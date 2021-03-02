package com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0002J%\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u0010\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "operateType", "", "callback", "", "env", "callbackId", "", "resultJson", "getChannelFeeds", "invoke", "data", "Lorg/json/JSONObject;", "updateChannelFeeds", "Companion", "GetChannelFeedsTask", "UpdateChannelFeedsTask", "plugin-appbrand-integration_release"})
public final class JsApiHandleMpChannelAction extends d<f> {
    private static final int CTRL_INDEX = CTRL_INDEX;
    private static final String NAME = NAME;
    public static final a lKE = new a((byte) 0);
    private String lKD = "";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "OPERATE_TYPE_GET", "OPERATE_TYPE_UPDATE", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(175154);
        AppMethodBeat.o(175154);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        String str;
        AppMethodBeat.i(175152);
        if (jSONObject == null || (str = jSONObject.optString("operateType")) == null) {
            str = "";
        }
        this.lKD = str;
        Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType: %s", this.lKD);
        if (this.lKD.length() == 0) {
            Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType empty");
            String Zf = Zf("fail: operationType empty");
            p.g(Zf, "makeReturnJson(\"fail: operationType empty\")");
            a(fVar, i2, Zf);
            AppMethodBeat.o(175152);
        } else if (this.lKD.equals("getChannelFeeds")) {
            Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds");
            GetChannelFeedsTask getChannelFeedsTask = new GetChannelFeedsTask(this, fVar, i2);
            getChannelFeedsTask.bDJ();
            getChannelFeedsTask.bjm();
            AppMethodBeat.o(175152);
        } else if (this.lKD.equals("updateChannelFeeds")) {
            Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds");
            UpdateChannelFeedsTask updateChannelFeedsTask = new UpdateChannelFeedsTask(fVar);
            updateChannelFeedsTask.bDJ();
            updateChannelFeedsTask.bjm();
            String Zf2 = Zf("ok");
            p.g(Zf2, "makeReturnJson(\"ok\")");
            a(fVar, i2, Zf2);
            AppMethodBeat.o(175152);
        } else {
            Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo handleMPChannelAction operateType invalid");
            String Zf3 = Zf("fail: operationType error");
            p.g(Zf3, "makeReturnJson(\"fail: operationType error\")");
            a(fVar, i2, Zf3);
            AppMethodBeat.o(175152);
        }
    }

    private static void a(f fVar, int i2, String str) {
        AppMethodBeat.i(175153);
        if (fVar != null) {
            fVar.i(i2, str);
            AppMethodBeat.o(175153);
            return;
        }
        AppMethodBeat.o(175153);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", ProviderConstants.API_PATH, "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "channelFeedsData", "", "jsapi", "describeContents", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    static final class GetChannelFeedsTask extends MainProcessTask {
        public static final a CREATOR = new a((byte) 0);
        private f lAx;
        private String lKF;
        private com.tencent.mm.plugin.appbrand.jsapi.p lKG;
        private int lqe;

        static {
            AppMethodBeat.i(175141);
            AppMethodBeat.o(175141);
        }

        public GetChannelFeedsTask() {
            this.lKF = "";
        }

        public GetChannelFeedsTask(com.tencent.mm.plugin.appbrand.jsapi.p pVar, f fVar, int i2) {
            this.lKF = "";
            this.lKG = pVar;
            this.lAx = fVar;
            this.lqe = i2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public GetChannelFeedsTask(Parcel parcel) {
            this();
            p.h(parcel, "parcel");
            AppMethodBeat.i(175140);
            f(parcel);
            AppMethodBeat.o(175140);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(175136);
            String cli = ((b) g.af(b.class)).cli();
            p.g(cli, "MMKernel.service(IBrandS…s.java).getChannelFeeds()");
            this.lKF = cli;
            Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo GetChannelFeedsTask channelFeedsData: %s", this.lKF);
            bDU();
            AppMethodBeat.o(175136);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String str;
            String str2 = null;
            AppMethodBeat.i(175137);
            super.bjk();
            bDK();
            if (this.lKF.length() == 0) {
                Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds error: data empty");
                f fVar = this.lAx;
                if (fVar != null) {
                    int i2 = this.lqe;
                    com.tencent.mm.plugin.appbrand.jsapi.p pVar = this.lKG;
                    if (pVar != null) {
                        str = pVar.Zf("fail: no channel feeds");
                    } else {
                        str = null;
                    }
                    fVar.i(i2, str);
                    AppMethodBeat.o(175137);
                    return;
                }
                AppMethodBeat.o(175137);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 0);
            hashMap.put("channelFeedsData", this.lKF);
            Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo getChannelFeeds success");
            f fVar2 = this.lAx;
            if (fVar2 != null) {
                int i3 = this.lqe;
                com.tencent.mm.plugin.appbrand.jsapi.p pVar2 = this.lKG;
                if (pVar2 != null) {
                    str2 = pVar2.n("ok", hashMap);
                }
                fVar2.i(i3, str2);
                AppMethodBeat.o(175137);
                return;
            }
            AppMethodBeat.o(175137);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            String str;
            AppMethodBeat.i(175138);
            super.f(parcel);
            if (parcel == null || (str = parcel.readString()) == null) {
                str = "";
            }
            this.lKF = str;
            AppMethodBeat.o(175138);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(175139);
            p.h(parcel, "parcel");
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.lKF);
            AppMethodBeat.o(175139);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$GetChannelFeedsTask;", "plugin-appbrand-integration_release"})
        public static final class a implements Parcelable.Creator<GetChannelFeedsTask> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetChannelFeedsTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(175135);
                p.h(parcel, "parcel");
                GetChannelFeedsTask getChannelFeedsTask = new GetChannelFeedsTask(parcel);
                AppMethodBeat.o(175135);
                return getChannelFeedsTask;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetChannelFeedsTask[] newArray(int i2) {
                return new GetChannelFeedsTask[i2];
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "channelFeedsData", "", "success", "", "describeContents", "", "parseFromParcel", "", "src", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    static final class UpdateChannelFeedsTask extends MainProcessTask {
        public static final a CREATOR = new a((byte) 0);
        private f lAx;
        private String lKF;
        private boolean success;

        static {
            AppMethodBeat.i(175150);
            AppMethodBeat.o(175150);
        }

        public static final /* synthetic */ boolean a(UpdateChannelFeedsTask updateChannelFeedsTask) {
            AppMethodBeat.i(175151);
            boolean bDU = updateChannelFeedsTask.bDU();
            AppMethodBeat.o(175151);
            return bDU;
        }

        public UpdateChannelFeedsTask() {
            this.lKF = "";
        }

        public UpdateChannelFeedsTask(f fVar) {
            this();
            this.lAx = fVar;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public UpdateChannelFeedsTask(Parcel parcel) {
            this();
            p.h(parcel, "parcel");
            AppMethodBeat.i(175149);
            f(parcel);
            AppMethodBeat.o(175149);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            String str;
            AppMethodBeat.i(175145);
            super.f(parcel);
            if (parcel == null || (str = parcel.readString()) == null) {
                str = "";
            }
            this.lKF = str;
            this.success = parcel != null && parcel.readInt() == 1;
            AppMethodBeat.o(175145);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask$runInMainProcess$1", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "channelFeeds", "plugin-appbrand-integration_release"})
        public static final class b implements b.AbstractC0862b {
            final /* synthetic */ UpdateChannelFeedsTask lKH;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            b(UpdateChannelFeedsTask updateChannelFeedsTask) {
                this.lKH = updateChannelFeedsTask;
            }

            @Override // com.tencent.mm.plugin.brandservice.a.b.AbstractC0862b
            public final void onSuccess(String str) {
                AppMethodBeat.i(175143);
                Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds onSuccess %s", str);
                UpdateChannelFeedsTask updateChannelFeedsTask = this.lKH;
                if (str == null) {
                    str = "";
                }
                updateChannelFeedsTask.lKF = str;
                this.lKH.success = true;
                UpdateChannelFeedsTask.a(this.lKH);
                AppMethodBeat.o(175143);
            }

            @Override // com.tencent.mm.plugin.brandservice.a.b.AbstractC0862b
            public final void p(int i2, int i3, String str) {
                AppMethodBeat.i(175144);
                Log.e("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds onFailed errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                this.lKH.success = false;
                UpdateChannelFeedsTask.a(this.lKH);
                AppMethodBeat.o(175144);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(175146);
            ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(new b(this));
            AppMethodBeat.o(175146);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(175147);
            super.bjk();
            bDK();
            Log.i("MicroMsg.JsApiHandleMpChannelAction", "alvinluo updateChannelFeeds end and dispatch onUpdateChannelFeeds, success: %b", Boolean.valueOf(this.success));
            a aVar = new a();
            f fVar = this.lAx;
            boolean z = this.success;
            String str = this.lKF;
            p.h(str, "channelFeedsData");
            Log.i("MicroMsg.JsApiEventOnUpdateChannelFeeds", "alvinluo onUpdateChannelFeeds dispatch success: %b, channelFeedsData: %s", Boolean.valueOf(z), str);
            HashMap hashMap = new HashMap();
            if (z) {
                if (str.length() > 0) {
                    hashMap.put("errCode", 0);
                    hashMap.put("errMsg", "ok");
                    hashMap.put("channelFeedsData", str);
                } else {
                    hashMap.put("errMsg", "no channel feeds");
                }
            } else {
                hashMap.put("errMsg", "update channel feeds failed");
            }
            aVar.h(fVar).L(hashMap).bEo();
            AppMethodBeat.o(175147);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(175148);
            p.h(parcel, "parcel");
            parcel.writeString(this.lKF);
            parcel.writeInt(this.success ? 1 : 0);
            AppMethodBeat.o(175148);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/bizvideochannel/JsApiHandleMpChannelAction$UpdateChannelFeedsTask;", "plugin-appbrand-integration_release"})
        public static final class a implements Parcelable.Creator<UpdateChannelFeedsTask> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ UpdateChannelFeedsTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(175142);
                p.h(parcel, "parcel");
                UpdateChannelFeedsTask updateChannelFeedsTask = new UpdateChannelFeedsTask(parcel);
                AppMethodBeat.o(175142);
                return updateChannelFeedsTask;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ UpdateChannelFeedsTask[] newArray(int i2) {
                return new UpdateChannelFeedsTask[i2];
            }
        }
    }
}
