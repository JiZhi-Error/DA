package com.tencent.mm.plugin.appbrand.jsapi.autofill.a;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.q;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010x\u001a\u00020A2\u0006\u0010y\u001a\u00020zH\u0002J\b\u0010{\u001a\u00020AH\u0016J\b\u0010|\u001a\u00020(H\u0016J\u0006\u0010}\u001a\u00020zJ\b\u0010~\u001a\u00020zH\u0016J\b\u0010\u001a\u0004\u0018\u00010YJ\u0007\u0010\u0001\u001a\u00020AJ\t\u0010\u0001\u001a\u00020\u001cH\u0016J\t\u0010\u0001\u001a\u00020\u001cH\u0016J\t\u0010\u0001\u001a\u00020\u001cH\u0016J\b\u0010I\u001a\u00020AH\u0016J\t\u0010\u0001\u001a\u00020AH\u0016J\u0011\u0010\u0001\u001a\u00020A2\u0006\u0010y\u001a\u00020zH\u0016J\u0014\u0010\u0001\u001a\u00020A2\t\u0010\u0001\u001a\u0004\u0018\u00010,H\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR(\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR*\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c@FX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R \u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER \u0010F\u001a\b\u0012\u0004\u0012\u00020A0@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER \u0010I\u001a\b\u0012\u0004\u0012\u00020A0@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER&\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020A0MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR \u0010R\u001a\b\u0012\u0004\u0012\u00020A0@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010C\"\u0004\bT\u0010ER \u0010U\u001a\b\u0012\u0004\u0012\u00020A0@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010C\"\u0004\bW\u0010ER(\u0010X\u001a\u0010\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020A\u0018\u00010MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010O\"\u0004\b[\u0010QR \u0010\\\u001a\b\u0012\u0004\u0012\u00020A0@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010C\"\u0004\b^\u0010ER \u0010_\u001a\b\u0012\u0004\u0012\u00020A0@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010C\"\u0004\ba\u0010ERD\u0010d\u001a\u0012\u0012\u0004\u0012\u00020Y0bj\b\u0012\u0004\u0012\u00020Y`c2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020Y0bj\b\u0012\u0004\u0012\u00020Y`c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR(\u0010i\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\n\"\u0004\bk\u0010\fR(\u0010l\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\n\"\u0004\bn\u0010\fR(\u0010o\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\n\"\u0004\bq\u0010\fR(\u0010r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\n\"\u0004\bt\u0010\fR(\u0010u\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\n\"\u0004\bw\u0010\f¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "IDCardInfo", "getIDCardInfo", "()Ljava/lang/String;", "setIDCardInfo", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "confirmWording", "getConfirmWording", "setConfirmWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "", "isAuthCheck", "()Ljava/lang/Boolean;", "setAuthCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mConfirmAssess", "Landroid/widget/CheckBox;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIDCardContainer", "Landroid/view/ViewGroup;", "mIDCardInfoTv", "Landroid/widget/TextView;", "mIconIv", "mNameTv", "mPhoneNumActionTv", "mPhoneNumContainer", "mPhoneWordingTv", "mProtocalContainer", "mProtocalTv", "mRealnameWordingTv", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "mRequestTv", "mRootView", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onChecked", "Lkotlin/Function1;", "getOnChecked", "()Lkotlin/jvm/functions/Function1;", "setOnChecked", "(Lkotlin/jvm/functions/Function1;)V", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "setOnPhoneItemSelect", "onProtocalJump", "getOnProtocalJump", "setOnProtocalJump", "onReject", "getOnReject", "setOnReject", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "phoneWording", "getPhoneWording", "setPhoneWording", "protocolJumpWording", "getProtocolJumpWording", "setProtocolJumpWording", "protocolPrefixWording", "getProtocolPrefixWording", "setProtocolPrefixWording", "realnameWording", "getRealnameWording", "setRealnameWording", "requstWording", "getRequstWording", "setRequstWording", "changeListHeightByRotation", "rotation", "", "dismiss", "getContentView", "getDialogHeight", "getPosition", "getSelectedPhoneItem", "initWeCoinAuthDialog", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class a extends Dialog implements k {
    private String iconUrl;
    public View jBN;
    private TextView jVh;
    public ImageView lIM;
    private TextView lIN;
    public ImageView lIO;
    private ViewGroup lIP;
    private TextView lIQ;
    private TextView lIR;
    private ViewGroup lIS;
    private TextView lIT;
    private MaxHeightRecyclerView lIU;
    private TextView lIV;
    private ViewGroup lIW;
    private CheckBox lIX;
    private TextView lIY;
    private View lIZ;
    private Button lJa;
    private Button lJb;
    private m lJc;
    private q lJd;
    private String lJe;
    private String lJf;
    private String lJg;
    private String lJh;
    private Boolean lJi;
    private String lJj;
    private String lJk;
    private String lJl;
    private String lJm;
    ArrayList<PhoneItem> lJn = new ArrayList<>();
    kotlin.g.a.a<x> lJo;
    kotlin.g.a.a<x> lJp;
    private kotlin.g.a.a<x> lJq;
    public kotlin.g.a.b<? super Boolean, x> lJr;
    kotlin.g.a.a<x> lJs;
    public kotlin.g.a.a<x> lJt;
    kotlin.g.a.a<x> lJu;
    kotlin.g.a.a<x> lJv;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a$a  reason: collision with other inner class name */
    static final class C0642a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final C0642a lJx = new C0642a();

        static {
            AppMethodBeat.i(50462);
            AppMethodBeat.o(50462);
        }

        C0642a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final b lJy = new b();

        static {
            AppMethodBeat.i(50463);
            AppMethodBeat.o(50463);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final c lJz = new c();

        static {
            AppMethodBeat.i(50464);
            AppMethodBeat.o(50464);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, x> {
        public static final d lJA = new d();

        static {
            AppMethodBeat.i(228325);
            AppMethodBeat.o(228325);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(228324);
            bool.booleanValue();
            x xVar = x.SXb;
            AppMethodBeat.o(228324);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final e lJB = new e();

        static {
            AppMethodBeat.i(50465);
            AppMethodBeat.o(50465);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final f lJC = new f();

        static {
            AppMethodBeat.i(50466);
            AppMethodBeat.o(50466);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final g lJD = new g();

        static {
            AppMethodBeat.i(50467);
            AppMethodBeat.o(50467);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final h lJE = new h();

        static {
            AppMethodBeat.i(50468);
            AppMethodBeat.o(50468);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(50477);
        View inflate = View.inflate(context, R.layout.ey, null);
        p.g(inflate, "View.inflate(context, R.…uth_request_dialog, null)");
        this.jBN = inflate;
        View findViewById = this.jBN.findViewById(R.id.h3q);
        p.g(findViewById, "mRootView.findViewById(R.id.request_icon)");
        this.lIM = (ImageView) findViewById;
        View findViewById2 = this.jBN.findViewById(R.id.h3s);
        p.g(findViewById2, "mRootView.findViewById(R.id.request_name)");
        this.jVh = (TextView) findViewById2;
        View findViewById3 = this.jBN.findViewById(R.id.h3k);
        p.g(findViewById3, "mRootView.findViewById(R.id.request_apply_wording)");
        this.lIN = (TextView) findViewById3;
        View findViewById4 = this.jBN.findViewById(R.id.h3w);
        p.g(findViewById4, "mRootView.findViewById(R.id.request_right_icon)");
        this.lIO = (ImageView) findViewById4;
        this.lIO.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.AnonymousClass1 */
            final /* synthetic */ a lJw;

            {
                this.lJw = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(50457);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.lJw.lJt.invoke();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(50457);
            }
        });
        View findViewById5 = this.jBN.findViewById(R.id.due);
        p.g(findViewById5, "mRootView.findViewById(R…d.id_card_info_container)");
        this.lIP = (ViewGroup) findViewById5;
        View findViewById6 = this.jBN.findViewById(R.id.dug);
        p.g(findViewById6, "mRootView.findViewById(R…d_card_info_request_desc)");
        this.lIQ = (TextView) findViewById6;
        View findViewById7 = this.jBN.findViewById(R.id.duf);
        p.g(findViewById7, "mRootView.findViewById(R…id_card_info_detail_desc)");
        this.lIR = (TextView) findViewById7;
        View findViewById8 = this.jBN.findViewById(R.id.gae);
        p.g(findViewById8, "mRootView.findViewById(R…phone_num_info_container)");
        this.lIS = (ViewGroup) findViewById8;
        View findViewById9 = this.jBN.findViewById(R.id.gaf);
        p.g(findViewById9, "mRootView.findViewById(R…ne_num_info_request_desc)");
        this.lIT = (TextView) findViewById9;
        View findViewById10 = this.jBN.findViewById(R.id.h3u);
        p.g(findViewById10, "mRootView.findViewById(R.id.request_recyclerview)");
        this.lIU = (MaxHeightRecyclerView) findViewById10;
        this.lIU.setLayoutManager(new LinearLayoutManager());
        this.lIU.setItemAnimator(null);
        View findViewById11 = this.jBN.findViewById(R.id.h3p);
        p.g(findViewById11, "mRootView.findViewById(R.id.request_function)");
        this.lIV = (TextView) findViewById11;
        this.lIV.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.AnonymousClass2 */
            final /* synthetic */ a lJw;

            {
                this.lJw = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(50458);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                switch (this.lJw.lJn.size()) {
                    case 1:
                        this.lJw.lJu.invoke();
                        break;
                    default:
                        this.lJw.lJv.invoke();
                        break;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(50458);
            }
        });
        View findViewById12 = this.jBN.findViewById(R.id.glw);
        p.g(findViewById12, "mRootView.findViewById(R.id.protocal_container)");
        this.lIW = (ViewGroup) findViewById12;
        View findViewById13 = this.jBN.findViewById(R.id.dui);
        p.g(findViewById13, "mRootView.findViewById(R.id.idcard_checkbox)");
        this.lIX = (CheckBox) findViewById13;
        View findViewById14 = this.jBN.findViewById(R.id.hr7);
        p.g(findViewById14, "mRootView.findViewById(R.id.show_protocal)");
        this.lIY = (TextView) findViewById14;
        View findViewById15 = this.jBN.findViewById(R.id.ah3);
        p.g(findViewById15, "mRootView.findViewById(R.id.button_group)");
        this.lIZ = findViewById15;
        View findViewById16 = this.jBN.findViewById(R.id.h3l);
        p.g(findViewById16, "mRootView.findViewById(R.id.request_cancel)");
        this.lJb = (Button) findViewById16;
        View findViewById17 = this.jBN.findViewById(R.id.h3t);
        p.g(findViewById17, "mRootView.findViewById(R.id.request_ok)");
        this.lJa = (Button) findViewById17;
        this.lJa.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.AnonymousClass3 */
            final /* synthetic */ a lJw;

            {
                this.lJw = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(50459);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.lJw.lJo.invoke();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(50459);
            }
        });
        this.lIX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.AnonymousClass4 */
            final /* synthetic */ a lJw;

            {
                this.lJw = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(50460);
                this.lJw.lJr.invoke(Boolean.valueOf(z));
                this.lJw.lJa.setEnabled(z);
                AppMethodBeat.o(50460);
            }
        });
        this.lJb.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.AnonymousClass5 */
            final /* synthetic */ a lJw;

            {
                this.lJw = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(50461);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.lJw.lJp.invoke();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(50461);
            }
        });
        this.lJo = C0642a.lJx;
        this.lJp = h.lJE;
        this.lJq = c.lJz;
        this.lJr = d.lJA;
        this.lJs = g.lJD;
        this.lJt = e.lJB;
        this.lJu = b.lJy;
        this.lJv = f.lJC;
        AppMethodBeat.o(50477);
    }

    public final void setIconUrl(String str) {
        AppMethodBeat.i(228326);
        this.iconUrl = str;
        com.tencent.mm.modelappbrand.a.b.aXY().a(this.lIM, str, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
        AppMethodBeat.o(228326);
    }

    public final void setAppBrandName(String str) {
        AppMethodBeat.i(228327);
        this.lJe = str;
        this.jVh.setText(str != null ? str : "");
        AppMethodBeat.o(228327);
    }

    public final void Zs(String str) {
        AppMethodBeat.i(228328);
        this.lJf = str;
        this.lIN.setText(str != null ? str : "");
        AppMethodBeat.o(228328);
    }

    public final void Zt(String str) {
        AppMethodBeat.i(228329);
        this.lJg = str;
        this.lIQ.setText(str != null ? str : "");
        AppMethodBeat.o(228329);
    }

    public final void Zu(String str) {
        AppMethodBeat.i(228330);
        this.lJh = str;
        this.lIT.setText(str != null ? str : "");
        AppMethodBeat.o(228330);
    }

    public final void g(Boolean bool) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(228331);
        this.lJi = bool;
        CheckBox checkBox = this.lIX;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = false;
        }
        checkBox.setChecked(z);
        Button button = this.lJa;
        if (bool != null) {
            z2 = bool.booleanValue();
        }
        button.setEnabled(z2);
        AppMethodBeat.o(228331);
    }

    public final void Zv(String str) {
        AppMethodBeat.i(228332);
        this.lJj = str;
        this.lJa.setText(!Util.isNullOrNil(str) ? str : getContext().getText(R.string.m6));
        AppMethodBeat.o(228332);
    }

    public final void Zw(String str) {
        AppMethodBeat.i(228333);
        this.lJk = str;
        this.lIX.setText(!Util.isNullOrNil(str) ? str : getContext().getText(R.string.m7));
        AppMethodBeat.o(228333);
    }

    public final void Zx(String str) {
        AppMethodBeat.i(228334);
        this.lJl = str;
        if (str != null) {
            this.lIY.setText(str);
            this.lIY.setOnClickListener(new j(this, str));
        }
        AppMethodBeat.o(228334);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$protocolJumpWording$1$1"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ String lJF;
        final /* synthetic */ a lJw;

        j(a aVar, String str) {
            this.lJw = aVar;
            this.lJF = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(50470);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$protocolJumpWording$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.lJw.lJs.invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$protocolJumpWording$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(50470);
        }
    }

    public final void Zy(String str) {
        AppMethodBeat.i(228335);
        this.lJm = str;
        if (Util.isNullOrNil(str)) {
            this.lIP.setVisibility(8);
            this.lIW.setVisibility(8);
            AppMethodBeat.o(228335);
            return;
        }
        this.lIP.setVisibility(0);
        this.lIR.setText(str);
        this.lIW.setVisibility(0);
        AppMethodBeat.o(228335);
    }

    public final void setPhoneItems(ArrayList<PhoneItem> arrayList) {
        AppMethodBeat.i(50471);
        p.h(arrayList, "value");
        this.lJn.clear();
        this.lJn.addAll(arrayList);
        com.tencent.mm.plugin.appbrand.ac.m.runOnUiThread(new i(this));
        AppMethodBeat.o(50471);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class i implements Runnable {
        final /* synthetic */ a lJw;

        i(a aVar) {
            this.lJw = aVar;
        }

        public final void run() {
            AppMethodBeat.i(50469);
            a aVar = this.lJw;
            Context context = this.lJw.getContext();
            p.g(context, "context");
            aVar.lJd = new q("", context, this.lJw.lJn);
            this.lJw.lIU.setAdapter(this.lJw.lJd);
            if (this.lJw.lJn.size() == 0) {
                this.lJw.lIS.setVisibility(8);
                AppMethodBeat.o(50469);
            } else if (this.lJw.lJn.size() == 1) {
                this.lJw.lIS.setVisibility(0);
                RecyclerView.a adapter = this.lJw.lIU.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                this.lJw.lIV.setText(this.lJw.getContext().getString(R.string.a2z));
                AppMethodBeat.o(50469);
            } else {
                this.lJw.lIS.setVisibility(0);
                RecyclerView.a adapter2 = this.lJw.lIU.getAdapter();
                if (adapter2 != null) {
                    adapter2.notifyDataSetChanged();
                }
                this.lJw.lIV.setText(this.lJw.getContext().getString(R.string.a2x));
                AppMethodBeat.o(50469);
            }
        }
    }

    public final void setOnAccept(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228336);
        p.h(aVar, "<set-?>");
        this.lJo = aVar;
        AppMethodBeat.o(228336);
    }

    public final void x(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228337);
        p.h(aVar, "<set-?>");
        this.lJp = aVar;
        AppMethodBeat.o(228337);
    }

    public final void setOnCancel(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228338);
        p.h(aVar, "<set-?>");
        this.lJq = aVar;
        AppMethodBeat.o(228338);
    }

    public final void y(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228339);
        p.h(aVar, "<set-?>");
        this.lJs = aVar;
        AppMethodBeat.o(228339);
    }

    public final void setOnAddPhoneNumber(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228340);
        p.h(aVar, "<set-?>");
        this.lJu = aVar;
        AppMethodBeat.o(228340);
    }

    public final void setOnManagePhoneNumber(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228341);
        p.h(aVar, "<set-?>");
        this.lJv = aVar;
        AppMethodBeat.o(228341);
    }

    public final void dismiss() {
        AppMethodBeat.i(50472);
        super.dismiss();
        onCancel();
        AppMethodBeat.o(50472);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void onCancel() {
        AppMethodBeat.i(50473);
        this.lJq.invoke();
        AppMethodBeat.o(50473);
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
    public final int getPosition() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final View getContentView() {
        return this.jBN;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjb() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void ut(int i2) {
        AppMethodBeat.i(50474);
        n nVar = n.JjY;
        Context context = getContext();
        p.g(context, "context");
        n.a(context, this.jBN, this.lIZ, i2, false);
        wN(i2);
        AppMethodBeat.o(50474);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void a(m mVar) {
        AppMethodBeat.i(50475);
        this.lJc = mVar;
        Object systemService = getContext().getSystemService("window");
        if (!(systemService instanceof WindowManager)) {
            systemService = null;
        }
        WindowManager windowManager = (WindowManager) systemService;
        if (windowManager != null) {
            n nVar = n.JjY;
            Context context = getContext();
            p.g(context, "context");
            View view = this.jBN;
            View view2 = this.lIZ;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            p.g(defaultDisplay, "it.defaultDisplay");
            n.a(context, view, view2, defaultDisplay.getRotation(), false);
            Display defaultDisplay2 = windowManager.getDefaultDisplay();
            p.g(defaultDisplay2, "it.defaultDisplay");
            wN(defaultDisplay2.getRotation());
            AppMethodBeat.o(50475);
            return;
        }
        AppMethodBeat.o(50475);
    }

    public final PhoneItem bEU() {
        AppMethodBeat.i(228342);
        Iterator<PhoneItem> it = this.lJn.iterator();
        while (it.hasNext()) {
            PhoneItem next = it.next();
            if (next.nzz) {
                AppMethodBeat.o(228342);
                return next;
            }
        }
        AppMethodBeat.o(228342);
        return null;
    }

    private final void wN(int i2) {
        AppMethodBeat.i(50476);
        double d2 = (i2 == 1 || i2 == 3) ? 1.5d : 2.5d;
        MaxHeightRecyclerView maxHeightRecyclerView = this.lIU;
        Context context = getContext();
        p.g(context, "context");
        maxHeightRecyclerView.setMaxHeight((int) (d2 * ((double) context.getResources().getDimensionPixelSize(R.dimen.su))));
        AppMethodBeat.o(50476);
    }
}
