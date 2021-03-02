package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "ResolveAccountResponseCreator")
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new ResolveAccountResponseCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 3)
    private ConnectionResult zzeu;
    @SafeParcelable.Field(getter = "getSaveDefaultAccount", id = 4)
    private boolean zzhs;
    @SafeParcelable.Field(id = 2)
    private IBinder zzqv;
    @SafeParcelable.Field(getter = "isFromCrossClientAuth", id = 5)
    private boolean zzuv;

    static {
        AppMethodBeat.i(11861);
        AppMethodBeat.o(11861);
    }

    public ResolveAccountResponse(int i2) {
        this(new ConnectionResult(i2, null));
        AppMethodBeat.i(11856);
        AppMethodBeat.o(11856);
    }

    @SafeParcelable.Constructor
    ResolveAccountResponse(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) ConnectionResult connectionResult, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2) {
        this.zzal = i2;
        this.zzqv = iBinder;
        this.zzeu = connectionResult;
        this.zzhs = z;
        this.zzuv = z2;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(11860);
        if (this == obj) {
            AppMethodBeat.o(11860);
            return true;
        } else if (!(obj instanceof ResolveAccountResponse)) {
            AppMethodBeat.o(11860);
            return false;
        } else {
            ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
            if (!this.zzeu.equals(resolveAccountResponse.zzeu) || !getAccountAccessor().equals(resolveAccountResponse.getAccountAccessor())) {
                AppMethodBeat.o(11860);
                return false;
            }
            AppMethodBeat.o(11860);
            return true;
        }
    }

    public IAccountAccessor getAccountAccessor() {
        AppMethodBeat.i(11857);
        IAccountAccessor asInterface = IAccountAccessor.Stub.asInterface(this.zzqv);
        AppMethodBeat.o(11857);
        return asInterface;
    }

    public ConnectionResult getConnectionResult() {
        return this.zzeu;
    }

    public boolean getSaveDefaultAccount() {
        return this.zzhs;
    }

    public boolean isFromCrossClientAuth() {
        return this.zzuv;
    }

    public ResolveAccountResponse setAccountAccessor(IAccountAccessor iAccountAccessor) {
        AppMethodBeat.i(11858);
        this.zzqv = iAccountAccessor == null ? null : iAccountAccessor.asBinder();
        AppMethodBeat.o(11858);
        return this;
    }

    public ResolveAccountResponse setIsFromCrossClientAuth(boolean z) {
        this.zzuv = z;
        return this;
    }

    public ResolveAccountResponse setSaveDefaultAccount(boolean z) {
        this.zzhs = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(11859);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzqv, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getConnectionResult(), i2, false);
        SafeParcelWriter.writeBoolean(parcel, 4, getSaveDefaultAccount());
        SafeParcelWriter.writeBoolean(parcel, 5, isFromCrossClientAuth());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(11859);
    }
}
