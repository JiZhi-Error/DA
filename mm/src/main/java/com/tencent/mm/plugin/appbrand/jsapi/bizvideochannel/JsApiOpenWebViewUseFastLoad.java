package com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J%\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "callback", "", "env", "callbackId", "", "resultJson", "", "invoke", "data", "Lorg/json/JSONObject;", "Companion", "OpenWebViewUseFastLoad", "plugin-appbrand-integration_release"})
public final class JsApiOpenWebViewUseFastLoad extends d<f> {
    private static final int CTRL_INDEX = CTRL_INDEX;
    private static final String NAME = NAME;
    public static final a lKI = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(175164);
        AppMethodBeat.o(175164);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0111, code lost:
        if (r0 == null) goto L_0x0113;
     */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.f r9, org.json.JSONObject r10, int r11) {
        /*
        // Method dump skipped, instructions count: 352
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiOpenWebViewUseFastLoad.a(com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int):void");
    }

    private static void a(f fVar, int i2, String str) {
        AppMethodBeat.i(175163);
        if (fVar != null) {
            fVar.i(i2, str);
            AppMethodBeat.o(175163);
            return;
        }
        AppMethodBeat.o(175163);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B-\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0014\u001a\u00020\bH\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", ProviderConstants.API_PATH, "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "data", "Lorg/json/JSONObject;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILorg/json/JSONObject;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errMsg", "", "jsapi", "success", "", "describeContents", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    static final class OpenWebViewUseFastLoad extends MainProcessTask {
        public static final a CREATOR = new a((byte) 0);
        private String errMsg;
        private f lAx;
        private p lKG;
        private JSONObject lnV;
        private int lqe;
        private boolean success;

        static {
            AppMethodBeat.i(175161);
            AppMethodBeat.o(175161);
        }

        public OpenWebViewUseFastLoad() {
            this.errMsg = "";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public OpenWebViewUseFastLoad(Parcel parcel) {
            this();
            kotlin.g.b.p.h(parcel, "parcel");
            AppMethodBeat.i(175160);
            f(parcel);
            AppMethodBeat.o(175160);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            OpenWebViewUseFastLoad openWebViewUseFastLoad;
            String str;
            AppMethodBeat.i(175156);
            if (!((b) g.af(b.class)).CR(5)) {
                Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad abtest closed");
                this.success = false;
                this.errMsg = "abtest closed";
                bDU();
                AppMethodBeat.o(175156);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            ((b) g.af(b.class)).a(MMApplicationContext.getContext(), this.lnV, hashMap);
            this.success = kotlin.g.b.p.j(hashMap.get("success"), Boolean.TRUE);
            Object obj = hashMap.get("desc");
            if (obj != null) {
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(175156);
                    throw tVar;
                }
                String str2 = (String) obj;
                if (str2 != null) {
                    str = str2;
                    openWebViewUseFastLoad = this;
                    openWebViewUseFastLoad.errMsg = str;
                    bDU();
                    AppMethodBeat.o(175156);
                }
            }
            str = "";
            openWebViewUseFastLoad = this;
            openWebViewUseFastLoad.errMsg = str;
            bDU();
            AppMethodBeat.o(175156);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String str = null;
            AppMethodBeat.i(175157);
            super.bjk();
            bDK();
            if (this.success) {
                Log.i("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad success");
                f fVar = this.lAx;
                if (fVar != null) {
                    int i2 = this.lqe;
                    p pVar = this.lKG;
                    if (pVar != null) {
                        str = pVar.Zf("ok");
                    }
                    fVar.i(i2, str);
                    AppMethodBeat.o(175157);
                    return;
                }
                AppMethodBeat.o(175157);
                return;
            }
            Log.e("MicroMsg.JsApiOpenWebViewUseFastLoad", "alvinluo openWebViewUseFastLoad failed %s", this.errMsg);
            f fVar2 = this.lAx;
            if (fVar2 != null) {
                int i3 = this.lqe;
                p pVar2 = this.lKG;
                if (pVar2 != null) {
                    str = pVar2.Zf("failed: " + this.errMsg);
                }
                fVar2.i(i3, str);
                AppMethodBeat.o(175157);
                return;
            }
            AppMethodBeat.o(175157);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            String str;
            String str2;
            AppMethodBeat.i(175158);
            super.f(parcel);
            if (parcel == null || (str = parcel.readString()) == null) {
                str = "";
            }
            kotlin.g.b.p.g(str, "src?.readString() ?: \"\"");
            this.lnV = new JSONObject(str);
            this.success = parcel != null && parcel.readInt() == 1;
            if (parcel == null || (str2 = parcel.readString()) == null) {
                str2 = "";
            }
            this.errMsg = str2;
            AppMethodBeat.o(175158);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            String str;
            AppMethodBeat.i(175159);
            kotlin.g.b.p.h(parcel, "parcel");
            super.writeToParcel(parcel, i2);
            JSONObject jSONObject = this.lnV;
            if (jSONObject == null || (str = jSONObject.toString()) == null) {
                str = "";
            }
            parcel.writeString(str);
            parcel.writeInt(this.success ? 1 : 0);
            parcel.writeString(this.errMsg);
            AppMethodBeat.o(175159);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiOpenWebViewUseFastLoad$OpenWebViewUseFastLoad;", "plugin-appbrand-integration_release"})
        public static final class a implements Parcelable.Creator<OpenWebViewUseFastLoad> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OpenWebViewUseFastLoad createFromParcel(Parcel parcel) {
                AppMethodBeat.i(175155);
                kotlin.g.b.p.h(parcel, "parcel");
                OpenWebViewUseFastLoad openWebViewUseFastLoad = new OpenWebViewUseFastLoad(parcel);
                AppMethodBeat.o(175155);
                return openWebViewUseFastLoad;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OpenWebViewUseFastLoad[] newArray(int i2) {
                return new OpenWebViewUseFastLoad[i2];
            }
        }
    }
}
