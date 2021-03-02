package com.tencent.mm.live.core.view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class b extends RelativeLayout implements View.OnClickListener {
    public WeakReference<AbstractC0390b> hAW;
    private boolean hBi;
    private boolean hBz;
    SurfaceView hEY;
    private View.OnClickListener hEZ;
    private GestureDetector hFa;
    private LinearLayout hFb;
    private Button hFc;
    private Button hFd;
    private Button hFe;
    private FrameLayout hFf;
    private TextView hFg;
    private ImageView hFh;
    private ViewGroup hFi;
    private HashMap<Integer, Integer> hFj;
    boolean hFk;
    private boolean hFl;
    private boolean hFm;
    a hFn;
    private float hFo;
    private float hFp;
    TXCloudVideoView mVideoView;

    public interface a {
        void C(float f2, float f3);
    }

    /* renamed from: com.tencent.mm.live.core.view.b$b  reason: collision with other inner class name */
    public interface AbstractC0390b {
        void g(b bVar);

        void h(b bVar);

        void i(b bVar);

        void j(b bVar);
    }

    public b(Context context, boolean z) {
        this(context, z, (byte) 0);
    }

    private b(Context context, boolean z, byte b2) {
        super(context, null);
        AppMethodBeat.i(196332);
        this.hFj = null;
        this.hFl = false;
        this.hBi = true;
        this.hBz = true;
        this.hFm = false;
        this.hFn = null;
        this.hFo = 0.0f;
        this.hFp = 0.0f;
        this.hFm = z;
        this.hFi = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.aze, (ViewGroup) this, true);
        if (this.hFm) {
            this.mVideoView = (TXCloudVideoView) this.hFi.findViewById(R.id.emq);
            this.mVideoView.setVisibility(0);
        } else {
            this.hEY = (SurfaceView) this.hFi.findViewById(R.id.eg7);
            this.hEY.setVisibility(0);
        }
        this.hFb = (LinearLayout) this.hFi.findViewById(R.id.ivm);
        this.hFc = (Button) this.hFi.findViewById(R.id.ivj);
        this.hFc.setOnClickListener(this);
        this.hFd = (Button) this.hFi.findViewById(R.id.ivi);
        this.hFd.setOnClickListener(this);
        this.hFe = (Button) this.hFi.findViewById(R.id.ivh);
        this.hFe.setOnClickListener(this);
        this.hFf = (FrameLayout) this.hFi.findViewById(R.id.ivk);
        this.hFg = (TextView) this.hFi.findViewById(R.id.ivn);
        this.hFh = (ImageView) this.hFi.findViewById(R.id.ivl);
        ((ToggleButton) this.hFi.findViewById(R.id.fqu)).setOnClickListener(this);
        this.hFa = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.live.core.view.b.AnonymousClass1 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(196330);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(196330);
                return onContextClick;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(196329);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(196329);
                return onDoubleTap;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(196328);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(196328);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(196326);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                if (b.this.hEZ != null) {
                    b.this.hEZ.onClick(b.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(196326);
                return true;
            }

            public final boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                AppMethodBeat.i(196327);
                if (!b.this.hFk) {
                    AppMethodBeat.o(196327);
                    return false;
                }
                if (b.this.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) b.this.getLayoutParams();
                    int max = Math.max(Math.min(au.az(b.this.getContext()).x - b.this.getWidth(), (int) (((float) layoutParams.leftMargin) + (motionEvent2.getX() - motionEvent.getX()))), 0);
                    int max2 = Math.max(Math.min(au.az(b.this.getContext()).y - b.this.getHeight(), (int) (((float) layoutParams.topMargin) + (motionEvent2.getY() - motionEvent.getY()))), 0);
                    layoutParams.leftMargin = max;
                    layoutParams.topMargin = max2;
                    b.this.setLayoutParams(layoutParams);
                }
                AppMethodBeat.o(196327);
                return true;
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.live.core.view.b.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(196331);
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        b.this.hFo = motionEvent.getRawX();
                        b.this.hFp = motionEvent.getRawY();
                        break;
                    case 1:
                    case 3:
                        float rawX = motionEvent.getRawX() - b.this.hFo;
                        float rawY = motionEvent.getRawY() - b.this.hFp;
                        if (b.this.hFk && b.this.hFn != null) {
                            b.this.hFn.C(rawX, rawY);
                            break;
                        }
                }
                GestureDetector gestureDetector = b.this.hFa;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(196331);
                return a2;
            }
        });
        this.hFj = new HashMap<>();
        AppMethodBeat.o(196332);
    }

    public final TXCloudVideoView getVideoView() {
        return this.mVideoView;
    }

    public final SurfaceView getCameraView() {
        return this.hEY;
    }

    public final void setBottomControllerVisibility(int i2) {
        AppMethodBeat.i(196333);
        if (this.hFb != null) {
            this.hFb.setVisibility(8);
        }
        AppMethodBeat.o(196333);
    }

    public final void GF(String str) {
        AppMethodBeat.i(196334);
        if (this.hFg != null) {
            this.hFg.setText(str);
        }
        if (this.hFf != null) {
            this.hFf.setVisibility(8);
        }
        AppMethodBeat.o(196334);
    }

    public final void setGestureListener(a aVar) {
        this.hFn = aVar;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.hEZ = onClickListener;
    }

    public final void setMoveable(boolean z) {
        this.hFk = z;
    }

    public final void onClick(View view) {
        boolean z = true;
        AppMethodBeat.i(196335);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        AbstractC0390b bVar2 = this.hAW != null ? this.hAW.get() : null;
        if (bVar2 == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(196335);
            return;
        }
        int id = view.getId();
        if (id == R.id.ivh) {
            this.hFl = !this.hFl;
            bVar2.g(this);
        } else if (id == R.id.ivi) {
            if (this.hBi) {
                z = false;
            }
            this.hBi = z;
            bVar2.h(this);
        } else if (id == R.id.ivj) {
            if (this.hBz) {
                z = false;
            }
            this.hBz = z;
            bVar2.i(this);
        } else if (id == R.id.fqu) {
            ((ToggleButton) view).isChecked();
            bVar2.j(this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196335);
    }

    public final void setIVideoLayoutListener(AbstractC0390b bVar) {
        AppMethodBeat.i(196336);
        this.hAW = new WeakReference<>(bVar);
        AppMethodBeat.o(196336);
    }
}
