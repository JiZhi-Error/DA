package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;

public final class a extends d implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int[] AS = new int[2];
    private GestureDetector PO;
    private int QJI;
    private int QVK = 0;
    boolean QVL = true;
    boolean QVM = false;
    private boolean QVN = false;
    private GestureDetector QVO;
    private int QVP = -1;
    private int QVQ = -1;
    private int QVR = -1;
    private int QVS;
    private int QVT;
    private boolean QVU = false;
    private float QVV = 500.0f;
    private int QVW;
    private int QVX;
    private int QVY;
    private boolean QVZ;
    private DragSortListView QWa;
    private GestureDetector.OnGestureListener QWb = new GestureDetector.SimpleOnGestureListener() {
        /* class com.tencent.mm.ui.widget.sortlist.a.AnonymousClass1 */

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(198541);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198541);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(198540);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198540);
            return onDoubleTap;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(198539);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(198539);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(198538);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198538);
            return onSingleTapUp;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(159738);
            if (a.this.QVM && a.this.QVN) {
                int width = a.this.QWa.getWidth() / 5;
                if (f2 > a.this.QVV) {
                    if (a.this.QJI > (-width)) {
                        a.this.QWa.cC(f2);
                    }
                } else if (f2 < (-a.this.QVV) && a.this.QJI < width) {
                    a.this.QWa.cC(f2);
                }
                a.this.QVN = false;
            }
            AppMethodBeat.o(159738);
            return false;
        }
    };
    private int mAh;
    private int mAi;
    private int mTouchSlop;
    private int rjb;

    public a(DragSortListView dragSortListView, int i2, int i3, int i4, int i5, int i6) {
        super(dragSortListView);
        AppMethodBeat.i(159739);
        this.QWa = dragSortListView;
        this.PO = new GestureDetector(dragSortListView.getContext(), this);
        this.QVO = new GestureDetector(dragSortListView.getContext(), this.QWb);
        this.QVO.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.QVW = i2;
        this.QVX = i5;
        this.QVY = i6;
        this.rjb = i4;
        this.QVK = i3;
        AppMethodBeat.o(159739);
    }

    private boolean bb(int i2, int i3, int i4) {
        int i5;
        int i6;
        View apz;
        boolean z = false;
        AppMethodBeat.i(159740);
        if (!this.QVL || this.QVN) {
            i5 = 0;
        } else {
            i5 = 12;
        }
        if (!this.QVM || !this.QVN) {
            i6 = i5;
        } else {
            i6 = i5 | 1 | 2;
        }
        DragSortListView dragSortListView = this.QWa;
        int headerViewsCount = i2 - this.QWa.getHeaderViewsCount();
        if (!(!dragSortListView.QWN || dragSortListView.QWO == null || (apz = dragSortListView.QWO.apz(headerViewsCount)) == null)) {
            z = dragSortListView.a(headerViewsCount, apz, i6, i3, i4);
        }
        this.QVU = z;
        boolean z2 = this.QVU;
        AppMethodBeat.o(159740);
        return z2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(159741);
        if (!this.QWa.QWt || this.QWa.QXd) {
            AppMethodBeat.o(159741);
        } else {
            GestureDetector gestureDetector = this.PO;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            if (this.QVM && this.QVU && this.rjb == 1) {
                GestureDetector gestureDetector2 = this.QVO;
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector2, bl2.axQ(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector2, gestureDetector2.onTouchEvent((MotionEvent) bl2.pG(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mAh = (int) motionEvent.getX();
                    this.mAi = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.QVM && this.QVN) {
                        if ((this.QJI >= 0 ? this.QJI : -this.QJI) > this.QWa.getWidth() / 2) {
                            this.QWa.cC(0.0f);
                            break;
                        }
                    }
                    break;
                case 3:
                    this.QVN = false;
                    this.QVU = false;
                    break;
            }
            AppMethodBeat.o(159741);
        }
        return false;
    }

    @Override // com.tencent.mm.ui.widget.sortlist.d, com.tencent.mm.ui.widget.sortlist.DragSortListView.i
    public final void n(Point point) {
        if (this.QVM && this.QVN) {
            this.QJI = point.x;
        }
    }

    private int l(MotionEvent motionEvent, int i2) {
        AppMethodBeat.i(159742);
        int pointToPosition = this.QWa.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.QWa.getHeaderViewsCount();
        int footerViewsCount = this.QWa.getFooterViewsCount();
        int count = this.QWa.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            DragSortListView dragSortListView = this.QWa;
            View childAt = dragSortListView.getChildAt(pointToPosition - dragSortListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i2 == 0 ? childAt : childAt.findViewById(i2);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.AS);
                if (rawX > this.AS[0] && rawY > this.AS[1] && rawX < this.AS[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.AS[1]) {
                        this.QVS = childAt.getLeft();
                        this.QVT = childAt.getTop();
                        AppMethodBeat.o(159742);
                        return pointToPosition;
                    }
                }
            }
        }
        AppMethodBeat.o(159742);
        return -1;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        int i2 = -1;
        AppMethodBeat.i(159743);
        if (this.QVM && this.rjb == 0) {
            this.QVR = l(motionEvent, this.QVX);
        }
        this.QVP = l(motionEvent, this.QVW);
        if (this.QVP != -1 && this.QVK == 0) {
            bb(this.QVP, ((int) motionEvent.getX()) - this.QVS, ((int) motionEvent.getY()) - this.QVT);
        }
        this.QVN = false;
        this.QVZ = true;
        this.QJI = 0;
        if (this.rjb == 1) {
            i2 = l(motionEvent, this.QVY);
        }
        this.QVQ = i2;
        AppMethodBeat.o(159743);
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(159744);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int x2 = (int) motionEvent2.getX();
        int y2 = (int) motionEvent2.getY();
        int i2 = x2 - this.QVS;
        int i3 = y2 - this.QVT;
        if (this.QVZ && !this.QVU && !(this.QVP == -1 && this.QVQ == -1)) {
            if (this.QVP != -1) {
                if (this.QVK == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.QVL) {
                    bb(this.QVP, i2, i3);
                } else if (this.QVK != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.QVM) {
                    this.QVN = true;
                    bb(this.QVQ, i2, i3);
                }
            } else if (this.QVQ != -1) {
                if (Math.abs(x2 - x) > this.mTouchSlop && this.QVM) {
                    this.QVN = true;
                    bb(this.QVQ, i2, i3);
                } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                    this.QVZ = false;
                }
            }
        }
        AppMethodBeat.o(159744);
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(159745);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        if (this.QVP != -1 && this.QVK == 2) {
            this.QWa.performHapticFeedback(0);
            bb(this.QVP, this.mAh - this.QVS, this.mAi - this.QVT);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(159745);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(159746);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        if (this.QVM && this.rjb == 0 && this.QVR != -1) {
            this.QWa.removeItem(this.QVR - this.QWa.getHeaderViewsCount());
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(159746);
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }
}
