package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class c extends du {
    public static IAutoDBItem.MAutoDBInfo info;
    public ArrayList<String> ysE;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public static boolean ik(String str, String str2) {
        AppMethodBeat.i(25536);
        if (str == null && str2 != null) {
            AppMethodBeat.o(25536);
            return false;
        } else if (str == null || str.equals(str2)) {
            AppMethodBeat.o(25536);
            return true;
        } else {
            AppMethodBeat.o(25536);
            return false;
        }
    }

    static {
        AppMethodBeat.i(25537);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "wechatUsername";
        mAutoDBInfo.colsMap.put("wechatUsername", "TEXT");
        sb.append(" wechatUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "systemAddressBookUsername";
        mAutoDBInfo.colsMap.put("systemAddressBookUsername", "TEXT");
        sb.append(" systemAddressBookUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "contactId";
        mAutoDBInfo.colsMap.put("contactId", "TEXT");
        sb.append(" contactId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "sortKey";
        mAutoDBInfo.colsMap.put("sortKey", "TEXT");
        sb.append(" sortKey TEXT");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(25537);
    }
}
