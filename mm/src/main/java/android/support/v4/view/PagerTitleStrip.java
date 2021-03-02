package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.q;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.a
public class PagerTitleStrip extends ViewGroup {
    private static final int[] QA = {16842804, 16842901, 16842904, 16842927};
    private static final int[] QB = {16843660};
    private int Ku;
    private int QC;
    int QD;
    ViewPager Qp;
    TextView Qq;
    TextView Qr;
    TextView Qs;
    private int Qt = -1;
    float Qu = -1.0f;
    private int Qv;
    private boolean Qw;
    private boolean Qx;
    private final a Qy = new a();
    private WeakReference<q> Qz;

    /* access modifiers changed from: package-private */
    public static class b extends SingleLineTransformationMethod {
        private Locale QF;

        b(Context context) {
            this.QF = context.getResources().getConfiguration().locale;
        }

        public final CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.QF);
            }
            return null;
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = false;
        TextView textView = new TextView(context);
        this.Qq = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.Qr = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.Qs = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, QA);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            q.d(this.Qq, resourceId);
            q.d(this.Qr, resourceId);
            q.d(this.Qs, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f2 = (float) dimensionPixelSize;
            this.Qq.setTextSize(0, f2);
            this.Qr.setTextSize(0, f2);
            this.Qs.setTextSize(0, f2);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.Qq.setTextColor(color);
            this.Qr.setTextColor(color);
            this.Qs.setTextColor(color);
        }
        this.Ku = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.QD = this.Qr.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.Qq.setEllipsize(TextUtils.TruncateAt.END);
        this.Qr.setEllipsize(TextUtils.TruncateAt.END);
        this.Qs.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, QB);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.Qq);
            setSingleLineAllCaps(this.Qr);
            setSingleLineAllCaps(this.Qs);
        } else {
            this.Qq.setSingleLine();
            this.Qr.setSingleLine();
            this.Qs.setSingleLine();
        }
        this.Qv = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i2) {
        this.Qv = i2;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.Qv;
    }

    public void setNonPrimaryAlpha(float f2) {
        this.QC = ((int) (255.0f * f2)) & 255;
        int i2 = (this.QC << 24) | (this.QD & 16777215);
        this.Qq.setTextColor(i2);
        this.Qs.setTextColor(i2);
    }

    public void setTextColor(int i2) {
        this.QD = i2;
        this.Qr.setTextColor(i2);
        int i3 = (this.QC << 24) | (this.QD & 16777215);
        this.Qq.setTextColor(i3);
        this.Qs.setTextColor(i3);
    }

    public void setGravity(int i2) {
        this.Ku = i2;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        q adapter = viewPager.getAdapter();
        viewPager.setInternalPageChangeListener(this.Qy);
        viewPager.addOnAdapterChangeListener(this.Qy);
        this.Qp = viewPager;
        a(this.Qz != null ? this.Qz.get() : null, adapter);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Qp != null) {
            a(this.Qp.getAdapter(), (q) null);
            this.Qp.setInternalPageChangeListener(null);
            this.Qp.removeOnAdapterChangeListener(this.Qy);
            this.Qp = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, q qVar) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3 = null;
        int count = qVar != null ? qVar.getCount() : 0;
        this.Qw = true;
        if (i2 <= 0 || qVar == null) {
            charSequence = null;
        } else {
            charSequence = qVar.getPageTitle(i2 - 1);
        }
        this.Qq.setText(charSequence);
        TextView textView = this.Qr;
        if (qVar == null || i2 >= count) {
            charSequence2 = null;
        } else {
            charSequence2 = qVar.getPageTitle(i2);
        }
        textView.setText(charSequence2);
        if (i2 + 1 < count && qVar != null) {
            charSequence3 = qVar.getPageTitle(i2 + 1);
        }
        this.Qs.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.Qq.measure(makeMeasureSpec, makeMeasureSpec2);
        this.Qr.measure(makeMeasureSpec, makeMeasureSpec2);
        this.Qs.measure(makeMeasureSpec, makeMeasureSpec2);
        this.Qt = i2;
        if (!this.Qx) {
            a(i2, this.Qu, false);
        }
        this.Qw = false;
    }

    public void requestLayout() {
        if (!this.Qw) {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(q qVar, q qVar2) {
        if (qVar != null) {
            qVar.unregisterDataSetObserver(this.Qy);
            this.Qz = null;
        }
        if (qVar2 != null) {
            qVar2.registerDataSetObserver(this.Qy);
            this.Qz = new WeakReference<>(qVar2);
        }
        if (this.Qp != null) {
            this.Qt = -1;
            this.Qu = -1.0f;
            a(this.Qp.getCurrentItem(), qVar2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (i2 != this.Qt) {
            a(i2, this.Qp.getAdapter());
        } else if (!z && f2 == this.Qu) {
            return;
        }
        this.Qx = true;
        int measuredWidth = this.Qq.getMeasuredWidth();
        int measuredWidth2 = this.Qr.getMeasuredWidth();
        int measuredWidth3 = this.Qs.getMeasuredWidth();
        int i6 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i7 = paddingRight + i6;
        int i8 = (width - (paddingLeft + i6)) - i7;
        float f3 = 0.5f + f2;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i9 = ((width - i7) - ((int) (f3 * ((float) i8)))) - i6;
        int i10 = i9 + measuredWidth2;
        int baseline = this.Qq.getBaseline();
        int baseline2 = this.Qr.getBaseline();
        int baseline3 = this.Qs.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i11 = max - baseline;
        int i12 = max - baseline2;
        int i13 = max - baseline3;
        int max2 = Math.max(Math.max(this.Qq.getMeasuredHeight() + i11, this.Qr.getMeasuredHeight() + i12), this.Qs.getMeasuredHeight() + i13);
        switch (this.Ku & 112) {
            case 16:
                int i14 = (((height - paddingTop) - paddingBottom) - max2) / 2;
                i3 = i14 + i11;
                i4 = i14 + i12;
                i5 = i14 + i13;
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                int i15 = (height - paddingBottom) - max2;
                i3 = i15 + i11;
                i4 = i15 + i12;
                i5 = i15 + i13;
                break;
            default:
                i3 = paddingTop + i11;
                i4 = paddingTop + i12;
                i5 = paddingTop + i13;
                break;
        }
        this.Qr.layout(i9, i4, i10, this.Qr.getMeasuredHeight() + i4);
        int min = Math.min(paddingLeft, (i9 - this.Qv) - measuredWidth);
        this.Qq.layout(min, i3, measuredWidth + min, this.Qq.getMeasuredHeight() + i3);
        int max3 = Math.max((width - paddingRight) - measuredWidth3, this.Qv + i10);
        this.Qs.layout(max3, i5, max3 + measuredWidth3, this.Qs.getMeasuredHeight() + i5);
        this.Qu = f2;
        this.Qx = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int max;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i3, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i2);
        int childMeasureSpec2 = getChildMeasureSpec(i2, (int) (((float) size) * 0.2f), -2);
        this.Qq.measure(childMeasureSpec2, childMeasureSpec);
        this.Qr.measure(childMeasureSpec2, childMeasureSpec);
        this.Qs.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            max = View.MeasureSpec.getSize(i3);
        } else {
            max = Math.max(getMinHeight(), paddingTop + this.Qr.getMeasuredHeight());
        }
        setMeasuredDimension(size, View.resolveSizeAndState(max, i3, this.Qr.getMeasuredState() << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2 = 0.0f;
        if (this.Qp != null) {
            if (this.Qu >= 0.0f) {
                f2 = this.Qu;
            }
            a(this.Qt, f2, true);
        }
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public class a extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.c {
        private int mScrollState;

        a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i2, float f2, int i3) {
            if (f2 > 0.5f) {
                i2++;
            }
            PagerTitleStrip.this.a(i2, f2, false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i2) {
            float f2 = 0.0f;
            if (this.mScrollState == 0) {
                PagerTitleStrip.this.a(PagerTitleStrip.this.Qp.getCurrentItem(), PagerTitleStrip.this.Qp.getAdapter());
                if (PagerTitleStrip.this.Qu >= 0.0f) {
                    f2 = PagerTitleStrip.this.Qu;
                }
                PagerTitleStrip.this.a(PagerTitleStrip.this.Qp.getCurrentItem(), f2, true);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i2) {
            this.mScrollState = i2;
        }

        @Override // android.support.v4.view.ViewPager.c
        public final void a(ViewPager viewPager, q qVar, q qVar2) {
            PagerTitleStrip.this.a(qVar, qVar2);
        }

        public final void onChanged() {
            float f2 = 0.0f;
            PagerTitleStrip.this.a(PagerTitleStrip.this.Qp.getCurrentItem(), PagerTitleStrip.this.Qp.getAdapter());
            if (PagerTitleStrip.this.Qu >= 0.0f) {
                f2 = PagerTitleStrip.this.Qu;
            }
            PagerTitleStrip.this.a(PagerTitleStrip.this.Qp.getCurrentItem(), f2, true);
        }
    }
}
