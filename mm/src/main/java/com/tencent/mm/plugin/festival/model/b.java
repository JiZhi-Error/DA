package com.tencent.mm.plugin.festival.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.am;
import com.tencent.mm.plugin.festival.b.e;
import com.tencent.mm.plugin.festival.c.c;
import com.tencent.mm.plugin.festival.c.d;
import com.tencent.mm.plugin.festival.model.z;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b0\nJ\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0000X\u0004¢\u0006\u0002\n\u0000RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n0\tj\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n`\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalCanvasDataCdnDownloader;", "Lcom/tencent/mm/plugin/festival/model/FestivalWishConfigProvider$OnConfigUpdatedListener;", "()V", "DOWNLOAD_TIMEOUT", "", "TAG", "", "THIS", "callbackMap", "Ljava/util/HashMap;", "Lkotlin/Function1;", "", "Lkotlin/collections/HashMap;", "orderGenerator", "Ljava/util/concurrent/atomic/AtomicInteger;", "orderMap", "Landroid/util/SparseArray;", "enqueueTask", "url", am.NAME, "Lcom/tencent/mm/vfs/VFSFile;", "callback", "Lkotlin/ParameterName;", "name", "errCode", "onConfigUpdated", "config", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;", "tryNotifyResult", "plugin-festival_release"})
public final class b implements z.a {
    private static int Uxv = Math.max(0, z.Uzb.hRC().UAC);
    private static final b Uxw;
    private static final AtomicInteger Uxx = new AtomicInteger(0);
    private static final SparseArray<String> Uxy = new SparseArray<>();
    public static final b Uxz;
    private static final HashMap<String, kotlin.g.a.b<Integer, x>> hdu = new HashMap<>();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "errCode", "", "invoke", "com/tencent/mm/plugin/festival/model/FestivalCanvasDataCdnDownloader$enqueueTask$2$1"})
    public static final class a extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ long ipR;
        final /* synthetic */ String pFh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(long j2, String str) {
            super(1);
            this.ipR = j2;
            this.pFh = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(262891);
            int intValue = num.intValue();
            Log.i("MicroMsg.FestivalCanvasDataCdnDownloader", "download url:" + this.pFh + ", cost:" + (Util.currentTicks() - this.ipR) + LocaleUtil.MALAY);
            b bVar = b.Uxz;
            b.m19if(this.pFh, intValue);
            x xVar = x.SXb;
            AppMethodBeat.o(262891);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(262894);
        b bVar = new b();
        Uxz = bVar;
        z zVar = z.Uzb;
        z.a(bVar);
        Uxw = bVar;
        AppMethodBeat.o(262894);
    }

    private b() {
    }

    @Override // com.tencent.mm.plugin.festival.model.z.a
    public final void a(e eVar) {
        AppMethodBeat.i(262892);
        p.h(eVar, "config");
        Uxv = Math.max(0, eVar.UAC);
        AppMethodBeat.o(262892);
    }

    public static void a(String str, o oVar, kotlin.g.a.b<? super Integer, x> bVar) {
        boolean z;
        AppMethodBeat.i(262893);
        p.h(str, "url");
        p.h(oVar, am.NAME);
        p.h(bVar, "callback");
        synchronized (Uxw) {
            try {
                if (Uxy.indexOfValue(str) < 0) {
                    Uxy.put(Uxx.getAndIncrement(), str);
                }
                z = hdu.put(str, bVar) != null;
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(262893);
                throw th;
            }
        }
        Log.d("MicroMsg.FestivalCanvasDataCdnDownloader", "enqueueTask url:" + str + ", hasEnqueued:" + z);
        if (z) {
            AppMethodBeat.o(262893);
            return;
        }
        d dVar = new d(c.Canvas, str, (long) Uxv, (long) Uxv, s.k(oVar.getAbsolutePath(), true));
        Log.i("MicroMsg.FestivalCanvasDataCdnDownloader", "startHttpsDownload url:".concat(String.valueOf(str)));
        long currentTicks = Util.currentTicks();
        com.tencent.mm.plugin.festival.c.b bVar2 = com.tencent.mm.plugin.festival.c.b.UGa;
        com.tencent.mm.plugin.festival.c.b.a(dVar, new a(currentTicks, str));
        AppMethodBeat.o(262893);
    }

    /* renamed from: if  reason: not valid java name */
    public static final /* synthetic */ void m19if(String str, int i2) {
        kotlin.g.a.b<Integer, x> bVar;
        AppMethodBeat.i(262895);
        synchronized (Uxw) {
            try {
                int indexOfValue = Uxy.indexOfValue(str);
                if (indexOfValue >= 0) {
                    bVar = hdu.remove(str);
                    Uxy.removeAtRange(0, Math.min(indexOfValue + 1, Uxy.size()));
                } else {
                    bVar = null;
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(262895);
                throw th;
            }
        }
        Log.i("MicroMsg.FestivalCanvasDataCdnDownloader", "tryNotifyResult url:".concat(String.valueOf(str)));
        if (bVar != null) {
            bVar.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(262895);
            return;
        }
        AppMethodBeat.o(262895);
    }
}
