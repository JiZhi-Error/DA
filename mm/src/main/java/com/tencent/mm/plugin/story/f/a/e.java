package com.tencent.mm.plugin.story.f.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.m;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.o;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.edp;
import com.tencent.mm.protocal.protobuf.edq;
import com.tencent.mm.protocal.protobuf.edr;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006H\u0002J\u001a\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0006H\u0002J\b\u0010.\u001a\u00020\rH\u0016J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0002J>\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "(Ljava/lang/String;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "deleteFaultdData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "existFaultData", "getType", "insertList", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryPageResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class e extends q implements m {
    public static final a FnF = new a((byte) 0);
    private static final String TAG = TAG;
    private String DIL = "";
    public boolean DIe;
    private long DIf;
    private long DIg;
    public long DJB;
    private long FnD;
    private i callback;
    private boolean dJM;
    private d rr;
    private int sourceType;
    public String userName;

    public e(String str, long j2, boolean z) {
        edq edq;
        long j3 = 0;
        int i2 = 0;
        p.h(str, "userName");
        AppMethodBeat.i(118811);
        this.userName = str;
        this.DIf = j2;
        this.dJM = z;
        if (this.DIf == 0) {
            Log.i(TAG, "fp mUserName " + this.userName);
        } else {
            Log.i(TAG, "np mUserName " + this.userName);
        }
        a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
        int i3 = com.tencent.mm.plugin.story.i.a.FuL;
        a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
        this.sourceType = i3 | com.tencent.mm.plugin.story.i.a.FuJ;
        d.a aVar3 = new d.a();
        aVar3.c(new edq());
        aVar3.d(new edr());
        aVar3.MB("/cgi-bin/micromsg-bin/mmstoryhistorypage");
        aVar3.sG(191);
        aVar3.sI(0);
        aVar3.sJ(0);
        d aXF = aVar3.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageRequest");
            AppMethodBeat.o(118811);
            throw tVar;
        }
        edq edq2 = (edq) aYJ;
        edq2.UserName = this.userName;
        edq2.MZh = this.DIf;
        this.DIe = this.DIf == 0;
        j.b bVar = j.Fmy;
        j.b.fol();
        int aSa = o.a.aSa(this.userName);
        j.b bVar2 = j.Fmy;
        this.DIg = j.b.foc().ab(!this.DIe ? this.DIf : j3, aSa);
        edq2.Nau = this.DIg;
        edq2.Nav = 0;
        try {
            String timeZoneOffset = Util.getTimeZoneOffset();
            p.g(timeZoneOffset, "Util.getTimeZoneOffset()");
            i2 = (int) Float.parseFloat(timeZoneOffset);
            edq = edq2;
        } catch (Exception e2) {
            edq = edq2;
        }
        edq.rBY = i2;
        if (this.DIe) {
            j.b bVar3 = j.Fmy;
            g fod = j.b.fod();
            a.C1768a aVar4 = com.tencent.mm.plugin.story.i.a.FvD;
            this.DIL = fod.aSu(com.tencent.mm.plugin.story.i.a.FuR);
            if (this.DIL == null) {
                this.DIL = "";
            }
            edq2.MZg = this.DIL;
        }
        this.FnD = this.DIf;
        Log.i(TAG, "req.mUserName:" + edq2.UserName + " req.MaxId:" + edq2.MZh + " req.MinFilterId:" + edq2.Nau + " req.LastRequestTime:" + edq2.Nav + " req.FirstPageMd5:" + edq2.MZg + " req.TimeZone:" + edq2.rBY);
        AppMethodBeat.o(118811);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryHistoryPage$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118812);
        AppMethodBeat.o(118812);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 191;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(118808);
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(118808);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(118809);
        Log.d(TAG, "netId=" + i2 + " errType=" + i3 + " errCode=" + i4 + " errMsg=" + str);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryHistoryPageResponse");
            AppMethodBeat.o(118809);
            throw tVar;
        }
        edr edr = (edr) aYK;
        this.DJB = edr.NdN;
        String str2 = edr.MZg;
        if (str2 == null) {
            str2 = "";
        }
        Log.i(TAG, "objCount:" + edr.NdX + " firstPageMd5:" + str2 + ", expiredTime:" + edr.KCC);
        if (edr.NdY.isEmpty()) {
            Log.i(TAG, "server give size zero");
            i iVar = this.callback;
            if (iVar == null) {
                p.btv("callback");
            }
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(118809);
            return;
        }
        j.b bVar = j.Fmy;
        g fod = j.b.fod();
        a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
        fod.kJ(com.tencent.mm.plugin.story.i.a.FuR, str2);
        if (this.DIe) {
            long j2 = edr.NdY.get(edr.NdY.size() - 1).Id;
            n.a aVar2 = n.FmM;
            if (j2 > n.a.aRZ(this.userName).field_storyID) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                long j3 = edr.NdY.get(edr.NdY.size() - 1).Id;
                String str3 = this.userName;
                j.b bVar2 = j.Fmy;
                if (Util.isEqual(str3, j.b.fau())) {
                    n.a aVar3 = n.FmM;
                    String str4 = this.userName;
                    p.h(str4, "userName");
                    j.b bVar3 = j.Fmy;
                    k foc = j.b.foc();
                    a.C1768a aVar4 = com.tencent.mm.plugin.story.i.a.FvD;
                    int i5 = com.tencent.mm.plugin.story.i.a.FuJ;
                    p.h(str4, "userName");
                    String str5 = "UPDATE " + k.TABLE + " SET sourceType = " + i5 + " Where userName = '" + str4 + "' AND storyID < " + j3;
                    Log.d(k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(str5)));
                    foc.db.execSQL(k.TABLE, str5);
                }
            }
        }
        a(edr);
        i iVar2 = this.callback;
        if (iVar2 == null) {
            p.btv("callback");
        }
        iVar2.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(118809);
    }

    private final void a(edr edr) {
        boolean z;
        AppMethodBeat.i(118810);
        LinkedList<edp> linkedList = edr.NdY;
        p.g(linkedList, "resp.HistoryItemList");
        for (T t : linkedList) {
            Log.d(TAG, "date=" + t.Lrr + " count=" + t.Ndu + " id=" + t.Id);
            n.a aVar = n.FmM;
            String str = this.userName;
            eea eea = t.NdL;
            p.g(eea, "it.StoryObject");
            int i2 = this.sourceType;
            p.h(str, "userName");
            p.h(eea, "storyObj");
            j.b bVar = j.Fmy;
            k foc = j.b.foc();
            Log.d(n.TAG, "insertStory storyObj.id:" + eea.Id);
            com.tencent.mm.plugin.story.i.j Kx = foc.Kx(eea.Id);
            if (Kx == null) {
                Kx = new com.tencent.mm.plugin.story.i.j();
            }
            p.h(Kx, "storyInfo");
            p.h(eea, "storyObj");
            p.h(str, "userName");
            if (eea.Nem == null || eea.Nem.getBuffer() == null) {
                Log.i(n.TAG, "object desc is null");
            } else {
                byte[] byteArray = eea.Nem.getBuffer().toByteArray();
                p.g(byteArray, "storyObj.ObjDesc.getBuffer().toByteArray()");
                String str2 = new String(byteArray, kotlin.n.d.UTF_8);
                Log.d(n.TAG, "from server %d \n%s", Long.valueOf(eea.Id), str2);
                q.a aVar2 = com.tencent.mm.plugin.story.f.q.FmO;
                eek aSb = q.a.aSb(str2);
                if (!Util.isNullOrNil(str2) && aSb != null && Kx.c(aSb)) {
                    Log.d(n.TAG, "from server xml ok %d \n ".concat(String.valueOf(str2)), Long.valueOf(eea.Id));
                    eea.Nem.setBuffer(new byte[0]);
                    Kx.field_userName = eea.UserName;
                    Kx.field_createTime = eea.CreateTime;
                    Kx.field_storyID = eea.Id;
                    if (!eea.Nen.isEmpty()) {
                        Kx.field_attrBuf = eea.toByteArray();
                    }
                    Log.i(n.TAG, "id:" + Kx.field_storyID + " createTime:" + Kx.field_createTime + " CommentListSize:" + eea.Nen.size() + " BubbleListSize:" + eea.Nep.size());
                    Kx.addSourceFlag(i2);
                    eek frG = Kx.frG();
                    frG.UserName = eea.UserName;
                    Kx.b(frG);
                    j.b bVar2 = j.Fmy;
                    k foc2 = j.b.foc();
                    Cursor rawQuery = foc2.db.rawQuery("select *,rowid from MMStoryInfo  where " + k.TABLE + ".storyID = " + eea.Id, null);
                    p.g(rawQuery, "cu");
                    int count = rawQuery.getCount();
                    rawQuery.close();
                    if (count > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        j.b bVar3 = j.Fmy;
                        j.b.foc().e(Kx);
                        j.b bVar4 = j.Fmy;
                        j.b.foc().KA(eea.Id);
                    } else {
                        j.b bVar5 = j.Fmy;
                        j.b.foc().f(Kx);
                    }
                }
            }
            m.a aVar3 = com.tencent.mm.plugin.story.f.m.FmL;
            p.g(t, LocaleUtil.ITALIAN);
            p.h(t, "item");
            h.a aVar4 = h.Fwn;
            p.h(t, "item");
            h hVar = new h();
            String str3 = t.Lrr;
            if (str3 == null) {
                str3 = "";
            }
            hVar.field_date = str3;
            hVar.field_count = t.Ndu;
            j.b bVar6 = j.Fmy;
            j.b.foh().a(hVar);
        }
        if (this.DIf == 0) {
            LinkedList<edp> linkedList2 = edr.NdY;
            p.g(linkedList2, "resp.HistoryItemList");
            this.DIf = linkedList2.getFirst().Id;
        }
        LinkedList<edp> linkedList3 = edr.NdY;
        p.g(linkedList3, "resp.HistoryItemList");
        this.DIg = linkedList3.getLast().Id;
        Log.i(TAG, "insertList mUserName %s maxId %s minId %s NewRequestTime %s", this.userName, Long.valueOf(this.DIf), Long.valueOf(this.DIg), Integer.valueOf(edr.NaG));
        AppMethodBeat.o(118810);
    }
}
