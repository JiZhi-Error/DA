package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ekf extends dop {
    public String CpJ;
    public String CpP;
    public String CpQ;
    public long CrW;
    public String Lhy;
    public String Njc;
    public String Njt;
    public String dNQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72605);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.dNQ == null) {
                b bVar = new b("Not all required fields were included: req_key");
                AppMethodBeat.o(72605);
                throw bVar;
            } else if (this.CpQ == null) {
                b bVar2 = new b("Not all required fields were included: transfer_id");
                AppMethodBeat.o(72605);
                throw bVar2;
            } else if (this.CpP == null) {
                b bVar3 = new b("Not all required fields were included: transaction_id");
                AppMethodBeat.o(72605);
                throw bVar3;
            } else if (this.CpJ == null) {
                b bVar4 = new b("Not all required fields were included: receiver_openid");
                AppMethodBeat.o(72605);
                throw bVar4;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.dNQ != null) {
                    aVar.e(2, this.dNQ);
                }
                if (this.CpQ != null) {
                    aVar.e(3, this.CpQ);
                }
                if (this.CpP != null) {
                    aVar.e(4, this.CpP);
                }
                if (this.CpJ != null) {
                    aVar.e(5, this.CpJ);
                }
                aVar.bb(6, this.CrW);
                if (this.Lhy != null) {
                    aVar.e(7, this.Lhy);
                }
                if (this.Njc != null) {
                    aVar.e(8, this.Njc);
                }
                if (this.Njt != null) {
                    aVar.e(9, this.Njt);
                }
                AppMethodBeat.o(72605);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNQ != null) {
                nh += g.a.a.b.b.a.f(2, this.dNQ);
            }
            if (this.CpQ != null) {
                nh += g.a.a.b.b.a.f(3, this.CpQ);
            }
            if (this.CpP != null) {
                nh += g.a.a.b.b.a.f(4, this.CpP);
            }
            if (this.CpJ != null) {
                nh += g.a.a.b.b.a.f(5, this.CpJ);
            }
            int r = nh + g.a.a.b.b.a.r(6, this.CrW);
            if (this.Lhy != null) {
                r += g.a.a.b.b.a.f(7, this.Lhy);
            }
            if (this.Njc != null) {
                r += g.a.a.b.b.a.f(8, this.Njc);
            }
            if (this.Njt != null) {
                r += g.a.a.b.b.a.f(9, this.Njt);
            }
            AppMethodBeat.o(72605);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.dNQ == null) {
                b bVar5 = new b("Not all required fields were included: req_key");
                AppMethodBeat.o(72605);
                throw bVar5;
            } else if (this.CpQ == null) {
                b bVar6 = new b("Not all required fields were included: transfer_id");
                AppMethodBeat.o(72605);
                throw bVar6;
            } else if (this.CpP == null) {
                b bVar7 = new b("Not all required fields were included: transaction_id");
                AppMethodBeat.o(72605);
                throw bVar7;
            } else if (this.CpJ == null) {
                b bVar8 = new b("Not all required fields were included: receiver_openid");
                AppMethodBeat.o(72605);
                throw bVar8;
            } else {
                AppMethodBeat.o(72605);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekf ekf = (ekf) objArr[1];
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
                        ekf.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72605);
                    return 0;
                case 2:
                    ekf.dNQ = aVar3.UbS.readString();
                    AppMethodBeat.o(72605);
                    return 0;
                case 3:
                    ekf.CpQ = aVar3.UbS.readString();
                    AppMethodBeat.o(72605);
                    return 0;
                case 4:
                    ekf.CpP = aVar3.UbS.readString();
                    AppMethodBeat.o(72605);
                    return 0;
                case 5:
                    ekf.CpJ = aVar3.UbS.readString();
                    AppMethodBeat.o(72605);
                    return 0;
                case 6:
                    ekf.CrW = aVar3.UbS.zl();
                    AppMethodBeat.o(72605);
                    return 0;
                case 7:
                    ekf.Lhy = aVar3.UbS.readString();
                    AppMethodBeat.o(72605);
                    return 0;
                case 8:
                    ekf.Njc = aVar3.UbS.readString();
                    AppMethodBeat.o(72605);
                    return 0;
                case 9:
                    ekf.Njt = aVar3.UbS.readString();
                    AppMethodBeat.o(72605);
                    return 0;
                default:
                    AppMethodBeat.o(72605);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72605);
            return -1;
        }
    }
}
