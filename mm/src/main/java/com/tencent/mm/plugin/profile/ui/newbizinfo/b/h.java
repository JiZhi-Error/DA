package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.fo;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class h extends fo {
    public static IAutoDBItem.MAutoDBInfo iBg;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(27585);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[17];
        mAutoDBInfo.columns = new String[18];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT PRIMARY KEY ");
        sb.append(" username TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_USERNAME;
        mAutoDBInfo.columns[1] = "originalArticleCount";
        mAutoDBInfo.colsMap.put("originalArticleCount", "INTEGER default '1' ");
        sb.append(" originalArticleCount INTEGER default '1' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "friendSubscribeCount";
        mAutoDBInfo.colsMap.put("friendSubscribeCount", "INTEGER default '1' ");
        sb.append(" friendSubscribeCount INTEGER default '1' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "allArticleWording";
        mAutoDBInfo.colsMap.put("allArticleWording", "TEXT");
        sb.append(" allArticleWording TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "historyArticlesUrl";
        mAutoDBInfo.colsMap.put("historyArticlesUrl", "TEXT");
        sb.append(" historyArticlesUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "userRole";
        mAutoDBInfo.colsMap.put("userRole", "INTEGER default '1' ");
        sb.append(" userRole INTEGER default '1' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "banReason";
        mAutoDBInfo.colsMap.put("banReason", "TEXT");
        sb.append(" banReason TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "showRecommendArticle";
        mAutoDBInfo.colsMap.put("showRecommendArticle", "INTEGER default '0' ");
        sb.append(" showRecommendArticle INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "showService";
        mAutoDBInfo.colsMap.put("showService", "INTEGER default '0' ");
        sb.append(" showService INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "messageListStr";
        mAutoDBInfo.colsMap.put("messageListStr", "TEXT");
        sb.append(" messageListStr TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "serviceInfoListStr";
        mAutoDBInfo.colsMap.put("serviceInfoListStr", "TEXT");
        sb.append(" serviceInfoListStr TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "bizAccountListStr";
        mAutoDBInfo.colsMap.put("bizAccountListStr", "TEXT");
        sb.append(" bizAccountListStr TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "cacheTime";
        mAutoDBInfo.colsMap.put("cacheTime", "LONG default '0' ");
        sb.append(" cacheTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "decryptUserName";
        mAutoDBInfo.colsMap.put("decryptUserName", "TEXT default '' ");
        sb.append(" decryptUserName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "hiddenAvatar";
        mAutoDBInfo.colsMap.put("hiddenAvatar", "INTEGER default '0' ");
        sb.append(" hiddenAvatar INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "hiddenButtonBeforeFocus";
        mAutoDBInfo.colsMap.put("hiddenButtonBeforeFocus", "INTEGER default '0' ");
        sb.append(" hiddenButtonBeforeFocus INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "newBanReason";
        mAutoDBInfo.colsMap.put("newBanReason", "TEXT");
        sb.append(" newBanReason TEXT");
        mAutoDBInfo.columns[17] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        AppMethodBeat.o(27585);
    }
}
