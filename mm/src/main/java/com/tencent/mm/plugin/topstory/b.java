package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements e {
    eiq GiK;
    eiq GiL;
    LinkedList<eiq> GiM = new LinkedList<>();
    e.a GiN;
    q GiO = new q() {
        /* class com.tencent.mm.plugin.topstory.b.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x034d, code lost:
            r9.fxp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0352, code lost:
            if (r9.GiN == null) goto L_0x0391;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0354, code lost:
            r9.GiN.a(r9.GiM.size(), r9.GiM.getFirst().msgId, r9.GiM.getLast().msgId, r9.GiM.getFirst().jlm, r9.GiM.getLast().jlm, r9.GiM.getLast().extInfo);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0391, code lost:
            com.tencent.mm.sdk.event.EventCenter.instance.publish(new com.tencent.mm.g.a.ts());
            com.tencent.matrix.trace.core.AppMethodBeat.o(88417);
         */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x03c3  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x03ee  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0407  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0445  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0457  */
        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNewXmlReceived(java.lang.String r13, java.util.Map<java.lang.String, java.lang.String> r14, com.tencent.mm.ak.h.a r15) {
            /*
            // Method dump skipped, instructions count: 1552
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.b.AnonymousClass1.onNewXmlReceived(java.lang.String, java.util.Map, com.tencent.mm.ak.h$a):void");
        }
    };
    com.tencent.mm.plugin.topstory.a.c.b GiP;
    final String GiQ = "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}";
    String GiR = "";
    IListener<fp> GiS = new IListener<fp>() {
        /* class com.tencent.mm.plugin.topstory.b.AnonymousClass3 */

        {
            AppMethodBeat.i(160991);
            this.__eventId = fp.class.getName().hashCode();
            AppMethodBeat.o(160991);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(88419);
            b.this.GiR = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_topstory_top_tab_params, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
            AppMethodBeat.o(88419);
            return false;
        }
    };
    private i gNh = new i() {
        /* class com.tencent.mm.plugin.topstory.b.AnonymousClass2 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(88418);
            if (qVar.equals(b.this.GiP)) {
                g.azz().b(b.this.GiP.getType(), this);
                b.this.GiP = null;
                com.tencent.mm.plugin.topstory.a.c.b bVar = (com.tencent.mm.plugin.topstory.a.c.b) qVar;
                if (i2 == 0 && i3 == 0) {
                    g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_RED_DOT_RESULT_STRING, bVar.fxZ().MaZ);
                    g.aAh().azQ().gBI();
                    EventCenter.instance.publish(new ts());
                    AppMethodBeat.o(88418);
                    return;
                }
                Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
                AppMethodBeat.o(88418);
                return;
            }
            AppMethodBeat.o(88418);
        }
    };

    public b() {
        AppMethodBeat.i(88420);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.GiO);
        this.GiL = new eiq();
        a(this.GiL);
        eiq eiq = this.GiL;
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_TOP_STORY_RED_XML_REC_STRING, "");
        if (!Util.isNullOrNil(str)) {
            String[] split = str.split(",");
            if (split != null) {
                try {
                    if (split.length >= 13) {
                        a(eiq, split);
                    }
                } catch (Exception e2) {
                    g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_RED_XML_REC_STRING, "");
                    g.aAh().azQ().gBI();
                }
            }
            g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_RED_XML_REC_STRING, "");
            g.aAh().azQ().gBI();
        }
        this.GiK = new eiq();
        a(this.GiK);
        eiq eiq2 = this.GiK;
        String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_TOP_STORY_HOME_TAB_RED_XML_REC_STRING, "");
        if (!Util.isNullOrNil(str2)) {
            String[] split2 = str2.split(",");
            if (split2 != null) {
                try {
                    if (split2.length >= 13) {
                        a(eiq2, split2);
                    }
                } catch (Exception e3) {
                    g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_HOME_TAB_RED_XML_REC_STRING, "");
                    g.aAh().azQ().gBI();
                }
            }
            g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_HOME_TAB_RED_XML_REC_STRING, "");
            g.aAh().azQ().gBI();
        }
        fxs();
        EventCenter.instance.add(this.GiS);
        AppMethodBeat.o(88420);
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final boolean fxl() {
        boolean z;
        boolean z2;
        char c2;
        AppMethodBeat.i(201209);
        if (!fxJ()) {
            AppMethodBeat.o(201209);
            return false;
        }
        if (Util.isNullOrNil(this.GiL.msgId)) {
            c2 = 65531;
        } else if (this.GiL.NhP == 1) {
            c2 = 65535;
        } else if (this.GiL.IFo > d.KyO) {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", this.GiL.msgId, Integer.valueOf(this.GiL.IFo), Integer.valueOf(d.KyO));
            c2 = 65534;
        } else {
            if (this.GiL.jmW != 0) {
                if (System.currentTimeMillis() > this.GiL.NhQ + (this.GiL.jmW * 1000)) {
                    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", this.GiL.msgId);
                    c2 = 65533;
                }
            }
            Object[] objArr = new Object[5];
            if (ai.aft(1) >= this.GiL.IEj) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(this.GiL.IEj);
            objArr[2] = Integer.valueOf(ai.aft(1));
            objArr[3] = Long.valueOf(this.GiL.NhO);
            objArr[4] = Long.valueOf(fxz());
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d", objArr);
            if (ai.aft(1) < this.GiL.IEj || this.GiL.NhO <= fxz()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                c2 = 65532;
            } else {
                c2 = 0;
            }
        }
        if (c2 == 0) {
            if (fxI()) {
                AppMethodBeat.o(201209);
                return true;
            }
        } else if (c2 == 65533) {
            com.tencent.mm.plugin.websearch.api.ar.a(this.GiL, 104, 1, 0, 0, "");
            fxn();
        }
        AppMethodBeat.o(201209);
        return false;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final boolean fxm() {
        AppMethodBeat.i(88422);
        if (!fxJ()) {
            AppMethodBeat.o(88422);
            return false;
        } else if (this.GiM.getLast() == null) {
            AppMethodBeat.o(88422);
            return false;
        } else {
            AppMethodBeat.o(88422);
            return true;
        }
    }

    private void fxn() {
        AppMethodBeat.i(201210);
        this.GiL = new eiq();
        a(this.GiL);
        g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_RED_XML_REC_STRING, "");
        g.aAh().azQ().gBI();
        if (this.GiN != null) {
            e.a aVar = this.GiN;
            fxz();
            aVar.fxO();
        }
        AppMethodBeat.o(201210);
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final eiq fxo() {
        return this.GiL;
    }

    public final void N(long j2, boolean z) {
        AppMethodBeat.i(201211);
        if (this.GiL == null || Util.isNullOrNil(this.GiL.msgId)) {
            AppMethodBeat.o(201211);
            return;
        }
        long aWA = cl.aWA() / 1000;
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", Long.valueOf(j2), Long.valueOf(aWA));
        if (j2 < fxz() || j2 <= 0 || aWA + 3600 < j2) {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", Long.valueOf(fxz()));
            AppMethodBeat.o(201211);
        } else if (this.GiL == null || j2 >= this.GiL.NhO) {
            if (z) {
                com.tencent.mm.plugin.websearch.api.ar.a(this.GiL, 106, 1, 0, j2, "");
            }
            fxn();
            g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_REDDOT_TIMESTAMP_LONG, Long.valueOf(j2));
            g.aAh().azQ().gBI();
            AppMethodBeat.o(201211);
        } else {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", Long.valueOf(this.GiL.NhO));
            AppMethodBeat.o(201211);
        }
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final void KH(long j2) {
        AppMethodBeat.i(201212);
        N(j2, true);
        AppMethodBeat.o(201212);
    }

    /* access modifiers changed from: package-private */
    public final void fxp() {
        AppMethodBeat.i(88430);
        synchronized (this.GiM) {
            try {
                StringBuilder sb = new StringBuilder();
                Iterator<eiq> it = this.GiM.iterator();
                while (it.hasNext()) {
                    sb.append(b(it.next())).append(";");
                }
                g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_CMT_RED_XML_REC_STRING, sb.toString());
                g.aAh().azQ().gBI();
            } finally {
                AppMethodBeat.o(88430);
            }
        }
    }

    public final void fxq() {
        AppMethodBeat.i(88432);
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearHomeTabRedDot");
        this.GiK = new eiq();
        a(this.GiK);
        g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_HOME_TAB_RED_XML_REC_STRING, "");
        g.aAh().azQ().gBI();
        AppMethodBeat.o(88432);
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final eiq fxr() {
        return this.GiK;
    }

    static void a(eiq eiq) {
        eiq.icon = "";
        eiq.msgId = "";
        eiq.text = "";
    }

    public static String b(eiq eiq) {
        AppMethodBeat.i(88434);
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", eiq.msgId, Integer.valueOf(eiq.NhP), Integer.valueOf(eiq.IFo), Integer.valueOf(eiq.IFp), Integer.valueOf(eiq.IFn), Long.valueOf(eiq.jmW), Integer.valueOf(eiq.IEj), Long.valueOf(eiq.NhQ), eiq.text, Integer.valueOf(eiq.type), Integer.valueOf(eiq.showFlag), Long.valueOf(eiq.NhO), eiq.icon, Integer.valueOf(eiq.jlm), eiq.extInfo);
        AppMethodBeat.o(88434);
        return format;
    }

    private static void a(eiq eiq, String[] strArr) {
        AppMethodBeat.i(88435);
        eiq.msgId = strArr[0];
        eiq.NhP = Integer.valueOf(strArr[1]).intValue();
        eiq.IFo = Integer.valueOf(strArr[2]).intValue();
        eiq.IFp = Integer.valueOf(strArr[3]).intValue();
        eiq.IFn = Integer.valueOf(strArr[4]).intValue();
        eiq.jmW = Long.valueOf(strArr[5]).longValue();
        eiq.IEj = Integer.valueOf(strArr[6]).intValue();
        eiq.NhQ = Long.valueOf(strArr[7]).longValue();
        eiq.text = strArr[8];
        eiq.type = Integer.valueOf(strArr[9]).intValue();
        eiq.showFlag = Integer.valueOf(strArr[10]).intValue();
        eiq.NhO = Long.valueOf(strArr[11]).longValue();
        eiq.icon = strArr[12];
        if (strArr.length > 13) {
            eiq.jlm = Integer.valueOf(strArr[13]).intValue();
        } else {
            eiq.jlm = 0;
            if (eiq.type == 7) {
                Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
            }
        }
        if (strArr.length > 14) {
            eiq.extInfo = strArr[14];
            AppMethodBeat.o(88435);
            return;
        }
        eiq.extInfo = "";
        AppMethodBeat.o(88435);
    }

    private void fxs() {
        AppMethodBeat.i(88436);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_TOP_STORY_CMT_RED_XML_REC_STRING, "");
        if (!Util.isNullOrNil(str)) {
            String[] split = str.split(";");
            try {
                for (String str2 : split) {
                    if (!Util.isNullOrNil(str2)) {
                        String[] split2 = str2.split(",");
                        eiq eiq = new eiq();
                        a(eiq, split2);
                        this.GiM.addLast(eiq);
                    }
                }
                AppMethodBeat.o(88436);
                return;
            } catch (Exception e2) {
                g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_CMT_RED_XML_REC_STRING, "");
                g.aAh().azQ().gBI();
            }
        }
        AppMethodBeat.o(88436);
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final boolean fxt() {
        if (this.GiL != null) {
            return this.GiL.IFp == 1;
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final int fxu() {
        AppMethodBeat.i(88437);
        if (!fxJ()) {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", 0);
            AppMethodBeat.o(88437);
            return 0;
        }
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", Integer.valueOf(this.GiM.size()));
        int size = this.GiM.size();
        AppMethodBeat.o(88437);
        return size;
    }

    /* access modifiers changed from: package-private */
    public final int fxv() {
        AppMethodBeat.i(88438);
        if (!fxJ()) {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", 0);
            AppMethodBeat.o(88438);
            return 0;
        }
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", Integer.valueOf(this.GiM.size()));
        int size = this.GiM.size();
        AppMethodBeat.o(88438);
        return size;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final eiq fxw() {
        eiq last;
        AppMethodBeat.i(88439);
        synchronized (this.GiM) {
            try {
                if (Util.isNullOrNil(this.GiM)) {
                    last = null;
                } else {
                    last = this.GiM.getLast();
                    AppMethodBeat.o(88439);
                }
            } finally {
                AppMethodBeat.o(88439);
            }
        }
        return last;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final eiq fxx() {
        eiq first;
        AppMethodBeat.i(88440);
        synchronized (this.GiM) {
            try {
                if (Util.isNullOrNil(this.GiM)) {
                    first = null;
                } else {
                    first = this.GiM.getFirst();
                    AppMethodBeat.o(88440);
                }
            } finally {
                AppMethodBeat.o(88440);
            }
        }
        return first;
    }

    public final void a(long j2, boolean z, int i2, boolean z2) {
        String str;
        AppMethodBeat.i(88441);
        if (this.GiM.size() == 0) {
            AppMethodBeat.o(88441);
        } else if (i2 <= fxA()) {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", Integer.valueOf(i2), Integer.valueOf(fxA()));
            AppMethodBeat.o(88441);
        } else {
            int size = this.GiM.size();
            synchronized (this.GiM) {
                str = "";
                while (this.GiM.size() > 0 && this.GiM.getFirst().jlm <= i2) {
                    try {
                        String str2 = this.GiM.getFirst().msgId;
                        this.GiM.removeFirst();
                        str = str2;
                    } catch (Throwable th) {
                        AppMethodBeat.o(88441);
                        throw th;
                    }
                }
            }
            if (size != this.GiM.size()) {
                fxp();
            }
            if (this.GiN != null) {
                if (this.GiM.size() > 0) {
                    this.GiN.a(this.GiM.size(), this.GiM.getFirst().msgId, this.GiM.getLast().msgId, this.GiM.getFirst().jlm, this.GiM.getLast().jlm, this.GiM.getLast().extInfo, z);
                } else {
                    this.GiN.a(0, "", "", 0, 0, "", z);
                }
            }
            if (z2) {
                eiq eiq = new eiq();
                eiq.msgId = str;
                eiq.NhO = j2;
                eiq.jlm = i2;
                com.tencent.mm.plugin.websearch.api.ar.a(eiq, 106, 2, size, j2, "");
            }
            g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_CMTREDDOT_TIMESTAMP_LONG, Long.valueOf(j2));
            g.aAh().azQ().gBI();
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", Integer.valueOf(i2));
            g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_CMTREDDOT_SEQ_INT, Integer.valueOf(i2));
            g.aAh().azQ().gBI();
            AppMethodBeat.o(88441);
        }
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final void j(long j2, int i2, boolean z) {
        AppMethodBeat.i(88442);
        a(j2, z, i2, true);
        AppMethodBeat.o(88442);
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final boolean fxy() {
        AppMethodBeat.i(88443);
        if (Util.isNullOrNil(this.GiM)) {
            AppMethodBeat.o(88443);
            return false;
        } else if (this.GiM.getLast().IFp == 1) {
            AppMethodBeat.o(88443);
            return true;
        } else {
            AppMethodBeat.o(88443);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final void a(e.a aVar) {
        this.GiN = aVar;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final void b(e.a aVar) {
        if (this.GiN == aVar) {
            this.GiN = null;
        }
    }

    public static long fxz() {
        AppMethodBeat.i(88445);
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_TOP_STORY_REDDOT_TIMESTAMP_LONG, (Object) null);
        if (obj == null) {
            AppMethodBeat.o(88445);
            return 0;
        }
        long longValue = ((Long) obj).longValue();
        AppMethodBeat.o(88445);
        return longValue;
    }

    public static int fxA() {
        AppMethodBeat.i(88446);
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_TOP_STORY_CMTREDDOT_SEQ_INT, (Object) null);
        if (obj == null) {
            AppMethodBeat.o(88446);
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        AppMethodBeat.o(88446);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final void fxD() {
        AppMethodBeat.i(88449);
        eiq eiq = new eiq();
        eiq.msgId = this.GiK.msgId;
        com.tencent.mm.plugin.websearch.api.ar.a(eiq, 106, 3, 0, 0, "");
        fxq();
        AppMethodBeat.o(88449);
    }

    public final void p(String str, String str2, long j2) {
        AppMethodBeat.i(88450);
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", str, str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", str);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, str2);
            jSONObject.put("ts", j2);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryRedDotImpl", e2, "setUserIconRedDot error", new Object[0]);
        }
        g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, jSONObject.toString());
        g.aAh().azQ().gBI();
        if (!Util.isNullOrNil(str) && this.GiN != null) {
            this.GiN.bt(str, j2);
        }
        AppMethodBeat.o(88450);
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final String fxE() {
        AppMethodBeat.i(88451);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, "");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(88451);
            return "";
        }
        try {
            String optString = new JSONObject(str).optString("msgId", "");
            AppMethodBeat.o(88451);
            return optString;
        } catch (JSONException e2) {
            AppMethodBeat.o(88451);
            return "";
        }
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final long fxF() {
        AppMethodBeat.i(88452);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, "");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(88452);
            return 0;
        }
        try {
            long optInt = (long) new JSONObject(str).optInt("ts", 0);
            AppMethodBeat.o(88452);
            return optInt;
        } catch (JSONException e2) {
            AppMethodBeat.o(88452);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final String fxG() {
        AppMethodBeat.i(88453);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_TOP_STORY_USER_ICON_RED_XML_REC_STRING, "");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(88453);
            return "";
        }
        try {
            String optString = new JSONObject(str).optString(IssueStorage.COLUMN_EXT_INFO);
            AppMethodBeat.o(88453);
            return optString;
        } catch (JSONException e2) {
            AppMethodBeat.o(88453);
            return "";
        }
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final void fxH() {
        AppMethodBeat.i(88454);
        p("", "", 0);
        AppMethodBeat.o(88454);
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final boolean fxI() {
        AppMethodBeat.i(88455);
        long aUd = z.aUd();
        boolean z = (67108864 & aUd) == 0;
        boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
        boolean Pi = com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null));
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "isShowRecEntry %s %s %s %s", Long.valueOf(aUd), Boolean.valueOf(z), Boolean.valueOf(Vt), Boolean.valueOf(Pi));
        if (!z || Vt || Pi) {
            AppMethodBeat.o(88455);
            return false;
        }
        AppMethodBeat.o(88455);
        return true;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final boolean fxJ() {
        AppMethodBeat.i(88456);
        if ((d.KyO >= 654311424 || d.KyS) && Util.isNullOrNil(this.GiR)) {
            this.GiR = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_topstory_top_tab_params, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
        }
        try {
            JSONArray jSONArray = new JSONObject(this.GiR).getJSONArray("tabs");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.getJSONObject(i2).getInt("category") == 110) {
                    AppMethodBeat.o(88456);
                    return true;
                }
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.TopStory.TopStoryRedDotImpl", "parse tabconfig failed: %s", e2.getMessage());
        }
        AppMethodBeat.o(88456);
        return false;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final int abP(int i2) {
        AppMethodBeat.i(201213);
        if (fxu() > 0) {
            AppMethodBeat.o(201213);
            return 110;
        } else if (!fxl() || !fxB()) {
            if (fxl()) {
                AppMethodBeat.o(201213);
                return 110;
            } else if (fxB()) {
                AppMethodBeat.o(201213);
                return 100;
            } else {
                AppMethodBeat.o(201213);
                return i2;
            }
        } else if (this.GiK.priority > this.GiL.priority) {
            AppMethodBeat.o(201213);
            return 100;
        } else if (this.GiK.priority < this.GiL.priority) {
            AppMethodBeat.o(201213);
            return 110;
        } else if (this.GiK.NhQ > this.GiL.NhQ) {
            AppMethodBeat.o(201213);
            return 100;
        } else if (this.GiK.NhQ < this.GiL.NhQ) {
            AppMethodBeat.o(201213);
            return 110;
        } else {
            AppMethodBeat.o(201213);
            return i2;
        }
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final boolean fxK() {
        AppMethodBeat.i(201214);
        if (this.GiL.NhQ < g.aAh().azQ().a(ar.a.USERINFO_TOP_STORY_FIND_MORE_CLICK_TIMESTAMP_LONG, 0)) {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "canShowHaokanFindMoreEntryRedDot already click find more entry");
            AppMethodBeat.o(201214);
            return false;
        }
        AppMethodBeat.o(201214);
        return true;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final boolean fxL() {
        AppMethodBeat.i(201215);
        if (this.GiK.NhQ < g.aAh().azQ().a(ar.a.USERINFO_TOP_STORY_FIND_MORE_CLICK_TIMESTAMP_LONG, 0)) {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "canShowHomeFindMoreEntryRedDot already click find more entry");
            AppMethodBeat.o(201215);
            return false;
        }
        AppMethodBeat.o(201215);
        return true;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final void fxM() {
        AppMethodBeat.i(201216);
        g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_FIND_MORE_CLICK_TIMESTAMP_LONG, Long.valueOf(cl.aWA()));
        AppMethodBeat.o(201216);
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final void fxN() {
        AppMethodBeat.i(201217);
        if (fxu() > 0) {
            eiq fxw = fxw();
            if (fxw != null) {
                com.tencent.mm.plugin.websearch.api.ar.a(fxw.msgId, fxw.NhO, 2, fxu(), "", fxw.jlm);
            }
            AppMethodBeat.o(201217);
        } else if (!fxl() || !fxB()) {
            if (fxl()) {
                com.tencent.mm.plugin.websearch.api.ar.a(this.GiL.msgId, this.GiL.NhO, 1, 0, "", 0);
                AppMethodBeat.o(201217);
                return;
            }
            if (fxB()) {
                com.tencent.mm.plugin.websearch.api.ar.a(this.GiK.msgId, this.GiK.NhO, 1, 0, "", 0);
            }
            AppMethodBeat.o(201217);
        } else if (this.GiK.priority > this.GiL.priority) {
            com.tencent.mm.plugin.websearch.api.ar.a(this.GiK.msgId, this.GiK.NhO, 1, 0, "", 0);
            AppMethodBeat.o(201217);
        } else if (this.GiK.priority < this.GiL.priority) {
            com.tencent.mm.plugin.websearch.api.ar.a(this.GiL.msgId, this.GiL.NhO, 1, 0, "", 0);
            AppMethodBeat.o(201217);
        } else if (this.GiK.NhQ > this.GiL.NhQ) {
            com.tencent.mm.plugin.websearch.api.ar.a(this.GiK.msgId, this.GiK.NhO, 1, 0, "", 0);
            AppMethodBeat.o(201217);
        } else if (this.GiK.NhQ < this.GiL.NhQ) {
            com.tencent.mm.plugin.websearch.api.ar.a(this.GiL.msgId, this.GiL.NhO, 1, 0, "", 0);
            AppMethodBeat.o(201217);
        } else {
            com.tencent.mm.plugin.websearch.api.ar.a(this.GiL.msgId, this.GiL.NhO, 1, 0, "", 0);
            AppMethodBeat.o(201217);
        }
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final boolean fxB() {
        AppMethodBeat.i(88447);
        eiq eiq = this.GiK;
        if (!Util.isNullOrNil(eiq.msgId)) {
            if (System.currentTimeMillis() > eiq.NhQ + (eiq.jmW * 1000)) {
                Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", eiq.msgId);
                fxq();
                AppMethodBeat.o(88447);
                return false;
            }
            AppMethodBeat.o(88447);
            return true;
        }
        AppMethodBeat.o(88447);
        return false;
    }

    @Override // com.tencent.mm.plugin.topstory.a.e
    public final String fxC() {
        AppMethodBeat.i(88448);
        String str = this.GiK.msgId;
        AppMethodBeat.o(88448);
        return str;
    }

    static /* synthetic */ void c(eiq eiq) {
        AppMethodBeat.i(88457);
        if (!Util.isNullOrNil(eiq.extInfo)) {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateInitTab %s", eiq.extInfo);
            try {
                if (new JSONObject(eiq.extInfo).optBoolean("has_wow_contents", true)) {
                    g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_HAS_HAOKAN_RESULT_INT, (Object) 1);
                    AppMethodBeat.o(88457);
                    return;
                }
                g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_HAS_HAOKAN_RESULT_INT, (Object) 0);
                AppMethodBeat.o(88457);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(88457);
    }
}
