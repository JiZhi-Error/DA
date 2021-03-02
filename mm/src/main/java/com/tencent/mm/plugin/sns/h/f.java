package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static String[] DRA = {"{sex", "{username", "{richtext"};
    public static HashMap<String, a> DRB = new HashMap<>();
    public static final Pattern DRz = Pattern.compile("\\{([\\s\\S]*?)\\}");

    static {
        AppMethodBeat.i(96137);
        AppMethodBeat.o(96137);
    }

    enum a {
        OK,
        FAIL;

        public static a valueOf(String str) {
            AppMethodBeat.i(96134);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(96134);
            return aVar;
        }

        static {
            AppMethodBeat.i(96135);
            AppMethodBeat.o(96135);
        }
    }

    public static String a(d.a aVar) {
        boolean z;
        AppMethodBeat.i(96136);
        if (!DRB.containsKey(aVar.DRw)) {
            String str = aVar.DRw;
            if (Util.isNullOrNil(str)) {
                String str2 = aVar.DRv;
                AppMethodBeat.o(96136);
                return str2;
            }
            do {
                Matcher matcher = DRz.matcher(str);
                if (matcher.find()) {
                    int groupCount = matcher.groupCount();
                    String group = matcher.group();
                    Log.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + groupCount + " " + group);
                    str = str.replace(group, "");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= DRA.length) {
                            z = false;
                            continue;
                            break;
                        } else if (group.indexOf(DRA[i2]) >= 0) {
                            z = true;
                            continue;
                            break;
                        } else {
                            i2++;
                        }
                    }
                } else {
                    DRB.put(aVar.DRw, a.OK);
                    String str3 = aVar.DRw;
                    AppMethodBeat.o(96136);
                    return str3;
                }
            } while (z);
            DRB.put(aVar.DRw, a.FAIL);
            String str4 = aVar.DRv;
            AppMethodBeat.o(96136);
            return str4;
        } else if (DRB.get(aVar.DRw) == a.OK) {
            String str5 = aVar.DRw;
            AppMethodBeat.o(96136);
            return str5;
        } else {
            String str6 = aVar.DRv;
            AppMethodBeat.o(96136);
            return str6;
        }
    }
}
