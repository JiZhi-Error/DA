package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dso extends a {
    public String Lir;
    public String Lis;
    public dqi Lqk;
    public aer MUR;
    public dqi Mjj;
    public int MmK;
    public String MmL;
    public String MmM;
    public String MmN;
    public int MmO;
    public int kdY;
    public String kdZ;
    public String kea;
    public String keb;
    public int kec;
    public String ked;
    public String keh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117918);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lqk == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(117918);
                throw bVar;
            } else if (this.Mjj == null) {
                b bVar2 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(117918);
                throw bVar2;
            } else {
                if (this.Lqk != null) {
                    aVar.ni(1, this.Lqk.computeSize());
                    this.Lqk.writeFields(aVar);
                }
                if (this.Mjj != null) {
                    aVar.ni(2, this.Mjj.computeSize());
                    this.Mjj.writeFields(aVar);
                }
                aVar.aM(3, this.kdY);
                if (this.kdZ != null) {
                    aVar.e(4, this.kdZ);
                }
                if (this.kea != null) {
                    aVar.e(5, this.kea);
                }
                if (this.keb != null) {
                    aVar.e(6, this.keb);
                }
                aVar.aM(7, this.kec);
                aVar.aM(8, this.MmK);
                if (this.MmL != null) {
                    aVar.e(9, this.MmL);
                }
                if (this.MmM != null) {
                    aVar.e(10, this.MmM);
                }
                if (this.ked != null) {
                    aVar.e(11, this.ked);
                }
                if (this.MmN != null) {
                    aVar.e(12, this.MmN);
                }
                aVar.aM(13, this.MmO);
                if (this.keh != null) {
                    aVar.e(14, this.keh);
                }
                if (this.MUR != null) {
                    aVar.ni(15, this.MUR.computeSize());
                    this.MUR.writeFields(aVar);
                }
                if (this.Lir != null) {
                    aVar.e(16, this.Lir);
                }
                if (this.Lis != null) {
                    aVar.e(17, this.Lis);
                }
                AppMethodBeat.o(117918);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.Lqk != null ? g.a.a.a.nh(1, this.Lqk.computeSize()) + 0 : 0;
            if (this.Mjj != null) {
                nh += g.a.a.a.nh(2, this.Mjj.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.kdY);
            if (this.kdZ != null) {
                bu += g.a.a.b.b.a.f(4, this.kdZ);
            }
            if (this.kea != null) {
                bu += g.a.a.b.b.a.f(5, this.kea);
            }
            if (this.keb != null) {
                bu += g.a.a.b.b.a.f(6, this.keb);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.kec) + g.a.a.b.b.a.bu(8, this.MmK);
            if (this.MmL != null) {
                bu2 += g.a.a.b.b.a.f(9, this.MmL);
            }
            if (this.MmM != null) {
                bu2 += g.a.a.b.b.a.f(10, this.MmM);
            }
            if (this.ked != null) {
                bu2 += g.a.a.b.b.a.f(11, this.ked);
            }
            if (this.MmN != null) {
                bu2 += g.a.a.b.b.a.f(12, this.MmN);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.MmO);
            if (this.keh != null) {
                bu3 += g.a.a.b.b.a.f(14, this.keh);
            }
            if (this.MUR != null) {
                bu3 += g.a.a.a.nh(15, this.MUR.computeSize());
            }
            if (this.Lir != null) {
                bu3 += g.a.a.b.b.a.f(16, this.Lir);
            }
            if (this.Lis != null) {
                bu3 += g.a.a.b.b.a.f(17, this.Lis);
            }
            AppMethodBeat.o(117918);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lqk == null) {
                b bVar3 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(117918);
                throw bVar3;
            } else if (this.Mjj == null) {
                b bVar4 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(117918);
                throw bVar4;
            } else {
                AppMethodBeat.o(117918);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dso dso = (dso) objArr[1];
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
                        dso.Lqk = dqi;
                    }
                    AppMethodBeat.o(117918);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        dso.Mjj = dqi2;
                    }
                    AppMethodBeat.o(117918);
                    return 0;
                case 3:
                    dso.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(117918);
                    return 0;
                case 4:
                    dso.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(117918);
                    return 0;
                case 5:
                    dso.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(117918);
                    return 0;
                case 6:
                    dso.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(117918);
                    return 0;
                case 7:
                    dso.kec = aVar3.UbS.zi();
                    AppMethodBeat.o(117918);
                    return 0;
                case 8:
                    dso.MmK = aVar3.UbS.zi();
                    AppMethodBeat.o(117918);
                    return 0;
                case 9:
                    dso.MmL = aVar3.UbS.readString();
                    AppMethodBeat.o(117918);
                    return 0;
                case 10:
                    dso.MmM = aVar3.UbS.readString();
                    AppMethodBeat.o(117918);
                    return 0;
                case 11:
                    dso.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(117918);
                    return 0;
                case 12:
                    dso.MmN = aVar3.UbS.readString();
                    AppMethodBeat.o(117918);
                    return 0;
                case 13:
                    dso.MmO = aVar3.UbS.zi();
                    AppMethodBeat.o(117918);
                    return 0;
                case 14:
                    dso.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(117918);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aer aer = new aer();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aer.populateBuilderWithField(aVar6, aer, a.getNextFieldNumber(aVar6))) {
                        }
                        dso.MUR = aer;
                    }
                    AppMethodBeat.o(117918);
                    return 0;
                case 16:
                    dso.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(117918);
                    return 0;
                case 17:
                    dso.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(117918);
                    return 0;
                default:
                    AppMethodBeat.o(117918);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117918);
            return -1;
        }
    }
}
