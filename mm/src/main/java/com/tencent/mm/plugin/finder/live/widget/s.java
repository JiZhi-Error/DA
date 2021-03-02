package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLuckyMoneyEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "luckyMoneyGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "luckyMoneyIcon", "Landroid/widget/ImageView;", "luckyMoneyTip", "Landroid/widget/TextView;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setVisible", "visible", "", "plugin-finder_release"})
public final class s {
    private final String TAG = "Finder.FinderLiveAnchorLuckyMoneyEntranceWidget";
    private final View UQN = this.hwr.findViewById(R.id.jwm);
    private final TextView UQO = ((TextView) this.hwr.findViewById(R.id.jwn));
    private final ImageView UQP = ((ImageView) this.hwr.findViewById(R.id.jwl));
    private final b hOp;
    public final ViewGroup hwr;
    public final d uFw;

    public s(ViewGroup viewGroup, b bVar, d dVar) {
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(261118);
        this.hwr = viewGroup;
        this.hOp = bVar;
        this.uFw = dVar;
        ImageView imageView = this.UQP;
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        imageView.setImageDrawable(ar.e(context.getResources().getDrawable(R.raw.icon_finder_post_lucky_money), -1));
        this.UQN.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.s.AnonymousClass1 */
            final /* synthetic */ s UQQ;

            {
                this.UQQ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(261117);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLuckyMoneyEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                Object obj = aAh.azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0);
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(261117);
                    throw tVar;
                }
                int intValue = ((Integer) obj).intValue();
                if (intValue != 0 && intValue != 1) {
                    Context context = this.UQQ.hwr.getContext();
                    Context context2 = this.UQQ.hwr.getContext();
                    p.g(context2, "root.context");
                    u.makeText(context, context2.getResources().getString(R.string.jao), 0).show();
                } else if (this.UQQ.hwr.getContext() instanceof Activity) {
                    o oVar = o.ujN;
                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = o.getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        Context context3 = this.UQQ.hwr.getContext();
                        if (context3 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
                            AppMethodBeat.o(261117);
                            throw tVar2;
                        }
                        finderLiveAssistant.bC((Activity) context3);
                    }
                }
                a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLuckyMoneyEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(261117);
            }
        });
        AppMethodBeat.o(261118);
    }
}
