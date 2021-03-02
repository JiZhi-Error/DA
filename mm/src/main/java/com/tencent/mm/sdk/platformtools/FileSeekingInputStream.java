package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;

public class FileSeekingInputStream extends FilterInputStream {
    private long mMarkPosition = 0;

    public FileSeekingInputStream(FileInputStream fileInputStream) {
        super(fileInputStream);
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int i2) {
        AppMethodBeat.i(157537);
        try {
            this.mMarkPosition = ((FileInputStream) this.in).getChannel().position();
            AppMethodBeat.o(157537);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FileSeekingInputStream", e2, "Failed seeking FileChannel.", new Object[0]);
            AppMethodBeat.o(157537);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        AppMethodBeat.i(157538);
        ((FileInputStream) this.in).getChannel().position(this.mMarkPosition);
        AppMethodBeat.o(157538);
    }
}
