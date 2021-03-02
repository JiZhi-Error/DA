package com.tencent.mm.msgsubscription.c;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u000523456B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\nH\u0002J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0006J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J&\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000eJ\u0016\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"J$\u0010#\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\nJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020'H\u0007J8\u0010(\u001a\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u001b\u001a\u00020\u000eH\u0007J\u0018\u0010+\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020,H\u0007J6\u0010-\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter;", "", "()V", "TAG", "", "TYPE_APP_BRAND", "", "TYPE_BIZ_SERVICE_BRAND", "lastShowReportTimestamp", "mInfoButtonClickCountList", "", "mInfoButtonClickIndexList", "mTemplateCount", "sessionId", "", "addInfoButtonClick", "", FirebaseAnalytics.b.INDEX, "buildInfoButtonClickInfoString", "Lkotlin/Pair;", "buildTemplateItemsJson", "subscribeMsgTmpItemList", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "createSession", "templateCount", "getUid", "bizUsername", AppMeasurement.Param.TIMESTAMP, "reportSubscribeAuthInBrandChat", "showType", "content", "reportSubscribeMsgDialogOp", "opType", "reportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "reportSubscribeMsgListOfProfile", "switchOpen", "", "reportSubscribeMsgOpInNotifyMessage", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgReportInfo;", "reportSubscribeMsgRequestDialogOp", "accType", "operationType", "reportSubscribeMsgSettingOp", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "reportSubscribeStatusOpInNotifyMessage", "templateId", "status", "templateName", "type", "ShowType", "SubscribeDialogReportInfo", "SubscribeMsgReportInfo", "SubscribeMsgSettingReportInfo", "SubscribeResultReportShowType", "plugin-comm_release"})
public final class a {
    private static List<Integer> jAn = new ArrayList();
    private static List<Integer> jAo = new ArrayList();
    private static int jAp;
    private static int jAq;
    public static final a jAr = new a();
    private static long sessionId = -1;

    static {
        AppMethodBeat.i(149597);
        AppMethodBeat.o(149597);
    }

    private a() {
    }

    public static void uq(int i2) {
        AppMethodBeat.i(149589);
        Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo createSession templateCount: %d", Integer.valueOf(i2));
        sessionId = System.currentTimeMillis();
        jAp = i2;
        jAn.clear();
        jAo.clear();
        if (i2 > 0) {
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(0);
            }
            jAo = arrayList;
        }
        AppMethodBeat.o(149589);
    }

    public static void ur(int i2) {
        AppMethodBeat.i(149590);
        if (i2 < jAp) {
            List<Integer> list = jAo;
            list.set(i2, Integer.valueOf(list.get(i2).intValue() + 1));
        }
        AppMethodBeat.o(149590);
    }

    public static void b(String str, boolean z, List<SubscribeMsgTmpItem> list) {
        int i2 = 0;
        AppMethodBeat.i(149593);
        p.h(str, "bizUsername");
        p.h(list, "subscribeMsgTmpItemList");
        Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile bizUsername: %s, switchOpen: %b, size: %d", str, Boolean.valueOf(z), Integer.valueOf(list.size()));
        JSONArray jSONArray = new JSONArray();
        for (T t : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scopeID", t.ixM);
            jSONObject.put("scopeName", t.title);
            jSONObject.put("selected", t.jyB == 1);
            jSONArray.put(jSONObject);
        }
        Log.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile json: %s", jSONArray.toString());
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (z) {
            i2 = 1;
        }
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = jSONArray.toString();
        hVar.a(17637, objArr);
        AppMethodBeat.o(149593);
    }

    public static void a(String str, int i2, String str2, int i3, String str3) {
        AppMethodBeat.i(149594);
        p.h(str, "bizUsername");
        p.h(str2, "templateId");
        p.h(str3, "templateName");
        Log.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeStatusOpInNotifyMessage bizUsername: %s, showType: %d, templateId: %s, status: %d, templateName: %s", str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3);
        h.INSTANCE.a(17638, str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3, 1);
        AppMethodBeat.o(149594);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0016j\b\u0012\u0004\u0012\u00020\u0004`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0016j\b\u0012\u0004\u0012\u00020\r`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006 "}, hxF = {"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "bizUsername", "getBizUsername", "setBizUsername", "keepSelected", "", "getKeepSelected", "()I", "setKeepSelected", "(I)V", "sessionId", "getSessionId", "setSessionId", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIdList", "()Ljava/util/ArrayList;", "setTemplateIdList", "(Ljava/util/ArrayList;)V", "templateOriginStatusList", "getTemplateOriginStatusList", "setTemplateOriginStatusList", "SubscribeDialogOpType", "plugin-comm_release"})
    /* renamed from: com.tencent.mm.msgsubscription.c.a$a  reason: collision with other inner class name */
    public static final class C0469a {
        String dVu = "";
        public ArrayList<Integer> jAs = new ArrayList<>();
        public int jAt;
        public ArrayList<String> jzS = new ArrayList<>();
        String jzY = "";
        String sessionId = "";

        public C0469a() {
            AppMethodBeat.i(223332);
            AppMethodBeat.o(223332);
        }

        public final void Rx(String str) {
            AppMethodBeat.i(223329);
            p.h(str, "<set-?>");
            this.dVu = str;
            AppMethodBeat.o(223329);
        }

        public final void Ry(String str) {
            AppMethodBeat.i(223330);
            p.h(str, "<set-?>");
            this.jzY = str;
            AppMethodBeat.o(223330);
        }

        public final void setSessionId(String str) {
            AppMethodBeat.i(223331);
            p.h(str, "<set-?>");
            this.sessionId = str;
            AppMethodBeat.o(223331);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003#$%B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\"R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006&"}, hxF = {"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgReportInfo;", "", "()V", "jumpInfo", "", "getJumpInfo", "()Ljava/lang/String;", "setJumpInfo", "(Ljava/lang/String;)V", "jumpType", "", "getJumpType", "()I", "setJumpType", "(I)V", "msgContent", "getMsgContent", "setMsgContent", "msgTitle", "getMsgTitle", "setMsgTitle", "templateId", "getTemplateId", "setTemplateId", "templateType", "getTemplateType", "setTemplateType", "type", "getType", "setType", ch.COL_USERNAME, "getUsername", "setUsername", "reset", "", "AccountType", "SubscribeMsgJumpType", "SubscribeMsgOpType", "plugin-comm_release"})
    public static final class b {
        public String dWG = "";
        public String ixM = "";
        public String jAu = "";
        public String jAv = "";
        public int jumpType;
        public int jyz;
        public int type;
        public String username = "";

        public final void setUsername(String str) {
            AppMethodBeat.i(223333);
            p.h(str, "<set-?>");
            this.username = str;
            AppMethodBeat.o(223333);
        }

        public final void setType(int i2) {
            this.type = i2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0016j\b\u0012\u0004\u0012\u00020\u0004`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0016j\b\u0012\u0004\u0012\u00020\n`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0016j\b\u0012\u0004\u0012\u00020\n`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR*\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0016j\b\u0012\u0004\u0012\u00020\u0004`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR*\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0016j\b\u0012\u0004\u0012\u00020\n`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00062"}, hxF = {"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "", "()V", "bizUsername", "", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", "(Ljava/lang/String;)V", "enterScene", "", "getEnterScene", "()I", "setEnterScene", "(I)V", "sessionId", "", "getSessionId", "()J", "setSessionId", "(J)V", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIdList", "()Ljava/util/ArrayList;", "setTemplateIdList", "(Ljava/util/ArrayList;)V", "templateOriginStatusList", "getTemplateOriginStatusList", "setTemplateOriginStatusList", "templateSelectedStatusList", "getTemplateSelectedStatusList", "setTemplateSelectedStatusList", "templateSize", "getTemplateSize", "setTemplateSize", "templateTitleList", "getTemplateTitleList", "setTemplateTitleList", "templateTypeList", "getTemplateTypeList", "setTemplateTypeList", "totalSwitch", "", "getTotalSwitch", "()Z", "setTotalSwitch", "(Z)V", "SubscribeMsgSettingOpType", "plugin-comm_release"})
    public static final class c {
        String dVu = "";
        public int enterScene;
        public ArrayList<Integer> jAA = new ArrayList<>();
        public ArrayList<Integer> jAs = new ArrayList<>();
        public boolean jAw;
        public int jAx;
        public ArrayList<Integer> jAy = new ArrayList<>();
        public ArrayList<String> jAz = new ArrayList<>();
        public ArrayList<String> jzS = new ArrayList<>();
        public long sessionId;

        public c() {
            AppMethodBeat.i(223335);
            AppMethodBeat.o(223335);
        }

        public final void Rx(String str) {
            AppMethodBeat.i(223334);
            p.h(str, "<set-?>");
            this.dVu = str;
            AppMethodBeat.o(223334);
        }
    }

    public static void a(int i2, C0469a aVar) {
        AppMethodBeat.i(223336);
        p.h(aVar, "reportInfo");
        if (i2 != 5) {
            h.INSTANCE.a(21802, aVar.dVu, aVar.sessionId, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), j.a(aVar.jzS, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62), j.a(aVar.jAs, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62), Integer.valueOf(aVar.jAt), aVar.jzY, 1);
            AppMethodBeat.o(223336);
            return;
        }
        h.INSTANCE.a(21802, aVar.dVu, aVar.sessionId, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), "", "", 0, aVar.jzY);
        AppMethodBeat.o(223336);
    }

    public static final void a(int i2, b bVar) {
        AppMethodBeat.i(223337);
        p.h(bVar, "reportInfo");
        Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgOpInNotifyMessage opType: %s, username: %s, jumpType: %s, jumpInfo: %s", Integer.valueOf(i2), bVar.username, Integer.valueOf(bVar.jumpType), bVar.jAv);
        if (i2 != 1 || jAq == 0 || System.currentTimeMillis() - ((long) jAq) > 1000) {
            h.INSTANCE.a(21811, bVar.username, bVar.ixM, Integer.valueOf(bVar.jyz), bVar.jAu, bVar.dWG, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(bVar.jumpType), bVar.jAv, Integer.valueOf(bVar.type));
            AppMethodBeat.o(223337);
            return;
        }
        AppMethodBeat.o(223337);
    }

    public static final void a(int i2, c cVar) {
        int i3;
        AppMethodBeat.i(223338);
        p.h(cVar, "reportInfo");
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[12];
        objArr[0] = cVar.dVu;
        objArr[1] = Long.valueOf(cVar.sessionId);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Long.valueOf(System.currentTimeMillis());
        if (cVar.jAw) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr[4] = Integer.valueOf(i3);
        objArr[5] = Integer.valueOf(cVar.jAx);
        objArr[6] = j.a(cVar.jzS, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        objArr[7] = j.a(cVar.jAs, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        objArr[8] = j.a(cVar.jAz, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        objArr[9] = j.a(cVar.jAy, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        objArr[10] = j.a(cVar.jAA, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        objArr[11] = Integer.valueOf(cVar.enterScene);
        hVar.a(21814, objArr);
        AppMethodBeat.o(223338);
    }

    public static void a(String str, int i2, String str2, long j2) {
        AppMethodBeat.i(149595);
        p.h(str, "bizUsername");
        p.h(str2, "content");
        h.INSTANCE.a(17639, z.aTY() + "#" + str + "#" + String.valueOf(j2), Integer.valueOf(i2), str2);
        AppMethodBeat.o(149595);
    }
}
