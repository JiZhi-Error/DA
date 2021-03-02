package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.u;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.as;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.multitask.b.b;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.d;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.adapter.NoteLinearLayoutManager;
import com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.mm.vfs.s;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;

public class NoteEditorUI extends BaseFavDetailReportUI implements i, com.tencent.mm.plugin.wenote.model.nativenote.b.a, g.a, a {
    boolean JGV = false;
    boolean JHk = false;
    private int JIH;
    private TextView JJA = null;
    private boolean JJB = false;
    boolean JJC = false;
    private boolean JJD = false;
    private String JJE = "";
    private NoteLinearLayoutManager JJF;
    private boolean JJG = false;
    private a JJH;
    private boolean JJI = false;
    private final Object JJJ = new Object();
    private String JJK = "";
    private int JJL = 0;
    private int JJM = 0;
    private String[] JJN = null;
    private boolean JJO = true;
    private long JJP = 0;
    private boolean JJQ = false;
    private String JJR;
    boolean JJS = false;
    private boolean JJT = false;
    private boolean JJU = false;
    private com.tencent.mm.plugin.wenote.multitask.a JJV;
    private boolean JJW = false;
    private boolean JJX = false;
    private boolean JJY = false;
    ViewTreeObserver.OnGlobalLayoutListener JJZ = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass37 */

        public final void onGlobalLayout() {
            AppMethodBeat.i(30740);
            Log.i("MicroMsg.Note.NoteEditorUI", "mOnGlobalLayoutComplaintListener scrollRange:" + NoteEditorUI.this.mRecyclerView.computeVerticalScrollRange());
            if (NoteEditorUI.this.JJA != null) {
                if (NoteEditorUI.this.mRecyclerView.computeVerticalScrollRange() + NoteEditorUI.this.JJA.getMeasuredHeight() > NoteEditorUI.this.mRecyclerView.getMeasuredHeight()) {
                    NoteEditorUI.this.JJv.JKL = true;
                    NoteEditorUI.this.JJv.atj.notifyChanged();
                    NoteEditorUI.this.JJA.setVisibility(8);
                    NoteEditorUI.this.mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(NoteEditorUI.this.JJZ);
                    AppMethodBeat.o(30740);
                    return;
                }
                NoteEditorUI.this.JJA.setVisibility(0);
            }
            AppMethodBeat.o(30740);
        }
    };
    k JJu;
    private b JJv;
    private LinearLayout JJw;
    private c JJx = null;
    private RelativeLayout JJy = null;
    private g JJz = null;
    private boolean JKa = false;
    private IListener<gy> JKb = new IListener<gy>() {
        /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass34 */

        {
            AppMethodBeat.i(179747);
            this.__eventId = gy.class.getName().hashCode();
            AppMethodBeat.o(179747);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gy gyVar) {
            AppMethodBeat.i(179749);
            boolean gkj = gkj();
            AppMethodBeat.o(179749);
            return gkj;
        }

        private boolean gkj() {
            AppMethodBeat.i(179748);
            Log.i("MicroMsg.Note.NoteEditorUI", "FavNoteSaveEvent, isFinish:%s", Boolean.valueOf(NoteEditorUI.this.iGD));
            NoteEditorUI.this.goBack();
            if (!NoteEditorUI.this.iGD) {
                NoteEditorUI.this.finish();
            }
            AppMethodBeat.o(179748);
            return true;
        }
    };
    private com.tencent.mm.plugin.wenote.b.a VhW;
    private int afB = 0;
    ViewTreeObserver.OnGlobalLayoutListener ajG = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass36 */

        public final void onGlobalLayout() {
            long j2;
            AppMethodBeat.i(30739);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - NoteEditorUI.this.JJP));
            MMHandlerThread aAk = bg.aAk();
            AnonymousClass1 r3 = new Runnable() {
                /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass36.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(30738);
                    NoteEditorUI.this.zD(false);
                    AppMethodBeat.o(30738);
                }
            };
            if (NoteEditorUI.this.JIH == 1) {
                j2 = 100;
            } else {
                j2 = 0;
            }
            aAk.postToWorkerDelayed(r3, j2);
            NoteEditorUI.this.mRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.ajG);
            AppMethodBeat.o(30739);
        }
    };
    private ProgressDialog gtM = null;
    private MMHandler hAk;
    private boolean iGD = false;
    private float liD = 0.0f;
    private float liE = 0.0f;
    long localId = -1;
    private View mContentView = null;
    private int mLastOffset = 0;
    private RecyclerView mRecyclerView;
    private long msgId = -1;
    private LinearLayout qND = null;
    private boolean qNH = true;
    private int qNI = 0;
    private RecyclerView.l qNJ = null;
    private boolean qNK = false;
    private boolean qNO = false;
    private int qNP = -1;
    private boolean qNQ = false;
    private aml qNR;
    View.OnTouchListener qNS = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass3 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(30691);
            if (motionEvent.getAction() == 0) {
                NoteEditorUI.this.liD = motionEvent.getX();
                NoteEditorUI.this.liE = motionEvent.getY();
            }
            if (motionEvent.getAction() == 1 && NoteEditorUI.this.mRecyclerView.o(motionEvent.getX(), motionEvent.getY()) == null) {
                float abs = Math.abs(NoteEditorUI.this.liD - motionEvent.getX());
                float abs2 = Math.abs(NoteEditorUI.this.liE - motionEvent.getY());
                if (abs < 30.0f && abs2 < 30.0f) {
                    if (NoteEditorUI.this.JJy.getVisibility() != 8) {
                        if (NoteEditorUI.this.JJz != null) {
                            NoteEditorUI.this.JJz.qQv.dismiss();
                        }
                        NoteEditorUI.this.JJy.setVisibility(8);
                    } else {
                        int size = c.gjL().size();
                        com.tencent.mm.plugin.wenote.model.a.c ahp = c.gjL().ahp(size - 1);
                        if (ahp != null) {
                            boolean z = ahp.qPA;
                            c.gjL().cDr();
                            ahp.qPA = true;
                            ahp.qPG = false;
                            ahp.qPC = -1;
                            NoteEditorUI.this.JJv.ci(size - 1);
                            NoteEditorUI.this.e(true, 50);
                            NoteEditorUI.this.Q(1, 0);
                            if (NoteEditorUI.M(NoteEditorUI.this) && z) {
                                NoteEditorUI.this.hAk.postDelayed(new Runnable() {
                                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass3.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(30690);
                                        e.gjW().ln(true);
                                        e.gjW().lm(true);
                                        AppMethodBeat.o(30690);
                                    }
                                }, 100);
                            }
                        }
                    }
                }
            } else if (motionEvent.getAction() == 2) {
                float abs3 = Math.abs(NoteEditorUI.this.liD - motionEvent.getX());
                float abs4 = Math.abs(NoteEditorUI.this.liE - motionEvent.getY());
                if (abs3 > 120.0f || abs4 > 120.0f) {
                    if (NoteEditorUI.M(NoteEditorUI.this)) {
                        if (e.gjW().getSelectType() == 1) {
                            NoteEditorUI.this.cCD();
                            e.gjW().cDY();
                        }
                    } else if (!NoteEditorUI.this.qNK) {
                        NoteEditorUI.this.cCD();
                    }
                }
            }
            AppMethodBeat.o(30691);
            return false;
        }
    };
    private q rGN = null;
    private String rzs = "";
    private String sUB;
    protected a.b xxK = new a.b() {
        /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass18 */

        @Override // com.tencent.mm.ui.widget.snackbar.a.b
        public final void bDZ() {
            AppMethodBeat.i(30709);
            hb hbVar = new hb();
            hbVar.dLm.type = 35;
            EventCenter.instance.publish(hbVar);
            AppMethodBeat.o(30709);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NoteEditorUI() {
        AppMethodBeat.i(30749);
        AppMethodBeat.o(30749);
    }

    static /* synthetic */ boolean M(NoteEditorUI noteEditorUI) {
        AppMethodBeat.i(169775);
        boolean z = noteEditorUI.qNH;
        AppMethodBeat.o(169775);
        return z;
    }

    static /* synthetic */ boolean N(NoteEditorUI noteEditorUI) {
        AppMethodBeat.i(184903);
        boolean cCP = noteEditorUI.cCP();
        AppMethodBeat.o(184903);
        return cCP;
    }

    static /* synthetic */ void O(NoteEditorUI noteEditorUI) {
        AppMethodBeat.i(232136);
        noteEditorUI.gki();
        AppMethodBeat.o(232136);
    }

    static /* synthetic */ void h(NoteEditorUI noteEditorUI) {
        AppMethodBeat.i(30805);
        noteEditorUI.cLD();
        AppMethodBeat.o(30805);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30750);
        Log.i("MicroMsg.Note.NoteEditorUI", "onCreate %s", Integer.valueOf(hashCode()));
        customfixStatusbar(true);
        this.JIH = getIntent().getIntExtra("note_open_from_scene", 2);
        this.msgId = getIntent().getLongExtra("note_msgid", -1);
        this.JJT = getIntent().getBooleanExtra("record_show_share", false);
        this.localId = getIntent().getLongExtra("note_fav_localid", -1);
        this.rzs = getIntent().getStringExtra("note_link_sns_localid");
        this.JGV = getIntent().getBooleanExtra("edit_status", false);
        this.JHk = getIntent().getBooleanExtra("need_save", false);
        this.JJC = this.JHk;
        this.JJK = getIntent().getStringExtra("fav_note_xml");
        this.JJL = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
        this.JJM = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
        this.sUB = getIntent().getStringExtra("fav_note_thumbpath");
        this.JJO = getIntent().getBooleanExtra("show_share", true);
        this.JJR = getIntent().getStringExtra("fav_note_link_sns_xml");
        String stringExtra = getIntent().getStringExtra("fav_note_link_source_info");
        this.JJU = getIntent().getBooleanExtra("fav_note_out_of_date", false);
        if (!Util.isNullOrNil(stringExtra)) {
            this.JJN = stringExtra.split(";");
        }
        if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
            this.JJQ = true;
        }
        d.JGX = false;
        if (this.JJN == null && this.localId > 0) {
            hb hbVar = new hb();
            hbVar.dLm.type = 30;
            hbVar.dLm.dLt = 3;
            hbVar.dLm.dFW = this.localId;
            EventCenter.instance.publish(hbVar);
            this.JJN = Util.isNullOrNil(hbVar.dLn.path) ? null : hbVar.dLn.path.split(";");
        }
        if (this.JJN == null || this.JJN.length >= 3) {
            this.hAk = new MMHandler();
            c gjL = c.gjL();
            gjL.mDataList = new ArrayList<>();
            gjL.JId = this;
            gjL.qQq = new aml();
            gjL.qQr = 0;
            gjL.qQs = 0;
            gjL.qQt = 0;
            Log.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
            h.q(this);
            super.onCreate(bundle);
            this.mContentView = getContentView();
            if (!(this.JJW || com.tencent.mm.plugin.wenote.model.c.gjz().JGL == null || com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGY == null)) {
                this.VhW = new com.tencent.mm.plugin.wenote.b.a(this, new com.tencent.mm.plugin.wenote.b.b(this));
                if (Util.isNullOrNil(this.rzs)) {
                    this.VhW.G(3, this.localId + "_" + this.msgId);
                } else {
                    this.VhW.G(3, "fav_" + this.rzs);
                }
                com.tencent.mm.plugin.wenote.b.a aVar = this.VhW;
                aVar.ciw().dPJ = new StringBuilder().append(this.localId).toString();
                aVar.cit();
                this.VhW.eU("eventData", com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGY);
                com.tencent.mm.plugin.wenote.b.a aVar2 = this.VhW;
                int i2 = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGZ;
                if (aVar2.oWE != null && (!aVar2.oWE.hasExtra("eventType") || aVar2.oWE.getIntExtra("eventType", i2) != i2)) {
                    Log.i("MicroMsg.FloatBallHelper", "updateIntExtra, %s:%s", "eventType", Integer.valueOf(i2));
                    aVar2.oWE.cy("eventType", i2);
                    aVar2.cit();
                }
                this.JJV = new com.tencent.mm.plugin.wenote.multitask.a(this, new com.tencent.mm.plugin.wenote.multitask.b(this));
                if (Util.isNullOrNil(this.rzs)) {
                    this.JJV.G(3, this.localId + "_" + this.msgId);
                } else {
                    this.JJV.G(3, "fav_" + this.rzs);
                }
            }
            Ee(this.localId);
            Log.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
            com.tencent.mm.plugin.wenote.model.a.i iVar = new com.tencent.mm.plugin.wenote.model.a.i();
            iVar.content = "";
            iVar.qPA = true;
            iVar.qPG = false;
            if (this.JGV) {
                c.gjL().a(iVar);
                this.JJQ = true;
            }
            this.mRecyclerView = (RecyclerView) findViewById(R.id.jnd);
            this.JJw = (LinearLayout) this.mContentView.findViewById(R.id.bvr);
            this.JJw.setVisibility(8);
            this.qND = (LinearLayout) this.JJw.findViewById(R.id.g23);
            this.qND.setVisibility(8);
            this.JJy = (RelativeLayout) findViewById(R.id.jn3);
            this.JJy.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(30688);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (NoteEditorUI.this.JJz != null) {
                        NoteEditorUI.this.JJz.qQv.dismiss();
                    }
                    NoteEditorUI.this.JJy.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30688);
                }
            });
            this.JJz = new g(this, this.JJy);
            this.JJz.JIl = this;
            this.JJF = new NoteLinearLayoutManager();
            this.JJF.qOi = com.tencent.mm.compatible.util.i.getScreenWH(this)[1];
            this.mRecyclerView.setLayoutManager(this.JJF);
            this.mRecyclerView.setHasFixedSize(true);
            this.JJH = new a();
            this.mRecyclerView.a(this.JJH);
            this.JJu = new k(this);
            this.JJu.dFW = this.localId;
            this.JJu.JIH = this.JIH;
            this.JJu.JIx = this.JJT;
            this.JJu.JII = this.JJQ;
            if (this.JHk) {
                k kVar = this.JJu;
                if (kVar.JIA < 0 && kVar.dFW > 0) {
                    kVar.JIJ.startTimer(Util.MILLSECONDS_OF_MINUTE);
                    kVar.JIA = Util.currentTicks();
                    kVar.JIB = "";
                }
            }
            this.JJv = new b(this.JJu);
            this.mRecyclerView.setAdapter(this.JJv);
            if (this.JIH == 2) {
                this.mRecyclerView.setOnTouchListener(this.qNS);
            }
            this.mRecyclerView.getItemAnimator().atn = 0;
            this.mRecyclerView.getItemAnimator().atq = 0;
            this.mRecyclerView.getItemAnimator().atp = 0;
            this.mRecyclerView.getItemAnimator().ato = 120;
            ((as) this.mRecyclerView.getItemAnimator()).awI = false;
            if (this.JIH == 1 || this.JIH == 4) {
                this.JJA = (TextView) findViewById(R.id.g1_);
                this.JJA.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass12 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(30702);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        NoteEditorUI.gkh();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(30702);
                    }
                });
            }
            this.qNI = com.tencent.mm.cb.a.fromDPToPix((Context) this, 48);
            if (this.qNH) {
                Log.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
                boolean z = this.JIH == 2 && this.JJQ;
                int color = getResources().getColor(R.color.a30);
                e gjW = e.gjW();
                Log.i("NoteSelectManager", "onInit start");
                gjW.qSq = z;
                gjW.qSt = 14;
                gjW.qSu = 32;
                gjW.qSv = com.tencent.mm.cb.a.fromDPToPix((Context) this, 21) - gjW.qSu;
                gjW.qSw = com.tencent.mm.cb.a.fromDPToPix((Context) this, 40) + (gjW.qSu * 2);
                gjW.qSx = com.tencent.mm.cb.a.fromDPToPix((Context) this, 240) + (gjW.qSu * 2);
                gjW.qSr = com.tencent.mm.cb.a.fromDPToPix((Context) this, 22);
                gjW.qSs = com.tencent.mm.cb.a.fromDPToPix((Context) this, 1);
                gjW.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
                gjW.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
                gjW.qSB = new int[]{-1, -1};
                gjW.qSC = new int[]{-1, -1};
                gjW.qSD = new int[]{-1, -1};
                gjW.qSE = new int[]{-1, -1};
                com.tencent.mm.plugin.wenote.model.nativenote.c.a aVar3 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, gjW.qSr, gjW.qSs, color, gjW);
                gjW.qSF = new PopupWindow((View) aVar3, aVar3.getViewWidth(), aVar3.getViewHeight(), false);
                gjW.qSF.setClippingEnabled(false);
                gjW.qSF.setAnimationStyle(R.style.a6k);
                gjW.qSz = aVar3.getOffsetForCursorMid();
                gjW.qSA = com.tencent.mm.cb.a.fromDPToPix((Context) this, 6);
                com.tencent.mm.plugin.wenote.model.nativenote.c.a aVar4 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, gjW.qSr, gjW.qSs, color, gjW);
                gjW.qSG = new PopupWindow((View) aVar4, aVar4.getViewWidth(), aVar3.getViewHeight(), false);
                gjW.qSG.setClippingEnabled(false);
                gjW.qSG.setAnimationStyle(R.style.a6j);
                com.tencent.mm.plugin.wenote.model.nativenote.c.a aVar5 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, gjW.qSr, gjW.qSs, color, gjW);
                gjW.qSH = new PopupWindow((View) aVar5, aVar5.getViewWidth(), aVar3.getViewHeight(), false);
                gjW.qSH.setClippingEnabled(false);
                gjW.qSH.setAnimationStyle(R.style.a6l);
                View inflate = LayoutInflater.from(this).inflate(R.layout.bgf, (ViewGroup) null);
                inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                gjW.qSI = new PopupWindow(inflate, -2, -2, false);
                gjW.qSI.setBackgroundDrawable(getResources().getDrawable(R.drawable.coj));
                gjW.qSI.setClippingEnabled(false);
                gjW.qSI.setAnimationStyle(R.style.a6n);
                gjW.qSO = (TextView) inflate.findViewById(R.id.g13);
                gjW.qSP = (TextView) inflate.findViewById(R.id.g1v);
                gjW.qSQ = (TextView) inflate.findViewById(R.id.g1s);
                gjW.qSR = (TextView) inflate.findViewById(R.id.g1r);
                gjW.qSS = (TextView) inflate.findViewById(R.id.g1c);
                gjW.qST = (TextView) inflate.findViewById(R.id.g1b);
                gjW.qSU = (TextView) inflate.findViewById(R.id.g1a);
                gjW.qSV = (TextView) inflate.findViewById(R.id.g1n);
                e.i(gjW.qSO, gjW.qSt);
                e.i(gjW.qSP, gjW.qSt);
                e.i(gjW.qSQ, gjW.qSt);
                e.i(gjW.qSR, gjW.qSt);
                e.i(gjW.qSS, gjW.qSt);
                e.i(gjW.qST, gjW.qSt);
                e.i(gjW.qSU, gjW.qSt);
                e.i(gjW.qSV, gjW.qSt);
                gjW.qSO.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0600: INVOKE  
                      (wrap: android.widget.TextView : 0x05f9: IGET  (r1v125 android.widget.TextView) = (r6v0 'gjW' com.tencent.mm.plugin.wenote.model.nativenote.c.e) com.tencent.mm.plugin.wenote.model.nativenote.c.e.qSO android.widget.TextView)
                      (wrap: com.tencent.mm.plugin.wenote.model.nativenote.c.e$10 : 0x05fd: CONSTRUCTOR  (r2v66 com.tencent.mm.plugin.wenote.model.nativenote.c.e$10) = (r6v0 'gjW' com.tencent.mm.plugin.wenote.model.nativenote.c.e) call: com.tencent.mm.plugin.wenote.model.nativenote.c.e.10.<init>(com.tencent.mm.plugin.wenote.model.nativenote.c.e):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.widget.TextView.setOnClickListener(android.view.View$OnClickListener):void in method: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.onCreate(android.os.Bundle):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x05fd: CONSTRUCTOR  (r2v66 com.tencent.mm.plugin.wenote.model.nativenote.c.e$10) = (r6v0 'gjW' com.tencent.mm.plugin.wenote.model.nativenote.c.e) call: com.tencent.mm.plugin.wenote.model.nativenote.c.e.10.<init>(com.tencent.mm.plugin.wenote.model.nativenote.c.e):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.onCreate(android.os.Bundle):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 26 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wenote.model.nativenote.c.e, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 32 more
                    */
                /*
                // Method dump skipped, instructions count: 2254
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.onCreate(android.os.Bundle):void");
            }

            private boolean e(com.tencent.mm.plugin.wenote.model.a.q qVar) {
                if (qVar == null) {
                    return false;
                }
                if (qVar.JHR == (this.JIH == 1)) {
                    return (this.JIH == 1 && qVar.JHT == this.msgId) || (this.JIH == 2 && qVar.JHS == this.localId);
                }
                return false;
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
            public void onBackPressed() {
                AppMethodBeat.i(30751);
                if (!cCP()) {
                    AppMethodBeat.o(30751);
                    return;
                }
                gki();
                if (this.JJV != null) {
                    com.tencent.mm.plugin.wenote.multitask.a aVar = this.JJV;
                    b.a aVar2 = com.tencent.mm.plugin.multitask.b.b.Abw;
                    if (aVar.l(2, c.gjL().bbV(getString(R.string.j3a)), this.JJY)) {
                        AppMethodBeat.o(30751);
                        return;
                    }
                }
                if (this.VhW == null || !this.VhW.wu(2)) {
                    goBack();
                    super.onBackPressed();
                    AppMethodBeat.o(30751);
                    return;
                }
                AppMethodBeat.o(30751);
            }

            @Override // com.tencent.mm.ui.MMActivity
            public int getLayoutId() {
                return R.layout.bgc;
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void cCz() {
                AppMethodBeat.i(30752);
                com.tencent.mm.ui.base.h.c(getContext(), getString(R.string.fef), null, true);
                AppMethodBeat.o(30752);
            }

            private boolean cCP() {
                AppMethodBeat.i(30753);
                if (this.JJx == null || !this.JJx.qTX) {
                    AppMethodBeat.o(30753);
                    return true;
                }
                cCz();
                AppMethodBeat.o(30753);
                return false;
            }

            public final void goBack() {
                AppMethodBeat.i(30754);
                Log.i("MicroMsg.Note.NoteEditorUI", "goback %s, localid:%s, hasDoGoBack:%s", Integer.valueOf(hashCode()), Long.valueOf(this.localId), Boolean.valueOf(this.JKa));
                if (this.JKa) {
                    AppMethodBeat.o(30754);
                    return;
                }
                this.JKa = true;
                try {
                    if (this.JIH != 2 || !this.JJu.JII) {
                        hXY();
                        Log.i("MicroMsg.Note.NoteEditorUI", "goback %s finally", Integer.valueOf(hashCode()));
                        if (this.qNH) {
                            e.gjW().onDestroy();
                        }
                        if (this.JJu != null) {
                            this.JJu.onDestroy();
                        }
                        if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL != null) {
                            com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGS.clear();
                            com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGR.clear();
                            com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGQ.clear();
                        }
                        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().destroy();
                        if (com.tencent.mm.plugin.wenote.model.k.gjE() != null) {
                            com.tencent.mm.plugin.wenote.model.k.gjE();
                            com.tencent.mm.plugin.wenote.model.k.destroy();
                        }
                        c.gjL().gjM();
                        AppMethodBeat.o(30754);
                        return;
                    }
                    if (!this.JJC && !this.JGV) {
                        if (gkg()) {
                            hXY();
                            Log.i("MicroMsg.Note.NoteEditorUI", "goback %s finally", Integer.valueOf(hashCode()));
                            if (this.qNH) {
                                e.gjW().onDestroy();
                            }
                            if (this.JJu != null) {
                                this.JJu.onDestroy();
                            }
                            if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL != null) {
                                com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGS.clear();
                                com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGR.clear();
                                com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGQ.clear();
                            }
                            com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().destroy();
                            if (com.tencent.mm.plugin.wenote.model.k.gjE() != null) {
                                com.tencent.mm.plugin.wenote.model.k.gjE();
                                com.tencent.mm.plugin.wenote.model.k.destroy();
                            }
                            c.gjL().gjM();
                            AppMethodBeat.o(30754);
                            return;
                        }
                        this.JJC = true;
                        this.JJD = true;
                    }
                    gke();
                    hXY();
                    Log.i("MicroMsg.Note.NoteEditorUI", "goback %s finally", Integer.valueOf(hashCode()));
                    if (this.qNH) {
                        e.gjW().onDestroy();
                    }
                    if (this.JJu != null) {
                        this.JJu.onDestroy();
                    }
                    if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL != null) {
                        com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGS.clear();
                        com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGR.clear();
                        com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGQ.clear();
                    }
                    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().destroy();
                    if (com.tencent.mm.plugin.wenote.model.k.gjE() != null) {
                        com.tencent.mm.plugin.wenote.model.k.gjE();
                        com.tencent.mm.plugin.wenote.model.k.destroy();
                    }
                    c.gjL().gjM();
                    AppMethodBeat.o(30754);
                } catch (Throwable th) {
                    Log.i("MicroMsg.Note.NoteEditorUI", "goback %s finally", Integer.valueOf(hashCode()));
                    if (this.qNH) {
                        e.gjW().onDestroy();
                    }
                    if (this.JJu != null) {
                        this.JJu.onDestroy();
                    }
                    if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL != null) {
                        com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGS.clear();
                        com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGR.clear();
                        com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGQ.clear();
                    }
                    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().destroy();
                    if (com.tencent.mm.plugin.wenote.model.k.gjE() != null) {
                        com.tencent.mm.plugin.wenote.model.k.gjE();
                        com.tencent.mm.plugin.wenote.model.k.destroy();
                    }
                    c.gjL().gjM();
                    AppMethodBeat.o(30754);
                    throw th;
                }
            }

            private void hXY() {
                AppMethodBeat.i(30755);
                if (this.VhW != null) {
                    this.VhW.agT(c.gjL().bbV(getString(R.string.j3a)));
                }
                AppMethodBeat.o(30755);
            }

            public final void gke() {
                AppMethodBeat.i(30756);
                if (this.JJX) {
                    AppMethodBeat.o(30756);
                    return;
                }
                this.JJx.a(this);
                String cDw = c.gjL().cDw();
                if (alG(cDw)) {
                    hb hbVar = new hb();
                    hbVar.dLm.type = 12;
                    hbVar.dLm.dFW = this.localId;
                    EventCenter.instance.publish(hbVar);
                    AppMethodBeat.o(30756);
                } else if (this.JHk || this.JGV) {
                    Log.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
                    bbX(cDw);
                    AppMethodBeat.o(30756);
                } else {
                    if (this.JJC) {
                        Log.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
                        bbY(cDw);
                    }
                    AppMethodBeat.o(30756);
                }
            }

            private void bbX(final String str) {
                AppMethodBeat.i(30757);
                final int i2 = this.JJu.JIE;
                final String str2 = this.JJu.JIF;
                final long j2 = this.JJu.JIG;
                final anb alU = c.gjL().alU(str);
                bg.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass39 */

                    public final void run() {
                        AppMethodBeat.i(30743);
                        NoteEditorUI.this.a(str, true, false, i2, str2, j2, alU);
                        AppMethodBeat.o(30743);
                    }
                });
                AppMethodBeat.o(30757);
            }

            private void bbY(final String str) {
                AppMethodBeat.i(30758);
                final int i2 = this.JJu.JIE;
                final String str2 = this.JJu.JIF;
                final long j2 = this.JJu.JIG;
                final anb alU = c.gjL().alU(str);
                bg.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(30689);
                        NoteEditorUI.this.a(str, false, false, i2, str2, j2, alU);
                        AppMethodBeat.o(30689);
                    }
                });
                AppMethodBeat.o(30758);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onStop() {
                AppMethodBeat.i(179750);
                super.onStop();
                Log.i("MicroMsg.Note.NoteEditorUI", "onStop %s", Integer.valueOf(hashCode()));
                EventCenter.instance.removeListener(this.JKb);
                AppMethodBeat.o(179750);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onDestroy() {
                AppMethodBeat.i(30759);
                super.onDestroy();
                goBack();
                Log.i("MicroMsg.Note.NoteEditorUI", "onDestroy %s", Integer.valueOf(hashCode()));
                this.iGD = true;
                if (this.VhW != null) {
                    this.VhW.onDestroy();
                }
                if (this.qNH && this.mRecyclerView != null) {
                    this.mRecyclerView.b(this.qNJ);
                    this.mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this.JJZ);
                }
                bg.azz().b(921, this);
                AppMethodBeat.o(30759);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void cCA() {
                AppMethodBeat.i(30760);
                if (this.JJx != null) {
                    this.JJx.a((com.tencent.mm.plugin.wenote.model.nativenote.b.a) null);
                }
                AppMethodBeat.o(30760);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void Fr(final int i2) {
                AppMethodBeat.i(30761);
                Handler handler = getWindow().getDecorView().getHandler();
                if (handler == null) {
                    AppMethodBeat.o(30761);
                    return;
                }
                handler.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(30692);
                        Log.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", Integer.valueOf(i2));
                        NoteEditorUI.this.JJv.ci(i2);
                        Log.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", Integer.valueOf(i2));
                        AppMethodBeat.o(30692);
                    }
                }, 0);
                AppMethodBeat.o(30761);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void Ft(int i2) {
                AppMethodBeat.i(30762);
                try {
                    this.JJv.ck(i2);
                    AppMethodBeat.o(30762);
                } catch (Exception e2) {
                    Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", Integer.valueOf(i2));
                    AppMethodBeat.o(30762);
                }
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void Fs(int i2) {
                AppMethodBeat.i(30763);
                try {
                    this.JJv.cj(i2);
                    AppMethodBeat.o(30763);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e2, "", new Object[0]);
                    Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", Integer.valueOf(i2));
                    AppMethodBeat.o(30763);
                }
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void ft(int i2, int i3) {
                AppMethodBeat.i(30764);
                try {
                    this.JJv.as(i2, i3);
                    AppMethodBeat.o(30764);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e2, "", new Object[0]);
                    Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    AppMethodBeat.o(30764);
                }
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void fu(int i2, int i3) {
                AppMethodBeat.i(30765);
                try {
                    this.JJv.aq(i2, i3);
                    AppMethodBeat.o(30765);
                } catch (Exception e2) {
                    Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    AppMethodBeat.o(30765);
                }
            }

            public final void cCu() {
                AppMethodBeat.i(30766);
                try {
                    this.JJv.atj.notifyChanged();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e2, "", new Object[0]);
                    Log.i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
                }
                if (ao.isMultiTaskMode() && this.JJV != null) {
                    com.tencent.mm.plugin.wenote.multitask.a aVar = this.JJV;
                    int i2 = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGZ;
                    String str = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGY;
                    String bbV = c.gjL().bbV(getString(R.string.j3a));
                    p.h(str, "jsonData");
                    p.h(bbV, "title");
                    aVar.type = i2;
                    aVar.data = str;
                    aVar.title = bbV;
                }
                AppMethodBeat.o(30766);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void zD(boolean z) {
                w wVar;
                AppMethodBeat.i(30767);
                Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", Boolean.valueOf(z));
                if (this.JJB || com.tencent.mm.plugin.wenote.model.c.gjz().JGL == null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(this.JJB);
                    objArr[1] = Boolean.valueOf(com.tencent.mm.plugin.wenote.model.c.gjz().JGL == null);
                    Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B", objArr);
                    AppMethodBeat.o(30767);
                    return;
                }
                if (this.JIH != 1) {
                    Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
                    if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGP == null) {
                        Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
                        AppMethodBeat.o(30767);
                        return;
                    }
                    wVar = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGQ.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGP.field_localId));
                } else {
                    Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
                    if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGO == null) {
                        Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
                        AppMethodBeat.o(30767);
                        return;
                    }
                    wVar = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGQ.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGO.msgId));
                }
                if (wVar != null && !this.JGV) {
                    this.JJI = wVar.qPV;
                    if (!wVar.qPV) {
                        this.JJB = true;
                        f(wVar.qPU, true);
                        AppMethodBeat.o(30767);
                        return;
                    }
                    f(wVar.qPU, false);
                }
                AppMethodBeat.o(30767);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final synchronized void f(Object obj, final boolean z) {
                synchronized (this) {
                    AppMethodBeat.i(30768);
                    Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData,canDismissLoadingDialog:%B", Boolean.valueOf(z));
                    synchronized (this.JJJ) {
                        try {
                            c.gjL().cDp();
                            ArrayList arrayList = (ArrayList) obj;
                            if (arrayList != null) {
                                Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData start");
                                if (this.JIH == 2 && !this.JJQ) {
                                    m mVar = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGO;
                                    if (mVar == null) {
                                        AppMethodBeat.o(30768);
                                    } else {
                                        com.tencent.mm.plugin.wenote.model.a.e eVar = new com.tencent.mm.plugin.wenote.model.a.e(mVar.JHQ);
                                        eVar.qPA = false;
                                        eVar.qPG = false;
                                        c.gjL().a(eVar);
                                    }
                                }
                                if (z) {
                                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                        o oVar = (o) arrayList.get(i2);
                                        if (oVar.getType() == 20) {
                                            com.tencent.mm.plugin.wenote.model.a.b bVar = (com.tencent.mm.plugin.wenote.model.a.b) oVar;
                                            if (!this.JJQ || !bVar.DmM) {
                                                com.tencent.mm.plugin.wenote.model.a.i iVar = new com.tencent.mm.plugin.wenote.model.a.i();
                                                ((t) iVar).qPN = bVar.qPN;
                                                iVar.content = getString(R.string.zz) + " " + bVar.qPR + "\n";
                                                arrayList.set(i2, iVar);
                                            }
                                        }
                                    }
                                }
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    o oVar2 = (o) it.next();
                                    switch (oVar2.type) {
                                        case -3:
                                        case -2:
                                        case -1:
                                            c.gjL().a((com.tencent.mm.plugin.wenote.model.a.h) oVar2);
                                            continue;
                                        case 0:
                                        case 7:
                                        case 8:
                                        case 9:
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 16:
                                        case 17:
                                        case 18:
                                        case 19:
                                        default:
                                            c.gjL().a((j) oVar2);
                                            continue;
                                        case 1:
                                            com.tencent.mm.plugin.wenote.model.a.i iVar2 = (com.tencent.mm.plugin.wenote.model.a.i) oVar2;
                                            if (Util.isNullOrNil(iVar2.content)) {
                                                iVar2.content = "";
                                            }
                                            iVar2.content = iVar2.content.replaceAll("<font", "<wx-font").replaceAll("<div", "<wx-div").replaceAll("<p", "<wx-p").replaceAll("</font>", "</wx-font>").replaceAll("<ul>", "<wx-ul>").replaceAll("</ul>", "</wx-ul>").replaceAll("<ol>", "<wx-ol>").replaceAll("</ol>", "</wx-ol>").replaceAll("<li>", "<wx-li>").replaceAll("</li>", "</wx-li>").replaceAll("<b>", "<wx-b>").replaceAll("</b>", "</wx-b>").replaceAll("</div>", "</wx-div>").replaceAll("</p>", "</wx-p>");
                                            if (iVar2.content.length() > 100) {
                                                com.tencent.mm.plugin.wenote.model.nativenote.a.a.alS(iVar2.content);
                                            } else if (com.tencent.mm.plugin.wenote.c.b.alP(iVar2.content)) {
                                                iVar2.content = iVar2.content.substring(0, iVar2.content.length() - 5);
                                            }
                                            c.gjL().a(iVar2);
                                            continue;
                                        case 2:
                                            c.gjL().a((f) oVar2);
                                            continue;
                                        case 3:
                                            c.gjL().a((com.tencent.mm.plugin.wenote.model.a.g) oVar2);
                                            continue;
                                        case 4:
                                            c.gjL().a((l) oVar2);
                                            continue;
                                        case 5:
                                            break;
                                        case 6:
                                            c.gjL().a((com.tencent.mm.plugin.wenote.model.a.k) oVar2);
                                            continue;
                                        case 20:
                                            c.gjL().a((com.tencent.mm.plugin.wenote.model.a.b) oVar2);
                                            break;
                                    }
                                    c.gjL().a((com.tencent.mm.plugin.wenote.model.a.d) oVar2);
                                }
                                Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData finish");
                                if (!z) {
                                    c gjL = c.gjL();
                                    synchronized (gjL) {
                                        try {
                                            gjL.JIe = true;
                                        } catch (Throwable th) {
                                            AppMethodBeat.o(30768);
                                            throw th;
                                        }
                                    }
                                }
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass5 */

                                    public final void run() {
                                        AppMethodBeat.i(30693);
                                        synchronized (NoteEditorUI.this.JJJ) {
                                            try {
                                                NoteEditorUI.this.cCu();
                                                NoteEditorUI.this.JJB = true;
                                                Log.i("MicroMsg.Note.NoteEditorUI", "postToMainThread,isInitDataList = true,canDismissLoadingDialog :%B,mHasFreshedDataByHtml:%B", Boolean.valueOf(z), Boolean.valueOf(NoteEditorUI.this.JJI));
                                                if (NoteEditorUI.this.rGN != null && z) {
                                                    NoteEditorUI.this.rGN.dismiss();
                                                }
                                            } finally {
                                                AppMethodBeat.o(30693);
                                            }
                                        }
                                    }
                                });
                                if (this.JJL > 0 || this.JJM != 0) {
                                    this.hAk.postDelayed(new Runnable() {
                                        /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass6 */

                                        public final void run() {
                                            AppMethodBeat.i(30694);
                                            if (NoteEditorUI.this.JJF != null) {
                                                NoteEditorUI.this.JJF.ah(NoteEditorUI.this.JJL, NoteEditorUI.this.JJM);
                                                NoteEditorUI.this.afB = NoteEditorUI.this.JJL;
                                                NoteEditorUI.this.mLastOffset = NoteEditorUI.this.JJM;
                                            }
                                            AppMethodBeat.o(30694);
                                        }
                                    }, 100);
                                }
                                c.gjL().cDu();
                                AppMethodBeat.o(30768);
                            }
                        } finally {
                            AppMethodBeat.o(30768);
                        }
                    }
                }
            }

            @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a
            public final RecyclerView cCI() {
                return this.mRecyclerView;
            }

            @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a
            public final Context cCJ() {
                AppMethodBeat.i(30769);
                AppCompatActivity context = getContext();
                AppMethodBeat.o(30769);
                return context;
            }

            @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a
            public final com.tencent.mm.plugin.wenote.model.nativenote.b.a gkf() {
                return this;
            }

            class a extends com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a {
                a() {
                }

                @Override // com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a
                public final void cCV() {
                    AppMethodBeat.i(30744);
                    NoteEditorUI.ag(NoteEditorUI.this);
                    AppMethodBeat.o(30744);
                }

                @Override // com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a
                public final void cCW() {
                    AppMethodBeat.i(30745);
                    NoteEditorUI.this.showActionbarLine();
                    NoteEditorUI.ag(NoteEditorUI.this);
                    AppMethodBeat.o(30745);
                }

                @Override // com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a
                public final void cCX() {
                    AppMethodBeat.i(30746);
                    NoteEditorUI.this.hideActionbarLine();
                    AppMethodBeat.o(30746);
                }

                @Override // com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a
                public final void gkk() {
                    AppMethodBeat.i(30747);
                    NoteEditorUI.this.thD.taw = true;
                    NoteEditorUI.this.JJY = true;
                    AppMethodBeat.o(30747);
                }

                @Override // android.support.v7.widget.RecyclerView.l, com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a
                public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    LinearLayoutManager linearLayoutManager;
                    View childAt;
                    AppMethodBeat.i(30748);
                    super.onScrollStateChanged(recyclerView, i2);
                    if (!(recyclerView.getLayoutManager() == null || (childAt = (linearLayoutManager = (LinearLayoutManager) NoteEditorUI.this.mRecyclerView.getLayoutManager()).getChildAt(0)) == null)) {
                        NoteEditorUI.this.mLastOffset = childAt.getTop();
                        NoteEditorUI.this.afB = linearLayoutManager.getPosition(childAt);
                    }
                    AppMethodBeat.o(30748);
                }
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onActivityResult(int i2, int i3, Intent intent) {
                char c2;
                int i4;
                AppMethodBeat.i(30770);
                super.onActivityResult(i2, i3, intent);
                Log.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                this.qNP = i2;
                if (i3 != -1) {
                    this.qNO = false;
                    AppMethodBeat.o(30770);
                    return;
                }
                this.qNO = true;
                int fileSizeLimit = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(true);
                int fileSizeLimitInMB = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimitInMB(true);
                switch (i2) {
                    case 4096:
                        final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                        final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
                        if (!Util.isNullOrNil(stringExtra)) {
                            bg.aVF();
                            final ca Hb = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
                            if (Hb.field_msgId == this.msgId) {
                                final q a2 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
                                bg.aAk().postToWorker(new Runnable() {
                                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass8 */

                                    public final void run() {
                                        AppMethodBeat.i(30697);
                                        rc rcVar = new rc();
                                        rcVar.dXF.type = 4;
                                        rcVar.dXF.dTX = Hb;
                                        rcVar.dXF.toUser = stringExtra;
                                        rcVar.dXF.dLs = stringExtra2;
                                        EventCenter.instance.publish(rcVar);
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass8.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(30696);
                                                a2.dismiss();
                                                com.tencent.mm.ui.widget.snackbar.b.r(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.dc_));
                                                AppMethodBeat.o(30696);
                                            }
                                        });
                                        AppMethodBeat.o(30697);
                                    }

                                    public final String toString() {
                                        AppMethodBeat.i(30698);
                                        String str = super.toString() + "|onActivityResult";
                                        AppMethodBeat.o(30698);
                                        return str;
                                    }
                                });
                                c2 = 2;
                                break;
                            } else {
                                Log.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
                                AppMethodBeat.o(30770);
                                return;
                            }
                        } else {
                            Log.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                            AppMethodBeat.o(30770);
                            return;
                        }
                    case 4097:
                        Log.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
                        if (intent.getParcelableExtra("key_req_result") == null) {
                            i4 = 2;
                        } else {
                            i4 = 1;
                        }
                        final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                            Log.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14547, Integer.valueOf(i4));
                            if (c.gjL().fw(0, stringArrayListExtra.size())) {
                                cCx();
                                c2 = 0;
                                break;
                            } else {
                                AppCompatActivity context = getContext();
                                getString(R.string.zb);
                                this.gtM = com.tencent.mm.ui.base.h.a((Context) context, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass10 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(30700);
                                        if (NoteEditorUI.this.gtM != null) {
                                            NoteEditorUI.this.gtM.dismiss();
                                            NoteEditorUI.this.gtM = null;
                                        }
                                        AppMethodBeat.o(30700);
                                    }
                                });
                                bg.aAk().postToWorker(new Runnable() {
                                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass11 */

                                    public final void run() {
                                        AppMethodBeat.i(30701);
                                        ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList = new ArrayList<>();
                                        for (int i2 = 0; i2 < stringArrayListExtra.size(); i2++) {
                                            f fVar = new f();
                                            fVar.qPO = true;
                                            fVar.type = 2;
                                            fVar.qPN = c.gjL().cDu();
                                            fVar.dLl = com.tencent.mm.plugin.wenote.model.f.alR(fVar.toString());
                                            NoteEditorUI.this.qNR = new aml();
                                            NoteEditorUI.this.qNR.bgs(fVar.dLl);
                                            fVar.qPL = com.tencent.mm.plugin.wenote.c.c.fJ((String) stringArrayListExtra.get(i2), com.tencent.mm.plugin.wenote.model.f.b(NoteEditorUI.this.qNR));
                                            fVar.dUs = com.tencent.mm.plugin.wenote.c.c.fK(fVar.qPL, com.tencent.mm.plugin.wenote.model.f.a(NoteEditorUI.this.qNR));
                                            arrayList.add(fVar);
                                        }
                                        if (NoteEditorUI.this.gtM == null || !NoteEditorUI.this.gtM.isShowing()) {
                                            Log.i("MicroMsg.Note.NoteEditorUI", "user canceled");
                                            AppMethodBeat.o(30701);
                                            return;
                                        }
                                        c.gjL().a(arrayList, NoteEditorUI.this.JJu.gjU(), true, false, true, false);
                                        NoteEditorUI.this.e(true, 100);
                                        NoteEditorUI.this.Q(1, 0);
                                        AppMethodBeat.o(30701);
                                    }
                                });
                            }
                        }
                        ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("key_select_video_list");
                        String stringExtra3 = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                        if (!Util.isNullOrNil(stringExtra3) && stringArrayListExtra2 == null) {
                            stringArrayListExtra2 = new ArrayList<>();
                            stringArrayListExtra2.add(stringExtra3);
                        }
                        if (stringArrayListExtra2 != null && stringArrayListExtra2.size() > 0) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14547, Integer.valueOf(i4));
                            if (!c.gjL().fw(0, stringArrayListExtra2.size())) {
                                String str = stringArrayListExtra2.get(0);
                                com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(str);
                                if (aNx != null) {
                                    int videoDuration = aNx.getVideoDuration();
                                    final com.tencent.mm.plugin.wenote.model.a.k kVar = new com.tencent.mm.plugin.wenote.model.a.k();
                                    kVar.qPO = true;
                                    kVar.thumbPath = "";
                                    kVar.dUs = "";
                                    kVar.duration = videoDuration;
                                    kVar.type = 6;
                                    kVar.qPN = c.gjL().cDu();
                                    kVar.qPP = s.akC(str);
                                    kVar.dLl = com.tencent.mm.plugin.wenote.model.f.alR(kVar.toString());
                                    this.qNR = new aml();
                                    this.qNR.bgs(kVar.dLl);
                                    this.qNR.bgp(kVar.qPP);
                                    String a3 = com.tencent.mm.plugin.wenote.model.f.a(this.qNR);
                                    String b2 = com.tencent.mm.plugin.wenote.model.f.b(this.qNR);
                                    if (!Util.isNullOrNil(str)) {
                                        Log.v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", str);
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(str);
                                        final com.tencent.mm.plugin.wenote.model.nativenote.manager.d dVar = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d(arrayList, a3, b2, kVar, new d.a() {
                                            /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass16 */

                                            @Override // com.tencent.mm.plugin.wenote.model.nativenote.manager.d.a
                                            public final void a(String str, com.tencent.mm.plugin.wenote.model.a.k kVar) {
                                                AppMethodBeat.i(30706);
                                                Log.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
                                                if (!Util.isNullOrNil(str) && s.YS(str) && kVar != null) {
                                                    kVar.thumbPath = str;
                                                }
                                                AppMethodBeat.o(30706);
                                            }

                                            @Override // com.tencent.mm.plugin.wenote.model.nativenote.manager.d.a
                                            public final void b(String str, com.tencent.mm.plugin.wenote.model.a.k kVar) {
                                                AppMethodBeat.i(30707);
                                                Log.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
                                                if (NoteEditorUI.this.gtM != null) {
                                                    NoteEditorUI.this.gtM.dismiss();
                                                    NoteEditorUI.this.gtM = null;
                                                }
                                                if (Util.isNullOrNil(str) || !s.YS(str) || kVar == null || kVar.qPW) {
                                                    Log.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
                                                } else if (new com.tencent.mm.vfs.o(str).length() < ((long) ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(false))) {
                                                    kVar.dUs = str;
                                                    c.gjL().a((com.tencent.mm.plugin.wenote.model.a.c) kVar, NoteEditorUI.this.JJu.gjU(), false, true, false);
                                                } else {
                                                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.string.ccv), 1).show();
                                                }
                                                NoteEditorUI.this.e(true, 100);
                                                NoteEditorUI.this.Q(1, 0);
                                                AppMethodBeat.o(30707);
                                            }
                                        });
                                        AppCompatActivity context2 = getContext();
                                        getString(R.string.zb);
                                        this.gtM = com.tencent.mm.ui.base.h.a((Context) context2, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                            /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass17 */

                                            public final void onCancel(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(30708);
                                                com.tencent.mm.plugin.wenote.model.nativenote.manager.d dVar = dVar;
                                                dVar.isStop = true;
                                                dVar.interrupt();
                                                kVar.qPW = true;
                                                NoteEditorUI.this.e(true, 100);
                                                NoteEditorUI.this.Q(1, 0);
                                                AppMethodBeat.o(30708);
                                            }
                                        });
                                        ThreadPool.post(dVar, "NoteEditor_importVideo");
                                        c2 = 0;
                                        break;
                                    } else {
                                        Log.e("MicroMsg.Note.NoteEditorUI", "video is null");
                                        c2 = 0;
                                        break;
                                    }
                                } else {
                                    Log.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", Util.nullAsNil(str));
                                    c2 = 0;
                                    break;
                                }
                            } else {
                                cCx();
                                c2 = 0;
                                break;
                            }
                        } else {
                            Log.i("MicroMsg.Note.NoteEditorUI", "no video selected");
                            c2 = 0;
                            break;
                        }
                        break;
                    case 4098:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14547, 4);
                        if (!c.gjL().fw(0, 1)) {
                            com.tencent.mm.plugin.wenote.model.a.g gVar = new com.tencent.mm.plugin.wenote.model.a.g();
                            gVar.lat = (double) ((float) intent.getDoubleExtra("kwebmap_slat", 0.0d));
                            gVar.lng = (double) ((float) intent.getDoubleExtra("kwebmap_lng", 0.0d));
                            gVar.JIb = (double) intent.getIntExtra("kwebmap_scale", 0);
                            gVar.iUO = Util.nullAs(intent.getStringExtra("Kwebmap_locaion"), "");
                            gVar.kHV = intent.getStringExtra("kPoiName");
                            gVar.qPN = c.gjL().cDu();
                            gVar.type = 3;
                            gVar.qPO = true;
                            gVar.dUs = "";
                            c.gjL().a((com.tencent.mm.plugin.wenote.model.a.c) gVar, this.JJu.gjU(), false, false, false);
                            c2 = 0;
                            break;
                        } else {
                            cCx();
                            c2 = 0;
                            break;
                        }
                    case 4099:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14547, 5);
                        String stringExtra4 = intent.getStringExtra("choosed_file_path");
                        if (!Util.isNullOrNil(stringExtra4)) {
                            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(stringExtra4);
                            if (oVar.exists()) {
                                if (oVar.length() < ((long) fileSizeLimit)) {
                                    if (!c.gjL().fw(0, 1)) {
                                        if (this.gtM != null) {
                                            this.gtM.dismiss();
                                            this.gtM = null;
                                        }
                                        AppCompatActivity context3 = getContext();
                                        getString(R.string.zb);
                                        this.gtM = com.tencent.mm.ui.base.h.a((Context) context3, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                            /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass13 */

                                            public final void onCancel(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(30703);
                                                if (NoteEditorUI.this.gtM != null) {
                                                    NoteEditorUI.this.gtM.dismiss();
                                                    NoteEditorUI.this.gtM = null;
                                                }
                                                AppMethodBeat.o(30703);
                                            }
                                        });
                                        com.tencent.mm.plugin.wenote.model.a.d dVar2 = new com.tencent.mm.plugin.wenote.model.a.d();
                                        dVar2.title = oVar.getName();
                                        dVar2.content = com.tencent.mm.plugin.wenote.model.f.getLengthStr((float) oVar.length());
                                        dVar2.mav = com.tencent.mm.plugin.wenote.model.h.bbT(s.akC(stringExtra4));
                                        dVar2.qPN = c.gjL().cDu();
                                        dVar2.type = 5;
                                        dVar2.qPO = true;
                                        dVar2.qPP = s.akC(stringExtra4);
                                        dVar2.dLl = com.tencent.mm.plugin.wenote.model.f.alR(dVar2.toString());
                                        this.qNR = new aml();
                                        this.qNR.bgs(dVar2.dLl);
                                        this.qNR.bgp(dVar2.qPP);
                                        dVar2.dUs = com.tencent.mm.plugin.wenote.model.f.b(this.qNR);
                                        s.nw(stringExtra4, dVar2.dUs);
                                        c.gjL().a((com.tencent.mm.plugin.wenote.model.a.c) dVar2, this.JJu.gjU(), false, true, false);
                                        c2 = 2;
                                        break;
                                    } else {
                                        cCx();
                                        c2 = 2;
                                        break;
                                    }
                                } else {
                                    c2 = 3;
                                    break;
                                }
                            } else {
                                c2 = 1;
                                break;
                            }
                        } else {
                            c2 = 1;
                            break;
                        }
                    case 4101:
                        String stringExtra5 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                        String stringExtra6 = intent == null ? null : intent.getStringExtra("custom_send_text");
                        if (!Util.isNullOrNil(stringExtra5)) {
                            final q a4 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
                            hb hbVar = new hb();
                            hbVar.dLm.type = 13;
                            hbVar.dLm.context = getContext();
                            hbVar.dLm.toUser = stringExtra5;
                            hbVar.dLm.dLs = stringExtra6;
                            hbVar.dLm.dFW = this.localId;
                            hbVar.dLm.dLr = new Runnable() {
                                /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass9 */

                                public final void run() {
                                    AppMethodBeat.i(30699);
                                    a4.dismiss();
                                    com.tencent.mm.ui.widget.snackbar.b.r(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.dc_));
                                    AppMethodBeat.o(30699);
                                }
                            };
                            EventCenter.instance.publish(hbVar);
                            c2 = 2;
                            break;
                        } else {
                            Log.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                            AppMethodBeat.o(30770);
                            return;
                        }
                    case 4354:
                        this.hAk.post(new Runnable() {
                            /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass14 */

                            public final void run() {
                                AppMethodBeat.i(30704);
                                Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.h0k), 0).show();
                                AppMethodBeat.o(30704);
                            }
                        });
                        c2 = 2;
                        break;
                    case 4355:
                        String stringExtra7 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                        String stringExtra8 = intent == null ? null : intent.getStringExtra("custom_send_text");
                        if (!Util.isNullOrNil(stringExtra7)) {
                            final q a5 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
                            hb hbVar2 = new hb();
                            hbVar2.dLm.type = 13;
                            hbVar2.dLm.context = getContext();
                            hbVar2.dLm.toUser = stringExtra7;
                            hbVar2.dLm.dLs = stringExtra8;
                            hbVar2.dLm.dFW = this.localId;
                            hbVar2.dLm.dGb = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGW;
                            hbVar2.dLm.dLr = new Runnable() {
                                /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass15 */

                                public final void run() {
                                    AppMethodBeat.i(30705);
                                    a5.dismiss();
                                    com.tencent.mm.ui.widget.snackbar.b.r(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.dc_));
                                    AppMethodBeat.o(30705);
                                }
                            };
                            EventCenter.instance.publish(hbVar2);
                            c2 = 2;
                            break;
                        } else {
                            Log.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                            AppMethodBeat.o(30770);
                            return;
                        }
                    case 30764:
                        Bundle bundleExtra = intent.getBundleExtra("result_data");
                        if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                            com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
                        }
                    default:
                        c2 = 2;
                        break;
                }
                if (c2 == 0) {
                    AppMethodBeat.o(30770);
                } else if (1 == c2) {
                    com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.c_1));
                    AppMethodBeat.o(30770);
                } else {
                    if (3 == c2) {
                        Toast.makeText(getContext(), getString(R.string.ccw, new Object[]{Integer.valueOf(fileSizeLimitInMB)}), 1).show();
                    }
                    AppMethodBeat.o(30770);
                }
            }

            public final void a(String str, boolean z, boolean z2, int i2, String str2, long j2, anb anb) {
                AppMethodBeat.i(179751);
                Log.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlLength: %s, isInsert:%s, htmlstr:%s", Integer.valueOf(str.length()), Boolean.valueOf(z), str);
                if (!z && str.equals(this.JJE)) {
                    if (!this.JJS && i2 > 0 && !Util.isNullOrNil(str2) && j2 > 0) {
                        hb hbVar = new hb();
                        hbVar.dLm.type = 19;
                        hbVar.dLm.dLt = -3;
                        hbVar.dLm.dFW = this.localId;
                        Intent intent = new Intent();
                        intent.putExtra("fav_note_item_status", i2);
                        intent.putExtra("fav_note_xml", str2);
                        intent.putExtra("fav_note_item_updatetime", j2);
                        hbVar.dLm.dLp = intent;
                        EventCenter.instance.publish(hbVar);
                    }
                    AppMethodBeat.o(179751);
                } else if (anb == null) {
                    Log.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
                    AppMethodBeat.o(179751);
                } else {
                    if (z) {
                        hb hbVar2 = new hb();
                        hbVar2.dLm.type = 19;
                        hbVar2.dLm.dGb = anb;
                        hbVar2.dLm.title = str;
                        hbVar2.dLm.dFW = this.localId;
                        hbVar2.dLm.desc = "fav_add_new_note";
                        EventCenter.instance.publish(hbVar2);
                    } else {
                        hb hbVar3 = new hb();
                        hbVar3.dLm.type = 19;
                        hbVar3.dLm.dGb = anb;
                        hbVar3.dLm.title = str;
                        hbVar3.dLm.dFW = this.localId;
                        hbVar3.dLm.desc = "";
                        if (this.JJD) {
                            hbVar3.dLm.dLt = -2;
                        }
                        EventCenter.instance.publish(hbVar3);
                    }
                    Log.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
                    int i3 = 20;
                    if (z) {
                        while (true) {
                            hb hbVar4 = new hb();
                            hbVar4.dLm.type = 30;
                            hbVar4.dLm.dLt = 6;
                            hbVar4.dLm.dFW = this.localId;
                            EventCenter.instance.publish(hbVar4);
                            if (hbVar4.dLn.ret == 1) {
                                this.JGV = false;
                                this.JHk = false;
                                this.JJC = true;
                                Log.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
                                break;
                            }
                            try {
                                Thread.sleep(1000);
                                if (!z2) {
                                    break;
                                }
                                int i4 = i3 - 1;
                                if (i3 <= 0) {
                                    break;
                                }
                                i3 = i4;
                            } catch (InterruptedException e2) {
                            }
                        }
                    } else {
                        while (true) {
                            com.tencent.mm.plugin.fav.a.g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.localId);
                            if (com.tencent.mm.plugin.fav.a.b.g(DY)) {
                                Log.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: update, %s", Integer.valueOf(DY.field_itemStatus));
                                break;
                            }
                            try {
                                Thread.sleep(1000);
                                if (!z2) {
                                    break;
                                }
                                i3--;
                                if (i3 <= 0) {
                                    break;
                                }
                            } catch (InterruptedException e3) {
                            }
                        }
                    }
                    this.JJE = str;
                    Log.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
                    AppMethodBeat.o(179751);
                }
            }

            static boolean alG(String str) {
                AppMethodBeat.i(30772);
                if (Util.isNullOrNil(com.tencent.mm.plugin.wenote.c.b.alQ(str))) {
                    AppMethodBeat.o(30772);
                    return true;
                }
                AppMethodBeat.o(30772);
                return false;
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onStart() {
                AppMethodBeat.i(179752);
                super.onStart();
                Log.i("MicroMsg.Note.NoteEditorUI", "onStart %s", Integer.valueOf(hashCode()));
                EventCenter.instance.addListener(this.JKb);
                AppMethodBeat.o(179752);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onResume() {
                AppMethodBeat.i(30773);
                super.onResume();
                Log.i("MicroMsg.Note.NoteEditorUI", "onResume %s", Integer.valueOf(hashCode()));
                if (this.VhW != null) {
                    this.VhW.bCA();
                }
                if (this.JJV != null) {
                    this.JJV.bCA();
                }
                if (this.JIH == 2) {
                    switch (this.qNP) {
                        case -1:
                            if (this.qNQ) {
                                e(true, 100);
                                Q(1, 0);
                                break;
                            }
                            break;
                        case 4097:
                            if (!this.qNO) {
                                e(true, 100);
                                Q(1, 0);
                                break;
                            }
                            break;
                        case 4098:
                        case 4099:
                            e(true, 100);
                            Q(1, 0);
                            break;
                    }
                }
                this.qNP = -1;
                this.qNO = false;
                AppMethodBeat.o(30773);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onPause() {
                AppMethodBeat.i(30774);
                super.onPause();
                if (this.VhW != null) {
                    this.VhW.aGj();
                }
                if (this.JJV != null) {
                    this.JJV.aGj();
                }
                if (this.JJx != null) {
                    this.JJx.a(this);
                }
                if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().cEF()) {
                    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().stopPlay();
                }
                this.qNQ = this.JJG;
                e(false, 0);
                com.tencent.mm.plugin.wenote.model.a.q gjP = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().gjP();
                if (e(gjP)) {
                    gjP.JHU = c.gjL().bbV(getString(R.string.j3a));
                    gjP.JHW = this.afB;
                    gjP.JHX = this.mLastOffset;
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().c(gjP);
                }
                AppMethodBeat.o(30774);
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
            public void onDrag() {
                AppMethodBeat.i(30775);
                super.onDrag();
                if (this.qNH) {
                    e.gjW().cEc();
                    e.gjW().cEa();
                }
                if (this.JJG) {
                    Log.i("MicroMsg.Note.NoteEditorUI", "onSwipeBack close vkb");
                    hideVKB();
                }
                AppMethodBeat.o(30775);
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
            public void onCancel() {
                AppMethodBeat.i(30776);
                super.onCancel();
                if (this.qNH) {
                    e.gjW().ln(false);
                    e.gjW().lm(false);
                }
                AppMethodBeat.o(30776);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void cCB() {
                AppMethodBeat.i(30777);
                com.tencent.mm.ui.base.h.c(this, getString(R.string.fe9), "", getString(R.string.fe8), getString(R.string.fe7), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass19 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(30710);
                        e.gjW().cEi();
                        AppMethodBeat.o(30710);
                    }
                }, null);
                AppMethodBeat.o(30777);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void gjI() {
                AppMethodBeat.i(30778);
                Toast.makeText(getContext(), getString(R.string.fec), 0).show();
                AppMethodBeat.o(30778);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final int cCE() {
                AppMethodBeat.i(30779);
                if (this.JJG) {
                    int keyBordHeightPx = com.tencent.mm.compatible.util.i.getKeyBordHeightPx(this);
                    AppMethodBeat.o(30779);
                    return keyBordHeightPx;
                }
                AppMethodBeat.o(30779);
                return 0;
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final int cCF() {
                AppMethodBeat.i(30780);
                int i2 = 0;
                if (this.JJw != null && this.JJw.getVisibility() == 0) {
                    i2 = this.qNI + 0;
                }
                if (this.qND != null && this.qND.getVisibility() == 0) {
                    i2 += this.qNI;
                }
                AppMethodBeat.o(30780);
                return i2;
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final boolean cCG() {
                AppMethodBeat.i(30781);
                if (this.JJu == null || this.JJu.gjQ() == null) {
                    AppMethodBeat.o(30781);
                    return false;
                }
                AppMethodBeat.o(30781);
                return true;
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final RecyclerView cCH() {
                return this.mRecyclerView;
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void cCD() {
                AppMethodBeat.i(30782);
                if (this.JIH != 2 || !this.JJu.JII) {
                    AppMethodBeat.o(30782);
                    return;
                }
                int cDq = c.gjL().cDq();
                com.tencent.mm.plugin.wenote.model.a.c ahp = c.gjL().ahp(cDq);
                if (ahp != null) {
                    ahp.qPA = false;
                    ahp.qPG = false;
                    Fr(cDq);
                }
                this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass20 */

                    public final void run() {
                        AppMethodBeat.i(30711);
                        WXRTEditText gjQ = NoteEditorUI.this.JJu.gjQ();
                        if (gjQ != null) {
                            gjQ.clearFocus();
                        }
                        AppMethodBeat.o(30711);
                    }
                });
                e(false, 0);
                Q(0, 0);
                AppMethodBeat.o(30782);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void a(WXRTEditText wXRTEditText, boolean z, int i2) {
                AppMethodBeat.i(30783);
                if (this.JIH != 2 || !this.JJu.JII) {
                    AppMethodBeat.o(30783);
                    return;
                }
                ((NoteLinearLayoutManager) this.mRecyclerView.getLayoutManager()).qOj = z;
                if (this.qNK) {
                    ((NoteLinearLayoutManager) this.mRecyclerView.getLayoutManager()).qOj = false;
                }
                if (z) {
                    if (!this.JGV && !this.JJC) {
                        this.JJE = c.gjL().cDw();
                        this.JJC = true;
                    }
                    if (wXRTEditText == null || wXRTEditText.getEditTextType() != 1) {
                        c.gjL().ag(i2, false);
                        AppMethodBeat.o(30783);
                        return;
                    }
                    c.gjL().ag(i2, true);
                    AppMethodBeat.o(30783);
                    return;
                }
                c.gjL().af(-1, false);
                AppMethodBeat.o(30783);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void gjJ() {
                AppMethodBeat.i(30784);
                if (!this.JGV && !this.JJC) {
                    this.JJE = c.gjL().cDw();
                    this.JJC = true;
                }
                AppMethodBeat.o(30784);
            }

            @Override // com.tencent.mm.ui.MMActivity
            public void onKeyboardStateChanged() {
                AppMethodBeat.i(30785);
                super.onKeyboardStateChanged();
                this.JJG = keyboardState() == 1;
                if (this.JJG) {
                    Q(1, 0);
                }
                if (this.qNH) {
                    this.hAk.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass21 */

                        public final void run() {
                            AppMethodBeat.i(30712);
                            e.gjW().ln(e.gjW().cEb());
                            e.gjW().lm(e.gjW().cDZ());
                            AppMethodBeat.o(30712);
                        }
                    }, 200);
                }
                AppMethodBeat.o(30785);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void e(final boolean z, long j2) {
                AppMethodBeat.i(30786);
                Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility setShow:%s, delay:%s", Boolean.valueOf(z), Long.valueOf(j2));
                if (this.JIH != 2 || !this.JJu.JII) {
                    AppMethodBeat.o(30786);
                    return;
                }
                this.hAk.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass22 */

                    public final void run() {
                        AppMethodBeat.i(30713);
                        Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility 2 isVKBShow:%s", Boolean.valueOf(NoteEditorUI.this.JJG));
                        if (!z || NoteEditorUI.this.JJG) {
                            if (!z && NoteEditorUI.this.JJG) {
                                NoteEditorUI.this.hideVKB();
                            }
                            AppMethodBeat.o(30713);
                            return;
                        }
                        NoteEditorUI.this.showVKB();
                        AppMethodBeat.o(30713);
                    }
                }, j2);
                AppMethodBeat.o(30786);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void Q(final int i2, long j2) {
                AppMethodBeat.i(30787);
                Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateToolBarVisibility, style:%s, delay:%s", Integer.valueOf(i2), Long.valueOf(j2));
                if (this.JIH != 2 || !this.JJu.JII) {
                    AppMethodBeat.o(30787);
                    return;
                }
                this.hAk.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass24 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    public final void run() {
                        AppMethodBeat.i(30715);
                        ImageButton imageButton = (ImageButton) NoteEditorUI.this.JJw.findViewById(R.id.jna);
                        View findViewById = NoteEditorUI.this.JJw.findViewById(R.id.jnb);
                        switch (i2) {
                            case 0:
                                NoteEditorUI.this.qND.setVisibility(8);
                                if (!NoteEditorUI.this.JJx.qTX) {
                                    NoteEditorUI.this.JJw.setVisibility(8);
                                    AppMethodBeat.o(30715);
                                    return;
                                }
                                NoteEditorUI.this.JJw.setVisibility(0);
                                AppMethodBeat.o(30715);
                                return;
                            case 1:
                                imageButton.setImageResource(R.raw.note_style_unpress);
                                findViewById.setVisibility(8);
                                NoteEditorUI.this.JJw.setVisibility(0);
                                NoteEditorUI.this.qND.setVisibility(8);
                                AppMethodBeat.o(30715);
                                return;
                            case 2:
                                NoteEditorUI.this.JJw.setVisibility(0);
                                NoteEditorUI.this.qND.setVisibility(8);
                                AppMethodBeat.o(30715);
                                return;
                            case 3:
                                imageButton.setImageResource(R.raw.note_style_press);
                                findViewById.setVisibility(0);
                                NoteEditorUI.this.JJw.setVisibility(0);
                                NoteEditorUI.this.qND.setVisibility(0);
                                break;
                        }
                        AppMethodBeat.o(30715);
                    }
                }, j2);
                AppMethodBeat.o(30787);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void cCv() {
                AppMethodBeat.i(30788);
                if (!this.JJx.qTX) {
                    cCD();
                    final AppCompatActivity context = getContext();
                    this.hAk.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass25 */

                        public final void run() {
                            AppMethodBeat.i(30716);
                            int size = c.gjL().size();
                            int childCount = NoteEditorUI.this.mRecyclerView.getChildCount();
                            if (size == childCount) {
                                int i2 = childCount - 1;
                                float f2 = 0.0f;
                                int i3 = i2;
                                while (i3 >= 0) {
                                    View childAt = NoteEditorUI.this.mRecyclerView.getChildAt(i3);
                                    float ae = u.ae(childAt);
                                    i3--;
                                    f2 = f2 > ((float) childAt.getBottom()) + ae ? f2 : ((float) childAt.getBottom()) + ae;
                                }
                                if (f2 < ((float) com.tencent.mm.compatible.util.i.getScreenWH(context)[1]) && f2 > 0.0f) {
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) NoteEditorUI.this.JJy.getLayoutParams();
                                    layoutParams.height = (int) f2;
                                    NoteEditorUI.this.JJy.setLayoutParams(layoutParams);
                                }
                            }
                            NoteEditorUI.this.JJy.setVisibility(0);
                            if (NoteEditorUI.this.JJz != null) {
                                g gVar = NoteEditorUI.this.JJz;
                                int[] iArr = {0, 0};
                                gVar.mParentView.getLocationOnScreen(iArr);
                                gVar.qQv.showAtLocation(gVar.mParentView, 49, 0, iArr[1] + 50);
                            }
                            AppMethodBeat.o(30716);
                        }
                    }, 400);
                }
                AppMethodBeat.o(30788);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void a(WXRTEditText wXRTEditText) {
                boolean z;
                AppMethodBeat.i(30789);
                if (wXRTEditText != null) {
                    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.kgc == null || com.tencent.mm.plugin.wenote.model.nativenote.manager.f.kgc.size() <= 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        ArrayList<com.tencent.mm.plugin.wenote.model.a.c> cDk = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cDk();
                        if (c.gjL().U(cDk)) {
                            cCx();
                            AppMethodBeat.o(30789);
                            return;
                        }
                        c.gjL().a(cDk, wXRTEditText, true, true, false, false);
                        int recyclerItemPosition = wXRTEditText.getRecyclerItemPosition();
                        c.gjL().fx(recyclerItemPosition, cDk.size() + recyclerItemPosition + 1);
                        cCD();
                        if (this.qNH) {
                            e.gjW().cDY();
                        }
                        AppMethodBeat.o(30789);
                        return;
                    }
                }
                AppMethodBeat.o(30789);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.manager.g.a
            public final void cCO() {
                AppMethodBeat.i(30790);
                getContext();
                int cDn = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cDn();
                if (cDn == 2) {
                    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cDm()) {
                        cCx();
                        AppMethodBeat.o(30790);
                        return;
                    }
                    c.gjL().cDp();
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.clearData();
                    com.tencent.mm.plugin.wenote.model.a.i iVar = new com.tencent.mm.plugin.wenote.model.a.i();
                    iVar.content = "";
                    iVar.qPA = false;
                    iVar.qPG = false;
                    iVar.qPC = 0;
                    iVar.qPI = true;
                    c.gjL().a(iVar);
                    cCu();
                    AppMethodBeat.o(30790);
                } else if (cDn == 3) {
                    ArrayList<com.tencent.mm.plugin.wenote.model.a.c> cDk = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cDk();
                    if (c.gjL().U(cDk)) {
                        cCx();
                        AppMethodBeat.o(30790);
                        return;
                    }
                    c.gjL().cDp();
                    c.gjL().a(cDk, null, false, false, false, false);
                    cCD();
                    AppMethodBeat.o(30790);
                } else {
                    AppMethodBeat.o(30790);
                }
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.manager.g.a
            public final void cCL() {
                AppMethodBeat.i(30791);
                com.tencent.mm.plugin.wenote.model.a.i iVar = new com.tencent.mm.plugin.wenote.model.a.i();
                iVar.content = "";
                iVar.qPA = true;
                iVar.qPG = false;
                iVar.qPC = 0;
                c.gjL().cDp();
                c.gjL().a(iVar);
                cCu();
                e(true, 50);
                Q(1, 0);
                AppMethodBeat.o(30791);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.manager.g.a
            public final void cCM() {
                AppMethodBeat.i(30792);
                com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), c.gjL().cDx());
                AppMethodBeat.o(30792);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.manager.g.a
            public final void cCN() {
                AppMethodBeat.i(30793);
                com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), c.gjL().cDx());
                cCL();
                AppMethodBeat.o(30793);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void fv(int i2, int i3) {
                AppMethodBeat.i(30794);
                this.qNK = Math.abs(i3 - i2) > 0;
                AppMethodBeat.o(30794);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void Fu(final int i2) {
                AppMethodBeat.i(30795);
                if (i2 < 0 || i2 >= c.gjL().size()) {
                    AppMethodBeat.o(30795);
                    return;
                }
                this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass26 */

                    public final void run() {
                        AppMethodBeat.i(30717);
                        RecyclerView recyclerView = NoteEditorUI.this.mRecyclerView;
                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$33", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$33", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                        AppMethodBeat.o(30717);
                    }
                });
                AppMethodBeat.o(30795);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void cCw() {
                AppMethodBeat.i(30796);
                this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass27 */

                    public final void run() {
                        AppMethodBeat.i(30718);
                        if (NoteEditorUI.this.gtM != null) {
                            NoteEditorUI.this.gtM.dismiss();
                            NoteEditorUI.this.gtM = null;
                        }
                        AppMethodBeat.o(30718);
                    }
                });
                AppMethodBeat.o(30796);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void cCx() {
                AppMethodBeat.i(30797);
                if (this.JGV || this.JJC) {
                    cCD();
                    if (this.qNH) {
                        e.gjW().cDY();
                    }
                    this.hAk.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass28 */

                        public final void run() {
                            AppMethodBeat.i(30719);
                            com.tencent.mm.ui.base.h.c(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.string.j3s), null, true);
                            AppMethodBeat.o(30719);
                        }
                    }, 100);
                }
                AppMethodBeat.o(30797);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
            public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(30798);
                super.onRequestPermissionsResult(i2, strArr, iArr);
                if (iArr == null || iArr.length <= 0) {
                    Log.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
                    AppMethodBeat.o(30798);
                    return;
                }
                Log.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
                switch (i2) {
                    case 64:
                        if (com.tencent.mm.aw.b.Pi((String) com.tencent.mm.kernel.g.aAh().azQ().get(274436, (Object) null)) && iArr[0] != 0) {
                            com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass29 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(30720);
                                    NoteEditorUI noteEditorUI = NoteEditorUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                    com.tencent.mm.hellhoundlib.a.a.a(noteEditorUI, bl.axQ(), "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$36", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    noteEditorUI.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(noteEditorUI, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$36", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    AppMethodBeat.o(30720);
                                }
                            }, (DialogInterface.OnClickListener) null);
                            break;
                        }
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                        if (iArr[0] != 0) {
                            gjH();
                            AppMethodBeat.o(30798);
                            return;
                        }
                        break;
                }
                AppMethodBeat.o(30798);
            }

            @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.a
            public final void gjH() {
                AppMethodBeat.i(30799);
                com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass30 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(30721);
                        dialogInterface.dismiss();
                        NoteEditorUI noteEditorUI = NoteEditorUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        com.tencent.mm.hellhoundlib.a.a.a(noteEditorUI, bl.axQ(), "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$37", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        noteEditorUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(noteEditorUI, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$37", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(30721);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass31 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(30722);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(30722);
                    }
                });
                AppMethodBeat.o(30799);
            }

            private boolean gkg() {
                AppMethodBeat.i(30800);
                hb hbVar = new hb();
                hbVar.dLm.type = 19;
                hbVar.dLm.dFW = this.localId;
                hbVar.dLm.dLt = -1;
                EventCenter.instance.publish(hbVar);
                if (!hbVar.dLn.dLD) {
                    AppMethodBeat.o(30800);
                    return true;
                }
                AppMethodBeat.o(30800);
                return false;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:100:0x0399, code lost:
                r2 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:107:0x03b9, code lost:
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
                cLD();
                android.widget.Toast.makeText(getContext(), getContext().getString(com.tencent.mm.R.string.fee), 1).show();
                r3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                r5 = new java.lang.Object[5];
                r5[0] = 0;
                r5[1] = 0;
                r5[2] = 0;
                r5[3] = 2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:108:0x0406, code lost:
                if (r14.JJQ != false) goto L_0x0408;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:109:0x0408, code lost:
                r2 = 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:110:0x0409, code lost:
                r5[4] = java.lang.Integer.valueOf(r2);
                r3.a(14811, r5);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:115:0x0421, code lost:
                r2 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:116:0x0424, code lost:
                r2 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x012b, code lost:
                r3 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x012d, code lost:
                if (r3 < r4) goto L_0x012f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x012f, code lost:
                r2 = (android.graphics.Bitmap) r7.get((java.lang.Object) java.lang.String.valueOf(r3));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x0141, code lost:
                r2.recycle();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x0144, code lost:
                r3 = r3 + 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x0148, code lost:
                cLD();
                android.widget.Toast.makeText(getContext(), getContext().getString(com.tencent.mm.R.string.fee), 1).show();
                com.tencent.matrix.trace.core.AppMethodBeat.o(30801);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x016a, code lost:
                cLD();
                android.widget.Toast.makeText(getContext(), getContext().getString(com.tencent.mm.R.string.fee), 1).show();
                r10 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                r12 = new java.lang.Object[5];
                r12[0] = 0;
                r12[1] = 0;
                r12[2] = 0;
                r12[3] = 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ae, code lost:
                if (r14.JJQ != false) goto L_0x01b0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x01b0, code lost:
                r3 = 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x01b1, code lost:
                r12[4] = java.lang.Integer.valueOf(r3);
                r10.a(14811, r12);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:57:0x01bd, code lost:
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Exception error msg a");
                cLD();
                android.widget.Toast.makeText(getContext(), getContext().getString(com.tencent.mm.R.string.fee), 1).show();
                r3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                r5 = new java.lang.Object[5];
                r5[0] = 0;
                r5[1] = 0;
                r5[2] = 0;
                r5[3] = 2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x020a, code lost:
                if (r14.JJQ != false) goto L_0x020c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x020c, code lost:
                r2 = 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:0x020d, code lost:
                r5[4] = java.lang.Integer.valueOf(r2);
                r3.a(14811, r5);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:62:0x0237, code lost:
                r3 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:82:0x02ad, code lost:
                r3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                r5 = new java.lang.Object[5];
                r5[0] = 0;
                r5[1] = 0;
                r5[2] = 0;
                r5[3] = 2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:83:0x02d7, code lost:
                if (r14.JJQ != false) goto L_0x02d9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:84:0x02d9, code lost:
                r2 = 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:85:0x02da, code lost:
                r5[4] = java.lang.Integer.valueOf(r2);
                r3.a(14811, r5);
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
                cLD();
                android.widget.Toast.makeText(getContext(), getContext().getString(com.tencent.mm.R.string.fee), 1).show();
                r3 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:86:0x0308, code lost:
                if (r3 < r6) goto L_0x030a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:87:0x030a, code lost:
                r2 = (android.graphics.Bitmap) r7.get((java.lang.Object) java.lang.String.valueOf(r3));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:91:0x031c, code lost:
                r2.recycle();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:92:0x031f, code lost:
                r3 = r3 + 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:93:0x0323, code lost:
                r2 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:94:0x0325, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(30801);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:95:0x032c, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:96:0x032d, code lost:
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,error msg Exception");
                com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.Note.NoteEditorUI", r2, "", new java.lang.Object[0]);
                cLD();
                android.widget.Toast.makeText(getContext(), getContext().getString(com.tencent.mm.R.string.fee), 1).show();
                r3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                r5 = new java.lang.Object[5];
                r5[0] = 0;
                r5[1] = 0;
                r5[2] = 0;
                r5[3] = 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:97:0x0386, code lost:
                if (r14.JJQ != false) goto L_0x0388;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:98:0x0388, code lost:
                r2 = 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:99:0x0389, code lost:
                r5[4] = java.lang.Integer.valueOf(r2);
                r3.a(14811, r5);
                com.tencent.matrix.trace.core.AppMethodBeat.o(30801);
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x03b8 A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:28:0x00a6] */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x01bc A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:28:0x00a6] */
            /* JADX WARNING: Removed duplicated region for block: B:95:0x032c A[ExcHandler: Exception (r2v65 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:63:0x023a] */
            @Override // com.tencent.mm.ak.i
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized void onSceneEnd(int r15, int r16, java.lang.String r17, com.tencent.mm.ak.q r18) {
                /*
                // Method dump skipped, instructions count: 1239
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
            }

            private void cLD() {
                AppMethodBeat.i(30802);
                if (this.rGN != null) {
                    this.rGN.dismiss();
                    this.rGN = null;
                }
                AppMethodBeat.o(30802);
            }

            public static void gkh() {
                AppMethodBeat.i(30803);
                Log.i("MicroMsg.Note.NoteEditorUI", "dealExpose()");
                Intent intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format(e.C2115e.OyU, 57));
                com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(30803);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
            public void finish() {
                AppMethodBeat.i(179753);
                Log.i("MicroMsg.Note.NoteEditorUI", "finish, %s, isFinish:%s", Integer.valueOf(hashCode()), Boolean.valueOf(this.iGD));
                this.iGD = true;
                super.finish();
                AppMethodBeat.o(179753);
            }

            private void gki() {
                AppMethodBeat.i(232135);
                int size = c.gjL().size();
                int childCount = this.mRecyclerView.getChildCount();
                if (size == childCount) {
                    float f2 = 0.0f;
                    for (int i2 = childCount - 1; i2 >= 0; i2--) {
                        View childAt = this.mRecyclerView.getChildAt(i2);
                        float ae = u.ae(childAt);
                        if (f2 <= ((float) childAt.getBottom()) + ae) {
                            f2 = ((float) childAt.getBottom()) + ae;
                        }
                    }
                    if (f2 < ((float) com.tencent.mm.compatible.util.i.getScreenWH(getApplicationContext())[1]) && f2 > 0.0f) {
                        this.JJY = true;
                    }
                }
                AppMethodBeat.o(232135);
            }

            static /* synthetic */ void a(NoteEditorUI noteEditorUI, com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(30804);
                if (noteEditorUI.e(com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().gjP())) {
                    mVar.d(6, noteEditorUI.getString(R.string.j35));
                    AppMethodBeat.o(30804);
                    return;
                }
                mVar.d(5, noteEditorUI.getString(R.string.j3_));
                AppMethodBeat.o(30804);
            }

            static /* synthetic */ boolean j(NoteEditorUI noteEditorUI) {
                AppMethodBeat.i(169773);
                com.tencent.mm.plugin.fav.a.g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(noteEditorUI.localId);
                long j2 = 0;
                if (DY != null) {
                    j2 = DY.field_datatotalsize;
                }
                Log.i("MicroMsg.Note.NoteEditorUI", "note2Send, totalSize:%s", Long.valueOf(j2));
                if (j2 > com.tencent.mm.n.c.aqu()) {
                    AppMethodBeat.o(169773);
                    return true;
                }
                AppMethodBeat.o(169773);
                return false;
            }

            static /* synthetic */ void b(NoteEditorUI noteEditorUI, String str) {
                AppMethodBeat.i(184902);
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_type", 15);
                intent.putExtra("need_result", true);
                String bbV = c.gjL().bbV(noteEditorUI.getString(R.string.j3a));
                intent.putExtra("fav_note_xml", str);
                intent.putExtra("Ksnsupload_title", bbV);
                intent.putExtra("Ksnsupload_link", e.o.Ozo);
                intent.putExtra("fav_note_link_description", "note description");
                intent.putExtra("Ksnsupload_imgbuf", s.aW(noteEditorUI.sUB, 0, -1));
                com.tencent.mm.br.c.b(noteEditorUI, "sns", ".ui.SnsUploadUI", intent, 4354);
                AppMethodBeat.o(184902);
            }

            static /* synthetic */ void ag(NoteEditorUI noteEditorUI) {
                AppMethodBeat.i(258862);
                bg.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(30695);
                        try {
                            int kv = ((LinearLayoutManager) NoteEditorUI.this.mRecyclerView.getLayoutManager()).kv();
                            com.tencent.mm.plugin.wenote.model.a.c ahp = c.gjL().ahp(kv);
                            if (ahp != null && ahp.getType() == 4 && !((l) ahp).qPO) {
                                NoteEditorUI.this.Fr(kv);
                            }
                            AppMethodBeat.o(30695);
                        } catch (NullPointerException e2) {
                            AppMethodBeat.o(30695);
                        }
                    }
                });
                AppMethodBeat.o(258862);
            }
        }
