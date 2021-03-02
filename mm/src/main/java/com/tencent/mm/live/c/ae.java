package com.tencent.mm.live.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.b.d.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0018\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u0016J\u001a\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blurView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "networkErrTip", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "forceSetVisible", "", "visible", "", "hideProgress", "setVisible", "showBlurBg", ch.COL_USERNAME, "", "showLoadingWithBlurBg", "showProgress", "showTipWithBlurBg", "tip", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ae extends a {
    private static final long FADE_OUT_DURATION = FADE_OUT_DURATION;
    public static final a hRk = new a((byte) 0);
    private final b hOp;
    private final RelativeLayout hRi;
    private final TextView hRj;
    private final ProgressBar progressBar;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Bitmap;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ ae hRl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ae aeVar) {
            super(1);
            this.hRl = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            AppMethodBeat.i(208083);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                RelativeLayout relativeLayout = this.hRl.hRi;
                p.g(relativeLayout, "blurView");
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                relativeLayout.setBackground(new BitmapDrawable(context.getResources(), bitmap2));
            }
            ProgressBar progressBar = this.hRl.progressBar;
            p.g(progressBar, "progressBar");
            progressBar.setVisibility(0);
            TextView textView = this.hRl.hRj;
            p.g(textView, "networkErrTip");
            textView.setVisibility(8);
            x xVar = x.SXb;
            AppMethodBeat.o(208083);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Bitmap;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ ae hRl;
        final /* synthetic */ String hRn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ae aeVar, String str) {
            super(1);
            this.hRl = aeVar;
            this.hRn = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            AppMethodBeat.i(208084);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                RelativeLayout relativeLayout = this.hRl.hRi;
                p.g(relativeLayout, "blurView");
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                relativeLayout.setBackground(new BitmapDrawable(context.getResources(), bitmap2));
            }
            ProgressBar progressBar = this.hRl.progressBar;
            p.g(progressBar, "progressBar");
            progressBar.setVisibility(8);
            TextView textView = this.hRl.hRj;
            p.g(textView, "networkErrTip");
            textView.setVisibility(0);
            TextView textView2 = this.hRl.hRj;
            p.g(textView2, "networkErrTip");
            textView2.setText(this.hRn);
            x xVar = x.SXb;
            AppMethodBeat.o(208084);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ae(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208089);
        this.hOp = bVar;
        this.hRi = (RelativeLayout) viewGroup.findViewById(R.id.ei4);
        this.progressBar = (ProgressBar) viewGroup.findViewById(R.id.ei3);
        this.hRj = (TextView) viewGroup.findViewById(R.id.fuw);
        AppMethodBeat.o(208089);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin$Companion;", "", "()V", "FADE_OUT_DURATION", "", "getFADE_OUT_DURATION", "()J", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(208090);
        AppMethodBeat.o(208090);
    }

    public final void Hc(String str) {
        AppMethodBeat.i(208085);
        RelativeLayout relativeLayout = this.hRi;
        p.g(relativeLayout, "blurView");
        relativeLayout.setVisibility(0);
        if (Util.isNullOrNil(str)) {
            ProgressBar progressBar2 = this.progressBar;
            p.g(progressBar2, "progressBar");
            progressBar2.setVisibility(0);
            TextView textView = this.hRj;
            p.g(textView, "networkErrTip");
            textView.setVisibility(8);
            AppMethodBeat.o(208085);
            return;
        }
        a.C0373a aVar = com.tencent.mm.live.b.d.a.hLg;
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        String aGt = com.tencent.mm.live.b.x.aGt();
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        a.C0373a.a(aGt, context.getResources().getColor(R.color.xg), new c(this));
        this.hwr.setVisibility(0);
        AppMethodBeat.o(208085);
    }

    public final void showTipWithBlurBg(String str, String str2) {
        AppMethodBeat.i(208086);
        p.h(str2, "tip");
        RelativeLayout relativeLayout = this.hRi;
        p.g(relativeLayout, "blurView");
        relativeLayout.setVisibility(0);
        if (Util.isNullOrNil(str)) {
            ProgressBar progressBar2 = this.progressBar;
            p.g(progressBar2, "progressBar");
            progressBar2.setVisibility(8);
            TextView textView = this.hRj;
            p.g(textView, "networkErrTip");
            textView.setVisibility(0);
            TextView textView2 = this.hRj;
            p.g(textView2, "networkErrTip");
            textView2.setText(str2);
            AppMethodBeat.o(208086);
            return;
        }
        a.C0373a aVar = com.tencent.mm.live.b.d.a.hLg;
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        String aGt = com.tencent.mm.live.b.x.aGt();
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        a.C0373a.a(aGt, context.getResources().getColor(R.color.xg), new d(this, str2));
        this.hwr.setVisibility(0);
        AppMethodBeat.o(208086);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/live/plugin/LiveLoadingPlugin$setVisible$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
    public static final class b implements Animation.AnimationListener {
        final /* synthetic */ ae hRl;
        final /* synthetic */ int hRm;

        b(ae aeVar, int i2) {
            this.hRl = aeVar;
            this.hRm = i2;
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(208082);
            this.hRl.hwr.setVisibility(this.hRm);
            AppMethodBeat.o(208082);
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208088);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (af.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(8);
                AppMethodBeat.o(208088);
                return;
            case 4:
                ProgressBar progressBar2 = this.progressBar;
                p.g(progressBar2, "progressBar");
                progressBar2.setVisibility(8);
                AppMethodBeat.o(208088);
                return;
            case 5:
                ProgressBar progressBar3 = this.progressBar;
                p.g(progressBar3, "progressBar");
                progressBar3.setVisibility(0);
                RelativeLayout relativeLayout = this.hRi;
                p.g(relativeLayout, "blurView");
                relativeLayout.setVisibility(8);
                TextView textView = this.hRj;
                p.g(textView, "networkErrTip");
                textView.setVisibility(8);
                this.hwr.setVisibility(0);
                break;
        }
        AppMethodBeat.o(208088);
    }

    @Override // com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(208087);
        if (this.hwr.getVisibility() == i2) {
            AppMethodBeat.o(208087);
        } else if (i2 == 0) {
            this.hwr.setVisibility(i2);
            AppMethodBeat.o(208087);
        } else {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.hwr.getContext(), R.anim.bs);
            p.g(loadAnimation, "animation");
            loadAnimation.setDuration(FADE_OUT_DURATION);
            loadAnimation.setAnimationListener(new b(this, i2));
            this.hwr.startAnimation(loadAnimation);
            this.hwr.invalidate();
            AppMethodBeat.o(208087);
        }
    }
}
