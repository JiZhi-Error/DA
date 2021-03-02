package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class n {
    private boolean bqX;
    private final int brV;
    boolean brW;
    public int brX;
    public byte[] nalData = new byte[TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE];

    public n(int i2) {
        AppMethodBeat.i(92262);
        this.brV = i2;
        this.nalData[2] = 1;
        AppMethodBeat.o(92262);
    }

    public final void reset() {
        this.bqX = false;
        this.brW = false;
    }

    public final void er(int i2) {
        boolean z = true;
        AppMethodBeat.i(92263);
        a.checkState(!this.bqX);
        if (i2 != this.brV) {
            z = false;
        }
        this.bqX = z;
        if (this.bqX) {
            this.brX = 3;
            this.brW = false;
        }
        AppMethodBeat.o(92263);
    }

    public final void f(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(92264);
        if (!this.bqX) {
            AppMethodBeat.o(92264);
            return;
        }
        int i4 = i3 - i2;
        if (this.nalData.length < this.brX + i4) {
            this.nalData = Arrays.copyOf(this.nalData, (this.brX + i4) * 2);
        }
        System.arraycopy(bArr, i2, this.nalData, this.brX, i4);
        this.brX = i4 + this.brX;
        AppMethodBeat.o(92264);
    }

    public final boolean es(int i2) {
        if (!this.bqX) {
            return false;
        }
        this.brX -= i2;
        this.bqX = false;
        this.brW = true;
        return true;
    }
}
