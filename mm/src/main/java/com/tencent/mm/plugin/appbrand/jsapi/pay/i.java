package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.e.f.h;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.ui.e;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "REQUEST_FACE_TO_FACE_PAYMENT_RESULT_CODE", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"})
public final class i extends d<c> {
    public static final int CTRL_INDEX = 820;
    public static final String NAME = "requestFacetoFacePayment";
    public static final a mmp = new a((byte) 0);
    private final int mmo = com.tencent.luggage.sdk.g.a.aK(this);

    static {
        AppMethodBeat.i(228444);
        AppMethodBeat.o(228444);
    }

    public i() {
        AppMethodBeat.i(228443);
        AppMethodBeat.o(228443);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(228442);
        c cVar2 = cVar;
        if (cVar2 == null) {
            AppMethodBeat.o(228442);
        } else if (cVar2.getRuntime() == null) {
            cVar2.i(i2, Zf("fail:internal error"));
            AppMethodBeat.o(228442);
        } else if (jSONObject == null) {
            cVar2.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(228442);
        } else {
            String optString = jSONObject.optString("confirm_token");
            if (TextUtils.isEmpty(optString)) {
                cVar2.i(i2, Zf("fail:confirm_token is empty"));
                AppMethodBeat.o(228442);
                return;
            }
            Intent intent = new Intent();
            q runtime = cVar2.getRuntime();
            p.g(runtime, "env.runtime");
            intent.putExtra("key_app_id", runtime.getAppId());
            intent.putExtra("key_confirm_id", optString);
            f.aK(cVar2.getContext()).b(new b(this, new WeakReference(cVar2), i2));
            com.tencent.mm.br.c.b(cVar2.getContext(), "remittance", ".ui.F2FAppBrandRemittanceUI", intent, this.mmo);
            AppMethodBeat.o(228442);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment$invoke$3", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultInterceptCallback;", "onResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
    public static final class b implements f.c {
        final /* synthetic */ int lyo;
        final /* synthetic */ i mmq;
        final /* synthetic */ WeakReference mmr;

        b(i iVar, WeakReference weakReference, int i2) {
            this.mmq = iVar;
            this.mmr = weakReference;
            this.lyo = i2;
        }

        @Override // com.tencent.luggage.h.f.c
        public final boolean c(int i2, int i3, Intent intent) {
            e.f.a aVar;
            String str;
            String str2;
            boolean z = false;
            AppMethodBeat.i(228441);
            if (this.mmq.mmo != i2) {
                AppMethodBeat.o(228441);
                return false;
            }
            c cVar = (c) this.mmr.get();
            if (cVar == null) {
                AppMethodBeat.o(228441);
                return true;
            }
            p.g(cVar, "envRef.get() ?: return true");
            if (intent == null || (aVar = intent.getSerializableExtra("key_result_pay_result")) == null) {
                aVar = e.f.a.FAIL;
            }
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.ConstantsUI.F2FAppBrandRemittanceUI.RESULT_TYPE");
                AppMethodBeat.o(228441);
                throw tVar;
            }
            e.f.a aVar2 = (e.f.a) aVar;
            if (intent == null || (str = intent.getStringExtra("key_result_error_msg")) == null) {
                str = "";
            }
            new StringBuilder("[onResult] result=").append(aVar2).append(", errorMsg").append(str);
            h.hkS();
            int i4 = this.lyo;
            i iVar = this.mmq;
            switch (j.$EnumSwitchMapping$0[aVar2.ordinal()]) {
                case 1:
                    str2 = "ok";
                    break;
                case 2:
                    if (str.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        str2 = "fail:".concat(String.valueOf(str));
                        break;
                    } else {
                        str2 = "fail";
                        break;
                    }
                case 3:
                    str2 = "cancel";
                    break;
                default:
                    m mVar = new m();
                    AppMethodBeat.o(228441);
                    throw mVar;
            }
            cVar.i(i4, iVar.Zf(str2));
            AppMethodBeat.o(228441);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
