package com.tencent.mm.n;

import android.view.ContextMenu;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class e {
    public static final int[] gMg = {1};
    HashMap<String, HashMap<String, String>> gMh = new HashMap<>();
    public Map<String, String> gMi = null;
    private int id;
    int version;

    public e(int i2) {
        AppMethodBeat.i(131988);
        this.id = i2;
        AppMethodBeat.o(131988);
    }

    static boolean Ek(String str) {
        String[] split;
        AppMethodBeat.i(131989);
        try {
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(131989);
                return false;
            }
            ArrayList<String> arrayList = new ArrayList();
            if (!Util.isNullOrNil(str) && (split = str.split(",")) != null && split.length > 0) {
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!Util.isNullOrNil(split[i2])) {
                        arrayList.add(split[i2]);
                    }
                }
            }
            String applicationLanguage = LocaleUtil.getApplicationLanguage();
            if (Util.isNullOrNil(applicationLanguage)) {
                AppMethodBeat.o(131989);
                return false;
            }
            Log.d("MicroMsg.ConfigListInfo", "locale is ".concat(String.valueOf(applicationLanguage)));
            for (String str2 : arrayList) {
                if (str2.trim().toLowerCase().equals(FacebookRequestErrorClassification.KEY_OTHER) && !applicationLanguage.equals(LocaleUtil.CHINA)) {
                    Log.d("MicroMsg.ConfigListInfo", "find other");
                    AppMethodBeat.o(131989);
                    return true;
                } else if (str2.trim().toLowerCase().equals(applicationLanguage.trim().toLowerCase())) {
                    Log.d("MicroMsg.ConfigListInfo", "find ");
                    AppMethodBeat.o(131989);
                    return true;
                }
            }
            AppMethodBeat.o(131989);
            return false;
        } catch (Exception e2) {
            Log.e("MicroMsg.ConfigListInfo", "exception:%s", Util.stackTraceToString(e2));
            Log.d("MicroMsg.ConfigListInfo", "isContainLocale failed " + e2.getMessage());
        }
    }

    public static class a {
        public String id;
        public String title;
        public String url;

        public a(String str, String str2, String str3) {
            this.id = str;
            this.title = str2;
            this.url = str3;
        }
    }

    public static class b implements ContextMenu.ContextMenuInfo {
        private static int gMj = 10000;
        public final int id;
        public final String key;
        public final String title;

        public b(String str, String str2) {
            AppMethodBeat.i(131987);
            int i2 = gMj;
            gMj = i2 + 1;
            this.id = i2;
            this.key = str;
            this.title = str2;
            AppMethodBeat.o(131987);
        }
    }

    private static LinkedList<a> b(Map<String, String> map, String str) {
        LinkedList<a> linkedList;
        AppMethodBeat.i(131990);
        LinkedList<a> linkedList2 = null;
        int i2 = 0;
        while (true) {
            String str2 = str + (i2 == 0 ? "" : Integer.valueOf(i2));
            if (map.get(str2) == null) {
                break;
            }
            String str3 = str2 + ".id";
            String str4 = str2 + ".title";
            String str5 = str2 + ".url";
            if (!map.containsKey(str3)) {
                break;
            }
            a aVar = new a(map.get(str3), map.get(str4), map.get(str5));
            if (linkedList2 == null) {
                linkedList = new LinkedList<>();
            } else {
                linkedList = linkedList2;
            }
            linkedList.add(aVar);
            i2++;
            linkedList2 = linkedList;
        }
        AppMethodBeat.o(131990);
        return linkedList2;
    }

    public static LinkedList<a> s(Map<String, String> map) {
        LinkedList<a> linkedList;
        AppMethodBeat.i(131991);
        LinkedList<a> linkedList2 = null;
        int i2 = 0;
        while (true) {
            String str = ".ConfigList.Config" + (i2 == 0 ? "" : Integer.valueOf(i2));
            if (map.get(str + ".$name") == null) {
                AppMethodBeat.o(131991);
                break;
            }
            if (map.get(str + ".$name").equalsIgnoreCase("JDWebViewMenu")) {
                linkedList = b(map, str + ".menuItems.menuItem");
                linkedList2 = b(map, str + ".menuItems.newMenuItem");
                if (linkedList == null) {
                    AppMethodBeat.o(131991);
                    break;
                } else if (linkedList2 != null && linkedList2.size() > 0) {
                    Log.d("MicroMsg.ConfigListInfo", "has menuItem2, %s, %s", Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()));
                    linkedList.addAll(linkedList2);
                }
            } else {
                linkedList = linkedList2;
            }
            i2++;
            linkedList2 = linkedList;
        }
        return linkedList2;
    }
}
