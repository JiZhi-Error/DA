package com.tencent.mm.kiss.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public ConcurrentHashMap<String, LinkedList<f>> hud = new ConcurrentHashMap<>();

    public b() {
        AppMethodBeat.i(141009);
        AppMethodBeat.o(141009);
    }

    public final synchronized void a(f fVar) {
        AppMethodBeat.i(141010);
        if (fVar == null || fVar.huG == null) {
            AppMethodBeat.o(141010);
        } else {
            LinkedList<f> linkedList = this.hud.get(fVar.huG.toString());
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
            linkedList.add(fVar);
            this.hud.put(fVar.huG.toString(), linkedList);
            AppMethodBeat.o(141010);
        }
    }

    public final synchronized f z(CharSequence charSequence) {
        f fVar;
        AppMethodBeat.i(141011);
        LinkedList<f> linkedList = this.hud.get(charSequence.toString());
        if (linkedList == null || linkedList.size() == 0) {
            fVar = null;
            AppMethodBeat.o(141011);
        } else {
            fVar = linkedList.removeFirst();
            AppMethodBeat.o(141011);
        }
        return fVar;
    }
}
