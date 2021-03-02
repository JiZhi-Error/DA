package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.plugin.bp;
import com.tencent.mm.plugin.finder.live.plugin.y;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/VisitorTimerCallbackImpl;", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "tag", "", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;Ljava/lang/String;)V", "rPluginLayout", "Ljava/lang/ref/WeakReference;", "getTag", "()Ljava/lang/String;", "onTimerExpired", "", "plugin-finder_release"})
public final class k implements MTimerHandler.CallBack {
    private final String tag;
    private WeakReference<FinderLiveVisitorPluginLayout> ugd;

    public k(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, String str) {
        p.h(finderLiveVisitorPluginLayout, "pluginLayout");
        p.h(str, "tag");
        AppMethodBeat.i(260873);
        this.tag = str;
        this.ugd = new WeakReference<>(finderLiveVisitorPluginLayout);
        AppMethodBeat.o(260873);
    }

    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
    public final boolean onTimerExpired() {
        String str;
        String str2;
        Integer num = null;
        AppMethodBeat.i(260872);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.ugd.get();
        if (finderLiveVisitorPluginLayout == null) {
            Log.i(this.tag, "VisitorTimerCallbackImpl onTimerExpired curPluginLayout is empty!");
            AppMethodBeat.o(260872);
            return false;
        }
        y commonInfoPlugin = finderLiveVisitorPluginLayout.getCommonInfoPlugin();
        bp bottomOptionPlugin = finderLiveVisitorPluginLayout.getBottomOptionPlugin();
        m mVar = m.vVH;
        String str3 = this.tag;
        StringBuilder sb = new StringBuilder();
        if (commonInfoPlugin != null) {
            str = commonInfoPlugin.name();
        } else {
            str = null;
        }
        StringBuilder append = sb.append(str).append(" visibility:").append(commonInfoPlugin != null ? Integer.valueOf(commonInfoPlugin.hwr.getVisibility()) : null).append(';');
        if (bottomOptionPlugin != null) {
            str2 = bottomOptionPlugin.name();
        } else {
            str2 = null;
        }
        StringBuilder append2 = append.append(str2).append(" visibility:");
        if (bottomOptionPlugin != null) {
            num = Integer.valueOf(bottomOptionPlugin.hwr.getVisibility());
        }
        m.hd(str3, append2.append(num).append(";onlineCnt:").append(finderLiveVisitorPluginLayout.getLiveData().liveInfo.uBn).append(",likeCnt:").append(finderLiveVisitorPluginLayout.getLiveData().UPT).append(",totalCnt:").append(finderLiveVisitorPluginLayout.getLiveData().uDV).toString());
        if (commonInfoPlugin != null && commonInfoPlugin.hwr.getVisibility() == 0) {
            commonInfoPlugin.e(finderLiveVisitorPluginLayout.getLiveData().liveInfo.uBn, finderLiveVisitorPluginLayout.getLiveData().UPT, finderLiveVisitorPluginLayout.getLiveData().uDV);
        }
        if (bottomOptionPlugin != null && bottomOptionPlugin.uuZ.isVisible()) {
            bottomOptionPlugin.uuZ.RE(bottomOptionPlugin.getLiveData().UPT);
        }
        AppMethodBeat.o(260872);
        return true;
    }
}
