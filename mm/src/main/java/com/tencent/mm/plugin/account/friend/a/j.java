package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;

public final class j {
    int cSx = -1;
    public int fuA = 0;
    public int fuI = 0;
    public String fuJ = "";
    public String fuK = "";
    public String signature = "";
    public String username = "";

    public j() {
        AppMethodBeat.i(131017);
        AppMethodBeat.o(131017);
    }

    public final ContentValues convertTo() {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(131018);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put(ch.COL_USERNAME, getUsername());
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("sex", Integer.valueOf(this.fuA));
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.fuI));
        }
        if ((this.cSx & 8) != 0) {
            if (this.fuJ == null) {
                str3 = "";
            } else {
                str3 = this.fuJ;
            }
            contentValues.put("province", str3);
        }
        if ((this.cSx & 16) != 0) {
            if (this.fuK == null) {
                str2 = "";
            } else {
                str2 = this.fuK;
            }
            contentValues.put("city", str2);
        }
        if ((this.cSx & 32) != 0) {
            if (this.signature == null) {
                str = "";
            } else {
                str = this.signature;
            }
            contentValues.put("signature", str);
        }
        AppMethodBeat.o(131018);
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
