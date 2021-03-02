package com.tencent.mm.ag;

import android.util.Pair;
import com.tencent.mm.ag.k;

public interface w {
    Pair<Integer, Long> a(k.b bVar, String str, String str2, String str3, String str4, byte[] bArr);

    public static class a {
        private static w iAI = null;

        public static void a(w wVar) {
            iAI = wVar;
        }

        public static w aSz() {
            return iAI;
        }
    }
}
