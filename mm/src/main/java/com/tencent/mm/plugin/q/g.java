package com.tencent.mm.plugin.q;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class g {
    public static String elv() {
        AppMethodBeat.i(26540);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.azM()).append("msgsynchronize/syncFile/").toString();
        AppMethodBeat.o(26540);
        return sb2;
    }

    public static String elw() {
        AppMethodBeat.i(26541);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.azM()).append("msgsynchronize/").toString();
        AppMethodBeat.o(26541);
        return sb2;
    }

    public static String elx() {
        AppMethodBeat.i(26542);
        try {
            StringBuilder sb = new StringBuilder();
            bg.aVF();
            String sb2 = sb.append(c.azM()).append("msgsynchronize.zip").toString();
            o oVar = new o(sb2);
            if (!oVar.exists()) {
                oVar.createNewFile();
            }
            AppMethodBeat.o(26542);
            return sb2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", e2, "", new Object[0]);
            AppMethodBeat.o(26542);
            return "";
        }
    }

    public static void e(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(26543);
        if (TextUtils.isEmpty(str) || bArr == null) {
            Log.e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", str, str2);
            AppMethodBeat.o(26543);
            return;
        }
        int i2 = 3;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                long agv = com.tencent.mm.plugin.backup.b.g.agv(str + str2);
                int f2 = f(str, str2, bArr);
                long agv2 = com.tencent.mm.plugin.backup.b.g.agv(str + str2);
                if (f2 != 0 || agv2 < ((long) bArr.length)) {
                    Log.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", Integer.valueOf(i3), Integer.valueOf(f2), Long.valueOf(agv), Long.valueOf(agv2), Integer.valueOf(bArr.length));
                    i2 = i3;
                } else {
                    AppMethodBeat.o(26543);
                    return;
                }
            } else {
                AppMethodBeat.o(26543);
                return;
            }
        }
    }

    private static int f(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(26544);
        try {
            o oVar = new o(str);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            String str3 = str + FilePathGenerator.ANDROID_DIR_SEP + str2;
            o oVar2 = new o(str3);
            if (!oVar2.exists()) {
                oVar2.createNewFile();
            }
            int e2 = s.e(str3, bArr, bArr.length);
            AppMethodBeat.o(26544);
            return e2;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", e3, "", new Object[0]);
            AppMethodBeat.o(26544);
            return -1;
        }
    }
}
