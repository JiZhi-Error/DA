package com.tencent.mm.plugin.flash.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;

public final class a {
    public static void dLh() {
        AppMethodBeat.i(186667);
        e.INSTANCE.idkeyStat(1484, 1, 1, false);
        AppMethodBeat.o(186667);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void MS(int i2) {
        AppMethodBeat.i(186668);
        switch (i2) {
            case 1:
                e.INSTANCE.idkeyStat(1484, 5, 1, false);
                AppMethodBeat.o(186668);
                return;
            case 2:
                e.INSTANCE.idkeyStat(1484, 10, 1, false);
                AppMethodBeat.o(186668);
                return;
            case 8:
                e.INSTANCE.idkeyStat(1484, 20, 1, false);
                break;
            case 16:
                e.INSTANCE.idkeyStat(1484, 15, 1, false);
                AppMethodBeat.o(186668);
                return;
        }
        AppMethodBeat.o(186668);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void MT(int i2) {
        AppMethodBeat.i(186669);
        switch (i2) {
            case 1:
                e.INSTANCE.idkeyStat(1484, 6, 1, false);
                AppMethodBeat.o(186669);
                return;
            case 2:
                e.INSTANCE.idkeyStat(1484, 11, 1, false);
                AppMethodBeat.o(186669);
                return;
            case 8:
                e.INSTANCE.idkeyStat(1484, 21, 1, false);
                break;
            case 16:
                e.INSTANCE.idkeyStat(1484, 16, 1, false);
                AppMethodBeat.o(186669);
                return;
        }
        AppMethodBeat.o(186669);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void MU(int i2) {
        AppMethodBeat.i(186670);
        switch (i2) {
            case 1:
                e.INSTANCE.idkeyStat(1484, 7, 1, false);
                AppMethodBeat.o(186670);
                return;
            case 2:
                e.INSTANCE.idkeyStat(1484, 12, 1, false);
                AppMethodBeat.o(186670);
                return;
            case 8:
                e.INSTANCE.idkeyStat(1484, 22, 1, false);
                break;
            case 16:
                e.INSTANCE.idkeyStat(1484, 17, 1, false);
                AppMethodBeat.o(186670);
                return;
        }
        AppMethodBeat.o(186670);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void MV(int i2) {
        AppMethodBeat.i(186671);
        switch (i2) {
            case 1:
                e.INSTANCE.idkeyStat(1484, 8, 1, false);
                AppMethodBeat.o(186671);
                return;
            case 2:
                e.INSTANCE.idkeyStat(1484, 13, 1, false);
                AppMethodBeat.o(186671);
                return;
            case 8:
                e.INSTANCE.idkeyStat(1484, 23, 1, false);
                break;
            case 16:
                e.INSTANCE.idkeyStat(1484, 18, 1, false);
                AppMethodBeat.o(186671);
                return;
        }
        AppMethodBeat.o(186671);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode) {
        AppMethodBeat.i(186672);
        switch (ytSDKKitFrameworkWorkMode) {
            case YT_FW_LIPREAD_TYPE:
                e.INSTANCE.idkeyStat(1484, 9, 1, false);
                AppMethodBeat.o(186672);
                return;
            case YT_FW_REFLECT_TYPE:
                e.INSTANCE.idkeyStat(1484, 14, 1, false);
                AppMethodBeat.o(186672);
                return;
            case YT_FW_ACTION_TYPE:
                e.INSTANCE.idkeyStat(1484, 19, 1, false);
                AppMethodBeat.o(186672);
                return;
            case YT_FW_ACTREFLECT_TYPE:
                e.INSTANCE.idkeyStat(1484, 24, 1, false);
                break;
        }
        AppMethodBeat.o(186672);
    }
}
