package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTaskForNative;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends l.b implements i {
    public static int DiS = 3;
    private int DgH = -1000;
    private d DiN;
    public Collection<a> DiO = null;
    private int DiP = 10001;
    private int DiQ = 10002;
    private int DiR = ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.shake.d.a.h.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(28289);
            if (!z) {
                AppMethodBeat.o(28289);
                return true;
            }
            h.this.gmu = f3;
            h.this.gmv = f2;
            h.this.DgH = (int) d3;
            AppMethodBeat.o(28289);
            return false;
        }
    };
    private float gmu = -85.0f;
    private float gmv = -1000.0f;
    private d iOv;

    public static final class a {
        public String DiU = "";
        public double DiV = 0.0d;
        public int DiW = 0;
        public double jiP = 0.0d;
        public int major = 0;
        public int minor = 0;
        public String uuid = null;
    }

    public h(l.a aVar) {
        super(aVar);
        AppMethodBeat.i(28293);
        AppMethodBeat.o(28293);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void init() {
        AppMethodBeat.i(28294);
        bg.azz().a(JsApiInstallDownloadTaskForNative.CTRL_INDEX, this);
        eTP();
        AppMethodBeat.o(28294);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void reset() {
        AppMethodBeat.i(28295);
        if (this.DiN != null) {
            bg.azz().a(this.DiN);
        }
        AppMethodBeat.o(28295);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void start() {
        int i2;
        boolean z;
        AppMethodBeat.i(28296);
        Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
        init();
        reset();
        if (this.iOv == null) {
            eTP();
        }
        this.iOv.b(this.gmA, true);
        if (!Build.VERSION.RELEASE.equals("6.0") && !Build.VERSION.RELEASE.equals("6.0.0") && Build.VERSION.SDK_INT >= 23) {
            LocationManager locationManager = (LocationManager) MMApplicationContext.getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
            if (locationManager != null) {
                z = locationManager.isProviderEnabled("gps");
            } else {
                z = true;
            }
            if (!z) {
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.shake.d.a.h.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(28290);
                        h.this.DgX.f(null, 8);
                        AppMethodBeat.o(28290);
                    }
                }, 1000);
                AppMethodBeat.o(28296);
                return;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.shake.d.a.h.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(28291);
                    h.this.DgX.f(null, 9);
                    AppMethodBeat.o(28291);
                }
            }, 1000);
            AppMethodBeat.o(28296);
        } else if (defaultAdapter == null) {
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.shake.d.a.h.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(28292);
                    h.this.DgX.f(null, 10);
                    AppMethodBeat.o(28292);
                }
            }, 1000);
            AppMethodBeat.o(28296);
        } else {
            Object[] objArr = new Object[1];
            if (this.DiO != null) {
                i2 = this.DiO.size();
            } else {
                i2 = 0;
            }
            objArr[0] = Integer.valueOf(i2);
            Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d", objArr);
            this.DiN = new d(this.DiO, this.gmu, this.gmv, this.DgH);
            bg.azz().a(this.DiN, 0);
            AppMethodBeat.o(28296);
        }
    }

    private void eTP() {
        AppMethodBeat.i(28299);
        this.iOv = d.bca();
        this.iOv.a(this.gmA, true);
        AppMethodBeat.o(28299);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void eTQ() {
        AppMethodBeat.i(28300);
        super.eTQ();
        bg.azz().b(JsApiInstallDownloadTaskForNative.CTRL_INDEX, this);
        AppMethodBeat.o(28300);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(28301);
        Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            d dVar = (d) qVar;
            if (658 == qVar.getType() && dVar.action == 1) {
                ccl ccl = (ccl) dVar.iUB.iLL.iLR;
                if (ccl.Mit == null) {
                    this.DgX.f(null, 3);
                    AppMethodBeat.o(28301);
                    return;
                } else if (ccl.Mit.LjQ == 0) {
                    Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", ccl.Mit.xJz, ccl.Mit.AZI, Integer.valueOf(ccl.Mit.LjQ));
                    try {
                        JSONObject jSONObject = new JSONObject(ccl.Mit.xJz);
                        JSONArray jSONArray = jSONObject.getJSONArray("msgs");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("guide_switch");
                        int i4 = jSONObject2.getInt("channel_open_method");
                        long j2 = jSONObject2.getLong("channel_open_time");
                        int i5 = jSONObject2.getInt("shake_tab_display");
                        int i6 = jSONObject.getJSONObject("gated_launch_option").getInt("tab_state");
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_METHOD_INT, Integer.valueOf(i4));
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, Long.valueOf(j2));
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(i5));
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(i6));
                        Log.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + i4 + " ,channel_open_time is " + j2 + ", shake_tab_display is " + i5);
                        int length = jSONArray.length();
                        ArrayList arrayList = null;
                        e eUm = m.eUm();
                        eUm.eUc();
                        if (length > 0) {
                            arrayList = new ArrayList();
                            for (int i7 = 0; i7 < length; i7++) {
                                com.tencent.mm.plugin.shake.b.d dVar2 = new com.tencent.mm.plugin.shake.b.d();
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i7);
                                String string = jSONObject3.getString("url");
                                String string2 = jSONObject3.getString("content");
                                String string3 = jSONObject3.getString("title");
                                String string4 = jSONObject3.getString("picurl");
                                String string5 = jSONObject3.getString("shopid");
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("beacon");
                                String string6 = jSONObject4.getString("uuid");
                                String string7 = jSONObject4.getString("major");
                                String string8 = jSONObject4.getString("minor");
                                int i8 = jSONObject3.getInt("guide_state");
                                String string9 = jSONObject3.getString("wxa_username");
                                String string10 = jSONObject3.getString("wxa_path");
                                int i9 = jSONObject3.getInt("wxa_version_type");
                                dVar2.field_type = 11;
                                dVar2.field_username = string3;
                                dVar2.field_nickname = string3;
                                dVar2.field_signature = string2;
                                dVar2.field_province = string4;
                                dVar2.field_city = string;
                                if (i8 == 1) {
                                    dVar2.field_sex = DiS;
                                }
                                dVar2.field_lvbuffer = (String.valueOf(string5) + "," + String.valueOf(string6) + "," + String.valueOf(string7) + "," + String.valueOf(string8)).getBytes(ProtocolPackage.ServerEncoding);
                                dVar2.field_insertBatch = 2;
                                dVar2.field_reserved3 = string9 + "," + string10 + "," + i9;
                                arrayList.add(dVar2);
                                eUm.a(dVar2, true);
                                if (dVar2.field_sex == DiS && i4 == 1) {
                                    a(dVar2);
                                }
                            }
                        }
                        this.DgX.f(arrayList, 1);
                        AppMethodBeat.o(28301);
                        return;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", Util.nullAsNil(e2.getMessage()));
                        this.DgX.f(null, 1);
                        AppMethodBeat.o(28301);
                        return;
                    }
                } else if (ccl.Mit.LjQ == this.DiP) {
                    this.DgX.f(null, 6);
                    AppMethodBeat.o(28301);
                    return;
                } else if (ccl.Mit.LjQ == this.DiQ) {
                    this.DgX.f(null, 7);
                    AppMethodBeat.o(28301);
                    return;
                } else if (ccl.Mit.LjQ == this.DiR) {
                    this.DgX.f(null, 8);
                    AppMethodBeat.o(28301);
                    return;
                } else {
                    this.DgX.f(null, 1);
                }
            }
            AppMethodBeat.o(28301);
            return;
        }
        this.DgX.f(null, 3);
        AppMethodBeat.o(28301);
    }

    public static void a(com.tencent.mm.plugin.shake.b.d dVar) {
        String str;
        AppMethodBeat.i(28302);
        if (dVar != null && dVar.field_sex == DiS) {
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.TRUE);
            long nowSecond = Util.nowSecond();
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, Long.valueOf(nowSecond));
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e2) {
                Log.printErrStackTrace("MicroMsg.ShakeIbeaconService", e2, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, Long.valueOf(split[0]));
                }
            }
        }
        AppMethodBeat.o(28302);
    }

    public static void b(com.tencent.mm.plugin.shake.b.d dVar) {
        String str;
        AppMethodBeat.i(28303);
        if (dVar != null) {
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e2) {
                Log.printErrStackTrace("MicroMsg.ShakeIbeaconService", e2, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    String str2 = split[1];
                    String str3 = split[2];
                    String str4 = split[3];
                    a aVar = new a();
                    aVar.uuid = str2;
                    aVar.major = Util.getInt(str3, 0);
                    aVar.minor = Util.getInt(str4, 0);
                }
            }
        }
        AppMethodBeat.o(28303);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void pause() {
        AppMethodBeat.i(28297);
        if (this.iOv != null) {
            this.iOv.c(this.gmA);
        }
        AppMethodBeat.o(28297);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void resume() {
        AppMethodBeat.i(28298);
        if (this.iOv != null) {
            this.iOv.a(this.gmA, true);
        }
        AppMethodBeat.o(28298);
    }
}
