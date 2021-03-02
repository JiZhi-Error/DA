package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.live.model.cgi.l;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 R2\u00020\u0001:\u0001RB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0011H\u0002J\"\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001c\u00104\u001a\u00020-2\b\u00105\u001a\u0004\u0018\u00010\f2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u00106\u001a\u00020-2\b\b\u0002\u00107\u001a\u00020(H\u0002J\b\u00108\u001a\u00020-H\u0002J*\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020(H\u0002J\u0006\u0010?\u001a\u00020#J\u0018\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020\bH\u0016J\u0010\u0010C\u001a\u00020-2\u0006\u0010B\u001a\u00020\bH\u0002J\b\u0010D\u001a\u00020-H\u0016J\b\u0010E\u001a\u00020(H\u0016J\b\u0010F\u001a\u00020-H\u0002J\b\u0010G\u001a\u00020-H\u0002J\u001a\u0010H\u001a\u00020-2\u0006\u0010I\u001a\u00020(2\b\b\u0002\u0010J\u001a\u00020(H\u0002J\u0006\u0010K\u001a\u00020-J\b\u0010L\u001a\u00020-H\u0002J\u001a\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u000103H\u0016J\b\u0010Q\u001a\u00020-H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u000f*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u000f*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n \u000f*\u0004\u0018\u00010 0 X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \u000f*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n \u000f*\u0004\u0018\u00010#0#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "atContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "commentFailContent", "", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "getCommentPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "setCommentPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;)V", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "lastEditHeight", "replyBtnWidth", "sendBtn", "sendBtnEnabled", "", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "textLimitView", "addSelfComment", "", "content", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "changeToInputMode", "atName", "changeToPreviewMode", "notify", "checkTextLimit", "dealWithErrCode", "errType", "errCode", "realNameUrl", "doScreenClear", "clear", "getEditPanel", "keyboardChange", "show", "height", "layoutInputView", "mount", "onBackPress", "onHideSmileyPanel", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "resendFailComment", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "Companion", "plugin-finder_release"})
public final class ah extends d {
    public static final a uqT = new a((byte) 0);
    public v commentPlugin;
    private Context context;
    private final com.tencent.mm.live.c.b hOp;
    private final int hQI;
    private final int hQJ = 1;
    private final int hQK = 2;
    private final LinearLayout hQL;
    private final LinearLayout hQM;
    private final View hQN;
    private final MMEditText hQO;
    private final TextView hQP;
    private final ImageView hQQ;
    private final TextView hQR;
    private SmileyPanel hQS;
    private int hQT;
    private boolean hQU;
    private int hQV;
    private int hQW;
    private final TextView uqQ;
    public String uqR;
    public avn uqS;

    static {
        AppMethodBeat.i(246797);
        AppMethodBeat.o(246797);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\b\u001a\n \u0004*\u0004\u0018\u00010\t0\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\n¢\u0006\u0002\b\f"}, hxF = {"<anonymous>", "", "source", "", "kotlin.jvm.PlatformType", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
    static final class h implements InputFilter {
        public static final h uqZ = new h();

        static {
            AppMethodBeat.i(246779);
            AppMethodBeat.o(246779);
        }

        h() {
        }

        public final /* bridge */ /* synthetic */ CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            return null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ah(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246796);
        this.hOp = bVar;
        this.hQL = (LinearLayout) viewGroup.findViewById(R.id.ehj);
        this.hQM = (LinearLayout) viewGroup.findViewById(R.id.egv);
        this.hQN = viewGroup.findViewById(R.id.ehl);
        this.hQO = (MMEditText) viewGroup.findViewById(R.id.ehn);
        this.hQP = (TextView) viewGroup.findViewById(R.id.eli);
        this.hQQ = (ImageView) viewGroup.findViewById(R.id.ehg);
        this.hQR = (TextView) viewGroup.findViewById(R.id.eg8);
        this.uqQ = (TextView) viewGroup.findViewById(R.id.ehk);
        SmileyPanel l = ad.l(viewGroup.getContext(), false);
        p.g(l, "SmileyPanelFactory.getSm…anel(root.context, false)");
        this.hQS = l;
        Context context2 = viewGroup.getContext();
        p.g(context2, "root.context");
        this.context = context2;
        this.hQV = this.hQI;
        this.uqR = "";
        this.hQV = this.hQI;
        ImageView imageView = this.hQQ;
        Context context3 = viewGroup.getContext();
        p.g(context3, "root.context");
        imageView.setImageDrawable(ar.e(context3.getResources().getDrawable(R.raw.icons_filled_sticker), -1));
        this.hQQ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ah.AnonymousClass1 */
            final /* synthetic */ ah uqU;

            {
                this.uqU = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246754);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ah.a(this.uqU, this.uqU.hQV != this.uqU.hQK);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246754);
            }
        });
        InputFilter[] inputFilterArr = {h.uqZ, new i(f.a.MODE_CHINESE_AS_2)};
        MMEditText mMEditText = this.hQO;
        p.g(mMEditText, "inputEt");
        mMEditText.setFilters(inputFilterArr);
        this.hQO.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ah.AnonymousClass2 */
            final /* synthetic */ ah uqU;

            {
                this.uqU = r1;
            }

            /* JADX WARNING: Removed duplicated region for block: B:20:0x00c3  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00d1  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void afterTextChanged(android.text.Editable r13) {
                /*
                // Method dump skipped, instructions count: 419
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.ah.AnonymousClass2.afterTextChanged(android.text.Editable):void");
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.ah$2$a */
            static final class a implements ValueAnimator.AnimatorUpdateListener {
                final /* synthetic */ AnonymousClass2 uqV;

                a(AnonymousClass2 r1) {
                    this.uqV = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(246755);
                    Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
                    if (animatedValue == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(246755);
                        throw tVar;
                    }
                    float intValue = (float) ((Integer) animatedValue).intValue();
                    TextView textView = this.uqV.uqU.hQP;
                    p.g(textView, "sendBtn");
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = kotlin.h.a.cR(intValue);
                    TextView textView2 = this.uqV.uqU.hQP;
                    p.g(textView2, "sendBtn");
                    textView2.setLayoutParams(layoutParams);
                    TextView textView3 = this.uqV.uqU.hQP;
                    p.g(textView3, "sendBtn");
                    textView3.setAlpha(intValue / ((float) this.uqV.uqU.hQT));
                    AppMethodBeat.o(246755);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$2$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.ah$2$b */
            public static final class b implements Animator.AnimatorListener {
                final /* synthetic */ AnonymousClass2 uqV;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                b(AnonymousClass2 r1) {
                    this.uqV = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(246756);
                    TextView textView = this.uqV.uqU.hQP;
                    p.g(textView, "sendBtn");
                    textView.setVisibility(0);
                    TextView textView2 = this.uqV.uqU.hQP;
                    p.g(textView2, "sendBtn");
                    ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                    layoutParams.width = this.uqV.uqU.hQT;
                    TextView textView3 = this.uqV.uqU.hQP;
                    p.g(textView3, "sendBtn");
                    textView3.setLayoutParams(layoutParams);
                    TextView textView4 = this.uqV.uqU.hQP;
                    p.g(textView4, "sendBtn");
                    textView4.setAlpha(1.0f);
                    AppMethodBeat.o(246756);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(246757);
                    TextView textView = this.uqV.uqU.hQP;
                    p.g(textView, "sendBtn");
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = this.uqV.uqU.hQT;
                    TextView textView2 = this.uqV.uqU.hQP;
                    p.g(textView2, "sendBtn");
                    textView2.setLayoutParams(layoutParams);
                    TextView textView3 = this.uqV.uqU.hQP;
                    p.g(textView3, "sendBtn");
                    textView3.setAlpha(1.0f);
                    AppMethodBeat.o(246757);
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(246758);
                    TextView textView = this.uqV.uqU.hQP;
                    p.g(textView, "sendBtn");
                    textView.setVisibility(0);
                    AppMethodBeat.o(246758);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.ah$2$c */
            static final class c implements ValueAnimator.AnimatorUpdateListener {
                final /* synthetic */ AnonymousClass2 uqV;

                c(AnonymousClass2 r1) {
                    this.uqV = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(246759);
                    Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
                    if (animatedValue == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(246759);
                        throw tVar;
                    }
                    float intValue = (float) ((Integer) animatedValue).intValue();
                    TextView textView = this.uqV.uqU.hQP;
                    p.g(textView, "sendBtn");
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = kotlin.h.a.cR(intValue);
                    TextView textView2 = this.uqV.uqU.hQP;
                    p.g(textView2, "sendBtn");
                    textView2.setLayoutParams(layoutParams);
                    TextView textView3 = this.uqV.uqU.hQP;
                    p.g(textView3, "sendBtn");
                    textView3.setAlpha(intValue / ((float) this.uqV.uqU.hQT));
                    AppMethodBeat.o(246759);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$2$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.ah$2$d */
            public static final class d implements Animator.AnimatorListener {
                final /* synthetic */ AnonymousClass2 uqV;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                d(AnonymousClass2 r1) {
                    this.uqV = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(246760);
                    TextView textView = this.uqV.uqU.hQP;
                    p.g(textView, "sendBtn");
                    textView.setVisibility(8);
                    AppMethodBeat.o(246760);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(246761);
                    TextView textView = this.uqV.uqU.hQP;
                    p.g(textView, "sendBtn");
                    textView.setVisibility(8);
                    AppMethodBeat.o(246761);
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(246762);
                    TextView textView = this.uqV.uqU.hQP;
                    p.g(textView, "sendBtn");
                    textView.setVisibility(0);
                    AppMethodBeat.o(246762);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        if (isLandscape()) {
            View view = this.hQN;
            p.g(view, "inputParent");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(246796);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(au.aD(viewGroup.getContext()));
        }
        this.hQP.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ah.AnonymousClass3 */
            final /* synthetic */ ah uqU;

            {
                this.uqU = r1;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t¨\u0006\u000b"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$1$1$1", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$$special$$inlined$let$lambda$1"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.ah$3$a */
            static final class a extends q implements r<Integer, Integer, String, ban, x> {
                final /* synthetic */ String uqW;
                final /* synthetic */ AnonymousClass3 uqX;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(String str, AnonymousClass3 r3) {
                    super(4);
                    this.uqW = str;
                    this.uqX = r3;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.r
                public final /* synthetic */ x invoke(Integer num, Integer num2, String str, ban ban) {
                    AppMethodBeat.i(246764);
                    int intValue = num.intValue();
                    int intValue2 = num2.intValue();
                    ban ban2 = ban;
                    p.h(ban2, "resp");
                    ah.a(this.uqX.uqU, intValue, intValue2, this.uqW.toString(), ban2.LFw);
                    x xVar = x.SXb;
                    AppMethodBeat.o(246764);
                    return xVar;
                }
            }

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(246766);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MMEditText mMEditText = this.uqU.hQO;
                p.g(mMEditText, "inputEt");
                if (mMEditText.getText() != null) {
                    ah.p(this.uqU);
                    Context context = this.uqU.context;
                    if (context == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(246766);
                        throw tVar;
                    }
                    ((MMActivity) context).hideVKB();
                    MMEditText mMEditText2 = this.uqU.hQO;
                    p.g(mMEditText2, "inputEt");
                    Editable text = mMEditText2.getText();
                    if (text == null || (str = text.toString()) == null) {
                        str = "";
                    }
                    MMEditText mMEditText3 = this.uqU.hQO;
                    p.g(mMEditText3, "inputEt");
                    mMEditText3.setText((CharSequence) null);
                    y yVar = y.vXH;
                    String awt = y.awt(str);
                    String str2 = awt;
                    if (str2 == null || str2.length() == 0) {
                        m mVar = m.vVH;
                        m.hd("Finder.LiveInputPlugin", "输入的内容为空");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(246766);
                        return;
                    }
                    avn avn = this.uqU.uqS;
                    if (avn != null) {
                        com.tencent.mm.plugin.finder.report.live.m.vli.bxV(awt.toString());
                        x.a aVar = com.tencent.mm.plugin.finder.cgi.x.ttF;
                        aut a2 = x.a.a(avn, awt.toString());
                        new com.tencent.mm.plugin.finder.cgi.x(a2, this.uqU.getLiveData(), new a(awt, this)).aYI();
                        m mVar2 = m.vVH;
                        m.a(a2, this.uqU.getLiveData());
                        b.C0376b.a(this.uqU.hOp, b.c.hMb);
                    } else {
                        o oVar = o.ujN;
                        s finderLiveAssistant = o.getFinderLiveAssistant();
                        if (finderLiveAssistant != null) {
                            String str3 = awt.toString();
                            o.c cVar = o.c.hGH;
                            finderLiveAssistant.a(str3, o.c.aFn(), new b(awt, this));
                        }
                        ah.b(this.uqU, awt.toString());
                        b.C0376b.a(this.uqU.hOp, b.c.hMb);
                    }
                    ah.a(this.uqU);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246766);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$1$2$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder_release", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$$special$$inlined$run$lambda$1"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.ah$3$b */
            public static final class b implements l.a {
                final /* synthetic */ String uqW;
                final /* synthetic */ AnonymousClass3 uqX;

                b(String str, AnonymousClass3 r2) {
                    this.uqW = str;
                    this.uqX = r2;
                }

                @Override // com.tencent.mm.plugin.finder.live.model.cgi.l.a
                public final void a(int i2, int i3, String str, bap bap) {
                    AppMethodBeat.i(246765);
                    p.h(bap, "resp");
                    ah.a(this.uqX.uqU, i2, i3, this.uqW.toString(), bap.HIt);
                    if (this.uqX.uqU.hOp.getLiveRole() == 0 && i2 == 0 && i3 == 0) {
                        com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.SEND_SUCC_COMMENT, this.uqW.toString());
                    }
                    AppMethodBeat.o(246765);
                }
            }
        });
        this.hQL.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ah.AnonymousClass4 */
            final /* synthetic */ ah uqU;

            {
                this.uqU = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246767);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ah.p(this.uqU);
                Context context = this.uqU.context;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(246767);
                    throw tVar;
                }
                ((MMActivity) context).hideVKB();
                ah.a(this.uqU);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246767);
            }
        });
        this.hQS.setEntranceScene(ChatFooterPanel.KbO);
        this.hQS.goD();
        this.hQS.goE();
        this.hQS.zN(false);
        this.hQS.setVisibility(4);
        this.hQS.onResume();
        this.hQS.setOnTextOperationListener(new k(this));
        AppMethodBeat.o(246796);
    }

    public static final /* synthetic */ void p(ah ahVar) {
        AppMethodBeat.i(246799);
        ahVar.aHz();
        AppMethodBeat.o(246799);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$Companion;", "", "()V", "AT_PREFFIX", "", "AT_SUFFIX", "MAX_COMMENT_TEXT_NUM", "", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder_release"})
    public static final class i extends com.tencent.mm.ui.tools.f {
        i(f.a aVar) {
            super(120, aVar);
        }

        @Override // com.tencent.mm.ui.tools.f
        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            int a2;
            int i6;
            AppMethodBeat.i(246780);
            if ((spanned != null ? spanned.length() : 0) > i4) {
                a2 = com.tencent.mm.ui.tools.f.a(String.valueOf(spanned != null ? spanned.subSequence(0, i4) : null), f.a.MODE_CHINESE_AS_2);
            } else {
                a2 = com.tencent.mm.ui.tools.f.a(String.valueOf(spanned), f.a.MODE_CHINESE_AS_2);
            }
            if (spanned == null || spanned.length() <= i5) {
                i6 = 0;
            } else {
                i6 = com.tencent.mm.ui.tools.f.a(spanned.subSequence(i5, spanned.length()).toString(), f.a.MODE_CHINESE_AS_2);
            }
            int a3 = com.tencent.mm.ui.tools.f.a(String.valueOf(charSequence), f.a.MODE_CHINESE_AS_2);
            int i7 = (120 - a2) - i6;
            int bnR = com.tencent.mm.ui.tools.f.bnR(String.valueOf(charSequence));
            if (i6 + a2 + a3 > 120) {
                int mZ = kotlin.k.j.mZ(i7 - bnR, 0);
                if (charSequence == null || i2 < 0 || charSequence.length() < i2 + mZ) {
                    AppMethodBeat.o(246780);
                    return r0;
                }
                CharSequence subSequence = charSequence.subSequence(i2, mZ + i2);
                AppMethodBeat.o(246780);
                return subSequence;
            }
            String str = charSequence == null ? "" : charSequence;
            AppMethodBeat.o(246780);
            return str;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$checkTextLimit$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
    public static final class f implements c.a {
        final /* synthetic */ ah uqU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(ah ahVar) {
            this.uqU = ahVar;
        }

        @Override // com.tencent.mm.ui.tools.b.c.a
        public final void Tx(String str) {
            AppMethodBeat.i(246775);
            TextView textView = this.uqU.uqQ;
            p.g(textView, "textLimitView");
            textView.setVisibility(8);
            AppMethodBeat.o(246775);
        }

        @Override // com.tencent.mm.ui.tools.b.c.a
        public final void dv(String str) {
            AppMethodBeat.i(246776);
            TextView textView = this.uqU.uqQ;
            p.g(textView, "textLimitView");
            textView.setText(String.valueOf(com.tencent.mm.ui.tools.f.dp(120, str)));
            this.uqU.uqQ.setTextColor(this.uqU.context.getResources().getColor(R.color.Red));
            TextView textView2 = this.uqU.uqQ;
            p.g(textView2, "textLimitView");
            textView2.setVisibility(0);
            AppMethodBeat.o(246776);
        }

        @Override // com.tencent.mm.ui.tools.b.c.a
        public final void Tw(String str) {
            AppMethodBeat.i(246777);
            int dp = com.tencent.mm.ui.tools.f.dp(120, str);
            if (dp > 5) {
                TextView textView = this.uqU.uqQ;
                p.g(textView, "textLimitView");
                textView.setVisibility(8);
                AppMethodBeat.o(246777);
                return;
            }
            TextView textView2 = this.uqU.uqQ;
            p.g(textView2, "textLimitView");
            textView2.setText(String.valueOf(dp));
            this.uqU.uqQ.setTextColor(this.uqU.context.getResources().getColor(R.color.BW_100_Alpha_0_5));
            TextView textView3 = this.uqU.uqQ;
            p.g(textView3, "textLimitView");
            textView3.setVisibility(0);
            AppMethodBeat.o(246777);
        }
    }

    private final void aHz() {
        AppMethodBeat.i(246785);
        if (this.hQV != this.hQK) {
            AppMethodBeat.o(246785);
            return;
        }
        ImageView imageView = this.hQQ;
        Context context2 = this.hwr.getContext();
        p.g(context2, "root.context");
        imageView.setImageDrawable(ar.e(context2.getResources().getDrawable(R.raw.icons_filled_sticker), -1));
        this.hQS.animate().alpha(0.0f).setDuration(220).setListener(new j(this)).start();
        AppMethodBeat.o(246785);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class j implements Animator.AnimatorListener {
        final /* synthetic */ ah uqU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(ah ahVar) {
            this.uqU = ahVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(246781);
            this.uqU.hQS.setAlpha(1.0f);
            this.uqU.hQS.setVisibility(4);
            AppMethodBeat.o(246781);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
    public static final class k implements ChatFooterPanel.a {
        final /* synthetic */ ah uqU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(ah ahVar) {
            this.uqU = ahVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void append(String str) {
            AppMethodBeat.i(246782);
            MMEditText mMEditText = this.uqU.hQO;
            if (mMEditText != null) {
                if (com.tencent.mm.ui.tools.f.a(((Object) mMEditText.getText()) + str, f.a.MODE_CHINESE_AS_2) <= 120) {
                    mMEditText.bol(str);
                }
                AppMethodBeat.o(246782);
                return;
            }
            AppMethodBeat.o(246782);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHC() {
            InputConnection inputConnection;
            InputConnection inputConnection2;
            AppMethodBeat.i(246783);
            MMEditText mMEditText = this.uqU.hQO;
            if (!(mMEditText == null || (inputConnection2 = mMEditText.getInputConnection()) == null)) {
                inputConnection2.sendKeyEvent(new KeyEvent(0, 67));
            }
            MMEditText mMEditText2 = this.uqU.hQO;
            if (mMEditText2 == null || (inputConnection = mMEditText2.getInputConnection()) == null) {
                AppMethodBeat.o(246783);
                return;
            }
            inputConnection.sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.o(246783);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void eP(boolean z) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHD() {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"showKVB", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ ah uqU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ah ahVar) {
            super(0);
            this.uqU = ahVar;
        }

        @Override // kotlin.g.a.a
        public final void invoke() {
            AppMethodBeat.i(246771);
            this.uqU.hQO.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.uqU.hwr.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.uqU.hQO, 0);
                AppMethodBeat.o(246771);
                return;
            }
            AppMethodBeat.o(246771);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"clearEditStatus", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ ah uqU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ah ahVar) {
            super(0);
            this.uqU = ahVar;
        }

        @Override // kotlin.g.a.a
        public final void invoke() {
            AppMethodBeat.i(246773);
            MMEditText mMEditText = this.uqU.hQO;
            p.g(mMEditText, "inputEt");
            mMEditText.setHint(this.uqU.context.getResources().getString(R.string.crr));
            MMEditText mMEditText2 = this.uqU.hQO;
            p.g(mMEditText2, "inputEt");
            mMEditText2.setText((CharSequence) null);
            AppMethodBeat.o(246773);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$changeToInputMode$3$1"})
    static final class b implements Runnable {
        final /* synthetic */ ah uqU;
        final /* synthetic */ c uqY;

        b(ah ahVar, c cVar) {
            this.uqU = ahVar;
            this.uqY = cVar;
        }

        public final void run() {
            AppMethodBeat.i(246769);
            this.uqY.invoke();
            AppMethodBeat.o(246769);
        }
    }

    static /* synthetic */ void a(ah ahVar) {
        AppMethodBeat.i(246787);
        ahVar.nu(true);
        AppMethodBeat.o(246787);
    }

    private final void nu(boolean z) {
        AppMethodBeat.i(246786);
        this.hQV = this.hQI;
        this.hwr.setVisibility(4);
        this.hQO.clearFocus();
        Object systemService = this.hwr.getContext().getSystemService("input_method");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            AppMethodBeat.o(246786);
            throw tVar;
        }
        MMEditText mMEditText = this.hQO;
        p.g(mMEditText, "inputEt");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(mMEditText.getWindowToken(), 0);
        nv(false);
        if (z) {
            this.hwr.post(new e(this));
        }
        AppMethodBeat.o(246786);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ ah uqU;

        e(ah ahVar) {
            this.uqU = ahVar;
        }

        public final void run() {
            AppMethodBeat.i(246774);
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_IS_ENTERING_COMMENT", false);
            this.uqU.hOp.statusChange(b.c.hMd, bundle);
            AppMethodBeat.o(246774);
        }
    }

    private final void nv(boolean z) {
        AppMethodBeat.i(246788);
        getLiveData().uDR = z;
        com.tencent.mm.live.c.b bVar = this.hOp;
        b.c cVar = b.c.hNl;
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", getLiveData().uDR);
        bVar.statusChange(cVar, bundle);
        AppMethodBeat.o(246788);
    }

    @Override // com.tencent.mm.live.c.a
    public final void B(int i2, Bundle bundle) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bf, code lost:
        if ((!kotlin.g.b.p.j(r0, r1)) != false) goto L_0x00c1;
     */
    @Override // com.tencent.mm.live.c.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void statusChange(com.tencent.mm.live.c.b.c r10, android.os.Bundle r11) {
        /*
        // Method dump skipped, instructions count: 368
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.ah.statusChange(com.tencent.mm.live.c.b$c, android.os.Bundle):void");
    }

    @Override // com.tencent.mm.live.c.a
    public final void keyboardChange(boolean z, int i2) {
        AppMethodBeat.i(246790);
        super.keyboardChange(z, i2);
        if (z) {
            this.hQV = this.hQJ;
            aHz();
            ri(i2);
        } else if (this.hQV == this.hQJ) {
            this.hQV = this.hQI;
            this.hQS.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
            ri(0);
            AppMethodBeat.o(246790);
            return;
        }
        AppMethodBeat.o(246790);
    }

    public final View aHB() {
        AppMethodBeat.i(246792);
        View view = this.hQN;
        p.g(view, "inputParent");
        AppMethodBeat.o(246792);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(246793);
        super.mount();
        TextView textView = this.hQP;
        p.g(textView, "sendBtn");
        CharSequence text = textView.getText();
        TextView textView2 = this.hQP;
        p.g(textView2, "sendBtn");
        int aH = at.aH(this.context, R.dimen.cp);
        TextView textView3 = this.hQP;
        p.g(textView3, "sendBtn");
        int desiredWidth = ((int) StaticLayout.getDesiredWidth(text, textView2.getPaint())) + textView3.getPaddingStart();
        TextView textView4 = this.hQP;
        p.g(textView4, "sendBtn");
        this.hQT = kotlin.k.j.mZ(aH, desiredWidth + textView4.getPaddingEnd());
        AppMethodBeat.o(246793);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246794);
        super.unMount();
        AppMethodBeat.o(246794);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ int $errCode;
        final /* synthetic */ int $errType;
        final /* synthetic */ String $realNameUrl;
        final /* synthetic */ String grJ;
        final /* synthetic */ ah uqU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(ah ahVar, int i2, int i3, String str, String str2) {
            super(0);
            this.uqU = ahVar;
            this.$errType = i2;
            this.$errCode = i3;
            this.grJ = str;
            this.$realNameUrl = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(246778);
            if (!(this.$errType == 0 && this.$errCode == 0)) {
                if (this.$errCode == -200016) {
                    this.uqU.uqR = this.grJ;
                    Bundle bundle = new Bundle();
                    bundle.putString("PARAM_FINDER_LIVE_URL", this.$realNameUrl);
                    bundle.putString("PARAM_FINDER_LIVE_COMMENT", this.grJ);
                    this.uqU.hOp.statusChange(b.c.hNj, bundle);
                } else if (this.$errCode == -200014) {
                    this.uqU.getLiveData().uDB = false;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("PARAM_FINDER_LIVE_COMMENT", this.grJ);
                    this.uqU.hOp.statusChange(b.c.hNk, bundle2);
                    Context context = this.uqU.hwr.getContext();
                    Context context2 = MMApplicationContext.getContext();
                    p.g(context2, "MMApplicationContext.getContext()");
                    u.makeText(context, context2.getResources().getString(R.string.cyy), 0).show();
                } else if (this.$errCode == -200031) {
                    this.uqU.getLiveData().uDD = false;
                } else if (this.$errCode == -200015 || this.$errCode == -200018) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("PARAM_FINDER_LIVE_COMMENT", this.grJ);
                    this.uqU.hOp.statusChange(b.c.hNk, bundle3);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246778);
            return xVar;
        }
    }

    static /* synthetic */ void a(ah ahVar, boolean z) {
        AppMethodBeat.i(246784);
        if (!z) {
            ahVar.aHz();
            Context context2 = ahVar.context;
            if (context2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(246784);
                throw tVar;
            }
            ((MMActivity) context2).showVKB();
        } else {
            ahVar.hQS.setVisibility(0);
            ImageView imageView = ahVar.hQQ;
            Context context3 = ahVar.hwr.getContext();
            p.g(context3, "root.context");
            imageView.setImageDrawable(ar.e(context3.getResources().getDrawable(R.raw.icons_filled_keyboard), -1));
            ahVar.hQV = ahVar.hQK;
            ahVar.hQS.setAlpha(0.0f);
            ahVar.hQS.animate().alpha(1.0f).setDuration(220).setListener(null).start();
            Context context4 = ahVar.context;
            if (context4 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(246784);
                throw tVar2;
            }
            ((MMActivity) context4).hideVKB();
        }
        if (z) {
            ImageView imageView2 = ahVar.hQQ;
            Context context5 = ahVar.hwr.getContext();
            p.g(context5, "root.context");
            imageView2.setImageDrawable(ar.e(context5.getResources().getDrawable(R.raw.icons_filled_keyboard), -1));
            AppMethodBeat.o(246784);
            return;
        }
        ImageView imageView3 = ahVar.hQQ;
        Context context6 = ahVar.hwr.getContext();
        p.g(context6, "root.context");
        imageView3.setImageDrawable(ar.e(context6.getResources().getDrawable(R.raw.icons_filled_sticker), -1));
        AppMethodBeat.o(246784);
    }

    private final void ri(int i2) {
        AppMethodBeat.i(246791);
        if (this.hwr.getContext() instanceof Activity) {
            View view = this.hQN;
            p.g(view, "inputParent");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                AppMethodBeat.o(246791);
                throw tVar;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (!isLandscape()) {
                layoutParams2.bottomMargin = au.aD(this.context) + i2;
            } else {
                layoutParams2.bottomMargin = i2;
            }
            View view2 = this.hQN;
            p.g(view2, "inputParent");
            view2.setLayoutParams(layoutParams);
            v vVar = this.commentPlugin;
            if (vVar != null) {
                ViewGroup.LayoutParams layoutParams3 = vVar.hwr.getLayoutParams();
                if (layoutParams3 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(246791);
                    throw tVar2;
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                if (!isLandscape()) {
                    View view3 = this.hQN;
                    p.g(view3, "inputParent");
                    layoutParams4.bottomMargin = au.aD(this.context) + i2 + view3.getHeight() + (this.context.getResources().getDimensionPixelOffset(R.dimen.cb) * 2);
                } else {
                    View view4 = this.hQN;
                    p.g(view4, "inputParent");
                    layoutParams4.bottomMargin = view4.getHeight() + i2 + (this.context.getResources().getDimensionPixelOffset(R.dimen.cb) * 2);
                }
                vVar.hwr.setLayoutParams(layoutParams3);
            }
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, i2);
            if (!isLandscape()) {
                layoutParams5.bottomMargin = au.aD(this.context);
            } else {
                layoutParams5.setMarginEnd(au.aD(this.context));
            }
            this.hQS.setLayoutParams(layoutParams5);
            if (this.hQS.getParent() == null) {
                this.hQM.addView(this.hQS, layoutParams5);
            }
            Bundle bundle = new Bundle();
            int height = aHB().getHeight() + i2 + au.aD(this.hwr.getContext());
            LinearLayout linearLayout = this.hQL;
            p.g(linearLayout, "inputLayout");
            bundle.putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", height + linearLayout.getPaddingBottom());
            this.hOp.statusChange(b.c.hMD, bundle);
        }
        AppMethodBeat.o(246791);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(246795);
        if (this.hwr.getVisibility() == 0) {
            if (this.hQV == this.hQK) {
                this.hQS.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
                this.hQV = this.hQI;
                ri(0);
            } else {
                nu(true);
            }
            AppMethodBeat.o(246795);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(246795);
        return onBackPress;
    }

    public static final /* synthetic */ void i(ah ahVar) {
        AppMethodBeat.i(246798);
        com.tencent.mm.ui.tools.b.c.f(ahVar.hQO).lv(1, 120).a(f.a.MODE_CHINESE_AS_2).CN(true).a(new f(ahVar));
        AppMethodBeat.o(246798);
    }

    public static final /* synthetic */ void a(ah ahVar, int i2, int i3, String str, String str2) {
        AppMethodBeat.i(246800);
        com.tencent.mm.ac.d.h(new g(ahVar, i2, i3, str, str2));
        AppMethodBeat.o(246800);
    }

    public static final /* synthetic */ void b(ah ahVar, String str) {
        AppMethodBeat.i(246801);
        awq awq = new awq();
        avn avn = new avn();
        m mVar = m.vVH;
        avn.contact = m.m(ahVar.getLiveData());
        avn.LDK = ahVar.getLiveData().uDx;
        awq.LHp = avn;
        if (str == null) {
            str = "";
        }
        awq.content = str;
        o.c cVar = o.c.hGH;
        awq.type = o.c.aFn();
        ahVar.getLiveData().uDs.add(new com.tencent.mm.plugin.finder.live.model.r(awq));
        com.tencent.mm.live.b.m mVar2 = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.aFe();
        AppMethodBeat.o(246801);
    }
}
