package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "Landroid/support/v7/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radius", "setRadius", "", "RoundCornerOutlineProvider", "libmmui_release"})
public final class MMRoundCornerImageView extends AppCompatImageView {
    private int radius;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMRoundCornerImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(204875);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.MMRoundCornerImageView);
            p.g(obtainStyledAttributes, "context.obtainStyledAttr…e.MMRoundCornerImageView)");
            this.radius = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }
        setClipToOutline(true);
        setOutlineProvider(new a(this.radius));
        AppMethodBeat.o(204875);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MMRoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(204876);
        AppMethodBeat.o(204876);
    }

    public final void setRadius(int i2) {
        AppMethodBeat.i(204874);
        this.radius = i2;
        setClipToOutline(true);
        setOutlineProvider(new a(i2));
        AppMethodBeat.o(204874);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/ui/widget/MMRoundCornerImageView$RoundCornerOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "radius", "", "(I)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "libmmui_release"})
    public static final class a extends ViewOutlineProvider {
        private int radius;

        public a(int i2) {
            this.radius = i2;
        }

        public final void getOutline(View view, Outline outline) {
            int i2;
            AppMethodBeat.i(204873);
            if (view != null) {
                i2 = view.getMeasuredWidth();
            } else {
                i2 = 0;
            }
            Rect rect = new Rect(0, 0, i2, view != null ? view.getMeasuredHeight() : 0);
            if (outline != null) {
                outline.setRoundRect(rect, (float) this.radius);
                AppMethodBeat.o(204873);
                return;
            }
            AppMethodBeat.o(204873);
        }
    }
}
