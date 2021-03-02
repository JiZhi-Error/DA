package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "AmsEntityUpdateParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    @SafeParcelable.Field(getter = "getValue", id = 4)
    private final String value;
    @SafeParcelable.Field(getter = "getEntityId", id = 2)
    private byte zzbd;
    @SafeParcelable.Field(getter = "getAttributeId", id = 3)
    private final byte zzbe;

    static {
        AppMethodBeat.i(101430);
        AppMethodBeat.o(101430);
    }

    @SafeParcelable.Constructor
    public zzi(@SafeParcelable.Param(id = 2) byte b2, @SafeParcelable.Param(id = 3) byte b3, @SafeParcelable.Param(id = 4) String str) {
        this.zzbd = b2;
        this.zzbe = b3;
        this.value = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101428);
        if (this == obj) {
            AppMethodBeat.o(101428);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(101428);
            return false;
        } else {
            zzi zzi = (zzi) obj;
            if (this.zzbd != zzi.zzbd) {
                AppMethodBeat.o(101428);
                return false;
            } else if (this.zzbe != zzi.zzbe) {
                AppMethodBeat.o(101428);
                return false;
            } else if (!this.value.equals(zzi.value)) {
                AppMethodBeat.o(101428);
                return false;
            } else {
                AppMethodBeat.o(101428);
                return true;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(101429);
        int hashCode = ((((this.zzbd + 31) * 31) + this.zzbe) * 31) + this.value.hashCode();
        AppMethodBeat.o(101429);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(101427);
        byte b2 = this.zzbd;
        byte b3 = this.zzbe;
        String str = this.value;
        String sb = new StringBuilder(String.valueOf(str).length() + 73).append("AmsEntityUpdateParcelable{, mEntityId=").append((int) b2).append(", mAttributeId=").append((int) b3).append(", mValue='").append(str).append('\'').append('}').toString();
        AppMethodBeat.o(101427);
        return sb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101426);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, this.zzbd);
        SafeParcelWriter.writeByte(parcel, 3, this.zzbe);
        SafeParcelWriter.writeString(parcel, 4, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101426);
    }
}
