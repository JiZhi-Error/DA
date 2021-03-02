package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "AccountChangeEventsRequestCreator")
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zze();
    @SafeParcelable.VersionField(id = 1)
    private final int zzh;
    @SafeParcelable.Field(id = 3)
    @Deprecated
    private String zzj;
    @SafeParcelable.Field(id = 2)
    private int zzl;
    @SafeParcelable.Field(id = 4)
    private Account zzn;

    static {
        AppMethodBeat.i(10589);
        AppMethodBeat.o(10589);
    }

    public AccountChangeEventsRequest() {
        this.zzh = 1;
    }

    @SafeParcelable.Constructor
    AccountChangeEventsRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) Account account) {
        AppMethodBeat.i(10587);
        this.zzh = i2;
        this.zzl = i3;
        this.zzj = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzn = account;
            AppMethodBeat.o(10587);
            return;
        }
        this.zzn = new Account(str, "com.google");
        AppMethodBeat.o(10587);
    }

    public Account getAccount() {
        return this.zzn;
    }

    @Deprecated
    public String getAccountName() {
        return this.zzj;
    }

    public int getEventIndex() {
        return this.zzl;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzn = account;
        return this;
    }

    @Deprecated
    public AccountChangeEventsRequest setAccountName(String str) {
        this.zzj = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i2) {
        this.zzl = i2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10588);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzh);
        SafeParcelWriter.writeInt(parcel, 2, this.zzl);
        SafeParcelWriter.writeString(parcel, 3, this.zzj, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzn, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10588);
    }
}
