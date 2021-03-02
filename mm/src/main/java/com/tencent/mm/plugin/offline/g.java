package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashSet;
import java.util.Map;

public final class g {
    public static int AIi = 5000;
    private static int AIj;
    private static int AIk = 5000;
    public static int AIl = 0;
    public static int AIm = 24;
    public static int AIn = 4;
    public static int AIo = 8;
    public static int AIp = 23;
    public static int AIq = 6;
    public static int AIr = 5;
    public static int AIs = 20;
    public static int AIt = com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT;
    public static int AIu = 20001;
    public static int AIv = 10001;
    public static int AIw;
    public static String TAG = "MicroMsg.OfflineGetMsgLogic";
    public i AIx = new i() {
        /* class com.tencent.mm.plugin.offline.g.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(66214);
            if ((qVar instanceof d) && i2 == 0 && i3 == 0) {
                d dVar = (d) qVar;
                int unused = g.AIw = dVar.AJl;
                if (g.AIw == 0) {
                    int unused2 = g.AIw = g.AIk;
                }
                Log.i(g.TAG, "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", dVar.AJm, dVar.AJk);
                if (Util.isNullOrNil(dVar.AJk) || Util.isNullOrNil(dVar.AJm)) {
                    Log.i(g.TAG, "OfflineGetMsgLogic msg is null");
                } else if (g.ji(dVar.AJm, dVar.AJk)) {
                    Log.i(g.TAG, "from cgi");
                    if (XmlParser.parseXml(dVar.AJk, "sysmsg", null) == null) {
                        AppMethodBeat.o(66214);
                        return;
                    }
                    h.INSTANCE.idkeyStat(135, 71, 1, true);
                    k.ezn();
                    s ezo = k.ezo();
                    String str2 = dVar.AJk;
                    Log.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
                    if (!TextUtils.isEmpty(str2)) {
                        int i4 = -1;
                        Map<String, String> parseXml = XmlParser.parseXml(str2, "sysmsg", null);
                        if (parseXml != null) {
                            parseXml.get(".sysmsg.paymsg.ack_key");
                            i4 = Util.getInt(parseXml.get(".sysmsg.paymsg.PayMsgType"), -1);
                        }
                        if (!(!a.eAL() || i4 == 7 || i4 == 10)) {
                            Log.i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
                            ezo.aJc(str2);
                            ezo.aJd(str2);
                        }
                    }
                }
                Log.i(g.TAG, "mIntercal=" + g.AIw);
                g.this.AIz.startTimer((long) g.AIw);
            }
            AppMethodBeat.o(66214);
        }
    };
    public boolean AIy = true;
    public MTimerHandler AIz = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.offline.g.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(66215);
            if (g.this.AIz != null) {
                if (!com.tencent.mm.kernel.g.aAc()) {
                    g.this.AIz.startTimer((long) g.AIi);
                    AppMethodBeat.o(66215);
                    return false;
                } else if (a.eAL() && a.eAj()) {
                    g.ezk();
                }
            }
            AppMethodBeat.o(66215);
            return false;
        }
    }, false);
    public int status = 0;

    static {
        int intValue;
        AppMethodBeat.i(66225);
        AIj = CommonUtils.MAX_TIMEOUT_MS;
        AIw = AIk;
        com.tencent.mm.kernel.g.aAi();
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, (Object) null);
        if (obj != null) {
            int intValue2 = ((Integer) obj).intValue();
            AIw = intValue2;
            if (intValue2 == 0) {
                AIw = AIk;
            }
        }
        com.tencent.mm.kernel.g.aAi();
        Object obj2 = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.BUSINESS_OFFLINE_GETMSG_MAX_POS_TIME_INT, (Object) 0);
        if (!(obj2 == null || (intValue = ((Integer) obj2).intValue()) == 0)) {
            AIj = intValue;
        }
        AppMethodBeat.o(66225);
    }

    public static int ezh() {
        return AIj;
    }

    public g() {
        AppMethodBeat.i(66216);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(385, this.AIx);
        AppMethodBeat.o(66216);
    }

    private static boolean a(r rVar) {
        boolean z = false;
        AppMethodBeat.i(66217);
        if (rVar != null) {
            Log.i(TAG, "isOrderClosed lastest status req_key=" + rVar.field_reqkey);
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(AIt));
        hashSet.add(Integer.valueOf(AIq));
        hashSet.add(Integer.valueOf(AIr));
        hashSet.add(Integer.valueOf(AIn));
        hashSet.add(-1);
        if (rVar == null || hashSet.contains(Integer.valueOf(rVar.field_status))) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("isOrderClosed true;status==null?");
            if (rVar == null) {
                z = true;
            }
            Log.i(str, sb.append(z).toString());
            if (rVar != null) {
                Log.i(TAG, "isOrderClosed status.field_status=" + rVar.field_status);
            }
            AppMethodBeat.o(66217);
            return true;
        }
        Log.i(TAG, "isOrderClosed false");
        if (rVar != null) {
            Log.i(TAG, "status=" + rVar.field_status + ";req_key=" + rVar.field_reqkey);
        } else {
            Log.i(TAG, "isOrderClosed status=null");
        }
        AppMethodBeat.o(66217);
        return false;
    }

    private static boolean hD(int i2, int i3) {
        AppMethodBeat.i(66219);
        Log.i(TAG, "checkStatus from=" + i2 + ";to=" + i3);
        if (i2 == i3) {
            AppMethodBeat.o(66219);
            return false;
        } else if (i2 == AIl) {
            AppMethodBeat.o(66219);
            return true;
        } else if (i2 == AIm) {
            if (i3 != AIm) {
                AppMethodBeat.o(66219);
                return true;
            }
            AppMethodBeat.o(66219);
            return false;
        } else if (i2 == AIq) {
            if (i3 == AIt) {
                AppMethodBeat.o(66219);
                return true;
            }
            AppMethodBeat.o(66219);
            return false;
        } else if (i2 == AIr) {
            if (i3 == AIt) {
                AppMethodBeat.o(66219);
                return true;
            }
            AppMethodBeat.o(66219);
            return false;
        } else if (i2 == AIn) {
            if (i3 == AIt) {
                AppMethodBeat.o(66219);
                return true;
            }
            AppMethodBeat.o(66219);
            return false;
        } else if (i2 == AIs) {
            if (i3 == AIt) {
                AppMethodBeat.o(66219);
                return true;
            }
            AppMethodBeat.o(66219);
            return false;
        } else if (i2 == AIo || i2 == AIp) {
            if (i3 == AIq || i3 == AIt) {
                AppMethodBeat.o(66219);
                return true;
            }
            AppMethodBeat.o(66219);
            return false;
        } else if (i2 != AIv) {
            AppMethodBeat.o(66219);
            return false;
        } else if (i3 == AIq || i3 == AIt) {
            AppMethodBeat.o(66219);
            return true;
        } else {
            AppMethodBeat.o(66219);
            return false;
        }
    }

    private static boolean a(r rVar, int i2) {
        AppMethodBeat.i(66220);
        if (i2 == AIn) {
            i2 = AIt;
        }
        boolean hD = hD(rVar.field_status, i2);
        Log.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", Boolean.valueOf(hD), Integer.valueOf(rVar.field_status), Integer.valueOf(i2));
        if (hD) {
            rVar.field_status = i2;
            k.ezn();
            k.ezr().c(rVar);
        }
        AppMethodBeat.o(66220);
        return hD;
    }

    public static void eY(String str, int i2) {
        AppMethodBeat.i(66221);
        if (!Util.isNullOrNil(str)) {
            k.ezn();
            r aJe = k.ezr().aJe(str);
            if (aJe != null) {
                a(aJe, i2);
                AppMethodBeat.o(66221);
                return;
            }
            r rVar = new r();
            rVar.field_reqkey = str;
            rVar.field_status = i2;
            k.ezn();
            k.ezr().c(rVar);
        }
        AppMethodBeat.o(66221);
    }

    public static void ezi() {
        AppMethodBeat.i(66222);
        Log.i(TAG, "endAllOldOrder");
        k.ezn();
        com.tencent.mm.plugin.offline.b.a ezr = k.ezr();
        Log.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", Integer.valueOf(ezr.ezv()), ezr.ezu());
        Cursor rawQuery = ezr.db.rawQuery(String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", "rowid", "OfflineOrderStatus", "rowid"), null, 2);
        long j2 = 0;
        if (rawQuery == null) {
            Log.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
        } else {
            rawQuery.moveToFirst();
            if (!rawQuery.isAfterLast() && rawQuery.getColumnCount() > 0) {
                j2 = rawQuery.getLong(0);
            }
            rawQuery.close();
        }
        if (j2 - 10 > 0) {
            String format = String.format("DELETE FROM %s WHERE %s < %d;", "OfflineOrderStatus", "rowid", Long.valueOf(j2 - 10));
            Log.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", Long.valueOf(j2), format);
            ezr.db.execSQL("OfflineOrderStatus", format);
        } else {
            Log.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", Long.valueOf(j2));
        }
        ezr.db.execSQL("OfflineOrderStatus", "UPDATE OfflineOrderStatus SET status=" + AIt + " where status!=" + AIt);
        AppMethodBeat.o(66222);
    }

    public final void stop() {
        AppMethodBeat.i(66223);
        if (a.eAL()) {
            Log.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.AIz.stopped());
            if (!this.AIz.stopped()) {
                h.INSTANCE.idkeyStat(135, 62, 1, true);
                this.AIz.stopTimer();
            }
        }
        AppMethodBeat.o(66223);
    }

    public static int ezj() {
        return AIw;
    }

    public static boolean ji(String str, String str2) {
        String str3;
        String str4;
        char c2;
        boolean z;
        Object[] objArr;
        Object[] objArr2;
        boolean z2;
        AppMethodBeat.i(66218);
        if (Util.isNullOrNil(str2)) {
            Log.i(TAG, "shouldDeal appmsg is null");
            z2 = false;
        } else {
            Map<String, String> parseXml = XmlParser.parseXml(str2, "sysmsg", null);
            String str5 = parseXml.get(".sysmsg.paymsg.req_key");
            int i2 = Util.getInt(parseXml.get(".sysmsg.paymsg.PayMsgType"), -1);
            k.ezn();
            r aJe = k.ezr().aJe(str5);
            k.ezn();
            r ezt = k.ezr().ezt();
            boolean a2 = a(ezt);
            if (aJe != null) {
                h.INSTANCE.idkeyStat(135, 63, 1, true);
            } else {
                h.INSTANCE.idkeyStat(135, 64, 1, true);
            }
            if (ezt != null) {
                str3 = TAG;
                str4 = "latestStatus: reqKey: %s, status:%d, isLatestClose: %b";
                Object[] objArr3 = new Object[3];
                objArr3[0] = ezt.field_reqkey;
                objArr3[1] = Integer.valueOf(ezt.field_status);
                c2 = 2;
                z = a2;
                objArr = objArr3;
                objArr2 = objArr3;
            } else {
                str3 = TAG;
                str4 = "latestStatus is null. isLatestClose: %b, localStatus is null ?: %b";
                Object[] objArr4 = new Object[2];
                objArr4[0] = Boolean.valueOf(a2);
                c2 = 1;
                if (aJe == null) {
                    z = true;
                    objArr = objArr4;
                    objArr2 = objArr4;
                } else {
                    z = false;
                    objArr = objArr4;
                    objArr2 = objArr4;
                }
            }
            objArr[c2] = Boolean.valueOf(z);
            Log.i(str3, str4, objArr2);
            if (aJe == null) {
                if (ezt == null) {
                    Log.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", str5, Integer.valueOf(i2));
                    z2 = true;
                } else if (a2) {
                    Log.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", str5, Integer.valueOf(i2), ezt.field_reqkey, Integer.valueOf(ezt.field_status));
                    z2 = true;
                } else {
                    Log.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", str5, Integer.valueOf(i2), ezt.field_reqkey, Integer.valueOf(ezt.field_status));
                    z2 = false;
                }
            } else if (a(aJe)) {
                Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", aJe.field_reqkey, Integer.valueOf(i2), Integer.valueOf(aJe.field_status));
                z2 = false;
            } else if (ezt == null) {
                Log.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", str5, Integer.valueOf(i2), Integer.valueOf(aJe.field_status));
                k.ezn();
                k.ezr().aJf(str5);
                z2 = false;
            } else {
                Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", str5, Integer.valueOf(i2), Integer.valueOf(aJe.field_status), ezt.field_reqkey, Integer.valueOf(ezt.field_status));
                if (aJe.field_reqkey.equals(ezt.field_reqkey)) {
                    if (hD(ezt.field_status, i2)) {
                        Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", str5, Integer.valueOf(i2), Integer.valueOf(aJe.field_status), ezt.field_reqkey, Integer.valueOf(ezt.field_status));
                        z2 = true;
                    } else {
                        Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", str5, Integer.valueOf(i2), Integer.valueOf(aJe.field_status), ezt.field_reqkey, Integer.valueOf(ezt.field_status));
                        if (ezt.field_status != i2) {
                            Log.i(TAG, "mark reqKey: %s as give up", str5);
                            k.ezn();
                            k.ezr().aJf(str5);
                        }
                        z2 = false;
                    }
                } else if (a2) {
                    Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", str5, Integer.valueOf(i2), Integer.valueOf(aJe.field_status), ezt.field_reqkey, Integer.valueOf(ezt.field_status));
                    z2 = true;
                } else {
                    Log.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", str5, Integer.valueOf(i2), Integer.valueOf(aJe.field_status), ezt.field_reqkey, Integer.valueOf(ezt.field_status));
                    k.ezn();
                    k.ezr().aJf(str5);
                    z2 = false;
                }
            }
        }
        if (z2) {
            k.ezn();
            r ezt2 = k.ezr().ezt();
            Map<String, String> parseXml2 = XmlParser.parseXml(str2, "sysmsg", null);
            int i3 = Util.getInt(parseXml2.get(".sysmsg.paymsg.PayMsgType"), -1);
            String str6 = parseXml2.get(".sysmsg.paymsg.req_key");
            if (i3 == 24) {
                h.INSTANCE.idkeyStat(135, 58, 1, true);
            } else if (i3 == 6) {
                h.INSTANCE.idkeyStat(135, 59, 1, true);
            } else if (i3 == 4 || i3 == 5 || i3 == 20) {
                h.INSTANCE.idkeyStat(135, 60, 1, true);
            } else if (i3 == 23) {
                h.INSTANCE.idkeyStat(135, 66, 1, true);
            }
            if (ezt2 == null || ezt2.field_reqkey == null || !ezt2.field_reqkey.equals(str6)) {
                r rVar = new r();
                rVar.field_reqkey = str6;
                if (!Util.isNullOrNil(str)) {
                    rVar.field_ack_key = str;
                }
                rVar.field_status = AIl;
                a(rVar, i3);
            } else {
                a(ezt2, i3);
            }
            Log.i(TAG, "dealMsg true");
            AppMethodBeat.o(66218);
            return true;
        }
        Log.i(TAG, "dealMsg false");
        AppMethodBeat.o(66218);
        return false;
    }

    static /* synthetic */ void ezk() {
        AppMethodBeat.i(66224);
        Log.i(TAG, "doGetOfflineMsg doScene:NetSceneOfflineGetMsg");
        d dVar = new d();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(dVar, 0);
        AppMethodBeat.o(66224);
    }
}
