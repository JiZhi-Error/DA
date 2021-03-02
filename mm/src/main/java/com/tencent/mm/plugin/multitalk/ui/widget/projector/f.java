package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.e;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.o;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.ScreenThumbLayoutManager;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.h;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020.H\u0016J\b\u00101\u001a\u00020.H\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u0006H\u0016J\b\u00105\u001a\u00020.H\u0016J\u000e\u00106\u001a\u00020.2\u0006\u00107\u001a\u000208J\u001a\u00109\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010:\u001a\u00020\u0006H\u0016J\b\u0010;\u001a\u00020.H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\u0010\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020\u001eH\u0016J\u001a\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u000108H\u0016R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\b\u0010\tR(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0011@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0011@BX\u000e¢\u0006\b\n\u0000\"\u0004\b \u0010\u0014R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "mCurrentIndex", "setMCurrentIndex", "(I)V", "Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "mCurrentViewStatus", "getMCurrentViewStatus", "()Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "setMCurrentViewStatus", "(Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;)V", "mFileExt", "", "mFilePath", "setMFilePath", "(Ljava/lang/String;)V", "mMaxCount", "setMMaxCount", "mReaderLayout", "Landroid/widget/RelativeLayout;", "getMReaderLayout", "()Landroid/widget/RelativeLayout;", "setMReaderLayout", "(Landroid/widget/RelativeLayout;)V", "mThumbnailHasBeenRequest", "", "mToken", "setMToken", "thumbUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "getThumbUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;", "setThumbUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI;)V", "thumbnailRoot", "Landroid/widget/FrameLayout;", "getThumbnailRoot", "()Landroid/widget/FrameLayout;", "setThumbnailRoot", "(Landroid/widget/FrameLayout;)V", "applyReaderUI", "", "applyThumbnailUI", "closeReaderRenderer", "dismissProjectScreen", "getBackgroundView", "Landroid/view/View;", "getLayoutId", "initView", "inputFileInfo", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "inputScreenProjectInfo", "pageIndex", "refreshView", "responeScreenClick", "showReaderContent", "show", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "Companion", "plugin-multitalk_release"})
public final class f extends l {
    public static final a zWn = new a((byte) 0);
    private String mFilePath;
    private int mMaxCount = -1;
    private String mToken;
    private String nhr;
    private int rmJ = -1;
    private h.b zVM;
    private FrameLayout zWj;
    private RelativeLayout zWk;
    private o zWl;
    private boolean zWm;

    static {
        AppMethodBeat.i(239962);
        AppMethodBeat.o(239962);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "pageIndex", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ f zWo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar) {
            super(1);
            this.zWo = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            o thumbUiLayout;
            AppMethodBeat.i(239937);
            int intValue = num.intValue();
            int i2 = this.zWo.mMaxCount;
            if (intValue >= 0 && i2 > intValue && (thumbUiLayout = this.zWo.getThumbUiLayout()) != null) {
                thumbUiLayout.RB(intValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239937);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue", "(Ljava/lang/Integer;)V"})
    public static final class d<T> implements ValueCallback<Integer> {
        final /* synthetic */ f zWo;

        d(f fVar) {
            this.zWo = fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Integer num) {
            AppMethodBeat.i(239945);
            Integer num2 = num;
            if (num2 == null || num2.intValue() != 0) {
                u.cH(this.zWo.getContext(), this.zWo.getContext().getString(R.string.gey));
                s mScreenReportData = this.zWo.getMScreenReportData();
                if (mScreenReportData != null) {
                    p.g(num2, "value");
                    mScreenReportData.errorCode = num2.intValue();
                }
                ac.eom().emx();
            }
            AppMethodBeat.o(239945);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(239961);
        e.a E = new e.a().E(1);
        Context context2 = getContext();
        p.g(context2, "context");
        String string = context2.getResources().getString(R.string.gev);
        p.g(string, "context.resources.getStr…n_projector_clear_screen)");
        e.a F = E.a(new e.c(string, 8)).F(9, 10);
        F.type = 2;
        setScreenFuncConfig(F.epo());
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.zWk = (RelativeLayout) findViewById(R.id.hc9);
        setMReadyLayout((FrameLayout) findViewById(R.id.hc5));
        setMEditLayout((FrameLayout) findViewById(R.id.hc8));
        setBottomRoot((FrameLayout) findViewById(R.id.hc1));
        setTopRoot((FrameLayout) findViewById(R.id.hc6));
        setAvatarRoot((FrameLayout) findViewById(R.id.hc7));
        this.zWj = (FrameLayout) findViewById(R.id.hc_);
        RelativeLayout relativeLayout = this.zWk;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        FrameLayout mEditLayout = getMEditLayout();
        if (mEditLayout != null) {
            mEditLayout.setVisibility(8);
        }
        Context context3 = getContext();
        p.g(context3, "context");
        setMultiTalkStrokeContext(new b(context3, this, getScreenFuncConfig()));
        b multiTalkStrokeContext = getMultiTalkStrokeContext();
        if (multiTalkStrokeContext != null) {
            multiTalkStrokeContext.zVP = new b(this);
        }
        Context context4 = getContext();
        p.g(context4, "context");
        setTopUiLayout(new p(context4, this));
        Context context5 = getContext();
        p.g(context5, "context");
        setAvatarLayout(new j(context5, this));
        Context context6 = getContext();
        p.g(context6, "context");
        setBottomUiLayout(new k(context6, this, getScreenFuncConfig()));
        Context context7 = getContext();
        p.g(context7, "context");
        this.zWl = new o(context7, this);
        Context context8 = getContext();
        p.g(context8, "context");
        setReadyUI(new r(context8, this, getScreenFuncConfig()));
        setMScreenReportData(new s());
        refreshView();
        AppMethodBeat.o(239961);
    }

    public static final /* synthetic */ void a(f fVar, int i2) {
        AppMethodBeat.i(239963);
        fVar.setMMaxCount(i2);
        AppMethodBeat.o(239963);
    }

    public static final /* synthetic */ void b(f fVar, int i2) {
        AppMethodBeat.i(239964);
        fVar.setMCurrentIndex(i2);
        AppMethodBeat.o(239964);
    }

    /* access modifiers changed from: protected */
    public final FrameLayout getThumbnailRoot() {
        return this.zWj;
    }

    /* access modifiers changed from: protected */
    public final void setThumbnailRoot(FrameLayout frameLayout) {
        this.zWj = frameLayout;
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout getMReaderLayout() {
        return this.zWk;
    }

    /* access modifiers changed from: protected */
    public final void setMReaderLayout(RelativeLayout relativeLayout) {
        this.zWk = relativeLayout;
    }

    /* access modifiers changed from: protected */
    public final o getThumbUiLayout() {
        return this.zWl;
    }

    /* access modifiers changed from: protected */
    public final void setThumbUiLayout(o oVar) {
        this.zWl = oVar;
    }

    /* access modifiers changed from: protected */
    public final h.b getMCurrentViewStatus() {
        return this.zVM;
    }

    /* access modifiers changed from: protected */
    public final void setMCurrentViewStatus(h.b bVar) {
        AppMethodBeat.i(239946);
        b multiTalkStrokeContext = getMultiTalkStrokeContext();
        if (multiTalkStrokeContext != null) {
            multiTalkStrokeContext.zVM = bVar;
        }
        this.zVM = bVar;
        AppMethodBeat.o(239946);
    }

    private final void setMMaxCount(int i2) {
        AppMethodBeat.i(239947);
        this.mMaxCount = i2;
        b multiTalkStrokeContext = getMultiTalkStrokeContext();
        if (multiTalkStrokeContext != null) {
            multiTalkStrokeContext.vfW = i2;
        }
        o oVar = this.zWl;
        if (oVar != null) {
            n nVar = oVar.zXK;
            if (nVar != null) {
                nVar.mMaxCount = i2;
            }
            com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b bVar = oVar.zXH;
            if (bVar != null) {
                bVar.mMaxCount = i2;
            }
            oVar.zXQ = (i2 / o.zXR) + 1;
            oVar.mMaxCount = i2;
            AppMethodBeat.o(239947);
            return;
        }
        AppMethodBeat.o(239947);
    }

    private final void setMToken(String str) {
        AppMethodBeat.i(239948);
        b multiTalkStrokeContext = getMultiTalkStrokeContext();
        if (multiTalkStrokeContext != null) {
            multiTalkStrokeContext.mToken = str;
        }
        this.mToken = str;
        AppMethodBeat.o(239948);
    }

    private final void setMFilePath(String str) {
        AppMethodBeat.i(239949);
        b multiTalkStrokeContext = getMultiTalkStrokeContext();
        if (multiTalkStrokeContext != null) {
            multiTalkStrokeContext.mFilePath = str;
        }
        this.mFilePath = str;
        AppMethodBeat.o(239949);
    }

    private final void setMCurrentIndex(int i2) {
        AppMethodBeat.i(239950);
        this.rmJ = i2;
        b multiTalkStrokeContext = getMultiTalkStrokeContext();
        if (multiTalkStrokeContext != null) {
            multiTalkStrokeContext.zVN = i2;
            kotlin.g.a.b<? super Integer, x> bVar = multiTalkStrokeContext.zVP;
            if (bVar != null) {
                bVar.invoke(Integer.valueOf(i2));
            }
        }
        o oVar = this.zWl;
        if (oVar != null) {
            n nVar = oVar.zXK;
            if (nVar != null) {
                nVar.rmJ = i2;
            }
            oVar.rmJ = i2;
            AppMethodBeat.o(239950);
            return;
        }
        AppMethodBeat.o(239950);
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final int getLayoutId() {
        return R.layout.bd4;
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final void sd(boolean z) {
        AppMethodBeat.i(239951);
        super.sd(z);
        RelativeLayout relativeLayout = this.zWk;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
            AppMethodBeat.o(239951);
            return;
        }
        AppMethodBeat.o(239951);
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final void aq(Bundle bundle) {
        AppMethodBeat.i(239952);
        if (bundle != null) {
            setVisibility(0);
            ar(bundle);
            sd(true);
        }
        AppMethodBeat.o(239952);
    }

    private void ar(Bundle bundle) {
        AppMethodBeat.i(239953);
        p.h(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        setVisibility(0);
        if (this.mToken == null) {
            setMToken(String.valueOf(hashCode()) + String.valueOf(System.currentTimeMillis()));
        }
        setMFilePath(bundle.getString("file_path"));
        this.nhr = bundle.getString("file_ext");
        if (this.mFilePath == null || this.nhr == null) {
            AppMethodBeat.o(239953);
            return;
        }
        String str = this.mFilePath;
        if (str == null) {
            p.hyc();
        }
        o oVar = new o(str);
        if (!oVar.exists() || !oVar.isFile()) {
            AppMethodBeat.o(239953);
            return;
        }
        s mScreenReportData = getMScreenReportData();
        if (mScreenReportData != null) {
            mScreenReportData.gCr = this.nhr;
        }
        s mScreenReportData2 = getMScreenReportData();
        if (mScreenReportData2 != null) {
            mScreenReportData2.fileName = this.mFilePath;
        }
        s mScreenReportData3 = getMScreenReportData();
        if (mScreenReportData3 != null) {
            mScreenReportData3.fileSize = s.boW(this.mFilePath);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("extra_param_disable_scale", "false");
        hashMap.put("extra_param_enable_receive_view_status_change", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("extra_param_bg_color", String.valueOf(getResources().getColor(R.color.y)));
        hashMap.put("extra_param_disable_finish_activity", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("extra_param_set_max_scale", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        String str2 = this.mFilePath;
        String str3 = this.nhr;
        String str4 = this.mToken;
        h.c cVar = h.c.ReaderView;
        Context context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(239953);
            throw tVar;
        }
        h.a(str2, str3, str4, true, (HashMap<String, String>) hashMap, cVar, (Activity) context, (ViewGroup) this.zWk, (h.a) new c(this), (ValueCallback<Integer>) new d(this));
        AppMethodBeat.o(239953);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J8\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0016¨\u0006\u001c"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector$inputFileInfo$1", "Lcom/tencent/xweb/FileReaderXWeb$ActionCallback;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onPageChange", "pageIndex", "", "pageWidth", "pageHeight", "onPageCountUpdate", "totalCount", "onReachEnd", "onSingleTap", "onThumbnailLoad", AssetExtension.SCENE_THUMBNAIL, "Landroid/graphics/Bitmap;", "onUserCancel", "onUserOperated", "onViewStatusChange", FirebaseAnalytics.b.INDEX, "zoom", "", "curWidth", "curHeight", "transX", "transY", "plugin-multitalk_release"})
    public static final class c implements h.a {
        final /* synthetic */ f zWo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(f fVar) {
            this.zWo = fVar;
        }

        @Override // com.tencent.xweb.h.a
        public final void Rz(int i2) {
            AppMethodBeat.i(239939);
            Log.i("MicroMsg.ScreenFileProjector", "xfile onPageCountUpdate ".concat(String.valueOf(i2)));
            f.a(this.zWo, i2);
            s mScreenReportData = this.zWo.getMScreenReportData();
            if (mScreenReportData != null) {
                mScreenReportData.zYf = this.zWo.mMaxCount;
            }
            o thumbUiLayout = this.zWo.getThumbUiLayout();
            if (thumbUiLayout != null) {
                thumbUiLayout.aGE(new StringBuilder().append(this.zWo.rmJ + 1).append('/').append(i2).toString());
                AppMethodBeat.o(239939);
                return;
            }
            AppMethodBeat.o(239939);
        }

        @Override // com.tencent.xweb.h.a
        public final void cTA() {
            AppMethodBeat.i(239940);
            Log.i("MicroMsg.ScreenFileProjector", "xfile on user cancel finish");
            ac.eom().emx();
            AppMethodBeat.o(239940);
        }

        @Override // com.tencent.xweb.h.a
        public final void ar(int i2, int i3, int i4) {
            AppMethodBeat.i(239941);
            Log.i("MicroMsg.ScreenFileProjector", "xfile onPageChange " + i2 + " and pageWidth " + i3 + " and pageHeight " + i4);
            if (i2 > this.zWo.rmJ && this.zWo.rmJ != -1) {
                this.zWo.epk();
                com.tencent.mm.plugin.multitalk.d.f fVar = com.tencent.mm.plugin.multitalk.d.f.zZd;
                com.tencent.mm.plugin.multitalk.d.f.equ();
                a.b.a(this.zWo, a.c.SLIDE_CONTENT_LEFT);
            } else if (i2 < this.zWo.rmJ && this.zWo.rmJ != -1) {
                this.zWo.epk();
                com.tencent.mm.plugin.multitalk.d.f fVar2 = com.tencent.mm.plugin.multitalk.d.f.zZd;
                com.tencent.mm.plugin.multitalk.d.f.equ();
                a.b.a(this.zWo, a.c.SLIDE_CONTENT_RIGHT);
            }
            if (!this.zWo.zWm) {
                this.zWo.zWm = true;
                o thumbUiLayout = this.zWo.getThumbUiLayout();
                if (thumbUiLayout != null) {
                    thumbUiLayout.epE();
                }
            }
            f.b(this.zWo, i2);
            this.zWo.setMCurrentScale(1.0f);
            this.zWo.setMCurrentPageWidth(i3);
            this.zWo.setMCurrentPageHeight(i4);
            o thumbUiLayout2 = this.zWo.getThumbUiLayout();
            if (thumbUiLayout2 != null) {
                int mCurrentPageWidth = this.zWo.getMCurrentPageWidth();
                int mCurrentPageHeight = this.zWo.getMCurrentPageHeight();
                thumbUiLayout2.zXN = mCurrentPageWidth;
                thumbUiLayout2.zXO = mCurrentPageHeight;
                com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b bVar = thumbUiLayout2.zXH;
                if (bVar != null) {
                    bVar.rmJ = i2;
                    float f2 = ((float) mCurrentPageWidth) / ((float) mCurrentPageHeight);
                    float f3 = ((float) mCurrentPageHeight) / (((float) mCurrentPageWidth) / com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYI);
                    if (f3 > com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYJ) {
                        float f4 = ((float) mCurrentPageWidth) / (((float) mCurrentPageHeight) / com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYJ);
                        if (f4 > com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYI) {
                            float f5 = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYK;
                            float f6 = f5 / f2;
                            if (f6 > com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYJ) {
                                f6 = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYJ;
                            }
                            bVar.zYE = f6;
                            bVar.zYD = f5;
                        } else if (f4 < com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYK) {
                            bVar.zYE = f3;
                            bVar.zYD = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYK;
                        } else {
                            bVar.zYE = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYJ;
                            bVar.zYD = f4;
                        }
                    } else {
                        bVar.zYE = f3;
                        bVar.zYD = com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b.zYI;
                    }
                    if (!(bVar.zYB == -1 || bVar.zYC == -1)) {
                        bVar.ci(i2);
                    }
                }
                RecyclerView recyclerView = thumbUiLayout2.zXI;
                if (recyclerView != null) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyCurrentThumbnail", "(III)V", "Undefined", "smoothScrollToPosition", "(I)V");
                    recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbUI", "applyCurrentThumbnail", "(III)V", "Undefined", "smoothScrollToPosition", "(I)V");
                }
            }
            this.zWo.setMCurrentViewStatus(h.oa(this.zWo.mToken, this.zWo.mFilePath));
            if (i3 > 0 && i4 > 0 && this.zWo.getMCurrentViewStatus() != null) {
                b multiTalkStrokeContext = this.zWo.getMultiTalkStrokeContext();
                if (multiTalkStrokeContext != null) {
                    multiTalkStrokeContext.zVL = this.zWo.getMCurrentPageHeight();
                }
                b multiTalkStrokeContext2 = this.zWo.getMultiTalkStrokeContext();
                if (multiTalkStrokeContext2 != null) {
                    multiTalkStrokeContext2.zVK = this.zWo.getMCurrentPageWidth();
                }
                b multiTalkStrokeContext3 = this.zWo.getMultiTalkStrokeContext();
                if (multiTalkStrokeContext3 != null) {
                    if (this.zWo.getMCurrentViewStatus() == null) {
                        p.hyc();
                    }
                    if (this.zWo.getMCurrentViewStatus() == null) {
                        p.hyc();
                    }
                    multiTalkStrokeContext3.zVJ = 1.0f;
                }
                com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
                h.b mCurrentViewStatus = this.zWo.getMCurrentViewStatus();
                if (mCurrentViewStatus == null) {
                    p.hyc();
                }
                int i5 = mCurrentViewStatus.Szo;
                h.b mCurrentViewStatus2 = this.zWo.getMCurrentViewStatus();
                if (mCurrentViewStatus2 == null) {
                    p.hyc();
                }
                int i6 = mCurrentViewStatus2.Szp;
                int mCurrentPageWidth2 = this.zWo.getMCurrentPageWidth();
                h.b mCurrentViewStatus3 = this.zWo.getMCurrentViewStatus();
                if (mCurrentViewStatus3 == null) {
                    p.hyc();
                }
                int i7 = mCurrentPageWidth2 + mCurrentViewStatus3.Szo;
                int mCurrentPageHeight2 = this.zWo.getMCurrentPageHeight();
                h.b mCurrentViewStatus4 = this.zWo.getMCurrentViewStatus();
                if (mCurrentViewStatus4 == null) {
                    p.hyc();
                }
                bVar2.setRect(new Rect(i5, i6, i7, mCurrentPageHeight2 + mCurrentViewStatus4.Szp));
                b multiTalkStrokeContext4 = this.zWo.getMultiTalkStrokeContext();
                if (multiTalkStrokeContext4 != null) {
                    multiTalkStrokeContext4.a(bVar2, new a(this));
                }
                this.zWo.epB();
                o thumbUiLayout3 = this.zWo.getThumbUiLayout();
                if (thumbUiLayout3 != null) {
                    thumbUiLayout3.aGE(new StringBuilder().append(this.zWo.rmJ + 1).append('/').append(this.zWo.mMaxCount).toString());
                    AppMethodBeat.o(239941);
                    return;
                }
            }
            AppMethodBeat.o(239941);
        }

        @Override // com.tencent.xweb.h.a
        public final void b(int i2, float f2, int i3, int i4, int i5, int i6) {
            com.tencent.mm.view.b.b bVar;
            AppMethodBeat.i(239942);
            Log.i("MicroMsg.ScreenFileProjector", "xfile onViewStatusChange " + i2 + " and pageWidth " + i3 + " and pageHeight " + i4 + " and scale " + f2 + " and transX " + i5 + " and " + i6);
            b multiTalkStrokeContext = this.zWo.getMultiTalkStrokeContext();
            if (multiTalkStrokeContext != null) {
                com.tencent.mm.plugin.multitalk.ui.a.b bVar2 = multiTalkStrokeContext.zVO;
                if (bVar2 != null) {
                    com.tencent.mm.plugin.multitalk.ui.a.a aVar = bVar2.zQC;
                    if (aVar != null) {
                        com.tencent.mm.view.l lVar = aVar.zQo;
                        if (lVar == null || (bVar = (com.tencent.mm.view.b.b) lVar.getBaseBoardView()) == null) {
                            AppMethodBeat.o(239942);
                            return;
                        }
                        bVar.h(f2, i5, i6);
                        AppMethodBeat.o(239942);
                        return;
                    }
                    AppMethodBeat.o(239942);
                    return;
                }
                AppMethodBeat.o(239942);
                return;
            }
            AppMethodBeat.o(239942);
        }

        @Override // com.tencent.xweb.h.a
        public final void c(int i2, Bitmap bitmap) {
            AppMethodBeat.i(239943);
            p.h(bitmap, AssetExtension.SCENE_THUMBNAIL);
            Log.i("MicroMsg.ScreenFileProjector", "xfile onThumbnailLoad ".concat(String.valueOf(i2)));
            o thumbUiLayout = this.zWo.getThumbUiLayout();
            if (thumbUiLayout != null) {
                p.h(bitmap, AssetExtension.SCENE_THUMBNAIL);
                if (thumbUiLayout.zXD.size() <= i2) {
                    thumbUiLayout.zXD.add(bitmap);
                } else {
                    thumbUiLayout.zXD.set(i2, bitmap);
                }
                com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b bVar = thumbUiLayout.zXH;
                if (bVar != null) {
                    p.h(bitmap, "bitmap");
                    bVar.zYB = bitmap.getWidth();
                    bVar.zYC = bitmap.getHeight();
                }
                com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.e eVar = thumbUiLayout.zXG;
                if (eVar != null) {
                    com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b bVar2 = thumbUiLayout.zXH;
                    int i3 = bVar2 != null ? (int) bVar2.zYD : 0;
                    FrameLayout frameLayout = thumbUiLayout.zXJ;
                    eVar.zYO = frameLayout != null ? frameLayout.getMeasuredWidth() : 0;
                    eVar.qmd = i3;
                }
                ScreenThumbLayoutManager screenThumbLayoutManager = thumbUiLayout.zXF;
                if (screenThumbLayoutManager != null) {
                    com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b bVar3 = thumbUiLayout.zXH;
                    int i4 = bVar3 != null ? (int) bVar3.zYD : 0;
                    FrameLayout frameLayout2 = thumbUiLayout.zXJ;
                    screenThumbLayoutManager.zYO = frameLayout2 != null ? frameLayout2.getMeasuredWidth() : 0;
                    screenThumbLayoutManager.qmd = i4;
                }
                if (i2 == (thumbUiLayout.zXP + 1) * o.zXR || i2 == thumbUiLayout.mMaxCount - 1) {
                    thumbUiLayout.isLoading = false;
                    com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b bVar4 = thumbUiLayout.zXH;
                    if (bVar4 != null) {
                        CopyOnWriteArrayList<Bitmap> copyOnWriteArrayList = thumbUiLayout.zXD;
                        p.h(copyOnWriteArrayList, "bitmapList");
                        CopyOnWriteArrayList<Bitmap> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                        for (Bitmap bitmap2 : copyOnWriteArrayList) {
                            if (bitmap2 != null) {
                                copyOnWriteArrayList2.add(bitmap2);
                            }
                        }
                        bVar4.zXD = copyOnWriteArrayList2;
                        bVar4.notifyDataSetChanged();
                    }
                    if (thumbUiLayout.zXP != thumbUiLayout.zXQ - 1) {
                        com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b bVar5 = thumbUiLayout.zXH;
                        if (bVar5 != null) {
                            bVar5.zYF = true;
                            Bitmap createBitmap = BitmapUtil.createBitmap((int) bVar5.zYD, (int) bVar5.zYE, Bitmap.Config.ARGB_8888);
                            p.g(createBitmap, "BitmapUtil.createBitmap(…,Bitmap.Config.ARGB_8888)");
                            p.h(createBitmap, "bitmap");
                            bVar5.zXD.add(createBitmap);
                            bVar5.cj(bVar5.zXD.size() - 1);
                            AppMethodBeat.o(239943);
                            return;
                        }
                        AppMethodBeat.o(239943);
                        return;
                    }
                    thumbUiLayout.jUX = true;
                }
                AppMethodBeat.o(239943);
                return;
            }
            AppMethodBeat.o(239943);
        }

        @Override // com.tencent.xweb.h.a
        public final void epu() {
            AppMethodBeat.i(239944);
            a.b.a(this.zWo, a.c.SCREEN_ON_CLICK);
            AppMethodBeat.o(239944);
        }

        @Override // com.tencent.xweb.h.a
        public final void epv() {
        }

        @Override // com.tencent.xweb.h.a
        public final void epw() {
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ c zWp;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar) {
                super(0);
                this.zWp = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(239938);
                this.zWp.zWo.setLockGenerateBitmap(false);
                x xVar = x.SXb;
                AppMethodBeat.o(239938);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final View getBackgroundView() {
        return this.zWk;
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final void epp() {
        AppMethodBeat.i(239954);
        setMToken(null);
        super.epp();
        AppMethodBeat.o(239954);
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final void epq() {
        AppMethodBeat.i(239955);
        h.nZ(this.mToken, this.mFilePath);
        setMToken(null);
        setMFilePath(null);
        AppMethodBeat.o(239955);
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final int epr() {
        AppMethodBeat.i(239956);
        int epr = super.epr();
        FrameLayout frameLayout = this.zWj;
        if (frameLayout != null) {
            frameLayout.setVisibility(epr);
        }
        AppMethodBeat.o(239956);
        return epr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0248  */
    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eps() {
        /*
        // Method dump skipped, instructions count: 592
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.projector.f.eps():void");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final void ept() {
        AppMethodBeat.i(239958);
        RelativeLayout relativeLayout = this.zWk;
        if (relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            k.a aVar = k.zTz;
            Context context = getContext();
            p.g(context, "context");
            if (k.a.gE(context) != 90) {
                k.a aVar2 = k.zTz;
                Context context2 = getContext();
                p.g(context2, "context");
                if (k.a.gE(context2) != 270) {
                    layoutParams.removeRule(16);
                    layoutParams.removeRule(3);
                    layoutParams.removeRule(17);
                    layoutParams.removeRule(2);
                    FrameLayout topRoot = getTopRoot();
                    if (topRoot == null) {
                        p.hyc();
                    }
                    layoutParams.addRule(3, topRoot.getId());
                    FrameLayout bottomRoot = getBottomRoot();
                    if (bottomRoot == null) {
                        p.hyc();
                    }
                    layoutParams.addRule(2, bottomRoot.getId());
                    relativeLayout.setLayoutParams(layoutParams);
                    AppMethodBeat.o(239958);
                    return;
                }
            }
            layoutParams.removeRule(16);
            layoutParams.removeRule(3);
            layoutParams.removeRule(17);
            layoutParams.removeRule(2);
            FrameLayout topRoot2 = getTopRoot();
            if (topRoot2 == null) {
                p.hyc();
            }
            layoutParams.addRule(17, topRoot2.getId());
            FrameLayout bottomRoot2 = getBottomRoot();
            if (bottomRoot2 == null) {
                p.hyc();
            }
            layoutParams.addRule(16, bottomRoot2.getId());
            relativeLayout.setLayoutParams(layoutParams);
            AppMethodBeat.o(239958);
            return;
        }
        AppMethodBeat.o(239958);
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final void refreshView() {
        AppMethodBeat.i(239959);
        this.zWm = false;
        super.refreshView();
        o oVar = this.zWl;
        if (oVar != null) {
            oVar.epE();
            AppMethodBeat.o(239959);
            return;
        }
        AppMethodBeat.o(239959);
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l, com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final void a(a.c cVar, Bundle bundle) {
        int i2;
        AppMethodBeat.i(239960);
        p.h(cVar, "status");
        super.a(cVar, bundle);
        switch (g.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                o oVar = this.zWl;
                if (oVar != null) {
                    oVar.hide();
                    AppMethodBeat.o(239960);
                    return;
                }
                AppMethodBeat.o(239960);
                return;
            case 2:
                o oVar2 = this.zWl;
                if (oVar2 != null) {
                    oVar2.show();
                    AppMethodBeat.o(239960);
                    return;
                }
                AppMethodBeat.o(239960);
                return;
            case 3:
                if (bundle != null) {
                    int i3 = bundle.getInt("thumb_flip_target_position");
                    epk();
                    h.aw(this.mToken, this.mFilePath, i3);
                    AppMethodBeat.o(239960);
                    return;
                }
                AppMethodBeat.o(239960);
                return;
            case 4:
                if (!this.zXj) {
                    int i4 = this.rmJ + 1;
                    int i5 = this.mMaxCount;
                    if (i4 >= 0 && i5 > i4) {
                        epk();
                        o oVar3 = this.zWl;
                        if (oVar3 != null) {
                            oVar3.RB(i4);
                            AppMethodBeat.o(239960);
                            return;
                        }
                        AppMethodBeat.o(239960);
                        return;
                    }
                    u.cE(getContext(), "没有更多内容");
                    AppMethodBeat.o(239960);
                    return;
                }
                break;
            case 5:
                if (!this.zXj) {
                    int i6 = this.rmJ - 1;
                    int i7 = this.mMaxCount;
                    if (i6 >= 0 && i7 > i6) {
                        epk();
                        o oVar4 = this.zWl;
                        if (oVar4 != null) {
                            oVar4.RB(i6);
                            AppMethodBeat.o(239960);
                            return;
                        }
                        AppMethodBeat.o(239960);
                        return;
                    }
                    u.cE(getContext(), "没有更多内容");
                    AppMethodBeat.o(239960);
                    return;
                }
                break;
            case 6:
                if (bundle != null) {
                    int i8 = bundle.getInt("thumb_current_page");
                    o.a aVar = o.zXS;
                    int epG = o.epG() * i8;
                    o.a aVar2 = o.zXS;
                    if ((i8 + 1) * o.epG() < this.mMaxCount) {
                        o.a aVar3 = o.zXS;
                        i2 = (i8 + 1) * o.epG();
                    } else {
                        i2 = this.mMaxCount;
                    }
                    if (epG <= i2) {
                        while (true) {
                            h.ax(this.mToken, this.mFilePath, epG);
                            if (epG != i2) {
                                epG++;
                            }
                        }
                    }
                    AppMethodBeat.o(239960);
                    return;
                }
                break;
        }
        AppMethodBeat.o(239960);
    }
}
