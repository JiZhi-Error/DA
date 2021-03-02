package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public final class i {

    public static class a {
        String filePath;
        int mediaType;
        u oNI;
        is oNL;
        LinkedList<u> oNM;
        boolean oNN = true;
        String oNO;
        boolean oNP;

        public a(String str, is isVar, LinkedList<u> linkedList, int i2, boolean z, boolean z2, u uVar) {
            this.filePath = str;
            this.oNL = isVar;
            this.oNM = linkedList;
            this.mediaType = i2;
            this.oNN = z;
            this.oNP = z2;
            this.oNI = uVar;
        }

        public a(String str, is isVar, LinkedList<u> linkedList, int i2, boolean z, String str2, boolean z2) {
            this.filePath = str;
            this.oNL = isVar;
            this.oNM = linkedList;
            this.mediaType = i2;
            this.oNN = z;
            this.oNO = str2;
            this.oNP = z2;
            this.oNI = null;
        }
    }

    public static int a(a aVar) {
        AppMethodBeat.i(21527);
        if (aVar.oNL == null) {
            Log.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", "backupItemInfo.backupitem");
            AppMethodBeat.o(21527);
            return 0;
        }
        int boW = (int) s.boW(aVar.filePath);
        if (boW <= 0) {
            Log.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + aVar.filePath);
            AppMethodBeat.o(21527);
            return 0;
        } else if (aVar.oNN) {
            AppMethodBeat.o(21527);
            return boW;
        } else if (aVar.oNM == null) {
            Log.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
            AppMethodBeat.o(21527);
            return 0;
        } else {
            String str = aVar.oNL.KHl.toString() + "_" + aVar.oNL.KHm.toString() + "_" + aVar.oNL.Brn + "_backup" + (aVar.oNO == null ? "" : "_" + aVar.oNO);
            Log.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", str, aVar.filePath);
            aVar.oNL.KMQ.add(new dqi().bhy(str));
            aVar.oNL.KMR.add(new dqj().ajp(aVar.mediaType));
            aVar.oNL.KMP = aVar.oNL.KMQ.size();
            if (aVar.oNI == null) {
                aVar.oNI = new u();
            }
            aVar.oNI.oUt = aVar.oNL.Brn;
            aVar.oNI.mediaId = str;
            aVar.oNI.path = aVar.filePath;
            aVar.oNI.type = aVar.mediaType;
            if (!aVar.oNP) {
                aVar.oNM.add(aVar.oNI);
            }
            AppMethodBeat.o(21527);
            return 0;
        }
    }
}
