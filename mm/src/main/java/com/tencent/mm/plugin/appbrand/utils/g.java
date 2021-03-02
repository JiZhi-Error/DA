package com.tencent.mm.plugin.appbrand.utils;

import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class g implements c {
    /* synthetic */ g(byte b2) {
        this();
    }

    private g() {
    }

    /* access modifiers changed from: package-private */
    public static class a {
        static g ogI = new g((byte) 0);

        static {
            AppMethodBeat.i(227736);
            AppMethodBeat.o(227736);
        }
    }

    static final class b implements k<IPCVoid, IPCString> {
        private b() {
        }

        private static boolean bZp() {
            Exception e2;
            boolean z;
            AppMethodBeat.i(227737);
            try {
                TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int callState = telephonyManager.getCallState();
                    switch (callState) {
                        case 0:
                            z = false;
                            break;
                        case 1:
                        case 2:
                            z = true;
                            break;
                        default:
                            z = false;
                            break;
                    }
                    try {
                        Log.i("MicroMsg.AppBrandVOIPStrategy", "isPhoneInUse, isPhoneInUse:%s, callState:%s", Boolean.valueOf(z), Integer.valueOf(callState));
                    } catch (Exception e3) {
                        e2 = e3;
                        Log.printErrStackTrace("MicroMsg.AppBrandVOIPStrategy", e2, "isPhoneInUse, exception:%s", e2);
                        AppMethodBeat.o(227737);
                        return z;
                    }
                } else {
                    z = false;
                }
            } catch (Exception e4) {
                e2 = e4;
                z = false;
                Log.printErrStackTrace("MicroMsg.AppBrandVOIPStrategy", e2, "isPhoneInUse, exception:%s", e2);
                AppMethodBeat.o(227737);
                return z;
            }
            AppMethodBeat.o(227737);
            return z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00b6  */
        @Override // com.tencent.mm.ipcinvoker.k
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ com.tencent.mm.ipcinvoker.type.IPCString invoke(com.tencent.mm.ipcinvoker.type.IPCVoid r7) {
            /*
            // Method dump skipped, instructions count: 195
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.utils.g.b.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public static void S(q qVar) {
        AppMethodBeat.i(227739);
        qVar.a(a.ogI);
        AppMethodBeat.o(227739);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c
    public final String bMg() {
        AppMethodBeat.i(227740);
        IPCString iPCString = (IPCString) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, b.class);
        if (iPCString != null) {
            String str = iPCString.value;
            AppMethodBeat.o(227740);
            return str;
        }
        AppMethodBeat.o(227740);
        return null;
    }
}
