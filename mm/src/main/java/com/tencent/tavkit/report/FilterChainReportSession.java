package com.tencent.tavkit.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class FilterChainReportSession {
    private static IReporter reporter;
    private Map<String, TimeConsumer> timeConsumerMap = new HashMap();

    public interface IReporter {
        void onCommit(Map<String, Long> map);
    }

    public FilterChainReportSession() {
        AppMethodBeat.i(197643);
        AppMethodBeat.o(197643);
    }

    public static synchronized void setReporter(IReporter iReporter) {
        synchronized (FilterChainReportSession.class) {
            reporter = iReporter;
        }
    }

    public void tick(String str, long j2) {
        AppMethodBeat.i(197644);
        TimeConsumer timeConsumer = this.timeConsumerMap.get(str);
        if (timeConsumer == null) {
            timeConsumer = new TimeConsumer(str);
            this.timeConsumerMap.put(timeConsumer.key, timeConsumer);
        }
        TimeConsumer.access$100(timeConsumer, j2 / 1000);
        AppMethodBeat.o(197644);
    }

    public void commit() {
        AppMethodBeat.i(197645);
        HashMap hashMap = new HashMap();
        for (TimeConsumer timeConsumer : this.timeConsumerMap.values()) {
            if (timeConsumer != null) {
                hashMap.put(timeConsumer.key, Long.valueOf(TimeConsumer.access$200(timeConsumer)));
            }
        }
        synchronized (FilterChainReportSession.class) {
            try {
                if (reporter != null) {
                    reporter.onCommit(hashMap);
                }
            } finally {
                AppMethodBeat.o(197645);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class TimeConsumer {
        private long count = 0;
        private final String key;
        private long totalUs = 0;

        static /* synthetic */ void access$100(TimeConsumer timeConsumer, long j2) {
            AppMethodBeat.i(197641);
            timeConsumer.tick(j2);
            AppMethodBeat.o(197641);
        }

        static /* synthetic */ long access$200(TimeConsumer timeConsumer) {
            AppMethodBeat.i(197642);
            long avgTimeUs = timeConsumer.getAvgTimeUs();
            AppMethodBeat.o(197642);
            return avgTimeUs;
        }

        public TimeConsumer(String str) {
            this.key = str;
        }

        private void tick(long j2) {
            this.totalUs += j2;
            this.count++;
        }

        private long getAvgTimeUs() {
            if (this.count == 0) {
                return 0;
            }
            return this.totalUs / this.count;
        }
    }
}
