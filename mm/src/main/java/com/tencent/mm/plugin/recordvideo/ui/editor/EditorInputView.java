package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.FontSelectorView;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.WebView;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0014\u0018\u0000 |2\u00020\u00012\u00020\u0002:\u0003z{|B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010[\u001a\u00020V2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010\\\u001a\u00020V2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0006\u0010\u001d\u001a\u00020VJ\u0016\u0010]\u001a\u00020V2\u0006\u0010^\u001a\u00020Z2\u0006\u0010_\u001a\u00020ZJ\u0016\u0010`\u001a\u00020V2\u0006\u0010a\u001a\u00020Z2\u0006\u0010b\u001a\u00020ZJ\u0010\u0010c\u001a\u00020'2\u0006\u0010d\u001a\u00020\nH\u0016J\b\u0010e\u001a\u00020'H\u0016J\b\u0010f\u001a\u00020VH\u0002J\"\u0010g\u001a\u00020V2\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010J\u001a\u00020\n2\u0006\u0010j\u001a\u00020\nH\u0002J\u000e\u0010k\u001a\u00020V2\u0006\u0010l\u001a\u00020\nJ\u0010\u0010m\u001a\u00020V2\u0006\u0010U\u001a\u00020'H\u0002J-\u0010n\u001a\u00020V2#\u0010o\u001a\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\bS\u0012\b\bT\u0012\u0004\b\b(U\u0012\u0004\u0012\u00020V\u0018\u00010RH\u0016J\u0010\u0010p\u001a\u00020V2\u0006\u0010q\u001a\u00020'H\u0016J\u0010\u0010r\u001a\u00020V2\b\u0010s\u001a\u0004\u0018\u00010\u000fJ \u0010t\u001a\u00020V2\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010J\u001a\u00020\n2\u0006\u0010j\u001a\u00020\nJ\"\u0010u\u001a\u00020V2\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010J\u001a\u00020\n2\u0006\u0010j\u001a\u00020\nH\u0002J\"\u0010v\u001a\u00020V2\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010J\u001a\u00020\n2\u0006\u0010j\u001a\u00020\nH\u0002J\u000e\u0010w\u001a\u00020V2\u0006\u0010q\u001a\u00020'J\u000e\u0010x\u001a\u00020V2\u0006\u00108\u001a\u00020\nJ\b\u0010y\u001a\u00020VH\u0002R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010)\"\u0004\b0\u0010+R\u000e\u00101\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\"\u0004\bA\u0010<R\u000e\u0010B\u001a\u00020CX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR+\u0010Q\u001a\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\bS\u0012\b\bT\u0012\u0004\b\b(U\u0012\u0004\u0012\u00020V\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "IMPUT_LINES_LIMIT", "INPUT_LIMIT", "TAG", "", "addTipGroup", "Landroid/view/View;", "addTipInput", "Landroid/widget/EditText;", "addTipOverSizeIndicator", "Lcom/tencent/mm/ui/widget/MMTextView;", "animatorColorPanel", "Landroid/view/ViewPropertyAnimator;", "animatorInputPanel", "animatorInputTipPanel", "bgColor", "bgToggle", "Landroid/widget/ImageView;", "cancel", "colorSelector", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "colorSelectorGroup", "confirm", "getConfirm", "()Landroid/view/View;", "setConfirm", "(Landroid/view/View;)V", "enableClickOutsideConfirm", "", "getEnableClickOutsideConfirm", "()Z", "setEnableClickOutsideConfirm", "(Z)V", "fontSelector", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView;", "hasBackground", "getHasBackground", "setHasBackground", "headerPanel", "input", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoEditText;", "inputRoot", "Landroid/view/ViewGroup;", "isCancelShowImg", "lastBottom", "mode", "getMode", "()I", "setMode", "(I)V", "realDisplayHeight", "selectedFont", "value", "selectedIndex", "setSelectedIndex", "showImeRunnable", "Ljava/lang/Runnable;", "textCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$AddTextCallback;", "getTextCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$AddTextCallback;", "setTextCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$AddTextCallback;)V", "textColor", "tipCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$AddTipCallback;", "getTipCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$AddTipCallback;", "setTipCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$AddTipCallback;)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "waitKeyBoardShown", "animationWithColorPanel", "toTransY", "", "animationWithInputPanel", "animationWithTipPanel", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "isShow", "resetTranslation", "setCaptionMode", "text", "", "textBgColor", "setConfirmBtnBg", "id", "setImeVisibility", "setOnVisibleChangeCallback", "callback", "setShow", "show", "setTypeFace", "typeface", "setup", "setupTextMode", "setupTipMode", "showFontSelect", "switchMode", "updateInput", "AddTextCallback", "AddTipCallback", "Companion", "plugin-recordvideo_release"})
public final class EditorInputView extends InsectRelativeLayout {
    private static final int CcZ = -1;
    private static final int Cda = Cda;
    private static final int[] Cdb;
    private static final int Cdc;
    private static final int Cdd = (Cdb[0] & Cda);
    private static final int Cde = -1;
    private static final int Cdf = 0;
    public static final c Cdg = new c((byte) 0);
    private final int CcH;
    private final int CcI;
    private PhotoEditText CcJ;
    private ViewGroup CcK;
    private View CcL;
    private final ImageView CcM;
    private final FontSelectorView CcN;
    private final View CcO;
    private final View CcP;
    private final EditText CcQ;
    private final MMTextView CcR;
    private int CcS;
    private String CcT;
    private a CcU;
    private b CcV;
    private boolean CcW;
    private boolean CcX;
    private boolean CcY;
    private kotlin.g.a.b<? super Boolean, x> Ccp;
    private final String TAG;
    private int bgColor;
    private int bxP;
    public int mode;
    private final TextColorSelector ruB;
    private int ruG;
    private boolean ruH;
    private final Runnable ruJ;
    private View ruy;
    private View ruz;
    private int textColor;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J*\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$AddTextCallback;", "", "onCancel", "", "onConfirm", "text", "", "color", "", "bgColor", "font", "", "plugin-recordvideo_release"})
    public interface a {
        void b(CharSequence charSequence, int i2, int i3, String str);

        void onCancel();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J*\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$AddTipCallback;", "", "onCancel", "", "onConfirm", "text", "", "color", "", "bgColor", "font", "", "plugin-recordvideo_release"})
    public interface b {
        void d(CharSequence charSequence, String str);

        void onCancel();
    }

    public static final /* synthetic */ void a(EditorInputView editorInputView, int i2) {
        AppMethodBeat.i(76009);
        editorInputView.setSelectedIndex(i2);
        AppMethodBeat.o(76009);
    }

    public static final /* synthetic */ void a(EditorInputView editorInputView, boolean z) {
        AppMethodBeat.i(76007);
        editorInputView.setImeVisibility(z);
        AppMethodBeat.o(76007);
    }

    public static final /* synthetic */ void j(EditorInputView editorInputView) {
        AppMethodBeat.i(76008);
        editorInputView.eMb();
        AppMethodBeat.o(76008);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View findViewById;
        p.h(context, "context");
        AppMethodBeat.i(76004);
        this.TAG = "MicroMsg.EditorInputView";
        this.CcH = 108;
        this.CcI = 7;
        this.CcT = "";
        this.CcX = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.InputViewIconStyle);
        this.CcY = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        this.CcS = au.az(context).y;
        View.inflate(context, R.layout.a0w, this);
        setBackgroundColor(getResources().getColor(R.color.aa5));
        View findViewById2 = findViewById(R.id.ar1);
        p.g(findViewById2, "findViewById(R.id.change_text_input)");
        this.CcJ = (PhotoEditText) findViewById2;
        View findViewById3 = findViewById(R.id.ia5);
        p.g(findViewById3, "findViewById(R.id.story_editor_input_root)");
        this.CcK = (ViewGroup) findViewById3;
        View findViewById4 = findViewById(R.id.ia4);
        p.g(findViewById4, "findViewById(R.id.story_editor_input_header)");
        this.CcL = findViewById4;
        if (this.CcY) {
            findViewById = findViewById(R.id.aqz);
            p.g(findViewById, "findViewById(R.id.change_text_cancel_iv)");
        } else {
            findViewById = findViewById(R.id.aqy);
            p.g(findViewById, "findViewById(R.id.change_text_cancel)");
        }
        this.ruy = findViewById;
        View view = this.ruy;
        if (this.CcY) {
            view.setBackground(ar.m(context, R.raw.icons_filled_close2, -1));
        }
        this.ruy.setVisibility(0);
        View findViewById5 = findViewById(R.id.ar0);
        p.g(findViewById5, "findViewById(R.id.change_text_confirm)");
        this.ruz = findViewById5;
        if (ao.aQ(context)) {
            this.CcL.setPadding(this.CcL.getPaddingLeft(), ao.aP(context) + at.aH(context, R.dimen.c5), this.CcL.getPaddingRight(), this.CcL.getPaddingBottom());
        }
        View findViewById6 = findViewById(R.id.ia1);
        p.g(findViewById6, "findViewById(R.id.story_editor_input_bg_toggle)");
        this.CcM = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.ia3);
        p.g(findViewById7, "findViewById(R.id.story_…tor_input_color_selector)");
        this.ruB = (TextColorSelector) findViewById7;
        View findViewById8 = findViewById(R.id.ia2);
        p.g(findViewById8, "findViewById(R.id.story_editor_input_color)");
        this.CcO = findViewById8;
        View findViewById9 = findViewById(R.id.ia9);
        p.g(findViewById9, "findViewById(R.id.story_editor_tip_input_root)");
        this.CcP = findViewById9;
        View findViewById10 = findViewById(R.id.ioo);
        p.g(findViewById10, "findViewById(R.id.tip_text_input)");
        this.CcQ = (EditText) findViewById10;
        View findViewById11 = findViewById(R.id.iom);
        p.g(findViewById11, "findViewById(R.id.tip_over_size_indicator)");
        this.CcR = (MMTextView) findViewById11;
        View findViewById12 = findViewById(R.id.d8a);
        p.g(findViewById12, "findViewById(R.id.font_selector_view)");
        this.CcN = (FontSelectorView) findViewById12;
        this.CcJ.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.AnonymousClass2 */
            final /* synthetic */ EditorInputView Cdh;

            {
                this.Cdh = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(75985);
                EditorInputView.a(this.Cdh, z);
                AppMethodBeat.o(75985);
            }
        });
        this.CcP.setTranslationY(-((float) this.CcS));
        this.CcQ.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.AnonymousClass3 */
            final /* synthetic */ EditorInputView Cdh;

            {
                this.Cdh = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(237712);
                EditorInputView.a(this.Cdh, z);
                AppMethodBeat.o(237712);
            }
        });
        this.CcQ.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.AnonymousClass4 */
            final /* synthetic */ EditorInputView Cdh;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.Cdh = r1;
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(237713);
                if (editable != null) {
                    int length = this.Cdh.CcH - editable.length();
                    this.Cdh.getConfirm().setEnabled(length >= 0 && this.Cdh.CcQ.getLineCount() <= this.Cdh.CcI);
                    if (length < 0) {
                        this.Cdh.CcR.setVisibility(0);
                        this.Cdh.CcR.setText(String.valueOf(length));
                        AppMethodBeat.o(237713);
                        return;
                    }
                    this.Cdh.CcR.setVisibility(8);
                    AppMethodBeat.o(237713);
                    return;
                }
                this.Cdh.CcR.setVisibility(8);
                AppMethodBeat.o(237713);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.ruy.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.AnonymousClass5 */
            final /* synthetic */ EditorInputView Cdh;

            {
                this.Cdh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(75988);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Cdh.cancel();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75988);
            }
        });
        this.ruz.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.AnonymousClass6 */
            final /* synthetic */ EditorInputView Cdh;

            {
                this.Cdh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(75989);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.Cdh.getMode() == 0 || this.Cdh.getMode() == 2) {
                    Editable text = this.Cdh.CcJ.getText();
                    a textCallback = this.Cdh.getTextCallback();
                    if (textCallback != null) {
                        textCallback.b(text, this.Cdh.textColor, this.Cdh.bgColor, this.Cdh.CcT);
                    }
                    this.Cdh.CcJ.clearFocus();
                } else if (this.Cdh.getMode() == 1) {
                    Editable text2 = this.Cdh.CcQ.getText();
                    b tipCallback = this.Cdh.getTipCallback();
                    if (tipCallback != null) {
                        tipCallback.d(text2, this.Cdh.CcT);
                    }
                    this.Cdh.CcQ.clearFocus();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75989);
            }
        });
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.AnonymousClass7 */
            final /* synthetic */ EditorInputView Cdh;

            {
                this.Cdh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(75990);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!this.Cdh.getConfirm().isEnabled() || !this.Cdh.getEnableClickOutsideConfirm()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(75990);
                    return;
                }
                if (this.Cdh.getMode() == 0 || this.Cdh.getMode() == 2) {
                    Editable text = this.Cdh.CcJ.getText();
                    a textCallback = this.Cdh.getTextCallback();
                    if (textCallback != null) {
                        textCallback.b(text, this.Cdh.textColor, this.Cdh.bgColor, this.Cdh.CcT);
                    }
                    this.Cdh.CcJ.clearFocus();
                } else if (this.Cdh.getMode() == 1) {
                    Editable text2 = this.Cdh.CcQ.getText();
                    b tipCallback = this.Cdh.getTipCallback();
                    if (tipCallback != null) {
                        tipCallback.d(text2, this.Cdh.CcT);
                    }
                    this.Cdh.CcQ.clearFocus();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75990);
            }
        });
        this.CcM.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.AnonymousClass8 */
            final /* synthetic */ EditorInputView Cdh;

            {
                this.Cdh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237714);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Cdh.CcM.setActivated(!this.Cdh.CcM.isActivated());
                this.Cdh.setHasBackground(this.Cdh.CcM.isActivated());
                EditorInputView.j(this.Cdh);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237714);
            }
        });
        this.ruB.setColorSelectedCallback(new kotlin.g.a.b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.AnonymousClass9 */
            final /* synthetic */ EditorInputView Cdh;

            {
                this.Cdh = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(237715);
                EditorInputView.a(this.Cdh, num.intValue());
                EditorInputView.j(this.Cdh);
                x xVar = x.SXb;
                AppMethodBeat.o(237715);
                return xVar;
            }
        });
        this.ruB.setColorList(Cdb);
        this.ruB.setSelected(0);
        this.CcJ.setTypeface(this.CcJ.getTypeface(), 1);
        this.CcN.setFontSelectCallback(new kotlin.g.a.b<String, x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.AnonymousClass1 */
            final /* synthetic */ EditorInputView Cdh;

            {
                this.Cdh = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(String str) {
                AppMethodBeat.i(237711);
                String str2 = str;
                p.h(str2, LocaleUtil.ITALIAN);
                this.Cdh.CcT = str2;
                if (!(str2.length() > 0)) {
                    this.Cdh.CcJ.setTypeface(Typeface.DEFAULT_BOLD);
                } else if (s.YS(str2)) {
                    this.Cdh.CcJ.setTypeface(Typeface.createFromFile(str2));
                } else {
                    this.Cdh.CcJ.setTypeface(Typeface.DEFAULT);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(237711);
                return xVar;
            }
        });
        this.ruJ = new d(this);
        AppMethodBeat.o(76004);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditorInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(76005);
        AppMethodBeat.o(76005);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView$Companion;", "", "()V", "AlphaBg", "", "getAlphaBg", "()I", "AlphaText", "getAlphaText", "ColorArray", "", "getColorArray", "()[I", "DefaultBgColor", "getDefaultBgColor", "DefaultTextColor", "getDefaultTextColor", "DefaultTipBgColor", "getDefaultTipBgColor", "DefaultTipColor", "getDefaultTipColor", "MODE_CAPTION", "MODE_TEXT", "MODE_TIP", "plugin-recordvideo_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(76006);
        int[] iArr = {-1, WebView.NIGHT_MODE_COLOR, -372399, -15616, -16268960, -15683841, -10197008};
        Cdb = iArr;
        Cdc = iArr[0];
        AppMethodBeat.o(76006);
    }

    public final View getConfirm() {
        return this.ruz;
    }

    public final void setConfirm(View view) {
        AppMethodBeat.i(75993);
        p.h(view, "<set-?>");
        this.ruz = view;
        AppMethodBeat.o(75993);
    }

    private final void setSelectedIndex(int i2) {
        this.bxP = i2;
        if (this.bxP < 0) {
            this.bxP = 0;
        }
    }

    public final int getMode() {
        return this.mode;
    }

    public final void setMode(int i2) {
        this.mode = i2;
    }

    public final a getTextCallback() {
        return this.CcU;
    }

    public final void setTextCallback(a aVar) {
        this.CcU = aVar;
    }

    public final b getTipCallback() {
        return this.CcV;
    }

    public final void setTipCallback(b bVar) {
        this.CcV = bVar;
    }

    public final boolean getHasBackground() {
        return this.CcW;
    }

    public final void setHasBackground(boolean z) {
        this.CcW = z;
    }

    public final boolean getEnableClickOutsideConfirm() {
        return this.CcX;
    }

    public final void setEnableClickOutsideConfirm(boolean z) {
        this.CcX = z;
    }

    public final void setTypeFace(String str) {
        AppMethodBeat.i(237716);
        this.CcN.setSelectFont(str);
        if (!TextUtils.isEmpty(str)) {
            if (str == null) {
                p.hyc();
            }
            this.CcT = str;
            if (s.YS(str)) {
                this.CcJ.setTypeface(Typeface.createFromFile(this.CcT));
                AppMethodBeat.o(237716);
                return;
            }
            this.CcJ.setTypeface(Typeface.DEFAULT);
        }
        AppMethodBeat.o(237716);
    }

    public final void g(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(75994);
        switch (this.mode) {
            case 0:
            case 2:
                h(charSequence, i2, i3);
                AppMethodBeat.o(75994);
                return;
            case 1:
                j(charSequence, i2);
                break;
        }
        AppMethodBeat.o(75994);
    }

    public final void cancel() {
        AppMethodBeat.i(237717);
        a aVar = this.CcU;
        if (aVar != null) {
            aVar.onCancel();
        }
        b bVar = this.CcV;
        if (bVar != null) {
            bVar.onCancel();
        }
        this.CcJ.clearFocus();
        this.CcQ.clearFocus();
        AppMethodBeat.o(237717);
    }

    public final void bL(float f2) {
        AppMethodBeat.i(75995);
        this.CcK.setPadding((int) f2, 0, (int) f2, 0);
        AppMethodBeat.o(75995);
    }

    private final void j(CharSequence charSequence, int i2) {
        AppMethodBeat.i(75996);
        this.CcQ.setText(charSequence);
        if (charSequence != null) {
            this.CcQ.setSelection(charSequence.length());
        }
        this.CcQ.setTextColor(i2);
        this.CcQ.postInvalidate();
        AppMethodBeat.o(75996);
    }

    private final void h(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(75997);
        this.CcJ.setText(charSequence);
        if (charSequence != null) {
            this.CcJ.setSelection(charSequence.length());
        }
        this.CcW = i3 != 0;
        if (this.CcW) {
            i2 = i3 | (Cda ^ -1);
        }
        setSelectedIndex(e.n(Cdb, i2));
        this.ruB.setSelected(this.bxP);
        this.CcM.setActivated(this.CcW);
        eMb();
        AppMethodBeat.o(75997);
    }

    private final void eMb() {
        int i2;
        AppMethodBeat.i(75998);
        if (this.CcW) {
            this.bgColor = Cdb[this.bxP] & Cda;
            switch (this.bxP) {
                case 0:
                    i2 = Cdb[1];
                    break;
                default:
                    i2 = Cdb[0];
                    break;
            }
            this.textColor = i2;
        } else {
            this.textColor = Cdb[this.bxP] & CcZ;
            this.bgColor = 0;
        }
        this.CcJ.setTextColor(this.textColor);
        this.CcJ.setTextBackground(this.bgColor);
        this.CcJ.postInvalidate();
        AppMethodBeat.o(75998);
    }

    public final boolean bJw() {
        AppMethodBeat.i(75999);
        if (getVisibility() == 0) {
            AppMethodBeat.o(75999);
            return true;
        }
        AppMethodBeat.o(75999);
        return false;
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(76000);
        if (z) {
            kotlin.g.a.b<? super Boolean, x> bVar = this.Ccp;
            if (bVar != null) {
                bVar.invoke(Boolean.TRUE);
            }
            switch (this.mode) {
                case 0:
                case 2:
                    setPadding(0, 0, 0, this.ruG);
                    this.CcP.setVisibility(8);
                    this.CcO.setVisibility(0);
                    this.CcK.setVisibility(0);
                    break;
                case 1:
                    this.CcK.setVisibility(8);
                    this.CcO.setVisibility(8);
                    this.CcP.setVisibility(0);
                    break;
            }
            setVisibility(0);
            if (this.mode == 0 || this.mode == 2) {
                this.CcJ.requestFocus();
                AppMethodBeat.o(76000);
                return;
            }
            if (this.mode == 1) {
                this.CcQ.requestFocus();
            }
            AppMethodBeat.o(76000);
            return;
        }
        this.ruH = true;
        setVisibility(8);
        this.CcP.setVisibility(8);
        this.CcO.setVisibility(8);
        this.CcK.setVisibility(8);
        this.CcP.setTranslationY(-((float) this.CcS));
        kotlin.g.a.b<? super Boolean, x> bVar2 = this.Ccp;
        if (bVar2 != null) {
            bVar2.invoke(Boolean.FALSE);
            AppMethodBeat.o(76000);
            return;
        }
        AppMethodBeat.o(76000);
    }

    public final void setOnVisibleChangeCallback(kotlin.g.a.b<? super Boolean, x> bVar) {
        this.Ccp = bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ EditorInputView Cdh;

        d(EditorInputView editorInputView) {
            this.Cdh = editorInputView;
        }

        public final void run() {
            AppMethodBeat.i(75992);
            InputMethodManager inputMethodManager = (InputMethodManager) this.Cdh.getContext().getSystemService("input_method");
            if (this.Cdh.getMode() == 0 || this.Cdh.getMode() == 2) {
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.Cdh.CcJ, 0);
                    AppMethodBeat.o(75992);
                    return;
                }
                AppMethodBeat.o(75992);
            } else if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.Cdh.CcQ, 0);
                AppMethodBeat.o(75992);
            } else {
                AppMethodBeat.o(75992);
            }
        }
    }

    private final void setImeVisibility(boolean z) {
        AppMethodBeat.i(76001);
        if (z) {
            post(this.ruJ);
            AppMethodBeat.o(76001);
            return;
        }
        removeCallbacks(this.ruJ);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(76001);
            return;
        }
        AppMethodBeat.o(76001);
    }

    @Override // com.tencent.mm.ui.widget.InsectRelativeLayout
    public final boolean Gv(int i2) {
        boolean z = true;
        AppMethodBeat.i(76002);
        if (this.mode == 0 || this.mode == 2) {
            this.ruG = i2;
            boolean z2 = i2 > au.aD(getContext());
            if (!this.ruH) {
                z = false;
            } else if (z2) {
                this.ruH = false;
                z = false;
            }
        } else {
            this.CcP.setTranslationY((float) ((this.CcS - i2) - this.CcP.getMeasuredHeight()));
            this.CcP.setVisibility(0);
        }
        AppMethodBeat.o(76002);
        return z;
    }

    public final void setConfirmBtnBg(int i2) {
        AppMethodBeat.i(163468);
        View view = this.ruz;
        Context context = getContext();
        p.g(context, "context");
        view.setBackground(context.getResources().getDrawable(i2));
        AppMethodBeat.o(163468);
    }
}
