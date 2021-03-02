package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class DragFeatureView extends FrameLayout implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private boolean canScroll = true;
    private Rect dtb = new Rect();
    private GestureDetector mDJ;
    Paint mPaint = new Paint();
    protected Rect mRect = new Rect();
    private RecyclerView mRecyclerView;
    private boolean omQ = false;
    protected int ooH;
    private Runnable ooI;
    private c ooJ;
    private RecyclerView.v ooK;
    int ooL = -1;
    private Vibrator ooM;
    private View ooN;
    protected Rect ooO = new Rect();
    protected Rect ooP = new Rect();
    private boolean ooQ = true;
    private LinearLayout ooR;
    private ImageView ooS;
    private TextView ooT;
    private boolean ooU = false;
    private f ooV = null;
    private boolean ooW = false;
    private Runnable ooX;
    private Animator.AnimatorListener ooY = new Animator.AnimatorListener() {
        /* class com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView.AnonymousClass4 */

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(49647);
            DragFeatureView.this.caH();
            DragFeatureView.this.requestLayout();
            if (DragFeatureView.this.ooW && (DragFeatureView.this.mRecyclerView instanceof DragRecyclerView)) {
                ((DragRecyclerView) DragFeatureView.this.mRecyclerView).setLongPress(false);
                DragFeatureView.this.ooW = false;
                DragFeatureView.this.ooU = false;
            }
            AppMethodBeat.o(49647);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    };

    /* access modifiers changed from: protected */
    public abstract c P(RecyclerView.v vVar);

    public DragFeatureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DragFeatureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }

    public void setTouchEnabled(boolean z) {
        this.ooQ = z;
    }

    private void init(Context context) {
        this.ooH = (int) getResources().getDimension(R.dimen.ahp);
        setVisibility(8);
        this.mDJ = new GestureDetector(context, this);
        this.ooM = (Vibrator) context.getSystemService("vibrator");
        addView(caI());
    }

    private void setItemDragCallback(c cVar) {
        this.ooJ = cVar;
    }

    public c getItemDragCallback() {
        return this.ooJ;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void setRecyclerViewScrollComputer(f fVar) {
        this.ooV = fVar;
    }

    public f getRecyclerScrollComputer() {
        return this.ooV;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x019c, code lost:
        if (r0.S(r4) != false) goto L_0x019e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onScroll(android.view.MotionEvent r12, android.view.MotionEvent r13, float r14, float r15) {
        /*
        // Method dump skipped, instructions count: 458
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    public void onLongPress(MotionEvent motionEvent) {
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        try {
            if (this.ooU) {
                Log.w("MicroMsg.DragFeatureView", "alvinluo DragFeatureView onLongPress is in long press and ignore");
                this.ooU = false;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                return;
            }
            this.ooU = true;
            RecyclerView.v e2 = e(motionEvent.getRawX(), motionEvent.getRawY(), true);
            setItemDragCallback(P(e2));
            if (e2 != null) {
                c cVar = this.ooJ;
                getRecyclerView();
                if (cVar.R(e2)) {
                    this.ooN = this.ooJ.g(getRecyclerView(), e2);
                    if (this.ooN != null) {
                        setVisibility(8);
                        this.ooL = e2.lR();
                        this.ooK = e2;
                        this.ooM.vibrate(30);
                        setRubbishViewVisible(0);
                        setVisibility(0);
                        motionEvent.setAction(0);
                        GestureDetector gestureDetector = this.mDJ;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                        motionEvent.setAction(3);
                        GestureDetector gestureDetector2 = this.mDJ;
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector2, bl2.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector2, gestureDetector2.onTouchEvent((MotionEvent) bl2.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                    }
                    setRubbishViewVisible(8);
                }
            }
            setVisibility(8);
            motionEvent.setAction(0);
            GestureDetector gestureDetector3 = this.mDJ;
            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector3, bl3.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector3, gestureDetector3.onTouchEvent((MotionEvent) bl3.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            motionEvent.setAction(3);
            GestureDetector gestureDetector22 = this.mDJ;
            com.tencent.mm.hellhoundlib.b.a bl22 = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector22, bl22.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector22, gestureDetector22.onTouchEvent((MotionEvent) bl22.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.DragFeatureView", e3, "alvinluo onLongPress exception", new Object[0]);
            motionEvent.setAction(0);
            GestureDetector gestureDetector4 = this.mDJ;
            com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector4, bl4.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector4, gestureDetector4.onTouchEvent((MotionEvent) bl4.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            motionEvent.setAction(3);
            GestureDetector gestureDetector5 = this.mDJ;
            com.tencent.mm.hellhoundlib.b.a bl5 = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector5, bl5.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector5, gestureDetector5.onTouchEvent((MotionEvent) bl5.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", e.a.NAME, "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        }
    }

    class a implements Runnable {
        final RecyclerView.v amO;

        a(RecyclerView.v vVar) {
            this.amO = vVar;
        }

        public final void run() {
            AppMethodBeat.i(49648);
            if (this.amO == null) {
                AppMethodBeat.o(49648);
                return;
            }
            int i2 = DragFeatureView.this.ooL;
            int lR = this.amO.lR();
            if (lR >= 0 || i2 >= 0) {
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(DragFeatureView.this.ooK != this.amO);
                c cVar = DragFeatureView.this.ooJ;
                DragFeatureView.this.getRecyclerView();
                RecyclerView.v unused = DragFeatureView.this.ooK;
                objArr[1] = Boolean.valueOf(cVar.T(this.amO));
                objArr[2] = Integer.valueOf(i2);
                objArr[3] = Integer.valueOf(lR);
                Log.i("MicroMsg.DragFeatureView", "alvinluo move run %b, onMove: %b, from: %d, to: %d", objArr);
                if (DragFeatureView.this.ooK != this.amO) {
                    c cVar2 = DragFeatureView.this.ooJ;
                    DragFeatureView.this.getRecyclerView();
                    RecyclerView.v unused2 = DragFeatureView.this.ooK;
                    if (cVar2.T(this.amO) && DragFeatureView.this.ooJ.a(DragFeatureView.this.getRecyclerView(), DragFeatureView.this.ooK, this.amO, i2, lR)) {
                        DragFeatureView.this.ooL = lR;
                    }
                }
                AppMethodBeat.o(49648);
                return;
            }
            AppMethodBeat.o(49648);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        getGlobalVisibleRect(this.ooO);
        this.ooO.set(this.ooO.left, this.ooO.bottom - (this.ooH * 2), this.ooO.right, this.ooO.bottom - this.ooH);
        getRecyclerView().getGlobalVisibleRect(this.ooP);
        this.ooP.set(this.ooP.left, 0, this.ooP.right, this.ooP.top + this.ooH);
        findViewById(R.id.h9v).getGlobalVisibleRect(this.dtb);
    }

    public Rect getRubbishRect() {
        return this.dtb;
    }

    public Rect getTopScrollRect() {
        return this.ooP;
    }

    public Rect getBottomScrollRect() {
        return this.ooO;
    }

    private void je(final boolean z) {
        if (this.ooX == null) {
            AnonymousClass2 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(49645);
                    Log.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge isTop: %b", Boolean.valueOf(z));
                    Log.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge canScroll: %b", Boolean.valueOf(DragFeatureView.this.getRecyclerView().canScrollVertically(z ? -10 : 10)));
                    DragFeatureView.this.getRecyclerView().scrollBy(0, z ? -20 : 20);
                    DragFeatureView.this.post(this);
                    AppMethodBeat.o(49645);
                }
            };
            this.ooX = r0;
            postDelayed(r0, 250);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-65536);
        if (this.ooO != null) {
            canvas.drawRect(this.ooO, this.mPaint);
        }
        this.mPaint.setColor(-16711936);
        if (this.ooP != null) {
            canvas.drawRect(this.ooP, this.mPaint);
        }
    }

    /* access modifiers changed from: protected */
    public RecyclerView.v e(float f2, float f3, boolean z) {
        if (this.ooO.contains((int) f2, (int) f3)) {
            return null;
        }
        for (int i2 = 0; i2 < getRecyclerView().getChildCount(); i2++) {
            RecyclerView.v bi = getRecyclerView().bi(getRecyclerView().getChildAt(i2));
            bi.aus.getGlobalVisibleRect(this.mRect);
            if (this.mRect.contains((int) f2, (int) f3)) {
                return bi;
            }
        }
        return this.ooP.contains((int) f2, (int) f3) ? null : null;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    private boolean P(float f2, float f3) {
        return getRubbishRect().contains((int) f2, (int) f3) || getRubbishRect().top < ((int) f3);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.ooQ) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!P(motionEvent.getRawX(), motionEvent.getRawY())) {
                    removeCallbacks(this.ooI);
                    removeCallbacks(this.ooX);
                    setRubbishViewVisible(8);
                    int i2 = this.ooL;
                    this.ooL = -1;
                    this.omQ = false;
                    this.ooJ.a(getRecyclerView(), this.ooK, i2, new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(49646);
                            DragFeatureView.this.setVisibility(8);
                            DragFeatureView.this.ooN = null;
                            DragFeatureView.this.ooX = null;
                            AppMethodBeat.o(49646);
                        }
                    });
                    break;
                } else {
                    this.ooL = -1;
                    this.omQ = false;
                    this.ooJ.h(getRecyclerView(), this.ooK);
                    removeCallbacks(this.ooI);
                    removeCallbacks(this.ooX);
                    if (this.ooN != null) {
                        this.ooN.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setListener(new Animator.AnimatorListener() {
                            /* class com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView.AnonymousClass1 */

                            public final void onAnimationStart(Animator animator) {
                            }

                            public final void onAnimationEnd(Animator animator) {
                                AppMethodBeat.i(49644);
                                DragFeatureView.this.removeView(DragFeatureView.this.ooN);
                                DragFeatureView.this.caH();
                                DragFeatureView.this.setRubbishViewVisible(8);
                                AppMethodBeat.o(49644);
                            }

                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }
                        }).setDuration(300).start();
                        break;
                    }
                }
                break;
            case 2:
                if (!P(motionEvent.getRawX(), motionEvent.getRawY())) {
                    caH();
                    break;
                } else {
                    this.ooR.setBackgroundColor(getContext().getResources().getColor(R.color.d_));
                    this.ooT.setText(R.string.k_);
                    this.ooT.setTextSize(2, getRubbishViewTextSize());
                    this.ooS.setImageResource(R.drawable.bxp);
                    break;
                }
        }
        GestureDetector gestureDetector = this.mDJ;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        return true;
    }

    public final void hx(boolean z) {
        Log.i("MicroMsg.DragFeatureView", "alvinluo enableScroll %b", Boolean.valueOf(z));
        this.canScroll = z;
    }

    private float getRubbishViewTextSize() {
        return 12.0f * b.ez(getContext());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void caH() {
        try {
            this.ooT.setText(R.string.k5);
            this.ooT.setTextSize(1, getRubbishViewTextSize());
            this.ooS.setImageResource(R.drawable.bxo);
            this.ooR.setBackgroundColor(getContext().getResources().getColor(R.color.d9));
        } catch (Exception e2) {
        }
    }

    private View caI() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.d9));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.ooH);
        layoutParams.gravity = 80;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setId(R.id.h9v);
        linearLayout.setTranslationY((float) layoutParams.height);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.bxo);
        imageView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        Log.i("MicroMsg.DragFeatureView", "alvinluo rubbishView icon size: %d,%d", Integer.valueOf(imageView.getMeasuredWidth()), Integer.valueOf(imageView.getMeasuredHeight()));
        layoutParams2.width = (int) (((float) imageView.getMeasuredWidth()) * b.ez(getContext()));
        layoutParams2.height = (int) (((float) imageView.getMeasuredHeight()) * b.ez(getContext()));
        imageView.setLayoutParams(layoutParams2);
        TextView textView = new TextView(getContext());
        textView.setText(R.string.k5);
        textView.setTextSize(1, getRubbishViewTextSize());
        textView.setTextColor(getContext().getResources().getColor(R.color.ag2));
        textView.setPadding(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 4), 0, 0);
        textView.setGravity(17);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        this.ooR = linearLayout;
        this.ooS = imageView;
        this.ooT = textView;
        return linearLayout;
    }

    /* access modifiers changed from: protected */
    public void setRubbishViewVisible(int i2) {
        View findViewById = findViewById(R.id.h9v);
        if (findViewById != null) {
            if (i2 == 0) {
                findViewById.animate().translationY(0.0f).setDuration(300).setListener(this.ooY).start();
                return;
            }
            this.ooW = true;
            findViewById.animate().translationY((float) findViewById.getHeight()).setDuration(300).setListener(this.ooY).start();
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }
}
