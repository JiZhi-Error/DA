package com.tencent.mm.plugin.story.g;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.f.a.m;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fH\u0016J\u0010\u0010)\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000fH\u0016J\u0018\u0010*\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fH\u0016J\b\u0010+\u001a\u00020%H\u0016J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0004H\u0002J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u000fH\u0016J\b\u00100\u001a\u00020%H\u0016J\b\u00101\u001a\u00020%H\u0016J\b\u00102\u001a\u00020%H\u0002J\u0010\u00103\u001a\u00020%2\u0006\u0010-\u001a\u00020\u0004H\u0002J\u001e\u00104\u001a\u00020%2\u0006\u0010-\u001a\u00020\u00042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006H\u0002J\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u000fH\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\u001aH\u0002J \u0010:\u001a\u00020%2\u0006\u00107\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u001aH\u0016J*\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010A\u001a\u00020BH\u0016J\u0018\u0010C\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fH\u0016J\u001a\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020\u001a2\b\b\u0002\u0010F\u001a\u00020\u001aH\u0002J\u0010\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020\u001aH\u0002J\b\u0010I\u001a\u00020%H\u0016J\u0010\u0010J\u001a\u00020%2\u0006\u0010K\u001a\u00020\u000fH\u0002J\b\u0010L\u001a\u00020%H\u0016J*\u0010M\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u001a2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J \u0010Q\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010R\u001a\u00020\u001aH\u0016J\b\u0010S\u001a\u00020%H\u0002J\b\u0010T\u001a\u00020%H\u0002J\b\u0010U\u001a\u00020%H\u0002J\u0010\u0010V\u001a\u00020%2\u0006\u0010K\u001a\u00020\u000fH\u0002R\u000e\u0010\u0011\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R>\u0010\u0012\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u000bj\b\u0012\u0004\u0012\u00020\u0013`\r0\u000bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u000bj\b\u0012\u0004\u0012\u00020\u0013`\r`\rX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u000bj\b\u0012\u0004\u0012\u00020\u0016`\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R,\u0010#\u001a \u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/SelfHistoryGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", ch.COL_USERNAME, "", "dates", "", "galleryUserCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "storyFilterList", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "queryCondition", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;Ljava/util/Map;I)V", "TAG", "dateGalleryMap", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "dateList", "dateState", "Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "deleteColumnIndex", "deleteRowIndex", "enableVisit", "", "isLoadNetScene", "loadingIndexQueue", "Ljava/util/LinkedList;", "needFilter", "preloadLocalCount", "preloadRemoteCount", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "cancelDeleteItem", "row", "column", "checkLoadMore", "deleteItem", "destroy", "getStoryCountByDate", FFmpegMetadataRetriever.METADATA_KEY_DATE, "initExpectPosition", "expectPos", "initLoad", "loadMore", "loadNextQueuedUser", "loadStoryByDate", "notifyDateUpdate", "userGalleryItems", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onMsgListState", FirebaseAnalytics.b.INDEX, "isSelf", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "success", "onSetPrivacyCallback", "isPrivacy", "pause", "preloadForDate", "dateIndex", "resume", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedCommentRead", "setSelectedRead", "setSelectedVisitRead", "updateUserGalleryItemsFromDb", "plugin-story_release"})
public final class i extends f implements com.tencent.mm.ak.i {
    private boolean EDF;
    private final int FkI;
    private final r<Long, Boolean, String, String, x> FpA;
    private final ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> FqZ;
    private final int FrM;
    private final int FrN;
    private boolean FrP;
    private boolean FrS;
    private final Map<String, ArrayList<Long>> FrW;
    private final ArrayList<e> Fra;
    private final LinkedList<String> Frb;
    private int Frc;
    private int Frd;
    private int Fre;
    private int Frf;
    private final c Fri;
    private ArrayList<String> Fsx;
    private final List<String> Fsy;
    private final String TAG;
    private final String username;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    static final class l extends q implements r<Long, Boolean, String, String, x> {
        final /* synthetic */ i Fsz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(i iVar) {
            super(4);
            this.Fsz = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Long l, Boolean bool, String str, String str2) {
            AppMethodBeat.i(119301);
            long longValue = l.longValue();
            boolean booleanValue = bool.booleanValue();
            p.h(str, "fromUser");
            p.h(str2, "storyOwner");
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(longValue);
            if (KA != null) {
                int i2 = 0;
                Iterator it = this.Fsz.Fsx.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    a.C1747a aVar = com.tencent.mm.plugin.story.e.a.Flw;
                    if (Util.isEqual((String) it.next(), a.C1747a.n(Integer.valueOf(KA.field_createTime)))) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    Object obj = this.Fsz.FqZ.get(i2);
                    p.g(obj, "dateGalleryMap[rowIndex]");
                    ArrayList arrayList = (ArrayList) obj;
                    int i3 = 0;
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        if (((com.tencent.mm.plugin.story.f.d.h) it2.next()).edx == longValue) {
                            break;
                        }
                        i3++;
                    }
                    if (i3 != -1) {
                        h.a aVar2 = com.tencent.mm.plugin.story.f.d.h.FoY;
                        com.tencent.mm.ac.d.h(new a(i2, i3, h.a.b(KA), arrayList, this, longValue, booleanValue));
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119301);
            return xVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/presenter/SelfHistoryGalleryPresenter$storyCommentChangeListener$1$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ com.tencent.mm.plugin.story.f.d.h FrA;
            final /* synthetic */ ArrayList FrB;
            final /* synthetic */ int Fry;
            final /* synthetic */ int Frz;
            final /* synthetic */ l FsF;
            final /* synthetic */ long FsG;
            final /* synthetic */ boolean FsH;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(int i2, int i3, com.tencent.mm.plugin.story.f.d.h hVar, ArrayList arrayList, l lVar, long j2, boolean z) {
                super(0);
                this.Fry = i2;
                this.Frz = i3;
                this.FrA = hVar;
                this.FrB = arrayList;
                this.FsF = lVar;
                this.FsG = j2;
                this.FsH = z;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(119300);
                if (this.FsH) {
                    Log.i(this.FsF.Fsz.TAG, "commentChanged, will update row:" + this.Fry + " col:" + this.Frz);
                    this.FrB.set(this.Frz, this.FrA);
                    this.FsF.Fsz.Fri.u(this.Fry, this.FrB);
                    this.FsF.Fsz.Fri.aA(this.Fry, this.Frz, 1);
                    this.FsF.Fsz.Fri.fpA();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(119300);
                return xVar;
            }
        }
    }

    public static final /* synthetic */ void a(i iVar, String str, List list) {
        AppMethodBeat.i(119319);
        iVar.E(str, list);
        AppMethodBeat.o(119319);
    }

    public static final /* synthetic */ void l(i iVar) {
        AppMethodBeat.i(119320);
        iVar.vP(true);
        AppMethodBeat.o(119320);
    }

    public static final /* synthetic */ void m(i iVar) {
        AppMethodBeat.i(119321);
        iVar.fpF();
        AppMethodBeat.o(119321);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, List list, c cVar) {
        this(str, list, cVar, new HashMap(), d.fpB());
        d dVar = d.FrG;
        AppMethodBeat.i(119318);
        AppMethodBeat.o(119318);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.ArrayList<java.lang.Long>> */
    /* JADX WARN: Multi-variable type inference failed */
    public i(String str, List<String> list, c cVar, Map<String, ? extends ArrayList<Long>> map, int i2) {
        p.h(str, ch.COL_USERNAME);
        p.h(list, "dates");
        p.h(cVar, "galleryUserCallback");
        p.h(map, "storyFilterList");
        AppMethodBeat.i(119317);
        this.username = str;
        this.Fsy = list;
        this.Fri = cVar;
        this.FrW = map;
        this.FkI = i2;
        this.TAG = "MicroMsg.SelfHistoryGalleryPresenter";
        this.FrM = 3;
        this.FrN = 1;
        this.FqZ = new ArrayList<>();
        this.Fra = new ArrayList<>();
        this.Frb = new LinkedList<>();
        this.Frc = -1;
        this.Frd = -1;
        this.Fre = -1;
        this.Frf = -1;
        int i3 = this.FkI;
        d dVar = d.FrG;
        this.FrS = com.tencent.mm.ac.d.cW(i3, d.fpE());
        this.Fsx = new ArrayList<>();
        this.FpA = new l(this);
        this.Fsx.addAll(this.Fsy);
        this.Fri.aaL(this.Fsx.size());
        for (T t : this.Fsx) {
            Log.i(this.TAG, "LogStory: ".concat(String.valueOf(t)));
            this.FqZ.add(new ArrayList<>());
            this.Fra.add(new e(t));
        }
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.f(this.FpA);
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "network()");
        aAg.azz().a(764, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "network()");
        aAg2.azz().a(com.tencent.mm.plugin.appbrand.jsapi.o.f.CTRL_INDEX, this);
        this.EDF = com.tencent.mm.plugin.story.c.a.e.Fln.fng();
        AppMethodBeat.o(119317);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void aaP(int i2) {
    }

    private final void vP(boolean z) {
        AppMethodBeat.i(119302);
        com.tencent.mm.ac.d.h(new e(this, z));
        AppMethodBeat.o(119302);
    }

    private final void av(boolean z, boolean z2) {
        AppMethodBeat.i(119303);
        com.tencent.mm.ac.d.h(new g(this, z, z2));
        AppMethodBeat.o(119303);
    }

    private final void E(String str, List<com.tencent.mm.plugin.story.f.d.h> list) {
        AppMethodBeat.i(119304);
        int indexOf = this.Fsx.indexOf(str);
        if (list.isEmpty()) {
            com.tencent.mm.ac.d.h(new c(this, indexOf));
            AppMethodBeat.o(119304);
            return;
        }
        com.tencent.mm.ac.d.h(new d(this, indexOf, list));
        AppMethodBeat.o(119304);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ i Fsz;

        k(i iVar) {
            this.Fsz = iVar;
        }

        public final void run() {
            final com.tencent.mm.plugin.story.f.d.g gVar;
            final com.tencent.mm.plugin.story.i.j jVar;
            Boolean bool = null;
            AppMethodBeat.i(119299);
            if (this.Fsz.Fre >= 0 && this.Fsz.Fre < this.Fsz.FqZ.size()) {
                Object obj = this.Fsz.FqZ.get(this.Fsz.Fre);
                p.g(obj, "dateGalleryMap[selectedRow]");
                ArrayList arrayList = (ArrayList) obj;
                com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(arrayList, this.Fsz.Frf);
                if (hVar != null) {
                    gVar = hVar.FoU;
                } else {
                    gVar = null;
                }
                com.tencent.mm.plugin.story.f.d.h hVar2 = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(arrayList, this.Fsz.Frf);
                if (hVar2 != null) {
                    jVar = hVar2.FoV;
                } else {
                    jVar = null;
                }
                String str = this.Fsz.TAG;
                StringBuilder append = new StringBuilder("setSelectedRead ").append(this.Fsz.Frf).append(", ");
                if (gVar != null) {
                    bool = Boolean.valueOf(gVar.FoN);
                }
                Log.i(str, append.append(bool).toString());
                if (gVar != null && gVar.FoS.size() > 0) {
                    com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                    long j2 = gVar.edx;
                    com.tencent.mm.plugin.story.f.b.a last = gVar.FoS.getLast();
                    p.g(last, "comment.visitorList.last");
                    if (com.tencent.mm.plugin.story.f.b.b.b(j2, last)) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.story.g.i.k.AnonymousClass1 */
                            final /* synthetic */ k FsE;

                            {
                                this.FsE = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(119298);
                                com.tencent.mm.plugin.story.i.j jVar = jVar;
                                if (jVar != null && !jVar.frL()) {
                                    com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                                    com.tencent.mm.plugin.story.f.b.b.at(false, false);
                                }
                                gVar.FoN = false;
                                Iterator<T> it = gVar.FoS.iterator();
                                while (it.hasNext()) {
                                    it.next().FnW = false;
                                }
                                this.FsE.Fsz.Fri.fpA();
                                x xVar = x.SXb;
                                AppMethodBeat.o(119298);
                                return xVar;
                            }
                        });
                    }
                }
            }
            AppMethodBeat.o(119299);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class j implements Runnable {
        final /* synthetic */ i Fsz;

        j(i iVar) {
            this.Fsz = iVar;
        }

        public final void run() {
            final com.tencent.mm.plugin.story.f.d.g gVar;
            com.tencent.mm.plugin.story.i.j jVar;
            Boolean bool = null;
            AppMethodBeat.i(119297);
            if (this.Fsz.Fre >= 0 && this.Fsz.Fre < this.Fsz.FqZ.size()) {
                Object obj = this.Fsz.FqZ.get(this.Fsz.Fre);
                p.g(obj, "dateGalleryMap[selectedRow]");
                ArrayList arrayList = (ArrayList) obj;
                com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(arrayList, this.Fsz.Frf);
                if (hVar != null) {
                    gVar = hVar.FoU;
                } else {
                    gVar = null;
                }
                com.tencent.mm.plugin.story.f.d.h hVar2 = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(arrayList, this.Fsz.Frf);
                if (hVar2 != null) {
                    jVar = hVar2.FoV;
                } else {
                    jVar = null;
                }
                String str = this.Fsz.TAG;
                StringBuilder append = new StringBuilder("setSelectedRead ").append(this.Fsz.Frf).append(", ");
                if (gVar != null) {
                    bool = Boolean.valueOf(gVar.FnW);
                }
                Log.i(str, append.append(bool).toString());
                if (!this.Fsz.EDF) {
                    if (jVar != null && jVar.frF()) {
                        jVar.vX(false);
                        n.a aVar = n.FmM;
                        n.a.aa(jVar.field_storyID, jVar.field_localFlag);
                    }
                    if (gVar != null && gVar.commentList.size() > 0) {
                        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                        long j2 = gVar.edx;
                        com.tencent.mm.plugin.story.f.b.a last = gVar.commentList.getLast();
                        p.g(last, "comment.commentList.last");
                        if (com.tencent.mm.plugin.story.f.b.b.b(j2, last)) {
                            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                                /* class com.tencent.mm.plugin.story.g.i.j.AnonymousClass2 */
                                final /* synthetic */ j FsD;

                                {
                                    this.FsD = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ x invoke() {
                                    AppMethodBeat.i(119296);
                                    gVar.FoN = false;
                                    gVar.FoO = false;
                                    gVar.FnW = false;
                                    Iterator<T> it = gVar.commentList.iterator();
                                    while (it.hasNext()) {
                                        it.next().FnW = false;
                                    }
                                    this.FsD.Fsz.Fri.fpA();
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(119296);
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
                        /* class com.tencent.mm.plugin.story.g.i.j.AnonymousClass1 */
                        final /* synthetic */ j FsD;

                        {
                            this.FsD = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(119295);
                            this.FsD.Fsz.Fri.fpA();
                            x xVar = x.SXb;
                            AppMethodBeat.o(119295);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(119297);
                    return;
                }
            }
            AppMethodBeat.o(119297);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.g.i$i  reason: collision with other inner class name */
    public static final class RunnableC1766i implements Runnable {
        final /* synthetic */ i Fsz;

        RunnableC1766i(i iVar) {
            this.Fsz = iVar;
        }

        public final void run() {
            final com.tencent.mm.plugin.story.f.d.g gVar;
            final com.tencent.mm.plugin.story.i.j jVar;
            Boolean bool = null;
            AppMethodBeat.i(119294);
            if (this.Fsz.Fre >= 0 && this.Fsz.Fre < this.Fsz.FqZ.size()) {
                Object obj = this.Fsz.FqZ.get(this.Fsz.Fre);
                p.g(obj, "dateGalleryMap[selectedRow]");
                ArrayList arrayList = (ArrayList) obj;
                com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(arrayList, this.Fsz.Frf);
                if (hVar != null) {
                    gVar = hVar.FoU;
                } else {
                    gVar = null;
                }
                com.tencent.mm.plugin.story.f.d.h hVar2 = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(arrayList, this.Fsz.Frf);
                if (hVar2 != null) {
                    jVar = hVar2.FoV;
                } else {
                    jVar = null;
                }
                String str = this.Fsz.TAG;
                StringBuilder append = new StringBuilder("setSelectedRead ").append(this.Fsz.Frf).append(", ");
                if (gVar != null) {
                    bool = Boolean.valueOf(gVar.FoO);
                }
                Log.i(str, append.append(bool).toString());
                if (gVar != null && gVar.FoQ.size() > 0) {
                    com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                    long j2 = gVar.edx;
                    com.tencent.mm.plugin.story.f.b.a last = gVar.FoQ.getLast();
                    p.g(last, "comment.msgList.last");
                    if (com.tencent.mm.plugin.story.f.b.b.b(j2, last)) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.story.g.i.RunnableC1766i.AnonymousClass1 */
                            final /* synthetic */ RunnableC1766i FsB;

                            {
                                this.FsB = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(119293);
                                com.tencent.mm.plugin.story.i.j jVar = jVar;
                                if (jVar != null && !jVar.frL()) {
                                    com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                                    com.tencent.mm.plugin.story.f.b.b.at(false, false);
                                }
                                gVar.FoO = false;
                                Iterator<T> it = gVar.FoQ.iterator();
                                while (it.hasNext()) {
                                    it.next().FnW = false;
                                }
                                this.FsB.Fsz.Fri.fpA();
                                x xVar = x.SXb;
                                AppMethodBeat.o(119293);
                                return xVar;
                            }
                        });
                    }
                }
            }
            AppMethodBeat.o(119294);
        }
    }

    private final void fpx() {
        AppMethodBeat.i(119305);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new RunnableC1766i(this));
        AppMethodBeat.o(119305);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void fpy() {
        AppMethodBeat.i(119306);
        this.Frc = -1;
        this.Frd = -1;
        n.a aVar = n.FmM;
        n.a.fov();
        AppMethodBeat.o(119306);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void resume() {
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void pause() {
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void destroy() {
        AppMethodBeat.i(119307);
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.g(this.FpA);
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "network()");
        aAg.azz().b(com.tencent.mm.plugin.appbrand.jsapi.o.f.CTRL_INDEX, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "network()");
        aAg2.azz().b(764, this);
        AppMethodBeat.o(119307);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void aaK(int i2) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: java.util.LinkedList<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.story.g.f
    public final void fpz() {
        AppMethodBeat.i(119308);
        int i2 = 0;
        Iterator<T> it = this.Fsx.iterator();
        while (it.hasNext()) {
            it.next();
            i2++;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            this.Fra.get(i2).FrH = 1;
        }
        Iterator<T> it2 = this.Fsx.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            it2.next();
            int i4 = i3 + 1;
            if (i3 < 0) {
                kotlin.a.j.hxH();
            }
            String str = this.Fsx.get(i3);
            p.g(str, "dateList[dateIndex]");
            String str2 = str;
            ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList = this.FqZ.get(i3);
            p.g(arrayList, "dateGalleryMap[dateIndex]");
            ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList2 = arrayList;
            e eVar = this.Fra.get(i3);
            p.g(eVar, "dateState[dateIndex]");
            e eVar2 = eVar;
            if (this.FrS) {
                ArrayList arrayList3 = new ArrayList();
                for (T t : f.a.la(this.username, str2)) {
                    T t2 = t;
                    ArrayList<Long> arrayList4 = this.FrW.get(str2);
                    if (arrayList4 != null ? arrayList4.contains(Long.valueOf(t2.edx)) : true) {
                        arrayList3.add(t);
                    }
                }
                ArrayList arrayList5 = arrayList3;
                if (!arrayList5.isEmpty()) {
                    arrayList2.addAll(arrayList5);
                    eVar2.FrH = 2;
                    Log.i(this.TAG, "LogStory: preload Db with filter data " + arrayList5.size());
                    i3 = i4;
                }
            } else {
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                com.tencent.mm.plugin.story.i.h aSy = j.b.foh().aSy(str2);
                int i5 = aSy != null ? aSy.field_count : 0;
                Log.i(this.TAG, "LogStory: preloadForDate " + str2 + " historyCount " + i5);
                ArrayList<com.tencent.mm.plugin.story.f.d.h> la = f.a.la(this.username, str2);
                if (la.size() > 0) {
                    arrayList2.addAll(la);
                    if (la.size() == i5) {
                        eVar2.FrH = 2;
                    } else {
                        eVar2.FrH = 1;
                    }
                    Log.i(this.TAG, "LogStory: preload Db data " + la.size());
                    i3 = i4;
                } else if (i5 != 0) {
                    eVar2.FrH = 1;
                    Log.i(this.TAG, "LogStory: initLoad Sync data");
                }
            }
            i3 = i4;
        }
        if (this.Fsx.size() > 0) {
            this.Frb.add(kotlin.a.j.ks(this.Fsx));
            fpF();
        }
        int i6 = 0;
        Iterator<T> it3 = this.Fsx.iterator();
        while (it3.hasNext()) {
            it3.next();
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.a.j.hxH();
            }
            String str3 = this.Fsx.get(i6);
            p.g(str3, "dateList[index]");
            ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList6 = this.FqZ.get(i6);
            p.g(arrayList6, "dateGalleryMap[index]");
            E(str3, arrayList6);
            i6 = i7;
        }
        AppMethodBeat.o(119308);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void cJk() {
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void je(int i2, int i3) {
        AppMethodBeat.i(119309);
        Log.i(this.TAG, "LogStory: deleteItem ".concat(String.valueOf(i2)));
        if (i2 >= 0 && i2 < this.Fsx.size() && i3 >= 0 && i3 < this.FqZ.get(i2).size()) {
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.eJP().post(new b(this, i2, i3));
        }
        AppMethodBeat.o(119309);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ int Frk;
        final /* synthetic */ int Frl;
        final /* synthetic */ i Fsz;

        b(i iVar, int i2, int i3) {
            this.Fsz = iVar;
            this.Frk = i2;
            this.Frl = i3;
        }

        public final void run() {
            AppMethodBeat.i(119286);
            this.Fsz.Frc = this.Frk;
            this.Fsz.Frd = this.Frl;
            Object obj = ((ArrayList) this.Fsz.FqZ.get(this.Frk)).get(this.Frl);
            p.g(obj, "dateGalleryMap[row][column]");
            final com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) obj;
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(hVar.FoT.ecf);
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().aSz(new StringBuilder().append(hVar.FoT.ecf).append('_').append(hVar.FoT.iXu).toString());
            if (aba != null) {
                Log.i(this.Fsz.TAG, "LogStory: deleteItem2 storyinfo " + hVar + " deleteItemRow " + this.Fsz.Frc + " deleteItemCol " + this.Fsz.Frd + " localid " + hVar.FoT.ecf + ' ' + aba.field_storyID);
                if (aba.field_storyID == 0) {
                    n.a aVar = n.FmM;
                    n.a.aaH(hVar.FoT.ecf);
                    i.l(this.Fsz);
                } else if (!(this.Fsz.Frc == -1 || this.Fsz.Frd == -1)) {
                    n.a aVar2 = n.FmM;
                    n.a.Z(aba.field_storyID, hVar.FoT.ecf);
                }
            }
            if (hVar.FoT.foV()) {
                j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.eJP().post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.story.g.i.b.AnonymousClass1 */
                    final /* synthetic */ b FsA;

                    {
                        this.FsA = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(119285);
                        Log.i(this.FsA.Fsz.TAG, "LogStory: deleteItem fake " + hVar);
                        n.a aVar = n.FmM;
                        n.a.aaH(hVar.FoT.ecf);
                        com.tencent.mm.plugin.story.f.e.a aVar2 = com.tencent.mm.plugin.story.f.e.a.Fpl;
                        com.tencent.mm.plugin.story.f.e.a.aLh(hVar.FoT.taskId);
                        com.tencent.mm.plugin.story.f.e.a aVar3 = com.tencent.mm.plugin.story.f.e.a.Fpl;
                        com.tencent.mm.plugin.story.f.e.a.aLi(hVar.FoT.taskId);
                        AppMethodBeat.o(119285);
                    }
                });
            }
            AppMethodBeat.o(119286);
        }
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void B(int i2, int i3, boolean z) {
        AppMethodBeat.i(119310);
        if (i2 == 3) {
            if (!z) {
                fpx();
            } else if (i3 == 0) {
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.eJP().post(new k(this));
                AppMethodBeat.o(119310);
                return;
            } else {
                if (i3 == 1) {
                    fpx();
                }
                AppMethodBeat.o(119310);
                return;
            }
        }
        AppMethodBeat.o(119310);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void jf(int i2, int i3) {
        AppMethodBeat.i(119311);
        this.Fre = i2;
        this.Frf = i3;
        Log.d(this.TAG, "onSelected row=" + i2 + " column=" + i3);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new f(this, i2));
        AppMethodBeat.o(119311);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ int Frk;
        final /* synthetic */ i Fsz;

        f(i iVar, int i2) {
            this.Fsz = iVar;
            this.Frk = i2;
        }

        public final void run() {
            AppMethodBeat.i(119290);
            if (((e) this.Fsz.Fra.get(this.Frk)).FrH != 2) {
                this.Fsz.Frb.add(this.Fsz.Fsx.get(this.Frk));
            }
            int i2 = this.Frk + 1;
            if (i2 < this.Fsz.Fsx.size()) {
                this.Fsz.Frb.add(this.Fsz.Fsx.get(i2));
                i.m(this.Fsz);
            }
            i.n(this.Fsz);
            AppMethodBeat.o(119290);
        }
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void C(int i2, int i3, boolean z) {
        long j2;
        AppMethodBeat.i(119312);
        Log.i(this.TAG, "LogStory: setPrivacy row:" + i2 + " column:" + i3);
        if (i2 >= 0 && i2 < this.Fsx.size() && i3 >= 0 && i3 < this.FqZ.get(i2).size()) {
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
                com.tencent.mm.plugin.story.h.h.a(j2, String.valueOf(aba.field_storyID), 2L, 0L, 16);
                n.a aVar = n.FmM;
                n.a.c(aba.field_storyID, (int) aba.systemRowid, z2, aba.frL());
                AppMethodBeat.o(119312);
                return;
            }
        }
        AppMethodBeat.o(119312);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ int Frk;
        final /* synthetic */ i Fsz;

        a(i iVar, int i2) {
            this.Fsz = iVar;
            this.Frk = i2;
        }

        public final void run() {
            AppMethodBeat.i(119284);
            if (((e) this.Fsz.Fra.get(this.Frk)).FrH != 2) {
                this.Fsz.Frb.add(this.Fsz.Fsx.get(this.Frk));
            }
            int i2 = this.Frk + 1;
            if (i2 < this.Fsz.Fsx.size()) {
                this.Fsz.Frb.add(this.Fsz.Fsx.get(i2));
                i.m(this.Fsz);
            }
            AppMethodBeat.o(119284);
        }
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void aaO(int i2) {
        AppMethodBeat.i(119313);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new a(this, i2));
        AppMethodBeat.o(119313);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        com.tencent.mm.plugin.story.f.a.a foQ;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(119314);
        p.h(qVar, "scene");
        Log.i(this.TAG, "LogStory: " + i2 + ' ' + i3 + ' ' + str);
        if ((qVar instanceof com.tencent.mm.plugin.story.f.a.d) && Util.isEqual(((com.tencent.mm.plugin.story.f.a.d) qVar).userName, this.username)) {
            int indexOf = this.Fsx.indexOf(this.Frb.poll());
            int size = this.Fra.size();
            if (indexOf < 0) {
                AppMethodBeat.o(119314);
                return;
            } else if (size > indexOf) {
                this.FrP = false;
                this.Fra.get(indexOf).FrH = 2;
                Log.i(this.TAG, "LogStory: updateUserGalleryItemsFromDb ".concat(String.valueOf(indexOf)));
                String str2 = this.Fsx.get(indexOf);
                p.g(str2, "dateList[dateIndex]");
                String str3 = str2;
                ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList = this.FqZ.get(indexOf);
                p.g(arrayList, "dateGalleryMap[dateIndex]");
                ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList2 = arrayList;
                ArrayList<com.tencent.mm.plugin.story.f.d.h> la = f.a.la(this.username, str3);
                arrayList2.clear();
                arrayList2.addAll(la);
                Log.i(this.TAG, "LogStory: db data " + str3 + ' ' + arrayList2.size());
                E(str3, arrayList2);
                fpF();
                AppMethodBeat.o(119314);
                return;
            }
        } else if ((qVar instanceof com.tencent.mm.plugin.story.f.a.f) && (foQ = ((com.tencent.mm.plugin.story.f.a.f) qVar).foQ()) != null) {
            if (foQ instanceof com.tencent.mm.plugin.story.f.a.l) {
                if (i3 == 0) {
                    Iterator<T> it = ((com.tencent.mm.plugin.story.f.a.f) qVar).FnH.iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        n.a aVar = n.FmM;
                        n.a.aaH(intValue);
                    }
                }
                vP(i3 == 0);
                AppMethodBeat.o(119314);
                return;
            }
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
                        z2 = false;
                    }
                    com.tencent.mm.ac.d.h(new h(this, z2));
                    AppMethodBeat.o(119314);
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
                    }
                    if (((com.tencent.mm.plugin.story.f.a.k) foQ).FnT == 1) {
                        z = true;
                    }
                    av(z, true);
                    AppMethodBeat.o(119314);
                    return;
                }
                a.C1768a aVar4 = com.tencent.mm.plugin.story.i.a.FvD;
                if (i3 == com.tencent.mm.plugin.story.i.a.Fva) {
                    if (((com.tencent.mm.plugin.story.f.a.k) foQ).FnT != 1) {
                        z2 = false;
                    }
                    av(z2, false);
                }
            }
            AppMethodBeat.o(119314);
            return;
        }
        AppMethodBeat.o(119314);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void D(int i2, int i3, boolean z) {
        boolean z2;
        long j2;
        AppMethodBeat.i(119315);
        Log.i(this.TAG, "LogStory: setFavorite ".concat(String.valueOf(i3)));
        if (i2 >= 0 && i2 < this.Fsx.size() && i3 >= 0 && i3 < this.FqZ.get(i2).size()) {
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
                com.tencent.mm.plugin.story.h.h.a(j2, String.valueOf(aba.field_storyID), 2L, 0L, 16);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(Long.valueOf(aba.field_storyID));
                arrayList2.add(Integer.valueOf((int) aba.systemRowid));
                n.a aVar = n.FmM;
                n.a.b(arrayList, arrayList2, z2);
            }
        }
        AppMethodBeat.o(119315);
    }

    private final void fpF() {
        AppMethodBeat.i(119316);
        while (!this.FrP && this.Frb.size() > 0) {
            String str = this.Frb.get(0);
            p.g(str, "loadingIndexQueue[0]");
            String str2 = str;
            int indexOf = this.Fsx.indexOf(str2);
            int size = this.Fra.size();
            if (indexOf < 0) {
                AppMethodBeat.o(119316);
                return;
            } else if (size > indexOf) {
                Log.i(this.TAG, "LogStory: loadRemoteForDate ".concat(String.valueOf(str2)));
                if (this.Fra.get(indexOf).FrH != 2) {
                    com.tencent.mm.plugin.story.f.a.d dVar = new com.tencent.mm.plugin.story.f.a.d(this.username, str2);
                    com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
                    p.g(aAg, "MMKernel.network()");
                    aAg.azz().b(dVar);
                    this.FrP = true;
                    AppMethodBeat.o(119316);
                    return;
                }
                this.Frb.remove(0);
            } else {
                AppMethodBeat.o(119316);
                return;
            }
        }
        AppMethodBeat.o(119316);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ i Fsz;
        final /* synthetic */ boolean vSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(i iVar, boolean z) {
            super(0);
            this.Fsz = iVar;
            this.vSM = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119289);
            if (this.vSM) {
                int size = this.Fsz.FqZ.size();
                int i2 = this.Fsz.Frc;
                if (i2 >= 0 && size > i2) {
                    Object obj = this.Fsz.FqZ.get(this.Fsz.Frc);
                    p.g(obj, "dateGalleryMap[deleteRowIndex]");
                    ArrayList arrayList = (ArrayList) obj;
                    int size2 = arrayList.size();
                    int i3 = this.Fsz.Frd;
                    if (i3 >= 0 && size2 > i3) {
                        arrayList.remove(this.Fsz.Frd);
                        Object obj2 = this.Fsz.Fsx.get(this.Fsz.Frc);
                        p.g(obj2, "dateList[deleteRowIndex]");
                        String str = (String) obj2;
                        i.a(this.Fsz, str, arrayList);
                        if (arrayList.isEmpty()) {
                            this.Fsz.FqZ.remove(arrayList);
                            this.Fsz.Fsx.remove(this.Fsz.Frc);
                            this.Fsz.Fra.remove(this.Fsz.Frc);
                            this.Fsz.Frb.remove(str);
                        }
                    }
                }
            }
            this.Fsz.Fri.vQ(this.vSM);
            this.Fsz.Frc = -1;
            this.Fsz.Frd = -1;
            x xVar = x.SXb;
            AppMethodBeat.o(119289);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean Frs;
        final /* synthetic */ i Fsz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(i iVar, boolean z) {
            super(0);
            this.Fsz = iVar;
            this.Frs = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119292);
            this.Fsz.Fri.vR(this.Frs);
            x xVar = x.SXb;
            AppMethodBeat.o(119292);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ boolean Frr;
        final /* synthetic */ i Fsz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(i iVar, boolean z, boolean z2) {
            super(0);
            this.Fsz = iVar;
            this.Frr = z;
            this.$success = z2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119291);
            this.Fsz.Fri.au(this.Frr, this.$success);
            x xVar = x.SXb;
            AppMethodBeat.o(119291);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int Fro;
        final /* synthetic */ i Fsz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(i iVar, int i2) {
            super(0);
            this.Fsz = iVar;
            this.Fro = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119287);
            this.Fsz.Fri.aaM(this.Fro);
            x xVar = x.SXb;
            AppMethodBeat.o(119287);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int Fro;
        final /* synthetic */ List Frp;
        final /* synthetic */ i Fsz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(i iVar, int i2, List list) {
            super(0);
            this.Fsz = iVar;
            this.Fro = i2;
            this.Frp = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119288);
            this.Fsz.Fri.u(this.Fro, this.Frp);
            this.Fsz.Fri.aaN(this.Fro);
            this.Fsz.Fri.fpA();
            x xVar = x.SXb;
            AppMethodBeat.o(119288);
            return xVar;
        }
    }

    public static final /* synthetic */ void n(i iVar) {
        AppMethodBeat.i(119322);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new j(iVar));
        AppMethodBeat.o(119322);
    }
}
