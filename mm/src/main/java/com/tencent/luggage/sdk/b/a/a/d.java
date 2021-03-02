package com.tencent.luggage.sdk.b.a.a;

import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.ac.l;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.ssl.X509TrustManager;

public class d {
    private String czC = null;
    private boolean czD = true;
    private String czU = null;
    private int czV = -1;
    private com.tencent.mm.plugin.appbrand.s.a czW = null;
    private boolean czX = false;
    private WcwssNative czY;
    private final a czZ = new a(new Runnable() {
        /* class com.tencent.luggage.sdk.b.a.a.d.AnonymousClass4 */

        public final void run() {
            AppMethodBeat.i(146772);
            synchronized (d.this) {
                try {
                    if (d.this.czY != null) {
                        Log.i("Luggage.WcWssNativeInstallHelper", "destroyTask destroyWcWssBinding mContextId:%s", d.this.czU);
                        d.this.czY.destoryWcwss();
                        d.this.czY = null;
                    } else {
                        Log.e("Luggage.WcWssNativeInstallHelper", "destroyTask mWcwssNative is null");
                    }
                } finally {
                    AppMethodBeat.o(146772);
                }
            }
        }
    });
    private X509TrustManager mTrustManager = null;

    public interface b extends com.tencent.luggage.a.b {
        boolean Ob();

        boolean isOpen();
    }

    public d() {
        AppMethodBeat.i(146775);
        AppMethodBeat.o(146775);
    }

    public final void a(final i iVar, final f fVar, int i2) {
        AppMethodBeat.i(146777);
        Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding");
        b bVar = (b) fVar.M(b.class);
        if (bVar != null) {
            this.czX = bVar.isOpen();
        }
        if (!this.czX) {
            Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xSwitch false");
            AppMethodBeat.o(146777);
        } else if (iVar == null) {
            Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsruntime is null");
            AppMethodBeat.o(146777);
        } else {
            this.czC = String.valueOf(i2);
            d.class.getClassLoader();
            j.Ed("owl");
            d.class.getClassLoader();
            j.Ed("wcwss");
            com.tencent.mm.websocket.libwcwss.a.loadLibraries();
            q qVar = (q) iVar.R(q.class);
            if (qVar == null) {
                Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsThreadHandler is null");
                AppMethodBeat.o(146777);
                return;
            }
            final WeakReference weakReference = new WeakReference(qVar);
            b bVar2 = (b) fVar.M(b.class);
            if (bVar2 != null) {
                this.czD = bVar2.Oa();
                Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xLibUVSwitch:%b ", Boolean.valueOf(this.czD));
            }
            final AnonymousClass1 r1 = new WcwssNative.IWcWssReportListener() {
                /* class com.tencent.luggage.sdk.b.a.a.d.AnonymousClass1 */

                @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener
                public final int getNetworkType() {
                    AppMethodBeat.i(146765);
                    int statisticsNetType = d.getStatisticsNetType();
                    AppMethodBeat.o(146765);
                    return statisticsNetType;
                }

                @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener
                public final void onKvStat(int i2, String str) {
                    AppMethodBeat.i(146766);
                    Log.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onKvStat logId:%d", Integer.valueOf(i2));
                    ((com.tencent.mm.plugin.appbrand.w.b) e.N(com.tencent.mm.plugin.appbrand.w.b.class)).kvStat(i2, str);
                    AppMethodBeat.o(146766);
                }

                @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener
                public final void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
                    AppMethodBeat.i(146767);
                    Log.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onIdKeyStat");
                    ArrayList<IDKey> arrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        arrayList.add(new IDKey(iArr[i2], iArr2[i2], iArr3[i2]));
                    }
                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).b(arrayList, false);
                    AppMethodBeat.o(146767);
                }
            };
            final AnonymousClass2 r3 = new WcwssNative.IWcWssWebSocketListener() {
                /* class com.tencent.luggage.sdk.b.a.a.d.AnonymousClass2 */

                @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener
                public final void onStateChange(final String str, final long j2, final int i2) {
                    AppMethodBeat.i(146769);
                    ((q) weakReference.get()).post(new Runnable() {
                        /* class com.tencent.luggage.sdk.b.a.a.d.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(146768);
                            Log.d("Luggage.WcWssNativeInstallHelper", "MMWcWss jsThreadHandler run onCallBack contextId:%s", str);
                            d.this.czY.updateInterface(j2, i2);
                            AppMethodBeat.o(146768);
                        }
                    });
                    AppMethodBeat.o(146769);
                }

                @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener
                public final int doCertificateVerify(String str, long j2, String str2, byte[][] bArr) {
                    AppMethodBeat.i(146770);
                    if (d.this.czW == null || d.this.mTrustManager == null) {
                        d.this.czW = (com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
                        if (d.this.czW != null) {
                            d.this.mTrustManager = com.tencent.mm.plugin.appbrand.s.j.b(d.this.czW);
                            if (d.this.mTrustManager == null) {
                                Log.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getTrustManager fail");
                            }
                        } else {
                            Log.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getConfig fail");
                        }
                    }
                    int a2 = d.a(str2, bArr, d.this.mTrustManager);
                    AppMethodBeat.o(146770);
                    return a2;
                }
            };
            qVar.post(new Runnable() {
                /* class com.tencent.luggage.sdk.b.a.a.d.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(146771);
                    Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback ");
                    if (d.this.czU != null) {
                        Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mContextId != null");
                        AppMethodBeat.o(146771);
                        return;
                    }
                    v vVar = (v) iVar.R(v.class);
                    if (vVar == null) {
                        Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding v8Addon is null");
                        AppMethodBeat.o(146771);
                        return;
                    }
                    d.this.czY = new WcwssNative();
                    if (d.this.czY != null) {
                        if (d.this.czD) {
                            d.this.czU = d.this.czY.initWcwss(vVar.getIsolatePtr(), vVar.XK(), 0);
                        } else {
                            d.this.czU = d.this.czY.initWcwss(vVar.getIsolatePtr(), vVar.XK(), 0);
                        }
                        d.this.czV = d.this.czY.setCallback(r3, r1);
                        Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback mContextId:%s,mInitCallBack:%d", d.this.czU, Integer.valueOf(d.this.czV));
                        AppMethodBeat.o(146771);
                        return;
                    }
                    Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mWcwssNative = null");
                    AppMethodBeat.o(146771);
                }
            });
            AppMethodBeat.o(146777);
        }
    }

    public final void b(i iVar) {
        AppMethodBeat.i(146778);
        Log.i("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding mContextId:%s", this.czU);
        if (!this.czX) {
            Log.e("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding xSwitch false");
            AppMethodBeat.o(146778);
        } else if (iVar == null) {
            Log.e("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding jsruntime is null");
            AppMethodBeat.o(146778);
        } else {
            ((m) iVar.R(m.class)).a(this.czZ);
            AppMethodBeat.o(146778);
        }
    }

    class a extends l implements m.a {
        a(Runnable runnable) {
            super(runnable);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.m.a
        public final void onDestroy() {
            AppMethodBeat.i(146774);
            run();
            AppMethodBeat.o(146774);
        }
    }

    public final void a(i iVar, final k kVar) {
        AppMethodBeat.i(229843);
        Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId:%s", this.czU);
        if (!this.czX) {
            Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss xSwitch false");
            AppMethodBeat.o(229843);
        } else if (iVar == null) {
            Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsruntime is null");
            AppMethodBeat.o(229843);
        } else {
            final q qVar = (q) iVar.R(q.class);
            if (qVar == null) {
                Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsThreadHandler is null");
                AppMethodBeat.o(229843);
                return;
            }
            b bVar = (b) kVar.M(b.class);
            boolean z = bVar != null && bVar.Ob();
            Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss appId:%s, closeWcWssSocketsWhenSuspend:%b", kVar.getAppId(), Boolean.valueOf(z));
            if (z) {
                kVar.getRuntime().kAH.a(new c.a() {
                    /* class com.tencent.luggage.sdk.b.a.a.d.AnonymousClass5 */

                    @Override // com.tencent.mm.plugin.appbrand.a.c.a
                    public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                        AppMethodBeat.i(229841);
                        if (com.tencent.mm.plugin.appbrand.a.b.SUSPEND == bVar && d.this.czY != null) {
                            qVar.a(new Runnable() {
                                /* class com.tencent.luggage.sdk.b.a.a.d.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(229840);
                                    if (d.this.czY != null) {
                                        d.this.czY.doOnRunningState();
                                    }
                                    AppMethodBeat.o(229840);
                                }
                            }, true);
                        }
                        AppMethodBeat.o(229841);
                    }
                });
            }
            qVar.post(new Runnable() {
                /* class com.tencent.luggage.sdk.b.a.a.d.AnonymousClass6 */

                public final void run() {
                    ArrayList<String> arrayList;
                    ArrayList<String> arrayList2;
                    AppMethodBeat.i(229842);
                    Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss initConfig mContextId:%s", d.this.czU);
                    if (d.this.czY == null) {
                        Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mWcwssNative is null");
                        AppMethodBeat.o(229842);
                        return;
                    }
                    com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) kVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
                    if (aVar != null) {
                        Log.i("Luggage.WcWssNativeInstallHelper", "wcwss mbzType:%s,,websocketTimeoutMS:%d,userAgentString :%s,referer:%s,mode:%d", d.this.czC, Integer.valueOf(aVar.nhF), aVar.nhM, aVar.referer, Integer.valueOf(aVar.mode));
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("referer", aVar.referer);
                        hashMap.put("User-Agent", aVar.nhM);
                        hashMap.put("bzType", d.this.czC);
                        hashMap.put("mode", String.valueOf(aVar.mode));
                        hashMap.put("timeout", String.valueOf(aVar.nhF));
                        d.this.czY.initConfig(hashMap);
                        if (aVar.mode == 0) {
                            Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", Integer.valueOf(aVar.mode));
                            AppMethodBeat.o(229842);
                        } else if (aVar.mode == 1) {
                            if (aVar.nhJ == null || aVar.nhJ.size() == 0) {
                                Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss blacklistHeaders is null");
                                arrayList2 = null;
                            } else {
                                arrayList2 = aVar.nhJ;
                            }
                            d.this.czY.initConfigWhiteBlack(null, arrayList2);
                            AppMethodBeat.o(229842);
                        } else if (aVar.mode == 2) {
                            if (aVar.nhK == null || aVar.nhK.size() == 0) {
                                Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss whitelistHeaders is null");
                                arrayList = null;
                            } else {
                                arrayList = aVar.nhK;
                            }
                            d.this.czY.initConfigWhiteBlack(arrayList, null);
                            AppMethodBeat.o(229842);
                        } else {
                            Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", Integer.valueOf(aVar.mode));
                            AppMethodBeat.o(229842);
                        }
                    } else {
                        Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss networkConfig is null");
                        AppMethodBeat.o(229842);
                    }
                }
            });
            AppMethodBeat.o(229843);
        }
    }

    public static int getStatisticsNetType() {
        AppMethodBeat.i(146780);
        try {
            int netType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
            Log.i("Luggage.WcWssNativeInstallHelper", "getStatisticsNetType ret:%d", Integer.valueOf(netType));
            if (netType == -1) {
                AppMethodBeat.o(146780);
                return -1;
            } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                AppMethodBeat.o(146780);
                return 3;
            } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                AppMethodBeat.o(146780);
                return 4;
            } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                AppMethodBeat.o(146780);
                return 5;
            } else if (NetStatusUtil.isWifi(netType)) {
                AppMethodBeat.o(146780);
                return 1;
            } else if (NetStatusUtil.isWap(netType)) {
                AppMethodBeat.o(146780);
                return 2;
            } else {
                AppMethodBeat.o(146780);
                return 6;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("Luggage.WcWssNativeInstallHelper", e2, "getStatisticsNetType_", new Object[0]);
            AppMethodBeat.o(146780);
            return -1;
        }
    }

    public static int a(String str, byte[][] bArr, X509TrustManager x509TrustManager) {
        AppMethodBeat.i(146781);
        Log.i("Luggage.WcWssNativeInstallHelper", "certifivate verify for ".concat(String.valueOf(str)));
        try {
            AndroidCertVerifyResult verifyServerCertificates = X509Util.verifyServerCertificates(bArr, EncryptUtil.KEY_ALGORITHM, str, 1, x509TrustManager);
            Log.i("Luggage.WcWssNativeInstallHelper", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
            if (verifyServerCertificates.getStatus() != 0) {
                verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "ECDSA", str, 1, x509TrustManager);
                Log.i("Luggage.WcWssNativeInstallHelper", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
            }
            if (verifyServerCertificates.getStatus() != 0) {
                ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 7, 1, false);
            }
            if (verifyServerCertificates.getStatus() == 0 && !verifyServerCertificates.isIssuedByHostMatched()) {
                ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 8, 1, false);
            }
            if (verifyServerCertificates.getStatus() == 0 && !verifyServerCertificates.isIssuedByKnownRoot()) {
                ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 9, 1, false);
            }
            if (verifyServerCertificates.getStatus() != 0 || !verifyServerCertificates.isIssuedByKnownRoot()) {
                AppMethodBeat.o(146781);
                return -1;
            }
            AppMethodBeat.o(146781);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace("Luggage.WcWssNativeInstallHelper", e2, "doCertificateVerify Exception", new Object[0]);
            AppMethodBeat.o(146781);
            return -1;
        }
    }
}
