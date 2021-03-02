package com.tencent.mm.plugin.appbrand.shortlink.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\b\u0010 \u001a\u00020\u0003H\u0016J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "Landroid/os/Parcelable;", "appId", "", "pageTitle", "path", "version", "", "versionType", "nickName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getNickName", "getPageTitle", "getPath", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"})
public final class WxaShortLinkInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new b();
    public static final a nOb = new a((byte) 0);
    public final String appId;
    public final int iOo;
    private final String nbg;
    public final String nickName;
    public final String path;
    public final int version;

    @l(hxD = {1, 1, 16})
    public static class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(230184);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            WxaShortLinkInfo wxaShortLinkInfo = new WxaShortLinkInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
            AppMethodBeat.o(230184);
            return wxaShortLinkInfo;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new WxaShortLinkInfo[i2];
        }
    }

    static {
        AppMethodBeat.i(230187);
        AppMethodBeat.o(230187);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (kotlin.g.b.p.j(r3.nickName, r4.nickName) != false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 230189(0x3832d, float:3.22563E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0042
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo
            if (r0 == 0) goto L_0x0047
            com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo r4 = (com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo) r4
            java.lang.String r0 = r3.appId
            java.lang.String r1 = r4.appId
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r3.nbg
            java.lang.String r1 = r4.nbg
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r3.path
            java.lang.String r1 = r4.path
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
            int r0 = r3.version
            int r1 = r4.version
            if (r0 != r1) goto L_0x0047
            int r0 = r3.iOo
            int r1 = r4.iOo
            if (r0 != r1) goto L_0x0047
            java.lang.String r0 = r3.nickName
            java.lang.String r1 = r4.nickName
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
        L_0x0042:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(230188);
        String str = this.appId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nbg;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.path;
        int hashCode3 = ((((((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31) + this.version) * 31) + this.iOo) * 31;
        String str4 = this.nickName;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode3 + i2;
        AppMethodBeat.o(230188);
        return i3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(230190);
        p.h(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeString(this.nbg);
        parcel.writeString(this.path);
        parcel.writeInt(this.version);
        parcel.writeInt(this.iOo);
        parcel.writeString(this.nickName);
        AppMethodBeat.o(230190);
    }

    public WxaShortLinkInfo(String str, String str2, String str3, int i2, int i3, String str4) {
        p.h(str, "appId");
        p.h(str2, "pageTitle");
        p.h(str3, "path");
        p.h(str4, "nickName");
        AppMethodBeat.i(230186);
        this.appId = str;
        this.nbg = str2;
        this.path = str3;
        this.version = i2;
        this.iOo = i3;
        this.nickName = str4;
        AppMethodBeat.o(230186);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo$Companion;", "", "()V", "make", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckShortLinkResp;", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final String toString() {
        AppMethodBeat.i(230185);
        String str = "WxaShortLinkInfo(\nappId='" + this.appId + "'\npageTitle='" + this.nbg + "'\npath='" + this.path + "'\nversion=" + this.version + '\n' + "versionType=" + this.iOo + '\n' + "nickName=" + this.nickName + ')';
        AppMethodBeat.o(230185);
        return str;
    }
}
