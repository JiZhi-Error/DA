package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.a;
import com.tencent.mm.plugin.wallet_index.b.a.b;
import com.tencent.mm.plugin.wallet_index.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;

public final class a implements b {
    private static final String Ire = MMApplicationContext.getApplicationId();
    public static long Iri = 0;
    private String IqF;
    String IqG;
    private d Irf = null;
    private d Irg = null;
    private c Irh;
    private d Irj;
    private com.tencent.mm.plugin.wallet_index.b.a.a Irk;
    private b Irl;
    String Irm;
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.wallet_index.ui.a.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(71853);
            String action = intent.getAction();
            if ("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE".equals(action)) {
                a aVar = a.this;
                com.tencent.mm.plugin.wallet_index.b.a.a unused = a.this.Irk;
                aVar.Irl = com.tencent.mm.plugin.wallet_index.b.a.a.a(intent, a.this.Irf);
                AppMethodBeat.o(71853);
                return;
            }
            if ("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE".equals(action)) {
                final boolean booleanExtra = intent.getBooleanExtra("is_direct", true);
                com.tencent.mm.plugin.wallet_index.b.a.a unused2 = a.this.Irk;
                com.tencent.mm.plugin.wallet_index.b.a.a.a(intent, new a.AbstractC1926a() {
                    /* class com.tencent.mm.plugin.wallet_index.ui.a.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.wallet_index.b.a.a.AbstractC1926a
                    public final void a(c cVar, b bVar) {
                        c cJ;
                        AppMethodBeat.i(71852);
                        Log.d("MicroMsg.GoogleWallet", "Query inventory finished.");
                        if (cVar.isFailure() || bVar == null) {
                            Log.w("MicroMsg.GoogleWallet", "Failed to query inventory: ".concat(String.valueOf(cVar)));
                            AppMethodBeat.o(71852);
                            return;
                        }
                        Log.d("MicroMsg.GoogleWallet", "Query inventory was successful.");
                        a.this.Irl = bVar;
                        c cVar2 = a.this.Irh;
                        ArrayList arrayList = new ArrayList(bVar.mPurchaseMap.keySet());
                        cVar2.Irt.clear();
                        cVar2.Irt.addAll(arrayList);
                        ArrayList<com.tencent.mm.plugin.wallet_index.b.a.c> arrayList2 = new ArrayList(bVar.mPurchaseMap.values());
                        if (arrayList2.size() > 0) {
                            for (com.tencent.mm.plugin.wallet_index.b.a.c cVar3 : arrayList2) {
                                Log.i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + cVar3.rcD + ",billNo:" + cVar3.IqE);
                                g.aAi();
                                g.aAg().hqi.a(a.this.Irh.a(cVar3, true), 0);
                            }
                            AppMethodBeat.o(71852);
                            return;
                        }
                        Log.d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
                        if (!booleanExtra) {
                            Log.d("MicroMsg.GoogleWallet", "unknown_purchase");
                            cJ = c.cJ(5, "");
                        } else {
                            Log.d("MicroMsg.GoogleWallet", "result ok");
                            cJ = c.cJ(0, "");
                        }
                        if (a.this.Irj != null) {
                            a.this.Irj.a(cJ, null);
                        }
                        AppMethodBeat.o(71852);
                    }
                });
            }
            AppMethodBeat.o(71853);
        }
    };
    String rcD;

    static {
        AppMethodBeat.i(214276);
        AppMethodBeat.o(214276);
    }

    public a(Activity activity, c cVar, d dVar) {
        AppMethodBeat.i(71854);
        this.Irj = dVar;
        Iri = 0;
        this.Irh = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
        activity.registerReceiver(this.mReceiver, intentFilter);
        this.Irk = new com.tencent.mm.plugin.wallet_index.b.a.a();
        AppMethodBeat.o(71854);
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final int fUr() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final int a(MMActivity mMActivity, d dVar) {
        AppMethodBeat.i(71855);
        this.Irf = dVar;
        this.rcD = this.Irh.IqP.AZx;
        this.IqG = this.Irh.IqP.price;
        this.IqF = this.Irh.IqP.LSm;
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
        intent.setPackage(Ire);
        intent.putExtra("product_id", this.rcD);
        this.Irm = this.Irh.IqP.MiH;
        String str = this.Irm;
        String str2 = this.IqG;
        String str3 = this.IqF;
        if (Util.isNullOrNil(str)) {
            str = "";
        }
        if (Util.isNullOrNil(str2)) {
            str2 = "";
        }
        if (Util.isNullOrNil(str3)) {
            str3 = "";
        }
        intent.putExtra("developer_pay_load", str + "[#]" + str2 + "[#]" + str3);
        if (!mMActivity.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
            Iri = Util.nowMilliSecond();
            Log.i("MicroMsg.GoogleWallet", "GWallet Found!");
            mMActivity.startActivityForResult(intent, 10001);
        } else {
            Log.i("MicroMsg.GoogleWallet", "Try to downloading GWallet Moudle!");
            c cJ = c.cJ(3, "");
            if (this.Irf != null) {
                this.Irf.a(cJ, null);
            }
        }
        AppMethodBeat.o(71855);
        return 10001;
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final void p(MMActivity mMActivity) {
        AppMethodBeat.i(71856);
        try {
            mMActivity.unregisterReceiver(this.mReceiver);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.GoogleWallet", e2.toString());
        }
        if (!Util.isTopActivity(mMActivity)) {
            Log.d("MicroMsg.GoogleWallet", "close front UI.");
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage(Ire);
            mMActivity.sendBroadcast(intent);
        }
        Log.d("MicroMsg.GoogleWallet", "Destroying helper.");
        AppMethodBeat.o(71856);
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final boolean a(MMActivity mMActivity, int i2, int i3, Intent intent) {
        AppMethodBeat.i(71858);
        if (i2 == 10001) {
            Log.i("MicroMsg.GoogleWallet", "purchase flow!result_code: %d", Integer.valueOf(i3));
            if (intent != null) {
                int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
                if (intExtra == 3 || intExtra == 105) {
                    ab.e(this.Irm, this.rcD, this.IqG, intExtra, "");
                    b(mMActivity, intExtra);
                    AppMethodBeat.o(71858);
                } else if (intExtra == 100000001) {
                    b(mMActivity, intExtra);
                    AppMethodBeat.o(71858);
                }
            } else {
                b(mMActivity, 1);
                AppMethodBeat.o(71858);
            }
            return true;
        }
        d dVar = this.Irg;
        String str = this.Irm;
        String str2 = this.rcD;
        String str3 = this.IqG;
        int bh = com.tencent.mm.plugin.wallet_index.b.a.a.bh(intent);
        Log.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(bh));
        c cJ = c.cJ(bh, "");
        ab.e(str, str2, str3, bh, cJ.mMessage);
        if (dVar != null) {
            dVar.a(cJ, null);
        }
        AppMethodBeat.o(71858);
        return true;
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final void c(MMActivity mMActivity, boolean z) {
        AppMethodBeat.i(71859);
        Log.d("MicroMsg.GoogleWallet", "restorePurchase. Querying inventory.");
        Log.d("MicroMsg.GoogleWallet", "is direct? ".concat(String.valueOf(z)));
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
        intent.setPackage(Ire);
        intent.putExtra("is_direct", z);
        mMActivity.startActivityForResult(intent, 10001);
        AppMethodBeat.o(71859);
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final void a(MMActivity mMActivity, ArrayList<String> arrayList, d dVar, boolean z) {
        AppMethodBeat.i(71860);
        this.Irg = dVar;
        Log.d("MicroMsg.GoogleWallet", "consumePurchase. consume...");
        b bVar = this.Irl;
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (String str : arrayList) {
            com.tencent.mm.plugin.wallet_index.b.a.c cVar = bVar.mPurchaseMap.get(str);
            if (cVar != null) {
                arrayList2.add(cVar.mToken);
            }
        }
        if (arrayList2.size() > 0) {
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage(Ire);
            intent.putStringArrayListExtra("tokens", arrayList2);
            intent.putExtra("IS_FAILED_CONSUME", z);
            mMActivity.sendBroadcast(intent);
            AppMethodBeat.o(71860);
            return;
        }
        c cJ = c.cJ(0, "");
        if (this.Irg != null) {
            this.Irg.a(cJ, null);
        }
        AppMethodBeat.o(71860);
    }

    private static void b(MMActivity mMActivity, int i2) {
        AppMethodBeat.i(71857);
        c cJ = c.cJ(i2, "");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", cJ.mResponse);
        intent.putExtra("key_err_msg", cJ.mMessage);
        intent.putExtra("key_launch_ts", Iri);
        mMActivity.setResult(-1, intent);
        mMActivity.finish();
        AppMethodBeat.o(71857);
    }
}
