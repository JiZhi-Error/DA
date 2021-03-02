package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public final class d {
    public static void h(HashMap<String, Integer> hashMap) {
        AppMethodBeat.i(22095);
        for (String str : hashMap.keySet()) {
            ca iG = b.chw().chx().aSQ().iG(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (iG != null) {
                int intValue = hashMap.get(str).intValue();
                String str2 = iG.field_talker;
                Log.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", str2, Integer.valueOf(intValue));
                boolean z = false;
                az bjY = b.chw().chx().aST().bjY(str2);
                if (bjY == null || bjY.field_conversationTime <= iG.field_createTime || bjY.field_conversationTime == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                    if (bjY == null) {
                        Log.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
                        Log.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", str2);
                        bjY = new az(str2);
                        z = true;
                    }
                    bjY.nv(iG.field_isSend);
                    bjY.nt(intValue + bjY.field_unReadCount);
                    bjY.aX(iG);
                    bjY.Cl(Integer.toString(iG.getType()));
                    bjY.yB((bjY.field_flag & 4611686018427387904L) | (iG.field_createTime & 72057594037927935L));
                    bjY.ns(0);
                    if (z) {
                        Log.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", str2, Long.valueOf(bjY.field_flag));
                        b.chw().chx().aST().e(bjY);
                    } else {
                        b.chw().chx().aST().a(bjY, str2);
                    }
                } else {
                    Log.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
        }
        b.chw().chx().aST().gCu();
        AppMethodBeat.o(22095);
    }

    public static boolean Eq(String str) {
        AppMethodBeat.i(22096);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(22096);
            return false;
        }
        boolean endsWith = str.endsWith("@chatroom");
        AppMethodBeat.o(22096);
        return endsWith;
    }

    public static long x(ca caVar) {
        AppMethodBeat.i(22097);
        as Kn = b.chw().chx().aSN().Kn(caVar.field_talker);
        if (Kn == null || ((int) Kn.gMZ) == 0) {
            if (!Util.isNullOrNil(caVar.field_talker)) {
                b.chw().chy().j(2, caVar.field_talker);
                b.chw().chx().aSN().ap(new as(caVar.field_talker));
            } else if (caVar.field_talker.endsWith("@chatroom") && b.chw().chx().aSX().Kh(caVar.field_talker) == null) {
                b.chw().chy().j(2, caVar.field_talker);
            }
        }
        long aC = b.chw().chx().aSQ().aC(caVar);
        if (aC < 0) {
            Log.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", Integer.valueOf(caVar.getType()), caVar.field_talker);
        }
        AppMethodBeat.o(22097);
        return aC;
    }

    public static int Kr(String str) {
        AppMethodBeat.i(22098);
        if (str == null) {
            AppMethodBeat.o(22098);
            return -1;
        } else if (str.length() <= 0) {
            AppMethodBeat.o(22098);
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                AppMethodBeat.o(22098);
                return indexOf;
            }
            AppMethodBeat.o(22098);
            return -1;
        }
    }

    public static s agI(String str) {
        AppMethodBeat.i(22099);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(22099);
            return null;
        }
        s Qq = b.chw().chx().bhj().Qq(str);
        AppMethodBeat.o(22099);
        return Qq;
    }

    public static String agJ(String str) {
        AppMethodBeat.i(22100);
        String genPath = FilePathGenerator.genPath(b.chw().chx().aTa(), "msg_", str, ".amr", 2);
        if (Util.isNullOrNil(genPath)) {
            AppMethodBeat.o(22100);
            return null;
        } else if (new o(genPath).exists()) {
            AppMethodBeat.o(22100);
            return genPath;
        } else {
            String str2 = b.chw().chx().bij() + str;
            if (new o(str2 + ".amr").exists()) {
                com.tencent.mm.vfs.s.nx(str2 + ".amr", genPath);
            } else if (new o(str2).exists()) {
                com.tencent.mm.vfs.s.nx(str2, genPath);
            }
            AppMethodBeat.o(22100);
            return genPath;
        }
    }
}
