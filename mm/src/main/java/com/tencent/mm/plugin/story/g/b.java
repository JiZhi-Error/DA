package com.tencent.mm.plugin.story.g;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.f.a.m;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0016J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\u001e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0015H\u0002J \u0010-\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J*\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u00042\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0016J*\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u00152\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u00109\u001a\u00020\u0015H\u0002J\u0010\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u0015H\u0002J\b\u0010<\u001a\u00020\u001fH\u0002J*\u0010=\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u00152\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J \u0010A\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u0015H\u0016J\b\u0010C\u001a\u00020\u001fH\u0002J\b\u0010D\u001a\u00020\u001fH\u0002J\b\u0010E\u001a\u00020\u001fH\u0002R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R,\u0010\u001c\u001a \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/FavStoryPresenter;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", ch.COL_USERNAME, "", "dateList", "", "galleryUserCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "queryCondition", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;I)V", "TAG", "dateGalleryMap", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "dateState", "Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "deleteColumnIndex", "deleteRowIndex", "enableVisitor", "", "galleryState", "isSelf", "loadingIndexQueue", "Ljava/util/LinkedList;", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "cancelDeleteItem", "row", "column", "deleteItem", "destroy", "initLoad", "notifyDateUpdate", "userIndex", "userGalleryItems", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onMsgListState", FirebaseAnalytics.b.INDEX, "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "selectedDate", "success", "onSetPrivacyCallback", "isPrivacy", "preloadForUser", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedCommentRead", "setSelectedRead", "setSelectedVisitRead", "plugin-story_release"})
public final class b extends f implements com.tencent.mm.ak.i {
    private final int FkI;
    private final List<String> FoJ;
    private final r<Long, Boolean, String, String, x> FpA;
    private final ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> FqZ;
    private final ArrayList<e> Fra;
    private final LinkedList<Integer> Frb;
    private int Frc;
    private int Frd;
    private int Fre;
    private int Frf;
    private int Frg;
    private boolean Frh;
    private final c Fri;
    private final String TAG;
    private boolean dJM;
    private final String username;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    static final class l extends q implements r<Long, Boolean, String, String, x> {
        final /* synthetic */ b Frj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(b bVar) {
            super(4);
            this.Frj = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Long l, Boolean bool, String str, String str2) {
            final int i2;
            boolean z;
            boolean z2;
            AppMethodBeat.i(119173);
            long longValue = l.longValue();
            final boolean booleanValue = bool.booleanValue();
            p.h(str, "fromUser");
            p.h(str2, "storyOwner");
            Iterator it = this.Frj.FqZ.iterator();
            final int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                }
                ArrayList arrayList = (ArrayList) it.next();
                if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (((com.tencent.mm.plugin.story.f.d.h) it2.next()).edx == longValue) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    break;
                }
                i3++;
            }
            if (i3 != -1) {
                Object obj = this.Frj.FqZ.get(i3);
                p.g(obj, "dateGalleryMap[rowIndex]");
                final ArrayList arrayList2 = (ArrayList) obj;
                int i4 = 0;
                Iterator it3 = arrayList2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (((com.tencent.mm.plugin.story.f.d.h) it3.next()).edx == longValue) {
                        i2 = i4;
                        break;
                    }
                    i4++;
                }
                if (i2 != -1) {
                    j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(longValue);
                    if (KA != null) {
                        h.a aVar = com.tencent.mm.plugin.story.f.d.h.FoY;
                        final com.tencent.mm.plugin.story.f.d.h b2 = h.a.b(KA);
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.story.g.b.l.AnonymousClass1 */
                            final /* synthetic */ l Frx;

                            {
                                this.Frx = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(119172);
                                if (booleanValue) {
                                    Log.i(this.Frx.Frj.TAG, "commentChanged, will update row:" + i3 + " col:" + i2);
                                    arrayList2.set(i2, b2);
                                    this.Frx.Frj.Fri.u(i3, arrayList2);
                                    this.Frx.Frj.Fri.aA(i3, i2, 1);
                                    this.Frx.Frj.Fri.fpA();
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(119172);
                                return xVar;
                            }
                        });
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119173);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(b bVar, int i2, List list) {
        AppMethodBeat.i(119191);
        bVar.t(i2, list);
        AppMethodBeat.o(119191);
    }

    public static final /* synthetic */ void i(b bVar) {
        AppMethodBeat.i(119192);
        bVar.vP(true);
        AppMethodBeat.o(119192);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, List list, c cVar) {
        this(str, list, cVar, d.fpB());
        d dVar = d.FrG;
        AppMethodBeat.i(119190);
        AppMethodBeat.o(119190);
    }

    private b(String str, List<String> list, c cVar, int i2) {
        p.h(str, ch.COL_USERNAME);
        p.h(list, "dateList");
        p.h(cVar, "galleryUserCallback");
        AppMethodBeat.i(119189);
        this.username = str;
        this.FoJ = list;
        this.Fri = cVar;
        this.FkI = i2;
        this.TAG = "MicroMsg.FavStoryPresenter";
        this.FqZ = new ArrayList<>();
        this.Fra = new ArrayList<>();
        this.Frb = new LinkedList<>();
        this.Frc = -1;
        this.Frd = -1;
        this.Fre = -1;
        this.Frf = -1;
        this.FpA = new l(this);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        this.dJM = Util.isEqual(j.b.fau(), this.username);
        this.Fri.aaL(this.FoJ.size());
        for (T t : this.FoJ) {
            Log.i(this.TAG, "LogStory: ".concat(String.valueOf(t)));
            this.FqZ.add(new ArrayList<>());
            this.Fra.add(new e(t));
        }
        if (this.dJM) {
            com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().a(764, this);
        }
        com.tencent.mm.plugin.story.f.b.b bVar2 = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.f(this.FpA);
        this.Frh = com.tencent.mm.plugin.story.c.a.e.Fln.fng();
        AppMethodBeat.o(119189);
    }

    private final void vP(boolean z) {
        AppMethodBeat.i(119174);
        com.tencent.mm.ac.d.h(new d(this, z));
        AppMethodBeat.o(119174);
    }

    private final void a(boolean z, ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList, boolean z2) {
        AppMethodBeat.i(119175);
        if (!z && arrayList != null) {
            int indexOf = this.FqZ.indexOf(arrayList);
            this.FqZ.remove(arrayList);
            com.tencent.mm.ac.d.h(new f(indexOf, this));
        }
        com.tencent.mm.ac.d.h(new g(this, z, z2));
        AppMethodBeat.o(119175);
    }

    private final void t(int i2, List<com.tencent.mm.plugin.story.f.d.h> list) {
        AppMethodBeat.i(119176);
        if (list.isEmpty()) {
            ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> arrayList = this.FqZ;
            if (arrayList == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                AppMethodBeat.o(119176);
                throw tVar;
            }
            af.eV(arrayList).remove(list);
            com.tencent.mm.ac.d.h(new C1762b(this, i2));
            AppMethodBeat.o(119176);
            return;
        }
        com.tencent.mm.ac.d.h(new c(this, i2, list));
        AppMethodBeat.o(119176);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ b Frj;

        k(b bVar) {
            this.Frj = bVar;
        }

        public final void run() {
            AppMethodBeat.i(119171);
            if (this.Frj.Fre >= 0 && this.Frj.Fre < this.Frj.FqZ.size() && this.Frj.Frf >= 0 && this.Frj.Frf < ((ArrayList) this.Frj.FqZ.get(this.Frj.Fre)).size()) {
                Object obj = ((ArrayList) this.Frj.FqZ.get(this.Frj.Fre)).get(this.Frj.Frf);
                p.g(obj, "dateGalleryMap[selectedRow][selectedCol]");
                final com.tencent.mm.plugin.story.f.d.g gVar = ((com.tencent.mm.plugin.story.f.d.h) obj).FoU;
                Log.i(this.Frj.TAG, "setSelectedRead " + this.Frj.Frf + ", " + gVar.FoN);
                if (gVar.FoS.size() > 0) {
                    com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                    long j2 = gVar.edx;
                    com.tencent.mm.plugin.story.f.b.a last = gVar.FoS.getLast();
                    p.g(last, "comment.visitorList.last");
                    if (com.tencent.mm.plugin.story.f.b.b.b(j2, last)) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.story.g.b.k.AnonymousClass1 */
                            final /* synthetic */ k Frw;

                            {
                                this.Frw = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(119170);
                                gVar.FoN = false;
                                Iterator<T> it = gVar.FoS.iterator();
                                while (it.hasNext()) {
                                    it.next().FnW = false;
                                }
                                this.Frw.Frj.Fri.fpA();
                                x xVar = x.SXb;
                                AppMethodBeat.o(119170);
                                return xVar;
                            }
                        });
                    }
                }
            }
            AppMethodBeat.o(119171);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class j implements Runnable {
        final /* synthetic */ b Frj;

        j(b bVar) {
            this.Frj = bVar;
        }

        public final void run() {
            AppMethodBeat.i(119169);
            if (this.Frj.Fre >= 0 && this.Frj.Fre < this.Frj.FqZ.size() && this.Frj.Frf >= 0 && this.Frj.Frf < ((ArrayList) this.Frj.FqZ.get(this.Frj.Fre)).size()) {
                Object obj = ((ArrayList) this.Frj.FqZ.get(this.Frj.Fre)).get(this.Frj.Frf);
                p.g(obj, "dateGalleryMap[selectedRow][selectedCol]");
                com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) obj;
                final com.tencent.mm.plugin.story.f.d.g gVar = hVar.FoU;
                com.tencent.mm.plugin.story.i.j jVar = hVar.FoV;
                Log.i(this.Frj.TAG, "setSelectedRead " + this.Frj.Frf + ", " + gVar.FnW);
                if (!this.Frj.Frh) {
                    if (jVar != null && jVar.frF()) {
                        jVar.vX(false);
                        n.a aVar = n.FmM;
                        n.a.aa(jVar.field_storyID, jVar.field_localFlag);
                    }
                    if (gVar.commentList.size() > 0) {
                        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                        long j2 = gVar.edx;
                        com.tencent.mm.plugin.story.f.b.a last = gVar.commentList.getLast();
                        p.g(last, "comment.commentList.last");
                        if (com.tencent.mm.plugin.story.f.b.b.b(j2, last)) {
                            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                                /* class com.tencent.mm.plugin.story.g.b.j.AnonymousClass2 */
                                final /* synthetic */ j Frv;

                                {
                                    this.Frv = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ x invoke() {
                                    AppMethodBeat.i(119168);
                                    gVar.FoN = false;
                                    gVar.FoO = false;
                                    gVar.FnW = false;
                                    Iterator<T> it = gVar.commentList.iterator();
                                    while (it.hasNext()) {
                                        it.next().FnW = false;
                                    }
                                    this.Frv.Frj.Fri.fpA();
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(119168);
                                    return xVar;
                                }
                            });
                        }
                    }
                } else if (jVar != null && jVar.frF()) {
                    jVar.vX(false);
                    n.a aVar2 = n.FmM;
                    n.a.aa(jVar.field_storyID, jVar.field_localFlag);
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.story.g.b.j.AnonymousClass1 */
                        final /* synthetic */ j Frv;

                        {
                            this.Frv = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(119167);
                            this.Frv.Frj.Fri.fpA();
                            x xVar = x.SXb;
                            AppMethodBeat.o(119167);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(119169);
                    return;
                }
            }
            AppMethodBeat.o(119169);
        }
    }

    private final void fpw() {
        AppMethodBeat.i(119177);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new j(this));
        AppMethodBeat.o(119177);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ b Frj;

        i(b bVar) {
            this.Frj = bVar;
        }

        public final void run() {
            AppMethodBeat.i(119166);
            if (this.Frj.Fre >= 0 && this.Frj.Fre < this.Frj.FqZ.size() && this.Frj.Frf >= 0 && this.Frj.Frf < ((ArrayList) this.Frj.FqZ.get(this.Frj.Fre)).size()) {
                Object obj = ((ArrayList) this.Frj.FqZ.get(this.Frj.Fre)).get(this.Frj.Frf);
                p.g(obj, "dateGalleryMap[selectedRow][selectedCol]");
                final com.tencent.mm.plugin.story.f.d.g gVar = ((com.tencent.mm.plugin.story.f.d.h) obj).FoU;
                Log.i(this.Frj.TAG, "setSelectedRead " + this.Frj.Frf + ", " + gVar.FoO);
                if (gVar.FoQ.size() > 0) {
                    com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                    long j2 = gVar.edx;
                    com.tencent.mm.plugin.story.f.b.a last = gVar.FoQ.getLast();
                    p.g(last, "comment.msgList.last");
                    if (com.tencent.mm.plugin.story.f.b.b.b(j2, last)) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.story.g.b.i.AnonymousClass1 */
                            final /* synthetic */ i Frt;

                            {
                                this.Frt = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(119165);
                                gVar.FoO = false;
                                Iterator<T> it = gVar.FoQ.iterator();
                                while (it.hasNext()) {
                                    it.next().FnW = false;
                                }
                                this.Frt.Frj.Fri.fpA();
                                x xVar = x.SXb;
                                AppMethodBeat.o(119165);
                                return xVar;
                            }
                        });
                    }
                }
            }
            AppMethodBeat.o(119166);
        }
    }

    private final void fpx() {
        AppMethodBeat.i(119178);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new i(this));
        AppMethodBeat.o(119178);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void fpy() {
        AppMethodBeat.i(119179);
        this.Frc = -1;
        this.Frd = -1;
        n.a aVar = n.FmM;
        n.a.fov();
        AppMethodBeat.o(119179);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void destroy() {
        AppMethodBeat.i(119180);
        if (this.dJM) {
            com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(764, this);
        }
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.g(this.FpA);
        AppMethodBeat.o(119180);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void fpz() {
        int i2 = 0;
        AppMethodBeat.i(119181);
        Iterator<T> it = this.FoJ.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            it.next();
            int i4 = i3 + 1;
            if (i3 < 0) {
                kotlin.a.j.hxH();
            }
            this.Fra.get(i3).FrH = 1;
            i3 = i4;
        }
        String str = this.username;
        p.h(str, ch.COL_USERNAME);
        ArrayList arrayList = new ArrayList();
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.k foc = j.b.foc();
        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
        Iterator<com.tencent.mm.plugin.story.i.j> it2 = foc.cy(str, Util.isEqual(str, j.b.fau())).iterator();
        while (it2.hasNext()) {
            com.tencent.mm.plugin.story.i.j next = it2.next();
            eek frG = next.frG();
            if (!(frG.NeB == null || frG.NeB.LoV.size() == 0)) {
                h.a aVar = com.tencent.mm.plugin.story.f.d.h.FoY;
                p.g(next, "story");
                arrayList.add(h.a.b(next));
                Log.i(f.TAG, "getFavGalleryItemsFromDb story username " + str + ' ' + arrayList.size() + ' ' + "content " + frG.NeB.LoV.get(0).Msz + ' ' + "and " + frG.NeB.LoV.get(0).Url + " id:" + next.field_storyID + " storyUsername: " + next.field_userName);
            }
        }
        if (arrayList.size() > 0) {
            int i5 = 0;
            for (Object obj : arrayList) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    kotlin.a.j.hxH();
                }
                com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) obj;
                if (i5 < this.FqZ.size()) {
                    this.FqZ.get(i5).add(hVar);
                }
                i5 = i6;
            }
            Log.i(this.TAG, "LogStory: preload Db data " + arrayList.size());
        } else {
            Log.i(this.TAG, "LogStory: initLoad no data");
        }
        Iterator<T> it3 = this.FoJ.iterator();
        while (it3.hasNext()) {
            it3.next();
            int i7 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            if (this.FqZ.size() > i2) {
                ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList2 = this.FqZ.get(i2);
                p.g(arrayList2, "dateGalleryMap[index]");
                t(i2, arrayList2);
            }
            i2 = i7;
        }
        AppMethodBeat.o(119181);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void je(int i2, int i3) {
        AppMethodBeat.i(119182);
        Log.i(this.TAG, "LogStory: deleteItem ".concat(String.valueOf(i2)));
        if (i2 >= 0 && i2 < this.FqZ.size() && i3 >= 0 && i3 < this.FqZ.get(i2).size()) {
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.eJP().post(new a(this, i2, i3));
        }
        AppMethodBeat.o(119182);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ b Frj;
        final /* synthetic */ int Frk;
        final /* synthetic */ int Frl;

        a(b bVar, int i2, int i3) {
            this.Frj = bVar;
            this.Frk = i2;
            this.Frl = i3;
        }

        public final void run() {
            AppMethodBeat.i(119157);
            this.Frj.Frc = this.Frk;
            this.Frj.Frd = this.Frl;
            Object obj = ((ArrayList) this.Frj.FqZ.get(this.Frk)).get(this.Frl);
            p.g(obj, "dateGalleryMap[row][column]");
            final com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) obj;
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(hVar.FoT.ecf);
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().aSz(new StringBuilder().append(hVar.FoT.ecf).append('_').append(hVar.FoT.iXu).toString());
            if (aba != null) {
                Log.i(this.Frj.TAG, "LogStory: deleteItem2 storyinfo " + hVar + " deleteItemRow " + this.Frj.Frc + " deleteItemCol " + this.Frj.Frd + " localid " + hVar.FoT.ecf + ' ' + aba.field_storyID);
                if (aba.field_storyID == 0) {
                    n.a aVar = n.FmM;
                    n.a.aaH(hVar.FoT.ecf);
                    b.i(this.Frj);
                } else if (!(this.Frj.Frc == -1 || this.Frj.Frd == -1)) {
                    n.a aVar2 = n.FmM;
                    n.a.Z(aba.field_storyID, hVar.FoT.ecf);
                }
            }
            if (hVar.FoT.foV()) {
                j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.eJP().post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.story.g.b.a.AnonymousClass1 */
                    final /* synthetic */ a Frm;

                    {
                        this.Frm = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(119156);
                        Log.i(this.Frm.Frj.TAG, "LogStory: deleteItem fake " + hVar);
                        n.a aVar = n.FmM;
                        n.a.aaH(hVar.FoT.ecf);
                        com.tencent.mm.plugin.story.f.e.a aVar2 = com.tencent.mm.plugin.story.f.e.a.Fpl;
                        com.tencent.mm.plugin.story.f.e.a.aLh(hVar.FoT.taskId);
                        com.tencent.mm.plugin.story.f.e.a aVar3 = com.tencent.mm.plugin.story.f.e.a.Fpl;
                        com.tencent.mm.plugin.story.f.e.a.aLi(hVar.FoT.taskId);
                        AppMethodBeat.o(119156);
                    }
                });
            }
            AppMethodBeat.o(119157);
        }
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void B(int i2, int i3, boolean z) {
        AppMethodBeat.i(119183);
        if (i2 == 3) {
            if (!z) {
                fpx();
            } else if (i3 == 0) {
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.eJP().post(new k(this));
                AppMethodBeat.o(119183);
                return;
            } else {
                if (i3 == 1) {
                    fpx();
                }
                AppMethodBeat.o(119183);
                return;
            }
        }
        AppMethodBeat.o(119183);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void aaK(int i2) {
        AppMethodBeat.i(119184);
        this.Frg = i2;
        if (this.Frg == 1 && !this.Frh) {
            fpw();
        }
        AppMethodBeat.o(119184);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void jf(int i2, int i3) {
        AppMethodBeat.i(119185);
        Log.d(this.TAG, "onSelected row=" + i2 + " column=" + i3);
        this.Fre = i2;
        this.Frf = i3;
        if (this.Frg == 1) {
            fpw();
        }
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new e(this, i2));
        AppMethodBeat.o(119185);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ b Frj;
        final /* synthetic */ int Frk;

        e(b bVar, int i2) {
            this.Frj = bVar;
            this.Frk = i2;
        }

        public final void run() {
            AppMethodBeat.i(119161);
            if (((e) this.Frj.Fra.get(this.Frk)).FrH != 2) {
                this.Frj.Frb.add(Integer.valueOf(this.Frk));
            }
            AppMethodBeat.o(119161);
        }
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void C(int i2, int i3, boolean z) {
        long j2;
        AppMethodBeat.i(119186);
        Log.i(this.TAG, "LogStory: setPrivacy row:" + i2 + " column:" + i3);
        if (i2 >= 0 && i2 < this.FoJ.size() && i3 >= 0 && i3 < this.FqZ.get(i2).size()) {
            boolean z2 = !z;
            com.tencent.mm.plugin.story.f.d.h hVar = this.FqZ.get(i2).get(i3);
            p.g(hVar, "dateGalleryMap[row][column]");
            com.tencent.mm.plugin.story.f.d.h hVar2 = hVar;
            Log.i(this.TAG, "LogStory: setPrivacy storyinfo " + hVar2 + " targetPrivacy:" + z2);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba((int) hVar2.FoV.systemRowid);
            if (aba != null) {
                com.tencent.mm.plugin.story.h.e eVar = com.tencent.mm.plugin.story.h.e.Fuh;
                com.tencent.mm.plugin.story.h.e.vT(z2);
                if (z2) {
                    j2 = 3;
                } else {
                    j2 = 4;
                }
                com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.a(j2, String.valueOf(aba.field_storyID), 0L, 0L, 28);
                n.a aVar = n.FmM;
                n.a.c(aba.field_storyID, (int) aba.systemRowid, z2, aba.frL());
            }
        }
        AppMethodBeat.o(119186);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        com.tencent.mm.plugin.story.f.a.a foQ;
        boolean z;
        T t;
        boolean z2;
        Object obj;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        AppMethodBeat.i(119187);
        p.h(qVar, "scene");
        Log.i(this.TAG, "LogStory: " + i2 + ' ' + i3 + ' ' + str);
        if (!(qVar instanceof com.tencent.mm.plugin.story.f.a.f) || (foQ = ((com.tencent.mm.plugin.story.f.a.f) qVar).foQ()) == null) {
            AppMethodBeat.o(119187);
        } else if (foQ instanceof com.tencent.mm.plugin.story.f.a.l) {
            if (i3 == 0) {
                Iterator<T> it = ((com.tencent.mm.plugin.story.f.a.f) qVar).FnH.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    n.a aVar = n.FmM;
                    n.a.aaH(intValue);
                }
            }
            if (i3 == 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            vP(z6);
            AppMethodBeat.o(119187);
        } else {
            if (foQ instanceof m) {
                Log.i(this.TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + i2 + ", errcode:" + i3);
                if (i3 == 0) {
                    Iterator<T> it2 = ((com.tencent.mm.plugin.story.f.a.f) qVar).FnH.iterator();
                    while (it2.hasNext()) {
                        int intValue2 = it2.next().intValue();
                        n.a aVar2 = n.FmM;
                        n.a.jc(intValue2, ((m) foQ).FnU);
                    }
                    if (((m) foQ).FnU != 1 || ((m) foQ).FnV) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    com.tencent.mm.ac.d.h(new h(this, z5));
                    AppMethodBeat.o(119187);
                    return;
                }
            } else if (foQ instanceof com.tencent.mm.plugin.story.f.a.k) {
                if (i3 == 0) {
                    Iterator<T> it3 = ((com.tencent.mm.plugin.story.f.a.f) qVar).FnH.iterator();
                    while (it3.hasNext()) {
                        int intValue3 = it3.next().intValue();
                        Log.i(this.TAG, "onSceneEnd update story favorite: errType " + i2 + ", errcode " + i3 + ", localId " + intValue3 + ", favorite:" + ((com.tencent.mm.plugin.story.f.a.k) foQ).FnT);
                        n.a aVar3 = n.FmM;
                        n.a.jd(intValue3, ((com.tencent.mm.plugin.story.f.a.k) foQ).FnT);
                        Iterator<T> it4 = this.FqZ.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                t = null;
                                break;
                            }
                            T next = it4.next();
                            Iterator it5 = next.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it5.next();
                                if (((int) ((com.tencent.mm.plugin.story.f.d.h) obj).FoV.systemRowid) == intValue3) {
                                    z4 = true;
                                    continue;
                                } else {
                                    z4 = false;
                                    continue;
                                }
                                if (z4) {
                                    break;
                                }
                            }
                            if (obj != null) {
                                z3 = true;
                                continue;
                            } else {
                                z3 = false;
                                continue;
                            }
                            if (z3) {
                                t = next;
                                break;
                            }
                        }
                        T t2 = t;
                        if (((com.tencent.mm.plugin.story.f.a.k) foQ).FnT == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        a(z2, (ArrayList<com.tencent.mm.plugin.story.f.d.h>) t2, true);
                    }
                    AppMethodBeat.o(119187);
                    return;
                }
                a.C1768a aVar4 = com.tencent.mm.plugin.story.i.a.FvD;
                if (i3 == com.tencent.mm.plugin.story.i.a.Fva) {
                    if (((com.tencent.mm.plugin.story.f.a.k) foQ).FnT == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a(z, (ArrayList<com.tencent.mm.plugin.story.f.d.h>) null, false);
                }
            }
            AppMethodBeat.o(119187);
        }
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void D(int i2, int i3, boolean z) {
        boolean z2;
        long j2;
        AppMethodBeat.i(119188);
        Log.i(this.TAG, "LogStory: setFavorite ".concat(String.valueOf(i3)));
        if (i2 >= 0 && i2 < this.FoJ.size() && i3 >= 0 && i3 < this.FqZ.get(i2).size()) {
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.tencent.mm.plugin.story.f.d.h hVar = this.FqZ.get(i2).get(i3);
            p.g(hVar, "dateGalleryMap[row][column]");
            com.tencent.mm.plugin.story.f.d.h hVar2 = hVar;
            Log.i(this.TAG, "LogStory: setFavorite storyinfo " + hVar2 + " localid " + hVar2.FoT.ecf + " targetFavorite:" + z2);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba((int) hVar2.FoV.systemRowid);
            if (aba != null) {
                com.tencent.mm.plugin.story.h.e eVar = com.tencent.mm.plugin.story.h.e.Fuh;
                com.tencent.mm.plugin.story.h.e.vS(z2);
                if (z2) {
                    j2 = 1;
                } else {
                    j2 = 2;
                }
                com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.a(j2, String.valueOf(aba.field_storyID), 0L, 0L, 28);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(Long.valueOf(aba.field_storyID));
                arrayList2.add(Integer.valueOf((int) aba.systemRowid));
                n.a aVar = n.FmM;
                n.a.b(arrayList, arrayList2, z2);
            }
        }
        AppMethodBeat.o(119188);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b Frj;
        final /* synthetic */ boolean vSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, boolean z) {
            super(0);
            this.Frj = bVar;
            this.vSM = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119160);
            if (this.vSM) {
                int size = this.Frj.FqZ.size();
                int i2 = this.Frj.Frc;
                if (i2 >= 0 && size > i2) {
                    Object obj = this.Frj.FqZ.get(this.Frj.Frc);
                    p.g(obj, "dateGalleryMap[deleteRowIndex]");
                    ArrayList arrayList = (ArrayList) obj;
                    int size2 = arrayList.size();
                    int i3 = this.Frj.Frd;
                    if (i3 >= 0 && size2 > i3) {
                        arrayList.remove(this.Frj.Frd);
                        b.a(this.Frj, this.Frj.Frc, arrayList);
                    }
                }
            }
            this.Frj.Fri.vQ(this.vSM);
            this.Frj.Frc = -1;
            this.Frj.Frd = -1;
            x xVar = x.SXb;
            AppMethodBeat.o(119160);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b Frj;
        final /* synthetic */ boolean Frs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar, boolean z) {
            super(0);
            this.Frj = bVar;
            this.Frs = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119164);
            this.Frj.Fri.vR(this.Frs);
            x xVar = x.SXb;
            AppMethodBeat.o(119164);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/presenter/FavStoryPresenter$onSetFavoriteCallback$1$1"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b Frj;
        final /* synthetic */ int Frq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(int i2, b bVar) {
            super(0);
            this.Frq = i2;
            this.Frj = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119162);
            this.Frj.Fri.aaM(this.Frq);
            x xVar = x.SXb;
            AppMethodBeat.o(119162);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ b Frj;
        final /* synthetic */ boolean Frr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(b bVar, boolean z, boolean z2) {
            super(0);
            this.Frj = bVar;
            this.Frr = z;
            this.$success = z2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119163);
            this.Frj.Fri.au(this.Frr, this.$success);
            x xVar = x.SXb;
            AppMethodBeat.o(119163);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.g.b$b  reason: collision with other inner class name */
    public static final class C1762b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b Frj;
        final /* synthetic */ int Fro;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1762b(b bVar, int i2) {
            super(0);
            this.Frj = bVar;
            this.Fro = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119158);
            this.Frj.Fri.aaM(this.Fro);
            x xVar = x.SXb;
            AppMethodBeat.o(119158);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b Frj;
        final /* synthetic */ int Fro;
        final /* synthetic */ List Frp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, int i2, List list) {
            super(0);
            this.Frj = bVar;
            this.Fro = i2;
            this.Frp = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119159);
            this.Frj.Fri.u(this.Fro, this.Frp);
            this.Frj.Fri.aaN(this.Fro);
            this.Frj.Fri.fpA();
            x xVar = x.SXb;
            AppMethodBeat.o(119159);
            return xVar;
        }
    }
}
