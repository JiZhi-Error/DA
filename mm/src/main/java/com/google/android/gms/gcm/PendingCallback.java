package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class PendingCallback implements Parcelable, ReflectedParcelable {
    public static final Parcelable.Creator<PendingCallback> CREATOR = new zzj();
    final IBinder zzal;

    static {
        AppMethodBeat.i(3672);
        AppMethodBeat.o(3672);
    }

    public PendingCallback(Parcel parcel) {
        AppMethodBeat.i(3670);
        this.zzal = parcel.readStrongBinder();
        AppMethodBeat.o(3670);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(3671);
        parcel.writeStrongBinder(this.zzal);
        AppMethodBeat.o(3671);
    }
}
