package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.ae;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.ui.widget.j;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000e\u0018\u0000 z2\u00020\u00012\u00020\u0002:\u0001zB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\"H\u0002J\u0006\u0010&\u001a\u00020'J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0011J\u000e\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0007J\u0012\u0010+\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010-\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010\"H\u0016J,\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u00010\"2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0016J\u0018\u00104\u001a\u00020\u00072\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u000106H\u0002J\b\u00107\u001a\u00020'H\u0016J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u0007H\u0016J\u0012\u0010;\u001a\u0004\u0018\u0001092\u0006\u0010<\u001a\u00020\"H\u0016J\u0018\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u000706j\b\u0012\u0004\u0012\u00020\u0007`>H\u0002J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0002J\u000e\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020\u0011J\b\u0010C\u001a\u00020\u0011H\u0016J\u0012\u0010D\u001a\u00020\u00112\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\"J\u0018\u0010F\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u0011H\u0002J\u000e\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020\u0011J\b\u0010I\u001a\u00020'H\u0016J\b\u0010J\u001a\u00020'H\u0016J\u0010\u0010K\u001a\u00020'2\u0006\u0010L\u001a\u00020\u0007H\u0016J\b\u0010M\u001a\u00020'H\u0016J\u0006\u0010N\u001a\u00020'J\b\u0010O\u001a\u00020'H\u0016J\b\u0010P\u001a\u00020'H\u0016J\b\u0010Q\u001a\u00020'H\u0016J\u001c\u0010R\u001a\u00020'2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010TH\u0016J\u0010\u0010V\u001a\u00020'2\u0006\u0010W\u001a\u00020\u0011H\u0016J\u001c\u0010X\u001a\u00020'2\b\u0010Y\u001a\u0004\u0018\u00010Z2\b\u0010[\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010\\\u001a\u00020'H\u0016J\u0010\u0010]\u001a\u00020'2\u0006\u0010^\u001a\u00020\u0011H\u0016J\u0006\u0010_\u001a\u00020'J\b\u0010`\u001a\u00020'H\u0016J\b\u0010a\u001a\u00020'H\u0016J\u0018\u0010b\u001a\u00020'2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0007H\u0016J\n\u0010e\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010f\u001a\u00020\"H\u0002J\u0016\u0010g\u001a\u00020\"2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\"0iH\u0002J\u0006\u0010j\u001a\u00020'J8\u0010k\u001a\u00020'2\u0006\u0010$\u001a\u00020\"2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0016J\u0010\u0010p\u001a\u00020'2\u0006\u0010q\u001a\u00020\u0011H\u0016J\u000e\u0010r\u001a\u00020'2\u0006\u0010s\u001a\u00020\u0007J\u000e\u0010t\u001a\u00020'2\u0006\u0010H\u001a\u00020\u0011J\"\u0010u\u001a\u00020'2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010B\u001a\u00020\u0011J\u000e\u0010v\u001a\u00020'2\u0006\u0010H\u001a\u00020\u0011J\u000e\u0010w\u001a\u00020'2\u0006\u0010B\u001a\u00020\u0011J\u000e\u0010x\u001a\u00020'2\u0006\u0010y\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow;", "Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "()V", "callBack", "Lcom/tencent/mm/plugin/voip/ui/IVoipMiniCallBack;", "currentMode", "", "floatBallViewListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "getFloatBallViewListener", "()Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "setFloatBallViewListener", "(Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;)V", "intent", "Landroid/content/Intent;", "isAllowToDoAnimation", "", "isHangup", "isNeedShowCameraStatus", "isNeedShowMuteStatus", "mBaseSmallView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView;", "mIsBeenSilent", "mTimerAfterClickAutoDismiss", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mUIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMUIHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setMUIHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "waitingRenderList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "checkRenderUserTalking", "userName", "checkSpeakerHasVideo", "dismiss", "", "isFinish", "disturbSpeaker", "interval", "doFavScreenShot", "path", "doSendToFriend", "drawVideo", ch.COL_USERNAME, "bitmap", "Landroid/graphics/Bitmap;", "mirror", "angle", "engineDoMemberSelectForView", "memberIdList", "Ljava/util/ArrayList;", "exitProjectScreen", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "wxUserName", "getOnlineUser", "Lkotlin/collections/ArrayList;", "getRandomNum", "maxSize", "initCurrentMode", "isVideo", "isCameraOpen", "isMiniTalkingUiVisibility", "wxGroupId", "mini", "onBadNetTipShow", "show", "onCameraStartError", "onEnterMultiTalk", "onError", "errCode", "onExitMultiTalk", "onHangupHappened", "onILinkCancelSubscribeLargeVideo", "onMemberChange", "onMiniMultiTalk", "onMultiTalkStatusChange", "preStatus", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkStatus;", "currentStatus", "onMuteStateChange", "isMute", "onNetWorkStatusChange", "preNetWorkType", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkUtil$NetWorkType;", "currentNetWorkType", "onScreenFrame", "onSpeakerStateChange", "isSpeaker", "onStartRecordFailed", "onTimeSecondCallback", "onVideoGroupMemberChange", "onVideoStateChange", "preAction", "currentAciton", "peakSpeakerUserList", "randomPeakUser", "randomPeakUserWhileTalking", "list", "", "refreshMiniView", "renderVideo", "img", "", "imgW", "imgH", "setHandFreeEnable", "enable", "setVoicePlayDevice", "device", "showCameraStatus", "showMini", "showMuteStatus", "switchToVoiceOrVideo", ch.COL_UPDATETIME, "time", "Companion", "plugin-multitalk_release"})
public final class n implements com.tencent.mm.plugin.multitalk.model.e, com.tencent.mm.plugin.multitalk.model.g {
    public static final a zTV = new a((byte) 0);
    private MMHandler czp;
    public Intent intent;
    public m zTM;
    public com.tencent.mm.plugin.voip.ui.a zTN;
    public boolean zTO;
    private MTimerHandler zTP;
    private int zTQ = 1;
    boolean zTR;
    boolean zTS;
    private boolean zTT;
    private com.tencent.mm.plugin.ball.c.h zTU = new b(this);

    static {
        AppMethodBeat.i(239871);
        AppMethodBeat.o(239871);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$Companion;", "", "()V", "AUDIO_MODE", "", "TAG", "", "VIDOE_MODE", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public n() {
        AppMethodBeat.i(239870);
        AppMethodBeat.o(239870);
    }

    public static final /* synthetic */ void a(n nVar, Intent intent2) {
        AppMethodBeat.i(239872);
        nVar.aM(intent2);
        AppMethodBeat.o(239872);
    }

    public final void eoN() {
        AppMethodBeat.i(239857);
        if (this.zTM != null) {
            this.zTO = true;
            com.tencent.f.h.RTc.bqo("showIcon");
            com.tencent.f.h.RTc.aV(new e(this));
            AppMethodBeat.o(239857);
            return;
        }
        rX(true);
        AppMethodBeat.o(239857);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ n zTW;

        e(n nVar) {
            this.zTW = nVar;
        }

        public final void run() {
            AppMethodBeat.i(239849);
            m mVar = this.zTW.zTM;
            if (mVar != null) {
                mVar.eoK();
                com.tencent.f.h.RTc.n(new Runnable(this) {
                    /* class com.tencent.mm.plugin.multitalk.ui.widget.n.e.AnonymousClass1 */
                    final /* synthetic */ e zTZ;

                    {
                        this.zTZ = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(239848);
                        this.zTZ.zTW.rX(true);
                        AppMethodBeat.o(239848);
                    }
                }, 2000);
                AppMethodBeat.o(239849);
                return;
            }
            AppMethodBeat.o(239849);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ boolean rti = true;
        final /* synthetic */ n zTW;

        public d(n nVar) {
            this.zTW = nVar;
        }

        public final void run() {
            AppMethodBeat.i(239847);
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.n.d.AnonymousClass1 */
                final /* synthetic */ d zTY;

                {
                    this.zTY = r1;
                }

                public final void run() {
                    m mVar;
                    AppMethodBeat.i(239846);
                    if (this.zTY.zTW.zTM == null || this.zTY.zTW.zTO || (mVar = this.zTY.zTW.zTM) == null) {
                        AppMethodBeat.o(239846);
                        return;
                    }
                    mVar.xm(this.zTY.rti);
                    AppMethodBeat.o(239846);
                }
            });
            AppMethodBeat.o(239847);
        }
    }

    private void rW(boolean z) {
        AppMethodBeat.i(239858);
        if (z) {
            if (this.zTQ == 2) {
                m mVar = this.zTM;
                if (mVar != null) {
                    mVar.rS(true);
                    AppMethodBeat.o(239858);
                    return;
                }
                AppMethodBeat.o(239858);
                return;
            }
            this.zTQ = 2;
            m mVar2 = this.zTM;
            if (mVar2 != null) {
                mVar2.eoJ();
                AppMethodBeat.o(239858);
                return;
            }
            AppMethodBeat.o(239858);
        } else if (this.zTQ == 1) {
            m mVar3 = this.zTM;
            if (mVar3 != null) {
                mVar3.rS(false);
                AppMethodBeat.o(239858);
                return;
            }
            AppMethodBeat.o(239858);
        } else {
            this.zTQ = 1;
            m mVar4 = this.zTM;
            if (mVar4 != null) {
                j jVar = mVar4.zTI;
                Integer eoH = jVar != null ? jVar.eoH() : null;
                if (eoH == null || eoH.intValue() != 0) {
                    j jVar2 = mVar4.zTI;
                    if (jVar2 != null) {
                        jVar2.lJI.setAlpha(0.0f);
                        jVar2.lJI.setVisibility(0);
                        jVar2.lJI.clearAnimation();
                        jVar2.lJI.animate().alpha(1.0f).setDuration(300).setListener(new j.b(jVar2)).start();
                    }
                    i iVar = mVar4.zTJ;
                    if (iVar != null) {
                        iVar.H(4);
                        AppMethodBeat.o(239858);
                        return;
                    }
                }
                AppMethodBeat.o(239858);
                return;
            }
            AppMethodBeat.o(239858);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ n zTW;

        public f(n nVar) {
            this.zTW = nVar;
        }

        public final void run() {
            AppMethodBeat.i(239851);
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.n.f.AnonymousClass1 */
                final /* synthetic */ f zUa;

                {
                    this.zUa = r1;
                }

                public final void run() {
                    m mVar;
                    AppMethodBeat.i(239850);
                    if (this.zUa.zTW.zTM == null || this.zUa.zTW.zTO || (mVar = this.zUa.zTW.zTM) == null) {
                        AppMethodBeat.o(239850);
                        return;
                    }
                    mVar.enR();
                    AppMethodBeat.o(239850);
                }
            });
            AppMethodBeat.o(239851);
        }
    }

    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(239859);
        m mVar = this.zTM;
        if (mVar != null) {
            mVar.setVoicePlayDevice(i2);
            AppMethodBeat.o(239859);
            return;
        }
        AppMethodBeat.o(239859);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emu() {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void eaa() {
        i iVar;
        MMHandler mMHandler;
        AppMethodBeat.i(239860);
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        if (eom.eno() && (mMHandler = this.czp) != null) {
            mMHandler.post(new g(this));
        }
        MMHandler mMHandler2 = this.czp;
        if (mMHandler2 != null) {
            mMHandler2.post(new h(this));
        }
        q eom2 = ac.eom();
        p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
        if (eom2.ent()) {
            ac.eom().enL();
        }
        String eoO = eoO();
        m mVar = this.zTM;
        if (p.j(eoO, mVar != null ? mVar.getRendererSpeaker() : null)) {
            m mVar2 = this.zTM;
            if (mVar2 != null) {
                i iVar2 = mVar2.zTJ;
                if (iVar2 != null) {
                    iVar2.zTi = Long.valueOf(Util.currentTicks());
                }
                i iVar3 = mVar2.zTJ;
                if ((iVar3 == null || !iVar3.zTf) && (iVar = mVar2.zTJ) != null) {
                    iVar.aGv(mVar2.getRendererSpeaker());
                }
            }
        } else if (eoO == null) {
            m mVar3 = this.zTM;
            if (mVar3 != null) {
                mVar3.aGA(null);
            }
            rW(false);
        } else {
            m mVar4 = this.zTM;
            if (mVar4 != null) {
                mVar4.aGA(eoO);
            }
            m mVar5 = this.zTM;
            if (mVar5 != null) {
                mVar5.aGz(eoO);
            }
            rW(true);
        }
        ac.eoo().emE();
        AppMethodBeat.o(239860);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ n zTW;

        g(n nVar) {
            this.zTW = nVar;
        }

        public final void run() {
            AppMethodBeat.i(239852);
            m mVar = this.zTW.zTM;
            if (mVar != null) {
                mVar.rT(true);
                AppMethodBeat.o(239852);
                return;
            }
            AppMethodBeat.o(239852);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ n zTW;

        h(n nVar) {
            this.zTW = nVar;
        }

        public final void run() {
            AppMethodBeat.i(239853);
            m mVar = this.zTW.zTM;
            if (mVar != null) {
                q eom = ac.eom();
                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                mVar.rU(eom.Zx());
                AppMethodBeat.o(239853);
                return;
            }
            AppMethodBeat.o(239853);
        }
    }

    private static int aB(ArrayList<Integer> arrayList) {
        AppMethodBeat.i(239861);
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(239861);
            return -1;
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            Integer num = arrayList.get(i2);
            p.g(num, "memberIdList[i]");
            int intValue = num.intValue();
            sb.append(intValue).append(",");
            iArr[i2] = intValue;
        }
        Log.i("MicroMsg.MultiTalkSmallWindow", "steve: engineDoMemberSelectForView: selected id list: %s", sb.toString());
        ByteBuffer allocate = ByteBuffer.allocate(size * 4);
        allocate.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(iArr);
        byte[] array = allocate.array();
        o eol = ac.eol();
        p.g(eol, "SubCoreMultiTalk.getMultiEngine()");
        int appCmd = eol.emG().setAppCmd(23, array, size);
        if (appCmd < 0) {
            Log.e("MicroMsg.MultiTalkSmallWindow", "steve:engineDoMemberSelectForView failed!!");
            com.tencent.mm.plugin.multitalk.model.p.emZ();
            AppMethodBeat.o(239861);
            return -1;
        }
        AppMethodBeat.o(239861);
        return appCmd;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void aFT(String str) {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emx() {
    }

    private final String eoO() {
        boolean z;
        String str = null;
        AppMethodBeat.i(239862);
        m mVar = this.zTM;
        String rendererSpeaker = mVar != null ? mVar.getRendererSpeaker() : null;
        String emJ = ac.eol().emJ();
        if (emJ == null) {
            String str2 = rendererSpeaker;
            if (str2 == null || kotlin.n.n.aL(str2)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (p.j(rendererSpeaker, z.aTY())) {
                    ac.eom();
                    if (!com.tencent.mm.plugin.multitalk.a.a.elC()) {
                        Log.i("MicroMsg.MultiTalkSmallWindow", "check mute form local pcm recorder");
                        AppMethodBeat.o(239862);
                        return rendererSpeaker;
                    } else if (!this.zTT) {
                        this.zTT = true;
                        AppMethodBeat.o(239862);
                        return rendererSpeaker;
                    } else {
                        this.zTT = false;
                        AppMethodBeat.o(239862);
                        return null;
                    }
                } else if (ac.eol().emH().contains(rendererSpeaker)) {
                    Log.i("MicroMsg.MultiTalkSmallWindow", "check mute form service status");
                    AppMethodBeat.o(239862);
                    return rendererSpeaker;
                } else if (!this.zTT) {
                    this.zTT = true;
                    AppMethodBeat.o(239862);
                    return rendererSpeaker;
                } else {
                    this.zTT = false;
                    AppMethodBeat.o(239862);
                    return null;
                }
            }
        } else {
            str = emJ;
        }
        AppMethodBeat.o(239862);
        return str;
    }

    private static ArrayList<Integer> eoP() {
        int aGF;
        AppMethodBeat.i(239863);
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        MultiTalkGroup enn = eom.enn();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (MultiTalkGroupMember multiTalkGroupMember : enn.RHa) {
            if ((multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) && (aGF = com.tencent.mm.plugin.multitalk.d.e.aGF(multiTalkGroupMember.RHb)) != -1) {
                arrayList.add(Integer.valueOf(aGF));
            }
        }
        AppMethodBeat.o(239863);
        return arrayList;
    }

    private static boolean aGB(String str) {
        T t;
        AppMethodBeat.i(239864);
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        HashSet<String> enr = eom.enr();
        p.g(enr, "SubCoreMultiTalk.getMult…ger().currentVideoUserSet");
        Iterator<T> it = enr.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (p.j(t, str)) {
                break;
            }
        }
        if (t != null) {
            AppMethodBeat.o(239864);
            return true;
        }
        AppMethodBeat.o(239864);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.g
    public final com.tencent.mm.plugin.multitalk.model.f Rc(int i2) {
        return null;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.g
    public final com.tencent.mm.plugin.multitalk.model.f aFB(String str) {
        m mVar;
        AppMethodBeat.i(239865);
        p.h(str, "wxUserName");
        m mVar2 = this.zTM;
        if (mVar2 != null) {
            mVar = TextUtils.isEmpty(mVar2.getUsername()) || p.j(mVar2.getUsername(), str) ? mVar2 : null;
        } else {
            mVar = null;
        }
        m mVar3 = mVar;
        AppMethodBeat.o(239865);
        return mVar3;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.g
    public final void emc() {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final boolean emo() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emw() {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void eie() {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void rw(boolean z) {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void rx(boolean z) {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void rv(boolean z) {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void dZZ() {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void a(o oVar) {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emt() {
        AppMethodBeat.i(239866);
        eoN();
        AppMethodBeat.o(239866);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emv() {
        m mVar;
        AppMethodBeat.i(239867);
        StringBuilder sb = new StringBuilder("onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): ");
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        Log.i("MicroMsg.MultiTalkSmallWindow", sb.append(eom.enr().size()).toString());
        q eom2 = ac.eom();
        p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
        if (eom2.ent()) {
            q eom3 = ac.eom();
            p.g(eom3, "SubCoreMultiTalk.getMultiTalkManager()");
            int i2 = eom3.enr().contains(z.aTY()) ? 1 : 0;
            q eom4 = ac.eom();
            p.g(eom4, "SubCoreMultiTalk.getMultiTalkManager()");
            if (eom4.enr().size() > i2) {
                ac.eom().enL();
                m mVar2 = this.zTM;
                if (mVar2 != null && (!p.j(mVar2.getRendererSpeaker(), ""))) {
                    rW(true);
                    m mVar3 = this.zTM;
                    if (mVar3 != null) {
                        mVar3.eoJ();
                    }
                }
            } else {
                ac.eom().enM();
                m mVar4 = this.zTM;
                if (mVar4 != null) {
                    if (!p.j(mVar4.getRendererSpeaker(), "")) {
                        m mVar5 = this.zTM;
                        if (mVar5 != null) {
                            mVar5.aGz(mVar4.getRendererSpeaker());
                        }
                    } else {
                        String eoO = eoO();
                        if (!(eoO == null || aGB(eoO) || (mVar = this.zTM) == null)) {
                            mVar.aGz(eoO);
                        }
                    }
                }
                eoO();
                rW(false);
            }
        }
        q eom5 = ac.eom();
        p.g(eom5, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean ens = eom5.ens();
        ArrayList<Integer> eoP = eoP();
        if (!ens) {
            aB(eoP);
        }
        if (ens) {
            q eom6 = ac.eom();
            p.g(eom6, "SubCoreMultiTalk.getMultiTalkManager()");
            if (!eom6.enA().emb()) {
                com.tencent.mm.plugin.multitalk.b.p.INSTANCE.az(eoP);
                Log.i("MicroMsg.MultiTalkSmallWindow", "ilink subscribeByUserMids ok, mids:".concat(String.valueOf(eoP)));
                AppMethodBeat.o(239867);
                return;
            }
        } else {
            int size = eoP.size();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                a.ar arVar = new a.ar();
                Integer num = eoP.get(i3);
                p.g(num, "userList[i]");
                arVar.qrD = num.intValue();
                arrayList.add(arVar);
            }
            ac.eom().fB(arrayList);
        }
        AppMethodBeat.o(239867);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void a(v.a aVar) {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emy() {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void onError(int i2) {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void aFS(String str) {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void hh(int i2, int i3) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$showMini$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-multitalk_release"})
    public static final class i implements RequestFloatWindowPermissionDialog.a {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ boolean wvA;
        final /* synthetic */ n zTW;
        final /* synthetic */ com.tencent.mm.plugin.voip.ui.a zUb;

        public i(n nVar, com.tencent.mm.plugin.voip.ui.a aVar, Intent intent, boolean z) {
            this.zTW = nVar;
            this.zUb = aVar;
            this.$intent = intent;
            this.wvA = z;
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(239854);
            p.h(requestFloatWindowPermissionDialog, "dialog");
            requestFloatWindowPermissionDialog.finish();
            if (this.zUb.dZV()) {
                n.a(this.zTW, this.$intent);
            }
            AppMethodBeat.o(239854);
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(239855);
            p.h(requestFloatWindowPermissionDialog, "dialog");
            requestFloatWindowPermissionDialog.finish();
            AppMethodBeat.o(239855);
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(239856);
            p.h(requestFloatWindowPermissionDialog, "dialog");
            requestFloatWindowPermissionDialog.finish();
            AppMethodBeat.o(239856);
        }
    }

    public final void aM(Intent intent2) {
        AppMethodBeat.i(239868);
        Log.i("MicroMsg.MultiTalkSmallWindow", "mini now..");
        if (this.zTM != null) {
            rX(false);
        }
        if (this.zTM == null) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            this.zTM = new m(context);
            this.zTO = false;
        }
        m mVar = this.zTM;
        if (mVar != null) {
            mVar.rT(ac.eoo().emo());
        }
        m mVar2 = this.zTM;
        if (mVar2 != null) {
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            mVar2.rU(eom.Zx());
        }
        m mVar3 = this.zTM;
        if (mVar3 != null) {
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class);
            p.g(af, "MMKernel.service(IFloatBallService::class.java)");
            mVar3.rV(((com.tencent.mm.plugin.ball.c.b) af).chT());
        }
        this.czp = new MMHandler();
        ac.eom().a(this);
        ac.eoo().zLR = this;
        MTimerHandler mTimerHandler = this.zTP;
        if (mTimerHandler != null) {
            mTimerHandler.stopTimer();
        }
        m mVar4 = this.zTM;
        if (mVar4 != null) {
            mVar4.setOnClickListener(new c(this, intent2));
        }
        com.tencent.mm.plugin.voip.a.a.fFk().a(8, true, this.zTM);
        ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a(this.zTU);
        ac.eol().emI();
        this.zTQ = 1;
        rW(false);
        com.tencent.mm.plugin.voip.ui.a aVar = this.zTN;
        if (aVar == null) {
            p.hyc();
        }
        aVar.a(intent2, this.zTM);
        q eom2 = ac.eom();
        p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
        ae enz = eom2.enz();
        ae.a(enz);
        enz.a(this);
        AppMethodBeat.o(239868);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ n zTW;

        c(n nVar, Intent intent) {
            this.zTW = nVar;
            this.$intent = intent;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(239845);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            view.setOnClickListener(null);
            this.$intent.addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.$intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.zTW.zTP = new MTimerHandler(new MTimerHandler.CallBack(this) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.n.c.AnonymousClass1 */
                final /* synthetic */ c zTX;

                {
                    this.zTX = r1;
                }

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(239843);
                    Log.i("MicroMsg.MultiTalkSmallWindow", "click small view and time is up we remove it..");
                    this.zTX.zTW.rX(false);
                    MTimerHandler mTimerHandler = this.zTX.zTW.zTP;
                    if (mTimerHandler != null) {
                        mTimerHandler.stopTimer();
                    }
                    AppMethodBeat.o(239843);
                    return true;
                }
            }, false);
            MTimerHandler mTimerHandler = this.zTW.zTP;
            if (mTimerHandler != null) {
                mTimerHandler.startTimer(2000);
            }
            MMHandlerThread.postToMainThreadDelayed(new Runnable(this) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.n.c.AnonymousClass2 */
                final /* synthetic */ c zTX;

                {
                    this.zTX = r1;
                }

                public final void run() {
                    AppMethodBeat.i(239844);
                    this.zTX.zTW.rX(false);
                    AppMethodBeat.o(239844);
                }
            }, 200);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$mini$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(239845);
        }
    }

    public final void rX(boolean z) {
        AppMethodBeat.i(239869);
        Log.i("MicroMsg.MultiTalkSmallWindow", "dismiss now.. isFinish: %b, smallView: %s", Boolean.valueOf(z), this.zTM);
        if (this.zTM != null) {
            if (z) {
                com.tencent.mm.plugin.voip.a.a.fFk().b(this.zTM);
            }
            m mVar = this.zTM;
            if (mVar != null) {
                mVar.setOnClickListener(null);
            }
            m mVar2 = this.zTM;
            if (mVar2 != null) {
                mVar2.uninit();
            }
            this.zTM = null;
            ac.eom().enm();
            ac.eoo().zLR = null;
        } else if (z) {
            com.tencent.mm.plugin.voip.a.a.fFk().cir();
        }
        ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b(this.zTU);
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        eom.enz().b(this);
        AppMethodBeat.o(239869);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$floatBallViewListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "onBallPositionChanged", "", "x", "", "y", "height", "isSettled", "", "isDockLeft", "plugin-multitalk_release"})
    public static final class b extends com.tencent.mm.plugin.ball.c.h {
        final /* synthetic */ n zTW;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(n nVar) {
            this.zTW = nVar;
        }

        @Override // com.tencent.mm.plugin.ball.c.h, com.tencent.mm.plugin.ball.c.g
        public final void a(int i2, int i3, int i4, boolean z, boolean z2) {
            AppMethodBeat.i(239842);
            super.a(i2, i3, i4, z, z2);
            m mVar = this.zTW.zTM;
            if (mVar != null) {
                mVar.rV(z2);
                AppMethodBeat.o(239842);
                return;
            }
            AppMethodBeat.o(239842);
        }
    }
}
