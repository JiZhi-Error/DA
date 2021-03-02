package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.util.StreamUtils;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class FileDataSource implements IDataSource {
    private long currentPosition;
    private RandomAccessFile file;
    private FileInputStream fileInputStream;
    private final String filePath;
    private boolean opened = false;
    private BufferedInputStream readingStream;

    public FileDataSource(String str) {
        this.filePath = str;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() {
        AppMethodBeat.i(114290);
        if (this.opened) {
            AppMethodBeat.o(114290);
            return;
        }
        this.opened = true;
        this.file = new RandomAccessFile(this.filePath, "r");
        this.fileInputStream = new FileInputStream(this.file.getFD());
        this.readingStream = new BufferedInputStream(this.fileInputStream);
        this.currentPosition = 0;
        AppMethodBeat.o(114290);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j2, byte[] bArr, int i2, int i3) {
        long skipForBufferStream;
        AppMethodBeat.i(114291);
        if (this.currentPosition != j2) {
            if (this.currentPosition > j2) {
                this.file.seek(j2);
                this.readingStream = new BufferedInputStream(this.fileInputStream);
                skipForBufferStream = j2;
            } else {
                skipForBufferStream = this.currentPosition + StreamUtils.skipForBufferStream(this.readingStream, j2 - this.currentPosition);
            }
            if (skipForBufferStream != j2) {
                AppMethodBeat.o(114291);
                return -1;
            }
            this.currentPosition = j2;
        }
        int read = this.readingStream.read(bArr, i2, i3);
        if (read >= 0) {
            this.currentPosition += (long) read;
        }
        AppMethodBeat.o(114291);
        return read;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() {
        AppMethodBeat.i(114292);
        long length = this.file.length();
        AppMethodBeat.o(114292);
        return length;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() {
        AppMethodBeat.i(114293);
        AudioFormat.AudioType recognitionAudioFormatExactly = AudioRecognition.recognitionAudioFormatExactly(this.filePath);
        AppMethodBeat.o(114293);
        return recognitionAudioFormatExactly;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(114294);
        if (!this.opened) {
            AppMethodBeat.o(114294);
            return;
        }
        if (this.fileInputStream != null) {
            this.fileInputStream.close();
        }
        if (this.readingStream != null) {
            this.readingStream.close();
        }
        if (this.file != null) {
            this.file.close();
        }
        this.opened = false;
        AppMethodBeat.o(114294);
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String toString() {
        AppMethodBeat.i(114295);
        String str = "(fd)" + this.filePath;
        AppMethodBeat.o(114295);
        return str;
    }
}
