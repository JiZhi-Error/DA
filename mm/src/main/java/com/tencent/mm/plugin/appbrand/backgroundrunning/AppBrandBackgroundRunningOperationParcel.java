package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandBackgroundRunningOperationParcel implements Parcelable {
    public static final Parcelable.Creator<AppBrandBackgroundRunningOperationParcel> CREATOR = new Parcelable.Creator<AppBrandBackgroundRunningOperationParcel>() {
        /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandBackgroundRunningOperationParcel[] newArray(int i2) {
            return new AppBrandBackgroundRunningOperationParcel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandBackgroundRunningOperationParcel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(153209);
            AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel(parcel);
            AppMethodBeat.o(153209);
            return appBrandBackgroundRunningOperationParcel;
        }
    };
    public String appId;
    public int beL;
    public int dDe;
    public int iOo;
    public String icon;
    public String kYe;
    public String kYf;
    public boolean kYo = false;
    public String name;
    public String process;
    public String username;

    public AppBrandBackgroundRunningOperationParcel() {
    }

    protected AppBrandBackgroundRunningOperationParcel(Parcel parcel) {
        AppMethodBeat.i(153210);
        this.appId = parcel.readString();
        this.iOo = parcel.readInt();
        this.beL = parcel.readInt();
        this.dDe = parcel.readInt();
        this.kYe = parcel.readString();
        this.name = parcel.readString();
        this.icon = parcel.readString();
        this.username = parcel.readString();
        this.process = parcel.readString();
        this.kYf = parcel.readString();
        AppMethodBeat.o(153210);
    }

    public String toString() {
        AppMethodBeat.i(153211);
        String str = "operation{appId='" + this.appId + '\'' + ", versionType=" + this.iOo + ", usage=" + this.beL + ", operation=" + this.dDe + ", uiclass='" + this.kYe + '\'' + ", name='" + this.name + '\'' + ", icon='" + this.icon + '\'' + ", username='" + this.username + '\'' + ", process='" + this.process + '\'' + ", customNotificationLogicClassName='" + this.kYf + '\'' + ", justNotify=" + this.kYo + '}';
        AppMethodBeat.o(153211);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(153212);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iOo);
        parcel.writeInt(this.beL);
        parcel.writeInt(this.dDe);
        parcel.writeString(this.kYe);
        parcel.writeString(this.name);
        parcel.writeString(this.icon);
        parcel.writeString(this.username);
        parcel.writeString(this.process);
        parcel.writeString(this.kYf);
        AppMethodBeat.o(153212);
    }

    static {
        AppMethodBeat.i(153213);
        AppMethodBeat.o(153213);
    }
}
