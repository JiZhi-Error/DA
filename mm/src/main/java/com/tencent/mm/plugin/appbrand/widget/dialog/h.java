package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.a.b;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.phonenumber.k;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.ui.ak;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\fH\u0002J$\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u000e2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010U\u001a\u00020LH\u0016J\u0010\u0010U\u001a\u00020L2\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010V\u001a\u00020\u0018H\u0016J\b\u0010W\u001a\u00020\fH\u0002J\n\u0010X\u001a\u0004\u0018\u000104H\u0016J\b\u0010Y\u001a\u00020\fH\u0016J \u0010Z\u001a\u0012\u0012\u0004\u0012\u00020\u000e0[j\b\u0012\u0004\u0012\u00020\u000e`\\2\u0006\u0010]\u001a\u00020\tH\u0002J\n\u0010^\u001a\u0004\u0018\u000102H\u0002J\b\u0010_\u001a\u00020\tH\u0016J\b\u0010`\u001a\u00020\tH\u0016J\b\u0010a\u001a\u00020\tH\u0016J\b\u0010b\u001a\u00020LH\u0016J\b\u0010c\u001a\u00020LH\u0016J\u0010\u0010d\u001a\u00020L2\u0006\u0010M\u001a\u00020\fH\u0016J\u0012\u0010e\u001a\u00020L2\b\u0010f\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010g\u001a\u00020L2\b\u0010\u0006\u001a\u0004\u0018\u00010hH\u0016J\u0012\u0010i\u001a\u00020L2\b\u0010\u0006\u001a\u0004\u0018\u00010hH\u0016J\u0012\u0010j\u001a\u00020L2\b\u0010k\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010l\u001a\u00020L2\b\b\u0001\u0010m\u001a\u00020\fH\u0016J\u0010\u0010n\u001a\u00020L2\u0006\u0010o\u001a\u00020\fH\u0016J\u0012\u0010p\u001a\u00020L2\b\u0010q\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010r\u001a\u00020L2\u0006\u0010\u0006\u001a\u00020sH\u0016J\u000e\u0010t\u001a\u00020L2\u0006\u0010u\u001a\u00020\fJ\u0012\u0010v\u001a\u00020L2\b\u0010w\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010x\u001a\u00020L2\u0006\u0010y\u001a\u00020\u000eH\u0016J\u0018\u0010z\u001a\u00020L2\u000e\u0010{\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010|H\u0016J\u0010\u0010}\u001a\u00020L2\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010~\u001a\u00020L2\u0006\u0010}\u001a\u00020\tH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\r\u001a\u0004\u0018\u00010\u001e@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020201X\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u000e¢\u0006\u0002\n\u0000R(\u0010E\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0011\"\u0004\bG\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R(\u0010H\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010\u0013¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "shouldInLargeScreenCompatMode", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;Z)V", "_position", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "mRootWrapperFrameLayout", "Landroid/widget/FrameLayout;", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "changeListHeightByRotation", "", "rotation", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getContentView", "getDialogHeight", "getLastPointerDownTouchEvent", "getPosition", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setFunctionButtonVisibility", "visibility", "setNegativeButtonText", "cancelWording", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPosition", "position", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "show", "showExplainIv", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public final class h extends Dialog implements com.tencent.mm.plugin.appbrand.permission.a.b, k {
    public static final a JjF = new a((byte) 0);
    private View JhJ;
    private b.c JhK;
    private FrameLayout JiV;
    private DialogInterface.OnDismissListener XZ;
    private final List<i.a> cvc;
    private View hSw;
    private String iconUrl;
    private final View jBN;
    private int jCs;
    private TextView jVh;
    private String lGX;
    private ImageView lIM;
    private ImageView lIO;
    private Button lJa;
    private Button lJb;
    private m lJc;
    private String lJe;
    private MaxHeightRecyclerView nbM;
    private MotionEvent nbP;
    private String nbQ;
    private TextView nbR;
    private String nbS;
    private TextView nbT;
    private String nbU;
    private LinearLayout nbV;
    private i nbW;
    private i.b nbX;
    private TextView nbY;
    private TextView nce;
    private DialogInterface.OnShowListener nyE;
    private final boolean nzn;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
    public interface b extends b.c {
    }

    static {
        AppMethodBeat.i(148265);
        AppMethodBeat.o(148265);
    }

    public /* synthetic */ h(Context context, b.c cVar) {
        this(context, cVar, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context, b.c cVar, boolean z) {
        super(context);
        p.h(context, "context");
        p.h(cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AppMethodBeat.i(230241);
        this.nzn = z;
        View inflate = View.inflate(n.dF(context), R.layout.fe, null);
        p.g(inflate, "View.inflate(context.wra…and_request_dialog, null)");
        this.jBN = inflate;
        this.JhK = cVar;
        this.lGX = "";
        this.cvc = new ArrayList();
        View findViewById = this.jBN.findViewById(R.id.h3q);
        p.g(findViewById, "mRootView.findViewById(R.id.request_icon)");
        this.lIM = (ImageView) findViewById;
        View findViewById2 = this.jBN.findViewById(R.id.h3s);
        p.g(findViewById2, "mRootView.findViewById(R.id.request_name)");
        this.jVh = (TextView) findViewById2;
        View findViewById3 = this.jBN.findViewById(R.id.h3l);
        p.g(findViewById3, "mRootView.findViewById(R.id.request_cancel)");
        this.lJb = (Button) findViewById3;
        View findViewById4 = this.jBN.findViewById(R.id.h3t);
        p.g(findViewById4, "mRootView.findViewById(R.id.request_ok)");
        this.lJa = (Button) findViewById4;
        View findViewById5 = this.jBN.findViewById(R.id.h3o);
        p.g(findViewById5, "mRootView.findViewById(R.id.request_desc)");
        this.nce = (TextView) findViewById5;
        View findViewById6 = this.jBN.findViewById(R.id.hs8);
        p.g(findViewById6, "mRootView.findViewById(R.id.simple_detail_desc)");
        this.nbR = (TextView) findViewById6;
        View findViewById7 = this.jBN.findViewById(R.id.h3n);
        p.g(findViewById7, "mRootView.findViewById(R.id.request_content)");
        this.nbV = (LinearLayout) findViewById7;
        View findViewById8 = this.jBN.findViewById(R.id.h3w);
        p.g(findViewById8, "mRootView.findViewById(R.id.request_right_icon)");
        this.lIO = (ImageView) findViewById8;
        View findViewById9 = this.jBN.findViewById(R.id.h3k);
        p.g(findViewById9, "mRootView.findViewById(R.id.request_apply_wording)");
        this.nbT = (TextView) findViewById9;
        View findViewById10 = this.jBN.findViewById(R.id.h3u);
        p.g(findViewById10, "mRootView.findViewById(R.id.request_recyclerview)");
        this.nbM = (MaxHeightRecyclerView) findViewById10;
        this.nbM.setLayoutManager(new LinearLayoutManager());
        this.nbW = new i(this.cvc);
        this.nbW.nbX = this.nbX;
        this.nbM.setAdapter(this.nbW);
        View findViewById11 = this.jBN.findViewById(R.id.h3r);
        p.g(findViewById11, "mRootView.findViewById(R.id.request_loading)");
        this.hSw = findViewById11;
        View findViewById12 = this.jBN.findViewById(R.id.ah3);
        p.g(findViewById12, "mRootView.findViewById(R.id.button_group)");
        this.JhJ = findViewById12;
        View findViewById13 = this.jBN.findViewById(R.id.h3p);
        p.g(findViewById13, "mRootView.findViewById(R.id.request_function)");
        this.nbY = (TextView) findViewById13;
        this.lJa.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.widget.dialog.h.AnonymousClass1 */
            final /* synthetic */ h oqV;

            {
                this.oqV = r1;
            }

            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(148227);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList<String> a2 = h.a(this.oqV, true);
                b.c cVar = this.oqV.JhK;
                i.a c2 = h.c(this.oqV);
                if (c2 != null) {
                    i2 = c2.lGW;
                } else {
                    i2 = 0;
                }
                cVar.a(1, a2, i2);
                m mVar = this.oqV.lJc;
                if (mVar != null) {
                    mVar.c(this.oqV);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(148227);
            }
        });
        this.lJb.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.widget.dialog.h.AnonymousClass2 */
            final /* synthetic */ h oqV;

            {
                this.oqV = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(148228);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.c.a.a(this.oqV.JhK, 2, h.a(this.oqV, false));
                m mVar = this.oqV.lJc;
                if (mVar != null) {
                    mVar.c(this.oqV);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(148228);
            }
        });
        this.nbM.setItemAnimator(null);
        this.jCs = 2;
        AppMethodBeat.o(230241);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setItemCheckedListener(i.b bVar) {
        this.nbX = bVar;
        this.nbW.nbX = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setAppBrandName(String str) {
        AppMethodBeat.i(148245);
        this.lJe = str;
        this.jVh.setText(str != null ? str : "");
        AppMethodBeat.o(148245);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setRequestDesc(String str) {
        AppMethodBeat.i(148246);
        this.nbQ = str;
        this.nce.setText(str);
        AppMethodBeat.o(148246);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setSimpleDetailDesc(String str) {
        AppMethodBeat.i(148247);
        this.nbS = str;
        if (str != null) {
            this.nbR.setVisibility(0);
            this.nbR.setText(str);
        }
        AppMethodBeat.o(148247);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setApplyWording(String str) {
        AppMethodBeat.i(148248);
        this.nbU = str;
        this.nbT.setText(str);
        AppMethodBeat.o(148248);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setIconUrl(String str) {
        AppMethodBeat.i(148249);
        this.iconUrl = str;
        com.tencent.mm.modelappbrand.a.b.aXY().a(this.lIM, this.iconUrl, ak.bXP(), g.iJB);
        AppMethodBeat.o(148249);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjb() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void a(m mVar) {
        AppMethodBeat.i(148250);
        setPosition(this.jCs);
        DialogInterface.OnShowListener onShowListener = this.nyE;
        if (onShowListener != null) {
            onShowListener.onShow(this);
        }
        this.lJc = mVar;
        Object systemService = getContext().getSystemService("window");
        if (!(systemService instanceof WindowManager)) {
            systemService = null;
        }
        WindowManager windowManager = (WindowManager) systemService;
        if (windowManager != null) {
            n nVar = n.JjY;
            Context context = getContentView().getContext();
            p.g(context, "contentView.context");
            View contentView = getContentView();
            View view = this.JhJ;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            p.g(defaultDisplay, "it.defaultDisplay");
            n.a(context, contentView, view, defaultDisplay.getRotation(), this.nzn);
            Display defaultDisplay2 = windowManager.getDefaultDisplay();
            p.g(defaultDisplay2, "it.defaultDisplay");
            wN(defaultDisplay2.getRotation());
            AppMethodBeat.o(148250);
            return;
        }
        AppMethodBeat.o(148250);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void ut(int i2) {
        AppMethodBeat.i(148251);
        n nVar = n.JjY;
        Context context = getContentView().getContext();
        p.g(context, "contentView.context");
        n.a(context, getContentView(), this.JhJ, i2, this.nzn);
        wN(i2);
        AppMethodBeat.o(148251);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$changeListHeightByRotation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wechat-full-sdk_release"})
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ h oqV;
        final /* synthetic */ double oqW;

        c(h hVar, double d2) {
            this.oqV = hVar;
            this.oqW = d2;
        }

        public final void onGlobalLayout() {
            int dimensionPixelSize;
            View childAt;
            AppMethodBeat.i(169658);
            double d2 = this.oqW;
            int i2 = 0;
            int i3 = 0;
            while (d2 > 0.0d) {
                RecyclerView.LayoutManager layoutManager = this.oqV.nbM.getLayoutManager();
                if (layoutManager == null || (childAt = layoutManager.getChildAt(i3)) == null) {
                    Context context = this.oqV.getContext();
                    p.g(context, "context");
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.su);
                } else {
                    dimensionPixelSize = childAt.getMeasuredHeight();
                }
                if (d2 < 1.0d) {
                    dimensionPixelSize = (int) (((double) dimensionPixelSize) * d2);
                }
                d2 -= 4.0d;
                i3++;
                i2 = dimensionPixelSize + i2;
            }
            this.oqV.nbM.setMaxHeight(i2);
            this.oqV.nbM.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.o(169658);
        }
    }

    private final void wN(int i2) {
        AppMethodBeat.i(148252);
        this.nbM.getViewTreeObserver().addOnGlobalLayoutListener(new c(this, (i2 == 1 || i2 == 3) ? 1.5d : 2.5d));
        this.nbM.invalidate();
        AppMethodBeat.o(148252);
    }

    public final void dismiss() {
        AppMethodBeat.i(148253);
        super.dismiss();
        DialogInterface.OnDismissListener onDismissListener = this.XZ;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
            AppMethodBeat.o(148253);
            return;
        }
        AppMethodBeat.o(148253);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void onCancel() {
        AppMethodBeat.i(148254);
        b.c.a.a(this.JhK, 3, new ArrayList());
        AppMethodBeat.o(148254);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjc() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean isCancelable() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final MotionEvent getLastPointerDownTouchEvent() {
        return this.nbP;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$getContentView$2", "Landroid/widget/FrameLayout;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "luggage-wechat-full-sdk_release"})
    public static final class d extends FrameLayout {
        final /* synthetic */ h oqV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar, Context context) {
            super(context);
            this.oqV = hVar;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(230234);
            if (motionEvent != null && motionEvent.getAction() == 0) {
                this.oqV.nbP = MotionEvent.obtain(motionEvent);
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(230234);
            return dispatchTouchEvent;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final View getContentView() {
        AppMethodBeat.i(230235);
        if (this.JiV == null) {
            this.JiV = new d(this, getContext());
            FrameLayout frameLayout = this.JiV;
            if (frameLayout == null) {
                p.btv("mRootWrapperFrameLayout");
            }
            frameLayout.addView(this.jBN, new ViewGroup.LayoutParams(-1, -1));
        }
        FrameLayout frameLayout2 = this.JiV;
        if (frameLayout2 == null) {
            p.btv("mRootWrapperFrameLayout");
        }
        FrameLayout frameLayout3 = frameLayout2;
        AppMethodBeat.o(230235);
        return frameLayout3;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setNegativeButtonText(String str) {
        AppMethodBeat.i(148255);
        if (str != null) {
            this.lJb.setText(str);
            AppMethodBeat.o(148255);
            return;
        }
        AppMethodBeat.o(148255);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setPositiveButtonText(String str) {
        AppMethodBeat.i(148256);
        if (str != null) {
            this.lJa.setText(str);
            AppMethodBeat.o(148256);
            return;
        }
        AppMethodBeat.o(148256);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setFunctionButtonText(String str) {
        AppMethodBeat.i(148257);
        if (TextUtils.isEmpty(str)) {
            this.nbY.setText("");
            this.nbY.setVisibility(4);
            AppMethodBeat.o(148257);
            return;
        }
        this.nbY.setText(str);
        this.nbY.setVisibility(0);
        AppMethodBeat.o(148257);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setFunctionButtonVisibility(int i2) {
        AppMethodBeat.i(230236);
        this.nbY.setVisibility(i2);
        AppMethodBeat.o(230236);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setFunctionButtonTextColor(int i2) {
        AppMethodBeat.i(148258);
        this.nbY.setTextColor(i2);
        AppMethodBeat.o(148258);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setFunctionButtonOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(148259);
        this.nbY.setOnClickListener(onClickListener);
        AppMethodBeat.o(148259);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setExplainOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(148260);
        this.lIO.setOnClickListener(onClickListener);
        AppMethodBeat.o(148260);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void ia(boolean z) {
        AppMethodBeat.i(148261);
        this.lIO.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(148261);
    }

    public final void setPosition(int i2) {
        AppMethodBeat.i(230237);
        this.jCs = i2;
        switch (i2) {
            case 1:
                this.jBN.setBackground(android.support.v4.content.b.l(getContext(), R.drawable.eh));
                AppMethodBeat.o(230237);
                return;
            case 2:
                this.jBN.setBackground(android.support.v4.content.b.l(getContext(), R.drawable.eg));
                break;
        }
        AppMethodBeat.o(230237);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final int getPosition() {
        return this.jCs;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setSelectListItem(List<i.a> list) {
        AppMethodBeat.i(148262);
        if (list == null) {
            AppMethodBeat.o(148262);
        } else if (list.isEmpty()) {
            AppMethodBeat.o(148262);
        } else {
            this.cvc.clear();
            this.cvc.addAll(list);
            this.nbW.notifyDataSetChanged();
            this.nbV.setVisibility(0);
            this.nbR.setVisibility(8);
            this.hSw.setVisibility(8);
            AppMethodBeat.o(148262);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setScope(String str) {
        AppMethodBeat.i(148263);
        p.h(str, "scope");
        this.lGX = str;
        AppMethodBeat.o(148263);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setOnListItemLongClickListener(i.d dVar) {
        AppMethodBeat.i(230238);
        p.h(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.nbW.oqX = dVar;
        AppMethodBeat.o(230238);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.f
    public final void h(com.tencent.mm.plugin.appbrand.d dVar) {
        AppMethodBeat.i(230239);
        p.h(dVar, "component");
        setPosition(this.jCs);
        p.h(dVar, "$this$findPromptViewContainer");
        p.h(dVar, "$this$findPromptViewContainer");
        h.a.k(dVar).b(this);
        AppMethodBeat.o(230239);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.h
    public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.d dVar, String str, ag agVar) {
        AppMethodBeat.i(230240);
        p.h(dVar, "component");
        Context context = getContext();
        p.g(context, "this.context");
        k kVar = new k(agVar, str, context, this.jBN.getMeasuredHeight(), dVar.getWindowAndroid().OD());
        com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid = dVar.getWindowAndroid();
        p.g(windowAndroid, "component.windowAndroid");
        if (windowAndroid.bsj()) {
            kVar.setPosition(1);
        }
        k kVar2 = kVar;
        AppMethodBeat.o(230240);
        return kVar2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Companion;", "", "()V", "ALERT_RESULT_CODE_ACCEPT", "", "ALERT_RESULT_CODE_CANCEL", "ALERT_RESULT_CODE_REJECT", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ ArrayList a(h hVar, boolean z) {
        String str;
        AppMethodBeat.i(148266);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(hVar.lGX)) {
            arrayList.add(hVar.lGX);
            AppMethodBeat.o(148266);
            return arrayList;
        }
        List<i.a> list = hVar.nbW.iHf;
        if (list.size() == 1) {
            i.a aVar = list.get(0);
            if (!(aVar == null || (str = aVar.scope) == null)) {
                arrayList.add(str);
            }
            AppMethodBeat.o(148266);
            return arrayList;
        }
        for (T t : list) {
            if (!(t == null || t.jCx != z || t.scope == null)) {
                arrayList.add(t.scope);
            }
        }
        AppMethodBeat.o(148266);
        return arrayList;
    }

    public static final /* synthetic */ i.a c(h hVar) {
        AppMethodBeat.i(230242);
        for (i.a aVar : hVar.nbW.iHf) {
            if (aVar != null && aVar.jCx) {
                AppMethodBeat.o(230242);
                return aVar;
            }
        }
        AppMethodBeat.o(230242);
        return null;
    }
}
