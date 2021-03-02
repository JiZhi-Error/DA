package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class l extends MAutoStorage<k> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(k.info, "CardQrCodeDataInfo")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(112790);
        AppMethodBeat.o(112790);
    }

    public l(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, k.info, "CardQrCodeDataInfo", k.INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final List<k> ajm(String str) {
        AppMethodBeat.i(112785);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{str});
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                k kVar = new k();
                kVar.convertFrom(rawQuery);
                arrayList.add(kVar);
            } catch (Exception e2) {
                Log.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeByCardId error!", e2.getMessage());
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(112785);
                throw th;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.o(112785);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.card.model.k ajn(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.model.l.ajn(java.lang.String):com.tencent.mm.plugin.card.model.k");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.card.model.k ajo(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.model.l.ajo(java.lang.String):com.tencent.mm.plugin.card.model.k");
    }

    public final boolean fr(String str, String str2) {
        AppMethodBeat.i(112788);
        k kVar = new k();
        kVar.field_card_id = str;
        kVar.field_code_id = str2;
        boolean delete = delete(kVar, "card_id", "code_id");
        if (!delete) {
            Log.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  failure! card_id = %s, code_id = %s", kVar.field_card_id, kVar.field_code_id);
        } else {
            Log.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  success! card_id = %s, code_id = %s", kVar.field_card_id, kVar.field_code_id);
        }
        AppMethodBeat.o(112788);
        return delete;
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(112789);
        k kVar = new k();
        kVar.field_card_id = str;
        boolean delete = delete(kVar, "card_id");
        if (!delete) {
            Log.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  failure! card_id = %s", str);
        } else {
            Log.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  success! card_id = %s", str);
        }
        AppMethodBeat.o(112789);
        return delete;
    }
}
