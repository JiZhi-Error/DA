package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "Landroid/os/Parcelable;", "appId", "", "point", "Landroid/graphics/Point;", "(Ljava/lang/String;Landroid/graphics/Point;)V", "getAppId", "()Ljava/lang/String;", "getPoint", "()Landroid/graphics/Point;", "component1", "component2", "copy", "describeContents", "", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class PipStablePos implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    final String appId;
    final Point nDV;

    static {
        AppMethodBeat.i(229274);
        AppMethodBeat.o(229274);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.nDV, r4.nDV) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 229277(0x37f9d, float:3.21286E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.pip.PipStablePos
            if (r0 == 0) goto L_0x0027
            com.tencent.mm.plugin.appbrand.pip.PipStablePos r4 = (com.tencent.mm.plugin.appbrand.pip.PipStablePos) r4
            java.lang.String r0 = r3.appId
            java.lang.String r1 = r4.appId
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            android.graphics.Point r0 = r3.nDV
            android.graphics.Point r1 = r4.nDV
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.pip.PipStablePos.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(229276);
        String str = this.appId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Point point = this.nDV;
        if (point != null) {
            i2 = point.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(229276);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(229275);
        String str = "PipStablePos(appId=" + this.appId + ", point=" + this.nDV + ")";
        AppMethodBeat.o(229275);
        return str;
    }

    public PipStablePos(String str, Point point) {
        p.h(str, "appId");
        p.h(point, "point");
        AppMethodBeat.i(229273);
        this.appId = str;
        this.nDV = point;
        AppMethodBeat.o(229273);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(229272);
        p.h(parcel, "parcel");
        try {
            parcel.writeString(this.appId);
            parcel.writeParcelable(this.nDV, i2);
            AppMethodBeat.o(229272);
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "writeToParcel fail since ".concat(String.valueOf(e2)));
            AppMethodBeat.o(229272);
        }
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "plugin-appbrand-integration_release"})
    public static final class a implements Parcelable.Creator<PipStablePos> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PipStablePos createFromParcel(Parcel parcel) {
            AppMethodBeat.i(229271);
            PipStablePos m = m(parcel);
            AppMethodBeat.o(229271);
            return m;
        }

        private static PipStablePos m(Parcel parcel) {
            PipStablePos pipStablePos;
            AppMethodBeat.i(229270);
            p.h(parcel, "parcel");
            try {
                String readString = parcel.readString();
                Point point = (Point) parcel.readParcelable(Point.class.getClassLoader());
                if (readString == null || point == null) {
                    Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "createFromParcel fail, appId: " + readString + ", point: " + point);
                    pipStablePos = m.nDU;
                } else {
                    pipStablePos = new PipStablePos(readString, point);
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "createFromParcel fail since ".concat(String.valueOf(e2)));
                pipStablePos = m.nDU;
            }
            AppMethodBeat.o(229270);
            return pipStablePos;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PipStablePos[] newArray(int i2) {
            return new PipStablePos[i2];
        }
    }
}
