package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.PluginFestival;
import com.tencent.mm.plugin.festival.c.j;
import com.tencent.mm.plugin.festival.model.FestivalWishContextBundle;
import com.tencent.mm.plugin.festival.model.ab;
import com.tencent.mm.plugin.festival.model.ah;
import com.tencent.mm.plugin.festival.ui.view.FestivalWishTopicPanel;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f;
import java.util.Arrays;
import kotlin.g.a.r;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020(H\u0002J\u0018\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\bH\u0016J\u0018\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\bH\u0002J\b\u00101\u001a\u00020\nH\u0016J\u0012\u00102\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010%H\u0002J\b\u00104\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\b\u0010/\u001a\u00020(H\u0002J\u001a\u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020(H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R#\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 ¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "curMode", "", "isKeyBoardShowing", "", "isPosting", "onBtnClick", "Landroid/view/View$OnClickListener;", "point", "Landroid/graphics/Point;", "postWishBtnBottomMargin", "postWishBtnBottomToKeyBoardMargin", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "kotlin.jvm.PlatformType", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "progressDialog$delegate", "Lkotlin/Lazy;", "screenHeight", "getScreenHeight", "()I", "screenHeight$delegate", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "canClearScreen", "checkTextLimit", "s", "", "checkTextLimitInclusive", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "isCancel", "hideKeyBoard", "keyboardChange", "show", "height", "layoutPostPanelWhenKeyBoardChange", "showKeyBoard", "keyBoardHeight", "onBackPress", "parseTopic", "wish", "setRulesTv", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-festival_release"})
public final class bf extends p {
    @Deprecated
    public static final c UvT = new c((byte) 0);
    private final View.OnClickListener FMu;
    private final int UvN;
    private final int UvO;
    private final kotlin.f UvP;
    private boolean UvQ;
    private boolean UvR;
    private final kotlin.f UvS;
    private final com.tencent.mm.live.c.b hOp;
    private int hQV;
    private Point nDV;
    private final kotlin.f uAh;

    static {
        AppMethodBeat.i(262761);
        AppMethodBeat.o(262761);
    }

    private final Vibrator getVibrator() {
        AppMethodBeat.i(262750);
        Vibrator vibrator = (Vibrator) this.uAh.getValue();
        AppMethodBeat.o(262750);
        return vibrator;
    }

    private final q gfk() {
        AppMethodBeat.i(262751);
        q qVar = (q) this.UvS.getValue();
        AppMethodBeat.o(262751);
        return qVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$Companion;", "", "()V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "MAX_COMMENT_TEXT_NUM", "RULES_URL", "", "TAG", "plugin-festival_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bf(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262760);
        this.hOp = bVar;
        Context context = viewGroup.getContext();
        p.g(context, "root.context");
        this.UvN = context.getResources().getDimensionPixelSize(R.dimen.arr);
        Context context2 = viewGroup.getContext();
        p.g(context2, "root.context");
        this.UvO = context2.getResources().getDimensionPixelSize(R.dimen.ars);
        this.uAh = kotlin.g.ah(new h(viewGroup));
        this.UvP = kotlin.g.ah(new f(viewGroup));
        this.UvS = kotlin.g.ah(new e(this, viewGroup));
        this.FMu = new d(this, viewGroup);
        viewGroup.setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R.id.k1k);
        if (frameLayout != null) {
            frameLayout.setOnApplyWindowInsetsListener(new b(frameLayout));
            frameLayout.setOnClickListener(new a(this));
        }
        ((FestivalWishTopicPanel) viewGroup.findViewById(R.id.k1q)).setOnShowCallback(new kotlin.g.a.a<x>() {
            /* class com.tencent.mm.plugin.festival.finder.bf.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(262729);
                com.tencent.mm.plugin.festival.model.a.e eVar = com.tencent.mm.plugin.festival.model.a.e.UAo;
                com.tencent.mm.plugin.festival.model.a.e.hSb();
                RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.k1j);
                p.g(relativeLayout, "root.postWishBtnArea");
                relativeLayout.setVisibility(8);
                x xVar = x.SXb;
                AppMethodBeat.o(262729);
                return xVar;
            }
        });
        ((FestivalWishTopicPanel) viewGroup.findViewById(R.id.k1q)).setOnHideCallback(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.festival.finder.bf.AnonymousClass2 */
            final /* synthetic */ bf UvU;

            {
                this.UvU = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(262730);
                RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.k1j);
                p.g(relativeLayout, "root.postWishBtnArea");
                relativeLayout.setVisibility(0);
                MMEditText mMEditText = (MMEditText) viewGroup.findViewById(R.id.k1p);
                if (mMEditText != null) {
                    mMEditText.requestFocus();
                }
                bf.h(this.UvU);
                x xVar = x.SXb;
                AppMethodBeat.o(262730);
                return xVar;
            }
        });
        ((FestivalWishTopicPanel) viewGroup.findViewById(R.id.k1q)).setSelectCallback(new kotlin.g.a.b<ah, x>(this) {
            /* class com.tencent.mm.plugin.festival.finder.bf.AnonymousClass3 */
            final /* synthetic */ bf UvU;

            {
                this.UvU = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(ah ahVar) {
                AppMethodBeat.i(262731);
                ah ahVar2 = ahVar;
                if (ahVar2 != null) {
                    com.tencent.mm.plugin.festival.model.a.e eVar = com.tencent.mm.plugin.festival.model.a.e.UAo;
                    String str = ahVar2.field_topic;
                    p.g(str, "it.field_topic");
                    com.tencent.mm.plugin.festival.model.a.e.bxx(str);
                    MMEditText mMEditText = (MMEditText) viewGroup.findViewById(R.id.k1p);
                    if (mMEditText != null) {
                        mMEditText.bol("#" + ahVar2.field_topic + ' ');
                    }
                }
                RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.k1j);
                p.g(relativeLayout, "root.postWishBtnArea");
                relativeLayout.setVisibility(0);
                MMEditText mMEditText2 = (MMEditText) viewGroup.findViewById(R.id.k1p);
                if (mMEditText2 != null) {
                    mMEditText2.requestFocus();
                }
                bf.h(this.UvU);
                x xVar = x.SXb;
                AppMethodBeat.o(262731);
                return xVar;
            }
        });
        Button button = (Button) viewGroup.findViewById(R.id.k1l);
        if (button != null) {
            button.setOnClickListener(null);
        }
        MMEditText mMEditText = (MMEditText) viewGroup.findViewById(R.id.k1p);
        if (mMEditText != null) {
            mMEditText.addTextChangedListener(new TextWatcher(this) {
                /* class com.tencent.mm.plugin.festival.finder.bf.AnonymousClass4 */
                final /* synthetic */ bf UvU;

                {
                    this.UvU = r1;
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(262734);
                    String valueOf = String.valueOf(editable);
                    if (valueOf == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                        AppMethodBeat.o(262734);
                        throw tVar;
                    }
                    String obj = n.trim(valueOf).toString();
                    if (bf.a(this.UvU, String.valueOf(editable))) {
                        c unused = bf.UvT;
                        String hm = com.tencent.mm.ui.tools.f.hm(obj, 64);
                        if (editable != null) {
                            try {
                                editable.replace(hm.length(), obj.length(), "");
                            } catch (Exception e2) {
                                c unused2 = bf.UvT;
                                Log.e("FestivalFinderPostWishPlugin", "etDesc replace: " + e2.getMessage());
                            }
                        }
                        if (editable != null) {
                            MMEditText mMEditText = (MMEditText) viewGroup.findViewById(R.id.k1p);
                            if (mMEditText != null) {
                                mMEditText.setSelection(editable.length());
                                AppMethodBeat.o(262734);
                                return;
                            }
                            AppMethodBeat.o(262734);
                            return;
                        }
                        AppMethodBeat.o(262734);
                        return;
                    }
                    AppMethodBeat.o(262734);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    AppMethodBeat.i(262735);
                    b bVar = new b(this);
                    a aVar = new a(this);
                    CharSequence trim = charSequence != null ? n.trim(charSequence) : null;
                    if (trim != null) {
                        if (trim.length() > 0) {
                            bVar.invoke();
                            AppMethodBeat.o(262735);
                            return;
                        }
                        aVar.invoke();
                        AppMethodBeat.o(262735);
                        return;
                    }
                    aVar.invoke();
                    AppMethodBeat.o(262735);
                }

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                /* renamed from: com.tencent.mm.plugin.festival.finder.bf$4$b */
                static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
                    final /* synthetic */ AnonymousClass4 UvW;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    b(AnonymousClass4 r2) {
                        super(0);
                        this.UvW = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(262733);
                        Button button = (Button) viewGroup.findViewById(R.id.k1l);
                        p.g(button, "root.postWishPanelBtn");
                        button.setClickable(true);
                        ((Button) viewGroup.findViewById(R.id.k1l)).setOnClickListener(this.UvW.UvU.FMu);
                        Button button2 = (Button) viewGroup.findViewById(R.id.k1l);
                        p.g(button2, "root.postWishPanelBtn");
                        button2.setEnabled(true);
                        Button button3 = (Button) viewGroup.findViewById(R.id.k1l);
                        p.g(button3, "root.postWishPanelBtn");
                        button3.setBackground(viewGroup.getContext().getDrawable(R.drawable.cu1));
                        Context context = viewGroup.getContext();
                        p.g(context, "root.context");
                        ((Button) viewGroup.findViewById(R.id.k1l)).setTextColor(context.getResources().getColor(R.color.agf));
                        x xVar = x.SXb;
                        AppMethodBeat.o(262733);
                        return xVar;
                    }
                }

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                /* renamed from: com.tencent.mm.plugin.festival.finder.bf$4$a */
                static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
                    final /* synthetic */ AnonymousClass4 UvW;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    a(AnonymousClass4 r2) {
                        super(0);
                        this.UvW = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(262732);
                        Button button = (Button) viewGroup.findViewById(R.id.k1l);
                        p.g(button, "root.postWishPanelBtn");
                        button.setClickable(false);
                        ((Button) viewGroup.findViewById(R.id.k1l)).setOnClickListener(null);
                        Button button2 = (Button) viewGroup.findViewById(R.id.k1l);
                        p.g(button2, "root.postWishPanelBtn");
                        button2.setEnabled(false);
                        Button button3 = (Button) viewGroup.findViewById(R.id.k1l);
                        p.g(button3, "root.postWishPanelBtn");
                        button3.setBackground(viewGroup.getContext().getDrawable(R.drawable.cu0));
                        Context context = viewGroup.getContext();
                        p.g(context, "root.context");
                        ((Button) viewGroup.findViewById(R.id.k1l)).setTextColor(context.getResources().getColor(R.color.age));
                        x xVar = x.SXb;
                        AppMethodBeat.o(262732);
                        return xVar;
                    }
                }
            });
        }
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.k1o);
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.festival.finder.bf.AnonymousClass5 */
                final /* synthetic */ bf UvU;

                {
                    this.UvU = r1;
                }

                public final void onClick(View view) {
                    Editable text;
                    MMEditText mMEditText;
                    AppMethodBeat.i(262736);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    bf bfVar = this.UvU;
                    MMEditText mMEditText2 = (MMEditText) viewGroup.findViewById(R.id.k1p);
                    if (!bf.b(bfVar, String.valueOf(mMEditText2 != null ? mMEditText2.getText() : null))) {
                        MMEditText mMEditText3 = (MMEditText) viewGroup.findViewById(R.id.k1p);
                        if (!(mMEditText3 == null || (text = mMEditText3.getText()) == null || (mMEditText = (MMEditText) viewGroup.findViewById(R.id.k1p)) == null)) {
                            mMEditText.setSelection(text.length());
                        }
                        bf.b(this.UvU);
                        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
                        p.g(ah, "plugin(PluginFestival::class.java)");
                        ((FestivalWishTopicPanel) viewGroup.findViewById(R.id.k1q)).setTopics(((PluginFestival) ah).getTopicStorage().getTopicList());
                        FestivalWishTopicPanel festivalWishTopicPanel = (FestivalWishTopicPanel) viewGroup.findViewById(R.id.k1q);
                        if (festivalWishTopicPanel.getVisibility() != 0) {
                            festivalWishTopicPanel.setTranslationY((float) av.az(festivalWishTopicPanel.getContext()).y);
                            festivalWishTopicPanel.animate().translationY(0.0f).setDuration(300).setInterpolator(new DecelerateInterpolator()).setListener(new FestivalWishTopicPanel.e(festivalWishTopicPanel)).start();
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(262736);
                }
            });
        }
        TextView textView = (TextView) viewGroup.findViewById(R.id.k1n);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.festival.finder.bf.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(262737);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ae aeVar = ae.SYK;
                    c unused = bf.UvT;
                    String format = String.format("https://weixin.qq.com/cgi-bin/readtemplate?t=page/agreement/2021_live_event&lang=%s", Arrays.copyOf(new Object[]{LocaleUtil.getApplicationLanguage()}, 1));
                    p.g(format, "java.lang.String.format(format, *args)");
                    c unused2 = bf.UvT;
                    Log.i("FestivalFinderPostWishPlugin", "go rules url ".concat(String.valueOf(format)));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", format);
                    com.tencent.mm.br.c.b(viewGroup.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    com.tencent.mm.plugin.festival.model.a.e eVar = com.tencent.mm.plugin.festival.model.a.e.UAo;
                    com.tencent.mm.plugin.festival.model.a.e.hSc();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(262737);
                }
            });
        }
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.k1m);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.festival.finder.bf.AnonymousClass7 */
                final /* synthetic */ bf UvU;

                {
                    this.UvU = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(262738);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    bf.h(this.UvU);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(262738);
                }
            });
        }
        int intValue = ((int) (((float) ((Number) this.UvP.getValue()).intValue()) * 0.18f)) - ao.getStatusBarHeight(viewGroup.getContext());
        Context context3 = viewGroup.getContext();
        p.g(context3, "root.context");
        int dimensionPixelSize = intValue - context3.getResources().getDimensionPixelSize(R.dimen.cn);
        LinearLayout linearLayout2 = (LinearLayout) viewGroup.findViewById(R.id.k1m);
        p.g(linearLayout2, "root.postWishPanelEditArea");
        int paddingLeft = linearLayout2.getPaddingLeft();
        LinearLayout linearLayout3 = (LinearLayout) viewGroup.findViewById(R.id.k1m);
        p.g(linearLayout3, "root.postWishPanelEditArea");
        int paddingRight = linearLayout3.getPaddingRight();
        LinearLayout linearLayout4 = (LinearLayout) viewGroup.findViewById(R.id.k1m);
        p.g(linearLayout4, "root.postWishPanelEditArea");
        ((LinearLayout) viewGroup.findViewById(R.id.k1m)).setPadding(paddingLeft, dimensionPixelSize, paddingRight, linearLayout4.getPaddingBottom());
        this.hQV = 0;
        AppMethodBeat.o(262760);
    }

    public static final /* synthetic */ void b(bf bfVar) {
        AppMethodBeat.i(262762);
        bfVar.fTu();
        AppMethodBeat.o(262762);
    }

    public static final /* synthetic */ q d(bf bfVar) {
        AppMethodBeat.i(262763);
        q gfk = bfVar.gfk();
        AppMethodBeat.o(262763);
        return gfk;
    }

    public static final /* synthetic */ void g(bf bfVar) {
        AppMethodBeat.i(262765);
        bfVar.eQ(true);
        AppMethodBeat.o(262765);
    }

    public static final /* synthetic */ void h(bf bfVar) {
        AppMethodBeat.i(262766);
        bfVar.fTt();
        AppMethodBeat.o(262766);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ bf UvU;
        final /* synthetic */ ViewGroup hOA;

        d(bf bfVar, ViewGroup viewGroup) {
            this.UvU = bfVar;
            this.hOA = viewGroup;
        }

        public final void onClick(View view) {
            Point point;
            AppMethodBeat.i(262744);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$onBtnClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.UvU.UvQ) {
                c unused = bf.UvT;
                Log.i("FestivalFinderPostWishPlugin", "posting");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$onBtnClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262744);
                return;
            }
            MMEditText mMEditText = (MMEditText) this.hOA.findViewById(R.id.k1p);
            final String valueOf = String.valueOf(mMEditText != null ? mMEditText.getText() : null);
            this.UvU.UvQ = true;
            com.tencent.mm.ac.d.a(2000, new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.festival.finder.bf.d.AnonymousClass1 */
                final /* synthetic */ d UvX;

                {
                    this.UvX = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(262740);
                    if (this.UvX.UvU.UvQ) {
                        bf.d(this.UvX.UvU).show();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(262740);
                    return xVar;
                }
            });
            Point point2 = this.UvU.nDV;
            if (point2 == null) {
                point = new Point(0, 0);
            } else {
                point = point2;
            }
            ab.a(point, valueOf, bf.bxt(valueOf), new r<Boolean, String, Integer, com.tencent.mm.plugin.festival.b.l, x>(this) {
                /* class com.tencent.mm.plugin.festival.finder.bf.d.AnonymousClass2 */
                final /* synthetic */ d UvX;

                {
                    this.UvX = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.r
                public final /* synthetic */ x invoke(Boolean bool, String str, Integer num, com.tencent.mm.plugin.festival.b.l lVar) {
                    FestivalWishContextBundle.a aVar;
                    AppMethodBeat.i(262743);
                    boolean booleanValue = bool.booleanValue();
                    String str2 = str;
                    int intValue = num.intValue();
                    com.tencent.mm.plugin.festival.b.l lVar2 = lVar;
                    p.h(str2, "error");
                    p.h(lVar2, "resp");
                    c unused = bf.UvT;
                    Log.i("FestivalFinderPostWishPlugin", "postWish suc:%b", Boolean.valueOf(booleanValue));
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.festival.finder.bf.d.AnonymousClass2.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass2 UvZ;

                        {
                            this.UvZ = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(262741);
                            this.UvZ.UvX.UvU.UvQ = false;
                            bf.d(this.UvZ.UvX.UvU).dismiss();
                            x xVar = x.SXb;
                            AppMethodBeat.o(262741);
                            return xVar;
                        }
                    });
                    if (booleanValue) {
                        FestivalWishContextBundle festivalWishContextBundle = new FestivalWishContextBundle();
                        festivalWishContextBundle.Uzg = valueOf;
                        if (lVar2.UBc) {
                            com.tencent.mm.plugin.festival.model.a.e eVar = com.tencent.mm.plugin.festival.model.a.e.UAo;
                            com.tencent.mm.plugin.festival.model.a.e.hRZ();
                            aVar = FestivalWishContextBundle.a.ShowDonation;
                        } else {
                            ab abVar = ab.UzG;
                            if (!ab.hRP()) {
                                c unused2 = bf.UvT;
                                Log.w("FestivalFinderPostWishPlugin", "after action fu status not available");
                                com.tencent.mm.plugin.festival.model.a.e eVar2 = com.tencent.mm.plugin.festival.model.a.e.UAo;
                                com.tencent.mm.plugin.festival.model.a.e.hRZ();
                                aVar = FestivalWishContextBundle.a.NONE;
                            } else {
                                aVar = FestivalWishContextBundle.a.GoSetState;
                            }
                        }
                        festivalWishContextBundle.Uzi = aVar;
                        festivalWishContextBundle.Uzh = lVar2.UBb;
                        festivalWishContextBundle.Uzj = lVar2.UBd;
                        festivalWishContextBundle.Uzk = lVar2.UBe;
                        festivalWishContextBundle.Uzl = lVar2.UBg;
                        festivalWishContextBundle.Uzm = lVar2.UBf;
                        festivalWishContextBundle.Uzn = lVar2.UBh;
                        festivalWishContextBundle.Uzo = lVar2.UBi;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("WishContext", festivalWishContextBundle);
                        this.UvX.UvU.hOp.statusChange(b.c.wLJ, bundle);
                        MMEditText mMEditText = (MMEditText) this.UvX.hOA.findViewById(R.id.k1p);
                        if (mMEditText != null) {
                            mMEditText.setText((CharSequence) null);
                        }
                        bf.a(this.UvX.UvU);
                    } else if (intValue == -100003) {
                        c unused3 = bf.UvT;
                        Log.i("FestivalFinderPostWishPlugin", "postWish need RealName");
                        new f.a(this.UvX.hOA.getContext()).hbu().bow(this.UvX.hOA.getContext().getString(R.string.j9c)).aC(this.UvX.hOA.getContext().getString(R.string.j9d)).boA(this.UvX.hOA.getContext().getString(R.string.w0)).b(AnonymousClass2.Uwa).show();
                    } else {
                        u.u(this.UvX.hOA.getContext(), str2, 0);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(262743);
                    return xVar;
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$onBtnClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262744);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Landroid/view/WindowInsets;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "insets", "onApplyWindowInsets"})
    static final class b implements View.OnApplyWindowInsetsListener {
        final /* synthetic */ FrameLayout UvV;

        b(FrameLayout frameLayout) {
            this.UvV = frameLayout;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            AppMethodBeat.i(262728);
            FrameLayout frameLayout = this.UvV;
            p.g(windowInsets, "insets");
            float systemWindowInsetTop = (float) windowInsets.getSystemWindowInsetTop();
            ViewGroup.LayoutParams layoutParams = this.UvV.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            frameLayout.setY(((float) (marginLayoutParams != null ? marginLayoutParams.topMargin : 0)) + systemWindowInsetTop);
            AppMethodBeat.o(262728);
            return windowInsets;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$1$2"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ bf UvU;

        a(bf bfVar) {
            this.UvU = bfVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262727);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bf.g(this.UvU);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262727);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        int i2;
        int i3;
        String string;
        AppMethodBeat.i(262752);
        p.h(cVar, "status");
        switch (bg.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (bundle != null) {
                    i2 = bundle.getInt("PostWishPointX");
                } else {
                    i2 = 0;
                }
                if (bundle != null) {
                    i3 = bundle.getInt("PostWishPointY");
                } else {
                    i3 = 0;
                }
                this.nDV = new Point(i2, i3);
                this.UvQ = false;
                MMEditText mMEditText = (MMEditText) this.hwr.findViewById(R.id.k1p);
                if (mMEditText != null) {
                    mMEditText.requestFocus();
                }
                this.hwr.bringToFront();
                this.hwr.setOnClickListener(new g(this));
                boolean z = getLiveData().UQh.LFy == 1;
                Log.i("FestivalFinderPostWishPlugin", "setRulesTv isWeChatRole:".concat(String.valueOf(z)));
                if (z) {
                    string = this.hwr.getContext().getString(R.string.j98);
                } else {
                    string = this.hwr.getContext().getString(R.string.j96, z.aUa());
                }
                p.g(string, "if (isWeChatRole) {\n    …FromUserInfo())\n        }");
                SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), string);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) c2);
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                Drawable drawable = context.getResources().getDrawable(R.drawable.cvq);
                if (drawable != null) {
                    TextView textView = (TextView) this.hwr.findViewById(R.id.k1n);
                    p.g(textView, "root.postWishPanelRulesTv");
                    int lineHeight = textView.getLineHeight() / 2;
                    TextView textView2 = (TextView) this.hwr.findViewById(R.id.k1n);
                    p.g(textView2, "root.postWishPanelRulesTv");
                    drawable.setBounds(0, 0, lineHeight, textView2.getLineHeight());
                    spannableStringBuilder.setSpan(new ImageSpan(drawable), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
                }
                TextView textView3 = (TextView) this.hwr.findViewById(R.id.k1n);
                p.g(textView3, "root.postWishPanelRulesTv");
                textView3.setText(spannableStringBuilder);
                fTt();
                rg(0);
                AppMethodBeat.o(262752);
                return;
            case 2:
                rg(8);
                break;
        }
        AppMethodBeat.o(262752);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262753);
        super.unMount();
        if (gfk() != null) {
            gfk().dismiss();
        }
        this.UvQ = false;
        AppMethodBeat.o(262753);
    }

    static /* synthetic */ void a(bf bfVar) {
        AppMethodBeat.i(262755);
        bfVar.eQ(false);
        AppMethodBeat.o(262755);
    }

    private final void eQ(boolean z) {
        AppMethodBeat.i(262754);
        this.UvQ = false;
        ((FestivalWishTopicPanel) this.hwr.findViewById(R.id.k1q)).hide();
        rg(8);
        this.hwr.setOnClickListener(null);
        fTu();
        if (z) {
            b.C0376b.a(this.hOp, b.c.wLW);
        }
        AppMethodBeat.o(262754);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$show$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-festival_release"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ bf UvU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(bf bfVar) {
            this.UvU = bfVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262748);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$show$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bf.b(this.UvU);
            ((FestivalWishTopicPanel) this.UvU.hwr.findViewById(R.id.k1q)).hide();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin$show$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262748);
        }
    }

    private final void fTt() {
        AppMethodBeat.i(262756);
        this.hQV = 1;
        if (this.UvR) {
            AppMethodBeat.o(262756);
            return;
        }
        Context context = this.hwr.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(262756);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) context;
        if (mMActivity != null) {
            mMActivity.showVKB();
            AppMethodBeat.o(262756);
            return;
        }
        AppMethodBeat.o(262756);
    }

    private final void fTu() {
        AppMethodBeat.i(262757);
        this.hQV = 0;
        if (!this.UvR) {
            AppMethodBeat.o(262757);
            return;
        }
        Context context = this.hwr.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(262757);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) context;
        if (mMActivity != null) {
            mMActivity.hideVKB();
            AppMethodBeat.o(262757);
            return;
        }
        AppMethodBeat.o(262757);
    }

    @Override // com.tencent.mm.live.c.a
    public final void keyboardChange(boolean z, int i2) {
        int aD;
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(262759);
        super.keyboardChange(z, i2);
        Log.d("FestivalFinderPostWishPlugin", "keyboardChange show: %b curMode: %b", Boolean.valueOf(z), Integer.valueOf(i2));
        this.UvR = z;
        if (z) {
            ((FestivalWishTopicPanel) this.hwr.findViewById(R.id.k1q)).hide();
            this.hQV = 1;
        } else if (this.hQV == 1) {
            this.hQV = 0;
        }
        if (z) {
            j jVar = j.UGJ;
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            aD = this.UvO + i2 + j.aD(context);
        } else {
            int i3 = this.UvN;
            j jVar2 = j.UGJ;
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            aD = i3 + j.aD(context2);
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.hwr.findViewById(R.id.k1j);
        if (relativeLayout != null) {
            layoutParams = relativeLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(262759);
            throw tVar;
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = aD;
        StringBuilder sb = new StringBuilder("layoutPostPanelWhenKeyBoardChange ");
        RelativeLayout relativeLayout2 = (RelativeLayout) this.hwr.findViewById(R.id.k1j);
        p.g(relativeLayout2, "root.postWishBtnArea");
        StringBuilder append = sb.append(relativeLayout2.getHeight()).append(' ').append(aD).append(' ');
        FrameLayout frameLayout = (FrameLayout) this.hwr.findViewById(R.id.k1k);
        p.g(frameLayout, "root.postWishPanelBackIv");
        StringBuilder append2 = append.append((int) frameLayout.getY()).append(' ');
        FrameLayout frameLayout2 = (FrameLayout) this.hwr.findViewById(R.id.k1k);
        p.g(frameLayout2, "root.postWishPanelBackIv");
        Log.d("FestivalFinderPostWishPlugin", append2.append(frameLayout2.getHeight()).toString());
        this.hwr.requestLayout();
        AppMethodBeat.o(262759);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return this.hQV == 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/os/Vibrator;", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<Vibrator> {
        final /* synthetic */ ViewGroup hOA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(ViewGroup viewGroup) {
            super(0);
            this.hOA = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Vibrator invoke() {
            AppMethodBeat.i(262749);
            Object systemService = this.hOA.getContext().getSystemService("vibrator");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.os.Vibrator");
                AppMethodBeat.o(262749);
                throw tVar;
            }
            Vibrator vibrator = (Vibrator) systemService;
            AppMethodBeat.o(262749);
            return vibrator;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ ViewGroup hOA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ViewGroup viewGroup) {
            super(0);
            this.hOA = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(262747);
            Integer valueOf = Integer.valueOf(av.az(this.hOA.getContext()).y);
            AppMethodBeat.o(262747);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<q> {
        final /* synthetic */ bf UvU;
        final /* synthetic */ ViewGroup hOA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(bf bfVar, ViewGroup viewGroup) {
            super(0);
            this.UvU = bfVar;
            this.hOA = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ q invoke() {
            AppMethodBeat.i(262746);
            q b2 = q.b(this.hOA.getContext(), this.hOA.getContext().getString(R.string.a06), true, 3, new DialogInterface.OnCancelListener(this) {
                /* class com.tencent.mm.plugin.festival.finder.bf.e.AnonymousClass1 */
                final /* synthetic */ e Uwb;

                {
                    this.Uwb = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(262745);
                    this.Uwb.UvU.UvQ = false;
                    AppMethodBeat.o(262745);
                }
            });
            AppMethodBeat.o(262746);
            return b2;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(262758);
        FestivalWishTopicPanel festivalWishTopicPanel = (FestivalWishTopicPanel) this.hwr.findViewById(R.id.k1q);
        p.g(festivalWishTopicPanel, "root.postWishTopicPanel");
        if (festivalWishTopicPanel.getVisibility() == 0) {
            ((FestivalWishTopicPanel) this.hwr.findViewById(R.id.k1q)).hide();
            AppMethodBeat.o(262758);
            return true;
        } else if (this.hwr.getVisibility() == 0) {
            eQ(true);
            AppMethodBeat.o(262758);
            return true;
        } else {
            boolean onBackPress = super.onBackPress();
            AppMethodBeat.o(262758);
            return onBackPress;
        }
    }

    public static final /* synthetic */ String bxt(String str) {
        int a2;
        AppMethodBeat.i(262764);
        if (str != null && (a2 = n.a((CharSequence) str, "#", 0, false, 6)) >= 0) {
            String substring = str.substring(a2);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            if (substring.length() != 1) {
                int a3 = n.a((CharSequence) substring, " ", 0, false, 6);
                if (a3 < 0) {
                    if (substring == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(262764);
                        throw tVar;
                    }
                    String substring2 = substring.substring(1);
                    p.g(substring2, "(this as java.lang.String).substring(startIndex)");
                    AppMethodBeat.o(262764);
                    return substring2;
                } else if (substring == null) {
                    t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(262764);
                    throw tVar2;
                } else {
                    String substring3 = substring.substring(1, a3);
                    p.g(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    AppMethodBeat.o(262764);
                    return substring3;
                }
            }
        }
        AppMethodBeat.o(262764);
        return "";
    }

    public static final /* synthetic */ boolean a(bf bfVar, String str) {
        AppMethodBeat.i(262767);
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(262767);
            throw tVar;
        } else if (com.tencent.mm.ui.tools.f.a(n.trim(str).toString(), f.a.MODE_CHINESE_AS_2) > 64) {
            Vibrator vibrator = bfVar.getVibrator();
            if (vibrator != null) {
                vibrator.vibrate(10);
            }
            u.u(bfVar.hwr.getContext(), bfVar.hwr.getContext().getString(R.string.j95), 0);
            AppMethodBeat.o(262767);
            return true;
        } else {
            AppMethodBeat.o(262767);
            return false;
        }
    }

    public static final /* synthetic */ boolean b(bf bfVar, String str) {
        AppMethodBeat.i(262768);
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(262768);
            throw tVar;
        } else if (com.tencent.mm.ui.tools.f.a(n.trim(str).toString(), f.a.MODE_CHINESE_AS_2) >= 64) {
            Vibrator vibrator = bfVar.getVibrator();
            if (vibrator != null) {
                vibrator.vibrate(10);
            }
            u.u(bfVar.hwr.getContext(), bfVar.hwr.getContext().getString(R.string.j95), 0);
            AppMethodBeat.o(262768);
            return true;
        } else {
            AppMethodBeat.o(262768);
            return false;
        }
    }
}
