package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq {
    int cSx = -1;
    int kfF = 0;
    int kfG = 0;
    int kfH = 0;
    int kfI = 0;
    int kfJ = 0;
    int kfK = 0;
    String kfL = "";
    String kfM = "";

    public aq() {
        AppMethodBeat.i(131154);
        AppMethodBeat.o(131154);
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(131155);
        this.kfF = cursor.getInt(0);
        this.kfG = cursor.getInt(1);
        this.kfH = cursor.getInt(2);
        this.kfI = cursor.getInt(3);
        this.kfJ = cursor.getInt(4);
        this.kfK = cursor.getInt(5);
        this.kfL = cursor.getString(6);
        this.kfM = cursor.getString(7);
        AppMethodBeat.o(131155);
    }

    public final ContentValues bos() {
        AppMethodBeat.i(131156);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put("grouopid", Integer.valueOf(this.kfF));
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("membernum", Integer.valueOf(this.kfG));
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("weixinnum", Integer.valueOf(this.kfH));
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put("insert_time", Integer.valueOf(this.kfI));
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("lastupdate_time", Integer.valueOf(this.kfJ));
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.kfK));
        }
        if ((this.cSx & 64) != 0) {
            contentValues.put("updatekey", bot());
        }
        if ((this.cSx & 128) != 0) {
            contentValues.put("groupname", bou());
        }
        AppMethodBeat.o(131156);
        return contentValues;
    }

    public final String bot() {
        return this.kfL == null ? "" : this.kfL;
    }

    public final String bou() {
        return this.kfM == null ? "" : this.kfM;
    }
}
