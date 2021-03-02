package com.tencent.mm.search.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.a.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J,\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "handlePayEmoji", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class b extends d {
    public static final a NJt = new a((byte) 0);
    public SimilarEmojiQueryModel hek;

    static {
        AppMethodBeat.i(105838);
        AppMethodBeat.o(105838);
    }

    public b(int i2) {
        super(i2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.emoji.panel.a.n, com.tencent.mm.emoji.panel.a.d
    public final void a(View view, Context context, int i2, ac acVar) {
        AppMethodBeat.i(200086);
        p.h(context, "context");
        if (acVar == null) {
            AppMethodBeat.o(200086);
        } else if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(context)) {
            AppMethodBeat.o(200086);
        } else {
            Log.i("MicroMsg.SimilarEmoji", "onClick: " + i2 + ", md5 :" + (acVar instanceof h ? ((h) acVar).gWm.field_md5 : ""));
            if (!(acVar instanceof h) || ((h) acVar).gYc != 102) {
                if ((acVar instanceof ah) && ((ah) acVar).gYc == 101) {
                    if (this.hek == null) {
                        Log.i("MicroMsg.SimilarEmoji", "can not jump for null data!");
                        AppMethodBeat.o(200086);
                        return;
                    }
                    com.tencent.mm.search.c.b bVar = com.tencent.mm.search.c.b.NJx;
                    com.tencent.mm.search.c.b.gxy();
                    Intent intent = new Intent();
                    intent.putExtra("KEY_NET_PARAM", this.hek);
                    c.b(((u) context).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", intent, 229);
                }
                AppMethodBeat.o(200086);
                return;
            }
            com.tencent.mm.search.c.a aVar = com.tencent.mm.search.c.a.NJv;
            com.tencent.mm.search.c.a.gxu();
            com.tencent.mm.search.c.b bVar2 = com.tencent.mm.search.c.b.NJx;
            com.tencent.mm.search.c.b.b(((h) acVar).gWm, (long) i2);
            if (((h) acVar).gWm.Vln == 1) {
                if (!Util.isNullOrNil(((h) acVar).gWm.avy())) {
                    com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                    p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                    if (((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr().amq(((h) acVar).gWm.avy())) {
                        Log.i("MicroMsg.SimilarEmoji", "buy and resend emoji");
                    }
                }
                EmojiInfo emojiInfo = ((h) acVar).gWm;
                d.a aVar2 = new d.a(context);
                aVar2.bon("");
                aVar2.boo(context.getString(R.string.h2n));
                aVar2.Dk(true);
                aVar2.aoV(R.string.br6).c(new DialogInterface$OnClickListenerC2055b(emojiInfo, context));
                aVar2.aoW(R.string.sz);
                com.tencent.mm.ui.widget.a.d hbn = aVar2.hbn();
                p.g(hbn, "alert");
                Window window = hbn.getWindow();
                if (window != null) {
                    window.setSoftInputMode(48);
                    window.setFlags(131072, 131072);
                }
                hbn.show();
                AppMethodBeat.o(200086);
                return;
            }
            EmojiInfo emojiInfo2 = ((h) acVar).gWm;
            bj gCJ = bj.gCJ();
            p.g(gCJ, "EmojiStorageMgr.getInstance()");
            if (gCJ.cgN().blk(emojiInfo2.field_md5) == null) {
                bj gCJ2 = bj.gCJ();
                p.g(gCJ2, "EmojiStorageMgr.getInstance()");
                gCJ2.cgN().K(emojiInfo2);
            }
            j jVar = this.haC;
            if (jVar != null) {
                jVar.B(emojiInfo2);
                AppMethodBeat.o(200086);
                return;
            }
            AppMethodBeat.o(200086);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.search.b.b$b  reason: collision with other inner class name */
    static final class DialogInterface$OnClickListenerC2055b implements DialogInterface.OnClickListener {
        final /* synthetic */ Context $context;
        final /* synthetic */ EmojiInfo haF;

        DialogInterface$OnClickListenerC2055b(EmojiInfo emojiInfo, Context context) {
            this.haF = emojiInfo;
            this.$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(105836);
            Intent intent = new Intent();
            intent.putExtra("extra_id", this.haF.field_groupId);
            intent.putExtra("preceding_scence", 20);
            Context context = this.$context;
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMContextThemeWrapper");
                AppMethodBeat.o(105836);
                throw tVar;
            }
            c.b(((u) context).getBaseContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
            dialogInterface.cancel();
            AppMethodBeat.o(105836);
        }
    }
}
