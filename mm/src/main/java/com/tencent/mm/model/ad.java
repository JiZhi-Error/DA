package com.tencent.mm.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ad {
    private static volatile ad iCQ;
    private Map<String, c> iCR = new a((byte) 0);

    public static ad aVe() {
        AppMethodBeat.i(125110);
        if (iCQ == null) {
            synchronized (ad.class) {
                try {
                    if (iCQ == null) {
                        iCQ = new ad();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(125110);
                    throw th;
                }
            }
        }
        ad adVar = iCQ;
        AppMethodBeat.o(125110);
        return adVar;
    }

    private ad() {
        AppMethodBeat.i(125111);
        AppMethodBeat.o(125111);
    }

    private c JU(String str) {
        AppMethodBeat.i(125112);
        c cVar = new c();
        this.iCR.put(str, cVar);
        AppMethodBeat.o(125112);
        return cVar;
    }

    public final b JV(String str) {
        AppMethodBeat.i(125113);
        c cVar = this.iCR.get(str);
        if (cVar != null) {
            b bVar = cVar.iCT;
            AppMethodBeat.o(125113);
            return bVar;
        }
        AppMethodBeat.o(125113);
        return null;
    }

    public final b G(String str, boolean z) {
        AppMethodBeat.i(125114);
        c cVar = this.iCR.get(str);
        if (cVar == null) {
            if (!z) {
                AppMethodBeat.o(125114);
                return null;
            }
            cVar = JU(str);
        }
        b bVar = cVar.iCT;
        AppMethodBeat.o(125114);
        return bVar;
    }

    public final b JW(String str) {
        AppMethodBeat.i(125115);
        c remove = this.iCR.remove(str);
        if (remove != null) {
            b bVar = remove.iCT;
            AppMethodBeat.o(125115);
            return bVar;
        }
        AppMethodBeat.o(125115);
        return null;
    }

    public static String JX(String str) {
        AppMethodBeat.i(125116);
        String str2 = "SessionId@" + str + "#" + System.nanoTime();
        AppMethodBeat.o(125116);
        return str2;
    }

    public String toString() {
        c cVar;
        AppMethodBeat.i(125117);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("DataCenter \nDataStore size : ").append(this.iCR.size());
        LinkedHashSet<Map.Entry> linkedHashSet = new LinkedHashSet(this.iCR.entrySet());
        for (Map.Entry entry : linkedHashSet) {
            if (!(entry == null || (cVar = (c) entry.getValue()) == null)) {
                sb.append("\nDataStore id : ").append((String) entry.getKey());
                sb.append(", CT : ").append(cVar.iCU).append(LocaleUtil.MALAY);
                sb.append(", TTL : ").append((currentTimeMillis - cVar.iCU) / 1000).append("s");
            }
        }
        linkedHashSet.clear();
        String sb2 = sb.toString();
        AppMethodBeat.o(125117);
        return sb2;
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        b iCT = new b();
        long iCU = System.currentTimeMillis();

        c() {
            AppMethodBeat.i(125109);
            AppMethodBeat.o(125109);
        }
    }

    public static class b {
        private Map<String, Object> iCS = new a((byte) 0);

        public b() {
            AppMethodBeat.i(125094);
            AppMethodBeat.o(125094);
        }

        public final Set<String> getKeySet() {
            AppMethodBeat.i(125095);
            Set<String> keySet = this.iCS.keySet();
            AppMethodBeat.o(125095);
            return keySet;
        }

        public final boolean containsKey(String str) {
            AppMethodBeat.i(125096);
            boolean containsKey = this.iCS.containsKey(str);
            AppMethodBeat.o(125096);
            return containsKey;
        }

        public final b l(String str, Object obj) {
            AppMethodBeat.i(125097);
            if (!TextUtils.isEmpty(str)) {
                this.iCS.put(str, obj);
            }
            AppMethodBeat.o(125097);
            return this;
        }

        public final b y(String str, long j2) {
            AppMethodBeat.i(125098);
            if (!TextUtils.isEmpty(str)) {
                this.iCS.put(str, Long.valueOf(j2));
            }
            AppMethodBeat.o(125098);
            return this;
        }

        public final b H(String str, boolean z) {
            AppMethodBeat.i(125099);
            if (!TextUtils.isEmpty(str)) {
                this.iCS.put(str, Boolean.valueOf(z));
            }
            AppMethodBeat.o(125099);
            return this;
        }

        public final b aK(String str, String str2) {
            AppMethodBeat.i(125100);
            if (!TextUtils.isEmpty(str)) {
                this.iCS.put(str, str2);
            }
            AppMethodBeat.o(125100);
            return this;
        }

        public final boolean JY(String str) {
            boolean z;
            AppMethodBeat.i(125101);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.iCS.get(str);
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                    AppMethodBeat.o(125101);
                    return z;
                }
            }
            z = false;
            AppMethodBeat.o(125101);
            return z;
        }

        public final Object get(String str) {
            AppMethodBeat.i(125102);
            Object obj = this.iCS.get(str);
            AppMethodBeat.o(125102);
            return obj;
        }

        public final long Fk(String str) {
            long j2;
            AppMethodBeat.i(125103);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.iCS.get(str);
                if (obj instanceof Long) {
                    j2 = ((Long) obj).longValue();
                    AppMethodBeat.o(125103);
                    return j2;
                }
            }
            j2 = 0;
            AppMethodBeat.o(125103);
            return j2;
        }

        public final int getInt(String str, int i2) {
            AppMethodBeat.i(125104);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.iCS.get(str);
                if (obj instanceof Integer) {
                    i2 = ((Integer) obj).intValue();
                }
            }
            AppMethodBeat.o(125104);
            return i2;
        }

        public final boolean getBoolean(String str, boolean z) {
            AppMethodBeat.i(125105);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.iCS.get(str);
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
            }
            AppMethodBeat.o(125105);
            return z;
        }

        public final String getString(String str, String str2) {
            AppMethodBeat.i(125106);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.iCS.get(str);
                if (obj instanceof String) {
                    str2 = (String) obj;
                }
            }
            AppMethodBeat.o(125106);
            return str2;
        }

        public final <T> T get(String str, T t) {
            AppMethodBeat.i(125107);
            T t2 = (T) get(str);
            if (t2 != null) {
                AppMethodBeat.o(125107);
                return t2;
            }
            AppMethodBeat.o(125107);
            return t;
        }

        public final void recycle() {
            AppMethodBeat.i(125108);
            this.iCS.clear();
            AppMethodBeat.o(125108);
        }
    }

    static class a<K, V> extends ConcurrentHashMap<K, V> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.concurrent.ConcurrentHashMap
        public final V get(Object obj) {
            AppMethodBeat.i(125090);
            if (obj == null) {
                AppMethodBeat.o(125090);
                return null;
            }
            V v = (V) super.get(obj);
            AppMethodBeat.o(125090);
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.concurrent.ConcurrentHashMap
        public final V put(K k, V v) {
            AppMethodBeat.i(125091);
            if (k == null) {
                AppMethodBeat.o(125091);
                return null;
            } else if (v == null) {
                V v2 = (V) super.remove(k);
                AppMethodBeat.o(125091);
                return v2;
            } else {
                V v3 = (V) super.put(k, v);
                AppMethodBeat.o(125091);
                return v3;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.concurrent.ConcurrentHashMap
        public final V remove(Object obj) {
            AppMethodBeat.i(125092);
            if (obj == null) {
                AppMethodBeat.o(125092);
                return null;
            }
            V v = (V) super.remove(obj);
            AppMethodBeat.o(125092);
            return v;
        }

        public final boolean containsValue(Object obj) {
            AppMethodBeat.i(125093);
            if (obj == null) {
                AppMethodBeat.o(125093);
                return false;
            }
            boolean containsValue = super.containsValue(obj);
            AppMethodBeat.o(125093);
            return containsValue;
        }
    }
}
