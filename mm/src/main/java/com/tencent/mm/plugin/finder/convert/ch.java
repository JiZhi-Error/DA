package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.stats.LoggingConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.at;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.t;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.finder.view.adapter.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007*\u0002\u0016)\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002KLB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J8\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/05H\u0002J\u0010\u00106\u001a\u0002032\u0006\u00101\u001a\u00020\u0002H\u0002J\b\u00107\u001a\u00020\u0006H\u0016J\u0010\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\u0014H\u0002J\"\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020?H\u0002J@\u0010@\u001a\u00020/2\u0006\u0010>\u001a\u00020?2\u0006\u00101\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\r2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010EH\u0016J \u0010G\u001a\u00020/2\u0006\u0010#\u001a\u00020$2\u0006\u0010>\u001a\u00020?2\u0006\u0010B\u001a\u00020\u0006H\u0016J\u0010\u0010H\u001a\u00020/2\u0006\u0010#\u001a\u00020$H\u0016J\u001c\u0010I\u001a\u00020/2\u0006\u00101\u001a\u00020\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0002J\u0010\u0010J\u001a\u0002032\u0006\u00101\u001a\u00020\u0002H\u0002R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;I)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "exposeItem", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$ExposeItem;", "isEnablePreloadRefreshContent", "", "()Z", "isEnablePreloadRefreshContent$delegate", "Lkotlin/Lazy;", "isPreloadContenting", "isRefreshing", "itemView", "Landroid/view/View;", "lifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1;", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Lkotlin/collections/ArrayList;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "rect2", "Landroid/graphics/Rect;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshContentPreload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Preload;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1;", "singleTaskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "viewRect", "fetchContent", "", "isRefresh", "item", LoggingConstants.LOG_FILE_PREFIX, "Lcom/tencent/mm/protocal/protobuf/Stats;", "call", "Lkotlin/Function1;", "genStat", "getLayoutId", "isViewExposed", "view", "jumpRelatedTimelineUI", "context", "Landroid/content/Context;", NativeProtocol.WEB_DIALOG_ACTION, "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "preloadContent", "reportStat", "Companion", "ExposeItem", "plugin-finder_release"})
public final class ch extends com.tencent.mm.view.recyclerview.e<ag> {
    public static final a tGr = new a((byte) 0);
    private View aus;
    private final int dLS;
    private RecyclerView hak;
    private boolean isRefreshing;
    private final kotlin.f tGg = kotlin.g.ah(q.tGK);
    private final kotlin.f tGh = kotlin.g.ah(d.tGD);
    private final com.tencent.mm.loader.g.i tGi;
    private final com.tencent.mm.plugin.finder.feed.model.internal.m<bo> tGj;
    private final ArrayList<cjl> tGk;
    private final Rect tGl;
    private final r tGm;
    private final FinderStreamCardAlbumConvert$lifecycleObserver$1 tGn;
    private b tGo;
    private boolean tGp;
    private final at tGq;
    private bbn ttO;
    private final Rect viewRect;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J=\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$ExposeItem;", "", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "feedId", "", "sumTimeMs", "startTimeMs", "position", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;JJJI)V", "getFeedId", "()J", "setFeedId", "(J)V", "getItem", "()Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "setItem", "(Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;)V", "getPosition", "()I", "setPosition", "(I)V", "getStartTimeMs", "setStartTimeMs", "getSumTimeMs", "setSumTimeMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    public static final class b {
        long feedId = 0;
        int position = -1;
        long startTimeMs = 0;
        ag tGs = null;
        private long tGt = 0;

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
            if (r5.position == r6.position) goto L_0x0036;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 243282(0x3b652, float:3.4091E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0036
                boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.convert.ch.b
                if (r0 == 0) goto L_0x003b
                com.tencent.mm.plugin.finder.convert.ch$b r6 = (com.tencent.mm.plugin.finder.convert.ch.b) r6
                com.tencent.mm.plugin.finder.feed.ag r0 = r5.tGs
                com.tencent.mm.plugin.finder.feed.ag r1 = r6.tGs
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003b
                long r0 = r5.feedId
                long r2 = r6.feedId
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x003b
                long r0 = r5.tGt
                long r2 = r6.tGt
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x003b
                long r0 = r5.startTimeMs
                long r2 = r6.startTimeMs
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x003b
                int r0 = r5.position
                int r1 = r6.position
                if (r0 != r1) goto L_0x003b
            L_0x0036:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x003a:
                return r0
            L_0x003b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x003a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.ch.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(243281);
            ag agVar = this.tGs;
            int hashCode = agVar != null ? agVar.hashCode() : 0;
            long j2 = this.feedId;
            long j3 = this.tGt;
            long j4 = this.startTimeMs;
            int i2 = (((((((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.position;
            AppMethodBeat.o(243281);
            return i2;
        }

        public final String toString() {
            AppMethodBeat.i(243280);
            String str = "ExposeItem(item=" + this.tGs + ", feedId=" + this.feedId + ", sumTimeMs=" + this.tGt + ", startTimeMs=" + this.startTimeMs + ", position=" + this.position + ")";
            AppMethodBeat.o(243280);
            return str;
        }
    }

    static {
        AppMethodBeat.i(243325);
        AppMethodBeat.o(243325);
    }

    private final boolean cZN() {
        AppMethodBeat.i(243316);
        boolean booleanValue = ((Boolean) this.tGh.getValue()).booleanValue();
        AppMethodBeat.o(243316);
        return booleanValue;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x> {
        final /* synthetic */ ch tGu;
        final /* synthetic */ boolean tGv;
        final /* synthetic */ ag tGw;
        final /* synthetic */ FinderStreamCardAlbumConvert$fetchContent$loader$1 tGx;
        final /* synthetic */ ecq tGy;
        final /* synthetic */ kotlin.g.a.b twV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ch chVar, boolean z, ag agVar, FinderStreamCardAlbumConvert$fetchContent$loader$1 finderStreamCardAlbumConvert$fetchContent$loader$1, ecq ecq, kotlin.g.a.b bVar) {
            super(1);
            this.tGu = chVar;
            this.tGv = z;
            this.tGw = agVar;
            this.tGx = finderStreamCardAlbumConvert$fetchContent$loader$1;
            this.tGy = ecq;
            this.twV = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.loader.g.h hVar) {
            ato ato;
            LinkedList<ecq> linkedList;
            ato ato2 = null;
            AppMethodBeat.i(243287);
            final com.tencent.mm.loader.g.h hVar2 = hVar;
            kotlin.g.b.p.h(hVar2, "task");
            Log.i("Finder.FinderStreamCardAlbumConvert", "[fetchContent#execute] isRefresh=" + this.tGv + ' ' + com.tencent.mm.plugin.finder.cgi.interceptor.e.a(this.tGw.tQQ));
            if (!this.tGv) {
                FinderStreamCardAlbumConvert$fetchContent$loader$1 finderStreamCardAlbumConvert$fetchContent$loader$1 = this.tGx;
                bcv bcv = this.tGw.tQQ.LLY;
                if (bcv != null) {
                    ato2 = bcv.LMc;
                }
                finderStreamCardAlbumConvert$fetchContent$loader$1.tta = ato2;
            } else {
                FinderStreamCardAlbumConvert$fetchContent$loader$1 finderStreamCardAlbumConvert$fetchContent$loader$12 = this.tGx;
                bcv bcv2 = this.tGw.tQQ.LLZ;
                if (bcv2 != null) {
                    ato2 = bcv2.LMc;
                }
                finderStreamCardAlbumConvert$fetchContent$loader$12.tta = ato2;
            }
            if (ch.i(this.tGu)) {
                this.tGx.setPreload(this.tGu.tGj);
            }
            ecq ecq = this.tGy;
            if (!(ecq == null || (ato = this.tGx.tta) == null || (linkedList = ato.LEw) == null)) {
                linkedList.add(ecq);
            }
            this.tGx.tVa = new kotlin.g.a.b<IResponse<bo>, x>(this) {
                /* class com.tencent.mm.plugin.finder.convert.ch.c.AnonymousClass1 */
                final /* synthetic */ c tGz;

                {
                    this.tGz = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
                    List<? extends FinderObject> list;
                    LinkedList linkedList;
                    AppMethodBeat.i(243286);
                    IResponse<bo> iResponse2 = iResponse;
                    kotlin.g.b.p.h(iResponse2, "resp");
                    hVar2.a(com.tencent.mm.loader.g.j.OK);
                    if (iResponse2.getErrType() == 0 && iResponse2.getErrCode() == 0) {
                        this.tGz.tGw.tQP = cl.aWA();
                        if (this.tGz.tGv) {
                            bcu bcu = (bcu) kotlin.a.j.kt(((FinderFeedRelTimelineLoader.b) iResponse2).tVi);
                            if (!(bcu == null || (list = ((FinderFeedRelTimelineLoader.b) iResponse2).tvo) == null)) {
                                if (!list.isEmpty()) {
                                    this.tGz.tGw.rvFeedList.clear();
                                    bcu.uOx = this.tGz.tGw.tQQ.uOx;
                                    LinkedList<FinderObject> linkedList2 = bcu.object;
                                    List<? extends FinderObject> list2 = ((FinderFeedRelTimelineLoader.b) iResponse2).tvo;
                                    if (list2 != null) {
                                        linkedList = list2;
                                    } else {
                                        linkedList = new LinkedList();
                                    }
                                    linkedList2.addAll(linkedList);
                                    ag agVar = this.tGz.tGw;
                                    kotlin.g.b.p.h(bcu, "<set-?>");
                                    agVar.tQQ = bcu;
                                    List<bo> incrementList = iResponse2.getIncrementList();
                                    if (incrementList != null) {
                                        ArrayList arrayList = new ArrayList();
                                        for (T t : incrementList) {
                                            if (t instanceof BaseFinderFeed) {
                                                arrayList.add(t);
                                            }
                                        }
                                        this.tGz.tGw.rvFeedList.addAll(arrayList);
                                    }
                                    com.tencent.mm.ac.d.a(0, new kotlin.g.a.a<x>(this) {
                                        /* class com.tencent.mm.plugin.finder.convert.ch.c.AnonymousClass1.AnonymousClass1 */
                                        final /* synthetic */ AnonymousClass1 tGB;

                                        {
                                            this.tGB = r2;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        @Override // kotlin.g.a.a
                                        public final /* synthetic */ x invoke() {
                                            AppMethodBeat.i(243283);
                                            ch.a(this.tGB.tGz.tGu, this.tGB.tGz.tGw, ch.b(this.tGB.tGz.tGu, this.tGB.tGz.tGw));
                                            x xVar = x.SXb;
                                            AppMethodBeat.o(243283);
                                            return xVar;
                                        }
                                    });
                                }
                            }
                            Log.e("Finder.FinderStreamCardAlbumConvert", "[fetchContent] wrong. isRefresh=true but resp.`object`.is Empty");
                        } else if (!this.tGz.tGv) {
                            this.tGz.tGw.tQQ.object.clear();
                            this.tGz.tGw.rvFeedList.clear();
                            List<? extends FinderObject> list3 = ((FinderFeedRelTimelineLoader.b) iResponse2).tvo;
                            if (list3 != null) {
                                this.tGz.tGw.tQQ.object.addAll(list3);
                            }
                            List<bo> incrementList2 = iResponse2.getIncrementList();
                            if (incrementList2 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (T t2 : incrementList2) {
                                    if (t2 instanceof BaseFinderFeed) {
                                        arrayList2.add(t2);
                                    }
                                }
                                this.tGz.tGw.rvFeedList.addAll(arrayList2);
                            }
                        }
                        Log.i("Finder.FinderStreamCardAlbumConvert", "[fetchContent] successfully! isRefresh=" + this.tGz.tGv + ' ' + com.tencent.mm.plugin.finder.cgi.interceptor.e.a(this.tGz.tGw.tQQ) + " hasMore=" + iResponse2.getHasMore() + " continueAtTheEnd=" + this.tGz.tGw.tQQ.uOm + " size=" + this.tGz.tGw.rvFeedList.size());
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.convert.ch.c.AnonymousClass1.AnonymousClass2 */
                            final /* synthetic */ AnonymousClass1 tGB;

                            {
                                this.tGB = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* bridge */ /* synthetic */ x invoke() {
                                AppMethodBeat.i(243284);
                                this.tGB.tGz.twV.invoke(this.tGB.tGz.tGw);
                                x xVar = x.SXb;
                                AppMethodBeat.o(243284);
                                return xVar;
                            }
                        });
                    } else {
                        Log.e("Finder.FinderStreamCardAlbumConvert", "[fetchContent] wrong. errType=" + iResponse2.getErrType() + " errCode=" + iResponse2.getErrCode());
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.convert.ch.c.AnonymousClass1.AnonymousClass3 */
                            final /* synthetic */ AnonymousClass1 tGB;

                            {
                                this.tGB = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* bridge */ /* synthetic */ x invoke() {
                                AppMethodBeat.i(243285);
                                this.tGB.tGz.twV.invoke(this.tGB.tGz.tGw);
                                x xVar = x.SXb;
                                AppMethodBeat.o(243285);
                                return xVar;
                            }
                        });
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(243286);
                    return xVar;
                }
            };
            this.tGx.requestRefresh();
            x xVar = x.SXb;
            AppMethodBeat.o(243287);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "invoke"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.b<ag, x> {
        final /* synthetic */ int $type;
        final /* synthetic */ int gUj;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ boolean tGE;
        final /* synthetic */ List tGF;
        final /* synthetic */ ch tGu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ch chVar, com.tencent.mm.view.recyclerview.h hVar, int i2, int i3, boolean z, List list) {
            super(1);
            this.tGu = chVar;
            this.qhp = hVar;
            this.gUj = i2;
            this.$type = i3;
            this.tGE = z;
            this.tGF = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ag agVar) {
            AppMethodBeat.i(243294);
            ag agVar2 = agVar;
            kotlin.g.b.p.h(agVar2, LocaleUtil.ITALIAN);
            if (!agVar2.rvFeedList.isEmpty()) {
                this.tGu.a(this.qhp, agVar2, this.gUj, this.$type, this.tGE, this.tGF);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(243294);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x> {
        final /* synthetic */ ch tGu;
        final /* synthetic */ ag tGw;
        final /* synthetic */ ecq tGy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(ch chVar, ecq ecq, ag agVar) {
            super(1);
            this.tGu = chVar;
            this.tGy = ecq;
            this.tGw = agVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.loader.g.h hVar) {
            ato ato;
            ato ato2;
            LinkedList<ecq> linkedList;
            AppMethodBeat.i(243310);
            final com.tencent.mm.loader.g.h hVar2 = hVar;
            kotlin.g.b.p.h(hVar2, "task");
            FinderStreamCardAlbumConvert$preloadContent$1$loader$1 finderStreamCardAlbumConvert$preloadContent$1$loader$1 = new FinderStreamCardAlbumConvert$preloadContent$1$loader$1(this, ch.d(this.tGu));
            finderStreamCardAlbumConvert$preloadContent$1$loader$1.register(new com.tencent.mm.view.c());
            finderStreamCardAlbumConvert$preloadContent$1$loader$1.setPreload(this.tGu.tGj);
            bcv bcv = this.tGw.tQQ.LLZ;
            if (bcv != null) {
                ato = bcv.LMc;
            } else {
                ato = null;
            }
            finderStreamCardAlbumConvert$preloadContent$1$loader$1.tta = ato;
            ecq ecq = this.tGy;
            if (!(ecq == null || (ato2 = finderStreamCardAlbumConvert$preloadContent$1$loader$1.tta) == null || (linkedList = ato2.LEw) == null)) {
                linkedList.add(ecq);
            }
            finderStreamCardAlbumConvert$preloadContent$1$loader$1.requestPreload(new com.tencent.mm.plugin.finder.feed.model.internal.f<bo>(this) {
                /* class com.tencent.mm.plugin.finder.convert.ch.p.AnonymousClass1 */
                final /* synthetic */ p tGI;

                {
                    this.tGI = r1;
                }

                @Override // com.tencent.mm.plugin.finder.feed.model.internal.f
                public final void onFetchDone(IResponse<bo> iResponse) {
                    List<bo> incrementList;
                    bo boVar;
                    bo boVar2;
                    long j2;
                    long j3;
                    ato ato;
                    efo efo;
                    AppMethodBeat.i(243307);
                    kotlin.g.b.p.h(iResponse, "response");
                    Log.i("Finder.FinderStreamCardAlbumConvert", "[preloadContent] errType=" + iResponse.getErrType() + " errCode=" + iResponse.getErrCode());
                    try {
                        if (iResponse.getErrType() == 0 && iResponse.getErrCode() == 0 && (incrementList = iResponse.getIncrementList()) != null && (boVar = (bo) kotlin.a.j.kt(incrementList)) != null && boVar.cxn() == 4) {
                            List<bo> incrementList2 = iResponse.getIncrementList();
                            if (incrementList2 != null) {
                                boVar2 = (bo) kotlin.a.j.kt(incrementList2);
                            } else {
                                boVar2 = null;
                            }
                            if (!(boVar2 instanceof BaseFinderFeed)) {
                                boVar2 = null;
                            }
                            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) boVar2;
                            if (baseFinderFeed != null) {
                                FinderItem.a aVar = FinderItem.Companion;
                                FinderObject feedObject = baseFinderFeed.feedObject.getFeedObject();
                                y yVar = y.vXH;
                                FinderItem a2 = FinderItem.a.a(feedObject, y.LL(this.tGI.tGu.dLS));
                                c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                                BaseFinderFeed s = c.a.s(a2);
                                LinkedList linkedList = new LinkedList();
                                linkedList.addAll(s.feedObject.getMediaList());
                                kotlin.o oVar = new kotlin.o(s, kotlin.a.j.v((Collection) linkedList));
                                LinkedList linkedList2 = new LinkedList();
                                linkedList2.add(oVar);
                                com.tencent.mm.plugin.finder.preload.worker.b h2 = ch.h(this.tGI.tGu);
                                FeedData.a aVar3 = FeedData.Companion;
                                h2.a(FeedData.a.i(baseFinderFeed.feedObject), kotlin.a.j.v((Collection) linkedList2), 0);
                                if (iResponse instanceof FinderFeedRelTimelineLoader.b) {
                                    bcu bcu = (bcu) kotlin.a.j.kt(((FinderFeedRelTimelineLoader.b) iResponse).tVi);
                                    String str = bcu != null ? bcu.IFO : null;
                                    if (bcu != null) {
                                        j2 = bcu.id;
                                    } else {
                                        j2 = 0;
                                    }
                                    StringBuilder append = new StringBuilder("preload this feed video. cardId=").append(com.tencent.mm.ac.d.zs(j2)).append(" titleWording=").append(str).append(' ').append("card request id=");
                                    bcv bcv = this.tGI.tGw.tQQ.LLZ;
                                    if (bcv == null || (ato = bcv.LMc) == null || (efo = ato.LEv) == null) {
                                        j3 = 0;
                                    } else {
                                        j3 = efo.id;
                                    }
                                    Log.i("Finder.FinderStreamCardAlbumConvert", append.append(com.tencent.mm.ac.d.zs(j3)).append(" first feedId=").append(com.tencent.mm.ac.d.zs(baseFinderFeed.lT())).toString());
                                }
                            } else {
                                return;
                            }
                        }
                        this.tGI.tGu.tGp = false;
                        hVar2.a(com.tencent.mm.loader.g.j.OK);
                        AppMethodBeat.o(243307);
                    } finally {
                        this.tGI.tGu.tGp = false;
                        hVar2.a(com.tencent.mm.loader.g.j.OK);
                        AppMethodBeat.o(243307);
                    }
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(243310);
            return xVar;
        }
    }

    public ch(at atVar, int i2) {
        kotlin.g.b.p.h(atVar, "contract");
        AppMethodBeat.i(243324);
        this.tGq = atVar;
        this.dLS = i2;
        com.tencent.mm.loader.g.i iVar = new com.tencent.mm.loader.g.i("StreamCardFeedLoader");
        iVar.start();
        this.tGi = iVar;
        this.tGj = new com.tencent.mm.plugin.finder.feed.model.internal.m<>((byte) 0);
        ArrayList<cjl> arrayList = new ArrayList<>(4);
        for (int i3 = 0; i3 < 4; i3++) {
            arrayList.add(new cjl());
        }
        this.tGk = arrayList;
        this.viewRect = new Rect();
        this.tGl = new Rect();
        this.tGm = new r(this);
        this.tGn = new FinderStreamCardAlbumConvert$lifecycleObserver$1(this);
        this.tGo = new b();
        AppMethodBeat.o(243324);
    }

    public static final /* synthetic */ void a(ch chVar, ag agVar, ecq ecq) {
        AppMethodBeat.i(243332);
        chVar.a(agVar, ecq);
        AppMethodBeat.o(243332);
    }

    public static final /* synthetic */ void a(ch chVar, ag agVar, ecq ecq, kotlin.g.a.b bVar) {
        AppMethodBeat.i(243328);
        chVar.a(true, agVar, ecq, (kotlin.g.a.b<? super ag, x>) bVar);
        AppMethodBeat.o(243328);
    }

    public static final /* synthetic */ ecq b(ch chVar, ag agVar) {
        AppMethodBeat.i(243333);
        ecq a2 = chVar.a(agVar);
        AppMethodBeat.o(243333);
        return a2;
    }

    public static final /* synthetic */ bbn d(ch chVar) {
        AppMethodBeat.i(243326);
        bbn bbn = chVar.ttO;
        if (bbn == null) {
            kotlin.g.b.p.btv("contextObj");
        }
        AppMethodBeat.o(243326);
        return bbn;
    }

    public static final /* synthetic */ boolean i(ch chVar) {
        AppMethodBeat.i(243331);
        boolean cZN = chVar.cZN();
        AppMethodBeat.o(243331);
        return cZN;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, ag agVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243320);
        a(hVar, agVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243320);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.m;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "isExposed", "", "()Z", "setExposed", "(Z)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class r extends RecyclerView.l {
        boolean tGL;
        final /* synthetic */ ch tGu;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(243315);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(243315);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        r(ch chVar) {
            this.tGu = chVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(243314);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                recyclerView.post(new a(this));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(243314);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ r tGM;

            a(r rVar) {
                this.tGM = rVar;
            }

            public final void run() {
                AppMethodBeat.i(243313);
                View view = this.tGM.tGu.aus;
                if (view != null) {
                    boolean a2 = ch.a(this.tGM.tGu, view);
                    if (this.tGM.tGL || !a2) {
                        if (this.tGM.tGL && !a2) {
                            this.tGM.tGL = false;
                            ag agVar = this.tGM.tGu.tGo.tGs;
                            if (agVar != null) {
                                long currentTimeMillis = System.currentTimeMillis() - this.tGM.tGu.tGo.startTimeMs;
                                int indexOf = this.tGM.tGu.tGq.tRo.getDataListJustForAdapter().indexOf(agVar);
                                t tVar = t.vhJ;
                                String str = agVar.tQQ.IFO;
                                if (str == null) {
                                    str = "";
                                }
                                t.a(str, agVar, indexOf, currentTimeMillis, ch.d(this.tGM.tGu));
                                AppMethodBeat.o(243313);
                                return;
                            }
                        }
                        AppMethodBeat.o(243313);
                        return;
                    }
                    this.tGM.tGL = true;
                    this.tGM.tGu.tGo.startTimeMs = System.currentTimeMillis();
                    AppMethodBeat.o(243313);
                    return;
                }
                AppMethodBeat.o(243313);
            }
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(243317);
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        kotlin.g.b.p.h(hVar, "holder");
        this.hak = recyclerView;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Context context = recyclerView.getContext();
        if (context == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(243317);
            throw tVar;
        }
        this.ttO = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderReporterUIC.class)).Mz(this.dLS);
        recyclerView.b(this.tGm);
        recyclerView.a(this.tGm);
        Context context2 = recyclerView.getContext();
        if (context2 == null) {
            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(243317);
            throw tVar2;
        }
        ((MMActivity) context2).getLifecycle().removeObserver(this.tGn);
        Context context3 = recyclerView.getContext();
        if (context3 == null) {
            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(243317);
            throw tVar3;
        }
        ((MMActivity) context3).getLifecycle().addObserver(this.tGn);
        View view = hVar.aus;
        kotlin.g.b.p.g(view, "holder.itemView");
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.gyf);
        linearLayout.post(new h(linearLayout));
        linearLayout.setOnClickListener(new i(this, hVar, i2));
        View view2 = hVar.aus;
        kotlin.g.b.p.g(view2, "holder.itemView");
        ((LinearLayout) view2.findViewById(R.id.hgd)).setOnClickListener(new j(hVar));
        View view3 = hVar.aus;
        kotlin.g.b.p.g(view3, "holder.itemView");
        ((TextView) view3.findViewById(R.id.ajl)).setOnClickListener(new k(hVar));
        View view4 = hVar.aus;
        kotlin.g.b.p.g(view4, "holder.itemView");
        TextView textView = (TextView) view4.findViewById(R.id.ajl);
        kotlin.g.b.p.g(textView, "holder.itemView.cardHeader");
        ao.a(textView.getPaint(), 0.8f);
        View view5 = hVar.aus;
        kotlin.g.b.p.g(view5, "holder.itemView");
        TextView textView2 = (TextView) view5.findViewById(R.id.gyd);
        kotlin.g.b.p.g(textView2, "holder.itemView.refreshContent");
        ao.a(textView2.getPaint(), 0.8f);
        View view6 = hVar.aus;
        kotlin.g.b.p.g(view6, "holder.itemView");
        ((TextView) view6.findViewById(R.id.hgb)).setOnClickListener(new l(this, hVar));
        View view7 = hVar.aus;
        kotlin.g.b.p.g(view7, "holder.itemView");
        ((LinearLayout) view7.findViewById(R.id.ajn)).setOnClickListener(new m(this, hVar));
        View view8 = hVar.aus;
        kotlin.g.b.p.g(view8, "holder.itemView");
        n nVar = new n(this, hVar, this.tGk);
        nVar.wrh = new g(this, hVar);
        ((FinderFeedAlbumView) view8.findViewById(R.id.cef)).setAdapter(nVar);
        if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            hVar.aus.setOnLongClickListener(new o(hVar));
        }
        AppMethodBeat.o(243317);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ LinearLayout tGG;

        h(LinearLayout linearLayout) {
            this.tGG = linearLayout;
        }

        public final void run() {
            AppMethodBeat.i(243297);
            Rect rect = new Rect();
            this.tGG.getHitRect(rect);
            rect.inset(rect.width(), (-rect.height()) / 2);
            LinearLayout linearLayout = this.tGG;
            kotlin.g.b.p.g(linearLayout, "refreshLayout");
            ViewParent parent = linearLayout.getParent();
            if (parent == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(243297);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.tGG));
            AppMethodBeat.o(243297);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ int $type;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ ch tGu;

        i(ch chVar, com.tencent.mm.view.recyclerview.h hVar, int i2) {
            this.tGu = chVar;
            this.qhp = hVar;
            this.$type = i2;
        }

        public final void onClick(final View view) {
            AppMethodBeat.i(243299);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.tGu.isRefreshing) {
                Log.w("Finder.FinderStreamCardAlbumConvert", "isRefreshing");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(243299);
                return;
            }
            this.tGu.isRefreshing = true;
            ag agVar = (ag) this.qhp.hgv();
            long currentTimeMillis = System.currentTimeMillis() - this.tGu.tGo.startTimeMs;
            int indexOf = this.tGu.tGq.tRo.getDataListJustForAdapter().indexOf(agVar);
            t tVar = t.vhJ;
            String str = agVar.tQQ.IFO;
            if (str == null) {
                str = "";
            }
            kotlin.g.b.p.g(agVar, "item");
            t.a(str, agVar, indexOf, currentTimeMillis, ch.d(this.tGu));
            t tVar2 = t.vhJ;
            String str2 = agVar.tQQ.IFO;
            if (str2 == null) {
                str2 = "";
            }
            t.a(str2, agVar.tQQ.id, 3, 0, ch.d(this.tGu), indexOf);
            kotlin.g.b.p.g(view, "view");
            WeImageView weImageView = (WeImageView) view.findViewById(R.id.gye);
            kotlin.g.b.p.g(weImageView, "view.refreshIcon");
            weImageView.setVisibility(8);
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.gyh);
            kotlin.g.b.p.g(progressBar, "view.refreshLoding");
            progressBar.setVisibility(0);
            ch.a(this.tGu, agVar, ch.a(this.tGu, agVar), new kotlin.g.a.b<ag, x>(this) {
                /* class com.tencent.mm.plugin.finder.convert.ch.i.AnonymousClass1 */
                final /* synthetic */ i tGH;

                {
                    this.tGH = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(ag agVar) {
                    AppMethodBeat.i(243298);
                    ag agVar2 = agVar;
                    kotlin.g.b.p.h(agVar2, LocaleUtil.ITALIAN);
                    View view = view;
                    kotlin.g.b.p.g(view, "view");
                    WeImageView weImageView = (WeImageView) view.findViewById(R.id.gye);
                    kotlin.g.b.p.g(weImageView, "view.refreshIcon");
                    weImageView.setVisibility(0);
                    View view2 = view;
                    kotlin.g.b.p.g(view2, "view");
                    ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.gyh);
                    kotlin.g.b.p.g(progressBar, "view.refreshLoding");
                    progressBar.setVisibility(8);
                    if (!agVar2.rvFeedList.isEmpty()) {
                        this.tGH.tGu.a(this.tGH.qhp, agVar2, this.tGH.qhp.lR(), this.tGH.$type, true, (List<Object>) null);
                    }
                    this.tGH.tGu.tGo.startTimeMs = System.currentTimeMillis();
                    this.tGH.tGu.isRefreshing = false;
                    x xVar = x.SXb;
                    AppMethodBeat.o(243298);
                    return xVar;
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243299);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        j(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243300);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View view2 = this.qhp.aus;
            kotlin.g.b.p.g(view2, "holder.itemView");
            ((LinearLayout) view2.findViewById(R.id.ajn)).callOnClick();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243300);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        k(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243301);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View view2 = this.qhp.aus;
            kotlin.g.b.p.g(view2, "holder.itemView");
            ((LinearLayout) view2.findViewById(R.id.ajn)).callOnClick();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243301);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ ch tGu;

        l(ch chVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tGu = chVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243302);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!((ag) this.qhp.hgv()).rvFeedList.isEmpty()) {
                ch chVar = this.tGu;
                Context context = this.qhp.getContext();
                kotlin.g.b.p.g(context, "holder.context");
                ch.a(chVar, context, 4, this.qhp);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243302);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class m implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ ch tGu;

        m(ch chVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tGu = chVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243303);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!((ag) this.qhp.hgv()).rvFeedList.isEmpty()) {
                ch chVar = this.tGu;
                Context context = this.qhp.getContext();
                kotlin.g.b.p.g(context, "holder.context");
                ch.a(chVar, context, 2, this.qhp);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243303);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$7", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter;", "getCardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getFinderVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "plugin-finder_release"})
    public static final class n extends com.tencent.mm.plugin.finder.view.adapter.b {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ ch tGu;

        /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mm/view/recyclerview/h;Ljava/util/List;Z)V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(ch chVar, com.tencent.mm.view.recyclerview.h hVar, List list) {
            super(list, true);
            this.tGu = chVar;
            this.qhp = hVar;
        }

        @Override // com.tencent.mm.plugin.finder.view.adapter.b
        public final ag cZO() {
            AppMethodBeat.i(243304);
            ag agVar = (ag) this.qhp.hgv();
            AppMethodBeat.o(243304);
            return agVar;
        }

        @Override // com.tencent.mm.plugin.finder.view.adapter.b
        public final com.tencent.mm.plugin.finder.video.k cZP() {
            AppMethodBeat.i(243305);
            com.tencent.mm.plugin.finder.video.k kVar = this.tGu.tGq.tCD;
            AppMethodBeat.o(243305);
            return kVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$8$1", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "onClick", "", "position", "", "view", "Landroid/view/View;", "plugin-finder_release"})
    public static final class g implements b.c {
        final /* synthetic */ ch tGu;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        g(ch chVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tGu = chVar;
            this.tzq = hVar;
        }

        @Override // com.tencent.mm.plugin.finder.view.adapter.b.c
        public final void f(int i2, View view) {
            AppMethodBeat.i(243296);
            kotlin.g.b.p.h(view, "view");
            ag agVar = (ag) this.tzq.hgv();
            if (agVar != null) {
                Log.i("Finder.FinderStreamCardAlbumConvert", "[onClick] position=" + i2 + ' ' + agVar.tQQ.id);
                ch chVar = this.tGu;
                Context context = view.getContext();
                kotlin.g.b.p.g(context, "view.context");
                ch.a(chVar, context, 1, this.tzq);
                AppMethodBeat.o(243296);
                return;
            }
            AppMethodBeat.o(243296);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class o implements View.OnLongClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        o(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(243306);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            ag agVar = (ag) this.qhp.hgv();
            StringBuilder append = new StringBuilder("FinderStreamCardFeed=").append(com.tencent.mm.plugin.finder.cgi.interceptor.e.a(agVar.tQQ)).append(' ');
            al alVar = al.tuv;
            LinkedList<FinderObject> linkedList = agVar.tQQ.object;
            kotlin.g.b.p.g(linkedList, "item.card.`object`");
            FinderObject first = linkedList.getFirst();
            kotlin.g.b.p.g(first, "item.card.`object`.first");
            Log.i("Finder.FinderStreamCardAlbumConvert", append.append(al.a(first)).toString());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(243306);
            return true;
        }
    }

    private final ecq a(ag agVar) {
        AppMethodBeat.i(243318);
        ecq ecq = new ecq();
        ecq.NcN = new epf();
        ecq.NcM = new mp();
        ecq.NcO = new cxr();
        ecq.hFK = agVar.tQQ.id;
        ecq.sessionBuffer = agVar.tQQ.sessionBuffer;
        y yVar = y.vXH;
        ecq.tCE = y.LB(this.dLS);
        ecq.finderUsername = z.aUg();
        ecq.NcS = agVar.tQP;
        ecq.NcP = cl.aWA();
        ecq.mediaType = 11;
        AppMethodBeat.o(243318);
        return ecq;
    }

    public final void a(com.tencent.mm.view.recyclerview.h hVar, ag agVar, int i2, int i3, boolean z, List<Object> list) {
        AppMethodBeat.i(243319);
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(agVar, "item");
        Log.i("Finder.FinderStreamCardAlbumConvert", "[onBindViewHolder] isHotPatch=" + z + " pos=" + i2 + " item=" + com.tencent.mm.plugin.finder.cgi.interceptor.e.a(agVar.tQQ) + " rvFeedList isEmpty=" + agVar.rvFeedList.isEmpty());
        this.aus = hVar.aus;
        this.tGo.feedId = agVar.tQQ.id;
        this.tGo.position = i2;
        this.tGo.tGs = agVar;
        agVar.position = i2;
        if (z || !agVar.rvFeedList.isEmpty()) {
            if (!agVar.rvFeedList.isEmpty()) {
                this.tGk.clear();
                ArrayList<cjl> arrayList = this.tGk;
                LinkedList<BaseFinderFeed> linkedList = agVar.rvFeedList;
                ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(linkedList, 10));
                Iterator<T> it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().feedObject.getMediaList().getFirst());
                }
                arrayList.addAll(arrayList2.subList(0, Math.min(4, agVar.rvFeedList.size())));
                View view = hVar.aus;
                kotlin.g.b.p.g(view, "holder.itemView");
                ((FinderFeedAlbumView) view.findViewById(R.id.cef)).dGH();
                View view2 = hVar.aus;
                kotlin.g.b.p.g(view2, "holder.itemView");
                ((FinderFeedAlbumView) view2.findViewById(R.id.cef)).post(new f(this));
                a(agVar, a(agVar));
            }
        } else {
            bcv bcv = agVar.tQQ.LLY;
            if (bcv != null && bcv.type == 1) {
                a(false, agVar, (ecq) null, (kotlin.g.a.b<? super ag, x>) new e(this, hVar, i2, i3, z, list));
            }
        }
        View view3 = hVar.aus;
        kotlin.g.b.p.g(view3, "holder.itemView");
        ((NeatTextView) view3.findViewById(R.id.ipm)).aw(agVar.tQQ.IFO);
        View view4 = hVar.aus;
        kotlin.g.b.p.g(view4, "holder.itemView");
        TextView textView = (TextView) view4.findViewById(R.id.icy);
        kotlin.g.b.p.g(textView, "holder.itemView.subTitle");
        textView.setText(agVar.tQQ.LLT);
        String str = agVar.tQQ.LrN;
        if (str != null) {
            View view5 = hVar.aus;
            kotlin.g.b.p.g(view5, "holder.itemView");
            LinearLayout linearLayout = (LinearLayout) view5.findViewById(R.id.gyf);
            kotlin.g.b.p.g(linearLayout, "holder.itemView.refreshLayout");
            linearLayout.setVisibility(0);
            View view6 = hVar.aus;
            kotlin.g.b.p.g(view6, "holder.itemView");
            TextView textView2 = (TextView) view6.findViewById(R.id.gyd);
            kotlin.g.b.p.g(textView2, "holder.itemView.refreshContent");
            textView2.setText(str);
            AppMethodBeat.o(243319);
            return;
        }
        View view7 = hVar.aus;
        kotlin.g.b.p.g(view7, "holder.itemView");
        LinearLayout linearLayout2 = (LinearLayout) view7.findViewById(R.id.gyf);
        kotlin.g.b.p.g(linearLayout2, "holder.itemView.refreshLayout");
        linearLayout2.setVisibility(8);
        AppMethodBeat.o(243319);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ ch tGu;

        f(ch chVar) {
            this.tGu = chVar;
        }

        public final void run() {
            AppMethodBeat.i(243295);
            FinderVideoAutoPlayManager finderVideoAutoPlayManager = this.tGu.tGq.tCD.weS;
            if (finderVideoAutoPlayManager != null) {
                finderVideoAutoPlayManager.awI("Finder.FinderStreamCardAlbumConvert");
                AppMethodBeat.o(243295);
                return;
            }
            AppMethodBeat.o(243295);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void c(RecyclerView recyclerView) {
        AppMethodBeat.i(243321);
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        super.c(recyclerView);
        Log.i("Finder.FinderStreamCardAlbumConvert", "[onDetachedFromRecyclerView] ret=" + this.tGj.clearCache() + " report unReadItem");
        IResponse<T> iResponse = this.tGj.tYO;
        if (iResponse != null) {
            y yVar = y.vXH;
            int i2 = this.dLS;
            LinkedList incrementList = iResponse.getIncrementList();
            if (incrementList == null) {
                incrementList = new LinkedList();
            }
            bbn bbn = this.ttO;
            if (bbn == null) {
                kotlin.g.b.p.btv("contextObj");
            }
            y.a(i2, incrementList, bbn);
            AppMethodBeat.o(243321);
            return;
        }
        AppMethodBeat.o(243321);
    }

    private final void a(ag agVar, ecq ecq) {
        long j2;
        ato ato;
        efo efo;
        long j3 = 0;
        AppMethodBeat.i(243322);
        if (!cZN()) {
            AppMethodBeat.o(243322);
            return;
        }
        String str = agVar.tQQ.LrN;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(243322);
        } else if (this.tGj.ddC()) {
            Log.w("Finder.FinderStreamCardAlbumConvert", "has cache never use. just return.");
            AppMethodBeat.o(243322);
        } else if (this.tGp) {
            Log.w("Finder.FinderStreamCardAlbumConvert", "isPreloadContenting. just return.");
            AppMethodBeat.o(243322);
        } else {
            this.tGp = true;
            StringBuilder append = new StringBuilder("[preloadContent] now title=").append(agVar.tQQ.IFO).append(" stats=");
            if (ecq != null) {
                j2 = ecq.hFK;
            } else {
                j2 = 0;
            }
            StringBuilder append2 = append.append(com.tencent.mm.ac.d.zs(j2)).append(' ').append("card request id=");
            bcv bcv = agVar.tQQ.LLZ;
            if (!(bcv == null || (ato = bcv.LMc) == null || (efo = ato.LEv) == null)) {
                j3 = efo.id;
            }
            Log.i("Finder.FinderStreamCardAlbumConvert", append2.append(com.tencent.mm.ac.d.zs(j3)).append(' ').append(com.tencent.mm.plugin.finder.cgi.interceptor.e.a(agVar.tQQ)).toString());
            this.tGi.a(new com.tencent.mm.loader.g.h(new p(this, ecq, agVar)));
            AppMethodBeat.o(243322);
        }
    }

    private final void a(boolean z, ag agVar, ecq ecq, kotlin.g.a.b<? super ag, x> bVar) {
        long j2;
        ato ato;
        efo efo;
        AppMethodBeat.i(243323);
        StringBuilder append = new StringBuilder("[fetchContent] isRefresh=").append(z).append(" hasCache=").append(this.tGj.ddC()).append(' ').append("card request id=");
        bcv bcv = agVar.tQQ.LLZ;
        if (bcv == null || (ato = bcv.LMc) == null || (efo = ato.LEv) == null) {
            j2 = 0;
        } else {
            j2 = efo.id;
        }
        Log.i("Finder.FinderStreamCardAlbumConvert", append.append(com.tencent.mm.ac.d.zs(j2)).append(com.tencent.mm.plugin.finder.cgi.interceptor.e.a(agVar.tQQ)).toString());
        bbn bbn = this.ttO;
        if (bbn == null) {
            kotlin.g.b.p.btv("contextObj");
        }
        FinderStreamCardAlbumConvert$fetchContent$loader$1 finderStreamCardAlbumConvert$fetchContent$loader$1 = new FinderStreamCardAlbumConvert$fetchContent$loader$1(this, ecq, bbn);
        finderStreamCardAlbumConvert$fetchContent$loader$1.register(new com.tencent.mm.view.c());
        this.tGi.a(new com.tencent.mm.loader.g.h(new c(this, z, agVar, finderStreamCardAlbumConvert$fetchContent$loader$1, ecq, bVar)));
        AppMethodBeat.o(243323);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b> {
        public static final q tGK = new q();

        static {
            AppMethodBeat.i(243312);
            AppMethodBeat.o(243312);
        }

        q() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.preload.worker.b invoke() {
            AppMethodBeat.i(243311);
            com.tencent.mm.plugin.finder.preload.worker.b bVar = new com.tencent.mm.plugin.finder.preload.worker.b(((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel(), "FinderStreamCardAlbum");
            AppMethodBeat.o(243311);
            return bVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final d tGD = new d();

        static {
            AppMethodBeat.i(243291);
            AppMethodBeat.o(243291);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(243290);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dvz().value().intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(243290);
            return valueOf;
        }
    }

    public static final /* synthetic */ ecq a(ch chVar, ag agVar) {
        AppMethodBeat.i(243327);
        ecq a2 = chVar.a(agVar);
        List listOf = kotlin.a.j.listOf(a2);
        bbn bbn = chVar.ttO;
        if (bbn == null) {
            kotlin.g.b.p.btv("contextObj");
        }
        new com.tencent.mm.plugin.finder.cgi.z(listOf, bbn).aYH().aYI();
        AppMethodBeat.o(243327);
        return a2;
    }

    public static final /* synthetic */ void a(ch chVar, Context context, int i2, com.tencent.mm.view.recyclerview.h hVar) {
        AppMethodBeat.i(243329);
        ag agVar = (ag) hVar.hgv();
        LinkedList<BaseFinderFeed> linkedList = agVar.rvFeedList;
        if (!Util.isNullOrNil(linkedList)) {
            int indexOf = chVar.tGq.tRo.getDataListJustForAdapter().indexOf(agVar);
            t tVar = t.vhJ;
            String str = agVar.tQQ.IFO;
            if (str == null) {
                str = "";
            }
            long j2 = agVar.tQQ.id;
            long lT = linkedList.get(0).lT();
            bbn bbn = chVar.ttO;
            if (bbn == null) {
                kotlin.g.b.p.btv("contextObj");
            }
            t.a(str, j2, i2, lT, bbn, indexOf);
            Log.i("Finder.FinderStreamCardAlbumConvert", "[jumpRelatedTimelineUI] parentIndex=" + indexOf + " cardBuffer=" + agVar.tQQ.tVe);
            if (linkedList.get(0).lT() != 0) {
                Intent intent = new Intent();
                intent.putExtra("TITLE_WORDING", agVar.tQQ.IFO);
                intent.putExtra("CARD_ID", agVar.tQQ.id);
                intent.putExtra("GET_REL_SCENE", agVar.tQQ.LLS);
                intent.putExtra("STREAM_CARD", agVar.tQQ.toByteArray());
                intent.putExtra("COMMENT_SCENE", 51);
                LinkedList linkedList2 = new LinkedList(linkedList);
                y yVar = y.vXH;
                y.a(0, linkedList2, agVar.tQQ.tVe, intent);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.enterAlbumRelatedTimelineUI(context, intent);
            }
        }
        AppMethodBeat.o(243329);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.finder.preload.worker.b h(ch chVar) {
        AppMethodBeat.i(243330);
        com.tencent.mm.plugin.finder.preload.worker.b bVar = (com.tencent.mm.plugin.finder.preload.worker.b) chVar.tGg.getValue();
        AppMethodBeat.o(243330);
        return bVar;
    }

    public static final /* synthetic */ boolean a(ch chVar, View view) {
        AppMethodBeat.i(243334);
        view.getHitRect(chVar.viewRect);
        RecyclerView recyclerView = chVar.hak;
        if (recyclerView != null) {
            recyclerView.getLocalVisibleRect(chVar.tGl);
        }
        if (chVar.viewRect.top < 0) {
            chVar.viewRect.top = 0;
        } else if (chVar.viewRect.top > chVar.tGl.bottom) {
            chVar.viewRect.top = chVar.tGl.bottom;
        }
        if (chVar.viewRect.bottom < 0) {
            chVar.viewRect.bottom = 0;
        } else if (chVar.viewRect.bottom > chVar.tGl.bottom) {
            chVar.viewRect.bottom = chVar.tGl.bottom;
        }
        if (view.getHeight() <= 0 || chVar.viewRect.height() <= 0 || chVar.viewRect.height() < view.getHeight() / 6) {
            AppMethodBeat.o(243334);
            return false;
        }
        AppMethodBeat.o(243334);
        return true;
    }
}
