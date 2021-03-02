package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0012\u0018\u0000 12\u00020\u0001:\u00011B%\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\"\u001a\u00020\u001b2\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020%J,\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\n2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0006\u0010/\u001a\u00020%J\u0006\u00100\u001a\u00020%R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "viewCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "(Ljava/util/ArrayList;Lcom/tencent/mm/view/IViewActionCallback;)V", "TAG", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getDataList", "()Ljava/util/ArrayList;", "feedUpdateListener", "com/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1;", "lastScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "getLastScene", "()Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "setLastScene", "(Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;)V", "requesting", "", "getRequesting", "()Z", "setRequesting", "(Z)V", "getViewCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "checkCleanRefresh", "responseList", "clearAll", "", "initData", "loadMore", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "release", "Companion", "plugin-finder_release"})
public final class g implements i {
    public static com.tencent.mm.bw.b lastBuffer;
    public static ArrayList<bo> tXm = new ArrayList<>();
    public static final a tXn = new a((byte) 0);
    public static boolean tuG = true;
    public final String TAG = "Finder.FinderSnsHeaderLoader";
    public final ArrayList<bo> kgc;
    public boolean tUq;
    public ch tXj;
    public final b tXk;
    public final j tXl;
    public final bbn ttO;

    public g(ArrayList<bo> arrayList, j jVar) {
        p.h(arrayList, "dataList");
        p.h(jVar, "viewCallback");
        AppMethodBeat.i(244863);
        this.kgc = arrayList;
        this.tXl = jVar;
        bbn bbn = new bbn();
        bbn.tCE = 61;
        this.ttO = bbn;
        this.tXk = new b(this);
        AppMethodBeat.o(244863);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$Companion;", "", "()V", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "dataCache", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getDataCache", "()Ljava/util/ArrayList;", "setDataCache", "(Ljava/util/ArrayList;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(244864);
        AppMethodBeat.o(244864);
    }

    public final void release() {
        AppMethodBeat.i(244861);
        com.tencent.mm.kernel.g.azz().b(6847, this);
        this.tXk.dead();
        AppMethodBeat.o(244861);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        awe awe;
        boolean z2;
        AppMethodBeat.i(244862);
        if (p.j(qVar, this.tXj) && qVar != null && (qVar instanceof ch)) {
            if (i2 == 0 && i3 == 0) {
                if (((ch) qVar).twn.size() > 0) {
                    if (((ch) qVar).pullType != 2) {
                        ArrayList<bo> arrayList = this.kgc;
                        ArrayList<bo> arrayList2 = ((ch) qVar).twn;
                        if (arrayList.size() == arrayList2.size()) {
                            ArrayList<Number> arrayList3 = new ArrayList();
                            int i4 = 0;
                            int size = arrayList.size();
                            if (size >= 0) {
                                while (true) {
                                    bo boVar = (bo) kotlin.a.j.L(arrayList, i4);
                                    Long valueOf = boVar != null ? Long.valueOf(boVar.lT()) : null;
                                    bo boVar2 = (bo) kotlin.a.j.L(arrayList2, i4);
                                    if ((!p.j(valueOf, boVar2 != null ? Long.valueOf(boVar2.lT()) : null)) || kotlin.a.j.L(arrayList, i4) == null) {
                                        z2 = true;
                                    } else {
                                        arrayList.set(i4, arrayList2.get(i4));
                                        arrayList3.add(Integer.valueOf(i4));
                                        if (i4 == size) {
                                            break;
                                        }
                                        i4++;
                                    }
                                }
                                z2 = true;
                            }
                            for (Number number : arrayList3) {
                                this.tXl.onItemRangeChanged(number.intValue(), 1, 1);
                            }
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.kgc.clear();
                            this.kgc.addAll(((ch) qVar).twn);
                            this.tXl.onChanged();
                        }
                    } else {
                        int size2 = this.kgc.size();
                        ArrayList arrayList4 = new ArrayList();
                        for (T t : ((ch) qVar).twn) {
                            if (t instanceof y) {
                                awe awe2 = t.uOo.liveInfo;
                                long j2 = awe2 != null ? awe2.liveId : 0;
                                int i5 = 0;
                                Iterator<bo> it = this.kgc.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        i5 = -1;
                                        break;
                                    }
                                    bo next = it.next();
                                    if ((next instanceof y) && (awe = ((y) next).uOo.liveInfo) != null && awe.liveId == j2) {
                                        break;
                                    }
                                    i5++;
                                }
                                if (i5 >= 0) {
                                    this.kgc.set(i5, t);
                                    this.tXl.onItemRangeChanged(i5, 1, 1);
                                    Log.i(this.TAG, "loadmore, exist, ".concat(String.valueOf(j2)));
                                } else {
                                    arrayList4.add(t);
                                }
                            } else {
                                arrayList4.add(t);
                            }
                        }
                        Log.i(this.TAG, "loadmore, append size:" + arrayList4.size());
                        if (arrayList4.size() > 0) {
                            this.kgc.addAll(arrayList4);
                            this.tXl.onItemRangeInserted(size2, arrayList4.size());
                        }
                    }
                } else if (((ch) qVar).pullType != 2) {
                    this.kgc.clear();
                    this.tXl.onChanged();
                }
                com.tencent.mm.bw.a aYK = ((ch) qVar).rr.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
                    AppMethodBeat.o(244862);
                    throw tVar;
                }
                lastBuffer = ((bcp) aYK).lastBuffer;
                com.tencent.mm.bw.a aYK2 = ((ch) qVar).rr.aYK();
                if (aYK2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
                    AppMethodBeat.o(244862);
                    throw tVar2;
                }
                if (((bcp) aYK2).continueFlag != 0) {
                    z = true;
                } else {
                    z = false;
                }
                tuG = z;
                Log.i(this.TAG, "onSceneEnd, pullType:" + ((ch) qVar).pullType + ", curSize:" + this.kgc.size() + " continueFlag:" + tuG);
                k kVar = k.vkd;
                k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, "61", c.EVENT_ON_REFRESH);
            }
            this.tUq = false;
        }
        AppMethodBeat.o(244862);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b extends IListener<hn> {
        final /* synthetic */ g tXo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(g gVar) {
            this.tXo = gVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hn hnVar) {
            int i2;
            awe awe;
            AppMethodBeat.i(244860);
            hn hnVar2 = hnVar;
            if (hnVar2 != null && hnVar2.dLW.id != 0 && hnVar2.dLW.dLY == 1 && hnVar2.dLW.type == 8) {
                Iterator<bo> it = this.tXo.kgc.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    bo next = it.next();
                    if ((next instanceof y) && (awe = ((y) next).uOo.liveInfo) != null && awe.liveId == hnVar2.dLW.id) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 >= 0) {
                    bo boVar = (bo) kotlin.a.j.L(this.tXo.kgc, i2);
                    if (boVar instanceof y) {
                        String str = this.tXo.TAG;
                        StringBuilder sb = new StringBuilder("end liveId:");
                        awe awe2 = ((y) boVar).uOo.liveInfo;
                        Log.i(str, sb.append(awe2 != null ? Long.valueOf(awe2.liveId) : null).toString());
                        awe awe3 = ((y) boVar).uOo.liveInfo;
                        if (awe3 != null) {
                            awe3.liveStatus = 2;
                        }
                        this.tXo.tXl.onItemRangeChanged(i2, 1, 1);
                    }
                }
            }
            AppMethodBeat.o(244860);
            return false;
        }
    }
}
