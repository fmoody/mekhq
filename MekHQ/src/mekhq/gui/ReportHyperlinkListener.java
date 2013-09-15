/*
 * ReportHyperlinkListener.java
 * 
 * Copyright (c) 2009 Jay Lawson <jaylawson39 at yahoo.com>. All rights reserved.
 * 
 * This file is part of MekHQ.
 * 
 * MekHQ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MekHQ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MekHQ.  If not, see <http://www.gnu.org/licenses/>.
 */

package mekhq.gui;

import java.util.UUID;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;



public class ReportHyperlinkListener implements HyperlinkListener {

    public static final String UNIT = "UNIT";
    public static final String PERSON = "PERSON";

    private CampaignGUI campaignGUI;
  
    public ReportHyperlinkListener(CampaignGUI gui) {
        campaignGUI = gui;
    }
    
    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (HyperlinkEvent.EventType.ACTIVATED == e.getEventType()) {
            if(e.getDescription().startsWith(UNIT)) {
                UUID id = UUID.fromString(e.getDescription().split(":")[1]);
                campaignGUI.focusOnUnit(id);
            }
            else if(e.getDescription().startsWith(PERSON)) {
                UUID id = UUID.fromString(e.getDescription().split(":")[1]);
                campaignGUI.focusOnPerson(id);
            }
        }
    }

}
 