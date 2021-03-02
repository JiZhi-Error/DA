package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u0017H\u0002J\u0012\u0010\"\u001a\u00020\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010#\u001a\u00020\u001eJ\"\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J*\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004R6\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0017`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "", "rv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "plugin", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "getPlugin", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "setPlugin", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;)V", "pos", "", "getPos", "()I", "setPos", "(I)V", "recyclerView", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "restartItem", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getRestartItem", "()Ljava/util/HashMap;", "setRestartItem", "(Ljava/util/HashMap;)V", "activatePlugin", "", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "isFromFloat", "deactivatePlugin", "release", "reportWhenSlideLiveRoom", "oldPos", "newPos", "updatePlugins", "newPlugin", "plugin-finder_release"})
public final class f {
    HashMap<Integer, Boolean> UJL = new HashMap<>();
    int pos = -1;
    WxRecyclerView ufR;
    FinderLiveVisitorPluginLayout ufS;

    public f(WxRecyclerView wxRecyclerView) {
        p.h(wxRecyclerView, "rv");
        AppMethodBeat.i(245861);
        this.ufR = wxRecyclerView;
        AppMethodBeat.o(245861);
    }

    public final void release() {
        AppMethodBeat.i(245860);
        FinderLiveViewCallback.a aVar = FinderLiveViewCallback.ufM;
        Log.i(FinderLiveViewCallback.TAG, "release:" + this.ufS);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.ufS;
        if (finderLiveVisitorPluginLayout != null) {
            finderLiveVisitorPluginLayout.checkMiniWindow();
            finderLiveVisitorPluginLayout.unMount();
            AppMethodBeat.o(245860);
            return;
        }
        AppMethodBeat.o(245860);
    }
}
