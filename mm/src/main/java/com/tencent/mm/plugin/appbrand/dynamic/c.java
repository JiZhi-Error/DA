package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c.e;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.f.g;
import com.tencent.mm.plugin.appbrand.dynamic.j.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.jsapi.ba;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Set;

public final class c implements com.tencent.mm.plugin.appbrand.canvas.widget.b {
    String Nv;
    String appId;
    String gIx;
    boolean gc;
    String hes;
    volatile e hpm;
    int llJ;
    boolean llK;
    com.tencent.mm.plugin.appbrand.widget.e llL;
    volatile boolean llM;
    volatile boolean llN;
    private volatile boolean llO;
    boolean llP = false;
    boolean llQ = false;
    private IPCRunCgi.a llR;
    Runnable llS;
    Context mContext;
    String mSessionId;
    String mUrl;

    public c(Context context) {
        AppMethodBeat.i(121149);
        this.mContext = context;
        this.llR = new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.c.AnonymousClass1 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(121141);
                Log.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", Integer.valueOf(i2), Integer.valueOf(i3), str);
                u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", Integer.valueOf(i2), Integer.valueOf(i3), str);
                com.tencent.mm.plugin.appbrand.widget.e eVar = c.this.llL;
                if (i2 == 0 && i3 == 0) {
                    if (c.this.llJ == 1 && !c.this.llP) {
                        c.this.llP = true;
                        v.pl(17);
                        hr vt = new hr().vt(u.Lv(c.this.gIx));
                        vt.eBS = (long) u.Lt(c.this.gIx);
                        vt.eMi = 10;
                        vt.eMk = 1;
                        hr vs = vt.vs(c.this.gIx);
                        vs.eMj = System.currentTimeMillis();
                        vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                    }
                    aid aid = (aid) dVar.iLL.iLR;
                    String yO = aid.LrK != null ? aid.LrK.yO() : "";
                    if (eVar == null) {
                        AppMethodBeat.o(121141);
                        return;
                    }
                    if (!Util.isNullOrNil(yO)) {
                        eVar.field_data = yO;
                    } else if (c.this.llL == null || TextUtils.isEmpty(c.this.llL.field_data)) {
                        j.bBN().P(c.this.gIx, ba.CTRL_INDEX, 4);
                    }
                    eVar.field_interval = aid.gTn;
                    eVar.field_updateTime = System.currentTimeMillis();
                    Bundle bundle = (Bundle) h.a(MainProcessIPCService.dkO, eVar.convertTo(), b.C0576b.class);
                    if (bundle != null) {
                        bundle.getBoolean("result", false);
                    }
                    if (!c.this.gc) {
                        Log.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
                        AppMethodBeat.o(121141);
                        return;
                    }
                    c.this.a(c.this.hpm, eVar);
                    if (c.this.llJ == 1 && !c.this.llQ) {
                        c.this.llQ = true;
                    }
                    if (eVar.field_interval > 0) {
                        c.this.bBG();
                    }
                    AppMethodBeat.o(121141);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(638, 0, 1, false);
                if (c.this.llJ == 1 && !c.this.llP) {
                    v.pl(18);
                    hr vt2 = new hr().vt(u.Lv(c.this.gIx));
                    vt2.eBS = (long) u.Lt(c.this.gIx);
                    vt2.eMi = 10;
                    vt2.eMk = 2;
                    hr vs2 = vt2.vs(c.this.gIx);
                    vs2.eMj = System.currentTimeMillis();
                    vs2.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                }
                b.j(c.this.llS, (eVar != null ? (long) eVar.field_interval : 10) * 1000);
                if (c.this.llL == null || TextUtils.isEmpty(c.this.llL.field_data)) {
                    j.bBN().P(c.this.gIx, ba.CTRL_INDEX, 2);
                }
                AppMethodBeat.o(121141);
            }
        };
        this.llS = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(121142);
                c.this.bBG();
                AppMethodBeat.o(121142);
            }
        };
        AppMethodBeat.o(121149);
    }

    public final boolean cY(String str, String str2) {
        AppMethodBeat.i(121150);
        if (this.hpm == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(121150);
            return false;
        }
        boolean at = this.hpm.at(str, str2);
        AppMethodBeat.o(121150);
        return at;
    }

    /* access modifiers changed from: package-private */
    public final void cleanup() {
        AppMethodBeat.i(121151);
        if (this.llL != null) {
            Log.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", this.llL.field_id, this.llL.field_appId);
        } else {
            Log.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
        }
        if (this.hpm != null) {
            this.hpm.onStop();
        }
        AppMethodBeat.o(121151);
    }

    /* access modifiers changed from: package-private */
    public final void bBG() {
        boolean z;
        AppMethodBeat.i(121152);
        u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
        if (this.llK) {
            AppMethodBeat.o(121152);
            return;
        }
        com.tencent.mm.plugin.appbrand.widget.e eVar = this.llL;
        if (eVar == null || !this.gc) {
            Object[] objArr = new Object[2];
            if (eVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Boolean.valueOf(this.gc);
            u.i("MicroMsg.DynamicPageViewIPCProxy", "cacheData %b, mRunning %b", objArr);
            AppMethodBeat.o(121152);
        } else if (this.llN) {
            u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
            this.llO = true;
            AppMethodBeat.o(121152);
        } else if (Util.isNullOrNil(eVar.field_appId)) {
            Log.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", this.gIx);
            AppMethodBeat.o(121152);
        } else {
            this.llO = false;
            long currentTimeMillis = (eVar.field_updateTime + (((long) eVar.field_interval) * 1000)) - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", Long.valueOf(currentTimeMillis));
                b.j(this.llS, currentTimeMillis);
                AppMethodBeat.o(121152);
                return;
            }
            u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", this.llL.field_id, this.llL.field_appId);
            if (this.llJ == 1 && !this.llP) {
                v.pl(16);
                hr vt = new hr().vt(u.Lv(this.gIx));
                vt.eBS = (long) u.Lt(this.gIx);
                vt.eMi = 9;
                hr vs = vt.vs(this.gIx);
                vs.eMj = System.currentTimeMillis();
                vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
            }
            d.a aVar = new d.a();
            aVar.funcId = 1193;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
            aic aic = new aic();
            aic.dNI = eVar.field_appId;
            aic.key = eVar.field_cacheKey;
            aic.scene = this.llJ;
            aic.query = this.Nv;
            aic.url = this.mUrl;
            aVar.iLN = aic;
            aVar.iLO = new aid();
            IPCRunCgi.a(aVar.aXF(), this.llR);
            AppMethodBeat.o(121152);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(e eVar, com.tencent.mm.plugin.appbrand.widget.e eVar2) {
        boolean z = false;
        AppMethodBeat.i(121153);
        if (eVar == null || eVar2 == null || Util.isNullOrNil(eVar2.field_data)) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(eVar == null);
            if (eVar2 == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            Log.i("MicroMsg.DynamicPageViewIPCProxy", "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null", objArr);
            AppMethodBeat.o(121153);
            return;
        }
        u.i("MicroMsg.DynamicPageViewIPCProxy", "pushData %s", eVar2.field_id);
        com.tencent.mm.plugin.appbrand.dynamic.f.c cVar = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
        cVar.data = eVar2.field_data;
        eVar.a(cVar, new ValueCallback<String>() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.c.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(121146);
                u.i("MicroMsg.DynamicPageViewIPCProxy", "onDataPush event dispatch result %s", str);
                AppMethodBeat.o(121146);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", eVar2.field_id);
        bundle.putString("respData", eVar2.field_data);
        String Yn = i.bBL().Yn(eVar2.field_id);
        u.i("MicroMsg.DynamicPageViewIPCProxy", "dispatch onDataPush event to view proce %s", Yn);
        if (Yn == null) {
            ToolsProcessIPCService.a(bundle, a.class);
            AppMethodBeat.o(121153);
            return;
        }
        h.a(Yn, bundle, a.class, null);
        AppMethodBeat.o(121153);
    }

    public final void H(Bundle bundle) {
        AppMethodBeat.i(121154);
        if (bundle == null) {
            AppMethodBeat.o(121154);
            return;
        }
        if (this.hpm != null) {
            ad.b ayQ = this.hpm.ayQ();
            if (ayQ == null) {
                AppMethodBeat.o(121154);
                return;
            }
            Set<String> keySet = bundle.keySet();
            if (keySet == null || ayQ == null) {
                AppMethodBeat.o(121154);
                return;
            }
            for (String str : keySet) {
                ayQ.l(str, bundle.get(str));
            }
        }
        AppMethodBeat.o(121154);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final void onResume() {
        AppMethodBeat.i(121155);
        Log.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", this.gIx);
        boolean z = this.llM;
        if (this.hpm != null) {
            this.hpm.b(new g());
        }
        this.llM = false;
        boolean z2 = this.llN;
        this.llN = false;
        if (z2 && this.llO) {
            bBG();
        }
        AppMethodBeat.o(121155);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final boolean isPaused() {
        return this.llM;
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            IPCDynamicPageView YC;
            AppMethodBeat.i(121147);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("widgetId");
            String string2 = bundle2.getString("respData");
            if (!Util.isNullOrNil(string) && (YC = com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk().YC(string)) != null) {
                AnonymousClass1 r3 = new t() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.c.a.AnonymousClass1 */

                    @Override // com.tencent.mm.modelappbrand.t
                    public final void b(boolean z, String str, Bundle bundle) {
                    }
                };
                if (YC.lpO == null) {
                    r3.b(false, "listener is null", null);
                    AppMethodBeat.o(121147);
                    return;
                }
                ae aeVar = (ae) YC.lpO.LA("OnDataPush");
                if (aeVar == null) {
                    r3.b(false, "listener is null", null);
                    AppMethodBeat.o(121147);
                    return;
                }
                aeVar.aX(string, string2);
            }
            AppMethodBeat.o(121147);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            IPCDynamicPageView YC;
            aa aaVar;
            AppMethodBeat.i(121148);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("widgetId");
            String string2 = bundle2.getString("data");
            String string3 = bundle2.getString(NativeProtocol.WEB_DIALOG_ACTION);
            if (!(Util.isNullOrNil(string) || (YC = com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk().YC(string)) == null || !"onWidgetJsError".equals(string3) || YC.lpO == null || (aaVar = (aa) YC.lpO.LA("onWxaWidgetJsError")) == null)) {
                aaVar.Lz(string2);
            }
            AppMethodBeat.o(121148);
        }
    }
}
