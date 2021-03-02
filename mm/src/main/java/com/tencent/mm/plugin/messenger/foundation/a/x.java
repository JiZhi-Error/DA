package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abn;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public interface x {
    void a(abn abn, byte[] bArr, boolean z, aa aaVar);

    public static class a {
        private static ConcurrentHashMap<Integer, x> zqd = new ConcurrentHashMap<>();

        static {
            AppMethodBeat.i(43065);
            AppMethodBeat.o(43065);
        }

        public static void a(int i2, x xVar) {
            AppMethodBeat.i(43063);
            Assert.assertTrue(zqd.get(Integer.valueOf(i2)) == null);
            zqd.put(Integer.valueOf(i2), xVar);
            AppMethodBeat.o(43063);
        }

        public static x Qn(int i2) {
            AppMethodBeat.i(43064);
            x xVar = zqd.get(Integer.valueOf(i2));
            AppMethodBeat.o(43064);
            return xVar;
        }
    }
}
