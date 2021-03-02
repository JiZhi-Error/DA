package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "RemoveListenerRequestCreator")
public final class zzfw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfw> CREATOR = new zzfx();
    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getListenerAsBinder", id = 2, type = "android.os.IBinder")
    private final zzem zzaz;

    static {
        AppMethodBeat.i(101328);
        AppMethodBeat.o(101328);
    }

    @SafeParcelable.Constructor
    zzfw(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) IBinder iBinder) {
        zzem zzem = null;
        AppMethodBeat.i(101326);
        this.versionCode = i2;
        if (iBinder != null) {
            if (iBinder != null) {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
                zzem = queryLocalInterface instanceof zzem ? (zzem) queryLocalInterface : new zzeo(iBinder);
            }
            this.zzaz = zzem;
            AppMethodBeat.o(101326);
            return;
        }
        this.zzaz = null;
        AppMethodBeat.o(101326);
    }

    public zzfw(zzem zzem) {
        this.versionCode = 1;
        this.zzaz = zzem;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101327);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzaz == null ? null : this.zzaz.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101327);
    }
}
