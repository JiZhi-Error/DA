package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "WebPagePrefetchTask", "plugin-appbrand-integration_release"})
public final class JsApiOnWebPageUrlExposed extends d<f> {
    public static final int CTRL_INDEX = 865;
    public static final String NAME = "private_onWebPageUrlExposed";
    public static final a lAI = new a((byte) 0);

    static {
        AppMethodBeat.i(228294);
        AppMethodBeat.o(228294);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(228293);
        Log.d("MicroMsg.JsApiOnWebPageUrlExposed", "invoke");
        String optString = jSONObject != null ? jSONObject.optString("urlList") : null;
        if (Util.isNullOrNil(optString)) {
            Log.i("MicroMsg.JsApiOnWebPageUrlExposed", "fail:urlList is null");
            if (fVar != null) {
                fVar.i(i2, Zf("fail:urlList is null"));
                AppMethodBeat.o(228293);
                return;
            }
            AppMethodBeat.o(228293);
            return;
        }
        WebPagePrefetchTask webPagePrefetchTask = new WebPagePrefetchTask(this, fVar, i2, optString);
        webPagePrefetchTask.bDJ();
        webPagePrefetchTask.bjm();
        AppMethodBeat.o(228293);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u0005¢\u0006\u0002\u0010\u000eJ\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", ProviderConstants.API_PATH, "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "urlListStr", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;ILjava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "errMsg", "jsApi", "success", "", "describeContents", "doOnWebPageUrlExposed", "", "parseFromParcel", LocaleUtil.INDONESIAN_NEWNAME, "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    static final class WebPagePrefetchTask extends MainProcessTask {
        public static final a CREATOR = new a((byte) 0);
        private String errMsg;
        private String lAJ;
        private int lqe;
        private p lqf;
        private f lqg;
        private boolean success;

        static {
            AppMethodBeat.i(228292);
            AppMethodBeat.o(228292);
        }

        public WebPagePrefetchTask() {
        }

        public WebPagePrefetchTask(p pVar, f fVar, int i2, String str) {
            this();
            this.lqf = pVar;
            this.lqg = fVar;
            this.lqe = i2;
            this.lAJ = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public WebPagePrefetchTask(Parcel parcel) {
            this();
            boolean z = true;
            p.h(parcel, "parcel");
            AppMethodBeat.i(228291);
            this.lAJ = parcel.readString();
            this.success = parcel.readInt() != 1 ? false : z;
            AppMethodBeat.o(228291);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(228287);
            this.success = false;
            if (Util.isNullOrNil(this.lAJ)) {
                this.errMsg = "fail:urlList is null";
                Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
            } else {
                ArrayList arrayList = new ArrayList();
                try {
                    f fVar = new f(this.lAJ);
                    if (fVar.length() <= 0) {
                        this.errMsg = "fail:urlList is decode array fail";
                        Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
                    } else {
                        int length = fVar.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            i pZ = fVar.pZ(i2);
                            String optString = pZ.optString("url");
                            if (optString == null || !n.aL(optString)) {
                                int optInt = pZ.optInt("bizScene");
                                String optString2 = pZ.optString(IssueStorage.COLUMN_EXT_INFO);
                                e.a aVar = new e.a();
                                aVar.url = optString;
                                aVar.extInfo = optString2;
                                aVar.pmM = TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
                                aVar.pmN = optInt;
                                arrayList.add(aVar);
                            } else {
                                Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", "decode url is empty");
                            }
                        }
                        if (arrayList.isEmpty()) {
                            this.errMsg = "fail:decode list is empty";
                            Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
                        } else {
                            ((e) g.af(e.class)).cu(arrayList);
                            this.errMsg = "ok";
                            this.success = true;
                        }
                    }
                } catch (Exception e2) {
                    this.errMsg = "fail:parse error";
                    Log.i("MicroMsg.JsApiOnWebPageUrlExposed.WebPagePrefetchTask", this.errMsg);
                }
            }
            bDU();
            AppMethodBeat.o(228287);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String str = null;
            AppMethodBeat.i(228288);
            super.bjk();
            bDK();
            if (this.success) {
                f fVar = this.lqg;
                if (fVar != null) {
                    int i2 = this.lqe;
                    p pVar = this.lqf;
                    if (pVar != null) {
                        String str2 = this.errMsg;
                        if (str2 == null) {
                            str2 = "ok";
                        }
                        str = pVar.Zf(str2);
                    }
                    fVar.i(i2, str);
                    AppMethodBeat.o(228288);
                    return;
                }
                AppMethodBeat.o(228288);
                return;
            }
            f fVar2 = this.lqg;
            if (fVar2 != null) {
                int i3 = this.lqe;
                p pVar2 = this.lqf;
                if (pVar2 != null) {
                    String str3 = this.errMsg;
                    if (str3 == null) {
                        str3 = "fail";
                    }
                    str = pVar2.Zf(str3);
                }
                fVar2.i(i3, str);
                AppMethodBeat.o(228288);
                return;
            }
            AppMethodBeat.o(228288);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(228289);
            super.f(parcel);
            this.lAJ = parcel != null ? parcel.readString() : null;
            this.success = parcel != null && parcel.readInt() == 1;
            AppMethodBeat.o(228289);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(228290);
            p.h(parcel, "parcel");
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.lAJ);
            parcel.writeInt(this.success ? 1 : 0);
            AppMethodBeat.o(228290);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "()V", "TAG", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOnWebPageUrlExposed$WebPagePrefetchTask;", "plugin-appbrand-integration_release"})
        public static final class a implements Parcelable.Creator<WebPagePrefetchTask> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WebPagePrefetchTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(228286);
                p.h(parcel, "parcel");
                WebPagePrefetchTask webPagePrefetchTask = new WebPagePrefetchTask(parcel);
                AppMethodBeat.o(228286);
                return webPagePrefetchTask;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WebPagePrefetchTask[] newArray(int i2) {
                return new WebPagePrefetchTask[i2];
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final int describeContents() {
            return 0;
        }
    }
}
