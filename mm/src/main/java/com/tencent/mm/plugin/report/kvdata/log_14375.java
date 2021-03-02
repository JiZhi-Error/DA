package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class log_14375 extends a {
    public int clientVersion_;
    public BDStatusInfo dbStatusInfo_;
    public int device_;
    public int ds_;
    public HeavyDetailInfo heavyDetailInfo_;
    public int import_ds_;
    public SDStatusInfo sdStatusInfo_;
    public long time_stamp_;
    public int type_;
    public long uin_;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151549);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.import_ds_);
            aVar.aM(2, this.ds_);
            aVar.bb(3, this.uin_);
            aVar.aM(4, this.device_);
            aVar.aM(5, this.clientVersion_);
            aVar.bb(6, this.time_stamp_);
            aVar.aM(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                aVar.ni(8, this.dbStatusInfo_.computeSize());
                this.dbStatusInfo_.writeFields(aVar);
            }
            if (this.sdStatusInfo_ != null) {
                aVar.ni(9, this.sdStatusInfo_.computeSize());
                this.sdStatusInfo_.writeFields(aVar);
            }
            if (this.heavyDetailInfo_ != null) {
                aVar.ni(10, this.heavyDetailInfo_.computeSize());
                this.heavyDetailInfo_.writeFields(aVar);
            }
            AppMethodBeat.o(151549);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.import_ds_) + 0 + g.a.a.b.b.a.bu(2, this.ds_) + g.a.a.b.b.a.r(3, this.uin_) + g.a.a.b.b.a.bu(4, this.device_) + g.a.a.b.b.a.bu(5, this.clientVersion_) + g.a.a.b.b.a.r(6, this.time_stamp_) + g.a.a.b.b.a.bu(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                bu += g.a.a.a.nh(8, this.dbStatusInfo_.computeSize());
            }
            if (this.sdStatusInfo_ != null) {
                bu += g.a.a.a.nh(9, this.sdStatusInfo_.computeSize());
            }
            if (this.heavyDetailInfo_ != null) {
                bu += g.a.a.a.nh(10, this.heavyDetailInfo_.computeSize());
            }
            AppMethodBeat.o(151549);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(151549);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            log_14375 log_14375 = (log_14375) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    log_14375.import_ds_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151549);
                    return 0;
                case 2:
                    log_14375.ds_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151549);
                    return 0;
                case 3:
                    log_14375.uin_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151549);
                    return 0;
                case 4:
                    log_14375.device_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151549);
                    return 0;
                case 5:
                    log_14375.clientVersion_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151549);
                    return 0;
                case 6:
                    log_14375.time_stamp_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151549);
                    return 0;
                case 7:
                    log_14375.type_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151549);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BDStatusInfo bDStatusInfo = new BDStatusInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bDStatusInfo.populateBuilderWithField(aVar4, bDStatusInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        log_14375.dbStatusInfo_ = bDStatusInfo;
                    }
                    AppMethodBeat.o(151549);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SDStatusInfo sDStatusInfo = new SDStatusInfo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sDStatusInfo.populateBuilderWithField(aVar5, sDStatusInfo, a.getNextFieldNumber(aVar5))) {
                        }
                        log_14375.sdStatusInfo_ = sDStatusInfo;
                    }
                    AppMethodBeat.o(151549);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = heavyDetailInfo.populateBuilderWithField(aVar6, heavyDetailInfo, a.getNextFieldNumber(aVar6))) {
                        }
                        log_14375.heavyDetailInfo_ = heavyDetailInfo;
                    }
                    AppMethodBeat.o(151549);
                    return 0;
                default:
                    AppMethodBeat.o(151549);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151549);
            return -1;
        }
    }
}
