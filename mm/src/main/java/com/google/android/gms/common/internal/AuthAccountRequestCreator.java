package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AuthAccountRequestCreator implements Parcelable.Creator<AuthAccountRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        AppMethodBeat.i(11798);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        Account account = null;
        Integer num = null;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 3:
                    scopeArr = (Scope[]) SafeParcelReader.createTypedArray(parcel, readHeader, Scope.CREATOR);
                    break;
                case 4:
                    num2 = SafeParcelReader.readIntegerObject(parcel, readHeader);
                    break;
                case 5:
                    num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                    break;
                case 6:
                    account = (Account) SafeParcelReader.createParcelable(parcel, readHeader, Account.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        AuthAccountRequest authAccountRequest = new AuthAccountRequest(i2, iBinder, scopeArr, num2, num, account);
        AppMethodBeat.o(11798);
        return authAccountRequest;
    }

    @Override // android.os.Parcelable.Creator
    public AuthAccountRequest[] newArray(int i2) {
        return new AuthAccountRequest[i2];
    }
}
