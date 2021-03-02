package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.k;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.c;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.d.bi;
import com.tencent.mm.ui.chatting.e.a;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d implements k.a, k.b, k.c, k.d, ao, c, SensorController.SensorEventCallBack {
    private List<ca> Peh;
    public long Pei = -1;
    private p Pej;
    private bi Pek;
    public p Pel;
    public boolean Pem;
    public boolean Pen = true;
    public boolean Peo = false;
    private long Pep = 0;
    private long Peq = 0;
    public boolean Per = false;
    private boolean Pes = false;
    public IListener Pet = new IListener<sw>() {
        /* class com.tencent.mm.ui.chatting.d.AnonymousClass1 */

        {
            AppMethodBeat.i(161516);
            this.__eventId = sw.class.getName().hashCode();
            AppMethodBeat.o(161516);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sw swVar) {
            AppMethodBeat.i(34255);
            sw swVar2 = swVar;
            long j2 = swVar2.dZp.msgId;
            Log.d("MicroMsg.AutoPlay", "playingVoiceId: %s", new StringBuilder().append(d.this.Pei).toString());
            Log.d("MicroMsg.AutoPlay", "msg id is: %s", new StringBuilder().append(swVar2.dZp.msgId).toString());
            if (d.this.Pei == j2) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(34254);
                        d.this.gMT();
                        d.this.gMO();
                        AppMethodBeat.o(34254);
                    }
                });
            }
            AppMethodBeat.o(34255);
            return false;
        }
    };
    private MMHandler Peu = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.ui.chatting.d.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            boolean z;
            AppMethodBeat.i(34256);
            super.handleMessage(message);
            try {
                Log.i("MicroMsg.AutoPlay", "reset speaker");
                d.b(d.this);
                d dVar = d.this;
                if (!d.this.Pek.qUn) {
                    z = true;
                } else {
                    z = false;
                }
                dVar.qUm = z;
                AppMethodBeat.o(34256);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AutoPlay", e2, "", new Object[0]);
                AppMethodBeat.o(34256);
            }
        }
    };
    private MMHandler Pev = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.ui.chatting.d.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(34257);
            super.handleMessage(message);
            try {
                Log.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
                d.this.gMR();
                AppMethodBeat.o(34257);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AutoPlay", e2, "", new Object[0]);
                AppMethodBeat.o(34257);
            }
        }
    };
    public Context context;
    public a dom;
    private int dyc;
    boolean ipv = false;
    private long lastShakeTime = -1;
    public k qUl;
    private boolean qUm;
    private boolean qUo = false;
    private ShakeManager qUp;
    private SensorController qUq;

    static /* synthetic */ void b(d dVar) {
        AppMethodBeat.i(34289);
        dVar.setScreenEnable(true);
        AppMethodBeat.o(34289);
    }

    static /* synthetic */ void e(d dVar) {
        AppMethodBeat.i(232837);
        dVar.gMU();
        AppMethodBeat.o(232837);
    }

    public d(a aVar, bi biVar, String str) {
        AppMethodBeat.i(34261);
        this.context = aVar.Pwc.getContext();
        this.dom = aVar;
        this.Pek = biVar;
        if (this.qUq == null) {
            this.qUq = new SensorController(this.context.getApplicationContext());
        }
        if (this.qUp == null) {
            this.qUp = new ShakeManager(this.context.getApplicationContext());
        }
        bmt(str);
        EventCenter.instance.addListener(this.Pet);
        bg.Xi().a(this);
        AppMethodBeat.o(34261);
    }

    public final void bmt(String str) {
        AppMethodBeat.i(34262);
        Log.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", Boolean.valueOf(this.Peo));
        if (this.Peo || this.context == null) {
            AppMethodBeat.o(34262);
            return;
        }
        this.Peh = new LinkedList();
        this.ipv = false;
        this.Pei = -1;
        this.qUm = false;
        this.lastShakeTime = -1;
        this.Pem = false;
        this.dyc = 0;
        if (ab.Jp(str)) {
            this.dyc = 1;
            this.qUl = new com.tencent.mm.audio.a.a(this.context, 1);
            AppMethodBeat.o(34262);
            return;
        }
        this.dyc = 0;
        this.qUl = new com.tencent.mm.audio.a.a(this.context, 0);
        AppMethodBeat.o(34262);
    }

    public final void gMO() {
        AppMethodBeat.i(34263);
        if (1 == Log.getLogLevel()) {
            Log.d("MicroMsg.AutoPlay", "clear play list, stack: %s", Util.getStack());
        }
        if (this.Pej != null) {
            this.Pej.dismiss();
        }
        this.Peh.clear();
        AppMethodBeat.o(34263);
    }

    public final void ama(int i2) {
        AppMethodBeat.i(34264);
        while (this.context != null) {
            if (this.dom == null) {
                Log.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
                AppMethodBeat.o(34264);
                return;
            }
            int count = ((com.tencent.mm.ui.chatting.d.b.k) this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).getCount();
            Log.d("MicroMsg.AutoPlay", "position : " + i2 + "adapter getCount = " + count);
            if (i2 < 0 || i2 >= count) {
                AppMethodBeat.o(34264);
                return;
            }
            ca amt = ((com.tencent.mm.ui.chatting.d.b.k) this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).amt(i2);
            if (amt == null) {
                AppMethodBeat.o(34264);
                return;
            }
            if (amt.gAy() && amt.field_isSend == 0 && !s.ai(amt) && !s.aj(amt)) {
                bf(amt);
            }
            i2++;
        }
        Log.e("MicroMsg.AutoPlay", "context is null");
        AppMethodBeat.o(34264);
    }

    public final void bf(ca caVar) {
        AppMethodBeat.i(34265);
        if (caVar == null) {
            AppMethodBeat.o(34265);
            return;
        }
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            if (this.Peh.size() > 0) {
                this.Peh.clear();
                u.g(this.context, this.dom.Pwc.getContentView());
            }
            AppMethodBeat.o(34265);
            return;
        }
        int size = this.Peh.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.Peh.get(i2).field_msgId == caVar.field_msgId) {
                AppMethodBeat.o(34265);
                return;
            }
        }
        if (this.Pem || this.Peh.size() == 0) {
            this.Peh.add(caVar);
        }
        Log.d("MicroMsg.AutoPlay", "add voice msg :" + this.Peh.size());
        AppMethodBeat.o(34265);
    }

    public final void a(int i2, ca caVar) {
        AppMethodBeat.i(34266);
        if (caVar == null) {
            AppMethodBeat.o(34266);
            return;
        }
        gMO();
        bg.aVF();
        Boolean bool = (Boolean) com.tencent.mm.model.c.azQ().get(4115, (Object) null);
        if (bool == null || !bool.booleanValue()) {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(4115, Boolean.TRUE);
            gMU();
            this.Pel = u.a(this.dom.Pwc.getActivity(), this.context.getString(R.string.b14), 4000);
        }
        if (!this.qUl.isPlaying() || caVar.field_msgId != this.Pei) {
            bf(caVar);
            if (caVar.field_isSend == 0 && !s.ai(caVar)) {
                ama(i2 + 1);
            }
            BK(true);
            AppMethodBeat.o(34266);
            return;
        }
        gMT();
        AppMethodBeat.o(34266);
    }

    public final void b(int i2, ca caVar) {
        AppMethodBeat.i(34267);
        if (caVar == null) {
            AppMethodBeat.o(34267);
            return;
        }
        gMO();
        bg.aVF();
        Boolean bool = (Boolean) com.tencent.mm.model.c.azQ().get(4115, (Object) null);
        if (bool == null || !bool.booleanValue()) {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(4115, Boolean.TRUE);
            gMU();
            this.Pel = u.a(this.dom.Pwc.getActivity(), this.context.getString(R.string.b14), 4000);
        }
        if (!this.qUl.isPlaying() || caVar.field_msgId != this.Pei) {
            bf(caVar);
            if (caVar.field_isSend == 0 && !s.ai(caVar)) {
                ama(i2 + 1);
            }
            BK(true);
            AppMethodBeat.o(34267);
            return;
        }
        gMT();
        AppMethodBeat.o(34267);
    }

    @Override // com.tencent.mm.modelvoice.c
    public final void ah(ca caVar) {
        AppMethodBeat.i(34268);
        if (this.Pen && this.Peh.isEmpty()) {
            AppMethodBeat.o(34268);
        } else if (caVar == null || !caVar.gAy() || caVar.field_isSend == 1) {
            AppMethodBeat.o(34268);
        } else if (caVar.field_talker == null || !caVar.field_talker.equals(this.dom.getTalkerUserName())) {
            AppMethodBeat.o(34268);
        } else if (!bg.azz().foreground || !this.dom.cQp) {
            AppMethodBeat.o(34268);
        } else if (s.aj(caVar)) {
            Log.e("MicroMsg.AutoPlay", "should not in this setData");
            AppMethodBeat.o(34268);
        } else {
            bf(caVar);
            if (!this.ipv && !this.qUl.isPlaying() && Util.isTopActivity(this.context)) {
                BK(true);
            }
            AppMethodBeat.o(34268);
        }
    }

    public final void gMP() {
        AppMethodBeat.i(34269);
        this.ipv = false;
        BK(true);
        AppMethodBeat.o(34269);
    }

    private void gMQ() {
        int i2;
        AppMethodBeat.i(34270);
        int size = this.Peh.size();
        int i3 = 0;
        int i4 = -1;
        while (i3 < size) {
            if (this.Peh.get(i3).field_msgId == this.Pei) {
                i2 = i3;
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        if (i4 != -1) {
            this.Peh.remove(i4);
        }
        Log.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.Peh.size());
        if (this.Peh.size() == 0) {
            EventCenter.instance.asyncPublish(new zc(), Looper.getMainLooper());
        }
        AppMethodBeat.o(34270);
    }

    public final void BK(boolean z) {
        AppMethodBeat.i(34271);
        Log.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", Integer.valueOf(this.Peh.size()), Boolean.valueOf(z));
        if (this.Peh.size() <= 0) {
            this.Peu.sendEmptyMessageDelayed(0, 1000);
            AppMethodBeat.o(34271);
            return;
        }
        if (this.qUl != null) {
            this.qUl.cZ(z);
            this.qUl.cY(z);
        }
        gMR();
        AppMethodBeat.o(34271);
    }

    public final void gMR() {
        long j2;
        AppMethodBeat.i(34272);
        try {
            Log.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.Peh.size());
            if (this.Peh.size() <= 0) {
                this.Peu.sendEmptyMessageDelayed(0, 1000);
                AppMethodBeat.o(34272);
                return;
            }
            long j3 = this.Peh.get(0).field_createTime;
            int size = this.Peh.size();
            int i2 = 1;
            int i3 = 0;
            while (i2 < size) {
                if (j3 > this.Peh.get(i2).field_createTime) {
                    j2 = this.Peh.get(i2).field_createTime;
                    i3 = i2;
                } else {
                    j2 = j3;
                }
                i2++;
                j3 = j2;
            }
            ca caVar = this.Peh.get(i3);
            if (caVar != null) {
                bg(caVar);
            }
            AppMethodBeat.o(34272);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AutoPlay", e2, "", new Object[0]);
            AppMethodBeat.o(34272);
        }
    }

    public final void BL(boolean z) {
        AppMethodBeat.i(232834);
        Log.printInfoStack("MicroMsg.AutoPlay", "speakerOn has been set %s", Boolean.valueOf(z));
        this.qUm = z;
        AppMethodBeat.o(232834);
    }

    public final void gMS() {
        AppMethodBeat.i(34273);
        if (this.qUl != null && this.qUl.isPlaying()) {
            Log.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", Boolean.valueOf(this.qUm), Boolean.valueOf(this.qUl.isPlaying()));
            this.qUl.cU(this.qUm);
        }
        AppMethodBeat.o(34273);
    }

    public final void release() {
        AppMethodBeat.i(34274);
        Log.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
        if (this.qUp != null) {
            this.qUp.stopShake();
        }
        AppMethodBeat.o(34274);
    }

    private void bg(ca caVar) {
        boolean z = true;
        AppMethodBeat.i(232835);
        Assert.assertTrue(caVar != null && (caVar.gAy() || caVar.gDs() || caVar.gDt() || caVar.gDu()));
        Log.i("MicroMsg.AutoPlay", "start play msg: %d", Long.valueOf(caVar.field_msgId));
        if (!this.qUq.hasRegistered()) {
            this.qUq.setSensorCallBack(this);
            if (this.qUp.startShake(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(34258);
                    d.this.lastShakeTime = Util.currentTicks();
                    AppMethodBeat.o(34258);
                }
            })) {
                this.lastShakeTime = 0;
            } else {
                this.lastShakeTime = -1;
            }
        }
        bg.aVF();
        if (com.tencent.mm.model.c.isSDCardAvailable() || Util.isNullOrNil(caVar.field_imgPath)) {
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable() && this.Pek.qUn) {
                if (this.Pej != null) {
                    this.Pej.dismiss();
                }
                boolean cdW = com.tencent.mm.plugin.audio.c.a.cdW();
                boolean ceb = com.tencent.mm.plugin.audio.c.a.ceb();
                Log.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPlugged: %b, isBluetoothOn: %b", Boolean.valueOf(cdW), Boolean.valueOf(ceb));
                if (cdW || !ceb) {
                    u.u(this.dom.Pwc.getActivity(), this.context.getString(R.string.aw0), R.raw.icons_filled_ear);
                } else {
                    u.u(this.dom.Pwc.getActivity(), this.context.getString(R.string.avz), R.raw.icons_filled_bluetooth);
                }
            }
            MMEntryLock.lock("keep_app_silent");
            s.ak(caVar);
            this.qUl.stop(true);
            this.Pek.acquireWakeLock();
            if (com.tencent.mm.plugin.audio.c.a.cdW() || com.tencent.mm.plugin.audio.c.a.ceb()) {
                Log.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cdW()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.ceb()));
                this.qUm = false;
            }
            String fullPath = getFullPath(caVar.field_imgPath);
            Log.i("MicroMsg.AutoPlay", "startplay");
            boolean Rm = s.Rm(caVar.field_imgPath);
            if (!Rm) {
                h.INSTANCE.idkeyStat(111, 175, 1, false);
            }
            if (!Rm || !this.qUl.a(fullPath, this.qUm, true, -1)) {
                this.Pei = -1;
                gMO();
                Toast.makeText(this.context, this.context.getString(R.string.b1n), 0).show();
            } else {
                k kVar = this.qUl;
                if (this.Peh.size() <= 1) {
                    z = false;
                }
                kVar.db(z);
                this.qUl.a((k.a) this);
                this.qUl.a((k.b) this);
                this.qUl.a((k.c) this);
                this.qUl.a((k.d) this);
                this.Pei = caVar.field_msgId;
                this.Peq = new com.tencent.mm.modelvoice.p(caVar.field_content).time;
                this.Pep = System.currentTimeMillis();
            }
            cmy();
            this.Peo = false;
            AppMethodBeat.o(232835);
            return;
        }
        this.Peh.clear();
        u.g(this.context, this.dom.Pwc.getContentView());
        AppMethodBeat.o(232835);
    }

    private String getFullPath(String str) {
        AppMethodBeat.i(232836);
        if (this.dyc == 1) {
            String cz = com.tencent.mm.plugin.subapp.d.h.cz(str, false);
            AppMethodBeat.o(232836);
            return cz;
        }
        String fullPath = s.getFullPath(str);
        AppMethodBeat.o(232836);
        return fullPath;
    }

    public final void gMT() {
        AppMethodBeat.i(34275);
        Log.i("MicroMsg.AutoPlay", "stop play");
        MMEntryLock.unlock("keep_app_silent");
        this.qUl.cZ(true);
        this.qUl.stop();
        AppMethodBeat.o(34275);
    }

    private void cmy() {
        AppMethodBeat.i(34276);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(34259);
                d.this.dom.cmy();
                AppMethodBeat.o(34259);
            }
        });
        AppMethodBeat.o(34276);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(34277);
        boolean isPlaying = this.qUl.isPlaying();
        AppMethodBeat.o(34277);
        return isPlaying;
    }

    @Override // com.tencent.mm.ak.k.a
    public final void onCompletion() {
        AppMethodBeat.i(34278);
        Log.i("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", Boolean.valueOf(this.qUm), Long.valueOf(this.Pei), Long.valueOf(this.Peq));
        h.INSTANCE.a(15160, Long.valueOf(this.Pei), Long.valueOf(this.Peq), Long.valueOf(this.Peq), 0);
        if (this.context != null) {
            Log.i("MicroMsg.AutoPlay", "stop play complete");
            MMEntryLock.unlock("keep_app_silent");
            this.Pek.releaseWakeLock();
            gMQ();
            if (this.Peh.isEmpty()) {
                this.qUq.removeSensorCallBack();
                this.qUp.stopShake();
            }
            cmy();
            this.Pei = -1;
            gMU();
            this.Pek.releaseWakeLock();
            BK(false);
        }
        AppMethodBeat.o(34278);
    }

    @Override // com.tencent.mm.ak.k.b
    public final void onError() {
        AppMethodBeat.i(34279);
        Log.e("MicroMsg.AutoPlay", "voice play error");
        gMT();
        BK(true);
        AppMethodBeat.o(34279);
    }

    @Override // com.tencent.mm.ak.k.c
    public final void fw(boolean z) {
        AppMethodBeat.i(34280);
        Log.w("MicroMsg.AutoPlay", "voice play pause. %b", Boolean.valueOf(z));
        onStop();
        AppMethodBeat.o(34280);
    }

    @Override // com.tencent.mm.ak.k.d
    public final void onStop() {
        int i2 = 2;
        AppMethodBeat.i(34281);
        Log.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", Long.valueOf(this.Pei), Long.valueOf(this.Peq), Long.valueOf(Util.milliSecondsToNow(this.Pep)), Boolean.valueOf(this.Pes), Boolean.valueOf(this.Per), Util.getStack());
        if (this.Pei > 0) {
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[4];
            objArr[0] = Long.valueOf(this.Pei);
            objArr[1] = Long.valueOf(this.Peq);
            objArr[2] = Long.valueOf(Util.milliSecondsToNow(this.Pep));
            if (this.Pes) {
                i2 = 3;
            } else if (this.Per) {
                i2 = 1;
            }
            objArr[3] = Integer.valueOf(i2);
            hVar.a(15160, objArr);
        }
        this.Pes = false;
        this.Per = false;
        this.Pek.releaseWakeLock();
        gMQ();
        if (this.Peh.isEmpty()) {
            this.qUq.removeSensorCallBack();
            this.qUp.stopShake();
        }
        cmy();
        this.Pei = -1;
        gMU();
        this.Peo = false;
        setScreenEnable(true);
        AppMethodBeat.o(34281);
    }

    @Override // com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack
    public final void onSensorEvent(final boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(34282);
        Log.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + z + "  hasSkip:" + this.qUo + " tick:" + Util.ticksToNow(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
        if (this.qUo) {
            if (z) {
                z2 = false;
            }
            this.qUo = z2;
            AppMethodBeat.o(34282);
        } else if (this.context == null) {
            this.qUq.removeSensorCallBack();
            AppMethodBeat.o(34282);
        } else {
            Log.i("MicroMsg.AutoPlay", "isScreenOn: %s", Boolean.valueOf(isScreenEnable()));
            if (z || this.lastShakeTime == -1 || Util.ticksToNow(this.lastShakeTime) <= 400) {
                this.qUo = false;
                if (this.qUl.isCalling()) {
                    AppMethodBeat.o(34282);
                } else if (com.tencent.mm.plugin.audio.c.a.ceb()) {
                    gMU();
                    Log.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
                    AppMethodBeat.o(34282);
                } else if (this.Pek.qUn) {
                    BL(false);
                    if (this.Pei != -1) {
                        setScreenEnable(z);
                        this.Peo = z;
                    } else {
                        setScreenEnable(true);
                        this.Peo = true;
                    }
                    gMS();
                    AppMethodBeat.o(34282);
                } else {
                    if (this.Pei != -1) {
                        if (isScreenEnable() == z) {
                            AppMethodBeat.o(34282);
                            return;
                        }
                        setScreenEnable(z);
                        this.Peo = z;
                        new MTimerHandler(new MTimerHandler.CallBack() {
                            /* class com.tencent.mm.ui.chatting.d.AnonymousClass6 */

                            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                            public final boolean onTimerExpired() {
                                AppMethodBeat.i(34260);
                                if (!z) {
                                    Log.i("MicroMsg.AutoPlay", "speaker off");
                                    d.this.BL(false);
                                    d dVar = d.this;
                                    if (dVar.qUl.isPlaying()) {
                                        Log.d("MicroMsg.AutoPlay", "deal sensor event, play next");
                                        dVar.qUl.cZ(false);
                                        dVar.BK(false);
                                    }
                                } else {
                                    Log.i("MicroMsg.AutoPlay", "speaker true");
                                    d.e(d.this);
                                    if (d.this.context != null) {
                                        d.this.Pel = u.a(d.this.dom.Pwc.getActivity(), d.this.context.getString(R.string.dg1), 2000);
                                    }
                                    d.this.BL(true);
                                    d.this.gMS();
                                }
                                AppMethodBeat.o(34260);
                                return false;
                            }
                        }, false).startTimer(50);
                    }
                    Log.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", Boolean.valueOf(this.Peo));
                    AppMethodBeat.o(34282);
                }
            } else {
                this.qUo = true;
                AppMethodBeat.o(34282);
            }
        }
    }

    private void setScreenEnable(boolean z) {
        AppMethodBeat.i(34283);
        if (this.dom != null) {
            this.dom.Pwc.getController().setScreenEnable(z);
        }
        AppMethodBeat.o(34283);
    }

    private boolean isScreenEnable() {
        AppMethodBeat.i(34284);
        if (this.dom != null) {
            boolean z = this.dom.Pwc.getController().OFT;
            AppMethodBeat.o(34284);
            return z;
        }
        AppMethodBeat.o(34284);
        return false;
    }

    public final void gMU() {
        AppMethodBeat.i(34285);
        if (this.Pel != null) {
            this.Pel.dismiss();
        }
        AppMethodBeat.o(34285);
    }

    @Override // com.tencent.mm.model.ao
    public final void aVl() {
        AppMethodBeat.i(34286);
        Log.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
        this.Pes = false;
        AppMethodBeat.o(34286);
    }

    @Override // com.tencent.mm.model.ao
    public final void aVm() {
        AppMethodBeat.i(34287);
        Log.printInfoStack("MicroMsg.AutoPlay", "phone comming or record start, stop play", new Object[0]);
        this.Pes = true;
        gMT();
        gMO();
        try {
            if (this.qUq != null) {
                this.qUq.removeSensorCallBack();
            }
            if (this.qUp != null) {
                this.qUp.stopShake();
            }
            AppMethodBeat.o(34287);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AutoPlay", e2, "reset sensor error: %s", e2.getMessage());
            AppMethodBeat.o(34287);
        }
    }
}
