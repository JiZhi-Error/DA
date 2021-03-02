package com.tencent.mm.m;

import com.tencent.mm.storage.ca;

public interface a {
    boolean DQ(String str);

    String K(String str, int i2);

    void n(ca caVar);

    String o(ca caVar);

    /* renamed from: com.tencent.mm.m.a$a  reason: collision with other inner class name */
    public static class C0409a {
        private static a gCE = null;

        public static void a(a aVar) {
            gCE = aVar;
        }

        public static a anC() {
            return gCE;
        }
    }
}
