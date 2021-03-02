package com.tencent.wxa;

import io.flutter.plugin.a.j;

public abstract class a {
    public abstract C2227a a(j jVar);

    public static C2227a hrG() {
        return new C2227a(false, null);
    }

    public static C2227a eI(Object obj) {
        return new C2227a(true, obj);
    }

    /* renamed from: com.tencent.wxa.a$a  reason: collision with other inner class name */
    public static class C2227a {
        Object SxC;
        boolean result;

        public C2227a(boolean z, Object obj) {
            this.result = z;
            this.SxC = obj;
        }
    }
}
