package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

/* access modifiers changed from: package-private */
public class TrackPositionDataSource {
    private final IDataSource mDataSource;
    private long mPosition = 0;

    TrackPositionDataSource(IDataSource iDataSource) {
        this.mDataSource = iDataSource;
    }

    public int read(byte[] bArr, int i2) {
        AppMethodBeat.i(114246);
        int readAt = this.mDataSource.readAt(this.mPosition, bArr, 0, i2);
        this.mPosition += (long) readAt;
        AppMethodBeat.o(114246);
        return readAt;
    }

    public long seek(long j2) {
        AppMethodBeat.i(114247);
        if (j2 < this.mDataSource.getSize()) {
            this.mPosition = j2;
        } else {
            j2 = -1;
        }
        AppMethodBeat.o(114247);
        return j2;
    }

    public long getSize() {
        AppMethodBeat.i(114248);
        long size = this.mDataSource.getSize();
        AppMethodBeat.o(114248);
        return size;
    }

    public long getCurPosition() {
        return this.mPosition;
    }
}
