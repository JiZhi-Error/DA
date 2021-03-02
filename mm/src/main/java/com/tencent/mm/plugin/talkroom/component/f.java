package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.talkroom.component.d;
import com.tencent.mm.plugin.talkroom.model.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends d.a {
    private v2engine FOY;
    private short FOZ;
    private short FPa;
    private c dyI;
    private c.a dzN = new c.a() {
        /* class com.tencent.mm.plugin.talkroom.component.f.AnonymousClass1 */

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            AppMethodBeat.i(29394);
            Log.d("MicroMsg.MicRecoder", "pcm len: ".concat(String.valueOf(i2)));
            if (i2 <= 0) {
                Log.e("MicroMsg.MicRecoder", "pcm data too low");
                AppMethodBeat.o(29394);
                return;
            }
            f.a(f.this, bArr, i2);
            int Send = f.this.FOY.Send(bArr, (short) i2);
            if (Send < 0) {
                Log.e("MicroMsg.MicRecoder", "send failed, ret: ".concat(String.valueOf(Send)));
                AppMethodBeat.o(29394);
                return;
            }
            AppMethodBeat.o(29394);
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
        }
    };

    public f(v2engine v2engine) {
        AppMethodBeat.i(29395);
        this.FOY = v2engine;
        AppMethodBeat.o(29395);
    }

    @Override // com.tencent.mm.plugin.talkroom.component.d
    public final void ftI() {
        AppMethodBeat.i(29396);
        if (this.dyI != null) {
            this.dyI.ZZ();
            this.dyI = null;
        }
        AppMethodBeat.o(29396);
    }

    @Override // com.tencent.mm.plugin.talkroom.component.d
    public final void bgt() {
        AppMethodBeat.i(29397);
        this.dyI = new c(a.FPn, 1, 2);
        this.dyI.x(8, false);
        this.dyI.dzv = this.dzN;
        this.dyI.jk(20);
        this.dyI.aai();
        this.FPa = 0;
        this.FOZ = 0;
        AppMethodBeat.o(29397);
    }

    @Override // com.tencent.mm.plugin.talkroom.component.d
    public final int ftJ() {
        if (this.FPa < this.FOZ) {
            this.FPa = this.FOZ;
        }
        if (this.FPa == 0) {
            return 0;
        }
        short s = (short) ((this.FOZ * 100) / this.FPa);
        this.FOZ = 0;
        return s;
    }

    @Override // com.tencent.mm.plugin.talkroom.component.d
    public final void start() {
    }

    @Override // com.tencent.mm.plugin.talkroom.component.d
    public final void release() {
        AppMethodBeat.i(29398);
        ftI();
        AppMethodBeat.o(29398);
    }

    static /* synthetic */ void a(f fVar, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < i2 / 2; i3++) {
            short s = (short) ((bArr[i3 * 2] & 255) | (bArr[(i3 * 2) + 1] << 8));
            if (s > fVar.FOZ) {
                fVar.FOZ = s;
            }
        }
    }
}
