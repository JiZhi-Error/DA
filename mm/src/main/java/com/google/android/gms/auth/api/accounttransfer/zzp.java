package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;

public final class zzp implements Parcelable.Creator<zzo> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo createFromParcel(Parcel parcel) {
        AppMethodBeat.i(10669);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        zzr zzr = null;
        int i2 = 0;
        ArrayList arrayList = null;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(1);
                    break;
                case 2:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, zzu.CREATOR);
                    hashSet.add(2);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(3);
                    break;
                case 4:
                    hashSet.add(4);
                    zzr = (zzr) SafeParcelReader.createParcelable(parcel, readHeader, zzr.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            SafeParcelReader.ParseException parseException = new SafeParcelReader.ParseException(new StringBuilder(37).append("Overread allowed size end=").append(validateObjectHeader).toString(), parcel);
            AppMethodBeat.o(10669);
            throw parseException;
        }
        zzo zzo = new zzo(hashSet, i3, arrayList, i2, zzr);
        AppMethodBeat.o(10669);
        return zzo;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i2) {
        return new zzo[i2];
    }
}
