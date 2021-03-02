package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.az.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class e extends a {
    public String BcW = null;
    public int status = 0;
    public String username = null;

    public e(Map<String, String> map, ca caVar) {
        super(map, caVar);
    }

    public e(Map<String, String> map) {
        super(map);
    }

    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        AppMethodBeat.i(26910);
        if (this.values == null) {
            Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] values == null ");
            AppMethodBeat.o(26910);
            return false;
        }
        Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type:%s, values size:%s", Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (Util.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlOpenIMFriReqAcceptedInWxWork")) {
            Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type err :%s", Util.nullAsNil(this.TYPE));
            AppMethodBeat.o(26910);
            return false;
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.username")) {
            this.username = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.username"));
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid")) {
            this.BcW = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid"));
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid")) {
            this.status = Util.getInt((String) this.values.get(".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.status"), 0);
        }
        Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "username:%s climsgid:%s status:%s", this.username, this.BcW, Integer.valueOf(this.status));
        fb(this.BcW, this.status);
        fc(this.username, this.status);
        AppMethodBeat.o(26910);
        return true;
    }

    private static void fb(String str, int i2) {
        i iVar;
        String valueOf;
        String str2;
        boolean z;
        AppMethodBeat.i(231828);
        g.aAi();
        String str3 = (String) g.aAh().azQ().get(ar.a.USERINFO_ADD_CONTACT_BY_WEWORK_STRING_SYNC, "");
        Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() climsgid:%s state:%s ", str, Integer.valueOf(i2));
        try {
            if (!Util.isNullOrNil(str3)) {
                i iVar2 = new i(str3);
                str2 = iVar2.optString("svrids");
                String optString = iVar2.optString("states");
                String[] split = str2.split(",");
                String[] split2 = optString.split(",");
                if (split != null && split2 != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= split.length) {
                            break;
                        } else if (Util.isEqual(str, split[i3])) {
                            split2[i3] = String.valueOf(i2);
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                z = false;
                iVar = new i();
                if (!z) {
                    str2 = str2 + "," + str;
                    valueOf = optString + "," + i2;
                } else {
                    String str4 = "";
                    for (int i4 = 0; i4 < split2.length; i4++) {
                        str4 = str4 + split2[i4] + ",";
                    }
                    valueOf = str4.substring(0, str4.length() - 1);
                }
            } else {
                iVar = new i();
                valueOf = String.valueOf(i2);
                str2 = str;
            }
            iVar.h("svrids", str2);
            iVar.h("states", valueOf);
            Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() result:%s", str, Integer.valueOf(i2), iVar.toString());
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_ADD_CONTACT_BY_WEWORK_STRING_SYNC, iVar.toString());
            AppMethodBeat.o(231828);
        } catch (Exception e2) {
            Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() Exception:%s", e2.getMessage());
            AppMethodBeat.o(231828);
        }
    }

    private static void fc(String str, int i2) {
        i iVar;
        String valueOf;
        String str2;
        boolean z;
        AppMethodBeat.i(26911);
        g.aAi();
        String str3 = (String) g.aAh().azQ().get(ar.a.USERINFO_ADD_CONTACT_BY_WEWORK_USERNAME_STRING_SYNC, "");
        Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() username:%s state:%s ", str, Integer.valueOf(i2));
        try {
            if (!Util.isNullOrNil(str3)) {
                i iVar2 = new i(str3);
                str2 = iVar2.optString("usernames");
                String optString = iVar2.optString("states");
                String[] split = str2.split(",");
                String[] split2 = optString.split(",");
                if (split != null && split2 != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= split.length) {
                            break;
                        } else if (Util.isEqual(str, split[i3])) {
                            split2[i3] = String.valueOf(i2);
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                z = false;
                iVar = new i();
                if (!z) {
                    str2 = str2 + "," + str;
                    valueOf = optString + "," + i2;
                } else {
                    String str4 = "";
                    for (int i4 = 0; i4 < split2.length; i4++) {
                        str4 = str4 + split2[i4] + ",";
                    }
                    valueOf = str4.substring(0, str4.length() - 1);
                }
            } else {
                iVar = new i();
                valueOf = String.valueOf(i2);
                str2 = str;
            }
            iVar.h("usernames", str2);
            iVar.h("states", valueOf);
            Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() result:%s", str, Integer.valueOf(i2), iVar.toString());
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_ADD_CONTACT_BY_WEWORK_USERNAME_STRING_SYNC, iVar.toString());
            AppMethodBeat.o(26911);
        } catch (Exception e2) {
            Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() Exception:%s", e2.getMessage());
            AppMethodBeat.o(26911);
        }
    }

    public static int aKl(String str) {
        int i2;
        AppMethodBeat.i(26912);
        g.aAi();
        String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_ADD_CONTACT_BY_WEWORK_STRING_SYNC, "");
        Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() climsgid:%s", str);
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(26912);
            return 1;
        }
        try {
            i iVar = new i(str2);
            String optString = iVar.optString("svrids");
            String optString2 = iVar.optString("states");
            String[] split = optString.split(",");
            String[] split2 = optString2.split(",");
            if (split == null || split2 == null) {
                AppMethodBeat.o(26912);
                return 1;
            }
            for (int i3 = 0; i3 < split.length; i3++) {
                if (Util.isEqual(str, split[i3])) {
                    try {
                        i2 = Integer.valueOf(split2[i3]).intValue();
                    } catch (NumberFormatException e2) {
                        Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", e2.getMessage());
                        i2 = 0;
                    }
                    AppMethodBeat.o(26912);
                    return i2;
                }
            }
            AppMethodBeat.o(26912);
            return 1;
        } catch (Exception e3) {
            Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", e3.getMessage());
            AppMethodBeat.o(26912);
            return 1;
        }
    }

    public static boolean aKm(String str) {
        int i2;
        AppMethodBeat.i(26913);
        g.aAi();
        String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_ADD_CONTACT_BY_WEWORK_USERNAME_STRING_SYNC, "");
        Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() username:%s", str);
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(26913);
            return false;
        }
        try {
            i iVar = new i(str2);
            String optString = iVar.optString("usernames");
            String optString2 = iVar.optString("states");
            String[] split = optString.split(",");
            String[] split2 = optString2.split(",");
            if (split == null || split2 == null) {
                AppMethodBeat.o(26913);
                return false;
            }
            for (int i3 = 0; i3 < split.length; i3++) {
                if (Util.isEqual(str, split[i3])) {
                    try {
                        i2 = Integer.valueOf(split2[i3]).intValue();
                    } catch (NumberFormatException e2) {
                        Log.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", e2.getMessage());
                        i2 = 0;
                    }
                    if (Util.isEqual(i2, 2) || Util.isEqual(i2, 3)) {
                        AppMethodBeat.o(26913);
                        return true;
                    } else if (Util.isEqual(i2, 1)) {
                        AppMethodBeat.o(26913);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(26913);
            return false;
        } catch (Exception e3) {
            Log.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", e3.getMessage());
            AppMethodBeat.o(26913);
            return false;
        }
    }
}
