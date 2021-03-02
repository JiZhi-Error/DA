package com.tencent.qqmusic.mediaplayer.downstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.RandomAccessFile;

public class FileDataSink implements IDataSink {
    private static final String TAG = "FileDataSink";
    private long currentPosition = 0;
    private final String filePath;
    private boolean opened = false;
    private RandomAccessFile randomAccessFile = null;

    public FileDataSink(String str) {
        this.filePath = str;
    }

    @Override // com.tencent.qqmusic.mediaplayer.downstream.IDataSink
    public void open() {
        AppMethodBeat.i(76588);
        if (this.opened) {
            AppMethodBeat.o(76588);
            return;
        }
        this.randomAccessFile = new RandomAccessFile(this.filePath, "rw");
        this.currentPosition = 0;
        this.opened = true;
        AppMethodBeat.o(76588);
    }

    @Override // com.tencent.qqmusic.mediaplayer.downstream.IDataSink
    public int write(long j2, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(76589);
        if (this.randomAccessFile != null) {
            if (this.currentPosition != j2) {
                Logger.d(TAG, "[write] seek to: ".concat(String.valueOf(j2)));
                this.randomAccessFile.seek(j2);
                this.currentPosition = j2;
            }
            this.randomAccessFile.write(bArr, i2, i3);
            this.currentPosition += (long) i3;
            AppMethodBeat.o(76589);
            return i3;
        }
        AppMethodBeat.o(76589);
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(76590);
        if (!this.opened) {
            AppMethodBeat.o(76590);
            return;
        }
        this.randomAccessFile.close();
        this.currentPosition = 0;
        AppMethodBeat.o(76590);
    }
}
