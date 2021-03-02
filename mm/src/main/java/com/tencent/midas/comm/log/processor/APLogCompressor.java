package com.tencent.midas.comm.log.processor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.compressor.CachedByteArrayStream;
import com.tencent.midas.comm.log.util.compressor.GzipCompressorOutputStream;
import java.io.IOException;

public class APLogCompressor {
    private GzipCompressorOutputStream gziper = null;
    private CachedByteArrayStream out = null;

    public static APLogCompressor create() {
        AppMethodBeat.i(193428);
        APLogCompressor aPLogCompressor = new APLogCompressor();
        try {
            aPLogCompressor.out = new CachedByteArrayStream(512);
            aPLogCompressor.gziper = new GzipCompressorOutputStream(aPLogCompressor.out);
            AppMethodBeat.o(193428);
            return aPLogCompressor;
        } catch (IOException e2) {
            AppMethodBeat.o(193428);
            return null;
        }
    }

    public synchronized byte[] compress(byte[] bArr) {
        byte[] byteArray;
        AppMethodBeat.i(193429);
        this.gziper.continued();
        this.out.reset();
        this.gziper.writeHeader();
        this.gziper.write(bArr, 0, bArr.length);
        this.gziper.finish();
        this.gziper.flush();
        byteArray = this.out.toByteArray();
        AppMethodBeat.o(193429);
        return byteArray;
    }

    public void close() {
        AppMethodBeat.i(193430);
        if (this.gziper != null) {
            this.gziper.close();
        }
        if (this.out != null) {
            this.out.close();
        }
        AppMethodBeat.o(193430);
    }
}
