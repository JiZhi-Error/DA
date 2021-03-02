package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class h implements l {
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.l
    public final AppBrandRecentView a(Context context, l.b bVar, l.a aVar) {
        AppMethodBeat.i(227792);
        if (bVar == l.b.TYPE_CONVERSATION) {
            ConversationAppBrandRecentView conversationAppBrandRecentView = new ConversationAppBrandRecentView(context);
            conversationAppBrandRecentView.setSceneFactory(aVar);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.rd));
            conversationAppBrandRecentView.setPadding(0, (int) context.getResources().getDimension(R.dimen.rf), 0, 0);
            conversationAppBrandRecentView.setLayoutParams(layoutParams);
            AppMethodBeat.o(227792);
            return conversationAppBrandRecentView;
        } else if (bVar == l.b.TYPE_MENU) {
            MenuAppBrandRecentView menuAppBrandRecentView = new MenuAppBrandRecentView(context);
            menuAppBrandRecentView.setSceneFactory(aVar);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.rd));
            menuAppBrandRecentView.setPadding(0, (int) context.getResources().getDimension(R.dimen.rf), 0, 0);
            menuAppBrandRecentView.setLayoutParams(layoutParams2);
            AppMethodBeat.o(227792);
            return menuAppBrandRecentView;
        } else {
            AppMethodBeat.o(227792);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.l
    public final void ccV() {
        AppMethodBeat.i(227793);
        Log.i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", 300, 8);
        if (g.aAe().azG().aBb()) {
            ks ksVar = new ks();
            ksVar.dPN.delay = 300;
            ksVar.dPN.type = 8;
            EventCenter.instance.publish(ksVar);
        }
        AppMethodBeat.o(227793);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.l
    public final g ccW() {
        AppMethodBeat.i(227794);
        g gVar = new g();
        AppMethodBeat.o(227794);
        return gVar;
    }
}
