package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;

public final class g {
    int cSx = -1;
    String fMb = "";
    int fuA = 0;
    public long fuC = 0;
    private String fuD = "";
    int fuI = 0;
    String fuJ = "";
    String fuK = "";
    String kdR = "";
    String kdS = "";
    String ker = "";
    int kes = 0;
    String nickName = "";
    String signature = "";
    public int status = 0;
    private int type = 0;
    String username = "";

    public g() {
        AppMethodBeat.i(130993);
        AppMethodBeat.o(130993);
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(130994);
        this.fuC = cursor.getLong(0);
        this.ker = cursor.getString(1);
        this.kes = cursor.getInt(2);
        this.status = cursor.getInt(3);
        this.username = cursor.getString(4);
        this.nickName = cursor.getString(5);
        this.kdR = cursor.getString(6);
        this.kdS = cursor.getString(7);
        this.fuA = cursor.getInt(8);
        this.fuI = cursor.getInt(9);
        this.fuJ = cursor.getString(10);
        this.fuK = cursor.getString(11);
        this.signature = cursor.getString(12);
        this.fMb = cursor.getString(13);
        this.type = cursor.getInt(14);
        this.fuD = cursor.getString(15);
        AppMethodBeat.o(130994);
    }

    public final ContentValues convertTo() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        AppMethodBeat.i(130995);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put("fbid", Long.valueOf(this.fuC));
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("fbname", bnT());
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("fbimgkey", Integer.valueOf(this.kes));
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put(ch.COL_USERNAME, getUsername());
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("nickname", getNickName());
        }
        if ((this.cSx & 64) != 0) {
            if (this.kdR == null) {
                str7 = "";
            } else {
                str7 = this.kdR;
            }
            contentValues.put("nicknamepyinitial", str7);
        }
        if ((this.cSx & 128) != 0) {
            if (this.kdS == null) {
                str6 = "";
            } else {
                str6 = this.kdS;
            }
            contentValues.put("nicknamequanpin", str6);
        }
        if ((this.cSx & 256) != 0) {
            contentValues.put("sex", Integer.valueOf(this.fuA));
        }
        if ((this.cSx & 512) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.fuI));
        }
        if ((this.cSx & 1024) != 0) {
            if (this.fuJ == null) {
                str5 = "";
            } else {
                str5 = this.fuJ;
            }
            contentValues.put("province", str5);
        }
        if ((this.cSx & 2048) != 0) {
            if (this.fuK == null) {
                str4 = "";
            } else {
                str4 = this.fuK;
            }
            contentValues.put("city", str4);
        }
        if ((this.cSx & 4096) != 0) {
            if (this.signature == null) {
                str3 = "";
            } else {
                str3 = this.signature;
            }
            contentValues.put("signature", str3);
        }
        if ((this.cSx & 8192) != 0) {
            if (this.fMb == null) {
                str2 = "";
            } else {
                str2 = this.fMb;
            }
            contentValues.put("alias", str2);
        }
        if ((this.cSx & 16384) != 0) {
            contentValues.put("type", Integer.valueOf(this.type));
        }
        if ((this.cSx & 32768) != 0) {
            if (this.fuD == null) {
                str = "";
            } else {
                str = this.fuD;
            }
            contentValues.put(Scopes.EMAIL, str);
        }
        AppMethodBeat.o(130995);
        return contentValues;
    }

    public final String bnT() {
        return this.ker == null ? "" : this.ker;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String getNickName() {
        return this.nickName == null ? "" : this.nickName;
    }
}
