package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ai;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.m;
import com.tencent.mm.emoji.b.b.u;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.c.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J,\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J,\u0010&\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006)"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "scene", "", "(I)V", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getEmojiCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "setEmojiCallback", "(Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getScene", "()I", "setScene", "talkerName", "", "getTalkerName", "()Ljava/lang/String;", "setTalkerName", "(Ljava/lang/String;)V", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "dealCaptureEmojiClick", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "startCustomManager", "uploadEmoji", "plugin-emojisdk_release"})
public class d implements n {
    public j haC;
    public String haD;
    public ChatFooterPanel.a har;
    public int scene;

    public d(int i2) {
        this.scene = i2;
    }

    @Override // com.tencent.mm.emoji.panel.a.n
    public void a(View view, Context context, int i2) {
        AppMethodBeat.i(199965);
        p.h(context, "context");
        AppMethodBeat.o(199965);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.emoji.panel.a.n
    public void a(View view, Context context, int i2, ac acVar) {
        EmojiInfo emojiInfo;
        String string;
        AppMethodBeat.i(199966);
        p.h(context, "context");
        Log.i(f.TAG, "onClick: " + i2 + ", " + acVar);
        if (acVar == null) {
            AppMethodBeat.o(199966);
            return;
        }
        h.awf().scene = this.scene;
        com.tencent.mm.emoji.c.c.awc().scene = this.scene;
        switch (acVar.type) {
            case 0:
                com.tencent.mm.emoji.b.b.h hVar = (com.tencent.mm.emoji.b.b.h) acVar;
                EmojiInfo emojiInfo2 = hVar.gWm;
                EmojiInfo emojiInfo3 = hVar.gWm;
                if (emojiInfo3.getGroup() == EmojiGroupInfo.VkO) {
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                    p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                    EmojiInfo p = ((com.tencent.mm.plugin.emoji.b.d) ah).getProvider().p(emojiInfo3);
                    p.g(p, "MMKernel.plugin(IPluginE…er.getRandomEmoji(toSend)");
                    emojiInfo = p;
                } else {
                    emojiInfo = emojiInfo3;
                }
                h.awf().b(i2, emojiInfo2.field_md5, emojiInfo2.field_groupId, emojiInfo2.field_designerID, emojiInfo2.field_activityid);
                j jVar = this.haC;
                if (jVar != null) {
                    jVar.B(emojiInfo);
                    AppMethodBeat.o(199966);
                    return;
                }
                AppMethodBeat.o(199966);
                return;
            case 1:
                ai aiVar = (ai) acVar;
                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                p.g(ah2, "MMKernel.plugin(IPluginEmoji::class.java)");
                ((com.tencent.mm.plugin.emoji.b.d) ah2).getProvider().amy(aiVar.gZf.key);
                String bie = com.tencent.mm.ce.e.gxR().bie(aiVar.gZf.key);
                p.g(bie, "MergerSmileyManager.getI…mileyItem.smileyInfo.key)");
                com.tencent.mm.emoji.c.a aVar = com.tencent.mm.emoji.c.a.hbZ;
                com.tencent.mm.emoji.c.a.ed(aiVar.gZg);
                com.tencent.mm.emoji.c.c.awc().a(n.j(bie, ",", " ", false), aiVar.gZg, aiVar.gZh);
                ChatFooterPanel.a aVar2 = this.har;
                if (aVar2 != null) {
                    aVar2.append(bie);
                    AppMethodBeat.o(199966);
                    return;
                }
                AppMethodBeat.o(199966);
                return;
            case 2:
                com.tencent.mm.emoji.c.d dVar = com.tencent.mm.emoji.c.d.hcj;
                com.tencent.mm.emoji.c.d.pl(2);
                PersonalDesigner personalDesigner = ((u) acVar).gYM;
                if (personalDesigner != null) {
                    Intent intent = new Intent();
                    intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, personalDesigner.DesignerUin);
                    intent.putExtra("name", personalDesigner.Name);
                    intent.putExtra("headurl", personalDesigner.HeadUrl);
                    intent.putExtra("extra_scence", 9);
                    com.tencent.mm.br.c.b(context, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
                    break;
                }
                break;
            case 3:
                m mVar = (m) acVar;
                if (mVar.gYH == 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11594, 1);
                    com.tencent.mm.br.c.b(context, "emoji", ".ui.EmojiCustomUI", new Intent());
                    AppMethodBeat.o(199966);
                    return;
                }
                if (mVar.gYH == 1) {
                    com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                    p.g(ah3, "MMKernel.plugin(IPluginEmoji::class.java)");
                    com.tencent.mm.pluginsdk.a.e provider = ((com.tencent.mm.plugin.emoji.b.d) ah3).getProvider();
                    p.g(provider, "MMKernel.plugin(IPluginEmoji::class.java).provider");
                    if (provider.avf()) {
                        i.a aVar3 = i.gYr;
                        com.tencent.mm.plugin.emojicapture.api.b.b(context, i.a.ph(this.scene), this.haD);
                    }
                }
                AppMethodBeat.o(199966);
                return;
            case 4:
                AppMethodBeat.o(199966);
                return;
            case 6:
                EmojiInfo emojiInfo4 = ((com.tencent.mm.emoji.b.b.h) acVar).gWm;
                Log.i(f.TAG, "penn send capture emoji click emoji: %s status: %d.", emojiInfo4.getMd5(), Integer.valueOf(emojiInfo4.field_captureStatus));
                EmojiInfo.a hYs = emojiInfo4.hYs();
                if (hYs == null) {
                    AppMethodBeat.o(199966);
                    return;
                }
                switch (e.haE[hYs.ordinal()]) {
                    case 1:
                        j jVar2 = this.haC;
                        if (jVar2 != null) {
                            jVar2.B(emojiInfo4);
                        }
                        Log.d(f.TAG, "onSendCustomEmoji emoji md5 is [%s].", emojiInfo4.getMd5());
                        AppMethodBeat.o(199966);
                        return;
                    case 2:
                    case 3:
                        com.tencent.mm.ui.base.h.cA(context, context.getString(R.string.brj));
                        AppMethodBeat.o(199966);
                        return;
                    case 4:
                        f.a aVar4 = new f.a(context);
                        aVar4.bow(context.getString(R.string.bre)).apa(R.string.bwr).apb(context.getResources().getColor(R.color.a5e));
                        aVar4.c(new a(emojiInfo4)).show();
                        AppMethodBeat.o(199966);
                        return;
                    case 5:
                        EmojiInfo.b hYv = emojiInfo4.hYv();
                        Log.d(f.TAG, "CaptureUploadErrCode: %d.", Integer.valueOf(hYv.ordinal()));
                        if (hYv != null) {
                            switch (e.$EnumSwitchMapping$0[hYv.ordinal()]) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                    f.a aVar5 = new f.a(context);
                                    aVar5.bow(context.getString(R.string.bri)).apa(R.string.brg);
                                    aVar5.c(new b(this, context, emojiInfo4)).show();
                                    AppMethodBeat.o(199966);
                                    return;
                                case 5:
                                    k kVar = k.gXr;
                                    if (k.auQ()) {
                                        f.a aVar6 = new f.a(context);
                                        aVar6.bow(context.getString(R.string.bwq)).boA(context.getString(R.string.buo));
                                        aVar6.c(new c(context)).show();
                                        AppMethodBeat.o(199966);
                                        return;
                                    }
                                    f.a aVar7 = new f.a(context);
                                    aVar7.bow(context.getString(R.string.bri)).apa(R.string.brg);
                                    aVar7.c(new C0332d(this, context, emojiInfo4)).show();
                                    AppMethodBeat.o(199966);
                                    return;
                                case 6:
                                    f.a aVar8 = new f.a(context);
                                    aVar8.bow(context.getString(R.string.bri)).apa(R.string.brg);
                                    aVar8.c(new e(this, context, emojiInfo4)).show();
                                    AppMethodBeat.o(199966);
                                    return;
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                    if (EmojiInfo.b.ERR_LOCAL_FILE == emojiInfo4.hYv()) {
                                        string = context.getString(R.string.bre);
                                        p.g(string, "context.getString(R.stri…ailure_upload_local_file)");
                                    } else if (EmojiInfo.b.ERR_OVER_SIZE == emojiInfo4.hYv()) {
                                        string = context.getString(R.string.bs2);
                                        p.g(string, "context.getString(R.stri…ustom_gif_max_size_limit)");
                                    } else if (EmojiInfo.b.ERR_SPAM == emojiInfo4.hYv()) {
                                        string = context.getString(R.string.brh);
                                        p.g(string, "context.getString(R.stri…ture_failure_upload_spam)");
                                    } else {
                                        string = context.getString(R.string.brf);
                                        p.g(string, "context.getString(R.stri…ad_over_upload_max_count)");
                                    }
                                    f.a aVar9 = new f.a(context);
                                    aVar9.bow(string).apa(R.string.bwr).apb(context.getResources().getColor(R.color.a5e));
                                    aVar9.c(new f(emojiInfo4)).show();
                                    AppMethodBeat.o(199966);
                                    return;
                            }
                        }
                        f.a aVar10 = new f.a(context);
                        aVar10.bow(context.getString(R.string.bri)).apa(R.string.brg);
                        aVar10.c(new g(this, context, emojiInfo4)).show();
                        break;
                }
                AppMethodBeat.o(199966);
                return;
            case 7:
                com.tencent.mm.kernel.b.a ah4 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                p.g(ah4, "MMKernel.plugin(IPluginEmoji::class.java)");
                com.tencent.mm.pluginsdk.a.e provider2 = ((com.tencent.mm.plugin.emoji.b.d) ah4).getProvider();
                p.g(provider2, "MMKernel.plugin(IPluginEmoji::class.java).provider");
                if (provider2.avf()) {
                    i.a aVar11 = i.gYr;
                    com.tencent.mm.plugin.emojicapture.api.b.b(context, i.a.ph(this.scene), this.haD);
                    AppMethodBeat.o(199966);
                    return;
                }
                break;
        }
        AppMethodBeat.o(199966);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class a implements f.c {
        final /* synthetic */ EmojiInfo haF;

        a(EmojiInfo emojiInfo) {
            this.haF = emojiInfo;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(105632);
            if (z && !Util.isNullOrNil(this.haF.getMd5())) {
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr().amB(this.haF.getMd5());
            }
            AppMethodBeat.o(105632);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class b implements f.c {
        final /* synthetic */ Context $context;
        final /* synthetic */ EmojiInfo haF;
        final /* synthetic */ d haG;

        b(d dVar, Context context, EmojiInfo emojiInfo) {
            this.haG = dVar;
            this.$context = context;
            this.haF = emojiInfo;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(105633);
            if (z) {
                d.m(this.haF);
            }
            AppMethodBeat.o(105633);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class c implements f.c {
        final /* synthetic */ Context $context;

        c(Context context) {
            this.$context = context;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(105634);
            if (z) {
                Intent intent = new Intent();
                intent.putExtra("key_emoji_panel_type", 1);
                com.tencent.mm.br.c.b(this.$context, "emoji", ".ui.EmojiCustomUI", intent);
            }
            AppMethodBeat.o(105634);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    /* renamed from: com.tencent.mm.emoji.panel.a.d$d  reason: collision with other inner class name */
    static final class C0332d implements f.c {
        final /* synthetic */ Context $context;
        final /* synthetic */ EmojiInfo haF;
        final /* synthetic */ d haG;

        C0332d(d dVar, Context context, EmojiInfo emojiInfo) {
            this.haG = dVar;
            this.$context = context;
            this.haF = emojiInfo;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(105635);
            if (z) {
                d.m(this.haF);
            }
            AppMethodBeat.o(105635);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class e implements f.c {
        final /* synthetic */ Context $context;
        final /* synthetic */ EmojiInfo haF;
        final /* synthetic */ d haG;

        e(d dVar, Context context, EmojiInfo emojiInfo) {
            this.haG = dVar;
            this.$context = context;
            this.haF = emojiInfo;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(105636);
            if (z) {
                d.m(this.haF);
            }
            AppMethodBeat.o(105636);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class f implements f.c {
        final /* synthetic */ EmojiInfo haF;

        f(EmojiInfo emojiInfo) {
            this.haF = emojiInfo;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(105637);
            if (z && !Util.isNullOrNil(this.haF.getMd5())) {
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr().amB(this.haF.getMd5());
            }
            AppMethodBeat.o(105637);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class g implements f.c {
        final /* synthetic */ Context $context;
        final /* synthetic */ EmojiInfo haF;
        final /* synthetic */ d haG;

        g(d dVar, Context context, EmojiInfo emojiInfo) {
            this.haG = dVar;
            this.$context = context;
            this.haF = emojiInfo;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(161814);
            if (z) {
                d.m(this.haF);
            }
            AppMethodBeat.o(161814);
        }
    }

    public static final /* synthetic */ void m(EmojiInfo emojiInfo) {
        AppMethodBeat.i(161815);
        EmojiInfo.a hYs = emojiInfo.hYs();
        emojiInfo.a(EmojiInfo.a.STATUS_UPLOADING);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr().updateEmojiInfo(emojiInfo);
        emojiInfo.a(hYs);
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(ah2, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d) ah2).getProvider().amC(emojiInfo.field_md5);
        AppMethodBeat.o(161815);
    }
}
