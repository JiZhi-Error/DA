package com.tencent.mm.plugin.freewifi.g;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cs;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.lang.reflect.Field;

public final class c extends cs {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(24949);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[14];
        mAutoDBInfo.columns = new String[15];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "ssidmd5";
        mAutoDBInfo.colsMap.put("ssidmd5", "TEXT PRIMARY KEY ");
        sb.append(" ssidmd5 TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "ssidmd5";
        mAutoDBInfo.columns[1] = TPDownloadProxyEnum.USER_SSID;
        mAutoDBInfo.colsMap.put(TPDownloadProxyEnum.USER_SSID, "TEXT");
        sb.append(" ssid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "mid";
        mAutoDBInfo.colsMap.put("mid", "TEXT");
        sb.append(" mid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "url";
        mAutoDBInfo.colsMap.put("url", "TEXT");
        sb.append(" url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "connectState";
        mAutoDBInfo.colsMap.put("connectState", "INTEGER default '-1' ");
        sb.append(" connectState INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "expiredTime";
        mAutoDBInfo.colsMap.put("expiredTime", "LONG");
        sb.append(" expiredTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "wifiType";
        mAutoDBInfo.colsMap.put("wifiType", "INTEGER default '1' ");
        sb.append(" wifiType INTEGER default '1' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = NativeProtocol.WEB_DIALOG_ACTION;
        mAutoDBInfo.colsMap.put(NativeProtocol.WEB_DIALOG_ACTION, "INTEGER default '0' ");
        sb.append(" action INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "showUrl";
        mAutoDBInfo.colsMap.put("showUrl", "TEXT");
        sb.append(" showUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "showWordEn";
        mAutoDBInfo.colsMap.put("showWordEn", "TEXT");
        sb.append(" showWordEn TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "showWordCn";
        mAutoDBInfo.colsMap.put("showWordCn", "TEXT");
        sb.append(" showWordCn TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "showWordTw";
        mAutoDBInfo.colsMap.put("showWordTw", "TEXT");
        sb.append(" showWordTw TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = TPDownloadProxyEnum.USER_MAC;
        mAutoDBInfo.colsMap.put(TPDownloadProxyEnum.USER_MAC, "TEXT");
        sb.append(" mac TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "verifyResult";
        mAutoDBInfo.colsMap.put("verifyResult", "INTEGER default '1' ");
        sb.append(" verifyResult INTEGER default '1' ");
        mAutoDBInfo.columns[14] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(24949);
    }
}
