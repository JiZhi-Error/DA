package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class JsApiMMTask extends MainProcessTask {
    public static final Parcelable.Creator<JsApiMMTask> CREATOR = new Parcelable.Creator<JsApiMMTask>() {
        /* class com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ JsApiMMTask[] newArray(int i2) {
            return new JsApiMMTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ JsApiMMTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(78496);
            JsApiMMTask jsApiMMTask = new JsApiMMTask(parcel, (byte) 0);
            AppMethodBeat.o(78496);
            return jsApiMMTask;
        }
    };
    public b.a IVw;
    public String IVx;
    public String IVy;
    public String errMsg;
    public String lEA;

    /* synthetic */ JsApiMMTask(Parcel parcel, byte b2) {
        this(parcel);
    }

    static /* synthetic */ boolean a(JsApiMMTask jsApiMMTask) {
        AppMethodBeat.i(78502);
        boolean bDU = jsApiMMTask.bDU();
        AppMethodBeat.o(78502);
        return bDU;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(78497);
        try {
            ((br) Class.forName(this.IVx).newInstance()).a(MMApplicationContext.getContext(), this.lEA, new br.a() {
                /* class com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br.a
                public final void i(String str, JSONObject jSONObject) {
                    AppMethodBeat.i(78495);
                    JsApiMMTask.this.errMsg = str;
                    if (jSONObject != null) {
                        JsApiMMTask.this.IVy = jSONObject.toString();
                    }
                    JsApiMMTask.a(JsApiMMTask.this);
                    AppMethodBeat.o(78495);
                }
            });
            AppMethodBeat.o(78497);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.JsApiMMTask", e2, "runInMainProcess fail.", new Object[0]);
            AppMethodBeat.o(78497);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(78498);
        bDK();
        if (this.IVw != null) {
            try {
                this.IVw.c(this.errMsg, new JSONObject(this.IVy));
                AppMethodBeat.o(78498);
                return;
            } catch (Exception e2) {
                this.IVw.c(this.errMsg, null);
                Log.printErrStackTrace("MicroMsg.JsApiMMTask", e2, "runInClientProcess fail.", new Object[0]);
            }
        }
        AppMethodBeat.o(78498);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(78499);
        this.lEA = parcel.readString();
        this.IVx = parcel.readString();
        this.errMsg = parcel.readString();
        this.IVy = parcel.readString();
        AppMethodBeat.o(78499);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(78500);
        parcel.writeString(this.lEA);
        parcel.writeString(this.IVx);
        parcel.writeString(this.errMsg);
        parcel.writeString(this.IVy);
        AppMethodBeat.o(78500);
    }

    public JsApiMMTask() {
    }

    private JsApiMMTask(Parcel parcel) {
        AppMethodBeat.i(78501);
        f(parcel);
        AppMethodBeat.o(78501);
    }

    static {
        AppMethodBeat.i(78503);
        AppMethodBeat.o(78503);
    }
}
