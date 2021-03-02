package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandLaunchFromNotifyReferrer implements Parcelable {
    public static final Parcelable.Creator<AppBrandLaunchFromNotifyReferrer> CREATOR = new Parcelable.Creator<AppBrandLaunchFromNotifyReferrer>() {
        /* class com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandLaunchFromNotifyReferrer[] newArray(int i2) {
            return new AppBrandLaunchFromNotifyReferrer[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandLaunchFromNotifyReferrer createFromParcel(Parcel parcel) {
            AppMethodBeat.i(225276);
            AppBrandLaunchFromNotifyReferrer appBrandLaunchFromNotifyReferrer = new AppBrandLaunchFromNotifyReferrer(parcel, (byte) 0);
            AppMethodBeat.o(225276);
            return appBrandLaunchFromNotifyReferrer;
        }
    };
    public String appId;
    public String content;
    public int lej;
    public String lek;
    public int lel;
    public String lem;
    public int uin;

    /* synthetic */ AppBrandLaunchFromNotifyReferrer(Parcel parcel, byte b2) {
        this(parcel);
    }

    public AppBrandLaunchFromNotifyReferrer() {
    }

    public final String toString() {
        AppMethodBeat.i(225277);
        String str = "AppBrandLaunchFromNotifyReferrer{appId=" + this.appId + ", uin='" + this.uin + '\'' + ", readscene='" + this.lej + '\'' + ", appbrandPushMsgId='" + this.lek + '\'' + ", content='" + this.content + '\'' + ", opLocation='" + this.lel + '\'' + ", reportSessionId='" + this.lem + '\'' + '}';
        AppMethodBeat.o(225277);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(225278);
        parcel.writeString(this.appId);
        parcel.writeInt(this.uin);
        parcel.writeInt(this.lej);
        parcel.writeString(this.lek);
        parcel.writeString(this.content);
        parcel.writeInt(this.lel);
        parcel.writeString(this.lem);
        AppMethodBeat.o(225278);
    }

    public final int describeContents() {
        return 0;
    }

    private AppBrandLaunchFromNotifyReferrer(Parcel parcel) {
        AppMethodBeat.i(225279);
        this.appId = parcel.readString();
        this.uin = parcel.readInt();
        this.lej = parcel.readInt();
        this.lek = parcel.readString();
        this.content = parcel.readString();
        this.lel = parcel.readInt();
        this.lem = parcel.readString();
        AppMethodBeat.o(225279);
    }

    static {
        AppMethodBeat.i(225280);
        AppMethodBeat.o(225280);
    }
}
