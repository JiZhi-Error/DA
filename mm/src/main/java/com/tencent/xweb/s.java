package com.tencent.xweb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class s {
    static boolean SzG = false;
    static List<a> SzH = new ArrayList();

    public interface a {
        void AN(int i2);

        void AO(int i2);

        void cdG();

        void cdH();

        void cdI();
    }

    static {
        AppMethodBeat.i(185174);
        AppMethodBeat.o(185174);
    }

    public static synchronized void init() {
        synchronized (s.class) {
            AppMethodBeat.i(185167);
            if (SzG) {
                AppMethodBeat.o(185167);
            } else if (XWalkEnvironment.getApplicationContext() == null) {
                AppMethodBeat.o(185167);
            } else {
                try {
                    XWalkEnvironment.getApplicationContext().registerReceiver(new b((byte) 0), new IntentFilter("com.tencent.xweb.update"));
                    SzG = true;
                    AppMethodBeat.o(185167);
                } catch (Exception e2) {
                    Log.e("UpdateListener", "registerReceiver failed exception is " + e2.getMessage());
                    AppMethodBeat.o(185167);
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (s.class) {
            AppMethodBeat.i(185168);
            init();
            if (aVar == null) {
                AppMethodBeat.o(185168);
            } else if (SzH.contains(aVar)) {
                AppMethodBeat.o(185168);
            } else {
                SzH.add(aVar);
                AppMethodBeat.o(185168);
            }
        }
    }

    public static synchronized void b(a aVar) {
        synchronized (s.class) {
            AppMethodBeat.i(219041);
            init();
            if (aVar == null) {
                AppMethodBeat.o(219041);
            } else if (!SzH.contains(aVar)) {
                AppMethodBeat.o(219041);
            } else {
                SzH.remove(aVar);
                AppMethodBeat.o(219041);
            }
        }
    }

    static synchronized void hsw() {
        synchronized (s.class) {
            AppMethodBeat.i(185169);
            for (a aVar : SzH) {
                aVar.cdG();
            }
            AppMethodBeat.o(185169);
        }
    }

    static synchronized void asS(int i2) {
        synchronized (s.class) {
            AppMethodBeat.i(219042);
            for (a aVar : SzH) {
                aVar.AO(i2);
            }
            AppMethodBeat.o(219042);
        }
    }

    static synchronized void asT(int i2) {
        synchronized (s.class) {
            AppMethodBeat.i(185171);
            for (a aVar : SzH) {
                aVar.AN(i2);
            }
            AppMethodBeat.o(185171);
        }
    }

    static synchronized void hsx() {
        synchronized (s.class) {
            AppMethodBeat.i(185172);
            for (a aVar : SzH) {
                aVar.cdH();
            }
            AppMethodBeat.o(185172);
        }
    }

    static synchronized void hsy() {
        synchronized (s.class) {
            AppMethodBeat.i(185173);
            for (a aVar : SzH) {
                aVar.cdI();
            }
            AppMethodBeat.o(185173);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(185166);
            if (!"com.tencent.xweb.update".equals(intent.getAction())) {
                AppMethodBeat.o(185166);
                return;
            }
            String stringExtra = intent.getStringExtra("stage");
            if ("start".equals(stringExtra)) {
                Log.i("updateReicever", "start update");
                s.hsw();
                AppMethodBeat.o(185166);
            } else if ("updating".equals(stringExtra)) {
                int intExtra = intent.getIntExtra("extra_data", 0);
                Log.i("updateReicever", "update progress = ".concat(String.valueOf(intExtra)));
                s.asS(intExtra);
                AppMethodBeat.o(185166);
            } else if ("finished".equals(stringExtra)) {
                int intExtra2 = intent.getIntExtra("extra_data", 0);
                Log.i("updateReicever", "update finished code = ".concat(String.valueOf(intExtra2)));
                s.asT(intExtra2);
                AppMethodBeat.o(185166);
            } else if ("cfg_update".equals(stringExtra)) {
                Log.i("updateReicever", "cfg_update");
                s.hsx();
                AppMethodBeat.o(185166);
            } else {
                if ("plugin_update".equals(stringExtra)) {
                    Log.i("updateReicever", "plugin_update");
                    s.hsy();
                }
                AppMethodBeat.o(185166);
            }
        }
    }
}
