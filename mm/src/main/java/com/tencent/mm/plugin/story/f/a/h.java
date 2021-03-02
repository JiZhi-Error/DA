package com.tencent.mm.plugin.story.f.a;

import android.os.Message;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.plugin.story.f.b.b;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.i.c;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eeg;
import com.tencent.mm.protocal.protobuf.eei;
import com.tencent.mm.protocal.protobuf.eej;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0002*+B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J>\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0012J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\b\u0010'\u001a\u00020\u0004H\u0014J\u0012\u0010(\u001a\u00020)2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0019H\u0014R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "processStoryVisit", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"})
public final class h extends q implements m {
    private static final LinkedList<Object> FnL = new LinkedList<>();
    public static final a FnM = new a((byte) 0);
    private static final String TAG = TAG;
    private b FnJ = new b();
    private final int FnK = 10;
    i callback;
    final d rr;

    public h() {
        AppMethodBeat.i(118837);
        d.a aVar = new d.a();
        aVar.c(new eei());
        aVar.d(new eej());
        aVar.MB("/cgi-bin/micromsg-bin/mmstorysync");
        aVar.sG(513);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(118837);
            throw tVar;
        }
        ((eei) aYJ).Leu = 128;
        AppMethodBeat.o(118837);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "", "(Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;)V", "cmdList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "getCmdList", "()Ljava/util/LinkedList;", "setCmdList", "(Ljava/util/LinkedList;)V", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getH", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setH", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "delaWithCmdList", "", "plugin-story_release"})
    public final class b {
        LinkedList<abn> sKS;
        MMHandler tby = new a(this);

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            AppMethodBeat.i(118829);
            AppMethodBeat.o(118829);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
        public static final class a extends MMHandler {
            final /* synthetic */ b FnO;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(b bVar) {
                this.FnO = bVar;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(118828);
                p.h(message, "msg");
                if (!g.aAf().azp()) {
                    AppMethodBeat.o(118828);
                    return;
                }
                if (this.FnO.sKS != null) {
                    LinkedList<abn> linkedList = this.FnO.sKS;
                    if (linkedList == null) {
                        p.hyc();
                    }
                    if (!linkedList.isEmpty()) {
                        LinkedList<abn> linkedList2 = this.FnO.sKS;
                        if (linkedList2 == null) {
                            p.hyc();
                        }
                        abn first = linkedList2.getFirst();
                        Log.d(h.TAG, "cmdId = " + first.Lms);
                        LinkedList<abn> linkedList3 = this.FnO.sKS;
                        if (linkedList3 == null) {
                            p.hyc();
                        }
                        linkedList3.removeFirst();
                        switch (first.Lms) {
                            case 1:
                                j.b bVar = j.Fmy;
                                j.b.eJP().post(new RunnableC1749a(this, first));
                                AppMethodBeat.o(118828);
                                return;
                            case 2:
                                j.b bVar2 = j.Fmy;
                                j.b.eJP().post(new RunnableC1750b(this, first));
                                AppMethodBeat.o(118828);
                                return;
                            case 3:
                                j.b bVar3 = j.Fmy;
                                j.b.eJP().post(new c(this, first));
                                AppMethodBeat.o(118828);
                                return;
                            case 4:
                                j.b bVar4 = j.Fmy;
                                j.b.eJP().post(new e(this, first));
                                AppMethodBeat.o(118828);
                                return;
                            case 5:
                            case 6:
                            default:
                                sendEmptyMessage(0);
                                AppMethodBeat.o(118828);
                                return;
                            case 7:
                                j.b bVar5 = j.Fmy;
                                j.b.eJP().post(new d(this, first));
                                AppMethodBeat.o(118828);
                                return;
                        }
                    }
                }
                h hVar = h.this;
                com.tencent.mm.bw.a aYK = hVar.rr.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
                    AppMethodBeat.o(118828);
                    throw tVar;
                }
                eej eej = (eej) aYK;
                com.tencent.mm.bw.a aYJ = hVar.rr.aYJ();
                if (aYJ == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
                    AppMethodBeat.o(118828);
                    throw tVar2;
                }
                eei eei = (eei) aYJ;
                byte[] l = ad.l(eei.Lev.getBuffer().toByteArray(), eej.Lev.getBuffer().toByteArray());
                if (l != null && l.length > 0) {
                    com.tencent.mm.kernel.e aAh = g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    aAh.azQ().set(8195, Util.encodeHexString(l));
                }
                eei.Lev.setBuffer(l);
                if ((eej.KZh & eei.Leu) == 0) {
                    i iVar = hVar.callback;
                    if (iVar == null) {
                        p.btv("callback");
                    }
                    iVar.onSceneEnd(0, 0, "", hVar);
                    AppMethodBeat.o(118828);
                    return;
                }
                com.tencent.mm.network.g dispatcher = hVar.dispatcher();
                p.g(dispatcher, "dispatcher()");
                i iVar2 = hVar.callback;
                if (iVar2 == null) {
                    p.btv("callback");
                }
                hVar.doScene(dispatcher, iVar2);
                AppMethodBeat.o(118828);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.story.f.a.h$b$a$a  reason: collision with other inner class name */
            static final class RunnableC1749a implements Runnable {
                final /* synthetic */ a FnP;
                final /* synthetic */ abn FnQ;

                RunnableC1749a(a aVar, abn abn) {
                    this.FnP = aVar;
                    this.FnQ = abn;
                }

                public final void run() {
                    AppMethodBeat.i(118823);
                    abn abn = this.FnQ;
                    p.g(abn, "item");
                    if (!h.c(abn, this.FnP)) {
                        this.FnP.sendEmptyMessage(0);
                    }
                    AppMethodBeat.o(118823);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.story.f.a.h$b$a$b  reason: collision with other inner class name */
            static final class RunnableC1750b implements Runnable {
                final /* synthetic */ a FnP;
                final /* synthetic */ abn FnQ;

                RunnableC1750b(a aVar, abn abn) {
                    this.FnP = aVar;
                    this.FnQ = abn;
                }

                public final void run() {
                    AppMethodBeat.i(118824);
                    abn abn = this.FnQ;
                    p.g(abn, "item");
                    if (!h.d(abn, this.FnP)) {
                        this.FnP.sendEmptyMessage(0);
                    }
                    AppMethodBeat.o(118824);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            static final class c implements Runnable {
                final /* synthetic */ a FnP;
                final /* synthetic */ abn FnQ;

                c(a aVar, abn abn) {
                    this.FnP = aVar;
                    this.FnQ = abn;
                }

                public final void run() {
                    AppMethodBeat.i(118825);
                    abn abn = this.FnQ;
                    p.g(abn, "item");
                    if (!h.e(abn, this.FnP)) {
                        this.FnP.sendEmptyMessage(0);
                    }
                    AppMethodBeat.o(118825);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            static final class d implements Runnable {
                final /* synthetic */ a FnP;
                final /* synthetic */ abn FnQ;

                d(a aVar, abn abn) {
                    this.FnP = aVar;
                    this.FnQ = abn;
                }

                public final void run() {
                    AppMethodBeat.i(118826);
                    abn abn = this.FnQ;
                    p.g(abn, "item");
                    if (!h.f(abn, this.FnP)) {
                        this.FnP.sendEmptyMessage(0);
                    }
                    AppMethodBeat.o(118826);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            static final class e implements Runnable {
                final /* synthetic */ a FnP;
                final /* synthetic */ abn FnQ;

                e(a aVar, abn abn) {
                    this.FnP = aVar;
                    this.FnQ = abn;
                }

                public final void run() {
                    AppMethodBeat.i(118827);
                    abn abn = this.FnQ;
                    p.g(abn, "item");
                    if (!h.g(abn, this.FnP)) {
                        this.FnP.sendEmptyMessage(0);
                    }
                    AppMethodBeat.o(118827);
                }
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$Companion;", "", "()V", "MM_STORY_SYNCCMD_COMMENT", "", "MM_STORY_SYNCCMD_COMMENT_DEL", "MM_STORY_SYNCCMD_POST", "MM_STORY_SYNCCMD_POST_DEL", "MM_STORY_SYNCCMD_VISIT", "TAG", "", "notifyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/IOnStoryNotify;", "addNotifyListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeNotifyListener", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118838);
        AppMethodBeat.o(118838);
    }

    public static boolean c(abn abn, MMHandler mMHandler) {
        eek frG;
        AppMethodBeat.i(118830);
        p.h(abn, "item");
        p.h(mMHandler, "h");
        try {
            eeg eeg = new eeg();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = abn.Lmt;
            p.g(sKBuiltinBuffer_t, "item.CmdBuf");
            com.tencent.mm.bw.a parseFrom = eeg.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.o(118830);
                throw tVar;
            }
            eeg eeg2 = (eeg) parseFrom;
            String str = eeg2.Ney.xNH;
            int i2 = eeg2.Ney.CreateTime;
            long j2 = eeg2.Id;
            n.a aVar = n.FmM;
            p.g(str, ch.COL_USERNAME);
            com.tencent.mm.plugin.story.i.j a2 = n.a.a(str, j2, i2, eeg2.Ney.NdL, false);
            k kVar = k.FmH;
            k.a(str, a2);
            Log.i(TAG, "processStoryPost username:" + eeg2.Ney.xNH + " createTime:" + eeg2.Ney.CreateTime + " id:" + eeg2.Id + " scope:" + ((a2 == null || (frG = a2.frG()) == null) ? null : Integer.valueOf(frG.NeD)));
            Iterator<Object> it = FnL.iterator();
            while (it.hasNext()) {
                it.next();
            }
            mMHandler.sendEmptyMessage(0);
            AppMethodBeat.o(118830);
            return true;
        } catch (Exception e2) {
            Log.w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.o(118830);
            return false;
        }
    }

    public static boolean d(abn abn, MMHandler mMHandler) {
        LinkedList<edt> linkedList;
        edt edt;
        LinkedList<edt> linkedList2;
        edt edt2;
        LinkedList<edt> linkedList3;
        edt edt3;
        AppMethodBeat.i(118831);
        p.h(abn, "item");
        p.h(mMHandler, "h");
        try {
            eeg eeg = new eeg();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = abn.Lmt;
            p.g(sKBuiltinBuffer_t, "item.CmdBuf");
            com.tencent.mm.bw.a parseFrom = eeg.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.o(118831);
                throw tVar;
            }
            eeg eeg2 = (eeg) parseFrom;
            String str = eeg2.Ney.xNH;
            int i2 = eeg2.Ney.CreateTime;
            long j2 = eeg2.Id;
            n.a aVar = n.FmM;
            p.g(str, ch.COL_USERNAME);
            n.a.a(str, j2, i2, null, true);
            n.a aVar2 = n.FmM;
            com.tencent.mm.plugin.story.i.j aRZ = n.a.aRZ(str);
            eek frG = aRZ.frG();
            edk edk = frG.NeB;
            String str2 = (edk == null || (linkedList3 = edk.LoV) == null || (edt3 = (edt) kotlin.a.j.L(linkedList3, 0)) == null) ? null : edt3.Msz;
            edk edk2 = frG.NeB;
            String str3 = (edk2 == null || (linkedList2 = edk2.LoV) == null || (edt2 = (edt) kotlin.a.j.L(linkedList2, 0)) == null) ? null : edt2.Url;
            edk edk3 = frG.NeB;
            float f2 = (edk3 == null || (linkedList = edk3.LoV) == null || (edt = (edt) kotlin.a.j.L(linkedList, 0)) == null) ? 0.0f : edt.Ned;
            k kVar = k.FmH;
            k.a(str, aRZ.field_storyID, aRZ.field_createTime, str2, str3, (long) (f2 * 1000.0f));
            Log.i(TAG, "processStoryPostDel username:" + str + " createTime:" + i2 + " id:" + j2 + " lastCreateTime:" + aRZ.field_createTime + " lastId:" + aRZ.field_storyID + "   ulonglong " + com.tencent.mm.ac.d.zs(j2));
            Iterator<Object> it = FnL.iterator();
            while (it.hasNext()) {
                it.next();
            }
            mMHandler.sendEmptyMessage(0);
            AppMethodBeat.o(118831);
            return true;
        } catch (Exception e2) {
            Log.w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.o(118831);
            return false;
        }
    }

    public static boolean e(abn abn, MMHandler mMHandler) {
        AppMethodBeat.i(118832);
        p.h(abn, "item");
        p.h(mMHandler, "h");
        try {
            eeg eeg = new eeg();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = abn.Lmt;
            p.g(sKBuiltinBuffer_t, "item.CmdBuf");
            com.tencent.mm.bw.a parseFrom = eeg.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.o(118832);
                throw tVar;
            }
            eeg eeg2 = (eeg) parseFrom;
            String str = eeg2.Ney.xNH;
            int i2 = eeg2.Ney.CreateTime;
            long j2 = eeg2.Id;
            Log.i(TAG, "processStoryComment username:" + str + " createTime:" + i2 + " id:" + j2 + " ulonglong " + com.tencent.mm.ac.d.zs(j2));
            com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
            p.h(eeg2, "syncMsg");
            Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncComment " + eeg2.Id + ' ' + eeg2.Ney.MYT + ' ' + eeg2.Ney.CreateTime);
            z.f fVar = new z.f();
            j.b bVar2 = j.Fmy;
            fVar.SYG = (T) j.b.fof().Kw(eeg2.Ney.Id);
            if (fVar.SYG == null) {
                fVar.SYG = (T) new c();
                ((c) fVar.SYG).field_storyId = eeg2.Id;
            }
            com.tencent.mm.plugin.story.f.b.b.a(eeg2);
            if (((c) fVar.SYG).field_readCommentTime == 0) {
                ((c) fVar.SYG).field_readCommentTime = 1;
            }
            String str2 = eeg2.Ney.xNH;
            p.g(str2, "syncMsg.SyncMsgDetail.FromUserName");
            fVar.SYG.aSr(str2);
            String str3 = eeg2.Ney.NdL.UserName;
            p.g(str3, "syncMsg.SyncMsgDetail.StoryObject.UserName");
            fVar.SYG.aSd(str3);
            ((c) fVar.SYG).field_syncCommentId = eeg2.Ney.MYT;
            ((c) fVar.SYG).field_syncCommentTime = eeg2.Ney.CreateTime;
            j.b bVar3 = j.Fmy;
            j.b.fof().replace(fVar.SYG);
            com.tencent.mm.ac.d.h(new b.a(fVar));
            Iterator<Object> it = FnL.iterator();
            while (it.hasNext()) {
                it.next();
            }
            mMHandler.sendEmptyMessage(0);
            AppMethodBeat.o(118832);
            return true;
        } catch (Exception e2) {
            Log.w(TAG, "StorySyncMsg parse error: " + e2.getMessage());
            AppMethodBeat.o(118832);
            return false;
        }
    }

    public static boolean f(abn abn, MMHandler mMHandler) {
        Integer valueOf;
        int i2;
        AppMethodBeat.i(118833);
        p.h(abn, "item");
        p.h(mMHandler, "h");
        try {
            eeg eeg = new eeg();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = abn.Lmt;
            p.g(sKBuiltinBuffer_t, "item.CmdBuf");
            com.tencent.mm.bw.a parseFrom = eeg.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.o(118833);
                throw tVar;
            }
            eeg eeg2 = (eeg) parseFrom;
            String str = eeg2.Ney.xNH;
            int i3 = eeg2.Ney.CreateTime;
            long j2 = eeg2.Id;
            Log.i(TAG, "processStoryVisit username:" + str + " createTime:" + i3 + " id:" + j2 + " ulonglong " + com.tencent.mm.ac.d.zs(j2));
            com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
            p.h(eeg2, "syncMsg");
            Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncVisit " + eeg2.Id + ' ' + eeg2.Ney.MYT + ' ' + eeg2.Ney.CreateTime + " enableVisit:" + e.Fln.fng());
            com.tencent.mm.plugin.story.f.b.b.a(eeg2);
            z.f fVar = new z.f();
            j.b bVar2 = j.Fmy;
            fVar.SYG = (T) j.b.fof().Kw(eeg2.Ney.Id);
            if (fVar.SYG == null) {
                fVar.SYG = (T) new c();
                ((c) fVar.SYG).field_storyId = eeg2.Id;
            }
            if (((c) fVar.SYG).field_readCommentTime == 0) {
                if (Util.isNullOrNil(eeg2.Ney.iAc)) {
                    LinkedList<edf> linkedList = eeg2.Ney.NdL.Nep;
                    p.g(linkedList, "bubbleList");
                    edf edf = (edf) kotlin.a.j.L(linkedList, linkedList.size() - 2);
                    valueOf = edf != null ? Integer.valueOf(edf.CreateTime) : null;
                } else {
                    LinkedList<edf> linkedList2 = eeg2.Ney.NdL.Nen;
                    p.g(linkedList2, "commentList");
                    edf edf2 = (edf) kotlin.a.j.L(linkedList2, linkedList2.size() - 2);
                    valueOf = edf2 != null ? Integer.valueOf(edf2.CreateTime) : null;
                }
                T t = fVar.SYG;
                if (valueOf != null) {
                    i2 = valueOf.intValue();
                } else {
                    i2 = 1;
                }
                ((c) t).field_readCommentTime = i2;
            }
            String str2 = eeg2.Ney.xNH;
            p.g(str2, "syncMsg.SyncMsgDetail.FromUserName");
            fVar.SYG.aSr(str2);
            String str3 = eeg2.Ney.NdL.UserName;
            p.g(str3, "syncMsg.SyncMsgDetail.StoryObject.UserName");
            fVar.SYG.aSd(str3);
            ((c) fVar.SYG).field_syncCommentId = eeg2.Ney.MYT;
            ((c) fVar.SYG).field_syncCommentTime = eeg2.Ney.CreateTime;
            j.b bVar3 = j.Fmy;
            j.b.fof().replace(fVar.SYG);
            com.tencent.mm.ac.d.h(new b.C1751b(fVar));
            Iterator<Object> it = FnL.iterator();
            while (it.hasNext()) {
                it.next();
            }
            mMHandler.sendEmptyMessage(0);
            AppMethodBeat.o(118833);
            return true;
        } catch (Exception e2) {
            Log.w(TAG, "StorySyncMsg parse error:  " + e2.getMessage());
            AppMethodBeat.o(118833);
            return false;
        }
    }

    public static boolean g(abn abn, MMHandler mMHandler) {
        AppMethodBeat.i(118834);
        p.h(abn, "item");
        p.h(mMHandler, "h");
        try {
            eeg eeg = new eeg();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = abn.Lmt;
            p.g(sKBuiltinBuffer_t, "item.CmdBuf");
            com.tencent.mm.bw.a parseFrom = eeg.parseFrom(sKBuiltinBuffer_t.getBuffer().toByteArray());
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
                AppMethodBeat.o(118834);
                throw tVar;
            }
            eeg eeg2 = (eeg) parseFrom;
            String str = eeg2.Ney.xNH;
            int i2 = eeg2.Ney.CreateTime;
            Log.i(TAG, "processStoryCommentDel username:" + str + " createTime:" + i2 + " id:" + eeg2.Id);
            com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
            p.h(eeg2, "syncMsg");
            Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "delSyncComment " + eeg2.Id + ' ' + eeg2.Ney.MYT);
            com.tencent.mm.plugin.story.f.b.b.k(eeg2.Ney.Id, eeg2.Ney.MYT, eeg2.Ney.iAc);
            com.tencent.mm.plugin.story.f.b.b.Kl(eeg2.Ney.Id);
            Iterator<Object> it = FnL.iterator();
            while (it.hasNext()) {
                it.next();
            }
            mMHandler.sendEmptyMessage(0);
            AppMethodBeat.o(118834);
            return true;
        } catch (Exception e2) {
            Log.w(TAG, "StorySyncMsg parse error!");
            AppMethodBeat.o(118834);
            return false;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(118835);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        byte[] decodeHexString = Util.decodeHexString(Util.nullAsNil((String) aAh.azQ().get(8195)));
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(decodeHexString);
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(118835);
            throw tVar;
        }
        ((eei) aYJ).Lev = sKBuiltinBuffer_t;
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(118835);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 513;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        LinkedList<abn> linkedList;
        AppMethodBeat.i(118836);
        Log.d(TAG, "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
                AppMethodBeat.o(118836);
                throw tVar;
            }
            eej eej = (eej) aYK;
            abo abo = eej.Ley;
            if (abo == null || (linkedList = abo.oTA) == null) {
                linkedList = new LinkedList<>();
            }
            if (linkedList.size() > 0) {
                b bVar = this.FnJ;
                p.h(linkedList, "cmdList");
                bVar.sKS = linkedList;
                bVar.tby.sendEmptyMessage(0);
                AppMethodBeat.o(118836);
                return;
            }
            if (eej.Lev != null) {
                SKBuiltinBuffer_t sKBuiltinBuffer_t = eej.Lev;
                p.g(sKBuiltinBuffer_t, "resp.KeyBuf");
                if (sKBuiltinBuffer_t.getBuffer() != null) {
                    SKBuiltinBuffer_t sKBuiltinBuffer_t2 = eej.Lev;
                    p.g(sKBuiltinBuffer_t2, "resp.KeyBuf");
                    byte[] byteArray = sKBuiltinBuffer_t2.getBuffer().toByteArray();
                    com.tencent.mm.bw.a aYJ = this.rr.aYJ();
                    if (aYJ == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
                        AppMethodBeat.o(118836);
                        throw tVar2;
                    }
                    byte[] l = ad.l(((eei) aYJ).Lev.getBuffer().toByteArray(), byteArray);
                    if (l != null) {
                        if (!(l.length == 0)) {
                            com.tencent.mm.kernel.e aAh = g.aAh();
                            p.g(aAh, "MMKernel.storage()");
                            aAh.azQ().set(8195, Util.encodeHexString(l));
                        }
                    }
                }
            }
            i iVar = this.callback;
            if (iVar == null) {
                p.btv("callback");
            }
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(118836);
            return;
        }
        i iVar2 = this.callback;
        if (iVar2 == null) {
            p.btv("callback");
        }
        iVar2.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(118836);
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return this.FnK;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }
}
