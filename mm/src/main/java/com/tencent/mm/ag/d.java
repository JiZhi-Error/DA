package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.luckymoney.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public class d extends f {
    public int eha = 0;
    public EmojiInfo gWm;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(20232);
        d dVar = new d();
        AppMethodBeat.o(20232);
        return dVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, com.tencent.mm.i.d dVar, int i2, int i3) {
        AppMethodBeat.i(20233);
        if (bVar.type == 2001) {
            e.a(sb, this.gWm == null ? new EmojiInfo() : this.gWm, this.eha);
        }
        AppMethodBeat.o(20233);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(20234);
        if (bVar.type == 2001) {
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = Util.nullAsNil(map.get(".msg.appmsg.emoji.md5"));
            emojiInfo.field_type = Util.getInt(map.get(".msg.appmsg.emoji.type"), 0);
            emojiInfo.field_width = Util.getInt(map.get(".msg.appmsg.emoji.width"), 0);
            emojiInfo.field_height = Util.getInt(map.get(".msg.appmsg.emoji.height"), 0);
            emojiInfo.field_size = Util.getInt(map.get(".msg.appmsg.emoji.len"), 0);
            emojiInfo.field_aeskey = Util.nullAsNil(map.get(".msg.appmsg.emoji.aeskey"));
            emojiInfo.field_cdnUrl = Util.nullAsNil(map.get(".msg.appmsg.emoji.cdnurl"));
            emojiInfo.field_encrypturl = Util.nullAsNil(map.get(".msg.appmsg.emoji.encrypturl"));
            emojiInfo.field_externUrl = Util.nullAsNil(map.get(".msg.appmsg.emoji.externurl"));
            emojiInfo.field_externMd5 = Util.nullAsNil(map.get(".msg.appmsg.emoji.externmd5"));
            emojiInfo.field_groupId = Util.nullAsNil(map.get(".msg.appmsg.emoji.productid"));
            emojiInfo.field_designerID = Util.nullAsNil(map.get(".msg.appmsg.emoji.designerid"));
            emojiInfo.field_attachedText = Util.nullAsNil(map.get(".msg.appmsg.emoji.attachedtext"));
            emojiInfo.field_temp = 1;
            emojiInfo.field_catalog = EmojiInfo.VkQ;
            emojiInfo.field_state = EmojiInfo.Vlg;
            this.gWm = emojiInfo;
            this.eha = Util.getInt(map.get(".msg.appmsg.emoji.localreceivestatus"), 0);
            if (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(emojiInfo.field_md5) == null) {
                com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.J(this.gWm);
            }
            Log.d("MicroMsg.AppContentLuckyMoneyEmogiPiece", "EmojiInfo: %s", this.gWm);
        }
        AppMethodBeat.o(20234);
    }
}
