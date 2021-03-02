package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.eef;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\u0010\u000bJ\u0018\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010#\u001a\u00020\u0007J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020&H\u0002J\"\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0002J>\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u00042\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J$\u00104\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000106H\u0002R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", ClientInfoTable.Columns.CLIENTID, ch.COL_LOCALID, "", "groupList", "", "blackList", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "errmsg", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"})
public final class g extends q implements m {
    private final String TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    private i callback;
    public int ecf;
    private long edx;
    private final d rr;

    public g(String str, String str2, int i2, List<String> list, List<String> list2) {
        p.h(str, "content");
        p.h(str2, ClientInfoTable.Columns.CLIENTID);
        p.h(list, "groupList");
        p.h(list2, "blackList");
        AppMethodBeat.i(118822);
        this.ecf = i2;
        d.a aVar = new d.a();
        aVar.c(new eee());
        aVar.d(new eef());
        aVar.MB("/cgi-bin/micromsg-bin/mmstorypost");
        aVar.sG(351);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
            AppMethodBeat.o(118822);
            throw tVar;
        }
        eee eee = (eee) aYJ;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        byte[] bytes = str.getBytes(kotlin.n.d.UTF_8);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        sKBuiltinBuffer_t.setBuffer(bytes);
        eee.Nem = sKBuiltinBuffer_t;
        eee.izX = str2;
        eee.KLP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            dqi dqi = new dqi();
            dqi.bhy(it.next());
            eee.GroupUser.add(dqi);
        }
        eee.GroupUserCount = list.size();
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            dqi dqi2 = new dqi();
            dqi2.bhy(it2.next());
            eee.BlackList.add(dqi2);
        }
        eee.BlackListCount = list2.size();
        AppMethodBeat.o(118822);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(118819);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        Log.d(this.TAG, "doScene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(118819);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 351;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        boolean z2;
        long j2;
        eea eea;
        AppMethodBeat.i(118820);
        Log.i(this.TAG, "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
            AppMethodBeat.o(118820);
            throw tVar;
        }
        eef eef = (eef) aYK;
        if (i3 == 4) {
            j.b bVar = j.Fmy;
            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(this.ecf);
            if (aba != null) {
                try {
                    a parseFrom = new edu().parseFrom(aba.field_postBuf);
                    if (parseFrom == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
                        AppMethodBeat.o(118820);
                        throw tVar2;
                    }
                    edu edu = (edu) parseFrom;
                    edu.Mtd = i4;
                    edu.Neg = str;
                    byte[] byteArray = edu.toByteArray();
                    p.g(byteArray, "postinfo.toByteArray()");
                    aba.setPostBuf(byteArray);
                    if (eef == null || (eea = eef.NdL) == null) {
                        j2 = 0;
                    } else {
                        j2 = eea.Id;
                    }
                    aba.field_storyID = j2;
                    aba.setItemDie();
                    j.b bVar2 = j.Fmy;
                    j.b.foc().a(this.ecf, aba);
                    j.b bVar3 = j.Fmy;
                    j.b.foj().Yv(this.ecf);
                } catch (Exception e2) {
                }
            }
            i iVar = this.callback;
            if (iVar == null) {
                p.btv("callback");
            }
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(118820);
        } else if (i4 != 0) {
            j.b bVar4 = j.Fmy;
            j.b.foj().Yv(this.ecf);
            i iVar2 = this.callback;
            if (iVar2 == null) {
                p.btv("callback");
            }
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(118820);
        } else {
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("resp.StoryObject==null ").append(eef.NdL == null).append(" resp.StoryObject.ObjDesc==null ");
            if (eef.NdL.Nem == null) {
                z = true;
            } else {
                z = false;
            }
            StringBuilder append2 = append.append(z).append(" resp.StoryObject.ObjDesc.getBuffer()==null ");
            if (eef.NdL.Nem.getBuffer() == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Log.i(str2, append2.append(z2).toString());
            if (eef.NdL == null || eef.NdL.Nem == null || eef.NdL.Nem.getBuffer() == null) {
                Log.e(this.TAG, "err respone buffer is null ignore");
                j.b bVar5 = j.Fmy;
                j.b.foc().Zs(this.ecf);
                i iVar3 = this.callback;
                if (iVar3 == null) {
                    p.btv("callback");
                }
                iVar3.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(118820);
                return;
            }
            f fVar = f.Fui;
            f.fqf();
            byte[] byteArray2 = eef.NdL.Nem.getBuffer().toByteArray();
            p.g(byteArray2, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
            String str3 = new String(byteArray2, kotlin.n.d.UTF_8);
            Log.d(this.TAG, "resp.xml:\n ".concat(String.valueOf(str3)));
            q.a aVar = com.tencent.mm.plugin.story.f.q.FmO;
            eek aSb = q.a.aSb(str3);
            if (aSb == null) {
                i iVar4 = this.callback;
                if (iVar4 == null) {
                    p.btv("callback");
                }
                iVar4.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(118820);
                return;
            }
            j.b bVar6 = j.Fmy;
            com.tencent.mm.plugin.story.i.j aba2 = j.b.foc().aba(this.ecf);
            if (aba2 == null) {
                aba2 = new com.tencent.mm.plugin.story.i.j();
            }
            a(eef.NdL.Id, aba2.frG(), aSb);
            if (eef.NdL.Nej == 1) {
                a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
                aba2.aaY(com.tencent.mm.plugin.story.i.a.Fvu);
            } else {
                a.C1768a aVar3 = com.tencent.mm.plugin.story.i.a.FvD;
                aba2.aaZ(com.tencent.mm.plugin.story.i.a.Fvu);
            }
            aba2.field_createTime = eef.NdL.CreateTime;
            aba2.c(aSb);
            int i5 = aba2.field_localFlag;
            a.d dVar = a.d.FvM;
            aba2.field_localFlag = i5 & (a.d.frm() ^ -1);
            aba2.field_storyID = eef.NdL.Id;
            eea eea2 = eef.NdL;
            eea2.Nem.setBuffer(new byte[0]);
            this.edx = eef.NdL.Id;
            aba2.field_attrBuf = eea2.toByteArray();
            aba2.clearItemDie();
            j.b bVar7 = j.Fmy;
            j.b.foc().Kz(eef.NdL.Id);
            j.b bVar8 = j.Fmy;
            j.b.foc().a(this.ecf, aba2);
            j.b bVar9 = j.Fmy;
            j.b.foj().Yv(this.ecf);
            j.b bVar10 = j.Fmy;
            j.b.foi().checkPost();
            i iVar5 = this.callback;
            if (iVar5 == null) {
                p.btv("callback");
            }
            iVar5.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(118820);
        }
    }

    private final boolean a(long j2, eek eek, eek eek2) {
        int i2 = 0;
        AppMethodBeat.i(118821);
        if (eek == null || eek2 == null || eek.NeB == null || eek2.NeB == null) {
            AppMethodBeat.o(118821);
            return false;
        }
        String str = eek2.UserName;
        while (i2 < eek.NeB.LoV.size() && i2 < eek2.NeB.LoV.size()) {
            edt edt = eek.NeB.LoV.get(i2);
            edt edt2 = eek2.NeB.LoV.get(i2);
            com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.FmK;
            String aRV = com.tencent.mm.plugin.story.f.l.aRV(edt.Id);
            com.tencent.mm.plugin.story.f.l lVar2 = com.tencent.mm.plugin.story.f.l.FmK;
            String aRW = com.tencent.mm.plugin.story.f.l.aRW(edt.Id);
            String kX = com.tencent.mm.plugin.story.f.l.FmK.kX(edt2.Url, str);
            String kY = com.tencent.mm.plugin.story.f.l.FmK.kY(edt2.Url, str);
            Log.d(this.TAG, "updateMediaFileName " + aRV + " to " + kX);
            Log.d(this.TAG, "updateMediaFileName " + aRW + " to " + kY);
            com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(kY));
            com.tencent.mm.vfs.s.nx(aRV, kX);
            com.tencent.mm.vfs.s.nw(aRW, kY);
            com.tencent.mm.plugin.story.f.s sVar = com.tencent.mm.plugin.story.f.s.Fny;
            p.g(edt2, "mediaObjCnt");
            p.h(edt2, "media");
            String a2 = com.tencent.mm.plugin.story.f.s.a(edt2, str);
            int boW = (int) com.tencent.mm.vfs.s.boW(a2);
            j.b bVar = j.Fmy;
            if (j.b.fog().KC(j2) == null) {
                n nVar = new n();
                nVar.field_storyId = j2;
                nVar.field_url = edt2.Url;
                nVar.field_cacheSize = boW;
                nVar.field_totalSize = boW;
                nVar.field_filePath = a2;
                j.b bVar2 = j.Fmy;
                j.b.fog().a(nVar);
            }
            i2++;
        }
        AppMethodBeat.o(118821);
        return true;
    }
}
