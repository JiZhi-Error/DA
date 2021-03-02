package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.ai;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\t\b\u0016\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u001c\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016J@\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000f2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J \u0010!\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0006H\u0016R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;I)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1;", "stickItemView", "Landroid/view/View;", "getLayoutId", "isTipFeed", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "floatPosition", "onAttachedToRecyclerView", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "Companion", "plugin-finder_release"})
public final class aj extends e<ai> {
    private static final String tDZ = "1";
    private static final String tEa = "2";
    private static final String tEb = "3";
    private static final int tEc = -2;
    private static boolean[] tEd = new boolean[3];
    private static Integer[] tEe = {Integer.valueOf(tEc), Integer.valueOf(tEc), Integer.valueOf(tEc)};
    public static final a tEf = new a((byte) 0);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, ai aiVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(165428);
        p.h(hVar, "holder");
        p.h(aiVar, "item");
        AppMethodBeat.o(165428);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.y;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004J \u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0004J2\u0010+\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010,\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004J\u0018\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0004H\u0002J\u000e\u00104\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004J\u0016\u00105\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$Companion;", "", "()V", "INVALID_POS", "", "getINVALID_POS", "()I", "TAG", "", "TYPE_FLOATVIEW_TIP", "getTYPE_FLOATVIEW_TIP", "()Ljava/lang/String;", "TYPE_TXT_FLOATVIEW_TIP", "getTYPE_TXT_FLOATVIEW_TIP", "TYPE_TXT_TIP", "getTYPE_TXT_TIP", "floatModeSet", "", "getFloatModeSet", "()[Z", "setFloatModeSet", "([Z)V", "floatPositionSet", "", "getFloatPositionSet", "()[Ljava/lang/Integer;", "setFloatPositionSet", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "changeToDecorView", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "parent", "Landroid/view/ViewGroup;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "isHard", "", "tabType", "changeToItemView", "stickView", "Landroid/view/View;", "clickRefreshTipView", "isFloat", "getFloatPosition", "getIndex", "type", "gotoMachine", "context", "Landroid/content/Context;", "position", "isFloatMode", "reset", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private static int getIndex(int i2) {
            switch (i2) {
                case 1:
                    return 1;
                case 2:
                default:
                    return 2;
                case 3:
                    return 0;
            }
        }

        public static void a(ai.b bVar, int i2) {
            AppMethodBeat.i(243109);
            p.h(bVar, "viewCallback");
            if (!aj.tEd[getIndex(i2)]) {
                AppMethodBeat.o(243109);
                return;
            }
            View findViewById = bVar.getRootView().findViewById(R.id.d3u);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            aj.tEd[getIndex(i2)] = false;
            AppMethodBeat.o(243109);
        }
    }

    static {
        AppMethodBeat.i(165430);
        AppMethodBeat.o(165430);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        AppMethodBeat.i(178135);
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
        AppMethodBeat.o(178135);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(165427);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(165427);
    }
}
