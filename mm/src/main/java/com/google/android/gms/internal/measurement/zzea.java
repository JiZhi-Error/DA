package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzea implements Parcelable.Creator<zzdz> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdz createFromParcel(Parcel parcel) {
        AppMethodBeat.i(1106);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j2 = 0;
        long j3 = 0;
        String str5 = null;
        boolean z = true;
        boolean z2 = false;
        long j4 = -2147483648L;
        String str6 = null;
        long j5 = 0;
        long j6 = 0;
        int i2 = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 7:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 8:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 14:
                    j6 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 15:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 16:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 17:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 18:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzdz zzdz = new zzdz(str, str2, str3, str4, j2, j3, str5, z, z2, j4, str6, j5, j6, i2, z3, z4, z5);
        AppMethodBeat.o(1106);
        return zzdz;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdz[] newArray(int i2) {
        return new zzdz[i2];
    }
}
