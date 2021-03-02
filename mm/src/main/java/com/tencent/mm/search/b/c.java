package com.tencent.mm.search.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "onClick", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class c extends d {
    public static final a NJu = new a((byte) 0);

    static {
        AppMethodBeat.i(105840);
        AppMethodBeat.o(105840);
    }

    public c(int i2) {
        super(i2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.emoji.panel.a.n, com.tencent.mm.emoji.panel.a.d
    public final void a(View view, Context context, int i2, ac acVar) {
        AppMethodBeat.i(200087);
        p.h(context, "context");
        if (acVar == null) {
            AppMethodBeat.o(200087);
            return;
        }
        Log.i("MicroMsg.SimilarEmoji", "onClick: " + i2 + ", " + ((h) acVar).gWm.field_md5);
        switch (((h) acVar).gYc) {
            case 103:
                com.tencent.mm.search.c.a aVar = com.tencent.mm.search.c.a.NJv;
                com.tencent.mm.search.c.a.gxv();
                EmojiInfo emojiInfo = ((h) acVar).gWm;
                bj gCJ = bj.gCJ();
                p.g(gCJ, "EmojiStorageMgr.getInstance()");
                if (gCJ.cgN().blk(emojiInfo.field_md5) == null) {
                    bj gCJ2 = bj.gCJ();
                    p.g(gCJ2, "EmojiStorageMgr.getInstance()");
                    gCJ2.cgN().K(emojiInfo);
                }
                AppMethodBeat.o(200087);
                return;
            default:
                AppMethodBeat.o(200087);
                return;
        }
    }
}
