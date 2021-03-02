package com.tencent.mm.plugin.appbrand.a;

import android.app.ActivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.statemachine.IState;
import com.tencent.mm.sdk.statemachine.State;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class d extends h {
    private static final AtomicInteger kQP = new AtomicInteger(0);
    public final String TAG = getName();
    private final AppBrandRuntime kEc;
    private final e kQQ;
    private final b kQR;
    private final f kQS;
    private final C0529d kQT;
    private final c kQU;
    public final AtomicBoolean kQV = new AtomicBoolean(false);
    public final AtomicBoolean kQW = new AtomicBoolean(false);
    private final AtomicBoolean kQX = new AtomicBoolean(false);
    private final AtomicReference<State> kQY = new AtomicReference<>(null);
    private final AtomicReference<State> kQZ = new AtomicReference<>(null);
    public final Queue<j<?>> kRa = new LinkedBlockingQueue();
    private final AtomicBoolean kRb = new AtomicBoolean(false);
    private volatile State kRc = null;

    public abstract void a(b bVar);

    /* access modifiers changed from: package-private */
    public abstract void bwW();

    public enum a {
        NONE(0),
        TO_BACKGROUND(1),
        TO_FOREGROUND(3),
        TO_SUSPEND_FROM_BACKGROUND(4, true),
        ON_SYSTEM_SCREEN_OFF(10),
        ON_SUSPEND_TIMEOUT(11, true),
        ON_DETACH_FROM_STACK(12),
        ON_STOP_BACKGROUND_LOCATION_LISTENING(13),
        ON_STOP_BACKGROUND_LIVE_VOIP(14),
        ON_STOP_AUDIO_BACKGROUND_PLAY(15),
        ON_STOP_BACKGROUND_VOIP_1v1(16),
        ON_CONTAINER_FORCED_MOVE_TO_BACK(18),
        AWAKE_MSG_QUEUE(1000);
        
        final int intValue;
        private final boolean kRu;

        public static a valueOf(String str) {
            AppMethodBeat.i(134725);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(134725);
            return aVar;
        }

        static {
            AppMethodBeat.i(134727);
            AppMethodBeat.o(134727);
        }

        private a(int i2, boolean z) {
            this.intValue = i2;
            this.kRu = z;
        }

        private a(int i2) {
            this(i2, false);
        }

        static a vS(int i2) {
            AppMethodBeat.i(176545);
            a[] values = values();
            for (a aVar : values) {
                if (aVar.intValue == i2) {
                    AppMethodBeat.o(176545);
                    return aVar;
                }
            }
            a aVar2 = NONE;
            AppMethodBeat.o(176545);
            return aVar2;
        }
    }

    d(AppBrandRuntime appBrandRuntime) {
        super(String.format(Locale.ENGLISH, "Luggage.AppRunningStateMachine[%s][%d]", appBrandRuntime.mAppId, Integer.valueOf(kQP.incrementAndGet())), Looper.getMainLooper());
        this.kEc = appBrandRuntime;
        super.setDbg(false);
        this.kQT = new C0529d(this);
        this.kQU = new c(this);
        this.kQR = new b(this, appBrandRuntime);
        this.kQQ = new e(this);
        this.kQS = new f(this);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.a.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(134716);
                d.this.addState(d.this.kQT);
                d.this.addState(d.this.kQU);
                d.this.addState(d.this.kQR);
                d.this.addState(d.this.kQQ);
                d.this.addState(d.this.kQS);
                d.this.setInitialState(d.this.kQQ);
                d.super.setDbg(true);
                AppMethodBeat.o(134716);
            }
        };
        if (Looper.myLooper() == getHandler().getLooper()) {
            r0.run();
            return;
        }
        this.kQX.set(true);
        getHandler().post(r0);
    }

    public final boolean bwX() {
        Handler handler = getHandler();
        if (handler == null) {
            return false;
        }
        return handler.hasMessages(-2);
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void start() {
        if (!this.kQW.get()) {
            this.kQV.set(true);
            if (Looper.myLooper() == getHandler().getLooper()) {
                super.start();
            } else {
                getHandler().post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.a.d.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(134717);
                        d.super.start();
                        AppMethodBeat.o(134717);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.a.h
    public final void a(g gVar) {
        this.kQY.set(null);
        this.kQZ.set(gVar);
        Message currentMessage = getCurrentMessage();
        if (currentMessage == null || currentMessage.what != -2) {
            State state = this.kRc;
            this.kRc = gVar;
            if (state != null && a(state) != a((IState) gVar)) {
                a(a((IState) gVar));
                return;
            }
            return;
        }
        this.kRc = gVar;
    }

    /* access modifiers changed from: package-private */
    public final void gK(boolean z) {
        this.kRb.set(z);
    }

    public final b bwY() {
        Object obj;
        boolean z;
        Handler handler = getHandler();
        if (handler == null) {
            Log.d(this.TAG, "getRunningStateExport, NULL handler, return DESTROYED");
            return b.DESTROYED;
        } else if (handler.hasMessages(-1)) {
            Log.d(this.TAG, "getRunningStateExport, has SM_QUIT_CMD, return DESTROYED");
            return b.DESTROYED;
        } else if (this.kQW.get()) {
            Log.d(this.TAG, "getRunningStateExport, mStopped=true, return DESTROYED");
            return b.DESTROYED;
        } else if (bwX()) {
            return b.kQH;
        } else {
            if (this.kQX.get() && Looper.myLooper() != handler.getLooper()) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    obj = "query from main-looper";
                    z = true;
                } else if (this.kRb.get()) {
                    obj = "skip flag marked true by outer";
                    z = true;
                } else {
                    obj = null;
                    z = false;
                }
                if (z) {
                    State state = this.kQZ.get();
                    boolean z2 = this.kQW.get();
                    Log.i(this.TAG, "getRunningStateExport, pending change in sm-looper(%d) but %s, cached-state=%s, stopped=%b", Long.valueOf(handler.getLooper().getThread().getId()), obj, state, Boolean.valueOf(z2));
                    if (state != null) {
                        return a(state);
                    }
                    return z2 ? b.DESTROYED : b.kQH;
                }
                AnonymousClass3 r1 = new j<b>() {
                    /* class com.tencent.mm.plugin.appbrand.a.d.AnonymousClass3 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* access modifiers changed from: protected */
                    @Override // com.tencent.mm.plugin.appbrand.a.j
                    public final /* synthetic */ b run() {
                        AppMethodBeat.i(134718);
                        b gL = d.this.gL(true);
                        AppMethodBeat.o(134718);
                        return gL;
                    }
                };
                Log.d(this.TAG, "getRunningStateExport, await");
                this.kRa.add(r1);
                b bVar = (b) r1.exec(new MMHandler(handler.getLooper()));
                this.kRa.remove(r1);
                if (bVar == null) {
                    Log.d(this.TAG, "getRunningStateExport, await timeout");
                    return gL(false);
                }
            }
            return gL(true);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private b gL(boolean z) {
        IState currentState;
        if (this.kQW.get()) {
            Log.d(this.TAG, "getRunningStateExportImpl, mStopped=true, return DESTROYED");
            return b.DESTROYED;
        }
        State state = this.kQY.get();
        if (state != null) {
            return a(state);
        }
        State state2 = this.kQZ.get();
        if (state2 != null) {
            return a(state2);
        }
        if (!z) {
            return a(this.kRc);
        }
        if (Thread.currentThread().getId() != getHandler().getLooper().getThread().getId()) {
            AnonymousClass4 r0 = new j<IState>() {
                /* class com.tencent.mm.plugin.appbrand.a.d.AnonymousClass4 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.appbrand.a.j
                public final /* synthetic */ IState run() {
                    AppMethodBeat.i(134719);
                    IState currentState = d.super.getCurrentState();
                    AppMethodBeat.o(134719);
                    return currentState;
                }
            };
            Log.d(this.TAG, "getRunningStateExportImpl, await");
            currentState = (IState) r0.exec(new MMHandler(getHandler().getLooper()));
        } else {
            currentState = super.getCurrentState();
        }
        return a(currentState);
    }

    private b a(IState iState) {
        if (iState == this.kQR || iState == this.kQT || iState == this.kQU) {
            return b.BACKGROUND;
        }
        if (iState == this.kQS) {
            return b.SUSPEND;
        }
        if (iState == this.kQQ) {
            return b.kQH;
        }
        return b.kQH;
    }

    public final boolean bwZ() {
        switch (bwY()) {
            case kQH:
                return true;
            case SUSPEND:
            case DESTROYED:
            default:
                return false;
            case BACKGROUND:
                return ((Boolean) new j<Boolean>(Boolean.FALSE) {
                    /* class com.tencent.mm.plugin.appbrand.a.d.AnonymousClass5 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* access modifiers changed from: protected */
                    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
                        if (r2 != false) goto L_0x0025;
                     */
                    @Override // com.tencent.mm.plugin.appbrand.a.j
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final /* synthetic */ java.lang.Boolean run() {
                        /*
                            r5 = this;
                            r4 = 134720(0x20e40, float:1.88783E-40)
                            r0 = 1
                            r1 = 0
                            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                            com.tencent.mm.plugin.appbrand.a.d r2 = com.tencent.mm.plugin.appbrand.a.d.this
                            com.tencent.mm.sdk.statemachine.IState r2 = com.tencent.mm.plugin.appbrand.a.d.j(r2)
                            com.tencent.mm.plugin.appbrand.a.d r3 = com.tencent.mm.plugin.appbrand.a.d.this
                            com.tencent.mm.plugin.appbrand.a.d$b r3 = com.tencent.mm.plugin.appbrand.a.d.c(r3)
                            if (r2 != r3) goto L_0x002f
                            com.tencent.mm.plugin.appbrand.a.d r2 = com.tencent.mm.plugin.appbrand.a.d.this
                            com.tencent.mm.plugin.appbrand.a.d$b r2 = com.tencent.mm.plugin.appbrand.a.d.c(r2)
                            int r2 = r2.kRB
                            r2 = r2 & 1
                            if (r2 <= 0) goto L_0x002d
                            r2 = r0
                        L_0x0023:
                            if (r2 == 0) goto L_0x002f
                        L_0x0025:
                            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                            return r0
                        L_0x002d:
                            r2 = r1
                            goto L_0x0023
                        L_0x002f:
                            r0 = r1
                            goto L_0x0025
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.a.d.AnonymousClass5.run():java.lang.Object");
                    }
                }.exec(new MMHandler(getHandler().getLooper()))).booleanValue();
        }
    }

    public final void a(a aVar) {
        a(aVar, (Object) null);
    }

    public final void a(a aVar, Object obj) {
        if (getHandler() == null) {
            Log.w(this.TAG, "executeOrPostMessage with cmd[%s], null handler", aVar.name());
            return;
        }
        this.kQX.set(true);
        if (Looper.myLooper() != getHandler().getLooper() || getCurrentMessage() == null || getCurrentMessage().what == -2 || bxa() || this.kRH) {
            super.sendMessage(obtainMessage(aVar.intValue, obj));
        } else {
            getHandler().dispatchMessage(obtainMessage(aVar.intValue, obj));
        }
    }

    private boolean bxa() {
        a[] values = a.values();
        for (a aVar : values) {
            if (!aVar.kRu && getHandler().hasMessages(aVar.intValue)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public boolean recordLogRec(Message message) {
        return message.what != a.AWAKE_MSG_QUEUE.intValue;
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void unhandledMessage(Message message) {
        Log.e(getName(), " - unhandledMessage: msg.what=%d, msg.obj=%s", Integer.valueOf(message.what), message.obj);
        this.kQX.set(false);
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void onQuitting() {
        super.onQuitting();
        if (getHandler().getLooper().getThread().getId() != Looper.getMainLooper().getThread().getId()) {
            getHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.a.d.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(134722);
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                        /* class com.tencent.mm.plugin.appbrand.a.d.AnonymousClass6.AnonymousClass1 */

                        public final boolean queueIdle() {
                            AppMethodBeat.i(134721);
                            Looper.myLooper().quit();
                            AppMethodBeat.o(134721);
                            return false;
                        }
                    });
                    AppMethodBeat.o(134722);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final class e extends g {
        e(h hVar) {
            super(hVar);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final String getName() {
            return "|Foreground";
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final boolean processMessage(Message message) {
            AppMethodBeat.i(134736);
            switch (a.vS(message.what)) {
                case TO_BACKGROUND:
                    d.a(d.this, (g) d.this.kQR);
                    AppMethodBeat.o(134736);
                    return true;
                default:
                    boolean processMessage = super.processMessage(message);
                    AppMethodBeat.o(134736);
                    return processMessage;
            }
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.plugin.appbrand.a.g, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(134737);
            super.enter();
            u k = d.k(d.this);
            if (k != null) {
                k.resume();
                for (m mVar : d.this.kEc.NY().btd().kEz.dqZ.values()) {
                    mVar.dpQ.resume();
                }
            }
            AppMethodBeat.o(134737);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void exit() {
            AppMethodBeat.i(134738);
            super.exit();
            AppMethodBeat.o(134738);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.a.d$d  reason: collision with other inner class name */
    public final class C0529d extends g {
        C0529d(h hVar) {
            super(hVar);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final String getName() {
            return "|BackgroundTemporary";
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final boolean processMessage(Message message) {
            AppMethodBeat.i(134733);
            switch (a.vS(message.what)) {
                case TO_SUSPEND_FROM_BACKGROUND:
                    if (d.this.kEc.isInBackStack()) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        Log.i(d.this.TAG, "BackgroundTemporary process TO_SUSPEND_FROM_BACKGROUND, current process importance %d", Integer.valueOf(runningAppProcessInfo.importance));
                        if (runningAppProcessInfo.importance == 100) {
                            d.a(d.this, (g) d.this.kQU);
                            AppMethodBeat.o(134733);
                            return true;
                        }
                    }
                    d.a(d.this, (g) d.this.kQS);
                    AppMethodBeat.o(134733);
                    return true;
                case ON_SYSTEM_SCREEN_OFF:
                    Log.i(d.this.TAG, "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF");
                    d.a(d.this, (g) d.this.kQU);
                    AppMethodBeat.o(134733);
                    return true;
                case TO_FOREGROUND:
                    d.a(d.this, (g) d.this.kQQ);
                    AppMethodBeat.o(134733);
                    return true;
                default:
                    boolean processMessage = super.processMessage(message);
                    AppMethodBeat.o(134733);
                    return processMessage;
            }
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.plugin.appbrand.a.g, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(134734);
            super.enter();
            if (d.this.kEc.OT().leC != Integer.MAX_VALUE) {
                d.this.getHandler().sendEmptyMessageDelayed(a.TO_SUSPEND_FROM_BACKGROUND.intValue, ((long) d.this.kEc.OT().leC) * 1000);
            }
            AppMethodBeat.o(134734);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void exit() {
            AppMethodBeat.i(134735);
            super.exit();
            d.this.getHandler().removeMessages(a.TO_SUSPEND_FROM_BACKGROUND.intValue);
            AppMethodBeat.o(134735);
        }
    }

    /* access modifiers changed from: package-private */
    public final class c extends g {
        c(h hVar) {
            super(hVar);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final String getName() {
            return "|BackgroundKeepNoChange";
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final boolean processMessage(Message message) {
            AppMethodBeat.i(134732);
            switch (a.vS(message.what)) {
                case TO_FOREGROUND:
                    d.a(d.this, (g) d.this.kQQ);
                    AppMethodBeat.o(134732);
                    return true;
                default:
                    boolean processMessage = super.processMessage(message);
                    AppMethodBeat.o(134732);
                    return processMessage;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final class b extends f {
        b(h hVar, AppBrandRuntime appBrandRuntime) {
            super(hVar, appBrandRuntime);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final String getName() {
            return "|Background";
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.plugin.appbrand.a.f, com.tencent.mm.sdk.statemachine.IState
        public final boolean processMessage(Message message) {
            AppMethodBeat.i(134728);
            switch (a.vS(message.what)) {
                case TO_FOREGROUND:
                    d.a(d.this, (g) d.this.kQQ);
                    AppMethodBeat.o(134728);
                    return true;
                case ON_DETACH_FROM_STACK:
                    super.vT(16);
                    AppMethodBeat.o(134728);
                    return true;
                default:
                    boolean processMessage = super.processMessage(message);
                    AppMethodBeat.o(134728);
                    return processMessage;
            }
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.plugin.appbrand.a.f, com.tencent.mm.plugin.appbrand.a.g, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(134729);
            super.enter();
            AppMethodBeat.o(134729);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.plugin.appbrand.a.f, com.tencent.mm.sdk.statemachine.IState
        public final void exit() {
            AppMethodBeat.i(134730);
            super.exit();
            AppMethodBeat.o(134730);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.a.f
        public final void bxb() {
            AppMethodBeat.i(134731);
            if (d.this.getCurrentState() == this) {
                d.a(d.this, (g) d.this.kQT);
                d.this.a(a.AWAKE_MSG_QUEUE);
            }
            AppMethodBeat.o(134731);
        }
    }

    /* access modifiers changed from: package-private */
    public final class f extends g {
        f(h hVar) {
            super(hVar);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final String getName() {
            return "|Suspend";
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.plugin.appbrand.a.g, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(134739);
            super.enter();
            d.this.getHandler().sendEmptyMessageDelayed(a.ON_SUSPEND_TIMEOUT.intValue, ((long) d.this.kEc.OT().leD) * 1000);
            u k = d.k(d.this);
            if (k != null) {
                k.pause();
                for (m mVar : d.this.kEc.NY().btd().kEz.dqZ.values()) {
                    mVar.dpQ.pause();
                }
            }
            AppMethodBeat.o(134739);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void exit() {
            AppMethodBeat.i(134740);
            super.exit();
            d.this.getHandler().removeMessages(a.ON_SUSPEND_TIMEOUT.intValue);
            AppMethodBeat.o(134740);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final boolean processMessage(Message message) {
            AppMethodBeat.i(134741);
            switch (a.vS(message.what)) {
                case TO_FOREGROUND:
                    d.a(d.this, (g) d.this.kQQ);
                    AppMethodBeat.o(134741);
                    return true;
                case ON_DETACH_FROM_STACK:
                default:
                    boolean processMessage = super.processMessage(message);
                    AppMethodBeat.o(134741);
                    return processMessage;
                case ON_SUSPEND_TIMEOUT:
                    Log.i(d.this.TAG, "suspend timeout");
                    d.this.bwW();
                    AppMethodBeat.o(134741);
                    return true;
            }
        }
    }

    static /* synthetic */ void a(d dVar, g gVar) {
        dVar.kQX.set(false);
        dVar.kQY.set(gVar);
        dVar.kQZ.set(null);
        super.transitionTo(gVar);
    }

    static /* synthetic */ u k(d dVar) {
        if (dVar.kEc.NY() == null || !dVar.kEc.mInitialized) {
            return null;
        }
        return (u) dVar.kEc.NY().getJsRuntime().R(u.class);
    }
}
