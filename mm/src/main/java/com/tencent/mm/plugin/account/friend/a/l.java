package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l {
    private static Map<String, String> keI = null;

    public enum a {
        NO_INIT,
        SET_MOBILE,
        SUCC,
        SUCC_UNLOAD;

        public static a valueOf(String str) {
            AppMethodBeat.i(131022);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(131022);
            return aVar;
        }

        static {
            AppMethodBeat.i(131023);
            AppMethodBeat.o(131023);
        }
    }

    public static void gl(boolean z) {
        AppMethodBeat.i(131024);
        if (z && !((Boolean) g.aAh().azQ().get(12322, Boolean.FALSE)).booleanValue()) {
            g.aAh().azQ().set(ar.a.USERINFO_ACCOUNT_MANAGER_NEW_ACCOUNTS_BOOLEAN_SYNC, Boolean.TRUE);
        }
        g.aAh().azQ().set(12322, Boolean.valueOf(z));
        AppMethodBeat.o(131024);
    }

    public static boolean bnX() {
        AppMethodBeat.i(131025);
        if (g.aAh() == null || g.aAh().azQ() == null) {
            Log.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMKernel.storage() is null!!!");
            AppMethodBeat.o(131025);
            return false;
        }
        boolean nullAs = Util.nullAs((Boolean) g.aAh().azQ().get(12322, Boolean.TRUE), true);
        AppMethodBeat.o(131025);
        return nullAs;
    }

    public static boolean bnY() {
        AppMethodBeat.i(131026);
        a bnZ = bnZ();
        Log.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", bnZ.toString());
        if (bnZ == a.SUCC) {
            boolean nullAs = Util.nullAs((Boolean) g.aAh().azQ().get(12322, Boolean.FALSE), false);
            Log.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", Boolean.valueOf(nullAs));
            if (!nullAs) {
                AppMethodBeat.o(131026);
                return true;
            }
            AppMethodBeat.o(131026);
            return false;
        }
        AppMethodBeat.o(131026);
        return false;
    }

    public static a bnZ() {
        AppMethodBeat.i(131027);
        try {
            String str = (String) g.aAh().azQ().get(4097, "");
            String str2 = (String) g.aAh().azQ().get(6, "");
            boolean aUI = z.aUI();
            Log.i("MicroMsg.FriendLogic", "isUpload " + aUI + " stat " + z.aUc());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && str2 == null) {
                a aVar = a.NO_INIT;
                AppMethodBeat.o(131027);
                return aVar;
            } else if (str != null && str2 == null) {
                a aVar2 = a.SET_MOBILE;
                AppMethodBeat.o(131027);
                return aVar2;
            } else if (aUI) {
                a aVar3 = a.SUCC;
                AppMethodBeat.o(131027);
                return aVar3;
            } else {
                a aVar4 = a.SUCC_UNLOAD;
                AppMethodBeat.o(131027);
                return aVar4;
            }
        } catch (Exception e2) {
            a aVar5 = a.NO_INIT;
            AppMethodBeat.o(131027);
            return aVar5;
        }
    }

    public static void boa() {
        AppMethodBeat.i(131028);
        g.aAh().azQ().set(4097, "");
        g.aAh().azQ().set(6, "");
        AppMethodBeat.o(131028);
    }

    public static String bob() {
        AppMethodBeat.i(131029);
        String str = (String) g.aAh().azQ().get(6, "");
        AppMethodBeat.o(131029);
        return str;
    }

    public static boolean boc() {
        boolean z;
        AppMethodBeat.i(131030);
        boolean aAc = g.aAc();
        if (!aAc) {
            Log.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", Boolean.valueOf(aAc));
            AppMethodBeat.o(131030);
            return false;
        }
        if (bnZ() == a.SUCC) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Log.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", Boolean.FALSE);
            AppMethodBeat.o(131030);
            return false;
        }
        boolean bnX = bnX();
        if (!bnX) {
            Log.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", Boolean.valueOf(bnX));
            AppMethodBeat.o(131030);
            return false;
        }
        AppMethodBeat.o(131030);
        return true;
    }

    public static boolean bod() {
        return true;
    }

    public static void boe() {
    }

    public static boolean a(String str, Context context, byte[] bArr) {
        AppMethodBeat.i(131032);
        boolean b2 = b.b(str, context, bArr);
        AppMethodBeat.o(131032);
        return b2;
    }

    public static void bof() {
        AppMethodBeat.i(131033);
        b bVar = (b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
        int delete = bVar.iFy.delete("addr_upload2", null, null);
        Log.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
        if (delete > 0) {
            bVar.doNotify(5, bVar, null);
        }
        AppMethodBeat.o(131033);
    }

    public static void bog() {
        AppMethodBeat.i(131034);
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eix().eiD()).iterator();
        while (it.hasNext()) {
            bn bnVar = (bn) it.next();
            ca.a aEK = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEK(bnVar.field_msgContent);
            if (aEK != null && (aEK.scene == 10 || aEK.scene == 11)) {
                hashSet.add(bnVar.field_talker);
            }
        }
        Log.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Tb((String) it2.next());
        }
        AppMethodBeat.o(131034);
    }

    private static void Tb(String str) {
        AppMethodBeat.i(131035);
        Log.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", 0L, str);
        Log.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiw().x(0, str))));
        Log.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eix().aEn(str))));
        AppMethodBeat.o(131035);
    }

    public static void aV(List<String> list) {
        AppMethodBeat.i(131036);
        if (list.size() == 0) {
            AppMethodBeat.o(131036);
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eix().eiD()).iterator();
        while (it.hasNext()) {
            bn bnVar = (bn) it.next();
            ca.a aEK = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEK(bnVar.field_msgContent);
            if (aEK != null) {
                String str = aEK.OqL;
                String str2 = aEK.OqK;
                if ((aEK.scene == 10 || aEK.scene == 11) && (list.contains(str) || list.contains(str2))) {
                    hashSet.add(bnVar.field_talker);
                }
            }
        }
        Log.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Tb((String) it2.next());
        }
        AppMethodBeat.o(131036);
    }

    public static String Tc(String str) {
        AppMethodBeat.i(131037);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(131037);
            return "";
        }
        Cursor rawQuery = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).iFy.rawQuery("select addr_upload2.realname from addr_upload2 where addr_upload2.id = " + a.SQ(str), null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(131037);
            return "";
        }
        String str2 = "";
        if (rawQuery.moveToFirst()) {
            str2 = rawQuery.getString(0);
        }
        rawQuery.close();
        AppMethodBeat.o(131037);
        return str2;
    }

    public static void aW(List<a> list) {
        AppMethodBeat.i(131038);
        if (list == null) {
            Log.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
            AppMethodBeat.o(131038);
            return;
        }
        ((b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).av(list);
        AppMethodBeat.o(131038);
    }

    public static void aX(List<String> list) {
        AppMethodBeat.i(131039);
        if (list == null) {
            Log.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
            AppMethodBeat.o(131039);
            return;
        }
        ((b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aU(list);
        AppMethodBeat.o(131039);
    }

    public static List<String> boh() {
        AppMethodBeat.i(131040);
        Cursor rawQuery = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).iFy.rawQuery("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(0));
        }
        rawQuery.close();
        AppMethodBeat.o(131040);
        return arrayList;
    }

    public static List<String> boi() {
        AppMethodBeat.i(131041);
        Cursor rawQuery = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).iFy.rawQuery("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            String Ts = b.Ts(rawQuery.getString(0));
            if (b.bcT(Ts)) {
                arrayList.add(Ts);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(131041);
        return arrayList;
    }

    public static boolean vh(int i2) {
        AppMethodBeat.i(131042);
        aq vi = ((ar) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).vi(i2);
        boolean vj = ((at) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).vj(i2);
        if (vi == null) {
            AppMethodBeat.o(131042);
            return false;
        } else if (vi.kfK == 1 || vj) {
            AppMethodBeat.o(131042);
            return true;
        } else {
            AppMethodBeat.o(131042);
            return false;
        }
    }

    public static Bitmap a(String str, Context context) {
        AppMethodBeat.i(131031);
        Bitmap a2 = b.a(str, context, false);
        AppMethodBeat.o(131031);
        return a2;
    }
}
