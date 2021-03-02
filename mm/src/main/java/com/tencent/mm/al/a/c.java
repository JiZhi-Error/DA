package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.l;
import com.tencent.mm.g.c.ah;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c extends ah {
    protected static IAutoDBItem.MAutoDBInfo info;
    private Map<String, k> iPG = new HashMap();
    private List<String> iPH;

    public c() {
        AppMethodBeat.i(116434);
        AppMethodBeat.o(116434);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean iE(int i2) {
        return (this.field_bitFlag & i2) != 0;
    }

    public final List<String> bax() {
        AppMethodBeat.i(116435);
        if (this.iPH != null) {
            List<String> list = this.iPH;
            AppMethodBeat.o(116435);
            return list;
        }
        String str = this.field_userList;
        if (Util.isNullOrNil(str)) {
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(116435);
            return linkedList;
        }
        this.iPH = Util.stringsToList(str.split(";"));
        List<String> list2 = this.iPH;
        AppMethodBeat.o(116435);
        return list2;
    }

    public final String getDisplayName(String str) {
        AppMethodBeat.i(116436);
        k NC = NC(str);
        if (NC == null) {
            AppMethodBeat.o(116436);
            return "";
        }
        String nullAs = Util.nullAs(NC.field_userName, "");
        AppMethodBeat.o(116436);
        return nullAs;
    }

    public final k NC(String str) {
        AppMethodBeat.i(116437);
        if (!this.iPG.containsKey(str) || this.iPG.get(str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ND(str);
            Log.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        if (this.iPG.containsKey(str)) {
            k kVar = this.iPG.get(str);
            AppMethodBeat.o(116437);
            return kVar;
        }
        AppMethodBeat.o(116437);
        return null;
    }

    private void ND(String str) {
        AppMethodBeat.i(116438);
        k fB = ((l) g.af(l.class)).fB(str);
        if (fB != null) {
            this.iPG.put(fB.field_userId, fB);
        }
        AppMethodBeat.o(116438);
    }

    public final boolean isGroup() {
        AppMethodBeat.i(116439);
        if (this.field_bizChatServId == null) {
            AppMethodBeat.o(116439);
            return false;
        }
        boolean endsWith = this.field_bizChatServId.endsWith("@qy_g");
        AppMethodBeat.o(116439);
        return endsWith;
    }

    public final boolean bay() {
        AppMethodBeat.i(116440);
        if (this.field_needToUpdate) {
            AppMethodBeat.o(116440);
            return true;
        } else if (isGroup() && Util.isNullOrNil(this.field_userList)) {
            AppMethodBeat.o(116440);
            return true;
        } else if (!Util.isNullOrNil(this.field_chatNamePY) || Util.isNullOrNil(this.field_chatName)) {
            AppMethodBeat.o(116440);
            return false;
        } else {
            AppMethodBeat.o(116440);
            return true;
        }
    }

    static {
        AppMethodBeat.i(116441);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[15];
        mAutoDBInfo.columns = new String[16];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "bizChatLocalId";
        mAutoDBInfo.colsMap.put("bizChatLocalId", "LONG PRIMARY KEY ");
        sb.append(" bizChatLocalId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "bizChatLocalId";
        mAutoDBInfo.columns[1] = "bizChatServId";
        mAutoDBInfo.colsMap.put("bizChatServId", "TEXT");
        sb.append(" bizChatServId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "brandUserName";
        mAutoDBInfo.colsMap.put("brandUserName", "TEXT default '' ");
        sb.append(" brandUserName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "chatType";
        mAutoDBInfo.colsMap.put("chatType", "INTEGER");
        sb.append(" chatType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "headImageUrl";
        mAutoDBInfo.colsMap.put("headImageUrl", "TEXT");
        sb.append(" headImageUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "chatName";
        mAutoDBInfo.colsMap.put("chatName", "TEXT default '' ");
        sb.append(" chatName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "chatNamePY";
        mAutoDBInfo.colsMap.put("chatNamePY", "TEXT default '' ");
        sb.append(" chatNamePY TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "chatVersion";
        mAutoDBInfo.colsMap.put("chatVersion", "INTEGER default '-1' ");
        sb.append(" chatVersion INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "needToUpdate";
        mAutoDBInfo.colsMap.put("needToUpdate", "INTEGER default 'true' ");
        sb.append(" needToUpdate INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "bitFlag";
        mAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
        sb.append(" bitFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "maxMemberCnt";
        mAutoDBInfo.colsMap.put("maxMemberCnt", "INTEGER default '0' ");
        sb.append(" maxMemberCnt INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "ownerUserId";
        mAutoDBInfo.colsMap.put("ownerUserId", "TEXT");
        sb.append(" ownerUserId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "userList";
        mAutoDBInfo.colsMap.put("userList", "TEXT");
        sb.append(" userList TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "addMemberUrl";
        mAutoDBInfo.colsMap.put("addMemberUrl", "TEXT");
        sb.append(" addMemberUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "roomflag";
        mAutoDBInfo.colsMap.put("roomflag", "INTEGER default '0' ");
        sb.append(" roomflag INTEGER default '0' ");
        mAutoDBInfo.columns[15] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(116441);
    }
}
