package com.tencent.tav.asset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;

public class AssetTrackSegment {
    protected boolean empty;
    protected CMTime scaleDuration = CMTime.CMTimeZero;
    protected CMTimeMapping timeMapping;
    protected CMTimeRange timeRange;

    protected AssetTrackSegment() {
    }

    protected AssetTrackSegment(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        AppMethodBeat.i(217638);
        this.timeMapping = new CMTimeMapping(cMTimeRange, cMTimeRange2);
        this.scaleDuration = cMTimeRange2.getDuration().clone();
        this.timeRange = cMTimeRange2.clone();
        AppMethodBeat.o(217638);
    }

    public CMTimeMapping getTimeMapping() {
        return this.timeMapping;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public CMTime getScaleDuration() {
        return this.scaleDuration;
    }
}
