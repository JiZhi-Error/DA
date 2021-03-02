package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

public abstract class AbstractResultService extends IntentService {
    public abstract void a(a aVar);

    public AbstractResultService() {
        super("TinkerResultService");
    }

    public static void a(Context context, a aVar, String str) {
        if (str == null) {
            throw new TinkerRuntimeException("resultServiceClass is null.");
        }
        try {
            Intent intent = new Intent();
            intent.setClassName(context, str);
            intent.putExtra("result_extra", aVar);
            context.startService(intent);
        } catch (Throwable th) {
            ShareTinkerLog.e("Tinker.AbstractResultService", "run result service fail, exception:".concat(String.valueOf(th)), new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent == null) {
            ShareTinkerLog.e("Tinker.AbstractResultService", "AbstractResultService received a null intent, ignoring.", new Object[0]);
        } else {
            a((a) ShareIntentUtil.getSerializableExtra(intent, "result_extra"));
        }
    }
}
