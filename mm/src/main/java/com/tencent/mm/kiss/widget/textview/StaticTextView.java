package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class StaticTextView extends View implements a {
    protected g huI = new g(this, aBn());

    public StaticTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141034);
        this.huI.init();
        AppMethodBeat.o(141034);
    }

    public StaticTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141035);
        this.huI.init();
        AppMethodBeat.o(141035);
    }

    public a getConfig() {
        if (this.huI == null) {
            return null;
        }
        return this.huI.huK;
    }

    /* access modifiers changed from: protected */
    public a aBn() {
        AppMethodBeat.i(141036);
        a aVar = new a();
        AppMethodBeat.o(141036);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public void setConfig(a aVar) {
        this.huI.huK = aVar;
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(141037);
        this.huI.setTextSize(0, f2);
        AppMethodBeat.o(141037);
    }

    public final void setTextSize$255e752(float f2) {
        AppMethodBeat.i(141038);
        this.huI.setTextSize(1, f2);
        AppMethodBeat.o(141038);
    }

    public void setTextLayout(f fVar) {
        AppMethodBeat.i(141039);
        this.huI.setTextLayout(fVar);
        AppMethodBeat.o(141039);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(141040);
        this.huI.setTextColor(i2);
        AppMethodBeat.o(141040);
    }

    public void setGravity(int i2) {
        AppMethodBeat.i(141041);
        this.huI.setGravity(i2);
        AppMethodBeat.o(141041);
    }

    public void setMaxLines(int i2) {
        AppMethodBeat.i(141042);
        this.huI.setMaxLines(i2);
        AppMethodBeat.o(141042);
    }

    public int getMaxLines() {
        AppMethodBeat.i(141043);
        int maxLines = this.huI.getMaxLines();
        AppMethodBeat.o(141043);
        return maxLines;
    }

    public void setMinLines(int i2) {
        AppMethodBeat.i(141044);
        this.huI.setMinLines(i2);
        AppMethodBeat.o(141044);
    }

    public void setLines(int i2) {
        AppMethodBeat.i(141045);
        this.huI.setLines(i2);
        AppMethodBeat.o(141045);
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.i(141046);
        this.huI.setSingleLine(z);
        AppMethodBeat.o(141046);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        AppMethodBeat.i(141047);
        this.huI.setText(charSequence, z);
        setContentDescription(charSequence);
        AppMethodBeat.o(141047);
    }

    public void setText(CharSequence charSequence) {
        AppMethodBeat.i(141048);
        setText(charSequence, true);
        AppMethodBeat.o(141048);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(141049);
        if (this.huI != null) {
            this.huI.aBo();
        }
        super.setLayoutParams(layoutParams);
        AppMethodBeat.o(141049);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141050);
        if (this.huI != null) {
            this.huI.aBo();
        }
        super.setPadding(i2, i3, i4, i5);
        AppMethodBeat.o(141050);
    }

    public CharSequence getText() {
        AppMethodBeat.i(141051);
        CharSequence text = this.huI.getText();
        AppMethodBeat.o(141051);
        return text;
    }

    public float getTextSize() {
        AppMethodBeat.i(141052);
        float textSize = this.huI.getTextSize();
        AppMethodBeat.o(141052);
        return textSize;
    }

    public int getTextColor() {
        AppMethodBeat.i(141053);
        int textColor = this.huI.getTextColor();
        AppMethodBeat.o(141053);
        return textColor;
    }

    public Layout getTvLayout() {
        AppMethodBeat.i(141054);
        Layout tvLayout = this.huI.getTvLayout();
        AppMethodBeat.o(141054);
        return tvLayout;
    }

    public f getLayoutWrapper() {
        AppMethodBeat.i(141055);
        if (this.huI == null) {
            AppMethodBeat.o(141055);
            return null;
        }
        f layoutWrapper = this.huI.getLayoutWrapper();
        AppMethodBeat.o(141055);
        return layoutWrapper;
    }

    public int getLineCount() {
        AppMethodBeat.i(141056);
        int lineCount = this.huI.getLineCount();
        AppMethodBeat.o(141056);
        return lineCount;
    }

    public int getLineHeight() {
        AppMethodBeat.i(141057);
        int lineHeight = this.huI.getLineHeight();
        AppMethodBeat.o(141057);
        return lineHeight;
    }

    public int getSelectionStart() {
        AppMethodBeat.i(141058);
        int selectionStart = this.huI.getSelectionStart();
        AppMethodBeat.o(141058);
        return selectionStart;
    }

    public int getSelectionEnd() {
        AppMethodBeat.i(141059);
        int selectionEnd = this.huI.getSelectionEnd();
        AppMethodBeat.o(141059);
        return selectionEnd;
    }

    public void setHandleClickableSpan(boolean z) {
        this.huI.huR = z;
    }

    public void setClickable(boolean z) {
        AppMethodBeat.i(141060);
        super.setClickable(z);
        if (this.huI != null) {
            this.huI.huQ = z;
        }
        AppMethodBeat.o(141060);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(141061);
        if (getTvLayout() == null) {
            AppMethodBeat.o(141061);
            return false;
        }
        boolean w = this.huI.w(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (w) {
            AppMethodBeat.o(141061);
            return true;
        }
        AppMethodBeat.o(141061);
        return onTouchEvent;
    }

    public boolean performClick() {
        AppMethodBeat.i(141062);
        if (this.huI == null) {
            AppMethodBeat.o(141062);
            return false;
        } else if (!this.huI.performClick()) {
            AppMethodBeat.o(141062);
            return false;
        } else {
            boolean performClick = super.performClick();
            AppMethodBeat.o(141062);
            return performClick;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(141063);
        super.onDraw(canvas);
        if (this.huI != null) {
            this.huI.onDraw(canvas);
        }
        AppMethodBeat.o(141063);
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
        AppMethodBeat.i(141064);
        if (this.huI == null) {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(141064);
            return;
        }
        Point cV = this.huI.cV(i2, i3);
        if (cV != null) {
            setMeasuredDimension(cV.x, cV.y);
            AppMethodBeat.o(141064);
            return;
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(141064);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(141065);
        super.onAttachedToWindow();
        AppMethodBeat.o(141065);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(141066);
        super.onDetachedFromWindow();
        AppMethodBeat.o(141066);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.i(141067);
        super.onStartTemporaryDetach();
        AppMethodBeat.o(141067);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.i(141068);
        super.onFinishTemporaryDetach();
        AppMethodBeat.o(141068);
    }

    public int getOrientation() {
        AppMethodBeat.i(141069);
        int i2 = getResources().getConfiguration().orientation;
        Log.i("MicroMsg.StaticTextView", "test test getOrientation ".concat(String.valueOf(i2)));
        AppMethodBeat.o(141069);
        return i2;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(141070);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(141070);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(141071);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!Util.isNullOrNil(getText())) {
            accessibilityEvent.getText().add(getText());
        }
        AppMethodBeat.o(141071);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(141072);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!Util.isNullOrNil(getText())) {
            accessibilityNodeInfo.addAction(256);
            accessibilityNodeInfo.addAction(512);
            accessibilityNodeInfo.setMovementGranularities(31);
            if (d.oD(18)) {
                accessibilityNodeInfo.addAction(131072);
            }
        }
        if (isFocused() && d.oD(18)) {
            accessibilityNodeInfo.addAction(16384);
            accessibilityNodeInfo.addAction(32768);
            accessibilityNodeInfo.addAction(65536);
        }
        if (d.oD(19) && this.huI.getMaxLines() > 1) {
            accessibilityNodeInfo.setMultiLine(true);
        }
        AppMethodBeat.o(141072);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(141073);
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 8192) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(getText()));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(getText()));
            if (!Util.isNullOrNil(getText())) {
                accessibilityEvent.setItemCount(getText().length());
            }
        }
        AppMethodBeat.o(141073);
    }
}
