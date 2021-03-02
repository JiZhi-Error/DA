package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class al {
    public static al CHN;
    public String CHA;
    public a CHB;
    public a CHC;
    public a CHD;
    public a CHE;
    public List<String> CHF;
    public List<String> CHG;
    public List<String> CHH;
    public List<String> CHI;
    public List<String> CHJ;
    public String CHK;
    public String CHL;
    public String CHM;
    public b CHw;
    c CHx;
    public c CHy;
    c CHz;
    public String fuD;
    public String lRD;
    public String lRL;
    public String nickName;
    public String title;
    public String url;

    public static class a {
        private String CHO;
        private String CHP;
        private String country;
        private String iUQ;
        private String jlI;
        private String lRP;
        private String lRQ;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            AppMethodBeat.i(51651);
            this.CHO = str == null ? "" : str;
            this.CHP = str2 == null ? "" : str2;
            this.lRP = str3 == null ? "" : str3;
            this.iUQ = str4 == null ? "" : str4;
            this.jlI = str5 == null ? "" : str5;
            this.lRQ = str6 == null ? "" : str6;
            this.country = str7 == null ? "" : str7;
            AppMethodBeat.o(51651);
        }

        public final String bGg() {
            String str;
            AppMethodBeat.i(51652);
            if (Util.isChinese(this.CHO) || Util.isChinese(this.CHP) || Util.isChinese(this.lRP) || Util.isChinese(this.iUQ) || Util.isChinese(this.jlI) || Util.isChinese(this.country)) {
                StringBuilder sb = new StringBuilder();
                if (this.country.length() > 0) {
                    sb.append(this.country);
                    sb.append("\n");
                }
                if (this.jlI.length() > 0) {
                    sb.append(this.jlI + " ");
                }
                if (this.iUQ.length() > 0) {
                    sb.append(this.iUQ);
                }
                if (this.jlI.length() > 0 || this.iUQ.length() > 0) {
                    sb.append("\n");
                }
                if (this.lRP.length() > 0) {
                    sb.append(this.lRP + " ");
                    sb.append("\n");
                }
                if (this.CHP.length() > 0) {
                    sb.append(this.CHP);
                    sb.append("\n");
                }
                if (this.CHO.length() > 0) {
                    sb.append(this.CHO);
                    sb.append("\n");
                }
                if (this.lRQ.length() > 0) {
                    sb.append(this.lRQ);
                }
                str = sb.toString();
                if (str.endsWith("\n")) {
                    str = str.substring(0, str.length() - 1);
                }
                AppMethodBeat.o(51652);
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (this.CHO.length() > 0) {
                    sb2.append(this.CHO);
                    sb2.append("\n");
                }
                if (this.CHP.length() > 0) {
                    sb2.append(this.CHP);
                    sb2.append("\n");
                }
                if (this.lRP.length() > 0) {
                    sb2.append(this.lRP);
                    sb2.append("\n");
                }
                if (this.iUQ.length() > 0) {
                    sb2.append(this.iUQ + " ");
                }
                if (this.jlI.length() > 0) {
                    sb2.append(this.jlI + " ");
                }
                if (this.lRQ.length() > 0) {
                    sb2.append(this.lRQ);
                }
                if (this.iUQ.length() > 0 || this.jlI.length() > 0) {
                    sb2.append("\n");
                }
                if (this.country.length() > 0) {
                    sb2.append(this.country);
                }
                str = sb2.toString();
                if (str.endsWith("\n")) {
                    str = str.substring(0, str.length() - 1);
                }
                AppMethodBeat.o(51652);
            }
            return str;
        }
    }

    public static class c {
        public String CHQ;
        public String igV;

        public c(String str, String str2) {
            this.igV = str;
            this.CHQ = str2;
        }
    }

    public static class b {
        private String firstName;
        private String lastName;
        private String middleName;

        public b(String str, String str2, String str3) {
            AppMethodBeat.i(51653);
            this.firstName = str == null ? "" : str;
            this.middleName = str2 == null ? "" : str2;
            this.lastName = str3 == null ? "" : str3;
            AppMethodBeat.o(51653);
        }

        public final String bGg() {
            AppMethodBeat.i(51654);
            StringBuilder sb = new StringBuilder();
            if (Util.isChinese(this.firstName) || Util.isChinese(this.middleName) || Util.isChinese(this.lastName)) {
                if (this.lastName.trim().length() > 0) {
                    sb.append(this.lastName);
                }
                if (this.middleName.trim().length() > 0) {
                    sb.append(this.middleName);
                }
                if (this.firstName.trim().length() > 0) {
                    sb.append(this.firstName);
                }
            } else {
                if (this.firstName.trim().length() > 0) {
                    sb.append(this.firstName);
                }
                if (this.middleName.trim().length() > 0) {
                    sb.append(" ");
                    sb.append(this.middleName);
                }
                if (this.lastName.trim().length() > 0) {
                    sb.append(" ");
                    sb.append(this.lastName);
                }
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(51654);
            return sb2;
        }
    }
}
