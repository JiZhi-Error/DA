package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.v.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/engine/FunctionMsgTimer;", "", "callback", "Lcom/tencent/mm/engine/ITimerCallback;", "(Lcom/tencent/mm/engine/ITimerCallback;)V", "mCallback", "mQueue", "Lcom/tencent/mm/engine/FunctionMsgQueue;", "add", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "check", "handleTask", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e {
    public static final a heY = new a((byte) 0);
    final f heW;
    private final c heX = new c(this);

    static {
        AppMethodBeat.i(114126);
        AppMethodBeat.o(114126);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/engine/FunctionMsgTimer$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public e(f fVar) {
        p.h(fVar, "callback");
        AppMethodBeat.i(114125);
        this.heW = fVar;
        AppMethodBeat.o(114125);
    }

    public final void a(int i2, i iVar, b bVar) {
        AppMethodBeat.i(114123);
        p.h(iVar, "item");
        p.h(bVar, "executor");
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("FunctionMsg.FunctionMsgTimer", "[add] op:%s delay:%ss id:%s", Integer.valueOf(i2), Long.valueOf(iVar.Vq() - (cl.aWy() / 1000)), iVar.Vk());
        this.heX.a(new d(i2, iVar, bVar));
        Log.i("FunctionMsg.FunctionMsgTimer", "[add] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(114123);
    }

    public final void awI() {
        AppMethodBeat.i(114124);
        long currentTimeMillis = System.currentTimeMillis();
        this.heX.loop();
        Log.i("FunctionMsg.FunctionMsgTimer", "[check] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(114124);
    }
}
