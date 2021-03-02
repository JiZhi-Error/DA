package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bs;
import com.tencent.mm.u.b;
import com.tencent.mm.u.d;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/executor/OpNoShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e implements b {
    public static final a hfg = new a((byte) 0);

    static {
        AppMethodBeat.i(114141);
        AppMethodBeat.o(114141);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/executor/OpNoShowExecutor$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.v.b
    public final void a(com.tencent.mm.u.e eVar, s sVar, bs bsVar, i iVar, i iVar2, long j2) {
        AppMethodBeat.i(114139);
        p.h(eVar, "timer");
        p.h(sVar, "dispatcher");
        p.h(bsVar, "storage");
        p.h(iVar, "newFunctionMsgItem");
        iVar.cI(false);
        if (iVar2 == null) {
            Log.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, insert a new one! %s", iVar);
            bsVar.insert(iVar);
            eVar.a(2, iVar, this);
            AppMethodBeat.o(114139);
        } else if (iVar2.getVersion() < iVar.getVersion()) {
            Log.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, update the exist one, preVersion: %s oldFunctionMsgItem:%s", Long.valueOf(iVar2.Vl()), iVar2);
            iVar2.bp(iVar2.getVersion());
            iVar.bp(iVar2.getVersion());
            iVar2.br(iVar.Vq());
            iVar2.fz(iVar.Vm());
            String Vk = iVar2.Vk();
            p.g(Vk, "oldFunctionMsgItem!!.functionMsgId");
            bs.a(Vk, iVar);
            eVar.a(2, iVar, this);
            AppMethodBeat.o(114139);
        } else {
            Log.w("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show! but version is smaller");
            AppMethodBeat.o(114139);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/executor/OpNoShowExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
    public static final class b implements b.a {
        final /* synthetic */ com.tencent.mm.u.e hfb;
        final /* synthetic */ d hfc;

        b(com.tencent.mm.u.e eVar, d dVar) {
            this.hfb = eVar;
            this.hfc = dVar;
        }

        @Override // com.tencent.mm.u.b.a
        public final void b(i iVar) {
            AppMethodBeat.i(114137);
            p.h(iVar, "item");
            Log.w("FunctionMsg.OpNoShowExecutor", "[onFailFetch] item:".concat(String.valueOf(iVar)));
            if (iVar.getStatus() == -1) {
                this.hfb.a(-1, iVar, this.hfc.heV);
            }
            AppMethodBeat.o(114137);
        }

        @Override // com.tencent.mm.u.b.a
        public final void a(i iVar) {
            AppMethodBeat.i(114138);
            p.h(iVar, "item");
            Log.i("FunctionMsg.OpNoShowExecutor", "[onSuccessFetch] item:".concat(String.valueOf(iVar)));
            if (iVar.Vq() > cl.aWy() / 1000) {
                this.hfb.a(2, iVar, this.hfc.heV);
            }
            AppMethodBeat.o(114138);
        }
    }

    @Override // com.tencent.mm.v.b
    public final void a(com.tencent.mm.u.e eVar, s sVar, d dVar) {
        AppMethodBeat.i(114140);
        p.h(eVar, "timer");
        p.h(sVar, "dispatcher");
        p.h(dVar, "task");
        i iVar = dVar.heU;
        if (iVar.getStatus() == -1) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(iVar);
            new com.tencent.mm.u.b(linkedList, sVar, new b(eVar, dVar)).awH();
        }
        AppMethodBeat.o(114140);
    }
}
