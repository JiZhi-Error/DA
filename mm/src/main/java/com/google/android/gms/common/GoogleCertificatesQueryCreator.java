package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleCertificatesQueryCreator implements Parcelable.Creator<GoogleCertificatesQuery> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public GoogleCertificatesQuery createFromParcel(Parcel parcel) {
        AppMethodBeat.i(4412);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        IBinder iBinder = null;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 3:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        GoogleCertificatesQuery googleCertificatesQuery = new GoogleCertificatesQuery(str, iBinder, z);
        AppMethodBeat.o(4412);
        return googleCertificatesQuery;
    }

    @Override // android.os.Parcelable.Creator
    public GoogleCertificatesQuery[] newArray(int i2) {
        return new GoogleCertificatesQuery[i2];
    }
}
