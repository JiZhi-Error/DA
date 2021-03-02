package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public class log_13835 extends a {
    public int clientVersion_;
    public String currChatName_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public LinkedList<IMBehavior> oplist_ = new LinkedList<>();
    public long time_stamp_;
    public long uin_;

    public log_13835() {
        AppMethodBeat.i(151545);
        AppMethodBeat.o(151545);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151546);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.currChatName_ == null) {
                b bVar = new b("Not all required fields were included: currChatName_");
                AppMethodBeat.o(151546);
                throw bVar;
            }
            aVar.aM(1, this.import_ds_);
            aVar.aM(2, this.ds_);
            aVar.bb(3, this.uin_);
            aVar.aM(4, this.device_);
            aVar.aM(5, this.clientVersion_);
            aVar.bb(6, this.time_stamp_);
            if (this.currChatName_ != null) {
                aVar.e(7, this.currChatName_);
            }
            aVar.e(8, 8, this.oplist_);
            AppMethodBeat.o(151546);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.import_ds_) + 0 + g.a.a.b.b.a.bu(2, this.ds_) + g.a.a.b.b.a.r(3, this.uin_) + g.a.a.b.b.a.bu(4, this.device_) + g.a.a.b.b.a.bu(5, this.clientVersion_) + g.a.a.b.b.a.r(6, this.time_stamp_);
            if (this.currChatName_ != null) {
                bu += g.a.a.b.b.a.f(7, this.currChatName_);
            }
            int c2 = bu + g.a.a.a.c(8, 8, this.oplist_);
            AppMethodBeat.o(151546);
            return c2;
        } else if (i2 == 2) {
            this.oplist_.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.currChatName_ == null) {
                b bVar2 = new b("Not all required fields were included: currChatName_");
                AppMethodBeat.o(151546);
                throw bVar2;
            }
            AppMethodBeat.o(151546);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            log_13835 log_13835 = (log_13835) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    log_13835.import_ds_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151546);
                    return 0;
                case 2:
                    log_13835.ds_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151546);
                    return 0;
                case 3:
                    log_13835.uin_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151546);
                    return 0;
                case 4:
                    log_13835.device_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151546);
                    return 0;
                case 5:
                    log_13835.clientVersion_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151546);
                    return 0;
                case 6:
                    log_13835.time_stamp_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151546);
                    return 0;
                case 7:
                    log_13835.currChatName_ = aVar3.UbS.readString();
                    AppMethodBeat.o(151546);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        IMBehavior iMBehavior = new IMBehavior();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = iMBehavior.populateBuilderWithField(aVar4, iMBehavior, a.getNextFieldNumber(aVar4))) {
                        }
                        log_13835.oplist_.add(iMBehavior);
                    }
                    AppMethodBeat.o(151546);
                    return 0;
                default:
                    AppMethodBeat.o(151546);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151546);
            return -1;
        }
    }
}
