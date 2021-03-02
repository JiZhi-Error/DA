package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.List;

public final class c extends MAutoStorage<CardInfo> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(CardInfo.info, "UserCardInfo"), "CREATE INDEX IF NOT EXISTS  stickyIndexIndex ON UserCardInfo ( stickyIndex ) "};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(112770);
        AppMethodBeat.o(112770);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, CardInfo.info, "UserCardInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final CardInfo ajk(String str) {
        AppMethodBeat.i(112768);
        CardInfo cardInfo = new CardInfo();
        cardInfo.field_card_id = str;
        if (super.get(cardInfo, new String[0])) {
            AppMethodBeat.o(112768);
            return cardInfo;
        }
        AppMethodBeat.o(112768);
        return null;
    }

    public final List<CardInfo> ctG() {
        AppMethodBeat.i(112769);
        Cursor rawQuery = this.db.rawQuery("select * from UserCardInfo where is_dynamic=?", new String[]{"1"});
        if (rawQuery == null) {
            Log.e("MicroMsg.CardInfoStorage", "getCardInfoList by is_dynamic is failure! cu is null!");
            AppMethodBeat.o(112769);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            try {
                CardInfo cardInfo = new CardInfo();
                cardInfo.convertFrom(rawQuery);
                arrayList.add(cardInfo);
            } catch (Exception e2) {
                Log.e("MicroMsg.CardInfoStorage", "getCardInfoList by is_dynamic is failure! is_dynamic = true", e2.getMessage());
                rawQuery.close();
            } catch (Throwable th) {
                rawQuery.close();
                AppMethodBeat.o(112769);
                throw th;
            }
        }
        rawQuery.close();
        AppMethodBeat.o(112769);
        return arrayList;
    }

    public final Cursor a(n.a aVar) {
        AppMethodBeat.i(112767);
        this.db.execSQL("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0 and (" + Util.nowSecond() + ">stickyEndTime and stickyEndTime<>0)");
        StringBuilder sb = new StringBuilder("select * from UserCardInfo");
        switch (aVar) {
            case NORMAL_TYPE:
                sb.append(" where (status=0 OR status=5)");
                break;
            case MEMBER_CARD_TYPE:
            case HOME_MEMBER_CARD_TYPE:
                sb.append(" where (status=0 OR status=5) AND ").append("card_type=10");
                break;
            case GENERAL_TYPE:
                sb.append(" where (status=0 OR status=5) AND ").append("card_type!=10");
                break;
            case GENERAL_WITHOUT_INVOICE_TYPE:
                sb.append(" where (status=0 OR status=5) AND ").append("card_type!=10 AND card_type!=30");
                break;
            case INVALID_TYPE:
                sb.append(" where (status=1 OR status=2 OR status").append("=3 OR status=4 OR status=6)");
                break;
            case CAN_GIFT_TYPE:
                sb.append(" where (status=0 OR status=5) and (block_mask").append("= '1' OR block_mask= '0' )");
                break;
        }
        sb.append(" order by stickyIndex desc, status asc , updateTime desc");
        if (aVar == n.a.HOME_MEMBER_CARD_TYPE) {
            sb.append(" LIMIT ").append(((Integer) g.aAh().azQ().get(ar.a.USERINFO_CARD_HOME_PAGE_CARD_NUM_INT_SYNC, (Object) 3)).intValue());
        }
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null);
        AppMethodBeat.o(112767);
        return rawQuery;
    }
}
