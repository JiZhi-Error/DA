package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b*\u0002\u00115\u0018\u0000 Q2\u00020\u0001:\u0001QB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020=J\u0006\u0010?\u001a\u00020=J\u0006\u0010@\u001a\u00020=J\u0006\u0010A\u001a\u00020=J\u0006\u0010B\u001a\u00020=J\u000e\u0010C\u001a\u00020=2\u0006\u0010D\u001a\u00020\u0014J\u000e\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\u0014J\u0006\u0010G\u001a\u00020=J\u000e\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020=J\u0006\u0010L\u001a\u00020=J\u0018\u0010M\u001a\u00020=2\u0006\u0010N\u001a\u00020\t2\b\b\u0002\u0010O\u001a\u00020\tJ\u0016\u0010M\u001a\u00020=2\u0006\u0010I\u001a\u00020J2\u0006\u0010O\u001a\u00020\tJ\u0006\u0010P\u001a\u00020=R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b3\u0010&\u001a\u0004\b2\u0010/R\u0010\u00104\u001a\u000205X\u0004¢\u0006\u0004\n\u0002\u00106R\u001b\u00107\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\b;\u0010&\u001a\u0004\b9\u0010:¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", ShareConstants.RES_PATH, "during", "showSearchingTips", "Companion", "plugin-radar_release"})
public final class RadarTipsView extends RelativeLayout {
    private static final int BAQ = 3;
    private static final int BAR = 0;
    static final int BAS = 1;
    static final int BAT = 2;
    private static final int BAU = 3;
    public static final a BAV = new a((byte) 0);
    static final String TAG = TAG;
    private final kotlin.f BAA = i.aq(this, R.id.gqi);
    private final kotlin.f BAB = i.aq(this, R.id.gql);
    private final int BAC;
    final int BAD = 1;
    final int BAE = 2;
    private final int BAF = 3;
    private final int BAG = 3;
    final f BAH = new f(this, Looper.getMainLooper());
    boolean BAI;
    private boolean BAJ = true;
    boolean BAK;
    boolean BAL;
    private int BAM;
    private long BAN;
    private boolean BAO;
    int BAP = BAR;
    private final b BAw = new b(this);
    private final kotlin.f BAx = g.ah(new d(this));
    private final kotlin.f BAy = g.ah(new e(this));
    private final kotlin.f BAz = i.aq(this, R.id.gqk);

    private final Animation getTipsFadeOut() {
        AppMethodBeat.i(138713);
        Animation animation = (Animation) this.BAy.getValue();
        AppMethodBeat.o(138713);
        return animation;
    }

    private final TextView getTvTextTips() {
        AppMethodBeat.i(138714);
        TextView textView = (TextView) this.BAz.getValue();
        AppMethodBeat.o(138714);
        return textView;
    }

    /* access modifiers changed from: package-private */
    public final LinearLayout getNoviceEducationTips() {
        AppMethodBeat.i(138716);
        LinearLayout linearLayout = (LinearLayout) this.BAB.getValue();
        AppMethodBeat.o(138716);
        return linearLayout;
    }

    /* access modifiers changed from: package-private */
    public final View getTextTipsContainer() {
        AppMethodBeat.i(138715);
        View view = (View) this.BAA.getValue();
        AppMethodBeat.o(138715);
        return view;
    }

    /* access modifiers changed from: package-private */
    public final Animation getTipsFadeIn() {
        AppMethodBeat.i(138712);
        Animation animation = (Animation) this.BAx.getValue();
        AppMethodBeat.o(138712);
        return animation;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class b extends MMHandler {
        final /* synthetic */ RadarTipsView BAW;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(RadarTipsView radarTipsView) {
            this.BAW = radarTipsView;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(138703);
            p.h(message, "msg");
            this.BAW.setVisibility(8);
            AppMethodBeat.o(138703);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<Animation> {
        final /* synthetic */ RadarTipsView BAW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(RadarTipsView radarTipsView) {
            super(0);
            this.BAW = radarTipsView;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
        public static final class a implements Animation.AnimationListener {
            final /* synthetic */ e BAX;

            a(e eVar) {
                this.BAX = eVar;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(138706);
                p.h(animation, "animation");
                AppMethodBeat.o(138706);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(138707);
                p.h(animation, "animation");
                if (!this.BAX.BAW.BAI) {
                    this.BAX.BAW.BAw.sendEmptyMessage(0);
                }
                AppMethodBeat.o(138707);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(138708);
                p.h(animation, "animation");
                AppMethodBeat.o(138708);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Animation invoke() {
            AppMethodBeat.i(138709);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.BAW.getContext(), R.anim.dy);
            loadAnimation.setAnimationListener(new a(this));
            AppMethodBeat.o(138709);
            return loadAnimation;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class f extends MMHandler {
        final /* synthetic */ RadarTipsView BAW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(RadarTipsView radarTipsView, Looper looper) {
            super(looper);
            this.BAW = radarTipsView;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(138710);
            p.h(message, "msg");
            int i2 = message.what;
            if (i2 == this.BAW.BAC) {
                this.BAW.eHy();
                AppMethodBeat.o(138710);
                return;
            }
            if (i2 == this.BAW.BAD) {
                if (this.BAW.BAJ && this.BAW.BAL) {
                    RadarTipsView.a(this.BAW);
                    AppMethodBeat.o(138710);
                    return;
                }
            } else if (i2 == this.BAW.BAF) {
                RadarTipsView radarTipsView = this.BAW;
                radarTipsView.BAI = true;
                radarTipsView.BAP = RadarTipsView.BAT;
                Log.d(RadarTipsView.TAG, "showNoviceEducation");
                radarTipsView.BAK = true;
                radarTipsView.getTextTipsContainer().setVisibility(8);
                radarTipsView.getTextTipsContainer().clearAnimation();
                radarTipsView.setVisibility(0);
                radarTipsView.getNoviceEducationTips().setVisibility(0);
                radarTipsView.getNoviceEducationTips().startAnimation(radarTipsView.getTipsFadeIn());
                radarTipsView.getNoviceEducationTips().requestFocus();
                AppMethodBeat.o(138710);
                return;
            } else if (i2 == this.BAW.BAG) {
                this.BAW.eHx();
            }
            AppMethodBeat.o(138710);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(138725);
        AppMethodBeat.o(138725);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarTipsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(138726);
        AppMethodBeat.o(138726);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ RadarTipsView BAW;

        c(RadarTipsView radarTipsView) {
            this.BAW = radarTipsView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138704);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/RadarTipsView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.d(RadarTipsView.TAG, "noviceEducationTips onclick");
            this.BAW.eHx();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarTipsView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(138704);
        }
    }

    private void fh(String str, int i2) {
        AppMethodBeat.i(138718);
        p.h(str, "msg");
        this.BAI = true;
        getNoviceEducationTips().setVisibility(8);
        getNoviceEducationTips().clearAnimation();
        getTvTextTips().setText(str);
        setVisibility(0);
        getTextTipsContainer().setVisibility(0);
        getTextTipsContainer().startAnimation(getTipsFadeIn());
        this.BAH.removeMessages(this.BAC);
        this.BAH.removeMessages(this.BAE);
        if (i2 > 0) {
            this.BAH.sendEmptyMessageDelayed(this.BAC, (long) i2);
        }
        AppMethodBeat.o(138718);
    }

    public final void aKP(String str) {
        AppMethodBeat.i(138719);
        p.h(str, "msg");
        this.BAP = BAU;
        fh(str, 5000);
        AppMethodBeat.o(138719);
    }

    public final void eHx() {
        AppMethodBeat.i(138720);
        this.BAI = false;
        this.BAP = BAR;
        Log.d(TAG, "hidNoviceEducation");
        this.BAH.removeMessages(this.BAF);
        if (getVisibility() == 0 && getNoviceEducationTips().getVisibility() == 0) {
            getNoviceEducationTips().clearAnimation();
            if (getTextTipsContainer().getAnimation() == getTipsFadeOut()) {
                getTextTipsContainer().clearAnimation();
            }
            Log.d(TAG, "hideNoviceEducation real");
            getNoviceEducationTips().startAnimation(getTipsFadeOut());
        }
        AppMethodBeat.o(138720);
    }

    public final void setNoMember(boolean z) {
        AppMethodBeat.i(138721);
        this.BAJ = z;
        if (!this.BAJ) {
            eHy();
            eHz();
            eHx();
        }
        AppMethodBeat.o(138721);
    }

    public final void setPressingDown(boolean z) {
        AppMethodBeat.i(138722);
        if (this.BAN != 0) {
            this.BAP = BAR;
            eHz();
            eHy();
            getTextTipsContainer().setVisibility(8);
            getNoviceEducationTips().setVisibility(8);
            setVisibility(8);
        }
        this.BAL = true;
        this.BAN = Util.currentTicks();
        this.BAO = z;
        this.BAM++;
        AppMethodBeat.o(138722);
    }

    public final void eHy() {
        AppMethodBeat.i(138723);
        Log.d(TAG, "hideRadarTips");
        if (getVisibility() == 0 && getTextTipsContainer().getVisibility() == 0) {
            if (getNoviceEducationTips().getAnimation() == getTipsFadeOut()) {
                getNoviceEducationTips().clearAnimation();
            }
            getTextTipsContainer().clearAnimation();
            Log.d(TAG, "hideRadarTips real");
            this.BAP = BAR;
            this.BAI = false;
            getTextTipsContainer().startAnimation(getTipsFadeOut());
        }
        AppMethodBeat.o(138723);
    }

    private void eHz() {
        AppMethodBeat.i(138724);
        this.BAI = false;
        f fVar = this.BAH;
        fVar.removeMessages(this.BAD);
        fVar.removeMessages(this.BAE);
        fVar.removeMessages(this.BAF);
        AppMethodBeat.o(138724);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$Companion;", "", "()V", "PressTooShortCountThreshold", "", "TAG", "", "TIPS_PURPOSE_ERROR_MESSAGE", "TIPS_PURPOSE_NORMAL", "TIPS_PURPOSE_NOVICE_EDUCATION", "TIPS_PURPOSE_SHEARING", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138711);
        AppMethodBeat.o(138711);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Animation> {
        final /* synthetic */ RadarTipsView BAW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(RadarTipsView radarTipsView) {
            super(0);
            this.BAW = radarTipsView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Animation invoke() {
            AppMethodBeat.i(138705);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.BAW.getContext(), R.anim.dx);
            AppMethodBeat.o(138705);
            return loadAnimation;
        }
    }

    public static /* synthetic */ void a(RadarTipsView radarTipsView) {
        AppMethodBeat.i(138717);
        String string = radarTipsView.getContext().getString(R.string.ftd);
        p.g(string, "context.getString(res)");
        radarTipsView.fh(string, -1);
        AppMethodBeat.o(138717);
    }
}
