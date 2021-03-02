package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class i {
    public static String eUQ() {
        AppMethodBeat.i(28306);
        if (!bg.aAc()) {
            Log.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
            AppMethodBeat.o(28306);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        o oVar = new o(sb.append(c.getAccPath()).append("shakemusic/").toString());
        if (!oVar.exists() || !oVar.isDirectory()) {
            Log.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", aa.z(oVar.her()));
            oVar.mkdirs();
        }
        o oVar2 = new o(oVar, FilePathGenerator.NO_MEDIA_FILENAME);
        if (!oVar2.exists()) {
            Log.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", aa.z(oVar.her()));
            try {
                oVar2.createNewFile();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.ShakeMusicLogic", e2, "", new Object[0]);
            }
        }
        if (!oVar.exists()) {
            Log.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
            AppMethodBeat.o(28306);
            return null;
        }
        String str = aa.z(oVar.her()) + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(28306);
        return str;
    }

    public static f e(byte[] bArr, long j2) {
        AppMethodBeat.i(28307);
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(28307);
            return null;
        }
        try {
            dwz dwz = (dwz) new dwz().parseFrom(bArr);
            f fVar = new f();
            fVar.jeT = 4;
            fVar.jeV = String.valueOf(dwz.MWY);
            fVar.jeW = dwz.jeW;
            fVar.jeZ = z.b(dwz.LZW);
            fVar.jfa = z.b(dwz.LZX);
            fVar.jff = a.aKj(fVar.jfa);
            fVar.jeU = dwz.jeU;
            fVar.jfe = z.b(dwz.LZV);
            fVar.jeX = z.b(dwz.MWZ);
            fVar.jeY = z.b(dwz.MXa);
            fVar.jfd = z.b(dwz.MXd);
            fVar.jfb = z.b(dwz.MXb);
            fVar.jfc = z.b(dwz.MXc);
            fVar.jfo = j2;
            AppMethodBeat.o(28307);
            return fVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ShakeMusicLogic", e2, "", new Object[0]);
            Log.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
            AppMethodBeat.o(28307);
            return null;
        }
    }
}
