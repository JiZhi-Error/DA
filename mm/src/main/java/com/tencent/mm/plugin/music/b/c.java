package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import java.net.URL;
import java.util.HashMap;

public final class c extends b {
    private IMediaHTTPConnection AgO;
    private com.tencent.mm.ai.b dvk;

    public c(IMediaHTTPConnection iMediaHTTPConnection, com.tencent.mm.ai.b bVar) {
        this.AgO = iMediaHTTPConnection;
        this.dvk = bVar;
    }

    @Override // com.tencent.mm.audio.mix.h.b, com.tencent.mm.audio.mix.h.c
    public final com.tencent.mm.ai.b ZU() {
        return this.dvk;
    }

    @Override // com.tencent.mm.audio.mix.h.b, com.tencent.mm.audio.mix.h.c
    public final void connect() {
        URL url;
        AppMethodBeat.i(198135);
        if (this.AgO != null) {
            try {
                url = new URL(this.dvk.dvn);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.AudioHttpDownloadSource", e2, "connect", new Object[0]);
                url = null;
            }
            this.AgO.connect(url, new HashMap());
        }
        AppMethodBeat.o(198135);
    }

    @Override // com.tencent.mm.audio.mix.h.b, com.tencent.mm.audio.mix.h.c
    public final void disconnect() {
        AppMethodBeat.i(198136);
        if (this.AgO != null) {
            this.AgO.disconnect();
        }
        AppMethodBeat.o(198136);
    }

    @Override // com.tencent.mm.audio.mix.h.b, com.tencent.mm.audio.mix.h.c
    public final int readAt(long j2, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(198137);
        if (this.AgO != null) {
            int readAt = this.AgO.readAt(j2, bArr, i2, i3);
            AppMethodBeat.o(198137);
            return readAt;
        }
        int readAt2 = super.readAt(j2, bArr, i2, i3);
        AppMethodBeat.o(198137);
        return readAt2;
    }

    @Override // com.tencent.mm.audio.mix.h.b, com.tencent.mm.audio.mix.h.c
    public final long getSize() {
        AppMethodBeat.i(198138);
        if (this.AgO != null) {
            long size = this.AgO.getSize();
            AppMethodBeat.o(198138);
            return size;
        }
        long size2 = super.getSize();
        AppMethodBeat.o(198138);
        return size2;
    }

    @Override // com.tencent.mm.audio.mix.h.b, com.tencent.mm.audio.mix.h.c
    public final String ZV() {
        AppMethodBeat.i(198139);
        if (this.AgO != null) {
            String mIMEType = this.AgO.getMIMEType();
            AppMethodBeat.o(198139);
            return mIMEType;
        }
        String ZV = super.ZV();
        AppMethodBeat.o(198139);
        return ZV;
    }
}
