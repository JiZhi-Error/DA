package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "AccountChangeEventCreator")
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zzd();
    @SafeParcelable.VersionField(id = 1)
    private final int zzh;
    @SafeParcelable.Field(id = 2)
    private final long zzi;
    @SafeParcelable.Field(id = 3)
    private final String zzj;
    @SafeParcelable.Field(id = 4)
    private final int zzk;
    @SafeParcelable.Field(id = 5)
    private final int zzl;
    @SafeParcelable.Field(id = 6)
    private final String zzm;

    static {
        AppMethodBeat.i(10586);
        AppMethodBeat.o(10586);
    }

    @SafeParcelable.Constructor
    AccountChangeEvent(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) String str2) {
        AppMethodBeat.i(10580);
        this.zzh = i2;
        this.zzi = j2;
        this.zzj = (String) Preconditions.checkNotNull(str);
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = str2;
        AppMethodBeat.o(10580);
    }

    public AccountChangeEvent(long j2, String str, int i2, int i3, String str2) {
        AppMethodBeat.i(10581);
        this.zzh = 1;
        this.zzi = j2;
        this.zzj = (String) Preconditions.checkNotNull(str);
        this.zzk = i2;
        this.zzl = i3;
        this.zzm = str2;
        AppMethodBeat.o(10581);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(10585);
        if (obj == this) {
            AppMethodBeat.o(10585);
            return true;
        } else if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            if (this.zzh == accountChangeEvent.zzh && this.zzi == accountChangeEvent.zzi && Objects.equal(this.zzj, accountChangeEvent.zzj) && this.zzk == accountChangeEvent.zzk && this.zzl == accountChangeEvent.zzl && Objects.equal(this.zzm, accountChangeEvent.zzm)) {
                AppMethodBeat.o(10585);
                return true;
            }
            AppMethodBeat.o(10585);
            return false;
        } else {
            AppMethodBeat.o(10585);
            return false;
        }
    }

    public String getAccountName() {
        return this.zzj;
    }

    public String getChangeData() {
        return this.zzm;
    }

    public int getChangeType() {
        return this.zzk;
    }

    public int getEventIndex() {
        return this.zzl;
    }

    public int hashCode() {
        AppMethodBeat.i(10584);
        int hashCode = Objects.hashCode(Integer.valueOf(this.zzh), Long.valueOf(this.zzi), this.zzj, Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), this.zzm);
        AppMethodBeat.o(10584);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.i(10583);
        String str = "UNKNOWN";
        switch (this.zzk) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        String str2 = this.zzj;
        String str3 = this.zzm;
        String sb = new StringBuilder(String.valueOf(str2).length() + 91 + String.valueOf(str).length() + String.valueOf(str3).length()).append("AccountChangeEvent {accountName = ").append(str2).append(", changeType = ").append(str).append(", changeData = ").append(str3).append(", eventIndex = ").append(this.zzl).append("}").toString();
        AppMethodBeat.o(10583);
        return sb;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10582);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzh);
        SafeParcelWriter.writeLong(parcel, 2, this.zzi);
        SafeParcelWriter.writeString(parcel, 3, this.zzj, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzk);
        SafeParcelWriter.writeInt(parcel, 5, this.zzl);
        SafeParcelWriter.writeString(parcel, 6, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10582);
    }
}
