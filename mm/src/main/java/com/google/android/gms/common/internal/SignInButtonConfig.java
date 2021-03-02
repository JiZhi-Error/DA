package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "SignInButtonConfigCreator")
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new SignInButtonConfigCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getScopes", id = 4)
    @Deprecated
    private final Scope[] zzqw;
    @SafeParcelable.Field(getter = "getButtonSize", id = 2)
    private final int zzux;
    @SafeParcelable.Field(getter = "getColorScheme", id = 3)
    private final int zzuy;

    static {
        AppMethodBeat.i(11866);
        AppMethodBeat.o(11866);
    }

    @SafeParcelable.Constructor
    SignInButtonConfig(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) Scope[] scopeArr) {
        this.zzal = i2;
        this.zzux = i3;
        this.zzuy = i4;
        this.zzqw = scopeArr;
    }

    public SignInButtonConfig(int i2, int i3, Scope[] scopeArr) {
        this(1, i2, i3, null);
    }

    public int getButtonSize() {
        return this.zzux;
    }

    public int getColorScheme() {
        return this.zzuy;
    }

    @Deprecated
    public Scope[] getScopes() {
        return this.zzqw;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(11865);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeInt(parcel, 2, getButtonSize());
        SafeParcelWriter.writeInt(parcel, 3, getColorScheme());
        SafeParcelWriter.writeTypedArray(parcel, 4, getScopes(), i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(11865);
    }
}
