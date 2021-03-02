package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mv.ui.uic.KeyboardProviderUIC;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\u0018\u0000 42\u00020\u00012\u00020\u0002:\u000245B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\nJ\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0003J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0015J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\u001cH\u0002J\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u0010H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentModeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "curEditMode", "hasWindowFocus", "", "lastKeyboardShow", "moveHeight", "nextEditMode", "onCommentSend", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "smilePanelHeight", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "toSendET", "Lcom/tencent/mm/ui/widget/MMEditText;", "allGone", "", "getTrueHeight", "hideSmileyPanel", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initEditText", "initEmojiBtn", "initSmilePanel", "onKeyboardHeightChanged", "height", "isResized", "onWindowFocusChanged", "onlyShowSmilePanel", "onlyShowVKB", "refreshBottomPanelHeight", "send", "setEditViewBackground", "id", "setOnCommentSendImp", "imp", "setVisibility", "visibility", "showSmileyPanel", "showState", "isShow", "Companion", "IOnCommentSend", "plugin-mv_release"})
public final class MusicMvCommentFooter extends LinearLayout implements com.tencent.mm.ui.tools.g {
    public static final a AxI = new a((byte) 0);
    private WeImageView AxC;
    private int AxD = 200;
    private int AxE = -1;
    private boolean AxF;
    private b AxG;
    private boolean AxH;
    private ChatFooterPanel rum;
    private int wBU = 200;
    private int ygg;
    private MMEditText ziR;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "", "onCommentSend", "", "toSendText", "", "emojiMd5", "plugin-mv_release"})
    public interface b {
        void aIq(String str);
    }

    static {
        AppMethodBeat.i(257494);
        AppMethodBeat.o(257494);
    }

    public static final /* synthetic */ void b(MusicMvCommentFooter musicMvCommentFooter) {
        AppMethodBeat.i(257495);
        musicMvCommentFooter.ewq();
        AppMethodBeat.o(257495);
    }

    public static final /* synthetic */ ChatFooterPanel g(MusicMvCommentFooter musicMvCommentFooter) {
        AppMethodBeat.i(257498);
        ChatFooterPanel chatFooterPanel = musicMvCommentFooter.rum;
        if (chatFooterPanel == null) {
            p.btv("smileyPanel");
        }
        AppMethodBeat.o(257498);
        return chatFooterPanel;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$Companion;", "", "()V", "DELAY_MILLISECOND", "", "EDIT_MODE_KEYBOARD", "", "EDIT_MODE_NONE", "EDIT_MODE_SMILE_PANEL", "NORMAL_ANIMATOR_DURATION", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void setOnCommentSendImp(b bVar) {
        AppMethodBeat.i(257483);
        p.h(bVar, "imp");
        this.AxG = bVar;
        AppMethodBeat.o(257483);
    }

    public MusicMvCommentFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(257492);
        init();
        AppMethodBeat.o(257492);
    }

    public MusicMvCommentFooter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(257493);
        init();
        AppMethodBeat.o(257493);
    }

    public final void setVisibility(int i2) {
        com.tencent.mm.ui.tools.h hVar;
        AppMethodBeat.i(257484);
        super.setVisibility(i2);
        this.wBU = 200;
        boolean z = i2 == 0;
        Log.i("Music.MusicMvCommentFooter", "setVisibility, cutEditMode:" + this.wBU + ", isShow:" + z);
        Log.i("Music.MusicMvCommentFooter", "showState ".concat(String.valueOf(z)));
        if (!z) {
            Log.i("Music.MusicMvCommentFooter", "allGone");
            this.AxD = 200;
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(257484);
                throw tVar;
            }
            ((MMActivity) context).hideVKB();
            ChatFooterPanel chatFooterPanel = this.rum;
            if (chatFooterPanel == null) {
                p.btv("smileyPanel");
            }
            chatFooterPanel.setAlpha(0.0f);
            ChatFooterPanel chatFooterPanel2 = this.rum;
            if (chatFooterPanel2 == null) {
                p.btv("smileyPanel");
            }
            chatFooterPanel2.setVisibility(4);
        }
        if (z) {
            this.AxH = false;
            this.AxF = true;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context2 = getContext();
            p.g(context2, "context");
            KeyboardProviderUIC keyboardProviderUIC = (KeyboardProviderUIC) com.tencent.mm.ui.component.a.ko(context2).get(KeyboardProviderUIC.class);
            keyboardProviderUIC.AsQ.add(this);
            com.tencent.mm.ui.tools.h hVar2 = keyboardProviderUIC.gyh;
            if (hVar2 != null) {
                hVar2.start();
            }
            MMEditText mMEditText = this.ziR;
            if (mMEditText != null) {
                mMEditText.requestFocus();
            }
            ewq();
            AppMethodBeat.o(257484);
            return;
        }
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        Context context3 = getContext();
        p.g(context3, "context");
        KeyboardProviderUIC keyboardProviderUIC2 = (KeyboardProviderUIC) com.tencent.mm.ui.component.a.ko(context3).get(KeyboardProviderUIC.class);
        MusicMvCommentFooter musicMvCommentFooter = this;
        ArrayList<com.tencent.mm.ui.tools.g> arrayList = keyboardProviderUIC2.AsQ;
        if (arrayList == null) {
            t tVar2 = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            AppMethodBeat.o(257484);
            throw tVar2;
        }
        af.eV(arrayList).remove(musicMvCommentFooter);
        if (!keyboardProviderUIC2.AsQ.isEmpty() || (hVar = keyboardProviderUIC2.gyh) == null) {
            AppMethodBeat.o(257484);
            return;
        }
        hVar.close();
        AppMethodBeat.o(257484);
    }

    public final int getTrueHeight() {
        AppMethodBeat.i(257485);
        int fromDPToPix = this.AxE + com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
        AppMethodBeat.o(257485);
        return fromDPToPix;
    }

    public final void setEditViewBackground(int i2) {
        AppMethodBeat.i(257486);
        MMEditText mMEditText = this.ziR;
        if (mMEditText != null) {
            mMEditText.setBackground(getContext().getDrawable(i2));
            AppMethodBeat.o(257486);
            return;
        }
        AppMethodBeat.o(257486);
    }

    private final void ewq() {
        AppMethodBeat.i(257487);
        Log.i("Music.MusicMvCommentFooter", "onlyShowVKB");
        this.AxD = 201;
        Context context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(257487);
            throw tVar;
        }
        ((MMActivity) context).showVKB();
        AppMethodBeat.o(257487);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ MusicMvCommentFooter AxJ;

        e(MusicMvCommentFooter musicMvCommentFooter) {
            this.AxJ = musicMvCommentFooter;
        }

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(257475);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$initEmojiBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("Music.MusicMvCommentFooter", "commentModeIv clicked, curEditMode:" + this.AxJ.wBU);
            MusicMvCommentFooter musicMvCommentFooter = this.AxJ;
            if (this.AxJ.wBU == 202) {
                MusicMvCommentFooter.b(this.AxJ);
                i2 = 201;
            } else {
                MusicMvCommentFooter.c(this.AxJ);
                i2 = 202;
            }
            musicMvCommentFooter.wBU = i2;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$initEmojiBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257475);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"})
    public static final class d implements TextView.OnEditorActionListener {
        final /* synthetic */ MusicMvCommentFooter AxJ;

        d(MusicMvCommentFooter musicMvCommentFooter) {
            this.AxJ = musicMvCommentFooter;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            AppMethodBeat.i(257474);
            if (i2 == 4) {
                MusicMvCommentFooter.d(this.AxJ);
                AppMethodBeat.o(257474);
                return true;
            }
            AppMethodBeat.o(257474);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$send$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-mv_release"})
    public static final class h implements c.a {
        final /* synthetic */ MusicMvCommentFooter AxJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(MusicMvCommentFooter musicMvCommentFooter) {
            this.AxJ = musicMvCommentFooter;
        }

        @Override // com.tencent.mm.ui.tools.b.c.a
        public final void Tw(String str) {
            b bVar;
            AppMethodBeat.i(257480);
            p.h(str, "text");
            Log.i("Music.MusicMvCommentFooter", "InputTextBoundaryCheck ok, ready to send, text:".concat(String.valueOf(str)));
            if (!Util.isNullOrNil(str) && (bVar = this.AxJ.AxG) != null) {
                bVar.aIq(str);
            }
            MMEditText mMEditText = this.AxJ.ziR;
            if (mMEditText == null) {
                p.hyc();
            }
            mMEditText.setText("");
            AppMethodBeat.o(257480);
        }

        @Override // com.tencent.mm.ui.tools.b.c.a
        public final void Tx(String str) {
            AppMethodBeat.i(257481);
            p.h(str, "text");
            AppMethodBeat.o(257481);
        }

        @Override // com.tencent.mm.ui.tools.b.c.a
        public final void dv(String str) {
            AppMethodBeat.i(257482);
            p.h(str, "text");
            com.tencent.mm.ui.base.h.n(this.AxJ.getContext(), R.string.hc2, R.string.hc3);
            AppMethodBeat.o(257482);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$initSmilePanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-mv_release"})
    public static final class f implements ChatFooterPanel.a {
        final /* synthetic */ MusicMvCommentFooter AxJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(MusicMvCommentFooter musicMvCommentFooter) {
            this.AxJ = musicMvCommentFooter;
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void append(String str) {
            MMEditText mMEditText;
            AppMethodBeat.i(257476);
            if (Util.isNullOrNil(str) || (mMEditText = this.AxJ.ziR) == null) {
                AppMethodBeat.o(257476);
                return;
            }
            mMEditText.append(com.tencent.mm.ui.g.c.b.c(this.AxJ.getContext(), str, mMEditText.getTextSize()));
            AppMethodBeat.o(257476);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHC() {
            InputConnection inputConnection;
            AppMethodBeat.i(257477);
            MMEditText mMEditText = this.AxJ.ziR;
            if (mMEditText == null || (inputConnection = mMEditText.getInputConnection()) == null) {
                AppMethodBeat.o(257477);
                return;
            }
            inputConnection.sendKeyEvent(new KeyEvent(0, 67));
            inputConnection.sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.o(257477);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void eP(boolean z) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHD() {
            AppMethodBeat.i(257478);
            MMEditText mMEditText = this.AxJ.ziR;
            Editable text = mMEditText != null ? mMEditText.getText() : null;
            if (text == null || text.length() == 0) {
                AppMethodBeat.o(257478);
                return;
            }
            MusicMvCommentFooter.d(this.AxJ);
            AppMethodBeat.o(257478);
        }
    }

    private final void init() {
        MMEditText mMEditText;
        Bundle inputExtras;
        MMEditText mMEditText2;
        AppMethodBeat.i(257488);
        View.inflate(getContext(), R.layout.be4, this);
        this.AxC = (WeImageView) findViewById(R.id.b97);
        WeImageView weImageView = this.AxC;
        if (weImageView != null) {
            weImageView.setOnClickListener(new e(this));
        }
        View findViewById = findViewById(R.id.b8m);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMEditText");
            AppMethodBeat.o(257488);
            throw tVar;
        }
        this.ziR = (MMEditText) findViewById;
        MMEditText mMEditText3 = this.ziR;
        if (mMEditText3 != null) {
            mMEditText3.setEnableSendBtn(true);
        }
        if (ao.gJI() && (mMEditText2 = this.ziR) != null) {
            mMEditText2.setImeOptions(268435456);
        }
        MMEditText mMEditText4 = this.ziR;
        if (mMEditText4 != null) {
            mMEditText4.setImeOptions(4);
        }
        MMEditText mMEditText5 = this.ziR;
        if (mMEditText5 != null) {
            MMEditText mMEditText6 = this.ziR;
            Integer valueOf = mMEditText6 != null ? Integer.valueOf(mMEditText6.getInputType() & -65) : null;
            if (valueOf == null) {
                p.hyc();
            }
            mMEditText5.setInputType(valueOf.intValue());
        }
        com.tencent.mm.ui.tools.b.c.f(this.ziR).aoq(80).a((c.a) null);
        MMEditText mMEditText7 = this.ziR;
        if (!(mMEditText7 == null || (inputExtras = mMEditText7.getInputExtras(true)) == null)) {
            inputExtras.putBoolean("IS_CHAT_EDITOR", true);
        }
        if (Build.VERSION.SDK_INT == 28 && (mMEditText = this.ziR) != null) {
            mMEditText.setBreakStrategy(1);
        }
        MMEditText mMEditText8 = this.ziR;
        if (mMEditText8 != null) {
            mMEditText8.setOnEditorActionListener(new d(this));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.h93);
        ChatFooterPanel eZ = com.tencent.mm.pluginsdk.ui.chat.e.grv().eZ(getContext());
        p.g(eZ, "FooterFactory.getSmileyP…).getSmileyPanel(context)");
        this.rum = eZ;
        ChatFooterPanel chatFooterPanel = this.rum;
        if (chatFooterPanel == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel.setEntranceScene(ChatFooterPanel.KbP);
        ChatFooterPanel chatFooterPanel2 = this.rum;
        if (chatFooterPanel2 == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel2.setBackgroundResource(R.drawable.mc);
        ChatFooterPanel chatFooterPanel3 = this.rum;
        if (chatFooterPanel3 == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel3.goD();
        ChatFooterPanel chatFooterPanel4 = this.rum;
        if (chatFooterPanel4 == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel4.setShowSend(true);
        ChatFooterPanel chatFooterPanel5 = this.rum;
        if (chatFooterPanel5 == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel5.setVisibility(4);
        this.AxE = KeyBoardUtil.getKeyBordHeightPx(getContext());
        ChatFooterPanel chatFooterPanel6 = this.rum;
        if (chatFooterPanel6 == null) {
            p.btv("smileyPanel");
        }
        linearLayout.addView(chatFooterPanel6, -1, this.AxE);
        ChatFooterPanel chatFooterPanel7 = this.rum;
        if (chatFooterPanel7 == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel7.setOnTextOperationListener(new f(this));
        AppMethodBeat.o(257488);
    }

    private final void cbM() {
        AppMethodBeat.i(257489);
        Log.i("Music.MusicMvCommentFooter", "hideSmileyPanel");
        WeImageView weImageView = this.AxC;
        if (weImageView != null) {
            weImageView.setImageResource(R.raw.icons_outlined_emoji);
        }
        WeImageView weImageView2 = this.AxC;
        if (weImageView2 != null) {
            Context context = getContext();
            p.g(context, "context");
            weImageView2.setIconColor(context.getResources().getColor(R.color.am));
        }
        ChatFooterPanel chatFooterPanel = this.rum;
        if (chatFooterPanel == null) {
            p.btv("smileyPanel");
        }
        chatFooterPanel.animate().cancel();
        ChatFooterPanel chatFooterPanel2 = this.rum;
        if (chatFooterPanel2 == null) {
            p.btv("smileyPanel");
        }
        if (chatFooterPanel2.getVisibility() == 0) {
            ChatFooterPanel chatFooterPanel3 = this.rum;
            if (chatFooterPanel3 == null) {
                p.btv("smileyPanel");
            }
            chatFooterPanel3.onPause();
            ChatFooterPanel chatFooterPanel4 = this.rum;
            if (chatFooterPanel4 == null) {
                p.btv("smileyPanel");
            }
            chatFooterPanel4.animate().alpha(0.0f).setDuration(175).withEndAction(new c(this)).start();
        }
        AppMethodBeat.o(257489);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ MusicMvCommentFooter AxJ;

        c(MusicMvCommentFooter musicMvCommentFooter) {
            this.AxJ = musicMvCommentFooter;
        }

        public final void run() {
            AppMethodBeat.i(257473);
            MusicMvCommentFooter.g(this.AxJ).setVisibility(4);
            AppMethodBeat.o(257473);
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(257490);
        super.onWindowFocusChanged(z);
        Log.i("Music.MusicMvCommentFooter", "onWindowFocusChanged: ".concat(String.valueOf(z)));
        this.AxF = z;
        if (getVisibility() == 0 && z && this.wBU == 201) {
            post(new g(this));
        }
        AppMethodBeat.o(257490);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ MusicMvCommentFooter AxJ;

        g(MusicMvCommentFooter musicMvCommentFooter) {
            this.AxJ = musicMvCommentFooter;
        }

        public final void run() {
            AppMethodBeat.i(257479);
            MMEditText mMEditText = this.AxJ.ziR;
            if (mMEditText != null) {
                mMEditText.requestFocus();
            }
            Context context = this.AxJ.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(257479);
                throw tVar;
            }
            ((MMActivity) context).showVKB();
            AppMethodBeat.o(257479);
        }
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        boolean z2;
        AppMethodBeat.i(257491);
        Log.i("Music.MusicMvCommentFooter", "onKeyboardHeightChanged: ".concat(String.valueOf(i2)));
        if (!this.AxF) {
            AppMethodBeat.o(257491);
            return;
        }
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.AxH == z2) {
            Log.d("Music.MusicMvCommentFooter", "onKeyboardHeightChanged repeat");
            AppMethodBeat.o(257491);
            return;
        }
        if (this.ygg == 0) {
            this.ygg = i2;
        }
        if (!(this.AxE == i2 || i2 == 0)) {
            this.AxE = i2;
            Log.i("Music.MusicMvCommentFooter", "refreshBottomPanelHeight, " + this.AxE);
            if (this.AxE > 0) {
                KeyBoardUtil.saveKeyBordHeightPx(getContext(), this.AxE);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.AxE);
                ChatFooterPanel chatFooterPanel = this.rum;
                if (chatFooterPanel == null) {
                    p.btv("smileyPanel");
                }
                chatFooterPanel.setLayoutParams(layoutParams);
            }
        }
        if (z2) {
            this.wBU = 201;
            cbM();
        } else {
            if (this.AxD == 200) {
                b bVar = this.AxG;
                if (bVar != null) {
                    bVar.aIq(null);
                }
                this.wBU = 200;
                cbM();
            } else if (this.AxD == 202) {
                this.wBU = 202;
                Log.i("Music.MusicMvCommentFooter", "showSmileyPanel");
                WeImageView weImageView = this.AxC;
                if (weImageView != null) {
                    weImageView.setImageResource(R.raw.icons_outlined_keyboard);
                }
                WeImageView weImageView2 = this.AxC;
                if (weImageView2 != null) {
                    Context context = getContext();
                    p.g(context, "context");
                    weImageView2.setIconColor(context.getResources().getColor(R.color.am));
                }
                ChatFooterPanel chatFooterPanel2 = this.rum;
                if (chatFooterPanel2 == null) {
                    p.btv("smileyPanel");
                }
                chatFooterPanel2.setVisibility(0);
                ChatFooterPanel chatFooterPanel3 = this.rum;
                if (chatFooterPanel3 == null) {
                    p.btv("smileyPanel");
                }
                chatFooterPanel3.onResume();
                ChatFooterPanel chatFooterPanel4 = this.rum;
                if (chatFooterPanel4 == null) {
                    p.btv("smileyPanel");
                }
                chatFooterPanel4.animate().cancel();
                ChatFooterPanel chatFooterPanel5 = this.rum;
                if (chatFooterPanel5 == null) {
                    p.btv("smileyPanel");
                }
                chatFooterPanel5.animate().alpha(1.0f).setDuration(175).start();
            }
            this.AxD = 200;
        }
        this.AxD = 200;
        this.AxH = z2;
        AppMethodBeat.o(257491);
    }

    public static final /* synthetic */ void c(MusicMvCommentFooter musicMvCommentFooter) {
        AppMethodBeat.i(257496);
        Log.i("Music.MusicMvCommentFooter", "onlyShowSmilePanel");
        musicMvCommentFooter.AxD = 202;
        Context context = musicMvCommentFooter.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(257496);
            throw tVar;
        }
        ((MMActivity) context).hideVKB();
        AppMethodBeat.o(257496);
    }

    public static final /* synthetic */ void d(MusicMvCommentFooter musicMvCommentFooter) {
        AppMethodBeat.i(257497);
        com.tencent.mm.ui.tools.b.c.f(musicMvCommentFooter.ziR).aoq(80).CN(true).a(new h(musicMvCommentFooter));
        AppMethodBeat.o(257497);
    }
}
