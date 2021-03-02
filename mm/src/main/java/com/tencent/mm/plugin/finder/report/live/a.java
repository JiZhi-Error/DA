package com.tencent.mm.plugin.finder.report.live;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI;
import com.tencent.mm.plugin.finder.search.f;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J(\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018JR\u0010\u0010\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)J\u000e\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-J\u000e\u0010+\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/J\u000e\u0010+\u001a\u00020\u00112\u0006\u0010.\u001a\u000200J(\u0010+\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00101\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000103R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/Audience21053Report;", "", "()V", "TAG", "", "mExposureCallback", "com/tencent/mm/plugin/finder/report/live/Audience21053Report$mExposureCallback$1", "Lcom/tencent/mm/plugin/finder/report/live/Audience21053Report$mExposureCallback$1;", "mFeedExposure", "Lcom/tencent/mm/plugin/finder/report/live/HellFeedExposure;", "mFeedSingleExposure", "Lcom/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure;", "getSessionBuffer", "feedId", "", "scene", "report", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "event", "Lcom/tencent/mm/plugin/finder/report/live/HELL_SCROLL_EVENT;", "listView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "firstVisibleItem", "", "visibleItemCount", "headerShow", "", "reportOnClick", "clickData", "Lcom/tencent/mm/plugin/finder/report/live/HellVisitorClickData;", "reportOnClickOnShare", "enterData", "Lcom/tencent/mm/plugin/finder/report/live/HellVisitorEnterData;", "reportOnEnter", "reportOnExposure", "liveFeed", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed;", "feed", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveItem;", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveMixSearchItem;", FirebaseAnalytics.b.INDEX, "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "plugin-finder_release"})
public final class a {
    final String TAG = "HABBYGE-MALI.Audience21053Report";
    private final C1268a viY = new C1268a(this);
    private final d viZ = new d(this.viY);
    final f vja = new f(this.viY);

    public a() {
        AppMethodBeat.i(250901);
        AppMethodBeat.o(250901);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\nH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/report/live/Audience21053Report$mExposureCallback$1", "Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;", "onAppear", "", "liveFeed", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed;", "fromSingleFlow", "", "feed", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveItem;", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveMixSearchItem;", "onDisappear", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.report.live.a$a  reason: collision with other inner class name */
    public static final class C1268a implements r {
        final /* synthetic */ a vjb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1268a(a aVar) {
            this.vjb = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.report.live.r
        public final void a(h hVar) {
            AppMethodBeat.i(250892);
            p.h(hVar, "liveFeed");
            AppMethodBeat.o(250892);
        }

        @Override // com.tencent.mm.plugin.finder.report.live.r
        public final void b(i iVar) {
            AppMethodBeat.i(250894);
            p.h(iVar, "feed");
            AppMethodBeat.o(250894);
        }

        @Override // com.tencent.mm.plugin.finder.report.live.r
        public final void b(j jVar) {
            AppMethodBeat.i(250896);
            p.h(jVar, "feed");
            AppMethodBeat.o(250896);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:41:0x02ac, code lost:
            if (r0.equals("FinderFriendTabFragment") != false) goto L_0x02ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x02b8, code lost:
            if (kotlin.g.b.p.j(r11.vjM, com.tencent.mm.plugin.finder.report.live.s.j.COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW.scene) != false) goto L_0x02c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x02c3, code lost:
            if (kotlin.g.b.p.j(r11.vjM, "17") == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x02c5, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(250891);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x02d0, code lost:
            if (r0.equals("FinderMachineTabFragment") != false) goto L_0x02d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x02dc, code lost:
            if (kotlin.g.b.p.j(r11.vjM, com.tencent.mm.plugin.finder.report.live.s.j.COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW.scene) != false) goto L_0x0300;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x02e7, code lost:
            if (kotlin.g.b.p.j(r11.vjM, "17") != false) goto L_0x0300;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x02f3, code lost:
            if (kotlin.g.b.p.j(r11.vjM, com.tencent.mm.plugin.finder.report.live.s.j.COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW.scene) != false) goto L_0x0300;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x02fe, code lost:
            if (kotlin.g.b.p.j(r11.vjM, "18") == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0300, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(250891);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x030b, code lost:
            if (r0.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment") != false) goto L_0x02d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0315, code lost:
            if (r0.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment") != false) goto L_0x02ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
        @Override // com.tencent.mm.plugin.finder.report.live.r
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.plugin.finder.report.live.h r11, boolean r12) {
            /*
            // Method dump skipped, instructions count: 852
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.a.C1268a.a(com.tencent.mm.plugin.finder.report.live.h, boolean):void");
        }

        @Override // com.tencent.mm.plugin.finder.report.live.r
        public final void a(i iVar) {
            AppMethodBeat.i(250893);
            p.h(iVar, "feed");
            if (iVar.vjX) {
                a aVar = this.vjb;
                p.h(iVar, "feed");
                cp cpVar = new cp();
                k kVar = k.vkd;
                k.a(cpVar, iVar.vjW.contact.getUsername());
                cpVar.mR(iVar.feedId);
                cpVar.hy(0);
                cpVar.mY(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                cpVar.hA(iVar.vjL.dDw);
                cpVar.mT(iVar.vjM);
                cpVar.hB((long) iVar.pos);
                cpVar.hC(0);
                cpVar.hD(0);
                cpVar.mU("");
                cpVar.mV(b.cND());
                cpVar.hE(-1);
                cpVar.mW(b.cNB());
                if (n.J(iVar.vjM, "temp_", false)) {
                    if (p.j(cpVar.ach(), "temp_2")) {
                        k kVar2 = k.vkd;
                        cpVar.mX(k.dpl().vlV);
                    } else {
                        cpVar.mX(iVar.vjM);
                    }
                } else if (b.isNumeric(iVar.feedId)) {
                    cpVar.mX(a.aP(Util.getLong(iVar.feedId, -1), Long.parseLong(iVar.vjM)));
                } else {
                    cpVar.mX(iVar.vjM);
                }
                cpVar.bfK();
                Log.i(aVar.TAG, "report21053OnExposure, item, struct:\nnickName=" + iVar.nickName + '\n' + "userName=" + cpVar.getUserName() + '\n' + "feedID=" + cpVar.acf() + '\n' + "liveIDStr=" + cpVar.adY() + '\n' + "actionTS=" + cpVar.acs() + '\n' + "action=" + cpVar.act() + '\n' + "commentScene=" + cpVar.ach() + '\n' + "index=" + cpVar.adU() + '\n' + "enterStatus=" + cpVar.acr() + '\n' + "shareType=" + cpVar.adV() + '\n' + "shareUserName=" + cpVar.adW() + '\n' + "contextId=" + cpVar.acj() + '\n' + "onlineNum=" + cpVar.adX() + '\n' + "clickTabContextId=" + cpVar.ack() + '\n' + "isPrivate=" + cpVar.aci() + '\n' + "sessionBuffer=" + cpVar.getSessionBuffer() + '\n' + "snsFeedId=" + cpVar.adZ() + '\n' + "sessionID=" + cpVar.acl());
            }
            AppMethodBeat.o(250893);
        }

        @Override // com.tencent.mm.plugin.finder.report.live.r
        public final void a(j jVar) {
            String str;
            AppMethodBeat.i(250895);
            p.h(jVar, "feed");
            if (jVar.vjX) {
                a aVar = this.vjb;
                p.h(jVar, "feed");
                cp cpVar = new cp();
                k kVar = k.vkd;
                FinderContact finderContact = jVar.vjY.contact;
                if (finderContact == null || (str = finderContact.username) == null) {
                    str = "";
                }
                k.a(cpVar, str);
                cpVar.mR(jVar.feedId);
                cpVar.hy(0);
                cpVar.mY(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                cpVar.hA(jVar.vjL.dDw);
                cpVar.mT(jVar.vjM);
                cpVar.hB((long) jVar.pos);
                cpVar.hC(0);
                cpVar.hD(0);
                cpVar.mU("");
                cpVar.mV(b.cND());
                cpVar.hE(-1);
                cpVar.mW(b.cNB());
                if (n.J(jVar.vjM, "temp_", false)) {
                    if (p.j(cpVar.ach(), "temp_2")) {
                        k kVar2 = k.vkd;
                        cpVar.mX(k.dpl().vlV);
                    } else {
                        cpVar.mX(jVar.vjM);
                    }
                } else if (b.isNumeric(jVar.feedId)) {
                    long j2 = Util.getLong(jVar.feedId, -1);
                    String ach = cpVar.ach();
                    p.g(ach, "struct.commentScene");
                    cpVar.mX(a.aP(j2, Long.parseLong(ach)));
                } else {
                    cpVar.mX(jVar.vjM);
                }
                cpVar.bfK();
                Log.i(aVar.TAG, "report21053OnExposure, mixsearch, struct:\nnickName=" + jVar.nickName + '\n' + "userName=" + cpVar.getUserName() + '\n' + "feedID=" + cpVar.acf() + '\n' + "liveIDStr=" + cpVar.adY() + '\n' + "actionTS=" + cpVar.acs() + '\n' + "action=" + cpVar.act() + '\n' + "commentScene=" + cpVar.ach() + '\n' + "index=" + cpVar.adU() + '\n' + "enterStatus=" + cpVar.acr() + '\n' + "shareType=" + cpVar.adV() + '\n' + "shareUserName=" + cpVar.adW() + '\n' + "contextId=" + cpVar.acj() + '\n' + "onlineNum=" + cpVar.adX() + '\n' + "clickTabContextId=" + cpVar.ack() + '\n' + "isPrivate=" + cpVar.aci() + '\n' + "sessionBuffer=" + cpVar.getSessionBuffer() + '\n' + "snsFeedId=" + cpVar.adZ() + '\n' + "sessionID=" + cpVar.acl());
            }
            AppMethodBeat.o(250895);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(RecyclerView recyclerView, s.p pVar, String str, c cVar) {
        RecyclerView.a aVar;
        WxRecyclerAdapter<?> wxRecyclerAdapter;
        RecyclerView.LayoutManager layoutManager;
        RecyclerView.a aVar2;
        WxRecyclerAdapter<bo> wxRecyclerAdapter2;
        RecyclerView.LayoutManager layoutManager2;
        RecyclerView.a aVar3;
        f.b bVar;
        RecyclerView.LayoutManager layoutManager3;
        WxRecyclerAdapter<?> wxRecyclerAdapter3;
        RecyclerView.a aVar4;
        FinderContactSearchUI.a aVar5;
        FinderContactSearchUI.a aVar6 = null;
        AppMethodBeat.i(250897);
        p.h(pVar, "actionType");
        p.h(str, "commentscene");
        p.h(cVar, "event");
        if (!p.j(str, "94") && !p.j(str, "80") && !p.j(str, s.j.COMMENT_SCENE_LBS_TOP_LIVE_CARD.scene) && !p.j(str, s.j.COMMENT_SCENE_PROFILE_PAGE.scene) && !p.j(str, "26") && !p.j(str, s.j.COMMENT_SCENE_SEARCH_RESULT_FLOW.scene) && !p.j(str, "15")) {
            if (p.j(str, "61") || p.j(str, "1") || p.j(str, "39") || p.j(str, "40") || p.j(str, "21") || p.j(str, "2") || p.j(str, "25") || p.j(str, "20") || p.j(str, "18") || p.j(str, s.j.COMMENT_SCENE_SEARCH_MORE_CONTACT.scene) || p.j(str, "12") || p.j(str, s.j.COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW.scene) || p.j(str, s.j.COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW.scene) || p.j(str, "27") || p.j(str, "9") || p.j(str, "6") || p.j(str, "16")) {
                f fVar = this.vja;
                p.h(cVar, "event");
                p.h(pVar, "actionType");
                p.h(str, "commentscene");
                switch (g.haE[cVar.ordinal()]) {
                    case 1:
                        if (recyclerView == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        RecyclerView.LayoutManager layoutManager4 = recyclerView.getLayoutManager();
                        if (!(layoutManager4 instanceof LinearLayoutManager)) {
                            layoutManager4 = null;
                        }
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager4;
                        if (linearLayoutManager == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        fVar.vjn = new WeakReference<>(linearLayoutManager);
                        if (p.j(str, s.j.COMMENT_SCENE_SEARCH_MORE_CONTACT.scene)) {
                            RecyclerView.a adapter = recyclerView.getAdapter();
                            if (adapter instanceof FinderContactSearchUI.a) {
                                aVar6 = adapter;
                            }
                            FinderContactSearchUI.a aVar7 = aVar6;
                            if (aVar7 == null) {
                                AppMethodBeat.o(250897);
                                return;
                            }
                            fVar.vjx = new WeakReference<>(aVar7);
                            fVar.a(aVar7, linearLayoutManager, pVar, str);
                            AppMethodBeat.o(250897);
                            return;
                        }
                        RecyclerView.a adapter2 = recyclerView.getAdapter();
                        if (adapter2 instanceof WxRecyclerAdapter) {
                            aVar6 = adapter2;
                        }
                        WxRecyclerAdapter<?> wxRecyclerAdapter4 = (WxRecyclerAdapter) aVar6;
                        if (wxRecyclerAdapter4 == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        fVar.vjo = new WeakReference<>(wxRecyclerAdapter4);
                        fVar.b(wxRecyclerAdapter4, linearLayoutManager, pVar, str);
                        AppMethodBeat.o(250897);
                        return;
                    case 2:
                        if (recyclerView == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        RecyclerView.a adapter3 = recyclerView.getAdapter();
                        if (!(adapter3 instanceof WxRecyclerAdapter)) {
                            adapter3 = null;
                        }
                        WxRecyclerAdapter<?> wxRecyclerAdapter5 = (WxRecyclerAdapter) adapter3;
                        if (wxRecyclerAdapter5 == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        fVar.vjo = new WeakReference<>(wxRecyclerAdapter5);
                        RecyclerView.LayoutManager layoutManager5 = recyclerView.getLayoutManager();
                        if (layoutManager5 instanceof LinearLayoutManager) {
                            aVar6 = layoutManager5;
                        }
                        LinearLayoutManager linearLayoutManager2 = aVar6;
                        if (linearLayoutManager2 == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        fVar.vjn = new WeakReference<>(linearLayoutManager2);
                        fVar.a(wxRecyclerAdapter5, linearLayoutManager2, pVar, str);
                        AppMethodBeat.o(250897);
                        return;
                    default:
                        if (cVar != c.EVENT_ON_RESUME && cVar != c.EVENT_ON_REFRESH) {
                            if (cVar != c.EVENT_ON_PAUSE) {
                                if (cVar == c.EVENT_ON_DESTROY) {
                                    fVar.vjv.clear();
                                    break;
                                }
                            } else if (p.j(str, "12")) {
                                fVar.dpe();
                                AppMethodBeat.o(250897);
                                return;
                            } else if (p.j(str, s.j.COMMENT_SCENE_SEARCH_MORE_CONTACT.scene)) {
                                fVar.dpb();
                                AppMethodBeat.o(250897);
                                return;
                            } else {
                                fVar.dpa();
                                AppMethodBeat.o(250897);
                                return;
                            }
                        } else if (p.j(str, s.j.COMMENT_SCENE_SEARCH_MORE_CONTACT.scene)) {
                            if (recyclerView != null) {
                                aVar4 = recyclerView.getAdapter();
                            } else {
                                aVar4 = null;
                            }
                            if (!(aVar4 instanceof FinderContactSearchUI.a)) {
                                aVar4 = null;
                            }
                            FinderContactSearchUI.a aVar8 = (FinderContactSearchUI.a) aVar4;
                            if (aVar8 == null) {
                                WeakReference<FinderContactSearchUI.a> weakReference = fVar.vjx;
                                if (weakReference != null) {
                                    aVar5 = weakReference.get();
                                } else {
                                    aVar5 = null;
                                }
                            } else {
                                aVar5 = aVar8;
                            }
                            if (aVar5 == null) {
                                AppMethodBeat.o(250897);
                                return;
                            }
                            RecyclerView.LayoutManager layoutManager6 = recyclerView != null ? recyclerView.getLayoutManager() : null;
                            if (!(layoutManager6 instanceof LinearLayoutManager)) {
                                layoutManager6 = null;
                            }
                            LinearLayoutManager linearLayoutManager3 = (LinearLayoutManager) layoutManager6;
                            if (linearLayoutManager3 == null) {
                                WeakReference<LinearLayoutManager> weakReference2 = fVar.vjn;
                                linearLayoutManager3 = weakReference2 != null ? weakReference2.get() : null;
                            }
                            if (linearLayoutManager3 == null) {
                                AppMethodBeat.o(250897);
                                return;
                            }
                            fVar.a(aVar5, linearLayoutManager3, pVar, str);
                            AppMethodBeat.o(250897);
                            return;
                        } else {
                            RecyclerView.a adapter4 = recyclerView != null ? recyclerView.getAdapter() : null;
                            if (!(adapter4 instanceof WxRecyclerAdapter)) {
                                adapter4 = null;
                            }
                            WxRecyclerAdapter<?> wxRecyclerAdapter6 = (WxRecyclerAdapter) adapter4;
                            if (wxRecyclerAdapter6 == null) {
                                WeakReference<WxRecyclerAdapter<?>> weakReference3 = fVar.vjo;
                                wxRecyclerAdapter3 = weakReference3 != null ? weakReference3.get() : null;
                            } else {
                                wxRecyclerAdapter3 = wxRecyclerAdapter6;
                            }
                            if (wxRecyclerAdapter3 == null) {
                                AppMethodBeat.o(250897);
                                return;
                            }
                            RecyclerView.LayoutManager layoutManager7 = recyclerView != null ? recyclerView.getLayoutManager() : null;
                            if (!(layoutManager7 instanceof LinearLayoutManager)) {
                                layoutManager7 = null;
                            }
                            LinearLayoutManager linearLayoutManager4 = (LinearLayoutManager) layoutManager7;
                            if (linearLayoutManager4 == null) {
                                WeakReference<LinearLayoutManager> weakReference4 = fVar.vjn;
                                linearLayoutManager4 = weakReference4 != null ? weakReference4.get() : null;
                            }
                            if (linearLayoutManager4 == null) {
                                AppMethodBeat.o(250897);
                                return;
                            }
                            fVar.b(wxRecyclerAdapter3, linearLayoutManager4, pVar, str);
                            AppMethodBeat.o(250897);
                            return;
                        }
                        break;
                }
            }
        } else {
            d dVar = this.viZ;
            p.h(cVar, "event");
            p.h(pVar, "actionType");
            p.h(str, "commentscene");
            switch (e.$EnumSwitchMapping$0[cVar.ordinal()]) {
                case 1:
                    if (recyclerView != null) {
                        RecyclerView.LayoutManager layoutManager8 = recyclerView.getLayoutManager();
                        if (!(layoutManager8 instanceof StaggeredGridLayoutManager)) {
                            layoutManager8 = null;
                        }
                        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager8;
                        if (staggeredGridLayoutManager == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        dVar.vjn = new WeakReference<>(staggeredGridLayoutManager);
                        if (p.j(str, s.j.COMMENT_SCENE_SEARCH_RESULT_FLOW.scene)) {
                            RecyclerView.a adapter5 = recyclerView.getAdapter();
                            if (adapter5 instanceof f.b) {
                                aVar6 = adapter5;
                            }
                            f.b bVar2 = aVar6;
                            if (bVar2 == null) {
                                AppMethodBeat.o(250897);
                                return;
                            }
                            dVar.vjp = new WeakReference<>(bVar2);
                            dVar.a(bVar2, staggeredGridLayoutManager, pVar, str);
                            AppMethodBeat.o(250897);
                            return;
                        } else if (p.j(str, s.j.COMMENT_SCENE_PROFILE_PAGE.scene)) {
                            RecyclerView.a adapter6 = recyclerView.getAdapter();
                            if (adapter6 instanceof WxRecyclerAdapter) {
                                aVar6 = adapter6;
                            }
                            WxRecyclerAdapter<bo> wxRecyclerAdapter7 = aVar6;
                            if (wxRecyclerAdapter7 == null) {
                                AppMethodBeat.o(250897);
                                return;
                            }
                            dVar.vjq = new WeakReference<>(wxRecyclerAdapter7);
                            dVar.a(wxRecyclerAdapter7, staggeredGridLayoutManager, pVar, str);
                            AppMethodBeat.o(250897);
                            return;
                        } else {
                            RecyclerView.a adapter7 = recyclerView.getAdapter();
                            if (adapter7 instanceof WxRecyclerAdapter) {
                                aVar6 = adapter7;
                            }
                            WxRecyclerAdapter<?> wxRecyclerAdapter8 = aVar6;
                            if (wxRecyclerAdapter8 == null) {
                                AppMethodBeat.o(250897);
                                return;
                            }
                            dVar.vjo = new WeakReference<>(wxRecyclerAdapter8);
                            dVar.b(wxRecyclerAdapter8, staggeredGridLayoutManager, pVar, str);
                            AppMethodBeat.o(250897);
                            return;
                        }
                    }
                    break;
                case 2:
                    if (recyclerView != null) {
                        RecyclerView.a adapter8 = recyclerView.getAdapter();
                        if (!(adapter8 instanceof WxRecyclerAdapter)) {
                            adapter8 = null;
                        }
                        WxRecyclerAdapter<?> wxRecyclerAdapter9 = (WxRecyclerAdapter) adapter8;
                        if (wxRecyclerAdapter9 == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        dVar.vjs = new WeakReference<>(wxRecyclerAdapter9);
                        RecyclerView.LayoutManager layoutManager9 = recyclerView.getLayoutManager();
                        if (layoutManager9 instanceof LinearLayoutManager) {
                            aVar6 = layoutManager9;
                        }
                        LinearLayoutManager linearLayoutManager5 = aVar6;
                        if (linearLayoutManager5 == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        dVar.vjr = new WeakReference<>(linearLayoutManager5);
                        dVar.a(wxRecyclerAdapter9, linearLayoutManager5, pVar, str);
                        AppMethodBeat.o(250897);
                        return;
                    }
                    break;
                case 3:
                case 4:
                    if (p.j(str, s.j.COMMENT_SCENE_SEARCH_RESULT_FLOW.scene)) {
                        if (recyclerView != null) {
                            aVar3 = recyclerView.getAdapter();
                        } else {
                            aVar3 = null;
                        }
                        if (!(aVar3 instanceof f.b)) {
                            aVar3 = null;
                        }
                        f.b bVar3 = (f.b) aVar3;
                        if (bVar3 == null) {
                            WeakReference<f.b> weakReference5 = dVar.vjp;
                            if (weakReference5 != null) {
                                bVar = weakReference5.get();
                            } else {
                                bVar = null;
                            }
                        } else {
                            bVar = bVar3;
                        }
                        if (bVar == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        if (recyclerView != null) {
                            layoutManager3 = recyclerView.getLayoutManager();
                        } else {
                            layoutManager3 = null;
                        }
                        if (!(layoutManager3 instanceof StaggeredGridLayoutManager)) {
                            layoutManager3 = null;
                        }
                        StaggeredGridLayoutManager staggeredGridLayoutManager2 = (StaggeredGridLayoutManager) layoutManager3;
                        if (staggeredGridLayoutManager2 == null) {
                            WeakReference<StaggeredGridLayoutManager> weakReference6 = dVar.vjn;
                            staggeredGridLayoutManager2 = weakReference6 != null ? weakReference6.get() : null;
                        }
                        if (staggeredGridLayoutManager2 == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        dVar.a(bVar, staggeredGridLayoutManager2, pVar, str);
                        AppMethodBeat.o(250897);
                        return;
                    } else if (p.j(str, s.j.COMMENT_SCENE_PROFILE_PAGE.scene)) {
                        if (recyclerView != null) {
                            aVar2 = recyclerView.getAdapter();
                        } else {
                            aVar2 = null;
                        }
                        if (!(aVar2 instanceof WxRecyclerAdapter)) {
                            aVar2 = null;
                        }
                        WxRecyclerAdapter<bo> wxRecyclerAdapter10 = (WxRecyclerAdapter) aVar2;
                        if (wxRecyclerAdapter10 == null) {
                            WeakReference<WxRecyclerAdapter<bo>> weakReference7 = dVar.vjq;
                            if (weakReference7 != null) {
                                wxRecyclerAdapter2 = weakReference7.get();
                            } else {
                                wxRecyclerAdapter2 = null;
                            }
                        } else {
                            wxRecyclerAdapter2 = wxRecyclerAdapter10;
                        }
                        if (wxRecyclerAdapter2 == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        if (recyclerView != null) {
                            layoutManager2 = recyclerView.getLayoutManager();
                        } else {
                            layoutManager2 = null;
                        }
                        if (!(layoutManager2 instanceof StaggeredGridLayoutManager)) {
                            layoutManager2 = null;
                        }
                        StaggeredGridLayoutManager staggeredGridLayoutManager3 = (StaggeredGridLayoutManager) layoutManager2;
                        if (staggeredGridLayoutManager3 == null) {
                            WeakReference<StaggeredGridLayoutManager> weakReference8 = dVar.vjn;
                            staggeredGridLayoutManager3 = weakReference8 != null ? weakReference8.get() : null;
                        }
                        if (staggeredGridLayoutManager3 == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        dVar.a(wxRecyclerAdapter2, staggeredGridLayoutManager3, pVar, str);
                        AppMethodBeat.o(250897);
                        return;
                    } else {
                        if (recyclerView != null) {
                            aVar = recyclerView.getAdapter();
                        } else {
                            aVar = null;
                        }
                        if (!(aVar instanceof WxRecyclerAdapter)) {
                            aVar = null;
                        }
                        WxRecyclerAdapter<?> wxRecyclerAdapter11 = (WxRecyclerAdapter) aVar;
                        if (wxRecyclerAdapter11 == null) {
                            WeakReference<WxRecyclerAdapter<?>> weakReference9 = dVar.vjo;
                            if (weakReference9 != null) {
                                wxRecyclerAdapter = weakReference9.get();
                            } else {
                                wxRecyclerAdapter = null;
                            }
                        } else {
                            wxRecyclerAdapter = wxRecyclerAdapter11;
                        }
                        if (wxRecyclerAdapter == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        if (recyclerView != null) {
                            layoutManager = recyclerView.getLayoutManager();
                        } else {
                            layoutManager = null;
                        }
                        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                            layoutManager = null;
                        }
                        StaggeredGridLayoutManager staggeredGridLayoutManager4 = (StaggeredGridLayoutManager) layoutManager;
                        if (staggeredGridLayoutManager4 == null) {
                            WeakReference<StaggeredGridLayoutManager> weakReference10 = dVar.vjn;
                            staggeredGridLayoutManager4 = weakReference10 != null ? weakReference10.get() : null;
                        }
                        if (staggeredGridLayoutManager4 == null) {
                            AppMethodBeat.o(250897);
                            return;
                        }
                        dVar.b(wxRecyclerAdapter, staggeredGridLayoutManager4, pVar, str);
                        AppMethodBeat.o(250897);
                        return;
                    }
                case 5:
                    dVar.dpa();
                    if (p.j(str, s.j.COMMENT_SCENE_SEARCH_RESULT_FLOW.scene)) {
                        dVar.dpb();
                        AppMethodBeat.o(250897);
                        return;
                    }
                    AppMethodBeat.o(250897);
                    return;
                case 6:
                    dVar.vjv.clear();
                    AppMethodBeat.o(250897);
                    return;
                default:
                    Log.e(dVar.TAG, "run, else-case, event=".concat(String.valueOf(cVar)));
                    AppMethodBeat.o(250897);
                    return;
            }
        }
        AppMethodBeat.o(250897);
    }

    public final void a(s.p pVar, int i2, String str, FeedData feedData) {
        String str2;
        AppMethodBeat.i(250898);
        p.h(pVar, "actionType");
        p.h(str, "commentscene");
        if (feedData == null) {
            AppMethodBeat.o(250898);
            return;
        }
        cp cpVar = new cp();
        k kVar = k.vkd;
        k.a(cpVar, feedData.getUserName());
        cpVar.mR(b.zs(feedData.getFeedId()));
        cpVar.hy(feedData.getLiveId());
        cpVar.mY(b.zs(feedData.getLiveId()));
        cpVar.hA(pVar.dDw);
        cpVar.mT(str);
        cpVar.hB((long) i2);
        cpVar.hC(0);
        cpVar.hD(0);
        cpVar.mU(feedData.getUserName());
        cpVar.mV(b.cND());
        cpVar.hE((long) feedData.getOnlineNum());
        cpVar.mW(b.cNB());
        if (p.j(cpVar.ach(), "temp_2")) {
            k kVar2 = k.vkd;
            cpVar.mX(k.dpl().vlV);
        } else {
            cpVar.mX(n.j(feedData.getSessionBuffer(), ",", ";", false));
        }
        if (p.j(cpVar.ach(), "61")) {
            if (TextUtils.isEmpty(c.sEy)) {
                com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                p.g(cPO, "HellSessionMonitor.getInstance()");
                str2 = cPO.cPR();
            } else {
                str2 = c.sEy;
            }
            cpVar.na(str2);
        }
        cpVar.bfK();
        Log.i(this.TAG, "report21053OnExposure, struct-2:\nuserName=" + cpVar.getUserName() + '\n' + "nickName=" + feedData.getNickName() + '\n' + "feedID=" + cpVar.acf() + '\n' + "liveIDStr=" + cpVar.adY() + '\n' + "actionTS=" + cpVar.acs() + '\n' + "action=" + cpVar.act() + '\n' + "commentScene=" + cpVar.ach() + '\n' + "index=" + cpVar.adU() + '\n' + "enterStatus=" + cpVar.acr() + '\n' + "shareType=" + cpVar.adV() + '\n' + "shareUserName=" + cpVar.adW() + '\n' + "contextId=" + cpVar.acj() + '\n' + "onlineNum=" + cpVar.adX() + '\n' + "clickTabContextId=" + cpVar.ack() + '\n' + "isPrivate=" + cpVar.aci() + '\n' + "sessionBuffer=" + cpVar.getSessionBuffer() + '\n' + "snsFeedId=" + cpVar.adZ() + '\n' + "enterSessionId=" + cpVar.aea() + '\n' + "enterIconType=" + cpVar.acv() + '\n' + "snsSessionID=" + cpVar.aeb() + '\n' + "sessionID=" + cpVar.acl());
        AppMethodBeat.o(250898);
    }

    public final void a(p pVar) {
        String str;
        AppMethodBeat.i(250899);
        p.h(pVar, "clickData");
        cp cpVar = new cp();
        k kVar = k.vkd;
        k.a(cpVar, pVar.userName);
        cpVar.mR(b.zs(pVar.feedId));
        cpVar.hy(pVar.liveId);
        cpVar.mY(b.zs(pVar.liveId));
        cpVar.hA(pVar.vjL.dDw);
        cpVar.mT(pVar.vjM);
        cpVar.hB(pVar.vln);
        cpVar.hC(0);
        cpVar.hD(pVar.vlp);
        cpVar.mU(pVar.vlq);
        cpVar.mZ(pVar.vlr);
        cpVar.mV(b.cND());
        cpVar.hE(pVar.vlo);
        cpVar.mW(b.cNB());
        if (!n.J(pVar.vjM, "temp_", false)) {
            long j2 = pVar.feedId;
            String ach = cpVar.ach();
            p.g(ach, "struct.commentScene");
            cpVar.mX(aP(j2, Long.parseLong(ach)));
        } else if (p.j(cpVar.ach(), "temp_2")) {
            k kVar2 = k.vkd;
            cpVar.mX(k.dpl().vlV);
        } else {
            cpVar.mX(pVar.vjM);
        }
        if (p.j(cpVar.ach(), "61")) {
            if (TextUtils.isEmpty(c.sEy)) {
                com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                p.g(cPO, "HellSessionMonitor.getInstance()");
                str = cPO.cPR();
            } else {
                str = c.sEy;
            }
            cpVar.na(str);
        }
        cpVar.bfK();
        Log.i(this.TAG, "report21053OnClick, struct=\nfeedId=" + cpVar.acf() + '\n' + "liveId=" + cpVar.adY() + '\n' + "userName=" + cpVar.getUserName() + '\n' + "isPrivate=" + cpVar.aci() + '\n' + "sessionID=" + cpVar.acl() + '\n' + "actionTS=" + cpVar.acs() + '\n' + "action=" + cpVar.act() + '\n' + "commentScene=" + cpVar.ach() + '\n' + "index=" + cpVar.adU() + '\n' + "enterStatus=" + cpVar.acr() + '\n' + "contextId=" + cpVar.acj() + '\n' + "onlineNum=" + cpVar.adX() + '\n' + "clickTabContextId=" + cpVar.ack() + '\n' + "sessionBuffer=" + cpVar.getSessionBuffer() + '\n' + "enterSessionId=" + cpVar.aea() + '\n' + "enterIconType=" + cpVar.acv() + '\n' + "snsSessionID=" + cpVar.aeb() + '\n' + "shareType=" + cpVar.adV() + '\n' + "shareUserName=" + cpVar.adW() + '\n' + "snsFeedId=" + cpVar.adZ());
        AppMethodBeat.o(250899);
    }

    public final void a(q qVar) {
        String str;
        AppMethodBeat.i(250900);
        p.h(qVar, "enterData");
        cp cpVar = new cp();
        k kVar = k.vkd;
        k.a(cpVar, qVar.userName);
        cpVar.mR(b.zs(qVar.feedId));
        cpVar.hy(qVar.liveId);
        cpVar.mY(b.zs(qVar.liveId));
        cpVar.hA(qVar.vjL.dDw);
        cpVar.mT(qVar.vjM);
        cpVar.hB(qVar.vln);
        cpVar.hC(qVar.vlt);
        cpVar.hD(qVar.vlp);
        cpVar.mU(qVar.vlq);
        cpVar.mZ(qVar.vlr);
        cpVar.mV(b.cND());
        cpVar.hE(qVar.vlo);
        cpVar.mW(b.cNB());
        if (!n.J(qVar.vjM, "temp_", false)) {
            long j2 = qVar.feedId;
            String ach = cpVar.ach();
            p.g(ach, "struct.commentScene");
            cpVar.mX(aP(j2, Long.parseLong(ach)));
        } else if (p.j(cpVar.ach(), "temp_2")) {
            k kVar2 = k.vkd;
            cpVar.mX(k.dpl().vlV);
        } else {
            cpVar.mX(qVar.vjM);
        }
        cpVar.hG(qVar.enterTime);
        k kVar3 = k.vkd;
        cpVar.hH(s.as(cpVar.ach(), (long) qVar.vlu.type));
        if (p.j(cpVar.ach(), "61")) {
            if (TextUtils.isEmpty(c.sEy)) {
                com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                p.g(cPO, "HellSessionMonitor.getInstance()");
                str = cPO.cPR();
            } else {
                str = c.sEy;
            }
            cpVar.na(str);
        }
        cpVar.bfK();
        Log.i(this.TAG, "report21053OnEnter, struct=\nfeedId=" + cpVar.acf() + '\n' + "liveId=" + cpVar.adY() + '\n' + "userName=" + cpVar.getUserName() + '\n' + "isPrivate=" + cpVar.aci() + '\n' + "sessionID=" + cpVar.acl() + '\n' + "actionTS=" + cpVar.acs() + '\n' + "action=" + cpVar.act() + '\n' + "commentScene=" + cpVar.ach() + '\n' + "index=" + cpVar.adU() + '\n' + "enterStatus=" + cpVar.acr() + '\n' + "contextId=" + cpVar.acj() + '\n' + "onlineNum=" + cpVar.adX() + '\n' + "clickTabContextId=" + cpVar.ack() + '\n' + "sessionBuffer=" + cpVar.getSessionBuffer() + '\n' + "shareType=" + cpVar.adV() + '\n' + "shareUserName=" + cpVar.adW() + '\n' + "enterSessionId=" + cpVar.aea() + '\n' + "enterIconType=" + cpVar.acv() + '\n' + "snsSessionID=" + cpVar.aeb() + '\n' + "snsFeedId=" + cpVar.adZ());
        AppMethodBeat.o(250900);
    }

    static String aP(long j2, long j3) {
        String str;
        String str2;
        AppMethodBeat.i(261326);
        o oVar = o.ujN;
        g dfZ = o.dfZ();
        if (dfZ != null) {
            str = dfZ.sessionBuffer;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            k kVar = k.vfA;
            str = k.G(j2, (int) j3);
            if (TextUtils.isEmpty(str)) {
                m mVar = m.vli;
                str = m.hUK();
                if (TextUtils.isEmpty(str)) {
                    m mVar2 = m.vli;
                    str = m.getSessionBuffer();
                }
            }
        }
        if (str == null || (str2 = n.j(str, ",", ";", false)) == null) {
            str2 = "";
        }
        AppMethodBeat.o(261326);
        return str2;
    }
}
