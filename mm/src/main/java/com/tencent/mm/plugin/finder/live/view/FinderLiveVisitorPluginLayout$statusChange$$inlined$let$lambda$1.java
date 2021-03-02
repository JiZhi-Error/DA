package com.tencent.mm.plugin.finder.live.view;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.plugin.ah;
import com.tencent.mm.plugin.finder.live.plugin.bp;
import com.tencent.mm.plugin.finder.live.plugin.v;
import kotlin.l;
import kotlin.t;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout$statusChange$2$1"})
public final class FinderLiveVisitorPluginLayout$statusChange$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ v $it;
    final /* synthetic */ Bundle $param$inlined;
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    FinderLiveVisitorPluginLayout$statusChange$$inlined$let$lambda$1(v vVar, FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, Bundle bundle) {
        this.$it = vVar;
        this.this$0 = finderLiveVisitorPluginLayout;
        this.$param$inlined = bundle;
    }

    public final void run() {
        ViewGroup viewGroup;
        AppMethodBeat.i(247626);
        Bundle bundle = this.$param$inlined;
        if (bundle == null || !bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
            ah ahVar = this.this$0.inputPluigin;
            if (ahVar != null) {
                ahVar.commentPlugin = null;
            }
            ViewGroup.LayoutParams layoutParams = this.$it.hwr.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(247626);
                throw tVar;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.removeRule(12);
            bp bottomOptionPlugin = this.this$0.getBottomOptionPlugin();
            layoutParams2.addRule(2, (bottomOptionPlugin == null || (viewGroup = bottomOptionPlugin.hwr) == null) ? 0 : viewGroup.getId());
            ViewGroup.LayoutParams layoutParams3 = this.$it.hwr.getLayoutParams();
            if (layoutParams3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247626);
                throw tVar2;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = this.this$0.originCommentBottomMargin;
            AppMethodBeat.o(247626);
            return;
        }
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.this$0;
        ViewGroup.LayoutParams layoutParams4 = this.$it.hwr.getLayoutParams();
        if (layoutParams4 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(247626);
            throw tVar3;
        }
        finderLiveVisitorPluginLayout.originCommentBottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin;
        ah ahVar2 = this.this$0.inputPluigin;
        if (ahVar2 != null) {
            ahVar2.commentPlugin = this.this$0.commentPlugin;
        }
        ViewGroup.LayoutParams layoutParams5 = this.$it.hwr.getLayoutParams();
        if (layoutParams5 == null) {
            t tVar4 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(247626);
            throw tVar4;
        }
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
        layoutParams6.addRule(12);
        layoutParams6.removeRule(2);
        AppMethodBeat.o(247626);
    }
}
