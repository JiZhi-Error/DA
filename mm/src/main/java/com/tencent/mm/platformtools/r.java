package com.tencent.mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class r {
    private static ConcurrentHashMap<Integer, a> jNf = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(132975);
        AppMethodBeat.o(132975);
    }

    public static final a a(int i2, String str, HashMap<Integer, h.b> hashMap, boolean z) {
        boolean z2;
        AppMethodBeat.i(132974);
        Assert.assertTrue(!Util.isNullOrNil(str) && hashMap != null);
        int hashCode = str.hashCode();
        a aVar = jNf.get(Integer.valueOf(hashCode));
        if (aVar == null) {
            aVar = new a(str, z);
            if (z) {
                g.aAf();
                q.dr(true);
                if (!aVar.b("", str, "", (long) com.tencent.mm.kernel.a.getUin(), hashMap, true)) {
                    b bVar = new b((byte) 0);
                    AppMethodBeat.o(132974);
                    throw bVar;
                }
            } else if (!aVar.a(str, hashMap, false)) {
                b bVar2 = new b((byte) 0);
                AppMethodBeat.o(132974);
                throw bVar2;
            }
            jNf.put(Integer.valueOf(hashCode), aVar);
        } else {
            if (z == aVar.bGA) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(z2);
            long beginTransaction = aVar.beginTransaction(-1);
            for (h.b bVar3 : hashMap.values()) {
                String[] sQLs = bVar3.getSQLs();
                for (String str2 : sQLs) {
                    Log.d("MicroMsg.GeneralDBHelper", "init sql:".concat(String.valueOf(str2)));
                    try {
                        aVar.execSQL(null, str2);
                    } catch (Exception e2) {
                        Assert.assertTrue("CreateTable failed:[" + str2 + "][" + e2.getMessage() + "]", false);
                    }
                }
            }
            aVar.endTransaction(beginTransaction);
        }
        Log.d("MicroMsg.GeneralDBHelper", "addRef %d", Integer.valueOf(i2));
        aVar.jNg.put(i2, true);
        AppMethodBeat.o(132974);
        return aVar;
    }

    public static final class a extends h {
        public final boolean bGA;
        SparseBooleanArray jNg = new SparseBooleanArray();
        private final String path;

        public a(String str, boolean z) {
            AppMethodBeat.i(132970);
            Log.d("MicroMsg.GeneralDBHelper", "create db %s", str);
            this.bGA = z;
            this.path = str;
            AppMethodBeat.o(132970);
        }

        public final void uS(int i2) {
            AppMethodBeat.i(132971);
            Log.d("MicroMsg.GeneralDBHelper", "try close db %d", Integer.valueOf(i2));
            this.jNg.delete(i2);
            if (this.jNg.size() <= 0) {
                Log.d("MicroMsg.GeneralDBHelper", "close db %d succ", Integer.valueOf(i2));
                super.closeDB();
                r.jNf.remove(Integer.valueOf(this.path.hashCode()));
            }
            AppMethodBeat.o(132971);
        }

        @Override // com.tencent.mm.storagebase.h
        @Deprecated
        public final void closeDB() {
            AppMethodBeat.i(132972);
            Log.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", Util.getStack());
            if (this.jNg.size() <= 1) {
                super.closeDB();
            }
            AppMethodBeat.o(132972);
        }

        @Override // com.tencent.mm.storagebase.h
        @Deprecated
        public final void CL(String str) {
            AppMethodBeat.i(132973);
            Log.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
            if (this.jNg.size() <= 1) {
                super.CL(str);
            }
            AppMethodBeat.o(132973);
        }
    }
}
