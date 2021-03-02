package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.a.c;
import android.support.v7.a.a;
import android.support.v7.view.menu.s;
import android.support.v7.widget.c;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.R;

public class ActivityChooserView extends ViewGroup {
    PopupWindow.OnDismissListener afJ;
    private final ImageView ajA;
    final FrameLayout ajB;
    final ImageView ajC;
    private final int ajD;
    android.support.v4.view.b ajE;
    final DataSetObserver ajF;
    private final ViewTreeObserver.OnGlobalLayoutListener ajG;
    private ListPopupWindow ajH;
    boolean ajI;
    int ajJ;
    int ajK;
    final a ajv;
    private final b ajw;
    final View ajx;
    final Drawable ajy;
    final FrameLayout ajz;
    private boolean mIsAttachedToWindow;

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.ajF = new DataSetObserver() {
            /* class android.support.v7.widget.ActivityChooserView.AnonymousClass1 */

            public final void onChanged() {
                super.onChanged();
                ActivityChooserView.this.ajv.notifyDataSetChanged();
            }

            public final void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.ajv.notifyDataSetInvalidated();
            }
        };
        this.ajG = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class android.support.v7.widget.ActivityChooserView.AnonymousClass2 */

            public final void onGlobalLayout() {
                if (!ActivityChooserView.this.iY()) {
                    return;
                }
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                if (ActivityChooserView.this.ajE != null) {
                    ActivityChooserView.this.ajE.J(true);
                }
            }
        };
        this.ajJ = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0040a.ActivityChooserView, i2, 0);
        this.ajJ = obtainStyledAttributes.getInt(1, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.an, (ViewGroup) this, true);
        this.ajw = new b();
        this.ajx = findViewById(R.id.em);
        this.ajy = this.ajx.getBackground();
        this.ajB = (FrameLayout) findViewById(R.id.bl_);
        this.ajB.setOnClickListener(this.ajw);
        this.ajB.setOnLongClickListener(this.ajw);
        this.ajC = (ImageView) this.ajB.findViewById(R.id.dup);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.c6l);
        frameLayout.setOnClickListener(this.ajw);
        frameLayout.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            /* class android.support.v7.widget.ActivityChooserView.AnonymousClass3 */

            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                c a2 = c.a(accessibilityNodeInfo);
                if (Build.VERSION.SDK_INT >= 19) {
                    a2.Ro.setCanOpenPopup(true);
                }
            }
        });
        frameLayout.setOnTouchListener(new ab(frameLayout) {
            /* class android.support.v7.widget.ActivityChooserView.AnonymousClass4 */

            @Override // android.support.v7.widget.ab
            public final s hO() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            /* access modifiers changed from: protected */
            @Override // android.support.v7.widget.ab
            public final boolean hP() {
                ActivityChooserView.this.iW();
                return true;
            }

            /* access modifiers changed from: protected */
            @Override // android.support.v7.widget.ab
            public final boolean iI() {
                ActivityChooserView.this.iX();
                return true;
            }
        });
        this.ajz = frameLayout;
        this.ajA = (ImageView) frameLayout.findViewById(R.id.dup);
        this.ajA.setImageDrawable(drawable);
        this.ajv = new a();
        this.ajv.registerDataSetObserver(new DataSetObserver() {
            /* class android.support.v7.widget.ActivityChooserView.AnonymousClass5 */

            public final void onChanged() {
                super.onChanged();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (activityChooserView.ajv.getCount() > 0) {
                    activityChooserView.ajz.setEnabled(true);
                } else {
                    activityChooserView.ajz.setEnabled(false);
                }
                int iM = activityChooserView.ajv.ajM.iM();
                int historySize = activityChooserView.ajv.ajM.getHistorySize();
                if (iM == 1 || (iM > 1 && historySize > 0)) {
                    activityChooserView.ajB.setVisibility(0);
                    ResolveInfo iN = activityChooserView.ajv.ajM.iN();
                    PackageManager packageManager = activityChooserView.getContext().getPackageManager();
                    activityChooserView.ajC.setImageDrawable(iN.loadIcon(packageManager));
                    if (activityChooserView.ajK != 0) {
                        CharSequence loadLabel = iN.loadLabel(packageManager);
                        activityChooserView.ajB.setContentDescription(activityChooserView.getContext().getString(activityChooserView.ajK, loadLabel));
                    }
                } else {
                    activityChooserView.ajB.setVisibility(8);
                }
                if (activityChooserView.ajB.getVisibility() == 0) {
                    activityChooserView.ajx.setBackgroundDrawable(activityChooserView.ajy);
                } else {
                    activityChooserView.ajx.setBackgroundDrawable(null);
                }
            }
        });
        Resources resources = context.getResources();
        this.ajD = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.mh));
    }

    public void setActivityChooserModel(c cVar) {
        a aVar = this.ajv;
        c cVar2 = ActivityChooserView.this.ajv.ajM;
        if (cVar2 != null && ActivityChooserView.this.isShown()) {
            cVar2.unregisterObserver(ActivityChooserView.this.ajF);
        }
        aVar.ajM = cVar;
        if (cVar != null && ActivityChooserView.this.isShown()) {
            cVar.registerObserver(ActivityChooserView.this.ajF);
        }
        aVar.notifyDataSetChanged();
        if (getListPopupWindow().arA.isShowing()) {
            iX();
            iW();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.ajA.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.ajA.setContentDescription(getContext().getString(i2));
    }

    public void setProvider(android.support.v4.view.b bVar) {
        this.ajE = bVar;
    }

    public final boolean iW() {
        if (getListPopupWindow().arA.isShowing() || !this.mIsAttachedToWindow) {
            return false;
        }
        this.ajI = false;
        bA(this.ajJ);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void bA(int i2) {
        int i3;
        if (this.ajv.ajM == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.ajG);
        boolean z = this.ajB.getVisibility() == 0;
        int iM = this.ajv.ajM.iM();
        if (z) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i2 == Integer.MAX_VALUE || iM <= i3 + i2) {
            this.ajv.setShowFooterView(false);
            this.ajv.bB(i2);
        } else {
            this.ajv.setShowFooterView(true);
            this.ajv.bB(i2 - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.arA.isShowing()) {
            if (this.ajI || !z) {
                this.ajv.g(true, z);
            } else {
                this.ajv.g(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.ajv.iZ(), this.ajD));
            listPopupWindow.show();
            if (this.ajE != null) {
                this.ajE.J(true);
            }
            listPopupWindow.arc.setContentDescription(getContext().getString(R.string.bd));
            listPopupWindow.arc.setSelector(new ColorDrawable(0));
        }
    }

    public final boolean iY() {
        return getListPopupWindow().arA.isShowing();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.ajv.ajM;
        if (cVar != null) {
            cVar.registerObserver(this.ajF);
        }
        this.mIsAttachedToWindow = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.ajv.ajM;
        if (cVar != null) {
            cVar.unregisterObserver(this.ajF);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.ajG);
        }
        if (iY()) {
            iX();
        }
        this.mIsAttachedToWindow = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        View view = this.ajx;
        if (this.ajB.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.ajx.layout(0, 0, i4 - i2, i5 - i3);
        if (!iY()) {
            iX();
        }
    }

    public c getDataModel() {
        return this.ajv.ajM;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.afJ = onDismissListener;
    }

    public void setInitialActivityCount(int i2) {
        this.ajJ = i2;
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.ajK = i2;
    }

    /* access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.ajH == null) {
            this.ajH = new ListPopupWindow(getContext());
            this.ajH.setAdapter(this.ajv);
            this.ajH.arp = this;
            this.ajH.setModal(true);
            this.ajH.ars = this.ajw;
            this.ajH.setOnDismissListener(this.ajw);
        }
        return this.ajH;
    }

    /* access modifiers changed from: package-private */
    public class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            float f2;
            switch (((a) adapterView.getAdapter()).getItemViewType(i2)) {
                case 0:
                    ActivityChooserView.this.iX();
                    if (!ActivityChooserView.this.ajI) {
                        if (!ActivityChooserView.this.ajv.ajO) {
                            i2++;
                        }
                        Intent bz = ActivityChooserView.this.ajv.ajM.bz(i2);
                        if (bz != null) {
                            bz.addFlags(524288);
                            Context context = ActivityChooserView.this.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bz);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "android/support/v7/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v7/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            return;
                        }
                        return;
                    } else if (i2 > 0) {
                        c cVar = ActivityChooserView.this.ajv.ajM;
                        synchronized (cVar.aji) {
                            cVar.iP();
                            c.a aVar = cVar.ajj.get(i2);
                            c.a aVar2 = cVar.ajj.get(0);
                            if (aVar2 != null) {
                                f2 = (aVar2.weight - aVar.weight) + 5.0f;
                            } else {
                                f2 = 1.0f;
                            }
                            cVar.a(new c.C0054c(new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name), System.currentTimeMillis(), f2));
                        }
                        return;
                    } else {
                        return;
                    }
                case 1:
                    ActivityChooserView.this.bA(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final void onClick(View view) {
            if (view == ActivityChooserView.this.ajB) {
                ActivityChooserView.this.iX();
                Intent bz = ActivityChooserView.this.ajv.ajM.bz(ActivityChooserView.this.ajv.ajM.a(ActivityChooserView.this.ajv.ajM.iN()));
                if (bz != null) {
                    bz.addFlags(524288);
                    Context context = ActivityChooserView.this.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bz);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "android/support/v7/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v7/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
            } else if (view == ActivityChooserView.this.ajz) {
                ActivityChooserView.this.ajI = false;
                ActivityChooserView.this.bA(ActivityChooserView.this.ajJ);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.ajB) {
                if (ActivityChooserView.this.ajv.getCount() > 0) {
                    ActivityChooserView.this.ajI = true;
                    ActivityChooserView.this.bA(ActivityChooserView.this.ajJ);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public final void onDismiss() {
            if (ActivityChooserView.this.afJ != null) {
                ActivityChooserView.this.afJ.onDismiss();
            }
            if (ActivityChooserView.this.ajE != null) {
                ActivityChooserView.this.ajE.J(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        c ajM;
        private int ajN = 4;
        boolean ajO;
        private boolean ajP;
        private boolean ajQ;

        a() {
        }

        public final int getItemViewType(int i2) {
            if (!this.ajQ || i2 != getCount() - 1) {
                return 0;
            }
            return 1;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final int getCount() {
            int iM = this.ajM.iM();
            if (!this.ajO && this.ajM.iN() != null) {
                iM--;
            }
            int min = Math.min(iM, this.ajN);
            if (this.ajQ) {
                return min + 1;
            }
            return min;
        }

        public final Object getItem(int i2) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (!this.ajO && this.ajM.iN() != null) {
                        i2++;
                    }
                    return this.ajM.by(i2);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view == null || view.getId() != R.id.ecs) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.ao, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i2);
                    ((ImageView) view.findViewById(R.id.dt5)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(R.id.ipm)).setText(resolveInfo.loadLabel(packageManager));
                    if (!this.ajO || i2 != 0 || !this.ajP) {
                        view.setActivated(false);
                        return view;
                    }
                    view.setActivated(true);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.ao, viewGroup, false);
                    inflate.setId(1);
                    ((TextView) inflate.findViewById(R.id.ipm)).setText(ActivityChooserView.this.getContext().getString(R.string.bc));
                    return inflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final int iZ() {
            int i2 = this.ajN;
            this.ajN = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int i3 = 0;
            View view = null;
            int i4 = 0;
            while (i3 < count) {
                View view2 = getView(i3, view, null);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                i4 = Math.max(i4, view2.getMeasuredWidth());
                i3++;
                view = view2;
            }
            this.ajN = i2;
            return i4;
        }

        public final void bB(int i2) {
            if (this.ajN != i2) {
                this.ajN = i2;
                notifyDataSetChanged();
            }
        }

        public final void setShowFooterView(boolean z) {
            if (this.ajQ != z) {
                this.ajQ = z;
                notifyDataSetChanged();
            }
        }

        public final void g(boolean z, boolean z2) {
            if (this.ajO != z || this.ajP != z2) {
                this.ajO = z;
                this.ajP = z2;
                notifyDataSetChanged();
            }
        }
    }

    public static class InnerLayout extends LinearLayout {
        private static final int[] afR = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            az a2 = az.a(context, attributeSet, afR);
            setBackgroundDrawable(a2.getDrawable(0));
            a2.ayy.recycle();
        }
    }

    public final boolean iX() {
        if (!getListPopupWindow().arA.isShowing()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.ajG);
        return true;
    }
}
