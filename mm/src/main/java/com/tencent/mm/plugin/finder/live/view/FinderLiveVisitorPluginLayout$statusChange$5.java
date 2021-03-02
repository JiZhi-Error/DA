package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.l;
import kotlin.t;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class FinderLiveVisitorPluginLayout$statusChange$5 implements View.OnClickListener {
    private byte _hellAccFlag_;
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    FinderLiveVisitorPluginLayout$statusChange$5(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(260860);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout$statusChange$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        s finderLiveAssistant = this.this$0.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            Context context = this.this$0.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(260860);
                throw tVar;
            }
            finderLiveAssistant.g((Activity) context, false);
        }
        a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout$statusChange$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(260860);
    }
}
