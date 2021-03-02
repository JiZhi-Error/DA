package com.tencent.mm.av;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class g {
    public int cSx = -2;
    public long dTS;
    public int fQW = 0;
    public int iKP;
    private boolean iXA;
    private boolean iXB;
    private boolean iXC;
    private boolean iXD;
    private boolean iXE;
    private boolean iXF;
    private boolean iXG;
    private boolean iXH;
    private boolean iXI;
    private boolean iXJ;
    private boolean iXK;
    private boolean iXL;
    private boolean iXM;
    private boolean iXN;
    private boolean iXO;
    private boolean iXP;
    private boolean iXQ;
    private boolean iXR;
    private boolean iXS;
    private boolean iXT;
    private boolean iXU;
    public String iXm = "";
    public String iXn = "";
    public String iXo = "";
    public int iXp;
    public int iXq;
    public String iXr = "";
    int iXs = 0;
    private String iXt = "";
    public int iXu;
    public long iXv;
    int iXw;
    public int iXx = 0;
    public String iXy = "";
    int iXz = 1;
    public long localId;
    public int offset;
    int source;
    public int status;

    public final void Op(String str) {
        this.iXt = str;
        this.iXQ = true;
    }

    public final void setStatus(int i2) {
        this.status = i2;
        this.iXJ = true;
    }

    public final void te(int i2) {
        this.iXw = i2;
        this.iXK = true;
    }

    public final void setCreateTime(int i2) {
        this.iXu = i2;
        this.iXH = true;
    }

    public final void Aw(long j2) {
        this.iXv = j2;
        this.iXI = true;
    }

    public final long getLocalId() {
        return this.localId;
    }

    public final void setLocalId(long j2) {
        this.localId = j2;
        this.iXA = true;
    }

    public final void yF(long j2) {
        if (this.dTS != j2) {
            this.iXB = true;
        }
        this.dTS = j2;
    }

    public final void setOffset(int i2) {
        int i3 = 0;
        AppMethodBeat.i(150550);
        if (this.offset != i2) {
            this.iXC = true;
        }
        this.offset = i2;
        Log.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", Integer.valueOf(i2), Long.valueOf(this.iXv), Integer.valueOf(this.iKP));
        if (i2 >= this.iKP) {
            i3 = 1;
        }
        tj(i3);
        AppMethodBeat.o(150550);
    }

    public final int bcq() {
        return this.iKP;
    }

    public final void tf(int i2) {
        this.iKP = i2;
        this.iXD = true;
    }

    public final String bcr() {
        return this.iXm;
    }

    public final void Oq(String str) {
        this.iXm = str;
        this.iXE = true;
    }

    public final String bcs() {
        return this.iXn;
    }

    public final void Or(String str) {
        this.iXn = str;
        this.iXF = true;
    }

    public final String bct() {
        return this.iXo;
    }

    public final void Os(String str) {
        this.iXo = str;
        this.iXG = true;
    }

    public final void tg(int i2) {
        this.iXx = i2;
        this.iXL = true;
    }

    public final void setSource(int i2) {
        this.source = i2;
        this.iXM = true;
    }

    public final void th(int i2) {
        this.iXq = i2;
        this.iXS = true;
    }

    public final boolean bcu() {
        return this.iKP != 0 && this.iKP == this.offset;
    }

    public final void Ot(String str) {
        AppMethodBeat.i(150551);
        if ((this.iXy == null && str != null) || (this.iXy != null && !this.iXy.equals(str))) {
            this.iXN = true;
        }
        this.iXy = str;
        AppMethodBeat.o(150551);
    }

    public final void bcw() {
        this.fQW = 1;
        this.iXO = true;
    }

    public final void Ou(String str) {
        this.iXr = str;
        this.iXT = true;
    }

    public final void ti(int i2) {
        this.iXs = i2;
        this.iXU = true;
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(150552);
        this.localId = (long) cursor.getInt(0);
        this.dTS = cursor.getLong(1);
        this.offset = cursor.getInt(2);
        this.iKP = cursor.getInt(3);
        this.iXm = cursor.getString(4);
        this.iXo = cursor.getString(5);
        this.iXu = cursor.getInt(6);
        this.iXv = (long) cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.iXw = cursor.getInt(9);
        this.iXx = cursor.getInt(10);
        this.source = cursor.getInt(11);
        this.iXy = cursor.getString(12);
        this.fQW = cursor.getInt(14);
        this.iXz = cursor.getInt(15);
        this.iXt = cursor.getString(16);
        this.iXp = cursor.getInt(17);
        this.iXn = cursor.getString(18);
        this.iXq = cursor.getInt(19);
        this.iXr = cursor.getString(20);
        this.iXs = cursor.getInt(21);
        AppMethodBeat.o(150552);
    }

    public final void tj(int i2) {
        if (this.iXz != i2) {
            this.iXP = true;
        }
        this.iXz = i2;
    }

    public final void tk(int i2) {
        this.iXp = i2;
        this.iXR = true;
    }

    public final ContentValues convertTo() {
        AppMethodBeat.i(150553);
        ContentValues contentValues = new ContentValues();
        if (this.iXA) {
            contentValues.put("id", Long.valueOf(this.localId));
        }
        if (this.iXB) {
            contentValues.put("msgSvrId", Long.valueOf(this.dTS));
        }
        if (this.iXC) {
            contentValues.put("offset", Integer.valueOf(this.offset));
        }
        if (this.iXD) {
            contentValues.put("totalLen", Integer.valueOf(this.iKP));
        }
        if (this.iXE) {
            contentValues.put("bigImgPath", this.iXm);
        }
        if (this.iXF) {
            contentValues.put("midImgPath", this.iXn);
        }
        if (this.iXG) {
            contentValues.put("thumbImgPath", this.iXo);
        }
        if (this.iXH) {
            contentValues.put("createtime", Integer.valueOf(this.iXu));
        }
        if (this.iXI) {
            contentValues.put("msglocalid", Long.valueOf(this.iXv));
        }
        if (this.iXJ) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if (this.iXK) {
            contentValues.put("nettimes", Integer.valueOf(this.iXw));
        }
        if (this.iXL) {
            contentValues.put("reserved1", Integer.valueOf(this.iXx));
        }
        if (this.iXM) {
            contentValues.put("reserved2", Integer.valueOf(this.source));
        }
        if (this.iXN) {
            contentValues.put("reserved3", this.iXy);
        }
        if (this.iXO) {
            contentValues.put("hashdthumb", Integer.valueOf(this.fQW));
        }
        if (this.iXP) {
            contentValues.put("iscomplete", Integer.valueOf(this.offset < this.iKP ? 0 : 1));
        }
        if (this.iXQ) {
            contentValues.put("origImgMD5", this.iXt);
        }
        if (this.iXR) {
            contentValues.put("compressType", Integer.valueOf(this.iXp));
        }
        if (this.iXS) {
            contentValues.put("forwardType", Integer.valueOf(this.iXq));
        }
        if (this.iXT) {
            contentValues.put("hevcPath", this.iXr);
        }
        if (this.iXU) {
            contentValues.put("sendImgType", Integer.valueOf(this.iXs));
        }
        AppMethodBeat.o(150553);
        return contentValues;
    }

    public final void bcx() {
        this.iXA = false;
        this.iXB = false;
        this.iXC = false;
        this.iXD = false;
        this.iXE = false;
        this.iXF = false;
        this.iXG = false;
        this.iXH = false;
        this.iXI = false;
        this.iXJ = false;
        this.iXK = false;
        this.iXL = false;
        this.iXM = false;
        this.iXN = false;
        this.iXO = false;
        this.iXP = false;
        this.iXQ = false;
        this.iXR = false;
        this.iXS = false;
        this.iXT = false;
        this.iXU = false;
    }

    public final boolean bcv() {
        return this.iXx > 0;
    }

    public final String getFileId() {
        AppMethodBeat.i(223573);
        int i2 = this.iXp;
        Map<String, String> parseXml = XmlParser.parseXml(this.iXy, "msg", null);
        if (parseXml == null) {
            AppMethodBeat.o(223573);
            return null;
        } else if (i2 != 1) {
            String str = parseXml.get(".msg.img.$cdnmidimgurl");
            AppMethodBeat.o(223573);
            return str;
        } else {
            String str2 = parseXml.get(".msg.img.$cdnbigimgurl");
            AppMethodBeat.o(223573);
            return str2;
        }
    }

    public final String getAesKey() {
        AppMethodBeat.i(223574);
        Map<String, String> parseXml = XmlParser.parseXml(this.iXy, "msg", null);
        if (parseXml != null) {
            String str = parseXml.get(".msg.img.$aeskey");
            AppMethodBeat.o(223574);
            return str;
        }
        AppMethodBeat.o(223574);
        return null;
    }
}
