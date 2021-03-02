package com.tencent.mm.plugin.gwallet;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.RemoteException;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

@JgClassChecked(author = 31, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK, EType.RECEIVERCHECK})
public class GWalletUI extends HellActivity {
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.gwallet.GWalletUI.AnonymousClass3 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(64573);
            if ("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST".equals(intent.getAction())) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tokens");
                final boolean booleanExtra = intent.getBooleanExtra("IS_FAILED_CONSUME", false);
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    GWalletUI.a(GWalletUI.this, 0, null);
                    AppMethodBeat.o(64573);
                    return;
                }
                ThreadPool.post(new Runnable(stringArrayListExtra, new b.AbstractC1430b() {
                    /* class com.tencent.mm.plugin.gwallet.GWalletUI.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.gwallet.a.b.AbstractC1430b
                    public final void b(c cVar, Intent intent) {
                        AppMethodBeat.i(64572);
                        Log.d("MicroMsg.GWalletUI", "Purchase finished: " + cVar + ", purchase: " + intent);
                        Intent intent2 = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_RESPONSE");
                        if (booleanExtra) {
                            intent2.putExtra("RESPONSE_CODE", 100000001);
                        } else {
                            intent2.putExtra("RESPONSE_CODE", 0);
                        }
                        GWalletUI.a(GWalletUI.this, -1, intent2);
                        AppMethodBeat.o(64572);
                    }
                }, new MMHandler()) {
                    /* class com.tencent.mm.plugin.gwallet.a.b.AnonymousClass2 */
                    final /* synthetic */ MMHandler val$handler;
                    final /* synthetic */ List yht;
                    final /* synthetic */ AbstractC1430b yhu;

                    {
                        this.yht = r2;
                        this.yhu = r3;
                        this.val$handler = r4;
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
                        if (r0.equals("") != false) goto L_0x002d;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                        // Method dump skipped, instructions count: 203
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gwallet.a.b.AnonymousClass2.run():void");
                    }
                }, "IabHelper_consumeAsync");
            }
            AppMethodBeat.o(64573);
        }
    };
    private b ygY = null;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GWalletUI() {
        AppMethodBeat.i(64575);
        AppMethodBeat.o(64575);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64576);
        super.onCreate(bundle);
        requestWindowFeature(1);
        Log.d("MicroMsg.GWalletUI", "Creating IAB helper.");
        this.ygY = new b(this);
        Log.d("MicroMsg.GWalletUI", "Starting setup.");
        this.ygY.a(new b.a() {
            /* class com.tencent.mm.plugin.gwallet.GWalletUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.gwallet.a.b.a
            public final void a(c cVar) {
                AppMethodBeat.i(64570);
                Log.d("MicroMsg.GWalletUI", "Setup finished.");
                if (!cVar.isSuccess()) {
                    Log.e("MicroMsg.GWalletUI", "Problem setting up in-app billing: ".concat(String.valueOf(cVar)));
                    Intent intent = new Intent();
                    intent.putExtra("RESPONSE_CODE", cVar.getResponse());
                    GWalletUI.a(GWalletUI.this, -1, intent);
                    AppMethodBeat.o(64570);
                } else if ("com.tencent.mm.gwallet.ACTION_PAY_REQUEST".equals(GWalletUI.this.getIntent().getAction())) {
                    GWalletUI.a(GWalletUI.this);
                    AppMethodBeat.o(64570);
                } else {
                    GWalletUI.this.qb(GWalletUI.this.getIntent().getBooleanExtra("is_direct", true));
                    AppMethodBeat.o(64570);
                }
            }
        });
        AppMethodBeat.o(64576);
    }

    public final void qb(final boolean z) {
        AppMethodBeat.i(64577);
        b bVar = this.ygY;
        AnonymousClass4 r2 = new b.AbstractC1430b() {
            /* class com.tencent.mm.plugin.gwallet.GWalletUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.gwallet.a.b.AbstractC1430b
            @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
            public final void b(c cVar, Intent intent) {
                AppMethodBeat.i(64574);
                Log.d("MicroMsg.GWalletUI", "Query inventory finished. data : ".concat(String.valueOf(intent)));
                if (intent == null) {
                    intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
                    intent.putExtra("RESPONSE_CODE", cVar.getResponse());
                } else {
                    intent.setAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
                }
                if (!z) {
                    intent.putExtra("is_direct", false);
                }
                GWalletUI.this.sendBroadcast(intent);
                AppMethodBeat.o(64574);
            }
        };
        MMHandler mMHandler = new MMHandler();
        bVar.aBu("queryInventory");
        ThreadPool.post(new Runnable("inapp", mMHandler, r2) {
            /* class com.tencent.mm.plugin.gwallet.a.b.AnonymousClass3 */
            final /* synthetic */ MMHandler val$handler;
            final /* synthetic */ String yhx;
            final /* synthetic */ AbstractC1430b yhy;

            {
                this.yhx = r2;
                this.val$handler = r3;
                this.yhy = r4;
            }

            public final void run() {
                AppMethodBeat.i(64592);
                final c cVar = new c(0, "Inventory refresh successful.");
                final Intent intent = new Intent();
                try {
                    int a2 = b.a(b.this, intent, this.yhx);
                    if (a2 != 0) {
                        cVar = new c(a2, "Error refreshing inventory (querying owned items).");
                    }
                } catch (RemoteException e2) {
                    Log.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
                    cVar = new c(-1001, "Remote exception while refreshing inventory.");
                } catch (JSONException e3) {
                    Log.printErrStackTrace("MicroMsg.IabHelper", e3, "", new Object[0]);
                    cVar = new c(-1002, "Error parsing JSON response while refreshing inventory.");
                }
                intent.putExtra("RESPONSE_CODE", cVar.getResponse());
                this.val$handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.gwallet.a.b.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(64591);
                        AnonymousClass3.this.yhy.b(cVar, intent);
                        AppMethodBeat.o(64591);
                    }
                });
                AppMethodBeat.o(64592);
            }
        }, "IabHelper_queryInventoryAsync");
        AppMethodBeat.o(64577);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(64578);
        if ("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST".equals(intent.getAction())) {
            qb(intent.getBooleanExtra("is_direct", true));
        }
        super.onNewIntent(intent);
        AppMethodBeat.o(64578);
    }

    public void onStart() {
        AppMethodBeat.i(64579);
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
        registerReceiver(this.mReceiver, intentFilter);
        AppMethodBeat.o(64579);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onStop() {
        AppMethodBeat.i(64580);
        super.onStop();
        unregisterReceiver(this.mReceiver);
        AppMethodBeat.o(64580);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        int longValue;
        AppMethodBeat.i(64581);
        b bVar = this.ygY;
        if (i2 == bVar.mRequestCode) {
            bVar.aBu("handleActivityResult");
            if (intent == null) {
                b.aBv("Null data in IAB activity result.");
                c cVar = new c(-1002, "Null data in IAB result");
                if (bVar.yhp != null) {
                    bVar.yhp.b(cVar, null);
                }
                AppMethodBeat.o(64581);
                return;
            }
            Object obj = intent.getExtras().get("RESPONSE_CODE");
            if (obj == null) {
                b.aBv("Intent with no response code, assuming OK (known issue)");
                longValue = 0;
            } else if (obj instanceof Integer) {
                longValue = ((Integer) obj).intValue();
            } else if (obj instanceof Long) {
                longValue = (int) ((Long) obj).longValue();
            } else {
                b.aBv("Unexpected type for intent response code.");
                b.aBv(obj.getClass().getName());
                RuntimeException runtimeException = new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
                AppMethodBeat.o(64581);
                throw runtimeException;
            }
            String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
            String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
            Log.d("MicroMsg.IabHelper", "Purchase data: ".concat(String.valueOf(stringExtra)));
            Log.d("MicroMsg.IabHelper", "Data signature: ".concat(String.valueOf(stringExtra2)));
            Log.d("MicroMsg.IabHelper", "Extras: " + intent.getExtras());
            Log.d("MicroMsg.IabHelper", "Expected item type: " + bVar.yhq);
            c cVar2 = new c(longValue, "Null data in IAB result");
            if (bVar.yhp != null) {
                bVar.yhp.b(cVar2, intent);
            }
        }
        AppMethodBeat.o(64581);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(64582);
        Log.d("MicroMsg.GWalletUI", "Destroying helper.");
        if (this.ygY != null) {
            this.ygY.dispose();
        }
        this.ygY = null;
        super.onDestroy();
        AppMethodBeat.o(64582);
    }

    static /* synthetic */ void a(GWalletUI gWalletUI, int i2, Intent intent) {
        AppMethodBeat.i(64583);
        Log.d("MicroMsg.GWalletUI", "Finish GWallet. setResult:".concat(String.valueOf(i2)));
        gWalletUI.setResult(i2, intent);
        gWalletUI.finish();
        AppMethodBeat.o(64583);
    }

    static /* synthetic */ void a(GWalletUI gWalletUI) {
        AppMethodBeat.i(64584);
        Intent intent = gWalletUI.getIntent();
        String stringExtra = intent.getStringExtra("product_id");
        String stringExtra2 = intent.getStringExtra("developer_pay_load");
        b bVar = gWalletUI.ygY;
        AnonymousClass2 r11 = new b.AbstractC1430b() {
            /* class com.tencent.mm.plugin.gwallet.GWalletUI.AnonymousClass2 */

            /* JADX WARNING: Code restructure failed: missing block: B:8:0x004e, code lost:
                if (r2 == false) goto L_0x0050;
             */
            @Override // com.tencent.mm.plugin.gwallet.a.b.AbstractC1430b
            @com.jg.JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {com.jg.EType.INTENTCHECK})
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void b(com.tencent.mm.plugin.gwallet.a.c r7, android.content.Intent r8) {
                /*
                // Method dump skipped, instructions count: 103
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gwallet.GWalletUI.AnonymousClass2.b(com.tencent.mm.plugin.gwallet.a.c, android.content.Intent):void");
            }
        };
        bVar.aBu("launchPurchaseFlow");
        if (!"inapp".equals("subs") || bVar.yho) {
            try {
                Log.d("MicroMsg.IabHelper", "Constructing buy intent for " + stringExtra + ", item type: " + "inapp" + ", extraData: " + stringExtra2);
                Bundle a2 = bVar.yhl.a(3, bVar.mContext.getPackageName(), stringExtra, "inapp", stringExtra2);
                int ao = b.ao(a2);
                if (ao != 0) {
                    r11.b(new c(ao, "Unable to buy item"), null);
                    AppMethodBeat.o(64584);
                    return;
                }
                Log.d("MicroMsg.IabHelper", "Launching buy intent for " + stringExtra + ". Request code: 10001");
                bVar.mRequestCode = 10001;
                bVar.yhp = r11;
                bVar.yhq = "inapp";
                gWalletUI.startIntentSenderForResult(((PendingIntent) a2.getParcelable("BUY_INTENT")).getIntentSender(), 10001, new Intent(), 0, 0, 0);
                AppMethodBeat.o(64584);
            } catch (IntentSender.SendIntentException e2) {
                b.aBv("SendIntentException while launching purchase flow for sku ".concat(String.valueOf(stringExtra)));
                Log.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
                r11.b(new c(-1004, "Failed to send intent."), null);
                AppMethodBeat.o(64584);
            } catch (RemoteException e3) {
                b.aBv("RemoteException while launching purchase flow for sku ".concat(String.valueOf(stringExtra)));
                Log.printErrStackTrace("MicroMsg.IabHelper", e3, "", new Object[0]);
                r11.b(new c(-1001, "Remote exception while starting purchase flow"), null);
                AppMethodBeat.o(64584);
            }
        } else {
            r11.b(new c(-1009, "Subscriptions are not available."), null);
            AppMethodBeat.o(64584);
        }
    }
}
