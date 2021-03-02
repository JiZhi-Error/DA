package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public int breakStrategy = -1;
    public int fontStyle = -1;
    public int gravity = 51;
    public float huA = 0.0f;
    public float huB = 1.0f;
    public boolean huC = false;
    public int huY = -1;
    public Layout.Alignment huw = Layout.Alignment.ALIGN_NORMAL;
    public TextUtils.TruncateAt hux = null;
    public TextDirectionHeuristic huz = null;
    public TextPaint iW = null;
    public int linkColor = -1;
    public int maxLength = -1;
    public int maxLines = -1;
    public int minLines = -1;
    public Typeface sB = null;
    public int textColor = -1;
    public float textSize = -1.0f;

    public final String toString() {
        AppMethodBeat.i(141134);
        String str = "" + String.format("maxLines: %d ", Integer.valueOf(this.maxLines)) + String.format("maxLength: %d ", Integer.valueOf(this.maxLength)) + String.format("textPaint: %s ", this.iW) + String.format("alignment: %s ", this.huw) + String.format("ellipsize: %s ", this.hux) + String.format("gravity: %s ", Integer.valueOf(this.gravity)) + String.format("ellipsizeWidth: %s ", Integer.valueOf(this.huY)) + String.format("textDirection: %s ", this.huz) + String.format("spacingAdd: %s spacingMult: %s ", Float.valueOf(this.huA), Float.valueOf(this.huB)) + String.format("includedPad: %b ", Boolean.valueOf(this.huC)) + String.format("typeface: %s ", this.sB) + String.format("fontStyle: %d ", Integer.valueOf(this.fontStyle)) + String.format("textSize: %s ", Float.valueOf(this.textSize)) + String.format("textColor: %d", Integer.valueOf(this.textColor)) + String.format("linkColor: %d", Integer.valueOf(this.linkColor)) + String.format("breakStrategy: %d", Integer.valueOf(this.breakStrategy));
        AppMethodBeat.o(141134);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.i(141135);
        int i2 = (this.maxLines * 31) + 0 + (this.maxLength * 31);
        if (this.iW != null) {
            i2 += this.iW.hashCode() * 31;
        }
        int hashCode = i2 + (this.huw.hashCode() * 31);
        if (this.hux != null) {
            hashCode += this.hux.hashCode() * 31;
        }
        int i3 = hashCode + (this.gravity * 31) + (this.huY * 31);
        if (this.huz != null) {
            i3 += this.huz.hashCode() * 31;
        }
        int i4 = ((this.huC ? 1 : 0) * 31) + ((int) (((float) ((int) (((float) i3) + (this.huA * 31.0f)))) + (this.huB * 31.0f)));
        if (this.sB != null) {
            i4 += this.sB.hashCode() * 31;
        }
        int i5 = ((int) (((float) (i4 + (this.fontStyle * 31))) + (this.textSize * 31.0f))) + (this.textColor * 31) + (this.linkColor * 31) + (this.breakStrategy * 31);
        AppMethodBeat.o(141135);
        return i5;
    }
}
