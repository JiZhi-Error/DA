package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ValidateAccountRequestCreator implements Parcelable.Creator<ValidateAccountRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public ValidateAccountRequest createFromParcel(Parcel parcel) {
        AppMethodBeat.i(4747);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ValidateAccountRequest validateAccountRequest = new ValidateAccountRequest(i2);
        AppMethodBeat.o(4747);
        return validateAccountRequest;
    }

    @Override // android.os.Parcelable.Creator
    public ValidateAccountRequest[] newArray(int i2) {
        return new ValidateAccountRequest[i2];
    }
}
