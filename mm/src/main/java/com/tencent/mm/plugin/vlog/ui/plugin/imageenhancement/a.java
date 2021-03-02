package com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.e;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.k.g;
import kotlin.k.i;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0002Jd\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00042J\b\u0002\u0010\u0016\u001aD\u00128\u00126\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0018j\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b`\u0019\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever;", "", "()V", "isCancel", "", "cancel", "", "getImageLabel", "Landroid/util/Pair;", "", "", "path", "", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getTrackLabel", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getVideoLabel", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "isAllImage", "callback", "Lkotlin/Function1;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "plugin-vlog_release"})
public final class a {
    public static final C1869a GLn = new C1869a((byte) 0);
    private volatile boolean ifz;

    static {
        AppMethodBeat.i(191750);
        AppMethodBeat.o(191750);
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
        b(com.tencent.mm.plugin.xlabeffect.b bVar, z.d dVar, int[] iArr, ArrayList arrayList, Object obj) {
            super(2);
            this.GLo = bVar;
            this.GLp = dVar;
            this.GLq = iArr;
            this.GLr = arrayList;
            this.GLs = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
            AppMethodBeat.i(191746);
            long longValue = l.longValue();
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bitmap2.getByteCount());
                bitmap2.copyPixelsToBuffer(allocateDirect);
                allocateDirect.position(0);
                Log.d("MicroMsg.CompositionLabelRetriever", "start track image label:" + bitmap2 + ", size:[" + bitmap2.getWidth() + ", " + bitmap2.getHeight() + "], config:" + bitmap2.getConfig() + ", timeMs:" + longValue + ']');
                com.tencent.mm.plugin.xlabeffect.b bVar = this.GLo;
                p.g(allocateDirect, "bitmapBuffer");
                Log.d("MicroMsg.CompositionLabelRetriever", "trackImageLabel ret:".concat(String.valueOf(bVar.a(allocateDirect, bitmap2.getWidth(), bitmap2.getHeight()))));
                this.GLp.SYE++;
                if (this.GLp.SYE % 10 == 0) {
                    int glg = this.GLo.glg();
                    Log.d("MicroMsg.CompositionLabelRetriever", "getImageLabel: ".concat(String.valueOf(glg)));
                    if (glg >= 0) {
                        int[] iArr = this.GLq;
                        iArr[glg] = iArr[glg] + 1;
                    }
                }
                if (this.GLp.SYE >= this.GLr.size()) {
                    synchronized (this.GLs) {
                        try {
                            this.GLs.notifyAll();
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.CompositionLabelRetriever", e2, "", new Object[0]);
                        }
                        try {
                            x xVar = x.SXb;
                        } catch (Throwable th) {
                            AppMethodBeat.o(191746);
                            throw th;
                        }
                    }
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(191746);
            return xVar2;
        }
    }

    public static final /* synthetic */ Pair b(ad adVar, com.tencent.mm.plugin.xlabeffect.b bVar) {
        AppMethodBeat.i(191751);
        Pair<Integer, Long> a2 = a(adVar, bVar);
        AppMethodBeat.o(191751);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever$Companion;", "", "()V", "TAG", "", "maxTrackFrameCount", "", "thumbSize", "timeStep", "", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a$a  reason: collision with other inner class name */
    public static final class C1869a {
        private C1869a() {
        }

        public /* synthetic */ C1869a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ boolean GJS;
        final /* synthetic */ a GLt;
        final /* synthetic */ v GLu;
        final /* synthetic */ kotlin.g.a.b gWe;

        public c(a aVar, boolean z, v vVar, kotlin.g.a.b bVar) {
            this.GLt = aVar;
            this.GJS = z;
            this.GLu = vVar;
            this.gWe = bVar;
        }

        public final void run() {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(191747);
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.b aNa = c.a.aNa();
            if (p.j(aNa.ilv, EGL14.EGL_NO_CONTEXT)) {
                Log.e("MicroMsg.CompositionLabelRetriever", "create EGLContext failed");
                AppMethodBeat.o(191747);
            } else if (this.GLt.ifz) {
                Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
                AppMethodBeat.o(191747);
            } else {
                com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                com.tencent.mm.plugin.vlog.model.local.a.fBX();
                com.tencent.mm.plugin.xlabeffect.b bVar = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 0, true, false, 23);
                HashMap hashMap = new HashMap();
                com.tencent.mm.plugin.vlog.model.report.a aVar3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                com.tencent.mm.plugin.vlog.model.report.a.fCh();
                if (!this.GJS) {
                    for (T t : this.GLu.GxA.Gzn) {
                        if (this.GLt.ifz) {
                            Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
                        } else {
                            hashMap.put(t.path, a.b(t, bVar));
                        }
                    }
                } else {
                    for (T t2 : this.GLu.Gyv) {
                        if (this.GLt.ifz) {
                            Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
                        } else {
                            hashMap.put(t2, a.a((String) t2, bVar));
                        }
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
                Log.i("MicroMsg.CompositionLabelRetriever", "all track list label:" + hashMap + ", isCancel:" + this.GLt.ifz);
                if (this.GLt.ifz) {
                    hashMap.clear();
                }
                kotlin.g.a.b bVar2 = this.gWe;
                if (bVar2 != null) {
                    bVar2.invoke(hashMap);
                    AppMethodBeat.o(191747);
                    return;
                }
                AppMethodBeat.o(191747);
            }
        }
    }

    public final void cancel() {
        AppMethodBeat.i(191748);
        this.ifz = true;
        Log.i("MicroMsg.CompositionLabelRetriever", "cancel get label");
        AppMethodBeat.o(191748);
    }

    private static Pair<Integer, Long> a(ad adVar, com.tencent.mm.plugin.xlabeffect.b bVar) {
        int glg;
        AppMethodBeat.i(191749);
        long currentTicks = Util.currentTicks();
        Object obj = new Object();
        c.a aVar = com.tencent.mm.videocomposition.c.RgU;
        com.tencent.mm.videocomposition.c b2 = c.a.b(adVar.GzA);
        b2.setSize(100, 100);
        ArrayList arrayList = new ArrayList();
        g a2 = j.a((g) new i(0, adVar.getDurationMs()), 1000L);
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
        z.d dVar = new z.d();
        dVar.SYE = 0;
        int[] iArr = new int[13];
        b2.b(arrayList, new b(bVar, dVar, iArr, arrayList, obj));
        synchronized (obj) {
            try {
                obj.wait();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CompositionLabelRetriever", e2, "", new Object[0]);
            }
            try {
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(191749);
                throw th;
            }
        }
        if (dVar.SYE < 10 && (glg = bVar.glg()) >= 0) {
            iArr[glg] = iArr[glg] + 1;
        }
        Integer aa = e.aa(iArr);
        int n = e.n(iArr, aa != null ? aa.intValue() : -1);
        long ticksToNow = Util.ticksToNow(currentTicks);
        com.tencent.mm.plugin.vlog.model.report.a aVar2 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
        com.tencent.mm.plugin.vlog.model.report.a.KS(ticksToNow);
        StringBuilder append = new StringBuilder("getTrackLabel finish, cost:").append(ticksToNow).append(", trackFrameCount:").append(dVar.SYE).append(", videoLabelScore:");
        String arrays = Arrays.toString(iArr);
        p.g(arrays, "java.util.Arrays.toString(this)");
        Log.i("MicroMsg.CompositionLabelRetriever", append.append(arrays).append(", videoLabel:").append(n).toString());
        Pair<Integer, Long> pair = new Pair<>(Integer.valueOf(n), Long.valueOf(ticksToNow));
        AppMethodBeat.o(191749);
        return pair;
    }

    public static final /* synthetic */ Pair a(String str, com.tencent.mm.plugin.xlabeffect.b bVar) {
        AppMethodBeat.i(191752);
        if (s.YS(str)) {
            long currentTicks = Util.currentTicks();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            String k = s.k(str, false);
            BitmapFactory.decodeFile(k, options);
            options.inSampleSize = BitmapUtil.calculateInSampleSize(options.outWidth, options.outHeight, 200, 200);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(k, options);
            if (decodeFile == null) {
                Log.e("MicroMsg.CompositionLabelRetriever", "getImageLabel bitmap is null path:".concat(String.valueOf(k)));
                Pair pair = new Pair(-1, -1L);
                AppMethodBeat.o(191752);
                return pair;
            }
            Log.d("MicroMsg.CompositionLabelRetriever", "start track image label:" + decodeFile + ", size:[" + decodeFile.getWidth() + ", " + decodeFile.getHeight() + "], config:" + decodeFile.getConfig() + "], path:" + k);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(decodeFile.getByteCount());
            decodeFile.copyPixelsToBuffer(allocateDirect);
            allocateDirect.position(0);
            p.g(allocateDirect, "bitmapBuffer");
            int a2 = bVar.a(allocateDirect, decodeFile.getWidth(), decodeFile.getHeight());
            int glg = bVar.glg();
            Log.d("MicroMsg.CompositionLabelRetriever", "trackImageLabel ret:" + a2 + ", label:" + glg + ", cost:" + Util.ticksToNow(currentTicks));
            Pair pair2 = new Pair(Integer.valueOf(glg), Long.valueOf(Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(191752);
            return pair2;
        }
        Pair pair3 = new Pair(-1, -1L);
        AppMethodBeat.o(191752);
        return pair3;
    }
}
