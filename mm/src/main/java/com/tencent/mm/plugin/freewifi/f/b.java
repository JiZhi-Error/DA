package com.tencent.mm.plugin.freewifi.f;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.freewifi.d.e;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
    static Pattern wQA = Pattern.compile("\"stageName\":\"(.+?)\"");
    private static volatile boolean wQy = true;
    static Pattern wQz = Pattern.compile("\"result\":(-?[0-9]+)");

    static {
        AppMethodBeat.i(24942);
        AppMethodBeat.o(24942);
    }

    public static void pl(final int i2) {
        AppMethodBeat.i(24940);
        j.dNr().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.f.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(24939);
                if (!b.wQy) {
                    AppMethodBeat.o(24939);
                    return;
                }
                if (i2 == 0) {
                    long currentTimeMillis = System.currentTimeMillis() - i.a.wMX.Fk("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS");
                    Log.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "mobile netowrk report interval between last time is : ".concat(String.valueOf(currentTimeMillis)));
                    if (currentTimeMillis < 0 || currentTimeMillis > Util.MILLSECONDS_OF_DAY) {
                        i.a.wMX.at("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS", System.currentTimeMillis());
                    } else {
                        Log.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "interval less than 24 hours. return.");
                        AppMethodBeat.o(24939);
                        return;
                    }
                }
                boolean unused = b.wQy = false;
                f dNp = j.dNp();
                m.a("FreeWifiLog", f.wQE, dNp, "MicroMsg.FreeWifi.FreeWifiLogStorage");
                Cursor rawQuery = dNp.rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
                LinkedList linkedList = new LinkedList();
                while (rawQuery != null && rawQuery.moveToNext()) {
                    bfl bfl = new bfl();
                    bfl.id = rawQuery.getString(0);
                    bfl.wPz = rawQuery.getInt(1);
                    bfl.LPd = rawQuery.getString(2);
                    bfl.LPe = rawQuery.getLong(3);
                    linkedList.add(bfl);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                String str = "ServerReportSimpleLog:" + b.aJ(linkedList);
                m.axP(str);
                Log.i("MicroMsg.FreeWifi.FreeWifiServerReporter", str);
                if (linkedList.size() > 0) {
                    new e(linkedList).c(new com.tencent.mm.ak.i() {
                        /* class com.tencent.mm.plugin.freewifi.f.b.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            LinkedList<bfl> dNB;
                            AppMethodBeat.i(24938);
                            try {
                                Log.i("MicroMsg.FreeWifi.FreeWifiServerReporter", "errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                if (m.gB(i2, i3) && (dNB = ((e) qVar).dNB()) != null && dNB.size() > 0) {
                                    f dNp = j.dNp();
                                    Iterator<bfl> it = dNB.iterator();
                                    while (it.hasNext()) {
                                        bfl next = it.next();
                                        String str2 = next.id;
                                        int i4 = next.dIZ;
                                        Log.i("MicroMsg.FreeWifi.FreeWifiServerReporter", "resp LinkedList<FreeWifiReport>. id=%s, errcode=%d", str2, Integer.valueOf(i4));
                                        if (!m.eP(str2) && i4 == 0) {
                                            Log.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "delete. id=%s", str2);
                                            com.tencent.mm.plugin.freewifi.g.e eVar = new com.tencent.mm.plugin.freewifi.g.e();
                                            eVar.field_id = str2;
                                            Log.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "delete ret".concat(String.valueOf(dNp.delete(eVar, new String[0]))));
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                Log.e("MicroMsg.FreeWifi.FreeWifiServerReporter", m.m(e2));
                            } finally {
                                boolean unused = b.wQy = true;
                                AppMethodBeat.o(24938);
                            }
                        }
                    });
                    AppMethodBeat.o(24939);
                    return;
                }
                boolean unused2 = b.wQy = true;
                AppMethodBeat.o(24939);
            }
        });
        AppMethodBeat.o(24940);
    }

    static String aJ(LinkedList<bfl> linkedList) {
        AppMethodBeat.i(24941);
        if (linkedList == null || linkedList.size() == 0) {
            AppMethodBeat.o(24941);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<bfl> it = linkedList.iterator();
        while (it.hasNext()) {
            bfl next = it.next();
            sb.append("|id=").append(m.axL(next.id)).append("|");
            String[] split = m.axL(next.LPd).split("\\},");
            for (String str : split) {
                Matcher matcher = wQA.matcher(str);
                String str2 = "";
                if (matcher.find()) {
                    str2 = matcher.group(1);
                }
                Matcher matcher2 = wQz.matcher(str);
                String str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                if (matcher2.find()) {
                    str3 = matcher2.group(1);
                }
                sb.append(k.axK(str2) + "=" + str3).append("|");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(24941);
        return sb2;
    }
}
