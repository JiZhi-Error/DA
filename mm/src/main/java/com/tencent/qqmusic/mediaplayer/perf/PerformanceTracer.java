package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PerformanceTracer {
    private IDataSource dataSource;
    private long lastTimeStampNanoSecond = 0;
    private long playStartTimestampNanoSec = 0;
    private final Map<String, SpeedCheck> speedMap = new LinkedHashMap();
    private long totalPcmInByte;
    private long totalTimeCostInNanoSec = 0;

    public interface Visitor {
        void visitSpeedCheck(List<SpeedCheck> list, OverallInfo overallInfo);
    }

    public PerformanceTracer() {
        AppMethodBeat.i(114186);
        AppMethodBeat.o(114186);
    }

    public void init(IDataSource iDataSource) {
        AppMethodBeat.i(114187);
        this.dataSource = iDataSource;
        this.lastTimeStampNanoSecond = 0;
        for (SpeedCheck speedCheck : this.speedMap.values()) {
            speedCheck.reset();
        }
        AppMethodBeat.o(114187);
    }

    public void playStart() {
        this.totalPcmInByte = 0;
    }

    public void playEnd() {
    }

    public void roundStart() {
        AppMethodBeat.i(114188);
        this.playStartTimestampNanoSec = System.nanoTime();
        AppMethodBeat.o(114188);
    }

    public void roundEnd(int i2) {
        AppMethodBeat.i(114189);
        this.totalPcmInByte += (long) i2;
        this.totalTimeCostInNanoSec += System.nanoTime() - this.playStartTimestampNanoSec;
        AppMethodBeat.o(114189);
    }

    public void start(String str) {
        AppMethodBeat.i(114190);
        getSpeedCheck(str);
        this.lastTimeStampNanoSecond = System.nanoTime();
        AppMethodBeat.o(114190);
    }

    public void end(String str, int i2) {
        AppMethodBeat.i(114191);
        SpeedCheck.access$000(getSpeedCheck(str), i2, System.nanoTime() - this.lastTimeStampNanoSecond);
        AppMethodBeat.o(114191);
    }

    public void accept(Visitor visitor) {
        AppMethodBeat.i(114192);
        ArrayList<SpeedCheck> arrayList = new ArrayList(this.speedMap.values());
        for (SpeedCheck speedCheck : arrayList) {
            SpeedCheck.access$100(speedCheck);
        }
        visitor.visitSpeedCheck(arrayList, new OverallInfo(this.dataSource, Math.round(((double) this.totalTimeCostInNanoSec) / 1000000.0d), this.totalPcmInByte));
        AppMethodBeat.o(114192);
    }

    private SpeedCheck getSpeedCheck(String str) {
        AppMethodBeat.i(114193);
        SpeedCheck speedCheck = this.speedMap.get(str);
        if (speedCheck != null) {
            AppMethodBeat.o(114193);
            return speedCheck;
        }
        SpeedCheck speedCheck2 = new SpeedCheck(str);
        this.speedMap.put(str, speedCheck2);
        AppMethodBeat.o(114193);
        return speedCheck2;
    }

    static class BufferSizeCheck {
        private int lastSize = 0;
        private int maxMismatch = 0;
        private final String name;
        private int sizeMismatchCount = 0;

        public BufferSizeCheck(String str) {
            this.name = str;
        }

        /* access modifiers changed from: package-private */
        public void onStart(int i2) {
            this.lastSize = i2;
        }

        /* access modifiers changed from: package-private */
        public void onEnd(int i2) {
            AppMethodBeat.i(114197);
            if (i2 != this.lastSize) {
                int i3 = this.lastSize - i2;
                if (Math.abs(i3) > this.maxMismatch) {
                    this.maxMismatch = i3;
                }
                this.sizeMismatchCount++;
            }
            AppMethodBeat.o(114197);
        }

        public int getMaxMismatch() {
            return this.maxMismatch;
        }

        public String getName() {
            return this.name;
        }

        public int getSizeMismatchCount() {
            return this.sizeMismatchCount;
        }
    }

    static class OverallInfo {
        final IDataSource dataSource;
        final long timeCostInMs;
        final long totalPcmToBePlayed;

        OverallInfo(IDataSource iDataSource, long j2, long j3) {
            this.dataSource = iDataSource;
            this.timeCostInMs = j2;
            this.totalPcmToBePlayed = j3;
        }
    }

    /* access modifiers changed from: package-private */
    public static class SpeedCheck {

        /* renamed from: f  reason: collision with root package name */
        private static final double f1559f = 1000000.0d;
        private double avg;
        private double max;
        private double min;
        private final String name;
        private long totalBufferLength;
        private long totalTimeNanoSecond;

        static /* synthetic */ void access$000(SpeedCheck speedCheck, int i2, long j2) {
            AppMethodBeat.i(114182);
            speedCheck.update(i2, j2);
            AppMethodBeat.o(114182);
        }

        static /* synthetic */ void access$100(SpeedCheck speedCheck) {
            AppMethodBeat.i(114183);
            speedCheck.compute();
            AppMethodBeat.o(114183);
        }

        public String getName() {
            return this.name;
        }

        public double getAvg() {
            return this.avg;
        }

        public double getMax() {
            return this.max;
        }

        public double getMin() {
            return this.min;
        }

        public long getTotalTimeMs() {
            AppMethodBeat.i(114180);
            long round = Math.round(((double) this.totalTimeNanoSecond) / f1559f);
            AppMethodBeat.o(114180);
            return round;
        }

        public long getTotalBufferLength() {
            return this.totalBufferLength;
        }

        private SpeedCheck(String str) {
            this.name = str;
        }

        private void update(int i2, long j2) {
            this.totalBufferLength += (long) i2;
            this.totalTimeNanoSecond += j2;
            double d2 = (((double) i2) * f1559f) / ((double) j2);
            if (d2 > this.max || this.max == 0.0d) {
                this.max = d2;
            } else if (d2 < this.min || this.min == 0.0d) {
                this.min = d2;
            }
        }

        private void compute() {
            this.avg = (((double) this.totalBufferLength) * f1559f) / ((double) this.totalTimeNanoSecond);
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.avg = 0.0d;
            this.max = 0.0d;
            this.min = 0.0d;
            this.totalTimeNanoSecond = 0;
            this.totalBufferLength = 0;
        }

        public String toString() {
            AppMethodBeat.i(114181);
            compute();
            String format = String.format(Locale.getDefault(), "%10s%15.2f%15.2f%15.2f%10d%15d", this.name, Double.valueOf(this.avg), Double.valueOf(this.max), Double.valueOf(this.min), Long.valueOf(this.totalTimeNanoSecond), Long.valueOf(this.totalBufferLength));
            AppMethodBeat.o(114181);
            return format;
        }
    }
}
