package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.j;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(19)
public final class a {
    public static a mht;
    private ResultReceiver MU;
    private final Handler mHandler = new Handler();
    private int mhj = 0;
    private boolean mhk = false;
    private boolean mhl = false;
    private boolean mhm = false;
    private Timer mhn;
    private TimerTask mho;
    private ComponentName mhp;
    private Activity mhq;
    private j mhr;
    private d mhs = null;

    public a() {
        AppMethodBeat.i(136130);
        AppMethodBeat.o(136130);
    }

    static /* synthetic */ void a(a aVar, int i2, String str) {
        AppMethodBeat.i(136153);
        aVar.an(i2, str);
        AppMethodBeat.o(136153);
    }

    static /* synthetic */ void a(a aVar, String str, String str2) {
        AppMethodBeat.i(136152);
        aVar.q(13004, str, str2);
        AppMethodBeat.o(136152);
    }

    static /* synthetic */ int b(a aVar) {
        int i2 = aVar.mhj;
        aVar.mhj = i2 + 1;
        return i2;
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(136148);
        aVar.bHO();
        AppMethodBeat.o(136148);
    }

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(136149);
        aVar.bHR();
        AppMethodBeat.o(136149);
    }

    static {
        AppMethodBeat.i(136154);
        mht = null;
        mht = new a();
        AppMethodBeat.o(136154);
    }

    public final void a(Activity activity, ResultReceiver resultReceiver) {
        AppMethodBeat.i(136131);
        Log.i("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity");
        if (activity == null || resultReceiver == null) {
            Log.e("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity hceActivity is null, or resultReceiver is null");
        }
        this.mhq = activity;
        this.MU = resultReceiver;
        AppMethodBeat.o(136131);
    }

    public final void b(ComponentName componentName) {
        AppMethodBeat.i(136132);
        Log.i("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent");
        this.mhp = componentName;
        AppMethodBeat.o(136132);
    }

    private void bHv() {
        AppMethodBeat.i(136133);
        if (this.mhq != null) {
            this.mhr = j.b(this.mhq, this.mhq.getString(R.string.et9), false);
            AppMethodBeat.o(136133);
            return;
        }
        Log.e("MicroMsg.HCEActivityMgr", "alvinluo showProgressDialog mHceActivity is null");
        AppMethodBeat.o(136133);
    }

    private void biW() {
        AppMethodBeat.i(136134);
        if (this.mhr != null) {
            this.mhr.dismiss();
            this.mhr = null;
        }
        AppMethodBeat.o(136134);
    }

    public final void xk(int i2) {
        AppMethodBeat.i(136135);
        if (i2 == 1) {
            Log.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
            this.mhl = true;
            AppMethodBeat.o(136135);
            return;
        }
        if (i2 == 2) {
            Log.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
        }
        AppMethodBeat.o(136135);
    }

    public final void bHM() {
        AppMethodBeat.i(136136);
        if (this.mhl) {
            bHN();
            AppMethodBeat.o(136136);
            return;
        }
        bHO();
        AppMethodBeat.o(136136);
    }

    public final void resetStatus() {
        this.mhl = false;
        this.mhm = false;
        this.mhk = false;
    }

    private void bHN() {
        AppMethodBeat.i(136137);
        this.mho = new TimerTask() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(136122);
                Log.i("MicroMsg.HCEActivityMgr", "alvinluo loop check NFC switch currentCount: %d", Integer.valueOf(a.this.mhj));
                a.b(a.this);
                m.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(136121);
                        if (a.this.mhj > 10) {
                            Log.i("MicroMsg.HCEActivityMgr", "alvinluo loop check count exceed max limit: %d", 10);
                            a.c(a.this);
                            a.d(a.this);
                            AppMethodBeat.o(136121);
                            return;
                        }
                        if (com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHY()) {
                            Log.i("MicroMsg.HCEActivityMgr", "alvinluo loopCheck NFC switch is opened, and cancel task");
                            a.c(a.this);
                            a.e(a.this);
                        }
                        AppMethodBeat.o(136121);
                    }
                });
                AppMethodBeat.o(136122);
            }
        };
        this.mhn = new Timer();
        this.mhn.scheduleAtFixedRate(this.mho, 0, 300);
        bHv();
        AppMethodBeat.o(136137);
    }

    private void bHO() {
        AppMethodBeat.i(136138);
        if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHX()) {
            am(13000, "not support NFC");
            AppMethodBeat.o(136138);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHW()) {
            am(13002, "not support HCE");
            AppMethodBeat.o(136138);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHY()) {
            bHP();
            AppMethodBeat.o(136138);
        } else {
            bHR();
            AppMethodBeat.o(136138);
        }
    }

    private void bHP() {
        AppMethodBeat.i(136139);
        if (this.mhq == null) {
            Log.e("MicroMsg.HCEActivityMgr", "alvinluo showOpenNFCDialog mHceActivity is null");
            AppMethodBeat.o(136139);
        } else if (this.mhk) {
            Log.i("MicroMsg.HCEActivityMgr", "alvinluo has shown open NFC dialog");
            q(13001, "system NFC switch not opened", this.mhq.getString(R.string.etl));
            AppMethodBeat.o(136139);
        } else {
            d.a aVar = new d.a(this.mhq);
            aVar.boo(this.mhq.getString(R.string.etn)).bou(this.mhq.getString(R.string.etj)).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(136123);
                    a.f(a.this);
                    AppMethodBeat.o(136123);
                }
            });
            if (bHQ()) {
                aVar.bov(this.mhq.getString(R.string.et7)).d(new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(136124);
                        Log.i("MicroMsg.HCEActivityMgr", "alvinluo user click cancel button of NFC tips dialog.");
                        a.a(a.this, "system NFC switch not opened");
                        AppMethodBeat.o(136124);
                    }
                });
            } else {
                aVar.bou(this.mhq.getString(R.string.et8));
            }
            aVar.f(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(136125);
                    Log.i("MicroMsg.HCEActivityMgr", "alvinluo cancel by pressing back");
                    a.a(a.this, "system NFC switch not opened");
                    AppMethodBeat.o(136125);
                }
            });
            this.mhs = aVar.hbn();
            this.mhs.setCanceledOnTouchOutside(false);
            this.mhs.show();
            this.mhk = true;
            AppMethodBeat.o(136139);
        }
    }

    private boolean bHQ() {
        AppMethodBeat.i(136140);
        if (this.mhq == null) {
            Log.e("MicroMsg.HCEActivityMgr", "alvinluo isCanJumpNFCSetting mHceActivity is null");
            AppMethodBeat.o(136140);
            return false;
        }
        List<ResolveInfo> queryIntentActivities = this.mhq.getPackageManager().queryIntentActivities(new Intent("android.settings.NFC_SETTINGS"), 65536);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            Log.e("MicroMsg.HCEActivityMgr", "alvinluo Cannot jump to NFC setting");
            AppMethodBeat.o(136140);
            return false;
        }
        Log.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity not null, activities size: " + queryIntentActivities.size());
        for (int i2 = 0; i2 < queryIntentActivities.size(); i2++) {
            Log.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity: %s", queryIntentActivities.get(i2).activityInfo.name);
        }
        AppMethodBeat.o(136140);
        return true;
    }

    @TargetApi(19)
    private void bHR() {
        AppMethodBeat.i(136141);
        if (this.mhq == null) {
            Log.e("MicroMsg.HCEActivityMgr", "alvinluo checkDefaultNFCApplication mHceActivity is null");
            AppMethodBeat.o(136141);
            return;
        }
        CardEmulation instance = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this.mhq));
        Log.i("MicroMsg.HCEActivityMgr", "alvinluo component name: " + this.mhp);
        if (!instance.isDefaultServiceForCategory(this.mhp, "payment")) {
            Log.i("MicroMsg.HCEActivityMgr", "alvinluo not NFC Default Application, isAutoSet: %b", Boolean.TRUE);
            c(this.mhp);
            AppMethodBeat.o(136141);
            return;
        }
        Log.i("MicroMsg.HCEActivityMgr", "alvinluo now is NFC Default Application");
        an(0, "NFC switch has opened and now is NFC default application");
        AppMethodBeat.o(136141);
    }

    @TargetApi(19)
    private void c(final ComponentName componentName) {
        AppMethodBeat.i(136142);
        if (this.mhq == null) {
            Log.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication mHceActivity is null");
            AppMethodBeat.o(136142);
            return;
        }
        Log.i("MicroMsg.HCEActivityMgr", "alvinluo request set default NFC application, hasRequestSetDefault: %b", Boolean.valueOf(this.mhm));
        if (this.mhm) {
            Log.i("MicroMsg.HCEActivityMgr", "alvinluo has request set default NFC application");
            q(13004, "not set default NFC application", this.mhq.getString(R.string.etm));
            AppMethodBeat.o(136142);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(136128);
                a.this.mhm = true;
                Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
                intent.putExtra("category", "payment");
                intent.putExtra("component", componentName);
                if (a.this.mhq == null || intent.resolveActivity(a.this.mhq.getPackageManager()) == null) {
                    Log.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication can not find activity");
                    if (a.this.mhq != null) {
                        a.a(a.this, "not set default NFC application", a.this.mhq.getString(R.string.etm));
                    }
                    AppMethodBeat.o(136128);
                    return;
                }
                f.aK(a.this.mhq).a(intent, new f.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.AnonymousClass6.AnonymousClass1 */

                    @Override // com.tencent.luggage.h.f.b
                    public final void a(int i2, Intent intent) {
                        AppMethodBeat.i(136127);
                        a.mht.xk(2);
                        AppMethodBeat.o(136127);
                    }
                });
                AppMethodBeat.o(136128);
            }
        }, 200);
        AppMethodBeat.o(136142);
    }

    private void q(final int i2, final String str, String str2) {
        AppMethodBeat.i(136143);
        dismissDialog();
        if (this.mhq == null) {
            Log.e("MicroMsg.HCEActivityMgr", "alvinluo showErrorDialog mHceActivity is null");
            AppMethodBeat.o(136143);
            return;
        }
        d.a aVar = new d.a(this.mhq);
        aVar.bon("");
        aVar.boo(str2);
        aVar.bou(this.mhq.getString(R.string.et8)).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(136129);
                a.a(a.this, i2, str);
                AppMethodBeat.o(136129);
            }
        });
        aVar.Dk(true);
        this.mhs = aVar.hbn();
        this.mhs.setCanceledOnTouchOutside(false);
        this.mhs.show();
        AppMethodBeat.o(136143);
    }

    public final void dismissDialog() {
        AppMethodBeat.i(136144);
        if (this.mhs != null && this.mhs.isShowing()) {
            this.mhs.dismiss();
            this.mhs = null;
        }
        biW();
        AppMethodBeat.o(136144);
    }

    private void am(int i2, String str) {
        AppMethodBeat.i(136145);
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", i2);
        bundle.putString("errMsg", str);
        this.MU.send(10001, bundle);
        AppMethodBeat.o(136145);
    }

    private void an(int i2, String str) {
        AppMethodBeat.i(136146);
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", i2);
        bundle.putString("errMsg", str);
        this.MU.send(10001, bundle);
        AppMethodBeat.o(136146);
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(136147);
        aVar.dismissDialog();
        if (aVar.mhn != null) {
            aVar.mhn.cancel();
        }
        AppMethodBeat.o(136147);
    }

    static /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(136150);
        if (aVar.mhq == null) {
            Log.e("MicroMsg.HCEActivityMgr", "alvinluo jumpNFCSetting mHceActivity is null");
            AppMethodBeat.o(136150);
            return;
        }
        f.aK(aVar.mhq).a(new Intent("android.settings.NFC_SETTINGS"), new f.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.AnonymousClass5 */

            @Override // com.tencent.luggage.h.f.b
            public final void a(int i2, Intent intent) {
                AppMethodBeat.i(136126);
                a.mht.xk(1);
                AppMethodBeat.o(136126);
            }
        });
        AppMethodBeat.o(136150);
    }

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(136151);
        aVar.an(13001, str);
        AppMethodBeat.o(136151);
    }
}
