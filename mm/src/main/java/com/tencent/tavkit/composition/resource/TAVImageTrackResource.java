package com.tencent.tavkit.composition.resource;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;

public class TAVImageTrackResource extends TAVResource {
    private boolean emptyAudioTrack;
    private String path;

    public String getPath() {
        return this.path;
    }

    public TAVImageTrackResource(String str, CMTime cMTime) {
        this(str, cMTime, true);
    }

    public TAVImageTrackResource(String str, CMTime cMTime, boolean z) {
        AppMethodBeat.i(197595);
        this.path = str;
        this.emptyAudioTrack = z;
        this.duration = cMTime;
        this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, cMTime);
        AppMethodBeat.o(197595);
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public TrackInfo trackInfoForType(int i2, int i3) {
        AppMethodBeat.i(197596);
        if (i2 == 1 || this.emptyAudioTrack) {
            CompositionTrackSegment compositionTrackSegment = new CompositionTrackSegment(this.path, 0, this.sourceTimeRange, this.sourceTimeRange, i2 == 1 ? 3 : i2);
            TrackInfo trackInfo = new TrackInfo();
            trackInfo.setCompositionTrackSegment(compositionTrackSegment);
            trackInfo.setSelectedTimeRange(getSourceTimeRange());
            trackInfo.setScaleToDuration(getScaledDuration());
            AppMethodBeat.o(197596);
            return trackInfo;
        }
        AppMethodBeat.o(197596);
        return null;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public CIImage imageAtTime(CMTime cMTime, CGSize cGSize) {
        return null;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource, com.tencent.tavkit.composition.resource.TAVResource, java.lang.Object
    public TAVImageTrackResource clone() {
        AppMethodBeat.i(197597);
        TAVImageTrackResource tAVImageTrackResource = new TAVImageTrackResource(this.path, this.duration.clone());
        tAVImageTrackResource.sourceTimeRange = this.sourceTimeRange.clone();
        tAVImageTrackResource.scaledDuration = this.scaledDuration.clone();
        AppMethodBeat.o(197597);
        return tAVImageTrackResource;
    }
}
