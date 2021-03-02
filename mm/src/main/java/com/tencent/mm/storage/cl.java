package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gb;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public class cl extends gb {
    protected static Field[] fields = gb.getValidFields(cl.class);
    public static IAutoDBItem.MAutoDBInfo info;

    static {
        AppMethodBeat.i(43301);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[11];
        mAutoDBInfo.columns = new String[12];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "svrid";
        mAutoDBInfo.colsMap.put("svrid", "LONG default '0'  PRIMARY KEY ");
        sb.append(" svrid LONG default '0'  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "svrid";
        mAutoDBInfo.columns[1] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER");
        sb.append(" scene INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "createtime";
        mAutoDBInfo.colsMap.put("createtime", "LONG");
        sb.append(" createtime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "talker";
        mAutoDBInfo.colsMap.put("talker", "TEXT");
        sb.append(" talker TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT");
        sb.append(" content TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "sayhiuser";
        mAutoDBInfo.colsMap.put("sayhiuser", "TEXT");
        sb.append(" sayhiuser TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "sayhicontent";
        mAutoDBInfo.colsMap.put("sayhicontent", "TEXT");
        sb.append(" sayhicontent TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "imgpath";
        mAutoDBInfo.colsMap.put("imgpath", "TEXT");
        sb.append(" imgpath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "isSend";
        mAutoDBInfo.colsMap.put("isSend", "INTEGER");
        sb.append(" isSend INTEGER");
        mAutoDBInfo.columns[11] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(43301);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }
}
