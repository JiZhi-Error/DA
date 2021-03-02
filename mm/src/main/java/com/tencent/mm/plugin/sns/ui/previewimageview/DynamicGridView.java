package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView extends WrappingGridView {
    private int Ekh = -1;
    private int Eki = -1;
    private BitmapDrawable FbV;
    private Rect FbW;
    private Rect FbX;
    private Rect FbY;
    private int FbZ = 0;
    int FcA = -1;
    float FcB;
    float FcC;
    private float FcD;
    private float FcE;
    private AbsListView.OnScrollListener FcF = new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.AnonymousClass2 */
        private int FcH = -1;
        private int FcI = -1;
        private int FcJ;
        private int FcK;
        private int guU;

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            int i5;
            AppMethodBeat.i(100306);
            this.FcJ = i2;
            this.FcK = i3;
            this.FcH = this.FcH == -1 ? this.FcJ : this.FcH;
            if (this.FcI == -1) {
                i5 = this.FcK;
            } else {
                i5 = this.FcI;
            }
            this.FcI = i5;
            if (!(this.FcJ == this.FcH || !DynamicGridView.this.Fcf || DynamicGridView.this.Fce == -1)) {
                DynamicGridView.a(DynamicGridView.this, DynamicGridView.this.Fce);
                DynamicGridView.p(DynamicGridView.this);
            }
            if (!(this.FcJ + this.FcK == this.FcH + this.FcI || !DynamicGridView.this.Fcf || DynamicGridView.this.Fce == -1)) {
                DynamicGridView.a(DynamicGridView.this, DynamicGridView.this.Fce);
                DynamicGridView.p(DynamicGridView.this);
            }
            this.FcH = this.FcJ;
            this.FcI = this.FcK;
            if (DynamicGridView.fkJ() && DynamicGridView.this.Fcm) {
                for (int i6 = 0; i6 < i3; i6++) {
                    View childAt = DynamicGridView.this.getChildAt(i6);
                    if (childAt != null) {
                        if (DynamicGridView.this.Fce != -1 && Boolean.TRUE != childAt.getTag(R.id.bp0)) {
                            if (i6 % 2 == 0) {
                                DynamicGridView.c(DynamicGridView.this, childAt);
                            } else {
                                DynamicGridView.d(DynamicGridView.this, childAt);
                            }
                            childAt.setTag(R.id.bp0, Boolean.TRUE);
                        } else if (DynamicGridView.this.Fce == -1 && childAt.getRotation() != 0.0f) {
                            childAt.setRotation(0.0f);
                            childAt.setTag(R.id.bp0, Boolean.FALSE);
                        }
                    }
                }
            }
            if (DynamicGridView.this.Fco != null) {
                DynamicGridView.this.Fco.onScroll(absListView, i2, i3, i4);
            }
            AppMethodBeat.o(100306);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(100307);
            this.guU = i2;
            DynamicGridView.this.mScrollState = i2;
            if (this.FcK > 0 && this.guU == 0) {
                if (DynamicGridView.this.Fcf && DynamicGridView.this.Fcg) {
                    DynamicGridView.m(DynamicGridView.this);
                } else if (DynamicGridView.this.Fci) {
                    DynamicGridView.o(DynamicGridView.this);
                }
            }
            if (DynamicGridView.this.Fco != null) {
                DynamicGridView.this.Fco.onScrollStateChanged(absListView, i2);
            }
            AppMethodBeat.o(100307);
        }
    };
    private int Fca = 0;
    private int Fcb = -1;
    private int Fcc = -1;
    private int Fcd;
    private long Fce = -1;
    private boolean Fcf = false;
    private boolean Fcg;
    private int Fch = 0;
    private boolean Fci = false;
    private List<ObjectAnimator> Fcj = new LinkedList();
    boolean Fck;
    boolean Fcl;
    boolean Fcm = true;
    private boolean Fcn = true;
    private AbsListView.OnScrollListener Fco;
    private f Fcp;
    private e Fcq;
    private g Fcr;
    private AdapterView.OnItemClickListener Fcs;
    private AdapterView.OnItemClickListener Fct = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(100305);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (!DynamicGridView.this.rIC && DynamicGridView.this.isEnabled() && DynamicGridView.this.Fcs != null) {
                DynamicGridView.this.Fcs.onItemClick(adapterView, view, i2, j2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100305);
        }
    };
    private boolean Fcu;
    private Stack<a> Fcv;
    private a Fcw;
    private h Fcx;
    private View Fcy;
    d Fcz = new d(this, (byte) 0);
    private List<Long> idList = new ArrayList();
    private int mActivePointerId = -1;
    private int mScrollState = 0;
    boolean rIC = false;

    public interface e {
        void aai(int i2);

        void aaj(int i2);

        void fky();

        void n(Rect rect);

        boolean o(Rect rect);
    }

    public interface f {
        void fkz();
    }

    public interface g {
    }

    public interface h {
    }

    /* access modifiers changed from: package-private */
    public interface j {
        void iW(int i2, int i3);
    }

    static /* synthetic */ void a(DynamicGridView dynamicGridView, long j2) {
        AppMethodBeat.i(100373);
        dynamicGridView.JX(j2);
        AppMethodBeat.o(100373);
    }

    static /* synthetic */ void a(DynamicGridView dynamicGridView, View view) {
        AppMethodBeat.i(100366);
        dynamicGridView.fL(view);
        AppMethodBeat.o(100366);
    }

    static /* synthetic */ void c(DynamicGridView dynamicGridView, View view) {
        AppMethodBeat.i(100369);
        dynamicGridView.fG(view);
        AppMethodBeat.o(100369);
    }

    static /* synthetic */ void d(DynamicGridView dynamicGridView, View view) {
        AppMethodBeat.i(100370);
        dynamicGridView.fH(view);
        AppMethodBeat.o(100370);
    }

    static /* synthetic */ boolean fkJ() {
        AppMethodBeat.i(100368);
        boolean fkF = fkF();
        AppMethodBeat.o(100368);
        return fkF;
    }

    static /* synthetic */ void m(DynamicGridView dynamicGridView) {
        AppMethodBeat.i(100371);
        dynamicGridView.fkC();
        AppMethodBeat.o(100371);
    }

    static /* synthetic */ void o(DynamicGridView dynamicGridView) {
        AppMethodBeat.i(100372);
        dynamicGridView.fkD();
        AppMethodBeat.o(100372);
    }

    static /* synthetic */ void p(DynamicGridView dynamicGridView) {
        AppMethodBeat.i(100374);
        dynamicGridView.fkI();
        AppMethodBeat.o(100374);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter adapter) {
        AppMethodBeat.i(100364);
        setAdapter((ListAdapter) adapter);
        AppMethodBeat.o(100364);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(100329);
        init(context);
        AppMethodBeat.o(100329);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(100330);
        init(context);
        AppMethodBeat.o(100330);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Fco = onScrollListener;
    }

    public void setOnDropListener(f fVar) {
        this.Fcp = fVar;
    }

    public void setOnDragListener(e eVar) {
        this.Fcq = eVar;
    }

    public final void aak(int i2) {
        AppMethodBeat.i(100331);
        if (!this.Fcn) {
            AppMethodBeat.o(100331);
            return;
        }
        requestDisallowInterceptTouchEvent(true);
        if (fkF() && this.Fcm) {
            fkA();
        }
        if (i2 != -1) {
            this.rIC = aal(i2);
            if (this.rIC) {
                this.Fcf = true;
            }
        }
        AppMethodBeat.o(100331);
    }

    public void setEditModeEnabled(boolean z) {
        this.Fcn = z;
    }

    public void setOnEditModeChangeListener(g gVar) {
        this.Fcr = gVar;
    }

    public void setWobbleInEditMode(boolean z) {
        this.Fcm = z;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        AppMethodBeat.i(100332);
        this.Fcs = onItemClickListener;
        super.setOnItemClickListener(this.Fct);
        AppMethodBeat.o(100332);
    }

    public void setUndoSupportEnabled(boolean z) {
        AppMethodBeat.i(100333);
        if (this.Fcu != z) {
            if (z) {
                this.Fcv = new Stack<>();
            } else {
                this.Fcv = null;
            }
        }
        this.Fcu = z;
        AppMethodBeat.o(100333);
    }

    public void setOnSelectedItemBitmapCreationListener(h hVar) {
        this.Fcx = hVar;
    }

    @TargetApi(11)
    private void fkA() {
        AppMethodBeat.i(100334);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt == null || Boolean.TRUE == childAt.getTag(R.id.bp0))) {
                if (i2 % 2 == 0) {
                    fG(childAt);
                } else {
                    fH(childAt);
                }
                childAt.setTag(R.id.bp0, Boolean.TRUE);
            }
        }
        AppMethodBeat.o(100334);
    }

    /* access modifiers changed from: package-private */
    @TargetApi(11)
    public final void vE(boolean z) {
        AppMethodBeat.i(100335);
        for (ObjectAnimator objectAnimator : this.Fcj) {
            objectAnimator.cancel();
        }
        this.Fcj.clear();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                if (z) {
                    childAt.setRotation(0.0f);
                }
                childAt.setTag(R.id.bp0, Boolean.FALSE);
            }
        }
        AppMethodBeat.o(100335);
    }

    private void init(Context context) {
        AppMethodBeat.i(100336);
        super.setOnScrollListener(this.FcF);
        this.Fch = (int) ((context.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        this.Fcd = getResources().getDimensionPixelSize(R.dimen.a00);
        AppMethodBeat.o(100336);
    }

    @TargetApi(11)
    private void fG(View view) {
        AppMethodBeat.i(100337);
        ObjectAnimator fI = fI(view);
        fI.setFloatValues(-2.0f, 2.0f);
        fI.start();
        this.Fcj.add(fI);
        AppMethodBeat.o(100337);
    }

    @TargetApi(11)
    private void fH(View view) {
        AppMethodBeat.i(100338);
        ObjectAnimator fI = fI(view);
        fI.setFloatValues(2.0f, -2.0f);
        fI.start();
        this.Fcj.add(fI);
        AppMethodBeat.o(100338);
    }

    @TargetApi(11)
    private ObjectAnimator fI(final View view) {
        AppMethodBeat.i(100339);
        if (!fkG()) {
            view.setLayerType(1, null);
        }
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setDuration(180L);
        objectAnimator.setRepeatMode(2);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setPropertyName("rotation");
        objectAnimator.setTarget(view);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.AnonymousClass3 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(100308);
                view.setLayerType(0, null);
                AppMethodBeat.o(100308);
            }
        });
        AppMethodBeat.o(100339);
        return objectAnimator;
    }

    private void iU(int i2, int i3) {
        AppMethodBeat.i(100340);
        getAdapterInterface().iT(i2, i3);
        AppMethodBeat.o(100340);
    }

    private int getColumnCount() {
        AppMethodBeat.i(100341);
        int columnCount = getAdapterInterface().getColumnCount();
        AppMethodBeat.o(100341);
        return columnCount;
    }

    private d getAdapterInterface() {
        AppMethodBeat.i(100342);
        d dVar = (d) getAdapter();
        AppMethodBeat.o(100342);
        return dVar;
    }

    private BitmapDrawable fJ(View view) {
        AppMethodBeat.i(100343);
        int width = view.getWidth();
        int height = view.getHeight();
        int top = view.getTop();
        int left = view.getLeft();
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), createBitmap);
        this.FbX = new Rect(left, top, left + width, top + height);
        this.FbW = new Rect(this.FbX.left - ((int) (((float) width) * 0.05f)), this.FbX.top - ((int) (((float) height) * 0.05f)), ((int) (((float) width) * 0.05f)) + this.FbX.right, ((int) (((float) height) * 0.05f)) + this.FbX.bottom);
        this.FbY = new Rect(this.FbW);
        bitmapDrawable.setBounds(this.FbX);
        AppMethodBeat.o(100343);
        return bitmapDrawable;
    }

    private void JX(long j2) {
        AppMethodBeat.i(100344);
        this.idList.clear();
        int JY = JY(j2);
        for (int firstVisiblePosition = getFirstVisiblePosition(); firstVisiblePosition <= getLastVisiblePosition(); firstVisiblePosition++) {
            if (JY != firstVisiblePosition && getAdapterInterface().aag(firstVisiblePosition)) {
                this.idList.add(Long.valueOf(aam(firstVisiblePosition)));
            }
        }
        AppMethodBeat.o(100344);
    }

    public final int JY(long j2) {
        AppMethodBeat.i(100345);
        View JZ = JZ(j2);
        if (JZ == null) {
            AppMethodBeat.o(100345);
            return -1;
        }
        int positionForView = getPositionForView(JZ);
        AppMethodBeat.o(100345);
        return positionForView;
    }

    public final View JZ(long j2) {
        AppMethodBeat.i(100346);
        int firstVisiblePosition = getFirstVisiblePosition();
        ListAdapter adapter = getAdapter();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (adapter.getItemId(firstVisiblePosition + i2) == j2) {
                AppMethodBeat.o(100346);
                return childAt;
            }
        }
        AppMethodBeat.o(100346);
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(100347);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        new StringBuilder("onInterceptTouchEvent ").append(motionEvent.getAction()).append(" ").append(onInterceptTouchEvent);
        AppMethodBeat.o(100347);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(100348);
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        new StringBuilder("onTouchEvent ").append(motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.FcB = motionEvent.getX();
                this.FcC = motionEvent.getY();
                this.FcA = f.a(this, motionEvent.getX(), motionEvent.getY());
                new StringBuilder("onTouchEvent ").append(motionEvent.getAction()).append(",downPos ").append(this.FcA);
                if (!this.Fck && this.FcA >= 0) {
                    d dVar = this.Fcz;
                    dVar.removeMessages(1);
                    dVar.sendEmptyMessageDelayed(1, 300);
                }
                this.Fcb = -1;
                this.Fcc = -1;
                this.Ekh = (int) motionEvent.getX();
                this.Eki = (int) motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                if (this.rIC && isEnabled()) {
                    layoutChildren();
                    aal(pointToPosition(this.Ekh, this.Eki));
                    break;
                } else if (!isEnabled()) {
                    AppMethodBeat.o(100348);
                    return false;
                }
                break;
            case 1:
                fkD();
                if (this.Fcu && this.Fcw != null) {
                    a aVar = this.Fcw;
                    Collections.reverse(aVar.FcM);
                    if (!aVar.FcM.isEmpty()) {
                        this.Fcv.push(this.Fcw);
                        this.Fcw = new a();
                        break;
                    }
                }
                break;
            case 2:
                this.FcB = motionEvent.getX();
                this.FcC = motionEvent.getY();
                if (!(!this.Fcf || this.mActivePointerId == -1 || findPointerIndex == -1)) {
                    if (this.Fcc == -1 && this.Fcb == -1) {
                        this.Fcb = (int) motionEvent.getY(findPointerIndex);
                        this.Fcc = (int) motionEvent.getX(findPointerIndex);
                        this.Ekh = this.Fcc;
                        this.Eki = this.Fcb;
                        break;
                    } else {
                        this.FcD = motionEvent.getRawX();
                        this.FcE = motionEvent.getRawY();
                        this.Fcb = (int) motionEvent.getY(findPointerIndex);
                        this.Fcc = (int) motionEvent.getX(findPointerIndex);
                        int i2 = this.Fcb - this.Eki;
                        this.FbW.offsetTo((this.Fcc - this.Ekh) + this.FbY.left + this.Fca, i2 + this.FbY.top + this.FbZ);
                        if (this.FbV != null) {
                            this.FbV.setBounds(this.FbW);
                        }
                        invalidate();
                        fkI();
                        this.Fcg = false;
                        fkC();
                        if (this.Fcq != null) {
                            Rect rect = new Rect(this.FbW);
                            rect.offset(0, this.FbW.height() >>> 1);
                            this.Fcq.n(rect);
                        }
                        AppMethodBeat.o(100348);
                        return false;
                    }
                }
                break;
            case 3:
                fkH();
                fkD();
                break;
            case 6:
                if (motionEvent.getPointerId((motionEvent.getAction() & 65280) >> 8) == this.mActivePointerId) {
                    fkD();
                    break;
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(100348);
        return onTouchEvent;
    }

    private boolean fkB() {
        int i2;
        j cVar;
        AppMethodBeat.i(100349);
        int JY = JY(this.Fce);
        if (JY != -1) {
            this.Fcq.aaj(JY);
            if (this.Fcy == null) {
                AppMethodBeat.o(100349);
                return false;
            }
            try {
                i2 = getPositionForView(this.Fcy);
            } catch (NullPointerException e2) {
                new StringBuilder("NullPointerException: ").append(e2.getMessage());
                i2 = -1;
            }
            int childCount = getChildCount() - 1;
            new StringBuilder("switch ").append(i2).append(",").append(childCount);
            if (i2 == -1) {
                AppMethodBeat.o(100349);
                return false;
            }
            iU(i2, childCount);
            if (this.Fcu) {
                this.Fcw.iV(i2, childCount);
            }
            this.Eki = this.Fcb;
            this.Ekh = this.Fcc;
            if (fkF() && fkG()) {
                cVar = new b(0, 0);
            } else if (fkG()) {
                cVar = new i(0, 0);
            } else {
                cVar = new c(0, 0);
            }
            JX(this.Fce);
            cVar.iW(i2, childCount);
            AppMethodBeat.o(100349);
            return true;
        }
        AppMethodBeat.o(100349);
        return false;
    }

    private boolean aal(int i2) {
        AppMethodBeat.i(100350);
        if (!getAdapterInterface().aaf(i2)) {
            AppMethodBeat.o(100350);
            return false;
        }
        this.FbZ = 0;
        this.Fca = 0;
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        if (childAt != null) {
            this.Fce = getAdapter().getItemId(i2);
            this.FbV = fJ(childAt);
            fkE();
            if (fkF()) {
                childAt.setVisibility(4);
            }
            JX(this.Fce);
            if (this.Fcq != null) {
                this.Fcq.aai(i2);
            }
            AppMethodBeat.o(100350);
            return true;
        }
        AppMethodBeat.o(100350);
        return false;
    }

    private void fkC() {
        AppMethodBeat.i(100351);
        this.Fcg = p(this.FbW);
        AppMethodBeat.o(100351);
    }

    private boolean p(Rect rect) {
        AppMethodBeat.i(100352);
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i2 = rect.top;
        int height2 = rect.height();
        if (i2 <= 0 && computeVerticalScrollOffset > 0) {
            smoothScrollBy(-this.Fch, 0);
            AppMethodBeat.o(100352);
            return true;
        } else if (i2 + height2 < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            AppMethodBeat.o(100352);
            return false;
        } else {
            smoothScrollBy(this.Fch, 0);
            AppMethodBeat.o(100352);
            return true;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(100353);
        super.setAdapter(listAdapter);
        AppMethodBeat.o(100353);
    }

    private void fkD() {
        Rect rect;
        AppMethodBeat.i(100354);
        this.Fcz.removeMessages(1);
        View JZ = JZ(this.Fce);
        if (this.FbW != null) {
            rect = new Rect(this.FbW);
            rect.offset(0, this.FbW.height() >>> 1);
        } else {
            rect = null;
        }
        if (this.Fcq != null && this.Fcq.o(rect) && fkB()) {
            this.FbV = null;
            fkH();
            if (this.Fcp != null) {
                this.Fcp.fkz();
            }
        } else if (JZ == null || (!this.Fcf && !this.Fci)) {
            fkH();
        } else {
            this.Fcf = false;
            this.Fci = false;
            this.Fcg = false;
            this.mActivePointerId = -1;
            this.FbW.set(JZ.getLeft(), JZ.getTop(), JZ.getRight(), JZ.getBottom());
            new StringBuilder("animating to  ").append(this.FbW);
            if (Build.VERSION.SDK_INT > 11) {
                fK(JZ);
            } else {
                this.FbV.setBounds(this.FbW);
                invalidate();
                fL(JZ);
            }
        }
        if (this.Fcq != null) {
            this.Fcq.fky();
        }
        AppMethodBeat.o(100354);
    }

    @TargetApi(11)
    private void fkE() {
        AppMethodBeat.i(100355);
        AnonymousClass4 r0 = new TypeEvaluator<Rect>() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
            @Override // android.animation.TypeEvaluator
            public final /* synthetic */ Rect evaluate(float f2, Rect rect, Rect rect2) {
                AppMethodBeat.i(100309);
                Rect rect3 = rect;
                Rect rect4 = rect2;
                Rect rect5 = new Rect(f(rect3.left, rect4.left, f2), f(rect3.top, rect4.top, f2), f(rect3.right, rect4.right, f2), f(rect3.bottom, rect4.bottom, f2));
                AppMethodBeat.o(100309);
                return rect5;
            }

            private static int f(int i2, int i3, float f2) {
                return (int) (((float) i2) + (((float) (i3 - i2)) * f2));
            }
        };
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.FbV, "bounds", r0, this.FbW);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.AnonymousClass5 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(100310);
                DynamicGridView.this.invalidate();
                AppMethodBeat.o(100310);
            }
        });
        ofObject.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.AnonymousClass6 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(100311);
                DynamicGridView.this.Fck = true;
                DynamicGridView.b(DynamicGridView.this);
                AppMethodBeat.o(100311);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(100312);
                DynamicGridView.this.Fck = false;
                DynamicGridView.b(DynamicGridView.this);
                AppMethodBeat.o(100312);
            }
        });
        ofObject.setDuration(10L);
        ofObject.start();
        AppMethodBeat.o(100355);
    }

    @TargetApi(11)
    private void fK(final View view) {
        AppMethodBeat.i(100356);
        AnonymousClass7 r0 = new TypeEvaluator<Rect>() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.AnonymousClass7 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
            @Override // android.animation.TypeEvaluator
            public final /* synthetic */ Rect evaluate(float f2, Rect rect, Rect rect2) {
                AppMethodBeat.i(100313);
                Rect rect3 = rect;
                Rect rect4 = rect2;
                Rect rect5 = new Rect(f(rect3.left, rect4.left, f2), f(rect3.top, rect4.top, f2), f(rect3.right, rect4.right, f2), f(rect3.bottom, rect4.bottom, f2));
                AppMethodBeat.o(100313);
                return rect5;
            }

            private static int f(int i2, int i3, float f2) {
                return (int) (((float) i2) + (((float) (i3 - i2)) * f2));
            }
        };
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.FbV, "bounds", r0, this.FbW);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.AnonymousClass8 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(100314);
                DynamicGridView.this.invalidate();
                AppMethodBeat.o(100314);
            }
        });
        ofObject.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.AnonymousClass9 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(100315);
                DynamicGridView.this.Fck = true;
                DynamicGridView.b(DynamicGridView.this);
                AppMethodBeat.o(100315);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(100316);
                DynamicGridView.this.Fck = false;
                DynamicGridView.b(DynamicGridView.this);
                if (!(DynamicGridView.this.FbV == null || DynamicGridView.this.Fcp == null)) {
                    DynamicGridView.this.Fcp.fkz();
                }
                DynamicGridView.a(DynamicGridView.this, view);
                AppMethodBeat.o(100316);
            }
        });
        ofObject.setDuration(200L);
        ofObject.start();
        AppMethodBeat.o(100356);
    }

    private void fL(View view) {
        AppMethodBeat.i(100357);
        this.idList.clear();
        this.Fce = -1;
        view.setVisibility(0);
        this.FbV = null;
        if (fkF() && this.Fcm) {
            if (this.rIC) {
                vE(false);
                fkA();
            } else {
                vE(true);
            }
        }
        for (int i2 = 0; i2 < getLastVisiblePosition() - getFirstVisiblePosition(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                childAt.setVisibility(0);
            }
        }
        invalidate();
        AppMethodBeat.o(100357);
    }

    static boolean fkF() {
        return Build.VERSION.SDK_INT >= 11;
    }

    private static boolean fkG() {
        return Build.VERSION.SDK_INT < 21;
    }

    private void fkH() {
        AppMethodBeat.i(100358);
        View JZ = JZ(this.Fce);
        if (JZ == null) {
            AppMethodBeat.o(100358);
            return;
        }
        if (this.Fcf) {
            fL(JZ);
        }
        this.Fcf = false;
        this.Fcg = false;
        this.mActivePointerId = -1;
        AppMethodBeat.o(100358);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x012e, code lost:
        if (r9 < (r5.getRight() - r14.Fcd)) goto L_0x0130;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fkI() {
        /*
        // Method dump skipped, instructions count: 508
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.fkI():void");
    }

    /* access modifiers changed from: package-private */
    public class i implements j {
        private int Bi;
        private int Bj;

        public i(int i2, int i3) {
            this.Bi = i2;
            this.Bj = i3;
        }

        @Override // com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.j
        public final void iW(int i2, int i3) {
            AppMethodBeat.i(100328);
            DynamicGridView.this.FbZ += this.Bj;
            DynamicGridView.this.Fca += this.Bi;
            AppMethodBeat.o(100328);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements j {
        static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
        private int Bi;
        private int Bj;

        static {
            AppMethodBeat.i(100323);
            AppMethodBeat.o(100323);
        }

        public b(int i2, int i3) {
            this.Bi = i2;
            this.Bj = i3;
        }

        @Override // com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.j
        public final void iW(int i2, int i3) {
            AppMethodBeat.i(100322);
            if ($assertionsDisabled || DynamicGridView.this.Fcy != null) {
                DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.this.Fcy, i2, i3));
                DynamicGridView.this.Fcy = DynamicGridView.this.JZ(DynamicGridView.this.Fce);
                AppMethodBeat.o(100322);
                return;
            }
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(100322);
            throw assertionError;
        }

        class a implements ViewTreeObserver.OnPreDrawListener {
            private final View FcN;
            private final int FcO;
            private final int atO;

            a(View view, int i2, int i3) {
                this.FcN = view;
                this.FcO = i2;
                this.atO = i3;
            }

            public final boolean onPreDraw() {
                AppMethodBeat.i(100321);
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                DynamicGridView.this.FbZ += b.this.Bj;
                DynamicGridView.this.Fca += b.this.Bi;
                DynamicGridView.a(DynamicGridView.this, this.FcO, this.atO);
                this.FcN.setVisibility(0);
                if (DynamicGridView.this.Fcy != null) {
                    DynamicGridView.this.Fcy.setVisibility(4);
                }
                AppMethodBeat.o(100321);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements j {
        int Bi;
        int Bj;

        public c(int i2, int i3) {
            this.Bi = i2;
            this.Bj = i3;
        }

        @Override // com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.j
        public final void iW(int i2, int i3) {
            AppMethodBeat.i(100326);
            DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(i2, i3));
            AppMethodBeat.o(100326);
        }

        class a implements ViewTreeObserver.OnPreDrawListener {
            static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
            private final int FcO;
            private final int atO;

            static {
                AppMethodBeat.i(100325);
                AppMethodBeat.o(100325);
            }

            a(int i2, int i3) {
                this.FcO = i2;
                this.atO = i3;
            }

            public final boolean onPreDraw() {
                AppMethodBeat.i(100324);
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                DynamicGridView.this.FbZ += c.this.Bj;
                DynamicGridView.this.Fca += c.this.Bi;
                DynamicGridView.a(DynamicGridView.this, this.FcO, this.atO);
                new StringBuilder("id ").append(DynamicGridView.this.JY(DynamicGridView.this.Fce));
                if (DynamicGridView.this.Fcy == null) {
                    AppMethodBeat.o(100324);
                } else if (DynamicGridView.this.Fcy == null) {
                    AppMethodBeat.o(100324);
                } else if ($assertionsDisabled || DynamicGridView.this.Fcy != null) {
                    DynamicGridView.this.Fcy.setVisibility(0);
                    DynamicGridView.this.Fcy = DynamicGridView.this.JZ(DynamicGridView.this.Fce);
                    if (DynamicGridView.this.Fcy == null) {
                        AppMethodBeat.o(100324);
                    } else if ($assertionsDisabled || DynamicGridView.this.Fcy != null) {
                        DynamicGridView.this.Fcy.setVisibility(4);
                        AppMethodBeat.o(100324);
                    } else {
                        AssertionError assertionError = new AssertionError();
                        AppMethodBeat.o(100324);
                        throw assertionError;
                    }
                } else {
                    AssertionError assertionError2 = new AssertionError();
                    AppMethodBeat.o(100324);
                    throw assertionError2;
                }
                return true;
            }
        }
    }

    private Point fM(View view) {
        AppMethodBeat.i(100360);
        int positionForView = getPositionForView(view);
        int columnCount = getColumnCount();
        Point point = new Point(positionForView % columnCount, positionForView / columnCount);
        AppMethodBeat.o(100360);
        return point;
    }

    private long aam(int i2) {
        AppMethodBeat.i(100361);
        long itemId = getAdapter().getItemId(i2);
        AppMethodBeat.o(100361);
        return itemId;
    }

    @TargetApi(11)
    private static AnimatorSet g(View view, float f2, float f3) {
        AppMethodBeat.i(100362);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f2, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", f3, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        AppMethodBeat.o(100362);
        return animatorSet;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(100363);
        super.dispatchDraw(canvas);
        if (this.FbV != null) {
            this.FbV.draw(canvas);
        }
        AppMethodBeat.o(100363);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        List<Pair<Integer, Integer>> FcM = new Stack();

        a() {
            AppMethodBeat.i(100319);
            AppMethodBeat.o(100319);
        }

        public final void iV(int i2, int i3) {
            AppMethodBeat.i(100320);
            this.FcM.add(new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3)));
            AppMethodBeat.o(100320);
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends Handler {
        private d() {
        }

        /* synthetic */ d(DynamicGridView dynamicGridView, byte b2) {
            this();
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(100327);
            switch (message.what) {
                case 1:
                    DynamicGridView dynamicGridView = DynamicGridView.this;
                    View childAt = dynamicGridView.getChildAt(dynamicGridView.FcA);
                    new StringBuilder("downView ").append(childAt).append(",downPos ").append(dynamicGridView.FcA).append(",lastTouchX ").append(dynamicGridView.FcB).append(",lastTouchY ").append(dynamicGridView.FcC);
                    if (!dynamicGridView.Fck && !dynamicGridView.Fcl && f.f(childAt, dynamicGridView.FcB, dynamicGridView.FcC)) {
                        dynamicGridView.aak(dynamicGridView.FcA);
                        break;
                    }
            }
            AppMethodBeat.o(100327);
        }
    }

    static /* synthetic */ void b(DynamicGridView dynamicGridView) {
        boolean z;
        AppMethodBeat.i(100365);
        if (dynamicGridView.Fck || dynamicGridView.Fcl) {
            z = false;
        } else {
            z = true;
        }
        dynamicGridView.setEnabled(z);
        AppMethodBeat.o(100365);
    }

    static /* synthetic */ void a(DynamicGridView dynamicGridView, int i2, int i3) {
        AppMethodBeat.i(100367);
        boolean z = i3 > i2;
        LinkedList linkedList = new LinkedList();
        if (z) {
            for (int min = Math.min(i2, i3); min < Math.max(i2, i3); min++) {
                View JZ = dynamicGridView.JZ(dynamicGridView.aam(min));
                if ((min + 1) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(g(JZ, (float) ((-JZ.getWidth()) * (dynamicGridView.getColumnCount() - 1)), (float) JZ.getHeight()));
                } else {
                    linkedList.add(g(JZ, (float) JZ.getWidth(), 0.0f));
                }
            }
        } else {
            for (int max = Math.max(i2, i3); max > Math.min(i2, i3); max--) {
                View JZ2 = dynamicGridView.JZ(dynamicGridView.aam(max));
                if ((dynamicGridView.getColumnCount() + max) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(g(JZ2, (float) (JZ2.getWidth() * (dynamicGridView.getColumnCount() - 1)), (float) (-JZ2.getHeight())));
                } else {
                    linkedList.add(g(JZ2, (float) (-JZ2.getWidth()), 0.0f));
                }
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(linkedList);
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.AnonymousClass10 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(100317);
                DynamicGridView.this.Fcl = true;
                DynamicGridView.b(DynamicGridView.this);
                AppMethodBeat.o(100317);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(100318);
                DynamicGridView.this.Fcl = false;
                DynamicGridView.b(DynamicGridView.this);
                AppMethodBeat.o(100318);
            }
        });
        animatorSet.start();
        AppMethodBeat.o(100367);
    }
}
