package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.a.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 W2\u00020\u0001:\u0001WB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010=\u001a\u00020\u0019J\b\u0010>\u001a\u0004\u0018\u00010?J\b\u0010@\u001a\u00020\u0019H\u0002J\b\u0010A\u001a\u00020\u0019H\u0002J\u0006\u0010B\u001a\u00020\u0019J\u000e\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\tJ\u0006\u0010E\u001a\u00020\u0010J\u0018\u0010F\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\u00102\u0006\u00102\u001a\u00020\tH\u0016J\b\u0010H\u001a\u00020\u0019H\u0002J\u000e\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\tJ\u0010\u0010K\u001a\u00020\u00192\b\u0010L\u001a\u0004\u0018\u00010MJ\"\u0010N\u001a\u00020\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010O\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0010J\u0010\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u000e\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020\u0010J\u0014\u0010T\u001a\u00020\u00192\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001f0VR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000RL\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dRL\u0010\u001e\u001a4\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u000e\u0010$\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatar", "Landroid/widget/ImageView;", "canSend", "", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "commentInputCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "content", "success", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function2;)V", "commentReplyCallback", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "isReply", "getCommentReplyCallback", "setCommentReplyCallback", "emojiBtn", "emojiRoot", "Landroid/widget/FrameLayout;", "fromUser", "Landroid/widget/TextView;", "hintTv", "inputContentGroup", "Landroid/view/View;", "inputLimit", "inputRootView", "inputType", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideSoftInput", "initSmileyPanel", "notifyDataChanged", "notifyItemRemoved", FirebaseAnalytics.b.INDEX, "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "scrollToPosition", "position", "setHostStory", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setInputHint", "toUser", "setKeyboardVisibility", "visible", "showCommentsList", "show", "updateComments", "storyComments", "", "Companion", "plugin-story_release"})
public final class StoryCommentInputView extends InputPanelFrameLayout {
    public static final a FCa = new a((byte) 0);
    private final FrameLayout FBO;
    private final MMEditText FBP;
    private final ImageView FBQ;
    private final TextView FBR;
    final e FBS;
    private final View FBT;
    private final View FBU;
    private boolean FBV;
    private final int FBW;
    private final int FBX;
    private m<? super String, ? super Boolean, x> FBY;
    private m<? super com.tencent.mm.plugin.story.f.b.a, ? super Boolean, x> FBZ;
    private final TextView Fxb;
    private final String TAG;
    private boolean gYo;
    private final RecyclerView hak;
    private int inputType;
    private final ImageView keC;
    private final TextView kuu;
    private int oXi;
    private final Runnable ruJ;
    private final ChatFooterPanel rum;

    static {
        AppMethodBeat.i(120129);
        AppMethodBeat.o(120129);
    }

    public static final /* synthetic */ void b(StoryCommentInputView storyCommentInputView, boolean z) {
        AppMethodBeat.i(120131);
        storyCommentInputView.setKeyboardVisibility(z);
        AppMethodBeat.o(120131);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryCommentInputView(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120126);
        this.TAG = "MicroMsg.StoryCommentInputView";
        View.inflate(context, R.layout.bzn, this);
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
        View findViewById4 = findViewById(R.id.i8b);
        p.g(findViewById4, "findViewById(R.id.story_comment_input_avatar)");
        this.keC = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.i8i);
        p.g(findViewById5, "findViewById(R.id.story_comment_input_username)");
        this.Fxb = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.i8f);
        p.g(findViewById6, "findViewById(R.id.story_comment_input_limit)");
        this.FBR = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.i8e);
        p.g(findViewById7, "findViewById(R.id.story_comment_input_hint)");
        this.kuu = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.i8g);
        p.g(findViewById8, "findViewById(R.id.story_comment_input_recycler)");
        this.hak = (RecyclerView) findViewById8;
        View findViewById9 = findViewById(R.id.i8h);
        p.g(findViewById9, "findViewById(R.id.story_comment_input_root)");
        this.FBT = findViewById9;
        View findViewById10 = findViewById(R.id.i8d);
        p.g(findViewById10, "findViewById(R.id.story_…ent_input_footer_content)");
        this.FBU = findViewById10;
        this.FBS = new e();
        this.hak.setLayoutManager(new LinearLayoutManager());
        this.hak.setAdapter(this.FBS);
        this.hak.setVisibility(8);
        this.hak.setFocusable(false);
        this.FBS.FxO = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.AnonymousClass1 */
            final /* synthetic */ StoryCommentInputView FCb;

            {
                this.FCb = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120105);
                StoryCommentInputView.c(this.FCb);
                x xVar = x.SXb;
                AppMethodBeat.o(120105);
                return xVar;
            }
        };
        this.FBS.FxN = new m<com.tencent.mm.plugin.story.f.b.a, Boolean, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.AnonymousClass2 */
            final /* synthetic */ StoryCommentInputView FCb;

            {
                this.FCb = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.story.f.b.a aVar, Boolean bool) {
                AppMethodBeat.i(120106);
                com.tencent.mm.plugin.story.f.b.a aVar2 = aVar;
                boolean booleanValue = bool.booleanValue();
                p.h(aVar2, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
                m<com.tencent.mm.plugin.story.f.b.a, Boolean, x> commentReplyCallback = this.FCb.getCommentReplyCallback();
                if (commentReplyCallback != null) {
                    commentReplyCallback.invoke(aVar2, Boolean.valueOf(booleanValue));
                }
                if (booleanValue) {
                    StoryCommentInputView.b(this.FCb, true);
                    this.FCb.FBU.setVisibility(0);
                    this.FCb.FBQ.setImageDrawable(ar.m(context, R.raw.icons_filled_sticker, -1));
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120106);
                return xVar;
            }
        };
        this.FBW = getResources().getColor(R.color.aam);
        this.FBX = getResources().getColor(R.color.Red);
        ImageView imageView = this.keC;
        j.b bVar = j.Fmy;
        a.b.d(imageView, j.b.fau());
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
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.AnonymousClass3 */
            final /* synthetic */ StoryCommentInputView FCb;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.FCb = r1;
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(120107);
                if (editable != null) {
                    int length = editable.length();
                    int i2 = 60 - length;
                    this.FCb.gYo = (editable.length() > 0) && i2 >= 0 && this.FCb.FBP.getLineCount() <= 10;
                    if (length >= 55) {
                        this.FCb.FBR.setVisibility(0);
                        this.FCb.FBR.setText(String.valueOf(i2));
                        if (i2 >= 0) {
                            this.FCb.FBR.setTextColor(this.FCb.FBW);
                            AppMethodBeat.o(120107);
                            return;
                        }
                        this.FCb.FBR.setTextColor(this.FCb.FBX);
                        AppMethodBeat.o(120107);
                        return;
                    }
                    this.FCb.FBR.setVisibility(8);
                    AppMethodBeat.o(120107);
                    return;
                }
                this.FCb.gYo = false;
                this.FCb.FBR.setVisibility(8);
                AppMethodBeat.o(120107);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.FBT.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.AnonymousClass4 */
            final /* synthetic */ StoryCommentInputView FCb;

            {
                this.FCb = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120108);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!this.FCb.FBV) {
                    this.FCb.inputType = 2;
                    StoryCommentInputView.b(this.FCb, true);
                    this.FCb.FBQ.setImageDrawable(ar.m(context, R.raw.icons_filled_sticker, -1));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120108);
            }
        });
        this.FBQ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.AnonymousClass5 */
            final /* synthetic */ StoryCommentInputView FCb;

            {
                this.FCb = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120109);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.FCb.inputType == 0) {
                    this.FCb.inputType = 2;
                    StoryCommentInputView.b(this.FCb, true);
                    this.FCb.FBQ.setImageDrawable(ar.m(context, R.raw.icons_filled_sticker, -1));
                } else {
                    if (this.FCb.FBV) {
                        this.FCb.inputType = 0;
                        StoryCommentInputView.b(this.FCb, false);
                    } else {
                        this.FCb.inputType = 0;
                        this.FCb.FBO.setVisibility(0);
                    }
                    this.FCb.FBQ.setImageDrawable(ar.m(context, R.raw.icons_filled_keyboard, -1));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120109);
            }
        });
        this.FBP.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.AnonymousClass6 */
            final /* synthetic */ StoryCommentInputView FCb;

            {
                this.FCb = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
                if (r8.getAction() == 66) goto L_0x0017;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onEditorAction(android.widget.TextView r6, int r7, android.view.KeyEvent r8) {
                /*
                    r5 = this;
                    r4 = 120110(0x1d52e, float:1.6831E-40)
                    r3 = 4
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                    if (r3 == r7) goto L_0x0017
                    java.lang.String r0 = "keyEvent"
                    kotlin.g.b.p.g(r8, r0)
                    int r0 = r8.getAction()
                    r1 = 66
                    if (r0 != r1) goto L_0x005b
                L_0x0017:
                    com.tencent.mm.plugin.story.ui.view.StoryCommentInputView r0 = r5.FCb
                    boolean r0 = com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.b(r0)
                    if (r0 == 0) goto L_0x005b
                    com.tencent.mm.plugin.story.h.h r0 = com.tencent.mm.plugin.story.h.h.FuH
                    r0 = 9
                    com.tencent.mm.plugin.story.h.h.aaT(r0)
                    com.tencent.mm.plugin.story.ui.view.StoryCommentInputView r0 = r5.FCb
                    com.tencent.mm.ui.widget.MMEditText r0 = com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.a(r0)
                    android.text.Editable r0 = r0.getText()
                    if (r0 == 0) goto L_0x005b
                    com.tencent.mm.plugin.story.ui.view.StoryCommentInputView r1 = r5.FCb
                    com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.c(r1)
                    com.tencent.mm.plugin.story.ui.view.StoryCommentInputView r1 = r5.FCb
                    com.tencent.mm.ui.widget.MMEditText r1 = com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.a(r1)
                    r2 = 0
                    r1.setText(r2)
                    com.tencent.mm.plugin.story.ui.view.StoryCommentInputView r1 = r5.FCb
                    android.view.View r1 = com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.e(r1)
                    r1.setVisibility(r3)
                    com.tencent.mm.plugin.story.ui.view.StoryCommentInputView r1 = r5.FCb
                    kotlin.g.a.m r1 = r1.getCommentInputCallback()
                    if (r1 == 0) goto L_0x005b
                    java.lang.String r0 = r0.toString()
                    java.lang.Boolean r2 = java.lang.Boolean.TRUE
                    r1.invoke(r0, r2)
                L_0x005b:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.AnonymousClass6.onEditorAction(android.widget.TextView, int, android.view.KeyEvent):boolean");
            }
        });
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.AnonymousClass7 */
            final /* synthetic */ StoryCommentInputView FCb;

            {
                this.FCb = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120111);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                StoryCommentInputView.b(this.FCb, false);
                m<String, Boolean, x> commentInputCallback = this.FCb.getCommentInputCallback();
                if (commentInputCallback != null) {
                    commentInputCallback.invoke("", Boolean.FALSE);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120111);
            }
        });
        this.FBQ.setImageDrawable(ar.m(context, R.raw.icons_filled_sticker, -1));
        this.FBO.setVisibility(0);
        this.gYo = false;
        TextView textView = this.Fxb;
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "storage()");
        Object obj = aAh.azQ().get(4);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(120126);
            throw tVar;
        }
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, (String) obj, this.Fxb.getTextSize()));
        this.inputType = 2;
        this.ruJ = new d(this);
        AppMethodBeat.o(120126);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryCommentInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120127);
        AppMethodBeat.o(120127);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryCommentInputView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(120128);
        AppMethodBeat.o(120128);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView$Companion;", "", "()V", "InputEmoji", "", "InputEmojiLater", "InputKeyboard", "InputKeyboardLater", "InputLimit", "InputNone", "MinShowLimit", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.String, ? super java.lang.Boolean, kotlin.x>, kotlin.g.a.m<java.lang.String, java.lang.Boolean, kotlin.x> */
    public final m<String, Boolean, x> getCommentInputCallback() {
        return this.FBY;
    }

    public final void setCommentInputCallback(m<? super String, ? super Boolean, x> mVar) {
        this.FBY = mVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super com.tencent.mm.plugin.story.f.b.a, ? super java.lang.Boolean, kotlin.x>, kotlin.g.a.m<com.tencent.mm.plugin.story.f.b.a, java.lang.Boolean, kotlin.x> */
    public final m<com.tencent.mm.plugin.story.f.b.a, Boolean, x> getCommentReplyCallback() {
        return this.FBZ;
    }

    public final void setCommentReplyCallback(m<? super com.tencent.mm.plugin.story.f.b.a, ? super Boolean, x> mVar) {
        this.FBZ = mVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"})
    public static final class b implements ChatFooterPanel.a {
        final /* synthetic */ StoryCommentInputView FCb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(StoryCommentInputView storyCommentInputView) {
            this.FCb = storyCommentInputView;
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void append(String str) {
            AppMethodBeat.i(120112);
            this.FCb.FBP.bol(str);
            AppMethodBeat.o(120112);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHC() {
            AppMethodBeat.i(120113);
            InputConnection inputConnection = this.FCb.FBP.getInputConnection();
            if (inputConnection != null) {
                inputConnection.sendKeyEvent(new KeyEvent(0, 67));
            }
            InputConnection inputConnection2 = this.FCb.FBP.getInputConnection();
            if (inputConnection2 != null) {
                inputConnection2.sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(120113);
                return;
            }
            AppMethodBeat.o(120113);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void eP(boolean z) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHD() {
            AppMethodBeat.i(120114);
            if (this.FCb.gYo) {
                h hVar = h.FuH;
                h.aaT(9);
                Editable text = this.FCb.FBP.getText();
                if (text != null) {
                    StoryCommentInputView.c(this.FCb);
                    this.FCb.FBP.setText((CharSequence) null);
                    this.FCb.FBO.setVisibility(8);
                    this.FCb.FBU.setVisibility(4);
                    m<String, Boolean, x> commentInputCallback = this.FCb.getCommentInputCallback();
                    if (commentInputCallback != null) {
                        commentInputCallback.invoke(text.toString(), Boolean.TRUE);
                        AppMethodBeat.o(120114);
                        return;
                    }
                    AppMethodBeat.o(120114);
                    return;
                }
            }
            AppMethodBeat.o(120114);
        }
    }

    public static /* synthetic */ void a(StoryCommentInputView storyCommentInputView, CharSequence charSequence) {
        AppMethodBeat.i(120118);
        storyCommentInputView.a(charSequence, "", false);
        AppMethodBeat.o(120118);
    }

    public final void a(CharSequence charSequence, String str, boolean z) {
        String string;
        String string2;
        CharSequence charSequence2;
        String arJ;
        AppMethodBeat.i(120117);
        p.h(str, "toUser");
        this.FBP.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), charSequence, this.FBP.getTextSize()));
        if (charSequence != null) {
            this.FBP.setSelection(charSequence.length());
        }
        if (z) {
            string = getResources().getString(R.string.hj4);
            p.g(string, "resources.getString(R.st…story_reply_visible_hint)");
            string2 = getResources().getString(R.string.hj3);
            p.g(string2, "resources.getString(R.st…_reply_visible_edit_hint)");
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
            charSequence2 = getResources().getString(R.string.hj3) + ' ' + ((Object) com.tencent.mm.pluginsdk.ui.span.l.b(this.Fxb.getContext(), (Kn == null || (arJ = Kn.arJ()) == null) ? "" : arJ, this.Fxb.getTextSize()));
        } else {
            string = getResources().getString(R.string.hh1);
            p.g(string, "resources.getString(R.st…ory_comment_visible_hint)");
            string2 = getResources().getString(R.string.hh0);
            p.g(string2, "resources.getString(R.st…omment_visible_edit_hint)");
            Context context = getContext();
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "storage()");
            Object obj = aAh.azQ().get(4);
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(120117);
                throw tVar;
            }
            CharSequence b2 = com.tencent.mm.pluginsdk.ui.span.l.b(context, (String) obj, this.Fxb.getTextSize());
            p.g(b2, "MMSpanManager.spanForSmi…tring, fromUser.textSize)");
            charSequence2 = b2;
        }
        this.FBP.setHint(string2);
        this.kuu.setText(string);
        this.Fxb.setText(charSequence2);
        AppMethodBeat.o(120117);
    }

    public final void aj(List<com.tencent.mm.plugin.story.f.b.a> list) {
        AppMethodBeat.i(120119);
        p.h(list, "storyComments");
        this.FBS.hw(list);
        AppMethodBeat.o(120119);
    }

    public final CharSequence getContent() {
        AppMethodBeat.i(120120);
        Editable text = this.FBP.getText();
        String obj = text != null ? text.toString() : null;
        AppMethodBeat.o(120120);
        return obj;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ StoryCommentInputView FCb;
        final /* synthetic */ int gUj;

        c(StoryCommentInputView storyCommentInputView, int i2) {
            this.FCb = storyCommentInputView;
            this.gUj = i2;
        }

        public final void run() {
            AppMethodBeat.i(120115);
            RecyclerView.LayoutManager layoutManager = this.FCb.hak.getLayoutManager();
            if (layoutManager == null) {
                p.hyc();
            }
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.gUj, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(layoutManager, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$scrollToPosition$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            layoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(layoutManager, "com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$scrollToPosition$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            AppMethodBeat.o(120115);
        }
    }

    public final void scrollToPosition(int i2) {
        AppMethodBeat.i(120121);
        this.hak.post(new c(this, i2));
        AppMethodBeat.o(120121);
    }

    public final void setHostStory(com.tencent.mm.plugin.story.i.j jVar) {
        this.FBS.FxM = jVar;
    }

    public final void frZ() {
        AppMethodBeat.i(120122);
        this.hak.setVisibility(0);
        AppMethodBeat.o(120122);
    }

    public final void destroy() {
        AppMethodBeat.i(120123);
        this.FBS.hw(new ArrayList());
        this.FBS.notifyDataSetChanged();
        this.rum.destroy();
        AppMethodBeat.o(120123);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ StoryCommentInputView FCb;

        d(StoryCommentInputView storyCommentInputView) {
            this.FCb = storyCommentInputView;
        }

        public final void run() {
            AppMethodBeat.i(120116);
            InputMethodManager inputMethodManager = (InputMethodManager) this.FCb.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.FCb.FBP, 0);
                AppMethodBeat.o(120116);
                return;
            }
            AppMethodBeat.o(120116);
        }
    }

    private final void setKeyboardVisibility(boolean z) {
        AppMethodBeat.i(120124);
        if (z) {
            post(this.ruJ);
            AppMethodBeat.o(120124);
            return;
        }
        removeCallbacks(this.ruJ);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(120124);
            return;
        }
        AppMethodBeat.o(120124);
    }

    @Override // com.tencent.mm.ui.widget.InputPanelFrameLayout, com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(120125);
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
        AppMethodBeat.o(120125);
    }

    public static final /* synthetic */ void c(StoryCommentInputView storyCommentInputView) {
        AppMethodBeat.i(120130);
        InputMethodManager inputMethodManager = (InputMethodManager) storyCommentInputView.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(storyCommentInputView.getWindowToken(), 0);
            AppMethodBeat.o(120130);
            return;
        }
        AppMethodBeat.o(120130);
    }
}
