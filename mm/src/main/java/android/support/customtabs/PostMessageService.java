package android.support.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.customtabs.f;

public class PostMessageService extends Service {
    private f.a gI = new f.a() {
        /* class android.support.customtabs.PostMessageService.AnonymousClass1 */

        @Override // android.support.customtabs.f
        public final void a(d dVar, Bundle bundle) {
            dVar.b(bundle);
        }

        @Override // android.support.customtabs.f
        public final void a(d dVar, String str, Bundle bundle) {
            dVar.c(str, bundle);
        }
    };

    public IBinder onBind(Intent intent) {
        return this.gI;
    }
}
