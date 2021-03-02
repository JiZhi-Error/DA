package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiClearStorageTask extends MainProcessTask {
    public static final Parcelable.Creator<JsApiClearStorageTask> CREATOR = new Parcelable.Creator<JsApiClearStorageTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiClearStorageTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ JsApiClearStorageTask[] newArray(int i2) {
            return new JsApiClearStorageTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ JsApiClearStorageTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(147234);
            JsApiClearStorageTask jsApiClearStorageTask = new JsApiClearStorageTask(parcel);
            AppMethodBeat.o(147234);
            return jsApiClearStorageTask;
        }
    };
    public String appId;
    public int mtl;

    public JsApiClearStorageTask() {
    }

    public JsApiClearStorageTask(Parcel parcel) {
        AppMethodBeat.i(147235);
        f(parcel);
        AppMethodBeat.o(147235);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        d NK;
        AppMethodBeat.i(147236);
        if (e.M(a.class) == null) {
            NK = null;
        } else {
            NK = ((a) e.M(a.class)).NK();
        }
        if (NK == null) {
            AppMethodBeat.o(147236);
            return;
        }
        NK.Y(this.mtl, this.appId);
        AppMethodBeat.o(147236);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(147237);
        this.appId = parcel.readString();
        this.mtl = parcel.readInt();
        AppMethodBeat.o(147237);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(147238);
        parcel.writeString(this.appId);
        parcel.writeInt(this.mtl);
        AppMethodBeat.o(147238);
    }

    static {
        AppMethodBeat.i(147239);
        AppMethodBeat.o(147239);
    }
}
