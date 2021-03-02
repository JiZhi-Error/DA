package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/MakeupApplyAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "makeupApplyLogic", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "getMakeupApplyLogic", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyLipStick", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "applyMakeup", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "path", "", "plugin-appbrand-integration_release"})
public final class h implements e {
    private final f oGN;

    public h(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l lVar) {
        p pVar;
        kotlin.g.b.p.h(lVar, "weEffectManager");
        AppMethodBeat.i(229731);
        if (lVar instanceof p) {
            Log.w("MicroMsg.AppBrand.MakeupApplyAdapter", "weEffectManager is IWeEffectWorkaroundManager");
            pVar = ((p) lVar).oHv.Qd();
        } else {
            pVar = new p(lVar);
        }
        this.oGN = pVar;
        AppMethodBeat.o(229731);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e
    public final f Qd() {
        return this.oGN;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
    public final boolean a(n nVar) {
        String absolutePath;
        AppMethodBeat.i(229726);
        kotlin.g.b.p.h(nVar, "info");
        i iVar = i.oGO;
        kotlin.g.b.p.h(nVar, "info");
        o oVar = new o(i.a(iVar), i.a(nVar));
        if (oVar.exists() || s.boN(oVar.getAbsolutePath())) {
            g gVar = new g();
            gVar.alpha = nVar.alpha;
            gVar.cGX = nVar.cGU.cGX;
            gVar.cGY = nVar.cGU.cGY;
            gVar.cGZ = nVar.cGU.cGZ;
            gVar.type = nVar.cGV.jsonVal;
            gVar.cGc = nVar.cGc;
            gVar.oGM = nVar.cGW.jsonVal;
            g gVar2 = gVar;
            if (!gVar2.isValid()) {
                Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
                s.deleteDir(oVar.getAbsolutePath());
                absolutePath = null;
            } else {
                String absolutePath2 = new o(oVar, "config.json").getAbsolutePath();
                kotlin.g.b.p.g(absolutePath2, "configFile.absolutePath");
                Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(absolutePath2)));
                a.C2063a aVar = a.NMI;
                a.C2063a.a(gVar2, absolutePath2);
                absolutePath = oVar.getAbsolutePath();
            }
        } else {
            Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
            absolutePath = null;
        }
        if (absolutePath != null) {
            this.oGN.a(l.b.MAKEUP_LIP_STICK, absolutePath);
            AppMethodBeat.o(229726);
            return true;
        }
        AppMethodBeat.o(229726);
        return false;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
    public final boolean a(c cVar) {
        String str;
        String str2;
        boolean z;
        String str3;
        String str4 = null;
        AppMethodBeat.i(229727);
        kotlin.g.b.p.h(cVar, "info");
        i iVar = i.oGO;
        kotlin.g.b.p.h(cVar, "info");
        o oVar = new o(i.a(iVar), i.a(cVar));
        if (oVar.exists() || s.boN(oVar.getAbsolutePath())) {
            e eVar = new e();
            eVar.alpha = cVar.alpha;
            o c2 = i.c(oVar, new o(cVar.cGk));
            if (c2 == null || (str = c2.getName()) == null) {
                str = "";
            }
            kotlin.g.b.p.h(str, "<set-?>");
            eVar.cGk = str;
            o c3 = i.c(oVar, new o(cVar.cGm));
            if (c3 == null || (str2 = c3.getName()) == null) {
                str2 = "";
            }
            kotlin.g.b.p.h(str2, "<set-?>");
            eVar.cGm = str2;
            String str5 = cVar.cGo;
            if (str5 == null || str5.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str3 = null;
            } else {
                String str6 = cVar.cGo;
                if (str6 == null) {
                    kotlin.g.b.p.hyc();
                }
                o c4 = i.c(oVar, new o(str6));
                if (c4 == null || (str3 = c4.getName()) == null) {
                    str3 = "";
                }
            }
            eVar.cGo = str3;
            e eVar2 = eVar;
            if (!eVar2.isValid()) {
                Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
                s.deleteDir(oVar.getAbsolutePath());
            } else {
                String absolutePath = new o(oVar, "config.json").getAbsolutePath();
                kotlin.g.b.p.g(absolutePath, "configFile.absolutePath");
                Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(absolutePath)));
                a.C2063a aVar = a.NMI;
                a.C2063a.a(eVar2, absolutePath);
                str4 = oVar.getAbsolutePath();
            }
        } else {
            Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
        }
        if (str4 != null) {
            this.oGN.a(l.b.MAKEUP_EYE_SHADOW, str4);
            AppMethodBeat.o(229727);
            return true;
        }
        AppMethodBeat.o(229727);
        return false;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
    public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a aVar) {
        String str;
        String str2;
        String absolutePath;
        AppMethodBeat.i(229728);
        kotlin.g.b.p.h(aVar, "info");
        i iVar = i.oGO;
        kotlin.g.b.p.h(aVar, "info");
        o oVar = new o(i.a(iVar), i.a(aVar));
        if (oVar.exists() || s.boN(oVar.getAbsolutePath())) {
            c cVar = new c();
            cVar.alpha = aVar.alpha;
            cVar.type = aVar.cFX.jsonVal;
            o c2 = i.c(oVar, new o(aVar.cFY));
            if (c2 == null || (str = c2.getName()) == null) {
                str = "";
            }
            kotlin.g.b.p.h(str, "<set-?>");
            cVar.cFY = str;
            o c3 = i.c(oVar, new o(aVar.cGa));
            if (c3 == null || (str2 = c3.getName()) == null) {
                str2 = "";
            }
            kotlin.g.b.p.h(str2, "<set-?>");
            cVar.cGa = str2;
            cVar.cGc = aVar.cGc;
            c cVar2 = cVar;
            if (!cVar2.isValid()) {
                Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
                s.deleteDir(oVar.getAbsolutePath());
                absolutePath = null;
            } else {
                String absolutePath2 = new o(oVar, "config.json").getAbsolutePath();
                kotlin.g.b.p.g(absolutePath2, "configFile.absolutePath");
                Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(absolutePath2)));
                a.C2063a aVar2 = a.NMI;
                a.C2063a.a(cVar2, absolutePath2);
                absolutePath = oVar.getAbsolutePath();
            }
        } else {
            Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
            absolutePath = null;
        }
        if (absolutePath != null) {
            this.oGN.a(l.b.MAKEUP_BLUSHER_STICK, absolutePath);
            AppMethodBeat.o(229728);
            return true;
        }
        AppMethodBeat.o(229728);
        return false;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
    public final boolean a(d dVar) {
        String str;
        String str2;
        String absolutePath;
        AppMethodBeat.i(229729);
        kotlin.g.b.p.h(dVar, "info");
        i iVar = i.oGO;
        kotlin.g.b.p.h(dVar, "info");
        o oVar = new o(i.a(iVar), i.a(dVar));
        if (oVar.exists() || s.boN(oVar.getAbsolutePath())) {
            f fVar = new f();
            fVar.cGt = dVar.cGt;
            fVar.cGu = dVar.cGu;
            o c2 = i.c(oVar, new o(dVar.cGv));
            if (c2 == null || (str = c2.getName()) == null) {
                str = "";
            }
            kotlin.g.b.p.h(str, "<set-?>");
            fVar.cGv = str;
            o c3 = i.c(oVar, new o(dVar.cGx));
            if (c3 == null || (str2 = c3.getName()) == null) {
                str2 = "";
            }
            kotlin.g.b.p.h(str2, "<set-?>");
            fVar.cGx = str2;
            fVar.cGc = dVar.cGc;
            f fVar2 = fVar;
            if (!fVar2.isValid()) {
                Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
                s.deleteDir(oVar.getAbsolutePath());
                absolutePath = null;
            } else {
                String absolutePath2 = new o(oVar, "config.json").getAbsolutePath();
                kotlin.g.b.p.g(absolutePath2, "configFile.absolutePath");
                Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(absolutePath2)));
                a.C2063a aVar = a.NMI;
                a.C2063a.a(fVar2, absolutePath2);
                absolutePath = oVar.getAbsolutePath();
            }
        } else {
            Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
            absolutePath = null;
        }
        if (absolutePath != null) {
            this.oGN.a(l.b.MAKEUP_FACE_CONTOUR, absolutePath);
            AppMethodBeat.o(229729);
            return true;
        }
        AppMethodBeat.o(229729);
        return false;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
    public final boolean a(b bVar) {
        String str;
        String str2;
        String absolutePath;
        AppMethodBeat.i(229730);
        kotlin.g.b.p.h(bVar, "info");
        i iVar = i.oGO;
        kotlin.g.b.p.h(bVar, "info");
        o oVar = new o(i.a(iVar), i.a(bVar));
        if (oVar.exists() || s.boN(oVar.getAbsolutePath())) {
            d dVar = new d();
            dVar.alpha = bVar.alpha;
            o c2 = i.c(oVar, new o(bVar.cGf));
            if (c2 == null || (str = c2.getName()) == null) {
                str = "";
            }
            kotlin.g.b.p.h(str, "<set-?>");
            dVar.cGf = str;
            o c3 = i.c(oVar, new o(bVar.cGh));
            if (c3 == null || (str2 = c3.getName()) == null) {
                str2 = "";
            }
            kotlin.g.b.p.h(str2, "<set-?>");
            dVar.cGh = str2;
            dVar.cGc = bVar.cGc;
            d dVar2 = dVar;
            if (!dVar2.isValid()) {
                Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
                s.deleteDir(oVar.getAbsolutePath());
                absolutePath = null;
            } else {
                String absolutePath2 = new o(oVar, "config.json").getAbsolutePath();
                kotlin.g.b.p.g(absolutePath2, "configFile.absolutePath");
                Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(absolutePath2)));
                a.C2063a aVar = a.NMI;
                a.C2063a.a(dVar2, absolutePath2);
                absolutePath = oVar.getAbsolutePath();
            }
        } else {
            Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
            absolutePath = null;
        }
        if (absolutePath != null) {
            this.oGN.a(l.b.MAKEUP_EYE_BROW, absolutePath);
            AppMethodBeat.o(229730);
            return true;
        }
        AppMethodBeat.o(229730);
        return false;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f
    public final void a(l.b bVar, String str) {
        AppMethodBeat.i(229725);
        kotlin.g.b.p.h(bVar, "type");
        kotlin.g.b.p.h(str, "path");
        this.oGN.a(bVar, str);
        AppMethodBeat.o(229725);
    }
}
