package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class ToolsProcessIPCService extends BaseIPCService {
    public static final String dkO = (MMApplicationContext.getPackageName() + ":tools");
    static int hnR = 0;
    private static a hnS;

    public interface a {
        boolean ayt();
    }

    static {
        AppMethodBeat.i(225240);
        AppMethodBeat.o(225240);
    }

    @Override // com.tencent.mm.ipcinvoker.BaseIPCService
    public final String getProcessName() {
        return dkO;
    }

    public static boolean ayt() {
        boolean z;
        AppMethodBeat.i(146439);
        if (hnR == 0) {
            a aVar = hnS;
            if (aVar != null) {
                z = aVar.ayt();
            } else {
                z = false;
            }
            if (z) {
                hnR = 1;
            } else {
                hnR = -1;
            }
        }
        if (hnR > 0) {
            AppMethodBeat.o(146439);
            return true;
        }
        AppMethodBeat.o(146439);
        return false;
    }

    public static void a(a aVar) {
        hnS = aVar;
    }

    public static <T extends b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType inputtype, Class<T> cls, d<ResultType> dVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(146440);
        if (MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":tools")) {
            z = h.a(dkO, inputtype, cls, dVar);
        } else {
            z = true;
        }
        if (!ayt() && MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":toolsmp")) {
            if (!h.a(ToolsMpProcessIPCService.dkO, inputtype, cls, dVar) || !z) {
                z2 = false;
            }
            z = z2;
        }
        AppMethodBeat.o(146440);
        return z;
    }

    public static <T extends b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType inputtype, Class<T> cls) {
        AppMethodBeat.i(146441);
        boolean a2 = h.a(dkO, inputtype, cls, null);
        if (!ayt()) {
            a2 = h.a(ToolsMpProcessIPCService.dkO, inputtype, cls, null) && a2;
        }
        AppMethodBeat.o(146441);
        return a2;
    }

    public static <T extends b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(Class<T> cls, d<ResultType> dVar) {
        AppMethodBeat.i(146442);
        boolean a2 = h.a(dkO, null, cls, dVar);
        AppMethodBeat.o(146442);
        return a2;
    }
}
