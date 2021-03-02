package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\tJ\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderMaxSizeLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "maxHeight", "maxWidth", "getMaxWidth", "initAttribute", "", "onMeasure", "widthSpec", "heightSpec", "setMaxHeight", "setMaxWidth", "plugin-finder_release"})
public final class FinderMaxSizeLayout extends FrameLayout {
    private final String TAG = "Finder.FinderMaxSizeLayout";
    private int maxHeight;
    private int maxWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMaxSizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(247718);
        b(attributeSet, 0);
        AppMethodBeat.o(247718);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMaxSizeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(247719);
        b(attributeSet, i2);
        AppMethodBeat.o(247719);
    }

    public final void setMaxHeight(int i2) {
        this.maxHeight = i2;
    }

    public final void setMaxWidth(int i2) {
        this.maxWidth = i2;
    }

    public final int getMaxWidth() {
        return this.maxWidth;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(247716);
        if (this.maxHeight > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, Integer.MIN_VALUE);
        }
        if (this.maxWidth > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(247716);
    }

    private final void b(AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(247717);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.a.FinderMaxSizeLayout, i2, 0);
            this.maxHeight = (int) obtainStyledAttributes.getDimension(0, 0.0f);
            this.maxWidth = (int) obtainStyledAttributes.getDimension(1, 0.0f);
            obtainStyledAttributes.recycle();
            Log.i(this.TAG, "[initAttribute],maxHeight:" + this.maxHeight + ", maxWidth:" + this.maxWidth);
        }
        AppMethodBeat.o(247717);
    }
}
