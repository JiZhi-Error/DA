package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.b.m;
import com.tencent.mm.live.c.b;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\nR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentCallback", "Lkotlin/Function1;", "", "", "inputHintDescTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "inputHintTv", "Landroid/view/View;", "inputImg", "Landroid/widget/ImageView;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "udpateBanCommentState", "plugin-logic_release"})
public final class bg extends a {
    final b hOy;
    private final b<String, x> hPv = new a(this);
    private final ImageView hSV;
    private final View hSW;
    private final TextView hSX;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "invoke"})
    static final class a extends q implements b<String, x> {
        final /* synthetic */ bg hSY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(bg bgVar) {
            super(1);
            this.hSY = bgVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(208215);
            p.h(str, "<anonymous parameter 0>");
            d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.live.c.bg.a.AnonymousClass1 */
                final /* synthetic */ a hSZ;

                {
                    this.hSZ = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(208214);
                    this.hSZ.hSY.aHM();
                    x xVar = x.SXb;
                    AppMethodBeat.o(208214);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(208215);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bg(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(208218);
        this.hOy = bVar;
        this.hSV = (ImageView) viewGroup.findViewById(R.id.ehi);
        this.hSW = viewGroup.findViewById(R.id.ehh);
        this.hSX = (TextView) viewGroup.findViewById(R.id.ehf);
        aHM();
        this.hSW.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.bg.AnonymousClass1 */
            final /* synthetic */ bg hSY;

            {
                this.hSY = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208212);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                if (com.tencent.mm.live.b.x.aGr().KNv) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
                    this.hSY.hOy.statusChange(b.c.hMd, bundle);
                } else {
                    u.makeText(viewGroup.getContext(), com.tencent.mm.cb.a.aI(viewGroup.getContext(), R.string.ejq), 0).show();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208212);
            }
        });
        if (viewGroup.findViewById(R.id.bf8) != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = au.aD(viewGroup.getContext());
            View findViewById = viewGroup.findViewById(R.id.bf8);
            p.g(findViewById, "root.findViewById<Relati…>(R.id.content_root_view)");
            ((RelativeLayout) findViewById).setLayoutParams(layoutParams);
        }
        m mVar = m.hGg;
        m.a(name(), this.hPv);
        AppMethodBeat.o(208218);
    }

    public final void aHM() {
        AppMethodBeat.i(208216);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGr().KNv) {
            TextView textView = this.hSX;
            p.g(textView, "inputHintDescTv");
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            textView.setText(context.getResources().getString(R.string.egg));
            ImageView imageView = this.hSV;
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            imageView.setImageDrawable(ar.e(context2.getResources().getDrawable(R.raw.icons_filled_chat), -1));
            AppMethodBeat.o(208216);
            return;
        }
        TextView textView2 = this.hSX;
        p.g(textView2, "inputHintDescTv");
        Context context3 = this.hwr.getContext();
        p.g(context3, "root.context");
        textView2.setText(context3.getResources().getString(R.string.egg));
        ImageView imageView2 = this.hSV;
        Context context4 = this.hwr.getContext();
        p.g(context4, "root.context");
        imageView2.setImageDrawable(ar.e(context4.getResources().getDrawable(R.raw.icons_filled_ban_comment), -1));
        AppMethodBeat.o(208216);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208217);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (bh.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                rg(8);
                AppMethodBeat.o(208217);
                return;
            case 3:
                rg(0);
                AppMethodBeat.o(208217);
                return;
            case 4:
                if (bundle == null || !bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                    rg(0);
                    break;
                } else {
                    rg(8);
                    AppMethodBeat.o(208217);
                    return;
                }
        }
        AppMethodBeat.o(208217);
    }
}
