package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;

public final class k extends MAutoStorage<ShareCardInfo> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ShareCardInfo.info, "ShareCardInfo")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(113022);
        AppMethodBeat.o(113022);
    }

    public static String Ek(int i2) {
        AppMethodBeat.i(113013);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> Eh = b.Eh(i2);
        if (Eh == null || Eh.size() <= 0) {
            AppMethodBeat.o(113013);
            return "";
        }
        sb.append(" (");
        for (int i3 = 0; i3 < Eh.size(); i3++) {
            if (i3 != 0) {
                sb.append(" OR ");
            }
            sb.append("card_id").append(" = '" + Eh.get(i3) + "' ");
        }
        sb.append(") AND ");
        String sb2 = sb.toString();
        AppMethodBeat.o(113013);
        return sb2;
    }

    public k(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ShareCardInfo.info, "ShareCardInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final ArrayList<String> ajw(String str) {
        ArrayList<String> arrayList = null;
        AppMethodBeat.i(113014);
        Log.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), limit is 99");
        StringBuilder sb = new StringBuilder();
        sb.append(" where ( status=0) ");
        sb.append(" AND (card_tp_id = '" + str + "' )");
        sb.append(" order by share_time desc ");
        sb.append(" limit 99");
        Cursor rawQuery = this.db.rawQuery("select ShareCardInfo.from_username from ShareCardInfo" + sb.toString(), null, 2);
        if (rawQuery == null) {
            Log.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), cursor == null");
            AppMethodBeat.o(113014);
        } else {
            int columnIndex = rawQuery.getColumnIndex("from_username");
            if (columnIndex == -1) {
                Log.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), index is wrong");
                rawQuery.close();
                AppMethodBeat.o(113014);
            } else {
                arrayList = new ArrayList<>();
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(columnIndex);
                    if (TextUtils.isEmpty(string) || arrayList.contains(string)) {
                        Log.e("MicroMsg.ShareCardInfoStorage", "the field_from_username is empty or username is added!, the card id is ".concat(String.valueOf(str)));
                    } else {
                        arrayList.add(string);
                    }
                    if (arrayList.size() >= 99) {
                        break;
                    }
                }
                rawQuery.close();
                AppMethodBeat.o(113014);
            }
        }
        return arrayList;
    }

    public final int ajx(String str) {
        int i2 = 0;
        AppMethodBeat.i(113015);
        Log.i("MicroMsg.ShareCardInfoStorage", "getNormalCount()");
        StringBuilder sb = new StringBuilder();
        sb.append(" where ( status=0) ");
        sb.append(" AND (card_tp_id = '" + str + "' )");
        Cursor rawQuery = this.db.rawQuery("select count(*) from ShareCardInfo" + sb.toString(), null, 2);
        if (rawQuery == null) {
            Log.i("MicroMsg.ShareCardInfoStorage", "getNormalCount(), cursor == null");
            AppMethodBeat.o(113015);
        } else {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(113015);
        }
        return i2;
    }

    public final String ajy(String str) {
        AppMethodBeat.i(113016);
        Log.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId()");
        StringBuilder sb = new StringBuilder();
        sb.append(" where ( status=0) ");
        sb.append(" AND (card_tp_id = '" + str + "' )");
        sb.append(" order by share_time desc ");
        sb.append(" limit 1");
        Cursor rawQuery = this.db.rawQuery("select ShareCardInfo.card_id from ShareCardInfo" + sb.toString(), null, 2);
        if (rawQuery == null) {
            Log.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), cursor == null");
            AppMethodBeat.o(113016);
            return "";
        }
        int columnIndex = rawQuery.getColumnIndex("card_id");
        if (columnIndex == -1) {
            Log.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), index is wrong");
            rawQuery.close();
            AppMethodBeat.o(113016);
            return "";
        }
        String str2 = "";
        if (rawQuery.moveToFirst()) {
            str2 = rawQuery.getString(columnIndex);
        }
        rawQuery.close();
        AppMethodBeat.o(113016);
        return str2;
    }

    public final String fv(String str, String str2) {
        AppMethodBeat.i(113017);
        Log.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId()");
        StringBuilder sb = new StringBuilder();
        sb.append(" where ( status=0) ");
        sb.append(" AND (card_tp_id = '" + str2 + "' )");
        sb.append(" order by share_time desc ");
        sb.append(" limit 2");
        Cursor rawQuery = this.db.rawQuery("select ShareCardInfo.card_id from ShareCardInfo" + sb.toString(), null, 2);
        if (rawQuery == null) {
            Log.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), cursor == null");
            AppMethodBeat.o(113017);
            return "";
        }
        int columnIndex = rawQuery.getColumnIndex("card_id");
        if (columnIndex == -1) {
            Log.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), index is wrong");
            rawQuery.close();
            AppMethodBeat.o(113017);
            return "";
        }
        String str3 = "";
        while (rawQuery.moveToNext()) {
            str3 = rawQuery.getString(columnIndex);
            if (str != null && !str.equals(str3)) {
                break;
            }
        }
        rawQuery.close();
        AppMethodBeat.o(113017);
        return str3;
    }

    public final boolean El(int i2) {
        AppMethodBeat.i(113018);
        StringBuilder sb = new StringBuilder();
        sb.append(" where ( status=0) ");
        sb.append(" AND (");
        sb.append("categoryType").append(" = '" + i2 + "'");
        sb.append(")");
        boolean execSQL = this.db.execSQL("ShareCardInfo", "update ShareCardInfo set categoryType = '0' , itemIndex = '0' " + sb.toString());
        Log.i("MicroMsg.ShareCardInfoStorage", "resetCategoryInfo updateRet is " + (execSQL ? 1 : 0));
        AppMethodBeat.o(113018);
        return execSQL;
    }

    public final boolean W(String str, int i2, int i3) {
        AppMethodBeat.i(113019);
        StringBuilder sb = new StringBuilder();
        sb.append(" where ( status=0) ");
        sb.append(" AND (card_tp_id = '" + str + "' )");
        boolean execSQL = this.db.execSQL("ShareCardInfo", "update ShareCardInfo set categoryType = '" + i2 + "', itemIndex = '" + i3 + "' " + sb.toString());
        Log.i("MicroMsg.ShareCardInfoStorage", "updateCategoryInfo updateRet is " + (execSQL ? 1 : 0));
        AppMethodBeat.o(113019);
        return execSQL;
    }

    public final void ajz(String str) {
        AppMethodBeat.i(113020);
        this.db.execSQL("ShareCardInfo", "delete from ShareCardInfo where card_id = '" + str + "'");
        AppMethodBeat.o(113020);
    }

    public final ShareCardInfo ajA(String str) {
        AppMethodBeat.i(113021);
        ShareCardInfo shareCardInfo = new ShareCardInfo();
        shareCardInfo.field_card_id = str;
        if (super.get(shareCardInfo, new String[0])) {
            AppMethodBeat.o(113021);
            return shareCardInfo;
        }
        AppMethodBeat.o(113021);
        return null;
    }
}
