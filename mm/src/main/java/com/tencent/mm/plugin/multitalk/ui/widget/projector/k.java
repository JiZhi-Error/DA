package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u00108\u001a\u000209H\u0002J\u0006\u0010:\u001a\u000209J\u0018\u0010;\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=J\u0018\u0010>\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=J\u000e\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020\u0018J\u001a\u0010A\u001a\u0002092\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010B\u001a\u0004\u0018\u00010CJ\u0010\u0010D\u001a\u0002092\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u0010\u0010.\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "bottomUiLayout", "Landroid/view/View;", "getBottomUiLayout", "()Landroid/view/View;", "setBottomUiLayout", "(Landroid/view/View;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isTouchEnable", "", "mCloseDoodleLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getMCloseDoodleLayout", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setMCloseDoodleLayout", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "mDoodleFinishIv", "getMDoodleFinishIv", "setMDoodleFinishIv", "mDoodleLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "getMDoodleLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "setMDoodleLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;)V", "mIsDoodleFuncSupport", "mIsMoreFuncSupport", "mIsTextFuncSupport", "mMicMuteLayout", "getMMicMuteLayout", "setMMicMuteLayout", "mMoreControlIv", "mSpeakerLayout", "getMSpeakerLayout", "setMSpeakerLayout", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "toastView", "Landroid/widget/Toast;", "applyClickEvent", "", "clearScreen", "getLandScapeLayout", "rootView", "Landroid/widget/FrameLayout;", "getPortraitLayout", "setEnable", "enable", "showCenterToast", "text", "", "showListBottomSheet", "showReaderContent", "show", "plugin-multitalk_release"})
public final class k {
    Context context;
    a zQD;
    e zQw;
    View zWH;
    MultiTalkSmallControlIconLayout zWI;
    WeImageView zWJ;
    MultiTalkSmallControlIconLayout zWK;
    MultiTalkSmallControlIconLayout zWL;
    private Toast zWM;
    boolean zWN;
    private boolean zWO;
    private boolean zWP;
    WeImageView zWQ;
    boolean zWR;

    public k(Context context2, a aVar, e eVar) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        p.h(context2, "context");
        p.h(aVar, "statusManager");
        AppMethodBeat.i(240019);
        this.context = context2;
        this.zQD = aVar;
        this.zQw = eVar;
        e eVar2 = this.zQw;
        if (eVar2 != null) {
            z = eVar2.Rx(3);
        } else {
            z = false;
        }
        this.zWN = z;
        e eVar3 = this.zQw;
        if (eVar3 != null) {
            z2 = eVar3.Rx(1);
        } else {
            z2 = false;
        }
        this.zWO = z2;
        e eVar4 = this.zQw;
        this.zWP = eVar4 != null ? eVar4.Rx(2) : z3;
        AppMethodBeat.o(240019);
    }

    /* access modifiers changed from: package-private */
    public final void epA() {
        WeImageView weImageView;
        int i2;
        int i3;
        int i4 = 4;
        AppMethodBeat.i(240017);
        if (this.zWO) {
            View view = this.zWH;
            this.zWJ = view != null ? (WeImageView) view.findViewById(R.id.b4a) : null;
            WeImageView weImageView2 = this.zWJ;
            if (weImageView2 != null) {
                weImageView2.setImageDrawable(ar.m(this.context, R.raw.icons_filled_close, -1));
            }
            WeImageView weImageView3 = this.zWJ;
            if (weImageView3 != null) {
                weImageView3.setIconColor(-1);
            }
            WeImageView weImageView4 = this.zWJ;
            if (weImageView4 != null) {
                weImageView4.setOnClickListener(new a(this));
            }
            View view2 = this.zWH;
            this.zWI = view2 != null ? (MultiTalkSmallControlIconLayout) view2.findViewById(R.id.bt6) : null;
            if (this.zQD.epg()) {
                MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout = this.zWI;
                if (multiTalkSmallControlIconLayout != null) {
                    multiTalkSmallControlIconLayout.setVisibility(8);
                }
                WeImageView weImageView5 = this.zWJ;
                if (weImageView5 != null) {
                    weImageView5.setVisibility(0);
                }
            } else {
                MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout2 = this.zWI;
                if (multiTalkSmallControlIconLayout2 != null) {
                    multiTalkSmallControlIconLayout2.setVisibility(0);
                }
            }
            MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout3 = this.zWI;
            if (multiTalkSmallControlIconLayout3 != null) {
                multiTalkSmallControlIconLayout3.setChecked(this.zQD.epg());
            }
            MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout4 = this.zWI;
            if (multiTalkSmallControlIconLayout4 != null) {
                multiTalkSmallControlIconLayout4.setOnClickListener(new b(this));
            }
        }
        View view3 = this.zWH;
        this.zWK = view3 != null ? (MultiTalkSmallControlIconLayout) view3.findViewById(R.id.fec) : null;
        MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout5 = this.zWK;
        if (multiTalkSmallControlIconLayout5 != null) {
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            multiTalkSmallControlIconLayout5.setChecked(eom.Zx());
        }
        MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout6 = this.zWK;
        if (multiTalkSmallControlIconLayout6 != null) {
            if (this.zQD.epg()) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            multiTalkSmallControlIconLayout6.setVisibility(i3);
        }
        MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout7 = this.zWK;
        if (multiTalkSmallControlIconLayout7 != null) {
            multiTalkSmallControlIconLayout7.setOnClickListener(new c(this));
        }
        View view4 = this.zWH;
        this.zWL = view4 != null ? (MultiTalkSmallControlIconLayout) view4.findViewById(R.id.i3d) : null;
        MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout8 = this.zWL;
        if (multiTalkSmallControlIconLayout8 != null) {
            q eom2 = ac.eom();
            p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
            multiTalkSmallControlIconLayout8.setChecked(eom2.enq());
        }
        MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout9 = this.zWL;
        if (multiTalkSmallControlIconLayout9 != null) {
            multiTalkSmallControlIconLayout9.setOnClickListener(new d(this));
        }
        MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout10 = this.zWL;
        if (multiTalkSmallControlIconLayout10 != null) {
            if (this.zQD.epg()) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            multiTalkSmallControlIconLayout10.setVisibility(i2);
        }
        if (this.zWN) {
            View view5 = this.zWH;
            if (view5 != null) {
                weImageView = (WeImageView) view5.findViewById(R.id.fki);
            } else {
                weImageView = null;
            }
            this.zWQ = weImageView;
            WeImageView weImageView6 = this.zWQ;
            if (weImageView6 != null) {
                weImageView6.setImageDrawable(ar.m(this.context, R.raw.icons_filled_more, this.context.getResources().getColor(R.color.am)));
            }
            WeImageView weImageView7 = this.zWQ;
            if (weImageView7 != null) {
                weImageView7.setIconColor(this.context.getResources().getColor(R.color.am));
            }
            WeImageView weImageView8 = this.zWQ;
            if (weImageView8 != null) {
                if (!this.zQD.epg()) {
                    i4 = 0;
                }
                weImageView8.setVisibility(i4);
            }
            WeImageView weImageView9 = this.zWQ;
            if (weImageView9 != null) {
                weImageView9.setOnClickListener(new e(this));
                AppMethodBeat.o(240017);
                return;
            }
        }
        AppMethodBeat.o(240017);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ k zWS;

        a(k kVar) {
            this.zWS = kVar;
        }

        public final void onClick(View view) {
            WeImageView weImageView;
            AppMethodBeat.i(240008);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.zWS.zWR) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(240008);
                return;
            }
            MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout = this.zWS.zWI;
            if (multiTalkSmallControlIconLayout != null) {
                multiTalkSmallControlIconLayout.setChecked(false);
            }
            MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout2 = this.zWS.zWI;
            if (multiTalkSmallControlIconLayout2 != null) {
                multiTalkSmallControlIconLayout2.setVisibility(0);
            }
            a.b.a(this.zWS.zQD, a.c.HIDE_DOODLE_LAYOUT);
            MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout3 = this.zWS.zWK;
            if (multiTalkSmallControlIconLayout3 != null) {
                multiTalkSmallControlIconLayout3.setVisibility(0);
            }
            MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout4 = this.zWS.zWL;
            if (multiTalkSmallControlIconLayout4 != null) {
                multiTalkSmallControlIconLayout4.setVisibility(0);
            }
            if (this.zWS.zWN && (weImageView = this.zWS.zWQ) != null) {
                weImageView.setVisibility(0);
            }
            WeImageView weImageView2 = this.zWS.zWJ;
            if (weImageView2 != null) {
                weImageView2.setVisibility(8);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240008);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ k zWS;

        b(k kVar) {
            this.zWS = kVar;
        }

        public final void onClick(View view) {
            WeImageView weImageView;
            WeImageView weImageView2;
            AppMethodBeat.i(240009);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.zWS.zWR) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(240009);
                return;
            }
            MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout = this.zWS.zWI;
            if (multiTalkSmallControlIconLayout != null) {
                q eom = ac.eom();
                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                com.tencent.mm.plugin.multitalk.model.p.n(eom.enn().zHD, 1, 7, 1);
                com.tencent.mm.plugin.multitalk.d.f fVar = com.tencent.mm.plugin.multitalk.d.f.zZd;
                com.tencent.mm.plugin.multitalk.d.f.eqp();
                if (!multiTalkSmallControlIconLayout.zVH) {
                    a.b.a(this.zWS.zQD, a.c.SHOW_DOODLE_LAYOUT);
                    multiTalkSmallControlIconLayout.setChecked(true);
                    MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout2 = this.zWS.zWK;
                    if (multiTalkSmallControlIconLayout2 != null) {
                        multiTalkSmallControlIconLayout2.setVisibility(8);
                    }
                    MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout3 = this.zWS.zWL;
                    if (multiTalkSmallControlIconLayout3 != null) {
                        multiTalkSmallControlIconLayout3.setVisibility(8);
                    }
                    if (this.zWS.zWN && (weImageView2 = this.zWS.zWQ) != null) {
                        weImageView2.setVisibility(8);
                    }
                    MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout4 = this.zWS.zWI;
                    if (multiTalkSmallControlIconLayout4 != null) {
                        multiTalkSmallControlIconLayout4.setVisibility(8);
                    }
                    WeImageView weImageView3 = this.zWS.zWJ;
                    if (weImageView3 != null) {
                        weImageView3.setVisibility(0);
                    }
                } else {
                    a.b.a(this.zWS.zQD, a.c.HIDE_DOODLE_LAYOUT);
                    multiTalkSmallControlIconLayout.setChecked(false);
                    MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout5 = this.zWS.zWK;
                    if (multiTalkSmallControlIconLayout5 != null) {
                        multiTalkSmallControlIconLayout5.setVisibility(0);
                    }
                    MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout6 = this.zWS.zWL;
                    if (multiTalkSmallControlIconLayout6 != null) {
                        multiTalkSmallControlIconLayout6.setVisibility(0);
                    }
                    if (this.zWS.zWN && (weImageView = this.zWS.zWQ) != null) {
                        weImageView.setVisibility(0);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240009);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ k zWS;

        c(k kVar) {
            this.zWS = kVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240011);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.zWS.zWR) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(240011);
                return;
            }
            MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout = this.zWS.zWK;
            if (multiTalkSmallControlIconLayout != null) {
                com.tencent.mm.plugin.multitalk.d.f fVar = com.tencent.mm.plugin.multitalk.d.f.zZd;
                com.tencent.mm.plugin.multitalk.d.f.eqq();
                q eom = ac.eom();
                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                com.tencent.mm.plugin.multitalk.model.p.n(eom.enn().zHD, 1, 5, 1);
                if (!multiTalkSmallControlIconLayout.zVH) {
                    this.zWS.bh(this.zWS.context, this.zWS.context.getResources().getString(R.string.gem));
                    multiTalkSmallControlIconLayout.setChecked(true);
                } else {
                    this.zWS.bh(this.zWS.context, this.zWS.context.getResources().getString(R.string.gel));
                    multiTalkSmallControlIconLayout.setChecked(false);
                }
                h.RTc.aX(new a(multiTalkSmallControlIconLayout));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240011);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ MultiTalkSmallControlIconLayout zWT;

            a(MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout) {
                this.zWT = multiTalkSmallControlIconLayout;
            }

            public final void run() {
                AppMethodBeat.i(240010);
                ac.eom().rK(this.zWT.zVH);
                AppMethodBeat.o(240010);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ k zWS;

        d(k kVar) {
            this.zWS = kVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240013);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.zWS.zWR) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(240013);
                return;
            }
            MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout = this.zWS.zWL;
            if (multiTalkSmallControlIconLayout != null) {
                com.tencent.mm.plugin.multitalk.d.f fVar = com.tencent.mm.plugin.multitalk.d.f.zZd;
                com.tencent.mm.plugin.multitalk.d.f.eqr();
                q eom = ac.eom();
                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                com.tencent.mm.plugin.multitalk.model.p.n(eom.enn().zHD, 1, 6, 1);
                if (multiTalkSmallControlIconLayout.isEnabled()) {
                    if (!multiTalkSmallControlIconLayout.zVH) {
                        this.zWS.bh(this.zWS.context, this.zWS.context.getResources().getString(R.string.gf4));
                        multiTalkSmallControlIconLayout.setChecked(true);
                    } else {
                        this.zWS.bh(this.zWS.context, this.zWS.context.getResources().getString(R.string.gf3));
                        multiTalkSmallControlIconLayout.setChecked(false);
                    }
                    h.RTc.aX(new a(multiTalkSmallControlIconLayout));
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240013);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ MultiTalkSmallControlIconLayout zWT;

            a(MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout) {
                this.zWT = multiTalkSmallControlIconLayout;
            }

            public final void run() {
                AppMethodBeat.i(240012);
                ac.eom().rJ(this.zWT.zVH);
                AppMethodBeat.o(240012);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ k zWS;

        e(k kVar) {
            this.zWS = kVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240014);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.zWS.zWR) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(240014);
                return;
            }
            k kVar = this.zWS;
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.zWS.context, 1, false);
            eVar.a(new f(kVar));
            eVar.hbr();
            eVar.a(new g(kVar));
            eVar.Dm(false);
            eVar.dGm();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240014);
        }
    }

    public final void bh(Context context2, String str) {
        AppMethodBeat.i(240018);
        Toast toast = this.zWM;
        if (toast != null) {
            toast.cancel();
        }
        this.zWM = Toast.makeText(context2, "", 0);
        View inflate = View.inflate(context2, R.layout.bdc, null);
        View findViewById = inflate.findViewById(R.id.ird);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(240018);
            throw tVar;
        }
        ((TextView) findViewById).setText(str);
        Toast toast2 = this.zWM;
        if (toast2 != null) {
            toast2.setGravity(17, 0, 0);
        }
        Toast toast3 = this.zWM;
        if (toast3 != null) {
            toast3.setView(inflate);
        }
        Toast toast4 = this.zWM;
        if (toast4 != null) {
            toast4.show();
            AppMethodBeat.o(240018);
            return;
        }
        AppMethodBeat.o(240018);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class f implements o.f {
        final /* synthetic */ k zWS;

        f(k kVar) {
            this.zWS = kVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            HashSet<e.c> hashSet;
            AppMethodBeat.i(240015);
            e eVar = this.zWS.zQw;
            if (eVar == null || (hashSet = eVar.zWf) == null) {
                AppMethodBeat.o(240015);
                return;
            }
            for (T t : hashSet) {
                mVar.a(t.zWi, -1, t.name);
            }
            AppMethodBeat.o(240015);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class g implements o.g {
        final /* synthetic */ k zWS;

        g(k kVar) {
            this.zWS = kVar;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout;
            AppMethodBeat.i(240016);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 5:
                    a.b.a(this.zWS.zQD, a.c.SEND_TO_FRIEND);
                    break;
                case 6:
                    a.b.a(this.zWS.zQD, a.c.SAVE_TO_FAV);
                    AppMethodBeat.o(240016);
                    return;
                case 7:
                    a.b.a(this.zWS.zQD, a.c.SAVE_TO_PICTURE);
                    AppMethodBeat.o(240016);
                    return;
                case 8:
                    q eom = ac.eom();
                    p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                    com.tencent.mm.plugin.multitalk.model.p.n(eom.enn().zHD, 1, 8, 1);
                    k kVar = this.zWS;
                    MultiTalkSmallControlIconLayout multiTalkSmallControlIconLayout2 = kVar.zWI;
                    if (!(multiTalkSmallControlIconLayout2 == null || !multiTalkSmallControlIconLayout2.zVH || (multiTalkSmallControlIconLayout = kVar.zWI) == null)) {
                        multiTalkSmallControlIconLayout.callOnClick();
                    }
                    a.b.a(this.zWS.zQD, a.c.CLEAR_SCREEN);
                    AppMethodBeat.o(240016);
                    return;
            }
            AppMethodBeat.o(240016);
        }
    }
}
