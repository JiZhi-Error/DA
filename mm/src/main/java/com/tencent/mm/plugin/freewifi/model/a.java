package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.freewifi.d.b;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    SparseArray<Long> wOv = new SparseArray<>();
    private g wOw = new g();

    public a() {
        AppMethodBeat.i(24761);
        AppMethodBeat.o(24761);
    }

    public final void a(String str, g.b bVar, int i2, Intent intent) {
        AppMethodBeat.i(24762);
        j.dNq().dMZ().post(new Runnable(str, intent, bVar, i2) {
            /* class com.tencent.mm.plugin.freewifi.model.g.AnonymousClass1 */
            final /* synthetic */ Intent val$intent;
            final /* synthetic */ int wNT;
            final /* synthetic */ b wOO;
            final /* synthetic */ String wOd;

            {
                this.wOd = r2;
                this.val$intent = r3;
                this.wOO = r4;
                this.wNT = r5;
            }

            public final void run() {
                AppMethodBeat.i(24801);
                int i2 = g.this.MAX_RETRY_COUNT;
                while (true) {
                    int i3 = i2 - 1;
                    if (i2 > 0) {
                        Log.i("MicroMsg.FreeWifi.FreeWifiNetwork", "now retry count = %d", Integer.valueOf(i3));
                        g.b(this.wOd, 1, this.val$intent);
                        String aqy = h.aqK().aqy();
                        Log.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from cinfig : %s", aqy);
                        if (Util.isNullOrNil(aqy)) {
                            Log.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from config failed, use the default url : %s", "http://10.1.0.6/redirect");
                            aqy = "http://10.1.0.6/redirect";
                        }
                        String axW = g.axW(aqy);
                        Log.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url : %s, %s", aqy, axW);
                        if (Util.isNullOrNil(axW)) {
                            Log.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url failed : %s, %s", aqy, axW);
                            try {
                                Thread.sleep(500);
                                i2 = i3;
                            } catch (Exception e2) {
                                i2 = i3;
                            }
                        } else {
                            String ht = g.ht(axW, "auth=");
                            Log.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauthmessage from location : %s, %s", ht, axW);
                            if (Util.isNullOrNil(ht)) {
                                Log.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauth message from location failed : %s", axW);
                                g.b(this.wOd, 3, this.val$intent);
                            }
                            if (this.wOO != null) {
                                this.wOO.dV(ht, this.wNT);
                            }
                            AppMethodBeat.o(24801);
                            return;
                        }
                    } else {
                        if (this.wOO != null) {
                            this.wOO.dV(null, this.wNT);
                        }
                        g.b(this.wOd, 3, this.val$intent);
                        AppMethodBeat.o(24801);
                        return;
                    }
                }
            }
        });
        AppMethodBeat.o(24762);
    }

    public final synchronized void dMW() {
        int hashCode;
        boolean z;
        int i2;
        AppMethodBeat.i(24764);
        Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "ap check for bar.");
        String dNf = d.dNf();
        Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "autuApAuth, get ssid is %s ", dNf);
        if (Util.isNullOrNil(dNf)) {
            AppMethodBeat.o(24764);
        } else if (j.dNn().axZ(dNf) != null) {
            AppMethodBeat.o(24764);
        } else {
            String dNb = d.dNb();
            Object[] objArr = new Object[3];
            objArr[0] = dNf;
            objArr[1] = dNb;
            if (dNb == null) {
                hashCode = 0;
            } else {
                hashCode = dNb.hashCode();
            }
            objArr[2] = Integer.valueOf(hashCode);
            Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi info is null, now try to check is the wechat wifi fromserver, ssid is : %s, mac is : %s, nowmac hashcode : %d", objArr);
            if (Util.isNullOrNil(dNb)) {
                AppMethodBeat.o(24764);
            } else {
                c aya = j.dNn().aya(dNf);
                Object[] objArr2 = new Object[2];
                objArr2[0] = dNb;
                objArr2[1] = aya == null ? "null free wifiinfo" : aya.field_mac;
                Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now mac is : %s, loacal mac is : %s", objArr2);
                if (aya != null) {
                    Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi is not null, expired time = %d", Long.valueOf(aya.field_expiredTime));
                    if (!dNb.equalsIgnoreCase(aya.field_mac) || aya.field_expiredTime - Util.nowSecond() < 0) {
                        Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has expierd time or mac has changed");
                        z = true;
                    }
                    z = false;
                } else if (this.wOv.indexOfKey(dNb.hashCode()) >= 0) {
                    long longValue = this.wOv.get(dNb.hashCode()).longValue();
                    Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has checked this mac, now time - last check time = %d", Long.valueOf(Util.nowMilliSecond() - longValue));
                    if (Util.nowMilliSecond() - longValue > 43200000) {
                        z = true;
                    }
                    z = false;
                } else {
                    Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has not checked this mac, try to check from server");
                    z = true;
                }
                Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "Should request bar from back end = %b", Boolean.valueOf(z));
                if (z) {
                    int dNc = d.dNc();
                    Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now should do ap check, rssi is :  %d, mac : %s, mac hashcode : %d", Integer.valueOf(dNc), dNb, Integer.valueOf(dNb.hashCode()));
                    if (System.currentTimeMillis() - i.a.wMX.Fk("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS") > ((long) (i.a.wMX.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7) * 24 * 60 * 60 * 1000))) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i.a.wMX.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1) {
                        i2 |= 2;
                    }
                    if (i.a.wMX.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0) == 1) {
                        i2 |= 4;
                    }
                    if (i.a.wMX.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0) == 1) {
                        i2 |= 8;
                    }
                    Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "features : ".concat(String.valueOf(i2)));
                    new b(dNb, dNf, dNc, i2).c(new com.tencent.mm.ak.i() {
                        /* class com.tencent.mm.plugin.freewifi.model.a.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(24760);
                            String str2 = ((b) qVar).mac;
                            if (m.eP(str2)) {
                                AppMethodBeat.o(24760);
                            } else if (i3 == -30011) {
                                a.this.wOv.put(str2.hashCode(), Long.valueOf(Util.nowMilliSecond()));
                                AppMethodBeat.o(24760);
                            } else {
                                a.this.wOv.remove(str2.hashCode());
                                AppMethodBeat.o(24760);
                            }
                        }
                    });
                }
                AppMethodBeat.o(24764);
            }
        }
    }

    public final void a(String str, String str2, Intent intent) {
        AppMethodBeat.i(24763);
        j.dNq().dMZ().post(new Runnable(str2, str, intent) {
            /* class com.tencent.mm.plugin.freewifi.model.g.AnonymousClass2 */
            final /* synthetic */ Intent val$intent;
            final /* synthetic */ String wOQ;
            final /* synthetic */ a wOR = null;
            final /* synthetic */ String wOd;

            {
                this.wOQ = r3;
                this.wOd = r4;
                this.val$intent = r5;
            }

            public final void run() {
                AppMethodBeat.i(24802);
                String axW = g.axW(this.wOQ);
                Log.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get redirect location from loginurl : %s, %s", axW, this.wOQ);
                if (!Util.isNullOrNil(axW)) {
                    String ht = g.ht(axW, "res=");
                    Log.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get connect result from location : %s, %s", ht, axW);
                    if (!Util.isNullOrNil(ht) && (ht.startsWith("success") || ht.startsWith("already"))) {
                        g.b(this.wOd, 2, this.val$intent);
                        j.dNn().ayb(this.wOd);
                        AppMethodBeat.o(24802);
                        return;
                    }
                }
                g.b(this.wOd, 3, this.val$intent);
                AppMethodBeat.o(24802);
            }
        });
        AppMethodBeat.o(24763);
    }
}
