package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.g.d;
import com.tencent.mm.model.aa;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVideoFragment extends VoipBaseFragment {
    private Bitmap BQT = null;
    public int GUK = 0;
    public int GUL = 0;
    private d GgP;
    private ImageView HcP;
    private View HcQ;
    private ImageView HcR;
    private TextView HcS;
    private TextView HcT;
    private TextView HcU;
    private TextView HcV;
    private View HcW;
    private TextView HcX;
    private TextView HcY;
    private TextView HcZ;
    private int HdA;
    private int HdB;
    private int HdF = 0;
    private boolean HdG = false;
    private boolean HdH;
    public long HdI = 0;
    public int HdK = 0;
    public int HdL = 0;
    private int HdM = 0;
    private int HdN = 0;
    private MTimerHandler HdO = null;
    private boolean HdP = false;
    private View.OnClickListener HdS = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(115394);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
            if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null || !((c) VoipVideoFragment.this.Hen.get()).fFt())) {
                VoipVideoFragment.this.Hdk.setEnabled(false);
                VoipVideoFragment.this.Hdj.setEnabled(false);
                VoipVideoFragment.this.jE(R.string.i2q, -1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115394);
        }
    };
    private View.OnClickListener HdT = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass12 */

        public final void onClick(View view) {
            AppMethodBeat.i(115406);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null)) {
                ((c) VoipVideoFragment.this.Hen.get()).fFM();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115406);
        }
    };
    private View.OnClickListener HdU = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass16 */

        public final void onClick(View view) {
            AppMethodBeat.i(115407);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null)) {
                ((c) VoipVideoFragment.this.Hen.get()).fFM();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115407);
        }
    };
    private View.OnClickListener HdV = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass17 */

        public final void onClick(View view) {
            AppMethodBeat.i(115410);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
            if (NetStatusUtil.isWifi(VoipVideoFragment.this.getActivity()) || s.fHs()) {
                VoipVideoFragment.c(VoipVideoFragment.this);
            } else {
                h.a(VoipVideoFragment.this.getActivity(), (int) R.string.i3r, (int) R.string.i3s, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass17.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(115408);
                        s.fHr();
                        VoipVideoFragment.c(VoipVideoFragment.this);
                        AppMethodBeat.o(115408);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass17.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(115409);
                        VoipVideoFragment.d(VoipVideoFragment.this);
                        AppMethodBeat.o(115409);
                    }
                });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115410);
        }
    };
    private View.OnClickListener HdW = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass18 */

        public final void onClick(View view) {
            AppMethodBeat.i(115413);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
            if (NetStatusUtil.isWifi(VoipVideoFragment.this.getActivity()) || (s.fHs() && !NetStatusUtil.is2G(VoipVideoFragment.this.getActivity()))) {
                VoipVideoFragment.e(VoipVideoFragment.this);
            } else {
                h.a(VoipVideoFragment.this.getActivity(), (int) R.string.i3r, (int) R.string.i3s, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass18.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(115411);
                        if (!NetStatusUtil.is2G(VoipVideoFragment.this.getActivity())) {
                            s.fHr();
                        }
                        VoipVideoFragment.e(VoipVideoFragment.this);
                        AppMethodBeat.o(115411);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass18.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(115412);
                        VoipVideoFragment.d(VoipVideoFragment.this);
                        AppMethodBeat.o(115412);
                    }
                });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115413);
        }
    };
    private View.OnClickListener HdX = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass19 */

        public final void onClick(View view) {
            AppMethodBeat.i(115414);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
            VoipVideoFragment.d(VoipVideoFragment.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115414);
        }
    };
    private View.OnClickListener HdY = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass20 */

        public final void onClick(View view) {
            AppMethodBeat.i(115415);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
            if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null || !((c) VoipVideoFragment.this.Hen.get()).fFA())) {
                VoipVideoFragment.this.Hdk.setEnabled(false);
                VoipVideoFragment.this.Hdg.setEnabled(false);
                VoipVideoFragment.this.HcY.setVisibility(0);
                VoipVideoFragment.this.HcY.setText(R.string.i1i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115415);
        }
    };
    private View.OnClickListener HdZ = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass21 */

        public final void onClick(View view) {
            AppMethodBeat.i(115416);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (System.currentTimeMillis() - VoipVideoFragment.this.nJh <= 1000) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(115416);
                return;
            }
            VoipVideoFragment.this.nJh = System.currentTimeMillis();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11618, 2, 1);
            if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null)) {
                ((c) VoipVideoFragment.this.Hen.get()).wX(true);
            }
            if (VoipVideoFragment.this.HeG != null) {
                VoipVideoFragment.this.fJx();
                VoipVideoFragment.this.HeG.aI(false, true);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115416);
        }
    };
    private RelativeLayout Hda;
    private Button Hdb;
    private WeImageView Hdc;
    private VoipSmallIconButton Hdd;
    private VoipSmallIconButton Hde;
    private VoipSmallIconButton Hdf;
    private VoipBigIconButton Hdg;
    private VoipBigIconButton Hdh;
    private VoipBigIconButton Hdi;
    private VoipBigIconButton Hdj;
    private VoipBigIconButton Hdk;
    private VoipBigIconButton Hdl;
    private TextView Hdm;
    private TextView Hdn;
    private TextView Hdo;
    private TextView Hdp;
    private TextView Hdq;
    private TextView Hdr;
    private com.tencent.mm.plugin.voip.video.d Hdu = null;
    private Button Hdv = null;
    private Button Hdw = null;
    private boolean Hdx = false;
    private int Hdy;
    private int Hdz;
    private View.OnClickListener Hea = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass22 */

        public final void onClick(View view) {
            AppMethodBeat.i(115417);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11619, 2);
            if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null)) {
                ((c) VoipVideoFragment.this.Hen.get()).fFY();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115417);
        }
    };
    private View.OnClickListener Heb = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(115395);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            VoipVideoFragment.this.Hdx = !VoipVideoFragment.this.Hdx;
            if (!VoipVideoFragment.this.Hdx) {
                VoipVideoFragment.this.Hdu.setVisibility(8);
            }
            Toast.makeText(VoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", Boolean.valueOf(VoipVideoFragment.this.Hdx)), 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115395);
        }
    };
    private View.OnClickListener Hec = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(115396);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            boolean nullAs = Util.nullAs((Boolean) view.getTag(), false);
            view.setTag(Boolean.valueOf(!nullAs));
            if (nullAs) {
                VoipVideoFragment.this.Hdu.setVisibility(8);
                Toast.makeText(VoipVideoFragment.this.getActivity(), "stop face detect", 0).show();
            } else {
                Toast.makeText(VoipVideoFragment.this.getActivity(), "start face detect", 0).show();
            }
            if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null)) {
                ((c) VoipVideoFragment.this.Hen.get()).fFZ();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115396);
        }
    };
    private View.OnClickListener Hed = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass9 */

        public final void onClick(View view) {
            AppMethodBeat.i(235791);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
            VoipVideoFragment.this.Hdl.setEnabled(false);
            VoipVideoFragment.q(VoipVideoFragment.this);
            VoipVideoFragment.this.Hdl.setEnabled(true);
            if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null)) {
                ((c) VoipVideoFragment.this.Hen.get()).fFF();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235791);
        }
    };
    private Runnable Hee = new Runnable() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass10 */

        public final void run() {
            AppMethodBeat.i(235792);
            Log.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
            VoipVideoFragment.r(VoipVideoFragment.this);
            if (VoipVideoFragment.this.getActivity() == null || VoipVideoFragment.this.getActivity().isFinishing()) {
                AppMethodBeat.o(235792);
            } else if (VoipVideoFragment.this.HdF > 0) {
                AppMethodBeat.o(235792);
            } else {
                VoipVideoFragment.this.Hdl.setVisibility(8);
                VoipVideoFragment.this.Hdb.setVisibility(8);
                VoipVideoFragment.this.HcX.setVisibility(8);
                VoipVideoFragment.this.Hdk.setVisibility(8);
                VoipVideoFragment.this.Hdj.setVisibility(8);
                VoipVideoFragment.this.Hdc.setVisibility(8);
                VoipVideoFragment.d(VoipVideoFragment.this, false);
                AppMethodBeat.o(235792);
            }
        }
    };
    private OpenGlView Hfn;
    private OpenGlView Hfo;
    private OpenGlRender Hfp;
    private OpenGlRender Hfq;
    private VoIPVideoView Hfr;
    private a Hfs;
    public int Hft = 0;
    int Hfu = 0;
    Bitmap Hfv = null;
    private PowerManager.WakeLock hCN;
    private Timer mTimer;
    private long nJh = 0;
    private CaptureView qsJ;
    private boolean qsM = false;
    private int qvm;
    private boolean qvo = false;
    private Runnable rtb = new Runnable() {
        /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass11 */

        public final void run() {
            AppMethodBeat.i(235793);
            if (VoipVideoFragment.this.getActivity() == null || VoipVideoFragment.this.getActivity().isFinishing()) {
                AppMethodBeat.o(235793);
                return;
            }
            VoipVideoFragment.this.HcY.setVisibility(8);
            AppMethodBeat.o(235793);
        }
    };
    private SurfaceTexture surfaceTexture = null;
    private TextView yzB;
    int[] zLY = null;

    public VoipVideoFragment() {
        AppMethodBeat.i(115420);
        AppMethodBeat.o(115420);
    }

    static /* synthetic */ Point c(VoipVideoFragment voipVideoFragment, boolean z) {
        AppMethodBeat.i(235805);
        Point xl = voipVideoFragment.xl(z);
        AppMethodBeat.o(235805);
        return xl;
    }

    static /* synthetic */ void q(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(235806);
        voipVideoFragment.fJp();
        AppMethodBeat.o(235806);
    }

    static /* synthetic */ int r(VoipVideoFragment voipVideoFragment) {
        int i2 = voipVideoFragment.HdF;
        voipVideoFragment.HdF = i2 - 1;
        return i2;
    }

    static /* synthetic */ void y(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(235810);
        voipVideoFragment.fJo();
        AppMethodBeat.o(235810);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(115421);
        this.ncd = (RelativeLayout) layoutInflater.inflate(R.layout.c75, viewGroup, false);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) this.ncd.findViewById(R.id.h7x)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(getActivity(), 40.0f));
        }
        this.HeC = (ImageView) this.ncd.findViewById(R.id.jao);
        this.HeD = (ImageView) this.ncd.findViewById(R.id.jbn);
        this.Hda = (RelativeLayout) this.ncd.findViewById(R.id.eo6);
        this.Hfn = (OpenGlView) this.ncd.findViewById(R.id.a3j);
        this.Hfn.jG(mScreenWidth, mScreenHeight);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
        this.Hdl = (VoipBigIconButton) this.ncd.findViewById(R.id.jbj);
        this.Hdl.setOnClickListener(this.Hed);
        this.Hdk = (VoipBigIconButton) this.ncd.findViewById(R.id.jbz);
        this.Hdk.setOnClickListener(this.HdT);
        this.Hdg = (VoipBigIconButton) this.ncd.findViewById(R.id.jap);
        this.Hdg.setOnClickListener(this.HdY);
        this.Hdj = (VoipBigIconButton) this.ncd.findViewById(R.id.jb6);
        this.Hdj.setOnClickListener(this.HdS);
        this.Hdi = (VoipBigIconButton) this.ncd.findViewById(R.id.jal);
        this.Hdi.setOnClickListener(this.HdW);
        this.Hdf = (VoipSmallIconButton) this.ncd.findViewById(R.id.jam);
        this.Hdf.setOnClickListener(this.HdV);
        this.Hdh = (VoipBigIconButton) this.ncd.findViewById(R.id.jbg);
        this.Hdh.setOnClickListener(this.HdX);
        this.Hde = (VoipSmallIconButton) this.ncd.findViewById(R.id.jbk);
        this.Hde.setOnClickListener(this.HdU);
        this.HdH = m.Se("VOIPBlockIgnoreButton") == 0;
        this.Hdd = (VoipSmallIconButton) this.ncd.findViewById(R.id.jb7);
        this.Hdd.setOnClickListener(this.Hea);
        if (!this.HdH) {
            this.Hdd.setVisibility(8);
        }
        this.HcX = (TextView) this.ncd.findViewById(R.id.jc0);
        this.HcQ = this.ncd.findViewById(R.id.jbt);
        this.HcR = (ImageView) this.ncd.findViewById(R.id.jbs);
        a.b.a(this.HcR, this.goe, 0.05882353f, true);
        this.HcS = (TextView) this.ncd.findViewById(R.id.jbu);
        this.HcT = (TextView) this.ncd.findViewById(R.id.jbw);
        this.HcU = (TextView) this.ncd.findViewById(R.id.jbp);
        this.HcV = (TextView) this.ncd.findViewById(R.id.jbr);
        this.HcW = this.ncd.findViewById(R.id.jbq);
        z(this.HcV);
        this.HcY = (TextView) this.ncd.findViewById(R.id.jbo);
        this.HcZ = (TextView) this.ncd.findViewById(R.id.jby);
        this.Hdb = (Button) this.ncd.findViewById(R.id.aez);
        this.Hdc = (WeImageView) this.ncd.findViewById(R.id.afa);
        this.yzB = (TextView) this.ncd.findViewById(R.id.jbc);
        this.HcP = (ImageView) this.ncd.findViewById(R.id.dbi);
        this.HcP.setImageBitmap(BitmapUtil.fastblur(c.a(this.goe, false, -1, null), 10));
        if (ac.jPp) {
            this.Hdm = (TextView) this.ncd.findViewById(R.id.jaq);
            this.Hdn = (TextView) this.ncd.findViewById(R.id.jbh);
            this.Hdo = (TextView) this.ncd.findViewById(R.id.jbe);
            this.Hdp = (TextView) this.ncd.findViewById(R.id.jbi);
            this.Hdq = (TextView) this.ncd.findViewById(R.id.jbf);
            this.Hdr = (TextView) this.ncd.findViewById(R.id.c3w);
        }
        this.Hdv = (Button) this.ncd.findViewById(R.id.jb4);
        this.Hdw = (Button) this.ncd.findViewById(R.id.jb5);
        this.Hdv.setVisibility(8);
        this.Hdw.setVisibility(8);
        this.Hdv.setOnClickListener(this.Heb);
        this.Hdw.setOnClickListener(this.Hec);
        this.Hdu = new com.tencent.mm.plugin.voip.video.d(getActivity());
        this.ncd.addView(this.Hdu);
        this.Hdu.setVisibility(8);
        this.Hdb.setOnClickListener(this.HdZ);
        if (ao.gJN()) {
            fJo();
        }
        b(this.qsJ);
        int ay = u.ay(getActivity());
        Log.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(ay)));
        aA(this.Hdb, ay);
        aA(this.Hdc, ay);
        aA(this.ncd.findViewById(R.id.jbm), ay);
        aA(this.HcQ, ay);
        this.Hdz = 0;
        this.Hdy = 0;
        this.qvm = 0;
        this.HdA = 0;
        this.HdB = 0;
        this.HdM = 0;
        this.HdN = 0;
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        this.Hfo = new MovableVideoView(getActivity().getApplicationContext());
        ((MovableVideoView) this.Hfo).jF(width, height);
        this.Hfo.setVisibility(0);
        this.Hfo.xv(true);
        this.Hfp = new OpenGlRender(this.Hfo, OpenGlRender.RenderRemote);
        this.Hfo.setRenderer(this.Hfp);
        this.Hfo.setRenderMode(0);
        this.Hfp.HiQ = new OpenGlRender.b() {
            /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void fJD() {
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Lj(long j2) {
                AppMethodBeat.i(235783);
                if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null || j2 <= 0)) {
                    ((c) VoipVideoFragment.this.Hen.get()).ah(j2, 2);
                }
                AppMethodBeat.o(235783);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Lk(long j2) {
                AppMethodBeat.i(235784);
                if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null || j2 <= 0)) {
                    ((c) VoipVideoFragment.this.Hen.get()).ah(j2, 0);
                }
                AppMethodBeat.o(235784);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Ll(long j2) {
                AppMethodBeat.i(235785);
                if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null || j2 <= 0)) {
                    ((c) VoipVideoFragment.this.Hen.get()).ah(j2, 1);
                }
                AppMethodBeat.o(235785);
            }
        };
        this.Hfq = new OpenGlRender(this.Hfn, OpenGlRender.RenderLocal);
        this.Hfn.setRenderer(this.Hfq);
        this.Hfn.setRenderMode(0);
        this.Hfn.setVisibility(0);
        this.Hfq.HiQ = new OpenGlRender.b() {
            /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void fJD() {
                AppMethodBeat.i(235786);
                if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null)) {
                    ((c) VoipVideoFragment.this.Hen.get()).ah(0, 3);
                }
                AppMethodBeat.o(235786);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Lj(long j2) {
                AppMethodBeat.i(235787);
                if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null || j2 <= 0)) {
                    ((c) VoipVideoFragment.this.Hen.get()).ah(j2, 2);
                }
                AppMethodBeat.o(235787);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Lk(long j2) {
                AppMethodBeat.i(235788);
                if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null || j2 <= 0)) {
                    ((c) VoipVideoFragment.this.Hen.get()).ah(j2, 0);
                }
                AppMethodBeat.o(235788);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Ll(long j2) {
                AppMethodBeat.i(235789);
                if (!(VoipVideoFragment.this.Hen == null || VoipVideoFragment.this.Hen.get() == null || j2 <= 0)) {
                    ((c) VoipVideoFragment.this.Hen.get()).ah(j2, 1);
                }
                AppMethodBeat.o(235789);
            }
        };
        Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
        this.ncd.addView(this.Hfo);
        this.Hfo.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass7 */
            long Heg = 0;

            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(235790);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
                if (VoipVideoFragment.this.Hfo.Hjc || VoipVideoFragment.this.Hfo.getVisibility() != 0) {
                    Log.i("MicroMsg.Voip.VoipVideoFragment", "current view is not show ");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(235790);
                } else if (Util.ticksToNow(this.Heg) < 400) {
                    Log.i("MicroMsg.Voip.VoipVideoFragment", "click mGlSmallVideoView too fast and not allow to response it,times%s", Long.valueOf(Util.ticksToNow(this.Heg)));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(235790);
                } else {
                    this.Heg = Util.currentTicks();
                    VoipVideoFragment.this.HdG = !VoipVideoFragment.this.HdG;
                    VoipVideoFragment.this.fJC();
                    VoipVideoFragment voipVideoFragment = VoipVideoFragment.this;
                    if (!VoipVideoFragment.this.HdG) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Point c2 = VoipVideoFragment.c(voipVideoFragment, z);
                    VoipVideoFragment.this.Hfo.jH(c2.x, c2.y);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11079, 3);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(235790);
                }
            }
        });
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.goe);
        this.HcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getActivity(), aa.b(Kn, this.goe), this.HcS.getTextSize()));
        String O = com.tencent.mm.openim.room.a.a.O(Kn);
        if (!Util.isNullOrNil(O)) {
            this.HcT.setText(O);
        }
        if (this.GUf) {
            this.kAn.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(115401);
                    VoipVideoFragment.this.HcU.setText(R.string.i34);
                    VoipVideoFragment.this.HeH.a(VoipVideoFragment.this.HcV, VoipBaseFragment.HeB);
                    AppMethodBeat.o(115401);
                }
            }, 2000);
        }
        this.Hfr = (VoIPVideoView) this.ncd.findViewById(R.id.jbl);
        this.mTimer = new Timer("VoIP_video_talking_count");
        Log.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", Integer.valueOf(this.HdL));
        this.Hfq.setVoipBeauty(this.HdL);
        this.Hfp.setVoipBeauty(this.HdL);
        this.Hfq.setSpatiotemporalDenosing(this.Hft);
        this.Hfp.setSpatiotemporalDenosing(this.Hft);
        if (!(this.Hen == null || this.Hen.get() == null)) {
            ((c) this.Hen.get()).aE(true, (260 == this.mStatus || 6 == this.mStatus) ? false : true);
            this.Hfq.HiO = true;
            this.Hfp.HiO = true;
        }
        this.qsM = true;
        jA(this.GUK, this.GUL);
        jD(0, this.mStatus);
        this.hCN = ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
        this.hCN.acquire();
        Log.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
        RelativeLayout relativeLayout = this.ncd;
        AppMethodBeat.o(115421);
        return relativeLayout;
    }

    private void fJo() {
        AppMethodBeat.i(235798);
        if (this.Hdc == null) {
            AppMethodBeat.o(235798);
            return;
        }
        aw.kA(getActivity());
        if (aw.a(aw.gWy(), getActivity().getTaskId()) == -1) {
            this.Hdc.setVisibility(8);
        } else {
            this.Hdc.setVisibility(0);
        }
        this.Hdc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(115397);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (aw.a(aw.gWy(), VoipVideoFragment.this.getActivity().getTaskId()) == 2) {
                    aw.a(aw.gWy(), VoipVideoFragment.this.getActivity().getTaskId(), 0);
                    VoipVideoFragment.this.Hdc.setBackgroundResource(R.raw.icons_outlined_sperated);
                } else {
                    aw.a(aw.gWy(), VoipVideoFragment.this.getActivity().getTaskId(), 2);
                    VoipVideoFragment.this.Hdc.setBackgroundResource(R.raw.icons_outlined_merge);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(115397);
            }
        });
        AppMethodBeat.o(235798);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        AppMethodBeat.i(115422);
        this.qvo = false;
        Log.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
        super.onDestroy();
        if (this.hCN != null && this.hCN.isHeld()) {
            Log.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
            this.hCN.release();
        }
        AppMethodBeat.o(115422);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void requestRender() {
        AppMethodBeat.i(115423);
        if (this.HdG) {
            this.Hfn.HhI.requestRender();
            AppMethodBeat.o(115423);
            return;
        }
        this.Hfo.HhI.requestRender();
        AppMethodBeat.o(115423);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void releaseSurfaceTexture() {
        AppMethodBeat.i(115424);
        this.Hfq.releaseSurfaceTexture();
        this.Hfp.releaseSurfaceTexture();
        AppMethodBeat.o(115424);
    }

    public final void fJC() {
        AppMethodBeat.i(115425);
        if (!(this.Hfq == null || this.Hfp == null)) {
            if (this.HdG) {
                this.Hfp.setShowMode(0);
                if ((this.HdK & 1) != 0) {
                    this.Hfq.setShowMode(1);
                } else {
                    this.Hfq.setShowMode(0);
                }
            } else {
                this.Hfq.setShowMode(0);
                if ((this.HdK & 1) != 0) {
                    this.Hfp.setShowMode(1);
                } else {
                    this.Hfp.setShowMode(0);
                }
            }
            Log.i("MicroMsg.Voip.VoipVideoFragment", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d,mIsSmallViewShowSelf:%b, after changeSurfaceRender", Integer.valueOf(this.Hfq.HiI), Integer.valueOf(this.Hfp.HiI), Boolean.valueOf(this.HdG));
        }
        AppMethodBeat.o(115425);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void a(SurfaceTexture surfaceTexture2, d dVar) {
        AppMethodBeat.i(115426);
        if (surfaceTexture2 == null || dVar == null) {
            Log.e("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture error, videoTexture:%s, videoTexture:%s", surfaceTexture2, dVar);
            AppMethodBeat.o(115426);
            return;
        }
        this.surfaceTexture = surfaceTexture2;
        this.GgP = dVar;
        if (!this.qsM || this.Hfq == null || this.Hfp == null) {
            Log.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture failed , texId:%d,mInitDone:%b", Integer.valueOf(dVar.igv), Boolean.valueOf(this.qsM));
            AppMethodBeat.o(115426);
            return;
        }
        this.Hfq.a(this.surfaceTexture, dVar);
        this.Hfp.a(this.surfaceTexture, dVar);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "setSurfaceTexture OK , videoTexture:%d", Integer.valueOf(dVar.igv));
        AppMethodBeat.o(115426);
    }

    private void fJp() {
        AppMethodBeat.i(115427);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
        this.HdF++;
        this.kAn.postDelayed(this.Hee, 10000);
        AppMethodBeat.o(115427);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void jD(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(115428);
        super.jD(i2, i3);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + k.adM(i3));
        if (this.ncd == null) {
            Log.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
            AppMethodBeat.o(115428);
            return;
        }
        switch (i3) {
            case 0:
            case 2:
                fJs();
                z = true;
                break;
            case 4:
            case CdnLogic.kAppTypeFestivalVideo:
                fJu();
                z = true;
                break;
            case 6:
            case 260:
                fJv();
                fJt();
                z = true;
                break;
            case 8:
            case 262:
                adA(i2);
                z = true;
                break;
            case 256:
                z = false;
                fJr();
                break;
            default:
                z = true;
                break;
        }
        if (ae.gKt.gFB == 1 && z) {
            this.HcP.setVisibility(8);
        }
        AppMethodBeat.o(115428);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void a(CaptureView captureView) {
        AppMethodBeat.i(235799);
        this.qsJ = captureView;
        b(this.qsJ);
        AppMethodBeat.o(235799);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void uninit() {
        AppMethodBeat.i(115430);
        Log.printInfoStack("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
        if (this.Hfo != null) {
            this.Hfo.setVisibility(4);
        }
        if (this.qsJ != null) {
            this.ncd.removeView(this.qsJ);
            this.qsJ = null;
            Log.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
        }
        if (this.Hfs != null) {
            this.Hfs.cancel();
            this.Hfs = null;
        }
        super.uninit();
        AppMethodBeat.o(115430);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void setMute(boolean z) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        AppMethodBeat.i(115431);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "onStop");
        this.Hfq.fKM();
        this.Hfp.fKM();
        super.onStop();
        AppMethodBeat.o(115431);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        AppMethodBeat.i(115432);
        this.Hfq.onStarted();
        this.Hfp.onStarted();
        super.onStart();
        AppMethodBeat.o(115432);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void aUB(String str) {
        AppMethodBeat.i(115433);
        if (this.HcZ != null) {
            this.HcZ.setVisibility(0);
            this.HcZ.setText(str);
        }
        AppMethodBeat.o(115433);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void jE(int i2, int i3) {
        AppMethodBeat.i(115434);
        if (this.HcY == null) {
            AppMethodBeat.o(115434);
            return;
        }
        this.HcY.setText(i2);
        this.HcY.setVisibility(0);
        this.HcY.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.HcY.setBackgroundResource(R.drawable.cq9);
        this.HcY.setCompoundDrawables(null, null, null, null);
        this.HcY.setCompoundDrawablePadding(0);
        this.kAn.removeCallbacks(this.rtb);
        if (-1 != i3) {
            this.kAn.postDelayed(this.rtb, (long) i3);
        }
        AppMethodBeat.o(115434);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void xk(boolean z) {
        AppMethodBeat.i(115435);
        if (this.yzB != null) {
            if (z) {
                this.yzB.setText(R.string.i3l);
            } else {
                this.yzB.setText(R.string.i3k);
            }
            this.yzB.clearAnimation();
            this.yzB.setVisibility(0);
        }
        AppMethodBeat.o(115435);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void fJq() {
        AppMethodBeat.i(115436);
        if (this.yzB != null) {
            this.yzB.clearAnimation();
            this.yzB.setVisibility(8);
        }
        AppMethodBeat.o(115436);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void m(Point point) {
        RelativeLayout.LayoutParams layoutParams;
        AppMethodBeat.i(235800);
        OpenGlView openGlView = this.Hfn;
        Log.i(OpenGlView.TAG, "new size from resoureHelper w %s * h  %s", Integer.valueOf(com.tencent.mm.cb.a.jn(openGlView.getContext())), Integer.valueOf(com.tencent.mm.cb.a.jo(openGlView.getContext())));
        int i2 = point.x;
        int i3 = point.y;
        openGlView.Hja = i2;
        openGlView.Hjb = i3;
        if (ao.gJI()) {
            int i4 = (i3 * 9) / 16;
            layoutParams = new RelativeLayout.LayoutParams(i4, i3);
            layoutParams.addRule(13);
            openGlView.Hja = i4;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        openGlView.setLayoutParams(layoutParams);
        openGlView.setLayoutParams(layoutParams);
        if (this.Hfo != null) {
            MovableVideoView movableVideoView = (MovableVideoView) this.Hfo;
            Log.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", Integer.valueOf(movableVideoView.mWidth), Integer.valueOf(movableVideoView.HhR));
            movableVideoView.mScreenWidth = 0;
            movableVideoView.jF(movableVideoView.mWidth, movableVideoView.HhR);
        }
        AppMethodBeat.o(235800);
    }

    private void fJr() {
        AppMethodBeat.i(115438);
        this.Hfn.setVisibility(0);
        if (this.HeD != null) {
            fJA();
        }
        this.HcQ.setVisibility(0);
        this.HcS.setVisibility(0);
        if (!as.bjp(this.goe) || Util.isNullOrNil(this.HcT.getText())) {
            this.HcT.setVisibility(8);
        } else {
            this.HcT.setVisibility(0);
        }
        this.HcU.setText(R.string.i36);
        this.HcW.setVisibility(0);
        this.HcR.setVisibility(0);
        this.HeH.a(this.HcV, HeB);
        this.Hdl.setVisibility(8);
        this.Hdk.setVisibility(8);
        this.Hdg.setVisibility(8);
        this.Hdj.setVisibility(8);
        this.Hdi.setVisibility(0);
        this.Hdf.setVisibility(0);
        this.Hdh.setVisibility(0);
        this.Hde.setVisibility(8);
        if (this.HdH) {
            this.Hdd.setVisibility(0);
        }
        this.HcZ.setVisibility(8);
        if (com.tencent.mm.plugin.voip.c.fFg().GUy != null) {
            this.HcZ.setVisibility(0);
            this.HcZ.setText(com.tencent.mm.plugin.voip.c.fFg().GUy);
        }
        if (ae.gKt.gFB == 1) {
            this.HcP.setVisibility(0);
            this.Hfn.setVisibility(4);
        }
        AppMethodBeat.o(115438);
    }

    private void fJs() {
        AppMethodBeat.i(115439);
        this.HcW.setVisibility(0);
        this.Hfn.setVisibility(0);
        this.HcU.setText(R.string.i34);
        if (!as.bjp(this.goe) || Util.isNullOrNil(this.HcT.getText())) {
            this.HcT.setVisibility(8);
        } else {
            this.HcT.setVisibility(0);
        }
        this.HeC.setVisibility(8);
        this.HcY.setVisibility(8);
        this.HcZ.setVisibility(8);
        if (com.tencent.mm.plugin.voip.c.fFg().GUy != null) {
            this.HcZ.setVisibility(0);
            this.HcZ.setText(com.tencent.mm.plugin.voip.c.fFg().GUy);
        }
        this.HeH.a(this.HcV, HeB);
        this.Hdl.setVisibility(8);
        this.Hdk.setVisibility(8);
        this.Hdg.setVisibility(0);
        this.Hdj.setVisibility(8);
        this.Hdi.setVisibility(8);
        this.Hdf.setVisibility(8);
        this.Hdh.setVisibility(8);
        this.Hde.setVisibility(0);
        this.Hdd.setVisibility(8);
        AppMethodBeat.o(115439);
    }

    private void fJt() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(115440);
        if (this.HeD != null) {
            this.HeD.setVisibility(8);
        }
        if (!this.Hfo.Hjc) {
            AppMethodBeat.o(115440);
            return;
        }
        this.Hfo.xv(false);
        if (this.GUf) {
            this.HdG = !this.HdG;
            if (!this.HdG) {
                z2 = true;
            } else {
                z2 = false;
            }
            Point xl = xl(z2);
            this.Hfo.jH(xl.x, xl.y);
        } else {
            if (!this.HdG) {
                z = true;
            } else {
                z = false;
            }
            this.HdG = z;
            this.Hfr.setVisibility(8);
        }
        if (ac.jPp) {
            this.Hdm.setVisibility(0);
            this.Hdn.setVisibility(0);
            this.Hdo.setVisibility(0);
            this.Hdp.setVisibility(0);
            this.Hdq.setVisibility(0);
            this.Hdr.setVisibility(0);
        }
        this.HcQ.setVisibility(8);
        this.Hfn.setVisibility(0);
        this.Hfo.setVisibility(0);
        this.HcX.setVisibility(0);
        this.Hdb.setVisibility(0);
        if (ao.gJN()) {
            fJo();
        }
        this.Hdl.setVisibility(0);
        this.Hdk.setVisibility(0);
        this.Hdg.setVisibility(8);
        this.Hdj.setVisibility(0);
        this.Hdi.setVisibility(8);
        this.Hdf.setVisibility(8);
        this.Hdh.setVisibility(8);
        this.Hde.setVisibility(8);
        this.Hdd.setVisibility(8);
        setHWDecMode(this.HdK);
        Log.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", Integer.valueOf(this.HdK));
        if (this.HdG) {
            z3 = false;
        }
        Point xl2 = xl(z3);
        ((MovableVideoView) this.Hfo).jF(xl2.x, xl2.y);
        bpu();
        if (MMApplicationContext.getDefaultPreference().getBoolean("voipfaceDebug", false)) {
            this.Hdv.setVisibility(0);
            this.Hdw.setVisibility(0);
        }
        fJp();
        if (this.HeE == 4102) {
            jE(R.string.i0p, 10000);
        }
        AppMethodBeat.o(115440);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void setDeviceOrientation(int i2) {
        AppMethodBeat.i(235801);
        super.setDeviceOrientation(i2);
        if (i2 == 0 || i2 == 180) {
            this.Hfq.Hir = 0;
            this.Hfp.Hir = 0;
            AppMethodBeat.o(235801);
            return;
        }
        this.Hfq.Hir = 360 - i2;
        this.Hfp.Hir = 360 - i2;
        AppMethodBeat.o(235801);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void b(byte[] bArr, long j2, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(235802);
        if (!this.qsM) {
            AppMethodBeat.o(235802);
            return;
        }
        if (OpenGlRender.His == 1) {
            if (this.Hfu < i2 * i3) {
                this.zLY = null;
            }
            if (this.zLY == null) {
                this.Hfu = i2 * i3;
                this.zLY = new int[this.Hfu];
            }
            if (com.tencent.mm.plugin.voip.c.fFg().a(bArr, (int) j2, i4 & 31, i2, i3, this.zLY, true) < 0 || this.zLY == null) {
                AppMethodBeat.o(235802);
                return;
            } else if (this.HdG) {
                this.Hfp.a(this.zLY, i2, i3, OpenGlRender.FLAG_RGBAClip + i5 + i6, true);
            } else {
                this.Hfq.a(this.zLY, i2, i3, OpenGlRender.FLAG_RGBAClip + i5 + i6, true);
            }
        } else if (OpenGlRender.His == 2) {
            if (this.HdG) {
                this.Hfp.a(bArr, i2, i3, OpenGlRender.FLAG_NV21 + i5 + i6, true, 3);
            } else {
                this.Hfq.a(bArr, i2, i3, OpenGlRender.FLAG_NV21 + i5 + i6, true, 3);
            }
        }
        this.Hdz++;
        this.Hdy++;
        com.tencent.mm.plugin.voip.video.d dVar = this.Hdu;
        dVar.Hhz = i2;
        dVar.HhA = i3;
        com.tencent.mm.plugin.voip.video.d dVar2 = this.Hdu;
        int width = this.ncd.getWidth();
        int height = this.ncd.getHeight();
        dVar2.Hhy = width;
        dVar2.sT = height;
        AppMethodBeat.o(235802);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void setHWDecMode(int i2) {
        AppMethodBeat.i(115442);
        this.HdK = i2;
        if (this.Hfo == null || this.Hfo.Hjc) {
            AppMethodBeat.o(115442);
            return;
        }
        Log.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %d, mIsSmallViewShowSelf:%b, before changeSurfaceRender", Integer.valueOf(this.HdK), Boolean.valueOf(this.HdG));
        fJC();
        AppMethodBeat.o(115442);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final OpenGlRender fJy() {
        if (this.HdG) {
            return this.Hfp;
        }
        return this.Hfq;
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final OpenGlRender getSpatioTemporalFilterData() {
        if (this.HdG) {
            return this.Hfp;
        }
        return this.Hfq;
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void f(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(115443);
        if (!this.qsM) {
            AppMethodBeat.o(115443);
            return;
        }
        this.qvm++;
        if (OpenGlRender.His == 1) {
            if (this.HdG) {
                this.Hfq.i(bArr, i2, i3, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
                AppMethodBeat.o(115443);
                return;
            }
            this.Hfp.i(bArr, i2, i3, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90);
            AppMethodBeat.o(115443);
        } else if (this.HdG) {
            this.Hfq.a(bArr, i2, i3, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
            AppMethodBeat.o(115443);
        } else {
            this.Hfp.a(bArr, i2, i3, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
            AppMethodBeat.o(115443);
        }
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void fJx() {
        AppMethodBeat.i(115444);
        if (!this.qsM) {
            AppMethodBeat.o(115444);
            return;
        }
        this.Hfq.fKN();
        this.Hfp.fKN();
        AppMethodBeat.o(115444);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void setVoipBeauty(int i2) {
        AppMethodBeat.i(115445);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", Integer.valueOf(i2), Boolean.valueOf(this.qsM));
        this.HdL = i2;
        if (!this.qsM) {
            AppMethodBeat.o(115445);
            return;
        }
        this.Hfq.setVoipBeauty(this.HdL);
        this.Hfp.setVoipBeauty(this.HdL);
        AppMethodBeat.o(115445);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void setSpatiotemporalDenosing(int i2) {
        AppMethodBeat.i(235803);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "setSpatiotemporalDenosing isON:%d, mInitDone:%b", Integer.valueOf(i2), Boolean.valueOf(this.qsM));
        this.Hft = i2;
        if (!this.qsM) {
            AppMethodBeat.o(235803);
            return;
        }
        this.Hfq.setSpatiotemporalDenosing(this.Hft);
        this.Hfp.setSpatiotemporalDenosing(this.Hft);
        AppMethodBeat.o(235803);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void jA(int i2, int i3) {
        AppMethodBeat.i(115446);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "adjustHWViewAspectRatio, mInitDone:%b, HWDecsize:%dx%d,  lastHWDecsize:%dx%d", Boolean.valueOf(this.qsM), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.GUK), Integer.valueOf(this.GUL));
        if (i2 == 0 || i3 == 0) {
            AppMethodBeat.o(115446);
            return;
        }
        if (!(this.GUK == i2 && this.GUL == i3)) {
            this.GUK = i2;
            this.GUL = i3;
        }
        if (this.qsM) {
            this.Hfq.jA(i2, i3);
            this.Hfp.jA(i2, i3);
        }
        AppMethodBeat.o(115446);
    }

    private void fJu() {
        AppMethodBeat.i(115447);
        this.HcU.setText(R.string.i57);
        this.HeH.a(this.HcV, HeB);
        AppMethodBeat.o(115447);
    }

    private void adA(int i2) {
        AppMethodBeat.i(115448);
        this.HeH.fJB();
        this.Hdg.setEnabled(false);
        this.Hdk.setEnabled(false);
        this.Hdj.setEnabled(false);
        this.Hdi.setEnabled(false);
        this.Hdh.setEnabled(false);
        this.Hdf.setEnabled(false);
        this.Hdl.setEnabled(false);
        this.Hde.setEnabled(false);
        this.Hdd.setEnabled(false);
        switch (i2) {
            case 4105:
                this.HcY.setVisibility(0);
                this.HcY.setText(R.string.i3q);
                break;
        }
        if (this.HeG != null) {
            this.HeG.aI(true, false);
        }
        AppMethodBeat.o(115448);
    }

    private void bpu() {
        AppMethodBeat.i(115449);
        if (this.mTimer == null || this.qvo) {
            AppMethodBeat.o(115449);
            return;
        }
        if (-1 == this.Heo) {
            this.Heo = Util.nowSecond();
        }
        this.HdI = this.Heo;
        this.qvo = true;
        this.mTimer.schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(235795);
                VoipVideoFragment.this.kAn.post(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass13.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(235794);
                        VoipVideoFragment.this.HcX.setText(VoipVideoFragment.AF(Util.secondsToNow(VoipVideoFragment.this.Heo)));
                        VoipVideoFragment.v(VoipVideoFragment.this);
                        AppMethodBeat.o(235794);
                    }
                });
                AppMethodBeat.o(235795);
            }
        }, 1000, 1000);
        this.HdO = new MTimerHandler("VoipVideoFragment_cpuStatThread", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass14 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(235796);
                if (VoipVideoFragment.this.HdP) {
                    VoipVideoFragment.x(VoipVideoFragment.this);
                    AppMethodBeat.o(235796);
                    return true;
                }
                AppMethodBeat.o(235796);
                return false;
            }
        }, true);
        this.HdP = true;
        this.HdO.startTimer(1000);
        AppMethodBeat.o(115449);
    }

    private void fJv() {
        AppMethodBeat.i(115450);
        this.ncd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.AnonymousClass15 */

            public final void onClick(View view) {
                boolean z = false;
                AppMethodBeat.i(235797);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11079, 4);
                if (!VoipVideoFragment.this.HdG && VoipVideoFragment.this.Hen.get() != null) {
                    VoipVideoFragment.this.Hdl.getVisibility();
                }
                boolean z2 = VoipVideoFragment.this.Hdl.getVisibility() == 0 ? true : false;
                int i2 = !z2 ? 0 : 8;
                VoipVideoFragment.this.Hdl.setVisibility(i2);
                VoipVideoFragment.this.Hdb.setVisibility(i2);
                if (ao.gJN()) {
                    VoipVideoFragment.y(VoipVideoFragment.this);
                }
                VoipVideoFragment.this.HcX.setVisibility(i2);
                VoipVideoFragment.this.Hdj.setVisibility(i2);
                VoipVideoFragment.this.Hdk.setVisibility(i2);
                VoipVideoFragment voipVideoFragment = VoipVideoFragment.this;
                if (i2 == 0) {
                    z = true;
                }
                VoipVideoFragment.d(voipVideoFragment, z);
                if (ac.jPp) {
                    VoipVideoFragment.this.Hdm.setVisibility(i2);
                    VoipVideoFragment.this.Hdn.setVisibility(i2);
                    VoipVideoFragment.this.Hdo.setVisibility(i2);
                    VoipVideoFragment.this.Hdp.setVisibility(i2);
                    VoipVideoFragment.this.Hdq.setVisibility(i2);
                    VoipVideoFragment.this.Hdr.setVisibility(i2);
                }
                if (!z2) {
                    VoipVideoFragment.q(VoipVideoFragment.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235797);
            }
        });
        AppMethodBeat.o(115450);
    }

    private void b(CaptureView captureView) {
        AppMethodBeat.i(235804);
        if (this.ncd == null || captureView == null) {
            AppMethodBeat.o(235804);
            return;
        }
        if (captureView.getParent() != null && (captureView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.qsJ.getParent()).removeView(this.qsJ);
        }
        this.ncd.removeView(this.qsJ);
        this.qsJ = null;
        if (captureView.getParent() != null) {
            ((ViewGroup) captureView.getParent()).removeAllViews();
        }
        this.qsJ = captureView;
        this.ncd.addView(captureView, new RelativeLayout.LayoutParams(1, 1));
        this.qsJ.setVisibility(0);
        this.qsJ.setAlpha(0.0f);
        Log.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
        AppMethodBeat.o(235804);
    }

    public final void fJj() {
        AppMethodBeat.i(115452);
        if (this.qsJ != null) {
            this.ncd.removeView(this.qsJ);
            this.ncd.addView(this.qsJ, new RelativeLayout.LayoutParams(1, 1));
            this.qsJ.setVisibility(0);
            this.qsJ.setAlpha(0.0f);
            Log.i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
        }
        AppMethodBeat.o(115452);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        AppMethodBeat.i(115453);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        if (this.HdO != null) {
            this.HdO.stopTimer();
        }
        this.HdP = false;
        super.onDetach();
        AppMethodBeat.o(115453);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void setVoicePlayDevice(int i2) {
    }

    private Point xl(boolean z) {
        AppMethodBeat.i(115454);
        int height = (int) (((double) getActivity().getWindowManager().getDefaultDisplay().getHeight()) / 5.0d);
        com.tencent.mm.plugin.voip.c.fFg();
        Point point = new Point((int) (((float) height) * com.tencent.mm.plugin.voip.model.u.xg(z)), height);
        AppMethodBeat.o(115454);
        return point;
    }

    public class a extends com.tencent.f.i.b {
        final /* synthetic */ VoipVideoFragment Hfw;

        public final void run() {
            AppMethodBeat.i(115419);
            Log.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
            final Bitmap bitmap = this.Hfw.BQT;
            this.Hfw.kAn.post(new Runnable() {
                /* class com.tencent.mm.plugin.voip.ui.VoipVideoFragment.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(115418);
                    if (a.this.Hfw.HeC != null) {
                        a.this.Hfw.HeC.setBackgroundDrawable(new BitmapDrawable(bitmap));
                    }
                    a.this.Hfw.Hfs = null;
                    AppMethodBeat.o(115418);
                }
            });
            AppMethodBeat.o(115419);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "VoipVideoFragment_blurBitmap";
        }
    }

    static /* synthetic */ void c(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(115455);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), 3);
        if (!(voipVideoFragment.Hen == null || voipVideoFragment.Hen.get() == null || !((c) voipVideoFragment.Hen.get()).fFu())) {
            voipVideoFragment.Hdf.setEnabled(false);
            voipVideoFragment.Hdi.setEnabled(false);
            voipVideoFragment.Hdh.setEnabled(false);
            voipVideoFragment.HcU.setText(R.string.i57);
            voipVideoFragment.HeH.a(voipVideoFragment.HcV, HeB);
        }
        AppMethodBeat.o(115455);
    }

    static /* synthetic */ void d(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(115456);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), 4);
        if (!(voipVideoFragment.Hen == null || voipVideoFragment.Hen.get() == null || !((c) voipVideoFragment.Hen.get()).fFv())) {
            voipVideoFragment.jE(R.string.i44, -1);
            voipVideoFragment.Hdh.setEnabled(false);
            voipVideoFragment.Hdi.setEnabled(false);
            voipVideoFragment.Hdf.setEnabled(false);
        }
        AppMethodBeat.o(115456);
    }

    static /* synthetic */ void e(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(115457);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), 1);
        if (!(voipVideoFragment.Hen == null || voipVideoFragment.Hen.get() == null || !((c) voipVideoFragment.Hen.get()).fFw())) {
            voipVideoFragment.Hdi.setEnabled(false);
            voipVideoFragment.Hdh.setEnabled(false);
            voipVideoFragment.Hdf.setEnabled(false);
            voipVideoFragment.Hdg.setVisibility(8);
        }
        AppMethodBeat.o(115457);
    }

    static /* synthetic */ void d(VoipVideoFragment voipVideoFragment, boolean z) {
        AppMethodBeat.i(235807);
        if (!z) {
            voipVideoFragment.getActivity().getWindow().setFlags(1024, 1024);
            AppMethodBeat.o(235807);
            return;
        }
        voipVideoFragment.getActivity().getWindow().clearFlags(1024);
        AppMethodBeat.o(235807);
    }

    static /* synthetic */ void v(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(235808);
        com.tencent.mm.plugin.voip.c.fFg().jB(voipVideoFragment.Hdz, voipVideoFragment.HdN);
        if (ac.jPp) {
            long nowSecond = Util.nowSecond();
            int i2 = (int) (nowSecond - voipVideoFragment.HdI);
            if (i2 <= 1) {
                i2 = 1;
            }
            String format = String.format(Locale.US, "Capt: %d,CPU:%d,vP:%d", Integer.valueOf(voipVideoFragment.Hdz), Integer.valueOf(voipVideoFragment.HdN), Integer.valueOf(voipVideoFragment.HdL));
            String format2 = String.format(Locale.US, "Send Fps: %d", Integer.valueOf(voipVideoFragment.Hdy));
            String format3 = String.format(Locale.US, "Recv Fps: %d", Integer.valueOf(voipVideoFragment.qvm));
            int fIc = com.tencent.mm.plugin.voip.c.fFg().fIc();
            int fId = com.tencent.mm.plugin.voip.c.fFg().fId();
            voipVideoFragment.HdA = (int) ((((double) (fIc - voipVideoFragment.HdA)) * 8.0d) / ((double) (i2 * 1000)));
            voipVideoFragment.HdB = (int) ((((double) (fId - voipVideoFragment.HdB)) * 8.0d) / ((double) (i2 * 1000)));
            int i3 = (voipVideoFragment.HdK >> 8) != 0 ? 1 : 0;
            int i4 = (voipVideoFragment.HdK & 255) != 0 ? 1 : 0;
            String format4 = String.format(Locale.US, "Tx:%d, HWEnc:%d", Integer.valueOf(voipVideoFragment.HdA), Integer.valueOf(i3));
            String format5 = String.format(Locale.US, "Rx:%d, HWDec:%d", Integer.valueOf(voipVideoFragment.HdB), Integer.valueOf(i4));
            byte[] fIe = com.tencent.mm.plugin.voip.c.fFg().fIe();
            if (fIe != null) {
                try {
                    voipVideoFragment.Hdr.setText(new String(fIe, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.Voip.VoipVideoFragment", e2, "", new Object[0]);
                }
            }
            voipVideoFragment.Hdm.setText(format);
            voipVideoFragment.Hdn.setText(format2);
            voipVideoFragment.Hdo.setText(format3);
            voipVideoFragment.Hdq.setText(format5);
            voipVideoFragment.Hdp.setText(format4);
            voipVideoFragment.HdA = fIc;
            voipVideoFragment.HdB = fId;
            voipVideoFragment.HdI = nowSecond;
        }
        voipVideoFragment.Hdz = 0;
        voipVideoFragment.Hdy = 0;
        voipVideoFragment.qvm = 0;
        AppMethodBeat.o(235808);
    }

    static /* synthetic */ void x(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(235809);
        boolean fIf = com.tencent.mm.plugin.voip.c.fFg().fIf();
        int i2 = voipVideoFragment.HdM;
        voipVideoFragment.HdM = i2 + 1;
        if (i2 % 5 == 0 && fIf) {
            int aox = ae.gKF.aox();
            Log.d("MicroMsg.Voip.VoipVideoFragment", "devincdai: cpu_usage = ".concat(String.valueOf(aox)));
            voipVideoFragment.HdN = aox;
        }
        AppMethodBeat.o(235809);
    }
}
