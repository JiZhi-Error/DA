package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.b;
import java.util.concurrent.Callable;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/audio/GetVideoRecommendAudioTask;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "videoPath", "", "startTime", "", "endTime", "scene", "", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;JJI)V", "getEndTime", "()J", "fetcher", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher;", "frameInterval", "getStartTime", "thumbFetcherPool", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher$FetcherPool;", "getVideoPath", "()Ljava/lang/String;", "nextBitmap", "Landroid/graphics/Bitmap;", FirebaseAnalytics.b.INDEX, "onFinishImageData", "", "onPrepareImageData", "plugin-recordvideo_release"})
public final class h extends a {
    int BPE = 1000;
    private d.a BPF;
    private d BPG;
    private final long endTime;
    private final long startTime;
    final String videoPath;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(b<com.tencent.mm.vending.e.a> bVar, String str, long j2, long j3, int i2) {
        super(bVar);
        p.h(bVar, "lifeCycleKeeper");
        p.h(str, "videoPath");
        AppMethodBeat.i(75431);
        this.videoPath = str;
        this.startTime = j2;
        this.endTime = j3;
        this.scene = i2;
        AppMethodBeat.o(75431);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ce A[Catch:{ Exception -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d8 A[Catch:{ Exception -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    @Override // com.tencent.mm.plugin.recordvideo.model.audio.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eJR() {
        /*
        // Method dump skipped, instructions count: 289
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.model.audio.h.eJR():void");
    }

    @Override // com.tencent.mm.plugin.recordvideo.model.audio.a
    public final void eJS() {
        AppMethodBeat.i(75430);
        d.a aVar = this.BPF;
        if (aVar != null) {
            aVar.a(this.BPG);
        }
        d.a aVar2 = this.BPF;
        if (aVar2 != null) {
            aVar2.destroy();
            AppMethodBeat.o(75430);
            return;
        }
        AppMethodBeat.o(75430);
    }

    @Override // com.tencent.mm.plugin.recordvideo.model.audio.a
    public final Bitmap VB(int i2) {
        AppMethodBeat.i(75428);
        Log.i(this.TAG, "nextBitmap:" + this.BOS[i2]);
        d dVar = this.BPG;
        Bitmap frameAtTime = dVar != null ? dVar.getFrameAtTime((long) this.BOS[i2]) : null;
        if (frameAtTime == null) {
            Bitmap createBitmap = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
            p.g(createBitmap, "Bitmap.createBitmap(thum… Bitmap.Config.ARGB_8888)");
            AppMethodBeat.o(75428);
            return createBitmap;
        }
        AppMethodBeat.o(75428);
        return frameAtTime;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher;", "kotlin.jvm.PlatformType", "call"})
    static final class a<V> implements Callable<d> {
        final /* synthetic */ h BPH;

        a(h hVar) {
            this.BPH = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public final /* synthetic */ d call() {
            AppMethodBeat.i(75427);
            d m = n.m(this.BPH.videoPath, this.BPH.BPE, this.BPH.thumbWidth, this.BPH.thumbHeight);
            AppMethodBeat.o(75427);
            return m;
        }
    }
}
