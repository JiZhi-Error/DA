package com.tencent.mm.plugin.game.model;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class ah {
    private static String aT(LinkedList<o.k> linkedList) {
        AppMethodBeat.i(41571);
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(41571);
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            Iterator<o.k> it = linkedList.iterator();
            while (it.hasNext()) {
                o.k next = it.next();
                newSerializer.startTag(null, "userinfo");
                newSerializer.attribute(null, "jump_id", next.xGs);
                newSerializer.startTag(null, ch.COL_USERNAME);
                try {
                    newSerializer.text(Util.nullAs(next.userName, ""));
                } catch (Exception e2) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, ch.COL_USERNAME);
                newSerializer.startTag(null, "nickname");
                try {
                    newSerializer.text(Util.nullAs(next.nickName, ""));
                } catch (Exception e3) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "nickname");
                newSerializer.startTag(null, "usericon");
                try {
                    newSerializer.text(Util.nullAs(next.xGp, ""));
                } catch (Exception e4) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "usericon");
                newSerializer.startTag(null, Scopes.PROFILE);
                try {
                    newSerializer.text(Util.nullAs(next.xGq, ""));
                } catch (Exception e5) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, Scopes.PROFILE);
                newSerializer.startTag(null, "badge_icon");
                try {
                    newSerializer.text(Util.nullAs(next.xGr, ""));
                } catch (Exception e6) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "badge_icon");
                newSerializer.endTag(null, "userinfo");
            }
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            AppMethodBeat.o(41571);
            return stringBuffer;
        } catch (Exception e7) {
            Log.e("MicroMsg.GameXmlProcess", e7.getMessage());
            AppMethodBeat.o(41571);
            return "";
        }
    }

    private static String b(LinkedList<o.k> linkedList, HashMap<String, o.g> hashMap) {
        AppMethodBeat.i(41572);
        if (Util.isNullOrNil(linkedList) || hashMap.isEmpty()) {
            AppMethodBeat.o(41572);
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            Iterator<o.k> it = linkedList.iterator();
            while (it.hasNext()) {
                o.k next = it.next();
                o.g gVar = hashMap.get(next.xGs);
                if (gVar != null) {
                    newSerializer.startTag(null, "jump");
                    newSerializer.attribute(null, "id", next.xGs);
                    newSerializer.startTag(null, "jump_type");
                    try {
                        newSerializer.text(String.valueOf(gVar.mJumpType));
                    } catch (Exception e2) {
                        newSerializer.text("");
                    }
                    newSerializer.endTag(null, "jump_type");
                    newSerializer.startTag(null, "jump_url");
                    try {
                        newSerializer.text(Util.nullAs(gVar.rHJ, ""));
                    } catch (Exception e3) {
                        newSerializer.text("");
                    }
                    newSerializer.endTag(null, "jump_url");
                    newSerializer.endTag(null, "jump");
                }
            }
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            AppMethodBeat.o(41572);
            return stringBuffer;
        } catch (Exception e4) {
            Log.e("MicroMsg.GameXmlProcess", e4.getMessage());
            AppMethodBeat.o(41572);
            return "";
        }
    }

    public static String a(String str, LinkedList<o.k> linkedList, HashMap<String, o.g> hashMap) {
        AppMethodBeat.i(41573);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(41573);
            return str;
        }
        String aT = aT(linkedList);
        if (Util.isNullOrNil(aT)) {
            AppMethodBeat.o(41573);
            return str;
        }
        String b2 = b(linkedList, hashMap);
        StringBuilder sb = new StringBuilder(str);
        try {
            if (sb.indexOf("<userinfo>") != -1) {
                sb.insert(sb.indexOf("<userinfo>"), "<usercount>" + linkedList.size() + 1 + "</usercount>");
            }
            if (sb.lastIndexOf("</userinfo>") != -1) {
                sb.insert(sb.lastIndexOf("</userinfo>") + 11, aT);
            }
            if (sb.lastIndexOf("</jump>") != -1 && !Util.isNullOrNil(b2)) {
                sb.insert(sb.lastIndexOf("</jump>") + 7, b2);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.GameXmlProcess", e2.getMessage());
            Log.e("MicroMsg.GameXmlProcess", "xml is invalid : ".concat(String.valueOf(str)));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(41573);
        return sb2;
    }
}
