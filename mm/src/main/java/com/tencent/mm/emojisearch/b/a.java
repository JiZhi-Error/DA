package com.tencent.mm.emojisearch.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.a.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J,\u0010#\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0014\u0010\t\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f¨\u0006%"}, hxF = {"Lcom/tencent/mm/emojisearch/logic/EmojiSearchPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "show", "Lkotlin/Function0;", "", "dismiss", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "EmojiSearchRequestCode", "getEmojiSearchRequestCode", "()I", "getDismiss", "()Lkotlin/jvm/functions/Function0;", "setDismiss", "(Lkotlin/jvm/functions/Function0;)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "getShow", "setShow", "handlePayEmoji", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "Companion", "plugin-emojisdk_release"})
public final class a extends d {
    public static final C0341a heo = new C0341a((byte) 0);
    public SimilarEmojiQueryModel hek;
    private final int hel;
    kotlin.g.a.a<x> hem;
    private kotlin.g.a.a<x> hen;

    static {
        AppMethodBeat.i(200025);
        AppMethodBeat.o(200025);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(int i2, kotlin.g.a.a<x> aVar, kotlin.g.a.a<x> aVar2) {
        super(i2);
        p.h(aVar, "show");
        p.h(aVar2, "dismiss");
        AppMethodBeat.i(200024);
        this.hem = aVar;
        this.hen = aVar2;
        AppMethodBeat.o(200024);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/emojisearch/logic/EmojiSearchPanelClickListener$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emojisearch.b.a$a  reason: collision with other inner class name */
    public static final class C0341a {
        private C0341a() {
        }

        public /* synthetic */ C0341a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.emoji.panel.a.n, com.tencent.mm.emoji.panel.a.d
    public final void a(View view, Context context, int i2) {
        AppMethodBeat.i(200022);
        p.h(context, "context");
        AppMethodBeat.o(200022);
    }

    @Override // com.tencent.mm.emoji.panel.a.n, com.tencent.mm.emoji.panel.a.d
    public final void a(View view, Context context, int i2, ac acVar) {
        AppMethodBeat.i(200023);
        p.h(context, "context");
        if (acVar == null) {
            AppMethodBeat.o(200023);
            return;
        }
        Log.i("MicroMsg.EmojiSearch", "onClick: " + i2 + ", md5 :" + (acVar instanceof h ? ((h) acVar).gWm.field_md5 : ""));
        if ((acVar instanceof ah) && ((ah) acVar).gYc == 200) {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("check_clickflag", false);
            if (!Util.isNullOrNil(this.haD)) {
                intent.putExtra("to_talker_name", this.haD);
            }
            Context baseContext = ((u) context).getBaseContext();
            if (baseContext instanceof MMFragmentActivity) {
                ((MMFragmentActivity) baseContext).setMMOnFragmentActivityResult(new c(this));
            }
            com.tencent.mm.br.c.b(baseContext, "emoji", ".ui.v2.EmojiStoreV2UI", intent, this.hel);
            com.tencent.mm.emojisearch.d.a aVar = com.tencent.mm.emojisearch.d.a.hew;
            com.tencent.mm.emojisearch.d.a.awz();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11594, 2);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12065, 8);
            AppMethodBeat.o(200023);
        } else if (!(acVar instanceof h) || ((h) acVar).gYc != 202) {
            if ((acVar instanceof ah) && (((ah) acVar).gYc == 201 || ((ah) acVar).gYc == 203)) {
                if (this.hek == null) {
                    Log.i("MicroMsg.EmojiSearch", "can not jump for null data!");
                    AppMethodBeat.o(200023);
                    return;
                }
                com.tencent.mm.emojisearch.d.a aVar2 = com.tencent.mm.emojisearch.d.a.hew;
                com.tencent.mm.emojisearch.d.a.awA();
                Intent intent2 = new Intent();
                intent2.putExtra("KEY_NET_PARAM", this.hek);
                com.tencent.mm.br.c.b(((u) context).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", intent2, 230);
            }
            AppMethodBeat.o(200023);
        } else {
            com.tencent.mm.emojisearch.d.a aVar3 = com.tencent.mm.emojisearch.d.a.hew;
            String md5 = ((h) acVar).gWm.getMd5();
            p.g(md5, "item.emojiInfo.md5");
            com.tencent.mm.emojisearch.d.a.R(md5, i2);
            if (((h) acVar).gWm.Vln == 1) {
                if (!Util.isNullOrNil(((h) acVar).gWm.avy())) {
                    com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                    p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                    if (((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr().amq(((h) acVar).gWm.avy())) {
                        Log.i("MicroMsg.EmojiSearch", "buy and resend emoji");
                    }
                }
                EmojiInfo emojiInfo = ((h) acVar).gWm;
                d.a aVar4 = new d.a(context);
                aVar4.bon("");
                aVar4.boo(context.getString(R.string.h2n));
                aVar4.Dk(true);
                aVar4.aoV(R.string.br6).c(new b(emojiInfo, context));
                aVar4.aoW(R.string.sz);
                com.tencent.mm.ui.widget.a.d hbn = aVar4.hbn();
                p.g(hbn, "alert");
                Window window = hbn.getWindow();
                if (window != null) {
                    window.setSoftInputMode(48);
                    window.setFlags(131072, 131072);
                }
                hbn.show();
                AppMethodBeat.o(200023);
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
            }
            j jVar2 = this.haC;
            if (jVar2 != null) {
                jVar2.eio();
            }
            this.hen.invoke();
            AppMethodBeat.o(200023);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class c implements MMFragmentActivity.b {
        final /* synthetic */ a hep;

        c(a aVar) {
            this.hep = aVar;
        }

        @Override // com.tencent.mm.ui.MMFragmentActivity.b
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(200021);
            Log.i("MicroMsg.EmojiSearch", "onActivityResult.");
            if (i2 == i2) {
                this.hep.hem.invoke();
            }
            AppMethodBeat.o(200021);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ Context $context;
        final /* synthetic */ EmojiInfo haF;

        b(EmojiInfo emojiInfo, Context context) {
            this.haF = emojiInfo;
            this.$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(200020);
            Intent intent = new Intent();
            intent.putExtra("extra_id", this.haF.field_groupId);
            intent.putExtra("preceding_scence", 20);
            Context context = this.$context;
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMContextThemeWrapper");
                AppMethodBeat.o(200020);
                throw tVar;
            }
            com.tencent.mm.br.c.b(((u) context).getBaseContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
            dialogInterface.cancel();
            AppMethodBeat.o(200020);
        }
    }
}
