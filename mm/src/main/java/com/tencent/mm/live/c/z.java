package com.tencent.mm.live.c;

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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0006\u0010%\u001a\u00020\u001aJ\u0018\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020#2\u0006\u0010(\u001a\u00020\tH\u0002J\b\u0010*\u001a\u00020#H\u0016J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020#H\u0002J,\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020#H\u0002J\u001a\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u001f2\b\b\u0002\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020#H\u0002J\u001a\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020#H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u000e*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u000e*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u000e*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u000e*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "lastEditHeight", "replyBtnWidth", "sendBtn", "sendBtnEnabled", "", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "changeToInputMode", "", "changeToPreviewMode", "getEditPanel", "keyboardChange", "show", "height", "layoutInputView", "mount", "onBackPress", "onHideSmileyPanel", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class z extends a implements i {
    public static final a hQX = new a((byte) 0);
    private Context context;
    private final b hOp;
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

    static {
        AppMethodBeat.i(208070);
        AppMethodBeat.o(208070);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208069);
        this.hOp = bVar;
        this.hQL = (LinearLayout) viewGroup.findViewById(R.id.ehj);
        this.hQM = (LinearLayout) viewGroup.findViewById(R.id.egv);
        this.hQN = viewGroup.findViewById(R.id.ehl);
        this.hQO = (MMEditText) viewGroup.findViewById(R.id.ehn);
        this.hQP = (TextView) viewGroup.findViewById(R.id.eli);
        this.hQQ = (ImageView) viewGroup.findViewById(R.id.ehg);
        this.hQR = (TextView) viewGroup.findViewById(R.id.eg8);
        SmileyPanel l = ad.l(viewGroup.getContext(), false);
        p.g(l, "SmileyPanelFactory.getSm…anel(root.context, false)");
        this.hQS = l;
        Context context2 = viewGroup.getContext();
        p.g(context2, "root.context");
        this.context = context2;
        this.hQV = this.hQI;
        this.hQV = this.hQI;
        ImageView imageView = this.hQQ;
        Context context3 = viewGroup.getContext();
        p.g(context3, "root.context");
        imageView.setImageDrawable(ar.e(context3.getResources().getDrawable(R.raw.icons_filled_sticker), -1));
        this.hQQ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.z.AnonymousClass1 */
            final /* synthetic */ z hQY;

            {
                this.hQY = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208035);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                z.a(this.hQY, this.hQY.hQV != this.hQY.hQK);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208035);
            }
        });
        InputFilter[] inputFilterArr = {new b(this), new c(f.a.MODE_CHINESE_AS_2)};
        MMEditText mMEditText = this.hQO;
        p.g(mMEditText, "inputEt");
        mMEditText.setFilters(inputFilterArr);
        this.hQO.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.live.c.z.AnonymousClass2 */
            final /* synthetic */ z hQY;

            {
                this.hQY = r1;
            }

            /* JADX WARNING: Removed duplicated region for block: B:20:0x00be  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00cc  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void afterTextChanged(android.text.Editable r13) {
                /*
                // Method dump skipped, instructions count: 414
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.c.z.AnonymousClass2.afterTextChanged(android.text.Editable):void");
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
            /* renamed from: com.tencent.mm.live.c.z$2$a */
            static final class a implements ValueAnimator.AnimatorUpdateListener {
                final /* synthetic */ AnonymousClass2 hQZ;

                a(AnonymousClass2 r1) {
                    this.hQZ = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(208036);
                    Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
                    if (animatedValue == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(208036);
                        throw tVar;
                    }
                    float intValue = (float) ((Integer) animatedValue).intValue();
                    TextView textView = this.hQZ.hQY.hQP;
                    p.g(textView, "sendBtn");
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = kotlin.h.a.cR(intValue);
                    TextView textView2 = this.hQZ.hQY.hQP;
                    p.g(textView2, "sendBtn");
                    textView2.setLayoutParams(layoutParams);
                    TextView textView3 = this.hQZ.hQY.hQP;
                    p.g(textView3, "sendBtn");
                    textView3.setAlpha(intValue / ((float) this.hQZ.hQY.hQT));
                    AppMethodBeat.o(208036);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
            /* renamed from: com.tencent.mm.live.c.z$2$b */
            public static final class b implements Animator.AnimatorListener {
                final /* synthetic */ AnonymousClass2 hQZ;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                b(AnonymousClass2 r1) {
                    this.hQZ = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(208037);
                    TextView textView = this.hQZ.hQY.hQP;
                    p.g(textView, "sendBtn");
                    textView.setVisibility(0);
                    TextView textView2 = this.hQZ.hQY.hQP;
                    p.g(textView2, "sendBtn");
                    ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                    layoutParams.width = this.hQZ.hQY.hQT;
                    TextView textView3 = this.hQZ.hQY.hQP;
                    p.g(textView3, "sendBtn");
                    textView3.setLayoutParams(layoutParams);
                    TextView textView4 = this.hQZ.hQY.hQP;
                    p.g(textView4, "sendBtn");
                    textView4.setAlpha(1.0f);
                    AppMethodBeat.o(208037);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(208038);
                    TextView textView = this.hQZ.hQY.hQP;
                    p.g(textView, "sendBtn");
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = this.hQZ.hQY.hQT;
                    TextView textView2 = this.hQZ.hQY.hQP;
                    p.g(textView2, "sendBtn");
                    textView2.setLayoutParams(layoutParams);
                    TextView textView3 = this.hQZ.hQY.hQP;
                    p.g(textView3, "sendBtn");
                    textView3.setAlpha(1.0f);
                    AppMethodBeat.o(208038);
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(208039);
                    TextView textView = this.hQZ.hQY.hQP;
                    p.g(textView, "sendBtn");
                    textView.setVisibility(0);
                    AppMethodBeat.o(208039);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
            /* renamed from: com.tencent.mm.live.c.z$2$c */
            static final class c implements ValueAnimator.AnimatorUpdateListener {
                final /* synthetic */ AnonymousClass2 hQZ;

                c(AnonymousClass2 r1) {
                    this.hQZ = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(208040);
                    Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
                    if (animatedValue == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(208040);
                        throw tVar;
                    }
                    float intValue = (float) ((Integer) animatedValue).intValue();
                    TextView textView = this.hQZ.hQY.hQP;
                    p.g(textView, "sendBtn");
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = kotlin.h.a.cR(intValue);
                    TextView textView2 = this.hQZ.hQY.hQP;
                    p.g(textView2, "sendBtn");
                    textView2.setLayoutParams(layoutParams);
                    TextView textView3 = this.hQZ.hQY.hQP;
                    p.g(textView3, "sendBtn");
                    textView3.setAlpha(intValue / ((float) this.hQZ.hQY.hQT));
                    AppMethodBeat.o(208040);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
            /* renamed from: com.tencent.mm.live.c.z$2$d */
            public static final class d implements Animator.AnimatorListener {
                final /* synthetic */ AnonymousClass2 hQZ;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                d(AnonymousClass2 r1) {
                    this.hQZ = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(208041);
                    TextView textView = this.hQZ.hQY.hQP;
                    p.g(textView, "sendBtn");
                    textView.setVisibility(8);
                    AppMethodBeat.o(208041);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(208042);
                    TextView textView = this.hQZ.hQY.hQP;
                    p.g(textView, "sendBtn");
                    textView.setVisibility(8);
                    AppMethodBeat.o(208042);
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(208043);
                    TextView textView = this.hQZ.hQY.hQP;
                    p.g(textView, "sendBtn");
                    textView.setVisibility(0);
                    AppMethodBeat.o(208043);
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
                AppMethodBeat.o(208069);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(au.aD(viewGroup.getContext()));
        }
        this.hQP.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.z.AnonymousClass3 */
            final /* synthetic */ z hQY;

            {
                this.hQY = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208046);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                x xVar = x.hJf;
                if (x.aGB()) {
                    new f.a(this.hQY.context).hbu().aC(this.hQY.context.getResources().getString(R.string.efj)).apa(R.string.w0).b(AnonymousClass1.hRa).show();
                } else {
                    MMEditText mMEditText = this.hQY.hQO;
                    p.g(mMEditText, "inputEt");
                    if (mMEditText.getText() != null) {
                        z.m(this.hQY);
                        Context context = this.hQY.context;
                        if (context == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                            AppMethodBeat.o(208046);
                            throw tVar;
                        }
                        ((MMActivity) context).hideVKB();
                        z.n(this.hQY);
                        MMEditText mMEditText2 = this.hQY.hQO;
                        p.g(mMEditText2, "inputEt");
                        Editable text = mMEditText2.getText();
                        MMEditText mMEditText3 = this.hQY.hQO;
                        p.g(mMEditText3, "inputEt");
                        mMEditText3.setText((CharSequence) null);
                        r rVar = r.hIg;
                        String obj = text.toString();
                        o.d dVar = o.d.hGL;
                        r.aa(obj, o.d.aFy());
                        b.C0376b.a(this.hQY.hOp, b.c.hMb);
                        if (this.hQY.hOp.getLiveRole() == 0) {
                            com.tencent.mm.live.d.f.aIT();
                        }
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208046);
            }
        });
        this.hQL.setOnClickListener(AnonymousClass4.hRb);
        this.hQR.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.z.AnonymousClass5 */
            final /* synthetic */ z hQY;

            {
                this.hQY = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208049);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                z.m(this.hQY);
                Context context = this.hQY.context;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(208049);
                    throw tVar;
                }
                ((MMActivity) context).hideVKB();
                z.n(this.hQY);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208049);
            }
        });
        this.hQS.setEntranceScene(ChatFooterPanel.KbO);
        this.hQS.goD();
        this.hQS.goE();
        this.hQS.zN(false);
        this.hQS.setVisibility(4);
        this.hQS.onResume();
        this.hQS.setOnTextOperationListener(new f(this));
        AppMethodBeat.o(208069);
    }

    public static final /* synthetic */ void m(z zVar) {
        AppMethodBeat.i(208071);
        zVar.aHz();
        AppMethodBeat.o(208071);
    }

    public static final /* synthetic */ void n(z zVar) {
        AppMethodBeat.i(208072);
        zVar.aHA();
        AppMethodBeat.o(208072);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveInputPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
    static final class b implements InputFilter {
        final /* synthetic */ z hQY;

        b(z zVar) {
            this.hQY = zVar;
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            AppMethodBeat.i(208051);
            MMEditText mMEditText = this.hQY.hQO;
            p.g(mMEditText, "inputEt");
            mMEditText.getText();
            String obj = charSequence.toString();
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(208051);
                throw tVar;
            } else if (obj.contentEquals(r0)) {
                AppMethodBeat.o(208051);
                return r0;
            } else {
                AppMethodBeat.o(208051);
                return null;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/live/plugin/LiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-logic_release"})
    public static final class c extends com.tencent.mm.ui.tools.f {
        c(f.a aVar) {
            super(120, aVar);
        }

        @Override // com.tencent.mm.ui.tools.f
        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            int a2;
            int i6;
            AppMethodBeat.i(208052);
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
                int mZ = j.mZ(i7 - bnR, 0);
                if (charSequence == null || i2 < 0 || charSequence.length() < i2 + mZ) {
                    AppMethodBeat.o(208052);
                    return r0;
                }
                CharSequence subSequence = charSequence.subSequence(i2, mZ + i2);
                AppMethodBeat.o(208052);
                return subSequence;
            }
            String str = charSequence == null ? "" : charSequence;
            AppMethodBeat.o(208052);
            return str;
        }
    }

    private final void aHz() {
        AppMethodBeat.i(208059);
        if (this.hQV != this.hQK) {
            AppMethodBeat.o(208059);
            return;
        }
        ImageView imageView = this.hQQ;
        Context context2 = this.hwr.getContext();
        p.g(context2, "root.context");
        imageView.setImageDrawable(ar.e(context2.getResources().getDrawable(R.raw.icons_filled_sticker), -1));
        this.hQS.animate().alpha(0.0f).setDuration(220).setListener(new d(this)).start();
        AppMethodBeat.o(208059);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/live/plugin/LiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ z hQY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(z zVar) {
            this.hQY = zVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(208053);
            this.hQY.hQS.setAlpha(1.0f);
            this.hQY.hQS.setVisibility(4);
            AppMethodBeat.o(208053);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/live/plugin/LiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-logic_release"})
    public static final class f implements ChatFooterPanel.a {
        final /* synthetic */ z hQY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(z zVar) {
            this.hQY = zVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void append(String str) {
            AppMethodBeat.i(208056);
            MMEditText mMEditText = this.hQY.hQO;
            if (mMEditText != null) {
                mMEditText.bol(str);
            }
            if (this.hQY.hOp.getLiveRole() == 0) {
                com.tencent.mm.live.d.f.aIU();
            }
            AppMethodBeat.o(208056);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHC() {
            InputConnection inputConnection;
            InputConnection inputConnection2;
            AppMethodBeat.i(208057);
            MMEditText mMEditText = this.hQY.hQO;
            if (!(mMEditText == null || (inputConnection2 = mMEditText.getInputConnection()) == null)) {
                inputConnection2.sendKeyEvent(new KeyEvent(0, 67));
            }
            MMEditText mMEditText2 = this.hQY.hQO;
            if (mMEditText2 == null || (inputConnection = mMEditText2.getInputConnection()) == null) {
                AppMethodBeat.o(208057);
                return;
            }
            inputConnection.sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.o(208057);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void eP(boolean z) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHD() {
        }
    }

    private final void aHA() {
        AppMethodBeat.i(208060);
        this.hQV = this.hQI;
        this.hwr.setVisibility(4);
        this.hQO.clearFocus();
        Object systemService = this.hwr.getContext().getSystemService("input_method");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            AppMethodBeat.o(208060);
            throw tVar;
        }
        MMEditText mMEditText = this.hQO;
        p.g(mMEditText, "inputEt");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(mMEditText.getWindowToken(), 0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_IS_ENTERING_COMMENT", false);
        this.hOp.statusChange(b.c.hMd, bundle);
        AppMethodBeat.o(208060);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208061);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (aa.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                rg(8);
                AppMethodBeat.o(208061);
                return;
            case 3:
                AppMethodBeat.o(208061);
                return;
            case 4:
                if (bundle == null) {
                    AppMethodBeat.o(208061);
                    return;
                } else if (bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                    this.hwr.setVisibility(0);
                    ImageView imageView = this.hQQ;
                    Context context2 = this.hwr.getContext();
                    p.g(context2, "root.context");
                    imageView.setImageDrawable(ar.e(context2.getResources().getDrawable(R.raw.icons_filled_sticker), -1));
                    this.hQO.requestFocus();
                    InputMethodManager inputMethodManager = (InputMethodManager) this.hwr.getContext().getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.showSoftInput(this.hQO, 0);
                        AppMethodBeat.o(208061);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(208061);
    }

    @Override // com.tencent.mm.live.c.a
    public final void keyboardChange(boolean z, int i2) {
        AppMethodBeat.i(208062);
        super.keyboardChange(z, i2);
        if (z) {
            this.hQV = this.hQJ;
            aHz();
            ri(i2);
        } else if (this.hQV == this.hQJ) {
            this.hQV = this.hQI;
            this.hQS.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
            ri(0);
            AppMethodBeat.o(208062);
            return;
        }
        AppMethodBeat.o(208062);
    }

    public final View aHB() {
        AppMethodBeat.i(208064);
        View view = this.hQN;
        p.g(view, "inputParent");
        AppMethodBeat.o(208064);
        return view;
    }

    @Override // com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(208065);
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
        this.hQT = j.mZ(aH, desiredWidth + textView4.getPaddingEnd());
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(904, this);
        AppMethodBeat.o(208065);
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(208066);
        super.unMount();
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(904, this);
        AppMethodBeat.o(208066);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(208068);
        if ((qVar instanceof s) && i3 == -100065) {
            x xVar = x.hJf;
            x.aGC();
            com.tencent.mm.ac.d.h(new e(this));
        }
        AppMethodBeat.o(208068);
    }

    static /* synthetic */ void a(z zVar, boolean z) {
        AppMethodBeat.i(208058);
        if (!z) {
            zVar.aHz();
            Context context2 = zVar.context;
            if (context2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(208058);
                throw tVar;
            }
            ((MMActivity) context2).showVKB();
        } else {
            zVar.hQS.setVisibility(0);
            ImageView imageView = zVar.hQQ;
            Context context3 = zVar.hwr.getContext();
            p.g(context3, "root.context");
            imageView.setImageDrawable(ar.e(context3.getResources().getDrawable(R.raw.icons_filled_keyboard), -1));
            zVar.hQV = zVar.hQK;
            zVar.hQS.setAlpha(0.0f);
            zVar.hQS.animate().alpha(1.0f).setDuration(220).setListener(null).start();
            Context context4 = zVar.context;
            if (context4 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(208058);
                throw tVar2;
            }
            ((MMActivity) context4).hideVKB();
        }
        if (z) {
            ImageView imageView2 = zVar.hQQ;
            Context context5 = zVar.hwr.getContext();
            p.g(context5, "root.context");
            imageView2.setImageDrawable(ar.e(context5.getResources().getDrawable(R.raw.icons_filled_keyboard), -1));
            AppMethodBeat.o(208058);
            return;
        }
        ImageView imageView3 = zVar.hQQ;
        Context context6 = zVar.hwr.getContext();
        p.g(context6, "root.context");
        imageView3.setImageDrawable(ar.e(context6.getResources().getDrawable(R.raw.icons_filled_sticker), -1));
        AppMethodBeat.o(208058);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ z hQY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(z zVar) {
            super(0);
            this.hQY = zVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(208055);
            new f.a(this.hQY.context).hbu().aC(this.hQY.context.getResources().getString(R.string.efj)).apa(R.string.w0).b(AnonymousClass1.hRc).show();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(208055);
            return xVar;
        }
    }

    private final void ri(int i2) {
        AppMethodBeat.i(208063);
        if (this.hwr.getContext() instanceof Activity) {
            View view = this.hQN;
            p.g(view, "inputParent");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                AppMethodBeat.o(208063);
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
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, i2);
            if (!isLandscape()) {
                layoutParams3.bottomMargin = au.aD(this.context);
            } else {
                layoutParams3.setMarginEnd(au.aD(this.context));
            }
            this.hQS.setLayoutParams(layoutParams3);
            if (this.hQS.getParent() == null) {
                this.hQM.addView(this.hQS, layoutParams3);
            }
            Bundle bundle = new Bundle();
            int height = aHB().getHeight() + i2 + au.aD(this.hwr.getContext());
            LinearLayout linearLayout = this.hQL;
            p.g(linearLayout, "inputLayout");
            bundle.putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", height + linearLayout.getPaddingBottom());
            this.hOp.statusChange(b.c.hMD, bundle);
        }
        AppMethodBeat.o(208063);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(208067);
        if (this.hwr.getVisibility() == 0) {
            if (this.hQV == this.hQK) {
                this.hQS.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
                this.hQV = this.hQI;
                ri(0);
            } else {
                aHA();
            }
            AppMethodBeat.o(208067);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(208067);
        return onBackPress;
    }
}
