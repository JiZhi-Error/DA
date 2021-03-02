package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;", "Landroid/os/Parcelable;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "loaderId", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;I)V", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getLoaderId", "()I", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class BindRemoteServiceData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    final AppBrandInitConfigWC kEG;
    final AppBrandStatObject kEH;
    final int kEI;

    @l(hxD = {1, 1, 16})
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(227896);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            BindRemoteServiceData bindRemoteServiceData = new BindRemoteServiceData((AppBrandInitConfigWC) parcel.readParcelable(BindRemoteServiceData.class.getClassLoader()), AppBrandStatObject.CREATOR.createFromParcel(parcel), parcel.readInt());
            AppMethodBeat.o(227896);
            return bindRemoteServiceData;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new BindRemoteServiceData[i2];
        }
    }

    static {
        AppMethodBeat.i(227902);
        AppMethodBeat.o(227902);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r3.kEI == r4.kEI) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 227900(0x37a3c, float:3.19356E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0028
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.BindRemoteServiceData
            if (r0 == 0) goto L_0x002d
            com.tencent.mm.plugin.appbrand.BindRemoteServiceData r4 = (com.tencent.mm.plugin.appbrand.BindRemoteServiceData) r4
            com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC r0 = r3.kEG
            com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC r1 = r4.kEG
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
            com.tencent.mm.plugin.appbrand.report.AppBrandStatObject r0 = r3.kEH
            com.tencent.mm.plugin.appbrand.report.AppBrandStatObject r1 = r4.kEH
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
            int r0 = r3.kEI
            int r1 = r4.kEI
            if (r0 != r1) goto L_0x002d
        L_0x0028:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x002c:
            return r0
        L_0x002d:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.BindRemoteServiceData.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(227899);
        AppBrandInitConfigWC appBrandInitConfigWC = this.kEG;
        int hashCode = (appBrandInitConfigWC != null ? appBrandInitConfigWC.hashCode() : 0) * 31;
        AppBrandStatObject appBrandStatObject = this.kEH;
        if (appBrandStatObject != null) {
            i2 = appBrandStatObject.hashCode();
        }
        int i3 = ((hashCode + i2) * 31) + this.kEI;
        AppMethodBeat.o(227899);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(227898);
        String str = "BindRemoteServiceData(initConfig=" + this.kEG + ", stat=" + this.kEH + ", loaderId=" + this.kEI + ")";
        AppMethodBeat.o(227898);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(227901);
        p.h(parcel, "parcel");
        parcel.writeParcelable(this.kEG, i2);
        this.kEH.writeToParcel(parcel, 0);
        parcel.writeInt(this.kEI);
        AppMethodBeat.o(227901);
    }

    public BindRemoteServiceData(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject, int i2) {
        p.h(appBrandInitConfigWC, "initConfig");
        p.h(appBrandStatObject, "stat");
        AppMethodBeat.i(227897);
        this.kEG = appBrandInitConfigWC;
        this.kEH = appBrandStatObject;
        this.kEI = i2;
        AppMethodBeat.o(227897);
    }
}
