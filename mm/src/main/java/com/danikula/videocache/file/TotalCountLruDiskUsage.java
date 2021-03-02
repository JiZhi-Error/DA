package com.danikula.videocache.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TotalCountLruDiskUsage extends LruDiskUsage {
    private final int maxCount;

    public TotalCountLruDiskUsage(int i2) {
        AppMethodBeat.i(223214);
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Max count must be positive number!");
            AppMethodBeat.o(223214);
            throw illegalArgumentException;
        }
        this.maxCount = i2;
        AppMethodBeat.o(223214);
    }

    /* access modifiers changed from: protected */
    @Override // com.danikula.videocache.file.LruDiskUsage
    public boolean accept(File file, long j2, int i2) {
        return i2 <= this.maxCount;
    }
}
