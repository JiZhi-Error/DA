package com.tencent.mm.plugin.gamelife.ui;

import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract;", "", "IConversationPresenter", "IConversationView", "plugin-gamelife_release"})
public interface h {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H&¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;", "", "disableLoadMore", "", "now", "", "dismissLoadingView", "finishLoadMore", "size", "", "getVisibleItemRange", "Lkotlin/Pair;", "initialLoadFailed", "isChattingClosed", "loadMoreFailed", "showEmptyView", "show", "startChatting", "sessionId", "", "selfUsername", "talker", "plugin-gamelife_release"})
    public interface a {
        void OF(int i2);

        boolean anw();

        void at(String str, String str2, String str3);

        void dXr();

        void dXs();

        void dXt();

        o<Integer, Integer> dXu();

        void mB(boolean z);

        void pY(boolean z);
    }
}
