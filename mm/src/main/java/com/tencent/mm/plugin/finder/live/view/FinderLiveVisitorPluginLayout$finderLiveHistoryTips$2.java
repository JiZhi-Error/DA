package com.tencent.mm.plugin.finder.live.view;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ao;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/View;", "invoke"})
public final class FinderLiveVisitorPluginLayout$finderLiveHistoryTips$2 extends q implements a<View> {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$finderLiveHistoryTips$2(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        super(0);
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    @Override // kotlin.g.a.a
    public final View invoke() {
        AppMethodBeat.i(247588);
        View findViewById = this.this$0.findViewById(R.id.cr8);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById.findViewById(R.id.cr_);
            p.g(textView, "textView");
            ao.a(textView.getPaint(), 0.8f);
        }
        AppMethodBeat.o(247588);
        return findViewById;
    }
}
