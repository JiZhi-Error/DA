package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaExposedParams implements Parcelable {
    public static final Parcelable.Creator<WxaExposedParams> CREATOR = new Parcelable.Creator<WxaExposedParams>() {
        /* class com.tencent.mm.plugin.appbrand.config.WxaExposedParams.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxaExposedParams[] newArray(int i2) {
            return new WxaExposedParams[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxaExposedParams createFromParcel(Parcel parcel) {
            AppMethodBeat.i(153219);
            WxaExposedParams wxaExposedParams = new WxaExposedParams(parcel);
            AppMethodBeat.o(153219);
            return wxaExposedParams;
        }
    };
    public String appId;
    public int from;
    public String iconUrl;
    public int kNW;
    public String lhn;
    public String lho;
    public String lhp;
    public String lhq;
    public String msgId;
    public String nickname;
    public String pageId;
    public int pkgVersion;
    public String sessionId;
    public String username;

    /* synthetic */ WxaExposedParams(a aVar, byte b2) {
        this(aVar);
    }

    private WxaExposedParams(a aVar) {
        this.appId = aVar.appId;
        this.username = aVar.username;
        this.nickname = aVar.nickname;
        this.iconUrl = aVar.iconUrl;
        this.kNW = aVar.kNW;
        this.pkgVersion = aVar.pkgVersion;
        this.lhn = aVar.lhn;
        this.from = aVar.from;
        this.pageId = aVar.pageId;
        this.lho = aVar.lho;
        this.lhp = aVar.lhp;
        this.sessionId = aVar.sessionId;
        this.lhq = aVar.lhq;
        this.msgId = aVar.msgId;
    }

    public static class a {
        public String appId = "";
        public int from = 0;
        public String iconUrl = "";
        public int kNW = -1;
        public String lhn = "";
        public String lho = "";
        public String lhp = "";
        public String lhq = "";
        public String msgId = "";
        public String nickname = "";
        public String pageId = "";
        public int pkgVersion = -1;
        public String sessionId = "";
        public String username = "";

        public final a XN(String str) {
            this.appId = str;
            return this;
        }

        public final a XO(String str) {
            this.username = str;
            return this;
        }

        public final a XP(String str) {
            this.nickname = str;
            return this;
        }

        public final a XQ(String str) {
            this.iconUrl = str;
            return this;
        }

        public final a wf(int i2) {
            this.pkgVersion = i2;
            return this;
        }

        public final a wg(int i2) {
            this.kNW = i2;
            return this;
        }

        public final a wh(int i2) {
            this.from = i2;
            return this;
        }

        public final a XR(String str) {
            this.pageId = str;
            return this;
        }

        public final WxaExposedParams bAv() {
            AppMethodBeat.i(153220);
            WxaExposedParams wxaExposedParams = new WxaExposedParams(this, (byte) 0);
            AppMethodBeat.o(153220);
            return wxaExposedParams;
        }
    }

    protected WxaExposedParams(Parcel parcel) {
        AppMethodBeat.i(153221);
        this.appId = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
        this.iconUrl = parcel.readString();
        this.kNW = parcel.readInt();
        this.pkgVersion = parcel.readInt();
        this.lhn = parcel.readString();
        this.from = parcel.readInt();
        this.pageId = parcel.readString();
        this.lho = parcel.readString();
        this.lhp = parcel.readString();
        this.sessionId = parcel.readString();
        this.lhq = parcel.readString();
        this.msgId = parcel.readString();
        AppMethodBeat.o(153221);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(153222);
        parcel.writeString(this.appId);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.kNW);
        parcel.writeInt(this.pkgVersion);
        parcel.writeString(this.lhn);
        parcel.writeInt(this.from);
        parcel.writeString(this.pageId);
        parcel.writeString(this.lho);
        parcel.writeString(this.lhp);
        parcel.writeString(this.sessionId);
        parcel.writeString(this.lhq);
        parcel.writeString(this.msgId);
        AppMethodBeat.o(153222);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(153224);
        AppMethodBeat.o(153224);
    }

    public String toString() {
        AppMethodBeat.i(153223);
        String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.kNW + ", pkgVersion=" + this.pkgVersion + ", pkgMD5='" + this.lhn + '\'' + ", from=" + this.from + ", pageId='" + this.pageId + '\'' + ", errorUrl='" + this.lho + '\'' + ", screenshotLocalId='" + this.lhp + '\'' + ", sessionId='" + this.sessionId + '\'' + ", businessAppId='" + this.lhq + '\'' + ", msgId='" + this.msgId + '\'' + '}';
        AppMethodBeat.o(153223);
        return str;
    }
}
