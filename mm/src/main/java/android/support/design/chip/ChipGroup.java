package android.support.design.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.a;
import android.support.design.internal.FlowLayout;
import android.support.design.internal.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.tencent.mm.R;

public class ChipGroup extends FlowLayout {
    private int jA;
    private boolean jB;
    private int ju;
    private int jv;
    private boolean jw;
    private b jx;
    private final a jy;
    private c jz;

    public interface b {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams() {
            super(-2, -2);
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ej);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.jy = new a(this, (byte) 0);
        this.jz = new c(this, (byte) 0);
        this.jA = -1;
        this.jB = false;
        TypedArray a2 = f.a(context, attributeSet, a.C0008a.ChipGroup, i2, R.style.a4i, new int[0]);
        int dimensionPixelOffset = a2.getDimensionPixelOffset(1, 0);
        setChipSpacingHorizontal(a2.getDimensionPixelOffset(2, dimensionPixelOffset));
        setChipSpacingVertical(a2.getDimensionPixelOffset(3, dimensionPixelOffset));
        setSingleLine(a2.getBoolean(4, false));
        setSingleSelection(a2.getBoolean(5, false));
        int resourceId = a2.getResourceId(0, -1);
        if (resourceId != -1) {
            this.jA = resourceId;
        }
        a2.recycle();
        super.setOnHierarchyChangeListener(this.jz);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.jz.jD = onHierarchyChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.jA != -1) {
            c(this.jA, true);
            setCheckedId(this.jA);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                if (this.jA != -1 && this.jw) {
                    c(this.jA, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i2, layoutParams);
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public int getCheckedChipId() {
        if (this.jw) {
            return this.jA;
        }
        return -1;
    }

    public void setOnCheckedChangeListener(b bVar) {
        this.jx = bVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCheckedId(int i2) {
        this.jA = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof Chip) {
            this.jB = true;
            ((Chip) findViewById).setChecked(z);
            this.jB = false;
        }
    }

    public void setChipSpacing(int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingResource(int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public int getChipSpacingHorizontal() {
        return this.ju;
    }

    public void setChipSpacingHorizontal(int i2) {
        if (this.ju != i2) {
            this.ju = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public int getChipSpacingVertical() {
        return this.jv;
    }

    public void setChipSpacingVertical(int i2) {
        if (this.jv != i2) {
            this.jv = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    public void setSingleLine(int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    public void setSingleSelection(boolean z) {
        if (this.jw != z) {
            this.jw = z;
            this.jB = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof Chip) {
                    ((Chip) childAt).setChecked(false);
                }
            }
            this.jB = false;
            setCheckedId(-1);
        }
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    /* access modifiers changed from: package-private */
    public class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        /* synthetic */ a(ChipGroup chipGroup, byte b2) {
            this();
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!ChipGroup.this.jB) {
                int id = compoundButton.getId();
                if (z) {
                    if (!(ChipGroup.this.jA == -1 || ChipGroup.this.jA == id || !ChipGroup.this.jw)) {
                        ChipGroup.this.c(ChipGroup.this.jA, false);
                    }
                    ChipGroup.this.setCheckedId(id);
                } else if (ChipGroup.this.jA == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            }
        }
    }

    class c implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener jD;

        private c() {
        }

        /* synthetic */ c(ChipGroup chipGroup, byte b2) {
            this();
        }

        public final void onChildViewAdded(View view, View view2) {
            int hashCode;
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        hashCode = View.generateViewId();
                    } else {
                        hashCode = view2.hashCode();
                    }
                    view2.setId(hashCode);
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.jy);
            }
            if (this.jD != null) {
                this.jD.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            if (this.jD != null) {
                this.jD.onChildViewRemoved(view, view2);
            }
        }
    }
}
