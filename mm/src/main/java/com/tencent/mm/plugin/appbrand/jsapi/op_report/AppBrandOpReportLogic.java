package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Util;

public final class AppBrandOpReportLogic {

    public static final class AppBrandOnOpReportStartEvent implements Parcelable {
        public static final Parcelable.Creator<AppBrandOnOpReportStartEvent> CREATOR = new Parcelable.Creator<AppBrandOnOpReportStartEvent>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AppBrandOnOpReportStartEvent[] newArray(int i2) {
                return new AppBrandOnOpReportStartEvent[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AppBrandOnOpReportStartEvent createFromParcel(Parcel parcel) {
                AppMethodBeat.i(147198);
                AppBrandOnOpReportStartEvent appBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent(parcel);
                AppMethodBeat.o(147198);
                return appBrandOnOpReportStartEvent;
            }
        };
        String appId;

        public static void aaA(String str) {
            AppMethodBeat.i(147199);
            AppBrandOnOpReportStartEvent appBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent();
            appBrandOnOpReportStartEvent.appId = str;
            e.b(str, appBrandOnOpReportStartEvent);
            AppMethodBeat.o(147199);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(147200);
            parcel.writeString(this.appId);
            AppMethodBeat.o(147200);
        }

        AppBrandOnOpReportStartEvent() {
        }

        AppBrandOnOpReportStartEvent(Parcel parcel) {
            AppMethodBeat.i(147201);
            this.appId = parcel.readString();
            AppMethodBeat.o(147201);
        }

        static {
            AppMethodBeat.i(147202);
            AppMethodBeat.o(147202);
        }
    }

    public static final class b {
        private static final SparseIntArray mjG = new SparseIntArray();

        static {
            AppMethodBeat.i(147206);
            AppMethodBeat.o(147206);
        }

        static void bM(String str, int i2) {
            AppMethodBeat.i(147205);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(147205);
                return;
            }
            synchronized (mjG) {
                try {
                    mjG.put(str.hashCode(), i2);
                } finally {
                    AppMethodBeat.o(147205);
                }
            }
        }
    }

    public static final class a {
        private static boolean mjF = false;

        public static synchronized void d(final k kVar) {
            synchronized (a.class) {
                AppMethodBeat.i(147204);
                if (mjF) {
                    AppMethodBeat.o(147204);
                } else {
                    MMToClientEvent.a(kVar.getAppId(), new MMToClientEvent.c() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c
                        public final void cq(Object obj) {
                            AppBrandRuntime runtime;
                            AppMethodBeat.i(147203);
                            if ((obj instanceof AppBrandOnOpReportStartEvent) && (runtime = kVar.getRuntime()) != null) {
                                a.m(runtime.NY());
                            }
                            AppMethodBeat.o(147203);
                        }
                    });
                    mjF = true;
                    AppMethodBeat.o(147204);
                }
            }
        }
    }
}
