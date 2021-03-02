package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class zzv implements Parcelable.Creator<zzu> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzu createFromParcel(Parcel parcel) {
        AppMethodBeat.i(10682);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        String str = null;
        String str2 = null;
        zzw zzw = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    zzw = (zzw) SafeParcelReader.createParcelable(parcel, readHeader, zzw.CREATOR);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    hashSet.add(3);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    hashSet.add(4);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            SafeParcelReader.ParseException parseException = new SafeParcelReader.ParseException(new StringBuilder(37).append("Overread allowed size end=").append(validateObjectHeader).toString(), parcel);
            AppMethodBeat.o(10682);
            throw parseException;
        }
        zzu zzu = new zzu(hashSet, i2, zzw, str2, str);
        AppMethodBeat.o(10682);
        return zzu;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzu[] newArray(int i2) {
        return new zzu[i2];
    }
}
