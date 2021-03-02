package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class ai extends MAutoStorage<ah> implements ap, g.a {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ah.info, "chatroom")};
    private ConcurrentHashMap<String, ah> NRF = new ConcurrentHashMap<>();
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(ah ahVar) {
        AppMethodBeat.i(116940);
        ah ahVar2 = ahVar;
        if (a(ahVar2, true)) {
            doNotify(ahVar2.field_chatroomname);
            AppMethodBeat.o(116940);
            return true;
        }
        Log.w("MicroMsg.ChatroomStorage", "replace error");
        AppMethodBeat.o(116940);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage
    public final /* synthetic */ boolean replace(ah ahVar, boolean z) {
        AppMethodBeat.i(187483);
        boolean a2 = a(ahVar, z);
        AppMethodBeat.o(187483);
        return a2;
    }

    static {
        AppMethodBeat.i(116941);
        AppMethodBeat.o(116941);
    }

    public ai(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ah.info, "chatroom", INDEX_CREATE);
        AppMethodBeat.i(187481);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(187481);
    }

    @Override // com.tencent.mm.model.ap
    public final ah Kd(String str) {
        AppMethodBeat.i(116930);
        ah ahVar = new ah();
        ahVar.field_chatroomname = str;
        if (super.get(ahVar, "chatroomname")) {
            AppMethodBeat.o(116930);
            return ahVar;
        }
        AppMethodBeat.o(116930);
        return null;
    }

    @Override // com.tencent.mm.model.ap
    public final ah Ke(String str) {
        AppMethodBeat.i(116931);
        ah ahVar = new ah();
        ahVar.field_chatroomname = str;
        if (super.get(ahVar, "chatroomname")) {
            AppMethodBeat.o(116931);
        } else {
            AppMethodBeat.o(116931);
        }
        return ahVar;
    }

    private boolean a(ah ahVar, boolean z) {
        boolean update;
        ah ahVar2 = null;
        AppMethodBeat.i(187482);
        if (ahVar == null) {
            Log.w("MicroMsg.ChatroomStorage", "replace error(item == null)");
            AppMethodBeat.o(187482);
            return false;
        } else if (Util.isNullOrNil(ahVar.field_chatroomname)) {
            Log.w("MicroMsg.ChatroomStorage", "replace error,item.field_chatroomname is null");
            AppMethodBeat.o(187482);
            return false;
        } else {
            String str = "select rowid,chatroomname from chatroom where chatroomname='" + Util.escapeSqlValue(ahVar.field_chatroomname) + "'";
            Log.d("MicroMsg.ChatroomStorage", "replace : ".concat(String.valueOf(str)));
            Cursor rawQuery = this.db.rawQuery(str, null, 2);
            if (rawQuery.moveToFirst()) {
                ahVar2 = new ah();
                ahVar2.convertFrom(rawQuery);
            }
            rawQuery.close();
            if (ahVar2 == null) {
                update = insertNotify(ahVar, z);
            } else {
                ahVar.systemRowid = ahVar2.systemRowid;
                update = update(ahVar.systemRowid, ahVar, z);
            }
            AppMethodBeat.o(187482);
            return update;
        }
    }

    @Override // com.tencent.mm.model.ap
    public final void z(String str, long j2) {
        AppMethodBeat.i(116932);
        this.db.execSQL("chatroom", "update chatroom set modifytime = " + j2 + " where chatroomname = '" + Util.escapeSqlValue(str) + "'");
        AppMethodBeat.o(116932);
    }

    @Override // com.tencent.mm.model.ap
    public final String Kf(String str) {
        ah ahVar;
        AppMethodBeat.i(116933);
        Assert.assertTrue(str.length() > 0);
        Cursor rawQuery = this.db.rawQuery("select roomowner from chatroom where chatroomname='" + Util.escapeSqlValue(str) + "'", null, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
            AppMethodBeat.o(116933);
            return null;
        }
        if (rawQuery.moveToFirst()) {
            ahVar = new ah();
            ahVar.convertFrom(rawQuery);
        } else {
            ahVar = null;
        }
        rawQuery.close();
        if (ahVar == null) {
            AppMethodBeat.o(116933);
            return null;
        }
        String str2 = ahVar.field_roomowner;
        AppMethodBeat.o(116933);
        return str2;
    }

    @Override // com.tencent.mm.model.ap
    public final String Kg(String str) {
        ah ahVar;
        AppMethodBeat.i(116934);
        Assert.assertTrue(str.length() > 0);
        Cursor rawQuery = this.db.rawQuery("select memberlist from chatroom where chatroomname='" + Util.escapeSqlValue(str) + "'", null, 2);
        if (rawQuery.moveToFirst()) {
            ahVar = new ah();
            ahVar.convertFrom(rawQuery);
        } else {
            ahVar = null;
        }
        rawQuery.close();
        if (ahVar == null) {
            AppMethodBeat.o(116934);
            return null;
        }
        String str2 = ahVar.field_memberlist;
        AppMethodBeat.o(116934);
        return str2;
    }

    @Override // com.tencent.mm.model.ap
    public final int Kk(String str) {
        ah ahVar = null;
        AppMethodBeat.i(116935);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(116935);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Cursor rawQuery = this.db.rawQuery("select memberCount from chatroom where chatroomname='" + Util.escapeSqlValue(str) + "'", null, 2);
            if (rawQuery.moveToFirst()) {
                ahVar = new ah();
                ahVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            if (ahVar == null) {
                Log.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(116935);
                return 0;
            }
            if (ahVar.field_memberCount < 0) {
                int length = Kg(str).split(";").length;
                ahVar.field_memberCount = length;
                this.db.execSQL("chatroom", "update chatroom set memberCount = " + length + " where chatroomname = '" + Util.escapeSqlValue(str) + "'");
                Log.i("MicroMsg.ChatroomStorage", "[getMemberCount] init field_memberCount! username:%s count:%s", str, Integer.valueOf(length));
            }
            int i2 = ahVar.field_memberCount;
            Log.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(116935);
            return i2;
        } catch (Throwable th) {
            Log.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(116935);
            throw th;
        }
    }

    @Override // com.tencent.mm.model.ap
    public final String getDisplayName(String str) {
        ah ahVar;
        AppMethodBeat.i(116936);
        Assert.assertTrue(str.length() > 0);
        Cursor rawQuery = this.db.rawQuery("select displayname from chatroom where chatroomname='" + Util.escapeSqlValue(str) + "'", null, 2);
        if (rawQuery.moveToFirst()) {
            ahVar = new ah();
            ahVar.convertFrom(rawQuery);
        } else {
            ahVar = null;
        }
        rawQuery.close();
        if (ahVar == null) {
            AppMethodBeat.o(116936);
            return null;
        }
        String str2 = ahVar.field_displayname;
        AppMethodBeat.o(116936);
        return str2;
    }

    @Override // com.tencent.mm.model.ap
    public final List<String> Kh(String str) {
        AppMethodBeat.i(116937);
        String Kg = Kg(str);
        if (Kg == null) {
            AppMethodBeat.o(116937);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (!Kg.equals("")) {
            String[] split = Kg.split(";");
            for (String str2 : split) {
                linkedList.add(str2);
            }
        }
        AppMethodBeat.o(116937);
        return linkedList;
    }

    @Override // com.tencent.mm.model.ap
    public final boolean Ki(String str) {
        ah ahVar = null;
        AppMethodBeat.i(116938);
        Cursor rawQuery = this.db.rawQuery("select * from chatroom where chatroomname='" + Util.escapeSqlValue(str) + "'", null, 2);
        if (rawQuery.moveToFirst()) {
            ahVar = new ah();
            ahVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        if (ahVar == null || (ahVar.field_roomflag & 1) != 0) {
            AppMethodBeat.o(116938);
            return false;
        }
        AppMethodBeat.o(116938);
        return true;
    }

    @Override // com.tencent.mm.model.ap
    public final boolean Kj(String str) {
        AppMethodBeat.i(116939);
        Assert.assertTrue(str.length() > 0);
        if (this.db.delete("chatroom", "chatroomname=?", new String[]{str}) == 0) {
            AppMethodBeat.o(116939);
            return false;
        }
        doNotify(str);
        AppMethodBeat.o(116939);
        return true;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        return 0;
    }
}
