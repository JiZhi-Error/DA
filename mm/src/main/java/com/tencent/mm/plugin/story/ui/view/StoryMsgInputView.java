package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0011\u0018\u0000 G2\u00020\u0001:\u0001GB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u00105\u001a\u00020\u0015J\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u00020\u0015J\b\u00109\u001a\u00020\u0015H\u0002J\b\u0010:\u001a\u00020\u0015H\u0002J\u0006\u0010;\u001a\u00020\u000eJ\u0018\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\tH\u0016J\b\u0010>\u001a\u00020\u0015H\u0002J\"\u0010?\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u0001072\b\b\u0002\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u000eJ\u0010\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u000eH\u0002J\u0016\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u000eR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000RL\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canSend", "", "commentInputCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "content", "success", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function2;)V", "emojiBtn", "Landroid/widget/ImageView;", "emojiRoot", "Landroid/widget/FrameLayout;", "hintTv", "Landroid/widget/TextView;", "inputContentGroup", "Landroid/view/View;", "inputLimit", "inputRootView", "inputType", "getInputType", "()I", "setInputType", "(I)V", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideInputPanel", "hideSoftInput", "initSmileyPanel", "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "setInputHint", "toUser", "isReply", "setKeyboardVisibility", "visible", "setVisibility", "visibility", "needRequest", "Companion", "plugin-story_release"})
public final class StoryMsgInputView extends InputPanelFrameLayout {
    public static final a FDo = new a((byte) 0);
    private final FrameLayout FBO;
    private final MMEditText FBP;
    private final ImageView FBQ;
    private final TextView FBR;
    private final View FBT;
    private final View FBU;
    private boolean FBV;
    private final int FBW;
    private final int FBX;
    private m<? super String, ? super Boolean, x> FBY;
    private final String TAG;
    private boolean gYo;
    private int inputType;
    private final TextView kuu;
    private int oXi;
    private final Runnable ruJ;
    private final ChatFooterPanel rum;

    static {
        AppMethodBeat.i(120226);
        AppMethodBeat.o(120226);
    }

    public static final /* synthetic */ void b(StoryMsgInputView storyMsgInputView, boolean z) {
        AppMethodBeat.i(120228);
        storyMsgInputView.setKeyboardVisibility(z);
        AppMethodBeat.o(120228);
    }

    public static final /* synthetic */ void c(StoryMsgInputView storyMsgInputView) {
        AppMethodBeat.i(120227);
        storyMsgInputView.fsf();
        AppMethodBeat.o(120227);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryMsgInputView(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120224);
        this.TAG = "MicroMsg.StoryCommentInputView";
        this.inputType = -1;
        View.inflate(context, R.layout.c0n, this);
        setClickable(true);
        View findViewById = findViewById(R.id.i88);
        p.g(findViewById, "findViewById(R.id.story_comment_emoji_root)");
        this.FBO = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.i8a);
        p.g(findViewById2, "findViewById(R.id.story_comment_input)");
        this.FBP = (MMEditText) findViewById2;
        this.FBP.setEnableSendBtn(true);
        View findViewById3 = findViewById(R.id.i87);
        p.g(findViewById3, "findViewById(R.id.story_comment_emoji_btn)");
        this.FBQ = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.i8f);
        p.g(findViewById4, "findViewById(R.id.story_comment_input_limit)");
        this.FBR = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.i8e);
        p.g(findViewById5, "findViewById(R.id.story_comment_input_hint)");
        this.kuu = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.i8h);
        p.g(findViewById6, "findViewById(R.id.story_comment_input_root)");
        this.FBT = findViewById6;
        View findViewById7 = findViewById(R.id.i8d);
        p.g(findViewById7, "findViewById(R.id.story_…ent_input_footer_content)");
        this.FBU = findViewById7;
        this.FBW = getResources().getColor(R.color.aam);
        this.FBX = getResources().getColor(R.color.Red);
        SmileyPanel l = ad.l(context, true);
        p.g(l, "SmileyPanelFactory.getSmileyPanel(context, true)");
        this.rum = l;
        this.oXi = KeyBoardUtil.getValidPanelHeight(getContext());
        this.FBO.addView(this.rum, new FrameLayout.LayoutParams(-1, this.oXi));
        this.rum.setPortHeightPx(this.oXi);
        this.rum.setEntranceScene(ChatFooterPanel.BKN);
        this.rum.goD();
        this.rum.setVisibility(0);
        this.rum.setShowSend(true);
        this.rum.onResume();
        this.rum.setOnTextOperationListener(new b(this));
        this.FBP.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryMsgInputView.AnonymousClass1 */
            final /* synthetic */ StoryMsgInputView FDp;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.FDp = r1;
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(120208);
                if (editable != null) {
                    int length = editable.length();
                    int i2 = 60 - length;
                    this.FDp.gYo = (editable.length() > 0) && i2 >= 0 && this.FDp.FBP.getLineCount() <= 10;
                    if (length >= 55) {
                        this.FDp.FBR.setVisibility(0);
                        this.FDp.FBR.setText(String.valueOf(i2));
                        if (i2 >= 0) {
                            this.FDp.FBR.setTextColor(this.FDp.FBW);
                            AppMethodBeat.o(120208);
                            return;
                        }
                        this.FDp.FBR.setTextColor(this.FDp.FBX);
                        AppMethodBeat.o(120208);
                        return;
                    }
                    this.FDp.FBR.setVisibility(8);
                    AppMethodBeat.o(120208);
                    return;
                }
                this.FDp.gYo = false;
                this.FDp.FBR.setVisibility(8);
                AppMethodBeat.o(120208);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.FBT.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryMsgInputView.AnonymousClass2 */
            final /* synthetic */ StoryMsgInputView FDp;

            {
                this.FDp = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120209);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!this.FDp.FBV) {
                    this.FDp.setInputType(2);
                    StoryMsgInputView.b(this.FDp, true);
                    this.FDp.FBQ.setImageDrawable(ar.m(context, R.raw.icons_filled_sticker, -1));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120209);
            }
        });
        this.FBQ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryMsgInputView.AnonymousClass3 */
            final /* synthetic */ StoryMsgInputView FDp;

            {
                this.FDp = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120210);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.FDp.getInputType() == 0) {
                    this.FDp.setInputType(2);
                    StoryMsgInputView.b(this.FDp, true);
                    this.FDp.FBQ.setImageDrawable(ar.m(context, R.raw.icons_filled_sticker, -1));
                } else {
                    if (this.FDp.FBV) {
                        this.FDp.setInputType(0);
                        StoryMsgInputView.b(this.FDp, false);
                    } else {
                        this.FDp.setInputType(0);
                        this.FDp.FBO.setVisibility(0);
                    }
                    this.FDp.FBQ.setImageDrawable(ar.m(context, R.raw.icons_filled_keyboard, -1));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120210);
            }
        });
        this.FBP.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryMsgInputView.AnonymousClass4 */
            final /* synthetic */ StoryMsgInputView FDp;

            {
                this.FDp = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
                if (r7.getAction() == 66) goto L_0x0017;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onEditorAction(android.widget.TextView r5, int r6, android.view.KeyEvent r7) {
                /*
                    r4 = this;
                    r3 = 120211(0x1d593, float:1.68451E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r0 = 4
                    if (r0 == r6) goto L_0x0017
                    java.lang.String r0 = "keyEvent"
                    kotlin.g.b.p.g(r7, r0)
                    int r0 = r7.getAction()
                    r1 = 66
                    if (r0 != r1) goto L_0x0052
                L_0x0017:
                    com.tencent.mm.plugin.story.ui.view.StoryMsgInputView r0 = r4.FDp
                    boolean r0 = com.tencent.mm.plugin.story.ui.view.StoryMsgInputView.b(r0)
                    if (r0 == 0) goto L_0x0052
                    com.tencent.mm.plugin.story.h.h r0 = com.tencent.mm.plugin.story.h.h.FuH
                    r0 = 9
                    com.tencent.mm.plugin.story.h.h.aaT(r0)
                    com.tencent.mm.plugin.story.ui.view.StoryMsgInputView r0 = r4.FDp
                    com.tencent.mm.ui.widget.MMEditText r0 = com.tencent.mm.plugin.story.ui.view.StoryMsgInputView.a(r0)
                    android.text.Editable r0 = r0.getText()
                    if (r0 == 0) goto L_0x0052
                    com.tencent.mm.plugin.story.ui.view.StoryMsgInputView r1 = r4.FDp
                    com.tencent.mm.plugin.story.ui.view.StoryMsgInputView.c(r1)
                    com.tencent.mm.plugin.story.ui.view.StoryMsgInputView r1 = r4.FDp
                    com.tencent.mm.ui.widget.MMEditText r1 = com.tencent.mm.plugin.story.ui.view.StoryMsgInputView.a(r1)
                    r2 = 0
                    r1.setText(r2)
                    com.tencent.mm.plugin.story.ui.view.StoryMsgInputView r1 = r4.FDp
                    kotlin.g.a.m r1 = r1.getCommentInputCallback()
                    if (r1 == 0) goto L_0x0052
                    java.lang.String r0 = r0.toString()
                    java.lang.Boolean r2 = java.lang.Boolean.TRUE
                    r1.invoke(r0, r2)
                L_0x0052:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.StoryMsgInputView.AnonymousClass4.onEditorAction(android.widget.TextView, int, android.view.KeyEvent):boolean");
            }
        });
        this.FBQ.setImageDrawable(ar.m(context, R.raw.icons_filled_sticker, -1));
        this.gYo = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ruJ = new c(this);
        AppMethodBeat.o(120224);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryMsgInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120225);
        AppMethodBeat.o(120225);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView$Companion;", "", "()V", "InputEmoji", "", "InputEmojiLater", "InputKeyboard", "InputKeyboardLater", "InputLimit", "InputNone", "MinShowLimit", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int getInputType() {
        return this.inputType;
    }

    public final void setInputType(int i2) {
        this.inputType = i2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.String, ? super java.lang.Boolean, kotlin.x>, kotlin.g.a.m<java.lang.String, java.lang.Boolean, kotlin.x> */
    public final m<String, Boolean, x> getCommentInputCallback() {
        return this.FBY;
    }

    public final void setCommentInputCallback(m<? super String, ? super Boolean, x> mVar) {
        this.FBY = mVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"})
    public static final class b implements ChatFooterPanel.a {
        final /* synthetic */ StoryMsgInputView FDp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(StoryMsgInputView storyMsgInputView) {
            this.FDp = storyMsgInputView;
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void append(String str) {
            AppMethodBeat.i(120212);
            this.FDp.FBP.bol(str);
            AppMethodBeat.o(120212);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHC() {
            AppMethodBeat.i(120213);
            InputConnection inputConnection = this.FDp.FBP.getInputConnection();
            if (inputConnection != null) {
                inputConnection.sendKeyEvent(new KeyEvent(0, 67));
            }
            InputConnection inputConnection2 = this.FDp.FBP.getInputConnection();
            if (inputConnection2 != null) {
                inputConnection2.sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(120213);
                return;
            }
            AppMethodBeat.o(120213);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void eP(boolean z) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHD() {
            AppMethodBeat.i(120214);
            if (this.FDp.gYo) {
                h hVar = h.FuH;
                h.aaT(9);
                Editable text = this.FDp.FBP.getText();
                if (text != null) {
                    StoryMsgInputView.c(this.FDp);
                    this.FDp.FBP.setText((CharSequence) null);
                    this.FDp.FBO.setVisibility(8);
                    m<String, Boolean, x> commentInputCallback = this.FDp.getCommentInputCallback();
                    if (commentInputCallback != null) {
                        commentInputCallback.invoke(text.toString(), Boolean.TRUE);
                        AppMethodBeat.o(120214);
                        return;
                    }
                    AppMethodBeat.o(120214);
                    return;
                }
            }
            AppMethodBeat.o(120214);
        }
    }

    public static /* synthetic */ void a(StoryMsgInputView storyMsgInputView, CharSequence charSequence) {
        AppMethodBeat.i(120217);
        storyMsgInputView.a(charSequence, "", false);
        AppMethodBeat.o(120217);
    }

    public final void a(CharSequence charSequence, String str, boolean z) {
        String string;
        String arJ;
        AppMethodBeat.i(120216);
        p.h(str, "toUser");
        this.FBP.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), charSequence, this.FBP.getTextSize()));
        if (charSequence != null) {
            this.FBP.setSelection(charSequence.length());
        }
        if (z) {
            p.g(getResources().getString(R.string.hj4), "resources.getString(R.st…story_reply_visible_hint)");
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
            string = getResources().getString(R.string.hj3) + ' ' + ((Object) com.tencent.mm.pluginsdk.ui.span.l.b(this.FBP.getContext(), (Kn == null || (arJ = Kn.arJ()) == null) ? "" : arJ, this.FBP.getTextSize()));
        } else {
            p.g(getResources().getString(R.string.hh1), "resources.getString(R.st…ory_comment_visible_hint)");
            string = getResources().getString(R.string.hh1);
            p.g(string, "resources.getString(R.st…ory_comment_visible_hint)");
        }
        this.FBP.setHint(string);
        AppMethodBeat.o(120216);
    }

    public final CharSequence getContent() {
        AppMethodBeat.i(120218);
        Editable text = this.FBP.getText();
        String obj = text != null ? text.toString() : null;
        AppMethodBeat.o(120218);
        return obj;
    }

    public final void fse() {
        AppMethodBeat.i(120219);
        if (this.inputType == 0) {
            this.FBO.setVisibility(8);
        } else if (this.inputType == 2) {
            fsf();
        }
        this.inputType = -1;
        AppMethodBeat.o(120219);
    }

    public final void setVisibility$2563266(boolean z) {
        AppMethodBeat.i(120220);
        if (z) {
            this.FBP.requestFocus();
            this.inputType = 2;
            this.FBQ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_sticker, -1));
            this.FBO.setVisibility(4);
            setKeyboardVisibility(true);
        }
        setVisibility(0);
        if (!z) {
            clearFocus();
        }
        AppMethodBeat.o(120220);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ StoryMsgInputView FDp;

        c(StoryMsgInputView storyMsgInputView) {
            this.FDp = storyMsgInputView;
        }

        public final void run() {
            AppMethodBeat.i(120215);
            InputMethodManager inputMethodManager = (InputMethodManager) this.FDp.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.FDp.FBP, 0);
                AppMethodBeat.o(120215);
                return;
            }
            AppMethodBeat.o(120215);
        }
    }

    private final void setKeyboardVisibility(boolean z) {
        AppMethodBeat.i(120221);
        if (z) {
            post(this.ruJ);
            AppMethodBeat.o(120221);
            return;
        }
        removeCallbacks(this.ruJ);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(120221);
            return;
        }
        AppMethodBeat.o(120221);
    }

    private final void fsf() {
        AppMethodBeat.i(120222);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(120222);
            return;
        }
        AppMethodBeat.o(120222);
    }

    @Override // com.tencent.mm.ui.widget.InputPanelFrameLayout, com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(120223);
        super.f(z, i2);
        this.FBV = z;
        if (z) {
            this.inputType = 2;
            this.FBO.setVisibility(4);
        } else if (this.inputType == 0) {
            this.FBO.setVisibility(0);
        } else {
            this.FBO.setVisibility(8);
            this.inputType = -1;
        }
        if (!(this.oXi == i2 || i2 == 0)) {
            this.oXi = i2;
            i.C(getContext(), i2);
            int validPanelHeight = KeyBoardUtil.getValidPanelHeight(getContext());
            this.rum.setPortHeightPx(validPanelHeight);
            ViewGroup.LayoutParams layoutParams = this.rum.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = validPanelHeight;
            }
        }
        AppMethodBeat.o(120223);
    }
}
