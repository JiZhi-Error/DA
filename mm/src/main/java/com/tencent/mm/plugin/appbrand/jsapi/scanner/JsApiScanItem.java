package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J%\u0010\f\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "callbackId", "", "data", "", "service", "doScanItem", "", "extData", "invoke", "Lorg/json/JSONObject;", "onCallback", "errCode", "errMsg", "CheckScanItemTask", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiScanItem extends d<c> {
    private static final int CTRL_INDEX = CTRL_INDEX;
    private static final String NAME = NAME;
    public static final a mpQ = new a((byte) 0);
    private String data = "";
    private c liR;
    private int lqe;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "ErrCode", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        String str;
        boolean z;
        AppMethodBeat.i(228516);
        c cVar2 = cVar;
        Object[] objArr = new Object[1];
        objArr[0] = jSONObject != null ? jSONObject.toString() : null;
        Log.v("MicroMsg.JsApiScanItem", "scanItem data: %s", objArr);
        if (cVar2 == null) {
            AppMethodBeat.o(228516);
            return;
        }
        this.liR = cVar2;
        if (jSONObject == null || (str = jSONObject.optString("data")) == null) {
            str = "";
        }
        this.data = str;
        this.lqe = i2;
        if (this.data.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.e("MicroMsg.JsApiScanItem", "scanItem data is empty");
            cVar2.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(228516);
            return;
        }
        CheckScanItemTask checkScanItemTask = new CheckScanItemTask(this);
        checkScanItemTask.bDJ();
        checkScanItemTask.bjm();
        AppMethodBeat.o(228516);
    }

    static {
        AppMethodBeat.i(228517);
        AppMethodBeat.o(228517);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onResult"})
    public static final class b implements f.c {
        final /* synthetic */ int lyo;
        final /* synthetic */ JsApiScanItem mpT;
        final /* synthetic */ c mpU;

        b(JsApiScanItem jsApiScanItem, c cVar, int i2) {
            this.mpT = jsApiScanItem;
            this.mpU = cVar;
            this.lyo = i2;
        }

        @Override // com.tencent.luggage.h.f.c
        public final boolean c(int i2, int i3, Intent intent) {
            AppMethodBeat.i(228515);
            if (i2 != (this.mpT.hashCode() & 65535)) {
                AppMethodBeat.o(228515);
                return false;
            }
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Boolean.valueOf(intent != null);
            Log.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult requestCode: %d, resultCode: %d, data != null: %b", objArr);
            switch (i3) {
                case -1:
                    if (intent == null) {
                        this.mpU.i(this.lyo, this.mpT.Zf("fail"));
                        break;
                    } else {
                        HashMap hashMap = new HashMap();
                        String stringExtra = intent.getStringExtra("key_scan_goods_result_req_key");
                        Log.i("MicroMsg.JsApiScanItem", "alvinluo scanItem onResult reqKey: %s", stringExtra);
                        p.g(stringExtra, "reqKey");
                        hashMap.put("reqKey", stringExtra);
                        this.mpU.i(this.lyo, this.mpT.n("ok", hashMap));
                        break;
                    }
                case 0:
                    this.mpU.i(this.lyo, this.mpT.Zf("cancel"));
                    break;
                default:
                    this.mpU.i(this.lyo, this.mpT.Zf("fail"));
                    break;
            }
            AppMethodBeat.o(228515);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", ProviderConstants.API_PATH, "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem;)V", "inParcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "errMsg", "", "describeContents", "parseFromParcel", "", LocaleUtil.INDONESIAN_NEWNAME, "runInClientProcess", "runInMainProcess", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
    static final class CheckScanItemTask extends MainProcessTask {
        public static final Parcelable.Creator<CheckScanItemTask> CREATOR = new b();
        public static final a mpS = new a((byte) 0);
        private int errCode;
        private String errMsg = "";
        private JsApiScanItem mpR;

        public CheckScanItemTask(JsApiScanItem jsApiScanItem) {
            this.mpR = jsApiScanItem;
        }

        public CheckScanItemTask(Parcel parcel) {
            p.h(parcel, "inParcel");
            AppMethodBeat.i(228513);
            f(parcel);
            AppMethodBeat.o(228513);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(228508);
            Context context = MMApplicationContext.getContext();
            if (com.tencent.mm.q.a.o(context, false) || e.bgF() || com.tencent.mm.q.a.r(context, false)) {
                Log.e("MicroMsg.JsApiScanItem", "scanItem camera is using now, can not call scanItem");
                this.errCode = 1001;
                this.errMsg = "camera is using";
            } else {
                this.errCode = 0;
                this.errMsg = "ok";
            }
            bDU();
            AppMethodBeat.o(228508);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(228509);
            super.bjk();
            bDK();
            JsApiScanItem jsApiScanItem = this.mpR;
            if (jsApiScanItem != null) {
                JsApiScanItem.a(jsApiScanItem, this.errCode, this.errMsg);
                AppMethodBeat.o(228509);
                return;
            }
            AppMethodBeat.o(228509);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final int describeContents() {
            AppMethodBeat.i(228510);
            int describeContents = super.describeContents();
            AppMethodBeat.o(228510);
            return describeContents;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(228511);
            p.h(parcel, "dest");
            parcel.writeInt(this.errCode);
            parcel.writeString(this.errMsg);
            AppMethodBeat.o(228511);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(228512);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            this.errCode = parcel.readInt();
            String readString = parcel.readString();
            if (readString == null) {
                readString = "";
            }
            this.errMsg = readString;
            AppMethodBeat.o(228512);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/scanner/JsApiScanItem$CheckScanItemTask;", "plugin-appbrand-integration_release"})
        public static final class b implements Parcelable.Creator<CheckScanItemTask> {
            b() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckScanItemTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(228507);
                p.h(parcel, "source");
                CheckScanItemTask checkScanItemTask = new CheckScanItemTask(parcel);
                AppMethodBeat.o(228507);
                return checkScanItemTask;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CheckScanItemTask[] newArray(int i2) {
                return new CheckScanItemTask[i2];
            }
        }

        static {
            AppMethodBeat.i(228514);
            AppMethodBeat.o(228514);
        }
    }

    public static final /* synthetic */ void a(JsApiScanItem jsApiScanItem, int i2, String str) {
        AppMethodBeat.i(228518);
        Log.d("MicroMsg.JsApiScanItem", "scanItem onCallback errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
        if (i2 == 0) {
            c cVar = jsApiScanItem.liR;
            String str2 = jsApiScanItem.data;
            int i3 = jsApiScanItem.lqe;
            Activity btb = cVar != null ? cVar.btb() : null;
            if (btb != null) {
                f.aK(btb).b(new b(jsApiScanItem, cVar, i3));
                ScanGoodsRequest scanGoodsRequest = new ScanGoodsRequest();
                scanGoodsRequest.requestType = 2;
                scanGoodsRequest.CAM = 1;
                scanGoodsRequest.CAE = true;
                scanGoodsRequest.CAF = false;
                scanGoodsRequest.CAG = false;
                scanGoodsRequest.CAH = false;
                scanGoodsRequest.CAI = true;
                scanGoodsRequest.extInfo = str2;
                ((com.tencent.mm.plugin.scanner.api.c) g.af(com.tencent.mm.plugin.scanner.api.c.class)).a(btb, scanGoodsRequest, jsApiScanItem.hashCode() & 65535);
                AppMethodBeat.o(228518);
            } else if (cVar != null) {
                cVar.i(i3, jsApiScanItem.Zf("fail:internal error invalid android context"));
                AppMethodBeat.o(228518);
            } else {
                AppMethodBeat.o(228518);
            }
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i2));
            if (!(str.length() > 0)) {
                str = "unknown error";
            }
            c cVar2 = jsApiScanItem.liR;
            if (cVar2 != null) {
                cVar2.i(jsApiScanItem.lqe, jsApiScanItem.n("fail: ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.o(228518);
                return;
            }
            AppMethodBeat.o(228518);
        }
    }
}
