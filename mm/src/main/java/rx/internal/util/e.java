package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.AccessController;
import java.security.PrivilegedAction;

public final class e {
    private static final int Unk;
    private static final boolean Unl;

    static {
        AppMethodBeat.i(90204);
        int hQS = hQS();
        Unk = hQS;
        Unl = hQS != 0;
        AppMethodBeat.o(90204);
    }

    public static boolean isAndroid() {
        return Unl;
    }

    public static int hQR() {
        return Unk;
    }

    private static int hQS() {
        ClassLoader classLoader;
        AppMethodBeat.i(90203);
        try {
            if (System.getSecurityManager() == null) {
                classLoader = ClassLoader.getSystemClassLoader();
            } else {
                classLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
                    /* class rx.internal.util.e.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // java.security.PrivilegedAction
                    public final /* synthetic */ ClassLoader run() {
                        AppMethodBeat.i(90202);
                        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                        AppMethodBeat.o(90202);
                        return systemClassLoader;
                    }
                });
            }
            int intValue = ((Integer) Class.forName("android.os.Build$VERSION", true, classLoader).getField("SDK_INT").get(null)).intValue();
            AppMethodBeat.o(90203);
            return intValue;
        } catch (Exception e2) {
            AppMethodBeat.o(90203);
            return 0;
        }
    }
}
