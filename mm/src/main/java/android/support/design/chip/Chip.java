package android.support.design.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.a.h;
import android.support.design.chip.a;
import android.support.design.d.b;
import android.support.v4.content.a.f;
import android.support.v4.view.a.c;
import android.support.v4.view.u;
import android.support.v4.widget.j;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.mm.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip extends AppCompatCheckBox implements a.AbstractC0009a {
    private static final Rect hZ = new Rect();
    private static final int[] ia = {16842913};
    private final RectF hO;
    private a ib;
    private RippleDrawable ic;
    private View.OnClickListener ie;

    /* renamed from: if  reason: not valid java name */
    private CompoundButton.OnCheckedChangeListener f1if;
    private boolean ig;
    private int ih;
    private boolean ii;
    private boolean ij;
    private boolean ik;
    private final a il;
    private final f.a im;
    private final Rect rect;

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ex);
    }

    public Chip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.ih = Integer.MIN_VALUE;
        this.rect = new Rect();
        this.hO = new RectF();
        this.im = new f.a() {
            /* class android.support.design.chip.Chip.AnonymousClass1 */

            @Override // android.support.v4.content.a.f.a
            public final void a(Typeface typeface) {
                Chip.this.setText(Chip.this.getText());
                Chip.this.requestLayout();
                Chip.this.invalidate();
            }

            @Override // android.support.v4.content.a.f.a
            public final void D(int i2) {
            }
        };
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
            } else {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
        }
        a a2 = a.a(context, attributeSet, i2);
        setChipDrawable(a2);
        this.il = new a(this);
        u.a(this, this.il);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() {
                /* class android.support.design.chip.Chip.AnonymousClass2 */

                @TargetApi(21)
                public final void getOutline(View view, Outline outline) {
                    if (Chip.this.ib != null) {
                        Chip.this.ib.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
        setChecked(this.ig);
        a2.js = false;
        setText(a2.ix);
        setEllipsize(a2.jr);
        setIncludeFontPadding(false);
        if (getTextAppearance() != null) {
            a(getTextAppearance());
        }
        setSingleLine();
        setGravity(8388627);
        bf();
    }

    private void bf() {
        if (!TextUtils.isEmpty(getText()) && this.ib != null) {
            float f2 = this.ib.iO + this.ib.iV + this.ib.iR + this.ib.iS;
            if ((this.ib.iA && this.ib.getChipIcon() != null) || (this.ib.iL != null && this.ib.iK && isChecked())) {
                f2 += this.ib.iP + this.ib.iQ + this.ib.iD;
            }
            if (this.ib.iE && this.ib.getCloseIcon() != null) {
                f2 += this.ib.iT + this.ib.iU + this.ib.iH;
            }
            if (((float) u.ad(this)) != f2) {
                u.d(this, u.ac(this), getPaddingTop(), (int) f2, getPaddingBottom());
            }
        }
    }

    public Drawable getChipDrawable() {
        return this.ib;
    }

    public void setChipDrawable(a aVar) {
        if (this.ib != aVar) {
            a aVar2 = this.ib;
            if (aVar2 != null) {
                aVar2.a((a.AbstractC0009a) null);
            }
            this.ib = aVar;
            this.ib.a(this);
            if (android.support.design.e.a.lH) {
                this.ic = new RippleDrawable(android.support.design.e.a.b(this.ib.hL), this.ib, null);
                this.ib.o(false);
                u.a(this, this.ic);
                return;
            }
            this.ib.o(true);
            u.a(this, this.ib);
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, ia);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (TextUtils.isEmpty(getText()) || this.ib == null || this.ib.js) {
            super.onDraw(canvas);
            return;
        }
        int save = canvas.save();
        a aVar = this.ib;
        float bp = aVar.bp() + getChipStartPadding() + getTextStartPadding();
        if (u.Z(this) != 0) {
            bp = -bp;
        }
        canvas.translate(bp, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void setGravity(int i2) {
        if (i2 == 8388627) {
            super.setGravity(i2);
        }
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setBackgroundColor(int i2) {
        throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundResource(int i2) {
        throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackground(Drawable drawable) {
        if (drawable == this.ib || drawable == this.ic) {
            super.setBackground(drawable);
            return;
        }
        throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == this.ib || drawable == this.ic) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        } else {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        } else {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        } else {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        } else {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        } else {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        } else {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public TextUtils.TruncateAt getEllipsize() {
        if (this.ib != null) {
            return this.ib.jr;
        }
        return null;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.ib != null) {
            if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
                throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
            }
            super.setEllipsize(truncateAt);
            if (this.ib != null) {
                this.ib.jr = truncateAt;
            }
        }
    }

    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    public void setLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i2);
    }

    public void setMinLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i2);
    }

    public void setMaxLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i2);
    }

    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        if (this.ib != null) {
            this.ib.maxWidth = i2;
        }
    }

    @Override // android.support.design.chip.a.AbstractC0009a
    public final void bg() {
        bf();
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setChecked(boolean z) {
        if (this.ib == null) {
            this.ig = z;
        } else if (this.ib.iJ) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && this.f1if != null) {
                this.f1if.onCheckedChanged(this, z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f1if = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.ie = onClickListener;
    }

    public final boolean bh() {
        boolean z;
        playSoundEffect(0);
        if (this.ie != null) {
            this.ie.onClick(this);
            z = true;
        } else {
            z = false;
        }
        this.il.sendEventForVirtualView(0, 1);
        return z;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        switch (actionMasked) {
            case 0:
                if (contains) {
                    setCloseIconPressed(true);
                    z = true;
                    break;
                }
                z = false;
                break;
            case 1:
                if (this.ii) {
                    bh();
                    z = true;
                    setCloseIconPressed(false);
                    break;
                }
                z = false;
                setCloseIconPressed(false);
            case 2:
                if (this.ii) {
                    if (!contains) {
                        setCloseIconPressed(false);
                    }
                    z = true;
                    break;
                }
                z = false;
                break;
            case 3:
                z = false;
                setCloseIconPressed(false);
                break;
            default:
                z = false;
                break;
        }
        return z || super.onTouchEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 7:
                setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
                break;
            case 10:
                setCloseIconHovered(false);
                break;
        }
        return super.onHoverEvent(motionEvent);
    }

    @SuppressLint({"PrivateApi"})
    private boolean d(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = j.class.getDeclaredField("mHoveredVirtualViewId");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.il)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = j.class.getDeclaredMethod("updateHoveredVirtualView", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.il, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e2) {
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return d(motionEvent) || this.il.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.il.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect2) {
        if (z) {
            setFocusedVirtualView(-1);
        } else {
            setFocusedVirtualView(Integer.MIN_VALUE);
        }
        invalidate();
        super.onFocusChanged(z, i2, rect2);
        this.il.onFocusChanged(z, i2, rect2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r7, android.view.KeyEvent r8) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.chip.Chip.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    private boolean n(boolean z) {
        bi();
        if (z) {
            if (this.ih == -1) {
                setFocusedVirtualView(0);
                return true;
            }
        } else if (this.ih == 0) {
            setFocusedVirtualView(-1);
            return true;
        }
        return false;
    }

    private void bi() {
        if (this.ih == Integer.MIN_VALUE) {
            setFocusedVirtualView(-1);
        }
    }

    public void getFocusedRect(Rect rect2) {
        if (this.ih == 0) {
            rect2.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect2);
        }
    }

    private void setFocusedVirtualView(int i2) {
        if (this.ih != i2) {
            if (this.ih == 0) {
                setCloseIconFocused(false);
            }
            this.ih = i2;
            if (i2 == 0) {
                setCloseIconFocused(true);
            }
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.ii != z) {
            this.ii = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z) {
        if (this.ij != z) {
            this.ij = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconFocused(boolean z) {
        if (this.ik != z) {
            this.ik = z;
            refreshDrawableState();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        int i2;
        int i3 = 1;
        boolean z = false;
        super.drawableStateChanged();
        if (this.ib != null && a.b(this.ib.iF)) {
            a aVar = this.ib;
            if (isEnabled()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.ik) {
                i2++;
            }
            if (this.ij) {
                i2++;
            }
            if (this.ii) {
                i2++;
            }
            if (isChecked()) {
                i2++;
            }
            int[] iArr = new int[i2];
            if (isEnabled()) {
                iArr[0] = 16842910;
            } else {
                i3 = 0;
            }
            if (this.ik) {
                iArr[i3] = 16842908;
                i3++;
            }
            if (this.ij) {
                iArr[i3] = 16843623;
                i3++;
            }
            if (this.ii) {
                iArr[i3] = 16842919;
                i3++;
            }
            if (isChecked()) {
                iArr[i3] = 16842913;
            }
            z = aVar.b(iArr);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean bj() {
        return (this.ib == null || this.ib.getCloseIcon() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RectF getCloseIconTouchBounds() {
        this.hO.setEmpty();
        if (bj()) {
            a aVar = this.ib;
            aVar.c(aVar.getBounds(), this.hO);
        }
        return this.hO;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.rect;
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    /* access modifiers changed from: package-private */
    public class a extends j {
        a(Chip chip) {
            super(chip);
        }

        @Override // android.support.v4.widget.j
        public final int getVirtualViewAt(float f2, float f3) {
            return (!Chip.this.bj() || !Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? -1 : 0;
        }

        @Override // android.support.v4.widget.j
        public final void getVisibleVirtualViews(List<Integer> list) {
            if (Chip.this.bj()) {
                list.add(0);
            }
        }

        @Override // android.support.v4.widget.j
        public final void onPopulateNodeForVirtualView(int i2, c cVar) {
            if (Chip.this.bj()) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    cVar.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    Object[] objArr = new Object[1];
                    if (TextUtils.isEmpty(text)) {
                        text = "";
                    }
                    objArr[0] = text;
                    cVar.setContentDescription(context.getString(R.string.f4q, objArr).trim());
                }
                cVar.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                c.a aVar = c.a.Ru;
                if (Build.VERSION.SDK_INT >= 21) {
                    cVar.Ro.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.RX);
                }
                cVar.setEnabled(Chip.this.isEnabled());
                return;
            }
            cVar.setContentDescription("");
            cVar.setBoundsInParent(Chip.hZ);
        }

        @Override // android.support.v4.widget.j
        public final void onPopulateNodeForHost(c cVar) {
            cVar.setCheckable(Chip.this.ib != null && Chip.this.ib.iJ);
            cVar.setClassName(Chip.class.getName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.setText(text);
            } else {
                cVar.setContentDescription(text);
            }
        }

        @Override // android.support.v4.widget.j
        public final boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            if (i3 == 16 && i2 == 0) {
                return Chip.this.bh();
            }
            return false;
        }
    }

    public ColorStateList getChipBackgroundColor() {
        if (this.ib != null) {
            return this.ib.ir;
        }
        return null;
    }

    public void setChipBackgroundColorResource(@android.support.annotation.a int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipBackgroundColor(android.support.v7.c.a.a.m(aVar.context, i2));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        if (this.ib != null) {
            this.ib.setChipBackgroundColor(colorStateList);
        }
    }

    public float getChipMinHeight() {
        if (this.ib != null) {
            return this.ib.is;
        }
        return 0.0f;
    }

    public void setChipMinHeightResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipMinHeight(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setChipMinHeight(float f2) {
        if (this.ib != null) {
            this.ib.setChipMinHeight(f2);
        }
    }

    public float getChipCornerRadius() {
        if (this.ib != null) {
            return this.ib.it;
        }
        return 0.0f;
    }

    public void setChipCornerRadiusResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipCornerRadius(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setChipCornerRadius(float f2) {
        if (this.ib != null) {
            this.ib.setChipCornerRadius(f2);
        }
    }

    public ColorStateList getChipStrokeColor() {
        if (this.ib != null) {
            return this.ib.iu;
        }
        return null;
    }

    public void setChipStrokeColorResource(@android.support.annotation.a int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipStrokeColor(android.support.v7.c.a.a.m(aVar.context, i2));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.ib != null) {
            this.ib.setChipStrokeColor(colorStateList);
        }
    }

    public float getChipStrokeWidth() {
        if (this.ib != null) {
            return this.ib.iw;
        }
        return 0.0f;
    }

    public void setChipStrokeWidthResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipStrokeWidth(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setChipStrokeWidth(float f2) {
        if (this.ib != null) {
            this.ib.setChipStrokeWidth(f2);
        }
    }

    public ColorStateList getRippleColor() {
        if (this.ib != null) {
            return this.ib.hL;
        }
        return null;
    }

    public void setRippleColorResource(@android.support.annotation.a int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setRippleColor(android.support.v7.c.a.a.m(aVar.context, i2));
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.ib != null) {
            this.ib.setRippleColor(colorStateList);
        }
    }

    public CharSequence getText() {
        if (this.ib != null) {
            return this.ib.ix;
        }
        return "";
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.ib != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            CharSequence unicodeWrap = android.support.v4.d.a.fg().unicodeWrap(charSequence);
            if (this.ib.js) {
                unicodeWrap = null;
            }
            super.setText(unicodeWrap, bufferType);
            if (this.ib != null) {
                this.ib.setText(charSequence);
            }
        }
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    private b getTextAppearance() {
        if (this.ib != null) {
            return this.ib.iz;
        }
        return null;
    }

    private void a(b bVar) {
        TextPaint paint = getPaint();
        paint.drawableState = this.ib.getState();
        bVar.b(getContext(), paint, this.im);
    }

    public void setTextAppearanceResource(int i2) {
        if (this.ib != null) {
            this.ib.setTextAppearanceResource(i2);
        }
        setTextAppearance(getContext(), i2);
    }

    public void setTextAppearance(b bVar) {
        if (this.ib != null) {
            this.ib.setTextAppearance(bVar);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(getContext(), getPaint(), this.im);
            a(bVar);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (this.ib != null) {
            this.ib.setTextAppearanceResource(i2);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(context, getPaint(), this.im);
            a(getTextAppearance());
        }
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        if (this.ib != null) {
            this.ib.setTextAppearanceResource(i2);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(getContext(), getPaint(), this.im);
            a(getTextAppearance());
        }
    }

    public void setChipIconVisible(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipIconVisible(aVar.context.getResources().getBoolean(i2));
        }
    }

    public void setChipIconVisible(boolean z) {
        if (this.ib != null) {
            this.ib.setChipIconVisible(z);
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    public Drawable getChipIcon() {
        if (this.ib != null) {
            return this.ib.getChipIcon();
        }
        return null;
    }

    public void setChipIconResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipIcon(android.support.v7.c.a.a.l(aVar.context, i2));
        }
    }

    public void setChipIcon(Drawable drawable) {
        if (this.ib != null) {
            this.ib.setChipIcon(drawable);
        }
    }

    public ColorStateList getChipIconTint() {
        if (this.ib != null) {
            return this.ib.iC;
        }
        return null;
    }

    public void setChipIconTintResource(@android.support.annotation.a int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipIconTint(android.support.v7.c.a.a.m(aVar.context, i2));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        if (this.ib != null) {
            this.ib.setChipIconTint(colorStateList);
        }
    }

    public float getChipIconSize() {
        if (this.ib != null) {
            return this.ib.iD;
        }
        return 0.0f;
    }

    public void setChipIconSizeResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipIconSize(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setChipIconSize(float f2) {
        if (this.ib != null) {
            this.ib.setChipIconSize(f2);
        }
    }

    public void setCloseIconVisible(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setCloseIconVisible(aVar.context.getResources().getBoolean(i2));
        }
    }

    public void setCloseIconVisible(boolean z) {
        if (this.ib != null) {
            this.ib.setCloseIconVisible(z);
        }
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    public Drawable getCloseIcon() {
        if (this.ib != null) {
            return this.ib.getCloseIcon();
        }
        return null;
    }

    public void setCloseIconResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setCloseIcon(android.support.v7.c.a.a.l(aVar.context, i2));
        }
    }

    public void setCloseIcon(Drawable drawable) {
        if (this.ib != null) {
            this.ib.setCloseIcon(drawable);
        }
    }

    public ColorStateList getCloseIconTint() {
        if (this.ib != null) {
            return this.ib.iG;
        }
        return null;
    }

    public void setCloseIconTintResource(@android.support.annotation.a int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setCloseIconTint(android.support.v7.c.a.a.m(aVar.context, i2));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        if (this.ib != null) {
            this.ib.setCloseIconTint(colorStateList);
        }
    }

    public float getCloseIconSize() {
        if (this.ib != null) {
            return this.ib.iH;
        }
        return 0.0f;
    }

    public void setCloseIconSizeResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setCloseIconSize(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setCloseIconSize(float f2) {
        if (this.ib != null) {
            this.ib.setCloseIconSize(f2);
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        if (this.ib != null) {
            a aVar = this.ib;
            if (aVar.iI != charSequence) {
                aVar.iI = android.support.v4.d.a.fg().unicodeWrap(charSequence);
                aVar.invalidateSelf();
            }
        }
    }

    public CharSequence getCloseIconContentDescription() {
        if (this.ib != null) {
            return this.ib.iI;
        }
        return null;
    }

    public void setCheckableResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setCheckable(aVar.context.getResources().getBoolean(i2));
        }
    }

    public void setCheckable(boolean z) {
        if (this.ib != null) {
            this.ib.setCheckable(z);
        }
    }

    public void setCheckedIconVisible(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setCheckedIconVisible(aVar.context.getResources().getBoolean(i2));
        }
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.ib != null) {
            this.ib.setCheckedIconVisible(z);
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    public Drawable getCheckedIcon() {
        if (this.ib != null) {
            return this.ib.iL;
        }
        return null;
    }

    public void setCheckedIconResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setCheckedIcon(android.support.v7.c.a.a.l(aVar.context, i2));
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        if (this.ib != null) {
            this.ib.setCheckedIcon(drawable);
        }
    }

    public h getShowMotionSpec() {
        if (this.ib != null) {
            return this.ib.iM;
        }
        return null;
    }

    public void setShowMotionSpecResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.iM = h.k(aVar.context, i2);
        }
    }

    public void setShowMotionSpec(h hVar) {
        if (this.ib != null) {
            this.ib.iM = hVar;
        }
    }

    public h getHideMotionSpec() {
        if (this.ib != null) {
            return this.ib.iN;
        }
        return null;
    }

    public void setHideMotionSpecResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.iN = h.k(aVar.context, i2);
        }
    }

    public void setHideMotionSpec(h hVar) {
        if (this.ib != null) {
            this.ib.iN = hVar;
        }
    }

    public float getChipStartPadding() {
        if (this.ib != null) {
            return this.ib.iO;
        }
        return 0.0f;
    }

    public void setChipStartPaddingResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipStartPadding(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setChipStartPadding(float f2) {
        if (this.ib != null) {
            this.ib.setChipStartPadding(f2);
        }
    }

    public float getIconStartPadding() {
        if (this.ib != null) {
            return this.ib.iP;
        }
        return 0.0f;
    }

    public void setIconStartPaddingResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setIconStartPadding(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f2) {
        if (this.ib != null) {
            this.ib.setIconStartPadding(f2);
        }
    }

    public float getIconEndPadding() {
        if (this.ib != null) {
            return this.ib.iQ;
        }
        return 0.0f;
    }

    public void setIconEndPaddingResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setIconEndPadding(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setIconEndPadding(float f2) {
        if (this.ib != null) {
            this.ib.setIconEndPadding(f2);
        }
    }

    public float getTextStartPadding() {
        if (this.ib != null) {
            return this.ib.iR;
        }
        return 0.0f;
    }

    public void setTextStartPaddingResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setTextStartPadding(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setTextStartPadding(float f2) {
        if (this.ib != null) {
            this.ib.setTextStartPadding(f2);
        }
    }

    public float getTextEndPadding() {
        if (this.ib != null) {
            return this.ib.iS;
        }
        return 0.0f;
    }

    public void setTextEndPaddingResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setTextEndPadding(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setTextEndPadding(float f2) {
        if (this.ib != null) {
            this.ib.setTextEndPadding(f2);
        }
    }

    public float getCloseIconStartPadding() {
        if (this.ib != null) {
            return this.ib.iT;
        }
        return 0.0f;
    }

    public void setCloseIconStartPaddingResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setCloseIconStartPadding(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        if (this.ib != null) {
            this.ib.setCloseIconStartPadding(f2);
        }
    }

    public float getCloseIconEndPadding() {
        if (this.ib != null) {
            return this.ib.iU;
        }
        return 0.0f;
    }

    public void setCloseIconEndPaddingResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setCloseIconEndPadding(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setCloseIconEndPadding(float f2) {
        if (this.ib != null) {
            this.ib.setCloseIconEndPadding(f2);
        }
    }

    public float getChipEndPadding() {
        if (this.ib != null) {
            return this.ib.iV;
        }
        return 0.0f;
    }

    public void setChipEndPaddingResource(int i2) {
        if (this.ib != null) {
            a aVar = this.ib;
            aVar.setChipEndPadding(aVar.context.getResources().getDimension(i2));
        }
    }

    public void setChipEndPadding(float f2) {
        if (this.ib != null) {
            this.ib.setChipEndPadding(f2);
        }
    }
}
