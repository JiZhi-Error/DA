package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadVisitor implements Collectable, PerformanceTracer.Visitor {
    private HashMap<String, Long> prefInfos = new HashMap<>();

    public UploadVisitor() {
        AppMethodBeat.i(114177);
        AppMethodBeat.o(114177);
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.Visitor
    public void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> list, PerformanceTracer.OverallInfo overallInfo) {
        AppMethodBeat.i(114178);
        for (PerformanceTracer.SpeedCheck speedCheck : list) {
            this.prefInfos.put(speedCheck.getName() + ".ms", Long.valueOf(speedCheck.getTotalTimeMs()));
            this.prefInfos.put(speedCheck.getName() + ".bytes", Long.valueOf(speedCheck.getTotalBufferLength()));
        }
        AppMethodBeat.o(114178);
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.Collectable
    public void accept(PlayerInfoCollector playerInfoCollector) {
        AppMethodBeat.i(114179);
        if (!this.prefInfos.entrySet().isEmpty()) {
            for (Map.Entry<String, Long> entry : this.prefInfos.entrySet()) {
                playerInfoCollector.putLong(entry.getKey(), entry.getValue().longValue());
            }
        }
        AppMethodBeat.o(114179);
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.Collectable
    public void accept(ErrorUploadCollector errorUploadCollector) {
    }
}
