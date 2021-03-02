package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.c.a;
import java.util.LinkedList;

public final class h extends dop {
    public String pPy;
    public String pPz;
    public int scene;
    public b ybi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225893);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.pPz == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: to_username");
                AppMethodBeat.o(225893);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.pPy != null) {
                aVar.e(2, this.pPy);
            }
            if (this.pPz != null) {
                aVar.e(3, this.pPz);
            }
            aVar.aM(4, this.scene);
            if (this.ybi != null) {
                aVar.c(5, this.ybi);
            }
            AppMethodBeat.o(225893);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.pPy != null) {
                nh += g.a.a.b.b.a.f(2, this.pPy);
            }
            if (this.pPz != null) {
                nh += g.a.a.b.b.a.f(3, this.pPz);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.scene);
            if (this.ybi != null) {
                bu += g.a.a.b.b.a.b(5, this.ybi);
            }
            AppMethodBeat.o(225893);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.pPz == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: to_username");
                AppMethodBeat.o(225893);
                throw bVar2;
            }
            AppMethodBeat.o(225893);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        hVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(225893);
                    return 0;
                case 2:
                    hVar.pPy = aVar3.UbS.readString();
                    AppMethodBeat.o(225893);
                    return 0;
                case 3:
                    hVar.pPz = aVar3.UbS.readString();
                    AppMethodBeat.o(225893);
                    return 0;
                case 4:
                    hVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(225893);
                    return 0;
                case 5:
                    hVar.ybi = aVar3.UbS.hPo();
                    AppMethodBeat.o(225893);
                    return 0;
                default:
                    AppMethodBeat.o(225893);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225893);
            return -1;
        }
    }
}
