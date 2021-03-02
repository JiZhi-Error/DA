package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class z implements Parcelable.Creator<zzi> {
    z() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi createFromParcel(Parcel parcel) {
        AppMethodBeat.i(4228);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            zzi zzi = new zzi(readStrongBinder);
            AppMethodBeat.o(4228);
            return zzi;
        }
        AppMethodBeat.o(4228);
        return null;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi[] newArray(int i2) {
        return new zzi[i2];
    }
}
