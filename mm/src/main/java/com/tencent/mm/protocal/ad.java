package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cgg;
import com.tencent.mm.protocal.protobuf.efv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class ad {
    public static byte[] l(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(133138);
        if (bArr == null || bArr.length <= 0) {
            Log.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
            AppMethodBeat.o(133138);
            return bArr2;
        } else if (bArr2 == null || bArr2.length <= 0) {
            Log.e("MicroMsg.SyncKeyUtil", "newKey is null");
            AppMethodBeat.o(133138);
            return null;
        } else {
            PByteArray pByteArray = new PByteArray();
            try {
                if (!MMProtocalJni.mergeSyncKey(bArr, bArr2, pByteArray)) {
                    Log.e("MicroMsg.SyncKeyUtil", "merge key failed");
                    AppMethodBeat.o(133138);
                    return null;
                }
                byte[] bArr3 = pByteArray.value;
                AppMethodBeat.o(133138);
                return bArr3;
            } catch (IncompatibleClassChangeError e2) {
                Log.printErrStackTrace("MicroMsg.Crash", e2, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
                IncompatibleClassChangeError incompatibleClassChangeError = (IncompatibleClassChangeError) new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(e2);
                AppMethodBeat.o(133138);
                throw incompatibleClassChangeError;
            }
        }
    }

    private static Map<Integer, Long> cJ(byte[] bArr) {
        AppMethodBeat.i(133139);
        if (Util.isNullOrNil(bArr)) {
            AppMethodBeat.o(133139);
            return null;
        }
        try {
            efv efv = (efv) new efv().parseFrom(bArr);
            if (efv == null) {
                AppMethodBeat.o(133139);
                return null;
            }
            Log.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + efv.MXU);
            LinkedList<cgg> linkedList = efv.MXV;
            if (linkedList.size() != efv.MXU) {
                AppMethodBeat.o(133139);
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < efv.MXU; i2++) {
                hashMap.put(Integer.valueOf(linkedList.get(i2).Cya), Long.valueOf(Util.MAX_32BIT_VALUE & ((long) linkedList.get(i2).MlT)));
            }
            if (hashMap.size() != efv.MXU) {
                AppMethodBeat.o(133139);
                return null;
            }
            AppMethodBeat.o(133139);
            return hashMap;
        } catch (Exception e2) {
            AppMethodBeat.o(133139);
            return null;
        }
    }

    public static String cK(byte[] bArr) {
        AppMethodBeat.i(133140);
        if (Util.isNullOrNil(bArr)) {
            AppMethodBeat.o(133140);
            return "";
        }
        Map<Integer, Long> cJ = cJ(bArr);
        if (cJ == null || cJ.size() <= 0) {
            AppMethodBeat.o(133140);
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" MsgKey:" + cJ.get(2));
        stringBuffer.append(" profile:" + cJ.get(1));
        stringBuffer.append(" contact:" + cJ.get(3));
        stringBuffer.append(" chatroom:" + cJ.get(11));
        stringBuffer.append(" Bottle:" + cJ.get(7));
        stringBuffer.append(" QContact:" + cJ.get(5));
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(133140);
        return stringBuffer2;
    }

    public static boolean m(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(133141);
        Map<Integer, Long> cJ = cJ(bArr);
        if (cJ == null) {
            Log.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
            AppMethodBeat.o(133141);
            return true;
        }
        Map<Integer, Long> cJ2 = cJ(bArr2);
        if (cJ2 == null) {
            Log.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
            AppMethodBeat.o(133141);
            return false;
        }
        for (Integer num : cJ2.keySet()) {
            Long l = cJ.get(num);
            Long l2 = cJ2.get(num);
            if (l == null) {
                Log.d("MicroMsg.SyncKeyUtil", "dkpush local key null :".concat(String.valueOf(num)));
                AppMethodBeat.o(133141);
                return true;
            }
            Log.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + num + " sv:" + l2 + " lv:" + l);
            if (l2.longValue() > l.longValue()) {
                AppMethodBeat.o(133141);
                return true;
            }
        }
        Log.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
        AppMethodBeat.o(133141);
        return false;
    }
}
