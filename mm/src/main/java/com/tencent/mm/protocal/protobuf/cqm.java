package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cqm extends a {
    public int KDZ;
    public int KEc;
    public dqi Lqk;
    public long LuA;
    public String LuB;
    public dqi Mjj;
    public int MmK;
    public String MmL;
    public String MmM;
    public String MmN;
    public int MmO;
    public ahm MvH;
    public int MvW;
    public int Mvj;
    public int Mwc;
    public b Mwd;
    public int Mwf;
    public dqi Mwg;
    public dqi Mwh;
    public int Mwi;
    public int Mwj;
    public int Mwk;
    public int Mwl;
    public int Mwm;
    public bzs Mwn;
    public int Mwo;
    public String Mwp;
    public int kdY;
    public String kdZ;
    public String kea;
    public String keb;
    public int kec;
    public String ked;
    public int kee;
    public int kef;
    public String keg;
    public String keh;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43112);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lqk == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: UserName");
                AppMethodBeat.o(43112);
                throw bVar;
            } else if (this.Mjj == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(43112);
                throw bVar2;
            } else if (this.Mwg == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: BindEmail");
                AppMethodBeat.o(43112);
                throw bVar3;
            } else if (this.Mwh == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: BindMobile");
                AppMethodBeat.o(43112);
                throw bVar4;
            } else {
                aVar.aM(1, this.Mwf);
                if (this.Lqk != null) {
                    aVar.ni(2, this.Lqk.computeSize());
                    this.Lqk.writeFields(aVar);
                }
                if (this.Mjj != null) {
                    aVar.ni(3, this.Mjj.computeSize());
                    this.Mjj.writeFields(aVar);
                }
                aVar.aM(4, this.KDZ);
                if (this.Mwg != null) {
                    aVar.ni(5, this.Mwg.computeSize());
                    this.Mwg.writeFields(aVar);
                }
                if (this.Mwh != null) {
                    aVar.ni(6, this.Mwh.computeSize());
                    this.Mwh.writeFields(aVar);
                }
                aVar.aM(7, this.oTW);
                aVar.aM(8, this.Mwc);
                if (this.Mwd != null) {
                    aVar.c(9, this.Mwd);
                }
                aVar.aM(10, this.kdY);
                if (this.kdZ != null) {
                    aVar.e(11, this.kdZ);
                }
                if (this.kea != null) {
                    aVar.e(12, this.kea);
                }
                if (this.keb != null) {
                    aVar.e(13, this.keb);
                }
                aVar.aM(14, this.kec);
                if (this.MvH != null) {
                    aVar.ni(15, this.MvH.computeSize());
                    this.MvH.writeFields(aVar);
                }
                aVar.aM(16, this.KEc);
                aVar.aM(17, this.MmK);
                if (this.MmL != null) {
                    aVar.e(18, this.MmL);
                }
                aVar.aM(19, this.Mwi);
                aVar.aM(20, this.Mwj);
                aVar.aM(21, this.Mvj);
                aVar.aM(22, this.Mwk);
                aVar.aM(23, this.Mwl);
                if (this.MmM != null) {
                    aVar.e(24, this.MmM);
                }
                aVar.aM(25, this.Mwm);
                if (this.Mwn != null) {
                    aVar.ni(26, this.Mwn.computeSize());
                    this.Mwn.writeFields(aVar);
                }
                if (this.ked != null) {
                    aVar.e(27, this.ked);
                }
                if (this.MmN != null) {
                    aVar.e(28, this.MmN);
                }
                aVar.aM(29, this.MmO);
                aVar.aM(30, this.Mwo);
                aVar.bb(31, this.LuA);
                if (this.LuB != null) {
                    aVar.e(32, this.LuB);
                }
                aVar.aM(33, this.kef);
                aVar.aM(34, this.kee);
                if (this.keg != null) {
                    aVar.e(35, this.keg);
                }
                aVar.aM(36, this.MvW);
                if (this.Mwp != null) {
                    aVar.e(37, this.Mwp);
                }
                if (this.keh != null) {
                    aVar.e(38, this.keh);
                }
                AppMethodBeat.o(43112);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Mwf) + 0;
            if (this.Lqk != null) {
                bu += g.a.a.a.nh(2, this.Lqk.computeSize());
            }
            if (this.Mjj != null) {
                bu += g.a.a.a.nh(3, this.Mjj.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.KDZ);
            if (this.Mwg != null) {
                bu2 += g.a.a.a.nh(5, this.Mwg.computeSize());
            }
            if (this.Mwh != null) {
                bu2 += g.a.a.a.nh(6, this.Mwh.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(7, this.oTW) + g.a.a.b.b.a.bu(8, this.Mwc);
            if (this.Mwd != null) {
                bu3 += g.a.a.b.b.a.b(9, this.Mwd);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(10, this.kdY);
            if (this.kdZ != null) {
                bu4 += g.a.a.b.b.a.f(11, this.kdZ);
            }
            if (this.kea != null) {
                bu4 += g.a.a.b.b.a.f(12, this.kea);
            }
            if (this.keb != null) {
                bu4 += g.a.a.b.b.a.f(13, this.keb);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(14, this.kec);
            if (this.MvH != null) {
                bu5 += g.a.a.a.nh(15, this.MvH.computeSize());
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(16, this.KEc) + g.a.a.b.b.a.bu(17, this.MmK);
            if (this.MmL != null) {
                bu6 += g.a.a.b.b.a.f(18, this.MmL);
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(19, this.Mwi) + g.a.a.b.b.a.bu(20, this.Mwj) + g.a.a.b.b.a.bu(21, this.Mvj) + g.a.a.b.b.a.bu(22, this.Mwk) + g.a.a.b.b.a.bu(23, this.Mwl);
            if (this.MmM != null) {
                bu7 += g.a.a.b.b.a.f(24, this.MmM);
            }
            int bu8 = bu7 + g.a.a.b.b.a.bu(25, this.Mwm);
            if (this.Mwn != null) {
                bu8 += g.a.a.a.nh(26, this.Mwn.computeSize());
            }
            if (this.ked != null) {
                bu8 += g.a.a.b.b.a.f(27, this.ked);
            }
            if (this.MmN != null) {
                bu8 += g.a.a.b.b.a.f(28, this.MmN);
            }
            int bu9 = bu8 + g.a.a.b.b.a.bu(29, this.MmO) + g.a.a.b.b.a.bu(30, this.Mwo) + g.a.a.b.b.a.r(31, this.LuA);
            if (this.LuB != null) {
                bu9 += g.a.a.b.b.a.f(32, this.LuB);
            }
            int bu10 = bu9 + g.a.a.b.b.a.bu(33, this.kef) + g.a.a.b.b.a.bu(34, this.kee);
            if (this.keg != null) {
                bu10 += g.a.a.b.b.a.f(35, this.keg);
            }
            int bu11 = bu10 + g.a.a.b.b.a.bu(36, this.MvW);
            if (this.Mwp != null) {
                bu11 += g.a.a.b.b.a.f(37, this.Mwp);
            }
            if (this.keh != null) {
                bu11 += g.a.a.b.b.a.f(38, this.keh);
            }
            AppMethodBeat.o(43112);
            return bu11;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lqk == null) {
                g.a.a.b bVar5 = new g.a.a.b("Not all required fields were included: UserName");
                AppMethodBeat.o(43112);
                throw bVar5;
            } else if (this.Mjj == null) {
                g.a.a.b bVar6 = new g.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(43112);
                throw bVar6;
            } else if (this.Mwg == null) {
                g.a.a.b bVar7 = new g.a.a.b("Not all required fields were included: BindEmail");
                AppMethodBeat.o(43112);
                throw bVar7;
            } else if (this.Mwh == null) {
                g.a.a.b bVar8 = new g.a.a.b("Not all required fields were included: BindMobile");
                AppMethodBeat.o(43112);
                throw bVar8;
            } else {
                AppMethodBeat.o(43112);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cqm cqm = (cqm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cqm.Mwf = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        cqm.Lqk = dqi;
                    }
                    AppMethodBeat.o(43112);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        cqm.Mjj = dqi2;
                    }
                    AppMethodBeat.o(43112);
                    return 0;
                case 4:
                    cqm.KDZ = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi3.populateBuilderWithField(aVar6, dqi3, a.getNextFieldNumber(aVar6))) {
                        }
                        cqm.Mwg = dqi3;
                    }
                    AppMethodBeat.o(43112);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi4.populateBuilderWithField(aVar7, dqi4, a.getNextFieldNumber(aVar7))) {
                        }
                        cqm.Mwh = dqi4;
                    }
                    AppMethodBeat.o(43112);
                    return 0;
                case 7:
                    cqm.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 8:
                    cqm.Mwc = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 9:
                    cqm.Mwd = aVar3.UbS.hPo();
                    AppMethodBeat.o(43112);
                    return 0;
                case 10:
                    cqm.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 11:
                    cqm.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                case 12:
                    cqm.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                case 13:
                    cqm.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                case 14:
                    cqm.kec = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ahm ahm = new ahm();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ahm.populateBuilderWithField(aVar8, ahm, a.getNextFieldNumber(aVar8))) {
                        }
                        cqm.MvH = ahm;
                    }
                    AppMethodBeat.o(43112);
                    return 0;
                case 16:
                    cqm.KEc = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 17:
                    cqm.MmK = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 18:
                    cqm.MmL = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                case 19:
                    cqm.Mwi = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 20:
                    cqm.Mwj = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 21:
                    cqm.Mvj = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 22:
                    cqm.Mwk = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 23:
                    cqm.Mwl = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 24:
                    cqm.MmM = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                case 25:
                    cqm.Mwm = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 26:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bzs bzs = new bzs();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bzs.populateBuilderWithField(aVar9, bzs, a.getNextFieldNumber(aVar9))) {
                        }
                        cqm.Mwn = bzs;
                    }
                    AppMethodBeat.o(43112);
                    return 0;
                case 27:
                    cqm.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                case 28:
                    cqm.MmN = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                case 29:
                    cqm.MmO = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 30:
                    cqm.Mwo = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 31:
                    cqm.LuA = aVar3.UbS.zl();
                    AppMethodBeat.o(43112);
                    return 0;
                case 32:
                    cqm.LuB = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                case 33:
                    cqm.kef = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 34:
                    cqm.kee = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 35:
                    cqm.keg = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                case 36:
                    cqm.MvW = aVar3.UbS.zi();
                    AppMethodBeat.o(43112);
                    return 0;
                case 37:
                    cqm.Mwp = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                case 38:
                    cqm.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(43112);
                    return 0;
                default:
                    AppMethodBeat.o(43112);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43112);
            return -1;
        }
    }
}
