package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.protocal.protobuf.hf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    private static int aPN(String str) {
        int i2 = 0;
        AppMethodBeat.i(96143);
        try {
            i2 = Util.getInt(str, 0);
        } catch (Exception e2) {
            Log.e("MicroMsg.AlbumBgHelper", "parserInt error ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(96143);
        return i2;
    }

    private static float PK(String str) {
        float f2 = 0.0f;
        AppMethodBeat.i(96144);
        if (str == null) {
            AppMethodBeat.o(96144);
        } else {
            try {
                f2 = Util.getFloat(str, 0.0f);
            } catch (Exception e2) {
                Log.e("MicroMsg.AlbumBgHelper", "parseFloat error ".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(96144);
        }
        return f2;
    }

    private static String PL(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static dw aPO(String str) {
        dw dwVar;
        AppMethodBeat.i(96145);
        Map<String, String> parseXml = XmlParser.parseXml(str, "albumList", null);
        dw dwVar2 = new dw();
        if (parseXml != null) {
            dwVar2.xLl = PL(parseXml.get(".albumList.$lang"));
            dwVar = b(parseXml, a(parseXml, dwVar2));
        } else {
            dwVar = dwVar2;
        }
        AppMethodBeat.o(96145);
        return dwVar;
    }

    private static dw a(Map<String, String> map, dw dwVar) {
        AppMethodBeat.i(96146);
        he heVar = new he();
        heVar.Name = PL(map.get(".albumList.album.author.name"));
        heVar.Title = PL(map.get(".albumList.album.author.title"));
        heVar.KHk = PL(map.get(".albumList.album.author.description"));
        heVar.KKN = PL(map.get(".albumList.album.author.quote"));
        heVar.KKO = aN(map);
        dwVar.KHT = heVar;
        AppMethodBeat.o(96146);
        return dwVar;
    }

    private static hf aN(Map<String, String> map) {
        AppMethodBeat.i(96147);
        hf hfVar = new hf();
        cnd D = D(map, ".albumList.album.author.icon.media");
        cnb cnb = new cnb();
        cnb.Id = PL(map.get(".albumList.album.author.icon.media.id"));
        cnb.oUv = aPN(map.get(".albumList.album.author.icon.media.type"));
        cnb.Title = PL(map.get(".albumList.album.author.icon.media.title"));
        cnb.Desc = PL(map.get(".albumList.album.author.icon.media.desc"));
        cnb.Url = PL(map.get(".albumList.album.author.icon.media.url"));
        cnb.Mcw = aPN(map.get(".albumList.album.author.icon.media.url.$type"));
        cnb.Msz = PL(map.get(".albumList.album.author.icon.media.thumb"));
        cnb.MsA = aPN(map.get(".albumList.album.author.icon.media.thumb.$type"));
        cnb.Privated = aPN(map.get(".albumList.album.author.icon.media.private"));
        cnb.MsB = D;
        hfVar.KKP = cnb;
        AppMethodBeat.o(96147);
        return hfVar;
    }

    private static cnd D(Map<String, String> map, String str) {
        AppMethodBeat.i(96148);
        String str2 = map.get(str + ".size.$width");
        String str3 = map.get(str + ".size.$height");
        String str4 = map.get(str + ".size.$totalSize");
        cnd cnd = new cnd();
        cnd.Mtp = 0.0f;
        cnd.Mto = 0.0f;
        cnd.Mtq = 0.0f;
        if (str2 != null) {
            cnd.Mto = PK(str2);
        }
        if (str3 != null) {
            cnd.Mtp = PK(str3);
        }
        if (str4 != null) {
            cnd.Mtq = PK(str4);
        }
        AppMethodBeat.o(96148);
        return cnd;
    }

    private static dw b(Map<String, String> map, dw dwVar) {
        String str;
        String str2;
        AppMethodBeat.i(96149);
        int i2 = 0;
        while (true) {
            bzz bzz = new bzz();
            if (i2 == 0) {
                str = ".albumList.album.groupList.group.name";
                str2 = ".albumList.album.groupList.group.mediaList";
            } else {
                str = ".albumList.album.groupList.group" + i2 + ".name";
                str2 = ".albumList.album.groupList.group" + i2 + ".mediaList";
            }
            String str3 = map.get(str);
            if (str3 != null) {
                bzz.Name = PL(str3);
                bzz.LoV = E(map, str2);
                dwVar.GroupList.add(bzz);
                i2++;
            } else {
                AppMethodBeat.o(96149);
                return dwVar;
            }
        }
    }

    private static LinkedList<cnb> E(Map<String, String> map, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        AppMethodBeat.i(96150);
        LinkedList<cnb> linkedList = new LinkedList<>();
        int i2 = 0;
        while (true) {
            if (i2 != 0) {
                str2 = str + ".media" + i2 + ".id";
                str3 = str + ".media" + i2 + ".type";
                str4 = str + ".media" + i2 + ".title";
                str5 = str + ".media" + i2 + ".desc";
                str6 = str + ".media" + i2 + ".url";
                str7 = str + ".media" + i2;
                str8 = str + ".media" + i2 + ".private";
                str9 = str + ".media" + i2 + ".thumb.$type";
                str10 = str + ".media" + i2 + ".url.$type";
                str11 = str + ".media" + i2 + ".thumb";
            } else {
                str2 = str + ".media.id";
                str3 = str + ".media.type";
                str4 = str + ".media.title";
                str5 = str + ".media.desc";
                str6 = str + ".media.url";
                str7 = str + ".media";
                str8 = str + ".media.private";
                str9 = str + ".media.thumb.$type";
                str10 = str + ".media.url.$type";
                str11 = str + ".media.thumb";
            }
            if (str2 != null && str3 != null) {
                cnd D = D(map, str7);
                String str12 = map.get(str2);
                String str13 = map.get(str3);
                String str14 = map.get(str4);
                String str15 = map.get(str5);
                String str16 = map.get(str6);
                String str17 = map.get(str8);
                String str18 = map.get(str11);
                String str19 = map.get(str10);
                String str20 = map.get(str9);
                if (str12 == null || str13 == null) {
                    break;
                }
                cnb cnb = new cnb();
                cnb.Id = PL(str12);
                cnb.oUv = aPN(str13);
                cnb.Title = PL(str14);
                cnb.Desc = PL(str15);
                cnb.Url = PL(str16);
                cnb.Mcw = aPN(str19);
                cnb.Msz = PL(str18);
                cnb.MsA = aPN(str20);
                cnb.Privated = aPN(str17);
                cnb.MsB = D;
                linkedList.add(cnb);
                i2++;
            } else {
                break;
            }
        }
        AppMethodBeat.o(96150);
        return linkedList;
    }
}
