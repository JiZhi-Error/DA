package com.tencent.mm.plugin.lite.storage;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class e extends b {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return null;
    }

    public final WxaLiteAppInfo ecG() {
        AppMethodBeat.i(198897);
        WxaLiteAppInfo wxaLiteAppInfo = new WxaLiteAppInfo();
        wxaLiteAppInfo.appId = this.field_appId;
        wxaLiteAppInfo.path = this.field_pkgPath;
        wxaLiteAppInfo.crh = this.field_signatureKey;
        wxaLiteAppInfo.crj = this.field_updateTime;
        wxaLiteAppInfo.cri = this.field_patchId;
        wxaLiteAppInfo.url = this.field_url;
        wxaLiteAppInfo.md5 = this.field_md5;
        wxaLiteAppInfo.crk = this.field_lastUseTime;
        wxaLiteAppInfo.groupId = this.field_groupId;
        wxaLiteAppInfo.type = this.field_pkgType;
        AppMethodBeat.o(198897);
        return wxaLiteAppInfo;
    }

    static {
        AppMethodBeat.i(198898);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[11];
        mAutoDBInfo.columns = new String[12];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT PRIMARY KEY ");
        sb.append(" appId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "appId";
        mAutoDBInfo.columns[1] = "groupId";
        mAutoDBInfo.colsMap.put("groupId", "TEXT");
        sb.append(" groupId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "signatureKey";
        mAutoDBInfo.colsMap.put("signatureKey", "TEXT");
        sb.append(" signatureKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "pkgPath";
        mAutoDBInfo.colsMap.put("pkgPath", "TEXT");
        sb.append(" pkgPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "pkgType";
        mAutoDBInfo.colsMap.put("pkgType", "TEXT");
        sb.append(" pkgType TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "patchId";
        mAutoDBInfo.colsMap.put("patchId", "TEXT");
        sb.append(" patchId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "version";
        mAutoDBInfo.colsMap.put("version", "TEXT");
        sb.append(" version TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "url";
        mAutoDBInfo.colsMap.put("url", "TEXT");
        sb.append(" url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "md5";
        mAutoDBInfo.colsMap.put("md5", "TEXT");
        sb.append(" md5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "lastUseTime";
        mAutoDBInfo.colsMap.put("lastUseTime", "LONG");
        sb.append(" lastUseTime LONG");
        mAutoDBInfo.columns[11] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(198898);
    }
}
