package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.b;
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

public final class c {
    public static void h(HashMap<String, Integer> hashMap) {
        AppMethodBeat.i(21757);
        Log.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", Integer.valueOf(hashMap.size()));
        for (String str : hashMap.keySet()) {
            ca iG = d.cgP().cgQ().aSQ().iG(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (iG != null) {
                int intValue = hashMap.get(str).intValue();
                String str2 = iG.field_talker;
                Log.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", str2, Integer.valueOf(intValue));
                az bjY = d.cgP().cgQ().aST().bjY(str2);
                if (bjY == null || bjY.field_conversationTime <= iG.field_createTime || bjY.field_conversationTime == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                    boolean z = false;
                    if (bjY == null) {
                        bjY = new az(str2);
                        z = true;
                    }
                    bjY.nv(iG.field_isSend);
                    bjY.nt(intValue + bjY.field_unReadCount);
                    bjY.aX(iG);
                    bjY.Cl(Integer.toString(iG.getType()));
                    bjY.yB((iG.field_createTime & 72057594037927935L) | (bjY.field_flag & 4611686018427387904L));
                    bjY.ns(0);
                    Log.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", Boolean.valueOf(z), str2, Long.valueOf(bjY.field_flag));
                    if (z) {
                        d.cgP().cgQ().aST().e(bjY);
                    } else {
                        d.cgP().cgQ().aST().a(bjY, str2);
                    }
                } else {
                    Log.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
            b cgQ = d.cgP().cgQ();
            if (cgQ.uin == 0) {
                b bVar = new b();
                AppMethodBeat.o(21757);
                throw bVar;
            }
            cgQ.oQH.aH(str, 0);
        }
        d.cgP().cgQ().aST().gCu();
        AppMethodBeat.o(21757);
    }

    public static boolean Eq(String str) {
        AppMethodBeat.i(21758);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(21758);
            return false;
        }
        boolean Iw = ab.Iw(str);
        AppMethodBeat.o(21758);
        return Iw;
    }

    public static long x(ca caVar) {
        AppMethodBeat.i(21759);
        as Kn = d.cgP().cgQ().aSN().Kn(caVar.field_talker);
        if (Kn == null || ((int) Kn.gMZ) == 0) {
            if (!Util.isNullOrNil(caVar.field_talker)) {
                d.cgP().cgR().i(2, caVar.field_talker);
                d.cgP().cgQ().aSN().ap(new as(caVar.field_talker));
            } else if (caVar.field_talker.endsWith("@chatroom") && d.cgP().cgQ().aSX().Kh(caVar.field_talker) == null) {
                d.cgP().cgR().i(2, caVar.field_talker);
            }
        }
        long aC = d.cgP().cgQ().aSQ().aC(caVar);
        if (aC < 0) {
            Log.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact failed: type:%d, talker:%s", Integer.valueOf(caVar.getType()), caVar.field_talker);
        }
        AppMethodBeat.o(21759);
        return aC;
    }

    public static int Kr(String str) {
        AppMethodBeat.i(21760);
        if (str == null) {
            AppMethodBeat.o(21760);
            return -1;
        } else if (str.length() <= 0) {
            AppMethodBeat.o(21760);
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                AppMethodBeat.o(21760);
                return indexOf;
            }
            AppMethodBeat.o(21760);
            return -1;
        }
    }

    public static s agI(String str) {
        AppMethodBeat.i(21761);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(21761);
            return null;
        }
        s Qq = d.cgP().cgQ().bhj().Qq(str);
        AppMethodBeat.o(21761);
        return Qq;
    }

    public static String agJ(String str) {
        AppMethodBeat.i(21762);
        String genPath = FilePathGenerator.genPath(d.cgP().cgQ().aTa(), "msg_", str, ".amr", 2);
        if (Util.isNullOrNil(genPath)) {
            AppMethodBeat.o(21762);
            return null;
        } else if (new o(genPath).exists()) {
            AppMethodBeat.o(21762);
            return genPath;
        } else {
            String str2 = d.cgP().cgQ().bij() + str;
            if (new o(str2 + ".amr").exists()) {
                com.tencent.mm.vfs.s.nx(str2 + ".amr", genPath);
            } else if (new o(str2).exists()) {
                com.tencent.mm.vfs.s.nx(str2, genPath);
            }
            AppMethodBeat.o(21762);
            return genPath;
        }
    }
}
