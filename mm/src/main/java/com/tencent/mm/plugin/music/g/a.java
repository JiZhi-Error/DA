package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.nio.ByteBuffer;

public final class a implements IDataSource {
    private ByteBuffer byteBuffer;
    private long jPY;
    private Object lock = new Object();

    public a(ByteBuffer byteBuffer2) {
        AppMethodBeat.i(198185);
        this.byteBuffer = byteBuffer2;
        AppMethodBeat.o(198185);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public final void open() {
        AppMethodBeat.i(198186);
        synchronized (this.lock) {
            try {
                if (this.byteBuffer != null) {
                    this.byteBuffer.rewind();
                }
            } finally {
                AppMethodBeat.o(198186);
            }
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public final int readAt(long j2, byte[] bArr, int i2, int i3) {
        int i4;
        AppMethodBeat.i(198187);
        if (this.byteBuffer == null) {
            Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "buffer is null");
            AppMethodBeat.o(198187);
            return -1;
        } else if (getSize() <= 0) {
            Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "getSize <= 0");
            AppMethodBeat.o(198187);
            return -1;
        } else if (bArr == null || bArr.length <= 0) {
            Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "bytes is null");
            AppMethodBeat.o(198187);
            return -1;
        } else if (j2 < 0 || i2 < 0 || i3 <= 0) {
            Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "position:%d, offset:%d, size:%d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(198187);
            return -1;
        } else if (bArr == null || i2 + i3 <= bArr.length) {
            if (((long) i3) + j2 > getSize()) {
                Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "position:%d, size:%d, getSize():%d", Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(getSize()));
            }
            if (this.jPY == 0) {
                this.jPY = getSize();
            }
            if (this.jPY <= 0 || j2 <= this.jPY || i3 <= 0) {
                synchronized (this.lock) {
                    try {
                        if (this.byteBuffer != null) {
                            this.byteBuffer.position((int) j2);
                            if (!this.byteBuffer.hasRemaining()) {
                                Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "no remaining");
                                return -1;
                            }
                            i4 = Math.min(i3, this.byteBuffer.remaining());
                            this.byteBuffer.get(bArr, i2, i4);
                        } else {
                            i4 = i3;
                        }
                        AppMethodBeat.o(198187);
                        return i4;
                    } finally {
                        AppMethodBeat.o(198187);
                    }
                }
            } else {
                AppMethodBeat.o(198187);
                return -1;
            }
        } else {
            Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length));
            AppMethodBeat.o(198187);
            return -1;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public final long getSize() {
        AppMethodBeat.i(198188);
        synchronized (this.lock) {
            try {
                if (this.byteBuffer != null) {
                    return (long) this.byteBuffer.limit();
                }
                AppMethodBeat.o(198188);
                return -1;
            } finally {
                AppMethodBeat.o(198188);
            }
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public final AudioFormat.AudioType getAudioType() {
        AppMethodBeat.i(198189);
        if (this.byteBuffer == null) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            AppMethodBeat.o(198189);
            return audioType;
        }
        AudioFormat.AudioType audioFormat = FormatDetector.getAudioFormat((IDataSource) this, false);
        AppMethodBeat.o(198189);
        return audioFormat;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.lock) {
            this.byteBuffer = null;
        }
    }
}
