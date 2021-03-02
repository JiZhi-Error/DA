package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;

public class TouchInterceptorListView extends ListView {
    private int afE;
    private int afF;
    private GestureDetector mDJ;
    private int mHeight;
    private Rect mTempRect = new Rect();
    private final int mTouchSlop;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mWindowParams;
    private int qXo;
    private ImageView riR;
    private int riS;
    private int riT;
    private int riU;
    private int riV;
    private a riW;
    private b riX;
    private c riY;
    private int riZ;
    private int rja;
    private int rjb = -1;
    private Bitmap rjc;
    private int rjd;
    private int rje;
    private Drawable rjf;
    private int rjg = 0;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    static /* synthetic */ void c(TouchInterceptorListView touchInterceptorListView) {
        AppMethodBeat.i(109096);
        touchInterceptorListView.cHP();
        AppMethodBeat.o(109096);
    }

    static /* synthetic */ void f(TouchInterceptorListView touchInterceptorListView) {
        AppMethodBeat.i(109097);
        touchInterceptorListView.lv(true);
        AppMethodBeat.o(109097);
    }

    public TouchInterceptorListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(109090);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        Resources resources = getResources();
        this.qXo = resources.getDimensionPixelSize(R.dimen.a2k) + 1;
        this.rje = this.qXo / 2;
        this.rjd = this.qXo * 2;
        this.rjg = resources.getDimensionPixelOffset(R.dimen.a2r);
        AppMethodBeat.o(109090);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(109091);
        if (this.riY != null && this.mDJ == null && this.rjb == 0) {
            this.mDJ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                /* class com.tencent.mm.plugin.emoji.ui.TouchInterceptorListView.AnonymousClass1 */

                public final boolean onContextClick(MotionEvent motionEvent) {
                    AppMethodBeat.i(240179);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                    boolean onContextClick = super.onContextClick(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(240179);
                    return onContextClick;
                }

                public final boolean onDoubleTap(MotionEvent motionEvent) {
                    AppMethodBeat.i(240178);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                    boolean onDoubleTap = super.onDoubleTap(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(240178);
                    return onDoubleTap;
                }

                public final void onLongPress(MotionEvent motionEvent) {
                    AppMethodBeat.i(240177);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                    super.onLongPress(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                    AppMethodBeat.o(240177);
                }

                public final boolean onSingleTapUp(MotionEvent motionEvent) {
                    AppMethodBeat.i(240176);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                    boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(240176);
                    return onSingleTapUp;
                }

                public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    AppMethodBeat.i(109089);
                    if (TouchInterceptorListView.this.riR != null) {
                        if (f2 > 1000.0f) {
                            Rect rect = TouchInterceptorListView.this.mTempRect;
                            TouchInterceptorListView.this.riR.getDrawingRect(rect);
                            if (motionEvent2.getX() > ((float) ((rect.right * 2) / 3))) {
                                TouchInterceptorListView.c(TouchInterceptorListView.this);
                                c unused = TouchInterceptorListView.this.riY;
                                int unused2 = TouchInterceptorListView.this.riT;
                                TouchInterceptorListView.f(TouchInterceptorListView.this);
                            }
                        }
                        AppMethodBeat.o(109089);
                        return true;
                    }
                    AppMethodBeat.o(109089);
                    return false;
                }
            });
        }
        if (!(this.riW == null && this.riX == null)) {
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        ViewGroup viewGroup = (ViewGroup) getChildAt(pointToPosition - getFirstVisiblePosition());
                        this.riU = x - viewGroup.getLeft();
                        this.riV = y - viewGroup.getTop();
                        this.afE = ((int) motionEvent.getRawX()) - x;
                        this.afF = ((int) motionEvent.getRawY()) - y;
                        if (x >= this.rjg) {
                            cHP();
                            break;
                        } else {
                            viewGroup.setDrawingCacheEnabled(true);
                            Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getDrawingCache());
                            cHP();
                            this.mWindowParams = new WindowManager.LayoutParams();
                            this.mWindowParams.gravity = 49;
                            this.mWindowParams.x = (x - this.riU) + this.afE;
                            this.mWindowParams.y = (y - this.riV) + this.afF;
                            this.mWindowParams.height = -2;
                            this.mWindowParams.width = -2;
                            this.mWindowParams.flags = 920;
                            this.mWindowParams.format = -3;
                            this.mWindowParams.windowAnimations = 0;
                            Context context = getContext();
                            ImageView imageView = new ImageView(context);
                            imageView.setBackgroundColor(context.getResources().getColor(R.color.afz));
                            imageView.setBackgroundResource(R.drawable.bcy);
                            imageView.setPadding(0, 0, 0, 0);
                            imageView.setImageBitmap(createBitmap);
                            this.rjc = createBitmap;
                            this.mWindowManager = (WindowManager) context.getSystemService("window");
                            this.mWindowManager.addView(imageView, this.mWindowParams);
                            this.riR = imageView;
                            this.riS = pointToPosition;
                            this.riT = this.riS;
                            this.mHeight = getHeight();
                            int i2 = this.mTouchSlop;
                            this.riZ = Math.min(y - i2, this.mHeight / 3);
                            this.rja = Math.max(i2 + y, (this.mHeight * 2) / 3);
                            AppMethodBeat.o(109091);
                            return false;
                        }
                    }
                    break;
            }
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(109091);
        return onInterceptTouchEvent;
    }

    private int fD(int i2, int i3) {
        int fD;
        AppMethodBeat.i(109092);
        if (i3 >= 0 || (fD = fD(i2, this.qXo + i3)) <= 0) {
            Rect rect = this.mTempRect;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                getChildAt(childCount).getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    int firstVisiblePosition = childCount + getFirstVisiblePosition();
                    AppMethodBeat.o(109092);
                    return firstVisiblePosition;
                }
            }
            AppMethodBeat.o(109092);
            return -1;
        }
        int i4 = fD - 1;
        AppMethodBeat.o(109092);
        return i4;
    }

    private void lv(boolean z) {
        AppMethodBeat.i(109093);
        int i2 = 0;
        while (true) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                if (z) {
                    int firstVisiblePosition = getFirstVisiblePosition();
                    int top = getChildAt(0).getTop();
                    setAdapter(getAdapter());
                    setSelectionFromTop(firstVisiblePosition, top);
                }
                try {
                    layoutChildren();
                    childAt = getChildAt(i2);
                } catch (IllegalStateException e2) {
                }
                if (childAt == null) {
                    AppMethodBeat.o(109093);
                    return;
                }
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = this.qXo;
            childAt.setLayoutParams(layoutParams);
            childAt.setVisibility(0);
            i2++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i3 = 4;
        int i4 = 0;
        AppMethodBeat.i(109094);
        if (this.mDJ != null) {
            GestureDetector gestureDetector = this.mDJ;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        }
        if ((this.riW == null && this.riX == null) || this.riR == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(109094);
            return onTouchEvent;
        }
        int action = motionEvent.getAction();
        switch (action) {
            case 0:
            case 2:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (this.rjb == 1) {
                    float f2 = 1.0f;
                    int width = this.riR.getWidth();
                    if (x > width / 2) {
                        f2 = ((float) (width - x)) / ((float) (width / 2));
                    }
                    this.mWindowParams.alpha = f2;
                }
                if (this.rjb == 0 || this.rjb == 2) {
                    this.mWindowParams.x = (x - this.riU) + this.afE;
                } else {
                    this.mWindowParams.x = 0;
                }
                this.mWindowParams.y = (y - this.riV) + this.afF;
                this.mWindowManager.updateViewLayout(this.riR, this.mWindowParams);
                if (this.rjf != null) {
                    int width2 = this.riR.getWidth();
                    if (y > (getHeight() * 3) / 4) {
                        this.rjf.setLevel(2);
                    } else if (width2 <= 0 || x <= width2 / 4) {
                        this.rjf.setLevel(0);
                    } else {
                        this.rjf.setLevel(1);
                    }
                }
                int i5 = (y - this.riV) - this.rje;
                int fD = fD(0, i5);
                if (fD >= 0) {
                    if (fD <= this.riT) {
                        fD++;
                    }
                } else if (i5 < 0) {
                    fD = 0;
                }
                if (fD >= 0) {
                    if (action == 0 || fD != this.riS) {
                        this.riS = fD;
                        Log.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", Integer.valueOf(this.riS), Integer.valueOf(this.riT));
                        Log.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", Integer.valueOf(getFirstVisiblePosition()));
                        Log.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", Integer.valueOf(getHeaderViewsCount()));
                        int firstVisiblePosition = this.riS - getFirstVisiblePosition();
                        int headerViewsCount = getHeaderViewsCount();
                        View childAt = getChildAt(this.riT - getFirstVisiblePosition());
                        int i6 = 0;
                        while (true) {
                            View childAt2 = getChildAt(i6);
                            if (childAt2 != null) {
                                int i7 = this.qXo;
                                if (this.riS >= headerViewsCount || i6 != headerViewsCount) {
                                    if (childAt2.equals(childAt)) {
                                        if (this.riS == this.riT || getPositionForView(childAt2) == getCount()) {
                                            i7 = this.qXo;
                                            Log.d("MicroMsg.emoji.TouchInterceptorListView", "2. visibility = View.INVISIBLE");
                                            i2 = 4;
                                        } else {
                                            Log.d("MicroMsg.emoji.TouchInterceptorListView", "2. height = 1");
                                            i2 = 0;
                                            i7 = 1;
                                        }
                                    } else if (i6 != firstVisiblePosition) {
                                        Log.d("MicroMsg.emoji.TouchInterceptorListView", "4");
                                        i2 = 0;
                                    } else if (this.riS < headerViewsCount || this.riS >= getCount()) {
                                        Log.d("MicroMsg.emoji.TouchInterceptorListView", "3. ");
                                        i2 = 0;
                                    } else {
                                        i7 = this.rjd;
                                        Log.d("MicroMsg.emoji.TouchInterceptorListView", "3. height = mItemHeightExpanded;");
                                        i2 = 0;
                                    }
                                } else if (childAt2.equals(childAt)) {
                                    Log.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
                                    i2 = 4;
                                } else {
                                    i7 = this.rjd;
                                    Log.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
                                    i2 = 0;
                                }
                                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                                layoutParams.height = i7;
                                childAt2.setLayoutParams(layoutParams);
                                childAt2.setVisibility(i2);
                                i6++;
                            }
                        }
                    }
                    if (y >= this.mHeight / 3) {
                        this.riZ = this.mHeight / 3;
                    }
                    if (y <= (this.mHeight * 2) / 3) {
                        this.rja = (this.mHeight * 2) / 3;
                    }
                    if (y > this.rja) {
                        if (getLastVisiblePosition() < getCount() - 1) {
                            if (y > (this.mHeight + this.rja) / 2) {
                                i3 = 16;
                            }
                            i4 = i3;
                        } else {
                            i4 = 1;
                        }
                    } else if (y < this.riZ) {
                        int i8 = y < this.riZ / 2 ? -16 : -4;
                        if (getFirstVisiblePosition() != 0 || getChildAt(0).getTop() < getPaddingTop()) {
                            i4 = i8;
                        }
                    }
                    if (i4 != 0 && !d.oE(8)) {
                        smoothScrollBy(i4, 30);
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                Rect rect = this.mTempRect;
                this.riR.getDrawingRect(rect);
                cHP();
                if (this.rjb == 1 && motionEvent.getX() > ((float) ((rect.right * 3) / 4))) {
                    lv(true);
                    break;
                } else {
                    if (this.riX != null && this.riS >= 0) {
                        getCount();
                    }
                    lv(false);
                    break;
                }
                break;
        }
        AppMethodBeat.o(109094);
        return true;
    }

    private void cHP() {
        AppMethodBeat.i(109095);
        if (this.riR != null) {
            this.riR.setVisibility(8);
            ((WindowManager) getContext().getSystemService("window")).removeView(this.riR);
            this.riR.setImageDrawable(null);
            this.riR = null;
        }
        if (this.rjc != null) {
            Log.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", this.rjc);
            this.rjc.recycle();
            this.rjc = null;
        }
        if (this.rjf != null) {
            this.rjf.setLevel(0);
        }
        AppMethodBeat.o(109095);
    }

    public void setTrashcan(Drawable drawable) {
        this.rjf = drawable;
        this.rjb = 2;
    }

    public void setDragListener(a aVar) {
        this.riW = aVar;
    }

    public void setDropListener(b bVar) {
        this.riX = bVar;
    }

    public void setRemoveListener(c cVar) {
        this.riY = cVar;
    }
}
