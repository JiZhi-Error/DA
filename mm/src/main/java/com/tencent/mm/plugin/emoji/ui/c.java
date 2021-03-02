package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000234B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0006J\u0006\u0010'\u001a\u00020#J\u0012\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0006\u0010+\u001a\u00020#J\u0016\u0010,\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010-\u001a\u00020*J\u0006\u0010.\u001a\u00020#J\u0006\u0010/\u001a\u00020#J\u0006\u00100\u001a\u00020#J\u0006\u00101\u001a\u00020#J\u0006\u00102\u001a\u00020#R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 ¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "talkName", "", "toSendText", "dialog", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog;", "panelCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog;Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "adapter", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchAdapter;", "countDownToHideVKB", "Ljava/lang/Runnable;", "dataManager", "Lcom/tencent/mm/emojisearch/data/IEmojiSearchManager;", "getDialog", "()Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog;", "emojiSearchEditTextView", "Lcom/tencent/mm/emojisearch/ui/EmojiSearchEditTextView;", "emojiSearchRunnable", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchView$EmojiSearchRunnable;", "getPanelCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "querySource", "", "recyclerView", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "getTalkName", "()Ljava/lang/String;", "getToSendText", "checkFocus", "", "dialogShow", "doEmojiSearch", "searchString", "hideVKB", "onClick", "v", "Landroid/view/View;", "release", "setEmojiSearchEditTextView", "view", "setEmptySearchWord", "setErrorNetwork", "setLoading", "startCountDownToHideVKB", "stopCountDownToHideVKB", "Companion", "EmojiSearchRunnable", "plugin-emojisdk_release"})
public final class c extends RelativeLayout implements View.OnClickListener {
    public static final a rgU = new a((byte) 0);
    int het;
    private final String rgD;
    final String rgH;
    private final j rgI;
    com.tencent.mm.emojisearch.a.b rgN = new com.tencent.mm.emojisearch.a.a();
    a rgO;
    public EmojiSearchEditTextView rgP;
    private EmojiPanelRecyclerView rgQ;
    private b rgR;
    Runnable rgS;
    private final b rgT;

    static {
        AppMethodBeat.i(200076);
        AppMethodBeat.o(200076);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, String str, String str2, b bVar, j jVar) {
        super(context, null, 0);
        String str3;
        p.h(context, "context");
        p.h(str, "talkName");
        p.h(str2, "toSendText");
        p.h(jVar, "panelCallback");
        AppMethodBeat.i(200075);
        this.rgD = str;
        this.rgH = str2;
        this.rgT = bVar;
        this.rgI = jVar;
        b bVar2 = this.rgT;
        if (bVar2 != null) {
            str3 = bVar2.rgD;
        } else {
            str3 = null;
        }
        this.rgO = new a(str3);
        this.het = 1;
        this.rgN.awy();
        setBackgroundColor(context.getResources().getColor(R.color.ac_));
        View inflate = LayoutInflater.from(context).inflate(R.layout.box, (ViewGroup) this, true);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(200075);
            throw tVar;
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        relativeLayout.findViewById(R.id.b4g).setOnClickListener(this);
        View findViewById = relativeLayout.findViewById(R.id.c1m);
        p.g(findViewById, "parent.findViewById(R.id.emoji_search_edittext)");
        this.rgP = (EmojiSearchEditTextView) findViewById;
        View findViewById2 = relativeLayout.findViewById(R.id.c0_);
        p.g(findViewById2, "parent.findViewById(R.id.emoji_list)");
        this.rgQ = (EmojiPanelRecyclerView) findViewById2;
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(4);
        gridLayoutManager.a(new GridLayoutManager.b(this) {
            /* class com.tencent.mm.plugin.emoji.ui.c.AnonymousClass1 */
            final /* synthetic */ c rgV;

            {
                this.rgV = r1;
            }

            @Override // android.support.v7.widget.GridLayoutManager.b
            public final int bX(int i2) {
                AppMethodBeat.i(200056);
                switch (this.rgV.rgO.getItemViewType(i2)) {
                    case 200:
                    case 201:
                    case 203:
                    case 204:
                    case 205:
                    case 206:
                        int ki = gridLayoutManager.ki();
                        AppMethodBeat.o(200056);
                        return ki;
                    case 202:
                    default:
                        AppMethodBeat.o(200056);
                        return 1;
                }
            }
        });
        this.rgQ.setLayoutManager(gridLayoutManager);
        this.rgQ.setItemViewCacheSize(0);
        this.rgQ.setAdapter(this.rgO);
        EmojiPanelRecyclerView emojiPanelRecyclerView = this.rgQ;
        emojiPanelRecyclerView.a(new EmojiPanelRecyclerView.a(emojiPanelRecyclerView));
        this.rgQ.setScene(2);
        this.rgQ.setEmojiPopupType(4);
        this.rgO.haK = new com.tencent.mm.emojisearch.b.a(ChatFooterPanel.KbC, new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.emoji.ui.c.AnonymousClass2 */
            final /* synthetic */ c rgV;

            {
                this.rgV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(200057);
                this.rgV.rgP.awD();
                this.rgV.rgP.awC();
                x xVar = x.SXb;
                AppMethodBeat.o(200057);
                return xVar;
            }
        }, new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.emoji.ui.c.AnonymousClass3 */
            final /* synthetic */ c rgV;

            {
                this.rgV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(200058);
                b dialog = this.rgV.getDialog();
                if (dialog != null) {
                    dialog.cancel();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(200058);
                return xVar;
            }
        });
        e(this.rgH, relativeLayout);
        SecDataUIC.a aVar = SecDataUIC.CWq;
        Context baseContext = ((u) context).getBaseContext();
        p.g(baseContext, "(context as MMContextThemeWrapper).baseContext");
        SecDataUIC gU = SecDataUIC.a.gU(baseContext);
        if (gU != null) {
            gU.a(new com.tencent.mm.plugin.secdata.a("SosSimilarUI", dyn.class));
            AppMethodBeat.o(200075);
            return;
        }
        AppMethodBeat.o(200075);
    }

    public final b getDialog() {
        return this.rgT;
    }

    public final j getPanelCallback() {
        return this.rgI;
    }

    public final String getTalkName() {
        return this.rgD;
    }

    public final String getToSendText() {
        return this.rgH;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchView$Companion;", "", "()V", "SCENE_EMOJI_SEARCH", "", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private void e(String str, View view) {
        boolean z;
        AppMethodBeat.i(200069);
        p.h(str, "toSendText");
        p.h(view, "view");
        if (!Util.isNullOrNil(str)) {
            this.rgP.setText(str);
            String str2 = str;
            int length = str2.length() - 1;
            boolean z2 = false;
            int i2 = 0;
            while (i2 <= length) {
                if (str2.charAt(!z2 ? i2 : length) <= ' ') {
                    z = true;
                } else {
                    z = false;
                }
                if (z2) {
                    if (!z) {
                        break;
                    }
                    length--;
                } else if (!z) {
                    z2 = true;
                } else {
                    i2++;
                }
            }
            amZ(str2.subSequence(i2, length + 1).toString());
        }
        this.rgP.setOnClickListener(new d(this, view));
        this.rgP.setEmojiSearchEditTextListener(new e(this));
        AppMethodBeat.o(200069);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ View hCI;
        final /* synthetic */ c rgV;

        d(c cVar, View view) {
            this.rgV = cVar;
            this.hCI = view;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(200063);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiSearchView$setEmojiSearchEditTextView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.rgV.rgP.awD();
            this.rgV.rgP.setHint(this.hCI.getContext().getString(R.string.yn));
            this.rgV.rgP.awC();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiSearchView$setEmojiSearchEditTextView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(200063);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/emoji/ui/EmojiSearchView$setEmojiSearchEditTextView$3", "Lcom/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$EmojiSearchEditTextListener;", "onClickClearTextBtn", "", "view", "Landroid/view/View;", "onEditTextChange", "totalText", "", "inEditText", "textChangeStatus", "Lcom/tencent/mm/emojisearch/ui/EmojiSearchEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "plugin-emojisdk_release"})
    public static final class e implements EmojiSearchEditTextView.a {
        final /* synthetic */ c rgV;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(c cVar) {
            this.rgV = cVar;
        }

        @Override // com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.a
        public final void a(String str, String str2, EmojiSearchEditTextView.b bVar) {
            boolean z;
            AppMethodBeat.i(200064);
            p.h(str, "totalText");
            p.h(str2, "inEditText");
            p.h(bVar, "textChangeStatus");
            Log.i("MicroMsg.EmojiSearch", "search totalText %s", str);
            this.rgV.het = 1;
            if (Util.isNullOrNil(str)) {
                if (this.rgV.rgR != null) {
                    b bVar2 = this.rgV.rgR;
                    if (bVar2 == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchView.EmojiSearchRunnable");
                        AppMethodBeat.o(200064);
                        throw tVar;
                    }
                    bVar2.isStop = true;
                    this.rgV.removeCallbacks(this.rgV.rgR);
                }
                this.rgV.cHs();
                this.rgV.cHt();
                AppMethodBeat.o(200064);
                return;
            }
            c cVar = this.rgV;
            String str3 = str;
            int length = str3.length() - 1;
            boolean z2 = false;
            int i2 = 0;
            while (i2 <= length) {
                if (str3.charAt(!z2 ? i2 : length) <= ' ') {
                    z = true;
                } else {
                    z = false;
                }
                if (z2) {
                    if (!z) {
                        break;
                    }
                    length--;
                } else if (!z) {
                    z2 = true;
                } else {
                    i2++;
                }
            }
            cVar.amZ(str3.subSequence(i2, length + 1).toString());
            c cVar2 = this.rgV;
            if (cVar2.rgS != null) {
                cVar2.removeCallbacks(cVar2.rgS);
            }
            cVar2.rgS = new f(cVar2);
            Runnable runnable = cVar2.rgS;
            com.tencent.mm.search.a aVar = com.tencent.mm.search.a.NJh;
            cVar2.postDelayed(runnable, com.tencent.mm.search.a.gxo());
            AppMethodBeat.o(200064);
        }

        @Override // com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.a
        public final void eh(boolean z) {
            AppMethodBeat.i(200065);
            Log.i("MicroMsg.EmojiSearch", "searchView hasFocus %s", Boolean.valueOf(z));
            AppMethodBeat.o(200065);
        }

        @Override // com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.a
        public final void onClickClearTextBtn(View view) {
            AppMethodBeat.i(200066);
            p.h(view, "view");
            Log.i("MicroMsg.EmojiSearch", "clear search text");
            if (this.rgV.rgR != null) {
                b bVar = this.rgV.rgR;
                if (bVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchView.EmojiSearchRunnable");
                    AppMethodBeat.o(200066);
                    throw tVar;
                }
                bVar.isStop = true;
                this.rgV.removeCallbacks(this.rgV.rgR);
            }
            this.rgV.het = 1;
            this.rgV.cHs();
            this.rgV.rgP.awD();
            this.rgV.rgP.awC();
            this.rgV.cHt();
            AppMethodBeat.o(200066);
        }

        @Override // com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView.a
        public final boolean awE() {
            String str;
            boolean z;
            AppMethodBeat.i(200067);
            Log.i("MicroMsg.EmojiSearch", "search key down");
            String obj = this.rgV.rgP.getEditText().getText().toString();
            int length = obj.length() - 1;
            boolean z2 = false;
            int i2 = 0;
            while (i2 <= length) {
                if (obj.charAt(!z2 ? i2 : length) <= ' ') {
                    z = true;
                } else {
                    z = false;
                }
                if (z2) {
                    if (!z) {
                        break;
                    }
                    length--;
                } else if (!z) {
                    z2 = true;
                } else {
                    i2++;
                }
            }
            String obj2 = obj.subSequence(i2, length + 1).toString();
            if (!Util.isNullOrNil(obj2)) {
                this.rgV.rgP.getEditText().clearFocus();
                this.rgV.hideVKB();
                b bVar = this.rgV.rgR;
                if (bVar != null) {
                    str = bVar.gzZ;
                } else {
                    str = null;
                }
                if (!obj2.equals(str)) {
                    this.rgV.amZ(obj2);
                }
            }
            AppMethodBeat.o(200067);
            return true;
        }
    }

    public final void cHs() {
        AppMethodBeat.i(200070);
        this.rgO.gUV.clear();
        this.rgO.cHr();
        this.rgO.notifyDataSetChanged();
        AppMethodBeat.o(200070);
    }

    public final void amZ(String str) {
        AppMethodBeat.i(200071);
        p.h(str, "searchString");
        if (this.rgR != null) {
            b bVar = this.rgR;
            if (bVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchView.EmojiSearchRunnable");
                AppMethodBeat.o(200071);
                throw tVar;
            }
            bVar.isStop = true;
            removeCallbacks(this.rgR);
        }
        this.rgR = new C0963c(this, str, str);
        postDelayed(this.rgR, 100);
        AppMethodBeat.o(200071);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/emoji/ui/EmojiSearchView$doEmojiSearch$2", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchView$EmojiSearchRunnable;", "run", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.plugin.emoji.ui.c$c  reason: collision with other inner class name */
    public static final class C0963c extends b {
        final /* synthetic */ c rgV;
        final /* synthetic */ String rgX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0963c(c cVar, String str, String str2) {
            super(str2);
            this.rgV = cVar;
            this.rgX = str;
        }

        public final void run() {
            AppMethodBeat.i(200062);
            c cVar = this.rgV;
            cVar.rgO.gUV.clear();
            a aVar = cVar.rgO;
            aVar.a(aVar.getItemCount(), new ah(205));
            cVar.rgO.notifyDataSetChanged();
            try {
                String str = this.rgX;
                String talkName = this.rgV.getTalkName();
                long currentTimeMillis = System.currentTimeMillis();
                String talkName2 = this.rgV.getTalkName();
                byte[] bytes = "".getBytes(kotlin.n.d.UTF_8);
                p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                SimilarEmojiQueryModel similarEmojiQueryModel = new SimilarEmojiQueryModel(str, "", talkName, currentTimeMillis, 2, talkName2, com.tencent.mm.bw.b.cD(bytes), true, this.rgV.getPanelCallback());
                n nVar = this.rgV.rgO.haK;
                if (nVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.emojisearch.logic.EmojiSearchPanelClickListener");
                    AppMethodBeat.o(200062);
                    throw tVar;
                }
                ((com.tencent.mm.emojisearch.b.a) nVar).hek = similarEmojiQueryModel;
                n nVar2 = this.rgV.rgO.haK;
                if (nVar2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.EmojiPanelClickListener");
                    AppMethodBeat.o(200062);
                    throw tVar2;
                }
                ((com.tencent.mm.emoji.panel.a.d) nVar2).haC = similarEmojiQueryModel.NJn;
                this.rgV.rgN.a(similarEmojiQueryModel, new a(this));
                AppMethodBeat.o(200062);
            } catch (IOException e2) {
                Log.i("MicroMsg.EmojiSearch", "SimilarEmojiQueryModel make error");
                AppMethodBeat.o(200062);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
        /* renamed from: com.tencent.mm.plugin.emoji.ui.c$c$a */
        static final class a implements i {
            final /* synthetic */ C0963c rgY;

            a(C0963c cVar) {
                this.rgY = cVar;
            }

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                final String str2;
                dyn dyn;
                AppMethodBeat.i(200061);
                if (qVar instanceof com.tencent.mm.emojisearch.c.a) {
                    if (i2 == 0 && i3 == 0) {
                        com.tencent.mm.bw.a aYK = ((com.tencent.mm.emojisearch.c.a) qVar).rr.aYK();
                        if (aYK == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiResponse");
                            AppMethodBeat.o(200061);
                            throw tVar;
                        }
                        LinkedList<dkt> linkedList = ((dld) aYK).LVc;
                        p.g(linkedList, "(rr.responseProtoBuf as …PanelEmojiResponse).Emoji");
                        final LinkedList<dkt> linkedList2 = linkedList;
                        com.tencent.mm.bw.a aYK2 = ((com.tencent.mm.emojisearch.c.a) qVar).rr.aYK();
                        if (aYK2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiResponse");
                            AppMethodBeat.o(200061);
                            throw tVar2;
                        }
                        String str3 = ((dld) aYK2).SessionId;
                        if (str3 == null) {
                            str2 = "";
                        } else {
                            str2 = str3;
                        }
                        SecDataUIC.a aVar = SecDataUIC.CWq;
                        Context context = this.rgY.rgV.getContext();
                        if (context == null) {
                            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMContextThemeWrapper");
                            AppMethodBeat.o(200061);
                            throw tVar3;
                        }
                        Context baseContext = ((u) context).getBaseContext();
                        p.g(baseContext, "(context as MMContextThemeWrapper).baseContext");
                        SecDataUIC gU = SecDataUIC.a.gU(baseContext);
                        if (!(gU == null || (dyn = (dyn) gU.Xh(1)) == null)) {
                            dyn.SessionId = str2;
                        }
                        Log.i("MicroMsg.EmojiSearch", "get response success: " + linkedList2.size());
                        MMHandlerThread.postToMainThread(new Runnable(this) {
                            /* class com.tencent.mm.plugin.emoji.ui.c.C0963c.a.AnonymousClass1 */
                            final /* synthetic */ a rgZ;

                            {
                                this.rgZ = r1;
                            }

                            public final void run() {
                                int i2 = 4;
                                AppMethodBeat.i(200060);
                                if (!this.rgZ.rgY.isStop) {
                                    a aVar = this.rgZ.rgY.rgV.rgO;
                                    List list = linkedList2;
                                    p.h(list, "list");
                                    List<dkt> list2 = list;
                                    ArrayList arrayList = new ArrayList(kotlin.a.j.a(list2, 10));
                                    for (dkt dkt : list2) {
                                        EmojiInfo emojiInfo = new EmojiInfo();
                                        com.tencent.mm.plugin.emoji.h.b.a(dkt.MOJ, emojiInfo, dkt.MOK);
                                        if ((dkt.type & 1) == 0) {
                                            emojiInfo.Vlo = 1;
                                        }
                                        if ((dkt.type & 1) == 0 && (dkt.type & 16) == 0) {
                                            emojiInfo.Vln = 1;
                                        }
                                        emojiInfo.field_catalog = EmojiInfo.VkQ;
                                        emojiInfo.field_groupId = dkt.MOJ.ProductID;
                                        arrayList.add(new h(emojiInfo, 202));
                                    }
                                    aVar.ad(arrayList);
                                    if (linkedList2.isEmpty()) {
                                        a aVar2 = this.rgZ.rgY.rgV.rgO;
                                        aVar2.a(aVar2.getItemCount(), new ah(203));
                                    } else {
                                        this.rgZ.rgY.rgV.rgO.a(0, new ah(204));
                                        a aVar3 = this.rgZ.rgY.rgV.rgO;
                                        aVar3.a(aVar3.getItemCount(), new ah(201));
                                    }
                                    this.rgZ.rgY.rgV.rgO.notifyDataSetChanged();
                                    final ArrayList arrayList2 = new ArrayList();
                                    List<dkt> list3 = linkedList2;
                                    ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(list3, 10));
                                    for (dkt dkt2 : list3) {
                                        EmojiInfo emojiInfo2 = new EmojiInfo();
                                        com.tencent.mm.plugin.emoji.h.b.a(dkt2.MOJ, emojiInfo2);
                                        arrayList3.add(emojiInfo2.getMd5());
                                    }
                                    final ArrayList arrayList4 = arrayList3;
                                    if (this.rgZ.rgY.rgV.het == 1) {
                                        if (arrayList4.size() < 4) {
                                            i2 = arrayList4.size();
                                        }
                                        arrayList2.addAll(arrayList4.subList(0, i2));
                                        com.tencent.mm.emojisearch.d.a aVar4 = com.tencent.mm.emojisearch.d.a.hew;
                                        com.tencent.mm.emojisearch.d.a.a(this.rgZ.rgY.rgX, str2, arrayList2, i2, this.rgZ.rgY.rgV.het, i2);
                                        AppMethodBeat.o(200060);
                                        return;
                                    }
                                    this.rgZ.rgY.rgV.postDelayed(new Runnable(this) {
                                        /* class com.tencent.mm.plugin.emoji.ui.c.C0963c.a.AnonymousClass1.AnonymousClass1 */
                                        final /* synthetic */ AnonymousClass1 rhb;

                                        {
                                            this.rhb = r1;
                                        }

                                        public final void run() {
                                            AppMethodBeat.i(200059);
                                            int childCount = this.rhb.rgZ.rgY.rgV.rgQ.getChildCount() - 1;
                                            if (arrayList4.size() < childCount) {
                                                childCount = arrayList4.size();
                                            }
                                            arrayList2.addAll(arrayList4.subList(0, childCount));
                                            com.tencent.mm.emojisearch.d.a aVar = com.tencent.mm.emojisearch.d.a.hew;
                                            com.tencent.mm.emojisearch.d.a.a(this.rhb.rgZ.rgY.rgX, str2, arrayList2, childCount, this.rhb.rgZ.rgY.rgV.het, childCount);
                                            AppMethodBeat.o(200059);
                                        }
                                    }, 50);
                                }
                                AppMethodBeat.o(200060);
                            }
                        });
                        AppMethodBeat.o(200061);
                        return;
                    }
                    Log.e("MicroMsg.EmojiSearch", "get response fail. errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    c cVar = this.rgY.rgV;
                    cVar.rgO.gUV.clear();
                    a aVar2 = cVar.rgO;
                    aVar2.a(aVar2.getItemCount(), new ah(206));
                    cVar.rgO.notifyDataSetChanged();
                }
                AppMethodBeat.o(200061);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/emoji/ui/EmojiSearchView$startCountDownToHideVKB$1", "Ljava/lang/Runnable;", "run", "", "plugin-emojisdk_release"})
    public static final class f implements Runnable {
        final /* synthetic */ c rgV;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(c cVar) {
            this.rgV = cVar;
        }

        public final void run() {
            AppMethodBeat.i(200068);
            this.rgV.hideVKB();
            AppMethodBeat.o(200068);
        }
    }

    public final void cHt() {
        AppMethodBeat.i(200072);
        if (this.rgS != null) {
            removeCallbacks(this.rgS);
        }
        AppMethodBeat.o(200072);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchView$EmojiSearchRunnable;", "Ljava/lang/Runnable;", "searchStr", "", "(Ljava/lang/String;)V", "isStop", "", "()Z", "setStop", "(Z)V", "getSearchStr", "()Ljava/lang/String;", "plugin-emojisdk_release"})
    public static abstract class b implements Runnable {
        final String gzZ;
        boolean isStop;

        public b(String str) {
            p.h(str, "searchStr");
            this.gzZ = str;
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.i(200073);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.b4g) {
            hideVKB();
            b bVar2 = this.rgT;
            if (bVar2 != null) {
                bVar2.cancel();
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(200073);
    }

    public final void hideVKB() {
        AppMethodBeat.i(200074);
        Util.hideVKB(this.rgP);
        AppMethodBeat.o(200074);
    }
}
