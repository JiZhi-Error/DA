package com.tencent.tav.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;

public final class ExportReportSession {
    private static final int FLUSH_DURATION_THRESHOLD = 10;
    private static final String TAG = "ExportReportSession";
    private long beginTimeMs = 0;
    private long compositeTimeUs = 0;
    private long exportStartTimeNs = 0;
    private long fileDurationUs = 0;
    private long framePerSecond = 0;
    private boolean success = false;
    private int successCount = 0;
    private long totalCostUs = 0;

    public final void setFileDurationUs(long j2) {
        this.fileDurationUs = j2;
    }

    public final void setFramePerSecond(int i2) {
        this.framePerSecond = (long) i2;
    }

    public final void onExportStart(long j2) {
        AppMethodBeat.i(218716);
        this.exportStartTimeNs = j2;
        this.beginTimeMs = System.currentTimeMillis();
        AppMethodBeat.o(218716);
    }

    public final void onExportSuccess() {
        AppMethodBeat.i(218717);
        if (this.exportStartTimeNs <= 0) {
            Logger.e(TAG, "onExportSuccess: 数据错误，exportStartTimeNs = " + this.exportStartTimeNs);
            AppMethodBeat.o(218717);
            return;
        }
        this.success = true;
        this.compositeTimeUs = (System.nanoTime() - this.exportStartTimeNs) / 1000;
        commit();
        AppMethodBeat.o(218717);
    }

    public final void onExportError() {
        AppMethodBeat.i(218718);
        this.success = false;
        commit();
        AppMethodBeat.o(218718);
    }

    public final void tickExport(long j2) {
        this.successCount++;
        this.totalCostUs += j2 / 1000;
    }

    private void commit() {
        AppMethodBeat.i(218719);
        if (this.beginTimeMs == 0 || this.exportStartTimeNs == 0) {
            Logger.e(TAG, "commit: 数据错误，beginTimeMs = " + this.beginTimeMs + "， exportStartTimeNs = " + this.exportStartTimeNs);
            AppMethodBeat.o(218719);
            return;
        }
        if (this.successCount >= 10) {
            doCommit();
        }
        reset();
        AppMethodBeat.o(218719);
    }

    private void doCommit() {
    }

    public final void reset() {
        AppMethodBeat.i(218720);
        Logger.d(TAG, "reset() called");
        this.compositeTimeUs = 0;
        this.success = false;
        this.totalCostUs = 0;
        this.successCount = 0;
        this.fileDurationUs = 0;
        this.framePerSecond = 0;
        AppMethodBeat.o(218720);
    }
}
