package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.s;

public final class p implements j {
    @Override // com.tencent.mm.pluginsdk.j
    public final com.tencent.mm.ui.base.p a(t tVar, String str, String str2, String str3, String str4, String str5, y.a aVar) {
        AppMethodBeat.i(31416);
        com.tencent.mm.ui.base.p a2 = o.a(tVar, str, str2, str3, str4, str5, aVar);
        AppMethodBeat.o(31416);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.j
    public final void a(t tVar, String str, String str2, String str3, y.a aVar) {
        AppMethodBeat.i(31417);
        o.a(tVar, str, str2, str3, aVar);
        AppMethodBeat.o(31417);
    }

    @Override // com.tencent.mm.pluginsdk.j
    public final d b(t tVar, String str, String str2, String str3, String str4, String str5, y.a aVar) {
        AppMethodBeat.i(31418);
        d b2 = o.b(tVar, str, str2, str3, str4, str5, aVar);
        AppMethodBeat.o(31418);
        return b2;
    }

    @Override // com.tencent.mm.pluginsdk.j
    public final d a(Context context, String str, View view, String str2, y.a aVar) {
        AppMethodBeat.i(31419);
        o.a gpz = new o.a(context).ea(str).gl(view).p(Boolean.TRUE).gpz();
        gpz.Kfh = str2;
        d dVar = gpz.a(aVar).kdo;
        AppMethodBeat.o(31419);
        return dVar;
    }

    @Override // com.tencent.mm.pluginsdk.j
    public final void a(Context context, String str, String str2, String str3, String str4, String str5, y.a aVar) {
        AppMethodBeat.i(31420);
        o.a aVar2 = new o.a(context);
        aVar2.ea(str).beQ(str2).Kfh = str3;
        aVar2.beR(str5).gpy();
        aVar2.Kfg.bos(str4);
        aVar2.a(aVar).kdo.show();
        AppMethodBeat.o(31420);
    }

    @Override // com.tencent.mm.pluginsdk.j
    public final void a(Context context, String str, String str2, String str3, y.a aVar) {
        AppMethodBeat.i(31421);
        o.a aVar2 = new o.a(context);
        aVar2.ea(str);
        aVar2.beS(str2);
        aVar2.p(Boolean.TRUE);
        aVar2.Kfh = str3;
        aVar2.a(aVar).kdo.show();
        AppMethodBeat.o(31421);
    }

    @Override // com.tencent.mm.pluginsdk.j
    public final void c(Context context, String str, String str2, String str3, y.a aVar) {
        AppMethodBeat.i(258864);
        o.a aVar2 = new o.a(context);
        aVar2.ea(str);
        aVar2.beQ(str2);
        aVar2.p(Boolean.TRUE);
        aVar2.gpx();
        aVar2.Kfh = str3;
        aVar2.a(aVar).kdo.show();
        AppMethodBeat.o(258864);
    }

    @Override // com.tencent.mm.pluginsdk.j
    public final void G(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(232197);
        EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(str2);
        a aVar = a.hdT;
        String W = EmojiLogic.W(a.awt(), "", str2);
        if (blk == null) {
            int i2 = ImgUtil.isGif(W) ? EmojiInfo.VkY : EmojiInfo.VkX;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str2;
            emojiInfo.field_catalog = EmojiInfo.VkQ;
            emojiInfo.field_type = i2;
            emojiInfo.field_size = (int) s.boW(W);
            emojiInfo.field_temp = 1;
            emojiInfo.field_designerID = str3;
            emojiInfo.field_thumbUrl = str4;
            k.getEmojiStorageMgr().OpN.J(emojiInfo);
            blk = emojiInfo;
        }
        k.cGf().a(str, blk, (ca) null);
        AppMethodBeat.o(232197);
    }

    @Override // com.tencent.mm.pluginsdk.j
    public final void b(Context context, String str, String str2, String str3, String str4, String str5, y.a aVar) {
        AppMethodBeat.i(232198);
        EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(str2);
        a aVar2 = a.hdT;
        String W = EmojiLogic.W(a.awt(), "", str2);
        if (blk == null) {
            int i2 = ImgUtil.isGif(W) ? EmojiInfo.VkY : EmojiInfo.VkX;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str2;
            emojiInfo.field_catalog = EmojiInfo.VkQ;
            emojiInfo.field_type = i2;
            emojiInfo.field_size = (int) s.boW(W);
            emojiInfo.field_temp = 1;
            emojiInfo.field_designerID = str3;
            emojiInfo.field_thumbUrl = str5;
            k.getEmojiStorageMgr().OpN.J(emojiInfo);
            blk = emojiInfo;
        }
        o.a aVar3 = new o.a(context);
        aVar3.ea(str);
        aVar3.a(blk, str4);
        aVar3.p(Boolean.TRUE);
        aVar3.Kfh = context.getString(R.string.yq);
        aVar3.a(aVar).kdo.show();
        AppMethodBeat.o(232198);
    }

    @Override // com.tencent.mm.pluginsdk.j
    public final void b(Context context, String str, String str2, String str3, y.a aVar) {
        AppMethodBeat.i(31422);
        EmojiInfo blk = bj.gCJ().OpN.blk(str2);
        o.a aVar2 = new o.a(context);
        aVar2.ea(str).a(blk, str3).p(Boolean.FALSE).aii(R.string.yq);
        aVar2.beP(context.getResources().getString(R.string.g5h));
        aVar2.a(aVar).kdo.show();
        AppMethodBeat.o(31422);
    }
}
