package com.tencent.tav.report;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PreviewReportSession {
    private static final int FLUSH_DURATION_THRESHOLD = 10;
    private static final String TAG = "PreviewReportSession";
    private long beginTimeMs = 0;
    private int frameCount = 0;
    private long totalReadCostUs = 0;
    private long totalRenderCount = 0;

    public final void flush() {
        AppMethodBeat.i(218721);
        if (this.beginTimeMs == 0) {
            AppMethodBeat.o(218721);
            return;
        }
        if (this.frameCount >= 10) {
            commit();
        }
        reset();
        AppMethodBeat.o(218721);
    }

    public final void tickPreview(long j2, long j3) {
        AppMethodBeat.i(218722);
        if (this.beginTimeMs == 0) {
            this.beginTimeMs = System.currentTimeMillis() - ((j2 / 1000) / 1000);
        }
        this.frameCount++;
        this.totalReadCostUs += j2 / 1000;
        this.totalRenderCount += j3 / 1000;
        AppMethodBeat.o(218722);
    }

    private void commit() {
    }

    private void reset() {
        this.beginTimeMs = 0;
        this.totalReadCostUs = 0;
        this.totalRenderCount = 0;
        this.frameCount = 0;
    }
}
