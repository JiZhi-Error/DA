package com.tencent.qqpinyin.voicerecoapi;

import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private TRVADNative RKJ;
    private int jwi;
    private int mTimeout;

    public static class a {
        public int RKK = 0;
        public int RKL = 256;
        public int RKM = 512;
        private int RKN = 0;
        public int RKO = 0;
    }

    public c(int i2) {
        AppMethodBeat.i(87689);
        this.RKJ = new TRVADNative();
        this.jwi = i2;
        this.mTimeout = GmsVersion.VERSION_LONGHORN;
        AppMethodBeat.o(87689);
    }

    public c() {
        AppMethodBeat.i(87690);
        this.RKJ = new TRVADNative();
        this.jwi = 500000;
        this.mTimeout = 10000000;
        AppMethodBeat.o(87690);
    }

    public final int hkt() {
        AppMethodBeat.i(87691);
        int mfeInit = this.RKJ.mfeInit(this.jwi, this.mTimeout);
        if (mfeInit == 0 && (mfeInit = this.RKJ.mfeOpen()) == 0 && (mfeInit = this.RKJ.mfeEnableNoiseDetection(true)) == 0) {
            mfeInit = this.RKJ.mfeStart();
        }
        if (mfeInit == 0) {
            AppMethodBeat.o(87691);
            return 0;
        }
        AppMethodBeat.o(87691);
        return -1;
    }

    public final int stop() {
        AppMethodBeat.i(87692);
        int mfeStop = this.RKJ.mfeStop();
        if (mfeStop == 0 && (mfeStop = this.RKJ.mfeClose()) == 0) {
            mfeStop = this.RKJ.mfeExit();
        }
        if (mfeStop == 0) {
            AppMethodBeat.o(87692);
            return 0;
        }
        AppMethodBeat.o(87692);
        return -1;
    }

    public final synchronized void a(short[] sArr, int i2, a aVar) {
        double d2 = 26.0d;
        synchronized (this) {
            AppMethodBeat.i(87693);
            if (i2 <= 0) {
                AppMethodBeat.o(87693);
            } else {
                switch (this.RKJ.mfeSendData(sArr, i2)) {
                    case 1:
                        aVar.RKK = 1;
                        break;
                    case 2:
                        aVar.RKK = 2;
                        break;
                    case 3:
                        aVar.RKK = 3;
                        break;
                    default:
                        aVar.RKK = 0;
                        break;
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < i2) {
                    i3++;
                    i4 = (int) (((double) i4) + (Math.sqrt((double) (sArr[i3] * sArr[i3])) / ((double) i2)));
                }
                if (i4 < 100) {
                    d2 = 0.0d;
                } else if (i4 <= 16383) {
                    d2 = 26.0d * ((((double) i4) - 100.0d) / 32667.0d);
                }
                aVar.RKO = (int) d2;
                new StringBuilder("volumn：").append(aVar.RKO);
                AppMethodBeat.o(87693);
            }
        }
    }
}
