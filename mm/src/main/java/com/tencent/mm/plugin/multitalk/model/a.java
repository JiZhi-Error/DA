package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.model.b;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView;
import com.tencent.mm.plugin.multitalk.ui.widget.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ah;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0002VWB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010'\u001a\u00020\rJ\u0014\u0010(\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0*J\u0006\u0010+\u001a\u00020\rJ\u0006\u0010,\u001a\u00020\rJ\u0006\u0010-\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u0017J\u0010\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\fJ\u0010\u00103\u001a\u0004\u0018\u00010\u00072\u0006\u00102\u001a\u00020\fJ\u0006\u00104\u001a\u00020\fJ\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u0015H\u0016J\u0012\u00108\u001a\u0004\u0018\u0001062\u0006\u00102\u001a\u00020\fH\u0016J\u000e\u00109\u001a\u00020\u00152\u0006\u00102\u001a\u00020\fJ\b\u0010:\u001a\u00020\rH\u0002J\b\u0010;\u001a\u00020\rH\u0002J\u0014\u0010<\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0*J\u0006\u0010=\u001a\u00020\u0017J\u0006\u0010>\u001a\u00020\u0017J\u000e\u0010?\u001a\u00020\u00172\u0006\u00102\u001a\u00020\fJ\u0012\u0010@\u001a\u00020\r2\b\u0010A\u001a\u0004\u0018\u000101H\u0016J\b\u0010B\u001a\u00020\rH\u0016J\u0014\u0010C\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0*J&\u0010D\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020 J(\u0010G\u001a\u00020\r2\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020\u00172\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\f0LH\u0002J\u000e\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u0017J\u0016\u0010O\u001a\u00020\r2\u0006\u00102\u001a\u00020\f2\u0006\u0010P\u001a\u00020\u0015J\u0010\u0010Q\u001a\u00020\r2\u0006\u00102\u001a\u00020\fH\u0002J\u0010\u0010R\u001a\u00020\r2\u0006\u00102\u001a\u00020\fH\u0002J\u0006\u0010S\u001a\u00020\rJ\u000e\u0010T\u001a\u00020\r2\u0006\u00102\u001a\u00020\fJ\u0016\u0010U\u001a\u00020\r2\u0006\u00102\u001a\u00020\f2\u0006\u0010P\u001a\u00020\u0015R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\"X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u00020$8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006X"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "Landroid/view/View$OnClickListener;", "()V", "bigAvatarAdapter", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "bigAvatarHolder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "bigAvatarLayout", "Landroid/widget/RelativeLayout;", "dispatchToAvatarEvent", "Lkotlin/Function1;", "", "", "dispatchToScreenCastBigEvent", "dispatchToScreenCastSmallEvent", "dispatchToVideoBigEvent", "dispatchToVideoSmallEvent", "firstScreenUser", "handlerMap", "", "", "screenCastBigLoadingShow", "", "screenCastUiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "showElement", "talkingAvatarContainer", "Landroid/support/v7/widget/RecyclerView;", "talkingBigAvatarLayout", "Landroid/widget/FrameLayout;", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManagerUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "videoDisplayDataMuxer", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "getVideoDisplayDataMuxer", "()Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "close", "closeMemberToVideo", "videoUserSet", "", "closeScreenCastBig", "displayVoiceTalkingIcon", "displayWeakNetWorkIcon", "finish", "isMini", "getAvatarViewGroupByUsername", "Landroid/view/View;", "wxUserName", "getAvatarViewHolderByUsername", "getBigHolderWxUserName", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "getUserState", "hideScreenCastBig", "hideVideoBig", "initCurrentViewStatus", "isBigAvatarScreenCastting", "isBigAvatarVideo", "isScreenCastPause", "onClick", "v", "onScreenFrame", "openMemberToVideo", "registerView", "mainUI", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "setBigAvatarUserState", "member", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "is2GOr3G", "currentVideoSet", "Ljava/util/HashSet;", "setMute", "isMute", "setStatus", "state", "showScreenCastBig", "showVideoBig", "unregisterView", "updateAvatar", "userStateTrans", "Companion", "ScreenCastReceiverUiCallbackImpl", "plugin-multitalk_release"})
public final class a implements View.OnClickListener, g {
    public static final C1489a zLe = new C1489a((byte) 0);
    private final Map<Integer, kotlin.g.a.b<String, x>> iFL;
    private RecyclerView zKN;
    private FrameLayout zKO;
    private RelativeLayout zKP;
    public b zKQ;
    com.tencent.mm.plugin.multitalk.ui.widget.b zKR;
    public com.tencent.mm.plugin.multitalk.ui.widget.a zKS;
    public ArrayMap<String, Integer> zKT = new ArrayMap<>();
    private i zKU;
    private String zKV = "";
    private boolean zKW;
    private ae zKX;
    private final kotlin.g.a.b<String, x> zKY;
    private final kotlin.g.a.b<String, x> zKZ;
    private final kotlin.g.a.b<String, x> zLa;
    private final kotlin.g.a.b<String, x> zLb;
    private final kotlin.g.a.b<String, x> zLc;
    private boolean zLd;

    static {
        AppMethodBeat.i(239592);
        AppMethodBeat.o(239592);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "wxUserName", "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a zLf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.zLf = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0154  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0157  */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke(java.lang.String r9) {
            /*
            // Method dump skipped, instructions count: 432
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.a.c.invoke(java.lang.Object):java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "wxUserName", "", "invoke"})
    static final class d extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a zLf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(1);
            this.zLf = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(239569);
            String str2 = str;
            p.h(str2, "wxUserName");
            Integer num = (Integer) this.zLf.zKT.get(str2);
            if (num == null) {
                Log.e("AvatarViewManager", "unable trans state to screen cast big");
            } else if (num != null && num.intValue() == 3) {
                this.zLf.zKT.put(str2, 4);
                a.c(this.zLf).bJ(2, str2);
                a.c(this.zLf, str2);
                q eom = ac.eom();
                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                p.n(eom.enn().zHD, 0, 4, 2);
            } else if (num != null && num.intValue() == 4) {
                Log.i("AvatarViewManager", "trans state from screen cast big to screen cast big");
            } else {
                Log.e("AvatarViewManager", "unable to trans from " + num + " to ScreenCastBig");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239569);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "wxUserName", "", "invoke"})
    static final class e extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a zLf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar) {
            super(1);
            this.zLf = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            boolean z;
            MultitalkFrameView multitalkFrameView;
            AppMethodBeat.i(239570);
            String str2 = str;
            p.h(str2, "wxUserName");
            Integer num = (Integer) this.zLf.zKT.get(str2);
            Log.printInfoStack("AvatarViewManager", str2 + " dispatchToScreenCastSmallEvent is " + num, new Object[0]);
            if (num != null && num.intValue() == 0) {
                if (TextUtils.isEmpty(this.zLf.zKV)) {
                    this.zLf.zKV = str2;
                }
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA = this.zLf.aFA(str2);
                if (aFA != null) {
                    MultitalkFrameView multitalkFrameView2 = aFA.zQT;
                    if (multitalkFrameView2 != null) {
                        multitalkFrameView2.epa();
                    }
                    aFA.Rq(0);
                    z = true;
                } else {
                    z = true;
                }
            } else if (num != null && num.intValue() == 4) {
                a.c(this.zLf).bJ(0, str2);
                a.f(this.zLf);
                z = true;
            } else if (num != null && num.intValue() == 3) {
                RelativeLayout relativeLayout = this.zLf.zKP;
                if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
                    com.tencent.mm.plugin.multitalk.ui.widget.b bVar = this.zLf.zKR;
                    if (p.j((bVar == null || (multitalkFrameView = bVar.zQT) == null) ? null : multitalkFrameView.getUsername(), str2)) {
                        a.f(this.zLf);
                    }
                }
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA2 = this.zLf.aFA(str2);
                if (aFA2 != null) {
                    MultitalkFrameView multitalkFrameView3 = aFA2.zQT;
                    if (multitalkFrameView3 != null) {
                        multitalkFrameView3.epa();
                    }
                    aFA2.Rq(0);
                }
                Log.i("AvatarViewManager", "trans state from screen cast small to screen cast small");
                z = true;
            } else if (num != null && num.intValue() == 1) {
                if (TextUtils.isEmpty(this.zLf.zKV)) {
                    this.zLf.zKV = str2;
                }
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA3 = this.zLf.aFA(str2);
                if (aFA3 != null) {
                    MultitalkFrameView multitalkFrameView4 = aFA3.zQT;
                    if (multitalkFrameView4 != null) {
                        multitalkFrameView4.epa();
                    }
                    aFA3.Rq(0);
                    z = true;
                } else {
                    z = true;
                }
            } else if (num != null && num.intValue() == 2) {
                a.c(this.zLf).bJ(0, str2);
                a.d(this.zLf);
                if (TextUtils.isEmpty(this.zLf.zKV)) {
                    this.zLf.zKV = str2;
                }
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA4 = this.zLf.aFA(str2);
                if (aFA4 != null) {
                    MultitalkFrameView multitalkFrameView5 = aFA4.zQT;
                    if (multitalkFrameView5 != null) {
                        multitalkFrameView5.epa();
                    }
                    aFA4.Rq(0);
                    z = true;
                } else {
                    z = true;
                }
            } else if (num == null) {
                if (TextUtils.isEmpty(this.zLf.zKV)) {
                    this.zLf.zKV = str2;
                }
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA5 = this.zLf.aFA(str2);
                if (aFA5 != null) {
                    MultitalkFrameView multitalkFrameView6 = aFA5.zQT;
                    if (multitalkFrameView6 != null) {
                        multitalkFrameView6.epa();
                    }
                    aFA5.Rq(0);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                Log.e("AvatarViewManager", "error to trans state from " + num + " to SCREEN CAST SMALL");
                z = false;
            }
            if (z) {
                this.zLf.zKT.put(str2, 3);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239570);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "wxUserName", "", "invoke"})
    static final class f extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a zLf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar) {
            super(1);
            this.zLf = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0043, code lost:
            if (r0 == null) goto L_0x0045;
         */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke(java.lang.String r6) {
            /*
            // Method dump skipped, instructions count: 164
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.a.f.invoke(java.lang.Object):java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "wxUserName", "", "invoke"})
    static final class g extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a zLf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(a aVar) {
            super(1);
            this.zLf = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            boolean z;
            MultitalkFrameView multitalkFrameView;
            MultitalkFrameView multitalkFrameView2;
            MultitalkFrameView multitalkFrameView3;
            AppMethodBeat.i(239572);
            String str2 = str;
            p.h(str2, "wxUserName");
            Integer num = (Integer) this.zLf.zKT.get(str2);
            if (num != null && num.intValue() == 0) {
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA = this.zLf.aFA(str2);
                if (aFA == null || (multitalkFrameView = aFA.zQT) == null) {
                    z = true;
                } else {
                    multitalkFrameView.eoZ();
                    z = true;
                }
            } else if (num != null && num.intValue() == 2) {
                a.c(this.zLf).bJ(0, str2);
                a.d(this.zLf);
                z = true;
            } else if (num != null && num.intValue() == 3) {
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA2 = this.zLf.aFA(str2);
                if (aFA2 != null) {
                    MultitalkFrameView multitalkFrameView4 = aFA2.zQT;
                    if (multitalkFrameView4 != null) {
                        multitalkFrameView4.eoZ();
                    }
                    aFA2.Rq(8);
                    z = true;
                } else {
                    z = true;
                }
            } else if (num != null && num.intValue() == 1) {
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA3 = this.zLf.aFA(str2);
                if (!(aFA3 == null || (multitalkFrameView2 = aFA3.zQT) == null)) {
                    multitalkFrameView2.eoZ();
                }
                Log.i("AvatarViewManager", "from small to small");
                z = true;
            } else if (num == null) {
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA4 = this.zLf.aFA(str2);
                if (aFA4 == null || (multitalkFrameView3 = aFA4.zQT) == null) {
                    z = true;
                } else {
                    multitalkFrameView3.eoZ();
                    z = true;
                }
            } else {
                Log.e("AvatarViewManager", "error to trans state from " + this.zLf + " to VIDEO SMALL");
                z = false;
            }
            if (z) {
                this.zLf.zKT.put(str2, 1);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239572);
            return xVar;
        }
    }

    public a() {
        AppMethodBeat.i(239591);
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        ae enz = eom.enz();
        p.g(enz, "SubCoreMultiTalk.getMult…kManager().videoDataMuxer");
        this.zKX = enz;
        this.zKY = new c(this);
        this.zKZ = new g(this);
        this.zLa = new f(this);
        this.zLb = new e(this);
        this.zLc = new d(this);
        this.iFL = ae.e(s.U(0, this.zKY), s.U(1, this.zKZ), s.U(2, this.zLa), s.U(3, this.zLb), s.U(4, this.zLc));
        this.zLd = true;
        AppMethodBeat.o(239591);
    }

    public static final /* synthetic */ ae c(a aVar) {
        AppMethodBeat.i(239593);
        ae elY = aVar.elY();
        AppMethodBeat.o(239593);
        return elY;
    }

    public static final /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(239596);
        aVar.emd();
        AppMethodBeat.o(239596);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager$Companion;", "", "()V", "AVATAR", "", "SCREEN_CAST_BIG", "SCREEN_CAST_SMALL", "TAG", "", "VIDEO_BIG", "VIDEO_SMALL", "plugin-multitalk_release"})
    /* renamed from: com.tencent.mm.plugin.multitalk.model.a$a  reason: collision with other inner class name */
    public static final class C1489a {
        private C1489a() {
        }

        public /* synthetic */ C1489a(byte b2) {
            this();
        }
    }

    private final ae elY() {
        boolean z;
        AppMethodBeat.i(239575);
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        ae enz = eom.enz();
        p.g(enz, "SubCoreMultiTalk.getMult…kManager().videoDataMuxer");
        this.zKX = enz;
        ae aeVar = this.zKX;
        a aVar = this;
        p.h(aVar, "container");
        ArrayList<g> arrayList = aeVar.zPa;
        if (arrayList == null || !arrayList.contains(aVar)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.zKX.a(this);
        }
        ae aeVar2 = this.zKX;
        AppMethodBeat.o(239575);
        return aeVar2;
    }

    public final void a(RecyclerView recyclerView, FrameLayout frameLayout, MultiTalkMainUI multiTalkMainUI, b bVar) {
        AppMethodBeat.i(239576);
        p.h(recyclerView, "talkingAvatarContainer");
        p.h(frameLayout, "talkingBigAvatarLayout");
        p.h(multiTalkMainUI, "mainUI");
        p.h(bVar, "uiCallback");
        this.zKQ = bVar;
        this.zKN = recyclerView;
        this.zKO = frameLayout;
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutAdapter");
            AppMethodBeat.o(239576);
            throw tVar;
        }
        this.zKS = (com.tencent.mm.plugin.multitalk.ui.widget.a) adapter;
        c.a aVar = com.tencent.mm.plugin.multitalk.ui.widget.c.zRp;
        MultiTalkMainUI multiTalkMainUI2 = multiTalkMainUI;
        FrameLayout frameLayout2 = frameLayout;
        a aVar2 = this;
        p.h(multiTalkMainUI2, "context");
        p.h(frameLayout2, "parent");
        p.h(aVar2, "clickListener");
        View inflate = LayoutInflater.from(multiTalkMainUI2).inflate(R.layout.b54, (ViewGroup) frameLayout2, false);
        if (inflate == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(239576);
            throw tVar2;
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        com.tencent.mm.plugin.multitalk.ui.widget.b bVar2 = new com.tencent.mm.plugin.multitalk.ui.widget.b(relativeLayout);
        bVar2.zQT = (MultitalkFrameView) relativeLayout.findViewById(R.id.iie);
        MultitalkFrameView multitalkFrameView = bVar2.zQT;
        if (multitalkFrameView != null) {
            multitalkFrameView.setIndex(0);
        }
        MultitalkFrameView multitalkFrameView2 = bVar2.zQT;
        if (multitalkFrameView2 != null) {
            multitalkFrameView2.setOnClickListener(aVar2);
        }
        bVar2.maskView = relativeLayout.findViewById(R.id.fac);
        View findViewById = relativeLayout.findViewById(R.id.j9s);
        if (findViewById == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(239576);
            throw tVar3;
        }
        bVar2.zQU = (ImageView) findViewById;
        View findViewById2 = relativeLayout.findViewById(R.id.fpk);
        if (findViewById2 == null) {
            t tVar4 = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(239576);
            throw tVar4;
        }
        bVar2.zQV = (ImageView) findViewById2;
        View findViewById3 = relativeLayout.findViewById(R.id.ifa);
        if (findViewById3 == null) {
            t tVar5 = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(239576);
            throw tVar5;
        }
        bVar2.zQW = (TextView) findViewById3;
        View findViewById4 = relativeLayout.findViewById(R.id.epk);
        if (findViewById4 == null) {
            t tVar6 = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(239576);
            throw tVar6;
        }
        bVar2.zhh = (ImageView) findViewById4;
        relativeLayout.setTag(bVar2);
        this.zKP = relativeLayout;
        RelativeLayout relativeLayout2 = this.zKP;
        Object tag = relativeLayout2 != null ? relativeLayout2.getTag() : null;
        if (tag == null) {
            t tVar7 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutHolder");
            AppMethodBeat.o(239576);
            throw tVar7;
        }
        this.zKR = (com.tencent.mm.plugin.multitalk.ui.widget.b) tag;
        frameLayout.addView(this.zKP);
        RelativeLayout relativeLayout3 = this.zKP;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        frameLayout.setVisibility(8);
        this.zKU = new b();
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        eom.enw().a(this.zKU);
        elY();
        AppMethodBeat.o(239576);
    }

    private void elZ() {
        AppMethodBeat.i(239577);
        this.zKR = null;
        this.zKS = null;
        this.zKP = null;
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        eom.enz().b(this);
        AppMethodBeat.o(239577);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(239578);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (emb()) {
            if (this.zLd) {
                b bVar2 = this.zKQ;
                if (bVar2 != null) {
                    bVar2.eml();
                }
                this.zLd = false;
            } else {
                b bVar3 = this.zKQ;
                if (bVar3 != null) {
                    bVar3.emk();
                }
                this.zLd = true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(239578);
        } else if (view == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView");
            AppMethodBeat.o(239578);
            throw tVar;
        } else {
            MultitalkFrameView multitalkFrameView = (MultitalkFrameView) view;
            if (multitalkFrameView.getUsername() == null) {
                Log.e("AvatarViewManager", "videoview get null username");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(239578);
                return;
            }
            FrameLayout frameLayout = this.zKO;
            if (frameLayout == null || frameLayout.getVisibility() != 0) {
                if (multitalkFrameView.epd()) {
                    eL(multitalkFrameView.getUsername(), 4);
                    p.zMs++;
                    b bVar4 = this.zKQ;
                    if (bVar4 != null) {
                        bVar4.emm();
                    }
                } else {
                    eL(multitalkFrameView.getUsername(), 2);
                    b bVar5 = this.zKQ;
                    if (bVar5 != null) {
                        bVar5.emn();
                    }
                }
            } else if (multitalkFrameView.epd()) {
                eL(multitalkFrameView.getUsername(), 3);
                b bVar6 = this.zKQ;
                if (bVar6 != null) {
                    bVar6.emn();
                }
            } else {
                eL(multitalkFrameView.getUsername(), 1);
                b bVar7 = this.zKQ;
                if (bVar7 != null) {
                    bVar7.emn();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/model/AvatarViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(239578);
        }
    }

    public final com.tencent.mm.plugin.multitalk.ui.widget.b aFA(String str) {
        View view;
        T t;
        int i2;
        String str2;
        MultiTalkGroupMember multiTalkGroupMember;
        AppMethodBeat.i(239579);
        p.h(str, "wxUserName");
        p.h(str, "wxUserName");
        com.tencent.mm.plugin.multitalk.ui.widget.a aVar = this.zKS;
        if (aVar != null) {
            p.h(str, "userName");
            Iterator<T> it = aVar.zQI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t2 = next;
                if (t2 == null || (multiTalkGroupMember = t2.zHg) == null) {
                    str2 = null;
                } else {
                    str2 = multiTalkGroupMember.RHb;
                }
                if (p.j(str2, str)) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                i2 = t3.index;
            } else {
                i2 = -1;
            }
            int i3 = i2 + aVar.wqJ;
            RecyclerView recyclerView = this.zKN;
            if (recyclerView != null) {
                view = recyclerView.getChildAt(i3);
            } else {
                view = null;
            }
        } else {
            view = null;
        }
        if (view != null) {
            RecyclerView recyclerView2 = this.zKN;
            RecyclerView.v bi = recyclerView2 != null ? recyclerView2.bi(view) : null;
            if (bi instanceof com.tencent.mm.plugin.multitalk.ui.widget.b) {
                com.tencent.mm.plugin.multitalk.ui.widget.b bVar = (com.tencent.mm.plugin.multitalk.ui.widget.b) bi;
                AppMethodBeat.o(239579);
                return bVar;
            }
            AppMethodBeat.o(239579);
            return null;
        }
        AppMethodBeat.o(239579);
        return null;
    }

    public final synchronized void eL(String str, int i2) {
        int i3;
        i iVar;
        AppMethodBeat.i(239580);
        p.h(str, "wxUserName");
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        int aGj = eom.enw().aGj(str);
        if (i2 == 1 && (aGj == 101 || aGj == 102)) {
            i3 = 3;
        } else {
            i3 = i2;
        }
        Log.printInfoStack("AvatarViewManager", str + " to state " + i3, new Object[0]);
        kotlin.g.a.b<String, x> bVar = this.iFL.get(Integer.valueOf(i3));
        if (bVar != null) {
            bVar.invoke(str);
        }
        if (i2 == 1 && aGj == 102 && (iVar = this.zKU) != null) {
            iVar.aFC(str);
            AppMethodBeat.o(239580);
        } else {
            AppMethodBeat.o(239580);
        }
    }

    public final void ema() {
        com.tencent.mm.plugin.multitalk.ui.widget.b bVar;
        MultitalkFrameView multitalkFrameView;
        String username;
        AppMethodBeat.i(239581);
        FrameLayout frameLayout = this.zKO;
        if (frameLayout == null) {
            AppMethodBeat.o(239581);
        } else if (frameLayout.getVisibility() != 0 || (bVar = this.zKR) == null || (multitalkFrameView = bVar.zQT) == null || (username = multitalkFrameView.getUsername()) == null) {
            AppMethodBeat.o(239581);
        } else {
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            int aGj = eom.enw().aGj(username);
            if (aGj == 103 || aGj == 100) {
                emd();
                AppMethodBeat.o(239581);
                return;
            }
            eL(username, 3);
            AppMethodBeat.o(239581);
        }
    }

    public final boolean emb() {
        MultitalkFrameView multitalkFrameView;
        AppMethodBeat.i(239582);
        FrameLayout frameLayout = this.zKO;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            com.tencent.mm.plugin.multitalk.ui.widget.b bVar = this.zKR;
            if ((bVar == null || (multitalkFrameView = bVar.zQT) == null) ? false : multitalkFrameView.epd()) {
                AppMethodBeat.o(239582);
                return true;
            }
        }
        AppMethodBeat.o(239582);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x002a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p(java.util.Set<java.lang.String> r10) {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.a.p(java.util.Set):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0033 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(java.util.Set<java.lang.String> r10) {
        /*
        // Method dump skipped, instructions count: 329
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.a.q(java.util.Set):void");
    }

    public final void r(Set<String> set) {
        CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> copyOnWriteArrayList;
        MultitalkFrameView multitalkFrameView;
        boolean z;
        AppMethodBeat.i(239585);
        p.h(set, "videoUserSet");
        com.tencent.mm.plugin.multitalk.ui.widget.a aVar = this.zKS;
        if (aVar == null || (copyOnWriteArrayList = aVar.zQI) == null) {
            AppMethodBeat.o(239585);
            return;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            String str = it.next().zHg.RHb;
            p.g(str, "it.member.usrName");
            com.tencent.mm.plugin.multitalk.ui.widget.b aFA = aFA(str);
            if (!(aFA == null || (multitalkFrameView = aFA.zQT) == null)) {
                if (multitalkFrameView.getUsername() == null || !(!p.j(z.aTY(), multitalkFrameView.getUsername()))) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    multitalkFrameView = null;
                }
                if (multitalkFrameView != null) {
                    if (!set.contains(multitalkFrameView.getUsername())) {
                        eL(multitalkFrameView.getUsername(), 0);
                    } else if (multitalkFrameView.epc()) {
                        eL(multitalkFrameView.getUsername(), 1);
                    }
                }
            }
        }
        AppMethodBeat.o(239585);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void hb(boolean r10) {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.a.hb(boolean):void");
    }

    @Override // com.tencent.mm.plugin.multitalk.model.g
    public final f Rc(int i2) {
        MultitalkFrameView multitalkFrameView;
        AppMethodBeat.i(239587);
        com.tencent.mm.plugin.multitalk.ui.widget.b bVar = this.zKR;
        if (bVar != null) {
            if (1 <= i2 && 5 >= i2) {
                com.tencent.mm.ac.d.h(new h(bVar, i2));
            }
            multitalkFrameView = bVar.zQT;
        } else {
            multitalkFrameView = null;
        }
        MultitalkFrameView multitalkFrameView2 = multitalkFrameView;
        AppMethodBeat.o(239587);
        return multitalkFrameView2;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.g
    public final f aFB(String str) {
        MultitalkFrameView multitalkFrameView = null;
        AppMethodBeat.i(239588);
        p.h(str, "wxUserName");
        com.tencent.mm.plugin.multitalk.ui.widget.b aFA = aFA(str);
        if (aFA != null) {
            if (!(aFA.lR() >= 0)) {
                aFA = null;
            }
            if (aFA != null) {
                multitalkFrameView = aFA.zQT;
            }
        }
        MultitalkFrameView multitalkFrameView2 = multitalkFrameView;
        AppMethodBeat.o(239588);
        return multitalkFrameView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r0.zRi == 1) goto L_0x0013;
     */
    @Override // com.tencent.mm.plugin.multitalk.model.g
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void emc() {
        /*
            r3 = this;
            r2 = 239589(0x3a7e5, float:3.35736E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            boolean r0 = r3.zKW
            if (r0 != 0) goto L_0x0013
            com.tencent.mm.plugin.multitalk.ui.widget.b r0 = r3.zKR
            if (r0 == 0) goto L_0x0021
            int r0 = r0.zRi
            r1 = 1
            if (r0 != r1) goto L_0x001d
        L_0x0013:
            com.tencent.mm.plugin.multitalk.model.a$i r0 = new com.tencent.mm.plugin.multitalk.model.a$i
            r0.<init>(r3)
            kotlin.g.a.a r0 = (kotlin.g.a.a) r0
            com.tencent.mm.ac.d.h(r0)
        L_0x001d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0020:
            return
        L_0x0021:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.a.emc():void");
    }

    private final void emd() {
        AppMethodBeat.i(239590);
        RecyclerView recyclerView = this.zKN;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        b bVar = this.zKQ;
        if (bVar != null) {
            bVar.emj();
        }
        b bVar2 = this.zKQ;
        if (bVar2 != null) {
            b.a.a(bVar2, "");
        }
        com.tencent.mm.plugin.multitalk.ui.widget.b bVar3 = this.zKR;
        if (bVar3 != null) {
            MultitalkFrameView multitalkFrameView = bVar3.zQT;
            if (multitalkFrameView != null) {
                multitalkFrameView.epb();
            }
            com.tencent.mm.plugin.multitalk.ui.widget.b.b(bVar3);
            bVar3.eoB();
        }
        FrameLayout frameLayout = this.zKO;
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(239590);
                throw tVar;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            b bVar4 = this.zKQ;
            if (bVar4 != null) {
                int[] eme = bVar4.eme();
                layoutParams2.topMargin = eme[1] - eme[0];
            }
            frameLayout.setLayoutParams(layoutParams2);
            frameLayout.setVisibility(8);
        }
        b bVar5 = this.zKQ;
        if (bVar5 != null) {
            bVar5.emn();
        }
        ac.eom().bR("", true);
        AppMethodBeat.o(239590);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\rH\u0002¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager$ScreenCastReceiverUiCallbackImpl;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "(Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;)V", "markPause", "", "wxUserName", "", "markRestart", "markResume", "markStart", "markStop", "updateTask", "task", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "plugin-multitalk_release"})
    public final class b implements i {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.multitalk.model.a$b$a  reason: collision with other inner class name */
        static final class C1490a extends q implements kotlin.g.a.b<com.tencent.mm.plugin.multitalk.ui.widget.b, x> {
            public static final C1490a zLg = new C1490a();

            static {
                AppMethodBeat.i(239562);
                AppMethodBeat.o(239562);
            }

            C1490a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.multitalk.ui.widget.b bVar) {
                AppMethodBeat.i(239561);
                com.tencent.mm.plugin.multitalk.ui.widget.b bVar2 = bVar;
                p.h(bVar2, LocaleUtil.ITALIAN);
                com.tencent.mm.plugin.multitalk.ui.widget.b.b(bVar2);
                bVar2.eoB();
                x xVar = x.SXb;
                AppMethodBeat.o(239561);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.plugin.multitalk.model.i
        public final void afd(String str) {
            AppMethodBeat.i(239563);
            p.h(str, "wxUserName");
            a.this.eL(str, 3);
            AppMethodBeat.o(239563);
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x004c  */
        @Override // com.tencent.mm.plugin.multitalk.model.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void aFC(java.lang.String r7) {
            /*
                r6 = this;
                r3 = 1
                r1 = 0
                r5 = 239564(0x3a7cc, float:3.357E-40)
                r4 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                java.lang.String r0 = "wxUserName"
                kotlin.g.b.p.h(r7, r0)
                com.tencent.mm.plugin.multitalk.model.a r0 = com.tencent.mm.plugin.multitalk.model.a.this
                com.tencent.mm.plugin.multitalk.ui.widget.b r0 = r0.aFA(r7)
                if (r0 == 0) goto L_0x0026
                com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView r2 = r0.zQT
                if (r2 == 0) goto L_0x0054
                boolean r2 = r2.epd()
            L_0x001f:
                if (r2 == 0) goto L_0x0056
            L_0x0021:
                if (r0 == 0) goto L_0x0026
                r0.Z(r3, r4)
            L_0x0026:
                com.tencent.mm.plugin.multitalk.model.a r0 = com.tencent.mm.plugin.multitalk.model.a.this
                com.tencent.mm.plugin.multitalk.ui.widget.b r2 = com.tencent.mm.plugin.multitalk.model.a.a(r0)
                if (r2 == 0) goto L_0x005e
                com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView r0 = r2.zQT
                if (r0 == 0) goto L_0x0058
                java.lang.String r0 = r0.getUsername()
            L_0x0036:
                boolean r0 = kotlin.g.b.p.j(r0, r7)
                if (r0 == 0) goto L_0x005c
                com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView r0 = r2.zQT
                if (r0 == 0) goto L_0x005a
                boolean r0 = r0.epd()
            L_0x0044:
                if (r0 == 0) goto L_0x005c
                r0 = r3
            L_0x0047:
                if (r0 == 0) goto L_0x004a
                r1 = r2
            L_0x004a:
                if (r1 == 0) goto L_0x005e
                r0 = 3
                com.tencent.mm.plugin.multitalk.ui.widget.b.a(r1, r4, r4, r0)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            L_0x0053:
                return
            L_0x0054:
                r2 = r4
                goto L_0x001f
            L_0x0056:
                r0 = r1
                goto L_0x0021
            L_0x0058:
                r0 = r1
                goto L_0x0036
            L_0x005a:
                r0 = r4
                goto L_0x0044
            L_0x005c:
                r0 = r4
                goto L_0x0047
            L_0x005e:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                goto L_0x0053
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.a.b.aFC(java.lang.String):void");
        }

        @Override // com.tencent.mm.plugin.multitalk.model.i
        public final void aFD(String str) {
            MultitalkFrameView multitalkFrameView;
            AppMethodBeat.i(239565);
            p.h(str, "wxUserName");
            a.this.eL(str, 3);
            com.tencent.mm.plugin.multitalk.ui.widget.b bVar = a.this.zKR;
            if (p.j((bVar == null || (multitalkFrameView = bVar.zQT) == null) ? null : multitalkFrameView.getUsername(), str)) {
                a.this.eL(str, 4);
            }
            AppMethodBeat.o(239565);
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x008f  */
        @Override // com.tencent.mm.plugin.multitalk.model.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void aFE(java.lang.String r8) {
            /*
            // Method dump skipped, instructions count: 155
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.a.b.aFE(java.lang.String):void");
        }

        @Override // com.tencent.mm.plugin.multitalk.model.i
        public final void aFF(String str) {
            AppMethodBeat.i(239567);
            p.h(str, "wxUserName");
            a.this.eL(str, 0);
            AppMethodBeat.o(239567);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/AvatarViewManager$getLargeRenderTarget$1$1"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.multitalk.ui.widget.b zLh;
        final /* synthetic */ int zLi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(com.tencent.mm.plugin.multitalk.ui.widget.b bVar, int i2) {
            super(0);
            this.zLh = bVar;
            this.zLi = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z = true;
            AppMethodBeat.i(239573);
            boolean z2 = this.zLi == 1 || this.zLi == 3;
            if (z2 != this.zLh.zRe) {
                this.zLh.zRe = z2;
                com.tencent.mm.plugin.multitalk.ui.widget.b bVar = this.zLh;
                if (z2) {
                    z = false;
                }
                com.tencent.mm.plugin.multitalk.ui.widget.b.a(bVar, z);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239573);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a zLf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar) {
            super(0);
            this.zLf = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            MultitalkFrameView multitalkFrameView;
            com.tencent.mm.plugin.multitalk.ui.widget.b bVar;
            AppMethodBeat.i(239574);
            com.tencent.mm.plugin.multitalk.ui.widget.b bVar2 = this.zLf.zKR;
            if (!(bVar2 == null || (multitalkFrameView = bVar2.zQT) == null || !multitalkFrameView.epd() || (bVar = this.zLf.zKR) == null)) {
                bVar.rR(false);
            }
            this.zLf.zKW = false;
            x xVar = x.SXb;
            AppMethodBeat.o(239574);
            return xVar;
        }
    }

    public static final /* synthetic */ void d(a aVar) {
        MultitalkFrameView multitalkFrameView;
        AppMethodBeat.i(239594);
        FrameLayout frameLayout = aVar.zKO;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        RecyclerView recyclerView = aVar.zKN;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        b bVar = aVar.zKQ;
        if (bVar != null) {
            b.a.a(bVar, "");
            bVar.emg();
        }
        com.tencent.mm.plugin.multitalk.ui.widget.b bVar2 = aVar.zKR;
        if (bVar2 == null || (multitalkFrameView = bVar2.zQT) == null) {
            AppMethodBeat.o(239594);
            return;
        }
        String username = multitalkFrameView.getUsername();
        if (username != null) {
            if (!(!p.j(username, z.aTY()))) {
                username = null;
            }
            if (username != null) {
                Log.d("AvatarViewManager", "steve: unsubscribe big video!");
                ac.eom().aGe("");
                com.tencent.mm.plugin.multitalk.d.a aVar2 = com.tencent.mm.plugin.multitalk.d.a.zYP;
                com.tencent.mm.plugin.multitalk.d.a.R(false, -1);
            }
        }
        multitalkFrameView.epb();
        AppMethodBeat.o(239594);
    }

    public static final /* synthetic */ void a(a aVar, String str) {
        MultiTalkGroupMember multiTalkGroupMember;
        String str2;
        MultitalkFrameView multitalkFrameView;
        MultitalkFrameView multitalkFrameView2;
        MultitalkFrameView.b currentSnapShot;
        MultitalkFrameView multitalkFrameView3;
        List<MultiTalkGroupMember> list;
        AppMethodBeat.i(239595);
        RecyclerView recyclerView = aVar.zKN;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FrameLayout frameLayout = aVar.zKO;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        b bVar = aVar.zKQ;
        int i2 = bVar != null ? bVar.eme()[0] : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = i2;
        layoutParams.height = i2;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        RelativeLayout relativeLayout = aVar.zKP;
        if (relativeLayout != null) {
            relativeLayout.setLayoutParams(layoutParams);
        }
        int aGF = com.tencent.mm.plugin.multitalk.d.e.aGF(str);
        if (!p.j(str, z.aTY())) {
            Log.d("AvatarViewManager", "click member id: %d", Integer.valueOf(aGF));
            ac.eom().aGe(str);
            com.tencent.mm.plugin.multitalk.d.a aVar2 = com.tencent.mm.plugin.multitalk.d.a.zYP;
            com.tencent.mm.plugin.multitalk.d.a.R(true, aGF);
        }
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        MultiTalkGroup enn = eom.enn();
        if (enn == null || (list = enn.RHa) == null) {
            multiTalkGroupMember = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                T t2 = t;
                if ((t2.status == 10 || t2.status == 1) && p.j(t2.RHb, str)) {
                    arrayList.add(t);
                }
            }
            multiTalkGroupMember = (MultiTalkGroupMember) j.ks(arrayList);
        }
        HashSet hashSet = new HashSet();
        q eom2 = ac.eom();
        p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
        hashSet.addAll(eom2.enr());
        com.tencent.mm.plugin.multitalk.ui.widget.b bVar2 = aVar.zKR;
        if (bVar2 != null) {
            MultitalkFrameView multitalkFrameView4 = bVar2.zQT;
            if (multitalkFrameView4 != null) {
                multitalkFrameView4.eN(str, com.tencent.mm.plugin.multitalk.d.e.aGF(str));
            }
            MultitalkFrameView multitalkFrameView5 = bVar2.zQT;
            if (multitalkFrameView5 != null) {
                multitalkFrameView5.eoZ();
            }
            com.tencent.mm.plugin.multitalk.ui.widget.b aFA = aVar.aFA(str);
            if (!(aFA == null || (multitalkFrameView2 = aFA.zQT) == null || (currentSnapShot = multitalkFrameView2.getCurrentSnapShot()) == null || (multitalkFrameView3 = bVar2.zQT) == null)) {
                multitalkFrameView3.a(currentSnapShot);
            }
        }
        b bVar3 = aVar.zKQ;
        if (bVar3 != null) {
            bVar3.emh();
        }
        RelativeLayout relativeLayout2 = aVar.zKP;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        b bVar4 = aVar.zKQ;
        boolean emf = bVar4 != null ? bVar4.emf() : false;
        com.tencent.mm.plugin.multitalk.ui.widget.b bVar5 = aVar.zKR;
        if (bVar5 != null) {
            if (multiTalkGroupMember != null) {
                MultitalkFrameView multitalkFrameView6 = bVar5.zQT;
                if (multitalkFrameView6 == null) {
                    p.hyc();
                }
                multitalkFrameView6.eN(multiTalkGroupMember.RHb, com.tencent.mm.plugin.multitalk.d.e.aGF(multiTalkGroupMember.RHb));
                MultitalkFrameView multitalkFrameView7 = bVar5.zQT;
                if (multitalkFrameView7 == null) {
                    p.hyc();
                }
                MultitalkFrameView multitalkFrameView8 = bVar5.zQT;
                if (multitalkFrameView8 == null) {
                    p.hyc();
                }
                multitalkFrameView7.setPosition(multitalkFrameView8.getIndex());
                if (multiTalkGroupMember.status != 10) {
                    View view = bVar5.maskView;
                    if (view == null) {
                        p.hyc();
                    }
                    view.setVisibility(0);
                    c.a aVar3 = com.tencent.mm.plugin.multitalk.ui.widget.c.zRp;
                    c.a.g(bVar5);
                } else {
                    View view2 = bVar5.maskView;
                    if (view2 == null) {
                        p.hyc();
                    }
                    view2.setVisibility(8);
                    c.a aVar4 = com.tencent.mm.plugin.multitalk.ui.widget.c.zRp;
                    c.a.h(bVar5);
                }
                if (!hashSet.contains(multiTalkGroupMember.RHb) || emf) {
                    MultitalkFrameView multitalkFrameView9 = bVar5.zQT;
                    if (multitalkFrameView9 == null) {
                        p.hyc();
                    }
                    multitalkFrameView9.eoY();
                } else {
                    MultitalkFrameView multitalkFrameView10 = bVar5.zQT;
                    if (multitalkFrameView10 == null) {
                        p.hyc();
                    }
                    multitalkFrameView10.eoZ();
                }
            } else {
                View view3 = bVar5.maskView;
                if (view3 == null) {
                    p.hyc();
                }
                view3.setVisibility(8);
                c.a aVar5 = com.tencent.mm.plugin.multitalk.ui.widget.c.zRp;
                c.a.h(bVar5);
                MultitalkFrameView multitalkFrameView11 = bVar5.zQT;
                if (multitalkFrameView11 == null) {
                    p.hyc();
                }
                multitalkFrameView11.epb();
            }
        }
        b bVar6 = aVar.zKQ;
        if (bVar6 != null) {
            com.tencent.mm.plugin.multitalk.ui.widget.b bVar7 = aVar.zKR;
            if (bVar7 == null || (multitalkFrameView = bVar7.zQT) == null || (str2 = multitalkFrameView.getNickName()) == null) {
                str2 = "";
            }
            bVar6.bQ(str2, false);
        }
        p.enl();
        AppMethodBeat.o(239595);
    }

    public static final /* synthetic */ void c(a aVar, String str) {
        String str2;
        String str3;
        String str4;
        MultitalkFrameView multitalkFrameView;
        boolean z;
        MultitalkFrameView.b currentSnapShot;
        AppMethodBeat.i(239597);
        b bVar = aVar.zKQ;
        if (bVar != null) {
            bVar.emi();
        }
        com.tencent.mm.plugin.multitalk.ui.widget.b aFA = aVar.aFA(str);
        if (aFA != null) {
            aFA.zRl = true;
            com.tencent.mm.plugin.multitalk.ui.widget.projector.c cVar = aFA.zRj;
            if (cVar != null) {
                cVar.epm();
            }
        }
        FrameLayout frameLayout = aVar.zKO;
        ViewGroup.LayoutParams layoutParams = frameLayout != null ? frameLayout.getLayoutParams() : null;
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(239597);
            throw tVar;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        b bVar2 = aVar.zKQ;
        layoutParams2.topMargin = bVar2 != null ? bVar2.deu() : 0;
        FrameLayout frameLayout2 = aVar.zKO;
        if (frameLayout2 != null) {
            frameLayout2.setLayoutParams(layoutParams2);
        }
        FrameLayout frameLayout3 = aVar.zKO;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        RecyclerView recyclerView = aVar.zKN;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        com.tencent.mm.plugin.multitalk.ui.widget.b bVar3 = aVar.zKR;
        if (bVar3 != null) {
            bVar3.eoB();
            aVar.zKW = true;
            MultitalkFrameView multitalkFrameView2 = bVar3.zQT;
            if (multitalkFrameView2 != null) {
                multitalkFrameView2.eN(str, com.tencent.mm.plugin.multitalk.d.e.aGF(str));
                multitalkFrameView2.epa();
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA2 = aVar.aFA(str);
                if (aFA2 != null) {
                    MultitalkFrameView multitalkFrameView3 = aFA2.zQT;
                    if (!(multitalkFrameView3 == null || (currentSnapShot = multitalkFrameView3.getCurrentSnapShot()) == null)) {
                        multitalkFrameView2.a(currentSnapShot);
                    }
                    if (aFA2.zRi == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        com.tencent.mm.plugin.multitalk.ui.widget.b bVar4 = aVar.zKR;
                        if (bVar4 != null) {
                            com.tencent.mm.plugin.multitalk.ui.widget.b.b(bVar4);
                        }
                        com.tencent.mm.plugin.multitalk.ui.widget.b bVar5 = aVar.zKR;
                        if (bVar5 != null) {
                            com.tencent.mm.plugin.multitalk.ui.widget.b.a(bVar5, false, false, 3);
                        }
                    }
                }
            }
            com.tencent.mm.plugin.multitalk.ui.widget.b.a(bVar3, false, false, 2);
        }
        RelativeLayout relativeLayout = aVar.zKP;
        if (relativeLayout != null) {
            ViewGroup.LayoutParams layoutParams3 = relativeLayout.getLayoutParams();
            if (layoutParams3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(239597);
                throw tVar2;
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.width = -1;
            layoutParams4.height = -1;
            layoutParams4.leftMargin = 0;
            layoutParams4.rightMargin = 0;
            relativeLayout.setLayoutParams(layoutParams4);
            relativeLayout.setVisibility(0);
            b bVar6 = aVar.zKQ;
            if (bVar6 != null) {
                com.tencent.mm.plugin.multitalk.d.e eVar = com.tencent.mm.plugin.multitalk.d.e.zZc;
                Context context = relativeLayout.getContext();
                p.g(context, "context");
                com.tencent.mm.plugin.multitalk.ui.widget.b bVar7 = aVar.zKR;
                if (bVar7 == null || (multitalkFrameView = bVar7.zQT) == null || (str2 = multitalkFrameView.getNickName()) == null) {
                    str2 = "";
                }
                p.h(context, "context");
                p.h(str2, "nickName");
                String eqf = com.tencent.mm.plugin.multitalk.d.e.eqf();
                if (eqf == null) {
                    eqf = context.getString(R.string.geg);
                    p.g(eqf, "context.getString(R.stri…reen_cast_title_template)");
                }
                if (eqf.length() < 3) {
                    str3 = eqf;
                } else if (eqf == null) {
                    t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(239597);
                    throw tVar3;
                } else {
                    str3 = eqf.substring(0, 3);
                    p.g(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                int i2 = ah.jS(context).width;
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 112);
                float fromDPToPix2 = (float) com.tencent.mm.cb.a.fromDPToPix(context, context.getResources().getDimension(R.dimen.af0));
                int i3 = com.tencent.mm.plugin.multitalk.d.e.i(str3, fromDPToPix2);
                int i4 = com.tencent.mm.plugin.multitalk.d.e.i(str2, fromDPToPix2);
                if (i3 + i4 + fromDPToPix <= i2 || i4 == 0) {
                    str4 = String.format(eqf, Arrays.copyOf(new Object[]{str2}, 1));
                    p.g(str4, "java.lang.String.format(this, *args)");
                } else {
                    int length = (int) (((((float) ((i2 - fromDPToPix) - i3)) / ((float) i4)) * ((float) str2.length())) - 1.0f);
                    if (length <= 0) {
                        str4 = String.format(eqf, Arrays.copyOf(new Object[]{""}, 1));
                        p.g(str4, "java.lang.String.format(this, *args)");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        String substring = str2.substring(0, length);
                        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        str4 = String.format(eqf, Arrays.copyOf(new Object[]{sb.append(substring).append("...").toString()}, 1));
                        p.g(str4, "java.lang.String.format(this, *args)");
                    }
                }
                bVar6.bQ(str4, false);
            }
        }
        if (!p.j(str, z.aUb())) {
            ac.eom().bR(str, false);
        }
        AppMethodBeat.o(239597);
    }
}
