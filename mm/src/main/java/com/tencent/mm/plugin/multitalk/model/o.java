package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.appbrand.jsapi.p.v;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.multitalk.b.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.b;
import com.tencent.pb.talkroom.sdk.d;
import com.tencent.wcdb.FileUtils;
import com.tencent.wecall.talkroom.model.e;
import com.tencent.wxmm.v2helper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class o implements i {
    private c.a dzN = new c.a() {
        /* class com.tencent.mm.plugin.multitalk.model.o.AnonymousClass2 */

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            AppMethodBeat.i(114434);
            if (i2 <= 0) {
                Log.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
                AppMethodBeat.o(114434);
                return;
            }
            if (o.this.zMg != null) {
                o.this.zMg.ag(bArr, i2);
                if (o.f(o.aa(bArr, i2 / 2), i2 / 2) > 50.0d) {
                    o.this.zMf = false;
                    o.this.zMi = 0;
                    AppMethodBeat.o(114434);
                    return;
                }
                o.h(o.this);
                if (o.this.zMi >= 30) {
                    o.this.zMf = true;
                }
            }
            AppMethodBeat.o(114434);
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
            AppMethodBeat.i(114435);
            Log.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
            ac.eom();
            q.enR();
            AppMethodBeat.o(114435);
        }
    };
    private c qrH;
    public d zMd;
    private l zMe;
    private boolean zMf;
    private com.tencent.pb.talkroom.sdk.c zMg;
    private b zMh;
    private int zMi = 0;
    private com.tencent.mm.plugin.voip.model.b zMj = new com.tencent.mm.plugin.voip.model.b() {
        /* class com.tencent.mm.plugin.multitalk.model.o.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.voip.model.b
        public final int Q(byte[] bArr, int i2) {
            int i3;
            AppMethodBeat.i(114436);
            if (o.this.zMh != null) {
                i3 = o.this.zMh.af(bArr, i2);
            } else {
                i3 = 0;
            }
            if (i3 < 0) {
                AppMethodBeat.o(114436);
                return -1;
            }
            AppMethodBeat.o(114436);
            return 0;
        }
    };
    private MTimerHandler zMk;
    public volatile HashMap<String, Integer> zMl = new HashMap<>();

    static /* synthetic */ int h(o oVar) {
        int i2 = oVar.zMi;
        oVar.zMi = i2 + 1;
        return i2;
    }

    public final d emG() {
        return this.zMd;
    }

    public o() {
        AppMethodBeat.i(114437);
        Log.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
        Context context = MMApplicationContext.getContext();
        e hrb = e.hrb();
        e.lw(context);
        this.zMd = hrb;
        this.zMd.hjt();
        this.zMe = new l();
        int nullAsNil = Util.nullAsNil((Integer) g.aAh().hqB.get(1));
        this.zMd.a(ac.eom(), new com.tencent.pb.talkroom.sdk.e() {
            /* class com.tencent.mm.plugin.multitalk.model.o.AnonymousClass1 */

            @Override // com.tencent.pb.talkroom.sdk.e
            public final boolean H(int i2, String str, String str2) {
                AppMethodBeat.i(114420);
                o.G(i2, str, str2);
                AppMethodBeat.o(114420);
                return false;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final boolean d(int i2, int i3, byte[] bArr) {
                AppMethodBeat.i(114421);
                Log.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + i2 + " cmdid " + i3);
                g.azz().a(new y(i2, i3, bArr), 0);
                AppMethodBeat.o(114421);
                return false;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final boolean emM() {
                AppMethodBeat.i(114422);
                Log.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(m.aon())));
                o.class.getClassLoader();
                j.Ed("voipMain");
                AppMethodBeat.o(114422);
                return true;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final int aon() {
                AppMethodBeat.i(114423);
                int aon = m.aon();
                AppMethodBeat.o(114423);
                return aon;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final int emN() {
                AppMethodBeat.i(239354);
                int i2 = 2;
                if (k.aFU("video/avc")) {
                    i2 = 10;
                }
                Log.i("MicroMsg.MT.MultiTalkEngine", "CodecList[%d]", Integer.valueOf(i2));
                AppMethodBeat.o(239354);
                return i2;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final int emO() {
                AppMethodBeat.i(114424);
                String gEu = g.aAh().azR().gEu();
                ae.DV(gEu);
                Log.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(gEu)));
                o.a(o.this);
                AppMethodBeat.o(114424);
                return 0;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final boolean rB(boolean z) {
                AppMethodBeat.i(114425);
                Log.printInfoStack("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", Boolean.valueOf(z));
                if (ac.eom().zMV != null) {
                    ac.eom().zMV.rs(z);
                }
                AppMethodBeat.o(114425);
                return true;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final int a(int i2, int i3, b bVar) {
                AppMethodBeat.i(114426);
                o.this.zMh = bVar;
                int a2 = o.this.zMe.a(o.this.zMj, i2, i3);
                o.this.emK();
                Log.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", Boolean.valueOf(a.isSpeakerphoneOn()), Boolean.valueOf(ac.eom().mkd));
                if (!(a.isSpeakerphoneOn() == ac.eom().mkd || !ac.eom().czl() || ac.eom().zMV == null)) {
                    ac.eom().zMV.rs(ac.eom().mkd);
                }
                AppMethodBeat.o(114426);
                return a2;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final int a(int i2, int i3, com.tencent.pb.talkroom.sdk.c cVar) {
                AppMethodBeat.i(114427);
                o.this.zMg = cVar;
                o.this.qrH = new c(i2, 1, 7);
                o.this.qrH.jk(i3);
                o.this.qrH.dd(true);
                o.this.qrH.aag();
                o.this.qrH.dzk = -19;
                o.this.qrH.x(1, false);
                o.this.qrH.dc(true);
                o.this.qrH.dzv = o.this.dzN;
                if (o.this.qrH.aai()) {
                    AppMethodBeat.o(114427);
                    return 1;
                }
                AppMethodBeat.o(114427);
                return -1;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final boolean emP() {
                AppMethodBeat.i(114428);
                Log.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
                l lVar = o.this.zMe;
                synchronized (lVar.qrY) {
                    try {
                        Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", Boolean.valueOf(lVar.isStart), Integer.valueOf(lVar.hashCode()));
                        if (lVar.isStart) {
                            com.tencent.mm.plugin.voip.model.c cVar = lVar.qrz;
                            if (cVar != null) {
                                lVar.qsa.gLm = SystemClock.elapsedRealtime();
                                cVar.fFr();
                                Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + lVar.qsa.apr());
                                cVar.fFo();
                                lVar.isStart = false;
                                lVar.qrz = null;
                            }
                            if (ac.eom().zMV != null) {
                                ac.eom().zMV.elB();
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(114428);
                        throw th;
                    }
                }
                o.this.emL();
                AppMethodBeat.o(114428);
                return true;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final boolean emQ() {
                AppMethodBeat.i(114429);
                Log.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
                try {
                    if (o.this.qrH != null) {
                        o.this.qrH.dzv = null;
                        o.this.qrH.ZZ();
                    }
                    o.this.qrH = null;
                    AppMethodBeat.o(114429);
                    return true;
                } catch (Exception e2) {
                    Log.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :".concat(String.valueOf(e2)));
                    AppMethodBeat.o(114429);
                    return false;
                }
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final int emR() {
                com.tencent.mm.plugin.voip.model.c cVar;
                int i2 = 0;
                AppMethodBeat.i(114430);
                Log.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
                if (!(o.this.zMe == null || ac.eom().zMV == null || (cVar = ac.eom().zMV.zHb) == null)) {
                    i2 = cVar.bhV();
                }
                int streamVolume = (int) ((((float) a.getStreamVolume(i2)) / ((float) a.getStreamMaxVolume(i2))) * 100.0f);
                AppMethodBeat.o(114430);
                return streamVolume;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final int emS() {
                AppMethodBeat.i(114431);
                Log.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
                if (o.this.qrH != null) {
                    int aal = o.this.qrH.aal();
                    AppMethodBeat.o(114431);
                    return aal;
                }
                AppMethodBeat.o(114431);
                return -2;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final int emT() {
                AppMethodBeat.i(114432);
                Log.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
                if (o.this.qrH != null) {
                    int i2 = o.this.qrH.dyZ;
                    AppMethodBeat.o(114432);
                    return i2;
                }
                AppMethodBeat.o(114432);
                return 0;
            }

            @Override // com.tencent.pb.talkroom.sdk.e
            public final int emU() {
                AppMethodBeat.i(114433);
                Log.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
                if (o.this.zMe == null || ac.eom().zMV == null) {
                    AppMethodBeat.o(114433);
                    return 0;
                }
                com.tencent.mm.plugin.voip.model.c cVar = ac.eom().zMV.zHb;
                if (cVar != null) {
                    int fFs = cVar.fFs();
                    AppMethodBeat.o(114433);
                    return fFs;
                }
                AppMethodBeat.o(114433);
                return 0;
            }
        });
        this.zMd.dr(nullAsNil, z.aTY());
        g.azz().a(1918, this);
        g.azz().a(1919, this);
        g.azz().a(1927, this);
        g.azz().a(1928, this);
        g.azz().a(1929, this);
        g.azz().a(1931, this);
        g.azz().a(1932, this);
        g.azz().a(1933, this);
        g.azz().a(1935, this);
        g.azz().a(1937, this);
        g.azz().a(1938, this);
        g.azz().a(1939, this);
        AppMethodBeat.o(114437);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(114438);
        y yVar = (y) qVar;
        Log.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + i2 + " errCode " + i3 + " cmdid " + yVar.mCmdId);
        this.zMd.d(i3, yVar.rxu, yVar.mCmdId, yVar.efs);
        AppMethodBeat.o(114438);
    }

    public final List<String> emH() {
        AppMethodBeat.i(239356);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Integer> entry : this.zMl.entrySet()) {
            arrayList.add(entry.getKey());
        }
        AppMethodBeat.o(239356);
        return arrayList;
    }

    public final void emI() {
        AppMethodBeat.i(239357);
        this.zMl = new HashMap<>();
        AppMethodBeat.o(239357);
    }

    public final String emJ() {
        AppMethodBeat.i(239358);
        Map.Entry<String, Integer> entry = null;
        for (Map.Entry<String, Integer> entry2 : this.zMl.entrySet()) {
            if (!entry2.getKey().equals(null)) {
                if (entry == null) {
                    entry = entry2;
                } else {
                    if (entry.getValue().intValue() >= entry2.getValue().intValue()) {
                        entry2 = entry;
                    }
                    entry = entry2;
                }
            }
        }
        if (entry != null) {
            String key = entry.getKey();
            AppMethodBeat.o(239358);
            return key;
        }
        AppMethodBeat.o(239358);
        return null;
    }

    public final void emK() {
        AppMethodBeat.i(239359);
        if (this.zMk != null) {
            this.zMk.stopTimer();
            this.zMk.quitSafely();
            this.zMk.removeCallbacksAndMessages(null);
        }
        this.zMk = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.multitalk.model.o.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(239355);
                o.k(o.this);
                AppMethodBeat.o(239355);
                return true;
            }
        }, true);
        this.zMk.startTimer(33);
        AppMethodBeat.o(239359);
    }

    public final void emL() {
        AppMethodBeat.i(239360);
        if (this.zMk != null) {
            this.zMk.stopTimer();
            this.zMk.quitSafely();
            this.zMk.removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(239360);
    }

    public final void ry(boolean z) {
        AppMethodBeat.i(114439);
        byte[] bArr = new byte[1];
        bArr[0] = (byte) (z ? 1 : 0);
        boolean ens = ac.eom().ens();
        Log.printInfoStack("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s, isILinkMode, %s", Boolean.valueOf(z), Boolean.valueOf(ens));
        if (ens) {
            p pVar = p.INSTANCE;
            p.f(425, bArr, 1);
        } else {
            this.zMd.setAppCmd(425, bArr, 1);
        }
        if (z) {
            if (ens) {
                if (a.cdW()) {
                    p pVar2 = p.INSTANCE;
                    p.f(JsApiQueryDownloadTask.CTRL_INDEX, bArr, 1);
                }
                if (a.ceb()) {
                    p pVar3 = p.INSTANCE;
                    p.f(JsApiInstallDownloadTask.CTRL_INDEX, bArr, 1);
                    AppMethodBeat.o(114439);
                    return;
                }
            } else {
                if (a.cdW()) {
                    this.zMd.setAppCmd(JsApiQueryDownloadTask.CTRL_INDEX, bArr, 1);
                }
                if (a.ceb()) {
                    this.zMd.setAppCmd(JsApiInstallDownloadTask.CTRL_INDEX, bArr, 1);
                    AppMethodBeat.o(114439);
                    return;
                }
            }
        } else if (ens) {
            p pVar4 = p.INSTANCE;
            p.f(JsApiQueryDownloadTask.CTRL_INDEX, bArr, 1);
            p pVar5 = p.INSTANCE;
            p.f(JsApiInstallDownloadTask.CTRL_INDEX, bArr, 1);
            AppMethodBeat.o(114439);
            return;
        } else {
            this.zMd.setAppCmd(JsApiQueryDownloadTask.CTRL_INDEX, bArr, 1);
            this.zMd.setAppCmd(JsApiInstallDownloadTask.CTRL_INDEX, bArr, 1);
        }
        AppMethodBeat.o(114439);
    }

    public final void rz(boolean z) {
        AppMethodBeat.i(239361);
        byte[] bArr = new byte[1];
        boolean ens = ac.eom().ens();
        Log.printDebugStack("MicroMsg.MT.MultiTalkEngine", "qipengfeng, setEngineSpeakerOn, %s, isILinkMode, %s", Boolean.valueOf(z), Boolean.valueOf(ens));
        if (z) {
            bArr[0] = 1;
            if (ens) {
                p pVar = p.INSTANCE;
                p.f(401, bArr, 1);
                AppMethodBeat.o(239361);
                return;
            }
            this.zMd.setAppCmd(401, bArr, 1);
            AppMethodBeat.o(239361);
            return;
        }
        bArr[0] = 0;
        if (ens) {
            p pVar2 = p.INSTANCE;
            p.f(402, bArr, 1);
            AppMethodBeat.o(239361);
            return;
        }
        this.zMd.setAppCmd(402, bArr, 1);
        AppMethodBeat.o(239361);
    }

    public final void rA(boolean z) {
        AppMethodBeat.i(239362);
        byte[] bArr = new byte[1];
        boolean ens = ac.eom().ens();
        Log.printDebugStack("MicroMsg.MT.MultiTalkEngine", "setEngineMicOn, %s, isILinkMode, %s", Boolean.valueOf(z), Boolean.valueOf(ens));
        if (z) {
            bArr[0] = 1;
            if (ens) {
                p pVar = p.INSTANCE;
                p.f(413, bArr, 1);
                AppMethodBeat.o(239362);
                return;
            }
            this.zMd.setAppCmd(413, bArr, 1);
            AppMethodBeat.o(239362);
            return;
        }
        bArr[0] = 0;
        if (ens) {
            p pVar2 = p.INSTANCE;
            p.f(412, bArr, 1);
            AppMethodBeat.o(239362);
            return;
        }
        this.zMd.setAppCmd(412, bArr, 1);
        AppMethodBeat.o(239362);
    }

    public final boolean elC() {
        return this.zMf;
    }

    static /* synthetic */ void G(int i2, String str, String str2) {
        AppMethodBeat.i(114440);
        switch (i2) {
            case 0:
                Log.v(str, str2);
                AppMethodBeat.o(114440);
                return;
            case 1:
                Log.d(str, str2);
                AppMethodBeat.o(114440);
                return;
            case 2:
                Log.i(str, str2);
                AppMethodBeat.o(114440);
                return;
            case 3:
                Log.w(str, str2);
                AppMethodBeat.o(114440);
                return;
            case 4:
                Log.e(str, str2);
                AppMethodBeat.o(114440);
                return;
            case 5:
                Log.f(str, str2);
                AppMethodBeat.o(114440);
                return;
            default:
                Log.v(str, str2);
                AppMethodBeat.o(114440);
                return;
        }
    }

    static /* synthetic */ void a(o oVar) {
        AppMethodBeat.i(114441);
        byte[] bArr = {0};
        byte[] bArr2 = new byte[2];
        if (ae.gKu.gEo >= 0) {
            bArr2[0] = (byte) ae.gKu.gEo;
            oVar.zMd.setAppCmd(406, bArr2, 1);
        } else if (ae.gKu.gEo == -2) {
            oVar.zMd.setAppCmd(407, bArr, 1);
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt_agc_params, -1);
        Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, x_agc_paras = %d", Integer.valueOf(a2));
        if (a2 > 0) {
            byte b2 = (byte) (a2 & 1);
            Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, agc_switch = %d", Byte.valueOf(b2));
            if (b2 > 0) {
                byte[] bArr3 = {(byte) ((a2 >> 1) & 31), (byte) ((a2 >> 6) & 31), (byte) ((a2 >> 11) & 3), (byte) ((a2 >> 13) & 3), (byte) ((a2 >> 15) & 1), (byte) ((a2 >> 16) & 7), (byte) ((a2 >> 19) & 15)};
                Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, agc para: %d, %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr3[0]), Byte.valueOf(bArr3[1]), Byte.valueOf(bArr3[2]), Byte.valueOf(bArr3[3]), Byte.valueOf(bArr3[4]), Byte.valueOf(bArr3[5]), Byte.valueOf(bArr3[6]));
                oVar.zMd.setAppCmd(404, bArr3, 7);
            } else {
                oVar.zMd.setAppCmd(405, bArr, 1);
            }
        }
        if (ae.gKu.gEt >= 0) {
            byte[] bArr4 = new byte[7];
            if (ae.gKu.gEu >= 0 && ae.gKu.gEv >= 0) {
                bArr4[0] = (byte) ae.gKu.gEu;
                bArr4[1] = (byte) ae.gKu.gEv;
                if (ae.gKu.gEw >= 0) {
                    bArr4[2] = (byte) ae.gKu.gEw;
                    bArr4[3] = (byte) ae.gKu.gEt;
                    bArr4[4] = (byte) ae.gKu.gEx;
                    bArr4[5] = (byte) ae.gKu.gEy;
                    bArr4[6] = (byte) ae.gKu.gEz;
                    oVar.zMd.setAppCmd(404, bArr4, 7);
                } else {
                    oVar.zMd.setAppCmd(404, bArr4, 2);
                }
            }
        } else if (ae.gKu.gEt == -2) {
            oVar.zMd.setAppCmd(405, bArr, 1);
        }
        long a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt_wave_agc, -1L);
        Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, x-expt settings, wave_agc_paras: %d", Long.valueOf(a3));
        if (a3 > -1) {
            byte[] bArr5 = new byte[11];
            bArr5[0] = (byte) ((int) (3 & a3));
            Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, x-expt settings, wave agc mode: %d", Byte.valueOf(bArr5[0]));
            if (bArr5[0] == 1) {
                bArr5[1] = (byte) ((int) ((a3 >> 2) & 31));
                bArr5[2] = (byte) ((int) ((a3 >> 7) & 31));
                bArr5[3] = (byte) ((int) ((a3 >> 12) & 31));
                bArr5[4] = (byte) ((int) ((a3 >> 17) & 31));
                bArr5[5] = (byte) ((int) ((a3 >> 22) & 15));
                bArr5[6] = (byte) ((int) ((a3 >> 26) & 15));
                bArr5[7] = (byte) ((int) ((a3 >> 30) & 1));
                bArr5[8] = (byte) ((int) ((a3 >> 31) & 31));
                bArr5[9] = (byte) ((int) ((a3 >> 36) & 31));
                bArr5[10] = (byte) ((int) ((a3 >> 41) & 31));
                oVar.zMd.setAppCmd(461, bArr5, 11);
                Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr5[1]), Byte.valueOf(bArr5[2]), Byte.valueOf(bArr5[3]), Byte.valueOf(bArr5[4]), Byte.valueOf(bArr5[5]), Byte.valueOf(bArr5[6]), Byte.valueOf(bArr5[7]), Byte.valueOf(bArr5[8]), Byte.valueOf(bArr5[9]), Byte.valueOf(bArr5[10]));
            } else if (bArr5[0] == 2) {
                bArr5[1] = (byte) ((int) ((a3 >> 2) & 31));
                bArr5[2] = (byte) ((int) ((a3 >> 7) & 31));
                bArr5[3] = (byte) ((int) ((a3 >> 12) & 31));
                bArr5[4] = (byte) ((int) ((a3 >> 17) & 31));
                bArr5[5] = (byte) ((int) ((a3 >> 22) & 15));
                bArr5[6] = (byte) ((int) ((a3 >> 26) & 15));
                oVar.zMd.setAppCmd(461, bArr5, 7);
                Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr5[1]), Byte.valueOf(bArr5[2]), Byte.valueOf(bArr5[3]), Byte.valueOf(bArr5[4]), Byte.valueOf(bArr5[5]), Byte.valueOf(bArr5[6]));
            } else if (bArr5[0] == 0) {
                oVar.zMd.setAppCmd(462, bArr5, 1);
            }
        }
        Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, device-model config, SrvDeviceInfo.mAudioInfo.waveAgcMode: %d", Integer.valueOf(ae.gKu.gEA));
        if (ae.gKu.gEA >= 0) {
            byte[] bArr6 = new byte[11];
            bArr6[0] = (byte) ae.gKu.gEA;
            if (bArr6[0] == 1) {
                bArr6[1] = (byte) ae.gKu.gEH;
                bArr6[2] = (byte) ae.gKu.gEI;
                bArr6[3] = (byte) ae.gKu.gEJ;
                bArr6[4] = (byte) ae.gKu.gEE;
                bArr6[5] = (byte) ae.gKu.gEF;
                bArr6[6] = (byte) ae.gKu.gEG;
                bArr6[7] = (byte) ae.gKu.gEK;
                bArr6[8] = (byte) ae.gKu.gEB;
                bArr6[9] = (byte) ae.gKu.gEC;
                bArr6[10] = (byte) ae.gKu.gED;
                oVar.zMd.setAppCmd(461, bArr6, 11);
                Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr6[1]), Byte.valueOf(bArr6[2]), Byte.valueOf(bArr6[3]), Byte.valueOf(bArr6[4]), Byte.valueOf(bArr6[5]), Byte.valueOf(bArr6[6]), Byte.valueOf(bArr6[7]), Byte.valueOf(bArr6[8]), Byte.valueOf(bArr6[9]), Byte.valueOf(bArr6[10]));
            } else if (bArr6[0] == 2) {
                bArr6[1] = (byte) ae.gKu.gEB;
                bArr6[2] = (byte) ae.gKu.gEC;
                bArr6[3] = (byte) ae.gKu.gED;
                bArr6[4] = (byte) ae.gKu.gEE;
                bArr6[5] = (byte) ae.gKu.gEF;
                bArr6[6] = (byte) ae.gKu.gEG;
                oVar.zMd.setAppCmd(461, bArr6, 7);
                Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr6[1]), Byte.valueOf(bArr6[2]), Byte.valueOf(bArr6[3]), Byte.valueOf(bArr6[4]), Byte.valueOf(bArr6[5]), Byte.valueOf(bArr6[6]));
            } else if (bArr6[0] == 0) {
                oVar.zMd.setAppCmd(462, bArr6, 1);
            }
        }
        int a4 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multiparty_rnn_value, 1002);
        if (a4 > 0) {
            oVar.zMd.setAppCmd(408, new byte[]{(byte) (a4 & 255), (byte) ((a4 >> 8) & 255), (byte) ((a4 >> 16) & 255), (byte) ((a4 >> 24) & 255)}, 4);
        } else if (a4 == 0) {
            bArr[0] = (byte) (a4 & 255);
            oVar.zMd.setAppCmd(409, bArr, 1);
        }
        int i2 = ae.gKu.gEq;
        Log.i("MicroMsg.MT.MultiTalkEngine", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNewMulti %d", Integer.valueOf(i2));
        if (ae.gKu.gEq >= 0) {
            if (i2 > 0) {
                int floor = ((int) Math.floor(((double) i2) / 1000.0d)) % 100;
                Log.i("MicroMsg.MT.MultiTalkEngine", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", Integer.valueOf(floor));
                if (floor > 0) {
                    oVar.zMd.setAppCmd(408, new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)}, 4);
                }
            } else if (i2 == 0) {
                bArr[0] = (byte) (i2 & 255);
                oVar.zMd.setAppCmd(409, bArr, 1);
            }
        } else if (ae.gKu.gEq == -2) {
            bArr[0] = (byte) (i2 & 255);
            oVar.zMd.setAppCmd(409, bArr, 1);
        }
        if (ae.gKu.gEP[0] > 0 || ae.gKu.gEP[1] > 0) {
            bArr2[0] = 0;
            bArr2[1] = 0;
            if (ae.gKu.gEP[0] > 0 && ae.gKu.gEP[0] < 10000) {
                bArr2[0] = (byte) ae.gKu.gEP[0];
            }
            if (ae.gKu.gEP[1] > 0 && ae.gKu.gEP[1] < 10000) {
                bArr2[1] = (byte) ae.gKu.gEP[1];
            }
            oVar.zMd.setAppCmd(v2helper.EMethodSetNgStrength, bArr2, 2);
        }
        if (ae.gKu.gDN >= 0 || ae.gKu.gDP >= 0) {
            bArr2[0] = -1;
            bArr2[1] = -1;
            if (ae.gKu.gDN >= 0) {
                bArr2[0] = (byte) ae.gKu.gDN;
            }
            if (ae.gKu.gDP >= 0) {
                bArr2[1] = (byte) ae.gKu.gDP;
            }
            oVar.zMd.setAppCmd(414, bArr2, 2);
        }
        if (ae.gKu.gDO >= 0 || ae.gKu.gDQ >= 0) {
            bArr2[0] = -1;
            bArr2[1] = -1;
            if (ae.gKu.gDO >= 0) {
                bArr2[0] = (byte) ae.gKu.gDO;
            }
            if (ae.gKu.gDQ >= 0) {
                bArr2[1] = (byte) ae.gKu.gDQ;
            }
            oVar.zMd.setAppCmd(415, bArr2, 2);
        }
        if (ae.gKu.gDR >= 0 || ae.gKu.gDS >= 0) {
            bArr2[0] = -1;
            bArr2[1] = -1;
            if (ae.gKu.gDR >= 0) {
                bArr2[0] = (byte) ae.gKu.gDR;
            }
            if (ae.gKu.gDS >= 0) {
                bArr2[1] = (byte) ae.gKu.gDS;
            }
            oVar.zMd.setAppCmd(v2helper.EMethodOutputVolumeGainEnable, bArr2, 2);
        }
        if (ae.gKu.gDX >= 0) {
            bArr2[0] = (byte) ae.gKu.gDX;
            oVar.zMd.setAppCmd(416, bArr2, 1);
        }
        if (ae.gKu.gDY >= 0 && ae.gKu.gDY != 5) {
            bArr2[0] = (byte) ae.gKu.gDY;
            oVar.zMd.setAppCmd(417, bArr2, 1);
        }
        if (ae.gKu.gDZ >= 0 && ae.gKu.gDZ != 5) {
            bArr2[0] = (byte) ae.gKu.gDZ;
            oVar.zMd.setAppCmd(418, bArr2, 1);
        }
        if (ae.gKu.gEa >= 0) {
            bArr2[0] = (byte) ae.gKu.gEa;
            oVar.zMd.setAppCmd(419, bArr2, 1);
        }
        if (1 == ae.gKu.gEN) {
            byte[] bArr7 = new byte[30];
            for (int i3 = 0; i3 < 15; i3++) {
                bArr7[i3 * 2] = (byte) (ae.gKu.gEO[i3] & 255);
                bArr7[(i3 * 2) + 1] = (byte) ((ae.gKu.gEO[i3] >> 8) & 255);
            }
            oVar.zMd.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOn, bArr7, 30);
        }
        if (ae.gKu.gEN == 0) {
            oVar.zMd.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOff, bArr, 1);
        }
        if (ae.gKu.gER > 0) {
            bArr2[0] = (byte) ae.gKu.gER;
            oVar.zMd.setAppCmd(v2helper.EMethodSetSpkEnhance, bArr2, 1);
        }
        if (ae.gKu.gEb > 0) {
            bArr2[0] = (byte) ae.gKu.gEb;
            oVar.zMd.setAppCmd(431, bArr2, 4);
        }
        int a5 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt_agcrx_params, -1);
        Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, x_agcrx_paras: %d", Integer.valueOf(a5));
        if (a5 > 0) {
            byte b3 = (byte) (a5 & 1);
            Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, agcrx_switch: %d", Byte.valueOf(b3));
            if (b3 > 0) {
                byte[] bArr8 = {(byte) ((a5 >> 1) & 3), (byte) ((a5 >> 3) & 31), (byte) ((a5 >> 8) & 31), (byte) ((a5 >> 13) & 1)};
                oVar.zMd.setAppCmd(v2helper.EMethodSetAgcRxOn, bArr8, 4);
                Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, agc rx para: %d, %d, %d, %d", Byte.valueOf(bArr8[0]), Byte.valueOf(bArr8[1]), Byte.valueOf(bArr8[2]), Byte.valueOf(bArr8[3]));
            }
        }
        if (ae.gKu.gEZ >= 0) {
            oVar.zMd.setAppCmd(v2helper.EMethodSetAgcRxOn, new byte[]{(byte) ae.gKu.gEZ, (byte) ae.gKu.gFa, (byte) ae.gKu.gFb, (byte) ae.gKu.gFc}, 4);
        }
        int a6 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_play_fadeinfadeout_switch, -1);
        Log.i("MicroMsg.MT.MultiTalkEngine", "kerrizhang, multi_play_fadeinfadeout_switch = %d", Integer.valueOf(a6));
        byte[] bArr9 = {0};
        if (a6 > 0) {
            bArr9[0] = (byte) a6;
        }
        oVar.zMd.setAppCmd(451, bArr9, 1);
        int a7 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_play_fadeinfadeout_thresh, -1);
        Log.i("MicroMsg.MT.MultiTalkEngine", "kerrizhang, multi_play_fadeinfadeout_thresh = %d", Integer.valueOf(a7));
        bArr9[0] = 0;
        if (a7 > 0) {
            bArr9[0] = (byte) a7;
        }
        oVar.zMd.setAppCmd(452, bArr9, 1);
        long[] jArr = {((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_activerangecnt, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange1, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange2, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange3, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange4, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange5, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange6, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange7, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange8, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange9, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange10, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange11, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange12, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange13, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange14, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange15, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange16, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange17, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange18, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange19, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange20, -1L)};
        ByteBuffer order = ByteBuffer.allocate(168).order(ByteOrder.LITTLE_ENDIAN);
        order.asLongBuffer().put(jArr);
        byte[] array = order.array();
        Log.i("MicroMsg.MT.MultiTalkEngine", "kerrizhang, multi_loss_control[0] %d,multi_loss_control[1] %d multi_loss_control[2] %d", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]), Long.valueOf(jArr[2]));
        oVar.zMd.setAppCmd(u.CTRL_INDEX, array, array.length);
        int a8 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_rcnnvadctr, -1);
        Log.i("MicroMsg.MT.MultiTalkEngine", "kerrizhang, rcnnvad_switch = %d", Integer.valueOf(a8));
        if (a8 > 0) {
            oVar.zMd.setAppCmd(v.CTRL_INDEX, new byte[]{(byte) a8}, 1);
        }
        int a9 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_aec_value, 0);
        Log.i("MicroMsg.MT.MultiTalkEngine", "dennyliang, voip aec_value = %d", Integer.valueOf(a9));
        if (a9 > 0) {
            oVar.zMd.setAppCmd(460, new byte[]{(byte) (a9 & 255), (byte) ((a9 >> 8) & 255), (byte) ((a9 >> 16) & 255), (byte) ((a9 >> 24) & 255)}, 4);
        }
        int a10 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_frz_sta_peroid, -1);
        Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, updateAudioAdaption, frz_sta_p_x = %d", Integer.valueOf(a10));
        if (a10 > 0) {
            oVar.zMd.setAppCmd(com.tencent.mm.plugin.appbrand.jsapi.share.u.CTRL_INDEX, new byte[]{(byte) (a10 & 255), (byte) ((a10 >> 8) & 255), (byte) ((a10 >> 16) & 255), (byte) ((a10 >> 24) & 255)}, 4);
        }
        int a11 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_engine_get_data_config, -1);
        Log.i("MicroMsg.MT.MultiTalkEngine", "qipengfeng, updateAudioAdaption, switch_flag_x = %d", Integer.valueOf(a11));
        byte[] bArr10 = {0};
        if (a11 > 0) {
            bArr10[0] = 1;
        }
        oVar.zMd.setAppCmd(450, bArr10, 1);
        int a12 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_flag, -1);
        int i4 = ae.gKu.gFd;
        Log.d("MicroMsg.MT.MultiTalkEngine", "MT3D, updateAudioAdaption, mt3d_flag_x = %d", Integer.valueOf(a12));
        Log.d("MicroMsg.MT.MultiTalkEngine", "MT3D, updateAudioAdaption, mt3d_flag_s = %d", Integer.valueOf(i4));
        byte[] bArr11 = {0};
        if (a12 > 0 && i4 > 0) {
            bArr11[0] = 1;
            byte[] bArr12 = new byte[76];
            int[] iArr = {((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_azim1, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_azim2, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_azim3, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_azim4, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_azim5, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_azim6, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_azim7, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_azim8, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_elvl1, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_elvl2, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_elvl3, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_elvl4, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_elvl5, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_elvl6, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_elvl7, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_elvl8, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_phi, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_theta1, -1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt3d_theta2, -1)};
            int i5 = ae.gKu.gFe;
            if (i5 >= 0) {
                iArr[0] = (short) i5;
            }
            int i6 = ae.gKu.gFf;
            if (i6 >= 0) {
                iArr[1] = (short) i6;
            }
            int i7 = ae.gKu.gFg;
            if (i7 >= 0) {
                iArr[2] = (short) i7;
            }
            int i8 = ae.gKu.gFh;
            if (i8 >= 0) {
                iArr[3] = (short) i8;
            }
            int i9 = ae.gKu.gFi;
            if (i9 >= 0) {
                iArr[4] = (short) i9;
            }
            int i10 = ae.gKu.gFj;
            if (i10 >= 0) {
                iArr[5] = (short) i10;
            }
            int i11 = ae.gKu.gFk;
            if (i11 >= 0) {
                iArr[6] = (short) i11;
            }
            int i12 = ae.gKu.gFl;
            if (i12 >= 0) {
                iArr[7] = (short) i12;
            }
            int i13 = ae.gKu.gFm;
            if (i13 >= 0) {
                iArr[8] = (short) i13;
            }
            int i14 = ae.gKu.gFn;
            if (i14 >= 0) {
                iArr[9] = (short) i14;
            }
            int i15 = ae.gKu.gFo;
            if (i15 >= 0) {
                iArr[10] = (short) i15;
            }
            int i16 = ae.gKu.gFp;
            if (i16 >= 0) {
                iArr[11] = (short) i16;
            }
            int i17 = ae.gKu.gFq;
            if (i17 >= 0) {
                iArr[12] = (short) i17;
            }
            int i18 = ae.gKu.gFr;
            if (i18 >= 0) {
                iArr[13] = (short) i18;
            }
            int i19 = ae.gKu.gFs;
            if (i19 >= 0) {
                iArr[14] = (short) i19;
            }
            int i20 = ae.gKu.gFt;
            if (i20 >= 0) {
                iArr[15] = (short) i20;
            }
            int i21 = ae.gKu.gFu;
            if (i21 >= 0) {
                iArr[16] = (short) i21;
            }
            int i22 = ae.gKu.gFv;
            if (i22 >= 0) {
                iArr[17] = (short) i22;
            }
            int i23 = ae.gKu.gFw;
            if (i23 >= 0) {
                iArr[18] = (short) i23;
            }
            for (int i24 = 0; i24 < 19; i24++) {
                bArr12[(i24 * 4) + 0] = (byte) (iArr[i24] & 255);
                bArr12[(i24 * 4) + 1] = (byte) ((iArr[i24] >> 8) & 255);
                bArr12[(i24 * 4) + 2] = (byte) ((iArr[i24] >> 16) & 255);
                bArr12[(i24 * 4) + 3] = (byte) ((iArr[i24] >> 24) & 255);
            }
            oVar.zMd.setAppCmd(447, bArr12, 19);
        }
        oVar.zMd.setAppCmd(446, bArr11, 1);
        if (oVar.zMe != null) {
            byte[] bArr13 = new byte[1];
            l lVar = oVar.zMe;
            if (2 == (lVar.qrz != null ? lVar.qrz.GTg : -1)) {
                bArr13[0] = 1;
                oVar.zMd.setAppCmd(FileUtils.S_IRWXU, bArr13, 1);
            }
        }
        AppMethodBeat.o(114441);
    }

    static /* synthetic */ short[] aa(byte[] bArr, int i2) {
        short[] sArr = new short[i2];
        for (int i3 = 0; i2 > i3; i3++) {
            sArr[i3] = (short) ((bArr[i3 * 2] & 255) | ((bArr[(i3 * 2) + 1] & 255) << 8));
        }
        return sArr;
    }

    static /* synthetic */ double f(short[] sArr, int i2) {
        AppMethodBeat.i(239363);
        float f2 = 0.0f;
        for (short s : sArr) {
            f2 += (float) (s * s);
        }
        double sqrt = Math.sqrt((double) (f2 / ((float) i2)));
        AppMethodBeat.o(239363);
        return sqrt;
    }

    static /* synthetic */ void k(o oVar) {
        Map<String, Integer> bpN;
        AppMethodBeat.i(239364);
        List<String> emH = oVar.emH();
        HashMap<String, Integer> hashMap = new HashMap<>();
        q eom = ac.eom();
        MultiTalkGroup multiTalkGroup = ac.eom().zME;
        if (multiTalkGroup == null) {
            bpN = null;
        } else {
            String str = multiTalkGroup.zHD;
            if (Util.isNullOrNil(str)) {
                str = multiTalkGroup.RGY;
            }
            if (eom.aFW(multiTalkGroup.zHE)) {
                bpN = p.INSTANCE.elS();
            } else {
                bpN = ac.eol().zMd.bpN(str);
            }
        }
        if (bpN != null) {
            for (Map.Entry<String, Integer> entry : bpN.entrySet()) {
                if (!emH.contains(entry.getKey())) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (String str2 : emH) {
                if (!bpN.containsKey(str2)) {
                    Integer num = oVar.zMl.get(str2);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() < 30) {
                        hashMap.put(str2, Integer.valueOf(num.intValue() + 1));
                    }
                } else {
                    hashMap.put(str2, 0);
                }
            }
        }
        oVar.zMl = hashMap;
        AppMethodBeat.o(239364);
    }
}
