package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Reporters {
    static /* synthetic */ void access$000(List list, StringBuilder sb, long j2) {
        AppMethodBeat.i(114200);
        generateDetailedPerformance(list, sb, j2);
        AppMethodBeat.o(114200);
    }

    public static PerformanceTracer.Visitor detail(final AudioInformation audioInformation, final Map<String, String> map) {
        AppMethodBeat.i(114198);
        AnonymousClass1 r0 = new PerformanceTracer.Visitor() {
            /* class com.tencent.qqmusic.mediaplayer.perf.Reporters.AnonymousClass1 */

            @Override // com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.Visitor
            public final void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> list, PerformanceTracer.OverallInfo overallInfo) {
                int i2 = 1;
                AppMethodBeat.i(114194);
                long round = Math.round(((double) overallInfo.totalPcmToBePlayed) / ((double) overallInfo.timeCostInMs));
                long playSample = audioInformation.getPlaySample() * ((long) audioInformation.getChannels());
                if (audioInformation.getBitDepth() != 1) {
                    i2 = 2;
                }
                double d2 = ((double) (((long) i2) * playSample)) / 1000.0d;
                StringBuilder sb = new StringBuilder("\n============== Info start ==============\n");
                sb.append("媒体文件信息:\n");
                sb.append("\t播放时间: ").append(new Date().toString()).append("\n");
                sb.append("\t音频类型: ").append(audioInformation.getAudioType().toString()).append("\n");
                sb.append("\t文件采样率: ").append(audioInformation.getSampleRate()).append("\n");
                sb.append("\t播放采样率: ").append(audioInformation.getPlaySample()).append("\n");
                sb.append("\t位深: ").append(audioInformation.getBitDepth()).append("\n");
                sb.append("\t声道数: ").append(audioInformation.getChannels()).append("\n");
                sb.append("\t时长: ").append(audioInformation.getDuration()).append("\n");
                sb.append("\n整体性能\n");
                sb.append("\t总耗时 (ms): ").append(overallInfo.timeCostInMs).append("\n");
                sb.append("\t播放PCM数据量 (byte): ").append(overallInfo.totalPcmToBePlayed).append("\n");
                sb.append("\t总速度 (byte/ms): ").append(round).append(" (").append(Math.round(((double) round) / d2)).append(" 倍于最低要求速度)\n");
                sb.append("\t最低要求速度 (byte/ms): ").append(d2).append("\n");
                sb.append("\n额外信息:");
                for (Map.Entry entry : map.entrySet()) {
                    sb.append("\n\t").append((String) entry.getKey()).append(": ").append((String) entry.getValue());
                }
                sb.append("\n");
                Reporters.access$000(list, sb, overallInfo.timeCostInMs);
                sb.append("============== Info end ==============");
                Logger.i("PERFORMANCE", sb.toString());
                AppMethodBeat.o(114194);
            }
        };
        AppMethodBeat.o(114198);
        return r0;
    }

    private static void generateDetailedPerformance(List<PerformanceTracer.SpeedCheck> list, StringBuilder sb, long j2) {
        AppMethodBeat.i(114199);
        sb.append("\n详细性能数据:\n");
        sb.append(String.format(Locale.getDefault(), "\t%15s%15s%15s%15s%15s", "名称", "平均速度(byte/ms)", "耗时(ms)", "数据量(byte)", "占总耗时比"));
        for (PerformanceTracer.SpeedCheck speedCheck : list) {
            sb.append("\n");
            sb.append(String.format(Locale.getDefault(), "\t%15s%15.0f%15d%15d%13.2f", speedCheck.getName(), Double.valueOf(speedCheck.getAvg()), Long.valueOf(speedCheck.getTotalTimeMs()), Long.valueOf(speedCheck.getTotalBufferLength()), Double.valueOf(((double) speedCheck.getTotalTimeMs()) / ((double) j2))));
        }
        sb.append("\n");
        AppMethodBeat.o(114199);
    }
}
