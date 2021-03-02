package com.tencent.mm.plugin.mmsight.model;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class l {
    public static void ejJ() {
        AppMethodBeat.i(89431);
        Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
        h.INSTANCE.idkeyStat(440, 0, 1, false);
        int i2 = 36;
        if (k.zuy != null) {
            if (k.zuy.gIP == 1) {
                i2 = 39;
            }
            if (k.zuy.ilT == 720) {
                i2++;
            } else if (k.zuy.ejS()) {
                i2 += 2;
            }
            h.INSTANCE.idkeyStat(440, (long) i2, 1, false);
        }
        AppMethodBeat.o(89431);
    }

    public static void aNB() {
        AppMethodBeat.i(89432);
        Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
        h.INSTANCE.idkeyStat(440, 2, 1, false);
        AppMethodBeat.o(89432);
    }

    public static void ejK() {
        AppMethodBeat.i(89433);
        Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
        h.INSTANCE.idkeyStat(440, 7, 1, false);
        AppMethodBeat.o(89433);
    }

    public static void ejL() {
        AppMethodBeat.i(89434);
        Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
        h.INSTANCE.idkeyStat(440, 8, 1, false);
        AppMethodBeat.o(89434);
    }

    public static void aNJ() {
        AppMethodBeat.i(89435);
        Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
        h.INSTANCE.idkeyStat(440, 16, 1, false);
        AppMethodBeat.o(89435);
    }

    public static void aNK() {
        AppMethodBeat.i(89436);
        Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
        h.INSTANCE.idkeyStat(440, 21, 1, false);
        AppMethodBeat.o(89436);
    }

    public static void ejM() {
        AppMethodBeat.i(89437);
        Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
        h.INSTANCE.idkeyStat(440, 31, 1, false);
        AppMethodBeat.o(89437);
    }

    public static void au(String str, int i2, int i3) {
        AppMethodBeat.i(89438);
        try {
            if (k.zuy != null) {
                int optInt = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(str)).optInt("videoBitrate");
                if (i3 == 1) {
                    if (i2 == 1) {
                        h.INSTANCE.idkeyStat(440, 189, (long) optInt, false);
                        h.INSTANCE.idkeyStat(440, 190, 1, false);
                        AppMethodBeat.o(89438);
                        return;
                    }
                    h.INSTANCE.idkeyStat(440, 184, (long) optInt, false);
                    h.INSTANCE.idkeyStat(440, 185, 1, false);
                    AppMethodBeat.o(89438);
                    return;
                } else if (i3 == 2) {
                    if (i2 == 1) {
                        h.INSTANCE.idkeyStat(440, 194, (long) optInt, false);
                        h.INSTANCE.idkeyStat(440, 195, 1, false);
                        AppMethodBeat.o(89438);
                        return;
                    }
                    h.INSTANCE.idkeyStat(440, 199, (long) optInt, false);
                    h.INSTANCE.idkeyStat(440, 200, 1, false);
                }
            }
            AppMethodBeat.o(89438);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", e2.getMessage());
            AppMethodBeat.o(89438);
        }
    }

    public static void h(boolean z, long j2) {
        int i2;
        AppMethodBeat.i(89439);
        Log.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", Boolean.valueOf(z), Long.valueOf(j2));
        b.ejt().ztB = j2;
        b ejt = b.ejt();
        m mVar = new m();
        m mVar2 = new m();
        mVar.m("model", ejt.model + ",");
        mVar.m("apiLevel", ejt.ztd + ",");
        mVar.m("memoryClass", ejt.jtg + ",");
        mVar.m("totalMemory", ejt.ipW + ",");
        mVar.m("maxCpu", ejt.zte + ",");
        mVar.m("screenW", ejt.ztf + ",");
        mVar.m("screenH", ejt.ztg + ",");
        mVar2.m("model", ejt.model + ",");
        mVar2.m("apiLevel", ejt.ztd + ",");
        mVar2.m("memoryClass", ejt.jtg + ",");
        mVar2.m("totalMemory", ejt.ipW + ",");
        mVar2.m("maxCpu", ejt.zte + ",");
        mVar2.m("screenW", ejt.ztf + ",");
        mVar2.m("screenH", ejt.ztg + ",");
        mVar.m("cropx", ejt.ztl + ",");
        mVar.m("cropy", ejt.ztm + ",");
        mVar.m("previewx", ejt.ztn + ",");
        mVar.m("previewy", ejt.zto + ",");
        mVar.m("encoderx", ejt.ztp + ",");
        mVar.m("encodery", ejt.ztq + ",");
        mVar.m(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, ejt.dYT + ",");
        mVar.m("deviceoutfps", ejt.ztr + ",");
        mVar.m("recordfps", ejt.zts + ",");
        mVar.m("recordertype", ejt.ztt + ",");
        mVar.m("videoBitrate", ejt.videoBitrate + ",");
        mVar.m("needRotateEachFrame", ejt.gIQ + ",");
        mVar.m("isNeedRealtimeScale", ejt.ztu + ",");
        mVar.m("resolutionLimit", ejt.ilT + ",");
        mVar.m("outfps", ejt.ztv + ",");
        mVar.m("recordTime", ejt.ztw + ",");
        mVar.m("avgcpu", ejt.ztx + ",");
        mVar.m("outx", ejt.zty + ",");
        mVar.m("outy", ejt.ztz + ",");
        mVar.m("outbitrate", ejt.ztA + ",");
        mVar.m("fileSize", ejt.fileSize + ",");
        mVar.m("wait2playtime", ejt.ztB + ",");
        mVar.m("useback", ejt.ztC + ",");
        int i3 = 0;
        int i4 = 0;
        Intent registerReceiver = MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            i2 = (intExtra == 2 || intExtra == 5) ? 1 : 0;
            i3 = registerReceiver.getIntExtra("level", -1);
            i4 = registerReceiver.getIntExtra("scale", -1);
        } else {
            i2 = 0;
        }
        Log.i("MicroMsg.CaptureStatistics", "battery %s %s %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        mVar.m("mIsCharging", i2 + ",");
        mVar.m("level", i3 + ",");
        mVar.m("scale", i4 + ",");
        mVar.m("createTime", System.currentTimeMillis() + ",");
        mVar2.m("prewViewlist1", ejt.zth + ",");
        mVar2.m("pictureSize1", ejt.zti + ",");
        mVar2.m("prewViewlist2", ejt.ztj + ",");
        mVar2.m("pictureSize2", ejt.ztk + ",");
        Log.i("MicroMsg.CaptureStatistics", "report " + mVar.abW());
        Log.v("MicroMsg.CaptureStatistics", "report " + mVar2.abW());
        h.INSTANCE.kvStat(13947, mVar.toString());
        h.INSTANCE.kvStat(13949, mVar2.toString());
        if (z) {
            h.INSTANCE.idkeyStat(440, 119, 1, false);
            h.INSTANCE.idkeyStat(440, 120, j2, false);
            if (k.zuy.ilT == 720) {
                h.INSTANCE.idkeyStat(440, 122, j2, false);
                AppMethodBeat.o(89439);
            } else if (k.zuy.ejS()) {
                h.INSTANCE.idkeyStat(440, 123, j2, false);
                AppMethodBeat.o(89439);
            } else {
                h.INSTANCE.idkeyStat(440, 121, j2, false);
                AppMethodBeat.o(89439);
            }
        } else {
            h.INSTANCE.idkeyStat(440, 124, 1, false);
            h.INSTANCE.idkeyStat(440, 125, j2, false);
            if (k.zuy.gIP == 1) {
                h.INSTANCE.idkeyStat(440, 127, j2, false);
                h.INSTANCE.idkeyStat(440, 131, j2, false);
                AppMethodBeat.o(89439);
                return;
            }
            h.INSTANCE.idkeyStat(440, 126, j2, false);
            h.INSTANCE.idkeyStat(440, 130, j2, false);
            AppMethodBeat.o(89439);
        }
    }

    public static void ejN() {
        AppMethodBeat.i(89440);
        h.INSTANCE.idkeyStat(440, 140, 0, false);
        AppMethodBeat.o(89440);
    }
}
