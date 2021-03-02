package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f {
    private static Map<String, Long> GsV = new HashMap();
    private static Map<String, Integer> GsW = new HashMap();
    private long GsQ;
    private double GsR = 0.35d;
    private double GsS = 3.0d;
    long GsT = 0;
    double GsU = 0.0d;
    public final String TAG = "Traf.TrafficModel";

    static {
        AppMethodBeat.i(123922);
        GsV.put(BuildConfig.COMMAND, 4194304L);
        GsV.put("Background", 5242880L);
        GsV.put("WebViewUI", 83886080L);
        GsV.put("WebviewMpUI", 83886080L);
        GsV.put("SnsTimeLineUI", 15728640L);
        GsV.put("SnsUserUI", 15728640L);
        GsV.put("AppBrandLaunchProxyUI", 12582912L);
        GsV.put("AppBrandUI", 20971520L);
        GsV.put("ChattingUI", 12582912L);
        GsV.put("SnsBrowseUI", 12582912L);
        GsV.put("SnsOnlineVideoActivity", 12582912L);
        GsV.put("EmojiStoreV2UI", 16777216L);
        GsV.put("EmojiStoreDetailUI", 16777216L);
        GsV.put("FTSSOSMoreWebViewUI", 12582912L);
        GsV.put("FTSWebViewUI", 12582912L);
        GsV.put("TopStoryHomeUI", 16777216L);
        GsV.put("TopStoryVideoStreamUI", 25165824L);
        GsV.put("GameDemoActivity1", 12582912L);
        GsV.put("ImageGalleryUI", 12582912L);
        GsV.put("SnsGalleryUI", 12582912L);
        GsV.put("VideoActivity", 16777216L);
        GsV.put("MultiTalkMainUI", 16777216L);
        GsV.put("FavoriteVideoPlayUI", 16777216L);
        GsV.put("AppAttachDownloadUI", 20971520L);
        GsV.put("LuggageGameWebViewUI", 20971520L);
        GsW.put("AppAttachDownloadUI", 2);
        GsW.put("SendImgProxyUI", 2);
        AppMethodBeat.o(123922);
    }

    public f() {
    }

    public f(long j2) {
        this.GsQ = j2;
    }

    public final boolean a(List<TrafficClickFlowReceiver.c> list, long j2, long j3, long j4) {
        int i2;
        AppMethodBeat.i(123920);
        Log.i("Traf.TrafficModel", "realInterval:%d", Long.valueOf(j4));
        if (j4 <= 5000) {
            AppMethodBeat.o(123920);
            return false;
        }
        if (j4 <= 300000) {
            i2 = 100;
        } else if (j4 > 300000 && j4 <= 600000) {
            i2 = 90;
        } else if (j4 <= 600000 || j4 > 1800000) {
            i2 = 50;
        } else {
            i2 = 60;
        }
        this.GsQ = ((((long) i2) * j4) * 1048576) / Util.MILLSECONDS_OF_MINUTE;
        this.GsT = 0;
        long j5 = 0;
        boolean z = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long min = Math.min(list.get(i3).endTime - list.get(i3).startTime, j3);
            j5 += min;
            String str = list.get(i3).GsN;
            if (str == null) {
                str = BuildConfig.COMMAND;
            }
            if (str.equals("AppAttachDownloadUI") && !z) {
                z = true;
            }
            str.equals("SendImgProxyUI");
            if (str.contains("_")) {
                str = str.substring(0, str.indexOf("_"));
            }
            if (GsV.containsKey(str)) {
                this.GsT = (long) ((((((double) min) / 1000.0d) / 60.0d) * ((double) GsV.get(str).longValue())) + ((double) this.GsT));
            } else {
                this.GsT = (long) ((((((double) min) / 1000.0d) / 60.0d) * 8388608.0d) + ((double) this.GsT));
            }
        }
        if (j5 < j3) {
            this.GsT += (((j3 - j5) / 1000) / 60) * 8388608;
        }
        this.GsT = Math.max(GsV.get(BuildConfig.COMMAND).longValue() * ((j3 / 1000) / 60), this.GsT);
        if (z) {
            this.GsT = ((long) GsW.get("AppAttachDownloadUI").intValue()) * this.GsT;
        }
        if (z) {
            this.GsT = ((long) GsW.get("SendImgProxyUI").intValue()) * this.GsT;
        }
        this.GsU = (((double) j2) / ((double) this.GsQ)) + ((((double) j2) / ((double) this.GsT)) * this.GsR);
        if (this.GsU < 0.0d) {
            this.GsU = 0.0d;
        }
        double d2 = this.GsU;
        Log.i("Traf.TrafficModel", "compute Traffic realTraffic:%d , standardTraffic:%d, predictionTraffic:%d, realInterval:%d", Long.valueOf(j2), Long.valueOf(this.GsQ), Long.valueOf(this.GsT), Long.valueOf(j4));
        if (d2 > this.GsS) {
            AppMethodBeat.o(123920);
            return true;
        }
        AppMethodBeat.o(123920);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(123921);
        String str = "TrafficModel{standardTraffic=" + this.GsQ + ", preciseRatio=" + this.GsR + ", threshold=" + this.GsS + '}';
        AppMethodBeat.o(123921);
        return str;
    }
}
