package com.tencent.mm.ui.matrix.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class c {
    private static Pattern Qnw = Pattern.compile("^((https|http|ftp|rtsp|mms)?://)?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$");

    static {
        AppMethodBeat.i(38932);
        AppMethodBeat.o(38932);
    }

    public static boolean bnL(String str) {
        AppMethodBeat.i(38930);
        boolean matches = Qnw.matcher(str).matches();
        AppMethodBeat.o(38930);
        return matches;
    }

    public static String aol(int i2) {
        AppMethodBeat.i(38931);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("      ");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(38931);
        return sb2;
    }
}
