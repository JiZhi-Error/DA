package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDataSource implements IDataSource {
    private long currentPosition;
    private InputStream currentStream;
    private final InputStreamFactory factory;
    private long size;

    public interface InputStreamFactory {
        InputStream create();
    }

    public InputStreamDataSource(InputStreamFactory inputStreamFactory) {
        this.factory = inputStreamFactory;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() {
        AppMethodBeat.i(114299);
        if (this.currentStream != null) {
            this.currentStream.close();
        }
        this.currentStream = this.factory.create();
        this.size = (long) this.currentStream.available();
        this.currentPosition = 0;
        AppMethodBeat.o(114299);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j2, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(114300);
        if (j2 < this.currentPosition) {
            open();
            int readAt = readAt(j2, bArr, i2, i3);
            AppMethodBeat.o(114300);
            return readAt;
        }
        if (j2 > this.currentPosition) {
            long j3 = j2 - this.currentPosition;
            while (true) {
                long skip = this.currentStream.skip(j3);
                j3 -= skip;
                if (j3 <= 0 && skip > 0) {
                    break;
                }
            }
            if (j3 < 0) {
                IOException iOException = new IOException("skipped too much bytes");
                AppMethodBeat.o(114300);
                throw iOException;
            }
            this.currentPosition = j2;
        }
        int read = this.currentStream.read(bArr, i2, i3);
        if (read > 0) {
            this.currentPosition += (long) read;
        }
        AppMethodBeat.o(114300);
        return read;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() {
        return this.size;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() {
        AppMethodBeat.i(114301);
        AudioFormat.AudioType audioFormat = FormatDetector.getAudioFormat((IDataSource) this, false);
        AppMethodBeat.o(114301);
        return audioFormat;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(114302);
        if (this.currentStream != null) {
            this.currentStream.close();
        }
        AppMethodBeat.o(114302);
    }
}
