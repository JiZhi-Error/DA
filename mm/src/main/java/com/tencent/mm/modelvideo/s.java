package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.Map;

public final class s {
    public int cSx = -1;
    String clientId = "";
    public long createTime = 0;
    public int dRQ = 0;
    public long dTS = 0;
    public String dWq = "";
    public String ean = "";
    public String ebj = "";
    public String fileName = "";
    public int gqW = 0;
    public int iFw = 0;
    public int iKP = 0;
    public String jpP = "";
    public int jqP = 0;
    public long jqz = 0;
    private boolean jsA;
    private boolean jsB;
    public String jsh = "";
    public int jsj = 0;
    public int jsk = 0;
    public int jsl = 0;
    public long jsm = 0;
    public long jsn = 0;
    public int jso = 0;
    public int jsp = 0;
    public int jsq = 0;
    public int jsr = 0;
    public int jss = 0;
    public String jst = "";
    public int jsu = 0;
    public String jsv = "";
    public eeq jsw = new eeq();
    public cly jsx = new cly();
    int jsy;
    String jsz;
    public int status = 0;
    public int videoFormat = 0;

    public final String toString() {
        AppMethodBeat.i(126947);
        String str = "VideoInfo{fileName='" + this.fileName + '\'' + ", clientId='" + this.clientId + '\'' + ", msgSvrId=" + this.dTS + ", netOffset=" + this.jqP + ", fileNowSize=" + this.jsj + ", totalLen=" + this.iKP + ", thumbNetOffset=" + this.jsk + ", thumbLen=" + this.jsl + ", status=" + this.status + ", createTime=" + this.createTime + ", lastModifyTime=" + this.jsm + ", priorityTime=" + this.jsn + ", videoLength=" + this.iFw + ", msgLocalId=" + this.jso + ", netTimes=" + this.jsp + ", cameraType=" + this.jsq + ", user='" + this.dWq + '\'' + ", human='" + this.jsh + '\'' + ", isExport=" + this.jsr + ", isUseCdn=" + this.jss + ", importPath='" + this.jpP + '\'' + ", recvXml='" + this.jst + '\'' + ", videoFuncFlag=" + this.jsu + ", massSendId=" + this.jqz + ", massSendList='" + this.jsv + '\'' + ", videoMD5='" + this.ebj + '\'' + ", streamVideoProto=" + this.jsw + ", statextstr='" + this.ean + '\'' + ", downloadScene=" + this.gqW + ", mmSightExtInfo=" + this.jsx + ", preloadSize=" + this.dRQ + ", videoFormat=" + this.videoFormat + ", flag=" + this.cSx + '}';
        AppMethodBeat.o(126947);
        return str;
    }

    public s() {
        AppMethodBeat.i(126948);
        AppMethodBeat.o(126948);
    }

    public static String Qn(String str) {
        AppMethodBeat.i(126949);
        try {
            Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
            if (parseXml != null) {
                String str2 = parseXml.get(".msg.videomsg.$cdnvideourl");
                AppMethodBeat.o(126949);
                return str2;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(126949);
        return "";
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(126950);
        this.fileName = cursor.getString(0);
        this.clientId = cursor.getString(1);
        this.dTS = cursor.getLong(2);
        this.jqP = cursor.getInt(3);
        this.jsj = cursor.getInt(4);
        this.iKP = cursor.getInt(5);
        this.jsk = cursor.getInt(6);
        this.jsl = cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.createTime = cursor.getLong(9);
        this.jsm = cursor.getLong(10);
        this.jsn = cursor.getLong(11);
        this.iFw = cursor.getInt(12);
        this.jso = cursor.getInt(13);
        this.jsp = cursor.getInt(14);
        this.jsq = cursor.getInt(15);
        this.dWq = cursor.getString(16);
        this.jsh = cursor.getString(17);
        this.jsr = cursor.getInt(18);
        this.jss = cursor.getInt(19);
        this.jpP = cursor.getString(20);
        this.jst = cursor.getString(21);
        this.jsu = cursor.getInt(22);
        this.jqz = cursor.getLong(23);
        this.jsv = cursor.getString(24);
        this.ebj = cursor.getString(25);
        as(cursor.getBlob(26));
        this.ean = cursor.getString(27);
        this.gqW = cursor.getInt(28);
        at(cursor.getBlob(29));
        this.dRQ = cursor.getInt(30);
        this.videoFormat = cursor.getInt(31);
        this.jsy = cursor.getInt(32);
        this.jsz = cursor.getString(33);
        AppMethodBeat.o(126950);
    }

    public final ContentValues convertTo() {
        String str;
        AppMethodBeat.i(126951);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put("filename", getFileName());
        }
        if ((this.cSx & 2) != 0) {
            if (this.clientId == null) {
                str = "";
            } else {
                str = this.clientId;
            }
            contentValues.put("clientid", str);
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("msgsvrid", Long.valueOf(this.dTS));
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put("netoffset", Integer.valueOf(this.jqP));
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("filenowsize", Integer.valueOf(this.jsj));
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.iKP));
        }
        if ((this.cSx & 64) != 0) {
            contentValues.put("thumbnetoffset", Integer.valueOf(this.jsk));
        }
        if ((this.cSx & 128) != 0) {
            contentValues.put("thumblen", Integer.valueOf(this.jsl));
        }
        if ((this.cSx & 256) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.cSx & 512) != 0) {
            contentValues.put("createtime", Long.valueOf(this.createTime));
        }
        if ((this.cSx & 1024) != 0) {
            contentValues.put("lastmodifytime", Long.valueOf(this.jsm));
        }
        if ((this.cSx & 2048) != 0) {
            contentValues.put("downloadtime", Long.valueOf(this.jsn));
        }
        if ((this.cSx & 4096) != 0) {
            contentValues.put("videolength", Integer.valueOf(this.iFw));
        }
        if ((this.cSx & 8192) != 0) {
            contentValues.put("msglocalid", Integer.valueOf(this.jso));
        }
        if ((this.cSx & 16384) != 0) {
            contentValues.put("nettimes", Integer.valueOf(this.jsp));
        }
        if ((this.cSx & 32768) != 0) {
            contentValues.put("cameratype", Integer.valueOf(this.jsq));
        }
        if ((this.cSx & 65536) != 0) {
            contentValues.put("user", getUser());
        }
        if ((this.cSx & 131072) != 0) {
            contentValues.put("human", bhs());
        }
        if ((this.cSx & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.jsr));
        }
        if ((this.cSx & 524288) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.jss));
        }
        if ((this.cSx & 1048576) != 0) {
            contentValues.put("reserved3", bhu());
        }
        if ((this.cSx & TPMediaCodecProfileLevel.HEVCHighTierLevel6) != 0) {
            contentValues.put("reserved4", bhv());
        }
        if ((this.cSx & 4194304) != 0) {
            contentValues.put("videofuncflag", Integer.valueOf(this.jsu));
        }
        if ((this.cSx & TPMediaCodecProfileLevel.HEVCHighTierLevel61) != 0) {
            contentValues.put("masssendid", Long.valueOf(this.jqz));
        }
        if ((this.cSx & TPMediaCodecProfileLevel.HEVCMainTierLevel62) != 0) {
            contentValues.put("masssendlist", this.jsv);
        }
        if ((this.cSx & TPMediaCodecProfileLevel.HEVCHighTierLevel62) != 0) {
            contentValues.put("videomd5", this.ebj);
        }
        if ((this.cSx & 67108864) != 0) {
            contentValues.put("streamvideo", bht());
        }
        if ((this.cSx & 134217728) != 0) {
            contentValues.put("statextstr", this.ean);
        }
        if ((this.cSx & 268435456) != 0) {
            contentValues.put("downloadscene", Integer.valueOf(this.gqW));
        }
        if ((this.cSx & 536870912) != 0) {
            contentValues.put("mmsightextinfo", bhz());
        }
        if ((this.cSx & 1) != 0) {
            contentValues.put("preloadsize", Integer.valueOf(this.dRQ));
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("videoformat", Integer.valueOf(this.videoFormat));
        }
        if (this.jsA) {
            contentValues.put("forward_msg_local_id", Integer.valueOf(this.jsy));
        }
        if (this.jsB) {
            contentValues.put("msg_uuid", this.jsz);
        }
        AppMethodBeat.o(126951);
        return contentValues;
    }

    private byte[] bht() {
        AppMethodBeat.i(126952);
        byte[] bArr = new byte[0];
        try {
            bArr = this.jsw.toByteArray();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VideoInfo", e2, "", new Object[0]);
        }
        AppMethodBeat.o(126952);
        return bArr;
    }

    private void as(byte[] bArr) {
        AppMethodBeat.i(126953);
        this.jsw = new eeq();
        try {
            this.jsw.parseFrom(bArr);
            AppMethodBeat.o(126953);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VideoInfo", e2, "", new Object[0]);
            AppMethodBeat.o(126953);
        }
    }

    public final void a(String str, int i2, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(126954);
        if (this.jsw == null) {
            this.jsw = new eeq();
        }
        this.jsw.izb = str2;
        this.jsw.LxJ = i2;
        this.jsw.iyZ = str;
        this.jsw.izc = str3;
        this.jsw.izd = str4;
        this.jsw.izf = str5;
        this.jsw.izg = str6;
        AppMethodBeat.o(126954);
    }

    public final String getFileName() {
        return this.fileName == null ? "" : this.fileName;
    }

    public final int bcq() {
        return this.iKP;
    }

    public final String getUser() {
        return this.dWq == null ? "" : this.dWq;
    }

    public final String bhs() {
        return this.jsh == null ? "" : this.jsh;
    }

    public final String bhu() {
        return this.jpP == null ? "" : this.jpP;
    }

    public final String bhv() {
        return this.jst == null ? "" : this.jst;
    }

    public final boolean bhw() {
        if (this.status == 140 || this.status == 141 || this.status == 142) {
            return true;
        }
        return false;
    }

    public final boolean bhx() {
        if (this.status == 121 || this.status == 122 || this.status == 120 || this.status == 123) {
            return true;
        }
        return false;
    }

    public final boolean bhy() {
        if (this.status == 199 || this.status == 199) {
            return true;
        }
        return false;
    }

    private void at(byte[] bArr) {
        AppMethodBeat.i(126955);
        this.jsx = new cly();
        try {
            this.jsx.parseFrom(bArr);
            AppMethodBeat.o(126955);
        } catch (Exception e2) {
            AppMethodBeat.o(126955);
        }
    }

    private byte[] bhz() {
        AppMethodBeat.i(126956);
        byte[] bArr = new byte[0];
        try {
            bArr = this.jsx.toByteArray();
        } catch (Exception e2) {
        }
        AppMethodBeat.o(126956);
        return bArr;
    }

    public final void ue(int i2) {
        this.jsy = i2;
        this.jsA = true;
    }

    public final void Qo(String str) {
        this.jsz = str;
        this.jsB = true;
    }
}
