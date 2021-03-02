package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class m {
    private static final ThreadLocal<HashMap<String, Long>> DGc = new ThreadLocal<>();

    static {
        AppMethodBeat.i(95195);
        AppMethodBeat.o(95195);
    }

    public static boolean aOH(String str) {
        AppMethodBeat.i(95189);
        SnsInfo aQm = aj.faO().aQm(str);
        boolean a2 = a(aQm, an.C(aQm));
        AppMethodBeat.o(95189);
        return a2;
    }

    public static boolean w(SnsInfo snsInfo) {
        AppMethodBeat.i(95190);
        boolean a2 = a(snsInfo, an.C(snsInfo));
        AppMethodBeat.o(95190);
        return a2;
    }

    public static boolean a(SnsInfo snsInfo, SnsObject snsObject) {
        AppMethodBeat.i(95191);
        if (snsInfo == null) {
            AppMethodBeat.o(95191);
            return true;
        }
        cnc postInfo = snsInfo.getPostInfo();
        if (snsInfo.getTypeFlag() != 21) {
            AppMethodBeat.o(95191);
            return true;
        } else if (postInfo.egZ == 1) {
            AppMethodBeat.o(95191);
            return true;
        } else if (z.aTY().equals(snsInfo.getUserName())) {
            AppMethodBeat.o(95191);
            return true;
        } else {
            if (snsObject.SnsRedEnvelops != null) {
                LinkedList<dzx> linkedList = snsObject.SnsRedEnvelops.Naf;
                if (linkedList == null || linkedList.size() == 0) {
                    AppMethodBeat.o(95191);
                    return false;
                }
                String aTY = z.aTY();
                for (dzx dzx : linkedList) {
                    if (aTY.equals(dzx.Username)) {
                        AppMethodBeat.o(95191);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(95191);
            return false;
        }
    }

    public static long y(SnsInfo snsInfo) {
        AppMethodBeat.i(95193);
        long b2 = b(snsInfo, null);
        AppMethodBeat.o(95193);
        return b2;
    }

    public static long b(SnsInfo snsInfo, SnsObject snsObject) {
        long j2 = 0;
        AppMethodBeat.i(95194);
        if (snsInfo == null) {
            AppMethodBeat.o(95194);
            return 0;
        }
        if (snsObject == null) {
            snsObject = an.C(snsInfo);
        }
        if (snsObject == null) {
            AppMethodBeat.o(95194);
            return 0;
        }
        ear ear = snsObject.SnsRedEnvelops;
        if (ear == null) {
            AppMethodBeat.o(95194);
            return 0;
        }
        LinkedList<dzx> linkedList = ear.Naf;
        if (linkedList == null) {
            AppMethodBeat.o(95194);
            return 0;
        }
        String str = snsInfo.contentByteMd5;
        String str2 = Util.isNullOrNil(str) ? g.getMessageDigest(snsInfo.field_content) + g.getMessageDigest(snsInfo.field_attrBuf) : str;
        HashMap<String, Long> hashMap = DGc.get();
        if (hashMap == null || !hashMap.containsKey(str2)) {
            for (dzx dzx : linkedList) {
                cbd cbd = new cbd();
                try {
                    cbd.parseFrom(com.tencent.mm.platformtools.z.a(dzx.MYW));
                } catch (Exception e2) {
                    Log.e("MicrMsg.SnsLuckyUtil", e2.getMessage() + "hbBuffer is error");
                }
                j2 += cbd.eht;
            }
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put(str2, Long.valueOf(j2));
            DGc.set(hashMap);
            AppMethodBeat.o(95194);
            return j2;
        }
        long longValue = hashMap.get(str2).longValue();
        AppMethodBeat.o(95194);
        return longValue;
    }

    public static int x(SnsInfo snsInfo) {
        AppMethodBeat.i(95192);
        if (snsInfo == null) {
            AppMethodBeat.o(95192);
            return 0;
        }
        SnsObject C = an.C(snsInfo);
        if (C == null) {
            AppMethodBeat.o(95192);
            return 0;
        }
        ear ear = C.SnsRedEnvelops;
        if (ear == null || ear.Naf.size() == 0) {
            AppMethodBeat.o(95192);
            return 0;
        }
        int size = ear.Naf.size();
        AppMethodBeat.o(95192);
        return size;
    }
}
