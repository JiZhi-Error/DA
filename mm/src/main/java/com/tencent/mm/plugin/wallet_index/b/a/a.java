package com.tencent.mm.plugin.wallet_index.b.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_index.c.c;
import com.tencent.mm.plugin.wallet_index.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import org.json.JSONException;

public final class a {

    /* renamed from: com.tencent.mm.plugin.wallet_index.b.a.a$a  reason: collision with other inner class name */
    public interface AbstractC1926a {
        void a(c cVar, b bVar);
    }

    public static b a(Intent intent, d dVar) {
        AppMethodBeat.i(71800);
        if (intent == null) {
            aBv("Null data in IAB activity result.");
            c cJ = c.cJ(5, "");
            if (dVar != null) {
                dVar.a(cJ, null);
            }
            AppMethodBeat.o(71800);
            return null;
        }
        int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (intExtra == 0) {
            Log.d("MicroMsg.IabResolver", "Successful resultcode from purchase activity.");
            Log.d("MicroMsg.IabResolver", "Purchase data: ".concat(String.valueOf(stringExtra)));
            Log.d("MicroMsg.IabResolver", "Data signature: ".concat(String.valueOf(stringExtra2)));
            Log.d("MicroMsg.IabResolver", "Extras: " + intent.getExtras());
            if (stringExtra == null || stringExtra2 == null) {
                aBv("BUG: either purchaseData or dataSignature is null.");
                c cJ2 = c.cJ(5, "");
                if (dVar != null) {
                    dVar.a(cJ2, null);
                }
                AppMethodBeat.o(71800);
                return null;
            }
            try {
                c cVar = new c("inapp", stringExtra, stringExtra2);
                String str = cVar.rcD;
                Log.d("MicroMsg.IabResolver", "Purchase signature successfully verified.");
                if (dVar != null) {
                    dVar.a(c.cJ(0, ""), cVar);
                }
                b bVar = new b(str, cVar);
                AppMethodBeat.o(71800);
                return bVar;
            } catch (JSONException e2) {
                aBv("Failed to parse purchase data.");
                Log.printErrStackTrace("MicroMsg.IabResolver", e2, "", new Object[0]);
                c cJ3 = c.cJ(5, "");
                if (dVar != null) {
                    dVar.a(cJ3, null);
                }
                AppMethodBeat.o(71800);
                return null;
            }
        } else {
            aBv("Purchase failed. Response: ".concat(String.valueOf(intExtra)));
            c cJ4 = c.cJ(intExtra, "");
            if (dVar != null) {
                dVar.a(cJ4, null);
            }
            AppMethodBeat.o(71800);
            return null;
        }
    }

    public static int a(Intent intent, AbstractC1926a aVar) {
        AppMethodBeat.i(71801);
        b bVar = new b();
        int bh = bh(intent);
        Log.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(bh));
        if (bh != 0) {
            aVar.a(c.cJ(bh, ""), null);
            AppMethodBeat.o(71801);
            return bh;
        } else if (!intent.hasExtra("INAPP_PURCHASE_ITEM_LIST") || !intent.hasExtra("INAPP_PURCHASE_DATA_LIST") || !intent.hasExtra("INAPP_DATA_SIGNATURE_LIST")) {
            aBv("Bundle returned from getPurchases() doesn't contain required fields.");
            aVar.a(c.cJ(5, ""), null);
            AppMethodBeat.o(71801);
            return 5;
        } else {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayListExtra3 = intent.getStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST");
            for (int i2 = 0; i2 < stringArrayListExtra2.size(); i2++) {
                try {
                    String str = stringArrayListExtra2.get(i2);
                    Log.d("MicroMsg.IabResolver", "Sku is owned: ".concat(String.valueOf(stringArrayListExtra.get(i2))));
                    c cVar = new c("inapp", str, stringArrayListExtra3.get(i2));
                    if (TextUtils.isEmpty(cVar.mToken)) {
                        Log.w("MicroMsg.IabResolver", "In-app billing warning: ".concat(String.valueOf("BUG: empty/null token!")));
                        Log.d("MicroMsg.IabResolver", "Purchase data: ".concat(String.valueOf(str)));
                    }
                    bVar.mPurchaseMap.put(cVar.rcD, cVar);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.IabResolver", e2, "", new Object[0]);
                    aVar.a(c.cJ(5, ""), bVar);
                }
            }
            aVar.a(c.cJ(0, ""), bVar);
            AppMethodBeat.o(71801);
            return 0;
        }
    }

    private static void aBv(String str) {
        AppMethodBeat.i(71802);
        Log.e("MicroMsg.IabResolver", "In-app billing error: ".concat(String.valueOf(str)));
        AppMethodBeat.o(71802);
    }

    public static int bh(Intent intent) {
        AppMethodBeat.i(71803);
        if (intent == null) {
            aBv("Intent with no response code, assuming OK (known issue)");
            AppMethodBeat.o(71803);
            return 1;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            aBv("Intent with no response code, assuming OK (known issue)");
            AppMethodBeat.o(71803);
            return 0;
        } else if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            AppMethodBeat.o(71803);
            return intValue;
        } else if (obj instanceof Long) {
            int longValue = (int) ((Long) obj).longValue();
            AppMethodBeat.o(71803);
            return longValue;
        } else {
            aBv("Unexpected type for intent response code.");
            aBv(obj.getClass().getName());
            RuntimeException runtimeException = new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
            AppMethodBeat.o(71803);
            throw runtimeException;
        }
    }
}
