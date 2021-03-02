package com.tencent.mm.plugin.multitalk.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class a extends MAutoStorage<f> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(f.info, "MultiTalkInfo"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkInfo_key  on MultiTalkInfo  (  wxGroupId )"};
    public static LinkedHashMap<String, Class> wQE = new LinkedHashMap<String, Class>() {
        /* class com.tencent.mm.plugin.multitalk.c.a.AnonymousClass1 */

        {
            AppMethodBeat.i(114637);
            put("wxGroupId", String.class);
            put("groupId", String.class);
            put("roomId", Integer.TYPE);
            put("roomKey", Long.TYPE);
            put("routeId", Integer.TYPE);
            put("createTime", Long.TYPE);
            put("ilinkRoomId", Long.TYPE);
            AppMethodBeat.o(114637);
        }
    };

    static {
        AppMethodBeat.i(114643);
        AppMethodBeat.o(114643);
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, f.info, "MultiTalkInfo", null);
    }

    public final LinkedList<f> eot() {
        AppMethodBeat.i(114638);
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, createTime, ilinkRoomId from MultiTalkInfo", new String[0]);
        LinkedList<f> linkedList = new LinkedList<>();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                f fVar = new f();
                fVar.field_wxGroupId = rawQuery.getString(0);
                fVar.field_groupId = rawQuery.getString(1);
                fVar.field_roomId = rawQuery.getInt(2);
                fVar.field_roomKey = rawQuery.getLong(3);
                fVar.field_routeId = rawQuery.getInt(4);
                fVar.field_createTime = rawQuery.getLong(5);
                fVar.field_ilinkRoomId = rawQuery.getLong(6);
                Log.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d, createTime=%d, ilinkroomid = %d", fVar.field_wxGroupId, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), Long.valueOf(fVar.field_createTime), Long.valueOf(fVar.field_ilinkRoomId));
                linkedList.add(fVar);
            } catch (Exception e2) {
                Log.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList error!");
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(114638);
                throw th;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.o(114638);
        return linkedList;
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(114639);
        String str = fVar.field_wxGroupId;
        if (com.tencent.pb.common.c.f.eP(str)) {
            Log.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. multiTalkInfo wxGroupId is empty!");
            AppMethodBeat.o(114639);
            return false;
        }
        Log.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d, ilinkroomid=%d", str, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), fVar.field_inviteUserName, Integer.valueOf(fVar.field_memberCount), Long.valueOf(fVar.field_createTime), Long.valueOf(fVar.field_ilinkRoomId));
        try {
            boolean insert = insert(fVar);
            Log.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "insert ret " + insert + " for id=%s" + str);
            AppMethodBeat.o(114639);
            return insert;
        } catch (Exception e2) {
            Log.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e2.toString());
            AppMethodBeat.o(114639);
            return false;
        }
    }

    public final boolean b(f fVar) {
        AppMethodBeat.i(114640);
        String str = fVar.field_wxGroupId;
        if (com.tencent.pb.common.c.f.eP(str)) {
            Log.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. multiTalkInfo wxGroupId is empty!");
            AppMethodBeat.o(114640);
            return false;
        }
        Log.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d,state=%d,ilinkroomid=%d", str, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), fVar.field_inviteUserName, Integer.valueOf(fVar.field_memberCount), Long.valueOf(fVar.field_createTime), Integer.valueOf(fVar.field_state), Long.valueOf(fVar.field_ilinkRoomId));
        try {
            boolean update = update(fVar, "wxGroupId");
            Log.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update ret " + update + " for id=%s" + str);
            AppMethodBeat.o(114640);
            return update;
        } catch (Exception e2) {
            Log.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e2.toString());
            AppMethodBeat.o(114640);
            return false;
        }
    }

    public final f aFI(String str) {
        AppMethodBeat.i(114641);
        Log.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTaklInfo for wxGroupId = %s", str);
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, inviteUserName,memberCount,createTime,state,ilinkRoomId from MultiTalkInfo where wxGroupId = '" + str + "'", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    f fVar = new f();
                    fVar.field_wxGroupId = rawQuery.getString(0);
                    fVar.field_groupId = rawQuery.getString(1);
                    fVar.field_roomId = rawQuery.getInt(2);
                    fVar.field_roomKey = rawQuery.getLong(3);
                    fVar.field_routeId = rawQuery.getInt(4);
                    fVar.field_inviteUserName = rawQuery.getString(5);
                    fVar.field_memberCount = rawQuery.getInt(6);
                    fVar.field_createTime = rawQuery.getLong(7);
                    fVar.field_state = rawQuery.getInt(8);
                    fVar.field_ilinkRoomId = rawQuery.getLong(9);
                    Log.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d,inviteUser=%s,memberCount=%d, createTime=%d,field_state=%d, ilinkroomid=%d", fVar.field_wxGroupId, fVar.field_groupId, Integer.valueOf(fVar.field_roomId), Long.valueOf(fVar.field_roomKey), Integer.valueOf(fVar.field_routeId), fVar.field_inviteUserName, Integer.valueOf(fVar.field_memberCount), Long.valueOf(fVar.field_createTime), Integer.valueOf(fVar.field_state), Long.valueOf(fVar.field_ilinkRoomId));
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.o(114641);
                    return fVar;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo error! " + e2.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(114641);
                return null;
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(114641);
                throw th;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.o(114641);
        return null;
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(114642);
        Log.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete id = %s", str);
        try {
            super.execSQL("MultiTalkInfo", "delete from MultiTalkInfo where wxGroupId = \"" + str + "\"");
            AppMethodBeat.o(114642);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete fail for wxGroupId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(114642);
            return false;
        }
    }
}
