package com.tencent.tav.asset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class CompositionTrack extends AssetTrack<CompositionTrackSegment> {
    protected List<CompositionTrackSegment> segments = new ArrayList();

    CompositionTrack() {
        AppMethodBeat.i(217647);
        AppMethodBeat.o(217647);
    }

    CompositionTrack(Asset asset, int i2, int i3, CMTimeRange cMTimeRange) {
        super(asset, i2, i3, cMTimeRange);
        AppMethodBeat.i(217648);
        AppMethodBeat.o(217648);
    }

    @Override // com.tencent.tav.asset.AssetTrack
    public CompositionTrackSegment segmentForTrackTime(CMTime cMTime) {
        CMTimeRange target;
        AppMethodBeat.i(217649);
        if (this.segments != null) {
            for (CompositionTrackSegment compositionTrackSegment : this.segments) {
                if (compositionTrackSegment != null && (target = compositionTrackSegment.getTimeMapping().getTarget()) != null && target.containsTime(cMTime) && (compositionTrackSegment instanceof CompositionTrackSegment)) {
                    CompositionTrackSegment compositionTrackSegment2 = compositionTrackSegment;
                    AppMethodBeat.o(217649);
                    return compositionTrackSegment2;
                }
            }
        }
        AppMethodBeat.o(217649);
        return null;
    }

    @Override // com.tencent.tav.asset.AssetTrack
    public List<CompositionTrackSegment> getSegments() {
        return this.segments;
    }

    public String toString() {
        AppMethodBeat.i(217650);
        String str = "CompositionTrack{segments=" + this.segments + ", trackID=" + this.trackID + ", mediaType=" + this.mediaType + '}';
        AppMethodBeat.o(217650);
        return str;
    }
}
