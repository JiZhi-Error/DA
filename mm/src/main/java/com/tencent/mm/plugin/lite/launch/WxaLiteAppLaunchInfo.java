package com.tencent.mm.plugin.lite.launch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\"H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "pkgPath", "getPkgPath", "setPkgPath", "qrUrlQueryStr", "getQrUrlQueryStr", "setQrUrlQueryStr", SearchIntents.EXTRA_QUERY, "getQuery", "setQuery", "signatureKey", "getSignatureKey", "setSignatureKey", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "describeContents", "", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "luggage-lite-app_release"})
public final class WxaLiteAppLaunchInfo implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    public String appId;
    public String crh;
    public String path;
    public String pkgPath;
    public String query;
    public long startTime;
    public String yEx;

    static {
        AppMethodBeat.i(198973);
        AppMethodBeat.o(198973);
    }

    public WxaLiteAppLaunchInfo() {
        this.appId = "";
        this.pkgPath = "";
        this.crh = "";
        this.path = "";
        this.query = "";
        this.yEx = "";
    }

    public final void setAppId(String str) {
        AppMethodBeat.i(198969);
        p.h(str, "<set-?>");
        this.appId = str;
        AppMethodBeat.o(198969);
    }

    public final String toString() {
        AppMethodBeat.i(198970);
        String str = "appId:" + this.appId + " \n pkgPath: " + this.pkgPath + " signatureKey :xxx";
        AppMethodBeat.o(198970);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(198971);
        p.h(parcel, "dest");
        parcel.writeString(this.appId);
        parcel.writeString(this.pkgPath);
        parcel.writeString(this.crh);
        parcel.writeString(this.path);
        parcel.writeString(this.query);
        parcel.writeString(this.yEx);
        parcel.writeLong(this.startTime);
        AppMethodBeat.o(198971);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WxaLiteAppLaunchInfo(Parcel parcel) {
        this();
        p.h(parcel, "parcel");
        AppMethodBeat.i(198972);
        String readString = parcel.readString();
        this.appId = readString == null ? "" : readString;
        this.pkgPath = parcel.readString();
        this.crh = parcel.readString();
        this.path = parcel.readString();
        this.query = parcel.readString();
        this.yEx = parcel.readString();
        this.startTime = parcel.readLong();
        AppMethodBeat.o(198972);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "luggage-lite-app_release"})
    public static final class a implements Parcelable.Creator<WxaLiteAppLaunchInfo> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxaLiteAppLaunchInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(198968);
            p.h(parcel, "parcel");
            WxaLiteAppLaunchInfo wxaLiteAppLaunchInfo = new WxaLiteAppLaunchInfo(parcel);
            AppMethodBeat.o(198968);
            return wxaLiteAppLaunchInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxaLiteAppLaunchInfo[] newArray(int i2) {
            return new WxaLiteAppLaunchInfo[i2];
        }
    }
}
