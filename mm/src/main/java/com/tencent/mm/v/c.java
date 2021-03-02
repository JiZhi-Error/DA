package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bs;
import com.tencent.mm.u.b;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/executor/OpDelayExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class c implements b {
    public static final a hfa = new a((byte) 0);

    static {
        AppMethodBeat.i(114133);
        AppMethodBeat.o(114133);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/executor/OpDelayExecutor$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.v.b
    public final void a(e eVar, s sVar, bs bsVar, i iVar, i iVar2, long j2) {
        AppMethodBeat.i(114131);
        p.h(eVar, "timer");
        p.h(sVar, "dispatcher");
        p.h(bsVar, "storage");
        p.h(iVar, "newFunctionMsgItem");
        if (iVar2 != null) {
            iVar.cI(true);
            iVar2.bp(iVar2.getVersion());
            iVar2.bo(iVar.getVersion());
            if (0 < iVar.Vq()) {
                iVar2.br(iVar.Vq() + iVar.Vp());
            } else {
                iVar2.br(iVar2.Vq() + iVar.Vp());
            }
            iVar2.fz(iVar.Vm());
            String Vk = iVar2.Vk();
            p.g(Vk, "oldFunctionMsgItem!!.functionMsgId");
            bs.a(Vk, iVar2);
            Log.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + iVar.Vk() + ", op delay! update the exist one, new ActionTime:" + iVar.Vq() + " new delay:" + iVar.Vp() + " reslt:" + iVar2);
            eVar.a(101, iVar2, this);
            AppMethodBeat.o(114131);
            return;
        }
        Log.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: ".concat(String.valueOf(iVar)));
        AppMethodBeat.o(114131);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/executor/OpDelayExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
    public static final class b implements b.a {
        final /* synthetic */ e hfb;
        final /* synthetic */ d hfc;
        final /* synthetic */ i hfd;
        final /* synthetic */ s hfe;

        b(e eVar, d dVar, i iVar, s sVar) {
            this.hfb = eVar;
            this.hfc = dVar;
            this.hfd = iVar;
            this.hfe = sVar;
        }

        @Override // com.tencent.mm.u.b.a
        public final void b(i iVar) {
            AppMethodBeat.i(114129);
            p.h(iVar, "item");
            Log.w("FunctionMsg.OpDelayExecutor", "[onFailFetch] item:".concat(String.valueOf(iVar)));
            if (iVar.getStatus() == -1) {
                this.hfb.a(-1, iVar, this.hfc.heV);
            }
            AppMethodBeat.o(114129);
        }

        @Override // com.tencent.mm.u.b.a
        public final void a(i iVar) {
            AppMethodBeat.i(114130);
            p.h(iVar, "item");
            Log.i("FunctionMsg.OpDelayExecutor", "[onSuccessFetch] item:".concat(String.valueOf(iVar)));
            if (iVar.Vq() > cl.aWy() / 1000) {
                this.hfb.a(101, iVar, this.hfc.heV);
                AppMethodBeat.o(114130);
                return;
            }
            Log.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] to show! id" + this.hfd.Vk());
            this.hfe.a(iVar.Vk(), iVar, iVar.Vn());
            AppMethodBeat.o(114130);
        }
    }

    @Override // com.tencent.mm.v.b
    public final void a(e eVar, s sVar, d dVar) {
        AppMethodBeat.i(114132);
        p.h(eVar, "timer");
        p.h(sVar, "dispatcher");
        p.h(dVar, "task");
        i iVar = dVar.heU;
        if (iVar.getStatus() == -1) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(iVar);
            new com.tencent.mm.u.b(linkedList, sVar, new b(eVar, dVar, iVar, sVar)).awH();
            AppMethodBeat.o(114132);
            return;
        }
        if (iVar.getStatus() == 2 || iVar.getStatus() == -2) {
            Log.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + iVar.Vk() + " actionTime:" + iVar.Vq());
            if (iVar.Vq() <= cl.aWy() / 1000) {
                sVar.a(iVar.Vk(), iVar, iVar.Vn());
                AppMethodBeat.o(114132);
                return;
            }
            eVar.a(iVar.Vj(), iVar, dVar.heV);
        }
        AppMethodBeat.o(114132);
    }
}
