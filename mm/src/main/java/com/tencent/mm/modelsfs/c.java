package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends SFSInputStream {
    private a jiU;

    public c(long j2, long j3) {
        super(j2);
        AppMethodBeat.i(155985);
        this.jiU = new a(j3);
        AppMethodBeat.o(155985);
    }

    @Override // com.tencent.mm.modelsfs.SFSInputStream
    public final void mark(int i2) {
        AppMethodBeat.i(155986);
        super.mark(i2);
        a aVar = this.jiU;
        aVar.jiT = aVar.jiR;
        AppMethodBeat.o(155986);
    }

    @Override // com.tencent.mm.modelsfs.SFSInputStream, java.io.InputStream
    public final void reset() {
        AppMethodBeat.i(155987);
        super.reset();
        a aVar = this.jiU;
        Log.i("MicroMsg.EncEngine", "reset " + Util.getStack());
        aVar.free();
        if (aVar.jiT == 0) {
            aVar.init();
            aVar.jiR = 0;
            AppMethodBeat.o(155987);
            return;
        }
        aVar.init();
        MMIMAGEENCJNI.seek(aVar.mNativePtr, aVar.jiT, 1);
        aVar.jiR = aVar.jiT;
        AppMethodBeat.o(155987);
    }

    @Override // com.tencent.mm.modelsfs.SFSInputStream, java.io.InputStream
    public final int read() {
        AppMethodBeat.i(155988);
        int read = super.read();
        AppMethodBeat.o(155988);
        return read;
    }

    @Override // com.tencent.mm.modelsfs.SFSInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(155989);
        int read = super.read(bArr, i2, i3);
        if (read < 0) {
            AppMethodBeat.o(155989);
        } else {
            this.jiU.B(bArr, i3);
            AppMethodBeat.o(155989);
        }
        return read;
    }

    @Override // com.tencent.mm.modelsfs.SFSInputStream, java.io.InputStream
    public final long skip(long j2) {
        AppMethodBeat.i(155990);
        long skip = super.skip(j2);
        a aVar = this.jiU;
        aVar.jiR = j2;
        MMIMAGEENCJNI.seek(aVar.mNativePtr, j2, 1);
        AppMethodBeat.o(155990);
        return skip;
    }

    @Override // java.io.Closeable, com.tencent.mm.modelsfs.SFSInputStream, java.lang.AutoCloseable, java.io.InputStream
    public final void close() {
        AppMethodBeat.i(155991);
        super.close();
        if (this.jiU != null) {
            this.jiU.free();
        }
        AppMethodBeat.o(155991);
    }
}
