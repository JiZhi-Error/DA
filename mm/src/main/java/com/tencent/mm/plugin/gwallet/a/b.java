package com.tencent.mm.plugin.gwallet.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.vending.billing.IInAppBillingService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public Context mContext;
    public int mRequestCode;
    public IInAppBillingService yhl;
    private ServiceConnection yhm;
    boolean yhn = false;
    public boolean yho = false;
    public AbstractC1430b yhp;
    public String yhq;

    public interface a {
        void a(c cVar);
    }

    /* renamed from: com.tencent.mm.plugin.gwallet.a.b$b  reason: collision with other inner class name */
    public interface AbstractC1430b {
        void b(c cVar, Intent intent);
    }

    public interface c {
        void a(c cVar, Intent intent);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(64593);
        if (this.yhn) {
            IllegalStateException illegalStateException = new IllegalStateException("IAB helper is already set up.");
            AppMethodBeat.o(64593);
            throw illegalStateException;
        }
        Log.d("MicroMsg.IabHelper", "Starting in-app billing setup.");
        this.yhm = new ServiceConnection() {
            /* class com.tencent.mm.plugin.gwallet.a.b.AnonymousClass1 */

            public final void onServiceDisconnected(ComponentName componentName) {
                AppMethodBeat.i(64587);
                b.aBw("Billing service disconnected.");
                b.this.yhl = null;
                AppMethodBeat.o(64587);
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AppMethodBeat.i(64588);
                b.aBw("Billing service connected.");
                b.this.yhl = IInAppBillingService.a.f(iBinder);
                String packageName = b.this.mContext.getPackageName();
                try {
                    b.aBw("Checking for in-app billing 3 support.");
                    int b2 = b.this.yhl.b(3, packageName, "inapp");
                    if (b2 != 0) {
                        if (aVar != null) {
                            aVar.a(new c(b2, "Error checking for billing v3 support."));
                        }
                        b.this.yho = false;
                        AppMethodBeat.o(64588);
                        return;
                    }
                    b.aBw("In-app billing version 3 supported for ".concat(String.valueOf(packageName)));
                    int b3 = b.this.yhl.b(3, packageName, "subs");
                    if (b3 == 0) {
                        b.aBw("Subscriptions AVAILABLE.");
                        b.this.yho = true;
                    } else {
                        b.aBw("Subscriptions NOT AVAILABLE. Response: ".concat(String.valueOf(b3)));
                    }
                    b.this.yhn = true;
                    if (aVar != null) {
                        aVar.a(new c(0, "Setup successful."));
                    }
                    AppMethodBeat.o(64588);
                } catch (RemoteException e2) {
                    if (aVar != null) {
                        aVar.a(new c(-1001, "RemoteException while setting up in-app billing."));
                    }
                    Log.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
                    AppMethodBeat.o(64588);
                }
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (this.mContext == null || this.mContext.getPackageManager() == null || this.mContext.getPackageManager().queryIntentServices(intent, 0) == null || this.mContext.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
            aVar.a(new c(-2001, "Google play not installed!"));
            AppMethodBeat.o(64593);
            return;
        }
        this.mContext.bindService(intent, this.yhm, 1);
        AppMethodBeat.o(64593);
    }

    public final void dispose() {
        AppMethodBeat.i(64594);
        Log.d("MicroMsg.IabHelper", "Disposing.");
        this.yhn = false;
        if (this.yhm != null) {
            Log.d("MicroMsg.IabHelper", "Unbinding from service.");
            try {
                if (this.mContext != null) {
                    this.mContext.unbindService(this.yhm);
                }
            } catch (IllegalArgumentException e2) {
                Log.e("MicroMsg.IabHelper", e2.toString());
            }
            this.yhm = null;
            this.yhl = null;
        }
        AppMethodBeat.o(64594);
    }

    public final void aBu(String str) {
        AppMethodBeat.i(64595);
        if (!this.yhn) {
            Log.e("MicroMsg.IabHelper", "Illegal state for operation (" + str + "): IAB helper is not set up.");
            IllegalStateException illegalStateException = new IllegalStateException("IAB helper is not set up. Can't perform operation: ".concat(String.valueOf(str)));
            AppMethodBeat.o(64595);
            throw illegalStateException;
        }
        AppMethodBeat.o(64595);
    }

    public final boolean a(ArrayList<String> arrayList, c cVar) {
        AppMethodBeat.i(64596);
        aBu("query details");
        Intent intent = new Intent();
        if (arrayList == null || arrayList.size() == 0) {
            Log.e("MicroMsg.IabHelper", "query list is empty!");
            c cVar2 = new c(5, "no query list or is empty");
            intent.putExtra("RESPONSE_CODE", 5);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            cVar.a(cVar2, intent);
            AppMethodBeat.o(64596);
            return true;
        }
        try {
            Log.d("MicroMsg.IabHelper", "query detail list with the size is " + arrayList.size());
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Bundle skuDetails = this.yhl.getSkuDetails(3, this.mContext.getPackageName(), "inapp", bundle);
            int ao = ao(skuDetails);
            Log.d("MicroMsg.IabHelper", "detail response: " + String.valueOf(ao));
            if (ao != 0) {
                Log.d("MicroMsg.IabHelper", "cannot query details");
                c cVar3 = new c(ao, "cannot query details");
                intent.putExtra("RESPONSE_CODE", ao);
                cVar.a(cVar3, intent);
                AppMethodBeat.o(64596);
                return true;
            }
            c cVar4 = new c(ao, "query list ok!");
            Log.d("MicroMsg.IabHelper", "result code : ".concat(String.valueOf(ao)));
            intent.putExtra("RESPONSE_CODE", ao);
            intent.putExtra("RESPONSE_QUERY_DETAIL_INFO", skuDetails.getStringArrayList("DETAILS_LIST"));
            cVar.a(cVar4, intent);
            Iterator<String> it = skuDetails.getStringArrayList("DETAILS_LIST").iterator();
            while (it.hasNext()) {
                Log.d("MicroMsg.IabHelper", it.next());
            }
            AppMethodBeat.o(64596);
            return true;
        } catch (RemoteException e2) {
            aBv("RemoteException while launching query details ");
            Log.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
            c cVar5 = new c(-1001, "Remote exception while starting purchase flow");
            intent.putExtra("RESPONSE_CODE", 6);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            cVar.a(cVar5, intent);
            AppMethodBeat.o(64596);
            return false;
        }
    }

    public static String getResponseDesc(int i2) {
        AppMethodBeat.i(64597);
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split(FilePathGenerator.ANDROID_DIR_SEP);
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split(FilePathGenerator.ANDROID_DIR_SEP);
        if (i2 <= -1000) {
            int i3 = -1000 - i2;
            if (i3 < 0 || i3 >= split2.length) {
                String str = String.valueOf(i2) + ":Unknown IAB Helper Error";
                AppMethodBeat.o(64597);
                return str;
            }
            String str2 = split2[i3];
            AppMethodBeat.o(64597);
            return str2;
        } else if (i2 < 0 || i2 >= split.length) {
            String str3 = String.valueOf(i2) + ":Unknown";
            AppMethodBeat.o(64597);
            return str3;
        } else {
            String str4 = split[i2];
            AppMethodBeat.o(64597);
            return str4;
        }
    }

    public static int ao(Bundle bundle) {
        AppMethodBeat.i(64598);
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            Log.d("MicroMsg.IabHelper", "Bundle with null response code, assuming OK (known issue)");
            AppMethodBeat.o(64598);
            return 0;
        } else if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            AppMethodBeat.o(64598);
            return intValue;
        } else if (obj instanceof Long) {
            int longValue = (int) ((Long) obj).longValue();
            AppMethodBeat.o(64598);
            return longValue;
        } else {
            aBv("Unexpected type for bundle response code.");
            aBv(obj.getClass().getName());
            RuntimeException runtimeException = new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
            AppMethodBeat.o(64598);
            throw runtimeException;
        }
    }

    public static void aBv(String str) {
        AppMethodBeat.i(64599);
        Log.e("MicroMsg.IabHelper", "In-app billing error: ".concat(String.valueOf(str)));
        AppMethodBeat.o(64599);
    }

    static /* synthetic */ void aBw(String str) {
        AppMethodBeat.i(213243);
        Log.d("MicroMsg.IabHelper", str);
        AppMethodBeat.o(213243);
    }

    static /* synthetic */ int a(b bVar, Intent intent, String str) {
        AppMethodBeat.i(64600);
        Log.d("MicroMsg.IabHelper", "Querying owned items, item type: ".concat(String.valueOf(str)));
        Log.d("MicroMsg.IabHelper", "Package name: " + bVar.mContext.getPackageName());
        String str2 = null;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        do {
            Log.d("MicroMsg.IabHelper", "Calling getPurchases with continuation token: ".concat(String.valueOf(str2)));
            Bundle b2 = bVar.yhl.b(3, bVar.mContext.getPackageName(), str, str2);
            int ao = ao(b2);
            Log.d("MicroMsg.IabHelper", "Owned items response: " + String.valueOf(ao));
            if (ao != 0) {
                Log.d("MicroMsg.IabHelper", "getPurchases() failed: ".concat(String.valueOf(ao)));
                AppMethodBeat.o(64600);
                return ao;
            } else if (!b2.containsKey("INAPP_PURCHASE_ITEM_LIST") || !b2.containsKey("INAPP_PURCHASE_DATA_LIST") || !b2.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                aBv("Bundle returned from getPurchases() doesn't contain required fields.");
                AppMethodBeat.o(64600);
                return -1002;
            } else {
                arrayList.addAll(b2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST"));
                arrayList2.addAll(b2.getStringArrayList("INAPP_PURCHASE_DATA_LIST"));
                arrayList3.addAll(b2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST"));
                str2 = b2.getString("INAPP_CONTINUATION_TOKEN");
                Log.d("MicroMsg.IabHelper", "Continuation token: ".concat(String.valueOf(str2)));
            }
        } while (!TextUtils.isEmpty(str2));
        intent.putStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST", arrayList);
        intent.putStringArrayListExtra("INAPP_PURCHASE_DATA_LIST", arrayList2);
        intent.putStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST", arrayList3);
        AppMethodBeat.o(64600);
        return 0;
    }
}
