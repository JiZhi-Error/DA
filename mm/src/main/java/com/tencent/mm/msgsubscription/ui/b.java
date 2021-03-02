package com.tencent.mm.msgsubscription.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.msgsubscription.ui.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00012\u00020\u0001:\n\u0001\u0001\u0001\u0001\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010l\u001a\u00020m2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0006\u0010n\u001a\u00020\nJ\u0010\u0010o\u001a\u00020m2\u0006\u0010p\u001a\u00020\rH\u0002J\b\u0010q\u001a\u00020mH\u0016J\b\u0010r\u001a\u00020\nH\u0002J\b\u0010s\u001a\u00020mH\u0016J\b\u0010t\u001a\u00020mH\u0002J\u0010\u0010u\u001a\u00020m2\u0006\u0010v\u001a\u00020\rH\u0002J\b\u0010w\u001a\u00020 H\u0016J\b\u0010x\u001a\u00020\rH\u0016J\b\u0010y\u001a\u00020\rH\u0002J\b\u0010z\u001a\u00020\nH\u0016J\b\u0010{\u001a\u00020\nH\u0016J\b\u0010|\u001a\u00020\nH\u0016J\b\u0010}\u001a\u00020mH\u0016J\u0010\u0010~\u001a\u00020m2\u0006\u0010\u001a\u00020\rH\u0002J\t\u0010\u0001\u001a\u00020mH\u0016J\u0011\u0010\u0001\u001a\u00020m2\u0006\u0010p\u001a\u00020\rH\u0016J\u0014\u0010\u0001\u001a\u00020m2\t\u0010\u0001\u001a\u0004\u0018\u00010/H\u0016J\u0010\u0010\u0001\u001a\u00020m2\u0007\u0010\u0001\u001a\u00020\rJ\u0012\u0010\u0001\u001a\u00020m2\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\u001f\u0010\u0001\u001a\u00020m2\u0007\u0010\u0001\u001a\u00020\n2\u000b\b\u0002\u0010\u0007\u001a\u0005\u0018\u00010\u0001H\u0002J\r\u0010\u0001\u001a\u00020m*\u00020\u0016H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u000e\u0010\u001e\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R$\u0010!\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u000e\u0010$\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u000e\u0010(\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R$\u0010+\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u00100\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0012\"\u0004\b7\u0010\u0014R\u000e\u00108\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R(\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u000e\u001a\u0004\u0018\u000109@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u000e¢\u0006\u0002\n\u0000R$\u0010D\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0012\"\u0004\bF\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060GX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R$\u0010J\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0012\"\u0004\bL\u0010\u0014R\u000e\u0010M\u001a\u00020AX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0012\"\u0004\bS\u0010\u0014R\u0012\u0010T\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010UR\u000e\u0010V\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020XX\u000e¢\u0006\u0002\n\u0000R$\u0010Y\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010^\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010[\"\u0004\b`\u0010]R\u001c\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010g\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0012\"\u0004\bi\u0010\u0014R\u000e\u0010j\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "isSingleMode", "", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;Z)V", "_position", "", "value", "", "actionDesc", "getActionDesc", "()Ljava/lang/String;", "setActionDesc", "(Ljava/lang/String;)V", "actionTv", "Landroid/widget/TextView;", "adapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "alwaysKeepCb", "Landroid/widget/CheckBox;", "alwaysKeepText", "getAlwaysKeepText", "setAlwaysKeepText", "alwaysKeepTv", "alwaysKeepView", "Landroid/view/View;", "alwaysRejectText", "getAlwaysRejectText", "setAlwaysRejectText", "alwaysRejectTv", "appName", "getAppName", "setAppName", "appNameTv", "cancelBtn", "Landroid/widget/Button;", "cancelBtnText", "getCancelBtnText", "setCancelBtnText", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "defaultIconRes", "getDefaultIconRes", "()I", "setDefaultIconRes", "(I)V", "desc", "getDesc", "setDesc", "descTV", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "dialogListener", "getDialogListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "setDialogListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;)V", "dialogView", "dialogViewContainer", "Landroid/widget/FrameLayout;", "iconIv", "Landroid/widget/ImageView;", "iconUrl", "getIconUrl", "setIconUrl", "", "mRootView", "okBtn", "okBtnText", "getOkBtnText", "setOkBtnText", "recyclerViewContainer", "sampleBack", "sampleRoot", "sampleShowing", "sampleTitle", "getSampleTitle", "setSampleTitle", "sampleViewId", "Ljava/lang/Integer;", "sampleViewTitle", "scrollView", "Landroid/widget/ScrollView;", "showAlwaysKeepView", "getShowAlwaysKeepView", "()Z", "setShowAlwaysKeepView", "(Z)V", "showAlwaysRejectView", "getShowAlwaysRejectView", "setShowAlwaysRejectView", "templateShowSampleListener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "getTemplateShowSampleListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "setTemplateShowSampleListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;)V", "tip", "getTip", "setTip", "tipTv", "topSampleBtn", "addRecyclerView", "", "alwaysKeepSelected", "applyRotation", "rotation", "cancel", "closeSampleView", "dismiss", "dispatchCancelEvent", "dispatchEvent", "event", "getContentView", "getPosition", "getRotation", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onCheckedCountChanged", "size", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setPosition", "position", "showSample", "item", "startSampleAnimation", "show", "Landroid/animation/Animator$AnimatorListener;", "setBoldStyle", "Companion", "Item", "ItemAdapter", "Listener", "SubscribeRequestDialogListener", "wxbiz-msgsubscription-sdk_release"})
public class b implements com.tencent.mm.plugin.appbrand.widget.dialog.k {
    public static final a jCu = new a((byte) 0);
    private String appName = "";
    private final Context context;
    private String desc = "";
    private ImageView gBZ;
    private ScrollView gxx;
    private Button hPX;
    private Button hSq;
    private TextView hVv;
    private List<C0477b> iHf = new ArrayList();
    private String iconUrl = "";
    private View jBN;
    private FrameLayout jBO;
    private c jBP;
    private TextView jBQ;
    private TextView jBR;
    private TextView jBS;
    private View jBT;
    private FrameLayout jBU;
    private View jBV;
    private View jBW;
    private TextView jBX;
    public TextView jBY;
    public View jBZ;
    public CheckBox jCa;
    private TextView jCb;
    private View jCc;
    private boolean jCd;
    private Integer jCe;
    private m jCf;
    public a.AbstractC0476a jCg;
    private String jCh = "";
    private String jCi = "";
    public boolean jCj = true;
    private String jCk = "";
    public boolean jCl = true;
    private String jCm = "";
    private String jCn = "";
    private String jCo = "";
    private String jCp = "";
    public int jCq;
    public e jCr;
    private int jCs;
    private d jCt;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "", "onDismiss", "", "onShow", "wxbiz-msgsubscription-sdk_release"})
    public interface e {
        void onDismiss();

        void onShow();
    }

    static {
        AppMethodBeat.i(149783);
        AppMethodBeat.o(149783);
    }

    public b(Context context2, final List<C0477b> list, d dVar, boolean z) {
        p.h(context2, "context");
        p.h(list, "items");
        AppMethodBeat.i(149782);
        this.context = context2;
        this.jCt = dVar;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.c15, (ViewGroup) null);
        p.g(inflate, "LayoutInflater.from(cont…msg_request_dialog, null)");
        this.jBN = inflate;
        View findViewById = this.jBN.findViewById(R.id.e2v);
        p.g(findViewById, "mRootView.findViewById(R.id.item_list_container)");
        this.jBO = (FrameLayout) findViewById;
        View findViewById2 = this.jBN.findViewById(R.id.hcs);
        p.g(findViewById2, "mRootView.findViewById(R.id.scroll_view)");
        this.gxx = (ScrollView) findViewById2;
        View findViewById3 = this.jBN.findViewById(R.id.dtx);
        p.g(findViewById3, "mRootView.findViewById(R.id.icon_iv)");
        this.gBZ = (ImageView) findViewById3;
        View findViewById4 = this.jBN.findViewById(R.id.c0);
        p.g(findViewById4, "mRootView.findViewById(R.id.action)");
        this.hVv = (TextView) findViewById4;
        View findViewById5 = this.jBN.findViewById(R.id.bmr);
        p.g(findViewById5, "mRootView.findViewById(R.id.desc)");
        this.jBR = (TextView) findViewById5;
        View findViewById6 = this.jBN.findViewById(R.id.io4);
        p.g(findViewById6, "mRootView.findViewById(R.id.tip)");
        this.jBS = (TextView) findViewById6;
        View findViewById7 = this.jBN.findViewById(R.id.sa);
        p.g(findViewById7, "mRootView.findViewById(R.id.app_name_tv)");
        this.jBQ = (TextView) findViewById7;
        View findViewById8 = this.jBN.findViewById(R.id.bqq);
        p.g(findViewById8, "mRootView.findViewById(R.id.dialog_cancel)");
        this.hSq = (Button) findViewById8;
        View findViewById9 = this.jBN.findViewById(R.id.br3);
        p.g(findViewById9, "mRootView.findViewById(R.id.dialog_ok)");
        this.hPX = (Button) findViewById9;
        View findViewById10 = this.jBN.findViewById(R.id.h_8);
        p.g(findViewById10, "mRootView.findViewById(R.id.sample_root)");
        this.jBT = findViewById10;
        View findViewById11 = this.jBN.findViewById(R.id.h_9);
        p.g(findViewById11, "mRootView.findViewById(R.id.sample_view_title)");
        this.jCb = (TextView) findViewById11;
        View findViewById12 = this.jBN.findViewById(R.id.br7);
        p.g(findViewById12, "mRootView.findViewById(R.id.dialog_view_container)");
        this.jBU = (FrameLayout) findViewById12;
        View findViewById13 = this.jBN.findViewById(R.id.br6);
        p.g(findViewById13, "mRootView.findViewById(R.id.dialog_view)");
        this.jBV = findViewById13;
        View findViewById14 = this.jBN.findViewById(R.id.h_7);
        p.g(findViewById14, "mRootView.findViewById(R.id.sample_back)");
        this.jBW = findViewById14;
        View findViewById15 = this.jBN.findViewById(R.id.m4);
        p.g(findViewById15, "mRootView.findViewById(R.id.always_keep_tv)");
        this.jBX = (TextView) findViewById15;
        View findViewById16 = this.jBN.findViewById(R.id.g3x);
        p.g(findViewById16, "mRootView.findViewById(R…_type_always_keep_layout)");
        this.jBZ = findViewById16;
        View findViewById17 = this.jBN.findViewById(R.id.m3);
        p.g(findViewById17, "mRootView.findViewById(R.id.always_keep_checkbox)");
        this.jCa = (CheckBox) findViewById17;
        View findViewById18 = this.jBN.findViewById(R.id.m5);
        p.g(findViewById18, "mRootView.findViewById(R.id.always_reject_tv)");
        this.jBY = (TextView) findViewById18;
        View findViewById19 = this.jBN.findViewById(R.id.it6);
        p.g(findViewById19, "mRootView.findViewById(R.id.top_sample)");
        this.jCc = findViewById19;
        this.jBN.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
            /* class com.tencent.mm.msgsubscription.ui.b.AnonymousClass1 */
            final /* synthetic */ b jCv;

            {
                this.jCv = r1;
            }

            public final void onGlobalLayout() {
                AppMethodBeat.i(149735);
                ViewParent parent = this.jCv.jBN.getParent();
                if (parent == null) {
                    AppMethodBeat.o(149735);
                } else if (parent == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(149735);
                    throw tVar;
                } else {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int h2 = b.h(this.jCv);
                    if (h2 != 1 && h2 != 3) {
                        int height = viewGroup.getHeight() - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 60);
                        if (this.jCv.jBN.getHeight() > height) {
                            this.jCv.jBN.getLayoutParams().height = Math.min(height, this.jCv.jBN.getHeight());
                            this.jCv.jBN.requestLayout();
                        }
                    } else if (this.jCv.jBN.getLayoutParams().height != -2) {
                        this.jCv.jBN.getLayoutParams().height = -2;
                        this.jCv.jBN.requestLayout();
                        AppMethodBeat.o(149735);
                        return;
                    }
                    AppMethodBeat.o(149735);
                }
            }
        });
        this.jBU.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
            /* class com.tencent.mm.msgsubscription.ui.b.AnonymousClass2 */
            final /* synthetic */ b jCv;

            {
                this.jCv = r1;
            }

            public final void onGlobalLayout() {
                AppMethodBeat.i(149736);
                if (this.jCv.jBU.getHeight() > 0) {
                    this.jCv.jBT.getLayoutParams().height = this.jCv.jBU.getHeight();
                }
                AppMethodBeat.o(149736);
            }
        });
        this.iHf.addAll(list);
        if (z) {
            this.jBO.setVisibility(8);
            this.jCc.setVisibility(0);
            this.jCc.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.msgsubscription.ui.b.AnonymousClass3 */
                final /* synthetic */ b jCv;

                {
                    this.jCv = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(149737);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    b.a(this.jCv, (C0477b) list.get(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(149737);
                }
            });
        }
        aK(list);
        this.hPX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.msgsubscription.ui.b.AnonymousClass4 */
            final /* synthetic */ b jCv;

            {
                this.jCv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(149738);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.b(this.jCv, 1);
                this.jCv.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(149738);
            }
        });
        this.hSq.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.msgsubscription.ui.b.AnonymousClass5 */
            final /* synthetic */ b jCv;

            {
                this.jCv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(149739);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.jCv.cancel();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(149739);
            }
        });
        this.jBZ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.msgsubscription.ui.b.AnonymousClass6 */
            final /* synthetic */ b jCv;

            {
                this.jCv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(149740);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.jCv.jCa.setChecked(!this.jCv.jCa.isChecked());
                for (C0477b bVar2 : list) {
                    bVar2.jCw = this.jCv.jCa.isChecked();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(149740);
            }
        });
        this.jBY.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.msgsubscription.ui.b.AnonymousClass7 */
            final /* synthetic */ b jCv;

            {
                this.jCv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(149741);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.b(this.jCv, 3);
                this.jCv.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(149741);
            }
        });
        this.jCs = 2;
        AppMethodBeat.o(149782);
    }

    public static final /* synthetic */ void a(b bVar, List list) {
        AppMethodBeat.i(149787);
        bVar.aK(list);
        AppMethodBeat.o(149787);
    }

    public static final /* synthetic */ void b(b bVar, int i2) {
        AppMethodBeat.i(149789);
        bVar.us(i2);
        AppMethodBeat.o(149789);
    }

    public static final /* synthetic */ boolean c(b bVar) {
        AppMethodBeat.i(149786);
        boolean bja = bVar.bja();
        AppMethodBeat.o(149786);
        return bja;
    }

    public static final /* synthetic */ int h(b bVar) {
        AppMethodBeat.i(149788);
        int rotation = bVar.getRotation();
        AppMethodBeat.o(149788);
        return rotation;
    }

    public final void setIconUrl(String str) {
        AppMethodBeat.i(149761);
        p.h(str, "value");
        this.iconUrl = str;
        AppMethodBeat.o(149761);
    }

    public final void RD(String str) {
        AppMethodBeat.i(149762);
        p.h(str, "value");
        this.appName = str;
        this.jBQ.setText(this.appName);
        g(this.jBQ);
        AppMethodBeat.o(149762);
    }

    public final void RE(String str) {
        AppMethodBeat.i(194267);
        p.h(str, "<set-?>");
        this.jCh = str;
        AppMethodBeat.o(194267);
    }

    public final void RF(String str) {
        AppMethodBeat.i(194268);
        p.h(str, "value");
        this.jCi = str;
        this.jBZ.setVisibility(0);
        this.jBX.setText(this.jCi);
        this.jBY.setVisibility(8);
        AppMethodBeat.o(194268);
    }

    public final void RG(String str) {
        AppMethodBeat.i(194269);
        p.h(str, "value");
        this.jCk = str;
        this.jBY.setVisibility(0);
        this.jBY.setText(this.jCk);
        this.jBZ.setVisibility(8);
        AppMethodBeat.o(194269);
    }

    public final void RH(String str) {
        AppMethodBeat.i(149763);
        p.h(str, "value");
        this.jCm = str;
        this.hVv.setText(this.jCm);
        g(this.hVv);
        AppMethodBeat.o(149763);
    }

    public final void setDesc(String str) {
        AppMethodBeat.i(149764);
        p.h(str, "value");
        this.desc = str;
        this.jBR.setText(this.desc);
        AppMethodBeat.o(149764);
    }

    public final void RI(String str) {
        AppMethodBeat.i(149765);
        p.h(str, "value");
        this.jCn = str;
        this.hPX.setText(this.jCn);
        AppMethodBeat.o(149765);
    }

    public final void RJ(String str) {
        AppMethodBeat.i(149766);
        p.h(str, "value");
        this.jCo = str;
        this.hSq.setText(this.jCo);
        AppMethodBeat.o(149766);
    }

    public final void RK(String str) {
        boolean z;
        AppMethodBeat.i(149767);
        p.h(str, "value");
        this.jCp = str;
        this.jBS.setText(this.jCp);
        TextView textView = this.jBS;
        if (this.jCp.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        textView.setVisibility(z ? 8 : 0);
        AppMethodBeat.o(149767);
    }

    private static void g(TextView textView) {
        AppMethodBeat.i(149768);
        TextPaint paint = textView.getPaint();
        p.g(paint, "paint");
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        TextPaint paint2 = textView.getPaint();
        p.g(paint2, "paint");
        paint2.setStrokeWidth(0.8f);
        AppMethodBeat.o(149768);
    }

    private final void aK(List<C0477b> list) {
        AppMethodBeat.i(149769);
        RecyclerView recyclerView = new RecyclerView(this.context);
        this.jBO.removeAllViews();
        this.jBO.addView(recyclerView, new ViewGroup.LayoutParams(-1, -2));
        this.jBP = new c(list, this);
        c cVar = this.jBP;
        if (cVar == null) {
            p.btv("adapter");
        }
        recyclerView.setAdapter(cVar);
        recyclerView.setLayoutManager(new LinearLayoutManager());
        recyclerView.b(new f(this));
        AppMethodBeat.o(149769);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u0019"}, hxF = {"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addRecyclerView$divider$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paddingLeft", "", "getPaddingLeft", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "strokeWidth", "getStrokeWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "wxbiz-msgsubscription-sdk_release"})
    public static final class f extends RecyclerView.h {
        final /* synthetic */ b jCv;
        private final int paddingLeft = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
        private final Paint paint = new Paint();
        private final int strokeWidth = 2;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(b bVar) {
            this.jCv = bVar;
            AppMethodBeat.i(149756);
            this.paint.setColor(bVar.context.getResources().getColor(R.color.lx));
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setFlags(1);
            this.paint.setStrokeWidth((float) this.strokeWidth);
            AppMethodBeat.o(149756);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(149754);
            p.h(canvas, "c");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            super.a(canvas, recyclerView, sVar);
            float paddingLeft2 = (float) recyclerView.getPaddingLeft();
            float width = (float) (recyclerView.getWidth() - recyclerView.getPaddingRight());
            int childCount = recyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                p.g(childAt, "child");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                    AppMethodBeat.o(149754);
                    throw tVar;
                }
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                float bottom = ((float) childAt.getBottom()) + ((float) layoutParams2.bottomMargin) + ((float) this.strokeWidth);
                if (i2 == 0) {
                    float top = (((float) layoutParams2.topMargin) + ((float) childAt.getTop())) - ((float) this.strokeWidth);
                    if (canvas != null) {
                        canvas.drawLine(paddingLeft2, top, width, top, this.paint);
                    }
                }
                if (i2 == recyclerView.getChildCount() - 1) {
                    if (canvas != null) {
                        canvas.drawLine(paddingLeft2, bottom, width, bottom, this.paint);
                    }
                } else if (canvas != null) {
                    canvas.drawLine(paddingLeft2 + ((float) this.paddingLeft), bottom, width, bottom, this.paint);
                }
            }
            AppMethodBeat.o(149754);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(149755);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            if (RecyclerView.bw(view) == 0) {
                rect.set(0, this.strokeWidth, 0, this.strokeWidth);
                AppMethodBeat.o(149755);
                return;
            }
            rect.set(0, 0, 0, this.strokeWidth);
            AppMethodBeat.o(149755);
        }
    }

    private final int getRotation() {
        AppMethodBeat.i(149770);
        Object systemService = this.context.getSystemService("window");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(149770);
            throw tVar;
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        p.g(defaultDisplay, "(context.getSystemServic…owManager).defaultDisplay");
        int rotation = defaultDisplay.getRotation();
        AppMethodBeat.o(149770);
        return rotation;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$1"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ b jCv;

        j(b bVar) {
            this.jCv = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(149759);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.c(this.jCv);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(149759);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
    public static final class k implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ b jCv;

        k(b bVar) {
            this.jCv = bVar;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(149760);
            this.jCv.jBT.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            b.a(this.jCv);
            AppMethodBeat.o(149760);
        }
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(194270);
        bVar.a(true, (Animator.AnimatorListener) null);
        AppMethodBeat.o(194270);
    }

    private final void a(boolean z, Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(149771);
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.jBU, View.TRANSLATION_X, 0.0f, -((float) this.jBU.getWidth())).setDuration(200L);
            p.g(duration, LocaleUtil.ITALIAN);
            duration.setInterpolator(new com.tencent.mm.msgsubscription.ui.a.a());
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.jBT, View.TRANSLATION_X, (float) this.jBT.getWidth(), 0.0f).setDuration(200L);
            p.g(duration2, LocaleUtil.ITALIAN);
            duration2.setInterpolator(new com.tencent.mm.msgsubscription.ui.a.a());
            animatorSet.playTogether(duration, duration2);
        } else {
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.jBU, View.TRANSLATION_X, -((float) this.jBU.getWidth()), 0.0f).setDuration(200L);
            p.g(duration3, LocaleUtil.ITALIAN);
            duration3.setInterpolator(new com.tencent.mm.msgsubscription.ui.a.a());
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.jBT, View.TRANSLATION_X, 0.0f, (float) this.jBT.getWidth()).setDuration(200L);
            p.g(duration4, LocaleUtil.ITALIAN);
            duration4.setInterpolator(new com.tencent.mm.msgsubscription.ui.a.a());
            animatorSet.playTogether(duration3, duration4);
        }
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        animatorSet.start();
        AppMethodBeat.o(149771);
    }

    private final boolean bja() {
        AppMethodBeat.i(149773);
        if (this.jCd) {
            a(false, (Animator.AnimatorListener) new i(this));
            this.jCd = false;
            AppMethodBeat.o(149773);
            return true;
        }
        AppMethodBeat.o(149773);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$closeSampleView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "wxbiz-msgsubscription-sdk_release"})
    public static final class i extends AnimatorListenerAdapter {
        final /* synthetic */ b jCv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(b bVar) {
            this.jCv = bVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(149758);
            Integer num = this.jCv.jCe;
            if (num != null) {
                View findViewById = this.jCv.jBT.findViewById(num.intValue());
                if (findViewById != null) {
                    ((LinearLayout) this.jCv.jBT.findViewById(R.id.be3)).removeView(findViewById);
                    AppMethodBeat.o(149758);
                    return;
                }
                AppMethodBeat.o(149758);
                return;
            }
            AppMethodBeat.o(149758);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjb() {
        AppMethodBeat.i(149774);
        boolean bja = bja();
        AppMethodBeat.o(149774);
        return bja;
    }

    public void dismiss() {
        AppMethodBeat.i(149775);
        m mVar = this.jCf;
        if (mVar != null) {
            mVar.c(this);
        }
        e eVar = this.jCr;
        if (eVar != null) {
            eVar.onDismiss();
            AppMethodBeat.o(149775);
            return;
        }
        AppMethodBeat.o(149775);
    }

    public final void setPosition(int i2) {
        AppMethodBeat.i(194271);
        this.jCs = i2;
        switch (i2) {
            case 1:
                View findViewById = this.jBN.findViewById(R.id.br8);
                p.g(findViewById, "mRootView.findViewById<V…alog_view_root_container)");
                findViewById.setBackground(android.support.v4.content.b.l(this.context, R.drawable.ay4));
                AppMethodBeat.o(194271);
                return;
            case 2:
                View findViewById2 = this.jBN.findViewById(R.id.br8);
                p.g(findViewById2, "mRootView.findViewById<V…alog_view_root_container)");
                findViewById2.setBackground(android.support.v4.content.b.l(this.context, R.drawable.ay3));
                break;
        }
        AppMethodBeat.o(194271);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final int getPosition() {
        return this.jCs;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void a(m mVar) {
        AppMethodBeat.i(149776);
        com.tencent.mm.modelappbrand.a.b.aXY().a(this.gBZ, this.iconUrl, this.jCq, new com.tencent.mm.modelappbrand.a.e());
        this.jCf = mVar;
        uu(getRotation());
        e eVar = this.jCr;
        if (eVar != null) {
            eVar.onShow();
            AppMethodBeat.o(149776);
            return;
        }
        AppMethodBeat.o(149776);
    }

    private final void us(int i2) {
        AppMethodBeat.i(149778);
        Log.i("SubscribeMsgRequestDialog", "dispatchEvent ".concat(String.valueOf(i2)));
        d dVar = this.jCt;
        if (dVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iHf);
            dVar.c(i2, arrayList);
            AppMethodBeat.o(149778);
            return;
        }
        AppMethodBeat.o(149778);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjc() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public boolean isCancelable() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final View getContentView() {
        return this.jBN;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void ut(int i2) {
        AppMethodBeat.i(149780);
        uu(i2);
        AppMethodBeat.o(149780);
    }

    private final void uu(int i2) {
        AppMethodBeat.i(149781);
        if (i2 == 1 || i2 == 3) {
            View view = this.jBN;
            ViewGroup.LayoutParams layoutParams = this.jBN.getLayoutParams();
            layoutParams.width = c.dj(this.context);
            view.setLayoutParams(layoutParams);
            if (this.gxx.indexOfChild(this.jBV) == -1) {
                ViewParent parent = this.jBV.getParent();
                if (parent != null) {
                    if (parent == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(149781);
                        throw tVar;
                    }
                    ((ViewGroup) parent).removeView(this.jBV);
                }
                this.gxx.addView(this.jBV);
                this.gxx.setVisibility(0);
            }
        } else {
            if (c.dk(this.context)) {
                c.a(this.jBN, new g(this));
            } else {
                View view2 = this.jBN;
                ViewGroup.LayoutParams layoutParams2 = this.jBN.getLayoutParams();
                layoutParams2.width = -1;
                view2.setLayoutParams(layoutParams2);
            }
            if (this.jBU.indexOfChild(this.jBV) == -1) {
                ViewParent parent2 = this.jBV.getParent();
                if (parent2 != null) {
                    if (parent2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(149781);
                        throw tVar2;
                    }
                    ((ViewGroup) parent2).removeView(this.jBV);
                }
                this.jBU.addView(this.jBV);
                this.gxx.setVisibility(8);
            }
        }
        this.jBN.getViewTreeObserver().addOnGlobalLayoutListener(new h(this));
        AppMethodBeat.o(149781);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$applyRotation$6", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
    public static final class h implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ b jCv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(b bVar) {
            this.jCv = bVar;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(174567);
            this.jCv.jBN.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            b.a(this.jCv, this.jCv.iHf);
            AppMethodBeat.o(174567);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "Companion", "wxbiz-msgsubscription-sdk_release"})
    public interface d {
        public static final a jCF = a.jCG;

        void c(int i2, List<C0477b> list);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener$Companion;", "", "()V", "EVENT_ALWAYS_REJECT", "", "EVENT_CANCEL", "EVENT_OK", "wxbiz-msgsubscription-sdk_release"})
        public static final class a {
            static final /* synthetic */ a jCG = new a();

            static {
                AppMethodBeat.i(149753);
                AppMethodBeat.o(149753);
            }

            private a() {
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "dialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "(Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "itemsChecked", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "wxbiz-msgsubscription-sdk_release"})
    public static final class c extends RecyclerView.a<a> {
        List<C0477b> iHf;
        private final b jCA;
        private final List<C0477b> jCz = new ArrayList();

        public c(List<C0477b> list, b bVar) {
            p.h(list, "items");
            p.h(bVar, "dialog");
            AppMethodBeat.i(149752);
            this.iHf = list;
            this.jCA = bVar;
            List<C0477b> list2 = this.jCz;
            ArrayList arrayList = new ArrayList();
            for (T t : this.iHf) {
                if (t.jCx) {
                    arrayList.add(t);
                }
            }
            list2.addAll(arrayList);
            b.a(this.jCA, this.jCz.size());
            AppMethodBeat.o(149752);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(149749);
            p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c13, (ViewGroup) null);
            p.g(inflate, "LayoutInflater.from(pare…be_msg_item_layout, null)");
            a aVar = new a(inflate);
            AppMethodBeat.o(149749);
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(a aVar, int i2) {
            AppMethodBeat.i(149751);
            a aVar2 = aVar;
            p.h(aVar2, "holder");
            aVar2.checkBox.setChecked(this.iHf.get(i2).jCx);
            aVar2.jCB.setText(this.iHf.get(i2).title);
            aVar2.jCC.setOnClickListener(new View$OnClickListenerC0478b(this, i2));
            aVar2.aus.setOnClickListener(new View$OnClickListenerC0479c(this, aVar2, i2));
            AppMethodBeat.o(149751);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(149750);
            int size = this.iHf.size();
            AppMethodBeat.o(149750);
            return size;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.msgsubscription.ui.b$c$b  reason: collision with other inner class name */
        static final class View$OnClickListenerC0478b implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ c jCD;

            View$OnClickListenerC0478b(c cVar, int i2) {
                this.jCD = cVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(149747);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a(this.jCD.jCA, this.jCD.iHf.get(this.gUj));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(149747);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.msgsubscription.ui.b$c$c  reason: collision with other inner class name */
        static final class View$OnClickListenerC0479c implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ c jCD;
            final /* synthetic */ a jCE;

            View$OnClickListenerC0479c(c cVar, a aVar, int i2) {
                this.jCD = cVar;
                this.jCE = aVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(149748);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.jCE.checkBox.setChecked(!this.jCE.checkBox.isChecked());
                this.jCD.iHf.get(this.gUj).jCx = this.jCE.checkBox.isChecked();
                if (this.jCD.iHf.get(this.gUj).jCx) {
                    this.jCD.jCz.add(this.jCD.iHf.get(this.gUj));
                } else {
                    this.jCD.jCz.remove(this.jCD.iHf.get(this.gUj));
                }
                b.a(this.jCD.jCA, this.jCD.jCz.size());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(149748);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "sample", "getSample", "()Landroid/view/View;", "setSample", "wxbiz-msgsubscription-sdk_release"})
        public static final class a extends RecyclerView.v {
            CheckBox checkBox;
            TextView jCB;
            View jCC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(View view) {
                super(view);
                p.h(view, "item");
                AppMethodBeat.i(149746);
                View findViewById = this.aus.findViewById(R.id.b0m);
                p.g(findViewById, "itemView.findViewById(R.id.checkbox)");
                this.checkBox = (CheckBox) findViewById;
                View findViewById2 = this.aus.findViewById(R.id.bmr);
                p.g(findViewById2, "itemView.findViewById(R.id.desc)");
                this.jCB = (TextView) findViewById2;
                View findViewById3 = this.aus.findViewById(R.id.h_6);
                p.g(findViewById3, "itemView.findViewById(R.id.sample)");
                this.jCC = findViewById3;
                AppMethodBeat.o(149746);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u001b\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006!"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "check", "", "title", "", "sampleWordings", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "templateId", "(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "alwaysKeep", "getAlwaysKeep", "()Z", "setAlwaysKeep", "(Z)V", "getCheck", "setCheck", "getSampleWordings", "()Ljava/util/ArrayList;", "getTemplateId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "wxbiz-msgsubscription-sdk_release"})
    /* renamed from: com.tencent.mm.msgsubscription.ui.b$b  reason: collision with other inner class name */
    public static final class C0477b {
        public final String ixM;
        boolean jCw;
        public boolean jCx;
        final ArrayList<o<String, String>> jCy;
        final String title;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
            if (kotlin.g.b.p.j(r3.ixM, r4.ixM) != false) goto L_0x0032;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 149745(0x248f1, float:2.09837E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0032
                boolean r0 = r4 instanceof com.tencent.mm.msgsubscription.ui.b.C0477b
                if (r0 == 0) goto L_0x0037
                com.tencent.mm.msgsubscription.ui.b$b r4 = (com.tencent.mm.msgsubscription.ui.b.C0477b) r4
                boolean r0 = r3.jCx
                boolean r1 = r4.jCx
                if (r0 != r1) goto L_0x0037
                java.lang.String r0 = r3.title
                java.lang.String r1 = r4.title
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0037
                java.util.ArrayList<kotlin.o<java.lang.String, java.lang.String>> r0 = r3.jCy
                java.util.ArrayList<kotlin.o<java.lang.String, java.lang.String>> r1 = r4.jCy
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0037
                java.lang.String r0 = r3.ixM
                java.lang.String r1 = r4.ixM
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0037
            L_0x0032:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0036:
                return r0
            L_0x0037:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0036
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.msgsubscription.ui.b.C0477b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(149744);
            boolean z = this.jCx;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = i3 * 31;
            String str = this.title;
            int hashCode = ((str != null ? str.hashCode() : 0) + i6) * 31;
            ArrayList<o<String, String>> arrayList = this.jCy;
            int hashCode2 = ((arrayList != null ? arrayList.hashCode() : 0) + hashCode) * 31;
            String str2 = this.ixM;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i7 = hashCode2 + i2;
            AppMethodBeat.o(149744);
            return i7;
        }

        public final String toString() {
            AppMethodBeat.i(149743);
            String str = "Item(check=" + this.jCx + ", title=" + this.title + ", sampleWordings=" + this.jCy + ", templateId=" + this.ixM + ")";
            AppMethodBeat.o(149743);
            return str;
        }

        public C0477b(boolean z, String str, ArrayList<o<String, String>> arrayList, String str2) {
            p.h(str, "title");
            p.h(arrayList, "sampleWordings");
            p.h(str2, "templateId");
            AppMethodBeat.i(149742);
            this.jCx = z;
            this.title = str;
            this.jCy = arrayList;
            this.ixM = str2;
            AppMethodBeat.o(149742);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion;", "", "()V", "TAG", "", "Rotation", "TemplateShowSampleListener", "wxbiz-msgsubscription-sdk_release"})
    public static final class a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "", "onSampleShow", "", "templateId", "", "check", "", FirebaseAnalytics.b.INDEX, "", "wxbiz-msgsubscription-sdk_release"})
        /* renamed from: com.tencent.mm.msgsubscription.ui.b$a$a  reason: collision with other inner class name */
        public interface AbstractC0476a {
            void aC(String str, int i2);
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void onCancel() {
        AppMethodBeat.i(149777);
        us(2);
        AppMethodBeat.o(149777);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b jCv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(b bVar) {
            super(0);
            this.jCv = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(174566);
            ViewGroup.LayoutParams layoutParams = this.jCv.jBN.getLayoutParams();
            Context context = this.jCv.context;
            int measuredWidth = this.jCv.jBN.getMeasuredWidth();
            int dj = c.dj(context);
            Resources resources = context.getResources();
            p.g(resources, "context.resources");
            int max = Math.max(dj, resources.getDisplayMetrics().widthPixels / 2);
            if (measuredWidth >= dj) {
                if (measuredWidth > max) {
                    dj = max;
                } else {
                    dj = measuredWidth;
                }
            }
            Resources resources2 = context.getResources();
            p.g(resources2, "context.resources");
            layoutParams.width = Math.min(dj, resources2.getDisplayMetrics().widthPixels);
            MMHandlerThread.postToMainThread(new c.b(this.jCv.jBN));
            x xVar = x.SXb;
            AppMethodBeat.o(174566);
            return xVar;
        }
    }

    public void cancel() {
        AppMethodBeat.i(149779);
        us(2);
        dismiss();
        AppMethodBeat.o(149779);
    }

    public static final /* synthetic */ void a(b bVar, C0477b bVar2) {
        AppMethodBeat.i(149784);
        if (!bVar.jCd) {
            com.tencent.mm.msgsubscription.util.b bVar3 = com.tencent.mm.msgsubscription.util.b.jDg;
            View a2 = com.tencent.mm.msgsubscription.util.b.a(bVar.context, bVar2.jCy);
            a2.setId(View.generateViewId());
            bVar.jCe = Integer.valueOf(a2.getId());
            ((LinearLayout) bVar.jBT.findViewById(R.id.be3)).addView(a2);
            bVar.jBT.setVisibility(0);
            bVar.jCb.setText(bVar.jCh);
            bVar.jBW.setOnClickListener(new j(bVar));
            bVar.jBT.getViewTreeObserver().addOnGlobalLayoutListener(new k(bVar));
            a.AbstractC0476a aVar = bVar.jCg;
            if (aVar != null) {
                aVar.aC(bVar2.ixM, bVar.iHf.indexOf(bVar2));
            }
            bVar.jCd = true;
        }
        AppMethodBeat.o(149784);
    }

    public static final /* synthetic */ void a(b bVar, int i2) {
        boolean z;
        AppMethodBeat.i(149785);
        Button button = bVar.hPX;
        if (i2 != 0) {
            z = true;
        } else {
            z = false;
        }
        button.setEnabled(z);
        AppMethodBeat.o(149785);
    }
}
