package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.design.internal.f;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.u;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.R;

public class BottomNavigationView extends FrameLayout {
    private final BottomNavigationPresenter kD;
    private final h kE;
    private final BottomNavigationMenuView kG;
    private MenuInflater nN;
    private b nO;
    private a nP;

    public interface a {
    }

    public interface b {
        boolean cc();
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ch);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.kD = new BottomNavigationPresenter();
        this.kE = new android.support.design.internal.a(context);
        this.kG = new BottomNavigationMenuView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.kG.setLayoutParams(layoutParams);
        this.kD.kG = this.kG;
        this.kD.id = 1;
        this.kG.setPresenter(this.kD);
        this.kE.a(this.kD);
        this.kD.a(getContext(), this.kE);
        az b2 = f.b(context, attributeSet, a.C0008a.BottomNavigationView, i2, R.style.a3q, 6, 5);
        if (b2.hasValue(4)) {
            this.kG.setIconTintList(b2.getColorStateList(4));
        } else {
            this.kG.setIconTintList(this.kG.bD());
        }
        setItemIconSize(b2.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.yz)));
        if (b2.hasValue(6)) {
            setItemTextAppearanceInactive(b2.getResourceId(6, 0));
        }
        if (b2.hasValue(5)) {
            setItemTextAppearanceActive(b2.getResourceId(5, 0));
        }
        if (b2.hasValue(7)) {
            setItemTextColor(b2.getColorStateList(7));
        }
        if (b2.hasValue(0)) {
            u.l(this, (float) b2.getDimensionPixelSize(0, 0));
        }
        setLabelVisibilityMode(b2.getInteger(8, -1));
        setItemHorizontalTranslationEnabled(b2.getBoolean(2, true));
        this.kG.setItemBackgroundRes(b2.getResourceId(1, 0));
        if (b2.hasValue(9)) {
            int resourceId = b2.getResourceId(9, 0);
            this.kD.kH = true;
            getMenuInflater().inflate(resourceId, this.kE);
            this.kD.kH = false;
            this.kD.p(true);
        }
        b2.ayy.recycle();
        addView(this.kG, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            View view = new View(context);
            view.setBackgroundColor(android.support.v4.content.b.n(context, R.color.l6));
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.z3)));
            addView(view);
        }
        this.kE.a(new h.a() {
            /* class android.support.design.widget.BottomNavigationView.AnonymousClass1 */

            @Override // android.support.v7.view.menu.h.a
            public final boolean a(h hVar, MenuItem menuItem) {
                if (BottomNavigationView.this.nP != null && menuItem.getItemId() == BottomNavigationView.this.getSelectedItemId()) {
                    a unused = BottomNavigationView.this.nP;
                    return true;
                } else if (BottomNavigationView.this.nO == null || BottomNavigationView.this.nO.cc()) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override // android.support.v7.view.menu.h.a
            public final void b(h hVar) {
            }
        });
    }

    public void setOnNavigationItemSelectedListener(b bVar) {
        this.nO = bVar;
    }

    public void setOnNavigationItemReselectedListener(a aVar) {
        this.nP = aVar;
    }

    public Menu getMenu() {
        return this.kE;
    }

    public int getMaxItemCount() {
        return 5;
    }

    public ColorStateList getItemIconTintList() {
        return this.kG.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.kG.setIconTintList(colorStateList);
    }

    public void setItemIconSize(int i2) {
        this.kG.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public int getItemIconSize() {
        return this.kG.getItemIconSize();
    }

    public ColorStateList getItemTextColor() {
        return this.kG.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.kG.setItemTextColor(colorStateList);
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.kG.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i2) {
        this.kG.setItemBackgroundRes(i2);
    }

    public Drawable getItemBackground() {
        return this.kG.getItemBackground();
    }

    public void setItemBackground(Drawable drawable) {
        this.kG.setItemBackground(drawable);
    }

    public int getSelectedItemId() {
        return this.kG.getSelectedItemId();
    }

    public void setSelectedItemId(int i2) {
        MenuItem findItem = this.kE.findItem(i2);
        if (findItem != null && !this.kE.a(findItem, this.kD, 0)) {
            findItem.setChecked(true);
        }
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.kG.getLabelVisibilityMode() != i2) {
            this.kG.setLabelVisibilityMode(i2);
            this.kD.p(false);
        }
    }

    public int getLabelVisibilityMode() {
        return this.kG.getLabelVisibilityMode();
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.kG.setItemTextAppearanceInactive(i2);
    }

    public int getItemTextAppearanceInactive() {
        return this.kG.getItemTextAppearanceInactive();
    }

    public void setItemTextAppearanceActive(int i2) {
        this.kG.setItemTextAppearanceActive(i2);
    }

    public int getItemTextAppearanceActive() {
        return this.kG.getItemTextAppearanceActive();
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.kG.kq != z) {
            this.kG.setItemHorizontalTranslationEnabled(z);
            this.kD.p(false);
        }
    }

    private MenuInflater getMenuInflater() {
        if (this.nN == null) {
            this.nN = new g(getContext());
        }
        return this.nN;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.nR = new Bundle();
        this.kE.e(savedState.nR);
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
        this.kE.dispatchRestoreInstanceState(savedState.nR);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.design.widget.BottomNavigationView.SavedState.AnonymousClass1 */

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
        Bundle nR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.nR = parcel.readBundle(classLoader);
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.nR);
        }
    }
}
