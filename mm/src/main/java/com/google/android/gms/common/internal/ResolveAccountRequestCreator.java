package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResolveAccountRequestCreator implements Parcelable.Creator<ResolveAccountRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        AppMethodBeat.i(11853);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        Account account = null;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    account = (Account) SafeParcelReader.createParcelable(parcel, readHeader, Account.CREATOR);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.createParcelable(parcel, readHeader, GoogleSignInAccount.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ResolveAccountRequest resolveAccountRequest = new ResolveAccountRequest(i3, account, i2, googleSignInAccount);
        AppMethodBeat.o(11853);
        return resolveAccountRequest;
    }

    @Override // android.os.Parcelable.Creator
    public ResolveAccountRequest[] newArray(int i2) {
        return new ResolveAccountRequest[i2];
    }
}
