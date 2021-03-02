package com.tencent.mm.plugin.story.f.g;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\n\u0010\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0018\u001a\u00020\bH\u0002J\u0006\u0010\u0019\u001a\u00020\bJ\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u0015\u001a\u00020\bJ,\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010(\u001a\u00020\bJ\u0010\u0010)\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010,\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onFakeDataUpdateCallback", "Lkotlin/Function0;", "", "postCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1;", "uploadQueue", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "addFakeDataListener", "onFakeDataUpdate", "addPostEndListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "checkMixStory", "checkPost", "notifyEndPost", ch.COL_LOCALID, "", "isOk", "", "notifyEventPost", "notifyStartPost", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFakeDataListener", "removePostEndListener", "start", "startPost", "stop", "Companion", "plugin-story_release"})
public final class c implements i {
    public static final a FqD = new a((byte) 0);
    public kotlin.g.a.a<x> FqA;
    public final f FqB = new f(this);
    public final h FqC = new h();
    public com.tencent.mm.loader.g.d<a> ibn = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte) 0), 1, "storyPost"));
    private final HashSet<k> listeners = new HashSet<>();
    public com.tencent.mm.loader.g.d<e> vSA = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte) 0), 1, "storyUpload"));

    static {
        AppMethodBeat.i(119119);
        AppMethodBeat.o(119119);
    }

    public c() {
        AppMethodBeat.i(119118);
        AppMethodBeat.o(119118);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/upload/UploadManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    public static final class f implements com.tencent.mm.loader.g.f<a> {
        final /* synthetic */ c FqE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(c cVar) {
            this.FqE = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(a aVar, j jVar) {
            AppMethodBeat.i(119108);
            a aVar2 = aVar;
            p.h(aVar2, "task");
            p.h(jVar, "status");
            if (jVar == j.OK) {
                this.FqE.checkPost();
                AppMethodBeat.o(119108);
                return;
            }
            c.a(this.FqE, (int) aVar2.Fqr.systemRowid);
            AppMethodBeat.o(119108);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    public static final class h implements com.tencent.mm.loader.g.f<e> {
        h() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(e eVar, j jVar) {
            AppMethodBeat.i(119110);
            p.h(eVar, "task");
            p.h(jVar, "status");
            AppMethodBeat.o(119110);
        }
    }

    public final void ac(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(119112);
        p.h(aVar, "onFakeDataUpdate");
        this.FqA = aVar;
        AppMethodBeat.o(119112);
    }

    public final void fpv() {
        AppMethodBeat.i(119113);
        kotlin.g.a.a<x> aVar = this.FqA;
        if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(119113);
            return;
        }
        AppMethodBeat.o(119113);
    }

    public final void a(k kVar) {
        AppMethodBeat.i(119114);
        com.tencent.mm.ac.d.h(new b(this, kVar));
        AppMethodBeat.o(119114);
    }

    public final void b(k kVar) {
        AppMethodBeat.i(119115);
        com.tencent.mm.ac.d.h(new g(this, kVar));
        AppMethodBeat.o(119115);
    }

    private final void aY(int i2, boolean z) {
        AppMethodBeat.i(119116);
        com.tencent.mm.ac.d.h(new C1758c(this, i2, z));
        AppMethodBeat.o(119116);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        q qVar2;
        AppMethodBeat.i(119117);
        if (!(qVar instanceof com.tencent.mm.plugin.story.f.a.g)) {
            qVar2 = null;
        } else {
            qVar2 = qVar;
        }
        com.tencent.mm.plugin.story.f.a.g gVar = (com.tencent.mm.plugin.story.f.a.g) qVar2;
        if (gVar != null) {
            if (i2 == 4 || i3 == 0) {
                aY(gVar.ecf, true);
                try {
                    j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(gVar.ecf);
                    if (aba != null) {
                        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                        com.tencent.mm.plugin.story.h.h.aaU(gVar.ecf).xh(String.valueOf(aba.field_storyID));
                        com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
                        com.tencent.mm.plugin.story.h.h.aaU(gVar.ecf).xg(aba.frG().NeB.LoV.get(0).Url);
                        com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
                        com.tencent.mm.plugin.story.h.h.aaU(gVar.ecf).sX(Util.nowMilliSecond());
                        com.tencent.mm.plugin.story.h.h hVar4 = com.tencent.mm.plugin.story.h.h.FuH;
                        com.tencent.mm.plugin.story.h.h.aaV(gVar.ecf);
                        x xVar = x.SXb;
                        AppMethodBeat.o(119117);
                        return;
                    }
                    AppMethodBeat.o(119117);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.StoryUploadTask", e2, "upload error", new Object[0]);
                    x xVar2 = x.SXb;
                    AppMethodBeat.o(119117);
                    return;
                }
            } else {
                aY(gVar.ecf, false);
            }
        }
        AppMethodBeat.o(119117);
    }

    public final void checkPost() {
        AppMethodBeat.i(119111);
        com.tencent.mm.plugin.story.f.e.a aVar = com.tencent.mm.plugin.story.f.e.a.Fpl;
        com.tencent.mm.plugin.story.f.e.a.fpa();
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.j frP = j.b.foc().frP();
        if (frP == null) {
            Log.d("MicroMsg.StoryUploadTask", "All has post");
            AppMethodBeat.o(119111);
            return;
        }
        Log.d("MicroMsg.StoryUploadTask", "checking story from db, will post: " + frP.field_storyID + ' ' + ((int) frP.systemRowid) + ' ' + frP.field_userName + ' ' + frP.frI().ibG);
        this.ibn.c(new a(frP, this.vSA));
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.aaU((int) frP.systemRowid).sW(Util.nowMilliSecond());
        com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.aaU((int) frP.systemRowid).sY((long) NetStatusUtil.getIOSNetType(MMApplicationContext.getContext()));
        AppMethodBeat.o(119111);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ c FqE;
        final /* synthetic */ k FqF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, k kVar) {
            super(0);
            this.FqE = cVar;
            this.FqF = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119104);
            if (this.FqF != null) {
                this.FqE.listeners.add(this.FqF);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119104);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ c FqE;
        final /* synthetic */ k FqF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(c cVar, k kVar) {
            super(0);
            this.FqE = cVar;
            this.FqF = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119109);
            if (this.FqF != null) {
                this.FqE.listeners.remove(this.FqF);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119109);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ c FqE;
        final /* synthetic */ int Fqu;
        final /* synthetic */ boolean vSM = false;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar, int i2) {
            super(0);
            this.FqE = cVar;
            this.Fqu = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119106);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            if (j.b.isInValid()) {
                Log.e("MicroMsg.StoryUploadTask", "is invalid to getSnsInfoStorage");
            } else {
                for (k kVar : this.FqE.listeners) {
                    kVar.fni();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119106);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.g.c$c  reason: collision with other inner class name */
    public static final class C1758c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ c FqE;
        final /* synthetic */ int Fqu;
        final /* synthetic */ boolean vSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1758c(c cVar, int i2, boolean z) {
            super(0);
            this.FqE = cVar;
            this.Fqu = i2;
            this.vSM = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119105);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            if (j.b.isInValid()) {
                Log.e("MicroMsg.StoryUploadTask", "is invalid to getSnsInfoStorage");
            } else {
                for (k kVar : this.FqE.listeners) {
                    kVar.fnh();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119105);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ c FqE;
        final /* synthetic */ int Fqu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(c cVar, int i2) {
            super(0);
            this.FqE = cVar;
            this.Fqu = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119107);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            if (j.b.isInValid()) {
                Log.e("MicroMsg.StoryUploadTask", "is invalid to getSnsInfoStorage");
            } else {
                for (k kVar : this.FqE.listeners) {
                    kVar.aaE(this.Fqu);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119107);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(c cVar, int i2) {
        AppMethodBeat.i(119120);
        com.tencent.mm.ac.d.h(new d(cVar, i2));
        AppMethodBeat.o(119120);
    }
}
