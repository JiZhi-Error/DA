package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.tencent.mm.R;

public final class ar extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator avs = new DecelerateInterpolator();
    int ahu;
    Runnable avl;
    LinearLayoutCompat avm;
    private Spinner avn;
    private boolean avo;
    int avp;
    int avq;
    private int avr;

    public final void onMeasure(int i2, int i3) {
        boolean z = true;
        int mode = View.MeasureSpec.getMode(i2);
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.avm.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.avp = -1;
        } else {
            if (childCount > 2) {
                this.avp = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
            } else {
                this.avp = View.MeasureSpec.getSize(i2) / 2;
            }
            this.avp = Math.min(this.avp, this.avq);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.ahu, 1073741824);
        if (z2 || !this.avo) {
            z = false;
        }
        if (z) {
            this.avm.measure(0, makeMeasureSpec);
            if (this.avm.getMeasuredWidth() <= View.MeasureSpec.getSize(i2)) {
                mj();
            } else if (!mi()) {
                if (this.avn == null) {
                    AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.a8);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.avn = appCompatSpinner;
                }
                removeView(this.avm);
                addView(this.avn, new ViewGroup.LayoutParams(-2, -1));
                if (this.avn.getAdapter() == null) {
                    this.avn.setAdapter((SpinnerAdapter) new a());
                }
                if (this.avl != null) {
                    removeCallbacks(this.avl);
                    this.avl = null;
                }
                this.avn.setSelection(this.avr);
            }
        } else {
            mj();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.avr);
        }
    }

    private boolean mi() {
        return this.avn != null && this.avn.getParent() == this;
    }

    public final void setAllowCollapse(boolean z) {
        this.avo = z;
    }

    private boolean mj() {
        if (mi()) {
            removeView(this.avn);
            addView(this.avm, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.avn.getSelectedItemPosition());
        }
        return false;
    }

    public final void setTabSelected(int i2) {
        this.avr = i2;
        int childCount = this.avm.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.avm.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                final View childAt2 = this.avm.getChildAt(i2);
                if (this.avl != null) {
                    removeCallbacks(this.avl);
                }
                this.avl = new Runnable() {
                    /* class android.support.v7.widget.ar.AnonymousClass1 */

                    public final void run() {
                        ar.this.smoothScrollTo(childAt2.getLeft() - ((ar.this.getWidth() - childAt2.getWidth()) / 2), 0);
                        ar.this.avl = null;
                    }
                };
                post(this.avl);
            }
        }
        if (this.avn != null && i2 >= 0) {
            this.avn.setSelection(i2);
        }
    }

    public final void setContentHeight(int i2) {
        this.ahu = i2;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        android.support.v7.view.a ab = android.support.v7.view.a.ab(getContext());
        TypedArray obtainStyledAttributes = ab.mContext.obtainStyledAttributes(null, a.C0040a.ActionBar, R.attr.a1, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(13, 0);
        Resources resources = ab.mContext.getResources();
        if (!ab.hC()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.m4));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.avq = ab.mContext.getResources().getDimensionPixelSize(R.dimen.m5);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.avl != null) {
            post(this.avl);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.avl != null) {
            removeCallbacks(this.avl);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* access modifiers changed from: package-private */
    public class b extends LinearLayout {
        private TextView Ws;
        private ImageView Xx;
        private View ahJ;
        private final int[] avv = {16842964};
        ActionBar.a avw;

        public b(Context context, ActionBar.a aVar) {
            super(context, null, R.attr.a3);
            this.avw = aVar;
            az a2 = az.a(context, null, this.avv, R.attr.a3, 0);
            if (a2.hasValue(0)) {
                setBackgroundDrawable(a2.getDrawable(0));
            }
            a2.ayy.recycle();
            setGravity(8388627);
            update();
        }

        public final void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.a.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
        }

        public final void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (ar.this.avp > 0 && getMeasuredWidth() > ar.this.avp) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(ar.this.avp, 1073741824), i3);
            }
        }

        public final void update() {
            boolean z;
            CharSequence contentDescription;
            ActionBar.a aVar = this.avw;
            View customView = aVar.getCustomView();
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.ahJ = customView;
                if (this.Ws != null) {
                    this.Ws.setVisibility(8);
                }
                if (this.Xx != null) {
                    this.Xx.setVisibility(8);
                    this.Xx.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.ahJ != null) {
                removeView(this.ahJ);
                this.ahJ = null;
            }
            Drawable icon = aVar.getIcon();
            CharSequence text = aVar.getText();
            if (icon != null) {
                if (this.Xx == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.Xx = appCompatImageView;
                }
                this.Xx.setImageDrawable(icon);
                this.Xx.setVisibility(0);
            } else if (this.Xx != null) {
                this.Xx.setVisibility(8);
                this.Xx.setImageDrawable(null);
            }
            if (!TextUtils.isEmpty(text)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this.Ws == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.a4);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.Ws = appCompatTextView;
                }
                this.Ws.setText(text);
                this.Ws.setVisibility(0);
            } else if (this.Ws != null) {
                this.Ws.setVisibility(8);
                this.Ws.setText((CharSequence) null);
            }
            if (this.Xx != null) {
                this.Xx.setContentDescription(aVar.getContentDescription());
            }
            if (z) {
                contentDescription = null;
            } else {
                contentDescription = aVar.getContentDescription();
            }
            bb.a(this, contentDescription);
        }
    }

    class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            return ar.this.avm.getChildCount();
        }

        public final Object getItem(int i2) {
            return ((b) ar.this.avm.getChildAt(i2)).avw;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                ar arVar = ar.this;
                b bVar = new b(arVar.getContext(), (ActionBar.a) getItem(i2));
                bVar.setBackgroundDrawable(null);
                bVar.setLayoutParams(new AbsListView.LayoutParams(-1, arVar.ahu));
                return bVar;
            }
            b bVar2 = (b) view;
            bVar2.avw = (ActionBar.a) getItem(i2);
            bVar2.update();
            return view;
        }
    }
}
