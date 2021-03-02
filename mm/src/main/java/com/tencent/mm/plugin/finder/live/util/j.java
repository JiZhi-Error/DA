package com.tencent.mm.plugin.finder.live.util;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0012\u0018\u00002\u00020\u0001:\u0003*+,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J+\u0010\u0019\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager;", "", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "clickCnt", "", "comboBatchSize", "comboBatchTimeoutMs", "comboId", "continuousClickTimeThreshHold", "", "lastClickCnt", "lastTouchUpTime", "longClickInstantCallbackInterval", "longClickRunnable", "com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1;", "longClickTimeThreshHold", "longClickTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onTouchUpOrCancelState", "", "registerView", "Landroid/view/View;", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "timer", "touchListener", "Landroid/view/View$OnTouchListener;", "cancelLongClickState", "", "checkComboBatchSize", "checkIfContinuousClick", "view", "initialValue", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;Ljava/lang/Integer;)V", "unRegisterView", "updateState", "newState", "IContinuousClickCallback", "Mode", "State", "plugin-finder_release"})
public final class j {
    final String TAG = "Finder.ContinuousClickManager";
    public MTimerHandler timer;
    private final int ujE;
    public final int ujF;
    public volatile String upR;
    public a uwA;
    public volatile View uwB;
    @SuppressLint({"ClickableViewAccessibility"})
    public final View.OnTouchListener uwC;
    final c uwD;
    MTimerHandler uwE;
    private final long uws = 3000;
    final long uwt;
    final long uwu;
    public volatile b uwv;
    public volatile int uww;
    public volatile int uwx;
    public volatile long uwy;
    volatile boolean uwz;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "", "(Ljava/lang/String;I)V", "NORMAL", "SINGLE_CLICK", "CONTINUOUS_CLICKING", "LONG_CLICK", "plugin-finder_release"})
    public enum b {
        NORMAL,
        SINGLE_CLICK,
        CONTINUOUS_CLICKING,
        LONG_CLICK;

        static {
            AppMethodBeat.i(247248);
            AppMethodBeat.o(247248);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(247250);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(247250);
            return bVar;
        }
    }

    public j() {
        int i2;
        int i3;
        AppMethodBeat.i(247261);
        o oVar = o.ujN;
        if (o.dgd() > 0) {
            o oVar2 = o.ujN;
            i2 = o.dgd();
        } else {
            i2 = 5;
        }
        this.ujE = i2;
        o oVar3 = o.ujN;
        if (o.dge() > 0) {
            o oVar4 = o.ujN;
            i3 = o.dge();
        } else {
            i3 = 1000;
        }
        this.ujF = i3;
        this.uwt = 500;
        this.uwu = 200;
        this.uwv = b.NORMAL;
        this.upR = "";
        this.uwz = true;
        this.uwC = new f(this);
        this.uwD = new c(this);
        this.timer = new MTimerHandler("ContinuousClickManager::Timer", (MTimerHandler.CallBack) new e(this), true);
        this.uwE = new MTimerHandler("ContinuousClickManager::longClickTimer", (MTimerHandler.CallBack) new d(this), true);
        AppMethodBeat.o(247261);
    }

    public final void dZ(View view) {
        a aVar;
        AppMethodBeat.i(247257);
        if (this.uwB == null) {
            AppMethodBeat.o(247257);
            return;
        }
        Log.i(this.TAG, "unRegisterView view: ".concat(String.valueOf(view)));
        if (view != null) {
            view.setOnTouchListener(null);
        }
        this.uwB = null;
        this.timer.stopTimer();
        dig();
        int i2 = this.uww - this.uwx;
        if (i2 > 0 && (aVar = this.uwA) != null) {
            View view2 = this.uwB;
            aVar.a(this.uww, i2, this.uwv, this.upR, true);
        }
        this.uwA = null;
        a(b.NORMAL);
        this.uwz = true;
        AppMethodBeat.o(247257);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class f implements View.OnTouchListener {
        final /* synthetic */ j uwK;

        f(j jVar) {
            this.uwK = jVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            byte[] bArr;
            byte[] bArr2 = null;
            AppMethodBeat.i(247256);
            Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                this.uwK.uwz = false;
                switch (k.$EnumSwitchMapping$0[this.uwK.uwv.ordinal()]) {
                    case 1:
                        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
                            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                            if (1 == com.tencent.mm.plugin.finder.storage.c.dvW().value().intValue()) {
                                j jVar = this.uwK;
                                StringBuilder sb = new StringBuilder();
                                String aTY = z.aTY();
                                if (aTY != null) {
                                    Charset charset = kotlin.n.d.UTF_8;
                                    if (aTY == null) {
                                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                                        AppMethodBeat.o(247256);
                                        throw tVar;
                                    }
                                    bArr = aTY.getBytes(charset);
                                    p.g(bArr, "(this as java.lang.String).getBytes(charset)");
                                } else {
                                    bArr = null;
                                }
                                jVar.upR = sb.append(g.getMessageDigest(bArr)).append("_123456").toString();
                                this.uwK.a(b.SINGLE_CLICK);
                                break;
                            }
                        }
                        j jVar2 = this.uwK;
                        StringBuilder sb2 = new StringBuilder();
                        String aTY2 = z.aTY();
                        if (aTY2 != null) {
                            Charset charset2 = kotlin.n.d.UTF_8;
                            if (aTY2 == null) {
                                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                                AppMethodBeat.o(247256);
                                throw tVar2;
                            }
                            bArr2 = aTY2.getBytes(charset2);
                            p.g(bArr2, "(this as java.lang.String).getBytes(charset)");
                        }
                        jVar2.upR = sb2.append(g.getMessageDigest(bArr2)).append('_').append(UUID.randomUUID()).toString();
                        this.uwK.a(b.SINGLE_CLICK);
                    case 2:
                    case 3:
                    case 4:
                        if (!j.a(this.uwK)) {
                            this.uwK.a(b.SINGLE_CLICK);
                            break;
                        } else {
                            this.uwK.a(b.CONTINUOUS_CLICKING);
                            break;
                        }
                }
                com.tencent.mm.ac.d.a(this.uwK.uwt, this.uwK.uwD);
            } else if (valueOf != null && valueOf.intValue() == 2) {
                this.uwK.uwz = false;
            } else if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 3)) {
                Log.i(this.uwK.TAG, "on ACTION_UP or ACTION_CANCEL: ".concat(String.valueOf(motionEvent)));
                this.uwK.uwz = true;
                this.uwK.uwy = System.currentTimeMillis();
                if (this.uwK.timer.stopped()) {
                    Log.i(this.uwK.TAG, "single click start timer");
                    this.uwK.timer.startTimer((long) this.uwK.ujF);
                }
                this.uwK.dig();
                a aVar = this.uwK.uwA;
                if (aVar != null) {
                    aVar.V(motionEvent);
                }
            }
            AppMethodBeat.o(247256);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void dig() {
        AppMethodBeat.i(247258);
        com.tencent.mm.ac.d.C(this.uwD);
        this.uwE.stopTimer();
        Log.i(this.TAG, "cancelLongClickState: longClickTimer.stopped = " + this.uwE.stopped());
        AppMethodBeat.o(247258);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
    public static final class c implements Runnable {
        final /* synthetic */ j uwK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(j jVar) {
            this.uwK = jVar;
        }

        public final void run() {
            AppMethodBeat.i(247252);
            this.uwK.a(b.LONG_CLICK);
            if (this.uwK.timer.stopped()) {
                Log.i(this.uwK.TAG, "long click start timer");
                this.uwK.timer.startTimer((long) this.uwK.ujF);
            }
            if (this.uwK.uwE.stopped()) {
                Log.i(this.uwK.TAG, "long click start longClickTimer");
                this.uwK.uwE.startTimer(this.uwK.uwu);
            }
            AppMethodBeat.o(247252);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$timer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder_release"})
    public static final class e implements MTimerHandler.CallBack {
        final /* synthetic */ j uwK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(j jVar) {
            this.uwK = jVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(247255);
            Log.i(this.uwK.TAG, "ContinuousClickManager Timer callback: clickCnt = " + this.uwK.uww + ", state = " + this.uwK.uwv.name() + ", lastClickCnt = " + this.uwK.uwx);
            if (this.uwK.uwx != this.uwK.uww) {
                int i2 = this.uwK.uww - this.uwK.uwx;
                this.uwK.uwx = this.uwK.uww;
                if (i2 < 0) {
                    this.uwK.a(b.NORMAL);
                    a aVar = this.uwK.uwA;
                    if (aVar != null) {
                        View view = this.uwK.uwB;
                        a.C1192a.a(aVar, this.uwK.uww, 0, b.NORMAL, this.uwK.upR);
                    }
                    AppMethodBeat.o(247255);
                    return false;
                }
                a aVar2 = this.uwK.uwA;
                if (aVar2 != null) {
                    View view2 = this.uwK.uwB;
                    a.C1192a.a(aVar2, this.uwK.uww, i2, this.uwK.uwv, this.uwK.upR);
                }
            }
            if (j.a(this.uwK)) {
                AppMethodBeat.o(247255);
                return true;
            }
            this.uwK.a(b.NORMAL);
            a aVar3 = this.uwK.uwA;
            if (aVar3 != null) {
                View view3 = this.uwK.uwB;
                a.C1192a.a(aVar3, this.uwK.uww, 0, b.NORMAL, this.uwK.upR);
            }
            AppMethodBeat.o(247255);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder_release"})
    public static final class d implements MTimerHandler.CallBack {
        final /* synthetic */ j uwK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(j jVar) {
            this.uwK = jVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(247254);
            if (this.uwK.uwz) {
                AppMethodBeat.o(247254);
                return false;
            }
            Log.i(this.uwK.TAG, "ContinuousClickManager longClickTimer callback: clickCnt = " + this.uwK.uww + ", state = " + this.uwK.uwv.name() + ", lastClickCnt = " + this.uwK.uwx);
            com.tencent.mm.ac.d.h(new a(this));
            AppMethodBeat.o(247254);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d uwL;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.uwL = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(247253);
                this.uwL.uwK.a(b.LONG_CLICK);
                x xVar = x.SXb;
                AppMethodBeat.o(247253);
                return xVar;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        AppMethodBeat.i(247259);
        Log.i(this.TAG, "updateState: newState = ".concat(String.valueOf(bVar)));
        this.uwv = bVar;
        switch (k.haE[bVar.ordinal()]) {
            case 1:
                this.uww = 0;
                this.uwx = 0;
                this.upR = "";
                AppMethodBeat.o(247259);
                return;
            case 2:
            case 3:
                this.uww++;
                a aVar = this.uwA;
                if (aVar != null) {
                    View view = this.uwB;
                    aVar.a(this.uww, bVar, this.upR, this.uww - this.uwx);
                }
                dih();
                AppMethodBeat.o(247259);
                return;
            case 4:
                this.uww++;
                a aVar2 = this.uwA;
                if (aVar2 != null) {
                    View view2 = this.uwB;
                    aVar2.a(this.uww, bVar, this.upR, this.uww - this.uwx);
                }
                dih();
                break;
        }
        AppMethodBeat.o(247259);
    }

    private final void dih() {
        AppMethodBeat.i(247260);
        int i2 = this.uww - this.uwx;
        if (i2 >= this.ujE) {
            Log.i(this.TAG, "checkComboBatchSize: clickCnt = " + this.uww + ", lastClickCnt = " + this.uwx);
            this.uwx = this.uww;
            a aVar = this.uwA;
            if (aVar != null) {
                View view = this.uwB;
                a.C1192a.a(aVar, this.uww, i2, this.uwv, this.upR);
            }
            if (!this.timer.stopped()) {
                this.timer.stopTimer();
                this.timer.startTimer((long) this.ujF);
            }
        }
        AppMethodBeat.o(247260);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003H&J2\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "", "batchCallback", "", "view", "Landroid/view/View;", "clickCnt", "", "diffCnt", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "comboId", "", "needCheckBalance", "instantCallback", "onActionUpOrCancel", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public interface a {
        void V(MotionEvent motionEvent);

        boolean a(int i2, int i3, b bVar, String str, boolean z);

        boolean a(int i2, b bVar, String str, int i3);

        @l(hxD = {1, 1, 16})
        /* renamed from: com.tencent.mm.plugin.finder.live.util.j$a$a  reason: collision with other inner class name */
        public static final class C1192a {
            public static /* synthetic */ boolean a(a aVar, int i2, int i3, b bVar, String str) {
                AppMethodBeat.i(247247);
                boolean a2 = aVar.a(i2, i3, bVar, str, false);
                AppMethodBeat.o(247247);
                return a2;
            }
        }
    }

    public static final /* synthetic */ boolean a(j jVar) {
        AppMethodBeat.i(247262);
        if (!jVar.uwz || System.currentTimeMillis() - jVar.uwy < jVar.uws) {
            AppMethodBeat.o(247262);
            return true;
        }
        AppMethodBeat.o(247262);
        return false;
    }
}
