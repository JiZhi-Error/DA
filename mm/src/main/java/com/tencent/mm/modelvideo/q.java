package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q {
    private String jsh;
    private boolean jsi;
    private long time;

    public static String b(String str, long j2, boolean z) {
        AppMethodBeat.i(126945);
        String str2 = str + ":" + j2 + ":" + (z ? 1 : 0) + "\n";
        AppMethodBeat.o(126945);
        return str2;
    }

    public q(String str) {
        AppMethodBeat.i(126946);
        String[] split = (str.endsWith("\n") ? str.substring(0, str.length() - 1) : str).split(":");
        try {
            if (split.length > 0) {
                this.jsh = split[0];
            }
            if (split.length > 1) {
                this.time = Util.getLong(split[1], 0);
            }
            if (split.length > 2) {
                this.jsi = split[2].equals("1");
            }
            AppMethodBeat.o(126946);
        } catch (Exception e2) {
            if (this.jsh == null) {
                this.jsh = "";
            }
            this.jsi = false;
            this.time = 0;
            Log.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
            AppMethodBeat.o(126946);
        }
    }

    public final String bhs() {
        return this.jsh;
    }
}
