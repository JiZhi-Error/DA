package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.aan;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.protobuf.ezh;
import com.tencent.mm.protocal.protobuf.ezs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class l extends a {
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30091);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11032);
        arrayList.add(11034);
        AppMethodBeat.o(30091);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final boolean afg(int i2) {
        switch (i2) {
            case 11032:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        AppMethodBeat.i(30092);
        switch (i2) {
            case 11032:
                ezh ezh = new ezh();
                if (h.aqJ().getInt("WearPayBlock", 0) == 0) {
                    a.jZ(13, 0);
                    a.aff(15);
                    aan aan = new aan();
                    aan.ehq.action = 3;
                    EventCenter.instance.publish(aan);
                    switch (aan.ehr.ehs) {
                        case 1:
                            ezh.NcY = 0;
                            ezh.MVg = "";
                            ezh.NvI = new b(aan.ehr.ehw);
                            ezh.NvJ = new b(aan.ehr.ehx);
                            ezh.NvK = aan.ehr.ehy;
                            ezh.NvL = aan.ehr.ehz;
                            break;
                        case 2:
                            ezh.NcY = 196611;
                            ezh.MVg = MMApplicationContext.getContext().getString(R.string.ixy);
                            break;
                        case 3:
                            ezh.NcY = 196609;
                            ezh.MVg = MMApplicationContext.getContext().getString(R.string.ixx);
                            break;
                        case 4:
                            ezh.NcY = 196610;
                            ezh.MVg = MMApplicationContext.getContext().getString(R.string.iy1);
                            break;
                        case 5:
                            ezh.NcY = 196612;
                            ezh.MVg = MMApplicationContext.getContext().getString(R.string.ixz);
                            break;
                    }
                } else {
                    ezh.NcY = 16777215;
                    ezh.MVg = MMApplicationContext.getContext().getString(R.string.iy0);
                }
                try {
                    byte[] byteArray = ezh.toByteArray();
                    AppMethodBeat.o(30092);
                    return byteArray;
                } catch (IOException e2) {
                    break;
                }
            case 11034:
                ezs ezs = new ezs();
                try {
                    ezs.parseFrom(bArr);
                } catch (IOException e3) {
                }
                c.V(MMApplicationContext.getContext(), ezs.NvP, ezs.NvQ);
                break;
        }
        byte[] bArr2 = new byte[0];
        AppMethodBeat.o(30092);
        return bArr2;
    }

    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final boolean afi(int i2) {
        switch (i2) {
            case 11032:
                return true;
            default:
                return false;
        }
    }
}
