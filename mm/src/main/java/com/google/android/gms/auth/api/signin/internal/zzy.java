package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzy implements Parcelable.Creator<SignInConfiguration> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration createFromParcel(Parcel parcel) {
        AppMethodBeat.i(88357);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        GoogleSignInOptions googleSignInOptions = null;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                case 4:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) SafeParcelReader.createParcelable(parcel, readHeader, GoogleSignInOptions.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SignInConfiguration signInConfiguration = new SignInConfiguration(str, googleSignInOptions);
        AppMethodBeat.o(88357);
        return signInConfiguration;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration[] newArray(int i2) {
        return new SignInConfiguration[i2];
    }
}
