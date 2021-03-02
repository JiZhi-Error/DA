package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.openmaterial.i;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.protocal.protobuf.bqf;
import com.tencent.mm.protocal.protobuf.bqg;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cms;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/WeChatOpenMaterialDataSourceAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource;", "()V", "OPEN_MATERIALS_CACHE_PREFIX", "", "PREFETCH_OPEN_MATERIALS_DELAY_MILLS", "", "fetchOpenMaterials", "", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsByCgi", "fetchOpenMaterialsQuickly", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "parseRawRsp", "rawCgiRsp", "parseRawRspAndCallback", "parseRsp", "rsp", "Lcom/tencent/mm/protocal/protobuf/GetMaterialRecommWxaCardResponse;", "parseRspAndCallback", "prefetchOpenMaterialsOnLaunchAppBrand", "toOpenMaterialDetailModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "Lcom/tencent/mm/protocal/protobuf/MaterialRecommWxaCard;", "toOpenMaterialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "Lcom/tencent/mm/protocal/protobuf/MaterialRecentlyUsedWxaCard;", "plugin-appbrand-integration_release"})
public final class g implements b {
    public static final g nlA = new g();

    static {
        AppMethodBeat.i(229179);
        AppMethodBeat.o(229179);
    }

    private g() {
    }

    public static final /* synthetic */ AppBrandOpenMaterialCollection b(bqg bqg, MaterialModel materialModel) {
        AppMethodBeat.i(229182);
        AppBrandOpenMaterialCollection a2 = a(bqg, materialModel);
        AppMethodBeat.o(229182);
        return a2;
    }

    public static final /* synthetic */ void i(MaterialModel materialModel) {
        AppMethodBeat.i(229180);
        b(materialModel, (i) null);
        AppMethodBeat.o(229180);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ MaterialModel nlp;

        d(MaterialModel materialModel) {
            this.nlp = materialModel;
        }

        public final void run() {
            AppMethodBeat.i(229170);
            g gVar = g.nlA;
            g.i(this.nlp);
            AppMethodBeat.o(229170);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.a.b
    public final void c(MaterialModel materialModel) {
        AppMethodBeat.i(229171);
        p.h(materialModel, "materialModel");
        h.RTc.o(new d(materialModel), 5000);
        AppMethodBeat.o(229171);
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.a.b
    public final void a(MaterialModel materialModel, i iVar) {
        AppMethodBeat.i(229172);
        p.h(materialModel, "materialModel");
        p.h(iVar, "fetchOpenMaterialsCallback");
        String str = "OpenMaterialsRsp###" + materialModel.mimeType;
        Log.d("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterials, cacheKey: ".concat(String.valueOf(str)));
        MultiProcessMMKV VQ = f.kIs.VQ();
        String string = VQ != null ? VQ.getString(str, null) : null;
        if (string != null) {
            if (!(string.length() == 0)) {
                com.tencent.mm.ac.d.h(new b(a(string, materialModel), iVar, materialModel));
                b(materialModel, (i) null);
                AppMethodBeat.o(229172);
                return;
            }
        }
        Log.i("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterials, rawCgiRsp is empty");
        b(materialModel, iVar);
        AppMethodBeat.o(229172);
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.a.b
    public final AppBrandOpenMaterialCollection a(MaterialModel materialModel) {
        AppBrandOpenMaterialCollection appBrandOpenMaterialCollection;
        AppMethodBeat.i(229173);
        p.h(materialModel, "materialModel");
        try {
            String str = "OpenMaterialsRsp###" + materialModel.mimeType;
            Log.d("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterialsQuickly, cacheKey: ".concat(String.valueOf(str)));
            MultiProcessMMKV VQ = f.kIs.VQ();
            String string = VQ != null ? VQ.getString(str, null) : null;
            if (string != null) {
                if (!(string.length() == 0)) {
                    appBrandOpenMaterialCollection = a(string, materialModel);
                    if (appBrandOpenMaterialCollection == null) {
                        appBrandOpenMaterialCollection = AppBrandOpenMaterialCollection.j(materialModel);
                        p.g(appBrandOpenMaterialCollection, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
                    }
                    b(materialModel, (i) null);
                    AppMethodBeat.o(229173);
                    return appBrandOpenMaterialCollection;
                }
            }
            Log.i("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterialsQuickly, rawCgiRsp is empty");
            appBrandOpenMaterialCollection = AppBrandOpenMaterialCollection.j(materialModel);
            p.g(appBrandOpenMaterialCollection, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
            return appBrandOpenMaterialCollection;
        } finally {
            b(materialModel, (i) null);
            AppMethodBeat.o(229173);
        }
    }

    private static void b(MaterialModel materialModel, i iVar) {
        AppMethodBeat.i(229174);
        d.a aVar = new d.a();
        aVar.MB("/cgi-bin/mmbiz-bin/wxabusiness/getmaterialrecommwxacard");
        aVar.sG(5049);
        bqf bqf = new bqf();
        bqf.LXZ = materialModel.mimeType;
        aVar.c(bqf);
        aVar.d(new bqg());
        IPCRunCgi.a(aVar.aXF(), new a(iVar, materialModel));
        AppMethodBeat.o(229174);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    public static final class a implements IPCRunCgi.a {
        final /* synthetic */ i nlo;
        final /* synthetic */ MaterialModel nlp;

        a(i iVar, MaterialModel materialModel) {
            this.nlo = iVar;
            this.nlp = materialModel;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(229167);
            Log.i("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterialsByCgi#onCgiBack, errType: " + i2 + ", errCode: " + i3 + ", errMsg: " + str);
            if (i2 == 0 && i3 == 0) {
                p.g(dVar, "reqResp");
                if (!(dVar.aYK() instanceof bqg)) {
                    Log.w("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterialsByCgi#onCgiBack, responseProtoBuf is not GetMaterialRecommWxaCardResponse");
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.appbrand.openmaterial.a.g.a.AnonymousClass1 */
                        final /* synthetic */ a nlB;

                        {
                            this.nlB = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(229165);
                            i iVar = this.nlB.nlo;
                            if (iVar != null) {
                                iVar.a(false, AppBrandOpenMaterialCollection.j(this.nlB.nlp));
                            }
                            x xVar = x.SXb;
                            AppMethodBeat.o(229165);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(229167);
                    return;
                }
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetMaterialRecommWxaCardResponse");
                    AppMethodBeat.o(229167);
                    throw tVar;
                }
                bqg bqg = (bqg) aYK;
                if (this.nlo != null) {
                    g gVar = g.nlA;
                    g.a(bqg, this.nlp, this.nlo);
                }
                String str2 = "OpenMaterialsRsp###" + this.nlp.mimeType;
                Log.d("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterialsByCgi#onCgiBack, cacheKey: ".concat(String.valueOf(str2)));
                MultiProcessMMKV VQ = f.kIs.VQ();
                if (VQ != null) {
                    byte[] byteArray = bqg.toByteArray();
                    p.g(byteArray, "rsp.toByteArray()");
                    VQ.putString(str2, new String(byteArray, kotlin.n.d.ISO_8859_1));
                    AppMethodBeat.o(229167);
                    return;
                }
                AppMethodBeat.o(229167);
                return;
            }
            Log.w("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterialsByCgi#onCgiBack, cgi back not ok");
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.appbrand.openmaterial.a.g.a.AnonymousClass2 */
                final /* synthetic */ a nlB;

                {
                    this.nlB = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(229166);
                    i iVar = this.nlB.nlo;
                    if (iVar != null) {
                        iVar.a(false, AppBrandOpenMaterialCollection.j(this.nlB.nlp));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(229166);
                    return xVar;
                }
            });
            AppMethodBeat.o(229167);
        }
    }

    private static AppBrandOpenMaterialCollection a(String str, MaterialModel materialModel) {
        AppBrandOpenMaterialCollection appBrandOpenMaterialCollection;
        AppMethodBeat.i(229175);
        try {
            bqg bqg = new bqg();
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(229175);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            bqg.parseFrom(bytes);
            appBrandOpenMaterialCollection = a(bqg, materialModel);
            AppMethodBeat.o(229175);
            return appBrandOpenMaterialCollection;
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "parseRawRsp, fail since ".concat(String.valueOf(e2)));
            appBrandOpenMaterialCollection = null;
        }
    }

    private static AppBrandOpenMaterialCollection a(bqg bqg, MaterialModel materialModel) {
        AppMethodBeat.i(229176);
        LinkedList<cmr> linkedList = bqg.LYa;
        p.g(linkedList, "rsp.recently_used_card_list");
        LinkedList<cmr> linkedList2 = linkedList;
        ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
        for (T t : linkedList2) {
            p.g(t, LocaleUtil.ITALIAN);
            arrayList.add(a((cmr) t));
        }
        ArrayList arrayList2 = arrayList;
        LinkedList<cms> linkedList3 = bqg.LYb;
        p.g(linkedList3, "rsp.recomm_card_list");
        LinkedList<cms> linkedList4 = linkedList3;
        ArrayList arrayList3 = new ArrayList(j.a(linkedList4, 10));
        for (T t2 : linkedList4) {
            p.g(t2, LocaleUtil.ITALIAN);
            arrayList3.add(a((cms) t2));
        }
        AppBrandOpenMaterialCollection appBrandOpenMaterialCollection = new AppBrandOpenMaterialCollection(materialModel, arrayList2, arrayList3);
        AppMethodBeat.o(229176);
        return appBrandOpenMaterialCollection;
    }

    private static AppBrandOpenMaterialModel a(cmr cmr) {
        AppMethodBeat.i(229177);
        AppBrandOpenMaterialModel appBrandOpenMaterialModel = new AppBrandOpenMaterialModel(cmr.dNI, cmr.KXC, cmr.Msf, cmr.qGB, cmr.Mse);
        appBrandOpenMaterialModel.appName = cmr.qFU;
        AppMethodBeat.o(229177);
        return appBrandOpenMaterialModel;
    }

    private static AppBrandOpenMaterialDetailModel a(cms cms) {
        AppMethodBeat.i(229178);
        AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel = new AppBrandOpenMaterialDetailModel(cms.dNI, cms.KXC, cms.Msf, cms.qGB, cms.Mse, cms.Msg, cms.score, cms.desc);
        appBrandOpenMaterialDetailModel.appName = cms.nickname;
        AppMethodBeat.o(229178);
        return appBrandOpenMaterialDetailModel;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ AppBrandOpenMaterialCollection nlb;
        final /* synthetic */ i nlo;
        final /* synthetic */ MaterialModel nlp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AppBrandOpenMaterialCollection appBrandOpenMaterialCollection, i iVar, MaterialModel materialModel) {
            super(0);
            this.nlb = appBrandOpenMaterialCollection;
            this.nlo = iVar;
            this.nlp = materialModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(229168);
            if (this.nlb != null) {
                this.nlo.a(true, this.nlb);
            } else {
                this.nlo.a(false, AppBrandOpenMaterialCollection.j(this.nlp));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(229168);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bqg nlC;
        final /* synthetic */ i nlo;
        final /* synthetic */ MaterialModel nlp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(i iVar, bqg bqg, MaterialModel materialModel) {
            super(0);
            this.nlo = iVar;
            this.nlC = bqg;
            this.nlp = materialModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(229169);
            i iVar = this.nlo;
            g gVar = g.nlA;
            iVar.a(true, g.b(this.nlC, this.nlp));
            x xVar = x.SXb;
            AppMethodBeat.o(229169);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(bqg bqg, MaterialModel materialModel, i iVar) {
        AppMethodBeat.i(229181);
        com.tencent.mm.ac.d.h(new c(iVar, bqg, materialModel));
        AppMethodBeat.o(229181);
    }
}
