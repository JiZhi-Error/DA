package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.eyv;
import com.tencent.mm.protocal.protobuf.eyw;
import java.util.List;

public final class h extends b {
    private long eht;
    private String ehu;
    private List<String> ehv;
    private long msgId;

    public h(long j2, long j3, String str, List<String> list) {
        this.msgId = j2;
        this.eht = j3;
        this.ehu = str;
        this.ehv = list;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.f.c
    public final void send() {
        AppMethodBeat.i(30128);
        eyv eyv = new eyv();
        eyv.Nvw = this.eht;
        eyv.KMm = this.msgId;
        eyv.Nvx = this.ehu;
        try {
            if (this.ehv != null) {
                for (String str : this.ehv) {
                    String[] split = str.split("=");
                    eyw eyw = new eyw();
                    eyw.MRZ = split[0];
                    eyw.oUJ = split[1];
                    if (eyw.oUJ.startsWith("wxid")) {
                        eyw.oUJ = aa.getDisplayName(eyw.oUJ);
                    }
                    eyw.Nvw = Long.valueOf(split[2]).longValue();
                    eyv.Nvy.add(eyw);
                }
            }
            a.fVQ();
            r.a(20015, eyv.toByteArray(), true);
        } catch (Exception e2) {
        }
        if (this.eht > 0) {
            com.tencent.mm.plugin.wear.model.c.a.yJ(true);
            AppMethodBeat.o(30128);
            return;
        }
        com.tencent.mm.plugin.wear.model.c.a.yJ(false);
        AppMethodBeat.o(30128);
    }

    @Override // com.tencent.mm.plugin.wear.model.f.d
    public final String getName() {
        return "WearLuckyReceiveTask";
    }
}
