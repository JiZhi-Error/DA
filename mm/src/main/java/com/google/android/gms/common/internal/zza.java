package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza implements Parcelable.Creator<BinderWrapper> {
    zza() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BinderWrapper createFromParcel(Parcel parcel) {
        AppMethodBeat.i(4883);
        BinderWrapper binderWrapper = new BinderWrapper(parcel, null);
        AppMethodBeat.o(4883);
        return binderWrapper;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BinderWrapper[] newArray(int i2) {
        return new BinderWrapper[i2];
    }
}
