package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001,B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010#\u001a\u00020$H\u0002J\u0016\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "getAnimation", "()Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "setAnimation", "(Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;)V", "callback", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$Callback;)V", "contentView", "Landroid/view/ViewGroup;", "getContentView", "()Landroid/view/ViewGroup;", "desktopView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView;", "getDesktopView", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView;", "spreadPoint", "Landroid/graphics/Point;", "getSpreadPoint", "()Landroid/graphics/Point;", "setSpreadPoint", "(Landroid/graphics/Point;)V", "animateShowDesktopView", "", "hideDesktopView", "reason", "immediately", "", "isDesktopViewShowing", "showDesktopView", "point", "Callback", "plugin-appbrand-integration_release"})
public final class AppBrandDesktopViewContainer extends FrameLayout {
    private final ViewGroup oot;
    private final AppBrandDesktopView oou;
    private Point oov;
    private a oow;
    private e oox;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$Callback;", "", "requestClose", "", "plugin-appbrand-integration_release"})
    public interface a {
    }

    public AppBrandDesktopViewContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private /* synthetic */ AppBrandDesktopViewContainer(Context context, AttributeSet attributeSet, byte b2) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBrandDesktopViewContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(229623);
        View inflate = LayoutInflater.from(context).inflate(R.layout.dk, (ViewGroup) this, false);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(229623);
            throw tVar;
        }
        this.oot = (ViewGroup) inflate;
        View findViewById = this.oot.findViewById(R.id.nt);
        p.g(findViewById, "contentView.findViewById…d.app_brand_desktop_view)");
        this.oou = (AppBrandDesktopView) findViewById;
        ((WeImageView) this.oot.findViewById(R.id.ei)).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopViewContainer.AnonymousClass1 */
            final /* synthetic */ AppBrandDesktopViewContainer ooy;

            {
                this.ooy = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(229618);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.ooy.getCallback();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(229618);
            }
        });
        addView(this.oot, new FrameLayout.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = this.oot.getLayoutParams();
        if (layoutParams == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(229623);
            throw tVar2;
        }
        ((FrameLayout.LayoutParams) layoutParams).topMargin = ao.getStatusBarHeight(context);
        this.oot.setVisibility(8);
        AppMethodBeat.o(229623);
    }

    public final ViewGroup getContentView() {
        return this.oot;
    }

    public final AppBrandDesktopView getDesktopView() {
        return this.oou;
    }

    public final Point getSpreadPoint() {
        return this.oov;
    }

    public final void setSpreadPoint(Point point) {
        this.oov = point;
    }

    public final a getCallback() {
        return this.oow;
    }

    public final void setCallback(a aVar) {
        this.oow = aVar;
    }

    public final e getAnimation() {
        return this.oox;
    }

    public final void setAnimation(e eVar) {
        this.oox = eVar;
    }
}
