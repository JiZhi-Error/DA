package android.support.customtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.c;
import java.util.ArrayList;

public final class b {
    public final Bundle gv;
    public final Intent intent;

    public /* synthetic */ b(Intent intent2, Bundle bundle, byte b2) {
        this(intent2, bundle);
    }

    private b(Intent intent2, Bundle bundle) {
        this.intent = intent2;
        this.gv = bundle;
    }

    public static final class a {
        public ArrayList<Bundle> gw;
        public Bundle gx;
        public ArrayList<Bundle> gy;
        public boolean gz;
        public final Intent mIntent;

        public a() {
            this((byte) 0);
        }

        private a(byte b2) {
            this.mIntent = new Intent("android.intent.action.VIEW");
            this.gw = null;
            this.gx = null;
            this.gy = null;
            this.gz = true;
            Bundle bundle = new Bundle();
            c.a(bundle, "android.support.customtabs.extra.SESSION", null);
            this.mIntent.putExtras(bundle);
        }
    }
}
