package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public class SysTextView extends TextView implements a {
    private static boolean huW = false;
    private static Field huX = null;
    private g huI = new g(this, new a());

    public SysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141096);
        init();
        AppMethodBeat.o(141096);
    }

    public SysTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141097);
        init();
        AppMethodBeat.o(141097);
    }

    private void init() {
        AppMethodBeat.i(141098);
        super.setText(" ", TextView.BufferType.SPANNABLE);
        this.huI.huK = new a();
        this.huI.huK.textColor = super.getTextColors().getDefaultColor();
        this.huI.huK.hux = super.getEllipsize();
        this.huI.huK.gravity = super.getGravity();
        this.huI.huK.textSize = super.getTextSize();
        aBp();
        AppMethodBeat.o(141098);
    }

    private void aBp() {
        AppMethodBeat.i(141099);
        if (huW) {
            AppMethodBeat.o(141099);
            return;
        }
        try {
            if (huX == null) {
                Field declaredField = TextView.class.getDeclaredField("mSingleLine");
                huX = declaredField;
                declaredField.setAccessible(true);
            }
            if (huX.getBoolean(this)) {
                this.huI.huK.maxLines = 1;
            }
            AppMethodBeat.o(141099);
        } catch (Exception e2) {
            Log.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", e2.getMessage());
            huW = true;
            AppMethodBeat.o(141099);
        }
    }

    /* access modifiers changed from: protected */
    public f getLayoutWrapper() {
        AppMethodBeat.i(141100);
        if (this.huI == null) {
            AppMethodBeat.o(141100);
            return null;
        }
        f layoutWrapper = this.huI.getLayoutWrapper();
        AppMethodBeat.o(141100);
        return layoutWrapper;
    }

    public a getConfig() {
        if (this.huI == null) {
            return null;
        }
        return this.huI.huK;
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.i(141101);
        if (this.huI == null) {
            AppMethodBeat.o(141101);
            return;
        }
        this.huI.setSingleLine(z);
        AppMethodBeat.o(141101);
    }

    public void setLines(int i2) {
        AppMethodBeat.i(141102);
        if (this.huI == null) {
            AppMethodBeat.o(141102);
            return;
        }
        this.huI.setLines(i2);
        AppMethodBeat.o(141102);
    }

    public boolean onPreDraw() {
        return true;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        AppMethodBeat.i(141103);
        setText$609c24db(charSequence);
        AppMethodBeat.o(141103);
    }

    public final void setText$609c24db(CharSequence charSequence) {
        AppMethodBeat.i(141104);
        if (this.huI == null) {
            super.setText("");
            AppMethodBeat.o(141104);
            return;
        }
        this.huI.setText(charSequence, false);
        AppMethodBeat.o(141104);
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(141105);
        setTextSize(0, f2);
        AppMethodBeat.o(141105);
    }

    public void setTextSize(int i2, float f2) {
        AppMethodBeat.i(141106);
        if (this.huI == null) {
            AppMethodBeat.o(141106);
            return;
        }
        this.huI.setTextSize(i2, f2);
        AppMethodBeat.o(141106);
    }

    public void setTextLayout(f fVar) {
        AppMethodBeat.i(141107);
        if (this.huI == null) {
            AppMethodBeat.o(141107);
            return;
        }
        this.huI.setTextLayout(fVar);
        AppMethodBeat.o(141107);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        AppMethodBeat.i(141108);
        if (this.huI == null) {
            AppMethodBeat.o(141108);
            return;
        }
        this.huI.setTextColor(i2);
        AppMethodBeat.o(141108);
    }

    public void setGravity(int i2) {
        AppMethodBeat.i(141109);
        if (this.huI == null) {
            AppMethodBeat.o(141109);
            return;
        }
        this.huI.setGravity(i2);
        AppMethodBeat.o(141109);
    }

    public void setMaxLines(int i2) {
        AppMethodBeat.i(141110);
        if (this.huI == null) {
            AppMethodBeat.o(141110);
            return;
        }
        this.huI.setMaxLines(i2);
        AppMethodBeat.o(141110);
    }

    public void setMinLines(int i2) {
        AppMethodBeat.i(141111);
        if (this.huI == null) {
            AppMethodBeat.o(141111);
            return;
        }
        this.huI.setMinLines(i2);
        AppMethodBeat.o(141111);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(141112);
        if (this.huI != null) {
            this.huI.aBo();
        }
        super.setLayoutParams(layoutParams);
        AppMethodBeat.o(141112);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141113);
        if (this.huI != null) {
            this.huI.aBo();
        }
        super.setPadding(i2, i3, i4, i5);
        AppMethodBeat.o(141113);
    }

    public CharSequence getText() {
        AppMethodBeat.i(141114);
        if (this.huI == null) {
            AppMethodBeat.o(141114);
            return null;
        }
        CharSequence text = this.huI.getText();
        AppMethodBeat.o(141114);
        return text;
    }

    public float getTextSize() {
        AppMethodBeat.i(141115);
        if (this.huI == null) {
            AppMethodBeat.o(141115);
            return 0.0f;
        }
        float textSize = this.huI.getTextSize();
        AppMethodBeat.o(141115);
        return textSize;
    }

    public int getTextColor() {
        AppMethodBeat.i(141116);
        int textColor = this.huI.getTextColor();
        AppMethodBeat.o(141116);
        return textColor;
    }

    public Layout getTvLayout() {
        AppMethodBeat.i(141117);
        Layout tvLayout = this.huI.getTvLayout();
        AppMethodBeat.o(141117);
        return tvLayout;
    }

    public int getLineCount() {
        AppMethodBeat.i(141118);
        if (this.huI == null) {
            AppMethodBeat.o(141118);
            return 0;
        }
        int lineCount = this.huI.getLineCount();
        AppMethodBeat.o(141118);
        return lineCount;
    }

    public int getLineHeight() {
        AppMethodBeat.i(141119);
        if (this.huI == null) {
            AppMethodBeat.o(141119);
            return 0;
        }
        int lineHeight = this.huI.getLineHeight();
        AppMethodBeat.o(141119);
        return lineHeight;
    }

    public int getSelectionStart() {
        AppMethodBeat.i(141120);
        if (getText() == null) {
            AppMethodBeat.o(141120);
            return -1;
        }
        int selectionStart = Selection.getSelectionStart(getText());
        AppMethodBeat.o(141120);
        return selectionStart;
    }

    public int getSelectionEnd() {
        AppMethodBeat.i(141121);
        if (getText() == null) {
            AppMethodBeat.o(141121);
            return -1;
        }
        int selectionEnd = Selection.getSelectionEnd(getText());
        AppMethodBeat.o(141121);
        return selectionEnd;
    }

    public void setHandleClickableSpan(boolean z) {
        this.huI.huR = z;
    }

    public void setClickable(boolean z) {
        AppMethodBeat.i(141122);
        super.setClickable(z);
        if (this.huI == null) {
            AppMethodBeat.o(141122);
            return;
        }
        this.huI.huQ = z;
        AppMethodBeat.o(141122);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(141123);
        if (getTvLayout() == null) {
            AppMethodBeat.o(141123);
            return false;
        }
        boolean w = this.huI.w(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (w) {
            AppMethodBeat.o(141123);
            return true;
        }
        AppMethodBeat.o(141123);
        return onTouchEvent;
    }

    public boolean performClick() {
        AppMethodBeat.i(141124);
        if (this.huI == null) {
            AppMethodBeat.o(141124);
            return false;
        } else if (!this.huI.performClick()) {
            AppMethodBeat.o(141124);
            return false;
        } else {
            boolean performClick = super.performClick();
            AppMethodBeat.o(141124);
            return performClick;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(141125);
        try {
            if (this.huI == null) {
                AppMethodBeat.o(141125);
                return;
            }
            this.huI.onDraw(canvas);
            AppMethodBeat.o(141125);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
            AppMethodBeat.o(141125);
        }
    }

    @Override // com.tencent.mm.kiss.widget.textview.a
    public int getHorizontalDrawOffset() {
        if (this.huI == null) {
            return 0;
        }
        return this.huI.huN;
    }

    @Override // com.tencent.mm.kiss.widget.textview.a
    public int getVerticalDrawOffset() {
        if (this.huI == null) {
            return 0;
        }
        return this.huI.huO;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(141126);
        try {
            Point cV = this.huI.cV(i2, i3);
            if (cV != null) {
                setMeasuredDimension(cV.x, cV.y);
                AppMethodBeat.o(141126);
                return;
            }
            try {
                super.onMeasure(i2, i3);
                AppMethodBeat.o(141126);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SysPLTextView", e2, "onMeasure error: %s", e2.getMessage());
                AppMethodBeat.o(141126);
            }
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
            AppMethodBeat.o(141126);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(141127);
        super.onAttachedToWindow();
        AppMethodBeat.o(141127);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(141128);
        super.onDetachedFromWindow();
        AppMethodBeat.o(141128);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.i(141129);
        super.onStartTemporaryDetach();
        AppMethodBeat.o(141129);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.i(141130);
        super.onFinishTemporaryDetach();
        AppMethodBeat.o(141130);
    }

    public void onHoverChanged(boolean z) {
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onProvideStructure(ViewStructure viewStructure) {
        AppMethodBeat.i(141131);
        try {
            super.onProvideStructure(viewStructure);
            AppMethodBeat.o(141131);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SysPLTextView", e2, "onProvideStructure error: %s", e2.getMessage());
            AppMethodBeat.o(141131);
        }
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
    }

    public int getBaseline() {
        AppMethodBeat.i(141132);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(141132);
            return baseline;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
            AppMethodBeat.o(141132);
            return -1;
        }
    }
}
