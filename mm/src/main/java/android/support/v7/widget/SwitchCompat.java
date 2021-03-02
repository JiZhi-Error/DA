package android.support.v7.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.u;
import android.support.v4.widget.q;
import android.support.v7.a.a;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.tencent.mm.R;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class SwitchCompat extends CompoundButton {
    private static final Property<SwitchCompat, Float> axK = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        /* class android.support.v7.widget.SwitchCompat.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.ayf);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    };
    private static final int[] jV = {16842912};
    private int asJ;
    private Drawable axL;
    private ColorStateList axM;
    private PorterDuff.Mode axN;
    private boolean axO;
    private boolean axP;
    private Drawable axQ;
    private ColorStateList axR;
    private PorterDuff.Mode axS;
    private boolean axT;
    private boolean axU;
    private int axV;
    private int axW;
    private int axX;
    private boolean axY;
    private CharSequence axZ;
    private CharSequence aya;
    private boolean ayb;
    private int ayc;
    private float ayd;
    private float aye;
    float ayf;
    private int ayg;
    private int ayh;
    private int ayi;
    private int ayj;
    private int ayk;
    private int ayl;
    private int aym;
    private final TextPaint ayn;
    private ColorStateList ayo;
    private Layout ayp;
    private Layout ayq;
    private TransformationMethod ayr;
    ObjectAnimator ays;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a0k);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Typeface typeface;
        Typeface create;
        int i3;
        boolean z;
        float f2;
        this.axM = null;
        this.axN = null;
        this.axO = false;
        this.axP = false;
        this.axR = null;
        this.axS = null;
        this.axT = false;
        this.axU = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.ayn = new TextPaint(1);
        this.ayn.density = getResources().getDisplayMetrics().density;
        az a2 = az.a(context, attributeSet, a.C0040a.SwitchCompat, i2, 0);
        this.axL = a2.getDrawable(2);
        if (this.axL != null) {
            this.axL.setCallback(this);
        }
        this.axQ = a2.getDrawable(11);
        if (this.axQ != null) {
            this.axQ.setCallback(this);
        }
        this.axZ = a2.getText(0);
        this.aya = a2.getText(1);
        this.ayb = a2.getBoolean(3, true);
        this.axV = a2.getDimensionPixelSize(8, 0);
        this.axW = a2.getDimensionPixelSize(5, 0);
        this.axX = a2.getDimensionPixelSize(6, 0);
        this.axY = a2.getBoolean(4, false);
        ColorStateList colorStateList = a2.getColorStateList(9);
        if (colorStateList != null) {
            this.axM = colorStateList;
            this.axO = true;
        }
        PorterDuff.Mode a3 = x.a(a2.getInt(10, -1), null);
        if (this.axN != a3) {
            this.axN = a3;
            this.axP = true;
        }
        if (this.axO || this.axP) {
            mU();
        }
        ColorStateList colorStateList2 = a2.getColorStateList(12);
        if (colorStateList2 != null) {
            this.axR = colorStateList2;
            this.axT = true;
        }
        PorterDuff.Mode a4 = x.a(a2.getInt(13, -1), null);
        if (this.axS != a4) {
            this.axS = a4;
            this.axU = true;
        }
        if (this.axT || this.axU) {
            mT();
        }
        int resourceId = a2.getResourceId(7, 0);
        if (resourceId != 0) {
            az a5 = az.a(context, resourceId, a.C0040a.TextAppearance);
            ColorStateList colorStateList3 = a5.getColorStateList(3);
            if (colorStateList3 != null) {
                this.ayo = colorStateList3;
            } else {
                this.ayo = getTextColors();
            }
            int dimensionPixelSize = a5.getDimensionPixelSize(0, 0);
            if (!(dimensionPixelSize == 0 || ((float) dimensionPixelSize) == this.ayn.getTextSize())) {
                this.ayn.setTextSize((float) dimensionPixelSize);
                requestLayout();
            }
            int i4 = a5.getInt(1, -1);
            int i5 = a5.getInt(2, -1);
            switch (i4) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    typeface = null;
                    break;
            }
            if (i5 > 0) {
                if (typeface == null) {
                    create = Typeface.defaultFromStyle(i5);
                } else {
                    create = Typeface.create(typeface, i5);
                }
                setSwitchTypeface(create);
                if (create != null) {
                    i3 = create.getStyle();
                } else {
                    i3 = 0;
                }
                int i6 = i5 & (i3 ^ -1);
                TextPaint textPaint = this.ayn;
                if ((i6 & 1) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                textPaint.setFakeBoldText(z);
                TextPaint textPaint2 = this.ayn;
                if ((i6 & 2) != 0) {
                    f2 = -0.25f;
                } else {
                    f2 = 0.0f;
                }
                textPaint2.setTextSkewX(f2);
            } else {
                this.ayn.setFakeBoldText(false);
                this.ayn.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (a5.getBoolean(12, false)) {
                this.ayr = new android.support.v7.g.a(getContext());
            } else {
                this.ayr = null;
            }
            a5.ayy.recycle();
        }
        a2.ayy.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.asJ = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.ayn.getTypeface() != null && !this.ayn.getTypeface().equals(typeface)) || (this.ayn.getTypeface() == null && typeface != null)) {
            this.ayn.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i2) {
        this.axX = i2;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.axX;
    }

    public void setSwitchMinWidth(int i2) {
        this.axW = i2;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.axW;
    }

    public void setThumbTextPadding(int i2) {
        this.axV = i2;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.axV;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.axQ != null) {
            this.axQ.setCallback(null);
        }
        this.axQ = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(android.support.v7.c.a.a.l(getContext(), i2));
    }

    public Drawable getTrackDrawable() {
        return this.axQ;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.axR = colorStateList;
        this.axT = true;
        mT();
    }

    public ColorStateList getTrackTintList() {
        return this.axR;
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.axS = mode;
        this.axU = true;
        mT();
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.axS;
    }

    private void mT() {
        if (this.axQ == null) {
            return;
        }
        if (this.axT || this.axU) {
            this.axQ = this.axQ.mutate();
            if (this.axT) {
                android.support.v4.graphics.drawable.a.a(this.axQ, this.axR);
            }
            if (this.axU) {
                android.support.v4.graphics.drawable.a.a(this.axQ, this.axS);
            }
            if (this.axQ.isStateful()) {
                this.axQ.setState(getDrawableState());
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.axL != null) {
            this.axL.setCallback(null);
        }
        this.axL = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(android.support.v7.c.a.a.l(getContext(), i2));
    }

    public Drawable getThumbDrawable() {
        return this.axL;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.axM = colorStateList;
        this.axO = true;
        mU();
    }

    public ColorStateList getThumbTintList() {
        return this.axM;
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.axN = mode;
        this.axP = true;
        mU();
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.axN;
    }

    private void mU() {
        if (this.axL == null) {
            return;
        }
        if (this.axO || this.axP) {
            this.axL = this.axL.mutate();
            if (this.axO) {
                android.support.v4.graphics.drawable.a.a(this.axL, this.axM);
            }
            if (this.axP) {
                android.support.v4.graphics.drawable.a.a(this.axL, this.axN);
            }
            if (this.axL.isStateful()) {
                this.axL.setState(getDrawableState());
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.axY = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.axY;
    }

    public CharSequence getTextOn() {
        return this.axZ;
    }

    public void setTextOn(CharSequence charSequence) {
        this.axZ = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.aya;
    }

    public void setTextOff(CharSequence charSequence) {
        this.aya = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.ayb != z) {
            this.ayb = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.ayb;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        if (this.ayb) {
            if (this.ayp == null) {
                this.ayp = q(this.axZ);
            }
            if (this.ayq == null) {
                this.ayq = q(this.aya);
            }
        }
        Rect rect = this.mTempRect;
        if (this.axL != null) {
            this.axL.getPadding(rect);
            i5 = (this.axL.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.axL.getIntrinsicHeight();
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (this.ayb) {
            i6 = Math.max(this.ayp.getWidth(), this.ayq.getWidth()) + (this.axV * 2);
        } else {
            i6 = 0;
        }
        this.ayi = Math.max(i6, i5);
        if (this.axQ != null) {
            this.axQ.getPadding(rect);
            i7 = this.axQ.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i8 = rect.left;
        int i9 = rect.right;
        if (this.axL != null) {
            Rect r = x.r(this.axL);
            i8 = Math.max(i8, r.left);
            i9 = Math.max(i9, r.right);
        }
        int max = Math.max(this.axW, i8 + (this.ayi * 2) + i9);
        int max2 = Math.max(i7, i4);
        this.ayg = max;
        this.ayh = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.axZ : this.aya;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    private Layout q(CharSequence charSequence) {
        int i2;
        CharSequence transformation = this.ayr != null ? this.ayr.getTransformation(charSequence, this) : charSequence;
        TextPaint textPaint = this.ayn;
        if (transformation != null) {
            i2 = (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.ayn));
        } else {
            i2 = 0;
        }
        return new StaticLayout(transformation, textPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        float f2;
        float f3 = 1.0f;
        boolean z2 = false;
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled()) {
                    if (this.axL != null) {
                        int thumbOffset = getThumbOffset();
                        this.axL.getPadding(this.mTempRect);
                        int i2 = this.ayk - this.mTouchSlop;
                        int i3 = (thumbOffset + this.ayj) - this.mTouchSlop;
                        int i4 = this.ayi + i3 + this.mTempRect.left + this.mTempRect.right + this.mTouchSlop;
                        int i5 = this.aym + this.mTouchSlop;
                        if (x > ((float) i3) && x < ((float) i4) && y > ((float) i2) && y < ((float) i5)) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        this.ayc = 1;
                        this.ayd = x;
                        this.aye = y;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                if (this.ayc != 2) {
                    this.ayc = 0;
                    this.mVelocityTracker.clear();
                    break;
                } else {
                    this.ayc = 0;
                    boolean z3 = motionEvent.getAction() == 1 && isEnabled();
                    boolean isChecked = isChecked();
                    if (z3) {
                        this.mVelocityTracker.computeCurrentVelocity(1000);
                        float xVelocity = this.mVelocityTracker.getXVelocity();
                        z = Math.abs(xVelocity) > ((float) this.asJ) ? bh.d(this) ? xVelocity < 0.0f : xVelocity > 0.0f : getTargetCheckedState();
                    } else {
                        z = isChecked;
                    }
                    if (z != isChecked) {
                        playSoundEffect(0);
                    }
                    setChecked(z);
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.onTouchEvent(obtain);
                    obtain.recycle();
                    super.onTouchEvent(motionEvent);
                    return true;
                }
            case 2:
                switch (this.ayc) {
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f4 = x2 - this.ayd;
                        if (thumbScrollRange != 0) {
                            f2 = f4 / ((float) thumbScrollRange);
                        } else {
                            f2 = f4 > 0.0f ? 1.0f : -1.0f;
                        }
                        if (bh.d(this)) {
                            f2 = -f2;
                        }
                        float f5 = f2 + this.ayf;
                        if (f5 < 0.0f) {
                            f3 = 0.0f;
                        } else if (f5 <= 1.0f) {
                            f3 = f5;
                        }
                        if (f3 == this.ayf) {
                            return true;
                        }
                        this.ayd = x2;
                        setThumbPosition(f3);
                        return true;
                    case 1:
                        float x3 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x3 - this.ayd) > ((float) this.mTouchSlop) || Math.abs(y2 - this.aye) > ((float) this.mTouchSlop)) {
                            this.ayc = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.ayd = x3;
                            this.aye = y2;
                            return true;
                        }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean getTargetCheckedState() {
        return this.ayf > 0.5f;
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float f2) {
        this.ayf = f2;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        float f2 = 1.0f;
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !u.az(this)) {
            if (this.ays != null) {
                this.ays.cancel();
            }
            if (!isChecked) {
                f2 = 0.0f;
            }
            setThumbPosition(f2);
            return;
        }
        if (!isChecked) {
            f2 = 0.0f;
        }
        this.ays = ObjectAnimator.ofFloat(this, axK, f2);
        this.ays.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.ays.setAutoCancel(true);
        }
        this.ays.start();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int height;
        int i10;
        super.onLayout(z, i2, i3, i4, i5);
        if (this.axL != null) {
            Rect rect = this.mTempRect;
            if (this.axQ != null) {
                this.axQ.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect r = x.r(this.axL);
            i7 = Math.max(0, r.left - rect.left);
            i6 = Math.max(0, r.right - rect.right);
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (bh.d(this)) {
            int paddingLeft = getPaddingLeft() + i7;
            i9 = ((this.ayg + paddingLeft) - i7) - i6;
            i8 = paddingLeft;
        } else {
            int width = (getWidth() - getPaddingRight()) - i6;
            i8 = i6 + i7 + (width - this.ayg);
            i9 = width;
        }
        switch (getGravity() & 112) {
            case 16:
                i10 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.ayh / 2);
                height = this.ayh + i10;
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                height = getHeight() - getPaddingBottom();
                i10 = height - this.ayh;
                break;
            default:
                i10 = getPaddingTop();
                height = this.ayh + i10;
                break;
        }
        this.ayj = i8;
        this.ayk = i10;
        this.aym = height;
        this.ayl = i9;
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i2;
        int i3;
        int i4;
        Rect rect2 = this.mTempRect;
        int i5 = this.ayj;
        int i6 = this.ayk;
        int i7 = this.ayl;
        int i8 = this.aym;
        int thumbOffset = i5 + getThumbOffset();
        if (this.axL != null) {
            rect = x.r(this.axL);
        } else {
            rect = x.amQ;
        }
        if (this.axQ != null) {
            this.axQ.getPadding(rect2);
            int i9 = rect2.left + thumbOffset;
            if (rect != null) {
                if (rect.left > rect2.left) {
                    i5 += rect.left - rect2.left;
                }
                if (rect.top > rect2.top) {
                    i4 = (rect.top - rect2.top) + i6;
                } else {
                    i4 = i6;
                }
                if (rect.right > rect2.right) {
                    i7 -= rect.right - rect2.right;
                }
                i3 = rect.bottom > rect2.bottom ? i8 - (rect.bottom - rect2.bottom) : i8;
            } else {
                i3 = i8;
                i4 = i6;
            }
            this.axQ.setBounds(i5, i4, i7, i3);
            i2 = i9;
        } else {
            i2 = thumbOffset;
        }
        if (this.axL != null) {
            this.axL.getPadding(rect2);
            int i10 = i2 - rect2.left;
            int i11 = i2 + this.ayi + rect2.right;
            this.axL.setBounds(i10, i6, i11, i8);
            Drawable background = getBackground();
            if (background != null) {
                android.support.v4.graphics.drawable.a.a(background, i10, i6, i11, i8);
            }
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.axQ;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.ayk;
        int i3 = this.aym;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.axL;
        if (drawable != null) {
            if (!this.axY || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect r = x.r(drawable2);
                drawable2.copyBounds(rect);
                rect.left += r.left;
                rect.right -= r.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.ayp : this.ayq;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.ayo != null) {
                this.ayn.setColor(this.ayo.getColorForState(drawableState, 0));
            }
            this.ayn.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.right + bounds.left;
            } else {
                width = getWidth();
            }
            canvas.translate((float) ((width / 2) - (layout.getWidth() / 2)), (float) (((i4 + i5) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public int getCompoundPaddingLeft() {
        if (!bh.d(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.ayg;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.axX;
        }
        return compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (bh.d(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.ayg;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.axX;
        }
        return compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f2;
        if (bh.d(this)) {
            f2 = 1.0f - this.ayf;
        } else {
            f2 = this.ayf;
        }
        return (int) ((f2 * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        if (this.axQ == null) {
            return 0;
        }
        Rect rect2 = this.mTempRect;
        this.axQ.getPadding(rect2);
        if (this.axL != null) {
            rect = x.r(this.axL);
        } else {
            rect = x.amQ;
        }
        return ((((this.ayg - this.ayi) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, jV);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean z = false;
        Drawable drawable = this.axL;
        if (drawable != null && drawable.isStateful()) {
            z = drawable.setState(drawableState) | false;
        }
        Drawable drawable2 = this.axQ;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        if (this.axL != null) {
            android.support.v4.graphics.drawable.a.a(this.axL, f2, f3);
        }
        if (this.axQ != null) {
            android.support.v4.graphics.drawable.a.a(this.axQ, f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.axL || drawable == this.axQ;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.axL != null) {
            this.axL.jumpToCurrentState();
        }
        if (this.axQ != null) {
            this.axQ.jumpToCurrentState();
        }
        if (this.ays != null && this.ays.isStarted()) {
            this.ays.end();
            this.ays = null;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.axZ : this.aya;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text).append(' ').append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(q.a(this, callback));
    }
}
