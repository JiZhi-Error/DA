package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public class AppBrandBackgroundRunningApp implements Parcelable {
    public static final Parcelable.Creator<AppBrandBackgroundRunningApp> CREATOR = new Parcelable.Creator<AppBrandBackgroundRunningApp>() {
        /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandBackgroundRunningApp[] newArray(int i2) {
            return new AppBrandBackgroundRunningApp[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandBackgroundRunningApp createFromParcel(Parcel parcel) {
            AppMethodBeat.i(153202);
            AppBrandBackgroundRunningApp appBrandBackgroundRunningApp = new AppBrandBackgroundRunningApp(parcel);
            AppMethodBeat.o(153202);
            return appBrandBackgroundRunningApp;
        }
    };
    public String appId;
    public int beL;
    public int iOo;
    public String icon;
    public String kYe;
    public String kYf;
    public String name;
    public String process;
    public String username;

    public String toString() {
        AppMethodBeat.i(153203);
        String str = "AppBrandBackgroundRunningApp{appId='" + this.appId + '\'' + ", versionType=" + this.iOo + ", usage=" + this.beL + ", icon='" + this.icon + '\'' + ", name='" + this.name + '\'' + ", username='" + this.username + '\'' + ", uiclass='" + this.kYe + '\'' + ", process='" + this.process + '\'' + ", customNotificationLogicClassName='" + this.kYf + '\'' + '}';
        AppMethodBeat.o(153203);
        return str;
    }

    public AppBrandBackgroundRunningApp() {
    }

    protected AppBrandBackgroundRunningApp(Parcel parcel) {
        AppMethodBeat.i(153204);
        this.appId = parcel.readString();
        this.iOo = parcel.readInt();
        this.beL = parcel.readInt();
        this.icon = parcel.readString();
        this.name = parcel.readString();
        this.username = parcel.readString();
        this.kYe = parcel.readString();
        this.process = parcel.readString();
        this.kYf = parcel.readString();
        AppMethodBeat.o(153204);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(153205);
        if (this == obj) {
            AppMethodBeat.o(153205);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(153205);
            return false;
        } else {
            boolean equals = Objects.equals(this.appId, ((AppBrandBackgroundRunningApp) obj).appId);
            AppMethodBeat.o(153205);
            return equals;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(153206);
        int hash = Objects.hash(this.appId);
        AppMethodBeat.o(153206);
        return hash;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(153207);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iOo);
        parcel.writeInt(this.beL);
        parcel.writeString(this.icon);
        parcel.writeString(this.name);
        parcel.writeString(this.username);
        parcel.writeString(this.kYe);
        parcel.writeString(this.process);
        parcel.writeString(this.kYf);
        AppMethodBeat.o(153207);
    }

    static {
        AppMethodBeat.i(153208);
        AppMethodBeat.o(153208);
    }
}
