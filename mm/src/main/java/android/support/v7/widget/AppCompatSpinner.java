package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.s;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import com.tencent.mm.R;

public class AppCompatSpinner extends Spinner implements s {
    private static final int[] akV = {16843505};
    private ab aeX;
    private final Context ahr;
    private SpinnerAdapter akW;
    private final boolean akX;
    b akY;
    int akZ;
    private final e akc;
    final Rect mTempRect;

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.zq);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i2, byte b2) {
        this(context, attributeSet, i2, -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatSpinner(android.content.Context r9, android.util.AttributeSet r10, int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 209
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    public Context getPopupContext() {
        if (this.akY != null) {
            return this.ahr;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.akY != null) {
            this.akY.setBackgroundDrawable(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(android.support.v7.c.a.a.l(getPopupContext(), i2));
    }

    public Drawable getPopupBackground() {
        if (this.akY != null) {
            return this.akY.arA.getBackground();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i2) {
        if (this.akY != null) {
            this.akY.setVerticalOffset(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.akY != null) {
            return this.akY.getVerticalOffset();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i2) {
        if (this.akY != null) {
            this.akY.are = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.akY != null) {
            return this.akY.are;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i2) {
        if (this.akY != null) {
            this.akZ = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    public int getDropDownWidth() {
        if (this.akY != null) {
            return this.akZ;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.akX) {
            this.akW = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.akY != null) {
            this.akY.setAdapter(new a(spinnerAdapter, (this.ahr == null ? getContext() : this.ahr).getTheme()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.akY != null && this.akY.arA.isShowing()) {
            this.akY.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aeX == null || !this.aeX.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.akY != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.akY == null) {
            return super.performClick();
        }
        if (!this.akY.arA.isShowing()) {
            this.akY.show();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.akY != null) {
            this.akY.ale = charSequence;
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        if (this.akY != null) {
            return this.akY.ale;
        }
        return super.getPrompt();
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        if (this.akc != null) {
            this.akc.bH(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.akc != null) {
            this.akc.jf();
        }
    }

    @Override // android.support.v4.view.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.akc != null) {
            this.akc.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v4.view.s
    public ColorStateList getSupportBackgroundTintList() {
        if (this.akc != null) {
            return this.akc.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // android.support.v4.view.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.akc != null) {
            this.akc.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v4.view.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.akc != null) {
            return this.akc.getSupportBackgroundTintMode();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.akc != null) {
            this.akc.jg();
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (max2 < min) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
            } else {
                itemViewType = i2;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            max2++;
            i2 = itemViewType;
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.mTempRect);
        return this.mTempRect.left + this.mTempRect.right + i3;
    }

    /* access modifiers changed from: package-private */
    public static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter alc;
        private ListAdapter ald;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.alc = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.ald = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public final int getCount() {
            if (this.alc == null) {
                return 0;
            }
            return this.alc.getCount();
        }

        public final Object getItem(int i2) {
            if (this.alc == null) {
                return null;
            }
            return this.alc.getItem(i2);
        }

        public final long getItemId(int i2) {
            if (this.alc == null) {
                return -1;
            }
            return this.alc.getItemId(i2);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            if (this.alc == null) {
                return null;
            }
            return this.alc.getDropDownView(i2, view, viewGroup);
        }

        public final boolean hasStableIds() {
            return this.alc != null && this.alc.hasStableIds();
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.alc != null) {
                this.alc.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.alc != null) {
                this.alc.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.ald;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public final boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.ald;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        public final int getItemViewType(int i2) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public final boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends ListPopupWindow {
        ListAdapter GO;
        CharSequence ale;
        final Rect alf = new Rect();

        public b(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.arp = AppCompatSpinner.this;
            setModal(true);
            this.aro = 0;
            this.ars = new AdapterView.OnItemClickListener(AppCompatSpinner.this) {
                /* class android.support.v7.widget.AppCompatSpinner.b.AnonymousClass1 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, b.this.GO.getItemId(i2));
                    }
                    b.this.dismiss();
                }
            };
        }

        @Override // android.support.v7.widget.ListPopupWindow
        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.GO = listAdapter;
        }

        /* access modifiers changed from: package-private */
        public final void jn() {
            int i2;
            int i3;
            Drawable background = this.arA.getBackground();
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.mTempRect);
                i2 = bh.d(AppCompatSpinner.this) ? AppCompatSpinner.this.mTempRect.right : -AppCompatSpinner.this.mTempRect.left;
            } else {
                Rect rect = AppCompatSpinner.this.mTempRect;
                AppCompatSpinner.this.mTempRect.right = 0;
                rect.left = 0;
                i2 = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.akZ == -2) {
                int a2 = AppCompatSpinner.this.a((SpinnerAdapter) this.GO, this.arA.getBackground());
                int i4 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left) - AppCompatSpinner.this.mTempRect.right;
                if (a2 <= i4) {
                    i4 = a2;
                }
                setContentWidth(Math.max(i4, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.akZ == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(AppCompatSpinner.this.akZ);
            }
            if (bh.d(AppCompatSpinner.this)) {
                i3 = ((width - paddingRight) - this.akZ) + i2;
            } else {
                i3 = i2 + paddingLeft;
            }
            this.are = i3;
        }

        @Override // android.support.v7.view.menu.s, android.support.v7.widget.ListPopupWindow
        public final void show() {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = this.arA.isShowing();
            jn();
            kC();
            super.show();
            this.arc.setChoiceMode(1);
            int selectedItemPosition = AppCompatSpinner.this.getSelectedItemPosition();
            y yVar = this.arc;
            if (this.arA.isShowing() && yVar != null) {
                yVar.setListSelectionHidden(false);
                yVar.setSelection(selectedItemPosition);
                if (yVar.getChoiceMode() != 0) {
                    yVar.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                final AnonymousClass2 r1 = new ViewTreeObserver.OnGlobalLayoutListener() {
                    /* class android.support.v7.widget.AppCompatSpinner.b.AnonymousClass2 */

                    public final void onGlobalLayout() {
                        boolean z;
                        b bVar = b.this;
                        AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                        if (!u.aD(appCompatSpinner) || !appCompatSpinner.getGlobalVisibleRect(bVar.alf)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            b.this.dismiss();
                            return;
                        }
                        b.this.jn();
                        b.super.show();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r1);
                setOnDismissListener(new PopupWindow.OnDismissListener() {
                    /* class android.support.v7.widget.AppCompatSpinner.b.AnonymousClass3 */

                    public final void onDismiss() {
                        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(r1);
                        }
                    }
                });
            }
        }
    }
}
