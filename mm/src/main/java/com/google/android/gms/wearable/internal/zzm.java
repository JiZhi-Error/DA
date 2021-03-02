package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzm implements Parcelable.Creator<zzl> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl createFromParcel(Parcel parcel) {
        AppMethodBeat.i(101437);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        String str7 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    b2 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 10:
                    b3 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 11:
                    b4 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 12:
                    b5 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 13:
                    str7 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzl zzl = new zzl(i2, str, str2, str3, str4, str5, str6, b2, b3, b4, b5, str7);
        AppMethodBeat.o(101437);
        return zzl;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl[] newArray(int i2) {
        return new zzl[i2];
    }
}
