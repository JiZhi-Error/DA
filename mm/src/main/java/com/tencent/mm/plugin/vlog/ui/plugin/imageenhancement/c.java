package com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.ui.plugin.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.c;
import com.tencent.mm.videocomposition.d;
import com.tencent.mm.videocomposition.e;
import com.tencent.mm.videocomposition.n;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.k.g;
import kotlin.k.i;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002JZ\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102H\u0010\u0011\u001aD\u00128\u00126\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0013j\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006`\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/WXCompositionLabelRetriever;", "Lcom/tencent/mm/videocomposition/ICompositionLabelRetriever;", "()V", "isCancel", "", "getTrackLabel", "Landroid/util/Pair;", "", "", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/videocomposition/CompositionTrack;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getVideoLabel", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "callback", "Lkotlin/Function1;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isEnable", "Companion", "plugin-vlog_release"})
public final class c implements e {
    public static final a GLG = new a((byte) 0);
    private volatile boolean ifz;

    static {
        AppMethodBeat.i(191776);
        AppMethodBeat.o(191776);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
    public static final class b extends q implements m<Long, Bitmap, x> {
        final /* synthetic */ com.tencent.mm.plugin.xlabeffect.b GLo;
        final /* synthetic */ z.d GLp;
        final /* synthetic */ int[] GLq;
        final /* synthetic */ ArrayList GLr;
        final /* synthetic */ Object GLs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(com.tencent.mm.plugin.xlabeffect.b bVar, z.d dVar, int[] iArr, Object obj, ArrayList arrayList) {
            super(2);
            this.GLo = bVar;
            this.GLp = dVar;
            this.GLq = iArr;
            this.GLs = obj;
            this.GLr = arrayList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
            AppMethodBeat.i(191771);
            long longValue = l.longValue();
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bitmap2.getByteCount());
                bitmap2.copyPixelsToBuffer(allocateDirect);
                allocateDirect.position(0);
                Log.d("MicroMsg.WXCompositionLabelRetriever", "start track image label:" + bitmap2 + ", size:[" + bitmap2.getWidth() + ", " + bitmap2.getHeight() + "], config:" + bitmap2.getConfig() + ", timeMs:" + longValue + ']');
                com.tencent.mm.plugin.xlabeffect.b bVar = this.GLo;
                p.g(allocateDirect, "bitmapBuffer");
                Log.d("MicroMsg.WXCompositionLabelRetriever", "trackImageLabel ret:".concat(String.valueOf(bVar.a(allocateDirect, bitmap2.getWidth(), bitmap2.getHeight()))));
                this.GLp.SYE++;
                if (this.GLp.SYE % 10 == 0) {
                    int glg = this.GLo.glg();
                    Log.d("MicroMsg.WXCompositionLabelRetriever", "getImageLabel: ".concat(String.valueOf(glg)));
                    if (glg >= 0) {
                        int[] iArr = this.GLq;
                        iArr[glg] = iArr[glg] + 1;
                    }
                }
                synchronized (this.GLs) {
                    try {
                        if (this.GLp.SYE >= this.GLr.size()) {
                            try {
                                this.GLs.notifyAll();
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.WXCompositionLabelRetriever", e2, "", new Object[0]);
                            }
                        }
                        x xVar = x.SXb;
                    } catch (Throwable th) {
                        AppMethodBeat.o(191771);
                        throw th;
                    }
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(191771);
            return xVar2;
        }
    }

    public static final /* synthetic */ Pair b(d dVar, com.tencent.mm.plugin.xlabeffect.b bVar) {
        AppMethodBeat.i(191777);
        Pair<Integer, Long> a2 = a(dVar, bVar);
        AppMethodBeat.o(191777);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/WXCompositionLabelRetriever$Companion;", "", "()V", "TAG", "", "maxTrackFrameCount", "", "thumbSize", "timeStep", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static Pair<Integer, Long> a(d dVar, com.tencent.mm.plugin.xlabeffect.b bVar) {
        int glg;
        AppMethodBeat.i(191773);
        long currentTicks = Util.currentTicks();
        Object obj = new Object();
        c.a aVar = com.tencent.mm.videocomposition.c.RgU;
        com.tencent.mm.videocomposition.c b2 = c.a.b(dVar);
        b2.setSize(100, 100);
        ArrayList arrayList = new ArrayList();
        g a2 = j.a((g) new i(0, dVar.getDurationMs()), 1000L);
        long j2 = a2.first;
        long j3 = a2.SZc;
        long j4 = a2.BMh;
        if (j4 < 0 ? j2 >= j3 : j2 <= j3) {
            while (true) {
                arrayList.add(Long.valueOf(j2));
                if (arrayList.size() >= 10 || j2 == j3) {
                    break;
                }
                j2 += j4;
            }
        }
        z.d dVar2 = new z.d();
        dVar2.SYE = 0;
        int[] iArr = new int[13];
        b2.b(arrayList, new b(bVar, dVar2, iArr, obj, arrayList));
        synchronized (obj) {
            try {
                if (dVar2.SYE < arrayList.size()) {
                    obj.wait();
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WXCompositionLabelRetriever", e2, "", new Object[0]);
            }
            try {
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(191773);
                throw th;
            }
        }
        if (dVar2.SYE < 10 && (glg = bVar.glg()) >= 0) {
            iArr[glg] = iArr[glg] + 1;
        }
        Integer aa = kotlin.a.e.aa(iArr);
        int n = kotlin.a.e.n(iArr, aa != null ? aa.intValue() : -1);
        long ticksToNow = Util.ticksToNow(currentTicks);
        com.tencent.mm.plugin.vlog.model.report.a aVar2 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
        com.tencent.mm.plugin.vlog.model.report.a.KS(ticksToNow);
        StringBuilder append = new StringBuilder("getTrackLabel finish, cost:").append(ticksToNow).append(", trackFrameCount:").append(dVar2.SYE).append(", videoLabelScore:");
        String arrays = Arrays.toString(iArr);
        p.g(arrays, "java.util.Arrays.toString(this)");
        Log.i("MicroMsg.WXCompositionLabelRetriever", append.append(arrays).append(", videoLabel:").append(n).toString());
        Pair<Integer, Long> pair = new Pair<>(Integer.valueOf(n), Long.valueOf(ticksToNow));
        AppMethodBeat.o(191773);
        return pair;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.c$c  reason: collision with other inner class name */
    static final class RunnableC1870c implements Runnable {
        final /* synthetic */ c GLH;
        final /* synthetic */ n GLI;
        final /* synthetic */ kotlin.g.a.b gWe;

        RunnableC1870c(c cVar, n nVar, kotlin.g.a.b bVar) {
            this.GLH = cVar;
            this.GLI = nVar;
            this.gWe = bVar;
        }

        public final void run() {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(191772);
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.b aNa = c.a.aNa();
            if (p.j(aNa.ilv, EGL14.EGL_NO_CONTEXT)) {
                Log.e("MicroMsg.WXCompositionLabelRetriever", "create EGLContext failed");
                AppMethodBeat.o(191772);
            } else if (this.GLH.ifz) {
                Log.i("MicroMsg.WXCompositionLabelRetriever", "getVideoLabel cancel!");
                AppMethodBeat.o(191772);
            } else {
                com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                com.tencent.mm.plugin.vlog.model.local.a.fBX();
                com.tencent.mm.plugin.xlabeffect.b bVar = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 0, true, false, 23);
                HashMap hashMap = new HashMap();
                com.tencent.mm.plugin.vlog.model.report.a aVar3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                com.tencent.mm.plugin.vlog.model.report.a.fCh();
                for (T t : this.GLI.Gzn) {
                    if (this.GLH.ifz) {
                        Log.i("MicroMsg.WXCompositionLabelRetriever", "getVideoLabel cancel!");
                    } else {
                        hashMap.put(t.path, c.b(t, bVar));
                    }
                }
                HashMap hashMap2 = hashMap;
                if (!hashMap2.isEmpty()) {
                    Iterator it = hashMap2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (p.compare(((Number) ((Pair) ((Map.Entry) it.next()).getValue()).first).intValue(), 0) < 0) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    com.tencent.mm.plugin.vlog.model.report.a aVar4 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                    com.tencent.mm.plugin.vlog.model.report.a.fCj();
                } else {
                    com.tencent.mm.plugin.vlog.model.report.a aVar5 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                    com.tencent.mm.plugin.vlog.model.report.a.fCi();
                }
                bVar.destroy();
                if (!p.j(aNa.eglSurface, EGL14.EGL_NO_SURFACE)) {
                    EGL14.eglDestroySurface(aNa.ilu, aNa.eglSurface);
                }
                EGL14.eglDestroyContext(aNa.ilu, aNa.ilv);
                Log.i("MicroMsg.WXCompositionLabelRetriever", "all track list label:" + hashMap + ", isCancel:" + this.GLH.ifz);
                if (this.GLH.ifz) {
                    hashMap.clear();
                }
                kotlin.g.a.b bVar2 = this.gWe;
                if (bVar2 != null) {
                    bVar2.invoke(hashMap);
                    AppMethodBeat.o(191772);
                    return;
                }
                AppMethodBeat.o(191772);
            }
        }
    }

    @Override // com.tencent.mm.videocomposition.e
    public final void a(n nVar, kotlin.g.a.b<? super HashMap<String, Pair<Integer, Long>>, x> bVar) {
        AppMethodBeat.i(191774);
        p.h(nVar, "composition");
        h.RTc.aX(new RunnableC1870c(this, nVar, bVar));
        AppMethodBeat.o(191774);
    }

    @Override // com.tencent.mm.videocomposition.e
    public final boolean isEnable() {
        AppMethodBeat.i(191775);
        aj.a aVar = aj.GJP;
        boolean isEnable = aj.a.isEnable();
        AppMethodBeat.o(191775);
        return isEnable;
    }
}
