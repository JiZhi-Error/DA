package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class drj extends dop {
    public String MTQ;
    public String MTR;
    public b MTS;
    public String MTY;
    public String MTZ;
    public String dNI;
    public String scope;
    public String state;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82473);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            if (this.scope != null) {
                aVar.e(3, this.scope);
            }
            if (this.state != null) {
                aVar.e(4, this.state);
            }
            if (this.MTQ != null) {
                aVar.e(5, this.MTQ);
            }
            if (this.MTY != null) {
                aVar.e(6, this.MTY);
            }
            if (this.MTZ != null) {
                aVar.e(7, this.MTZ);
            }
            if (this.MTR != null) {
                aVar.e(13, this.MTR);
            }
            if (this.MTS != null) {
                aVar.c(14, this.MTS);
            }
            AppMethodBeat.o(82473);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            if (this.scope != null) {
                nh += g.a.a.b.b.a.f(3, this.scope);
            }
            if (this.state != null) {
                nh += g.a.a.b.b.a.f(4, this.state);
            }
            if (this.MTQ != null) {
                nh += g.a.a.b.b.a.f(5, this.MTQ);
            }
            if (this.MTY != null) {
                nh += g.a.a.b.b.a.f(6, this.MTY);
            }
            if (this.MTZ != null) {
                nh += g.a.a.b.b.a.f(7, this.MTZ);
            }
            if (this.MTR != null) {
                nh += g.a.a.b.b.a.f(13, this.MTR);
            }
            if (this.MTS != null) {
                nh += g.a.a.b.b.a.b(14, this.MTS);
            }
            AppMethodBeat.o(82473);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82473);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drj drj = (drj) objArr[1];
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
                        drj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(82473);
                    return 0;
                case 2:
                    drj.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(82473);
                    return 0;
                case 3:
                    drj.scope = aVar3.UbS.readString();
                    AppMethodBeat.o(82473);
                    return 0;
                case 4:
                    drj.state = aVar3.UbS.readString();
                    AppMethodBeat.o(82473);
                    return 0;
                case 5:
                    drj.MTQ = aVar3.UbS.readString();
                    AppMethodBeat.o(82473);
                    return 0;
                case 6:
                    drj.MTY = aVar3.UbS.readString();
                    AppMethodBeat.o(82473);
                    return 0;
                case 7:
                    drj.MTZ = aVar3.UbS.readString();
                    AppMethodBeat.o(82473);
                    return 0;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                default:
                    AppMethodBeat.o(82473);
                    return -1;
                case 13:
                    drj.MTR = aVar3.UbS.readString();
                    AppMethodBeat.o(82473);
                    return 0;
                case 14:
                    drj.MTS = aVar3.UbS.hPo();
                    AppMethodBeat.o(82473);
                    return 0;
            }
        } else {
            AppMethodBeat.o(82473);
            return -1;
        }
    }
}
