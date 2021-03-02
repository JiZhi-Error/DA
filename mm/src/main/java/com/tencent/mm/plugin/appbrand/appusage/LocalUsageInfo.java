package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public class LocalUsageInfo implements Parcelable {
    public static final Parcelable.Creator<LocalUsageInfo> CREATOR = new Parcelable.Creator<LocalUsageInfo>() {
        /* class com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalUsageInfo[] newArray(int i2) {
            return new LocalUsageInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalUsageInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(153197);
            LocalUsageInfo localUsageInfo = new LocalUsageInfo(parcel, (byte) 0);
            AppMethodBeat.o(153197);
            return localUsageInfo;
        }
    };
    public final String appId;
    public final int appVersion;
    public final String cyB;
    public final long czf;
    public final int iOo;
    public final String kVZ;
    public final boolean kWa;
    public final long kWb;
    public final boolean kWc;
    public final String kWd;
    public final String nickname;
    public final String username;

    /* synthetic */ LocalUsageInfo(Parcel parcel, byte b2) {
        this(parcel);
    }

    public LocalUsageInfo(String str, String str2, int i2, int i3, String str3, String str4, String str5, boolean z, long j2, long j3, boolean z2, String str6) {
        this.username = str;
        this.appId = str2;
        this.iOo = i2;
        this.appVersion = i3;
        this.nickname = str3;
        this.cyB = str4;
        this.kVZ = str5;
        this.kWa = z;
        this.czf = j2;
        this.kWb = j3;
        this.kWc = z2;
        this.kWd = str6;
    }

    public LocalUsageInfo(String str, String str2, int i2, int i3, String str3, String str4, String str5, long j2) {
        this(str, str2, i2, i3, str3, str4, str5, false, j2, 0, false, "");
    }

    public final boolean g(LocalUsageInfo localUsageInfo) {
        AppMethodBeat.i(153198);
        if (localUsageInfo == null) {
            AppMethodBeat.o(153198);
            return false;
        } else if (Util.isNullOrNil(localUsageInfo.username)) {
            AppMethodBeat.o(153198);
            return false;
        } else if (!localUsageInfo.username.equals(this.username) || localUsageInfo.iOo != this.iOo) {
            AppMethodBeat.o(153198);
            return false;
        } else {
            AppMethodBeat.o(153198);
            return true;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(153199);
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iOo);
        parcel.writeInt(this.appVersion);
        parcel.writeString(this.nickname);
        parcel.writeString(this.cyB);
        parcel.writeString(this.kVZ);
        parcel.writeByte((byte) (this.kWa ? 1 : 0));
        parcel.writeLong(this.czf);
        parcel.writeLong(this.kWb);
        if (!this.kWc) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.kWd);
        AppMethodBeat.o(153199);
    }

    private LocalUsageInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(153200);
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.iOo = parcel.readInt();
        this.appVersion = parcel.readInt();
        this.nickname = parcel.readString();
        this.cyB = parcel.readString();
        this.kVZ = parcel.readString();
        this.kWa = parcel.readByte() > 0;
        this.czf = parcel.readLong();
        this.kWb = parcel.readLong();
        this.kWc = parcel.readByte() <= 0 ? false : z;
        this.kWd = parcel.readString();
        AppMethodBeat.o(153200);
    }

    static {
        AppMethodBeat.i(153201);
        AppMethodBeat.o(153201);
    }
}
