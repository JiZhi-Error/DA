package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a;
import com.tencent.mm.ui.as;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView extends ListView {
    private float QWA = 0.33333334f;
    private float QWB = 0.33333334f;
    private int QWC;
    private int QWD;
    private float QWE;
    private float QWF;
    private float QWG;
    private float QWH;
    private float QWI = 0.5f;
    private c QWJ = new c() {
        /* class com.tencent.mm.ui.widget.sortlist.DragSortListView.AnonymousClass1 */

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.c
        public final float cD(float f2) {
            AppMethodBeat.i(159754);
            float f3 = DragSortListView.this.QWI * f2;
            AppMethodBeat.o(159754);
            return f3;
        }
    };
    private int QWK;
    private int QWL = 0;
    private boolean QWM = false;
    boolean QWN = false;
    i QWO = null;
    private MotionEvent QWP;
    private int QWQ = 0;
    private float QWR = 0.25f;
    private float QWS = 0.0f;
    private a QWT;
    private boolean QWU = false;
    private f QWV;
    private boolean QWW = false;
    private boolean QWX = false;
    private j QWY = new j(this, (byte) 0);
    private k QWZ;
    private Point QWd = new Point();
    private Point QWe = new Point();
    private int QWf;
    private boolean QWg = false;
    private float QWh = 1.0f;
    private float QWi = 1.0f;
    private int QWj;
    private int QWk;
    private int QWl;
    private boolean QWm = false;
    private int QWn;
    private int QWo;
    private int QWp;
    private b QWq;
    private h QWr;
    private l QWs;
    boolean QWt = true;
    private int QWu = 1;
    private int QWv;
    private int QWw;
    private int QWx = 0;
    private View[] QWy = new View[1];
    private d QWz;
    private g QXa;
    private boolean QXb;
    private float QXc = 0.0f;
    boolean QXd = false;
    private boolean QXe = false;
    private int Wx = 0;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private int nrK;
    private int nrL;
    private View ooN;

    public interface b {
    }

    public interface c {
        float cD(float f2);
    }

    public interface e extends b, h, l {
    }

    public interface h {
        void ey(int i2, int i3);
    }

    public interface i {
        View apz(int i2);

        void hA(View view);

        void n(Point point);
    }

    public interface l {
        void remove(int i2);
    }

    static /* synthetic */ void a(DragSortListView dragSortListView, int i2, View view) {
        AppMethodBeat.i(159832);
        dragSortListView.a(i2, view, true);
        AppMethodBeat.o(159832);
    }

    static /* synthetic */ int b(DragSortListView dragSortListView, int i2, View view) {
        AppMethodBeat.i(159836);
        int b2 = dragSortListView.b(i2, view, false);
        AppMethodBeat.o(159836);
        return b2;
    }

    static /* synthetic */ void c(DragSortListView dragSortListView, int i2, View view) {
        AppMethodBeat.i(159838);
        dragSortListView.d(i2, view, false);
        AppMethodBeat.o(159838);
    }

    static /* synthetic */ void f(DragSortListView dragSortListView) {
        AppMethodBeat.i(159833);
        dragSortListView.hcK();
        AppMethodBeat.o(159833);
    }

    static /* synthetic */ void k(DragSortListView dragSortListView) {
        AppMethodBeat.i(159834);
        dragSortListView.hcE();
        AppMethodBeat.o(159834);
    }

    static /* synthetic */ void p(DragSortListView dragSortListView) {
        AppMethodBeat.i(159835);
        dragSortListView.hcM();
        AppMethodBeat.o(159835);
    }

    @Override // android.widget.AbsListView, android.widget.ListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter adapter) {
        AppMethodBeat.i(159831);
        setAdapter((ListAdapter) adapter);
        AppMethodBeat.o(159831);
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159791);
        int i2 = 150;
        int i3 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0296a.DragSortListView, 0, 0);
            this.QWu = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(1, 1));
            this.QWU = obtainStyledAttributes.getBoolean(16, false);
            if (this.QWU) {
                this.QWV = new f();
            }
            this.QWh = obtainStyledAttributes.getFloat(8, this.QWh);
            this.QWi = this.QWh;
            this.QWt = obtainStyledAttributes.getBoolean(2, this.QWt);
            this.QWR = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(14, 0.75f)));
            this.QWm = this.QWR > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(4, this.QWA));
            this.QWI = obtainStyledAttributes.getFloat(10, this.QWI);
            int i4 = obtainStyledAttributes.getInt(11, 150);
            int i5 = obtainStyledAttributes.getInt(6, 150);
            if (obtainStyledAttributes.getBoolean(17, true)) {
                boolean z = obtainStyledAttributes.getBoolean(12, false);
                int i6 = obtainStyledAttributes.getInt(13, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(15, true);
                int i7 = obtainStyledAttributes.getInt(5, 0);
                int resourceId = obtainStyledAttributes.getResourceId(3, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(7, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(0, 0);
                int color = obtainStyledAttributes.getColor(9, WebView.NIGHT_MODE_COLOR);
                a aVar = new a(this, resourceId, i7, i6, resourceId3, resourceId2);
                aVar.QVM = z;
                aVar.QVL = z2;
                aVar.QXK = color;
                this.QWO = aVar;
                setOnTouchListener(aVar);
            }
            obtainStyledAttributes.recycle();
            i3 = i5;
            i2 = i4;
        }
        this.QWz = new d();
        if (i2 > 0) {
            this.QWZ = new k(this, i2, (byte) 0);
        }
        if (i3 > 0) {
            this.QXa = new g(this, i3, (byte) 0);
        }
        this.QWP = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mObserver = new DataSetObserver() {
            /* class com.tencent.mm.ui.widget.sortlist.DragSortListView.AnonymousClass2 */

            private void cancel() {
                AppMethodBeat.i(159755);
                if (DragSortListView.this.Wx == 4) {
                    DragSortListView.this.hcC();
                }
                AppMethodBeat.o(159755);
            }

            public final void onChanged() {
                AppMethodBeat.i(159756);
                cancel();
                AppMethodBeat.o(159756);
            }

            public final void onInvalidated() {
                AppMethodBeat.i(159757);
                cancel();
                AppMethodBeat.o(159757);
            }
        };
        AppMethodBeat.o(159791);
    }

    public float getFloatAlpha() {
        return this.QWi;
    }

    public void setFloatAlpha(float f2) {
        this.QWi = f2;
    }

    public void setMaxScrollSpeed(float f2) {
        this.QWI = f2;
    }

    @Override // android.widget.AbsListView, android.widget.ListView
    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(159792);
        if (listAdapter != null) {
            this.QWT = new a(this, listAdapter, (byte) 0);
            listAdapter.registerDataSetObserver(this.mObserver);
            if (listAdapter instanceof h) {
                setDropListener((h) listAdapter);
            }
            if (listAdapter instanceof b) {
                setDragListener((b) listAdapter);
            }
            if (listAdapter instanceof l) {
                setRemoveListener((l) listAdapter);
            }
        } else {
            this.QWT = null;
        }
        super.setAdapter((ListAdapter) this.QWT);
        AppMethodBeat.o(159792);
    }

    public ListAdapter getInputAdapter() {
        if (this.QWT == null) {
            return null;
        }
        return this.QWT.GO;
    }

    private void a(int i2, Canvas canvas) {
        ViewGroup viewGroup;
        int bottom;
        int i3;
        AppMethodBeat.i(159793);
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (!(divider == null || dividerHeight == 0 || (viewGroup = (ViewGroup) getChildAt(i2 - getFirstVisiblePosition())) == null)) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int height = viewGroup.getChildAt(0).getHeight();
            if (i2 > this.QWn) {
                i3 = height + viewGroup.getTop();
                bottom = i3 + dividerHeight;
            } else {
                bottom = viewGroup.getBottom() - height;
                i3 = bottom - dividerHeight;
            }
            canvas.save();
            canvas.clipRect(paddingLeft, i3, width, bottom);
            divider.setBounds(paddingLeft, i3, width, bottom);
            divider.draw(canvas);
            canvas.restore();
        }
        AppMethodBeat.o(159793);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        float f2;
        AppMethodBeat.i(159794);
        super.dispatchDraw(canvas);
        if (this.Wx != 0) {
            if (this.QWk != this.QWn) {
                a(this.QWk, canvas);
            }
            if (!(this.QWl == this.QWk || this.QWl == this.QWn)) {
                a(this.QWl, canvas);
            }
        }
        if (this.ooN != null) {
            int width = this.ooN.getWidth();
            int height = this.ooN.getHeight();
            int i2 = this.QWd.x;
            int width2 = getWidth();
            if (i2 < 0) {
                i2 = -i2;
            }
            if (i2 < width2) {
                float f3 = ((float) (width2 - i2)) / ((float) width2);
                f2 = f3 * f3;
            } else {
                f2 = 0.0f;
            }
            int i3 = (int) (f2 * 255.0f * this.QWi);
            canvas.save();
            canvas.translate((float) this.QWd.x, (float) this.QWd.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) width, (float) height, i3, 31);
            this.ooN.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
        AppMethodBeat.o(159794);
    }

    private int apv(int i2) {
        AppMethodBeat.i(159795);
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        if (childAt != null) {
            int height = childAt.getHeight();
            AppMethodBeat.o(159795);
            return height;
        }
        int lO = lO(i2, apx(i2));
        AppMethodBeat.o(159795);
        return lO;
    }

    private int lN(int i2, int i3) {
        int i4;
        AppMethodBeat.i(159796);
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= getCount() - footerViewsCount) {
            AppMethodBeat.o(159796);
            return i3;
        }
        int dividerHeight = getDividerHeight();
        int i5 = this.QWv - this.QWu;
        int apx = apx(i2);
        int apv = apv(i2);
        if (this.QWl <= this.QWn) {
            if (i2 != this.QWl || this.QWk == this.QWl) {
                if (i2 > this.QWl && i2 <= this.QWn) {
                    i3 -= i5;
                }
            } else if (i2 == this.QWn) {
                i3 = (i3 + apv) - this.QWv;
            } else {
                i3 = ((apv - apx) + i3) - i5;
            }
        } else if (i2 > this.QWn && i2 <= this.QWk) {
            i3 += i5;
        } else if (i2 == this.QWl && this.QWk != this.QWl) {
            i3 += apv - apx;
        }
        if (i2 <= this.QWn) {
            i4 = (((this.QWv - dividerHeight) - apx(i2 - 1)) / 2) + i3;
        } else {
            i4 = (((apx - dividerHeight) - this.QWv) / 2) + i3;
        }
        AppMethodBeat.o(159796);
        return i4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean hcB() {
        /*
        // Method dump skipped, instructions count: 290
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.sortlist.DragSortListView.hcB():boolean");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(159798);
        super.onDraw(canvas);
        if (this.QWU) {
            f fVar = this.QWV;
            if (fVar.QXr) {
                fVar.mBuilder.append("<DSLVState>\n");
                int childCount = DragSortListView.this.getChildCount();
                int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
                fVar.mBuilder.append("    <Positions>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    fVar.mBuilder.append(firstVisiblePosition + i2).append(",");
                }
                fVar.mBuilder.append("</Positions>\n");
                fVar.mBuilder.append("    <Tops>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    fVar.mBuilder.append(DragSortListView.this.getChildAt(i3).getTop()).append(",");
                }
                fVar.mBuilder.append("</Tops>\n");
                fVar.mBuilder.append("    <Bottoms>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    fVar.mBuilder.append(DragSortListView.this.getChildAt(i4).getBottom()).append(",");
                }
                fVar.mBuilder.append("</Bottoms>\n");
                fVar.mBuilder.append("    <FirstExpPos>").append(DragSortListView.this.QWk).append("</FirstExpPos>\n");
                fVar.mBuilder.append("    <FirstExpBlankHeight>").append(DragSortListView.this.apv(DragSortListView.this.QWk) - DragSortListView.this.apx(DragSortListView.this.QWk)).append("</FirstExpBlankHeight>\n");
                fVar.mBuilder.append("    <SecondExpPos>").append(DragSortListView.this.QWl).append("</SecondExpPos>\n");
                fVar.mBuilder.append("    <SecondExpBlankHeight>").append(DragSortListView.this.apv(DragSortListView.this.QWl) - DragSortListView.this.apx(DragSortListView.this.QWl)).append("</SecondExpBlankHeight>\n");
                fVar.mBuilder.append("    <SrcPos>").append(DragSortListView.this.QWn).append("</SrcPos>\n");
                fVar.mBuilder.append("    <SrcHeight>").append(DragSortListView.this.QWv + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
                fVar.mBuilder.append("    <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
                fVar.mBuilder.append("    <LastY>").append(DragSortListView.this.nrL).append("</LastY>\n");
                fVar.mBuilder.append("    <FloatY>").append(DragSortListView.this.QWf).append("</FloatY>\n");
                fVar.mBuilder.append("    <ShuffleEdges>");
                for (int i5 = 0; i5 < childCount; i5++) {
                    fVar.mBuilder.append(DragSortListView.this.lN(firstVisiblePosition + i5, DragSortListView.this.getChildAt(i5).getTop())).append(",");
                }
                fVar.mBuilder.append("</ShuffleEdges>\n");
                fVar.mBuilder.append("</DSLVState>\n");
                fVar.QXp++;
                if (fVar.QXp > 1000) {
                    fVar.flush();
                    fVar.QXp = 0;
                }
            }
        }
        AppMethodBeat.o(159798);
    }

    public final void removeItem(int i2) {
        AppMethodBeat.i(159799);
        this.QXb = false;
        D(i2, 0.0f);
        AppMethodBeat.o(159799);
    }

    private void D(int i2, float f2) {
        AppMethodBeat.i(159800);
        if (this.Wx == 0 || this.Wx == 4) {
            if (this.Wx == 0) {
                this.QWn = getHeaderViewsCount() + i2;
                this.QWk = this.QWn;
                this.QWl = this.QWn;
                this.QWj = this.QWn;
                View childAt = getChildAt(this.QWn - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.Wx = 1;
            this.QXc = f2;
            if (this.QWN) {
                switch (this.QWQ) {
                    case 1:
                        super.onTouchEvent(this.QWP);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.QWP);
                        break;
                }
            }
            if (this.QWZ != null) {
                this.QWZ.start();
                AppMethodBeat.o(159800);
                return;
            }
            apw(i2);
        }
        AppMethodBeat.o(159800);
    }

    public final void hcC() {
        AppMethodBeat.i(159801);
        if (this.Wx == 4) {
            this.QWz.hcN();
            hcM();
            hcD();
            hcI();
            if (this.QWN) {
                this.Wx = 3;
                AppMethodBeat.o(159801);
                return;
            }
            this.Wx = 0;
        }
        AppMethodBeat.o(159801);
    }

    private void hcD() {
        this.QWn = -1;
        this.QWk = -1;
        this.QWl = -1;
        this.QWj = -1;
    }

    private void hcE() {
        AppMethodBeat.i(159802);
        this.Wx = 2;
        if (this.QWr != null && this.QWj >= 0 && this.QWj < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.QWr.ey(this.QWn - headerViewsCount, this.QWj - headerViewsCount);
        }
        hcM();
        hcF();
        hcD();
        hcI();
        if (this.QWN) {
            this.Wx = 3;
            AppMethodBeat.o(159802);
            return;
        }
        this.Wx = 0;
        AppMethodBeat.o(159802);
    }

    private void apw(int i2) {
        AppMethodBeat.i(159803);
        this.Wx = 1;
        if (this.QWs != null) {
            this.QWs.remove(i2);
        }
        hcM();
        hcF();
        hcD();
        if (this.QWN) {
            this.Wx = 3;
            AppMethodBeat.o(159803);
            return;
        }
        this.Wx = 0;
        AppMethodBeat.o(159803);
    }

    private void hcF() {
        int i2 = 0;
        AppMethodBeat.i(159804);
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.QWn < firstVisiblePosition) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                i2 = childAt.getTop();
            }
            setSelectionFromTop(firstVisiblePosition - 1, i2 - getPaddingTop());
        }
        AppMethodBeat.o(159804);
    }

    public final boolean cC(float f2) {
        AppMethodBeat.i(159805);
        this.QXb = true;
        boolean e2 = e(true, f2);
        AppMethodBeat.o(159805);
        return e2;
    }

    private boolean e(boolean z, float f2) {
        AppMethodBeat.i(159806);
        if (this.ooN != null) {
            this.QWz.hcN();
            if (z) {
                D(this.QWn - getHeaderViewsCount(), f2);
            } else if (this.QXa != null) {
                this.QXa.start();
            } else {
                hcE();
            }
            if (this.QWU) {
                this.QWV.stopTracking();
            }
            AppMethodBeat.o(159806);
            return true;
        }
        AppMethodBeat.o(159806);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i2;
        AppMethodBeat.i(159807);
        if (this.QWX) {
            this.QWX = false;
            AppMethodBeat.o(159807);
            return false;
        } else if (!this.QWt) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(159807);
            return onTouchEvent;
        } else {
            boolean z2 = this.QWM;
            this.QWM = false;
            if (!z2) {
                ay(motionEvent);
            }
            if (this.Wx != 4) {
                if (this.Wx != 0 || !super.onTouchEvent(motionEvent)) {
                    z = false;
                } else {
                    z = true;
                }
                switch (motionEvent.getAction() & 255) {
                    case 1:
                    case 3:
                        hcG();
                        break;
                    case 2:
                    default:
                        if (z) {
                            this.QWQ = 1;
                            break;
                        }
                        break;
                }
            } else {
                switch (motionEvent.getAction() & 255) {
                    case 1:
                        if (this.Wx == 4) {
                            this.QXb = false;
                            e(false, 0.0f);
                        }
                        hcG();
                        break;
                    case 2:
                        int y = (int) motionEvent.getY();
                        this.QWd.x = ((int) motionEvent.getX()) - this.QWo;
                        this.QWd.y = y - this.QWp;
                        hcK();
                        int min = Math.min(y, this.QWf + this.QWw);
                        int max = Math.max(y, this.QWf - this.QWw);
                        d dVar = this.QWz;
                        if (dVar.hfx) {
                            i2 = dVar.QXn;
                        } else {
                            i2 = -1;
                        }
                        if (min <= this.nrL || min <= this.QWD || i2 == 1) {
                            if (max >= this.nrL || max >= this.QWC || i2 == 0) {
                                if (max >= this.QWC && min <= this.QWD && this.QWz.hfx) {
                                    this.QWz.hcN();
                                    break;
                                }
                            } else {
                                if (i2 != -1) {
                                    this.QWz.hcN();
                                }
                                this.QWz.apy(0);
                                break;
                            }
                        } else {
                            if (i2 != -1) {
                                this.QWz.hcN();
                            }
                            this.QWz.apy(1);
                            break;
                        }
                        break;
                    case 3:
                        if (this.Wx == 4) {
                            hcC();
                        }
                        hcG();
                        break;
                }
                z = true;
            }
            AppMethodBeat.o(159807);
            return z;
        }
    }

    private void hcG() {
        AppMethodBeat.i(159808);
        this.QWQ = 0;
        this.QWN = false;
        if (this.Wx == 3) {
            this.Wx = 0;
        }
        this.QWi = this.QWh;
        this.QXd = false;
        this.QWY.clear();
        AppMethodBeat.o(159808);
    }

    private void ay(MotionEvent motionEvent) {
        AppMethodBeat.i(159809);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.nrK = this.mX;
            this.nrL = this.mY;
        }
        this.mX = (int) motionEvent.getX();
        this.mY = (int) motionEvent.getY();
        if (action == 0) {
            this.nrK = this.mX;
            this.nrL = this.mY;
        }
        this.mOffsetX = ((int) motionEvent.getRawX()) - this.mX;
        this.mOffsetY = ((int) motionEvent.getRawY()) - this.mY;
        AppMethodBeat.o(159809);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(159810);
        if (!this.QWt) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(159810);
            return onInterceptTouchEvent;
        }
        ay(motionEvent);
        this.QWM = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.Wx != 0) {
                this.QWX = true;
                AppMethodBeat.o(159810);
                return true;
            }
            this.QWN = true;
        }
        if (this.ooN == null) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.QXd = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    hcG();
                    break;
                case 2:
                default:
                    if (!z) {
                        this.QWQ = 2;
                        break;
                    } else {
                        this.QWQ = 1;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.QWN = false;
        }
        AppMethodBeat.o(159810);
        return z;
    }

    private void hcH() {
        AppMethodBeat.i(159812);
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        float f2 = (float) height;
        this.QWF = ((float) paddingTop) + (this.QWA * f2);
        this.QWE = (f2 * (1.0f - this.QWB)) + ((float) paddingTop);
        this.QWC = (int) this.QWF;
        this.QWD = (int) this.QWE;
        this.QWG = this.QWF - ((float) paddingTop);
        this.QWH = ((float) (paddingTop + height)) - this.QWE;
        AppMethodBeat.o(159812);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(159813);
        super.onSizeChanged(i2, i3, i4, i5);
        hcH();
        AppMethodBeat.o(159813);
    }

    private void hcI() {
        AppMethodBeat.i(159814);
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
        AppMethodBeat.o(159814);
    }

    private void a(int i2, View view, boolean z) {
        int c2;
        AppMethodBeat.i(159815);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i2 == this.QWn || i2 == this.QWk || i2 == this.QWl) {
            c2 = c(i2, view, z);
        } else {
            c2 = -2;
        }
        if (c2 != layoutParams.height) {
            layoutParams.height = c2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.QWk || i2 == this.QWl) {
            if (i2 < this.QWn) {
                ((b) view).setGravity(80);
            } else if (i2 > this.QWn) {
                ((b) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.QWn && this.ooN != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
        AppMethodBeat.o(159815);
    }

    private int apx(int i2) {
        View view;
        AppMethodBeat.i(159816);
        if (i2 == this.QWn) {
            AppMethodBeat.o(159816);
            return 0;
        }
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        if (childAt != null) {
            int b2 = b(i2, childAt, false);
            AppMethodBeat.o(159816);
            return b2;
        }
        int i3 = this.QWY.get(i2);
        if (i3 != -1) {
            AppMethodBeat.o(159816);
            return i3;
        }
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i2);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.QWy.length) {
            this.QWy = new View[viewTypeCount];
        }
        if (itemViewType < 0) {
            view = adapter.getView(i2, null, this);
        } else if (this.QWy[itemViewType] == null) {
            view = adapter.getView(i2, null, this);
            this.QWy[itemViewType] = view;
        } else {
            view = adapter.getView(i2, this.QWy[itemViewType], this);
        }
        int b3 = b(i2, view, true);
        this.QWY.add(i2, b3);
        AppMethodBeat.o(159816);
        return b3;
    }

    private int b(int i2, View view, boolean z) {
        AppMethodBeat.i(159817);
        if (i2 == this.QWn) {
            AppMethodBeat.o(159817);
            return 0;
        }
        if (i2 >= getHeaderViewsCount() && i2 < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.height <= 0) {
            int height = view.getHeight();
            if (height == 0 || z) {
                hz(view);
                height = view.getMeasuredHeight();
            }
            AppMethodBeat.o(159817);
            return height;
        }
        int i3 = layoutParams.height;
        AppMethodBeat.o(159817);
        return i3;
    }

    private int c(int i2, View view, boolean z) {
        AppMethodBeat.i(159818);
        int lO = lO(i2, b(i2, view, z));
        AppMethodBeat.o(159818);
        return lO;
    }

    private int lO(int i2, int i3) {
        boolean z = this.QWm && this.QWk != this.QWl;
        int i4 = this.QWv - this.QWu;
        int i5 = (int) (this.QWS * ((float) i4));
        if (i2 == this.QWn) {
            if (this.QWn == this.QWk) {
                if (z) {
                    return i5 + this.QWu;
                }
                return this.QWv;
            } else if (this.QWn == this.QWl) {
                return this.QWv - i5;
            } else {
                return this.QWu;
            }
        } else if (i2 == this.QWk) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.QWl) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    public void requestLayout() {
        AppMethodBeat.i(159819);
        if (!this.QWW) {
            super.requestLayout();
        }
        AppMethodBeat.o(159819);
    }

    private int a(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(159820);
        int apx = apx(i2);
        int height = view.getHeight();
        int lO = lO(i2, apx);
        if (i2 != this.QWn) {
            i6 = height - apx;
            i5 = lO - apx;
        } else {
            i5 = lO;
            i6 = height;
        }
        int i8 = this.QWv;
        if (!(this.QWn == this.QWk || this.QWn == this.QWl)) {
            i8 -= this.QWu;
        }
        if (i2 <= i3) {
            if (i2 > this.QWk) {
                i7 = (i8 - i5) + 0;
            }
            i7 = 0;
        } else if (i2 == i4) {
            i7 = i2 <= this.QWk ? (i6 - i8) + 0 : i2 == this.QWl ? (height - lO) + 0 : i6 + 0;
        } else if (i2 <= this.QWk) {
            i7 = 0 - i8;
        } else {
            if (i2 == this.QWl) {
                i7 = 0 - i5;
            }
            i7 = 0;
        }
        AppMethodBeat.o(159820);
        return i7;
    }

    private void hz(View view) {
        int makeMeasureSpec;
        AppMethodBeat.i(159821);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.QWx, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
        AppMethodBeat.o(159821);
    }

    private void hcJ() {
        AppMethodBeat.i(159822);
        if (this.ooN != null) {
            hz(this.ooN);
            this.QWv = this.ooN.getMeasuredHeight();
            this.QWw = this.QWv / 2;
        }
        AppMethodBeat.o(159822);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(159823);
        super.onMeasure(i2, i3);
        if (this.ooN != null) {
            if (this.ooN.isLayoutRequested()) {
                hcJ();
            }
            this.QWg = true;
        }
        this.QWx = i2;
        AppMethodBeat.o(159823);
    }

    /* access modifiers changed from: protected */
    public void layoutChildren() {
        AppMethodBeat.i(159824);
        super.layoutChildren();
        if (this.ooN != null) {
            if (this.ooN.isLayoutRequested() && !this.QWg) {
                hcJ();
            }
            this.ooN.layout(0, 0, this.ooN.getMeasuredWidth(), this.ooN.getMeasuredHeight());
            this.QWg = false;
        }
        AppMethodBeat.o(159824);
    }

    public final boolean a(int i2, View view, int i3, int i4, int i5) {
        AppMethodBeat.i(159825);
        if (this.Wx != 0 || !this.QWN || this.ooN != null || view == null || !this.QWt) {
            AppMethodBeat.o(159825);
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = getHeaderViewsCount() + i2;
        this.QWk = headerViewsCount;
        this.QWl = headerViewsCount;
        this.QWn = headerViewsCount;
        this.QWj = headerViewsCount;
        this.Wx = 4;
        this.QWL = 0;
        this.QWL |= i3;
        this.ooN = view;
        hcJ();
        this.QWo = i4;
        this.QWp = i5;
        this.QWK = this.mY;
        this.QWd.x = this.mX - this.QWo;
        this.QWd.y = this.mY - this.QWp;
        View childAt = getChildAt(this.QWn - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.QWU) {
            f fVar = this.QWV;
            fVar.mBuilder.append("<DSLVStates>\n");
            fVar.QXq = 0;
            fVar.QXr = true;
        }
        switch (this.QWQ) {
            case 1:
                super.onTouchEvent(this.QWP);
                break;
            case 2:
                super.onInterceptTouchEvent(this.QWP);
                break;
        }
        requestLayout();
        AppMethodBeat.o(159825);
        return true;
    }

    private void hcK() {
        AppMethodBeat.i(159826);
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt == null) {
            AppMethodBeat.o(159826);
            return;
        }
        d(firstVisiblePosition, childAt, true);
        AppMethodBeat.o(159826);
    }

    private void d(int i2, View view, boolean z) {
        AppMethodBeat.i(159827);
        this.QWW = true;
        hcL();
        int i3 = this.QWk;
        int i4 = this.QWl;
        boolean hcB = hcB();
        if (hcB) {
            hcI();
            setSelectionFromTop(i2, (a(i2, view, i3, i4) + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        if (hcB || z) {
            invalidate();
        }
        this.QWW = false;
        AppMethodBeat.o(159827);
    }

    private void hcL() {
        AppMethodBeat.i(159828);
        if (this.QWO != null) {
            this.QWe.set(this.mX, this.mY);
            this.QWO.n(this.QWd);
        }
        int i2 = this.QWd.x;
        int i3 = this.QWd.y;
        int paddingLeft = getPaddingLeft();
        if ((this.QWL & 1) == 0 && i2 > paddingLeft) {
            this.QWd.x = paddingLeft;
        } else if ((this.QWL & 2) == 0 && i2 < paddingLeft) {
            this.QWd.x = paddingLeft;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int paddingTop = getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.QWL & 8) == 0 && firstVisiblePosition <= this.QWn) {
            paddingTop = Math.max(getChildAt(this.QWn - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            height = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.QWL & 4) == 0 && lastVisiblePosition >= this.QWn) {
            height = Math.min(getChildAt(this.QWn - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.QWd.y = paddingTop;
        } else if (this.QWv + i3 > height) {
            this.QWd.y = height - this.QWv;
        }
        this.QWf = this.QWd.y + this.QWw;
        AppMethodBeat.o(159828);
    }

    private void hcM() {
        AppMethodBeat.i(159829);
        if (this.ooN != null) {
            this.ooN.setVisibility(8);
            if (this.QWO != null) {
                this.QWO.hA(this.ooN);
            }
            this.ooN = null;
            invalidate();
        }
        AppMethodBeat.o(159829);
    }

    public void setFloatViewManager(i iVar) {
        this.QWO = iVar;
    }

    public void setDragListener(b bVar) {
        this.QWq = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.QWt = z;
    }

    public void setDropListener(h hVar) {
        this.QWr = hVar;
    }

    public void setRemoveListener(l lVar) {
        this.QWs = lVar;
    }

    public void setDragSortListener(e eVar) {
        AppMethodBeat.i(159830);
        setDropListener(eVar);
        setDragListener(eVar);
        setRemoveListener(eVar);
        AppMethodBeat.o(159830);
    }

    public void setDragScrollProfile(c cVar) {
        if (cVar != null) {
            this.QWJ = cVar;
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        ListAdapter GO;

        /* synthetic */ a(DragSortListView dragSortListView, ListAdapter listAdapter, byte b2) {
            this(listAdapter);
        }

        private a(ListAdapter listAdapter) {
            AppMethodBeat.i(159760);
            this.GO = listAdapter;
            this.GO.registerDataSetObserver(new DataSetObserver(DragSortListView.this) {
                /* class com.tencent.mm.ui.widget.sortlist.DragSortListView.a.AnonymousClass1 */

                public final void onChanged() {
                    AppMethodBeat.i(159758);
                    a.this.notifyDataSetChanged();
                    AppMethodBeat.o(159758);
                }

                public final void onInvalidated() {
                    AppMethodBeat.i(159759);
                    a.this.notifyDataSetInvalidated();
                    AppMethodBeat.o(159759);
                }
            });
            AppMethodBeat.o(159760);
        }

        public final long getItemId(int i2) {
            AppMethodBeat.i(159761);
            long itemId = this.GO.getItemId(i2);
            AppMethodBeat.o(159761);
            return itemId;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(159762);
            Object item = this.GO.getItem(i2);
            AppMethodBeat.o(159762);
            return item;
        }

        public final int getCount() {
            AppMethodBeat.i(159763);
            int count = this.GO.getCount();
            AppMethodBeat.o(159763);
            return count;
        }

        public final boolean areAllItemsEnabled() {
            AppMethodBeat.i(159764);
            boolean areAllItemsEnabled = this.GO.areAllItemsEnabled();
            AppMethodBeat.o(159764);
            return areAllItemsEnabled;
        }

        public final boolean isEnabled(int i2) {
            AppMethodBeat.i(159765);
            boolean isEnabled = this.GO.isEnabled(i2);
            AppMethodBeat.o(159765);
            return isEnabled;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(159766);
            int itemViewType = this.GO.getItemViewType(i2);
            AppMethodBeat.o(159766);
            return itemViewType;
        }

        public final int getViewTypeCount() {
            AppMethodBeat.i(159767);
            int viewTypeCount = this.GO.getViewTypeCount();
            AppMethodBeat.o(159767);
            return viewTypeCount;
        }

        public final boolean hasStableIds() {
            AppMethodBeat.i(159768);
            boolean hasStableIds = this.GO.hasStableIds();
            AppMethodBeat.o(159768);
            return hasStableIds;
        }

        public final boolean isEmpty() {
            AppMethodBeat.i(159769);
            boolean isEmpty = this.GO.isEmpty();
            AppMethodBeat.o(159769);
            return isEmpty;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            b bVar2;
            AppMethodBeat.i(159770);
            if (view == null || !(view instanceof b)) {
                View view2 = this.GO.getView(i2, null, DragSortListView.this);
                if (view2 instanceof Checkable) {
                    bVar = new c(DragSortListView.this.getContext());
                } else {
                    bVar = new b(DragSortListView.this.getContext());
                }
                bVar.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                bVar.addView(view2);
                bVar2 = bVar;
            } else {
                bVar2 = (b) view;
                View childAt = bVar2.getChildAt(0);
                View view3 = this.GO.getView(i2, childAt, DragSortListView.this);
                if (view3 != childAt) {
                    if (childAt != null) {
                        bVar2.removeViewAt(0);
                    }
                    bVar2.addView(view3);
                }
            }
            DragSortListView dragSortListView = DragSortListView.this;
            DragSortListView.a(dragSortListView, dragSortListView.getHeaderViewsCount() + i2, bVar2);
            AppMethodBeat.o(159770);
            return bVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public class j {
        private SparseIntArray QXw;
        private ArrayList<Integer> QXx;
        private int mMaxSize;

        /* synthetic */ j(DragSortListView dragSortListView, byte b2) {
            this();
        }

        private j() {
            AppMethodBeat.i(159781);
            this.QXw = new SparseIntArray(3);
            this.QXx = new ArrayList<>(3);
            this.mMaxSize = 3;
            AppMethodBeat.o(159781);
        }

        public final void add(int i2, int i3) {
            AppMethodBeat.i(159782);
            int i4 = this.QXw.get(i2, -1);
            if (i4 != i3) {
                if (i4 != -1) {
                    this.QXx.remove(Integer.valueOf(i2));
                } else if (this.QXw.size() == this.mMaxSize) {
                    this.QXw.delete(this.QXx.remove(0).intValue());
                }
                this.QXw.put(i2, i3);
                this.QXx.add(Integer.valueOf(i2));
            }
            AppMethodBeat.o(159782);
        }

        public final int get(int i2) {
            AppMethodBeat.i(159783);
            int i3 = this.QXw.get(i2, -1);
            AppMethodBeat.o(159783);
            return i3;
        }

        public final void clear() {
            AppMethodBeat.i(159784);
            this.QXw.clear();
            this.QXx.clear();
            AppMethodBeat.o(159784);
        }
    }

    /* access modifiers changed from: package-private */
    public class m implements Runnable {
        private float QXE;
        private float QXF;
        private float QXG;
        private float QXH;
        private float QXI;
        private float mAlpha;
        boolean mCanceled;
        protected long mStartTime;

        /* synthetic */ m(DragSortListView dragSortListView, float f2, int i2, byte b2) {
            this(0.5f, i2);
        }

        private m(float f2, int i2) {
            AppMethodBeat.i(198542);
            this.mAlpha = f2;
            this.QXE = (float) i2;
            float f3 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.QXI = f3;
            this.QXF = f3;
            this.QXG = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.QXH = 1.0f / (1.0f - this.mAlpha);
            AppMethodBeat.o(198542);
        }

        public final void start() {
            AppMethodBeat.i(159789);
            this.mStartTime = SystemClock.uptimeMillis();
            this.mCanceled = false;
            onStart();
            DragSortListView.this.post(this);
            AppMethodBeat.o(159789);
        }

        public void onStart() {
        }

        public void cE(float f2) {
        }

        public void onStop() {
        }

        public void run() {
            float f2;
            AppMethodBeat.i(159790);
            if (this.mCanceled) {
                AppMethodBeat.o(159790);
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.QXE;
            if (uptimeMillis >= 1.0f) {
                cE(1.0f);
                onStop();
                AppMethodBeat.o(159790);
                return;
            }
            if (uptimeMillis < this.mAlpha) {
                f2 = uptimeMillis * this.QXF * uptimeMillis;
            } else if (uptimeMillis < 1.0f - this.mAlpha) {
                f2 = (uptimeMillis * this.QXH) + this.QXG;
            } else {
                f2 = 1.0f - ((uptimeMillis - 1.0f) * (this.QXI * (uptimeMillis - 1.0f)));
            }
            cE(f2);
            DragSortListView.this.post(this);
            AppMethodBeat.o(159790);
        }
    }

    /* access modifiers changed from: package-private */
    public class g extends m {
        private int QXs;
        private int QXt;
        private float QXu;
        private float QXv;

        /* synthetic */ g(DragSortListView dragSortListView, int i2, byte b2) {
            this(i2);
        }

        private g(int i2) {
            super(DragSortListView.this, 0.5f, i2, (byte) 0);
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.m
        public final void onStart() {
            AppMethodBeat.i(159777);
            this.QXs = DragSortListView.this.QWj;
            this.QXt = DragSortListView.this.QWn;
            DragSortListView.this.Wx = 2;
            this.QXu = (float) (DragSortListView.this.QWd.y - hcO());
            this.QXv = (float) (DragSortListView.this.QWd.x - DragSortListView.this.getPaddingLeft());
            AppMethodBeat.o(159777);
        }

        private int hcO() {
            AppMethodBeat.i(159778);
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int dividerHeight = (DragSortListView.this.QWu + DragSortListView.this.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.QXs - firstVisiblePosition);
            int i2 = -1;
            if (childAt == null) {
                this.mCanceled = true;
            } else if (this.QXs == this.QXt) {
                i2 = childAt.getTop();
            } else if (this.QXs < this.QXt) {
                i2 = childAt.getTop() - dividerHeight;
            } else {
                i2 = (childAt.getBottom() + dividerHeight) - DragSortListView.this.QWv;
            }
            AppMethodBeat.o(159778);
            return i2;
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.m
        public final void cE(float f2) {
            AppMethodBeat.i(159779);
            int hcO = hcO();
            float paddingLeft = (float) (DragSortListView.this.QWd.x - DragSortListView.this.getPaddingLeft());
            float f3 = 1.0f - f2;
            if (f3 < Math.abs(((float) (DragSortListView.this.QWd.y - hcO)) / this.QXu) || f3 < Math.abs(paddingLeft / this.QXv)) {
                DragSortListView.this.QWd.y = hcO + ((int) (this.QXu * f3));
                DragSortListView.this.QWd.x = DragSortListView.this.getPaddingLeft() + ((int) (this.QXv * f3));
                DragSortListView.f(DragSortListView.this);
            }
            AppMethodBeat.o(159779);
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.m
        public final void onStop() {
            AppMethodBeat.i(159780);
            DragSortListView.k(DragSortListView.this);
            AppMethodBeat.o(159780);
        }
    }

    /* access modifiers changed from: package-private */
    public class k extends m {
        private float QXA;
        private int QXB;
        private int QXC;
        private int QXD;
        private float QXy;
        private float QXz;
        private int gzS;

        /* synthetic */ k(DragSortListView dragSortListView, int i2, byte b2) {
            this(i2);
        }

        private k(int i2) {
            super(DragSortListView.this, 0.5f, i2, (byte) 0);
            this.QXB = -1;
            this.QXC = -1;
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.m
        public final void onStart() {
            int i2 = -1;
            AppMethodBeat.i(159785);
            this.QXB = -1;
            this.QXC = -1;
            this.gzS = DragSortListView.this.QWk;
            this.QXD = DragSortListView.this.QWl;
            DragSortListView.this.Wx = 1;
            this.QXy = (float) DragSortListView.this.QWd.x;
            if (DragSortListView.this.QXb) {
                float width = ((float) DragSortListView.this.getWidth()) * 2.0f;
                if (DragSortListView.this.QXc == 0.0f) {
                    DragSortListView dragSortListView = DragSortListView.this;
                    if (this.QXy >= 0.0f) {
                        i2 = 1;
                    }
                    dragSortListView.QXc = ((float) i2) * width;
                    AppMethodBeat.o(159785);
                    return;
                }
                float f2 = width * 2.0f;
                if (DragSortListView.this.QXc >= 0.0f || DragSortListView.this.QXc <= (-f2)) {
                    if (DragSortListView.this.QXc > 0.0f && DragSortListView.this.QXc < f2) {
                        DragSortListView.this.QXc = f2;
                    }
                    AppMethodBeat.o(159785);
                    return;
                }
                DragSortListView.this.QXc = -f2;
                AppMethodBeat.o(159785);
                return;
            }
            DragSortListView.p(DragSortListView.this);
            AppMethodBeat.o(159785);
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.m
        public final void cE(float f2) {
            View childAt;
            AppMethodBeat.i(159786);
            float f3 = 1.0f - f2;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt2 = DragSortListView.this.getChildAt(this.gzS - firstVisiblePosition);
            if (DragSortListView.this.QXb) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis == 0.0f) {
                    AppMethodBeat.o(159786);
                    return;
                }
                float f4 = DragSortListView.this.QXc * uptimeMillis;
                int width = DragSortListView.this.getWidth();
                DragSortListView.this.QXc = (((float) (DragSortListView.this.QXc > 0.0f ? 1 : -1)) * uptimeMillis * ((float) width)) + DragSortListView.this.QXc;
                this.QXy += f4;
                DragSortListView.this.QWd.x = (int) this.QXy;
                if (this.QXy < ((float) width) && this.QXy > ((float) (-width))) {
                    this.mStartTime = SystemClock.uptimeMillis();
                    DragSortListView.f(DragSortListView.this);
                    AppMethodBeat.o(159786);
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.QXB == -1) {
                    this.QXB = DragSortListView.b(DragSortListView.this, this.gzS, childAt2);
                    this.QXz = (float) (childAt2.getHeight() - this.QXB);
                }
                int max = Math.max((int) (this.QXz * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.QXB;
                childAt2.setLayoutParams(layoutParams);
            }
            if (!(this.QXD == this.gzS || (childAt = DragSortListView.this.getChildAt(this.QXD - firstVisiblePosition)) == null)) {
                if (this.QXC == -1) {
                    this.QXC = DragSortListView.b(DragSortListView.this, this.QXD, childAt);
                    this.QXA = (float) (childAt.getHeight() - this.QXC);
                }
                int max2 = Math.max((int) (this.QXA * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.QXC;
                childAt.setLayoutParams(layoutParams2);
            }
            AppMethodBeat.o(159786);
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.m
        public final void onStop() {
            AppMethodBeat.i(159787);
            DragSortListView.q(DragSortListView.this);
            AppMethodBeat.o(159787);
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {
        private long QXi;
        private long QXj;
        private int QXk;
        private float QXl;
        private long QXm;
        int QXn;
        private float QXo;
        boolean hfx = false;
        private boolean mAbort;

        d() {
        }

        public final void apy(int i2) {
            AppMethodBeat.i(159771);
            if (!this.hfx) {
                this.mAbort = false;
                this.hfx = true;
                this.QXm = SystemClock.uptimeMillis();
                this.QXi = this.QXm;
                this.QXn = i2;
                DragSortListView.this.post(this);
            }
            AppMethodBeat.o(159771);
        }

        public final void hcN() {
            AppMethodBeat.i(159772);
            DragSortListView.this.removeCallbacks(this);
            this.hfx = false;
            AppMethodBeat.o(159772);
        }

        public final void run() {
            AppMethodBeat.i(159773);
            if (this.mAbort) {
                this.hfx = false;
                AppMethodBeat.o(159773);
                return;
            }
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int lastVisiblePosition = DragSortListView.this.getLastVisiblePosition();
            int count = DragSortListView.this.getCount();
            int paddingTop = DragSortListView.this.getPaddingTop();
            int height = (DragSortListView.this.getHeight() - paddingTop) - DragSortListView.this.getPaddingBottom();
            int min = Math.min(DragSortListView.this.mY, DragSortListView.this.QWf + DragSortListView.this.QWw);
            int max = Math.max(DragSortListView.this.mY, DragSortListView.this.QWf - DragSortListView.this.QWw);
            if (this.QXn == 0) {
                View childAt = DragSortListView.this.getChildAt(0);
                if (childAt == null) {
                    this.hfx = false;
                    AppMethodBeat.o(159773);
                    return;
                } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                    this.hfx = false;
                    AppMethodBeat.o(159773);
                    return;
                } else {
                    this.QXo = DragSortListView.this.QWJ.cD((DragSortListView.this.QWF - ((float) max)) / DragSortListView.this.QWG);
                }
            } else {
                View childAt2 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.hfx = false;
                    AppMethodBeat.o(159773);
                    return;
                } else if (lastVisiblePosition != count - 1 || childAt2.getBottom() > height + paddingTop) {
                    this.QXo = -DragSortListView.this.QWJ.cD((((float) min) - DragSortListView.this.QWE) / DragSortListView.this.QWH);
                } else {
                    this.hfx = false;
                    AppMethodBeat.o(159773);
                    return;
                }
            }
            this.QXj = SystemClock.uptimeMillis();
            this.QXl = (float) (this.QXj - this.QXi);
            this.QXk = Math.round(this.QXo * this.QXl);
            if (this.QXk >= 0) {
                this.QXk = Math.min(height, this.QXk);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.QXk = Math.max(-height, this.QXk);
            }
            View childAt3 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
            int top = childAt3.getTop() + this.QXk;
            if (lastVisiblePosition == 0 && top > paddingTop) {
                top = paddingTop;
            }
            DragSortListView.this.QWW = true;
            DragSortListView.this.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.QWW = false;
            DragSortListView.c(DragSortListView.this, lastVisiblePosition, childAt3);
            this.QXi = this.QXj;
            DragSortListView.this.post(this);
            AppMethodBeat.o(159773);
        }
    }

    /* access modifiers changed from: package-private */
    public class f {
        int QXp = 0;
        int QXq = 0;
        boolean QXr = false;
        StringBuilder mBuilder = new StringBuilder();
        File mFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");

        f() {
            AppMethodBeat.i(159774);
            if (!this.mFile.exists()) {
                try {
                    if (!this.mFile.createNewFile()) {
                        as.e("mobeta", "creat file fail!! file already exist", new Object[0]);
                    }
                    as.d("mobeta", "file created", new Object[0]);
                    AppMethodBeat.o(159774);
                    return;
                } catch (IOException e2) {
                    as.w("mobeta", "Could not create dslv_state.txt", new Object[0]);
                    as.d("mobeta", e2.getMessage(), new Object[0]);
                }
            }
            AppMethodBeat.o(159774);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A[SYNTHETIC, Splitter:B:19:0x0063] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x007f A[SYNTHETIC, Splitter:B:27:0x007f] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void flush() {
            /*
            // Method dump skipped, instructions count: 156
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.sortlist.DragSortListView.f.flush():void");
        }

        public final void stopTracking() {
            AppMethodBeat.i(159776);
            if (this.QXr) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.QXr = false;
            }
            AppMethodBeat.o(159776);
        }
    }

    public void setDragScrollStart(float f2) {
        AppMethodBeat.i(159811);
        if (f2 > 0.5f) {
            this.QWB = 0.5f;
        } else {
            this.QWB = f2;
        }
        if (f2 > 0.5f) {
            this.QWA = 0.5f;
        } else {
            this.QWA = f2;
        }
        if (getHeight() != 0) {
            hcH();
        }
        AppMethodBeat.o(159811);
    }

    static /* synthetic */ void q(DragSortListView dragSortListView) {
        AppMethodBeat.i(159837);
        dragSortListView.apw(dragSortListView.QWn - dragSortListView.getHeaderViewsCount());
        AppMethodBeat.o(159837);
    }
}
