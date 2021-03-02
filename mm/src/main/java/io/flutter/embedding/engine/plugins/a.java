package io.flutter.embedding.engine.plugins;

import android.content.Context;
import io.flutter.plugin.a.c;
import io.flutter.plugin.platform.e;

public interface a {

    /* renamed from: io.flutter.embedding.engine.plugins.a$a  reason: collision with other inner class name */
    public interface AbstractC2251a {
        String btc(String str);

        String op(String str, String str2);
    }

    void a(b bVar);

    void b(b bVar);

    public static class b {
        public final c SOH;
        public final e SPA;
        public final AbstractC2251a SPB;
        public final io.flutter.view.c StA;
        public final Context applicationContext;
        public final io.flutter.embedding.engine.a wJi;

        public b(Context context, io.flutter.embedding.engine.a aVar, c cVar, io.flutter.view.c cVar2, e eVar, AbstractC2251a aVar2) {
            this.applicationContext = context;
            this.wJi = aVar;
            this.SOH = cVar;
            this.StA = cVar2;
            this.SPA = eVar;
            this.SPB = aVar2;
        }

        @Deprecated
        public final io.flutter.embedding.engine.a hwW() {
            return this.wJi;
        }

        public final c hwX() {
            return this.SOH;
        }
    }
}
