package com.danikula.videocache.file;

import com.danikula.videocache.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class LruDiskUsage implements DiskUsage {
    private final ExecutorService workerThread = Executors.newSingleThreadExecutor();

    /* access modifiers changed from: protected */
    public abstract boolean accept(File file, long j2, int i2);

    @Override // com.danikula.videocache.file.DiskUsage
    public void touch(File file) {
        this.workerThread.submit(new TouchCallable(file));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void touchInBackground(File file) {
        Files.setLastModifiedNow(file);
        trim(Files.getLruListFiles(file.getParentFile()));
    }

    private void trim(List<File> list) {
        long countTotalSize = countTotalSize(list);
        int size = list.size();
        int i2 = size;
        for (File file : list) {
            if (!accept(file, countTotalSize, i2)) {
                long length = file.length();
                if (file.delete()) {
                    i2--;
                    countTotalSize -= length;
                    Logger.info("Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    Logger.error("Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private long countTotalSize(List<File> list) {
        long j2 = 0;
        for (File file : list) {
            j2 = file.length() + j2;
        }
        return j2;
    }

    class TouchCallable implements Callable<Void> {
        private final File file;

        public TouchCallable(File file2) {
            this.file = file2;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            AppMethodBeat.i(223212);
            LruDiskUsage.this.touchInBackground(this.file);
            AppMethodBeat.o(223212);
            return null;
        }
    }
}
