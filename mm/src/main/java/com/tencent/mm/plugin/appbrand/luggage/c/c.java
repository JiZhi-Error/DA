package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;

public final class c implements o {
    @Override // com.tencent.mm.plugin.appbrand.s.o
    public final void Yl(String str) {
        AppMethodBeat.i(47583);
        AppBrandStatObject TS = a.TS(str);
        if (TS != null) {
            f.Yl(Util.nullAsNil(TS.dCw));
        }
        AppMethodBeat.o(47583);
    }

    @Override // com.tencent.mm.plugin.appbrand.s.o
    public final void a(String str, String str2, String str3, String str4, long j2, long j3, int i2, int i3, int i4, String str5, String str6) {
        AppMethodBeat.i(47582);
        AppBrandSysConfigWC TR = a.TR(str);
        if (TR != null) {
            try {
                str4 = q.encode(str4, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e2) {
                Log.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report UnsupportedEncodingException");
            }
            int i5 = TR.leE.pkgVersion;
            int i6 = TR.leE.kNW + 1;
            String networkType = i.getNetworkType(MMApplicationContext.getContext());
            int aeH = i.aeH(str);
            com.tencent.mm.plugin.appbrand.report.a.nFX.a(14510, str, Integer.valueOf(i5), Integer.valueOf(i6), networkType, str2, str4, str3, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str5, str6, Integer.valueOf(aeH));
            if (Log.getLogLevel() <= 1) {
                StringBuilder sb = new StringBuilder("report kv_14510{");
                sb.append("appId='").append(str).append('\'').append(", appVersion=").append(i5).append(", appState=").append(i6).append(", appType=").append(aeH).append(", networkType='").append(networkType).append('\'').append(", functionName='").append(str2).append('\'').append(", url='").append(str4).append('\'').append(", method='").append(str3).append('\'').append(", sentsize=").append(j2).append(", receivedsize=").append(j3).append(", statusCode=").append(i2).append(", result=").append(i3).append(", costtime=").append(i4).append(", dstPath=").append(str5).append(", contentType=").append(str6).append('}');
                Log.d("MicroMsg.AppBrand.Report.kv_14510", sb.toString());
            }
            AppMethodBeat.o(47582);
            return;
        }
        Log.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", str);
        AppMethodBeat.o(47582);
    }
}
