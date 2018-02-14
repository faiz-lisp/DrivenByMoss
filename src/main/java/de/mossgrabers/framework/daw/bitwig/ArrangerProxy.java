// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2018
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.framework.daw.bitwig;

import de.mossgrabers.framework.daw.IArranger;

import com.bitwig.extension.controller.api.Arranger;


/**
 * Encapsulates the Arranger instance.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class ArrangerProxy implements IArranger
{
    private Arranger arranger;


    /**
     * Constructor
     *
     * @param arranger The arranger
     */
    public ArrangerProxy (final Arranger arranger)
    {
        this.arranger = arranger;

        this.arranger.areCueMarkersVisible ().markInterested ();
        this.arranger.isPlaybackFollowEnabled ().markInterested ();
        this.arranger.hasDoubleRowTrackHeight ().markInterested ();
        this.arranger.isClipLauncherVisible ().markInterested ();
        this.arranger.isTimelineVisible ().markInterested ();
        this.arranger.isIoSectionVisible ().markInterested ();
        this.arranger.areEffectTracksVisible ().markInterested ();
    }


    /** {@inheritDoc} */
    @Override
    public void enableObservers (final boolean enable)
    {
        this.arranger.areCueMarkersVisible ().setIsSubscribed (enable);
        this.arranger.isPlaybackFollowEnabled ().setIsSubscribed (enable);
        this.arranger.hasDoubleRowTrackHeight ().setIsSubscribed (enable);
        this.arranger.isClipLauncherVisible ().setIsSubscribed (enable);
        this.arranger.isTimelineVisible ().setIsSubscribed (enable);
        this.arranger.isIoSectionVisible ().setIsSubscribed (enable);
        this.arranger.areEffectTracksVisible ().setIsSubscribed (enable);
    }


    /** {@inheritDoc} */
    @Override
    public boolean areCueMarkersVisible ()
    {
        return this.arranger.areCueMarkersVisible ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public void toggleCueMarkerVisibility ()
    {
        this.arranger.areCueMarkersVisible ().toggle ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean isPlaybackFollowEnabled ()
    {
        return this.arranger.isPlaybackFollowEnabled ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public void togglePlaybackFollow ()
    {
        this.arranger.isPlaybackFollowEnabled ().toggle ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean hasDoubleRowTrackHeight ()
    {
        return this.arranger.hasDoubleRowTrackHeight ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public void toggleTrackRowHeight ()
    {
        this.arranger.hasDoubleRowTrackHeight ().toggle ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean isClipLauncherVisible ()
    {
        return this.arranger.isClipLauncherVisible ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public void toggleClipLauncher ()
    {
        this.arranger.isClipLauncherVisible ().toggle ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean isTimelineVisible ()
    {
        return this.arranger.isTimelineVisible ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public void toggleTimeLine ()
    {
        this.arranger.isTimelineVisible ().toggle ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean isIoSectionVisible ()
    {
        return this.arranger.isIoSectionVisible ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public void toggleIoSection ()
    {
        this.arranger.isIoSectionVisible ().toggle ();
    }


    /** {@inheritDoc} */
    @Override
    public boolean areEffectTracksVisible ()
    {
        return this.arranger.areEffectTracksVisible ().get ();
    }


    /** {@inheritDoc} */
    @Override
    public void toggleEffectTracks ()
    {
        this.arranger.areEffectTracksVisible ().toggle ();
    }
}