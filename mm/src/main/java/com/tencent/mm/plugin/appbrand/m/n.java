package com.tencent.mm.plugin.appbrand.m;

public interface n extends j {

    public interface a {
        void a(b bVar);
    }

    public static class b {
        public long dqk;
        public long dql;
    }

    void a(String str, String str2, int i2, String str3, a aVar);

    void invokeCallbackHandler(int i2, String str);

    void subscribeHandler(String str, String str2, int i2, String str3);
}
