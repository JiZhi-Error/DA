package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.g.b.a.ig;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "position", "", "(Landroid/content/Context;Lcom/tencent/mm/emoji/model/panel/EmojiItem;Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;I)V", "getContext", "()Landroid/content/Context;", "getData", "()Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getPosition", "()I", "doAddAction", "", "md5", "", "designerID", "thumbUrl", "activityId", "getReportScene", "", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "plugin-webview_release"})
public final class b implements o.g {
    private final h INy;
    private final c INz;
    private final Context context;
    private final int position;

    public b(Context context2, h hVar, c cVar, int i2) {
        p.h(context2, "context");
        p.h(cVar, "data");
        AppMethodBeat.i(210289);
        this.context = context2;
        this.INy = hVar;
        this.INz = cVar;
        this.position = i2;
        AppMethodBeat.o(210289);
    }

    private long gaq() {
        AppMethodBeat.i(210287);
        if (this.INz.gau()) {
            AppMethodBeat.o(210287);
            return 59;
        }
        AppMethodBeat.o(210287);
        return 78;
    }

    @Override // com.tencent.mm.ui.base.o.g
    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        EmojiInfo emojiInfo;
        EmojiInfo emojiInfo2;
        AppMethodBeat.i(210288);
        if (menuItem != null) {
            switch (menuItem.getItemId()) {
                case 0:
                    h hVar = this.INy;
                    if (hVar != null) {
                        String md5 = hVar.gWm.getMd5();
                        if (md5 == null) {
                            str = "";
                        } else {
                            str = md5;
                        }
                        String str9 = hVar.gWm.field_designerID;
                        if (str9 == null) {
                            str2 = "";
                        } else {
                            str2 = str9;
                        }
                        String str10 = hVar.gWm.field_thumbUrl;
                        if (str10 == null) {
                            str3 = "";
                        } else {
                            str3 = str10;
                        }
                        String str11 = hVar.gWm.field_activityid;
                        if (str11 == null) {
                            str4 = "";
                        } else {
                            str4 = str11;
                        }
                        ig igVar = new ig();
                        igVar.ri(gaq());
                        igVar.vZ(this.INz.sessionId);
                        igVar.wa(this.INz.rjq);
                        h hVar2 = this.INy;
                        if (hVar2 == null || (emojiInfo2 = hVar2.gWm) == null || (str5 = emojiInfo2.field_md5) == null) {
                            str5 = "";
                        }
                        igVar.wb(str5);
                        SimilarEmojiQueryModel similarEmojiQueryModel = this.INz.INC;
                        if (similarEmojiQueryModel == null || (str6 = similarEmojiQueryModel.emojiMD5) == null) {
                            str6 = "";
                        }
                        igVar.wc(str6);
                        igVar.rj((long) this.INz.offset);
                        igVar.rk((long) this.position);
                        igVar.rl(System.currentTimeMillis());
                        igVar.wd(this.INz.rjq);
                        igVar.rm(2);
                        igVar.bfK();
                        ar.a(igVar);
                        bj emojiStorageMgr = k.getEmojiStorageMgr();
                        p.g(emojiStorageMgr, "SubCoreEmoji.getEmojiStorageMgr()");
                        EmojiInfo blk = emojiStorageMgr.cgN().blk(str);
                        String W = EmojiLogic.W(com.tencent.mm.plugin.emoji.h.b.aTd(), "", str);
                        if (blk == null) {
                            int i3 = ImgUtil.isGif(W) ? EmojiInfo.VkY : EmojiInfo.VkX;
                            EmojiInfo emojiInfo3 = new EmojiInfo();
                            emojiInfo3.setMd5(str);
                            emojiInfo3.axt(EmojiInfo.VkQ);
                            emojiInfo3.setType(i3);
                            emojiInfo3.setSize((int) s.boW(W));
                            emojiInfo3.hYr();
                            emojiInfo3.field_designerID = str2;
                            emojiInfo3.field_thumbUrl = str3;
                            emojiInfo3.field_activityid = str4;
                            bj emojiStorageMgr2 = k.getEmojiStorageMgr();
                            p.g(emojiStorageMgr2, "SubCoreEmoji.getEmojiStorageMgr()");
                            emojiStorageMgr2.cgN().J(emojiInfo3);
                            blk = emojiInfo3;
                        }
                        Log.i("MicroMsg.WebSearch.SosSimilarUI", "doAddAction %b", Boolean.valueOf(k.cGf().a(this.context, blk, 18, z.aTY())));
                        ig igVar2 = new ig();
                        igVar2.ri(gaq());
                        igVar2.vZ(this.INz.rjq);
                        igVar2.wa(this.INz.rjq);
                        h hVar3 = this.INy;
                        if (hVar3 == null || (emojiInfo = hVar3.gWm) == null || (str7 = emojiInfo.field_md5) == null) {
                            str7 = "";
                        }
                        igVar2.wb(str7);
                        SimilarEmojiQueryModel similarEmojiQueryModel2 = this.INz.INC;
                        if (similarEmojiQueryModel2 == null || (str8 = similarEmojiQueryModel2.emojiMD5) == null) {
                            str8 = "";
                        }
                        igVar2.wc(str8);
                        igVar2.rj((long) this.INz.offset);
                        igVar2.rk((long) this.position);
                        igVar2.rl(System.currentTimeMillis());
                        igVar2.wd(this.INz.rjq);
                        igVar2.rm(3);
                        igVar2.bfK();
                        ar.a(igVar2);
                        AppMethodBeat.o(210288);
                        return;
                    }
                    break;
            }
        }
        AppMethodBeat.o(210288);
    }
}
