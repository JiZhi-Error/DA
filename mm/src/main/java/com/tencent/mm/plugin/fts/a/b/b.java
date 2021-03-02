package com.tencent.mm.plugin.fts.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class b {
    private HashSet<String> wXt = new HashSet<>();
    public c wXu = new c(' ');

    public b() {
        AppMethodBeat.i(131720);
        AppMethodBeat.o(131720);
    }

    public final void ayz(String str) {
        AppMethodBeat.i(131721);
        if (!this.wXt.add(str)) {
            AppMethodBeat.o(131721);
            return;
        }
        c cVar = this.wXu;
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            int i3 = charArray[i2] - 'a';
            if (cVar.wXv[i3] == null) {
                cVar.wXv[i3] = new c(charArray[i2]);
            }
            cVar = cVar.wXv[i3];
        }
        cVar.wXs = true;
        AppMethodBeat.o(131721);
    }

    public final List<List<String>> ayA(String str) {
        a aVar;
        AppMethodBeat.i(131722);
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(new a(0, 0, null));
        char[] charArray = str.toLowerCase().toCharArray();
        ArrayList arrayList = new ArrayList();
        while (!arrayDeque.isEmpty() && (aVar = (a) arrayDeque.poll()) != null) {
            c cVar = this.wXu;
            for (int i2 = aVar.end; i2 < charArray.length; i2++) {
                int i3 = charArray[i2] - 'a';
                if (cVar.wXv[i3] == null) {
                    break;
                }
                cVar = cVar.wXv[i3];
                if (cVar.wXs || i2 == charArray.length - 1) {
                    if (aVar.aQz == null) {
                        aVar.aQz = new ArrayList();
                    }
                    a aVar2 = new a(aVar.end, i2 + 1, aVar);
                    aVar.aQz.add(aVar2);
                    if (aVar2.end == charArray.length) {
                        aVar2.wXs = true;
                    }
                    arrayDeque.offer(aVar2);
                }
            }
            if (aVar.wXs) {
                ArrayList arrayList2 = new ArrayList();
                while (aVar != null) {
                    if (aVar.end > aVar.start) {
                        arrayList2.add(str.substring(aVar.start, aVar.end));
                    }
                    aVar = aVar.wXr;
                }
                Collections.reverse(arrayList2);
                arrayList.add(arrayList2);
            }
        }
        AppMethodBeat.o(131722);
        return arrayList;
    }
}
