package com.tencent.tavkit.composition.resource;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\u0001H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/tavkit/composition/resource/TAVLoopImageResource;", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "images", "", "Lcom/tencent/tavkit/ciimage/CIImage;", "interval", "Lcom/tencent/tav/coremedia/CMTime;", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "(Ljava/util/List;Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V", "ciImageHashMap", "Ljava/lang/ThreadLocal;", "Landroid/util/SparseArray;", "clone", "imageAtTime", "time", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "tavkit_release"})
public final class TAVLoopImageResource extends TAVResource {
    private final ThreadLocal<SparseArray<CIImage>> ciImageHashMap;
    private final List<CIImage> images;
    private final CMTime interval;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.tencent.tavkit.ciimage.CIImage> */
    /* JADX WARN: Multi-variable type inference failed */
    public TAVLoopImageResource(List<? extends CIImage> list, CMTime cMTime, CMTime cMTime2) {
        p.h(list, "images");
        p.h(cMTime, "interval");
        p.h(cMTime2, FFmpegMetadataRetriever.METADATA_KEY_DURATION);
        AppMethodBeat.i(197695);
        this.images = list;
        this.interval = cMTime;
        this.ciImageHashMap = new ThreadLocal<>();
        setDuration(cMTime2);
        setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, cMTime2));
        AppMethodBeat.o(197695);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TAVLoopImageResource(java.util.List r6, com.tencent.tav.coremedia.CMTime r7, com.tencent.tav.coremedia.CMTime r8, int r9, kotlin.g.b.j r10) {
        /*
            r5 = this;
            r4 = 197696(0x30440, float:2.77031E-40)
            r0 = r9 & 4
            if (r0 == 0) goto L_0x001b
            int r0 = r6.size()
            long r0 = (long) r0
            long r2 = r7.getTimeUs()
            long r0 = r0 * r2
            com.tencent.tav.coremedia.CMTime r8 = com.tencent.tav.coremedia.CMTime.fromUs(r0)
            java.lang.String r0 = "CMTime.fromUs(images.size * interval.timeUs)"
            kotlin.g.b.p.g(r8, r0)
        L_0x001b:
            r5.<init>(r6, r7, r8)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tavkit.composition.resource.TAVLoopImageResource.<init>(java.util.List, com.tencent.tav.coremedia.CMTime, com.tencent.tav.coremedia.CMTime, int, kotlin.g.b.j):void");
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource, com.tencent.tavkit.composition.resource.TAVResource, java.lang.Object
    public final TAVResource clone() {
        AppMethodBeat.i(197692);
        List<CIImage> list = this.images;
        CMTime cMTime = this.interval;
        CMTime cMTime2 = this.duration;
        p.g(cMTime2, FFmpegMetadataRetriever.METADATA_KEY_DURATION);
        TAVLoopImageResource tAVLoopImageResource = new TAVLoopImageResource(list, cMTime, cMTime2);
        AppMethodBeat.o(197692);
        return tAVLoopImageResource;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public final CIImage imageAtTime(CMTime cMTime, CGSize cGSize) {
        AppMethodBeat.i(197694);
        p.h(cMTime, "time");
        p.h(cGSize, "renderSize");
        if (!this.sourceTimeRange.containsTime(cMTime)) {
            AppMethodBeat.o(197694);
            return null;
        } else if (this.images.isEmpty()) {
            AppMethodBeat.o(197694);
            return null;
        } else {
            ThreadLocal<SparseArray<CIImage>> threadLocal = this.ciImageHashMap;
            SparseArray<CIImage> sparseArray = threadLocal.get();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                threadLocal.set(sparseArray);
            }
            SparseArray<CIImage> sparseArray2 = sparseArray;
            int timeUs = (int) ((cMTime.getTimeUs() / this.interval.getTimeUs()) % ((long) this.images.size()));
            CIImage cIImage = sparseArray2.get(timeUs);
            if (cIImage != null) {
                cIImage.reset();
                AppMethodBeat.o(197694);
                return cIImage;
            }
            sparseArray2.put(timeUs, this.images.get(timeUs).clone());
            CIImage cIImage2 = sparseArray2.get(timeUs);
            AppMethodBeat.o(197694);
            return cIImage2;
        }
    }
}
