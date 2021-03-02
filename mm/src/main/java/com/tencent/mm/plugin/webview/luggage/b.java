package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public final class b extends RelativeLayout {
    private WebView IJw;
    private m ISN;
    private boolean ISO;
    private Runnable ISP = new Runnable() {
        /* class com.tencent.mm.plugin.webview.luggage.b.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(210861);
            if (!b.this.ISO || b.this.mDisabled) {
                AppMethodBeat.o(210861);
                return;
            }
            int webScrollY = b.this.IJw.getWebScrollY();
            if (b.this.ISQ != webScrollY) {
                b.this.ISQ = webScrollY;
                b.this.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.b.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(210860);
                        b.e(b.this);
                        AppMethodBeat.o(210860);
                    }
                });
                h.RTc.o(b.this.ISP, 100);
            }
            AppMethodBeat.o(210861);
        }
    };
    private int ISQ;
    private GestureDetector mDJ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
        /* class com.tencent.mm.plugin.webview.luggage.b.AnonymousClass2 */

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(210867);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            a.a(onContextClick, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(210867);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(210866);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            a.a(onDoubleTap, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(210866);
            return onDoubleTap;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(210865);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            a.a(this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(210865);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(210864);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            a.a(onSingleTapUp, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(210864);
            return onSingleTapUp;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(210863);
            if (!b.this.mDisabled) {
                b.this.ISO = true;
                b.this.ISQ = b.this.IJw.getWebScrollY();
                b.this.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.b.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(210862);
                        b.e(b.this);
                        AppMethodBeat.o(210862);
                    }
                });
                h.RTc.o(b.this.ISP, 100);
            }
            AppMethodBeat.o(210863);
            return false;
        }
    }, null);
    private boolean mDisabled = true;

    static /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(210871);
        bVar.gbw();
        AppMethodBeat.o(210871);
    }

    public b(Context context) {
        super(context);
        AppMethodBeat.i(210868);
        AppMethodBeat.o(210868);
    }

    public final void setDisable(boolean z) {
        this.mDisabled = z;
    }

    public final void setWebView(WebView webView) {
        this.IJw = webView;
    }

    public final void setActionBar(m mVar) {
        this.ISN = mVar;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(210869);
        this.ISO = false;
        if (this.mDisabled) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(210869);
            return onInterceptTouchEvent;
        }
        GestureDetector gestureDetector = this.mDJ;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/webview/luggage/ImmersivePageView", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/webview/luggage/ImmersivePageView", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        int action = motionEvent.getAction();
        if (action == 2 || action == 1) {
            gbw();
        }
        boolean onInterceptTouchEvent2 = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(210869);
        return onInterceptTouchEvent2;
    }

    private void gbw() {
        AppMethodBeat.i(210870);
        int webScrollY = this.IJw.getWebScrollY();
        if (webScrollY < 300) {
            this.ISN.gbZ();
        } else if (webScrollY > 450) {
            this.ISN.setAlpha(1.0f);
        } else {
            this.ISN.setAlpha(((float) (webScrollY - 300)) / 150.0f);
        }
        Log.i("MicroMsg.ImmersivePageView", "setActionBarAlpha, scrollY : %d", Integer.valueOf(webScrollY));
        AppMethodBeat.o(210870);
    }
}
