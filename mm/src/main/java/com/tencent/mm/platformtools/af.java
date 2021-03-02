package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.e;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public final class af {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final long[] VIRBRATOR_PATTERN = {300, 200, 300, 200};

    public static List<String> k(String[] strArr) {
        AppMethodBeat.i(20719);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(20719);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str);
        }
        AppMethodBeat.o(20719);
        return arrayList;
    }

    public static String getSizeKB(long j2) {
        AppMethodBeat.i(20720);
        if ((j2 >> 20) > 0) {
            String str = (((float) Math.round((((float) j2) * 10.0f) / 1048576.0f)) / 10.0f) + "MB";
            AppMethodBeat.o(20720);
            return str;
        } else if ((j2 >> 9) > 0) {
            String str2 = (((float) Math.round((((float) j2) * 10.0f) / 1024.0f)) / 10.0f) + "KB";
            AppMethodBeat.o(20720);
            return str2;
        } else {
            String str3 = j2 + "B";
            AppMethodBeat.o(20720);
            return str3;
        }
    }

    static {
        AppMethodBeat.i(20749);
        AppMethodBeat.o(20749);
    }

    public static String formatSecToMin(int i2) {
        AppMethodBeat.i(20722);
        String format = String.format("%d:%02d", Long.valueOf(((long) i2) / 60), Long.valueOf(((long) i2) % 60));
        AppMethodBeat.o(20722);
        return format;
    }

    public static boolean uT(int i2) {
        AppMethodBeat.i(20731);
        long j2 = ((long) i2) * 1000;
        long currentTimeMillis = j2 - System.currentTimeMillis();
        Log.d("MicroMsg.Util", "time " + j2 + "  systime " + System.currentTimeMillis() + " diff " + currentTimeMillis);
        if (currentTimeMillis < 0) {
            AppMethodBeat.o(20731);
            return true;
        }
        AppMethodBeat.o(20731);
        return false;
    }

    public static void blM() {
        AppMethodBeat.i(20732);
        Log.w("MicroMsg.Util", "memory usage: h=%s/%s, e=%s/%s, n=%s/%s", getSizeKB((long) Debug.getGlobalAllocSize()), getSizeKB((long) (Debug.getGlobalAllocSize() + Debug.getGlobalFreedSize())), getSizeKB((long) Debug.getGlobalExternalAllocSize()), getSizeKB((long) (Debug.getGlobalExternalAllocSize() + Debug.getGlobalExternalFreedSize())), getSizeKB(Debug.getNativeHeapAllocatedSize()), getSizeKB(Debug.getNativeHeapSize()));
        AppMethodBeat.o(20732);
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    public static int i(Integer num) {
        AppMethodBeat.i(20737);
        if (num == null) {
            AppMethodBeat.o(20737);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(20737);
        return intValue;
    }

    public static String nullAs(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static int cm(Object obj) {
        AppMethodBeat.i(20740);
        if (obj == null) {
            AppMethodBeat.o(20740);
            return 0;
        } else if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            AppMethodBeat.o(20740);
            return intValue;
        } else if (obj instanceof Long) {
            int intValue2 = ((Long) obj).intValue();
            AppMethodBeat.o(20740);
            return intValue2;
        } else {
            AppMethodBeat.o(20740);
            return 0;
        }
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(20741);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(20741);
            return true;
        }
        AppMethodBeat.o(20741);
        return false;
    }

    @Deprecated
    public static int getInt(String str, int i2) {
        AppMethodBeat.i(20742);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.parseInt(str);
                    AppMethodBeat.o(20742);
                    return i2;
                }
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
                AppMethodBeat.o(20742);
            }
        }
        AppMethodBeat.o(20742);
        return i2;
    }

    @Deprecated
    public static long Fk(String str) {
        long j2 = -1;
        AppMethodBeat.i(20743);
        if (str == null) {
            try {
                AppMethodBeat.o(20743);
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(20743);
            }
        } else {
            j2 = Long.parseLong(str);
            AppMethodBeat.o(20743);
        }
        return j2;
    }

    public static boolean isLongVertical(int i2, int i3) {
        return ((double) i3) > ((double) i2) * 2.0d;
    }

    public static boolean isLongHorizontal(int i2, int i3) {
        return ((double) i2) > ((double) i3) * 2.0d;
    }

    public static a blN() {
        AppMethodBeat.i(20745);
        a aVar = new a();
        AppMethodBeat.o(20745);
        return aVar;
    }

    public static List<String> bS(String str, String str2) {
        AppMethodBeat.i(20746);
        ArrayList arrayList = null;
        if (str != null) {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            int groupCount = matcher.groupCount();
            arrayList = new ArrayList();
            if (matcher.find()) {
                for (int i2 = 1; i2 <= groupCount; i2++) {
                    arrayList.add(matcher.group(i2));
                }
            }
        }
        AppMethodBeat.o(20746);
        return arrayList;
    }

    public static boolean dA(Context context) {
        boolean z;
        AppMethodBeat.i(20747);
        if (d.elq() != null) {
            d.elq().elo();
        }
        if ((ChannelUtil.updateMode & 1) != 0) {
            Log.e("MicroMsg.Util", "package has set external update mode");
            Uri parse = Uri.parse(ChannelUtil.marketURL);
            Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
            if (!(parse == null || addFlags == null)) {
                if (context.getPackageManager().queryIntentActivities(addFlags, 65536).size() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Log.i("MicroMsg.Util", "parse market uri ok");
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(addFlags);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(20747);
                    return true;
                }
            }
            Log.e("MicroMsg.Util", "parse market uri failed, jump to weixin.qq.com");
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.intent.action.VIEW", Uri.parse(e.OyP)).addFlags(268435456));
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(20747);
            return true;
        }
        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", System.currentTimeMillis() / 1000).commit();
        if (d.elq() != null) {
            com.tencent.mm.plugin.p.a c2 = d.elq().c(context, new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.platformtools.af.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            if (c2 == null) {
                AppMethodBeat.o(20747);
                return false;
            }
            c2.update(3);
        }
        AppMethodBeat.o(20747);
        return true;
    }

    public static boolean a(Context context, View view) {
        boolean z;
        AppMethodBeat.i(20748);
        if (view == null) {
            AppMethodBeat.o(20748);
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(20748);
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(20748);
            return false;
        }
        try {
            z = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.Util", "hide VKB(View) exception %s", e2);
            z = false;
        }
        AppMethodBeat.o(20748);
        return z;
    }

    public static class a {
        public final String toString() {
            AppMethodBeat.i(20716);
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length < 4) {
                AppMethodBeat.o(20716);
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 3; i2 < stackTrace.length; i2++) {
                if (stackTrace[i2].getClassName().contains("com.tencent.mm")) {
                    sb.append("[");
                    sb.append(stackTrace[i2].getClassName().substring(15));
                    sb.append(":");
                    sb.append(stackTrace[i2].getMethodName());
                    sb.append("(" + stackTrace[i2].getLineNumber() + ")]");
                }
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(20716);
            return sb2;
        }
    }
}
