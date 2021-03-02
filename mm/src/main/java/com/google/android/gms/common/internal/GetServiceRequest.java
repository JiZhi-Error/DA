package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new GetServiceRequestCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int version;
    @SafeParcelable.Field(id = 2)
    private final int zzst;
    @SafeParcelable.Field(id = 3)
    private int zzsu;
    @SafeParcelable.Field(id = 4)
    private String zzsv;
    @SafeParcelable.Field(id = 5)
    private IBinder zzsw;
    @SafeParcelable.Field(id = 6)
    private Scope[] zzsx;
    @SafeParcelable.Field(id = 7)
    private Bundle zzsy;
    @SafeParcelable.Field(id = 8)
    private Account zzsz;
    @SafeParcelable.Field(id = 10)
    private Feature[] zzta;
    @SafeParcelable.Field(id = 11)
    private Feature[] zztb;
    @SafeParcelable.Field(id = 12)
    private boolean zztc;

    static {
        AppMethodBeat.i(4632);
        AppMethodBeat.o(4632);
    }

    public GetServiceRequest(int i2) {
        this.version = 4;
        this.zzsu = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzst = i2;
        this.zztc = true;
    }

    @SafeParcelable.Constructor
    GetServiceRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) IBinder iBinder, @SafeParcelable.Param(id = 6) Scope[] scopeArr, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) Account account, @SafeParcelable.Param(id = 10) Feature[] featureArr, @SafeParcelable.Param(id = 11) Feature[] featureArr2, @SafeParcelable.Param(id = 12) boolean z) {
        AppMethodBeat.i(4626);
        this.version = i2;
        this.zzst = i3;
        this.zzsu = i4;
        if ("com.google.android.gms".equals(str)) {
            this.zzsv = "com.google.android.gms";
        } else {
            this.zzsv = str;
        }
        if (i2 < 2) {
            this.zzsz = zzb(iBinder);
        } else {
            this.zzsw = iBinder;
            this.zzsz = account;
        }
        this.zzsx = scopeArr;
        this.zzsy = bundle;
        this.zzta = featureArr;
        this.zztb = featureArr2;
        this.zztc = z;
        AppMethodBeat.o(4626);
    }

    public static Parcelable.Creator<GetServiceRequest> getCreator() {
        return CREATOR;
    }

    private static Account zzb(IBinder iBinder) {
        AppMethodBeat.i(4631);
        Account account = null;
        if (iBinder != null) {
            account = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder));
        }
        AppMethodBeat.o(4631);
        return account;
    }

    public Account getAuthenticatedAccount() {
        AppMethodBeat.i(4627);
        Account zzb = zzb(this.zzsw);
        AppMethodBeat.o(4627);
        return zzb;
    }

    public String getCallingPackage() {
        return this.zzsv;
    }

    public Feature[] getClientApiFeatures() {
        return this.zztb;
    }

    public int getClientLibraryVersion() {
        return this.zzsu;
    }

    public Account getClientRequestedAccount() {
        return this.zzsz;
    }

    public Feature[] getClientRequiredFeatures() {
        return this.zzta;
    }

    public Bundle getExtraArgs() {
        return this.zzsy;
    }

    public Scope[] getScopes() {
        return this.zzsx;
    }

    public int getServiceId() {
        return this.zzst;
    }

    public boolean isRequestingConnectionInfo() {
        return this.zztc;
    }

    public GetServiceRequest setAuthenticatedAccount(IAccountAccessor iAccountAccessor) {
        AppMethodBeat.i(4628);
        if (iAccountAccessor != null) {
            this.zzsw = iAccountAccessor.asBinder();
        }
        AppMethodBeat.o(4628);
        return this;
    }

    public GetServiceRequest setCallingPackage(String str) {
        this.zzsv = str;
        return this;
    }

    public GetServiceRequest setClientApiFeatures(Feature[] featureArr) {
        this.zztb = featureArr;
        return this;
    }

    public GetServiceRequest setClientLibraryVersion(int i2) {
        this.zzsu = i2;
        return this;
    }

    public GetServiceRequest setClientRequestedAccount(Account account) {
        this.zzsz = account;
        return this;
    }

    public GetServiceRequest setClientRequiredFeatures(Feature[] featureArr) {
        this.zzta = featureArr;
        return this;
    }

    public GetServiceRequest setExtraArgs(Bundle bundle) {
        this.zzsy = bundle;
        return this;
    }

    public GetServiceRequest setRequestingConnectionInfo(boolean z) {
        this.zztc = z;
        return this;
    }

    public GetServiceRequest setScopes(Collection<Scope> collection) {
        AppMethodBeat.i(4629);
        this.zzsx = (Scope[]) collection.toArray(new Scope[collection.size()]);
        AppMethodBeat.o(4629);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4630);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.version);
        SafeParcelWriter.writeInt(parcel, 2, this.zzst);
        SafeParcelWriter.writeInt(parcel, 3, this.zzsu);
        SafeParcelWriter.writeString(parcel, 4, this.zzsv, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzsw, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzsx, i2, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzsy, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzsz, i2, false);
        SafeParcelWriter.writeTypedArray(parcel, 10, this.zzta, i2, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, this.zztb, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zztc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(4630);
    }
}
