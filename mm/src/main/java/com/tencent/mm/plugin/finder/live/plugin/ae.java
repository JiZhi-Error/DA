package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.live.util.n;
import com.tencent.mm.plugin.finder.live.util.p;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGiftTextView;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010&\n\u0002\b\u0011\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0005cdefgB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ$\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J \u0010+\u001a\u00020,2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0013R\u00020\u00000.H\u0002J\b\u0010/\u001a\u00020\u000bH\u0016J\u0016\u00100\u001a\u00020%2\f\u00101\u001a\b\u0018\u00010\u0013R\u00020\u0000H\u0002J$\u00102\u001a\u00020\u000b2\u001a\b\u0002\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0013R\u00020\u0000\u0018\u00010.H\u0002J\"\u00103\u001a\u00020%2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0013R\u00020\u0000\u0018\u00010.H\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u0016H\u0002J\u0006\u00106\u001a\u00020%J\u0014\u00107\u001a\u00020%2\n\u00101\u001a\u00060\u0013R\u00020\u0000H\u0002J\u001a\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u000bH\u0002J\u001a\u0010;\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u000bH\u0002J\u0010\u0010<\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0010\u0010=\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001a\u0010>\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0013R\u00020\u0000\u0018\u00010.H\u0002J\"\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020D2\u0006\u0010:\u001a\u00020\u000bH\u0002J\"\u0010E\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010F\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u001c\u0010G\u001a\u00020%2\b\u0010H\u001a\u0004\u0018\u00010\u00042\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0012\u0010K\u001a\u00020\u000b2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\b\u0010L\u001a\u00020%H\u0016J4\u0010M\u001a\u00020%2\"\u0010N\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020(0Oj\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020(`P2\u0006\u0010Q\u001a\u00020\u000bH\u0016J\u0010\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020%H\u0002J\"\u0010V\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u00162\b\b\u0002\u0010X\u001a\u00020\u000eH\u0002J\u001c\u0010Y\u001a\u00020%2\b\u0010H\u001a\u0004\u0018\u00010\u00042\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u001c\u0010Z\u001a\u00020%2\b\u0010[\u001a\u0004\u0018\u00010\u00042\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\b\u0010\\\u001a\u00020%H\u0016J\u0010\u0010]\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004H\u0002J(\u0010^\u001a\u00020%2\f\u0010_\u001a\b\u0018\u00010\u0013R\u00020\u00002\u0006\u0010I\u001a\u00020J2\b\b\u0002\u0010`\u001a\u00020\u000bH\u0002J\u001c\u0010a\u001a\u00020%2\u0006\u0010b\u001a\u00020\u00162\n\u0010_\u001a\u00060\u0013R\u00020\u0000H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0013R\u00020\u00000\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "iGiftQueue", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "outerSpaceParent", "isVisitor", "", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;Landroid/view/ViewGroup;Z)V", "NICK_NAME_LENGTH", "", "bulletInAnimatorMap", "", "Landroid/animation/ObjectAnimator;", "bulletInfoMap", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "bulletOutAnimatorMap", "comboIdBackToLiveMap", "", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$ComboIdBackToLiveInfo;", "comboIdList", "Ljava/util/LinkedList;", "containerFake", "Landroid/widget/RelativeLayout;", "containerOne", "containerThree", "containerTwo", "initialMapSize", "outerSpaceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "adjustContainerLocation", "", "container", "rect", "Landroid/graphics/Rect;", "micUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "calculatePreciousGiftRemainingTime", "", "entry", "", "canClearScreen", "checkIfNeedPreserveShowingPreciousGift", "info", "checkIfPreciousGiftTimeOver", "checkIfSelfPreciousGiftForceReplace", "checkInfoFromComboIdBackToLiveMap", "comboId", "checkStatusWhenMaximizeWindow", "cloneToFakeContainer", "createBulletInAnimator", "target", "isOuterSpace", "createBulletOutAnimator", "disableContainer", "enableContainer", "findCurrentShowingPreciousGift", "getDisplayNickName", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "textView", "Landroid/widget/TextView;", "getOuterSpaceContainer", "parent", "launchBulletInAnimation", "space", "giftShowInfo", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "matchBackupGiftType", "mount", "onAudienceMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "onGiftAdding", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "pollNextGiftShowInfo", "registerOuterSpace", "targetUserName", TencentLocation.EXTRA_DIRECTION, "relaunchBulletInAnimation", "replaceBullet", "originSpace", "unMount", "unregisterOuterSpace", "updateBulletShowingInfo", "bulletShowingInfo", "isForceReplace", "updatePreciousGiftTotalShowingTime", "giftId", "BulletFadeInEvaluator", "BulletShowingInfo", "BulletViewHolder", "ComboIdBackToLiveInfo", "Companion", "plugin-finder_release"})
public final class ae extends d implements p.a {
    private static final float UMb = MMApplicationContext.getResources().getDimension(R.dimen.cl);
    private static final float UMc = MMApplicationContext.getResources().getDimension(R.dimen.cl);
    private static final int ulA = (com.tencent.mm.plugin.finder.storage.c.dvY().value().intValue() * 1000);
    private static final int upL = (500 / (ulA + 500));
    public static final c upM = new c((byte) 0);
    private final RelativeLayout ULX;
    private final int ULY;
    private final ConcurrentHashMap<String, ViewGroup> ULZ;
    private final ViewGroup UMa;
    private final com.tencent.mm.live.c.b hOp;
    private final MTimerHandler timer;
    private final int upA;
    private final RelativeLayout upB;
    private final RelativeLayout upC;
    private final RelativeLayout upD;
    private final Map<ViewGroup, a> upE;
    private final Map<ViewGroup, ObjectAnimator> upF;
    private final Map<ViewGroup, ObjectAnimator> upG;
    private final Map<String, f> upH;
    private final LinkedList<String> upI;
    private final com.tencent.mm.plugin.finder.live.util.p upJ;
    private final boolean upK;

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "fraction", "", "flying", "", "invoke"})
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.m<Float, Boolean, x> {
        final /* synthetic */ ae uqd;
        final /* synthetic */ ViewGroup uql;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(ae aeVar, ViewGroup viewGroup) {
            super(2);
            this.uqd = aeVar;
            this.uql = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Float f2, Boolean bool) {
            AppMethodBeat.i(246688);
            f2.floatValue();
            boolean booleanValue = bool.booleanValue();
            a aVar = (a) this.uqd.upE.get(this.uql);
            if (aVar != null) {
                aVar.nt(booleanValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246688);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "fraction", "", "flying", "", "invoke"})
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.m<Float, Boolean, x> {
        final /* synthetic */ ae uqd;
        final /* synthetic */ ViewGroup uql;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(ae aeVar, ViewGroup viewGroup) {
            super(2);
            this.uqd = aeVar;
            this.uql = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Float f2, Boolean bool) {
            AppMethodBeat.i(260636);
            f2.floatValue();
            boolean booleanValue = bool.booleanValue();
            a aVar = (a) this.uqd.upE.get(this.uql);
            if (aVar != null) {
                aVar.nt(booleanValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260636);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0005R\u00020\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.b<Map.Entry<? extends ViewGroup, ? extends a>, Boolean> {
        public static final j uqp = new j();

        static {
            AppMethodBeat.i(246698);
            AppMethodBeat.o(246698);
        }

        j() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Map.Entry<? extends ViewGroup, ? extends a> entry) {
            boolean z;
            AppMethodBeat.i(246697);
            Map.Entry<? extends ViewGroup, ? extends a> entry2 = entry;
            kotlin.g.b.p.h(entry2, LocaleUtil.ITALIAN);
            if (!((a) entry2.getValue()).upN.get() || !((a) entry2.getValue()).upP.get()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(246697);
            return valueOf;
        }
    }

    public static final /* synthetic */ boolean a(ae aeVar, Map.Entry entry) {
        AppMethodBeat.i(246721);
        boolean g2 = aeVar.g(entry);
        AppMethodBeat.o(246721);
        return g2;
    }

    public static final /* synthetic */ void b(String str, a aVar) {
        AppMethodBeat.i(246724);
        a(str, aVar);
        AppMethodBeat.o(246724);
    }

    public static final /* synthetic */ void g(ae aeVar) {
        AppMethodBeat.i(246722);
        aeVar.dhm();
        AppMethodBeat.o(246722);
    }

    public /* synthetic */ ae(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, com.tencent.mm.plugin.finder.live.util.p pVar, ViewGroup viewGroup2) {
        this(viewGroup, bVar, pVar, viewGroup2, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ae(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, com.tencent.mm.plugin.finder.live.util.p pVar, ViewGroup viewGroup2, boolean z) {
        super(viewGroup, bVar);
        kotlin.g.b.p.h(viewGroup, "root");
        kotlin.g.b.p.h(bVar, "statusMonitor");
        kotlin.g.b.p.h(pVar, "iGiftQueue");
        kotlin.g.b.p.h(viewGroup2, "outerSpaceParent");
        AppMethodBeat.i(260650);
        this.hOp = bVar;
        this.upJ = pVar;
        this.UMa = viewGroup2;
        this.upK = z;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.upA = com.tencent.mm.plugin.finder.storage.c.dvZ().value().intValue();
        this.upI = new LinkedList<>();
        this.ULZ = new ConcurrentHashMap<>();
        this.timer = new MTimerHandler("FinderLiveGiftQueuePlugin::Timer", (MTimerHandler.CallBack) new o(this), false);
        View findViewById = viewGroup.findViewById(R.id.cqy);
        kotlin.g.b.p.g(findViewById, "root.findViewById(R.id.f…ve_gift_queue_bullet_one)");
        this.upB = (RelativeLayout) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.cr0);
        kotlin.g.b.p.g(findViewById2, "root.findViewById(R.id.f…ve_gift_queue_bullet_two)");
        this.upC = (RelativeLayout) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.cqz);
        kotlin.g.b.p.g(findViewById3, "root.findViewById(R.id.f…_gift_queue_bullet_three)");
        this.upD = (RelativeLayout) findViewById3;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ado, viewGroup, false);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(260650);
            throw tVar;
        }
        this.ULX = (RelativeLayout) inflate;
        Map<ViewGroup, a> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap(3));
        kotlin.g.b.p.g(synchronizedMap, "Collections.synchronizedMap(LinkedHashMap(3))");
        this.upE = synchronizedMap;
        this.upE.put(this.upB, new a(this, this.upB, 0, this.upK, false, false, 24));
        this.upE.put(this.upC, new a(this, this.upC, 1, this.upK, false, false, 24));
        this.upE.put(this.upD, new a(this, this.upD, 2, this.upK, true, false, 16));
        Map<ViewGroup, a> map = this.upE;
        RelativeLayout relativeLayout = this.ULX;
        a aVar = new a(this, this.ULX, 1000, this.upK, false, false, 24);
        aVar.UMg = true;
        aVar.upP.getAndSet(true);
        aVar.bxH("");
        map.put(relativeLayout, aVar);
        this.ULY = this.upE.size();
        this.upF = new ConcurrentHashMap(3);
        this.upF.put(this.upB, e(this.upB, false));
        this.upF.put(this.upC, e(this.upC, false));
        this.upF.put(this.upD, e(this.upD, false));
        this.upG = new ConcurrentHashMap(3);
        this.upG.put(this.upB, R(this.upB));
        this.upG.put(this.upC, R(this.upC));
        this.upG.put(this.upD, R(this.upD));
        Map<String, f> synchronizedMap2 = Collections.synchronizedMap(new LinkedHashMap());
        kotlin.g.b.p.g(synchronizedMap2, "Collections.synchronizedMap(LinkedHashMap())");
        this.upH = synchronizedMap2;
        Iterator<T> it = this.upE.values().iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            com.tencent.mm.plugin.finder.utils.m.p(it.next().upV.uqj);
        }
        AppMethodBeat.o(260650);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$Companion;", "", "()V", "ANIMATION_DURATION", "", "ANIMATION_STAY_START_TIME", "", "BULLET_FLY_DISTANCE", "", "BULLET_UI_HEIGHT", "FLY_FRACTION", "LINK_MIC_USER_MARGIN_BOTTOM", "OUTER_SPACE_NICK_NAME_MAX_LENGTH", "PRECIOUS_GIFT_REMAINING_TIME_THRESHHOLD", "STAY_DURATION", "TAG", "", "plugin-finder_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(246720);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        AppMethodBeat.o(246720);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010T\u001a\u00020UJ\b\u0010V\u001a\u00020WH\u0002J\u0018\u0010\u0015\u001a\u00020U2\u0006\u0010X\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020\u0007J\u0010\u0010Z\u001a\u00020U2\b\b\u0002\u0010[\u001a\u00020!J\b\u0010\\\u001a\u00020!H\u0016R$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u001a\u00105\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010R\u001a\u00107\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010R\u001a\u00109\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010\u0010R\u001a\u0010;\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010.\"\u0004\b<\u00100R\u001a\u0010=\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u0010R\u001a\u0010?\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010.\"\u0004\b@\u00100R\u001a\u0010A\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010(\"\u0004\bC\u0010*R\u001a\u0010D\u001a\u00020EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010#\"\u0004\bL\u0010%R\u001a\u0010M\u001a\u00020EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010G\"\u0004\bO\u0010IR\u0011\u0010P\u001a\u00020Q¢\u0006\b\n\u0000\u001a\u0004\bR\u0010S¨\u0006]"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletShowingInfo;", "", "container", "Landroid/view/ViewGroup;", FirebaseAnalytics.b.INDEX, "", "isVisitor", "", "backup", "isOuterSpace", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;Landroid/view/ViewGroup;IZZZ)V", "value", "bulletFlying", "getBulletFlying", "()Z", "setBulletFlying", "(Z)V", "cntQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getCntQueue", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setCntQueue", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "cntTransferAnimatorSet", "Landroid/animation/AnimatorSet;", "getCntTransferAnimatorSet", "()Landroid/animation/AnimatorSet;", "setCntTransferAnimatorSet", "(Landroid/animation/AnimatorSet;)V", "cntTransferAniming", "getCntTransferAniming", "setCntTransferAniming", "comboId", "", "getComboId", "()Ljava/lang/String;", "setComboId", "(Ljava/lang/String;)V", "comboSumCount", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getEnabled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setEnabled", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "giftId", "getGiftId", "setGiftId", "getIndex", "isBackup", "setBackup", "isBulletInAnimationEnd", "setBulletInAnimationEnd", "isFakeContainer", "setFakeContainer", "isPreciousGift", "setPreciousGift", "isSelfSend", "setSelfSend", "isShowing", "setShowing", "lastCountOnBackToLive", "getLastCountOnBackToLive", "setLastCountOnBackToLive", "startShowingTime", "", "getStartShowingTime", "()J", "setStartShowingTime", "(J)V", "targetUserName", "getTargetUserName", "setTargetUserName", "totalShowingTime", "getTotalShowingTime", "setTotalShowingTime", "viewHolder", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "getViewHolder", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "reset", "", "saveBackToLiveInfo", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$ComboIdBackToLiveInfo;", "destinationCnt", "localSend", "startTransferCnt", "prefix", "toString", "plugin-finder_release"})
    public final class a {
        volatile String UMe;
        AtomicBoolean UMf;
        boolean UMg;
        final int index;
        AtomicBoolean upN;
        volatile boolean upO;
        AtomicBoolean upP;
        volatile boolean upQ;
        volatile String upR;
        volatile int upS;
        private ConcurrentLinkedDeque<Integer> upT;
        volatile int upU;
        final b upV;
        boolean upW;
        volatile long upX;
        volatile long upY;
        volatile String upZ;
        AnimatorSet uqa;
        private volatile boolean uqb;
        volatile boolean uqc;
        final /* synthetic */ ae uqd;

        private a(ae aeVar, ViewGroup viewGroup, int i2, boolean z, boolean z2, boolean z3) {
            kotlin.g.b.p.h(viewGroup, "container");
            this.uqd = aeVar;
            AppMethodBeat.i(260630);
            this.index = i2;
            this.upN = new AtomicBoolean(false);
            this.upP = new AtomicBoolean(false);
            this.upR = "";
            this.upT = new ConcurrentLinkedDeque<>();
            this.upV = new b(viewGroup, z, z3);
            this.upW = z2;
            this.upZ = "";
            this.UMe = aeVar.getLiveData().hwd;
            this.UMf = new AtomicBoolean(true);
            this.uqa = new AnimatorSet();
            final ObjectAnimator duration = ObjectAnimator.ofFloat(this.upV.uqj, "scaleX", 0.0f, 1.1f).setDuration(125L);
            kotlin.g.b.p.g(duration, "ObjectAnimator.ofFloat(v…f, 1.1f).setDuration(125)");
            final ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.upV.uqj, "scaleY", 0.0f, 1.1f).setDuration(125L);
            kotlin.g.b.p.g(duration2, "ObjectAnimator.ofFloat(v…f, 1.1f).setDuration(125)");
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.upV.uqj, "scaleX", 1.1f, 1.0f).setDuration(83L);
            kotlin.g.b.p.g(duration3, "ObjectAnimator.ofFloat(v…1f, 1.0f).setDuration(83)");
            duration3.setStartDelay(125);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.upV.uqj, "scaleY", 1.1f, 1.0f).setDuration(83L);
            kotlin.g.b.p.g(duration4, "ObjectAnimator.ofFloat(v…1f, 1.0f).setDuration(83)");
            duration4.setStartDelay(125);
            final ObjectAnimator duration5 = ObjectAnimator.ofFloat(this.upV.uqj, "alpha", 0.0f, 1.0f).setDuration(208L);
            kotlin.g.b.p.g(duration5, "ObjectAnimator.ofFloat(v…f, 1.0f).setDuration(208)");
            this.upV.uqj.setPivotX(0.0f);
            this.upV.uqj.setPivotY((float) this.upV.uqj.getMeasuredHeight());
            this.uqa.playTogether(duration, duration2, duration3, duration4, duration5);
            this.uqa.addListener(new Animator.AnimatorListener(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.ae.a.AnonymousClass1 */
                final /* synthetic */ a uqe;

                {
                    this.uqe = r1;
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(246670);
                    this.uqe.ns(true);
                    AppMethodBeat.o(246670);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(246671);
                    this.uqe.ns(false);
                    Object target = duration5.getTarget();
                    if (!(target instanceof View)) {
                        target = null;
                    }
                    View view = (View) target;
                    if (view != null) {
                        view.setAlpha(1.0f);
                    }
                    Object target2 = duration.getTarget();
                    if (!(target2 instanceof View)) {
                        target2 = null;
                    }
                    View view2 = (View) target2;
                    if (view2 != null) {
                        view2.setScaleX(1.0f);
                    }
                    Object target3 = duration2.getTarget();
                    if (!(target3 instanceof View)) {
                        target3 = null;
                    }
                    View view3 = (View) target3;
                    if (view3 != null) {
                        view3.setScaleY(1.0f);
                        AppMethodBeat.o(246671);
                        return;
                    }
                    AppMethodBeat.o(246671);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            AppMethodBeat.o(260630);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(ae aeVar, ViewGroup viewGroup, int i2, boolean z, boolean z2, boolean z3, int i3) {
            this(aeVar, viewGroup, i2, z, (i3 & 8) != 0 ? false : z2, (i3 & 16) == 0 ? z3 : false);
            AppMethodBeat.i(260631);
            AppMethodBeat.o(260631);
        }

        public final void atJ(String str) {
            AppMethodBeat.i(246674);
            kotlin.g.b.p.h(str, "<set-?>");
            this.upR = str;
            AppMethodBeat.o(246674);
        }

        public final void bxH(String str) {
            AppMethodBeat.i(260628);
            kotlin.g.b.p.h(str, "<set-?>");
            this.UMe = str;
            AppMethodBeat.o(260628);
        }

        public final void ns(boolean z) {
            AppMethodBeat.i(246675);
            if (z != this.uqb) {
                Log.i("Finder.FinderLiveGiftQueuePlugin", "cntTransferAniming origin value:" + this.uqb + ",value:" + z);
            }
            this.uqb = z;
            if (!this.uqb) {
                atK("cntTransferAnim end");
            }
            AppMethodBeat.o(246675);
        }

        public final void nt(boolean z) {
            AppMethodBeat.i(246676);
            boolean z2 = false;
            if (z != this.uqc) {
                Log.i("Finder.FinderLiveGiftQueuePlugin", "bulletFlying origin value:" + this.uqc + ",value:" + z);
                if (!z) {
                    z2 = true;
                }
            }
            this.uqc = z;
            if (z2) {
                atK("bulletFlying Stop");
            }
            AppMethodBeat.o(246676);
        }

        public final void ak(int i2, boolean z) {
            boolean z2;
            AppMethodBeat.i(246677);
            Object tag = this.upV.uqj.getTag();
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            int intValue = num != null ? num.intValue() : this.upU;
            if (intValue <= 0) {
                z2 = true;
                intValue = 1;
            } else {
                z2 = false;
            }
            if (i2 <= intValue) {
                this.upV.uqj.setText("x".concat(String.valueOf(intValue)));
                AppMethodBeat.o(246677);
                return;
            }
            StringBuilder sb = new StringBuilder("localSend:" + z + ",startCnt:" + intValue + ",lastCountOnBackToLive:" + this.upU + ",firstGift:" + z2 + ';');
            this.upT.clear();
            if (!z) {
                int mZ = kotlin.k.j.mZ(1, (int) Math.ceil((((double) i2) - ((double) intValue)) / 5.0d));
                if (!z2) {
                    intValue += mZ;
                }
                while (intValue < i2) {
                    this.upT.offer(Integer.valueOf(intValue));
                    sb.append(new StringBuilder().append(intValue).append(',').toString());
                    intValue += mZ;
                }
            }
            this.upT.offer(Integer.valueOf(i2));
            sb.append(i2);
            Log.i("Finder.FinderLiveGiftQueuePlugin", "setCntQueue ".concat(String.valueOf(sb)));
            atK("setCntQueue");
            AppMethodBeat.o(246677);
        }

        private void atK(String str) {
            AppMethodBeat.i(246678);
            kotlin.g.b.p.h(str, "prefix");
            boolean isEmpty = this.upT.isEmpty();
            if (isEmpty || this.uqb || this.uqc) {
                Log.i("Finder.FinderLiveGiftQueuePlugin", "startTransferCnt(" + str + ") cntQueueEmpty:" + isEmpty + ",cntTransferAniming:" + this.uqb + ",bulletFlying:" + this.uqc);
                AppMethodBeat.o(246678);
                return;
            }
            Integer pollFirst = this.upT.pollFirst();
            int intValue = pollFirst != null ? pollFirst.intValue() : this.upS;
            Log.i("Finder.FinderLiveGiftQueuePlugin", "startTransferCnt(" + str + ") number:" + intValue + ",cntQueueEmpty:" + isEmpty + ",cntTransferAniming:" + this.uqb + ",bulletFlying:" + this.uqc);
            this.upV.uqj.setText("x".concat(String.valueOf(intValue)));
            this.upV.uqj.setTag(Integer.valueOf(intValue));
            this.upV.uqj.setPivotX(0.0f);
            this.upV.uqj.setPivotY((float) this.upV.uqj.getMeasuredHeight());
            this.uqa.start();
            AppMethodBeat.o(246678);
        }

        public final void reset() {
            AppMethodBeat.i(246679);
            this.uqd.upH.put(this.upR, hTA());
            com.tencent.mm.ac.d.c("giftQueueMapClear", new C1188a(this));
            Integer peekLast = this.upT.peekLast();
            if (peekLast != null) {
                this.upV.uqj.setText("x".concat(String.valueOf(peekLast)));
            }
            this.upN.getAndSet(false);
            this.upO = false;
            this.upP.getAndSet(false);
            this.upQ = false;
            this.upR = "";
            this.upS = 0;
            this.upU = 0;
            this.upT.clear();
            this.upX = 0;
            this.upY = 0;
            this.upZ = "";
            com.tencent.mm.ac.d.h(new b(this));
            ns(false);
            nt(false);
            this.upV.uqj.setTag(null);
            AppMethodBeat.o(246679);
        }

        private final f hTA() {
            AppMethodBeat.i(260629);
            f fVar = new f();
            fVar.upP.getAndSet(this.upP.get());
            fVar.dJM = this.upQ;
            fVar.upS = this.upS;
            fVar.jmU = cl.aWA();
            fVar.bxI(this.upZ);
            AppMethodBeat.o(260629);
            return fVar;
        }

        public final String toString() {
            AppMethodBeat.i(246681);
            String str = "\n" + ("index = " + this.index) + ", " + ("giftId = " + this.upZ) + ", " + ("isShowing = " + this.upN) + ", " + ("isPreciousGift = " + this.upP) + ", " + ("isAnimationEnd = " + this.upO) + ", " + ("comboId = " + this.upR) + ", " + ("comboSumCount = " + this.upS) + ", " + ("lastCountOnBackToLive = " + this.upU) + ", " + ("totalShowingTime = " + this.upX) + ", " + ("cntTransferAniming = " + this.uqb) + ", " + ("bulletFlying = " + this.uqc) + ", " + ("targetUserName = " + this.UMe) + ", " + ("enabled = " + this.UMf) + "\n";
            kotlin.g.b.p.g(str, "StringBuilder().append(\"…              .toString()");
            AppMethodBeat.o(246681);
            return str;
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.live.plugin.ae$a$a  reason: collision with other inner class name */
        public static final class C1188a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ a uqe;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1188a(a aVar) {
                super(0);
                this.uqe = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(246672);
                this.uqe.uqd.upI.remove(this.uqe.upR);
                this.uqe.uqd.upI.offerLast(this.uqe.upR);
                while (this.uqe.uqd.upI.size() > 1000) {
                    String str = (String) this.uqe.uqd.upI.pollFirst();
                    if (str != null) {
                        Log.i("Finder.FinderLiveGiftQueuePlugin", "comboIdBackToLiveMap remove: comboId=".concat(String.valueOf(str)));
                        this.uqe.uqd.upH.remove(str);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(246672);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ a uqe;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar) {
                super(0);
                this.uqe = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(246673);
                this.uqe.uqa.cancel();
                this.uqe.upV.uqi.stop();
                this.uqe.upV.uqi.setFile(null);
                x xVar = x.SXb;
                AppMethodBeat.o(246673);
                return xVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletViewHolder;", "", "container", "Landroid/view/ViewGroup;", "isVisitor", "", "isOuterSpace", "(Landroid/view/ViewGroup;ZZ)V", "cntTv", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "getCntTv", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "fromUserTv", "Landroid/widget/TextView;", "getFromUserTv", "()Landroid/widget/TextView;", "giftNameTv", "getGiftNameTv", "()Z", "pagView", "Lorg/libpag/PAGView;", "getPagView", "()Lorg/libpag/PAGView;", "plugin-finder_release"})
    public static final class b {
        final TextView UMh;
        final TextView UMi;
        final boolean UMj;
        final PAGView uqi;
        final FinderLiveGiftTextView uqj;

        public b(ViewGroup viewGroup, boolean z, boolean z2) {
            ViewGroup.LayoutParams layoutParams;
            ViewGroup.LayoutParams layoutParams2;
            kotlin.g.b.p.h(viewGroup, "container");
            AppMethodBeat.i(260632);
            this.UMj = z2;
            View findViewById = viewGroup.findViewById(R.id.jx0);
            kotlin.g.b.p.g(findViewById, "container.findViewById(R…ft_bullut_desc_from_user)");
            this.UMh = (TextView) findViewById;
            View findViewById2 = viewGroup.findViewById(R.id.jx1);
            kotlin.g.b.p.g(findViewById2, "container.findViewById(R…ft_bullut_desc_gift_name)");
            this.UMi = (TextView) findViewById2;
            View findViewById3 = viewGroup.findViewById(R.id.cq_);
            kotlin.g.b.p.g(findViewById3, "container.findViewById(R…der_live_gift_bullut_pag)");
            this.uqi = (PAGView) findViewById3;
            View findViewById4 = viewGroup.findViewById(R.id.cq6);
            kotlin.g.b.p.g(findViewById4, "container.findViewById(R…_live_gift_bullut_cnt_tv)");
            this.uqj = (FinderLiveGiftTextView) findViewById4;
            if (this.UMj) {
                this.UMh.setTextSize(1, 14.0f);
                this.UMi.setTextSize(1, 14.0f);
                ViewGroup.LayoutParams layoutParams3 = this.uqi.getLayoutParams();
                Context context = viewGroup.getContext();
                kotlin.g.b.p.g(context, "container.context");
                layoutParams3.width = (int) context.getResources().getDimension(R.dimen.cl);
                ViewGroup.LayoutParams layoutParams4 = this.uqi.getLayoutParams();
                Context context2 = viewGroup.getContext();
                kotlin.g.b.p.g(context2, "container.context");
                layoutParams4.height = (int) context2.getResources().getDimension(R.dimen.cl);
                this.uqj.setTextSize(1, 17.0f);
                ViewGroup.LayoutParams layoutParams5 = viewGroup.getLayoutParams();
                Context context3 = viewGroup.getContext();
                kotlin.g.b.p.g(context3, "container.context");
                layoutParams5.height = (int) context3.getResources().getDimension(R.dimen.cl);
                View findViewById5 = viewGroup.findViewById(R.id.jti);
                if (!(findViewById5 == null || (layoutParams2 = findViewById5.getLayoutParams()) == null)) {
                    Context context4 = viewGroup.getContext();
                    kotlin.g.b.p.g(context4, "container.context");
                    layoutParams2.width = (int) context4.getResources().getDimension(R.dimen.c8);
                }
                View findViewById6 = viewGroup.findViewById(R.id.jti);
                if (findViewById6 == null || (layoutParams = findViewById6.getLayoutParams()) == null) {
                    AppMethodBeat.o(260632);
                    return;
                }
                Context context5 = viewGroup.getContext();
                kotlin.g.b.p.g(context5, "container.context");
                layoutParams.height = (int) context5.getResources().getDimension(R.dimen.ce);
                AppMethodBeat.o(260632);
                return;
            }
            if (z) {
                this.UMh.setTextSize(1, 15.0f);
                this.UMi.setTextSize(1, 15.0f);
            } else {
                this.UMh.setTextSize(1, 17.0f);
                this.UMi.setTextSize(1, 17.0f);
            }
            this.uqj.setTextSize(1, 22.0f);
            AppMethodBeat.o(260632);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$ComboIdBackToLiveInfo;", "", "()V", "comboSumCount", "", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "giftId", "", "getGiftId", "()Ljava/lang/String;", "setGiftId", "(Ljava/lang/String;)V", "isPreciousGift", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setPreciousGift", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isSelf", "", "()Z", "setSelf", "(Z)V", "quitTime", "", "getQuitTime", "()J", "setQuitTime", "(J)V", "plugin-finder_release"})
    public static final class f {
        volatile boolean dJM;
        long jmU;
        AtomicBoolean upP = new AtomicBoolean(false);
        volatile int upS;
        private volatile String upZ = "";

        public f() {
            AppMethodBeat.i(260634);
            AppMethodBeat.o(260634);
        }

        public final void bxI(String str) {
            AppMethodBeat.i(260633);
            kotlin.g.b.p.h(str, "<set-?>");
            this.upZ = str;
            AppMethodBeat.o(260633);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0004\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ)\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0018RL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletFadeInEvaluator;", "Landroid/animation/FloatEvaluator;", "fadeDuration", "", "stayDuration", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "fraction", "", "flying", "", "(IILkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "fadeFraction", "evaluate", "startValue", "", "endValue", "(FLjava/lang/Number;Ljava/lang/Number;)Ljava/lang/Float;", "plugin-finder_release"})
    public static final class d extends FloatEvaluator {
        private final float UMd;
        private kotlin.g.a.m<? super Float, ? super Boolean, x> gWp;

        public d(int i2, kotlin.g.a.m<? super Float, ? super Boolean, x> mVar) {
            AppMethodBeat.i(260627);
            this.gWp = mVar;
            this.UMd = 500.0f / ((float) (i2 + 500));
            AppMethodBeat.o(260627);
        }

        @Override // android.animation.TypeEvaluator, android.animation.FloatEvaluator
        public final /* bridge */ /* synthetic */ Object evaluate(float f2, Object obj, Object obj2) {
            AppMethodBeat.i(260626);
            Float evaluate = evaluate(f2, (Number) obj, (Number) obj2);
            AppMethodBeat.o(260626);
            return evaluate;
        }

        @Override // android.animation.FloatEvaluator
        public final Float evaluate(float f2, Number number, Number number2) {
            float floatValue;
            AppMethodBeat.i(260625);
            if (f2 < this.UMd) {
                kotlin.g.a.m<? super Float, ? super Boolean, x> mVar = this.gWp;
                if (mVar != null) {
                    mVar.invoke(Float.valueOf(f2), Boolean.TRUE);
                }
                if (number == null || number2 == null) {
                    Float valueOf = Float.valueOf(0.0f);
                    AppMethodBeat.o(260625);
                    return valueOf;
                }
                floatValue = number.floatValue() + (((number2.floatValue() - number.floatValue()) * f2) / this.UMd);
            } else {
                kotlin.g.a.m<? super Float, ? super Boolean, x> mVar2 = this.gWp;
                if (mVar2 != null) {
                    mVar2.invoke(Float.valueOf(f2), Boolean.FALSE);
                }
                Float f3 = (Float) (!(number2 instanceof Float) ? null : number2);
                floatValue = f3 != null ? f3.floatValue() : 1.0f;
            }
            Float valueOf2 = Float.valueOf(floatValue);
            AppMethodBeat.o(260625);
            return valueOf2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$timer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder_release"})
    public static final class o implements MTimerHandler.CallBack {
        final /* synthetic */ ae uqd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(ae aeVar) {
            this.uqd = aeVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(246704);
            com.tencent.mm.ac.d.h(new a(this));
            AppMethodBeat.o(246704);
            return false;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ o uqs;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(o oVar) {
                super(0);
                this.uqs = oVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(246703);
                ae.a(this.uqs.uqd);
                x xVar = x.SXb;
                AppMethodBeat.o(246703);
                return xVar;
            }
        }
    }

    private final ObjectAnimator e(ViewGroup viewGroup, boolean z) {
        ObjectAnimator ofFloat;
        AppMethodBeat.i(260641);
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(viewGroup, "alpha", 0.0f, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(viewGroup, "translationX", -500.0f, 0.0f);
        }
        kotlin.g.b.p.g(ofFloat, "bulletInAnim");
        ofFloat.setDuration((long) (ulA + 500));
        if (z) {
            ofFloat.setEvaluator(new d(ulA, new g(this, viewGroup)));
        } else {
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setEvaluator(new c(500, ulA, new h(this, viewGroup)));
        }
        ofFloat.addListener(new r(this, viewGroup, z));
        AppMethodBeat.o(260641);
        return ofFloat;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$createBulletInAnimator$3", "Landroid/animation/Animator$AnimatorListener;", "isCanceling", "", "()Z", "setCanceling", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class r implements Animator.AnimatorListener {
        final /* synthetic */ boolean UMl;
        final /* synthetic */ ae uqd;
        final /* synthetic */ ViewGroup uql;
        private boolean uqm;

        r(ae aeVar, ViewGroup viewGroup, boolean z) {
            this.uqd = aeVar;
            this.uql = viewGroup;
            this.UMl = z;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AtomicBoolean atomicBoolean;
            Object obj;
            AppMethodBeat.i(260638);
            Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationEnd: isCancel=" + this.uqm + ", bulletShowInfo: " + ((a) this.uqd.upE.get(this.uql)));
            if (this.uqm) {
                this.uqm = false;
                AppMethodBeat.o(260638);
                return;
            }
            a aVar = (a) this.uqd.upE.get(this.uql);
            if (aVar != null) {
                aVar.upO = true;
            }
            a aVar2 = (a) this.uqd.upE.get(this.uql);
            if (aVar2 == null || (atomicBoolean = aVar2.upP) == null || true != atomicBoolean.get()) {
                ObjectAnimator objectAnimator = (ObjectAnimator) this.uqd.upG.get(this.uql);
                if (objectAnimator != null) {
                    objectAnimator.start();
                    AppMethodBeat.o(260638);
                    return;
                }
                AppMethodBeat.o(260638);
                return;
            }
            Iterator it = kotlin.a.j.z(this.uqd.upE.entrySet()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (kotlin.g.b.p.j((ViewGroup) ((Map.Entry) next).getKey(), this.uql)) {
                    obj = next;
                    break;
                }
            }
            ae.a(this.uqd, (Map.Entry) obj);
            AppMethodBeat.o(260638);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(260639);
            this.uqm = true;
            Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationCancel: isCancel=" + this.uqm + ", bulletShowInfo:" + ((a) this.uqd.upE.get(this.uql)));
            AppMethodBeat.o(260639);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(260640);
            Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletInAnimator onAnimationStart: " + ((a) this.uqd.upE.get(this.uql)));
            com.tencent.mm.ac.d.h(new a(this));
            AppMethodBeat.o(260640);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ r UMm;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(r rVar) {
                super(0);
                this.UMm = rVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(260637);
                if (!this.UMm.UMl) {
                    this.UMm.uql.setAlpha(1.0f);
                }
                this.UMm.uql.setVisibility(0);
                x xVar = x.SXb;
                AppMethodBeat.o(260637);
                return xVar;
            }
        }
    }

    private final ObjectAnimator R(ViewGroup viewGroup) {
        AppMethodBeat.i(260642);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "alpha", 1.0f, 0.0f);
        kotlin.g.b.p.g(ofFloat, "bulletOutAnim");
        ofFloat.setDuration(500L);
        ofFloat.addListener(new i(this, viewGroup));
        AppMethodBeat.o(260642);
        return ofFloat;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$createBulletOutAnimator$1", "Landroid/animation/Animator$AnimatorListener;", "isCanceling", "", "()Z", "setCanceling", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class i implements Animator.AnimatorListener {
        final /* synthetic */ ae uqd;
        final /* synthetic */ ViewGroup uql;
        private boolean uqm;

        i(ae aeVar, ViewGroup viewGroup) {
            this.uqd = aeVar;
            this.uql = viewGroup;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AtomicBoolean atomicBoolean;
            AppMethodBeat.i(246694);
            Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationEnd: isCancel=" + this.uqm + ", bulletShowInfo: " + ((a) this.uqd.upE.get(this.uql)));
            if (this.uqm) {
                this.uqm = false;
                AppMethodBeat.o(246694);
                return;
            }
            com.tencent.mm.ac.d.h(new a(this));
            a aVar = (a) this.uqd.upE.get(this.uql);
            if (!(aVar == null || (atomicBoolean = aVar.upP) == null || true != atomicBoolean.get())) {
                b.C0376b.a(this.uqd.hOp, b.c.hML);
            }
            a aVar2 = (a) this.uqd.upE.get(this.uql);
            if (aVar2 != null) {
                aVar2.reset();
            }
            ae.g(this.uqd);
            AppMethodBeat.o(246694);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(246695);
            this.uqm = true;
            Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationCancel: isCancel=" + this.uqm + ", bulletShowInfo:" + ((a) this.uqd.upE.get(this.uql)));
            AppMethodBeat.o(246695);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(246696);
            Log.i("Finder.FinderLiveGiftQueuePlugin", "BulletOutAnimator onAnimationStart: " + ((a) this.uqd.upE.get(this.uql)));
            AppMethodBeat.o(246696);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ i uqo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(i iVar) {
                super(0);
                this.uqo = iVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(246693);
                this.uqo.uql.setVisibility(4);
                x xVar = x.SXb;
                AppMethodBeat.o(246693);
                return xVar;
            }
        }
    }

    private final synchronized void dhm() {
        p.b bxK;
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        AtomicBoolean atomicBoolean3;
        p.c dii;
        String str;
        AtomicBoolean atomicBoolean4;
        AtomicBoolean atomicBoolean5;
        AppMethodBeat.i(246708);
        Map.Entry<ViewGroup, a> dhn = dhn();
        if ((dhn != null) && dhn != null && !dhn.getValue().upQ && (dii = this.upJ.dii()) != null && dii.compareTo((Enum) p.c.SELF_NORMAL_GIFT_COMBO) < 0) {
            T t = (T) dhn.getKey();
            p.b dik = this.upJ.dik();
            if (!(t == null || dik == null)) {
                Log.i("Finder.FinderLiveGiftQueuePlugin", "replaceBullet, originSpace BulletShowingInfo=" + this.upE.get(t) + ", giftShowInfo=" + dik);
                z.f fVar = new z.f();
                fVar.SYG = t;
                String str2 = dik.UMe;
                a aVar = this.upE.get(t);
                if (aVar != null) {
                    str = aVar.UMe;
                } else {
                    str = null;
                }
                if (!str2.equals(str)) {
                    Map<ViewGroup, a> map = this.upE;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<ViewGroup, a> entry : map.entrySet()) {
                        if (entry.getValue().UMe.equals(dik.UMe)) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    LinkedHashMap linkedHashMap2 = linkedHashMap;
                    ArrayList arrayList = new ArrayList(linkedHashMap2.size());
                    for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                        arrayList.add((ViewGroup) entry2.getKey());
                    }
                    ArrayList arrayList2 = arrayList;
                    if (!arrayList2.isEmpty()) {
                        fVar.SYG = (T) ((ViewGroup) arrayList2.get(0));
                    }
                }
                if (!kotlin.g.b.p.j(fVar.SYG, t)) {
                    Log.i("Finder.FinderLiveGiftQueuePlugin", "replaceBullet, targetSpace BulletShowingInfo=" + this.upE.get(fVar.SYG));
                    a aVar2 = this.upE.get(t);
                    if (aVar2 != null) {
                        aVar2.reset();
                    }
                }
                a aVar3 = this.upE.get(fVar.SYG);
                if (aVar3 != null) {
                    aVar3.reset();
                }
                a aVar4 = this.upE.get(fVar.SYG);
                if (!(aVar4 == null || (atomicBoolean5 = aVar4.upN) == null)) {
                    atomicBoolean5.getAndSet(true);
                }
                a aVar5 = this.upE.get(fVar.SYG);
                if (!(aVar5 == null || (atomicBoolean4 = aVar5.upP) == null)) {
                    atomicBoolean4.getAndSet(dik.uwW);
                }
                a aVar6 = this.upE.get(fVar.SYG);
                if (aVar6 != null) {
                    String str3 = dik.upR;
                    if (str3 == null) {
                        str3 = "";
                    }
                    aVar6.atJ(str3);
                }
                com.tencent.mm.ac.d.h(new n(this, fVar, t, dik));
            }
        }
        Map<ViewGroup, a> map2 = this.upE;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry<ViewGroup, a> entry3 : map2.entrySet()) {
            if (entry3.getValue().UMf.get()) {
                linkedHashMap3.put(entry3.getKey(), entry3.getValue());
            }
        }
        Iterator it = linkedHashMap3.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                AppMethodBeat.o(246708);
                break;
            }
            Map.Entry entry4 = (Map.Entry) it.next();
            Log.i("Finder.FinderLiveGiftQueuePlugin", "pollNextGiftShowInfo: index = " + ((a) entry4.getValue()).index + " \n current bulletInfo = " + this.upE + " \n current gift queue size: " + this.upJ.size());
            if (!this.upJ.hasNext()) {
                AppMethodBeat.o(246708);
                break;
            } else if (((a) entry4.getValue()).upN.get()) {
                p.b bxM = this.upJ.bxM(((a) entry4.getValue()).upR);
                if (bxM != null) {
                    a((ViewGroup) entry4.getKey(), bxM);
                }
            } else {
                boolean z = dhn() != null;
                Log.i("Finder.FinderLiveGiftQueuePlugin", "pollNextGiftShowInfo: isPreciousGiftShowing = ".concat(String.valueOf(z)));
                if (z) {
                    bxK = this.upJ.bxJ(((a) entry4.getValue()).UMe);
                } else {
                    bxK = this.upJ.bxK(((a) entry4.getValue()).UMe);
                }
                if (bxK != null) {
                    Log.i("Finder.FinderLiveGiftQueuePlugin", "pollNextGiftShowInfo: giftShowInfo = ".concat(String.valueOf(bxK)));
                    if (((a) entry4.getValue()).upW) {
                        if (!z) {
                            if (!(bxK == null ? false : bxK.uwW)) {
                            }
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) entry4.getKey();
                    if (!(viewGroup == null || bxK == null)) {
                        a aVar7 = this.upE.get(viewGroup);
                        if (aVar7 == null || (atomicBoolean3 = aVar7.upN) == null || true != atomicBoolean3.get()) {
                            a aVar8 = this.upE.get(viewGroup);
                            if (!(aVar8 == null || (atomicBoolean2 = aVar8.upN) == null)) {
                                atomicBoolean2.getAndSet(true);
                            }
                            a aVar9 = this.upE.get(viewGroup);
                            if (!(aVar9 == null || (atomicBoolean = aVar9.upP) == null)) {
                                atomicBoolean.getAndSet(bxK.uwW);
                            }
                            a aVar10 = this.upE.get(viewGroup);
                            if (aVar10 != null) {
                                String str4 = bxK.upR;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                aVar10.atJ(str4);
                            }
                            com.tencent.mm.ac.d.h(new k(this, viewGroup, bxK));
                        } else {
                            a(viewGroup, bxK);
                        }
                    }
                    this.upJ.b(bxK);
                }
            }
        }
    }

    private final void a(ViewGroup viewGroup, p.b bVar) {
        AppMethodBeat.i(246710);
        if (viewGroup == null || bVar == null) {
            AppMethodBeat.o(246710);
            return;
        }
        com.tencent.mm.ac.d.h(new m(this, viewGroup, bVar));
        AppMethodBeat.o(246710);
    }

    private static void a(String str, a aVar) {
        AppMethodBeat.i(246711);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        long longValue = com.tencent.mm.plugin.finder.storage.c.dwc().value().longValue();
        com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
        Long l2 = com.tencent.mm.plugin.finder.live.model.e.dfx().get(str);
        long longValue2 = l2 != null ? l2.longValue() / 1000 : longValue;
        if (0 == longValue2) {
            StringBuilder sb = new StringBuilder("updatePreciousGiftTotalShowingTime: giftFullPagDurationMap value = ");
            com.tencent.mm.plugin.finder.live.model.e eVar2 = com.tencent.mm.plugin.finder.live.model.e.uiD;
            Log.i("Finder.FinderLiveGiftQueuePlugin", sb.append(com.tencent.mm.plugin.finder.live.model.e.dfx().get(str)).toString());
            longValue2 = longValue;
        }
        aVar.upX = (long) (((float) longValue2) * 0.9f * ((float) (aVar.upS - aVar.upU)));
        Log.i("Finder.FinderLiveGiftQueuePlugin", "updatePreciousGiftTotalShowingTime: giftId=" + str + ',' + " durationMs=" + longValue2 + ", totalShowingTime=" + aVar.upX);
        AppMethodBeat.o(246711);
    }

    private final Map.Entry<ViewGroup, a> dhn() {
        boolean z;
        AppMethodBeat.i(246712);
        List c2 = kotlin.m.i.c(kotlin.m.i.a(kotlin.a.ae.cw(this.upE), j.uqp));
        if (!c2.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Map.Entry<ViewGroup, a> entry = (Map.Entry) c2.get(0);
            AppMethodBeat.o(246712);
            return entry;
        }
        AppMethodBeat.o(246712);
        return null;
    }

    static /* synthetic */ boolean a(ae aeVar) {
        AppMethodBeat.i(246714);
        boolean g2 = aeVar.g((Map.Entry<? extends ViewGroup, a>) null);
        AppMethodBeat.o(246714);
        return g2;
    }

    private final boolean g(Map.Entry<? extends ViewGroup, a> entry) {
        AtomicBoolean atomicBoolean;
        AppMethodBeat.i(246713);
        if (entry == null) {
            entry = dhn();
        }
        if (entry != null) {
            long aWA = entry.getValue().upX - (cl.aWA() - entry.getValue().upY);
            Log.i("Finder.FinderLiveGiftQueuePlugin", "checkIfPreciousGiftTimeOver: remainingTime=" + aWA + ", entry=" + entry);
            if (aWA > 100) {
                this.timer.startTimer(aWA);
                AppMethodBeat.o(246713);
                return true;
            }
            ObjectAnimator objectAnimator = this.upG.get(entry.getKey());
            if (objectAnimator == null) {
                Log.i("Finder.FinderLiveGiftQueuePlugin", "checkIfPreciousGiftTimeOver: fake container");
                b.C0376b.a(this.hOp, b.c.hML);
                a aVar = this.upE.get(this.ULX);
                if (!(aVar == null || (atomicBoolean = aVar.upN) == null)) {
                    atomicBoolean.getAndSet(false);
                }
                dhm();
            } else if (!objectAnimator.isRunning()) {
                com.tencent.mm.ac.d.h(new q(objectAnimator));
            }
            AppMethodBeat.o(246713);
            return false;
        }
        AppMethodBeat.o(246713);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(246715);
        super.mount();
        this.upJ.a(this);
        AppMethodBeat.o(246715);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246716);
        super.unMount();
        this.timer.stopTimer();
        com.tencent.mm.ac.d.h(new p(this));
        this.upJ.b(this);
        AppMethodBeat.o(246716);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p.a
    public final void a(p.c cVar) {
        AppMethodBeat.i(246717);
        kotlin.g.b.p.h(cVar, "giftType");
        com.tencent.mm.ac.d.h(new l(this));
        dhm();
        AppMethodBeat.o(246717);
    }

    public final void dho() {
        AppMethodBeat.i(246718);
        if (this.upJ.hasNext()) {
            com.tencent.mm.ac.d.h(new e(this));
            dhm();
        }
        AppMethodBeat.o(246718);
    }

    private final void S(ViewGroup viewGroup) {
        AppMethodBeat.i(260643);
        a aVar = this.upE.get(viewGroup);
        if (aVar != null) {
            aVar.reset();
            aVar.UMf.getAndSet(false);
        }
        viewGroup.setVisibility(8);
        AppMethodBeat.o(260643);
    }

    private final void T(ViewGroup viewGroup) {
        AppMethodBeat.i(260644);
        if (!this.upE.containsKey(viewGroup)) {
            AppMethodBeat.o(260644);
            return;
        }
        a(this.upE.get(viewGroup));
        Log.i("Finder.FinderLiveGiftQueuePlugin", "unregisterOuterSpace: info:" + this.upE.get(viewGroup));
        this.upE.remove(viewGroup);
        this.upF.remove(viewGroup);
        this.upG.remove(viewGroup);
        this.UMa.removeView(viewGroup);
        if (this.upE.size() == this.ULY) {
            Log.i("Finder.FinderLiveGiftQueuePlugin", "unregisterOuterSpace: enable origin three container");
            U(this.upB);
            U(this.upC);
            U(this.upD);
        }
        AppMethodBeat.o(260644);
    }

    private final void U(ViewGroup viewGroup) {
        AppMethodBeat.i(260645);
        a aVar = this.upE.get(viewGroup);
        if (aVar != null) {
            aVar.UMf.getAndSet(true);
            AppMethodBeat.o(260645);
            return;
        }
        AppMethodBeat.o(260645);
    }

    @Override // com.tencent.mm.live.c.a
    public final void a(LinkedHashMap<String, Rect> linkedHashMap, boolean z) {
        T t;
        String str;
        String str2;
        T t2;
        String str3;
        AppMethodBeat.i(260646);
        kotlin.g.b.p.h(linkedHashMap, "micUserMap");
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = getLiveData().UPZ;
        Log.i("Finder.FinderLiveGiftQueuePlugin", "onAudienceMicUserChanged: linkMicList size:" + list.size());
        if (list.isEmpty()) {
            for (Map.Entry<String, ViewGroup> entry : this.ULZ.entrySet()) {
                T(entry.getValue());
            }
            this.ULZ.clear();
            AppMethodBeat.o(260646);
            return;
        }
        Iterator<Map.Entry<String, ViewGroup>> it = this.ULZ.entrySet().iterator();
        while (it.hasNext()) {
            ViewGroup value = it.next().getValue();
            a aVar = this.upE.get(value);
            kotlin.g.b.p.g(list, "linkMicList");
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it2.next();
                String str4 = t2.username;
                if (aVar != null) {
                    str3 = aVar.UMe;
                } else {
                    str3 = null;
                }
                if (TextUtils.equals(str4, str3)) {
                    break;
                }
            }
            if (t2 == null) {
                T(value);
                it.remove();
            }
        }
        for (Map.Entry<String, Rect> entry2 : linkedHashMap.entrySet()) {
            kotlin.g.b.p.g(list, "linkMicList");
            Iterator<T> it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    t = null;
                    break;
                }
                T next = it3.next();
                if (entry2.getKey().equals(next.uCo)) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (this.ULZ.containsKey(entry2.getKey())) {
                Log.i("Finder.FinderLiveGiftQueuePlugin", "onAudienceMicUserChanged: adjustContainerLocation, sdkUserId = " + entry2.getKey());
                a(this.ULZ.get(entry2.getKey()), entry2.getValue(), t3);
            } else {
                Rect value2 = entry2.getValue();
                ViewGroup viewGroup = this.UMa;
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ado, viewGroup, false);
                if (inflate == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(260646);
                    throw tVar;
                }
                ViewGroup viewGroup2 = (ViewGroup) inflate;
                viewGroup.addView(viewGroup2);
                a(viewGroup2, value2, t3);
                viewGroup2.setVisibility(8);
                if (t3 == null || (str2 = t3.username) == null) {
                    str = getLiveData().hwd;
                } else {
                    str = str2;
                }
                if (this.upE.size() == this.ULY) {
                    Log.i("Finder.FinderLiveGiftQueuePlugin", "registerOuterSpace: disable origin three container");
                    Map.Entry<ViewGroup, a> dhn = dhn();
                    a(dhn != null ? dhn.getValue() : null);
                    S(this.upB);
                    S(this.upC);
                    S(this.upD);
                }
                this.upE.put(viewGroup2, new a(this, viewGroup2, this.upE.size(), this.upK, false, true, 8));
                a aVar2 = this.upE.get(viewGroup2);
                if (aVar2 != null) {
                    aVar2.bxH(str);
                }
                Log.i("Finder.FinderLiveGiftQueuePlugin", "registerOuterSpace: info:" + this.upE.get(viewGroup2));
                this.upF.put(viewGroup2, e(viewGroup2, true));
                this.upG.put(viewGroup2, R(viewGroup2));
                a aVar3 = this.upE.get(viewGroup2);
                if (aVar3 != null) {
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    com.tencent.mm.plugin.finder.utils.m.p(aVar3.upV.uqj);
                }
                this.ULZ.put(entry2.getKey(), viewGroup2);
                Log.i("Finder.FinderLiveGiftQueuePlugin", "onAudienceMicUserChanged: outerSpaceMap add new entry, key = " + entry2.getKey() + ", value = " + viewGroup2);
            }
        }
        AppMethodBeat.o(260646);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isEqual(r2, r1 != null ? r1.djq() : null) != false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(android.view.ViewGroup r6, android.graphics.Rect r7, com.tencent.mm.plugin.finder.live.viewmodel.e r8) {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.ae.a(android.view.ViewGroup, android.graphics.Rect, com.tencent.mm.plugin.finder.live.viewmodel.e):void");
    }

    private final void a(a aVar) {
        AppMethodBeat.i(260648);
        if (aVar == null) {
            AppMethodBeat.o(260648);
            return;
        }
        if (aVar.upN.get() && aVar.upP.get() && !aVar.UMg) {
            b(aVar);
        }
        AppMethodBeat.o(260648);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ae uqd;
        final /* synthetic */ ViewGroup uqq;
        final /* synthetic */ p.b uqr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(ae aeVar, ViewGroup viewGroup, p.b bVar) {
            super(0);
            this.uqd = aeVar;
            this.uqq = viewGroup;
            this.uqr = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246699);
            Log.i("Finder.FinderLiveGiftQueuePlugin", "launchBulletInAnimation, BulletShowingInfo=" + ((a) this.uqd.upE.get(this.uqq)) + ", giftShowInfo=" + this.uqr);
            ae.a(this.uqd, (a) this.uqd.upE.get(this.uqq), this.uqr);
            ObjectAnimator objectAnimator = (ObjectAnimator) this.uqd.upF.get(this.uqq);
            if (objectAnimator != null) {
                objectAnimator.start();
            }
            a aVar = (a) this.uqd.upE.get(this.uqq);
            if (aVar != null) {
                aVar.upY = cl.aWA();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246699);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ae uqd;
        final /* synthetic */ ViewGroup uqq;
        final /* synthetic */ p.b uqr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(ae aeVar, ViewGroup viewGroup, p.b bVar) {
            super(0);
            this.uqd = aeVar;
            this.uqq = viewGroup;
            this.uqr = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Object obj;
            ObjectAnimator objectAnimator;
            AppMethodBeat.i(246701);
            Log.i("Finder.FinderLiveGiftQueuePlugin", "relaunchBulletInAnimation, BulletShowingInfo=" + ((a) this.uqd.upE.get(this.uqq)) + ", giftShowInfo=" + this.uqr);
            a aVar = (a) this.uqd.upE.get(this.uqq);
            if (aVar != null) {
                String str = "bulletInfoMap " + this.uqq + " giftShowInfo:" + this.uqr.upS + " reward:" + this.uqr.uwV + " comboSumCount:" + aVar.upS;
                if (this.uqr.upS > aVar.upS) {
                    aVar.upS = this.uqr.upS;
                } else {
                    aVar.upS += this.uqr.uwV;
                }
                aVar.ak(aVar.upS, this.uqr.upQ);
                Log.i("Finder.FinderLiveGiftQueuePlugin", "loginfo " + str + " result " + aVar.upS);
                if (aVar.upP.get()) {
                    String str2 = this.uqr.upZ;
                    if (str2 == null) {
                        str2 = "";
                    }
                    ae.b(str2, aVar);
                }
                if (!aVar.uqc) {
                    ObjectAnimator objectAnimator2 = (ObjectAnimator) this.uqd.upG.get(this.uqq);
                    if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                        objectAnimator2.cancel();
                    }
                    if (aVar.upO && (objectAnimator = (ObjectAnimator) this.uqd.upF.get(this.uqq)) != null) {
                        objectAnimator.start();
                    }
                    this.uqq.setAlpha(1.0f);
                    this.uqq.setVisibility(0);
                    if (!aVar.upP.get()) {
                        ObjectAnimator objectAnimator3 = (ObjectAnimator) this.uqd.upF.get(this.uqq);
                        if (objectAnimator3 != null) {
                            objectAnimator3.setCurrentPlayTime(550);
                        }
                    } else if (this.uqd.timer.stopped()) {
                        Iterator it = kotlin.a.j.z(this.uqd.upE.entrySet()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            Object next = it.next();
                            if (kotlin.g.b.p.j((ViewGroup) ((Map.Entry) next).getKey(), this.uqq)) {
                                obj = next;
                                break;
                            }
                        }
                        ae.a(this.uqd, (Map.Entry) obj);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246701);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class n extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ z.f UMn;
        final /* synthetic */ ViewGroup UMo;
        final /* synthetic */ ae uqd;
        final /* synthetic */ p.b uqr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(ae aeVar, z.f fVar, ViewGroup viewGroup, p.b bVar) {
            super(0);
            this.uqd = aeVar;
            this.UMn = fVar;
            this.UMo = viewGroup;
            this.uqr = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            a aVar;
            AtomicBoolean atomicBoolean;
            AppMethodBeat.i(246702);
            Log.i("Finder.FinderLiveGiftQueuePlugin", "replaceBullet ui thread: target BulletShowingInfo=" + ((a) this.uqd.upE.get(this.UMn.SYG)) + ", origin BulletShowingInfo=" + ((a) this.uqd.upE.get(this.UMo)) + ", giftShowInfo=" + this.uqr);
            ObjectAnimator objectAnimator = (ObjectAnimator) this.uqd.upF.get(this.UMn.SYG);
            if (objectAnimator != null && objectAnimator.isRunning()) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimator2 = (ObjectAnimator) this.uqd.upG.get(this.UMn.SYG);
            if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                objectAnimator2.cancel();
            }
            if ((!kotlin.g.b.p.j(this.UMn.SYG, this.UMo)) && ((aVar = (a) this.uqd.upE.get(this.UMo)) == null || (atomicBoolean = aVar.upN) == null || !atomicBoolean.get())) {
                ObjectAnimator objectAnimator3 = (ObjectAnimator) this.uqd.upF.get(this.UMo);
                if (objectAnimator3 != null && objectAnimator3.isRunning()) {
                    objectAnimator3.cancel();
                }
                ObjectAnimator objectAnimator4 = (ObjectAnimator) this.uqd.upG.get(this.UMo);
                if (objectAnimator4 != null && !objectAnimator4.isRunning()) {
                    objectAnimator4.start();
                }
            }
            ae.a(this.uqd, (a) this.uqd.upE.get(this.UMn.SYG), this.uqr);
            ObjectAnimator objectAnimator5 = (ObjectAnimator) this.uqd.upF.get(this.UMn.SYG);
            if (objectAnimator5 != null) {
                objectAnimator5.start();
            }
            a aVar2 = (a) this.uqd.upE.get(this.UMn.SYG);
            if (aVar2 != null) {
                aVar2.upY = cl.aWA();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246702);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class q extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ObjectAnimator UMk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(ObjectAnimator objectAnimator) {
            super(0);
            this.UMk = objectAnimator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260635);
            this.UMk.start();
            x xVar = x.SXb;
            AppMethodBeat.o(260635);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ae uqd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(ae aeVar) {
            super(0);
            this.uqd = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246705);
            for (Map.Entry entry : this.uqd.upF.entrySet()) {
                ((ObjectAnimator) entry.getValue()).cancel();
            }
            for (Map.Entry entry2 : this.uqd.upG.entrySet()) {
                ((ObjectAnimator) entry2.getValue()).cancel();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246705);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ae uqd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(ae aeVar) {
            super(0);
            this.uqd = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246700);
            this.uqd.rg(0);
            x xVar = x.SXb;
            AppMethodBeat.o(246700);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ae uqd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ae aeVar) {
            super(0);
            this.uqd = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246685);
            this.uqd.rg(0);
            x xVar = x.SXb;
            AppMethodBeat.o(246685);
            return xVar;
        }
    }

    private final void b(a aVar) {
        Object obj;
        AppMethodBeat.i(260649);
        if (!aVar.upP.get()) {
            AppMethodBeat.o(260649);
            return;
        }
        Log.i("Finder.FinderLiveGiftQueuePlugin", "cloneToFakeContainer: origin info = ".concat(String.valueOf(aVar)));
        a aVar2 = this.upE.get(this.ULX);
        if (aVar2 != null) {
            aVar2.upX = aVar.upX;
            aVar2.upY = aVar.upY;
            aVar2.upN.getAndSet(true);
            if (this.timer.stopped()) {
                Iterator it = kotlin.a.j.z(this.upE.entrySet()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it.next();
                    if (kotlin.g.b.p.j((ViewGroup) ((Map.Entry) next).getKey(), this.ULX)) {
                        obj = next;
                        break;
                    }
                }
                g((Map.Entry) obj);
            }
            AppMethodBeat.o(260649);
            return;
        }
        AppMethodBeat.o(260649);
    }

    public static final /* synthetic */ void a(ae aeVar, a aVar, p.b bVar) {
        String str;
        int i2;
        int i3;
        FinderContact finderContact;
        String dM;
        avn avn;
        String str2 = null;
        AppMethodBeat.i(246723);
        if (aVar != null) {
            String str3 = bVar.upZ;
            if (str3 == null) {
                str3 = "";
            }
            kotlin.g.b.p.h(str3, "<set-?>");
            aVar.upZ = str3;
            String str4 = bVar.upR;
            if (str4 == null) {
                str = "";
            } else {
                str = str4;
            }
            if (!aeVar.upH.containsKey(str)) {
                i2 = 0;
            } else {
                f fVar = aeVar.upH.get(str);
                if (fVar == null) {
                    i2 = 0;
                } else {
                    i2 = fVar.upS;
                    n.a aVar2 = com.tencent.mm.plugin.finder.live.util.n.uwR;
                    if (cl.aWA() - fVar.jmU > ((long) (com.tencent.mm.plugin.finder.live.util.n.uwQ * 1000))) {
                        i2 = 0;
                    }
                    aeVar.upH.remove(str);
                    Log.i("Finder.FinderLiveGiftQueuePlugin", "checkInfoFromComboIdBackToLiveMap: comboId=" + str + ", quitTime=" + fVar.jmU + ", result=" + i2);
                }
            }
            aVar.upU = i2;
            if (bVar.upS > 0) {
                i3 = bVar.upS;
            } else {
                i3 = bVar.uwV + aVar.upU;
            }
            aVar.upS = i3;
            aVar.ak(aVar.upS, bVar.upQ);
            if (bVar.uwW) {
                String str5 = bVar.upZ;
                if (str5 == null) {
                    str5 = "";
                }
                a(str5, aVar);
            }
            aVar.upQ = bVar.upQ;
            auz auz = bVar.uwU;
            com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
            s atA = com.tencent.mm.plugin.finder.live.model.e.atA(auz.LFM);
            if (atA != null) {
                Context context = aeVar.hwr.getContext();
                TextView textView = aVar.upV.UMh;
                aut aut = bVar.uwX;
                if (aut == null || (avn = aut.LFE) == null) {
                    finderContact = null;
                } else {
                    finderContact = avn.contact;
                }
                TextView textView2 = aVar.upV.UMh;
                boolean z = aVar.upV.UMj;
                y yVar = y.vXH;
                String str6 = finderContact != null ? finderContact.username : null;
                if (finderContact != null) {
                    str2 = finderContact.nickname;
                }
                String hf = y.hf(str6, str2);
                if (z) {
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    dM = com.tencent.mm.plugin.finder.utils.m.dM(hf, 4);
                } else if (aeVar.upA <= 0) {
                    com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
                    dM = com.tencent.mm.plugin.finder.convert.d.e(textView2, hf);
                } else {
                    com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                    dM = com.tencent.mm.plugin.finder.utils.m.dM(hf, aeVar.upA);
                }
                textView.setText(dM);
                if (aVar.upV.UMj) {
                    aVar.upV.UMi.setText(context.getString(R.string.csm, ""));
                } else {
                    aVar.upV.UMi.setText(context.getString(R.string.csm, atA.field_name));
                }
                com.tencent.mm.plugin.finder.live.model.e eVar2 = com.tencent.mm.plugin.finder.live.model.e.uiD;
                if (com.tencent.mm.plugin.finder.live.model.e.getDebug()) {
                    PAGView pAGView = aVar.upV.uqi;
                    Context context2 = aeVar.hwr.getContext();
                    kotlin.g.b.p.g(context2, "root.context");
                    AssetManager assets = context2.getAssets();
                    com.tencent.mm.plugin.finder.live.model.e eVar3 = com.tencent.mm.plugin.finder.live.model.e.uiD;
                    String bf = com.tencent.mm.plugin.finder.live.model.e.bf(bVar.upZ, true);
                    if (bf == null) {
                        bf = "";
                    }
                    pAGView.setFile(PAGFile.Load(assets, bf));
                } else {
                    PAGView pAGView2 = aVar.upV.uqi;
                    com.tencent.mm.plugin.finder.live.model.e eVar4 = com.tencent.mm.plugin.finder.live.model.e.uiD;
                    String bf2 = com.tencent.mm.plugin.finder.live.model.e.bf(bVar.upZ, true);
                    if (bf2 == null) {
                        bf2 = "";
                    }
                    pAGView2.setFile(PAGFile.Load(bf2));
                }
                aVar.upV.uqi.setRepeatCount(-1);
                aVar.upV.uqi.play();
                aVar.upV.uqi.flush();
                Bundle bundle = new Bundle();
                bundle.putString("PARAM_LIVE_GIFT_INFO", auz.LFM);
                bundle.putBoolean("PARAM_LIVE_GIFT_IS_FORCE_REPLACE", true);
                aeVar.hOp.statusChange(b.c.hMK, bundle);
            }
        }
        AppMethodBeat.o(246723);
    }
}
