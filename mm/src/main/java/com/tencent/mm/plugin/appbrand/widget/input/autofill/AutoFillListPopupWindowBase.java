package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Locale;

public class AutoFillListPopupWindowBase {
    ListAdapter GO;
    int akZ;
    PopupWindow arA;
    int ard;
    int are;
    int arf;
    boolean arh;
    boolean ark;
    boolean arl;
    int arm;
    private View arn;
    private int aro;
    View arp;
    private Drawable arq;
    private AdapterView.OnItemClickListener ars;
    private AdapterView.OnItemSelectedListener art;
    private Runnable ary;
    boolean arz;
    private Context mContext;
    private MMHandler mHandler;
    DataSetObserver mObserver;
    private Rect mTempRect;
    a ows;
    private final f owt;
    private final e owu;
    private final d owv;
    private final b oww;
    private boolean owx;

    public AutoFillListPopupWindowBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sa);
    }

    public AutoFillListPopupWindowBase(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(136663);
        this.ard = -2;
        this.akZ = -2;
        this.ark = false;
        this.arl = false;
        this.arm = Integer.MAX_VALUE;
        this.aro = 0;
        this.owt = new f(this, (byte) 0);
        this.owu = new e(this, (byte) 0);
        this.owv = new d(this, (byte) 0);
        this.oww = new b(this, (byte) 0);
        this.mHandler = new MMHandler();
        this.mTempRect = new Rect();
        this.owx = false;
        this.mContext = context;
        this.arA = new PopupWindow(context);
        this.arA.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
        AppMethodBeat.o(136663);
    }

    public final void setVerticalOffset(int i2) {
        this.arf = i2;
        this.arh = true;
    }

    public final void dismiss() {
        AppMethodBeat.i(136665);
        this.arA.dismiss();
        kB();
        this.arA.setContentView(null);
        this.ows = null;
        this.mHandler.removeCallbacks(this.owt);
        AppMethodBeat.o(136665);
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        AppMethodBeat.i(136666);
        this.arA.setOnDismissListener(onDismissListener);
        AppMethodBeat.o(136666);
    }

    private void kB() {
        AppMethodBeat.i(136667);
        if (this.arn != null) {
            ViewParent parent = this.arn.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.arn);
            }
        }
        AppMethodBeat.o(136667);
    }

    public final void clearListSelection() {
        AppMethodBeat.i(136668);
        a aVar = this.ows;
        if (aVar != null) {
            aVar.ana = true;
            aVar.requestLayout();
        }
        AppMethodBeat.o(136668);
    }

    public final boolean isInputMethodNotNeeded() {
        AppMethodBeat.i(136669);
        if (this.arA.getInputMethodMode() == 2) {
            AppMethodBeat.o(136669);
            return true;
        }
        AppMethodBeat.o(136669);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class a extends ListView {
        private boolean ana;
        private boolean anb;

        public a(Context context, boolean z) {
            super(context, null, R.attr.jt);
            AppMethodBeat.i(136649);
            this.anb = z;
            setCacheColorHint(0);
            AppMethodBeat.o(136649);
        }

        public final boolean isInTouchMode() {
            AppMethodBeat.i(136650);
            if ((!this.anb || !this.ana) && !super.isInTouchMode()) {
                AppMethodBeat.o(136650);
                return false;
            }
            AppMethodBeat.o(136650);
            return true;
        }

        public final boolean hasWindowFocus() {
            AppMethodBeat.i(136651);
            if (this.anb || super.hasWindowFocus()) {
                AppMethodBeat.o(136651);
                return true;
            }
            AppMethodBeat.o(136651);
            return false;
        }

        public final boolean isFocused() {
            AppMethodBeat.i(136652);
            if (this.anb || super.isFocused()) {
                AppMethodBeat.o(136652);
                return true;
            }
            AppMethodBeat.o(136652);
            return false;
        }

        public final boolean hasFocus() {
            AppMethodBeat.i(136653);
            if (this.anb || super.hasFocus()) {
                AppMethodBeat.o(136653);
                return true;
            }
            AppMethodBeat.o(136653);
            return false;
        }

        /* access modifiers changed from: package-private */
        public final int eL(int i2, int i3) {
            int makeMeasureSpec;
            int i4;
            AppMethodBeat.i(136654);
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            getListPaddingLeft();
            getListPaddingRight();
            int dividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                int i5 = listPaddingTop + listPaddingBottom;
                AppMethodBeat.o(136654);
                return i5;
            }
            int i6 = listPaddingBottom + listPaddingTop;
            if (dividerHeight <= 0 || divider == null) {
                dividerHeight = 0;
            }
            int count = adapter.getCount();
            int i7 = 0;
            View view = null;
            for (int i8 = 0; i8 < count; i8++) {
                int itemViewType = adapter.getItemViewType(i8);
                if (itemViewType != i7) {
                    i7 = itemViewType;
                    view = null;
                }
                view = adapter.getView(i8, view, this);
                int i9 = view.getLayoutParams().height;
                if (i9 > 0) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                view.measure(i2, makeMeasureSpec);
                if (i8 > 0) {
                    i4 = i6 + dividerHeight;
                } else {
                    i4 = i6;
                }
                i6 = view.getMeasuredHeight() + i4;
                if (i6 >= i3) {
                    AppMethodBeat.o(136654);
                    return i3;
                }
            }
            AppMethodBeat.o(136654);
            return i6;
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends DataSetObserver {
        private c() {
        }

        /* synthetic */ c(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b2) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.i(136657);
            if (AutoFillListPopupWindowBase.this.arA.isShowing()) {
                AutoFillListPopupWindowBase.this.show();
            }
            AppMethodBeat.o(136657);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(136658);
            AutoFillListPopupWindowBase.this.dismiss();
            AppMethodBeat.o(136658);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(136656);
            AutoFillListPopupWindowBase.this.clearListSelection();
            AppMethodBeat.o(136656);
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(136662);
            if (AutoFillListPopupWindowBase.this.ows != null && AutoFillListPopupWindowBase.this.ows.getCount() > AutoFillListPopupWindowBase.this.ows.getChildCount() && AutoFillListPopupWindowBase.this.ows.getChildCount() <= AutoFillListPopupWindowBase.this.arm) {
                AutoFillListPopupWindowBase.this.arA.setInputMethodMode(2);
                AutoFillListPopupWindowBase.this.show();
            }
            AppMethodBeat.o(136662);
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements View.OnTouchListener {
        private e() {
        }

        /* synthetic */ e(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b2) {
            this();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(136661);
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && AutoFillListPopupWindowBase.this.arA != null && AutoFillListPopupWindowBase.this.arA.isShowing() && x >= 0 && x < AutoFillListPopupWindowBase.this.arA.getWidth() && y >= 0 && y < AutoFillListPopupWindowBase.this.arA.getHeight()) {
                AutoFillListPopupWindowBase.this.mHandler.postDelayed(AutoFillListPopupWindowBase.this.owt, 250);
            } else if (action == 1) {
                AutoFillListPopupWindowBase.this.mHandler.removeCallbacks(AutoFillListPopupWindowBase.this.owt);
            }
            AppMethodBeat.o(136661);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements AbsListView.OnScrollListener {
        private d() {
        }

        /* synthetic */ d(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b2) {
            this();
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AppMethodBeat.i(136659);
            if (!(AutoFillListPopupWindowBase.this.ows == null || AutoFillListPopupWindowBase.this.arn == null || AutoFillListPopupWindowBase.this.GO == null || AutoFillListPopupWindowBase.this.ows == null)) {
                if (AutoFillListPopupWindowBase.this.ows.getLastVisiblePosition() != AutoFillListPopupWindowBase.this.GO.getCount() - 1 || AutoFillListPopupWindowBase.this.ows.getChildAt(AutoFillListPopupWindowBase.this.ows.getChildCount() - 1) == null || AutoFillListPopupWindowBase.this.ows.getChildAt(AutoFillListPopupWindowBase.this.ows.getChildCount() - 1).getBottom() > AutoFillListPopupWindowBase.this.ows.getHeight()) {
                    AutoFillListPopupWindowBase.this.arn.setVisibility(0);
                } else {
                    AutoFillListPopupWindowBase.this.arn.setVisibility(8);
                    AppMethodBeat.o(136659);
                    return;
                }
            }
            AppMethodBeat.o(136659);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(136660);
            if (i2 == 1 && !AutoFillListPopupWindowBase.this.isInputMethodNotNeeded() && AutoFillListPopupWindowBase.this.arA.getContentView() != null) {
                AutoFillListPopupWindowBase.this.mHandler.removeCallbacks(AutoFillListPopupWindowBase.this.owt);
                AutoFillListPopupWindowBase.this.owt.run();
            }
            AppMethodBeat.o(136660);
        }
    }

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
        int makeMeasureSpec;
        View view;
        boolean z2 = true;
        int i10 = -1;
        AppMethodBeat.i(136664);
        if (this.ows == null) {
            Context context = this.mContext;
            this.ary = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(136647);
                    View view = AutoFillListPopupWindowBase.this.arp;
                    if (!(view == null || view.getWindowToken() == null)) {
                        AutoFillListPopupWindowBase.this.show();
                    }
                    AppMethodBeat.o(136647);
                }
            };
            this.ows = new a(context, !this.arz);
            if (this.arq != null) {
                this.ows.setSelector(this.arq);
            }
            this.ows.setAdapter(this.GO);
            this.ows.setOnItemClickListener(this.ars);
            this.ows.setFocusable(true);
            this.ows.setFocusableInTouchMode(true);
            this.ows.setDivider(null);
            this.ows.setDividerHeight(0);
            this.ows.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.AnonymousClass2 */

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                    a aVar;
                    AppMethodBeat.i(136648);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillListPopupWindowBase$2", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    if (!(i2 == -1 || (aVar = AutoFillListPopupWindowBase.this.ows) == null)) {
                        aVar.ana = false;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillListPopupWindowBase$2", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(136648);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.ows.setOnScrollListener(this.owv);
            if (this.art != null) {
                this.ows.setOnItemSelectedListener(this.art);
            }
            View view2 = this.ows;
            View view3 = this.arn;
            if (view3 != null) {
                kB();
                FrameLayout frameLayout = new FrameLayout(context);
                ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                switch (this.aro) {
                    case 0:
                        layoutParams2.gravity = 48;
                        frameLayout.addView(view2, layoutParams);
                        frameLayout.addView(view3, layoutParams2);
                        break;
                    case 1:
                        layoutParams2.gravity = 80;
                        frameLayout.addView(view2, layoutParams);
                        frameLayout.addView(view3, layoutParams2);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.aro);
                        break;
                }
                view3.measure(View.MeasureSpec.makeMeasureSpec(this.akZ, Integer.MIN_VALUE), 0);
                view = frameLayout;
            } else {
                view = view2;
            }
            this.arA.setContentView(view);
            i2 = 0;
        } else {
            this.arA.getContentView();
            View view4 = this.arn;
            if (view4 != null) {
                i2 = view4.getMeasuredHeight();
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.arA.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            i3 = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.arh) {
                this.arf = -this.mTempRect.top;
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
        View view5 = this.arp;
        int i11 = this.arf;
        Rect rect = new Rect();
        view5.getWindowVisibleDisplayFrame(rect);
        view5.getLocationOnScreen(new int[2]);
        int i12 = rect.bottom;
        if (z) {
            i4 = view5.getContext().getResources().getDisplayMetrics().heightPixels;
        } else {
            i4 = i12;
        }
        int i13 = i4 - i11;
        if (this.arA.getBackground() != null) {
            this.arA.getBackground().getPadding(this.mTempRect);
            i13 -= this.mTempRect.top + this.mTempRect.bottom;
        }
        if (this.ark || this.ard == -1) {
            i5 = i13 + i3;
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
            int eL = this.ows.eL(makeMeasureSpec, i13 - i2);
            if (eL > 0) {
                i2 += i3;
            }
            i5 = i2 + eL;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        if (this.arA.isShowing()) {
            if (this.akZ == -1) {
                i8 = -1;
            } else if (this.akZ == -2) {
                i8 = this.arp.getWidth();
            } else {
                i8 = this.akZ;
            }
            if (this.ard == -1) {
                if (isInputMethodNotNeeded) {
                    i9 = i5;
                } else {
                    i9 = -1;
                }
                if (isInputMethodNotNeeded) {
                    PopupWindow popupWindow = this.arA;
                    if (this.akZ != -1) {
                        i10 = 0;
                    }
                    popupWindow.setWindowLayoutMode(i10, 0);
                    i5 = i9;
                } else {
                    this.arA.setWindowLayoutMode(this.akZ == -1 ? -1 : 0, -1);
                    i5 = i9;
                }
            } else if (this.ard != -2) {
                i5 = this.ard;
            }
            this.arA.update(i8, i5);
            PopupWindow popupWindow2 = this.arA;
            if (this.arl || this.ark) {
                z2 = false;
            }
            popupWindow2.setOutsideTouchable(z2);
            if (this.owx) {
                this.arA.showAtLocation(this.arp, 17, 0, 0);
                AppMethodBeat.o(136664);
                return;
            }
            this.arA.update(this.arp, this.are, this.arf, this.arA.getWidth(), this.arA.getHeight());
            AppMethodBeat.o(136664);
            return;
        }
        if (this.akZ == -1) {
            i6 = -1;
        } else if (this.akZ == -2) {
            this.arA.setWidth(this.arp.getWidth());
            i6 = 0;
        } else {
            this.arA.setWidth(this.akZ);
            i6 = 0;
        }
        if (this.ard == -1) {
            i7 = -1;
        } else if (this.ard == -2) {
            this.arA.setHeight(i5);
            i7 = 0;
        } else {
            this.arA.setHeight(this.ard);
            i7 = 0;
        }
        this.arA.setWindowLayoutMode(i6, i7);
        PopupWindow popupWindow3 = this.arA;
        if (this.arl || this.ark) {
            z2 = false;
        }
        popupWindow3.setOutsideTouchable(z2);
        this.arA.setTouchInterceptor(this.owu);
        if (this.owx) {
            this.arA.showAtLocation(this.arp, 17, 0, 0);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.arA.showAsDropDown(this.arp, this.are, this.arf, 53);
        } else {
            this.arA.showAtLocation(this.arp, 53, this.are, this.arf);
        }
        this.ows.setSelection(-1);
        if (!this.arz || this.ows.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.arz) {
            this.mHandler.post(this.oww);
        }
        AppMethodBeat.o(136664);
    }
}
