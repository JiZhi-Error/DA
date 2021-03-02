package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 02\u00020\u00012\u00020\u0002:\u000201B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010%\u001a\u00020&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010)\u001a\u00020&H\u0016J\u0018\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020&H\u0016J\u0012\u0010/\u001a\u00020&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter;", "applyLinkPkUserList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "applyListView", "Landroid/support/v7/widget/RecyclerView;", "contentTipLine", "Landroid/view/View;", "contentTipTv", "Landroid/widget/TextView;", "emptyGroup", "emptyView", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "headerView", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "onAnchorApplyListListener", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView$IOnAnchorApplyListListener;", "getOnAnchorApplyListListener", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView$IOnAnchorApplyListListener;", "setOnAnchorApplyListListener", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView$IOnAnchorApplyListListener;)V", "onBind", "", "onClick", "v", "onHideLinkMicPanel", "onKeyboardChange", "show", "", "height", "onNotifyDataChanged", "onTimerUpdateData", "Companion", "IOnAnchorApplyListListener", "plugin-finder_release"})
public final class FinderLiveApplyLinkAnchorView extends FinderLiveApplyLinkView implements View.OnClickListener {
    private static final String TAG = TAG;
    public static final a UNC = new a((byte) 0);
    private final ArrayList<e> UNA;
    private b UNB;
    private final TextView UNw;
    private final RecyclerView UNx;
    private final View UNy;
    private final com.tencent.mm.plugin.finder.live.view.adapter.a UNz;
    private final TextView hSx;
    private final View kgo;
    private g liveData;
    private s ujx;
    private final View ush;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView$IOnAnchorApplyListListener;", "", "onAcceptItemClick", "", "linkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "onInviteAnchorClick", "plugin-finder_release"})
    public interface b {
        void a(e eVar);

        void hTu();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveApplyLinkAnchorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(260801);
        this.UNz = new com.tencent.mm.plugin.finder.live.view.adapter.a();
        this.UNA = new ArrayList<>();
        View.inflate(context, R.layout.cet, this);
        View findViewById = findViewById(R.id.jwc);
        p.g(findViewById, "findViewById(R.id.finder…_link_list_anchor_header)");
        this.kgo = findViewById;
        View findViewById2 = findViewById(R.id.jw_);
        p.g(findViewById2, "findViewById(R.id.finder…st_anchor_content_tip_tv)");
        this.UNw = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.jw7);
        p.g(findViewById3, "findViewById(R.id.finder…list_anchor_content_list)");
        this.UNx = (RecyclerView) findViewById3;
        View findViewById4 = findViewById(R.id.jwb);
        p.g(findViewById4, "findViewById(R.id.finder…k_list_anchor_empty_view)");
        this.hSx = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.jw9);
        p.g(findViewById5, "findViewById(R.id.finder…_anchor_content_tip_line)");
        this.UNy = findViewById5;
        View findViewById6 = findViewById(R.id.jwa);
        p.g(findViewById6, "findViewById(R.id.finder…_list_anchor_empty_group)");
        this.ush = findViewById6;
        this.UNx.setLayoutManager(new LinearLayoutManager());
        this.UNx.setAdapter(this.UNz);
        this.UNz.uzX = new kotlin.g.a.b<e, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkAnchorView.AnonymousClass1 */
            final /* synthetic */ FinderLiveApplyLinkAnchorView UND;

            {
                this.UND = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(e eVar) {
                AppMethodBeat.i(260796);
                e eVar2 = eVar;
                p.h(eVar2, LocaleUtil.ITALIAN);
                b onAnchorApplyListListener = this.UND.getOnAnchorApplyListListener();
                if (onAnchorApplyListListener != null) {
                    onAnchorApplyListListener.a(eVar2);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(260796);
                return xVar;
            }
        };
        this.kgo.setOnClickListener(this);
        AppMethodBeat.o(260801);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260804);
        AppMethodBeat.o(260804);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveApplyLinkAnchorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(260802);
        AppMethodBeat.o(260802);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveApplyLinkAnchorView(Context context) {
        this(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(260803);
        AppMethodBeat.o(260803);
    }

    public final b getOnAnchorApplyListListener() {
        return this.UNB;
    }

    public final void setOnAnchorApplyListListener(b bVar) {
        this.UNB = bVar;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
    public final void a(g gVar, s sVar) {
        List<e> list;
        ArrayList arrayList;
        AppMethodBeat.i(260798);
        String str = TAG;
        StringBuilder sb = new StringBuilder("onBind anchorLinkMicUserList:");
        if (gVar != null) {
            list = gVar.UPX;
        } else {
            list = null;
        }
        Log.i(str, sb.append(list).toString());
        this.liveData = gVar;
        this.ujx = sVar;
        this.UNz.liveData = gVar;
        if (gVar != null) {
            this.UNA.clear();
            ArrayList<e> arrayList2 = this.UNA;
            List<e> list2 = gVar.UPX;
            p.g(list2, "roomData.linkMicUserList");
            List<e> list3 = list2;
            synchronized (list3) {
                try {
                    ArrayList arrayList3 = new ArrayList();
                    for (T t : list3) {
                        if (t.UPN) {
                            arrayList3.add(t);
                        }
                    }
                    arrayList = arrayList3;
                } catch (Throwable th) {
                    AppMethodBeat.o(260798);
                    throw th;
                }
            }
            arrayList2.addAll(arrayList);
            ArrayList<e> arrayList4 = this.UNA;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                this.ush.setVisibility(0);
                this.UNx.setVisibility(8);
                this.UNw.setVisibility(8);
                this.UNy.setVisibility(8);
                AppMethodBeat.o(260798);
                return;
            }
            this.UNx.setVisibility(0);
            this.UNw.setVisibility(0);
            this.UNy.setVisibility(0);
            this.ush.setVisibility(8);
            TextView textView = this.UNw;
            Context context = getContext();
            p.g(context, "context");
            textView.setText(context.getResources().getString(R.string.ja7, Integer.valueOf(this.UNA.size())));
            this.UNz.ad(this.UNA);
            this.UNz.notifyDataSetChanged();
            AppMethodBeat.o(260798);
            return;
        }
        AppMethodBeat.o(260798);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
    public final void l(g gVar) {
        AppMethodBeat.i(260799);
        d.h(new c(this, gVar));
        AppMethodBeat.o(260799);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
    public final void hTH() {
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
    public final void aj(boolean z, int i2) {
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
    public final void cCu() {
    }

    public final void onClick(View view) {
        b bVar;
        AppMethodBeat.i(260800);
        com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
        bVar2.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (!(valueOf == null || valueOf.intValue() != R.id.jwc || (bVar = this.UNB) == null)) {
            bVar.hTu();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(260800);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderLiveApplyLinkAnchorView UND;
        final /* synthetic */ g uga;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderLiveApplyLinkAnchorView finderLiveApplyLinkAnchorView, g gVar) {
            super(0);
            this.UND = finderLiveApplyLinkAnchorView;
            this.uga = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            List<e> list;
            ArrayList arrayList;
            AppMethodBeat.i(260797);
            a aVar = FinderLiveApplyLinkAnchorView.UNC;
            String str = FinderLiveApplyLinkAnchorView.TAG;
            StringBuilder sb = new StringBuilder("onTimerUpdateData linkMicVisitorUserList:");
            g gVar = this.uga;
            if (gVar != null) {
                list = gVar.UPX;
            } else {
                list = null;
            }
            Log.i(str, sb.append(list).toString());
            g gVar2 = this.uga;
            if (gVar2 != null) {
                this.UND.UNA.clear();
                ArrayList arrayList2 = this.UND.UNA;
                List<e> list2 = gVar2.UPX;
                p.g(list2, "roomData.linkMicUserList");
                List<e> list3 = list2;
                synchronized (list3) {
                    try {
                        ArrayList arrayList3 = new ArrayList();
                        for (T t : list3) {
                            if (t.UPN) {
                                arrayList3.add(t);
                            }
                        }
                        arrayList = arrayList3;
                    } catch (Throwable th) {
                        AppMethodBeat.o(260797);
                        throw th;
                    }
                }
                arrayList2.addAll(arrayList);
                ArrayList arrayList4 = this.UND.UNA;
                if (arrayList4 == null || arrayList4.isEmpty()) {
                    this.UND.ush.setVisibility(0);
                    this.UND.UNx.setVisibility(8);
                    this.UND.UNw.setVisibility(8);
                    this.UND.UNy.setVisibility(8);
                } else {
                    this.UND.UNx.setVisibility(0);
                    this.UND.UNw.setVisibility(0);
                    this.UND.UNy.setVisibility(0);
                    this.UND.ush.setVisibility(8);
                    TextView textView = this.UND.UNw;
                    Context context = this.UND.getContext();
                    p.g(context, "context");
                    textView.setText(context.getResources().getString(R.string.ja7, Integer.valueOf(this.UND.UNA.size())));
                    this.UND.UNz.ad(this.UND.UNA);
                    this.UND.UNz.notifyDataSetChanged();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260797);
            return xVar;
        }
    }
}
