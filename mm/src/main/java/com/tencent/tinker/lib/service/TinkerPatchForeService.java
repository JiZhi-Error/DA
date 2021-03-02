package com.tencent.tinker.lib.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.tinker.lib.a;

public class TinkerPatchForeService extends Service {
    public IBinder onBind(Intent intent) {
        return new a.AbstractBinderC2214a() {
            /* class com.tencent.tinker.lib.service.TinkerPatchForeService.AnonymousClass1 */
        };
    }
}
