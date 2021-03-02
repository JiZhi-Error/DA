package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public final class bi {
    public int OpC;
    public int OpD;
    public int OpE;
    public int OpF;
    public String OpG = "";
    public String OpH;
    public String OpI;
    public String OpJ;
    public boolean OpK = true;
    public String OpL;
    public String OpM;
    public String aeskey;
    public long createTime;
    public String dKK;
    public long dTS;
    public int fqJ;
    public String fqK = "";
    public String gXx;
    public int height;
    public String id;
    public String iwN;
    public String iwT;
    public String jsh;
    public int jvu;
    public String md5;
    public String pkK;
    public String productId;
    public String rnS;
    public String talker;
    public String thumbUrl;
    public int width;

    public static bi I(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104962);
        if (emojiInfo == null) {
            Log.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
            AppMethodBeat.o(104962);
            return null;
        }
        bi biVar = new bi();
        biVar.md5 = emojiInfo.field_md5;
        biVar.OpC = emojiInfo.field_type;
        biVar.OpD = emojiInfo.field_size;
        biVar.productId = emojiInfo.field_groupId;
        biVar.OpH = emojiInfo.field_designerID;
        biVar.thumbUrl = emojiInfo.field_thumbUrl;
        biVar.dKK = emojiInfo.field_encrypturl;
        biVar.aeskey = emojiInfo.field_aeskey;
        biVar.width = emojiInfo.field_width;
        biVar.height = emojiInfo.field_height;
        biVar.pkK = emojiInfo.field_cdnUrl;
        biVar.OpI = emojiInfo.field_externUrl;
        biVar.OpJ = emojiInfo.field_externMd5;
        biVar.OpL = emojiInfo.field_activityid;
        biVar.iwN = emojiInfo.field_tpurl;
        biVar.iwT = emojiInfo.field_tpauthkey;
        biVar.gXx = emojiInfo.field_attachedText;
        biVar.rnS = emojiInfo.field_lensId;
        biVar.OpM = emojiInfo.field_attachTextColor;
        AppMethodBeat.o(104962);
        return biVar;
    }

    public static bi mU(String str, String str2) {
        AppMethodBeat.i(104963);
        Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(str2)));
        bi e2 = e(XmlParser.parseXml(str2, "msg", null), str, str2);
        AppMethodBeat.o(104963);
        return e2;
    }

    public static bi bp(String str, String str2, String str3) {
        AppMethodBeat.i(199820);
        Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(str2)));
        bi a2 = a(XmlParser.parseXml(str2, "msg", null), str, str2, str3);
        AppMethodBeat.o(199820);
        return a2;
    }

    public static bi e(Map<String, String> map, String str, String str2) {
        AppMethodBeat.i(104964);
        bi a2 = a(map, str, str2, "");
        AppMethodBeat.o(104964);
        return a2;
    }

    private static bi a(Map<String, String> map, String str, String str2, String str3) {
        AppMethodBeat.i(104965);
        if (map == null) {
            AppMethodBeat.o(104965);
            return null;
        }
        bi biVar = new bi();
        biVar.OpG = str2;
        biVar.talker = str;
        biVar.id = map.get(".msg.emoji.$idbuffer");
        biVar.jsh = map.get(".msg.emoji.$fromusername");
        String str4 = map.get(".msg.emoji.$androidmd5");
        biVar.md5 = str4;
        if (str4 == null) {
            biVar.md5 = map.get(".msg.emoji.$md5");
        }
        if (!Util.isNullOrNil(biVar.md5)) {
            biVar.md5 = biVar.md5.toLowerCase();
        }
        try {
            biVar.OpC = Integer.valueOf(map.get(".msg.emoji.$type")).intValue();
            if (map.get(".msg.emoji.$androidlen") != null) {
                biVar.OpD = Integer.valueOf(map.get(".msg.emoji.$androidlen")).intValue();
            } else if (map.get(".msg.emoji.$len") != null) {
                biVar.OpD = Integer.valueOf(map.get(".msg.emoji.$len")).intValue();
            }
            if (map.get(".msg.gameext.$type") != null) {
                biVar.OpE = Integer.valueOf(map.get(".msg.gameext.$type")).intValue();
            }
            if (map.get(".msg.gameext.$content") != null) {
                biVar.OpF = Integer.valueOf(map.get(".msg.gameext.$content")).intValue();
            }
            if (map.get(".msg.emoji.$productid") != null) {
                biVar.productId = map.get(".msg.emoji.$productid");
            }
            if (map.get(".msg.emoji.$cdnurl") != null) {
                biVar.pkK = map.get(".msg.emoji.$cdnurl");
            }
            if (map.get(".msg.emoji.$tpurl") != null) {
                biVar.iwN = map.get(".msg.emoji.$tpurl");
            }
            if (map.get(".msg.emoji.$tpauthkey") != null) {
                biVar.iwT = map.get(".msg.emoji.$tpauthkey");
            }
            if (map.get(".msg.emoji.$designerid") != null) {
                biVar.OpH = map.get(".msg.emoji.$designerid");
            }
            if (map.get(".msg.emoji.$thumburl") != null) {
                biVar.thumbUrl = map.get(".msg.emoji.$thumburl");
            }
            if (map.get(".msg.emoji.$encrypturl") != null) {
                biVar.dKK = map.get(".msg.emoji.$encrypturl");
            }
            if (map.get(".msg.emoji.$aeskey") != null) {
                biVar.aeskey = map.get(".msg.emoji.$aeskey");
            }
            if (map.get(".msg.emoji.$width") != null) {
                biVar.width = Integer.valueOf(map.get(".msg.emoji.$width")).intValue();
            }
            if (map.get(".msg.emoji.$height") != null) {
                biVar.height = Integer.valueOf(map.get(".msg.emoji.$height")).intValue();
            }
            if (map.get(".msg.emoji.$externurl") != null) {
                biVar.OpI = map.get(".msg.emoji.$externurl");
            }
            if (map.get(".msg.emoji.$externmd5") != null) {
                biVar.OpJ = map.get(".msg.emoji.$externmd5");
            }
            if (map.get(".msg.emoji.$activityid") != null) {
                biVar.OpL = map.get(".msg.emoji.$activityid");
            }
            if (map.get(".msg.emoji.$attachedtext") != null) {
                biVar.gXx = map.get(".msg.emoji.$attachedtext");
            }
            if (map.get(".msg.emoji.$attachedtextcolor") != null) {
                biVar.OpM = map.get(".msg.emoji.$attachedtextcolor");
            }
            if (map.get(".msg.emoji.$lensid") != null) {
                biVar.rnS = map.get(".msg.emoji.$lensid");
            }
            if (!Util.isNullOrNil(str3)) {
                biVar.fqK = str3;
            }
            Log.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", biVar.id, biVar.md5, Integer.valueOf(biVar.OpC), Integer.valueOf(biVar.OpD), Integer.valueOf(biVar.OpE), Integer.valueOf(biVar.OpF), biVar.productId, biVar.pkK, biVar.iwN, biVar.OpH, biVar.thumbUrl, biVar.dKK, Integer.valueOf(biVar.width), Integer.valueOf(biVar.height), biVar.OpI, biVar.OpJ);
            AppMethodBeat.o(104965);
            return biVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(104965);
            return null;
        }
    }
}
