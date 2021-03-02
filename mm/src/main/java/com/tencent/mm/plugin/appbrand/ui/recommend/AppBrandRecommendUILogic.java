package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.ui.recommend.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004*\u0002HK\b&\u0018\u0000 t2\u00020\u0001:\u0002tuB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010N\u001a\u00020O2\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\u0006\u0010Q\u001a\u000209H\u0002J\u0010\u0010R\u001a\u00020O2\u0006\u0010S\u001a\u000209H\u0002J\b\u0010T\u001a\u00020OH\u0002J\b\u0010U\u001a\u00020OH\u0002J\b\u0010V\u001a\u00020OH\u0002J\b\u0010W\u001a\u00020OH\u0002J\b\u0010X\u001a\u00020OH\u0002J\b\u0010Y\u001a\u00020OH\u0002J\u0006\u0010Z\u001a\u00020OJ\b\u0010[\u001a\u00020OH\u0007J\b\u0010\\\u001a\u00020OH\u0007J\b\u0010]\u001a\u00020OH\u0007J\b\u0010^\u001a\u00020OH\u0002J\u0018\u0010_\u001a\u00020O2\u0006\u0010`\u001a\u00020)2\u0006\u0010a\u001a\u00020)H\u0002J\b\u0010b\u001a\u00020OH\u0007J\b\u0010c\u001a\u00020OH\u0007J\u0010\u0010d\u001a\u00020O2\u0006\u0010e\u001a\u00020fH&J\u0010\u0010g\u001a\u00020O2\u0006\u0010h\u001a\u00020)H\u0002J\b\u0010i\u001a\u00020OH\u0002J \u0010j\u001a\u00020O2\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*H\u0002J\u0016\u0010k\u001a\u00020O2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020O0mH\u0002J\b\u0010n\u001a\u00020OH\u0002J\b\u0010o\u001a\u00020OH\u0002J\u0016\u0010p\u001a\u00020O2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u001f0rH\u0002J\b\u0010s\u001a\u00020OH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R-\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001ej\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 `!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0012\u0010$\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R!\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008FX\u0002¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b1\u00102R\u0012\u00104\u001a\u000605R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u000209X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R-\u0010<\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001f`!¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u001b\u0010>\u001a\u00020?8FX\u0002¢\u0006\f\n\u0004\bB\u0010\u0010\u001a\u0004\b@\u0010AR\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R!\u0010E\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R\u0010\u0010G\u001a\u00020HX\u0004¢\u0006\u0004\n\u0002\u0010IR\u0010\u0010J\u001a\u00020KX\u0004¢\u0006\u0004\n\u0002\u0010LR\u000e\u0010M\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006v"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroid/arch/lifecycle/LifecycleObserver;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v4/app/FragmentActivity;", "(Landroid/support/v4/app/FragmentActivity;)V", "getActivity", "()Landroid/support/v4/app/FragmentActivity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroid/support/v7/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"})
public abstract class AppBrandRecommendUILogic implements LifecycleObserver {
    private static final String TAG = TAG;
    public static final a ofJ = new a((byte) 0);
    final Context context;
    private final MStorage.IOnStorageChange ofA;
    private final MStorage.IOnStorageChange ofB;
    final ArrayList<Integer> ofC;
    final ArrayList<Integer> ofD;
    final HashMap<String, Long> ofE;
    final HashMap<Integer, String> ofF;
    final l ofG;
    private final p ofH;
    final FragmentActivity ofI;
    private final kotlin.f ofr;
    private final kotlin.f ofs;
    private final MMHandler oft;
    final a ofu;
    final b ofv;
    final LinearLayoutManager ofw;
    final com.tencent.mm.plugin.appbrand.ui.recents.i ofx;
    final h ofy;
    private final kotlin.f ofz;

    public abstract String bYN();

    public abstract boolean bYO();

    public final LoadMoreRecyclerView bZc() {
        return (LoadMoreRecyclerView) this.ofr.getValue();
    }

    /* access modifiers changed from: package-private */
    public final com.tencent.mm.plugin.appbrand.appusage.a.d bZd() {
        return (com.tencent.mm.plugin.appbrand.appusage.a.d) this.ofs.getValue();
    }

    public final com.tencent.mm.plugin.appbrand.ui.recents.g bZe() {
        return (com.tencent.mm.plugin.appbrand.ui.recents.g) this.ofz.getValue();
    }

    public abstract View getContentView();

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.q<Integer, LinkedList<dko>, Integer, x> {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            super(3);
            this.ofL = appBrandRecommendUILogic;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(Integer num, LinkedList<dko> linkedList, Integer num2) {
            AppMethodBeat.i(51364);
            final int intValue = num.intValue();
            final LinkedList<dko> linkedList2 = linkedList;
            final int intValue2 = num2.intValue();
            kotlin.g.b.p.h(linkedList2, "fetchedDataList");
            Log.i(AppBrandRecommendUILogic.TAG, "onFetchFinish, remainCount:%d, size:%d, result code:%d", Integer.valueOf(intValue2), Integer.valueOf(linkedList2.size()), Integer.valueOf(intValue));
            if (intValue == 0 || intValue == 3) {
                ArrayList arrayList = new ArrayList();
                Iterator<dko> it = linkedList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().gTT);
                }
                AppBrandRecommendUILogic.a(this.ofL, (List) arrayList);
            }
            final z.d dVar = new z.d();
            dVar.SYE = this.ofL.ofv.jlo;
            synchronized (this.ofL.ofv) {
                try {
                    this.ofL.ofv.jlo = this.ofL.bZd().kWZ;
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(51364);
                    throw th;
                }
            }
            i.a(this.ofL, new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic.f.AnonymousClass1 */
                final /* synthetic */ f ofO;

                {
                    this.ofO = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(51363);
                    j.b(this.ofO.ofL.context, this.ofO.ofL.ofx.bYp());
                    if (linkedList2 == null || !(intValue == 0 || intValue == 2 || intValue == 3)) {
                        Log.i(AppBrandRecommendUILogic.TAG, "onFetchFinish fail");
                        AppBrandRecommendUILogic.e(this.ofO.ofL);
                    } else {
                        Log.i(AppBrandRecommendUILogic.TAG, "onFetchFinish success and data size = %d, page num:%d", Integer.valueOf(linkedList2.size()), Integer.valueOf(this.ofO.ofL.ofv.jlo));
                        if ((intValue == 0 && (this.ofO.ofL.ofv.jlo == 0 || (dVar.SYE == 0 && this.ofO.ofL.ofv.jlo == 1))) || intValue == 2 || intValue == 3) {
                            a aVar = this.ofO.ofL.ofu;
                            LinkedList linkedList = linkedList2;
                            kotlin.g.b.p.h(linkedList, "data");
                            aVar.bYP().clear();
                            aVar.bYP().addAll(linkedList);
                        } else {
                            a aVar2 = this.ofO.ofL.ofu;
                            LinkedList linkedList2 = linkedList2;
                            kotlin.g.b.p.h(linkedList2, "data");
                            aVar2.bYP().addAll(linkedList2);
                        }
                        if (intValue == 3) {
                            Log.i(AppBrandRecommendUILogic.TAG, "scrollToPosition %d", Integer.valueOf(this.ofO.ofL.bZd().eeE));
                            LoadMoreRecyclerView bZc = this.ofO.ofL.bZc();
                            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.ofO.ofL.bZd().eeE, new com.tencent.mm.hellhoundlib.b.a());
                            com.tencent.mm.hellhoundlib.a.a.a(bZc, a2.axQ(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$initData$1$2", "invoke", "()V", "Undefined", "scrollToPosition", "(I)V");
                            bZc.scrollToPosition(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(bZc, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$initData$1$2", "invoke", "()V", "Undefined", "scrollToPosition", "(I)V");
                        }
                        this.ofO.ofL.ofu.notifyDataSetChanged();
                        AppBrandRecommendUILogic.a(this.ofO.ofL, intValue2);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(51363);
                    return xVar;
                }
            });
            x xVar2 = x.SXb;
            AppMethodBeat.o(51364);
            return xVar2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.m<dko, Integer, x> {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            super(2);
            this.ofL = appBrandRecommendUILogic;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(dko dko, Integer num) {
            AppMethodBeat.i(51373);
            int intValue = num.intValue();
            kotlin.g.b.p.h(dko, "recommendCard");
            if (intValue == 0) {
                j.b(this.ofL.context, this.ofL.ofx.bYp());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(51373);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.m<dko, Integer, x> {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            super(2);
            this.ofL = appBrandRecommendUILogic;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(dko dko, Integer num) {
            AppMethodBeat.i(51374);
            dko dko2 = dko;
            int intValue = num.intValue();
            kotlin.g.b.p.h(dko2, "recommendCard");
            this.ofL.ofy.a(intValue, dko2);
            x xVar = x.SXb;
            AppMethodBeat.o(51374);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.m<dko, Integer, x> {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            super(2);
            this.ofL = appBrandRecommendUILogic;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(dko dko, Integer num) {
            AppMethodBeat.i(51375);
            dko dko2 = dko;
            int intValue = num.intValue();
            kotlin.g.b.p.h(dko2, "recommendCard");
            this.ofL.ofy.b(intValue, dko2);
            x xVar = x.SXb;
            AppMethodBeat.o(51375);
            return xVar;
        }
    }

    public AppBrandRecommendUILogic(FragmentActivity fragmentActivity) {
        kotlin.g.b.p.h(fragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        this.ofI = fragmentActivity;
        FragmentActivity fragmentActivity2 = this.ofI;
        if (fragmentActivity2 == null) {
            throw new t("null cannot be cast to non-null type android.content.Context");
        }
        this.context = fragmentActivity2;
        this.ofr = kotlin.g.ah(new j(this));
        this.ofs = kotlin.g.ah(c.ofM);
        this.oft = new MMHandler("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
        this.ofu = new a(this.ofI);
        this.ofv = new b();
        this.ofw = new SmoothScrollLinerLayoutManager(this.context);
        this.ofx = new com.tencent.mm.plugin.appbrand.ui.recents.i(this.ofI, bZc());
        this.ofy = new h();
        this.ofz = kotlin.g.ah(new i(this));
        this.ofA = new d(this);
        this.ofB = new r(this);
        this.ofC = new ArrayList<>();
        this.ofD = new ArrayList<>();
        this.ofE = new HashMap<>();
        this.ofF = new HashMap<>();
        this.ofG = new l(this);
        this.ofH = new p(this);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class d implements MStorage.IOnStorageChange {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        d(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            this.ofL = appBrandRecommendUILogic;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(51361);
            AppBrandRecommendUILogic.g(this.ofL);
            AppMethodBeat.o(51361);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class r implements MStorage.IOnStorageChange {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        r(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            this.ofL = appBrandRecommendUILogic;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(51377);
            AppBrandRecommendUILogic.g(this.ofL);
            AppMethodBeat.o(51377);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"})
    public static final class l extends RecyclerView.l {
        private boolean ocr;
        final /* synthetic */ AppBrandRecommendUILogic ofL;
        private final ArrayList<Integer> ofU = new ArrayList<>();
        private final ArrayList<Integer> ofV = new ArrayList<>();

        /* JADX WARN: Incorrect args count in method signature: ()V */
        l(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            this.ofL = appBrandRecommendUILogic;
            AppMethodBeat.i(51372);
            AppMethodBeat.o(51372);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(51370);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            if (layoutManager instanceof LinearLayoutManager) {
                int ks = ((LinearLayoutManager) layoutManager).ks();
                int ku = ((LinearLayoutManager) layoutManager).ku();
                if (ks == 0 && ku == 1) {
                    j.b(this.ofL.context, this.ofL.ofx.bYp());
                } else {
                    this.ofV.clear();
                    if (ks <= ku) {
                        int i4 = ks;
                        while (true) {
                            if (i4 != 0) {
                                RecyclerView.v ch = this.ofL.bZc().ch(i4);
                                if (ch != null && (ch instanceof a.c)) {
                                    this.ofV.add(Integer.valueOf(i4));
                                    if (!this.ofU.contains(Integer.valueOf(i4))) {
                                        int U = this.ofL.bZc().U(ch);
                                        Log.d(AppBrandRecommendUILogic.TAG, "reportExposeData index:%d, holderPosition:%d", Integer.valueOf(i4), Integer.valueOf(U));
                                        if (U < this.ofL.ofu.getItemCount()) {
                                            dko dko = this.ofL.ofu.bYP().get(U);
                                            kotlin.g.b.p.g(dko, "wxaList[position]");
                                            dko dko2 = dko;
                                            this.ofL.ofy.d(U, dko2);
                                            this.ofL.ofE.put(dko2.nHd, Long.valueOf(System.currentTimeMillis()));
                                            this.ofL.ofF.put(Integer.valueOf(i4), dko2.nHd);
                                            this.ofL.ofC.add(Integer.valueOf(i4));
                                        }
                                    }
                                }
                            } else {
                                j.b(this.ofL.context, this.ofL.ofx.bYp());
                            }
                            if (i4 == ku) {
                                break;
                            }
                            i4++;
                        }
                    }
                    this.ofL.ofD.clear();
                    this.ofU.removeAll(this.ofV);
                    this.ofL.ofD.addAll(this.ofU);
                    this.ofU.clear();
                    this.ofU.addAll(this.ofV);
                    this.ofL.ofC.removeAll(this.ofL.ofD);
                    this.ofL.c(this.ofL.ofD, true);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(51370);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(51371);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            this.ocr = i2 == 2;
            if (this.ocr) {
                this.ofL.ofy.iU(this.ocr);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).ks();
                int ku = ((LinearLayoutManager) layoutManager).ku();
                if (ku >= 3) {
                    ku--;
                }
                this.ofL.bZd().eeE = ku;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(51371);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void c(ArrayList<Integer> arrayList, boolean z) {
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if ((next == null || next.intValue() != 0) && this.ofF.containsKey(next)) {
                String str = this.ofF.get(next);
                Long l2 = this.ofE.get(str);
                if (!(str == null || l2 == null)) {
                    long currentTimeMillis = System.currentTimeMillis() - l2.longValue();
                    Log.d(TAG, "exposure index: %d, exposureTime:%d", next, Long.valueOf(currentTimeMillis));
                    this.ofy.W(str, currentTimeMillis);
                }
            }
        }
        if (z) {
            arrayList.clear();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        Log.i(TAG, "onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Log.i(TAG, "onResume");
        this.ofy.bYZ();
        Iterator<Integer> it = this.ofC.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if ((next == null || next.intValue() != 0) && this.ofF.containsKey(next)) {
                String str = this.ofF.get(next);
                Long l2 = this.ofE.get(str);
                if (!(str == null || l2 == null)) {
                    this.ofE.put(str, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        Log.i(TAG, "onPause");
        c(this.ofC, false);
        this.ofy.bZa();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        boolean z;
        Log.i(TAG, "onDestroy");
        ((u) com.tencent.mm.plugin.appbrand.app.n.W(u.class)).remove(this.ofA);
        com.tencent.mm.plugin.appbrand.app.n.buC().remove(this.ofB);
        this.ofC.clear();
        this.ofD.clear();
        this.ofE.clear();
        this.ofF.clear();
        this.ofy.Br(bZd().sessionId);
        com.tencent.mm.plugin.appbrand.appusage.a.d bZd = bZd();
        if (!bZd().byK().isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        bZd.kXa = z;
        bZd().kXb = 0;
        com.tencent.mm.plugin.appbrand.appusage.a.d bZd2 = bZd();
        bZd2.kWV.a((c.a) null);
        bZd2.kXf = null;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    static final class h implements LoadMoreRecyclerView.a {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        h(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            this.ofL = appBrandRecommendUILogic;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a
        public final void bYy() {
            AppMethodBeat.i(51366);
            if (this.ofL.ofv.bZf()) {
                Log.d(AppBrandRecommendUILogic.TAG, "can load more: let's do fetch");
                this.ofL.iV(false);
            }
            AppMethodBeat.o(51366);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class g implements View.OnLongClickListener {
        public static final g ofT = new g();

        static {
            AppMethodBeat.i(51365);
            AppMethodBeat.o(51365);
        }

        g() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(229570);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$initHeaderTagView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$initHeaderTagView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(229570);
            return true;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroyView() {
        this.oft.quit();
        this.ofx.onDetached();
        bZe().onDetached();
        bZc().b(this.ofG);
    }

    /* access modifiers changed from: package-private */
    public final void iV(boolean z) {
        i.a(this, true);
        i.b(this, true);
        v(new e(this, z));
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class k implements Runnable {
        final /* synthetic */ kotlin.g.a.a kXn;

        k(kotlin.g.a.a aVar) {
            this.kXn = aVar;
        }

        public final void run() {
            AppMethodBeat.i(51369);
            this.kXn.invoke();
            AppMethodBeat.o(51369);
        }
    }

    private final void v(kotlin.g.a.a<x> aVar) {
        this.oft.post(new k(aVar));
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)V", "canLoadMore", "", "getCanLoadMore", "()Z", "setCanLoadMore", "(Z)V", "isLoading", "setLoading", "page", "", "getPage", "()I", "setPage", "(I)V", "plugin-appbrand-integration_release"})
    public final class b {
        volatile boolean isLoading;
        volatile int jlo;
        volatile boolean ofK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        public final boolean bZf() {
            return this.ofK && !this.isLoading;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendShowMenu$IShowMenuCallback;", "onMenuCallback", "", "strategy", "", "plugin-appbrand-integration_release"})
    public static final class p {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            this.ofL = appBrandRecommendUILogic;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/RecommendRecycleView;", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<RecommendRecycleView> {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            super(0);
            this.ofL = appBrandRecommendUILogic;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecommendRecycleView invoke() {
            AppMethodBeat.i(51368);
            RecommendRecycleView recommendRecycleView = new RecommendRecycleView(this.ofL.ofI);
            AppMethodBeat.o(51368);
            return recommendRecycleView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appusage.a.d> {
        public static final c ofM = new c();

        static {
            AppMethodBeat.i(51360);
            AppMethodBeat.o(51360);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.appbrand.appusage.a.d invoke() {
            AppMethodBeat.i(51359);
            com.tencent.mm.plugin.appbrand.appusage.a.d byM = com.tencent.mm.plugin.appbrand.appusage.a.d.kXh.byM();
            AppMethodBeat.o(51359);
            return byM;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.ui.recents.g> {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            super(0);
            this.ofL = appBrandRecommendUILogic;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.appbrand.ui.recents.g invoke() {
            AppMethodBeat.i(51367);
            com.tencent.mm.plugin.appbrand.ui.recents.g gVar = new com.tencent.mm.plugin.appbrand.ui.recents.g(this.ofL.context, this.ofL.bZc());
            AppMethodBeat.o(51367);
            return gVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class q extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ AppBrandRecommendUILogic ofL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(AppBrandRecommendUILogic appBrandRecommendUILogic) {
            super(0);
            this.ofL = appBrandRecommendUILogic;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(51376);
            this.ofL.ofu.notifyDataSetChanged();
            x xVar = x.SXb;
            AppMethodBeat.o(51376);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ AppBrandRecommendUILogic ofL;
        final /* synthetic */ boolean ofN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppBrandRecommendUILogic appBrandRecommendUILogic, boolean z) {
            super(0);
            this.ofL = appBrandRecommendUILogic;
            this.ofN = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(51362);
            synchronized (this.ofL.ofv) {
                try {
                    this.ofL.ofv.isLoading = true;
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(51362);
                    throw th;
                }
            }
            if (this.ofN) {
                Log.i(AppBrandRecommendUILogic.TAG, "fetching page from memory, pageNum:%d, ", Integer.valueOf(this.ofL.ofv.jlo));
                com.tencent.mm.plugin.appbrand.appusage.a.e.v(new d.f(this.ofL.bZd()));
            } else {
                Log.i(AppBrandRecommendUILogic.TAG, "fetching page, pageNum:%d, ", Integer.valueOf(this.ofL.ofv.jlo));
                com.tencent.mm.plugin.appbrand.appusage.a.e.v(new d.e(this.ofL.bZd(), this.ofL.ofv.jlo));
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(51362);
            return xVar2;
        }
    }

    public static final /* synthetic */ void a(AppBrandRecommendUILogic appBrandRecommendUILogic, List list) {
        aa.b(list, o.a.WXA_RECOMMEND_CARD_LIST);
        ((u) com.tencent.mm.plugin.appbrand.app.n.W(u.class)).add(appBrandRecommendUILogic.oft.getSerial(), appBrandRecommendUILogic.ofA);
        com.tencent.mm.plugin.appbrand.app.n.buC().add(appBrandRecommendUILogic.oft.getSerial(), appBrandRecommendUILogic.ofB);
    }

    public static final /* synthetic */ void a(AppBrandRecommendUILogic appBrandRecommendUILogic, int i2) {
        boolean z;
        Log.i(TAG, "onFetchPageSuccess");
        synchronized (appBrandRecommendUILogic.ofv) {
            b bVar = appBrandRecommendUILogic.ofv;
            if (i2 > 0) {
                z = true;
            } else {
                z = false;
            }
            bVar.ofK = z;
            appBrandRecommendUILogic.ofv.isLoading = false;
            x xVar = x.SXb;
        }
        i.a(appBrandRecommendUILogic, true);
        if (appBrandRecommendUILogic.ofv.bZf()) {
            i.b(appBrandRecommendUILogic, true);
            return;
        }
        i.b(appBrandRecommendUILogic, false);
        i.h(appBrandRecommendUILogic);
    }

    public static final /* synthetic */ void e(AppBrandRecommendUILogic appBrandRecommendUILogic) {
        Log.i(TAG, "onFetchPageFail");
        i.b(appBrandRecommendUILogic, false);
        i.a(appBrandRecommendUILogic, true);
        i.h(appBrandRecommendUILogic);
        synchronized (appBrandRecommendUILogic.ofv) {
            appBrandRecommendUILogic.ofv.isLoading = false;
            x xVar = x.SXb;
        }
    }

    public static final /* synthetic */ void g(AppBrandRecommendUILogic appBrandRecommendUILogic) {
        i.a(appBrandRecommendUILogic, new q(appBrandRecommendUILogic));
    }
}
