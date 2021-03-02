package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;
import kotlin.x;

public final class g {
    private static final g vSH = new g();
    private static boolean vSI;
    public static final a vSJ = new a((byte) 0);
    public final String TAG = "Finder.LogPost.FinderPostManager";
    public com.tencent.mm.loader.g.d<h> ibn = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte) 0), 1, "finderPost"));
    private final HashSet<q> listeners = new HashSet<>();
    public com.tencent.mm.loader.g.d<n> vSA = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte) 0), 1, "finderUpload"));
    public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> vSB = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte) 0), 1, "finderUploadImage"));
    com.tencent.mm.loader.g.d<c> vSC = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte) 0), 1, "finderMediaProcess"));
    com.tencent.mm.loader.g.d<r> vSD = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte) 0), 1, "mv_finderMediaProcess"));
    com.tencent.mm.loader.g.d<s> vSE = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte) 0), 1, "mv_finderUpload"));
    public final C1308g vSF = new C1308g(this);
    public final i vSG = new i();

    public g() {
        AppMethodBeat.i(167764);
        AppMethodBeat.o(167764);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(167765);
        AppMethodBeat.o(167765);
    }

    /* renamed from: com.tencent.mm.plugin.finder.upload.g$g */
    public static final class C1308g implements com.tencent.mm.loader.g.f<h> {
        final /* synthetic */ g vSK;

        C1308g(g gVar) {
            this.vSK = gVar;
        }

        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(h hVar, j jVar) {
            AppMethodBeat.i(167754);
            h hVar2 = hVar;
            p.h(hVar2, "task");
            p.h(jVar, "status");
            if (hVar2 instanceof e) {
                this.vSK.dAZ();
                AppMethodBeat.o(167754);
                return;
            }
            com.tencent.mm.kernel.g.azz().a(6649, hVar2.vSP);
            if (jVar == j.OK) {
                this.vSK.dAZ();
                AppMethodBeat.o(167754);
                return;
            }
            FinderItem finderItem = hVar2.vRO;
            FinderFeedReportObject finderFeedReportObject = finderItem.field_reportObject;
            if (finderFeedReportObject != null) {
                int dBi = (int) hVar2.dBi();
                FinderFeedReportObject finderFeedReportObject2 = finderItem.field_reportObject;
                finderFeedReportObject.postTaskCost = (finderFeedReportObject2 != null ? finderFeedReportObject2.postTaskCost : 0) + dBi;
            }
            FinderFeedReportObject finderFeedReportObject3 = finderItem.field_reportObject;
            if (finderFeedReportObject3 != null) {
                i iVar = i.vSX;
                i.a(finderFeedReportObject3, jVar == j.Fail ? "postFailed" : "postWaitRetry");
            }
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.r(finderItem);
            r.d dVar = r.d.vhx;
            r.d.od(hVar2.vRO.isLongVideo());
            this.vSK.dAZ();
            com.tencent.mm.ac.d.h(new c(this.vSK, hVar2.vRO.getLocalId()));
            AppMethodBeat.o(167754);
        }
    }

    public static final class i implements com.tencent.mm.loader.g.f<n> {
        i() {
        }

        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(n nVar, j jVar) {
            AppMethodBeat.i(167756);
            p.h(nVar, "task");
            p.h(jVar, "status");
            AppMethodBeat.o(167756);
        }
    }

    public final void t(FinderItem finderItem) {
        AppMethodBeat.i(167758);
        p.h(finderItem, "feed");
        Log.i(this.TAG, "Finder.PostLog repost " + finderItem.getLocalId());
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        FinderItem FS = c.a.FS(finderItem.getLocalId());
        if (FS != null) {
            finderItem = FS;
        }
        finderItem.setPostWaiting();
        cjm postInfo = finderItem.getPostInfo();
        postInfo.ibG = 0;
        postInfo.Mpc = 0;
        if (postInfo.Mpa == 2) {
            postInfo.Mpa = 0;
        }
        Iterator<T> it = finderItem.getMediaList().iterator();
        while (it.hasNext()) {
            cjx cjx = it.next().uOR;
            if (cjx != null) {
                cjx.retryCount = 0;
            }
        }
        Iterator<T> it2 = finderItem.getLongVideoMediaExtList().iterator();
        while (it2.hasNext()) {
            cjx cjx2 = it2.next().uOR;
            if (cjx2 != null) {
                cjx2.retryCount = 0;
            }
        }
        FinderFeedReportObject finderFeedReportObject = finderItem.field_reportObject;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.clickRepostCount++;
            i iVar = i.vSX;
            i.a(finderFeedReportObject, "clickRepost");
        }
        if (finderItem.isMvFeed()) {
            Iterator<T> it3 = finderItem.getClipListExt().iterator();
            while (it3.hasNext()) {
                Iterator<T> it4 = it3.next().getMediaList().iterator();
                while (it4.hasNext()) {
                    cjx cjx3 = it4.next().uOR;
                    if (cjx3 != null) {
                        cjx3.retryCount = 0;
                    }
                }
            }
            c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.q(finderItem);
        } else {
            c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.r(finderItem);
        }
        dAZ();
        r.d dVar = r.d.vhx;
        r.d.oa(finderItem.isLongVideo());
        r.d dVar2 = r.d.vhx;
        r.d.on(finderItem.isLongVideo());
        if (finderItem.isLongVideo()) {
            r.d dVar3 = r.d.vhx;
            r.d.doy();
        }
        EventCenter eventCenter = EventCenter.instance;
        hk hkVar = new hk();
        hkVar.dLT.localId = finderItem.getLocalId();
        hkVar.dLT.progress = finderItem.getPostInfo().Mpc;
        eventCenter.publish(hkVar);
        AppMethodBeat.o(167758);
    }

    public final void a(String str, String str2, com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c> fVar) {
        AppMethodBeat.i(261415);
        p.h(str, "path");
        p.h(str2, "userName");
        p.h(fVar, "callback");
        this.vSB.a(new m(str, str2), fVar);
        AppMethodBeat.o(261415);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003a, code lost:
        if (((java.lang.Boolean) com.tencent.mm.plugin.finder.storage.c.dtp().value()).booleanValue() != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dAZ() {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.g.dAZ():void");
    }

    public final void a(q qVar) {
        AppMethodBeat.i(167760);
        com.tencent.mm.ac.d.h(new b(this, qVar));
        AppMethodBeat.o(167760);
    }

    public final void b(q qVar) {
        AppMethodBeat.i(167761);
        com.tencent.mm.ac.d.h(new h(this, qVar));
        AppMethodBeat.o(167761);
    }

    public final void FY(long j2) {
        AppMethodBeat.i(167762);
        com.tencent.mm.ac.d.h(new d(this, j2));
        AppMethodBeat.o(167762);
    }

    public final void FZ(long j2) {
        AppMethodBeat.i(167763);
        com.tencent.mm.ac.d.h(new f(this, j2));
        AppMethodBeat.o(167763);
    }

    public static o<Integer, Integer> af(int i2, int i3, int i4) {
        int i5;
        int i6;
        AppMethodBeat.i(253079);
        if (i2 < i3) {
            if (i2 % 16 != 0) {
                i6 = i2 - (i2 % 16);
            } else {
                i6 = i2;
            }
            if (i2 > i4) {
                i3 = (int) (((float) i3) * (((float) i4) / ((float) i2)));
            } else {
                i4 = i6;
            }
            if (i3 % 16 != 0) {
                i3 -= i3 % 16;
            }
            o<Integer, Integer> oVar = new o<>(Integer.valueOf(i4), Integer.valueOf(i3));
            AppMethodBeat.o(253079);
            return oVar;
        }
        if (i3 % 16 != 0) {
            i5 = i3 - (i3 % 16);
        } else {
            i5 = i3;
        }
        if (i5 > i4) {
            i2 = (int) (((float) i2) * (((float) i4) / ((float) i3)));
        } else {
            i4 = i5;
        }
        if (i2 % 16 != 0) {
            i2 -= i2 % 16;
        }
        o<Integer, Integer> oVar2 = new o<>(Integer.valueOf(i2), Integer.valueOf(i4));
        AppMethodBeat.o(253079);
        return oVar2;
    }

    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g vSK;
        final /* synthetic */ q vSL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar, q qVar) {
            super(0);
            this.vSK = gVar;
            this.vSL = qVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(167749);
            if (this.vSL != null) {
                this.vSK.listeners.add(this.vSL);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167749);
            return xVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:187:0x05e6, code lost:
        if (com.tencent.mm.plugin.finder.storage.c.drO() != false) goto L_0x05e8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0637  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(com.tencent.mm.plugin.finder.upload.p r28) {
        /*
        // Method dump skipped, instructions count: 2631
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.g.a(com.tencent.mm.plugin.finder.upload.p):long");
    }

    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g vSK;
        final /* synthetic */ q vSL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(g gVar, q qVar) {
            super(0);
            this.vSK = gVar;
            this.vSL = qVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(167755);
            if (this.vSL != null) {
                this.vSK.listeners.remove(this.vSL);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167755);
            return xVar;
        }
    }

    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ long $localId;
        final /* synthetic */ g vSK;
        final /* synthetic */ boolean vSM = false;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar, long j2) {
            super(0);
            this.vSK = gVar;
            this.$localId = j2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(167750);
            if (!com.tencent.mm.kernel.g.aAc()) {
                Log.e(this.vSK.TAG, "is invalid to notifyEventPost");
            } else {
                for (q qVar : this.vSK.listeners) {
                    qVar.onPostNotify(this.$localId, this.vSM);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167750);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ long $localId;
        final /* synthetic */ g vSK;
        final /* synthetic */ boolean vSM = false;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(g gVar, long j2) {
            super(0);
            this.vSK = gVar;
            this.$localId = j2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(167751);
            if (!com.tencent.mm.kernel.g.aAc()) {
                Log.e(this.vSK.TAG, "is invalid to notifyPostError");
            } else {
                for (q qVar : this.vSK.listeners) {
                    Log.i(this.vSK.TAG, "notifyPostError " + this.$localId + " isOk " + this.vSM);
                    qVar.onPostEnd(this.$localId, this.vSM);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167751);
            return xVar;
        }
    }

    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ long $localId;
        final /* synthetic */ long vGm;
        final /* synthetic */ g vSK;
        final /* synthetic */ boolean vSM = true;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(g gVar, long j2, long j3) {
            super(0);
            this.vSK = gVar;
            this.$localId = j2;
            this.vGm = j3;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(167752);
            if (!com.tencent.mm.kernel.g.aAc()) {
                Log.e(this.vSK.TAG, "is invalid to notifyPostError");
            } else {
                for (q qVar : this.vSK.listeners) {
                    Log.i(this.vSK.TAG, "notifyPostOk " + this.$localId + " svrId " + this.vGm + " isOk " + this.vSM);
                    qVar.onPostOk(this.$localId, this.vGm);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167752);
            return xVar;
        }
    }

    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ long $localId;
        final /* synthetic */ g vSK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(g gVar, long j2) {
            super(0);
            this.vSK = gVar;
            this.$localId = j2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(167753);
            if (!com.tencent.mm.kernel.g.aAc()) {
                Log.e(this.vSK.TAG, "is invalid to notifyStartPost");
            } else {
                for (q qVar : this.vSK.listeners) {
                    qVar.onPostStart(this.$localId);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167753);
            return xVar;
        }
    }
}
