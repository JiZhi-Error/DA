package com.tencent.mm.plugin.n;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public final class g {
    List<n> jQx;
    List<Pair> jQy;
    private RandomAccessFile zrn;
    n zro;
    int zrp;
    int zrq;

    public final void release() {
        AppMethodBeat.i(133908);
        if (this.zrn != null) {
            try {
                this.zrn.close();
            } catch (IOException e2) {
            }
        }
        this.jQx.clear();
        this.jQx = null;
        this.jQy.clear();
        this.jQy = null;
        this.zro = null;
        AppMethodBeat.o(133908);
    }

    public final int H(ByteBuffer byteBuffer) {
        Exception e2;
        int i2;
        AppMethodBeat.i(133909);
        if (this.zrp >= this.zrq) {
            AppMethodBeat.o(133909);
            return -1;
        }
        try {
            this.zrn.seek(this.zro.start);
            byte[] bArr = new byte[this.zro.size];
            i2 = this.zrn.read(bArr);
            try {
                if (i2 < this.zro.size) {
                    AppMethodBeat.o(133909);
                    return -1;
                }
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                bArr[3] = 1;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (bArr[i3] == Byte.MIN_VALUE && i3 + 4 < i2 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 0) {
                        bArr[i3 + 3] = 0;
                        bArr[i3 + 4] = 1;
                    }
                }
                byteBuffer.clear();
                byteBuffer.put(bArr, 0, i2).flip();
                AppMethodBeat.o(133909);
                return i2;
            } catch (Exception e3) {
                e2 = e3;
                Log.printErrStackTrace("MicroMsg.Mp4Extractor", e2, "read sample data error", new Object[0]);
                AppMethodBeat.o(133909);
                return i2;
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = -1;
            Log.printErrStackTrace("MicroMsg.Mp4Extractor", e2, "read sample data error", new Object[0]);
            AppMethodBeat.o(133909);
            return i2;
        }
    }
}
