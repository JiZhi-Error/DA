package com.tencent.mm.plugin.textstatus.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/logic/WeakOnSceneEnd;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "obj", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "ref", "Ljava/lang/ref/WeakReference;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"})
public final class f implements i {
    private final WeakReference<i> nsR;

    public f(i iVar) {
        p.h(iVar, "obj");
        AppMethodBeat.i(216158);
        this.nsR = new WeakReference<>(iVar);
        AppMethodBeat.o(216158);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(216157);
        i iVar = this.nsR.get();
        if (iVar != null) {
            iVar.onSceneEnd(i2, i3, str, qVar);
            AppMethodBeat.o(216157);
            return;
        }
        AppMethodBeat.o(216157);
    }
}
