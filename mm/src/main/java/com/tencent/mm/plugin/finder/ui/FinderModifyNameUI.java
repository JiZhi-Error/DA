package com.tencent.mm.plugin.finder.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.b;
import java.util.HashMap;
import java.util.regex.Matcher;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0014\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010,\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010-\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010.\u001a\u00020\tH\u0014J\b\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0014J\"\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u000106H\u0014J\u0012\u00107\u001a\u00020)2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020)H\u0014J\u0018\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0018\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020)H\u0014J,\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t2\b\u0010F\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020)H\u0002J\u0016\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00112\u0006\u0010+\u001a\u00020KJ(\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020\u000b2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006P"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_SELECT_AT_CONTACT", "", "TAG", "", "edit", "Landroid/widget/EditText;", "editBottomSpace", "Landroid/view/View;", "editLimit", "Landroid/widget/TextView;", "edtContainer", "edtLayoutListener", "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1;", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "keyboardHeight", "modifyBtn", "Landroid/widget/Button;", "modifyCountTip", "nicknameMaxLength", "progressDialog", "Landroid/app/ProgressDialog;", "scene", "scrollView", "Landroid/widget/ScrollView;", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "signatureMaxLength", "titleTv", "topErrorTip", "doPrepareUser", "", "doWhenLess", "text", "doWhenMore", "doWhenOK", "getLayoutId", "getMaxLength", "hideError", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "setSpanTouch", "descTv", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "plugin-finder_release"})
public final class FinderModifyNameUI extends MMFinderUI implements i, ai<azg>, c.a, b.a {
    private final String TAG = "Finder.FinderModifyNameUI";
    private HashMap _$_findViewCache;
    private ScrollView gxx;
    private int oXi;
    private int scene;
    private TextView titleTv;
    private com.tencent.mm.plugin.finder.api.g uCY;
    private View uht;
    private ProgressDialog vIA;
    private int vIE = 20;
    private View vIp;
    private InputPanelFrameLayout vIq;
    private TextView vIr;
    private EditText vMl;
    private TextView vMm;
    private Button vMn;
    private View vMo;
    private TextView vMp;
    private int vMq = 400;
    private final int vMr = 20001;
    private final a vMs = new a(this);

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252549);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252549);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252548);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252548);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class g extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ String vJf;
        final /* synthetic */ String vJg;
        final /* synthetic */ FinderModifyNameUI vMt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderModifyNameUI finderModifyNameUI, String str, String str2) {
            super(1);
            this.vMt = finderModifyNameUI;
            this.vJf = str;
            this.vJg = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(252542);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            Log.i(this.vMt.TAG, "click ".concat(String.valueOf(str2)));
            y yVar = y.vXH;
            String str3 = this.vJf;
            String str4 = this.vJg;
            if (!(str3 == null || str4 == null)) {
                wq wqVar = new wq();
                wqVar.ecI.userName = str3;
                wqVar.ecI.ecK = str4;
                EventCenter.instance.publish(wqVar);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252542);
            return xVar;
        }
    }

    public FinderModifyNameUI() {
        AppMethodBeat.i(167455);
        AppMethodBeat.o(167455);
    }

    public static final /* synthetic */ EditText b(FinderModifyNameUI finderModifyNameUI) {
        AppMethodBeat.i(167456);
        EditText editText = finderModifyNameUI.vMl;
        if (editText == null) {
            p.btv("edit");
        }
        AppMethodBeat.o(167456);
        return editText;
    }

    public static final /* synthetic */ int f(FinderModifyNameUI finderModifyNameUI) {
        AppMethodBeat.i(167457);
        int maxLength = finderModifyNameUI.getMaxLength();
        AppMethodBeat.o(167457);
        return maxLength;
    }

    public static final /* synthetic */ ScrollView h(FinderModifyNameUI finderModifyNameUI) {
        AppMethodBeat.i(167458);
        ScrollView scrollView = finderModifyNameUI.gxx;
        if (scrollView == null) {
            p.btv("scrollView");
        }
        AppMethodBeat.o(167458);
        return scrollView;
    }

    public static final /* synthetic */ View i(FinderModifyNameUI finderModifyNameUI) {
        AppMethodBeat.i(167459);
        View view = finderModifyNameUI.uht;
        if (view == null) {
            p.btv("inputContainer");
        }
        AppMethodBeat.o(167459);
        return view;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
    @Override // com.tencent.mm.plugin.i.a.ai
    public final /* synthetic */ void a(azg azg, apg apg) {
        byte[] bArr;
        AppMethodBeat.i(167449);
        p.h(azg, "req");
        p.h(apg, "ret");
        ProgressDialog progressDialog = this.vIA;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        switch (apg.retCode) {
            case 0:
                u.makeText(this, getString(R.string.daz), 0).show();
                finish();
                AppMethodBeat.o(167449);
                return;
            default:
                azh azh = new azh();
                if (apg.LBp != null) {
                    com.tencent.mm.bw.b bVar = apg.LBp;
                    if (bVar != null) {
                        bArr = bVar.toByteArray();
                    } else {
                        bArr = null;
                    }
                    azh.parseFrom(bArr);
                }
                com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
                if (com.tencent.mm.plugin.finder.spam.a.ba(apg.retCode, apg.qwG)) {
                    if (apg.retCode == -4003) {
                        h.INSTANCE.n(1279, 37, 1);
                    } else if (apg.retCode == -4008) {
                        h.INSTANCE.n(1279, 38, 1);
                    }
                    azn azn = azh.verifyInfo;
                    if (azn != null) {
                        if (!Util.isNullOrNil(azn.LJo)) {
                            String str = azn.LJo;
                            if (str == null) {
                                str = "";
                            }
                            aj(str, azn.LJt, azn.LJs);
                            AppMethodBeat.o(167449);
                            return;
                        }
                        String string = getString(R.string.ckb);
                        p.g(string, "getString(R.string.finde…reate_contact_failed_tip)");
                        aj(string, null, null);
                        AppMethodBeat.o(167449);
                        return;
                    }
                }
                AppMethodBeat.o(167449);
                return;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167443);
        super.onCreate(bundle);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        this.uCY = c.a.asG(z.aUg());
        this.scene = getIntent().getIntExtra("key_scene", 0);
        initView();
        com.tencent.mm.kernel.g.azz().a(3761, this);
        AppMethodBeat.o(167443);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        String str = null;
        AppMethodBeat.i(167444);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        getController().p(this, getResources().getColor(R.color.afz));
        View findViewById = findViewById(R.id.d08);
        p.g(findViewById, "findViewById(R.id.finder_modify_name_container)");
        this.vMo = findViewById;
        View findViewById2 = findViewById(R.id.cmg);
        p.g(findViewById2, "findViewById(R.id.finder_input_container)");
        this.uht = findViewById2;
        View findViewById3 = findViewById(R.id.d09);
        p.g(findViewById3, "findViewById(R.id.finder_modify_title)");
        this.titleTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.cl5);
        p.g(findViewById4, "findViewById(R.id.finder_edit)");
        this.vMl = (EditText) findViewById4;
        View findViewById5 = findViewById(R.id.cl6);
        p.g(findViewById5, "findViewById(R.id.finder_edit_limit)");
        this.vMm = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.by1);
        p.g(findViewById6, "findViewById(R.id.edt_bottom_space)");
        this.vIp = findViewById6;
        View findViewById7 = findViewById(R.id.d07);
        p.g(findViewById7, "findViewById(R.id.finder_modify_btn)");
        this.vMn = (Button) findViewById7;
        View findViewById8 = findViewById(R.id.fj7);
        p.g(findViewById8, "findViewById(R.id.modify_max_tip)");
        this.vMp = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.hcm);
        p.g(findViewById9, "findViewById(R.id.scroll_container)");
        this.gxx = (ScrollView) findViewById9;
        View findViewById10 = findViewById(R.id.dyy);
        p.g(findViewById10, "findViewById(R.id.input_panel)");
        this.vIq = (InputPanelFrameLayout) findViewById10;
        View findViewById11 = findViewById(R.id.isu);
        p.g(findViewById11, "findViewById(R.id.top_error_tip)");
        this.vIr = (TextView) findViewById11;
        Button button = this.vMn;
        if (button == null) {
            p.btv("modifyBtn");
        }
        button.setOnClickListener(new b(this));
        e eVar = new e(this);
        EditText editText = this.vMl;
        if (editText == null) {
            p.btv("edit");
        }
        editText.addTextChangedListener(eVar);
        EditText editText2 = this.vMl;
        if (editText2 == null) {
            p.btv("edit");
        }
        editText2.setOnTouchListener(new c(this));
        setBackBtn(new d(this));
        InputPanelFrameLayout inputPanelFrameLayout = this.vIq;
        if (inputPanelFrameLayout == null) {
            p.btv("inputPanel");
        }
        inputPanelFrameLayout.setExternalListener(this);
        switch (this.scene) {
            case 1:
                EditText editText3 = this.vMl;
                if (editText3 == null) {
                    p.btv("edit");
                }
                editText3.setMaxLines(1);
                EditText editText4 = this.vMl;
                if (editText4 == null) {
                    p.btv("edit");
                }
                AppCompatActivity context = getContext();
                com.tencent.mm.plugin.finder.api.g gVar = this.uCY;
                if (gVar != null) {
                    str = gVar.getNickname();
                }
                editText4.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, str));
                TextView textView = this.titleTv;
                if (textView == null) {
                    p.btv("titleTv");
                }
                textView.setText(getString(R.string.d1r));
                break;
            case 2:
                TextView textView2 = this.titleTv;
                if (textView2 == null) {
                    p.btv("titleTv");
                }
                textView2.setText(getString(R.string.d1s));
                EditText editText5 = this.vMl;
                if (editText5 == null) {
                    p.btv("edit");
                }
                editText5.setMaxLines(5);
                EditText editText6 = this.vMl;
                if (editText6 == null) {
                    p.btv("edit");
                }
                AppCompatActivity context2 = getContext();
                com.tencent.mm.plugin.finder.api.g gVar2 = this.uCY;
                if (gVar2 != null) {
                    str = gVar2.field_signature;
                }
                editText6.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context2, str));
                break;
        }
        refreshView();
        EditText editText7 = this.vMl;
        if (editText7 == null) {
            p.btv("edit");
        }
        editText7.requestFocus();
        AppMethodBeat.o(167444);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ FinderModifyNameUI vMt;

        b(FinderModifyNameUI finderModifyNameUI) {
            this.vMt = finderModifyNameUI;
        }

        public final void onClick(View view) {
            boolean z;
            String str;
            AppMethodBeat.i(167438);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (com.tencent.mm.plugin.finder.spam.a.avp("personalInfo")) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(167438);
                return;
            }
            Log.i(this.vMt.TAG, "doClick create contact btn");
            String obj = FinderModifyNameUI.b(this.vMt).getText().toString();
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(167438);
                throw tVar;
            }
            String obj2 = n.trim(obj).toString();
            String str2 = "";
            switch (this.vMt.scene) {
                case 1:
                    if (!(obj2.length() == 0)) {
                        if (com.tencent.mm.ui.tools.f.bnP(obj2) > this.vMt.vIE) {
                            str = this.vMt.getString(R.string.cpe, new Object[]{this.vMt.getString(R.string.d38)});
                            p.g(str, "getString(R.string.finde….string.finder_nickname))");
                        } else {
                            str = str2;
                        }
                        str2 = str;
                        break;
                    } else {
                        str2 = this.vMt.getString(R.string.cpd, new Object[]{this.vMt.getString(R.string.d38)});
                        p.g(str2, "getString(R.string.finde….string.finder_nickname))");
                        break;
                    }
                case 2:
                    if (com.tencent.mm.ui.tools.f.bnP(obj2) > this.vMt.vMq) {
                        str2 = this.vMt.getString(R.string.cpe, new Object[]{this.vMt.getString(R.string.d_0)});
                        p.g(str2, "getString(R.string.finde…string.finder_signature))");
                        break;
                    }
                    break;
                default:
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(167438);
                    return;
            }
            if (str2.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                switch (this.vMt.scene) {
                    case 1:
                        ((com.tencent.mm.plugin.i.a.x) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.x.class)).d(obj2, this.vMt);
                        this.vMt.vIA = com.tencent.mm.ui.base.h.a((Context) this.vMt, this.vMt.getString(R.string.zo), false, (DialogInterface.OnCancelListener) null);
                        break;
                    case 2:
                        ((com.tencent.mm.plugin.i.a.x) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.x.class)).e(obj2, this.vMt);
                        this.vMt.vIA = com.tencent.mm.ui.base.h.a((Context) this.vMt, this.vMt.getString(R.string.zo), false, (DialogInterface.OnCancelListener) null);
                        break;
                }
            } else {
                FinderModifyNameUI.a(this.vMt, str2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167438);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
    public static final class e implements TextWatcher {
        final /* synthetic */ FinderModifyNameUI vMt;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "start", "", "end", "nickname", "", "invoke"})
        static final class a extends q implements kotlin.g.a.q<Integer, Integer, String, x> {
            final /* synthetic */ Editable vMu;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Editable editable) {
                super(3);
                this.vMu = editable;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ x d(Integer num, Integer num2, String str) {
                AppMethodBeat.i(252539);
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                p.h(str, "nickname");
                Editable editable = this.vMu;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                editable.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.x0)), intValue, intValue2, 17);
                x xVar = x.SXb;
                AppMethodBeat.o(252539);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderModifyNameUI finderModifyNameUI) {
            this.vMt = finderModifyNameUI;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(167441);
            com.tencent.mm.ui.tools.b.c.f(FinderModifyNameUI.b(this.vMt)).lv(1, FinderModifyNameUI.f(this.vMt)).a(f.a.MODE_CHINESE_AS_2).CN(true).a(this.vMt);
            if (this.vMt.scene == 2 && editable != null) {
                ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) editable.getSpans(0, editable.length(), ForegroundColorSpan.class);
                p.g(foregroundColorSpanArr, "spans");
                for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                    editable.removeSpan(foregroundColorSpan);
                }
                com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
                com.tencent.mm.plugin.finder.utils.d.a(editable.toString(), new a(editable));
            }
            AppMethodBeat.o(167441);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Character ch = null;
            AppMethodBeat.i(252540);
            if (this.vMt.scene == 2 && i4 == 1) {
                if (charSequence != null) {
                    p.h(charSequence, "$this$getOrNull");
                    if (i2 >= 0 && i2 <= n.aO(charSequence)) {
                        ch = Character.valueOf(charSequence.charAt(i2));
                    }
                }
                if (ch == null) {
                    AppMethodBeat.o(252540);
                    return;
                } else if (ch.charValue() == '@') {
                    Log.i(this.vMt.TAG, "at auto goto");
                    Intent intent = new Intent();
                    intent.putExtra("key_scene", 2);
                    intent.putExtra("KEY_ENTER_SCENE", 1);
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.c(this.vMt, intent, this.vMt.vMr);
                }
            }
            AppMethodBeat.o(252540);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    public static final class c implements View.OnTouchListener {
        final /* synthetic */ FinderModifyNameUI vMt;

        c(FinderModifyNameUI finderModifyNameUI) {
            this.vMt = finderModifyNameUI;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(167439);
            if (p.j(view, FinderModifyNameUI.b(this.vMt))) {
                p.g(motionEvent, "event");
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        FinderModifyNameUI.h(this.vMt).requestDisallowInterceptTouchEvent(true);
                        break;
                    case 1:
                    case 3:
                        FinderModifyNameUI.h(this.vMt).requestDisallowInterceptTouchEvent(false);
                        break;
                }
            }
            AppMethodBeat.o(167439);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderModifyNameUI vMt;

        d(FinderModifyNameUI finderModifyNameUI) {
            this.vMt = finderModifyNameUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167440);
            this.vMt.finish();
            AppMethodBeat.o(167440);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        cjj cjj;
        int i4;
        AppMethodBeat.i(252543);
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.vMr) {
            showVKB();
            if (intent != null && i3 == -1) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("key_select_contact");
                if (byteArrayExtra != null) {
                    try {
                        cjj cjj2 = new cjj();
                        cjj2.parseFrom(byteArrayExtra);
                        cjj = cjj2;
                    } catch (Exception e2) {
                        Log.e(this.TAG, "onActivityResult LocalFinderAtContact parseFrom:%s", e2.getMessage());
                        cjj = null;
                    }
                } else {
                    cjj = null;
                }
                if (cjj != null) {
                    if (!Util.isNullOrNil(cjj.nickname)) {
                        EditText editText = this.vMl;
                        if (editText == null) {
                            p.btv("edit");
                        }
                        int selectionEnd = editText.getSelectionEnd();
                        EditText editText2 = this.vMl;
                        if (editText2 == null) {
                            p.btv("edit");
                        }
                        String obj = editText2.getText().toString();
                        if (this.scene == 2) {
                            EditText editText3 = this.vMl;
                            if (editText3 == null) {
                                p.btv("edit");
                            }
                            int selectionEnd2 = editText3.getSelectionEnd();
                            if (selectionEnd2 > 0) {
                                int i5 = selectionEnd2 - 1;
                                boolean z = true;
                                while (i5 >= 0 && z) {
                                    EditText editText4 = this.vMl;
                                    if (editText4 == null) {
                                        p.btv("edit");
                                    }
                                    if (editText4.getText().toString().charAt(i5) == '@') {
                                        i5--;
                                    } else {
                                        z = false;
                                    }
                                }
                                selectionEnd = i5 + 1;
                                if (selectionEnd > obj.length()) {
                                    selectionEnd = obj.length();
                                }
                                StringBuilder sb = new StringBuilder();
                                if (obj == null) {
                                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                                    AppMethodBeat.o(252543);
                                    throw tVar;
                                }
                                String substring = obj.substring(0, selectionEnd);
                                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                StringBuilder append = sb.append(substring);
                                int length = obj.length();
                                if (obj == null) {
                                    t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                                    AppMethodBeat.o(252543);
                                    throw tVar2;
                                }
                                String substring2 = obj.substring(selectionEnd2, length);
                                p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                obj = append.append(substring2).toString();
                            }
                        }
                        if (selectionEnd > obj.length()) {
                            i4 = obj.length();
                        } else {
                            i4 = selectionEnd;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        if (obj == null) {
                            t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                            AppMethodBeat.o(252543);
                            throw tVar3;
                        }
                        String substring3 = obj.substring(0, i4);
                        p.g(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        StringBuilder append2 = sb2.append(substring3).append('@').append(cjj.nickname).append(' ');
                        int length2 = obj.length();
                        if (obj == null) {
                            t tVar4 = new t("null cannot be cast to non-null type java.lang.String");
                            AppMethodBeat.o(252543);
                            throw tVar4;
                        }
                        String substring4 = obj.substring(i4, length2);
                        p.g(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String sb3 = append2.append(substring4).toString();
                        String str = cjj.nickname;
                        int length3 = (str != null ? str.length() : 0) + i4 + 2;
                        EditText editText5 = this.vMl;
                        if (editText5 == null) {
                            p.btv("edit");
                        }
                        editText5.setText(sb3);
                        EditText editText6 = this.vMl;
                        if (editText6 == null) {
                            p.btv("edit");
                        }
                        editText6.setSelection(length3);
                    }
                    AppMethodBeat.o(252543);
                    return;
                }
            }
        }
        AppMethodBeat.o(252543);
    }

    private final void refreshView() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(167445);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
        Log.i(this.TAG, "user extFlag ".concat(String.valueOf(i2)));
        if (this.scene == 1) {
            if ((i2 & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            EditText editText = this.vMl;
            if (editText == null) {
                p.btv("edit");
            }
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            editText.setEnabled(z2);
            Button button = this.vMn;
            if (button == null) {
                p.btv("modifyBtn");
            }
            if (z) {
                z3 = false;
            }
            button.setEnabled(z3);
        }
        AppMethodBeat.o(167445);
    }

    private final int getMaxLength() {
        switch (this.scene) {
            case 1:
                return this.vIE;
            case 2:
                return this.vMq;
            default:
                return Integer.MAX_VALUE;
        }
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void Tw(String str) {
        AppMethodBeat.i(167446);
        int dp = com.tencent.mm.ui.tools.f.dp(getMaxLength(), str);
        TextView textView = this.vMm;
        if (textView == null) {
            p.btv("editLimit");
        }
        textView.setText(String.valueOf(dp));
        TextView textView2 = this.vMm;
        if (textView2 == null) {
            p.btv("editLimit");
        }
        textView2.setTextColor(getResources().getColor(R.color.BW_0_Alpha_0_3));
        if (dp <= j.mZ((int) (((float) getMaxLength()) * 0.1f), 1)) {
            TextView textView3 = this.vMm;
            if (textView3 == null) {
                p.btv("editLimit");
            }
            textView3.setVisibility(0);
        } else {
            TextView textView4 = this.vMm;
            if (textView4 == null) {
                p.btv("editLimit");
            }
            textView4.setVisibility(4);
        }
        TextView textView5 = this.vIr;
        if (textView5 == null) {
            p.btv("topErrorTip");
        }
        textView5.setText("");
        TextView textView6 = this.vIr;
        if (textView6 == null) {
            p.btv("topErrorTip");
        }
        textView6.setVisibility(8);
        AppMethodBeat.o(167446);
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void Tx(String str) {
        AppMethodBeat.i(252544);
        TextView textView = this.vMm;
        if (textView == null) {
            p.btv("editLimit");
        }
        textView.setText(String.valueOf(getMaxLength()));
        TextView textView2 = this.vMm;
        if (textView2 == null) {
            p.btv("editLimit");
        }
        textView2.setTextColor(getResources().getColor(R.color.BW_0_Alpha_0_3));
        AppMethodBeat.o(252544);
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void dv(String str) {
        AppMethodBeat.i(167448);
        TextView textView = this.vMm;
        if (textView == null) {
            p.btv("editLimit");
        }
        textView.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        TextView textView2 = this.vMm;
        if (textView2 == null) {
            p.btv("editLimit");
        }
        textView2.setVisibility(0);
        TextView textView3 = this.vMm;
        if (textView3 == null) {
            p.btv("editLimit");
        }
        textView3.setTextColor(getResources().getColor(R.color.Red_100));
        AppMethodBeat.o(167448);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
    public static final class a implements View.OnLayoutChangeListener {
        final /* synthetic */ FinderModifyNameUI vMt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderModifyNameUI finderModifyNameUI) {
            this.vMt = finderModifyNameUI;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(167437);
            if (i9 != i5) {
                int dimensionPixelSize = this.vMt.getResources().getDimensionPixelSize(R.dimen.ct);
                if (i9 < i5) {
                    if (FinderModifyNameUI.i(this.vMt).getHeight() < dimensionPixelSize) {
                        FinderModifyNameUI.i(this.vMt).scrollBy(0, i5 - i9);
                        AppMethodBeat.o(167437);
                        return;
                    }
                } else if (FinderModifyNameUI.i(this.vMt).getScrollY() > 0) {
                    FinderModifyNameUI.i(this.vMt).scrollBy(0, i5 - i9);
                }
            }
            AppMethodBeat.o(167437);
        }
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(167450);
        this.oXi = i2;
        if (z) {
            String str = this.TAG;
            StringBuilder append = new StringBuilder("keyboardHeight ").append(i2).append(", inputContainer.height ");
            View view = this.uht;
            if (view == null) {
                p.btv("inputContainer");
            }
            Log.i(str, append.append(view.getHeight()).toString());
            View view2 = this.vMo;
            if (view2 == null) {
                p.btv("edtContainer");
            }
            view2.addOnLayoutChangeListener(this.vMs);
            Button button = this.vMn;
            if (button == null) {
                p.btv("modifyBtn");
            }
            ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                AppMethodBeat.o(167450);
                throw tVar;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin = 0;
            Button button2 = this.vMn;
            if (button2 == null) {
                p.btv("modifyBtn");
            }
            button2.setLayoutParams(layoutParams2);
            View view3 = this.uht;
            if (view3 == null) {
                p.btv("inputContainer");
            }
            ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
            if (layoutParams3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(167450);
                throw tVar2;
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            View view4 = this.uht;
            if (view4 == null) {
                p.btv("inputContainer");
            }
            layoutParams4.height = view4.getHeight() - i2;
            View view5 = this.uht;
            if (view5 == null) {
                p.btv("inputContainer");
            }
            view5.setLayoutParams(layoutParams4);
            View view6 = this.uht;
            if (view6 == null) {
                p.btv("inputContainer");
            }
            view6.requestLayout();
            AppMethodBeat.o(167450);
            return;
        }
        View view7 = this.vMo;
        if (view7 == null) {
            p.btv("edtContainer");
        }
        view7.removeOnLayoutChangeListener(this.vMs);
        Button button3 = this.vMn;
        if (button3 == null) {
            p.btv("modifyBtn");
        }
        ViewGroup.LayoutParams layoutParams5 = button3.getLayoutParams();
        if (layoutParams5 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(167450);
            throw tVar3;
        }
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
        layoutParams6.bottomMargin = getResources().getDimensionPixelSize(R.dimen.bx);
        Button button4 = this.vMn;
        if (button4 == null) {
            p.btv("modifyBtn");
        }
        button4.setLayoutParams(layoutParams6);
        View view8 = this.uht;
        if (view8 == null) {
            p.btv("inputContainer");
        }
        ViewGroup.LayoutParams layoutParams7 = view8.getLayoutParams();
        if (layoutParams7 == null) {
            t tVar4 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(167450);
            throw tVar4;
        }
        FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) layoutParams7;
        layoutParams8.height = -1;
        View view9 = this.uht;
        if (view9 == null) {
            p.btv("inputContainer");
        }
        view9.setLayoutParams(layoutParams8);
        View view10 = this.uht;
        if (view10 == null) {
            p.btv("inputContainer");
        }
        view10.requestLayout();
        View view11 = this.uht;
        if (view11 == null) {
            p.btv("inputContainer");
        }
        view11.scrollTo(0, 0);
        AppMethodBeat.o(167450);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(167451);
        super.onResume();
        com.tencent.mm.kernel.g.azz().b(new cd(2));
        AppMethodBeat.o(167451);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(167452);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(3761, this);
        AppMethodBeat.o(167452);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z = true;
        AppMethodBeat.i(167453);
        Log.i(this.TAG, "onSceneEnd errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        Integer valueOf = qVar != null ? Integer.valueOf(qVar.getType()) : null;
        if (valueOf == null) {
            AppMethodBeat.o(167453);
            return;
        }
        if (valueOf.intValue() == 3761 && i2 == 0 && i3 == 0) {
            if (qVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
                AppMethodBeat.o(167453);
                throw tVar;
            }
            bed cZc = ((cd) qVar).cZc();
            if (cZc != null) {
                String str2 = cZc.LNL;
                if (str2 != null) {
                    if (this.scene != 1) {
                        z = false;
                    }
                    if (!z) {
                        str2 = null;
                    }
                    if (str2 != null) {
                        TextView textView = this.vMp;
                        if (textView == null) {
                            p.btv("modifyCountTip");
                        }
                        textView.setText(((cd) qVar).cZc().LNL);
                        TextView textView2 = this.vMp;
                        if (textView2 == null) {
                            p.btv("modifyCountTip");
                        }
                        textView2.setVisibility(0);
                    }
                }
                if (cZc.vIE > 0) {
                    this.vIE = cZc.vIE;
                }
                if (cZc.vMq > 0) {
                    this.vMq = cZc.vMq;
                }
            }
            refreshView();
        }
        AppMethodBeat.o(167453);
    }

    static /* synthetic */ void a(FinderModifyNameUI finderModifyNameUI, String str) {
        AppMethodBeat.i(252546);
        finderModifyNameUI.aj(str, null, null);
        AppMethodBeat.o(252546);
    }

    private final void aj(String str, String str2, String str3) {
        AppMethodBeat.i(252545);
        Log.i(this.TAG, "showError ".concat(String.valueOf(str)));
        Matcher matcher = k.PATTERN.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            StringBuilder sb = new StringBuilder();
            if (matcher.start(0) > 0) {
                int start = matcher.start(0);
                if (str == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(252545);
                    throw tVar;
                }
                String substring = str.substring(0, start);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
            }
            sb.append(group);
            if (matcher.end(0) < str.length()) {
                int end = matcher.end(0);
                int length = str.length();
                if (str == null) {
                    t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(252545);
                    throw tVar2;
                }
                String substring2 = str.substring(end, length);
                p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring2);
            }
            String sb2 = sb.toString();
            p.g(sb2, "sb.toString()");
            int start2 = matcher.start(0);
            int length2 = start2 + group.length();
            SpannableString spannableString = new SpannableString(sb2);
            p.g(group, "content");
            AppCompatActivity context = getContext();
            p.g(context, "context");
            int color = context.getResources().getColor(R.color.Link);
            AppCompatActivity context2 = getContext();
            p.g(context2, "context");
            spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(group, color, context2.getResources().getColor(R.color.Link_Alpha_0_6), new g(this, str2, str3)), start2, length2, 17);
            TextView textView = this.vIr;
            if (textView == null) {
                p.btv("topErrorTip");
            }
            textView.setText(spannableString);
            TextView textView2 = this.vIr;
            if (textView2 == null) {
                p.btv("topErrorTip");
            }
            a(textView2, spannableString);
        } else {
            TextView textView3 = this.vIr;
            if (textView3 == null) {
                p.btv("topErrorTip");
            }
            textView3.setText(str);
        }
        TextView textView4 = this.vIr;
        if (textView4 == null) {
            p.btv("topErrorTip");
        }
        textView4.setVisibility(0);
        AppMethodBeat.o(252545);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.agy;
    }

    private void a(TextView textView, Spannable spannable) {
        AppMethodBeat.i(252547);
        p.h(textView, "descTv");
        p.h(spannable, "text");
        textView.setOnTouchListener(new f(this, spannable, textView));
        AppMethodBeat.o(252547);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    public static final class f implements View.OnTouchListener {
        final /* synthetic */ Spannable vJd;
        final /* synthetic */ TextView vJe;
        final /* synthetic */ FinderModifyNameUI vMt;

        f(FinderModifyNameUI finderModifyNameUI, Spannable spannable, TextView textView) {
            this.vMt = finderModifyNameUI;
            this.vJd = spannable;
            this.vJe = textView;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            ClickableSpan[] clickableSpanArr;
            AppMethodBeat.i(252541);
            p.g(motionEvent, "event");
            int action = motionEvent.getAction();
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(252541);
                throw tVar;
            }
            TextView textView = (TextView) view;
            Spannable spannable = this.vJd;
            if ((action == 1 || action == 3) && (clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, this.vJd.length(), ClickableSpan.class)) != null) {
                for (ClickableSpan clickableSpan : clickableSpanArr) {
                    if (clickableSpan instanceof com.tencent.mm.pluginsdk.ui.span.p) {
                        ((com.tencent.mm.pluginsdk.ui.span.p) clickableSpan).setIsPressed(false);
                        this.vJe.invalidate();
                    }
                }
            }
            if (action == 1 || action == 0) {
                int x = ((int) motionEvent.getX()) - textView.getPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
                ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr2.length != 0) {
                    ClickableSpan clickableSpan2 = clickableSpanArr2[0];
                    if (action == 1) {
                        clickableSpan2.onClick(textView);
                    } else if (action == 0) {
                        if (clickableSpan2 instanceof com.tencent.mm.pluginsdk.ui.span.p) {
                            ((com.tencent.mm.pluginsdk.ui.span.p) clickableSpan2).setIsPressed(true);
                            this.vJe.invalidate();
                        }
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpan2), spannable.getSpanEnd(clickableSpan2));
                    }
                    z = true;
                    Log.i(this.vMt.TAG, "touch " + motionEvent.getX() + ", " + motionEvent.getY() + ", ret:" + z);
                    AppMethodBeat.o(252541);
                    return z;
                }
                Selection.removeSelection(spannable);
            }
            z = false;
            Log.i(this.vMt.TAG, "touch " + motionEvent.getX() + ", " + motionEvent.getY() + ", ret:" + z);
            AppMethodBeat.o(252541);
            return z;
        }
    }
}
