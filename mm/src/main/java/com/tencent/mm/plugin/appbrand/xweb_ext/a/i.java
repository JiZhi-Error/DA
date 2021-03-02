package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\bJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\tJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\nJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u000bJ8\u0010\f\u001a\u0004\u0018\u00010\u0004\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u000e2\u0006\u0010\u0006\u001a\u0002H\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\b¢\u0006\u0002\u0010\u0013J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\n \u0018*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0019\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/MakeupApplyAdapterCoreLogic;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "()V", "TAG", "", "convert2Path", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "convert2PathImpl", "T", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "flatten", "Lkotlin/Function1;", "Lcom/tencent/mm/vfs/VFSFile;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "copyImageIfNeed", "resDir", "originFile", "generateResDirName", "kotlin.jvm.PlatformType", "infoObj", "plugin-appbrand-integration_release"})
public final class i extends b {
    public static final i oGO = new i();

    static {
        AppMethodBeat.i(229733);
        AppMethodBeat.o(229733);
    }

    private i() {
    }

    public static final /* synthetic */ o a(i iVar) {
        AppMethodBeat.i(229734);
        o cdJ = iVar.cdJ();
        AppMethodBeat.o(229734);
        return cdJ;
    }

    static o c(o oVar, o oVar2) {
        AppMethodBeat.i(229732);
        o oVar3 = new o(oVar, oVar2.getName());
        Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, originFile: " + oVar2 + ", newFile: " + oVar3);
        d dVar = d.mJM;
        if (d.D(oVar3)) {
            Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, newFile already exist");
            AppMethodBeat.o(229732);
            return oVar3;
        } else if (!oVar2.exists()) {
            Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, originFile not exist");
            AppMethodBeat.o(229732);
            return null;
        } else if (0 > s.nw(oVar2.getAbsolutePath(), oVar3.getAbsolutePath())) {
            Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, copy fail");
            AppMethodBeat.o(229732);
            return null;
        } else {
            d dVar2 = d.mJM;
            if (!d.C(oVar3)) {
                Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, record newFile fail");
                AppMethodBeat.o(229732);
                return null;
            }
            AppMethodBeat.o(229732);
            return oVar3;
        }
    }

    public static final /* synthetic */ String a(h hVar) {
        AppMethodBeat.i(229735);
        String Qc = hVar.Qc();
        Charset charset = kotlin.n.d.UTF_8;
        if (Qc == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(229735);
            throw tVar;
        }
        byte[] bytes = Qc.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String messageDigest = com.tencent.xweb.util.d.getMessageDigest(bytes);
        AppMethodBeat.o(229735);
        return messageDigest;
    }
}
