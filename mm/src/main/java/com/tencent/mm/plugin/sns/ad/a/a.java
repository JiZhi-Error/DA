package com.tencent.mm.plugin.sns.ad.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import java.util.Map;

public final class a {
    public String finderEncryptedTopicId;
    public String finderTopicName;

    public static a s(Map<String, String> map, String str) {
        AppMethodBeat.i(201848);
        if (c.isEmpty(map)) {
            AppMethodBeat.o(201848);
            return null;
        }
        try {
            String str2 = map.get(str + ".finderEncryptedTopicId");
            String str3 = map.get(str + ".finderTopicName");
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                AppMethodBeat.o(201848);
                return null;
            }
            a aVar = new a();
            aVar.finderEncryptedTopicId = str2;
            aVar.finderTopicName = str3;
            AppMethodBeat.o(201848);
            return aVar;
        } catch (Throwable th) {
            AppMethodBeat.o(201848);
            return null;
        }
    }
}
