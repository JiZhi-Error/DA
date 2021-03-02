package com.tencent.mm.plugin.festival.model;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.am;
import com.tencent.mm.plugin.festival.c.f;
import com.tencent.mm.plugin.festival.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l.k;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010\u0018\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u0010\u001d\u001a\u00020\u001e*\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r\u0018\u00010\u000f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalLiveCanvasDataProvider;", "Lcom/tencent/mm/plugin/festival/model/FestivalLiveCanvasDataProviderContract;", "()V", "CACHE_DIR", "", "getCACHE_DIR", "()Ljava/lang/String;", "CACHE_DIR_NAME", "EXPIRE_14_DAYS", "", "TAG", "canvasDataUpdatedListeners", "", "Lcom/tencent/mm/plugin/festival/model/FestivalLiveCanvasDataProviderContract$OnCanvasDataUpdateListener;", "kotlin.jvm.PlatformType", "", "configureExpiredStrategy", "", "debugClearCacheData", "getLatestCanvasData", "Lcom/tencent/mm/vfs/VFSFile;", "notifyCanvasDataUpdated", am.NAME, "url", "notifyNewDataUrl", "md5", "registerDataUpdateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterDataUpdateListener", "isChecksumValid", "", "ConfigStorage", "plugin-festival_release"})
public final class l implements m {
    private static final Set<m.a> Uyo = Collections.newSetFromMap(new ConcurrentHashMap());
    public static final l Uyp = new l();

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "errCode", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ o Uyu;
        final /* synthetic */ String hdx;
        final /* synthetic */ String mkH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(o oVar, String str, String str2) {
            super(1);
            this.Uyu = oVar;
            this.hdx = str;
            this.mkH = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(262999);
            if (num.intValue() == 0) {
                l lVar = l.Uyp;
                boolean i2 = l.i(this.Uyu, this.hdx);
                Log.i("MicroMsg.FestivalLiveCanvasDataProvider", "onDownloadComplete, checksumValid:" + i2 + ", url:" + this.mkH + ", md5:" + this.hdx);
                if (i2) {
                    l lVar2 = l.Uyp;
                    l.j(this.Uyu, this.mkH);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(262999);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(263007);
        AppMethodBeat.o(263007);
    }

    private l() {
    }

    public static final /* synthetic */ boolean i(o oVar, String str) {
        AppMethodBeat.i(263008);
        boolean h2 = h(oVar, str);
        AppMethodBeat.o(263008);
        return h2;
    }

    public static final /* synthetic */ void j(o oVar, String str) {
        AppMethodBeat.i(263009);
        g(oVar, str);
        AppMethodBeat.o(263009);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalLiveCanvasDataProvider$ConfigStorage;", "", "()V", "<set-?>", "", "LAST_CDN_URL", "getLAST_CDN_URL", "()Ljava/lang/String;", "setLAST_CDN_URL", "(Ljava/lang/String;)V", "LAST_CDN_URL$delegate", "Lcom/tencent/mm/plugin/festival/model/FestivalMmkvProperty;", "", "LATEST_CACHE_FILE_LAST_MODIFIED", "getLATEST_CACHE_FILE_LAST_MODIFIED", "()J", "setLATEST_CACHE_FILE_LAST_MODIFIED", "(J)V", "LATEST_CACHE_FILE_LAST_MODIFIED$delegate", "LATEST_CACHE_FILE_NAME", "getLATEST_CACHE_FILE_NAME", "setLATEST_CACHE_FILE_NAME", "LATEST_CACHE_FILE_NAME$delegate", "plugin-festival_release"})
    public static final class a {
        static final p Uyq = new p("", f.a.CanvasDataLatestCacheFileName);
        static final p Uyr = new p(Long.valueOf((long) MAlarmHandler.NEXT_FIRE_INTERVAL), f.a.CanvasDataLatestCacheFileLastModified);
        private static final p Uys = new p("", f.a.CanvasDataLastCdnUrl);
        public static final a Uyt = new a();
        static final /* synthetic */ k[] cLI = {aa.a(new v(aa.bp(a.class), "LATEST_CACHE_FILE_NAME", "getLATEST_CACHE_FILE_NAME()Ljava/lang/String;")), aa.a(new v(aa.bp(a.class), "LATEST_CACHE_FILE_LAST_MODIFIED", "getLATEST_CACHE_FILE_LAST_MODIFIED()J")), aa.a(new v(aa.bp(a.class), "LAST_CDN_URL", "getLAST_CDN_URL()Ljava/lang/String;"))};

        public final void RH(long j2) {
            AppMethodBeat.i(262996);
            Uyr.a(this, cLI[1], Long.valueOf(j2));
            AppMethodBeat.o(262996);
        }

        public final void bxu(String str) {
            AppMethodBeat.i(262995);
            p.h(str, "<set-?>");
            Uyq.a(this, cLI[0], str);
            AppMethodBeat.o(262995);
        }

        public final void bxv(String str) {
            AppMethodBeat.i(262998);
            p.h(str, "<set-?>");
            Uys.a(this, cLI[2], str);
            AppMethodBeat.o(262998);
        }

        public final String hbw() {
            AppMethodBeat.i(262997);
            String str = (String) Uys.a(this, cLI[2]);
            AppMethodBeat.o(262997);
            return str;
        }

        static {
            AppMethodBeat.i(262994);
            AppMethodBeat.o(262994);
        }

        private a() {
        }
    }

    public static String gWT() {
        AppMethodBeat.i(263000);
        String str = d.UxB + "festival_canvas_data";
        AppMethodBeat.o(263000);
        return str;
    }

    static void g(o oVar, String str) {
        AppMethodBeat.i(263001);
        a aVar = a.Uyt;
        String name = oVar.getName();
        p.g(name, "saveFile.name");
        aVar.bxu(name);
        a.Uyt.RH(Util.currentTicks());
        a.Uyt.bxv(str);
        Log.d("MicroMsg.FestivalLiveCanvasDataProvider", "notifyCanvasDataUpdated url:" + str + ", size:" + Uyo.size());
        for (m.a aVar2 : new HashSet(Uyo)) {
            aVar2.aq(oVar);
        }
        AppMethodBeat.o(263001);
    }

    static boolean h(o oVar, String str) {
        AppMethodBeat.i(263002);
        if (!oVar.exists() || !oVar.isFile()) {
            AppMethodBeat.o(263002);
            return false;
        }
        String str2 = str;
        if ((str2 == null || str2.length() == 0) || p.j(str, CdnLogic.calcFileMD5(s.k(oVar.getAbsolutePath(), false)))) {
            AppMethodBeat.o(263002);
            return true;
        }
        AppMethodBeat.o(263002);
        return false;
    }

    @Override // com.tencent.mm.plugin.festival.model.af
    public final void debugClearCacheData() {
        AppMethodBeat.i(263003);
        a.Uyt.bxv("");
        a.Uyt.bxu("");
        s.dy(gWT(), true);
        s.boN(gWT());
        AppMethodBeat.o(263003);
    }

    public static o gXc() {
        o oVar;
        AppMethodBeat.i(263004);
        o oVar2 = new o(gWT(), (String) a.Uyq.a(a.Uyt, a.cLI[0]));
        if (oVar2.exists()) {
            if (Util.currentTicks() - ((Number) a.Uyr.a(a.Uyt, a.cLI[1])).longValue() <= 10000) {
                oVar = oVar2;
                Log.d("MicroMsg.FestivalLiveCanvasDataProvider", "getLatestCanvasData ".concat(String.valueOf(oVar)));
                AppMethodBeat.o(263004);
                return oVar;
            }
        }
        a.Uyt.bxu("");
        a.Uyt.RH(MAlarmHandler.NEXT_FIRE_INTERVAL);
        oVar = null;
        Log.d("MicroMsg.FestivalLiveCanvasDataProvider", "getLatestCanvasData ".concat(String.valueOf(oVar)));
        AppMethodBeat.o(263004);
        return oVar;
    }

    public static void a(m.a aVar) {
        AppMethodBeat.i(263005);
        Uyo.add(aVar);
        AppMethodBeat.o(263005);
    }

    public static void b(m.a aVar) {
        AppMethodBeat.i(263006);
        Uyo.remove(aVar);
        AppMethodBeat.o(263006);
    }
}
