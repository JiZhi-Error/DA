package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.a;
import com.tencent.neattextview.textview.layout.NeatLayout;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.List;

public class NeatTextView extends View implements a {
    private static final LruCache<String, e> RBP = new LruCache<>(800);
    private static final HandlerThread RBQ;
    private static Handler RBR;
    private int AoL = 8388659;
    private ColorStateList BpJ;
    private int OVm;
    private Spannable.Factory OVo = Spannable.Factory.getInstance();
    private TextUtils.TruncateAt OVp;
    private float OVv = 0.0f;
    private TextView.BufferType QGD = TextView.BufferType.NORMAL;
    private CharSequence QGE;
    private ColorStateList QGn;
    private ColorStateList QGo;
    private int QGp;
    private TextView RBS;
    private a RBT = new a(this, (byte) 0);
    private b RBU;
    private boolean RBV = true;
    private b RBW;
    private float RBX;
    private boolean RBY = true;
    private d RBZ;
    private com.tencent.neattextview.textview.layout.c RBw;
    private float[] RCa;
    private com.tencent.neattextview.textview.layout.a RCb;
    private TextPaint ayn;
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private CharSequence mText = "";
    private int pME = Integer.MAX_VALUE;
    public boolean pMM;

    public interface b {
        boolean gS(View view);
    }

    public interface c extends View.OnTouchListener {
    }

    static /* synthetic */ Layout b(NeatTextView neatTextView) {
        AppMethodBeat.i(39828);
        Layout wrappedTxtLayout = neatTextView.getWrappedTxtLayout();
        AppMethodBeat.o(39828);
        return wrappedTxtLayout;
    }

    static {
        AppMethodBeat.i(39829);
        HandlerThread handlerThread = new HandlerThread("PreMeasuredThread", -8);
        RBQ = handlerThread;
        handlerThread.start();
        Looper looper = RBQ.getLooper();
        if (looper != null) {
            RBR = new Handler(looper);
        }
        AppMethodBeat.o(39829);
    }

    public NeatTextView(Context context) {
        super(context);
        AppMethodBeat.i(163503);
        e(context, null, 0);
        AppMethodBeat.o(163503);
    }

    public NeatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39785);
        e(context, attributeSet, 0);
        AppMethodBeat.o(39785);
    }

    public NeatTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(39786);
        e(context, attributeSet, i2);
        AppMethodBeat.o(39786);
    }

    private void e(Context context, AttributeSet attributeSet, int i2) {
        int i3;
        AppMethodBeat.i(39787);
        this.RBU = new b(getContext(), this);
        AdaptedTextView adaptedTextView = new AdaptedTextView(context);
        adaptedTextView.setClickable(true);
        adaptedTextView.setFocusable(true);
        adaptedTextView.RCd = new AdaptedTextView.a() {
            /* class com.tencent.neattextview.textview.view.NeatTextView.AnonymousClass1 */

            @Override // com.tencent.neattextview.textview.view.NeatTextView.AdaptedTextView.a
            public final void invalidate() {
                AppMethodBeat.i(39761);
                NeatTextView.this.invalidate();
                AppMethodBeat.o(39761);
            }

            @Override // com.tencent.neattextview.textview.view.NeatTextView.AdaptedTextView.a
            public final void postInvalidate() {
                AppMethodBeat.i(39762);
                NeatTextView.this.postInvalidate();
                AppMethodBeat.o(39762);
            }
        };
        this.RBS = adaptedTextView;
        this.ayn = getWrappedTextView().getPaint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2178a.NeatTextView, i2, 0);
        int i4 = 15;
        int i5 = WebView.NIGHT_MODE_COLOR;
        int i6 = -7829368;
        int i7 = -16776961;
        int i8 = -1;
        String str = null;
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = obtainStyledAttributes.getIndex(i9);
                if (index == 0) {
                    i4 = obtainStyledAttributes.getDimensionPixelSize(index, 15);
                } else if (index == 3) {
                    i5 = obtainStyledAttributes.getColor(index, WebView.NIGHT_MODE_COLOR);
                } else if (index == 23) {
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        i3 = 1;
                    } else {
                        i3 = this.pME;
                    }
                    setMaxLines(i3);
                } else if (index == 20) {
                    setLines(obtainStyledAttributes.getInt(index, Integer.MAX_VALUE));
                } else if (index == 7) {
                    setTextGravity(obtainStyledAttributes.getInt(index, 16));
                } else if (index == 13) {
                    setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(index, this.mMaxWidth));
                } else if (index == 24) {
                    setSpacingAdd(obtainStyledAttributes.getDimensionPixelSize(index, (int) this.OVv));
                } else if (index == 15) {
                    setMinWidth(obtainStyledAttributes.getDimensionPixelSize(index, this.mMinWidth));
                } else if (index == 16) {
                    setMinHeight(obtainStyledAttributes.getDimensionPixelSize(index, this.mMinHeight));
                } else if (index == 14) {
                    setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(index, this.mMaxHeight));
                } else if (index == 19) {
                    setMaxLines(obtainStyledAttributes.getInt(index, Integer.MAX_VALUE));
                } else if (index == 17) {
                    str = obtainStyledAttributes.getString(index);
                } else if (index == 22) {
                    setWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == 21) {
                    setHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == 18) {
                    setHint(obtainStyledAttributes.getText(index));
                } else if (index == 4) {
                    i6 = obtainStyledAttributes.getColor(index, -7829368);
                } else if (index == 5) {
                    i7 = obtainStyledAttributes.getColor(index, -16776961);
                } else if (index == 6) {
                    i8 = obtainStyledAttributes.getInt(index, i8);
                } else if (index == 26) {
                    this.RBY = obtainStyledAttributes.getBoolean(index, true);
                }
            }
            obtainStyledAttributes.recycle();
            setTextColor(i5);
            setRawTextSize((float) i4);
            setLinkTextColor(i7);
            setHintTextColor(i6);
            switch (i8) {
                case 1:
                    setEllipsize(TextUtils.TruncateAt.START);
                    break;
                case 2:
                    setEllipsize(TextUtils.TruncateAt.MIDDLE);
                    break;
                case 3:
                    setEllipsize(TextUtils.TruncateAt.END);
                    break;
            }
            if (!TextUtils.isEmpty(str)) {
                aw(str);
            }
            getWrappedTextView().setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            AppMethodBeat.o(39787);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(39787);
            throw th;
        }
    }

    @Override // com.tencent.neattextview.textview.view.a
    public b getOnDoubleClickListener() {
        return this.RBW;
    }

    public void setOnDoubleClickListener(b bVar) {
        this.RBW = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(39788);
        if (this.RBU == null || !this.RBU.onTouch(this, motionEvent)) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(39788);
            return onTouchEvent;
        }
        AppMethodBeat.o(39788);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        float[] fArr;
        boolean z;
        CharSequence charSequence;
        AppMethodBeat.i(39789);
        if (this.pMM) {
            getWrappedTextView().measure(i2, i3);
            setMeasuredDimension(getWrappedTextView().getMeasuredWidth(), getWrappedTextView().getMeasuredHeight());
            AppMethodBeat.o(39789);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (size <= 0 && mode2 == 0) {
            size = getResources().getDisplayMetrics().widthPixels;
        }
        if (size2 <= 0 && mode2 == 0) {
            size2 = Integer.MAX_VALUE;
        }
        if (this.mMaxWidth <= 0 || this.mMaxWidth >= size) {
            i4 = size;
        } else {
            i4 = this.mMaxWidth;
        }
        if (this.mMaxHeight <= 0 || this.mMaxHeight >= size2) {
            i5 = size2;
        } else {
            i5 = this.mMaxHeight;
        }
        float paddingLeft = (float) ((i4 - getPaddingLeft()) - getPaddingRight());
        float paddingTop = (float) ((i5 - getPaddingTop()) - getPaddingBottom());
        CharSequence charSequence2 = TextUtils.isEmpty(this.mText) ? this.QGE : this.mText;
        if (!TextUtils.isEmpty(charSequence2)) {
            e eVar = RBP.get(aWu(charSequence2.toString()));
            if (eVar != null) {
                fArr = eVar.RCf;
                z = false;
                charSequence = charSequence2;
            } else {
                if (this.RBZ != null) {
                    d dVar = this.RBZ;
                    if (this.ayn.getTextSize() != dVar.huv.getTextSize() || !dVar.iGD) {
                        fArr = null;
                    } else {
                        fArr = dVar.RCf;
                    }
                } else {
                    fArr = null;
                }
                z = true;
                charSequence = charSequence2;
            }
        } else {
            fArr = null;
            z = false;
            charSequence = "";
        }
        this.RBw = new NeatLayout(charSequence, fArr);
        if (this.RCa == null) {
            this.RBw.a(getPaint(), paddingLeft, paddingTop, (float) getPaddingLeft(), (float) getPaddingTop(), this.OVv, this.pME, this.OVp, this.RBX, this.RBY, this.AoL);
        } else {
            this.RBw.a(getPaint(), this.RCa, paddingLeft, paddingTop, (float) getPaddingLeft(), (float) getPaddingTop(), this.OVv, this.pME, this.OVp, this.RBX, this.RBY, this.AoL);
        }
        if (z) {
            RBP.put(aWu(this.RBw.hiP()), new e(this.pMM, this.RBw.hiI()));
        }
        this.RBT.RCe = new WeakReference<>(this.RBw);
        float[] hiQ = this.RBw.hiQ();
        if (mode != 1073741824) {
            i4 = (int) Math.min(hiQ[0] + ((float) getPaddingLeft()) + ((float) getPaddingRight()), (float) this.mMaxWidth);
        }
        if (mode2 != 1073741824) {
            i5 = (int) Math.min(hiQ[1] + ((float) getPaddingTop()) + ((float) getPaddingBottom()), (float) this.mMaxHeight);
        }
        setMeasuredDimension(Math.max(i4, this.mMinWidth), Math.max(i5, this.mMinHeight));
        AppMethodBeat.o(39789);
    }

    public final com.tencent.neattextview.textview.layout.a mq(int i2, int i3) {
        NeatLayout neatLayout;
        AppMethodBeat.i(163504);
        if (!TextUtils.isEmpty(this.mText)) {
            neatLayout = new NeatLayout(this.mText, null);
            neatLayout.a(getPaint(), (float) i2, (float) i3, (float) getPaddingLeft(), (float) getPaddingTop(), this.OVv, this.pME, this.OVp, this.RBX, this.RBY, this.AoL);
        } else {
            neatLayout = null;
        }
        AppMethodBeat.o(163504);
        return neatLayout;
    }

    public float getExtraEllipsizeWidth() {
        return this.RBX;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(39791);
        super.onDraw(canvas);
        int i2 = this.OVm;
        if (!TextUtils.isEmpty(this.QGE) && TextUtils.isEmpty(this.mText) && this.QGn != null) {
            i2 = this.QGp;
        }
        this.ayn.setColor(i2);
        this.ayn.drawableState = getDrawableState();
        if (this.pMM) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            Layout layout = getWrappedTextView().getLayout();
            if (layout != null) {
                layout.draw(canvas);
            }
            canvas.restore();
            AppMethodBeat.o(39791);
            return;
        }
        if (this.RBw != null) {
            if (this.RBw.getTextPaint() != null) {
                this.RBw.getTextPaint().set(this.ayn);
            }
            this.RBw.a(canvas, (float) getPaddingLeft(), getVerticalOffset());
        }
        AppMethodBeat.o(39791);
    }

    public TextView getWrappedTextView() {
        return this.RBS;
    }

    public final CharSequence hiT() {
        return this.mText == null ? "" : this.mText;
    }

    public void aw(CharSequence charSequence) {
        AppMethodBeat.i(39792);
        a(charSequence, TextView.BufferType.NORMAL);
        AppMethodBeat.o(39792);
    }

    public void a(CharSequence charSequence, TextView.BufferType bufferType) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(39793);
        this.QGD = bufferType;
        if (charSequence == null) {
            charSequence = "";
        }
        if (bufferType == TextView.BufferType.NORMAL) {
            charSequence = TextUtils.stringOrSpannedString(charSequence);
        } else if (bufferType == TextView.BufferType.SPANNABLE) {
            charSequence = this.OVo.newSpannable(charSequence);
        }
        this.mText = charSequence;
        if (gYM()) {
            String charSequence2 = charSequence.toString();
            e eVar = RBP.get(aWu(charSequence2));
            if (eVar == null) {
                z = !charSequence2.matches("^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$");
                RBP.put(aWu(charSequence2), new e(z, null));
            } else {
                z = eVar.pMM;
            }
            if (!z) {
                z2 = false;
            }
        }
        this.pMM = z2;
        if (this.pMM) {
            if (getLayoutParams() != null) {
                getWrappedTextView().setLayoutParams(getLayoutParams());
            }
            getWrappedTextView().setText(charSequence, bufferType);
            this.mText = getWrappedTextView().getText();
            requestLayout();
            invalidate();
        } else {
            IR();
        }
        if (this.mText instanceof Spannable) {
            ((Spannable) this.mText).setSpan(this.RBT, 0, charSequence.length(), 18);
        }
        AppMethodBeat.o(39793);
    }

    @Override // com.tencent.neattextview.textview.view.a
    public float getVerticalOffset() {
        AppMethodBeat.i(39794);
        if ((this.AoL & 112) == 48 || this.RBw == null) {
            float paddingTop = (float) getPaddingTop();
            AppMethodBeat.o(39794);
            return paddingTop;
        }
        float measuredHeight = (((float) getMeasuredHeight()) - this.RBw.hiQ()[1]) / 2.0f;
        AppMethodBeat.o(39794);
        return measuredHeight;
    }

    @Override // com.tencent.neattextview.textview.view.a
    public float getHorizontalOffset() {
        AppMethodBeat.i(39795);
        if ((this.AoL & 7) == 3 || this.RBw == null) {
            float paddingLeft = (float) getPaddingLeft();
            AppMethodBeat.o(39795);
            return paddingLeft;
        }
        float measuredWidth = (((float) getMeasuredWidth()) - this.RBw.hiQ()[0]) / 2.0f;
        AppMethodBeat.o(39795);
        return measuredWidth;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        AppMethodBeat.i(39796);
        if (this.OVp != truncateAt) {
            this.OVp = truncateAt;
            hiU();
            if (this.RBw != null) {
                this.RBw = null;
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(39796);
    }

    public final void a(TextUtils.TruncateAt truncateAt, float f2) {
        AppMethodBeat.i(39797);
        this.RBX = f2;
        this.OVp = truncateAt;
        hiU();
        if (this.RBw != null) {
            this.RBw = null;
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(39797);
    }

    private void hiU() {
        AppMethodBeat.i(39798);
        getWrappedTextView().setEllipsize(this.OVp);
        AppMethodBeat.o(39798);
    }

    @Override // com.tencent.neattextview.textview.view.a
    public final boolean hiS() {
        return this.pMM;
    }

    public int getTextGravity() {
        return this.AoL;
    }

    public void setTextGravity(int i2) {
        int i3;
        AppMethodBeat.i(39799);
        getWrappedTextView().setGravity(i2);
        if ((8388615 & i2) == 0) {
            i3 = 8388611 | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 112) == 0) {
            i3 |= 48;
        }
        this.AoL = i3;
        if (i3 != this.AoL) {
            invalidate();
        }
        AppMethodBeat.o(39799);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(39800);
        if (!(i2 == getPaddingLeft() && i4 == getPaddingRight() && i3 == getPaddingTop() && i5 == getPaddingBottom())) {
            this.RBw = null;
        }
        super.setPadding(i2, i3, i4, i5);
        getWrappedTextView().setPadding(i2, i3, i4, i5);
        invalidate();
        AppMethodBeat.o(39800);
    }

    public TextPaint getPaint() {
        return this.ayn;
    }

    public int getLineCount() {
        AppMethodBeat.i(39801);
        if (this.RBw != null) {
            int size = this.RBw.RAX.size();
            AppMethodBeat.o(39801);
            return size;
        }
        AppMethodBeat.o(39801);
        return 0;
    }

    public CharSequence getHint() {
        return this.QGE;
    }

    public final void setHint(int i2) {
        AppMethodBeat.i(39802);
        setHint(getContext().getResources().getText(i2));
        AppMethodBeat.o(39802);
    }

    public final void setHint(CharSequence charSequence) {
        AppMethodBeat.i(39803);
        this.QGE = TextUtils.stringOrSpannedString(charSequence);
        getWrappedTextView().setHint(this.QGE);
        if (TextUtils.isEmpty(this.mText)) {
            IR();
        }
        AppMethodBeat.o(39803);
    }

    public boolean gYM() {
        return this.RBV;
    }

    public void setNeatEnable(boolean z) {
        this.RBV = z;
    }

    public void setSmartLetterEnable(boolean z) {
        this.RBY = z;
    }

    public void setWidth(int i2) {
        AppMethodBeat.i(39804);
        this.mMaxWidth = i2;
        getWrappedTextView().setMaxWidth(i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(39804);
    }

    public void setHeight(int i2) {
        AppMethodBeat.i(39805);
        this.mMaxHeight = i2;
        getWrappedTextView().setMaxHeight(i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(39805);
    }

    public void setMinHeight(int i2) {
        AppMethodBeat.i(39806);
        this.mMinHeight = i2;
        getWrappedTextView().setMinHeight(i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(39806);
    }

    public void setMaxHeight(int i2) {
        AppMethodBeat.i(39807);
        this.mMaxHeight = i2;
        getWrappedTextView().setMaxHeight(i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(39807);
    }

    public void setMaxWidth(int i2) {
        AppMethodBeat.i(39808);
        this.mMaxWidth = i2;
        getWrappedTextView().setMaxWidth(i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(39808);
    }

    public void setSpacingAdd(int i2) {
        AppMethodBeat.i(39809);
        this.OVv = (float) i2;
        getWrappedTextView().setLineSpacing((float) i2, 1.0f);
        requestLayout();
        invalidate();
        AppMethodBeat.o(39809);
    }

    public void setMinWidth(int i2) {
        AppMethodBeat.i(39810);
        this.mMinWidth = i2;
        getWrappedTextView().setMinWidth(i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(39810);
    }

    public void setMaxLines(int i2) {
        AppMethodBeat.i(39811);
        this.pME = i2;
        getWrappedTextView().setMaxLines(i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(39811);
    }

    public void setLines(int i2) {
        AppMethodBeat.i(39812);
        this.pME = i2;
        getWrappedTextView().setLines(i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(39812);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(39813);
        this.BpJ = ColorStateList.valueOf(i2);
        getWrappedTextView().setTextColor(i2);
        updateTextColors();
        AppMethodBeat.o(39813);
    }

    public final void setLinkTextColor(int i2) {
        AppMethodBeat.i(39814);
        this.QGo = ColorStateList.valueOf(i2);
        updateTextColors();
        AppMethodBeat.o(39814);
    }

    public final void setHintTextColor(int i2) {
        AppMethodBeat.i(39815);
        this.QGn = ColorStateList.valueOf(i2);
        getWrappedTextView().setHintTextColor(i2);
        updateTextColors();
        AppMethodBeat.o(39815);
    }

    public final int getCurrentHintTextColor() {
        return this.QGn != null ? this.QGp : this.OVm;
    }

    public final int getCurrentTextColor() {
        return this.OVm;
    }

    private String aWu(String str) {
        AppMethodBeat.i(39816);
        String str2 = str + "#" + this.ayn.getTextSize();
        AppMethodBeat.o(39816);
        return str2;
    }

    private void IR() {
        AppMethodBeat.i(39817);
        this.RBw = null;
        if (RBR != null) {
            if (this.mText == null && this.QGE != null) {
                Handler handler = RBR;
                d dVar = new d(this.QGE.toString(), this.ayn);
                this.RBZ = dVar;
                handler.post(dVar);
            } else if (this.mText != null) {
                Handler handler2 = RBR;
                d dVar2 = new d(this.mText.toString(), this.ayn);
                this.RBZ = dVar2;
                handler2.post(dVar2);
            } else {
                AppMethodBeat.o(39817);
                return;
            }
        }
        requestLayout();
        invalidate();
        AppMethodBeat.o(39817);
    }

    private void updateTextColors() {
        boolean z;
        int colorForState;
        int colorForState2;
        AppMethodBeat.i(39818);
        int colorForState3 = this.BpJ.getColorForState(getDrawableState(), 0);
        if (colorForState3 != this.OVm) {
            this.OVm = colorForState3;
            z = true;
        } else {
            z = false;
        }
        if (!(this.QGo == null || (colorForState2 = this.QGo.getColorForState(getDrawableState(), 0)) == this.ayn.linkColor)) {
            this.ayn.linkColor = colorForState2;
            z = true;
        }
        if (!(this.QGn == null || (colorForState = this.QGn.getColorForState(getDrawableState(), 0)) == this.QGp)) {
            this.QGp = colorForState;
            if (this.mText == null || this.mText.length() == 0) {
                z = true;
            }
        }
        if (z) {
            invalidate();
        }
        AppMethodBeat.o(39818);
    }

    public void setLineEndExtraWidths(float[] fArr) {
        this.RCa = fArr;
    }

    public float getTextSize() {
        AppMethodBeat.i(39819);
        float textSize = getPaint().getTextSize();
        AppMethodBeat.o(39819);
        return textSize;
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(39820);
        setTextSize(2, f2);
        AppMethodBeat.o(39820);
    }

    public final void setTextSize(int i2, float f2) {
        Resources resources;
        AppMethodBeat.i(39821);
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
        AppMethodBeat.o(39821);
    }

    private void setRawTextSize(float f2) {
        AppMethodBeat.i(39822);
        if (f2 != this.ayn.getTextSize()) {
            this.ayn.setTextSize(f2);
            if (this.RBw != null) {
                IR();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(39822);
    }

    /* access modifiers changed from: package-private */
    public static final class d implements Runnable {
        float[] RCf;
        TextPaint huv = new TextPaint();
        volatile boolean iGD = false;
        String text;

        d(String str, TextPaint textPaint) {
            AppMethodBeat.i(39783);
            this.huv.set(textPaint);
            this.text = str;
            AppMethodBeat.o(39783);
        }

        public final void run() {
            AppMethodBeat.i(39784);
            this.RCf = new float[this.text.length()];
            this.huv.getTextWidths(this.text, this.RCf);
            this.iGD = true;
            AppMethodBeat.o(39784);
        }
    }

    /* access modifiers changed from: package-private */
    public static class e {
        public float[] RCf;
        public boolean pMM;

        public e(boolean z, float[] fArr) {
            this.pMM = z;
            this.RCf = fArr;
        }
    }

    public void invalidate() {
        AppMethodBeat.i(39823);
        super.invalidate();
        AppMethodBeat.o(39823);
    }

    public void postInvalidate() {
        AppMethodBeat.i(39824);
        super.postInvalidate();
        AppMethodBeat.o(39824);
    }

    /* access modifiers changed from: package-private */
    public class a implements SpanWatcher {
        WeakReference<com.tencent.neattextview.textview.layout.c> RCe;

        private a() {
        }

        /* synthetic */ a(NeatTextView neatTextView, byte b2) {
            this();
        }

        public final void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
            AppMethodBeat.i(39779);
            k(spannable);
            AppMethodBeat.o(39779);
        }

        public final void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
            AppMethodBeat.i(39780);
            k(spannable);
            AppMethodBeat.o(39780);
        }

        public final void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(39781);
            k(spannable);
            AppMethodBeat.o(39781);
        }

        private void k(Spannable spannable) {
            AppMethodBeat.i(39782);
            if (NeatTextView.this.pMM) {
                NeatTextView.this.postInvalidate();
                AppMethodBeat.o(39782);
            } else if (this.RCe == null) {
                AppMethodBeat.o(39782);
            } else {
                com.tencent.neattextview.textview.layout.c cVar = this.RCe.get();
                if (cVar != null && cVar.getText() == spannable) {
                    cVar.aG(spannable);
                    NeatTextView.this.postInvalidate();
                }
                AppMethodBeat.o(39782);
            }
        }
    }

    @Override // com.tencent.neattextview.textview.view.a
    public com.tencent.neattextview.textview.layout.a getLayout() {
        AppMethodBeat.i(39825);
        if (this.RCb != null) {
            com.tencent.neattextview.textview.layout.a aVar = this.RCb;
            AppMethodBeat.o(39825);
            return aVar;
        }
        AnonymousClass2 r0 = new com.tencent.neattextview.textview.layout.a() {
            /* class com.tencent.neattextview.textview.view.NeatTextView.AnonymousClass2 */

            @Override // com.tencent.neattextview.textview.layout.a
            public final int getLineBaseline(int i2) {
                AppMethodBeat.i(39763);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39763);
                        return -1;
                    }
                    int lineBaseline = b2.getLineBaseline(i2);
                    AppMethodBeat.o(39763);
                    return lineBaseline;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39763);
                    return -1;
                }
                int lineBaseline2 = NeatTextView.this.RBw.getLineBaseline(i2);
                AppMethodBeat.o(39763);
                return lineBaseline2;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final int getLineTop(int i2) {
                AppMethodBeat.i(39764);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39764);
                        return -1;
                    }
                    int lineTop = b2.getLineTop(i2);
                    AppMethodBeat.o(39764);
                    return lineTop;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39764);
                    return -1;
                }
                int lineTop2 = NeatTextView.this.RBw.getLineTop(i2);
                AppMethodBeat.o(39764);
                return lineTop2;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final int getLineBottom(int i2) {
                AppMethodBeat.i(39765);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39765);
                        return -1;
                    }
                    int lineBottom = b2.getLineBottom(i2);
                    AppMethodBeat.o(39765);
                    return lineBottom;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39765);
                    return -1;
                }
                int lineBottom2 = NeatTextView.this.RBw.getLineBottom(i2);
                AppMethodBeat.o(39765);
                return lineBottom2;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final int getLineForOffset(int i2) {
                AppMethodBeat.i(39766);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39766);
                        return -1;
                    }
                    int lineForOffset = b2.getLineForOffset(i2);
                    AppMethodBeat.o(39766);
                    return lineForOffset;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39766);
                    return -1;
                }
                int lineForOffset2 = NeatTextView.this.RBw.getLineForOffset(i2);
                AppMethodBeat.o(39766);
                return lineForOffset2;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final float getPrimaryHorizontal(int i2) {
                AppMethodBeat.i(39767);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39767);
                        return -1.0f;
                    }
                    float primaryHorizontal = b2.getPrimaryHorizontal(i2);
                    AppMethodBeat.o(39767);
                    return primaryHorizontal;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39767);
                    return -1.0f;
                }
                float primaryHorizontal2 = NeatTextView.this.RBw.getPrimaryHorizontal(i2);
                AppMethodBeat.o(39767);
                return primaryHorizontal2;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final int getOffsetForHorizontal(int i2, float f2) {
                AppMethodBeat.i(39768);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39768);
                        return -1;
                    }
                    int offsetForHorizontal = b2.getOffsetForHorizontal(i2, f2);
                    AppMethodBeat.o(39768);
                    return offsetForHorizontal;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39768);
                    return -1;
                }
                int offsetForHorizontal2 = NeatTextView.this.RBw.getOffsetForHorizontal(i2, f2);
                AppMethodBeat.o(39768);
                return offsetForHorizontal2;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final float getLineWidth(int i2) {
                AppMethodBeat.i(39769);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39769);
                        return -1.0f;
                    }
                    float lineWidth = b2.getLineWidth(i2);
                    AppMethodBeat.o(39769);
                    return lineWidth;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39769);
                    return -1.0f;
                }
                float lineWidth2 = NeatTextView.this.RBw.getLineWidth(i2);
                AppMethodBeat.o(39769);
                return lineWidth2;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final int getLineStart(int i2) {
                AppMethodBeat.i(39770);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39770);
                        return -1;
                    }
                    int lineStart = b2.getLineStart(i2);
                    AppMethodBeat.o(39770);
                    return lineStart;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39770);
                    return -1;
                }
                int lineStart2 = NeatTextView.this.RBw.getLineStart(i2);
                AppMethodBeat.o(39770);
                return lineStart2;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final int getLineForVertical(int i2) {
                AppMethodBeat.i(39771);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39771);
                        return -1;
                    }
                    int lineForVertical = b2.getLineForVertical(i2);
                    AppMethodBeat.o(39771);
                    return lineForVertical;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39771);
                    return -1;
                }
                int lineForVertical2 = NeatTextView.this.RBw.getLineForVertical(i2);
                AppMethodBeat.o(39771);
                return lineForVertical2;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final float getLineRight(int i2) {
                AppMethodBeat.i(39772);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39772);
                        return -1.0f;
                    }
                    float lineRight = b2.getLineRight(i2);
                    AppMethodBeat.o(39772);
                    return lineRight;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39772);
                    return -1.0f;
                }
                float lineRight2 = NeatTextView.this.RBw.getLineRight(i2);
                AppMethodBeat.o(39772);
                return lineRight2;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final int hiG() {
                AppMethodBeat.i(39773);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39773);
                        return -1;
                    }
                    int lineCount = b2.getLineCount();
                    AppMethodBeat.o(39773);
                    return lineCount;
                }
                com.tencent.neattextview.textview.layout.c unused = NeatTextView.this.RBw;
                if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39773);
                    return -1;
                }
                int size = NeatTextView.this.RBw.RAX.size();
                AppMethodBeat.o(39773);
                return size;
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final int mn(int i2, int i3) {
                AppMethodBeat.i(39774);
                if (NeatTextView.this.pMM) {
                    int paddingLeft = i2 - NeatTextView.this.getPaddingLeft();
                    int paddingTop = i3 - NeatTextView.this.getPaddingTop();
                    Layout layout = NeatTextView.this.getWrappedTextView().getLayout();
                    if (layout != null) {
                        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(paddingTop), (float) paddingLeft);
                        if (((int) layout.getPrimaryHorizontal(offsetForHorizontal)) > paddingLeft) {
                            int offsetToLeftOf = layout.getOffsetToLeftOf(offsetForHorizontal);
                            AppMethodBeat.o(39774);
                            return offsetToLeftOf;
                        }
                        AppMethodBeat.o(39774);
                        return offsetForHorizontal;
                    }
                    AppMethodBeat.o(39774);
                    return -1;
                } else if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39774);
                    return -1;
                } else {
                    int mn = NeatTextView.this.RBw.mn(i2, i3);
                    AppMethodBeat.o(39774);
                    return mn;
                }
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final List<com.tencent.neattextview.textview.b.c> hiH() {
                AppMethodBeat.i(39775);
                if (NeatTextView.this.pMM) {
                    AppMethodBeat.o(39775);
                    return null;
                } else if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39775);
                    return null;
                } else {
                    List<com.tencent.neattextview.textview.b.c> hiH = NeatTextView.this.RBw.hiH();
                    AppMethodBeat.o(39775);
                    return hiH;
                }
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final int getEllipsisStart(int i2) {
                AppMethodBeat.i(192278);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(192278);
                        return -1;
                    }
                    int ellipsisStart = b2.getEllipsisStart(i2);
                    AppMethodBeat.o(192278);
                    return ellipsisStart;
                } else if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(192278);
                    return -1;
                } else {
                    int ellipsisStart2 = NeatTextView.this.RBw.getEllipsisStart(i2);
                    AppMethodBeat.o(192278);
                    return ellipsisStart2;
                }
            }

            @Override // com.tencent.neattextview.textview.layout.a
            public final int getEllipsisCount(int i2) {
                AppMethodBeat.i(39776);
                if (NeatTextView.this.pMM) {
                    Layout b2 = NeatTextView.b(NeatTextView.this);
                    if (b2 == null) {
                        AppMethodBeat.o(39776);
                        return -1;
                    }
                    int ellipsisCount = b2.getEllipsisCount(i2);
                    AppMethodBeat.o(39776);
                    return ellipsisCount;
                } else if (NeatTextView.this.RBw == null) {
                    AppMethodBeat.o(39776);
                    return -1;
                } else {
                    int ellipsisCount2 = NeatTextView.this.RBw.getEllipsisCount(i2);
                    AppMethodBeat.o(39776);
                    return ellipsisCount2;
                }
            }
        };
        this.RCb = r0;
        AppMethodBeat.o(39825);
        return r0;
    }

    public int getLineHeight() {
        AppMethodBeat.i(39826);
        int round = Math.round(((float) this.ayn.getFontMetricsInt(null)) + this.OVv);
        AppMethodBeat.o(39826);
        return round;
    }

    private Layout getWrappedTxtLayout() {
        AppMethodBeat.i(39827);
        TextView wrappedTextView = getWrappedTextView();
        if (wrappedTextView != null) {
            Layout layout = wrappedTextView.getLayout();
            AppMethodBeat.o(39827);
            return layout;
        }
        AppMethodBeat.o(39827);
        return null;
    }

    public int getMaxLines() {
        return this.pME;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    /* access modifiers changed from: package-private */
    public static class AdaptedTextView extends AppCompatTextView {
        a RCd;

        public interface a {
            void invalidate();

            void postInvalidate();
        }

        public AdaptedTextView(Context context) {
            super(context);
        }

        public AdaptedTextView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public AdaptedTextView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }

        public void invalidate() {
            AppMethodBeat.i(39777);
            super.invalidate();
            if (this.RCd != null) {
                this.RCd.invalidate();
            }
            AppMethodBeat.o(39777);
        }

        public void postInvalidate() {
            AppMethodBeat.i(39778);
            super.postInvalidate();
            if (this.RCd != null) {
                this.RCd.postInvalidate();
            }
            AppMethodBeat.o(39778);
        }
    }
}
