package com.google.android.gms.common.internal;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.ThreadUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Preconditions {
    private Preconditions() {
        AppMethodBeat.i(4728);
        AssertionError assertionError = new AssertionError("Uninstantiable");
        AppMethodBeat.o(4728);
        throw assertionError;
    }

    public static void checkArgument(boolean z) {
        AppMethodBeat.i(4727);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(4727);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4727);
    }

    public static void checkArgument(boolean z, Object obj) {
        AppMethodBeat.i(4725);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
            AppMethodBeat.o(4725);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4725);
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        AppMethodBeat.i(4726);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(str, objArr));
            AppMethodBeat.o(4726);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4726);
    }

    public static int checkElementIndex(int i2, int i3) {
        AppMethodBeat.i(4733);
        int checkElementIndex = checkElementIndex(i2, i3, FirebaseAnalytics.b.INDEX);
        AppMethodBeat.o(4733);
        return checkElementIndex;
    }

    public static int checkElementIndex(int i2, int i3, String str) {
        String format;
        AppMethodBeat.i(4734);
        if (i2 < 0 || i2 >= i3) {
            if (i2 < 0) {
                format = format("%s (%s) must not be negative", str, Integer.valueOf(i2));
            } else if (i3 < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(i3).toString());
                AppMethodBeat.o(4734);
                throw illegalArgumentException;
            } else {
                format = format("%s (%s) must be less than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(format);
            AppMethodBeat.o(4734);
            throw indexOutOfBoundsException;
        }
        AppMethodBeat.o(4734);
        return i2;
    }

    public static void checkHandlerThread(Handler handler) {
        AppMethodBeat.i(4732);
        if (Looper.myLooper() != handler.getLooper()) {
            IllegalStateException illegalStateException = new IllegalStateException("Must be called on the handler thread");
            AppMethodBeat.o(4732);
            throw illegalStateException;
        }
        AppMethodBeat.o(4732);
    }

    public static void checkMainThread(String str) {
        AppMethodBeat.i(4729);
        if (!ThreadUtils.isMainThread()) {
            IllegalStateException illegalStateException = new IllegalStateException(str);
            AppMethodBeat.o(4729);
            throw illegalStateException;
        }
        AppMethodBeat.o(4729);
    }

    public static String checkNotEmpty(String str) {
        AppMethodBeat.i(4714);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given String is empty or null");
            AppMethodBeat.o(4714);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4714);
        return str;
    }

    public static String checkNotEmpty(String str, Object obj) {
        AppMethodBeat.i(4715);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
            AppMethodBeat.o(4715);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4715);
        return str;
    }

    public static void checkNotMainThread() {
        AppMethodBeat.i(4730);
        checkNotMainThread("Must not be called on the main application thread");
        AppMethodBeat.o(4730);
    }

    public static void checkNotMainThread(String str) {
        AppMethodBeat.i(4731);
        if (ThreadUtils.isMainThread()) {
            IllegalStateException illegalStateException = new IllegalStateException(str);
            AppMethodBeat.o(4731);
            throw illegalStateException;
        }
        AppMethodBeat.o(4731);
    }

    public static <T> T checkNotNull(T t) {
        AppMethodBeat.i(4713);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("null reference");
            AppMethodBeat.o(4713);
            throw nullPointerException;
        }
        AppMethodBeat.o(4713);
        return t;
    }

    public static <T> T checkNotNull(T t, Object obj) {
        AppMethodBeat.i(4716);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(String.valueOf(obj));
            AppMethodBeat.o(4716);
            throw nullPointerException;
        }
        AppMethodBeat.o(4716);
        return t;
    }

    public static void checkNotNullIfPresent(String str, ContentValues contentValues) {
        AppMethodBeat.i(4721);
        if (!contentValues.containsKey(str) || contentValues.get(str) != null) {
            AppMethodBeat.o(4721);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(str).concat(" cannot be set to null"));
        AppMethodBeat.o(4721);
        throw illegalArgumentException;
    }

    public static int checkNotZero(int i2) {
        AppMethodBeat.i(4718);
        if (i2 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given Integer is zero");
            AppMethodBeat.o(4718);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4718);
        return i2;
    }

    public static int checkNotZero(int i2, Object obj) {
        AppMethodBeat.i(4717);
        if (i2 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
            AppMethodBeat.o(4717);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4717);
        return i2;
    }

    public static long checkNotZero(long j2) {
        AppMethodBeat.i(4720);
        if (j2 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given Long is zero");
            AppMethodBeat.o(4720);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4720);
        return j2;
    }

    public static long checkNotZero(long j2, Object obj) {
        AppMethodBeat.i(4719);
        if (j2 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
            AppMethodBeat.o(4719);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4719);
        return j2;
    }

    public static int checkPositionIndex(int i2, int i3) {
        AppMethodBeat.i(4735);
        int checkPositionIndex = checkPositionIndex(i2, i3, FirebaseAnalytics.b.INDEX);
        AppMethodBeat.o(4735);
        return checkPositionIndex;
    }

    public static int checkPositionIndex(int i2, int i3, String str) {
        AppMethodBeat.i(4736);
        if (i2 < 0 || i2 > i3) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(zza(i2, i3, str));
            AppMethodBeat.o(4736);
            throw indexOutOfBoundsException;
        }
        AppMethodBeat.o(4736);
        return i2;
    }

    public static void checkPositionIndexes(int i2, int i3, int i4) {
        String str;
        AppMethodBeat.i(4738);
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 < 0 || i2 > i4) {
                str = zza(i2, i4, "start index");
            } else if (i3 < 0 || i3 > i4) {
                str = zza(i3, i4, "end index");
            } else {
                str = format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(str);
            AppMethodBeat.o(4738);
            throw indexOutOfBoundsException;
        }
        AppMethodBeat.o(4738);
    }

    public static void checkState(boolean z) {
        AppMethodBeat.i(4722);
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(4722);
            throw illegalStateException;
        }
        AppMethodBeat.o(4722);
    }

    public static void checkState(boolean z, Object obj) {
        AppMethodBeat.i(4723);
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(obj));
            AppMethodBeat.o(4723);
            throw illegalStateException;
        }
        AppMethodBeat.o(4723);
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        AppMethodBeat.i(4724);
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException(String.format(str, objArr));
            AppMethodBeat.o(4724);
            throw illegalStateException;
        }
        AppMethodBeat.o(4724);
    }

    public static String checkTag(String str) {
        AppMethodBeat.i(4739);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Tag must not be empty or null");
            AppMethodBeat.o(4739);
            throw illegalArgumentException;
        } else if (str.length() > 23) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Tag must not be greater than 23 chars.");
            AppMethodBeat.o(4739);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(4739);
            return str;
        }
    }

    private static String format(String str, Object... objArr) {
        int indexOf;
        AppMethodBeat.i(4740);
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 16));
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length && (indexOf = str.indexOf("%s", i3)) != -1) {
            sb.append(str.substring(i3, indexOf));
            sb.append(objArr[i2]);
            i3 = indexOf + 2;
            i2++;
        }
        sb.append(str.substring(i3));
        if (i2 < objArr.length) {
            sb.append(" [");
            int i4 = i2 + 1;
            sb.append(objArr[i2]);
            while (i4 < objArr.length) {
                sb.append(", ");
                i4++;
                sb.append(objArr[i4]);
            }
            sb.append("]");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(4740);
        return sb2;
    }

    private static String zza(int i2, int i3, String str) {
        AppMethodBeat.i(4737);
        if (i2 < 0) {
            String format = format("%s (%s) must not be negative", str, Integer.valueOf(i2));
            AppMethodBeat.o(4737);
            return format;
        } else if (i3 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(i3).toString());
            AppMethodBeat.o(4737);
            throw illegalArgumentException;
        } else {
            String format2 = format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(4737);
            return format2;
        }
    }
}
