package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "extInfoWrapper", "", "(Ljava/lang/String;)V", "getExtInfoWrapper", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class EnterFinderRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
    public static final a CREATOR = new a((byte) 0);
    final String lRv;

    static {
        AppMethodBeat.i(228375);
        AppMethodBeat.o(228375);
    }

    public EnterFinderRequest(String str) {
        p.h(str, "extInfoWrapper");
        AppMethodBeat.i(228373);
        this.lRv = str;
        AppMethodBeat.o(228373);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EnterFinderRequest(android.os.Parcel r3) {
        /*
            r2 = this;
            r1 = 228374(0x37c16, float:3.2002E-40)
            java.lang.String r0 = "parcel"
            kotlin.g.b.p.h(r3, r0)
            java.lang.String r0 = r3.readString()
            if (r0 != 0) goto L_0x0012
            java.lang.String r0 = ""
        L_0x0012:
            r2.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.channels.EnterFinderRequest.<init>(android.os.Parcel):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final Class<a> bCJ() {
        return a.class;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(228372);
        p.h(parcel, "parcel");
        parcel.writeString(this.lRv);
        AppMethodBeat.o(228372);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "plugin-appbrand-integration_release"})
    public static final class a implements Parcelable.Creator<EnterFinderRequest> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ EnterFinderRequest createFromParcel(Parcel parcel) {
            AppMethodBeat.i(228371);
            p.h(parcel, "parcel");
            EnterFinderRequest enterFinderRequest = new EnterFinderRequest(parcel);
            AppMethodBeat.o(228371);
            return enterFinderRequest;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ EnterFinderRequest[] newArray(int i2) {
            return new EnterFinderRequest[i2];
        }
    }
}
