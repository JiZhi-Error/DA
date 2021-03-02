package com.tencent.mm.emoji.e;

import android.content.Context;
import android.util.Base64;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bb.g;
import com.tencent.mm.emoji.b.a;
import com.tencent.mm.emoji.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class b {
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.tencent.mm.storage.emotion.SmileyInfo> d(com.tencent.mm.vfs.o r15) {
        /*
        // Method dump skipped, instructions count: 519
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.e.b.d(com.tencent.mm.vfs.o):java.util.ArrayList");
    }

    public static ArrayList<SmileyPanelConfigInfo> e(o oVar) {
        String str;
        AppMethodBeat.i(104498);
        ArrayList<SmileyPanelConfigInfo> arrayList = new ArrayList<>();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        InputStream inputStream = null;
        try {
            InputStream ao = s.ao(oVar);
            Document parse = newInstance.newDocumentBuilder().parse(ao);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("item");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                int length = elementsByTagName.getLength();
                for (int i2 = 0; i2 < length; i2++) {
                    Node item = elementsByTagName.item(i2);
                    if (item != null && !Util.isNullOrNil(item.getTextContent())) {
                        String replaceAll = item.getTextContent().replaceAll("\"", "");
                        if (replaceAll.matches("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$")) {
                            str = new String(Base64.decode(replaceAll, 0));
                        } else {
                            str = replaceAll;
                        }
                        if (str.startsWith("\\\\u")) {
                            char[] chars = Character.toChars(Integer.parseInt(str.substring(3), 16));
                            str = "";
                            for (int i3 = 0; i3 < chars.length; i3++) {
                                str = str + String.valueOf(chars[i3]);
                            }
                        }
                        SmileyPanelConfigInfo smileyPanelConfigInfo = new SmileyPanelConfigInfo(i2, str);
                        if (Util.isNullOrNil(smileyPanelConfigInfo.field_key)) {
                            Log.i("MicroMsg.EmojiResHelper", "key is null.");
                        } else {
                            arrayList.add(smileyPanelConfigInfo);
                        }
                        Log.d("MicroMsg.EmojiResHelper", smileyPanelConfigInfo.toString());
                    }
                }
            }
            if (ao != null) {
                try {
                    ao.close();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.EmojiResHelper", "parseSmileyPanelConfig parseXML exception:%s", e3.toString());
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(104498);
            throw th;
        }
        AppMethodBeat.o(104498);
        return arrayList;
    }

    public static g f(o oVar) {
        AppMethodBeat.i(104499);
        try {
            i iVar = new i();
            a.C0319a aVar = a.gWU;
            a.C0319a.a(aa.z(oVar.her()), iVar);
            g gVar = iVar.gXc;
            Log.i("MicroMsg.EmojiResHelper", "parserEmojiEggConfig: %s", Integer.valueOf(gVar.jgS.size()));
            AppMethodBeat.o(104499);
            return gVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.EmojiResHelper", e2, "", new Object[0]);
            AppMethodBeat.o(104499);
            return null;
        }
    }

    public static int EY(String str) {
        int i2 = -1;
        AppMethodBeat.i(199755);
        if (s.YS(str)) {
            try {
                i2 = new com.tencent.mm.ab.i(s.boY(str)).optInt("version", -1);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.EmojiResHelper", e2, "readConfigVersion fail", new Object[0]);
            }
        }
        Log.i("MicroMsg.EmojiResHelper", "readConfigVersion: %s, %s", Integer.valueOf(i2), str);
        AppMethodBeat.o(199755);
        return i2;
    }

    public static int cG(Context context) {
        AppMethodBeat.i(177030);
        if (context == null) {
            AppMethodBeat.o(177030);
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.nd, typedValue, true);
        int i2 = typedValue.resourceId;
        AppMethodBeat.o(177030);
        return i2;
    }
}
