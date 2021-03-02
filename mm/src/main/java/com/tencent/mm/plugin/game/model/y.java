package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.by;
import com.tencent.mm.plugin.game.protobuf.g;
import java.util.Iterator;
import java.util.LinkedList;

public final class y extends x {
    private int mType = 0;
    public by xGU;
    public LinkedList<c> xGV;
    private int xGW = 0;

    public y(a aVar, int i2, int i3) {
        int i4;
        AppMethodBeat.i(41524);
        if (aVar == null) {
            this.xGU = new by();
            AppMethodBeat.o(41524);
            return;
        }
        this.xGU = (by) aVar;
        this.mType = i2;
        this.xGW = i3;
        LinkedList<c> linkedList = new LinkedList<>();
        if (this.xGU.xMf != null) {
            Iterator<g> it = this.xGU.xMf.iterator();
            int i5 = this.xGW + 1;
            while (it.hasNext()) {
                c a2 = a(it.next());
                if (a2 != null) {
                    switch (this.mType) {
                        case 1:
                            a2.scene = 16;
                            a2.dYu = 1601;
                            i4 = i5 + 1;
                            a2.position = i5;
                            break;
                        case 2:
                            a2.scene = 15;
                            a2.dYu = 1501;
                            i4 = i5 + 1;
                            a2.position = i5;
                            break;
                        default:
                            i4 = i5;
                            break;
                    }
                    linkedList.add(a2);
                    i5 = i4;
                }
            }
        }
        this.xGV = linkedList;
        d.aZ(this.xGV);
        AppMethodBeat.o(41524);
    }
}
