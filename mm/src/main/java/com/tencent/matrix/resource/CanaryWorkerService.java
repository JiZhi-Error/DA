package com.tencent.matrix.resource;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.resource.analyzer.model.f;

public class CanaryWorkerService extends MatrixJobIntentService {
    public static void a(Context context, f fVar) {
        Intent intent = new Intent(context, CanaryWorkerService.class);
        intent.setAction("com.tencent.matrix.resource.worker.action.SHRINK_HPROF");
        intent.putExtra("com.tencent.matrix.resource.worker.param.HEAPDUMP", fVar);
        a(context, CanaryWorkerService.class, -84148995, intent);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0210 A[SYNTHETIC, Splitter:B:28:0x0210] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0215 A[SYNTHETIC, Splitter:B:31:0x0215] */
    @Override // com.tencent.matrix.resource.MatrixJobIntentService
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(android.content.Intent r19) {
        /*
        // Method dump skipped, instructions count: 607
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.resource.CanaryWorkerService.l(android.content.Intent):void");
    }
}
