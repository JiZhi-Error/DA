package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.bw;
import com.tencent.mm.plugin.game.protobuf.dg;
import com.tencent.mm.plugin.game.protobuf.dt;
import com.tencent.mm.plugin.game.protobuf.e;
import com.tencent.mm.plugin.game.protobuf.q;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class ae extends x {
    private int xGW;
    public bw xHq;
    public LinkedList<c> xHr;
    public LinkedList<c> xHs;

    public ae(a aVar, boolean z, int i2) {
        AppMethodBeat.i(41543);
        this.xGW = 0;
        if (aVar == null) {
            this.xHq = new bw();
            AppMethodBeat.o(41543);
            return;
        }
        this.xHq = (bw) aVar;
        this.xGW = i2;
        this.xHr = dVQ();
        this.xHs = dVR();
        if (z) {
            ((f) g.af(f.class)).dSL().b("pb_library", aVar);
        }
        d.aZ(this.xHr);
        d.aZ(this.xHs);
        AppMethodBeat.o(41543);
    }

    public ae(byte[] bArr) {
        AppMethodBeat.i(41544);
        this.xGW = 0;
        this.xHq = new bw();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(41544);
            return;
        }
        try {
            this.xHq.parseFrom(bArr);
        } catch (IOException e2) {
            Log.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", e2.getMessage());
        }
        this.xHr = dVQ();
        this.xHs = dVR();
        d.aZ(this.xHr);
        d.aZ(this.xHs);
        AppMethodBeat.o(41544);
    }

    private LinkedList<c> dVQ() {
        AppMethodBeat.i(41545);
        LinkedList<c> linkedList = new LinkedList<>();
        if (this.xHq.xLZ == null || this.xHq.xLZ.xMF == null || this.xHq.xLZ.xMF.xMT == null) {
            AppMethodBeat.o(41545);
            return linkedList;
        }
        Iterator<dg> it = this.xHq.xLZ.xMF.xMT.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            dg next = it.next();
            c a2 = a(next.xIz);
            if (a2 != null) {
                a2.xEe = next.xIz.xIP;
                a2.scene = 11;
                a2.dYu = 1110;
                a2.position = i2;
                linkedList.add(a2);
                i2++;
            }
        }
        AppMethodBeat.o(41545);
        return linkedList;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private LinkedList<c> dVR() {
        AppMethodBeat.i(41546);
        LinkedList<c> linkedList = new LinkedList<>();
        if (this.xHq.xMa == null) {
            AppMethodBeat.o(41546);
            return linkedList;
        }
        int i2 = this.xGW + 1;
        int i3 = (this.xGW / 15) + 901;
        Iterator<e> it = this.xHq.xMa.iterator();
        while (it.hasNext()) {
            e next = it.next();
            c cVar = null;
            switch (next.oUv) {
                case 1:
                    cVar = a(next.xIz);
                    if (cVar != null) {
                        cVar.position = i2;
                        i3 = i3;
                        i2++;
                        break;
                    }
                    i3 = i3;
                    break;
                case 2:
                    if (!(next.xIF == null || (cVar = a(next.xIF.xIz)) == null)) {
                        cVar.type = 1;
                        cVar.xDX = next.xIF.xIB;
                        cVar.xDY = next.xIF.xIA;
                        i3++;
                        cVar.position = i3;
                        break;
                    }
                    i3 = i3;
                    break;
                default:
                    i3 = i3;
                    break;
            }
            if (cVar != null) {
                cVar.scene = 11;
                cVar.dYu = 1111;
                linkedList.add(cVar);
            }
        }
        AppMethodBeat.o(41546);
        return linkedList;
    }

    public final HashMap<Integer, String> dVS() {
        AppMethodBeat.i(41547);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.xHq.xLZ == null || this.xHq.xLZ.xMI == null) {
            AppMethodBeat.o(41547);
            return linkedHashMap;
        }
        Iterator<dt> it = this.xHq.xLZ.xMI.iterator();
        while (it.hasNext()) {
            dt next = it.next();
            int i2 = next.xLX;
            linkedHashMap.put(Integer.valueOf(i2), next.Name);
        }
        AppMethodBeat.o(41547);
        return linkedHashMap;
    }

    public final LinkedList<GameLibraryCategoriesView.a> dVT() {
        AppMethodBeat.i(41548);
        if (this.xHq.xLZ == null || this.xHq.xLZ.xMG == null) {
            AppMethodBeat.o(41548);
            return null;
        }
        int i2 = 0;
        LinkedList<GameLibraryCategoriesView.a> linkedList = new LinkedList<>();
        Iterator<q> it = this.xHq.xLZ.xMG.iterator();
        while (it.hasNext()) {
            q next = it.next();
            GameLibraryCategoriesView.a aVar = new GameLibraryCategoriesView.a();
            aVar.xTz = next.xJC;
            aVar.xjU = next.Name;
            aVar.xTA = next.xIB;
            aVar.kVZ = next.xIJ;
            i2++;
            aVar.position = i2;
            linkedList.add(aVar);
        }
        AppMethodBeat.o(41548);
        return linkedList;
    }
}
