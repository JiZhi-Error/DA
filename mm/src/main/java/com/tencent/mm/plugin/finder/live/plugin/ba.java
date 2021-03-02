package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J,\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J,\u0010 \u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0016J\u0012\u0010#\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010$\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010%\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0019\u0010&\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010'J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020+H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "clearView", "Landroid/view/View;", "clickTime", "", "downTime", "clearScreeen", "", "clear", "", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", e.a.NAME, "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "screenAction", "(Ljava/lang/Boolean;)V", "screenClickLogic", "setVisible", "visible", "", "plugin-finder_release"})
public final class ba extends d implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    private final String TAG = "Finder.LiveScreenClearPlugin";
    private long hET;
    private final b hOp;
    private long nJh;
    private View utw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ba(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246965);
        this.hOp = bVar;
        this.utw = viewGroup;
        this.nJh = SystemClock.elapsedRealtime();
        this.hET = -1;
        this.utw.setOnTouchListener(new View.OnTouchListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ba.AnonymousClass1 */
            final /* synthetic */ ba utx;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.utx = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(246957);
                Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
                if (valueOf != null && valueOf.intValue() == 0) {
                    this.utx.hET = SystemClock.elapsedRealtime();
                } else if (valueOf != null && valueOf.intValue() == 1) {
                    if (this.utx.hET > 0 && SystemClock.elapsedRealtime() - this.utx.hET <= ((long) ViewConfiguration.getTapTimeout())) {
                        ba.a(this.utx);
                    }
                    this.utx.hET = -1;
                }
                AppMethodBeat.o(246957);
                return true;
            }
        });
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(246965);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
        AppMethodBeat.o(246965);
    }

    static /* synthetic */ void a(ba baVar) {
        AppMethodBeat.i(246959);
        baVar.k(null);
        AppMethodBeat.o(246959);
    }

    public final void k(Boolean bool) {
        boolean z;
        s.h hVar;
        AppMethodBeat.i(246958);
        Log.i(this.TAG, "screenClickLogic");
        if (SystemClock.elapsedRealtime() - this.nJh < ((long) ViewConfiguration.getDoubleTapTimeout())) {
            AppMethodBeat.o(246958);
            return;
        }
        this.nJh = SystemClock.elapsedRealtime();
        FinderLiveViewCallback.a aVar = FinderLiveViewCallback.ufM;
        if (FinderLiveViewCallback.ufL) {
            String str = this.TAG;
            StringBuilder sb = new StringBuilder("[screenAction] inNewGuideStatus:");
            FinderLiveViewCallback.a aVar2 = FinderLiveViewCallback.ufM;
            Log.i(str, sb.append(FinderLiveViewCallback.ufL).append(" return").toString());
            AppMethodBeat.o(246958);
            return;
        }
        g liveData = getLiveData();
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = !getLiveData().uDR;
        }
        liveData.uDR = z;
        Log.i(this.TAG, "screenAction liveData.screenClear:" + getLiveData().uDR);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", getLiveData().uDR);
        this.hOp.statusChange(b.c.hNl, bundle);
        if (this.hOp.getLiveRole() == 0) {
            if (getLiveData().uDR) {
                hVar = s.h.CLICK_CLEAR_SCREEN;
            } else {
                hVar = s.h.CLICK_CLEAR_SCREEN_CANCEL;
            }
            m.vli.a(hVar);
        }
        if (getLiveData().uDR && isLandscape() && Build.VERSION.SDK_INT >= 21) {
            Context context = this.hwr.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(246958);
                throw tVar;
            }
            Window window = ((Activity) context).getWindow();
            p.g(window, "(root.context as Activity).window");
            View decorView = window.getDecorView();
            p.g(decorView, "(root.context as Activity).window.decorView");
            decorView.setSystemUiVisibility(3846);
        }
        AppMethodBeat.o(246958);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(246960);
        Log.i(this.TAG, "visibility:" + (i2 == 0));
        super.rg(i2);
        AppMethodBeat.o(246960);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(246961);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        a.a(false, (Object) this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(246961);
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(246962);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(246962);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AppMethodBeat.i(246963);
        k(null);
        AppMethodBeat.o(246963);
        return true;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(246964);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        k(null);
        a.a(true, (Object) this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(246964);
        return true;
    }
}
