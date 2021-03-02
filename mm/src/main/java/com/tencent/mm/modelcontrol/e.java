package com.tencent.mm.modelcontrol;

import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.n.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tavkit.component.TAVPlayer;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class e implements bd {
    private static final int iSE = c.bJ("dscp");
    private a iSF = new a();
    private byte[] iSG = null;
    private b iSH;
    private f[] iSI;
    private f[] iSJ;
    private f[] iSK;
    private f[] iSL;
    private f[] iSM;
    private f[] iSN;
    private f[] iSO;
    private f[] iSP;
    private f[] iSQ;
    private f[] iSR;
    private f[] iSS;

    static {
        AppMethodBeat.i(126773);
        AppMethodBeat.o(126773);
    }

    public e() {
        AppMethodBeat.i(126747);
        AppMethodBeat.o(126747);
    }

    public static e baZ() {
        AppMethodBeat.i(126748);
        e eVar = (e) y.at(e.class);
        AppMethodBeat.o(126748);
        return eVar;
    }

    private static f[] Og(String str) {
        AppMethodBeat.i(126749);
        String value = ((a) g.af(a.class)).aqJ().getValue(str);
        if (Util.isNullOrNil(value)) {
            Log.i("MicroMsg.SubCoreVideoControl", "key %s config is null", str);
            AppMethodBeat.o(126749);
            return null;
        }
        if (!value.startsWith("[")) {
            value = "[".concat(String.valueOf(value));
        }
        if (!value.endsWith("]")) {
            value = value + "]";
        }
        Log.i("MicroMsg.SubCoreVideoControl", "%s=%s ", str, value);
        try {
            JSONArray jSONArray = new JSONArray(value);
            int length = jSONArray.length();
            Log.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", Integer.valueOf(length));
            f[] fVarArr = new f[length];
            for (int i2 = 0; i2 < length; i2++) {
                fVarArr[i2] = y(jSONArray.getJSONObject(i2));
            }
            AppMethodBeat.o(126749);
            return fVarArr;
        } catch (Exception e2) {
            Log.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + e2.toString());
            AppMethodBeat.o(126749);
            return null;
        }
    }

    private static f y(JSONObject jSONObject) {
        String string;
        AppMethodBeat.i(126750);
        f fVar = new f();
        try {
            String string2 = jSONObject.isNull("time") ? "" : jSONObject.getString("time");
            String string3 = jSONObject.getString("abr");
            String string4 = jSONObject.getString("intval");
            String string5 = jSONObject.getString("prof");
            String string6 = jSONObject.getString("preset");
            if (jSONObject.isNull("stepbr")) {
                string = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else {
                string = jSONObject.getString("stepbr");
            }
            Log.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", string2, string3, string4, string5, string6, string);
            fVar.a(string2, string3, string4, string5, string6, string);
            JSONArray jSONArray = jSONObject.getJSONArray("conf");
            ArrayList arrayList = new ArrayList();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            PInt pInt5 = new PInt();
            PInt pInt6 = new PInt();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (a(!jSONObject2.isNull("dura") ? jSONObject2.getString("dura") : "", jSONObject2.getString("wh"), jSONObject2.getString("fps"), jSONObject2.getString("vbr"), pInt, pInt2, pInt3, pInt4, pInt5, pInt6)) {
                    arrayList.add(new g(pInt.value, pInt2.value, pInt3.value, pInt4.value, pInt5.value, pInt6.value, pInt6.value));
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2 && !fVar.iSW) {
                int i3 = ((g) arrayList.get(0)).iTe;
                for (int i4 = 1; i4 < arrayList.size(); i4++) {
                    g gVar = (g) arrayList.get(i4);
                    gVar.iTd = i3;
                    i3 = gVar.iTe;
                }
            }
            fVar.iSX = new g[arrayList.size()];
            arrayList.toArray(fVar.iSX);
            Log.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", fVar);
            AppMethodBeat.o(126750);
            return fVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + e2.toString());
            AppMethodBeat.o(126750);
            return null;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5, PInt pInt6) {
        AppMethodBeat.i(126751);
        if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3) || Util.isNullOrNil(str4)) {
            AppMethodBeat.o(126751);
            return false;
        }
        try {
            if (!Util.isNullOrNil(str)) {
                String[] split = str.split("~");
                pInt.value = Util.getInt(split[0], -1);
                pInt2.value = Util.getInt(split[1], -1);
                if (pInt.value < 0 || pInt2.value < 0) {
                    AppMethodBeat.o(126751);
                    return false;
                }
            } else {
                pInt2.value = 0;
                pInt.value = 0;
            }
            String[] split2 = str2.split("x");
            pInt3.value = Util.getInt(split2[0], -1);
            pInt4.value = Util.getInt(split2[1], -1);
            if (pInt3.value < 0 || pInt4.value < 0) {
                AppMethodBeat.o(126751);
                return false;
            }
            pInt5.value = Util.getInt(str3, -1);
            pInt6.value = Util.getInt(str4, -1);
            if (pInt5.value < 0 || pInt6.value < 0) {
                AppMethodBeat.o(126751);
                return false;
            }
            pInt6.value *= 1000;
            Log.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", str, str2, str3, str4, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value), Integer.valueOf(pInt5.value), Integer.valueOf(pInt6.value));
            AppMethodBeat.o(126751);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.SubCoreVideoControl", "parse video para error." + e2.toString());
        }
    }

    public static int b(VideoTransPara videoTransPara) {
        if (videoTransPara == null) {
            return 0;
        }
        switch (videoTransPara.duration) {
            case 10:
                return 1;
            default:
                return videoTransPara.duration;
        }
    }

    public final byte[] getWeixinMeta() {
        AppMethodBeat.i(126752);
        if (Util.isNullOrNil(this.iSG)) {
            try {
                String str = "{\"WXVer\":" + d.KyO + "}";
                this.iSG = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                Log.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", str);
            } catch (Exception e2) {
                Log.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", e2.toString());
            }
        }
        byte[] bArr = this.iSG;
        AppMethodBeat.o(126752);
        return bArr;
    }

    public final boolean Oh(String str) {
        AppMethodBeat.i(126753);
        if (this.iSH == null) {
            this.iSH = new b();
        }
        b bVar = this.iSH;
        bVar.jPW = -1;
        bVar.jPY = -1;
        bVar.jPZ = null;
        long currentTicks = Util.currentTicks();
        long Sw = this.iSH.Sw(str);
        if (Sw <= 0) {
            AppMethodBeat.o(126753);
            return false;
        }
        RandomAccessFile randomAccessFile = null;
        String str2 = null;
        try {
            RandomAccessFile dB = s.dB(str, false);
            dB.seek(Sw);
            byte[] bArr = new byte[8];
            com.tencent.mm.plugin.a.a aVar = null;
            for (com.tencent.mm.plugin.a.a a2 = c.a(dB, bArr, com.tencent.mm.plugin.a.a.bmj); a2 != null; a2 = c.a(dB, bArr, com.tencent.mm.plugin.a.a.bmj)) {
                aVar = c.a(dB, bArr, iSE);
                if (aVar != null) {
                    break;
                }
                dB.seek(a2.getEndPos());
            }
            if (aVar != null) {
                byte[] bArr2 = new byte[(((int) aVar.getSize()) - 8)];
                dB.seek(aVar.jPV + 8);
                if (dB.read(bArr2) > 0) {
                    str2 = new String(bArr2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                }
            }
            if (dB != null) {
                try {
                    dB.close();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e3.toString());
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException e4) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(126753);
            throw th;
        }
        Log.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(Sw), Long.valueOf(Util.ticksToNow(currentTicks)), str);
        if (!Util.isNullOrNil(str2)) {
            boolean contains = str2.contains("WXVer");
            AppMethodBeat.o(126753);
            return contains;
        }
        AppMethodBeat.o(126753);
        return false;
    }

    public final VideoTransPara bba() {
        VideoTransPara videoTransPara;
        boolean z;
        AppMethodBeat.i(126754);
        long currentTicks = Util.currentTicks();
        if (this.iSI == null) {
            this.iSI = Og("C2CRecordVideoConfig");
        }
        if (this.iSI != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.iSI.length) {
                    break;
                }
                f fVar = this.iSI[i2];
                if (fVar != null && fVar.bbo()) {
                    Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
                    videoTransPara = fVar.bbp();
                    z = fVar.iSW;
                    break;
                }
                i2++;
            }
        }
        videoTransPara = null;
        z = true;
        if (videoTransPara == null) {
            videoTransPara = new VideoTransPara();
            videoTransPara.isDefault = true;
            videoTransPara.width = TAVPlayer.VIDEO_PLAYER_WIDTH;
            videoTransPara.height = 960;
            videoTransPara.fps = 30;
            videoTransPara.videoBitrate = 1200000;
            videoTransPara.iiH = 10;
            videoTransPara.audioBitrate = 64000;
            videoTransPara.iSU = 2;
            videoTransPara.iSV = 1;
            videoTransPara.audioChannelCount = 1;
        }
        videoTransPara.audioSampleRate = 44100;
        videoTransPara.iiH = 10;
        VideoTransPara a2 = a(videoTransPara, 1);
        a2.duration = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.mmc2c_record_sight_max_timelength, 10);
        if (!z) {
            h.INSTANCE.idkeyStat(422, 11, 1, false);
        } else {
            h.INSTANCE.idkeyStat(422, 12, 1, false);
        }
        int nullAsNil = Util.nullAsNil((Integer) h.a(a2.videoBitrate / 1000, new int[]{350, 544, 800, 1200, 1600}, 13, 18));
        h.INSTANCE.idkeyStat(422, (long) nullAsNil, 1, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", Long.valueOf(Util.ticksToNow(currentTicks)), a2, Integer.valueOf(nullAsNil));
        AppMethodBeat.o(126754);
        return a2;
    }

    public final VideoTransPara bbb() {
        VideoTransPara videoTransPara;
        boolean z;
        VideoTransPara videoTransPara2;
        AppMethodBeat.i(126755);
        long currentTicks = Util.currentTicks();
        if (this.iSJ == null) {
            this.iSJ = Og("SnsRecordVideoConfig");
        }
        if (this.iSJ != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.iSJ.length) {
                    break;
                }
                f fVar = this.iSJ[i2];
                if (fVar != null && fVar.bbo()) {
                    Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
                    videoTransPara = fVar.bbp();
                    z = fVar.iSW;
                    break;
                }
                i2++;
            }
        }
        videoTransPara = null;
        z = true;
        if (videoTransPara == null) {
            videoTransPara2 = bbi();
        } else {
            videoTransPara2 = videoTransPara;
        }
        videoTransPara2.audioSampleRate = 44100;
        videoTransPara2.iiH = 10;
        videoTransPara2.iTf = 200;
        videoTransPara2.duration = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.mmsns_record_sight_max_timelength, 10);
        VideoTransPara a2 = a(videoTransPara2, 2);
        if (!z) {
            h.INSTANCE.idkeyStat(422, 31, 1, false);
        } else {
            h.INSTANCE.idkeyStat(422, 32, 1, false);
        }
        int nullAsNil = Util.nullAsNil((Integer) h.a(a2.videoBitrate / 1000, new int[]{350, 544, 800, 1200, 1600}, 33, 38));
        h.INSTANCE.idkeyStat(422, (long) nullAsNil, 1, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", Long.valueOf(Util.ticksToNow(currentTicks)), a2, Integer.valueOf(nullAsNil));
        AppMethodBeat.o(126755);
        return a2;
    }

    public final VideoTransPara bbc() {
        VideoTransPara videoTransPara;
        boolean z;
        VideoTransPara videoTransPara2;
        AppMethodBeat.i(126756);
        long currentTicks = Util.currentTicks();
        if (this.iSK == null) {
            this.iSK = Og("SnsAlbumVideoConfig");
        }
        if (this.iSK != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.iSK.length) {
                    break;
                }
                f fVar = this.iSK[i2];
                if (fVar != null && fVar.bbo()) {
                    Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
                    videoTransPara = fVar.bbp();
                    z = fVar.iSW;
                    break;
                }
                i2++;
            }
        }
        videoTransPara = null;
        z = true;
        if (videoTransPara == null) {
            videoTransPara2 = bbi();
        } else {
            videoTransPara2 = videoTransPara;
        }
        videoTransPara2.audioSampleRate = 44100;
        videoTransPara2.iiH = 10;
        videoTransPara2.iTf = 200;
        videoTransPara2.duration = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.mmsns_album_sight_max_timelength, 10);
        VideoTransPara a2 = a(videoTransPara2, 2);
        if (!z) {
            h.INSTANCE.idkeyStat(422, 21, 1, false);
        } else {
            h.INSTANCE.idkeyStat(422, 22, 1, false);
        }
        int nullAsNil = Util.nullAsNil((Integer) h.a(a2.videoBitrate / 1000, new int[]{350, 544, 800, 1200, 1600}, 23, 28));
        h.INSTANCE.idkeyStat(422, (long) nullAsNil, 1, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", Long.valueOf(Util.ticksToNow(currentTicks)), a2, Integer.valueOf(nullAsNil));
        AppMethodBeat.o(126756);
        return a2;
    }

    private static VideoTransPara a(VideoTransPara videoTransPara, int i2) {
        boolean z;
        AppMethodBeat.i(126757);
        if (i2 == 2 || i2 == 4 || i2 == 1) {
            switch (i2) {
                case 1:
                    videoTransPara.iTg = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_brres_adjust_c2c_switch, 0);
                    videoTransPara.iTn = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_bitrate_adjust_enable720p, 0);
                    videoTransPara.iTk = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_snsc2c_ceiling_bitrate, 10);
                    videoTransPara.iTl = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_snsc2c_flooring_bitrate, 10);
                    videoTransPara.iTo = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_snsc2c_max_videosize, 10);
                    break;
                case 2:
                    videoTransPara.iTg = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_bitrate_adjust_switch, 0);
                    videoTransPara.iTn = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_bitrate_adjust_sns720p, 0);
                    videoTransPara.iTk = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_snsc2c_ceiling_bitrate, 10);
                    videoTransPara.iTl = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_snsc2c_flooring_bitrate, 10);
                    videoTransPara.iTo = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_snsc2c_max_videosize, 10);
                    break;
                case 3:
                default:
                    videoTransPara.iTg = 0;
                    videoTransPara.iTn = 0;
                    break;
                case 4:
                    videoTransPara.iTg = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_brres_adjust_finder_switch, 0);
                    videoTransPara.iTn = 0;
                    videoTransPara.iTk = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_finder_ceiling_bitrate, 10);
                    videoTransPara.iTl = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_finder_flooring_bitrate, 10);
                    videoTransPara.iTo = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_finder_max_videosize, 10);
                    break;
            }
            videoTransPara.iTh = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_minmaxqp_switch, 0);
            videoTransPara.iTi = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_bitrate_adjust_upgear, 10);
            videoTransPara.iTj = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_bitrate_adjust_downgear, 10);
            videoTransPara.iTm = 0;
            if (videoTransPara.iTh != 0) {
                videoTransPara.idF = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_bitrate_adjust_minqp, 21);
                videoTransPara.idG = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_bitrate_adjust_maxqp, 39);
            } else {
                videoTransPara.idF = 0;
                videoTransPara.idG = 51;
            }
            videoTransPara.iTp = videoTransPara.videoBitrate;
            videoTransPara.iTq = i2;
            int aon = m.aon() & 255;
            if (aon < 30 || Build.VERSION.SDK_INT <= 25) {
                videoTransPara.iTg = 0;
            }
            Log.i("MicroMsg.SubCoreVideoControl", "ABA: Prams abaSwitch: [%d]  qpSwitch: [%d] abaUpgear: [%d] abaDowngear: [%d] ceilingVideoBR: [%d] flooringVideoBR:[%d] minQP: [%d] maxQP: [%d] CPUlevel: [%d] AndroidVersionSDK: [%d] remuxSecene: [%d] isEnable720p: [%d] maxVideoSize: [%d]", Integer.valueOf(videoTransPara.iTg), Integer.valueOf(videoTransPara.iTh), Integer.valueOf(videoTransPara.iTi), Integer.valueOf(videoTransPara.iTj), Integer.valueOf(videoTransPara.iTk), Integer.valueOf(videoTransPara.iTl), Integer.valueOf(videoTransPara.idF), Integer.valueOf(videoTransPara.idG), Integer.valueOf(aon), Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(videoTransPara.iTq), Integer.valueOf(videoTransPara.iTn), Integer.valueOf(videoTransPara.iTo));
        } else {
            videoTransPara.iTg = 0;
            videoTransPara.iTh = 0;
            videoTransPara.iTp = videoTransPara.videoBitrate;
            videoTransPara.idF = 0;
            videoTransPara.idG = 51;
            Log.i("MicroMsg.SubCoreVideoControl", "ABA: it does not use the ABA or MinMax QP Limitation");
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("HardcoderQP");
        if (mmkv != null) {
            String decodeString = mmkv.decodeString("HCMinQPKey", null);
            String decodeString2 = mmkv.decodeString("HCMaxQPKey", null);
            if (!(decodeString == null || decodeString2 == null)) {
                boolean z2 = false;
                int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_minmaxqp_switch, 0);
                int i3 = ae.gKA.gJp;
                if (i3 == 0) {
                    z = true;
                } else if (i2 <= 0 || i2 > 3 || i3 <= 0 || ((1 << (i2 - 1)) & i3) == 0) {
                    z = false;
                } else {
                    z2 = true;
                    z = false;
                }
                Log.i("MicroMsg.SubCoreVideoControl", "steve:[hardcoder] get hardcoder QP key: min:%s, max:%s, forceHWQP:%s, qpSwitch:%s, deviceQPCfg:%s, forceHWQPOff:%s", decodeString, decodeString2, Boolean.valueOf(z2), Integer.valueOf(a2), Integer.valueOf(i3), Boolean.valueOf(z));
                if (!z && (z2 || (a2 & 2) != 0)) {
                    int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_bitrate_adjust_minqp, 21);
                    int a4 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmadaptive_bitrate_adjust_maxqp, 39);
                    int max = Math.max(0, Math.min(51, a3));
                    int max2 = Math.max(0, Math.min(51, a4));
                    if (!(max == 0 || max2 == 51)) {
                        videoTransPara.idF = max;
                        videoTransPara.idG = max2;
                        videoTransPara.iTg = 0;
                        videoTransPara.iTh |= 2;
                        Log.i("MicroMsg.SubCoreVideoControl", "steve:[hardcoder] get hardcoder QP key: min:%s, max:%s, value: minQP:%d, maxQP:%d, Scence:%d", decodeString, decodeString2, Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(i2));
                    }
                }
            }
        }
        AppMethodBeat.o(126757);
        return videoTransPara;
    }

    public final VideoTransPara bbd() {
        VideoTransPara videoTransPara;
        boolean z;
        AppMethodBeat.i(126758);
        long currentTicks = Util.currentTicks();
        if (this.iSL == null) {
            this.iSL = Og("StoryRecordVideoConfig");
        }
        if (this.iSL != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.iSL.length) {
                    break;
                }
                f fVar = this.iSL[i2];
                if (fVar != null && fVar.bbo()) {
                    Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
                    videoTransPara = fVar.bbp();
                    z = fVar.iSW;
                    break;
                }
                i2++;
            }
        }
        videoTransPara = null;
        z = true;
        if (videoTransPara == null) {
            videoTransPara = new VideoTransPara();
            videoTransPara.isDefault = true;
            videoTransPara.width = TAVExporter.VIDEO_EXPORT_WIDTH;
            videoTransPara.height = TAVExporter.VIDEO_EXPORT_HEIGHT;
            videoTransPara.fps = 30;
            videoTransPara.videoBitrate = 3500000;
            videoTransPara.iiH = 10;
            videoTransPara.audioBitrate = 48000;
            videoTransPara.iSU = 2;
            videoTransPara.iSV = 1;
            videoTransPara.audioChannelCount = 1;
        }
        videoTransPara.audioSampleRate = 44100;
        videoTransPara.iiH = 10;
        videoTransPara.iTf = 200;
        VideoTransPara a2 = a(videoTransPara, 3);
        if (a2.duration <= 0) {
            a2.duration = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_capture_duration, 15);
        }
        if (!z) {
            h.INSTANCE.idkeyStat(422, 31, 1, false);
        } else {
            h.INSTANCE.idkeyStat(422, 32, 1, false);
        }
        int nullAsNil = Util.nullAsNil((Integer) h.a(a2.videoBitrate / 1000, new int[]{350, 544, 800, 1200, 1600}, 33, 38));
        h.INSTANCE.idkeyStat(422, (long) nullAsNil, 1, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get story record para cost %d. %s rpt %d", Long.valueOf(Util.ticksToNow(currentTicks)), a2, Integer.valueOf(nullAsNil));
        AppMethodBeat.o(126758);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.modelcontrol.VideoTransPara bbe() {
        /*
        // Method dump skipped, instructions count: 179
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.e.bbe():com.tencent.mm.modelcontrol.VideoTransPara");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.modelcontrol.VideoTransPara bbf() {
        /*
        // Method dump skipped, instructions count: 179
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.e.bbf():com.tencent.mm.modelcontrol.VideoTransPara");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.modelcontrol.VideoTransPara bbg() {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.e.bbg():com.tencent.mm.modelcontrol.VideoTransPara");
    }

    public final VideoTransPara sV(int i2) {
        VideoTransPara videoTransPara;
        AppMethodBeat.i(126759);
        long currentTicks = Util.currentTicks();
        if (this.iSP == null) {
            if (i2 == 1) {
                this.iSP = Og("GameRecordBigVideoConfig");
            } else {
                this.iSP = Og("GameRecordVideoConfig");
            }
        }
        if (this.iSP != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.iSP.length) {
                    break;
                }
                f fVar = this.iSP[i3];
                if (fVar != null && fVar.bbo()) {
                    Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get game Record config.");
                    videoTransPara = fVar.bbp();
                    break;
                }
                i3++;
            }
        }
        videoTransPara = null;
        if (videoTransPara == null) {
            if (i2 == 1) {
                videoTransPara = new VideoTransPara();
                videoTransPara.isDefault = true;
                videoTransPara.width = 1080;
                videoTransPara.height = 1920;
                videoTransPara.fps = 30;
                videoTransPara.videoBitrate = 3500000;
                videoTransPara.iiH = 10;
                videoTransPara.audioBitrate = 48000;
                videoTransPara.iSU = 2;
                videoTransPara.iSV = 1;
                videoTransPara.duration = 60;
                videoTransPara.audioChannelCount = 1;
            } else {
                videoTransPara = new VideoTransPara();
                videoTransPara.isDefault = true;
                videoTransPara.width = 1080;
                videoTransPara.height = 1920;
                videoTransPara.fps = 30;
                videoTransPara.videoBitrate = 3500000;
                videoTransPara.iiH = 10;
                videoTransPara.audioBitrate = 48000;
                videoTransPara.iSU = 2;
                videoTransPara.iSV = 1;
                videoTransPara.duration = 60;
                videoTransPara.audioChannelCount = 1;
            }
        }
        videoTransPara.audioSampleRate = 44100;
        videoTransPara.iiH = 10;
        videoTransPara.iTf = 200;
        VideoTransPara a2 = a(videoTransPara, 1);
        Log.i("MicroMsg.SubCoreVideoControl", "get game record para cost %d. %s", Long.valueOf(Util.ticksToNow(currentTicks)), a2);
        AppMethodBeat.o(126759);
        return a2;
    }

    public final VideoTransPara c(VideoTransPara videoTransPara) {
        boolean z;
        f[] fVarArr;
        int a2;
        VideoTransPara videoTransPara2;
        AppMethodBeat.i(126760);
        if (videoTransPara == null) {
            Log.e("MicroMsg.SubCoreVideoControl", "get c2c album video para but original video para is null.");
            AppMethodBeat.o(126760);
            return null;
        }
        int i2 = videoTransPara.duration;
        com.tencent.mm.n.a aVar = com.tencent.mm.n.a.gLV;
        if (i2 >= com.tencent.mm.n.a.apH()) {
            Log.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", 300);
            AppMethodBeat.o(126760);
            return null;
        }
        long currentTicks = Util.currentTicks();
        VideoTransPara sW = sW(videoTransPara.duration);
        boolean z2 = true;
        int i3 = 1;
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100157");
        if (Fu.isValid()) {
            i3 = Util.getInt(Fu.gzz().get("VideoEncodeStep"), 1);
        }
        Log.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", Integer.valueOf(i3));
        if (i3 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.iSR == null) {
                this.iSR = Og("C2CAlbumVideoStepConfig");
            }
            fVarArr = this.iSR;
        } else {
            if (this.iSQ == null) {
                this.iSQ = Og("C2CAlbumVideoConfig");
            }
            fVarArr = this.iSQ;
        }
        if (fVarArr != null) {
            int i4 = 0;
            while (true) {
                if (i4 >= fVarArr.length) {
                    a2 = 0;
                    break;
                }
                f fVar = fVarArr[i4];
                if (fVar != null && fVar.bbo()) {
                    Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
                    int a3 = a.a(fVar.iSX, videoTransPara, sW);
                    z2 = fVar.iSW;
                    a2 = a3;
                    break;
                }
                i4++;
            }
        } else {
            Log.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
            a2 = a.a(null, videoTransPara, sW);
        }
        if (a2 <= 0) {
            videoTransPara2 = sW(videoTransPara.duration);
        } else {
            sW.isDefault = false;
            videoTransPara2 = sW;
        }
        VideoTransPara a4 = a(videoTransPara2, 1);
        if (!z2) {
            h.INSTANCE.idkeyStat(422, 1, 1, false);
        } else {
            h.INSTANCE.idkeyStat(422, 2, 1, false);
        }
        int nullAsNil = Util.nullAsNil((Integer) h.a(a4.videoBitrate / 1000, new int[]{350, 544, 800, 1200, 1600}, 3, 8));
        h.INSTANCE.idkeyStat(422, (long) nullAsNil, 1, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(nullAsNil), Integer.valueOf(a2), a4, videoTransPara);
        AppMethodBeat.o(126760);
        return a4;
    }

    public final VideoTransPara bbh() {
        VideoTransPara videoTransPara;
        boolean z;
        AppMethodBeat.i(126761);
        long currentTicks = Util.currentTicks();
        if (this.iSS == null) {
            this.iSS = Og("NearbyRecordVideoConfig");
        }
        if (this.iSS != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.iSS.length) {
                    break;
                }
                f fVar = this.iSS[i2];
                if (fVar != null && fVar.bbo()) {
                    Log.i("MicroMsg.SubCoreVideoControl", "is busy time, try to get nearby record config.");
                    videoTransPara = fVar.bbp();
                    z = fVar.iSW;
                    break;
                }
                i2++;
            }
        }
        videoTransPara = null;
        z = true;
        if (videoTransPara == null) {
            videoTransPara = bbi();
        }
        videoTransPara.audioSampleRate = 44100;
        videoTransPara.iiH = 10;
        videoTransPara.iTf = 200;
        VideoTransPara a2 = a(videoTransPara, 2);
        if (a2.duration <= 0) {
            a2.duration = 10;
        }
        if (!z) {
            h.INSTANCE.idkeyStat(422, 31, 1, false);
        } else {
            h.INSTANCE.idkeyStat(422, 32, 1, false);
        }
        int nullAsNil = Util.nullAsNil((Integer) h.a(a2.videoBitrate / 1000, new int[]{350, 544, 800, 1200, 1600}, 33, 38));
        h.INSTANCE.idkeyStat(422, (long) nullAsNil, 1, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get nearby record para cost %d. %s rpt %d", Long.valueOf(Util.ticksToNow(currentTicks)), a2, Integer.valueOf(nullAsNil));
        AppMethodBeat.o(126761);
        return a2;
    }

    private static VideoTransPara bbi() {
        AppMethodBeat.i(126762);
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.width = TAVExporter.VIDEO_EXPORT_WIDTH;
        videoTransPara.height = TAVExporter.VIDEO_EXPORT_HEIGHT;
        videoTransPara.fps = 30;
        videoTransPara.videoBitrate = 2000000;
        videoTransPara.iiH = 10;
        videoTransPara.audioBitrate = 64000;
        videoTransPara.iSU = 2;
        videoTransPara.iSV = 1;
        videoTransPara.audioChannelCount = 1;
        AppMethodBeat.o(126762);
        return videoTransPara;
    }

    private static VideoTransPara bbj() {
        AppMethodBeat.i(169099);
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.width = 1072;
        videoTransPara.height = (int) (((double) (((float) videoTransPara.width) * 3.5f)) / 3.0d);
        videoTransPara.fps = 30;
        videoTransPara.videoBitrate = 2000000;
        videoTransPara.iiH = 1;
        videoTransPara.audioBitrate = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
        videoTransPara.iSU = 2;
        videoTransPara.iSV = 1;
        videoTransPara.audioChannelCount = 1;
        AppMethodBeat.o(169099);
        return videoTransPara;
    }

    private static VideoTransPara sW(int i2) {
        AppMethodBeat.i(126763);
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.iiH = 1;
        videoTransPara.audioBitrate = 48000;
        videoTransPara.iSU = 2;
        videoTransPara.iSV = 1;
        videoTransPara.audioChannelCount = 1;
        if (i2 <= 120) {
            videoTransPara.fps = 30;
            videoTransPara.width = TAVPlayer.VIDEO_PLAYER_WIDTH;
            videoTransPara.height = 960;
            videoTransPara.videoBitrate = 1200000;
        } else {
            videoTransPara.fps = 24;
            videoTransPara.width = v2helper.VOIP_ENC_HEIGHT_LV1;
            videoTransPara.height = 640;
            videoTransPara.videoBitrate = 544000;
        }
        AppMethodBeat.o(126763);
        return videoTransPara;
    }

    public static boolean bbk() {
        int i2;
        boolean z;
        AppMethodBeat.i(126764);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_ONLINE_VIDEO_INT, (Object) -1)).intValue();
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100136");
        if (Fu.isValid()) {
            i2 = Util.getInt(Fu.gzz().get("streamingDownload"), 0);
        } else {
            i2 = 0;
        }
        boolean bbm = bbm();
        if (intValue == 0 || i2 == -1 || !bbm) {
            z = false;
        } else if (intValue > 0) {
            z = true;
        } else {
            z = i2 > 0;
        }
        Log.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", Boolean.valueOf(z), Boolean.valueOf(bbm), Integer.valueOf(intValue), Integer.valueOf(i2));
        AppMethodBeat.o(126764);
        return z;
    }

    public static boolean bbl() {
        int i2;
        boolean z;
        AppMethodBeat.i(126765);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_ONLINE_VIDEO_INT, (Object) -1)).intValue();
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100153");
        if (Fu.isValid()) {
            i2 = Util.getInt(Fu.gzz().get("snsStreamDownload"), 0);
        } else {
            i2 = 0;
        }
        boolean bbm = bbm();
        if (intValue == 0 || i2 == -1 || !bbm) {
            z = false;
        } else if (intValue > 0) {
            z = true;
        } else {
            z = i2 > 0;
        }
        Log.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", Boolean.valueOf(z), Boolean.valueOf(bbm), Integer.valueOf(intValue), Integer.valueOf(i2));
        AppMethodBeat.o(126765);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean bbm() {
        /*
        // Method dump skipped, instructions count: 277
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.e.bbm():boolean");
    }

    public static int a(int i2, com.tencent.mm.modelvideo.s sVar) {
        int a2;
        AppMethodBeat.i(126767);
        switch (i2) {
            case 0:
                a2 = 1;
                break;
            case 1:
                a2 = a(sVar);
                break;
            case 2:
                a2 = a(sVar);
                break;
            default:
                a2 = 1;
                break;
        }
        Log.i("MicroMsg.SubCoreVideoControl", "check c2c video format[%d]", Integer.valueOf(a2));
        if (a2 == 2) {
            h.INSTANCE.idkeyStat(354, 130, 1, false);
        } else {
            h.INSTANCE.idkeyStat(354, 131, 1, false);
        }
        AppMethodBeat.o(126767);
        return a2;
    }

    private static int a(com.tencent.mm.modelvideo.s sVar) {
        int i2 = 1;
        AppMethodBeat.i(126768);
        if (!sX(1)) {
            AppMethodBeat.o(126768);
            return 1;
        }
        o.bhj();
        String Qw = t.Qw(sVar.getFileName());
        if (!s.YS(Qw)) {
            AppMethodBeat.o(126768);
            return 2;
        }
        if (r.isH265Video(Qw)) {
            i2 = 2;
        }
        AppMethodBeat.o(126768);
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (com.tencent.mm.modelvideo.r.isH265Video(r8) != false) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int K(int r7, java.lang.String r8) {
        /*
            r6 = 126769(0x1ef31, float:1.77641E-40)
            r0 = 2
            r1 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            switch(r7) {
                case 0: goto L_0x0022;
                case 1: goto L_0x0024;
                case 2: goto L_0x0024;
                default: goto L_0x000b;
            }
        L_0x000b:
            r0 = r1
        L_0x000c:
            java.lang.String r2 = "MicroMsg.SubCoreVideoControl"
            java.lang.String r3 = "check sns video format[%d]"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            r1[r4] = r5
            com.tencent.mm.sdk.platformtools.Log.i(r2, r3, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return r0
        L_0x0022:
            r0 = r1
            goto L_0x000c
        L_0x0024:
            boolean r2 = sX(r0)
            if (r2 == 0) goto L_0x000b
            boolean r2 = com.tencent.mm.vfs.s.YS(r8)
            if (r2 == 0) goto L_0x000c
            boolean r2 = com.tencent.mm.modelvideo.r.isH265Video(r8)
            if (r2 == 0) goto L_0x000b
            goto L_0x000c
            switch-data {0->0x0022, 1->0x0024, 2->0x0024, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.e.K(int, java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int j(int r10, java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 362
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.e.j(int, java.lang.String, java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (com.tencent.mm.modelvideo.r.isH265Video(r8) != false) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int L(int r7, java.lang.String r8) {
        /*
            r6 = 126770(0x1ef32, float:1.77643E-40)
            r0 = 2
            r1 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            switch(r7) {
                case 0: goto L_0x0022;
                case 1: goto L_0x0024;
                case 2: goto L_0x0024;
                default: goto L_0x000b;
            }
        L_0x000b:
            r0 = r1
        L_0x000c:
            java.lang.String r2 = "MicroMsg.SubCoreVideoControl"
            java.lang.String r3 = "check story video format[%d]"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            r1[r4] = r5
            com.tencent.mm.sdk.platformtools.Log.i(r2, r3, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return r0
        L_0x0022:
            r0 = r1
            goto L_0x000c
        L_0x0024:
            r2 = 3
            boolean r2 = sX(r2)
            if (r2 == 0) goto L_0x000b
            boolean r2 = com.tencent.mm.vfs.s.YS(r8)
            if (r2 == 0) goto L_0x000c
            boolean r2 = com.tencent.mm.modelvideo.r.isH265Video(r8)
            if (r2 == 0) goto L_0x000b
            goto L_0x000c
            switch-data {0->0x0022, 1->0x0024, 2->0x0024, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.e.L(int, java.lang.String):int");
    }

    public static boolean bbn() {
        AppMethodBeat.i(126771);
        String str = null;
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100253");
        if (Fu.isValid()) {
            str = Fu.gzz().get("noCompleteRange");
        }
        if (Util.isNullOrNil(str)) {
            str = "20:00-23:30";
        }
        g.aAf();
        int ch = i.ch(com.tencent.mm.kernel.a.getUin(), 30);
        boolean ar = b.ar(str, ch);
        Log.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", Boolean.valueOf(ar), str, Integer.valueOf(ch));
        if (!ar) {
            AppMethodBeat.o(126771);
            return true;
        }
        AppMethodBeat.o(126771);
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x016d, code lost:
        if (com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG != false) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x017b, code lost:
        if (com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG != false) goto L_0x016f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean sX(int r11) {
        /*
        // Method dump skipped, instructions count: 408
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.e.sX(int):boolean");
    }

    public static boolean caG() {
        boolean z;
        AppMethodBeat.i(263553);
        boolean hWm = f.hWm();
        Log.i("MicroMsg.SubCoreVideoControl", "check device support hevcenc[%b]", Boolean.valueOf(hWm));
        if (!hWm) {
            Log.i("MicroMsg.SubCoreVideoControl", "no hevc encoder found!");
            AppMethodBeat.o(263553);
            return false;
        }
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_video_disable_h265_encoding, false);
        Log.i("MicroMsg.SubCoreVideoControl", "further check checkDeviceSupportHevcEnc bH265EncDisabled:%b ", Boolean.valueOf(a2));
        if (a2) {
            Log.i("MicroMsg.SubCoreVideoControl", "model %s is hit", Build.MODEL.toLowerCase());
            z = false;
        } else {
            z = true;
        }
        Log.i("MicroMsg.SubCoreVideoControl", "check checkDeviceSupportHevcEnc, scene:%s, configResult:%s", 5, Boolean.valueOf(z));
        AppMethodBeat.o(263553);
        return z;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        this.iSI = null;
        this.iSR = null;
        this.iSQ = null;
        this.iSJ = null;
        this.iSK = null;
    }
}
