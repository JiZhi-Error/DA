package com.tencent.tavkit.composition.resource;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public class TAVEmptyResource extends TAVResource {
    private boolean insertTimeRange;

    public TAVEmptyResource(CMTime cMTime) {
        this(cMTime, true);
    }

    public TAVEmptyResource(CMTime cMTime, boolean z) {
        AppMethodBeat.i(197586);
        this.insertTimeRange = z;
        this.duration = cMTime;
        this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, cMTime);
        AppMethodBeat.o(197586);
    }

    public void setInsertTimeRange(boolean z) {
        this.insertTimeRange = z;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public TrackInfo trackInfoForType(int i2, int i3) {
        AppMethodBeat.i(197587);
        if (this.insertTimeRange) {
            TrackInfo trackInfoForType = super.trackInfoForType(i2, i3);
            AppMethodBeat.o(197587);
            return trackInfoForType;
        }
        AppMethodBeat.o(197587);
        return null;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource, com.tencent.tavkit.composition.resource.TAVResource, java.lang.Object
    public TAVResource clone() {
        AppMethodBeat.i(197588);
        TAVEmptyResource tAVEmptyResource = new TAVEmptyResource(this.duration.clone());
        tAVEmptyResource.sourceTimeRange = this.sourceTimeRange.clone();
        tAVEmptyResource.scaledDuration = this.scaledDuration.clone();
        AppMethodBeat.o(197588);
        return tAVEmptyResource;
    }
}
