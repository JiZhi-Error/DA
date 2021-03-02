package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b implements d {
    protected String TAG = "CacheDataSink";
    private final long bFU;
    protected long bFW;
    protected long bFX;
    protected o file;
    protected long kNt = -1;
    private final a mxs;
    protected g mxt;
    private OutputStream mxu;
    protected c mxv = c.myu;
    public String mxw = "";
    private BufferedOutputStream outputStream;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public b(a aVar, long j2) {
        this.mxs = aVar;
        this.bFU = j2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d
    public final d a(g gVar, long j2, c cVar) {
        AppMethodBeat.i(234661);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(gVar.length != -1);
        this.kNt = j2;
        this.mxv = cVar;
        try {
            this.mxt = gVar;
            this.bFX = 0;
            wO();
            AppMethodBeat.o(234661);
            return this;
        } catch (IOException e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(234661);
            throw aVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d
    public final void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(234662);
        int i4 = 0;
        while (i4 < i3) {
            try {
                if (this.bFW == this.bFU) {
                    wP();
                    wO();
                }
                int min = (int) Math.min((long) (i3 - i4), this.bFU - this.bFW);
                this.outputStream.write(bArr, i2 + i4, min);
                i4 += min;
                this.bFW += (long) min;
                this.bFX += (long) min;
            } catch (IOException e2) {
                a aVar = new a(e2);
                AppMethodBeat.o(234662);
                throw aVar;
            }
        }
        AppMethodBeat.o(234662);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d
    public final void close() {
        AppMethodBeat.i(234663);
        try {
            wP();
            h.log(4, getLogTag(), "close outputStream, " + String.format("total cached %d bytes", Long.valueOf(this.bFX)));
            AppMethodBeat.o(234663);
        } catch (IOException e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(234663);
            throw aVar;
        }
    }

    private void bJM() {
        AppMethodBeat.i(234664);
        this.file = this.mxs.a(this.mxt.key, this.mxt.bEP + this.bFX, this.kNt, this.mxv, Math.min(this.mxt.length - this.bFX, this.bFU));
        AppMethodBeat.o(234664);
    }

    private void bJN() {
        AppMethodBeat.i(234665);
        this.mxs.A(this.file);
        AppMethodBeat.o(234665);
    }

    private void wO() {
        AppMethodBeat.i(234666);
        bJM();
        h.log(4, getLogTag(), "start cache " + aa.z(this.file.her()));
        this.mxu = s.ap(this.file);
        this.outputStream = new BufferedOutputStream(this.mxu);
        this.bFW = 0;
        AppMethodBeat.o(234666);
    }

    /* JADX INFO: finally extract failed */
    private void wP() {
        AppMethodBeat.i(234667);
        if (this.outputStream == null) {
            h.log(4, getLogTag(), "finish cache, outputStream is null");
            AppMethodBeat.o(234667);
            return;
        }
        try {
            this.outputStream.flush();
            try {
                this.outputStream.close();
            } catch (IOException e2) {
            }
            bJN();
            h.log(4, getLogTag(), "finish cache " + aa.z(this.file.her()) + "  fileSize=" + this.file.length());
            this.mxu = null;
            this.outputStream = null;
            this.file = null;
            AppMethodBeat.o(234667);
        } catch (Throwable th) {
            try {
                this.outputStream.close();
            } catch (IOException e3) {
            }
            this.file.delete();
            h.log(6, getLogTag(), "close outputStream failed: " + aa.z(this.file.her()));
            this.mxu = null;
            this.outputStream = null;
            this.file = null;
            AppMethodBeat.o(234667);
            throw th;
        }
    }

    private String getLogTag() {
        AppMethodBeat.i(234668);
        String str = this.mxw + this.TAG;
        AppMethodBeat.o(234668);
        return str;
    }
}
