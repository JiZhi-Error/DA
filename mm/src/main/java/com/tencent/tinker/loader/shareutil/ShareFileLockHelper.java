package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class ShareFileLockHelper implements Closeable {
    public static final int LOCK_WAIT_EACH_TIME = 10;
    public static final int MAX_LOCK_ATTEMPTS = 3;
    private static final String TAG = "Tinker.FileLockHelper";
    private final FileLock fileLock;
    private final FileOutputStream outputStream;

    private ShareFileLockHelper(File file) {
        FileLock fileLock2;
        this.outputStream = new FileOutputStream(file);
        Exception exc = null;
        FileLock fileLock3 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                fileLock2 = fileLock3;
                break;
            }
            i2++;
            try {
                fileLock2 = this.outputStream.getChannel().lock();
                if (fileLock2 != null) {
                    break;
                }
                fileLock3 = fileLock2;
                try {
                    Thread.sleep(10);
                } catch (Exception e2) {
                    ShareTinkerLog.e(TAG, "getInfoLock Thread sleep exception", e2);
                }
            } catch (Exception e3) {
                ShareTinkerLog.e(TAG, "getInfoLock Thread failed time:10", new Object[0]);
                exc = e3;
            }
        }
        if (fileLock2 == null) {
            throw new IOException("Tinker Exception:FileLockHelper lock file failed: " + file.getAbsolutePath(), exc);
        }
        this.fileLock = fileLock2;
    }

    public static ShareFileLockHelper getFileLock(File file) {
        return new ShareFileLockHelper(file);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.fileLock != null) {
                this.fileLock.release();
            }
        } finally {
            if (this.outputStream != null) {
                this.outputStream.close();
            }
        }
    }
}
