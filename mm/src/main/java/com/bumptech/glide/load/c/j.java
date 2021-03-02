package com.bumptech.glide.load.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j implements h {
    private volatile Map<String, String> aJY;
    private final Map<String, List<i>> headers;

    j(Map<String, List<i>> map) {
        AppMethodBeat.i(77249);
        this.headers = Collections.unmodifiableMap(map);
        AppMethodBeat.o(77249);
    }

    @Override // com.bumptech.glide.load.c.h
    public final Map<String, String> getHeaders() {
        AppMethodBeat.i(77250);
        if (this.aJY == null) {
            synchronized (this) {
                try {
                    if (this.aJY == null) {
                        HashMap hashMap = new HashMap();
                        for (Map.Entry<String, List<i>> entry : this.headers.entrySet()) {
                            String q = q(entry.getValue());
                            if (!TextUtils.isEmpty(q)) {
                                hashMap.put(entry.getKey(), q);
                            }
                        }
                        this.aJY = Collections.unmodifiableMap(hashMap);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(77250);
                    throw th;
                }
            }
        }
        Map<String, String> map = this.aJY;
        AppMethodBeat.o(77250);
        return map;
    }

    private static String q(List<i> list) {
        AppMethodBeat.i(77251);
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String ps = list.get(i2).ps();
            if (!TextUtils.isEmpty(ps)) {
                sb.append(ps);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(77251);
        return sb2;
    }

    public final String toString() {
        AppMethodBeat.i(77252);
        String str = "LazyHeaders{headers=" + this.headers + '}';
        AppMethodBeat.o(77252);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(77253);
        if (obj instanceof j) {
            boolean equals = this.headers.equals(((j) obj).headers);
            AppMethodBeat.o(77253);
            return equals;
        }
        AppMethodBeat.o(77253);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(77254);
        int hashCode = this.headers.hashCode();
        AppMethodBeat.o(77254);
        return hashCode;
    }

    static final class b implements i {
        private final String value;

        b(String str) {
            this.value = str;
        }

        @Override // com.bumptech.glide.load.c.i
        public final String ps() {
            return this.value;
        }

        public final String toString() {
            AppMethodBeat.i(77246);
            String str = "StringHeaderFactory{value='" + this.value + '\'' + '}';
            AppMethodBeat.o(77246);
            return str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(77247);
            if (obj instanceof b) {
                boolean equals = this.value.equals(((b) obj).value);
                AppMethodBeat.o(77247);
                return equals;
            }
            AppMethodBeat.o(77247);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(77248);
            int hashCode = this.value.hashCode();
            AppMethodBeat.o(77248);
            return hashCode;
        }
    }

    public static final class a {
        private static final String aJZ;
        private static final Map<String, List<i>> aKa;
        boolean aKb = true;
        private boolean aKc = true;
        Map<String, List<i>> headers = aKa;

        static {
            AppMethodBeat.i(77245);
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = property.charAt(i2);
                    if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                        sb.append(charAt);
                    } else {
                        sb.append('?');
                    }
                }
                property = sb.toString();
            }
            aJZ = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(aJZ)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(aJZ)));
            }
            aKa = Collections.unmodifiableMap(hashMap);
            AppMethodBeat.o(77245);
        }
    }
}
