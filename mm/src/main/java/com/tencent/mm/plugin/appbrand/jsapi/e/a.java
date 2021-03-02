package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.xeffect.FaceTracker;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a {
    static a lTL;
    float aTD = -1.0f;
    float aTE = -1.0f;
    e lTM;
    FaceTracker lTN;
    ExecutorService lTO = Executors.newSingleThreadExecutor();
    HashMap<String, Float> lTP = new HashMap<>(1);

    public a() {
        AppMethodBeat.i(226760);
        AppMethodBeat.o(226760);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.a$a  reason: collision with other inner class name */
    public enum EnumC0659a {
        ResultOK,
        ResultNotInit,
        ResultInited,
        ResultInitFail,
        ResultNoLicense,
        ResultFaceDetectedFail,
        ResultStopFail,
        ResultUndefinedError;

        public static EnumC0659a valueOf(String str) {
            AppMethodBeat.i(226758);
            EnumC0659a aVar = (EnumC0659a) Enum.valueOf(EnumC0659a.class, str);
            AppMethodBeat.o(226758);
            return aVar;
        }

        static {
            AppMethodBeat.i(226759);
            AppMethodBeat.o(226759);
        }
    }

    public static synchronized a bGl() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(226761);
            if (lTL == null) {
                lTL = new a();
            }
            aVar = lTL;
            AppMethodBeat.o(226761);
        }
        return aVar;
    }

    public static int a(EnumC0659a aVar) {
        AppMethodBeat.i(226762);
        switch (aVar) {
            case ResultOK:
                AppMethodBeat.o(226762);
                return 0;
            case ResultNotInit:
                AppMethodBeat.o(226762);
                return 1;
            case ResultInited:
                AppMethodBeat.o(226762);
                return 2;
            case ResultInitFail:
                AppMethodBeat.o(226762);
                return 3;
            case ResultNoLicense:
                AppMethodBeat.o(226762);
                return 4;
            case ResultFaceDetectedFail:
                AppMethodBeat.o(226762);
                return 5;
            case ResultStopFail:
                AppMethodBeat.o(226762);
                return 6;
            case ResultUndefinedError:
                AppMethodBeat.o(226762);
                return 7;
            default:
                AppMethodBeat.o(226762);
                return -1;
        }
    }
}
