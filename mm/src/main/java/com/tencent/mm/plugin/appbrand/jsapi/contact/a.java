package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    String fuD;
    b lRC;
    String lRD;
    C0656a lRE;
    C0656a lRF;
    C0656a lRG;
    String lRH;
    String lRI;
    String lRJ;
    String lRK;
    String lRL;
    String lRM;
    String lRN;
    String lRO;
    String nickName;
    String remark;
    String title;
    String url;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.a$a  reason: collision with other inner class name */
    public static class C0656a {
        private String country;
        private String fuK;
        private String lRP;
        String lRQ;
        private String state;

        public C0656a(String str, String str2, String str3, String str4, String str5) {
            AppMethodBeat.i(137485);
            this.country = Util.nullAsNil(str);
            this.state = Util.nullAsNil(str2);
            this.fuK = Util.nullAsNil(str3);
            this.lRP = Util.nullAsNil(str4);
            this.lRQ = Util.nullAsNil(str5);
            AppMethodBeat.o(137485);
        }

        public final String bGg() {
            AppMethodBeat.i(137486);
            if (Util.isChinese(this.country) || Util.isChinese(this.state) || Util.isChinese(this.fuK) || Util.isChinese(this.lRP) || Util.isChinese(this.lRQ)) {
                StringBuilder sb = new StringBuilder();
                if (this.country.length() > 0) {
                    sb.append(this.country);
                }
                if (this.state.length() > 0) {
                    sb.append(this.state);
                }
                if (this.fuK.length() > 0) {
                    sb.append(this.fuK);
                }
                if (this.lRP.length() > 0) {
                    sb.append(this.lRP);
                }
                if (this.lRQ.length() > 0) {
                    sb.append(" ");
                    sb.append(this.lRQ);
                }
                String sb2 = sb.toString();
                AppMethodBeat.o(137486);
                return sb2;
            }
            StringBuilder sb3 = new StringBuilder();
            if (this.lRP.length() > 0) {
                sb3.append(this.lRP);
                sb3.append(" ");
            }
            if (this.fuK.length() > 0) {
                sb3.append(this.fuK + " ");
            }
            if (this.state.length() > 0) {
                sb3.append(this.state + " ");
            }
            if (this.country.length() > 0) {
                sb3.append(this.country);
            }
            if (this.lRQ.length() > 0) {
                sb3.append(" ");
                sb3.append(this.lRQ);
            }
            String sb4 = sb3.toString();
            AppMethodBeat.o(137486);
            return sb4;
        }
    }

    public static class b {
        String firstName;
        String lastName;
        String middleName;

        public b(String str, String str2, String str3) {
            AppMethodBeat.i(137487);
            this.firstName = Util.nullAsNil(str);
            this.middleName = Util.nullAsNil(str2);
            this.lastName = Util.nullAsNil(str3);
            AppMethodBeat.o(137487);
        }
    }
}
