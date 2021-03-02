package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.tav.coremedia.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public final class j implements a {
    static {
        AppMethodBeat.i(20186);
        b.a(new j(), "//assert", "//netassert", "//jniassert", "//jnipushassert", "//pushassert", "//anrassert");
        AppMethodBeat.o(20186);
    }

    public static void init() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        char c2;
        AppMethodBeat.i(20185);
        String str2 = strArr[0];
        switch (str2.hashCode()) {
            case -2061874877:
                if (str2.equals("//netassert")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1869906331:
                if (str2.equals("//jnipushassert")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1794206389:
                if (str2.equals("//jniassert")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 918688960:
                if (str2.equals("//pushassert")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 985580427:
                if (str2.equals("//anrassert")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1957466406:
                if (str2.equals("//assert")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                Assert.assertTrue("test errlog " + new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).format(new Date()), false);
                AppMethodBeat.o(20185);
                return true;
            case 1:
                Assert.assertTrue("NetsceneQueue forbid in ", false);
                AppMethodBeat.o(20185);
                return true;
            case 2:
                MMProtocalJni.setClientPackVersion(-1);
                AppMethodBeat.o(20185);
                return true;
            case 3:
                WatchDogPushReceiver.tZ(2);
                AppMethodBeat.o(20185);
                return true;
            case 4:
                WatchDogPushReceiver.tZ(1);
                AppMethodBeat.o(20185);
                return true;
            case 5:
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e2) {
                }
                AppMethodBeat.o(20185);
                return true;
            default:
                AppMethodBeat.o(20185);
                return false;
        }
    }
}
