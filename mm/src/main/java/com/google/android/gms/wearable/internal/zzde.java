package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzde implements Parcelable.Creator<zzdd> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdd createFromParcel(Parcel parcel) {
        AppMethodBeat.i(101181);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArr = null;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, readHeader, Uri.CREATOR);
                    break;
                case 3:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 4:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 5:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzdd zzdd = new zzdd(uri, bundle, bArr);
        AppMethodBeat.o(101181);
        return zzdd;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdd[] newArray(int i2) {
        return new zzdd[i2];
    }
}
