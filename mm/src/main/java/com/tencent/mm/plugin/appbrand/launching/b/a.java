package com.tencent.mm.plugin.appbrand.launching.b;

import android.util.Pair;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.launching.ac;
import com.tencent.mm.plugin.appbrand.launching.b.a.a;
import com.tencent.mm.plugin.appbrand.launching.e.i;
import com.tencent.mm.plugin.appbrand.launching.o;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.v;
import com.tencent.mm.plugin.appbrand.launching.x;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.e;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\bH\u0016J4\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J,\u0010\u0012\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0018\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0014H\u0016J\u000e\u0010\u0017\u001a\u00020\u0018*\u0004\u0018\u00010\u0004H\u0002J\f\u0010\u0019\u001a\u00020\n*\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\n*\u00020\u001cH\u0002J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/AppBrandLaunchDataPrefetchExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService;", "()V", "TAG", "", "insertPrefetchedPkgInfos", "", "infos", "", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService$PrefetchPkgDownloadInfo;", "prefetchContactAndPkgDownloadInfo", "Lcom/tencent/mm/vending/pipeline/Pipeline;", ch.COL_USERNAME, "enterPath", "preloadEnvScene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "prefetchLaunchWxaAppResponse", "prefetchWxaAttrs", "callback", "Landroid/arch/core/util/Function;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "Ljava/lang/Void;", "fileExists", "", "toInfo", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "toPreFetchDownloadInfo", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "toPreFetchGetUrlItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "plugin-appbrand-integration_release"})
public final class a implements com.tencent.mm.plugin.appbrand.launching.b.a.a {
    public static final a mXV = new a();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "wxaAttrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String hLl;
        final /* synthetic */ z mXX;
        final /* synthetic */ String mXY;

        c(z zVar, String str, String str2) {
            this.mXX = zVar;
            this.mXY = str;
            this.hLl = str2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            List<String> ac;
            boolean z;
            WxaAttributes.WxaVersionModuleInfo wxaVersionModuleInfo;
            AppMethodBeat.i(50776);
            WxaAttributes wxaAttributes = (WxaAttributes) obj;
            if (wxaAttributes == null || wxaAttributes.bAp() == null) {
                Log.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchContactAndPkgDownloadInfo NULL wxaAttrs interrupt");
                g.hdx().ej(null);
                AppMethodBeat.o(50776);
                return null;
            }
            String str = wxaAttributes.field_appId;
            if (str == null || str.length() == 0) {
                Log.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchContactAndPkgDownloadInfo EMPTY wxaAttrs.appId interrupt");
                g.hdx().ej(null);
                AppMethodBeat.o(50776);
                return null;
            }
            final com.tencent.mm.vending.g.b hdH = g.hdH();
            if (this.mXX != null) {
                WxaAttributes.a bAn = wxaAttributes.bAn();
                if (bAn == null || !bAn.NA()) {
                    WxaAttributes.a bAn2 = wxaAttributes.bAn();
                    if (bAn2 == null || !bAn2.bAt()) {
                        h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WASERVICE, this.mXX);
                    } else {
                        h.bWb().e(this.mXX);
                    }
                } else {
                    h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WAGAME, this.mXX);
                }
            }
            String str2 = wxaAttributes.field_appId;
            WxaAttributes.WxaVersionInfo bAp = wxaAttributes.bAp();
            int i2 = bAp.appVersion;
            WxaAttributes.a bAn3 = wxaAttributes.bAn();
            p.g(bAn3, "wxaAttrs.appInfo");
            boolean NA = bAn3.NA();
            ac acVar = ac.mUH;
            WxaAttributes.WxaVersionInfo bAp2 = wxaAttributes.bAp();
            p.g(bAp2, "wxaAttrs.versionInfo");
            p.g(str2, "appId");
            ac acVar2 = ac.mUH;
            Map<String, WxaAttributes.WxaWidgetInfo> a2 = ac.a(bAp2, str2, ac.a(str2, 0, bAp.appVersion, NA, i.bOk()));
            if (!bAp.lgX || Util.isNullOrNil(bAp.moduleList)) {
                ac = j.ac(ModulePkgInfo.MAIN_MODULE_NAME);
            } else {
                LinkedList linkedList = new LinkedList();
                String dM = com.tencent.luggage.h.l.dM(LaunchParcel.Wf(this.mXY));
                String str3 = dM;
                if (str3 == null || str3.length() == 0) {
                    String str4 = bAp.lgY;
                    if (!(str4 == null || str4.length() == 0)) {
                        Iterator<WxaAttributes.WxaVersionModuleInfo> it = bAp.moduleList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                wxaVersionModuleInfo = null;
                                break;
                            }
                            wxaVersionModuleInfo = it.next();
                            if (p.j(bAp.lgY, wxaVersionModuleInfo.name)) {
                                break;
                            }
                        }
                    } else {
                        wxaVersionModuleInfo = null;
                    }
                } else {
                    List<WxaAttributes.WxaVersionModuleInfo> list = bAp.moduleList;
                    p.g(list, "versionInfo.moduleList");
                    wxaVersionModuleInfo = (WxaAttributes.WxaVersionModuleInfo) com.tencent.mm.plugin.appbrand.p.h.d(list, dM, "prefetchContactAndPkgDownloadInfo  appId:" + str2 + " versionType:0");
                }
                if (wxaVersionModuleInfo != null) {
                    linkedList.add(wxaVersionModuleInfo.name);
                }
                if (wxaVersionModuleInfo == null || (!wxaVersionModuleInfo.independent && (!p.j(ModulePkgInfo.MAIN_MODULE_NAME, wxaVersionModuleInfo.name)))) {
                    linkedList.add(ModulePkgInfo.MAIN_MODULE_NAME);
                }
                ac = linkedList;
            }
            HashSet<x.d> hashSet = new HashSet();
            for (String str5 : ac) {
                WxaAttributes.WxaWidgetInfo wxaWidgetInfo = a2.get(str5);
                if (wxaWidgetInfo == null) {
                    IllegalStateException illegalStateException = new IllegalStateException(("Invalid ModuleName(" + str5 + ')').toString());
                    AppMethodBeat.o(50776);
                    throw illegalStateException;
                }
                int i3 = wxaWidgetInfo.packageType;
                x.g.b bVar = new x.g.b(j.a.vP(0) ? i2 : 0);
                v.a.C0742a aVar = v.a.mTH;
                if (!v.a.C0742a.hW(NA)) {
                    z = true;
                } else {
                    z = false;
                }
                hashSet.add(new x.d(str2, str5, i3, 0, bVar, z));
                kotlin.a.v vVar = wxaWidgetInfo.lhk;
                if (vVar == null) {
                    vVar = kotlin.a.v.SXr;
                }
                for (WxaAttributes.WxaPluginCodeInfo wxaPluginCodeInfo : vVar) {
                    p.g(wxaPluginCodeInfo, "plugin");
                    hashSet.add(o.a(wxaPluginCodeInfo));
                }
            }
            km kmVar = new km();
            for (x.d dVar : hashSet) {
                LinkedList<bml> linkedList2 = kmVar.KOE;
                a aVar2 = a.mXV;
                linkedList2.add(a.c(dVar));
            }
            kmVar.scene = 1;
            acc acc = new acc();
            acc.LmG = 1;
            kmVar.KOF = acc;
            new com.tencent.mm.plugin.appbrand.appcache.g(kmVar).aYI().a(new d.b<c.a<kn>>(this) {
                /* class com.tencent.mm.plugin.appbrand.launching.b.a.c.AnonymousClass1 */
                final /* synthetic */ c mXZ;

                {
                    this.mXZ = r1;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.g.d.b
                public final /* synthetic */ void bz(c.a<kn> aVar) {
                    AppMethodBeat.i(228741);
                    c.a<kn> aVar2 = aVar;
                    try {
                        LinkedList linkedList = new LinkedList();
                        Iterator<bmm> it = ((kn) aVar2.iLC).KOG.iterator();
                        while (it.hasNext()) {
                            bmm next = it.next();
                            a aVar3 = a.mXV;
                            p.g(next, "respItem");
                            linkedList.add(a.a(next));
                        }
                        hdH.G(linkedList);
                        AppMethodBeat.o(228741);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchContactAndPkgDownloadInfo, username:" + this.mXZ.hLl + ", path:" + this.mXZ.mXY + ", convert to retList failed, exception:" + e2);
                        hdH.ej(e2);
                        AppMethodBeat.o(228741);
                    }
                }
            }).a(new d.a<Object>() {
                /* class com.tencent.mm.plugin.appbrand.launching.b.a.c.AnonymousClass2 */

                @Override // com.tencent.mm.vending.g.d.a
                public final void cn(Object obj) {
                    AppMethodBeat.i(228742);
                    hdH.ej(obj);
                    AppMethodBeat.o(228742);
                }
            });
            AppMethodBeat.o(50776);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrSyncHelper$IGetContactCallback$RESULT;", "attrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onGetContact"})
    static final class d<T> implements aa.b<WxaAttributes> {
        final /* synthetic */ String hLl;
        final /* synthetic */ android.arch.a.c.a mYa;

        d(String str, android.arch.a.c.a aVar) {
            this.hLl = str;
            this.mYa = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.config.aa$b$a, java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.config.aa.b
        public final /* synthetic */ void a(aa.b.a aVar, WxaAttributes wxaAttributes) {
            AppMethodBeat.i(228743);
            WxaAttributes wxaAttributes2 = wxaAttributes;
            p.h(aVar, "ret");
            Log.i("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchWxaAttrs with username:" + this.hLl + ", ret:" + aVar);
            if (wxaAttributes2 != null) {
                com.tencent.mm.plugin.appbrand.config.a.b bVar = (com.tencent.mm.plugin.appbrand.config.a.b) n.W(com.tencent.mm.plugin.appbrand.config.a.b.class);
                String str = this.hLl;
                if (str == null) {
                    p.hyc();
                }
                bVar.b(new b.a.C0564b(str));
            }
            android.arch.a.c.a aVar2 = this.mYa;
            if (aVar2 != null) {
                aVar2.apply(wxaAttributes2);
                AppMethodBeat.o(228743);
                return;
            }
            AppMethodBeat.o(228743);
        }
    }

    static {
        AppMethodBeat.i(50780);
        AppMethodBeat.o(50780);
    }

    private a() {
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.b.a.a
    public final void ek(String str, String str2) {
        AppMethodBeat.i(50777);
        new b(str, str2).aYI();
        AppMethodBeat.o(50777);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.b.a.a
    public final void a(String str, android.arch.a.c.a<WxaAttributes, Void> aVar) {
        AppMethodBeat.i(228744);
        aa.a(str, new d(str, aVar));
        AppMethodBeat.o(228744);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.b.a.a
    public final e<List<a.C0735a>> a(String str, String str2, z zVar) {
        AppMethodBeat.i(228745);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            Log.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchContactAndPkgDownloadInfo EMPTY USERNAME");
            f c2 = com.tencent.mm.co.g.c(null);
            p.g(c2, "pipelineExt(null)");
            f fVar = c2;
            AppMethodBeat.o(228745);
            return fVar;
        }
        f<_Ret> h2 = com.tencent.mm.co.g.hio().h(new b(str)).h(new c(zVar, str2, str));
        p.g(h2, "pipelineExt().`$logic`<W…n@`$logic` null\n        }");
        f<_Ret> fVar2 = h2;
        AppMethodBeat.o(228745);
        return fVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.b.a.a
    public final void bO(List<? extends Pair<a.C0735a, String>> list) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(50779);
        Iterator<? extends Pair<a.C0735a, String>> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.mm.ac.a aVar = com.tencent.mm.ac.a.hvd;
            a.C0735a aVar2 = (a.C0735a) com.tencent.mm.ac.a.a(pair);
            com.tencent.mm.ac.a aVar3 = com.tencent.mm.ac.a.hvd;
            String str = (String) com.tencent.mm.ac.a.b(pair);
            if (aVar2 != null) {
                String str2 = aVar2.appId;
                if (!(str2 == null || str2.length() == 0)) {
                    String str3 = aVar2.mYc;
                    if (str3 == null || str3.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (str == null || !s.YS(str)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            String adVar = new ad(aVar2.appId, aVar2.MJn, aVar2.packageType).toString();
                            p.g(adVar, "PkgQueryKey(pkg.appId, p…g.packageType).toString()");
                            bd a2 = n.buL().a(adVar, aVar2.MJo, 0, "versionMd5", "NewMd5");
                            if (a2 != null) {
                                if (str == null) {
                                    p.hyc();
                                }
                                String calcFileMD5 = CdnLogic.calcFileMD5(s.k(str, false));
                                String[] strArr = {a2.field_versionMd5, a2.field_NewMd5};
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= 2) {
                                        z3 = false;
                                        break;
                                    }
                                    String str4 = strArr[i2];
                                    String str5 = str4;
                                    if (!(str5 == null || str5.length() == 0) && p.j(str4, calcFileMD5)) {
                                        z3 = true;
                                        break;
                                    }
                                    i2++;
                                }
                                if (z3) {
                                    String aT = ba.aT(adVar, aVar2.MJo);
                                    s.nx(str, aT);
                                    n.buL().e(adVar, 0, aVar2.MJo, aT);
                                    if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED) {
                                        com.tencent.mm.ac.d.h(new C0734a(aVar2));
                                    }
                                    Log.i("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk accepted appId[" + aVar2.appId + "] key[" + aVar2.MJn + "] version[" + aVar2.MJo + "] fileMD5[" + calcFileMD5 + ']');
                                } else {
                                    Log.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk rejected appId[" + aVar2.appId + "] key[" + aVar2.MJn + "] version[" + aVar2.MJo + "] fileMD5[" + calcFileMD5 + ']');
                                }
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(50779);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String hLl;

        b(String str) {
            this.hLl = str;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(50768);
            final com.tencent.mm.vending.g.b hdH = g.hdH();
            ((q) com.tencent.mm.kernel.g.af(q.class)).c(this.hLl, new q.a() {
                /* class com.tencent.mm.plugin.appbrand.launching.b.a.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.service.q.a
                public final void b(WxaAttributes wxaAttributes) {
                    AppMethodBeat.i(50767);
                    hdH.G(wxaAttributes);
                    AppMethodBeat.o(50767);
                }
            });
            AppMethodBeat.o(50768);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.launching.b.a$a  reason: collision with other inner class name */
    static final class C0734a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a.C0735a mXW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0734a(a.C0735a aVar) {
            super(0);
            this.mXW = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(50766);
            Toast.makeText(MMApplicationContext.getContext(), "WxaPkg path from OpenSdk accepted appId[" + this.mXW.appId + "] key[" + this.mXW.MJn + "] version[" + this.mXW.MJo + ']', 0).show();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(50766);
            return xVar;
        }
    }

    public static final /* synthetic */ bml c(x.d dVar) {
        int i2;
        AppMethodBeat.i(228746);
        bml bml = new bml();
        bml.LVf = new doo();
        bml.LVf.dNI = dVar.appId;
        doo doo = bml.LVf;
        String str = dVar.cBp;
        if (str == null) {
            str = "";
        }
        doo.MbW = str;
        bml.LVf.MbZ = dVar.packageType;
        if (dVar.mUm) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        bml.LVh = i2;
        x.g gVar = dVar.mUl;
        if (gVar instanceof x.g.a) {
            bml.LVi = true;
        } else if (gVar instanceof x.g.b) {
            bml.KXD = ((x.g.b) dVar.mUl).version;
        }
        bml.LVj = false;
        AppMethodBeat.o(228746);
        return bml;
    }

    public static final /* synthetic */ a.C0735a a(bmm bmm) {
        AppMethodBeat.i(228747);
        a.C0735a aVar = new a.C0735a();
        aVar.appId = bmm.LVf.dNI;
        String str = bmm.LVf.MbW;
        if (str == null) {
            str = "";
        }
        aVar.MJn = str;
        aVar.packageType = bmm.LVf.MbZ;
        aVar.MJo = bmm.KXD;
        aVar.mYc = bmm.md5;
        aVar.mYd = bmm.url;
        aVar.mYe = (long) bmm.LUr;
        AppMethodBeat.o(228747);
        return aVar;
    }
}
