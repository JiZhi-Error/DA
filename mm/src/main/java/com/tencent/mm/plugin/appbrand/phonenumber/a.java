package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0017\u0018\u0000 w2\u00020\u00012\u00020\u0002:\u0002wxB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010e\u001a\u00020fH\u0016J\b\u0010g\u001a\u00020'H\u0016J\b\u0010h\u001a\u00020\u0007H\u0016J\b\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020jH\u0016J\b\u0010l\u001a\u00020jH\u0016J\b\u0010m\u001a\u00020fH\u0016J\b\u0010n\u001a\u00020fH\u0016J\u0010\u0010o\u001a\u00020f2\u0006\u0010p\u001a\u00020\u0007H\u0016J\u0012\u0010q\u001a\u00020f2\b\u0010r\u001a\u0004\u0018\u00010/H\u0016J\u000e\u0010s\u001a\u00020f2\u0006\u0010t\u001a\u00020\u0007J\u000e\u0010u\u001a\u00020f2\u0006\u0010v\u001a\u00020jR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR(\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010?\"\u0004\bQ\u0010AR\u000e\u0010R\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R(\u0010S\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\f\"\u0004\bU\u0010\u000eR(\u0010W\u001a\u0004\u0018\u00010V2\b\u0010\b\u001a\u0004\u0018\u00010V@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R(\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010\b\u001a\u0004\u0018\u00010\\@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR(\u0010b\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\f\"\u0004\bd\u0010\u000e¨\u0006y"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_position", "", "value", "", "acceptWording", "getAcceptWording", "()Ljava/lang/String;", "setAcceptWording", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "applyWording", "getApplyWording", "setApplyWording", "cancelWording", "getCancelWording", "setCancelWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mContentLayout", "Landroid/widget/LinearLayout;", "getMContentLayout", "()Landroid/widget/LinearLayout;", "setMContentLayout", "(Landroid/widget/LinearLayout;)V", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mFuncTv", "getMFuncTv", "()Landroid/widget/TextView;", "setMFuncTv", "(Landroid/widget/TextView;)V", "mIconIv", "Landroid/widget/ImageView;", "mListener", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "setMListener", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;)V", "mLoadingView", "getMLoadingView", "()Landroid/view/View;", "setMLoadingView", "(Landroid/view/View;)V", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getMRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setMRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "mRequestDescTv", "mRightIconIv", "mRootView", "getMRootView", "setMRootView", "mSimpleDetailDescTv", "requestDesc", "getRequestDesc", "setRequestDesc", "Landroid/graphics/drawable/Drawable;", "rightIcon", "getRightIcon", "()Landroid/graphics/drawable/Drawable;", "setRightIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View$OnClickListener;", "rightIconListener", "getRightIconListener", "()Landroid/view/View$OnClickListener;", "setRightIconListener", "(Landroid/view/View$OnClickListener;)V", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "dismiss", "", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "showRightIcon", "show", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public class a extends Dialog implements k {
    public static final C0782a nyH = new C0782a((byte) 0);
    private DialogInterface.OnDismissListener XZ;
    View gAy;
    private String iconUrl;
    View jBN;
    int jCs = 2;
    private TextView jVh;
    private ImageView lIM;
    private View lIZ;
    private Button lJa;
    private Button lJb;
    private m lJc;
    private String lJe;
    RecyclerView mRecyclerView;
    private TextView nbR;
    private TextView nbT;
    private TextView nce;
    LinearLayout ncf;
    TextView ncg;
    ImageView nyD;
    private DialogInterface.OnShowListener nyE;
    b nyF;
    Drawable nyG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "", "onMsg", "", "resultCode", "", "luggage-wechat-full-sdk_release"})
    public interface b {
        void yU(int i2);
    }

    static {
        AppMethodBeat.i(148016);
        AppMethodBeat.o(148016);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(148015);
        View inflate = View.inflate(n.dF(context), R.layout.fe, null);
        p.g(inflate, "View.inflate(context.wra…and_request_dialog, null)");
        this.jBN = inflate;
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
        this.ncf = (LinearLayout) findViewById7;
        View findViewById8 = this.jBN.findViewById(R.id.h3w);
        p.g(findViewById8, "mRootView.findViewById(R.id.request_right_icon)");
        this.nyD = (ImageView) findViewById8;
        View findViewById9 = this.jBN.findViewById(R.id.h3k);
        p.g(findViewById9, "mRootView.findViewById(R.id.request_apply_wording)");
        this.nbT = (TextView) findViewById9;
        View findViewById10 = this.jBN.findViewById(R.id.h3u);
        p.g(findViewById10, "mRootView.findViewById(R.id.request_recyclerview)");
        this.mRecyclerView = (RecyclerView) findViewById10;
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager());
        View findViewById11 = this.jBN.findViewById(R.id.h3r);
        p.g(findViewById11, "mRootView.findViewById(R.id.request_loading)");
        this.gAy = findViewById11;
        View findViewById12 = this.jBN.findViewById(R.id.ah3);
        p.g(findViewById12, "mRootView.findViewById(R.id.button_group)");
        this.lIZ = findViewById12;
        View findViewById13 = this.jBN.findViewById(R.id.h3p);
        p.g(findViewById13, "mRootView.findViewById(R.id.request_function)");
        this.ncg = (TextView) findViewById13;
        this.lJa.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.phonenumber.a.AnonymousClass1 */
            final /* synthetic */ a nyI;

            {
                this.nyI = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(148007);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b bVar2 = this.nyI.nyF;
                if (bVar2 != null) {
                    bVar2.yU(1);
                }
                m mVar = this.nyI.lJc;
                if (mVar != null) {
                    mVar.c(this.nyI);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(148007);
            }
        });
        this.lJb.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.phonenumber.a.AnonymousClass2 */
            final /* synthetic */ a nyI;

            {
                this.nyI = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(148008);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b bVar2 = this.nyI.nyF;
                if (bVar2 != null) {
                    bVar2.yU(2);
                }
                m mVar = this.nyI.lJc;
                if (mVar != null) {
                    mVar.c(this.nyI);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(148008);
            }
        });
        this.mRecyclerView.setItemAnimator(null);
        AppMethodBeat.o(148015);
    }

    public final void setIconUrl(String str) {
        AppMethodBeat.i(230132);
        this.iconUrl = str;
        com.tencent.mm.modelappbrand.a.b.aXY().a(this.lIM, this.iconUrl, R.drawable.cg_, g.iJB);
        AppMethodBeat.o(230132);
    }

    public final void a(View.OnClickListener onClickListener) {
        AppMethodBeat.i(230133);
        this.nyD.setOnClickListener(onClickListener);
        AppMethodBeat.o(230133);
    }

    public final void setAppBrandName(String str) {
        AppMethodBeat.i(230134);
        this.lJe = str;
        this.jVh.setText(str != null ? str : "");
        AppMethodBeat.o(230134);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public boolean bjb() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void a(m mVar) {
        AppMethodBeat.i(148009);
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
            Context context = this.jBN.getContext();
            p.g(context, "mRootView.context");
            View view = this.jBN;
            View view2 = this.lIZ;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            p.g(defaultDisplay, "it.defaultDisplay");
            n.a(context, view, view2, defaultDisplay.getRotation(), false);
            AppMethodBeat.o(148009);
            return;
        }
        AppMethodBeat.o(148009);
    }

    public void onDismiss() {
        AppMethodBeat.i(148010);
        DialogInterface.OnDismissListener onDismissListener = this.XZ;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
            AppMethodBeat.o(148010);
            return;
        }
        AppMethodBeat.o(148010);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void ut(int i2) {
        AppMethodBeat.i(148011);
        n nVar = n.JjY;
        Context context = this.jBN.getContext();
        p.g(context, "mRootView.context");
        n.a(context, this.jBN, this.lIZ, i2, false);
        AppMethodBeat.o(148011);
    }

    public void dismiss() {
        AppMethodBeat.i(148012);
        super.dismiss();
        onDismiss();
        AppMethodBeat.o(148012);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void onCancel() {
        AppMethodBeat.i(148013);
        b bVar = this.nyF;
        if (bVar != null) {
            bVar.yU(3);
            AppMethodBeat.o(148013);
            return;
        }
        AppMethodBeat.o(148013);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjc() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean isCancelable() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final View getContentView() {
        return this.jBN;
    }

    public final void setPosition(int i2) {
        AppMethodBeat.i(230135);
        this.jCs = i2;
        switch (i2) {
            case 1:
                this.jBN.setBackground(android.support.v4.content.b.l(getContext(), R.drawable.eh));
                AppMethodBeat.o(230135);
                return;
            case 2:
                this.jBN.setBackground(android.support.v4.content.b.l(getContext(), R.drawable.eg));
                break;
        }
        AppMethodBeat.o(230135);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final int getPosition() {
        return this.jCs;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Companion;", "", "()V", "ALERT_RESULT_CODE_ACCEPT", "", "ALERT_RESULT_CODE_CANCEL", "ALERT_RESULT_CODE_REJECT", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.a$a  reason: collision with other inner class name */
    public static final class C0782a {
        private C0782a() {
        }

        public /* synthetic */ C0782a(byte b2) {
            this();
        }
    }
}
