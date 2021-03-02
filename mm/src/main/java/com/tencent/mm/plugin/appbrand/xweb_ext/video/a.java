package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public class a implements com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a {
    private static a oHx;
    private Set<String> oHy = new HashSet();

    private a() {
        AppMethodBeat.i(50025);
        AppMethodBeat.o(50025);
    }

    public static a cdL() {
        AppMethodBeat.i(50026);
        if (oHx == null) {
            synchronized (a.class) {
                try {
                    if (oHx == null) {
                        a aVar = new a();
                        oHx = aVar;
                        return aVar;
                    }
                } finally {
                    AppMethodBeat.o(50026);
                }
            }
        }
        a aVar2 = oHx;
        AppMethodBeat.o(50026);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a
    public final void xw(int i2) {
        AppMethodBeat.i(50027);
        Log.i("MicroMsg.SameLayer.VideoReporter", "startProxyResult, reason:%s", Integer.valueOf(i2));
        if (i2 >= 0) {
            h.INSTANCE.idkeyStat(1234, 16, 1, false);
            AppMethodBeat.o(50027);
        } else if (i2 == -1) {
            h.INSTANCE.idkeyStat(1234, 17, 1, false);
            AppMethodBeat.o(50027);
        } else {
            if (i2 == -2) {
                h.INSTANCE.idkeyStat(1234, 18, 1, false);
            }
            AppMethodBeat.o(50027);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a
    public final void dP(String str, String str2) {
        AppMethodBeat.i(50028);
        Log.i("MicroMsg.SameLayer.VideoReporter", "reportPreloadStart, uuid:%s, url:%s", str, str2);
        h.INSTANCE.idkeyStat(1234, 26, 1, false);
        AppMethodBeat.o(50028);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a
    public final void D(String str, String str2, int i2) {
        AppMethodBeat.i(50029);
        Log.i("MicroMsg.SameLayer.VideoReporter", "reportPreloadError, uuid:%s, url:%s, code:%s", str, str2, Integer.valueOf(i2));
        this.oHy.add(str);
        if (i2 == -101) {
            h.INSTANCE.idkeyStat(1234, 27, 1, false);
            AppMethodBeat.o(50029);
        } else if (i2 == -102) {
            h.INSTANCE.idkeyStat(1234, 28, 1, false);
            AppMethodBeat.o(50029);
        } else if (i2 == -103) {
            h.INSTANCE.idkeyStat(1234, 29, 1, false);
            AppMethodBeat.o(50029);
        } else if (i2 == -104) {
            h.INSTANCE.idkeyStat(1234, 30, 1, false);
            AppMethodBeat.o(50029);
        } else {
            if (i2 == -105) {
                h.INSTANCE.idkeyStat(1234, 31, 1, false);
            }
            AppMethodBeat.o(50029);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a
    public final void dQ(String str, String str2) {
        AppMethodBeat.i(50030);
        Log.i("MicroMsg.SameLayer.VideoReporter", "reportPreloadEnd, uuid:%s, url:%s", str, str2);
        if (!this.oHy.contains(str)) {
            h.INSTANCE.idkeyStat(1234, 32, 1, false);
            AppMethodBeat.o(50030);
            return;
        }
        this.oHy.remove(str);
        AppMethodBeat.o(50030);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a
    public final void bJZ() {
        AppMethodBeat.i(50031);
        h.INSTANCE.idkeyStat(1234, 36, 1, false);
        AppMethodBeat.o(50031);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a
    public final void Bi(long j2) {
        AppMethodBeat.i(50032);
        h.INSTANCE.idkeyStat(1234, 37, j2, false);
        AppMethodBeat.o(50032);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a
    public final void a(String str, String str2, int i2, long j2, long j3, long j4, int i3, String str3, long j5, long j6, long j7, long j8, String str4, int i4) {
        AppMethodBeat.i(50033);
        Log.i("MicroMsg.SameLayer.VideoReporter", "downloadResult, videoUuid:%s, sourceUrl:%s, priority:%s, rangeStart:%s, rangeEnd:%s, totalLength:%s, contentType:%s, requestMethod:%s, speed:%s, retCode:%s, subRetCode:%s, responseCode:%s, costTime:%s, message:%s", str, str2, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i3), str3, Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Integer.valueOf(i4), str4);
        h.INSTANCE.a(18693, str, str2, Integer.valueOf(i2), Long.valueOf(j8), Integer.valueOf(i4), Long.valueOf(j6), Long.valueOf(j7), str4, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i3), str3, Long.valueOf(j5));
        AppMethodBeat.o(50033);
    }
}
