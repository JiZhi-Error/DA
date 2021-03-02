package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.at;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends at {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(120810);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[9];
        mAutoDBInfo.columns = new String[10];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "mediaId";
        mAutoDBInfo.colsMap.put("mediaId", "TEXT");
        sb.append(" mediaId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "downloadUrlHashCode";
        mAutoDBInfo.colsMap.put("downloadUrlHashCode", "INTEGER PRIMARY KEY ");
        sb.append(" downloadUrlHashCode INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "downloadUrlHashCode";
        mAutoDBInfo.columns[2] = "downloadUrl";
        mAutoDBInfo.colsMap.put("downloadUrl", "TEXT");
        sb.append(" downloadUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "httpsUrl";
        mAutoDBInfo.colsMap.put("httpsUrl", "TEXT");
        sb.append(" httpsUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "filePath";
        mAutoDBInfo.colsMap.put("filePath", "TEXT");
        sb.append(" filePath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "verifyHeaders";
        mAutoDBInfo.colsMap.put("verifyHeaders", "TEXT");
        sb.append(" verifyHeaders TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "game_package_download";
        mAutoDBInfo.colsMap.put("game_package_download", "INTEGER");
        sb.append(" game_package_download INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "allowMobileNetDownload";
        mAutoDBInfo.colsMap.put("allowMobileNetDownload", "INTEGER");
        sb.append(" allowMobileNetDownload INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "wifiAutoDownload";
        mAutoDBInfo.colsMap.put("wifiAutoDownload", "INTEGER");
        sb.append(" wifiAutoDownload INTEGER");
        mAutoDBInfo.columns[9] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(120810);
    }
}
