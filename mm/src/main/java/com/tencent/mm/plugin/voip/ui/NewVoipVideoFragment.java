package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
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
import com.tencent.mm.model.aa;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.video.NewMovableVideoView;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
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
import kotlin.g.b.p;

public class NewVoipVideoFragment extends VoipBaseFragment {
    private Bitmap BQT;
    private boolean GxH;
    private VoIPRenderSurfaceView HcN;
    private VoIPRenderSurfaceView HcO;
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
    private boolean HdC;
    private boolean HdD;
    private boolean HdE;
    private int HdF;
    private boolean HdG;
    private boolean HdH;
    public long HdI;
    private a HdJ;
    public int HdK;
    public int HdL;
    private int HdM;
    private int HdN;
    private MTimerHandler HdO;
    private boolean HdP;
    private boolean HdQ;
    private boolean HdR;
    private View.OnClickListener HdS;
    private View.OnClickListener HdT;
    private View.OnClickListener HdU;
    private View.OnClickListener HdV;
    private View.OnClickListener HdW;
    private View.OnClickListener HdX;
    private View.OnClickListener HdY;
    private View.OnClickListener HdZ;
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
    private TextView Hds;
    private TextView Hdt;
    private d Hdu = null;
    private Button Hdv = null;
    private Button Hdw = null;
    private boolean Hdx = false;
    private int Hdy;
    private int Hdz;
    private View.OnClickListener Hea;
    private View.OnClickListener Heb;
    private View.OnClickListener Hec;
    private View.OnClickListener Hed;
    private Runnable Hee;
    private PowerManager.WakeLock hCN;
    private Timer mTimer;
    private long nJh;
    private boolean qsM;
    private int qvm;
    private boolean qvo;
    private Runnable rtb;
    private TextView yzB;

    public NewVoipVideoFragment() {
        AppMethodBeat.i(235731);
        g gVar = g.HgZ;
        this.HdC = g.fKj();
        g gVar2 = g.HgZ;
        this.GxH = g.fKi();
        g gVar3 = g.HgZ;
        this.HdD = g.fKh();
        g gVar4 = g.HgZ;
        this.HdE = g.fKf();
        this.HdF = 0;
        this.HdG = false;
        this.qvo = false;
        this.qsM = false;
        this.HdI = 0;
        this.BQT = null;
        this.HdK = 0;
        this.HdL = 0;
        this.HdM = 0;
        this.nJh = 0;
        this.HdN = 0;
        this.HdO = null;
        this.HdP = false;
        this.HdQ = false;
        this.HdR = false;
        this.HdS = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(235704);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
                if (!(NewVoipVideoFragment.this.Hen == null || NewVoipVideoFragment.this.Hen.get() == null || !((c) NewVoipVideoFragment.this.Hen.get()).fFt())) {
                    NewVoipVideoFragment.this.Hdk.setEnabled(false);
                    NewVoipVideoFragment.this.Hdj.setEnabled(false);
                    NewVoipVideoFragment.this.jE(R.string.i2q, -1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235704);
            }
        };
        this.HdT = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(235716);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(NewVoipVideoFragment.this.Hen == null || NewVoipVideoFragment.this.Hen.get() == null)) {
                    ((c) NewVoipVideoFragment.this.Hen.get()).fFM();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235716);
            }
        };
        this.HdU = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(235718);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(NewVoipVideoFragment.this.Hen == null || NewVoipVideoFragment.this.Hen.get() == null)) {
                    ((c) NewVoipVideoFragment.this.Hen.get()).fFM();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235718);
            }
        };
        this.HdV = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(235721);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
                if (NetStatusUtil.isWifi(NewVoipVideoFragment.this.getActivity()) || s.fHs()) {
                    NewVoipVideoFragment.c(NewVoipVideoFragment.this);
                } else {
                    h.a(NewVoipVideoFragment.this.getActivity(), (int) R.string.i3r, (int) R.string.i3s, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass15.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(235719);
                            s.fHr();
                            NewVoipVideoFragment.c(NewVoipVideoFragment.this);
                            AppMethodBeat.o(235719);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass15.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(235720);
                            NewVoipVideoFragment.d(NewVoipVideoFragment.this);
                            AppMethodBeat.o(235720);
                        }
                    });
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235721);
            }
        };
        this.HdW = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(235724);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
                if (NetStatusUtil.isWifi(NewVoipVideoFragment.this.getActivity()) || (s.fHs() && !NetStatusUtil.is2G(NewVoipVideoFragment.this.getActivity()))) {
                    NewVoipVideoFragment.e(NewVoipVideoFragment.this);
                } else {
                    h.a(NewVoipVideoFragment.this.getActivity(), (int) R.string.i3r, (int) R.string.i3s, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass16.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(235722);
                            if (!NetStatusUtil.is2G(NewVoipVideoFragment.this.getActivity())) {
                                s.fHr();
                            }
                            NewVoipVideoFragment.e(NewVoipVideoFragment.this);
                            AppMethodBeat.o(235722);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass16.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(235723);
                            NewVoipVideoFragment.d(NewVoipVideoFragment.this);
                            AppMethodBeat.o(235723);
                        }
                    });
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235724);
            }
        };
        this.HdX = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(235725);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
                NewVoipVideoFragment.d(NewVoipVideoFragment.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235725);
            }
        };
        this.HdY = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass18 */

            public final void onClick(View view) {
                AppMethodBeat.i(235726);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
                if (!(NewVoipVideoFragment.this.Hen == null || NewVoipVideoFragment.this.Hen.get() == null || !((c) NewVoipVideoFragment.this.Hen.get()).fFA())) {
                    NewVoipVideoFragment.this.Hdk.setEnabled(false);
                    NewVoipVideoFragment.this.Hdg.setEnabled(false);
                    NewVoipVideoFragment.this.HcY.setVisibility(0);
                    NewVoipVideoFragment.this.HcY.setText(R.string.i1i);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235726);
            }
        };
        this.HdZ = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass19 */

            public final void onClick(View view) {
                AppMethodBeat.i(235727);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (System.currentTimeMillis() - NewVoipVideoFragment.this.nJh <= 1000) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(235727);
                    return;
                }
                NewVoipVideoFragment.this.nJh = System.currentTimeMillis();
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11618, 2, 1);
                if (NewVoipVideoFragment.this.HeG != null) {
                    NewVoipVideoFragment.this.HeG.aI(false, true);
                }
                if (!(NewVoipVideoFragment.this.Hen == null || NewVoipVideoFragment.this.Hen.get() == null)) {
                    ((c) NewVoipVideoFragment.this.Hen.get()).wX(true);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235727);
            }
        };
        this.Hea = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass20 */

            public final void onClick(View view) {
                AppMethodBeat.i(235728);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11619, 2);
                if (!(NewVoipVideoFragment.this.Hen == null || NewVoipVideoFragment.this.Hen.get() == null)) {
                    ((c) NewVoipVideoFragment.this.Hen.get()).fFY();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235728);
            }
        };
        this.Heb = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(235705);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                NewVoipVideoFragment.this.Hdx = !NewVoipVideoFragment.this.Hdx;
                if (!NewVoipVideoFragment.this.Hdx) {
                    NewVoipVideoFragment.this.Hdu.setVisibility(8);
                }
                Toast.makeText(NewVoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", Boolean.valueOf(NewVoipVideoFragment.this.Hdx)), 0).show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235705);
            }
        };
        this.Hec = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(235706);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                boolean nullAs = Util.nullAs((Boolean) view.getTag(), false);
                view.setTag(Boolean.valueOf(!nullAs));
                if (nullAs) {
                    NewVoipVideoFragment.this.Hdu.setVisibility(8);
                    Toast.makeText(NewVoipVideoFragment.this.getActivity(), "stop face detect", 0).show();
                } else {
                    Toast.makeText(NewVoipVideoFragment.this.getActivity(), "start face detect", 0).show();
                }
                if (!(NewVoipVideoFragment.this.Hen == null || NewVoipVideoFragment.this.Hen.get() == null)) {
                    ((c) NewVoipVideoFragment.this.Hen.get()).fFZ();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235706);
            }
        };
        this.Hed = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(235710);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
                NewVoipVideoFragment.this.Hdl.setEnabled(false);
                NewVoipVideoFragment.q(NewVoipVideoFragment.this);
                NewVoipVideoFragment.this.Hdl.setEnabled(true);
                if (!(NewVoipVideoFragment.this.Hen == null || NewVoipVideoFragment.this.Hen.get() == null)) {
                    ((c) NewVoipVideoFragment.this.Hen.get()).fFF();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235710);
            }
        };
        this.Hee = new Runnable() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(235711);
                Log.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
                NewVoipVideoFragment.r(NewVoipVideoFragment.this);
                if (NewVoipVideoFragment.this.getActivity() == null || NewVoipVideoFragment.this.getActivity().isFinishing()) {
                    AppMethodBeat.o(235711);
                } else if (NewVoipVideoFragment.this.HdF > 0) {
                    AppMethodBeat.o(235711);
                } else {
                    NewVoipVideoFragment.this.Hdl.setVisibility(8);
                    NewVoipVideoFragment.this.Hdb.setVisibility(8);
                    NewVoipVideoFragment.this.HcX.setVisibility(8);
                    NewVoipVideoFragment.this.Hdk.setVisibility(8);
                    NewVoipVideoFragment.this.Hdj.setVisibility(8);
                    NewVoipVideoFragment.this.Hdc.setVisibility(8);
                    NewVoipVideoFragment.d(NewVoipVideoFragment.this, false);
                    AppMethodBeat.o(235711);
                }
            }
        };
        this.rtb = new Runnable() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(235712);
                if (NewVoipVideoFragment.this.getActivity() == null || NewVoipVideoFragment.this.getActivity().isFinishing()) {
                    AppMethodBeat.o(235712);
                    return;
                }
                NewVoipVideoFragment.this.HcY.setVisibility(8);
                AppMethodBeat.o(235712);
            }
        };
        AppMethodBeat.o(235731);
    }

    static /* synthetic */ Point c(NewVoipVideoFragment newVoipVideoFragment, boolean z) {
        AppMethodBeat.i(235757);
        Point xl = newVoipVideoFragment.xl(z);
        AppMethodBeat.o(235757);
        return xl;
    }

    static /* synthetic */ void q(NewVoipVideoFragment newVoipVideoFragment) {
        AppMethodBeat.i(235758);
        newVoipVideoFragment.fJp();
        AppMethodBeat.o(235758);
    }

    static /* synthetic */ int r(NewVoipVideoFragment newVoipVideoFragment) {
        int i2 = newVoipVideoFragment.HdF;
        newVoipVideoFragment.HdF = i2 - 1;
        return i2;
    }

    static /* synthetic */ void y(NewVoipVideoFragment newVoipVideoFragment) {
        AppMethodBeat.i(235762);
        newVoipVideoFragment.fJo();
        AppMethodBeat.o(235762);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(235732);
        this.ncd = (RelativeLayout) layoutInflater.inflate(R.layout.c74, viewGroup, false);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) this.ncd.findViewById(R.id.h7x)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(getActivity(), 40.0f));
        }
        this.HeC = (ImageView) this.ncd.findViewById(R.id.jao);
        this.HeD = (ImageView) this.ncd.findViewById(R.id.jbn);
        this.Hda = (RelativeLayout) this.ncd.findViewById(R.id.eo6);
        this.HcN = (VoIPRenderSurfaceView) this.ncd.findViewById(R.id.a3j);
        this.HcN.jI(mScreenWidth, mScreenHeight);
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
            this.Hds = (TextView) this.ncd.findViewById(R.id.dkt);
            this.Hdt = (TextView) this.ncd.findViewById(R.id.ai2);
        }
        this.Hdv = (Button) this.ncd.findViewById(R.id.jb4);
        this.Hdw = (Button) this.ncd.findViewById(R.id.jb5);
        this.Hdv.setVisibility(8);
        this.Hdw.setVisibility(8);
        this.Hdv.setOnClickListener(this.Heb);
        this.Hdw.setOnClickListener(this.Hec);
        this.Hdu = new d(getActivity());
        this.ncd.addView(this.Hdu);
        this.Hdu.setVisibility(8);
        this.Hdb.setOnClickListener(this.HdZ);
        if (ao.gJN()) {
            fJo();
        }
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
        this.HcO = new NewMovableVideoView(MMApplicationContext.getContext());
        ((NewMovableVideoView) this.HcO).jF(width, height);
        this.HcO.setVisibility(4);
        this.HcN.setVisibility(0);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
        this.ncd.addView(this.HcO);
        this.HcO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass5 */
            long Heg = 0;

            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(235708);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
                this.Heg = Util.currentTicks();
                NewVoipVideoFragment.this.HdG = !NewVoipVideoFragment.this.HdG;
                ((c) NewVoipVideoFragment.this.Hen.get()).fFH();
                com.tencent.mm.plugin.voip.b.h.xs(true);
                NewVoipVideoFragment newVoipVideoFragment = NewVoipVideoFragment.this;
                if (!NewVoipVideoFragment.this.HdG) {
                    z = true;
                } else {
                    z = false;
                }
                Point c2 = NewVoipVideoFragment.c(newVoipVideoFragment, z);
                if (NewVoipVideoFragment.this.HcO != null) {
                    NewVoipVideoFragment.this.HcO.jH(c2.x, c2.y);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11079, 3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235708);
            }
        });
        as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.goe);
        this.HcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getActivity(), aa.b(Kn, this.goe), this.HcS.getTextSize()));
        String O = com.tencent.mm.openim.room.a.a.O(Kn);
        if (!Util.isNullOrNil(O)) {
            this.HcT.setText(O);
        }
        if (this.GUf) {
            this.kAn.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(235709);
                    NewVoipVideoFragment.this.HcU.setText(R.string.i34);
                    NewVoipVideoFragment.this.HeH.a(NewVoipVideoFragment.this.HcV, VoipBaseFragment.HeB);
                    AppMethodBeat.o(235709);
                }
            }, 2000);
        }
        this.mTimer = new Timer("VoIP_video_talking_count");
        Log.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", Integer.valueOf(this.HdL));
        this.qsM = true;
        if (!(this.Hen == null || this.Hen.get() == null)) {
            ((c) this.Hen.get()).fFI();
        }
        jD(0, this.mStatus);
        this.hCN = ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipVideoFragment");
        this.hCN.acquire();
        Log.i("MicroMsg.Voip.VoipVideoFragment", "acquire wakelock");
        RelativeLayout relativeLayout = this.ncd;
        AppMethodBeat.o(235732);
        return relativeLayout;
    }

    private void fJo() {
        AppMethodBeat.i(235733);
        if (this.Hdc == null) {
            AppMethodBeat.o(235733);
            return;
        }
        aw.kA(getActivity());
        if (aw.a(aw.gWy(), getActivity().getTaskId()) == -1) {
            this.Hdc.setVisibility(8);
        } else {
            this.Hdc.setVisibility(0);
        }
        this.Hdc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(235707);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (aw.a(aw.gWy(), NewVoipVideoFragment.this.getActivity().getTaskId()) == 2) {
                    aw.a(aw.gWy(), NewVoipVideoFragment.this.getActivity().getTaskId(), 0);
                    NewVoipVideoFragment.this.Hdc.setBackgroundResource(R.raw.icons_outlined_sperated);
                } else {
                    aw.a(aw.gWy(), NewVoipVideoFragment.this.getActivity().getTaskId(), 2);
                    NewVoipVideoFragment.this.Hdc.setBackgroundResource(R.raw.icons_outlined_merge);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235707);
            }
        });
        AppMethodBeat.o(235733);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        AppMethodBeat.i(235734);
        this.qvo = false;
        Log.i("MicroMsg.Voip.VoipVideoFragment", "onDestory");
        super.onDestroy();
        if (this.hCN != null && this.hCN.isHeld()) {
            Log.i("MicroMsg.Voip.VoipVideoFragment", "release waklock");
            this.hCN.release();
        }
        AppMethodBeat.o(235734);
    }

    private void fJp() {
        AppMethodBeat.i(235735);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
        this.HdF++;
        this.kAn.postDelayed(this.Hee, 10000);
        AppMethodBeat.o(235735);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void jD(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(235736);
        super.jD(i2, i3);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + k.adM(i3));
        if (this.ncd == null) {
            Log.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
            AppMethodBeat.o(235736);
            return;
        }
        switch (i3) {
            case 0:
            case 2:
                this.HdQ = true;
                xj(true);
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
                if (this.HdQ) {
                    ((c) this.Hen.get()).fFH();
                    com.tencent.mm.plugin.voip.b.h.xs(false);
                    this.HdQ = false;
                } else {
                    xj(false);
                }
                fJt();
                z = true;
                break;
            case 8:
            case 262:
                adA(i2);
                z = true;
                break;
            case 256:
                this.HdQ = true;
                xj(true);
                fJr();
                z = false;
                break;
            default:
                z = true;
                break;
        }
        if (ae.gKt.gFB == 1 && z) {
            this.HcP.setVisibility(8);
        }
        AppMethodBeat.o(235736);
    }

    private void xj(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(235737);
        if (!this.HdR) {
            if (z) {
                ((c) this.Hen.get()).a(this.HcO, 1);
                ((c) this.Hen.get()).a(this.HcN, 0);
            } else {
                ((c) this.Hen.get()).a(this.HcO, 0);
                ((c) this.Hen.get()).a(this.HcN, 1);
            }
            c cVar = (c) this.Hen.get();
            if (!(260 == this.mStatus || 6 == this.mStatus)) {
                z2 = true;
            }
            cVar.aE(true, z2);
            this.HdR = true;
        }
        AppMethodBeat.o(235737);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void uninit() {
        AppMethodBeat.i(235738);
        Log.printInfoStack("MicroMsg.Voip.VoipVideoFragment", "unit should not be allow in foreground", new Object[0]);
        if (!(this.HcN == null || this.Hen == null || this.Hen.get() == null)) {
            this.HcN.release();
        }
        if (!(this.Hen == null || this.Hen.get() == null)) {
            ((c) this.Hen.get()).a(this.HcN);
            ((c) this.Hen.get()).a(this.HcO);
        }
        if (this.HcO != null) {
            this.HcO.release();
            this.HcO.setVisibility(4);
            this.HcO = null;
        }
        if (this.HdJ != null) {
            this.HdJ.cancel();
            this.HdJ = null;
        }
        super.uninit();
        AppMethodBeat.o(235738);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        AppMethodBeat.i(235739);
        super.onDestroyView();
        if (this.HcN != null) {
            this.HcN.setVisibility(8);
            this.HcN = null;
        }
        AppMethodBeat.o(235739);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void setMute(boolean z) {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void aUB(String str) {
        AppMethodBeat.i(235740);
        if (this.HcZ != null) {
            this.HcZ.setVisibility(0);
            this.HcZ.setText(str);
        }
        AppMethodBeat.o(235740);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void jE(int i2, int i3) {
        AppMethodBeat.i(235741);
        if (this.HcY == null) {
            AppMethodBeat.o(235741);
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
        AppMethodBeat.o(235741);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void xk(boolean z) {
        AppMethodBeat.i(235742);
        if (this.yzB != null) {
            if (z) {
                this.yzB.setText(R.string.i3l);
            } else {
                this.yzB.setText(R.string.i3k);
            }
            this.yzB.clearAnimation();
            this.yzB.setVisibility(0);
        }
        AppMethodBeat.o(235742);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void fJq() {
        AppMethodBeat.i(235743);
        if (this.yzB != null) {
            this.yzB.clearAnimation();
            this.yzB.setVisibility(8);
        }
        AppMethodBeat.o(235743);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void m(Point point) {
        RelativeLayout.LayoutParams layoutParams;
        AppMethodBeat.i(235744);
        VoIPRenderSurfaceView voIPRenderSurfaceView = this.HcN;
        p.h(point, "screenSize");
        Log.i("RenderView", "new size from resource Helper w %s * h  %s", Integer.valueOf(com.tencent.mm.cb.a.jn(voIPRenderSurfaceView.getContext())), Integer.valueOf(com.tencent.mm.cb.a.jo(voIPRenderSurfaceView.getContext())));
        int i2 = point.x;
        int i3 = point.y;
        if (ao.gJI()) {
            layoutParams = new RelativeLayout.LayoutParams((i3 * 9) / 16, i3);
            layoutParams.addRule(13);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        voIPRenderSurfaceView.setLayoutParams(layoutParams);
        voIPRenderSurfaceView.requestLayout();
        if (this.HcO != null) {
            NewMovableVideoView newMovableVideoView = (NewMovableVideoView) this.HcO;
            Log.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", Integer.valueOf(newMovableVideoView.mWidth), Integer.valueOf(newMovableVideoView.HhR));
            newMovableVideoView.mScreenWidth = 0;
            newMovableVideoView.jF(newMovableVideoView.mWidth, newMovableVideoView.HhR);
        }
        AppMethodBeat.o(235744);
    }

    private void fJr() {
        AppMethodBeat.i(235745);
        this.HcN.setVisibility(0);
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
            this.HcN.setVisibility(4);
        }
        AppMethodBeat.o(235745);
    }

    private void fJs() {
        AppMethodBeat.i(235746);
        this.HcW.setVisibility(0);
        this.HcN.setVisibility(0);
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
        AppMethodBeat.o(235746);
    }

    private void fJt() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(235747);
        if (this.HeD != null) {
            this.HeD.setVisibility(8);
        }
        if (this.HcO == null) {
            AppMethodBeat.o(235747);
        } else if (this.HcO.getVisibility() == 0) {
            AppMethodBeat.o(235747);
        } else {
            if (this.GUf) {
                this.HdG = !this.HdG;
                if (!this.HdG) {
                    z = true;
                } else {
                    z = false;
                }
                Point xl = xl(z);
                this.HcO.jH(xl.x, xl.y);
            } else {
                this.HdG = !this.HdG;
            }
            if (ac.jPp) {
                this.Hdm.setVisibility(0);
                this.Hdn.setVisibility(0);
                this.Hdo.setVisibility(0);
                this.Hdp.setVisibility(0);
                this.Hdq.setVisibility(0);
                this.Hdr.setVisibility(0);
                this.Hds.setVisibility(0);
                this.Hdt.setVisibility(0);
            }
            this.HcQ.setVisibility(8);
            this.HcN.setVisibility(0);
            this.HcO.setVisibility(0);
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
            ((c) this.Hen.get()).wV(this.HdG);
            Log.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", Integer.valueOf(this.HdK));
            if (this.HdG) {
                z2 = false;
            }
            Point xl2 = xl(z2);
            ((NewMovableVideoView) this.HcO).jF(xl2.x, xl2.y);
            bpu();
            if (MMApplicationContext.getDefaultPreference().getBoolean("voipfaceDebug", false)) {
                this.Hdv.setVisibility(0);
                this.Hdw.setVisibility(0);
            }
            fJp();
            if (this.HeE == 4102) {
                jE(R.string.i0p, 10000);
            }
            AppMethodBeat.o(235747);
        }
    }

    private void fJu() {
        AppMethodBeat.i(235748);
        this.HcU.setText(R.string.i57);
        this.HeH.a(this.HcV, HeB);
        AppMethodBeat.o(235748);
    }

    private void adA(int i2) {
        AppMethodBeat.i(235749);
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
        AppMethodBeat.o(235749);
    }

    private void bpu() {
        AppMethodBeat.i(235750);
        if (this.mTimer == null || this.qvo) {
            AppMethodBeat.o(235750);
            return;
        }
        if (-1 == this.Heo) {
            this.Heo = Util.nowSecond();
        }
        this.HdI = this.Heo;
        this.qvo = true;
        this.mTimer.schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(235714);
                NewVoipVideoFragment.this.kAn.post(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass10.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(235713);
                        NewVoipVideoFragment.this.HcX.setText(NewVoipVideoFragment.AF(Util.secondsToNow(NewVoipVideoFragment.this.Heo)));
                        NewVoipVideoFragment.v(NewVoipVideoFragment.this);
                        AppMethodBeat.o(235713);
                    }
                });
                AppMethodBeat.o(235714);
            }
        }, 1000, 1000);
        this.HdO = new MTimerHandler("VoipVideoFragment_cpuStatThread", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass11 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(235715);
                if (NewVoipVideoFragment.this.HdP) {
                    NewVoipVideoFragment.x(NewVoipVideoFragment.this);
                    AppMethodBeat.o(235715);
                    return true;
                }
                AppMethodBeat.o(235715);
                return false;
            }
        }, true);
        this.HdP = true;
        this.HdO.startTimer(1000);
        AppMethodBeat.o(235750);
    }

    private void fJv() {
        AppMethodBeat.i(235751);
        this.ncd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.AnonymousClass13 */

            public final void onClick(View view) {
                boolean z = false;
                AppMethodBeat.i(235717);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11079, 4);
                if (!NewVoipVideoFragment.this.HdG && NewVoipVideoFragment.this.Hen.get() != null) {
                    NewVoipVideoFragment.this.Hdl.getVisibility();
                }
                boolean z2 = NewVoipVideoFragment.this.Hdl.getVisibility() == 0 ? true : false;
                int i2 = !z2 ? 0 : 8;
                NewVoipVideoFragment.this.Hdl.setVisibility(i2);
                NewVoipVideoFragment.this.Hdb.setVisibility(i2);
                if (ao.gJN()) {
                    NewVoipVideoFragment.y(NewVoipVideoFragment.this);
                }
                NewVoipVideoFragment.this.HcX.setVisibility(i2);
                NewVoipVideoFragment.this.Hdj.setVisibility(i2);
                NewVoipVideoFragment.this.Hdk.setVisibility(i2);
                NewVoipVideoFragment newVoipVideoFragment = NewVoipVideoFragment.this;
                if (i2 == 0) {
                    z = true;
                }
                NewVoipVideoFragment.d(newVoipVideoFragment, z);
                if (ac.jPp) {
                    NewVoipVideoFragment.this.Hdm.setVisibility(i2);
                    NewVoipVideoFragment.this.Hdn.setVisibility(i2);
                    NewVoipVideoFragment.this.Hdo.setVisibility(i2);
                    NewVoipVideoFragment.this.Hdp.setVisibility(i2);
                    NewVoipVideoFragment.this.Hdq.setVisibility(i2);
                    NewVoipVideoFragment.this.Hdr.setVisibility(i2);
                    NewVoipVideoFragment.this.Hds.setVisibility(i2);
                }
                if (!z2) {
                    NewVoipVideoFragment.q(NewVoipVideoFragment.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235717);
            }
        });
        AppMethodBeat.o(235751);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        AppMethodBeat.i(235752);
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
        AppMethodBeat.o(235752);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void setVoicePlayDevice(int i2) {
    }

    private Point xl(boolean z) {
        AppMethodBeat.i(235753);
        int height = (int) (((double) getActivity().getWindowManager().getDefaultDisplay().getHeight()) / 5.0d);
        com.tencent.mm.plugin.voip.c.fFg();
        Point point = new Point((int) (((float) height) * com.tencent.mm.plugin.voip.model.u.xg(z)), height);
        AppMethodBeat.o(235753);
        return point;
    }

    public class a extends com.tencent.f.i.b {
        final /* synthetic */ NewVoipVideoFragment Hef;

        public final void run() {
            AppMethodBeat.i(235730);
            Log.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
            final Bitmap bitmap = this.Hef.BQT;
            this.Hef.kAn.post(new Runnable() {
                /* class com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(235729);
                    if (a.this.Hef.HeC != null) {
                        a.this.Hef.HeC.setBackgroundDrawable(new BitmapDrawable(bitmap));
                    }
                    a.this.Hef.HdJ = null;
                    AppMethodBeat.o(235729);
                }
            });
            AppMethodBeat.o(235730);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "MicroMsg.Voip.VoipVideoFragment#ShowBlurBackgroundRunnable";
        }
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void fJm() {
        this.qvm++;
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void adx(int i2) {
        this.Hdz++;
        if (i2 > 0) {
            this.Hdy++;
        }
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void ady(int i2) {
        this.HdK = i2;
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment
    public final void adz(int i2) {
        this.HdL = i2;
    }

    static /* synthetic */ void c(NewVoipVideoFragment newVoipVideoFragment) {
        AppMethodBeat.i(235754);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), 3);
        if (!(newVoipVideoFragment.Hen == null || newVoipVideoFragment.Hen.get() == null || !((c) newVoipVideoFragment.Hen.get()).fFu())) {
            newVoipVideoFragment.Hdf.setEnabled(false);
            newVoipVideoFragment.Hdi.setEnabled(false);
            newVoipVideoFragment.Hdh.setEnabled(false);
            newVoipVideoFragment.HcU.setText(R.string.i57);
            newVoipVideoFragment.HeH.a(newVoipVideoFragment.HcV, HeB);
        }
        AppMethodBeat.o(235754);
    }

    static /* synthetic */ void d(NewVoipVideoFragment newVoipVideoFragment) {
        AppMethodBeat.i(235755);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), 4);
        if (!(newVoipVideoFragment.Hen == null || newVoipVideoFragment.Hen.get() == null || !((c) newVoipVideoFragment.Hen.get()).fFv())) {
            newVoipVideoFragment.jE(R.string.i44, -1);
            newVoipVideoFragment.Hdh.setEnabled(false);
            newVoipVideoFragment.Hdi.setEnabled(false);
            newVoipVideoFragment.Hdf.setEnabled(false);
        }
        AppMethodBeat.o(235755);
    }

    static /* synthetic */ void e(NewVoipVideoFragment newVoipVideoFragment) {
        AppMethodBeat.i(235756);
        Log.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), 1);
        if (!(newVoipVideoFragment.Hen == null || newVoipVideoFragment.Hen.get() == null || !((c) newVoipVideoFragment.Hen.get()).fFw())) {
            newVoipVideoFragment.Hdi.setEnabled(false);
            newVoipVideoFragment.Hdh.setEnabled(false);
            newVoipVideoFragment.Hdf.setEnabled(false);
            newVoipVideoFragment.Hdg.setVisibility(8);
        }
        AppMethodBeat.o(235756);
    }

    static /* synthetic */ void d(NewVoipVideoFragment newVoipVideoFragment, boolean z) {
        AppMethodBeat.i(235759);
        if (!z) {
            newVoipVideoFragment.getActivity().getWindow().setFlags(1024, 1024);
            AppMethodBeat.o(235759);
            return;
        }
        newVoipVideoFragment.getActivity().getWindow().clearFlags(1024);
        AppMethodBeat.o(235759);
    }

    static /* synthetic */ void v(NewVoipVideoFragment newVoipVideoFragment) {
        AppMethodBeat.i(235760);
        com.tencent.mm.plugin.voip.c.fFg().jB(newVoipVideoFragment.Hdz, newVoipVideoFragment.HdN);
        if (ac.jPp) {
            long nowSecond = Util.nowSecond();
            int i2 = (int) (nowSecond - newVoipVideoFragment.HdI);
            if (i2 <= 1) {
                i2 = 1;
            }
            String format = String.format(Locale.US, "Capt: %d,CPU:%d,vP:%d", Integer.valueOf(newVoipVideoFragment.Hdz), Integer.valueOf(newVoipVideoFragment.HdN), Integer.valueOf(newVoipVideoFragment.HdL));
            String format2 = String.format(Locale.US, "Send Fps: %d", Integer.valueOf(newVoipVideoFragment.Hdy));
            String format3 = String.format(Locale.US, "Recv Fps: %d", Integer.valueOf(newVoipVideoFragment.qvm));
            int fIc = com.tencent.mm.plugin.voip.c.fFg().fIc();
            int fId = com.tencent.mm.plugin.voip.c.fFg().fId();
            newVoipVideoFragment.HdA = (int) ((((double) (fIc - newVoipVideoFragment.HdA)) * 8.0d) / ((double) (i2 * 1000)));
            newVoipVideoFragment.HdB = (int) ((((double) (fId - newVoipVideoFragment.HdB)) * 8.0d) / ((double) (i2 * 1000)));
            int i3 = (newVoipVideoFragment.HdK >> 8) != 0 ? 1 : 0;
            int i4 = (newVoipVideoFragment.HdK & 255) != 0 ? 1 : 0;
            String format4 = String.format(Locale.US, "Tx:%d, HWEnc:%d", Integer.valueOf(newVoipVideoFragment.HdA), Integer.valueOf(i3));
            String format5 = String.format(Locale.US, "Rx:%d, HWDec:%d", Integer.valueOf(newVoipVideoFragment.HdB), Integer.valueOf(i4));
            byte[] fIe = com.tencent.mm.plugin.voip.c.fFg().fIe();
            if (fIe != null) {
                try {
                    newVoipVideoFragment.Hdr.setText(new String(fIe, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.Voip.VoipVideoFragment", e2, "", new Object[0]);
                }
            }
            if (newVoipVideoFragment.GxH) {
                if (newVoipVideoFragment.HdC) {
                    newVoipVideoFragment.Hds.setText("gpu crop");
                } else {
                    newVoipVideoFragment.Hds.setText("gpu rgb2yuv");
                }
            }
            if (!newVoipVideoFragment.HdD || newVoipVideoFragment.Hdt == null) {
                newVoipVideoFragment.Hdt.setText("prev CameraModular");
            } else if (newVoipVideoFragment.HdE) {
                newVoipVideoFragment.Hdt.setText("new CameraModular + Camera2");
            } else {
                newVoipVideoFragment.Hdt.setText("new CameraModular + Camera1");
            }
            newVoipVideoFragment.Hdm.setText(format);
            newVoipVideoFragment.Hdn.setText(format2);
            newVoipVideoFragment.Hdo.setText(format3);
            newVoipVideoFragment.Hdq.setText(format5);
            newVoipVideoFragment.Hdp.setText(format4);
            newVoipVideoFragment.HdA = fIc;
            newVoipVideoFragment.HdB = fId;
            newVoipVideoFragment.HdI = nowSecond;
        }
        newVoipVideoFragment.Hdz = 0;
        newVoipVideoFragment.Hdy = 0;
        newVoipVideoFragment.qvm = 0;
        AppMethodBeat.o(235760);
    }

    static /* synthetic */ void x(NewVoipVideoFragment newVoipVideoFragment) {
        AppMethodBeat.i(235761);
        boolean fIf = com.tencent.mm.plugin.voip.c.fFg().fIf();
        int i2 = newVoipVideoFragment.HdM;
        newVoipVideoFragment.HdM = i2 + 1;
        if (i2 % 5 == 0 && fIf) {
            int aox = ae.gKF.aox();
            Log.d("MicroMsg.Voip.VoipVideoFragment", "devincdai: cpu_usage = ".concat(String.valueOf(aox)));
            newVoipVideoFragment.HdN = aox;
        }
        AppMethodBeat.o(235761);
    }
}
