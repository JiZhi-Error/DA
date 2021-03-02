package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.b;
import com.tencent.mm.ui.ao;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\tH\u0002J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u0019\u001a\u00020\u00152\b\b\u0001\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u001c\u001a\u00020\u00152\b\b\u0001\u0010\u001a\u001a\u00020\tJ\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekTimeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentTimeTv", "Landroid/widget/TextView;", "hintTextColor", "sumTimeTv", "textColor", "textSize", "formatSecToMin", "", "second", "initAttribute", "", "defStyle", "setCurrentTime", "sec", "setHintTextColor", "color", "setSumTime", "setTextColor", "setTextSize", "unit", "size", "", "plugin-finder_release"})
public final class FinderVideoSeekTimeView extends LinearLayout {
    private int textColor = Integer.MIN_VALUE;
    private int textSize = -1;
    private int wfU = Integer.MIN_VALUE;
    private final TextView wfV;
    private final TextView wfW;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoSeekTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(254377);
        TextView textView = new TextView(getContext());
        ao.a(textView.getPaint(), 0.8f);
        this.wfV = textView;
        TextView textView2 = new TextView(getContext());
        ao.a(textView2.getPaint(), 0.8f);
        this.wfW = textView2;
        setOrientation(0);
        setGravity(17);
        addView(this.wfV);
        addView(this.wfW);
        TextView textView3 = this.wfV;
        Context context2 = getContext();
        p.g(context2, "context");
        textView3.setShadowLayer(6.0f, 0.0f, 0.0f, context2.getResources().getColor(R.color.BW_0_Alpha_0_3));
        TextView textView4 = this.wfW;
        Context context3 = getContext();
        p.g(context3, "context");
        textView4.setShadowLayer(6.0f, 0.0f, 0.0f, context3.getResources().getColor(R.color.BW_0_Alpha_0_3));
        b(attributeSet, 0);
        AppMethodBeat.o(254377);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoSeekTimeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(254378);
        TextView textView = new TextView(getContext());
        ao.a(textView.getPaint(), 0.8f);
        this.wfV = textView;
        TextView textView2 = new TextView(getContext());
        ao.a(textView2.getPaint(), 0.8f);
        this.wfW = textView2;
        setOrientation(0);
        setGravity(17);
        addView(this.wfV);
        addView(this.wfW);
        TextView textView3 = this.wfV;
        Context context2 = getContext();
        p.g(context2, "context");
        textView3.setShadowLayer(6.0f, 0.0f, 0.0f, context2.getResources().getColor(R.color.BW_0_Alpha_0_3));
        TextView textView4 = this.wfW;
        Context context3 = getContext();
        p.g(context3, "context");
        textView4.setShadowLayer(6.0f, 0.0f, 0.0f, context3.getResources().getColor(R.color.BW_0_Alpha_0_3));
        b(attributeSet, i2);
        AppMethodBeat.o(254378);
    }

    private final void b(AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(254371);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.a.FinderVideoSeekTimeView, i2, 0);
        this.textColor = obtainStyledAttributes.getColor(1, Integer.MIN_VALUE);
        this.wfU = obtainStyledAttributes.getColor(0, Integer.MIN_VALUE);
        this.textSize = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (this.textSize != -1) {
            float f2 = (float) this.textSize;
            this.wfV.setTextSize(0, f2);
            this.wfW.setTextSize(0, f2);
        }
        if (this.textColor != Integer.MIN_VALUE) {
            setTextColor(this.textColor);
        }
        if (this.wfU != Integer.MIN_VALUE) {
            setHintTextColor(this.wfU);
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(254371);
    }

    public final void setTextColor(int i2) {
        AppMethodBeat.i(254372);
        this.wfV.setTextColor(i2);
        AppMethodBeat.o(254372);
    }

    public final void setHintTextColor(int i2) {
        AppMethodBeat.i(254373);
        this.wfW.setTextColor(i2);
        AppMethodBeat.o(254373);
    }

    public final void setSumTime(int i2) {
        AppMethodBeat.i(254374);
        this.wfW.setText(" / " + formatSecToMin(i2));
        AppMethodBeat.o(254374);
    }

    public final void setCurrentTime(int i2) {
        AppMethodBeat.i(254375);
        this.wfV.setText(formatSecToMin(i2));
        AppMethodBeat.o(254375);
    }

    private static String formatSecToMin(int i2) {
        AppMethodBeat.i(254376);
        ae aeVar = ae.SYK;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(((long) i2) / 60), Long.valueOf(((long) i2) % 60)}, 2));
        p.g(format, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(254376);
        return format;
    }
}
