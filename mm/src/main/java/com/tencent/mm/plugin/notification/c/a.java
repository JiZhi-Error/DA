package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.plugin.notification.d.b;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.notification.ui.b;
import com.tencent.mm.plugin.notification.ui.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<T> implements c {
    protected b AGQ;
    protected FailSendMsgNotification AGR;
    protected boolean AGS;
    protected ArrayList<Long> AGT;
    protected ArrayList<Long> AGU;
    protected ArrayList<Long> AGV;
    private ArrayList<MTimerHandler> AGW;
    private MTimerHandler AGX;
    private IListener AGY;
    protected Context mContext;

    public abstract void HA(long j2);

    public abstract boolean HB(long j2);

    /* access modifiers changed from: protected */
    public abstract String TR(int i2);

    /* access modifiers changed from: protected */
    public abstract void aH(ArrayList<Long> arrayList);

    /* access modifiers changed from: protected */
    public abstract String av(int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract long dK(T t);

    /* access modifiers changed from: protected */
    public abstract ArrayList<Long> dL(T t);

    /* access modifiers changed from: protected */
    public abstract void eyK();

    /* access modifiers changed from: protected */
    public abstract int getType();

    /* access modifiers changed from: protected */
    public abstract String hB(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String hC(int i2, int i3);

    static /* synthetic */ void a(a aVar, final long j2) {
        while (!aVar.HB(j2)) {
            aVar.AGU.add(Long.valueOf(j2));
            Log.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, msg:%d not exist", Long.valueOf(j2));
            aVar.eyw();
            j2 = aVar.AGQ.eyO();
            if (j2 == -1) {
                Log.e("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg error, finalMsgId is -1, may be resend finish");
                if (aVar.AGT.size() + aVar.AGU.size() >= aVar.AGQ.AHb.size()) {
                    Log.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, resend finish");
                    aVar.eyx();
                    return;
                }
                return;
            }
        }
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, finalMsgId:%d", Long.valueOf(j2));
        aVar.HA(j2);
        MTimerHandler mTimerHandler = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.notification.c.a.AnonymousClass8 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(26735);
                if (!a.this.AGT.contains(Long.valueOf(j2)) && !a.this.AGU.contains(Long.valueOf(j2)) && a.this.AGQ.contains(j2)) {
                    Log.i("MicroMsg.AbstractSendMsgFailNotification", "msg:%d send timeout, move this message to fail list, continue send next message", Long.valueOf(j2));
                    a.this.AGU.add(Long.valueOf(j2));
                    a.this.AGV.add(Long.valueOf(j2));
                    if (a.this.AGT.size() + a.this.AGU.size() >= a.this.AGQ.AHb.size()) {
                        a.this.eyx();
                    } else {
                        a.this.Hz(a.this.AGQ.eyO());
                    }
                }
                AppMethodBeat.o(26735);
                return true;
            }
        }, false);
        mTimerHandler.startTimer(1800000);
        aVar.AGW.add(mTimerHandler);
    }

    public a() {
        this.AGQ = null;
        this.AGR = null;
        this.AGS = false;
        this.mContext = null;
        this.AGT = null;
        this.AGU = null;
        this.AGV = null;
        this.AGW = new ArrayList<>();
        this.AGX = null;
        this.AGY = new IListener<yl>() {
            /* class com.tencent.mm.plugin.notification.c.a.AnonymousClass1 */

            {
                AppMethodBeat.i(161396);
                this.__eventId = yl.class.getName().hashCode();
                AppMethodBeat.o(161396);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(yl ylVar) {
                AppMethodBeat.i(26725);
                yl ylVar2 = ylVar;
                a.a(a.this, ylVar2.eeI.eeJ, ylVar2.eeI.eeK);
                AppMethodBeat.o(26725);
                return false;
            }
        };
        this.AGQ = new b();
        this.AGR = new FailSendMsgNotification(getType());
        this.AGS = false;
        this.mContext = MMApplicationContext.getContext();
        this.AGT = new ArrayList<>();
        this.AGU = new ArrayList<>();
        this.AGV = new ArrayList<>();
        this.AGR.AHJ = new com.tencent.mm.plugin.notification.ui.a() {
            /* class com.tencent.mm.plugin.notification.c.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.notification.ui.a
            public final void eyL() {
                AppMethodBeat.i(26728);
                Log.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.notification.c.a.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(26726);
                        h.INSTANCE.a(11425, Integer.valueOf(a.this.getType()), 3, 0, 0);
                        a.this.eyI();
                        a.a(a.this);
                        a.this.eyz();
                        AppMethodBeat.o(26726);
                    }
                });
                AppMethodBeat.o(26728);
            }

            @Override // com.tencent.mm.plugin.notification.ui.a
            public final void eyM() {
                AppMethodBeat.i(26729);
                Log.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.notification.c.a.AnonymousClass2.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(26727);
                        h.INSTANCE.a(11425, Integer.valueOf(a.this.getType()), 2, 0, 0);
                        a.this.eyI();
                        a.this.eyE();
                        a.this.resetStatus();
                        a.this.AGR.dismiss();
                        AppMethodBeat.o(26727);
                    }
                });
                AppMethodBeat.o(26729);
            }
        };
        this.AGR.AHK = new b() {
            /* class com.tencent.mm.plugin.notification.c.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.notification.ui.b
            public final void eyN() {
                AppMethodBeat.i(26730);
                h.INSTANCE.a(11425, Integer.valueOf(a.this.getType()), 1, 0, 0);
                a.this.eyI();
                a.this.eyK();
                if (!a.this.AGS) {
                    a.this.AGR.dismiss();
                }
                AppMethodBeat.o(26730);
            }
        };
        this.AGR.AHL = new c() {
            /* class com.tencent.mm.plugin.notification.c.a.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.notification.ui.c
            public final void onDismiss() {
                AppMethodBeat.i(26731);
                a.this.resetStatus();
                AppMethodBeat.o(26731);
            }
        };
        eyt();
    }

    private void eyt() {
        this.AGX = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.notification.c.a.AnonymousClass5 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(26732);
                if (a.this.AGS) {
                    Log.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", Integer.valueOf(a.this.AGQ.AHb.size()), Integer.valueOf(a.this.AGT.size()), Integer.valueOf(a.this.AGU.size()));
                    a.this.eyB();
                    Log.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", Integer.valueOf(a.this.AGQ.AHb.size()), Integer.valueOf(a.this.AGT.size()), Integer.valueOf(a.this.AGU.size()));
                    if (a.this.AGQ.AHb.size() > 0) {
                        a.this.eyw();
                    } else {
                        a.this.eyx();
                    }
                    AppMethodBeat.o(26732);
                    return true;
                }
                AppMethodBeat.o(26732);
                return false;
            }
        }, true);
    }

    private void eyu() {
        if (this.AGX != null) {
            this.AGX.stopTimer();
        } else {
            Log.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
        }
    }

    public final void dI(T t) {
        if (t != null) {
            Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", Long.valueOf(dK(t)), eyF(), Boolean.valueOf(this.AGS));
            if (this.AGS) {
                if (this.AGQ.contains(dK(t)) && !this.AGU.contains(Long.valueOf(dK(t)))) {
                    this.AGU.add(Long.valueOf(dK(t)));
                }
                if (!this.AGQ.contains(dK(t))) {
                    Log.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
                    this.AGQ.HC(dK(t));
                }
                eyw();
                Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", Integer.valueOf(this.AGT.size()), Integer.valueOf(this.AGU.size()));
                if (this.AGT.size() + this.AGU.size() < this.AGQ.AHb.size()) {
                    long eyO = this.AGQ.eyO();
                    if (eyO == -1) {
                        Log.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    Log.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", Long.valueOf(eyO));
                    eyJ();
                    Hz(eyO);
                    return;
                }
                eyx();
            } else if (this.AGV.contains(Long.valueOf(dK(t)))) {
                this.AGV.remove(Long.valueOf(dK(t)));
            } else if (t == null) {
                Log.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
            } else {
                ArrayList<Long> dL = dL(t);
                if (dL == null || dL.size() <= 0) {
                    Log.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
                    return;
                }
                resetStatus();
                b bVar = this.AGQ;
                if (dL != null && dL.size() > 0) {
                    bVar.AHb.addAll(dL);
                }
                eyJ();
                Log.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", Integer.valueOf(this.AGQ.AHb.size()), eyF());
                h.INSTANCE.a(11426, Integer.valueOf(getType()));
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.notification.c.a.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(26733);
                        a.this.eyv();
                        AppMethodBeat.o(26733);
                    }
                }, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void eyv() {
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", Boolean.valueOf(f.Pv()));
        this.AGR.AHN = TR(this.AGQ.AHb.size());
        this.AGR.eza();
        if (!f.Pv() && !this.AGR.AHS) {
            this.AGR.AHM = TR(this.AGQ.AHb.size());
            this.AGR.eyZ();
            this.AGR.eyY();
            Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
            this.AGR.show();
            EventCenter.instance.removeListener(this.AGY);
            EventCenter.instance.addListener(this.AGY);
        } else if (this.AGR.AHS) {
            this.AGR.eyZ();
            this.AGR.eyY();
            Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
            this.AGR.aJb(TR(this.AGQ.AHb.size()));
            EventCenter.instance.removeListener(this.AGY);
            EventCenter.instance.addListener(this.AGY);
        } else {
            Log.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", Boolean.valueOf(f.Pv()));
        }
    }

    public final void dJ(T t) {
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", Long.valueOf(dK(t)), eyF());
        if (this.AGQ.contains(dK(t))) {
            long dK = dK(t);
            if (this.AGV.contains(Long.valueOf(dK)) && this.AGU.contains(Long.valueOf(dK))) {
                Log.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
                this.AGV.remove(Long.valueOf(dK));
                this.AGU.remove(Long.valueOf(dK));
            }
            if (this.AGS) {
                this.AGT.add(Long.valueOf(dK));
                eyw();
                Log.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", Integer.valueOf(this.AGT.size()), Integer.valueOf(this.AGU.size()));
                if (this.AGT.size() + this.AGU.size() < this.AGQ.AHb.size()) {
                    long eyO = this.AGQ.eyO();
                    if (eyO == -1) {
                        Log.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    Log.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", Long.valueOf(eyO));
                    eyJ();
                    Hz(eyO);
                    return;
                }
                eyx();
                return;
            }
            this.AGQ.remove(dK(t));
            if (this.AGQ.AHb.size() == 0) {
                this.AGR.dismiss();
                resetStatus();
                com.tencent.mm.plugin.notification.d.b.TT(getType());
                return;
            }
            Log.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
            this.AGR.aJb(TR(this.AGQ.AHb.size()));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void eyw() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.AGR.AHN = TR(this.AGQ.AHb.size());
            if (this.AGU.size() <= 0) {
                this.AGR.aJb(hB(this.AGQ.AHb.size(), this.AGT.size() + this.AGU.size()));
            } else {
                this.AGR.aJb(av(this.AGQ.AHb.size(), this.AGT.size() + this.AGU.size(), this.AGU.size()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void eyx() {
        this.AGS = false;
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", Integer.valueOf(this.AGQ.AHb.size()), Integer.valueOf(this.AGU.size()), Integer.valueOf(this.AGT.size()));
        eyA();
        if (this.AGU.size() <= 0 || Build.VERSION.SDK_INT < 16) {
            com.tencent.mm.plugin.notification.d.b.TT(getType());
        }
        h.INSTANCE.a(11425, Integer.valueOf(getType()), 0, Integer.valueOf(this.AGT.size()), Integer.valueOf(this.AGU.size()));
        if (Build.VERSION.SDK_INT >= 16) {
            this.AGR.eyZ();
            this.AGR.AHN = TR(this.AGQ.AHb.size());
            FailSendMsgNotification failSendMsgNotification = this.AGR;
            this.AGQ.AHb.size();
            failSendMsgNotification.aJb(hC(this.AGT.size(), this.AGU.size()));
            this.AGR.eyY();
            if (this.AGU.size() > 0) {
                this.AGR.eza();
                this.AGR.show();
                eyH();
                eyJ();
            }
        }
        nn nnVar = new nn();
        nnVar.dTH.type = getType();
        EventCenter.instance.publish(nnVar);
        eyu();
        eyD();
        EventCenter.instance.removeListener(this.AGY);
        eyy();
    }

    /* access modifiers changed from: protected */
    public void eyy() {
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final void eyz() {
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", Integer.valueOf(this.AGQ.AHb.size()));
        this.AGS = true;
        if (Build.VERSION.SDK_INT >= 16) {
            FailSendMsgNotification failSendMsgNotification = this.AGR;
            failSendMsgNotification.AHU = false;
            failSendMsgNotification.AHH = com.tencent.mm.bq.a.cd(failSendMsgNotification.mContext, com.tencent.mm.bq.a.glE());
            failSendMsgNotification.eyX();
            failSendMsgNotification.show();
            Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
            FailSendMsgNotification failSendMsgNotification2 = this.AGR;
            failSendMsgNotification2.AHH.g(2, true);
            failSendMsgNotification2.AHT = true;
            failSendMsgNotification2.show();
            Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
            this.AGR.aJb(hB(this.AGQ.AHb.size(), 0));
        }
        this.AGQ.currentIndex = 0;
        eyD();
        EventCenter.instance.removeListener(this.AGY);
        EventCenter.instance.addListener(this.AGY);
        Hz(this.AGQ.eyO());
        if (this.AGX != null) {
            this.AGX.startTimer(300000);
        } else {
            Log.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
        }
    }

    private void eyA() {
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", Integer.valueOf(this.AGQ.AHb.size()), Integer.valueOf(this.AGT.size()), Integer.valueOf(this.AGU.size()));
        eyB();
        eyC();
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", Integer.valueOf(this.AGQ.AHb.size()), Integer.valueOf(this.AGT.size()), Integer.valueOf(this.AGU.size()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void eyB() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.AGQ.AHb.size(); i2++) {
            long j2 = this.AGQ.get(i2);
            if (!HB(j2)) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.AGQ.remove(((Long) it.next()).longValue());
            }
        }
    }

    private void eyC() {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = this.AGT.iterator();
        while (it.hasNext()) {
            Long next = it.next();
            if (!HB(next.longValue())) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.AGT.remove((Long) it2.next());
        }
        arrayList.clear();
        Iterator<Long> it3 = this.AGU.iterator();
        while (it3.hasNext()) {
            Long next2 = it3.next();
            if (!HB(next2.longValue())) {
                arrayList.add(next2);
            }
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            this.AGU.remove((Long) it4.next());
        }
    }

    /* access modifiers changed from: package-private */
    public final void Hz(final long j2) {
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.notification.c.a.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(26734);
                a.a(a.this, j2);
                AppMethodBeat.o(26734);
            }
        }, 200);
    }

    private void eyD() {
        Iterator<MTimerHandler> it = this.AGW.iterator();
        while (it.hasNext()) {
            it.next().stopTimer();
        }
        this.AGW.clear();
        this.AGV.clear();
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final void eyE() {
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", Integer.valueOf(this.AGQ.AHb.size()));
        if (this.AGQ.AHb.size() > 0) {
            b bVar = this.AGQ;
            ArrayList<Long> arrayList = new ArrayList<>();
            Iterator<Long> it = bVar.AHb.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next().longValue()));
            }
            aH(arrayList);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resetStatus() {
        this.AGQ.clear();
        this.AGS = false;
        this.AGT.clear();
        this.AGU.clear();
        eyD();
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.mContext;
    }

    private String eyF() {
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < this.AGQ.AHb.size(); i2++) {
            sb.append(this.AGQ.get(i2) + ", ");
        }
        return sb.toString();
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final FailSendMsgNotification eyG() {
        return this.AGR;
    }

    private void eyH() {
        this.AGQ.currentIndex = 0;
        if (this.AGT.size() > 0) {
            Iterator<Long> it = this.AGT.iterator();
            while (it.hasNext()) {
                this.AGQ.remove(it.next().longValue());
            }
        }
        this.AGT.clear();
        this.AGU.clear();
    }

    /* access modifiers changed from: protected */
    public final void eyI() {
        if (this.AGQ == null || this.AGQ.AHb.size() == 0) {
            Log.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
            b.a TS = com.tencent.mm.plugin.notification.d.b.TS(getType());
            if (TS == null) {
                Log.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
                return;
            }
            if (this.AGX == null) {
                eyt();
            }
            b bVar = TS.AHe;
            ArrayList<Long> arrayList = TS.AHg;
            ArrayList<Long> arrayList2 = TS.AHh;
            int i2 = TS.AHf;
            if (arrayList.size() == 0 && arrayList2.size() == 0 && i2 == 0) {
                Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
                this.AGQ.clear();
                this.AGQ = bVar;
                this.AGT.clear();
                this.AGU.clear();
                eyv();
            } else if (arrayList.size() + arrayList2.size() >= bVar.AHb.size()) {
                Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
                eyx();
            } else {
                Log.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
                this.AGQ.clear();
                this.AGQ = bVar;
                this.AGQ.currentIndex = i2;
                this.AGT.clear();
                this.AGT.addAll(arrayList);
                this.AGU.clear();
                this.AGU.addAll(arrayList2);
                eyw();
            }
        }
    }

    private void eyJ() {
        com.tencent.mm.plugin.notification.d.b.a(getType(), new b.a(this.AGQ, this.AGQ.currentIndex, this.AGT, this.AGU));
    }

    static /* synthetic */ void a(a aVar, long j2, long j3) {
        Log.i("MicroMsg.AbstractSendMsgFailNotification", "updateMsgIdInMsgList, oldMsgId:%d, newMsgId:%d", Long.valueOf(j2), Long.valueOf(j3));
        if (aVar.AGQ.contains(j2)) {
            b bVar = aVar.AGQ;
            int indexOf = bVar.AHb.indexOf(Long.valueOf(j2));
            if (indexOf != -1) {
                bVar.AHb.set(indexOf, Long.valueOf(j3));
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, mMsgList.size:%d", Integer.valueOf(aVar.AGQ.AHb.size()));
        aVar.eyB();
        if (Build.VERSION.SDK_INT >= 16) {
            aVar.AGR.aJb(aVar.TR(aVar.AGQ.AHb.size()));
        }
        Log.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, after check, mMsgList.size:%d", Integer.valueOf(aVar.AGQ.AHb.size()));
    }
}
