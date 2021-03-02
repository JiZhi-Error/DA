package com.tencent.tavkit.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.report.FilterChainReportSession;
import java.util.HashMap;
import java.util.Map;

public final class CompositingReportSession {
    private static final int FLUSH_DURATION_THRESHOLD = 10;
    private static final String REPORT_EVENT = "android_tavkit_compositing";
    public static final String REPORT_KEY_AVG_RENDER_TIME_US = "avg_render_time_us";
    private static final String REPORT_SERVICE = "TAVKit_Android";
    private static final String REPORT_VERSION = "1.3.5.6";
    private static final String TAG = "CompositingReportSessio";
    private static IReporter reporter;
    private long beginTimeMs = 0;
    private int failureCount = 0;
    private final FilterChainReporter filterChainReporter;
    private float renderHeight;
    private float renderWidth;
    private int successCount = 0;
    private long totalCostUs = 0;

    public interface IReporter {
        void onCommit(Map<String, Long> map, Map<String, Long> map2);
    }

    public static synchronized void setReporter(IReporter iReporter) {
        synchronized (CompositingReportSession.class) {
            reporter = iReporter;
        }
    }

    public CompositingReportSession(float f2, float f3) {
        AppMethodBeat.i(197638);
        this.renderWidth = f2;
        this.renderHeight = f3;
        this.filterChainReporter = new FilterChainReporter();
        FilterChainReportSession.setReporter(this.filterChainReporter);
        AppMethodBeat.o(197638);
    }

    public final void flush() {
        AppMethodBeat.i(197639);
        if (this.beginTimeMs == 0) {
            AppMethodBeat.o(197639);
            return;
        }
        if (this.successCount >= 10) {
            commit();
        }
        reset();
        AppMethodBeat.o(197639);
    }

    public final void tickSuccess(long j2) {
        AppMethodBeat.i(197640);
        if (this.beginTimeMs == 0) {
            this.beginTimeMs = System.currentTimeMillis() - ((j2 / 1000) / 1000);
        }
        this.successCount++;
        this.totalCostUs += j2 / 1000;
        AppMethodBeat.o(197640);
    }

    public final void tickFailed() {
        this.failureCount++;
    }

    private void commit() {
    }

    private void reset() {
        this.beginTimeMs = 0;
        this.totalCostUs = 0;
        this.successCount = 0;
    }

    static class FilterChainReporter implements FilterChainReportSession.IReporter {
        private Map<String, Long> values;

        private FilterChainReporter() {
            AppMethodBeat.i(197636);
            this.values = new HashMap();
            AppMethodBeat.o(197636);
        }

        @Override // com.tencent.tavkit.report.FilterChainReportSession.IReporter
        public void onCommit(Map<String, Long> map) {
            AppMethodBeat.i(197637);
            map.putAll(map);
            AppMethodBeat.o(197637);
        }
    }
}
