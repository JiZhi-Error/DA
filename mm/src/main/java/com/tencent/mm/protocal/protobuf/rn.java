package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class rn extends dop {
    public eig KYA;
    public String KYB;
    public int KYY;
    public du KYe;
    public String token;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91381);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KYA == null) {
                b bVar = new b("Not all required fields were included: tock_mess");
                AppMethodBeat.o(91381);
                throw bVar;
            } else if (this.KYe == null) {
                b bVar2 = new b("Not all required fields were included: after_placeorder_comm_req");
                AppMethodBeat.o(91381);
                throw bVar2;
            } else if (this.token == null) {
                b bVar3 = new b("Not all required fields were included: token");
                AppMethodBeat.o(91381);
                throw bVar3;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.KYA != null) {
                    aVar.ni(2, this.KYA.computeSize());
                    this.KYA.writeFields(aVar);
                }
                if (this.KYe != null) {
                    aVar.ni(3, this.KYe.computeSize());
                    this.KYe.writeFields(aVar);
                }
                if (this.KYB != null) {
                    aVar.e(4, this.KYB);
                }
                aVar.aM(5, this.KYY);
                if (this.token != null) {
                    aVar.e(6, this.token);
                }
                AppMethodBeat.o(91381);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KYA != null) {
                nh += g.a.a.a.nh(2, this.KYA.computeSize());
            }
            if (this.KYe != null) {
                nh += g.a.a.a.nh(3, this.KYe.computeSize());
            }
            if (this.KYB != null) {
                nh += g.a.a.b.b.a.f(4, this.KYB);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KYY);
            if (this.token != null) {
                bu += g.a.a.b.b.a.f(6, this.token);
            }
            AppMethodBeat.o(91381);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KYA == null) {
                b bVar4 = new b("Not all required fields were included: tock_mess");
                AppMethodBeat.o(91381);
                throw bVar4;
            } else if (this.KYe == null) {
                b bVar5 = new b("Not all required fields were included: after_placeorder_comm_req");
                AppMethodBeat.o(91381);
                throw bVar5;
            } else if (this.token == null) {
                b bVar6 = new b("Not all required fields were included: token");
                AppMethodBeat.o(91381);
                throw bVar6;
            } else {
                AppMethodBeat.o(91381);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            rn rnVar = (rn) objArr[1];
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
                        rnVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91381);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eig eig = new eig();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eig.populateBuilderWithField(aVar5, eig, dop.getNextFieldNumber(aVar5))) {
                        }
                        rnVar.KYA = eig;
                    }
                    AppMethodBeat.o(91381);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        du duVar = new du();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = duVar.populateBuilderWithField(aVar6, duVar, dop.getNextFieldNumber(aVar6))) {
                        }
                        rnVar.KYe = duVar;
                    }
                    AppMethodBeat.o(91381);
                    return 0;
                case 4:
                    rnVar.KYB = aVar3.UbS.readString();
                    AppMethodBeat.o(91381);
                    return 0;
                case 5:
                    rnVar.KYY = aVar3.UbS.zi();
                    AppMethodBeat.o(91381);
                    return 0;
                case 6:
                    rnVar.token = aVar3.UbS.readString();
                    AppMethodBeat.o(91381);
                    return 0;
                default:
                    AppMethodBeat.o(91381);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91381);
            return -1;
        }
    }
}
