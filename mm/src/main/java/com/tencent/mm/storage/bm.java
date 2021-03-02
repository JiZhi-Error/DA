package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class bm extends MAutoStorage<bl> implements d, MStorage.IOnStorageChange {
    private static final String[] NRG = {"CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(bl.info, "fmessage_conversation")};
    private Runnable Oqj = new Runnable() {
        /* class com.tencent.mm.storage.bm.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(117147);
            int gCR = bm.this.gCR();
            Log.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", Integer.valueOf(gCR));
            g.aAh().azQ().set(143618, Integer.valueOf(gCR));
            AppMethodBeat.o(117147);
        }
    };
    public ISQLiteDatabase db;
    private final int dnq = 1;
    protected Context mContext = null;

    static {
        AppMethodBeat.i(117161);
        AppMethodBeat.o(117161);
    }

    public bm(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, bl.info, "fmessage_conversation", NRG);
        AppMethodBeat.i(117148);
        this.db = iSQLiteDatabase;
        this.mContext = MMApplicationContext.getContext();
        AppMethodBeat.o(117148);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final Cursor getAll() {
        AppMethodBeat.i(117149);
        Cursor rawQuery = this.db.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
        AppMethodBeat.o(117149);
        return rawQuery;
    }

    public final List<bl> gCP() {
        AppMethodBeat.i(117150);
        Log.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", 4);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
        while (rawQuery.moveToNext()) {
            bl blVar = new bl();
            blVar.convertFrom(rawQuery);
            if (!Util.isNullOrNil(blVar.field_talker)) {
                arrayList.add(blVar);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(117150);
        return arrayList;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final int getCount() {
        int i2 = 0;
        AppMethodBeat.i(117151);
        Cursor rawQuery = this.db.rawQuery("select count(*) from fmessage_conversation", null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        Log.d("MicroMsg.FMessageConversationStorage", "getCount = ".concat(String.valueOf(i2)));
        AppMethodBeat.o(117151);
        return i2;
    }

    public final boolean gP(String str, int i2) {
        AppMethodBeat.i(117152);
        if (str == null || str.length() == 0) {
            Log.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
            AppMethodBeat.o(117152);
            return false;
        }
        bl aEl = aEl(str);
        if (aEl == null) {
            Log.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = ".concat(String.valueOf(str)));
            AppMethodBeat.o(117152);
            return false;
        } else if (i2 == aEl.field_state) {
            Log.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
            AppMethodBeat.o(117152);
            return true;
        } else {
            aEl.field_state = i2;
            aEl.field_lastModifiedTime = System.currentTimeMillis();
            if (super.update(aEl, new String[0])) {
                doNotify(str);
                AppMethodBeat.o(117152);
                return true;
            }
            AppMethodBeat.o(117152);
            return false;
        }
    }

    public final boolean gCQ() {
        AppMethodBeat.i(117153);
        if (this.db.execSQL("fmessage_conversation", "update fmessage_conversation set isNew = 0")) {
            Log.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
            doNotify();
            AppMethodBeat.o(117153);
            return true;
        }
        Log.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
        AppMethodBeat.o(117153);
        return false;
    }

    public final int gCR() {
        int i2 = 0;
        AppMethodBeat.i(117154);
        Cursor rawQuery = this.db.rawQuery(String.format("select count(*) from %s where %s = 1 and %s < 2", "fmessage_conversation", "isNew", "fmsgIsSend"), null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        Log.d("MicroMsg.FMessageConversationStorage", "getNewCount = ".concat(String.valueOf(i2)));
        AppMethodBeat.o(117154);
        return i2;
    }

    public final boolean bks(String str) {
        AppMethodBeat.i(117155);
        if (str == null || str.length() == 0) {
            Log.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
            AppMethodBeat.o(117155);
            return false;
        }
        bl aEl = aEl(str);
        if (aEl == null || !str.equals(aEl.field_talker)) {
            Log.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = ".concat(String.valueOf(str)));
            AppMethodBeat.o(117155);
            return false;
        }
        aEl.field_isNew = 0;
        boolean update = super.update(aEl, new String[0]);
        AppMethodBeat.o(117155);
        return update;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.d
    public final bl aEl(String str) {
        AppMethodBeat.i(117156);
        if (str == null || str.length() == 0) {
            Log.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
            AppMethodBeat.o(117156);
            return null;
        }
        bl blVar = new bl();
        blVar.field_talker = str;
        if (super.get(blVar, new String[0])) {
            AppMethodBeat.o(117156);
            return blVar;
        }
        Log.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = ".concat(String.valueOf(str)));
        AppMethodBeat.o(117156);
        return null;
    }

    public final bl bkt(String str) {
        bl blVar = null;
        AppMethodBeat.i(117157);
        if (str == null || str.length() == 0) {
            Log.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
            AppMethodBeat.o(117157);
        } else {
            Cursor rawQuery = this.db.rawQuery("select * from fmessage_conversation  where encryptTalker=" + h.Fl(str), null, 2);
            if (rawQuery.moveToFirst()) {
                blVar = new bl();
                blVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(117157);
        }
        return blVar;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        long j2;
        boolean z;
        AppMethodBeat.i(117158);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
            AppMethodBeat.o(117158);
            return;
        }
        try {
            j2 = Util.getLong(str, 0);
        } catch (Exception e2) {
            Log.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + str + ", ex = " + e2.getMessage());
            j2 = 0;
        }
        if (j2 == 0) {
            Log.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
            AppMethodBeat.o(117158);
        } else if (!g.aAf().azp()) {
            Log.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
            AppMethodBeat.o(117158);
        } else {
            bn bnVar = new bn();
            if (!((bo) ((l) g.af(l.class)).eix()).get(j2, bnVar)) {
                Log.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = ".concat(String.valueOf(j2)));
                AppMethodBeat.o(117158);
                return;
            }
            Log.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = ".concat(String.valueOf(j2)));
            bl aEl = ((l) g.af(l.class)).eiw().aEl(bnVar.field_talker);
            if (aEl == null) {
                Log.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + bnVar.field_talker);
                if (Util.isNullOrNil(bnVar.field_talker)) {
                    Log.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
                    AppMethodBeat.o(117158);
                    return;
                }
                bl blVar = new bl();
                if (bnVar.field_type == 0) {
                    ca.a bkA = ca.a.bkA(bnVar.field_msgContent);
                    blVar.field_displayName = bkA.getDisplayName();
                    if (bkA.scene == 4 && bkA.gDZ() != null) {
                        blVar.field_displayName = bkA.gDZ();
                    }
                    blVar.field_addScene = bkA.scene;
                    blVar.field_isNew = 1;
                    blVar.field_contentFromUsername = bkA.dkU;
                    blVar.field_contentNickname = bkA.nickname;
                    blVar.field_contentPhoneNumMD5 = bkA.OqK;
                    blVar.field_contentFullPhoneNumMD5 = bkA.OqL;
                    Log.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + blVar.field_contentFromUsername + "new friend Nickname: " + blVar.field_contentNickname);
                } else if (bnVar.gCT()) {
                    ca.d bkD = ca.d.bkD(bnVar.field_msgContent);
                    blVar.field_displayName = bkD.getDisplayName();
                    blVar.field_addScene = bkD.scene;
                    blVar.field_isNew = 1;
                    blVar.field_contentFromUsername = bkD.dkU;
                    blVar.field_contentNickname = bkD.nickname;
                    blVar.field_contentVerifyContent = bkD.content;
                    Log.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + blVar.field_contentFromUsername + "new friend Nickname: " + blVar.field_contentNickname);
                }
                blVar.field_lastModifiedTime = System.currentTimeMillis();
                blVar.field_state = 0;
                blVar.field_talker = bnVar.field_talker;
                blVar.field_encryptTalker = bnVar.field_encryptTalker;
                blVar.field_fmsgSysRowId = j2;
                blVar.field_fmsgIsSend = bnVar.field_isSend;
                blVar.field_fmsgType = bnVar.field_type;
                blVar.field_fmsgContent = bnVar.field_msgContent;
                blVar.field_recvFmsgType = bnVar.gCT() ? bnVar.field_type : 0;
                Log.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + blVar.field_fmsgContent);
                ((bm) ((l) g.af(l.class)).eiw()).insert(blVar);
            } else {
                Log.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + bnVar.field_talker);
                if (bnVar.gCT()) {
                    aEl.field_isNew = 1;
                }
                aEl.field_lastModifiedTime = System.currentTimeMillis();
                aEl.field_encryptTalker = bnVar.field_encryptTalker;
                aEl.field_fmsgSysRowId = j2;
                aEl.field_fmsgIsSend = bnVar.field_isSend;
                aEl.field_fmsgType = bnVar.field_type;
                aEl.field_fmsgContent = bnVar.field_msgContent;
                if (bnVar.gCT()) {
                    aEl.field_recvFmsgType = bnVar.field_type;
                    Log.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + aEl.field_recvFmsgType);
                }
                if (bnVar.field_type == 0) {
                    ca.a bkA2 = ca.a.bkA(bnVar.field_msgContent);
                    aEl.field_contentFromUsername = bkA2.dkU;
                    aEl.field_contentNickname = bkA2.nickname;
                    aEl.field_contentPhoneNumMD5 = bkA2.OqK;
                    aEl.field_contentFullPhoneNumMD5 = bkA2.OqL;
                    Log.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + aEl.field_contentFromUsername + "new friend Nickname: " + aEl.field_contentNickname);
                } else if (bnVar.gCT()) {
                    if (bnVar.field_isSend >= 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        ca.d bkD2 = ca.d.bkD(bnVar.field_msgContent);
                        aEl.field_contentVerifyContent = bkD2.content;
                        aEl.field_contentFromUsername = bkD2.dkU;
                        aEl.field_contentNickname = bkD2.nickname;
                        Log.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + aEl.field_contentVerifyContent + " receive, new friend Username: " + aEl.field_contentFromUsername + " new friend Nickname: " + aEl.field_contentNickname);
                        String str2 = aEl.field_contentFromUsername;
                        String str3 = aEl.field_contentNickname;
                        nx nxVar = new nx();
                        nxVar.dTZ.userName = str2;
                        nxVar.dTZ.nickName = str3;
                        nxVar.dTZ.type = 1;
                        EventCenter.instance.publish(nxVar);
                    }
                }
                ((bm) ((l) g.af(l.class)).eiw()).update(aEl, new String[0]);
                if (gCR() == 0) {
                    g.aAh().azQ().set(340225, Long.valueOf(System.currentTimeMillis()));
                }
            }
            gCS();
            AppMethodBeat.o(117158);
        }
    }

    public final void gCS() {
        AppMethodBeat.i(117159);
        MMHandlerThread.removeRunnable(this.Oqj);
        MMHandlerThread.postToMainThreadDelayed(this.Oqj, 500);
        AppMethodBeat.o(117159);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.d
    public final boolean x(long j2, String str) {
        String str2;
        AppMethodBeat.i(117160);
        Log.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", Long.valueOf(j2), str);
        if (!Util.isNullOrNil(str)) {
            str2 = "delete from fmessage_conversation where talker = '" + Util.escapeSqlValue(str) + "'";
        } else if (j2 > 0) {
            str2 = "delete from fmessage_conversation where fmsgSysRowId = '" + j2 + "'";
        } else {
            AppMethodBeat.o(117160);
            return false;
        }
        if (this.db.execSQL("fmessage_conversation", str2)) {
            Log.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", Long.valueOf(j2), str);
            doNotify(str);
            AppMethodBeat.o(117160);
            return true;
        }
        AppMethodBeat.o(117160);
        return false;
    }
}
