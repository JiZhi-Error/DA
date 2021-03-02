package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@SafeParcelable.Class(creator = "StorageInfoResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzge extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzge> CREATOR = new zzgf();
    @SafeParcelable.Field(id = 2)
    private final int statusCode;
    @SafeParcelable.Field(id = 3)
    private final long zzep;
    @SafeParcelable.Field(id = 4)
    private final List<zzfs> zzer;

    static {
        AppMethodBeat.i(101346);
        AppMethodBeat.o(101346);
    }

    @SafeParcelable.Constructor
    public zzge(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) List<zzfs> list) {
        this.statusCode = i2;
        this.zzep = j2;
        this.zzer = list;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101345);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeLong(parcel, 3, this.zzep);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzer, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101345);
    }
}
