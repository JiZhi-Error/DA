package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;

public final class k {
    a Gnk = a.None;
    c Gnl;
    boolean Gnm;
    boolean Gnn;
    int MQ = 0;
    Context mContext;
    View mDH;
    private GestureDetector mDJ;
    private float mDL = 0.0f;
    int mDM = -1;
    int mDN = 0;
    Runnable mDO = new Runnable() {
        /* class com.tencent.mm.plugin.topstory.ui.video.k.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(126097);
            k.this.Gnl.bJj();
            AppMethodBeat.o(126097);
        }
    };
    float mue = 0.0f;

    /* access modifiers changed from: package-private */
    public enum a {
        None,
        Volume,
        Brightness,
        FastBackwardOrForward;

        public static a valueOf(String str) {
            AppMethodBeat.i(126102);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(126102);
            return aVar;
        }

        static {
            AppMethodBeat.i(126103);
            AppMethodBeat.o(126103);
        }
    }

    public k(Context context, View view, c cVar) {
        AppMethodBeat.i(126104);
        this.mContext = context;
        this.Gnl = cVar;
        this.mDH = view;
        this.mDJ = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.k.AnonymousClass2 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(236390);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(236390);
                return onContextClick;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(236389);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(236389);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(126098);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                k.this.mDH.postDelayed(k.this.mDO, 200);
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(126098);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(126099);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                k.this.mDH.removeCallbacks(k.this.mDO);
                k.this.Gnl.bJk();
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(126099);
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:53:0x011d  */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x012b  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onScroll(android.view.MotionEvent r11, android.view.MotionEvent r12, float r13, float r14) {
                /*
                // Method dump skipped, instructions count: 308
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.video.k.AnonymousClass2.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
            }
        });
        this.mue = com.tencent.mm.plugin.websearch.ui.a.dV(context);
        AppMethodBeat.o(126104);
    }

    public final void A(MotionEvent motionEvent) {
        AppMethodBeat.i(126105);
        if (!this.Gnl.fyT()) {
            this.Gnk = a.None;
            AppMethodBeat.o(126105);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mDL = motionEvent.getRawX();
            this.MQ = ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
            this.mue = com.tencent.mm.plugin.websearch.ui.a.dV(this.mContext);
        }
        GestureDetector gestureDetector = this.mDJ;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/topstory/ui/video/TopStoryGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (actionMasked == 1 || actionMasked == 3) {
            if (this.Gnk == a.FastBackwardOrForward) {
                c cVar = this.Gnl;
                int i2 = this.mDN;
                motionEvent.getRawX();
                cVar.abX(i2);
                this.mDM = -1;
                this.mDN = 0;
                this.mDL = 0.0f;
            } else if (this.Gnk == a.Volume) {
                ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
            } else {
                a aVar = a.Brightness;
            }
            this.Gnk = a.None;
        }
        AppMethodBeat.o(126105);
    }

    public final void bKZ() {
        this.mDM = -1;
        this.mDN = 0;
        this.mDL = 0.0f;
    }
}
