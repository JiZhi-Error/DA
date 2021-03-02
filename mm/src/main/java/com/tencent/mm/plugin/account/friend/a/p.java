package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;

public final class p {
    int cSx = -1;
    public int dii = 0;
    private int iFr = 0;
    private String iFt = "";
    private String iFu = "";
    private int iWj = 0;
    public int keQ = 0;
    public String username = "";

    public p() {
        AppMethodBeat.i(131061);
        AppMethodBeat.o(131061);
    }

    public final ContentValues convertTo() {
        String str;
        String str2;
        AppMethodBeat.i(131062);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put(ch.COL_USERNAME, getUsername());
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("friendtype", Integer.valueOf(this.keQ));
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("updatetime", Integer.valueOf(this.dii));
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.iFr));
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.iWj));
        }
        if ((this.cSx & 32) != 0) {
            if (this.iFt == null) {
                str2 = "";
            } else {
                str2 = this.iFt;
            }
            contentValues.put("reserved3", str2);
        }
        if ((this.cSx & 64) != 0) {
            if (this.iFu == null) {
                str = "";
            } else {
                str = this.iFu;
            }
            contentValues.put("reserved4", str);
        }
        AppMethodBeat.o(131062);
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
