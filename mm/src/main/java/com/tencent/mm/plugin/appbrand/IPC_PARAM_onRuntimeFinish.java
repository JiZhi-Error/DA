package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_onRuntimeFinish;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class IPC_PARAM_onRuntimeFinish implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    final String appId;

    static {
        AppMethodBeat.i(227913);
        AppMethodBeat.o(227913);
    }

    public IPC_PARAM_onRuntimeFinish(String str) {
        p.h(str, "appId");
        AppMethodBeat.i(227911);
        this.appId = str;
        AppMethodBeat.o(227911);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IPC_PARAM_onRuntimeFinish(android.os.Parcel r3) {
        /*
            r2 = this;
            r1 = 227912(0x37a48, float:3.19373E-40)
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.IPC_PARAM_onRuntimeFinish.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(227910);
        p.h(parcel, "parcel");
        parcel.writeString(this.appId);
        AppMethodBeat.o(227910);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_onRuntimeFinish$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_onRuntimeFinish;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_onRuntimeFinish;", "plugin-appbrand-integration_release"})
    public static final class a implements Parcelable.Creator<IPC_PARAM_onRuntimeFinish> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPC_PARAM_onRuntimeFinish createFromParcel(Parcel parcel) {
            AppMethodBeat.i(227909);
            p.h(parcel, "parcel");
            IPC_PARAM_onRuntimeFinish iPC_PARAM_onRuntimeFinish = new IPC_PARAM_onRuntimeFinish(parcel);
            AppMethodBeat.o(227909);
            return iPC_PARAM_onRuntimeFinish;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPC_PARAM_onRuntimeFinish[] newArray(int i2) {
            return new IPC_PARAM_onRuntimeFinish[i2];
        }
    }
}
