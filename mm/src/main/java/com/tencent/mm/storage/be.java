package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class be {
    public boolean Opg;
    public String Oph = "";
    private String jsh;
    public boolean jsi;
    public String md5 = "-1";
    public long time;

    public static String a(String str, long j2, boolean z, String str2, boolean z2, String str3) {
        int i2 = 1;
        AppMethodBeat.i(104952);
        StringBuilder append = new StringBuilder().append(str).append(":").append(j2).append(":").append(z ? 1 : 0).append(":").append(str2).append(":").append(str3.replace(":", "*#*")).append(":");
        if (!z2) {
            i2 = 0;
        }
        String sb = append.append(i2).append("\n").toString();
        AppMethodBeat.o(104952);
        return sb;
    }

    public final String bie() {
        int i2 = 1;
        AppMethodBeat.i(104953);
        StringBuilder append = new StringBuilder().append(this.jsh).append(":").append(this.time).append(":").append(this.jsi ? 1 : 0).append(":").append(this.md5).append(":").append(this.Oph).append(":");
        if (!this.Opg) {
            i2 = 0;
        }
        String sb = append.append(i2).append("\n").toString();
        AppMethodBeat.o(104953);
        return sb;
    }

    public be(String str) {
        String str2;
        int i2;
        AppMethodBeat.i(104954);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
            AppMethodBeat.o(104954);
            return;
        }
        try {
            if (str.endsWith("\n")) {
                str2 = str.substring(0, str.length() - 1);
            } else {
                this.Oph = str.replace(":", "*#*");
                str2 = str;
            }
            String[] split = str2.split(":", 6);
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
            if (split.length > i2 + 3) {
                this.md5 = split[i2 + 3];
            }
            if (split.length > i2 + 4) {
                this.Oph = split[i2 + 4].replace("*#*", ":");
            }
            if (split.length > i2 + 5) {
                this.Opg = split[i2 + 5].equals("1");
            }
            AppMethodBeat.o(104954);
        } catch (Exception e2) {
            this.time = 0;
            Log.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", str, Util.stackTraceToString(e2));
            AppMethodBeat.o(104954);
        }
    }

    public static be bkr(String str) {
        AppMethodBeat.i(104955);
        be beVar = new be(str);
        AppMethodBeat.o(104955);
        return beVar;
    }

    public final String bhs() {
        return this.jsh;
    }
}
