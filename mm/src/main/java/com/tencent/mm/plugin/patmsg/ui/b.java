package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ha;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002ABB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0002J\u0006\u00101\u001a\u00020-J\u0006\u00102\u001a\u00020-J\u0012\u00103\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0018\u00106\u001a\u00020-2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\bH\u0016J$\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0006\u0010@\u001a\u00020-R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0015\u0010&\u001a\u00060'R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;", "Landroid/support/v7/app/AppCompatDialog;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "dialogContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "PAT_SUFFIX_LENGTH_LIMIT", "", "getPAT_SUFFIX_LENGTH_LIMIT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "curSuffix", "getCurSuffix", "setCurSuffix", "(Ljava/lang/String;)V", "getDialogContext", "()Landroid/content/Context;", "setDialogContext", "errorTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getErrorTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "hintTv", "Landroid/widget/TextView;", "getHintTv", "()Landroid/widget/TextView;", "setHintTv", "(Landroid/widget/TextView;)V", "suffixET", "Landroid/widget/EditText;", "getSuffixET", "()Landroid/widget/EditText;", "setSuffixET", "(Landroid/widget/EditText;)V", "textWatcher", "Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "getTextWatcher", "()Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismiss", "", "doModifyPatSuffixScene", "suffix", "", "hideVKB", "initContentView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "onOpLogResult", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "showVKB", "Companion", "PatTextWatcher", "plugin-patmsg_release"})
public final class b extends android.support.v7.app.e implements h.a, b.a {
    private static b ARM;
    public static final a ARN = new a((byte) 0);
    final int ARG = 16;
    String ARH;
    EditText ARI;
    final C1569b ARJ = new C1569b();
    final MTimerHandler ARK = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new c(this), false);
    Context ARL;
    final String TAG = "MicroMsg.Pat.PatSuffixSettingDialog";
    TextView kuu;
    private q tipDialog;

    static {
        AppMethodBeat.i(207031);
        AppMethodBeat.o(207031);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.rs);
        p.h(context, "dialogContext");
        AppMethodBeat.i(207030);
        this.ARL = context;
        AppMethodBeat.o(207030);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(207026);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.addFlags(67108864);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setDimAmount(0.5f);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setWindowAnimations(R.style.fs);
        }
        View inflate = LayoutInflater.from(this.ARL).inflate(R.layout.bh_, (ViewGroup) null, false);
        p.g(inflate, "LayoutInflater.from(dial…ting_dialog, null, false)");
        setContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        this.ARI = (EditText) findViewById(R.id.g91);
        this.kuu = (TextView) findViewById(R.id.g92);
        inflate.findViewById(R.id.c2j).setOnTouchListener(new d(this));
        inflate.findViewById(R.id.b46).setOnClickListener(new e(this));
        setCancelable(true);
        EditText editText = (EditText) findViewById(R.id.g91);
        if (editText != null) {
            editText.requestFocus();
        }
        com.tencent.f.h.RTc.n(new f(this), 128);
        InputPanelLinearLayout inputPanelLinearLayout = (InputPanelLinearLayout) findViewById(R.id.dym);
        if (inputPanelLinearLayout != null) {
            inputPanelLinearLayout.setExternalListener(this);
        }
        View findViewById = findViewById(R.id.g3k);
        if (findViewById != null) {
            findViewById.setOnClickListener(new g(this));
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object i2 = aAh.azQ().i(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC);
        if (!(i2 instanceof String)) {
            i2 = null;
        }
        String str2 = (String) i2;
        if (str2 == null) {
            str2 = "";
        }
        this.ARH = str2;
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        int i3 = aAh2.azQ().getInt(ar.a.USERINFO_PAT_SUFFIX_VERSION_INT_SYNC, 0);
        Log.i(this.TAG, "curSuffix %s, suffixVersion %d", this.ARH, Integer.valueOf(i3));
        if (i3 == 0 && LocaleUtil.isChineseAppLang() && (str = this.ARH) != null) {
            this.ARH = "的".concat(String.valueOf(str));
        }
        String str3 = this.ARH;
        if (str3 != null) {
            EditText editText2 = this.ARI;
            if (editText2 != null) {
                editText2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.ARL, str3));
            }
            EditText editText3 = this.ARI;
            if (editText3 != null) {
                editText3.setSelection(str3.length());
            }
        }
        EditText editText4 = this.ARI;
        if (editText4 != null) {
            editText4.addTextChangedListener(this.ARJ);
        }
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eis().a(TbsListener.ErrorCode.UNLZMA_FAIURE, this);
        setOnDismissListener(new h(this));
        ha haVar = new ha();
        haVar.uP(String.valueOf(cl.aWA()));
        haVar.lo(1);
        haVar.agT();
        haVar.lp(0);
        haVar.bfK();
        com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
        com.tencent.mm.util.b.a(haVar);
        setOnCancelListener(i.ARP);
        ARM = this;
        AppMethodBeat.o(207026);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class d implements View.OnTouchListener {
        final /* synthetic */ b ARO;

        d(b bVar) {
            this.ARO = bVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(207019);
            this.ARO.cancel();
            AppMethodBeat.o(207019);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ b ARO;

        e(b bVar) {
            this.ARO = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(207020);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.ARO.cancel();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(207020);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ b ARO;

        f(b bVar) {
            this.ARO = bVar;
        }

        public final void run() {
            AppMethodBeat.i(207021);
            b bVar = this.ARO;
            Object systemService = bVar.ARL.getSystemService("input_method");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                AppMethodBeat.o(207021);
                throw tVar;
            }
            ((InputMethodManager) systemService).showSoftInput(bVar.ARI, 0);
            AppMethodBeat.o(207021);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ b ARO;

        g(b bVar) {
            this.ARO = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(207022);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EditText editText = (EditText) this.ARO.findViewById(R.id.g91);
            if (editText != null) {
                b bVar2 = this.ARO;
                Editable text = editText.getText();
                p.g(text, "it.text");
                b.a(bVar2, text);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(207022);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class h implements DialogInterface.OnDismissListener {
        final /* synthetic */ b ARO;

        h(b bVar) {
            this.ARO = bVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(207023);
            a aVar = b.ARN;
            b.ARM = null;
            this.ARO.ARK.stopTimer();
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eis().b(TbsListener.ErrorCode.UNLZMA_FAIURE, this.ARO);
            SecDataUIC.a aVar2 = SecDataUIC.CWq;
            czj czj = (czj) SecDataUIC.a.c(this.ARO.ARL, 4, czj.class);
            if (czj != null) {
                czj.MEF = 0;
                AppMethodBeat.o(207023);
                return;
            }
            AppMethodBeat.o(207023);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class i implements DialogInterface.OnCancelListener {
        public static final i ARP = new i();

        static {
            AppMethodBeat.i(207025);
            AppMethodBeat.o(207025);
        }

        i() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(207024);
            ha haVar = new ha();
            haVar.uP(String.valueOf(cl.aWA()));
            haVar.lo(3);
            haVar.agT();
            haVar.lp(0);
            haVar.bfK();
            com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(haVar);
            AppMethodBeat.o(207024);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;)V", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-patmsg_release"})
    /* renamed from: com.tencent.mm.plugin.patmsg.ui.b$b  reason: collision with other inner class name */
    public final class C1569b implements TextWatcher {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C1569b() {
        }

        public final void afterTextChanged(Editable editable) {
            String str;
            AppMethodBeat.i(207017);
            EditText editText = b.this.ARI;
            if (editText != null) {
                editText.removeTextChangedListener(b.this.ARJ);
            }
            int a2 = com.tencent.mm.ui.tools.f.a(String.valueOf(editable), f.a.MODE_CHINESE_AS_2);
            Log.i(b.this.TAG, "afterTextChanged inputCount:".concat(String.valueOf(a2)));
            String valueOf = String.valueOf(editable);
            if (a2 > b.this.ARG) {
                str = com.tencent.mm.ui.tools.f.hm(valueOf, b.this.ARG);
                p.g(str, "InputTextLengthFilter.su… PAT_SUFFIX_LENGTH_LIMIT)");
                TextView textView = b.this.kuu;
                if (textView != null) {
                    textView.setText(b.this.ARL.getString(R.string.fjs, Integer.valueOf(b.this.ARG / 2)));
                }
                TextView textView2 = b.this.kuu;
                if (textView2 != null) {
                    textView2.setTextColor(com.tencent.mm.cb.a.n(b.this.ARL, R.color.a5e));
                }
                TextView textView3 = b.this.kuu;
                if (textView3 != null) {
                    textView3.performHapticFeedback(3, 2);
                }
                if (editable != null) {
                    editable.replace(str.length(), valueOf.length(), "");
                }
                if (b.this.ARK.stopped()) {
                    b.this.ARK.startTimer(3000);
                }
            } else if (a2 < b.this.ARG) {
                b.this.ARK.stopTimer();
                str = String.valueOf(editable);
                TextView textView4 = b.this.kuu;
                if (textView4 != null) {
                    textView4.setText(b.this.ARL.getString(R.string.fjt));
                }
                TextView textView5 = b.this.kuu;
                if (textView5 != null) {
                    textView5.setTextColor(com.tencent.mm.cb.a.n(b.this.ARL, R.color.l4));
                }
            } else {
                str = valueOf;
            }
            EditText editText2 = b.this.ARI;
            if (editText2 != null) {
                editText2.addTextChangedListener(b.this.ARJ);
            }
            View findViewById = b.this.findViewById(R.id.g3k);
            if (findViewById != null) {
                findViewById.setEnabled(!p.j(str, b.this.ARH));
                AppMethodBeat.o(207017);
                return;
            }
            AppMethodBeat.o(207017);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(207027);
        if (z) {
            View findViewById = findViewById(R.id.dym);
            if (findViewById != null) {
                findViewById.setPadding(0, 0, 0, i2);
                AppMethodBeat.o(207027);
                return;
            }
            AppMethodBeat.o(207027);
            return;
        }
        View findViewById2 = findViewById(R.id.dym);
        if (findViewById2 != null) {
            findViewById2.setPadding(0, 0, 0, 0);
            AppMethodBeat.o(207027);
            return;
        }
        AppMethodBeat.o(207027);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.h.a
    public final void a(int i2, cxl cxl, k.b bVar) {
        String str;
        com.tencent.mm.bw.a aVar;
        String str2 = null;
        AppMethodBeat.i(207029);
        String str3 = this.TAG;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = cxl != null ? cxl.iAc : null;
        if (cxl != null) {
            str = cxl.Title;
        } else {
            str = null;
        }
        objArr[2] = str;
        Log.i(str3, "ret:%d, content:%s, title:%s", objArr);
        q qVar = this.tipDialog;
        if (qVar != null) {
            qVar.dismiss();
        }
        try {
            ha haVar = new ha();
            haVar.uP(String.valueOf(cl.aWA()));
            haVar.lo(2);
            haVar.agT();
            if (i2 == 0) {
                com.tencent.mm.ui.base.h.cA(this.ARL, this.ARL.getString(R.string.wo));
                if (bVar != null) {
                    aVar = bVar.eiR();
                } else {
                    aVar = null;
                }
                if (aVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ModPatSuffixOplog");
                    AppMethodBeat.o(207029);
                    throw tVar;
                }
                cqa cqa = (cqa) aVar;
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                Object i3 = aAh.azQ().i(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC);
                if (i3 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(207029);
                    throw tVar2;
                }
                if (!p.j(Util.nullAsNil((String) i3), cqa.MvT)) {
                    com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(ar.a.USERINFO_PAT_SUFFIX_VERSION_INT_SYNC, (Object) 2);
                }
                com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh3, "MMKernel.storage()");
                aAh3.azQ().set(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, cqa.MvT);
                com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh4, "MMKernel.storage()");
                aAh4.azQ().set(ar.a.USERINFO_PAT_SUFFIX_MODIFY_TIP_TIMESTAMP_LONG, Long.valueOf(cl.aWA()));
                com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh5, "MMKernel.storage()");
                aAh5.azQ().set(ar.a.USERINFO_PAT_SUFFIX_MODIFY_TIP_COUNT_INT, (Object) 0);
                haVar.lp(0);
                dismiss();
            } else {
                if (!Util.isNullOrNil(cxl != null ? cxl.iAc : null)) {
                    Context context = this.ARL;
                    if (cxl != null) {
                        str2 = cxl.iAc;
                    }
                    com.tencent.mm.ui.base.h.X(context, str2, this.ARL.getString(R.string.wn));
                } else {
                    com.tencent.mm.ui.base.h.n(this.ARL, R.string.u5, R.string.wn);
                }
                haVar.lp(i2);
            }
            haVar.bfK();
            com.tencent.mm.util.b bVar2 = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(haVar);
            AppMethodBeat.o(207029);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            AppMethodBeat.o(207029);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class c implements MTimerHandler.CallBack {
        final /* synthetic */ b ARO;

        c(b bVar) {
            this.ARO = bVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(207018);
            Log.i(this.ARO.TAG, "errorTimeHandler callback");
            TextView textView = (TextView) this.ARO.findViewById(R.id.g92);
            if (textView != null) {
                textView.setText(this.ARO.ARL.getString(R.string.fjt));
            }
            if (textView != null) {
                textView.setTextColor(com.tencent.mm.cb.a.n(this.ARO.ARL, R.color.l4));
            }
            AppMethodBeat.o(207018);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$Companion;", "", "()V", "patSettingDialog", "Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;", "getPatSettingDialog", "()Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;", "setPatSettingDialog", "(Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;)V", "plugin-patmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void dismiss() {
        IBinder iBinder;
        AppMethodBeat.i(207028);
        Object systemService = this.ARL.getSystemService("input_method");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            AppMethodBeat.o(207028);
            throw tVar;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        EditText editText = this.ARI;
        if (editText != null) {
            iBinder = editText.getWindowToken();
        } else {
            iBinder = null;
        }
        inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        super.dismiss();
        AppMethodBeat.o(207028);
    }

    public static final /* synthetic */ void a(b bVar, CharSequence charSequence) {
        boolean z;
        AppMethodBeat.i(207032);
        cqa cqa = new cqa();
        String escapeStringForUCC = Util.escapeStringForUCC(charSequence.toString());
        p.g(escapeStringForUCC, "Util.escapeStringForUCC(suffix.toString())");
        String str = escapeStringForUCC;
        int length = str.length() - 1;
        boolean z2 = false;
        int i2 = 0;
        while (i2 <= length) {
            if (str.charAt(!z2 ? i2 : length) <= ' ') {
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
        cqa.MvT = str.subSequence(i2, length + 1).toString();
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eis().b(new k.a(TbsListener.ErrorCode.UNLZMA_FAIURE, cqa));
        bVar.tipDialog = com.tencent.mm.ui.base.h.a(bVar.ARL, bVar.ARL.getString(R.string.f30), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(207032);
    }
}
