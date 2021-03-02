package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.b;
import android.support.design.internal.c;
import android.support.design.internal.f;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.view.u;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.R;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] jV = {16842912};
    private static final int[] kh = {-16842910};
    private final int maxWidth;
    private MenuInflater nN;
    private final b th;
    private final c ti;
    a tj;

    public interface a {
        boolean cc();
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vc);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ColorStateList aa;
        int i3;
        boolean z;
        this.ti = new c();
        this.th = new b(context);
        az b2 = f.b(context, attributeSet, a.C0008a.NavigationView, i2, R.style.a3u, new int[0]);
        u.a(this, b2.getDrawable(0));
        if (b2.hasValue(3)) {
            u.l(this, (float) b2.getDimensionPixelSize(3, 0));
        }
        u.e(this, b2.getBoolean(1, false));
        this.maxWidth = b2.getDimensionPixelSize(2, 0);
        if (b2.hasValue(8)) {
            aa = b2.getColorStateList(8);
        } else {
            aa = aa(16842808);
        }
        if (b2.hasValue(9)) {
            i3 = b2.getResourceId(9, 0);
            z = true;
        } else {
            i3 = 0;
            z = false;
        }
        ColorStateList colorStateList = b2.hasValue(10) ? b2.getColorStateList(10) : null;
        if (!z && colorStateList == null) {
            colorStateList = aa(16842806);
        }
        Drawable drawable = b2.getDrawable(5);
        if (b2.hasValue(6)) {
            this.ti.setItemHorizontalPadding(b2.getDimensionPixelSize(6, 0));
        }
        int dimensionPixelSize = b2.getDimensionPixelSize(7, 0);
        this.th.a(new h.a() {
            /* class android.support.design.widget.NavigationView.AnonymousClass1 */

            @Override // android.support.v7.view.menu.h.a
            public final boolean a(h hVar, MenuItem menuItem) {
                return NavigationView.this.tj != null && NavigationView.this.tj.cc();
            }

            @Override // android.support.v7.view.menu.h.a
            public final void b(h hVar) {
            }
        });
        this.ti.id = 1;
        this.ti.a(context, this.th);
        this.ti.setItemIconTintList(aa);
        if (z) {
            this.ti.setItemTextAppearance(i3);
        }
        this.ti.setItemTextColor(colorStateList);
        this.ti.setItemBackground(drawable);
        this.ti.setItemIconPadding(dimensionPixelSize);
        this.th.a(this.ti);
        c cVar = this.ti;
        if (cVar.kY == null) {
            cVar.kY = (NavigationMenuView) cVar.layoutInflater.inflate(R.layout.zi, (ViewGroup) this, false);
            if (cVar.lb == null) {
                cVar.lb = new c.b();
            }
            cVar.kZ = (LinearLayout) cVar.layoutInflater.inflate(R.layout.zf, (ViewGroup) cVar.kY, false);
            cVar.kY.setAdapter(cVar.lb);
        }
        addView(cVar.kY);
        if (b2.hasValue(11)) {
            int resourceId = b2.getResourceId(11, 0);
            this.ti.q(true);
            getMenuInflater().inflate(resourceId, this.th);
            this.ti.q(false);
            this.ti.p(false);
        }
        if (b2.hasValue(4)) {
            int resourceId2 = b2.getResourceId(4, 0);
            c cVar2 = this.ti;
            cVar2.kZ.addView(cVar2.layoutInflater.inflate(resourceId2, (ViewGroup) cVar2.kZ, false));
            cVar2.kY.setPadding(0, 0, 0, cVar2.kY.getPaddingBottom());
        }
        b2.ayy.recycle();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.tl = new Bundle();
        this.th.e(savedState.tl);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.Pm);
        this.th.dispatchRestoreInstanceState(savedState.tl);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.tj = aVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        switch (View.MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.maxWidth), 1073741824);
                break;
            case 0:
                i2 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
                break;
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.support.design.internal.ScrimInsetsFrameLayout
    public final void a(ac acVar) {
        c cVar = this.ti;
        int systemWindowInsetTop = acVar.getSystemWindowInsetTop();
        if (cVar.lg != systemWindowInsetTop) {
            cVar.lg = systemWindowInsetTop;
            if (cVar.kZ.getChildCount() == 0) {
                cVar.kY.setPadding(0, cVar.lg, 0, cVar.kY.getPaddingBottom());
            }
        }
        u.b(cVar.kZ, acVar);
    }

    public Menu getMenu() {
        return this.th;
    }

    public int getHeaderCount() {
        return this.ti.kZ.getChildCount();
    }

    public ColorStateList getItemIconTintList() {
        return this.ti.kT;
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.ti.setItemIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.ti.ld;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.ti.setItemTextColor(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.ti.kA;
    }

    public void setItemBackgroundResource(int i2) {
        setItemBackground(android.support.v4.content.b.l(getContext(), i2));
    }

    public void setItemBackground(Drawable drawable) {
        this.ti.setItemBackground(drawable);
    }

    public int getItemHorizontalPadding() {
        return this.ti.le;
    }

    public void setItemHorizontalPadding(int i2) {
        this.ti.setItemHorizontalPadding(i2);
    }

    public void setItemHorizontalPaddingResource(int i2) {
        this.ti.setItemHorizontalPadding(getResources().getDimensionPixelSize(i2));
    }

    public int getItemIconPadding() {
        return this.ti.lf;
    }

    public void setItemIconPadding(int i2) {
        this.ti.setItemIconPadding(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.ti.setItemIconPadding(getResources().getDimensionPixelSize(i2));
    }

    public void setCheckedItem(int i2) {
        MenuItem findItem = this.th.findItem(i2);
        if (findItem != null) {
            this.ti.d((j) findItem);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.th.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.ti.d((j) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.ti.lb.lk;
    }

    public void setItemTextAppearance(int i2) {
        this.ti.setItemTextAppearance(i2);
    }

    private MenuInflater getMenuInflater() {
        if (this.nN == null) {
            this.nN = new g(getContext());
        }
        return this.nN;
    }

    private ColorStateList aa(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList m = android.support.v7.c.a.a.m(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.g6, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = m.getDefaultColor();
        return new ColorStateList(new int[][]{kh, jV, EMPTY_STATE_SET}, new int[]{m.getColorForState(kh, defaultColor), i3, defaultColor});
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.design.widget.NavigationView.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        public Bundle tl;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.tl = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.tl);
        }
    }
}
