package com.tencent.mm.emoji.panel;

import android.content.Context;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.e.e;
import com.tencent.mm.emoji.panel.layout.SmileyLayoutManager;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000eJ(\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0014J\u0006\u0010.\u001a\u00020\u001fR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "setConfig", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "deleteBg", "Landroid/view/View;", "deleteBtn", "Landroid/widget/ImageView;", "hideRect", "Landroid/graphics/Rect;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "sendBtn", "Landroid/widget/Button;", "sendListener", "Lkotlin/Function0;", "", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "touchClick", "Lcom/tencent/mm/emoji/panel/TouchToClick;", "bind", "onSizeChanged", "w", "h", "oldw", "oldh", "unbind", "plugin-emojisdk_release"})
public final class SmileyPanelView extends ConstraintLayout {
    private final String TAG;
    public i gYa;
    private final RecyclerView hak;
    private final ImageView hal;
    private final View ham;
    private final Button han;
    private final Rect hao;
    public final kotlin.g.a.a<x> hap;
    private final a haq;
    private ChatFooterPanel.a har;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmileyPanelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(105622);
        this.TAG = "MicroMsg.SmileyPanelView";
        this.hao = new Rect();
        this.haq = new a();
        View.inflate(context, R.layout.a2c, this);
        View findViewById = findViewById(R.id.c0p);
        p.g(findViewById, "findViewById(R.id.emoji_panel_group_recycler)");
        this.hak = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.c0n);
        p.g(findViewById2, "findViewById(R.id.emoji_panel_delete)");
        this.hal = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.c0o);
        p.g(findViewById3, "findViewById(R.id.emoji_panel_delete_bg)");
        this.ham = findViewById3;
        View findViewById4 = findViewById(R.id.c0u);
        p.g(findViewById4, "findViewById(R.id.emoji_panel_send)");
        this.han = (Button) findViewById4;
        this.hal.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.emoji.panel.SmileyPanelView.AnonymousClass1 */
            final /* synthetic */ SmileyPanelView has;

            {
                this.has = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(105617);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/SmileyPanelView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ChatFooterPanel.a textOperationListener = this.has.getTextOperationListener();
                if (textOperationListener != null) {
                    textOperationListener.aHC();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/SmileyPanelView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(105617);
            }
        });
        this.han.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.emoji.panel.SmileyPanelView.AnonymousClass2 */
            final /* synthetic */ SmileyPanelView has;

            {
                this.has = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(105618);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/SmileyPanelView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ChatFooterPanel.a textOperationListener = this.has.getTextOperationListener();
                if (textOperationListener != null) {
                    textOperationListener.aHD();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/SmileyPanelView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(105618);
            }
        });
        this.hal.setOnTouchListener(this.haq);
        this.hap = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.emoji.panel.SmileyPanelView.AnonymousClass3 */
            final /* synthetic */ SmileyPanelView has;

            {
                this.has = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(105619);
                i config = this.has.getConfig();
                if (config != null) {
                    if (config.gYn) {
                        this.has.han.setVisibility(0);
                        this.has.han.setEnabled(config.gYo);
                    } else {
                        this.has.han.setVisibility(8);
                    }
                    this.has.ham.setEnabled(config.gYo);
                    if (config.gYo) {
                        ImageView imageView = this.has.hal;
                        Context context = imageView.getContext();
                        p.g(context, "context");
                        e.a(imageView, R.raw.icons_outlined_emoji_del, context.getResources().getColor(R.color.FG_0));
                    } else {
                        e.a(this.has.hal, R.raw.icons_outlined_emoji_del, -3355444);
                    }
                    if (!config.gYo) {
                        a aVar = this.has.haq;
                        MTimerHandler mTimerHandler = aVar.hat;
                        if (mTimerHandler != null) {
                            mTimerHandler.stopTimer();
                        }
                        aVar.hat = null;
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(105619);
                return xVar;
            }
        };
        AppMethodBeat.o(105622);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmileyPanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(105623);
        AppMethodBeat.o(105623);
    }

    public final ChatFooterPanel.a getTextOperationListener() {
        return this.har;
    }

    public final void setTextOperationListener(ChatFooterPanel.a aVar) {
        this.har = aVar;
    }

    public final i getConfig() {
        return this.gYa;
    }

    public final void setConfig(i iVar) {
        this.gYa = iVar;
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(105621);
        super.onSizeChanged(i2, i3, i4, i5);
        post(new a(this));
        AppMethodBeat.o(105621);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ SmileyPanelView has;

        a(SmileyPanelView smileyPanelView) {
            this.has = smileyPanelView;
        }

        public final void run() {
            AppMethodBeat.i(105620);
            this.has.hao.setEmpty();
            this.has.hao.union(this.has.hal.getLeft(), this.has.hal.getTop(), this.has.hal.getRight(), this.has.hal.getBottom());
            this.has.hao.union(this.has.han.getLeft(), this.has.han.getTop(), this.has.han.getRight(), this.has.han.getBottom());
            RecyclerView.LayoutManager layoutManager = this.has.hak.getLayoutManager();
            if (!(layoutManager instanceof SmileyLayoutManager)) {
                layoutManager = null;
            }
            SmileyLayoutManager smileyLayoutManager = (SmileyLayoutManager) layoutManager;
            if (smileyLayoutManager != null) {
                Rect rect = this.has.hao;
                p.h(rect, "rect");
                smileyLayoutManager.hao.set(rect);
                smileyLayoutManager.avX();
                AppMethodBeat.o(105620);
                return;
            }
            AppMethodBeat.o(105620);
        }
    }
}
