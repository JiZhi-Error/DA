package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "AddListenerRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getListenerAsBinder", id = 2, type = "android.os.IBinder")
    private final zzem zzaz;
    @SafeParcelable.Field(id = 3)
    private final IntentFilter[] zzba;
    @Nullable
    @SafeParcelable.Field(id = 4)
    private final String zzbb;
    @Nullable
    @SafeParcelable.Field(id = 5)
    private final String zzbc;

    static {
        AppMethodBeat.i(101169);
        AppMethodBeat.o(101169);
    }

    @SafeParcelable.Constructor
    zzd(@SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) IntentFilter[] intentFilterArr, @SafeParcelable.Param(id = 4) @Nullable String str, @SafeParcelable.Param(id = 5) @Nullable String str2) {
        zzem zzem = null;
        AppMethodBeat.i(101166);
        if (iBinder != null) {
            if (iBinder != null) {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
                zzem = queryLocalInterface instanceof zzem ? (zzem) queryLocalInterface : new zzeo(iBinder);
            }
            this.zzaz = zzem;
        } else {
            this.zzaz = null;
        }
        this.zzba = intentFilterArr;
        this.zzbb = str;
        this.zzbc = str2;
        AppMethodBeat.o(101166);
    }

    public zzd(zzhk zzhk) {
        AppMethodBeat.i(101167);
        this.zzaz = zzhk;
        this.zzba = zzhk.zze();
        this.zzbb = zzhk.zzf();
        this.zzbc = null;
        AppMethodBeat.o(101167);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101168);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzaz == null ? null : this.zzaz.asBinder(), false);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzba, i2, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzbb, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101168);
    }
}
