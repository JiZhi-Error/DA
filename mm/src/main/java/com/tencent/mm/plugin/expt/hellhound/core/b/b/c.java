package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;

public final class c {
    public static void ah(Bundle bundle) {
        AppMethodBeat.i(121992);
        if (bundle == null) {
            AppMethodBeat.o(121992);
            return;
        }
        String string = bundle.getString("Chat_User");
        if (!TextUtils.isEmpty(string)) {
            Log.d("HABBYGE-MALI.FragmentBundleDao", "FragmentBundleDao, putBundle: %s", string);
            go("Chat_User", string);
        }
        AppMethodBeat.o(121992);
    }

    static void go(String str, String str2) {
        cyi cyi;
        AppMethodBeat.i(121993);
        cyi cNX = cNX();
        if (cNX == null) {
            cyi = new cyi();
        } else {
            cyi = cNX;
        }
        Iterator<cgh> it = cyi.MDh.iterator();
        while (true) {
            if (it.hasNext()) {
                cgh next = it.next();
                if (next != null && str.equals(next.key)) {
                    cyi.MDh.remove(next);
                    break;
                }
            } else {
                break;
            }
        }
        cgh cgh = new cgh();
        cgh.key = str;
        cgh.value = str2;
        cyi.MDh.add(cgh);
        try {
            b.o("hell_fgm_bun_mmkv_key", cyi.toByteArray());
            AppMethodBeat.o(121993);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FragmentBundleDao", e2, "FragmentBundleDao writeBack", new Object[0]);
            AppMethodBeat.o(121993);
        }
    }

    public static cyi cNX() {
        AppMethodBeat.i(121994);
        byte[] bytes = b.getBytes("hell_fgm_bun_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(121994);
            return null;
        }
        cyi cyi = new cyi();
        try {
            cyi.parseFrom(bytes);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FragmentBundleDao", e2, "FragmentBundleDao _doRead parse", new Object[0]);
            cyi = null;
        }
        AppMethodBeat.o(121994);
        return cyi;
    }
}
