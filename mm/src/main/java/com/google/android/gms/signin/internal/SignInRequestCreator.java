package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInRequestCreator implements Parcelable.Creator<SignInRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public SignInRequest createFromParcel(Parcel parcel) {
        AppMethodBeat.i(12191);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    resolveAccountRequest = (ResolveAccountRequest) SafeParcelReader.createParcelable(parcel, readHeader, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SignInRequest signInRequest = new SignInRequest(i2, resolveAccountRequest);
        AppMethodBeat.o(12191);
        return signInRequest;
    }

    @Override // android.os.Parcelable.Creator
    public SignInRequest[] newArray(int i2) {
        return new SignInRequest[i2];
    }
}
