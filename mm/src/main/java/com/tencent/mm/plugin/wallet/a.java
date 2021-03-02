package com.tencent.mm.plugin.wallet;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public String HsN = "";
    public StringBuffer HsO = new StringBuffer();
    public int index = 0;

    public a() {
        AppMethodBeat.i(117554);
        AppMethodBeat.o(117554);
    }

    public static a fV(String str, int i2) {
        AppMethodBeat.i(117555);
        a aVar = new a();
        aVar.HsN = str + "," + i2;
        AppMethodBeat.o(117555);
        return aVar;
    }

    public final void k(int i2, Object... objArr) {
        AppMethodBeat.i(117556);
        cG(i2, u(objArr));
        AppMethodBeat.o(117556);
    }

    private static String u(Object... objArr) {
        String str;
        AppMethodBeat.i(117557);
        if (objArr == null || objArr.length <= 0) {
            Log.w("MicroMsg.PayLogReport", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder sb = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.valueOf(objArr[i2])).append(',');
            }
            sb.append(String.valueOf(objArr[length]));
            str = sb.toString();
        }
        AppMethodBeat.o(117557);
        return str;
    }

    public final void cG(int i2, String str) {
        AppMethodBeat.i(117558);
        String format = String.format("{%d, %s, %d, %s},", Integer.valueOf(this.index), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), str);
        this.index++;
        Log.i("MicroMsg.PayLogReport", "test for log ".concat(String.valueOf(format)));
        this.HsO.append(format);
        AppMethodBeat.o(117558);
    }

    public static boolean a(a aVar, Intent intent) {
        AppMethodBeat.i(117559);
        if (aVar == null) {
            AppMethodBeat.o(117559);
            return false;
        }
        intent.putExtra("WECHAT_PAY_LOG_REPORT_INDEX", aVar.index);
        intent.putExtra("WECHAT_PAY_LOG_REPORT_DATA", aVar.HsO.toString());
        intent.putExtra("WECHAT_PAY_LOG_REPORT_BASEIFO", aVar.HsN);
        AppMethodBeat.o(117559);
        return true;
    }

    public static a be(Intent intent) {
        AppMethodBeat.i(117560);
        int intExtra = intent.getIntExtra("WECHAT_PAY_LOG_REPORT_INDEX", -1);
        if (intExtra == -1) {
            AppMethodBeat.o(117560);
            return null;
        }
        a aVar = new a();
        aVar.index = intExtra;
        aVar.HsO = new StringBuffer(Util.nullAs(intent.getStringExtra("WECHAT_PAY_LOG_REPORT_DATA"), ""));
        aVar.HsN = Util.nullAs(intent.getStringExtra("WECHAT_PAY_LOG_REPORT_BASEIFO"), "");
        AppMethodBeat.o(117560);
        return aVar;
    }
}
