package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;

public class ActiveMainProcessTask extends MainProcessTask {
    public static final Parcelable.Creator<ActiveMainProcessTask> CREATOR = new Parcelable.Creator<ActiveMainProcessTask>() {
        /* class com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ActiveMainProcessTask[] newArray(int i2) {
            return new ActiveMainProcessTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ActiveMainProcessTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(78483);
            ActiveMainProcessTask activeMainProcessTask = new ActiveMainProcessTask((char) 0);
            AppMethodBeat.o(78483);
            return activeMainProcessTask;
        }
    };
    public Runnable callback;

    /* synthetic */ ActiveMainProcessTask(char c2) {
        this((byte) 0);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(78484);
        Log.i("MicroMsg.ActiveMainProcessTask", "active");
        bDU();
        AppMethodBeat.o(78484);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(78485);
        Log.i("MicroMsg.ActiveMainProcessTask", "runInClientProcess");
        if (this.callback != null) {
            this.callback.run();
        }
        AppMethodBeat.o(78485);
    }

    public ActiveMainProcessTask() {
    }

    private ActiveMainProcessTask(byte b2) {
    }

    static {
        AppMethodBeat.i(78486);
        AppMethodBeat.o(78486);
    }
}
