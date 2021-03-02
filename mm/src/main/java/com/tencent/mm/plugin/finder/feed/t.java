package com.tencent.mm.plugin.finder.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000É\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001.\b\u0016\u0018\u0000 q2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0002qrB\u0005¢\u0006\u0002\u0010\u0007J\b\u0010H\u001a\u00020\u0011H\u0002J\b\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u00020JH\u0002J\u0010\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020NH\u0016J\u0018\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0016J\u0014\u0010T\u001a\u0006\u0012\u0002\b\u00030U2\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020Y2\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010Z\u001a\u00020[2\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010\\\u001a\u00020\tH\u0016J\b\u0010]\u001a\u00020\tH\u0016J\u0012\u0010^\u001a\u00020J2\b\u0010_\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010`\u001a\u00020JH\u0002J\"\u0010a\u001a\u00020J2\u0006\u0010b\u001a\u00020C2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010%H\u0016J\b\u0010c\u001a\u00020JH\u0016J.\u0010d\u001a\u00020J2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00030f2\u0006\u0010M\u001a\u00020N2\u0006\u0010g\u001a\u00020\t2\u0006\u0010h\u001a\u00020\u0003H\u0016J.\u0010i\u001a\u00020\u00112\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00030f2\u0006\u0010M\u001a\u00020N2\u0006\u0010g\u001a\u00020\t2\u0006\u0010h\u001a\u00020\u0003H\u0016J:\u0010j\u001a\u00020J2\b\b\u0002\u0010k\u001a\u00020\u00112&\b\u0002\u0010l\u001a \u0012\f\u0012\n\u0012\u0004\u0012\u00020o\u0018\u00010n\u0012\f\u0012\n\u0012\u0004\u0012\u00020o\u0018\u00010n\u0018\u00010mH\u0016J\u0006\u0010p\u001a\u00020JR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u001f\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u0014R\u001a\u0010\"\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u0014R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060'X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u00020.X\u0004¢\u0006\u0004\n\u0002\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018BX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0019\u00104\u001a\n 6*\u0004\u0018\u00010505¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\"\u0004\bA\u0010\u0014R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006s"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "commentCount", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "value", "", "downContinue", "setDownContinue", "(Z)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "forceShowLikeEdu", "getForceShowLikeEdu", "()Z", "setForceShowLikeEdu", "inMsgUI", "getInMsgUI", "setInMsgUI", "isAttached", "setAttached", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "likeBuffer", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "likeDataObserver", "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "selfUsername", "", "kotlin.jvm.PlatformType", "getSelfUsername", "()Ljava/lang/String;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "totalCount", "upContinue", "setUpContinue", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;)V", "canShowLikeEdu", "checkDownContinue", "", "checkUpContinue", "doExtraOnBuildDrawerBody", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "getTotalItemCount", "keep", "p0", "loadMoreData", "onAttach", "builder", "onDetach", "onItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "position", "holder", "onItemLongClick", "refreshData", "down", "extra", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeCountView", "Companion", "SpaceItemDecoration", "plugin-finder_release"})
public class t implements aw, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, g.c<h>, g.d<h> {
    public static final a tOB = new a((byte) 0);
    final ArrayList<v> data = new ArrayList<>();
    private int gAZ;
    boolean iuM;
    private volatile com.tencent.mm.bw.b lastBuffer;
    com.tencent.mm.bw.b likeBuffer;
    private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP = new CopyOnWriteArraySet<>();
    public FinderItem tMO;
    private boolean tMT;
    private boolean tMU = true;
    private i tMX;
    private final d tOA = new d(this);
    final String tOw = z.aTY();
    com.tencent.mm.plugin.finder.view.builder.a tOx;
    public boolean tOy;
    public boolean tOz;

    static {
        AppMethodBeat.i(243964);
        AppMethodBeat.o(243964);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x> {
        final /* synthetic */ t tOC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(t tVar) {
            super(1);
            this.tOC = tVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.loader.g.h hVar) {
            String mD5String;
            AppMethodBeat.i(243935);
            final com.tencent.mm.loader.g.h hVar2 = hVar;
            p.h(hVar2, "task");
            StringBuilder sb = new StringBuilder("loadMoreData before lastBuffer ");
            if (this.tOC.lastBuffer == null) {
                mD5String = BuildConfig.COMMAND;
            } else {
                com.tencent.mm.bw.b bVar = this.tOC.lastBuffer;
                mD5String = MD5Util.getMD5String(bVar != null ? bVar.toByteArray() : null);
            }
            Log.i("Finder.DrawerPresenter", sb.append(mD5String).toString());
            new ag(this.tOC.getFeedObj(), this.tOC.getScene(), this.tOC.lastBuffer, this.tOC.likeBuffer).aYI().h(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.t.e.AnonymousClass1 */
                final /* synthetic */ e tOE;

                {
                    this.tOE = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    String mD5String;
                    AppMethodBeat.i(243933);
                    c.a aVar = (c.a) obj;
                    if (aVar == null) {
                        Log.e("Finder.DrawerPresenter", "loadMoreData resp null");
                        LinkedList linkedList = new LinkedList();
                        AppMethodBeat.o(243933);
                        return linkedList;
                    } else if (aVar.errType == 0 && aVar.errCode == 0 && aVar.iLC != null) {
                        t.a(this.tOE.tOC, ((asc) aVar.iLC).continueFlag == 1);
                        this.tOE.tOC.lastBuffer = ((asc) aVar.iLC).lastBuffer;
                        StringBuilder sb = new StringBuilder("loadMoreData after lastBuffer ");
                        if (this.tOE.tOC.lastBuffer == null) {
                            mD5String = BuildConfig.COMMAND;
                        } else {
                            com.tencent.mm.bw.b bVar = this.tOE.tOC.lastBuffer;
                            mD5String = MD5Util.getMD5String(bVar != null ? bVar.toByteArray() : null);
                        }
                        Log.i("Finder.DrawerPresenter", sb.append(mD5String).toString());
                        if (t.f(this.tOE.tOC)) {
                            int scene = this.tOE.tOC.getScene();
                            FinderLikeDrawer.a aVar2 = FinderLikeDrawer.wnm;
                            if (scene == FinderLikeDrawer.tvm) {
                                LinkedList<aul> linkedList2 = ((asc) aVar.iLC).likeList;
                                p.g(linkedList2, "it.resp.likeList");
                                ArrayList arrayList = new ArrayList();
                                for (T t : linkedList2) {
                                    if (!p.j(t.dMW, this.tOE.tOC.tOw)) {
                                        arrayList.add(t);
                                    }
                                }
                                ArrayList arrayList2 = arrayList;
                                AppMethodBeat.o(243933);
                                return arrayList2;
                            }
                        }
                        LinkedList<aul> linkedList3 = ((asc) aVar.iLC).likeList;
                        AppMethodBeat.o(243933);
                        return linkedList3;
                    } else {
                        LinkedList linkedList4 = new LinkedList();
                        AppMethodBeat.o(243933);
                        return linkedList4;
                    }
                }
            }).b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.t.e.AnonymousClass2 */
                final /* synthetic */ e tOE;

                {
                    this.tOE = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    RefreshLoadMoreLayout rlLayout;
                    RefreshLoadMoreLayout rlLayout2;
                    RecyclerView recyclerView;
                    RecyclerView.a adapter;
                    AppMethodBeat.i(243934);
                    List<aul> list = (List) obj;
                    p.g(list, LocaleUtil.ITALIAN);
                    if (!list.isEmpty()) {
                        int size = this.tOE.tOC.data.size();
                        for (aul aul : list) {
                            Iterator<v> it = this.tOE.tOC.data.iterator();
                            int i2 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i2 = -1;
                                    break;
                                } else if (p.j(it.next().uOk.dMW, aul.dMW)) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            if (!(i2 >= 0)) {
                                ArrayList<v> arrayList = this.tOE.tOC.data;
                                p.g(aul, "finderLikeInfo");
                                v vVar = new v(aul);
                                if (this.tOE.tOC.likeBuffer != null && vVar.uOk.unreadFlag == 1) {
                                    vVar.uOb = true;
                                }
                                arrayList.add(vVar);
                            }
                        }
                        com.tencent.mm.plugin.finder.view.builder.a aVar = this.tOE.tOC.tOx;
                        if (!(aVar == null || (rlLayout2 = aVar.getRlLayout()) == null || (recyclerView = rlLayout2.getRecyclerView()) == null || (adapter = recyclerView.getAdapter()) == null)) {
                            adapter.as(size, this.tOE.tOC.data.size() - size);
                        }
                    } else {
                        Log.w("Finder.DrawerPresenter", "[loadMoreData] empty!");
                    }
                    RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                    cVar.Rmj = this.tOE.tOC.tMU;
                    cVar.Rmk = list.size();
                    if (cVar.Rmk > 0) {
                        cVar.jLE = false;
                    }
                    com.tencent.mm.plugin.finder.view.builder.a aVar2 = this.tOE.tOC.tOx;
                    if (!(aVar2 == null || (rlLayout = aVar2.getRlLayout()) == null)) {
                        rlLayout.onPreFinishLoadMoreSmooth(cVar);
                    }
                    hVar2.a(j.OK);
                    x xVar = x.SXb;
                    AppMethodBeat.o(243934);
                    return xVar;
                }
            }).a(this.tOC);
            x xVar = x.SXb;
            AppMethodBeat.o(243935);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    public static final class g extends q implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x> {
        final /* synthetic */ t tOC;
        final /* synthetic */ kotlin.g.a.b tOG;
        final /* synthetic */ boolean tzV = true;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(t tVar, boolean z, kotlin.g.a.b bVar) {
            super(1);
            this.tOC = tVar;
            this.tOG = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.loader.g.h hVar) {
            AppMethodBeat.i(243944);
            final com.tencent.mm.loader.g.h hVar2 = hVar;
            p.h(hVar2, "task");
            Log.i("Finder.DrawerPresenter", "refreshData " + this.tzV);
            final long currentTimeMillis = System.currentTimeMillis();
            new ag(this.tOC.getFeedObj(), this.tOC.getScene(), this.tOC.lastBuffer, this.tOC.likeBuffer).aYI().h(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.t.g.AnonymousClass1 */
                final /* synthetic */ g tOH;

                {
                    this.tOH = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    String mD5String;
                    boolean z = true;
                    AppMethodBeat.i(243941);
                    c.a aVar = (c.a) obj;
                    if (aVar == null) {
                        Log.e("Finder.DrawerPresenter", "refreshData resp null");
                        o oVar = new o(Boolean.FALSE, null);
                        AppMethodBeat.o(243941);
                        return oVar;
                    } else if (aVar.errType == 0 && aVar.errCode == 0 && aVar.iLC != null) {
                        this.tOH.tOC.lastBuffer = ((asc) aVar.iLC).lastBuffer;
                        this.tOH.tOC.gAZ = ((asc) aVar.iLC).gAZ;
                        StringBuilder sb = new StringBuilder("refreshData lastBuffer ");
                        if (this.tOH.tOC.lastBuffer == null) {
                            mD5String = BuildConfig.COMMAND;
                        } else {
                            com.tencent.mm.bw.b bVar = this.tOH.tOC.lastBuffer;
                            mD5String = MD5Util.getMD5String(bVar != null ? bVar.toByteArray() : null);
                        }
                        Log.i("Finder.DrawerPresenter", sb.append(mD5String).append(" totalCount ").append(this.tOH.tOC.gAZ).toString());
                        t.a(this.tOH.tOC, ((asc) aVar.iLC).continueFlag == 1);
                        LinkedList linkedList = new LinkedList();
                        as aUL = z.aUL();
                        StringBuilder sb2 = new StringBuilder("contact: ");
                        if (aUL != null) {
                            z = false;
                        }
                        Log.i("Finder.DrawerPresenter", sb2.append(z).append(", canShowLikeEdu:").append(t.f(this.tOH.tOC)).toString());
                        if (t.f(this.tOH.tOC)) {
                            int scene = this.tOH.tOC.getScene();
                            FinderLikeDrawer.a aVar2 = FinderLikeDrawer.wnm;
                            if (scene == FinderLikeDrawer.tvm && aUL != null) {
                                aul aul = new aul();
                                aul.nickName = aUL.arI();
                                aul.dMW = this.tOH.tOC.tOw;
                                aul.tsR = System.currentTimeMillis();
                                linkedList.add(aul);
                                LinkedList<aul> linkedList2 = ((asc) aVar.iLC).likeList;
                                p.g(linkedList2, "it.resp.likeList");
                                ArrayList arrayList = new ArrayList();
                                for (T t : linkedList2) {
                                    if (!p.j(t.dMW, this.tOH.tOC.tOw)) {
                                        arrayList.add(t);
                                    }
                                }
                                linkedList.addAll(arrayList);
                                o oVar2 = new o(Boolean.TRUE, linkedList);
                                AppMethodBeat.o(243941);
                                return oVar2;
                            }
                        }
                        linkedList.addAll(((asc) aVar.iLC).likeList);
                        o oVar22 = new o(Boolean.TRUE, linkedList);
                        AppMethodBeat.o(243941);
                        return oVar22;
                    } else {
                        o oVar3 = new o(Boolean.FALSE, null);
                        AppMethodBeat.o(243941);
                        return oVar3;
                    }
                }
            }).b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.finder.feed.t.g.AnonymousClass2 */
                final /* synthetic */ g tOH;

                {
                    this.tOH = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    B b2;
                    com.tencent.mm.plugin.finder.view.builder.a aVar;
                    RefreshLoadMoreLayout rlLayout;
                    RefreshLoadMoreLayout rlLayout2;
                    RecyclerView recyclerView;
                    RecyclerView.a adapter;
                    RefreshLoadMoreLayout rlLayout3;
                    RecyclerView recyclerView2;
                    RecyclerView.a adapter2;
                    RefreshLoadMoreLayout rlLayout4;
                    LinkedList linkedList;
                    boolean z = false;
                    AppMethodBeat.i(243943);
                    o oVar = (o) obj;
                    kotlin.g.a.b bVar = this.tOH.tOG;
                    if (bVar == null || (linkedList = (LinkedList) bVar.invoke(oVar.second)) == null) {
                        b2 = oVar.second;
                    } else {
                        b2 = linkedList;
                    }
                    com.tencent.mm.plugin.finder.view.builder.a aVar2 = this.tOH.tOC.tOx;
                    if (aVar2 != null) {
                        aVar2.hideLoading();
                    }
                    if (!this.tOH.tzV) {
                        com.tencent.mm.plugin.finder.view.builder.a aVar3 = this.tOH.tOC.tOx;
                        if (!(aVar3 == null || (rlLayout4 = aVar3.getRlLayout()) == null)) {
                            rlLayout4.apS(b2 != null ? b2.size() : 0);
                        }
                    } else if (!(this.tOH.tOC.tMU || (aVar = this.tOH.tOC.tOx) == null || (rlLayout = aVar.getRlLayout()) == null)) {
                        RefreshLoadMoreLayout.e(rlLayout);
                    }
                    if (this.tOH.tzV) {
                        t.h(this.tOH.tOC);
                    }
                    if (b2 == null || b2.size() <= 0) {
                        Log.i("Finder.DrawerPresenter", "refresh header title...");
                        this.tOH.tOC.dcM();
                        if (this.tOH.tzV) {
                            this.tOH.tOC.data.clear();
                            com.tencent.mm.plugin.finder.view.builder.a aVar4 = this.tOH.tOC.tOx;
                            if (!(aVar4 == null || (rlLayout2 = aVar4.getRlLayout()) == null || (recyclerView = rlLayout2.getRecyclerView()) == null || (adapter = recyclerView.getAdapter()) == null)) {
                                adapter.notifyDataSetChanged();
                            }
                            if (oVar.first.booleanValue()) {
                                com.tencent.mm.plugin.finder.view.builder.a aVar5 = this.tOH.tOC.tOx;
                                if (aVar5 != null) {
                                    FrameLayout frameLayout = aVar5.wrT;
                                    if (frameLayout == null) {
                                        p.btv("loadingLayout");
                                    }
                                    frameLayout.setVisibility(0);
                                    View view = aVar5.hSw;
                                    if (view == null) {
                                        p.btv("loadingView");
                                    }
                                    view.setVisibility(8);
                                    View view2 = aVar5.wrU;
                                    if (view2 == null) {
                                        p.btv("nothingView");
                                    }
                                    view2.setVisibility(0);
                                    View view3 = aVar5.wrV;
                                    if (view3 == null) {
                                        p.btv("retryView");
                                    }
                                    view3.setVisibility(8);
                                }
                            } else {
                                com.tencent.mm.plugin.finder.view.builder.a aVar6 = this.tOH.tOC.tOx;
                                if (aVar6 != null) {
                                    AnonymousClass1 r0 = new kotlin.g.a.a<x>(this) {
                                        /* class com.tencent.mm.plugin.finder.feed.t.g.AnonymousClass2.AnonymousClass1 */
                                        final /* synthetic */ AnonymousClass2 tOI;

                                        {
                                            this.tOI = r2;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        @Override // kotlin.g.a.a
                                        public final /* synthetic */ x invoke() {
                                            AppMethodBeat.i(243942);
                                            com.tencent.mm.plugin.finder.view.builder.a aVar = this.tOI.tOH.tOC.tOx;
                                            if (aVar != null) {
                                                aVar.showLoading();
                                            }
                                            t.a(this.tOI.tOH.tOC);
                                            x xVar = x.SXb;
                                            AppMethodBeat.o(243942);
                                            return xVar;
                                        }
                                    };
                                    p.h(r0, "onClick");
                                    FrameLayout frameLayout2 = aVar6.wrT;
                                    if (frameLayout2 == null) {
                                        p.btv("loadingLayout");
                                    }
                                    frameLayout2.setVisibility(0);
                                    View view4 = aVar6.hSw;
                                    if (view4 == null) {
                                        p.btv("loadingView");
                                    }
                                    view4.setVisibility(8);
                                    View view5 = aVar6.wrU;
                                    if (view5 == null) {
                                        p.btv("nothingView");
                                    }
                                    view5.setVisibility(8);
                                    View view6 = aVar6.wrV;
                                    if (view6 == null) {
                                        p.btv("retryView");
                                    }
                                    view6.setVisibility(0);
                                    View view7 = aVar6.wrV;
                                    if (view7 == null) {
                                        p.btv("retryView");
                                    }
                                    view7.setOnClickListener(new a.c(r0));
                                }
                            }
                        }
                    } else {
                        Iterator it = b2.iterator();
                        while (it.hasNext()) {
                            aul aul = (aul) it.next();
                            ArrayList<v> arrayList = this.tOH.tOC.data;
                            p.g(aul, "finderLikeInfo");
                            v vVar = new v(aul);
                            if (this.tOH.tOC.likeBuffer != null && vVar.uOk.unreadFlag == 1) {
                                vVar.uOb = true;
                            }
                            arrayList.add(vVar);
                        }
                        com.tencent.mm.plugin.finder.view.builder.a aVar7 = this.tOH.tOC.tOx;
                        if (!(aVar7 == null || (rlLayout3 = aVar7.getRlLayout()) == null || (recyclerView2 = rlLayout3.getRecyclerView()) == null || (adapter2 = recyclerView2.getAdapter()) == null)) {
                            adapter2.notifyDataSetChanged();
                        }
                    }
                    StringBuilder append = new StringBuilder("[refreshData] Cost=").append(System.currentTimeMillis() - currentTimeMillis).append("ms, succ:");
                    if (b2 != null) {
                        z = true;
                    }
                    Log.i("Finder.DrawerPresenter", append.append(z).toString());
                    hVar2.a(j.OK);
                    x xVar = x.SXb;
                    AppMethodBeat.o(243943);
                    return xVar;
                }
            }).a(this.tOC);
            x xVar = x.SXb;
            AppMethodBeat.o(243944);
            return xVar;
        }
    }

    public t() {
        AppMethodBeat.i(243963);
        AppMethodBeat.o(243963);
    }

    public static final /* synthetic */ void a(t tVar, boolean z) {
        AppMethodBeat.i(243967);
        tVar.mX(z);
        AppMethodBeat.o(243967);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        AppMethodBeat.i(243955);
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar, "holder");
        AppMethodBeat.o(243955);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.d
    public final /* synthetic */ boolean b(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        AppMethodBeat.i(243954);
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar, "holder");
        AppMethodBeat.o(243954);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final FinderItem getFeedObj() {
        AppMethodBeat.i(243945);
        FinderItem finderItem = this.tMO;
        if (finderItem == null) {
            p.btv("feedObj");
        }
        AppMethodBeat.o(243945);
        return finderItem;
    }

    private final Resources getResources() {
        Context context;
        AppMethodBeat.i(243946);
        com.tencent.mm.plugin.finder.view.builder.a aVar = this.tOx;
        if (aVar == null || (context = aVar.getContext()) == null) {
            AppMethodBeat.o(243946);
            return null;
        }
        Resources resources = context.getResources();
        AppMethodBeat.o(243946);
        return resources;
    }

    private final void mX(boolean z) {
        AppMethodBeat.i(243947);
        this.tMU = z;
        Log.i("Finder.DrawerPresenter", "set downContinue ".concat(String.valueOf(z)));
        AppMethodBeat.o(243947);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw
    public final int dcL() {
        return this.gAZ;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw
    public void a(com.tencent.mm.plugin.finder.view.builder.a aVar, FinderItem finderItem, com.tencent.mm.bw.b bVar) {
        com.tencent.mm.plugin.finder.view.builder.a aVar2;
        RefreshLoadMoreLayout rlLayout;
        FinderLikeDrawer dcn;
        AppMethodBeat.i(243948);
        p.h(aVar, "builder");
        p.h(finderItem, "feedObj");
        this.tMO = finderItem;
        this.likeBuffer = bVar;
        this.tMX = new i("FinderLikeExecutor");
        this.tOx = aVar;
        Log.i("Finder.DrawerPresenter", "onAttach " + finderItem.getId());
        i iVar = this.tMX;
        if (iVar != null) {
            iVar.start();
        }
        dcM();
        this.data.clear();
        try {
            RecyclerView.a adapter = aVar.getRlLayout().getRecyclerView().getAdapter();
            if (adapter != null) {
                adapter.a(this.tOA);
            }
        } catch (IllegalStateException e2) {
            Log.printErrStackTrace("Finder.DrawerPresenter", e2, "", new Object[0]);
        }
        aVar.dHt();
        com.tencent.mm.plugin.finder.view.builder.a aVar3 = this.tOx;
        if (!(aVar3 == null || (dcn = aVar3.dcn()) == null)) {
            dcn.hge();
        }
        aVar.getRlLayout().getRecyclerView().setLayoutFrozen(false);
        aVar.getRlLayout().setActionCallback(new f(this));
        com.tencent.mm.plugin.finder.view.builder.a aVar4 = this.tOx;
        if (aVar4 != null) {
            aVar4.hideLoading();
        }
        com.tencent.mm.plugin.finder.view.builder.a aVar5 = this.tOx;
        if (aVar5 != null) {
            aVar5.showLoading();
        }
        A(null);
        if (!(this.tMU || (aVar2 = this.tOx) == null || (rlLayout = aVar2.getRlLayout()) == null)) {
            RefreshLoadMoreLayout.e(rlLayout);
        }
        this.iuM = true;
        AppMethodBeat.o(243948);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
    public static final class f extends RefreshLoadMoreLayout.a {
        final /* synthetic */ t tOC;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(243939);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(243939);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(243940);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(243940);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(t tVar) {
            this.tOC = tVar;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(243937);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            com.tencent.f.h.RTc.aX(new a(this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(243937);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ f tOF;

            a(f fVar) {
                this.tOF = fVar;
            }

            public final void run() {
                AppMethodBeat.i(243936);
                t.b(this.tOF.tOC);
                AppMethodBeat.o(243936);
            }
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(243938);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            super.a(cVar);
            t.c(this.tOC);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$onAttach$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(243938);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw
    public void onDetach() {
        RefreshLoadMoreLayout rlLayout;
        RefreshLoadMoreLayout rlLayout2;
        RecyclerView recyclerView;
        RefreshLoadMoreLayout rlLayout3;
        RecyclerView recyclerView2;
        RecyclerView.a adapter;
        RefreshLoadMoreLayout rlLayout4;
        AppMethodBeat.i(243949);
        if (!this.iuM) {
            Log.i("Finder.DrawerPresenter", "onDetach: cannot detach when have not attached");
            AppMethodBeat.o(243949);
            return;
        }
        this.iuM = false;
        i iVar = this.tMX;
        if (iVar != null) {
            iVar.stop();
        }
        this.tMX = null;
        Iterator<T> it = this.tLP.iterator();
        while (it.hasNext()) {
            it.next().dead();
        }
        this.tLP.clear();
        this.data.clear();
        this.lastBuffer = null;
        this.tMT = false;
        Log.i("Finder.DrawerPresenter", "set upContinue false");
        mX(true);
        com.tencent.mm.plugin.finder.view.builder.a aVar = this.tOx;
        if (!(aVar == null || (rlLayout4 = aVar.getRlLayout()) == null)) {
            rlLayout4.setHasBottomMore(true);
        }
        com.tencent.mm.plugin.finder.view.builder.a aVar2 = this.tOx;
        if (!(aVar2 == null || (rlLayout3 = aVar2.getRlLayout()) == null || (recyclerView2 = rlLayout3.getRecyclerView()) == null || (adapter = recyclerView2.getAdapter()) == null)) {
            adapter.notifyDataSetChanged();
        }
        com.tencent.mm.plugin.finder.view.builder.a aVar3 = this.tOx;
        if (!(aVar3 == null || (rlLayout2 = aVar3.getRlLayout()) == null || (recyclerView = rlLayout2.getRecyclerView()) == null)) {
            recyclerView.setLayoutFrozen(true);
        }
        com.tencent.mm.plugin.finder.view.builder.a aVar4 = this.tOx;
        if (!(aVar4 == null || (rlLayout = aVar4.getRlLayout()) == null)) {
            rlLayout.setActionCallback(null);
        }
        this.tOx = null;
        AppMethodBeat.o(243949);
    }

    public static /* synthetic */ void a(t tVar) {
        AppMethodBeat.i(243951);
        tVar.A(null);
        AppMethodBeat.o(243951);
    }

    public final void A(kotlin.g.a.b<? super LinkedList<aul>, ? extends LinkedList<aul>> bVar) {
        AppMethodBeat.i(243950);
        i iVar = this.tMX;
        if (iVar != null) {
            iVar.a(new com.tencent.mm.loader.g.h(new g(this, true, bVar)));
            AppMethodBeat.o(243950);
            return;
        }
        AppMethodBeat.o(243950);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw
    public WxRecyclerAdapter<?> fm(Context context) {
        AppMethodBeat.i(243952);
        p.h(context, "context");
        WxRecyclerAdapter<?> wxRecyclerAdapter = new WxRecyclerAdapter<>(dcK(), this.data, true);
        wxRecyclerAdapter.au(false);
        wxRecyclerAdapter.RqP = this;
        wxRecyclerAdapter.RqO = this;
        AppMethodBeat.o(243952);
        return wxRecyclerAdapter;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$likeDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
    public static final class d extends RecyclerView.c {
        final /* synthetic */ t tOC;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(t tVar) {
            this.tOC = tVar;
        }

        @Override // android.support.v7.widget.RecyclerView.c
        @SuppressLint({"StringFormatMatches"})
        public final void onChanged() {
            AppMethodBeat.i(243928);
            super.onChanged();
            this.tOC.dcM();
            AppMethodBeat.o(243928);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(243929);
            super.onItemRangeInserted(i2, i3);
            this.tOC.dcM();
            AppMethodBeat.o(243929);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3) {
            AppMethodBeat.i(243930);
            super.onItemRangeChanged(i2, i3);
            this.tOC.dcM();
            AppMethodBeat.o(243930);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(243931);
            super.onItemRangeChanged(i2, i3, obj);
            this.tOC.dcM();
            AppMethodBeat.o(243931);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(243932);
            super.onItemRangeRemoved(i2, i3);
            this.tOC.dcM();
            AppMethodBeat.o(243932);
        }
    }

    public final void dcM() {
        String str;
        com.tencent.mm.plugin.finder.view.builder.a aVar;
        TextView dHs;
        Context context;
        TextView dHs2;
        String str2;
        AppMethodBeat.i(243953);
        if (this.gAZ <= 0) {
            com.tencent.mm.plugin.finder.view.builder.a aVar2 = this.tOx;
            if (aVar2 == null || (dHs2 = aVar2.dHs()) == null) {
                AppMethodBeat.o(243953);
                return;
            }
            Resources resources = getResources();
            if (resources != null) {
                str2 = resources.getString(R.string.cq5);
            } else {
                str2 = null;
            }
            dHs2.setText(str2);
            AppMethodBeat.o(243953);
            return;
        }
        com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        FinderItem finderItem = this.tMO;
        if (finderItem == null) {
            p.btv("feedObj");
        }
        azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(finderItem.getFeedObject().objectType);
        if (Lj != null) {
            String str3 = Lj.LJA;
            if (!(str3 == null || str3.length() == 0)) {
                str = k.Lw(this.gAZ) + Lj.LJA;
                aVar = this.tOx;
                if (aVar != null || (dHs = aVar.dHs()) == null) {
                    AppMethodBeat.o(243953);
                }
                dHs.setText(str);
                AppMethodBeat.o(243953);
                return;
            }
        }
        com.tencent.mm.plugin.finder.view.builder.a aVar3 = this.tOx;
        if (aVar3 == null || (context = aVar3.getContext()) == null) {
            str = null;
        } else {
            str = context.getString(R.string.cq6, k.Lw(this.gAZ));
        }
        aVar = this.tOx;
        if (aVar != null) {
        }
        AppMethodBeat.o(243953);
    }

    @Override // com.tencent.mm.vending.e.b
    public void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(243956);
        this.tLP.add(aVar);
        AppMethodBeat.o(243956);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class b implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ t tOC;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "like", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.t$b$b  reason: collision with other inner class name */
        static final class C1166b extends q implements kotlin.g.a.b<Boolean, x> {
            final /* synthetic */ b tOD;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1166b(b bVar) {
                super(1);
                this.tOD = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                int i2 = 1;
                AppMethodBeat.i(243924);
                boolean booleanValue = bool.booleanValue();
                com.tencent.mm.plugin.finder.view.builder.a aVar = this.tOD.tOC.tOx;
                Context context = aVar != null ? aVar.getContext() : null;
                if (context instanceof MMFragmentActivity) {
                    int scene = this.tOD.tOC.getScene();
                    FinderLikeDrawer.a aVar2 = FinderLikeDrawer.wnm;
                    if (scene == FinderLikeDrawer.tvm) {
                        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderReporterUIC.class)).dIx();
                        aj ajVar = aj.uOw;
                        aj.a(dIx, this.tOD.tOC.getFeedObj(), booleanValue);
                        hn hnVar = new hn();
                        hnVar.dLW.id = this.tOD.tOC.getFeedObj().getId();
                        hnVar.dLW.type = 4;
                        hnVar.dLW.dLZ = booleanValue ? 1 : 0;
                        EventCenter.instance.publish(hnVar);
                        if (booleanValue) {
                            this.tOD.tOC.gAZ++;
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            StringBuilder append = new StringBuilder().append(com.tencent.mm.ac.d.zs(this.tOD.tOC.getFeedObj().getId())).append(",2,");
                            if (!this.tOD.tOC.tOy) {
                                i2 = this.tOD.tOC.tOz ? 3 : 2;
                            }
                            hVar.kvStat(20851, append.append(i2).toString());
                        } else {
                            t tVar = this.tOD.tOC;
                            tVar.gAZ--;
                            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            StringBuilder append2 = new StringBuilder().append(com.tencent.mm.ac.d.zs(this.tOD.tOC.getFeedObj().getId())).append(",3,");
                            if (!this.tOD.tOC.tOy) {
                                i2 = this.tOD.tOC.tOz ? 3 : 2;
                            }
                            hVar2.kvStat(20851, append2.append(i2).toString());
                        }
                        this.tOD.tOC.dcM();
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(243924);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(t tVar) {
            this.tOC = tVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(243926);
            w wVar = new w(t.f(this.tOC), new a(this), new C1166b(this), new c(this));
            AppMethodBeat.o(243926);
            return wVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<Boolean> {
            final /* synthetic */ b tOD;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(0);
                this.tOD = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Boolean invoke() {
                boolean z;
                AppMethodBeat.i(243923);
                j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
                o<Boolean, Boolean> m = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(this.tOD.tOC.getFeedObj().getFeedObject());
                boolean booleanValue = m.first.booleanValue();
                boolean booleanValue2 = m.second.booleanValue();
                if (!booleanValue || booleanValue2) {
                    z = false;
                } else {
                    z = true;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(243923);
                return valueOf;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b tOD;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar) {
                super(0);
                this.tOD = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                int i2;
                AppMethodBeat.i(243925);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                StringBuilder append = new StringBuilder().append(com.tencent.mm.ac.d.zs(this.tOD.tOC.getFeedObj().getId())).append(",1,");
                if (this.tOD.tOC.tOy) {
                    i2 = 1;
                } else {
                    i2 = this.tOD.tOC.tOz ? 3 : 2;
                }
                hVar.kvStat(20851, append.append(i2).toString());
                x xVar = x.SXb;
                AppMethodBeat.o(243925);
                return xVar;
            }
        }
    }

    public com.tencent.mm.view.recyclerview.f dcK() {
        AppMethodBeat.i(243957);
        b bVar = new b(this);
        AppMethodBeat.o(243957);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class c extends RecyclerView.h {
        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(243927);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            rect.set(0, 0, 0, 0);
            AppMethodBeat.o(243927);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw
    public RecyclerView.h fi(Context context) {
        AppMethodBeat.i(243958);
        p.h(context, "context");
        c cVar = new c();
        AppMethodBeat.o(243958);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw
    public int getScene() {
        AppMethodBeat.i(243959);
        FinderLikeDrawer.a aVar = FinderLikeDrawer.wnm;
        int i2 = FinderLikeDrawer.tvm;
        AppMethodBeat.o(243959);
        return i2;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw
    public RecyclerView.LayoutManager eS(Context context) {
        AppMethodBeat.i(243960);
        p.h(context, "context");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1, false);
        AppMethodBeat.o(243960);
        return linearLayoutManager;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw
    public void dV(View view) {
        AppMethodBeat.i(243961);
        p.h(view, "view");
        AppMethodBeat.o(243961);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aw
    public void a(Context context, FrameLayout frameLayout) {
        AppMethodBeat.i(243962);
        p.h(context, "context");
        p.h(frameLayout, "headerLayout");
        AppMethodBeat.o(243962);
    }

    public static final /* synthetic */ void b(t tVar) {
        AppMethodBeat.i(243965);
        i iVar = tVar.tMX;
        if (iVar != null) {
            iVar.a(new com.tencent.mm.loader.g.h(new e(tVar)));
            AppMethodBeat.o(243965);
            return;
        }
        AppMethodBeat.o(243965);
    }

    public static final /* synthetic */ void c(t tVar) {
        com.tencent.mm.plugin.finder.view.builder.a aVar;
        RefreshLoadMoreLayout rlLayout;
        AppMethodBeat.i(243966);
        if (tVar.tMU || (aVar = tVar.tOx) == null || (rlLayout = aVar.getRlLayout()) == null) {
            AppMethodBeat.o(243966);
            return;
        }
        RefreshLoadMoreLayout.e(rlLayout);
        AppMethodBeat.o(243966);
    }

    public static final /* synthetic */ boolean f(t tVar) {
        AppMethodBeat.i(243968);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.duw().value().intValue() == 1 || tVar.tOy) {
            y yVar = y.vXH;
            if (!y.dnv()) {
                AppMethodBeat.o(243968);
                return true;
            }
        }
        AppMethodBeat.o(243968);
        return false;
    }

    public static final /* synthetic */ void h(t tVar) {
        FinderLikeDrawer dcn;
        AppMethodBeat.i(243969);
        if (!tVar.tMT) {
            com.tencent.mm.plugin.finder.view.builder.a aVar = tVar.tOx;
            if (aVar != null) {
                aVar.dHt();
            }
            com.tencent.mm.plugin.finder.view.builder.a aVar2 = tVar.tOx;
            if (!(aVar2 == null || (dcn = aVar2.dcn()) == null)) {
                dcn.hge();
                AppMethodBeat.o(243969);
                return;
            }
        }
        AppMethodBeat.o(243969);
    }
}
