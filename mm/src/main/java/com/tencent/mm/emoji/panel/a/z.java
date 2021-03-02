package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "gifAutoPlay", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getGifAutoPlay", "()Z", "setGifAutoPlay", "(Z)V", "icon", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "loadingView", "Landroid/widget/ProgressBar;", "getLoadingView", "()Landroid/widget/ProgressBar;", "payTip", "Landroid/widget/TextView;", "title", "getTitle", "()Landroid/widget/TextView;", "loadGif", "", "onBind", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "pauseGif", "plugin-emojisdk_release"})
public final class z extends q<h> {
    private final TextView hbb;
    public final CoverEmojiStatusView hbu;
    final ProgressBar hbv;
    private final TextView hbw;
    public boolean hbx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(View view, boolean z, n nVar) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(105688);
        this.hbx = z;
        View findViewById = view.findViewById(R.id.ur);
        p.g(findViewById, "itemView.findViewById(R.id.art_emoji_icon_iv)");
        this.hbu = (CoverEmojiStatusView) findViewById;
        this.hbv = (ProgressBar) view.findViewById(R.id.br0);
        View findViewById2 = view.findViewById(R.id.us);
        p.g(findViewById2, "itemView.findViewById(R.id.art_emoji_icon_text)");
        this.hbb = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.g9m);
        p.g(findViewById3, "itemView.findViewById(R.id.pay_tip)");
        this.hbw = (TextView) findViewById3;
        AppMethodBeat.o(105688);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        String str;
        AppMethodBeat.i(105687);
        p.h(acVar, "item");
        super.a(acVar);
        h hVar = (h) this.hbh;
        if (hVar != null) {
            if (this.hbv != null) {
                this.hbu.setStatusListener(new a(this));
                this.hbu.setImageDrawable(null);
                CoverEmojiStatusView.b statusListener = this.hbu.getStatusListener();
                if (statusListener != null) {
                    statusListener.po(0);
                }
            }
            this.hbw.setVisibility(hVar.gWm.Vln == 1 ? 0 : 8);
            this.hbu.stop();
            if (this.hbv == null) {
                EmojiInfo emojiInfo = this.hbu.getEmojiInfo();
                if (emojiInfo != null) {
                    str = emojiInfo.field_md5;
                } else {
                    str = null;
                }
                if (!p.j(str, hVar.gWm.field_md5)) {
                    CoverEmojiStatusView coverEmojiStatusView = this.hbu;
                    Context context = this.hbu.getContext();
                    p.g(context, "icon.context");
                    coverEmojiStatusView.setImageDrawable(new ColorDrawable(context.getResources().getColor(R.color.f3046d)));
                }
            }
            if (this.hbx) {
                this.hbu.setEmojiInfo(hVar.gWm);
                this.hbu.setContentDescription(hVar.gWm.MOK);
                AppMethodBeat.o(105687);
                return;
            }
            e eVar = e.gVM;
            e.a(hVar.gWm, (ImageView) this.hbu);
            AppMethodBeat.o(105687);
            return;
        }
        AppMethodBeat.o(105687);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, hxF = {"com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$onBind$1$1$1", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "onStatus", "", "status", "", "plugin-emojisdk_release", "com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$$special$$inlined$apply$lambda$1"})
    public static final class a implements CoverEmojiStatusView.b {
        final /* synthetic */ z hby;

        a(z zVar) {
            this.hby = zVar;
        }

        @Override // com.tencent.mm.emoji.view.CoverEmojiStatusView.b
        public final void po(final int i2) {
            AppMethodBeat.i(105686);
            d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.emoji.panel.a.z.a.AnonymousClass1 */
                final /* synthetic */ a hbz;

                {
                    this.hbz = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(105685);
                    if (i2 == 0) {
                        this.hbz.hby.hbv.setVisibility(0);
                    } else {
                        this.hbz.hby.hbv.setVisibility(8);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(105685);
                    return xVar;
                }
            });
            AppMethodBeat.o(105686);
        }
    }

    public final void avV() {
        String md5;
        AppMethodBeat.i(199980);
        Log.i("MicroMsg.SimilarEmoji", "loadGif");
        h hVar = (h) this.hbh;
        if (hVar != null) {
            EmojiInfo emojiInfo = this.hbu.getEmojiInfo();
            if (emojiInfo == null || (md5 = emojiInfo.getMd5()) == null || !md5.equals(hVar.gWm.getMd5())) {
                this.hbu.setEmojiInfo(hVar.gWm);
                AppMethodBeat.o(199980);
                return;
            }
            if (!this.hbu.isRunning()) {
                this.hbu.resume();
            }
            AppMethodBeat.o(199980);
            return;
        }
        AppMethodBeat.o(199980);
    }
}
