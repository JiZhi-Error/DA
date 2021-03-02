package com.tencent.matrix;

import android.app.Application;
import com.tencent.matrix.b;
import com.tencent.matrix.g.c;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.report.h;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Objects;

public final class c {
    public static final boolean ENABLE_MATRIX;
    public static final boolean ENABLE_MATRIX_TRACE;

    public interface a {
        c.a RH();

        h RI();

        f RJ();

        h.b RK();

        o RL();

        void a(Application application);

        void a(Application application, b.a aVar, f fVar);

        void b(b bVar);
    }

    static {
        boolean z;
        boolean z2 = false;
        if (BuildInfo.ENABLE_MATRIX || BuildInfo.DEBUG) {
            z = true;
        } else {
            z = false;
        }
        ENABLE_MATRIX = z;
        if (BuildInfo.ENABLE_MATRIX_TRACE || BuildInfo.DEBUG) {
            z2 = true;
        }
        ENABLE_MATRIX_TRACE = z2;
    }

    public static void a(Application application, a aVar) {
        com.tencent.matrix.g.c.i("MicroMsg.MatrixDelegate", "[onBoot] ENABLE_MATRIX=" + ENABLE_MATRIX + ", ENABLE_MATRIX_TRACE=" + ENABLE_MATRIX_TRACE, new Object[0]);
        if (ENABLE_MATRIX) {
            Objects.requireNonNull(aVar);
            aVar.a(application);
            b.a(aVar.RH());
            AppForegroundDelegate.INSTANCE.a(aVar.RL());
            MrsLogic.setStrategyCaller(new com.tencent.matrix.strategy.b());
            f RJ = aVar.RJ();
            h RI = aVar.RI();
            RI.cWu = aVar.RK();
            b.a aVar2 = new b.a(application);
            aVar2.pluginListener = RI;
            aVar.a(application, aVar2, RJ);
            if (aVar2.pluginListener == null) {
                aVar2.pluginListener = new com.tencent.matrix.e.a(aVar2.application);
            }
            b.a(new b(aVar2.application, aVar2.pluginListener, aVar2.cqP, (byte) 0));
            Iterator<com.tencent.matrix.e.b> it = b.RG().cqP.iterator();
            while (it.hasNext()) {
                com.tencent.matrix.e.b next = it.next();
                Log.i("MicroMsg.MatrixDelegate", "[onInitialize] start plugin: ".concat(String.valueOf(next)));
                next.start();
            }
            aVar.b(b.RG());
        }
    }
}
