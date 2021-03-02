package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b;
import com.tencent.mm.sdk.platformtools.Log;

public class HCEEventLogic {
    private static String mgS = null;
    private static boolean mgT = true;
    private static h.c mgU = new h.c() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void onCreate() {
            AppMethodBeat.i(136079);
            Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onCreate");
            super.onCreate();
            HCEEventLogic.a(HCEEventLogic.mgS, 21, null);
            AppMethodBeat.o(136079);
        }

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void onResume() {
            AppMethodBeat.i(136080);
            Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onResume");
            super.onResume();
            HCEEventLogic.a(HCEEventLogic.mgS, 22, null);
            AppMethodBeat.o(136080);
        }

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void a(h.d dVar) {
            AppMethodBeat.i(136081);
            Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onPause");
            super.a(dVar);
            HCEEventLogic.a(HCEEventLogic.mgS, 23, null);
            AppMethodBeat.o(136081);
        }

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void onDestroy() {
            AppMethodBeat.i(136082);
            Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onDestroy");
            super.onDestroy();
            HCEEventLogic.a(HCEEventLogic.mgS, 24, null);
            AppMethodBeat.o(136082);
        }
    };

    static {
        AppMethodBeat.i(136093);
        AppMethodBeat.o(136093);
    }

    public static void aau(String str) {
        AppMethodBeat.i(136090);
        if (!(mgS == null || mgU == null)) {
            Log.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", mgS);
            h.b(mgS, mgU);
        }
        mgS = str;
        h.a(str, mgU);
        AppMethodBeat.o(136090);
    }

    public static void aav(String str) {
        AppMethodBeat.i(136091);
        if (str != null) {
            h.b(str, mgU);
        }
        AppMethodBeat.o(136091);
    }

    public static void hI(boolean z) {
        synchronized (HCEEventLogic.class) {
            mgT = z;
        }
    }

    public static boolean bHI() {
        boolean z;
        synchronized (HCEEventLogic.class) {
            z = mgT;
        }
        return z;
    }

    public static void a(String str, int i2, Bundle bundle) {
        AppMethodBeat.i(136092);
        if (bundle == null) {
            bundle = new Bundle();
        }
        Log.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", str, Integer.valueOf(i2));
        SendHCEEventToMMTask sendHCEEventToMMTask = new SendHCEEventToMMTask(str, i2, bundle, (byte) 0);
        sendHCEEventToMMTask.bDJ();
        AppBrandMainProcessService.a(sendHCEEventToMMTask);
        AppMethodBeat.o(136092);
    }

    /* access modifiers changed from: package-private */
    public static class SendHCEEventToMMTask extends MainProcessTask {
        public static final Parcelable.Creator<SendHCEEventToMMTask> CREATOR = new Parcelable.Creator<SendHCEEventToMMTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.SendHCEEventToMMTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SendHCEEventToMMTask[] newArray(int i2) {
                return new SendHCEEventToMMTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SendHCEEventToMMTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(136083);
                SendHCEEventToMMTask sendHCEEventToMMTask = new SendHCEEventToMMTask(parcel);
                AppMethodBeat.o(136083);
                return sendHCEEventToMMTask;
            }
        };
        private String appId;
        private int mgV;
        private Bundle mgW;

        /* synthetic */ SendHCEEventToMMTask(String str, int i2, Bundle bundle, byte b2) {
            this(str, i2, bundle);
        }

        private SendHCEEventToMMTask(String str, int i2, Bundle bundle) {
            this.mgV = i2;
            this.appId = str;
            this.mgW = bundle;
        }

        protected SendHCEEventToMMTask(Parcel parcel) {
            AppMethodBeat.i(136084);
            f(parcel);
            AppMethodBeat.o(136084);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(136085);
            Log.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
            b.mhH.a(this.mgV, this.appId, this.mgW);
            bDU();
            AppMethodBeat.o(136085);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(136086);
            super.bjk();
            bDK();
            AppMethodBeat.o(136086);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(136087);
            super.f(parcel);
            this.mgV = parcel.readInt();
            this.appId = parcel.readString();
            this.mgW = parcel.readBundle();
            AppMethodBeat.o(136087);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(136088);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.mgV);
            parcel.writeString(this.appId);
            parcel.writeBundle(this.mgW);
            AppMethodBeat.o(136088);
        }

        static {
            AppMethodBeat.i(136089);
            AppMethodBeat.o(136089);
        }
    }
}
