package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.a;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class b {
    protected String dus;
    protected String dut;
    public InputStream inputStream;

    public b(String str, boolean z, String str2) {
        AppMethodBeat.i(198104);
        if (z) {
            this.dut = a.S(str2, str);
        } else {
            this.dut = a.hr(str);
        }
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioConvertCacheReader", "cacheFile:%s", this.dut);
        try {
            this.inputStream = s.ao(a.hs(this.dut));
        } catch (FileNotFoundException e2) {
            com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", e2, "VFSFileOp.openRead", new Object[0]);
        } catch (Exception e3) {
            com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", e3, "VFSFileOp.openRead", new Object[0]);
        }
        this.dus = str;
        AppMethodBeat.o(198104);
    }

    public final byte[] YO() {
        AppMethodBeat.i(198105);
        if (this.inputStream == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioConvertCacheReader", "readPcmDataTrack, inputStream is null");
            AppMethodBeat.o(198105);
            return null;
        }
        byte[] bArr = new byte[3536];
        try {
            if (this.inputStream.read(bArr, 0, 3536) > 0) {
                AppMethodBeat.o(198105);
                return bArr;
            }
            AppMethodBeat.o(198105);
            return null;
        } catch (Exception e2) {
            com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", e2, "readPcmDataTrack", new Object[0]);
            AppMethodBeat.o(198105);
            return null;
        }
    }
}
