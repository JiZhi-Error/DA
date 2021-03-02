package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@SafeParcelable.Class(creator = "AncsNotificationParcelableCreator")
@SafeParcelable.Reserved({1})
@Immutable
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getId", id = 2)
    private int id;
    @Nullable
    @SafeParcelable.Field(getter = "getPackageName", id = 13)
    private final String packageName;
    @SafeParcelable.Field(getter = "getAppId", id = 3)
    private final String zzbf;
    @Nullable
    @SafeParcelable.Field(getter = "getDateTime", id = 4)
    private final String zzbg;
    @SafeParcelable.Field(getter = "getNotificationText", id = 5)
    private final String zzbh;
    @SafeParcelable.Field(getter = "getTitle", id = 6)
    private final String zzbi;
    @SafeParcelable.Field(getter = "getSubtitle", id = 7)
    private final String zzbj;
    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 8)
    private final String zzbk;
    @SafeParcelable.Field(getter = "getEventId", id = 9)
    private final byte zzbl;
    @SafeParcelable.Field(getter = "getEventFlags", id = 10)
    private final byte zzbm;
    @SafeParcelable.Field(getter = "getCategoryId", id = 11)
    private final byte zzbn;
    @SafeParcelable.Field(getter = "getCategoryCount", id = 12)
    private final byte zzbo;

    static {
        AppMethodBeat.i(101436);
        AppMethodBeat.o(101436);
    }

    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) @Nullable String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) @Nullable String str6, @SafeParcelable.Param(id = 9) byte b2, @SafeParcelable.Param(id = 10) byte b3, @SafeParcelable.Param(id = 11) byte b4, @SafeParcelable.Param(id = 12) byte b5, @SafeParcelable.Param(id = 13) @Nullable String str7) {
        this.id = i2;
        this.zzbf = str;
        this.zzbg = str2;
        this.zzbh = str3;
        this.zzbi = str4;
        this.zzbj = str5;
        this.zzbk = str6;
        this.zzbl = b2;
        this.zzbm = b3;
        this.zzbn = b4;
        this.zzbo = b5;
        this.packageName = str7;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101434);
        if (this == obj) {
            AppMethodBeat.o(101434);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(101434);
            return false;
        } else {
            zzl zzl = (zzl) obj;
            if (this.id != zzl.id) {
                AppMethodBeat.o(101434);
                return false;
            } else if (this.zzbl != zzl.zzbl) {
                AppMethodBeat.o(101434);
                return false;
            } else if (this.zzbm != zzl.zzbm) {
                AppMethodBeat.o(101434);
                return false;
            } else if (this.zzbn != zzl.zzbn) {
                AppMethodBeat.o(101434);
                return false;
            } else if (this.zzbo != zzl.zzbo) {
                AppMethodBeat.o(101434);
                return false;
            } else if (!this.zzbf.equals(zzl.zzbf)) {
                AppMethodBeat.o(101434);
                return false;
            } else if (this.zzbg == null ? zzl.zzbg != null : !this.zzbg.equals(zzl.zzbg)) {
                AppMethodBeat.o(101434);
                return false;
            } else if (!this.zzbh.equals(zzl.zzbh)) {
                AppMethodBeat.o(101434);
                return false;
            } else if (!this.zzbi.equals(zzl.zzbi)) {
                AppMethodBeat.o(101434);
                return false;
            } else if (!this.zzbj.equals(zzl.zzbj)) {
                AppMethodBeat.o(101434);
                return false;
            } else if (this.zzbk == null ? zzl.zzbk != null : !this.zzbk.equals(zzl.zzbk)) {
                AppMethodBeat.o(101434);
                return false;
            } else if (this.packageName != null) {
                boolean equals = this.packageName.equals(zzl.packageName);
                AppMethodBeat.o(101434);
                return equals;
            } else if (zzl.packageName == null) {
                AppMethodBeat.o(101434);
                return true;
            } else {
                AppMethodBeat.o(101434);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(101435);
        int hashCode = ((((((((((this.zzbk != null ? this.zzbk.hashCode() : 0) + (((((((((this.zzbg != null ? this.zzbg.hashCode() : 0) + ((((this.id + 31) * 31) + this.zzbf.hashCode()) * 31)) * 31) + this.zzbh.hashCode()) * 31) + this.zzbi.hashCode()) * 31) + this.zzbj.hashCode()) * 31)) * 31) + this.zzbl) * 31) + this.zzbm) * 31) + this.zzbn) * 31) + this.zzbo) * 31;
        if (this.packageName != null) {
            i2 = this.packageName.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(101435);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(101433);
        int i2 = this.id;
        String str = this.zzbf;
        String str2 = this.zzbg;
        String str3 = this.zzbh;
        String str4 = this.zzbi;
        String str5 = this.zzbj;
        String str6 = this.zzbk;
        byte b2 = this.zzbl;
        byte b3 = this.zzbm;
        byte b4 = this.zzbn;
        byte b5 = this.zzbo;
        String str7 = this.packageName;
        String sb = new StringBuilder(String.valueOf(str).length() + 211 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length()).append("AncsNotificationParcelable{, id=").append(i2).append(", appId='").append(str).append('\'').append(", dateTime='").append(str2).append('\'').append(", notificationText='").append(str3).append('\'').append(", title='").append(str4).append('\'').append(", subtitle='").append(str5).append('\'').append(", displayName='").append(str6).append('\'').append(", eventId=").append((int) b2).append(", eventFlags=").append((int) b3).append(", categoryId=").append((int) b4).append(", categoryCount=").append((int) b5).append(", packageName='").append(str7).append('\'').append('}').toString();
        AppMethodBeat.o(101433);
        return sb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101432);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.id);
        SafeParcelWriter.writeString(parcel, 3, this.zzbf, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzbg, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbh, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbi, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzbj, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzbk == null ? this.zzbf : this.zzbk, false);
        SafeParcelWriter.writeByte(parcel, 9, this.zzbl);
        SafeParcelWriter.writeByte(parcel, 10, this.zzbm);
        SafeParcelWriter.writeByte(parcel, 11, this.zzbn);
        SafeParcelWriter.writeByte(parcel, 12, this.zzbo);
        SafeParcelWriter.writeString(parcel, 13, this.packageName, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101432);
    }
}
