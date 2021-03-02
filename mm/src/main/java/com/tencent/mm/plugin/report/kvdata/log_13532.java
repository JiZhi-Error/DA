package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class log_13532 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public long time_stamp_;
    public int type;
    public long uin_;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151544);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.import_ds_);
            aVar.aM(2, this.ds_);
            aVar.bb(3, this.uin_);
            aVar.aM(4, this.device_);
            aVar.aM(5, this.clientVersion_);
            aVar.bb(6, this.time_stamp_);
            aVar.aM(7, this.type);
            AppMethodBeat.o(151544);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.import_ds_) + 0 + g.a.a.b.b.a.bu(2, this.ds_) + g.a.a.b.b.a.r(3, this.uin_) + g.a.a.b.b.a.bu(4, this.device_) + g.a.a.b.b.a.bu(5, this.clientVersion_) + g.a.a.b.b.a.r(6, this.time_stamp_) + g.a.a.b.b.a.bu(7, this.type);
            AppMethodBeat.o(151544);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(151544);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            log_13532 log_13532 = (log_13532) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    log_13532.import_ds_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151544);
                    return 0;
                case 2:
                    log_13532.ds_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151544);
                    return 0;
                case 3:
                    log_13532.uin_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151544);
                    return 0;
                case 4:
                    log_13532.device_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151544);
                    return 0;
                case 5:
                    log_13532.clientVersion_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151544);
                    return 0;
                case 6:
                    log_13532.time_stamp_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151544);
                    return 0;
                case 7:
                    log_13532.type = aVar3.UbS.zi();
                    AppMethodBeat.o(151544);
                    return 0;
                default:
                    AppMethodBeat.o(151544);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151544);
            return -1;
        }
    }
}
