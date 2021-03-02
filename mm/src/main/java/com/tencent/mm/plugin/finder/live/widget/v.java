package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010Z\u001a\u00020-J\u0006\u0010[\u001a\u00020-J\u0010\u0010\\\u001a\u00020-2\u0006\u0010]\u001a\u00020QH\u0002J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0019H\u0002J\u0010\u0010`\u001a\u00020-2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0006\u0010b\u001a\u00020-J\u0006\u0010c\u001a\u00020\u0017J\u0012\u0010d\u001a\u00020-2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0016J,\u0010f\u001a\u00020-2\u0006\u0010g\u001a\u00020Q2\u0006\u0010h\u001a\u00020Q2\b\u0010i\u001a\u0004\u0018\u00010\u00072\b\u0010j\u001a\u0004\u0018\u00010kH\u0016J\u0010\u0010l\u001a\u00020-2\u0006\u0010_\u001a\u00020\u0019H\u0002J\u0010\u0010m\u001a\u00020-2\u0006\u0010_\u001a\u00020\u0019H\u0002J\u0010\u0010n\u001a\u00020-2\u0006\u0010_\u001a\u00020\u0019H\u0002J\u0010\u0010o\u001a\u00020-2\u0006\u0010_\u001a\u00020\u0019H\u0002J\b\u0010p\u001a\u00020-H\u0002J\u0018\u0010q\u001a\u00020-2\u0006\u0010_\u001a\u00020\u00192\u0006\u0010r\u001a\u00020sH\u0002J\u0010\u0010t\u001a\u00020-2\u0006\u0010_\u001a\u00020\u0019H\u0002J\u0010\u0010u\u001a\u00020-2\u0006\u0010_\u001a\u00020\u0019H\u0002J\u0016\u0010v\u001a\u00020-2\u0006\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020QJ\"\u0010y\u001a\u00020-2\u0006\u0010z\u001a\u00020\u00192\u0006\u0010P\u001a\u00020Q2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FJ\b\u0010{\u001a\u00020-H\u0002J\u0018\u0010|\u001a\u00020-2\u0006\u0010_\u001a\u00020\u00192\u0006\u0010P\u001a\u00020QH\u0002R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \f*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \f*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\n \f*\u0004\u0018\u00010\u001f0\u001fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \f*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \f*\u0004\u0018\u00010\u001f0\u001fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n \f*\u0004\u0018\u00010&0&X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R9\u0010(\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\n\u0012\u0004\u0012\u00020-\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n \f*\u0004\u0018\u00010?0?X\u0004¢\u0006\u0002\n\u0000R\"\u0010@\u001a\n\u0012\u0004\u0012\u00020-\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00105\"\u0004\bB\u00107R\u0016\u0010C\u001a\n \f*\u0004\u0018\u00010D0DX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\"\u0010M\u001a\n\u0012\u0004\u0012\u00020-\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00105\"\u0004\bO\u00107R\u001a\u0010P\u001a\u00020QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010V\u001a\n \f*\u0004\u0018\u00010&0&X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010W\u001a\n \f*\u0004\u0018\u00010&0&X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010X\u001a\n \f*\u0004\u0018\u00010&0&X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Y\u001a\n \f*\u0004\u0018\u00010\u001f0\u001fX\u0004¢\u0006\u0002\n\u0000¨\u0006}"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "anchorActionGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "authInfoIv", "Landroid/widget/ImageView;", "avatarIcon", "banCommentIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "blankArea", "closeBtn", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "contentIsShow", "", "curLiveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getCurLiveContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "setCurLiveContact", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;)V", "finderPrivacyMsgBtn", "Landroid/widget/Button;", "finderUserArrowIv", "followBtn", "followListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FollowUserEvent;", "followsDescTv", "Landroid/widget/TextView;", "followsGroup", "gotoProfileCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ch.COL_USERNAME, "", "getGotoProfileCallback", "()Lkotlin/jvm/functions/Function1;", "setGotoProfileCallback", "(Lkotlin/jvm/functions/Function1;)V", "hideContentCallback", "Lkotlin/Function0;", "getHideContentCallback", "()Lkotlin/jvm/functions/Function0;", "setHideContentCallback", "(Lkotlin/jvm/functions/Function0;)V", "isPrivacyUser", "()Z", "setPrivacyUser", "(Z)V", "loadingBar", "Landroid/widget/ProgressBar;", "moreAction", "Landroid/widget/FrameLayout;", "moreActionCallback", "getMoreActionCallback", "setMoreActionCallback", "profileInfoGroup", "Landroid/widget/RelativeLayout;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setReportObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getRoot", "()Landroid/view/ViewGroup;", "showContentCallback", "getShowContentCallback", "setShowContentCallback", "sourceType", "", "getSourceType", "()I", "setSourceType", "(I)V", "titleTv", "userInfoTv", "userSigatureTv", "wechatPrivacyMsgBtn", "activate", "deActivate", "followFinderUser", "followType", "getFinderLiveContactInfo", "contact", "handleFollowBtn", "finderUsername", "hideProfile", "isLandscape", "onClick", "v", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setAnchorActionState", "setAuthInfo", "setFinderUserArrow", "setFollows", "setMoreActionState", "setTitleContent", "titleSpan", "Landroid/text/SpannableString;", "setUserInfo", "setUserSignature", "showCenterCustomizeToast", "msg", ShareConstants.RES_PATH, "showProfile", "liveContact", "updateProfile", "updateProfileInfo", "plugin-finder_release"})
public final class v implements View.OnClickListener, i {
    public final String TAG = "FinderLiveMemebrProfileWidget";
    private final View URA = this.hwr.findViewById(R.id.jzj);
    private final TextView URB = ((TextView) this.hwr.findViewById(R.id.jzi));
    private final View URC = this.hwr.findViewById(R.id.jta);
    private final Button URD = ((Button) this.hwr.findViewById(R.id.k3j));
    private final Button URE = ((Button) this.hwr.findViewById(R.id.jz_));
    private final Button URF = ((Button) this.hwr.findViewById(R.id.d7y));
    private boolean URG;
    public kotlin.g.a.a<x> URn;
    public kotlin.g.a.a<x> URo;
    public kotlin.g.a.b<? super String, x> URp;
    public kotlin.g.a.a<x> URq;
    avn URr;
    private boolean URs;
    private final RelativeLayout URt = ((RelativeLayout) this.hwr.findViewById(R.id.cv7));
    private final ImageView URu = ((ImageView) this.hwr.findViewById(R.id.jtb));
    private final WeImageView URv = ((WeImageView) this.hwr.findViewById(R.id.jzg));
    private final TextView URw = ((TextView) this.hwr.findViewById(R.id.k2y));
    private final TextView URx = ((TextView) this.hwr.findViewById(R.id.k30));
    private final FrameLayout URy = ((FrameLayout) this.hwr.findViewById(R.id.cv_));
    private final WeImageView URz = ((WeImageView) this.hwr.findViewById(R.id.jtf));
    private final ProgressBar hRO;
    private final View hRd = this.hwr.findViewById(R.id.cuy);
    private final View hRx = this.hwr.findViewById(R.id.cux);
    public final LiveBottomSheetPanel hRy = ((LiveBottomSheetPanel) this.hwr.findViewById(R.id.cuz));
    private final ImageView hXu = ((ImageView) this.hwr.findViewById(R.id.cv8));
    public final ViewGroup hwr;
    private bbn reportObj;
    private int sourceType;
    private final TextView titleTv = ((TextView) this.hwr.findViewById(R.id.k0v));
    private IListener<ik> vbQ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "isShow", "", "invoke", "com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget$1$1"})
    static final class a extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ v URH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(v vVar) {
            super(1);
            this.URH = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(261150);
            boolean booleanValue = bool.booleanValue();
            this.URH.URG = booleanValue;
            if (booleanValue) {
                kotlin.g.a.a<x> aVar = this.URH.URn;
                if (aVar != null) {
                    aVar.invoke();
                }
            } else {
                kotlin.g.a.a<x> aVar2 = this.URH.URo;
                if (aVar2 != null) {
                    aVar2.invoke();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(261150);
            return xVar;
        }
    }

    public v(ViewGroup viewGroup) {
        boolean z;
        p.h(viewGroup, "root");
        AppMethodBeat.i(261174);
        this.hwr = viewGroup;
        View findViewById = this.hwr.findViewById(R.id.epq);
        p.g(findViewById, "root.findViewById(R.id.loading_progress)");
        this.hRO = (ProgressBar) findViewById;
        LiveBottomSheetPanel liveBottomSheetPanel = this.hRy;
        liveBottomSheetPanel.setTranslationY((float) au.az(this.hwr.getContext()).y);
        liveBottomSheetPanel.setOnVisibilityListener(new a(this));
        if (liveBottomSheetPanel.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            Resources resources = context.getResources();
            p.g(resources, "root.context.resources");
            if (resources.getConfiguration().orientation == 2) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                LiveBottomSheetPanel liveBottomSheetPanel2 = this.hRy;
                LiveBottomSheetPanel liveBottomSheetPanel3 = this.hRy;
                p.g(liveBottomSheetPanel3, "contentGroup");
                int paddingLeft = liveBottomSheetPanel3.getPaddingLeft();
                LiveBottomSheetPanel liveBottomSheetPanel4 = this.hRy;
                p.g(liveBottomSheetPanel4, "contentGroup");
                int paddingTop = liveBottomSheetPanel4.getPaddingTop();
                LiveBottomSheetPanel liveBottomSheetPanel5 = this.hRy;
                p.g(liveBottomSheetPanel5, "contentGroup");
                liveBottomSheetPanel2.setPadding(paddingLeft, paddingTop, liveBottomSheetPanel5.getPaddingRight(), au.aD(this.hwr.getContext()));
            } else {
                liveBottomSheetPanel.getLayoutParams().width = au.az(this.hwr.getContext()).y;
                ViewGroup.LayoutParams layoutParams = liveBottomSheetPanel.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    AppMethodBeat.o(261174);
                    throw tVar;
                }
                ((LinearLayout.LayoutParams) layoutParams).gravity = 1;
            }
        }
        int aD = au.aD(this.hwr.getContext());
        ViewGroup.LayoutParams layoutParams2 = this.URC.getLayoutParams();
        if (layoutParams2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(261174);
            throw tVar2;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams.bottomMargin = aD + marginLayoutParams.bottomMargin;
        this.vbQ = new IListener<ik>(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.v.AnonymousClass1 */
            final /* synthetic */ v URH;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.URH = r1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ik ikVar) {
                boolean z;
                ik.a aVar;
                FinderContact finderContact;
                String str = null;
                AppMethodBeat.i(261152);
                ik ikVar2 = ikVar;
                avn avn = this.URH.URr;
                String str2 = (avn == null || (finderContact = avn.contact) == null) ? null : finderContact.username;
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (!(ikVar2 == null || (aVar = ikVar2.dNb) == null)) {
                        str = aVar.dNc;
                    }
                    if (p.j(str, str2)) {
                        d.h(new a(this, ikVar2, str2));
                    }
                }
                AppMethodBeat.o(261152);
                return false;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.finder.live.widget.v$1$a */
            static final class a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ AnonymousClass1 URJ;
                final /* synthetic */ ik URK;
                final /* synthetic */ String URM;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(AnonymousClass1 r2, ik ikVar, String str) {
                    super(0);
                    this.URJ = r2;
                    this.URK = ikVar;
                    this.URM = str;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    ik.a aVar;
                    AppMethodBeat.i(261151);
                    ik ikVar = this.URK;
                    Integer valueOf = (ikVar == null || (aVar = ikVar.dNb) == null) ? null : Integer.valueOf(aVar.opType);
                    bb.a aVar2 = bb.tve;
                    int i2 = bb.tvb;
                    if (valueOf != null && valueOf.intValue() == i2) {
                        v vVar = this.URJ.URH;
                        Context context = MMApplicationContext.getContext();
                        p.g(context, "MMApplicationContext.getContext()");
                        String string = context.getResources().getString(R.string.jbf);
                        p.g(string, "MMApplicationContext.get…ve_profile_followed_tips)");
                        vVar.bxS(string);
                    } else {
                        bb.a aVar3 = bb.tve;
                        int i3 = bb.tvc;
                        if (valueOf != null && valueOf.intValue() == i3) {
                            v vVar2 = this.URJ.URH;
                            Context context2 = MMApplicationContext.getContext();
                            p.g(context2, "MMApplicationContext.getContext()");
                            String string2 = context2.getResources().getString(R.string.jbl);
                            p.g(string2, "MMApplicationContext.get…ve_profile_unfollow_tips)");
                            vVar2.bxS(string2);
                        } else {
                            bb.a aVar4 = bb.tve;
                            int i4 = bb.tvd;
                            if (valueOf != null && valueOf.intValue() == i4) {
                                v vVar3 = this.URJ.URH;
                                Context context3 = MMApplicationContext.getContext();
                                p.g(context3, "MMApplicationContext.getContext()");
                                String string3 = context3.getResources().getString(R.string.jbj);
                                p.g(string3, "MMApplicationContext.get…file_unapply_follow_tips)");
                                vVar3.bxS(string3);
                            }
                        }
                    }
                    v.a(this.URJ.URH, this.URM);
                    x xVar = x.SXb;
                    AppMethodBeat.o(261151);
                    return xVar;
                }
            }
        };
        this.URt.setOnClickListener(this);
        this.hRd.setOnClickListener(this);
        this.hRx.setOnClickListener(this);
        this.URy.setOnClickListener(this);
        this.URD.setOnClickListener(this);
        this.URF.setOnClickListener(this);
        this.URE.setOnClickListener(this);
        AppMethodBeat.o(261174);
    }

    public static final /* synthetic */ void a(v vVar, String str) {
        AppMethodBeat.i(261175);
        vVar.auz(str);
        AppMethodBeat.o(261175);
    }

    public final void bxS(String str) {
        AppMethodBeat.i(261155);
        p.h(str, "msg");
        d.h(new b(this, str));
        AppMethodBeat.o(261155);
    }

    public final void hUn() {
        AppMethodBeat.i(261156);
        Log.i(this.TAG, "activate");
        IListener<ik> iListener = this.vbQ;
        if (iListener != null) {
            iListener.alive();
            AppMethodBeat.o(261156);
            return;
        }
        AppMethodBeat.o(261156);
    }

    public final void hUo() {
        AppMethodBeat.i(261157);
        Log.i(this.TAG, "deActivate");
        IListener<ik> iListener = this.vbQ;
        if (iListener != null) {
            iListener.dead();
        }
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3736, this);
        AppMethodBeat.o(261157);
    }

    public final void a(avn avn, int i2, bbn bbn) {
        String str;
        FinderContact finderContact;
        AppMethodBeat.i(261158);
        p.h(avn, "liveContact");
        int i3 = avn.Viq;
        Log.i(this.TAG, "showProfile contentIsShow:" + this.URG + ",roleType:" + i3 + ",sourceType:" + i2);
        this.URr = avn;
        this.sourceType = i2;
        this.reportObj = bbn;
        if (i3 != 3) {
            cCt();
            AppMethodBeat.o(261158);
            return;
        }
        this.hRO.setVisibility(0);
        View view = this.hRd;
        p.g(view, "closeBtn");
        view.setVisibility(4);
        FrameLayout frameLayout = this.URy;
        p.g(frameLayout, "moreAction");
        frameLayout.setVisibility(4);
        RelativeLayout relativeLayout = this.URt;
        p.g(relativeLayout, "profileInfoGroup");
        relativeLayout.setVisibility(4);
        View view2 = this.URC;
        p.g(view2, "anchorActionGroup");
        view2.setVisibility(4);
        if (!this.URG) {
            this.hRy.show();
        }
        avn avn2 = this.URr;
        if (avn2 == null || (finderContact = avn2.contact) == null || (str = finderContact.username) == null) {
            str = "";
        }
        cn cnVar = new cn(str, 0, null, 0, null, 0, 0, 104);
        cnVar.twC = true;
        g.azz().b(cnVar);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3736, this);
        AppMethodBeat.o(261158);
    }

    private final void cCt() {
        AppMethodBeat.i(261159);
        Log.i(this.TAG, "updateProfile contentIsShow:" + this.URG);
        avn avn = this.URr;
        if (avn != null) {
            FinderContact finderContact = avn.contact;
            String str = finderContact != null ? finderContact.username : null;
            c.a aVar = c.tsp;
            if (c.a.asG(str) == null) {
                FinderContact finderContact2 = avn.contact;
                if (finderContact2 != null) {
                    c.a aVar2 = c.tsp;
                    p.g(finderContact2, "finderContact");
                    c.a.a(finderContact2);
                }
                Log.i(this.TAG, "updateProfile :" + str + " localContact is empty,replace it!");
            }
            this.hRO.setVisibility(4);
            View view = this.hRd;
            p.g(view, "closeBtn");
            view.setVisibility(0);
            RelativeLayout relativeLayout = this.URt;
            p.g(relativeLayout, "profileInfoGroup");
            relativeLayout.setVisibility(0);
            View view2 = this.URC;
            p.g(view2, "anchorActionGroup");
            view2.setVisibility(0);
            a(avn, this.sourceType);
            if (!this.URG) {
                this.hRy.show();
            }
            AppMethodBeat.o(261159);
            return;
        }
        AppMethodBeat.o(261159);
    }

    private final void a(avn avn, int i2) {
        String str;
        String str2 = null;
        AppMethodBeat.i(261160);
        FinderContact finderContact = avn.contact;
        if (!(finderContact == null || (str = finderContact.headUrl) == null)) {
            m mVar = m.vVH;
            ImageView imageView = this.hXu;
            p.g(imageView, "avatarIcon");
            p.g(str, LocaleUtil.ITALIAN);
            m.g(imageView, str, avn.Viq);
        }
        Context context = this.hwr.getContext();
        y yVar = y.vXH;
        FinderContact finderContact2 = avn.contact;
        String str3 = finderContact2 != null ? finderContact2.username : null;
        FinderContact finderContact3 = avn.contact;
        if (finderContact3 != null) {
            str2 = finderContact3.nickname;
        }
        TextView textView = this.titleTv;
        p.g(textView, "titleTv");
        SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(context, y.hf(str3, str2), textView.getTextSize());
        p.g(b2, "MMSpanManager.spanForSmi…kname), titleTv.textSize)");
        a(avn, b2);
        b(avn);
        c(avn);
        d(avn);
        e(avn);
        f(avn);
        g(avn);
        hUp();
        Log.i(this.TAG, "updateProfileInfo," + h(avn) + ",sourceType:" + i2);
        AppMethodBeat.o(261160);
    }

    private final void a(avn avn, SpannableString spannableString) {
        int dimensionPixelOffset;
        boolean z = true;
        AppMethodBeat.i(261161);
        TextView textView = this.titleTv;
        p.g(textView, "titleTv");
        textView.setText(spannableString);
        TextView textView2 = this.titleTv;
        p.g(textView2, "titleTv");
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        if (avn.Viq == 2) {
            WeImageView weImageView = this.URz;
            p.g(weImageView, "banCommentIv");
            weImageView.setVisibility(8);
            ImageView imageView = this.hXu;
            p.g(imageView, "avatarIcon");
            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
            if (layoutParams2 != null) {
                dimensionPixelOffset = layoutParams2.height;
            } else {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.cp);
            }
            layoutParams.height = dimensionPixelOffset;
            AppMethodBeat.o(261161);
            return;
        }
        layoutParams.height = -2;
        if (avn.LGh != 1) {
            z = false;
        }
        if (z) {
            WeImageView weImageView2 = this.URz;
            p.g(weImageView2, "banCommentIv");
            weImageView2.setVisibility(0);
            AppMethodBeat.o(261161);
            return;
        }
        WeImageView weImageView3 = this.URz;
        p.g(weImageView3, "banCommentIv");
        weImageView3.setVisibility(8);
        AppMethodBeat.o(261161);
    }

    private final void b(avn avn) {
        int i2;
        FinderAuthInfo finderAuthInfo;
        AppMethodBeat.i(261162);
        if (avn.Viq == 2) {
            ImageView imageView = this.URu;
            p.g(imageView, "authInfoIv");
            imageView.setVisibility(8);
            AppMethodBeat.o(261162);
            return;
        }
        FinderContact finderContact = avn.contact;
        if (finderContact == null || (finderAuthInfo = finderContact.authInfo) == null) {
            i2 = 0;
        } else {
            i2 = finderAuthInfo.authIconType;
        }
        if (i2 > 0) {
            ImageView imageView2 = this.URu;
            p.g(imageView2, "authInfoIv");
            imageView2.setVisibility(0);
            y yVar = y.vXH;
            ImageView imageView3 = this.URu;
            p.g(imageView3, "authInfoIv");
            FinderContact finderContact2 = avn.contact;
            y.a(imageView3, finderContact2 != null ? finderContact2.authInfo : null, 0);
            AppMethodBeat.o(261162);
            return;
        }
        ImageView imageView4 = this.URu;
        p.g(imageView4, "authInfoIv");
        imageView4.setVisibility(8);
        AppMethodBeat.o(261162);
    }

    private final void c(avn avn) {
        AppMethodBeat.i(261163);
        if (avn.Viq == 3) {
            WeImageView weImageView = this.URv;
            p.g(weImageView, "finderUserArrowIv");
            weImageView.setVisibility(0);
            RelativeLayout relativeLayout = this.URt;
            p.g(relativeLayout, "profileInfoGroup");
            relativeLayout.setClickable(true);
            AppMethodBeat.o(261163);
            return;
        }
        WeImageView weImageView2 = this.URv;
        p.g(weImageView2, "finderUserArrowIv");
        weImageView2.setVisibility(8);
        RelativeLayout relativeLayout2 = this.URt;
        p.g(relativeLayout2, "profileInfoGroup");
        relativeLayout2.setClickable(false);
        AppMethodBeat.o(261163);
    }

    private final void d(avn avn) {
        app app;
        String str;
        String str2;
        String str3;
        app app2;
        app app3;
        app app4;
        app app5;
        app app6;
        app app7;
        String str4 = null;
        AppMethodBeat.i(261164);
        if (avn.Viq == 2) {
            TextView textView = this.URw;
            p.g(textView, "userInfoTv");
            textView.setVisibility(8);
            AppMethodBeat.o(261164);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        FinderContact finderContact = avn.contact;
        if (finderContact == null || (app7 = finderContact.extInfo) == null || app7.fuA != 1) {
            FinderContact finderContact2 = avn.contact;
            if (!(finderContact2 == null || (app = finderContact2.extInfo) == null || app.fuA != 2)) {
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                stringBuffer.append(context.getResources().getString(R.string.gxh)).append("  ");
            }
        } else {
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            p.g(stringBuffer.append(context2.getResources().getString(R.string.gxi)).append("  "), "tip.append(root.context.…g.sex_male)).append(\"  \")");
        }
        RegionCodeDecoder.gEm();
        FinderContact finderContact3 = avn.contact;
        if (finderContact3 == null || (app6 = finderContact3.extInfo) == null) {
            str = null;
        } else {
            str = app6.country;
        }
        FinderContact finderContact4 = avn.contact;
        String mV = RegionCodeDecoder.mV(str, (finderContact4 == null || (app5 = finderContact4.extInfo) == null) ? null : app5.fuJ);
        RegionCodeDecoder.gEm();
        FinderContact finderContact5 = avn.contact;
        if (finderContact5 == null || (app4 = finderContact5.extInfo) == null) {
            str2 = null;
        } else {
            str2 = app4.country;
        }
        FinderContact finderContact6 = avn.contact;
        if (finderContact6 == null || (app3 = finderContact6.extInfo) == null) {
            str3 = null;
        } else {
            str3 = app3.fuJ;
        }
        FinderContact finderContact7 = avn.contact;
        if (!(finderContact7 == null || (app2 = finderContact7.extInfo) == null)) {
            str4 = app2.fuK;
        }
        String br = RegionCodeDecoder.br(str2, str3, str4);
        if (!Util.isNullOrNil(mV)) {
            stringBuffer.append(mV).append(" ");
        }
        if (!Util.isNullOrNil(br)) {
            stringBuffer.append(br);
        }
        if (Util.isNullOrNil(n.trim(stringBuffer))) {
            TextView textView2 = this.URw;
            p.g(textView2, "userInfoTv");
            textView2.setVisibility(8);
            AppMethodBeat.o(261164);
            return;
        }
        TextView textView3 = this.URw;
        p.g(textView3, "userInfoTv");
        textView3.setVisibility(0);
        TextView textView4 = this.URw;
        p.g(textView4, "userInfoTv");
        textView4.setText(stringBuffer);
        AppMethodBeat.o(261164);
    }

    private final void e(avn avn) {
        AppMethodBeat.i(261165);
        int i2 = avn.Viq;
        if (i2 == 2) {
            TextView textView = this.URx;
            p.g(textView, "userSigatureTv");
            textView.setVisibility(8);
            AppMethodBeat.o(261165);
            return;
        }
        FinderContact finderContact = avn.contact;
        String str = finderContact != null ? finderContact.signature : null;
        if (Util.isNullOrNil(str)) {
            TextView textView2 = this.URx;
            p.g(textView2, "userSigatureTv");
            textView2.setVisibility(8);
            AppMethodBeat.o(261165);
            return;
        }
        if (i2 == 3) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            str = context.getResources().getString(R.string.jbc, str);
        }
        TextView textView3 = this.URx;
        p.g(textView3, "userSigatureTv");
        textView3.setVisibility(0);
        TextView textView4 = this.URx;
        p.g(textView4, "userSigatureTv");
        textView4.setText(str);
        AppMethodBeat.o(261165);
    }

    private final void f(avn avn) {
        int i2;
        AppMethodBeat.i(261166);
        if (avn.Viq == 2) {
            View view = this.URA;
            p.g(view, "followsGroup");
            view.setVisibility(8);
            AppMethodBeat.o(261166);
            return;
        }
        FinderContact finderContact = avn.contact;
        if (finderContact != null) {
            i2 = finderContact.friend_follow_count;
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            View view2 = this.URA;
            p.g(view2, "followsGroup");
            view2.setVisibility(0);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.jbe, Integer.valueOf(i2));
            p.g(string, "MMApplicationContext.get…wed_fans_desc, followCnt)");
            TextView textView = this.URB;
            p.g(textView, "followsDescTv");
            textView.setText(string);
            AppMethodBeat.o(261166);
            return;
        }
        View view3 = this.URA;
        p.g(view3, "followsGroup");
        view3.setVisibility(8);
        AppMethodBeat.o(261166);
    }

    private final void hUp() {
        AppMethodBeat.i(261167);
        if (this.sourceType == 1) {
            FrameLayout frameLayout = this.URy;
            p.g(frameLayout, "moreAction");
            frameLayout.setVisibility(0);
            AppMethodBeat.o(261167);
            return;
        }
        FrameLayout frameLayout2 = this.URy;
        p.g(frameLayout2, "moreAction");
        frameLayout2.setVisibility(4);
        AppMethodBeat.o(261167);
    }

    private final void g(avn avn) {
        int i2;
        boolean z;
        AppMethodBeat.i(261168);
        int i3 = avn.Viq;
        int i4 = avn.LGi;
        FinderContact finderContact = avn.contact;
        String str = finderContact != null ? finderContact.username : null;
        FinderContact finderContact2 = avn.contact;
        if (finderContact2 != null) {
            i2 = finderContact2.extFlag;
        } else {
            i2 = 0;
        }
        this.URs = d.cW(i2, 1024);
        switch (i3) {
            case 1:
                Button button = this.URD;
                p.g(button, "wechatPrivacyMsgBtn");
                button.setVisibility(0);
                Button button2 = this.URE;
                p.g(button2, "finderPrivacyMsgBtn");
                button2.setVisibility(8);
                Button button3 = this.URF;
                p.g(button3, "followBtn");
                button3.setVisibility(8);
                AppMethodBeat.o(261168);
                return;
            case 2:
                if (i4 > 0) {
                    Button button4 = this.URD;
                    p.g(button4, "wechatPrivacyMsgBtn");
                    button4.setVisibility(0);
                    Button button5 = this.URE;
                    p.g(button5, "finderPrivacyMsgBtn");
                    button5.setVisibility(8);
                    Button button6 = this.URF;
                    p.g(button6, "followBtn");
                    button6.setVisibility(8);
                    AppMethodBeat.o(261168);
                    return;
                }
                Button button7 = this.URD;
                p.g(button7, "wechatPrivacyMsgBtn");
                button7.setVisibility(8);
                Button button8 = this.URE;
                p.g(button8, "finderPrivacyMsgBtn");
                button8.setVisibility(8);
                Button button9 = this.URF;
                p.g(button9, "followBtn");
                button9.setVisibility(8);
                AppMethodBeat.o(261168);
                return;
            case 3:
                Button button10 = this.URD;
                p.g(button10, "wechatPrivacyMsgBtn");
                button10.setVisibility(8);
                Button button11 = this.URE;
                p.g(button11, "finderPrivacyMsgBtn");
                button11.setVisibility(8);
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Button button12 = this.URF;
                    p.g(button12, "followBtn");
                    button12.setVisibility(8);
                    AppMethodBeat.o(261168);
                    return;
                }
                Button button13 = this.URF;
                p.g(button13, "followBtn");
                button13.setVisibility(0);
                auz(str);
                AppMethodBeat.o(261168);
                return;
            default:
                Button button14 = this.URD;
                p.g(button14, "wechatPrivacyMsgBtn");
                button14.setVisibility(8);
                Button button15 = this.URE;
                p.g(button15, "finderPrivacyMsgBtn");
                button15.setVisibility(8);
                Button button16 = this.URF;
                p.g(button16, "followBtn");
                button16.setVisibility(8);
                AppMethodBeat.o(261168);
                return;
        }
    }

    private final void auz(String str) {
        AppMethodBeat.i(261169);
        g.a aVar = com.tencent.mm.plugin.finder.upload.action.g.vUn;
        if (com.tencent.mm.plugin.finder.upload.action.g.vUm.asJ(str)) {
            Log.i(this.TAG, "handleFollowBtn have follow user:".concat(String.valueOf(str)));
            Button button = this.URF;
            p.g(button, "followBtn");
            button.setEnabled(true);
            Button button2 = this.URF;
            p.g(button2, "followBtn");
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            button2.setText(context.getResources().getString(R.string.jbk));
            this.URF.setBackgroundResource(R.drawable.cup);
            AppMethodBeat.o(261169);
            return;
        }
        g.a aVar2 = com.tencent.mm.plugin.finder.upload.action.g.vUn;
        if (com.tencent.mm.plugin.finder.upload.action.g.vUm.asK(str)) {
            Log.i(this.TAG, "handleFollowBtn waiting user:" + str + " to allow");
            Button button3 = this.URF;
            p.g(button3, "followBtn");
            button3.setEnabled(false);
            Button button4 = this.URF;
            p.g(button4, "followBtn");
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            button4.setText(context2.getResources().getString(R.string.jbi));
            this.URF.setBackgroundResource(R.drawable.cup);
            AppMethodBeat.o(261169);
            return;
        }
        Button button5 = this.URF;
        p.g(button5, "followBtn");
        button5.setEnabled(true);
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        String string = context3.getResources().getString(R.string.jbd);
        p.g(string, "MMApplicationContext.get…nder_live_profile_follow)");
        if (this.URs) {
            Context context4 = MMApplicationContext.getContext();
            p.g(context4, "MMApplicationContext.getContext()");
            string = context4.getResources().getString(R.string.jbh);
            p.g(string, "MMApplicationContext.get…ofile_req_follow_privacy)");
        }
        Button button6 = this.URF;
        p.g(button6, "followBtn");
        button6.setText(string);
        this.URF.setBackgroundResource(R.drawable.a01);
        AppMethodBeat.o(261169);
    }

    private final void awS(int i2) {
        FinderContact finderContact;
        AppMethodBeat.i(261170);
        avn avn = this.URr;
        String str = (avn == null || (finderContact = avn.contact) == null) ? null : finderContact.username;
        if (str != null) {
            bbn bbn = this.reportObj;
            if (bbn == null) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                bbn = ((FinderReporterUIC) com.tencent.mm.ui.component.a.ko(context).get(FinderReporterUIC.class)).dIx();
            }
            ag agVar = ag.uOs;
            ag.a(bbn, str, i2, false);
            AppMethodBeat.o(261170);
            return;
        }
        AppMethodBeat.o(261170);
    }

    public final void onClick(View view) {
        FinderContact finderContact;
        FinderContact finderContact2;
        String str = null;
        AppMethodBeat.i(261171);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.cv7) {
            m mVar = m.vVH;
            if (m.dBP()) {
                k kVar = k.vkd;
                k.a(s.ak.CLICK_ENTER_USER_PROFILE);
            }
            kotlin.g.a.b<? super String, x> bVar2 = this.URp;
            if (bVar2 != null) {
                avn avn = this.URr;
                bVar2.invoke((avn == null || (finderContact = avn.contact) == null) ? null : finderContact.username);
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.cuy) {
            this.hRy.hide();
            m mVar2 = m.vVH;
            if (m.dBP()) {
                k kVar2 = k.vkd;
                k.a(s.c.SEE_GIFT_LIST, String.valueOf(s.ak.RETURN_LIVE_ROOM.action));
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.cux) {
            this.hRy.hide();
            m mVar3 = m.vVH;
            if (m.dBP()) {
                k kVar3 = k.vkd;
                k.a(s.c.SEE_GIFT_LIST, String.valueOf(s.ak.RETURN_LIVE_ROOM.action));
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.cv_) {
            this.hRy.hide();
            kotlin.g.a.a<x> aVar = this.URq;
            if (aVar != null) {
                aVar.invoke();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.k3j) {
            avn avn2 = this.URr;
            if (!(avn2 == null || (finderContact2 = avn2.contact) == null)) {
                str = finderContact2.username;
            }
            if (str != null) {
                m mVar4 = m.vVH;
                if (m.dBP()) {
                    k kVar4 = k.vkd;
                    k.a(s.ak.CLICK_PRIVATE_MSG_USER);
                }
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                String aUg = z.aUg();
                p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                com.tencent.mm.plugin.finder.utils.a.z(context, aUg, str);
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.d7y) {
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.Button");
                AppMethodBeat.o(261171);
                throw tVar;
            }
            CharSequence text = ((Button) view).getText();
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            if (p.j(text, context2.getResources().getString(R.string.jbd))) {
                m mVar5 = m.vVH;
                if (m.dBP()) {
                    k kVar5 = k.vkd;
                    k.a(s.ak.CLICK_FOLLOW_USER);
                }
                bb.a aVar3 = bb.tve;
                awS(bb.tvb);
            } else {
                Context context3 = MMApplicationContext.getContext();
                p.g(context3, "MMApplicationContext.getContext()");
                if (p.j(text, context3.getResources().getString(R.string.jbk))) {
                    bb.a aVar4 = bb.tve;
                    awS(bb.tvc);
                } else {
                    Context context4 = MMApplicationContext.getContext();
                    p.g(context4, "MMApplicationContext.getContext()");
                    if (p.j(text, context4.getResources().getString(R.string.jbi))) {
                        bb.a aVar5 = bb.tve;
                        awS(bb.tvd);
                    }
                }
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(261171);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String str2;
        FinderContact finderContact;
        boolean z = false;
        String str3 = null;
        AppMethodBeat.i(261172);
        Log.i(this.TAG, "onSceneEnd errType:" + i2 + ", errCode:" + i3 + ", scene:" + qVar);
        if (qVar instanceof cn) {
            FinderContact cZk = ((cn) qVar).cZk();
            int visibility = this.hwr.getVisibility();
            Context context = this.hwr.getContext();
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            boolean z2 = activity != null && activity.isFinishing();
            avn avn = this.URr;
            if (avn == null || (finderContact = avn.contact) == null) {
                str2 = null;
            } else {
                str2 = finderContact.username;
            }
            String str4 = this.TAG;
            StringBuilder append = new StringBuilder("onSceneEnd,isOnlyFetchUserInfo:").append(((cn) qVar).twC).append(", cur liveContact username:").append(str2).append(", req username:").append(((cn) qVar).tuH).append("，contact username:");
            if (cZk != null) {
                str3 = cZk.username;
            }
            Log.i(str4, append.append(str3).append(",visibility:").append(visibility).append(",isFinish:").append(z2).toString());
            String str5 = str2;
            if (str5 == null || str5.length() == 0) {
                z = true;
            }
            if (!z && ((cn) qVar).twC && p.j(((cn) qVar).tuH, str2)) {
                com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
                p.g(aAg, "MMKernel.network()");
                aAg.azz().b(3736, this);
                if (z2 || visibility != 0 || this.URr == null) {
                    this.hRy.hide();
                    AppMethodBeat.o(261172);
                    return;
                }
                avn avn2 = this.URr;
                if (avn2 != null) {
                    avn2.contact = cZk;
                }
                cCt();
            }
        }
        AppMethodBeat.o(261172);
    }

    private static String h(avn avn) {
        String str;
        app app;
        FinderAuthInfo finderAuthInfo;
        boolean z = true;
        String str2 = null;
        AppMethodBeat.i(261173);
        StringBuilder sb = new StringBuilder("headUrl is empty:");
        FinderContact finderContact = avn.contact;
        if (finderContact != null) {
            str = finderContact.headUrl;
        } else {
            str = null;
        }
        String str3 = str;
        StringBuilder append = sb.append(str3 == null || str3.length() == 0).append(", nickName:");
        FinderContact finderContact2 = avn.contact;
        StringBuilder append2 = append.append(finderContact2 != null ? finderContact2.nickname : null).append(",authIconType:");
        FinderContact finderContact3 = avn.contact;
        StringBuilder append3 = append2.append((finderContact3 == null || (finderAuthInfo = finderContact3.authInfo) == null) ? null : Integer.valueOf(finderAuthInfo.authIconType)).append(',').append("roleType:").append(avn.Viq).append(",disableComment:").append(avn.LGh).append(", extInfo is empty:");
        FinderContact finderContact4 = avn.contact;
        if (finderContact4 != null) {
            app = finderContact4.extInfo;
        } else {
            app = null;
        }
        StringBuilder append4 = append3.append(app == null).append(",signature is empty:");
        FinderContact finderContact5 = avn.contact;
        if (finderContact5 != null) {
            str2 = finderContact5.signature;
        }
        if (str2 != null) {
            z = false;
        }
        String sb2 = append4.append(z).append(",reward:").append(avn.LGi).toString();
        AppMethodBeat.o(261173);
        return sb2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ v URH;
        final /* synthetic */ String uhA;
        final /* synthetic */ int uxz = R.raw.icons_outlined_done;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(v vVar, String str) {
            super(0);
            this.URH = vVar;
            this.uhA = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(261154);
            u.a(this.URH.hwr.getContext(), this.uhA, new u.b(this) {
                /* class com.tencent.mm.plugin.finder.live.widget.v.b.AnonymousClass1 */
                final /* synthetic */ b URN;

                {
                    this.URN = r1;
                }

                @Override // com.tencent.mm.ui.base.u.b
                public final void dU(View view) {
                    WeImageView weImageView;
                    TextView textView;
                    AppMethodBeat.i(261153);
                    if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                        textView.setTextSize(1, 14.0f);
                    }
                    if (view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null) {
                        AppMethodBeat.o(261153);
                        return;
                    }
                    weImageView.setImageResource(this.URN.uxz);
                    AppMethodBeat.o(261153);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(261154);
            return xVar;
        }
    }
}
