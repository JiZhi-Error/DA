package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserIconImageView;", "Landroid/support/v7/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pressedColor", "drawableStateChanged", "", "switchNormalState", "switchPressState", "Companion", "plugin-webview_release"})
public final class BrowserIconImageView extends AppCompatImageView {
    public static final a Jmj = new a((byte) 0);
    private int Jmi;

    static {
        AppMethodBeat.i(210468);
        AppMethodBeat.o(210468);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserIconImageView$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BrowserIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(210466);
        AppMethodBeat.o(210466);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrowserIconImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(210467);
        this.Jmi = getResources().getColor(R.color.aa);
        AppMethodBeat.o(210467);
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public final void drawableStateChanged() {
        Drawable mutate;
        AppMethodBeat.i(210464);
        super.drawableStateChanged();
        if (!isEnabled() || !isFocusable()) {
            ggw();
            AppMethodBeat.o(210464);
        } else if (isPressed()) {
            Drawable drawable = getDrawable();
            if (drawable == null || (mutate = drawable.mutate()) == null) {
                AppMethodBeat.o(210464);
                return;
            }
            mutate.setColorFilter(new PorterDuffColorFilter(this.Jmi, PorterDuff.Mode.SRC_ATOP));
            AppMethodBeat.o(210464);
        } else {
            ggw();
            AppMethodBeat.o(210464);
        }
    }

    private final void ggw() {
        Drawable mutate;
        AppMethodBeat.i(210465);
        Drawable drawable = getDrawable();
        if (drawable == null || (mutate = drawable.mutate()) == null) {
            AppMethodBeat.o(210465);
            return;
        }
        mutate.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        AppMethodBeat.o(210465);
    }
}
