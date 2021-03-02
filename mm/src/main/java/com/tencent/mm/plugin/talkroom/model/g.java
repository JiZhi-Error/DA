package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bh.a;
import com.tencent.mm.bh.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.talkroom.b.f;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a;
import com.tencent.mm.plugin.talkroom.component.b;
import com.tencent.mm.plugin.talkroom.component.c;
import com.tencent.mm.plugin.talkroom.component.d;
import com.tencent.mm.plugin.talkroom.component.e;
import com.tencent.mm.plugin.talkroom.model.i;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsOnlineSDKExtensionEntry;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements i, a, c, ao {
    public static final int[] FQH = {80, 8080, 16285};
    public static final byte[][] FQI = {new byte[]{101, -30, 76, 27}, new byte[]{112, 64, -19, -29}, new byte[]{120, -52, -55, -58}};
    private com.tencent.mm.plugin.talkroom.component.a FQA;
    private b FQB;
    private e FQC;
    private d FQD;
    private MAlarmHandler FQE;
    private MTimerHandler FQF;
    private i FQG = new i();
    public boolean FQJ = false;
    private int FQs = 0;
    private int FQt = 0;
    private boolean FQu = false;
    public String FQv;
    private int FQw;
    private int FQx;
    private int FQy;
    private LinkedList<egr> FQz = new LinkedList<>();
    private final ServiceConnection qmC = new ServiceConnection() {
        /* class com.tencent.mm.plugin.talkroom.model.g.AnonymousClass1 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(29483);
            Log.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
            if (iBinder == null) {
                g.this.FQG.s("enterTalkRoom bindServie or protocalInit failed", 3, -1);
                AppMethodBeat.o(29483);
                return;
            }
            g.this.FQA = a.AbstractBinderC1793a.D(iBinder);
            if (g.this.state >= 2) {
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.talkroom.model.g.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(29482);
                        g.this.wi(true);
                        AppMethodBeat.o(29482);
                    }
                });
            }
            AppMethodBeat.o(29483);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(29484);
            Log.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
            AppMethodBeat.o(29484);
        }
    };
    private int roomId;
    private int state = 0;
    private long ypH;

    static /* synthetic */ void a(g gVar, int i2) {
        AppMethodBeat.i(29526);
        gVar.abq(i2);
        AppMethodBeat.o(29526);
    }

    static /* synthetic */ void c(g gVar) {
        AppMethodBeat.i(29524);
        gVar.wh(true);
        AppMethodBeat.o(29524);
    }

    static /* synthetic */ void c(g gVar, int i2) {
        AppMethodBeat.i(29527);
        gVar.abr(i2);
        AppMethodBeat.o(29527);
    }

    static /* synthetic */ void d(g gVar) {
        AppMethodBeat.i(29525);
        gVar.fud();
        AppMethodBeat.o(29525);
    }

    public g() {
        AppMethodBeat.i(29493);
        TalkRoomReceiver.init();
        AppMethodBeat.o(29493);
    }

    public final int ftY() {
        AppMethodBeat.i(29494);
        if (this.FQs == 1 || (com.tencent.mm.bi.d.jpA != null && com.tencent.mm.bi.d.jpA.PZ(this.FQv))) {
            AppMethodBeat.o(29494);
            return 1;
        }
        AppMethodBeat.o(29494);
        return 0;
    }

    public final List ecY() {
        AppMethodBeat.i(29495);
        LinkedList<egs> aSV = b.ftO().aSV(this.FQv);
        AppMethodBeat.o(29495);
        return aSV;
    }

    public final String ftZ() {
        AppMethodBeat.i(29496);
        Iterator<egs> it = b.ftO().aSV(this.FQv).iterator();
        while (it.hasNext()) {
            egs next = it.next();
            if (next.NgD == this.FQy) {
                String str = next.UserName;
                AppMethodBeat.o(29496);
                return str;
            }
        }
        AppMethodBeat.o(29496);
        return null;
    }

    @Override // com.tencent.mm.bh.c
    public final void a(com.tencent.mm.bh.d dVar) {
        AppMethodBeat.i(29497);
        i iVar = this.FQG;
        synchronized (dVar) {
            try {
                if (!iVar.callbacks.contains(dVar)) {
                    iVar.callbacks.add(dVar);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(29497);
                throw th;
            }
        }
        this.FQG.PX(ftZ());
        AppMethodBeat.o(29497);
    }

    @Override // com.tencent.mm.bh.c
    public final void b(com.tencent.mm.bh.d dVar) {
        AppMethodBeat.i(29498);
        i iVar = this.FQG;
        synchronized (dVar) {
            try {
                iVar.callbacks.remove(dVar);
            } finally {
                AppMethodBeat.o(29498);
            }
        }
    }

    private boolean fua() {
        AppMethodBeat.i(29499);
        if (ftY() == 1) {
            b(b.ftM().FPB);
        } else {
            a(b.ftM().FPB);
        }
        if (this.FQt > 0) {
            Log.i("MicroMsg.TalkRoomServer", "addListener has init before");
            AppMethodBeat.o(29499);
        } else {
            bg.azz().a(TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_THROWABLE, this);
            bg.azz().a(TbsListener.ErrorCode.ERROR_ONE_WIZARD_CREATE_FAIL, this);
            bg.azz().a(336, this);
            bg.azz().a(335, this);
            b.ftO().a(this);
            bg.Xi().a(this);
            this.FQt = 1;
            if (this.FQA != null) {
                try {
                    this.FQA.Close();
                    this.FQA.uninitLive();
                } catch (RemoteException e2) {
                    Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
                }
            }
            MMApplicationContext.getContext().bindService(new Intent(MMApplicationContext.getContext(), TalkRoomService.class), this.qmC, 1);
            this.FQB = new b.a() {
                /* class com.tencent.mm.plugin.talkroom.model.g.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.talkroom.component.b
                public final void keep_OnOpenSuccess() {
                    AppMethodBeat.i(29487);
                    Log.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
                    if (g.this.state != 1) {
                        Log.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", Integer.valueOf(g.this.state));
                        AppMethodBeat.o(29487);
                        return;
                    }
                    b.ftQ().ftV();
                    new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.mm.plugin.talkroom.model.g.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(29485);
                            g.c(g.this);
                            AppMethodBeat.o(29485);
                        }
                    });
                    g.d(g.this);
                    g.this.FQG.bgz();
                    AppMethodBeat.o(29487);
                }

                @Override // com.tencent.mm.plugin.talkroom.component.b
                public final void keep_OnError(int i2) {
                    AppMethodBeat.i(29488);
                    Log.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", Integer.valueOf(i2));
                    b.ftQ().ftV();
                    b.ftQ().FPP = 1;
                    g.this.FQG.s("component OnError ".concat(String.valueOf(i2)), 99, i2);
                    new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.mm.plugin.talkroom.model.g.AnonymousClass2.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(29486);
                            g.this.fub();
                            AppMethodBeat.o(29486);
                        }
                    });
                    AppMethodBeat.o(29488);
                }
            };
            AppMethodBeat.o(29499);
        }
        return true;
    }

    private void removeListener() {
        AppMethodBeat.i(29500);
        this.FQt = 0;
        bg.azz().b(TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_THROWABLE, this);
        bg.azz().b(TbsListener.ErrorCode.ERROR_ONE_WIZARD_CREATE_FAIL, this);
        bg.azz().b(336, this);
        bg.azz().b(335, this);
        b.ftO().b(this);
        bg.Xi().b(this);
        b(b.ftM().FPB);
        int i2 = TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE;
        if (this.FQA != null) {
            try {
                i2 = this.FQA.uninitLive();
            } catch (RemoteException e2) {
                Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
        }
        MMApplicationContext.getContext().unbindService(this.qmC);
        MMApplicationContext.getContext().stopService(new Intent(MMApplicationContext.getContext(), TalkRoomService.class));
        this.FQA = null;
        if (i2 < 0) {
            Log.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", Integer.valueOf(i2));
        }
        AppMethodBeat.o(29500);
    }

    @Override // com.tencent.mm.bh.c
    public final void aw(String str, int i2) {
        AppMethodBeat.i(29501);
        Log.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", str, Integer.valueOf(i2));
        this.FQs = i2;
        fua();
        if (str.equals(this.FQv)) {
            Log.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", str);
            if (this.state == 2) {
                this.FQG.bgz();
            }
            AppMethodBeat.o(29501);
            return;
        }
        Log.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", str);
        this.FQv = str;
        bg.azz().a(new com.tencent.mm.plugin.talkroom.b.a(this.FQv, ftY()), 0);
        b.ftM().FPD = new f();
        b.ftQ().FQm = Util.currentTicks();
        b.ftQ().FQj = str;
        if (ftY() == 0) {
            b.ftM().FPB.yJA = true;
        }
        i iVar = this.FQG;
        i.AnonymousClass11 r1 = new Runnable(str) {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass11 */
            final /* synthetic */ String gsB;

            {
                this.gsB = r2;
            }

            public final void run() {
                AppMethodBeat.i(29539);
                synchronized (i.this.callbacks) {
                    try {
                        Iterator<com.tencent.mm.bh.d> it = i.this.callbacks.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    } finally {
                        AppMethodBeat.o(29539);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r1.run();
            AppMethodBeat.o(29501);
            return;
        }
        iVar.handler.post(r1);
        AppMethodBeat.o(29501);
    }

    public final void fub() {
        int i2;
        AppMethodBeat.i(29502);
        Log.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
        wh(false);
        if (Util.isNullOrNil(this.FQv)) {
            Log.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
            AppMethodBeat.o(29502);
            return;
        }
        b.ftQ().exitRoom();
        this.state = 0;
        this.FQu = false;
        bg.azz().a(new com.tencent.mm.plugin.talkroom.b.b(this.roomId, this.ypH, this.roomId != 0 ? this.FQv : "", ftY()), 0);
        if (this.FQA != null) {
            try {
                i2 = this.FQA.Close();
            } catch (RemoteException e2) {
                Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
                i2 = -99999;
            }
            if (i2 < 0) {
                Log.e("MicroMsg.TalkRoomServer", "engine.Close error %d", Integer.valueOf(i2));
            }
            PByteArray pByteArray = new PByteArray();
            if (a(pByteArray, aa.getDisplayName(this.FQv)) == 0) {
                String str = new String(pByteArray.value);
                Log.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", Integer.valueOf(pByteArray.value.length), str);
                LinkedList linkedList = new LinkedList();
                egt egt = new egt();
                egt.MlF = 10402;
                egt.NgE = new dqi().bhy(str);
                egt egt2 = new egt();
                egt2.MlF = 10404;
                egt2.NgE = new dqi().bhy(b.ftQ().toString());
                linkedList.add(egt);
                linkedList.add(egt2);
                bg.azz().a(new com.tencent.mm.plugin.talkroom.b.g(linkedList, ftY()), 0);
            }
        }
        this.FQv = "";
        this.roomId = 0;
        this.ypH = 0;
        this.FQw = 0;
        this.FQx = 0;
        this.FQy = 0;
        this.FQz.clear();
        fuc();
        this.FQG.bgB();
        b.ftM().FPB.ftS();
        removeListener();
        AppMethodBeat.o(29502);
    }

    private void fuc() {
        AppMethodBeat.i(29503);
        if (this.FQC != null) {
            try {
                this.FQC.release();
            } catch (RemoteException e2) {
                Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            this.FQC = null;
        }
        if (this.FQD != null) {
            try {
                this.FQD.release();
            } catch (RemoteException e3) {
                Log.printErrStackTrace("MicroMsg.TalkRoomServer", e3, "", new Object[0]);
            }
            this.FQD = null;
        }
        if (this.FQE != null) {
            this.FQE.stopTimer();
            this.FQE = null;
        }
        if (this.FQF != null) {
            this.FQF.stopTimer();
            this.FQF = null;
        }
        AppMethodBeat.o(29503);
    }

    private void wh(boolean z) {
        int i2;
        AppMethodBeat.i(29504);
        if (Util.isNullOrNil(this.FQv)) {
            AppMethodBeat.o(29504);
            return;
        }
        bg.aVF();
        az bjY = com.tencent.mm.model.c.aST().bjY(this.FQv);
        if (bjY == null) {
            AppMethodBeat.o(29504);
            return;
        }
        if (z) {
            i2 = 5;
        } else {
            i2 = 6;
        }
        bjY.yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(bjY, i2, bjY.field_conversationTime));
        bg.aVF();
        com.tencent.mm.model.c.aST().a(bjY, this.FQv);
        AppMethodBeat.o(29504);
    }

    @Override // com.tencent.mm.bh.c
    public final boolean bgw() {
        AppMethodBeat.i(29505);
        Log.i("MicroMsg.TalkRoomServer", "seizeMic");
        if (this.state != 2) {
            Log.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
            if (this.state == 0) {
                this.FQG.j(3, -1, "seizeMic in outside room state");
            }
            AppMethodBeat.o(29505);
            return false;
        }
        if (this.FQC != null) {
            try {
                this.FQC.cXa();
            } catch (RemoteException e2) {
                Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
        }
        this.state = 3;
        bg.azz().a(new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.ypH, 1, this.FQv, ftY()), 0);
        b.ftQ().FQo = Util.currentTicks();
        b.ftQ().FQr = true;
        AppMethodBeat.o(29505);
        return true;
    }

    @Override // com.tencent.mm.bh.c
    public final void bgx() {
        AppMethodBeat.i(29506);
        Log.i("MicroMsg.TalkRoomServer", "putAwayMic");
        f ftQ = b.ftQ();
        if (ftQ.FQr && !ftQ.FQq) {
            ftQ.FQl++;
        }
        ftQ.FQq = false;
        ftQ.FQr = false;
        if (this.state < 3) {
            Log.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
            AppMethodBeat.o(29506);
            return;
        }
        if (this.FQF != null) {
            this.FQF.stopTimer();
            this.FQF = null;
        }
        fud();
        bg.azz().a(new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.ypH, 2, this.FQv, ftY()), 0);
        AppMethodBeat.o(29506);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(29507);
        Log.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
        f fVar = (f) qVar;
        if (fVar.fui() == null || !fVar.fui().equals(this.FQv)) {
            Log.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", fVar.fui(), this.FQv);
            AppMethodBeat.o(29507);
            return;
        }
        if (!(i2 == 0 && i3 == 0)) {
            if (qVar.getType() == 332) {
                b.ftQ().abp(2);
                if (i2 == 4) {
                    b.ftQ().FQk = i3;
                }
                this.FQG.s("cgi enter failed : errType:" + i2 + " errCode:" + i3, i2, i3);
                fub();
                AppMethodBeat.o(29507);
                return;
            } else if (qVar.getType() == 334) {
                if (((com.tencent.mm.plugin.talkroom.b.d) qVar).actionType != 1) {
                    AppMethodBeat.o(29507);
                    return;
                }
                f ftQ = b.ftQ();
                ftQ.FPT++;
                ftQ.FQo = 0;
                fud();
                Log.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
                if (i2 == 4 && (i3 == 311 || i3 == 340)) {
                    this.FQG.ua(i3);
                    AppMethodBeat.o(29507);
                    return;
                }
                this.FQG.j(i2, i3, "TalkMicAction failed!!");
                AppMethodBeat.o(29507);
                return;
            } else if (qVar.getType() == 336) {
                this.FQu = false;
                this.FQG.j(i2, i3, "TalkGetMember failed!!");
                fub();
                AppMethodBeat.o(29507);
                return;
            } else if (qVar.getType() == 335) {
                this.FQG.j(i2, i3, "TalkNoop failed!!");
                fub();
                AppMethodBeat.o(29507);
                return;
            }
        }
        if (qVar.getType() == 332) {
            b.ftQ().abp(1);
            com.tencent.mm.plugin.talkroom.b.a aVar = (com.tencent.mm.plugin.talkroom.b.a) qVar;
            this.roomId = aVar.roomId;
            this.ypH = aVar.ypH;
            this.FQw = aVar.FQw;
            this.FQx = aVar.FQx;
            this.FQz = aVar.FQz;
            f ftQ2 = b.ftQ();
            int i4 = this.roomId;
            long j2 = this.ypH;
            ftQ2.roomId = i4;
            ftQ2.ypH = j2;
            b.ftO().a(this.FQv, aVar.FQR, null, null, fVar.fuj());
            abq(100);
            AppMethodBeat.o(29507);
        } else if (qVar.getType() == 334) {
            com.tencent.mm.plugin.talkroom.b.d dVar = (com.tencent.mm.plugin.talkroom.b.d) qVar;
            if (dVar.actionType == 1) {
                f ftQ3 = b.ftQ();
                if (ftQ3.FQo != 0) {
                    ftQ3.FPR = (Util.ticksToNow(ftQ3.FQo) + (ftQ3.FPR * ((long) ftQ3.FQn))) / ((long) (ftQ3.FQn + 1));
                    ftQ3.FQn++;
                    ftQ3.FPS++;
                    ftQ3.FQo = 0;
                }
                Log.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
                if (dVar.FQw < this.FQw) {
                    Log.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", Integer.valueOf(dVar.FQw), Integer.valueOf(this.FQw));
                    fud();
                    this.FQG.ua(TPNativePlayerInitConfig.INT_WIDTH);
                    AppMethodBeat.o(29507);
                    return;
                }
                this.FQw = dVar.FQw;
                int i5 = TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE;
                try {
                    i5 = this.FQA.SetCurrentMicId(this.FQw);
                } catch (RemoteException e2) {
                    Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
                }
                if (this.state != 3) {
                    Log.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
                    AppMethodBeat.o(29507);
                    return;
                }
                i iVar = this.FQG;
                i.AnonymousClass6 r2 = new Runnable() {
                    /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(29534);
                        synchronized (i.this.callbacks) {
                            try {
                                for (com.tencent.mm.bh.d dVar : i.this.callbacks) {
                                    dVar.bgA();
                                }
                            } finally {
                                AppMethodBeat.o(29534);
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    r2.run();
                } else {
                    iVar.handler.post(r2);
                }
                this.state = 4;
                if (i5 < 0) {
                    Log.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", Integer.valueOf(i5));
                }
                if (this.FQF == null) {
                    this.FQF = new MTimerHandler(new MTimerHandler.CallBack() {
                        /* class com.tencent.mm.plugin.talkroom.model.g.AnonymousClass3 */

                        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                        public final boolean onTimerExpired() {
                            AppMethodBeat.i(29489);
                            int i2 = g.this.roomId;
                            long j2 = g.this.ypH;
                            String str = g.this.FQv;
                            g gVar = g.this;
                            String unused = g.this.FQv;
                            bg.azz().a(new com.tencent.mm.plugin.talkroom.b.d(i2, j2, 1, str, gVar.ftY()), 0);
                            AppMethodBeat.o(29489);
                            return true;
                        }
                    }, true);
                    this.FQF.startTimer(5000);
                }
                AppMethodBeat.o(29507);
                return;
            }
            Log.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
            AppMethodBeat.o(29507);
        } else {
            if (qVar.getType() == 336) {
                com.tencent.mm.plugin.talkroom.b.c cVar = (com.tencent.mm.plugin.talkroom.b.c) qVar;
                b.ftO().a(this.FQv, cVar.FQR, null, null, fVar.fuj());
                abr(cVar.FQw);
                this.FQu = false;
                this.FQG.PX(ftZ());
            }
            if (qVar.getType() == 335 && this.state == 0) {
                this.FQG.j(3, -1, "talknoop success but in outside room state");
            }
            AppMethodBeat.o(29507);
        }
    }

    private void fud() {
        AppMethodBeat.i(29508);
        try {
            b.ftQ().ftX();
            if (this.FQD != null) {
                this.FQD.ftI();
            }
            if (this.FQC != null) {
                this.FQC.eYd();
            }
            this.state = 2;
            AppMethodBeat.o(29508);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            AppMethodBeat.o(29508);
        }
    }

    @Override // com.tencent.mm.bh.c
    public final void bgt() {
        AppMethodBeat.i(29509);
        Log.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", Integer.valueOf(this.state));
        if (this.state != 4) {
            AppMethodBeat.o(29509);
            return;
        }
        f ftQ = b.ftQ();
        ftQ.FQq = true;
        ftQ.FQp = Util.currentTicks();
        try {
            this.FQD.bgt();
            AppMethodBeat.o(29509);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            AppMethodBeat.o(29509);
        }
    }

    private void abq(final int i2) {
        AppMethodBeat.i(29510);
        if (this.FQA != null) {
            try {
                fue();
                AppMethodBeat.o(29510);
            } catch (RemoteException e2) {
                Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
                AppMethodBeat.o(29510);
            }
        } else if (i2 == 0) {
            this.FQG.s("bind talkroomService timeout", 3, -1);
            AppMethodBeat.o(29510);
        } else {
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.talkroom.model.g.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(29490);
                    g.a(g.this, i2 - 1);
                    AppMethodBeat.o(29490);
                }
            }, 50);
            AppMethodBeat.o(29510);
        }
    }

    private void fue() {
        AppMethodBeat.i(29511);
        this.state = 1;
        this.FQu = false;
        if (!fuf()) {
            AppMethodBeat.o(29511);
            return;
        }
        fuc();
        fuh();
        fug();
        if (this.FQE != null) {
            Log.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
            AppMethodBeat.o(29511);
            return;
        }
        this.FQE = new MAlarmHandler(new MAlarmHandler.CallBack() {
            /* class com.tencent.mm.plugin.talkroom.model.g.AnonymousClass5 */

            @Override // com.tencent.mm.sdk.platformtools.MAlarmHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(29491);
                if (g.this.roomId == 0 || Util.isNullOrNil(g.this.FQv)) {
                    Log.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(g.this.roomId), g.this.FQv);
                    g.this.FQE = null;
                    AppMethodBeat.o(29491);
                    return false;
                }
                String str = g.this.FQv;
                int i2 = g.this.roomId;
                long j2 = g.this.ypH;
                g gVar = g.this;
                String unused = g.this.FQv;
                bg.azz().a(new com.tencent.mm.plugin.talkroom.b.e(str, i2, j2, gVar.ftY()), 0);
                AppMethodBeat.o(29491);
                return true;
            }
        }, true);
        this.FQE.startTimer(50000);
        AppMethodBeat.o(29511);
    }

    private boolean fuf() {
        AppMethodBeat.i(29512);
        int i2 = TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE;
        try {
            i2 = this.FQA.ftD();
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
        }
        Log.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
        if (i2 >= 0 || i2 == -3) {
            AppMethodBeat.o(29512);
            return true;
        }
        this.FQA = null;
        Log.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", Integer.valueOf(i2));
        this.FQG.s("enterTalkRoom protocalInit failed", 3, -1);
        AppMethodBeat.o(29512);
        return false;
    }

    private void abr(int i2) {
        AppMethodBeat.i(29513);
        if (i2 > this.FQw) {
            this.FQw = i2;
            if (this.state >= 3) {
                this.FQG.ua(TPNativePlayerInitConfig.INT_WIDTH);
            }
            fud();
        }
        AppMethodBeat.o(29513);
    }

    public final void wi(boolean z) {
        AppMethodBeat.i(29514);
        Log.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", this.FQv);
        if (Util.isNullOrNil(this.FQv) || this.state < 2) {
            AppMethodBeat.o(29514);
            return;
        }
        b.ftQ().ftW();
        if (z) {
            if (!fuf()) {
                AppMethodBeat.o(29514);
                return;
            }
            try {
                fug();
            } catch (RemoteException e2) {
                Log.e("MicroMsg.TalkRoomServer", e2.toString());
                Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
        }
        fud();
        this.state = 1;
        try {
            if (this.FQA != null) {
                this.FQA.Close();
            }
        } catch (RemoteException e3) {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", e3, "", new Object[0]);
        }
        if (this.roomId != 0) {
            fuh();
        }
        if (!z) {
            this.FQG.bgE();
        }
        AppMethodBeat.o(29514);
    }

    private void fug() {
        AppMethodBeat.i(29515);
        if (this.FQA == null) {
            Log.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
            AppMethodBeat.o(29515);
            return;
        }
        this.FQC = this.FQA.a(new c.a() {
            /* class com.tencent.mm.plugin.talkroom.model.g.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.talkroom.component.c
            public final void E(int i2, int i3, boolean z) {
                AppMethodBeat.i(29492);
                if (z) {
                    g.this.FQy = 0;
                    g.this.FQG.PX("");
                    AppMethodBeat.o(29492);
                    return;
                }
                g.c(g.this, i3);
                if (g.this.FQy == i2) {
                    AppMethodBeat.o(29492);
                    return;
                }
                g.this.FQy = i2;
                String ftZ = g.this.ftZ();
                if (!g.this.FQu && ftZ == null) {
                    g.this.FQu = true;
                    int i4 = g.this.roomId;
                    long j2 = g.this.ypH;
                    String str = g.this.FQv;
                    g gVar = g.this;
                    String unused = g.this.FQv;
                    bg.azz().a(new com.tencent.mm.plugin.talkroom.b.c(i4, j2, str, gVar.ftY()), 0);
                    b.ftQ().FPX++;
                    b.ftQ().FPY++;
                }
                g.this.FQG.PX(ftZ);
                PlaySound.play(MMApplicationContext.getContext(), R.string.hl4);
                AppMethodBeat.o(29492);
            }
        });
        this.FQC.start();
        this.FQD = this.FQA.ftE();
        this.FQD.start();
        AppMethodBeat.o(29515);
    }

    private void fuh() {
        int i2;
        AppMethodBeat.i(29517);
        if (this.FQz.size() == 0) {
            Log.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
            this.FQG.j(3, -1, "engine.talk relay addr list empty");
            AppMethodBeat.o(29517);
            return;
        }
        int[] iArr = new int[this.FQz.size()];
        int[] iArr2 = new int[this.FQz.size()];
        String[] strArr = new String[this.FQz.size()];
        Log.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", Integer.valueOf(this.FQz.size()));
        for (int i3 = 0; i3 < this.FQz.size(); i3++) {
            iArr[i3] = this.FQz.get(i3).NgB;
            iArr2[i3] = this.FQz.get(i3).MKe;
            strArr[i3] = this.FQz.get(i3).NgC;
            Log.i("MicroMsg.TalkRoomServer", "add talk relay addr [%s][%s][%d]", abs(this.FQz.get(i3).NgB), this.FQz.get(i3).NgC, Integer.valueOf(this.FQz.get(i3).MKe));
        }
        Log.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", Integer.valueOf(this.FQx), Integer.valueOf(this.roomId), Long.valueOf(this.ypH));
        try {
            com.tencent.mm.plugin.talkroom.component.a aVar = this.FQA;
            b bVar = this.FQB;
            bg.aVF();
            i2 = aVar.a(bVar, com.tencent.mm.model.c.getUin(), this.FQx, this.roomId, this.ypH, iArr, iArr2, 0, strArr);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            i2 = -99999;
        }
        if (i2 < 0 && i2 != -3) {
            Log.e("MicroMsg.TalkRoomServer", "engine.Open error %d", Integer.valueOf(i2));
            this.FQG.j(3, i2, "engine.Open error");
        }
        AppMethodBeat.o(29517);
    }

    @Override // com.tencent.mm.bh.c
    public final short bgu() {
        AppMethodBeat.i(29518);
        if (this.FQD == null) {
            AppMethodBeat.o(29518);
            return 0;
        }
        try {
            short ftJ = (short) this.FQD.ftJ();
            AppMethodBeat.o(29518);
            return ftJ;
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            AppMethodBeat.o(29518);
            return 0;
        }
    }

    @Override // com.tencent.mm.bh.c
    public final short bgv() {
        AppMethodBeat.i(29519);
        if (this.FQC == null) {
            AppMethodBeat.o(29519);
            return 0;
        }
        try {
            short ftJ = (short) this.FQC.ftJ();
            AppMethodBeat.o(29519);
            return ftJ;
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            AppMethodBeat.o(29519);
            return 0;
        }
    }

    private int a(PByteArray pByteArray, String str) {
        AppMethodBeat.i(29520);
        if (this.FQA != null) {
            int[] iArr = new int[1];
            try {
                pByteArray.value = this.FQA.e(iArr, str);
            } catch (RemoteException e2) {
                iArr[0] = -99999;
                Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            int i2 = iArr[0];
            AppMethodBeat.o(29520);
            return i2;
        }
        AppMethodBeat.o(29520);
        return -99;
    }

    @Override // com.tencent.mm.bh.a
    public final void h(String str, String str2, String str3) {
        AppMethodBeat.i(29521);
        if (!str.equals(this.FQv)) {
            AppMethodBeat.o(29521);
            return;
        }
        i iVar = this.FQG;
        i.AnonymousClass10 r1 = new Runnable(str2, str3) {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass10 */
            final /* synthetic */ String yGY;
            final /* synthetic */ String yGZ;

            {
                this.yGY = r2;
                this.yGZ = r3;
            }

            public final void run() {
                AppMethodBeat.i(29538);
                synchronized (i.this.callbacks) {
                    try {
                        for (com.tencent.mm.bh.d dVar : i.this.callbacks) {
                            dVar.bA(this.yGY, this.yGZ);
                        }
                    } finally {
                        AppMethodBeat.o(29538);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r1.run();
            AppMethodBeat.o(29521);
            return;
        }
        iVar.handler.post(r1);
        AppMethodBeat.o(29521);
    }

    @Override // com.tencent.mm.bh.c
    public final boolean bgy() {
        return this.FQJ;
    }

    private static String abs(int i2) {
        AppMethodBeat.i(29516);
        try {
            String hostAddress = InetAddress.getByAddress(new byte[]{(byte) ((i2 >>> 24) & 255), (byte) ((i2 >>> 16) & 255), (byte) ((i2 >>> 8) & 255), (byte) (i2 & 255)}).getHostAddress();
            AppMethodBeat.o(29516);
            return hostAddress;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            AppMethodBeat.o(29516);
            return null;
        }
    }

    @Override // com.tencent.mm.model.ao
    public final void aVl() {
        AppMethodBeat.i(29522);
        Log.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
        if (Util.isNullOrNil(this.FQv)) {
            Log.d("MicroMsg.TalkRoomServer", "pause");
        } else {
            fud();
        }
        this.FQJ = false;
        i iVar = this.FQG;
        i.AnonymousClass3 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(29531);
                synchronized (i.this.callbacks) {
                    try {
                        for (com.tencent.mm.bh.d dVar : i.this.callbacks) {
                            dVar.bgD();
                        }
                    } finally {
                        AppMethodBeat.o(29531);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r1.run();
            AppMethodBeat.o(29522);
            return;
        }
        iVar.handler.post(r1);
        AppMethodBeat.o(29522);
    }

    @Override // com.tencent.mm.model.ao
    public final void aVm() {
        AppMethodBeat.i(29523);
        Log.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
        try {
            if (Util.isNullOrNil(this.FQv)) {
                Log.d("MicroMsg.TalkRoomServer", "pause");
            } else {
                if (this.FQD != null) {
                    this.FQD.ftI();
                }
                if (this.FQC != null) {
                    this.FQC.cXa();
                }
                this.state = 2;
            }
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
        }
        this.FQJ = true;
        i iVar = this.FQG;
        i.AnonymousClass2 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(29530);
                synchronized (i.this.callbacks) {
                    try {
                        for (com.tencent.mm.bh.d dVar : i.this.callbacks) {
                            dVar.bgC();
                        }
                    } finally {
                        AppMethodBeat.o(29530);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r1.run();
            AppMethodBeat.o(29523);
            return;
        }
        iVar.handler.post(r1);
        AppMethodBeat.o(29523);
    }
}
