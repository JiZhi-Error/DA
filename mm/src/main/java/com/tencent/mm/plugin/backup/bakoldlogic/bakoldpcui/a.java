package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMWizardActivity;

public final class a extends b implements e.d {
    private static String TAG = "MicroMsg.BakChatBanner";
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private int oRS = -1;
    private IListener oSw;
    private int percent = 0;
    private View sc = null;

    public a(Context context) {
        super(context);
        AppMethodBeat.i(21960);
        if (this.view != null) {
            this.sc = this.view.findViewById(R.id.zj);
            this.sc.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(21957);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    a.this.oRS = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS;
                    if (2 == a.this.oRS || 3 == a.this.oRS || 5 == a.this.oRS || 6 == a.this.oRS) {
                        Log.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS), Integer.valueOf(a.this.percent));
                        a.d(a.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(21957);
                    } else if (4 == a.this.oRS) {
                        Log.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS), Integer.valueOf(a.this.percent));
                        a.e(a.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(21957);
                    } else {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(21957);
                    }
                }
            });
        }
        bYa();
        this.oSw = new IListener<pe>() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a.AnonymousClass1 */

            {
                AppMethodBeat.i(161288);
                this.__eventId = pe.class.getName().hashCode();
                AppMethodBeat.o(161288);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(pe peVar) {
                AppMethodBeat.i(21956);
                a.this.getView().post(new Runnable() {
                    /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(21955);
                        if (a.a(a.this)) {
                            EventCenter.instance.publish(new mg());
                        }
                        AppMethodBeat.o(21955);
                    }
                });
                AppMethodBeat.o(21956);
                return false;
            }
        };
        EventCenter.instance.addListener(this.oSw);
        AppMethodBeat.o(21960);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.i2;
    }

    private boolean jI(boolean z) {
        AppMethodBeat.i(21961);
        this.oRS = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS;
        Log.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setStrategyCaller:%b", Integer.valueOf(this.oRS), Boolean.valueOf(z));
        if (this.oRS < 2 || this.oRS > 6) {
            this.sc.setVisibility(8);
            AppMethodBeat.o(21961);
            return false;
        }
        this.sc.setVisibility(0);
        if (z && !com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().chh()) {
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().a(this);
        }
        if (2 == this.oRS) {
            ((ImageView) this.view.findViewById(R.id.zk)).setImageResource(R.raw.chatting_backup_computer);
            ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a9t, Integer.valueOf(this.percent)));
        } else if (3 == this.oRS) {
            ((ImageView) this.view.findViewById(R.id.zk)).setImageResource(R.raw.chatting_backup_computer);
            ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a9w, Integer.valueOf(this.percent)));
        } else if (4 == this.oRS) {
            ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a9v));
            ((ImageView) this.view.findViewById(R.id.zk)).setImageResource(R.raw.chatting_backup_comfirm);
        } else if (5 == this.oRS) {
            ((ImageView) this.view.findViewById(R.id.zk)).setImageResource(R.raw.chatting_backup_computer);
            ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a9r, Integer.valueOf(this.percent)));
        } else if (6 == this.oRS) {
            ((TextView) this.view.findViewById(R.id.zl)).setText(MMApplicationContext.getContext().getString(R.string.a9u));
            ((ImageView) this.view.findViewById(R.id.zk)).setImageResource(R.raw.chatting_backup_comfirm);
        }
        AppMethodBeat.o(21961);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        AppMethodBeat.i(21962);
        this.percent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().chk();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().a(this);
        boolean jI = jI(true);
        AppMethodBeat.o(21962);
        return jI;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void release() {
        AppMethodBeat.i(21963);
        this.oRS = -1;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().chi();
        AppMethodBeat.o(21963);
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.b
    public final void onError(int i2) {
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d
    public final void By(int i2) {
        AppMethodBeat.i(21964);
        Log.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS), Integer.valueOf(i2));
        this.percent = i2;
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(21958);
                a.this.bYa();
                AppMethodBeat.o(21958);
            }
        });
        AppMethodBeat.o(21964);
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d
    public final void Bz(int i2) {
        AppMethodBeat.i(21965);
        Log.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS), Integer.valueOf(i2));
        AppMethodBeat.o(21965);
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d
    public final void chn() {
        AppMethodBeat.i(21966);
        Log.d(TAG, "onNetFinish PCBannerStatus:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS));
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha();
        e.Bv(17);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(21959);
                a.this.bYa();
                AppMethodBeat.o(21959);
            }
        });
        AppMethodBeat.o(21966);
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d
    public final void ceL() {
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d
    public final void cho() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
        AppMethodBeat.i(21967);
        Log.i(TAG, "destroy");
        release();
        EventCenter.instance.removeListener(this.oSw);
        AppMethodBeat.o(21967);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getOrder() {
        return 3;
    }

    static /* synthetic */ boolean a(a aVar) {
        AppMethodBeat.i(21968);
        aVar.percent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().chk();
        Log.d(TAG, "refreshForBakpc PCBannerStatus:%d, percent:%d", Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS), Integer.valueOf(aVar.percent));
        boolean jI = aVar.jI(false);
        AppMethodBeat.o(21968);
        return jI;
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(21969);
        Intent intent = new Intent((Context) aVar.Kgr.get(), BakOperatingUI.class);
        intent.putExtra("from_bak_banner", true);
        MMWizardActivity.ay((Context) aVar.Kgr.get(), intent);
        AppMethodBeat.o(21969);
    }

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(21970);
        Intent intent = new Intent((Context) aVar.Kgr.get(), BakFinishUI.class);
        intent.putExtra("cmd", 1);
        MMWizardActivity.ay((Context) aVar.Kgr.get(), intent);
        AppMethodBeat.o(21970);
    }
}
