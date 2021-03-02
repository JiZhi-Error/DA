package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceResult;", "Landroid/os/Parcelable;", "errCode", "", "errMsg", "", "(ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
final class BindRemoteServiceResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    final int errCode;
    final String errMsg;

    @l(hxD = {1, 1, 16})
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(227903);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            BindRemoteServiceResult bindRemoteServiceResult = new BindRemoteServiceResult(parcel.readInt(), parcel.readString());
            AppMethodBeat.o(227903);
            return bindRemoteServiceResult;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new BindRemoteServiceResult[i2];
        }
    }

    static {
        AppMethodBeat.i(227908);
        AppMethodBeat.o(227908);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (kotlin.g.b.p.j(r3.errMsg, r4.errMsg) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 227906(0x37a42, float:3.19364E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.BindRemoteServiceResult
            if (r0 == 0) goto L_0x0023
            com.tencent.mm.plugin.appbrand.BindRemoteServiceResult r4 = (com.tencent.mm.plugin.appbrand.BindRemoteServiceResult) r4
            int r0 = r3.errCode
            int r1 = r4.errCode
            if (r0 != r1) goto L_0x0023
            java.lang.String r0 = r3.errMsg
            java.lang.String r1 = r4.errMsg
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.BindRemoteServiceResult.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(227905);
        int i2 = this.errCode * 31;
        String str = this.errMsg;
        int hashCode = (str != null ? str.hashCode() : 0) + i2;
        AppMethodBeat.o(227905);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(227904);
        String str = "BindRemoteServiceResult(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
        AppMethodBeat.o(227904);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(227907);
        p.h(parcel, "parcel");
        parcel.writeInt(this.errCode);
        parcel.writeString(this.errMsg);
        AppMethodBeat.o(227907);
    }

    public /* synthetic */ BindRemoteServiceResult(int i2) {
        this(i2, null);
    }

    public BindRemoteServiceResult(int i2, String str) {
        this.errCode = i2;
        this.errMsg = str;
    }
}
