package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiRemoveStorageTask extends MainProcessTask {
    public static final Parcelable.Creator<JsApiRemoveStorageTask> CREATOR = new Parcelable.Creator<JsApiRemoveStorageTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiRemoveStorageTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ JsApiRemoveStorageTask[] newArray(int i2) {
            return new JsApiRemoveStorageTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ JsApiRemoveStorageTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(147273);
            JsApiRemoveStorageTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
            jsApiRemoveStorageTask.f(parcel);
            AppMethodBeat.o(147273);
            return jsApiRemoveStorageTask;
        }
    };
    public String appId;
    public String key;
    public int mtl;

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        d NK;
        AppMethodBeat.i(147274);
        if (e.M(a.class) == null) {
            NK = null;
        } else {
            NK = ((a) e.M(a.class)).NK();
        }
        if (NK == null) {
            AppMethodBeat.o(147274);
            return;
        }
        NK.m(this.mtl, this.appId, this.key);
        AppMethodBeat.o(147274);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(147275);
        parcel.writeString(this.appId);
        parcel.writeInt(this.mtl);
        parcel.writeString(this.key);
        AppMethodBeat.o(147275);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(147276);
        this.appId = parcel.readString();
        this.mtl = parcel.readInt();
        this.key = parcel.readString();
        AppMethodBeat.o(147276);
    }

    static {
        AppMethodBeat.i(147277);
        AppMethodBeat.o(147277);
    }
}
