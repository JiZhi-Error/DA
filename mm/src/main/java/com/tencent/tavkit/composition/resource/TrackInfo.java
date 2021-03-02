package com.tencent.tavkit.composition.resource;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public class TrackInfo {
    private CompositionTrackSegment compositionTrackSegment;
    private CMTime scaleToDuration;
    private CMTimeRange selectedTimeRange;
    private AssetTrack track;

    public CMTime getScaleToDuration() {
        return this.scaleToDuration;
    }

    public AssetTrack getTrack() {
        return this.track;
    }

    public CMTimeRange getSelectedTimeRange() {
        return this.selectedTimeRange;
    }

    public void setTrack(AssetTrack assetTrack) {
        this.track = assetTrack;
    }

    public void setSelectedTimeRange(CMTimeRange cMTimeRange) {
        this.selectedTimeRange = cMTimeRange;
    }

    public void setScaleToDuration(CMTime cMTime) {
        this.scaleToDuration = cMTime;
    }

    public CompositionTrackSegment getCompositionTrackSegment(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(197600);
        CompositionTrackSegment compositionTrackSegment2 = new CompositionTrackSegment(this.compositionTrackSegment.getSourcePath(), this.compositionTrackSegment.getSourceTrackID(), this.compositionTrackSegment.getTimeMapping().getSource(), cMTimeRange, this.compositionTrackSegment.getSourceType());
        AppMethodBeat.o(197600);
        return compositionTrackSegment2;
    }

    public void setCompositionTrackSegment(CompositionTrackSegment compositionTrackSegment2) {
        this.compositionTrackSegment = compositionTrackSegment2;
    }

    public int getMediaType() {
        AppMethodBeat.i(197601);
        if (this.track != null) {
            int mediaType = this.track.getMediaType();
            AppMethodBeat.o(197601);
            return mediaType;
        } else if (this.compositionTrackSegment != null) {
            int sourceType = this.compositionTrackSegment.getSourceType();
            if (sourceType == 3) {
                sourceType = 1;
            }
            AppMethodBeat.o(197601);
            return sourceType;
        } else {
            AppMethodBeat.o(197601);
            return 0;
        }
    }
}
