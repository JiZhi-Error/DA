package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class m {
    public static boolean a(String str, VideoTransPara videoTransPara, cly cly, e eVar) {
        boolean z;
        float f2;
        float f3;
        AppMethodBeat.i(148821);
        try {
            if (Util.isNullOrNil(str) || videoTransPara == null) {
                AppMethodBeat.o(148821);
                return false;
            }
            if (cly == null) {
                cly = new cly();
            }
            Log.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", Boolean.valueOf(cly.Mrn), str, videoTransPara, Boolean.valueOf(cly.Mrq));
            if (cly.Mrq) {
                Log.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", str);
                AppMethodBeat.o(148821);
                return false;
            } else if (!cly.Mrn || Util.isNullOrNil(str)) {
                AppMethodBeat.o(148821);
                return false;
            } else {
                SightVideoJNI.tagMP4Dscp(str, e.baZ().getWeixinMeta());
                if (!Util.isNullOrNil(cly.Mrp)) {
                    SightVideoJNI.tagMp4RecordInfo(str, cly.Mrp);
                }
                long currentTicks = Util.currentTicks();
                SightVideoJNI.optimizeMP4VFS(str);
                Log.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                eVar.ehT();
                String k = s.k(str, false);
                d dVar = new d();
                dVar.setDataSource(k);
                int i2 = Util.getInt(dVar.extractMetadata(18), 0);
                int i3 = Util.getInt(dVar.extractMetadata(19), 0);
                int i4 = Util.getInt(dVar.extractMetadata(20), 0);
                dVar.release();
                Log.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                Log.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s %s", Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height), Integer.valueOf(videoTransPara.videoBitrate), Integer.valueOf(videoTransPara.iTh));
                int min = Math.min(i2, i3);
                boolean z2 = ae.gKA.gIZ == 1;
                if (Util.getInt(((a) g.af(a.class)).aqJ().getValue("MMSightCheckSendVideoBitrate"), 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                float f4 = Util.getFloat(((a) g.af(a.class)).aqJ().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3f);
                String mP4CprtH = SightVideoJNI.getMP4CprtH(k);
                if (mP4CprtH != null && mP4CprtH.length() >= 17 && mP4CprtH.substring(0, 17).equals("AdaptiveBitrateUP")) {
                    Log.i("MicroMsg.SightSendVideoLogic", "ABA: checkShouldRemuxing use aba: %s ", mP4CprtH);
                    f4 = 2.0f;
                }
                if ((videoTransPara.iTh & 2) != 0) {
                    f2 = 2.0f;
                } else {
                    f2 = f4;
                }
                float f5 = ((float) videoTransPara.videoBitrate) * f2;
                if (cly.Mrr) {
                    Log.i("MicroMsg.SightSendVideoLogic", "from skip compress, set to bitrate upper bound to 2400000");
                    f3 = (float) Util.getInt(((a) g.af(a.class)).aqJ().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 2400000);
                } else {
                    f3 = f5;
                }
                Log.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", Boolean.valueOf(z2), Boolean.valueOf(z), Float.valueOf(f2));
                boolean z3 = z2 || z;
                if (min > videoTransPara.width && ((min <= videoTransPara.width || min % 16 != 0 || Math.abs(min - videoTransPara.width) >= 16) && (!z3 || ((float) i4) < f3))) {
                    AppMethodBeat.o(148821);
                    return true;
                } else if (cly.Mrm) {
                    AppMethodBeat.o(148821);
                    return true;
                } else if (!z3 || ((float) i4) < ((float) videoTransPara.videoBitrate) * f2) {
                    cly.Mrq = true;
                    AppMethodBeat.o(148821);
                    return false;
                } else {
                    Log.i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
                    h.INSTANCE.idkeyStat(440, 205, 1, false);
                    AppMethodBeat.o(148821);
                    return true;
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", e2.getMessage(), str);
            if (cly != null) {
                cly.Mrq = true;
            }
            AppMethodBeat.o(148821);
            return false;
        }
    }

    public static int b(String str, VideoTransPara videoTransPara, cly cly, e eVar) {
        String str2;
        String str3;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(148822);
        if (cly == null || !cly.Mrn || !s.YS(str)) {
            AppMethodBeat.o(148822);
            return -1;
        }
        if (cly.Mrq) {
            Log.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", str);
        }
        try {
            String boZ = s.boZ(str);
            if (!boZ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str2 = boZ + FilePathGenerator.ANDROID_DIR_SEP;
            } else {
                str2 = boZ;
            }
            String name = new o(str).getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                str3 = name.substring(0, lastIndexOf);
            } else {
                str3 = name;
            }
            String str4 = str2 + str3 + "_hd";
            if (str.endsWith(".mp4")) {
                str4 = str4 + ".mp4";
            }
            String str5 = str2 + str3 + "tempRemuxing.mp4";
            s.nw(str, str4);
            Log.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", str2, str3, str4, str5, Integer.valueOf(cly.vUh));
            String k = s.k(str4, true);
            String k2 = s.k(str5, true);
            d dVar = new d();
            dVar.setDataSource(k);
            int i7 = Util.getInt(dVar.extractMetadata(18), 0);
            int i8 = Util.getInt(dVar.extractMetadata(19), 0);
            int min = Math.min(i7, i8);
            if (min <= videoTransPara.width || (min > videoTransPara.width && min % 16 == 0 && Math.abs(min - videoTransPara.width) < 16)) {
                i3 = i8;
                i2 = i7;
            } else {
                if (i7 < i8) {
                    i2 = videoTransPara.width;
                    i3 = (int) (((double) i8) / ((1.0d * ((double) i7)) / ((double) i2)));
                } else {
                    i3 = videoTransPara.width;
                    i2 = (int) (((double) i7) / ((1.0d * ((double) i8)) / ((double) i3)));
                }
                if (i3 % 2 != 0) {
                    i3++;
                }
                if (i2 % 2 != 0) {
                    i2++;
                }
            }
            Log.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", str, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i2), Integer.valueOf(i3), videoTransPara);
            long currentTicks = Util.currentTicks();
            if (cly.Mrr) {
                Log.i("MicroMsg.SightSendVideoLogic", "from skip compress, set remux target bitrate to 2400000");
                videoTransPara.videoBitrate = Util.getInt(((a) g.af(a.class)).aqJ().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 2400000);
            }
            int[] iArr2 = new int[34];
            if (videoTransPara.iTg == 1 || videoTransPara.iTg == 2) {
                int[] a2 = AdaptiveAdjustBitrate.a(k, i3, i2, videoTransPara.fps, videoTransPara.videoBitrate, 0.0f, 0.0f, 2, videoTransPara.iTi, videoTransPara.iTj, videoTransPara.iTk, videoTransPara.iTl, videoTransPara.iTm, videoTransPara.iTn, videoTransPara.iTo, false);
                if (a2 != null) {
                    videoTransPara.videoBitrate = a2[0] * 1000;
                }
                if (a2[5] > 0) {
                    i2 = a2[1];
                    i4 = a2[2];
                } else {
                    i4 = i3;
                }
                Log.i("MicroMsg.SightSendVideoLogic", "ABA: MMsightSendVideoLogic Videobitrate: [%d] , Width: [%d], Height: [%d] ", Integer.valueOf(videoTransPara.videoBitrate), Integer.valueOf(i2), Integer.valueOf(i4));
                iArr = a2;
            } else {
                iArr = iArr2;
                i4 = i3;
            }
            if (videoTransPara.iTh == 1) {
                Log.i("MicroMsg.SightSendVideoLogic", "ABA: Using Min Max QP Limitation: [%d], [%d] ", Integer.valueOf(videoTransPara.idF), Integer.valueOf(videoTransPara.idG));
                i5 = videoTransPara.idF;
                i6 = videoTransPara.idG;
            } else {
                i5 = 0;
                i6 = 51;
            }
            int remuxingVFS = SightVideoJNI.remuxingVFS(k, k2, i2, i4, videoTransPara.videoBitrate, videoTransPara.iSV, 8, videoTransPara.iSU, 25.0f, 30.0f, null, 0, false, i5, i6);
            Log.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", str, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(remuxingVFS), Long.valueOf(Util.ticksToNow(currentTicks)));
            s.nx(k2, str);
            String k3 = s.k(str, true);
            long currentTicks2 = Util.currentTicks();
            if (videoTransPara.iTg > 0) {
                SightVideoJNI.addReportMetadata(k3, iArr, videoTransPara.iTg, 0);
            } else if (videoTransPara.iTh == 1) {
                SightVideoJNI.addReportMetadata(k3, iArr, 0, videoTransPara.iTh);
            }
            if (cly.Mrn) {
                SightVideoJNI.tagMP4Dscp(k3, e.baZ().getWeixinMeta());
                if (!Util.isNullOrNil(cly.Mrp)) {
                    SightVideoJNI.tagMp4RecordInfo(k3, cly.Mrp);
                }
                SightVideoJNI.optimizeMP4VFS(k3);
            }
            eVar.ehT();
            Log.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", Long.valueOf(Util.ticksToNow(currentTicks2)));
            AppMethodBeat.o(148822);
            return remuxingVFS;
        } catch (Exception e2) {
            Log.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", e2.getMessage());
            AppMethodBeat.o(148822);
            return -1;
        }
    }
}
