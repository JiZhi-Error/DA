package com.tencent.mm.ui.m;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020!J\u0006\u0010'\u001a\u00020\u0017J\u000e\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u0014J\u000e\u0010,\u001a\u00020\u00172\u0006\u0010&\u001a\u00020!J\u000e\u0010-\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "removeScrollConsumer", "trackTouchEvent", "Companion", "libmmui_release"})
public final class b {
    public static final a QnH = new a((byte) 0);
    private static String TAG = "MicroMsg.GalleryScrollHelper";
    private boolean CIx;
    private final int QnA;
    private boolean QnB;
    private boolean QnC;
    public int QnD;
    kotlin.g.a.a<Boolean> QnE;
    public boolean QnF = true;
    private final HashSet<a> QnG = new HashSet<>();
    private float deo;
    private float dep;
    public final Runnable had = new RunnableC2119b(this);
    private final int rZ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper$Companion;", "", "()V", "ScrollAll", "", "ScrollDown", "ScrollLeft", "ScrollNone", "ScrollRight", "ScrollUp", "TAG", "", "scrollHorizontal", "", "type", "scrollVertical", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(Context context) {
        p.h(context, "context");
        AppMethodBeat.i(140943);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.QnA = ViewConfiguration.getLongPressTimeout() + 100;
        p.g(viewConfiguration, "config");
        this.rZ = viewConfiguration.getScaledTouchSlop();
        AppMethodBeat.o(140943);
    }

    static {
        AppMethodBeat.i(140944);
        AppMethodBeat.o(140944);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.ui.m.b$b  reason: collision with other inner class name */
    static final class RunnableC2119b implements Runnable {
        final /* synthetic */ b QnI;

        RunnableC2119b(b bVar) {
            this.QnI = bVar;
        }

        public final void run() {
            AppMethodBeat.i(140939);
            Log.d(b.TAG, "MSG_STORY_LONG_PRESS_CHECK");
            if (this.QnI.QnF) {
                kotlin.g.a.a<Boolean> aVar = this.QnI.QnE;
                if (aVar == null) {
                    AppMethodBeat.o(140939);
                    return;
                } else if (aVar.invoke().booleanValue()) {
                    this.QnI.QnB = true;
                }
            }
            AppMethodBeat.o(140939);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(140940);
        p.h(aVar, "consumer");
        this.QnG.add(aVar);
        AppMethodBeat.o(140940);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void al(MotionEvent motionEvent) {
        int i2 = 1;
        boolean z = false;
        AppMethodBeat.i(140941);
        p.h(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.deo = motionEvent.getX();
                this.dep = motionEvent.getY();
                this.QnB = false;
                this.CIx = false;
                this.QnC = false;
                this.QnD = 0;
                MMHandlerThread.postToMainThreadDelayed(this.had, (long) this.QnA);
                Log.d(TAG, "downX:" + this.deo + "  downY:" + this.dep);
                AppMethodBeat.o(140941);
                return;
            case 1:
            case 3:
                MMHandlerThread.removeRunnable(this.had);
                this.QnD = 0;
                this.QnC = true;
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f2 = x - this.deo;
                float f3 = y - this.dep;
                if (!this.CIx) {
                    if (Math.abs(x - this.deo) > ((float) this.rZ) || Math.abs(y - this.dep) > ((float) this.rZ)) {
                        z = true;
                    }
                    this.CIx = z;
                }
                if (this.CIx) {
                    MMHandlerThread.removeRunnable(this.had);
                    if (this.QnD == 0) {
                        if (Math.abs(f3) > Math.abs(f2)) {
                            if (f3 >= 0.0f) {
                                i2 = 2;
                            }
                        } else if (f2 < 0.0f) {
                            i2 = 4;
                        } else {
                            i2 = 8;
                        }
                        this.QnD = i2;
                    }
                }
                Log.d(TAG, "scrollType " + this.QnD + " move: " + f2 + ", " + f3);
                AppMethodBeat.o(140941);
                return;
        }
        AppMethodBeat.o(140941);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.i(140942);
        p.h(motionEvent, "event");
        Log.d(TAG, "dispatchTouchEvent " + motionEvent.getAction() + ", " + motionEvent.getX() + ' ' + motionEvent.getY());
        int i3 = this.QnD;
        switch (motionEvent.getActionMasked()) {
            case 1:
            case 3:
                i2 = 15;
                z = true;
                break;
            case 2:
                if (this.QnC) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                i2 = this.QnD;
                Log.d(TAG, "scrollType " + this.QnD);
                z = z2;
                break;
            default:
                i2 = i3;
                z = true;
                break;
        }
        if (this.QnB) {
            z4 = true;
        }
        if (!z4 && z) {
            Iterator<a> it = this.QnG.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (!z4) {
                    if (!this.CIx || (next.fsk() & i2) != 0) {
                        z3 = next.a(motionEvent, this.CIx, i2) | z4;
                    } else {
                        z3 = z4;
                    }
                    z4 = z3;
                }
            }
        }
        AppMethodBeat.o(140942);
        return z4;
    }
}
