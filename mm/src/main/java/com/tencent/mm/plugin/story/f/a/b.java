package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.edb;
import com.tencent.mm.protocal.protobuf.edc;
import com.tencent.mm.protocal.protobuf.edd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.utils.TbsLog;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\rH\u0016J>\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class b extends q implements m {
    public static final a Fnz = new a((byte) 0);
    private static final String TAG = TAG;
    private i callback;
    public final String jVv;
    public final d rr;

    public b(String str) {
        edc edc;
        SKBuiltinBuffer_t sKBuiltinBuffer_t;
        SKBuiltinBuffer_t aC;
        p.h(str, "chatRoom");
        AppMethodBeat.i(118798);
        this.jVv = str;
        d.a aVar = new d.a();
        aVar.c(new edc());
        aVar.d(new edd());
        aVar.MB("/cgi-bin/micromsg-bin/mmstorychatroomsync");
        aVar.sG(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
            AppMethodBeat.o(118798);
            throw tVar;
        }
        edc edc2 = (edc) aYJ;
        j.b bVar = j.Fmy;
        String fau = j.b.fau();
        j.b bVar2 = j.Fmy;
        com.tencent.mm.plugin.story.i.l aSB = j.b.foe().aSB(this.jVv);
        edc2.UserName = fau;
        edc2.KGO = this.jVv;
        byte[] bArr = aSB.field_extbuf;
        if (bArr == null || (aC = z.aC(bArr)) == null) {
            sKBuiltinBuffer_t = null;
            edc = edc2;
        } else {
            sKBuiltinBuffer_t = aC;
            edc = edc2;
        }
        edc.Ndv = sKBuiltinBuffer_t;
        Log.i(TAG, "req userName " + fau + " chatRoomName " + this.jVv + " buf " + edc2.Ndv);
        AppMethodBeat.o(118798);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118799);
        AppMethodBeat.o(118799);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        byte[] bArr2;
        AppMethodBeat.i(118796);
        Log.i(TAG, "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            z = false;
        } else {
            z = true;
        }
        edd edd = (edd) this.rr.aYK();
        if (edd != null) {
            j.b bVar = j.Fmy;
            com.tencent.mm.plugin.story.i.l aSB = j.b.foe().aSB(this.jVv);
            SKBuiltinBuffer_t sKBuiltinBuffer_t = edd.Ndv;
            if (sKBuiltinBuffer_t != null) {
                try {
                    bArr2 = sKBuiltinBuffer_t.getBufferToBytes();
                } catch (Exception e2) {
                    Log.printDebugStack("safeBufferToByte", "", e2);
                    bArr2 = null;
                }
            } else {
                bArr2 = null;
            }
            aSB.field_extbuf = bArr2;
            Log.i(TAG, "onGYNetEnd: count " + edd.Ndw);
            if (z) {
                aSB.field_nextSyncTime = Util.MILLSECONDS_OF_MINUTE + System.currentTimeMillis();
            } else {
                aSB.field_nextSyncTime = (((long) edd.Ndy) * 1000) + System.currentTimeMillis();
            }
            j.b bVar2 = j.Fmy;
            j.b.foe().replace(aSB);
            Log.i(TAG, "response: count " + edd.Ndw + ", interval " + edd.Ndy);
            LinkedList<edb> linkedList = edd.Ndx;
            p.g(linkedList, "resp.SyncInfoList");
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                T next = it.next();
                if (!((next != null ? next.UserName : null) == null || next.ThumbUrl == null)) {
                    k kVar = k.FmH;
                    String str2 = next.UserName;
                    p.g(str2, "it.UserName");
                    f aRS = k.aRS(str2);
                    Log.d(TAG, "fetch " + next.UserName + ' ' + next.Nds + ' ' + next.Ndt + ", oldId " + aRS.field_syncId);
                    if (aRS.field_syncId != next.Nds) {
                        k kVar2 = k.FmH;
                        String str3 = next.UserName;
                        p.g(str3, "it.UserName");
                        k.a(str3, next.Nds, next.Ndt, next.ThumbUrl, next.xLk, 0);
                    }
                }
            }
        }
        i iVar = this.callback;
        if (iVar == null) {
            p.btv("callback");
        }
        iVar.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(118796);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(118797);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(118797);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR;
    }
}
