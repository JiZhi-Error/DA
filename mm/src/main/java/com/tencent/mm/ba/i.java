package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.protocal.protobuf.cgb;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i extends k.b {
    private cgb jgm;

    public i(List<a> list) {
        super(36);
        AppMethodBeat.i(43056);
        LinkedList<cga> linkedList = new LinkedList<>();
        for (a aVar : list) {
            linkedList.add(aVar.jgn);
        }
        this.jgm = new cgb();
        this.jgm.oTz = list.size();
        this.jgm.oTA = linkedList;
        this.zqv = this.jgm;
        AppMethodBeat.o(43056);
    }

    public static class a {
        cga jgn;
        private int key;
        private String value;

        public a() {
            AppMethodBeat.i(43054);
            this.key = 0;
            this.value = "";
            this.jgn = new cga();
            this.jgn.Cya = 0;
            this.jgn.Cyk = "";
            AppMethodBeat.o(43054);
        }

        public a(int i2, String str) {
            AppMethodBeat.i(43055);
            this.key = i2;
            this.value = str;
            this.jgn = new cga();
            this.jgn.Cya = i2;
            this.jgn.Cyk = str;
            AppMethodBeat.o(43055);
        }
    }
}
