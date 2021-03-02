package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
public final class zzjx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjx> CREATOR = new zzjy();
    @SafeParcelable.Field(id = 2)
    public final String name;
    @SafeParcelable.Field(id = 7)
    public final String origin;
    @SafeParcelable.Field(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(id = 6)
    private final String zzajf;
    @SafeParcelable.Field(id = 3)
    public final long zzaqz;
    @SafeParcelable.Field(id = 4)
    private final Long zzara;
    @SafeParcelable.Field(id = 5)
    private final Float zzarb;
    @SafeParcelable.Field(id = 8)
    private final Double zzarc;

    static {
        AppMethodBeat.i(TXLiteAVCode.EVT_VOD_PLAY_DNS_RESOLVED);
        AppMethodBeat.o(TXLiteAVCode.EVT_VOD_PLAY_DNS_RESOLVED);
    }

    @SafeParcelable.Constructor
    zzjx(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) Long l, @SafeParcelable.Param(id = 5) Float f2, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Double d2) {
        Double d3 = null;
        AppMethodBeat.i(2016);
        this.versionCode = i2;
        this.name = str;
        this.zzaqz = j2;
        this.zzara = l;
        this.zzarb = null;
        if (i2 == 1) {
            this.zzarc = f2 != null ? Double.valueOf(f2.doubleValue()) : d3;
        } else {
            this.zzarc = d2;
        }
        this.zzajf = str2;
        this.origin = str3;
        AppMethodBeat.o(2016);
    }

    zzjx(zzjz zzjz) {
        this(zzjz.name, zzjz.zzaqz, zzjz.value, zzjz.origin);
    }

    zzjx(String str, long j2, Object obj, String str2) {
        AppMethodBeat.i(2015);
        Preconditions.checkNotEmpty(str);
        this.versionCode = 2;
        this.name = str;
        this.zzaqz = j2;
        this.origin = str2;
        if (obj == null) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = null;
            AppMethodBeat.o(2015);
        } else if (obj instanceof Long) {
            this.zzara = (Long) obj;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = null;
            AppMethodBeat.o(2015);
        } else if (obj instanceof String) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = (String) obj;
            AppMethodBeat.o(2015);
        } else if (obj instanceof Double) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = (Double) obj;
            this.zzajf = null;
            AppMethodBeat.o(2015);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("User attribute given of un-supported type");
            AppMethodBeat.o(2015);
            throw illegalArgumentException;
        }
    }

    public final Object getValue() {
        if (this.zzara != null) {
            return this.zzara;
        }
        if (this.zzarc != null) {
            return this.zzarc;
        }
        if (this.zzajf != null) {
            return this.zzajf;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(TXLiteAVCode.EVT_VOD_PLAY_FIRST_VIDEO_PACKET);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzaqz);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzara, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzajf, false);
        SafeParcelWriter.writeString(parcel, 7, this.origin, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzarc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(TXLiteAVCode.EVT_VOD_PLAY_FIRST_VIDEO_PACKET);
    }
}
