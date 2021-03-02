package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.sns.ad.i.g;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class a extends q {
    com.tencent.mm.plugin.sns.ad.landingpage.component.b.a Dtk;
    private com.tencent.mm.ui.base.q Dtl;

    public a(Context context, com.tencent.mm.plugin.sns.ad.landingpage.component.b.a aVar, ViewGroup viewGroup) {
        super(context, aVar, viewGroup);
        AppMethodBeat.i(201955);
        this.Dtk = aVar;
        try {
            if (!(this.Edn == null || this.Dtk == null)) {
                this.Edn.kv("appId", this.Dtk.couponAppId);
                this.Edn.kv("stockId", this.Dtk.couponStockId);
            }
            AppMethodBeat.o(201955);
        } catch (Throwable th) {
            AppMethodBeat.o(201955);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void hWL() {
        Bundle bundle;
        AppMethodBeat.i(259429);
        try {
            com.tencent.mm.plugin.sns.ad.remote.a aVar = new com.tencent.mm.plugin.sns.ad.remote.a();
            aVar.Dxn = new c();
            aVar.Dxm = new b(this);
            com.tencent.mm.plugin.sns.ad.remote.ipc.a eXy = aVar.eXy();
            if (eXy != null) {
                if (this.context instanceof Activity) {
                    Activity activity = (Activity) this.context;
                    if (!activity.isFinishing() && !activity.isDestroyed()) {
                        if (this.Dtl == null) {
                            this.Dtl = com.tencent.mm.plugin.sns.ad.landingpage.a.a.ap(this.context, R.string.h3z);
                        }
                        if (this.Dtl != null && !this.Dtl.isShowing()) {
                            this.Dtl.show();
                        }
                    }
                }
                com.tencent.mm.plugin.sns.ad.landingpage.component.b.a aVar2 = this.Dtk;
                if (aVar2 == null) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(aVar2.couponAppId)) {
                        bundle.putString("COUPON_APP_ID", aVar2.couponAppId);
                    }
                    if (!TextUtils.isEmpty(aVar2.couponStockId)) {
                        bundle.putString("COUPON_STOCK_ID", aVar2.couponStockId);
                    }
                    if (!TextUtils.isEmpty(aVar2.DZi)) {
                        bundle.putString("COMP_ID", aVar2.DZi);
                    }
                    ah fds = fds();
                    if (fds != null) {
                        String str = fds.DZW;
                        if (TextUtils.isEmpty(str)) {
                            str = fds.uxInfo;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            bundle.putString("UX_INFO", str);
                        }
                    }
                }
                eXy.aA(bundle);
                AppMethodBeat.o(259429);
                return;
            }
            Log.e("SnsAd.CouponCardBtnComp", "the ipc request object is null, please check the log to find the reason!");
            AppMethodBeat.o(259429);
        } catch (Throwable th) {
            AppMethodBeat.o(259429);
        }
    }

    private void cp(int i2, String str) {
        AppMethodBeat.i(201957);
        if (i2 == 0) {
            if (TextUtils.isEmpty(str)) {
                str = this.context.getString(R.string.h3j);
            }
            u.cG(this.context, str);
            AppMethodBeat.o(201957);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.context.getString(R.string.h3i);
        }
        u.cH(this.context, str);
        AppMethodBeat.o(201957);
    }

    static class b implements com.tencent.mm.plugin.sns.ad.remote.a.a {
        WeakReference<a> Dtm;

        b(a aVar) {
            AppMethodBeat.i(201951);
            this.Dtm = new WeakReference<>(aVar);
            AppMethodBeat.o(201951);
        }

        @Override // com.tencent.mm.plugin.sns.ad.remote.a.a
        @com.tencent.mm.plugin.sns.ad.remote.b
        public final void az(Bundle bundle) {
            a aVar;
            AppMethodBeat.i(201952);
            Log.d("SnsAd.CouponCardBtnComp", "the onCallbackFromServer running!");
            try {
                WeakReference<a> weakReference = this.Dtm;
                if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                    a.a(aVar, bundle);
                }
                AppMethodBeat.o(201952);
            } catch (Throwable th) {
                Log.d("SnsAd.CouponCardBtnComp", "there is something wrong in client!");
                AppMethodBeat.o(201952);
            }
        }
    }

    public static class c implements i, com.tencent.mm.plugin.sns.ad.remote.a.b {
        com.tencent.mm.plugin.sns.ad.remote.ipc.b Dtn;

        @Override // com.tencent.mm.plugin.sns.ad.remote.a.b
        public final Bundle a(com.tencent.mm.plugin.sns.ad.remote.ipc.b bVar, Bundle bundle) {
            AppMethodBeat.i(201953);
            try {
                String string = g.getString(bundle, "COUPON_APP_ID");
                String string2 = g.getString(bundle, "COUPON_STOCK_ID");
                String string3 = g.getString(bundle, "COMP_ID");
                String string4 = g.getString(bundle, "UX_INFO");
                this.Dtn = bVar;
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.kernel.g.azz().a(4743, this);
                com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.plugin.sns.ad.h.b(string, string2, string4, string3), 0);
                Log.d("SnsAd.CouponCardBtnComp", "CouponRemoteCall::the onServerCall is end, take time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            } catch (Throwable th) {
                Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onServerCall has something invalid!");
            }
            AppMethodBeat.o(201953);
            return null;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(201954);
            try {
                Bundle bundle = new Bundle();
                com.tencent.mm.kernel.g.azz().b(4743, this);
                if (i2 == 0 && i3 == 0 && (qVar instanceof com.tencent.mm.plugin.sns.ad.h.b)) {
                    bvk bvk = (bvk) ((com.tencent.mm.plugin.sns.ad.h.b) qVar).eXx();
                    if (bvk != null) {
                        bundle.putInt("ret", bvk.ret);
                        if (!TextUtils.isEmpty(bvk.msg)) {
                            bundle.putString("msg", bvk.msg);
                        }
                    } else {
                        Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onSceneEnd, the response is null!!!!");
                        bundle.putInt("call_ipc_result_key", -1);
                    }
                } else {
                    Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onSceneEnd is return error errType is " + i2 + ", the error code is " + i3);
                    bundle.putInt("call_ipc_result_key", -1);
                }
                if (this.Dtn != null) {
                    this.Dtn.aB(bundle);
                }
                AppMethodBeat.o(201954);
            } catch (Throwable th) {
                Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onSceneEnd has something invalid!");
                AppMethodBeat.o(201954);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ad.landingpage.component.a.a$a  reason: collision with other inner class name */
    public static class C1704a implements i.a {
        protected String adExtInfo;
        protected String appId;
        protected String dRS;
        protected String gTp;
        protected String msg;
        protected int result;
        protected int source;
        protected String uxInfo;

        protected C1704a(int i2, String str) {
            AppMethodBeat.i(201947);
            this.result = i2;
            this.msg = Util.nullAs(str, "");
            AppMethodBeat.o(201947);
        }

        private static String aNI(String str) {
            AppMethodBeat.i(201948);
            try {
                String Jb = r.Jb(k.aOa(str));
                AppMethodBeat.o(201948);
                return Jb;
            } catch (Throwable th) {
                AppMethodBeat.o(201948);
                return "";
            }
        }

        protected C1704a(a aVar, int i2, String str) {
            AppMethodBeat.i(201949);
            ah fds = aVar.fds();
            if (fds != null) {
                this.dRS = aNI(fds.getSnsId());
                this.adExtInfo = Util.nullAs(fds.adExtInfo, "");
                this.uxInfo = Util.nullAs(fds.DZW, "");
                if (TextUtils.isEmpty(this.uxInfo)) {
                    this.uxInfo = Util.nullAs(fds.uxInfo, "");
                }
            }
            com.tencent.mm.plugin.sns.ad.landingpage.component.b.a aVar2 = aVar.Dtk;
            if (aVar2 != null) {
                this.appId = aVar2.couponAppId;
                this.gTp = aVar2.couponStockId;
            }
            this.source = 0;
            this.result = i2;
            this.msg = Util.nullAs(str, "");
            AppMethodBeat.o(201949);
        }

        @Override // com.tencent.mm.plugin.sns.ad.i.i.a
        public final String eWH() {
            return "sns_ad_native_landing_page_coupon";
        }

        @Override // com.tencent.mm.plugin.sns.ad.i.i.a
        public final String getContent() {
            AppMethodBeat.i(201950);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("snsid", this.dRS);
                jSONObject.putOpt("uxinfo", this.uxInfo);
                jSONObject.putOpt("adExtInfo", this.adExtInfo);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.putOpt(IssueStorage.COLUMN_EXT_INFO, jSONObject2);
                try {
                    jSONObject2.putOpt("appId", this.appId);
                    jSONObject2.putOpt("stockId", this.gTp);
                    jSONObject2.putOpt("result", Integer.valueOf(this.result));
                    jSONObject2.putOpt("msg", this.msg);
                    jSONObject2.putOpt("source", Integer.valueOf(this.source));
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
            }
            String jSONObject3 = jSONObject.toString();
            AppMethodBeat.o(201950);
            return jSONObject3;
        }
    }

    static /* synthetic */ void a(a aVar, Bundle bundle) {
        AppMethodBeat.i(201958);
        try {
            if (aVar.Dtl != null && aVar.Dtl.isShowing()) {
                aVar.Dtl.dismiss();
            }
        } catch (Throwable th) {
        }
        if (bundle != null) {
            int i2 = g.getInt(bundle, "call_ipc_result_key", 0);
            Log.d("SnsAd.CouponCardBtnComp", "the value is ".concat(String.valueOf(i2)));
            if (i2 == 0) {
                int i3 = g.getInt(bundle, "ret", -1);
                String string = g.getString(bundle, "msg");
                Log.d("SnsAd.CouponCardBtnComp", "responseTo the msg is " + string + ", the ret is " + i3);
                aVar.cp(i3, string);
                com.tencent.mm.plugin.sns.ad.i.i.a(new C1704a(aVar, i3, string));
                AppMethodBeat.o(201958);
                return;
            }
            aVar.cp(-1, "");
            com.tencent.mm.plugin.sns.ad.i.i.a(new C1704a(aVar, -1, ""));
        }
        AppMethodBeat.o(201958);
    }
}
