package org.libpag;

public class PAGVideoRange {
    public long endTime = 0;
    public long playDuration = 0;
    public boolean reversed = false;
    public long startTime = 0;

    public PAGVideoRange(long j2, long j3, long j4, boolean z) {
        this.startTime = j2;
        this.endTime = j3;
        this.playDuration = j4;
        this.reversed = z;
    }
}
