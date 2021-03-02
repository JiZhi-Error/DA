package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.decoder.EncoderWriter;

public class c implements d {
    String nef = EncoderWriter.OUTPUT_AUDIO_MIME_TYPE;
    String neg = "audio/mpeg";
    d.a neh = null;
    int nei = 0;
    int nej = 0;
    byte[] nek;
    int nel = 0;

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d
    public final void yA(int i2) {
        AppMethodBeat.i(146342);
        Log.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", Integer.valueOf(this.nei));
        this.nei = i2;
        AppMethodBeat.o(146342);
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d
    public final void a(d.a aVar) {
        this.neh = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d
    public final void r(double d2) {
        AppMethodBeat.i(146343);
        this.nej = (int) (1024.0d * d2);
        Log.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", Double.valueOf(d2), Integer.valueOf(this.nej));
        this.nek = new byte[this.nej];
        AppMethodBeat.o(146343);
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d
    public boolean i(String str, int i2, int i3, int i4) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d
    public boolean a(boolean z, byte[] bArr, int i2) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d
    public void flush() {
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d
    public void close() {
    }

    public final void d(byte[] bArr, int i2, boolean z) {
        AppMethodBeat.i(146344);
        if (this.neh == null) {
            Log.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
            AppMethodBeat.o(146344);
        } else if (((double) this.nej) == 0.0d) {
            Log.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
            AppMethodBeat.o(146344);
        } else {
            if (i2 > this.nej) {
                Log.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", Integer.valueOf(i2), Integer.valueOf(this.nej));
            }
            Log.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", Integer.valueOf(this.nel), Integer.valueOf(i2));
            int i3 = this.nel + i2;
            if (i3 >= this.nej && bArr != null) {
                Log.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", Integer.valueOf(i3));
                if (i3 > this.nek.length) {
                    Log.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", Integer.valueOf(i3));
                    byte[] bArr2 = this.nek;
                    this.nek = new byte[i3];
                    System.arraycopy(bArr2, 0, this.nek, 0, this.nel);
                }
                System.arraycopy(bArr, 0, this.nek, this.nel, i2);
                this.neh.c(this.nek, i3, false);
                this.nel = 0;
            } else if (bArr != null) {
                System.arraycopy(bArr, 0, this.nek, this.nel, i2);
                this.nel = i3;
                Log.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", Integer.valueOf(this.nel));
            }
            if (z) {
                Log.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", Integer.valueOf(this.nel));
                this.neh.c(this.nek, this.nel, z);
                this.nel = 0;
            }
            AppMethodBeat.o(146344);
        }
    }
}
