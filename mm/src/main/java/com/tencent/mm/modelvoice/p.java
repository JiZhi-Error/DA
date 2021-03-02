package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class p {
    public String jsh;
    public boolean jsi;
    public long time;

    public static String b(String str, long j2, boolean z) {
        AppMethodBeat.i(130091);
        String str2 = str + ":" + j2 + ":" + (z ? 1 : 0) + "\n";
        AppMethodBeat.o(130091);
        return str2;
    }

    public final String bie() {
        AppMethodBeat.i(200989);
        String str = this.jsh + ":" + this.time + ":" + (this.jsi ? 1 : 0) + "\n";
        AppMethodBeat.o(200989);
        return str;
    }

    public p(String str) {
        int i2;
        AppMethodBeat.i(130092);
        try {
            String[] split = (str.endsWith("\n") ? str.substring(0, str.length() - 1) : str).split(":");
            if (split.length != 4 || !as.IG(split[0])) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (split.length > i2) {
                this.jsh = split[i2];
            }
            if (split.length > i2 + 1) {
                this.time = Util.getLong(split[i2 + 1], 0);
            }
            if (split.length > i2 + 2) {
                this.jsi = split[i2 + 2].equals("1");
            }
            AppMethodBeat.o(130092);
        } catch (Exception e2) {
            if (this.jsh == null) {
                this.jsh = "";
            }
            this.jsi = false;
            this.time = 0;
            Log.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
            AppMethodBeat.o(130092);
        }
    }

    public final String bhs() {
        return this.jsh;
    }
}
