package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.UnsupportedEncodingException;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVoiceFragment extends VoipBaseFragment {
    private int GUk = 1;
    private boolean HdH = false;
    private View.OnClickListener HdZ = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass6 */

        public final void onClick(View view) {
            AppMethodBeat.i(115466);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h.INSTANCE.a(11618, 3, 1);
            if (!(VoipVoiceFragment.this.Hen == null || VoipVoiceFragment.this.Hen.get() == null)) {
                ((c) VoipVoiceFragment.this.Hen.get()).wX(true);
            }
            if (VoipVoiceFragment.this.HeG != null) {
                VoipVoiceFragment.this.HeG.aI(false, true);
            }
            a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115466);
        }
    };
    private Button Hdb;
    private WeImageView Hdc;
    private TextView Hdr;
    private View.OnClickListener Hea = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass7 */

        public final void onClick(View view) {
            AppMethodBeat.i(115467);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h.INSTANCE.a(11619, 3);
            if (!(VoipVoiceFragment.this.Hen == null || VoipVoiceFragment.this.Hen.get() == null)) {
                ((c) VoipVoiceFragment.this.Hen.get()).fFY();
            }
            a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115467);
        }
    };
    private View HfE;
    private ImageView HfF;
    private TextView HfG;
    private TextView HfH;
    private TextView HfI;
    private TextView HfJ;
    private TextView HfK;
    private View HfL;
    private RelativeLayout HfM;
    private MMCheckBox HfN;
    private TextView HfO;
    private RelativeLayout HfP;
    private MMCheckBox HfQ;
    private TextView HfR;
    private TextView HfS;
    private TextView HfT;
    private VoipBigIconButton HfU;
    private VoipBigIconButton HfV;
    private VoipBigIconButton HfW;
    private VoipBigIconButton HfX;
    private VoipSmallIconButton HfY;
    private ImageView HfZ;
    private boolean Hga = false;
    private boolean Hgb = false;
    private View.OnClickListener Hgc = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass8 */

        public final void onClick(View view) {
            AppMethodBeat.i(115468);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            boolean isChecked = VoipVoiceFragment.this.HfN.isChecked();
            Log.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", Boolean.valueOf(isChecked));
            VoipVoiceFragment.this.HfN.setEnabled(false);
            if (!(VoipVoiceFragment.this.Hen == null || VoipVoiceFragment.this.Hen.get() == null)) {
                ((c) VoipVoiceFragment.this.Hen.get()).wU(isChecked);
            }
            VoipVoiceFragment.this.GUk = isChecked ? 1 : 2;
            VoipVoiceFragment.this.HfN.setEnabled(true);
            a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115468);
        }
    };
    private View.OnClickListener Hgd = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass9 */

        public final void onClick(View view) {
            AppMethodBeat.i(115469);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            boolean isChecked = VoipVoiceFragment.this.HfQ.isChecked();
            Log.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", Boolean.valueOf(isChecked));
            VoipVoiceFragment.this.HfQ.setEnabled(false);
            if (!(VoipVoiceFragment.this.Hen == null || VoipVoiceFragment.this.Hen.get() == null)) {
                ((c) VoipVoiceFragment.this.Hen.get()).rv(isChecked);
            }
            VoipVoiceFragment.this.mIsMute = isChecked;
            VoipVoiceFragment.this.HfQ.setEnabled(true);
            a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115469);
        }
    };
    private View.OnClickListener Hge = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass10 */

        public final void onClick(View view) {
            AppMethodBeat.i(115470);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
            h.INSTANCE.a(11526, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 2);
            if (!(VoipVoiceFragment.this.Hen == null || VoipVoiceFragment.this.Hen.get() == null || !((c) VoipVoiceFragment.this.Hen.get()).fFz())) {
                VoipVoiceFragment.this.HfU.setEnabled(false);
                VoipVoiceFragment.this.HfJ.setText(R.string.i57);
                VoipVoiceFragment.this.HeH.a(VoipVoiceFragment.this.HfK, VoipBaseFragment.HeB);
                VoipVoiceFragment.this.HfL.setVisibility(0);
                VoipVoiceFragment.this.HfI.setVisibility(8);
                VoipVoiceFragment.this.HfU.setVisibility(8);
                VoipVoiceFragment.this.HfV.setVisibility(8);
                VoipVoiceFragment.this.HfW.setVisibility(0);
            }
            a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115470);
        }
    };
    private View.OnClickListener Hgf = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass11 */

        public final void onClick(View view) {
            AppMethodBeat.i(115471);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
            h.INSTANCE.a(11526, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 5);
            if (!(VoipVoiceFragment.this.Hen == null || VoipVoiceFragment.this.Hen.get() == null || !((c) VoipVoiceFragment.this.Hen.get()).fFy())) {
                VoipVoiceFragment.this.HfV.setEnabled(false);
                VoipVoiceFragment.this.HfU.setEnabled(false);
                VoipVoiceFragment.this.jE(R.string.i44, -1);
                if (VoipVoiceFragment.this.HeG != null) {
                    VoipVoiceFragment.this.HeG.aI(true, false);
                }
            }
            a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115471);
        }
    };
    private View.OnClickListener Hgg = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass12 */

        public final void onClick(View view) {
            AppMethodBeat.i(115472);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
            if (!(VoipVoiceFragment.this.Hen == null || VoipVoiceFragment.this.Hen.get() == null || !((c) VoipVoiceFragment.this.Hen.get()).fFt())) {
                VoipVoiceFragment.this.jE(R.string.i2q, -1);
            }
            a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115472);
        }
    };
    private View.OnClickListener Hgh = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass13 */

        public final void onClick(View view) {
            AppMethodBeat.i(235816);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
            if (!(VoipVoiceFragment.this.Hen == null || VoipVoiceFragment.this.Hen.get() == null || !((c) VoipVoiceFragment.this.Hen.get()).fFB())) {
                VoipVoiceFragment.this.jE(R.string.i1i, -1);
                VoipVoiceFragment.this.HfX.setEnabled(false);
            }
            a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235816);
        }
    };
    private Runnable Hgi = new Runnable() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass4 */

        public final void run() {
            AppMethodBeat.i(235813);
            if (VoipVoiceFragment.this.getActivity() == null || VoipVoiceFragment.this.getActivity().isFinishing()) {
                AppMethodBeat.o(235813);
                return;
            }
            if (VoipVoiceFragment.this.ncd.findViewById(R.id.fuv) != null) {
                VoipVoiceFragment.this.ncd.findViewById(R.id.fuv).setOnClickListener(null);
            }
            VoipVoiceFragment.this.Hgb = false;
            VoipVoiceFragment.this.yzB.setVisibility(8);
            VoipVoiceFragment.this.HfZ.setVisibility(8);
            AppMethodBeat.o(235813);
        }
    };
    private boolean mIsMute = false;
    private Timer mTimer;
    private boolean qvo = false;
    private Runnable rtb = new Runnable() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(235812);
            if (VoipVoiceFragment.this.getActivity() == null || VoipVoiceFragment.this.getActivity().isFinishing()) {
                AppMethodBeat.o(235812);
                return;
            }
            VoipVoiceFragment.this.HfS.setVisibility(8);
            AppMethodBeat.o(235812);
        }
    };
    private TextView yzB;

    public VoipVoiceFragment() {
        AppMethodBeat.i(115474);
        AppMethodBeat.o(115474);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        AppMethodBeat.i(115475);
        this.qvo = false;
        super.onDestroy();
        AppMethodBeat.o(115475);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(115476);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) layoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Log.i("MicroMsg.VoipVoiceFragment", "dpi: " + (((float) displayMetrics.heightPixels) / displayMetrics.density));
        if (((float) displayMetrics.heightPixels) / displayMetrics.density <= 540.0f) {
            this.ncd = (RelativeLayout) layoutInflater.inflate(R.layout.c77, viewGroup, false);
        } else {
            this.ncd = (RelativeLayout) layoutInflater.inflate(R.layout.c76, viewGroup, false);
            if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                ((RelativeLayout) this.ncd.findViewById(R.id.h7z)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(getActivity(), 40.0f));
            }
        }
        this.HeC = (ImageView) this.ncd.findViewById(R.id.jao);
        this.HfE = this.ncd.findViewById(R.id.jc2);
        this.HfF = (ImageView) this.ncd.findViewById(R.id.jcf);
        a.b.a(this.HfF, this.goe, 0.0375f, true);
        this.HfG = (TextView) this.ncd.findViewById(R.id.jcg);
        this.HfG.setText(l.b(getActivity(), aa.getDisplayName(this.goe), this.HfG.getTextSize()));
        this.HfH = (TextView) this.ncd.findViewById(R.id.jci);
        this.HfI = (TextView) this.ncd.findViewById(R.id.jcn);
        this.HfJ = (TextView) this.ncd.findViewById(R.id.jc6);
        this.HfK = (TextView) this.ncd.findViewById(R.id.jc8);
        this.HfL = this.ncd.findViewById(R.id.jc7);
        this.HfS = (TextView) this.ncd.findViewById(R.id.jc3);
        this.HfT = (TextView) this.ncd.findViewById(R.id.jcj);
        this.yzB = (TextView) this.ncd.findViewById(R.id.jbc);
        this.HfZ = (ImageView) this.ncd.findViewById(R.id.eca);
        this.HfZ.setImageDrawable(ar.m(MMApplicationContext.getContext(), R.raw.icons_filled_arrow, -1));
        z(this.HfK);
        if (ac.jPp) {
            this.Hdr = (TextView) this.ncd.findViewById(R.id.c3w);
        }
        this.HfP = (RelativeLayout) this.ncd.findViewById(R.id.jc_);
        this.HfQ = (MMCheckBox) this.ncd.findViewById(R.id.jc9);
        this.HfQ.setChecked(this.mIsMute);
        this.HfR = (TextView) this.ncd.findViewById(R.id.jca);
        this.HfR.setText(R.string.i3f);
        this.HfM = (RelativeLayout) this.ncd.findViewById(R.id.jcl);
        this.HfN = (MMCheckBox) this.ncd.findViewById(R.id.jck);
        this.HfO = (TextView) this.ncd.findViewById(R.id.jcm);
        this.HfO.setText(R.string.i4d);
        fJJ();
        this.HfU = (VoipBigIconButton) this.ncd.findViewById(R.id.jc1);
        this.HfU.setOnClickListener(this.Hge);
        this.HfV = (VoipBigIconButton) this.ncd.findViewById(R.id.jce);
        this.HfV.setOnClickListener(this.Hgf);
        this.HfW = (VoipBigIconButton) this.ncd.findViewById(R.id.jc5);
        this.HfW.setOnClickListener(this.Hgg);
        this.HfX = (VoipBigIconButton) this.ncd.findViewById(R.id.jc4);
        this.HfX.setOnClickListener(this.Hgh);
        this.HdH = m.Se("VOIPBlockIgnoreButton") == 0;
        this.HfY = (VoipSmallIconButton) this.ncd.findViewById(R.id.jb8);
        this.HfY.setOnClickListener(this.Hea);
        if (!this.HdH) {
            this.HfY.setVisibility(8);
        }
        this.HfN.setOnClickListener(this.Hgc);
        this.HfQ.setOnClickListener(this.Hgd);
        this.Hdb = (Button) this.ncd.findViewById(R.id.aez);
        this.Hdb.setOnClickListener(this.HdZ);
        this.Hdc = (WeImageView) this.ncd.findViewById(R.id.afa);
        if (ao.gJN() && this.Hdc != null) {
            aw.kA(getActivity());
            if (aw.a(aw.gWy(), getActivity().getTaskId()) == -1) {
                this.Hdc.setVisibility(8);
            } else {
                this.Hdc.setVisibility(0);
            }
            this.Hdc.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(115463);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (aw.a(aw.gWy(), VoipVoiceFragment.this.getActivity().getTaskId()) == 2) {
                        aw.a(aw.gWy(), VoipVoiceFragment.this.getActivity().getTaskId(), 0);
                        VoipVoiceFragment.this.Hdc.setBackgroundResource(R.raw.icons_outlined_sperated);
                    } else {
                        aw.a(aw.gWy(), VoipVoiceFragment.this.getActivity().getTaskId(), 2);
                        VoipVoiceFragment.this.Hdc.setBackgroundResource(R.raw.icons_outlined_merge);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(115463);
                }
            });
        }
        int ay = u.ay(getActivity());
        Log.d("MicroMsg.VoipVoiceFragment", "statusHeight: ".concat(String.valueOf(ay)));
        aA(this.Hdb, ay);
        aA(this.Hdc, ay);
        if (this.GUf && 2 == this.GUk) {
            jE(R.string.i0w, 10000);
        }
        String O = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.goe));
        if (!Util.isNullOrNil(O) && this.HfH != null) {
            this.HfH.setText(O);
        }
        this.mTimer = new Timer();
        jD(this.HeE, this.mStatus);
        RelativeLayout relativeLayout = this.ncd;
        AppMethodBeat.o(115476);
        return relativeLayout;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void jD(int i2, int i3) {
        AppMethodBeat.i(115477);
        super.jD(i2, i3);
        Log.i("MicroMsg.VoipVoiceFragment", "newState: " + k.adM(i3) + ", action: " + k.adM(i2) + ", lastStatus: " + k.adM(HeF) + ", isSwitchFromVideo: " + this.Hga);
        if (this.ncd == null) {
            Log.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
            AppMethodBeat.o(115477);
            return;
        }
        switch (i3) {
            case 1:
                fJs();
                AppMethodBeat.o(115477);
                return;
            case 3:
                adC(i2);
                AppMethodBeat.o(115477);
                return;
            case 5:
                fJE();
                AppMethodBeat.o(115477);
                return;
            case 7:
            case 261:
                fJI();
                AppMethodBeat.o(115477);
                return;
            case 8:
            case 262:
                fJF();
                AppMethodBeat.o(115477);
                return;
            case CdnLogic.kAppTypeFestivalImage:
                fJG();
                AppMethodBeat.o(115477);
                return;
            case 259:
                fJH();
                break;
        }
        AppMethodBeat.o(115477);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void uninit() {
        AppMethodBeat.i(115478);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        super.uninit();
        AppMethodBeat.o(115478);
    }

    private void fJs() {
        AppMethodBeat.i(115479);
        this.HfE.setVisibility(0);
        this.HfI.setVisibility(8);
        this.HfJ.setText(R.string.i3x);
        this.HeH.a(this.HfK, HeB);
        this.HfL.setVisibility(0);
        this.HfU.setVisibility(8);
        this.HfV.setVisibility(8);
        this.HfW.setVisibility(8);
        this.HfX.setVisibility(0);
        this.HfY.setVisibility(8);
        this.HfP.setVisibility(0);
        this.HfQ.setEnabled(false);
        this.HfQ.setBackgroundResource(R.drawable.cqf);
        this.HfR.setTextColor(1728053247);
        this.HfT.setVisibility(8);
        if (c.fFg().GUy != null) {
            this.HfT.setVisibility(0);
            this.HfT.setText(c.fFg().GUy);
        }
        fJJ();
        this.HfQ.setChecked(this.mIsMute);
        this.HfM.setVisibility(0);
        if (2 == this.GUk) {
            jE(R.string.i0w, 10000);
        }
        fJz();
        AppMethodBeat.o(115479);
    }

    private void adC(int i2) {
        AppMethodBeat.i(115480);
        this.HfE.setVisibility(0);
        this.HfI.setVisibility(8);
        this.HfJ.setText(R.string.i34);
        this.HeH.a(this.HfK, HeB);
        this.HfL.setVisibility(0);
        if (this.HfH != null) {
            if (!as.bjp(this.goe) || Util.isNullOrNil(this.HfH.getText())) {
                this.HfH.setVisibility(8);
            } else {
                this.HfH.setVisibility(0);
            }
        }
        this.HfU.setVisibility(8);
        this.HfV.setVisibility(8);
        this.HfW.setVisibility(8);
        this.HfX.setVisibility(0);
        this.HfY.setVisibility(8);
        this.HfP.setVisibility(0);
        this.HfQ.setEnabled(false);
        this.HfQ.setBackgroundResource(R.drawable.cqf);
        this.HfR.setTextColor(1728053247);
        fJJ();
        this.HfQ.setChecked(this.mIsMute);
        this.HfM.setVisibility(0);
        if (i2 != 4097 && 2 == this.GUk) {
            jE(R.string.i0w, 10000);
        }
        fJz();
        this.HfT.setVisibility(8);
        if (c.fFg().GUy != null) {
            this.HfT.setVisibility(0);
            this.HfT.setText(c.fFg().GUy);
        }
        if (HeF == 2) {
            this.Hga = true;
        }
        AppMethodBeat.o(115480);
    }

    private void fJE() {
        AppMethodBeat.i(115481);
        this.HfJ.setText(R.string.i57);
        this.HeH.a(this.HfK, HeB);
        this.HfU.setVisibility(8);
        this.HfV.setVisibility(8);
        this.HfW.setVisibility(0);
        this.HfX.setVisibility(8);
        this.HfY.setVisibility(8);
        AppMethodBeat.o(115481);
    }

    private void fJF() {
        AppMethodBeat.i(115482);
        this.HeH.fJB();
        this.HfW.setEnabled(false);
        this.HfX.setEnabled(false);
        this.HfU.setEnabled(false);
        this.HfV.setEnabled(false);
        this.HfY.setEnabled(false);
        AppMethodBeat.o(115482);
    }

    private void fJG() {
        AppMethodBeat.i(115483);
        this.HfE.setVisibility(0);
        this.HfL.setVisibility(0);
        this.HfJ.setText(R.string.i35);
        this.HeH.a(this.HfK, HeB);
        if (this.HfH != null) {
            if (!as.bjp(this.goe) || Util.isNullOrNil(this.HfH.getText())) {
                this.HfH.setVisibility(8);
            } else {
                this.HfH.setVisibility(0);
            }
        }
        fJJ();
        this.HfU.setVisibility(0);
        this.HfV.setVisibility(0);
        this.HfW.setVisibility(8);
        this.HfX.setVisibility(8);
        if (this.HdH) {
            this.HfY.setVisibility(0);
        }
        if (HeF == 256) {
            this.Hga = true;
            jE(R.string.i0x, 10000);
        }
        fJz();
        this.HfT.setVisibility(8);
        if (c.fFg().GUy != null) {
            this.HfT.setVisibility(0);
            this.HfT.setText(c.fFg().GUy);
        }
        AppMethodBeat.o(115483);
    }

    private void fJH() {
        AppMethodBeat.i(115484);
        this.HfE.setVisibility(0);
        this.HfL.setVisibility(0);
        this.HfJ.setText(R.string.i57);
        this.HeH.a(this.HfK, HeB);
        this.HfU.setVisibility(8);
        this.HfV.setVisibility(8);
        this.HfW.setVisibility(0);
        this.HfX.setVisibility(8);
        this.HfY.setVisibility(8);
        jE(R.string.i0w, 10000);
        fJz();
        AppMethodBeat.o(115484);
    }

    private void fJI() {
        AppMethodBeat.i(115485);
        this.HfX.setVisibility(8);
        this.HfU.setVisibility(8);
        this.HfV.setVisibility(8);
        this.HfY.setVisibility(8);
        this.HfL.setVisibility(8);
        this.HeH.fJB();
        this.HfW.setVisibility(0);
        this.HfI.setVisibility(0);
        this.HfP.setVisibility(0);
        this.HfM.setVisibility(0);
        this.HfE.setVisibility(0);
        this.Hdb.setVisibility(0);
        this.HfQ.setEnabled(true);
        this.HfQ.setBackgroundResource(R.drawable.b34);
        this.HfR.setTextColor(-1);
        fJJ();
        this.HfQ.setChecked(this.mIsMute);
        if (!this.Hga) {
            jE(R.string.i0p, 10000);
        } else if (2 == this.GUk) {
            jE(R.string.i0r, 10000);
        } else if (3 == this.GUk) {
            jE(R.string.i0q, 10000);
        }
        if (ac.jPp) {
            this.Hdr.setVisibility(0);
        }
        fJz();
        bpu();
        this.HfT.setVisibility(8);
        if (c.fFg().GUy != null) {
            this.HfT.setVisibility(0);
            this.HfT.setText(c.fFg().GUy);
        }
        AppMethodBeat.o(115485);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void aUB(String str) {
        AppMethodBeat.i(115486);
        if (this.HfT != null) {
            this.HfT.setVisibility(0);
            this.HfT.setText(str);
        }
        AppMethodBeat.o(115486);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void jE(int i2, int i3) {
        AppMethodBeat.i(115487);
        if (this.HfS == null) {
            AppMethodBeat.o(115487);
            return;
        }
        this.HfS.setText(i2);
        this.HfS.setVisibility(0);
        this.HfS.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.HfS.setBackgroundResource(R.drawable.cq9);
        this.HfS.setCompoundDrawables(null, null, null, null);
        this.HfS.setCompoundDrawablePadding(0);
        this.kAn.removeCallbacks(this.rtb);
        if (-1 != i3) {
            this.kAn.postDelayed(this.rtb, (long) i3);
        }
        AppMethodBeat.o(115487);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void xk(boolean z) {
        AppMethodBeat.i(115488);
        if (this.Hgb) {
            AppMethodBeat.o(115488);
            return;
        }
        if (this.yzB != null) {
            if (z) {
                this.yzB.setText(R.string.i3l);
            } else {
                this.yzB.setText(R.string.i3k);
            }
            this.yzB.clearAnimation();
            this.yzB.setVisibility(0);
        }
        AppMethodBeat.o(115488);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void fJq() {
        AppMethodBeat.i(115489);
        if (this.yzB != null) {
            this.yzB.clearAnimation();
            this.yzB.setVisibility(8);
        }
        AppMethodBeat.o(115489);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void m(Point point) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void setMute(boolean z) {
        AppMethodBeat.i(115490);
        Log.printInfoStack("MicroMsg.VoipVoiceFragment", "setMute:%s", Boolean.valueOf(z));
        this.mIsMute = z;
        if (!(this.HfQ == null || this.HfR == null)) {
            this.HfQ.setChecked(z);
        }
        AppMethodBeat.o(115490);
    }

    private void bpu() {
        AppMethodBeat.i(115491);
        if (this.mTimer == null || this.qvo) {
            AppMethodBeat.o(115491);
            return;
        }
        if (-1 == this.Heo) {
            this.Heo = Util.nowSecond();
        }
        this.qvo = true;
        this.mTimer.schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(235815);
                VoipVoiceFragment.this.kAn.post(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(235814);
                        VoipVoiceFragment.this.HfI.setText(VoipVoiceFragment.AF(Util.secondsToNow(VoipVoiceFragment.this.Heo)));
                        VoipVoiceFragment.p(VoipVoiceFragment.this);
                        AppMethodBeat.o(235814);
                    }
                });
                AppMethodBeat.o(235815);
            }
        }, 50, 1000);
        AppMethodBeat.o(115491);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(115492);
        if (i2 != -1) {
            this.GUk = i2;
            fJJ();
        }
        AppMethodBeat.o(115492);
    }

    private void fJJ() {
        AppMethodBeat.i(115493);
        if (this.HfN == null || this.HfO == null) {
            Log.e("MicroMsg.VoipVoiceFragment", "speaker is null");
            AppMethodBeat.o(115493);
        } else if (4 == this.GUk || 3 == this.GUk) {
            this.HfN.setEnabled(false);
            this.HfO.setTextColor(1728053247);
            this.HfN.setBackgroundResource(R.drawable.cq6);
            Log.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, disable mCbVoiceSpeakerSwitcher");
            AppMethodBeat.o(115493);
        } else {
            boolean z = this.GUk == 1;
            this.HfN.setBackgroundResource(R.drawable.b35);
            this.HfN.setEnabled(true);
            this.HfO.setTextColor(-1);
            this.HfN.setChecked(z);
            Log.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, set mCbVoiceSpeakerSwitcher isChecked:%s", Boolean.valueOf(z));
            AppMethodBeat.o(115493);
        }
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void adB(int i2) {
        AppMethodBeat.i(235817);
        if (this.yzB != null) {
            this.Hgb = true;
            if (this.ncd.findViewById(R.id.fuv) != null) {
                this.ncd.findViewById(R.id.fuv).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(235811);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (VoipVoiceFragment.this.ncd.findViewById(R.id.fuv) != null) {
                            ((c) VoipVoiceFragment.this.Hen.get()).fFL();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(235811);
                    }
                });
            }
            this.HfZ.setVisibility(0);
            this.yzB.setVisibility(0);
            this.yzB.setText(R.string.i0z);
            this.kAn.removeCallbacks(this.Hgi);
            this.kAn.postDelayed(this.Hgi, (long) (i2 * 1000));
        }
        AppMethodBeat.o(235817);
    }

    static /* synthetic */ void p(VoipVoiceFragment voipVoiceFragment) {
        AppMethodBeat.i(235818);
        Log.d("MicroMsg.VoipVoiceFragment", "in showEngineInfo");
        if (ac.jPp) {
            byte[] fIe = c.fFg().fIe();
            Log.d("MicroMsg.VoipVoiceFragment", "engine_info: ".concat(String.valueOf(fIe)));
            if (fIe != null) {
                try {
                    String str = new String(fIe, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    Log.d("MicroMsg.VoipVoiceFragment", "engine info: ".concat(String.valueOf(str)));
                    voipVoiceFragment.Hdr.setText(str);
                    AppMethodBeat.o(235818);
                    return;
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.VoipVoiceFragment", e2, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(235818);
    }
}
