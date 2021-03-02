package com.tencent.matrix.resource;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.e.b;
import com.tencent.matrix.g.c;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import org.json.JSONObject;

public class CanaryResultService extends MatrixJobIntentService {
    public static void c(Context context, String str, String str2) {
        Intent intent = new Intent(context, CanaryResultService.class);
        intent.setAction("com.tencent.matrix.resource.result.action.REPORT_HPROF_RESULT");
        intent.putExtra("RESULT_PATH", str);
        intent.putExtra("RESULT_ACTIVITY", str2);
        a(context, CanaryResultService.class, -84148994, intent);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.matrix.resource.MatrixJobIntentService
    public final void l(Intent intent) {
        if (intent != null && "com.tencent.matrix.resource.result.action.REPORT_HPROF_RESULT".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("RESULT_PATH");
            String stringExtra2 = intent.getStringExtra("RESULT_ACTIVITY");
            if (stringExtra == null || stringExtra.isEmpty() || stringExtra2 == null || stringExtra2.isEmpty()) {
                c.e("Matrix.CanaryResultService", "resultPath or activityName is null or empty, skip reporting.", new Object[0]);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultZipPath", stringExtra);
                jSONObject.put(EnvConsts.ACTIVITY_MANAGER_SRVNAME, stringExtra2);
                b Y = com.tencent.matrix.b.RG().Y(b.class);
                if (Y != null) {
                    Y.onDetectIssue(new com.tencent.matrix.report.c(jSONObject));
                }
            } catch (Throwable th) {
                c.printErrStackTrace("Matrix.CanaryResultService", th, "unexpected exception, skip reporting.", new Object[0]);
            }
        }
    }
}
