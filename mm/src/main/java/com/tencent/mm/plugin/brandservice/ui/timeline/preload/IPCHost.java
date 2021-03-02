package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016JD\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\b2\u001a\u0010\u0016\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00180\u00172\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00110\u001aJ\b\u0010\u001b\u001a\u00020\u0013H\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000fH\u0016R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\t¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/IPCHost;", "Landroid/os/Parcelable;", "Lcom/tencent/mm/ipcinvoker/event/IPCData;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "hosts", "", "", "([Ljava/lang/String;)V", "getHosts", "()[Ljava/lang/String;", "setHosts", "[Ljava/lang/String;", "describeContents", "", "fromBundle", "", "bundle", "Landroid/os/Bundle;", "invoke", "processName", "process", "Ljava/lang/Class;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "callback", "Lkotlin/Function1;", "toBundle", "writeToParcel", "flags", "CREATOR", "plugin-brandservice_release"})
public final class IPCHost implements Parcelable, com.tencent.mm.ipcinvoker.d.a {
    public static final a CREATOR = new a((byte) 0);
    private String[] pBd;

    static {
        AppMethodBeat.i(6589);
        AppMethodBeat.o(6589);
    }

    private IPCHost(String[] strArr) {
        p.h(strArr, "hosts");
        AppMethodBeat.i(6587);
        this.pBd = strArr;
        AppMethodBeat.o(6587);
    }

    @Override // com.tencent.mm.ipcinvoker.d.a
    public final Bundle toBundle() {
        AppMethodBeat.i(6584);
        Bundle bundle = new Bundle();
        bundle.putStringArray("hosts", this.pBd);
        AppMethodBeat.o(6584);
        return bundle;
    }

    @Override // com.tencent.mm.ipcinvoker.d.a
    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.i(6585);
        if (bundle != null) {
            String[] stringArray = bundle.getStringArray("hosts");
            if (stringArray == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                AppMethodBeat.o(6585);
                throw tVar;
            }
            this.pBd = stringArray;
            AppMethodBeat.o(6585);
            return;
        }
        AppMethodBeat.o(6585);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IPCHost(android.os.Parcel r4) {
        /*
            r3 = this;
            r2 = 6588(0x19bc, float:9.232E-42)
            java.lang.String r0 = "parcel"
            kotlin.g.b.p.h(r4, r0)
            java.lang.String[] r0 = r4.createStringArray()
            if (r0 != 0) goto L_0x001a
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<kotlin.String>"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x001a:
            r3.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.IPCHost.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(6586);
        p.h(parcel, "parcel");
        parcel.writeStringArray(this.pBd);
        AppMethodBeat.o(6586);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/IPCHost$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/IPCHost;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/IPCHost;", "plugin-brandservice_release"})
    public static final class a implements Parcelable.Creator<IPCHost> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCHost createFromParcel(Parcel parcel) {
            AppMethodBeat.i(6582);
            p.h(parcel, "parcel");
            IPCHost iPCHost = new IPCHost(parcel);
            AppMethodBeat.o(6582);
            return iPCHost;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCHost[] newArray(int i2) {
            return new IPCHost[i2];
        }
    }
}
