package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.p;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0011\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J,\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020\u0019H\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", ch.COL_LOCALID, "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", ClientInfoTable.Columns.CLIENTID, "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"})
public final class a extends com.tencent.mm.loader.g.c implements i {
    public static final C1757a Fqs = new C1757a((byte) 0);
    private final g Fqq = new g();
    j Fqr;
    private final HashSet<k> listeners = new HashSet<>();
    private final com.tencent.mm.loader.g.d<e> vSA;

    static {
        AppMethodBeat.i(119094);
        AppMethodBeat.o(119094);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Exception, x> {
        final /* synthetic */ a Fqt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(1);
            this.Fqt = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Exception exc) {
            AppMethodBeat.i(119081);
            Exception exc2 = exc;
            p.h(exc2, LocaleUtil.ITALIAN);
            a aVar = this.Fqt;
            a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
            a.a(aVar, com.tencent.mm.plugin.story.i.a.Fvi, "MediaPostInfo parser error:" + exc2.getMessage());
            x xVar = x.SXb;
            AppMethodBeat.o(119081);
            return xVar;
        }
    }

    public a(j jVar, com.tencent.mm.loader.g.d<e> dVar) {
        p.h(jVar, "storyInfo");
        p.h(dVar, "uploadQueue");
        AppMethodBeat.i(119093);
        this.Fqr = jVar;
        this.vSA = dVar;
        AppMethodBeat.o(119093);
    }

    public static final /* synthetic */ edu a(a aVar) {
        AppMethodBeat.i(119095);
        edu fps = aVar.fps();
        AppMethodBeat.o(119095);
        return fps;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/upload/PostTask$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.g.a$a  reason: collision with other inner class name */
    public static final class C1757a {
        private C1757a() {
        }

        public /* synthetic */ C1757a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    public static final class g implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c> {
        g() {
        }

        @Override // com.tencent.mm.loader.g.f
        public final void a(com.tencent.mm.loader.g.c cVar, com.tencent.mm.loader.g.j jVar) {
            AppMethodBeat.i(119086);
            p.h(cVar, "task");
            p.h(jVar, "status");
            AppMethodBeat.o(119086);
        }
    }

    private final edu fps() {
        AppMethodBeat.i(119087);
        com.tencent.mm.bw.a parseFrom = new edu().parseFrom(this.Fqr.field_postBuf);
        if (parseFrom == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
            AppMethodBeat.o(119087);
            throw tVar;
        }
        edu edu = (edu) parseFrom;
        j jVar = this.Fqr;
        byte[] byteArray = edu.toByteArray();
        p.g(byteArray, "postInfo.toByteArray()");
        jVar.setPostBuf(byteArray);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foc().a((int) this.Fqr.systemRowid, this.Fqr);
        AppMethodBeat.o(119087);
        return edu;
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        String str;
        AppMethodBeat.i(119088);
        edu edu = (edu) com.tencent.mm.ac.d.a(new edu(), this.Fqr.field_postBuf, new b(this));
        if (edu != null) {
            if (com.tencent.mm.plugin.story.i.j.isTimeLimit(edu.ibG, edu.MsZ)) {
                a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
                cy(com.tencent.mm.plugin.story.i.a.Fvm, "this item isTimeLimit");
                Log.i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + ((int) this.Fqr.systemRowid) + " is die count " + edu.ibG + " time: " + edu.MsZ);
                AppMethodBeat.o(119088);
                return;
            }
            int i2 = edu.Mpa;
            a.g gVar = a.g.FvU;
            if (i2 == a.g.frs()) {
                edu fps = fps();
                if (com.tencent.mm.plugin.story.i.j.isTimeLimit(fps.ibG, fps.MsZ)) {
                    a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
                    cy(com.tencent.mm.plugin.story.i.a.Fvm, "this item isTimeLimit");
                    Log.i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + ((int) this.Fqr.systemRowid) + " is die ");
                    AppMethodBeat.o(119088);
                    return;
                }
                eek frG = this.Fqr.frG();
                p.a aVar3 = com.tencent.mm.plugin.story.f.p.FmN;
                String a2 = p.a.a(frG, fps);
                Log.i("MicroMsg.StoryPostTask", "startPost content " + a2 + "  testValue " + ac.jPI);
                if (kotlin.g.b.p.j(a2, "")) {
                    a.C1768a aVar4 = com.tencent.mm.plugin.story.i.a.FvD;
                    cy(com.tencent.mm.plugin.story.i.a.Fvl, "content is error");
                    AppMethodBeat.o(119088);
                    return;
                }
                if (ac.jPI) {
                    str = "<Test>Android Test Fail</Test>";
                } else {
                    str = a2;
                }
                String str2 = fps.izX;
                kotlin.g.b.p.g(str2, "postInfo.ClientId");
                com.tencent.mm.ac.d.h(new e(this, str, str2));
                AppMethodBeat.o(119088);
                return;
            }
            a.g gVar2 = a.g.FvU;
            this.vSA.a(new e(this.Fqr), new f(this));
        }
        AppMethodBeat.o(119088);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/story/model/upload/PostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    public static final class f implements com.tencent.mm.loader.g.f<e> {
        final /* synthetic */ a Fqt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(a aVar) {
            this.Fqt = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(e eVar, com.tencent.mm.loader.g.j jVar) {
            AppMethodBeat.i(119085);
            kotlin.g.b.p.h(eVar, "task");
            kotlin.g.b.p.h(jVar, "status");
            if (jVar == com.tencent.mm.loader.g.j.OK) {
                this.Fqt.call();
                AppMethodBeat.o(119085);
                return;
            }
            this.Fqt.a(com.tencent.mm.loader.g.j.Wait);
            AppMethodBeat.o(119085);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(119089);
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg, "MMKernel.network()");
        aAg.azz().b(351, this);
        a(com.tencent.mm.loader.g.j.OK);
        AppMethodBeat.o(119089);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(119090);
        String valueOf = String.valueOf((int) this.Fqr.systemRowid);
        AppMethodBeat.o(119090);
        return valueOf;
    }

    static /* synthetic */ void a(a aVar, int i2, String str) {
        AppMethodBeat.i(119092);
        aVar.cy(i2, str);
        AppMethodBeat.o(119092);
    }

    private final void cy(int i2, String str) {
        AppMethodBeat.i(119091);
        Log.i("MicroMsg.StoryPostTask", "processError localId " + ((int) this.Fqr.systemRowid) + " processError " + i2 + " errMsg: " + str);
        f fVar = f.FqO;
        f.a(this.Fqr, i2, str, new c(this));
        AppMethodBeat.o(119091);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Fqt;
        final /* synthetic */ String Fqv;
        final /* synthetic */ String grJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar, String str, String str2) {
            super(0);
            this.Fqt = aVar;
            this.grJ = str;
            this.Fqv = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119084);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            if (j.b.isInValid()) {
                Log.e("MicroMsg.StoryPostTask", "is invalid to getstoryInfoStorage");
            } else {
                edu a2 = a.a(this.Fqt);
                a2.ibG++;
                com.tencent.mm.plugin.story.i.j jVar = this.Fqt.Fqr;
                byte[] byteArray = a2.toByteArray();
                kotlin.g.b.p.g(byteArray, "postInfo.toByteArray()");
                jVar.setPostBuf(byteArray);
                j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.foc().a((int) this.Fqt.Fqr.systemRowid, this.Fqt.Fqr);
                j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                if (j.b.foc().aSA(new StringBuilder().append((int) this.Fqt.Fqr.systemRowid).append('_').append(this.Fqt.Fqr.field_createTime).toString())) {
                    this.Fqt.a(com.tencent.mm.loader.g.j.OK);
                } else {
                    com.tencent.mm.plugin.story.f.a.g gVar = new com.tencent.mm.plugin.story.f.a.g(this.grJ, this.Fqv, (int) this.Fqt.Fqr.systemRowid, this.Fqt.Fqr.avv(), this.Fqt.Fqr.frE());
                    com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
                    kotlin.g.b.p.g(aAg, "MMKernel.network()");
                    aAg.azz().a(351, this.Fqt);
                    com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
                    kotlin.g.b.p.g(aAg2, "MMKernel.network()");
                    aAg2.azz().b(gVar);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119084);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Fqt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(0);
            this.Fqt = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119082);
            this.Fqt.a(com.tencent.mm.loader.g.j.Fail);
            a.a(this.Fqt, (int) this.Fqt.Fqr.systemRowid);
            x xVar = x.SXb;
            AppMethodBeat.o(119082);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Fqt;
        final /* synthetic */ int Fqu;
        final /* synthetic */ boolean vSM = false;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar, int i2) {
            super(0);
            this.Fqt = aVar;
            this.Fqu = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119083);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            if (j.b.isInValid()) {
                Log.e("MicroMsg.StoryPostTask", "is invalid to getstoryInfoStorage");
            } else {
                Iterator it = this.Fqt.listeners.iterator();
                while (it.hasNext()) {
                    k kVar = (k) it.next();
                    if (kVar != null) {
                        kVar.fnh();
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119083);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(119096);
        com.tencent.mm.ac.d.h(new d(aVar, i2));
        AppMethodBeat.o(119096);
    }
}
