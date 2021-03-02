package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.b.a.an;
import com.tencent.mm.g.b.a.ki;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.io.File;
import java.util.HashMap;

public class n implements bd {
    public HashMap<String, a> jrv = new HashMap<>();
    private IListener<mk> jrw = new IListener<mk>() {
        /* class com.tencent.mm.modelvideo.n.AnonymousClass3 */

        {
            AppMethodBeat.i(161758);
            this.__eventId = mk.class.getName().hashCode();
            AppMethodBeat.o(161758);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mk mkVar) {
            AppMethodBeat.i(126917);
            boolean a2 = a(mkVar);
            AppMethodBeat.o(126917);
            return a2;
        }

        private boolean a(mk mkVar) {
            String str;
            AppMethodBeat.i(126916);
            Log.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
            if (mkVar == null) {
                AppMethodBeat.o(126916);
                return false;
            }
            String str2 = mkVar.dRK.path;
            try {
                if (str2.endsWith(".tmp")) {
                    str2 = str2.substring(0, str2.lastIndexOf(".tmp"));
                    Log.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", str2, mkVar.dRK.path);
                }
                str = str2;
            } catch (Exception e2) {
                str = str2;
            }
            n nVar = n.this;
            String str3 = mkVar.dRK.dRL;
            String str4 = mkVar.dRK.dRM;
            int i2 = mkVar.dRK.dRN;
            String str5 = mkVar.dRK.fileId;
            String str6 = mkVar.dRK.dRP;
            long j2 = mkVar.dRK.startTime;
            long j3 = mkVar.dRK.endTime;
            g.aAk().postToWorker(new Runnable(str, mkVar.dRK.dRO, str3, str4, i2, str5, str6, j2, j3, mkVar.dRK.dRQ, mkVar.dRK.dRR, mkVar.dRK.dRS) {
                /* class com.tencent.mm.modelvideo.n.AnonymousClass2 */
                final /* synthetic */ String iBG;
                final /* synthetic */ String[] jrB;
                final /* synthetic */ String jrC;
                final /* synthetic */ int jrD;
                final /* synthetic */ String jrE;
                final /* synthetic */ String jrF;
                final /* synthetic */ long jrG;
                final /* synthetic */ int jrH;
                final /* synthetic */ int jrI;
                final /* synthetic */ String jrJ;
                final /* synthetic */ String val$path;
                final /* synthetic */ long val$startTime;

                {
                    this.val$path = r5;
                    this.jrB = r6;
                    this.iBG = r7;
                    this.jrC = r8;
                    this.jrD = r9;
                    this.jrE = r10;
                    this.jrF = r11;
                    this.val$startTime = r12;
                    this.jrG = r14;
                    this.jrH = r16;
                    this.jrI = r17;
                    this.jrJ = r18;
                }

                public final void run() {
                    AppMethodBeat.i(126915);
                    com.tencent.mm.plugin.sight.base.a aNx = e.aNx(this.val$path);
                    if (aNx == null) {
                        Log.w("MicroMsg.SubCoreMediaRpt", "get media info is null. %s", this.val$path);
                        AppMethodBeat.o(126915);
                        return;
                    }
                    int boW = (int) s.boW(this.val$path);
                    String str = null;
                    if (this.jrB != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (String str2 : this.jrB) {
                            stringBuffer.append(str2).append("|");
                        }
                        str = stringBuffer.toString();
                    }
                    int iOSOldNetType = NetStatusUtil.getIOSOldNetType(MMApplicationContext.getContext());
                    f.baR();
                    String NX = com.tencent.mm.an.a.NX(this.val$path);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(this.iBG).append(",").append(this.jrC).append(",");
                    stringBuffer2.append(this.jrD).append(",").append(this.jrE).append(",");
                    stringBuffer2.append(this.jrF).append(",").append(iOSOldNetType).append(",");
                    stringBuffer2.append(NX).append(",").append(this.val$startTime).append(",");
                    stringBuffer2.append(this.jrG).append(",").append(boW).append(",");
                    stringBuffer2.append(aNx.videoDuration).append(",").append(aNx.videoBitrate / 1000).append(",");
                    stringBuffer2.append(aNx.audioBitrate / 1000).append(",").append(aNx.frameRate).append(",");
                    stringBuffer2.append(aNx.width).append(",").append(aNx.height).append(",");
                    stringBuffer2.append(str).append(",").append(aNx.audioChannel).append(",");
                    stringBuffer2.append(this.jrH).append(",").append(this.jrI).append(",");
                    stringBuffer2.append(c.aTR(this.jrJ));
                    Log.i("MicroMsg.SubCoreMediaRpt", "download video rpt %s ", stringBuffer2.toString());
                    new an(stringBuffer2.toString()).bfK();
                    AppMethodBeat.o(126915);
                }
            });
            AppMethodBeat.o(126916);
            return false;
        }
    };

    public n() {
        AppMethodBeat.i(126918);
        EventCenter.instance.addListener(this.jrw);
        AppMethodBeat.o(126918);
    }

    public static n bhh() {
        AppMethodBeat.i(126919);
        n nVar = (n) y.at(n.class);
        AppMethodBeat.o(126919);
        return nVar;
    }

    public final int Qj(String str) {
        AppMethodBeat.i(240872);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(240872);
            return 0;
        }
        a aVar = this.jrv.get(str);
        if (aVar != null) {
            int i2 = aVar.jrO;
            AppMethodBeat.o(240872);
            return i2;
        }
        AppMethodBeat.o(240872);
        return 0;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i2, int i3) {
        AppMethodBeat.i(126920);
        a aVar = this.jrv.get(str2);
        if (aVar == null) {
            aVar = new a();
        }
        aVar.jrK = str;
        aVar.jrL = str2;
        aVar.toUser = str3;
        aVar.fqK = str4;
        aVar.jrM = str5;
        aVar.jrO = aVar.jrO != 0 ? aVar.jrO : i2;
        aVar.jrN = i3;
        aVar.startTime = Util.nowMilliSecond();
        this.jrv.put(str2, aVar);
        Log.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", str, str2, str3, str4, str5, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(126920);
    }

    public final void a(final d dVar, final String str, final String str2, final long j2) {
        AppMethodBeat.i(240873);
        if (dVar == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(240873);
            return;
        }
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelvideo.n.AnonymousClass1 */

            public final void run() {
                long j2;
                com.tencent.mm.plugin.sight.base.a aVar;
                AppMethodBeat.i(126914);
                a aVar2 = (a) n.this.jrv.remove(str);
                if (aVar2 == null) {
                    AppMethodBeat.o(126914);
                    return;
                }
                int boW = (int) s.boW(aVar2.jrL);
                com.tencent.mm.plugin.sight.base.a aNx = e.aNx(aVar2.jrL);
                if (!Util.isNullOrNil(aVar2.jrK)) {
                    com.tencent.mm.plugin.sight.base.a aNx2 = e.aNx(aVar2.jrK);
                    j2 = (long) ((int) s.boW(aVar2.jrK));
                    aVar = aNx2;
                } else {
                    j2 = (long) boW;
                    aVar = aNx;
                }
                if (aVar == null || aNx == null) {
                    Log.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", aVar2.jrL);
                    AppMethodBeat.o(126914);
                    return;
                }
                int iOSOldNetType = NetStatusUtil.getIOSOldNetType(MMApplicationContext.getContext());
                long j3 = dVar.field_startTime != 0 ? dVar.field_startTime : aVar2.startTime;
                long nowMilliSecond = dVar.field_endTime != 0 ? dVar.field_endTime : Util.nowMilliSecond();
                String str = null;
                if (dVar.field_usedSvrIps != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str2 : dVar.field_usedSvrIps) {
                        stringBuffer.append(str2).append("|");
                    }
                    str = stringBuffer.toString();
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(aVar2.toUser).append(",").append(aVar2.fqK).append(",");
                stringBuffer2.append(iOSOldNetType).append(",").append(dVar.field_fileId).append(",");
                stringBuffer2.append(dVar.field_mp4identifymd5).append(",").append(c.aTR(aVar2.jrM)).append(",");
                stringBuffer2.append(j3).append(",").append(nowMilliSecond).append(",");
                stringBuffer2.append(j2).append(",").append(aVar.videoDuration).append(",");
                stringBuffer2.append(aVar.videoBitrate / 1000).append(",").append(aVar.audioBitrate / 1000).append(",");
                stringBuffer2.append(aVar.frameRate).append(",").append(aVar.width).append(",");
                stringBuffer2.append(aVar.height).append(",").append(aVar2.jrN).append(",");
                stringBuffer2.append(boW).append(",").append(aNx.videoDuration).append(",");
                stringBuffer2.append(aNx.videoBitrate / 1000).append(",").append(aNx.audioBitrate / 1000).append(",");
                stringBuffer2.append(aNx.frameRate).append(",").append(aNx.width).append(",");
                stringBuffer2.append(aNx.height).append(",").append(aVar2.jrO).append(",");
                stringBuffer2.append(str).append(",").append(aVar.audioChannel).append(",").append(dVar.field_fileUrl);
                Log.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", stringBuffer2.toString());
                new ki(stringBuffer2.toString()).bfK();
                n.dz(aNx.videoBitrate, aVar2.jrO);
                if (aNx.Cir == 1) {
                    Log.i("MicroMsg.SubCoreMediaRpt", "ABA: New Path %s ", aVar2.jrL);
                    n.a(aNx, aVar2.jrO);
                }
                com.tencent.mm.plugin.multimediareport.d dVar = new com.tencent.mm.plugin.multimediareport.d();
                dVar.zGI = j2;
                dVar.zGJ = 2;
                dVar.source = 3;
                switch (aVar2.jrO) {
                    case 1:
                        dVar.source = 2;
                        break;
                    case 2:
                        dVar.source = 3;
                        break;
                    case 3:
                    default:
                        dVar.source = 1;
                        break;
                    case 4:
                        dVar.source = 3;
                        break;
                    case 5:
                        dVar.source = 2;
                        break;
                }
                if (!Util.isNullOrNil(aVar2.fqK)) {
                    dVar.source = 1;
                }
                dVar.pPz = aVar2.toUser;
                dVar.zGL = dVar.field_fileUrl;
                dVar.fileid = dVar.field_fileId;
                dVar.zGM = dVar.field_aesKey;
                dVar.md5 = dVar.field_filemd5;
                if (!Util.isNullOrNil(aVar2.jrK)) {
                    dVar.createtime = new File(aVar2.jrK).lastModified();
                } else {
                    dVar.createtime = aVar2.startTime;
                }
                dVar.zGN = aNx.width;
                dVar.zGO = aNx.height;
                dVar.hyI = aNx.frameRate;
                dVar.zGP = aNx.getVideoDuration();
                dVar.zGR = r.isH265Video(aVar2.jrL) ? "h265" : "h264";
                dVar.gTB = Util.isNullOrNil(dVar.field_thumbUrl) ? null : dVar.field_thumbUrl;
                dVar.zGS = "aac";
                dVar.zGQ = aNx.audioSampleRate;
                dVar.uuid = str2;
                int i2 = 1;
                if (Util.isNullOrNil(aVar2.toUser)) {
                    i2 = 3;
                } else if (ab.Eq(aVar2.toUser)) {
                    i2 = 2;
                }
                com.tencent.mm.plugin.multimediareport.g.a(dVar, i2, aVar2.startTime, aVar2.jrL);
                AppMethodBeat.o(126914);
            }
        });
        AppMethodBeat.o(240873);
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
    }

    public class a {
        public String dRP;
        public String fqK;
        public d jaC;
        public String jrK;
        public String jrL;
        public String jrM;
        public int jrN;
        public int jrO;
        public long startTime;
        public String toUser;

        public a() {
        }
    }

    static /* synthetic */ void dz(int i2, int i3) {
        int i4;
        int i5;
        AppMethodBeat.i(126922);
        switch (i3) {
            case 1:
                i4 = 101;
                i5 = 107;
                break;
            case 2:
                i4 = 111;
                i5 = 117;
                break;
            case 3:
            default:
                AppMethodBeat.o(126922);
                return;
            case 4:
                i4 = TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE;
                i5 = 137;
                break;
            case 5:
                i4 = 121;
                i5 = TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
                break;
        }
        int nullAsNil = Util.nullAsNil((Integer) com.tencent.mm.plugin.report.service.h.a(i2 / 1000, new int[]{350, 544, 800, 1200, 1600, 2000}, i4, i5));
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(422, (long) nullAsNil, 1, false);
        Log.i("MicroMsg.SubCoreMediaRpt", "rptIdkey [%d] bitrate [%d] sendScene [%d]", Integer.valueOf(nullAsNil), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(126922);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(com.tencent.mm.plugin.sight.base.a aVar, int i2) {
        AppMethodBeat.i(126923);
        if (aVar.Cir == 1) {
            int nullAsNil = Util.nullAsNil((Integer) com.tencent.mm.plugin.report.service.h.a(aVar.videoBitrate / 1000, new int[]{350, 544, 700, TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR, 1100, 1300, 1500, 1700, 1900, 2100}, 48, 58));
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1052, (long) nullAsNil, 1, false);
            Log.i("MicroMsg.SubCoreMediaRpt", "ABA: Using min and max qp limitation , video bitrate: [%d]  [%d] [%d]", Integer.valueOf(aVar.videoBitrate / 1000), Integer.valueOf(nullAsNil), Integer.valueOf(i2));
            switch (i2) {
                case 1:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1052, 59, 1, false);
                    AppMethodBeat.o(126923);
                    return;
                case 2:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1052, 60, 1, false);
                    AppMethodBeat.o(126923);
                    return;
                case 4:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1052, 61, 1, false);
                    AppMethodBeat.o(126923);
                    return;
                case 5:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1052, 62, 1, false);
                    AppMethodBeat.o(126923);
                    return;
                case 8:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1052, 63, 1, false);
                    break;
            }
        }
        AppMethodBeat.o(126923);
    }
}
