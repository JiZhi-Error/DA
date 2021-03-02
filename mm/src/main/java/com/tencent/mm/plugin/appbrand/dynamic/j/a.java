package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.fbn;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.protocal.protobuf.ffb;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.LinkedList;

public final class a {

    public interface e {
        void ao(String str, boolean z);
    }

    public static WxaPkgWrappingInfo b(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(121470);
        WxaPkgWrappingInfo a2 = a(str, str2, str3, i2, 0, (String) null);
        AppMethodBeat.o(121470);
        return a2;
    }

    public static WxaPkgWrappingInfo a(String str, String str2, String str3, int i2, int i3, String str4) {
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        AppMethodBeat.i(121471);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("appId", str2);
        bundle.putInt("pkgType", i2);
        bundle.putInt("pkgVersion", i3);
        bundle.putString("searchId", str3);
        bundle.putString("preload_download_data", str4);
        if (i2 != 10102 || (wxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.dynamic.b.e.Yu(Q(str2, i2, i3))) == null) {
            wxaPkgWrappingInfo = (WxaPkgWrappingInfo) h.a(MainProcessIPCService.dkO, bundle, C0575a.class);
            if (wxaPkgWrappingInfo != null) {
                com.tencent.mm.plugin.appbrand.dynamic.b.e.b(Q(str2, i2, i3), wxaPkgWrappingInfo);
            }
            AppMethodBeat.o(121471);
        } else {
            u.i("MicroMsg.DynamicPkgUpdater", "get wxaPkgInfo from cache", new Object[0]);
            AppMethodBeat.o(121471);
        }
        return wxaPkgWrappingInfo;
    }

    public static d a(String str, int i2, int i3, int i4, int i5, String str2) {
        AppMethodBeat.i(121472);
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt("pkgType", i2);
        bundle.putInt("pkgVersion", i3);
        bundle.putInt("widgetType", i4);
        bundle.putInt("scene", i5);
        bundle.putString("preloadLaunchData", str2);
        Bundle bundle2 = (Bundle) h.a(MainProcessIPCService.dkO, bundle, c.class);
        if (bundle2 == null) {
            AppMethodBeat.o(121472);
            return null;
        }
        d dVar = new d();
        dVar.appId = str;
        dVar.lps = (DebuggerInfo) bundle2.getParcelable("debuggerInfo");
        byte[] byteArray = bundle2.getByteArray("jsApiInfo");
        if (byteArray != null) {
            dVar.lpw = new ys();
            try {
                dVar.lpw.parseFrom(byteArray);
            } catch (IOException e2) {
                Log.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e2);
            }
        }
        byte[] byteArray2 = bundle2.getByteArray("launchAction");
        if (byteArray2 != null) {
            dVar.lpv = new fbo();
            try {
                dVar.lpv.parseFrom(byteArray2);
            } catch (IOException e3) {
                Log.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e3);
            }
        }
        byte[] byteArray3 = bundle2.getByteArray("versionInfo");
        dVar.lpx = new fbq();
        if (byteArray3 != null) {
            try {
                dVar.lpx.parseFrom(byteArray3);
            } catch (IOException e4) {
                Log.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e4);
            }
        }
        dVar.lpt = (WidgetSysConfig) bundle2.getParcelable("sysConfig");
        dVar.lpu = (WidgetRuntimeConfig) bundle2.getParcelable("runtimeConfig");
        if (dVar.lpu == null) {
            dVar.lpu = new WidgetRuntimeConfig();
        }
        AppMethodBeat.o(121472);
        return dVar;
    }

    private static String Q(String str, int i2, int i3) {
        AppMethodBeat.i(121473);
        String str2 = str + "#" + i2 + "#" + i3;
        AppMethodBeat.o(121473);
        return str2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a$a  reason: collision with other inner class name */
    public static class C0575a implements k<Bundle, WxaPkgWrappingInfo> {
        private C0575a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ WxaPkgWrappingInfo invoke(Bundle bundle) {
            AppMethodBeat.i(121464);
            WxaPkgWrappingInfo I = I(bundle);
            AppMethodBeat.o(121464);
            return I;
        }

        private static WxaPkgWrappingInfo I(Bundle bundle) {
            AppMethodBeat.i(121463);
            String string = bundle.getString("id");
            String string2 = bundle.getString("appId");
            int i2 = bundle.getInt("pkgType");
            int i3 = bundle.getInt("pkgVersion");
            bundle.getInt("scene");
            String string3 = bundle.getString("searchId");
            String string4 = bundle.getString("preload_download_data");
            switch (i2) {
                case 10000:
                    WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) WxaPkgIntegrityChecker.D(string2, i2, i3).second;
                    AppMethodBeat.o(121463);
                    return wxaPkgWrappingInfo;
                case 10001:
                    if (new com.tencent.mm.plugin.appbrand.dynamic.launching.c(string2, "", "", (byte) 0).bCj() == c.a.Ok.ordinal()) {
                        bd a2 = ((com.tencent.mm.plugin.appbrand.api.e) g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().a(string2, i2, "downloadURL");
                        if (a2 == null) {
                            Log.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i2));
                            AppMethodBeat.o(121463);
                            return null;
                        }
                        try {
                            WxaPkgWrappingInfo bCi = new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, string3, i2, i3, com.tencent.mm.plugin.appbrand.dynamic.launching.b.loI, a2.field_downloadURL).bCi();
                            AppMethodBeat.o(121463);
                            return bCi;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", string2, Integer.valueOf(i2), e2);
                            AppMethodBeat.o(121463);
                            return null;
                        }
                    }
                    break;
                case 10100:
                case 10101:
                    bd a3 = ((com.tencent.mm.plugin.appbrand.api.e) g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().a(string2, i2, "downloadURL");
                    g.aAf();
                    int uin = com.tencent.mm.kernel.a.getUin();
                    d.a aVar = new d.a();
                    byw byw = new byw();
                    byw.dNI = string2;
                    byw.Med = uin;
                    fbn fbn = new fbn();
                    switch (i2) {
                        case 10100:
                            fbn.KXC = 1;
                            fbn.NxK = 1;
                            break;
                        case 10101:
                            fbn.KXC = 2;
                            fbn.NxK = 1;
                            break;
                        default:
                            fbn.KXC = 0;
                            fbn.NxK = 0;
                            break;
                    }
                    if (a3 != null) {
                        fbn.md5 = a3.field_versionMd5;
                    } else {
                        fbn.md5 = "";
                    }
                    byw.Mee = new LinkedList<>();
                    byw.Mee.add(fbn);
                    aVar.iLN = byw;
                    aVar.iLO = new byx();
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
                    aVar.funcId = 1186;
                    c.a e3 = ab.e(aVar.aXF());
                    if (e3.errType == 0 && e3.errCode == 0) {
                        byx byx = (byx) e3.iLC;
                        if (!(byx == null || byx.Mee == null || byx.Mee.size() <= 0)) {
                            fbn first = byx.Mee.getFirst();
                            u.i("MicroMsg.DynamicPkgUpdater", "getWidgetInfo debugType %d, md5 %s, url %s", Integer.valueOf(i2), first.md5, first.url);
                            if (first.url != null && first.url.length() > 0) {
                                switch (i2) {
                                    case 10000:
                                    case 10001:
                                    case 10100:
                                    case 10101:
                                        ((com.tencent.mm.plugin.appbrand.api.e) g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().a(string2, i2, first.url, first.md5, 0, 0);
                                        break;
                                }
                            }
                        }
                    } else {
                        Log.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", Integer.valueOf(e3.errType), Integer.valueOf(e3.errCode), e3.errMsg, string2, Integer.valueOf(i2));
                        u.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", Integer.valueOf(e3.errType), Integer.valueOf(e3.errCode), e3.errMsg, string2, Integer.valueOf(i2));
                    }
                    WxaPkgWrappingInfo wxaPkgWrappingInfo2 = (WxaPkgWrappingInfo) WxaPkgIntegrityChecker.D(string2, i2, i3).second;
                    AppMethodBeat.o(121463);
                    return wxaPkgWrappingInfo2;
                case 10102:
                    String str = "";
                    try {
                        bd a4 = ((com.tencent.mm.plugin.appbrand.api.e) g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().a(string2, i2, "downloadURL", "version");
                        if (a4 != null) {
                            str = a4.field_downloadURL;
                            i3 = a4.field_version;
                        }
                        WxaPkgWrappingInfo bCi2 = new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, string3, i2, i3, com.tencent.mm.plugin.appbrand.dynamic.launching.b.loJ, str, string4).bCi();
                        AppMethodBeat.o(121463);
                        return bCi2;
                    } catch (Exception e4) {
                        Log.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", e4);
                        break;
                    }
                default:
                    String str2 = "";
                    try {
                        bd a5 = ((com.tencent.mm.plugin.appbrand.api.e) g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().a(string2, i2, "downloadURL", "version");
                        if (a5 != null) {
                            str2 = a5.field_downloadURL;
                            i3 = a5.field_version;
                        }
                        WxaPkgWrappingInfo bCi3 = new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, string3, i2, i3, com.tencent.mm.plugin.appbrand.dynamic.launching.b.loI, str2).bCi();
                        AppMethodBeat.o(121463);
                        return bCi3;
                    } catch (Exception e5) {
                        Log.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", e5);
                        break;
                    }
            }
            AppMethodBeat.o(121463);
            return null;
        }
    }

    static class c implements k<Bundle, Bundle> {
        private c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            AppMethodBeat.i(121467);
            Bundle J = J(bundle);
            AppMethodBeat.o(121467);
            return J;
        }

        private static Bundle J(Bundle bundle) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(121466);
            String string = bundle.getString("appId");
            int i2 = bundle.getInt("pkgType");
            int i3 = bundle.getInt("pkgVersion");
            int i4 = bundle.getInt("scene");
            int i5 = bundle.getInt("widgetType");
            String string2 = bundle.getString("preloadLaunchData", "");
            Bundle bundle2 = new Bundle();
            try {
                j bCh = new com.tencent.mm.plugin.appbrand.dynamic.launching.a(string, i2, i3, i4, i5, string2).bCh();
                if (bCh == null) {
                    AppMethodBeat.o(121466);
                    return bundle2;
                }
                if (bCh.field_jsApiInfo != null) {
                    bundle2.putByteArray("jsApiInfo", bCh.field_jsApiInfo.toByteArray());
                }
                if (bCh.field_launchAction != null) {
                    bundle2.putByteArray("launchAction", bCh.field_launchAction.toByteArray());
                }
                if (bCh.field_versionInfo != null) {
                    bundle2.putByteArray("versionInfo", bCh.field_versionInfo.toByteArray());
                }
                WidgetRuntimeConfig widgetRuntimeConfig = new WidgetRuntimeConfig();
                widgetRuntimeConfig.appId = string;
                widgetRuntimeConfig.loG = i5;
                ffb ffb = bCh.field_widgetSetting;
                if (ffb != null) {
                    widgetRuntimeConfig.loX = ffb.NAq;
                    widgetRuntimeConfig.loZ = ffb.NAs;
                    widgetRuntimeConfig.loY = ffb.NAr;
                }
                bundle2.putParcelable("runtimeConfig", widgetRuntimeConfig);
                com.tencent.mm.plugin.appbrand.widget.a.b bVar = (com.tencent.mm.plugin.appbrand.widget.a.b) com.tencent.mm.plugin.appbrand.dynamic.k.a.aA(com.tencent.mm.plugin.appbrand.widget.a.b.class);
                if (bVar == null) {
                    AppMethodBeat.o(121466);
                    return bundle2;
                }
                m afV = bVar.buH().afV(string);
                DebuggerInfo Yv = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.Yv(string);
                DebuggerInfo debuggerInfo = new DebuggerInfo();
                debuggerInfo.lnc = afV != null && afV.field_openDebug;
                if (j.a.sE(i2) || (Yv != null && Yv.lnb)) {
                    z = true;
                } else {
                    z = false;
                }
                debuggerInfo.lnb = z;
                if (Yv == null || !Yv.lnd) {
                    z2 = false;
                }
                debuggerInfo.lnd = z2;
                bundle2.putParcelable("debuggerInfo", debuggerInfo);
                AppBrandGlobalSystemConfig bzP = AppBrandGlobalSystemConfig.bzP();
                WidgetSysConfig widgetSysConfig = new WidgetSysConfig();
                widgetSysConfig.lcY = bzP.lcY;
                widgetSysConfig.lcZ = bzP.lcZ;
                widgetSysConfig.lda = bzP.lda;
                bundle2.putParcelable("sysConfig", widgetSysConfig);
                AppMethodBeat.o(121466);
                return bundle2;
            } catch (Exception e2) {
                Log.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", e2);
            }
        }
    }

    public static class d implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, final com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(121469);
            Bundle bundle2 = bundle;
            final String string = bundle2.getString("id");
            String string2 = bundle2.getString("appId");
            int i2 = bundle2.getInt("debugType");
            bd a2 = ((com.tencent.mm.plugin.appbrand.api.e) g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().a(string2, i2, "downloadURL");
            String str = a2 != null ? a2.field_downloadURL : null;
            if (a2 == null) {
                Log.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i2));
                u.i("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i2));
                if (dVar != null) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("appId", string2);
                    bundle3.putBoolean("result", false);
                    dVar.bn(bundle3);
                }
                AppMethodBeat.o(121469);
                return;
            }
            if (!Util.isNullOrNil(str)) {
                bj.a(string2, i2, str, new bj.a() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.j.a.d.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                    public final /* bridge */ /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                    public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                        AppMethodBeat.i(121468);
                        u.i("MicroMsg.DynamicPkgUpdater", "pkg download return %s", aVar);
                        if (!b.a.EnumC0543a.OK.equals(aVar)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("id", string);
                            bundle.putInt("widgetState", 2106);
                            h.a(i.bBL().Yn(string), bundle, f.a.class, null);
                            com.tencent.mm.plugin.appbrand.dynamic.j.bBN().P(string, JsApiShowImageOperateSheet.CTRL_INDEX, 16);
                        }
                        if (dVar != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("appId", str);
                            bundle2.putBoolean("result", b.a.EnumC0543a.OK.equals(aVar));
                            dVar.bn(bundle2);
                        }
                        AppMethodBeat.o(121468);
                    }
                });
            }
            AppMethodBeat.o(121469);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(121465);
            com.tencent.mm.plugin.appbrand.dynamic.b.e.removeAll();
            Log.v("MicroMsg.DynamicPkgUpdater", "clearCache");
            com.tencent.mm.plugin.appbrand.dynamic.i.b.bCs();
            AppMethodBeat.o(121465);
        }
    }
}
