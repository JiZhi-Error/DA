package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConnectionInfoCreator implements Parcelable.Creator<ConnectionInfo> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public ConnectionInfo createFromParcel(Parcel parcel) {
        AppMethodBeat.i(4609);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Feature[] featureArr = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 2:
                    featureArr = (Feature[]) SafeParcelReader.createTypedArray(parcel, readHeader, Feature.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ConnectionInfo connectionInfo = new ConnectionInfo(bundle, featureArr);
        AppMethodBeat.o(4609);
        return connectionInfo;
    }

    @Override // android.os.Parcelable.Creator
    public ConnectionInfo[] newArray(int i2) {
        return new ConnectionInfo[i2];
    }
}
