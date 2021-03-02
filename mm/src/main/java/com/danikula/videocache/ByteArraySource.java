package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;

public class ByteArraySource implements Source {
    private ByteArrayInputStream arrayInputStream;
    private final byte[] data;

    public ByteArraySource(byte[] bArr) {
        this.data = bArr;
    }

    @Override // com.danikula.videocache.Source
    public int read(byte[] bArr) {
        AppMethodBeat.i(223127);
        int read = this.arrayInputStream.read(bArr, 0, bArr.length);
        AppMethodBeat.o(223127);
        return read;
    }

    @Override // com.danikula.videocache.Source
    public long length() {
        return (long) this.data.length;
    }

    @Override // com.danikula.videocache.Source
    public void open(long j2) {
        AppMethodBeat.i(223128);
        this.arrayInputStream = new ByteArrayInputStream(this.data);
        this.arrayInputStream.skip(j2);
        AppMethodBeat.o(223128);
    }

    @Override // com.danikula.videocache.Source
    public void close() {
    }
}
