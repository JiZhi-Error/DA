package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Modifier;
import java.util.Locale;
import junit.framework.Assert;

public final class IPCRunCgi {
    private static final b hnF = new b() {
        /* class com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.AnonymousClass1 */

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b
        public final d a(d dVar) {
            return dVar;
        }
    };

    public interface a {
        void a(int i2, int i3, String str, d dVar);
    }

    public interface b {
        d a(d dVar);
    }

    static {
        AppMethodBeat.i(225230);
        AppMethodBeat.o(225230);
    }

    public static q a(d dVar, a aVar) {
        AppMethodBeat.i(174551);
        q a2 = a(dVar, null, aVar);
        AppMethodBeat.o(174551);
        return a2;
    }

    public static q a(d dVar, b bVar, final a aVar) {
        AppMethodBeat.i(225228);
        if (MMApplicationContext.isMMProcess()) {
            if (bVar == null) {
                bVar = hnF;
            }
            q a2 = aa.a(bVar.a(dVar), new aa.a() {
                /* class com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.AnonymousClass2 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(225221);
                    if (aVar != null) {
                        aVar.a(i2, i3, str, dVar);
                    }
                    AppMethodBeat.o(225221);
                    return 0;
                }
            }, true);
            AppMethodBeat.o(225228);
            return a2;
        }
        b(dVar, bVar, aVar);
        AppMethodBeat.o(225228);
        return null;
    }

    private static void b(d dVar, b bVar, final a aVar) {
        String str = null;
        AppMethodBeat.i(225229);
        if (bVar != null && !Modifier.isStatic(bVar.getClass().getModifiers())) {
            String format = String.format(Locale.ENGLISH, "remoteCgiImpl in client process, invalid interceptor %s", bVar.getClass().getName());
            if (BuildInfo.IS_FLAVOR_RED) {
                Assert.fail(format);
            }
            Log.printErrStackTrace("MicroMsg.IPCRunCgi", new Throwable(), format, new Object[0]);
            bVar = null;
        }
        IPCRunCgiParamsWrapper iPCRunCgiParamsWrapper = new IPCRunCgiParamsWrapper();
        if (bVar != null) {
            str = bVar.getClass().getName();
        }
        iPCRunCgiParamsWrapper.hnH = str;
        iPCRunCgiParamsWrapper.rr = dVar;
        XIPCInvoker.a(MainProcessIPCService.dkO, iPCRunCgiParamsWrapper, c.class, new com.tencent.mm.ipcinvoker.d<IPCRunCgiRespWrapper>() {
            /* class com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCRunCgiRespWrapper iPCRunCgiRespWrapper) {
                AppMethodBeat.i(225222);
                IPCRunCgiRespWrapper iPCRunCgiRespWrapper2 = iPCRunCgiRespWrapper;
                try {
                    if (!(aVar == null || iPCRunCgiRespWrapper2 == null)) {
                        aVar.a(iPCRunCgiRespWrapper2.errType, iPCRunCgiRespWrapper2.errCode, iPCRunCgiRespWrapper2.errMsg, iPCRunCgiRespWrapper2.rr);
                    }
                    AppMethodBeat.o(225222);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.IPCRunCgi", e2, "remoteCgiImpl do callback", new Object[0]);
                    AppMethodBeat.o(225222);
                }
            }
        });
        AppMethodBeat.o(225229);
    }

    /* access modifiers changed from: package-private */
    public static final class c implements com.tencent.mm.ipcinvoker.b<IPCRunCgiParamsWrapper, IPCRunCgiRespWrapper> {
        private c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCRunCgiParamsWrapper iPCRunCgiParamsWrapper, final com.tencent.mm.ipcinvoker.d<IPCRunCgiRespWrapper> dVar) {
            AppMethodBeat.i(146408);
            IPCRunCgiParamsWrapper iPCRunCgiParamsWrapper2 = iPCRunCgiParamsWrapper;
            d dVar2 = iPCRunCgiParamsWrapper2.rr;
            if (dVar2 != null) {
                dVar2 = iPCRunCgiParamsWrapper2.ayn().a(dVar2);
            }
            if (dVar2 == null || dVar2.iLL.iLR.getClass() == com.tencent.mm.bw.a.class) {
                Log.e("MicroMsg.IPCRunCgi", "InvokeTask, mm received invalid rr %s", dVar2);
                if (dVar != null) {
                    dVar.bn(IPCRunCgiRespWrapper.b(dVar2));
                }
                AppMethodBeat.o(146408);
                return;
            }
            aa.a(dVar2, new aa.a() {
                /* class com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.c.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(146407);
                    if (dVar != null) {
                        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
                        iPCRunCgiRespWrapper.errType = i2;
                        iPCRunCgiRespWrapper.errCode = i3;
                        iPCRunCgiRespWrapper.errMsg = str;
                        iPCRunCgiRespWrapper.rr = dVar;
                        dVar.bn(iPCRunCgiRespWrapper);
                    }
                    AppMethodBeat.o(146407);
                    return 0;
                }
            }, true);
            AppMethodBeat.o(146408);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class IPCRunCgiParamsWrapper implements Parcelable {
        public static final Parcelable.Creator<IPCRunCgiParamsWrapper> CREATOR = new Parcelable.Creator<IPCRunCgiParamsWrapper>() {
            /* class com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.IPCRunCgiParamsWrapper.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCRunCgiParamsWrapper[] newArray(int i2) {
                return new IPCRunCgiParamsWrapper[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCRunCgiParamsWrapper createFromParcel(Parcel parcel) {
                AppMethodBeat.i(225223);
                IPCRunCgiParamsWrapper iPCRunCgiParamsWrapper = new IPCRunCgiParamsWrapper(parcel);
                AppMethodBeat.o(225223);
                return iPCRunCgiParamsWrapper;
            }
        };
        private String hnH;
        private d rr;

        public final b ayn() {
            AppMethodBeat.i(225224);
            if (this.hnH == null) {
                b bVar = IPCRunCgi.hnF;
                AppMethodBeat.o(225224);
                return bVar;
            }
            try {
                b bVar2 = (b) org.a.a.bF(org.a.a.forName(this.hnH)).hPX().object;
                AppMethodBeat.o(225224);
                return bVar2;
            } catch (org.a.b e2) {
                Log.e("MicroMsg.IPCRunCgi", "createInterceptor with name:%s, get exception:%s", this.hnH, e2);
                b bVar3 = IPCRunCgi.hnF;
                AppMethodBeat.o(225224);
                return bVar3;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(225225);
            parcel.writeString(this.hnH);
            com.tencent.mm.ipcinvoker.extension.c.a(this.rr, parcel);
            AppMethodBeat.o(225225);
        }

        public IPCRunCgiParamsWrapper() {
        }

        IPCRunCgiParamsWrapper(Parcel parcel) {
            AppMethodBeat.i(225226);
            this.hnH = parcel.readString();
            this.rr = (d) com.tencent.mm.ipcinvoker.extension.c.a(a.class.getName(), parcel);
            AppMethodBeat.o(225226);
        }

        static {
            AppMethodBeat.i(225227);
            AppMethodBeat.o(225227);
        }
    }
}
