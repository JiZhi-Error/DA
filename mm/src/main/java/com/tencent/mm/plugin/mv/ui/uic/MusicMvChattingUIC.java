package com.tencent.mm.plugin.mv.ui.uic;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mv.a.a.j;
import com.tencent.mm.plugin.mv.a.a.k;
import com.tencent.mm.plugin.mv.a.a.m;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001mB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\nJ\u000e\u0010P\u001a\u00020N2\u0006\u0010Q\u001a\u00020FJ\u000e\u0010R\u001a\u00020N2\u0006\u0010S\u001a\u00020FJ\u0010\u0010T\u001a\u00020N2\u0006\u0010=\u001a\u00020\u000fH\u0002J\b\u0010U\u001a\u00020NH\u0002J\u0006\u0010V\u001a\u00020\bJ\u0012\u0010W\u001a\u00020N2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u0012\u0010Z\u001a\u00020N2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010[\u001a\u00020NH\u0016J\u0010\u0010\\\u001a\u00020N2\u0006\u0010]\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u00020N2\u0006\u0010`\u001a\u00020aH\u0002J,\u0010b\u001a\u00020N2\u0006\u0010c\u001a\u00020\b2\u0006\u0010d\u001a\u00020\b2\b\u0010e\u001a\u0004\u0018\u00010\u00172\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\u0010\u0010h\u001a\u00020N2\u0006\u0010i\u001a\u00020aH\u0002J\u0016\u0010h\u001a\u00020N2\u0006\u0010j\u001a\u00020\u00172\u0006\u0010k\u001a\u00020lR9\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u0010/\u001a\u0012\u0012\u0004\u0012\u00020100j\b\u0012\u0004\u0012\u000201`2X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u00107\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0012\u0010;\u001a\u0006\u0012\u0002\b\u00030<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR-\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#`\u000b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\rR9\u0010E\u001a*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\t0\u0007j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\t`\u000b¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\rR\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R9\u0010K\u001a*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\t0\u0007j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\t`\u000b¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\r¨\u0006n"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvChattingUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "commentAreaRvMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;", "Lkotlin/collections/HashMap;", "getCommentAreaRvMap", "()Ljava/util/HashMap;", "hasJoinMsg", "", "getHasJoinMsg", "()Z", "setHasJoinMsg", "(Z)V", "heartBeatCookie", "Lcom/tencent/mm/protobuf/ByteString;", "joinMsg", "", "getJoinMsg", "()Ljava/lang/String;", "setJoinMsg", "(Ljava/lang/String;)V", "lastOnlineCount", "getLastOnlineCount", "()Ljava/lang/Integer;", "setLastOnlineCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lastOnlineCountTimestamp", "", "getLastOnlineCountTimestamp", "()Ljava/lang/Long;", "setLastOnlineCountTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "setListener", "(Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;)V", "liveMsgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "Lkotlin/collections/ArrayList;", "getLiveMsgList", "()Ljava/util/ArrayList;", "setLiveMsgList", "(Ljava/util/ArrayList;)V", "mmHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMmHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "offline", "onlineCount", "getOnlineCount", "()I", "setOnlineCount", "(I)V", "onlineUserTimeMap", "getOnlineUserTimeMap", "onlineUserTvMap", "Landroid/widget/TextView;", "getOnlineUserTvMap", "postLiveMsgScene", "Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvPostLiveMsg;", "songId", "userEnterTipTvMap", "getUserEnterTipTvMap", "addCommentAreaRv", "", "commentAreaRv", "addOnlineUserTv", "onlineUserTv", "addUserEnterTipTv", "userEnterTipTv", "doHeartBeatScene", "doJoinScene", "minHeight", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onHeartBeatCallback", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatResp;", "onPostMsgEnd", "msgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postLiveMsg", "msg", "toSendText", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "Companion", "plugin-mv_release"})
public final class MusicMvChattingUIC extends UIComponent implements i {
    public static final a Ate = new a((byte) 0);
    private static final int minHeight = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.cd);
    String AqO;
    private boolean AqQ;
    private com.tencent.mm.bw.b AsR;
    private int AsS;
    boolean AsT;
    String AsU = "";
    private ArrayList<MusicMvCommentView.b> AsV = new ArrayList<>();
    private Integer AsW;
    public final HashMap<Integer, Long> AsY = new HashMap<>();
    public com.tencent.mm.plugin.mv.ui.uic.a.a AsZ;
    com.tencent.mm.plugin.mv.a.a.l Ata;
    public final HashMap<Integer, WeakReference<TextView>> Atb = new HashMap<>();
    public final HashMap<Integer, WeakReference<TextView>> Atc = new HashMap<>();
    public final HashMap<Integer, WeakReference<MusicMvCommentView>> Atd = new HashMap<>();
    private Long UZT;
    private final IListener<?> lEl;
    private final MMHandler ndA = new MMHandler(Looper.getMainLooper(), new b(this));

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvChattingUIC$Companion;", "", "()V", "TAG", "", "minHeight", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvChattingUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257094);
        this.lEl = new c(this, appCompatActivity);
        AppMethodBeat.o(257094);
    }

    public static final /* synthetic */ void a(MusicMvChattingUIC musicMvChattingUIC) {
        AppMethodBeat.i(259236);
        musicMvChattingUIC.hWD();
        AppMethodBeat.o(259236);
    }

    public static final /* synthetic */ void b(MusicMvChattingUIC musicMvChattingUIC) {
        AppMethodBeat.i(259237);
        musicMvChattingUIC.sr(false);
        AppMethodBeat.o(259237);
    }

    static {
        AppMethodBeat.i(257095);
        AppMethodBeat.o(257095);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class b implements MMHandler.Callback {
        final /* synthetic */ MusicMvChattingUIC Atf;

        b(MusicMvChattingUIC musicMvChattingUIC) {
            this.Atf = musicMvChattingUIC;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(257086);
            switch (message.what) {
                case 0:
                    this.Atf.AsT = false;
                    MusicMvChattingUIC musicMvChattingUIC = this.Atf;
                    p.h("", "<set-?>");
                    musicMvChattingUIC.AsU = "";
                    Collection<WeakReference<TextView>> values = this.Atf.Atb.values();
                    p.g(values, "onlineUserTvMap.values");
                    Iterator<T> it = values.iterator();
                    while (it.hasNext()) {
                        TextView textView = (TextView) it.next().get();
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                    }
                    Collection<WeakReference<TextView>> values2 = this.Atf.Atc.values();
                    p.g(values2, "userEnterTipTvMap.values");
                    Iterator<T> it2 = values2.iterator();
                    while (it2.hasNext()) {
                        TextView textView2 = (TextView) it2.next().get();
                        if (textView2 != null) {
                            textView2.setVisibility(8);
                        }
                    }
                    break;
            }
            AppMethodBeat.o(257086);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(257087);
        super.onCreate(bundle);
        g.azz().a(6893, this);
        g.azz().a(6820, this);
        g.azz().a(6672, this);
        this.lEl.alive();
        AppMethodBeat.o(257087);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        AppMethodBeat.i(257088);
        hWD();
        AppMethodBeat.o(257088);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(257089);
        g.azz().b(6893, this);
        g.azz().b(6820, this);
        g.azz().b(6672, this);
        sr(true);
        this.lEl.dead();
        super.onDestroy();
        AppMethodBeat.o(257089);
    }

    private final void hWD() {
        AppMethodBeat.i(259235);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        g.azz().b(new k(((MusicMvDataUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class)).Aqo, getActivity().hashCode()));
        AppMethodBeat.o(259235);
    }

    private final void sr(boolean z) {
        AppMethodBeat.i(257090);
        this.AqQ = z;
        String str = this.AqO;
        if (str != null) {
            com.tencent.mm.bw.b bVar = this.AsR;
            if (bVar != null) {
                g.azz().b(new j(str, bVar, z, getActivity().hashCode()));
                AppMethodBeat.o(257090);
                return;
            }
            AppMethodBeat.o(257090);
            return;
        }
        AppMethodBeat.o(257090);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(257091);
        if (!(qVar instanceof m) || ((m) qVar).NoN == 0 || ((m) qVar).NoN == getActivity().hashCode()) {
            if (qVar instanceof j) {
                Log.i("MicroMsg.Mv.MusicMvChattingUIC", "NetSceneMusicMvHeartbeat, errCode:" + i3 + ", errType:" + i2 + ", errMsg:" + str);
                if (i2 == 0 && i3 == 0 && !this.AqQ) {
                    csf csf = ((j) qVar).AqN;
                    if (csf != null) {
                        a(csf);
                    }
                    csf csf2 = ((j) qVar).AqN;
                    this.AsR = csf2 != null ? csf2.AqP : null;
                    sr(false);
                    AppMethodBeat.o(257091);
                    return;
                }
            } else if (qVar instanceof k) {
                Log.i("MicroMsg.Mv.MusicMvChattingUIC", "NetSceneMusicMvJoin, errCode:" + i3 + ", errType:" + i2 + ", errMsg:" + str);
                if (i2 == 0 && i3 == 0) {
                    csh csh = ((k) qVar).AqT;
                    if (csh != null) {
                        this.AsR = csh.AqP;
                        this.AqO = csh.MwX;
                        sr(false);
                        Log.i("MicroMsg.Mv.MusicMvChattingUIC", "NetSceneMusicMvJoin songId:" + this.AqO);
                        AppMethodBeat.o(257091);
                        return;
                    }
                    AppMethodBeat.o(257091);
                    return;
                }
            } else if (!(qVar instanceof com.tencent.mm.plugin.mv.a.a.l) || !p.j(qVar, this.Ata)) {
                Log.e("MicroMsg.Mv.MusicMvChattingUIC", "invalid: Scene".concat(String.valueOf(qVar)));
            } else if (i2 == 0 && i3 == 0) {
                csn csn = ((com.tencent.mm.plugin.mv.a.a.l) qVar).AqW;
                if (csn != null) {
                    csk csk = csn.Mxx;
                    p.g(csk, "it.msg");
                    a(csk);
                    AppMethodBeat.o(257091);
                    return;
                }
                AppMethodBeat.o(257091);
                return;
            }
            AppMethodBeat.o(257091);
            return;
        }
        Log.i("MicroMsg.Mv.MusicMvChattingUIC", "not the same page of netscene");
        AppMethodBeat.o(257091);
    }

    private final void a(csk csk) {
        AppMethodBeat.i(257092);
        this.AsV.add(new MusicMvCommentView.b(new MusicMvCommentView.d(csk)));
        Collection<WeakReference<MusicMvCommentView>> values = this.Atd.values();
        p.g(values, "commentAreaRvMap.values");
        for (T t : values) {
            if (!this.AsV.isEmpty()) {
                MusicMvCommentView musicMvCommentView = (MusicMvCommentView) t.get();
                if (musicMvCommentView != null) {
                    musicMvCommentView.setVisibility(0);
                }
                MusicMvCommentView musicMvCommentView2 = (MusicMvCommentView) t.get();
                if (musicMvCommentView2 != null) {
                    musicMvCommentView2.aE(this.AsV);
                }
            }
        }
        AppMethodBeat.o(257092);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(com.tencent.mm.protocal.protobuf.csf r11) {
        /*
        // Method dump skipped, instructions count: 648
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.uic.MusicMvChattingUIC.a(com.tencent.mm.protocal.protobuf.csf):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvChattingUIC$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
    public static final class c extends IListener<mx> {
        final /* synthetic */ MusicMvChattingUIC Atf;
        final /* synthetic */ AppCompatActivity uQi;

        c(MusicMvChattingUIC musicMvChattingUIC, AppCompatActivity appCompatActivity) {
            this.Atf = musicMvChattingUIC;
            this.uQi = appCompatActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(259234);
            mx mxVar2 = mxVar;
            if (mxVar2 != null) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                if (((MusicMvDataUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(MusicMvDataUIC.class)).f(mxVar2.dSE.dSy)) {
                    switch (mxVar2.dSE.action) {
                        case 0:
                            Log.i("MicroMsg.Mv.MusicMvChattingUIC", "onMusic start and start to join music");
                            MusicMvChattingUIC.a(this.Atf);
                            break;
                        case 2:
                        case 4:
                            Log.i("MicroMsg.Mv.MusicMvChattingUIC", "onMusic stop and leave music chat");
                            MusicMvChattingUIC.b(this.Atf);
                            break;
                    }
                }
            }
            AppMethodBeat.o(259234);
            return false;
        }
    }
}
