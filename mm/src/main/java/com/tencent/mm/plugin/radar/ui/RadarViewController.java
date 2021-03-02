package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.ui.RadarMemberView;
import com.tencent.mm.plugin.radar.ui.RadarSpecialGridView;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b\u0001\u0001\u0001\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ0\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020IH\u0002J\u0006\u0010N\u001a\u00020OJ\u0018\u0010P\u001a\u00020\u00122\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010RH\u0002J4\u0010S\u001a\u00020O2\u0006\u0010T\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00122\b\u0010V\u001a\u0004\u0018\u00010I2\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020O2\b\u0010Z\u001a\u0004\u0018\u00010[J\u0006\u0010\\\u001a\u00020OJ\u0018\u0010]\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\n2\u0006\u0010_\u001a\u00020`H\u0016J\u001a\u0010a\u001a\u00020O2\u0006\u0010b\u001a\u00020\u00122\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\u0006\u0010e\u001a\u00020OJ0\u0010f\u001a\u00020O2\u0006\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020\n2\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010R2\u0006\u0010j\u001a\u00020\nH\u0016J0\u0010k\u001a\u00020O2\u0006\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020\n2\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010R2\u0006\u0010j\u001a\u00020\nH\u0016J\u0010\u0010n\u001a\u00020O2\u0006\u0010o\u001a\u00020pH\u0016J\u0010\u0010q\u001a\u00020O2\u0006\u0010o\u001a\u00020pH\u0016J\u0006\u0010r\u001a\u00020OJ,\u0010s\u001a\u00020O2\u0006\u0010T\u001a\u00020\u00122\b\u0010V\u001a\u0004\u0018\u00010I2\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010W\u001a\u00020XH\u0016J\b\u0010t\u001a\u00020OH\u0002J\u0018\u0010u\u001a\u00020O2\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010RH\u0002J\b\u0010v\u001a\u00020OH\u0002J\u0006\u0010w\u001a\u00020OJ\u0006\u0010x\u001a\u00020OJ\u0006\u0010y\u001a\u00020OJ\u0006\u0010z\u001a\u00020OJ\u001a\u0010{\u001a\u00020O2\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010|\u001a\u00020}H\u0002J\u0010\u0010~\u001a\u00020O2\u0006\u0010\u001a\u000208H\u0002J\t\u0010\u0001\u001a\u00020OH\u0002R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u0010\u0018\u001a\u0004\b2\u00103R\u000e\u00105\u001a\u000206X.¢\u0006\u0002\n\u0000R\u001e\u00109\u001a\u0002082\u0006\u00107\u001a\u000208@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001b\u0010<\u001a\u00020=8BX\u0002¢\u0006\f\n\u0004\b@\u0010\u0018\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0002¢\u0006\f\n\u0004\bE\u0010\u0018\u001a\u0004\bC\u0010D¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", ch.COL_USERNAME, "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"})
public final class RadarViewController extends RelativeLayout implements c.AbstractC1620c, e.d {
    public static final b BBq = new b((byte) 0);
    private static final String TAG = TAG;
    private final kotlin.f BAZ = kotlin.g.ah(new i(this));
    private final kotlin.f BBa = i.aq(this, R.id.gq3);
    private final kotlin.f BBb = i.aq(this, R.id.gqh);
    private final kotlin.f BBc = i.aq(this, R.id.gqj);
    private final kotlin.f BBd = i.aq(this, R.id.gq8);
    private final kotlin.f BBe = i.aq(this, R.id.gq9);
    private final kotlin.f BBf = i.aq(this, R.id.gqb);
    private final kotlin.f BBg = i.aq(this, R.id.gpx);
    com.tencent.mm.plugin.radar.b.e BBh;
    com.tencent.mm.plugin.radar.b.c BBi;
    c BBj;
    private e.EnumC1621e BBk = e.EnumC1621e.SEARCHING;
    private final boolean BBl;
    final View.OnClickListener BBm = new f(this);
    private final int BBn = TPMediaCodecProfileLevel.HEVCHighTierLevel62;
    private final int BBo = (this.BBn + 1);
    private final int BBp = (this.BBn + 2);
    private boolean uSu;

    private final TextView getNewRadarTip() {
        AppMethodBeat.i(138758);
        TextView textView = (TextView) this.BBd.getValue();
        AppMethodBeat.o(138758);
        return textView;
    }

    private final ProgressBar getNewRadarTipLoading() {
        AppMethodBeat.i(138759);
        ProgressBar progressBar = (ProgressBar) this.BBe.getValue();
        AppMethodBeat.o(138759);
        return progressBar;
    }

    private final View getRadarBgMask() {
        AppMethodBeat.i(138761);
        View view = (View) this.BBg.getValue();
        AppMethodBeat.o(138761);
        return view;
    }

    /* access modifiers changed from: package-private */
    public final RadarSpecialGridView getGrid() {
        AppMethodBeat.i(138756);
        RadarSpecialGridView radarSpecialGridView = (RadarSpecialGridView) this.BBb.getValue();
        AppMethodBeat.o(138756);
        return radarSpecialGridView;
    }

    /* access modifiers changed from: package-private */
    public final RadarMemberView getMemberDetailView() {
        AppMethodBeat.i(138755);
        RadarMemberView radarMemberView = (RadarMemberView) this.BBa.getValue();
        AppMethodBeat.o(138755);
        return radarMemberView;
    }

    /* access modifiers changed from: package-private */
    public final Button getQuitBtn() {
        AppMethodBeat.i(138760);
        Button button = (Button) this.BBf.getValue();
        AppMethodBeat.o(138760);
        return button;
    }

    /* access modifiers changed from: package-private */
    public final RadarTipsView getRadarTips() {
        AppMethodBeat.i(138757);
        RadarTipsView radarTipsView = (RadarTipsView) this.BBc.getValue();
        AppMethodBeat.o(138757);
        return radarTipsView;
    }

    /* access modifiers changed from: package-private */
    public final RadarWaveView getWaveView() {
        AppMethodBeat.i(138754);
        RadarWaveView radarWaveView = (RadarWaveView) this.BAZ.getValue();
        AppMethodBeat.o(138754);
        return radarWaveView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarViewController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "mContext");
        AppMethodBeat.i(138777);
        Context applicationContext = context.getApplicationContext();
        p.g(applicationContext, "mContext.getApplicationContext()");
        this.BBh = new com.tencent.mm.plugin.radar.b.e(this, applicationContext);
        this.BBi = new com.tencent.mm.plugin.radar.b.c(this, context);
        AppMethodBeat.o(138777);
    }

    public static final /* synthetic */ void a(RadarViewController radarViewController, e.EnumC1621e eVar) {
        AppMethodBeat.i(138784);
        radarViewController.a(eVar);
        AppMethodBeat.o(138784);
    }

    public static final /* synthetic */ void a(RadarViewController radarViewController, String str, c.e eVar) {
        AppMethodBeat.i(138780);
        radarViewController.d(str, eVar);
        AppMethodBeat.o(138780);
    }

    public static final /* synthetic */ boolean a(RadarViewController radarViewController, LinkedList linkedList) {
        AppMethodBeat.i(138783);
        boolean bj = radarViewController.bj(linkedList);
        AppMethodBeat.o(138783);
        return bj;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.radar.b.e c(RadarViewController radarViewController) {
        AppMethodBeat.i(138778);
        com.tencent.mm.plugin.radar.b.e eVar = radarViewController.BBh;
        if (eVar == null) {
            p.btv("radarManager");
        }
        AppMethodBeat.o(138778);
        return eVar;
    }

    public static final /* synthetic */ c d(RadarViewController radarViewController) {
        AppMethodBeat.i(138779);
        c cVar = radarViewController.BBj;
        if (cVar == null) {
            p.btv("adapter");
        }
        AppMethodBeat.o(138779);
        return cVar;
    }

    public static final /* synthetic */ void eHB() {
    }

    public static final /* synthetic */ RadarWaveView f(RadarViewController radarViewController) {
        AppMethodBeat.i(138781);
        RadarWaveView waveView = radarViewController.getWaveView();
        AppMethodBeat.o(138781);
        return waveView;
    }

    public static final /* synthetic */ RadarMemberView g(RadarViewController radarViewController) {
        AppMethodBeat.i(138782);
        RadarMemberView memberDetailView = radarViewController.getMemberDetailView();
        AppMethodBeat.o(138782);
        return memberDetailView;
    }

    public final e.EnumC1621e getRadarStatus() {
        return this.BBk;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ RadarViewController BBu;

        f(RadarViewController radarViewController) {
            this.BBu = radarViewController;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138748);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/RadarViewController$mOnQuitActionButtonListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.BBu.getRadarStatus() == e.EnumC1621e.SEARCHING || this.BBu.getRadarStatus() == e.EnumC1621e.SEARCH_RETRUN) {
                Context context = this.BBu.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(138748);
                    throw tVar;
                }
                ((Activity) context).finish();
            } else {
                RadarViewController radarViewController = this.BBu;
                c d2 = RadarViewController.d(this.BBu);
                LinkedList linkedList = new LinkedList();
                int length = d2.BBw.length;
                for (int i2 = 0; i2 < length; i2++) {
                    djb djb = d2.BBw[i2];
                    if (djb != null) {
                        linkedList.add(djb);
                    }
                }
                if (RadarViewController.a(radarViewController, linkedList)) {
                    RadarViewController.f(this.BBu).eHD();
                    RadarViewController.f(this.BBu).setVisibility(0);
                    RadarViewController.c(this.BBu).eHj();
                    RadarViewController.a(this.BBu, e.EnumC1621e.SEARCH_RETRUN);
                } else {
                    RadarViewController.a(this.BBu, e.EnumC1621e.SEARCHING);
                }
                RadarViewController.d(this.BBu).cax();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarViewController$mOnQuitActionButtonListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(138748);
        }
    }

    public final void onResume() {
        AppMethodBeat.i(138762);
        com.tencent.mm.plugin.radar.b.e eVar = this.BBh;
        if (eVar == null) {
            p.btv("radarManager");
        }
        eVar.onResume();
        AppMethodBeat.o(138762);
    }

    public final void eHj() {
        AppMethodBeat.i(138763);
        com.tencent.mm.plugin.radar.b.e eVar = this.BBh;
        if (eVar == null) {
            p.btv("radarManager");
        }
        eVar.eHj();
        AppMethodBeat.o(138763);
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(138764);
        p.h(keyEvent, "event");
        if (i2 == 4 && getMemberDetailView().isShowing()) {
            getMemberDetailView().dismiss();
            AppMethodBeat.o(138764);
            return true;
        }
        AppMethodBeat.o(138764);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
    public static final class e implements RadarMemberView.b {
        final /* synthetic */ RadarViewController BBu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(RadarViewController radarViewController) {
            this.BBu = radarViewController;
        }

        @Override // com.tencent.mm.plugin.radar.ui.RadarMemberView.b
        public final void a(djb djb, c.e eVar) {
            boolean z;
            String str;
            boolean z2;
            long j2;
            AppMethodBeat.i(138746);
            p.h(djb, "member");
            g gVar = g.BAY;
            String b2 = g.b(djb);
            if (eVar == null) {
                AppMethodBeat.o(138746);
                return;
            }
            switch (h.$EnumSwitchMapping$0[eVar.ordinal()]) {
                case 1:
                    RadarViewController.c(this.BBu).ByP.put(Long.valueOf(this.BBu.BBi.aKM(b2)), new e.c(djb, eVar));
                    RadarViewController.a(this.BBu, b2, c.e.Verifying);
                    AppMethodBeat.o(138746);
                    return;
                case 2:
                    com.tencent.mm.plugin.radar.b.c cVar = this.BBu.BBi;
                    p.h(b2, ch.COL_USERNAME);
                    com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af, "service(IMessengerStorage::class.java)");
                    as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(b2);
                    p.g(Kn, "contact");
                    String username = Kn.getUsername();
                    if (username == null || n.aL(username)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        str = b2;
                    } else {
                        String username2 = Kn.getUsername();
                        p.g(username2, "contact.username");
                        str = username2;
                    }
                    String str2 = cVar.Byg.get(str);
                    String str3 = str2;
                    if (str3 == null || n.aL(str3)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        Log.e(com.tencent.mm.plugin.radar.b.c.TAG, "Verify Contact username(%s) error, verifyTicket is null", str);
                        cVar.aKM(str);
                        j2 = -1;
                    } else {
                        ca.d bkD = ca.d.bkD(str2);
                        long currentTimeMillis = System.currentTimeMillis();
                        c.a aVar = new c.a(new c.m(cVar, str2, currentTimeMillis));
                        String gEc = bkD.gEc();
                        p.g(gEc, "verify.verifyTicket");
                        p.h(gEc, "verifyTicket");
                        Assert.assertTrue("username is null", str != null && str.length() > 0);
                        aVar.onStart();
                        com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.pluginsdk.model.p(str, gEc, 48));
                        j2 = currentTimeMillis;
                    }
                    RadarViewController.c(this.BBu).ByP.put(Long.valueOf(j2), new e.c(djb, eVar));
                    RadarViewController.a(this.BBu, b2, c.e.Verifying);
                    break;
            }
            AppMethodBeat.o(138746);
        }

        @Override // com.tencent.mm.plugin.radar.ui.RadarMemberView.b
        public final void b(djb djb, c.e eVar) {
            String str;
            AppMethodBeat.i(138747);
            if (djb != null) {
                g gVar = g.BAY;
                str = g.b(djb);
            } else {
                str = null;
            }
            View view = RadarViewController.d(this.BBu).BBB.get(str);
            if (view != null) {
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                    AppMethodBeat.o(138747);
                    throw tVar;
                }
                c.a aVar = (c.a) tag;
                if (eVar != c.e.Stranger) {
                    aVar.BBF.eHu();
                }
            }
            RadarViewController.f(this.BBu).eHD();
            AppMethodBeat.o(138747);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
    public static final class h implements RadarSpecialGridView.a {
        final /* synthetic */ RadarViewController BBu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(RadarViewController radarViewController) {
            this.BBu = radarViewController;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
            if (r1 != false) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fe, code lost:
            if (r1 != false) goto L_0x0100;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0195, code lost:
            if (r1 != false) goto L_0x0197;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0103  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x014c  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0171  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x019a  */
        @Override // com.tencent.mm.plugin.radar.ui.RadarSpecialGridView.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(int r8, android.view.View r9) {
            /*
            // Method dump skipped, instructions count: 486
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController.h.b(int, android.view.View):void");
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ h BBJ;
            final /* synthetic */ c.e BBK;
            final /* synthetic */ djb BzP;
            final /* synthetic */ View hCI;

            a(h hVar, View view, djb djb, c.e eVar) {
                this.BBJ = hVar;
                this.hCI = view;
                this.BzP = djb;
                this.BBK = eVar;
            }

            public final void run() {
                AppMethodBeat.i(138750);
                RadarViewController.g(this.BBJ.BBu).a(this.hCI, this.BzP, this.BBK);
                RadarViewController.f(this.BBJ.BBu).eHE();
                AppMethodBeat.o(138750);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$TagItem;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "plugin-radar_release"})
    public final class d {
        final /* synthetic */ RadarViewController BBu;
        private djb Bzb;

        public d(RadarViewController radarViewController, djb djb) {
            p.h(djb, "member");
            this.BBu = radarViewController;
            AppMethodBeat.i(138744);
            this.Bzb = djb;
            AppMethodBeat.o(138744);
        }
    }

    private final void d(String str, c.e eVar) {
        AppMethodBeat.i(138765);
        com.tencent.mm.plugin.radar.b.e eVar2 = this.BBh;
        if (eVar2 == null) {
            p.btv("radarManager");
        }
        if (str == null) {
            p.hyc();
        }
        c.e aKO = eVar2.aKO(str);
        if (!(aKO == null || aKO == eVar)) {
            com.tencent.mm.plugin.radar.b.e eVar3 = this.BBh;
            if (eVar3 == null) {
                p.btv("radarManager");
            }
            eVar3.b(str, eVar);
            c cVar = this.BBj;
            if (cVar == null) {
                p.btv("adapter");
            }
            cVar.cax();
        }
        AppMethodBeat.o(138765);
    }

    @Override // com.tencent.mm.plugin.radar.b.c.AbstractC1620c
    public final void a(boolean z, boolean z2, String str, String str2, long j2) {
        AppMethodBeat.i(138766);
        if (z) {
            d(str2, c.e.Added);
        } else if (z2) {
            d(str2, c.e.Verifying);
        } else {
            RadarTipsView radarTips = getRadarTips();
            if (str == null) {
                str = "";
            }
            radarTips.aKP(str);
            com.tencent.mm.plugin.radar.b.e eVar = this.BBh;
            if (eVar == null) {
                p.btv("radarManager");
            }
            e.c cVar = eVar.ByP.get(Long.valueOf(j2));
            if (cVar != null) {
                g gVar = g.BAY;
                d(g.b(cVar.Bzb), cVar.Bzc);
                g gVar2 = g.BAY;
                d(g.c(cVar.Bzb), cVar.Bzc);
            }
        }
        com.tencent.mm.plugin.radar.b.e eVar2 = this.BBh;
        if (eVar2 == null) {
            p.btv("radarManager");
        }
        eVar2.ByP.remove(Long.valueOf(j2));
        AppMethodBeat.o(138766);
    }

    @Override // com.tencent.mm.plugin.radar.b.c.AbstractC1620c
    public final void a(boolean z, String str, String str2, long j2) {
        AppMethodBeat.i(138767);
        if (z) {
            d(str2, c.e.Added);
        } else {
            RadarTipsView radarTips = getRadarTips();
            if (str == null) {
                str = "";
            }
            radarTips.aKP(str);
            com.tencent.mm.plugin.radar.b.e eVar = this.BBh;
            if (eVar == null) {
                p.btv("radarManager");
            }
            e.c cVar = eVar.ByP.get(Long.valueOf(j2));
            if (cVar != null) {
                g gVar = g.BAY;
                d(g.b(cVar.Bzb), cVar.Bzc);
            }
        }
        com.tencent.mm.plugin.radar.b.e eVar2 = this.BBh;
        if (eVar2 == null) {
            p.btv("radarManager");
        }
        eVar2.ByP.remove(Long.valueOf(j2));
        AppMethodBeat.o(138767);
    }

    @Override // com.tencent.mm.plugin.radar.b.c.AbstractC1620c
    public final void ah(as asVar) {
        AppMethodBeat.i(138768);
        p.h(asVar, "contact");
        com.tencent.mm.plugin.radar.b.e eVar = this.BBh;
        if (eVar == null) {
            p.btv("radarManager");
        }
        String username = asVar.getUsername();
        p.g(username, "contact.username");
        if (eVar.aKO(username) == null) {
            com.tencent.mm.plugin.radar.b.e eVar2 = this.BBh;
            if (eVar2 == null) {
                p.btv("radarManager");
            }
            String ajB = asVar.ajB();
            p.g(ajB, "contact.encryptUsername");
            if (eVar2.aKO(ajB) == null) {
                LinkedList<djb> linkedList = new LinkedList<>();
                String username2 = asVar.getUsername();
                p.g(username2, "contact.username");
                String ajB2 = asVar.ajB();
                p.g(ajB2, "contact.encryptUsername");
                String nickname = asVar.getNickname();
                p.g(nickname, "contact.nickname");
                djb djb = new djb();
                djb.MNf = 100;
                djb.UserName = username2;
                djb.oUJ = nickname;
                djb.SmallImgUrl = "";
                djb.LuX = ajB2;
                linkedList.add(djb);
                bi(linkedList);
            }
        }
        if (getMemberDetailView().isShowing()) {
            RadarMemberView memberDetailView = getMemberDetailView();
            String ajB3 = asVar.ajB();
            p.g(ajB3, "contact.encryptUsername");
            memberDetailView.c(ajB3, c.e.NeedVerify);
        }
        d(asVar.getUsername(), c.e.NeedVerify);
        d(asVar.ajB(), c.e.NeedVerify);
        AppMethodBeat.o(138768);
    }

    @Override // com.tencent.mm.plugin.radar.b.c.AbstractC1620c
    public final void ag(as asVar) {
        AppMethodBeat.i(138769);
        p.h(asVar, "contact");
        if (getMemberDetailView().isShowing()) {
            RadarMemberView memberDetailView = getMemberDetailView();
            String ajB = asVar.ajB();
            p.g(ajB, "contact.encryptUsername");
            memberDetailView.c(ajB, c.e.Added);
        }
        d(asVar.getUsername(), c.e.Added);
        d(asVar.ajB(), c.e.Added);
        AppMethodBeat.o(138769);
    }

    @Override // com.tencent.mm.plugin.radar.b.e.d
    public final void sV(boolean z) {
        AppMethodBeat.i(138770);
        if (!z) {
            RadarTipsView radarTips = getRadarTips();
            String string = getContext().getString(R.string.ftb);
            p.g(string, "context.getString(R.stri….radar_tips_location_err)");
            radarTips.aKP(string);
            if (!this.uSu && !com.tencent.mm.modelgeo.d.bcc()) {
                this.uSu = true;
                com.tencent.mm.ui.base.h.a(getContext(), getContext().getString(R.string.dvi), getContext().getString(R.string.zb), getContext().getString(R.string.e_k), getContext().getString(R.string.sz), false, (DialogInterface.OnClickListener) new g(this), (DialogInterface.OnClickListener) null);
            }
        }
        AppMethodBeat.o(138770);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    static final class g implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarViewController BBu;

        g(RadarViewController radarViewController) {
            this.BBu = radarViewController;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(138749);
            com.tencent.mm.modelgeo.d.cZ(this.BBu.getContext());
            AppMethodBeat.o(138749);
        }
    }

    @Override // com.tencent.mm.plugin.radar.b.e.d
    public final void a(int i2, int i3, LinkedList<djb> linkedList) {
        AppMethodBeat.i(138771);
        if (i2 == 0 && i3 == 0) {
            bi(linkedList);
            AppMethodBeat.o(138771);
            return;
        }
        Log.e(TAG, "radar member return error : %s, type : %s ", Integer.valueOf(i3), Integer.valueOf(i2));
        if (2 == i2) {
            RadarTipsView radarTips = getRadarTips();
            String string = getContext().getString(R.string.fbd);
            p.g(string, "context.getString(R.string.net_warn_no_network)");
            radarTips.aKP(string);
            AppMethodBeat.o(138771);
            return;
        }
        RadarTipsView radarTips2 = getRadarTips();
        String string2 = getContext().getString(R.string.ftc);
        p.g(string2, "context.getString(R.string.radar_tips_network_err)");
        radarTips2.aKP(string2);
        AppMethodBeat.o(138771);
    }

    @Override // com.tencent.mm.plugin.radar.b.e.d
    public final void b(int i2, int i3, LinkedList<diy> linkedList) {
        AppMethodBeat.i(138772);
        if (i2 == 0 && i3 == 0 && linkedList != null) {
            a(e.EnumC1621e.RALATIONCHAIN_RETRUN);
            c cVar = this.BBj;
            if (cVar == null) {
                p.btv("adapter");
            }
            c(cVar.BBu).ByQ.clear();
            c(cVar.BBu).ByM.clear();
            cVar.BBx.clear();
            cVar.BBy.clear();
            LinkedList<diz> linkedList2 = null;
            if (linkedList != null && linkedList.size() > 0) {
                LinkedList<diz> linkedList3 = new LinkedList<>();
                int size = linkedList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    diy diy = linkedList.get(i4);
                    p.g(diy, "radarChatMember[i]");
                    diy diy2 = diy;
                    diz diz = new diz();
                    diz.MNe = diy2.UserName;
                    linkedList3.add(diz);
                    Map<String, String> map = c(cVar.BBu).ByM;
                    String str = diy2.LuX;
                    p.g(str, "radarchatroomMember.EncodeUserName");
                    String str2 = diy2.UserName;
                    p.g(str2, "radarchatroomMember.UserName");
                    map.put(str, str2);
                    HashMap<String, Integer> hashMap = cVar.BBy;
                    g gVar = g.BAY;
                    hashMap.put(g.a(diy2), 0);
                }
                int length = cVar.BBw.length;
                for (int i5 = 0; i5 < length; i5++) {
                    djb djb = cVar.BBw[i5];
                    Map<String, String> map2 = c(cVar.BBu).ByM;
                    g gVar2 = g.BAY;
                    if (!Util.isNullOrNil(map2.get(g.c(djb)))) {
                        d(cVar.BBu).d(djb);
                        c(cVar.BBu).a(djb);
                    }
                }
                linkedList2 = linkedList3;
            }
            c(cVar.BBu).ByL = linkedList2;
            c cVar2 = this.BBj;
            if (cVar2 == null) {
                p.btv("adapter");
            }
            cVar2.cax();
            AppMethodBeat.o(138772);
            return;
        }
        a(e.EnumC1621e.SEARCHING);
        RadarTipsView radarTips = getRadarTips();
        String string = getContext().getString(R.string.ftc);
        p.g(string, "context.getString(R.string.radar_tips_network_err)");
        radarTips.aKP(string);
        AppMethodBeat.o(138772);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bi(java.util.LinkedList<com.tencent.mm.protocal.protobuf.djb> r9) {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController.bi(java.util.LinkedList):void");
    }

    private final boolean bj(LinkedList<djb> linkedList) {
        c.e eVar;
        boolean z;
        AppMethodBeat.i(138774);
        boolean z2 = false;
        if (linkedList == null) {
            p.hyc();
        }
        Iterator<djb> it = linkedList.iterator();
        while (it.hasNext()) {
            djb next = it.next();
            com.tencent.mm.plugin.radar.b.e eVar2 = this.BBh;
            if (eVar2 == null) {
                p.btv("radarManager");
            }
            p.g(next, "member");
            c.e a2 = com.tencent.mm.plugin.radar.b.e.a(eVar2, next);
            if (a2 == null) {
                g gVar = g.BAY;
                String b2 = g.b(next);
                eVar = this.BBi.aKN(b2);
                com.tencent.mm.plugin.radar.b.e eVar3 = this.BBh;
                if (eVar3 == null) {
                    p.btv("radarManager");
                }
                eVar3.b(b2, eVar);
            } else {
                eVar = a2;
            }
            if (eVar == c.e.Added) {
                z = true;
            } else {
                z = z2;
            }
            z2 = z;
        }
        AppMethodBeat.o(138774);
        return z2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", FirebaseAnalytics.b.INDEX, "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "show", "plugin-radar_release"})
    public final class a {
        private int BBr;
        final boolean BBs;
        private final C1623a BBt = new C1623a(this);

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            AppMethodBeat.i(138736);
            g gVar = g.BAY;
            Context context = RadarViewController.this.getContext();
            p.g(context, "context");
            this.BBs = g.gM(context);
            AppMethodBeat.o(138736);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
        /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$a$a  reason: collision with other inner class name */
        public static final class C1623a extends MMHandler {
            final /* synthetic */ a BBv;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1623a(a aVar) {
                this.BBv = aVar;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(138731);
                p.h(message, "msg");
                if (message.obj instanceof View) {
                    Object obj = message.obj;
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(138731);
                        throw tVar;
                    }
                    View view = (View) obj;
                    view.setVisibility(0);
                    view.clearAnimation();
                    if (!this.BBv.BBs) {
                        Object tag = view.getTag(RadarViewController.this.BBp);
                        if (!(tag instanceof Animation)) {
                            tag = null;
                        }
                        Animation animation = (Animation) tag;
                        if (animation == null) {
                            animation = this.BBv.getInAnimation();
                        }
                        view.startAnimation(animation);
                    }
                }
                AppMethodBeat.o(138731);
            }
        }

        public final Animation getInAnimation() {
            AppMethodBeat.i(138732);
            Animation loadAnimation = AnimationUtils.loadAnimation(RadarViewController.this.getContext(), R.anim.dz);
            p.g(loadAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
            AppMethodBeat.o(138732);
            return loadAnimation;
        }

        public final int eHC() {
            this.BBr++;
            return this.BBr;
        }

        public final void j(int i2, View view) {
            AppMethodBeat.i(138733);
            p.h(view, "view");
            Message obtainMessage = this.BBt.obtainMessage();
            obtainMessage.what = eI(view);
            obtainMessage.obj = view;
            view.setVisibility(4);
            this.BBt.sendMessageDelayed(obtainMessage, (long) ((i2 + 1) * 500));
            AppMethodBeat.o(138733);
        }

        public final void cl(View view) {
            AppMethodBeat.i(138734);
            p.h(view, "view");
            int eI = eI(view);
            if (eI > 0) {
                this.BBt.removeMessages(eI);
            }
            view.clearAnimation();
            AppMethodBeat.o(138734);
        }

        private final int eI(View view) {
            AppMethodBeat.i(138735);
            Object tag = view.getTag(RadarViewController.this.BBo);
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            if (num != null) {
                int intValue = num.intValue();
                AppMethodBeat.o(138735);
                return intValue;
            }
            AppMethodBeat.o(138735);
            return -1;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001DB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001dJ\u0006\u00101\u001a\u00020/J\u0006\u00102\u001a\u00020/J\b\u00103\u001a\u00020/H\u0002J\u0010\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\bH\u0016J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00105\u001a\u00020\bH\u0016J\u001a\u00108\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010+2\u0006\u00105\u001a\u00020\bH\u0016J\u0010\u0010:\u001a\u00020\u00102\b\u0010;\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010<\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010+2\u0006\u00105\u001a\u00020\bH\u0002J\"\u0010=\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010+2\u0006\u00105\u001a\u00020\b2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010A\u001a\u00020/2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010$R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R4\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010$2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010$8F@FX\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020+0\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"})
    public final class c extends a {
        private int BBA;
        HashMap<String, View> BBB = new HashMap<>();
        private boolean BBC;
        final /* synthetic */ RadarViewController BBu;
        djb[] BBw = new djb[12];
        HashMap<String, String> BBx = new HashMap<>();
        HashMap<String, Integer> BBy = new HashMap<>();
        private final a BBz;
        private final Context context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(RadarViewController radarViewController, RadarSpecialGridView radarSpecialGridView, Context context2) {
            super(radarSpecialGridView, context2);
            p.h(radarSpecialGridView, "radarGridView");
            p.h(context2, "context");
            this.BBu = radarViewController;
            AppMethodBeat.i(138743);
            this.context = context2;
            this.BBz = new a();
            AppMethodBeat.o(138743);
        }

        @Override // com.tencent.mm.plugin.radar.ui.a
        public final int getCount() {
            if (this.BBC) {
                return 0;
            }
            return this.BBw.length;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x009e, code lost:
            if (r0 != false) goto L_0x00a0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00a3 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0078 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bk(java.util.LinkedList<com.tencent.mm.protocal.protobuf.djb> r12) {
            /*
            // Method dump skipped, instructions count: 295
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController.c.bk(java.util.LinkedList):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0372, code lost:
            if (r1 == null) goto L_0x0374;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
        @Override // com.tencent.mm.plugin.radar.ui.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.View ao(android.view.View r11, int r12) {
            /*
            // Method dump skipped, instructions count: 1020
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController.c.ao(android.view.View, int):android.view.View");
        }

        public final void clearAll() {
            AppMethodBeat.i(138740);
            this.BBy.clear();
            this.BBB.clear();
            for (String str : this.BBB.keySet()) {
                View view = this.BBB.get(str);
                if (view != null) {
                    a aVar = this.BBz;
                    p.g(view, LocaleUtil.ITALIAN);
                    aVar.cl(view);
                }
            }
            cax();
            AppMethodBeat.o(138740);
        }

        private final View ap(View view, int i2) {
            AppMethodBeat.i(138741);
            if (view == null) {
                view = View.inflate(this.context, R.layout.bkd, null);
                if (view == null) {
                    p.hyc();
                }
                view.setTag(this.BBu.BBo, Integer.valueOf(this.BBz.eHC()));
                view.setTag(this.BBu.BBp, this.BBz.getInAnimation());
            }
            View findViewById = view.findViewById(R.id.gqc);
            p.g(findViewById, "anotherConvertView.findV…ar_result_item_avatar_iv)");
            findViewById.setVisibility(8);
            View findViewById2 = view.findViewById(R.id.gqd);
            p.g(findViewById2, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
            findViewById2.setVisibility(8);
            View findViewById3 = view.findViewById(R.id.gqe);
            p.g(findViewById3, "anotherConvertView.findV…_result_item_username_tv)");
            findViewById3.setVisibility(4);
            View findViewById4 = view.findViewById(R.id.gq7);
            p.g(findViewById4, "anotherConvertView.findV….radar_member_state_view)");
            findViewById4.setVisibility(4);
            View findViewById5 = view.findViewById(R.id.gq6);
            p.g(findViewById5, "anotherConvertView.findV…member_state_choose_view)");
            findViewById5.setVisibility(4);
            if (i2 == 7 || i2 % 3 == 1) {
                View findViewById6 = view.findViewById(R.id.aba);
                p.g(findViewById6, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                findViewById6.setVisibility(0);
                View findViewById7 = view.findViewById(R.id.itd);
                p.g(findViewById7, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                findViewById7.setVisibility(8);
            } else {
                View findViewById8 = view.findViewById(R.id.itd);
                p.g(findViewById8, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                findViewById8.setVisibility(0);
                View findViewById9 = view.findViewById(R.id.aba);
                p.g(findViewById9, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                findViewById9.setVisibility(8);
            }
            AppMethodBeat.o(138741);
            return view;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter$ViewHolder;", "", "tvMemberName", "Landroid/widget/TextView;", "ivMemberAvatar", "Landroid/widget/ImageView;", "vMemberState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "vMemberChooseState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "ivMemberAvatarMask", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/radar/ui/RadarStateView;Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;Landroid/widget/ImageView;)V", "getIvMemberAvatar$plugin_radar_release", "()Landroid/widget/ImageView;", "setIvMemberAvatar$plugin_radar_release", "(Landroid/widget/ImageView;)V", "getIvMemberAvatarMask$plugin_radar_release", "setIvMemberAvatarMask$plugin_radar_release", "getTvMemberName$plugin_radar_release", "()Landroid/widget/TextView;", "setTvMemberName$plugin_radar_release", "(Landroid/widget/TextView;)V", "getVMemberChooseState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "setVMemberChooseState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;)V", "getVMemberState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "setVMemberState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateView;)V", "plugin-radar_release"})
        public final class a {
            TextView BBD;
            ImageView BBE;
            RadarStateView BBF;
            RadarStateChooseView BBG;
            ImageView BBH;
            final /* synthetic */ c BBI;

            public a(c cVar, TextView textView, ImageView imageView, RadarStateView radarStateView, RadarStateChooseView radarStateChooseView, ImageView imageView2) {
                p.h(textView, "tvMemberName");
                p.h(imageView, "ivMemberAvatar");
                p.h(radarStateView, "vMemberState");
                p.h(radarStateChooseView, "vMemberChooseState");
                p.h(imageView2, "ivMemberAvatarMask");
                this.BBI = cVar;
                AppMethodBeat.i(138737);
                this.BBD = textView;
                this.BBE = imageView;
                this.BBF = radarStateView;
                this.BBG = radarStateChooseView;
                this.BBH = imageView2;
                AppMethodBeat.o(138737);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            if (r0 != false) goto L_0x0028;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d(com.tencent.mm.protocal.protobuf.djb r5) {
            /*
            // Method dump skipped, instructions count: 115
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController.c.d(com.tencent.mm.protocal.protobuf.djb):void");
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final void a(e.EnumC1621e eVar) {
        AppMethodBeat.i(138775);
        this.BBk = eVar;
        switch (h.uqL[eVar.ordinal()]) {
            case 1:
                getRadarBgMask().setVisibility(8);
                getQuitBtn().setText(R.string.ft7);
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText("");
                getWaveView().eHD();
                getWaveView().setVisibility(0);
                com.tencent.mm.plugin.radar.b.e eVar2 = this.BBh;
                if (eVar2 == null) {
                    p.btv("radarManager");
                }
                eVar2.eHj();
                AppMethodBeat.o(138775);
                return;
            case 2:
                getRadarBgMask().setVisibility(8);
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText("");
                AppMethodBeat.o(138775);
                return;
            case 3:
                eHA();
                getQuitBtn().setText(R.string.sz);
                com.tencent.mm.plugin.radar.b.e eVar3 = this.BBh;
                if (eVar3 == null) {
                    p.btv("radarManager");
                }
                eVar3.eHk();
                getNewRadarTipLoading().setVisibility(0);
                getNewRadarTip().setText(R.string.ft9);
                getWaveView().eHE();
                getWaveView().setVisibility(4);
                getGrid().setVisibility(4);
                c cVar = this.BBj;
                if (cVar == null) {
                    p.btv("adapter");
                }
                cVar.clearAll();
                AppMethodBeat.o(138775);
                return;
            case 4:
                getRadarBgMask().setVisibility(0);
                com.tencent.mm.plugin.radar.b.e eVar4 = this.BBh;
                if (eVar4 == null) {
                    p.btv("radarManager");
                }
                eVar4.eHk();
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText(R.string.fsy);
                getGrid().setVisibility(0);
                AppMethodBeat.o(138775);
                return;
            case 5:
                getRadarBgMask().setVisibility(8);
                com.tencent.mm.plugin.radar.b.e eVar5 = this.BBh;
                if (eVar5 == null) {
                    p.btv("radarManager");
                }
                eVar5.eHk();
                getNewRadarTipLoading().setVisibility(0);
                getNewRadarTip().setText(R.string.fsz);
                break;
        }
        AppMethodBeat.o(138775);
    }

    private final void eHA() {
        AppMethodBeat.i(138776);
        if (getRadarBgMask().getVisibility() != 0) {
            getRadarBgMask().setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ds));
            getRadarBgMask().setVisibility(0);
        }
        AppMethodBeat.o(138776);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138753);
        AppMethodBeat.o(138753);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends q implements kotlin.g.a.a<RadarWaveView> {
        final /* synthetic */ RadarViewController BBu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(RadarViewController radarViewController) {
            super(0);
            this.BBu = radarViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RadarWaveView invoke() {
            AppMethodBeat.i(138752);
            Context context = this.BBu.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(138752);
                throw tVar;
            }
            RadarWaveView radarWaveView = (RadarWaveView) ((Activity) context).findViewById(R.id.gqm);
            AppMethodBeat.o(138752);
            return radarWaveView;
        }
    }
}
