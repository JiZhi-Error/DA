package com.tencent.mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.lang.reflect.Field;

public class g extends y {
    public static String JVR = "wxce6f23b478a3a2a2";
    public static String JVS = "wx7302cee7c7d6d7d6";
    public static String JVT = "wx6fa7e3bab7e15415";
    public static String JVU = "wx3cc22b542de028d4";
    protected static IAutoDBItem.MAutoDBInfo info;

    static {
        AppMethodBeat.i(151678);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[26];
        mAutoDBInfo.columns = new String[27];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT default ''  PRIMARY KEY ");
        sb.append(" appId TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "appId";
        mAutoDBInfo.columns[1] = "appName";
        mAutoDBInfo.colsMap.put("appName", "TEXT");
        sb.append(" appName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "appDiscription";
        mAutoDBInfo.colsMap.put("appDiscription", "TEXT");
        sb.append(" appDiscription TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "appIconUrl";
        mAutoDBInfo.colsMap.put("appIconUrl", "TEXT");
        sb.append(" appIconUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "appStoreUrl";
        mAutoDBInfo.colsMap.put("appStoreUrl", "TEXT");
        sb.append(" appStoreUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "appVersion";
        mAutoDBInfo.colsMap.put("appVersion", "INTEGER");
        sb.append(" appVersion INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "appWatermarkUrl";
        mAutoDBInfo.colsMap.put("appWatermarkUrl", "TEXT");
        sb.append(" appWatermarkUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME;
        mAutoDBInfo.colsMap.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "TEXT");
        sb.append(" packageName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "signature";
        mAutoDBInfo.colsMap.put("signature", "TEXT");
        sb.append(" signature TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "modifyTime";
        mAutoDBInfo.colsMap.put("modifyTime", "LONG");
        sb.append(" modifyTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "appName_en";
        mAutoDBInfo.colsMap.put("appName_en", "TEXT");
        sb.append(" appName_en TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "appName_tw";
        mAutoDBInfo.colsMap.put("appName_tw", "TEXT");
        sb.append(" appName_tw TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "appName_hk";
        mAutoDBInfo.colsMap.put("appName_hk", "TEXT");
        sb.append(" appName_hk TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "appDiscription_en";
        mAutoDBInfo.colsMap.put("appDiscription_en", "TEXT");
        sb.append(" appDiscription_en TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "appDiscription_tw";
        mAutoDBInfo.colsMap.put("appDiscription_tw", "TEXT");
        sb.append(" appDiscription_tw TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "appType";
        mAutoDBInfo.colsMap.put("appType", "TEXT");
        sb.append(" appType TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "openId";
        mAutoDBInfo.colsMap.put("openId", "TEXT");
        sb.append(" openId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "authFlag";
        mAutoDBInfo.colsMap.put("authFlag", "INTEGER");
        sb.append(" authFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "appInfoFlag";
        mAutoDBInfo.colsMap.put("appInfoFlag", "INTEGER default '-1' ");
        sb.append(" appInfoFlag INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "lvbuff";
        mAutoDBInfo.colsMap.put("lvbuff", "BLOB");
        sb.append(" lvbuff BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "serviceAppType";
        mAutoDBInfo.colsMap.put("serviceAppType", "INTEGER default '0' ");
        sb.append(" serviceAppType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "serviceAppInfoFlag";
        mAutoDBInfo.colsMap.put("serviceAppInfoFlag", "INTEGER default '0' ");
        sb.append(" serviceAppInfoFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "serviceShowFlag";
        mAutoDBInfo.colsMap.put("serviceShowFlag", "INTEGER default '0' ");
        sb.append(" serviceShowFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "appSupportContentType";
        mAutoDBInfo.colsMap.put("appSupportContentType", "LONG default '0' ");
        sb.append(" appSupportContentType LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "svrAppSupportContentType";
        mAutoDBInfo.colsMap.put("svrAppSupportContentType", "LONG default '0' ");
        sb.append(" svrAppSupportContentType LONG default '0' ");
        mAutoDBInfo.columns[26] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(151678);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public g() {
        AppMethodBeat.i(151672);
        this.field_appId = "";
        this.field_appName = "";
        this.field_appDiscription = "";
        this.field_appIconUrl = "";
        this.field_appStoreUrl = "";
        this.field_appVersion = 0;
        this.field_appWatermarkUrl = "";
        this.field_packageName = "";
        this.field_status = 4;
        this.field_signature = "";
        this.field_modifyTime = 0;
        this.field_appName_en = "";
        this.field_appName_tw = "";
        this.field_appName_hk = "";
        this.field_appDiscription_en = "";
        this.field_appDiscription_tw = "";
        this.field_appInfoFlag = 0;
        this.field_appType = "";
        this.field_openId = "";
        this.field_authFlag = 0;
        this.field_appInfoFlag = 0;
        Bk("");
        this.fmC = "";
        this.fma = true;
        Bl("");
        Bp("");
        Bq("");
        Br("");
        AppMethodBeat.o(151672);
    }

    public final boolean NA() {
        AppMethodBeat.i(151673);
        if (Util.isNullOrNil(this.field_appType)) {
            AppMethodBeat.o(151673);
            return false;
        }
        String[] split = this.field_appType.split(",");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(151673);
            return false;
        }
        for (String str : split) {
            if (str.equals("1")) {
                AppMethodBeat.o(151673);
                return true;
            }
        }
        AppMethodBeat.o(151673);
        return false;
    }

    public final boolean gmR() {
        if (this.field_serviceAppType == 0) {
            return false;
        }
        return true;
    }

    public final boolean gmS() {
        if ((this.field_serviceAppInfoFlag & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean gmT() {
        AppMethodBeat.i(151674);
        if (JVS.equals(this.field_appId)) {
            AppMethodBeat.o(151674);
            return true;
        }
        AppMethodBeat.o(151674);
        return false;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem, com.tencent.mm.g.c.y
    public ContentValues convertTo() {
        AppMethodBeat.i(151675);
        if (!Util.isNullOrNil(this.field_appType) && (this.field_appType.startsWith("1") || this.field_appType.startsWith("6"))) {
            this.field_appType = "," + this.field_appType;
        }
        ContentValues convertTo = super.convertTo();
        AppMethodBeat.o(151675);
        return convertTo;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(151676);
        if (obj == null) {
            AppMethodBeat.o(151676);
            return false;
        } else if (obj == this) {
            AppMethodBeat.o(151676);
            return true;
        } else if (!(obj instanceof g)) {
            AppMethodBeat.o(151676);
            return false;
        } else {
            boolean equals = ((g) obj).field_appId.equals(this.field_appId);
            AppMethodBeat.o(151676);
            return equals;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(151677);
        if (!Util.isNullOrNil(this.field_appId)) {
            int hashCode = this.field_appId.hashCode();
            AppMethodBeat.o(151677);
            return hashCode;
        }
        int hashCode2 = super.hashCode();
        AppMethodBeat.o(151677);
        return hashCode2;
    }
}
