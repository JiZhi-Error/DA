package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J,\u0010 \u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "isRunning", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reloadFp", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class k implements i, a.AbstractC1746a {
    public static final a FsL = new a((byte) 0);
    private static final String TAG = TAG;
    private long FqQ;
    private long FqR;
    private long FqS;
    private int FsJ = 1;
    final a.b FsK;
    private boolean isRunning;
    private String mRa = "";
    private boolean qhf;

    public k(a.b bVar) {
        p.h(bVar, "view");
        AppMethodBeat.i(119337);
        this.FsK = bVar;
        AppMethodBeat.o(119337);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119338);
        AppMethodBeat.o(119338);
    }

    @Override // com.tencent.mm.plugin.story.d.a.AbstractC1746a
    public final void onCreate(String str) {
        AppMethodBeat.i(119330);
        p.h(str, "userName");
        this.mRa = str;
        Km(this.FqR);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(273, this);
        com.tencent.mm.kernel.b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().a(764, this);
        AppMethodBeat.o(119330);
    }

    public final void Km(long j2) {
        AppMethodBeat.i(119331);
        j.b bVar = j.Fmy;
        com.tencent.mm.plugin.story.i.k foc = j.b.foc();
        String str = this.mRa;
        j.b bVar2 = j.Fmy;
        boolean isEqual = Util.isEqual(j.b.fau(), this.mRa);
        j.b bVar3 = j.Fmy;
        j.b.fol();
        a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
        this.FqS = foc.a(j2, str, isEqual, com.tencent.mm.plugin.story.i.a.FuN);
        Log.d(TAG, "localMinId=" + this.FqS + ", respMaxId=" + this.FqQ);
        AppMethodBeat.o(119331);
    }

    @Override // com.tencent.mm.plugin.story.d.a.AbstractC1746a
    public final void fib() {
        AppMethodBeat.i(119332);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(273, this);
        com.tencent.mm.kernel.b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(764, this);
        AppMethodBeat.o(119332);
    }

    @Override // com.tencent.mm.plugin.story.d.a.AbstractC1746a
    public final void fnw() {
        AppMethodBeat.i(119333);
        if (!this.isRunning) {
            this.FsJ--;
            Log.i(TAG, "loadNpData username=" + this.mRa + " maxId=" + this.FqQ);
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
                azz.b(new com.tencent.mm.plugin.story.f.a.i(str, j2, isEqual, "", com.tencent.mm.plugin.story.i.a.FvB));
            }
        }
        AppMethodBeat.o(119333);
    }

    @Override // com.tencent.mm.plugin.story.d.a.AbstractC1746a
    public final void fnx() {
        AppMethodBeat.i(119334);
        if (!this.isRunning) {
            this.isRunning = true;
            Log.i(TAG, "loadFpData username=" + this.mRa + " maxId=" + this.FqQ);
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            t azz = aAg.azz();
            String str = this.mRa;
            String str2 = this.mRa;
            j.b bVar = j.Fmy;
            boolean isEqual = Util.isEqual(str2, j.b.fau());
            a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
            azz.b(new com.tencent.mm.plugin.story.f.a.i(str, 0, isEqual, "", com.tencent.mm.plugin.story.i.a.FvB));
        }
        AppMethodBeat.o(119334);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ k FsM;

        b(k kVar) {
            this.FsM = kVar;
        }

        public final void run() {
            AppMethodBeat.i(119327);
            final ArrayList arrayList = new ArrayList();
            final z.f fVar = new z.f();
            j.b bVar = j.Fmy;
            com.tencent.mm.plugin.story.i.k foc = j.b.foc();
            String str = this.FsM.mRa;
            String str2 = this.FsM.mRa;
            j.b bVar2 = j.Fmy;
            fVar.SYG = (T) com.tencent.mm.plugin.story.i.k.a(foc, str, Util.isEqual(str2, j.b.fau()), this.FsM.FqS);
            if (!fVar.SYG.isEmpty()) {
                this.FsM.FqR = ((com.tencent.mm.plugin.story.i.j) kotlin.a.j.ku(fVar.SYG)).field_storyID;
            } else {
                j.b bVar3 = j.Fmy;
                com.tencent.mm.plugin.story.i.k foc2 = j.b.foc();
                String str3 = this.FsM.mRa;
                String str4 = this.FsM.mRa;
                j.b bVar4 = j.Fmy;
                arrayList.addAll(foc2.cw(str3, Util.isEqual(str4, j.b.fau())));
            }
            a aVar = k.FsL;
            Log.d(k.TAG, "localCachedMinId=" + this.FsM.FqR + " infos.size=" + fVar.SYG.size() + " localMinId=" + this.FsM.FqS);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.story.g.k.b.AnonymousClass1 */
                final /* synthetic */ b FsN;

                {
                    this.FsN = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(119326);
                    this.FsN.FsM.FsK.o(fVar.SYG, arrayList.isEmpty());
                    x xVar = x.SXb;
                    AppMethodBeat.o(119326);
                    return xVar;
                }
            });
            AppMethodBeat.o(119327);
        }
    }

    @Override // com.tencent.mm.plugin.story.d.a.AbstractC1746a
    public final void fny() {
        AppMethodBeat.i(119335);
        j.b bVar = j.Fmy;
        j.b.eJP().post(new b(this));
        AppMethodBeat.o(119335);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ k FsM;

        c(k kVar) {
            this.FsM = kVar;
        }

        public final void run() {
            AppMethodBeat.i(119328);
            this.FsM.Km(this.FsM.FqR);
            this.FsM.fny();
            if (this.FsM.FsJ > 0) {
                this.FsM.fnw();
            }
            AppMethodBeat.o(119328);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ k FsM;

        d(k kVar) {
            this.FsM = kVar;
        }

        public final void run() {
            AppMethodBeat.i(119329);
            this.FsM.Km(this.FsM.FqR);
            this.FsM.fny();
            if (this.FsM.FsJ > 0) {
                this.FsM.fnw();
            }
            AppMethodBeat.o(119329);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c9  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
        /*
        // Method dump skipped, instructions count: 407
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.g.k.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }
}
