package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class GoogleSignInOptionsCreator implements Parcelable.Creator<GoogleSignInOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public GoogleSignInOptions createFromParcel(Parcel parcel) {
        AppMethodBeat.i(10872);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        String str = null;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.createParcelable(parcel, readHeader, Account.CREATOR);
                    break;
                case 4:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions(i2, arrayList2, account, z3, z2, z, str2, str, arrayList);
        AppMethodBeat.o(10872);
        return googleSignInOptions;
    }

    @Override // android.os.Parcelable.Creator
    public GoogleSignInOptions[] newArray(int i2) {
        return new GoogleSignInOptions[i2];
    }
}
