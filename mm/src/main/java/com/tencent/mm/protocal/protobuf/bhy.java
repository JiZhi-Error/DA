package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bhy extends dop {
    public String GaP;
    public int LSk;
    public int LSl;
    public String LSm;
    public String LSn;
    public int count;
    public String dNI;
    public String desc;
    public int scene;
    public String sign;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72476);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.dNI == null) {
                b bVar = new b("Not all required fields were included: appid");
                AppMethodBeat.o(72476);
                throw bVar;
            } else if (this.GaP == null) {
                b bVar2 = new b("Not all required fields were included: busi_id");
                AppMethodBeat.o(72476);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                aVar.aM(2, this.LSk);
                if (this.dNI != null) {
                    aVar.e(3, this.dNI);
                }
                if (this.desc != null) {
                    aVar.e(4, this.desc);
                }
                aVar.aM(5, this.LSl);
                if (this.LSm != null) {
                    aVar.e(6, this.LSm);
                }
                aVar.aM(7, this.count);
                aVar.aM(8, this.scene);
                if (this.GaP != null) {
                    aVar.e(9, this.GaP);
                }
                if (this.sign != null) {
                    aVar.e(10, this.sign);
                }
                if (this.LSn != null) {
                    aVar.e(11, this.LSn);
                }
                AppMethodBeat.o(72476);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LSk);
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(3, this.dNI);
            }
            if (this.desc != null) {
                nh += g.a.a.b.b.a.f(4, this.desc);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.LSl);
            if (this.LSm != null) {
                bu += g.a.a.b.b.a.f(6, this.LSm);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.count) + g.a.a.b.b.a.bu(8, this.scene);
            if (this.GaP != null) {
                bu2 += g.a.a.b.b.a.f(9, this.GaP);
            }
            if (this.sign != null) {
                bu2 += g.a.a.b.b.a.f(10, this.sign);
            }
            if (this.LSn != null) {
                bu2 += g.a.a.b.b.a.f(11, this.LSn);
            }
            AppMethodBeat.o(72476);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.dNI == null) {
                b bVar3 = new b("Not all required fields were included: appid");
                AppMethodBeat.o(72476);
                throw bVar3;
            } else if (this.GaP == null) {
                b bVar4 = new b("Not all required fields were included: busi_id");
                AppMethodBeat.o(72476);
                throw bVar4;
            } else {
                AppMethodBeat.o(72476);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhy bhy = (bhy) objArr[1];
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
                        bhy.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72476);
                    return 0;
                case 2:
                    bhy.LSk = aVar3.UbS.zi();
                    AppMethodBeat.o(72476);
                    return 0;
                case 3:
                    bhy.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(72476);
                    return 0;
                case 4:
                    bhy.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(72476);
                    return 0;
                case 5:
                    bhy.LSl = aVar3.UbS.zi();
                    AppMethodBeat.o(72476);
                    return 0;
                case 6:
                    bhy.LSm = aVar3.UbS.readString();
                    AppMethodBeat.o(72476);
                    return 0;
                case 7:
                    bhy.count = aVar3.UbS.zi();
                    AppMethodBeat.o(72476);
                    return 0;
                case 8:
                    bhy.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(72476);
                    return 0;
                case 9:
                    bhy.GaP = aVar3.UbS.readString();
                    AppMethodBeat.o(72476);
                    return 0;
                case 10:
                    bhy.sign = aVar3.UbS.readString();
                    AppMethodBeat.o(72476);
                    return 0;
                case 11:
                    bhy.LSn = aVar3.UbS.readString();
                    AppMethodBeat.o(72476);
                    return 0;
                default:
                    AppMethodBeat.o(72476);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72476);
            return -1;
        }
    }
}
