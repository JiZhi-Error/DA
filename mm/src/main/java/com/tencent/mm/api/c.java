package com.tencent.mm.api;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.k;
import com.tencent.mm.g.c.al;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cr;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends al {
    public static int dhr = 1;
    public static int dhs = 0;
    public static int dht = 1;
    private static int dhw = 0;
    private static b dhx = null;
    public static IAutoDBItem.MAutoDBInfo info;
    private List<a> dhu;
    public b dhv;

    public static class a {
        public String description;
        public String dhy;
        public String title;
        public String url;
    }

    static {
        AppMethodBeat.i(116408);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[20];
        mAutoDBInfo.columns = new String[21];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT PRIMARY KEY ");
        sb.append(" username TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_USERNAME;
        mAutoDBInfo.columns[1] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "brandList";
        mAutoDBInfo.colsMap.put("brandList", "TEXT default '' ");
        sb.append(" brandList TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "brandListVersion";
        mAutoDBInfo.colsMap.put("brandListVersion", "TEXT");
        sb.append(" brandListVersion TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "brandListContent";
        mAutoDBInfo.colsMap.put("brandListContent", "TEXT");
        sb.append(" brandListContent TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "brandFlag";
        mAutoDBInfo.colsMap.put("brandFlag", "INTEGER");
        sb.append(" brandFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = IssueStorage.COLUMN_EXT_INFO;
        mAutoDBInfo.colsMap.put(IssueStorage.COLUMN_EXT_INFO, "TEXT");
        sb.append(" extInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "brandInfo";
        mAutoDBInfo.colsMap.put("brandInfo", "TEXT");
        sb.append(" brandInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "brandIconURL";
        mAutoDBInfo.colsMap.put("brandIconURL", "TEXT");
        sb.append(" brandIconURL TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "hadAlert";
        mAutoDBInfo.colsMap.put("hadAlert", "INTEGER");
        sb.append(" hadAlert INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "acceptType";
        mAutoDBInfo.colsMap.put("acceptType", "INTEGER default '0' ");
        sb.append(" acceptType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
        sb.append(" type INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
        sb.append(" status INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "enterpriseFather";
        mAutoDBInfo.colsMap.put("enterpriseFather", "TEXT");
        sb.append(" enterpriseFather TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "kfWorkerId";
        mAutoDBInfo.colsMap.put("kfWorkerId", "TEXT");
        sb.append(" kfWorkerId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "specialType";
        mAutoDBInfo.colsMap.put("specialType", "INTEGER");
        sb.append(" specialType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "attrSyncVersion";
        mAutoDBInfo.colsMap.put("attrSyncVersion", "TEXT");
        sb.append(" attrSyncVersion TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "incrementUpdateTime";
        mAutoDBInfo.colsMap.put("incrementUpdateTime", "LONG");
        sb.append(" incrementUpdateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "bitFlag";
        mAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
        sb.append(" bitFlag INTEGER default '0' ");
        mAutoDBInfo.columns[20] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(116408);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final b Uw() {
        AppMethodBeat.i(187529);
        b cG = cG(false);
        AppMethodBeat.o(187529);
        return cG;
    }

    public final b cG(boolean z) {
        AppMethodBeat.i(116389);
        if (this.dhv == null || z) {
            if (Util.isNullOrNil(this.field_extInfo) || dhw != this.field_extInfo.hashCode()) {
                if (!ab.Iv(this.field_username) || !WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()) {
                    b fp = b.fp(this.field_extInfo);
                    this.dhv = fp;
                    dhx = fp;
                } else {
                    b fp2 = b.fp(cr.c.aWN());
                    this.dhv = fp2;
                    dhx = fp2;
                }
                dhw = Util.nullAsNil(this.field_extInfo).hashCode();
            } else {
                this.dhv = dhx;
            }
        }
        b bVar = this.dhv;
        AppMethodBeat.o(116389);
        return bVar;
    }

    public final boolean Ux() {
        return (this.field_brandFlag & 1) == 0;
    }

    public final boolean Uy() {
        return (this.field_brandFlag & 4) != 0;
    }

    public final boolean Uz() {
        AppMethodBeat.i(116390);
        if (System.currentTimeMillis() - this.field_updateTime > Util.MILLSECONDS_OF_DAY) {
            AppMethodBeat.o(116390);
            return true;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        if (this.field_updateTime < instance.getTimeInMillis()) {
            AppMethodBeat.o(116390);
            return true;
        }
        AppMethodBeat.o(116390);
        return false;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem, com.tencent.mm.g.c.al
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(116405);
        super.convertFrom(cursor);
        AppMethodBeat.o(116405);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem, com.tencent.mm.g.c.al
    public final ContentValues convertTo() {
        AppMethodBeat.i(116406);
        ContentValues convertTo = super.convertTo();
        AppMethodBeat.o(116406);
        return convertTo;
    }

    public final List<a> UO() {
        AppMethodBeat.i(116407);
        if (this.dhu != null) {
            List<a> list = this.dhu;
            AppMethodBeat.o(116407);
            return list;
        }
        this.dhu = new LinkedList();
        if (this.field_brandInfo == null || this.field_brandInfo.length() == 0) {
            List<a> list2 = this.dhu;
            AppMethodBeat.o(116407);
            return list2;
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.field_brandInfo).optJSONArray("urls");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                a aVar = new a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                aVar.title = optJSONObject.optString("title");
                aVar.url = optJSONObject.optString("url");
                aVar.dhy = optJSONObject.optString("title_key");
                aVar.description = optJSONObject.optString("description");
                this.dhu.add(aVar);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.BizInfo", "exception:%s", Util.stackTraceToString(e2));
        }
        List<a> list3 = this.dhu;
        AppMethodBeat.o(116407);
        return list3;
    }

    public static class b {
        private boolean dhA = true;
        public boolean dhB = false;
        private boolean dhC = false;
        public boolean dhD = false;
        private String dhE;
        private String dhF;
        private List<g> dhG = null;
        private e dhH = null;
        private d dhI = null;
        private C0262c dhJ = null;
        private f dhK = null;
        C0262c.a dhL = null;
        private boolean dhM = false;
        public boolean dhN = false;
        int dhO;
        public boolean dhP = false;
        public int dhQ = 0;
        private String dhR;
        private C0261b dhS = null;
        private int dhT = 0;
        private int dhU = c.dhs;
        private String dhV;
        private boolean dhW = false;
        private int dhX;
        private h dhY;
        private String dhZ;
        public JSONObject dhz = null;
        private String dia;
        private boolean dib = false;
        public a dic;
        private List<WxaAttributes.WxaEntryInfo> did;
        private int serviceType = 0;

        public static class d {
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo> getWxaEntryInfoList() {
            /*
            // Method dump skipped, instructions count: 145
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.api.c.b.getWxaEntryInfoList():java.util.List");
        }

        public final boolean UP() {
            AppMethodBeat.i(116366);
            if (!(this.dhz == null || this.dhz.optJSONObject("WifiBizInfo") == null || this.dhz.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") != 1)) {
                this.dib = true;
            }
            boolean z = this.dib;
            AppMethodBeat.o(116366);
            return z;
        }

        public final boolean UQ() {
            AppMethodBeat.i(116367);
            if (this.dhz != null) {
                this.dhC = "1".equals(this.dhz.optString("IsShowMember"));
            }
            boolean z = this.dhC;
            AppMethodBeat.o(116367);
            return z;
        }

        public final boolean UR() {
            AppMethodBeat.i(116368);
            if (this.dhz != null) {
                this.dhU = Util.getInt(this.dhz.optString("NotifyManage"), c.dhs);
            }
            if (this.dhU == c.dhr) {
                AppMethodBeat.o(116368);
                return true;
            }
            AppMethodBeat.o(116368);
            return false;
        }

        public final String US() {
            AppMethodBeat.i(116369);
            if (this.dhz != null) {
                this.dhE = this.dhz.optString("VerifyContactPromptTitle");
            }
            String str = this.dhE;
            AppMethodBeat.o(116369);
            return str;
        }

        public final String UT() {
            AppMethodBeat.i(116370);
            if (this.dhz != null) {
                this.dhZ = this.dhz.optString("TrademarkUrl");
            }
            String str = this.dhZ;
            AppMethodBeat.o(116370);
            return str;
        }

        public final String UU() {
            AppMethodBeat.i(116371);
            if (this.dhz != null) {
                this.dia = this.dhz.optString("TrademarkName");
            }
            String str = this.dia;
            AppMethodBeat.o(116371);
            return str;
        }

        public final String UV() {
            AppMethodBeat.i(116372);
            if (this.dhz != null) {
                this.dhF = this.dhz.optString("ConferenceContactExpireTime");
            }
            String str = this.dhF;
            AppMethodBeat.o(116372);
            return str;
        }

        public final List<g> UW() {
            AppMethodBeat.i(116373);
            if (this.dhz != null && this.dhG == null) {
                this.dhG = g.d(this.dhz.optJSONArray("Privilege"));
            }
            List<g> list = this.dhG;
            AppMethodBeat.o(116373);
            return list;
        }

        public final int UX() {
            AppMethodBeat.i(116374);
            if (this.dhz != null) {
                this.dhT = this.dhz.optInt("InteractiveMode");
            }
            int i2 = this.dhT;
            AppMethodBeat.o(116374);
            return i2;
        }

        public final f UY() {
            AppMethodBeat.i(116375);
            if (this.dhz != null && this.dhK == null) {
                this.dhK = f.fv(this.dhz.optString("PayShowInfo"));
            }
            f fVar = this.dhK;
            AppMethodBeat.o(116375);
            return fVar;
        }

        public final C0261b UZ() {
            String optString;
            AppMethodBeat.i(116376);
            if (!(this.dhz == null || this.dhS != null || (optString = this.dhz.optString("HardwareBizInfo")) == null)) {
                this.dhS = C0261b.fr(optString);
            }
            C0261b bVar = this.dhS;
            AppMethodBeat.o(116376);
            return bVar;
        }

        public final e Va() {
            AppMethodBeat.i(116377);
            if (this.dhz != null && this.dhH == null) {
                this.dhH = e.fu(this.dhz.optString("VerifySource"));
            }
            e eVar = this.dhH;
            AppMethodBeat.o(116377);
            return eVar;
        }

        public final h Vb() {
            String optString;
            AppMethodBeat.i(116379);
            if (!(this.dhz == null || this.dhY != null || (optString = this.dhz.optString("RegisterSource")) == null)) {
                this.dhY = h.fw(optString);
            }
            h hVar = this.dhY;
            AppMethodBeat.o(116379);
            return hVar;
        }

        public final boolean UB() {
            boolean z = false;
            AppMethodBeat.i(116380);
            if (this.dhz != null) {
                if (Util.getInt(this.dhz.optString("ReportLocationType"), 0) > 0) {
                    z = true;
                }
                this.dhM = z;
            }
            boolean z2 = this.dhM;
            AppMethodBeat.o(116380);
            return z2;
        }

        public final boolean Vc() {
            boolean z = true;
            AppMethodBeat.i(116381);
            if (this.dhz != null) {
                if (Util.getInt(this.dhz.optString("IsTrademarkProtection"), 0) != 1) {
                    z = false;
                }
                this.dhW = z;
            }
            boolean z2 = this.dhW;
            AppMethodBeat.o(116381);
            return z2;
        }

        public final int getServiceType() {
            AppMethodBeat.i(116382);
            if (this.dhz != null) {
                this.serviceType = this.dhz.optInt("ServiceType", 0);
            }
            int i2 = this.serviceType;
            AppMethodBeat.o(116382);
            return i2;
        }

        public final String Vd() {
            AppMethodBeat.i(116383);
            if (this.dhz != null) {
                this.dhR = this.dhz.optString("SupportEmoticonLinkPrefix");
            }
            String str = this.dhR;
            AppMethodBeat.o(116383);
            return str;
        }

        public final C0262c Ve() {
            String optString;
            AppMethodBeat.i(116384);
            if (!(this.dhz == null || this.dhJ != null || (optString = this.dhz.optString("MMBizMenu")) == null)) {
                this.dhJ = C0262c.fs(optString);
            }
            C0262c cVar = this.dhJ;
            AppMethodBeat.o(116384);
            return cVar;
        }

        public final String Vf() {
            AppMethodBeat.i(116385);
            if (this.dhz != null) {
                this.dhV = this.dhz.optString("ServicePhone");
            }
            String str = this.dhV;
            AppMethodBeat.o(116385);
            return str;
        }

        private b() {
        }

        static b fp(String str) {
            AppMethodBeat.i(116387);
            b bVar = new b();
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(116387);
            } else {
                try {
                    System.currentTimeMillis();
                    bVar.dhz = new JSONObject(str);
                } catch (Exception e2) {
                    Log.e("MicroMsg.BizInfo", "exception:%s", Util.stackTraceToString(e2));
                }
                AppMethodBeat.o(116387);
            }
            return bVar;
        }

        public static class g {
            public String description;
            public String diz;
            public String iconUrl;

            public static List<g> d(JSONArray jSONArray) {
                AppMethodBeat.i(116363);
                LinkedList linkedList = new LinkedList();
                if (jSONArray == null) {
                    AppMethodBeat.o(116363);
                } else {
                    try {
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            g gVar = new g();
                            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                            gVar.iconUrl = optJSONObject.optString("icon");
                            gVar.description = optJSONObject.optString("description");
                            gVar.diz = optJSONObject.optString("description_key");
                            linkedList.add(gVar);
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.BizInfo", "exception:%s", Util.stackTraceToString(e2));
                    }
                    AppMethodBeat.o(116363);
                }
                return linkedList;
            }
        }

        public static class e {
            public int dip = 0;
            public String diq;
            public String dis;
            public String dit;
            public String diu;

            public static e fu(String str) {
                AppMethodBeat.i(116361);
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(116361);
                    return null;
                }
                Log.i("MicroMsg.BizInfo", "biz verify info is [%s]", str);
                e eVar = new e();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    eVar.dip = jSONObject.optInt("Type");
                    eVar.diq = jSONObject.optString("Description");
                    eVar.dis = jSONObject.optString("Name");
                    eVar.dit = jSONObject.optString("IntroUrl");
                    eVar.diu = jSONObject.optString("VerifySubTitle");
                } catch (Exception e2) {
                    Log.e("MicroMsg.BizInfo", "exception:%s", Util.stackTraceToString(e2));
                }
                Log.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", Integer.valueOf(eVar.dip), eVar.diq, eVar.dis, eVar.dit);
                AppMethodBeat.o(116361);
                return eVar;
            }
        }

        public static class a {
            public ArrayList<String> die;

            public static a fq(String str) {
                AppMethodBeat.i(116356);
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(116356);
                    return null;
                }
                a aVar = new a();
                Log.d("MicroMsg.BizInfo", "BizAcctTransferInfo is [%s]", str);
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("origin_name_list");
                    if (optJSONArray != null) {
                        aVar.die = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            aVar.die.add(optJSONArray.optString(i2));
                        }
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.BizInfo", "exception:%s", Util.stackTraceToString(e2));
                }
                AppMethodBeat.o(116356);
                return aVar;
            }
        }

        /* renamed from: com.tencent.mm.api.c$b$b  reason: collision with other inner class name */
        public static class C0261b {
            public int dif;
            public int dig;
            public int dih;

            public static C0261b fr(String str) {
                AppMethodBeat.i(116357);
                Log.i("MicroMsg.BizInfo", "HardwareBizInfo = ".concat(String.valueOf(str)));
                C0261b bVar = new C0261b();
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(116357);
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        bVar.dif = jSONObject.optInt("hardware_flag");
                        bVar.dig = jSONObject.optInt("connect_status_display_mode");
                        bVar.dih = jSONObject.optInt("special_internal_brand_type");
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.BizInfo", "exception:%s", Util.stackTraceToString(e2));
                    }
                    AppMethodBeat.o(116357);
                }
                return bVar;
            }

            public final boolean Vi() {
                return (this.dif & 1) > 0;
            }
        }

        public static class h {
            public String diA;
            public String diB;
            public boolean diC;
            public String diD;

            public static h fw(String str) {
                AppMethodBeat.i(116364);
                Log.i("MicroMsg.BizInfo", "RegisterSource = %s", str);
                h hVar = new h();
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(116364);
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        hVar.diA = jSONObject.optString("RegisterBody");
                        hVar.diB = jSONObject.optString("IntroUrl");
                        hVar.diC = jSONObject.optInt("IsClose", 0) == 1;
                        hVar.diD = jSONObject.optString("AboutBizUrl");
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", Util.stackTraceToString(e2));
                    }
                    AppMethodBeat.o(116364);
                }
                return hVar;
            }
        }

        /* renamed from: com.tencent.mm.api.c$b$c  reason: collision with other inner class name */
        public static class C0262c {
            public int dii;
            public List<k> dij = null;
            public int type;

            public static C0262c fs(String str) {
                AppMethodBeat.i(116359);
                Log.i("MicroMsg.BizInfo", "MenuInfo = ".concat(String.valueOf(str)));
                C0262c cVar = new C0262c();
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(116359);
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        cVar.dii = jSONObject.optInt("update_time");
                        cVar.type = jSONObject.optInt("type", 0);
                        cVar.dij = k.e(jSONObject.optJSONArray("button_list"));
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.BizInfo", "exception:%s", Util.stackTraceToString(e2));
                    }
                    AppMethodBeat.o(116359);
                }
                return cVar;
            }

            /* renamed from: com.tencent.mm.api.c$b$c$a */
            public static class a {
                public long appid = 0;
                public String dik;
                public String dil;
                public int dim;
                public String din;
                public String dio;

                public static a ft(String str) {
                    AppMethodBeat.i(116358);
                    Log.i("MicroMsg.BizInfo", "EnterpriseBizInfo = ".concat(String.valueOf(str)));
                    a aVar = new a();
                    if (str == null || str.length() <= 0) {
                        AppMethodBeat.o(116358);
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            aVar.dik = jSONObject.optString("belong");
                            aVar.dil = jSONObject.optString("freeze_wording");
                            aVar.dim = jSONObject.optInt("child_type");
                            aVar.din = jSONObject.optString("home_url");
                            String optString = jSONObject.optString("exattr");
                            if (Util.isNullOrNil(optString)) {
                                aVar.dio = null;
                            } else {
                                JSONObject jSONObject2 = new JSONObject(optString);
                                aVar.dio = jSONObject2.optString("chat_extension_url");
                                aVar.appid = jSONObject2.optLong("app_id");
                            }
                        } catch (JSONException e2) {
                            Log.e("MicroMsg.BizInfo", "exception:%s", Util.stackTraceToString(e2));
                        }
                        AppMethodBeat.o(116358);
                    }
                    return aVar;
                }
            }
        }

        public final C0262c.a Vh() {
            String optString;
            AppMethodBeat.i(116388);
            if (!(this.dhz == null || this.dhL != null || (optString = this.dhz.optString("EnterpriseBizInfo")) == null)) {
                this.dhL = C0262c.a.ft(optString);
            }
            C0262c.a aVar = this.dhL;
            AppMethodBeat.o(116388);
            return aVar;
        }

        public static class f {
            public int div;
            public String diw;
            public List<String> dix;
            public String diy;

            public static f fv(String str) {
                int length;
                AppMethodBeat.i(116362);
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(116362);
                    return null;
                }
                try {
                    f fVar = new f();
                    JSONObject jSONObject = new JSONObject(str);
                    fVar.div = jSONObject.optInt("reputation_level", -1);
                    fVar.diw = jSONObject.optString("scope_of_business");
                    fVar.diy = jSONObject.optString("guarantee_detail_h5_url");
                    JSONArray optJSONArray = jSONObject.optJSONArray("guarantee_info");
                    if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                        fVar.dix = new ArrayList();
                        for (int i2 = 0; i2 < length; i2++) {
                            String string = optJSONArray.getString(i2);
                            if (!Util.isNullOrNil(string)) {
                                fVar.dix.add(string);
                            }
                        }
                    }
                    AppMethodBeat.o(116362);
                    return fVar;
                } catch (Exception e2) {
                    Log.e("MicroMsg.BizInfo", "exception:%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(116362);
                    return null;
                }
            }
        }

        public final boolean Vg() {
            AppMethodBeat.i(116386);
            if (this.dhz != null) {
                this.dhX = this.dhz.optInt("FunctionFlag");
            }
            if ((this.dhX & c.dht) > 0) {
                AppMethodBeat.o(116386);
                return true;
            }
            AppMethodBeat.o(116386);
            return false;
        }
    }

    private boolean iE(int i2) {
        return (this.field_bitFlag & i2) != 0;
    }

    private void iF(int i2) {
        this.field_bitFlag |= i2;
    }

    public final void UA() {
        AppMethodBeat.i(116391);
        cG(false);
        b bVar = this.dhv;
        if (bVar.dhz != null) {
            bVar.dhO = bVar.dhz.optInt("ConnectorMsgType");
        }
        this.field_acceptType = bVar.dhO;
        this.field_type = cG(false).getServiceType();
        if (UH()) {
            iF(1);
            AppMethodBeat.o(116391);
            return;
        }
        this.field_bitFlag &= -2;
        AppMethodBeat.o(116391);
    }

    public final boolean UB() {
        AppMethodBeat.i(116392);
        cG(false);
        Log.i("MicroMsg.BizInfo", "is report location, user %s %B", this.field_username, Boolean.valueOf(this.dhv.UB()));
        boolean UB = this.dhv.UB();
        AppMethodBeat.o(116392);
        return UB;
    }

    public final boolean UC() {
        AppMethodBeat.i(116393);
        cG(false);
        if (this.field_type == 1) {
            AppMethodBeat.o(116393);
            return true;
        }
        AppMethodBeat.o(116393);
        return false;
    }

    public final boolean UD() {
        AppMethodBeat.i(116394);
        cG(false);
        if (this.field_type == 0) {
            AppMethodBeat.o(116394);
            return true;
        }
        AppMethodBeat.o(116394);
        return false;
    }

    public final boolean UE() {
        AppMethodBeat.i(116395);
        cG(false);
        if (this.field_type == 2 || this.field_type == 3) {
            AppMethodBeat.o(116395);
            return true;
        }
        AppMethodBeat.o(116395);
        return false;
    }

    public final boolean UF() {
        AppMethodBeat.i(116396);
        cG(false);
        if (this.field_type == 2) {
            AppMethodBeat.o(116396);
            return true;
        }
        AppMethodBeat.o(116396);
        return false;
    }

    public final boolean UG() {
        AppMethodBeat.i(116397);
        cG(false);
        if (this.field_type == 3) {
            AppMethodBeat.o(116397);
            return true;
        }
        AppMethodBeat.o(116397);
        return false;
    }

    public final boolean UH() {
        boolean z;
        AppMethodBeat.i(116398);
        cG(false);
        if (this.dhv == null || this.dhv.Vh() == null) {
            z = false;
        } else {
            boolean z2 = this.dhv.dhL.dim == 1;
            if (z2 && !iE(1)) {
                iF(1);
                ((p) g.af(p.class)).a(this);
            }
            if (z2) {
                Log.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", this.field_username);
            }
            z = z2;
        }
        AppMethodBeat.o(116398);
        return z;
    }

    public final boolean UI() {
        boolean z;
        AppMethodBeat.i(116399);
        cG(false);
        if (this.dhv == null || this.dhv.Vh() == null) {
            z = false;
        } else {
            boolean z2 = this.dhv.dhL.dim == 2;
            if (z2 && !iE(2)) {
                iF(2);
                ((p) g.af(p.class)).a(this);
            }
            if (z2) {
                Log.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", this.field_username);
            }
            z = z2;
        }
        AppMethodBeat.o(116399);
        return z;
    }

    public final String UJ() {
        b.C0262c.a Vh;
        AppMethodBeat.i(116400);
        cG(false);
        if (this.dhv == null || (Vh = this.dhv.Vh()) == null || Vh.din == null || Vh.din.isEmpty()) {
            AppMethodBeat.o(116400);
            return null;
        }
        String str = Vh.din;
        AppMethodBeat.o(116400);
        return str;
    }

    public final long UK() {
        b.C0262c.a Vh;
        AppMethodBeat.i(116401);
        cG(false);
        if (this.dhv == null || (Vh = this.dhv.Vh()) == null || Vh.appid == 0) {
            AppMethodBeat.o(116401);
            return 0;
        }
        long j2 = Vh.appid;
        AppMethodBeat.o(116401);
        return j2;
    }

    public final boolean UL() {
        AppMethodBeat.i(116402);
        cG(false);
        if (this.dhv == null) {
            Log.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
            AppMethodBeat.o(116402);
            return true;
        } else if (this.dhv.Vb() == null) {
            Log.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
            AppMethodBeat.o(116402);
            return true;
        } else if (!this.dhv.Vb().diC) {
            AppMethodBeat.o(116402);
            return true;
        } else {
            AppMethodBeat.o(116402);
            return false;
        }
    }

    public final String UM() {
        b.C0262c.a Vh;
        AppMethodBeat.i(116403);
        cG(false);
        if (this.dhv == null || (Vh = this.dhv.Vh()) == null) {
            AppMethodBeat.o(116403);
            return null;
        }
        String str = Vh.dio;
        AppMethodBeat.o(116403);
        return str;
    }

    public final String UN() {
        String str;
        AppMethodBeat.i(116404);
        try {
            str = cG(false).Vh().dik;
        } catch (NullPointerException e2) {
            str = "";
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.BizInfo", "check father: %s, %s", this.field_username, str);
        }
        AppMethodBeat.o(116404);
        return str;
    }
}
