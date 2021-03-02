package com.tencent.mm.bj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cl;
import java.util.ArrayList;

public final class a {
    public static ArrayList<String> Qb(String str) {
        AppMethodBeat.i(20657);
        ArrayList<String> arrayList = new ArrayList<>();
        bx[] gR = d.bgO().gR(str, 10);
        if (gR != null) {
            for (bx bxVar : gR) {
                arrayList.add(bxVar.field_sayhicontent);
            }
        }
        Log.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
        AppMethodBeat.o(20657);
        return arrayList;
    }

    public static ArrayList<String> Qc(String str) {
        AppMethodBeat.i(20658);
        ArrayList<String> arrayList = new ArrayList<>();
        cl[] gT = d.bgP().gT(str, 10);
        if (gT != null) {
            for (cl clVar : gT) {
                arrayList.add(clVar.field_sayhicontent);
            }
        }
        Log.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
        AppMethodBeat.o(20658);
        return arrayList;
    }

    public static ArrayList<String> Qd(String str) {
        AppMethodBeat.i(20659);
        ArrayList<String> arrayList = new ArrayList<>();
        bg.aVF();
        Cursor aEG = c.aSQ().aEG(str);
        if (!(aEG == null || aEG.getCount() == 0)) {
            if (aEG.moveToFirst()) {
                int i2 = 0;
                while (!aEG.isAfterLast()) {
                    ca caVar = new ca();
                    caVar.convertFrom(aEG);
                    aEG.moveToNext();
                    if (caVar.isText()) {
                        arrayList.add(caVar.field_content);
                    } else {
                        arrayList.add("");
                    }
                    i2++;
                    if (i2 == 10) {
                        break;
                    }
                }
            }
            aEG.close();
        }
        AppMethodBeat.o(20659);
        return arrayList;
    }

    public static ArrayList<String> P(int i2, String str) {
        AppMethodBeat.i(20660);
        ArrayList<String> arrayList = new ArrayList<>();
        bn[] gQ = d.bgM().gQ(str, 10);
        if (gQ != null) {
            for (bn bnVar : gQ) {
                if (bnVar.field_type == 1) {
                    arrayList.add(Util.nullAsNil(ca.d.bkD(bnVar.field_msgContent).content));
                }
            }
        }
        Log.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", Integer.valueOf(i2));
        AppMethodBeat.o(20660);
        return arrayList;
    }
}
