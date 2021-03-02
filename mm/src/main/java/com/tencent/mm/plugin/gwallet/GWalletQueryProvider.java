package com.tencent.mm.plugin.gwallet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class GWalletQueryProvider extends ContentProvider {
    public static final String[] COLUMNS = {"_id", "product_id", "full_price", "product_state", "price_currency", "price_amount"};
    private final String TAG = "MicroMsg.GWalletQueryProvider";
    private Context mContext = null;
    private b ygY = null;
    private boolean ygZ;
    private boolean yha;
    private ArrayList<String> yhb;
    private ArrayList<String> yhc;
    private int yhd;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        AppMethodBeat.i(64567);
        Log.d("MicroMsg.GWalletQueryProvider", "successfully loaded");
        AppMethodBeat.o(64567);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        JSONException e2;
        AppMethodBeat.i(64568);
        synchronized (GWalletQueryProvider.class) {
            try {
                Log.d("MicroMsg.GWalletQueryProvider", "Creating IAB helper.");
                if (strArr2 == null || strArr2.length == 0) {
                    Log.d("MicroMsg.GWalletQueryProvider", "no product id selected or size is 0");
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("no product id selected or size is 0");
                    AppMethodBeat.o(64568);
                    throw illegalArgumentException;
                }
                this.mContext = getContext();
                this.ygY = new b(this.mContext);
                this.ygZ = true;
                this.yha = false;
                this.yhc = new ArrayList<>();
                for (String str3 : strArr2) {
                    this.yhc.add(str3);
                }
                Log.d("MicroMsg.GWalletQueryProvider", "Starting setup.");
                this.ygY.a(new b.a() {
                    /* class com.tencent.mm.plugin.gwallet.GWalletQueryProvider.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.gwallet.a.b.a
                    public final void a(c cVar) {
                        AppMethodBeat.i(64565);
                        Log.d("MicroMsg.GWalletQueryProvider", "Setup finished.");
                        if (!cVar.isSuccess()) {
                            Log.e("MicroMsg.GWalletQueryProvider", "Problem setting up in-app billing: ".concat(String.valueOf(cVar)));
                            GWalletQueryProvider.this.ygZ = false;
                            if (GWalletQueryProvider.this.ygY != null) {
                                GWalletQueryProvider.this.ygY.dispose();
                            }
                            GWalletQueryProvider.this.ygY = null;
                            AppMethodBeat.o(64565);
                            return;
                        }
                        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
                            /* class com.tencent.mm.plugin.gwallet.GWalletQueryProvider.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                            public final boolean doInBackground() {
                                AppMethodBeat.i(64562);
                                GWalletQueryProvider.d(GWalletQueryProvider.this);
                                AppMethodBeat.o(64562);
                                return true;
                            }

                            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                            public final boolean onPostExecute() {
                                AppMethodBeat.i(64563);
                                if (GWalletQueryProvider.this.ygY != null) {
                                    GWalletQueryProvider.this.ygY.dispose();
                                }
                                GWalletQueryProvider.this.ygY = null;
                                AppMethodBeat.o(64563);
                                return true;
                            }

                            public final String toString() {
                                AppMethodBeat.i(64564);
                                String str = super.toString() + "|onIabSetupFinished";
                                AppMethodBeat.o(64564);
                                return str;
                            }
                        });
                        AppMethodBeat.o(64565);
                    }
                });
                long j2 = 0;
                while (j2 <= 30000 && this.ygZ && !this.yha) {
                    try {
                        Thread.sleep(100);
                        j2 += 100;
                    } catch (InterruptedException e3) {
                        Log.e("MicroMsg.GWalletQueryProvider", e3.toString());
                    }
                }
                if (!this.ygZ) {
                    Log.d("MicroMsg.GWalletQueryProvider", "unable to setup");
                    MatrixCursor matrixCursor = new MatrixCursor(COLUMNS);
                    Iterator<String> it = this.yhc.iterator();
                    while (it.hasNext()) {
                        matrixCursor.addRow(new Object[]{0, it.next(), "", 10234, "", ""});
                    }
                    return matrixCursor;
                } else if (j2 > 30000) {
                    Log.d("MicroMsg.GWalletQueryProvider", "time's out");
                    MatrixCursor matrixCursor2 = new MatrixCursor(COLUMNS);
                    Iterator<String> it2 = this.yhc.iterator();
                    while (it2.hasNext()) {
                        matrixCursor2.addRow(new Object[]{0, it2.next(), "", 10235, "", ""});
                    }
                    AppMethodBeat.o(64568);
                    return matrixCursor2;
                } else {
                    Log.d("MicroMsg.GWalletQueryProvider", "successfully queried!");
                    MatrixCursor matrixCursor3 = new MatrixCursor(COLUMNS);
                    if (this.yhd == 0) {
                        int i2 = 0;
                        if (this.yhb != null) {
                            Iterator<String> it3 = this.yhb.iterator();
                            while (it3.hasNext()) {
                                String next = it3.next();
                                if (!Util.isNullOrNil(next)) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(next);
                                        String string = jSONObject.getString("productId");
                                        String string2 = jSONObject.getString(FirebaseAnalytics.b.PRICE);
                                        String string3 = jSONObject.getString("price_currency_code");
                                        String string4 = jSONObject.getString("price_amount_micros");
                                        Object[] objArr = new Object[6];
                                        i2++;
                                        try {
                                            objArr[0] = Integer.valueOf(i2);
                                            objArr[1] = string;
                                            objArr[2] = string2;
                                            objArr[3] = 10232;
                                            objArr[4] = string3;
                                            objArr[5] = string4;
                                            matrixCursor3.addRow(objArr);
                                            this.yhc.remove(string);
                                        } catch (JSONException e4) {
                                            e2 = e4;
                                            Log.d("MicroMsg.GWalletQueryProvider", e2.toString());
                                        }
                                    } catch (JSONException e5) {
                                        e2 = e5;
                                        i2 = i2;
                                        Log.d("MicroMsg.GWalletQueryProvider", e2.toString());
                                    }
                                } else {
                                    i2 = i2;
                                }
                            }
                            i2 = i2;
                        }
                        Iterator<String> it4 = this.yhc.iterator();
                        int i3 = i2;
                        while (it4.hasNext()) {
                            matrixCursor3.addRow(new Object[]{Integer.valueOf(i3), it4.next(), "", 10233, "", ""});
                            i3++;
                        }
                    } else {
                        Iterator<String> it5 = this.yhc.iterator();
                        while (it5.hasNext()) {
                            matrixCursor3.addRow(new Object[]{0, it5.next(), "", 10236, "", ""});
                        }
                    }
                    AppMethodBeat.o(64568);
                    return matrixCursor3;
                }
            } finally {
                AppMethodBeat.o(64568);
            }
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static /* synthetic */ void d(GWalletQueryProvider gWalletQueryProvider) {
        AppMethodBeat.i(64569);
        if (gWalletQueryProvider.ygY != null) {
            gWalletQueryProvider.ygY.a(gWalletQueryProvider.yhc, new b.c() {
                /* class com.tencent.mm.plugin.gwallet.GWalletQueryProvider.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.gwallet.a.b.c
                public final void a(c cVar, Intent intent) {
                    AppMethodBeat.i(64566);
                    Log.d("MicroMsg.GWalletQueryProvider", "query detail done! Result ".concat(String.valueOf(cVar)));
                    GWalletQueryProvider.this.yha = true;
                    GWalletQueryProvider.this.yhb = intent.getStringArrayListExtra("RESPONSE_QUERY_DETAIL_INFO");
                    GWalletQueryProvider.this.yhd = intent.getIntExtra("RESPONSE_CODE", 0);
                    AppMethodBeat.o(64566);
                }
            });
        }
        AppMethodBeat.o(64569);
    }
}
