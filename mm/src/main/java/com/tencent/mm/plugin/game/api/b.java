package com.tencent.mm.plugin.game.api;

import android.content.Context;

public interface b {
    void NX(int i2);

    void O(long j2, int i2);

    void a(Context context, String str, String str2, String str3, int i2, int i3, int i4, String str4, String str5, String str6);

    void a(Context context, String str, String str2, String str3, int i2, String str4, int i3);

    void a(String str, String str2, int i2, int i3, String str3, int i4);

    void a(String str, String str2, int i2, int i3, String str3, long j2, String str4, int i4);

    void am(String str, int i2, int i3);

    void azk(String str);

    boolean dSE();

    String dSF();

    void fU(Context context);

    void k(Context context, String str, String str2);

    void k(String str, String str2, String str3);

    void pG(boolean z);

    public static class a {
        private static b xtY = null;

        public static void a(b bVar) {
            xtY = bVar;
        }

        public static b dSQ() {
            return xtY;
        }
    }
}
