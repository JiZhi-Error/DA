package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1})
public final class zzdz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdz> CREATOR = new zzea();
    @SafeParcelable.Field(id = 2)
    public final String packageName;
    @SafeParcelable.Field(id = 3)
    public final String zzadm;
    @SafeParcelable.Field(id = 12)
    public final String zzado;
    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MIN_VALUE", id = 11)
    public final long zzads;
    @SafeParcelable.Field(id = 5)
    public final String zzadt;
    @SafeParcelable.Field(id = 6)
    public final long zzadu;
    @SafeParcelable.Field(id = 7)
    public final long zzadv;
    @SafeParcelable.Field(defaultValue = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, id = 9)
    public final boolean zzadw;
    @SafeParcelable.Field(id = 13)
    public final long zzadx;
    @SafeParcelable.Field(defaultValue = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, id = 16)
    public final boolean zzady;
    @SafeParcelable.Field(defaultValue = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, id = 17)
    public final boolean zzadz;
    @SafeParcelable.Field(id = 8)
    public final String zzaek;
    @SafeParcelable.Field(id = 10)
    public final boolean zzael;
    @SafeParcelable.Field(id = 14)
    public final long zzaem;
    @SafeParcelable.Field(id = 15)
    public final int zzaen;
    @SafeParcelable.Field(id = 18)
    public final boolean zzaeo;
    @SafeParcelable.Field(id = 4)
    public final String zzth;

    static {
        AppMethodBeat.i(1105);
        AppMethodBeat.o(1105);
    }

    zzdz(String str, String str2, String str3, long j2, String str4, long j3, long j4, String str5, boolean z, boolean z2, String str6, long j5, long j6, int i2, boolean z3, boolean z4, boolean z5) {
        AppMethodBeat.i(1103);
        Preconditions.checkNotEmpty(str);
        this.packageName = str;
        this.zzadm = TextUtils.isEmpty(str2) ? null : str2;
        this.zzth = str3;
        this.zzads = j2;
        this.zzadt = str4;
        this.zzadu = j3;
        this.zzadv = j4;
        this.zzaek = str5;
        this.zzadw = z;
        this.zzael = z2;
        this.zzado = str6;
        this.zzadx = j5;
        this.zzaem = j6;
        this.zzaen = i2;
        this.zzady = z3;
        this.zzadz = z4;
        this.zzaeo = z5;
        AppMethodBeat.o(1103);
    }

    @SafeParcelable.Constructor
    zzdz(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) long j2, @SafeParcelable.Param(id = 7) long j3, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) boolean z, @SafeParcelable.Param(id = 10) boolean z2, @SafeParcelable.Param(id = 11) long j4, @SafeParcelable.Param(id = 12) String str6, @SafeParcelable.Param(id = 13) long j5, @SafeParcelable.Param(id = 14) long j6, @SafeParcelable.Param(id = 15) int i2, @SafeParcelable.Param(id = 16) boolean z3, @SafeParcelable.Param(id = 17) boolean z4, @SafeParcelable.Param(id = 18) boolean z5) {
        this.packageName = str;
        this.zzadm = str2;
        this.zzth = str3;
        this.zzads = j4;
        this.zzadt = str4;
        this.zzadu = j2;
        this.zzadv = j3;
        this.zzaek = str5;
        this.zzadw = z;
        this.zzael = z2;
        this.zzado = str6;
        this.zzadx = j5;
        this.zzaem = j6;
        this.zzaen = i2;
        this.zzady = z3;
        this.zzadz = z4;
        this.zzaeo = z5;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(1104);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzadm, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzth, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzadt, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzadu);
        SafeParcelWriter.writeLong(parcel, 7, this.zzadv);
        SafeParcelWriter.writeString(parcel, 8, this.zzaek, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzadw);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzael);
        SafeParcelWriter.writeLong(parcel, 11, this.zzads);
        SafeParcelWriter.writeString(parcel, 12, this.zzado, false);
        SafeParcelWriter.writeLong(parcel, 13, this.zzadx);
        SafeParcelWriter.writeLong(parcel, 14, this.zzaem);
        SafeParcelWriter.writeInt(parcel, 15, this.zzaen);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzady);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzadz);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzaeo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(1104);
    }
}
