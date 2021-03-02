package com.tencent.mm.plugin.ipcall;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Looper;
import android.support.v4.app.s;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.model.bg;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.ipcall.model.IPCallForegroundService;
import com.tencent.mm.plugin.ipcall.model.a.a;
import com.tencent.mm.plugin.ipcall.model.c.a;
import com.tencent.mm.plugin.ipcall.model.c.c;
import com.tencent.mm.plugin.ipcall.model.d.a;
import com.tencent.mm.plugin.ipcall.model.d.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;

public final class c implements a.AbstractC1443a, g.a, r.a {
    private static MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private PhoneStateListener mtH = new PhoneStateListener() {
        /* class com.tencent.mm.plugin.ipcall.c.AnonymousClass1 */

        public final void onCallStateChanged(int i2, String str) {
            AppMethodBeat.i(25288);
            super.onCallStateChanged(i2, str);
            Log.d("MicroMsg.IPCallManager", "onCallStateChanged ".concat(String.valueOf(i2)));
            if (i2 == 2) {
                Log.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
                c.this.gP(0, 0);
            }
            AppMethodBeat.o(25288);
        }
    };
    private Object taa = new Object();
    private MTimerHandler timer;
    public e yof;
    private k yog;
    private boolean yoh = false;
    private TelephonyManager yoi;
    private boolean yoj = false;
    private IListener yok = new IListener<zi>() {
        /* class com.tencent.mm.plugin.ipcall.c.AnonymousClass2 */

        {
            AppMethodBeat.i(161377);
            this.__eventId = zi.class.getName().hashCode();
            AppMethodBeat.o(161377);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(zi ziVar) {
            zi ziVar2 = ziVar;
            if (ziVar2 instanceof zi) {
                ziVar2.efv.efw = false;
                ziVar2.efv.dCH = false;
                ziVar2.efv.dCI = true;
                ziVar2.efv.talker = "";
            }
            return false;
        }
    };
    private Runnable yol = new Runnable() {
        /* class com.tencent.mm.plugin.ipcall.c.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(25289);
            if (!i.eaw().eao()) {
                Log.i("MicroMsg.IPCallManager", "timeout! still not accept!");
                if (c.this.gP(9, 12)) {
                    c.this.g(9, null, MMApplicationContext.getContext().getString(R.string.aml), 2);
                }
            }
            AppMethodBeat.o(25289);
        }
    };
    private Runnable yom = new Runnable() {
        /* class com.tencent.mm.plugin.ipcall.c.AnonymousClass4 */

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0094 A[Catch:{ Exception -> 0x00c8 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 244
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.c.AnonymousClass4.run():void");
        }
    };
    private boolean yon;
    private com.tencent.mm.plugin.voip.ui.a yoo = new com.tencent.mm.plugin.voip.ui.a() {
        /* class com.tencent.mm.plugin.ipcall.c.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.voip.ui.a
        public final boolean dZV() {
            AppMethodBeat.i(25291);
            if (i.eaw().eal()) {
                AppMethodBeat.o(25291);
                return true;
            }
            AppMethodBeat.o(25291);
            return false;
        }

        @Override // com.tencent.mm.plugin.voip.ui.a
        public final void a(Intent intent, BaseSmallView baseSmallView) {
            AppMethodBeat.i(179650);
            if (!i.eaw().eao()) {
                baseSmallView.aGx(MMApplicationContext.getContext().getString(R.string.f7m));
                AppMethodBeat.o(179650);
                return;
            }
            int dZU = c.this.dZU();
            baseSmallView.aGy(String.format("%02d:%02d", Integer.valueOf(dZU / 60), Integer.valueOf(dZU % 60)));
            AppMethodBeat.o(179650);
        }
    };
    private long yop = 0;

    public c() {
        AppMethodBeat.i(25294);
        AppMethodBeat.o(25294);
    }

    private void removeListener() {
        AppMethodBeat.i(25295);
        if (this.yoi != null) {
            TelephonyManager telephonyManager = this.yoi;
            com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(this.mtH);
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/ipcall/IPCallManager", "removeListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/ipcall/IPCallManager", "removeListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            this.yoi = null;
        }
        EventCenter.instance.removeListener(this.yok);
        AppMethodBeat.o(25295);
    }

    static {
        AppMethodBeat.i(25324);
        AppMethodBeat.o(25324);
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(25296);
        if (i.eaw().eal()) {
            Log.i("MicroMsg.IPCallManager", "startIPCall, already start!");
            AppMethodBeat.o(25296);
            return false;
        }
        Log.i("MicroMsg.IPCallManager", "startIPCall");
        i.eas().yoN = this;
        i.eat().yqK = this;
        i.eaw().mAT = -1;
        removeListener();
        this.yoi = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        TelephonyManager telephonyManager = this.yoi;
        com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(this.mtH);
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/ipcall/IPCallManager", "addListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/ipcall/IPCallManager", "addListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        EventCenter.instance.addListener(this.yok);
        Log.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", str4, str5);
        k kVar = new k();
        kVar.field_phonenumber = str4;
        if (!Util.isNullOrNil(str5)) {
            com.tencent.mm.plugin.ipcall.model.h.c aBV = i.eay().aBV(str5);
            if (aBV == null || aBV.systemRowid == -1) {
                kVar.field_addressId = -1;
            } else {
                kVar.field_addressId = aBV.systemRowid;
            }
        } else {
            kVar.field_addressId = -1;
        }
        if (i2 != -1) {
            kVar.field_phoneType = i2;
        } else {
            kVar.field_phoneType = -1;
        }
        kVar.field_calltime = Util.nowMilliSecond();
        kVar.field_status = 1;
        if (!i.eaz().insert(kVar)) {
            kVar = null;
        }
        this.yog = kVar;
        hAk.postDelayed(this.yom, 1754);
        this.yoh = false;
        b eau = i.eau();
        Log.d("MicroMsg.IPCallReportHelper", "reset");
        eau.yqM = 0;
        eau.yqN = 0;
        eau.yqO = 0;
        eau.yqP = 0;
        eau.yqQ = 0;
        eau.yqR = 0;
        eau.yqS = 0;
        eau.yqT = 0;
        eau.yqU = 0;
        eau.yqV = 0;
        eau.roomId = 0;
        eau.ypH = 0;
        eau.yqW = 0;
        eau.kik = "";
        eau.yqX = 0;
        eau.yqY = "";
        eau.yra = 0;
        eau.yqZ = 0;
        eau.yop = 0;
        eau.yrb = 0;
        eau.yrc = 0;
        eau.yrh = 0;
        eau.yrg = 0;
        eau.yrd = "";
        eau.yre = "";
        eau.countryCode = "";
        eau.yri = 0;
        eau.yrj = 0;
        eau.yrk = 0;
        eau.yrl = 0;
        eau.yrm = 0;
        i.eaw().mAT = -1;
        Log.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", str3, str4);
        g eas = i.eas();
        Log.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", str3, str4);
        eas.dWM = false;
        eas.yoX = false;
        eas.yoI = 0;
        eas.yoJ = 0;
        eas.yoK = 0;
        eas.yoL = false;
        eas.yoM = false;
        eas.yoY = false;
        eas.yoW = new com.tencent.mm.plugin.ipcall.model.b.c();
        eas.yoW.nickname = str;
        eas.yoW.yqh = str2;
        eas.yoW.edf = str5;
        eas.yoW.yqi = str4;
        eas.yoW.dkV = str3;
        eas.yoW.ypJ = (int) System.currentTimeMillis();
        eas.yoW.ypK = i3;
        eas.yoW.ypL = i4;
        eas.yoW.phoneType = i2;
        eas.yoO.a(eas.yoW);
        eas.yoT.a(eas.yoW);
        Log.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", Integer.valueOf(eas.yoW.ypJ));
        i.eaw().OZ(1);
        a eat = i.eat();
        if (eat.yqJ) {
            Log.d("MicroMsg.IPCallEngineManager", "already start engine");
        } else {
            eat.resetStatus();
            Log.i("MicroMsg.IPCallEngineManager", "start engine");
            if (eat.yqF.fIZ()) {
                eat.yqF.xh(false);
                eat.yqF.reset();
            }
            eat.yqF.Hav = 1;
            long currentTimeMillis = System.currentTimeMillis();
            int fJb = eat.yqF.fJb();
            Log.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", Integer.valueOf(fJb), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (eat.yqF.field_capInfo != null && eat.yqF.exchangeCabInfo(eat.yqF.field_capInfo, eat.yqF.field_capInfo.length) < 0) {
                Log.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
                i.eau().yqV = 24;
            }
            if (fJb < 0) {
                Log.e("MicroMsg.IPCallEngineManager", "engine init failed!");
            }
            eat.yqF.Hav = 1;
            eat.yqJ = true;
        }
        hAk.removeCallbacks(this.yol);
        hAk.postDelayed(this.yol, Util.MILLSECONDS_OF_MINUTE);
        Log.printInfoStack("MicroMsg.IPCallManager", "bindIPCallForegroundIfNeed", new Object[0]);
        if (d.oD(26) && !this.yoj) {
            Intent intent = new Intent();
            intent.setClass(MMApplicationContext.getContext(), IPCallForegroundService.class);
            try {
                MMApplicationContext.getContext().startService(intent);
                z = true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.IPCallManager", e2, "using start service to bindIPCallForegroundIfNeed error: %s", e2.getMessage());
                try {
                    MMApplicationContext.getContext().startForegroundService(intent);
                    z = false;
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.IPCallManager", e3, "using start foreground service to bindIPCallForegroundIfNeed error: %s", e3.getMessage());
                    z = false;
                }
            }
            if (z) {
                this.yoj = true;
            }
        }
        AppMethodBeat.o(25296);
        return true;
    }

    private boolean al(int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int streamVolume;
        boolean z;
        int i8;
        boolean z2;
        AppMethodBeat.i(25297);
        com.tencent.mm.plugin.ipcall.model.b.c cVar = i.eas().yoW;
        if (!i.eaw().OZ(i2)) {
            Log.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now, currentState: %s", f.stateToString(i.eaw().mAT));
            if (cVar != null) {
                Log.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now inviteId:%d, roomId:%d, state:%d,errStatus:%d, pstnErrCode:%d", Integer.valueOf(cVar.ypJ), Integer.valueOf(cVar.roomId), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            }
            AppMethodBeat.o(25297);
            return false;
        }
        if (cVar != null) {
            Log.i("MicroMsg.IPCallManager", "finishIPCall inviteId:%d, roomId:%d, state:%d, errStatus:%d, pstnErrCode:%d", Integer.valueOf(cVar.ypJ), Integer.valueOf(cVar.roomId), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        i.eaC().stop();
        e eaC = i.eaC();
        boolean isSpeakerphoneOn = i.eav().yqo.isSpeakerphoneOn();
        eaC.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_shake", true);
        com.tencent.mm.plugin.audio.c.a.agr("voip").cV(isSpeakerphoneOn);
        if (isSpeakerphoneOn) {
            com.tencent.mm.plugin.audio.c.a.setMode(0);
        } else {
            com.tencent.mm.plugin.audio.c.a.setMode(2);
        }
        Log.i("MicroMsg.RingPlayer", "playSound, shake: %s, isSpeakerOn: %s, type: %s", Boolean.FALSE, Boolean.valueOf(isSpeakerphoneOn), 2);
        eaC.Hjh = System.currentTimeMillis();
        com.tencent.mm.compatible.b.k kVar = new com.tencent.mm.compatible.b.k();
        try {
            kVar.setDataSource(eaC.mContext, Uri.parse("android.resource://" + eaC.mContext.getPackageName() + "/2131689973"));
            kVar.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                /* class com.tencent.mm.plugin.voip.video.e.AnonymousClass7 */

                public final void onCompletion(MediaPlayer mediaPlayer) {
                    AppMethodBeat.i(115683);
                    mediaPlayer.release();
                    if (System.currentTimeMillis() - e.this.Hjh > 5000) {
                        e.this.Hjf = 8;
                        com.tencent.mm.plugin.audio.c.a.cdV();
                    }
                    AppMethodBeat.o(115683);
                }
            });
            kVar.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                /* class com.tencent.mm.plugin.voip.video.e.AnonymousClass8 */

                public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                    AppMethodBeat.i(115684);
                    if (mediaPlayer != null) {
                        mediaPlayer.release();
                        e.this.Hjf = 5;
                        Log.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
                    }
                    AppMethodBeat.o(115684);
                    return false;
                }
            });
            kVar.setAudioStreamType((com.tencent.mm.plugin.audio.c.a.ceb() || !isSpeakerphoneOn) ? 0 : 2);
            kVar.prepare();
            kVar.setLooping(false);
            kVar.start();
            if (System.currentTimeMillis() - eaC.Hjh > 2000) {
                eaC.Hjf = 7;
            }
        } catch (Throwable th) {
            Log.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", th);
            eaC.Hjf = 6;
            kVar.stop();
            kVar.release();
        }
        Log.i("MicroMsg.IPCallManager", "closeDeviceEngine");
        r.fHo().fHq();
        r.fHo().a(null);
        b eau = i.eau();
        com.tencent.mm.plugin.ipcall.model.c.c cVar2 = i.eav().yqo.ypB;
        if (cVar2 == null) {
            i5 = 0;
        } else if (cVar2.yqu != null) {
            i5 = cVar2.yqu.dyZ;
        } else {
            i5 = 0;
        }
        if (eau.yrj == 0) {
            eau.yrj = i5;
        }
        b eau2 = i.eau();
        com.tencent.mm.plugin.ipcall.model.c.a aVar = i.eav().yqo.ypA;
        if (aVar == null) {
            i6 = 0;
        } else if (aVar.qrz != null) {
            Log.d("MicroMsg.IPCallAudioPlayer", "AudioPlayer  mAudioPlayErrState:" + aVar.qrz.fFs());
            i6 = aVar.qrz.fFs();
        } else {
            i6 = 0;
        }
        if (eau2.yrk == 0) {
            eau2.yrk = i6;
        }
        com.tencent.mm.plugin.ipcall.model.c.b eav = i.eav();
        a eat = i.eat();
        com.tencent.mm.plugin.ipcall.model.a.a aVar2 = eav.yqo;
        com.tencent.mm.plugin.ipcall.model.c.a aVar3 = aVar2.ypA;
        if (aVar3 == null) {
            i7 = 0;
        } else if (aVar3.qrz == null || !aVar3.isStart) {
            i7 = -1;
        } else {
            i7 = aVar3.qrz.bhV();
        }
        if (i7 == -1) {
            streamVolume = 0;
        } else {
            streamVolume = (int) ((((float) aVar2.getStreamVolume(i7)) / ((float) aVar2.getStreamMaxVolume(i7))) * 100.0f);
        }
        eat.yqF.HaY = streamVolume;
        eav.gte = null;
        com.tencent.mm.plugin.ipcall.model.a.a aVar4 = eav.yqo;
        com.tencent.mm.plugin.ipcall.model.c.a aVar5 = aVar4.ypA;
        if (aVar5 != null && aVar5.isStart) {
            Log.i("MicroMsg.IPCallAudioPlayer", "stopPlay");
            synchronized (aVar5.yql) {
                try {
                    ThreadPool.post(new a.RunnableC1442a(aVar5.qrz), "IPCallAudioPlayer_stop");
                    aVar5.isStart = false;
                    aVar5.qrz = null;
                } catch (Throwable th2) {
                    AppMethodBeat.o(25297);
                    throw th2;
                }
            }
        }
        aVar4.agq("ipcall");
        aVar4.ypz = null;
        aVar4.jvG.apm();
        eav.yqs = null;
        com.tencent.mm.plugin.ipcall.model.c.b eav2 = i.eav();
        com.tencent.mm.plugin.ipcall.model.c.c cVar3 = eav2.yqo.ypB;
        if (cVar3 != null && cVar3.isStart) {
            Log.i("MicroMsg.IPCallRecorder", "stop record");
            synchronized (cVar3.yqv) {
                try {
                    if (cVar3.yqu != null) {
                        ThreadPool.post(new c.a(cVar3.yqu), "IPCallRecorder_stopRecord");
                        cVar3.yqu = null;
                        cVar3.isStart = false;
                        cVar3.guh = false;
                    }
                } catch (Throwable th3) {
                    AppMethodBeat.o(25297);
                    throw th3;
                }
            }
        }
        eav2.gte = null;
        com.tencent.mm.plugin.ipcall.model.d.a eat2 = i.eat();
        Log.i("MicroMsg.IPCallEngineManager", "close engine");
        eat2.yqF.xh(true);
        b eau3 = i.eau();
        if (Util.isNullOrNil(eau3.yre) && Util.isNullOrNil(eau3.yrd)) {
            com.tencent.mm.plugin.ipcall.model.b.c cVar4 = i.eas().yoW;
            v2protocal v2protocal = i.eat().yqF;
            if (eau3.yqT == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            v2protocal.getPstnChannelInfo(v2protocal.Hcs, v2protocal.Hcs.length, z2 ? 1 : 0, cVar4.yqc);
            Log.d("MicroMsg.Voip", "field_pstnChannelInfoLength: %d", Integer.valueOf(v2protocal.field_pstnChannelInfoLength));
            eau3.yre = new String(v2protocal.Hcs, 0, v2protocal.field_pstnChannelInfoLength);
            v2protocal v2protocal2 = i.eat().yqF;
            v2protocal2.getPstnEngineInfo(v2protocal2.Hct, v2protocal2.Hct.length);
            Log.d("MicroMsg.Voip", "field_pstnEngineInfoLength: %d", Integer.valueOf(v2protocal2.field_pstnEngineInfoLength));
            eau3.yrd = new String(v2protocal2.Hct, 0, v2protocal2.field_pstnEngineInfoLength);
            eau3.yrf = i.eat().yqF.fIY();
            Log.d("MicroMsg.IPCallReportHelper", "nativeChannelReportString: %s", eau3.yre);
            Log.d("MicroMsg.IPCallReportHelper", "nativeEngineReportString: %s", eau3.yrd);
            Log.d("MicroMsg.IPCallReportHelper", "clientReportExString: %s", eau3.yrf);
        }
        eat2.yqF.reset();
        eat2.resetStatus();
        hAk.removeCallbacks(this.yom);
        hAk.removeCallbacks(this.yol);
        if (this.timer != null) {
            this.timer.stopTimer();
            this.timer = null;
        }
        i.eau().yqV = i4;
        b eau4 = i.eau();
        Log.d("MicroMsg.IPCallReportHelper", "markEndTalk");
        if (eau4.yrc == 0 && eau4.yrb != 0) {
            eau4.yrc = System.currentTimeMillis();
            eau4.yqU = (eau4.yrc - eau4.yrb) / 1000;
            Log.d("MicroMsg.IPCallReportHelper", "callTime: %d", Long.valueOf(eau4.yqU));
        }
        if (i2 == 8) {
            i.eas().eap();
            i.eau().eaP();
            k kVar2 = this.yog;
            if (kVar2 != null) {
                Log.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", Long.valueOf(kVar2.systemRowid));
                if (kVar2.systemRowid != -1) {
                    kVar2.field_status = 2;
                    i.eaz().a(kVar2);
                }
            }
        } else if (i2 == 12) {
            i.eas().eap();
            i.eau().eaP();
            if (i3 == 11) {
                m.b(this.yog);
            } else {
                k kVar3 = this.yog;
                if (kVar3 != null) {
                    Log.d("MicroMsg.IPCallRecordStorageLogic", "recordCallFailed, localId: %d", Long.valueOf(kVar3.systemRowid));
                    if (kVar3.systemRowid != -1) {
                        kVar3.field_status = 6;
                        i.eaz().a(kVar3);
                    }
                }
            }
        } else if (i2 == 9) {
            i.eas().Pb(1);
            i.eau().eaO();
            m.a(this.yog, i.eau().yqU);
        } else if (i2 == 10) {
            i.eas().Pb(1);
            b eau5 = i.eau();
            Log.i("MicroMsg.IPCallReportHelper", "otherSideUserShutdown");
            eau5.yqO = 1;
            k kVar4 = this.yog;
            long j2 = i.eau().yqU;
            if (kVar4 != null) {
                Log.d("MicroMsg.IPCallRecordStorageLogic", "recordOthersideShutdownCall, localId: %d, talkTime: %d", Long.valueOf(kVar4.systemRowid), Long.valueOf(j2));
                if (kVar4.systemRowid != -1) {
                    kVar4.field_status = 5;
                    kVar4.field_duration = j2;
                    i.eaz().a(kVar4);
                }
            }
        } else if (i2 == 11) {
            if (i3 == 5) {
                i.eas().Pb(3);
            } else if (i3 == 11) {
                i.eas().Pb(1);
            } else {
                i.eas().Pb(2);
            }
            i.eau().eaO();
            if (i3 == 11) {
                m.b(this.yog);
            } else {
                m.a(this.yog, i.eau().yqU);
            }
        }
        if (i.eas().dWM) {
            if (this.yon || i.eas().yoW.roomId == 0 || i.eas().yoW.ypI == 0) {
                Log.e("MicroMsg.IPCallManager", "roomId = 0,ignore feedback");
            } else {
                Context context = MMApplicationContext.getContext();
                int i9 = i.eas().yoW.roomId;
                long j3 = i.eas().yoW.ypI;
                Log.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog");
                if (d.dZW()) {
                    int i10 = h.aqJ().getInt("WCOMaxTimesForShowFeedback", 0);
                    bg.aVF();
                    int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERFINO_IPCALL_SHOW_FEEDBACK_TIME_COUNT_INT, (Object) 0)).intValue();
                    bg.aVF();
                    long longValue = ((Long) com.tencent.mm.model.c.azQ().get(ar.a.USERFINO_IPCALL_SHOW_FEEDBACK_LAST_TIME_LONG, (Object) 0L)).longValue();
                    long nowSecond = Util.nowSecond();
                    if (nowSecond - longValue > 86400) {
                        i8 = 0;
                        Log.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reset time");
                    } else {
                        i8 = intValue;
                    }
                    if (i8 >= i10) {
                        Log.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reach max time".concat(String.valueOf(i10)));
                    } else if (nowSecond - longValue < 1800) {
                        Log.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog not reach INTERVAL_TIMES_TRY_SHOW_WCO_FEEDBACK_MAIN");
                    } else {
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_SHOW_FEEDBACK_TIME_COUNT_INT, Integer.valueOf(i8 + 1));
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(ar.a.USERFINO_IPCALL_SHOW_FEEDBACK_LAST_TIME_LONG, Long.valueOf(nowSecond));
                        Intent intent = new Intent();
                        intent.putExtra("IPCallFeedbackDialogUI_KRoomId", i9);
                        intent.putExtra("IPCallFeedbackDialogUI_KCallseq", j3);
                        com.tencent.mm.br.c.b(context, "ipcall", ".ui.IPCallFeedbackDialogUI", intent);
                    }
                }
            }
        }
        i.eas().yoN = null;
        i.eat().yqK = null;
        i.eaw().mAT = -1;
        i.eaq();
        com.tencent.mm.plugin.ipcall.model.a.a.unInit();
        qm(true);
        removeListener();
        Log.printInfoStack("MicroMsg.IPCallManager", "unbindIPCallForegroundIfNeed", new Object[0]);
        if (d.oD(26)) {
            try {
                Intent intent2 = new Intent();
                intent2.setClass(MMApplicationContext.getContext(), IPCallForegroundService.class);
                MMApplicationContext.getContext().stopService(intent2);
                z = true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.IPCallManager", e2, "unbindIPCallForegroundIfNeed error: %s", e2.getMessage());
                z = false;
            }
            if (z) {
                this.yoj = false;
            }
        }
        AppMethodBeat.o(25297);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean aBQ(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.c.aBQ(java.lang.String):boolean");
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void dZI() {
        AppMethodBeat.i(25299);
        Log.i("MicroMsg.IPCallManager", "onInviteSuccess");
        if (!i.eaw().OZ(3)) {
            AppMethodBeat.o(25299);
            return;
        }
        b eau = i.eau();
        Log.d("MicroMsg.IPCallReportHelper", "markStartInvite");
        if (eau.yqZ == 0) {
            eau.yqZ = System.currentTimeMillis();
        }
        com.tencent.mm.plugin.ipcall.model.b.c cVar = i.eas().yoW;
        b eau2 = i.eau();
        int i2 = cVar.ypJ;
        String str = cVar.dkV;
        String str2 = cVar.yqi;
        int i3 = cVar.roomId;
        long j2 = cVar.ypH;
        long j3 = cVar.ypI;
        eau2.ypJ = i2;
        eau2.yqY = str;
        eau2.kik = str2;
        eau2.roomId = i3;
        eau2.ypH = j2;
        eau2.yqW = j3;
        if (this.yof != null) {
            this.yof.dZI();
        }
        AppMethodBeat.o(25299);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void X(String str, String str2, int i2) {
        AppMethodBeat.i(25300);
        Log.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", f.stateToString(i.eaw().mAT));
        if (gP(2, 0)) {
            g(2, str, str2, i2);
        }
        AppMethodBeat.o(25300);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void dZJ() {
        AppMethodBeat.i(25301);
        Log.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", f.stateToString(i.eaw().mAT));
        if (!i.eaw().OZ(4)) {
            AppMethodBeat.o(25301);
            return;
        }
        b eau = i.eau();
        Log.d("MicroMsg.IPCallReportHelper", "markStartRing");
        if (eau.yra == 0) {
            eau.yra = System.currentTimeMillis();
            eau.yqR = eau.yra - eau.yqZ;
            Log.d("MicroMsg.IPCallReportHelper", "ringTime: %d", Long.valueOf(eau.yqR));
        }
        i.eat().eaN();
        b eau2 = i.eau();
        Log.i("MicroMsg.IPCallReportHelper", "startRing");
        eau2.yqM = 1;
        if (this.yof != null) {
            this.yof.dZJ();
        }
        AppMethodBeat.o(25301);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void dZK() {
        AppMethodBeat.i(25302);
        Log.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", f.stateToString(i.eaw().mAT));
        if (!i.eaw().OZ(5)) {
            AppMethodBeat.o(25302);
            return;
        }
        b eau = i.eau();
        Log.d("MicroMsg.IPCallReportHelper", "markUserAccept");
        if (eau.yop == 0) {
            eau.yop = System.currentTimeMillis();
            eau.yqS = eau.yop - eau.yqZ;
            Log.d("MicroMsg.IPCallReportHelper", "answerTime: %d", Long.valueOf(eau.yqS));
        }
        i.eat().eaN();
        b eau2 = i.eau();
        Log.i("MicroMsg.IPCallReportHelper", "userAccept");
        eau2.yqN = 1;
        hAk.removeCallbacks(this.yol);
        i.eaC().stop();
        hAk.removeCallbacks(this.yom);
        i.eav().yqo.bFT();
        if (i.eat().yqI && !this.yoh) {
            i.eau().eaQ();
            i.eau().eaT();
            this.yoh = true;
            this.yop = Util.nowSecond();
            bpu();
            i.eat().eaM();
            if (this.yof != null) {
                this.yof.dZX();
            }
            i.eau().eaS();
            r.fHo().fHp();
            r.fHo().a(this);
        }
        AppMethodBeat.o(25302);
    }

    public final void g(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(25303);
        if (this.yof != null) {
            this.yof.g(i2, str, str2, i3);
            AppMethodBeat.o(25303);
            return;
        }
        Toast.makeText(MMApplicationContext.getContext(), str2, 1).show();
        AppMethodBeat.o(25303);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void ep(String str, int i2) {
        AppMethodBeat.i(25304);
        Log.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", f.stateToString(i.eaw().mAT));
        if (gP(3, 5)) {
            g(3, null, str, i2);
        }
        AppMethodBeat.o(25304);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void eq(String str, int i2) {
        AppMethodBeat.i(25305);
        Log.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", f.stateToString(i.eaw().mAT));
        if (gP(1, 4)) {
            g(1, null, str, i2);
        }
        AppMethodBeat.o(25305);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void dZL() {
        AppMethodBeat.i(25306);
        Log.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", f.stateToString(i.eaw().mAT));
        if (al(10, 0, 32)) {
            if (this.yof != null) {
                this.yof.dZY();
                AppMethodBeat.o(25306);
                return;
            }
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.e7x), 1).show();
        }
        AppMethodBeat.o(25306);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void er(String str, int i2) {
        AppMethodBeat.i(25307);
        Log.i("MicroMsg.IPCallManager", "onSyncFailed");
        if (gP(7, 35)) {
            g(7, null, str, i2);
        }
        AppMethodBeat.o(25307);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void dZM() {
        AppMethodBeat.i(25308);
        Log.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
        if (gP(7, 29)) {
            g(7, null, MMApplicationContext.getContext().getString(R.string.amf), 1);
        }
        AppMethodBeat.o(25308);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void Y(String str, String str2, int i2) {
        AppMethodBeat.i(25309);
        Log.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", f.stateToString(i.eaw().mAT));
        if (gP(8, 9)) {
            g(8, str, str2, i2);
        }
        AppMethodBeat.o(25309);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void Z(String str, String str2, int i2) {
        AppMethodBeat.i(25310);
        Log.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", f.stateToString(i.eaw().mAT));
        if (gP(10, 0)) {
            g(10, str, str2, i2);
        }
        AppMethodBeat.o(25310);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void aa(String str, String str2, int i2) {
        AppMethodBeat.i(25311);
        Log.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", f.stateToString(i.eaw().mAT));
        if (gP(11, 0)) {
            g(11, str, str2, i2);
        }
        AppMethodBeat.o(25311);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.g.a
    public final void dZN() {
        AppMethodBeat.i(25312);
        do {
            Log.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", f.stateToString(i.eaw().mAT));
        } while (gP(12, 0));
        AppMethodBeat.o(25312);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.d.a.AbstractC1443a
    public final void dZO() {
        AppMethodBeat.i(25313);
        Log.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", f.stateToString(i.eaw().mAT));
        if (gP(6, 0)) {
            g(6, null, MMApplicationContext.getContext().getString(R.string.aml), 1);
        }
        AppMethodBeat.o(25313);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.d.a.AbstractC1443a
    public final void dZP() {
        boolean z;
        AppMethodBeat.i(25314);
        Log.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", f.stateToString(i.eaw().mAT));
        i.eaC().stop();
        hAk.removeCallbacks(this.yom);
        if (i.eaw().eam()) {
            com.tencent.mm.plugin.ipcall.model.c.b eav = i.eav();
            eav.yqo.b("ipcall", (Integer) 4);
            Log.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.AY(3)), Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.AY(4)));
            com.tencent.mm.plugin.ipcall.model.a.a aVar = eav.yqo;
            com.tencent.mm.plugin.ipcall.model.c.a aVar2 = aVar.ypA;
            if (aVar2 != null) {
                if (aVar2.isStart) {
                    Log.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
                } else {
                    Log.i("MicroMsg.IPCallAudioPlayer", "startPlay");
                    if (aVar2.qrz == null) {
                        aVar2.qrz = new com.tencent.mm.plugin.voip.model.c();
                        aVar2.qrz.N(v2protocal.VOICE_SAMPLERATE, 1, 20, 1);
                    }
                    aVar2.yqm = aVar2.qrz.F(MMApplicationContext.getContext(), false);
                    aVar2.qrz.GTi = new com.tencent.mm.plugin.voip.model.b() {
                        /* class com.tencent.mm.plugin.ipcall.model.c.a.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.voip.model.b
                        public final int Q(byte[] bArr, int i2) {
                            AppMethodBeat.i(25413);
                            if (!a.this.isStart) {
                                AppMethodBeat.o(25413);
                                return -1;
                            }
                            int playCallback = i.eat().yqF.playCallback(bArr, i2);
                            if (playCallback < 0) {
                                Log.e("MicroMsg.IPCallAudioPlayer", "playCallback, error: %d", Integer.valueOf(playCallback));
                                AppMethodBeat.o(25413);
                                return -1;
                            }
                            AppMethodBeat.o(25413);
                            return 0;
                        }
                    };
                    if (aVar2.qrz.fFp() <= 0) {
                        i.eau().eaR();
                    }
                    aVar2.yqo.cV(aVar2.yqn);
                    aVar2.isStart = true;
                }
            }
            a.b bVar = aVar.ypz;
            if (bVar != null) {
                bVar.qu(aVar.cdY() == 3);
            }
            a.b bVar2 = aVar.ypz;
            if (bVar2 != null) {
                if (aVar.cdY() == 4) {
                    z = true;
                } else {
                    z = false;
                }
                bVar2.qv(z);
            }
        }
        i.eau().eaQ();
        i.eav().yqo.bFT();
        if (i.eaw().eao() && !this.yoh) {
            i.eau().eaT();
            i.eat().eaM();
            this.yoh = true;
            this.yop = Util.nowSecond();
            bpu();
            if (this.yof != null) {
                this.yof.dZX();
            }
            k kVar = this.yog;
            if (kVar != null) {
                Log.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", Long.valueOf(kVar.systemRowid));
                if (kVar.systemRowid != -1) {
                    kVar.field_status = 3;
                    i.eaz().a(kVar);
                }
            }
            i.eau().eaS();
            r.fHo().fHp();
            r.fHo().a(this);
        }
        AppMethodBeat.o(25314);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.d.a.AbstractC1443a
    public final void OX(int i2) {
        AppMethodBeat.i(25315);
        Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", f.stateToString(i.eaw().mAT));
        if (i.eat().yqI) {
            Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
            if (gP(5, i2)) {
                g(5, null, MMApplicationContext.getContext().getString(R.string.amf), 1);
                AppMethodBeat.o(25315);
                return;
            }
        } else {
            Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
            if (gP(4, i2)) {
                g(4, null, MMApplicationContext.getContext().getString(R.string.amf), 1);
            }
        }
        AppMethodBeat.o(25315);
    }

    public final boolean gP(int i2, int i3) {
        AppMethodBeat.i(25316);
        if (i.eaw().eao()) {
            if (i2 == 0) {
                boolean al = al(9, i2, i3);
                AppMethodBeat.o(25316);
                return al;
            }
            boolean al2 = al(11, i2, i3);
            AppMethodBeat.o(25316);
            return al2;
        } else if (i2 == 0) {
            boolean al3 = al(8, i2, i3);
            AppMethodBeat.o(25316);
            return al3;
        } else {
            boolean al4 = al(12, i2, i3);
            AppMethodBeat.o(25316);
            return al4;
        }
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void dZQ() {
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void ql(boolean z) {
        AppMethodBeat.i(25317);
        if (i.eaw().mAT != 5) {
            Log.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", Integer.valueOf(i.eaw().mAT));
            AppMethodBeat.o(25317);
            return;
        }
        com.tencent.mm.plugin.ipcall.model.c.b eav = i.eav();
        Log.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
        if (eav.yqs != null) {
            j jVar = eav.yqs;
            if (jVar.yzB != null) {
                jVar.yzB.setVisibility(0);
            }
            if (jVar.yzC != null) {
                jVar.yzC.setVisibility(0);
            }
        }
        if (!eav.yqo.isSpeakerphoneOn()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - eav.yqt > 30000) {
                eav.yqt = currentTimeMillis;
                com.tencent.mm.plugin.voip.c.fFg().GYS.fIA();
            }
        }
        AppMethodBeat.o(25317);
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void dZR() {
        AppMethodBeat.i(25318);
        if (i.eaw().mAT != 5) {
            Log.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", Integer.valueOf(i.eaw().mAT));
            AppMethodBeat.o(25318);
            return;
        }
        com.tencent.mm.plugin.ipcall.model.c.b eav = i.eav();
        Log.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
        if (eav.yqs != null) {
            eav.yqs.ebH();
        }
        AppMethodBeat.o(25318);
    }

    public final void dZS() {
        AppMethodBeat.i(25319);
        synchronized (this.taa) {
            try {
                if (i.eaw().eal()) {
                    if (this.yon) {
                        dZT();
                        return;
                    }
                    this.yon = true;
                    Toast.makeText(MMApplicationContext.getContext(), (int) R.string.f6j, 0).show();
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setClass(MMApplicationContext.getContext(), IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
                    com.tencent.mm.plugin.voip.c.fFh().a(intent, false, this.yoo);
                    dZT();
                    if (this.yof != null) {
                        this.yof.dZZ();
                    }
                }
                AppMethodBeat.o(25319);
            } finally {
                AppMethodBeat.o(25319);
            }
        }
    }

    public final void dZT() {
        String string;
        AppMethodBeat.i(25320);
        if (d.oE(26)) {
            if (i.eaw().eao()) {
                string = MMApplicationContext.getContext().getString(R.string.e6t, String.format("%02d:%02d", Long.valueOf(Util.secondsToNow(this.yop) / 60), Long.valueOf(Util.secondsToNow(this.yop) % 60)));
            } else {
                string = MMApplicationContext.getContext().getString(R.string.e6s);
            }
            Intent intent = new Intent(MMApplicationContext.getContext(), IPCallTalkUI.class);
            intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
            PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 42, intent, 134217728);
            int i2 = R.drawable.cj8;
            if (d.oE(19)) {
                i2 = R.drawable.cj7;
            }
            s.c g2 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(MMApplicationContext.getContext().getString(R.string.e6s)).i(System.currentTimeMillis()).f(MMApplicationContext.getContext().getString(R.string.e6i)).g(string);
            g2.Hv = activity;
            Notification build = g2.build();
            build.icon = i2;
            build.flags |= 32;
            bg.getNotification().a(42, build, false);
        }
        if (!i.eaw().eao()) {
            com.tencent.mm.plugin.voip.c.fFh().aGx(MMApplicationContext.getContext().getString(R.string.f7m));
            AppMethodBeat.o(25320);
            return;
        }
        com.tencent.mm.plugin.voip.c.fFh().xv(dZU());
        AppMethodBeat.o(25320);
    }

    public final void qm(boolean z) {
        AppMethodBeat.i(185745);
        synchronized (this.taa) {
            try {
                this.yon = false;
                com.tencent.mm.plugin.voip.c.fFh().rX(z);
                ((NotificationManager) MMApplicationContext.getContext().getSystemService("notification")).cancel(42);
            } finally {
                AppMethodBeat.o(185745);
            }
        }
    }

    public final int dZU() {
        AppMethodBeat.i(25322);
        int secondsToNow = (int) Util.secondsToNow(this.yop);
        if (secondsToNow > 0) {
            AppMethodBeat.o(25322);
            return secondsToNow;
        }
        AppMethodBeat.o(25322);
        return 0;
    }

    private void bpu() {
        AppMethodBeat.i(25323);
        Log.i("MicroMsg.IPCallManager", "startTimeCount");
        if (this.timer != null) {
            this.timer.stopTimer();
            AppMethodBeat.o(25323);
            return;
        }
        if (this.timer == null) {
            this.timer = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.ipcall.c.AnonymousClass6 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(25293);
                    c.this.dZT();
                    if (i.eaw().eao() && c.this.yof != null) {
                        c.this.yof.eaa();
                    }
                    AppMethodBeat.o(25293);
                    return true;
                }
            }, true);
        }
        this.timer.startTimer(1000);
        AppMethodBeat.o(25323);
    }
}
