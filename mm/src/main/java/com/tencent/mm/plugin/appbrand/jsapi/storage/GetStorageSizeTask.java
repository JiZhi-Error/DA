package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class GetStorageSizeTask extends MainProcessTask {
    public static final Parcelable.Creator<GetStorageSizeTask> CREATOR = new Parcelable.Creator<GetStorageSizeTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GetStorageSizeTask[] newArray(int i2) {
            return new GetStorageSizeTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GetStorageSizeTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(147221);
            GetStorageSizeTask getStorageSizeTask = new GetStorageSizeTask(parcel);
            AppMethodBeat.o(147221);
            return getStorageSizeTask;
        }
    };
    public String appId;
    public Runnable lyv;
    public int size;

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        d NK;
        AppMethodBeat.i(147222);
        if (e.M(a.class) == null) {
            NK = null;
        } else {
            NK = ((a) e.M(a.class)).NK();
        }
        if (NK == null) {
            bDU();
            AppMethodBeat.o(147222);
            return;
        }
        this.size = NK.VL(this.appId);
        bDU();
        AppMethodBeat.o(147222);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(147223);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(147223);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(147224);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.appId);
        parcel.writeInt(this.size);
        AppMethodBeat.o(147224);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(147225);
        this.appId = parcel.readString();
        this.size = parcel.readInt();
        AppMethodBeat.o(147225);
    }

    public GetStorageSizeTask() {
    }

    protected GetStorageSizeTask(Parcel parcel) {
        AppMethodBeat.i(147226);
        f(parcel);
        AppMethodBeat.o(147226);
    }

    static {
        AppMethodBeat.i(147227);
        AppMethodBeat.o(147227);
    }
}
