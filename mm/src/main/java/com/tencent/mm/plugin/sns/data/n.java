package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnb;
import java.util.LinkedList;
import java.util.List;

public final class n {
    public int DEs;
    public String dPI;
    public List<cnb> list = new LinkedList();

    public n() {
        AppMethodBeat.i(95086);
        AppMethodBeat.o(95086);
    }

    public n(cnb cnb) {
        AppMethodBeat.i(95087);
        this.list.add(cnb);
        AppMethodBeat.o(95087);
    }

    public n(List<cnb> list2) {
        AppMethodBeat.i(95088);
        this.list = list2;
        AppMethodBeat.o(95088);
    }
}
