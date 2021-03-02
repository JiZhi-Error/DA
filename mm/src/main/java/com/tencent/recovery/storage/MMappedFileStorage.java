package com.tencent.recovery.storage;

import com.tencent.recovery.log.RecoveryLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MMappedFileStorage {
    private static final int DEFAULT_MAX_BUFFER_SIZE = 153600;
    private static final int HEADER_OFFSET = 4;
    private static final String TAG = "Recovery.MMappedFileStorage";
    private int currentIndex;
    private int maxTempFileLength = DEFAULT_MAX_BUFFER_SIZE;
    private File targetFile;
    private MappedByteBuffer tempBuffer;
    private File tempFile = new File(this.targetFile.getParentFile(), "temp-" + this.targetFile.getName());
    private RandomAccessFile tempRandomAccessFile;

    public MMappedFileStorage(String str) {
        this.targetFile = new File(str);
        init();
    }

    private void init() {
        if (!this.targetFile.getParentFile().exists()) {
            this.targetFile.getParentFile().mkdirs();
        }
        if (this.tempFile.exists()) {
            copyAppendTargetFile(this.tempFile, this.targetFile);
            this.tempFile.delete();
        }
    }

    public synchronized void appendToBuffer(byte[] bArr, boolean z) {
        try {
            if (this.tempRandomAccessFile == null) {
                if (!this.tempFile.exists()) {
                    this.tempFile.createNewFile();
                }
                this.tempRandomAccessFile = new RandomAccessFile(this.tempFile, "rw");
            }
            if (this.tempBuffer == null) {
                this.tempBuffer = this.tempRandomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, (long) this.maxTempFileLength);
            }
            if (!(this.tempFile == null || this.tempBuffer == null)) {
                if (this.currentIndex + bArr.length > this.maxTempFileLength || z) {
                    this.tempBuffer.force();
                    try {
                        this.tempRandomAccessFile.close();
                    } catch (IOException e2) {
                    }
                    copyAppendTargetFile(this.tempFile, this.targetFile);
                    this.currentIndex = 4;
                    this.tempFile.delete();
                    this.tempFile.createNewFile();
                    this.tempRandomAccessFile = new RandomAccessFile(this.tempFile, "rw");
                    this.tempBuffer = this.tempRandomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, (long) this.maxTempFileLength);
                    this.tempBuffer.putInt(this.currentIndex - 4);
                }
                if (bArr.length >= 0) {
                    this.tempBuffer.position(this.currentIndex);
                    this.tempBuffer.put(bArr);
                    this.tempBuffer.position(0);
                    this.currentIndex += bArr.length;
                    this.tempBuffer.putInt(this.currentIndex - 4);
                }
            }
        } catch (Exception e3) {
            RecoveryLog.printErrStackTrace(TAG, e3, "appendToBuffer", new Object[0]);
        }
        return;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d A[SYNTHETIC, Splitter:B:27:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0052 A[SYNTHETIC, Splitter:B:30:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005d A[SYNTHETIC, Splitter:B:36:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0062 A[SYNTHETIC, Splitter:B:39:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void copyAppendTargetFile(java.io.File r9, java.io.File r10) {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.storage.MMappedFileStorage.copyAppendTargetFile(java.io.File, java.io.File):void");
    }
}
