package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "RecordConsentRequestCreator")
public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new RecordConsentRequestCreator();
    @SafeParcelable.Field(getter = "getScopesToConsent", id = 3)
    private final Scope[] zzadr;
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getAccount", id = 2)
    private final Account zzs;
    @SafeParcelable.Field(getter = "getServerClientId", id = 4)
    private final String zzw;

    static {
        AppMethodBeat.i(12175);
        AppMethodBeat.o(12175);
    }

    @SafeParcelable.Constructor
    RecordConsentRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Account account, @SafeParcelable.Param(id = 3) Scope[] scopeArr, @SafeParcelable.Param(id = 4) String str) {
        this.zzal = i2;
        this.zzs = account;
        this.zzadr = scopeArr;
        this.zzw = str;
    }

    public RecordConsentRequest(Account account, Scope[] scopeArr, String str) {
        this(1, account, scopeArr, str);
    }

    public Account getAccount() {
        return this.zzs;
    }

    public Scope[] getScopesToConsent() {
        return this.zzadr;
    }

    public String getServerClientId() {
        return this.zzw;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(12174);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, getAccount(), i2, false);
        SafeParcelWriter.writeTypedArray(parcel, 3, getScopesToConsent(), i2, false);
        SafeParcelWriter.writeString(parcel, 4, getServerClientId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(12174);
    }
}
