package com.tencent.mm.plugin.gamelife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/TestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "FROM_USER_NAME", "", "getFROM_USER_NAME", "()Ljava/lang/String;", "setFROM_USER_NAME", "(Ljava/lang/String;)V", "TO_USER_NAME", "getTO_USER_NAME", "setTO_USER_NAME", "switchBlackList", "", "getSwitchBlackList", "()Z", "setSwitchBlackList", "(Z)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUpTestUsername", "Companion", "plugin-gamelife_release"})
public final class TestUI extends MMActivity {
    private static final String TAG = TAG;
    private static final String ydw = ydw;
    private static final String ydx = ydx;
    private static String ydy = "S1_BgAAdQoEcfnVwzCiSbiVnB7BOg@gamelifesess";
    public static final a ydz = new a((byte) 0);
    private HashMap _$_findViewCache;
    String ydt = ydw;
    String ydu = ydx;
    boolean ydv = true;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(241559);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(241559);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(241558);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(241558);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/TestUI$Companion;", "", "()V", "SESSION_ID", "", "getSESSION_ID", "()Ljava/lang/String;", "setSESSION_ID", "(Ljava/lang/String;)V", "T1_USERNAME", "getT1_USERNAME", "T2_USERNAME", "getT2_USERNAME", "TAG", "getTAG", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241557);
        AppMethodBeat.o(241557);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(241556);
        super.onCreate(bundle);
        kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        String ayV = com.tencent.mm.kernel.a.ayV();
        if (ayV != null) {
            switch (ayV.hashCode()) {
                case -1552608050:
                    if (ayV.equals("3191137690")) {
                        this.ydu = ydx;
                        this.ydt = ydw;
                        break;
                    }
                    break;
                case 226066304:
                    if (ayV.equals("3193176932")) {
                        this.ydu = ydw;
                        this.ydt = ydx;
                        break;
                    }
                    break;
            }
        }
        ((Button) findViewById(R.id.djv)).setOnClickListener(new b(this));
        ((Button) findViewById(R.id.djp)).setOnClickListener(new j(this));
        ((Button) findViewById(R.id.djm)).setOnClickListener(new k(this));
        ((Button) findViewById(R.id.hl7)).setOnClickListener(new l(this));
        ((Button) findViewById(R.id.hl8)).setOnClickListener(new m(this));
        ((Button) findViewById(R.id.djo)).setOnClickListener(n.ydE);
        ((Button) findViewById(R.id.hle)).setOnClickListener(o.ydF);
        ((Button) findViewById(R.id.izo)).setOnClickListener(p.ydG);
        ((Button) findViewById(R.id.bss)).setOnClickListener(q.ydH);
        ((Button) findViewById(R.id.aie)).setOnClickListener(c.ydB);
        findViewById(R.id.dh2);
        ((Button) findViewById(R.id.hko)).setOnClickListener(new d(this));
        ((Button) _$_findCachedViewById(R.id.bfw)).setOnClickListener(new e(this));
        ((Button) _$_findCachedViewById(R.id.b3e)).setOnClickListener(f.ydC);
        ((Button) _$_findCachedViewById(R.id.ci7)).setOnClickListener(new g(this));
        ((Button) _$_findCachedViewById(R.id.i4f)).setOnClickListener(new h(this));
        ((Button) _$_findCachedViewById(R.id.bmd)).setOnClickListener(i.ydD);
        AppMethodBeat.o(241556);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ TestUI ydA;

        b(TestUI testUI) {
            this.ydA = testUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241533);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.gamelife.c.g.ybA;
            String str = this.ydA.ydu;
            String str2 = this.ydA.ydt;
            kotlin.g.b.p.h(str, "fromUserName");
            kotlin.g.b.p.h(str2, "toUserName");
            Log.i(com.tencent.mm.plugin.gamelife.c.g.TAG, "getChatSessionId, fromUsrName = " + str + " , toUserName = " + str2);
            new com.tencent.mm.plugin.gamelife.c.c(str, str2, 0, null).aYI();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241533);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ TestUI ydA;

        j(TestUI testUI) {
            this.ydA = testUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241544);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.gamelife.c.g.ybA;
            LinkedList linkedList = new LinkedList(kotlin.a.j.listOf((Object[]) new String[]{this.ydA.ydu, this.ydA.ydt}));
            kotlin.g.b.p.h(linkedList, "userNameList");
            Log.i(com.tencent.mm.plugin.gamelife.c.g.TAG, "getChatUserInfo, userNameList = ".concat(String.valueOf(linkedList)));
            new com.tencent.mm.plugin.gamelife.c.d(linkedList).aYI();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241544);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ TestUI ydA;

        k(TestUI testUI) {
            this.ydA = testUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241545);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.gamelife.c.g.ybA;
            String str = this.ydA.ydt;
            kotlin.g.b.p.h(str, "userName");
            Log.i(com.tencent.mm.plugin.gamelife.c.g.TAG, "getBlackList, userName = ".concat(String.valueOf(str)));
            new com.tencent.mm.plugin.gamelife.c.a(str).aYI();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241545);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ TestUI ydA;

        l(TestUI testUI) {
            this.ydA = testUI;
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(241546);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.gamelife.c.g.ybA;
            g.a.h(this.ydA.ydt, this.ydA.ydv, false);
            TestUI testUI = this.ydA;
            if (!this.ydA.ydv) {
                z = true;
            } else {
                z = false;
            }
            testUI.ydv = z;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241546);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class m implements View.OnClickListener {
        final /* synthetic */ TestUI ydA;

        m(TestUI testUI) {
            this.ydA = testUI;
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(241547);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.gamelife.c.g.ybA;
            g.a.h(this.ydA.ydt, this.ydA.ydv, true);
            TestUI testUI = this.ydA;
            if (!this.ydA.ydv) {
                z = true;
            } else {
                z = false;
            }
            testUI.ydv = z;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241547);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class n implements View.OnClickListener {
        public static final n ydE = new n();

        static {
            AppMethodBeat.i(241549);
            AppMethodBeat.o(241549);
        }

        n() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241548);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.gamelife.c.g.ybA;
            a aVar2 = TestUI.ydz;
            LinkedList linkedList = new LinkedList(kotlin.a.j.listOf(TestUI.ydy));
            kotlin.g.b.p.h(linkedList, "sessionIdList");
            Log.i(com.tencent.mm.plugin.gamelife.c.g.TAG, "getSessionData, sesseionIdList = ".concat(String.valueOf(linkedList)));
            new com.tencent.mm.plugin.gamelife.c.b(linkedList).aYI();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241548);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class o implements View.OnClickListener {
        public static final o ydF = new o();

        static {
            AppMethodBeat.i(241551);
            AppMethodBeat.o(241551);
        }

        o() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241550);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.gamelife.c.g.ybA;
            a aVar2 = TestUI.ydz;
            g.a.d(TestUI.ydy, 1, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241550);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class p implements View.OnClickListener {
        public static final p ydG = new p();

        static {
            AppMethodBeat.i(241553);
            AppMethodBeat.o(241553);
        }

        p() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241552);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.gamelife.c.g.ybA;
            a aVar2 = TestUI.ydz;
            g.a.d(TestUI.ydy, 1, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241552);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class q implements View.OnClickListener {
        public static final q ydH = new q();

        static {
            AppMethodBeat.i(241555);
            AppMethodBeat.o(241555);
        }

        q() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241554);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.gamelife.c.g.ybA;
            a aVar2 = TestUI.ydz;
            g.a.d(TestUI.ydy, 2, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241554);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        public static final c ydB = new c();

        static {
            AppMethodBeat.i(241535);
            AppMethodBeat.o(241535);
        }

        c() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241534);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.gamelife.c.g.ybA;
            a aVar2 = TestUI.ydz;
            g.a.d(TestUI.ydy, 2, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241534);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ TestUI ydA;

        d(TestUI testUI) {
            this.ydA = testUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241536);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a aVar = TestUI.ydz;
            aa.iNn.azA().b(new com.tencent.mm.plugin.byp.b.d(TestUI.ydy, this.ydA.ydu, this.ydA.ydt, "this is the first gamelife text"));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241536);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ TestUI ydA;

        e(TestUI testUI) {
            this.ydA = testUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241537);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TestUI testUI = this.ydA;
            Intent intent = new Intent(this.ydA, GameLifeConversationUI.class);
            intent.putExtra("TEST", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(testUI, bl.axQ(), "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            testUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(testUI, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241537);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        public static final f ydC = new f();

        static {
            AppMethodBeat.i(241539);
            AppMethodBeat.o(241539);
        }

        f() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241538);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).clearDB();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241538);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ TestUI ydA;

        g(TestUI testUI) {
            this.ydA = testUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241540);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.gamelife.e.e conversationStorage = ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getConversationStorage();
            for (int i2 = 0; i2 <= 50; i2++) {
                com.tencent.mm.plugin.gamelife.e.a aVar = new com.tencent.mm.plugin.gamelife.e.a();
                aVar.field_sessionId = APMidasPayAPI.ENV_TEST.concat(String.valueOf(i2));
                aVar.field_digest = "digest".concat(String.valueOf(i2));
                aVar.field_updateTime = System.currentTimeMillis();
                aVar.field_talker = "talker".concat(String.valueOf(i2));
                aVar.field_selfUserName = this.ydA.ydu;
                conversationStorage.insert(aVar);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241540);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ TestUI ydA;

        h(TestUI testUI) {
            this.ydA = testUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241541);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).enterChattingUI(this.ydA, this.ydA.ydu, this.ydA.ydt, 0, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241541);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        public static final i ydD = new i();

        static {
            AppMethodBeat.i(241543);
            AppMethodBeat.o(241543);
        }

        i() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241542);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ((com.tencent.mm.plugin.gamelife.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.c.class)).aAT(((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getConversationStorage().dP(0, 1).get(0).field_sessionId);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241542);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.at_;
    }
}
