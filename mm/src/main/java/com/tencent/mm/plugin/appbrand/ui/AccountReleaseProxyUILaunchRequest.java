package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0014¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "CREATOR", "plugin-appbrand-integration_release"})
public final class AccountReleaseProxyUILaunchRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
    public static final a CREATOR = new a((byte) 0);

    static {
        AppMethodBeat.i(51102);
        AppMethodBeat.o(51102);
    }

    public AccountReleaseProxyUILaunchRequest() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AccountReleaseProxyUILaunchRequest(Parcel parcel) {
        this();
        p.h(parcel, "parcel");
        AppMethodBeat.i(51101);
        AppMethodBeat.o(51101);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
        return a.class;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest;", "plugin-appbrand-integration_release"})
    public static final class a implements Parcelable.Creator<AccountReleaseProxyUILaunchRequest> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AccountReleaseProxyUILaunchRequest createFromParcel(Parcel parcel) {
            AppMethodBeat.i(51100);
            p.h(parcel, "parcel");
            AccountReleaseProxyUILaunchRequest accountReleaseProxyUILaunchRequest = new AccountReleaseProxyUILaunchRequest(parcel);
            AppMethodBeat.o(51100);
            return accountReleaseProxyUILaunchRequest;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AccountReleaseProxyUILaunchRequest[] newArray(int i2) {
            return new AccountReleaseProxyUILaunchRequest[i2];
        }
    }
}
