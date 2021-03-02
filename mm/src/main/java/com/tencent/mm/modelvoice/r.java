package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public final class r {
    public int cSx = -1;
    public String clientId = "";
    public long createTime = 0;
    public long dTS = 0;
    public String dWq = "";
    public String fileName = "";
    int fqJ = 0;
    String fqK = "";
    public int iKP = 0;
    public int jqP = 0;
    public String jsh = "";
    public int jsj = 0;
    public long jsm = 0;
    public int jso = 0;
    int jsp = 0;
    String jui = "";
    int jup = 0;
    public int jvt = 0;
    int jvu = 0;
    long jvv = 0;
    int jvw = 0;
    public int jvx = 0;
    public int status = 0;

    public final boolean bif() {
        if (this.status == 5 || this.status == 6) {
            return true;
        }
        return false;
    }

    public final boolean big() {
        if ((this.status <= 1 || this.status > 3) && this.status != 8) {
            return false;
        }
        return true;
    }

    public final ContentValues convertTo() {
        AppMethodBeat.i(148452);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put("FileName", this.fileName);
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("User", this.dWq);
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("MsgId", Long.valueOf(this.dTS));
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put("NetOffset", Integer.valueOf(this.jqP));
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("FileNowSize", Integer.valueOf(this.jsj));
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("TotalLen", Integer.valueOf(this.iKP));
        }
        if ((this.cSx & 64) != 0) {
            contentValues.put("Status", Integer.valueOf(this.status));
        }
        if ((this.cSx & 128) != 0) {
            contentValues.put("CreateTime", Long.valueOf(this.createTime));
        }
        if ((this.cSx & 256) != 0) {
            contentValues.put("LastModifyTime", Long.valueOf(this.jsm));
        }
        if ((this.cSx & 512) != 0) {
            contentValues.put("ClientId", this.clientId);
        }
        if ((this.cSx & 1024) != 0) {
            contentValues.put("VoiceLength", Integer.valueOf(this.jvt));
        }
        if ((this.cSx & 2048) != 0) {
            contentValues.put("MsgLocalId", Integer.valueOf(this.jso));
        }
        if ((this.cSx & 4096) != 0) {
            contentValues.put("Human", this.jsh);
        }
        if ((this.cSx & 8192) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.jsp));
        }
        if ((this.cSx & 16384) != 0) {
            contentValues.put("reserved2", this.jui);
        }
        if ((this.cSx & 32768) != 0) {
            contentValues.put("MsgSource", this.fqK);
        }
        if ((this.cSx & 65536) != 0) {
            contentValues.put("MsgFlag", Integer.valueOf(this.fqJ));
        }
        if ((this.cSx & 131072) != 0) {
            contentValues.put("MsgSeq", Integer.valueOf(this.jvu));
        }
        if ((this.cSx & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0) {
            contentValues.put("MasterBufId", Long.valueOf(this.jvv));
        }
        if ((this.cSx & 524288) != 0) {
            contentValues.put("checksum", Integer.valueOf(this.jvw));
        }
        if ((this.cSx & 1048576) != 0) {
            contentValues.put("VoiceFlag", Integer.valueOf(this.jvx));
        }
        AppMethodBeat.o(148452);
        return contentValues;
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(148453);
        this.fileName = cursor.getString(0);
        this.dWq = cursor.getString(1);
        this.dTS = cursor.getLong(2);
        this.jqP = cursor.getInt(3);
        this.jsj = cursor.getInt(4);
        this.iKP = cursor.getInt(5);
        this.status = cursor.getInt(6);
        this.createTime = cursor.getLong(7);
        this.jsm = cursor.getLong(8);
        this.clientId = cursor.getString(9);
        this.jvt = cursor.getInt(10);
        this.jso = cursor.getInt(11);
        this.jsh = cursor.getString(12);
        this.jsp = cursor.getInt(13);
        this.jui = cursor.getString(14);
        this.fqK = cursor.getString(15);
        this.fqJ = cursor.getInt(16);
        this.jvu = cursor.getInt(17);
        this.jvv = cursor.getLong(18);
        this.jvw = cursor.getInt(19);
        this.jvx = cursor.getInt(20);
        AppMethodBeat.o(148453);
    }

    public r() {
        AppMethodBeat.i(148454);
        AppMethodBeat.o(148454);
    }

    public final boolean bih() {
        return (this.jvx & 1) != 0;
    }
}
