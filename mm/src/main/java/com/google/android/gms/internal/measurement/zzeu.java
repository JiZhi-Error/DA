package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzeu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeu> CREATOR = new zzev();
    @SafeParcelable.Field(id = 2)
    public final String name;
    @SafeParcelable.Field(id = 4)
    public final String origin;
    @SafeParcelable.Field(id = 3)
    public final zzer zzafq;
    @SafeParcelable.Field(id = 5)
    public final long zzagb;

    static {
        AppMethodBeat.i(1271);
        AppMethodBeat.o(1271);
    }

    zzeu(zzeu zzeu, long j2) {
        AppMethodBeat.i(1268);
        Preconditions.checkNotNull(zzeu);
        this.name = zzeu.name;
        this.zzafq = zzeu.zzafq;
        this.origin = zzeu.origin;
        this.zzagb = j2;
        AppMethodBeat.o(1268);
    }

    @SafeParcelable.Constructor
    public zzeu(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) zzer zzer, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) long j2) {
        this.name = str;
        this.zzafq = zzer;
        this.origin = str2;
        this.zzagb = j2;
    }

    public final String toString() {
        AppMethodBeat.i(1269);
        String str = this.origin;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzafq);
        String sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(valueOf).toString();
        AppMethodBeat.o(1269);
        return sb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(1270);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzafq, i2, false);
        SafeParcelWriter.writeString(parcel, 4, this.origin, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzagb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(1270);
    }
}
