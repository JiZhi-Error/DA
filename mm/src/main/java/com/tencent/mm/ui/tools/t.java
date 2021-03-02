package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMListPopupWindow;

public abstract class t implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    private DialogInterface.OnCancelListener CJj;
    private MMListPopupWindow Pfj;
    private int Pfk = R.style.hy;
    private ViewGroup QwT;
    private PopupWindow.OnDismissListener QwU;
    private boolean QwV = true;
    private View QwW;
    private int QwX;
    private int QwY = 0;
    private int QwZ = 0;
    private float Qxa = 0.0f;
    private float Qxb = 0.0f;
    private ViewTreeObserver afI;
    private int ahi;
    private int dividerHeight;
    protected Context mContext;
    private boolean mLL = false;
    private boolean owx = false;
    private BaseAdapter pXY;
    private int pcA = 0;
    private View qK;

    /* access modifiers changed from: protected */
    public abstract BaseAdapter anl();

    public t(Context context) {
        this.mContext = context;
        Resources resources = context.getResources();
        this.ahi = Math.min((resources.getDisplayMetrics().widthPixels * 4) / 5, resources.getDimensionPixelSize(R.dimen.ix));
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.qK = viewGroup.getChildAt(0);
            } else {
                this.qK = viewGroup;
            }
        }
        this.dividerHeight = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 1.0f);
        this.QwY = resources.getDimensionPixelSize(R.dimen.ir) * 2;
        this.pcA = resources.getDimensionPixelSize(R.dimen.bb);
        this.QwZ = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 36.0f);
        this.pXY = anl();
    }

    public final void CL(boolean z) {
        this.owx = z;
        if (z) {
            this.Pfk = R.style.gb;
        } else {
            this.Pfk = R.style.hy;
        }
    }

    public boolean iv() {
        int fromDPToPix;
        int i2;
        int i3;
        Rect rect = new Rect();
        if (this.mContext instanceof AppCompatActivity) {
            fromDPToPix = ((AppCompatActivity) this.mContext).getSupportActionBar().getHeight();
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 40.0f);
            } else {
                fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 49.0f);
            }
        }
        int aH = at.aH(this.mContext, R.dimen.ct);
        if (this.mContext instanceof Activity) {
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) this.mContext).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height - rect.height() < 0 || iArr[1] <= 200) {
                fromDPToPix += rect.top;
            } else {
                fromDPToPix += height - rect.height();
            }
        }
        this.mLL = isLandscape();
        if (this.Pfj == null) {
            this.Pfj = new MMListPopupWindow(this.mContext, null, 0);
        }
        this.Pfj.setOnDismissListener(this);
        this.Pfj.ars = this;
        this.Pfj.setAdapter(this.pXY);
        this.Pfj.setModal(true);
        this.Pfj.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.cjb));
        this.Pfj.setAnimationStyle(this.Pfk);
        this.Pfj.are = aH;
        this.Pfj.arp = this.qK;
        if (this.qK != null) {
            boolean z = this.afI == null;
            this.afI = this.qK.getViewTreeObserver();
            Log.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", Boolean.valueOf(z));
            if (z) {
                this.afI.addOnGlobalLayoutListener(this);
            }
        }
        this.Pfj.setVerticalOffset(fromDPToPix);
        this.Pfj.owx = this.owx;
        this.Pfj.setContentWidth(Math.min(b(this.pXY), this.ahi));
        this.Pfj.kC();
        if (!(this.Qxa == 0.0f || this.Qxb == 0.0f)) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            boolean z2 = displayMetrics2.widthPixels > displayMetrics2.heightPixels;
            Rect rect2 = new Rect();
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            int height2 = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            if (height2 > rect2.height()) {
                i2 = rect2.height();
            } else {
                i2 = height2;
            }
            if (z2) {
                i3 = (int) (this.Qxb * ((float) i2));
            } else {
                i3 = (int) (this.Qxa * ((float) i2));
            }
            Log.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", Float.valueOf(this.Qxa), Float.valueOf(this.Qxb), Integer.valueOf(rect2.height()), Integer.valueOf(i2), Integer.valueOf(i3));
            int round = Math.round((float) (i3 / this.pcA));
            if (round <= 0 || this.pXY == null) {
                Log.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
            } else {
                int i4 = (this.pcA * round) + this.QwY;
                if (i4 == 0 || i4 >= this.pXY.getCount() * this.pcA) {
                    Log.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", Integer.valueOf(i4), Integer.valueOf(this.pXY.getCount() * this.pcA));
                } else {
                    this.Pfj.ard = ((round - 1) * this.pcA) + this.QwY + this.QwZ;
                }
            }
        }
        if (!(this.Pfj == null || this.QwW == null)) {
            MMListPopupWindow mMListPopupWindow = this.Pfj;
            View view = this.QwW;
            boolean isShowing = mMListPopupWindow.kuK.isShowing();
            if (isShowing) {
                mMListPopupWindow.kB();
            }
            mMListPopupWindow.arn = view;
            if (isShowing) {
                mMListPopupWindow.show();
            }
            this.Pfj.aro = this.QwX;
        }
        this.Pfj.show();
        this.Pfj.ORx.setOnKeyListener(this);
        this.Pfj.ORx.setSelector(new ColorDrawable(this.mContext.getResources().getColor(R.color.ac_)));
        this.Pfj.ORx.setDividerHeight(0);
        this.Pfj.ORx.setVerticalScrollBarEnabled(true);
        this.Pfj.ORx.setHorizontalScrollBarEnabled(false);
        return true;
    }

    private boolean isLandscape() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.Pfj.dismiss();
        }
    }

    private int b(ListAdapter listAdapter) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                view = null;
            } else {
                itemViewType = i3;
            }
            if (this.QwT == null) {
                this.QwT = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i2, view, this.QwT);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i4 = Math.max(i4, view.getMeasuredWidth());
            i2++;
            i3 = itemViewType;
        }
        return i4;
    }

    public void onDismiss() {
        if (this.afI != null) {
            if (!this.afI.isAlive()) {
                this.afI = this.qK.getViewTreeObserver();
            }
            this.afI.removeGlobalOnLayoutListener(this);
            this.afI = null;
        }
        if (this.CJj != null) {
            this.CJj.onCancel(null);
        }
        if (this.QwU != null) {
            this.QwU.onDismiss();
        }
    }

    public final boolean isShowing() {
        return this.Pfj != null && this.Pfj.kuK.isShowing();
    }

    public void onGlobalLayout() {
        Log.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", Boolean.valueOf(isShowing()), Boolean.valueOf(this.qK.isShown()));
        if (isShowing()) {
            View view = this.qK;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing() && this.mLL != isLandscape()) {
                this.Pfj.dismiss();
            }
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        b bVar = new b();
        bVar.bm(view);
        bVar.pH(i2);
        bVar.bm(keyEvent);
        a.b("com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
        Log.v("MicroMsg.SubMenuHelperBase", "onKey");
        if (keyEvent.getAction() == 1 && i2 == 82) {
            dismiss();
            a.a(true, (Object) this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            return true;
        }
        a.a(false, (Object) this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        a.b("com/tencent/mm/ui/tools/SubMenuHelperBase", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        dismiss();
        a.a(this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    }
}
