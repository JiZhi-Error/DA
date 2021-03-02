package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.contact.c;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.a.a;

public final class f implements a<String> {
    public CharSequence NON;
    private String field_alias;
    public String field_conRemark;
    public int field_deleteFlag;
    public String field_descWording;
    public String field_descWordingId;
    public String field_descWordingQuanpin;
    public byte[] field_lvbuff;
    public String field_nickname;
    public String field_openImAppid;
    public String field_remarkDesc;
    public int field_showHead;
    public String field_signature;
    public String field_username;
    private int field_verifyFlag;
    public int field_weiboFlag;
    public long gMZ;

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(90779);
        this.field_username = cursor.getString(0);
        this.field_nickname = cursor.getString(1);
        this.field_alias = cursor.getString(2);
        this.field_conRemark = cursor.getString(3);
        this.field_verifyFlag = cursor.getInt(4);
        this.field_showHead = cursor.getInt(5);
        this.field_weiboFlag = cursor.getInt(6);
        this.gMZ = cursor.getLong(7);
        this.field_deleteFlag = cursor.getInt(8);
        this.field_lvbuff = cursor.getBlob(9);
        this.field_descWordingId = cursor.getString(10);
        this.field_openImAppid = cursor.getString(11);
        if (cursor.getColumnCount() >= 14) {
            this.field_descWording = cursor.getString(12);
            this.field_descWordingQuanpin = cursor.getString(13);
        }
        gzA();
        AppMethodBeat.o(90779);
    }

    public final String arJ() {
        AppMethodBeat.i(90780);
        if (this.field_conRemark == null || this.field_conRemark.trim().equals("")) {
            String Ew = c.Ew(this.field_username);
            if (Ew != null) {
                AppMethodBeat.o(90780);
                return Ew;
            } else if (this.field_nickname == null || this.field_nickname.length() <= 0) {
                String str = this.field_alias;
                if (!Util.isNullOrNil(str)) {
                    AppMethodBeat.o(90780);
                    return str;
                }
                String str2 = this.field_username;
                if (str2 == null) {
                    str2 = null;
                } else if (str2.toLowerCase().endsWith("@t.qq.com")) {
                    str2 = "@" + str2.replace("@t.qq.com", "");
                } else if (str2.toLowerCase().endsWith("@qqim")) {
                    str2 = str2.replace("@qqim", "");
                    long longValue = Long.valueOf(str2).longValue();
                    if (longValue < 0) {
                        str2 = new p(longValue).toString();
                    }
                }
                if (str2 == null || str2.length() == 0) {
                    String str3 = this.field_username;
                    AppMethodBeat.o(90780);
                    return str3;
                }
                AppMethodBeat.o(90780);
                return str2;
            } else {
                String str4 = this.field_nickname;
                AppMethodBeat.o(90780);
                return str4;
            }
        } else {
            String str5 = this.field_conRemark;
            AppMethodBeat.o(90780);
            return str5;
        }
    }

    private void gzA() {
        AppMethodBeat.i(90781);
        if (this.field_lvbuff == null) {
            AppMethodBeat.o(90781);
            return;
        }
        try {
            if (this.field_lvbuff == null || this.field_lvbuff.length == 0) {
                AppMethodBeat.o(90781);
                return;
            }
            LVBuffer lVBuffer = new LVBuffer();
            if (lVBuffer.initParse(this.field_lvbuff) != 0) {
                AppMethodBeat.o(90781);
                return;
            }
            lVBuffer.skipPosition(4);
            lVBuffer.skipPosition(4);
            lVBuffer.skipString();
            lVBuffer.skipPosition(8);
            lVBuffer.skipPosition(4);
            lVBuffer.skipString();
            lVBuffer.skipString();
            lVBuffer.skipPosition(4);
            lVBuffer.skipPosition(4);
            lVBuffer.skipString();
            lVBuffer.skipString();
            lVBuffer.skipPosition(4);
            lVBuffer.skipPosition(4);
            this.field_signature = lVBuffer.getString();
            lVBuffer.skipString();
            lVBuffer.skipString();
            lVBuffer.skipString();
            lVBuffer.skipPosition(4);
            lVBuffer.skipPosition(4);
            lVBuffer.skipString();
            lVBuffer.skipPosition(4);
            lVBuffer.skipString();
            lVBuffer.skipString();
            lVBuffer.skipPosition(4);
            lVBuffer.skipPosition(4);
            if (!lVBuffer.checkGetFinish()) {
                this.field_remarkDesc = lVBuffer.getString();
            }
            this.field_lvbuff = null;
            AppMethodBeat.o(90781);
        } catch (Exception e2) {
            Log.e("MicroMsg.AddressUIContact", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(90781);
        }
    }

    @Override // com.tencent.mm.storagebase.a.a
    public final void t(int i2, byte[] bArr) {
        if (i2 == 9) {
            this.field_lvbuff = bArr;
        }
    }

    @Override // com.tencent.mm.storagebase.a.a
    public final void dh(int i2, String str) {
        switch (i2) {
            case 0:
                this.field_username = str;
                return;
            case 1:
                this.field_nickname = str;
                return;
            case 2:
                this.field_alias = str;
                return;
            case 3:
                this.field_conRemark = str;
                return;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                return;
            case 10:
                this.field_descWordingId = str;
                return;
            case 11:
                this.field_openImAppid = str;
                return;
            case 12:
                this.field_descWording = str;
                return;
            case 13:
                this.field_descWordingQuanpin = str;
                return;
        }
    }

    @Override // com.tencent.mm.storagebase.a.a
    public final void gzB() {
        AppMethodBeat.i(90782);
        gzA();
        AppMethodBeat.o(90782);
    }

    @Override // com.tencent.mm.storagebase.a.a
    public final void aT(int i2, long j2) {
        switch (i2) {
            case 4:
                this.field_verifyFlag = (int) j2;
                return;
            case 5:
                this.field_showHead = (int) j2;
                return;
            case 6:
                this.field_weiboFlag = (int) j2;
                return;
            case 7:
                this.gMZ = j2;
                return;
            case 8:
                this.field_deleteFlag = (int) j2;
                return;
            default:
                return;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.storagebase.a.a
    public final /* bridge */ /* synthetic */ String getKey() {
        return this.field_username;
    }
}
