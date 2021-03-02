package com.tencent.mm.audio.mix.d;

import android.media.MediaDataSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public final class g extends MediaDataSource {
    private IDataSource dataSource;

    public g(IDataSource iDataSource) {
        this.dataSource = iDataSource;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j2, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(198107);
        if (this.dataSource != null) {
            int readAt = this.dataSource.readAt(j2, bArr, i2, i3);
            AppMethodBeat.o(198107);
            return readAt;
        }
        AppMethodBeat.o(198107);
        return -1;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        AppMethodBeat.i(198108);
        if (this.dataSource != null) {
            long size = this.dataSource.getSize();
            AppMethodBeat.o(198108);
            return size;
        }
        AppMethodBeat.o(198108);
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(198109);
        if (this.dataSource != null) {
            this.dataSource.close();
            this.dataSource = null;
        }
        AppMethodBeat.o(198109);
    }
}
