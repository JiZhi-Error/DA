package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ecb extends dop {
    public b Mpw;
    public String Ncc;
    public String Ncd;
    public String Nce;
    public int Ncf;
    public int Ncg;
    public int Nch;
    public int Nci;
    public ebz Ncj;
    public ebz Nck;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133198);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Mpw == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: ctx");
                AppMethodBeat.o(133198);
                throw bVar;
            } else if (this.Ncc == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: network_type");
                AppMethodBeat.o(133198);
                throw bVar2;
            } else if (this.Ncd == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: network_info");
                AppMethodBeat.o(133198);
                throw bVar3;
            } else if (this.Nce == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: device_info");
                AppMethodBeat.o(133198);
                throw bVar4;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.Mpw != null) {
                    aVar.c(2, this.Mpw);
                }
                if (this.Ncc != null) {
                    aVar.e(3, this.Ncc);
                }
                if (this.Ncd != null) {
                    aVar.e(4, this.Ncd);
                }
                if (this.Nce != null) {
                    aVar.e(5, this.Nce);
                }
                aVar.aM(6, this.Ncf);
                aVar.aM(7, this.Ncg);
                aVar.aM(8, this.Nch);
                aVar.aM(9, this.Nci);
                if (this.Ncj != null) {
                    aVar.ni(10, this.Ncj.computeSize());
                    this.Ncj.writeFields(aVar);
                }
                if (this.Nck != null) {
                    aVar.ni(11, this.Nck.computeSize());
                    this.Nck.writeFields(aVar);
                }
                AppMethodBeat.o(133198);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Mpw != null) {
                nh += g.a.a.b.b.a.b(2, this.Mpw);
            }
            if (this.Ncc != null) {
                nh += g.a.a.b.b.a.f(3, this.Ncc);
            }
            if (this.Ncd != null) {
                nh += g.a.a.b.b.a.f(4, this.Ncd);
            }
            if (this.Nce != null) {
                nh += g.a.a.b.b.a.f(5, this.Nce);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Ncf) + g.a.a.b.b.a.bu(7, this.Ncg) + g.a.a.b.b.a.bu(8, this.Nch) + g.a.a.b.b.a.bu(9, this.Nci);
            if (this.Ncj != null) {
                bu += g.a.a.a.nh(10, this.Ncj.computeSize());
            }
            if (this.Nck != null) {
                bu += g.a.a.a.nh(11, this.Nck.computeSize());
            }
            AppMethodBeat.o(133198);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Mpw == null) {
                g.a.a.b bVar5 = new g.a.a.b("Not all required fields were included: ctx");
                AppMethodBeat.o(133198);
                throw bVar5;
            } else if (this.Ncc == null) {
                g.a.a.b bVar6 = new g.a.a.b("Not all required fields were included: network_type");
                AppMethodBeat.o(133198);
                throw bVar6;
            } else if (this.Ncd == null) {
                g.a.a.b bVar7 = new g.a.a.b("Not all required fields were included: network_info");
                AppMethodBeat.o(133198);
                throw bVar7;
            } else if (this.Nce == null) {
                g.a.a.b bVar8 = new g.a.a.b("Not all required fields were included: device_info");
                AppMethodBeat.o(133198);
                throw bVar8;
            } else {
                AppMethodBeat.o(133198);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecb ecb = (ecb) objArr[1];
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
                        ecb.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(133198);
                    return 0;
                case 2:
                    ecb.Mpw = aVar3.UbS.hPo();
                    AppMethodBeat.o(133198);
                    return 0;
                case 3:
                    ecb.Ncc = aVar3.UbS.readString();
                    AppMethodBeat.o(133198);
                    return 0;
                case 4:
                    ecb.Ncd = aVar3.UbS.readString();
                    AppMethodBeat.o(133198);
                    return 0;
                case 5:
                    ecb.Nce = aVar3.UbS.readString();
                    AppMethodBeat.o(133198);
                    return 0;
                case 6:
                    ecb.Ncf = aVar3.UbS.zi();
                    AppMethodBeat.o(133198);
                    return 0;
                case 7:
                    ecb.Ncg = aVar3.UbS.zi();
                    AppMethodBeat.o(133198);
                    return 0;
                case 8:
                    ecb.Nch = aVar3.UbS.zi();
                    AppMethodBeat.o(133198);
                    return 0;
                case 9:
                    ecb.Nci = aVar3.UbS.zi();
                    AppMethodBeat.o(133198);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ebz ebz = new ebz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ebz.populateBuilderWithField(aVar5, ebz, dop.getNextFieldNumber(aVar5))) {
                        }
                        ecb.Ncj = ebz;
                    }
                    AppMethodBeat.o(133198);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ebz ebz2 = new ebz();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ebz2.populateBuilderWithField(aVar6, ebz2, dop.getNextFieldNumber(aVar6))) {
                        }
                        ecb.Nck = ebz2;
                    }
                    AppMethodBeat.o(133198);
                    return 0;
                default:
                    AppMethodBeat.o(133198);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133198);
            return -1;
        }
    }
}
