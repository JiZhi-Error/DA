package com.tencent.mm.emoji.e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/emoji/util/EmojiSendCheck;", "", "context", "Landroid/content/Context;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "goToDetail", "", "callback", "Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ZLcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "getContext", "()Landroid/content/Context;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getGoToDetail", "()Z", "checkExchange", "", "showErrorDialog", "msg", "showPurchaseDialog", "CheckCallback", "plugin-emojisdk_release"})
public final class c {
    final String TAG = "MicroMsg.EmojiSendCheck";
    final Context context;
    EmojiInfo gWm;
    final boolean hdU;
    final a hdV;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "", "onResult", "", "canSend", "", "plugin-emojisdk_release"})
    public interface a {
        void dQ(boolean z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/ExchangeEmotionPackResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c hdW;

        b(c cVar) {
            this.hdW = cVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(200007);
            c.a aVar = (c.a) obj;
            int i2 = aVar.errType;
            int i3 = aVar.errCode;
            Log.i(this.hdW.TAG, "checkExchange: cgi result: " + i2 + ", " + i3);
            if (i2 == 0 && i3 == 0) {
                d dVar = d.hdY;
                String str = this.hdW.gWm.field_groupId;
                p.g(str, "emojiInfo.field_groupId");
                d.Fa(str);
                this.hdW.hdV.dQ(true);
            } else if (i3 == 4) {
                c cVar = this.hdW;
                com.tencent.mm.ui.widget.a.d X = h.X(cVar.context, cVar.context.getString(R.string.br4), "");
                if (cVar.hdU) {
                    X.b(R.string.sz, DialogInterface$OnClickListenerC0324c.hdX);
                    X.a(R.string.br6, new d(cVar));
                }
                this.hdW.hdV.dQ(false);
            } else if (i3 == 9) {
                c cVar2 = this.hdW;
                String string = this.hdW.context.getString(R.string.btm);
                p.g(string, "context.getString(R.stri…oji_send_product_expired)");
                c.a(cVar2, string);
                this.hdW.hdV.dQ(false);
            } else {
                c cVar3 = this.hdW;
                String string2 = this.hdW.context.getString(R.string.btj);
                p.g(string2, "context.getString(R.stri…emoji_send_exchange_fail)");
                c.a(cVar3, string2);
                this.hdW.hdV.dQ(false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(200007);
            return xVar;
        }
    }

    public c(Context context2, EmojiInfo emojiInfo, boolean z, a aVar) {
        p.h(context2, "context");
        p.h(emojiInfo, "emojiInfo");
        p.h(aVar, "callback");
        AppMethodBeat.i(200010);
        this.context = context2;
        this.gWm = emojiInfo;
        this.hdU = z;
        this.hdV = aVar;
        if (!com.tencent.mm.plugin.emoji.h.b.x(this.gWm) && !com.tencent.mm.plugin.emoji.h.b.y(this.gWm) && !Util.isNullOrNil(this.gWm.field_groupId)) {
            d dVar = d.hdY;
            String str = this.gWm.field_groupId;
            p.g(str, "emojiInfo.field_groupId");
            if (!d.EZ(str)) {
                String str2 = this.gWm.field_groupId;
                p.g(str2, "emojiInfo.field_groupId");
                new com.tencent.mm.emoji.b.a.a(str2).aYI().g(new b(this));
                Log.i(this.TAG, "do exchange %s %s", this.gWm.field_md5, this.gWm.field_groupId);
                AppMethodBeat.o(200010);
                return;
            }
        }
        Log.i(this.TAG, "no need exchange %s %s", this.gWm.field_md5, this.gWm.field_groupId);
        this.hdV.dQ(true);
        AppMethodBeat.o(200010);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.emoji.e.c$c  reason: collision with other inner class name */
    static final class DialogInterface$OnClickListenerC0324c implements DialogInterface.OnClickListener {
        public static final DialogInterface$OnClickListenerC0324c hdX = new DialogInterface$OnClickListenerC0324c();

        static {
            AppMethodBeat.i(200008);
            AppMethodBeat.o(200008);
        }

        DialogInterface$OnClickListenerC0324c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class d implements DialogInterface.OnClickListener {
        final /* synthetic */ c hdW;

        d(c cVar) {
            this.hdW = cVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(200009);
            Intent intent = new Intent();
            intent.putExtra("extra_id", this.hdW.gWm.field_groupId);
            intent.putExtra("preceding_scence", 20);
            com.tencent.mm.br.c.b(this.hdW.context, "emoji", ".ui.EmojiStoreDetailUI", intent);
            AppMethodBeat.o(200009);
        }
    }

    public static final /* synthetic */ void a(c cVar, String str) {
        AppMethodBeat.i(200011);
        p.g(h.X(cVar.context, str, ""), "MMAlert.showAlert(context, msg, \"\")");
        AppMethodBeat.o(200011);
    }
}
