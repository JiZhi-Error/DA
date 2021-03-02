package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/AppBrandFileCleaner;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class g {
    public static final a kzC = new a((byte) 0);

    static {
        AppMethodBeat.i(227885);
        AppMethodBeat.o(227885);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/AppBrandFileCleaner$Companion;", "", "()V", "IDKEY_CLEAN_APPBRAND_FILE", "", "TAG", "", "clean", "", "cleanImpl", "uinStr", "appId", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final void clean() {
        AppMethodBeat.i(227886);
        a aVar = kzC;
        long currentTicks = Util.currentTicks();
        Object W = n.W(k.class);
        p.g(W, "SubCoreAppBrand.getStora…icateStorage::class.java)");
        List<String> bxT = ((k) W).bxT();
        List<String> bWa = h.bWa();
        p.g(bWa, "aliveTaskAppId");
        bxT.removeAll(bWa);
        p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        String ayV = com.tencent.mm.kernel.a.ayV();
        String str = ayV;
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppBrandFileCleaner", "uin value is invaild");
            AppMethodBeat.o(227886);
            return;
        }
        for (String str2 : bxT) {
            p.g(str2, "appId");
            try {
                o oVar = new o(at.bGo() + str2 + FilePathGenerator.ANDROID_DIR_SEP);
                com.tencent.mm.plugin.appbrand.appstorage.n.t(oVar);
                if (oVar.exists()) {
                    oVar.delete();
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandFileCleaner", "clean Flatten appId=%s e=%s", str2, e2);
            }
            try {
                at.dt(ayV, str2).bxq();
            } catch (Exception e3) {
                Log.e("MicroMsg.AppBrandFileCleaner", "clean NonFlatten appId=%s e=%s", str2, e3);
            }
            try {
                at.dw(ayV, str2).bxq();
            } catch (Exception e4) {
                Log.e("MicroMsg.AppBrandFileCleaner", "clean SinglePageNotFlatten appId=%s e=%s", str2, e4);
            }
            try {
                o oVar2 = new o(at.bGo() + str2 + "/blobTmp/");
                com.tencent.mm.plugin.appbrand.appstorage.n.t(oVar2);
                if (oVar2.exists()) {
                    oVar2.delete();
                }
            } catch (Exception e5) {
                Log.e("MicroMsg.AppBrandFileCleaner", "clean flattenBlobPath appId=%s e=%s", str2, e5);
            }
            AppBrandLocalMediaObjectManager.clear(str2);
            n.NK().VJ(str2);
            ((com.tencent.luggage.sdk.customize.a) e.M(com.tencent.luggage.sdk.customize.a.class)).dD(str2).VJ(str2);
            JsApiOperateWXData.clear(str2);
        }
        long ticksToNow = Util.ticksToNow(currentTicks);
        Log.d("MicroMsg.AppBrandFileCleaner", "%d clean appbrand file costTime[%d]", Integer.valueOf(aVar.hashCode()), Long.valueOf(ticksToNow));
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1508, 0, ticksToNow);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1508, 1, 1);
        AppMethodBeat.o(227886);
    }
}
