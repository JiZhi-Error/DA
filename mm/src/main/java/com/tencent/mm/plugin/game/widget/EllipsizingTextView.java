package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class EllipsizingTextView extends TextView {
    private float jLu = 1.0f;
    private int maxLines = -1;
    private final List<Object> xZQ = new ArrayList();
    private boolean xZR;
    private boolean xZS;
    private boolean xZT;
    private String xZU;
    private float xZV = 0.0f;

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42611);
        AppMethodBeat.o(42611);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(42612);
        AppMethodBeat.o(42612);
    }

    public void setMaxLines(int i2) {
        AppMethodBeat.i(42613);
        super.setMaxLines(i2);
        this.maxLines = i2;
        this.xZS = true;
        AppMethodBeat.o(42613);
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public void setLineSpacing(float f2, float f3) {
        AppMethodBeat.i(42614);
        this.xZV = f2;
        this.jLu = f3;
        super.setLineSpacing(f2, f3);
        AppMethodBeat.o(42614);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        AppMethodBeat.i(42615);
        super.onTextChanged(charSequence, i2, i3, i4);
        if (!this.xZT) {
            this.xZU = charSequence.toString();
            this.xZS = true;
        }
        AppMethodBeat.o(42615);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r9) {
        /*
        // Method dump skipped, instructions count: 207
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.widget.EllipsizingTextView.onDraw(android.graphics.Canvas):void");
    }

    private Layout aAP(String str) {
        AppMethodBeat.i(42617);
        StaticLayout staticLayout = new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.jLu, this.xZV, false);
        AppMethodBeat.o(42617);
        return staticLayout;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
