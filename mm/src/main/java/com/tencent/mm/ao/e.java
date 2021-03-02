package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;

public final class e extends as {
    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        return i2 != 0 && i2 < 604372991;
    }

    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        az azVar;
        AppMethodBeat.i(20480);
        Log.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", Integer.valueOf(i2));
        if (i2 != 0 && i2 < 604372991) {
            h.INSTANCE.dN(336, 14);
            bg.aVF();
            com.tencent.mm.storagebase.h dataDB = c.getDataDB();
            StringBuilder sb = new StringBuilder();
            sb.append("select rconversation.username from rconversation, rcontact").append(", bizinfo where rconversation.username = rcontact").append(".username and rconversation.username = bizinfo").append(".username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
            String sb2 = sb.toString();
            Log.d("MicroMsg.ConversationDataTransfer", "select sql %s", sb2);
            Cursor rawQuery = dataDB.rawQuery(sb2, null, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
                do {
                    String string = rawQuery.getString(0);
                    if (!ab.JA(string)) {
                        sb3.append(" or username = '").append(string).append("'");
                    }
                } while (rawQuery.moveToNext());
                rawQuery.close();
                String sb4 = sb3.toString();
                Log.d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", Boolean.TRUE, sb4);
                dataDB.execSQL("rconversation", sb4);
                bg.aVF();
                az bjY = c.aST().bjY("officialaccounts");
                if (bjY == null) {
                    az azVar2 = new az("officialaccounts");
                    azVar2.gCr();
                    bg.aVF();
                    c.aST().e(azVar2);
                    azVar = azVar2;
                } else {
                    azVar = bjY;
                }
                bg.aVF();
                String gCz = c.aST().gCz();
                if (Util.isNullOrNil(gCz)) {
                    Log.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
                    AppMethodBeat.o(20480);
                    return;
                }
                bg.aVF();
                ca aEx = c.aSQ().aEx(gCz);
                if (aEx == null || aEx.field_msgId == 0) {
                    Log.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
                    AppMethodBeat.o(20480);
                    return;
                }
                azVar.aX(aEx);
                azVar.setContent(aEx.field_talker + ":" + aEx.field_content);
                azVar.Cl(Integer.toString(aEx.getType()));
                bg.aVF();
                bw.b Xh = c.aST().Xh();
                if (Xh != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    aEx.Cy("officialaccounts");
                    aEx.setContent(azVar.field_content);
                    Xh.a(aEx, pString, pString2, pInt, false);
                    azVar.Cm(pString.value);
                    azVar.Cn(pString2.value);
                    azVar.nw(pInt.value);
                }
                bg.aVF();
                c.aST().a(azVar, azVar.field_username);
            }
            if (rawQuery != null && !rawQuery.isClosed()) {
                rawQuery.close();
            }
        }
        AppMethodBeat.o(20480);
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.ConversationDataTransfer";
    }
}
