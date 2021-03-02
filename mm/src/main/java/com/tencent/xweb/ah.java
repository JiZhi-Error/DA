package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.xwalk.c;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class ah {
    static c SAO;
    private static boolean SAP = false;
    static boolean SAQ = false;

    public static class a {
        public int errorCode = 0;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r7.equals("SET_INIT_ARG") != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.xweb.ah.a H(java.lang.String r7, java.lang.Object r8) {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.ah.H(java.lang.String, java.lang.Object):com.tencent.xweb.ah$a");
    }

    public static Object m(int i2, Object[] objArr) {
        AppMethodBeat.i(219058);
        try {
            l.a g2 = l.g(WebView.c.WV_KIND_CW);
            if (g2 != null) {
                Object excute = g2.excute("STR_CMD_INVOKE_TO_RUNTIME", new Object[]{Integer.valueOf(i2), objArr});
                AppMethodBeat.o(219058);
                return excute;
            }
        } catch (Exception e2) {
            Log.e("XWebSdk", "invokeExtension failed");
        }
        AppMethodBeat.o(219058);
        return null;
    }

    public static boolean htd() {
        AppMethodBeat.i(219059);
        if (!WebView.isXWalk()) {
            Log.e("XWebSdk", "hasXWebFeature not xwalk now");
            AppMethodBeat.o(219059);
            return false;
        }
        Object m = m(80003, new Object[]{2009});
        if (m instanceof Boolean) {
            boolean booleanValue = ((Boolean) m).booleanValue();
            AppMethodBeat.o(219059);
            return booleanValue;
        }
        AppMethodBeat.o(219059);
        return false;
    }

    public static void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.i(156939);
        if (context == null) {
            try {
                context = XWalkEnvironment.getApplicationContext();
            } catch (Exception e2) {
                Log.e("XWebSdk", "clearAllWebViewCache failed: " + e2.getMessage());
                AppMethodBeat.o(156939);
                return;
            }
        }
        if (context == null) {
            AppMethodBeat.o(156939);
            return;
        }
        l.g(WebView.getCurWebType()).clearAllWebViewCache(context, z);
        AppMethodBeat.o(156939);
    }

    public static synchronized void a(c cVar) {
        synchronized (ah.class) {
            SAO = cVar;
        }
    }

    public static synchronized c hte() {
        c cVar;
        synchronized (ah.class) {
            cVar = SAO;
        }
        return cVar;
    }

    public static synchronized void setSharedPreferenceProvider(ISharedPreferenceProvider iSharedPreferenceProvider) {
        synchronized (ah.class) {
            AppMethodBeat.i(156940);
            XWalkEnvironment.setSharedPreferenceProvider(iSharedPreferenceProvider);
            AppMethodBeat.o(156940);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a5 A[SYNTHETIC, Splitter:B:59:0x01a5] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void htf() {
        /*
        // Method dump skipped, instructions count: 566
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.ah.htf():void");
    }

    public static void htg() {
        AppMethodBeat.i(185176);
        Log.i("XWebSdk", "set wati for xweb = true");
        SAQ = true;
        AppMethodBeat.o(185176);
    }

    public static boolean hth() {
        return SAQ;
    }

    public static boolean ON(long j2) {
        AppMethodBeat.i(219060);
        if (!WebView.isXWalk()) {
            Log.e("XWebSdk", "bind_native_trans is  not xwalk now");
            AppMethodBeat.o(219060);
            return false;
        }
        Long valueOf = Long.valueOf(j2);
        try {
            l.a g2 = l.g(WebView.c.WV_KIND_CW);
            if (g2 == null) {
                AppMethodBeat.o(219060);
                return false;
            }
            g2.excute("STR_CMD_NATIVE_TRANS_INIT", new Object[]{valueOf});
            AppMethodBeat.o(219060);
            return true;
        } catch (Exception e2) {
            Log.e("XWebSdk", "invokeExtension failed");
        }
    }
}
