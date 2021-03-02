package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.util.SparseArray;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication;
import com.tencent.mm.plugin.appbrand.jsapi.p.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", i.NAME, "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "CallbackContext", "Companion", "plugin-appbrand-integration_release"})
final class q implements o {
    @Deprecated
    public static final b naJ = new b((byte) 0);
    private int naH;
    private final SparseArray<a> naI = new SparseArray<>();
    private final l nas;

    static {
        AppMethodBeat.i(228847);
        AppMethodBeat.o(228847);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public q(l lVar) {
        p.h(lVar, "runtime");
        AppMethodBeat.i(228846);
        this.nas = lVar;
        AppMethodBeat.o(228846);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x014d  */
    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void acv(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 354
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.q.acv(java.lang.String):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o
    public final void a(p pVar, int i2, String str) {
        AppMethodBeat.i(228843);
        p.h(pVar, "component");
        p.h(str, "data");
        a aVar = this.naI.get(i2, null);
        if (aVar instanceof a.C0750a) {
            this.naI.remove(i2);
            ep(((a.C0750a) aVar).les, str);
            AppMethodBeat.o(228843);
            return;
        }
        if (aVar instanceof a.b) {
            this.naI.remove(i2);
            Activity context = this.nas.getContext();
            if (context != null) {
                context.moveTaskToBack(true);
            }
            this.nas.finish();
        }
        AppMethodBeat.o(228843);
    }

    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o
    public final void b(p pVar, int i2, String str) {
        AppMethodBeat.i(228844);
        p.h(pVar, "component");
        p.h(str, "callbackStr");
        Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + i2 + "), callbackStr(" + str + ')');
        a(pVar, i2, str);
        AppMethodBeat.o(228844);
    }

    private final void ep(String str, String str2) {
        AppMethodBeat.i(228845);
        Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.LegacySDKInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + str2 + ')');
        this.naH++;
        int i2 = this.naH;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", str2);
        jSONObject2.put("transitiveData", str);
        jSONObject.put("extraData", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        p.g(jSONObject3, "JSONObject().apply {\n   …   )\n        }.toString()");
        this.naI.put(i2, a.b.naK);
        this.nas.bsE().y(JsApiNavigateBackApplication.NAME, jSONObject3, i2);
        AppMethodBeat.o(228845);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "", "()V", "InvokeCallbackContext", "NavigateBackCallbackContext", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "plugin-appbrand-integration_release"})
    public static abstract class a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "transitiveData", "", "(Ljava/lang/String;)V", "getTransitiveData", "()Ljava/lang/String;", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.q$a$a  reason: collision with other inner class name */
        public static final class C0750a extends a {
            final String les;

            public final boolean equals(Object obj) {
                AppMethodBeat.i(228840);
                if (this == obj || ((obj instanceof C0750a) && p.j(this.les, ((C0750a) obj).les))) {
                    AppMethodBeat.o(228840);
                    return true;
                }
                AppMethodBeat.o(228840);
                return false;
            }

            public final int hashCode() {
                AppMethodBeat.i(228839);
                String str = this.les;
                if (str != null) {
                    int hashCode = str.hashCode();
                    AppMethodBeat.o(228839);
                    return hashCode;
                }
                AppMethodBeat.o(228839);
                return 0;
            }

            public final String toString() {
                AppMethodBeat.i(228838);
                String str = "InvokeCallbackContext(transitiveData=" + this.les + ")";
                AppMethodBeat.o(228838);
                return str;
            }

            public C0750a(String str) {
                super((byte) 0);
                this.les = str;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "()V", "plugin-appbrand-integration_release"})
        public static final class b extends a {
            public static final b naK = new b();

            static {
                AppMethodBeat.i(228841);
                AppMethodBeat.o(228841);
            }

            private b() {
                super((byte) 0);
            }
        }
    }
}
