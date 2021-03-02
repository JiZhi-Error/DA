package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class m implements a {
    private static int jvj = 100;
    public c dyI;
    private int dyt = 0;
    c.a dzv = new c.a() {
        /* class com.tencent.mm.modelvoice.m.AnonymousClass1 */

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            AppMethodBeat.i(148428);
            if (m.this.jvk != null) {
                m.this.jvk.a(new g.a(bArr, i2), 0, false);
            }
            m.a(m.this, bArr, i2);
            Log.d("MicroMsg.SpeexRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", Integer.valueOf(bArr.length), Integer.valueOf(i2));
            tq tqVar = new tq();
            tqVar.ead.buf = Arrays.copyOf(bArr, bArr.length);
            tqVar.ead.len = i2;
            EventCenter.instance.publish(tqVar);
            AppMethodBeat.o(148428);
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
        }
    };
    private d jvk;
    private String mFileName = null;
    public int mStatus = 0;

    public m() {
        AppMethodBeat.i(148429);
        AppMethodBeat.o(148429);
    }

    @Override // com.tencent.mm.audio.b.a
    public final boolean hw(String str) {
        AppMethodBeat.i(148430);
        if (!Util.isNullOrNil(this.mFileName)) {
            Log.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            AppMethodBeat.o(148430);
            return false;
        }
        Log.i("MicroMsg.SpeexRecorder", "[startRecord] fileName:%s", str);
        this.mStatus = 1;
        this.dyt = 0;
        this.dyI = new c(16000, 1, 0);
        this.dyI.dzk = -19;
        if (ae.gKE.gGG > 0) {
            this.dyI.x(ae.gKE.gGG, true);
        } else {
            this.dyI.x(5, false);
        }
        this.dyI.dc(false);
        this.dyI.dzv = this.dzv;
        this.jvk = new d();
        if (!this.jvk.hz(str)) {
            Log.e("MicroMsg.SpeexRecorder", "init speex writer failed");
            clean();
            this.mStatus = -1;
            AppMethodBeat.o(148430);
            return false;
        } else if (!this.dyI.aai()) {
            Log.e("MicroMsg.SpeexRecorder", "start record failed");
            clean();
            this.mStatus = -1;
            AppMethodBeat.o(148430);
            return false;
        } else {
            this.mFileName = str;
            AppMethodBeat.o(148430);
            return true;
        }
    }

    @Override // com.tencent.mm.audio.b.a
    public final void a(m.a aVar) {
    }

    @Override // com.tencent.mm.audio.b.a
    public final boolean ZZ() {
        AppMethodBeat.i(148431);
        this.mFileName = null;
        this.mStatus = 0;
        clean();
        AppMethodBeat.o(148431);
        return true;
    }

    @Override // com.tencent.mm.audio.b.a
    public final int getStatus() {
        return this.mStatus;
    }

    private void clean() {
        AppMethodBeat.i(148432);
        if (this.dyI != null) {
            this.dyI.ZZ();
            this.dyI = null;
        }
        if (this.jvk != null) {
            this.jvk.abP();
            this.jvk = null;
        }
        AppMethodBeat.o(148432);
    }

    @Override // com.tencent.mm.audio.b.a
    public final int getMaxAmplitude() {
        int i2 = this.dyt;
        this.dyt = 0;
        if (i2 > jvj) {
            jvj = i2;
        }
        return (i2 * 100) / jvj;
    }

    @Override // com.tencent.mm.audio.b.a
    public final int aaa() {
        return this.dyI.dzA;
    }

    static /* synthetic */ void a(m mVar, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < i2 / 2; i3++) {
            short s = (short) ((bArr[i3 * 2] & 255) | (bArr[(i3 * 2) + 1] << 8));
            if (s > mVar.dyt) {
                mVar.dyt = s;
            }
        }
    }
}
