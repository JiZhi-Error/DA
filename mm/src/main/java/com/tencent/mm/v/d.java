package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bs;
import com.tencent.mm.u.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/executor/OpDeleteExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsg", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class d implements b {
    public static final a hff = new a((byte) 0);

    static {
        AppMethodBeat.i(114136);
        AppMethodBeat.o(114136);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/executor/OpDeleteExecutor$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.v.b
    public final void a(e eVar, s sVar, bs bsVar, i iVar, i iVar2, long j2) {
        AppMethodBeat.i(114134);
        p.h(eVar, "timer");
        p.h(sVar, "dispatcher");
        p.h(bsVar, "storage");
        p.h(iVar, "newFunctionMsgItem");
        Log.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete! id:".concat(String.valueOf(iVar)));
        if (iVar2 != null) {
            Log.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, %s", Long.valueOf(iVar.getVersion()), Long.valueOf(iVar2.getVersion()), iVar2);
            if (iVar.getVersion() == iVar2.getVersion() || iVar.getVersion() == 0) {
                iVar2.br(iVar.Vq());
                bsVar.delete(iVar2, new String[0]);
                iVar2.a(iVar.Vo());
                eVar.a(1, iVar2, this);
            }
            AppMethodBeat.o(114134);
            return;
        }
        Log.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, the origin one not exist! ".concat(String.valueOf(iVar)));
        eVar.a(1, iVar, this);
        AppMethodBeat.o(114134);
    }

    @Override // com.tencent.mm.v.b
    public final void a(e eVar, s sVar, com.tencent.mm.u.d dVar) {
        AppMethodBeat.i(114135);
        p.h(eVar, "timer");
        p.h(sVar, "dispatcher");
        p.h(dVar, "task");
        Log.i("FunctionMsg.OpDeleteExecutor", "[onTaskExpired] delete " + dVar.heU.Vk());
        i iVar = dVar.heU;
        sVar.b(iVar.Vk(), iVar, iVar.Vn());
        AppMethodBeat.o(114135);
    }
}
