package com.tencent.mm.plugin.transvoice.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.MMBottomSheetBehavior;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.api.ad;
import com.tencent.mm.cj.a;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.plugin.transvoice.a.c;
import com.tencent.mm.plugin.transvoice.ui.TransVoicePanelLayout;
import com.tencent.mm.plugin.transvoice.ui.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 }2\u00020\u0001:\u0005}~\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0015H\u0002J\u0010\u0010e\u001a\u00020c2\u0006\u0010f\u001a\u00020\fH\u0002J\u0010\u0010g\u001a\u00020c2\u0006\u0010h\u001a\u00020\u001bH\u0002J\b\u0010i\u001a\u00020cH\u0002J\b\u0010j\u001a\u00020\u0015H\u0002J\b\u0010k\u001a\u00020cH\u0002J\b\u0010l\u001a\u00020cH\u0002J\b\u0010m\u001a\u00020cH\u0016J\u0012\u0010n\u001a\u00020c2\b\u0010o\u001a\u0004\u0018\u00010pH\u0014J\b\u0010q\u001a\u00020cH\u0002J\b\u0010r\u001a\u00020cH\u0002J\u0010\u0010s\u001a\u00020c2\u0006\u0010t\u001a\u00020\u001bH\u0002J\b\u00107\u001a\u00020cH\u0002J\u0010\u0010u\u001a\u00020c2\u0006\u0010f\u001a\u00020\fH\u0002J\u0010\u0010v\u001a\u00020c2\u0006\u0010f\u001a\u00020\fH\u0002J\u0010\u0010w\u001a\u00020c2\u0006\u0010f\u001a\u00020\fH\u0002J\u0010\u0010x\u001a\u00020c2\u0006\u0010f\u001a\u00020\fH\u0002J\b\u0010y\u001a\u00020cH\u0016J\u000e\u0010z\u001a\u00020c2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010z\u001a\u00020c2\u0006\u0010t\u001a\u00020\u001bJ\b\u0010{\u001a\u00020cH\u0002J\b\u0010|\u001a\u00020cH\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0017\"\u0004\bB\u0010\u0019R\u0010\u0010C\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010N\u001a\n P*\u0004\u0018\u00010O0OX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u000e¢\u0006\u0002\n\u0000R(\u0010Y\u001a\u0004\u0018\u00010\u00152\b\u0010X\u001a\u0004\u0018\u00010\u0015@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0017\"\u0004\b[\u0010\u0019R\u001a\u0010\\\u001a\u00020EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "bottomSheetCoordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "btnLayout", "canCloseKeyboard", "", "canClosePanel", "canHideKeyboard", "closeInputMethod", "Landroid/widget/ImageView;", "closePanel", "container", "Lcom/tencent/mm/modelvoiceaddr/ShortSentenceContainer;", "curTxt", "", "getCurTxt", "()Ljava/lang/String;", "setCurTxt", "(Ljava/lang/String;)V", "dotCounter", "", "dotStr", "emojiRoot", "Landroid/widget/FrameLayout;", "hasClick", "inputMethodLayout", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoicePanelLayout;", "inputMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "isEdited", "isKeyboardShown", "keyboardHeight", "langType", "languageChoiceDialog", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "mNewVoiceInputReport", "Lcom/tencent/mm/modelvoiceaddr/voicereport/NewVoiceInputReportManager;", "mVoiceIdSet", "", "needSendTxtMsg", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "overTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "panelDragOpeMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "reporter", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "sendTxtMsg", "Landroid/widget/Button;", "sendVoiceMsg", "showImeRunnable", "Ljava/lang/Runnable;", "smileyItem", "smileyOpener", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "talker", "getTalker", "setTalker", "targetView", "tmpClickChangeLangTypeTime", "", "transCancelable", "transMore", "transPanelAction", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "getTransPanelAction", "()Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "setTransPanelAction", "(Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;)V", "transSP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "txtEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "txtMsg4Send", "updateDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceAddr", "Lcom/tencent/mm/plugin/transvoice/model/SceneVoiceInputAddr2;", "value", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "voiceLen", "getVoiceLen", "()J", "setVoiceLen", "(J)V", "voiceMsgSend", "cgiReport", "", "msg", "closeInputMethodBtnVisibility", "visible", "closeTransPanel", "exitType", "delPunctuation", "getContentTxt", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initSmileyPanel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshBottomPanelHeight", "resetTransPanel", "saveTransLangTypeByTalker", "type", "setBottomBtnVisibility", "setKeyboardVisibility", "setSmileyItemVisibility", "setSmileyPanelVisibility", "show", "startTrans", "updateCurTxt", "updateTransLangTypeByTalker", "Companion", "InputMode", "PanelDragOpeMode", "TransPanelAction", "plugin-transvoice_release"})
public final class b extends android.support.v7.app.e {
    public static int Gwb = -1;
    public static final a Gwc = new a((byte) 0);
    private FrameLayout FBO;
    private boolean FBV;
    private ImageView Guf;
    private MMBottomSheetBehavior<View> Gui;
    private boolean Guj;
    private a.b Guk;
    private View GvA;
    private ImageView GvB;
    private Button GvC;
    private Button GvD;
    com.tencent.mm.plugin.transvoice.a.b GvE;
    private EnumC1844b GvF = EnumC1844b.INPUT_NONE;
    public long GvG;
    String GvH;
    private boolean GvI;
    private String GvJ = "";
    private int GvK;
    MTimerHandler GvL;
    private boolean GvM;
    private a GvN;
    MMHandler GvO;
    private SharedPreferences GvP;
    boolean GvQ;
    private CoordinatorLayout GvR;
    private c GvS;
    private boolean GvT;
    private boolean GvU;
    private boolean GvV;
    private String GvW;
    private final com.tencent.mm.modelvoiceaddr.b.b GvX;
    private List<String> GvY;
    String GvZ;
    final com.tencent.mm.plugin.transvoice.a.c Gvs = com.tencent.mm.plugin.transvoice.a.c.fAu();
    long Gvt;
    boolean Gvu;
    private TransVoicePanelLayout Gvv;
    private MMEditText Gvw;
    private ImageView Gvx;
    private ImageView Gvy;
    private View Gvz;
    public d Gwa;
    com.tencent.mm.modelvoiceaddr.h jvN;
    int jvS = com.tencent.mm.modelvoiceaddr.g.jwq;
    private int oXi;
    private final Runnable ruJ;
    private ChatFooterPanel rum;
    public String talker;
    private View targetView;

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "", "(Ljava/lang/String;I)V", "INPUT_NONE", "INPUT_EMOJI", "INPUT_KEYBOARD", "plugin-transvoice_release"})
    /* renamed from: com.tencent.mm.plugin.transvoice.ui.b$b  reason: collision with other inner class name */
    public enum EnumC1844b {
        INPUT_NONE,
        INPUT_EMOJI,
        INPUT_KEYBOARD;

        static {
            AppMethodBeat.i(102558);
            AppMethodBeat.o(102558);
        }

        public static EnumC1844b valueOf(String str) {
            AppMethodBeat.i(102560);
            EnumC1844b bVar = (EnumC1844b) Enum.valueOf(EnumC1844b.class, str);
            AppMethodBeat.o(102560);
            return bVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "", "(Ljava/lang/String;I)V", "MODE_ONLY_PANEL", "MODE_WITH_KEYBOARD", "plugin-transvoice_release"})
    public enum c {
        MODE_ONLY_PANEL,
        MODE_WITH_KEYBOARD;

        static {
            AppMethodBeat.i(102561);
            AppMethodBeat.o(102561);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(102563);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(102563);
            return cVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0006H&J!\u0010\t\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "", "onTransPanelClose", "", "onTxtMsgSend", "txt", "", "onVoiceMsgDelete", DownloadInfo.FILENAME, "onVoiceMsgSend", "", "fileLength", "", "(Ljava/lang/String;Ljava/lang/Long;)Z", "plugin-transvoice_release"})
    public interface d {
        void aTP(String str);

        void aTQ(String str);

        boolean b(String str, Long l);

        void fAI();
    }

    public static final /* synthetic */ void b(b bVar, int i2) {
        AppMethodBeat.i(102612);
        bVar.acv(i2);
        AppMethodBeat.o(102612);
    }

    public static final /* synthetic */ void e(b bVar, boolean z) {
        AppMethodBeat.i(102609);
        bVar.wA(z);
        AppMethodBeat.o(102609);
    }

    public static final /* synthetic */ void i(b bVar, boolean z) {
        AppMethodBeat.i(102611);
        bVar.setKeyboardVisibility(z);
        AppMethodBeat.o(102611);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.zq);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(102604);
        c.a aVar = com.tencent.mm.plugin.transvoice.a.c.Guc;
        this.GvP = context.getSharedPreferences("voice2txt_sp", 0);
        this.GvS = c.MODE_ONLY_PANEL;
        this.GvW = "";
        gR();
        this.GvX = new com.tencent.mm.modelvoiceaddr.b.b();
        this.ruJ = new w(this, context);
        this.GvZ = "";
        AppMethodBeat.o(102604);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$Companion;", "", "()V", "MODE_ONLY_PANEL_CLOSE_PANEL_OFFSET", "", "MODE_WITH_KEYBOARD_CLOSE_KEYBOARD_OFFSET", "MODE_WITH_KEYBOARD_HIDE_KEYBOARD_OFFSET", "OVERTIME_INTERVAL", "", "OVERTIME_MSG", "", "SP_NAME", "", "TAG", "UPDATE_DOT_STR_INTERVAL", "trans2txt_cmd", "trans2txt_cmd_close", "trans2txt_cmd_invalid", "trans2txt_cmd_open", "plugin-transvoice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(102605);
        AppMethodBeat.o(102605);
    }

    public final void aTN(String str) {
        AppMethodBeat.i(185255);
        if (!Util.isNullOrNil(str)) {
            this.GvH = str;
            a.C0295a aVar = com.tencent.mm.cj.a.Owq;
            if (str == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.h(str, "<set-?>");
            com.tencent.mm.cj.a.GvH = str;
        }
        AppMethodBeat.o(185255);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        View view;
        ImageView imageView;
        ImageView imageView2;
        View view2;
        ImageView imageView3;
        Button button;
        TextPaint textPaint;
        TextPaint textPaint2;
        AppMethodBeat.i(102596);
        this.targetView = LayoutInflater.from(getContext()).inflate(R.layout.c4k, (ViewGroup) null, false);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View view3 = this.targetView;
        if (view3 == null) {
            kotlin.g.b.p.hyc();
        }
        setContentView(view3, layoutParams);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(67108864);
            window.setLayout(-1, -1);
            window.setSoftInputMode(34);
            window.setDimAmount(0.5f);
            window.setWindowAnimations(R.style.fs);
        }
        View view4 = this.targetView;
        this.Gvv = view4 != null ? (TransVoicePanelLayout) view4.findViewById(R.id.dyv) : null;
        TransVoicePanelLayout transVoicePanelLayout = this.Gvv;
        if (transVoicePanelLayout != null) {
            transVoicePanelLayout.setOnInputPanelChange(new h(this));
        }
        View view5 = this.targetView;
        this.GvR = view5 != null ? (CoordinatorLayout) view5.findViewById(R.id.my) : null;
        View view6 = this.targetView;
        if (view6 != null) {
            view = view6.findViewById(R.id.gs3);
        } else {
            view = null;
        }
        this.Gui = MMBottomSheetBehavior.x(view);
        MMBottomSheetBehavior<View> mMBottomSheetBehavior = this.Gui;
        if (mMBottomSheetBehavior != null) {
            mMBottomSheetBehavior.a(new o(this));
        }
        MMBottomSheetBehavior<View> mMBottomSheetBehavior2 = this.Gui;
        if (mMBottomSheetBehavior2 != null) {
            mMBottomSheetBehavior2.a(new p(this));
        }
        View view7 = this.targetView;
        this.Gvw = view7 != null ? (MMEditText) view7.findViewById(R.id.iuv) : null;
        MMEditText mMEditText = this.Gvw;
        if (mMEditText != null) {
            mMEditText.setCursorVisible(false);
            mMEditText.setOnEditorActionListener(new e(this));
            mMEditText.setMaxLines(Integer.MAX_VALUE);
            mMEditText.setHorizontallyScrolling(false);
            mMEditText.setOnClickListener(new f(this));
            mMEditText.addTextChangedListener(new g(this));
        }
        View view8 = this.targetView;
        this.Guf = view8 != null ? (ImageView) view8.findViewById(R.id.b4j) : null;
        ImageView imageView4 = this.Guf;
        if (imageView4 != null) {
            imageView4.setOnClickListener(new q(this));
        }
        View view9 = this.targetView;
        if (view9 != null) {
            imageView = (ImageView) view9.findViewById(R.id.iuw);
        } else {
            imageView = null;
        }
        this.Gvx = imageView;
        ImageView imageView5 = this.Gvx;
        if (imageView5 != null) {
            imageView5.setOnClickListener(new r(this));
        }
        View view10 = this.targetView;
        if (view10 != null) {
            imageView2 = (ImageView) view10.findViewById(R.id.b4e);
        } else {
            imageView2 = null;
        }
        this.Gvy = imageView2;
        ImageView imageView6 = this.Gvy;
        if (imageView6 != null) {
            imageView6.setOnClickListener(new s(this));
        }
        View view11 = this.targetView;
        this.Gvz = view11 != null ? view11.findViewById(R.id.gs1) : null;
        View view12 = this.targetView;
        if (view12 != null) {
            view2 = view12.findViewById(R.id.hta);
        } else {
            view2 = null;
        }
        this.GvA = view2;
        View view13 = this.targetView;
        if (view13 != null) {
            imageView3 = (ImageView) view13.findViewById(R.id.htf);
        } else {
            imageView3 = null;
        }
        this.GvB = imageView3;
        ImageView imageView7 = this.GvB;
        if (imageView7 != null) {
            imageView7.setOnClickListener(new t(this));
        }
        View view14 = this.targetView;
        this.FBO = view14 != null ? (FrameLayout) view14.findViewById(R.id.c1l) : null;
        this.rum = ad.bC(getContext());
        this.oXi = KeyBoardUtil.getValidPanelHeight(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, this.oXi);
        FrameLayout frameLayout = this.FBO;
        if (frameLayout != null) {
            frameLayout.addView(this.rum, layoutParams2);
        }
        ChatFooterPanel chatFooterPanel = this.rum;
        if (chatFooterPanel != null) {
            chatFooterPanel.setPortHeightPx(this.oXi);
        }
        ChatFooterPanel chatFooterPanel2 = this.rum;
        if (chatFooterPanel2 != null) {
            chatFooterPanel2.setEntranceScene(ChatFooterPanel.KbB);
        }
        ChatFooterPanel chatFooterPanel3 = this.rum;
        if (chatFooterPanel3 != null) {
            chatFooterPanel3.goD();
        }
        ChatFooterPanel chatFooterPanel4 = this.rum;
        if (chatFooterPanel4 != null) {
            chatFooterPanel4.onResume();
        }
        ChatFooterPanel chatFooterPanel5 = this.rum;
        if (chatFooterPanel5 != null) {
            chatFooterPanel5.setVisibility(0);
        }
        ChatFooterPanel chatFooterPanel6 = this.rum;
        if (chatFooterPanel6 != null) {
            chatFooterPanel6.setShowSend(true);
        }
        ChatFooterPanel chatFooterPanel7 = this.rum;
        if (chatFooterPanel7 != null) {
            chatFooterPanel7.setOnTextOperationListener(new v(this));
        }
        this.GvL = new MTimerHandler(new u(this), true);
        View view15 = this.targetView;
        this.GvC = view15 != null ? (Button) view15.findViewById(R.id.af7) : null;
        Button button2 = this.GvC;
        if (button2 != null) {
            button2.setOnClickListener(new i(this));
        }
        View view16 = this.targetView;
        if (view16 != null) {
            button = (Button) view16.findViewById(R.id.af8);
        } else {
            button = null;
        }
        this.GvD = button;
        Button button3 = this.GvD;
        if (button3 != null) {
            button3.setOnClickListener(new j(this));
        }
        Button button4 = this.GvC;
        if (button4 != null) {
            textPaint = button4.getPaint();
        } else {
            textPaint = null;
        }
        ao.a(textPaint, 0.8f);
        Button button5 = this.GvD;
        if (button5 != null) {
            textPaint2 = button5.getPaint();
        } else {
            textPaint2 = null;
        }
        ao.a(textPaint2, 0.8f);
        this.Guk = new k(this);
        Context context = getContext();
        kotlin.g.b.p.g(context, "context");
        this.GvN = new a(context);
        a aVar = this.GvN;
        if (aVar != null) {
            aVar.setOnDismissListener(l.Gwl);
            aVar.Guk = this.Guk;
        }
        this.GvO = new MMHandler(new m(this));
        setOnDismissListener(new n(this));
        AppMethodBeat.o(102596);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "isKeyboardShow", "", "keyboardHeight", "", "onInputPanelChange"})
    static final class h implements TransVoicePanelLayout.a {
        final /* synthetic */ b Gwk;

        h(b bVar) {
            this.Gwk = bVar;
        }

        @Override // com.tencent.mm.plugin.transvoice.ui.TransVoicePanelLayout.a
        public final void f(boolean z, int i2) {
            AppMethodBeat.i(102568);
            this.Gwk.FBV = z;
            Log.d("MicroMsg.TransVoiceDialog", "isKeyboardShow %s.", Boolean.valueOf(z));
            if (!z) {
                MMBottomSheetBehavior mMBottomSheetBehavior = this.Gwk.Gui;
                if (!(mMBottomSheetBehavior == null || 3 != mMBottomSheetBehavior.getState() || EnumC1844b.INPUT_EMOJI == this.Gwk.GvF)) {
                    this.Gwk.GvS = c.MODE_ONLY_PANEL;
                }
                switch (c.$EnumSwitchMapping$0[this.Gwk.GvF.ordinal()]) {
                    case 2:
                        this.Gwk.GvF = EnumC1844b.INPUT_NONE;
                        if (c.MODE_WITH_KEYBOARD != this.Gwk.GvS) {
                            b.b(this.Gwk, false);
                            b.c(this.Gwk, true);
                            ChatFooterPanel chatFooterPanel = this.Gwk.rum;
                            if (chatFooterPanel != null) {
                                chatFooterPanel.setVisibility(8);
                            }
                            MMEditText mMEditText = this.Gwk.Gvw;
                            if (mMEditText != null) {
                                mMEditText.setCursorVisible(false);
                            }
                            b.e(this.Gwk, false);
                            break;
                        }
                        break;
                }
            } else {
                this.Gwk.GvF = EnumC1844b.INPUT_KEYBOARD;
                MMBottomSheetBehavior mMBottomSheetBehavior2 = this.Gwk.Gui;
                if (mMBottomSheetBehavior2 != null && 3 == mMBottomSheetBehavior2.getState()) {
                    this.Gwk.GvS = c.MODE_WITH_KEYBOARD;
                }
                MMEditText mMEditText2 = this.Gwk.Gvw;
                if (mMEditText2 != null) {
                    mMEditText2.setCursorVisible(true);
                }
                b.b(this.Gwk, true);
                b.c(this.Gwk, false);
                b.d(this.Gwk, false);
                ImageView imageView = this.Gwk.GvB;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.of);
                }
                b.e(this.Gwk, true);
            }
            if (!(this.Gwk.oXi == i2 || i2 == 0)) {
                this.Gwk.oXi = i2;
                com.tencent.mm.compatible.util.i.C(this.Gwk.getContext(), i2);
                b.i(this.Gwk);
            }
            AppMethodBeat.o(102568);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0017¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$2", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
    public static final class o extends MMBottomSheetBehavior.a {
        final /* synthetic */ b Gwk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(b bVar) {
            this.Gwk = bVar;
        }

        @Override // android.support.design.widget.MMBottomSheetBehavior.a
        public final void b(View view, float f2) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(102576);
            kotlin.g.b.p.h(view, "bottomSheet");
            Log.d("MicroMsg.TransVoiceDialog", "slideOffset: %f, panelDragOpeMode: %s.", Float.valueOf(f2), this.Gwk.GvS);
            MMBottomSheetBehavior mMBottomSheetBehavior = this.Gwk.Gui;
            if (mMBottomSheetBehavior != null) {
                if (mMBottomSheetBehavior.getState() == 1) {
                    if (c.MODE_ONLY_PANEL == this.Gwk.GvS) {
                        b bVar = this.Gwk;
                        if (0.7f >= f2) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        bVar.Guj = z2;
                        Window window = this.Gwk.getWindow();
                        if (window != null) {
                            window.setDimAmount((float) (0.5d - (((double) (1.0f - f2)) / 2.0d)));
                        }
                    }
                    if (c.MODE_WITH_KEYBOARD == this.Gwk.GvS) {
                        b bVar2 = this.Gwk;
                        if (0.8f >= f2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        bVar2.GvU = z;
                        if (0.9f >= f2) {
                            if (!this.Gwk.GvT) {
                                this.Gwk.GvT = true;
                                b.i(this.Gwk, false);
                                b.b(this.Gwk, false);
                                b.c(this.Gwk, false);
                                b.d(this.Gwk, false);
                                ImageView imageView = this.Gwk.GvB;
                                if (imageView != null) {
                                    imageView.setImageResource(R.drawable.of);
                                    AppMethodBeat.o(102576);
                                    return;
                                }
                                AppMethodBeat.o(102576);
                                return;
                            }
                        } else if (this.Gwk.GvT) {
                            this.Gwk.GvT = false;
                            b.i(this.Gwk, true);
                            b.b(this.Gwk, true);
                            b.c(this.Gwk, false);
                            b.d(this.Gwk, false);
                        }
                    }
                }
                AppMethodBeat.o(102576);
                return;
            }
            AppMethodBeat.o(102576);
        }

        @Override // android.support.design.widget.MMBottomSheetBehavior.a
        @SuppressLint({"SwitchIntDef"})
        public final void f(View view, int i2) {
            AppMethodBeat.i(102577);
            kotlin.g.b.p.h(view, "bottomSheet");
            Log.d("MicroMsg.TransVoiceDialog", "newState: %d, panelDragOpeMode: %s, canClosePanel: %s, canHideKeyboard: %s, canCloseKeyboard: %s.", Integer.valueOf(i2), this.Gwk.GvS, Boolean.valueOf(this.Gwk.Guj), Boolean.valueOf(this.Gwk.GvT), Boolean.valueOf(this.Gwk.GvU));
            switch (i2) {
                case 1:
                    this.Gwk.Guj = false;
                    this.Gwk.GvT = false;
                    this.Gwk.GvU = false;
                    break;
                case 2:
                    if (c.MODE_ONLY_PANEL == this.Gwk.GvS && this.Gwk.Guj) {
                        b.b(this.Gwk, 6);
                    }
                    if (c.MODE_WITH_KEYBOARD == this.Gwk.GvS && this.Gwk.GvT) {
                        if (!this.Gwk.GvU) {
                            b.i(this.Gwk, true);
                            b.b(this.Gwk, true);
                            b.c(this.Gwk, false);
                            b.d(this.Gwk, false);
                            break;
                        } else {
                            this.Gwk.GvS = c.MODE_ONLY_PANEL;
                            b.c(this.Gwk, true);
                            b.b(this.Gwk, false);
                            ChatFooterPanel chatFooterPanel = this.Gwk.rum;
                            if (chatFooterPanel != null) {
                                chatFooterPanel.setVisibility(8);
                            }
                            MMEditText mMEditText = this.Gwk.Gvw;
                            if (mMEditText != null) {
                                mMEditText.setCursorVisible(false);
                            }
                            b.e(this.Gwk, false);
                            TransVoicePanelLayout transVoicePanelLayout = this.Gwk.Gvv;
                            if (transVoicePanelLayout != null) {
                                transVoicePanelLayout.postDelayed(new a(this), 200);
                                break;
                            }
                        }
                    }
                    break;
            }
            if (!(1 == i2 || 3 == i2)) {
                if (!this.Gwk.Guj) {
                    Window window = this.Gwk.getWindow();
                    if (window != null) {
                        window.setDimAmount(0.5f);
                    }
                    MMBottomSheetBehavior mMBottomSheetBehavior = this.Gwk.Gui;
                    if (mMBottomSheetBehavior != null) {
                        mMBottomSheetBehavior.cU();
                        AppMethodBeat.o(102577);
                        return;
                    }
                    AppMethodBeat.o(102577);
                    return;
                }
                b.b(this.Gwk, 6);
            }
            AppMethodBeat.o(102577);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ o Gwm;

            a(o oVar) {
                this.Gwm = oVar;
            }

            public final void run() {
                AppMethodBeat.i(102575);
                TransVoicePanelLayout transVoicePanelLayout = this.Gwm.Gwk.Gvv;
                if (transVoicePanelLayout != null) {
                    transVoicePanelLayout.requestLayout();
                    AppMethodBeat.o(102575);
                    return;
                }
                AppMethodBeat.o(102575);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$ExternalTouchHelper;", "downY", "", "getDownY", "()F", "setDownY", "(F)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onNeedJudge", "plugin-transvoice_release"})
    public static final class p implements MMBottomSheetBehavior.b {
        final /* synthetic */ b Gwk;
        private float dep;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(b bVar) {
            this.Gwk = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
        @Override // android.support.design.widget.MMBottomSheetBehavior.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
            /*
            // Method dump skipped, instructions count: 272
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.transvoice.ui.b.p.onInterceptTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$1"})
    static final class e implements TextView.OnEditorActionListener {
        final /* synthetic */ b Gwk;

        e(b bVar) {
            this.Gwk = bVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            AppMethodBeat.i(102565);
            if (4 != i2) {
                kotlin.g.b.p.g(keyEvent, "event");
                if (66 != keyEvent.getAction()) {
                    AppMethodBeat.o(102565);
                    return false;
                }
            }
            b.o(this.Gwk);
            AppMethodBeat.o(102565);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$2"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ b Gwk;

        f(b bVar) {
            this.Gwk = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102566);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Gwk.Gvs.Gua = 1;
            this.Gwk.GvQ = true;
            if (this.Gwk.GvM) {
                this.Gwk.GvM = false;
                this.Gwk.Gvs.GtY = 0;
                this.Gwk.Gvs.GtU = System.currentTimeMillis();
                com.tencent.mm.plugin.transvoice.a.b bVar2 = this.Gwk.GvE;
                if (bVar2 != null) {
                    bVar2.cancel(true);
                }
                View view2 = this.Gwk.Gvz;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                MMHandler mMHandler = this.Gwk.GvO;
                if (mMHandler != null) {
                    mMHandler.removeMessages(5000);
                }
                MTimerHandler mTimerHandler = this.Gwk.GvL;
                if (mTimerHandler != null) {
                    mTimerHandler.stopTimer();
                }
                MMEditText mMEditText = this.Gwk.Gvw;
                if (mMEditText != null) {
                    mMEditText.setText(this.Gwk.GvZ);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102566);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-transvoice_release"})
    public static final class g implements TextWatcher {
        final /* synthetic */ b Gwk;

        g(b bVar) {
            this.Gwk = bVar;
        }

        public final void afterTextChanged(Editable editable) {
            boolean z;
            int i2 = 0;
            AppMethodBeat.i(102567);
            if (!this.Gwk.Gvu && this.Gwk.GvQ) {
                this.Gwk.Gvu = true;
                this.Gwk.Gvs.GtZ = 1;
            }
            Button button = this.Gwk.GvD;
            if (button != null) {
                if (!Util.isNullOrNil(editable)) {
                    z = true;
                } else {
                    z = false;
                }
                button.setEnabled(z);
            }
            ImageView imageView = this.Gwk.Gvx;
            if (imageView != null) {
                if (Util.isNullOrNil(editable)) {
                    i2 = 4;
                }
                imageView.setVisibility(i2);
                AppMethodBeat.o(102567);
                return;
            }
            AppMethodBeat.o(102567);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class q implements View.OnClickListener {
        final /* synthetic */ b Gwk;

        q(b bVar) {
            this.Gwk = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102579);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.b(this.Gwk, 6);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102579);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class r implements View.OnClickListener {
        final /* synthetic */ b Gwk;

        r(b bVar) {
            this.Gwk = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102580);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Gwk.Gvt = System.currentTimeMillis();
            a aVar = this.Gwk.GvN;
            if (aVar != null) {
                aVar.jvS = this.Gwk.jvS;
            }
            a aVar2 = this.Gwk.GvN;
            if (aVar2 != null) {
                aVar2.fAw();
            }
            a aVar3 = this.Gwk.GvN;
            if (aVar3 != null) {
                aVar3.show();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102580);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class s implements View.OnClickListener {
        final /* synthetic */ b Gwk;

        s(b bVar) {
            this.Gwk = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102581);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            switch (c.haE[this.Gwk.GvF.ordinal()]) {
                case 1:
                    b.i(this.Gwk, false);
                    break;
                case 2:
                    this.Gwk.GvF = EnumC1844b.INPUT_NONE;
                    b.b(this.Gwk, false);
                    b.c(this.Gwk, true);
                    ChatFooterPanel chatFooterPanel = this.Gwk.rum;
                    if (chatFooterPanel != null) {
                        chatFooterPanel.setVisibility(8);
                    }
                    MMEditText mMEditText = this.Gwk.Gvw;
                    if (mMEditText != null) {
                        mMEditText.setCursorVisible(false);
                    }
                    b.e(this.Gwk, false);
                    break;
                case 3:
                    this.Gwk.GvF = EnumC1844b.INPUT_NONE;
                    b.b(this.Gwk, 6);
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102581);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class t implements View.OnClickListener {
        final /* synthetic */ b Gwk;

        t(b bVar) {
            this.Gwk = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102582);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.Gwk.FBV) {
                this.Gwk.GvF = EnumC1844b.INPUT_EMOJI;
                b.i(this.Gwk, false);
                b.d(this.Gwk, true);
                ImageView imageView = this.Gwk.GvB;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.oh);
                }
            } else {
                this.Gwk.GvF = EnumC1844b.INPUT_KEYBOARD;
                b.i(this.Gwk, true);
                b.d(this.Gwk, false);
                ImageView imageView2 = this.Gwk.GvB;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.of);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102582);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class u implements MTimerHandler.CallBack {
        final /* synthetic */ b Gwk;

        u(b bVar) {
            this.Gwk = bVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(102583);
            int i2 = this.Gwk.GvK % 3;
            this.Gwk.GvK++;
            switch (i2) {
                case 0:
                    this.Gwk.GvJ = "·";
                    break;
                case 1:
                    this.Gwk.GvJ = "··";
                    break;
                case 2:
                    this.Gwk.GvJ = "···";
                    break;
            }
            b.E(this.Gwk);
            AppMethodBeat.o(102583);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ b Gwk;

        i(b bVar) {
            this.Gwk = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102569);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.TransVoiceDialog", "sendVoiceMsg onClick.");
            d dVar = this.Gwk.Gwa;
            if (dVar != null && true == dVar.b(this.Gwk.GvH, Long.valueOf(this.Gwk.GvG))) {
                this.Gwk.GvI = true;
            }
            b.b(this.Gwk, 7);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102569);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ b Gwk;

        j(b bVar) {
            this.Gwk = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102570);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.o(this.Gwk);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102570);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$12", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
    public static final class k implements a.b {
        final /* synthetic */ b Gwk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(b bVar) {
            this.Gwk = bVar;
        }

        @Override // com.tencent.mm.plugin.transvoice.ui.a.b
        public final void acp(int i2) {
            AppMethodBeat.i(102571);
            a aVar = this.Gwk.GvN;
            if (aVar != null) {
                aVar.dismiss();
            }
            b.d(this.Gwk, i2);
            if (i2 == this.Gwk.jvS) {
                AppMethodBeat.o(102571);
            } else if (NetStatusUtil.isConnected(this.Gwk.getContext())) {
                b bVar = this.Gwk;
                bVar.Gvu = false;
                bVar.GvQ = false;
                bVar.Gvs.GtQ = bVar.Gvt;
                bVar.Gvs.GtT = 0;
                bVar.Gvs.GtU = 0;
                bVar.Gvs.GtV = 0;
                bVar.Gvs.GtY = 0;
                bVar.Gvs.GtZ = 0;
                bVar.Gvs.Gua = 0;
                bVar.fAH();
                MMHandler mMHandler = bVar.GvO;
                if (mMHandler != null) {
                    mMHandler.sendEmptyMessageDelayed(5000, 5000);
                }
                MTimerHandler mTimerHandler = bVar.GvL;
                if (mTimerHandler != null) {
                    mTimerHandler.startTimer(500);
                }
                bVar.jvS = i2;
                long nanoTime = System.nanoTime() & Util.MAX_32BIT_VALUE;
                if (nanoTime < 0) {
                    nanoTime = Math.abs(nanoTime);
                }
                com.tencent.mm.modelvoiceaddr.h hVar = new com.tencent.mm.modelvoiceaddr.h(String.valueOf(nanoTime));
                com.tencent.mm.modelvoiceaddr.h hVar2 = bVar.jvN;
                if (hVar2 != null) {
                    hVar2.a(hVar);
                }
                bVar.GvE = new com.tencent.mm.plugin.transvoice.a.b(hVar, i2, new y(bVar));
                com.tencent.mm.plugin.transvoice.a.b bVar2 = bVar.GvE;
                if (bVar2 != null) {
                    bVar2.start();
                    AppMethodBeat.o(102571);
                    return;
                }
                AppMethodBeat.o(102571);
            } else {
                d.a aVar2 = new d.a(this.Gwk.getContext());
                Context context = this.Gwk.getContext();
                kotlin.g.b.p.g(context, "context");
                aVar2.boo(context.getResources().getString(R.string.x3));
                Context context2 = this.Gwk.getContext();
                kotlin.g.b.p.g(context2, "context");
                aVar2.bou(context2.getResources().getString(R.string.fbr));
                Context context3 = this.Gwk.getContext();
                kotlin.g.b.p.g(context3, "context");
                aVar2.aoX(context3.getResources().getColor(R.color.Link_100));
                aVar2.hbn().show();
                AppMethodBeat.o(102571);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class l implements DialogInterface.OnDismissListener {
        public static final l Gwl = new l();

        static {
            AppMethodBeat.i(102572);
            AppMethodBeat.o(102572);
        }

        l() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class m implements MMHandler.Callback {
        final /* synthetic */ b Gwk;

        m(b bVar) {
            this.Gwk = bVar;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(102573);
            switch (message.what) {
                case 5000:
                    this.Gwk.Gvs.GtT = 1;
                    this.Gwk.Gvs.GtU = System.currentTimeMillis();
                    this.Gwk.Gvs.GtY = 0;
                    MTimerHandler mTimerHandler = this.Gwk.GvL;
                    if (mTimerHandler != null) {
                        mTimerHandler.stopTimer();
                    }
                    com.tencent.mm.plugin.transvoice.a.b bVar = this.Gwk.GvE;
                    if (bVar != null) {
                        bVar.cancel(false);
                    }
                    if (!Util.isNullOrNil(this.Gwk.GvZ)) {
                        MMEditText mMEditText = this.Gwk.Gvw;
                        if (mMEditText != null) {
                            mMEditText.setFocusable(true);
                        }
                        MMEditText mMEditText2 = this.Gwk.Gvw;
                        if (mMEditText2 != null) {
                            mMEditText2.setFocusableInTouchMode(true);
                        }
                    }
                    MMEditText mMEditText3 = this.Gwk.Gvw;
                    if (mMEditText3 != null) {
                        mMEditText3.setText(this.Gwk.GvZ);
                    }
                    View view = this.Gwk.Gvz;
                    if (view != null) {
                        view.setVisibility(0);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(102573);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class n implements DialogInterface.OnDismissListener {
        final /* synthetic */ b Gwk;

        n(b bVar) {
            this.Gwk = bVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(102574);
            Log.d("MicroMsg.TransVoiceDialog", "onDismiss.");
            if (this.Gwk.GvV) {
                this.Gwk.GvV = false;
                if (!Util.isNullOrNil(this.Gwk.GvW)) {
                    d dVar = this.Gwk.Gwa;
                    if (dVar != null) {
                        dVar.aTP(this.Gwk.GvW);
                    }
                    b.b(this.Gwk, this.Gwk.GvW);
                }
            }
            AppMethodBeat.o(102574);
        }
    }

    public final void onBackPressed() {
        AppMethodBeat.i(102597);
        acv(6);
        super.onBackPressed();
        AppMethodBeat.o(102597);
    }

    private final void wA(boolean z) {
        AppMethodBeat.i(102598);
        if (z) {
            ImageView imageView = this.Gvx;
            if (imageView != null) {
                imageView.setVisibility(4);
                AppMethodBeat.o(102598);
                return;
            }
            AppMethodBeat.o(102598);
            return;
        }
        ImageView imageView2 = this.Gvx;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
            AppMethodBeat.o(102598);
            return;
        }
        AppMethodBeat.o(102598);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-transvoice_release"})
    public static final class v implements ChatFooterPanel.a {
        final /* synthetic */ b Gwk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        v(b bVar) {
            this.Gwk = bVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void append(String str) {
            AppMethodBeat.i(102584);
            MMEditText mMEditText = this.Gwk.Gvw;
            if (mMEditText != null) {
                mMEditText.bol(str);
                AppMethodBeat.o(102584);
                return;
            }
            AppMethodBeat.o(102584);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHC() {
            InputConnection inputConnection;
            InputConnection inputConnection2;
            AppMethodBeat.i(102585);
            MMEditText mMEditText = this.Gwk.Gvw;
            if (!(mMEditText == null || (inputConnection2 = mMEditText.getInputConnection()) == null)) {
                inputConnection2.sendKeyEvent(new KeyEvent(0, 67));
            }
            MMEditText mMEditText2 = this.Gwk.Gvw;
            if (mMEditText2 == null || (inputConnection = mMEditText2.getInputConnection()) == null) {
                AppMethodBeat.o(102585);
                return;
            }
            inputConnection.sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.o(102585);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void eP(boolean z) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHD() {
            AppMethodBeat.i(102586);
            b.o(this.Gwk);
            AppMethodBeat.o(102586);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class w implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ b Gwk;

        w(b bVar, Context context) {
            this.Gwk = bVar;
            this.$context = context;
        }

        public final void run() {
            AppMethodBeat.i(102587);
            InputMethodManager inputMethodManager = (InputMethodManager) this.$context.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.Gwk.Gvw, 0);
                AppMethodBeat.o(102587);
                return;
            }
            AppMethodBeat.o(102587);
        }
    }

    private final void setKeyboardVisibility(boolean z) {
        AppMethodBeat.i(102599);
        Log.d("MicroMsg.TransVoiceDialog", "setKeyboardVisibility, %s.", Boolean.valueOf(z));
        if (z) {
            View view = this.targetView;
            if (view != null) {
                view.removeCallbacks(this.ruJ);
            }
            View view2 = this.targetView;
            if (view2 != null) {
                view2.post(this.ruJ);
                AppMethodBeat.o(102599);
                return;
            }
            AppMethodBeat.o(102599);
            return;
        }
        View view3 = this.targetView;
        if (view3 != null) {
            view3.removeCallbacks(this.ruJ);
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            MMEditText mMEditText = this.Gvw;
            inputMethodManager.hideSoftInputFromWindow(mMEditText != null ? mMEditText.getWindowToken() : null, 0);
            AppMethodBeat.o(102599);
            return;
        }
        AppMethodBeat.o(102599);
    }

    private final void acv(int i2) {
        d dVar;
        AppMethodBeat.i(102600);
        if (isShowing()) {
            this.Gvs.setExitType(i2);
            fAH();
            dismiss();
            d dVar2 = this.Gwa;
            if (dVar2 != null) {
                dVar2.fAI();
            }
            if (!this.GvI && (dVar = this.Gwa) != null) {
                dVar.aTQ(this.GvH);
            }
            this.GvI = false;
        }
        AppMethodBeat.o(102600);
    }

    /* access modifiers changed from: package-private */
    public final void fAH() {
        AppMethodBeat.i(102601);
        this.GvZ = "";
        this.GvK = 0;
        this.GvJ = "";
        this.GvM = false;
        MMEditText mMEditText = this.Gvw;
        if (mMEditText != null) {
            mMEditText.setText("");
        }
        MMEditText mMEditText2 = this.Gvw;
        if (mMEditText2 != null) {
            mMEditText2.setCursorVisible(false);
        }
        MMEditText mMEditText3 = this.Gvw;
        if (mMEditText3 != null) {
            mMEditText3.setFocusable(false);
        }
        MMEditText mMEditText4 = this.Gvw;
        if (mMEditText4 != null) {
            mMEditText4.setFocusableInTouchMode(false);
        }
        View view = this.Gvz;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.GvA;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setKeyboardVisibility(false);
        ChatFooterPanel chatFooterPanel = this.rum;
        if (chatFooterPanel != null) {
            chatFooterPanel.setVisibility(8);
        }
        wA(false);
        MMHandler mMHandler = this.GvO;
        if (mMHandler != null) {
            mMHandler.removeMessages(5000);
        }
        this.GvS = c.MODE_ONLY_PANEL;
        this.Guj = false;
        this.GvT = false;
        this.GvU = false;
        AppMethodBeat.o(102601);
    }

    public final void aTO(String str) {
        AppMethodBeat.i(102602);
        kotlin.g.b.p.h(str, "<set-?>");
        this.GvZ = str;
        AppMethodBeat.o(102602);
    }

    public final void c(com.tencent.mm.modelvoiceaddr.h hVar) {
        AppMethodBeat.i(185256);
        kotlin.g.b.p.h(hVar, "container");
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.5f);
        }
        MMBottomSheetBehavior<View> mMBottomSheetBehavior = this.Gui;
        if (mMBottomSheetBehavior != null) {
            mMBottomSheetBehavior.cU();
        }
        this.Gvu = false;
        this.GvQ = false;
        int i2 = this.GvP.getInt(this.talker, 0);
        a aVar = this.GvN;
        if (aVar == null) {
            kotlin.g.b.p.hyc();
        }
        ArrayList<Integer> arrayList = aVar.Gug;
        if (arrayList == null) {
            kotlin.g.b.p.hyc();
        }
        if (arrayList.contains(Integer.valueOf(i2))) {
            this.jvS = i2;
        } else {
            a aVar2 = this.GvN;
            if (aVar2 == null) {
                kotlin.g.b.p.hyc();
            }
            ArrayList<Integer> arrayList2 = aVar2.Gug;
            if (arrayList2 == null) {
                kotlin.g.b.p.hyc();
            }
            if (arrayList2.size() > 0) {
                a aVar3 = this.GvN;
                if (aVar3 == null) {
                    kotlin.g.b.p.hyc();
                }
                ArrayList<Integer> arrayList3 = aVar3.Gug;
                if (arrayList3 == null) {
                    kotlin.g.b.p.hyc();
                }
                Integer num = arrayList3.get(0);
                kotlin.g.b.p.g(num, "languageChoiceDialog!!.langTypeArr!![0]");
                this.jvS = num.intValue();
            } else {
                String currentLanguage = LocaleUtil.getCurrentLanguage(getContext());
                if (kotlin.g.b.p.j(currentLanguage, LocaleUtil.CHINA) || kotlin.g.b.p.j(currentLanguage, LocaleUtil.HONGKONG) || kotlin.g.b.p.j(currentLanguage, LocaleUtil.TAIWAN)) {
                    this.jvS = com.tencent.mm.modelvoiceaddr.g.jwq;
                } else if (kotlin.g.b.p.j(currentLanguage, LocaleUtil.ENGLISH)) {
                    this.jvS = com.tencent.mm.modelvoiceaddr.g.jws;
                }
            }
        }
        this.Gvs.GtR = this.jvS;
        fAH();
        MMHandler mMHandler = this.GvO;
        if (mMHandler != null) {
            mMHandler.sendEmptyMessageDelayed(5000, 5000);
        }
        MTimerHandler mTimerHandler = this.GvL;
        if (mTimerHandler != null) {
            mTimerHandler.startTimer(500);
        }
        this.jvN = hVar;
        this.GvE = new com.tencent.mm.plugin.transvoice.a.b(hVar, this.jvS, new x(this));
        com.tencent.mm.plugin.transvoice.a.b bVar = this.GvE;
        if (bVar != null) {
            bVar.start();
            AppMethodBeat.o(185256);
            return;
        }
        AppMethodBeat.o(185256);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J/\u0010\f\u001a\u00020\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
    public static final class x implements g.b {
        final /* synthetic */ b Gwk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        x(b bVar) {
            this.Gwk = bVar;
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void b(String[] strArr, List<String> list) {
            String str;
            AppMethodBeat.i(102588);
            Log.i("MicroMsg.TransVoiceDialog", "onRes.");
            this.Gwk.GvY = list;
            MMHandler mMHandler = this.Gwk.GvO;
            if (mMHandler != null) {
                mMHandler.removeMessages(5000);
            }
            MMHandler mMHandler2 = this.Gwk.GvO;
            if (mMHandler2 != null) {
                mMHandler2.sendEmptyMessageDelayed(5000, 5000);
            }
            if (strArr == null || (str = strArr[0]) == null) {
                AppMethodBeat.o(102588);
                return;
            }
            if (str.length() > 0) {
                this.Gwk.aTO(strArr[0]);
                Log.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", this.Gwk.GvZ);
                this.Gwk.Gvs.GtV = this.Gwk.GvZ.length();
                if (!this.Gwk.GvM) {
                    this.Gwk.GvM = true;
                    MMEditText mMEditText = this.Gwk.Gvw;
                    if (mMEditText != null) {
                        mMEditText.setFocusable(true);
                    }
                    MMEditText mMEditText2 = this.Gwk.Gvw;
                    if (mMEditText2 != null) {
                        mMEditText2.setFocusableInTouchMode(true);
                    }
                    MMEditText mMEditText3 = this.Gwk.Gvw;
                    if (mMEditText3 != null) {
                        mMEditText3.requestFocus();
                        AppMethodBeat.o(102588);
                        return;
                    }
                }
            }
            AppMethodBeat.o(102588);
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void c(int i2, int i3, int i4, long j2) {
            AppMethodBeat.i(102589);
            Log.i("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2));
            this.Gwk.Gvs.GtY = 0;
            this.Gwk.Gvs.GtU = System.currentTimeMillis();
            AppMethodBeat.o(102589);
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void biv() {
            AppMethodBeat.i(102590);
            Log.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
            AppMethodBeat.o(102590);
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void biz() {
            AppMethodBeat.i(102591);
            Log.i("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
            this.Gwk.GvM = false;
            this.Gwk.Gvs.GtY = 1;
            this.Gwk.Gvs.GtU = System.currentTimeMillis();
            MMHandler mMHandler = this.Gwk.GvO;
            if (mMHandler != null) {
                mMHandler.removeMessages(5000);
            }
            MTimerHandler mTimerHandler = this.Gwk.GvL;
            if (mTimerHandler != null) {
                mTimerHandler.stopTimer();
            }
            b.J(this.Gwk);
            View view = this.Gwk.Gvz;
            if (view != null) {
                view.setVisibility(0);
                AppMethodBeat.o(102591);
                return;
            }
            AppMethodBeat.o(102591);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J/\u0010\f\u001a\u00020\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$2", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
    public static final class y implements g.b {
        final /* synthetic */ b Gwk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        y(b bVar) {
            this.Gwk = bVar;
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void b(String[] strArr, List<String> list) {
            String str;
            AppMethodBeat.i(102592);
            Log.d("MicroMsg.TransVoiceDialog", "onRes.");
            this.Gwk.GvY = list;
            MMHandler mMHandler = this.Gwk.GvO;
            if (mMHandler != null) {
                mMHandler.removeMessages(5000);
            }
            MMHandler mMHandler2 = this.Gwk.GvO;
            if (mMHandler2 != null) {
                mMHandler2.sendEmptyMessageDelayed(5000, 5000);
            }
            if (strArr == null || (str = strArr[0]) == null) {
                AppMethodBeat.o(102592);
                return;
            }
            if (str.length() > 0) {
                this.Gwk.aTO(strArr[0]);
                Log.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", this.Gwk.GvZ);
                this.Gwk.Gvs.GtV = this.Gwk.GvZ.length();
                if (!this.Gwk.GvM) {
                    this.Gwk.GvM = true;
                    MMEditText mMEditText = this.Gwk.Gvw;
                    if (mMEditText != null) {
                        mMEditText.setFocusable(true);
                    }
                    MMEditText mMEditText2 = this.Gwk.Gvw;
                    if (mMEditText2 != null) {
                        mMEditText2.setFocusableInTouchMode(true);
                    }
                    MMEditText mMEditText3 = this.Gwk.Gvw;
                    if (mMEditText3 != null) {
                        mMEditText3.requestFocus();
                        AppMethodBeat.o(102592);
                        return;
                    }
                }
            }
            AppMethodBeat.o(102592);
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void c(int i2, int i3, int i4, long j2) {
            AppMethodBeat.i(102593);
            Log.d("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2));
            this.Gwk.Gvs.GtY = 0;
            this.Gwk.Gvs.GtU = System.currentTimeMillis();
            AppMethodBeat.o(102593);
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void biv() {
            AppMethodBeat.i(102594);
            Log.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
            AppMethodBeat.o(102594);
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void biz() {
            AppMethodBeat.i(102595);
            Log.d("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
            this.Gwk.GvM = false;
            this.Gwk.Gvs.GtY = 1;
            this.Gwk.Gvs.GtU = System.currentTimeMillis();
            MMHandler mMHandler = this.Gwk.GvO;
            if (mMHandler != null) {
                mMHandler.removeMessages(5000);
            }
            MTimerHandler mTimerHandler = this.Gwk.GvL;
            if (mTimerHandler != null) {
                mTimerHandler.stopTimer();
            }
            b.J(this.Gwk);
            View view = this.Gwk.Gvz;
            if (view != null) {
                view.setVisibility(0);
                AppMethodBeat.o(102595);
                return;
            }
            AppMethodBeat.o(102595);
        }
    }

    public final void show() {
        AppMethodBeat.i(102603);
        a.C0295a aVar = com.tencent.mm.cj.a.Owq;
        com.tencent.mm.cj.a.Own = true;
        super.show();
        AppMethodBeat.o(102603);
    }

    public static final /* synthetic */ void b(b bVar, boolean z) {
        AppMethodBeat.i(102606);
        if (z) {
            View view = bVar.GvA;
            if (view != null) {
                view.setVisibility(0);
                AppMethodBeat.o(102606);
                return;
            }
            AppMethodBeat.o(102606);
            return;
        }
        View view2 = bVar.GvA;
        if (view2 != null) {
            view2.setVisibility(8);
            AppMethodBeat.o(102606);
            return;
        }
        AppMethodBeat.o(102606);
    }

    public static final /* synthetic */ void c(b bVar, boolean z) {
        AppMethodBeat.i(102607);
        if (z) {
            View view = bVar.Gvz;
            if (view != null) {
                view.setVisibility(0);
                AppMethodBeat.o(102607);
                return;
            }
            AppMethodBeat.o(102607);
            return;
        }
        View view2 = bVar.Gvz;
        if (view2 != null) {
            view2.setVisibility(8);
            AppMethodBeat.o(102607);
            return;
        }
        AppMethodBeat.o(102607);
    }

    public static final /* synthetic */ void d(b bVar, boolean z) {
        AppMethodBeat.i(102608);
        if (z) {
            ChatFooterPanel chatFooterPanel = bVar.rum;
            if (chatFooterPanel != null) {
                chatFooterPanel.setVisibility(0);
                AppMethodBeat.o(102608);
                return;
            }
            AppMethodBeat.o(102608);
            return;
        }
        ChatFooterPanel chatFooterPanel2 = bVar.rum;
        if (chatFooterPanel2 != null) {
            chatFooterPanel2.setVisibility(4);
            AppMethodBeat.o(102608);
            return;
        }
        AppMethodBeat.o(102608);
    }

    public static final /* synthetic */ void i(b bVar) {
        AppMethodBeat.i(102610);
        int validPanelHeight = KeyBoardUtil.getValidPanelHeight(bVar.getContext());
        ChatFooterPanel chatFooterPanel = bVar.rum;
        if (chatFooterPanel != null) {
            chatFooterPanel.setPortHeightPx(validPanelHeight);
        }
        ChatFooterPanel chatFooterPanel2 = bVar.rum;
        ViewGroup.LayoutParams layoutParams = chatFooterPanel2 != null ? chatFooterPanel2.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = validPanelHeight;
        }
        AppMethodBeat.o(102610);
    }

    public static final /* synthetic */ void o(b bVar) {
        Editable editable;
        AppMethodBeat.i(102613);
        bVar.Gvs.GtS = bVar.jvS;
        MMEditText mMEditText = bVar.Gvw;
        if (mMEditText != null) {
            editable = mMEditText.getText();
        } else {
            editable = null;
        }
        String valueOf = String.valueOf(editable);
        if (!Util.isNullOrNil(valueOf)) {
            bVar.Gvs.GtW = valueOf.length();
            bVar.GvV = true;
            bVar.GvW = valueOf;
        } else {
            bVar.Gvs.GtW = 0;
            bVar.GvW = "";
        }
        if (bVar.Gvu) {
            bVar.acv(8);
            AppMethodBeat.o(102613);
            return;
        }
        bVar.acv(5);
        AppMethodBeat.o(102613);
    }

    public static final /* synthetic */ void E(b bVar) {
        int i2;
        AppMethodBeat.i(102614);
        String str = bVar.GvZ;
        if (str.length() > 3) {
            i2 = str.length() - 3;
        } else {
            i2 = 0;
        }
        String str2 = str + bVar.GvJ;
        SpannableString spannableString = new SpannableString(str2);
        Context context = bVar.getContext();
        kotlin.g.b.p.g(context, "context");
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.BW_0_Alpha_0_3)), i2, str2.length(), 18);
        MMEditText mMEditText = bVar.Gvw;
        if (mMEditText != null) {
            mMEditText.setText(spannableString);
            AppMethodBeat.o(102614);
            return;
        }
        AppMethodBeat.o(102614);
    }

    public static final /* synthetic */ void d(b bVar, int i2) {
        AppMethodBeat.i(102615);
        bVar.GvP.edit().putInt(bVar.talker, i2).apply();
        AppMethodBeat.o(102615);
    }

    public static final /* synthetic */ void b(b bVar, String str) {
        int i2;
        AppMethodBeat.i(102616);
        Object[] objArr = new Object[1];
        List<String> list = bVar.GvY;
        objArr[0] = list != null ? Integer.valueOf(list.size()) : null;
        Log.i("MicroMsg.TransVoiceDialog", "cgiReport size = %s", objArr);
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100235");
        if (Fu.isValid()) {
            i2 = Util.getInt(Fu.gzz().get("MMVoipVadOn"), 0);
        } else {
            i2 = 0;
        }
        Log.i("MicroMsg.TransVoiceDialog", "cgiReport: abTestFlag = [%s]", Integer.valueOf(i2));
        bVar.GvX.a(bVar.GvY, str, String.valueOf(i2));
        List<String> list2 = bVar.GvY;
        if (list2 != null) {
            list2.clear();
            AppMethodBeat.o(102616);
            return;
        }
        AppMethodBeat.o(102616);
    }

    public static final /* synthetic */ void J(b bVar) {
        AppMethodBeat.i(102617);
        if (!Util.isNullOrNil(bVar.GvZ)) {
            String str = bVar.GvZ;
            if (str == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(102617);
                throw tVar;
            }
            String obj = kotlin.n.n.trim(str).toString();
            int length = obj.length() - 1;
            if (obj == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(102617);
                throw tVar2;
            }
            String substring = obj.substring(length);
            kotlin.g.b.p.g(substring, "(this as java.lang.String).substring(startIndex)");
            Log.i("MicroMsg.TransVoiceDialog", "delPunctuation, msg = %s, msg.length() = %s, punctuation = %s.", Util.secPrint(obj), Integer.valueOf(obj.length()), substring);
            if (kotlin.n.n.I(substring, "。", true) || kotlin.n.n.I(substring, ".", true)) {
                int length2 = obj.length() - 1;
                if (obj == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(102617);
                    throw tVar3;
                }
                String substring2 = obj.substring(0, length2);
                kotlin.g.b.p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                MMEditText mMEditText = bVar.Gvw;
                if (mMEditText != null) {
                    mMEditText.setText(substring2);
                    AppMethodBeat.o(102617);
                    return;
                }
                AppMethodBeat.o(102617);
                return;
            }
            MMEditText mMEditText2 = bVar.Gvw;
            if (mMEditText2 != null) {
                mMEditText2.setText(obj);
                AppMethodBeat.o(102617);
                return;
            }
            AppMethodBeat.o(102617);
            return;
        }
        MMEditText mMEditText3 = bVar.Gvw;
        if (mMEditText3 != null) {
            mMEditText3.setText("");
            AppMethodBeat.o(102617);
            return;
        }
        AppMethodBeat.o(102617);
    }
}
