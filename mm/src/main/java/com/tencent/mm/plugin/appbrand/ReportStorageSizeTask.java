package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.f.h;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;

public class ReportStorageSizeTask extends MainProcessTask {
    public static final Parcelable.Creator<ReportStorageSizeTask> CREATOR = new Parcelable.Creator<ReportStorageSizeTask>() {
        /* class com.tencent.mm.plugin.appbrand.ReportStorageSizeTask.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ReportStorageSizeTask[] newArray(int i2) {
            return new ReportStorageSizeTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ReportStorageSizeTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(226249);
            ReportStorageSizeTask reportStorageSizeTask = new ReportStorageSizeTask();
            reportStorageSizeTask.f(parcel);
            AppMethodBeat.o(226249);
            return reportStorageSizeTask;
        }
    };
    public String appId;

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(43981);
        h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.appbrand.ReportStorageSizeTask.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(226247);
                try {
                    ReportStorageSizeTask.a(ReportStorageSizeTask.this);
                    AppMethodBeat.o(226247);
                } catch (Throwable th) {
                    Log.e("MicroMsg.AppBrand.ReportStorageSizeTask", "doReport appId:%s, e:%s", ReportStorageSizeTask.this.appId, th);
                    AppMethodBeat.o(226247);
                }
            }

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                AppMethodBeat.i(226248);
                String str = "MicroMsg.AppBrand.ReportStorageSizeTask#" + ReportStorageSizeTask.this.appId;
                AppMethodBeat.o(226248);
                return str;
            }
        });
        AppMethodBeat.o(43981);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(43982);
        parcel.writeString(this.appId);
        AppMethodBeat.o(43982);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(43983);
        this.appId = parcel.readString();
        AppMethodBeat.o(43983);
    }

    static {
        AppMethodBeat.i(43984);
        AppMethodBeat.o(43984);
    }

    static /* synthetic */ void a(ReportStorageSizeTask reportStorageSizeTask) {
        Integer valueOf;
        AppMethodBeat.i(226250);
        d NK = n.NK();
        if (NK == null) {
            AppMethodBeat.o(226250);
            return;
        }
        e.a aVar = e.AkJ;
        if (e.a.bxm(reportStorageSizeTask.appId) != 1) {
            valueOf = Integer.valueOf(((a) com.tencent.luggage.a.e.M(a.class)).dD(reportStorageSizeTask.appId).VL(reportStorageSizeTask.appId));
        } else {
            valueOf = Integer.valueOf(NK.VL(reportStorageSizeTask.appId));
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14073, reportStorageSizeTask.appId, "", "", valueOf, Long.valueOf(AppBrandLocalMediaObjectManager.bxn(reportStorageSizeTask.appId)), Long.valueOf(AppBrandLocalMediaObjectManager.bxo(reportStorageSizeTask.appId)));
        AppMethodBeat.o(226250);
    }
}
