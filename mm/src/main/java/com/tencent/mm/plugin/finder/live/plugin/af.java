package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.util.j;
import com.tencent.mm.plugin.finder.live.util.p;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGiftSendBtn;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001HB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\b2\u0006\u0010(\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010*\u001a\u00020\u000eH\u0002J\"\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010-\u001a\u00020\u000eH\u0002J\b\u0010.\u001a\u00020\u0014H\u0016J\b\u0010/\u001a\u00020&H\u0002J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020&H\u0002J\b\u00102\u001a\u00020\u0014H\u0016J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u00020&H\u0016J,\u00105\u001a\u00020&2\u0006\u0010,\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\b2\b\b\u0002\u00106\u001a\u00020\u0014H\u0002J\b\u00107\u001a\u00020&H\u0002J\b\u00108\u001a\u00020&H\u0002J\u0012\u00109\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010:\u001a\u00020&2\u0006\u00101\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u00020&H\u0016J\u0017\u0010@\u001a\u00020&2\b\u0010A\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0002\u0010CJ\u0018\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020GH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "continuousClickCallback", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "continuousClickManager", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager;", "curComboCount", "", "curComboId", "curGiftId", "entranceNotAvailabComboId", "memberListAutoRefreshValue", "networkEnable", "", "notEnoughWecoinComboId", "notifyMemberListRefresh", "sendBtn", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftSendBtn;", "sendGiftCallback", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftTargetUserName", "sendLocalGiftToMsg", "vibrator", "", "kotlin.jvm.PlatformType", "wecoinDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "wecoinEntranceNotAvailableDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "wecoinNotEnoughDialog", "addLocalGiftMsg", "", "rewardGiftId", "rewardGiftCnt", "comboId", "diffCnt", "addSelfGiftToComment", "giftId", "comboCount", "canClearScreen", "hideGiftSendAgainLayout", "networkChange", "status", "onBackPress", "resetSelfGiftParams", "resume", "sendGift", "canShowNotEnoughDialog", "showConsumeFailDialog", "showGiftSendAgainLayout", "showWecoinNotEnoughDialog", "statusChange", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopGiftSending", "unMount", "uodateWecoinBalance", "balance", "", "(Ljava/lang/Long;)V", "vibrateAndShowGiftAnimation", "clickCnt", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "ISendGiftCallback", "plugin-finder_release"})
public final class af extends d {
    final String TAG = "Finder.FinderLiveGiftSendPlugin";
    String UMp;
    String UMq;
    com.tencent.mm.ui.widget.a.d UMr;
    String UMs;
    com.tencent.mm.ui.widget.a.d UMt;
    final com.tencent.mm.live.c.b hOp;
    final Object hQn;
    com.tencent.mm.plugin.wallet.wecoin.a.d upj;
    String upm;
    boolean uqA;
    boolean uqB;
    int uqC;
    String uqt;
    int uqu;
    j.a uqv;
    FinderLiveGiftSendBtn uqw;
    j uqx;
    a uqy;
    volatile boolean uqz;

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0011JM\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;)V", "ErrorType", "plugin-finder_release"})
    public interface a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "", "(Ljava/lang/String;I)V", "OK", "NETWORK", "WECOIN", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.live.plugin.af$a$a  reason: collision with other inner class name */
        public enum EnumC1189a {
            OK,
            NETWORK,
            WECOIN;

            static {
                AppMethodBeat.i(246730);
                AppMethodBeat.o(246730);
            }

            public static EnumC1189a valueOf(String str) {
                AppMethodBeat.i(246732);
                EnumC1189a aVar = (EnumC1189a) Enum.valueOf(EnumC1189a.class, str);
                AppMethodBeat.o(246732);
                return aVar;
            }
        }

        void a(boolean z, int i2, EnumC1189a aVar, String str, Long l, int i3, String str2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public af(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        boolean z;
        boolean z2 = true;
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246750);
        this.hOp = bVar;
        this.hQn = viewGroup.getContext().getSystemService("vibrator");
        this.uqw = (FinderLiveGiftSendBtn) viewGroup;
        this.UMp = "";
        this.UMq = "";
        this.UMs = "";
        this.uqz = true;
        this.uqA = true;
        this.uqB = true;
        viewGroup.post(new Runnable() {
            /* class com.tencent.mm.plugin.finder.live.plugin.af.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(246725);
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(246725);
                    throw tVar;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
                AppMethodBeat.o(246725);
            }
        });
        this.uqv = new j.a(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.af.AnonymousClass2 */
            final /* synthetic */ af uqD;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.uqD = r1;
            }

            @Override // com.tencent.mm.plugin.finder.live.util.j.a
            public final boolean a(int i2, j.b bVar, String str, int i3) {
                p.c cVar;
                String str2;
                boolean z = false;
                AppMethodBeat.i(246727);
                kotlin.g.b.p.h(bVar, "state");
                kotlin.g.b.p.h(str, "comboId");
                com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
                s atA = com.tencent.mm.plugin.finder.live.model.e.atA(this.uqD.upm);
                if (atA != null) {
                    int i4 = (int) atA.field_price;
                    boolean z2 = this.uqD.getLiveData().uEM >= ((long) i4);
                    com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.uqD.getLiveData();
                    liveData.EN(liveData.uEM - ((long) i4));
                    if (z2) {
                        af afVar = this.uqD;
                        String str3 = this.uqD.upm;
                        afVar.uqt = str;
                        afVar.uqu = i2;
                        com.tencent.mm.plugin.finder.live.model.e eVar2 = com.tencent.mm.plugin.finder.live.model.e.uiD;
                        boolean atB = com.tencent.mm.plugin.finder.live.model.e.atB(str3);
                        com.tencent.mm.plugin.finder.live.model.e eVar3 = com.tencent.mm.plugin.finder.live.model.e.uiD;
                        s atA2 = com.tencent.mm.plugin.finder.live.model.e.atA(str3);
                        if (atA2 != null) {
                            aut aut = new aut();
                            auz auz = new auz();
                            auz.LFM = atA2.field_rewardProductId;
                            aut.LFB = com.tencent.mm.bw.b.cD(auz.toByteArray());
                            avn avn = new avn();
                            m mVar = m.vVH;
                            avn.contact = m.m(afVar.getLiveData());
                            aut.LFE = avn;
                            aut.ybm = 20009;
                            p.b bVar2 = new p.b(aut);
                            bVar2.upR = str;
                            bVar2.upS = i2;
                            if (bVar2.upS > 1) {
                                if (atB) {
                                    cVar = p.c.SELF_PRECIOUS_GIFT_COMBO;
                                } else {
                                    cVar = p.c.SELF_NORMAL_GIFT_COMBO;
                                }
                            } else if (atB) {
                                cVar = p.c.SELF_PRECIOUS_GIFT_SOLO;
                            } else {
                                cVar = p.c.SELF_NORMAL_GIFT_SOLO;
                            }
                            bVar2.c(cVar);
                            if (afVar.UMp.length() == 0) {
                                z = true;
                            }
                            if (z) {
                                str2 = afVar.getLiveData().hwd;
                            } else {
                                str2 = afVar.UMp;
                            }
                            bVar2.bxH(str2);
                            Log.i(afVar.TAG, "addLocalGiftMsg local add GiftShowInfo:" + bVar2 + ",diffCnt:" + i3);
                            afVar.getLiveData().uDw.a(bVar2);
                        } else {
                            Log.i(afVar.TAG, "addLocalGiftMsg giftInfo is null,giftId:" + str3 + ",cnt:" + i2 + ",comboId:" + str + ",diffCnt:" + i3);
                        }
                        com.tencent.mm.ac.d.h(new a(this, i2, bVar));
                        AppMethodBeat.o(246727);
                        return true;
                    }
                    Log.i(this.uqD.TAG, "instantCallback no haveEnoughBalanceToConsume cnt:" + i2 + ",curBalance:" + this.uqD.getLiveData().uEM + ", diffCnt:" + i3);
                    af.a(this.uqD);
                    af.a(this.uqD, str);
                    AppMethodBeat.o(246727);
                    return false;
                }
                Log.i(this.uqD.TAG, "instantCallback giftInfo empty,curBalance:" + this.uqD.getLiveData().uEM + ", cnt:" + i2 + ",comboId:" + str + ", diffCnt:" + i3);
                AppMethodBeat.o(246727);
                return false;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0104, code lost:
                if (r12 > 0) goto L_0x0106;
             */
            @Override // com.tencent.mm.plugin.finder.live.util.j.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean a(int r11, int r12, com.tencent.mm.plugin.finder.live.util.j.b r13, java.lang.String r14, boolean r15) {
                /*
                // Method dump skipped, instructions count: 484
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.af.AnonymousClass2.a(int, int, com.tencent.mm.plugin.finder.live.util.j$b, java.lang.String, boolean):boolean");
            }

            @Override // com.tencent.mm.plugin.finder.live.util.j.a
            public final void V(MotionEvent motionEvent) {
                AppMethodBeat.i(246729);
                kotlin.g.b.p.h(motionEvent, "event");
                FinderLiveGiftSendBtn finderLiveGiftSendBtn = this.uqD.uqw;
                com.tencent.mm.ac.d.a(finderLiveGiftSendBtn.uyA, finderLiveGiftSendBtn.uyF);
                AppMethodBeat.o(246729);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.af$2$a */
            static final class a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ AnonymousClass2 uqE;
                final /* synthetic */ int uqF;
                final /* synthetic */ j.b uqG;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(AnonymousClass2 r2, int i2, j.b bVar) {
                    super(0);
                    this.uqE = r2;
                    this.uqF = i2;
                    this.uqG = bVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    boolean z;
                    AppMethodBeat.i(246726);
                    af afVar = this.uqE.uqD;
                    j.b bVar = this.uqG;
                    com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
                    boolean bg = com.tencent.mm.plugin.finder.live.model.e.bg(afVar.upm, false);
                    if (afVar.upm != null && bg) {
                        if (afVar.hQn instanceof Vibrator) {
                            ((Vibrator) afVar.hQn).vibrate(50);
                        }
                        com.tencent.mm.ac.d.C(afVar.uqw.uyF);
                        FinderLiveGiftSendBtn finderLiveGiftSendBtn = afVar.uqw;
                        if (bVar == j.b.LONG_CLICK) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Log.i(finderLiveGiftSendBtn.TAG, "showContinueClickSendAgaim longClick:".concat(String.valueOf(z)));
                        if (!kotlin.g.b.p.j(finderLiveGiftSendBtn.uyC.getPath(), finderLiveGiftSendBtn.uyD)) {
                            finderLiveGiftSendBtn.diu();
                            finderLiveGiftSendBtn.atQ(finderLiveGiftSendBtn.uyD);
                            finderLiveGiftSendBtn.uyC.setRepeatCount(1);
                        }
                        finderLiveGiftSendBtn.uyC.setProgress(0.0d);
                        finderLiveGiftSendBtn.uyC.play();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(246726);
                    return xVar;
                }
            }
        };
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue = com.tencent.mm.plugin.finder.storage.c.dwg().value().intValue();
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.uqC = com.tencent.mm.plugin.finder.storage.c.dwe().value().intValue() * 1000;
        if (intValue == 0) {
            z = true;
        } else {
            z = false;
        }
        this.uqA = z;
        this.uqB = this.uqC < 0 ? false : z2;
        Log.i(this.TAG, "sendLocalGiftToMsgValue :" + intValue + ",memberListAutoRefreshValue:" + this.uqC);
        AppMethodBeat.o(246750);
    }

    /* access modifiers changed from: package-private */
    public final void dhq() {
        AppMethodBeat.i(246744);
        com.tencent.mm.ac.d.h(new b(this));
        AppMethodBeat.o(246744);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$sendGift$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;)V", "plugin-finder_release"})
    public static final class d implements a {
        final /* synthetic */ af uqD;
        final /* synthetic */ boolean uqN = true;

        /* JADX WARN: Incorrect types in method signature: (Z)V */
        d(af afVar) {
            this.uqD = afVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.plugin.af.a
        public final void a(boolean z, int i2, a.EnumC1189a aVar, String str, Long l, int i3, String str2) {
            AppMethodBeat.i(246737);
            kotlin.g.b.p.h(aVar, "errType");
            Log.i(this.uqD.TAG, "sendGiftCallback, success:" + z + " errCode:" + i2 + " errType:" + aVar + ",rewardGiftId:" + str + ",balance:" + l + ",cnt:" + i3 + ",comboId:" + str2);
            if (z) {
                af afVar = this.uqD;
                if (l != null) {
                    com.tencent.mm.live.c.b bVar = afVar.hOp;
                    b.c cVar = b.c.hMM;
                    Bundle bundle = new Bundle();
                    bundle.putLong("PARAM_FINDER_LIVE_GIFT_UPDATE_WECOIN", l.longValue());
                    bVar.statusChange(cVar, bundle);
                } else {
                    b.C0376b.a(afVar.hOp, b.c.hMM);
                }
                if (this.uqD.hOp.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                    com.tencent.mm.plugin.finder.report.live.m.a(s.aw.SINGLE_OR_CONTINUE_CLICK_SELECT_GITF_SEND, str, i3);
                }
                AppMethodBeat.o(246737);
                return;
            }
            af.a(this.uqD);
            switch (ag.haE[aVar.ordinal()]) {
                case 1:
                    switch (i2) {
                        case 10000:
                            AppMethodBeat.o(246737);
                            return;
                        case 10001:
                        case 10002:
                        default:
                            af.c(this.uqD);
                            break;
                        case ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL /*{ENCODED_INT: 10003}*/:
                            if (this.uqN) {
                                af.a(this.uqD, str2);
                                AppMethodBeat.o(246737);
                                return;
                            }
                            break;
                    }
            }
            AppMethodBeat.o(246737);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(246745);
        super.resume();
        AppMethodBeat.o(246745);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246747);
        super.unMount();
        FinderLiveGiftSendBtn finderLiveGiftSendBtn = this.uqw;
        finderLiveGiftSendBtn.diu();
        com.tencent.mm.ac.d.C(finderLiveGiftSendBtn.uyF);
        AppMethodBeat.o(246747);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void uC(int i2) {
        AppMethodBeat.i(246748);
        this.uqz = NetStatusUtil.isConnected(MMApplicationContext.getContext());
        Log.i(this.TAG, "networkChange " + i2 + ",networkEnable:" + this.uqz);
        if (!this.uqz) {
            com.tencent.mm.ac.d.h(new c(this));
        }
        AppMethodBeat.o(246748);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(246749);
        kotlin.g.b.p.h(cVar, "status");
        switch (ag.uqL[cVar.ordinal()]) {
            case 1:
                if (bundle != null && bundle.containsKey("PARAM_FINDER_LIVE_GIFT_ID")) {
                    this.upm = bundle.getString("PARAM_FINDER_LIVE_GIFT_ID");
                }
                if (bundle != null && bundle.containsKey("PARAM_FINDER_LIVE_SEND_GIFT_TARGET_USER_NAME")) {
                    String string = bundle.getString("PARAM_FINDER_LIVE_SEND_GIFT_TARGET_USER_NAME");
                    if (string == null) {
                        string = "";
                    }
                    this.UMp = string;
                }
                com.tencent.mm.ac.d.h(new f(this));
                AppMethodBeat.o(246749);
                return;
            case 2:
                dhq();
                AppMethodBeat.o(246749);
                return;
            case 3:
                if (!getLiveData().dja()) {
                    dhq();
                    com.tencent.mm.plugin.wallet.wecoin.a.d dVar = this.upj;
                    if (dVar != null) {
                        dVar.bMo();
                        AppMethodBeat.o(246749);
                        return;
                    }
                    AppMethodBeat.o(246749);
                    return;
                }
                break;
            case 4:
                com.tencent.mm.plugin.wallet.wecoin.a.d dVar2 = this.upj;
                if (dVar2 != null) {
                    dVar2.bMo();
                    AppMethodBeat.o(246749);
                    return;
                }
                break;
        }
        AppMethodBeat.o(246749);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(246746);
        if (this.hwr.getVisibility() == 0) {
            dhq();
            AppMethodBeat.o(246746);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(246746);
        return onBackPress;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ af uqD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(af afVar) {
            super(0);
            this.uqD = afVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1  */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 323
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.af.f.invoke():java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ af uqD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(af afVar) {
            super(0);
            this.uqD = afVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            awd awd;
            AppMethodBeat.i(246735);
            af afVar = this.uqD;
            String str2 = this.uqD.upm;
            if (str2 == null) {
                str = "";
            } else {
                str = str2;
            }
            String str3 = this.uqD.uqt;
            int i2 = this.uqD.uqu;
            if (afVar.uqA) {
                if (i2 > 0) {
                    String str4 = str3;
                    if (!(str4 == null || str4.length() == 0)) {
                        aut aut = new aut();
                        avn avn = new avn();
                        m mVar = m.vVH;
                        avn.contact = m.m(afVar.getLiveData());
                        avn.LDK = afVar.getLiveData().uDx;
                        aut.LFE = avn;
                        aut.ybm = 20013;
                        com.tencent.mm.plugin.finder.live.model.d dVar = new com.tencent.mm.plugin.finder.live.model.d(aut);
                        dVar.uir = true;
                        auy auy = new auy();
                        auy.LFM = str;
                        auy.LFP = str3;
                        auy.LFO = i2;
                        com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
                        com.tencent.mm.plugin.finder.storage.s atA = com.tencent.mm.plugin.finder.live.model.e.atA(str);
                        if (atA != null) {
                            awd = new awd();
                            awd.LFM = atA.field_rewardProductId;
                            awd.KTE = atA.field_businessType;
                            awd.LGJ = atA.field_thumbnailFileUrl;
                            awd.LGK = atA.field_previewPagUrl;
                            awd.LGL = atA.field_animationPagUrl;
                            awd.LGM = atA.field_thumbnailMd5;
                            awd.LGN = atA.field_previewPagMd5;
                            awd.LGO = atA.field_animationPagMd5;
                            awd.LGQ = atA.field_giftType;
                            awd.name = atA.field_name;
                            awd.LGP = atA.field_price;
                        } else {
                            awd = null;
                        }
                        auy.LFN = awd;
                        dVar.uiq = auy;
                        afVar.getLiveData().uDs.add(dVar);
                        Log.i(afVar.TAG, "addSelfGiftToComment comboCount:" + i2 + ",comboId:" + str3 + ",username:" + dVar.csW());
                        com.tencent.mm.live.b.m mVar2 = com.tencent.mm.live.b.m.hGg;
                        com.tencent.mm.live.b.m.aFe();
                    }
                }
                Log.i(afVar.TAG, "addSelfGiftToComment comboCount:" + i2 + ",comboId:" + str3);
            }
            af afVar2 = this.uqD;
            afVar2.uqt = "";
            afVar2.uqu = 0;
            this.uqD.hwr.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.af.b.AnonymousClass1 */
                final /* synthetic */ b uqM;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.uqM = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(246734);
                    this.uqM.uqD.rg(8);
                    AppMethodBeat.o(246734);
                }
            }).start();
            j jVar = this.uqD.uqx;
            if (jVar != null) {
                jVar.dZ(this.uqD.uqw);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246735);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ af uqD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(af afVar) {
            super(0);
            this.uqD = afVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246743);
            this.uqD.onBackPress();
            x xVar = x.SXb;
            AppMethodBeat.o(246743);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String uie;
        final /* synthetic */ af uqD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(af afVar, String str) {
            super(0);
            this.uqD = afVar;
            this.uie = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Boolean bool = null;
            AppMethodBeat.i(246742);
            final Context context = this.uqD.hwr.getContext();
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = o.getFinderLiveAssistant();
            Boolean valueOf = finderLiveAssistant != null ? Boolean.valueOf(finderLiveAssistant.dfq()) : null;
            Log.i(this.uqD.TAG, "showWecoinNotEnoughDialog isWeCoinEntranceAvailable:" + valueOf + ",comboId:" + this.uie);
            if (kotlin.g.b.p.j(Boolean.TRUE, valueOf)) {
                com.tencent.mm.ui.widget.a.d dVar = this.uqD.UMr;
                if (dVar == null || !dVar.isShowing()) {
                    m mVar = m.vVH;
                    if (!m.hn(this.uie, this.uqD.UMq)) {
                        f.a aVar = new f.a(context);
                        kotlin.g.b.p.g(context, "context");
                        aVar.bow(context.getResources().getString(R.string.d0h)).boA(context.getResources().getString(R.string.d0k)).boB(context.getResources().getString(R.string.sz)).b(new f.c(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.af.g.AnonymousClass1 */
                            final /* synthetic */ g uqO;

                            {
                                this.uqO = r1;
                            }

                            @Override // com.tencent.mm.ui.widget.a.f.c
                            public final void e(boolean z, String str) {
                                com.tencent.mm.plugin.wallet.wecoin.a.d dVar;
                                AppMethodBeat.i(246741);
                                if (this.uqO.uqD.hOp.getLiveRole() == 0) {
                                    com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                                    com.tencent.mm.plugin.finder.report.live.m.a(s.aw.SEND_GIFT_MONEY_NOT_ENOUGH_CLICK_EXCHARGE_UI, "", 0);
                                }
                                if (context instanceof FragmentActivity) {
                                    af afVar = this.uqO.uqD;
                                    o oVar = o.ujN;
                                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = o.getFinderLiveAssistant();
                                    if (finderLiveAssistant != null) {
                                        dVar = finderLiveAssistant.a((FragmentActivity) context, 2, new kotlin.g.a.a<x>(this) {
                                            /* class com.tencent.mm.plugin.finder.live.plugin.af.g.AnonymousClass1.AnonymousClass1 */
                                            final /* synthetic */ AnonymousClass1 uqP;

                                            {
                                                this.uqP = r2;
                                            }

                                            /* Return type fixed from 'java.lang.Object' to match base method */
                                            @Override // kotlin.g.a.a
                                            public final /* synthetic */ x invoke() {
                                                AppMethodBeat.i(246740);
                                                b.C0376b.a(this.uqP.uqO.uqD.hOp, b.c.hMG);
                                                x xVar = x.SXb;
                                                AppMethodBeat.o(246740);
                                                return xVar;
                                            }
                                        });
                                    } else {
                                        dVar = null;
                                    }
                                    afVar.upj = dVar;
                                }
                                AppMethodBeat.o(246741);
                            }
                        }).show();
                        this.uqD.UMr = aVar.hbv();
                        this.uqD.UMq = this.uie;
                    }
                }
                String str = this.uqD.TAG;
                StringBuilder sb = new StringBuilder("showWecoinNotEnoughDialog isShowing:");
                com.tencent.mm.ui.widget.a.d dVar2 = this.uqD.UMr;
                if (dVar2 != null) {
                    bool = Boolean.valueOf(dVar2.isShowing());
                }
                Log.i(str, sb.append(bool).append(",notEnoughWecoinComboId:").append(this.uqD.UMq).toString());
            } else {
                com.tencent.mm.ui.widget.a.d dVar3 = this.uqD.UMt;
                if (dVar3 == null || !dVar3.isShowing()) {
                    m mVar2 = m.vVH;
                    if (!m.hn(this.uie, this.uqD.UMs)) {
                        f.a aVar2 = new f.a(context);
                        kotlin.g.b.p.g(context, "context");
                        aVar2.bow(context.getResources().getString(R.string.d0i)).boA(context.getResources().getString(R.string.csn)).show();
                        this.uqD.UMt = aVar2.hbv();
                        this.uqD.UMs = this.uie;
                    }
                }
                String str2 = this.uqD.TAG;
                StringBuilder sb2 = new StringBuilder("showWecoinEntranceNotAvailableDialog isShowing:");
                com.tencent.mm.ui.widget.a.d dVar4 = this.uqD.UMt;
                if (dVar4 != null) {
                    bool = Boolean.valueOf(dVar4.isShowing());
                }
                Log.i(str2, sb2.append(bool).append(",entranceNotAvailabComboId:").append(this.uqD.UMs).toString());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246742);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ af uqD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(af afVar) {
            super(0);
            this.uqD = afVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246738);
            Log.i(this.uqD.TAG, "showConsumeFailDialog");
            Context context = this.uqD.hwr.getContext();
            f.a aVar = new f.a(context);
            kotlin.g.b.p.g(context, "context");
            aVar.bow(context.getResources().getString(R.string.d0_)).boA(context.getResources().getString(R.string.csn)).show();
            x xVar = x.SXb;
            AppMethodBeat.o(246738);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ af uqD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(af afVar) {
            super(0);
            this.uqD = afVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246736);
            j jVar = this.uqD.uqx;
            if (jVar != null) {
                jVar.dZ(this.uqD.uqw);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246736);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(af afVar) {
        AppMethodBeat.i(246751);
        com.tencent.mm.ac.d.h(new h(afVar));
        AppMethodBeat.o(246751);
    }

    public static final /* synthetic */ void a(af afVar, String str) {
        AppMethodBeat.i(260651);
        com.tencent.mm.ac.d.h(new g(afVar, str));
        if (afVar.hOp.getLiveRole() == 0) {
            com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.a(s.aw.SEND_GIFT_MONEY_NOT_ENOUGH_DIALOG_EXPLORE, "", 0);
        }
        AppMethodBeat.o(260651);
    }

    public static final /* synthetic */ void c(af afVar) {
        AppMethodBeat.i(246753);
        com.tencent.mm.ac.d.h(new e(afVar));
        AppMethodBeat.o(246753);
    }
}
