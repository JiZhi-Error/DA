package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.i.a;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

public final class e extends d {
    private d duL;
    private InputStream inputStream;
    private OutputStream outputStream;

    public e(d dVar, int i2, int i3, int i4, String str) {
        AppMethodBeat.i(136767);
        b.i("MicroMsg.Mix.AudioFixedConvertProcess", "AudioFixedConvertProcess src:%s, sample:%d, channels:%d, encodeBit:%d", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        c.YP();
        this.duL = dVar;
        this.duF = a.hr(str);
        b.i("MicroMsg.Mix.AudioFixedConvertProcess", "outFile:%s", this.duF);
        s.deleteFile(this.duF);
        com.tencent.mm.audio.mix.b.a.Yw().gC(dVar.dtT);
        try {
            this.outputStream = s.ap(a.hs(this.duF));
        } catch (FileNotFoundException e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e2, "VFSFileOp.openWrite", new Object[0]);
        } catch (Exception e3) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e3, "VFSFileOp.openWrite", new Object[0]);
        }
        try {
            this.inputStream = s.ao(a.hs(this.duF));
        } catch (FileNotFoundException e4) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e4, "VFSFileOp.openRead", new Object[0]);
        } catch (Exception e5) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e5, "VFSFileOp.openRead", new Object[0]);
        }
        this.dus = str;
        this.duz = 44100;
        this.duA = 2;
        this.duB = 2;
        G(i2, i3, i4);
        AppMethodBeat.o(136767);
    }

    @Override // com.tencent.mm.audio.mix.c.h, com.tencent.mm.audio.mix.c.d
    public final byte[] X(byte[] bArr) {
        AppMethodBeat.i(136768);
        if (bArr == null) {
            AppMethodBeat.o(136768);
            return bArr;
        }
        byte[] X = super.X(bArr);
        if (this.outputStream == null) {
            AppMethodBeat.o(136768);
            return X;
        } else if (X != null) {
            try {
                this.outputStream.write(X, 0, X.length);
            } catch (Exception e2) {
                b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e2, "write", new Object[0]);
            }
            AppMethodBeat.o(136768);
            return X;
        } else {
            b.e("MicroMsg.Mix.AudioFixedConvertProcess", "desdata is null");
            AppMethodBeat.o(136768);
            return null;
        }
    }

    @Override // com.tencent.mm.audio.mix.c.h, com.tencent.mm.audio.mix.c.d
    public final void YR() {
        AppMethodBeat.i(136769);
        b.i("MicroMsg.Mix.AudioFixedConvertProcess", "finishProcess");
        try {
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
                this.outputStream = null;
            }
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e2, "finishProcess", new Object[0]);
        }
        Runtime.getRuntime().gc();
        AppMethodBeat.o(136769);
    }

    @Override // com.tencent.mm.audio.mix.c.h, com.tencent.mm.audio.mix.c.d
    public final com.tencent.mm.audio.mix.a.e YS() {
        AppMethodBeat.i(136770);
        if (this.inputStream == null) {
            b.e("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack, inputStream is null");
            AppMethodBeat.o(136770);
            return null;
        }
        byte[] bArr = new byte[3536];
        try {
            if (this.inputStream.read(bArr, 0, 3536) > 0) {
                com.tencent.mm.audio.mix.a.e YI = com.tencent.mm.audio.mix.b.e.YJ().YI();
                YI.dtQ = bArr;
                AppMethodBeat.o(136770);
                return YI;
            }
            b.e("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack readSize is 0");
            AppMethodBeat.o(136770);
            return null;
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e2, "readPcmDataTrack", new Object[0]);
            AppMethodBeat.o(136770);
            return null;
        }
    }

    @Override // com.tencent.mm.audio.mix.c.h, com.tencent.mm.audio.mix.c.d
    public final void flushCache() {
        int i2;
        AppMethodBeat.i(136771);
        b.i("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache");
        if (this.inputStream == null) {
            b.e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, inputStream is null");
            AppMethodBeat.o(136771);
        } else if (this.duL.aBQ) {
            b.e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, cache is complete");
            AppMethodBeat.o(136771);
        } else {
            int i3 = 0;
            while (i3 != -1) {
                byte[] bArr = new byte[3536];
                try {
                    i2 = this.inputStream.read(bArr, 0, 3536);
                } catch (Exception e2) {
                    b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e2, "readPcmDataTrack", new Object[0]);
                    i2 = i3;
                }
                if (i2 > 0) {
                    com.tencent.mm.audio.mix.a.e YI = com.tencent.mm.audio.mix.b.e.YJ().YI();
                    YI.dtQ = bArr;
                    this.duL.a(YI);
                }
                i3 = i2;
            }
            this.duL.complete();
            AppMethodBeat.o(136771);
        }
    }

    @Override // com.tencent.mm.audio.mix.c.h, com.tencent.mm.audio.mix.c.d
    public final void release() {
        AppMethodBeat.i(136772);
        b.i("MicroMsg.Mix.AudioFixedConvertProcess", "release");
        super.release();
        try {
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
                this.outputStream = null;
            }
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e2, "outputStream close", new Object[0]);
        }
        try {
            if (this.inputStream != null) {
                this.inputStream.close();
                this.inputStream = null;
            }
            AppMethodBeat.o(136772);
        } catch (Exception e3) {
            b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", e3, "inputStream close", new Object[0]);
            AppMethodBeat.o(136772);
        }
    }

    @Override // com.tencent.mm.audio.mix.c.d
    public final i YQ() {
        AppMethodBeat.i(136773);
        j jVar = new j();
        AppMethodBeat.o(136773);
        return jVar;
    }
}
