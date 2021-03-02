package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInButtonConfigCreator implements Parcelable.Creator<SignInButtonConfig> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public SignInButtonConfig createFromParcel(Parcel parcel) {
        AppMethodBeat.i(11867);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    scopeArr = (Scope[]) SafeParcelReader.createTypedArray(parcel, readHeader, Scope.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i4, i3, i2, scopeArr);
        AppMethodBeat.o(11867);
        return signInButtonConfig;
    }

    @Override // android.os.Parcelable.Creator
    public SignInButtonConfig[] newArray(int i2) {
        return new SignInButtonConfig[i2];
    }
}
