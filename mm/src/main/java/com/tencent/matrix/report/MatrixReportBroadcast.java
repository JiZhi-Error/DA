package com.tencent.matrix.report;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.d;
import com.tencent.matrix.g.c;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class MatrixReportBroadcast extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            c.e("Matrix.ReportBroadcast", "MatrixReportBroadcast intent == null", new Object[0]);
            return;
        }
        String stringExtra = IntentUtil.getStringExtra(intent, "tag");
        String stringExtra2 = IntentUtil.getStringExtra(intent, "key");
        int intExtra = IntentUtil.getIntExtra(intent, "type", 0);
        String stringExtra3 = IntentUtil.getStringExtra(intent, "value");
        String stringExtra4 = IntentUtil.getStringExtra(intent, "filePath");
        c cVar = new c();
        cVar.tag = stringExtra;
        cVar.key = stringExtra2;
        cVar.type = intExtra;
        try {
            cVar.cWe = new JSONObject(stringExtra3);
        } catch (JSONException e2) {
        }
        h hVar = d.INSTANCE.cPJ;
        if (hVar != null) {
            hVar.a(cVar, stringExtra4);
        }
    }
}
