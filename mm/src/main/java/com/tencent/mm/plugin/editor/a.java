package com.tencent.mm.plugin.editor;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static String alE(String str) {
        AppMethodBeat.i(181516);
        String replaceAll = str.replaceAll("<font", "<wx-font").replaceAll("<div", "<wx-div").replaceAll("<p", "<wx-p").replaceAll("</font>", "</wx-font>").replaceAll("<ul>", "<wx-ul>").replaceAll("</ul>", "</wx-ul>").replaceAll("<ol>", "<wx-ol>").replaceAll("</ol>", "</wx-ol>").replaceAll("<li>", "<wx-li>").replaceAll("</li>", "</wx-li>").replaceAll("<b>", "<wx-b>").replaceAll("</b>", "</wx-b>").replaceAll("</div>", "</wx-div>").replaceAll("</p>", "</wx-p>");
        AppMethodBeat.o(181516);
        return replaceAll;
    }
}
