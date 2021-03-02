package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class a {
    public static AbstractC1686a CXD;
    private static a CXE;
    public boolean jkK = false;

    /* renamed from: com.tencent.mm.plugin.setting.model.a$a  reason: collision with other inner class name */
    public interface AbstractC1686a {
        void Xn(int i2);
    }

    public static a eSG() {
        AppMethodBeat.i(73760);
        if (CXE == null) {
            CXE = new a();
        }
        a aVar = CXE;
        AppMethodBeat.o(73760);
        return aVar;
    }

    public static long agD(String str) {
        AppMethodBeat.i(73761);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        long nowMilliSecond = Util.nowMilliSecond();
        try {
            nowMilliSecond = simpleDateFormat.parse(str).getTime();
        } catch (ParseException e2) {
            Log.e("MicroMsg.FixToolsUplogModel", "dateToTimeStamp failed. date:%s, stack:%s", str, Util.getStack());
        }
        AppMethodBeat.o(73761);
        return nowMilliSecond;
    }
}
