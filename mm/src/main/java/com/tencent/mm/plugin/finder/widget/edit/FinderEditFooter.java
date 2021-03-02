package com.tencent.mm.plugin.finder.widget.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0018\u001a\u00020\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\u001aH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "Lcom/tencent/mm/ui/widget/InputPanelLinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "alignBtn", "Landroid/widget/ImageButton;", "alignModeChangeListener", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "curAlignMode", "curEditMode", "emojiBtn", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyTextListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getCurrentAlignMode", "hideSmileyPanel", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "setAlignModeChangeListener", "setSmileyTextOperationListener", "showSmileyPanel", "switchAlignMode", "AlignModeChangeListener", "Companion", "plugin-finder_release"})
public final class FinderEditFooter extends InputPanelLinearLayout {
    private static final int wBV = 101;
    private static final int wBW = 102;
    private static final int wBX = 201;
    private static final int wBY = 202;
    public static final b wBZ = new b((byte) 0);
    private String TAG = "Finder.FinderEditFooter";
    private ChatFooterPanel rum;
    private ImageButton wBP;
    private ImageButton wBQ;
    private int wBR = wBV;
    private a wBS;
    private ChatFooterPanel.a wBT;
    private int wBU = wBX;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
    public interface a {
        void Lm(int i2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$Companion;", "", "()V", "ALIGN_MODE_CENTER", "", "getALIGN_MODE_CENTER", "()I", "ALIGN_MODE_LEFT", "getALIGN_MODE_LEFT", "EDIT_MODE_EMOJI", "getEDIT_MODE_EMOJI", "EDIT_MODE_KEYBOARD", "getEDIT_MODE_KEYBOARD", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(168575);
        AppMethodBeat.o(168575);
    }

    public FinderEditFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(168573);
        init();
        AppMethodBeat.o(168573);
    }

    public FinderEditFooter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(168574);
        init();
        AppMethodBeat.o(168574);
    }

    private final void init() {
        AppMethodBeat.i(168569);
        View.inflate(getContext(), R.layout.a_c, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.h93);
        View findViewById = findViewById(R.id.byx);
        p.g(findViewById, "findViewById(R.id.emoji_btn)");
        this.wBP = (ImageButton) findViewById;
        ImageButton imageButton = this.wBP;
        if (imageButton == null) {
            p.btv("emojiBtn");
        }
        imageButton.setOnClickListener(new c(this));
        View findViewById2 = findViewById(R.id.lt);
        p.g(findViewById2, "findViewById(R.id.alignment_btn)");
        this.wBQ = (ImageButton) findViewById2;
        ImageButton imageButton2 = this.wBQ;
        if (imageButton2 == null) {
            p.btv("alignBtn");
        }
        imageButton2.setOnClickListener(new d(this));
        ChatFooterPanel eZ = e.grv().eZ(getContext());
        p.g(eZ, "FooterFactory.getSmileyP…).getSmileyPanel(context)");
        this.rum = eZ;
        ChatFooterPanel chatFooterPanel = this.rum;
        if (chatFooterPanel == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel.setEntranceScene(ChatFooterPanel.tvw);
        ChatFooterPanel chatFooterPanel2 = this.rum;
        if (chatFooterPanel2 == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel2.setVisibility(8);
        ChatFooterPanel chatFooterPanel3 = this.rum;
        if (chatFooterPanel3 == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel3.setBackgroundResource(R.drawable.mc);
        ChatFooterPanel chatFooterPanel4 = this.rum;
        if (chatFooterPanel4 == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel4.goD();
        int validPanelHeight = KeyBoardUtil.getValidPanelHeight(getContext());
        ChatFooterPanel chatFooterPanel5 = this.rum;
        if (chatFooterPanel5 == null) {
            p.btv("smileyPanel");
        }
        linearLayout.addView(chatFooterPanel5, -1, validPanelHeight);
        AppMethodBeat.o(168569);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ FinderEditFooter wCa;

        c(FinderEditFooter finderEditFooter) {
            this.wCa = finderEditFooter;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168567);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int i2 = this.wCa.wBU;
            b bVar2 = FinderEditFooter.wBZ;
            if (i2 == FinderEditFooter.wBY) {
                FinderEditFooter.b(this.wCa);
                Context context = this.wCa.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(168567);
                    throw tVar;
                }
                ((MMActivity) context).showVKB();
                FinderEditFooter finderEditFooter = this.wCa;
                b bVar3 = FinderEditFooter.wBZ;
                finderEditFooter.wBU = FinderEditFooter.wBX;
            } else {
                Context context2 = this.wCa.getContext();
                if (context2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(168567);
                    throw tVar2;
                }
                ((MMActivity) context2).hideVKB();
                FinderEditFooter.c(this.wCa);
                FinderEditFooter finderEditFooter2 = this.wCa;
                b bVar4 = FinderEditFooter.wBZ;
                finderEditFooter2.wBU = FinderEditFooter.wBY;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168567);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ FinderEditFooter wCa;

        d(FinderEditFooter finderEditFooter) {
            this.wCa = finderEditFooter;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168568);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderEditFooter.d(this.wCa);
            a aVar = this.wCa.wBS;
            if (aVar != null) {
                aVar.Lm(this.wCa.wBR);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168568);
        }
    }

    @Override // com.tencent.mm.ui.widget.b.a, com.tencent.mm.ui.widget.InputPanelLinearLayout
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(168570);
        super.f(z, i2);
        Log.d(this.TAG, "isKeyboardShow " + z + " keyboardHeight " + i2);
        if (z) {
            this.wBU = wBX;
            ImageButton imageButton = this.wBP;
            if (imageButton == null) {
                p.btv("emojiBtn");
            }
            imageButton.setImageResource(R.raw.icons_outlined_emoji);
            ChatFooterPanel chatFooterPanel = this.rum;
            if (chatFooterPanel == null) {
                p.btv("smileyPanel");
            }
            chatFooterPanel.setVisibility(0);
            AppMethodBeat.o(168570);
            return;
        }
        if (this.wBU == wBX) {
            ChatFooterPanel chatFooterPanel2 = this.rum;
            if (chatFooterPanel2 == null) {
                p.btv("smileyPanel");
            }
            chatFooterPanel2.setVisibility(8);
        }
        AppMethodBeat.o(168570);
    }

    public final void setAlignModeChangeListener(a aVar) {
        AppMethodBeat.i(168571);
        p.h(aVar, "alignModeChangeListener");
        this.wBS = aVar;
        AppMethodBeat.o(168571);
    }

    public final void setSmileyTextOperationListener(ChatFooterPanel.a aVar) {
        AppMethodBeat.i(168572);
        p.h(aVar, "smileyTextListener");
        this.wBT = aVar;
        ChatFooterPanel chatFooterPanel = this.rum;
        if (chatFooterPanel == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel.setOnTextOperationListener(aVar);
        AppMethodBeat.o(168572);
    }

    public final int getCurrentAlignMode() {
        return this.wBR;
    }

    public static final /* synthetic */ void b(FinderEditFooter finderEditFooter) {
        AppMethodBeat.i(168576);
        ImageButton imageButton = finderEditFooter.wBP;
        if (imageButton == null) {
            p.btv("emojiBtn");
        }
        imageButton.setImageResource(R.raw.icons_outlined_emoji);
        ChatFooterPanel chatFooterPanel = finderEditFooter.rum;
        if (chatFooterPanel == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel.onPause();
        AppMethodBeat.o(168576);
    }

    public static final /* synthetic */ void c(FinderEditFooter finderEditFooter) {
        AppMethodBeat.i(168577);
        ImageButton imageButton = finderEditFooter.wBP;
        if (imageButton == null) {
            p.btv("emojiBtn");
        }
        imageButton.setImageResource(R.raw.icons_outlined_keyboard);
        ChatFooterPanel chatFooterPanel = finderEditFooter.rum;
        if (chatFooterPanel == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel.setVisibility(0);
        ChatFooterPanel chatFooterPanel2 = finderEditFooter.rum;
        if (chatFooterPanel2 == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel2.onResume();
        AppMethodBeat.o(168577);
    }

    public static final /* synthetic */ void d(FinderEditFooter finderEditFooter) {
        AppMethodBeat.i(168578);
        int i2 = finderEditFooter.wBR;
        if (i2 == wBW) {
            finderEditFooter.wBR = wBV;
            ImageButton imageButton = finderEditFooter.wBQ;
            if (imageButton == null) {
                p.btv("alignBtn");
            }
            imageButton.setImageResource(R.raw.icons_outlined_alignment_left);
            AppMethodBeat.o(168578);
            return;
        }
        if (i2 == wBV) {
            finderEditFooter.wBR = wBW;
            ImageButton imageButton2 = finderEditFooter.wBQ;
            if (imageButton2 == null) {
                p.btv("alignBtn");
            }
            imageButton2.setImageResource(R.raw.icons_outlined_alignment_center);
        }
        AppMethodBeat.o(168578);
    }
}
