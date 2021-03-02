package com.tencent.mm.plugin.multitalk.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;

public final class c extends MAutoStorage<b> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(b.info, "MultiTalkMember"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkMember  on MultiTalkMember  (  wxGroupId )"};

    static {
        AppMethodBeat.i(114650);
        AppMethodBeat.o(114650);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, b.info, "MultiTalkMember", null);
    }

    public final b iP(String str, String str2) {
        AppMethodBeat.i(114645);
        Cursor rawQuery = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + str + "' and userName ='" + str2 + "'", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.field_memberUuid = (long) rawQuery.getInt(0);
                    bVar.field_wxGroupId = rawQuery.getString(1);
                    bVar.field_userName = rawQuery.getString(2);
                    bVar.field_inviteUserName = rawQuery.getString(3);
                    bVar.field_memberId = rawQuery.getLong(4);
                    bVar.field_status = rawQuery.getInt(5);
                    bVar.field_createTime = rawQuery.getLong(6);
                    Log.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMember get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", Long.valueOf(bVar.field_memberUuid), bVar.field_wxGroupId, bVar.field_userName, bVar.field_inviteUserName, Long.valueOf(bVar.field_memberId), Integer.valueOf(bVar.field_status), Long.valueOf(bVar.field_createTime));
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.o(114645);
                    return bVar;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e2.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(114645);
                throw th;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.o(114645);
        return null;
    }

    public final LinkedList<b> aGq(String str) {
        AppMethodBeat.i(114646);
        Cursor rawQuery = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + str + "'", new String[0]);
        LinkedList<b> linkedList = new LinkedList<>();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                b bVar = new b();
                bVar.field_memberUuid = (long) rawQuery.getInt(0);
                bVar.field_wxGroupId = rawQuery.getString(1);
                bVar.field_userName = rawQuery.getString(2);
                bVar.field_inviteUserName = rawQuery.getString(3);
                bVar.field_memberId = rawQuery.getLong(4);
                bVar.field_status = rawQuery.getInt(5);
                bVar.field_createTime = rawQuery.getLong(6);
                Log.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMemberList get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", Long.valueOf(bVar.field_memberUuid), bVar.field_wxGroupId, bVar.field_userName, bVar.field_inviteUserName, Long.valueOf(bVar.field_memberId), Integer.valueOf(bVar.field_status), Long.valueOf(bVar.field_createTime));
                linkedList.add(bVar);
            } catch (Exception e2) {
                Log.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e2.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(114646);
                throw th;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.o(114646);
        return linkedList;
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(114647);
        long j2 = bVar.field_memberUuid;
        Cursor rawQuery = rawQuery("select * from MultiTalkMember where memberUuid = '" + j2 + "' and wxGroupId = '" + bVar.field_wxGroupId + "'", new String[0]);
        try {
            if (rawQuery.getCount() == 0) {
                boolean insert = insert(bVar);
                Log.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "insert ret " + insert + " for memberUuid = " + j2);
                return insert;
            }
            boolean update = update(bVar, new String[0]);
            Log.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "update ret " + update + " for memberUuid = " + j2);
            rawQuery.close();
            AppMethodBeat.o(114647);
            return update;
        } catch (Exception e2) {
            Log.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e2.toString());
            return false;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(114647);
        }
    }

    public final boolean b(b bVar) {
        AppMethodBeat.i(239432);
        String str = bVar.field_userName;
        Cursor rawQuery = rawQuery("select * from MultiTalkMember where userName = '" + str + "' and wxGroupId = '" + bVar.field_wxGroupId + "'", new String[0]);
        try {
            if (rawQuery.getCount() == 0) {
                boolean insert = insert(bVar);
                Log.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "insert ret " + insert + " for userName = " + str);
                return insert;
            }
            boolean update = update(bVar, new String[0]);
            Log.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "update ret " + update + " for userName = " + str);
            rawQuery.close();
            AppMethodBeat.o(239432);
            return update;
        } catch (Exception e2) {
            Log.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e2.toString());
            return false;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(239432);
        }
    }

    public final boolean fr(String str, String str2) {
        AppMethodBeat.i(114648);
        Log.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = " + str + ",member = " + str2);
        try {
            super.execSQL("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + str + "\" and userName = \"" + str2 + "\"");
            AppMethodBeat.o(114648);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = " + str + ",member = " + str2);
            AppMethodBeat.o(114648);
            return false;
        }
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(114649);
        Log.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = ".concat(String.valueOf(str)));
        try {
            super.execSQL("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + str + "\"");
            AppMethodBeat.o(114649);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(114649);
            return false;
        }
    }
}
