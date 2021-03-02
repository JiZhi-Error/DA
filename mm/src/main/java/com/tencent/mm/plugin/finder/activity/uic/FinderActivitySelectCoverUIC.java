package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 L2\u00020\u0001:\u0001LB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010&\u001a\u00020'H\u0002J\u0006\u0010(\u001a\u00020'J\u001e\u0010)\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0018\u00010*2\u0006\u0010-\u001a\u00020!H\u0002J\u0006\u0010.\u001a\u00020'J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020!H\u0002J\"\u00101\u001a\u00020'2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020'H\u0002J\b\u00108\u001a\u00020'H\u0002J\u0012\u00109\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010<\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010!H\u0002J\b\u0010?\u001a\u00020\u0018H\u0002J\b\u0010@\u001a\u00020'H\u0002J\b\u0010A\u001a\u00020'H\u0002J\u0010\u0010B\u001a\u00020'2\b\u0010C\u001a\u0004\u0018\u00010!J\b\u0010D\u001a\u00020'H\u0002J\u0006\u0010E\u001a\u00020'J(\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u0002062\u0006\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020!H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "addCoverBtn", "Landroid/view/View;", "addCoverContainer", "addCoverIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "addCoverImage", "addCoverText", "Landroid/widget/TextView;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "changeCoverBtn", "Landroid/widget/Button;", "coverImageView", "Landroid/widget/ImageView;", "coverManagerContainer", "coverMaskContainer", "coverMaskImageView", "deleteCoverBtn", "isCoverChangedByUser", "", "()Z", "setCoverChangedByUser", "(Z)V", "isCoverSet", "setCoverSet", "progressBar", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "thumbLocalPath", "", "getThumbLocalPath", "()Ljava/lang/String;", "setThumbLocalPath", "(Ljava/lang/String;)V", "addCover", "", "dismissProgress", "getDefaultContent", "Lkotlin/Pair;", "Landroid/graphics/Rect;", "", "input", "initView", "modifyCover", "imgPath", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCoverSet", "onCoverUnset", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCropImageSuccess", "imagePath", "selectCoverFromAlbum", "selectCoverFromOrigin", "selectCoverFromOriginOld", "setCover", "coverUrl", "setCoverMaskMargin", "showProgress", "startCropImgForResult", "context", "Landroid/app/Activity;", "intent", "filePath", "resultFileName", "Companion", "plugin-finder_release"})
public final class FinderActivitySelectCoverUIC extends UIComponent {
    public static final a trR = new a((byte) 0);
    private View UHw;
    private View UHx;
    private ImageView cxe;
    private ImageView tqR;
    boolean trA;
    private q trF;
    private WeImageView trG;
    private View trI;
    private View trJ;
    private TextView trK;
    private View trL;
    private WeImageView trO;
    String trP = "";
    boolean trQ;

    static {
        AppMethodBeat.i(242138);
        AppMethodBeat.o(242138);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class i<T, R> implements com.tencent.mm.loader.f.e<o, Bitmap> {
        final /* synthetic */ FinderActivitySelectCoverUIC trS;
        final /* synthetic */ String tra;

        i(FinderActivitySelectCoverUIC finderActivitySelectCoverUIC, String str) {
            this.trS = finderActivitySelectCoverUIC;
            this.tra = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(242124);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                d.h(new a(this));
                Log.i("SimpleUIComponent", "[handleActivityProfileCover] [" + bitmap2.getWidth() + ':' + bitmap2.getHeight() + "] allocationByteCount=" + Util.getSizeKB((long) bitmap2.getAllocationByteCount()) + " coverUrl=" + this.tra);
                AppMethodBeat.o(242124);
                return;
            }
            AppMethodBeat.o(242124);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$setCover$1$1$1"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ i trU;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(i iVar) {
                super(0);
                this.trU = iVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(242123);
                this.trU.trS.cXy();
                ImageView a2 = FinderActivitySelectCoverUIC.a(this.trU.trS);
                if (a2 != null) {
                    a2.setVisibility(0);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(242123);
                return xVar;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActivitySelectCoverUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(260121);
        AppMethodBeat.o(260121);
    }

    public static final /* synthetic */ ImageView a(FinderActivitySelectCoverUIC finderActivitySelectCoverUIC) {
        AppMethodBeat.i(242139);
        ImageView imageView = finderActivitySelectCoverUIC.cxe;
        if (imageView == null) {
            p.btv("coverImageView");
        }
        AppMethodBeat.o(242139);
        return imageView;
    }

    public static final /* synthetic */ void d(FinderActivitySelectCoverUIC finderActivitySelectCoverUIC) {
        AppMethodBeat.i(242142);
        finderActivitySelectCoverUIC.cXA();
        AppMethodBeat.o(242142);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$Companion;", "", "()V", "MENU_ID_SET_BG", "", "RATIO", "", "REQUEST_CODE_CROP_FIX_IMAGE", "REQUEST_CODE_IMAGE_BOUND_SEND_SURE", "SELECT_FROM_GALLERY", "SELECT_FROM_VIDEO", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void asC(String str) {
        AppMethodBeat.i(242125);
        p.h(str, "<set-?>");
        this.trP = str;
        AppMethodBeat.o(242125);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        View view;
        FinderActivitySelectCoverUIC finderActivitySelectCoverUIC;
        AppMethodBeat.i(242126);
        super.onCreateAfter(bundle);
        View findViewById = getActivity().findViewById(R.id.ew);
        p.g(findViewById, "activity.findViewById(R.id.activity_post_cover)");
        this.cxe = (ImageView) findViewById;
        View findViewById2 = getActivity().findViewById(R.id.cjp);
        p.g(findViewById2, "activity.findViewById(R.…vity_post_add_cover_icon)");
        this.trO = (WeImageView) findViewById2;
        View findViewById3 = getActivity().findViewById(R.id.ex);
        p.g(findViewById3, "activity.findViewById(R.…activity_post_cover_mask)");
        this.tqR = (ImageView) findViewById3;
        View findViewById4 = getActivity().findViewById(R.id.jt1);
        p.g(findViewById4, "activity.findViewById(R.…ity_post_cover_container)");
        this.UHx = findViewById4;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(242126);
            throw tVar;
        }
        WindowManager windowManager = activity.getWindowManager();
        p.g(windowManager, "(activity as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        float f2 = ((float) displayMetrics.widthPixels) / 0.75f;
        ImageView imageView = this.tqR;
        if (imageView == null) {
            p.btv("coverMaskImageView");
        }
        ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
        if (layoutParams == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.o(242126);
            throw tVar2;
        }
        layoutParams.height = (int) f2;
        ImageView imageView2 = this.tqR;
        if (imageView2 == null) {
            p.btv("coverMaskImageView");
        }
        if (imageView2 != null) {
            imageView2.setLayoutParams(layoutParams);
        }
        this.trJ = getActivity().findViewById(R.id.cjo);
        this.trK = (TextView) getActivity().findViewById(R.id.cjq);
        this.trF = q.b(getActivity(), getString(R.string.a06), false, 0, null);
        this.trI = getActivity().findViewById(R.id.cj7);
        WeImageView weImageView = this.trG;
        if (weImageView != null) {
            weImageView.setOnClickListener(new g(this));
        }
        View findViewById5 = getActivity().findViewById(R.id.cja);
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(new e(this));
            view = findViewById5;
            finderActivitySelectCoverUIC = this;
        } else {
            view = null;
            finderActivitySelectCoverUIC = this;
        }
        finderActivitySelectCoverUIC.UHw = view;
        String stringExtra = getIntent().getStringExtra("key_activity_local_cover_url");
        if (!Util.isNullOrNil(stringExtra)) {
            setCover(stringExtra);
            cXz();
        } else {
            cXA();
        }
        View view2 = this.trJ;
        if (view2 != null) {
            view2.setOnClickListener(new b(this));
            AppMethodBeat.o(242126);
            return;
        }
        AppMethodBeat.o(242126);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(242127);
        super.onCreate(bundle);
        AppMethodBeat.o(242127);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        String str = null;
        AppMethodBeat.i(242128);
        super.onActivityResult(i2, i3, intent);
        if (intent == null || i3 != -1) {
            AppMethodBeat.o(242128);
            return;
        }
        switch (i2) {
            case com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT:
                Uri data = intent.getData();
                if (data != null) {
                    str = data.getPath();
                }
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    Log.w("SimpleUIComponent", "filePath is null.try to getResultPhotoPath.");
                    al alVar = al.waC;
                    str = s.h(getActivity(), intent, al.dEA());
                }
                Log.i("SimpleUIComponent", "filePath[" + str + "] " + intent);
                String str3 = str;
                if (str3 == null || str3.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Log.e("SimpleUIComponent", "filePath is null.");
                    AppMethodBeat.o(242128);
                    return;
                }
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.f(getActivity(), str, "");
                AppMethodBeat.o(242128);
                return;
            case 20001:
                Log.d("SimpleUIComponent", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
                asD(intent.getStringExtra("key_result_img_path"));
                AppMethodBeat.o(242128);
                return;
            case 20002:
                CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel) intent.getParcelableExtra("KSEGMENTMEDIAINFO");
                StringBuilder sb = new StringBuilder("REQUEST_CODE_CROP_FIX_IMAGE model: ");
                if (captureVideoNormalModel != null) {
                    str = captureVideoNormalModel.aQn();
                }
                Log.i("SimpleUIComponent", sb.append(str).toString());
                if (captureVideoNormalModel != null) {
                    Boolean eJI = captureVideoNormalModel.eJI();
                    p.g(eJI, "photo");
                    if (!eJI.booleanValue() || Util.isNullOrNil(captureVideoNormalModel.aQn())) {
                        u.makeText(getActivity(), (int) R.string.cgo, 0).show();
                        AppMethodBeat.o(242128);
                        return;
                    }
                    asD(captureVideoNormalModel.aQn());
                    AppMethodBeat.o(242128);
                    return;
                }
                break;
        }
        AppMethodBeat.o(242128);
    }

    private final void asD(String str) {
        String str2;
        AppMethodBeat.i(242129);
        if (Util.isNullOrNil(str) || !com.tencent.mm.vfs.s.YS(str)) {
            u.makeText(getActivity(), (int) R.string.cgo, 0).show();
            Log.e("SimpleUIComponent", "ERROR! filePath=".concat(String.valueOf(str)));
            AppMethodBeat.o(242129);
            return;
        }
        Log.d("SimpleUIComponent", "onCropImageSuccess ".concat(String.valueOf(str)));
        showProgress();
        this.trQ = true;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        this.trP = str2;
        setCover(str);
        cXz();
        AppMethodBeat.o(242129);
    }

    public final void showProgress() {
        AppMethodBeat.i(242130);
        q qVar = this.trF;
        if (qVar != null) {
            if (!qVar.isShowing()) {
                qVar.show();
            }
            AppMethodBeat.o(242130);
            return;
        }
        AppMethodBeat.o(242130);
    }

    public final void cXy() {
        AppMethodBeat.i(242131);
        q qVar = this.trF;
        if (qVar != null) {
            if (qVar.isShowing()) {
                qVar.dismiss();
            }
            AppMethodBeat.o(242131);
            return;
        }
        AppMethodBeat.o(242131);
    }

    public final void setCover(String str) {
        String str2;
        AppMethodBeat.i(242133);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        com.tencent.mm.plugin.finder.loader.g gVar = new com.tencent.mm.plugin.finder.loader.g(str2);
        m mVar = m.uJa;
        com.tencent.mm.loader.a.b<o, Bitmap> bQ = m.djY().bQ(gVar);
        m mVar2 = m.uJa;
        com.tencent.mm.loader.b<o, Bitmap> a2 = bQ.a(m.a(m.a.PROFILE_COVER)).a(new i(this, str));
        ImageView imageView = this.cxe;
        if (imageView == null) {
            p.btv("coverImageView");
        }
        a2.c(imageView);
        AppMethodBeat.o(242133);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ FinderActivitySelectCoverUIC trS;

        g(FinderActivitySelectCoverUIC finderActivitySelectCoverUIC) {
            this.trS = finderActivitySelectCoverUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242121);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderActivitySelectCoverUIC.b(this.trS);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242121);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$2$1"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ FinderActivitySelectCoverUIC trS;

        e(FinderActivitySelectCoverUIC finderActivitySelectCoverUIC) {
            this.trS = finderActivitySelectCoverUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242119);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.trS.asC("");
            this.trS.trQ = true;
            this.trS.setCover("");
            FinderActivitySelectCoverUIC.d(this.trS);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242119);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ FinderActivitySelectCoverUIC trS;

        b(FinderActivitySelectCoverUIC finderActivitySelectCoverUIC) {
            this.trS = finderActivitySelectCoverUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260120);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.trS.trA) {
                this.trS.asC("");
                this.trS.trQ = true;
                this.trS.setCover("");
                FinderActivitySelectCoverUIC.d(this.trS);
            } else {
                FinderActivitySelectCoverUIC.b(this.trS);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260120);
        }
    }

    private final void cXz() {
        AppMethodBeat.i(242135);
        this.trA = true;
        View view = this.trL;
        if (view != null) {
            view.setVisibility(0);
        }
        int color = getResources().getColor(R.color.pe);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(242135);
            throw tVar;
        }
        ((MMActivity) activity).getController().updataStatusBarIcon(true);
        ImageView imageView = this.cxe;
        if (imageView == null) {
            p.btv("coverImageView");
        }
        imageView.setVisibility(0);
        ImageView imageView2 = this.tqR;
        if (imageView2 == null) {
            p.btv("coverMaskImageView");
        }
        imageView2.setVisibility(0);
        View view2 = this.UHx;
        if (view2 == null) {
            p.btv("coverMaskContainer");
        }
        view2.setVisibility(0);
        TextView textView = this.trK;
        if (textView != null) {
            textView.setText(getResources().getString(R.string.cgq));
        }
        TextView textView2 = this.trK;
        if (textView2 != null) {
            textView2.setTextColor(color);
        }
        WeImageView weImageView = this.trO;
        if (weImageView == null) {
            p.btv("addCoverIcon");
        }
        weImageView.setIconColor(color);
        WeImageView weImageView2 = this.trO;
        if (weImageView2 == null) {
            p.btv("addCoverIcon");
        }
        weImageView2.setImageResource(R.raw.icons_filled_delete);
        View view3 = this.trJ;
        if (view3 != null) {
            view3.setBackgroundResource(R.drawable.x0);
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderActivityPostUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderActivityPostUIC.class)).cXx();
        AppMethodBeat.o(242135);
    }

    private final void cXA() {
        AppMethodBeat.i(242136);
        this.trA = false;
        View view = this.trL;
        if (view != null) {
            view.setVisibility(8);
        }
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(242136);
            throw tVar;
        }
        ((MMActivity) activity).getController().updataStatusBarIcon(ao.isDarkMode());
        ImageView imageView = this.cxe;
        if (imageView == null) {
            p.btv("coverImageView");
        }
        imageView.setVisibility(8);
        ImageView imageView2 = this.tqR;
        if (imageView2 == null) {
            p.btv("coverMaskImageView");
        }
        imageView2.setVisibility(8);
        View view2 = this.UHx;
        if (view2 == null) {
            p.btv("coverMaskContainer");
        }
        view2.setVisibility(8);
        int color = getResources().getColor(R.color.FG_0);
        TextView textView = this.trK;
        if (textView != null) {
            textView.setTextColor(color);
        }
        WeImageView weImageView = this.trO;
        if (weImageView == null) {
            p.btv("addCoverIcon");
        }
        weImageView.setIconColor(color);
        WeImageView weImageView2 = this.trO;
        if (weImageView2 == null) {
            p.btv("addCoverIcon");
        }
        weImageView2.setImageResource(R.raw.icon_filled_add);
        View view3 = this.trJ;
        if (view3 != null) {
            view3.setBackgroundResource(R.drawable.wz);
        }
        TextView textView2 = this.trK;
        if (textView2 != null) {
            textView2.setText(getResources().getString(R.string.cgk));
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderActivityPostUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderActivityPostUIC.class)).cXo();
        AppMethodBeat.o(242136);
    }

    public static final /* synthetic */ void b(FinderActivitySelectCoverUIC finderActivitySelectCoverUIC) {
        AppMethodBeat.i(242140);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (!aAh.isSDCardAvailable()) {
            u.kf(finderActivitySelectCoverUIC.getActivity());
            AppMethodBeat.o(242140);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("album_min_ratio_limit", 0.33333334f);
        intent.putExtra("album_max_ratio_limit", 3.0f);
        s.c(finderActivitySelectCoverUIC.getActivity(), com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT, intent);
        AppMethodBeat.o(242140);
    }
}
