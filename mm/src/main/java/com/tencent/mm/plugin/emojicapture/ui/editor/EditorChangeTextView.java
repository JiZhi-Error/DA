package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0014\u001a\u000201J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020)H\u0016J\u0010\u00105\u001a\u0002012\u0006\u00106\u001a\u00020)H\u0002J-\u00107\u001a\u0002012#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110)¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(6\u0012\u0004\u0012\u000201\u0018\u000108H\u0016J\u0010\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020)H\u0016J\u0010\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020\nH\u0016J\u0018\u0010?\u001a\u0002012\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\nR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "setCallback", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;)V", "cancel", "Landroid/view/View;", "colorSelector", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "confirm", "deleteIcon", "Landroid/widget/ImageView;", "input", "Landroid/widget/EditText;", "lastBottom", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectedColor", "selectedStrokeColor", "showImeRunnable", "Ljava/lang/Runnable;", "textChanged", "", "getTextChanged", "()Z", "setTextChanged", "(Z)V", "waitKeyBoardShown", "windowVisibleRect", "Landroid/graphics/Rect;", "", "insectBottom", "bottom", "isShow", "setImeVisibility", "visible", "setOnVisibleChangeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setShow", "show", "setVisibility", "visibility", "setup", "text", "", "textColor", "AddTextCallback", "plugin-emojicapture_release"})
public final class EditorChangeTextView extends InsectRelativeLayout {
    private final String TAG;
    EditText ova;
    public EmojiCaptureReporter rqJ;
    private ImageView ruA;
    TextColorSelector ruB;
    int ruC;
    int ruD;
    private final Rect ruE;
    private a ruF;
    private int ruG;
    private boolean ruH;
    boolean ruI;
    private final Runnable ruJ;
    private View ruy;
    private View ruz;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "", "onCancel", "", "onConfirm", "text", "", "color", "", "plugin-emojicapture_release"})
    public interface a {
        void i(CharSequence charSequence, int i2);

        void onCancel();
    }

    public static final /* synthetic */ void a(EditorChangeTextView editorChangeTextView, boolean z) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.b.CTRL_INDEX);
        editorChangeTextView.setImeVisibility(z);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.b.CTRL_INDEX);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorChangeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(733);
        this.TAG = "EditorChangeTextView";
        this.ruE = new Rect();
        View.inflate(context, R.layout.a1c, this);
        View findViewById = findViewById(R.id.ar1);
        p.g(findViewById, "findViewById(R.id.change_text_input)");
        this.ova = (EditText) findViewById;
        View findViewById2 = findViewById(R.id.aqy);
        p.g(findViewById2, "findViewById(R.id.change_text_cancel)");
        this.ruy = findViewById2;
        View findViewById3 = findViewById(R.id.ar0);
        p.g(findViewById3, "findViewById(R.id.change_text_confirm)");
        this.ruz = findViewById3;
        View findViewById4 = findViewById(R.id.ik2);
        p.g(findViewById4, "findViewById(R.id.text_color_selector)");
        this.ruB = (TextColorSelector) findViewById4;
        View findViewById5 = findViewById(R.id.bmk);
        p.g(findViewById5, "findViewById(R.id.delete_text)");
        this.ruA = (ImageView) findViewById5;
        this.ova.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.AnonymousClass1 */
            final /* synthetic */ EditorChangeTextView ruK;

            {
                this.ruK = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(717);
                EditorChangeTextView.a(this.ruK, z);
                AppMethodBeat.o(717);
            }
        });
        this.ova.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.AnonymousClass2 */
            final /* synthetic */ EditorChangeTextView ruK;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.ruK = r1;
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(718);
                if (editable != null) {
                    if (editable.length() > 0) {
                        this.ruK.ruA.setVisibility(0);
                        AppMethodBeat.o(718);
                        return;
                    }
                }
                this.ruK.ruA.setVisibility(8);
                AppMethodBeat.o(718);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(719);
                this.ruK.setTextChanged(true);
                AppMethodBeat.o(719);
            }
        });
        this.ruy.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.AnonymousClass3 */
            final /* synthetic */ EditorChangeTextView ruK;

            {
                this.ruK = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(TAVExporter.VIDEO_EXPORT_WIDTH);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.ruK.cancel();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(TAVExporter.VIDEO_EXPORT_WIDTH);
            }
        });
        this.ruz.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.AnonymousClass4 */
            final /* synthetic */ EditorChangeTextView ruK;

            {
                this.ruK = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(721);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Editable text = this.ruK.ova.getText();
                a callback = this.ruK.getCallback();
                if (callback != null) {
                    callback.i(text, this.ruK.ruC);
                }
                this.ruK.ova.clearFocus();
                if (this.ruK.getTextChanged()) {
                    EmojiCaptureReporter.a(16, this.ruK.getReporter().hdz, 0, 0, 0, 0, 0, 0, this.ruK.getReporter().scene);
                }
                EmojiCaptureReporter.a(15, this.ruK.getReporter().hdz, 0, 0, 0, 0, 0, 0, this.ruK.getReporter().scene);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(721);
            }
        });
        this.ruA.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.AnonymousClass5 */
            final /* synthetic */ EditorChangeTextView ruK;

            {
                this.ruK = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(722);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.ruK.ova.setText("");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(722);
            }
        });
        this.ruB.setColorList(c.cJF());
        this.ruB.setSelected(0);
        this.ruB.setColorSelectedCallback(new kotlin.g.a.b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.AnonymousClass6 */
            final /* synthetic */ EditorChangeTextView ruK;

            {
                this.ruK = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(723);
                int intValue = num.intValue();
                this.ruK.ruC = c.cJF()[intValue];
                this.ruK.ruD = c.cJG()[intValue];
                this.ruK.ova.setTextColor(this.ruK.ruC);
                x xVar = x.SXb;
                AppMethodBeat.o(723);
                return xVar;
            }
        });
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.AnonymousClass7 */
            final /* synthetic */ EditorChangeTextView ruK;

            {
                this.ruK = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(724);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.ruK.ova.requestFocus();
                EditorChangeTextView.a(this.ruK, true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(724);
            }
        });
        setLayerType(1, null);
        this.ruJ = new b(this);
        AppMethodBeat.o(733);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditorChangeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.a.CTRL_INDEX);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.a.CTRL_INDEX);
    }

    public final a getCallback() {
        return this.ruF;
    }

    public final void setCallback(a aVar) {
        this.ruF = aVar;
    }

    public final boolean getTextChanged() {
        return this.ruI;
    }

    public final void setTextChanged(boolean z) {
        this.ruI = z;
    }

    public final EmojiCaptureReporter getReporter() {
        AppMethodBeat.i(726);
        EmojiCaptureReporter emojiCaptureReporter = this.rqJ;
        if (emojiCaptureReporter == null) {
            p.btv("reporter");
        }
        AppMethodBeat.o(726);
        return emojiCaptureReporter;
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        AppMethodBeat.i(727);
        p.h(emojiCaptureReporter, "<set-?>");
        this.rqJ = emojiCaptureReporter;
        AppMethodBeat.o(727);
    }

    public final void cancel() {
        AppMethodBeat.i(728);
        a aVar = this.ruF;
        if (aVar != null) {
            aVar.onCancel();
        }
        this.ova.clearFocus();
        if (this.ruI) {
            EmojiCaptureReporter emojiCaptureReporter = this.rqJ;
            if (emojiCaptureReporter == null) {
                p.btv("reporter");
            }
            long j2 = emojiCaptureReporter.hdz;
            EmojiCaptureReporter emojiCaptureReporter2 = this.rqJ;
            if (emojiCaptureReporter2 == null) {
                p.btv("reporter");
            }
            EmojiCaptureReporter.a(16, j2, 0, 0, 0, 0, 0, 0, emojiCaptureReporter2.scene);
        }
        EmojiCaptureReporter emojiCaptureReporter3 = this.rqJ;
        if (emojiCaptureReporter3 == null) {
            p.btv("reporter");
        }
        long j3 = emojiCaptureReporter3.hdz;
        EmojiCaptureReporter emojiCaptureReporter4 = this.rqJ;
        if (emojiCaptureReporter4 == null) {
            p.btv("reporter");
        }
        EmojiCaptureReporter.a(14, j3, 0, 0, 0, 0, 0, 0, emojiCaptureReporter4.scene);
        AppMethodBeat.o(728);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ EditorChangeTextView ruK;

        b(EditorChangeTextView editorChangeTextView) {
            this.ruK = editorChangeTextView;
        }

        public final void run() {
            AppMethodBeat.i(725);
            InputMethodManager inputMethodManager = (InputMethodManager) this.ruK.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.ruK.ova, 0);
                AppMethodBeat.o(725);
                return;
            }
            AppMethodBeat.o(725);
        }
    }

    private final void setImeVisibility(boolean z) {
        AppMethodBeat.i(729);
        if (z) {
            post(this.ruJ);
            AppMethodBeat.o(729);
            return;
        }
        removeCallbacks(this.ruJ);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(729);
            return;
        }
        AppMethodBeat.o(729);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
        if (z) {
            setVisibility(0);
            setPadding(0, 0, 0, this.ruG);
            AppMethodBeat.o(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
            return;
        }
        this.ruH = true;
        setVisibility(8);
        AppMethodBeat.o(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
    }

    @Override // com.tencent.mm.ui.widget.InsectRelativeLayout
    public final boolean Gv(int i2) {
        AppMethodBeat.i(731);
        this.ruG = i2;
        boolean z = i2 > au.aD(getContext());
        if (!this.ruH) {
            AppMethodBeat.o(731);
            return false;
        } else if (z) {
            this.ruH = false;
            AppMethodBeat.o(731);
            return false;
        } else {
            AppMethodBeat.o(731);
            return true;
        }
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
        super.setVisibility(i2);
        if (i2 == 0) {
            this.ova.requestFocus();
        }
        AppMethodBeat.o(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
    }

    public final void setOnVisibleChangeCallback(kotlin.g.a.b<? super Boolean, x> bVar) {
    }
}
