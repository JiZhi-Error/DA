package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.q;
import com.tencent.mm.api.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public static String fqK = null;
    public static final Object iPQ = new Object();

    static {
        AppMethodBeat.i(124241);
        AppMethodBeat.o(124241);
    }

    public static boolean NF(String str) {
        AppMethodBeat.i(124218);
        if (str == null) {
            AppMethodBeat.o(124218);
            return false;
        } else if (str.endsWith("@qy_u") || str.endsWith("@qy_g")) {
            AppMethodBeat.o(124218);
            return true;
        } else {
            AppMethodBeat.o(124218);
            return false;
        }
    }

    public static boolean NG(String str) {
        AppMethodBeat.i(124219);
        if (str == null) {
            Log.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
            AppMethodBeat.o(124219);
            return false;
        }
        boolean endsWith = str.endsWith("@qy_g");
        AppMethodBeat.o(124219);
        return endsWith;
    }

    public static boolean c(c cVar) {
        AppMethodBeat.i(124220);
        if (cVar == null) {
            AppMethodBeat.o(124220);
            return false;
        }
        List<String> bax = cVar.bax();
        String fC = ((l) g.af(l.class)).fC(cVar.field_brandUserName);
        if (fC == null) {
            Log.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
            AppMethodBeat.o(124220);
            return false;
        }
        for (String str : bax) {
            if (fC.equals(str)) {
                AppMethodBeat.o(124220);
                return true;
            }
        }
        Log.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", fC);
        Log.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", Arrays.toString(bax.toArray()));
        AppMethodBeat.o(124220);
        return false;
    }

    public static int Ar(long j2) {
        AppMethodBeat.i(124221);
        List<String> As = As(j2);
        if (As != null) {
            int size = As.size();
            AppMethodBeat.o(124221);
            return size;
        }
        Log.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
        AppMethodBeat.o(124221);
        return 0;
    }

    public static List<String> As(long j2) {
        AppMethodBeat.i(124222);
        List<String> bax = ag.baj().bs(j2).bax();
        AppMethodBeat.o(124222);
        return bax;
    }

    public static String NH(String str) {
        AppMethodBeat.i(124223);
        if (str == null) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
            AppMethodBeat.o(124223);
            return null;
        }
        k fB = ag.bal().fB(str);
        if (fB != null) {
            String str2 = fB.field_userName;
            AppMethodBeat.o(124223);
            return str2;
        }
        Log.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
        AppMethodBeat.o(124223);
        return null;
    }

    public static String NI(String str) {
        AppMethodBeat.i(124224);
        k fB = ag.bal().fB(str);
        if (fB != null) {
            String str2 = fB.field_headImageUrl;
            AppMethodBeat.o(124224);
            return str2;
        }
        AppMethodBeat.o(124224);
        return null;
    }

    public static c a(c cVar, long j2) {
        AppMethodBeat.i(124225);
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j2);
        objArr[1] = Long.valueOf(cVar == null ? -1 : cVar.field_bizChatLocalId);
        Log.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ", objArr);
        if (cVar == null) {
            c cVar2 = new c();
            cVar2.field_bizChatLocalId = j2;
            ag.baj().b(cVar2);
            cVar = ag.baj().bs(j2);
        }
        AppMethodBeat.o(124225);
        return cVar;
    }

    public static k a(k kVar, String str) {
        AppMethodBeat.i(124226);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = kVar == null ? -1 : kVar.field_userId;
        Log.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist userId:%s BizChatUserInfo:%s ", objArr);
        if (kVar == null) {
            k kVar2 = new k();
            kVar2.field_userId = str;
            ag.bal().b(kVar2);
            kVar = ag.bal().fB(str);
            if (kVar == null) {
                Log.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
                AppMethodBeat.o(124226);
                return kVar2;
            }
        }
        AppMethodBeat.o(124226);
        return kVar;
    }

    public static k NJ(String str) {
        k kVar = null;
        AppMethodBeat.i(124227);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
            AppMethodBeat.o(124227);
        } else {
            f NO = ag.bam().NO(str);
            if (NO == null) {
                Log.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
                AppMethodBeat.o(124227);
            } else {
                kVar = ag.bal().fB(NO.field_userId);
                if (kVar == null) {
                    Log.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
                }
                AppMethodBeat.o(124227);
            }
        }
        return kVar;
    }

    public static String NK(String str) {
        AppMethodBeat.i(124228);
        if (str == null) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
            AppMethodBeat.o(124228);
            return null;
        }
        int indexOf = str.indexOf("<enterprise_info>") + 17;
        int indexOf2 = str.indexOf("</enterprise_info>");
        if (indexOf == -1 || indexOf2 == -1 || indexOf >= indexOf2) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", Integer.valueOf(indexOf), Integer.valueOf(indexOf2));
            AppMethodBeat.o(124228);
            return null;
        }
        String substring = str.substring(indexOf, indexOf2);
        String replace = str.replace(substring, substring.replace("<", "&lt;").replace(">", "&gt;"));
        AppMethodBeat.o(124228);
        return replace;
    }

    public static String ajw() {
        String str;
        synchronized (iPQ) {
            str = fqK;
        }
        return str;
    }

    public static String d(c cVar) {
        AppMethodBeat.i(124229);
        if (cVar == null) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
            AppMethodBeat.o(124229);
            return null;
        }
        Log.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
        if (cVar.field_bizChatServId == null) {
            Log.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", cVar.field_bizChatServId);
            AppMethodBeat.o(124229);
            return null;
        }
        k NJ = NJ(cVar.field_brandUserName);
        if (NJ == null || NJ.field_userId == null) {
            Log.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", cVar.field_bizChatServId);
            AppMethodBeat.o(124229);
            return null;
        }
        synchronized (iPQ) {
            try {
                String str = NJ.field_userId;
                fqK = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id><climsgid>%s</climsgid></enterprise_info></msgsource>", 1, cVar.field_bizChatServId, Integer.valueOf(cVar.field_chatVersion), NJ.field_userId, Long.valueOf(cVar.field_bizChatLocalId), 2 + Util.nowSecond() + str + a.iPW.nextInt());
            } catch (Throwable th) {
                AppMethodBeat.o(124229);
                throw th;
            }
        }
        Log.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", fqK);
        String str2 = fqK;
        AppMethodBeat.o(124229);
        return str2;
    }

    static final class a {
        static final Random iPW = new Random(Util.nowMilliSecond());

        static {
            AppMethodBeat.i(124217);
            AppMethodBeat.o(124217);
        }
    }

    public static void NL(String str) {
        synchronized (iPQ) {
            fqK = str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        if (com.tencent.mm.al.ag.baj().a(r5) == false) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.al.a.c e(com.tencent.mm.al.a.c r5) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.al.a.e.e(com.tencent.mm.al.a.c):com.tencent.mm.al.a.c");
    }

    public static boolean f(c cVar) {
        AppMethodBeat.i(124231);
        Log.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
        if (cVar == null) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
            AppMethodBeat.o(124231);
            return false;
        }
        List<String> bax = cVar.bax();
        if (bax == null) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
            AppMethodBeat.o(124231);
            return false;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (String str : bax) {
            k fB = ag.bal().fB(str);
            if (fB != null && fB.bay()) {
                linkedList.add(str);
            }
        }
        if (linkedList.size() > 0) {
            ag.baq().c(linkedList, cVar.field_brandUserName);
            AppMethodBeat.o(124231);
            return true;
        }
        Log.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
        AppMethodBeat.o(124231);
        return false;
    }

    public static String At(long j2) {
        AppMethodBeat.i(124232);
        String str = ag.baj().bs(j2).field_bizChatServId;
        AppMethodBeat.o(124232);
        return str;
    }

    public static long NM(String str) {
        AppMethodBeat.i(124233);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
            AppMethodBeat.o(124233);
            return -1;
        }
        c NE = ag.baj().NE(str);
        if (NE != null) {
            long j2 = NE.field_bizChatLocalId;
            AppMethodBeat.o(124233);
            return j2;
        }
        Log.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
        AppMethodBeat.o(124233);
        return -1;
    }

    public static void P(final String str, final boolean z) {
        AppMethodBeat.i(124234);
        if (Util.isNullOrNil(str)) {
            Log.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
            AppMethodBeat.o(124234);
            return;
        }
        Log.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.al.a.e.AnonymousClass1 */
            final /* synthetic */ bp.a iBS = null;

            public final void run() {
                AppMethodBeat.i(124214);
                ag.bak().NA(str);
                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjW(str);
                d baj = ag.baj();
                String str = str;
                StringBuilder sb = new StringBuilder();
                sb.append("delete from BizChatInfo");
                sb.append(" where brandUserName = '").append(str).append("' ");
                String sb2 = sb.toString();
                boolean execSQL = baj.db.execSQL("BizChatInfo", sb2);
                Log.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", sb2, Boolean.valueOf(execSQL));
                if (execSQL) {
                    c cVar = new c();
                    d.a.b bVar = new d.a.b();
                    bVar.iPE = -1;
                    bVar.brandName = str;
                    bVar.iPO = d.a.EnumC0249a.DELETE;
                    bVar.iPP = cVar;
                    baj.iNS.event(bVar);
                    baj.iNS.doNotify();
                }
                s.dy(e.fe(str), true);
                if (z) {
                    l bal = ag.bal();
                    String str2 = str;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("delete from BizChatUserInfo");
                    sb3.append(" where brandUserName = '").append(str2).append("' ");
                    String sb4 = sb3.toString();
                    boolean execSQL2 = bal.db.execSQL("BizChatUserInfo", sb4);
                    Log.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", sb4, Boolean.valueOf(execSQL2));
                    if (execSQL2) {
                        k kVar = new k();
                        l.a.b bVar2 = new l.a.b();
                        bVar2.iQx = l.a.EnumC0251a.DELETE;
                        bVar2.iQy = kVar;
                        bal.iNS.event(bVar2);
                        bal.iNS.doNotify();
                    }
                    ag.bam().NA(str);
                    s.dy(e.NN(str), true);
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.al.a.e.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(124213);
                        if (AnonymousClass1.this.iBS != null) {
                            AnonymousClass1.this.iBS.amH();
                        }
                        AppMethodBeat.o(124213);
                    }
                });
                AppMethodBeat.o(124214);
            }

            public final String toString() {
                AppMethodBeat.i(124215);
                String str = super.toString() + "|deleteMsgByTalkers";
                AppMethodBeat.o(124215);
                return str;
            }
        });
        AppMethodBeat.o(124234);
    }

    public static void n(final String str, final String str2, final String str3) {
        AppMethodBeat.i(124235);
        Log.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", str, str2, str3);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.al.a.e.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(124216);
                c NE = ag.baj().NE(str2);
                if (NE == null) {
                    AppMethodBeat.o(124216);
                    return;
                }
                if (NE.field_chatVersion < Util.getInt(str3, Integer.MAX_VALUE)) {
                    NE.field_needToUpdate = true;
                    ag.baj().b(NE);
                }
                if (NE.isGroup()) {
                    ag.baq().bj(NE.field_bizChatServId, str);
                    AppMethodBeat.o(124216);
                    return;
                }
                ag.baq().bl(NE.field_bizChatServId, str);
                AppMethodBeat.o(124216);
            }
        });
        AppMethodBeat.o(124235);
    }

    public static String fe(String str) {
        AppMethodBeat.i(124236);
        String fe = com.tencent.mm.api.a.fe(str);
        AppMethodBeat.o(124236);
        return fe;
    }

    public static boolean a(c cVar, String str, String str2, bfs bfs) {
        boolean z;
        AppMethodBeat.i(124238);
        if (str != null && !Util.isNullOrNil(cVar.field_brandUserName)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() != 1 || !Util.isNullOrNil(str2)) {
                    LinkedList<nv> linkedList = new LinkedList<>();
                    if (!Util.isNullOrNil(str2)) {
                        nv nvVar = new nv();
                        nvVar.KTu = str2;
                        linkedList.add(nvVar);
                    }
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        k kVar = new k();
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        kVar.field_userId = jSONObject.getString("id");
                        kVar.field_userName = jSONObject.getString("nick_name");
                        kVar.field_brandUserName = cVar.field_brandUserName;
                        kVar.field_headImageUrl = jSONObject.getString("head_img_url");
                        kVar.field_profileUrl = jSONObject.getString("profile_url");
                        kVar.field_UserVersion = jSONObject.getInt("ver");
                        kVar.field_addMemberUrl = cVar.field_addMemberUrl;
                        if (!ag.bal().b(kVar)) {
                            ag.bal().a(kVar);
                        }
                        nv nvVar2 = new nv();
                        nvVar2.KTu = kVar.field_userId;
                        linkedList.add(nvVar2);
                    }
                    bfs.KTv = linkedList;
                    cVar.field_bizChatLocalId = -1;
                    AppMethodBeat.o(124238);
                    return true;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                String string = jSONObject2.getString("id");
                k fB = ag.bal().fB(string);
                if (fB == null) {
                    fB = new k();
                    z = true;
                } else {
                    z = false;
                }
                fB.field_userId = string;
                fB.field_userName = jSONObject2.getString("nick_name");
                fB.field_headImageUrl = jSONObject2.getString("head_img_url");
                fB.field_profileUrl = jSONObject2.getString("profile_url");
                fB.field_UserVersion = jSONObject2.getInt("ver");
                if (fB.field_brandUserName == null || fB.field_brandUserName.length() == 0) {
                    fB.field_brandUserName = cVar.field_brandUserName;
                    z = true;
                }
                if (fB.field_addMemberUrl == null || fB.field_addMemberUrl.length() == 0) {
                    fB.field_addMemberUrl = cVar.field_addMemberUrl;
                    z = true;
                }
                if (!ag.bal().b(fB)) {
                    ag.bal().a(fB);
                }
                if (z) {
                    ag.baq().bm(fB.field_userId, fB.field_brandUserName);
                }
                c cVar2 = new c();
                cVar2.field_bizChatServId = fB.field_userId;
                cVar2.field_brandUserName = fB.field_brandUserName;
                cVar2.field_chatName = fB.field_userName;
                cVar2.field_chatType = j.BIZ_CHAT_TYPE_GROUP.iQq;
                c e2 = e(cVar2);
                if (e2 != null) {
                    cVar.field_bizChatLocalId = e2.field_bizChatLocalId;
                    cVar.field_chatName = fB.field_userName;
                    AppMethodBeat.o(124238);
                    return true;
                }
                AppMethodBeat.o(124238);
                return false;
            } catch (JSONException e3) {
                Log.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", e3.getMessage());
                Log.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", e3, "", new Object[0]);
            }
        }
        AppMethodBeat.o(124238);
        return false;
    }

    public static void g(c cVar) {
        AppMethodBeat.i(124239);
        if (cVar == null) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
            AppMethodBeat.o(124239);
            return;
        }
        boolean Ao = ag.bak().Ao(cVar.field_bizChatLocalId);
        boolean iE = cVar.iE(16);
        Log.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", Boolean.valueOf(Ao), Boolean.valueOf(iE), cVar.field_chatName);
        if (!iE || Ao) {
            if (!iE && Ao) {
                ag.bak().Aq(cVar.field_bizChatLocalId);
            }
            AppMethodBeat.o(124239);
            return;
        }
        ag.bak().Ap(cVar.field_bizChatLocalId);
        AppMethodBeat.o(124239);
    }

    public static void h(c cVar) {
        String str;
        int indexOf;
        AppMethodBeat.i(124240);
        if (cVar == null) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
            AppMethodBeat.o(124240);
            return;
        }
        az bjY = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(cVar.field_brandUserName);
        if (bjY == null) {
            Log.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
            AppMethodBeat.o(124240);
            return;
        }
        ca aEx = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(cVar.field_brandUserName);
        ca bX = ((q) g.af(q.class)).aSR().bX(cVar.field_brandUserName, cVar.field_bizChatLocalId);
        if (!(aEx == null || bX == null || aEx.field_msgId != bX.field_msgId || (str = bjY.field_digest) == null || (indexOf = str.indexOf(":")) == -1)) {
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            if (substring != null && !substring.equals(cVar.field_chatName)) {
                bjY.Cm(cVar.field_chatName + ":" + substring2);
                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().a(bjY, bjY.field_username);
            }
        }
        AppMethodBeat.o(124240);
    }

    public static String NN(String str) {
        AppMethodBeat.i(124237);
        if (Util.isNullOrNil(str)) {
            str = "tempUser";
        }
        StringBuilder sb = new StringBuilder(com.tencent.mm.plugin.image.d.aSZ());
        sb.append(com.tencent.mm.b.g.getMessageDigest(str.getBytes())).append(FilePathGenerator.ANDROID_DIR_SEP);
        sb.append("user/");
        String sb2 = sb.toString();
        AppMethodBeat.o(124237);
        return sb2;
    }
}
