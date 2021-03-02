package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bjt extends dop {
    public String HXc;
    public String KXJ;
    public String LTm;
    public String LTn;
    public String Lpg;
    public String qcM;
    public String signature;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124506);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lpg == null) {
                b bVar = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(124506);
                throw bVar;
            } else if (this.LTm == null) {
                b bVar2 = new b("Not all required fields were included: group_id");
                AppMethodBeat.o(124506);
                throw bVar2;
            } else if (this.HXc == null) {
                b bVar3 = new b("Not all required fields were included: time_stamp");
                AppMethodBeat.o(124506);
                throw bVar3;
            } else if (this.qcM == null) {
                b bVar4 = new b("Not all required fields were included: nonce_str");
                AppMethodBeat.o(124506);
                throw bVar4;
            } else if (this.signature == null) {
                b bVar5 = new b("Not all required fields were included: signature");
                AppMethodBeat.o(124506);
                throw bVar5;
            } else if (this.KXJ == null) {
                b bVar6 = new b("Not all required fields were included: from_url");
                AppMethodBeat.o(124506);
                throw bVar6;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.Lpg != null) {
                    aVar.e(2, this.Lpg);
                }
                if (this.LTm != null) {
                    aVar.e(3, this.LTm);
                }
                if (this.HXc != null) {
                    aVar.e(4, this.HXc);
                }
                if (this.qcM != null) {
                    aVar.e(5, this.qcM);
                }
                if (this.signature != null) {
                    aVar.e(6, this.signature);
                }
                if (this.KXJ != null) {
                    aVar.e(7, this.KXJ);
                }
                if (this.LTn != null) {
                    aVar.e(8, this.LTn);
                }
                AppMethodBeat.o(124506);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Lpg != null) {
                nh += g.a.a.b.b.a.f(2, this.Lpg);
            }
            if (this.LTm != null) {
                nh += g.a.a.b.b.a.f(3, this.LTm);
            }
            if (this.HXc != null) {
                nh += g.a.a.b.b.a.f(4, this.HXc);
            }
            if (this.qcM != null) {
                nh += g.a.a.b.b.a.f(5, this.qcM);
            }
            if (this.signature != null) {
                nh += g.a.a.b.b.a.f(6, this.signature);
            }
            if (this.KXJ != null) {
                nh += g.a.a.b.b.a.f(7, this.KXJ);
            }
            if (this.LTn != null) {
                nh += g.a.a.b.b.a.f(8, this.LTn);
            }
            AppMethodBeat.o(124506);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lpg == null) {
                b bVar7 = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(124506);
                throw bVar7;
            } else if (this.LTm == null) {
                b bVar8 = new b("Not all required fields were included: group_id");
                AppMethodBeat.o(124506);
                throw bVar8;
            } else if (this.HXc == null) {
                b bVar9 = new b("Not all required fields were included: time_stamp");
                AppMethodBeat.o(124506);
                throw bVar9;
            } else if (this.qcM == null) {
                b bVar10 = new b("Not all required fields were included: nonce_str");
                AppMethodBeat.o(124506);
                throw bVar10;
            } else if (this.signature == null) {
                b bVar11 = new b("Not all required fields were included: signature");
                AppMethodBeat.o(124506);
                throw bVar11;
            } else if (this.KXJ == null) {
                b bVar12 = new b("Not all required fields were included: from_url");
                AppMethodBeat.o(124506);
                throw bVar12;
            } else {
                AppMethodBeat.o(124506);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bjt bjt = (bjt) objArr[1];
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
                        bjt.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124506);
                    return 0;
                case 2:
                    bjt.Lpg = aVar3.UbS.readString();
                    AppMethodBeat.o(124506);
                    return 0;
                case 3:
                    bjt.LTm = aVar3.UbS.readString();
                    AppMethodBeat.o(124506);
                    return 0;
                case 4:
                    bjt.HXc = aVar3.UbS.readString();
                    AppMethodBeat.o(124506);
                    return 0;
                case 5:
                    bjt.qcM = aVar3.UbS.readString();
                    AppMethodBeat.o(124506);
                    return 0;
                case 6:
                    bjt.signature = aVar3.UbS.readString();
                    AppMethodBeat.o(124506);
                    return 0;
                case 7:
                    bjt.KXJ = aVar3.UbS.readString();
                    AppMethodBeat.o(124506);
                    return 0;
                case 8:
                    bjt.LTn = aVar3.UbS.readString();
                    AppMethodBeat.o(124506);
                    return 0;
                default:
                    AppMethodBeat.o(124506);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124506);
            return -1;
        }
    }
}
