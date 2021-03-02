package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class g {
    private static volatile g gCT = null;
    private static boolean gCV = false;
    private static boolean gCW = false;
    private static boolean gCX = false;
    private static boolean gCY = false;
    private static int gDa = 0;
    private static int gDb = 0;
    private static HashMap<Integer, String> gDc = new HashMap<>();
    private static int gDd = 0;
    private static int gDe = 0;
    private static HashMap<Integer, String> gDf = new HashMap<>();
    private static int gDg = 0;
    private static int gDh = 0;
    private static HashMap<Integer, String> gDi = new HashMap<>();
    private int gCU = -1;
    private int gCZ = 0;

    static {
        AppMethodBeat.i(155610);
        AppMethodBeat.o(155610);
    }

    public static g anF() {
        AppMethodBeat.i(155571);
        if (gCT == null) {
            synchronized (g.class) {
                try {
                    if (gCT == null) {
                        MMApplicationContext.getContext();
                        gCT = new g();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(155571);
                    throw th;
                }
            }
        }
        g gVar = gCT;
        AppMethodBeat.o(155571);
        return gVar;
    }

    public static boolean anG() {
        return false;
    }

    public static void oo(int i2) {
        AppMethodBeat.i(155602);
        gDa++;
        Log.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i2), Integer.valueOf(gDa), Integer.valueOf(gDb));
        gDc.put(Integer.valueOf(i2), Util.getStack().toString());
        anH();
        AppMethodBeat.o(155602);
    }

    public static void op(int i2) {
        AppMethodBeat.i(155603);
        gDb++;
        Log.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i2), Integer.valueOf(gDa), Integer.valueOf(gDb));
        gDc.remove(Integer.valueOf(i2));
        AppMethodBeat.o(155603);
    }

    public static void oq(int i2) {
        AppMethodBeat.i(155604);
        gDd++;
        Log.printInfoStack("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i2), Integer.valueOf(gDd), Integer.valueOf(gDe));
        gDf.put(Integer.valueOf(i2), Util.getStack().toString());
        anH();
        AppMethodBeat.o(155604);
    }

    public static void or(int i2) {
        AppMethodBeat.i(155605);
        if (gDf.containsKey(Integer.valueOf(i2))) {
            gDe++;
            Log.printInfoStack("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i2), Integer.valueOf(gDd), Integer.valueOf(gDe));
            gDf.remove(Integer.valueOf(i2));
        }
        AppMethodBeat.o(155605);
    }

    public static void os(int i2) {
        AppMethodBeat.i(155606);
        gDg++;
        Log.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i2), Integer.valueOf(gDg), Integer.valueOf(gDh));
        gDi.put(Integer.valueOf(i2), Util.getStack().toString());
        anH();
        AppMethodBeat.o(155606);
    }

    public static void ot(int i2) {
        AppMethodBeat.i(155607);
        gDh++;
        Log.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i2), Integer.valueOf(gDg), Integer.valueOf(gDh));
        gDi.remove(Integer.valueOf(i2));
        AppMethodBeat.o(155607);
    }

    private static void anH() {
        AppMethodBeat.i(155608);
        ml mlVar = new ml();
        if (gDa - gDb > 1) {
            mlVar.dRT.dRU = true;
            mlVar.dRT.dRV = gDc.size();
        }
        if (gDg - gDh > 1) {
            mlVar.dRT.dRW = true;
            mlVar.dRT.dRX = gDi.size();
        }
        if (gDd - gDe > 1) {
            mlVar.dRT.dRY = true;
            mlVar.dRT.dRZ = gDf.size();
        }
        if (mlVar.dRT.dRW || mlVar.dRT.dRU || mlVar.dRT.dRY) {
            Log.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", Boolean.valueOf(mlVar.dRT.dRU), Integer.valueOf(mlVar.dRT.dRV), Boolean.valueOf(mlVar.dRT.dRW), Integer.valueOf(mlVar.dRT.dRX), Boolean.valueOf(mlVar.dRT.dRY), Integer.valueOf(mlVar.dRT.dRZ));
            EventCenter.instance.publish(mlVar);
        }
        AppMethodBeat.o(155608);
    }

    public static String anI() {
        AppMethodBeat.i(155609);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AudioTrack: \r\n");
        stringBuffer.append("leak: ").append(gDc.size()).append("init: ").append(gDa).append("release: ").append(gDb).append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gDc.isEmpty()) {
            for (String str : gDc.values()) {
                stringBuffer.append(str).append(APLogFileUtil.SEPARATOR_LINE);
            }
        }
        stringBuffer.append("MediaPlayer: \r\n");
        stringBuffer.append("leak: ").append(gDi.size()).append("init: ").append(gDg).append("release: ").append(gDh).append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gDi.isEmpty()) {
            for (String str2 : gDi.values()) {
                stringBuffer.append(str2).append(APLogFileUtil.SEPARATOR_LINE);
            }
        }
        stringBuffer.append("AudioRecord: \r\n");
        stringBuffer.append("leak: ").append(gDf.size()).append("init: ").append(gDd).append("release: ").append(gDd).append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gDf.isEmpty()) {
            for (String str3 : gDf.values()) {
                stringBuffer.append(str3).append(APLogFileUtil.SEPARATOR_LINE);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        Log.e("MicroMsg.MMAudioManager", "leak? %s", stringBuffer2);
        AppMethodBeat.o(155609);
        return stringBuffer2;
    }
}
