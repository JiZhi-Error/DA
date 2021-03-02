package com.tencent.tavkit.composition.resource;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.HashMap;

public class TAVImageResource extends TAVResource {
    private HashMap<Thread, CIImage> ciImageHashMap;
    private boolean emptyAudioTrack;
    private CIImage image;

    public TAVImageResource(CIImage cIImage, CMTime cMTime) {
        this(cIImage, cMTime, false);
    }

    public TAVImageResource(CIImage cIImage, CMTime cMTime, boolean z) {
        AppMethodBeat.i(197590);
        this.ciImageHashMap = new HashMap<>();
        this.image = cIImage;
        this.duration = cMTime;
        this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, cMTime);
        this.emptyAudioTrack = z;
        AppMethodBeat.o(197590);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    @Override // com.tencent.tavkit.composition.resource.TAVResource
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.tavkit.ciimage.CIImage imageAtTime(com.tencent.tav.coremedia.CMTime r5, com.tencent.tav.coremedia.CGSize r6) {
        /*
            r4 = this;
            r0 = 0
            r3 = 197591(0x303d7, float:2.76884E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.tav.coremedia.CMTime r1 = r4.scaledDuration
            com.tencent.tav.coremedia.CMTime r2 = com.tencent.tav.coremedia.CMTime.CMTimeZero
            boolean r1 = r1.bigThan(r2)
            if (r1 == 0) goto L_0x0025
            com.tencent.tav.coremedia.CMTime r1 = com.tencent.tav.coremedia.CMTime.CMTimeZero
            boolean r1 = r5.smallThan(r1)
            if (r1 != 0) goto L_0x0021
            com.tencent.tav.coremedia.CMTime r1 = r4.scaledDuration
            boolean r1 = r5.bigThan(r1)
            if (r1 == 0) goto L_0x0031
        L_0x0021:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0024:
            return r0
        L_0x0025:
            com.tencent.tav.coremedia.CMTimeRange r1 = r4.sourceTimeRange
            boolean r1 = r1.containsTime(r5)
            if (r1 != 0) goto L_0x0031
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0024
        L_0x0031:
            com.tencent.tavkit.ciimage.CIImage r1 = r4.image
            if (r1 != 0) goto L_0x0039
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0024
        L_0x0039:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.util.HashMap<java.lang.Thread, com.tencent.tavkit.ciimage.CIImage> r0 = r4.ciImageHashMap
            java.lang.Object r0 = r0.get(r1)
            com.tencent.tavkit.ciimage.CIImage r0 = (com.tencent.tavkit.ciimage.CIImage) r0
            if (r0 != 0) goto L_0x0052
            com.tencent.tavkit.ciimage.CIImage r0 = r4.image
            com.tencent.tavkit.ciimage.CIImage r0 = r0.simpleClone()
            java.util.HashMap<java.lang.Thread, com.tencent.tavkit.ciimage.CIImage> r2 = r4.ciImageHashMap
            r2.put(r1, r0)
        L_0x0052:
            r0.reset()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tavkit.composition.resource.TAVImageResource.imageAtTime(com.tencent.tav.coremedia.CMTime, com.tencent.tav.coremedia.CGSize):com.tencent.tavkit.ciimage.CIImage");
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public TrackInfo trackInfoForType(int i2, int i3) {
        AppMethodBeat.i(197592);
        if (i2 == 1) {
            TrackInfo newEmptyTrackInfo = newEmptyTrackInfo(i2, i3);
            AppMethodBeat.o(197592);
            return newEmptyTrackInfo;
        } else if (!this.emptyAudioTrack || i2 != 2) {
            AppMethodBeat.o(197592);
            return null;
        } else {
            TrackInfo newEmptyTrackInfo2 = newEmptyTrackInfo(i2, i3);
            AppMethodBeat.o(197592);
            return newEmptyTrackInfo2;
        }
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource, com.tencent.tavkit.composition.resource.TAVResource, java.lang.Object
    public TAVResource clone() {
        AppMethodBeat.i(197593);
        TAVImageResource tAVImageResource = new TAVImageResource(this.image, this.duration.clone(), this.emptyAudioTrack);
        tAVImageResource.sourceTimeRange = this.sourceTimeRange.clone();
        tAVImageResource.scaledDuration = this.scaledDuration.clone();
        tAVImageResource.ciImageHashMap = this.ciImageHashMap;
        AppMethodBeat.o(197593);
        return tAVImageResource;
    }
}
