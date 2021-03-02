package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
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
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.av;

public class MMListPopupWindow {
    private ListAdapter GO;
    private final f ORt;
    private final e ORu;
    private final d ORv;
    private final b ORw;
    public a ORx;
    private int akZ;
    public int ard;
    public int are;
    private int arf;
    private boolean arh;
    private boolean ark;
    public boolean arl;
    int arm;
    public View arn;
    public int aro;
    public View arp;
    private Drawable arq;
    public AdapterView.OnItemClickListener ars;
    private AdapterView.OnItemSelectedListener art;
    private Runnable ary;
    private boolean arz;
    public p kuK;
    private Context mContext;
    private Handler mHandler;
    private DataSetObserver mObserver;
    private Rect mTempRect;
    public boolean owx;

    public MMListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sa);
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(159198);
        this.ORt = new f(this, (byte) 0);
        this.ORu = new e(this, (byte) 0);
        this.ORv = new d(this, (byte) 0);
        this.ORw = new b(this, (byte) 0);
        this.arm = Integer.MAX_VALUE;
        this.ard = -2;
        this.akZ = -2;
        this.ark = false;
        this.arl = false;
        this.aro = 0;
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.owx = false;
        this.mContext = context;
        this.kuK = new p(context);
        this.kuK.setInputMethodMode(1);
        AppMethodBeat.o(159198);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(159199);
        if (this.mObserver == null) {
            this.mObserver = new c(this, (byte) 0);
        } else if (this.GO != null) {
            this.GO.unregisterDataSetObserver(this.mObserver);
        }
        this.GO = listAdapter;
        if (this.GO != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.ORx != null) {
            this.ORx.setAdapter(this.GO);
        }
        AppMethodBeat.o(159199);
    }

    public final void setModal(boolean z) {
        AppMethodBeat.i(159200);
        this.arz = z;
        this.kuK.setFocusable(this.arz);
        AppMethodBeat.o(159200);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        AppMethodBeat.i(159201);
        this.kuK.setBackgroundDrawable(drawable);
        AppMethodBeat.o(159201);
    }

    public final void setAnimationStyle(int i2) {
        AppMethodBeat.i(159202);
        this.kuK.setAnimationStyle(i2);
        AppMethodBeat.o(159202);
    }

    public final void setVerticalOffset(int i2) {
        this.arf = i2;
        this.arh = true;
    }

    public final void setContentWidth(int i2) {
        AppMethodBeat.i(159203);
        Drawable background = this.kuK.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.akZ = this.mTempRect.left + this.mTempRect.right + i2;
            AppMethodBeat.o(159203);
            return;
        }
        this.akZ = i2;
        AppMethodBeat.o(159203);
    }

    public final void dismiss() {
        AppMethodBeat.i(159205);
        this.kuK.dismiss();
        kB();
        this.kuK.setContentView(null);
        this.ORx = null;
        this.mHandler.removeCallbacks(this.ORt);
        AppMethodBeat.o(159205);
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        AppMethodBeat.i(159206);
        this.kuK.setOnDismissListener(onDismissListener);
        AppMethodBeat.o(159206);
    }

    public final void kB() {
        AppMethodBeat.i(159207);
        if (this.arn != null) {
            ViewParent parent = this.arn.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.arn);
            }
        }
        AppMethodBeat.o(159207);
    }

    public final void kC() {
        AppMethodBeat.i(159208);
        this.kuK.setInputMethodMode(2);
        AppMethodBeat.o(159208);
    }

    public final void clearListSelection() {
        AppMethodBeat.i(159209);
        a aVar = this.ORx;
        if (aVar != null) {
            aVar.ana = true;
            aVar.requestLayout();
        }
        AppMethodBeat.o(159209);
    }

    public final boolean isInputMethodNotNeeded() {
        AppMethodBeat.i(159210);
        if (this.kuK.getInputMethodMode() == 2) {
            AppMethodBeat.o(159210);
            return true;
        }
        AppMethodBeat.o(159210);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class a extends ListView {
        private boolean ana;
        private boolean anb;

        /* synthetic */ a(Context context, boolean z, byte b2) {
            this(context, z);
        }

        private a(Context context, boolean z) {
            super(context, null, R.attr.jt);
            AppMethodBeat.i(159184);
            this.anb = z;
            setCacheColorHint(0);
            AppMethodBeat.o(159184);
        }

        public final boolean isInTouchMode() {
            AppMethodBeat.i(159185);
            if ((!this.anb || !this.ana) && !super.isInTouchMode()) {
                AppMethodBeat.o(159185);
                return false;
            }
            AppMethodBeat.o(159185);
            return true;
        }

        public final boolean hasWindowFocus() {
            AppMethodBeat.i(159186);
            if (this.anb || super.hasWindowFocus()) {
                AppMethodBeat.o(159186);
                return true;
            }
            AppMethodBeat.o(159186);
            return false;
        }

        public final boolean isFocused() {
            AppMethodBeat.i(159187);
            if (this.anb || super.isFocused()) {
                AppMethodBeat.o(159187);
                return true;
            }
            AppMethodBeat.o(159187);
            return false;
        }

        public final boolean hasFocus() {
            AppMethodBeat.i(159188);
            if (this.anb || super.hasFocus()) {
                AppMethodBeat.o(159188);
                return true;
            }
            AppMethodBeat.o(159188);
            return false;
        }

        /* access modifiers changed from: package-private */
        public final int eL(int i2, int i3) {
            int makeMeasureSpec;
            AppMethodBeat.i(159189);
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            int dividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                int i4 = listPaddingTop + listPaddingBottom;
                AppMethodBeat.o(159189);
                return i4;
            }
            int i5 = listPaddingTop + listPaddingBottom;
            if (dividerHeight <= 0 || divider == null) {
                dividerHeight = 0;
            }
            int count = adapter.getCount();
            int i6 = 0;
            int i7 = 0;
            View view = null;
            while (i6 < count) {
                int itemViewType = adapter.getItemViewType(i6);
                if (itemViewType != i7) {
                    view = null;
                } else {
                    itemViewType = i7;
                }
                view = adapter.getView(i6, view, this);
                int i8 = view == null ? 0 : view.getLayoutParams().height;
                if (i8 > 0) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                if (view != null) {
                    view.measure(i2, makeMeasureSpec);
                }
                if (i6 > 0) {
                    i5 += dividerHeight;
                }
                if (view != null) {
                    i5 += view.getMeasuredHeight();
                }
                if (i5 >= i3) {
                    AppMethodBeat.o(159189);
                    return i3;
                }
                i6++;
                i7 = itemViewType;
            }
            AppMethodBeat.o(159189);
            return i5;
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends DataSetObserver {
        private c() {
        }

        /* synthetic */ c(MMListPopupWindow mMListPopupWindow, byte b2) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.i(159192);
            if (MMListPopupWindow.this.kuK.isShowing()) {
                MMListPopupWindow.this.show();
            }
            AppMethodBeat.o(159192);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(159193);
            MMListPopupWindow.this.dismiss();
            AppMethodBeat.o(159193);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(MMListPopupWindow mMListPopupWindow, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(159191);
            MMListPopupWindow.this.clearListSelection();
            AppMethodBeat.o(159191);
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(MMListPopupWindow mMListPopupWindow, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(159197);
            if (MMListPopupWindow.this.ORx != null && MMListPopupWindow.this.ORx.getCount() > MMListPopupWindow.this.ORx.getChildCount() && MMListPopupWindow.this.ORx.getChildCount() <= MMListPopupWindow.this.arm) {
                MMListPopupWindow.this.kuK.setInputMethodMode(2);
                MMListPopupWindow.this.show();
            }
            AppMethodBeat.o(159197);
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements View.OnTouchListener {
        private e() {
        }

        /* synthetic */ e(MMListPopupWindow mMListPopupWindow, byte b2) {
            this();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(159196);
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && MMListPopupWindow.this.kuK != null && MMListPopupWindow.this.kuK.isShowing() && x >= 0 && x < MMListPopupWindow.this.kuK.getWidth() && y >= 0 && y < MMListPopupWindow.this.kuK.getHeight()) {
                MMListPopupWindow.this.mHandler.postDelayed(MMListPopupWindow.this.ORt, 250);
            } else if (action == 1) {
                MMListPopupWindow.this.mHandler.removeCallbacks(MMListPopupWindow.this.ORt);
            }
            AppMethodBeat.o(159196);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements AbsListView.OnScrollListener {
        private d() {
        }

        /* synthetic */ d(MMListPopupWindow mMListPopupWindow, byte b2) {
            this();
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AppMethodBeat.i(159194);
            if (!(MMListPopupWindow.this.ORx == null || MMListPopupWindow.this.arn == null || MMListPopupWindow.this.GO == null || MMListPopupWindow.this.ORx == null)) {
                if (MMListPopupWindow.this.ORx.getLastVisiblePosition() != MMListPopupWindow.this.GO.getCount() - 1 || MMListPopupWindow.this.ORx.getChildAt(MMListPopupWindow.this.ORx.getChildCount() - 1) == null || MMListPopupWindow.this.ORx.getChildAt(MMListPopupWindow.this.ORx.getChildCount() - 1).getBottom() > MMListPopupWindow.this.ORx.getHeight()) {
                    MMListPopupWindow.this.arn.setVisibility(0);
                } else {
                    MMListPopupWindow.this.arn.setVisibility(8);
                    AppMethodBeat.o(159194);
                    return;
                }
            }
            AppMethodBeat.o(159194);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(159195);
            if (i2 == 1 && !MMListPopupWindow.this.isInputMethodNotNeeded() && MMListPopupWindow.this.kuK.getContentView() != null) {
                MMListPopupWindow.this.mHandler.removeCallbacks(MMListPopupWindow.this.ORt);
                MMListPopupWindow.this.ORt.run();
            }
            AppMethodBeat.o(159195);
        }
    }

    public final void show() {
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
        AppMethodBeat.i(159204);
        if (this.ORx == null) {
            Context context = this.mContext;
            this.ary = new Runnable() {
                /* class com.tencent.mm.ui.base.MMListPopupWindow.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(159182);
                    View view = MMListPopupWindow.this.arp;
                    if (!(view == null || view.getWindowToken() == null)) {
                        MMListPopupWindow.this.show();
                    }
                    AppMethodBeat.o(159182);
                }
            };
            this.ORx = new a(context, !this.arz, (byte) 0);
            if (this.arq != null) {
                this.ORx.setSelector(this.arq);
            }
            this.ORx.setAdapter(this.GO);
            this.ORx.setOnItemClickListener(this.ars);
            this.ORx.setFocusable(true);
            this.ORx.setFocusableInTouchMode(true);
            this.ORx.setDivider(null);
            this.ORx.setDividerHeight(0);
            this.ORx.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                /* class com.tencent.mm.ui.base.MMListPopupWindow.AnonymousClass2 */

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                    a aVar;
                    AppMethodBeat.i(159183);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMListPopupWindow$2", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    if (!(i2 == -1 || (aVar = MMListPopupWindow.this.ORx) == null)) {
                        aVar.ana = false;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMListPopupWindow$2", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(159183);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.ORx.setOnScrollListener(this.ORv);
            if (this.art != null) {
                this.ORx.setOnItemSelectedListener(this.art);
            }
            View view2 = this.ORx;
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
                        as.e("ListPopupWindow", "Invalid hint position " + this.aro, new Object[0]);
                        break;
                }
                view3.measure(View.MeasureSpec.makeMeasureSpec(this.akZ, Integer.MIN_VALUE), 0);
                view = frameLayout;
            } else {
                view = view2;
            }
            this.kuK.setContentView(view);
            i2 = 0;
        } else {
            View view4 = this.arn;
            if (view4 != null) {
                i2 = view4.getMeasuredHeight();
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.kuK.getBackground();
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
        if (this.kuK.getInputMethodMode() == 2) {
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
            view5.getContext().getResources();
            i4 = av.az(view5.getContext()).y;
        } else {
            i4 = i12;
        }
        int i13 = i4 - i11;
        if (this.kuK.getBackground() != null) {
            this.kuK.getBackground().getPadding(this.mTempRect);
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
            int eL = this.ORx.eL(makeMeasureSpec, i13 - i2);
            if (eL > 0) {
                i2 += i3;
            }
            i5 = i2 + eL;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        if (this.kuK.isShowing()) {
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
                    p pVar = this.kuK;
                    if (this.akZ != -1) {
                        i10 = 0;
                    }
                    pVar.setWindowLayoutMode(i10, 0);
                    i5 = i9;
                } else {
                    this.kuK.setWindowLayoutMode(this.akZ == -1 ? -1 : 0, -1);
                    i5 = i9;
                }
            } else if (this.ard != -2) {
                i5 = this.ard;
            }
            this.kuK.update(i8, i5);
            p pVar2 = this.kuK;
            if (this.arl || this.ark) {
                z2 = false;
            }
            pVar2.setOutsideTouchable(z2);
            if (this.owx) {
                this.kuK.showAtLocation(this.arp, 17, 0, 0);
                AppMethodBeat.o(159204);
                return;
            }
            this.kuK.showAtLocation(this.arp, 53, this.are, this.arf);
            AppMethodBeat.o(159204);
            return;
        }
        if (this.akZ == -1) {
            i6 = -1;
        } else if (this.akZ == -2) {
            this.kuK.setWidth(this.arp.getWidth());
            i6 = 0;
        } else {
            this.kuK.setWidth(this.akZ);
            i6 = 0;
        }
        if (this.ard == -1) {
            i7 = -1;
        } else if (this.ard == -2) {
            this.kuK.setHeight(i5);
            i7 = 0;
        } else {
            this.kuK.setHeight(this.ard);
            i7 = 0;
        }
        this.kuK.setWindowLayoutMode(i6, i7);
        p pVar3 = this.kuK;
        if (this.arl || this.ark) {
            z2 = false;
        }
        pVar3.setOutsideTouchable(z2);
        this.kuK.setTouchInterceptor(this.ORu);
        if (this.owx) {
            this.kuK.showAtLocation(this.arp, 17, 0, 0);
        } else {
            this.kuK.showAtLocation(this.arp, 53, this.are, this.arf);
        }
        this.ORx.setSelection(-1);
        if (!this.arz || this.ORx.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.arz) {
            this.mHandler.post(this.ORw);
        }
        AppMethodBeat.o(159204);
    }
}
