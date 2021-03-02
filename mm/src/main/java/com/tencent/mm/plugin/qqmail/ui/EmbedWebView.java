package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;

public class EmbedWebView extends MMWebView {
    private GestureDetector Bvq = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
        /* class com.tencent.mm.plugin.qqmail.ui.EmbedWebView.AnonymousClass1 */

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(198707);
            b bVar = new b();
            bVar.bm(motionEvent);
            a.b("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            a.a(onContextClick, this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198707);
            return onContextClick;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(198706);
            b bVar = new b();
            bVar.bm(motionEvent);
            a.b("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            a.a(this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(198706);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(198705);
            b bVar = new b();
            bVar.bm(motionEvent);
            a.b("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            a.a(onSingleTapUp, this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198705);
            return onSingleTapUp;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(123003);
            b bVar = new b();
            bVar.bm(motionEvent);
            a.b("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            EmbedWebView embedWebView = EmbedWebView.this;
            Log.d("MicroMsg.EmbedWebView", "onDoubleTapm, before scale:" + embedWebView.getScale());
            int i2 = 10;
            while (embedWebView.getScale() != 1.0f && i2 - 1 > 0) {
                if (embedWebView.getScale() > 1.0f) {
                    embedWebView.zoomOut();
                } else {
                    embedWebView.zoomIn();
                }
            }
            Log.d("MicroMsg.EmbedWebView", "onDoubleTapm, after scale:" + EmbedWebView.this.getScale());
            a.a(true, (Object) this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(123003);
            return true;
        }
    });
    private boolean Bvr = false;
    private float[] Bvs = new float[2];
    private float[] Bvt = new float[2];
    private float[] Bvu = new float[2];
    private float[] Bvv = new float[2];

    public EmbedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(123006);
        postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.ui.EmbedWebView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(123005);
                View view = (View) EmbedWebView.this.getParent();
                if (view == null) {
                    AppMethodBeat.o(123005);
                    return;
                }
                View view2 = (View) view.getParent();
                if (view2 != null && (view2 instanceof ScrollView)) {
                    EmbedWebView.this.Bvr = true;
                    view2.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.plugin.qqmail.ui.EmbedWebView.AnonymousClass2.AnonymousClass1 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(123004);
                            if (motionEvent.getPointerCount() == 2) {
                                EmbedWebView.this.onTouchEvent(motionEvent);
                            }
                            AppMethodBeat.o(123004);
                            return false;
                        }
                    });
                }
                AppMethodBeat.o(123005);
            }
        }, 100);
        AppMethodBeat.o(123006);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(123007);
        GestureDetector gestureDetector = this.Bvq;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/EmbedWebView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/qqmail/ui/EmbedWebView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (this.Bvr) {
            int action = motionEvent.getAction() & 255;
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount != 2) {
                z = false;
            } else {
                switch (action) {
                    case 2:
                        for (int i2 = 0; i2 < pointerCount; i2++) {
                            this.Bvu[i2] = motionEvent.getX(i2);
                            this.Bvv[i2] = motionEvent.getY(i2);
                        }
                        float pow = (float) (Math.pow((double) (this.Bvs[1] - this.Bvs[0]), 2.0d) + Math.pow((double) (this.Bvt[1] - this.Bvt[0]), 2.0d));
                        float pow2 = (float) (Math.pow((double) (this.Bvu[1] - this.Bvu[0]), 2.0d) + Math.pow((double) (this.Bvv[1] - this.Bvv[0]), 2.0d));
                        if (pow - pow2 > 20000.0f) {
                            zoomOut();
                        } else if (pow2 - pow > 20000.0f) {
                            zoomIn();
                        }
                        this.Bvs[0] = this.Bvu[0];
                        this.Bvs[1] = this.Bvu[1];
                        this.Bvt[0] = this.Bvv[0];
                        this.Bvt[1] = this.Bvv[1];
                        break;
                    case 5:
                        for (int i3 = 0; i3 < pointerCount; i3++) {
                            this.Bvs[i3] = motionEvent.getX(i3);
                            this.Bvt[i3] = motionEvent.getY(i3);
                        }
                        break;
                }
                z = true;
            }
            if (z) {
                AppMethodBeat.o(123007);
                return true;
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(123007);
        return onTouchEvent;
    }
}
