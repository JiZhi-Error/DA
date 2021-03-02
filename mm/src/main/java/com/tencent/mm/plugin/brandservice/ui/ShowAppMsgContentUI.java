package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0014J\b\u0010\u001a\u001a\u00020\bH\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/ShowAppMsgContentUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "MENU_ID_COPY", "", "getMENU_ID_COPY", "()I", "TAG", "", "contentTV", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getContentTV", "()Landroid/widget/TextView;", "contentTV$delegate", "Lkotlin/Lazy;", "msgId", "", "getMsgId", "()J", "msgId$delegate", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "getMoreInfo", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-brandservice_release"})
public final class ShowAppMsgContentUI extends MMActivity {
    private final String TAG = "MicroMsg.ShowAppMsgContentUI";
    private HashMap _$_findViewCache;
    private ca dTX;
    final int pqh = 1;
    private final kotlin.f pqi = g.ah(new a(this));
    private final kotlin.f pqj = g.ah(new b(this));
    private q tipDialog;

    private final long ajL() {
        AppMethodBeat.i(6523);
        long longValue = ((Number) this.pqj.getValue()).longValue();
        AppMethodBeat.o(6523);
        return longValue;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(195150);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(195150);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(195149);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(195149);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ ShowAppMsgContentUI pqk;

        c(ShowAppMsgContentUI showAppMsgContentUI) {
            this.pqk = showAppMsgContentUI;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(6516);
            CharSequence cmi = cmi();
            AppMethodBeat.o(6516);
            return cmi;
        }

        private CharSequence cmi() {
            String str;
            AppMethodBeat.i(175479);
            try {
                TextView c2 = ShowAppMsgContentUI.c(this.pqk);
                p.g(c2, "contentTV");
                str = com.tencent.mm.pluginsdk.ui.span.l.a(this.pqk, ShowAppMsgContentUI.a(this.pqk) + "\n" + ShowAppMsgContentUI.b(this.pqk).getContent(), (int) c2.getTextSize(), 1, (Object) null, (String) null);
            } catch (Exception e2) {
                Log.e(this.pqk.TAG, "spanForTextViewWithExtra ex: " + e2.getMessage());
            }
            AppMethodBeat.o(175479);
            return str;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "str", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/CharSequence;)Lkotlin/Unit;"})
    static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ ShowAppMsgContentUI pqk;

        d(ShowAppMsgContentUI showAppMsgContentUI) {
            this.pqk = showAppMsgContentUI;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(6517);
            TextView c2 = ShowAppMsgContentUI.c(this.pqk);
            p.g(c2, "contentTV");
            c2.setText((CharSequence) obj);
            q qVar = this.pqk.tipDialog;
            if (qVar != null) {
                qVar.dismiss();
                x xVar = x.SXb;
                AppMethodBeat.o(6517);
                return xVar;
            }
            AppMethodBeat.o(6517);
            return null;
        }
    }

    public ShowAppMsgContentUI() {
        AppMethodBeat.i(6526);
        AppMethodBeat.o(6526);
    }

    public static final /* synthetic */ ca b(ShowAppMsgContentUI showAppMsgContentUI) {
        AppMethodBeat.i(6528);
        ca caVar = showAppMsgContentUI.dTX;
        if (caVar == null) {
            p.btv("msgInfo");
        }
        AppMethodBeat.o(6528);
        return caVar;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(6524);
        super.onCreate(bundle);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().Hb(ajL());
        p.g(Hb, "MMKernel.service(IMessen…msgInfoStg.getById(msgId)");
        this.dTX = Hb;
        ca caVar = this.dTX;
        if (caVar == null) {
            p.btv("msgInfo");
        }
        if (caVar != null) {
            ca caVar2 = this.dTX;
            if (caVar2 == null) {
                p.btv("msgInfo");
            }
            if (caVar2.ajL() > 0) {
                getContext().getString(R.string.zb);
                this.tipDialog = h.a((Context) getContext(), getContext().getString(R.string.a06), true, (DialogInterface.OnCancelListener) null);
                com.tencent.mm.co.g.hio().j(new c(this)).b(new d(this));
                setBackBtn(new e(this));
                setMMTitle(R.string.f0_);
                addIconOptionMenu(0, getString(R.string.wp), R.raw.actionbar_icon_dark_more, new f(this));
                AppMethodBeat.o(6524);
                return;
            }
        }
        Log.w(this.TAG, "onCreate msg is invalid %d", Long.valueOf(ajL()));
        finish();
        AppMethodBeat.o(6524);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ShowAppMsgContentUI pqk;

        e(ShowAppMsgContentUI showAppMsgContentUI) {
            this.pqk = showAppMsgContentUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(6518);
            this.pqk.hideVKB();
            this.pqk.finish();
            AppMethodBeat.o(6518);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class f implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ShowAppMsgContentUI pqk;

        f(ShowAppMsgContentUI showAppMsgContentUI) {
            this.pqk = showAppMsgContentUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(6521);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.pqk, 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.brandservice.ui.ShowAppMsgContentUI.f.AnonymousClass1 */
                final /* synthetic */ f pql;

                {
                    this.pql = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(6519);
                    mVar.kV(this.pql.pqk.pqh, R.string.t_);
                    AppMethodBeat.o(6519);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.brandservice.ui.ShowAppMsgContentUI.f.AnonymousClass2 */
                final /* synthetic */ f pql;

                {
                    this.pql = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(6520);
                    p.g(menuItem, "menuItem");
                    if (menuItem.getItemId() == this.pql.pqk.pqh) {
                        ClipboardHelper.setText(MMApplicationContext.getContext(), null, ShowAppMsgContentUI.b(this.pql.pqk).getContent());
                        h.cA(this.pql.pqk.getContext(), this.pql.pqk.getContext().getString(R.string.ta));
                        AppMethodBeat.o(6520);
                        return;
                    }
                    Log.w(this.pql.pqk.TAG, "default onMMMenuItemSelected err");
                    AppMethodBeat.o(6520);
                }
            });
            eVar.dGm();
            AppMethodBeat.o(6521);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(6525);
        super.onDestroy();
        q qVar = this.tipDialog;
        if (qVar != null) {
            if (qVar.isShowing()) {
                qVar.dismiss();
            }
            AppMethodBeat.o(6525);
            return;
        }
        AppMethodBeat.o(6525);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bsd;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ ShowAppMsgContentUI pqk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ShowAppMsgContentUI showAppMsgContentUI) {
            super(0);
            this.pqk = showAppMsgContentUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(6514);
            TextView textView = (TextView) this.pqk.findViewById(R.id.bfe);
            AppMethodBeat.o(6514);
            return textView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<Long> {
        final /* synthetic */ ShowAppMsgContentUI pqk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ShowAppMsgContentUI showAppMsgContentUI) {
            super(0);
            this.pqk = showAppMsgContentUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(6515);
            Long valueOf = Long.valueOf(this.pqk.getIntent().getLongExtra("Chat_Msg_Id", 0));
            AppMethodBeat.o(6515);
            return valueOf;
        }
    }

    public static final /* synthetic */ String a(ShowAppMsgContentUI showAppMsgContentUI) {
        AppMethodBeat.i(6527);
        JSONObject jSONObject = new JSONObject();
        ca caVar = showAppMsgContentUI.dTX;
        if (caVar == null) {
            p.btv("msgInfo");
        }
        jSONObject.put("msgId", caVar.ajL());
        ca caVar2 = showAppMsgContentUI.dTX;
        if (caVar2 == null) {
            p.btv("msgInfo");
        }
        jSONObject.put("msgSvrId", caVar2.ajM());
        ca caVar3 = showAppMsgContentUI.dTX;
        if (caVar3 == null) {
            p.btv("msgInfo");
        }
        jSONObject.put("talker", caVar3.ajO());
        ca caVar4 = showAppMsgContentUI.dTX;
        if (caVar4 == null) {
            p.btv("msgInfo");
        }
        jSONObject.put("isSend", caVar4.ajN());
        ca caVar5 = showAppMsgContentUI.dTX;
        if (caVar5 == null) {
            p.btv("msgInfo");
        }
        jSONObject.put("status", caVar5.getStatus());
        ca caVar6 = showAppMsgContentUI.dTX;
        if (caVar6 == null) {
            p.btv("msgInfo");
        }
        jSONObject.put("type", caVar6.getType());
        ca caVar7 = showAppMsgContentUI.dTX;
        if (caVar7 == null) {
            p.btv("msgInfo");
        }
        jSONObject.put("createTime", caVar7.getCreateTime());
        ca caVar8 = showAppMsgContentUI.dTX;
        if (caVar8 == null) {
            p.btv("msgInfo");
        }
        if (!Util.isNullOrNil(caVar8.ajR())) {
            ca caVar9 = showAppMsgContentUI.dTX;
            if (caVar9 == null) {
                p.btv("msgInfo");
            }
            jSONObject.put("bizClientMsgId", caVar9.ajR());
        }
        ca caVar10 = showAppMsgContentUI.dTX;
        if (caVar10 == null) {
            p.btv("msgInfo");
        }
        if (!Util.isNullOrNil(caVar10.ajw())) {
            ca caVar11 = showAppMsgContentUI.dTX;
            if (caVar11 == null) {
                p.btv("msgInfo");
            }
            jSONObject.put("msgSource", caVar11.ajw());
        }
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "json.toString()");
        AppMethodBeat.o(6527);
        return jSONObject2;
    }

    public static final /* synthetic */ TextView c(ShowAppMsgContentUI showAppMsgContentUI) {
        AppMethodBeat.i(6529);
        TextView textView = (TextView) showAppMsgContentUI.pqi.getValue();
        AppMethodBeat.o(6529);
        return textView;
    }
}
