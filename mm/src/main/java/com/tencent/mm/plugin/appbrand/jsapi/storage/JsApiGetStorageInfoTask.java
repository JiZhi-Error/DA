package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask extends MainProcessTask {
    public static final Parcelable.Creator<JsApiGetStorageInfoTask> CREATOR = new Parcelable.Creator<JsApiGetStorageInfoTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ JsApiGetStorageInfoTask[] newArray(int i2) {
            return new JsApiGetStorageInfoTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ JsApiGetStorageInfoTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(147253);
            JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
            jsApiGetStorageInfoTask.f(parcel);
            AppMethodBeat.o(147253);
            return jsApiGetStorageInfoTask;
        }
    };
    public String appId;
    public int limit;
    public Runnable lyv;
    public int mtl;
    public ArrayList<String> mtq;
    public int size;

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        d NK;
        Object[] Z;
        AppMethodBeat.i(147254);
        if (e.M(a.class) == null) {
            NK = null;
        } else {
            NK = ((a) e.M(a.class)).NK();
        }
        if (NK == null) {
            bDU();
            AppMethodBeat.o(147254);
            return;
        }
        synchronized (d.class) {
            try {
                Z = NK.Z(this.mtl, this.appId);
            } catch (Throwable th) {
                AppMethodBeat.o(147254);
                throw th;
            }
        }
        this.mtq = (ArrayList) Z[0];
        this.size = (int) Math.ceil(((Integer) Z[1]).doubleValue() / 1000.0d);
        this.limit = (int) Math.ceil(((Integer) Z[2]).doubleValue() / 1000.0d);
        bDU();
        AppMethodBeat.o(147254);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(147255);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(147255);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(147256);
        this.appId = parcel.readString();
        this.mtl = parcel.readInt();
        this.mtq = parcel.createStringArrayList();
        this.size = parcel.readInt();
        this.limit = parcel.readInt();
        AppMethodBeat.o(147256);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(147257);
        parcel.writeString(this.appId);
        parcel.writeInt(this.mtl);
        parcel.writeStringList(this.mtq);
        parcel.writeInt(this.size);
        parcel.writeInt(this.limit);
        AppMethodBeat.o(147257);
    }

    static {
        AppMethodBeat.i(147258);
        AppMethodBeat.o(147258);
    }
}
