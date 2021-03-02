package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.u;
import android.support.v4.widget.n;
import android.support.v7.a.a;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.mm.R;
import java.lang.reflect.Method;

public class ListPopupWindow implements s {
    private static Method aqZ;
    private static Method ara;
    private static Method arb;
    private ListAdapter GO;
    public int afz;
    public Rect ahd;
    private boolean akK;
    public int akZ;
    public PopupWindow arA;
    public y arc;
    private int ard;
    public int are;
    private int arf;
    private int arg;
    private boolean arh;
    private boolean ari;
    private boolean arj;
    private boolean ark;
    private boolean arl;
    int arm;
    private View arn;
    int aro;
    public View arp;
    private Drawable arq;
    public AdapterView.OnItemClickListener ars;
    private AdapterView.OnItemSelectedListener art;
    final e aru;
    private final d arv;
    private final c arw;
    private final a arx;
    private Runnable ary;
    public boolean arz;
    private Context mContext;
    final Handler mHandler;
    private DataSetObserver mObserver;
    private final Rect mTempRect;

    static {
        try {
            aqZ = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
        }
        try {
            ara = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException e3) {
        }
        try {
            arb = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException e4) {
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.sa);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sa);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.ard = -2;
        this.akZ = -2;
        this.arg = 1002;
        this.ari = true;
        this.afz = 0;
        this.ark = false;
        this.arl = false;
        this.arm = Integer.MAX_VALUE;
        this.aro = 0;
        this.aru = new e();
        this.arv = new d();
        this.arw = new c();
        this.arx = new a();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0040a.ListPopupWindow, i2, i3);
        this.are = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        this.arf = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        if (this.arf != 0) {
            this.arh = true;
        }
        obtainStyledAttributes.recycle();
        this.arA = new AppCompatPopupWindow(context, attributeSet, i2, i3);
        this.arA.setInputMethodMode(1);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new b();
        } else if (this.GO != null) {
            this.GO.unregisterDataSetObserver(this.mObserver);
        }
        this.GO = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.arc != null) {
            this.arc.setAdapter(this.GO);
        }
    }

    public final void setModal(boolean z) {
        this.arz = z;
        this.arA.setFocusable(z);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.arA.setBackgroundDrawable(drawable);
    }

    public final void setAnimationStyle(int i2) {
        this.arA.setAnimationStyle(i2);
    }

    public final int getVerticalOffset() {
        if (!this.arh) {
            return 0;
        }
        return this.arf;
    }

    public final void setVerticalOffset(int i2) {
        this.arf = i2;
        this.arh = true;
    }

    public final void setContentWidth(int i2) {
        Drawable background = this.arA.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.akZ = this.mTempRect.left + this.mTempRect.right + i2;
            return;
        }
        this.akZ = i2;
    }

    public final void setHeight(int i2) {
        if (i2 >= 0 || -2 == i2 || -1 == i2) {
            this.ard = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v30, resolved type: android.widget.LinearLayout */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.view.menu.s
    public void show() {
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int makeMeasureSpec;
        int i11;
        int i12;
        int i13;
        boolean z2 = true;
        if (this.arc == null) {
            Context context = this.mContext;
            this.ary = new Runnable() {
                /* class android.support.v7.widget.ListPopupWindow.AnonymousClass1 */

                public final void run() {
                    View view = ListPopupWindow.this.arp;
                    if (view != null && view.getWindowToken() != null) {
                        ListPopupWindow.this.show();
                    }
                }
            };
            this.arc = i(context, !this.arz);
            if (this.arq != null) {
                this.arc.setSelector(this.arq);
            }
            this.arc.setAdapter(this.GO);
            this.arc.setOnItemClickListener(this.ars);
            this.arc.setFocusable(true);
            this.arc.setFocusableInTouchMode(true);
            this.arc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                /* class android.support.v7.widget.ListPopupWindow.AnonymousClass2 */

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                    y yVar;
                    if (i2 != -1 && (yVar = ListPopupWindow.this.arc) != null) {
                        yVar.setListSelectionHidden(false);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.arc.setOnScrollListener(this.arw);
            if (this.art != null) {
                this.arc.setOnItemSelectedListener(this.art);
            }
            y yVar = this.arc;
            View view = this.arn;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.aro) {
                    case 0:
                        linearLayout.addView(view);
                        linearLayout.addView(yVar, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(yVar, layoutParams);
                        linearLayout.addView(view);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.aro);
                        break;
                }
                if (this.akZ >= 0) {
                    i13 = this.akZ;
                    i12 = Integer.MIN_VALUE;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i13, i12), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i11 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                yVar = linearLayout;
            } else {
                i11 = 0;
            }
            this.arA.setContentView(yVar);
            i2 = i11;
        } else {
            this.arA.getContentView();
            View view2 = this.arn;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i2 = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.arA.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            int i14 = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.arh) {
                this.arf = -this.mTempRect.top;
                i3 = i14;
            } else {
                i3 = i14;
            }
        } else {
            this.mTempRect.setEmpty();
            i3 = 0;
        }
        if (this.arA.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        int maxAvailableHeight = getMaxAvailableHeight(this.arp, this.arf, z);
        if (this.ark || this.ard == -1) {
            i4 = maxAvailableHeight + i3;
        } else {
            switch (this.akZ) {
                case -2:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
                    break;
                default:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.akZ, 1073741824);
                    break;
            }
            int e2 = this.arc.e(makeMeasureSpec, 0, -1, maxAvailableHeight - i2, -1);
            if (e2 > 0) {
                i2 += this.arc.getPaddingTop() + this.arc.getPaddingBottom() + i3;
            }
            i4 = e2 + i2;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        n.a(this.arA, this.arg);
        if (!this.arA.isShowing()) {
            if (this.akZ == -1) {
                i5 = -1;
            } else if (this.akZ == -2) {
                i5 = this.arp.getWidth();
            } else {
                i5 = this.akZ;
            }
            if (this.ard == -1) {
                i4 = -1;
            } else if (this.ard != -2) {
                i4 = this.ard;
            }
            this.arA.setWidth(i5);
            this.arA.setHeight(i4);
            if (aqZ != null) {
                try {
                    aqZ.invoke(this.arA, Boolean.TRUE);
                } catch (Exception e3) {
                }
            }
            PopupWindow popupWindow = this.arA;
            if (this.arl || this.ark) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.arA.setTouchInterceptor(this.arv);
            if (this.arj) {
                n.a(this.arA, this.akK);
            }
            if (arb != null) {
                try {
                    arb.invoke(this.arA, this.ahd);
                } catch (Exception e4) {
                }
            }
            PopupWindow popupWindow2 = this.arA;
            View view3 = this.arp;
            int i15 = this.are;
            int i16 = this.arf;
            int i17 = this.afz;
            if (Build.VERSION.SDK_INT >= 19) {
                popupWindow2.showAsDropDown(view3, i15, i16, i17);
            } else {
                if ((android.support.v4.view.d.getAbsoluteGravity(i17, u.Z(view3)) & 7) == 5) {
                    i15 -= popupWindow2.getWidth() - view3.getWidth();
                }
                popupWindow2.showAsDropDown(view3, i15, i16);
            }
            this.arc.setSelection(-1);
            if (!this.arz || this.arc.isInTouchMode()) {
                clearListSelection();
            }
            if (!this.arz) {
                this.mHandler.post(this.arx);
            }
        } else if (u.aD(this.arp)) {
            if (this.akZ == -1) {
                i6 = -1;
            } else if (this.akZ == -2) {
                i6 = this.arp.getWidth();
            } else {
                i6 = this.akZ;
            }
            if (this.ard == -1) {
                if (isInputMethodNotNeeded) {
                    i8 = i4;
                } else {
                    i8 = -1;
                }
                if (isInputMethodNotNeeded) {
                    PopupWindow popupWindow3 = this.arA;
                    if (this.akZ == -1) {
                        i10 = -1;
                    } else {
                        i10 = 0;
                    }
                    popupWindow3.setWidth(i10);
                    this.arA.setHeight(0);
                    i7 = i8;
                } else {
                    PopupWindow popupWindow4 = this.arA;
                    if (this.akZ == -1) {
                        i9 = -1;
                    } else {
                        i9 = 0;
                    }
                    popupWindow4.setWidth(i9);
                    this.arA.setHeight(-1);
                    i7 = i8;
                }
            } else if (this.ard != -2) {
                i7 = this.ard;
            } else {
                i7 = i4;
            }
            PopupWindow popupWindow5 = this.arA;
            if (this.arl || this.ark) {
                z2 = false;
            }
            popupWindow5.setOutsideTouchable(z2);
            PopupWindow popupWindow6 = this.arA;
            View view4 = this.arp;
            int i18 = this.are;
            int i19 = this.arf;
            if (i6 < 0) {
                i6 = -1;
            }
            if (i7 < 0) {
                i7 = -1;
            }
            popupWindow6.update(view4, i18, i19, i6, i7);
        }
    }

    @Override // android.support.v7.view.menu.s
    public final void dismiss() {
        this.arA.dismiss();
        kB();
        this.arA.setContentView(null);
        this.arc = null;
        this.mHandler.removeCallbacks(this.aru);
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.arA.setOnDismissListener(onDismissListener);
    }

    private void kB() {
        if (this.arn != null) {
            ViewParent parent = this.arn.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.arn);
            }
        }
    }

    public final void kC() {
        this.arA.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        y yVar = this.arc;
        if (yVar != null) {
            yVar.setListSelectionHidden(true);
            yVar.requestLayout();
        }
    }

    @Override // android.support.v7.view.menu.s
    public final boolean isShowing() {
        return this.arA.isShowing();
    }

    public final boolean isInputMethodNotNeeded() {
        return this.arA.getInputMethodMode() == 2;
    }

    @Override // android.support.v7.view.menu.s
    public final ListView getListView() {
        return this.arc;
    }

    /* access modifiers changed from: package-private */
    public y i(Context context, boolean z) {
        return new y(context, z);
    }

    public final void kD() {
        this.arj = true;
        this.akK = true;
    }

    /* access modifiers changed from: package-private */
    public class b extends DataSetObserver {
        b() {
        }

        public final void onChanged() {
            if (ListPopupWindow.this.arA.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public final void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        a() {
        }

        public final void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements Runnable {
        e() {
        }

        public final void run() {
            if (ListPopupWindow.this.arc != null && u.aD(ListPopupWindow.this.arc) && ListPopupWindow.this.arc.getCount() > ListPopupWindow.this.arc.getChildCount() && ListPopupWindow.this.arc.getChildCount() <= ListPopupWindow.this.arm) {
                ListPopupWindow.this.arA.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements View.OnTouchListener {
        d() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.arA != null && ListPopupWindow.this.arA.isShowing() && x >= 0 && x < ListPopupWindow.this.arA.getWidth() && y >= 0 && y < ListPopupWindow.this.arA.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.aru, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.aru);
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements AbsListView.OnScrollListener {
        c() {
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.arA.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.aru);
                ListPopupWindow.this.aru.run();
            }
        }
    }

    private int getMaxAvailableHeight(View view, int i2, boolean z) {
        if (ara != null) {
            try {
                return ((Integer) ara.invoke(this.arA, view, Integer.valueOf(i2), Boolean.valueOf(z))).intValue();
            } catch (Exception e2) {
            }
        }
        return this.arA.getMaxAvailableHeight(view, i2);
    }
}
