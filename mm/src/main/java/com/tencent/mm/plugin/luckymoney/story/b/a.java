package com.tencent.mm.plugin.luckymoney.story.b;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends ei {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public static void a(a aVar, dlt dlt, String str, int i2) {
        if (dlt != null) {
            aVar.field_title = dlt.title;
            aVar.field_corp_name = dlt.MPn;
            aVar.field_action_app_nickname = dlt.MPp;
            aVar.field_action_app_username = dlt.yUL;
            aVar.field_action_type = dlt.pTI;
            aVar.field_action_url = dlt.yUK;
            aVar.field_description = dlt.description;
            aVar.field_logo_url = dlt.iwv;
            aVar.field_logo_md5 = dlt.iww;
            aVar.field_packet_id = str;
            aVar.field_subtype_id = i2;
        }
    }

    public static dlt a(a aVar) {
        AppMethodBeat.i(163691);
        dlt dlt = new dlt();
        dlt.title = aVar.field_title;
        dlt.description = aVar.field_description;
        dlt.MPn = aVar.field_corp_name;
        dlt.MPp = aVar.field_action_app_nickname;
        dlt.yUL = aVar.field_action_app_username;
        dlt.pTI = aVar.field_action_type;
        dlt.yUK = aVar.field_action_url;
        dlt.iwv = aVar.field_logo_url;
        dlt.iww = aVar.field_logo_md5;
        dlt.iwu = aVar.field_packet_id;
        dlt.VjK = aVar.field_subtype_id;
        AppMethodBeat.o(163691);
        return dlt;
    }

    static {
        AppMethodBeat.i(163692);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[12];
        mAutoDBInfo.columns = new String[13];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT");
        sb.append(" title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "logo_url";
        mAutoDBInfo.colsMap.put("logo_url", "TEXT");
        sb.append(" logo_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "logo_md5";
        mAutoDBInfo.colsMap.put("logo_md5", "TEXT");
        sb.append(" logo_md5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "description";
        mAutoDBInfo.colsMap.put("description", "TEXT");
        sb.append(" description TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "corp_name";
        mAutoDBInfo.colsMap.put("corp_name", "TEXT");
        sb.append(" corp_name TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE;
        mAutoDBInfo.colsMap.put(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, "INTEGER");
        sb.append(" action_type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "action_url";
        mAutoDBInfo.colsMap.put("action_url", "TEXT");
        sb.append(" action_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "action_app_username";
        mAutoDBInfo.colsMap.put("action_app_username", "TEXT");
        sb.append(" action_app_username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "action_app_nickname";
        mAutoDBInfo.colsMap.put("action_app_nickname", "TEXT");
        sb.append(" action_app_nickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "packet_id";
        mAutoDBInfo.colsMap.put("packet_id", "TEXT PRIMARY KEY ");
        sb.append(" packet_id TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "packet_id";
        mAutoDBInfo.columns[10] = "update_time";
        mAutoDBInfo.colsMap.put("update_time", "LONG");
        sb.append(" update_time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "subtype_id";
        mAutoDBInfo.colsMap.put("subtype_id", "INTEGER");
        sb.append(" subtype_id INTEGER");
        mAutoDBInfo.columns[12] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(163692);
    }
}
