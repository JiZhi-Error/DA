package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "clickArea", "Landroid/view/View;", "icon", "Landroid/widget/ImageView;", "likeCntTv", "Landroid/widget/TextView;", "likeIcon", "canClearScreen", "", "updateLikeCnt", "", "likeCnt", "", "plugin-finder_release"})
public final class k extends d {
    private final View clickArea;
    final b hOp;
    private final ImageView kc;
    private final ImageView rNa;
    final TextView umN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246440);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.cou);
        p.g(findViewById, "root.findViewById(R.id.f…ve_camera_opt_click_area)");
        this.clickArea = findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.cov);
        p.g(findViewById2, "root.findViewById(R.id.f…der_live_camera_opt_icon)");
        this.kc = (ImageView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.cn0);
        p.g(findViewById3, "root.findViewById(R.id.f…chor_like_indicator_icon)");
        this.rNa = (ImageView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.cn1);
        p.g(findViewById4, "root.findViewById(R.id.f…anchor_like_indicator_tv)");
        this.umN = (TextView) findViewById4;
        this.clickArea.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.k.AnonymousClass1 */
            final /* synthetic */ k umO;

            {
                this.umO = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246437);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m mVar = m.vVH;
                if (m.i(this.umO.getLiveData())) {
                    u.makeText(viewGroup.getContext(), (int) R.string.cy_, 0).show();
                } else {
                    this.umO.hOp.statusChange(b.c.hNx, new Bundle());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246437);
            }
        });
        ImageView imageView = this.kc;
        Context context = viewGroup.getContext();
        p.g(context, "root.context");
        imageView.setImageDrawable(ar.e(context.getResources().getDrawable(R.raw.icons_filled_beautybox), -1));
        if (!isLandscape()) {
            viewGroup.post(new Runnable() {
                /* class com.tencent.mm.plugin.finder.live.plugin.k.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(246438);
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(246438);
                        throw tVar;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
                    AppMethodBeat.o(246438);
                }
            });
        }
        AppMethodBeat.o(246440);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ long ULj;
        final /* synthetic */ k umO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k kVar, long j2) {
            super(0);
            this.umO = kVar;
            this.ULj = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246439);
            TextView textView = this.umO.umN;
            y yVar = y.vXH;
            textView.setText(y.RN(this.ULj));
            x xVar = x.SXb;
            AppMethodBeat.o(246439);
            return xVar;
        }
    }
}
