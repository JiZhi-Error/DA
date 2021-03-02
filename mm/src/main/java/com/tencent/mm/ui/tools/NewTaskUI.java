package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

public class NewTaskUI extends MMBaseActivity implements i {
    static NewTaskUI QvG;
    private i QvH = new i();
    private ProgressDialog gtM = null;
    private SecurityImage kdp = null;
    private IListener kkK = new IListener<lz>() {
        /* class com.tencent.mm.ui.tools.NewTaskUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161581);
            this.__eventId = lz.class.getName().hashCode();
            AppMethodBeat.o(161581);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lz lzVar) {
            AppMethodBeat.i(39109);
            lz lzVar2 = lzVar;
            if (lzVar2 == null || lzVar2.dRz == null) {
                AppMethodBeat.o(39109);
                return false;
            }
            Log.i("MicroMsg.NewTaskUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", lzVar2.dRz.content, lzVar2.dRz.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", lzVar2.dRz.content);
            intent.putExtra("key_disaster_url", lzVar2.dRz.url);
            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/tools/NewTaskUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/tools/NewTaskUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(39109);
            return true;
        }
    };

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NewTaskUI() {
        AppMethodBeat.i(39115);
        AppMethodBeat.o(39115);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39116);
        super.onCreate(bundle);
        Log.i("MicroMsg.NewTaskUI", "onCreate :%d", Integer.valueOf(hashCode()));
        setContentView(R.layout.hl);
        bg.azz().a(701, this);
        bg.azz().a(252, this);
        QvG = this;
        final t tVar = new t(0, "", "", "");
        bg.azz().a(tVar, 0);
        getString(R.string.zb);
        this.gtM = h.a((Context) this, getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.tools.NewTaskUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(39110);
                bg.azz().a(tVar);
                AppMethodBeat.o(39110);
            }
        });
        AppMethodBeat.o(39116);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(39117);
        EventCenter.instance.addListener(this.kkK);
        super.onResume();
        AppMethodBeat.o(39117);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(39118);
        super.onPause();
        EventCenter.instance.removeListener(this.kkK);
        AppMethodBeat.o(39118);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(39119);
        Log.i("MicroMsg.NewTaskUI", "onDestroy :%d", Integer.valueOf(hashCode()));
        if (equals(QvG)) {
            QvG = null;
        }
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        if (this.kdp != null) {
            this.kdp.dismiss();
        }
        bg.azz().b(701, this);
        bg.azz().b(252, this);
        super.onDestroy();
        AppMethodBeat.o(39119);
    }

    public static NewTaskUI gXN() {
        return QvG;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(39120);
        Log.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        if (i2 == 4 && i3 == -3) {
            Log.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", Boolean.valueOf(bg.aAc()));
            if (com.tencent.mm.plugin.account.ui.a.a(QvG, i2, i3, new Intent().setClass(QvG, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                AppMethodBeat.o(39120);
                return;
            }
        }
        if (i2 == 4 && (i3 == -6 || i3 == -311 || i3 == -310)) {
            if (qVar instanceof t) {
                t tVar = (t) qVar;
                this.QvH.kmJ = tVar.getSecCodeType();
                this.QvH.kdr = tVar.bfm();
                this.QvH.kds = tVar.bfl();
                this.QvH.kdt = tVar.bfn();
                Log.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.QvH.kds + " img len" + this.QvH.kdr.length + " " + f.apq());
            }
            if (this.kdp == null) {
                this.kdp = SecurityImage.a.a(this, this.QvH.kmJ, this.QvH.kdr, this.QvH.kds, this.QvH.kdt, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.tools.NewTaskUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(39112);
                        Log.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.this.QvH.kds + " img len" + NewTaskUI.this.QvH.kdr.length + " " + f.apq());
                        if (NewTaskUI.this.kdp == null) {
                            Log.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
                            AppMethodBeat.o(39112);
                            return;
                        }
                        final t tVar = new t(NewTaskUI.this.QvH.kmJ, NewTaskUI.this.kdp.getSecImgCode(), NewTaskUI.this.kdp.getSecImgSid(), NewTaskUI.this.kdp.getSecImgEncryptKey());
                        bg.azz().a(tVar, 0);
                        NewTaskUI newTaskUI = NewTaskUI.this;
                        NewTaskUI newTaskUI2 = NewTaskUI.this;
                        NewTaskUI.this.getString(R.string.zb);
                        newTaskUI.gtM = h.a((Context) newTaskUI2, NewTaskUI.this.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.ui.tools.NewTaskUI.AnonymousClass3.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(39111);
                                bg.azz().a(tVar);
                                AppMethodBeat.o(39111);
                            }
                        });
                        AppMethodBeat.o(39112);
                    }
                }, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.ui.tools.NewTaskUI.AnonymousClass4 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(39113);
                        if (NewTaskUI.QvG != null) {
                            NewTaskUI.QvG = null;
                            NewTaskUI.this.finish();
                        }
                        AppMethodBeat.o(39113);
                    }
                }, new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.ui.tools.NewTaskUI.AnonymousClass5 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(39114);
                        NewTaskUI.this.kdp = null;
                        AppMethodBeat.o(39114);
                    }
                }, this.QvH);
                AppMethodBeat.o(39120);
                return;
            }
            Log.d("MicroMsg.NewTaskUI", "imgSid:" + this.QvH.kds + " img len" + this.QvH.kdr.length + " " + f.apq());
            this.kdp.b(this.QvH.kmJ, this.QvH.kdr, this.QvH.kds, this.QvH.kdt);
            AppMethodBeat.o(39120);
            return;
        }
        QvG = null;
        finish();
        AppMethodBeat.o(39120);
    }
}
