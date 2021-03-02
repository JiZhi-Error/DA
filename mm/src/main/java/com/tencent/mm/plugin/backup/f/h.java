package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;

public final class h {

    public static class a {
        public String md5;
        public u oNI;
        public long oNJ;
        public String oNK;
    }

    private static void al(ca caVar) {
        AppMethodBeat.i(231595);
        if (caVar != null && caVar.getType() == 10002 && (caVar.fqJ & 4) == 4) {
            caVar.setContent(MMApplicationContext.getContext().getString(R.string.b24));
            caVar.setType(10000);
        }
        AppMethodBeat.o(231595);
    }

    public static boolean Bi(int i2) {
        if (i2 == 1 || i2 == 3 || i2 == 34 || i2 == 42 || i2 == 66 || i2 == 43 || i2 == 43 || i2 == 44 || i2 == 47 || i2 == 48 || i2 == 49 || i2 == 62 || i2 == 10000) {
            return true;
        }
        return false;
    }

    public static is a(ca caVar, boolean z, String str, PLong pLong, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, boolean z3, long j2) {
        int i2;
        is isVar;
        AppMethodBeat.i(21526);
        if (caVar.field_msgSvrId == 0) {
            Log.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", caVar.field_talker, Integer.valueOf(caVar.getType()));
            AppMethodBeat.o(21526);
            return null;
        }
        al(caVar);
        int ahM = m.ahM(caVar.getType());
        if (!Bi(ahM)) {
            Log.e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", caVar.field_talker, Integer.valueOf(caVar.getType()));
            AppMethodBeat.o(21526);
            return null;
        }
        is isVar2 = new is();
        isVar2.Brn = caVar.field_msgSvrId;
        if (caVar.field_isSend == 1) {
            isVar2.KHl = new dqi().bhy(str);
            isVar2.KHm = new dqi().bhy(caVar.field_talker);
            i2 = 2;
            isVar = isVar2;
        } else {
            isVar2.KHl = new dqi().bhy(caVar.field_talker);
            isVar2.KHm = new dqi().bhy(str);
            if (z2) {
                i2 = 3;
                isVar = isVar2;
            } else {
                i2 = 4;
                isVar = isVar2;
            }
        }
        isVar.KMN = i2;
        isVar2.KMS = new SKBuiltinBuffer_t();
        isVar2.KMT = 0;
        isVar2.KMU = 0;
        isVar2.KHq = "";
        isVar2.oUv = ahM;
        isVar2.KMO = (int) (caVar.field_createTime / 1000);
        isVar2.KMW = caVar.field_createTime;
        isVar2.KMV = (int) caVar.field_msgSeq;
        isVar2.KMX = caVar.field_flag;
        dqi dqi = new dqi();
        dqi.bhy(Util.nullAs(caVar.field_content, ""));
        isVar2.KHn = dqi;
        l Bh = c.cfW().Bh(m.ahM(caVar.getType()));
        if (Bh == null) {
            Log.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", Integer.valueOf(caVar.getType()));
            AppMethodBeat.o(21526);
            return null;
        }
        int a2 = Bh.a(isVar2, z, caVar, str, linkedList, hashMap, z3, j2);
        if (a2 < 0) {
            AppMethodBeat.o(21526);
            return null;
        }
        pLong.value += (long) a2;
        pLong.value += 60;
        AppMethodBeat.o(21526);
        return isVar2;
    }
}
