package com.tencent.mm.plugin.messenger.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class c {

    public static class a {
        public String content;
        public int type;

        public a(int i2, String str) {
            this.type = i2;
            this.content = str;
        }
    }

    public static ArrayList<a> aFd(String str) {
        a aVar;
        AppMethodBeat.i(90772);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.SysMsgTemplateParser", "hy: null text!!");
            AppMethodBeat.o(90772);
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        String[] split = str.split("\\$");
        for (int i2 = 0; i2 < split.length; i2++) {
            if (i2 % 2 == 0) {
                aVar = new a(0, split[i2]);
            } else {
                aVar = new a(1, split[i2]);
            }
            arrayList.add(aVar);
        }
        AppMethodBeat.o(90772);
        return arrayList;
    }
}
