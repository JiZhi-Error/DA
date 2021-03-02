package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.b.c;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.t;

@com.tencent.mm.ui.base.a(32)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001e\b\u0007\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0002@AB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020+H\u0016J\b\u0010/\u001a\u00020\u0005H\u0014J\b\u00100\u001a\u00020\u0005H\u0014J\b\u00101\u001a\u00020+H\u0002J\"\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u00020+H\u0016J\u0012\u00108\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0018\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0005H\u0016J\u0010\u0010>\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010?\u001a\u00020+H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "CUSTOM_TEXT_STATUS_LENGTH_LIMIT", "", "getCUSTOM_TEXT_STATUS_LENGTH_LIMIT", "()I", "btnBack", "Landroid/view/View;", "getBtnBack", "()Landroid/view/View;", "btnBack$delegate", "Lkotlin/Lazy;", "customDialog", "customET", "Landroid/widget/EditText;", "customETWatcher", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$PatTextWatcher;", "isCancel", "", "isEnter", "()Z", "setEnter", "(Z)V", "layoutContent", "getLayoutContent", "setLayoutContent", "(Landroid/view/View;)V", "onItemClickListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1;", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "doClickIcon", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "finish", "getForceOrientation", "getLayoutId", "hideCustomDialog", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "showCustomDialog", "showEducationLayout", "Companion", "PatTextWatcher", "plugin-textstatus_release"})
public final class TextStatusDoWhatActivity extends MMSecDataActivity implements b.a {
    public static final a GdF = new a((byte) 0);
    private View GdB;
    private final kotlin.f GdD = kotlin.g.ah(new b(this));
    private final g GdE = new g(this);
    private m Gev;
    final int VeU = 8;
    private View VeV;
    private EditText VeW;
    private d VeX = new d();
    private boolean dEv;
    private boolean ifz = true;
    WxRecyclerView rHX;

    static {
        AppMethodBeat.i(216479);
        AppMethodBeat.o(216479);
    }

    private final View fwo() {
        AppMethodBeat.i(216475);
        View view = (View) this.GdD.getValue();
        AppMethodBeat.o(216475);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion;", "", "()V", "KEY_DEFAULT_BACKGROUND_ID", "", "KEY_IS_ENTER", "TAG", "start", "", "context", "Landroid/content/Context;", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "startForResult", "Landroid/app/Activity;", "defaultBackgroundId", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void g(Context context, Bundle bundle) {
            Context context2;
            AppMethodBeat.i(216467);
            p.h(context, "context");
            Intent intent = new Intent(context, TextStatusDoWhatActivity.class);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("KEY_IS_ENTER", true);
            intent.putExtras(bundle);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion", "start", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion", "start", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (!(context instanceof Activity)) {
                context2 = null;
            } else {
                context2 = context;
            }
            Activity activity = (Activity) context2;
            if (activity != null) {
                activity.overridePendingTransition(R.anim.dq, R.anim.s);
                AppMethodBeat.o(216467);
                return;
            }
            AppMethodBeat.o(216467);
        }
    }

    public TextStatusDoWhatActivity() {
        AppMethodBeat.i(216478);
        AppMethodBeat.o(216478);
    }

    public static final /* synthetic */ void f(TextStatusDoWhatActivity textStatusDoWhatActivity) {
        AppMethodBeat.i(258464);
        textStatusDoWhatActivity.hXu();
        AppMethodBeat.o(258464);
    }

    public static final /* synthetic */ View g(TextStatusDoWhatActivity textStatusDoWhatActivity) {
        AppMethodBeat.i(258466);
        View fwo = textStatusDoWhatActivity.fwo();
        AppMethodBeat.o(258466);
        return fwo;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c2c;
    }

    public final void setLayoutContent(View view) {
        this.GdB = view;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        int i2;
        AppMethodBeat.i(216476);
        com.tencent.mm.pluginsdk.h.q(this);
        super.onCreate(bundle);
        setActionbarColor(0);
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1792);
        com.tencent.mm.ui.statusbar.d.e(getWindow());
        setNavigationbarColor(getResources().getColor(R.color.ac_));
        setMMTitle("");
        hideActionbarLine();
        hideActionBarOperationArea();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        this.rHX = (WxRecyclerView) findViewById(R.id.h9z);
        this.GdB = findViewById(R.id.e9u);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("SET_TEXT_PARAMS");
        if (byteArrayExtra != null) {
            m mVar = new m();
            mVar.parseFrom(byteArrayExtra);
            this.Gev = mVar;
        }
        if (this.Gev == null) {
            this.Gev = new m();
        }
        m mVar2 = this.Gev;
        if (mVar2 != null) {
            mVar2.enterTime = cl.aWA();
        }
        m mVar3 = this.Gev;
        if (mVar3 != null) {
            Intent intent = getIntent();
            com.tencent.mm.plugin.textstatus.j.e eVar = com.tencent.mm.plugin.textstatus.j.e.Ggj;
            mVar3.Gag = intent.getIntExtra("KEY_DEFAULT_BACKGROUND_ID", com.tencent.mm.plugin.textstatus.j.e.fwL());
        }
        this.dEv = getIntent().getBooleanExtra("KEY_IS_ENTER", false);
        m mVar4 = this.Gev;
        if (mVar4 == null) {
            p.hyc();
        }
        Bitmap bitmapNative = BitmapUtil.getBitmapNative(mVar4.Gag);
        View view = this.GdB;
        if (view != null) {
            view.setBackground(new BitmapDrawable(getResources(), bitmapNative));
        }
        WxRecyclerView wxRecyclerView = this.rHX;
        if (wxRecyclerView != null) {
            com.tencent.mm.plugin.textstatus.j.b bVar = com.tencent.mm.plugin.textstatus.j.b.GfZ;
            wxRecyclerView.setAdapter(new WxRecyclerAdapter(new c(this), com.tencent.mm.plugin.textstatus.j.b.getDataList()));
        }
        AppCompatActivity context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        int i3 = resources.getDisplayMetrics().widthPixels;
        AppCompatActivity context2 = getContext();
        p.g(context2, "context");
        Resources resources2 = context2.getResources();
        p.g(resources2, "context.resources");
        int min = Math.min(i3, resources2.getDisplayMetrics().heightPixels);
        WxRecyclerView wxRecyclerView2 = this.rHX;
        int paddingLeft = min - (wxRecyclerView2 != null ? wxRecyclerView2.getPaddingLeft() : 0);
        WxRecyclerView wxRecyclerView3 = this.rHX;
        if (wxRecyclerView3 != null) {
            i2 = wxRecyclerView3.getPaddingRight();
        } else {
            i2 = 0;
        }
        int i4 = paddingLeft - i2;
        float dimension = getResources().getDimension(R.dimen.akv);
        z.c cVar = new z.c();
        cVar.SYD = getResources().getDimension(R.dimen.aku);
        z.f fVar = new z.f();
        fVar.SYG = (T) new GridLayoutManager((int) ((((float) i4) + cVar.SYD) / (dimension + cVar.SYD)));
        fVar.SYG.a(new e(this, fVar));
        WxRecyclerView wxRecyclerView4 = this.rHX;
        if (wxRecyclerView4 != null) {
            wxRecyclerView4.setLayoutManager(fVar.SYG);
        }
        WxRecyclerView wxRecyclerView5 = this.rHX;
        if (wxRecyclerView5 != null) {
            wxRecyclerView5.b(new f(cVar));
        }
        ViewGroup.LayoutParams layoutParams = fwo().getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(216476);
            throw tVar;
        }
        ((RelativeLayout.LayoutParams) layoutParams).topMargin = at.fromDPToPix(getContext(), 6) + au.getStatusBarHeight(getContext());
        fwo().setOnClickListener(new i(this));
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        boolean z = aAh.azQ().getInt(ar.a.USERINFO_TEXT_STATUS_EDUCATION_FLAG_INT, 1) == 1;
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        boolean z2 = aAh2.azQ().getBoolean(ar.a.USERINFO_TEXT_STATUS_NEW_TIPS_SHOW_BOOLEAN, false);
        if (z && !z2) {
            m mVar5 = this.Gev;
            if (mVar5 != null) {
                mVar5.VdL = 1;
            }
            View findViewById = findViewById(R.id.jui);
            p.g(findViewById, "findViewById<View>(R.id.education_layout)");
            findViewById.setVisibility(0);
            WxRecyclerView wxRecyclerView6 = this.rHX;
            if (wxRecyclerView6 != null) {
                wxRecyclerView6.setVisibility(8);
            }
            fwo().setVisibility(8);
            com.tencent.mm.plugin.textstatus.a.p.fvE();
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_TEXT_STATUS_EDUCATION_FLAG_INT, (Object) 0);
            findViewById(R.id.juh).setOnClickListener(new l(this));
        }
        AppMethodBeat.o(216476);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$2", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-textstatus_release"})
    public static final class e extends GridLayoutManager.b {
        final /* synthetic */ TextStatusDoWhatActivity GdG;
        final /* synthetic */ z.f VeY;

        e(TextStatusDoWhatActivity textStatusDoWhatActivity, z.f fVar) {
            this.GdG = textStatusDoWhatActivity;
            this.VeY = fVar;
        }

        @Override // android.support.v7.widget.GridLayoutManager.b
        public final int bX(int i2) {
            RecyclerView.a adapter;
            AppMethodBeat.i(258454);
            WxRecyclerView wxRecyclerView = this.GdG.rHX;
            Integer valueOf = (wxRecyclerView == null || (adapter = wxRecyclerView.getAdapter()) == null) ? null : Integer.valueOf(adapter.getItemViewType(i2));
            if (valueOf != null && valueOf.intValue() == -1) {
                int ki = this.VeY.SYG.ki();
                AppMethodBeat.o(258454);
                return ki;
            } else if (valueOf != null && valueOf.intValue() == 1) {
                int ki2 = this.VeY.SYG.ki();
                AppMethodBeat.o(258454);
                return ki2;
            } else {
                AppMethodBeat.o(258454);
                return 1;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$3", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-textstatus_release"})
    public static final class f extends RecyclerView.h {
        final /* synthetic */ z.c VeZ;

        f(z.c cVar) {
            this.VeZ = cVar;
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(258455);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            super.a(rect, view, recyclerView, sVar);
            rect.bottom = (int) this.VeZ.SYD;
            rect.left = ((int) this.VeZ.SYD) / 2;
            rect.right = ((int) this.VeZ.SYD) / 2;
            AppMethodBeat.o(258455);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ TextStatusDoWhatActivity GdG;

        i(TextStatusDoWhatActivity textStatusDoWhatActivity) {
            this.GdG = textStatusDoWhatActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258456);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GdG.onBackPressed();
            this.GdG.getContext().overridePendingTransition(R.anim.s, R.anim.f6do);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258456);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
    public static final class c implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ TextStatusDoWhatActivity GdG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(TextStatusDoWhatActivity textStatusDoWhatActivity) {
            this.GdG = textStatusDoWhatActivity;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(216469);
            switch (i2) {
                case -1:
                    com.tencent.mm.plugin.textstatus.b.b bVar = new com.tencent.mm.plugin.textstatus.b.b();
                    AppMethodBeat.o(216469);
                    return bVar;
                case 0:
                default:
                    com.tencent.mm.plugin.textstatus.b.c cVar = new com.tencent.mm.plugin.textstatus.b.c(this.GdG.GdE);
                    AppMethodBeat.o(216469);
                    return cVar;
                case 1:
                    com.tencent.mm.plugin.textstatus.b.a aVar = new com.tencent.mm.plugin.textstatus.b.a();
                    AppMethodBeat.o(216469);
                    return aVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "onItemClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "plugin-textstatus_release"})
    public static final class g implements c.b {
        final /* synthetic */ TextStatusDoWhatActivity GdG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(TextStatusDoWhatActivity textStatusDoWhatActivity) {
            this.GdG = textStatusDoWhatActivity;
        }

        @Override // com.tencent.mm.plugin.textstatus.b.c.b
        public final void a(View view, com.tencent.mm.plugin.textstatus.f.e.c cVar) {
            AppMethodBeat.i(216474);
            p.h(view, "v");
            p.h(cVar, "item");
            if (p.j(cVar.VdG.Ggc, "custom")) {
                TextStatusDoWhatActivity.b(this.GdG, cVar);
                AppMethodBeat.o(216474);
                return;
            }
            TextStatusDoWhatActivity.a(this.GdG, cVar);
            AppMethodBeat.o(216474);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ TextStatusDoWhatActivity GdG;

        h(TextStatusDoWhatActivity textStatusDoWhatActivity) {
            this.GdG = textStatusDoWhatActivity;
        }

        public final void run() {
            AppMethodBeat.i(258453);
            this.GdG.ifz = false;
            this.GdG.finish();
            AppMethodBeat.o(258453);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(216477);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == 1) {
            finish();
            getContext().overridePendingTransition(R.anim.dq, R.anim.f6do);
        }
        AppMethodBeat.o(216477);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(258460);
        if (this.ifz) {
            com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
            com.tencent.mm.plugin.textstatus.k.a.a(this.Gev);
        }
        super.finish();
        AppMethodBeat.o(258460);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$PatTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity;)V", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-textstatus_release"})
    public final class d implements TextWatcher {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        public final void afterTextChanged(Editable editable) {
            Button button;
            AppMethodBeat.i(258452);
            EditText editText = TextStatusDoWhatActivity.this.VeW;
            if (editText != null) {
                editText.removeTextChangedListener(TextStatusDoWhatActivity.this.VeX);
            }
            int a2 = com.tencent.mm.ui.tools.f.a(String.valueOf(editable), f.a.MODE_CHINESE_AS_2);
            Log.i("MicroMsg.TxtStatus.TextStatusDoWhatActivity", "afterTextChanged inputCount:".concat(String.valueOf(a2)));
            String valueOf = String.valueOf(editable);
            if (a2 > TextStatusDoWhatActivity.this.VeU) {
                String hm = com.tencent.mm.ui.tools.f.hm(valueOf, TextStatusDoWhatActivity.this.VeU);
                if (editable != null) {
                    editable.replace(hm.length(), valueOf.length(), "");
                }
                u.u(TextStatusDoWhatActivity.this, TextStatusDoWhatActivity.this.getString(R.string.jdu), R.raw.icons_outlined_info);
            }
            EditText editText2 = TextStatusDoWhatActivity.this.VeW;
            if (editText2 != null) {
                editText2.addTextChangedListener(TextStatusDoWhatActivity.this.VeX);
            }
            View view = TextStatusDoWhatActivity.this.VeV;
            if (view == null || (button = (Button) view.findViewById(R.id.b_4)) == null) {
                AppMethodBeat.o(258452);
                return;
            }
            button.setEnabled(editable == null || editable.length() != 0);
            AppMethodBeat.o(258452);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ TextStatusDoWhatActivity GdG;

        j(TextStatusDoWhatActivity textStatusDoWhatActivity) {
            this.GdG = textStatusDoWhatActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258457);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showCustomDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusDoWhatActivity.f(this.GdG);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showCustomDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258457);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.textstatus.f.e.c FXB;
        final /* synthetic */ TextStatusDoWhatActivity GdG;

        k(TextStatusDoWhatActivity textStatusDoWhatActivity, com.tencent.mm.plugin.textstatus.f.e.c cVar) {
            this.GdG = textStatusDoWhatActivity;
            this.FXB = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258458);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showCustomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.textstatus.j.b bVar2 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
            EditText editText = this.GdG.VeW;
            com.tencent.mm.plugin.textstatus.j.b.byu(String.valueOf(editText != null ? editText.getText() : null));
            TextStatusDoWhatActivity.a(this.GdG, this.FXB);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showCustomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258458);
        }
    }

    private final void hXu() {
        AppMethodBeat.i(258461);
        WxRecyclerView wxRecyclerView = this.rHX;
        if (wxRecyclerView != null) {
            wxRecyclerView.setVisibility(0);
        }
        fwo().setVisibility(0);
        View view = this.VeV;
        if (view != null) {
            view.setVisibility(8);
        }
        EditText editText = this.VeW;
        if (editText != null) {
            editText.setText("");
        }
        hideVKB();
        AppMethodBeat.o(258461);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(258462);
        View view = this.VeV;
        if (view == null || view.getVisibility() != 0) {
            super.onBackPressed();
            AppMethodBeat.o(258462);
            return;
        }
        hXu();
        AppMethodBeat.o(258462);
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(258463);
        if (z) {
            View view = this.VeV;
            if (view != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 56) + i2;
                AppMethodBeat.o(258463);
                return;
            }
            AppMethodBeat.o(258463);
            return;
        }
        View view2 = this.VeV;
        ViewGroup.LayoutParams layoutParams2 = view2 != null ? view2.getLayoutParams() : null;
        if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams2 = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.bottomMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 160);
            AppMethodBeat.o(258463);
            return;
        }
        AppMethodBeat.o(258463);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ TextStatusDoWhatActivity GdG;

        l(TextStatusDoWhatActivity textStatusDoWhatActivity) {
            this.GdG = textStatusDoWhatActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258459);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showEducationLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View findViewById = this.GdG.findViewById(R.id.jui);
            p.g(findViewById, "findViewById<View>(R.id.education_layout)");
            findViewById.setVisibility(8);
            WxRecyclerView wxRecyclerView = this.GdG.rHX;
            if (wxRecyclerView != null) {
                wxRecyclerView.setVisibility(0);
            }
            TextStatusDoWhatActivity.g(this.GdG).setVisibility(0);
            m mVar = this.GdG.Gev;
            if (mVar != null) {
                mVar.VdM = 1;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showEducationLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258459);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ TextStatusDoWhatActivity GdG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(TextStatusDoWhatActivity textStatusDoWhatActivity) {
            super(0);
            this.GdG = textStatusDoWhatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(216468);
            View findViewById = this.GdG.findViewById(R.id.aej);
            AppMethodBeat.o(216468);
            return findViewById;
        }
    }

    public static final /* synthetic */ void a(TextStatusDoWhatActivity textStatusDoWhatActivity, com.tencent.mm.plugin.textstatus.f.e.c cVar) {
        int i2 = 0;
        AppMethodBeat.i(258465);
        if (textStatusDoWhatActivity.dEv) {
            m.a aSY = new m.a().aSZ(cVar.VdG.fwJ()).aSY(cVar.VdG.Ggc);
            m mVar = textStatusDoWhatActivity.Gev;
            if (mVar == null) {
                p.hyc();
            }
            m.a abL = aSY.abL(mVar.Gag);
            m mVar2 = textStatusDoWhatActivity.Gev;
            if (mVar2 == null) {
                p.hyc();
            }
            m fvz = abL.RR(mVar2.enterTime).fvz();
            m mVar3 = textStatusDoWhatActivity.Gev;
            fvz.VdL = mVar3 != null ? mVar3.VdL : 0;
            m mVar4 = textStatusDoWhatActivity.Gev;
            if (mVar4 != null) {
                i2 = mVar4.VdM;
            }
            fvz.VdM = i2;
            if (p.j(cVar.VdG.Ggc, "custom")) {
                fvz.VdP = cVar.VdG.fwJ();
            }
            TextStatusEditActivity.a aVar = TextStatusEditActivity.GeM;
            TextStatusEditActivity.a.a(textStatusDoWhatActivity, fvz, 1);
            com.tencent.f.h.RTc.n(new h(textStatusDoWhatActivity), 50);
            AppMethodBeat.o(258465);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("STATUS_TYPE_NAME", cVar.VdG.fwJ());
        intent.putExtra("STATUS_TYPE_IMG", cVar.VdG.Ggc);
        textStatusDoWhatActivity.setResult(-1, intent);
        textStatusDoWhatActivity.ifz = false;
        textStatusDoWhatActivity.finish();
        textStatusDoWhatActivity.getContext().overridePendingTransition(0, R.anim.f6do);
        AppMethodBeat.o(258465);
    }

    public static final /* synthetic */ void b(TextStatusDoWhatActivity textStatusDoWhatActivity, com.tencent.mm.plugin.textstatus.f.e.c cVar) {
        boolean z;
        Button button;
        Button button2;
        InputPanelLinearLayout inputPanelLinearLayout;
        AppMethodBeat.i(258467);
        WxRecyclerView wxRecyclerView = textStatusDoWhatActivity.rHX;
        if (wxRecyclerView != null) {
            wxRecyclerView.setVisibility(8);
        }
        textStatusDoWhatActivity.fwo().setVisibility(8);
        textStatusDoWhatActivity.VeV = textStatusDoWhatActivity.findViewById(R.id.ju1);
        View view = textStatusDoWhatActivity.VeV;
        textStatusDoWhatActivity.VeW = view != null ? (EditText) view.findViewById(R.id.ju0) : null;
        View view2 = textStatusDoWhatActivity.VeV;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        com.tencent.mm.plugin.textstatus.j.b bVar = com.tencent.mm.plugin.textstatus.j.b.GfZ;
        String hXz = com.tencent.mm.plugin.textstatus.j.b.hXz();
        if (hXz.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            EditText editText = textStatusDoWhatActivity.VeW;
            if (editText != null) {
                editText.setText(hXz);
            }
            EditText editText2 = textStatusDoWhatActivity.VeW;
            if (editText2 != null) {
                editText2.setSelection(hXz.length());
            }
        }
        EditText editText3 = textStatusDoWhatActivity.VeW;
        if (editText3 != null) {
            editText3.removeTextChangedListener(textStatusDoWhatActivity.VeX);
        }
        EditText editText4 = textStatusDoWhatActivity.VeW;
        if (editText4 != null) {
            editText4.addTextChangedListener(textStatusDoWhatActivity.VeX);
        }
        View view3 = textStatusDoWhatActivity.VeV;
        if (!(view3 == null || (inputPanelLinearLayout = (InputPanelLinearLayout) view3.findViewById(R.id.jtz)) == null)) {
            inputPanelLinearLayout.setExternalListener(textStatusDoWhatActivity);
        }
        View view4 = textStatusDoWhatActivity.VeV;
        if (!(view4 == null || (button2 = (Button) view4.findViewById(R.id.aib)) == null)) {
            button2.setOnClickListener(new j(textStatusDoWhatActivity));
        }
        View view5 = textStatusDoWhatActivity.VeV;
        if (!(view5 == null || (button = (Button) view5.findViewById(R.id.b_4)) == null)) {
            button.setOnClickListener(new k(textStatusDoWhatActivity, cVar));
        }
        EditText editText5 = textStatusDoWhatActivity.VeW;
        if (editText5 != null) {
            editText5.requestFocus();
        }
        textStatusDoWhatActivity.showVKB();
        AppMethodBeat.o(258467);
    }
}
