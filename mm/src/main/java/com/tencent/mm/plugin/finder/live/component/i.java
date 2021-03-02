package com.tencent.mm.plugin.finder.live.component;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract;", "", "LuckyMoneyState", "Presenter", "ViewCallback", "plugin-finder_release"})
public interface i {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;", "", "(Ljava/lang/String;I)V", "NEW", "OPENED", "ALL_SNATCHED", "plugin-finder_release"})
    public enum a {
        NEW,
        OPENED,
        ALL_SNATCHED;

        static {
            AppMethodBeat.i(260391);
            AppMethodBeat.o(260391);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(260393);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(260393);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\tH&¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "getRedPacketType", "", "onBubbleClick", "", "onBubbleShownChange", "showing", "", "removeLuckyMoneyBySendId", "sendId", "updateStatus", "plugin-finder_release"})
    public interface b extends com.tencent.mm.plugin.finder.presenter.base.a<c> {
        void Fu(boolean z);

        void bxC(String str);

        void deZ();

        boolean hSY();

        String hSZ();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "initView", "", "release", "reset", "resumeLuckyMoneyBubble", "callback", "Lkotlin/Function0;", "updateLotteryStatus", "showing", "", "updateLuckyMoneyCount", "count", "", "updateRefPoint", "point", "Landroid/graphics/PointF;", "plugin-finder_release"})
    public interface c extends com.tencent.mm.plugin.finder.presenter.base.c<b> {
        void Fv(boolean z);

        void awL(int i2);

        void f(PointF pointF);

        void initView();

        void release();
    }
}
