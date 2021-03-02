package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.wallet.ui.b;
import com.tencent.mm.plugin.wallet.wecoin.a.d;
import com.tencent.mm.plugin.wallet.wecoin.model.RechargeProductsDialogViewModel;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.deo;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.protocal.protobuf.faz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.e;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 I2\u00020\u0001:\u0002IJB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u0012\u0010#\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020\u001fH\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0013H\u0002J\b\u0010.\u001a\u00020\u001fH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\u0012\u00101\u001a\u00020\u001f2\b\u00102\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u00103\u001a\u00020\u001f2\b\u00102\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u00104\u001a\u00020\u001fH\u0002J\u0012\u00105\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u000106H\u0002J\u0017\u00107\u001a\u00020\u001f2\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u001fH\u0016J\u0012\u0010;\u001a\u00020\u001f2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0017\u0010>\u001a\u00020\u001f2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0002\u0010AJ\u0018\u0010B\u001a\u00020\u001f2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010DH\u0002J\u0017\u0010E\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0002\u0010HR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0010R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "context", "Landroid/support/v4/app/FragmentActivity;", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "(Landroid/support/v4/app/FragmentActivity;Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;)V", "getContext", "()Landroid/support/v4/app/FragmentActivity;", "mBottomSheet", "Lcom/tencent/mm/plugin/wallet/ui/CommonBottomSheet;", "mCancelListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog$OnCancelListener;", "mCustomView", "Landroid/view/View;", "mFirstAdapter", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;", "mHeaderView", "mIsItemClicked", "", "mMenuClickListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IBtnClickListener;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mSecondAdapter", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel;", "getParams", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "showDarkAlways", "bindData", "", "createExitAnimation", "Landroid/animation/Animator;", "dialogView", "handleInterceptWinInfo", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "handleItemClicked", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "initCustomView", "initHeaderView", "initKVData", "initView", "Landroid/content/Context;", "isLandscape", "loadData", "removeObserver", "setAnimationOut", "setDialogCancelListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setMenuClickListener", "shakeIt", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "tryHide", "updateAgreementLinkText", "url", "", "updateCheckBox", "status", "", "(Ljava/lang/Integer;)V", "updatePriceItem", "priceInfo", "", "updateTitleBalance", "balance", "", "(Ljava/lang/Long;)V", "Companion", "RecycleViewAdapter", "plugin-wxpay_release"})
public final class a implements com.tencent.mm.plugin.wallet.wecoin.a.d {
    public static final C1910a HOk = new C1910a((byte) 0);
    private final boolean HMJ = this.HOj.HMJ;
    private com.tencent.mm.plugin.wallet.ui.b HOb;
    private final RechargeProductsDialogViewModel HOc;
    private b HOd;
    private b HOe;
    private boolean HOf;
    private d.a HOg;
    private com.tencent.mm.plugin.wallet.wecoin.a.a HOh;
    final FragmentActivity HOi;
    final com.tencent.mm.plugin.wallet.wecoin.model.e HOj;
    private View agA;
    private View ahJ;
    private com.tencent.mm.ui.base.q gxX;

    static {
        AppMethodBeat.i(212777);
        AppMethodBeat.o(212777);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged"})
    static final class c<T> implements Observer<String> {
        final /* synthetic */ a HOl;

        c(a aVar) {
            this.HOl = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(String str) {
            AppMethodBeat.i(212754);
            a.a(this.HOl, str);
            AppMethodBeat.o(212754);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged", "(Ljava/lang/Integer;)V"})
    static final class d<T> implements Observer<Integer> {
        final /* synthetic */ a HOl;

        d(a aVar) {
            this.HOl = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Integer num) {
            AppMethodBeat.i(212755);
            a.a(this.HOl, num);
            AppMethodBeat.o(212755);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "onChanged"})
    static final class e<T> implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.a> {
        final /* synthetic */ a HOl;

        e(a aVar) {
            this.HOl = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(com.tencent.mm.plugin.wallet.wecoin.model.a aVar) {
            AppMethodBeat.i(212756);
            a.a(this.HOl, aVar);
            AppMethodBeat.o(212756);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged", "(Ljava/lang/Long;)V"})
    static final class f<T> implements Observer<Long> {
        final /* synthetic */ a HOl;

        f(a aVar) {
            this.HOl = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Long l) {
            AppMethodBeat.i(212757);
            a.a(this.HOl, l);
            AppMethodBeat.o(212757);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged", "(Ljava/lang/Boolean;)V"})
    static final class g<T> implements Observer<Boolean> {
        final /* synthetic */ a HOl;

        g(a aVar) {
            this.HOl = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Boolean bool) {
            AppMethodBeat.i(212758);
            a.a(this.HOl, bool);
            AppMethodBeat.o(212758);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "onChanged"})
    static final class h<T> implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.d> {
        final /* synthetic */ a HOl;

        h(a aVar) {
            this.HOl = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(com.tencent.mm.plugin.wallet.wecoin.model.d dVar) {
            AppMethodBeat.i(212759);
            a.a(this.HOl, dVar);
            AppMethodBeat.o(212759);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "onChanged"})
    static final class i<T> implements Observer<List<? extends faz>> {
        final /* synthetic */ a HOl;

        i(a aVar) {
            this.HOl = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(List<? extends faz> list) {
            AppMethodBeat.i(212760);
            a.a(this.HOl, list);
            AppMethodBeat.o(212760);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:85:0x03ca, code lost:
        if (r0 == null) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.support.v4.app.FragmentActivity r10, com.tencent.mm.plugin.wallet.wecoin.model.e r11) {
        /*
        // Method dump skipped, instructions count: 1020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.wecoin.ui.a.<init>(android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.wallet.wecoin.model.e):void");
    }

    public static final /* synthetic */ void a(a aVar, Boolean bool) {
        AppMethodBeat.i(212783);
        aVar.j(bool);
        AppMethodBeat.o(212783);
    }

    public static final /* synthetic */ View b(a aVar) {
        AppMethodBeat.i(212778);
        View view = aVar.ahJ;
        if (view == null) {
            kotlin.g.b.p.btv("mCustomView");
        }
        AppMethodBeat.o(212778);
        return view;
    }

    public static final /* synthetic */ boolean f(a aVar) {
        AppMethodBeat.i(212786);
        boolean isLandscape = aVar.isLandscape();
        AppMethodBeat.o(212786);
        return isLandscape;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.wallet.ui.b h(a aVar) {
        AppMethodBeat.i(212788);
        com.tencent.mm.plugin.wallet.ui.b bVar = aVar.HOb;
        if (bVar == null) {
            kotlin.g.b.p.btv("mBottomSheet");
        }
        AppMethodBeat.o(212788);
        return bVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$Companion;", "", "()V", "MAX_ITEM_NUM", "", "TAG", "", "plugin-wxpay_release"})
    /* renamed from: com.tencent.mm.plugin.wallet.wecoin.ui.a$a  reason: collision with other inner class name */
    public static final class C1910a {
        private C1910a() {
        }

        public /* synthetic */ C1910a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class l implements b.a {
        final /* synthetic */ a HOl;

        l(a aVar) {
            this.HOl = aVar;
        }

        @Override // com.tencent.mm.plugin.wallet.ui.b.a
        public final void fPA() {
            com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> eVar;
            AppMethodBeat.i(212763);
            if (!this.HOl.HOf) {
                this.HOl.HOc.aeH(2);
                com.tencent.mm.plugin.wallet.wecoin.model.e eVar2 = this.HOl.HOc.HNa;
                if (!(eVar2 == null || (eVar = eVar2.HML) == null)) {
                    eVar.p(3, -3, "");
                    AppMethodBeat.o(212763);
                    return;
                }
            }
            AppMethodBeat.o(212763);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class m implements DialogInterface.OnCancelListener {
        final /* synthetic */ a HOl;

        m(a aVar) {
            this.HOl = aVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(212764);
            Log.d("MicroMsg.BuyGoodsBottomDialog", "setCancelCallback");
            d.a aVar = this.HOl.HOg;
            if (aVar != null) {
                aVar.dhl();
                AppMethodBeat.o(212764);
                return;
            }
            AppMethodBeat.o(212764);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ a HOl;

        k(a aVar) {
            this.HOl = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212762);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.HOl.HOc.fPF();
            a.C1016a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
            a.C1016a.reportGiftOnReturn();
            if (this.HOl.HOj.mScene != 1 || a.f(this.HOl)) {
                a.h(this.HOl).bMo();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(212762);
                return;
            }
            a.g(this.HOl);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212762);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    public static final class r implements AdapterView.OnItemClickListener {
        final /* synthetic */ a HOl;
        final /* synthetic */ ArrayList HOx;

        r(a aVar, ArrayList arrayList) {
            this.HOl = aVar;
            this.HOx = arrayList;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(212771);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updatePriceItem$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            a aVar = this.HOl;
            Object obj = this.HOx.get(i2);
            kotlin.g.b.p.g(obj, "firstMenuArray[position]");
            a.a(aVar, (faz) obj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updatePriceItem$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(212771);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    public static final class s implements AdapterView.OnItemClickListener {
        final /* synthetic */ a HOl;
        final /* synthetic */ ArrayList HOy;

        s(a aVar, ArrayList arrayList) {
            this.HOl = aVar;
            this.HOy = arrayList;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(212772);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updatePriceItem$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            a aVar = this.HOl;
            Object obj = this.HOy.get(i2);
            kotlin.g.b.p.g(obj, "secondMenuArray[position]");
            a.a(aVar, (faz) obj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updatePriceItem$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(212772);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$1$1"})
    public static final class q implements View.OnClickListener {
        final /* synthetic */ a HOl;
        final /* synthetic */ CheckBox HOv;
        final /* synthetic */ Integer HOw;

        q(CheckBox checkBox, a aVar, Integer num) {
            this.HOv = checkBox;
            this.HOl = aVar;
            this.HOw = num;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212770);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            CheckBox checkBox = this.HOv;
            kotlin.g.b.p.g(checkBox, "agreementCheckBox");
            if (checkBox.isChecked()) {
                CheckBox checkBox2 = this.HOv;
                kotlin.g.b.p.g(checkBox2, "agreementCheckBox");
                checkBox2.setChecked(false);
                this.HOl.HOc.aeH(4);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(212770);
                return;
            }
            CheckBox checkBox3 = this.HOv;
            kotlin.g.b.p.g(checkBox3, "agreementCheckBox");
            checkBox3.setChecked(true);
            this.HOl.HOc.aeH(3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212770);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class p implements e.a {
        final /* synthetic */ a HOl;
        final /* synthetic */ String mkH;

        p(a aVar, String str) {
            this.HOl = aVar;
            this.mkH = str;
        }

        @Override // com.tencent.mm.wallet_core.ui.e.a
        public final void bmr() {
            AppMethodBeat.i(212769);
            this.HOl.HOc.aeH(8);
            com.tencent.mm.wallet_core.ui.f.p(this.HOl.HOi, this.mkH, true);
            AppMethodBeat.o(212769);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$handleInterceptWinInfo$1$clickListener$1", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "onClick", "", "item", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "plugin-wxpay_release"})
    public static final class j implements com.tencent.mm.plugin.wallet.wecoin.model.b {
        final /* synthetic */ a HOl;
        final /* synthetic */ String HOq;
        final /* synthetic */ dep HOr;
        final /* synthetic */ com.tencent.mm.plugin.wallet.wecoin.model.d HOs;

        j(String str, dep dep, a aVar, com.tencent.mm.plugin.wallet.wecoin.model.d dVar) {
            this.HOq = str;
            this.HOr = dep;
            this.HOl = aVar;
            this.HOs = dVar;
        }

        @Override // com.tencent.mm.plugin.wallet.wecoin.model.b
        public final void a(ddc ddc) {
            AppMethodBeat.i(212761);
            if (ddc != null) {
                if (ddc.action == 3) {
                    String str = this.HOq;
                    if (!(str == null || str.length() == 0)) {
                        this.HOl.HOc.a(this.HOl.HOi, this.HOr, "release", this.HOq);
                    }
                }
                AppMethodBeat.o(212761);
                return;
            }
            AppMethodBeat.o(212761);
        }
    }

    private final void j(Boolean bool) {
        com.tencent.mm.ui.base.q qVar;
        AppMethodBeat.i(212773);
        Log.d("MicroMsg.BuyGoodsBottomDialog", "showProgressDialog: ".concat(String.valueOf(bool)));
        if (bool == null) {
            AppMethodBeat.o(212773);
            return;
        }
        if (bool.booleanValue()) {
            qVar = com.tencent.mm.ui.base.q.a(this.HOi, this.HOi.getString(R.string.ekc), true, 3, new o(this));
        } else {
            com.tencent.mm.ui.base.q qVar2 = this.gxX;
            if (qVar2 != null) {
                qVar2.dismiss();
            }
            qVar = null;
        }
        this.gxX = qVar;
        AppMethodBeat.o(212773);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class o implements DialogInterface.OnCancelListener {
        final /* synthetic */ a HOl;

        o(a aVar) {
            this.HOl = aVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(212768);
            if (!this.HOl.HOi.isFinishing() && !this.HOl.HOi.isDestroyed()) {
                RechargeProductsDialogViewModel rechargeProductsDialogViewModel = this.HOl.HOc;
                Log.i("MicroMsg.RechargeProductsDialogViewModel", "cancelPrepareRecharge, mPrepareCgi: " + rechargeProductsDialogViewModel.HMU);
                com.tencent.mm.plugin.wallet.wecoin.b.k kVar = rechargeProductsDialogViewModel.HMU;
                if (kVar != null) {
                    kVar.cancel();
                }
                rechargeProductsDialogViewModel.f(3, 2, 0, "");
                RechargeProductsDialogViewModel rechargeProductsDialogViewModel2 = this.HOl.HOc;
                Log.i("MicroMsg.RechargeProductsDialogViewModel", "cancelGetPriceListRequest, mGetPriceListCgi: " + rechargeProductsDialogViewModel2.HMV);
                com.tencent.mm.plugin.wallet.wecoin.b.i iVar = rechargeProductsDialogViewModel2.HMV;
                if (iVar != null) {
                    iVar.cancel();
                }
                rechargeProductsDialogViewModel2.f(8, 2, 0, "");
                this.HOl.HOi.finish();
            }
            com.tencent.mm.ui.base.q qVar = this.HOl.gxX;
            if (qVar != null) {
                if (qVar.isShowing()) {
                    qVar.dismiss();
                    this.HOl.gxX = null;
                }
                AppMethodBeat.o(212768);
                return;
            }
            AppMethodBeat.o(212768);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$setAnimationOut$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-wxpay_release"})
    public static final class n extends AnimatorListenerAdapter {
        final /* synthetic */ a HOl;
        final /* synthetic */ View HOt;

        n(a aVar, View view) {
            this.HOl = aVar;
            this.HOt = view;
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(212766);
            kotlin.g.b.p.h(animator, "animation");
            onAnimationEnd(animator);
            AppMethodBeat.o(212766);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.wallet.wecoin.ui.a$n$a  reason: collision with other inner class name */
        public static final class RunnableC1913a implements Runnable {
            final /* synthetic */ n HOu;

            RunnableC1913a(n nVar) {
                this.HOu = nVar;
            }

            public final void run() {
                AppMethodBeat.i(212765);
                a.h(this.HOu.HOl).bMo();
                AppMethodBeat.o(212765);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(212767);
            kotlin.g.b.p.h(animator, "animation");
            View view = a.h(this.HOl).lJI;
            kotlin.g.b.p.g(view, "mBottomSheet.rootView");
            ViewParent parent = view.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(212767);
                throw tVar;
            }
            ((ViewGroup) parent).setVisibility(8);
            this.HOt.post(new RunnableC1913a(this));
            AppMethodBeat.o(212767);
        }
    }

    private final boolean isLandscape() {
        AppMethodBeat.i(212774);
        Resources resources = this.HOi.getResources();
        kotlin.g.b.p.g(resources, "context.resources");
        if (resources.getConfiguration().orientation == 2) {
            AppMethodBeat.o(212774);
            return true;
        }
        AppMethodBeat.o(212774);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\fH\u0016J \u0010\u0014\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder;", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;", "(Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "getMItemClickListener", "()Landroid/widget/AdapterView$OnItemClickListener;", "setMItemClickListener", "(Landroid/widget/AdapterView$OnItemClickListener;)V", "mViewWidth", "", "mmMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMenu", "menu", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "ViewHolder", "plugin-wxpay_release"})
    public final class b extends RecyclerView.a<View$OnClickListenerC1911a> {
        com.tencent.mm.ui.base.m HMj;
        private int aYN;
        AdapterView.OnItemClickListener ars;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ View$OnClickListenerC1911a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(212751);
            kotlin.g.b.p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(a.this.HOi).inflate(R.layout.lv, viewGroup, false);
            kotlin.g.b.p.g(inflate, "itemView");
            View$OnClickListenerC1911a aVar = new View$OnClickListenerC1911a(this, inflate);
            AppMethodBeat.o(212751);
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(View$OnClickListenerC1911a aVar, int i2) {
            AppMethodBeat.i(212752);
            View$OnClickListenerC1911a aVar2 = aVar;
            kotlin.g.b.p.h(aVar2, "holder");
            com.tencent.mm.ui.base.m mVar = this.HMj;
            if (mVar != null) {
                if (i2 < mVar.size()) {
                    MenuItem menuItem = mVar.avn().get(i2);
                    if (menuItem == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
                        AppMethodBeat.o(212752);
                        throw tVar;
                    }
                    com.tencent.mm.ui.base.n nVar = (com.tencent.mm.ui.base.n) menuItem;
                    aVar2.HOm.setText(nVar.getTitle());
                    aVar2.HOn.setText(nVar.gKS());
                    if (a.this.HMJ) {
                        aVar2.HOm.setTextColor(a.this.HOi.getResources().getColor(R.color.BW_100_Alpha_0_8));
                        aVar2.HOn.setTextColor(a.this.HOi.getResources().getColor(R.color.BW_100_Alpha_0_5));
                    }
                }
                C1912b bVar = new C1912b(this, i2, aVar2);
                if (this.aYN > 0 || a.b(a.this).getWidth() > 0) {
                    bVar.invoke();
                    AppMethodBeat.o(212752);
                    return;
                }
                a.b(a.this).post(new c(bVar));
                AppMethodBeat.o(212752);
                return;
            }
            AppMethodBeat.o(212752);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class c implements Runnable {
            final /* synthetic */ kotlin.g.a.a qgW;

            c(kotlin.g.a.a aVar) {
                this.qgW = aVar;
            }

            public final void run() {
                AppMethodBeat.i(212750);
                this.qgW.invoke();
                AppMethodBeat.o(212750);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(212753);
            com.tencent.mm.ui.base.m mVar = this.HMj;
            if (mVar != null) {
                int size = mVar.size();
                AppMethodBeat.o(212753);
                return size;
            }
            AppMethodBeat.o(212753);
            return 0;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;Landroid/view/View;)V", "balanceCountTV", "Landroid/widget/TextView;", "getBalanceCountTV", "()Landroid/widget/TextView;", "setBalanceCountTV", "(Landroid/widget/TextView;)V", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "totalBalanceTV", "getTotalBalanceTV", "setTotalBalanceTV", "onClick", "", "v", "plugin-wxpay_release"})
        /* renamed from: com.tencent.mm.plugin.wallet.wecoin.ui.a$b$a  reason: collision with other inner class name */
        public final class View$OnClickListenerC1911a extends RecyclerView.v implements View.OnClickListener {
            TextView HOm;
            TextView HOn;
            final /* synthetic */ b HOo;
            private View lJI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public View$OnClickListenerC1911a(b bVar, View view) {
                super(view);
                kotlin.g.b.p.h(view, "itemView");
                this.HOo = bVar;
                AppMethodBeat.i(212748);
                view.setOnClickListener(this);
                View findViewById = view.findViewById(R.id.gv6);
                kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…product_balance_count_tv)");
                this.HOm = (TextView) findViewById;
                ao.a(this.HOm.getPaint(), 0.8f);
                com.tencent.mm.plugin.wallet.wecoin.c.c.o(this.HOm, 24);
                View findViewById2 = view.findViewById(R.id.gv8);
                kotlin.g.b.p.g(findViewById2, "itemView.findViewById(R.…product_total_balance_tv)");
                this.HOn = (TextView) findViewById2;
                com.tencent.mm.plugin.wallet.wecoin.c.c.o(this.HOn, 14);
                View findViewById3 = view.findViewById(R.id.h8v);
                kotlin.g.b.p.g(findViewById3, "itemView.findViewById(R.id.root)");
                this.lJI = findViewById3;
                if (a.this.HMJ || ao.isDarkMode()) {
                    this.lJI.setBackground(a.this.HOi.getResources().getDrawable(R.drawable.b57, null));
                }
                AppMethodBeat.o(212748);
            }

            public final void onClick(View view) {
                AppMethodBeat.i(212747);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.b.p.h(view, "v");
                AdapterView.OnItemClickListener onItemClickListener = this.HOo.ars;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(null, view, getPosition(), (long) getPosition());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(212747);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$onBindViewHolder$1$func$1"})
        /* renamed from: com.tencent.mm.plugin.wallet.wecoin.ui.a$b$b  reason: collision with other inner class name */
        static final class C1912b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ b HOo;
            final /* synthetic */ View$OnClickListenerC1911a HOp;
            final /* synthetic */ int oeZ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1912b(b bVar, int i2, View$OnClickListenerC1911a aVar) {
                super(0);
                this.HOo = bVar;
                this.oeZ = i2;
                this.HOp = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(212749);
                b bVar = this.HOo;
                View view = this.HOp.aus;
                kotlin.g.b.p.g(view, "holder.itemView");
                bVar.aYN = view.getWidth();
                View view2 = this.HOp.aus;
                kotlin.g.b.p.g(view2, "holder.itemView");
                view2.getLayoutParams().width = (a.b(a.this).getWidth() - (com.tencent.mm.cb.a.fromDPToPix((Context) a.this.HOi, 16) * 2)) / 3;
                this.HOp.aus.requestLayout();
                x xVar = x.SXb;
                AppMethodBeat.o(212749);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.d
    public final void a(d.a aVar) {
        this.HOg = aVar;
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.d
    public final void b(com.tencent.mm.plugin.wallet.wecoin.a.a aVar) {
        this.HOh = aVar;
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.d
    public final void bMo() {
        AppMethodBeat.i(212775);
        com.tencent.mm.plugin.wallet.ui.b bVar = this.HOb;
        if (bVar == null) {
            kotlin.g.b.p.btv("mBottomSheet");
        }
        bVar.bMo();
        AppMethodBeat.o(212775);
    }

    public static final /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(212779);
        Log.d("MicroMsg.BuyGoodsBottomDialog", "updateAgreementLinkText: ".concat(String.valueOf(str)));
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            View view = aVar.ahJ;
            if (view == null) {
                kotlin.g.b.p.btv("mCustomView");
            }
            TextView textView = (TextView) view.findViewById(R.id.gug);
            kotlin.g.b.p.g(textView, "linkText");
            com.tencent.mm.plugin.wallet.wecoin.c.c.o(textView, 14);
            if (aVar.HMJ) {
                textView.setTextColor(aVar.HOi.getResources().getColor(R.color.BW_100_Alpha_0_3));
            }
            String string = aVar.HOi.getString(R.string.ihr);
            kotlin.g.b.p.g(string, "context.getString(R.stri…lan_protocal_prefix_text)");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            String string2 = aVar.HOi.getString(R.string.j2n);
            kotlin.g.b.p.g(string2, "context.getString(R.stri…arge_agreement_link_text)");
            spannableStringBuilder.append((CharSequence) string2);
            spannableStringBuilder.setSpan(new com.tencent.mm.wallet_core.ui.e(new p(aVar, str)), string.length(), spannableStringBuilder.length(), 18);
            textView.setText(spannableStringBuilder);
            textView.setClickable(true);
            textView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(aVar.HOi));
            textView.setVisibility(0);
        }
        AppMethodBeat.o(212779);
    }

    public static final /* synthetic */ void a(a aVar, Integer num) {
        AppMethodBeat.i(212780);
        Log.d("MicroMsg.BuyGoodsBottomDialog", "updateCheckBox: ".concat(String.valueOf(num)));
        if (num != null) {
            num.intValue();
            aVar.HOc.aeH(num.intValue() == 0 ? 7 : 6);
            View view = aVar.ahJ;
            if (view == null) {
                kotlin.g.b.p.btv("mCustomView");
            }
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.gue);
            View view2 = aVar.ahJ;
            if (view2 == null) {
                kotlin.g.b.p.btv("mCustomView");
            }
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.gud);
            if (aVar.HMJ) {
                kotlin.g.b.p.g(checkBox, "agreementCheckBox");
                checkBox.setBackground(aVar.HOi.getResources().getDrawable(R.drawable.b53, null));
            }
            kotlin.g.b.p.g(checkBox, "agreementCheckBox");
            checkBox.setChecked(num.intValue() != 0);
            linearLayout.setOnClickListener(new q(checkBox, aVar, num));
            AppMethodBeat.o(212780);
            return;
        }
        AppMethodBeat.o(212780);
    }

    public static final /* synthetic */ void a(a aVar, com.tencent.mm.plugin.wallet.wecoin.model.a aVar2) {
        AppMethodBeat.i(212781);
        Log.d("MicroMsg.BuyGoodsBottomDialog", "showErrorMsg: ".concat(String.valueOf(aVar2)));
        com.tencent.mm.plugin.wallet.wecoin.c.c.a(aVar.HOi, aVar2);
        AppMethodBeat.o(212781);
    }

    public static final /* synthetic */ void a(a aVar, Long l2) {
        AppMethodBeat.i(212782);
        Log.d("MicroMsg.BuyGoodsBottomDialog", "updateTitleBalance: ".concat(String.valueOf(l2)));
        if (l2 != null) {
            long longValue = l2.longValue();
            View view = aVar.agA;
            if (view == null) {
                kotlin.g.b.p.btv("mHeaderView");
            }
            View findViewById = view.findViewById(R.id.h6x);
            kotlin.g.b.p.g(findViewById, "balanceLayout");
            findViewById.setVisibility(0);
            View view2 = aVar.agA;
            if (view2 == null) {
                kotlin.g.b.p.btv("mHeaderView");
            }
            View findViewById2 = view2.findViewById(R.id.gv8);
            kotlin.g.b.p.g(findViewById2, "mHeaderView.findViewById…product_total_balance_tv)");
            TextView textView = (TextView) findViewById2;
            com.tencent.mm.plugin.wallet.wecoin.c.c.o(textView, 15);
            ao.a(textView.getPaint(), 0.8f);
            if (aVar.HMJ) {
                textView.setTextColor(aVar.HOi.getResources().getColor(R.color.BW_100_Alpha_0_8));
            }
            textView.setText(String.valueOf(longValue));
            AppMethodBeat.o(212782);
            return;
        }
        AppMethodBeat.o(212782);
    }

    public static final /* synthetic */ void a(a aVar, com.tencent.mm.plugin.wallet.wecoin.model.d dVar) {
        dep dep;
        AppMethodBeat.i(212784);
        Log.d("MicroMsg.BuyGoodsBottomDialog", "handleInterceptWinInfo: ".concat(String.valueOf(dVar)));
        if (dVar == null || (dep = dVar.HMH) == null) {
            AppMethodBeat.o(212784);
            return;
        }
        faz faz = dVar.HMI;
        com.tencent.mm.plugin.wallet.wecoin.c.c.a(aVar.HOi, dep.MJy, new j(faz != null ? faz.AZx : null, dep, aVar, dVar));
        AppMethodBeat.o(212784);
    }

    public static final /* synthetic */ void a(a aVar, List list) {
        AppMethodBeat.i(212785);
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            StringBuilder sb = new StringBuilder("mBottomSheet: showing ");
            com.tencent.mm.plugin.wallet.ui.b bVar = aVar.HOb;
            if (bVar == null) {
                kotlin.g.b.p.btv("mBottomSheet");
            }
            Log.d("MicroMsg.BuyGoodsBottomDialog", sb.append(bVar.isShowing()).toString());
            com.tencent.mm.plugin.wallet.ui.b bVar2 = aVar.HOb;
            if (bVar2 == null) {
                kotlin.g.b.p.btv("mBottomSheet");
            }
            if (!bVar2.isShowing()) {
                aVar.HOc.aeH(1);
            }
            aVar.j(Boolean.FALSE);
            int size = list.size() / 2;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (i2 < size) {
                    arrayList.add(list.get(i2));
                } else {
                    arrayList2.add(list.get(i2));
                }
            }
            com.tencent.mm.ui.base.m mVar = new com.tencent.mm.ui.base.m(aVar.HOi);
            com.tencent.mm.ui.base.m mVar2 = new com.tencent.mm.ui.base.m(aVar.HOi);
            int i3 = 0;
            for (Object obj : arrayList) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    kotlin.a.j.hxH();
                }
                faz faz = (faz) obj;
                String string = aVar.HOi.getString(R.string.j2o, new Object[]{String.valueOf(com.tencent.mm.wallet_core.ui.f.a(new StringBuilder().append(faz.Bac).toString(), "100", RoundingMode.CEILING))});
                kotlin.g.b.p.g(string, "context.getString(R.stri…an, avgAmount.toString())");
                mVar.a(i3, new StringBuilder().append(faz.Nxr).toString(), string, -1);
                i3 = i4;
            }
            int i5 = 0;
            for (Object obj2 : arrayList2) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    kotlin.a.j.hxH();
                }
                faz faz2 = (faz) obj2;
                String string2 = aVar.HOi.getString(R.string.j2o, new Object[]{String.valueOf(com.tencent.mm.wallet_core.ui.f.a(new StringBuilder().append(faz2.Bac).toString(), "100", RoundingMode.CEILING))});
                kotlin.g.b.p.g(string2, "context.getString(R.stri…an, avgAmount.toString())");
                mVar2.a(i5, new StringBuilder().append(faz2.Nxr).toString(), string2, -1);
                i5 = i6;
            }
            b bVar3 = aVar.HOd;
            if (bVar3 == null) {
                kotlin.g.b.p.btv("mFirstAdapter");
            }
            bVar3.HMj = mVar;
            b bVar4 = aVar.HOd;
            if (bVar4 == null) {
                kotlin.g.b.p.btv("mFirstAdapter");
            }
            bVar4.ars = new r(aVar, arrayList);
            b bVar5 = aVar.HOe;
            if (bVar5 == null) {
                kotlin.g.b.p.btv("mSecondAdapter");
            }
            bVar5.HMj = mVar2;
            b bVar6 = aVar.HOe;
            if (bVar6 == null) {
                kotlin.g.b.p.btv("mSecondAdapter");
            }
            bVar6.ars = new s(aVar, arrayList2);
            b bVar7 = aVar.HOd;
            if (bVar7 == null) {
                kotlin.g.b.p.btv("mFirstAdapter");
            }
            bVar7.notifyDataSetChanged();
            b bVar8 = aVar.HOe;
            if (bVar8 == null) {
                kotlin.g.b.p.btv("mSecondAdapter");
            }
            bVar8.notifyDataSetChanged();
            com.tencent.mm.plugin.wallet.ui.b bVar9 = aVar.HOb;
            if (bVar9 == null) {
                kotlin.g.b.p.btv("mBottomSheet");
            }
            bVar9.dGm();
        }
        AppMethodBeat.o(212785);
    }

    public static final /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(212787);
        com.tencent.mm.plugin.wallet.ui.b bVar = aVar.HOb;
        if (bVar == null) {
            kotlin.g.b.p.btv("mBottomSheet");
        }
        View view = bVar.lJI;
        view.animate().cancel();
        view.clearAnimation();
        kotlin.g.b.p.g(view, "dialogView");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, (float) view.getWidth());
        kotlin.g.b.p.g(ofFloat, "animator");
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(ofFloat);
        AnimatorSet animatorSet2 = animatorSet;
        animatorSet2.addListener(new n(aVar, view));
        animatorSet2.start();
        AppMethodBeat.o(212787);
    }

    public static final /* synthetic */ void a(a aVar, faz faz) {
        com.tencent.mm.co.f aYI;
        AppMethodBeat.i(212789);
        View view = aVar.ahJ;
        if (view == null) {
            kotlin.g.b.p.btv("mCustomView");
        }
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.gue);
        kotlin.g.b.p.g(checkBox, "agreementCheckBox");
        if (checkBox.isChecked()) {
            aVar.HOf = true;
            d.a aVar2 = aVar.HOg;
            if (aVar2 != null) {
                aVar2.dhl();
            }
            com.tencent.mm.plugin.wallet.wecoin.a.a aVar3 = aVar.HOh;
            if (aVar3 != null) {
                aVar3.onClick();
            }
            com.tencent.mm.plugin.wallet.ui.b bVar = aVar.HOb;
            if (bVar == null) {
                kotlin.g.b.p.btv("mBottomSheet");
            }
            bVar.bMo();
            a.C1016a aVar4 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
            a.C1016a.reportGiftOnReturn();
            RechargeProductsDialogViewModel rechargeProductsDialogViewModel = aVar.HOc;
            FragmentActivity fragmentActivity = aVar.HOi;
            int i2 = aVar.HOj.mScene;
            kotlin.g.b.p.h(fragmentActivity, "context");
            kotlin.g.b.p.h(faz, "info");
            com.tencent.mm.plugin.wallet.wecoin.c.a.a(rechargeProductsDialogViewModel.qiR, Boolean.TRUE);
            rechargeProductsDialogViewModel.f(3, 1, 0, "");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 20);
            String str = rechargeProductsDialogViewModel.zfX;
            if (str == null) {
                str = rechargeProductsDialogViewModel.fPE();
            }
            deo deo = new deo();
            deo.request_id = str;
            deo.MJG = faz.AZx;
            deo.Meb = rechargeProductsDialogViewModel.HMW;
            deo.scene = i2;
            deo.LoB = str;
            rechargeProductsDialogViewModel.HMU = new com.tencent.mm.plugin.wallet.wecoin.b.k(deo);
            com.tencent.mm.plugin.wallet.wecoin.b.k kVar = rechargeProductsDialogViewModel.HMU;
            if (!(kVar == null || (aYI = kVar.aYI()) == null)) {
                aYI.b(new RechargeProductsDialogViewModel.e(rechargeProductsDialogViewModel, faz, fragmentActivity));
            }
        } else {
            Animation loadAnimation = AnimationUtils.loadAnimation(aVar.HOi, R.anim.a1);
            View view2 = aVar.ahJ;
            if (view2 == null) {
                kotlin.g.b.p.btv("mCustomView");
            }
            ((LinearLayout) view2.findViewById(R.id.guf)).startAnimation(loadAnimation);
        }
        aVar.HOc.aeH(5);
        AppMethodBeat.o(212789);
    }
}
