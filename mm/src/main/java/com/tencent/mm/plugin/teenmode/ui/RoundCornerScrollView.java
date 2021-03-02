package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/teenmode/ui/RoundCornerScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "radiusF", "", "rect", "Landroid/graphics/RectF;", "TeenModeOutlineProvider", "plugin-teenmode_release"})
public final class RoundCornerScrollView extends ScrollView {
    private final float FWm;
    private final RectF cuN;
    private final Path lR;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoundCornerScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(187472);
        AppMethodBeat.o(187472);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundCornerScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(187473);
        this.FWm = (float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
        this.lR = new Path();
        this.cuN = new RectF();
        setClipToOutline(true);
        setOutlineProvider(new a(this.FWm));
        Context context2 = getContext();
        p.g(context2, "context");
        setBackground(context2.getResources().getDrawable(R.drawable.asw));
        AppMethodBeat.o(187473);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/teenmode/ui/RoundCornerScrollView$TeenModeOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "radius", "", "(F)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-teenmode_release"})
    public static final class a extends ViewOutlineProvider {
        private float radius;

        public a(float f2) {
            this.radius = f2;
        }

        public final void getOutline(View view, Outline outline) {
            AppMethodBeat.i(187471);
            Rect rect = new Rect();
            if (view != null) {
                view.getDrawingRect(rect);
            }
            Rect rect2 = new Rect(0, 0, (rect.right - rect.left) + 0, (rect.bottom - rect.top) + 0);
            if (outline != null) {
                outline.setRoundRect(rect2, this.radius);
                AppMethodBeat.o(187471);
                return;
            }
            AppMethodBeat.o(187471);
        }
    }
}
