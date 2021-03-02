package com.tencent.mm.audio.mix.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.c;

public final class b implements g {
    private boolean dvV = false;
    private e dvW;
    private com.tencent.mm.ai.b dvk;
    private volatile boolean stop = true;

    public b(e eVar) {
        this.dvW = eVar;
    }

    @Override // com.tencent.mm.audio.mix.e.g
    public final void a(c cVar) {
        long j2;
        AppMethodBeat.i(198116);
        this.stop = false;
        if (cVar == null) {
            if (this.dvW != null) {
                this.dvW.d(null);
            }
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDownloadProcess", "process source is null");
            this.stop = true;
            AppMethodBeat.o(198116);
            return;
        }
        this.dvV = false;
        com.tencent.mm.ai.b ZU = cVar.ZU();
        if (ZU != null) {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "audio:%s, url:%s", ZU.dtX, ZU.dvn);
        }
        this.dvk = ZU;
        cVar.connect();
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "source connect, stop:%b", Boolean.valueOf(this.stop));
        String str = "";
        long j3 = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= 3 || this.stop) {
                break;
            }
            i2++;
            if (j3 <= 0) {
                j2 = cVar.getSize();
            } else {
                j2 = j3;
            }
            if (TextUtils.isEmpty(str)) {
                str = cVar.ZV();
            }
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "fileSize:%d, mimetype:%s, tryCount:%d", Long.valueOf(j2), str, Integer.valueOf(i2));
            if (j2 <= 0 || TextUtils.isEmpty(str)) {
                j3 = j2;
            } else if (TextUtils.isEmpty(str) || !str.contains("text/")) {
                byte[] bArr = new byte[8192];
                int i3 = 0;
                while (true) {
                    if (((long) i3) >= j2 || this.stop) {
                        break;
                    }
                    int readAt = cVar.readAt((long) i3, bArr, 0, 8192);
                    if (readAt < 0) {
                        com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDownloadProcess", "readSize:%d, terminal process or read end", Integer.valueOf(readAt));
                        break;
                    }
                    i3 += readAt;
                }
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "offSize:%d", Integer.valueOf(i3));
                this.dvV = true;
            } else {
                com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDownloadProcess", "mimetype not support");
            }
        }
        cVar.disconnect();
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "source disconnect");
        AppMethodBeat.o(198116);
    }

    @Override // com.tencent.mm.audio.mix.e.g
    public final void a(c cVar) {
        AppMethodBeat.i(198117);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "download process end, download finish:%b", Boolean.valueOf(this.dvV));
        d.b(cVar);
        if (this.dvV) {
            if (this.dvW != null) {
                this.dvW.c(this.dvk);
            }
        } else if (this.dvW != null) {
            this.dvW.d(this.dvk);
        }
        this.stop = true;
        cVar.dvY = null;
        this.dvW = null;
        AppMethodBeat.o(198117);
    }

    @Override // com.tencent.mm.audio.mix.e.g
    public final void stop() {
        this.stop = true;
    }
}
