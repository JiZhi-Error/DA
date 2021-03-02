package com.tencent.mm.storage;

import android.util.Base64;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.an;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;
import java.lang.reflect.Field;
import org.json.JSONObject;

public final class z extends an {
    protected static IAutoDBItem.MAutoDBInfo info;
    public boolean NQj = false;
    public boolean NQk = false;
    public boolean NQl = false;
    public int NQm = -1;
    public ege NQn = null;
    x NQo = null;
    private String NQp = "";
    private JSONObject NQq = null;
    public dkr NQr = null;
    private String aid = "";
    public int dDG = 0;
    private String id = null;
    private String kZe = "";
    private String pathType = "";
    public boolean pvs = false;
    public int pxD = -1;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final long gAo() {
        return (this.field_orderFlag & -4294967296L) >> 32;
    }

    public final long gAp() {
        return (this.field_orderFlag & 4278190080L) >> 24;
    }

    public final String getId() {
        AppMethodBeat.i(212325);
        if (this.id != null) {
            String str = this.id;
            AppMethodBeat.o(212325);
            return str;
        }
        if (gAs()) {
            this.id = "recFeed:" + this.field_orderFlag;
        } else if (gAr()) {
            this.id = "newMsgLine";
        } else {
            this.id = "msg:" + this.field_orderFlag;
        }
        String str2 = this.id;
        AppMethodBeat.o(212325);
        return str2;
    }

    public final boolean gAq() {
        return this.dDG == 0;
    }

    public final boolean gAr() {
        return this.dDG == 1;
    }

    public final boolean gAs() {
        return this.dDG == 2;
    }

    public final boolean gAt() {
        return this.field_type == 285212721;
    }

    public final boolean gAu() {
        return this.field_type == 620757041;
    }

    public final boolean gAv() {
        return this.field_type == 637534257;
    }

    public final boolean gAw() {
        return this.field_type == 10100;
    }

    public final boolean gAx() {
        return this.field_type == 318767153;
    }

    public final boolean gAy() {
        return this.field_type == 34;
    }

    public final boolean gAz() {
        switch (this.field_type) {
            case 3:
            case 13:
            case 23:
            case 33:
            case 39:
                return true;
            default:
                return false;
        }
    }

    public final boolean isText() {
        switch (this.field_type) {
            case 1:
            case 11:
            case 21:
            case 31:
            case 36:
                return true;
            default:
                return false;
        }
    }

    public final boolean gAA() {
        AppMethodBeat.i(124603);
        if (gAo() == 1) {
            AppMethodBeat.o(124603);
            return true;
        }
        AppMethodBeat.o(124603);
        return false;
    }

    public final x gAB() {
        AppMethodBeat.i(212326);
        if (this.NQo != null) {
            x xVar = this.NQo;
            AppMethodBeat.o(212326);
            return xVar;
        }
        b bVar = b.pfn;
        this.NQo = b.ahh(this.field_content);
        x xVar2 = this.NQo;
        AppMethodBeat.o(212326);
        return xVar2;
    }

    public final efz gAC() {
        AppMethodBeat.i(124604);
        ege gAD = gAD();
        if (gAD == null) {
            AppMethodBeat.o(124604);
            return null;
        }
        efz efz = gAD.NfY;
        AppMethodBeat.o(124604);
        return efz;
    }

    public final void c(ege ege) {
        AppMethodBeat.i(124606);
        this.NQn = ege;
        byte[] d2 = d(ege);
        if (d2 == null) {
            AppMethodBeat.o(124606);
            return;
        }
        this.field_content = Base64.encodeToString(d2, 0);
        this.fqL = null;
        this.fqk = true;
        AppMethodBeat.o(124606);
    }

    private static byte[] d(ege ege) {
        byte[] bArr = null;
        AppMethodBeat.i(124607);
        if (ege == null) {
            AppMethodBeat.o(124607);
        } else {
            try {
                bArr = ege.toByteArray();
                AppMethodBeat.o(124607);
            } catch (IOException e2) {
                Log.w("MicroMsg.BizTimeLineInfo", "getTLRecCardBytes toByteArray ex %s", e2.getMessage());
                AppMethodBeat.o(124607);
            }
        }
        return bArr;
    }

    public final String acx() {
        AppMethodBeat.i(212327);
        if (!gAv()) {
            AppMethodBeat.o(212327);
            return null;
        } else if (!Util.isNullOrNil(this.NQp)) {
            String str = this.NQp;
            AppMethodBeat.o(212327);
            return str;
        } else {
            JSONObject gAE = gAE();
            if (gAE != null) {
                this.NQp = gAE.toString();
            }
            String str2 = this.NQp;
            AppMethodBeat.o(212327);
            return str2;
        }
    }

    public final JSONObject gAE() {
        AppMethodBeat.i(212328);
        if (!gAv()) {
            AppMethodBeat.o(212328);
            return null;
        } else if (this.NQq != null) {
            JSONObject jSONObject = this.NQq;
            AppMethodBeat.o(212328);
            return jSONObject;
        } else {
            r rVar = r.NPl;
            this.NQq = r.biI(this.field_content);
            JSONObject jSONObject2 = this.NQq;
            AppMethodBeat.o(212328);
            return jSONObject2;
        }
    }

    public final void gAF() {
        AppMethodBeat.i(212329);
        this.NQq = null;
        this.aid = "";
        gAI();
        AppMethodBeat.o(212329);
    }

    public final String gAG() {
        AppMethodBeat.i(212330);
        if (!Util.isNullOrNil(this.aid)) {
            String str = this.aid;
            AppMethodBeat.o(212330);
            return str;
        }
        gAI();
        String str2 = this.aid;
        AppMethodBeat.o(212330);
        return str2;
    }

    public final boolean gAH() {
        AppMethodBeat.i(212331);
        if (Util.isNullOrNil(gAG())) {
            AppMethodBeat.o(212331);
            return false;
        } else if (this.NQq == null) {
            AppMethodBeat.o(212331);
            return false;
        } else if (!Util.isNullOrNil(this.NQq.optString("video_info"))) {
            AppMethodBeat.o(212331);
            return true;
        } else {
            AppMethodBeat.o(212331);
            return false;
        }
    }

    public final String getPathType() {
        AppMethodBeat.i(212332);
        if (!Util.isNullOrNil(this.pathType)) {
            String str = this.pathType;
            AppMethodBeat.o(212332);
            return str;
        }
        gAI();
        String str2 = this.pathType;
        AppMethodBeat.o(212332);
        return str2;
    }

    public final String getTraceId() {
        AppMethodBeat.i(212333);
        if (!Util.isNullOrNil(this.kZe)) {
            String str = this.kZe;
            AppMethodBeat.o(212333);
            return str;
        }
        gAI();
        String str2 = this.kZe;
        AppMethodBeat.o(212333);
        return str2;
    }

    private void gAI() {
        AppMethodBeat.i(212334);
        JSONObject gAE = gAE();
        if (gAE == null || !Util.isNullOrNil(this.aid)) {
            AppMethodBeat.o(212334);
            return;
        }
        try {
            this.aid = gAE.optString("aid");
            this.kZe = gAE.optString("traceid");
            this.pathType = gAE.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, "ad");
            AppMethodBeat.o(212334);
        } catch (Exception e2) {
            Log.w("MicroMsg.BizTimeLineInfo", "getAId ex %s", e2.getMessage());
            AppMethodBeat.o(212334);
        }
    }

    public final int gAJ() {
        AppMethodBeat.i(212335);
        if (!gAs() || this.NQr == null) {
            AppMethodBeat.o(212335);
            return -1;
        }
        int i2 = this.NQr.KUh;
        AppMethodBeat.o(212335);
        return i2;
    }

    public final boolean iE(int i2) {
        return (this.field_bitFlag & i2) != 0;
    }

    public final void iF(int i2) {
        this.field_bitFlag |= i2;
    }

    public final void gAK() {
        this.field_bitFlag &= -2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A[SYNTHETIC, Splitter:B:15:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.protocal.protobuf.ege gAD() {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.z.gAD():com.tencent.mm.protocal.protobuf.ege");
    }

    static {
        AppMethodBeat.i(124608);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[20];
        mAutoDBInfo.columns = new String[21];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
        sb.append(" msgId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "msgId";
        mAutoDBInfo.columns[1] = "msgSvrId";
        mAutoDBInfo.colsMap.put("msgSvrId", "LONG");
        sb.append(" msgSvrId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "talker";
        mAutoDBInfo.colsMap.put("talker", "TEXT");
        sb.append(" talker TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT default '' ");
        sb.append(" content TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "imgPath";
        mAutoDBInfo.colsMap.put("imgPath", "TEXT");
        sb.append(" imgPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "lvbuffer";
        mAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
        sb.append(" lvbuffer BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "talkerId";
        mAutoDBInfo.colsMap.put("talkerId", "INTEGER");
        sb.append(" talkerId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "isExpand";
        mAutoDBInfo.colsMap.put("isExpand", "INTEGER");
        sb.append(" isExpand INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "orderFlag";
        mAutoDBInfo.colsMap.put("orderFlag", "LONG default '0' ");
        sb.append(" orderFlag LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "hasShow";
        mAutoDBInfo.colsMap.put("hasShow", "INTEGER default '1' ");
        sb.append(" hasShow INTEGER default '1' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "placeTop";
        mAutoDBInfo.colsMap.put("placeTop", "INTEGER default '1' ");
        sb.append(" placeTop INTEGER default '1' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "appMsgStatInfoProto";
        mAutoDBInfo.colsMap.put("appMsgStatInfoProto", "BLOB");
        sb.append(" appMsgStatInfoProto BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "isRead";
        mAutoDBInfo.colsMap.put("isRead", "INTEGER default '0' ");
        sb.append(" isRead INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "bitFlag";
        mAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
        sb.append(" bitFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "bizClientMsgId";
        mAutoDBInfo.colsMap.put("bizClientMsgId", "TEXT default '' ");
        sb.append(" bizClientMsgId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "rankSessionId";
        mAutoDBInfo.colsMap.put("rankSessionId", "TEXT default '' ");
        sb.append(" rankSessionId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "recommendCardId";
        mAutoDBInfo.colsMap.put("recommendCardId", "TEXT default '' ");
        sb.append(" recommendCardId TEXT default '' ");
        mAutoDBInfo.columns[20] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(124608);
    }
}
