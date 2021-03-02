package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tJ\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderBubbleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "container", "topView", "Landroid/widget/ImageView;", "setBubbleColor", "", "color", "setContent", "resId", "setTopViewMargin", "left", "right", "plugin-finder_release"})
public final class FinderBubbleLayout extends FrameLayout {
    private final FrameLayout container;
    private final ImageView wjQ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderBubbleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254670);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a9r, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.afe);
        p.g(findViewById, "root.findViewById(R.id.bubble_top_view)");
        this.wjQ = (ImageView) findViewById;
        this.wjQ.setEnabled(false);
        View findViewById2 = inflate.findViewById(R.id.afc);
        p.g(findViewById2, "root.findViewById(R.id.bubble_container)");
        this.container = (FrameLayout) findViewById2;
        AppMethodBeat.o(254670);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderBubbleLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(254671);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a9r, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.afe);
        p.g(findViewById, "root.findViewById(R.id.bubble_top_view)");
        this.wjQ = (ImageView) findViewById;
        this.wjQ.setEnabled(false);
        View findViewById2 = inflate.findViewById(R.id.afc);
        p.g(findViewById2, "root.findViewById(R.id.bubble_container)");
        this.container = (FrameLayout) findViewById2;
        AppMethodBeat.o(254671);
    }

    public final void setContent(int i2) {
        AppMethodBeat.i(254668);
        LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) this.container, true);
        AppMethodBeat.o(254668);
    }

    public final void setBubbleColor(int i2) {
        AppMethodBeat.i(254669);
        this.wjQ.setImageDrawable(ar.m(getContext(), R.raw.finder_bubble_arrow, i2));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        Context context = getContext();
        p.g(context, "context");
        gradientDrawable.setCornerRadius(context.getResources().getDimension(R.dimen.bt));
        this.container.setBackground(gradientDrawable);
        AppMethodBeat.o(254669);
    }
}
