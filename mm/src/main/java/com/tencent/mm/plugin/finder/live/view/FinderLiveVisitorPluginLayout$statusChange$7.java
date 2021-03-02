package com.tencent.mm.plugin.finder.live.view;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.plugin.aq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class FinderLiveVisitorPluginLayout$statusChange$7 implements View.OnClickListener {
    private byte _hellAccFlag_;
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    FinderLiveVisitorPluginLayout$statusChange$7(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(260862);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout$statusChange$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        aq aqVar = this.this$0.bottomTipPlugin;
        if (aqVar != null) {
            aqVar.hRy.hide();
        }
        a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout$statusChange$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(260862);
    }
}
