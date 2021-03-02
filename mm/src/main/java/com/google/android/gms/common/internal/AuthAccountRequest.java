package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "AuthAccountRequestCreator")
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new AuthAccountRequestCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(id = 2)
    @Deprecated
    private final IBinder zzqv;
    @SafeParcelable.Field(id = 3)
    private final Scope[] zzqw;
    @SafeParcelable.Field(id = 4)
    private Integer zzqx;
    @SafeParcelable.Field(id = 5)
    private Integer zzqy;
    @SafeParcelable.Field(id = 6, type = "android.accounts.Account")
    private Account zzs;

    static {
        AppMethodBeat.i(11797);
        AppMethodBeat.o(11797);
    }

    @SafeParcelable.Constructor
    AuthAccountRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) Scope[] scopeArr, @SafeParcelable.Param(id = 4) Integer num, @SafeParcelable.Param(id = 5) Integer num2, @SafeParcelable.Param(id = 6) Account account) {
        this.zzal = i2;
        this.zzqv = iBinder;
        this.zzqw = scopeArr;
        this.zzqx = num;
        this.zzqy = num2;
        this.zzs = account;
    }

    public AuthAccountRequest(Account account, Set<Scope> set) {
        this(3, null, (Scope[]) set.toArray(new Scope[set.size()]), null, null, (Account) Preconditions.checkNotNull(account));
        AppMethodBeat.i(11793);
        AppMethodBeat.o(11793);
    }

    @Deprecated
    public AuthAccountRequest(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        this(3, iAccountAccessor.asBinder(), (Scope[]) set.toArray(new Scope[set.size()]), null, null, null);
        AppMethodBeat.i(11792);
        AppMethodBeat.o(11792);
    }

    public Account getAccount() {
        AppMethodBeat.i(11794);
        Account account = null;
        if (this.zzs != null) {
            account = this.zzs;
        } else if (this.zzqv != null) {
            account = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(this.zzqv));
        }
        AppMethodBeat.o(11794);
        return account;
    }

    @Nullable
    public Integer getOauthPolicy() {
        return this.zzqx;
    }

    @Nullable
    public Integer getPolicyAction() {
        return this.zzqy;
    }

    public Set<Scope> getScopes() {
        AppMethodBeat.i(11795);
        HashSet hashSet = new HashSet(Arrays.asList(this.zzqw));
        AppMethodBeat.o(11795);
        return hashSet;
    }

    public AuthAccountRequest setOauthPolicy(@Nullable Integer num) {
        this.zzqx = num;
        return this;
    }

    public AuthAccountRequest setPolicyAction(@Nullable Integer num) {
        this.zzqy = num;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(11796);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzqv, false);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzqw, i2, false);
        SafeParcelWriter.writeIntegerObject(parcel, 4, this.zzqx, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, this.zzqy, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzs, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(11796);
    }
}
