// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2018
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.framework.daw.bitwig.data;

import de.mossgrabers.framework.daw.data.ISlot;

import com.bitwig.extension.controller.api.ClipLauncherSlot;
import com.bitwig.extension.controller.api.ColorValue;


/**
 * Encapsulates the data of a slot.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class SlotImpl implements ISlot
{
    private final int              index;
    private final ClipLauncherSlot slot;


    /**
     * Constructor.
     *
     * @param slot The slot
     * @param index The index of the slot
     */
    public SlotImpl (final ClipLauncherSlot slot, final int index)
    {
        this.index = index;
        this.slot = slot;

        slot.exists ().markInterested ();
        slot.name ().markInterested ();
        slot.hasContent ().markInterested ();
        slot.color ().markInterested ();

        // States
        slot.isPlaying ().markInterested ();
        slot.isPlaybackQueued ().markInterested ();
        slot.isRecording ().markInterested ();
        slot.isRecordingQueued ().markInterested ();
        slot.isSelected ().markInterested ();
        slot.isStopQueued ().markInterested ();
    }


    /** {@inheritDoc} */
    @Override
    public void enableObservers (final boolean enable)
    {
        this.slot.exists ().setIsSubscribed (enable);
        this.slot.name ().setIsSubscribed (enable);
        this.slot.hasContent ().setIsSubscribed (enable);
        this.slot.color ().setIsSubscribed (enable);
        this.slot.isPlaying ().setIsSubscribed (enable);
        this.slot.isPlaybackQueued ().setIsSubscribed (enable);
        this.slot.isRecording ().setIsSubscribed (enable);
        this.slot.isRecordingQueued ().setIsSubscribed (enable);
        this.slot.isSelected ().setIsSubscribed (enable);
        this.slot.isStopQueued ().setIsSubscribed (enable);
    }


    /** {@inheritDoc} */
    @Override
    public int getIndex ()
    {
        return this.index;
    }


    /** {@inheritDoc} */
    @Override
    public boolean doesExist ()
    {
        return this.slot.exists ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public String getName ()
    {
        return this.slot.name ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public String getName (final int limit)
    {
        return this.slot.name ().getLimited (limit);
    }


    /** {@inheritDoc} */
    @Override
    public boolean isSelected ()
    {
        return this.slot.isSelected ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean hasContent ()
    {
        return this.slot.hasContent ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean isRecording ()
    {
        return this.slot.isRecording ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean isPlaying ()
    {
        return this.slot.isPlaying ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean isPlayingQueued ()
    {
        return this.slot.isPlaybackQueued ().get () || this.slot.isRecordingQueued ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean isRecordingQueued ()
    {
        return this.slot.isRecordingQueued ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public double [] getColor ()
    {
        final ColorValue color = this.slot.color ();
        return new double []
        {
            color.red (),
            color.green (),
            color.blue ()
        };
    }


    /** {@inheritDoc} */
    @Override
    public void setColor (final double red, final double green, final double blue)
    {
        // TODO API extension required - We need a setter
        // this.slot.color ().set ((float) red, (float) green, (float) blue);
    }
}
