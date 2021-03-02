package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "NodeParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzfo extends AbstractSafeParcelable implements Node {
    public static final Parcelable.Creator<zzfo> CREATOR = new zzfp();
    @SafeParcelable.Field(getter = "getDisplayName", id = 3)
    private final String zzbk;
    @SafeParcelable.Field(getter = "getId", id = 2)
    private final String zzdm;
    @SafeParcelable.Field(getter = "getHopCount", id = 4)
    private final int zzen;
    @SafeParcelable.Field(getter = "isNearby", id = 5)
    private final boolean zzeo;

    static {
        AppMethodBeat.i(101315);
        AppMethodBeat.o(101315);
    }

    @SafeParcelable.Constructor
    public zzfo(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z) {
        this.zzdm = str;
        this.zzbk = str2;
        this.zzen = i2;
        this.zzeo = z;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101312);
        if (!(obj instanceof zzfo)) {
            AppMethodBeat.o(101312);
            return false;
        }
        boolean equals = ((zzfo) obj).zzdm.equals(this.zzdm);
        AppMethodBeat.o(101312);
        return equals;
    }

    @Override // com.google.android.gms.wearable.Node
    public final String getDisplayName() {
        return this.zzbk;
    }

    @Override // com.google.android.gms.wearable.Node
    public final String getId() {
        return this.zzdm;
    }

    public final int hashCode() {
        AppMethodBeat.i(101313);
        int hashCode = this.zzdm.hashCode();
        AppMethodBeat.o(101313);
        return hashCode;
    }

    @Override // com.google.android.gms.wearable.Node
    public final boolean isNearby() {
        return this.zzeo;
    }

    public final String toString() {
        AppMethodBeat.i(101314);
        String str = this.zzbk;
        String str2 = this.zzdm;
        int i2 = this.zzen;
        String sb = new StringBuilder(String.valueOf(str).length() + 45 + String.valueOf(str2).length()).append("Node{").append(str).append(", id=").append(str2).append(", hops=").append(i2).append(", isNearby=").append(this.zzeo).append("}").toString();
        AppMethodBeat.o(101314);
        return sb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101311);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzen);
        SafeParcelWriter.writeBoolean(parcel, 5, isNearby());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101311);
    }
}
