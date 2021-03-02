package com.tencent.mm.plugin.wenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class b {
    public static ArrayList<String> alN(String str) {
        AppMethodBeat.i(30671);
        if (Util.isNullOrNil(str) || str.length() == 0) {
            AppMethodBeat.o(30671);
            return null;
        }
        String[] split = Pattern.compile("\n", 2).matcher(Pattern.compile("<div></div>", 2).matcher(Pattern.compile("</object>", 2).matcher(Pattern.compile("<hr[^>]*>", 2).matcher(Pattern.compile("<object[^>]*>", 2).matcher(Pattern.compile("<div><object[^>]*></object></div>", 2).matcher(str).replaceAll("<object>")).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#")).replaceAll("#WNNoteNode#<ThisisNoteNodeHrObj>#WNNoteNode#")).replaceAll("")).replaceAll("")).replaceAll("").replaceAll("<br>", "<br/>").trim().split("#WNNoteNode#");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            if (str2.length() > 0) {
                String replace = str2.replace("</div>", "<div>");
                int i2 = -1;
                if (replace.endsWith("<div>")) {
                    i2 = replace.lastIndexOf("<div>");
                }
                if (i2 > 0) {
                    replace = replace.substring(0, i2);
                }
                arrayList.add(replace.replace("<div><br/>", "<div>"));
            }
        }
        AppMethodBeat.o(30671);
        return arrayList;
    }

    public static String alO(String str) {
        AppMethodBeat.i(30672);
        if (Util.isNullOrNil(str) || str.length() == 0) {
            AppMethodBeat.o(30672);
            return str;
        }
        String replaceAll = Pattern.compile("&nbsp;", 2).matcher(Pattern.compile("<[^>]*>", 2).matcher(Pattern.compile("</p>", 2).matcher(Pattern.compile("<p [^>]*>", 2).matcher(Pattern.compile("<hr[^>]*>", 2).matcher(Pattern.compile("</wx-todo>", 2).matcher(Pattern.compile("</wx-li>", 2).matcher(Pattern.compile("<div>", 2).matcher(Pattern.compile("<br[^>]*>", 2).matcher(str).replaceAll("\n")).replaceAll("")).replaceAll("\n")).replaceAll("\n")).replaceAll("\n")).replaceAll("")).replaceAll("")).replaceAll("")).replaceAll(" ");
        AppMethodBeat.o(30672);
        return replaceAll;
    }

    public static boolean alP(String str) {
        AppMethodBeat.i(30673);
        int length = "<br/>".length();
        if (Util.isNullOrNil(str) || str.length() < length) {
            AppMethodBeat.o(30673);
            return false;
        }
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + length;
            if (i3 > str.length()) {
                AppMethodBeat.o(30673);
                return false;
            } else if (!"<br/>".equalsIgnoreCase(str.substring(i2, i3))) {
                AppMethodBeat.o(30673);
                return false;
            } else {
                i2 = i3;
            }
        }
        AppMethodBeat.o(30673);
        return true;
    }

    public static String alQ(String str) {
        AppMethodBeat.i(30674);
        String alO = alO(Pattern.compile("<object[^>]*>", 2).matcher(str).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#"));
        if (Util.isNullOrNil(alO) || alO.length() == 0) {
            AppMethodBeat.o(30674);
            return alO;
        }
        String replaceAll = Pattern.compile("\\s*|\t|\r|\n").matcher(alO).replaceAll("");
        AppMethodBeat.o(30674);
        return replaceAll;
    }
}
