package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Map;

public final class b {
    public int CEF;
    public String CEG;
    public boolean CEH;
    public int iconHeight;
    public String iconUrl;
    public int iconWidth;
    public LinkedList<a> mRG = new LinkedList<>();
    public String title;
    public int type = 1;

    public b() {
        AppMethodBeat.i(51609);
        AppMethodBeat.o(51609);
    }

    public static class a {
        public String CEG;
        public String CEI = "";
        public String CEJ = "";
        public String CEK = "";
        public String CEL = "";
        public String CEM = "";
        public String CEN = "";
        public String CEO = "";
        public String CEP = "";
        public String CEQ;
        public String CER;
        public String content;
        public int dDG;
        public String desc = "";
        public String iAq = "";
        public String iconUrl = "";
        public String image = "";
        public String key;
        public String link = "";
        public String name = "";
        public String nickname = "";
        public String thumburl = "";
        public int type;
        public String username = "";

        public a() {
        }

        public a(int i2) {
            this.type = i2;
        }
    }

    public static LinkedList<b> o(Map<String, String> map, String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(51610);
        LinkedList<b> linkedList = new LinkedList<>();
        boolean z3 = false;
        int i2 = 0;
        while (i2 < 1000) {
            b bVar = new b();
            String str2 = str + ".actionlist" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (!Util.isNullOrNil(map.get(str2 + ".$type"))) {
                bVar.type = Util.getInt(map.get(str2 + ".$type"), 0);
            }
            bVar.title = Util.nullAsNil(map.get(str2 + ".$title"));
            bVar.iconUrl = Util.nullAsNil(map.get(str2 + ".$iconurl"));
            bVar.iconWidth = Util.getInt(map.get(str2 + ".$iconwidth"), 34);
            bVar.iconHeight = Util.getInt(map.get(str2 + ".$iconheight"), 34);
            bVar.CEG = Util.nullAsNil(map.get(str2 + ".$referkey"));
            bVar.CEF = Util.getInt(map.get(str2 + ".$listshowtype"), 0);
            boolean z4 = false;
            LinkedList<a> linkedList2 = new LinkedList<>();
            int i3 = 0;
            while (true) {
                if (i3 >= 1000) {
                    z = z3;
                    break;
                }
                String str3 = str2 + ".action" + (i3 > 0 ? Integer.valueOf(i3) : "");
                if (!Util.isNullOrNil(map.get(str3 + ".$type"))) {
                    z3 = false;
                    a p = p(map, str3);
                    if (p != null) {
                        linkedList2.add(p);
                        if (!t.a(p)) {
                            z2 = true;
                            i3++;
                            z4 = z2;
                        }
                    }
                    z2 = z4;
                    i3++;
                    z4 = z2;
                } else if (z3) {
                    AppMethodBeat.o(51610);
                    return linkedList;
                } else {
                    z = true;
                    bVar.mRG = linkedList2;
                }
            }
            bVar.CEH = z4;
            linkedList.add(bVar);
            i2++;
            z3 = z;
        }
        AppMethodBeat.o(51610);
        return linkedList;
    }

    public static a p(Map<String, String> map, String str) {
        a aVar;
        AppMethodBeat.i(51611);
        int i2 = Util.getInt(map.get(str + ".$type"), 0);
        a aVar2 = new a(i2);
        aVar2.type = i2;
        aVar2.CEM = Util.nullAsNil(map.get(str + ".statid"));
        aVar2.name = Util.nullAsNil(map.get(str + ".name"));
        aVar2.desc = Util.nullAsNil(map.get(str + ".desc"));
        aVar2.iAq = Util.nullAsNil(map.get(str + ".digest"));
        aVar2.dDG = Util.getInt(map.get(str + ".showtype"), 0);
        aVar2.image = Util.nullAsNil(map.get(str + ".image"));
        aVar2.key = Util.nullAsNil(map.get(str + ".$key"));
        aVar2.iconUrl = Util.nullAsNil(map.get(str + ".iconurl"));
        if (i2 == 1) {
            aVar2.link = Util.nullAsNil(map.get(str + ".link"));
            aVar = aVar2;
        } else if (i2 == 2) {
            aVar2.username = Util.nullAsNil(map.get(str + ".username"));
            aVar2.nickname = Util.nullAsNil(map.get(str + ".nickname"));
            aVar2.CEQ = Util.nullAsNil(map.get(str + ".strbeforefollow"));
            aVar2.CER = Util.nullAsNil(map.get(str + ".strafterfollow"));
            aVar = aVar2;
        } else if (i2 == 3) {
            aVar2.thumburl = Util.nullAsNil(map.get(str + ".thumburl"));
            aVar2.link = Util.nullAsNil(map.get(str + ".link"));
            aVar = aVar2;
        } else if (i2 == 4) {
            aVar2.thumburl = Util.nullAsNil(map.get(str + ".thumburl"));
            aVar2.username = Util.nullAsNil(map.get(str + ".username"));
            aVar2.nickname = Util.nullAsNil(map.get(str + ".nickname"));
            aVar = aVar2;
        } else {
            if (i2 == 5) {
                aVar2.CEJ = Util.nullAsNil(map.get(str + ".wifiurl"));
                aVar2.CEK = Util.nullAsNil(map.get(str + ".wapurl"));
                aVar2.CEL = Util.nullAsNil(map.get(str + ".weburl"));
                if (Util.isNullOrNil(aVar2.CEJ) && Util.isNullOrNil(aVar2.CEK) && Util.isNullOrNil(aVar2.CEL)) {
                    aVar = null;
                }
            } else if (i2 != 6) {
                if (i2 == 7) {
                    aVar2.thumburl = Util.nullAsNil(map.get(str + ".thumburl"));
                    aVar2.CEI = Util.nullAsNil(map.get(str + ".playurl"));
                    aVar = aVar2;
                } else if (i2 == 9) {
                    aVar2.CEN = Util.nullAsNil(map.get(str + ".productid"));
                    aVar = aVar2;
                } else if (i2 == 8) {
                    aVar2.CEO = Util.nullAsNil(map.get(str + ".cardext"));
                    aVar2.CEP = Util.nullAsNil(map.get(str + ".cardid"));
                    aVar = aVar2;
                } else if (i2 == 10) {
                    aVar2.CEN = Util.nullAsNil(map.get(str + ".id"));
                    aVar = aVar2;
                } else if (i2 == 12) {
                    aVar2.thumburl = Util.nullAsNil(map.get(str + ".image"));
                    aVar2.link = Util.nullAsNil(map.get(str + ".link"));
                    aVar = aVar2;
                } else if (i2 == 22) {
                    aVar2.content = Util.nullAsNil(map.get(str + ".content"));
                    aVar2.link = Util.nullAsNil(map.get(str + ".link"));
                    aVar2.nickname = Util.nullAsNil(map.get(str + ".nickname"));
                    aVar2.thumburl = Util.nullAsNil(map.get(str + ".image"));
                    aVar = aVar2;
                } else if (i2 == 21) {
                    aVar2.CEG = Util.nullAsNil(map.get(str + ".referkey"));
                    aVar = aVar2;
                } else {
                    aVar2.link = Util.nullAsNil(map.get(str + ".link"));
                }
            }
            aVar = aVar2;
        }
        AppMethodBeat.o(51611);
        return aVar;
    }
}
