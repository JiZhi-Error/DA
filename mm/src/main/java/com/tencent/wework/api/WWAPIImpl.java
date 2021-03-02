package com.tencent.wework.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class WWAPIImpl implements IWWAPI {
    private static final ArrayList<String> Sxg = new ArrayList<String>() {
        /* class com.tencent.wework.api.WWAPIImpl.AnonymousClass1 */

        {
            AppMethodBeat.i(106527);
            add("com.tencent.weworklocal");
            add("com.tencent.wework");
            add("com.tencent.wwgovernment");
            AppMethodBeat.o(106527);
        }
    };
    private static final ArrayList<String> Sxh = new ArrayList<String>() {
        /* class com.tencent.wework.api.WWAPIImpl.AnonymousClass2 */

        {
            AppMethodBeat.i(198982);
            add("com.tencent.wework");
            AppMethodBeat.o(198982);
        }
    };
    private static boolean tUq = false;
    private String Sxf;
    private BroadcastReceiver Sxi = new BroadcastReceiver() {
        /* class com.tencent.wework.api.WWAPIImpl.AnonymousClass3 */

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(198984);
            try {
                if (!WWAPIImpl.this.Sxf.equals(intent.getScheme())) {
                    AppMethodBeat.o(198984);
                    return;
                }
                final BaseMessage A = BaseMessage.A(intent.getData());
                A.brz(WWAPIImpl.this.mPreferences.getString("sk", ""));
                A.fromBundle(intent.getExtras());
                if (A instanceof WWBaseRespMessage) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.wework.api.WWAPIImpl.AnonymousClass3.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(198983);
                            try {
                                WWAPIImpl.this.callbacks.get(((WWBaseRespMessage) A).transaction);
                                WWAPIImpl.this.callbacks.remove(((WWBaseRespMessage) A).transaction);
                                AppMethodBeat.o(198983);
                            } catch (Throwable th) {
                                AppMethodBeat.o(198983);
                            }
                        }
                    });
                }
                AppMethodBeat.o(198984);
            } catch (Throwable th) {
                AppMethodBeat.o(198984);
            }
        }
    };
    private Map<String, Object> callbacks = new HashMap();
    private Context context;
    private SharedPreferences mPreferences = null;

    static {
        AppMethodBeat.i(106537);
        AppMethodBeat.o(106537);
    }

    WWAPIImpl(Context context2) {
        AppMethodBeat.i(106530);
        this.context = context2;
        this.mPreferences = context2.getSharedPreferences("wxwork_wwapi_store", 0);
        AppMethodBeat.o(106530);
    }

    @Override // com.tencent.wework.api.IWWAPI
    public final boolean a(IWWAPI.WWAppType wWAppType) {
        return false;
    }

    @Override // com.tencent.wework.api.IWWAPI
    public final String b(IWWAPI.WWAppType wWAppType) {
        return null;
    }

    private int brw(String str) {
        int i2 = 0;
        AppMethodBeat.i(106533);
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(str, 128);
            if (packageInfo == null) {
                AppMethodBeat.o(106533);
            } else {
                i2 = packageInfo.versionCode;
                AppMethodBeat.o(106533);
            }
        } catch (Throwable th) {
            AppMethodBeat.o(106533);
        }
        return i2;
    }

    @Override // com.tencent.wework.api.IWWAPI
    public final boolean a(BaseMessage baseMessage, IWWAPI.WWAppType wWAppType) {
        return false;
    }

    @Override // com.tencent.wework.api.IWWAPI
    public final boolean hrE() {
        int i2;
        AppMethodBeat.i(106531);
        ArrayList<String> arrayList = Sxg;
        if (this.context != null && !TextUtils.equals(this.context.getPackageName(), "com.tencent.mm")) {
            arrayList = Sxh;
        }
        Iterator<String> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            i2 = brw(it.next());
            if (i2 != 0) {
                break;
            }
        }
        if (i2 >= 100) {
            AppMethodBeat.o(106531);
            return true;
        }
        AppMethodBeat.o(106531);
        return false;
    }
}
