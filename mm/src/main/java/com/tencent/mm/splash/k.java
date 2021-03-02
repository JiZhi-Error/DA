package com.tencent.mm.splash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity;
import java.lang.reflect.Field;

/* access modifiers changed from: package-private */
public final class k extends Instrumentation {
    public Instrumentation NMp;

    public k(Instrumentation instrumentation) {
        AppMethodBeat.i(40679);
        this.NMp = instrumentation;
        gyx();
        AppMethodBeat.o(40679);
    }

    @Override // android.app.Instrumentation
    public final Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        Activity activity;
        AppMethodBeat.i(40680);
        if (h.NLG != null) {
            h.NLG.gn(str);
        }
        if (!h.gyj() || h.gyp().getCanonicalName().equals(str) || h.bim(str) || ExtStorageMigrateAuxActivity.class.getName().equals(str)) {
            Activity newActivity = super.newActivity(classLoader, str, intent);
            d dVar = h.dme;
            if (dVar == null || (activity = dVar.q(newActivity)) == newActivity) {
                activity = newActivity;
            } else {
                h.c("WxSplash.SplashHackInstrumentation", "Activity %s is intercepted by %s.", str, activity);
            }
            if (j.gyw()) {
                h.c("WxSplash.SplashHackInstrumentation", "processing relaunch activity.", new Object[0]);
                intent.putExtra("splash-hack-activity-recreate", true);
            }
            AppMethodBeat.o(40680);
            return activity;
        }
        i iVar = new i();
        iVar.NMc = str;
        h.c("WxSplash.SplashHackInstrumentation", "new splash hack activity. replace activity %s", str);
        h.NLB.add(iVar);
        AppMethodBeat.o(40680);
        return iVar;
    }

    private void gyx() {
        AppMethodBeat.i(40681);
        Field[] declaredFields = Instrumentation.class.getDeclaredFields();
        for (int i2 = 0; i2 < declaredFields.length; i2++) {
            declaredFields[i2].setAccessible(true);
            declaredFields[i2].set(this, declaredFields[i2].get(this.NMp));
        }
        AppMethodBeat.o(40681);
    }
}
