package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0014\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingFailView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "loadingView", "hideLoading", "", "loadFailed", "setOnClickListener", "callback", "Lkotlin/Function0;", "plugin-gamelife_release"})
public final class GameLifeLoadingCoverView extends FrameLayout {
    final View hSw;
    final View ydq;

    public GameLifeLoadingCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, (byte) 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GameLifeLoadingCoverView(Context context, AttributeSet attributeSet, int i2, byte b2) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, 0);
        AppMethodBeat.i(241527);
        AppMethodBeat.o(241527);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GameLifeLoadingCoverView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(241526);
        setBackgroundResource(R.color.f3045c);
        View inflate = aa.jQ(context).inflate(R.layout.atd, (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        addView(inflate, layoutParams);
        this.hSw = findViewById(R.id.ep6);
        this.ydq = findViewById(R.id.epg);
        AppMethodBeat.o(241526);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.a ihE;
        final /* synthetic */ GameLifeLoadingCoverView ydr;

        a(GameLifeLoadingCoverView gameLifeLoadingCoverView, kotlin.g.a.a aVar) {
            this.ydr = gameLifeLoadingCoverView;
            this.ihE = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241524);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView$setOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View view2 = this.ydr.ydq;
            p.g(view2, "loadingFailView");
            view2.setVisibility(8);
            View view3 = this.ydr.hSw;
            p.g(view3, "loadingView");
            view3.setVisibility(0);
            this.ihE.invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView$setOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241524);
        }
    }

    public final void setOnClickListener(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(241525);
        p.h(aVar, "callback");
        this.ydq.setOnClickListener(new a(this, aVar));
        AppMethodBeat.o(241525);
    }
}
