package com.danikula.videocache.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TotalSizeLruDiskUsage extends LruDiskUsage {
    private final long maxSize;

    public TotalSizeLruDiskUsage(long j2) {
        AppMethodBeat.i(183628);
        if (j2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Max size must be positive number!");
            AppMethodBeat.o(183628);
            throw illegalArgumentException;
        }
        this.maxSize = j2;
        AppMethodBeat.o(183628);
    }

    /* access modifiers changed from: protected */
    @Override // com.danikula.videocache.file.LruDiskUsage
    public boolean accept(File file, long j2, int i2) {
        return j2 <= this.maxSize;
    }
}
