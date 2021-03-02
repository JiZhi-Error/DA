package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {
    private static final Pattern lnT = Pattern.compile("(\\$\\{[^\\}]+\\})");

    static {
        AppMethodBeat.i(194477);
        AppMethodBeat.o(194477);
    }

    public static class a {
        public String group;
        public String value;

        a(String str, String str2) {
            this.group = str;
            this.value = str2;
        }

        public final String toString() {
            AppMethodBeat.i(194475);
            String str = "group:" + this.group + ",value:" + this.value;
            AppMethodBeat.o(194475);
            return str;
        }
    }

    public static List<a> aDX(String str) {
        AppMethodBeat.i(194476);
        Matcher matcher = lnT.matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            try {
                String group = matcher.group(0);
                String substring = group.substring(2, group.length() - 1);
                Log.i("MicroMsg.SysMsgTemplateHelper", "parse template, group:%s,value:%s", group, substring);
                arrayList.add(new a(group, substring));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SysMsgTemplateHelper", e2, "parseParams error!", new Object[0]);
            }
        }
        AppMethodBeat.o(194476);
        return arrayList;
    }
}
