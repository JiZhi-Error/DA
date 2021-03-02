package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class ac {
    private static final List<a> iCP = new ArrayList();

    public interface a {
        boolean a(String str, String str2, PInt pInt);
    }

    public static int JP(String str) {
        AppMethodBeat.i(42933);
        if (!g.aAc()) {
            Log.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
            AppMethodBeat.o(42933);
            return 0;
        }
        long currentTicks = Util.currentTicks();
        int i2 = 0;
        for (az azVar : JQ(str).values()) {
            i2 = azVar.field_unReadCount + i2;
        }
        Log.i("MicroMsg.ConversationLogic", "get count %d with black list use %d ms", Integer.valueOf(i2), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(42933);
        return i2;
    }

    public static HashMap<String, az> JQ(String str) {
        AppMethodBeat.i(225943);
        long currentTicks = Util.currentTicks();
        Cursor bki = ((l) g.af(l.class)).aST().bki(str);
        HashMap<String, az> hashMap = new HashMap<>();
        if (bki == null) {
            AppMethodBeat.o(225943);
            return hashMap;
        }
        HashSet hashSet = new HashSet();
        while (bki.moveToNext()) {
            az azVar = new az();
            azVar.convertFrom(bki);
            hashSet.add(azVar.field_username);
            hashMap.put(azVar.field_username, azVar);
        }
        bki.close();
        for (String str2 : g(hashSet)) {
            hashMap.remove(str2);
        }
        Log.i("MicroMsg.ConversationLogic", "[getUnreadConversation] cost %d ms  unread conversations: %s, stack:%s", Long.valueOf(Util.ticksToNow(currentTicks)), hashMap.keySet(), Util.getStack());
        AppMethodBeat.o(225943);
        return hashMap;
    }

    public static int aI(String str, String str2) {
        int i2;
        AppMethodBeat.i(42935);
        if (!g.aAc()) {
            Log.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
            AppMethodBeat.o(42935);
            return 0;
        }
        Cursor mT = ((l) g.af(l.class)).aST().mT(str, str2);
        if (mT == null || mT.getCount() <= 0) {
            i2 = 0;
        } else {
            mT.moveToFirst();
            i2 = mT.getInt(0);
        }
        if (mT != null) {
            mT.close();
        }
        AppMethodBeat.o(42935);
        return i2;
    }

    public static Map<String, as> JR(String str) {
        AppMethodBeat.i(225944);
        HashMap hashMap = new HashMap();
        if (!g.aAc()) {
            Log.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
            AppMethodBeat.o(225944);
            return hashMap;
        }
        long currentTicks = Util.currentTicks();
        Cursor bkj = ((l) g.af(l.class)).aST().bkj(str);
        if (bkj != null) {
            List<String> aVd = aVd();
            while (bkj.moveToNext()) {
                as asVar = new as();
                asVar.convertFrom(bkj);
                if (aVd.contains(asVar.field_username) || K(asVar)) {
                    Log.d("MicroMsg.ConversationLogic", "ignore contact %s", asVar.field_username);
                } else {
                    hashMap.put(asVar.field_username, asVar);
                }
            }
            bkj.close();
        }
        Log.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms  unread contact: %s, stack %s", Long.valueOf(Util.ticksToNow(currentTicks)), hashMap.keySet(), Util.getStack());
        AppMethodBeat.o(225944);
        return hashMap;
    }

    private static Set<String> g(Set<String> set) {
        Cursor iL;
        AppMethodBeat.i(225945);
        List<String> aVd = aVd();
        HashSet hashSet = new HashSet(aVd);
        HashSet hashSet2 = new HashSet(set);
        hashSet2.removeAll(aVd);
        if (!hashSet2.isEmpty() && (iL = ((l) g.af(l.class)).aSN().iL(new ArrayList(hashSet2))) != null) {
            while (iL.moveToNext()) {
                as asVar = new as();
                asVar.convertFrom(iL);
                if (K(asVar)) {
                    Log.d("MicroMsg.ConversationLogic", "ignore contact %s", asVar.field_username);
                    hashSet.add(asVar.field_username);
                }
            }
            iL.close();
        }
        AppMethodBeat.o(225945);
        return hashSet;
    }

    public static boolean JS(String str) {
        AppMethodBeat.i(225946);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(225946);
            return false;
        } else if (aVd().contains(str)) {
            AppMethodBeat.o(225946);
            return true;
        } else {
            boolean K = K(((l) g.af(l.class)).aSN().Kn(str));
            AppMethodBeat.o(225946);
            return K;
        }
    }

    private static boolean K(as asVar) {
        AppMethodBeat.i(225947);
        if (!(asVar == null || ((int) asVar.gMZ) == 0)) {
            if (asVar.Zx() && asVar.amU()) {
                AppMethodBeat.o(225947);
                return true;
            } else if (ab.Eq(asVar.field_username) && asVar.fuH == 0) {
                AppMethodBeat.o(225947);
                return true;
            }
        }
        AppMethodBeat.o(225947);
        return false;
    }

    public static int aJ(String str, String str2) {
        boolean z;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(42938);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42938);
            return 0;
        }
        if ("notification_messages".equals(str)) {
            i2 = 8;
        } else if (str2 == null || !str2.endsWith("@chatroom")) {
            PInt pInt = new PInt();
            synchronized (iCP) {
                int i4 = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        if (i4 >= iCP.size()) {
                            z = z2;
                            break;
                        }
                        a aVar = iCP.get(i4);
                        if (aVar != null) {
                            z = aVar.a(str, str2, pInt);
                            if (z) {
                                i3 = pInt.value;
                                break;
                            }
                        } else {
                            z = z2;
                        }
                        i4++;
                        z2 = z;
                    } finally {
                        AppMethodBeat.o(42938);
                    }
                }
            }
            if (!z) {
                i2 = 1;
            } else {
                i2 = i3;
            }
        } else {
            i2 = 2;
        }
        return i2;
    }

    static {
        AppMethodBeat.i(42940);
        AppMethodBeat.o(42940);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(42939);
        Assert.assertNotNull(aVar);
        synchronized (iCP) {
            try {
                iCP.add(aVar);
            } finally {
                AppMethodBeat.o(42939);
            }
        }
    }

    public static List<String> aVd() {
        AppMethodBeat.i(225948);
        ArrayList arrayList = new ArrayList();
        arrayList.add("floatbottle");
        if (!g.aAh().azQ().getBoolean(ar.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("notifymessage");
            Log.d("MicroMsg.ConversationLogic", "add service notify message into show unread count blacklist.");
        }
        if (!g.aAh().azQ().getBoolean(ar.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("appbrandcustomerservicemsg");
            Log.d("MicroMsg.ConversationLogic", "add wxa custom session notify message into show unread count blacklist.");
        }
        arrayList.add("appbrand_notify_message");
        arrayList.add("officialaccounts");
        Log.d("MicroMsg.ConversationLogic", "getUnreadCountBlacklist blacklist(%s).", arrayList);
        AppMethodBeat.o(225948);
        return arrayList;
    }

    public static int JT(String str) {
        AppMethodBeat.i(225949);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(225949);
            return 0;
        } else if (ab.Eq(str)) {
            if (ab.JI(str)) {
                AppMethodBeat.o(225949);
                return 3;
            }
            AppMethodBeat.o(225949);
            return 4;
        } else if (ab.Js(str)) {
            AppMethodBeat.o(225949);
            return 5;
        } else if (ab.JB(str) || ab.JC(str) || ab.Jx(str)) {
            AppMethodBeat.o(225949);
            return 7;
        } else if (ab.Jz(str)) {
            AppMethodBeat.o(225949);
            return 8;
        } else if (ab.IT(str)) {
            AppMethodBeat.o(225949);
            return 6;
        } else if (ab.JJ(str)) {
            AppMethodBeat.o(225949);
            return 2;
        } else {
            AppMethodBeat.o(225949);
            return 1;
        }
    }
}
