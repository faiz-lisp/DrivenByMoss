// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2018
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.apcmini.command.trigger;

import de.mossgrabers.apc.APCConfiguration;
import de.mossgrabers.apc.controller.APCControlSurface;
import de.mossgrabers.framework.ButtonEvent;
import de.mossgrabers.framework.command.core.AbstractTriggerCommand;
import de.mossgrabers.framework.daw.IModel;


/**
 * A solo button command.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class SoloCommand extends AbstractTriggerCommand<APCControlSurface, APCConfiguration>
{
    private int index;


    /**
     * Constructor.
     *
     * @param index The channel index
     * @param model The model
     * @param surface The surface
     */
    public SoloCommand (final int index, final IModel model, final APCControlSurface surface)
    {
        super (model, surface);
        this.index = index;
    }


    /** {@inheritDoc} */
    @Override
    public void executeNormal (final ButtonEvent event)
    {
        if (event == ButtonEvent.DOWN)
            this.model.getCurrentTrackBank ().toggleSolo (this.index);
    }


    /** {@inheritDoc} */
    @Override
    public void executeShifted (final ButtonEvent event)
    {
        if (event == ButtonEvent.DOWN)
            this.model.getCurrentTrackBank ().toggleAutoMonitor (this.index);
    }
}
