package com.tencent.mm.plugin.appbrand.shortlink;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/UploadResult;", "Landroid/os/Parcelable;", "ret", "", "fileUrl", "", "(ZLjava/lang/String;)V", "getFileUrl", "()Ljava/lang/String;", "getRet", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class UploadResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    final boolean dFE;
    final String fileUrl;

    @l(hxD = {1, 1, 16})
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(229347);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            UploadResult uploadResult = new UploadResult(parcel.readInt() != 0, parcel.readString());
            AppMethodBeat.o(229347);
            return uploadResult;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new UploadResult[i2];
        }
    }

    static {
        AppMethodBeat.i(229354);
        AppMethodBeat.o(229354);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (kotlin.g.b.p.j(r3.fileUrl, r4.fileUrl) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 229352(0x37fe8, float:3.2139E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.shortlink.UploadResult
            if (r0 == 0) goto L_0x0023
            com.tencent.mm.plugin.appbrand.shortlink.UploadResult r4 = (com.tencent.mm.plugin.appbrand.shortlink.UploadResult) r4
            boolean r0 = r3.dFE
            boolean r1 = r4.dFE
            if (r0 != r1) goto L_0x0023
            java.lang.String r0 = r3.fileUrl
            java.lang.String r1 = r4.fileUrl
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0023
        L_0x001e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0022:
            return r0
        L_0x0023:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.shortlink.UploadResult.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(229351);
        boolean z = this.dFE;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 * 31;
        String str = this.fileUrl;
        int hashCode = (str != null ? str.hashCode() : 0) + i5;
        AppMethodBeat.o(229351);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(229350);
        String str = "UploadResult(ret=" + this.dFE + ", fileUrl=" + this.fileUrl + ")";
        AppMethodBeat.o(229350);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(229353);
        p.h(parcel, "parcel");
        parcel.writeInt(this.dFE ? 1 : 0);
        parcel.writeString(this.fileUrl);
        AppMethodBeat.o(229353);
    }

    public /* synthetic */ UploadResult() {
        this(false, "");
        AppMethodBeat.i(229349);
        AppMethodBeat.o(229349);
    }

    public UploadResult(boolean z, String str) {
        p.h(str, "fileUrl");
        AppMethodBeat.i(229348);
        this.dFE = z;
        this.fileUrl = str;
        AppMethodBeat.o(229348);
    }
}
