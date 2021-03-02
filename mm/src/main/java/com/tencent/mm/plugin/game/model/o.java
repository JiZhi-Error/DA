package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class o extends dd {
    protected static IAutoDBItem.MAutoDBInfo info;
    public String mAppName = "";
    public String rfc = "";
    public long xEU = 0;
    private boolean xEV = false;
    public String xEW = "";
    public String xEX = "";
    public String xEY = "";
    public String xEZ = "";
    public boolean xEs = false;
    public String xFA = "";
    public String xFB = "";
    public String xFC = "";
    public String xFD = "";
    public String xFE;
    public String xFF;
    public String xFG;
    public String xFH;
    public String xFI;
    public i xFJ;
    public h xFK = new h();
    public j xFL = new j();
    public l xFM = new l();
    public d xFN = new d();
    public p xFO = new p();
    public C1405o xFP = new C1405o();
    public n xFQ = new n();
    public c xFR = new c();
    public m xFS = new m();
    public b xFT = new b();
    public int xFU;
    public int xFV;
    public String xFW;
    public String xFX;
    public String xFY;
    public int xFZ = 0;
    public String xFa = "";
    public int xFb = 0;
    public String xFc = "";
    public String xFd = "";
    public LinkedList<k> xFe = new LinkedList<>();
    public boolean xFf;
    public f xFg = new f();
    public boolean xFh;
    public e xFi = new e();
    public HashMap<String, g> xFj = new HashMap<>();
    public String xFk = "";
    public int xFl = 0;
    public int xFm = 0;
    public int xFn = 0;
    public String xFo = "";
    public String xFp = "";
    public String xFq = "";
    public int xFr = 0;
    public int xFs = 0;
    public long xFt = 0;
    public long xFu = 0;
    public int xFv = 0;
    public a xFw = new a();
    public String xFx = "";
    public String xFy = "";
    public String xFz = "";
    public String xGa = "";
    public boolean xGb = false;

    public static class b {
        public String xGd;
    }

    public static class c {
        public boolean dWA = false;
        public boolean xGe = false;
    }

    public static class e {
        public String mDesc;
        public String xGg;
        public String xGh;
    }

    public static class f {
        public int mIconHeight;
        public int mIconWidth;
        public String mText;
        public String xGg;
        public int xGi;
        public boolean xGj;
        public int xGk;
        public boolean xGl;
    }

    public static class g {
        public int mJumpType;
        public String rHJ;
    }

    public static class h {
        public String mContent;
        public String xGg;
        public String xGh;
    }

    public static class i {
        public String xGh;
        public String xGm;
        public String xGn;
        public String xGo;
    }

    public static class j {
        public boolean mClickable;
        public String mName;
        public String xGh;
    }

    public static class k {
        public String nickName;
        public String userName;
        public String xGp;
        public String xGq;
        public String xGr;
        public String xGs;
    }

    public static class l {
        public int pXp = 0;
        public String xGt;
        public long xGu = 0;
    }

    public static class m {
        public String xGv;
        public String xGw;
        public long xGx;
    }

    public static class n {
        public int xGA;
        public String xGB;
        public String xGC;
        public String xGD;
        public String xGE;
        public String xGF;
        public String xGG;
        public String xGH;
        public int xGI;
        public String xGJ;
        public String xGK;
        public String xGL;
        public String xGM;
        public String xGN;
        public String xGy;
        public int xGz;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.o$o  reason: collision with other inner class name */
    public static class C1405o {
        public Boolean eay = null;
        public String iGB;
        public int xGO = 0;
        public int xGP;
    }

    public static class p {
        public int xGQ;
    }

    public o() {
        AppMethodBeat.i(41452);
        AppMethodBeat.o(41452);
    }

    public static class a {
        public boolean crp;
        public int orientation;
        public String url;
        public List<String> xGc = new ArrayList();
        public boolean xvW;

        public a() {
            AppMethodBeat.i(41450);
            AppMethodBeat.o(41450);
        }
    }

    public static class d {
        public List<String> xGc = new ArrayList();
        public String xGf;

        public d() {
            AppMethodBeat.i(41451);
            AppMethodBeat.o(41451);
        }
    }

    public final void dVl() {
        AppMethodBeat.i(41453);
        if (this.xEV) {
            AppMethodBeat.o(41453);
            return;
        }
        if (this.field_msgType == 100) {
            u.dVC();
            u.a(this);
        } else {
            q.a(this);
        }
        q.b(this);
        this.xEV = true;
        AppMethodBeat.o(41453);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(41454);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[19];
        mAutoDBInfo.columns = new String[20];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
        sb.append(" msgId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "msgId";
        mAutoDBInfo.columns[1] = "mergerId";
        mAutoDBInfo.colsMap.put("mergerId", "TEXT");
        sb.append(" mergerId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "gameMsgId";
        mAutoDBInfo.colsMap.put("gameMsgId", "TEXT");
        sb.append(" gameMsgId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "msgType";
        mAutoDBInfo.colsMap.put("msgType", "INTEGER");
        sb.append(" msgType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
        sb.append(" createTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "expireTime";
        mAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
        sb.append(" expireTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "showInMsgList";
        mAutoDBInfo.colsMap.put("showInMsgList", "INTEGER default 'true' ");
        sb.append(" showInMsgList INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "isRead";
        mAutoDBInfo.colsMap.put("isRead", "INTEGER default 'false' ");
        sb.append(" isRead INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "label";
        mAutoDBInfo.colsMap.put("label", "TEXT default '' ");
        sb.append(" label TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "isHidden";
        mAutoDBInfo.colsMap.put("isHidden", "INTEGER default 'false' ");
        sb.append(" isHidden INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "weight";
        mAutoDBInfo.colsMap.put("weight", "TEXT default '' ");
        sb.append(" weight TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "rawXML";
        mAutoDBInfo.colsMap.put("rawXML", "TEXT default '' ");
        sb.append(" rawXML TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "receiveTime";
        mAutoDBInfo.colsMap.put("receiveTime", "LONG default '0' ");
        sb.append(" receiveTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "showType";
        mAutoDBInfo.colsMap.put("showType", "INTEGER default '0' ");
        sb.append(" showType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "interactiveMergeId";
        mAutoDBInfo.colsMap.put("interactiveMergeId", "TEXT default '' ");
        sb.append(" interactiveMergeId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "hasMergedCount";
        mAutoDBInfo.colsMap.put("hasMergedCount", "INTEGER default '1' ");
        sb.append(" hasMergedCount INTEGER default '1' ");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "redDotExpireTime";
        mAutoDBInfo.colsMap.put("redDotExpireTime", "LONG default '0' ");
        sb.append(" redDotExpireTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "needReport";
        mAutoDBInfo.colsMap.put("needReport", "INTEGER default 'false' ");
        sb.append(" needReport INTEGER default 'false' ");
        mAutoDBInfo.columns[19] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(41454);
    }
}
