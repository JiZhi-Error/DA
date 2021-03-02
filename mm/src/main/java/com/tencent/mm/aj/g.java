package com.tencent.mm.aj;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;

public final class g {
    int bNu;
    int cSx = -1;
    int iKM;
    int iKN;
    String iKO;
    int iKP;
    int iKQ;
    String iKR;
    String iKS;
    int iKT;
    int iKU;
    String username;

    public g() {
        AppMethodBeat.i(150279);
        reset();
        AppMethodBeat.o(150279);
    }

    public final void reset() {
        this.username = "";
        this.iKM = 0;
        this.iKN = 0;
        this.iKO = "";
        this.iKP = 0;
        this.bNu = 0;
        this.iKQ = 0;
        this.iKR = "";
        this.iKS = "";
        this.iKT = 0;
        this.iKU = 0;
    }

    public final ContentValues convertTo() {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(150280);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            if (this.username == null) {
                str3 = "";
            } else {
                str3 = this.username;
            }
            contentValues.put(ch.COL_USERNAME, str3);
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("imgwidth", Integer.valueOf(this.iKM));
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("imgheigth", Integer.valueOf(this.iKN));
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put("imgformat", aYp());
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.iKP));
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("startpos", Integer.valueOf(this.bNu));
        }
        if ((this.cSx & 64) != 0) {
            contentValues.put("headimgtype", Integer.valueOf(this.iKQ));
        }
        if ((this.cSx & 128) != 0) {
            if (this.iKR == null) {
                str2 = "";
            } else {
                str2 = this.iKR;
            }
            contentValues.put("reserved1", str2);
        }
        if ((this.cSx & 256) != 0) {
            if (this.iKS == null) {
                str = "";
            } else {
                str = this.iKS;
            }
            contentValues.put("reserved2", str);
        }
        if ((this.cSx & 512) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.iKT));
        }
        if ((this.cSx & 1024) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.iKU));
        }
        AppMethodBeat.o(150280);
        return contentValues;
    }

    public final String aYp() {
        return this.iKO == null ? "" : this.iKO;
    }
}
