package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.xwalk.core.Log;

public final class t {
    static boolean SzG;
    static List<String> SzI = new ArrayList();
    static List<String> SzJ = new ArrayList();
    static HashSet<String> SzK = new HashSet<>();
    static HashSet<String> SzL = new HashSet<>();

    public static boolean bsh(String str) {
        AppMethodBeat.i(156763);
        if (!init()) {
            Log.i("UrlDispatcher", "init urldispatcher failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(156763);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            Log.e("UrlDispatcher", "host is empty ".concat(String.valueOf(str)));
            AppMethodBeat.o(156763);
            return false;
        } else {
            String trim = str.trim();
            if (!a(trim, SzK) && !R(trim, SzI)) {
                Log.i("UrlDispatcher", "not in white list ".concat(String.valueOf(trim)));
                AppMethodBeat.o(156763);
                return false;
            } else if (a(trim, SzL) || R(trim, SzJ)) {
                h.s(903, 121, 1);
                Log.i("UrlDispatcher", "dispatch to toolsmp failed in blacklist, host = ".concat(String.valueOf(trim)));
                AppMethodBeat.o(156763);
                return false;
            } else {
                h.s(903, 120, 1);
                Log.i("UrlDispatcher", "dispatch to toolsmp suc, host = ".concat(String.valueOf(trim)));
                AppMethodBeat.o(156763);
                return true;
            }
        }
    }

    public static boolean bsi(String str) {
        AppMethodBeat.i(219043);
        if (a(str, SzL) || R(str, SzJ)) {
            h.s(903, 121, 1);
            Log.i("UrlDispatcher", "isInXWebBlackList dispatch to toolsmp failed in blacklist, host = ".concat(String.valueOf(str)));
            AppMethodBeat.o(219043);
            return true;
        }
        AppMethodBeat.o(219043);
        return false;
    }

    static {
        AppMethodBeat.i(156768);
        init();
        AppMethodBeat.o(156768);
    }

    public static synchronized void refresh() {
        synchronized (t.class) {
            AppMethodBeat.i(219044);
            SzG = false;
            SzI = new ArrayList();
            SzJ = new ArrayList();
            SzK = new HashSet<>();
            SzL = new HashSet<>();
            init();
            AppMethodBeat.o(219044);
        }
    }

    private static synchronized boolean init() {
        boolean z = true;
        synchronized (t.class) {
            AppMethodBeat.i(156764);
            if (SzG) {
                AppMethodBeat.o(156764);
            } else {
                try {
                    String nS = a.nS("white_list_host_suffix", "toolsmp");
                    String nS2 = a.nS("black_list_host_suffix", "toolsmp");
                    String nS3 = a.nS("white_list_host", "toolsmp");
                    String nS4 = a.nS("black_list_host", "toolsmp");
                    SzI.addAll(bsj(nS));
                    SzJ.addAll(bsj(nS2));
                    SzK.addAll(bsj(nS3));
                    SzL.addAll(bsj(nS4));
                    SzG = true;
                } catch (Exception e2) {
                    Log.e("UrlDispatcher", "init failed ");
                }
                z = SzG;
                AppMethodBeat.o(156764);
            }
        }
        return z;
    }

    private static List<String> bsj(String str) {
        AppMethodBeat.i(156765);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(156765);
        } else {
            String[] split = str.split(",");
            if (split == null || split.length == 0) {
                AppMethodBeat.o(156765);
            } else {
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList.add(str2.trim());
                    }
                }
                AppMethodBeat.o(156765);
            }
        }
        return arrayList;
    }

    private static boolean R(String str, List<String> list) {
        AppMethodBeat.i(156766);
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str)) {
                if ("all".equalsIgnoreCase(str2)) {
                    AppMethodBeat.o(156766);
                    return true;
                } else if (!str.endsWith(str2)) {
                    continue;
                } else if (str.length() == str2.length()) {
                    AppMethodBeat.o(156766);
                    return true;
                } else if (str.charAt((str.length() - str2.length()) - 1) == '.') {
                    AppMethodBeat.o(156766);
                    return true;
                }
            }
        }
        AppMethodBeat.o(156766);
        return false;
    }

    private static boolean a(String str, Set<String> set) {
        AppMethodBeat.i(156767);
        if (set.contains(str)) {
            AppMethodBeat.o(156767);
            return true;
        }
        AppMethodBeat.o(156767);
        return false;
    }
}
