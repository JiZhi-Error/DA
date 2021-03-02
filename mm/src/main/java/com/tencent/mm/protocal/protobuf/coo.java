package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class coo extends a {
    public int LoM;
    public dqi LpA;
    public dqi LpB;
    public dqi Lqp;
    public dqi Mjj;
    public int MmK;
    public String MmL;
    public int MuH;
    public dqi MuI;
    public dqi MuJ;
    public dqi MuK;
    public int kdY;
    public String kdZ;
    public String kea;
    public String keb;
    public int kec;
    public String keh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101823);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lqp == null) {
                b bVar = new b("Not all required fields were included: MemberName");
                AppMethodBeat.o(101823);
                throw bVar;
            } else if (this.Mjj == null) {
                b bVar2 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(101823);
                throw bVar2;
            } else if (this.LpA == null) {
                b bVar3 = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(101823);
                throw bVar3;
            } else if (this.LpB == null) {
                b bVar4 = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(101823);
                throw bVar4;
            } else if (this.MuI == null) {
                b bVar5 = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(101823);
                throw bVar5;
            } else if (this.MuJ == null) {
                b bVar6 = new b("Not all required fields were included: RemarkPYInitial");
                AppMethodBeat.o(101823);
                throw bVar6;
            } else if (this.MuK == null) {
                b bVar7 = new b("Not all required fields were included: RemarkQuanPin");
                AppMethodBeat.o(101823);
                throw bVar7;
            } else {
                if (this.Lqp != null) {
                    aVar.ni(1, this.Lqp.computeSize());
                    this.Lqp.writeFields(aVar);
                }
                aVar.aM(2, this.MuH);
                if (this.Mjj != null) {
                    aVar.ni(3, this.Mjj.computeSize());
                    this.Mjj.writeFields(aVar);
                }
                if (this.LpA != null) {
                    aVar.ni(4, this.LpA.computeSize());
                    this.LpA.writeFields(aVar);
                }
                if (this.LpB != null) {
                    aVar.ni(5, this.LpB.computeSize());
                    this.LpB.writeFields(aVar);
                }
                aVar.aM(6, this.kdY);
                if (this.MuI != null) {
                    aVar.ni(9, this.MuI.computeSize());
                    this.MuI.writeFields(aVar);
                }
                if (this.MuJ != null) {
                    aVar.ni(10, this.MuJ.computeSize());
                    this.MuJ.writeFields(aVar);
                }
                if (this.MuK != null) {
                    aVar.ni(11, this.MuK.computeSize());
                    this.MuK.writeFields(aVar);
                }
                aVar.aM(12, this.LoM);
                if (this.kdZ != null) {
                    aVar.e(13, this.kdZ);
                }
                if (this.kea != null) {
                    aVar.e(14, this.kea);
                }
                if (this.keb != null) {
                    aVar.e(15, this.keb);
                }
                aVar.aM(16, this.kec);
                aVar.aM(17, this.MmK);
                if (this.MmL != null) {
                    aVar.e(18, this.MmL);
                }
                if (this.keh != null) {
                    aVar.e(19, this.keh);
                }
                AppMethodBeat.o(101823);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.Lqp != null ? g.a.a.a.nh(1, this.Lqp.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MuH);
            if (this.Mjj != null) {
                nh += g.a.a.a.nh(3, this.Mjj.computeSize());
            }
            if (this.LpA != null) {
                nh += g.a.a.a.nh(4, this.LpA.computeSize());
            }
            if (this.LpB != null) {
                nh += g.a.a.a.nh(5, this.LpB.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.kdY);
            if (this.MuI != null) {
                bu += g.a.a.a.nh(9, this.MuI.computeSize());
            }
            if (this.MuJ != null) {
                bu += g.a.a.a.nh(10, this.MuJ.computeSize());
            }
            if (this.MuK != null) {
                bu += g.a.a.a.nh(11, this.MuK.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(12, this.LoM);
            if (this.kdZ != null) {
                bu2 += g.a.a.b.b.a.f(13, this.kdZ);
            }
            if (this.kea != null) {
                bu2 += g.a.a.b.b.a.f(14, this.kea);
            }
            if (this.keb != null) {
                bu2 += g.a.a.b.b.a.f(15, this.keb);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(16, this.kec) + g.a.a.b.b.a.bu(17, this.MmK);
            if (this.MmL != null) {
                bu3 += g.a.a.b.b.a.f(18, this.MmL);
            }
            if (this.keh != null) {
                bu3 += g.a.a.b.b.a.f(19, this.keh);
            }
            AppMethodBeat.o(101823);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lqp == null) {
                b bVar8 = new b("Not all required fields were included: MemberName");
                AppMethodBeat.o(101823);
                throw bVar8;
            } else if (this.Mjj == null) {
                b bVar9 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(101823);
                throw bVar9;
            } else if (this.LpA == null) {
                b bVar10 = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(101823);
                throw bVar10;
            } else if (this.LpB == null) {
                b bVar11 = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(101823);
                throw bVar11;
            } else if (this.MuI == null) {
                b bVar12 = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(101823);
                throw bVar12;
            } else if (this.MuJ == null) {
                b bVar13 = new b("Not all required fields were included: RemarkPYInitial");
                AppMethodBeat.o(101823);
                throw bVar13;
            } else if (this.MuK == null) {
                b bVar14 = new b("Not all required fields were included: RemarkQuanPin");
                AppMethodBeat.o(101823);
                throw bVar14;
            } else {
                AppMethodBeat.o(101823);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            coo coo = (coo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        coo.Lqp = dqi;
                    }
                    AppMethodBeat.o(101823);
                    return 0;
                case 2:
                    coo.MuH = aVar3.UbS.zi();
                    AppMethodBeat.o(101823);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        coo.Mjj = dqi2;
                    }
                    AppMethodBeat.o(101823);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi3.populateBuilderWithField(aVar6, dqi3, a.getNextFieldNumber(aVar6))) {
                        }
                        coo.LpA = dqi3;
                    }
                    AppMethodBeat.o(101823);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi4.populateBuilderWithField(aVar7, dqi4, a.getNextFieldNumber(aVar7))) {
                        }
                        coo.LpB = dqi4;
                    }
                    AppMethodBeat.o(101823);
                    return 0;
                case 6:
                    coo.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(101823);
                    return 0;
                case 7:
                case 8:
                default:
                    AppMethodBeat.o(101823);
                    return -1;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dqi dqi5 = new dqi();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dqi5.populateBuilderWithField(aVar8, dqi5, a.getNextFieldNumber(aVar8))) {
                        }
                        coo.MuI = dqi5;
                    }
                    AppMethodBeat.o(101823);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dqi dqi6 = new dqi();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dqi6.populateBuilderWithField(aVar9, dqi6, a.getNextFieldNumber(aVar9))) {
                        }
                        coo.MuJ = dqi6;
                    }
                    AppMethodBeat.o(101823);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dqi dqi7 = new dqi();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dqi7.populateBuilderWithField(aVar10, dqi7, a.getNextFieldNumber(aVar10))) {
                        }
                        coo.MuK = dqi7;
                    }
                    AppMethodBeat.o(101823);
                    return 0;
                case 12:
                    coo.LoM = aVar3.UbS.zi();
                    AppMethodBeat.o(101823);
                    return 0;
                case 13:
                    coo.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(101823);
                    return 0;
                case 14:
                    coo.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(101823);
                    return 0;
                case 15:
                    coo.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(101823);
                    return 0;
                case 16:
                    coo.kec = aVar3.UbS.zi();
                    AppMethodBeat.o(101823);
                    return 0;
                case 17:
                    coo.MmK = aVar3.UbS.zi();
                    AppMethodBeat.o(101823);
                    return 0;
                case 18:
                    coo.MmL = aVar3.UbS.readString();
                    AppMethodBeat.o(101823);
                    return 0;
                case 19:
                    coo.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(101823);
                    return 0;
            }
        } else {
            AppMethodBeat.o(101823);
            return -1;
        }
    }
}
