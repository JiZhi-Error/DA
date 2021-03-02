package com.tencent.mm.plugin.kidswatch.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KidsWatchAcctInfo implements Parcelable {
    public static final Parcelable.Creator<KidsWatchAcctInfo> CREATOR = new Parcelable.Creator<KidsWatchAcctInfo>() {
        /* class com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ KidsWatchAcctInfo[] newArray(int i2) {
            return new KidsWatchAcctInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ KidsWatchAcctInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(256394);
            KidsWatchAcctInfo kidsWatchAcctInfo = new KidsWatchAcctInfo(parcel);
            AppMethodBeat.o(256394);
            return kidsWatchAcctInfo;
        }
    };
    public String deviceName;
    public String iAR;
    public String nickName;
    public String userName;
    public int yAy;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(256395);
        parcel.writeInt(this.yAy);
        parcel.writeString(this.userName);
        parcel.writeString(this.nickName);
        parcel.writeString(this.deviceName);
        parcel.writeString(this.iAR);
        AppMethodBeat.o(256395);
    }

    public KidsWatchAcctInfo(String str, String str2, String str3, String str4, int i2) {
        this.yAy = i2;
        this.userName = str;
        this.nickName = str2;
        this.deviceName = str4;
        this.iAR = str3;
    }

    protected KidsWatchAcctInfo(Parcel parcel) {
        AppMethodBeat.i(256396);
        this.yAy = parcel.readInt();
        this.userName = parcel.readString();
        this.nickName = parcel.readString();
        this.deviceName = parcel.readString();
        this.iAR = parcel.readString();
        AppMethodBeat.o(256396);
    }

    static {
        AppMethodBeat.i(256397);
        AppMethodBeat.o(256397);
    }
}
