package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzax implements Parcelable.Creator<zzaw> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaw createFromParcel(Parcel parcel) {
        AppMethodBeat.i(101025);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzay zzay = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    zzay = (zzay) SafeParcelReader.createParcelable(parcel, readHeader, zzay.CREATOR);
                    break;
                case 3:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzaw zzaw = new zzaw(zzay, i4, i3, i2);
        AppMethodBeat.o(101025);
        return zzaw;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaw[] newArray(int i2) {
        return new zzaw[i2];
    }
}