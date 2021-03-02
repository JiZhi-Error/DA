package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
@SafeParcelable.Class(creator = "ScopeCreator")
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzd();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getScopeUri", id = 2)
    private final String zzdp;

    static {
        AppMethodBeat.i(4473);
        AppMethodBeat.o(4473);
    }

    @SafeParcelable.Constructor
    Scope(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str) {
        AppMethodBeat.i(4469);
        Preconditions.checkNotEmpty(str, "scopeUri must not be null or empty");
        this.zzal = i2;
        this.zzdp = str;
        AppMethodBeat.o(4469);
    }

    public Scope(String str) {
        this(1, str);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(4470);
        if (this == obj) {
            AppMethodBeat.o(4470);
            return true;
        } else if (!(obj instanceof Scope)) {
            AppMethodBeat.o(4470);
            return false;
        } else {
            boolean equals = this.zzdp.equals(((Scope) obj).zzdp);
            AppMethodBeat.o(4470);
            return equals;
        }
    }

    @KeepForSdk
    public final String getScopeUri() {
        return this.zzdp;
    }

    public final int hashCode() {
        AppMethodBeat.i(4471);
        int hashCode = this.zzdp.hashCode();
        AppMethodBeat.o(4471);
        return hashCode;
    }

    public final String toString() {
        return this.zzdp;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4472);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeString(parcel, 2, getScopeUri(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(4472);
    }
}
