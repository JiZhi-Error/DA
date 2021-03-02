package com.tencent.mm.plugin.fts.a.a;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cb;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class d extends cb {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public d() {
        this.field_featureId = 0;
        this.field_title = "";
        this.field_titlePY = "";
        this.field_titleShortPY = "";
        this.field_tag = "";
        this.field_actionType = 0;
        this.field_url = "";
        this.field_helpUrl = "";
        this.field_updateUrl = "";
        this.field_androidUrl = "";
        this.field_iconPath = "";
    }

    public final String toString() {
        AppMethodBeat.i(131672);
        String str = "Feature [field_featureId=" + this.field_featureId + ", field_title=" + this.field_title + ", field_titlePY=" + this.field_titlePY + ", field_titleShortPY=" + this.field_titleShortPY + ", field_tag=" + this.field_tag + ", field_actionType=" + this.field_actionType + ", field_url=" + this.field_url + ", field_helpUrl=" + this.field_helpUrl + ", field_updateUrl=" + this.field_updateUrl + ", field_androidUrl=" + this.field_androidUrl + ", field_iconPath=" + this.field_iconPath + "]";
        AppMethodBeat.o(131672);
        return str;
    }

    static {
        AppMethodBeat.i(131673);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[12];
        mAutoDBInfo.columns = new String[13];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "featureId";
        mAutoDBInfo.colsMap.put("featureId", "INTEGER PRIMARY KEY ");
        sb.append(" featureId INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "featureId";
        mAutoDBInfo.columns[1] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT");
        sb.append(" title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "titlePY";
        mAutoDBInfo.colsMap.put("titlePY", "TEXT");
        sb.append(" titlePY TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "titleShortPY";
        mAutoDBInfo.colsMap.put("titleShortPY", "TEXT");
        sb.append(" titleShortPY TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "tag";
        mAutoDBInfo.colsMap.put("tag", "TEXT");
        sb.append(" tag TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "actionType";
        mAutoDBInfo.colsMap.put("actionType", "INTEGER default '0' ");
        sb.append(" actionType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "url";
        mAutoDBInfo.colsMap.put("url", "TEXT");
        sb.append(" url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "helpUrl";
        mAutoDBInfo.colsMap.put("helpUrl", "TEXT");
        sb.append(" helpUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "updateUrl";
        mAutoDBInfo.colsMap.put("updateUrl", "TEXT");
        sb.append(" updateUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "androidUrl";
        mAutoDBInfo.colsMap.put("androidUrl", "TEXT");
        sb.append(" androidUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "iconPath";
        mAutoDBInfo.colsMap.put("iconPath", "TEXT");
        sb.append(" iconPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = AppMeasurement.Param.TIMESTAMP;
        mAutoDBInfo.colsMap.put(AppMeasurement.Param.TIMESTAMP, "LONG default '0' ");
        sb.append(" timestamp LONG default '0' ");
        mAutoDBInfo.columns[12] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(131673);
    }
}
