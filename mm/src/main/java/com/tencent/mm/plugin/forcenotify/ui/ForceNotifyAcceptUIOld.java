package com.tencent.mm.plugin.forcenotify.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.protocal.protobuf.dqr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"})
public final class ForceNotifyAcceptUIOld extends MMActivity {
    final String TAG = "MicroMsg.ForceNotifyAcceptUI";
    private final MMHandler UWg = new MMHandler(this.TAG);
    private q nUq;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ForceNotifyAcceptUIOld() {
        AppMethodBeat.i(261783);
        AppMethodBeat.o(261783);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.am_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(261780);
        getWindow().addFlags(6815872);
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        setBackBtn(new a(this));
        getString(R.string.zb);
        this.nUq = h.a((Context) this, getString(R.string.a06), false, (DialogInterface.OnCancelListener) b.UWi);
        q qVar = this.nUq;
        if (qVar != null) {
            qVar.show();
        }
        Intent intent = getIntent();
        p.g(intent, "intent");
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString("data") : null;
        Log.d(this.TAG, "data:%s", string);
        if (string == null) {
            finish();
            Log.d(this.TAG, "data is null");
            AppMethodBeat.o(261780);
            return;
        }
        this.UWg.post(new c(this, string));
        ((Button) findViewById(R.id.b7)).setOnClickListener(new d(this, string));
        ((Button) findViewById(R.id.ai8)).setOnClickListener(new e(this));
        AppMethodBeat.o(261780);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ForceNotifyAcceptUIOld UWh;

        a(ForceNotifyAcceptUIOld forceNotifyAcceptUIOld) {
            this.UWh = forceNotifyAcceptUIOld;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(261772);
            this.UWh.onBackPressed();
            AppMethodBeat.o(261772);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class b implements DialogInterface.OnCancelListener {
        public static final b UWi = new b();

        static {
            AppMethodBeat.i(261773);
            AppMethodBeat.o(261773);
        }

        b() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ ForceNotifyAcceptUIOld UWh;
        final /* synthetic */ String pmq;

        c(ForceNotifyAcceptUIOld forceNotifyAcceptUIOld, String str) {
            this.UWh = forceNotifyAcceptUIOld;
            this.pmq = str;
        }

        public final void run() {
            AppMethodBeat.i(261775);
            new com.tencent.mm.plugin.forcenotify.c.b(this.pmq).aYI().b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUIOld.c.AnonymousClass1 */
                final /* synthetic */ c UWj;

                {
                    this.UWj = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    int i2;
                    AppMethodBeat.i(261774);
                    c.a aVar = (c.a) obj;
                    if (aVar.errType == 0 && aVar.errCode == 0) {
                        Log.i(this.UWj.UWh.TAG, "get accept info successfully");
                        bex bex = ((dqr) aVar.iLC).MTA;
                        com.tencent.mm.plugin.forcenotify.c.d dVar = new com.tencent.mm.plugin.forcenotify.c.d();
                        dVar.field_UserName = bex.UserName;
                        dVar.field_ExpiredTime = ((long) bex.KCC) * 1000;
                        dVar.field_CreateTime = ((long) bex.CreateTime) * 1000;
                        if (cl.aWz() >= dVar.field_ExpiredTime) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        dVar.field_Status = i2;
                        dVar.field_ExtInfo = bex.xNU;
                        dVar.field_Description = bex.KHk;
                        dVar.field_UserIcon = bex.LOD;
                        dVar.field_ForcePushId = bex.KHi;
                        Log.i(this.UWj.UWh.TAG, " item:%s", dVar);
                        View findViewById = this.UWj.UWh.findViewById(R.id.bmr);
                        p.g(findViewById, "findViewById<TextView>(R.id.desc)");
                        ((TextView) findViewById).setText(Util.nullAsNil(dVar.field_Description));
                    } else {
                        Toast.makeText(this.UWj.UWh, aVar.errMsg, 0).show();
                        this.UWj.UWh.finish();
                    }
                    q qVar = this.UWj.UWh.nUq;
                    if (qVar != null) {
                        qVar.dismiss();
                        x xVar = x.SXb;
                        AppMethodBeat.o(261774);
                        return xVar;
                    }
                    AppMethodBeat.o(261774);
                    return null;
                }
            });
            AppMethodBeat.o(261775);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ ForceNotifyAcceptUIOld UWh;
        final /* synthetic */ String pmq;

        d(ForceNotifyAcceptUIOld forceNotifyAcceptUIOld, String str) {
            this.UWh = forceNotifyAcceptUIOld;
            this.pmq = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261778);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ForceNotifyAcceptUIOld forceNotifyAcceptUIOld = this.UWh;
            this.UWh.getString(R.string.zb);
            forceNotifyAcceptUIOld.nUq = h.a((Context) this.UWh, this.UWh.getString(R.string.a06), false, (DialogInterface.OnCancelListener) AnonymousClass1.UWk);
            q qVar = this.UWh.nUq;
            if (qVar != null) {
                qVar.show();
            }
            new com.tencent.mm.plugin.forcenotify.c.a(this.pmq).aYI().b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUIOld.d.AnonymousClass2 */
                final /* synthetic */ d UWl;

                {
                    this.UWl = r1;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
                    if ((r0.length() == 0) != false) goto L_0x0079;
                 */
                @Override // com.tencent.mm.vending.c.a
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final /* synthetic */ java.lang.Object call(java.lang.Object r6) {
                    /*
                    // Method dump skipped, instructions count: 171
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUIOld.d.AnonymousClass2.call(java.lang.Object):java.lang.Object");
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261778);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ ForceNotifyAcceptUIOld UWh;

        e(ForceNotifyAcceptUIOld forceNotifyAcceptUIOld) {
            this.UWh = forceNotifyAcceptUIOld;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261779);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i(this.UWh.TAG, "Cancel!");
            this.UWh.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261779);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(261781);
        super.onBackPressed();
        finish();
        AppMethodBeat.o(261781);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(261782);
        super.onDestroy();
        q qVar = this.nUq;
        if (qVar != null) {
            qVar.dismiss();
            AppMethodBeat.o(261782);
            return;
        }
        AppMethodBeat.o(261782);
    }
}
