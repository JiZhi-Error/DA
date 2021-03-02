package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

public final class CrashUtils {
    private static final String[] zzzc = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager zzzd = null;
    private static boolean zzze = false;
    private static boolean zzzf;
    private static boolean zzzg;
    private static int zzzh = -1;
    @GuardedBy("CrashUtils.class")
    private static int zzzi = 0;
    @GuardedBy("CrashUtils.class")
    private static int zzzj = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorDialogData {
        public static final int AVG_CRASH_FREQ = 2;
        public static final int BINDER_CRASH = 268435456;
        public static final int DYNAMITE_CRASH = 536870912;
        public static final int FORCED_SHUSHED_BY_WRAPPER = 4;
        public static final int NONE = 0;
        public static final int POPUP_FREQ = 1;
        public static final int SUPPRESSED = 1073741824;
    }

    public static boolean addDynamiteErrorToDropBox(Context context, Throwable th) {
        AppMethodBeat.i(5157);
        boolean addErrorToDropBoxInternal = addErrorToDropBoxInternal(context, th, 536870912);
        AppMethodBeat.o(5157);
        return addErrorToDropBoxInternal;
    }

    @Deprecated
    public static boolean addErrorToDropBox(Context context, Throwable th) {
        AppMethodBeat.i(5158);
        boolean addDynamiteErrorToDropBox = addDynamiteErrorToDropBox(context, th);
        AppMethodBeat.o(5158);
        return addDynamiteErrorToDropBox;
    }

    public static boolean addErrorToDropBoxInternal(Context context, String str, String str2, int i2) {
        AppMethodBeat.i(5160);
        boolean zza = zza(context, str, str2, i2, null);
        AppMethodBeat.o(5160);
        return zza;
    }

    public static boolean addErrorToDropBoxInternal(Context context, Throwable th, int i2) {
        boolean z;
        AppMethodBeat.i(5159);
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th);
            if (!isPackageSide()) {
                AppMethodBeat.o(5159);
                return false;
            } else if (zzdb() || (th = zza(th)) != null) {
                boolean zza = zza(context, Log.getStackTraceString(th), ProcessUtils.getMyProcessName(), i2, th);
                AppMethodBeat.o(5159);
                return zza;
            } else {
                AppMethodBeat.o(5159);
                return false;
            }
        } catch (Exception e2) {
            try {
                z = zzdb();
            } catch (Exception e3) {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(5159);
                throw e2;
            }
            AppMethodBeat.o(5159);
            return false;
        }
    }

    private static boolean isPackageSide() {
        if (zzze) {
            return zzzf;
        }
        return false;
    }

    public static boolean isSystemClassPrefixInternal(String str) {
        AppMethodBeat.i(5162);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(5162);
            return false;
        }
        for (String str2 : zzzc) {
            if (str.startsWith(str2)) {
                AppMethodBeat.o(5162);
                return true;
            }
        }
        AppMethodBeat.o(5162);
        return false;
    }

    @VisibleForTesting
    public static synchronized void setTestVariables(DropBoxManager dropBoxManager, boolean z, boolean z2, int i2) {
        synchronized (CrashUtils.class) {
            zzze = true;
            zzzd = dropBoxManager;
            zzzg = z;
            zzzf = z2;
            zzzh = i2;
            zzzi = 0;
            zzzj = 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ab, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01ac, code lost:
        r2 = r0;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01c5, code lost:
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018c A[SYNTHETIC, Splitter:B:50:0x018c] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01ab A[ExcHandler: all (r0v24 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:36:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01b0 A[SYNTHETIC, Splitter:B:62:0x01b0] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String zza(android.content.Context r8, java.lang.String r9, java.lang.String r10, int r11) {
        /*
        // Method dump skipped, instructions count: 465
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.CrashUtils.zza(android.content.Context, java.lang.String, java.lang.String, int):java.lang.String");
    }

    @VisibleForTesting
    private static synchronized Throwable zza(Throwable th) {
        Throwable th2;
        synchronized (CrashUtils.class) {
            AppMethodBeat.i(5163);
            LinkedList linkedList = new LinkedList();
            while (th != null) {
                linkedList.push(th);
                th = th.getCause();
            }
            Throwable th3 = null;
            boolean z = false;
            while (!linkedList.isEmpty()) {
                Throwable th4 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th4.getStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
                boolean z2 = z;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    String fileName = stackTraceElement.getFileName();
                    boolean z3 = !TextUtils.isEmpty(fileName) && fileName.startsWith(":com.google.android.gms");
                    z2 |= z3;
                    if (!z3 && !isSystemClassPrefixInternal(className)) {
                        stackTraceElement = new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1);
                    }
                    arrayList.add(stackTraceElement);
                }
                th3 = th3 == null ? new Throwable("<filtered>") : new Throwable("<filtered>", th3);
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                z = z2;
            }
            if (!z) {
                th2 = null;
                AppMethodBeat.o(5163);
            } else {
                AppMethodBeat.o(5163);
                th2 = th3;
            }
        }
        return th2;
    }

    private static synchronized boolean zza(Context context, String str, String str2, int i2, Throwable th) {
        boolean z;
        synchronized (CrashUtils.class) {
            AppMethodBeat.i(5161);
            Preconditions.checkNotNull(context);
            if (!isPackageSide() || Strings.isEmptyOrWhitespace(str)) {
                AppMethodBeat.o(5161);
                z = false;
            } else {
                int hashCode = str.hashCode();
                int hashCode2 = th == null ? zzzj : th.hashCode();
                if (zzzi == hashCode && zzzj == hashCode2) {
                    AppMethodBeat.o(5161);
                    z = false;
                } else {
                    zzzi = hashCode;
                    zzzj = hashCode2;
                    DropBoxManager dropBoxManager = zzzd != null ? zzzd : (DropBoxManager) context.getSystemService("dropbox");
                    if (dropBoxManager == null || !dropBoxManager.isTagEnabled("system_app_crash")) {
                        AppMethodBeat.o(5161);
                        z = false;
                    } else {
                        dropBoxManager.addText("system_app_crash", zza(context, str, str2, i2));
                        z = true;
                        AppMethodBeat.o(5161);
                    }
                }
            }
        }
        return z;
    }

    private static boolean zzdb() {
        if (zzze) {
            return zzzg;
        }
        return false;
    }
}
