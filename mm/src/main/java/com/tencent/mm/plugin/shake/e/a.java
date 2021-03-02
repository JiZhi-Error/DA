package com.tencent.mm.plugin.shake.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a {
    public LinkedList<C1693a> mRG = new LinkedList<>();

    public a() {
        AppMethodBeat.i(28614);
        AppMethodBeat.o(28614);
    }

    /* renamed from: com.tencent.mm.plugin.shake.e.a$a  reason: collision with other inner class name */
    public static class C1693a {
        public List<String> DlO = new ArrayList();
        public String DlP = "";
        public String DlQ = "";
        public String daA;
        public String summary;
        public String title;
        public int type;

        public C1693a() {
            AppMethodBeat.i(28612);
            AppMethodBeat.o(28612);
        }

        public C1693a(int i2) {
            AppMethodBeat.i(28613);
            this.type = i2;
            AppMethodBeat.o(28613);
        }
    }

    public static LinkedList<a> o(Map<String, String> map, String str) {
        boolean z;
        AppMethodBeat.i(28615);
        LinkedList<a> linkedList = new LinkedList<>();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < 1000) {
            a aVar = new a();
            String str2 = str + ".actionlist" + (i2 > 0 ? Integer.valueOf(i2) : "");
            LinkedList<C1693a> linkedList2 = new LinkedList<>();
            int i3 = 0;
            while (true) {
                if (i3 >= 1000) {
                    z = z2;
                    break;
                }
                String str3 = str2 + ".action" + (i3 > 0 ? Integer.valueOf(i3) : "");
                if (!Util.isNullOrNil(map.get(str3 + ".type"))) {
                    try {
                        int intValue = Integer.valueOf(map.get(str3 + ".type")).intValue();
                        C1693a aVar2 = null;
                        if (intValue == 2) {
                            C1693a aVar3 = new C1693a(intValue);
                            aVar3.daA = Util.nullAsNil(map.get(str3 + ".comment.id"));
                            aVar3.title = Util.nullAsNil(map.get(str3 + ".comment.title"));
                            aVar2 = aVar3;
                        } else if (intValue == 3) {
                            aVar2 = a(map, intValue, str3);
                        } else if (intValue == 4) {
                            aVar2 = a(map, intValue, str3);
                        } else if (intValue == 5) {
                            aVar2 = a(map, intValue, str3);
                        } else if (intValue == 6) {
                            aVar2 = a(map, intValue, str3);
                        }
                        if (aVar2 != null) {
                            linkedList2.add(aVar2);
                        }
                        i3++;
                        z2 = false;
                    } catch (Exception e2) {
                        new StringBuilder("Exception in parseActionList: ").append(e2.getMessage());
                        if (z2) {
                            AppMethodBeat.o(28615);
                            return linkedList;
                        }
                        aVar.mRG = linkedList2;
                        z = true;
                    }
                } else if (z2) {
                    AppMethodBeat.o(28615);
                    return linkedList;
                } else {
                    aVar.mRG = linkedList2;
                    z = true;
                }
            }
            linkedList.add(aVar);
            i2++;
            z2 = z;
        }
        AppMethodBeat.o(28615);
        return linkedList;
    }

    private static C1693a a(Map<String, String> map, int i2, String str) {
        AppMethodBeat.i(28616);
        C1693a aVar = new C1693a(i2);
        aVar.title = Util.nullAsNil(map.get(str + ".title"));
        aVar.summary = Util.nullAsNil(map.get(str + ".summary"));
        String str2 = str + ".thumburl";
        int i3 = 0;
        while (i3 < 100) {
            String str3 = map.get(str2 + (i3 > 0 ? Integer.valueOf(i3) : ""));
            if (Util.isNullOrNil(str3)) {
                break;
            }
            aVar.DlO.add(str3);
            i3++;
        }
        switch (i2) {
            case 3:
                aVar.daA = Util.nullAsNil(map.get(str + ".h5url.link"));
                aVar.DlP = Util.nullAsNil(map.get(str + ".h5url.title"));
                aVar.DlQ = Util.nullAsNil(map.get(str + ".h5url.username"));
                break;
            case 4:
                aVar.daA = Util.nullAsNil(map.get(str + ".bizprofile.username"));
                aVar.DlP = Util.nullAsNil(map.get(str + ".bizprofile.showchat"));
                break;
            case 5:
                aVar.daA = Util.nullAsNil(map.get(str + ".nativepay.wx_pay_url"));
                break;
            case 6:
                aVar.daA = Util.nullAsNil(map.get(str + ".product.product_id"));
                break;
        }
        AppMethodBeat.o(28616);
        return aVar;
    }
}
