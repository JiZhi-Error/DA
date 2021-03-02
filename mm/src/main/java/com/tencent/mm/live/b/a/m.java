package com.tencent.mm.live.b.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.live.b.n;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.x;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J<\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "offline", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "getDuration", "()J", "setDuration", "(J)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class m extends q implements com.tencent.mm.network.m {
    public static final a hKj = new a((byte) 0);
    private i callback;
    public long duration;
    private d hJu;
    private final bpl hKh;
    private bpm hKi;

    static {
        AppMethodBeat.i(207789);
        AppMethodBeat.o(207789);
    }

    public /* synthetic */ m(long j2, String str) {
        this(j2, str, false);
    }

    public m(long j2, String str, boolean z) {
        p.h(str, "wechatRoomId");
        AppMethodBeat.i(207788);
        d.a aVar = new d.a();
        aVar.c(new bpl());
        aVar.d(new bpm());
        aVar.sG(3767);
        aVar.MB("/cgi-bin/micromsg-bin/getlivemessage");
        aVar.sI(0);
        aVar.sJ(0);
        aVar.aYL();
        aVar.aYM();
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.hJu = aXF;
        com.tencent.mm.bw.a aYJ = this.hJu.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageRequest");
            AppMethodBeat.o(207788);
            throw tVar;
        }
        this.hKh = (bpl) aYJ;
        this.hKh.hyH = j2;
        this.hKh.KDQ = str;
        bpl bpl = this.hKh;
        x xVar = x.hJf;
        bpl.LFp = b.cD(x.aGq());
        this.hKh.AqQ = z;
        Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "get live message:" + j2 + " wechatRoomId:" + str + " offline:" + z);
        AppMethodBeat.o(207788);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(207786);
        this.duration = System.currentTimeMillis();
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(207786);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        byte[] bArr2;
        ArrayList arrayList;
        b bVar;
        Integer num = null;
        AppMethodBeat.i(207787);
        p.h(sVar, "rr");
        Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        this.duration = System.currentTimeMillis() - this.duration;
        n nVar = n.hGh;
        if (n.da(i3, i4)) {
            r.a(r.hIg);
            i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(207787);
                return;
            }
            AppMethodBeat.o(207787);
            return;
        }
        com.tencent.mm.bw.a aYK = ((d) sVar).aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageResponse");
            AppMethodBeat.o(207787);
            throw tVar;
        }
        this.hKi = (bpm) aYK;
        if (i3 != 0 || i4 != 0) {
            Log.e("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd error");
            switch (i4) {
                case -100056:
                    com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
                    com.tencent.mm.live.b.m.aFf();
                    break;
            }
        } else {
            bpm bpm = this.hKi;
            if (bpm != null) {
                if (bpm.LXH) {
                    x xVar = x.hJf;
                    if (x.aGr().LIa != bpm.LIa) {
                        com.tencent.mm.live.b.m mVar2 = com.tencent.mm.live.b.m.hGg;
                        com.tencent.mm.live.b.m.aFg();
                    }
                    x xVar2 = x.hJf;
                    x.aGr().LIa = bpm.LIa;
                    x xVar3 = x.hJf;
                    civ aGr = x.aGr();
                    x xVar4 = x.hJf;
                    aGr.LXG = Math.max(x.aGr().LXG, bpm.LXG);
                    x xVar5 = x.hJf;
                    x.aGn().clear();
                    x xVar6 = x.hJf;
                    ArrayList<String> aGn = x.aGn();
                    LinkedList<String> linkedList = bpm.LXF;
                    aGn.addAll(linkedList != null ? linkedList : new ArrayList());
                    x xVar7 = x.hJf;
                    x.a(new ciq());
                    x xVar8 = x.hJf;
                    ciq aGx = x.aGx();
                    cis cis = bpm.LXI;
                    if (cis == null || (bVar = cis.MnG) == null) {
                        bArr2 = null;
                    } else {
                        bArr2 = bVar.zy;
                    }
                    try {
                        aGx.parseFrom(bArr2);
                    } catch (Exception e2) {
                        Log.printDebugStack("safeParser", "", e2);
                    }
                    com.tencent.mm.live.b.d.b bVar2 = com.tencent.mm.live.b.d.b.hLo;
                    x xVar9 = x.hJf;
                    ArrayList<com.tencent.mm.live.view.a.a> aGp = x.aGp();
                    LinkedList<cix> linkedList2 = bpm.LXE;
                    if (linkedList2 != null) {
                        arrayList = linkedList2;
                    } else {
                        arrayList = new ArrayList();
                    }
                    String aTY = z.aTY();
                    p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                    com.tencent.mm.live.b.d.b.a(aGp, arrayList, aTY);
                    com.tencent.mm.live.b.m mVar3 = com.tencent.mm.live.b.m.hGg;
                    com.tencent.mm.live.b.m.aFe();
                }
                x xVar10 = x.hJf;
                b bVar3 = bpm.LFp;
                p.g(bVar3, "it.live_cookies");
                x.ad(bVar3.zy);
                StringBuilder sb = new StringBuilder("onlineCount:");
                x xVar11 = x.hJf;
                StringBuilder append = sb.append(x.aGr().LIa).append(" headerList:");
                x xVar12 = x.hJf;
                StringBuilder append2 = append.append(x.aGn().size()).append(" remoteMsgSize:");
                LinkedList<cix> linkedList3 = bpm.LXE;
                if (linkedList3 != null) {
                    num = Integer.valueOf(linkedList3.size());
                }
                StringBuilder append3 = append2.append(num).append(", msgSize:");
                x xVar13 = x.hJf;
                StringBuilder append4 = append3.append(x.aGp().size()).append(" likeCount:");
                x xVar14 = x.hJf;
                Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", append4.append(x.aGr().LXG).append(", needUpdate:").append(bpm.LXH).toString());
            }
        }
        i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(207787);
            return;
        }
        AppMethodBeat.o(207787);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3767;
    }
}
