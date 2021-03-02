package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ah;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0002\u000f\u001e\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001DB\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\tH\u0002J\u0018\u00101\u001a\u0002022\u0006\u0010*\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J@\u00106\u001a\u0002022\u0006\u00104\u001a\u0002052\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\u00182\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0016J(\u0010>\u001a\u0002022\u0006\u0010*\u001a\u00020+2\u0006\u00107\u001a\u00020\u00022\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020.H\u0002J \u0010B\u001a\u0002022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00104\u001a\u0002052\u0006\u00109\u001a\u00020.H\u0016J\u0018\u0010C\u001a\u0002022\u0006\u00100\u001a\u00020\t2\u0006\u00107\u001a\u00020\u0002H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "lifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1;", "linkLayout", "loadMoreLayout", "rect2", "Landroid/graphics/Rect;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "reportExpose", "", "getReportExpose", "()Z", "setReportExpose", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1;", "streamCardVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "getStreamCardVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "streamCardVM$delegate", "Lkotlin/Lazy;", "titleLayoutSet", "Ljava/util/LinkedList;", "viewRect", "createTitleLayout", "context", "Landroid/content/Context;", "parent", "getLayoutId", "", "isViewExposed", "view", "jumpToHotTab", "", "Lcom/tencent/mm/ui/MMActivity;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onClickTopic", "txt", "", FirebaseAnalytics.b.INDEX, "onCreateViewHolder", "setFinderStreamTxtCard", "Companion", "plugin-finder_release"})
public final class ci extends com.tencent.mm.view.recyclerview.e<ah> {
    public static final a tGU = new a((byte) 0);
    View aus;
    private RecyclerView hak;
    private BaseFinderFeedLoader tFM;
    private final LinkedList<View> tGN;
    private View tGO;
    private View tGP;
    private final kotlin.f tGQ;
    private final d tGR;
    boolean tGS;
    private final FinderStreamCardTxtConvert$lifecycleObserver$1 tGT;
    private final Rect tGl;
    private bbn ttO;
    private final Rect viewRect;

    static {
        AppMethodBeat.i(243348);
        AppMethodBeat.o(243348);
    }

    private /* synthetic */ ci() {
        this(null);
    }

    public ci(BaseFinderFeedLoader baseFinderFeedLoader) {
        AppMethodBeat.i(243347);
        this.tFM = baseFinderFeedLoader;
        this.tGN = new LinkedList<>();
        this.tGQ = kotlin.g.ah(g.tHb);
        this.viewRect = new Rect();
        this.tGl = new Rect();
        this.tGR = new d(this);
        this.tGS = true;
        this.tGT = new FinderStreamCardTxtConvert$lifecycleObserver$1(this);
        AppMethodBeat.o(243347);
    }

    public static final /* synthetic */ bbn b(ci ciVar) {
        AppMethodBeat.i(243352);
        bbn bbn = ciVar.ttO;
        if (bbn == null) {
            p.btv("contextObj");
        }
        AppMethodBeat.o(243352);
        return bbn;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, ah ahVar, int i2, int i3, boolean z, List list) {
        View view;
        int i4;
        AppMethodBeat.i(243346);
        ah ahVar2 = ahVar;
        p.h(hVar, "holder");
        p.h(ahVar2, "item");
        ahVar2.position = i2;
        this.aus = hVar.aus;
        View view2 = hVar.aus;
        p.g(view2, "holder.itemView");
        view2.setTag(ahVar2);
        View view3 = hVar.aus;
        p.g(view3, "holder.itemView");
        this.tGO = (LinearLayout) view3.findViewById(R.id.eow);
        View view4 = hVar.aus;
        p.g(view4, "holder.itemView");
        this.tGP = (LinearLayout) view4.findViewById(R.id.ec7);
        View view5 = hVar.aus;
        p.g(view5, "holder.itemView");
        LinearLayout linearLayout = (LinearLayout) view5.findViewById(R.id.ec9);
        p.g(linearLayout, "view.linkTitleLayout");
        int childCount = linearLayout.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            this.tGN.add(((LinearLayout) view5.findViewById(R.id.ec9)).getChildAt(i5));
        }
        ((LinearLayout) view5.findViewById(R.id.ec9)).removeAllViews();
        bdb bdb = ahVar2.tQX;
        if (bdb.LMR.size() <= 0) {
            LinearLayout linearLayout2 = (LinearLayout) view5.findViewById(R.id.ec7);
            p.g(linearLayout2, "view.linkLayout");
            linearLayout2.setVisibility(8);
        } else {
            LinearLayout linearLayout3 = (LinearLayout) view5.findViewById(R.id.ec7);
            p.g(linearLayout3, "view.linkLayout");
            linearLayout3.setVisibility(0);
            kotlin.k.d a2 = j.a((kotlin.k.d) j.mY(0, bdb.LMR.size()), 2);
            int i6 = a2.SYU;
            int i7 = a2.SYV;
            int i8 = a2.lCq;
            if (i8 < 0 ? i6 >= i7 : i6 <= i7) {
                while (true) {
                    Context context = view5.getContext();
                    p.g(context, "view.context");
                    View poll = this.tGN.poll();
                    if (poll == null) {
                        view = aa.jQ(context).inflate(R.layout.a8i, (ViewGroup) null, false);
                        p.g(view, "MMLayoutInflater.getInfl…opic_layout, null, false)");
                    } else {
                        view = poll;
                    }
                    LinearLayout linearLayout4 = (LinearLayout) view5.findViewById(R.id.ec9);
                    if (linearLayout4 != null) {
                        linearLayout4.addView(view);
                        TextView textView = (TextView) view.findViewById(R.id.itg);
                        p.g(textView, "titleLayout.topic_1");
                        ao.a(textView.getPaint(), 0.8f);
                        TextView textView2 = (TextView) view.findViewById(R.id.ith);
                        p.g(textView2, "titleLayout.topic_2");
                        ao.a(textView2.getPaint(), 0.8f);
                        TextView textView3 = (TextView) view.findViewById(R.id.itg);
                        p.g(textView3, "titleLayout.topic_1");
                        textView3.setText(bdb.LMR.get(i6));
                        if (bdb.LMR.size() > i6 + 1) {
                            View findViewById = view.findViewById(R.id.ebr);
                            p.g(findViewById, "titleLayout.line");
                            findViewById.setVisibility(0);
                            TextView textView4 = (TextView) view.findViewById(R.id.ith);
                            p.g(textView4, "titleLayout.topic_2");
                            textView4.setText(bdb.LMR.get(i6 + 1));
                            ((TextView) view.findViewById(R.id.ith)).setOnClickListener(new e(this, view5, ahVar2, view, i6));
                        } else {
                            View findViewById2 = view.findViewById(R.id.ebr);
                            p.g(findViewById2, "titleLayout.line");
                            findViewById2.setVisibility(8);
                            TextView textView5 = (TextView) view.findViewById(R.id.ith);
                            p.g(textView5, "titleLayout.topic_2");
                            textView5.setText("");
                            ((TextView) view.findViewById(R.id.ith)).setOnClickListener(null);
                        }
                        ((TextView) view.findViewById(R.id.itg)).setOnClickListener(new f(this, view5, ahVar2, view, i6));
                        if (i6 == i7) {
                            break;
                        }
                        i6 += i8;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(243346);
                        throw tVar;
                    }
                }
            }
        }
        View view6 = hVar.aus;
        p.g(view6, "holder.itemView");
        TextView textView6 = (TextView) view6.findViewById(R.id.ipm);
        p.g(textView6, "holder.itemView.title");
        textView6.setText(ahVar2.tQX.LMQ);
        if (ahVar2.tQU.length() > 0) {
            View view7 = hVar.aus;
            p.g(view7, "holder.itemView");
            TextView textView7 = (TextView) view7.findViewById(R.id.fjq);
            p.g(textView7, "holder.itemView.moreTitle");
            textView7.setText(ahVar2.tQU);
        }
        View view8 = hVar.aus;
        p.g(view8, "holder.itemView");
        LinearLayout linearLayout5 = (LinearLayout) view8.findViewById(R.id.eow);
        p.g(linearLayout5, "holder.itemView.loadMoreLayout");
        if (ahVar2.tQT == 0) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        linearLayout5.setVisibility(i4);
        AppMethodBeat.o(243346);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "isExposed", "", "()Z", "setExposed", "(Z)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class d extends RecyclerView.l {
        boolean tGL;
        final /* synthetic */ ci tGW;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(243340);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(243340);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(ci ciVar) {
            this.tGW = ciVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(243339);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                recyclerView.post(new a(this));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(243339);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ d tGX;

            a(d dVar) {
                this.tGX = dVar;
            }

            public final void run() {
                ah ahVar = null;
                int i2 = 0;
                AppMethodBeat.i(243338);
                View view = this.tGX.tGW.aus;
                if (view != null) {
                    boolean a2 = ci.a(this.tGX.tGW, view);
                    if (!this.tGX.tGL && a2) {
                        this.tGX.tGL = true;
                        View view2 = this.tGX.tGW.tGO;
                        if (view2 != null) {
                            i2 = view2.getHeight();
                        }
                        if (i2 > 0) {
                            Object tag = view.getTag();
                            if (tag instanceof ah) {
                                ahVar = tag;
                            }
                            ah ahVar2 = (ah) ahVar;
                            if (ahVar2 != null) {
                                com.tencent.mm.plugin.finder.report.t tVar = com.tencent.mm.plugin.finder.report.t.vhJ;
                                com.tencent.mm.plugin.finder.report.t.a(ahVar2.tQV, ahVar2.tQW, ahVar2.position, 1, ci.b(this.tGX.tGW));
                                AppMethodBeat.o(243338);
                                return;
                            }
                        }
                    } else if (this.tGX.tGL && !a2) {
                        this.tGX.tGL = false;
                        View view3 = this.tGX.tGW.tGP;
                        if (view3 != null) {
                            i2 = view3.getHeight();
                        }
                        if (i2 > 0) {
                            Object tag2 = view.getTag();
                            if (tag2 instanceof ah) {
                                ahVar = tag2;
                            }
                            ah ahVar3 = ahVar;
                            if (ahVar3 != null) {
                                com.tencent.mm.plugin.finder.report.t tVar2 = com.tencent.mm.plugin.finder.report.t.vhJ;
                                com.tencent.mm.plugin.finder.report.t.a(ahVar3.tQV, ahVar3.tQW, ahVar3.position, ahVar3.tQX, "", ci.b(this.tGX.tGW));
                            }
                        }
                    }
                    AppMethodBeat.o(243338);
                    return;
                }
                AppMethodBeat.o(243338);
            }
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.n;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243345);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        this.hak = recyclerView;
        recyclerView.b(this.tGR);
        recyclerView.a(this.tGR);
        Context context = recyclerView.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(243345);
            throw tVar;
        }
        ((MMActivity) context).getLifecycle().removeObserver(this.tGT);
        Context context2 = recyclerView.getContext();
        if (context2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(243345);
            throw tVar2;
        }
        ((MMActivity) context2).getLifecycle().addObserver(this.tGT);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Context context3 = hVar.getContext();
        if (context3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(243345);
            throw tVar3;
        }
        this.ttO = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((MMActivity) context3).get(FinderReporterUIC.class)).dIx();
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        TextView textView = (TextView) view.findViewById(R.id.ipm);
        p.g(textView, "holder.itemView.title");
        ao.a(textView.getPaint(), 0.8f);
        View view2 = hVar.aus;
        p.g(view2, "holder.itemView");
        TextView textView2 = (TextView) view2.findViewById(R.id.fjq);
        p.g(textView2, "holder.itemView.moreTitle");
        ao.a(textView2.getPaint(), 0.8f);
        View view3 = hVar.aus;
        p.g(view3, "holder.itemView");
        ((LinearLayout) view3.findViewById(R.id.eow)).setOnClickListener(new c(this, hVar));
        AppMethodBeat.o(243345);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ ci tGW;

        c(ci ciVar, h hVar) {
            this.tGW = ciVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243337);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ci ciVar = this.tGW;
            Context context = this.qhp.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(243337);
                throw tVar;
            }
            ci.a(ciVar, (MMActivity) context, this.qhp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243337);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ View hCI;
        final /* synthetic */ ci tGW;
        final /* synthetic */ ah tGY;
        final /* synthetic */ View tGZ;
        final /* synthetic */ int tHa;

        e(ci ciVar, View view, ah ahVar, View view2, int i2) {
            this.tGW = ciVar;
            this.hCI = view;
            this.tGY = ahVar;
            this.tGZ = view2;
            this.tHa = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243341);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ci ciVar = this.tGW;
            Context context = this.hCI.getContext();
            p.g(context, "view.context");
            ah ahVar = this.tGY;
            TextView textView = (TextView) this.tGZ.findViewById(R.id.ith);
            p.g(textView, "titleLayout.topic_2");
            ci.a(ciVar, context, ahVar, textView.getText().toString(), this.tHa + 1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243341);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ View hCI;
        final /* synthetic */ ci tGW;
        final /* synthetic */ ah tGY;
        final /* synthetic */ View tGZ;
        final /* synthetic */ int tHa;

        f(ci ciVar, View view, ah ahVar, View view2, int i2) {
            this.tGW = ciVar;
            this.hCI = view;
            this.tGY = ahVar;
            this.tGZ = view2;
            this.tHa = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243342);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ci ciVar = this.tGW;
            Context context = this.hCI.getContext();
            p.g(context, "view.context");
            ah ahVar = this.tGY;
            TextView textView = (TextView) this.tGZ.findViewById(R.id.itg);
            p.g(textView, "titleLayout.topic_1");
            ci.a(ciVar, context, ahVar, textView.getText().toString(), this.tHa);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243342);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "invoke"})
    static final class g extends q implements kotlin.g.a.a<FinderStreamCardVM> {
        public static final g tHb = new g();

        static {
            AppMethodBeat.i(243344);
            AppMethodBeat.o(243344);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderStreamCardVM invoke() {
            AppMethodBeat.i(243343);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderStreamCardVM finderStreamCardVM = (FinderStreamCardVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class);
            AppMethodBeat.o(243343);
            return finderStreamCardVM;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.bw.b tGV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(com.tencent.mm.bw.b bVar) {
            super(0);
            this.tGV = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String encodeHexString;
            AppMethodBeat.i(243335);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            com.tencent.mm.storage.ao azQ = aAh.azQ();
            y yVar = y.vXH;
            ar.a LK = y.LK(4);
            if (this.tGV == null) {
                encodeHexString = "";
            } else {
                encodeHexString = Util.encodeHexString(this.tGV.toByteArray());
            }
            azQ.set(LK, encodeHexString);
            x xVar = x.SXb;
            AppMethodBeat.o(243335);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(ci ciVar, MMActivity mMActivity, h hVar) {
        bcz bcz;
        AppMethodBeat.i(243349);
        ah ahVar = (ah) hVar.hgv();
        BaseFinderFeedLoader baseFinderFeedLoader = ciVar.tFM;
        if (baseFinderFeedLoader == null) {
            AppMethodBeat.o(243349);
            return;
        }
        com.tencent.mm.plugin.finder.report.t tVar = com.tencent.mm.plugin.finder.report.t.vhJ;
        String str = ahVar.tQV;
        long j2 = ahVar.tQW;
        int lR = hVar.lR();
        bbn bbn = ciVar.ttO;
        if (bbn == null) {
            p.btv("contextObj");
        }
        com.tencent.mm.plugin.finder.report.t.a(str, j2, lR, 2, bbn);
        DataBuffer dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter();
        p.h(dataListJustForAdapter, "$this$filterIsInstance");
        p.h(BaseFinderFeed.class, "klass");
        List<BaseFinderFeed> list = (List) kotlin.a.j.a(dataListJustForAdapter, new ArrayList(), BaseFinderFeed.class);
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
        for (BaseFinderFeed baseFinderFeed : list) {
            arrayList.add(baseFinderFeed.feedObject.getFeedObject());
        }
        ArrayList arrayList2 = arrayList;
        bcv bcv = ahVar.tQS;
        com.tencent.mm.bw.b bVar = (bcv == null || (bcz = bcv.LMb) == null) ? null : bcz.lastBuffer;
        Log.i("Finder.StreamCardTxtConvert", "[jumpToHotTab] " + ahVar.tQV + " readStats=" + arrayList2.size() + " lastBuffer=" + bVar);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderStreamTabPreloadCore) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).aM(com.tencent.mm.plugin.finder.preload.tabPreload.d.class);
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mq(4).a(FinderHomeTabStateVM.d.HardRefresh);
        ((FinderStreamCardVM) ciVar.tGQ.getValue()).a(arrayList2, "Finder.StreamCardTxtConvert", new b(bVar));
        Intent intent = new Intent();
        intent.putExtra("KEY_FINDER_JUMP_HOT_TAB_WITH_ANIM", false);
        intent.putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", true);
        intent.putExtra("Source", 5);
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderTimelineUI(mMActivity, intent);
        mMActivity.finish();
        AppMethodBeat.o(243349);
    }

    public static final /* synthetic */ void a(ci ciVar, Context context, ah ahVar, String str, int i2) {
        blo blo;
        AppMethodBeat.i(243350);
        String j2 = n.j(str, "#", "", false);
        bdb bdb = ahVar.tQX;
        StringBuilder append = new StringBuilder("[onClickTopic] topic=").append(j2).append(" index=").append(i2).append(' ');
        LinkedList<bcv> linkedList = bdb.LMS;
        p.g(linkedList, "card.link_action_info");
        LinkedList<bcv> linkedList2 = linkedList;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
        Iterator<T> it = linkedList2.iterator();
        while (it.hasNext()) {
            ato ato = it.next().LMc;
            arrayList.add((ato == null || (blo = ato.tVd) == null) ? null : Long.valueOf(blo.id));
        }
        Log.i("Finder.StreamCardTxtConvert", append.append(arrayList).toString());
        bcv bcv = bdb.LMS.get(i2);
        if (bcv != null) {
            if (bcv.type == 1) {
                com.tencent.mm.plugin.finder.report.t tVar = com.tencent.mm.plugin.finder.report.t.vhJ;
                String str2 = ahVar.tQV;
                long j3 = ahVar.tQW;
                int i3 = ahVar.position;
                bdb bdb2 = ahVar.tQX;
                bbn bbn = ciVar.ttO;
                if (bbn == null) {
                    p.btv("contextObj");
                }
                com.tencent.mm.plugin.finder.report.t.a(str2, j3, i3, bdb2, str, bbn);
                Intent intent = new Intent();
                intent.putExtra("STREAM_TXT_CARD", ahVar.tQX.toByteArray());
                intent.putExtra("STREAM_TXT_CARD_INDEX", i2);
                intent.putExtra("TITLE_WORDING", j2);
                intent.putExtra("AUTO_REFRESH", true);
                ato ato2 = bcv.LMc;
                intent.putExtra("GET_REL_SCENE", ato2 != null ? ato2.scene : 0);
                FinderFoldedScrollLayout.a aVar = FinderFoldedScrollLayout.wmQ;
                FinderFoldedScrollLayout.Gu(cl.aWA());
                ciVar.tGS = false;
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.enterAlbumRelatedTimelineUI(context, intent);
            }
            AppMethodBeat.o(243350);
            return;
        }
        AppMethodBeat.o(243350);
    }

    public static final /* synthetic */ boolean a(ci ciVar, View view) {
        AppMethodBeat.i(243351);
        view.getHitRect(ciVar.viewRect);
        RecyclerView recyclerView = ciVar.hak;
        if (recyclerView != null) {
            recyclerView.getLocalVisibleRect(ciVar.tGl);
        }
        if (ciVar.viewRect.top < 0) {
            ciVar.viewRect.top = 0;
        } else if (ciVar.viewRect.top > ciVar.tGl.bottom) {
            ciVar.viewRect.top = ciVar.tGl.bottom;
        }
        if (ciVar.viewRect.bottom < 0) {
            ciVar.viewRect.bottom = 0;
        } else if (ciVar.viewRect.bottom > ciVar.tGl.bottom) {
            ciVar.viewRect.bottom = ciVar.tGl.bottom;
        }
        if (view.getHeight() <= 0 || ciVar.viewRect.height() <= 0 || ciVar.viewRect.height() < view.getHeight() / 6) {
            AppMethodBeat.o(243351);
            return false;
        }
        AppMethodBeat.o(243351);
        return true;
    }
}
