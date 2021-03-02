package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.ui.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class au implements ad {
    private int DPi = 1;
    private int EpG;
    private k EpM = null;
    private String EpN = "";
    private boolean EsQ = false;
    private Bitmap EsR = null;
    bf Eth = null;
    a EwB;
    c EwC = null;
    private boolean dGX = false;
    private String desc = "";
    ProgressDialog gtM = null;
    MMActivity gte;
    String md5 = "";
    ProgressBar progressBar;
    private View sc = null;
    private IListener tOh = new IListener<uw>() {
        /* class com.tencent.mm.plugin.sns.ui.au.AnonymousClass1 */

        {
            AppMethodBeat.i(160703);
            this.__eventId = uw.class.getName().hashCode();
            AppMethodBeat.o(160703);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uw uwVar) {
            AppMethodBeat.i(98286);
            uw uwVar2 = uwVar;
            Log.i("MicroMsg.SightWidget", "on sight send result callback, type %d", Integer.valueOf(uwVar2.ebg.type));
            switch (uwVar2.ebg.type) {
                case 1:
                    Log.i("MicroMsg.SightWidget", "come event done");
                    au.this.videoPath = uwVar2.ebg.videoPath;
                    au.this.md5 = uwVar2.ebg.ebj;
                    if (au.this.gtM != null) {
                        au.this.gtM.dismiss();
                    }
                    au.this.EwB.e(au.this.videoPath, false, 0);
                    au.this.progressBar.setVisibility(8);
                    if (uwVar2.ebg.ebi && au.this.Eth != null) {
                        au.this.fgO();
                    }
                    Log.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", Boolean.valueOf(uwVar2.ebg.ebi), uwVar2.ebg.videoPath, Long.valueOf(s.boW(uwVar2.ebg.videoPath)), au.this.md5);
                    break;
            }
            AppMethodBeat.o(98286);
            return false;
        }
    };
    String thumbPath = "";
    String videoPath = "";

    public au(MMActivity mMActivity) {
        AppMethodBeat.i(98288);
        this.gte = mMActivity;
        AppMethodBeat.o(98288);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        AppMethodBeat.i(98289);
        this.EpM = k.w(this.gte.getIntent());
        this.thumbPath = this.gte.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.gte.getIntent().getStringExtra("KSightPath");
        this.md5 = this.gte.getIntent().getStringExtra("sight_md5");
        this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
        uw uwVar = new uw();
        uwVar.ebg.type = 2;
        EventCenter.instance.publish(uwVar);
        if (Util.isNullOrNil(this.videoPath)) {
            this.videoPath = Util.nullAs(uwVar.ebh.ebl, "");
            Log.e("MicroMsg.SightWidget", "videoPath is null %s", this.videoPath);
        }
        this.md5 = Util.isNullOrNil(this.md5) ? Util.nullAs(uwVar.ebh.ebj, "") : this.md5;
        Log.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", this.thumbPath, this.videoPath, this.md5);
        EventCenter.instance.addListener(this.tOh);
        if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.DPi = 1;
        } else {
            this.DPi = 0;
        }
        this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        AppMethodBeat.o(98289);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aD(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffA() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final View ffB() {
        AppMethodBeat.i(98290);
        this.sc = View.inflate(this.gte, R.layout.c50, null);
        this.EwB = (a) this.sc.findViewById(R.id.dup);
        this.EwB.setDrawableWidth(com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 90));
        this.progressBar = (ProgressBar) this.sc.findViewById(R.id.ep4);
        this.gte.getResources().getDisplayMetrics();
        this.sc.findViewById(R.id.auf).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.au.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(98287);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!s.YS(au.this.videoPath)) {
                    Log.i("MicroMsg.SightWidget", "click videopath is not exist " + au.this.videoPath);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(98287);
                    return;
                }
                if (au.this.EwC != null) {
                    au.this.EwC.dismiss();
                    au.this.EwC = null;
                }
                au.this.EwC = new c(au.this.gte);
                c cVar = au.this.EwC;
                String str = au.this.videoPath;
                String str2 = au.this.thumbPath;
                cVar.fullPath = str;
                cVar.imagePath = str2;
                c cVar2 = au.this.EwC;
                cVar2.eeF = 0;
                cVar2.Dne = 0;
                cVar2.tex = 1;
                au.this.EwC.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98287);
            }
        });
        Log.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + s.boW(this.videoPath) + " " + s.boW(this.thumbPath));
        if (s.YS(this.videoPath)) {
            this.EwB.e(this.videoPath, false, 0);
            this.progressBar.setVisibility(8);
            Log.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", this.videoPath, this.md5);
        } else {
            n aOq = r.aOq(this.thumbPath);
            if (aOq != null) {
                this.EsR = aOq.aSa();
                if (r.M(this.EsR)) {
                    this.EwB.setThumbBmp(this.EsR);
                }
            }
            this.progressBar.setVisibility(0);
        }
        View view = this.sc;
        AppMethodBeat.o(98290);
        return view;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffC() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffD() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean a(int i2, int i3, i iVar, String str, List<String> list, cjy cjy, LinkedList<Long> linkedList, int i4, boolean z, List<String> list2, PInt pInt, String str2, int i5, int i6) {
        AppMethodBeat.i(98291);
        if (this.Eth != null) {
            AppMethodBeat.o(98291);
            return false;
        }
        this.desc = str;
        LinkedList<ebm> linkedList2 = new LinkedList<>();
        if (list != null) {
            new LinkedList();
            List<String> gnq = com.tencent.mm.pluginsdk.i.a.gnq();
            for (String str3 : list) {
                if (!gnq.contains(str3)) {
                    ebm ebm = new ebm();
                    ebm.UserName = str3;
                    linkedList2.add(ebm);
                }
            }
        }
        this.Eth = new bf(15, this.gte);
        pInt.value = this.Eth.beK;
        if (i4 > com.tencent.mm.plugin.sns.c.a.DCT) {
            this.Eth.YF(3);
        }
        bf aPw = this.Eth.aPw(str);
        new LinkedList();
        aPw.a(cjy).bq(linkedList2).YI(i2).YJ(i3).gR(list2);
        if (z) {
            this.Eth.YL(1);
        } else {
            this.Eth.YL(0);
        }
        this.Eth.gR(list2).YI(i2);
        this.Eth.YK(this.EpG);
        this.Eth.ct(this.DPi, this.EpN);
        this.Eth.g(null, null, null, i5, i6);
        if (s.YS(this.videoPath)) {
            fgO();
            AppMethodBeat.o(98291);
            return true;
        }
        Log.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
        MMActivity mMActivity = this.gte;
        this.gte.getString(R.string.zb);
        this.gtM = h.a((Context) mMActivity, this.gte.getString(R.string.h_t), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.sns.ui.au.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                au.this.Eth = null;
            }
        });
        AppMethodBeat.o(98291);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void fgO() {
        AppMethodBeat.i(98292);
        if (this.EsQ) {
            AppMethodBeat.o(98292);
        } else if (!this.Eth.D(this.videoPath, this.thumbPath, this.desc, this.md5)) {
            Log.i("MicroMsg.SightWidget", "videopath " + s.boW(this.videoPath) + " thumb: " + s.boW(this.thumbPath));
            u.makeText(this.gte, (int) R.string.gkm, 0).show();
            AppMethodBeat.o(98292);
        } else {
            uw uwVar = new uw();
            uwVar.ebg.type = 0;
            uwVar.ebg.ebi = true;
            EventCenter.instance.publish(uwVar);
            this.EsQ = true;
            int commit = this.Eth.commit();
            if (this.EpM != null) {
                this.EpM.tQ(commit);
                g.DVR.c(this.EpM);
            }
            aj.faY().EvE = 0;
            Intent intent = new Intent();
            intent.putExtra("sns_resume_state", false);
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            intent.setClass(this.gte, SnsTimeLineUI.class);
            intent.addFlags(67108864);
            MMActivity mMActivity = this.gte;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mMActivity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/sns/ui/SightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.gte.setResult(-1);
            this.gte.finish();
            AppMethodBeat.o(98292);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean k(int i2, Intent intent) {
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffE() {
        AppMethodBeat.i(98293);
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        EventCenter.instance.removeListener(this.tOh);
        if (r.M(this.EsR)) {
            this.EsR.recycle();
        }
        AppMethodBeat.o(98293);
        return false;
    }
}
