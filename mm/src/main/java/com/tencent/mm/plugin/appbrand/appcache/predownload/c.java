package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.g.b.a.my;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.protocal.protobuf.ddu;
import com.tencent.mm.protocal.protobuf.ddv;
import com.tencent.mm.protocal.protobuf.efw;
import com.tencent.mm.protocal.protobuf.efx;
import com.tencent.mm.protocal.protobuf.feo;
import com.tencent.mm.protocal.protobuf.fep;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nB'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u001c\u0010*\u001a\u00020+2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/J\u0014\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020302H\u0016R\u0014\u0010\f\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0011R\u0016\u0010&\u001a\u0004\u0018\u00010'8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/CgiPreDownloadCode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", ch.COL_USERNAME, "", "path", "scene", "", "appId", "appType", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "(Ljava/lang/String;Ljava/lang/String;I)V", "FUNC_ID", "getFUNC_ID", "()I", "TAG", "getTAG", "()Ljava/lang/String;", "URL", "getURL", "getAppId", "setAppId", "(Ljava/lang/String;)V", "getAppType", "setAppType", "(I)V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "getPath", "getScene", "startTime", "getStartTime", "setStartTime", "getUsername", "wxaAttrStorage", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "getWxaAttrStorage", "()Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "createSingleReqInfo", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "execute", "", "splitDownloadURLCgi", "", "dealPluginOnly", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class c extends com.tencent.mm.ak.c<ddv> {
    final String TAG;
    private final String URL;
    String appId;
    int appType;
    long endTime;
    private final int kOR;
    private final String path;
    final int scene;
    long startTime;
    final String username;

    public c() {
        this((String) null, 0, 7);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, int i2, int i3) {
        this((i3 & 1) != 0 ? null : str, (String) null, (i3 & 4) != 0 ? 0 : i2);
        AppMethodBeat.i(227994);
        AppMethodBeat.o(227994);
    }

    public c(String str, String str2, int i2) {
        AppMethodBeat.i(50192);
        this.username = str;
        this.path = str2;
        this.scene = i2;
        this.TAG = "MicroMsg.AppBrand.CgiPreDownloadCode";
        this.URL = "/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode";
        this.kOR = 1479;
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.o(50192);
    }

    public c(String str, int i2, String str2, int i3) {
        this((String) null, str, i2);
        this.appId = str2;
        this.appType = i3;
    }

    @Override // com.tencent.mm.ak.c
    public final f<c.a<ddv>> aYI() {
        boolean z;
        z buC;
        WxaAttributes wxaAttributes;
        int i2;
        f<c.a<ddv>> aYI;
        WxaAttributes.WxaVersionInfo bAp;
        boolean z2;
        WxaAttributes wxaAttributes2 = null;
        boolean z3 = true;
        AppMethodBeat.i(50189);
        String str = this.username;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String str2 = this.appId;
            if (str2 == null || str2.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                f<c.a<ddv>> c2 = g.c(new b(this));
                p.g(c2, "pipelineExt {\n          …          )\n            }");
                AppMethodBeat.o(50189);
                return c2;
            }
        }
        if (n.buC() == null) {
            aYI = g.c(new C0550c(this));
        } else {
            Log.i(this.TAG, "do cgi with username[" + this.username + "] appId:[" + this.appId + ']');
            d.a aVar = new d.a();
            ddu ddu = new ddu();
            String str3 = this.username;
            String str4 = this.appId;
            efw efw = new efw();
            String str5 = str4;
            if (!(str5 == null || str5.length() == 0)) {
                efw.jfi = str4;
                String str6 = str4;
                if (!(str6 == null || str6.length() == 0)) {
                    z3 = false;
                }
                if (z3) {
                    wxaAttributes = null;
                } else {
                    z buC2 = n.buC();
                    wxaAttributes = buC2 != null ? buC2.e(str4, new String[0]) : null;
                }
            } else {
                efw.Mmv = str3;
                String str7 = str3;
                if (!(str7 == null || str7.length() == 0) && (buC = n.buC()) != null) {
                    wxaAttributes2 = buC.d(str3, new String[0]);
                }
                wxaAttributes = wxaAttributes2;
            }
            if (wxaAttributes == null || (bAp = wxaAttributes.bAp()) == null) {
                i2 = 0;
            } else {
                i2 = bAp.appVersion;
            }
            efw.NfQ = i2;
            efw.xut = this.path;
            ddu.MIS = efw;
            ddu.MIT = v.bvG();
            ddu.scene = this.scene;
            aVar.c(ddu);
            aVar.d(new ddv());
            aVar.MB(this.URL);
            aVar.sG(this.kOR);
            super.c(aVar.aXF());
            aYI = super.aYI();
        }
        p.g(aYI, "if (null == wxaAttrStora…    super.run()\n        }");
        AppMethodBeat.o(50189);
        return aYI;
    }

    public static /* synthetic */ void a(c cVar, boolean z, int i2) {
        AppMethodBeat.i(50191);
        if ((i2 & 1) != 0) {
            z = false;
        }
        cVar.s(z, false);
        AppMethodBeat.o(50191);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ c kOS;
        final /* synthetic */ boolean kOT;
        final /* synthetic */ boolean kOU;

        a(c cVar, boolean z, boolean z2) {
            this.kOS = cVar;
            this.kOT = z;
            this.kOU = z2;
        }

        public final void run() {
            AppMethodBeat.i(50186);
            this.kOS.aYI().a(com.tencent.mm.vending.h.d.LOGIC, new d.b<c.a<ddv>>(this) {
                /* class com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.AnonymousClass1 */
                final /* synthetic */ a kOV;

                {
                    this.kOV = r1;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.g.d.b
                public final /* synthetic */ void bz(c.a<ddv> aVar) {
                    fep fep;
                    feo feo;
                    fep fep2;
                    fep fep3;
                    String str;
                    fep fep4;
                    LinkedList<efx> linkedList;
                    efx efx;
                    AppMethodBeat.i(50185);
                    c.a<ddv> aVar2 = aVar;
                    if (aVar2 == null) {
                        new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 kOW;

                            {
                                this.kOW = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(50184);
                                Log.i(this.kOW.kOV.kOS.TAG, "onCgiBack NULL result");
                                x xVar = x.SXb;
                                AppMethodBeat.o(50184);
                                return xVar;
                            }
                        }.invoke();
                        AppMethodBeat.o(50185);
                        return;
                    }
                    Log.i(this.kOV.kOS.TAG, "onCgiBack errType[" + aVar2.errType + "], errCode[" + aVar2.errCode + "], errMsg[" + aVar2.errMsg + "], splitDownloadURLCgi[" + this.kOV.kOT + "], dealPluginOnly[" + this.kOV.kOU + "], splitPluginCode:[" + v.bvG() + ']');
                    this.kOV.kOS.endTime = System.currentTimeMillis();
                    if (com.tencent.mm.plugin.appbrand.r.a.d(aVar2)) {
                        LinkedList linkedList2 = new LinkedList();
                        ddv ddv = (ddv) aVar2.iLC;
                        if (!(ddv == null || (efx = ddv.MIU) == null)) {
                            linkedList2.add(efx);
                        }
                        ddv ddv2 = (ddv) aVar2.iLC;
                        if (!(ddv2 == null || (linkedList = ddv2.MIV) == null)) {
                            linkedList2.addAll(linkedList);
                        }
                        Log.i(this.kOV.kOS.TAG, "cmdList size:[" + linkedList2.size() + ']');
                        if (this.kOV.kOU) {
                            if (v.bvG()) {
                                Iterator it = linkedList2.iterator();
                                while (it.hasNext()) {
                                    efx efx2 = (efx) it.next();
                                    feo feo2 = efx2.NfS;
                                    if (!(feo2 == null || (fep4 = feo2.NzT) == null || fep4.NAd == 6)) {
                                        efx2.NfS.NzT = null;
                                    }
                                }
                            } else {
                                Iterator it2 = linkedList2.iterator();
                                while (it2.hasNext()) {
                                    ((efx) it2.next()).NfS.NzT = null;
                                }
                            }
                        } else if (v.bvG()) {
                            HashSet hashSet = new HashSet();
                            Iterator it3 = linkedList2.iterator();
                            while (it3.hasNext()) {
                                efx efx3 = (efx) it3.next();
                                feo feo3 = efx3.NfS;
                                if (!(feo3 == null || (fep3 = feo3.NzT) == null)) {
                                    int i2 = fep3.NAd;
                                    if ((i2 == 12 || i2 == 13) && (str = efx3.KGX) != null) {
                                        hashSet.add(str);
                                    }
                                }
                            }
                            if (!hashSet.isEmpty()) {
                                Iterator it4 = linkedList2.iterator();
                                while (it4.hasNext()) {
                                    efx efx4 = (efx) it4.next();
                                    String str2 = efx4.KGX;
                                    if (!(str2 == null || (feo = efx4.NfS) == null || (fep2 = feo.NzT) == null)) {
                                        int i3 = fep2.NAd;
                                        if ((i3 == 0 || i3 == 4) && hashSet.contains(str2)) {
                                            efx4.NfS.NzT = null;
                                        }
                                    }
                                }
                            }
                        } else {
                            Iterator it5 = linkedList2.iterator();
                            while (it5.hasNext()) {
                                efx efx5 = (efx) it5.next();
                                feo feo4 = efx5.NfS;
                                if (!(feo4 == null || (fep = feo4.NzT) == null)) {
                                    int i4 = fep.NAd;
                                    if (i4 == 12 || i4 == 13 || i4 == 6) {
                                        efx5.NfS.NzT = null;
                                    }
                                }
                            }
                        }
                        e.a(linkedList2, this.kOV.kOT, this.kOV.kOS.scene);
                    }
                    my myVar = new my();
                    myVar.Ag(this.kOV.kOS.username);
                    myVar.Ah(this.kOV.kOS.appId);
                    myVar.xo((long) this.kOV.kOS.appType);
                    myVar.xq((long) this.kOV.kOS.scene);
                    myVar.xp(this.kOV.kOS.endTime - this.kOV.kOS.startTime);
                    myVar.xr(this.kOV.kOS.startTime);
                    myVar.xs(this.kOV.kOS.endTime);
                    myVar.mK(aVar2.errType);
                    myVar.xt((long) com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType());
                    myVar.bfK();
                    AppMethodBeat.o(50185);
                }
            });
            AppMethodBeat.o(50186);
        }
    }

    public final void s(boolean z, boolean z2) {
        AppMethodBeat.i(50190);
        h.RTc.aV(new a(this, z, z2));
        AppMethodBeat.o(50190);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret> implements c.a<_Var> {
        final /* synthetic */ c kOS;

        b(c cVar) {
            this.kOS = cVar;
        }

        @Override // com.tencent.mm.vending.g.c.a
        public final /* synthetic */ Object call() {
            AppMethodBeat.i(50187);
            c.a a2 = c.a.a(3, -2, "EMPTY USERNAME OR APPID", new ddv(), null, this.kOS);
            AppMethodBeat.o(50187);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.predownload.c$c  reason: collision with other inner class name */
    public static final class C0550c<_Ret> implements c.a<_Var> {
        final /* synthetic */ c kOS;

        C0550c(c cVar) {
            this.kOS = cVar;
        }

        @Override // com.tencent.mm.vending.g.c.a
        public final /* synthetic */ Object call() {
            AppMethodBeat.i(50188);
            c.a a2 = c.a.a(3, -2, "NULL wxaAttrStorage", new ddv(), null, this.kOS);
            AppMethodBeat.o(50188);
            return a2;
        }
    }
}
