package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.List;

public final class d extends MAutoStorage<c> implements MStorageEx.IOnStorageChange {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS todoIdIndex ON GroupTodo ( todoid )", "CREATE INDEX IF NOT EXISTS todoIdRoomNameIndex ON GroupTodo ( todoid,roomname )", "CREATE INDEX IF NOT EXISTS roomNameIndex ON GroupTodo ( roomname )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "GroupTodo")};
    public static final Long gtt = 604800000L;
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(c cVar) {
        AppMethodBeat.i(182145);
        boolean f2 = f(cVar);
        AppMethodBeat.o(182145);
        return f2;
    }

    static {
        AppMethodBeat.i(182146);
        AppMethodBeat.o(182146);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "GroupTodo", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final boolean f(c cVar) {
        AppMethodBeat.i(182139);
        if (cVar == null) {
            AppMethodBeat.o(182139);
            return false;
        }
        boolean insert = super.insert(cVar);
        AppMethodBeat.o(182139);
        return insert;
    }

    public final c ai(String str, String str2) {
        AppMethodBeat.i(182140);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(182140);
            return null;
        }
        Cursor query = this.db.query("GroupTodo", c.info.columns, "roomname=? and todoid=?", new String[]{str, str2}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(182140);
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                c cVar = new c();
                cVar.convertFrom(query);
                arrayList.add(cVar);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            c cVar2 = (c) arrayList.get(0);
            query.close();
            AppMethodBeat.o(182140);
            return cVar2;
        } finally {
            query.close();
            AppMethodBeat.o(182140);
        }
    }

    public final c DB(String str) {
        AppMethodBeat.i(194056);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(194056);
            return null;
        }
        Cursor query = this.db.query("GroupTodo", c.info.columns, "roomname=? and username=? and state!=?", new String[]{str, "roomannouncement@app.origin", "2"}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(194056);
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                c cVar = new c();
                cVar.convertFrom(query);
                arrayList.add(cVar);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            c cVar2 = (c) arrayList.get(0);
            query.close();
            AppMethodBeat.o(194056);
            return cVar2;
        } finally {
            query.close();
            AppMethodBeat.o(194056);
        }
    }

    public final boolean g(c cVar) {
        AppMethodBeat.i(182141);
        if (cVar == null) {
            AppMethodBeat.o(182141);
            return false;
        }
        boolean update = update(cVar.systemRowid, cVar);
        AppMethodBeat.o(182141);
        return update;
    }

    public final boolean h(c cVar) {
        AppMethodBeat.i(182142);
        if (cVar == null) {
            AppMethodBeat.o(182142);
            return true;
        }
        if (cVar.systemRowid == -1) {
            c ai = ai(cVar.field_roomname, cVar.field_todoid);
            if (ai == null) {
                AppMethodBeat.o(182142);
                return true;
            }
            cVar.systemRowid = ai.systemRowid;
        }
        boolean delete = delete(cVar.systemRowid);
        AppMethodBeat.o(182142);
        return delete;
    }

    public final List<c> DC(String str) {
        AppMethodBeat.i(182143);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(182143);
            return arrayList;
        }
        long aWB = (long) cl.aWB();
        Cursor query = this.db.query("GroupTodo", c.info.columns, "roomname=? and createtime>=? AND state IN (0,1)", new String[]{str, new StringBuilder().append(aWB - gtt.longValue()).toString()}, null, null, "updatetime DESC limit 20");
        if (query == null) {
            AppMethodBeat.o(182143);
            return arrayList;
        }
        while (query.moveToNext()) {
            try {
                c cVar = new c();
                cVar.convertFrom(query);
                arrayList.add(cVar);
            } finally {
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(182143);
            }
        }
        return arrayList;
    }

    public final boolean DD(String str) {
        int i2;
        AppMethodBeat.i(194057);
        try {
            i2 = this.db.delete("GroupTodo", "createtime<? and username=?", new String[]{new StringBuilder().append(cl.aWz() - gtt.longValue()).toString(), str});
        } catch (Exception e2) {
            Log.e("MicroMsg.roomTodo.GroupTodoStorage", "deleteExpireData Exception：[%s %s]", e2.getClass().getSimpleName(), e2.getMessage());
            i2 = 0;
        }
        if (i2 > 0) {
            AppMethodBeat.o(194057);
            return true;
        }
        AppMethodBeat.o(194057);
        return false;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(194058);
        if (obj == null || !(obj instanceof String)) {
            Log.d("MicroMsg.roomTodo.GroupTodoStorage", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(194058);
            return;
        }
        final String str = (String) obj;
        if (i2 == 5 && (mStorageEx instanceof bw)) {
            Log.i("MicroMsg.roomTodo.GroupTodoStorage", "delete, username %s", Integer.valueOf(i2), str);
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.chatroom.storage.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(194055);
                    Log.i("MicroMsg.roomTodo.GroupTodoStorage", "onNotifyChange delete expire data : %s", Boolean.valueOf(((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().DD(str)));
                    AppMethodBeat.o(194055);
                }
            });
        }
        AppMethodBeat.o(194058);
    }
}
