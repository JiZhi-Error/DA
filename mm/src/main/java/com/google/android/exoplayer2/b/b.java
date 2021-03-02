package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public int bhd;
    public int bhe;
    public final MediaCodec.CryptoInfo bhf;
    private final a bhg;
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;

    public b() {
        MediaCodec.CryptoInfo cryptoInfo;
        a aVar = null;
        AppMethodBeat.i(91848);
        if (x.SDK_INT >= 16) {
            cryptoInfo = new MediaCodec.CryptoInfo();
        } else {
            cryptoInfo = null;
        }
        this.bhf = cryptoInfo;
        this.bhg = x.SDK_INT >= 24 ? new a(this.bhf, (byte) 0) : aVar;
        AppMethodBeat.o(91848);
    }

    public final void a(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        AppMethodBeat.i(91849);
        this.numSubSamples = i2;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i3;
        this.bhd = i4;
        this.bhe = i5;
        if (x.SDK_INT >= 16) {
            this.bhf.numSubSamples = this.numSubSamples;
            this.bhf.numBytesOfClearData = this.numBytesOfClearData;
            this.bhf.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            this.bhf.key = this.key;
            this.bhf.iv = this.iv;
            this.bhf.mode = this.mode;
            if (x.SDK_INT >= 24) {
                a aVar = this.bhg;
                aVar.bhh.set(this.bhd, this.bhe);
                aVar.bhf.setPattern(aVar.bhh);
            }
        }
        AppMethodBeat.o(91849);
    }

    @TargetApi(24)
    static final class a {
        final MediaCodec.CryptoInfo bhf;
        final MediaCodec.CryptoInfo.Pattern bhh;

        /* synthetic */ a(MediaCodec.CryptoInfo cryptoInfo, byte b2) {
            this(cryptoInfo);
        }

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            AppMethodBeat.i(91847);
            this.bhf = cryptoInfo;
            this.bhh = new MediaCodec.CryptoInfo.Pattern(0, 0);
            AppMethodBeat.o(91847);
        }
    }
}
