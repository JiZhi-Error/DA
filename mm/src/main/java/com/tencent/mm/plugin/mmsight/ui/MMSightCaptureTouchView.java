package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.wcdb.support.Log;

public class MMSightCaptureTouchView extends RelativeLayout {
    private GestureDetector jKk;
    private float kyX;
    private int kyY;
    private long zAN;
    private a zAO;

    public interface a {
        void I(float f2, float f3);

        void bqQ();

        void bqR();

        void cJL();
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(94512);
        this.zAN = 0;
        this.kyX = -1.0f;
        this.kyY = 0;
        this.jKk = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.AnonymousClass1 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(187077);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(187077);
                return onContextClick;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(187076);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(187076);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(94509);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapUp");
                if (MMSightCaptureTouchView.this.zAO != null) {
                    MMSightCaptureTouchView.this.zAO.I(motionEvent.getX(), motionEvent.getY());
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(94509);
                return false;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(94510);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                Log.i("MicroMsg.MMSightCaptureTouchView", "onDoubleTap");
                if (System.currentTimeMillis() - MMSightCaptureTouchView.this.zAN > 1000) {
                    if (MMSightCaptureTouchView.this.zAO != null) {
                        MMSightCaptureTouchView.this.zAO.cJL();
                    }
                    MMSightCaptureTouchView.this.zAN = System.currentTimeMillis();
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(94510);
                return false;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                AppMethodBeat.i(94511);
                Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapConfirmed");
                AppMethodBeat.o(94511);
                return true;
            }
        });
        this.jKk.setIsLongpressEnabled(false);
        AppMethodBeat.o(94512);
    }

    public void setTouchCallback(a aVar) {
        this.zAO = aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(94513);
        GestureDetector gestureDetector = this.jKk;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        switch (motionEvent.getAction() & 255) {
            case 0:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_DOWN");
                this.kyX = -1.0f;
                this.kyY++;
                break;
            case 1:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
                this.kyX = -1.0f;
                this.kyY = 0;
                break;
            case 2:
                if (this.kyY >= 2) {
                    float x = x(motionEvent);
                    Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", Float.valueOf(x));
                    if (x > 0.0f) {
                        if (this.kyX > 0.0f) {
                            if (Math.abs(x - this.kyX) > 15.0f) {
                                if (x > this.kyX) {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
                                    if (this.zAO != null) {
                                        this.zAO.bqQ();
                                    }
                                } else {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
                                    if (this.zAO != null) {
                                        this.zAO.bqR();
                                    }
                                }
                            }
                        }
                        this.kyX = x;
                        break;
                    }
                }
                break;
            case 5:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
                this.kyY++;
                break;
            case 6:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
                this.kyY--;
                break;
        }
        AppMethodBeat.o(94513);
        return true;
    }

    private float x(MotionEvent motionEvent) {
        AppMethodBeat.i(94514);
        try {
            if (this.kyY >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                float abs = Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
                AppMethodBeat.o(94514);
                return abs;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightCaptureTouchView", "pointerDistance error: %s", e2.getMessage());
        }
        AppMethodBeat.o(94514);
        return 0.0f;
    }
}
