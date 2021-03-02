package com.tencent.mm.plugin.sns.ad.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d {
    public String DrP;
    public String DrQ;
    public List<String> DrR;
    public List<e> DrS;
    public String finderEncryptedTopicId;
    public String finderTopicName;

    public static d w(Map<String, String> map, String str) {
        AppMethodBeat.i(201852);
        if (c.isEmpty(map)) {
            AppMethodBeat.o(201852);
            return null;
        }
        try {
            String str2 = map.get(str + ".finderEncryptedTopicId");
            String str3 = map.get(str + ".finderTopicName");
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                AppMethodBeat.o(201852);
                return null;
            }
            d dVar = new d();
            dVar.finderEncryptedTopicId = str2;
            dVar.finderTopicName = str3;
            dVar.DrP = Util.nullAsNil(map.get(str + ".finderTopicTitle"));
            dVar.DrQ = Util.nullAsNil(map.get(str + ".relationText"));
            dVar.DrR = x(map, str + ".relationAvatarList");
            dVar.DrS = y(map, str + ".finderTopicResList");
            AppMethodBeat.o(201852);
            return dVar;
        } catch (Throwable th) {
            AppMethodBeat.o(201852);
            return null;
        }
    }

    private static List<String> x(Map<String, String> map, String str) {
        AppMethodBeat.i(201853);
        String str2 = map.get(str + ".avatar");
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(201853);
            return null;
        }
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(str2);
        int i2 = 1;
        while (!TextUtils.isEmpty(map.get(str + ".avatar" + i2)) && i2 < 10) {
            arrayList.add(map.get(str + ".avatar" + i2));
            i2++;
        }
        AppMethodBeat.o(201853);
        return arrayList;
    }

    private static List<e> y(Map<String, String> map, String str) {
        AppMethodBeat.i(201854);
        e z = e.z(map, str + ".finderTopicResInfo");
        if (z == null) {
            AppMethodBeat.o(201854);
            return null;
        }
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(z);
        for (int i2 = 1; i2 < 5; i2++) {
            e z2 = e.z(map, str + ".finderTopicResInfo" + i2);
            if (z2 == null) {
                break;
            }
            arrayList.add(z2);
        }
        AppMethodBeat.o(201854);
        return arrayList;
    }
}
