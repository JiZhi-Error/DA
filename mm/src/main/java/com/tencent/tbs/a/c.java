package com.tencent.tbs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;

public enum c {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    RSl(Integer.MIN_VALUE),
    NONE(Integer.MAX_VALUE);
    

    /* renamed from: h  reason: collision with root package name */
    int f2309h;

    public static c valueOf(String str) {
        AppMethodBeat.i(174264);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(174264);
        return cVar;
    }

    static {
        AppMethodBeat.i(174266);
        AppMethodBeat.o(174266);
    }

    private c(int i2) {
        this.f2309h = i2;
    }

    public static c aqN(int i2) {
        switch (i2) {
            case 2:
                return VERBOSE;
            case 3:
                return DEBUG;
            case 4:
                return INFO;
            case 5:
                return WARN;
            case 6:
                return ERROR;
            default:
                return NONE;
        }
    }

    public static String a(c cVar) {
        String str;
        AppMethodBeat.i(174265);
        switch (cVar) {
            case VERBOSE:
                str = "V";
                break;
            case DEBUG:
                str = QLog.TAG_REPORTLEVEL_DEVELOPER;
                break;
            case INFO:
                str = "I";
                break;
            case WARN:
                str = QLog.TAG_REPORTLEVEL_COLORUSER;
                break;
            case ERROR:
                str = QLog.TAG_REPORTLEVEL_USER;
                break;
            default:
                if (cVar.f2309h >= VERBOSE.f2309h) {
                    str = "E+" + (cVar.f2309h - ERROR.f2309h);
                    break;
                } else {
                    str = "V-" + (VERBOSE.f2309h - cVar.f2309h);
                    break;
                }
        }
        AppMethodBeat.o(174265);
        return str;
    }
}
