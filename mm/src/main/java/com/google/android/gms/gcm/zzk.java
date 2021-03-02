package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk implements Parcelable.Creator<PeriodicTask> {
    zzk() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PeriodicTask createFromParcel(Parcel parcel) {
        AppMethodBeat.i(3709);
        PeriodicTask periodicTask = new PeriodicTask(parcel, (zzk) null);
        AppMethodBeat.o(3709);
        return periodicTask;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PeriodicTask[] newArray(int i2) {
        return new PeriodicTask[i2];
    }
}
