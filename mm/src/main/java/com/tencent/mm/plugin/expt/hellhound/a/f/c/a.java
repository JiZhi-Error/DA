package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a {
    public static void aqF(String str) {
        AppMethodBeat.i(122120);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(122120);
            return;
        }
        if (str == null) {
            str = "";
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_async_biz_dao".concat(String.valueOf(uin)), str);
            AppMethodBeat.o(122120);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", e2, "AsyncBizDao._write crash: %s", e2.getMessage());
            AppMethodBeat.o(122120);
        }
    }

    public static String cQi() {
        AppMethodBeat.i(122121);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(122121);
            return "-1";
        }
        String string = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_async_biz_dao".concat(String.valueOf(uin)));
        if (string == null || string.isEmpty()) {
            AppMethodBeat.o(122121);
            return null;
        }
        AppMethodBeat.o(122121);
        return string;
    }

    public static void h(Set<String> set) {
        AppMethodBeat.i(122122);
        if (set.isEmpty()) {
            AppMethodBeat.o(122122);
            return;
        }
        List<String> cQj = cQj();
        if (cQj != null && !cQj.isEmpty()) {
            for (String str : set) {
                if (str != null && !cQj.contains(str)) {
                    cQj.add(str);
                }
            }
            dr(cQj);
        } else if (!set.isEmpty()) {
            hi hiVar = new hi();
            hiVar.KKS.addAll(set);
            a(hiVar);
            AppMethodBeat.o(122122);
            return;
        }
        AppMethodBeat.o(122122);
    }

    public static void dq(List<String> list) {
        AppMethodBeat.i(122123);
        for (int size = list.size() - 1; size >= 0; size--) {
            String str = list.get(size);
            if (str == null || str.isEmpty()) {
                list.remove(size);
            } else {
                Long aqx = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqx(str);
                if (aqx != null && System.currentTimeMillis() - aqx.longValue() >= 43200000) {
                    Log.i("HABBYGE-MALI.AsyncBizDao", "AsyncBizDao, _clearHistory: %s", str);
                    list.remove(size);
                }
            }
        }
        AppMethodBeat.o(122123);
    }

    public static void dr(List<String> list) {
        AppMethodBeat.i(122124);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(122124);
            return;
        }
        hi hiVar = new hi();
        hiVar.KKS.addAll(list);
        a(hiVar);
        AppMethodBeat.o(122124);
    }

    public static List<String> cQj() {
        AppMethodBeat.i(122125);
        hi cQk = cQk();
        if (cQk == null) {
            AppMethodBeat.o(122125);
            return null;
        }
        LinkedList<String> linkedList = cQk.KKS;
        AppMethodBeat.o(122125);
        return linkedList;
    }

    private static void a(hi hiVar) {
        AppMethodBeat.i(122126);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(122126);
            return;
        }
        try {
            byte[] byteArray = hiVar.toByteArray();
            if (byteArray == null) {
                try {
                    byteArray = new byte[0];
                } catch (Exception e2) {
                    Log.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", e2, "AsyncBizDao._writeBizId crash: %s", e2.getMessage());
                    AppMethodBeat.o(122126);
                    return;
                }
            }
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_async_bizid_sid".concat(String.valueOf(uin)), byteArray);
            AppMethodBeat.o(122126);
        } catch (IOException e3) {
            Log.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", e3, "AsyncBizDao, putBizIdOfCloudConfig, crash: %s", e3.getMessage());
            AppMethodBeat.o(122126);
        }
    }

    private static hi cQk() {
        AppMethodBeat.i(122127);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(122127);
            return null;
        }
        byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_async_bizid_sid".concat(String.valueOf(uin)));
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(122127);
            return null;
        }
        hi hiVar = new hi();
        try {
            hiVar.parseFrom(bytes);
            AppMethodBeat.o(122127);
            return hiVar;
        } catch (IOException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", e2, "AsyncBizDao, _readBizId, crash: %s", e2.getMessage());
            AppMethodBeat.o(122127);
            return null;
        }
    }
}
