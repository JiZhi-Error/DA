package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J,\u0010#\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\t2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0016\u0010'\u001a\u00020\u001a2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/StoryFavSelectPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "MAX_COUNT", "", "TAG", "", "isRunning", "", "loadNpCount", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "first", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateLocalMinId", "lastId", "plugin-story_release"})
public final class l implements i, a.c {
    private long FqQ;
    long FqR;
    long FqS;
    int FsJ;
    final a.d FsP;
    private final int MAX_COUNT = 20;
    final String TAG = "MicroMsg.StoryFavSelectPresenter";
    private boolean isRunning;
    String mRa = "";
    private boolean qhf;

    public l(a.d dVar) {
        p.h(dVar, "view");
        AppMethodBeat.i(119352);
        this.FsP = dVar;
        AppMethodBeat.o(119352);
    }

    /* access modifiers changed from: package-private */
    public final void Km(long j2) {
        AppMethodBeat.i(119344);
        j.b bVar = j.Fmy;
        k foc = j.b.foc();
        j.b bVar2 = j.Fmy;
        j.b.fol();
        p.h(this.mRa, "userName");
        a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
        int i2 = com.tencent.mm.plugin.story.i.a.FuO;
        String str = this.mRa;
        String str2 = this.mRa;
        j.b bVar3 = j.Fmy;
        this.FqS = foc.c(j2, i2, str, Util.isEqual(str2, j.b.fau()));
        if (this.FqQ != 0) {
            this.FqS = this.FqS < this.FqQ ? this.FqS : this.FqQ;
        }
        Log.d(this.TAG, "localMinId=" + this.FqS + ", respMaxId=" + this.FqQ);
        AppMethodBeat.o(119344);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ l FsQ;

        b(l lVar) {
            this.FsQ = lVar;
        }

        public final void run() {
            AppMethodBeat.i(119341);
            this.FsQ.Km(this.FsQ.FqR);
            this.FsQ.vL(false);
            if (this.FsQ.FsJ > 0) {
                this.FsQ.fnw();
            }
            AppMethodBeat.o(119341);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ l FsQ;

        c(l lVar) {
            this.FsQ = lVar;
        }

        public final void run() {
            AppMethodBeat.i(119342);
            this.FsQ.Km(this.FsQ.FqR);
            this.FsQ.vL(false);
            if (this.FsQ.FsJ > 0) {
                this.FsQ.fnw();
            }
            AppMethodBeat.o(119342);
        }
    }

    @Override // com.tencent.mm.plugin.story.d.a.c
    public final void onCreate(String str) {
        AppMethodBeat.i(119345);
        p.h(str, "userName");
        this.mRa = str;
        Km(this.FqR);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(273, this);
        AppMethodBeat.o(119345);
    }

    @Override // com.tencent.mm.plugin.story.d.a.c
    public final void fib() {
        AppMethodBeat.i(119346);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(273, this);
        AppMethodBeat.o(119346);
    }

    @Override // com.tencent.mm.plugin.story.d.a.c
    public final void vL(boolean z) {
        AppMethodBeat.i(119347);
        j.b bVar = j.Fmy;
        j.b.eJP().post(new a(this, z));
        AppMethodBeat.o(119347);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ l FsQ;
        final /* synthetic */ boolean FsR;

        a(l lVar, boolean z) {
            this.FsQ = lVar;
            this.FsR = z;
        }

        public final void run() {
            AppMethodBeat.i(119340);
            j.b bVar = j.Fmy;
            List<com.tencent.mm.plugin.story.i.j> a2 = k.a(j.b.foc(), this.FsQ.FqS);
            if (!a2.isEmpty()) {
                this.FsQ.FqR = ((com.tencent.mm.plugin.story.i.j) kotlin.a.j.ku(a2)).field_storyID;
            }
            Log.d(this.FsQ.TAG, "localCachedMinId=" + this.FsQ.FqR + " infos.size=" + a2.size() + " localMinId=" + this.FsQ.FqS);
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            if (this.FsR) {
                j.b bVar2 = j.Fmy;
                k foc = j.b.foc();
                j.b bVar3 = j.Fmy;
                arrayList2.addAll(foc.cy(j.b.fau(), true));
            }
            for (com.tencent.mm.plugin.story.i.j jVar : a2) {
                if (jVar.field_storyID != 0 && !jVar.frJ()) {
                    arrayList.add(jVar);
                }
            }
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.story.g.l.a.AnonymousClass1 */
                final /* synthetic */ a FsS;

                {
                    this.FsS = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(119339);
                    if (this.FsS.FsR) {
                        this.FsS.FsQ.FsP.t(arrayList, arrayList2);
                    } else {
                        this.FsS.FsQ.FsP.hr(arrayList);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(119339);
                    return xVar;
                }
            });
            AppMethodBeat.o(119340);
        }
    }

    @Override // com.tencent.mm.plugin.story.d.a.c
    public final void fnw() {
        AppMethodBeat.i(119348);
        if (!this.isRunning) {
            this.FsJ--;
            Log.i(this.TAG, "loadNpData username=" + this.mRa + " maxId=" + this.FqQ);
            if (!this.qhf) {
                this.isRunning = true;
                com.tencent.mm.kernel.b aAg = g.aAg();
                p.g(aAg, "MMKernel.network()");
                t azz = aAg.azz();
                String str = this.mRa;
                long j2 = this.FqQ;
                String str2 = this.mRa;
                j.b bVar = j.Fmy;
                boolean isEqual = Util.isEqual(str2, j.b.fau());
                a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
                azz.b(new com.tencent.mm.plugin.story.f.a.i(str, j2, isEqual, "", com.tencent.mm.plugin.story.i.a.FvA));
                AppMethodBeat.o(119348);
                return;
            }
        } else {
            Log.i(this.TAG, "loadNpData is running");
        }
        AppMethodBeat.o(119348);
    }

    @Override // com.tencent.mm.plugin.story.d.a.c
    public final void fnx() {
        AppMethodBeat.i(119349);
        if (!this.isRunning) {
            this.isRunning = true;
            Log.i(this.TAG, "loadFpData username=" + this.mRa + " maxId=" + this.FqQ);
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            t azz = aAg.azz();
            String str = this.mRa;
            String str2 = this.mRa;
            j.b bVar = j.Fmy;
            boolean isEqual = Util.isEqual(str2, j.b.fau());
            a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
            azz.b(new com.tencent.mm.plugin.story.f.a.i(str, 0, isEqual, "", com.tencent.mm.plugin.story.i.a.FvA));
            AppMethodBeat.o(119349);
            return;
        }
        Log.i(this.TAG, "loadFpData is running");
        AppMethodBeat.o(119349);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x013d  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r11, int r12, java.lang.String r13, com.tencent.mm.ak.q r14) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.g.l.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ l FsQ;
        final /* synthetic */ List FsV;

        d(l lVar, List list) {
            this.FsQ = lVar;
            this.FsV = list;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0027 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x006b A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 398
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.g.l.d.run():void");
        }
    }

    @Override // com.tencent.mm.plugin.story.d.a.c
    public final void hq(List<com.tencent.mm.plugin.story.i.j> list) {
        AppMethodBeat.i(119351);
        p.h(list, "storyList");
        j.b bVar = j.Fmy;
        j.b.eJP().post(new d(this, list));
        AppMethodBeat.o(119351);
    }
}
