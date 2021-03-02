package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class ByteArrayCache implements Cache {
    private volatile boolean completed;
    private volatile byte[] data;

    public ByteArrayCache() {
        this(new byte[0]);
        AppMethodBeat.i(223123);
        AppMethodBeat.o(223123);
    }

    public ByteArrayCache(byte[] bArr) {
        AppMethodBeat.i(223124);
        this.data = (byte[]) Preconditions.checkNotNull(bArr);
        AppMethodBeat.o(223124);
    }

    @Override // com.danikula.videocache.Cache
    public int read(byte[] bArr, long j2, int i2) {
        AppMethodBeat.i(223125);
        if (j2 >= ((long) this.data.length)) {
            AppMethodBeat.o(223125);
            return -1;
        } else if (j2 > 2147483647L) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Too long offset for memory cache ".concat(String.valueOf(j2)));
            AppMethodBeat.o(223125);
            throw illegalArgumentException;
        } else {
            int read = new ByteArrayInputStream(this.data).read(bArr, (int) j2, i2);
            AppMethodBeat.o(223125);
            return read;
        }
    }

    @Override // com.danikula.videocache.Cache
    public long available() {
        return (long) this.data.length;
    }

    @Override // com.danikula.videocache.Cache
    public void append(byte[] bArr, int i2) {
        AppMethodBeat.i(223126);
        Preconditions.checkNotNull(this.data);
        Preconditions.checkArgument(i2 >= 0 && i2 <= bArr.length);
        byte[] copyOf = Arrays.copyOf(this.data, this.data.length + i2);
        System.arraycopy(bArr, 0, copyOf, this.data.length, i2);
        this.data = copyOf;
        AppMethodBeat.o(223126);
    }

    @Override // com.danikula.videocache.Cache
    public void close() {
    }

    @Override // com.danikula.videocache.Cache
    public void complete() {
        this.completed = true;
    }

    @Override // com.danikula.videocache.Cache
    public boolean isCompleted() {
        return this.completed;
    }
}
