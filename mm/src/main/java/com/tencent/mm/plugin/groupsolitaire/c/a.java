package com.tencent.mm.plugin.groupsolitaire.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.dk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.HashMap;

public final class a extends dk {
    protected static IAutoDBItem.MAutoDBInfo info;
    public String header = "";
    public String separator = " ";
    public String xxN = "";
    public String yfB = "";
    public int yfC = 1;
    public boolean yfD = false;
    public HashMap<Integer, b> yfE = new HashMap<>();
    public boolean yfF = false;
    public int yfG = 0;

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(110396);
        a dXV = dXV();
        AppMethodBeat.o(110396);
        return dXV;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public a() {
        AppMethodBeat.i(110393);
        AppMethodBeat.o(110393);
    }

    public final void dXU() {
        if (this.yfC == 0) {
            this.yfC = 1;
            this.header = "";
        }
    }

    public final String toString() {
        AppMethodBeat.i(110394);
        String str = "GroupSolitatire{header='" + this.header + '\'' + ", example='" + this.yfB + '\'' + ", tail='" + this.xxN + '\'' + ", separator='" + this.separator + '\'' + ", hasRealTitle=" + this.yfC + ", content=" + this.yfE + ", includeRepeatedContent=" + this.yfF + ", includeWhiteContentNum=" + this.yfG + ", field_username='" + this.field_username + '\'' + ", field_key='" + this.field_key + '\'' + ", field_content='" + this.field_content + '\'' + ", field_creator='" + this.field_creator + '\'' + ", field_num=" + this.field_num + ", field_firstMsgId=" + this.field_firstMsgId + ", field_msgSvrId=" + this.field_msgSvrId + ", field_active=" + this.field_active + ", field_lastActiveTime=" + this.field_lastActiveTime + ", systemRowid=" + this.systemRowid + '}';
        AppMethodBeat.o(110394);
        return str;
    }

    public final a dXV() {
        Exception e2;
        AppMethodBeat.i(110395);
        a aVar = null;
        try {
            a aVar2 = new a();
            try {
                aVar2.systemRowid = this.systemRowid;
                aVar2.field_username = this.field_username;
                aVar2.field_key = this.field_key;
                aVar2.field_content = this.field_content;
                aVar2.field_creator = this.field_creator;
                aVar2.field_num = this.field_num;
                aVar2.field_firstMsgId = this.field_firstMsgId;
                aVar2.field_msgSvrId = this.field_msgSvrId;
                aVar2.field_active = this.field_active;
                aVar2.field_lastActiveTime = this.field_lastActiveTime;
                aVar2.header = this.header;
                aVar2.yfB = this.yfB;
                aVar2.xxN = this.xxN;
                aVar2.separator = this.separator;
                aVar2.yfC = this.yfC;
                aVar2.yfG = this.yfG;
                aVar2.yfF = this.yfF;
                aVar2.yfE = new HashMap<>();
                for (int i2 = 1; i2 <= this.yfE.size(); i2++) {
                    aVar2.yfE.put(Integer.valueOf(i2), this.yfE.get(Integer.valueOf(i2)).dXW());
                }
                aVar = aVar2;
            } catch (Exception e3) {
                e2 = e3;
                aVar = aVar2;
                Log.i("MicroMsg.groupsolitaire.GroupSolitatire", "clone() Exception:%s %s", e2.getClass(), e2.getMessage());
                AppMethodBeat.o(110395);
                return aVar;
            }
        } catch (Exception e4) {
            e2 = e4;
            Log.i("MicroMsg.groupsolitaire.GroupSolitatire", "clone() Exception:%s %s", e2.getClass(), e2.getMessage());
            AppMethodBeat.o(110395);
            return aVar;
        }
        AppMethodBeat.o(110395);
        return aVar;
    }

    static {
        AppMethodBeat.i(110397);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[9];
        mAutoDBInfo.columns = new String[10];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "key";
        mAutoDBInfo.colsMap.put("key", "TEXT");
        sb.append(" key TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT");
        sb.append(" content TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "creator";
        mAutoDBInfo.colsMap.put("creator", "TEXT");
        sb.append(" creator TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "num";
        mAutoDBInfo.colsMap.put("num", "INTEGER");
        sb.append(" num INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "firstMsgId";
        mAutoDBInfo.colsMap.put("firstMsgId", "LONG");
        sb.append(" firstMsgId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "msgSvrId";
        mAutoDBInfo.colsMap.put("msgSvrId", "LONG");
        sb.append(" msgSvrId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "active";
        mAutoDBInfo.colsMap.put("active", "INTEGER default '-1' ");
        sb.append(" active INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "lastActiveTime";
        mAutoDBInfo.colsMap.put("lastActiveTime", "LONG");
        sb.append(" lastActiveTime LONG");
        mAutoDBInfo.columns[9] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(110397);
    }
}
