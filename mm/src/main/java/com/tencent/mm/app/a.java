package com.tencent.mm.app;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.p;

@Deprecated
public final class a {
    private static String cQi = "";
    private static final AbstractC0263a djA = new AbstractC0263a() {
        /* class com.tencent.mm.app.a.AnonymousClass1 */
    };
    private static final b djB = new b() {
        /* class com.tencent.mm.app.a.AnonymousClass2 */
    };
    private static AbstractC0263a djC = djA;
    private static b djD = djB;
    private static int djE = 4500;
    private static int djF = 500;
    private static String djG = "";
    private static boolean djH = true;
    private static boolean djI = false;
    private static int djx = 0;
    private static int djy = 0;
    private static p djz = new p((long) Process.myPid());

    /* renamed from: com.tencent.mm.app.a$a  reason: collision with other inner class name */
    public interface AbstractC0263a {
    }

    public interface b {
    }

    static {
        AppMethodBeat.i(19427);
        AppMethodBeat.o(19427);
    }

    public static void VP() {
    }
}
