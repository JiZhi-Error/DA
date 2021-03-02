package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;

public final class as {
    int cSx = -1;
    String iKR = "";
    String iKS = "";
    public int iKT = 0;
    public int iKU = 0;
    public long kfN = 0;
    public int kfO = 0;
    int kfP = 0;
    String kfQ = "";
    String kfR = "";
    String kfS = "";
    String kfT = "";
    String kfU = "";
    public String kfV = "";
    String kfW = "";
    String kfX = "";
    public String nickname = "";
    public String username = "";

    public as() {
        AppMethodBeat.i(131159);
        AppMethodBeat.o(131159);
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(131160);
        this.kfN = cursor.getLong(0);
        int i2 = cursor.getInt(1);
        if (i2 == 65536) {
            this.kfO = 0;
        } else {
            this.kfO = i2;
        }
        this.kfP = cursor.getInt(2);
        this.username = cursor.getString(3);
        this.nickname = cursor.getString(4);
        this.kfQ = cursor.getString(5);
        this.kfR = cursor.getString(6);
        this.kfS = cursor.getString(7);
        this.kfT = cursor.getString(8);
        this.kfU = cursor.getString(9);
        this.kfV = cursor.getString(10);
        this.kfW = cursor.getString(11);
        this.kfX = cursor.getString(12);
        this.iKR = cursor.getString(13);
        this.iKS = cursor.getString(14);
        this.iKT = cursor.getInt(15);
        this.iKU = cursor.getInt(16);
        AppMethodBeat.o(131160);
    }

    public final ContentValues bov() {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(131161);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put("qq", Long.valueOf(this.kfN));
        }
        if ((this.cSx & 2) != 0) {
            int i2 = this.kfO;
            if (i2 == 0) {
                contentValues.put("wexinstatus", (Integer) 65536);
            } else {
                contentValues.put("wexinstatus", Integer.valueOf(i2));
            }
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("groupid", Integer.valueOf(this.kfP));
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put(ch.COL_USERNAME, getUsername());
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("nickname", getNickname());
        }
        if ((this.cSx & 32) != 0) {
            if (this.kfQ == null) {
                str3 = "";
            } else {
                str3 = this.kfQ;
            }
            contentValues.put("pyinitial", str3);
        }
        if ((this.cSx & 64) != 0) {
            if (this.kfR == null) {
                str2 = "";
            } else {
                str2 = this.kfR;
            }
            contentValues.put("quanpin", str2);
        }
        if ((this.cSx & 128) != 0) {
            contentValues.put("qqnickname", bow());
        }
        if ((this.cSx & 256) != 0) {
            contentValues.put("qqpyinitial", box());
        }
        if ((this.cSx & 512) != 0) {
            contentValues.put("qqquanpin", boy());
        }
        if ((this.cSx & 1024) != 0) {
            contentValues.put("qqremark", boz());
        }
        if ((this.cSx & 2048) != 0) {
            contentValues.put("qqremarkpyinitial", boA());
        }
        if ((this.cSx & 4096) != 0) {
            contentValues.put("qqremarkquanpin", boB());
        }
        if ((this.cSx & 16384) != 0) {
            if (this.iKS == null) {
                str = "";
            } else {
                str = this.iKS;
            }
            contentValues.put("reserved2", str);
        }
        if ((this.cSx & 32768) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.iKT));
        }
        if ((this.cSx & 65536) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.iKU));
        }
        AppMethodBeat.o(131161);
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String getNickname() {
        return this.nickname == null ? "" : this.nickname;
    }

    public final String bow() {
        return this.kfS == null ? "" : this.kfS;
    }

    public final String box() {
        return this.kfT == null ? "" : this.kfT;
    }

    public final String boy() {
        return this.kfU == null ? "" : this.kfU;
    }

    public final String boz() {
        return this.kfV == null ? "" : this.kfV;
    }

    public final String boA() {
        return this.kfW == null ? "" : this.kfW;
    }

    public final String boB() {
        return this.kfX == null ? "" : this.kfX;
    }

    public final String getDisplayName() {
        AppMethodBeat.i(131162);
        if (boz() == null || boz().length() <= 0) {
            String bow = bow();
            AppMethodBeat.o(131162);
            return bow;
        }
        String boz = boz();
        AppMethodBeat.o(131162);
        return boz;
    }

    public final void boC() {
        this.iKT |= 1;
    }

    public final String toString() {
        AppMethodBeat.i(131163);
        StringBuilder sb = new StringBuilder();
        sb.append("groupID\t:").append(this.kfP).append("\n");
        sb.append("qq\t:").append(this.kfN).append("\n");
        sb.append("username\t:").append(this.username).append("\n");
        sb.append("nickname\t:").append(this.nickname).append("\n");
        sb.append("wexinStatus\t:").append(this.kfO).append("\n");
        sb.append("reserved3\t:").append(this.iKT).append("\n");
        sb.append("reserved4\t:").append(this.iKU).append("\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(131163);
        return sb2;
    }
}
