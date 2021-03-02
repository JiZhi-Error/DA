package com.tencent.mm.plugin.finder.feed.model;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.he;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.data.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.b;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u001bH\u0002J$\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\"\u001a\u00020\u001bH\u0002J(\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020%0*J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\fH\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J\u0012\u00104\u001a\u00020,2\b\u00105\u001a\u0004\u0018\u00010\u0002H\u0016J,\u00106\u001a\u00020,2\f\u00107\u001a\b\u0012\u0004\u0012\u0002080*2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\"\u001a\u00020\u001bH\u0002J=\u00109\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2%\u0010\u0011\u001a!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0012J\u0006\u0010:\u001a\u00020,J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u000203H\u0016JD\u0010=\u001a\u00020,2\u0006\u0010\"\u001a\u00020\u001b2\b\u0010>\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020\b2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\fJ0\u0010D\u001a\u00020,2\u0006\u0010\"\u001a\u00020\u001b2\b\u0010>\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020\bJB\u0010E\u001a\u00020,2\u0006\u0010\"\u001a\u00020\u001b2\b\u0010>\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020\b2\b\u0010F\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R-\u0010\u0011\u001a!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getActivity", "()Landroid/support/v7/app/AppCompatActivity;", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "getData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visiblePosition", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadingList", "Ljava/util/Vector;", "", "scene", "cacheLevel2FirstAuthorComment", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "barrageCommentInfo", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "feedId", "expandTopLevel2Comment", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "respList", "filterComment", "data", "itemList", "", "getFeedByPosToLoad", "", "pos", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "keep", "p0", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "onDetach", "onEventHappen", "ev", "preloadComment", "objectNonceId", "oldVersion", "feedUsername", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullScene", "preloadFirstPageComment", "preloadNextPageComment", "lastBuf", "plugin-finder_release"})
public final class d extends com.tencent.mm.plugin.finder.event.base.d implements b<com.tencent.mm.vending.e.a> {
    final String TAG = "Finder.FinderCommentPreloader";
    private int scene = 2;
    private int tCE;
    private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP = new CopyOnWriteArraySet<>();
    private kotlin.g.a.b<? super Integer, ? extends bo> tUO;
    Vector<Long> tUP = new Vector<>();
    private final AppCompatActivity tUQ;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ z.f tND;
        final /* synthetic */ z.f tNE;
        final /* synthetic */ d tUR;
        final /* synthetic */ long txv;

        a(d dVar, long j2, z.f fVar, z.f fVar2) {
            this.tUR = dVar;
            this.txv = j2;
            this.tND = fVar;
            this.tNE = fVar2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            Object obj2;
            boolean z;
            AppMethodBeat.i(244554);
            c.a aVar = (c.a) obj;
            try {
                if (aVar.errType == 0 && aVar.errCode == 0 && aVar.iLC != null) {
                    com.tencent.mm.bw.b bVar = ((ars) aVar.iLC).lastBuffer;
                    Log.d(this.tUR.TAG, "---refreshData lastBuffer " + (bVar == null ? BuildConfig.COMMAND : MD5Util.getMD5String(bVar.toByteArray())));
                    boolean z2 = ((ars) aVar.iLC).LDf == 1;
                    boolean z3 = ((ars) aVar.iLC).upContinueFlag == 1;
                    Log.d(this.tUR.TAG, "---first fetch, svrCount:".concat(String.valueOf(((ars) aVar.iLC).commentCount)));
                    ArrayList arrayList = new ArrayList();
                    LinkedList<FinderCommentInfo> linkedList = ((ars) aVar.iLC).LDe;
                    p.g(linkedList, "it.resp.commentInfo");
                    ArrayList arrayList2 = arrayList;
                    for (T t : linkedList) {
                        com.tencent.mm.plugin.finder.storage.logic.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                        p.g(t, "commentInfo");
                        arrayList2.add(com.tencent.mm.plugin.finder.storage.logic.a.b(t, this.txv));
                    }
                    d dVar = this.tUR;
                    LinkedList<FinderCommentInfo> linkedList2 = ((ars) aVar.iLC).LDh;
                    p.g(linkedList2, "it.resp.barrageCommentInfo");
                    he b2 = dVar.b(linkedList2, this.txv);
                    d.a(this.tUR, this.tND.SYG, arrayList, this.txv);
                    List d2 = d.d(arrayList, this.txv);
                    for (an anVar : this.tNE.SYG) {
                        Iterator it = d2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            Object next = it.next();
                            s sVar = (s) next;
                            if (sVar.uOf.dyg() == null || !p.j(sVar.uOf.dyg(), anVar.dyg())) {
                                z = false;
                                continue;
                            } else {
                                z = true;
                                continue;
                            }
                            if (z) {
                                obj2 = next;
                                break;
                            }
                        }
                        if (((s) obj2) == null) {
                            Log.d(this.tUR.TAG, "---merge local item: " + anVar.dyg());
                            s sVar2 = new s(anVar);
                            sVar2.uNY = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), anVar.getContent());
                            d2.add(sVar2);
                        }
                    }
                    Log.i(this.tUR.TAG, "---merge respCount:" + ((ars) aVar.iLC).commentCount + ", preSize: " + ((ars) aVar.iLC).LDe.size() + ", afterSize:" + d2.size());
                    if (Util.isNullOrNil(f.vGd.T(this.txv, 0))) {
                        f fVar = f.vGd;
                        long j2 = this.txv;
                        List<s> list = d2;
                        ArrayList arrayList3 = new ArrayList(j.a(list, 10));
                        for (s sVar3 : list) {
                            arrayList3.add(sVar3.uOf);
                        }
                        fVar.a(j2, 0, arrayList3);
                        f.vGd.a(this.txv, 0, 0, bVar, z3, z2, false);
                        Log.i(this.tUR.TAG, "add cache succ, feedId: " + this.txv + ", size:" + d2.size());
                    } else {
                        Log.i(this.tUR.TAG, "---cache exist or list is empty, feedId:" + this.txv + ", list size: " + d2.size());
                    }
                    EventCenter.instance.publish(b2);
                }
                this.tUR.tUP.remove(Long.valueOf(this.txv));
            } catch (Throwable th) {
                this.tUR.tUP.remove(Long.valueOf(this.txv));
                AppMethodBeat.o(244554);
                throw th;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244554);
            return xVar;
        }
    }

    public d(AppCompatActivity appCompatActivity) {
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(244559);
        this.tUQ = appCompatActivity;
        AppMethodBeat.o(244559);
    }

    public final void a(int i2, int i3, kotlin.g.a.b<? super Integer, ? extends bo> bVar) {
        AppMethodBeat.i(244555);
        Log.i(this.TAG, "onAttach");
        this.tUO = bVar;
        this.scene = i2;
        this.tCE = i3;
        AppMethodBeat.o(244555);
    }

    public final void onDetach() {
        AppMethodBeat.i(166033);
        Log.i(this.TAG, "onDetach");
        this.tUO = null;
        Iterator<T> it = this.tLP.iterator();
        while (it.hasNext()) {
            it.next().dead();
        }
        this.tLP.clear();
        this.tUP.clear();
        AppMethodBeat.o(166033);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(166034);
        p.h(bVar, "ev");
        if (bVar instanceof h) {
            int i2 = ((h) bVar).tIy;
            int i3 = ((h) bVar).tIA;
            if (i2 > i3) {
                AppMethodBeat.o(166034);
                return;
            }
            int i4 = ((h) bVar).tID;
            if (i4 <= i3) {
                int i5 = i4;
                while (true) {
                    IM(i5);
                    if (i5 == i3) {
                        break;
                    }
                    i5++;
                }
            }
            int i6 = i4 - 1;
            if (i6 >= i2) {
                while (true) {
                    IM(i6);
                    if (i6 == i2) {
                        break;
                    }
                    i6--;
                }
            }
        }
        AppMethodBeat.o(166034);
    }

    private final void IM(int i2) {
        bo boVar;
        String str;
        int i3;
        boolean z;
        String str2;
        long j2;
        d dVar;
        AppMethodBeat.i(244556);
        kotlin.g.a.b<? super Integer, ? extends bo> bVar = this.tUO;
        if (bVar == null || (boVar = (bo) bVar.invoke(Integer.valueOf(i2))) == null) {
            AppMethodBeat.o(244556);
            return;
        }
        if (boVar instanceof BaseFinderFeed) {
            j2 = ((BaseFinderFeed) boVar).feedObject.getId();
            str = ((BaseFinderFeed) boVar).feedObject.getObjectNonceId();
            i3 = this.tCE;
            z = ((BaseFinderFeed) boVar).feedObject.isOldVersion();
            str2 = ((BaseFinderFeed) boVar).feedObject.getUserName();
            dVar = this;
        } else {
            if (boVar instanceof bm) {
                long j3 = ((bm) boVar).getFeedObject().id;
                str = ((bm) boVar).getFeedObject().objectNonceId;
                i3 = this.tCE;
                z = ((bm) boVar).getFeedObject().secondaryShowFlag != 1;
                str2 = ((bm) boVar).getFeedObject().username;
                if (str2 == null) {
                    str2 = "";
                    j2 = j3;
                    dVar = this;
                } else {
                    j2 = j3;
                    dVar = this;
                }
            }
            AppMethodBeat.o(244556);
        }
        dVar.a(j2, str, i3, z, str2);
        AppMethodBeat.o(244556);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(166035);
        p.h(cVar, "dispatcher");
        p.h(bVar, "event");
        if (!(bVar instanceof h)) {
            AppMethodBeat.o(166035);
            return false;
        } else if (((h) bVar).type == 0 || ((h) bVar).type == 5 || ((h) bVar).type == 4) {
            AppMethodBeat.o(166035);
            return true;
        } else {
            AppMethodBeat.o(166035);
            return false;
        }
    }

    public final void a(long j2, String str, int i2, boolean z, String str2) {
        AppMethodBeat.i(244557);
        p.h(str2, "feedUsername");
        com.tencent.mm.kernel.c.a af = g.af(ad.class);
        p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af).dxX()) {
            Log.i(this.TAG, "***preloadFirstPageComment disable for 青少年模式");
            AppMethodBeat.o(244557);
            return;
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drQ()) {
            Log.i(this.TAG, "***preloadFirstPageComment disable");
            AppMethodBeat.o(244557);
        } else if (j2 == 0) {
            Log.i(this.TAG, "***preloadFirstPageComment feedId is 0");
            AppMethodBeat.o(244557);
        } else if (!Util.isNullOrNil(f.vGd.T(j2, 0)) && !Util.isNullOrNil(f.vGd.FG(j2))) {
            Log.i(this.TAG, "***preloadFirstPageComment has cache");
            AppMethodBeat.o(244557);
        } else if (this.tUP.contains(Long.valueOf(j2))) {
            Log.i(this.TAG, "***preloadFirstPageComment is loading");
            AppMethodBeat.o(244557);
        } else {
            z.f fVar = new z.f();
            fVar.SYG = (T) v.SXr;
            z.f fVar2 = new z.f();
            fVar2.SYG = (T) v.SXr;
            fVar.SYG = (T) ((PluginFinder) g.ah(PluginFinder.class)).getFinderActionStorage().Ft(j2);
            if (!z) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : fVar.SYG) {
                    if (((an) obj).field_actionInfo.tuf != 0) {
                        arrayList.add(obj);
                    }
                }
                fVar2.SYG = (T) arrayList;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : fVar.SYG) {
                    if (((an) obj2).field_actionInfo.tuf == 0) {
                        arrayList2.add(obj2);
                    }
                }
                fVar.SYG = (T) arrayList2;
            }
            this.tUP.add(Long.valueOf(j2));
            int i3 = this.scene;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tUQ);
            new af(j2, str, i2, i3, str2, false, null, null, 0, null, false, false, null, fH != null ? fH.dIx() : null, 3, 8160).aYI().h(new a(this, j2, fVar2, fVar)).a(this);
            AppMethodBeat.o(244557);
        }
    }

    /* access modifiers changed from: package-private */
    public final he b(LinkedList<FinderCommentInfo> linkedList, long j2) {
        AppMethodBeat.i(244558);
        ArrayList arrayList = new ArrayList();
        LinkedList<FinderCommentInfo> linkedList2 = linkedList;
        ArrayList arrayList2 = new ArrayList(j.a(linkedList2, 10));
        Iterator<T> it = linkedList2.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.finder.storage.logic.a aVar = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
            arrayList2.add(com.tencent.mm.plugin.finder.storage.logic.a.b(it.next(), j2));
        }
        arrayList.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        for (Object obj : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            s sVar = (s) obj;
            arrayList3.add(sVar);
            if (sVar.uOf.field_actionInfo.tuf == 0 && sVar.uOf.dyb().levelTwoComment.size() > 0 && (i2 >= arrayList.size() - 1 || ((s) arrayList.get(i2 + 1)).uOf.field_actionInfo.tuf == 0)) {
                int size = sVar.uOf.dyb().levelTwoComment.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    FinderCommentInfo remove = sVar.uOf.dyb().levelTwoComment.remove();
                    com.tencent.mm.plugin.finder.storage.logic.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                    p.g(remove, "level2CommentInfo");
                    s b2 = com.tencent.mm.plugin.finder.storage.logic.a.b(remove, j2, sVar.lT());
                    if (b2.uOf.dyj()) {
                        b2.uOe = true;
                        arrayList3.add(b2);
                        i2 = i3;
                        break;
                    }
                    i4++;
                }
            }
            i2 = i3;
        }
        he heVar = new he();
        heVar.dLG.feedId = j2;
        if (!Util.isNullOrNil(arrayList3)) {
            f fVar = f.vGd;
            ArrayList<s> arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(j.a(arrayList4, 10));
            for (s sVar2 : arrayList4) {
                arrayList5.add(sVar2.uOf);
            }
            ArrayList arrayList6 = arrayList5;
            p.h(arrayList6, "comments");
            synchronized (fVar) {
                try {
                    synchronized (f.vGd) {
                        try {
                            f.vGc.remove(new f.a(j2, 0));
                        } finally {
                            AppMethodBeat.o(244558);
                        }
                    }
                    f.vGc.put(new f.a(j2, 0), arrayList6);
                } finally {
                    AppMethodBeat.o(244558);
                }
            }
            Log.i(this.TAG, "add bullet subtitle cache succ, feedId: " + j2 + ", size:" + arrayList.size());
            heVar.dLG.dLH = false;
        } else {
            heVar.dLG.dLH = true;
        }
        return heVar;
    }

    @Override // com.tencent.mm.vending.e.b
    public final void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(166036);
        this.tLP.add(aVar);
        AppMethodBeat.o(166036);
    }

    public static final /* synthetic */ void a(d dVar, List list, List list2, long j2) {
        int i2;
        int i3;
        boolean z;
        AppMethodBeat.i(244560);
        ArrayList arrayList = new ArrayList();
        ArrayList<FinderCommentInfo> arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FinderCommentInfo finderCommentInfo = ((an) it.next()).field_actionInfo.LAn;
            if (finderCommentInfo != null) {
                int i4 = 0;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    i3 = i4;
                    if (!it2.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    if (((FinderCommentInfo) it2.next()).commentId == finderCommentInfo.commentId) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                    i4 = i3 + 1;
                }
                if (i3 < 0 && finderCommentInfo.commentId != 0) {
                    p.g(finderCommentInfo, "rootComment");
                    arrayList2.add(finderCommentInfo);
                }
            }
        }
        for (FinderCommentInfo finderCommentInfo2 : arrayList2) {
            int i5 = 0;
            Iterator it3 = list2.iterator();
            while (true) {
                i2 = i5;
                if (!it3.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (((s) it3.next()).uOf.dyb().commentId == finderCommentInfo2.commentId) {
                    break;
                }
                i5 = i2 + 1;
            }
            if (i2 >= 0) {
                list2.remove(i2);
                Log.i(dVar.TAG, "mergeLocalLevel2Comments, remove level1ExistIndex:" + i2 + ", id:" + finderCommentInfo2.commentId);
            }
            com.tencent.mm.plugin.finder.storage.logic.a aVar = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
            arrayList.add(com.tencent.mm.plugin.finder.storage.logic.a.b(finderCommentInfo2, j2));
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                an anVar = (an) it4.next();
                if (anVar.field_actionInfo.tuf == finderCommentInfo2.commentId) {
                    s sVar = new s(anVar);
                    sVar.uNY = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), anVar.getContent());
                    arrayList.add(sVar);
                }
            }
        }
        if (arrayList.size() > 0) {
            Log.i(dVar.TAG, "mergeLocalLevel2Comments, total local size: " + arrayList.size() + ", level1 size:" + arrayList2.size());
        }
        list2.addAll(arrayList);
        AppMethodBeat.o(244560);
    }

    public static final /* synthetic */ List d(List list, long j2) {
        AppMethodBeat.i(244561);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            s sVar = (s) obj;
            arrayList.add(sVar);
            if (sVar.uOf.field_actionInfo.tuf == 0 && sVar.uOf.dyb().levelTwoComment.size() > 0 && (i2 >= list.size() - 1 || ((s) list.get(i2 + 1)).uOf.field_actionInfo.tuf == 0)) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dso().value().intValue() == 1) {
                    int size = sVar.uOf.dyb().levelTwoComment.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        FinderCommentInfo remove = sVar.uOf.dyb().levelTwoComment.remove();
                        com.tencent.mm.plugin.finder.storage.logic.a aVar = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
                        p.g(remove, "level2Comment");
                        s b2 = com.tencent.mm.plugin.finder.storage.logic.a.b(remove, j2, sVar.lT());
                        b2.uOe = true;
                        arrayList.add(b2);
                    }
                    sVar.uOd -= size;
                    if (sVar.uOd < 0) {
                        sVar.uOd = 0;
                    }
                }
            }
            i2 = i3;
        }
        AppMethodBeat.o(244561);
        return arrayList;
    }
}
