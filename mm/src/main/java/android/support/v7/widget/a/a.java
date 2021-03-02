package android.support.v7.widget.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;

public final class a extends RecyclerView.h implements RecyclerView.i {
    Rect Ui;
    private final RecyclerView.k aAA = new RecyclerView.k() {
        /* class android.support.v7.widget.a.a.AnonymousClass2 */

        @Override // android.support.v7.widget.RecyclerView.k
        public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            c cVar;
            a.this.aAy.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                a.this.mActivePointerId = motionEvent.getPointerId(0);
                a.this.aAh = motionEvent.getX();
                a.this.aAi = motionEvent.getY();
                a.this.no();
                if (a.this.aAg == null) {
                    a aVar = a.this;
                    if (!aVar.aAs.isEmpty()) {
                        View m = aVar.m(motionEvent);
                        int size = aVar.aAs.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            }
                            cVar = aVar.aAs.get(size);
                            if (cVar.atw.aus == m) {
                                break;
                            }
                            size--;
                        }
                    }
                    cVar = null;
                    if (cVar != null) {
                        a.this.aAh -= cVar.mX;
                        a.this.aAi -= cVar.mY;
                        a.this.b(cVar.atw, true);
                        if (a.this.aAe.remove(cVar.atw.aus)) {
                            a.this.aAp.d(a.this.mRecyclerView, cVar.atw);
                        }
                        a.this.e(cVar.atw, cVar.aAq);
                        a.this.a(motionEvent, a.this.aAr, 0);
                    }
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                a.this.mActivePointerId = -1;
                a.this.e(null, 0);
            } else if (a.this.mActivePointerId != -1 && (findPointerIndex = motionEvent.findPointerIndex(a.this.mActivePointerId)) >= 0) {
                a.this.a(actionMasked, motionEvent, findPointerIndex);
            }
            if (a.this.mVelocityTracker != null) {
                a.this.mVelocityTracker.addMovement(motionEvent);
            }
            return a.this.aAg != null;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.support.v7.widget.RecyclerView.k
        public final void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            int i2 = 0;
            a.this.aAy.onTouchEvent(motionEvent);
            if (a.this.mVelocityTracker != null) {
                a.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (a.this.mActivePointerId != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(a.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    a.this.a(actionMasked, motionEvent, findPointerIndex);
                }
                RecyclerView.v vVar = a.this.aAg;
                if (vVar != null) {
                    switch (actionMasked) {
                        case 1:
                            break;
                        case 2:
                            if (findPointerIndex >= 0) {
                                a.this.a(motionEvent, a.this.aAr, findPointerIndex);
                                a.this.L(vVar);
                                a.this.mRecyclerView.removeCallbacks(a.this.aAt);
                                a.this.aAt.run();
                                a.this.mRecyclerView.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (a.this.mVelocityTracker != null) {
                                a.this.mVelocityTracker.clear();
                                break;
                            }
                            break;
                        case 4:
                        case 5:
                        default:
                            return;
                        case 6:
                            int actionIndex = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionIndex) == a.this.mActivePointerId) {
                                if (actionIndex == 0) {
                                    i2 = 1;
                                }
                                a.this.mActivePointerId = motionEvent.getPointerId(i2);
                                a.this.a(motionEvent, a.this.aAr, actionIndex);
                                return;
                            }
                            return;
                    }
                    a.this.e(null, 0);
                    a.this.mActivePointerId = -1;
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void ah(boolean z) {
            if (z) {
                a.this.e(null, 0);
            }
        }
    };
    long aAB;
    final List<View> aAe = new ArrayList();
    private final float[] aAf = new float[2];
    RecyclerView.v aAg = null;
    float aAh;
    float aAi;
    private float aAj;
    private float aAk;
    public float aAl;
    public float aAm;
    float aAn;
    float aAo;
    public AbstractC0053a aAp;
    private int aAq = 0;
    int aAr;
    List<c> aAs = new ArrayList();
    final Runnable aAt = new Runnable() {
        /* class android.support.v7.widget.a.a.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
            if (r3 < 0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
            if (r7 < 0) goto L_0x007a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0109, code lost:
            if (r3 > 0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0131, code lost:
            if (r7 > 0) goto L_0x007a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 319
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.a.a.AnonymousClass1.run():void");
        }
    };
    private List<RecyclerView.v> aAu;
    private List<Integer> aAv;
    View aAw = null;
    int aAx = -1;
    android.support.v4.view.c aAy;
    private b aAz;
    private RecyclerView.d asZ = null;
    private int awG;
    int mActivePointerId = -1;
    public RecyclerView mRecyclerView;
    VelocityTracker mVelocityTracker;

    public interface d {
        void e(View view, View view2);
    }

    public a(AbstractC0053a aVar) {
        this.aAp = aVar;
    }

    private static boolean a(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= ((float) view.getWidth()) + f4 && f3 >= f5 && f3 <= ((float) view.getHeight()) + f5;
    }

    public final void f(RecyclerView recyclerView) {
        if (this.mRecyclerView != recyclerView) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.c(this);
                this.mRecyclerView.b(this.aAA);
                RecyclerView recyclerView2 = this.mRecyclerView;
                if (recyclerView2.ass != null) {
                    recyclerView2.ass.remove(this);
                }
                for (int size = this.aAs.size() - 1; size >= 0; size--) {
                    this.aAp.d(this.mRecyclerView, this.aAs.get(0).atw);
                }
                this.aAs.clear();
                this.aAw = null;
                this.aAx = -1;
                np();
                if (this.aAz != null) {
                    this.aAz.aAJ = false;
                    this.aAz = null;
                }
                if (this.aAy != null) {
                    this.aAy = null;
                }
            }
            this.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.aAj = resources.getDimension(R.dimen.a__);
                this.aAk = resources.getDimension(R.dimen.a_9);
                this.awG = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
                this.mRecyclerView.a((RecyclerView.h) this);
                this.mRecyclerView.a(this.aAA);
                this.mRecyclerView.a((RecyclerView.i) this);
                this.aAz = new b();
                this.aAy = new android.support.v4.view.c(this.mRecyclerView.getContext(), this.aAz);
            }
        }
    }

    private void g(float[] fArr) {
        if ((this.aAr & 12) != 0) {
            fArr[0] = (this.aAn + this.aAl) - ((float) this.aAg.aus.getLeft());
        } else {
            fArr[0] = this.aAg.aus.getTranslationX();
        }
        if ((this.aAr & 3) != 0) {
            fArr[1] = (this.aAo + this.aAm) - ((float) this.aAg.aus.getTop());
        } else {
            fArr[1] = this.aAg.aus.getTranslationY();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        boolean z;
        boolean z2 = false;
        if (this.aAg != null) {
            g(this.aAf);
        }
        RecyclerView.v vVar = this.aAg;
        List<c> list = this.aAs;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2);
            int save = canvas.save();
            AbstractC0053a.ns();
            canvas.restoreToCount(save);
        }
        if (vVar != null) {
            int save2 = canvas.save();
            AbstractC0053a.ns();
            canvas.restoreToCount(save2);
        }
        int i3 = size - 1;
        while (i3 >= 0) {
            c cVar = list.get(i3);
            if (cVar.CB && !cVar.aAQ) {
                list.remove(i3);
                z = z2;
            } else if (!cVar.CB) {
                z = true;
            } else {
                z = z2;
            }
            i3--;
            z2 = z;
        }
        if (z2) {
            recyclerView.invalidate();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        float f2;
        float f3;
        this.aAx = -1;
        if (this.aAg != null) {
            g(this.aAf);
            float f4 = this.aAf[0];
            f2 = this.aAf[1];
            f3 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        AbstractC0053a aVar = this.aAp;
        RecyclerView.v vVar = this.aAg;
        List<c> list = this.aAs;
        int i2 = this.aAq;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            c cVar = list.get(i3);
            if (cVar.aAK == cVar.aAM) {
                cVar.mX = cVar.atw.aus.getTranslationX();
            } else {
                cVar.mX = cVar.aAK + (cVar.aAS * (cVar.aAM - cVar.aAK));
            }
            if (cVar.aAL == cVar.aAN) {
                cVar.mY = cVar.atw.aus.getTranslationY();
            } else {
                cVar.mY = cVar.aAL + (cVar.aAS * (cVar.aAN - cVar.aAL));
            }
            int save = canvas.save();
            aVar.a(canvas, recyclerView, cVar.atw, cVar.mX, cVar.mY, cVar.aAq, false);
            canvas.restoreToCount(save);
        }
        if (vVar != null) {
            int save2 = canvas.save();
            aVar.a(canvas, recyclerView, vVar, f3, f2, i2, true);
            canvas.restoreToCount(save2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0144, code lost:
        if (r9 <= 0) goto L_0x0146;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0188  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(android.support.v7.widget.RecyclerView.v r13, int r14) {
        /*
        // Method dump skipped, instructions count: 442
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.a.a.e(android.support.v7.widget.RecyclerView$v, int):void");
    }

    /* access modifiers changed from: package-private */
    public final void L(RecyclerView.v vVar) {
        if (!this.mRecyclerView.isLayoutRequested() && this.aAq == 2) {
            float M = this.aAp.M(vVar);
            int i2 = (int) (this.aAn + this.aAl);
            int i3 = (int) (this.aAo + this.aAm);
            if (((float) Math.abs(i3 - vVar.aus.getTop())) >= ((float) vVar.aus.getHeight()) * M || ((float) Math.abs(i2 - vVar.aus.getLeft())) >= M * ((float) vVar.aus.getWidth())) {
                if (this.aAu == null) {
                    this.aAu = new ArrayList();
                    this.aAv = new ArrayList();
                } else {
                    this.aAu.clear();
                    this.aAv.clear();
                }
                int round = Math.round(this.aAn + this.aAl) + 0;
                int round2 = Math.round(this.aAo + this.aAm) + 0;
                int width = vVar.aus.getWidth() + round + 0;
                int height = vVar.aus.getHeight() + round2 + 0;
                int i4 = (round + width) / 2;
                int i5 = (round2 + height) / 2;
                RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
                int childCount = layoutManager.getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = layoutManager.getChildAt(i6);
                    if (childAt != vVar.aus && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                        RecyclerView.v bi = this.mRecyclerView.bi(childAt);
                        int abs = Math.abs(i4 - ((childAt.getLeft() + childAt.getRight()) / 2));
                        int abs2 = Math.abs(i5 - ((childAt.getBottom() + childAt.getTop()) / 2));
                        int i7 = (abs * abs) + (abs2 * abs2);
                        int i8 = 0;
                        int size = this.aAu.size();
                        int i9 = 0;
                        while (i9 < size && i7 > this.aAv.get(i9).intValue()) {
                            i8++;
                            i9++;
                        }
                        this.aAu.add(i8, bi);
                        this.aAv.add(i8, Integer.valueOf(i7));
                    }
                }
                List<RecyclerView.v> list = this.aAu;
                if (list.size() != 0) {
                    RecyclerView.v a2 = AbstractC0053a.a(vVar, list, i2, i3);
                    if (a2 == null) {
                        this.aAu.clear();
                        this.aAv.clear();
                        return;
                    }
                    int lR = a2.lR();
                    vVar.lR();
                    if (this.aAp.a(this.mRecyclerView, vVar, a2)) {
                        AbstractC0053a.a(this.mRecyclerView, vVar, a2, lR);
                    }
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.i
    public final void bD(View view) {
    }

    @Override // android.support.v7.widget.RecyclerView.i
    public final void bE(View view) {
        bT(view);
        RecyclerView.v bi = this.mRecyclerView.bi(view);
        if (bi != null) {
            if (this.aAg == null || bi != this.aAg) {
                b(bi, false);
                if (this.aAe.remove(bi.aus)) {
                    this.aAp.d(this.mRecyclerView, bi);
                    return;
                }
                return;
            }
            e(null, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(RecyclerView.v vVar, boolean z) {
        for (int size = this.aAs.size() - 1; size >= 0; size--) {
            c cVar = this.aAs.get(size);
            if (cVar.atw == vVar) {
                cVar.aAR |= z;
                if (!cVar.CB) {
                    cVar.aAO.cancel();
                }
                this.aAs.remove(size);
                return;
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        rect.setEmpty();
    }

    public final void no() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    private void np() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, MotionEvent motionEvent, int i3) {
        View m;
        int b2;
        RecyclerView.v vVar = null;
        if (this.aAg == null && i2 == 2 && this.aAq != 2 && this.aAp.nr() && this.mRecyclerView.getScrollState() != 1) {
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (this.mActivePointerId != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.aAh);
                float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.aAi);
                if ((abs >= ((float) this.awG) || abs2 >= ((float) this.awG)) && ((abs <= abs2 || !layoutManager.canScrollHorizontally()) && ((abs2 <= abs || !layoutManager.canScrollVertically()) && (m = m(motionEvent)) != null))) {
                    vVar = this.mRecyclerView.bi(m);
                }
            }
            if (vVar != null && (b2 = (this.aAp.b(this.mRecyclerView, vVar) & 65280) >> 8) != 0) {
                float x = motionEvent.getX(i3);
                float y = motionEvent.getY(i3);
                float f2 = x - this.aAh;
                float f3 = y - this.aAi;
                float abs3 = Math.abs(f2);
                float abs4 = Math.abs(f3);
                if (abs3 >= ((float) this.awG) || abs4 >= ((float) this.awG)) {
                    if (abs3 > abs4) {
                        if (f2 < 0.0f && (b2 & 4) == 0) {
                            return;
                        }
                        if (f2 > 0.0f && (b2 & 8) == 0) {
                            return;
                        }
                    } else if (f3 < 0.0f && (b2 & 1) == 0) {
                        return;
                    } else {
                        if (f3 > 0.0f && (b2 & 2) == 0) {
                            return;
                        }
                    }
                    this.aAm = 0.0f;
                    this.aAl = 0.0f;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    e(vVar, 1);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final View m(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.aAg != null) {
            View view = this.aAg.aus;
            if (a(view, x, y, this.aAn + this.aAl, this.aAo + this.aAm)) {
                return view;
            }
        }
        for (int size = this.aAs.size() - 1; size >= 0; size--) {
            c cVar = this.aAs.get(size);
            View view2 = cVar.atw.aus;
            if (a(view2, x, y, cVar.mX, cVar.mY)) {
                return view2;
            }
        }
        return this.mRecyclerView.o(x, y);
    }

    /* access modifiers changed from: package-private */
    public final void a(MotionEvent motionEvent, int i2, int i3) {
        float x = motionEvent.getX(i3);
        float y = motionEvent.getY(i3);
        this.aAl = x - this.aAh;
        this.aAm = y - this.aAi;
        if ((i2 & 4) == 0) {
            this.aAl = Math.max(0.0f, this.aAl);
        }
        if ((i2 & 8) == 0) {
            this.aAl = Math.min(0.0f, this.aAl);
        }
        if ((i2 & 1) == 0) {
            this.aAm = Math.max(0.0f, this.aAm);
        }
        if ((i2 & 2) == 0) {
            this.aAm = Math.min(0.0f, this.aAm);
        }
    }

    private int cZ(int i2) {
        int i3 = 8;
        if ((i2 & 12) != 0) {
            int i4 = this.aAl > 0.0f ? 8 : 4;
            if (this.mVelocityTracker != null && this.mActivePointerId >= 0) {
                this.mVelocityTracker.computeCurrentVelocity(1000, AbstractC0053a.P(this.aAk));
                float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                if (xVelocity <= 0.0f) {
                    i3 = 4;
                }
                float abs = Math.abs(xVelocity);
                if ((i3 & i2) != 0 && i4 == i3 && abs >= AbstractC0053a.O(this.aAj) && abs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
            float width = ((float) this.mRecyclerView.getWidth()) * 0.5f;
            if ((i2 & i4) != 0 && Math.abs(this.aAl) > width) {
                return i4;
            }
        }
        return 0;
    }

    private int da(int i2) {
        int i3 = 2;
        if ((i2 & 3) != 0) {
            int i4 = this.aAm > 0.0f ? 2 : 1;
            if (this.mVelocityTracker != null && this.mActivePointerId >= 0) {
                this.mVelocityTracker.computeCurrentVelocity(1000, AbstractC0053a.P(this.aAk));
                float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                if (yVelocity <= 0.0f) {
                    i3 = 1;
                }
                float abs = Math.abs(yVelocity);
                if ((i3 & i2) != 0 && i3 == i4 && abs >= AbstractC0053a.O(this.aAj) && abs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
            float height = ((float) this.mRecyclerView.getHeight()) * 0.5f;
            if ((i2 & i4) != 0 && Math.abs(this.aAm) > height) {
                return i4;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void bT(View view) {
        if (view == this.aAw) {
            this.aAw = null;
            if (this.asZ != null) {
                this.mRecyclerView.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* renamed from: android.support.v7.widget.a.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0053a {
        private static final Interpolator aAG = new Interpolator() {
            /* class android.support.v7.widget.a.a.AbstractC0053a.AnonymousClass1 */

            public final float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        };
        private static final Interpolator aAH = new Interpolator() {
            /* class android.support.v7.widget.a.a.AbstractC0053a.AnonymousClass2 */

            public final float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
        private int aAI = -1;

        public abstract void N(RecyclerView.v vVar);

        public abstract int a(RecyclerView recyclerView, RecyclerView.v vVar);

        public abstract boolean a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2);

        public static int aK(int i2, int i3) {
            int i4 = i2 & 789516;
            if (i4 == 0) {
                return i2;
            }
            int i5 = (i4 ^ -1) & i2;
            if (i3 == 0) {
                return i5 | (i4 << 2);
            }
            return i5 | ((i4 << 1) & -789517) | (((i4 << 1) & 789516) << 2);
        }

        public static int db(int i2) {
            return ((i2 | 0) << 0) | 0 | (i2 << 16);
        }

        public static int aL(int i2, int i3) {
            int i4 = i2 & 3158064;
            if (i4 == 0) {
                return i2;
            }
            int i5 = (i4 ^ -1) & i2;
            if (i3 == 0) {
                return i5 | (i4 >> 2);
            }
            return i5 | ((i4 >> 1) & -3158065) | (((i4 >> 1) & 3158064) >> 2);
        }

        /* access modifiers changed from: package-private */
        public final int b(RecyclerView recyclerView, RecyclerView.v vVar) {
            return aL(a(recyclerView, vVar), u.Z(recyclerView));
        }

        public final boolean c(RecyclerView recyclerView, RecyclerView.v vVar) {
            return (b(recyclerView, vVar) & 16711680) != 0;
        }

        public boolean nq() {
            return true;
        }

        public boolean nr() {
            return true;
        }

        public float M(RecyclerView.v vVar) {
            return 0.5f;
        }

        public static float O(float f2) {
            return f2;
        }

        public static float P(float f2) {
            return f2;
        }

        public static RecyclerView.v a(RecyclerView.v vVar, List<RecyclerView.v> list, int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int bottom;
            int top;
            int left;
            int right;
            int width = i2 + vVar.aus.getWidth();
            int height = i3 + vVar.aus.getHeight();
            int i7 = -1;
            int left2 = i2 - vVar.aus.getLeft();
            int top2 = i3 - vVar.aus.getTop();
            int size = list.size();
            int i8 = 0;
            RecyclerView.v vVar2 = null;
            while (i8 < size) {
                RecyclerView.v vVar3 = list.get(i8);
                if (left2 <= 0 || (right = vVar3.aus.getRight() - width) >= 0 || vVar3.aus.getRight() <= vVar.aus.getRight() || (i4 = Math.abs(right)) <= i7) {
                    i4 = i7;
                } else {
                    vVar2 = vVar3;
                }
                if (left2 >= 0 || (left = vVar3.aus.getLeft() - i2) <= 0 || vVar3.aus.getLeft() >= vVar.aus.getLeft() || (i5 = Math.abs(left)) <= i4) {
                    i5 = i4;
                } else {
                    vVar2 = vVar3;
                }
                if (top2 >= 0 || (top = vVar3.aus.getTop() - i3) <= 0 || vVar3.aus.getTop() >= vVar.aus.getTop() || (i6 = Math.abs(top)) <= i5) {
                    i6 = i5;
                } else {
                    vVar2 = vVar3;
                }
                if (top2 <= 0 || (bottom = vVar3.aus.getBottom() - height) >= 0 || vVar3.aus.getBottom() <= vVar.aus.getBottom() || (i7 = Math.abs(bottom)) <= i6) {
                    i7 = i6;
                    vVar3 = vVar2;
                }
                i8++;
                vVar2 = vVar3;
            }
            return vVar2;
        }

        public void f(RecyclerView.v vVar, int i2) {
            if (vVar != null) {
                b bVar = c.aAU;
            }
        }

        private int g(RecyclerView recyclerView) {
            if (this.aAI == -1) {
                this.aAI = recyclerView.getResources().getDimensionPixelSize(R.dimen.a_8);
            }
            return this.aAI;
        }

        public static void a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2, int i2) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof d) {
                ((d) layoutManager).e(vVar.aus, vVar2.aus);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(vVar2.aus) <= recyclerView.getPaddingLeft()) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
                }
                if (layoutManager.getDecoratedRight(vVar2.aus) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a3.axQ(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a3.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(vVar2.aus) <= recyclerView.getPaddingTop()) {
                    com.tencent.mm.hellhoundlib.b.a a4 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a4.axQ(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a4.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
                }
                if (layoutManager.getDecoratedBottom(vVar2.aus) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    com.tencent.mm.hellhoundlib.b.a a5 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a5.axQ(), "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a5.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "android/support/v7/widget/helper/ItemTouchHelper$Callback", "onMoved", "(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILandroid/support/v7/widget/RecyclerView$ViewHolder;III)V", "Undefined", "scrollToPosition", "(I)V");
                }
            }
        }

        public void d(RecyclerView recyclerView, RecyclerView.v vVar) {
            c.aAU.bU(vVar.aus);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z) {
            c.aAU.a(recyclerView, vVar.aus, f2, f3, z);
        }

        public static void ns() {
            b bVar = c.aAU;
        }

        public static long b(RecyclerView recyclerView, int i2) {
            RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i2 == 8 ? 200 : 250;
            }
            if (i2 == 8) {
                return itemAnimator.atp;
            }
            return itemAnimator.ly();
        }

        public final int a(RecyclerView recyclerView, int i2, int i3, long j2) {
            float f2 = 1.0f;
            int g2 = (int) (((float) (g(recyclerView) * ((int) Math.signum((float) i3)))) * aAH.getInterpolation(Math.min(1.0f, (((float) Math.abs(i3)) * 1.0f) / ((float) i2))));
            if (j2 <= 2000) {
                f2 = ((float) j2) / 2000.0f;
            }
            int interpolation = (int) (aAG.getInterpolation(f2) * ((float) g2));
            if (interpolation == 0) {
                return i3 > 0 ? 1 : -1;
            }
            return interpolation;
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        boolean aAJ = true;

        b() {
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            View m;
            RecyclerView.v bi;
            if (this.aAJ && (m = a.this.m(motionEvent)) != null && (bi = a.this.mRecyclerView.bi(m)) != null && a.this.aAp.c(a.this.mRecyclerView, bi) && motionEvent.getPointerId(0) == a.this.mActivePointerId) {
                int findPointerIndex = motionEvent.findPointerIndex(a.this.mActivePointerId);
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                a.this.aAh = x;
                a.this.aAi = y;
                a aVar = a.this;
                a.this.aAm = 0.0f;
                aVar.aAl = 0.0f;
                if (a.this.aAp.nq()) {
                    a.this.e(bi, 2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class c implements Animator.AnimatorListener {
        boolean CB = false;
        final float aAK;
        final float aAL;
        final float aAM;
        final float aAN;
        final ValueAnimator aAO;
        final int aAP;
        boolean aAQ;
        boolean aAR = false;
        float aAS;
        final int aAq;
        final RecyclerView.v atw;
        float mX;
        float mY;

        c(RecyclerView.v vVar, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.aAq = i3;
            this.aAP = i2;
            this.atw = vVar;
            this.aAK = f2;
            this.aAL = f3;
            this.aAM = f4;
            this.aAN = f5;
            this.aAO = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.aAO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class android.support.v7.widget.a.a.c.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c.this.aAS = valueAnimator.getAnimatedFraction();
                }
            });
            this.aAO.setTarget(vVar.aus);
            this.aAO.addListener(this);
            this.aAS = 0.0f;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.CB) {
                this.atw.av(true);
            }
            this.CB = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
            this.aAS = 1.0f;
        }
    }
}
