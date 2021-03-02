package com.tencent.mm.plugin.finder.report.live;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.live.h;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.search.f;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J@\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0002J(\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0002J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006H\u0002J \u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006H\u0002J2\u0010.\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020*H\u0002J \u00101\u001a\u00020*2\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u000603j\b\u0012\u0004\u0012\u00020\u0006`4H\u0002J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020*H\u0002J \u00107\u001a\u00020*2\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u000603j\b\u0012\u0004\u0012\u00020\u0006`4H\u0002J,\u00108\u001a\u00020*2\n\u00109\u001a\u00060\tR\u00020\n2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006H\u0002J,\u00108\u001a\u00020*2\n\u00109\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006H\u0002J6\u00108\u001a\u00020*2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010;\u001a\u00020<H\u0002J,\u0010=\u001a\u00020*2\n\u00109\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010:\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0018\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@2\u0006\u0010%\u001a\u00020&H\u0002J(\u0010A\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010B\u001a\u00020C2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\b\u0012\u00060\tR\u00020\n\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0013`\u0014X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0013`\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\u0012j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c`\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/HellFeedExposure;", "", "mCallback", "Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;", "(Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;)V", "TAG", "", "mAdapterMixSearchRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "mAdapterProfileRef", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mAdapterRef", "getMCallback", "()Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;", "mFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed;", "Lkotlin/collections/HashMap;", "mFeedHorizontalCache", "mHorAdapterRef", "mHorLayoutRef", "Landroid/support/v7/widget/LinearLayoutManager;", "mLayoutRef", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "mMixSearchItemCache", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveMixSearchItem;", "_doOnScroll", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "rvFeeds", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "pos", "", "_doOnScrollHorizontal", "rvFeed", "doRunOnScroll", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "doRunOnScrollHorizontal", "onAppearCallback", "userName", "onDestroy", "onDisappearCallback", "curScrrenFeedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onFeedAllDisappear", "onMixSearchAllDisappear", "onMixSearchDisappearCallback", "onScroll", "adapter", "layoutManager", "fromProfile", "", "onScrollHorizontal", "onScrollMixSearch", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "run", "event", "Lcom/tencent/mm/plugin/finder/report/live/HELL_SCROLL_EVENT;", "plugin-finder_release"})
public final class d {
    final String TAG = "HABBYGE-MALI.HellFeedExposure";
    WeakReference<StaggeredGridLayoutManager> vjn;
    WeakReference<WxRecyclerAdapter<?>> vjo;
    WeakReference<f.b> vjp;
    WeakReference<WxRecyclerAdapter<bo>> vjq;
    WeakReference<LinearLayoutManager> vjr;
    WeakReference<WxRecyclerAdapter<?>> vjs;
    private final HashMap<String, h> vjt = new HashMap<>();
    private final HashMap<String, j> vju = new HashMap<>();
    final HashMap<String, h> vjv = new HashMap<>();
    private final r vjw;

    public d(r rVar) {
        AppMethodBeat.i(250916);
        this.vjw = rVar;
        AppMethodBeat.o(250916);
    }

    /* access modifiers changed from: package-private */
    public final void a(WxRecyclerAdapter<?> wxRecyclerAdapter, LinearLayoutManager linearLayoutManager, s.p pVar, String str) {
        int i2;
        int i3;
        AppMethodBeat.i(250906);
        int ks = linearLayoutManager.ks();
        int ku = linearLayoutManager.ku();
        if (ks != 0) {
            i2 = ks - 1;
            i3 = ku - 1;
        } else if (ku >= 2) {
            i2 = ks;
            i3 = ku - 1;
        } else {
            i2 = ks;
            i3 = ku;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<D> arrayList2 = wxRecyclerAdapter.data;
        if ((!arrayList2.isEmpty()) && i2 <= i3) {
            int i4 = i2;
            while (true) {
                if (arrayList2.size() > i4) {
                    D d2 = arrayList2.get(i4);
                    if (!(d2 instanceof bo)) {
                        d2 = null;
                    }
                    bo boVar = (bo) d2;
                    if (boVar != null) {
                        long lT = boVar.lT();
                        String zs = b.zs(lT);
                        p.g(zs, "HellhoundUtil.long2UnsignedString(feedIdL)");
                        if (!this.vjv.containsKey(zs)) {
                            h.a aVar = h.vjR;
                            com.tencent.mm.vending.j.d<Long, Integer, Boolean> a2 = h.a.a(boVar);
                            String str2 = "";
                            if (boVar instanceof BaseFinderFeed) {
                                str2 = ((BaseFinderFeed) boVar).feedObject.getUserName();
                            }
                            Long hdM = a2.hdM();
                            p.g(hdM, "liveIdTuple3.`$1`()");
                            long longValue = hdM.longValue();
                            Integer hdN = a2.hdN();
                            p.g(hdN, "liveIdTuple3.`$2`()");
                            int intValue = hdN.intValue();
                            h.a aVar2 = h.vjR;
                            h hVar = new h(boVar, str2, i4, zs, lT, longValue, pVar, str, intValue, h.a.b(boVar), h.b.UNDEFINE, true, false, 12288, (byte) 0);
                            this.vjv.put(zs, hVar);
                            this.vjt.put(zs, hVar);
                            r rVar = this.vjw;
                            if (rVar != null) {
                                rVar.a(hVar, false);
                            }
                        }
                        arrayList.add(zs);
                    }
                }
                if (i4 == i3) {
                    break;
                }
                i4++;
            }
        }
        Iterator<Map.Entry<String, h>> it = this.vjv.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, h> next = it.next();
            p.g(next, "iterator.next()");
            Map.Entry<String, h> entry = next;
            if (!arrayList.contains(entry.getKey())) {
                it.remove();
                this.vjt.remove(entry.getKey());
                r rVar2 = this.vjw;
                if (rVar2 != null) {
                    h value = entry.getValue();
                    p.g(value, "hellFeedPair.value");
                    rVar2.a(value);
                }
            }
        }
        arrayList.clear();
        AppMethodBeat.o(250906);
    }

    /* access modifiers changed from: package-private */
    public final void a(WxRecyclerAdapter<bo> wxRecyclerAdapter, StaggeredGridLayoutManager staggeredGridLayoutManager, s.p pVar, String str) {
        boolean z;
        int i2;
        AppMethodBeat.i(250907);
        int[] iArr = new int[staggeredGridLayoutManager.ki()];
        staggeredGridLayoutManager.n(iArr);
        int[] iArr2 = new int[staggeredGridLayoutManager.ki()];
        staggeredGridLayoutManager.o(iArr2);
        int size = wxRecyclerAdapter.RqM.size();
        int min = Math.min(iArr[0], iArr[1]);
        int max = Math.max(iArr2[0], iArr2[1]);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<D> arrayList2 = wxRecyclerAdapter.data;
        if (!arrayList2.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z && min <= max) {
            while (true) {
                if (min - size >= 0) {
                    i2 = min - size;
                } else {
                    i2 = min;
                }
                if (i2 < arrayList2.size() && i2 >= 0) {
                    bo boVar = (bo) arrayList2.get(i2);
                    arrayList.add(a(boVar, boVar instanceof BaseFinderFeed ? ((BaseFinderFeed) boVar).feedObject.getUserName() : "", min, pVar, str));
                }
                if (min == max) {
                    break;
                }
                min++;
            }
        }
        ai(arrayList);
        arrayList.clear();
        AppMethodBeat.o(250907);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005b, code lost:
        if ((!r11.isEmpty()) != false) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.finder.search.f.b r17, android.support.v7.widget.StaggeredGridLayoutManager r18, com.tencent.mm.plugin.finder.report.live.s.p r19, java.lang.String r20) {
        /*
        // Method dump skipped, instructions count: 294
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.d.a(com.tencent.mm.plugin.finder.search.f$b, android.support.v7.widget.StaggeredGridLayoutManager, com.tencent.mm.plugin.finder.report.live.s$p, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final void b(WxRecyclerAdapter<?> wxRecyclerAdapter, StaggeredGridLayoutManager staggeredGridLayoutManager, s.p pVar, String str) {
        int i2;
        D d2;
        String str2;
        s.p pVar2;
        AppMethodBeat.i(250909);
        int[] iArr = new int[staggeredGridLayoutManager.ki()];
        staggeredGridLayoutManager.n(iArr);
        int[] iArr2 = new int[staggeredGridLayoutManager.ki()];
        staggeredGridLayoutManager.o(iArr2);
        int size = wxRecyclerAdapter.RqM.size();
        int min = Math.min(iArr[0], iArr[1]);
        int max = Math.max(iArr2[0], iArr2[1]);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<D> arrayList3 = wxRecyclerAdapter.data;
        if ((!arrayList3.isEmpty()) && min <= max) {
            while (true) {
                if (staggeredGridLayoutManager.findViewByPosition(min) != null && arrayList3.size() > (i2 = size + min)) {
                    D d3 = arrayList3.get(i2);
                    if (d3 instanceof x) {
                        c<List<String>, List<String>> a2 = a((x) d3, pVar, str, min);
                        arrayList.addAll(a2.hdM());
                        arrayList2.addAll(a2.hdN());
                    } else if (d3 instanceof BaseFinderFeed) {
                        String userName = ((BaseFinderFeed) d3).feedObject.getUserName();
                        if (p.j(str, s.j.COMMENT_SCENE_LBS_TOP_LIVE_CARD.scene)) {
                            pVar2 = s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD;
                            str2 = "15";
                        } else {
                            str2 = str;
                            pVar2 = pVar;
                        }
                        arrayList.add(a((bo) d3, userName, min, pVar2, str2));
                    } else {
                        if (!(d3 instanceof bo)) {
                            d2 = null;
                        } else {
                            d2 = d3;
                        }
                        if (((bo) d2) != null) {
                            arrayList.add(a((bo) d3, "", min, pVar, str));
                        }
                    }
                }
                if (min == max) {
                    break;
                }
                min++;
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            this.vjt.remove((String) it.next());
        }
        ai(arrayList);
        arrayList.clear();
        arrayList2.clear();
        AppMethodBeat.o(250909);
    }

    private final c<List<String>, List<String>> a(x xVar, s.p pVar, String str, int i2) {
        AppMethodBeat.i(250910);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<y> it = xVar.dtS.iterator();
        while (it.hasNext()) {
            y next = it.next();
            long j2 = next.uOo.id;
            String zs = b.zs(j2);
            p.g(zs, "HellhoundUtil.long2UnsignedString(feedIdL)");
            if (this.vjv.containsKey(zs)) {
                if (!this.vjt.containsKey(zs)) {
                    h.a aVar = h.vjR;
                    p.g(next, "subRvFeed");
                    com.tencent.mm.vending.j.d<Long, Integer, Boolean> a2 = h.a.a(next);
                    y yVar = next;
                    String str2 = next.uOo.username;
                    if (str2 == null) {
                        str2 = "";
                    }
                    Long hdM = a2.hdM();
                    p.g(hdM, "liveIdTuple3.`$1`()");
                    long longValue = hdM.longValue();
                    Integer hdN = a2.hdN();
                    p.g(hdN, "liveIdTuple3.`$2`()");
                    int intValue = hdN.intValue();
                    h.a aVar2 = h.vjR;
                    String b2 = h.a.b(next);
                    h.b bVar = h.b.UNDEFINE;
                    Boolean hdO = a2.hdO();
                    p.g(hdO, "liveIdTuple3.`$3`()");
                    h hVar = new h(yVar, str2, i2, zs, j2, longValue, pVar, str, intValue, b2, bVar, hdO.booleanValue(), false, 12288, (byte) 0);
                    this.vjt.put(zs, hVar);
                    r rVar = this.vjw;
                    if (rVar != null) {
                        rVar.a(hVar, false);
                    }
                }
                arrayList.add(zs);
            } else {
                arrayList2.add(zs);
            }
        }
        c<List<String>, List<String>> Q = a.Q(arrayList, arrayList2);
        p.g(Q, "Tuple.make(retIdList, needDelList)");
        AppMethodBeat.o(250910);
        return Q;
    }

    private final String a(bo boVar, String str, int i2, s.p pVar, String str2) {
        AppMethodBeat.i(250911);
        long lT = boVar.lT();
        String zs = b.zs(lT);
        p.g(zs, "HellhoundUtil.long2UnsignedString(feedIdL)");
        if (!this.vjt.containsKey(zs)) {
            h.a aVar = h.vjR;
            com.tencent.mm.vending.j.d<Long, Integer, Boolean> a2 = h.a.a(boVar);
            Long hdM = a2.hdM();
            p.g(hdM, "tuple3.`$1`()");
            long longValue = hdM.longValue();
            Integer hdN = a2.hdN();
            p.g(hdN, "tuple3.`$2`()");
            int intValue = hdN.intValue();
            h.a aVar2 = h.vjR;
            String b2 = h.a.b(boVar);
            h.b bVar = h.b.UNDEFINE;
            Boolean hdO = a2.hdO();
            p.g(hdO, "tuple3.`$3`()");
            h hVar = new h(boVar, str, i2, zs, lT, longValue, pVar, str2, intValue, b2, bVar, false, hdO.booleanValue(), 8192, (byte) 0);
            this.vjt.put(zs, hVar);
            r rVar = this.vjw;
            if (rVar != null) {
                rVar.a(hVar, false);
            }
        }
        AppMethodBeat.o(250911);
        return zs;
    }

    /* access modifiers changed from: package-private */
    public final void dpa() {
        AppMethodBeat.i(250912);
        Iterator<Map.Entry<String, h>> it = this.vjt.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, h> next = it.next();
            p.g(next, "iterator.next()");
            Map.Entry<String, h> entry = next;
            it.remove();
            r rVar = this.vjw;
            if (rVar != null) {
                h value = entry.getValue();
                p.g(value, "hellFeedPair.value");
                rVar.a(value);
            }
        }
        AppMethodBeat.o(250912);
    }

    /* access modifiers changed from: package-private */
    public final void dpb() {
        AppMethodBeat.i(250913);
        Iterator<Map.Entry<String, j>> it = this.vju.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, j> next = it.next();
            p.g(next, "iterator.next()");
            Map.Entry<String, j> entry = next;
            it.remove();
            r rVar = this.vjw;
            if (rVar != null) {
                j value = entry.getValue();
                p.g(value, "hellFeedPair.value");
                rVar.b(value);
            }
        }
        AppMethodBeat.o(250913);
    }

    private final void ai(ArrayList<String> arrayList) {
        AppMethodBeat.i(250914);
        Iterator<Map.Entry<String, h>> it = this.vjt.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, h> next = it.next();
            p.g(next, "iterator.next()");
            Map.Entry<String, h> entry = next;
            if (!arrayList.contains(entry.getKey())) {
                it.remove();
                r rVar = this.vjw;
                if (rVar != null) {
                    h value = entry.getValue();
                    p.g(value, "hellFeedPair.value");
                    rVar.a(value);
                }
            }
        }
        AppMethodBeat.o(250914);
    }

    private final void aj(ArrayList<String> arrayList) {
        AppMethodBeat.i(250915);
        Iterator<Map.Entry<String, j>> it = this.vju.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, j> next = it.next();
            p.g(next, "iterator.next()");
            Map.Entry<String, j> entry = next;
            if (!arrayList.contains(entry.getKey())) {
                it.remove();
                r rVar = this.vjw;
                if (rVar != null) {
                    j value = entry.getValue();
                    p.g(value, "hellFeedPair.value");
                    rVar.b(value);
                }
            }
        }
        arrayList.clear();
        AppMethodBeat.o(250915);
    }
}
