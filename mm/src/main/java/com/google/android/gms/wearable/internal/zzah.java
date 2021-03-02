package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

@SafeParcelable.Class(creator = "CapabilityInfoParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzah extends AbstractSafeParcelable implements CapabilityInfo {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();
    private final Object lock = new Object();
    @SafeParcelable.Field(getter = "getName", id = 2)
    private final String name;
    @GuardedBy("lock")
    private Set<Node> zzbt;
    @SafeParcelable.Field(getter = "getNodeParcelables", id = 3)
    private final List<zzfo> zzca;

    static {
        AppMethodBeat.i(100978);
        AppMethodBeat.o(100978);
    }

    @SafeParcelable.Constructor
    public zzah(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) List<zzfo> list) {
        AppMethodBeat.i(100972);
        this.name = str;
        this.zzca = list;
        this.zzbt = null;
        Preconditions.checkNotNull(this.name);
        Preconditions.checkNotNull(this.zzca);
        AppMethodBeat.o(100972);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100976);
        if (this == obj) {
            AppMethodBeat.o(100976);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(100976);
            return false;
        } else {
            zzah zzah = (zzah) obj;
            if (this.name == null ? zzah.name != null : !this.name.equals(zzah.name)) {
                AppMethodBeat.o(100976);
                return false;
            } else if (this.zzca == null ? zzah.zzca != null : !this.zzca.equals(zzah.zzca)) {
                AppMethodBeat.o(100976);
                return false;
            } else {
                AppMethodBeat.o(100976);
                return true;
            }
        }
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final String getName() {
        return this.name;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final Set<Node> getNodes() {
        Set<Node> set;
        AppMethodBeat.i(100973);
        synchronized (this.lock) {
            try {
                if (this.zzbt == null) {
                    this.zzbt = new HashSet(this.zzca);
                }
                set = this.zzbt;
            } finally {
                AppMethodBeat.o(100973);
            }
        }
        return set;
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(100977);
        int hashCode = ((this.name != null ? this.name.hashCode() : 0) + 31) * 31;
        if (this.zzca != null) {
            i2 = this.zzca.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(100977);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(100975);
        String str = this.name;
        String valueOf = String.valueOf(this.zzca);
        String sb = new StringBuilder(String.valueOf(str).length() + 18 + String.valueOf(valueOf).length()).append("CapabilityInfo{").append(str).append(", ").append(valueOf).append("}").toString();
        AppMethodBeat.o(100975);
        return sb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(100974);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzca, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(100974);
    }
}
