package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.di;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class n extends di {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final String toString() {
        AppMethodBeat.i(131046);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("googleIDgoogleid\n");
        stringBuffer.append("googleNamegooglename\n");
        stringBuffer.append("googlePhotoUrlgooglephotourl\n");
        stringBuffer.append("googleGmailgooglegmail\n");
        stringBuffer.append("userNameusername\n");
        stringBuffer.append("nickNamenickname\n");
        stringBuffer.append("nickNameQuanPinnicknameqp\n");
        stringBuffer.append("nickNamePYInitialusernamepy\n");
        stringBuffer.append("smallHeaderUrlsmall_url\n");
        stringBuffer.append("bigHeaderUrlbig_url\n");
        stringBuffer.append("retret\n");
        stringBuffer.append("statusstatus\n");
        stringBuffer.append("googleItemIDgoogleitemid\n");
        stringBuffer.append("cgiStatusgooglecgistatus\n");
        stringBuffer.append("contactTypecontecttype\n");
        stringBuffer.append("googleNamePYInitialgooglenamepy\n");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(131046);
        return stringBuffer2;
    }

    static {
        AppMethodBeat.i(131047);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[16];
        mAutoDBInfo.columns = new String[17];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "googleid";
        mAutoDBInfo.colsMap.put("googleid", "TEXT");
        sb.append(" googleid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "googlename";
        mAutoDBInfo.colsMap.put("googlename", "TEXT");
        sb.append(" googlename TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "googlephotourl";
        mAutoDBInfo.colsMap.put("googlephotourl", "TEXT");
        sb.append(" googlephotourl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "googlegmail";
        mAutoDBInfo.colsMap.put("googlegmail", "TEXT");
        sb.append(" googlegmail TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT");
        sb.append(" nickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "nicknameqp";
        mAutoDBInfo.colsMap.put("nicknameqp", "TEXT");
        sb.append(" nicknameqp TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "usernamepy";
        mAutoDBInfo.colsMap.put("usernamepy", "TEXT");
        sb.append(" usernamepy TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "small_url";
        mAutoDBInfo.colsMap.put("small_url", "TEXT");
        sb.append(" small_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "big_url";
        mAutoDBInfo.colsMap.put("big_url", "TEXT");
        sb.append(" big_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "ret";
        mAutoDBInfo.colsMap.put("ret", "INTEGER");
        sb.append(" ret INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "googleitemid";
        mAutoDBInfo.colsMap.put("googleitemid", "TEXT PRIMARY KEY ");
        sb.append(" googleitemid TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "googleitemid";
        mAutoDBInfo.columns[13] = "googlecgistatus";
        mAutoDBInfo.colsMap.put("googlecgistatus", "INTEGER default '2' ");
        sb.append(" googlecgistatus INTEGER default '2' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "contecttype";
        mAutoDBInfo.colsMap.put("contecttype", "TEXT");
        sb.append(" contecttype TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "googlenamepy";
        mAutoDBInfo.colsMap.put("googlenamepy", "TEXT");
        sb.append(" googlenamepy TEXT");
        mAutoDBInfo.columns[16] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(131047);
    }
}
