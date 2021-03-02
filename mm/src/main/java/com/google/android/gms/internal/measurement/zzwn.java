package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzwn {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzbmh = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbmi = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbmj = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzbmk = new AtomicBoolean();
    private static HashMap<String, String> zzbml;
    private static final HashMap<String, Boolean> zzbmm = new HashMap<>();
    private static final HashMap<String, Integer> zzbmn = new HashMap<>();
    private static final HashMap<String, Long> zzbmo = new HashMap<>();
    private static final HashMap<String, Float> zzbmp = new HashMap<>();
    private static Object zzbmq;
    private static boolean zzbmr;
    private static String[] zzbms = new String[0];

    static {
        AppMethodBeat.i(2274);
        AppMethodBeat.o(2274);
    }

    private static <T> T zza(HashMap<String, T> hashMap, String str, T t) {
        AppMethodBeat.i(2273);
        synchronized (zzwn.class) {
            try {
                if (hashMap.containsKey(str)) {
                    T t2 = hashMap.get(str);
                    if (t2 == null) {
                        t2 = t;
                    }
                    return t2;
                }
                AppMethodBeat.o(2273);
                return null;
            } finally {
                AppMethodBeat.o(2273);
            }
        }
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(2268);
        synchronized (zzwn.class) {
            try {
                zza(contentResolver);
                Object obj = zzbmq;
                if (zzbml.containsKey(str)) {
                    String str4 = zzbml.get(str);
                    if (str4 != null) {
                        str3 = str4;
                    }
                } else {
                    String[] strArr = zzbms;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                            if (query != null) {
                                try {
                                    if (query.moveToFirst()) {
                                        String string = query.getString(1);
                                        if (string != null && string.equals(null)) {
                                            string = null;
                                        }
                                        zza(obj, str, string);
                                        if (string != null) {
                                            str3 = string;
                                        }
                                    }
                                } finally {
                                    if (query != null) {
                                        query.close();
                                    }
                                    AppMethodBeat.o(2268);
                                }
                            }
                            zza(obj, str, (String) null);
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.o(2268);
                        } else if (str.startsWith(strArr[i2])) {
                            if (!zzbmr || zzbml.isEmpty()) {
                                zzbml.putAll(zza(contentResolver, zzbms));
                                zzbmr = true;
                                if (zzbml.containsKey(str)) {
                                    String str5 = zzbml.get(str);
                                    if (str5 != null) {
                                        str3 = str5;
                                    }
                                    AppMethodBeat.o(2268);
                                }
                            }
                            AppMethodBeat.o(2268);
                        } else {
                            i2++;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(2268);
            }
        }
        return str3;
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        AppMethodBeat.i(2271);
        Cursor query = contentResolver.query(zzbmh, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            AppMethodBeat.o(2271);
        } else {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                    AppMethodBeat.o(2271);
                }
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        AppMethodBeat.i(2267);
        if (zzbml == null) {
            zzbmk.set(false);
            zzbml = new HashMap<>();
            zzbmq = new Object();
            zzbmr = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzwo(null));
            AppMethodBeat.o(2267);
            return;
        }
        if (zzbmk.getAndSet(false)) {
            zzbml.clear();
            zzbmm.clear();
            zzbmn.clear();
            zzbmo.clear();
            zzbmp.clear();
            zzbmq = new Object();
            zzbmr = false;
        }
        AppMethodBeat.o(2267);
    }

    private static void zza(Object obj, String str, String str2) {
        AppMethodBeat.i(2269);
        synchronized (zzwn.class) {
            try {
                if (obj == zzbmq) {
                    zzbml.put(str, str2);
                }
            } finally {
                AppMethodBeat.o(2269);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        AppMethodBeat.i(2270);
        Object zzb = zzb(contentResolver);
        Boolean bool = (Boolean) zza(zzbmm, str, Boolean.valueOf(z));
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(2270);
            return booleanValue;
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null && !zza.equals("")) {
            if (zzbmi.matcher(zza).matches()) {
                z = true;
                bool = Boolean.TRUE;
            } else if (zzbmj.matcher(zza).matches()) {
                z = false;
                bool = Boolean.FALSE;
            } else {
                new StringBuilder("attempt to read gservices key ").append(str).append(" (value \"").append(zza).append("\") as boolean");
            }
        }
        HashMap<String, Boolean> hashMap = zzbmm;
        synchronized (zzwn.class) {
            try {
                if (zzb == zzbmq) {
                    hashMap.put(str, bool);
                    zzbml.remove(str);
                }
            } finally {
                AppMethodBeat.o(2270);
            }
        }
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        AppMethodBeat.i(2272);
        synchronized (zzwn.class) {
            try {
                zza(contentResolver);
                obj = zzbmq;
            } finally {
                AppMethodBeat.o(2272);
            }
        }
        return obj;
    }
}
