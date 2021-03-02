package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.aq;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0007H\u0016J@\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerData;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;)V", "msgButtonLen", "", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class az extends e<aq> {
    private int tED;
    final FinderLotteryListContract.Presenter tEE;

    public az(FinderLotteryListContract.Presenter presenter) {
        p.h(presenter, "presenter");
        AppMethodBeat.i(243171);
        this.tEE = presenter;
        AppMethodBeat.o(243171);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, aq aqVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243170);
        aq aqVar2 = aqVar;
        p.h(hVar, "holder");
        p.h(aqVar2, "item");
        hVar.et(aqVar2);
        m mVar = m.uJa;
        d<o> dkb = m.dkb();
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(aqVar2.uOC.iAR);
        View Mn = hVar.Mn(R.id.ett);
        p.g(Mn, "holder.getView<ImageView…id.lottery_winner_avatar)");
        m mVar2 = m.uJa;
        dkb.a(aVar, (ImageView) Mn, m.a(m.a.WX_AVATAR));
        View Mn2 = hVar.Mn(R.id.etu);
        p.g(Mn2, "holder.getView<TextView>….lottery_winner_nickname)");
        ((TextView) Mn2).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), aqVar2.uOC.nickname));
        View Mn3 = hVar.Mn(R.id.hju);
        p.g(Mn3, LocaleUtil.ITALIAN);
        Mn3.setVisibility(this.tEE.uYh ? 0 : 8);
        Mn3.setOnClickListener(new a(this, aqVar2, hVar));
        if (Mn3.getVisibility() == 0 && this.tED == 0) {
            TextView textView = (TextView) hVar.Mn(R.id.d2r);
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ci);
            p.g(textView, "textView");
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            this.tED = Math.max(dimensionPixelOffset, ((int) textView.getPaint().measureText(textView.getText().toString())) + context2.getResources().getDimensionPixelOffset(R.dimen.ce));
        }
        ((TextView) hVar.Mn(R.id.etu)).setPadding(0, 0, this.tED, 0);
        AppMethodBeat.o(243170);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.aek;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243169);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        ao.a(((TextView) hVar.Mn(R.id.d2r)).getPaint(), 0.8f);
        View Mn = hVar.Mn(R.id.hju);
        Mn.post(new b(Mn));
        AppMethodBeat.o(243169);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ View tEH;

        b(View view) {
            this.tEH = view;
        }

        public final void run() {
            AppMethodBeat.i(243168);
            Rect rect = new Rect();
            this.tEH.getHitRect(rect);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ct);
            rect.inset(-dimensionPixelOffset, -dimensionPixelOffset);
            View view = this.tEH;
            p.g(view, "sendMsgBtn");
            ViewParent parent = view.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(243168);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.tEH));
            AppMethodBeat.o(243168);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert$onBindViewHolder$1$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ az tEF;
        final /* synthetic */ aq tEG;
        final /* synthetic */ h tzq;

        a(az azVar, aq aqVar, h hVar) {
            this.tEF = azVar;
            this.tEG = aqVar;
            this.tzq = hVar;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(243167);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            String str2 = this.tEG.uOC.username;
            com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
            d.b dnK = com.tencent.mm.plugin.finder.report.d.dnK();
            String aUg = z.aUg();
            p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            if (str2 == null) {
                str = "";
            } else {
                str = str2;
            }
            dnK.ah(aUg, str, "");
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = this.tzq.getContext();
            p.g(context, "holder.context");
            BaseFeedLoader<bo> baseFeedLoader = this.tEF.tEE.uWg;
            if (baseFeedLoader == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader");
                AppMethodBeat.o(243167);
                throw tVar;
            }
            String str3 = ((FinderLiveLotteryListLoader) baseFeedLoader).tWb;
            BaseFeedLoader<bo> baseFeedLoader2 = this.tEF.tEE.uWg;
            if (baseFeedLoader2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader");
                AppMethodBeat.o(243167);
                throw tVar2;
            }
            long j2 = ((FinderLiveLotteryListLoader) baseFeedLoader2).hFK;
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            Context context2 = this.tzq.getContext();
            p.g(context2, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
            com.tencent.mm.plugin.finder.utils.a.a(context, 1, str2, str3, j2, fH != null ? fH.dIx() : null);
            k kVar = k.vkd;
            k.a(s.f.CLICK_WINNER_AVATAR_ENTER_PRIVATE_MSG_UI, "");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243167);
        }
    }
}
