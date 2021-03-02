package com.tencent.mm.plugin.finder.search;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.search.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0010H\u0016J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0010H\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0)H\u0016J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\fH\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0015H\u0016J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020!H\u0016J\u0018\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0010H\u0016J\b\u00101\u001a\u00020#H\u0016J\b\u00102\u001a\u00020#H\u0016J\u0010\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0015H\u0016J\b\u00105\u001a\u00020\u0017H\u0016J,\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00102\b\u00109\u001a\u0004\u0018\u00010\u00072\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J \u0010<\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u0017H\u0002J\u0012\u0010?\u001a\u00020#2\b\b\u0002\u0010@\u001a\u00020\u0017H\u0002J*\u0010A\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010B\u001a\u00020\u00172\b\u0010C\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\fj\b\u0012\u0004\u0012\u00020\u0015`\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "feedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isFromHistory", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "lastSearchResult", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "offset", SearchIntents.EXTRA_QUERY, "requestId", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "type", "getContactList", "", "getFeedList", "jumpToLive", "feed", "onAttach", "callback", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onDetach", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSearch", "isAccountEmpty", "isFeedEmpty", "reportSearchExpose", "needClear", "startSearchQuery", "isFromHot", "sessionBuffer", "plugin-finder_release"})
public final class FinderMixSearchPresenter implements i, e.a {
    private final String TAG = "Finder.FinderMixSearchPresenter";
    private int continueFlag;
    private String dPI = "";
    private ArrayList<BaseFinderFeed> feedList = new ArrayList<>();
    private MMActivity gte;
    private int offset;
    private String query;
    private b tVM;
    private boolean twi;
    private ArrayList<bbz> uae = new ArrayList<>();
    private HashMap<String, a> vtH = new HashMap<>();
    private cf vtL;
    private String vus = "";
    private e.b vut;
    private final a vuu = new a(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(e.b bVar) {
        AppMethodBeat.i(166808);
        a(bVar);
        AppMethodBeat.o(166808);
    }

    public FinderMixSearchPresenter(MMActivity mMActivity) {
        p.h(mMActivity, "context");
        AppMethodBeat.i(166815);
        this.gte = mMActivity;
        AppMethodBeat.o(166815);
    }

    public final void br(String str, boolean z) {
        AppMethodBeat.i(251311);
        p.h(str, SearchIntents.EXTRA_QUERY);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 3, 1, false);
        ov(true);
        this.offset = 0;
        this.continueFlag = 0;
        this.tVM = null;
        this.uae.clear();
        this.feedList.clear();
        this.query = str;
        String uuid = UUID.randomUUID().toString();
        p.g(uuid, "UUID.randomUUID().toString()");
        this.dPI = uuid;
        if (this.vtL != null) {
            g.azz().a(this.vtL);
            this.vtL = null;
        }
        if (!Util.isNullOrNil(str)) {
            int i2 = this.offset;
            String str2 = this.dPI;
            b bVar = this.tVM;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            this.vtL = new cf(str, i2, str2, bVar, 0, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx(), (b) null);
            g.azz().b(this.vtL);
            g.azz().a(3820, this);
            e.b bVar2 = this.vut;
            if (bVar2 != null) {
                bVar2.dpE();
            }
        }
        this.twi = z;
        AppMethodBeat.o(251311);
    }

    private final void ov(boolean z) {
        AppMethodBeat.i(166804);
        if (!Util.isNullOrNil(this.dPI)) {
            if (!this.vtH.isEmpty()) {
                com.tencent.mm.plugin.finder.report.l lVar = com.tencent.mm.plugin.finder.report.l.vfB;
                com.tencent.mm.plugin.finder.report.l.a(this.dPI, this.query, this.vtH, 1);
                if (z) {
                    this.vtH.clear();
                }
            }
        }
        AppMethodBeat.o(166804);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        AppMethodBeat.i(166805);
        g.azz().b(3820, this);
        e.b bVar = this.vut;
        if (bVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchViewCallback");
            AppMethodBeat.o(166805);
            throw tVar;
        }
        ((f) bVar).dpF();
        int size = this.uae.size();
        int size2 = this.feedList.size();
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 4, 1, false);
            cf cfVar = this.vtL;
            bcb bcb = cfVar != null ? cfVar.twl : null;
            if (bcb == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
                AppMethodBeat.o(166805);
                throw tVar2;
            }
            LinkedList<bbz> linkedList = bcb.zns;
            p.g(linkedList, "response.infoList");
            LinkedList<bbz> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
            for (T t : linkedList2) {
                if (t.contact != null) {
                    this.uae.add(t);
                }
                arrayList.add(x.SXb);
            }
            LinkedList<FinderObject> linkedList3 = bcb.tbD;
            p.g(linkedList3, "response.objectList");
            LinkedList<FinderObject> linkedList4 = linkedList3;
            ArrayList arrayList2 = new ArrayList(j.a(linkedList4, 10));
            for (T t2 : linkedList4) {
                FinderItem.a aVar = FinderItem.Companion;
                p.g(t2, LocaleUtil.ITALIAN);
                FinderItem a2 = FinderItem.a.a((FinderObject) t2, 16);
                c.a aVar2 = c.vGN;
                arrayList2.add(Boolean.valueOf(this.feedList.add(c.a.s(a2))));
            }
            this.offset = bcb.offset;
            this.continueFlag = bcb.continueFlag;
            this.tVM = bcb.tVM;
            Log.i(this.TAG, "onSceneEnd " + bcb.zns.size() + ' ' + bcb.offset + ' ' + bcb.continueFlag + ' ' + this.uae.size() + ' ' + this.feedList.size());
            String str3 = this.vus;
            String str4 = this.query;
            if (str4 == null) {
                str4 = "";
            }
            if (!p.j(str3, str4)) {
                com.tencent.mm.plugin.finder.report.l lVar = com.tencent.mm.plugin.finder.report.l.vfB;
                String str5 = this.query;
                if (str5 == null) {
                    str2 = "";
                } else {
                    str2 = str5;
                }
                ArrayList<BaseFinderFeed> arrayList3 = this.feedList;
                ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
                Iterator<T> it = arrayList3.iterator();
                while (it.hasNext()) {
                    arrayList4.add(it.next().feedObject.getUnsignedId());
                }
                com.tencent.mm.plugin.finder.report.l.t(str2, arrayList4);
                String str6 = this.query;
                if (str6 == null) {
                    str6 = "";
                }
                this.vus = str6;
            }
            String str7 = this.query;
            if (str7 == null) {
                str7 = "";
            }
            boolean isEmpty = bcb.zns.isEmpty();
            boolean isEmpty2 = bcb.tbD.isEmpty();
            int i4 = this.twi ? 2 : 1;
            int i5 = isEmpty ? 1 : 2;
            int i6 = isEmpty2 ? 1 : 2;
            k kVar = k.vfA;
            k kVar2 = k.vfA;
            String dob = k.dob();
            String str8 = this.dPI;
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            k.a(dob, str8, str7, 1, i4, 2, i5, i6, fH != null ? fH.dIx() : null);
        } else {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 5, 1, false);
        }
        e.b bVar2 = this.vut;
        if (bVar2 != null) {
            bVar2.gg(size, size2);
            AppMethodBeat.o(166805);
            return;
        }
        AppMethodBeat.o(166805);
    }

    @Override // com.tencent.mm.plugin.finder.search.e.a
    public final List<bbz> dpA() {
        return this.uae;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(166806);
        g.azz().b(3820, this);
        ov(true);
        this.vuu.dead();
        AppMethodBeat.o(166806);
    }

    public final void a(e.b bVar) {
        AppMethodBeat.i(166807);
        p.h(bVar, "callback");
        this.vut = bVar;
        this.vuu.alive();
        AppMethodBeat.o(166807);
    }

    @Override // com.tencent.mm.plugin.finder.search.e.a
    public final void a(bbz bbz, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(166809);
        p.h(bbz, "finderSearchInfo");
        Intent intent = new Intent();
        FinderContact finderContact = bbz.contact;
        if (finderContact == null || (str = finderContact.username) == null) {
            str = "";
        }
        intent.putExtra("finder_username", str);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(this.gte, intent, 0, 7, false, 64);
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(this.gte, intent);
        int i3 = this.twi ? 2 : 1;
        k kVar = k.vfA;
        String str5 = this.dPI;
        String str6 = this.query;
        FinderContact finderContact2 = bbz.contact;
        if (finderContact2 == null || (str2 = finderContact2.username) == null) {
            str2 = "";
        }
        k kVar2 = k.vfA;
        String dob = k.dob();
        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
        k.a(str5, str6, 0, 1, str2, i2, 1, dob, i3, fH != null ? fH.dIx() : null);
        k kVar3 = k.vfA;
        String str7 = this.dPI;
        String str8 = this.query;
        FinderContact finderContact3 = bbz.contact;
        if (finderContact3 == null || (str3 = finderContact3.username) == null) {
            str3 = "";
        }
        k kVar4 = k.vfA;
        String dob2 = k.dob();
        FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
        k.a(str7, str8, 0, 1, str3, i2, 1, dob2, 2, i3, fH2 != null ? fH2.dIx() : null);
        FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
        FinderReporterUIC fH3 = FinderReporterUIC.a.fH(this.gte);
        if (fH3 != null) {
            k kVar5 = k.vfA;
            int i4 = fH3.tCE;
            FinderContact finderContact4 = bbz.contact;
            if (finderContact4 == null || (str4 = finderContact4.username) == null) {
                str4 = "";
            }
            k.a(6, 0, i4, 1, str4);
            AppMethodBeat.o(166809);
            return;
        }
        AppMethodBeat.o(166809);
    }

    @Override // com.tencent.mm.plugin.finder.search.e.a
    public final void dpB() {
        AppMethodBeat.i(166810);
        Intent intent = new Intent();
        aqw aqw = new aqw();
        aqw.dPI = this.dPI;
        aqw.query = this.query;
        aqw.offset = this.offset;
        aqw.continueFlag = 1;
        aqw.tVM = this.tVM;
        ArrayList<bbz> arrayList = this.uae;
        ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Boolean.valueOf(aqw.LCI.add(it.next())));
        }
        try {
            intent.putExtra("request_type", 1);
        } catch (Exception e2) {
        }
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        AppCompatActivity context = this.gte.getContext();
        p.g(context, "context.context");
        com.tencent.mm.plugin.finder.utils.a.a(context, aqw, intent);
        AppMethodBeat.o(166810);
    }

    @Override // com.tencent.mm.plugin.finder.search.e.a
    public final boolean dpC() {
        AppMethodBeat.i(166811);
        if (this.continueFlag == 1) {
            String str = this.query;
            if (str != null) {
                int i2 = this.offset;
                String str2 = this.dPI;
                b bVar = this.tVM;
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                this.vtL = new cf(str, i2, str2, bVar, 0, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx(), 64);
                g.azz().b(this.vtL);
                g.azz().a(3820, this);
                AppMethodBeat.o(166811);
                return true;
            }
            AppMethodBeat.o(166811);
            return false;
        }
        AppMethodBeat.o(166811);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.search.e.a
    public final void r(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(166812);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(baseFinderFeed);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", this, bVar.axR());
        p.h(baseFinderFeed, "finderFeedObj");
        aqw aqw = new aqw();
        aqw.dPI = this.dPI;
        aqw.query = this.query;
        aqw.offset = this.offset;
        aqw.continueFlag = 1;
        aqw.tVM = this.tVM;
        ArrayList<BaseFinderFeed> arrayList = this.feedList;
        ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Boolean.valueOf(aqw.tbD.add(it.next().feedObject.getFeedObject())));
        }
        int i2 = 0;
        LinkedList<FinderObject> linkedList = aqw.tbD;
        p.g(linkedList, "finderFeedSearchObj.objectList");
        Iterator<T> it2 = linkedList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            if (baseFinderFeed.feedObject.getFeedObject().id == next.id) {
                aqw.LCH = i2;
                int i3 = this.twi ? 2 : 1;
                k kVar = k.vfA;
                String Fg = k.Fg(next.id);
                k kVar2 = k.vfA;
                String str = this.dPI;
                String str2 = this.query;
                k kVar3 = k.vfA;
                String dob = k.dob();
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
                k.a(str, str2, 0, 2, Fg, i2, 1, dob, i3, fH != null ? fH.dIx() : null);
                k kVar4 = k.vfA;
                String str3 = this.dPI;
                String str4 = this.query;
                k kVar5 = k.vfA;
                String dob2 = k.dob();
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
                k.a(str3, str4, 0, 2, Fg, i2, 1, dob2, 2, i3, fH2 != null ? fH2.dIx() : null);
            } else {
                i2++;
            }
        }
        Intent intent = new Intent();
        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(this.gte, intent, 0, 0, false, 124);
        com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.b(this.gte, aqw, intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V");
        AppMethodBeat.o(166812);
    }

    @Override // com.tencent.mm.plugin.finder.search.e.a
    public final void K(long j2, int i2) {
        AppMethodBeat.i(166813);
        k kVar = k.vfA;
        ae(k.Fg(j2), i2, 2);
        AppMethodBeat.o(166813);
    }

    @Override // com.tencent.mm.plugin.finder.search.e.a
    public final void ae(String str, int i2, int i3) {
        AppMethodBeat.i(166814);
        p.h(str, "id");
        if (!this.vtH.containsKey(str)) {
            Log.d(this.TAG, "addExposeItem " + str + ' ' + i2 + ' ' + i3);
            a aVar = new a();
            aVar.setId(str);
            aVar.position = i2;
            aVar.type = i3;
            aVar.timeStamp = System.currentTimeMillis();
            this.vtH.put(str, aVar);
            if (this.vtH.size() % 30 == 0) {
                ov(false);
            }
        }
        int i4 = this.twi ? 2 : 1;
        k kVar = k.vfA;
        String str2 = this.dPI;
        String str3 = this.query;
        k kVar2 = k.vfA;
        String dob = k.dob();
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
        k.a(str2, str3, 0, i3, str, i2, 1, dob, 1, i4, fH != null ? fH.dIx() : null);
        AppMethodBeat.o(166814);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class a extends IListener<hf> {
        final /* synthetic */ FinderMixSearchPresenter vuv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderMixSearchPresenter finderMixSearchPresenter) {
            this.vuv = finderMixSearchPresenter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hf hfVar) {
            AppMethodBeat.i(251310);
            hf hfVar2 = hfVar;
            p.h(hfVar2, "event");
            d.a(0, new C1271a(this, hfVar2));
            AppMethodBeat.o(251310);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter$a$a  reason: collision with other inner class name */
        static final class C1271a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ hf tAo;
            final /* synthetic */ a vuw;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1271a(a aVar, hf hfVar) {
                super(0);
                this.vuw = aVar;
                this.tAo = hfVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                e.b bVar;
                AppMethodBeat.i(251309);
                if (!Util.isNullOrNil(this.tAo.dLI.username)) {
                    Log.d(this.vuw.vuv.TAG, "contactChangelistener " + this.tAo.dLI.username);
                    int i2 = 0;
                    for (Object obj : this.vuw.vuv.uae) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            j.hxH();
                        }
                        String str = this.tAo.dLI.username;
                        FinderContact finderContact = ((bbz) obj).contact;
                        if (!p.j(str, finderContact != null ? finderContact.username : null) || (bVar = this.vuw.vuv.vut) == null) {
                            i2 = i3;
                        } else {
                            bVar.ci(i2 + 1);
                            i2 = i3;
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(251309);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.search.e.a
    public final /* bridge */ /* synthetic */ List cYD() {
        return this.feedList;
    }

    @Override // com.tencent.mm.plugin.finder.search.e.a
    public final void q(BaseFinderFeed baseFinderFeed) {
        long j2;
        AppMethodBeat.i(251312);
        p.h(baseFinderFeed, "feed");
        if (Util.isEqual(baseFinderFeed.feedObject.getFeedObject().username, z.aUg())) {
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            MMActivity mMActivity = this.gte;
            long j3 = baseFinderFeed.feedObject.getFeedObject().id;
            String str = baseFinderFeed.feedObject.getFeedObject().objectNonceId;
            if (str == null) {
                str = "";
            }
            awe awe = baseFinderFeed.feedObject.getFeedObject().liveInfo;
            if (awe == null) {
                awe = new awe();
            }
            com.tencent.mm.plugin.finder.utils.a.a(mMActivity, j3, str, awe, false, null, null, null, null, null, baseFinderFeed.getSessionBuffer(), null, null, 14320);
            AppMethodBeat.o(251312);
            return;
        }
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        MMActivity mMActivity2 = this.gte;
        long j4 = baseFinderFeed.feedObject.getFeedObject().id;
        awe awe2 = baseFinderFeed.feedObject.getFeedObject().liveInfo;
        if (awe2 != null) {
            j2 = awe2.liveId;
        } else {
            j2 = 0;
        }
        String str2 = baseFinderFeed.feedObject.getFeedObject().username;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = baseFinderFeed.feedObject.getFeedObject().objectNonceId;
        if (str3 == null) {
            str3 = "";
        }
        awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
        com.tencent.mm.plugin.finder.utils.a.a(aVar2, mMActivity2, j4, j2, str2, str3, "", "", liveInfo != null ? liveInfo.LGU : 0, baseFinderFeed.getSessionBuffer());
        AppMethodBeat.o(251312);
    }
}
