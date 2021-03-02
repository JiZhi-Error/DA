package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AuthAccountResultCreator implements Parcelable.Creator<AuthAccountResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public AuthAccountResult createFromParcel(Parcel parcel) {
        AppMethodBeat.i(12146);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Intent intent = null;
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
                    intent = (Intent) SafeParcelReader.createParcelable(parcel, readHeader, Intent.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        AuthAccountResult authAccountResult = new AuthAccountResult(i3, i2, intent);
        AppMethodBeat.o(12146);
        return authAccountResult;
    }

    @Override // android.os.Parcelable.Creator
    public AuthAccountResult[] newArray(int i2) {
        return new AuthAccountResult[i2];
    }
}
