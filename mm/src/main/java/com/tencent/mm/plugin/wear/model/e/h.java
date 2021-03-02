package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.protobuf.eyr;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.log.RecoveryFileLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h extends a {
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30083);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11000);
        arrayList.add(11003);
        arrayList.add(11035);
        AppMethodBeat.o(30083);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final boolean fWf() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        AppMethodBeat.i(30084);
        if (i2 == 11000) {
            String str = new String(bArr);
            String str2 = "";
            try {
                str2 = s.boY(str);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e2, "handleData", new Object[0]);
            }
            String[] split = str2.split(RecoveryFileLog.LINE_SPLITTER);
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < split.length; i3++) {
                arrayList.add(split[i3]);
                if (i3 % 50 == 9) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.B("WearCrash", arrayList);
                    arrayList.clear();
                }
            }
            if (arrayList.size() > 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.B("WearCrash", arrayList);
                arrayList.clear();
            }
            s.deleteFile(str);
        } else if (i2 == 11003) {
            String str3 = new String(bArr);
            String str4 = "";
            try {
                str4 = s.boY(str3);
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e3, "handleData", new Object[0]);
            }
            for (String str5 : str4.split(RecoveryFileLog.LINE_SPLITTER)) {
                Log.i("MicroMsg.Wear.LOG", str5);
            }
            s.deleteFile(str3);
        } else if (i2 == 11035) {
            eyr eyr = new eyr();
            try {
                eyr.parseFrom(bArr);
            } catch (IOException e4) {
            }
            eys eys = a.fVM().IxH.Iyu;
            if (eys != null) {
                Log.v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", Integer.valueOf(eyr.xNF), eys.oTJ, eys.Nvp, Integer.valueOf(eys.KIy), eys.Nvq, eyr.KWF);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(eyr.xNF, eys.oTJ, eys.Nvp, Integer.valueOf(eys.KIy), eys.Nvq, eyr.KWF);
            }
        }
        AppMethodBeat.o(30084);
        return null;
    }
}
