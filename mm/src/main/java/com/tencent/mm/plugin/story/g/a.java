package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.o;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\rH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J,\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\r2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00100\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class a implements i, a.e {
    public static final C1761a FqV = new C1761a((byte) 0);
    private static final String TAG = TAG;
    private final LinkedHashMap<String, ArrayList<h>> FqP = new LinkedHashMap<>();
    private long FqQ;
    private long FqR;
    private long FqS;
    private int FqT;
    final a.f FqU;
    private String mRa = "";
    private boolean qhf;

    public a(a.f fVar) {
        p.h(fVar, "view");
        AppMethodBeat.i(119153);
        this.FqU = fVar;
        AppMethodBeat.o(119153);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.g.a$a  reason: collision with other inner class name */
    public static final class C1761a {
        private C1761a() {
        }

        public /* synthetic */ C1761a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119154);
        AppMethodBeat.o(119154);
    }

    public final void Km(long j2) {
        AppMethodBeat.i(119146);
        j.b bVar = j.Fmy;
        k foc = j.b.foc();
        j.b bVar2 = j.Fmy;
        j.b.fol();
        this.FqS = foc.ab(j2, o.a.aSa(this.mRa));
        if (this.FqQ != 0) {
            this.FqS = this.FqS < this.FqQ ? this.FqS : this.FqQ;
        }
        Log.d(TAG, "localMinId=" + this.FqS + ", respMaxId=" + this.FqQ);
        AppMethodBeat.o(119146);
    }

    @Override // com.tencent.mm.plugin.story.d.a.e
    public final void onCreate(String str) {
        AppMethodBeat.i(119147);
        p.h(str, "userName");
        this.mRa = str;
        Km(this.FqR);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(191, this);
        com.tencent.mm.kernel.b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().a(3926, this);
        com.tencent.mm.kernel.b aAg3 = g.aAg();
        p.g(aAg3, "MMKernel.network()");
        aAg3.azz().a(764, this);
        AppMethodBeat.o(119147);
    }

    @Override // com.tencent.mm.plugin.story.d.a.e
    public final void fib() {
        AppMethodBeat.i(119148);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(191, this);
        com.tencent.mm.kernel.b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(3926, this);
        com.tencent.mm.kernel.b aAg3 = g.aAg();
        p.g(aAg3, "MMKernel.network()");
        aAg3.azz().b(764, this);
        AppMethodBeat.o(119148);
    }

    @Override // com.tencent.mm.plugin.story.d.a.e
    public final void fnz() {
        AppMethodBeat.i(119149);
        j.b bVar = j.Fmy;
        j.b.eJP().post(new b(this));
        AppMethodBeat.o(119149);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ a FqW;

        b(a aVar) {
            this.FqW = aVar;
        }

        public final void run() {
            AppMethodBeat.i(119141);
            ArrayList arrayList = new ArrayList();
            j.b bVar = j.Fmy;
            List<com.tencent.mm.plugin.story.i.j> a2 = k.a(j.b.foc(), this.FqW.mRa, this.FqW.FqS);
            if (!a2.isEmpty()) {
                this.FqW.FqR = ((com.tencent.mm.plugin.story.i.j) kotlin.a.j.ku(a2)).field_storyID;
            }
            ArrayList arrayList2 = new ArrayList();
            for (com.tencent.mm.plugin.story.i.j jVar : a2) {
                j.b bVar2 = j.Fmy;
                com.tencent.mm.plugin.story.i.i foh = j.b.foh();
                a.C1747a aVar = com.tencent.mm.plugin.story.e.a.Flw;
                h aSy = foh.aSy(a.C1747a.n(Integer.valueOf(jVar.field_createTime)));
                C1761a aVar2 = a.FqV;
                Log.d(a.TAG, new StringBuilder("loadDBData rawLocalId=").append((int) jVar.systemRowid).append(" rawStoryId=").append(jVar.field_storyID).append(" date=").append(aSy != null ? aSy.frD() : null).append(" count=").append(aSy != null ? Integer.valueOf(aSy.field_count) : null).toString());
                if (aSy != null) {
                    j.b bVar3 = j.Fmy;
                    com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba((int) jVar.systemRowid);
                    if (aba == null) {
                        aba = new com.tencent.mm.plugin.story.i.j();
                    }
                    p.h(aba, "<set-?>");
                    aSy.Fqr = aba;
                    if (!arrayList2.contains(aSy.frD())) {
                        arrayList.add(aSy);
                        arrayList2.add(aSy.frD());
                    }
                }
            }
            C1761a aVar3 = a.FqV;
            Log.d(a.TAG, "localCachedMinId=" + this.FqW.FqR + " infos.size=" + arrayList.size() + " localMinId=" + this.FqW.FqS);
            final List a3 = a.a(this.FqW, arrayList);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.story.g.a.b.AnonymousClass1 */
                final /* synthetic */ b FqX;

                {
                    this.FqX = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(119140);
                    this.FqX.FqW.FqU.hh(a3);
                    x xVar = x.SXb;
                    AppMethodBeat.o(119140);
                    return xVar;
                }
            });
            AppMethodBeat.o(119141);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ a FqW;

        c(a aVar) {
            this.FqW = aVar;
        }

        public final void run() {
            AppMethodBeat.i(119142);
            C1761a aVar = a.FqV;
            Log.i(a.TAG, "loadFpData username=" + this.FqW.mRa + " maxId=" + this.FqW.FqQ);
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            t azz = aAg.azz();
            String str = this.FqW.mRa;
            long j2 = this.FqW.FqQ;
            String str2 = this.FqW.mRa;
            j.b bVar = j.Fmy;
            azz.b(new com.tencent.mm.plugin.story.f.a.e(str, j2, Util.isEqual(str2, j.b.fau())));
            AppMethodBeat.o(119142);
        }
    }

    @Override // com.tencent.mm.plugin.story.d.a.e
    public final void fnx() {
        AppMethodBeat.i(119150);
        j.b bVar = j.Fmy;
        j.b.eJP().post(new c(this));
        AppMethodBeat.o(119150);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ a FqW;

        d(a aVar) {
            this.FqW = aVar;
        }

        public final void run() {
            AppMethodBeat.i(119143);
            C1761a aVar = a.FqV;
            Log.i(a.TAG, "loadNpData username=" + this.FqW.mRa + " maxId=" + this.FqW.FqQ);
            if (this.FqW.FqT == 0 && !this.FqW.qhf) {
                this.FqW.FqT++;
                com.tencent.mm.kernel.b aAg = g.aAg();
                p.g(aAg, "MMKernel.network()");
                t azz = aAg.azz();
                String str = this.FqW.mRa;
                long j2 = this.FqW.FqQ;
                String str2 = this.FqW.mRa;
                j.b bVar = j.Fmy;
                azz.b(new com.tencent.mm.plugin.story.f.a.e(str, j2, Util.isEqual(str2, j.b.fau())));
            }
            AppMethodBeat.o(119143);
        }
    }

    @Override // com.tencent.mm.plugin.story.d.a.e
    public final void fnw() {
        AppMethodBeat.i(119151);
        j.b bVar = j.Fmy;
        j.b.eJP().post(new d(this));
        AppMethodBeat.o(119151);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r7, int r8, java.lang.String r9, com.tencent.mm.ak.q r10) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.g.a.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ a FqW;

        e(a aVar) {
            this.FqW = aVar;
        }

        public final void run() {
            AppMethodBeat.i(119144);
            this.FqW.Km(this.FqW.FqR);
            this.FqW.fnz();
            AppMethodBeat.o(119144);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ a FqW;

        f(a aVar) {
            this.FqW = aVar;
        }

        public final void run() {
            AppMethodBeat.i(119145);
            this.FqW.Km(this.FqW.FqR);
            this.FqW.fnz();
            AppMethodBeat.o(119145);
        }
    }

    public static final /* synthetic */ List a(a aVar, List list) {
        AppMethodBeat.i(119155);
        ArrayList arrayList = new ArrayList();
        aVar.FqP.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            a.C1747a aVar2 = com.tencent.mm.plugin.story.e.a.Flw;
            CharSequence aRL = a.C1747a.aRL(hVar.frD());
            Log.d(TAG, "key=" + aRL + " info.date=" + hVar.frD() + " info.count=" + hVar.field_count);
            ArrayList<h> arrayList2 = aVar.FqP.get(aRL.toString());
            if (arrayList2 == null) {
                ArrayList<h> arrayList3 = new ArrayList<>();
                aVar.FqP.put(aRL.toString(), arrayList3);
                arrayList2 = arrayList3;
            }
            arrayList2.add(hVar);
        }
        for (Map.Entry<String, ArrayList<h>> entry : aVar.FqP.entrySet()) {
            com.tencent.mm.plugin.story.ui.album.c cVar = new com.tencent.mm.plugin.story.ui.album.c(entry.getKey(), entry.getValue());
            Log.i(TAG, String.valueOf(cVar));
            arrayList.add(cVar);
        }
        ArrayList arrayList4 = arrayList;
        AppMethodBeat.o(119155);
        return arrayList4;
    }
}
