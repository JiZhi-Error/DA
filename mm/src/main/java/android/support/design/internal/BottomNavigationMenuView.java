package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionSet;
import android.support.v4.e.l;
import android.support.v4.view.b.b;
import android.support.v4.view.u;
import android.support.v7.c.a.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;

public class BottomNavigationMenuView extends ViewGroup implements p {
    private static final int[] jV = {16842912};
    private static final int[] kh = {-16842910};
    private Drawable kA;
    private int kB;
    private int[] kC;
    BottomNavigationPresenter kD;
    h kE;
    int ka;
    final TransitionSet ki;
    private final int kj;
    private final int kk;
    private final int kl;
    private final int km;
    private final int kn;
    private final View.OnClickListener ko;
    private final l.a<BottomNavigationItemView> kp;
    public boolean kq;
    BottomNavigationItemView[] kr;
    int ks;
    int kt;
    private ColorStateList ku;
    private int kv;
    private ColorStateList kw;
    private final ColorStateList kx;
    private int ky;
    private int kz;

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kp = new l.c(5);
        this.ks = 0;
        this.kt = 0;
        Resources resources = getResources();
        this.kj = resources.getDimensionPixelSize(R.dimen.z0);
        this.kk = resources.getDimensionPixelSize(R.dimen.z1);
        this.kl = resources.getDimensionPixelSize(R.dimen.yu);
        this.km = resources.getDimensionPixelSize(R.dimen.yv);
        this.kn = resources.getDimensionPixelSize(R.dimen.yy);
        this.kx = bD();
        this.ki = new AutoTransition();
        this.ki.ao(0);
        this.ki.f(115);
        this.ki.b(new b());
        this.ki.c(new e());
        this.ko = new View.OnClickListener() {
            /* class android.support.design.internal.BottomNavigationMenuView.AnonymousClass1 */

            public final void onClick(View view) {
                j itemData = ((BottomNavigationItemView) view).getItemData();
                if (!BottomNavigationMenuView.this.kE.a(itemData, BottomNavigationMenuView.this.kD, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        this.kC = new int[5];
    }

    @Override // android.support.v7.view.menu.p
    public final void a(h hVar) {
        this.kE = hVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6 = 1;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.kE.m1if().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.kn, 1073741824);
        if (!m(this.ka, size2) || !this.kq) {
            if (size2 != 0) {
                i6 = size2;
            }
            int min = Math.min(size / i6, this.kl);
            int i7 = size - (min * size2);
            for (int i8 = 0; i8 < childCount; i8++) {
                if (getChildAt(i8).getVisibility() != 8) {
                    this.kC[i8] = min;
                    if (i7 > 0) {
                        int[] iArr = this.kC;
                        iArr[i8] = iArr[i8] + 1;
                        i7--;
                    }
                } else {
                    this.kC[i8] = 0;
                }
            }
        } else {
            View childAt = getChildAt(this.kt);
            int i9 = this.km;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.kl, Integer.MIN_VALUE), makeMeasureSpec);
                i9 = Math.max(i9, childAt.getMeasuredWidth());
            }
            int i10 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min2 = Math.min(size - (this.kk * i10), Math.min(i9, this.kl));
            int i11 = size - min2;
            if (i10 != 0) {
                i6 = i10;
            }
            int min3 = Math.min(i11 / i6, this.kj);
            int i12 = (size - min2) - (i10 * min3);
            int i13 = 0;
            while (i13 < childCount) {
                if (getChildAt(i13).getVisibility() != 8) {
                    int[] iArr2 = this.kC;
                    if (i13 == this.kt) {
                        i5 = min2;
                    } else {
                        i5 = min3;
                    }
                    iArr2[i13] = i5;
                    if (i12 > 0) {
                        int[] iArr3 = this.kC;
                        iArr3[i13] = iArr3[i13] + 1;
                        i4 = i12 - 1;
                    }
                    i4 = i12;
                } else {
                    this.kC[i13] = 0;
                    i4 = i12;
                }
                i13++;
                i12 = i4;
            }
        }
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.kC[i15], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i14 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i14, View.MeasureSpec.makeMeasureSpec(i14, 1073741824), 0), View.resolveSizeAndState(this.kn, makeMeasureSpec, 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (u.Z(this) == 1) {
                    childAt.layout((i6 - i8) - childAt.getMeasuredWidth(), 0, i6 - i8, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.ku = colorStateList;
        if (this.kr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.kr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.ku;
    }

    public void setItemIconSize(int i2) {
        this.kv = i2;
        if (this.kr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.kr) {
                bottomNavigationItemView.setIconSize(i2);
            }
        }
    }

    public int getItemIconSize() {
        return this.kv;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.kw = colorStateList;
        if (this.kr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.kr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.kw;
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.ky = i2;
        if (this.kr != null) {
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.kr;
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i2);
                if (this.kw != null) {
                    bottomNavigationItemView.setTextColor(this.kw);
                }
            }
        }
    }

    public int getItemTextAppearanceInactive() {
        return this.ky;
    }

    public void setItemTextAppearanceActive(int i2) {
        this.kz = i2;
        if (this.kr != null) {
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.kr;
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i2);
                if (this.kw != null) {
                    bottomNavigationItemView.setTextColor(this.kw);
                }
            }
        }
    }

    public int getItemTextAppearanceActive() {
        return this.kz;
    }

    public void setItemBackgroundRes(int i2) {
        this.kB = i2;
        if (this.kr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.kr) {
                bottomNavigationItemView.setItemBackground(i2);
            }
        }
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.kB;
    }

    public void setItemBackground(Drawable drawable) {
        this.kA = drawable;
        if (this.kr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.kr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public Drawable getItemBackground() {
        if (this.kr == null || this.kr.length <= 0) {
            return this.kA;
        }
        return this.kr[0].getBackground();
    }

    public void setLabelVisibilityMode(int i2) {
        this.ka = i2;
    }

    public int getLabelVisibilityMode() {
        return this.ka;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.kq = z;
    }

    public final ColorStateList bD() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16842808, typedValue, true)) {
            return null;
        }
        ColorStateList m = a.m(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.g6, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = m.getDefaultColor();
        return new ColorStateList(new int[][]{kh, jV, EMPTY_STATE_SET}, new int[]{m.getColorForState(kh, defaultColor), i2, defaultColor});
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.kD = bottomNavigationPresenter;
    }

    public final void bE() {
        removeAllViews();
        if (this.kr != null) {
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.kr;
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.kp.release(bottomNavigationItemView);
                }
            }
        }
        if (this.kE.size() == 0) {
            this.ks = 0;
            this.kt = 0;
            this.kr = null;
            return;
        }
        this.kr = new BottomNavigationItemView[this.kE.size()];
        boolean m = m(this.ka, this.kE.m1if().size());
        for (int i2 = 0; i2 < this.kE.size(); i2++) {
            this.kD.kH = true;
            this.kE.getItem(i2).setCheckable(true);
            this.kD.kH = false;
            BottomNavigationItemView newItem = getNewItem();
            this.kr[i2] = newItem;
            newItem.setIconTintList(this.ku);
            newItem.setIconSize(this.kv);
            newItem.setTextColor(this.kx);
            newItem.setTextAppearanceInactive(this.ky);
            newItem.setTextAppearanceActive(this.kz);
            newItem.setTextColor(this.kw);
            if (this.kA != null) {
                newItem.setItemBackground(this.kA);
            } else {
                newItem.setItemBackground(this.kB);
            }
            newItem.setShifting(m);
            newItem.setLabelVisibilityMode(this.ka);
            newItem.a((j) this.kE.getItem(i2));
            newItem.setItemPosition(i2);
            newItem.setOnClickListener(this.ko);
            addView(newItem);
        }
        this.kt = Math.min(this.kE.size() - 1, this.kt);
        this.kE.getItem(this.kt).setChecked(true);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = this.kp.acquire();
        if (acquire == null) {
            return new BottomNavigationItemView(getContext());
        }
        return acquire;
    }

    public int getSelectedItemId() {
        return this.ks;
    }

    static boolean m(int i2, int i3) {
        return i2 == -1 ? i3 > 3 : i2 == 0;
    }
}
