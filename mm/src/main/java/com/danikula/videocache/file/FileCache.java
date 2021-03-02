package com.danikula.videocache.file;

import com.danikula.videocache.Cache;
import com.danikula.videocache.ProxyCacheException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileCache implements Cache {
    private static final String TEMP_POSTFIX = ".download";
    private RandomAccessFile dataFile;
    private final DiskUsage diskUsage;
    public File file;

    public FileCache(File file2) {
        this(file2, new UnlimitedDiskUsage());
        AppMethodBeat.i(223203);
        AppMethodBeat.o(223203);
    }

    public FileCache(File file2, DiskUsage diskUsage2) {
        AppMethodBeat.i(183618);
        if (diskUsage2 == null) {
            try {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.o(183618);
                throw nullPointerException;
            } catch (IOException e2) {
                ProxyCacheException proxyCacheException = new ProxyCacheException("Error using file " + file2 + " as disc cache", e2);
                AppMethodBeat.o(183618);
                throw proxyCacheException;
            }
        } else {
            this.diskUsage = diskUsage2;
            Files.makeDir(file2.getParentFile());
            boolean exists = file2.exists();
            this.file = exists ? file2 : new File(file2.getParentFile(), file2.getName() + TEMP_POSTFIX);
            this.dataFile = new RandomAccessFile(this.file, exists ? "r" : "rw");
            AppMethodBeat.o(183618);
        }
    }

    @Override // com.danikula.videocache.Cache
    public synchronized long available() {
        long length;
        AppMethodBeat.i(183619);
        try {
            length = (long) ((int) this.dataFile.length());
            AppMethodBeat.o(183619);
        } catch (IOException e2) {
            ProxyCacheException proxyCacheException = new ProxyCacheException("Error reading length of file " + this.file, e2);
            AppMethodBeat.o(183619);
            throw proxyCacheException;
        }
        return length;
    }

    @Override // com.danikula.videocache.Cache
    public synchronized int read(byte[] bArr, long j2, int i2) {
        int read;
        AppMethodBeat.i(223204);
        try {
            this.dataFile.seek(j2);
            read = this.dataFile.read(bArr, 0, i2);
            AppMethodBeat.o(223204);
        } catch (IOException e2) {
            ProxyCacheException proxyCacheException = new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(available()), Integer.valueOf(bArr.length)), e2);
            AppMethodBeat.o(223204);
            throw proxyCacheException;
        }
        return read;
    }

    @Override // com.danikula.videocache.Cache
    public synchronized void append(byte[] bArr, int i2) {
        AppMethodBeat.i(183621);
        try {
            if (isCompleted()) {
                ProxyCacheException proxyCacheException = new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
                AppMethodBeat.o(183621);
                throw proxyCacheException;
            }
            this.dataFile.seek(available());
            this.dataFile.write(bArr, 0, i2);
            AppMethodBeat.o(183621);
        } catch (IOException e2) {
            ProxyCacheException proxyCacheException2 = new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.dataFile, Integer.valueOf(bArr.length)), e2);
            AppMethodBeat.o(183621);
            throw proxyCacheException2;
        }
    }

    @Override // com.danikula.videocache.Cache
    public synchronized void close() {
        AppMethodBeat.i(183622);
        try {
            this.dataFile.close();
            this.diskUsage.touch(this.file);
            AppMethodBeat.o(183622);
        } catch (IOException e2) {
            ProxyCacheException proxyCacheException = new ProxyCacheException("Error closing file " + this.file, e2);
            AppMethodBeat.o(183622);
            throw proxyCacheException;
        }
    }

    @Override // com.danikula.videocache.Cache
    public synchronized void complete() {
        AppMethodBeat.i(183623);
        if (isCompleted()) {
            AppMethodBeat.o(183623);
        } else {
            close();
            File file2 = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
            if (!this.file.renameTo(file2)) {
                ProxyCacheException proxyCacheException = new ProxyCacheException("Error renaming file " + this.file + " to " + file2 + " for completion!");
                AppMethodBeat.o(183623);
                throw proxyCacheException;
            }
            this.file = file2;
            try {
                this.dataFile = new RandomAccessFile(this.file, "r");
                this.diskUsage.touch(this.file);
                AppMethodBeat.o(183623);
            } catch (IOException e2) {
                ProxyCacheException proxyCacheException2 = new ProxyCacheException("Error opening " + this.file + " as disc cache", e2);
                AppMethodBeat.o(183623);
                throw proxyCacheException2;
            }
        }
    }

    @Override // com.danikula.videocache.Cache
    public synchronized boolean isCompleted() {
        boolean z;
        AppMethodBeat.i(183624);
        if (!isTempFile(this.file)) {
            z = true;
            AppMethodBeat.o(183624);
        } else {
            z = false;
            AppMethodBeat.o(183624);
        }
        return z;
    }

    public File getFile() {
        return this.file;
    }

    private boolean isTempFile(File file2) {
        AppMethodBeat.i(223205);
        boolean endsWith = file2.getName().endsWith(TEMP_POSTFIX);
        AppMethodBeat.o(223205);
        return endsWith;
    }
}
