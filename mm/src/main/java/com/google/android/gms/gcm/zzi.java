package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzi implements Parcelable.Creator<OneoffTask> {
    zzi() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ OneoffTask createFromParcel(Parcel parcel) {
        AppMethodBeat.i(3707);
        OneoffTask oneoffTask = new OneoffTask(parcel, (zzi) null);
        AppMethodBeat.o(3707);
        return oneoffTask;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ OneoffTask[] newArray(int i2) {
        return new OneoffTask[i2];
    }
}
