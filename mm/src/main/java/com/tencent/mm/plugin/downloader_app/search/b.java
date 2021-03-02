package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class b {
    String appId;
    String iconUrl;
    String jumpUrl;
    int position;
    String qLO;
    String qLP;
    List<String> qLQ;
    long size;
    int state;
    int type;

    public final boolean equals(Object obj) {
        AppMethodBeat.i(8954);
        if (!(obj instanceof b) || ((b) obj).qLO == null) {
            boolean equals = super.equals(obj);
            AppMethodBeat.o(8954);
            return equals;
        }
        boolean equals2 = ((b) obj).qLO.equals(this.qLO);
        AppMethodBeat.o(8954);
        return equals2;
    }

    public static List<b> eX(Context context) {
        AppMethodBeat.i(8955);
        ArrayList arrayList = new ArrayList();
        String string = context.getSharedPreferences("search_history_href", 0).getString("search_history_list", "");
        if (Util.isNullOrNil(string)) {
            AppMethodBeat.o(8955);
            return arrayList;
        }
        String[] split = string.split(";");
        int i2 = 0;
        for (String str : split) {
            if (!Util.isNullOrNil(str)) {
                b bVar = new b();
                bVar.type = 2;
                bVar.qLO = new String(Base64.decode(str, 0));
                i2++;
                bVar.position = i2;
                arrayList.add(bVar);
            }
        }
        if (!Util.isNullOrNil(arrayList)) {
            b bVar2 = new b();
            bVar2.type = 1;
            arrayList.add(0, bVar2);
        }
        AppMethodBeat.o(8955);
        return arrayList;
    }

    public static void au(Context context, String str) {
        int i2 = 0;
        AppMethodBeat.i(8956);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(8956);
            return;
        }
        av(context, str);
        SharedPreferences sharedPreferences = context.getSharedPreferences("search_history_href", 0);
        String string = sharedPreferences.getString("search_history_list", "");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Base64.encodeToString(str.getBytes(), 0));
        stringBuffer.append(";");
        stringBuffer.append(string);
        String[] split = stringBuffer.toString().split(";");
        stringBuffer.setLength(0);
        while (i2 < split.length && i2 < 10) {
            stringBuffer.append(split[i2]);
            stringBuffer.append(";");
            i2++;
        }
        sharedPreferences.edit().putString("search_history_list", stringBuffer.toString()).commit();
        AppMethodBeat.o(8956);
    }

    public static void av(Context context, String str) {
        AppMethodBeat.i(8957);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(8957);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("search_history_href", 0);
        sharedPreferences.edit().putString("search_history_list", sharedPreferences.getString("search_history_list", "").replace(Base64.encodeToString(str.getBytes(), 0) + ";", "")).commit();
        AppMethodBeat.o(8957);
    }
}
