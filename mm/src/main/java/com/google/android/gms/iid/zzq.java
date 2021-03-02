package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzq implements Parcelable.Creator<MessengerCompat> {
    zzq() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessengerCompat createFromParcel(Parcel parcel) {
        AppMethodBeat.i(2552);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            MessengerCompat messengerCompat = new MessengerCompat(readStrongBinder);
            AppMethodBeat.o(2552);
            return messengerCompat;
        }
        AppMethodBeat.o(2552);
        return null;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessengerCompat[] newArray(int i2) {
        return new MessengerCompat[i2];
    }
}
