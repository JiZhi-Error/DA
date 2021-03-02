package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class zzx implements Parcelable.Creator<zzw> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzw createFromParcel(Parcel parcel) {
        AppMethodBeat.i(10691);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        DeviceMetaData deviceMetaData = null;
        PendingIntent pendingIntent = null;
        byte[] bArr = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(1);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    hashSet.add(2);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(3);
                    break;
                case 4:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    hashSet.add(4);
                    break;
                case 5:
                    hashSet.add(5);
                    pendingIntent = (PendingIntent) SafeParcelReader.createParcelable(parcel, readHeader, PendingIntent.CREATOR);
                    break;
                case 6:
                    hashSet.add(6);
                    deviceMetaData = (DeviceMetaData) SafeParcelReader.createParcelable(parcel, readHeader, DeviceMetaData.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            SafeParcelReader.ParseException parseException = new SafeParcelReader.ParseException(new StringBuilder(37).append("Overread allowed size end=").append(validateObjectHeader).toString(), parcel);
            AppMethodBeat.o(10691);
            throw parseException;
        }
        zzw zzw = new zzw(hashSet, i3, str, i2, bArr, pendingIntent, deviceMetaData);
        AppMethodBeat.o(10691);
        return zzw;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzw[] newArray(int i2) {
        return new zzw[i2];
    }
}
