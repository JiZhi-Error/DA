package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzi {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static HashMap<String, String> zzagq;
    private static final Uri zzagv = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final Pattern zzagw = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern zzagx = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzagy = new AtomicBoolean();
    private static final HashMap<String, Boolean> zzagz = new HashMap<>();
    private static final HashMap<String, Integer> zzaha = new HashMap<>();
    private static final HashMap<String, Long> zzahb = new HashMap<>();
    private static final HashMap<String, Float> zzahc = new HashMap<>();
    private static Object zzahd;
    private static boolean zzahe;
    private static String[] zzahf = new String[0];

    static {
        AppMethodBeat.i(5512);
        AppMethodBeat.o(5512);
    }

    public static int getInt(ContentResolver contentResolver, String str, int i2) {
        AppMethodBeat.i(5505);
        Object zzb = zzb(contentResolver);
        Integer num = (Integer) zza(zzaha, str, Integer.valueOf(i2));
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(5505);
            return intValue;
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null) {
            try {
                int parseInt = Integer.parseInt(zza);
                num = Integer.valueOf(parseInt);
                i2 = parseInt;
            } catch (NumberFormatException e2) {
            }
        }
        zza(zzb, zzaha, str, num);
        AppMethodBeat.o(5505);
        return i2;
    }

    public static long getLong(ContentResolver contentResolver, String str, long j2) {
        AppMethodBeat.i(5506);
        Object zzb = zzb(contentResolver);
        Long l = (Long) zza(zzahb, str, Long.valueOf(j2));
        if (l != null) {
            long longValue = l.longValue();
            AppMethodBeat.o(5506);
            return longValue;
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null) {
            try {
                long parseLong = Long.parseLong(zza);
                l = Long.valueOf(parseLong);
                j2 = parseLong;
            } catch (NumberFormatException e2) {
            }
        }
        zza(zzb, zzahb, str, l);
        AppMethodBeat.o(5506);
        return j2;
    }

    private static <T> T zza(HashMap<String, T> hashMap, String str, T t) {
        AppMethodBeat.i(5510);
        synchronized (zzi.class) {
            try {
                if (hashMap.containsKey(str)) {
                    T t2 = hashMap.get(str);
                    if (t2 == null) {
                        t2 = t;
                    }
                    return t2;
                }
                AppMethodBeat.o(5510);
                return null;
            } finally {
                AppMethodBeat.o(5510);
            }
        }
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        AppMethodBeat.i(5503);
        synchronized (zzi.class) {
            try {
                zza(contentResolver);
                Object obj = zzahd;
                if (zzagq.containsKey(str)) {
                    String str3 = zzagq.get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                } else {
                    String[] strArr = zzahf;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                            if (query != null) {
                                try {
                                    if (query.moveToFirst()) {
                                        String string = query.getString(1);
                                        if (string != null && string.equals(str2)) {
                                            string = str2;
                                        }
                                        zza(obj, str, string);
                                        if (string != null) {
                                            str2 = string;
                                        }
                                    }
                                } finally {
                                    if (query != null) {
                                        query.close();
                                    }
                                    AppMethodBeat.o(5503);
                                }
                            }
                            zza(obj, str, (String) null);
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.o(5503);
                        } else if (str.startsWith(strArr[i2])) {
                            if (!zzahe || zzagq.isEmpty()) {
                                zzagq.putAll(zza(contentResolver, zzahf));
                                zzahe = true;
                                if (zzagq.containsKey(str)) {
                                    String str4 = zzagq.get(str);
                                    if (str4 != null) {
                                        str2 = str4;
                                    }
                                    AppMethodBeat.o(5503);
                                }
                            }
                            AppMethodBeat.o(5503);
                        } else {
                            i2++;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(5503);
            }
        }
        return str2;
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        AppMethodBeat.i(5508);
        Cursor query = contentResolver.query(zzagv, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            AppMethodBeat.o(5508);
        } else {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                    AppMethodBeat.o(5508);
                }
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        AppMethodBeat.i(5502);
        if (zzagq == null) {
            zzagy.set(false);
            zzagq = new HashMap<>();
            zzahd = new Object();
            zzahe = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzj(null));
            AppMethodBeat.o(5502);
            return;
        }
        if (zzagy.getAndSet(false)) {
            zzagq.clear();
            zzagz.clear();
            zzaha.clear();
            zzahb.clear();
            zzahc.clear();
            zzahd = new Object();
            zzahe = false;
        }
        AppMethodBeat.o(5502);
    }

    private static void zza(Object obj, String str, String str2) {
        AppMethodBeat.i(5504);
        synchronized (zzi.class) {
            try {
                if (obj == zzahd) {
                    zzagq.put(str, str2);
                }
            } finally {
                AppMethodBeat.o(5504);
            }
        }
    }

    private static <T> void zza(Object obj, HashMap<String, T> hashMap, String str, T t) {
        AppMethodBeat.i(5511);
        synchronized (zzi.class) {
            try {
                if (obj == zzahd) {
                    hashMap.put(str, t);
                    zzagq.remove(str);
                }
            } finally {
                AppMethodBeat.o(5511);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        AppMethodBeat.i(5507);
        Object zzb = zzb(contentResolver);
        Boolean bool = (Boolean) zza(zzagz, str, Boolean.valueOf(z));
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(5507);
            return booleanValue;
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null && !zza.equals("")) {
            if (zzagw.matcher(zza).matches()) {
                z = true;
                bool = Boolean.TRUE;
            } else if (zzagx.matcher(zza).matches()) {
                z = false;
                bool = Boolean.FALSE;
            } else {
                new StringBuilder("attempt to read gservices key ").append(str).append(" (value \"").append(zza).append("\") as boolean");
            }
        }
        zza(zzb, zzagz, str, bool);
        AppMethodBeat.o(5507);
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        AppMethodBeat.i(5509);
        synchronized (zzi.class) {
            try {
                zza(contentResolver);
                obj = zzahd;
            } finally {
                AppMethodBeat.o(5509);
            }
        }
        return obj;
    }
}
