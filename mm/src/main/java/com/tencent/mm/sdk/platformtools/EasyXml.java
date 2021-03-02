package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class EasyXml {
    public static String INVALID_TAG = "]]>";
    String mprevTag = "";
    StringBuffer sb = new StringBuffer();

    public EasyXml() {
        AppMethodBeat.i(157525);
        AppMethodBeat.o(157525);
    }

    public EasyXml(String str) {
        AppMethodBeat.i(157526);
        this.mprevTag = str;
        startTag(this.mprevTag);
        AppMethodBeat.o(157526);
    }

    private static String filterNull(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.i(230280);
        if (str.matches("\\d*")) {
            AppMethodBeat.o(230280);
            return true;
        }
        AppMethodBeat.o(230280);
        return false;
    }

    public static String filterId(String str) {
        AppMethodBeat.i(230281);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(230281);
            return "";
        } else if (isNumeric(str)) {
            AppMethodBeat.o(230281);
            return str;
        } else {
            AppMethodBeat.o(230281);
            return "";
        }
    }

    public void startTag(String str) {
        AppMethodBeat.i(157527);
        this.sb.append("<" + str + ">");
        AppMethodBeat.o(157527);
    }

    public void endTag(String str) {
        AppMethodBeat.i(157528);
        this.sb.append("</" + str + ">");
        AppMethodBeat.o(157528);
    }

    public void text(String str) {
        AppMethodBeat.i(230282);
        setText(str);
        AppMethodBeat.o(230282);
    }

    public void setText(String str) {
        AppMethodBeat.i(157529);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(157529);
        } else if (str.contains(INVALID_TAG)) {
            this.sb.append("<![CDATA[" + Util.escapeStringForXml(str) + "]]>");
            AppMethodBeat.o(157529);
        } else {
            this.sb.append("<![CDATA[" + str + "]]>");
            AppMethodBeat.o(157529);
        }
    }

    public void text(int i2) {
        AppMethodBeat.i(230283);
        setText(i2);
        AppMethodBeat.o(230283);
    }

    public void setText(int i2) {
        AppMethodBeat.i(230284);
        this.sb.append(i2);
        AppMethodBeat.o(230284);
    }

    public void addTag(String str, String str2) {
        AppMethodBeat.i(157530);
        startTag(str);
        setText(str2);
        endTag(str);
        AppMethodBeat.o(157530);
    }

    public void addTag(String str, int i2) {
        AppMethodBeat.i(230285);
        startTag(str);
        setText(i2);
        endTag(str);
        AppMethodBeat.o(230285);
    }

    public void startTag(String str, Map<String, String> map) {
        AppMethodBeat.i(230286);
        this.sb.append("<".concat(String.valueOf(str)));
        for (String str2 : map.keySet()) {
            this.sb.append(" " + str2 + " =  \"" + map.get(str2) + "\" ");
        }
        this.sb.append(">");
        map.clear();
        AppMethodBeat.o(230286);
    }

    public String getXml() {
        AppMethodBeat.i(230287);
        if (!Util.isNullOrNil(this.mprevTag)) {
            endTag(this.mprevTag);
            this.mprevTag = "";
        }
        String stringBuffer = this.sb.toString();
        AppMethodBeat.o(230287);
        return stringBuffer;
    }
}
