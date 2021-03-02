package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public final class b {
    private static long mStartTime = -1;
    private static final byte[] mhF = {0, 0};
    public static b mhH;
    ResultReceiver MU;
    String mAppId = null;
    private boolean mhA = true;
    boolean mhB = false;
    boolean mhC = false;
    private com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a mhD = new a(this, (byte) 0);
    private com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b mhE = new C0685b(this, (byte) 0);
    HostApduService mhG;
    int mhf;
    ArrayList<String> mhy;
    boolean mhz = false;

    public b() {
        AppMethodBeat.i(136167);
        AppMethodBeat.o(136167);
    }

    static /* synthetic */ void a(b bVar, byte[] bArr, boolean z, HostApduService hostApduService) {
        AppMethodBeat.i(136175);
        bVar.a(bArr, z, hostApduService);
        AppMethodBeat.o(136175);
    }

    static {
        AppMethodBeat.i(136176);
        mhH = null;
        mhH = new b();
        AppMethodBeat.o(136176);
    }

    public final void a(int i2, String str, Bundle bundle) {
        AppMethodBeat.i(136168);
        Log.i("MicroMsg.HCEServiceMgr", "alvinluo genCallHCEService type = %d", Integer.valueOf(i2));
        switch (i2) {
            case 13:
                bHT();
                if (this.mhG != null) {
                    this.mhG.stopSelf();
                    break;
                }
                break;
            case 21:
                if (this.mhE != null) {
                    this.mhE.onCreate();
                    AppMethodBeat.o(136168);
                    return;
                }
                break;
            case 22:
                if (this.mhE != null) {
                    this.mhE.onResume();
                    AppMethodBeat.o(136168);
                    return;
                }
                break;
            case 23:
                if (this.mhE != null) {
                    this.mhE.onPause();
                    AppMethodBeat.o(136168);
                    return;
                }
                break;
            case 24:
                if (this.mhE != null) {
                    this.mhE.onDestroy();
                    AppMethodBeat.o(136168);
                    return;
                }
                break;
            case 31:
                if (this.mhD != null) {
                    this.mhD.dD(str, bundle.getString("key_apdu_command"));
                    AppMethodBeat.o(136168);
                    return;
                }
                break;
            case 32:
                if (this.mhD != null) {
                    this.mhD.dE(str, bundle.getString("key_apdu_command"));
                    AppMethodBeat.o(136168);
                    return;
                }
                break;
        }
        AppMethodBeat.o(136168);
    }

    @TargetApi(21)
    public final void bHS() {
        AppMethodBeat.i(136169);
        if (this.mhy == null || this.mhG == null) {
            Log.e("MicroMsg.HCEServiceMgr", "alvinluo mAidList is null, or mHceService is null fail to register");
            AppMethodBeat.o(136169);
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.mhG);
        if (defaultAdapter == null) {
            Log.e("MicroMsg.HCEServiceMgr", "alvinluo NfcAdapter is null when register aids");
            AppMethodBeat.o(136169);
        } else if (Build.VERSION.SDK_INT < 21) {
            Log.e("MicroMsg.HCEServiceMgr", "alvinluo android version: %d is not satisfied when register aids", Integer.valueOf(Build.VERSION.SDK_INT));
            AppMethodBeat.o(136169);
        } else {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                try {
                    ComponentName componentName = new ComponentName(this.mhG, this.mhG.getClass());
                    boolean registerAidsForService = instance.registerAidsForService(componentName, "payment", this.mhy);
                    Log.i("MicroMsg.HCEServiceMgr", "alvinluo register aids result: %b", Boolean.valueOf(registerAidsForService));
                    if (registerAidsForService) {
                        hJ(true);
                        List<String> aidsForService = instance.getAidsForService(componentName, "payment");
                        if (aidsForService != null && aidsForService.size() > 0) {
                            for (int i2 = 0; i2 < aidsForService.size(); i2++) {
                                Log.e("MicroMsg.HCEServiceMgr", "dynamicAIDList aid=" + aidsForService.get(i2));
                            }
                        }
                        AppMethodBeat.o(136169);
                        return;
                    }
                    hJ(false);
                    AppMethodBeat.o(136169);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.HCEServiceMgr", e2, "alvinluo HCEService register aid exception", new Object[0]);
                    hJ(false);
                }
            }
            AppMethodBeat.o(136169);
        }
    }

    private void hJ(boolean z) {
        AppMethodBeat.i(136170);
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("errCode", 0);
            bundle.putString("errMsg", "");
        } else {
            bundle.putInt("errCode", 13006);
            bundle.putString("errMsg", "register aids failed");
        }
        b(this.mAppId, 12, bundle);
        AppMethodBeat.o(136170);
    }

    public final void b(String str, int i2, Bundle bundle) {
        AppMethodBeat.i(136171);
        bundle.putString("key_appid", str);
        bundle.putInt("key_event_type", i2);
        Q(bundle);
        AppMethodBeat.o(136171);
    }

    @TargetApi(21)
    public final void bHT() {
        AppMethodBeat.i(136172);
        if (this.mhG == null) {
            Log.e("MicroMsg.HCEServiceMgr", "alvinluo mHceService is null fail to unregisterAids");
            AppMethodBeat.o(136172);
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.mhG);
        if (defaultAdapter == null) {
            AppMethodBeat.o(136172);
        } else if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(136172);
        } else {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                ComponentName componentName = new ComponentName(this.mhG, this.mhG.getClass());
                Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService unregister aids");
                instance.removeAidsForService(componentName, "payment");
            }
            AppMethodBeat.o(136172);
        }
    }

    class a implements com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a
        public final void dD(String str, String str2) {
            AppMethodBeat.i(136161);
            Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", str, str2);
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                Log.e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
                AppMethodBeat.o(136161);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_apdu_command", str2);
            b.this.b(str, 31, bundle);
            b.this.mhA = true;
            if (!b.this.mhB) {
                b.this.mhB = true;
                b.this.mhC = false;
                long unused = b.mStartTime = System.currentTimeMillis();
                m.bZn().j(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(136160);
                        Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timer check, timeLimit: %d, hasCommandNotResponded: %b", Integer.valueOf(b.this.mhf), Boolean.valueOf(b.this.mhA));
                        b.this.mhC = true;
                        b.a(b.this, b.mhF, true, b.this.mhG);
                        AppMethodBeat.o(136160);
                    }
                }, (long) b.this.mhf);
                AppMethodBeat.o(136161);
                return;
            }
            if (b.this.mhC) {
                Log.w("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND TimeExceeded, just return default command");
                b.a(b.this, b.mhF, true, b.this.mhG);
                b.this.mhC = false;
            }
            AppMethodBeat.o(136161);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a
        public final void dE(String str, String str2) {
            AppMethodBeat.i(136162);
            if (b.this.mAppId == null || !b.this.mAppId.equals(str) || Util.isNullOrNil(str2)) {
                Log.e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", b.this.mAppId, str, str2);
                AppMethodBeat.o(136162);
                return;
            }
            byte[] decode = Base64.decode(str2, 2);
            Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", str, str2, c.aL(decode), Boolean.valueOf(b.this.mhA));
            b.a(b.this, decode, false, b.this.mhG);
            AppMethodBeat.o(136162);
        }
    }

    private synchronized void a(byte[] bArr, boolean z, HostApduService hostApduService) {
        AppMethodBeat.i(136173);
        Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND sendResponseCommandToSystem isDefaultCommand: %b, hasCommandNotResponded: %b", Boolean.valueOf(z), Boolean.valueOf(this.mhA));
        if (this.mhA) {
            this.mhA = false;
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send response command time: %d, cost: %d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - mStartTime));
            if (hostApduService != null) {
                hostApduService.sendResponseApdu(bArr);
            } else {
                Log.e("MicroMsg.HCEServiceMgr", "alvinluo sendResponseCommandToSystem hceService is null");
            }
            if (z) {
                String str = this.mAppId;
                Log.i("MicroMsg.HCEReportManager", "alvinluo reportHCEtimeExceeded appId: %s", str);
                ((com.tencent.mm.plugin.appbrand.w.b) e.N(com.tencent.mm.plugin.appbrand.w.b.class)).kvStat(14838, str);
            }
        }
        AppMethodBeat.o(136173);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b$b  reason: collision with other inner class name */
    class C0685b implements com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b {
        private C0685b() {
        }

        /* synthetic */ C0685b(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b
        public final void onCreate() {
            AppMethodBeat.i(136163);
            Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onCreate");
            AppMethodBeat.o(136163);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b
        public final void onResume() {
            AppMethodBeat.i(136164);
            Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onResume");
            if (b.this.mhz) {
                b.this.bHS();
                b.this.mhz = false;
            }
            AppMethodBeat.o(136164);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b
        public final void onPause() {
            AppMethodBeat.i(136165);
            Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onPause");
            b.this.bHT();
            b.this.mhz = true;
            AppMethodBeat.o(136165);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b
        public final void onDestroy() {
            AppMethodBeat.i(136166);
            Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onDestroy");
            AppMethodBeat.o(136166);
        }
    }

    private void Q(Bundle bundle) {
        AppMethodBeat.i(136174);
        Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCE EVENT mm to AppBrand");
        if (this.MU != null) {
            this.MU.send(10002, bundle);
        }
        AppMethodBeat.o(136174);
    }
}
