package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleSignInOptionsExtensionCreator implements Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public GoogleSignInOptionsExtensionParcelable createFromParcel(Parcel parcel) {
        AppMethodBeat.i(10875);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundle = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = new GoogleSignInOptionsExtensionParcelable(i3, i2, bundle);
        AppMethodBeat.o(10875);
        return googleSignInOptionsExtensionParcelable;
    }

    @Override // android.os.Parcelable.Creator
    public GoogleSignInOptionsExtensionParcelable[] newArray(int i2) {
        return new GoogleSignInOptionsExtensionParcelable[i2];
    }
}
