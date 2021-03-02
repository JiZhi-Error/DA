package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public final class a {
    public int cSx = -1;
    public String fuD = "";
    public String iKR = "";
    public int iKU = 0;
    private int id = 0;
    public String kdN = "";
    long kdO = 0;
    public String kdP = "";
    public String kdQ = "";
    String kdR = "";
    String kdS = "";
    public String kdT = "";
    public int kdU = 0;
    public byte[] kdV;
    public int kdW;
    public String kdX = "";
    public int kdY = 0;
    public String kdZ = "";
    public String kea = "";
    public String keb = "";
    int kec = 0;
    public String ked = "";
    int kee = 0;
    int kef = 0;
    String keg = "";
    public String keh = "";
    String kei = "";
    int kej = -1;
    String kek = "";
    long kel = -1;
    int kem = -1;
    String ken = "";
    String keo = "";
    String kep = "";
    public long keq = 0;
    private String md5 = "";
    String nickName = "";
    public String realName = "";
    public int status = 0;
    public int type = 0;
    public String username = "";

    public a() {
        AppMethodBeat.i(130966);
        AppMethodBeat.o(130966);
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(130967);
        setMd5(cursor.getString(1));
        this.kdN = cursor.getString(2);
        this.kdO = cursor.getLong(3);
        this.realName = cursor.getString(4);
        this.kdP = cursor.getString(5);
        this.kdQ = cursor.getString(6);
        this.username = cursor.getString(7);
        this.nickName = cursor.getString(8);
        this.kdR = cursor.getString(9);
        this.kdS = cursor.getString(10);
        this.type = cursor.getInt(11);
        this.kdT = cursor.getString(12);
        this.fuD = cursor.getString(13);
        int i2 = cursor.getInt(14);
        if (i2 == 65536) {
            this.status = 0;
        } else {
            this.status = i2;
        }
        this.kdU = cursor.getInt(17);
        this.iKR = cursor.getString(15);
        this.iKU = cursor.getInt(18);
        this.kdV = cursor.getBlob(19);
        if (!Util.isNullOrNil(this.kdV)) {
            aG(this.kdV);
        }
        this.kdW = cursor.getInt(20);
        AppMethodBeat.o(130967);
    }

    private void aG(byte[] bArr) {
        AppMethodBeat.i(130968);
        try {
            LVBuffer lVBuffer = new LVBuffer();
            int initParse = lVBuffer.initParse(bArr);
            if (initParse != 0) {
                Log.e("MicroMsg.AddrUpload", "parse LVBuffer error:".concat(String.valueOf(initParse)));
                AppMethodBeat.o(130968);
                return;
            }
            this.kdX = lVBuffer.getString();
            this.kdY = lVBuffer.getInt();
            this.kdZ = lVBuffer.getString();
            this.kea = lVBuffer.getString();
            this.keb = lVBuffer.getString();
            this.kec = lVBuffer.getInt();
            this.ked = lVBuffer.getString();
            this.kee = lVBuffer.getInt();
            this.kef = lVBuffer.getInt();
            this.keg = lVBuffer.getString();
            this.keh = lVBuffer.getString();
            this.kei = lVBuffer.getString();
            this.kej = lVBuffer.getInt();
            this.kek = lVBuffer.getString();
            this.kel = lVBuffer.getLong();
            this.kem = lVBuffer.getInt();
            this.ken = lVBuffer.getString();
            this.keo = lVBuffer.getString();
            this.kep = lVBuffer.getString();
            this.keq = lVBuffer.getLong();
            AppMethodBeat.o(130968);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AddrUpload", e2, "", new Object[0]);
            AppMethodBeat.o(130968);
        }
    }

    public final ContentValues convertTo() {
        AppMethodBeat.i(130969);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put("id", Integer.valueOf(this.id));
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("md5", getMd5());
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("peopleid", bnJ());
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put("uploadtime", Long.valueOf(this.kdO));
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("realname", bnK());
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("realnamepyinitial", bnL());
        }
        if ((this.cSx & 64) != 0) {
            contentValues.put("realnamequanpin", bnM());
        }
        if ((this.cSx & 128) != 0) {
            contentValues.put(ch.COL_USERNAME, getUsername());
        }
        if ((this.cSx & 256) != 0) {
            contentValues.put("nickname", getNickName());
        }
        if ((this.cSx & 512) != 0) {
            contentValues.put("nicknamepyinitial", bnN());
        }
        if ((this.cSx & 1024) != 0) {
            contentValues.put("nicknamequanpin", bnO());
        }
        if ((this.cSx & 2048) != 0) {
            contentValues.put("type", Integer.valueOf(this.type));
        }
        if ((this.cSx & 4096) != 0) {
            contentValues.put("moblie", bnP());
        }
        if ((this.cSx & 8192) != 0) {
            contentValues.put(Scopes.EMAIL, getEmail());
        }
        if ((this.cSx & 16384) != 0) {
            int i2 = this.status;
            if (i2 == 0) {
                contentValues.put("status", (Integer) 65536);
            } else {
                contentValues.put("status", Integer.valueOf(i2));
            }
        }
        if ((this.cSx & 32768) != 0) {
            contentValues.put("reserved1", this.iKR);
        }
        if ((this.cSx & 131072) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.kdU));
        }
        if ((this.cSx & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.iKU));
        }
        if ((this.cSx & 524288) != 0) {
            this.kdV = bnI();
            contentValues.put("lvbuf", this.kdV);
        }
        if ((this.cSx & 1048576) != 0) {
            contentValues.put("showhead", Integer.valueOf(this.kdW));
        }
        AppMethodBeat.o(130969);
        return contentValues;
    }

    private byte[] bnI() {
        AppMethodBeat.i(130970);
        try {
            LVBuffer lVBuffer = new LVBuffer();
            lVBuffer.initBuild();
            lVBuffer.putString(this.kdX);
            lVBuffer.putInt(this.kdY);
            lVBuffer.putString(this.kdZ);
            lVBuffer.putString(this.kea);
            lVBuffer.putString(this.keb);
            lVBuffer.putInt(this.kec);
            lVBuffer.putString(this.ked);
            lVBuffer.putInt(this.kee);
            lVBuffer.putInt(this.kef);
            lVBuffer.putString(this.keg);
            lVBuffer.putString(this.keh);
            lVBuffer.putString(this.kei);
            lVBuffer.putInt(this.kej);
            lVBuffer.putString(this.kek);
            lVBuffer.putLong(this.kel);
            lVBuffer.putInt(this.kem);
            lVBuffer.putString(this.ken);
            lVBuffer.putString(this.keo);
            lVBuffer.putString(this.kep);
            lVBuffer.putLong(this.keq);
            byte[] buildFinish = lVBuffer.buildFinish();
            AppMethodBeat.o(130970);
            return buildFinish;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AddrUpload", e2, "", new Object[0]);
            AppMethodBeat.o(130970);
            return null;
        }
    }

    public static int SQ(String str) {
        int i2 = 0;
        AppMethodBeat.i(130971);
        try {
            i2 = Util.getHex("0x" + str.substring(0, 8), 0);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AddrUpload", e2, "md5: %s", str);
        }
        AppMethodBeat.o(130971);
        return i2;
    }

    public final void setMd5(String str) {
        AppMethodBeat.i(130972);
        this.md5 = str;
        this.id = SQ(str);
        AppMethodBeat.o(130972);
    }

    public final String getMd5() {
        return this.md5 == null ? "" : this.md5;
    }

    public final String bnJ() {
        return this.kdN == null ? "" : this.kdN;
    }

    public final String bnK() {
        return this.realName == null ? "" : this.realName;
    }

    public final String bnL() {
        return this.kdP == null ? "" : this.kdP;
    }

    public final String bnM() {
        return this.kdQ == null ? "" : this.kdQ;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String getNickName() {
        return this.nickName == null ? "" : this.nickName;
    }

    public final String bnN() {
        return this.kdR == null ? "" : this.kdR;
    }

    public final String bnO() {
        return this.kdS == null ? "" : this.kdS;
    }

    public final String bnP() {
        return this.kdT == null ? "" : this.kdT;
    }

    public final String getEmail() {
        return this.fuD == null ? "" : this.fuD;
    }

    public final void bnQ() {
        this.kdU |= 1;
    }

    public final boolean bnR() {
        return (this.kdU & 1) == 0;
    }

    public final int aqN() {
        AppMethodBeat.i(130973);
        char c2 = ' ';
        if (!Util.isNullOrNil(bnL())) {
            c2 = bnL().charAt(0);
        } else if (!Util.isNullOrNil(bnM())) {
            c2 = bnM().charAt(0);
        }
        if (c2 >= 'a' && c2 <= 'z') {
            c2 = (char) (c2 - ' ');
        } else if (c2 < 'A' || c2 > 'Z') {
            c2 = '{';
        }
        AppMethodBeat.o(130973);
        return c2;
    }
}
