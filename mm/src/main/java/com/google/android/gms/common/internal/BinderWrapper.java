package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zza();
    private IBinder zzry;

    static {
        AppMethodBeat.i(4606);
        AppMethodBeat.o(4606);
    }

    public BinderWrapper() {
        this.zzry = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.zzry = null;
        this.zzry = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        AppMethodBeat.i(4604);
        this.zzry = null;
        this.zzry = parcel.readStrongBinder();
        AppMethodBeat.o(4604);
    }

    /* synthetic */ BinderWrapper(Parcel parcel, zza zza) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final IBinder getBinder() {
        return this.zzry;
    }

    public final void setBinder(IBinder iBinder) {
        this.zzry = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4605);
        parcel.writeStrongBinder(this.zzry);
        AppMethodBeat.o(4605);
    }
}
