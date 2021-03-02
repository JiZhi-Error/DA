package com.tencent.mm.emoji.d;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;

public abstract class d {
    protected EmojiInfo gWm;
    protected long gXF = Util.nowMilliSecond();
    protected boolean gXv;
    protected boolean hdB;
    public a hdF;

    public interface a {
        void A(int i2, String str);
    }

    public d(EmojiInfo emojiInfo, boolean z, a aVar) {
        this.gWm = emojiInfo;
        this.gXv = z;
        this.hdF = aVar;
        this.hdB = ImgUtil.isWXGF(emojiInfo.hYx());
        Log.i("MicroMsg.EmojiUpload", "EmojiUpload: %s, %s, %s", emojiInfo.field_md5, Boolean.valueOf(z), Boolean.valueOf(this.hdB));
    }

    /* access modifiers changed from: protected */
    public final void EW(String str) {
        Log.i("MicroMsg.EmojiUpload", "save emoji gif md5, wxam %b, md5 %s, %s", Boolean.valueOf(this.gWm.hYo()), str, this.gWm.field_wxamMd5);
        if (!this.hdB || Util.isNullOrNil(str)) {
            this.gWm.a(EmojiInfo.a.STATUS_SUCCESS);
            ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(this.gWm);
            return;
        }
        String hYx = this.gWm.hYx();
        String hYy = this.gWm.hYy();
        s.nw(hYx, EmojiInfo.hYz() + str);
        String str2 = this.gWm.field_md5;
        this.gWm.field_md5 = str;
        this.gWm.field_externMd5 = this.gWm.field_wxamMd5;
        this.gWm.a(EmojiInfo.a.STATUS_SUCCESS);
        s.nw(hYy, this.gWm.hYy());
        ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.J(this.gWm);
        ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.dj(str2, true);
    }

    public final void aws() {
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            C(5, null);
        } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            C(6, null);
        } else {
            C(7, null);
        }
    }

    /* access modifiers changed from: protected */
    public final void pt(int i2) {
        C(i2, null);
    }

    /* access modifiers changed from: protected */
    public final void C(int i2, String str) {
        if (this.hdF != null) {
            this.hdF.A(i2, str);
        }
    }
}
