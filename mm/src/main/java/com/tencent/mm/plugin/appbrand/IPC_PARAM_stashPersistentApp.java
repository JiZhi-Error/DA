package com.tencent.mm.plugin.appbrand;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B)\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "processName", "taskController", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getProcessName", "setProcessName", "getTaskController", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "setTaskController", "(Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;)V", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
public final class IPC_PARAM_stashPersistentApp implements Parcelable {
    public static final Parcelable.Creator<IPC_PARAM_stashPersistentApp> CREATOR = new b();
    public static final a kET = new a((byte) 0);
    String appId;
    AppBrandRemoteTaskController kES;
    String processName;

    public IPC_PARAM_stashPersistentApp(String str, String str2, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        this.appId = str;
        this.processName = str2;
        this.kES = appBrandRemoteTaskController;
    }

    private /* synthetic */ IPC_PARAM_stashPersistentApp() {
        this(null, null, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IPC_PARAM_stashPersistentApp(Parcel parcel) {
        this();
        p.h(parcel, "source");
        AppMethodBeat.i(50154);
        this.appId = parcel.readString();
        this.processName = parcel.readString();
        Bundle readBundle = parcel.readBundle(AppBrandRemoteTaskController.class.getClassLoader());
        if (readBundle != null) {
            MainProcessTask b2 = AppBrandMainProcessService.b(readBundle, true);
            this.kES = (AppBrandRemoteTaskController) (!(b2 instanceof AppBrandRemoteTaskController) ? null : b2);
            AppMethodBeat.o(50154);
            return;
        }
        AppMethodBeat.o(50154);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(50153);
        p.h(parcel, "dest");
        parcel.writeString(this.appId);
        parcel.writeString(this.processName);
        if (this.kES != null) {
            parcel.writeBundle(AppBrandMainProcessService.a((MainProcessTask) this.kES, true));
            AppMethodBeat.o(50153);
            return;
        }
        parcel.writeBundle(null);
        AppMethodBeat.o(50153);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp;", "plugin-appbrand-integration_release"})
    public static final class b implements Parcelable.Creator<IPC_PARAM_stashPersistentApp> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPC_PARAM_stashPersistentApp createFromParcel(Parcel parcel) {
            AppMethodBeat.i(50152);
            p.h(parcel, "source");
            IPC_PARAM_stashPersistentApp iPC_PARAM_stashPersistentApp = new IPC_PARAM_stashPersistentApp(parcel);
            AppMethodBeat.o(50152);
            return iPC_PARAM_stashPersistentApp;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPC_PARAM_stashPersistentApp[] newArray(int i2) {
            return new IPC_PARAM_stashPersistentApp[i2];
        }
    }

    static {
        AppMethodBeat.i(50155);
        AppMethodBeat.o(50155);
    }
}
