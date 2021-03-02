package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.k;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.o;
import com.tencent.mm.plugin.appbrand.jsapi.share.q;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.c;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u000eH\u0002J\u0010\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\tH\u0002J\u0010\u00104\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0014J\u0018\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0014J\u000e\u00108\u001a\u00020-2\u0006\u00103\u001a\u00020\u000eJ\u0010\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010;J(\u0010<\u001a\u00020-2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u0013R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/FontTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alignment", "Landroid/text/Layout$Alignment;", "contentLeft", "", "contentPadding", "defaultText", "", "drawStroke", "", "getDrawStroke", "()Z", "setDrawStroke", "(Z)V", "includePadding", "layout", "Landroid/text/StaticLayout;", "lineHeight", "lineSpacing", "maxWidth", "newLayout", "spacingAddition", "spacingMultiplier", "strokePaint", "Landroid/text/TextPaint;", "text", "", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "getTextDrawer", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "setTextDrawer", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;)V", "textPaint", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "line", "lineSpace", "makeNewLayout", "width", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMaxWidth", "setTypeface", "typeface", "Landroid/graphics/Typeface;", "updateText", "color", "strokeColor", "change", "plugin-emojicapture_release"})
public final class FontTextView extends View {
    private final int hbe;
    private final Layout.Alignment huw;
    private TextPaint iW;
    private StaticLayout layout;
    private float maxWidth;
    private String rvd;
    private final float rve;
    private final float rvf;
    private final boolean rvg;
    private TextPaint rvh;
    private float rvi;
    private float rvj;
    private float rvk;
    private boolean rvl;
    private c rvm;
    private boolean rvn;
    private CharSequence text;

    public FontTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(783);
        this.huw = Layout.Alignment.ALIGN_CENTER;
        this.rve = 1.0f;
        this.iW = new TextPaint();
        this.rvh = new TextPaint();
        this.text = "";
        if (context == null) {
            p.hyc();
        }
        float dimension = context.getResources().getDimension(R.dimen.a1k);
        this.rvj = context.getResources().getDimension(R.dimen.a1m);
        this.rvk = context.getResources().getDimension(R.dimen.a1n);
        String string = context.getResources().getString(R.string.an5);
        p.g(string, "context.resources.getStr…pture_emoji_text_default)");
        this.rvd = string;
        this.hbe = a.fromDPToPix(context, 2);
        this.iW.setAntiAlias(true);
        this.iW.setTextSize(dimension);
        this.iW.setColor(Integer.MAX_VALUE);
        float fromDPToPix = (float) a.fromDPToPix(context, 1);
        this.iW.setShadowLayer(fromDPToPix, 0.0f, fromDPToPix, WebView.NIGHT_MODE_COLOR);
        this.rvh.setStrokeWidth(context.getResources().getDimension(R.dimen.a1o));
        this.rvh.setAntiAlias(true);
        this.rvh.setTextSize(this.iW.getTextSize());
        this.rvh.setStyle(Paint.Style.STROKE);
        this.layout = new StaticLayout(this.text, this.iW, getWidth(), this.huw, this.rve, this.rvf, this.rvg);
        this.rvm = new com.tencent.mm.plugin.emojicapture.ui.editor.text.a();
        this.text = this.rvd;
        c cVar = this.rvm;
        if (cVar != null) {
            cVar.setText(this.text);
            AppMethodBeat.o(783);
            return;
        }
        AppMethodBeat.o(783);
    }

    public FontTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FontTextView(Context context) {
        this(context, null);
    }

    public final c getTextDrawer() {
        return this.rvm;
    }

    public final void setTextDrawer(c cVar) {
        this.rvm = cVar;
    }

    public final boolean getDrawStroke() {
        return this.rvn;
    }

    public final void setDrawStroke(boolean z) {
        this.rvn = z;
    }

    public final void setMaxWidth(float f2) {
        this.maxWidth = f2;
    }

    public final void d(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(778);
        if (charSequence == null || charSequence.length() == 0) {
            this.rvn = false;
            this.text = this.rvd;
            this.iW.setColor(Integer.MAX_VALUE);
            float fromDPToPix = (float) a.fromDPToPix(getContext(), 1);
            this.iW.setShadowLayer(fromDPToPix, 0.0f, fromDPToPix, WebView.NIGHT_MODE_COLOR);
        } else {
            this.rvn = true;
            if (charSequence == null) {
                p.hyc();
            }
            this.text = charSequence;
            this.iW.setColor(i2);
            this.iW.clearShadowLayer();
        }
        this.rvh.setColor(i3);
        c cVar = this.rvm;
        if (cVar != null) {
            cVar.setText(this.text);
        }
        c cVar2 = this.rvm;
        if (cVar2 != null) {
            cVar2.refresh();
            AppMethodBeat.o(778);
            return;
        }
        AppMethodBeat.o(778);
    }

    public final void setTypeface(Typeface typeface) {
        AppMethodBeat.i(q.CTRL_INDEX);
        this.iW.setTypeface(typeface);
        this.rvh.setTypeface(typeface);
        AppMethodBeat.o(q.CTRL_INDEX);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(k.CTRL_INDEX);
        p.h(canvas, "canvas");
        canvas.save();
        canvas.translate(-this.rvi, 0.0f);
        a(canvas, 0, 0.0f);
        a(canvas, 1, this.rvk);
        canvas.restore();
        AppMethodBeat.o(k.CTRL_INDEX);
    }

    private final void a(Canvas canvas, int i2, float f2) {
        c cVar;
        AppMethodBeat.i(o.CTRL_INDEX);
        if (i2 < 0 || i2 >= this.layout.getLineCount()) {
            AppMethodBeat.o(o.CTRL_INDEX);
            return;
        }
        float lineLeft = this.layout.getLineLeft(i2) + ((float) getPaddingLeft());
        float lineBaseline = ((float) this.layout.getLineBaseline(i2)) + f2 + ((float) getPaddingTop());
        boolean z = this.layout.getEllipsisCount(i2) > 0;
        int lineStart = z ? this.layout.getLineStart(i2) + this.layout.getEllipsisStart(i2) : this.layout.getLineEnd(i2);
        if (this.rvn && (cVar = this.rvm) != null) {
            cVar.a(canvas, this.layout.getLineStart(i2), lineStart, lineLeft, lineBaseline, this.rvh, z);
        }
        c cVar2 = this.rvm;
        if (cVar2 != null) {
            cVar2.a(canvas, this.layout.getLineStart(i2), lineStart, lineLeft, lineBaseline, this.iW, z);
            AppMethodBeat.o(o.CTRL_INDEX);
            return;
        }
        AppMethodBeat.o(o.CTRL_INDEX);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        int i4;
        AppMethodBeat.i(782);
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        if (((float) size) > this.maxWidth) {
            size = (int) this.maxWidth;
        }
        this.rvl = true;
        int i5 = size - (this.hbe * 2);
        StaticLayout staticLayout = this.layout;
        if (this.rvl && i5 >= 0) {
            c cVar = this.rvm;
            if (cVar != null) {
                cVar.refresh();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                staticLayout = StaticLayout.Builder.obtain(this.text, 0, this.text.length(), this.iW, i5).setAlignment(this.huw).setIncludePad(this.rvg).setMaxLines(2).setLineSpacing(this.rvf, this.rve).setEllipsize(TextUtils.TruncateAt.END).build();
                p.g(staticLayout, "StaticLayout.Builder.obt…                 .build()");
            } else {
                staticLayout = new StaticLayout(this.text, this.iW, i5, this.huw, this.rve, this.rvf, this.rvg);
            }
            this.rvl = false;
        }
        this.layout = staticLayout;
        int lineBottom = this.layout.getLineBottom(0) - this.layout.getLineTop(0);
        if (((float) lineBottom) > this.rvj) {
            this.rvj = (float) lineBottom;
        }
        if (this.layout.getLineCount() <= 1) {
            i4 = (int) this.rvj;
        } else {
            i4 = (int) ((2.0f * this.rvj) + this.rvk);
        }
        int paddingBottom = i4 + getPaddingBottom() + getPaddingTop();
        float lineLeft = this.layout.getLineLeft(0);
        float lineRight = this.layout.getLineRight(0);
        if (this.layout.getLineCount() > 1) {
            if (lineLeft > this.layout.getLineLeft(1)) {
                lineLeft = this.layout.getLineLeft(1);
            }
            if (lineRight < this.layout.getLineRight(1)) {
                lineRight = this.layout.getLineRight(1);
            }
        }
        this.rvi = lineLeft - ((float) this.hbe);
        setMeasuredDimension((int) ((lineRight - lineLeft) + ((float) (this.hbe * 2))), paddingBottom);
        AppMethodBeat.o(782);
    }
}
