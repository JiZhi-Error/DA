package com.tencent.mm.u;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.v.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/engine/FunctionMsgTask;", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "(ILcom/tencent/mm/api/FunctionMsgItem;Lcom/tencent/mm/executor/IOpExecutor;)V", "mExecutor", "getMExecutor", "()Lcom/tencent/mm/executor/IOpExecutor;", "mItem", "getMItem", "()Lcom/tencent/mm/api/FunctionMsgItem;", "mOpCode", "getMOpCode", "()I", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "toString", "", "plugin-functionmsg_release"})
public final class d {
    final int dKp;
    public final i heU;
    public final b heV;

    public d(int i2, i iVar, b bVar) {
        p.h(iVar, "item");
        p.h(bVar, "executor");
        AppMethodBeat.i(114122);
        this.dKp = i2;
        this.heU = iVar;
        this.heV = bVar;
        AppMethodBeat.o(114122);
    }

    public final String toString() {
        AppMethodBeat.i(114120);
        String str = "FunctionMsgTask(mOpCode=" + this.dKp + ", mItem=" + this.heU + ')';
        AppMethodBeat.o(114120);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(114121);
        if (obj instanceof d) {
            boolean j2 = p.j(((d) obj).heU.Vk(), this.heU.Vk());
            AppMethodBeat.o(114121);
            return j2;
        }
        AppMethodBeat.o(114121);
        return false;
    }
}
