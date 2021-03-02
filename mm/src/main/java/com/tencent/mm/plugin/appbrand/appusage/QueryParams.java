package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "count", "", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "versionType", "(ILcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;I)V", "getCount", "()I", "getOrder", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "getVersionType", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class QueryParams implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    final int count;
    final int iOo;
    final ag.a kWk;

    static {
        AppMethodBeat.i(50303);
        AppMethodBeat.o(50303);
    }

    public QueryParams(int i2, ag.a aVar, int i3) {
        this.count = i2;
        this.kWk = aVar;
        this.iOo = i3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public QueryParams(android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.g.b.p.h(r4, r0)
            int r1 = r4.readInt()
            int r0 = r4.readInt()
            com.tencent.mm.plugin.appbrand.appusage.ag$a r2 = com.tencent.mm.plugin.appbrand.appusage.ag.a.ASC
            int r2 = r2.ordinal()
            if (r0 != r2) goto L_0x0026
            com.tencent.mm.plugin.appbrand.appusage.ag$a r0 = com.tencent.mm.plugin.appbrand.appusage.ag.a.ASC
        L_0x0018:
            int r2 = r4.readInt()
            r3.<init>(r1, r0, r2)
            r0 = 50302(0xc47e, float:7.0488E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)
            return
        L_0x0026:
            com.tencent.mm.plugin.appbrand.appusage.ag$a r2 = com.tencent.mm.plugin.appbrand.appusage.ag.a.DESC
            int r2 = r2.ordinal()
            if (r0 != r2) goto L_0x0031
            com.tencent.mm.plugin.appbrand.appusage.ag$a r0 = com.tencent.mm.plugin.appbrand.appusage.ag.a.DESC
            goto L_0x0018
        L_0x0031:
            r0 = 0
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appusage.QueryParams.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(50301);
        if (parcel != null) {
            parcel.writeInt(this.count);
        }
        if (parcel != null) {
            ag.a aVar = this.kWk;
            parcel.writeInt(aVar != null ? aVar.ordinal() : -1);
        }
        if (parcel != null) {
            parcel.writeInt(this.iOo);
            AppMethodBeat.o(50301);
            return;
        }
        AppMethodBeat.o(50301);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "plugin-appbrand-integration_release"})
    public static final class a implements Parcelable.Creator<QueryParams> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ QueryParams createFromParcel(Parcel parcel) {
            AppMethodBeat.i(50300);
            p.h(parcel, "parcel");
            QueryParams queryParams = new QueryParams(parcel);
            AppMethodBeat.o(50300);
            return queryParams;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ QueryParams[] newArray(int i2) {
            return new QueryParams[i2];
        }
    }
}
