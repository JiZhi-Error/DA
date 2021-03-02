package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;

public final class r implements e {
    private String mxw = "";
    private final e myq;
    private final d myr;
    private boolean mys;
    private boolean myt;

    public r(e eVar, d dVar) {
        AppMethodBeat.i(234773);
        this.myq = (e) a.checkNotNull(eVar);
        this.myr = (d) a.checkNotNull(dVar);
        AppMethodBeat.o(234773);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c8  */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g r21) {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.b.b.r.a(com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g):long");
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(234775);
        int read = this.myq.read(bArr, i2, i3);
        if (read > 0) {
            if (this.mys) {
                AppMethodBeat.o(234775);
                return read;
            }
            try {
                if (this.myt) {
                    this.myr.write(bArr, i2, read);
                }
            } catch (b.a e2) {
                this.mys = true;
                h.a(5, getLogTag(), "error write dataSink " + e2.toString(), e2);
            }
        }
        AppMethodBeat.o(234775);
        return read;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long available() {
        AppMethodBeat.i(234776);
        long available = this.myq.available();
        AppMethodBeat.o(234776);
        return available;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void close() {
        AppMethodBeat.i(234777);
        try {
            this.myq.close();
            try {
            } catch (b.a e2) {
                h.a(5, getLogTag(), "error close dataSink " + e2.toString(), e2);
                AppMethodBeat.o(234777);
            }
        } finally {
            try {
                if (this.myt) {
                    this.myr.close();
                }
            } catch (b.a e3) {
                h.a(5, getLogTag(), "error close dataSink " + e3.toString(), e3);
            }
            AppMethodBeat.o(234777);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final c bJP() {
        AppMethodBeat.i(234778);
        c bJP = this.myq.bJP();
        AppMethodBeat.o(234778);
        return bJP;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long getTotalLength() {
        AppMethodBeat.i(234779);
        long totalLength = this.myq.getTotalLength();
        AppMethodBeat.o(234779);
        return totalLength;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void setLogTag(String str) {
        this.mxw = str;
    }

    private String getLogTag() {
        AppMethodBeat.i(234780);
        String str = this.mxw + "TeeDataSource";
        AppMethodBeat.o(234780);
        return str;
    }
}
