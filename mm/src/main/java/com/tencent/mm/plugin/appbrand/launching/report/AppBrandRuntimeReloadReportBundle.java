package com.tencent.mm.plugin.appbrand.launching.report;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/report/AppBrandRuntimeReloadReportBundle;", "Landroid/os/Parcelable;", "refererInstanceId", "", "reloadReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getRefererInstanceId", "()Ljava/lang/String;", "setRefererInstanceId", "(Ljava/lang/String;)V", "getReloadReason", "setReloadReason", "component1", "component2", "copy", "describeContents", "", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimeReloadReportBundle implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public String mZr;
    public String mZs;

    @l(hxD = {1, 1, 16})
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(228755);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            AppBrandRuntimeReloadReportBundle appBrandRuntimeReloadReportBundle = new AppBrandRuntimeReloadReportBundle(parcel.readString(), parcel.readString());
            AppMethodBeat.o(228755);
            return appBrandRuntimeReloadReportBundle;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new AppBrandRuntimeReloadReportBundle[i2];
        }
    }

    static {
        AppMethodBeat.i(228761);
        AppMethodBeat.o(228761);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.mZs, r4.mZs) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 228759(0x37d97, float:3.2056E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle
            if (r0 == 0) goto L_0x0027
            com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle r4 = (com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle) r4
            java.lang.String r0 = r3.mZr
            java.lang.String r1 = r4.mZr
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r3.mZs
            java.lang.String r1 = r4.mZs
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
        L_0x0022:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0026:
            return r0
        L_0x0027:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(228758);
        String str = this.mZr;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mZs;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(228758);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(228757);
        String str = "AppBrandRuntimeReloadReportBundle(refererInstanceId=" + this.mZr + ", reloadReason=" + this.mZs + ")";
        AppMethodBeat.o(228757);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(228760);
        p.h(parcel, "parcel");
        parcel.writeString(this.mZr);
        parcel.writeString(this.mZs);
        AppMethodBeat.o(228760);
    }

    public AppBrandRuntimeReloadReportBundle(String str, String str2) {
        p.h(str, "refererInstanceId");
        AppMethodBeat.i(228756);
        this.mZr = str;
        this.mZs = str2;
        AppMethodBeat.o(228756);
    }
}
