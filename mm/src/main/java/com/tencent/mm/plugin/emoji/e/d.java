package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.regex.Pattern;

public class d {
    public static d qZz;
    public boolean qZA = false;
    private Pattern qZB = Pattern.compile("_\\d");

    public d() {
        AppMethodBeat.i(108423);
        AppMethodBeat.o(108423);
    }

    public static d cFF() {
        AppMethodBeat.i(108424);
        if (qZz == null) {
            synchronized (d.class) {
                try {
                    qZz = new d();
                } catch (Throwable th) {
                    AppMethodBeat.o(108424);
                    throw th;
                }
            }
        }
        d dVar = qZz;
        AppMethodBeat.o(108424);
        return dVar;
    }

    public final void amj(String str) {
        o[] het;
        AppMethodBeat.i(108425);
        o oVar = new o(str);
        if (oVar.exists() && oVar.isDirectory() && (het = oVar.het()) != null && het.length > 0) {
            for (o oVar2 : het) {
                if (this.qZA) {
                    if (oVar2.isDirectory()) {
                        amj(aa.z(oVar2.mUri));
                    } else {
                        String name = oVar2.getName();
                        if (this.qZB.matcher(name).find() || name.startsWith("temp")) {
                            oVar2.delete();
                        }
                    }
                } else {
                    Log.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
                    AppMethodBeat.o(108425);
                    return;
                }
            }
        }
        AppMethodBeat.o(108425);
    }

    public final void amk(String str) {
        o[] het;
        AppMethodBeat.i(108426);
        o oVar = new o(str);
        if (oVar.exists() && oVar.isDirectory() && (het = oVar.het()) != null && het.length > 0) {
            for (o oVar2 : het) {
                if (oVar2.isDirectory()) {
                    amk(aa.z(oVar2.mUri));
                } else {
                    oVar2.getName();
                    oVar2.delete();
                }
            }
        }
        AppMethodBeat.o(108426);
    }
}
