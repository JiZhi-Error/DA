package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.l;

public final class a {
    int MQ = 0;
    Context mContext;
    View mDH;
    EnumC0718a mDI = EnumC0718a.None;
    private GestureDetector mDJ;
    b mDK;
    private float mDL = 0.0f;
    int mDM = -1;
    int mDN = 0;
    Runnable mDO = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(235151);
            a.this.mDK.bJj();
            AppMethodBeat.o(235151);
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

        boolean bJo();

        boolean bJp();

        boolean bJq();

        int getCurrentPosition();

        int k(int i2, float f2);

        void l(int i2, float f2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.ui.a$a  reason: collision with other inner class name */
    enum EnumC0718a {
        None,
        Volume,
        Brightness,
        FastBackwardOrForward;

        public static EnumC0718a valueOf(String str) {
            AppMethodBeat.i(235158);
            EnumC0718a aVar = (EnumC0718a) Enum.valueOf(EnumC0718a.class, str);
            AppMethodBeat.o(235158);
            return aVar;
        }

        static {
            AppMethodBeat.i(235159);
            AppMethodBeat.o(235159);
        }
    }

    public a(Context context, View view, b bVar) {
        AppMethodBeat.i(235160);
        this.mContext = context;
        this.mDK = bVar;
        this.mDH = view;
        this.mDJ = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.AnonymousClass2 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(235156);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(235156);
                return onContextClick;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(235155);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(235155);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(235152);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                a.this.mDH.postDelayed(a.this.mDO, 200);
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(235152);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(235153);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                a.this.mDH.removeCallbacks(a.this.mDO);
                a.this.mDK.bJk();
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(235153);
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:48:0x0125  */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x013d  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onScroll(android.view.MotionEvent r12, android.view.MotionEvent r13, float r14, float r15) {
                /*
                // Method dump skipped, instructions count: 328
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.AnonymousClass2.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
            }
        });
        this.mue = l.dV(context);
        AppMethodBeat.o(235160);
    }

    public final void A(MotionEvent motionEvent) {
        AppMethodBeat.i(235161);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mDL = motionEvent.getRawX();
            bLa();
        }
        GestureDetector gestureDetector = this.mDJ;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (actionMasked == 1 || actionMasked == 3) {
            if (this.mDI == EnumC0718a.FastBackwardOrForward) {
                this.mDK.l(this.mDN, motionEvent.getRawX() - this.mDL);
                this.mDM = -1;
                this.mDN = 0;
                this.mDL = 0.0f;
            } else if (this.mDI == EnumC0718a.Volume) {
                ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                this.mDK.bJm();
            } else if (this.mDI == EnumC0718a.Brightness) {
                this.mDK.bJn();
            }
            this.mDI = EnumC0718a.None;
        }
        AppMethodBeat.o(235161);
    }

    public final void bKZ() {
        this.mDM = -1;
        this.mDN = 0;
        this.mDL = 0.0f;
    }

    private void bLa() {
        AppMethodBeat.i(235162);
        this.MQ = ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
        this.mue = l.dV(this.mContext);
        AppMethodBeat.o(235162);
    }
}
