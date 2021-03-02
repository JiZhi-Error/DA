package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.jsapi.b.b;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.util.i;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.plugin.v.a.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e;
import com.tencent.smtt.sdk.TbsListener;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class c implements i, a.AbstractC1847a {
    private static final String CTl = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e26) + "/qr/");
    private boolean CFK = false;
    private boolean CIS = false;
    private int CJz;
    private boolean CSX;
    private int CSY = -1;
    private com.tencent.mm.plugin.scanner.view.c CTa = null;
    private Timer CTb = null;
    private TimerTask CTc = null;
    private int CTm;
    private String CTn;
    private Bundle CTo;
    private e.a CTp = null;
    private Map<q, Integer> CTq = new HashMap();
    private boolean CTr = false;
    public String appId;
    private int dFL;
    private int dFM;
    public String dFO;
    public String imagePath;
    public WeakReference<Activity> mActivityRef;
    public int pHw;
    public ProgressDialog pqa = null;
    public String source;
    public int sourceType;
    public String talker;
    private String typeName;

    static {
        AppMethodBeat.i(240823);
        AppMethodBeat.o(240823);
    }

    public c() {
        AppMethodBeat.i(52043);
        Log.i("MicroMsg.QBarStringHandler", "onResume");
        g.azz().a(106, this);
        g.azz().a(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, this);
        g.azz().a(com.tencent.mm.plugin.appbrand.game.e.a.e.CTRL_INDEX, this);
        g.azz().a(b.CTRL_INDEX, this);
        g.azz().a(3512, this);
        AppMethodBeat.o(52043);
    }

    private void a(String str, c.a aVar) {
        boolean z = false;
        AppMethodBeat.i(52044);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.CIS);
        if (this.CTa == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.d("MicroMsg.QBarStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", objArr);
        if (this.CTa == null || !this.CIS) {
            b(str, aVar);
            AppMethodBeat.o(52044);
            return;
        }
        cancelLoading();
        this.CTb = new Timer();
        this.CTc = new i(this.CTa, new i.b() {
            /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.scanner.util.i.b
            public final void onShow() {
                AppMethodBeat.i(240806);
                c.this.CTr = true;
                AppMethodBeat.o(240806);
            }
        }, aVar);
        this.CTb.schedule(this.CTc, 500);
        AppMethodBeat.o(52044);
    }

    private void c(String str, c.a aVar) {
        AppMethodBeat.i(52045);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.CIS);
        objArr[1] = Boolean.valueOf(this.CTa == null);
        Log.d("MicroMsg.QBarStringHandler", "alvinluo directShowLoading isFromScanUI: %b, loadingViewModel == null: %b", objArr);
        if (this.CTa == null || !this.CIS) {
            b(str, aVar);
            AppMethodBeat.o(52045);
            return;
        }
        this.CTr = true;
        this.CTa.a(true, false, aVar);
        AppMethodBeat.o(52045);
    }

    private void cancelLoading() {
        AppMethodBeat.i(52046);
        Log.i("MicroMsg.QBarStringHandler", "alvinluo cancelLoading");
        if (this.CTa != null) {
            this.CTa.a(false, false, null);
        }
        if (this.pqa != null && this.pqa.isShowing()) {
            this.pqa.dismiss();
        }
        if (this.CTb != null) {
            this.CTb.cancel();
        }
        if (this.CTc != null) {
            this.CTc.cancel();
        }
        AppMethodBeat.o(52046);
    }

    private void b(String str, final c.a aVar) {
        AppMethodBeat.i(52047);
        if (this.pqa != null) {
            this.pqa.dismiss();
        }
        Activity activity = this.mActivityRef != null ? this.mActivityRef.get() : null;
        if (activity == null) {
            AppMethodBeat.o(52047);
            return;
        }
        this.pqa = h.a((Context) activity, str, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass11 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(52035);
                if (aVar != null) {
                    aVar.eRN();
                }
                AppMethodBeat.o(52035);
            }
        });
        AppMethodBeat.o(52047);
    }

    public final void a(Activity activity, String str, int i2, String str2, int i3, int i4, e.a aVar, com.tencent.mm.plugin.scanner.view.c cVar, Bundle bundle, int i5, boolean z, int i6, boolean z2) {
        int i7;
        AppMethodBeat.i(52048);
        Log.i("MicroMsg.QBarStringHandler", "dealQBarString %s, source:%d, codeType: %s, codeVersion: %s, scanEntryScene: %d, processOfflineScan: %b, networkStatus: %d, isFromScanUI: %b", str, Integer.valueOf(i2), str2, Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Integer.valueOf(g.azz().aYS()), Boolean.valueOf(z2));
        this.mActivityRef = new WeakReference<>(activity);
        this.CTm = i2;
        this.CTn = str;
        this.dFL = i3;
        this.dFM = i4;
        this.typeName = str2;
        this.CTp = aVar;
        this.CTo = bundle;
        this.CSX = z;
        this.CJz = i5;
        this.CIS = z2;
        this.CFK = i2 == 1;
        this.CSY = i6;
        this.CTa = cVar;
        final String str3 = "";
        if (bundle != null) {
            str3 = bundle.getString("stat_url", "");
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
            AppMethodBeat.o(52048);
            return;
        }
        final Activity activity2 = this.mActivityRef.get();
        if (g.azz().aYS() == 0) {
            boolean isConnected = NetStatusUtil.isConnected(activity2);
            if (this.CTp != null) {
                Bundle bundle2 = null;
                if (aMQ(str)) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("key_offline_scan_show_tips", false);
                }
                this.CTp.r(0, bundle2);
                this.CTp.r(6, bundle2);
            }
            int i8 = isConnected ? 2 : 1;
            if (!this.CSX) {
                b bVar = b.CTi;
                if (b.uk(z2)) {
                    Log.e("MicroMsg.QBarStringHandler", "alvinluo dealQBarString network unavailable and deal with offline, isConnected: %b", Boolean.valueOf(isConnected));
                    if (!aMQ(str)) {
                        b bVar2 = b.CTi;
                        b.a(new OfflineScanContext(activity, i8, str, i2, i3, i4, this.typeName, this.CFK, bundle), isConnected ? activity2.getString(R.string.gd7) : activity2.getString(R.string.gd_), false);
                    }
                    com.tencent.mm.plugin.scanner.model.q qVar = com.tencent.mm.plugin.scanner.model.q.CFL;
                    String str4 = this.typeName;
                    if (this.CFK) {
                        i7 = 2;
                    } else {
                        i7 = 1;
                    }
                    com.tencent.mm.plugin.scanner.model.q.b(str, str4, i7, i8, 0);
                    AppMethodBeat.o(52048);
                    return;
                }
            }
            if (this.CSX) {
                b bVar3 = b.CTi;
                if (b.uk(z2)) {
                    b bVar4 = b.CTi;
                    b.k(activity, isConnected ? activity2.getString(R.string.gd7) : activity2.getString(R.string.gd_));
                    AppMethodBeat.o(52048);
                    return;
                }
            }
            Toast.makeText(activity, activity.getString(R.string.dep), 0).show();
            AppMethodBeat.o(52048);
            return;
        }
        String str5 = "";
        if (str.startsWith("weixin://qr/")) {
            str5 = str.substring(12) + "@qr";
        }
        if (!Util.isNullOrNil(str5)) {
            a(activity, i2, str5, false);
            AppMethodBeat.o(52048);
            return;
        }
        if (aMQ(str)) {
            Log.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString isPayCode and report");
            if (!z) {
                b bVar5 = b.CTi;
                if (b.uk(z2)) {
                    com.tencent.mm.plugin.scanner.model.q qVar2 = com.tencent.mm.plugin.scanner.model.q.CFL;
                    com.tencent.mm.plugin.scanner.model.q.b(str, this.typeName, this.CFK ? 2 : 1, 4, 0);
                }
            }
        }
        Log.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", str, Boolean.TRUE, Boolean.TRUE);
        if (str.startsWith("weixin://wxpay/bizpayurl")) {
            Log.i("MicroMsg.QBarStringHandler", "do native pay");
            if (this.CTp != null) {
                this.CTp.r(5, null);
            }
            int Xa = Xa(this.CTm);
            int Vl = Vl(Xa);
            final ph phVar = new ph();
            phVar.dVp.url = str;
            phVar.dVp.channel = Vl;
            phVar.dVp.scene = Xa;
            phVar.dVp.context = activity2;
            if (Vl == 13) {
                Log.d("MicroMsg.QBarStringHandler", "add source and sourceType");
                phVar.dVp.source = this.source;
                phVar.dVp.sourceType = this.sourceType;
            }
            phVar.callback = new Runnable() {
                /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(52036);
                    if (activity2 == null || phVar.dVq == null) {
                        AppMethodBeat.o(52036);
                    } else if (phVar.dVq.ret == 1) {
                        c.this.sU(true);
                        AppMethodBeat.o(52036);
                    } else {
                        if (phVar.dVq.ret == 2) {
                            c.this.sU(false);
                        }
                        AppMethodBeat.o(52036);
                    }
                }
            };
            EventCenter.instance.asyncPublish(phVar, Looper.myLooper());
            if (!((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) {
                new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(52037);
                        if (c.this.CTp != null && (phVar.dVq == null || phVar.dVq.ret != 1)) {
                            c.a(c.this, false);
                        }
                        AppMethodBeat.o(52037);
                    }
                }, 10000);
            }
            Xb(11);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16472, 2, str, str3);
            AppMethodBeat.o(52048);
        } else if (str.startsWith("https://wx.tenpay.com/f2f") || str.startsWith("wxp://f2f")) {
            Log.d("MicroMsg.QBarStringHandler", "go to payment code");
            if (this.CTp != null) {
                this.CTp.r(5, null);
            }
            if (!WeChatBrands.Business.Entries.DiscoveryScanPayCode.checkAvailable(activity2, new android.support.v4.e.c<Integer>() {
                /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass14 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.support.v4.e.c
                public final /* synthetic */ void accept(Integer num) {
                    AppMethodBeat.i(240815);
                    c.a(c.this, true);
                    AppMethodBeat.o(240815);
                }
            })) {
                AppMethodBeat.o(52048);
                return;
            }
            f.a(activity2, 1, str, Vl(Xa(this.CTm)), (com.tencent.mm.plugin.wallet.a) null);
            b(true, (Bundle) null);
            Xb(11);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16472, 1, str, str3);
            AppMethodBeat.o(52048);
        } else if (str.startsWith("wxp://wbf2f")) {
            if (this.CTp != null) {
                this.CTp.r(5, null);
            }
            f.a(activity2, 6, str, Vl(Xa(this.CTm)), (com.tencent.mm.plugin.wallet.a) null);
            b(true, (Bundle) null);
            Xb(11);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16472, 3, str, str3);
            AppMethodBeat.o(52048);
        } else if (i3 == 22 && str.startsWith("m")) {
            Log.i("MicroMsg.QBarStringHandler", "go to reward");
            if (this.CTp != null) {
                this.CTp.r(5, null);
            }
            if (!WeChatBrands.Business.Entries.DiscoveryScanPayReward.checkAvailable(activity2, new android.support.v4.e.c<Integer>() {
                /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass15 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.support.v4.e.c
                public final /* synthetic */ void accept(Integer num) {
                    AppMethodBeat.i(240816);
                    c.a(c.this, true);
                    AppMethodBeat.o(240816);
                }
            })) {
                AppMethodBeat.o(52048);
                return;
            }
            int Vl2 = Vl(Xa(this.CTm));
            int i9 = 1;
            if (this.pHw == 37) {
                i9 = 2;
            } else if (this.pHw == 38) {
                i9 = 3;
            } else if (this.pHw == 40) {
                i9 = 4;
            }
            f.a(activity2, str, Vl2, str3, i9);
            b(true, (Bundle) null);
            Xb(11);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16472, 6, str, str3);
            AppMethodBeat.o(52048);
        } else if (str.startsWith(CTl)) {
            Log.d("MicroMsg.QBarStringHandler", "f2f pay material");
            if (this.CTp != null) {
                this.CTp.r(5, null);
            }
            f.a(activity2, 1, str, Vl(Xa(this.CTm)), (com.tencent.mm.plugin.wallet.a) null);
            b(true, (Bundle) null);
            Xb(11);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16472, 5, str, str3);
            AppMethodBeat.o(52048);
        } else if (i3 != 22 || !str.startsWith("n")) {
            if (str.startsWith("weixin://wxpay/bindurl")) {
                Log.i("MicroMsg.QBarStringHandler", "fast bind card qrcode");
                if (this.CTp != null) {
                    this.CTp.r(5, null);
                }
                ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startFastBindUseCase(str, Vl(Xa(this.CTm)), new Runnable() {
                    /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass18 */

                    public final void run() {
                        AppMethodBeat.i(240819);
                        if (c.this.CTp != null) {
                            c.this.CTp.r(3, null);
                        }
                        AppMethodBeat.o(240819);
                    }
                });
                AppMethodBeat.o(52048);
            } else if (str.startsWith("wxhb://f2f")) {
                Log.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
                if (i3 != 19) {
                    AppMethodBeat.o(52048);
                } else if (!WeChatBrands.Business.Entries.DiscoveryScanFace2Face.checkAvailable(activity2, new android.support.v4.e.c<Integer>() {
                    /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass2 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.support.v4.e.c
                    public final /* synthetic */ void accept(Integer num) {
                        AppMethodBeat.i(240807);
                        c.a(c.this, true);
                        AppMethodBeat.o(240807);
                    }
                })) {
                    if (this.CTp != null) {
                        this.CTp.r(5, null);
                    }
                    AppMethodBeat.o(52048);
                } else {
                    if (this.CTp != null) {
                        this.CTp.r(5, null);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_share_url", str);
                    com.tencent.mm.br.c.b(activity2, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", intent, 1001);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16472, 4, str, str3);
                    Xb(11);
                    AppMethodBeat.o(52048);
                }
            } else {
                com.tencent.mm.plugin.scanner.c cVar2 = new com.tencent.mm.plugin.scanner.c();
                cVar2.activity = activity;
                cVar2.Czz = str;
                cVar2.dFL = i3;
                cVar2.dFM = i4;
                EventCenter.instance.publish(cVar2);
                a(activity, str, i3, i4, this.appId);
                if (this.CTp != null) {
                    this.CTp.r(5, null);
                }
                AppMethodBeat.o(52048);
            }
        } else if (!WeChatBrands.Business.Entries.DiscoveryScanPayReward.checkAvailable(activity2, new android.support.v4.e.c<Integer>() {
            /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass16 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(Integer num) {
                AppMethodBeat.i(240817);
                c.a(c.this, true);
                AppMethodBeat.o(240817);
            }
        })) {
            if (this.CTp != null) {
                this.CTp.r(5, null);
            }
            AppMethodBeat.o(52048);
        } else {
            Log.d("MicroMsg.QBarStringHandler", "qr reward pay material");
            if (this.CTp != null) {
                this.CTp.r(5, null);
            }
            final int Xa2 = Xa(this.CTm);
            final int Vl3 = Vl(Xa2);
            final tk tkVar = new tk();
            tkVar.dZQ.dZS = str;
            tkVar.dZQ.scene = Xa2;
            tkVar.dZQ.type = 1;
            tkVar.dZQ.aWF = new WeakReference(activity2);
            tkVar.dZQ.callback = new Runnable() {
                /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass17 */

                public final void run() {
                    AppMethodBeat.i(240818);
                    if (!Util.isNullOrNil(tkVar.dZR.errMsg)) {
                        if (activity2 != null) {
                            Toast.makeText(activity2, tkVar.dZR.errMsg, 1).show();
                        }
                        c.a(c.this, false);
                        AppMethodBeat.o(240818);
                    } else if (Util.isNullOrNil(tkVar.dZR.dZT)) {
                        Log.w("MicroMsg.QBarStringHandler", "resp url is null!");
                        c.a(c.this, false);
                        AppMethodBeat.o(240818);
                    } else if (tkVar.dZR.actionType == 1) {
                        f.a(activity2, tkVar.dZR.dZT, Vl3, str3, Xa2);
                        c.a(c.this, true);
                        AppMethodBeat.o(240818);
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", tkVar.dZR.dZT);
                        com.tencent.mm.plugin.scanner.h.jRt.i(intent, activity2);
                        c.a(c.this, true);
                        AppMethodBeat.o(240818);
                    }
                }
            };
            EventCenter.instance.publish(tkVar);
            Xb(11);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16472, 7, str, str3);
            AppMethodBeat.o(52048);
        }
    }

    private static boolean aMQ(String str) {
        AppMethodBeat.i(52049);
        if (str.startsWith("weixin://wxpay/bizpayurl") || str.startsWith("https://wx.tenpay.com/f2f") || str.startsWith("wxp://f2f") || str.startsWith("wxhb://f2f") || str.startsWith("wxp://wbf2f") || str.startsWith("m") || str.startsWith(CTl) || str.startsWith("n")) {
            AppMethodBeat.o(52049);
            return true;
        }
        AppMethodBeat.o(52049);
        return false;
    }

    private static int Vl(int i2) {
        if (i2 == 30 || i2 == 37 || i2 == 38 || i2 == 40) {
            return 13;
        }
        if (i2 == 4 || i2 == 47) {
            return 12;
        }
        if (i2 == 34) {
            return 24;
        }
        return 0;
    }

    public final void eRR() {
        AppMethodBeat.i(52050);
        Log.i("MicroMsg.QBarStringHandler", "cancel Deal");
        this.CTn = null;
        if (this.mActivityRef != null) {
            this.mActivityRef.clear();
            this.mActivityRef = null;
        }
        onPause();
        AppMethodBeat.o(52050);
    }

    private void onPause() {
        AppMethodBeat.i(52051);
        Log.i("MicroMsg.QBarStringHandler", "onPause");
        g.azz().b(106, this);
        g.azz().b(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, this);
        g.azz().b(com.tencent.mm.plugin.appbrand.game.e.a.e.CTRL_INDEX, this);
        g.azz().b(b.CTRL_INDEX, this);
        g.azz().b(3512, this);
        AppMethodBeat.o(52051);
    }

    private void a(Activity activity, int i2, String str, boolean z) {
        int i3 = 2;
        AppMethodBeat.i(52052);
        Log.i("MicroMsg.QBarStringHandler", "start search contact %s", str);
        if (i2 != 2) {
            i3 = 1;
        }
        final com.tencent.mm.plugin.messenger.a.f fVar = new com.tencent.mm.plugin.messenger.a.f(str, i3, 5, z);
        this.CTq.put(fVar, 1);
        g.azz().a(fVar, 0);
        AnonymousClass3 r0 = new c.a() {
            /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.scanner.view.c.a
            public final void eRN() {
                AppMethodBeat.i(240808);
                g.azz().a(fVar);
                if (c.this.CTp != null) {
                    c.this.CTp.r(1, null);
                }
                c.a(c.this, fVar);
                AppMethodBeat.o(240808);
            }
        };
        if (activity != null) {
            if (!z || !this.CTr) {
                a(activity.getString(R.string.gct), r0);
            } else {
                c(activity.getString(R.string.gct), r0);
                AppMethodBeat.o(52052);
                return;
            }
        }
        AppMethodBeat.o(52052);
    }

    private void a(Activity activity, String str, int i2, int i3, String str2) {
        String str3;
        AppMethodBeat.i(52053);
        int Xa = this.pHw > 0 ? this.pHw : Xa(this.CTm);
        Log.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", str, Integer.valueOf(this.CTm), Integer.valueOf(Xa));
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (this.CTo != null) {
            str4 = this.CTo.getString("stat_send_msg_user");
            String string = this.CTo.getString("stat_msg_id");
            if (!Util.isNullOrNil(string)) {
                str6 = string.replace("msg_", "").replace("sns_", "");
            }
            str5 = this.CTo.getString("stat_chat_talker_username");
            str3 = str6;
        } else {
            str3 = str6;
        }
        final l lVar = new l(str, str5, Xa, i2, i3, str2, (int) System.currentTimeMillis(), new byte[0], str4, str3);
        if (str.startsWith(com.tencent.mm.plugin.scanner.g.CAd) || str.startsWith(com.tencent.mm.plugin.scanner.g.CAe)) {
            String stringExtra = activity.getIntent().getStringExtra("img_gallery_session_id");
            int akL = e.a.akL(this.CTm);
            lVar.setSubScene(akL);
            String str7 = "";
            if (!Util.isNullOrNil(stringExtra)) {
                ad.b JV = ad.aVe().JV(stringExtra);
                if (JV != null) {
                    str7 = JV.getString("url", null);
                }
                lVar.Pz(str7);
            }
            Log.i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d", str7, Integer.valueOf(akL));
        }
        this.CTq.put(lVar, 1);
        g.azz().a(lVar, 0);
        if (this.pqa != null) {
            this.pqa.dismiss();
        }
        a(activity.getString(R.string.fsp), new c.a() {
            /* class com.tencent.mm.plugin.scanner.util.c.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.scanner.view.c.a
            public final void eRN() {
                AppMethodBeat.i(163478);
                g.azz().a(lVar);
                if (c.this.CTp != null) {
                    c.this.CTp.r(1, null);
                }
                c.a(c.this, lVar);
                AppMethodBeat.o(163478);
            }
        });
        AppMethodBeat.o(52053);
    }

    private static int Xa(int i2) {
        if (i2 == 1) {
            return 34;
        }
        if (i2 == 0) {
            return 4;
        }
        if (i2 == 3) {
            return 42;
        }
        return 30;
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x032a  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r14, int r15, java.lang.String r16, com.tencent.mm.ak.q r17) {
        /*
        // Method dump skipped, instructions count: 2372
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.util.c.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    private int eFd() {
        switch (this.CTm) {
            case 0:
            case 2:
            default:
                return 30;
            case 1:
                return 45;
        }
    }

    private void Xb(int i2) {
        AppMethodBeat.i(52055);
        if (this.CTo != null) {
            String string = this.CTo.getString("stat_url");
            if ((this.sourceType == 6 || this.sourceType == 0) && !Util.isNullOrNil(string)) {
                String str = "";
                String str2 = "";
                try {
                    str = URLEncoder.encode(Util.nullAsNil(string), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    str2 = URLEncoder.encode(Util.nullAsNil(this.CTn), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.QBarStringHandler", e2, "", new Object[0]);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13329, str, str2, Integer.valueOf(i2));
            }
        }
        AppMethodBeat.o(52055);
    }

    @Override // com.tencent.mm.plugin.v.a.a.AbstractC1847a
    public final Context getContext() {
        AppMethodBeat.i(261897);
        if (this.mActivityRef != null) {
            Activity activity = this.mActivityRef.get();
            AppMethodBeat.o(261897);
            return activity;
        }
        AppMethodBeat.o(261897);
        return null;
    }

    @Override // com.tencent.mm.plugin.v.a.a.AbstractC1847a
    public final void sU(boolean z) {
        AppMethodBeat.i(52056);
        if (!z) {
            b(true, (Bundle) null);
        } else if (this.CTp != null) {
            this.CTp.r(1, null);
            AppMethodBeat.o(52056);
            return;
        }
        AppMethodBeat.o(52056);
    }

    private void b(boolean z, Bundle bundle) {
        AppMethodBeat.i(240820);
        if (this.CTp != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("key_scan_qr_code_result", z);
            this.CTp.r(3, bundle);
        }
        AppMethodBeat.o(240820);
    }

    static /* synthetic */ void a(c cVar, boolean z) {
        AppMethodBeat.i(240821);
        cVar.b(z, (Bundle) null);
        AppMethodBeat.o(240821);
    }

    static /* synthetic */ void a(c cVar, q qVar) {
        int i2;
        int i3 = 2;
        int i4 = 1;
        AppMethodBeat.i(240822);
        b bVar = b.CTi;
        if (b.o(qVar)) {
            Log.i("MicroMsg.QBarStringHandler", "alvinluo OfflineScan onCancelScene processOfflineScan: %b, offlineScanNetworkType: %d", Boolean.valueOf(cVar.CSX), Integer.valueOf(cVar.CSY));
            com.tencent.mm.plugin.scanner.model.q qVar2 = com.tencent.mm.plugin.scanner.model.q.CFL;
            String str = cVar.CTn;
            String str2 = cVar.typeName;
            if (!cVar.CFK) {
                i3 = 1;
            }
            if (cVar.CSX) {
                i2 = cVar.CSY;
            } else {
                i2 = 3;
            }
            if (!cVar.CSX) {
                i4 = 0;
            }
            com.tencent.mm.plugin.scanner.model.q.b(str, str2, i3, i2, i4);
        }
        AppMethodBeat.o(240822);
    }
}
