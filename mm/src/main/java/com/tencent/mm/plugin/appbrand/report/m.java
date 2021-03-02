package com.tencent.mm.plugin.appbrand.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;

public final class m {
    public static int k(int i2, Bundle bundle) {
        AppMethodBeat.i(48066);
        if (bundle == null || !ze(i2)) {
            AppMethodBeat.o(48066);
            return 0;
        }
        int i3 = bundle.getInt("stat_scene");
        AppMethodBeat.o(48066);
        return i3;
    }

    public static String l(int i2, Bundle bundle) {
        AppMethodBeat.i(48067);
        if (bundle == null || !ze(i2)) {
            AppMethodBeat.o(48067);
            return "";
        }
        switch (bundle.getInt("stat_scene")) {
            case 1:
                String string = bundle.getString("stat_send_msg_user");
                AppMethodBeat.o(48067);
                return string;
            case 2:
                String str = bundle.getString("stat_chat_talker_username") + ":" + bundle.getString("stat_send_msg_user");
                AppMethodBeat.o(48067);
                return str;
            case 3:
                String str2 = bundle.getString("stat_msg_id") + ":" + bundle.getString("stat_send_msg_user");
                AppMethodBeat.o(48067);
                return str2;
            case 4:
                String encode = q.encode(bundle.getString("stat_url"));
                AppMethodBeat.o(48067);
                return encode;
            case 5:
            default:
                AppMethodBeat.o(48067);
                return "";
            case 6:
                String string2 = bundle.getString("stat_app_id");
                String string3 = bundle.getString("stat_url");
                StringBuilder append = new StringBuilder().append(string2).append(":");
                if (string3 == null) {
                    string3 = "";
                }
                String sb = append.append(q.encode(string3)).toString();
                AppMethodBeat.o(48067);
                return sb;
            case 7:
                String string4 = bundle.getString("stat_chat_talker_username");
                AppMethodBeat.o(48067);
                return string4;
            case 8:
                String str3 = "search:" + bundle.getString("stat_search_id");
                AppMethodBeat.o(48067);
                return str3;
            case 9:
                String str4 = bundle.getString("stat_chat_talker_username") + ":" + bundle.getString("stat_send_msg_user");
                AppMethodBeat.o(48067);
                return str4;
        }
    }

    private static boolean ze(int i2) {
        switch (i2) {
            case 1007:
            case 1008:
            case 1012:
            case 1024:
            case 1031:
            case 1036:
            case 1044:
            case 1048:
            case 1088:
            case 1124:
            case 1125:
            case 1126:
                return true;
            default:
                return false;
        }
    }
}
