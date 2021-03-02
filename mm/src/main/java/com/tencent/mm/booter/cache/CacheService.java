package com.tencent.mm.booter.cache;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CacheService extends Service {
    public void onCreate() {
        AppMethodBeat.i(19916);
        super.onCreate();
        a.prepare();
        AppMethodBeat.o(19916);
    }

    public void onDestroy() {
        AppMethodBeat.i(19917);
        super.onDestroy();
        a.destroy();
        AppMethodBeat.o(19917);
    }

    public IBinder onBind(Intent intent) {
        return a.gnv;
    }
}
