package com.tencent.mm.plugin.appbrand.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class AdReportCgiHelper {

    public interface a {
        void onDone();
    }

    public static void a(int i2, String str, final a aVar) {
        AppMethodBeat.i(48080);
        if (MMApplicationContext.isMMProcess()) {
            au(i2, str);
            if (aVar != null) {
                aVar.onDone();
                AppMethodBeat.o(48080);
                return;
            }
        } else {
            AdReportCgiParams adReportCgiParams = new AdReportCgiParams();
            adReportCgiParams.hhs = i2;
            adReportCgiParams.nIh = str;
            XIPCInvoker.a(MainProcessIPCService.dkO, adReportCgiParams, b.class, new d<IPCVoid>() {
                /* class com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(IPCVoid iPCVoid) {
                    AppMethodBeat.i(48074);
                    if (aVar != null) {
                        aVar.onDone();
                    }
                    AppMethodBeat.o(48074);
                }
            });
        }
        AppMethodBeat.o(48080);
    }

    static void au(int i2, String str) {
        AppMethodBeat.i(48081);
        if (g.af(com.tencent.mm.plugin.sns.b.a.class) != null) {
            ((com.tencent.mm.plugin.sns.b.a) g.af(com.tencent.mm.plugin.sns.b.a.class)).r(i2, str, (int) Util.nowSecond());
        }
        AppMethodBeat.o(48081);
    }

    static final class b implements com.tencent.mm.ipcinvoker.b<AdReportCgiParams, IPCVoid> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(AdReportCgiParams adReportCgiParams, d<IPCVoid> dVar) {
            AppMethodBeat.i(48079);
            AdReportCgiParams adReportCgiParams2 = adReportCgiParams;
            Log.i("MicroMsg.AdReportCgiHelper", "report kvId:%d str:%s", Integer.valueOf(adReportCgiParams2.hhs), adReportCgiParams2.nIh);
            AdReportCgiHelper.au(adReportCgiParams2.hhs, adReportCgiParams2.nIh);
            dVar.bn(new IPCVoid());
            AppMethodBeat.o(48079);
        }
    }

    static final class AdReportCgiParams implements Parcelable {
        public static final Parcelable.Creator<AdReportCgiParams> CREATOR = new Parcelable.Creator<AdReportCgiParams>() {
            /* class com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper.AdReportCgiParams.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AdReportCgiParams[] newArray(int i2) {
                return new AdReportCgiParams[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AdReportCgiParams createFromParcel(Parcel parcel) {
                AppMethodBeat.i(48075);
                AdReportCgiParams adReportCgiParams = new AdReportCgiParams(parcel);
                AppMethodBeat.o(48075);
                return adReportCgiParams;
            }
        };
        private int hhs;
        private String nIh;

        AdReportCgiParams() {
        }

        protected AdReportCgiParams(Parcel parcel) {
            AppMethodBeat.i(48076);
            this.hhs = parcel.readInt();
            this.nIh = parcel.readString();
            AppMethodBeat.o(48076);
        }

        static {
            AppMethodBeat.i(48078);
            AppMethodBeat.o(48078);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(48077);
            parcel.writeInt(this.hhs);
            parcel.writeString(this.nIh);
            AppMethodBeat.o(48077);
        }
    }
}
