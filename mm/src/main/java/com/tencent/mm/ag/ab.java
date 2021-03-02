package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public class ab extends eo {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(42763);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[24];
        mAutoDBInfo.columns = new String[25];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
        sb.append(" msgId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "msgId";
        mAutoDBInfo.columns[1] = "msgSvrId";
        mAutoDBInfo.colsMap.put("msgSvrId", "LONG");
        sb.append(" msgSvrId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "isSend";
        mAutoDBInfo.colsMap.put("isSend", "INTEGER");
        sb.append(" isSend INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "isShowTimer";
        mAutoDBInfo.colsMap.put("isShowTimer", "INTEGER");
        sb.append(" isShowTimer INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "talker";
        mAutoDBInfo.colsMap.put("talker", "TEXT");
        sb.append(" talker TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT default '' ");
        sb.append(" content TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "imgPath";
        mAutoDBInfo.colsMap.put("imgPath", "TEXT");
        sb.append(" imgPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "reserved";
        mAutoDBInfo.colsMap.put("reserved", "TEXT");
        sb.append(" reserved TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "lvbuffer";
        mAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
        sb.append(" lvbuffer BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "talkerId";
        mAutoDBInfo.colsMap.put("talkerId", "INTEGER");
        sb.append(" talkerId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "transContent";
        mAutoDBInfo.colsMap.put("transContent", "TEXT default '' ");
        sb.append(" transContent TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "transBrandWording";
        mAutoDBInfo.colsMap.put("transBrandWording", "TEXT default '' ");
        sb.append(" transBrandWording TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "bizClientMsgId";
        mAutoDBInfo.colsMap.put("bizClientMsgId", "TEXT default '' ");
        sb.append(" bizClientMsgId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "bizChatId";
        mAutoDBInfo.colsMap.put("bizChatId", "LONG default '-1' ");
        sb.append(" bizChatId LONG default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "bizChatUserId";
        mAutoDBInfo.colsMap.put("bizChatUserId", "TEXT default '' ");
        sb.append(" bizChatUserId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "msgSeq";
        mAutoDBInfo.colsMap.put("msgSeq", "LONG");
        sb.append(" msgSeq LONG");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "flag";
        mAutoDBInfo.colsMap.put("flag", "INTEGER default '0' ");
        sb.append(" flag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "solitaireFoldInfo";
        mAutoDBInfo.colsMap.put("solitaireFoldInfo", "BLOB");
        sb.append(" solitaireFoldInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "fromUsername";
        mAutoDBInfo.colsMap.put("fromUsername", "TEXT");
        sb.append(" fromUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "toUsername";
        mAutoDBInfo.colsMap.put("toUsername", "TEXT");
        sb.append(" toUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "historyId";
        mAutoDBInfo.colsMap.put("historyId", "TEXT");
        sb.append(" historyId TEXT");
        mAutoDBInfo.columns[24] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(42763);
    }
}