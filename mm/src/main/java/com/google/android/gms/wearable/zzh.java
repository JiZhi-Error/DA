package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh implements Parcelable.Creator<PutDataRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PutDataRequest createFromParcel(Parcel parcel) {
        AppMethodBeat.i(101463);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j2 = 0;
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
                case 6:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        PutDataRequest putDataRequest = new PutDataRequest(uri, bundle, bArr, j2);
        AppMethodBeat.o(101463);
        return putDataRequest;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PutDataRequest[] newArray(int i2) {
        return new PutDataRequest[i2];
    }
}
