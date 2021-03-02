package com.tencent.mm.plugin.expt.d.a;

import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.plugin.expt.d.e.c;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.List;
import org.apache.commons.b.g;

public abstract class a implements c {
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c A[SYNTHETIC, Splitter:B:16:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mm.plugin.expt.d.a.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.expt.d.e.a r8) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.d.a.a.a(com.tencent.mm.plugin.expt.d.e.a):void");
    }

    @Override // com.tencent.mm.plugin.expt.d.a.c
    public final List<com.tencent.mm.plugin.expt.d.e.a> aol(String str) {
        MultiProcessMMKV VQ;
        List<com.tencent.mm.plugin.expt.d.e.a> list;
        if (g.eP(str) || (VQ = VQ()) == null) {
            return null;
        }
        String aom = aom(str);
        if (g.eP(aom)) {
            return null;
        }
        Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] read key : ".concat(String.valueOf(aom)));
        byte[] decodeBytes = VQ.decodeBytes(aom);
        if (decodeBytes == null || decodeBytes.length <= 0) {
            return null;
        }
        aih aih = new aih();
        try {
            aih.parseFrom(decodeBytes);
            list = c.a(aih);
        } catch (Exception e2) {
            Log.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] read parseFrom : " + aom + ", throw Exception : " + e2.getMessage());
            list = null;
        }
        if (list != null) {
            return list;
        }
        return null;
    }

    @Override // com.tencent.mm.plugin.expt.d.a.c
    public final void clear(String str) {
        MultiProcessMMKV VQ;
        if (!g.eP(str) && (VQ = VQ()) != null) {
            String aom = aom(str);
            if (!g.eP(aom)) {
                Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] clear key : ".concat(String.valueOf(aom)));
                VQ.removeValueForKey(aom);
            }
        }
    }

    @Override // com.tencent.mm.plugin.expt.d.a.c
    public final void clearAll() {
        MultiProcessMMKV VQ = VQ();
        if (VQ != null) {
            Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] clearAll");
            VQ.clearAll();
            if (VQ.totalSize() >= 3145728) {
                VQ.trim();
            }
        }
    }

    private static String aom(String str) {
        if (g.eP(str)) {
            return null;
        }
        return "mmkv_key_data_cache_" + str;
    }

    @Override // com.tencent.mm.plugin.expt.d.a.c
    public final long size() {
        String[] allKeys;
        List<com.tencent.mm.plugin.expt.d.e.a> list;
        long j2;
        long j3 = 0;
        MultiProcessMMKV VQ = VQ();
        if (!(VQ == null || (allKeys = VQ.allKeys()) == null || allKeys.length <= 0)) {
            for (String str : allKeys) {
                byte[] decodeBytes = VQ.decodeBytes(str);
                if (decodeBytes != null && decodeBytes.length > 0) {
                    aih aih = new aih();
                    try {
                        aih.parseFrom(decodeBytes);
                        list = c.a(aih);
                    } catch (Exception e2) {
                        Log.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] read parseFrom : " + str + ", throw Exception : " + e2.getMessage());
                        list = null;
                    }
                    if (list != null) {
                        for (com.tencent.mm.plugin.expt.d.e.a aVar : list) {
                            if (aVar.data != null) {
                                j2 = ((long) aVar.data.length()) + j3;
                            } else {
                                j2 = j3;
                            }
                            j3 = j2;
                        }
                    }
                }
            }
        }
        return j3;
    }

    private MultiProcessMMKV VQ() {
        if (getType() == 2) {
            return b.cMO();
        }
        if (getType() == 1) {
            return b.cMN();
        }
        return null;
    }
}
