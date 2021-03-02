package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;

public final class q {
    private long EmL;
    public int EmM;
    public String EmN;
    private int EmO;
    private long EmP;
    public String EmQ;
    public byte[] EmR;
    long createTime;
    private int kdU;
    public int localid;
    public int offset;
    public int type;
    private String userName;

    public final ContentValues feY() {
        AppMethodBeat.i(97595);
        ContentValues contentValues = new ContentValues();
        contentValues.put("seqId", Long.valueOf(this.EmL));
        contentValues.put("type", Integer.valueOf(this.type));
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("userName", this.userName);
        contentValues.put("totallen", Integer.valueOf(this.EmM));
        contentValues.put("offset", Integer.valueOf(this.offset));
        contentValues.put("local_flag", Integer.valueOf(this.kdU));
        contentValues.put("tmp_path", this.EmN);
        contentValues.put("nums", Integer.valueOf(this.EmO));
        contentValues.put("try_times", Long.valueOf(this.EmP));
        contentValues.put("StrId", this.EmQ);
        contentValues.put("upload_buf", this.EmR);
        AppMethodBeat.o(97595);
        return contentValues;
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(97596);
        this.localid = cursor.getInt(0);
        long j2 = cursor.getLong(1);
        this.EmL = j2;
        this.EmQ = r.Jb(j2);
        this.type = cursor.getInt(2);
        this.createTime = cursor.getLong(3);
        this.userName = cursor.getString(4);
        this.EmM = cursor.getInt(5);
        this.offset = cursor.getInt(6);
        this.kdU = cursor.getInt(7);
        this.EmN = cursor.getString(8);
        this.EmO = cursor.getInt(9);
        this.EmP = cursor.getLong(10);
        this.EmQ = cursor.getString(11);
        this.EmR = cursor.getBlob(12);
        AppMethodBeat.o(97596);
    }

    public final void feZ() {
        this.kdU |= 4;
    }

    public final void ffa() {
        this.kdU &= -5;
    }

    public final String ffb() {
        return this.EmN;
    }
}
