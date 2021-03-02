package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class JsApiAppBrandNFCBase extends d {
    a mgX = null;

    public interface a {
        void A(int i2, String str);
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        this.mgX = aVar;
        CheckIsSupportHCETask checkIsSupportHCETask = new CheckIsSupportHCETask(this);
        checkIsSupportHCETask.bDJ();
        AppBrandMainProcessService.a(checkIsSupportHCETask);
    }

    static class CheckIsSupportHCETask extends MainProcessTask {
        public static final Parcelable.Creator<CheckIsSupportHCETask> CREATOR = new Parcelable.Creator<CheckIsSupportHCETask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.CheckIsSupportHCETask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CheckIsSupportHCETask[] newArray(int i2) {
                return new CheckIsSupportHCETask[0];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckIsSupportHCETask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(136094);
                CheckIsSupportHCETask checkIsSupportHCETask = new CheckIsSupportHCETask(parcel);
                AppMethodBeat.o(136094);
                return checkIsSupportHCETask;
            }
        };
        private int errCode;
        private String errMsg;
        private JsApiAppBrandNFCBase mgY = null;

        public CheckIsSupportHCETask(JsApiAppBrandNFCBase jsApiAppBrandNFCBase) {
            this.mgY = jsApiAppBrandNFCBase;
        }

        public CheckIsSupportHCETask(Parcel parcel) {
            AppMethodBeat.i(136095);
            f(parcel);
            AppMethodBeat.o(136095);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(136096);
            if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHX()) {
                this.errCode = 13000;
                this.errMsg = "not support NFC";
            } else if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHW()) {
                this.errCode = 13002;
                this.errMsg = "not support HCE";
            } else {
                this.errCode = 0;
                this.errMsg = "support HCE and system NFC switch is opened";
            }
            bDU();
            AppMethodBeat.o(136096);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(136097);
            super.bjk();
            bDK();
            if (this.mgY != null) {
                JsApiAppBrandNFCBase jsApiAppBrandNFCBase = this.mgY;
                int i2 = this.errCode;
                String str = this.errMsg;
                Log.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
                if (i2 != 0) {
                    if (Util.isNullOrNil(str)) {
                        str = "unknown error";
                    }
                    if (jsApiAppBrandNFCBase.mgX != null) {
                        jsApiAppBrandNFCBase.mgX.A(i2, str);
                    }
                } else if (jsApiAppBrandNFCBase.mgX != null) {
                    jsApiAppBrandNFCBase.mgX.A(i2, str);
                    AppMethodBeat.o(136097);
                    return;
                }
            }
            AppMethodBeat.o(136097);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public int describeContents() {
            AppMethodBeat.i(136098);
            int describeContents = super.describeContents();
            AppMethodBeat.o(136098);
            return describeContents;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(136099);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.errMsg);
            AppMethodBeat.o(136099);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(136100);
            super.f(parcel);
            this.errCode = parcel.readInt();
            this.errMsg = parcel.readString();
            AppMethodBeat.o(136100);
        }

        static {
            AppMethodBeat.i(136101);
            AppMethodBeat.o(136101);
        }
    }
}
