package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.webview.fts.c.c;

public final class a {
    EnumC1956a IPO = EnumC1956a.None;
    b IPP;
    int MQ = 0;
    Context mContext;
    View mDH;
    GestureDetector mDJ;
    float mDL = 0.0f;
    int mDM = -1;
    int mDN = 0;
    Runnable mDO = new Runnable() {
        /* class com.tencent.mm.plugin.webview.fts.ui.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(78028);
            a.this.IPP.bJj();
            AppMethodBeat.o(78028);
        }
    };
    float mue = 0.0f;

    public interface b {
        void aM(float f2);

        void aN(float f2);

        void bJj();

        void bJk();

        void bJl();

        void bJm();

        void bJn();

        boolean fyT();

        int getCurrentPosition();

        int k(int i2, float f2);

        void l(int i2, float f2);
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.a$a  reason: collision with other inner class name */
    enum EnumC1956a {
        None,
        Volume,
        Brightness,
        FastBackwardOrForward;

        public static EnumC1956a valueOf(String str) {
            AppMethodBeat.i(78033);
            EnumC1956a aVar = (EnumC1956a) Enum.valueOf(EnumC1956a.class, str);
            AppMethodBeat.o(78033);
            return aVar;
        }

        static {
            AppMethodBeat.i(78034);
            AppMethodBeat.o(78034);
        }
    }

    public a(Context context, View view, b bVar) {
        AppMethodBeat.i(78035);
        this.mContext = context;
        this.IPP = bVar;
        this.mDH = view;
        this.mDJ = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.plugin.webview.fts.ui.a.AnonymousClass2 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(210855);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(210855);
                return onContextClick;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(210854);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(210854);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(78029);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                a.this.mDH.postDelayed(a.this.mDO, 200);
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(78029);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(78030);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                a.this.mDH.removeCallbacks(a.this.mDO);
                a.this.IPP.bJk();
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(78030);
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:49:0x0118  */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x012e  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onScroll(android.view.MotionEvent r11, android.view.MotionEvent r12, float r13, float r14) {
                /*
                // Method dump skipped, instructions count: 311
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.ui.a.AnonymousClass2.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
            }
        });
        this.mue = c.dV(context);
        AppMethodBeat.o(78035);
    }
}
