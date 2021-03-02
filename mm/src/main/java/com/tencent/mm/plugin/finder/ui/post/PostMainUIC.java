package com.tencent.mm.plugin.finder.ui.post;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.ui.post.PostLocationUIC;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderExtendActivityView;
import com.tencent.mm.plugin.finder.view.FinderPostFooter;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0001xB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010P\u001a\u00020QH\u0002J\u0006\u0010R\u001a\u00020QJ\b\u0010S\u001a\u00020QH\u0002J\b\u0010T\u001a\u00020QH\u0002J\u0006\u0010U\u001a\u00020QJ\b\u0010V\u001a\u00020QH\u0002J\b\u0010W\u001a\u00020\nH\u0016J\b\u0010X\u001a\u00020QH\u0002J\b\u0010Y\u001a\u00020QH\u0002J\u0006\u0010Z\u001a\u00020QJ\"\u0010[\u001a\u00020Q2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010]\u001a\u00020\n2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\b\u0010`\u001a\u00020,H\u0016J\u0012\u0010a\u001a\u00020Q2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u0018\u0010d\u001a\u00020Q2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020,H\u0016J\b\u0010g\u001a\u00020QH\u0016J\b\u0010h\u001a\u00020QH\u0016J\b\u0010i\u001a\u00020jH\u0002J\b\u0010k\u001a\u00020lH\u0002J\u0010\u0010m\u001a\u00020Q2\u0006\u0010n\u001a\u00020\nH\u0002J\b\u0010o\u001a\u00020QH\u0002J\b\u0010p\u001a\u00020QH\u0002J\u0010\u0010q\u001a\u00020Q2\u0006\u0010r\u001a\u00020sH\u0002J\b\u0010t\u001a\u00020QH\u0002J\b\u0010u\u001a\u00020QH\u0002J\b\u0010v\u001a\u00020QH\u0002J\b\u0010w\u001a\u00020QH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R#\u0010\u0018\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0019\u0010\u0013R\u000e\u0010\u001b\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R#\u0010#\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b$\u0010\u0013R\u000e\u0010&\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R#\u0010-\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b.\u0010\u0013R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X.¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X.¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020?X.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020HX.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR#\u0010M\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\bO\u0010\u0015\u001a\u0004\bN\u0010\u0013¨\u0006y"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/post/PostMainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "FLUTTER_TAG", "", "TAG", "actionBarHeight", "", "activityPostView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "activityWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget;", "addMediaBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getAddMediaBtn", "()Landroid/view/View;", "addMediaBtn$delegate", "Lkotlin/Lazy;", "avatarIv", "Landroid/widget/ImageView;", "backBtn", "getBackBtn", "backBtn$delegate", "bottomSpace", "checkPostTime", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "delMediaBtn", "getDelMediaBtn", "delMediaBtn$delegate", "edtContainer", "edtLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "extendReadingWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendReadingWidget;", "hasStartKeyBoardProvider", "", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "getHeader", "header$delegate", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "longVideoLinkView", "mediaViewContainer", "Landroid/view/ViewGroup;", "mediaWidget", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "myFinderUser", "newsWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderSetNewsFeedWidget;", "nickTv", "Landroid/widget/TextView;", "originalWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderOriginalWidget;", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "setPostDataManager", "(Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "reportFlag", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "setScrollView", "(Landroid/widget/ScrollView;)V", "sendBtn", "getSendBtn", "sendBtn$delegate", "checkNeedScroll", "", "checkNextEnable", "checkPostData", "delMediaInternal", "enterFinderMediaPreviewAtTimelineUI", "exitAndSave", "getLayoutId", "initDelMediaBtn", "initPostMediaWidget", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyboardHeightChanged", "height", "isResized", "onResume", "onUserVisibleFocused", "postEditUIC", "Lcom/tencent/mm/plugin/finder/ui/post/PostEditUIC;", "postLocationUIC", "Lcom/tencent/mm/plugin/finder/ui/post/PostLocationUIC;", "reportMediaDelOp", NativeProtocol.WEB_DIALOG_ACTION, "restore", "routeBack", "routeForward", ch.COL_LOCALID, "", "save", "selectMedia", "setWindowStyle", "showDelBottomSheet", "Companion", "plugin-finder_release"})
public final class PostMainUIC extends UIComponent implements com.tencent.mm.ui.tools.g {
    public static final a vRu = new a((byte) 0);
    private final String TAG = "Finder.FinderPostUI";
    private com.tencent.mm.plugin.finder.api.g contact;
    private com.tencent.mm.ui.base.q gut;
    public ScrollView gxx;
    private com.tencent.mm.ui.tools.h gyh;
    private ImageView gyr;
    private TextView kib;
    private final kotlin.f uZN;
    private int udM;
    private View vMo;
    private String vOl = "";
    private final String vRb = "Finder.FinderRecordPluginLayout.FlutterVideoEditor_DataReport";
    private ViewGroup vRc;
    private View vRd;
    private boolean vRe;
    private com.tencent.mm.plugin.finder.widget.post.a vRf;
    private com.tencent.mm.plugin.finder.upload.postui.b vRg;
    private com.tencent.mm.plugin.finder.upload.postui.d vRh;
    private com.tencent.mm.plugin.finder.upload.postui.e vRi;
    private View vRj;
    private com.tencent.mm.plugin.finder.upload.postui.a vRk;
    private FinderExtendActivityView vRl;
    private final kotlin.f vRm;
    private final kotlin.f vRn;
    private final kotlin.f vRo;
    private final kotlin.f vRp;
    public com.tencent.mm.plugin.finder.widget.post.c vRq;
    private int vRr;
    private boolean vRs;
    private final View.OnLayoutChangeListener vRt;

    static {
        AppMethodBeat.i(253001);
        AppMethodBeat.o(253001);
    }

    private final View dAF() {
        AppMethodBeat.i(252984);
        View view = (View) this.vRm.getValue();
        AppMethodBeat.o(252984);
        return view;
    }

    private final View dAG() {
        AppMethodBeat.i(252985);
        View view = (View) this.vRn.getValue();
        AppMethodBeat.o(252985);
        return view;
    }

    private final View dAH() {
        AppMethodBeat.i(252986);
        View view = (View) this.vRo.getValue();
        AppMethodBeat.o(252986);
        return view;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", WeChatBrands.Business.GROUP_OPEN, "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ PostMainUIC vRv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(PostMainUIC postMainUIC) {
            super(1);
            this.vRv = postMainUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(252974);
            if (bool.booleanValue()) {
                PostMainUIC.d(this.vRv).close();
            } else {
                PostMainUIC.d(this.vRv).start();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252974);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostMainUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(253000);
        this.vRm = kotlin.g.ah(new f(appCompatActivity));
        this.vRn = kotlin.g.ah(new b(appCompatActivity));
        this.uZN = kotlin.g.ah(new c(appCompatActivity));
        this.vRo = kotlin.g.ah(new t(appCompatActivity));
        this.vRp = kotlin.g.ah(new j(appCompatActivity));
        this.vRt = new g(this);
        AppMethodBeat.o(253000);
    }

    public static final /* synthetic */ void a(PostMainUIC postMainUIC) {
        AppMethodBeat.i(253002);
        postMainUIC.dAM();
        AppMethodBeat.o(253002);
    }

    public static final /* synthetic */ com.tencent.mm.ui.tools.h d(PostMainUIC postMainUIC) {
        AppMethodBeat.i(253004);
        com.tencent.mm.ui.tools.h hVar = postMainUIC.gyh;
        if (hVar == null) {
            kotlin.g.b.p.btv("keyboardHeightProvider");
        }
        AppMethodBeat.o(253004);
        return hVar;
    }

    public static final /* synthetic */ PostEditUIC g(PostMainUIC postMainUIC) {
        AppMethodBeat.i(253006);
        PostEditUIC dAL = postMainUIC.dAL();
        AppMethodBeat.o(253006);
        return dAL;
    }

    public static final /* synthetic */ PostLocationUIC j(PostMainUIC postMainUIC) {
        AppMethodBeat.i(253009);
        PostLocationUIC dAK = postMainUIC.dAK();
        AppMethodBeat.o(253009);
        return dAK;
    }

    public static final /* synthetic */ View m(PostMainUIC postMainUIC) {
        AppMethodBeat.i(253011);
        View view = postMainUIC.vMo;
        if (view == null) {
            kotlin.g.b.p.btv("edtContainer");
        }
        AppMethodBeat.o(253011);
        return view;
    }

    public static final /* synthetic */ View o(PostMainUIC postMainUIC) {
        AppMethodBeat.i(253012);
        View view = postMainUIC.vRd;
        if (view == null) {
            kotlin.g.b.p.btv("bottomSpace");
        }
        AppMethodBeat.o(253012);
        return view;
    }

    public final ScrollView dAE() {
        AppMethodBeat.i(252983);
        ScrollView scrollView = this.gxx;
        if (scrollView == null) {
            kotlin.g.b.p.btv("scrollView");
        }
        AppMethodBeat.o(252983);
        return scrollView;
    }

    public final com.tencent.mm.plugin.finder.widget.post.c dAD() {
        AppMethodBeat.i(252987);
        com.tencent.mm.plugin.finder.widget.post.c cVar = this.vRq;
        if (cVar == null) {
            kotlin.g.b.p.btv("postDataManager");
        }
        AppMethodBeat.o(252987);
        return cVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/post/PostMainUIC$Companion;", "", "()V", "CHECK_POST_INTERVAL", "", "CONFIME_DEL_MEDIA", "", "MAX_CHECK_POST_COUNT", "REQUEST_CODE_PICK_LOCATION", "REQUEST_CODE_SELECTE_MEDIA", "REQUEST_CODE_SELECT_AT_CONTACT", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:331:0x0b51, code lost:
        if (r2 != null) goto L_0x0b53;
     */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r19) {
        /*
        // Method dump skipped, instructions count: 3328
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.post.PostMainUIC.onCreate(android.os.Bundle):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class m implements View.OnClickListener {
        final /* synthetic */ PostMainUIC vRv;

        m(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252972);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            PostMainUIC.a(this.vRv);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252972);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class n implements View.OnClickListener {
        final /* synthetic */ MMActivity nbB;
        final /* synthetic */ PostMainUIC vRv;

        n(PostMainUIC postMainUIC, MMActivity mMActivity) {
            this.vRv = postMainUIC;
            this.nbB = mMActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252973);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (Util.isNullOrNil(z.aUg())) {
                y yVar = y.vXH;
                if (y.bE(this.nbB)) {
                    Intent intent = new Intent();
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    if (Util.isNullOrNil(((SdkShareUIC) com.tencent.mm.ui.component.a.b(this.nbB).get(SdkShareUIC.class)).dAO())) {
                        intent.putExtra("key_create_scene", 4);
                    } else {
                        intent.putExtra("key_create_scene", 5);
                    }
                    intent.putExtra("scene", 2);
                    intent.putExtra("key_router_to_profile", false);
                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.w(this.nbB, intent);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20694, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(252973);
                return;
            }
            if (this.vRv.vRr == 0) {
                if (this.vRv.getIntent().getIntExtra("key_finder_post_from", -1) == 5) {
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1) {
                        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        int dsS = com.tencent.mm.plugin.finder.storage.c.dsS();
                        if (dsS < 6) {
                            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                            com.tencent.mm.plugin.finder.storage.c.KS(dsS + 1);
                        }
                    }
                }
                com.tencent.mm.plugin.vlog.model.m mVar = com.tencent.mm.plugin.vlog.model.m.Gyi;
                com.tencent.mm.plugin.vlog.model.m.fBe();
                PostMainUIC.c(this.vRv);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252973);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class p implements View.OnClickListener {
        final /* synthetic */ PostMainUIC vRv;

        p(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(252975);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.widget.post.a aVar = this.vRv.vRf;
            if (!(aVar instanceof com.tencent.mm.plugin.finder.widget.post.f)) {
                aVar = null;
            }
            com.tencent.mm.plugin.finder.widget.post.f fVar = (com.tencent.mm.plugin.finder.widget.post.f) aVar;
            if (fVar != null) {
                cjk cjk = new cjk();
                if (fVar.wDo == null) {
                    ArrayList<String> arrayList = fVar.wDi;
                    if (!(arrayList == null || (str = (String) kotlin.a.j.ks(arrayList)) == null)) {
                        cjx cjx = new cjx();
                        MultiMediaVideoChecker.a aTV = MultiMediaVideoChecker.GyY.aTV(str);
                        if (aTV != null) {
                            int i2 = aTV.width;
                            int i3 = aTV.height;
                            int mp4RotateVFS = SightVideoJNI.getMp4RotateVFS(str);
                            if (mp4RotateVFS == 90 || mp4RotateVFS == 270) {
                                i2 = aTV.height;
                                i3 = aTV.width;
                            }
                            int i4 = au.az(fVar.context).x;
                            float f2 = ((float) i2) / ((float) i3);
                            if (f2 >= 0.5625f && f2 <= 1.7777778f) {
                                erf erf = new erf();
                                erf.left = 0;
                                erf.top = i3;
                                erf.right = i2;
                                erf.bottom = 0;
                                cjx.Mpq = erf;
                                cjx.Mps = erf;
                                List listOf = kotlin.a.j.listOf((Object[]) new Float[]{Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f)});
                                bej bej = new bej();
                                bej.LOe.addAll(kotlin.a.j.p(listOf));
                                cjx.Mpr = bej;
                            } else if (f2 > 1.7777778f) {
                                int i5 = (int) ((((float) i3) * 16.0f) / 9.0f);
                                erf erf2 = new erf();
                                erf2.left = (i2 - i5) / 2;
                                erf2.top = i3;
                                erf2.right = i2 - erf2.left;
                                erf2.bottom = 0;
                                cjx.Mpq = erf2;
                                cjx.Mps = erf2;
                                Matrix matrix = new Matrix();
                                matrix.postTranslate(-((float) erf2.left), 0.0f);
                                bej bej2 = new bej();
                                float[] fArr = new float[9];
                                matrix.getValues(fArr);
                                bej2.LOe.addAll(kotlin.a.e.s(fArr));
                                cjx.Mpr = bej2;
                                i2 = i5;
                            } else {
                                int i6 = (int) ((((float) i2) * 16.0f) / 9.0f);
                                erf erf3 = new erf();
                                erf3.left = 0;
                                erf3.bottom = (i3 - i6) / 2;
                                erf3.right = i2;
                                erf3.top = i3 - erf3.bottom;
                                cjx.Mpq = erf3;
                                cjx.Mps = erf3;
                                Matrix matrix2 = new Matrix();
                                matrix2.postTranslate(0.0f, -((float) erf3.bottom));
                                bej bej3 = new bej();
                                float[] fArr2 = new float[9];
                                matrix2.getValues(fArr2);
                                bej3.LOe.addAll(kotlin.a.e.s(fArr2));
                                cjx.Mpr = bej3;
                                i3 = i6;
                            }
                            cjx.dvv = 0;
                            cjx.iqg = (int) aTV.duration;
                            cjx.width = i2;
                            cjx.height = i3;
                            cjx.retryCount = 0;
                            fVar.wDo = cjx;
                        }
                    }
                    x xVar = x.SXb;
                }
                ArrayList<String> arrayList2 = fVar.wDi;
                if (arrayList2 == null) {
                    kotlin.g.b.p.hyc();
                }
                int i7 = 0;
                for (T t : arrayList2) {
                    int i8 = i7 + 1;
                    if (i7 < 0) {
                        kotlin.a.j.hxH();
                    }
                    LinkedList<cjl> linkedList = cjk.mediaList;
                    com.tencent.mm.plugin.finder.upload.i iVar = com.tencent.mm.plugin.finder.upload.i.vSX;
                    linkedList.add(com.tencent.mm.plugin.finder.upload.i.a(t, "", fVar.wDo));
                    i7 = i8;
                }
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context = fVar.context;
                if (context == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(252975);
                    throw tVar;
                }
                com.tencent.mm.plugin.finder.utils.a.a((Activity) context, (ViewAnimHelper.ViewInfo) null, cjk, (azy) null, true, 8);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252975);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class q implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tru;

        q(com.tencent.mm.plugin.finder.view.d dVar) {
            this.tru = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252976);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tru.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252976);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(252989);
        if (!this.vRs) {
            com.tencent.mm.ui.tools.h hVar = this.gyh;
            if (hVar == null) {
                kotlin.g.b.p.btv("keyboardHeightProvider");
            }
            hVar.start();
            this.vRs = true;
        }
        AppMethodBeat.o(252989);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(252990);
        super.onResume();
        this.udM = au.eu(getContext());
        com.tencent.mm.plugin.finder.upload.postui.b bVar = this.vRg;
        if (bVar == null) {
            kotlin.g.b.p.btv("extendReadingWidget");
        }
        bVar.vUH.dHC();
        com.tencent.mm.plugin.vlog.model.m mVar = com.tencent.mm.plugin.vlog.model.m.Gyi;
        com.tencent.mm.plugin.vlog.model.m.fBd();
        AppMethodBeat.o(252990);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        boolean z;
        AppMethodBeat.i(252991);
        com.tencent.mm.plugin.finder.upload.postui.b bVar = this.vRg;
        if (bVar == null) {
            kotlin.g.b.p.btv("extendReadingWidget");
        }
        if (bVar.vUH.wsQ) {
            bVar.vUH.dHA();
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            dAM();
            AppMethodBeat.o(252991);
            return true;
        }
        AppMethodBeat.o(252991);
        return false;
    }

    private final void dAI() {
        AppMethodBeat.i(252992);
        View dAF = dAF();
        kotlin.g.b.p.g(dAF, "delMediaBtn");
        ViewGroup viewGroup = this.vRc;
        if (viewGroup == null) {
            kotlin.g.b.p.btv("mediaViewContainer");
        }
        dAF.setVisibility(viewGroup.getChildCount() != 0 ? 0 : 8);
        dAF().setOnClickListener(new k(this));
        dAG().setOnClickListener(new l(this));
        AppMethodBeat.o(252992);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ PostMainUIC vRv;

        k(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252970);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initDelMediaBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            PostMainUIC.f(this.vRv);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initDelMediaBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252970);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class l implements View.OnClickListener {
        final /* synthetic */ PostMainUIC vRv;

        l(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252971);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initDelMediaBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            PostMainUIC.g(this.vRv).dAC();
            Intent intent = new Intent();
            intent.putExtras(this.vRv.getIntent());
            intent.putExtra("album_from_finder_add_media", true);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.b(intent, this.vRv.getIntent());
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.J(this.vRv.getActivity(), intent);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.Kr(1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initDelMediaBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252971);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class u implements o.f {
        final /* synthetic */ PostMainUIC vRv;

        u(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(252980);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.a(20003, this.vRv.getContext().getResources().getColor(R.color.Red), this.vRv.getContext().getResources().getString(R.string.d5c));
            }
            AppMethodBeat.o(252980);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class v implements o.g {
        final /* synthetic */ PostMainUIC vRv;

        v(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(252981);
            kotlin.g.b.p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 20003:
                    PostMainUIC.h(this.vRv);
                    PostMainUIC.i(this.vRv);
                    break;
            }
            AppMethodBeat.o(252981);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class w implements e.b {
        final /* synthetic */ PostMainUIC vRv;

        w(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(252982);
            PostMainUIC.i(this.vRv);
            AppMethodBeat.o(252982);
        }
    }

    public final void dAJ() {
        AppMethodBeat.i(252993);
        if (getActivity() == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(252993);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.upload.postui.b bVar = this.vRg;
        if (bVar == null) {
            kotlin.g.b.p.btv("extendReadingWidget");
        }
        if (!bVar.vUH.dHB() || !dAL().vQT) {
            View dAH = dAH();
            kotlin.g.b.p.g(dAH, "sendBtn");
            dAH.setEnabled(false);
            AppMethodBeat.o(252993);
        } else if (this.vRf != null) {
            View dAH2 = dAH();
            kotlin.g.b.p.g(dAH2, "sendBtn");
            dAH2.setEnabled(true);
            AppMethodBeat.o(252993);
        } else {
            View dAH3 = dAH();
            kotlin.g.b.p.g(dAH3, "sendBtn");
            dAH3.setEnabled(false);
            AppMethodBeat.o(252993);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.aik;
    }

    private final PostLocationUIC dAK() {
        AppMethodBeat.i(252994);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(getActivity()).get(PostLocationUIC.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…tLocationUIC::class.java)");
        PostLocationUIC postLocationUIC = (PostLocationUIC) viewModel;
        AppMethodBeat.o(252994);
        return postLocationUIC;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
    static final class g implements View.OnLayoutChangeListener {
        final /* synthetic */ PostMainUIC vRv;

        g(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(252966);
            Log.i(this.vRv.TAG, "oldBottom " + i9 + ", bottom " + i5);
            if (i9 != i5) {
                PostMainUIC.l(this.vRv);
            }
            AppMethodBeat.o(252966);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ PostMainUIC vRv;
        final /* synthetic */ int vRw;
        final /* synthetic */ int vRx;

        d(PostMainUIC postMainUIC, int i2, int i3) {
            this.vRv = postMainUIC;
            this.vRw = i2;
            this.vRx = i3;
        }

        public final void run() {
            AppMethodBeat.i(252963);
            this.vRv.dAE().scrollBy(0, this.vRw - this.vRx);
            AppMethodBeat.o(252963);
        }
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        AppMethodBeat.i(252995);
        FinderPostFooter dAy = dAL().dAy();
        View dAz = dAL().dAz();
        boolean z2 = i2 > 0;
        if (i2 > 0 && i2 != ((int) dAy.wkX)) {
            KeyBoardUtil.saveKeyBordHeightPx(dAy.getContext(), i2);
            dAy.wkX = (float) i2;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) dAy.wkX);
            SmileyPanel smileyPanel = dAy.hQS;
            if (smileyPanel == null) {
                kotlin.g.b.p.btv("smileyPanel");
            }
            smileyPanel.setLayoutParams(layoutParams);
        }
        ImageView imageView = dAy.wkR;
        if (imageView == null) {
            kotlin.g.b.p.btv("smileyBtn");
        }
        Object tag = imageView.getTag();
        if (tag == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(252995);
            throw tVar;
        }
        boolean booleanValue = ((Boolean) tag).booleanValue();
        if (z2 || booleanValue) {
            View view = dAy.jxm;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = dAy.jxm;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        if (z2 && booleanValue) {
            dAy.R(false, false);
        }
        dAy.post(new r(this, dAz));
        AppMethodBeat.o(252995);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class r implements Runnable {
        final /* synthetic */ PostMainUIC vRv;
        final /* synthetic */ View vRy;

        r(PostMainUIC postMainUIC, View view) {
            this.vRv = postMainUIC;
            this.vRy = view;
        }

        public final void run() {
            AppMethodBeat.i(252977);
            Log.i(this.vRv.TAG, "footer.height " + this.vRy.getHeight() + ", footer.oldHeight " + PostMainUIC.g(this.vRv).vQU);
            if (this.vRy.getVisibility() == 0) {
                if (PostMainUIC.g(this.vRv).dAx().hasFocus() && this.vRy.getHeight() != PostMainUIC.g(this.vRv).vQU) {
                    PostMainUIC.g(this.vRv).vQU = this.vRy.getHeight();
                    PostMainUIC.l(this.vRv);
                }
                PostMainUIC.m(this.vRv).addOnLayoutChangeListener(this.vRv.vRt);
                AppMethodBeat.o(252977);
                return;
            }
            if (this.vRy.getVisibility() == 8 || this.vRy.getHeight() == 0) {
                PostMainUIC.g(this.vRv).vQU = 0;
                this.vRv.dAE().scrollTo(0, 0);
                ViewGroup.LayoutParams layoutParams = PostMainUIC.o(this.vRv).getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    AppMethodBeat.o(252977);
                    throw tVar;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.height = 0;
                layoutParams2.weight = 1.0f;
                PostMainUIC.o(this.vRv).setLayoutParams(layoutParams2);
                PostMainUIC.o(this.vRv).requestLayout();
                PostMainUIC.m(this.vRv).removeOnLayoutChangeListener(this.vRv.vRt);
            }
            AppMethodBeat.o(252977);
        }
    }

    private final PostEditUIC dAL() {
        AppMethodBeat.i(252996);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(getActivity()).get(PostEditUIC.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…(PostEditUIC::class.java)");
        PostEditUIC postEditUIC = (PostEditUIC) viewModel;
        AppMethodBeat.o(252996);
        return postEditUIC;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ PostMainUIC vRv;

        e(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        public final void run() {
            AppMethodBeat.i(252964);
            PostMainUIC.c(this.vRv);
            AppMethodBeat.o(252964);
        }
    }

    private final void dAM() {
        int i2;
        cjk cjk;
        String str;
        azk azk;
        AppMethodBeat.i(252997);
        com.tencent.mm.plugin.finder.widget.post.a aVar = this.vRf;
        com.tencent.mm.plugin.finder.widget.post.g dJh = aVar != null ? aVar.dJh() : null;
        if (dJh != null) {
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            cjk cjk2 = dJh.wDD;
            if (cjk2 == null || (str = cjk2.vMX) == null) {
                cjk cjk3 = dJh.wDD;
                if (cjk3 == null || (azk = cjk3.MoJ) == null) {
                    str = null;
                } else {
                    str = azk.wWb;
                }
            }
            if (str == null) {
                str = "";
            }
            com.tencent.mm.plugin.finder.report.i.auF(str);
            cjk cjk4 = dJh.wDD;
            if (cjk4 == null || cjk4.wCu || dJh.wDD.wCv) {
                cjk cjk5 = dJh.wDD;
                if (cjk5 == null || cjk5.wCu) {
                    cjk cjk6 = dJh.wDD;
                    if (cjk6 == null || cjk6.wCv) {
                        com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
                        com.tencent.mm.plugin.finder.report.i.Kp(0);
                    } else {
                        com.tencent.mm.plugin.finder.report.i iVar3 = com.tencent.mm.plugin.finder.report.i.vfo;
                        com.tencent.mm.plugin.finder.report.i.Kp(1);
                    }
                } else {
                    com.tencent.mm.plugin.finder.report.i iVar4 = com.tencent.mm.plugin.finder.report.i.vfo;
                    com.tencent.mm.plugin.finder.report.i.Kp(2);
                }
            } else {
                com.tencent.mm.plugin.finder.report.i iVar5 = com.tencent.mm.plugin.finder.report.i.vfo;
                com.tencent.mm.plugin.finder.report.i.Kp(3);
            }
        }
        com.tencent.mm.plugin.finder.report.i iVar6 = com.tencent.mm.plugin.finder.report.i.vfo;
        if (dJh == null || (cjk = dJh.wDD) == null) {
            i2 = 0;
        } else {
            i2 = cjk.soundTrackType;
        }
        com.tencent.mm.plugin.finder.report.i.Ko(i2);
        com.tencent.mm.plugin.finder.report.i iVar7 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.c(dAL().dAA().dHI().vTC, dAL().dAA().dHI().wsI, dAL().dAA().dHI().wsJ);
        com.tencent.mm.plugin.finder.widget.post.c cVar = this.vRq;
        if (cVar == null) {
            kotlin.g.b.p.btv("postDataManager");
        }
        Integer num = cVar.wCl;
        if (num == null || num.intValue() != 1 || !Util.isNullOrNil(dAL().dAx().getText().toString())) {
            com.tencent.mm.plugin.finder.widget.post.c cVar2 = this.vRq;
            if (cVar2 == null) {
                kotlin.g.b.p.btv("postDataManager");
            }
            if (cVar2.vTz == null) {
                com.tencent.mm.plugin.finder.widget.post.c cVar3 = this.vRq;
                if (cVar3 == null) {
                    kotlin.g.b.p.btv("postDataManager");
                }
                if (cVar3.wCr == null) {
                    String string = getString(R.string.db1);
                    com.tencent.mm.plugin.finder.widget.post.c cVar4 = this.vRq;
                    if (cVar4 == null) {
                        kotlin.g.b.p.btv("postDataManager");
                    }
                    if (cVar4.wCw > 0) {
                        string = getString(R.string.db2);
                    }
                    com.tencent.mm.ui.base.h.a((Context) getActivity(), string, "", getString(R.string.db4), getString(R.string.db3), true, (DialogInterface.OnClickListener) new h(this), (DialogInterface.OnClickListener) new i(this), (int) R.color.cc);
                    AppMethodBeat.o(252997);
                    return;
                }
            }
        }
        getActivity().finish();
        AppMethodBeat.o(252997);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class h implements DialogInterface.OnClickListener {
        final /* synthetic */ PostMainUIC vRv;

        h(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(252967);
            PostMainUIC.p(this.vRv);
            PostMainUIC.q(this.vRv);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.at(4, true);
            AppMethodBeat.o(252967);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class i implements DialogInterface.OnClickListener {
        final /* synthetic */ PostMainUIC vRv;

        i(PostMainUIC postMainUIC) {
            this.vRv = postMainUIC;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(252968);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.at(4, false);
            PostMainUIC.q(this.vRv);
            AppMethodBeat.o(252968);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:229:0x03ba */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:233:0x03ba */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        if (r0 == null) goto L_0x00a0;
     */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r13, int r14, android.content.Intent r15) {
        /*
        // Method dump skipped, instructions count: 1106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.post.PostMainUIC.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void dAN() {
        String str;
        boolean z;
        LinkedList<cjl> linkedList;
        cjl cjl;
        azk azk;
        AppMethodBeat.i(252999);
        com.tencent.mm.plugin.finder.widget.post.a aVar = this.vRf;
        com.tencent.mm.plugin.finder.widget.post.g dJh = aVar != null ? aVar.dJh() : null;
        if (dJh != null) {
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            cjk cjk = dJh.wDD;
            if (cjk == null || (str = cjk.vMX) == null) {
                cjk cjk2 = dJh.wDD;
                if (cjk2 == null || (azk = cjk2.MoJ) == null) {
                    str = null;
                } else {
                    str = azk.wWb;
                }
            }
            if (str == null) {
                str = "";
            }
            com.tencent.mm.plugin.finder.report.i.auF(str);
            cjk cjk3 = dJh.wDD;
            if (cjk3 == null || cjk3.wCu || dJh.wDD.wCv) {
                cjk cjk4 = dJh.wDD;
                if (cjk4 == null || cjk4.wCu) {
                    cjk cjk5 = dJh.wDD;
                    if (cjk5 == null || cjk5.wCv) {
                        com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
                        com.tencent.mm.plugin.finder.report.i.Kp(0);
                    } else {
                        com.tencent.mm.plugin.finder.report.i iVar3 = com.tencent.mm.plugin.finder.report.i.vfo;
                        com.tencent.mm.plugin.finder.report.i.Kp(1);
                    }
                } else {
                    com.tencent.mm.plugin.finder.report.i iVar4 = com.tencent.mm.plugin.finder.report.i.vfo;
                    com.tencent.mm.plugin.finder.report.i.Kp(2);
                }
            } else {
                com.tencent.mm.plugin.finder.report.i iVar5 = com.tencent.mm.plugin.finder.report.i.vfo;
                com.tencent.mm.plugin.finder.report.i.Kp(3);
            }
            cjk cjk6 = dJh.wDD;
            if (!(cjk6 == null || (linkedList = cjk6.mediaList) == null || (cjl = (cjl) kotlin.a.j.L(linkedList, 0)) == null)) {
                cjl.mediaId = UUID.randomUUID().toString();
            }
            com.tencent.mm.plugin.finder.widget.post.c cVar = this.vRq;
            if (cVar == null) {
                kotlin.g.b.p.btv("postDataManager");
            }
            Bundle bundle = cVar.vUI;
            com.tencent.mm.plugin.finder.upload.postui.e eVar = this.vRi;
            if (eVar == null) {
                kotlin.g.b.p.btv("newsWidget");
            }
            bundle.putBoolean("isNews", eVar.isChecked());
            com.tencent.mm.plugin.finder.widget.post.c cVar2 = this.vRq;
            if (cVar2 == null) {
                kotlin.g.b.p.btv("postDataManager");
            }
            String obj = dAL().dAx().getText().toString();
            if (obj == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(252999);
                throw tVar;
            }
            FinderItem a2 = cVar2.a(kotlin.n.n.aM(obj).toString(), dJh, dAL().dAA().dHI().dHz());
            a2.setPreview(true);
            c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            BaseFinderFeed s2 = c.a.s(a2);
            Intent intent = new Intent();
            intent.putExtra("KEY_FROM_SCENE", 1);
            intent.putExtra("KEY_USERNAME", z.aUg());
            intent.putExtra("KEY_FINDER_SELF_FLAG", true);
            OccupyFinderUI10.a aVar3 = OccupyFinderUI10.udX;
            intent.putExtra(OccupyFinderUI10.udV, true);
            OccupyFinderUI10.a aVar4 = OccupyFinderUI10.udX;
            String str2 = OccupyFinderUI10.udW;
            y yVar = y.vXH;
            if (!y.isDisablePostHalfScreen()) {
                z = true;
            } else {
                z = false;
            }
            intent.putExtra(str2, z);
            y yVar2 = y.vXH;
            y.a(0, kotlin.a.j.listOf(s2), (com.tencent.mm.bw.b) null, intent);
            com.tencent.mm.plugin.finder.utils.a aVar5 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.ac(getContext(), intent);
        }
        AppMethodBeat.o(252999);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(252965);
            View findViewById = this.uQi.findViewById(R.id.gfj);
            AppMethodBeat.o(252965);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(252961);
            View findViewById = this.uQi.findViewById(R.id.gf1);
            AppMethodBeat.o(252961);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(252962);
            View findViewById = this.uQi.findViewById(R.id.d0y);
            AppMethodBeat.o(252962);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(252979);
            View findViewById = this.uQi.findViewById(R.id.d16);
            AppMethodBeat.o(252979);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(252969);
            View findViewById = this.uQi.findViewById(R.id.d17);
            AppMethodBeat.o(252969);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ PostMainUIC vRv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(PostMainUIC postMainUIC) {
            super(0);
            this.vRv = postMainUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(252978);
            PostLocationUIC j2 = PostMainUIC.j(this.vRv);
            if (!j2.getIntent().getBooleanExtra("saveLocation", false)) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
                if (FinderGlobalLocationVM.dHO()) {
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
                    kotlin.o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
                    chk chk = new chk();
                    chk.LbC = dHP.first.floatValue();
                    chk.LbD = dHP.second.floatValue();
                    chk.LuW = 0;
                    chk.LuT = 1;
                    ((com.tencent.mm.pluginsdk.location.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.location.a.class)).a(chk, j2);
                    com.tencent.mm.ac.d.h(new PostLocationUIC.a(j2));
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252978);
            return xVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:92:0x02ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void c(com.tencent.mm.plugin.finder.ui.post.PostMainUIC r11) {
        /*
        // Method dump skipped, instructions count: 846
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.post.PostMainUIC.c(com.tencent.mm.plugin.finder.ui.post.PostMainUIC):void");
    }

    public static final /* synthetic */ void f(PostMainUIC postMainUIC) {
        String str;
        AppMethodBeat.i(253005);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) postMainUIC.getContext(), 1, true);
        View inflate = aa.jQ(postMainUIC.getContext()).inflate(R.layout.aia, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.d0z);
        kotlin.g.b.p.g(findViewById, "titleView.findViewById<T…nder_post_del_header_txt)");
        TextView textView = (TextView) findViewById;
        com.tencent.mm.plugin.finder.widget.post.c cVar = postMainUIC.vRq;
        if (cVar == null) {
            kotlin.g.b.p.btv("postDataManager");
        }
        Integer num = cVar.wCl;
        if (num == null || num.intValue() != 2) {
            com.tencent.mm.plugin.finder.widget.post.c cVar2 = postMainUIC.vRq;
            if (cVar2 == null) {
                kotlin.g.b.p.btv("postDataManager");
            }
            Integer num2 = cVar2.wCl;
            if (num2 != null && num2.intValue() == 4) {
                str = postMainUIC.getContext().getResources().getString(R.string.d5e);
                textView.setText(str);
                eVar.setTitleView(inflate);
                eVar.a(new u(postMainUIC));
                eVar.a(new v(postMainUIC));
                eVar.b(new w(postMainUIC));
                eVar.dGm();
                AppMethodBeat.o(253005);
            }
        }
        str = postMainUIC.getContext().getResources().getString(R.string.d5d);
        textView.setText(str);
        eVar.setTitleView(inflate);
        eVar.a(new u(postMainUIC));
        eVar.a(new v(postMainUIC));
        eVar.b(new w(postMainUIC));
        eVar.dGm();
        AppMethodBeat.o(253005);
    }

    public static final /* synthetic */ void h(PostMainUIC postMainUIC) {
        AppMethodBeat.i(253007);
        View dAG = postMainUIC.dAG();
        kotlin.g.b.p.g(dAG, "addMediaBtn");
        ViewGroup.LayoutParams layoutParams = dAG.getLayoutParams();
        ViewGroup viewGroup = postMainUIC.vRc;
        if (viewGroup == null) {
            kotlin.g.b.p.btv("mediaViewContainer");
        }
        layoutParams.width = viewGroup.getWidth();
        View dAG2 = postMainUIC.dAG();
        kotlin.g.b.p.g(dAG2, "addMediaBtn");
        ViewGroup.LayoutParams layoutParams2 = dAG2.getLayoutParams();
        ViewGroup viewGroup2 = postMainUIC.vRc;
        if (viewGroup2 == null) {
            kotlin.g.b.p.btv("mediaViewContainer");
        }
        layoutParams2.height = viewGroup2.getHeight();
        ViewGroup viewGroup3 = postMainUIC.vRc;
        if (viewGroup3 == null) {
            kotlin.g.b.p.btv("mediaViewContainer");
        }
        viewGroup3.removeAllViews();
        com.tencent.mm.plugin.finder.widget.post.a aVar = postMainUIC.vRf;
        if (aVar != null) {
            aVar.dIX();
        }
        com.tencent.mm.plugin.finder.widget.post.c cVar = postMainUIC.vRq;
        if (cVar == null) {
            kotlin.g.b.p.btv("postDataManager");
        }
        cVar.wCl = -1;
        com.tencent.mm.plugin.finder.widget.post.c cVar2 = postMainUIC.vRq;
        if (cVar2 == null) {
            kotlin.g.b.p.btv("postDataManager");
        }
        cVar2.intent.removeExtra("postType");
        cVar2.intent.removeExtra("postMediaList");
        cVar2.intent.removeExtra("key_post_media_quality_list");
        cVar2.intent.removeExtra("video_composition");
        cVar2.intent.removeExtra("postTypeList");
        cVar2.intent.removeExtra("postRefMediaList");
        cVar2.intent.removeExtra("postRefFeedInfo");
        cVar2.intent.removeExtra("KEY_POST_FROM_CAMERA");
        cVar2.intent.removeExtra("postVideoCropList");
        cVar2.intent.removeExtra("postThumbList");
        cVar2.intent.removeExtra("KEY_POST_VLOG_CROP_RECT");
        cVar2.intent.removeExtra("MEDIA_EXTRA_MUSIC");
        cVar2.intent.removeExtra("ORIGIN_MUSIC_ID");
        cVar2.intent.removeExtra("ORIGIN_MUSIC_INFO");
        cVar2.intent.removeExtra("ORIGIN_MUSIC_PATH");
        cVar2.intent.removeExtra("ORIGIN_BGM_URL");
        cVar2.intent.removeExtra("MEDIA_IS_MUTE");
        cVar2.intent.removeExtra("MUSIC_IS_MUTE");
        cVar2.intent.removeExtra("SOUND_TRACK_TYPE");
        cVar2.intent.removeExtra("isLongVideoPost");
        cVar2.intent.removeExtra("KEY_POST_HALF_IMAGE_LIST");
        cVar2.intent.removeExtra("KEY_POST_HALF_RECT_LIST");
        cVar2.intent.removeExtra("VIDEO_COVER_URL");
        cVar2.intent.removeExtra("VIDEO_COVER_QUALITY");
        postMainUIC.getIntent().removeExtra("postType");
        postMainUIC.dAJ();
        View dAG3 = postMainUIC.dAG();
        kotlin.g.b.p.g(dAG3, "addMediaBtn");
        dAG3.setVisibility(0);
        View dAF = postMainUIC.dAF();
        kotlin.g.b.p.g(dAF, "delMediaBtn");
        dAF.setVisibility(8);
        AppMethodBeat.o(253007);
    }

    public static final /* synthetic */ void i(PostMainUIC postMainUIC) {
        int i2;
        int i3;
        long j2;
        long j3;
        AppMethodBeat.i(253008);
        com.tencent.mm.plugin.finder.widget.post.c cVar = postMainUIC.vRq;
        if (cVar == null) {
            kotlin.g.b.p.btv("postDataManager");
        }
        Integer num = cVar.wCl;
        if (num == null || num.intValue() != 2) {
            com.tencent.mm.plugin.finder.widget.post.c cVar2 = postMainUIC.vRq;
            if (cVar2 == null) {
                kotlin.g.b.p.btv("postDataManager");
            }
            Integer num2 = cVar2.wCl;
            if (num2 == null) {
                AppMethodBeat.o(253008);
                return;
            } else if (num2.intValue() == 4 && (postMainUIC.vRf instanceof com.tencent.mm.plugin.finder.widget.post.f)) {
                com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                com.tencent.mm.plugin.finder.widget.post.c cVar3 = postMainUIC.vRq;
                if (cVar3 == null) {
                    kotlin.g.b.p.btv("postDataManager");
                }
                Integer num3 = cVar3.wCl;
                int intValue = num3 != null ? num3.intValue() : -1;
                com.tencent.mm.plugin.finder.widget.post.a aVar = postMainUIC.vRf;
                if (aVar == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.post.PostVideoWidget");
                    AppMethodBeat.o(253008);
                    throw tVar;
                }
                com.tencent.mm.plugin.finder.widget.post.f fVar = (com.tencent.mm.plugin.finder.widget.post.f) aVar;
                acn acn = fVar.wDk;
                if (acn != null) {
                    j2 = acn.Lnf;
                } else {
                    j2 = 0;
                }
                acn acn2 = fVar.wDk;
                if (acn2 != null) {
                    j3 = acn2.Lne;
                } else {
                    j3 = 0;
                }
                com.tencent.mm.plugin.finder.report.i.j(intValue, 0, kotlin.k.j.aM(j2 - j3, 0));
            }
        } else if (postMainUIC.vRf instanceof com.tencent.mm.plugin.finder.widget.post.d) {
            com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.widget.post.c cVar4 = postMainUIC.vRq;
            if (cVar4 == null) {
                kotlin.g.b.p.btv("postDataManager");
            }
            Integer num4 = cVar4.wCl;
            if (num4 != null) {
                i2 = num4.intValue();
            } else {
                i2 = -1;
            }
            com.tencent.mm.plugin.finder.widget.post.a aVar2 = postMainUIC.vRf;
            if (aVar2 == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.post.PostImageWidget");
                AppMethodBeat.o(253008);
                throw tVar2;
            }
            ArrayList<String> arrayList = ((com.tencent.mm.plugin.finder.widget.post.d) aVar2).wCB;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            com.tencent.mm.plugin.finder.report.i.j(i2, (long) i3, 0);
            AppMethodBeat.o(253008);
            return;
        }
        AppMethodBeat.o(253008);
    }

    public static final /* synthetic */ void l(PostMainUIC postMainUIC) {
        AppMethodBeat.i(253010);
        Point point = new Point();
        WindowManager windowManager = postMainUIC.getActivity().getWindowManager();
        kotlin.g.b.p.g(windowManager, "activity.windowManager");
        windowManager.getDefaultDisplay().getSize(point);
        int[] iArr = new int[2];
        View view = postMainUIC.vMo;
        if (view == null) {
            kotlin.g.b.p.btv("edtContainer");
        }
        view.getLocationInWindow(iArr);
        View dAz = postMainUIC.dAL().dAz();
        int height = (point.y - dAz.getHeight()) - postMainUIC.getResources().getDimensionPixelSize(R.dimen.cb);
        int i2 = iArr[1];
        View view2 = postMainUIC.vMo;
        if (view2 == null) {
            kotlin.g.b.p.btv("edtContainer");
        }
        int height2 = i2 + view2.getHeight();
        Log.i(postMainUIC.TAG, "window.y " + point.y + " footer.height " + dAz.getHeight() + " bottom " + height2 + ", maxBottom " + height + ' ');
        View view3 = postMainUIC.vRd;
        if (view3 == null) {
            kotlin.g.b.p.btv("bottomSpace");
        }
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(253010);
            throw tVar;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        String str = postMainUIC.TAG;
        StringBuilder sb = new StringBuilder("bottom height ");
        View view4 = postMainUIC.vRd;
        if (view4 == null) {
            kotlin.g.b.p.btv("bottomSpace");
        }
        Log.i(str, sb.append(view4.getHeight()).toString());
        View view5 = postMainUIC.vRd;
        if (view5 == null) {
            kotlin.g.b.p.btv("bottomSpace");
        }
        layoutParams2.height = view5.getHeight() + (height2 - height);
        View view6 = postMainUIC.vRd;
        if (view6 == null) {
            kotlin.g.b.p.btv("bottomSpace");
        }
        view6.setLayoutParams(layoutParams2);
        View view7 = postMainUIC.vRd;
        if (view7 == null) {
            kotlin.g.b.p.btv("bottomSpace");
        }
        view7.requestLayout();
        View view8 = postMainUIC.vRd;
        if (view8 == null) {
            kotlin.g.b.p.btv("bottomSpace");
        }
        view8.post(new d(postMainUIC, height2, height));
        AppMethodBeat.o(253010);
    }

    public static final /* synthetic */ void p(PostMainUIC postMainUIC) {
        AppMethodBeat.i(253013);
        com.tencent.mm.plugin.finder.widget.post.a aVar = postMainUIC.vRf;
        com.tencent.mm.plugin.finder.widget.post.g dJh = aVar != null ? aVar.dJh() : null;
        if (dJh != null) {
            com.tencent.mm.plugin.finder.widget.post.c cVar = postMainUIC.vRq;
            if (cVar == null) {
                kotlin.g.b.p.btv("postDataManager");
            }
            String obj = postMainUIC.dAL().dAx().getText().toString();
            if (obj == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(253013);
                throw tVar;
            }
            FinderItem a2 = cVar.a(kotlin.n.n.aM(obj).toString(), dJh, postMainUIC.dAL().dAA().dHI().dHz());
            g.a aVar2 = com.tencent.mm.plugin.finder.storage.g.vDm;
            com.tencent.mm.plugin.finder.storage.g j2 = g.a.j(a2);
            Parcel obtain = Parcel.obtain();
            kotlin.g.b.p.g(obtain, "Parcel.obtain()");
            postMainUIC.dAL().dAC();
            postMainUIC.getIntent().writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            j2.field_localId = postMainUIC.getIntent().getLongExtra("KEY_FINDER_POST_DRAFT_LOCAL_ID", 0);
            j2.field_postIntent = com.tencent.e.f.e.bytesToHexString(marshall);
            j2.field_createTime = cl.aWB();
            j2.field_localFlag = 1;
            j2.field_objectType = 0;
            com.tencent.mm.plugin.finder.storage.h hVar = com.tencent.mm.plugin.finder.storage.h.vDp;
            kotlin.g.b.p.h(j2, "draftItem");
            if (j2.field_localId > 0) {
                com.tencent.mm.plugin.finder.storage.h.Fx(j2.field_localId);
            }
            com.tencent.mm.plugin.finder.storage.h.aj(com.tencent.mm.plugin.finder.storage.h.vDn, ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getDraftStorage().b(j2));
            AppMethodBeat.o(253013);
            return;
        }
        AppMethodBeat.o(253013);
    }

    public static final /* synthetic */ void q(PostMainUIC postMainUIC) {
        AppMethodBeat.i(253014);
        int intExtra = postMainUIC.getIntent().getIntExtra("key_finder_post_from", -1);
        if (!(intExtra == -1 || intExtra == 6)) {
            Intent intent = new Intent();
            intent.putExtra("key_finder_post_router", intExtra);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(postMainUIC.getActivity(), intent);
            postMainUIC.getActivity().overridePendingTransition(0, MMFragmentActivity.a.ogp);
        }
        postMainUIC.getActivity().finish();
        AppMethodBeat.o(253014);
    }
}
