package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.pay.q;
import com.tencent.mm.plugin.multitalk.d.f;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.b;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.model.x;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.j;
import com.tencent.mm.plugin.voip.video.camera.a.c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class p implements View.OnClickListener, e.a, b {
    private MTimerHandler cve = new MTimerHandler("MultiTalkTimer", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass10 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(239465);
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass10.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(239464);
                    p.this.titleTv.setVisibility(8);
                    p.this.timeTV.setVisibility(0);
                    AppMethodBeat.o(239464);
                }
            });
            AppMethodBeat.o(239465);
            return true;
        }
    }, false);
    public boolean huQ = true;
    public TextView timeTV;
    private TextView titleTv;
    public RecyclerView zKN;
    public FrameLayout zKO;
    public com.tencent.mm.plugin.multitalk.model.a zMZ;
    public MultiTalkMainUI zSH;
    private ImageButton zSP;
    private boolean zSQ;
    private int zSR = 0;
    public CollapseView zUA;
    private ArrayList<Integer> zUB = new ArrayList<>();
    private ArrayList<Integer> zUC = new ArrayList<>();
    public boolean zUD = false;
    private boolean zUE = false;
    private boolean zUF = true;
    private int zUG = (e.b.JSI * e.b.JSH);
    RelativeLayout zUH;
    public com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a zUI;
    View.OnClickListener zUJ = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass7 */

        public final void onClick(View view) {
            AppMethodBeat.i(178933);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.multitalk.model.p.zbi++;
            p pVar = p.this;
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(pVar.zSH.getContext(), "android.permission.CAMERA", 22, "", "");
            Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), pVar.zSH.getContext());
            if (!a2) {
                p.this.zUr.setChecked(false);
                com.tencent.mm.plugin.multitalk.model.p.emY();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(178933);
            } else if (!ac.eom().ent()) {
                p.this.zUr.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(178933);
            } else if (!ac.eom().emr()) {
                p.this.zUr.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(178933);
            } else if (!NetStatusUtil.isNetworkConnected(p.this.zSH)) {
                com.tencent.mm.bh.e.a(p.this.zSH, R.string.i3o, null);
                p.this.zUr.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(178933);
            } else if (!v.enZ()) {
                Toast.makeText(p.this.zSH, (int) R.string.f5l, 1).show();
                p.this.zUr.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(178933);
            } else {
                if (p.this.zUr.zRU.isChecked()) {
                    p.this.zUr.setChecked(true);
                    p.this.rZ(false);
                    ac.eom().enN();
                    com.tencent.mm.plugin.multitalk.model.p.enh();
                    com.tencent.mm.plugin.multitalk.b.p pVar2 = com.tencent.mm.plugin.multitalk.b.p.INSTANCE;
                    Log.i("MicroMsg.Multitalk.ILinkService", "hy: onCameraStart");
                    pVar2.aj(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0159: INVOKE  
                          (r0v33 'pVar2' com.tencent.mm.plugin.multitalk.b.p)
                          (wrap: com.tencent.mm.plugin.multitalk.b.p$34 : 0x0156: CONSTRUCTOR  (r1v11 com.tencent.mm.plugin.multitalk.b.p$34) = (r0v33 'pVar2' com.tencent.mm.plugin.multitalk.b.p) call: com.tencent.mm.plugin.multitalk.b.p.34.<init>(com.tencent.mm.plugin.multitalk.b.p):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.plugin.multitalk.b.p.aj(java.lang.Runnable):void in method: com.tencent.mm.plugin.multitalk.ui.widget.p.7.onClick(android.view.View):void, file: classes7.dex
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
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0156: CONSTRUCTOR  (r1v11 com.tencent.mm.plugin.multitalk.b.p$34) = (r0v33 'pVar2' com.tencent.mm.plugin.multitalk.b.p) call: com.tencent.mm.plugin.multitalk.b.p.34.<init>(com.tencent.mm.plugin.multitalk.b.p):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.ui.widget.p.7.onClick(android.view.View):void, file: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 32 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.p, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 38 more
                        */
                    /*
                    // Method dump skipped, instructions count: 448
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass7.onClick(android.view.View):void");
                }
            };
            private boolean zUK = false;
            public long zUL;
            public final View zUi;
            private RelativeLayout zUj;
            public GridLayoutManager zUk;
            public View zUl;
            public View zUm;
            private View zUn;
            private View zUo;
            private View zUp;
            public View zUq;
            public MultiTalkControlIconLayout zUr;
            MultiTalkControlIconLayout zUs;
            public MultiTalkControlIconLayout zUt;
            private int zUu;
            private int zUv;
            private RelativeLayout zUw;
            private RelativeLayout zUx;
            private LinearLayout zUy;
            private RelativeLayout zUz;

            static /* synthetic */ void e(p pVar) {
                AppMethodBeat.i(239491);
                pVar.eoW();
                AppMethodBeat.o(239491);
            }

            public p(MultiTalkMainUI multiTalkMainUI) {
                AppMethodBeat.i(114737);
                this.zSH = multiTalkMainUI;
                this.zUu = com.tencent.mm.cb.a.jn(multiTalkMainUI.getContext());
                this.zUv = this.zUu + com.tencent.mm.cb.a.fromDPToPix((Context) multiTalkMainUI, 52) + ao.getStatusBarHeight(multiTalkMainUI);
                this.timeTV = (TextView) multiTalkMainUI.findViewById(R.id.in3);
                this.zUl = multiTalkMainUI.findViewById(R.id.isw);
                this.titleTv = (TextView) multiTalkMainUI.findViewById(R.id.ir3);
                this.zUm = multiTalkMainUI.findViewById(R.id.iib);
                this.zSR = com.tencent.mm.cb.a.jo(multiTalkMainUI) - com.tencent.mm.cb.a.fromDPToPix((Context) multiTalkMainUI, (int) q.CTRL_INDEX);
                this.zUw = (RelativeLayout) multiTalkMainUI.findViewById(R.id.bfq);
                this.zUx = (RelativeLayout) multiTalkMainUI.findViewById(R.id.dn4);
                this.zUy = (LinearLayout) multiTalkMainUI.getLayoutInflater().inflate(R.layout.bck, (ViewGroup) null, false);
                this.zUz = (RelativeLayout) multiTalkMainUI.getLayoutInflater().inflate(R.layout.bcj, (ViewGroup) null, false);
                this.zSP = (ImageButton) this.zUz.findViewById(R.id.iia);
                this.zKN = (RecyclerView) multiTalkMainUI.findViewById(R.id.iic);
                this.zUj = (RelativeLayout) multiTalkMainUI.findViewById(R.id.iid);
                this.zKO = (FrameLayout) multiTalkMainUI.findViewById(R.id.ii9);
                this.zMZ = ac.eom().enA();
                this.zUH = (RelativeLayout) multiTalkMainUI.findViewById(R.id.hbt);
                this.zUi = multiTalkMainUI.findViewById(R.id.isr);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zUi.getLayoutParams();
                layoutParams.topMargin = ao.getStatusBarHeight(multiTalkMainUI) + com.tencent.mm.cb.a.fromDPToPix((Context) multiTalkMainUI, 12);
                this.zUi.setLayoutParams(layoutParams);
                ((RelativeLayout.LayoutParams) this.zKO.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) multiTalkMainUI, 52) + ao.getStatusBarHeight(multiTalkMainUI);
                this.zUk = new GridLayoutManager(3);
                final a aVar = new a(multiTalkMainUI);
                this.zKN.setLayoutManager(this.zUk);
                this.zUk.apR = new GridLayoutManager.b() {
                    /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass1 */

                    @Override // android.support.v7.widget.GridLayoutManager.b
                    public final int bX(int i2) {
                        AppMethodBeat.i(178928);
                        if (aVar.Rn(i2)) {
                            int i3 = p.this.zUk.apM;
                            AppMethodBeat.o(178928);
                            return i3;
                        }
                        AppMethodBeat.o(178928);
                        return 1;
                    }
                };
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.zKN.getLayoutParams();
                if (this.zSR > this.zUu) {
                    layoutParams2.width = this.zUu;
                    layoutParams2.height = this.zUv;
                } else {
                    layoutParams2.width = this.zSR;
                    layoutParams2.height = this.zSR + com.tencent.mm.cb.a.fromDPToPix((Context) multiTalkMainUI, 52) + ao.getStatusBarHeight(multiTalkMainUI);
                    layoutParams2.addRule(14);
                }
                Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "mAvatarLastHeight is %s and talkingAvatarContainerWidth is %s", Integer.valueOf(this.zSR), Integer.valueOf(this.zUu));
                this.zKN.setLayoutParams(layoutParams2);
                aVar.zQP = this.zMZ;
                this.zKN.setAdapter(aVar);
                this.zKN.setOnScrollListener(new RecyclerView.l() {
                    /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass4 */

                    @Override // android.support.v7.widget.RecyclerView.l
                    public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                        AppMethodBeat.i(178929);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(recyclerView);
                        bVar.pH(i2);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                        super.onScrollStateChanged(recyclerView, i2);
                        if (i2 == 0 && p.this.zSQ) {
                            p.this.rY(false);
                            com.tencent.mm.plugin.multitalk.model.p.rE(true);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                        AppMethodBeat.o(178929);
                    }

                    @Override // android.support.v7.widget.RecyclerView.l
                    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                        AppMethodBeat.i(178930);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(recyclerView);
                        bVar.pH(i2);
                        bVar.pH(i3);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                        super.onScrolled(recyclerView, i2, i3);
                        p.this.zSQ = i3 != 0;
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                        AppMethodBeat.o(178930);
                    }
                });
                this.zMZ.a(this.zKN, this.zKO, multiTalkMainUI, this);
                this.zUn = multiTalkMainUI.findViewById(R.id.fom);
                this.zUo = multiTalkMainUI.findViewById(R.id.fo_);
                this.zUo.setBackground(ar.m(MMApplicationContext.getContext(), R.raw.icons_outlined_add, -1));
                this.zUp = multiTalkMainUI.findViewById(R.id.fp1);
                this.zUp.setBackground(ar.m(multiTalkMainUI, R.raw.icons_outlined_board, multiTalkMainUI.getResources().getColor(R.color.am)));
                if (com.tencent.mm.plugin.multitalk.d.e.eqa()) {
                    this.zUp.setVisibility(0);
                } else {
                    this.zUp.setVisibility(8);
                }
                this.zUo.bringToFront();
                this.zUo.setOnClickListener(this);
                this.zUr = (MultiTalkControlIconLayout) this.zUy.findViewById(R.id.fpf);
                this.zUr.setIconEnabled(ac.eom().emr());
                this.zUr.setOnClickListener(this.zUJ);
                this.zUs = (MultiTalkControlIconLayout) this.zUy.findViewById(R.id.f17for);
                this.zUs.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(178931);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.multitalk.model.p.zMo++;
                        ac.eom().rK(p.this.zUs.zRU.isChecked());
                        if (p.this.zUs.zRU.isChecked()) {
                            p.this.zUs.setChecked(true);
                            com.tencent.mm.plugin.multitalk.model.p.enc();
                            ac.eol().rA(false);
                            ac.eon().zTS = true;
                        } else {
                            p.this.zUs.setChecked(false);
                            ac.eon().zTS = false;
                            com.tencent.mm.plugin.multitalk.model.p.ene();
                            ac.eol().rA(true);
                        }
                        if (ac.eom().enA().emb()) {
                            com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 0, 5, 2);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(178931);
                    }
                });
                this.zUt = (MultiTalkControlIconLayout) this.zUy.findViewById(R.id.fog);
                this.zUt.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(178932);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (p.this.zUt.isEnabled()) {
                            com.tencent.mm.plugin.multitalk.model.p.zMp++;
                            ac.eom().rJ(p.this.zUt.zRU.isChecked());
                            p.this.eoW();
                            if (p.this.zUt.zRU.isChecked()) {
                                p.this.zUt.setChecked(true);
                                com.tencent.mm.plugin.multitalk.model.p.enf();
                                ac.eol().rz(true);
                            } else {
                                p.this.zUt.setChecked(false);
                                com.tencent.mm.plugin.multitalk.model.p.eng();
                                ac.eol().rz(false);
                            }
                            if (ac.eom().enA().emb()) {
                                com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 0, 6, 2);
                            }
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(178932);
                    }
                });
                this.zUA = (CollapseView) multiTalkMainUI.findViewById(R.id.djl);
                this.zUq = this.zUz.findViewById(R.id.foe);
                this.zUs.setChecked(ac.eom().guh);
                this.zUt.setChecked(ac.eom().mkd);
                this.zUr.setChecked(v.Rl(ac.eom().zMx));
                Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", Integer.valueOf(this.zUv));
                this.zSP.setOnClickListener(this);
                this.zUn.bringToFront();
                this.zUn.setOnClickListener(this);
                this.zUn.setBackground(ar.m(MMApplicationContext.getContext(), R.raw.icons_outlined_min_window, -1));
                this.zUp.bringToFront();
                this.zUp.setOnClickListener(this);
                this.zUq.setOnClickListener(this);
                multiTalkMainUI.findViewById(R.id.fp8).setOnClickListener(this);
                com.tencent.mm.aj.p.aYn().a(this);
                if (v.Rl(ac.eom().zMx)) {
                    this.zUq.setVisibility(0);
                } else {
                    this.zUq.setVisibility(8);
                }
                eoW();
                AppMethodBeat.o(114737);
            }

            public final void n(MultiTalkGroup multiTalkGroup) {
                AppMethodBeat.i(114738);
                if (!this.zSH.eov()) {
                    if (!this.zMZ.emb()) {
                        this.zUm.setVisibility(0);
                        this.zUr.setIconEnabled(ac.eom().emr());
                        this.zUo.setVisibility(0);
                        if (!ac.eom().emr()) {
                            this.zUp.setVisibility(8);
                        } else if (this.zSH.eov()) {
                            this.zUp.setVisibility(8);
                            this.zUo.setVisibility(8);
                        } else if (com.tencent.mm.plugin.multitalk.d.e.eqa()) {
                            this.zUp.setVisibility(0);
                        }
                    }
                    o(multiTalkGroup);
                    eoW();
                }
                AppMethodBeat.o(114738);
            }

            /* access modifiers changed from: package-private */
            public class a {
                int qrD;
                MultiTalkGroupMember zUQ;

                a(MultiTalkGroupMember multiTalkGroupMember, int i2) {
                    this.zUQ = multiTalkGroupMember;
                    this.qrD = i2;
                }
            }

            private void o(MultiTalkGroup multiTalkGroup) {
                boolean z;
                AppMethodBeat.i(178936);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                MultiTalkGroupMember multiTalkGroupMember = null;
                for (MultiTalkGroupMember multiTalkGroupMember2 : multiTalkGroup.RHa) {
                    if (multiTalkGroupMember2.status != 10 && multiTalkGroupMember2.status != 1) {
                        multiTalkGroupMember2 = multiTalkGroupMember;
                    } else if (!multiTalkGroupMember2.RHb.equals(z.aTY())) {
                        int aGF = com.tencent.mm.plugin.multitalk.d.e.aGF(multiTalkGroupMember2.RHb);
                        if (aGF == -1) {
                            arrayList2.add(multiTalkGroupMember2);
                        } else {
                            arrayList.add(new a(multiTalkGroupMember2, aGF));
                        }
                    }
                    multiTalkGroupMember = multiTalkGroupMember2;
                }
                if (multiTalkGroupMember != null) {
                    arrayList2.add(multiTalkGroupMember);
                }
                ArrayList<MultiTalkGroupMember> arrayList3 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    boolean z2 = false;
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        if (((a) arrayList.get(i2)).qrD > ((a) arrayList.get(i3)).qrD) {
                            arrayList.set(i2, arrayList.get(i3));
                            arrayList.set(i3, (a) arrayList.get(i2));
                            z = true;
                        } else {
                            z = z2;
                        }
                        i3++;
                        z2 = z;
                    }
                    if (!z2) {
                        break;
                    }
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberis is %s", Integer.valueOf(((a) arrayList.get(size)).qrD));
                    arrayList3.add(((a) arrayList.get(size)).zUQ);
                }
                if (this.zUA != null && !v.k(multiTalkGroup).equals(multiTalkGroup.RGY)) {
                    this.zUA.setRoomKey(v.k(multiTalkGroup));
                }
                arrayList3.addAll(arrayList2);
                aC(arrayList3);
                AppMethodBeat.o(178936);
            }

            private void aC(ArrayList<MultiTalkGroupMember> arrayList) {
                AppMethodBeat.i(178937);
                int size = arrayList.size();
                int i2 = 3;
                if (size < 5) {
                    i2 = 2;
                }
                if (!(this.zSH.chG() == null || this.zSH.chG().findViewById(R.id.h9c) == null)) {
                    Log.printInfoStack("MicroMsg.MT.MultiTalkTalkingUILogic", "inflateLineUser", new Object[0]);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.bottomMargin = au.aD(this.zSH);
                    this.zSH.chG().findViewById(R.id.h9c).setLayoutParams(layoutParams);
                }
                this.zKN.removeAllViewsInLayout();
                if (size > 9 || this.zUD) {
                    if (!ac.eom().zMG && size > 12) {
                        ac.eom().zMG = true;
                        u.u(this.zSH, this.zSH.getResources().getString(R.string.f6y), R.raw.multitalk_icons_scrool);
                    }
                    eoT();
                } else {
                    eoR();
                }
                this.zUk.bW(i2);
                this.zKN.setLayoutManager(this.zUk);
                HashSet<String> hashSet = new HashSet<>(ac.eom().zMC);
                ArrayList<String> arrayList2 = new ArrayList<>(ac.eom().enw().enV());
                a aVar = (a) this.zKN.getAdapter();
                if (aVar != null) {
                    aVar.zQJ = false;
                    aVar.c(hashSet);
                    aVar.aA(arrayList2);
                    aVar.a(arrayList, this.zMZ);
                }
                if (ac.eom().ent() && this.zUr != null && !this.zUr.zRU.isChecked()) {
                    ac.eom().aF(1, ac.eom().zMz);
                }
                if (v.Rm(ac.eom().zMx)) {
                    this.zMZ.q(hashSet);
                    rY(false);
                }
                AppMethodBeat.o(178937);
            }

            public static void eoQ() {
                AppMethodBeat.i(239467);
                com.tencent.mm.plugin.multitalk.model.q eom = ac.eom();
                HashSet<String> hashSet = new HashSet<>();
                Iterator<String> it = eom.zMC.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!z.aTY().equals(next)) {
                        hashSet.add(next);
                    }
                }
                eom.zMC.clear();
                eom.zMC = hashSet;
                if (eom.zLR != null) {
                    eom.zLR.emu();
                }
                AppMethodBeat.o(239467);
            }

            private void eoR() {
                AppMethodBeat.i(239468);
                if (this.zUy.getParent() != null) {
                    ((ViewGroup) this.zUy.getParent()).removeView(this.zUy);
                }
                if (this.zUz.getParent() != null) {
                    ((ViewGroup) this.zUz.getParent()).removeView(this.zUz);
                }
                View findViewById = this.zSH.findViewById(R.id.ii_);
                if (findViewById != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                    layoutParams.bottomMargin = (int) ((((double) com.tencent.mm.cb.a.jo(this.zSH)) * 3.6d) / 100.0d);
                    findViewById.setLayoutParams(layoutParams);
                }
                this.zUA.setVisibility(4);
                this.zUw.addView(this.zUy);
                this.zUx.addView(this.zUz);
                AppMethodBeat.o(239468);
            }

            public final void eoS() {
                AppMethodBeat.i(239469);
                this.zUA.setVisibility(4);
                AppMethodBeat.o(239469);
            }

            private void eoT() {
                AppMethodBeat.i(239470);
                if (this.zUD) {
                    AppMethodBeat.o(239470);
                    return;
                }
                this.zUD = true;
                this.zUA.setVisibility(0);
                this.zUA.setCollapseContent$53599cc9(this.zUz);
                this.zUA.am(this.zUy, this.zSH.chG().findViewById(R.id.ii_).getHeight());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zKN.getLayoutParams();
                if (this.zSR > this.zUu) {
                    layoutParams.height = ((this.zUu / 3) * 5) + com.tencent.mm.cb.a.fromDPToPix((Context) this.zSH, 52) + ao.getStatusBarHeight(this.zSH);
                } else {
                    layoutParams.height = ((this.zSR / 3) * 5) + ao.getStatusBarHeight(this.zSH);
                }
                this.zKN.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.zUA.findViewById(R.id.h8x).getLayoutParams();
                layoutParams2.bottomMargin = au.aD(this.zSH);
                this.zUA.findViewById(R.id.h8x).setLayoutParams(layoutParams2);
                if (ac.eom().ent() && this.zUr != null && !this.zUr.zRU.isChecked()) {
                    ac.eom().aF(1, ac.eom().zMz);
                }
                AppMethodBeat.o(239470);
            }

            public final void rY(boolean z) {
                AppMethodBeat.i(239471);
                boolean ens = ac.eom().ens();
                if (!(this.zKN.getAdapter() == null || this.zUk == null)) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    arrayList.clear();
                    arrayList2.clear();
                    a aVar = (a) this.zKN.getAdapter();
                    int kt = this.zUk.kt();
                    int i2 = kt == 0 ? 0 : kt - aVar.wqJ;
                    int kv = (this.zUk.kv() - aVar.wqJ) - aVar.zQO;
                    if (i2 >= 0 && kv >= 0) {
                        for (int i3 = i2; i3 <= kv; i3++) {
                            b aFA = this.zMZ.aFA(aVar.zQI.get(i3).zHg.RHb);
                            if (!(aFA == null || aFA.zQT == null || !(aFA.zQT.enp() || aFA.zQT.epd()))) {
                                int aGF = com.tencent.mm.plugin.multitalk.d.e.aGF(aFA.zQT.getUsername());
                                arrayList.add(Integer.valueOf(aGF));
                                if (ens) {
                                    int QY = com.tencent.mm.plugin.multitalk.b.p.INSTANCE.QY(aGF);
                                    arrayList2.add(Integer.valueOf((QY == 102 || QY == 101) ? 1 : 0));
                                }
                                Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", Integer.valueOf(aGF));
                            }
                        }
                        if (!ens) {
                            aB(arrayList);
                        }
                    } else if (this.zKN.getAdapter() != null) {
                        int i4 = 0;
                        Iterator<com.tencent.mm.plugin.multitalk.data.a> it = ((a) this.zKN.getAdapter()).zQI.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.multitalk.data.a next = it.next();
                            if (next.zHi && i4 < this.zUG) {
                                int aGF2 = com.tencent.mm.plugin.multitalk.d.e.aGF(next.zHg.RHb);
                                arrayList.add(Integer.valueOf(aGF2));
                                if (ens) {
                                    int QY2 = com.tencent.mm.plugin.multitalk.b.p.INSTANCE.QY(aGF2);
                                    arrayList2.add(Integer.valueOf((QY2 == 102 || QY2 == 101) ? 1 : 0));
                                }
                                Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", Integer.valueOf(aGF2));
                            }
                            if (i4 >= this.zUG) {
                                break;
                            }
                            i4++;
                        }
                        if (!ens) {
                            aB(arrayList);
                        }
                    }
                    boolean z2 = false;
                    if (ens) {
                        if (!z && this.zUB != null && arrayList.containsAll(this.zUB) && this.zUB.containsAll(arrayList) && arrayList2.containsAll(this.zUC) && this.zUC.containsAll(arrayList2)) {
                            z2 = true;
                        }
                    } else if (!z && this.zUB != null && arrayList.containsAll(this.zUB) && this.zUB.containsAll(arrayList)) {
                        z2 = true;
                    }
                    if (!z2) {
                        if (!ens) {
                            int size = arrayList.size();
                            ArrayList arrayList3 = new ArrayList();
                            for (int i5 = 0; i5 < size; i5++) {
                                a.ar arVar = new a.ar();
                                arVar.qrD = arrayList.get(i5).intValue();
                                arrayList3.add(arVar);
                            }
                            ac.eom().fB(arrayList3);
                        } else if (!ac.eom().enA().emb()) {
                            com.tencent.mm.plugin.multitalk.b.p.INSTANCE.az(arrayList);
                            Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "ilink subscribeByUserMids ok, mids:".concat(String.valueOf(arrayList)));
                        }
                    }
                    this.zUB = arrayList;
                    if (ens) {
                        this.zUC = arrayList2;
                    }
                }
                AppMethodBeat.o(239471);
            }

            private static int aB(ArrayList<Integer> arrayList) {
                AppMethodBeat.i(178939);
                if (arrayList.size() <= 0) {
                    AppMethodBeat.o(178939);
                    return -1;
                }
                int size = arrayList.size();
                int[] iArr = new int[size];
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < size; i2++) {
                    int intValue = arrayList.get(i2).intValue();
                    sb.append(intValue).append(",");
                    iArr[i2] = intValue;
                }
                Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: engineDoMemberSelectForView: selected id list: %s", sb.toString());
                ByteBuffer allocate = ByteBuffer.allocate(size * 4);
                allocate.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(iArr);
                int appCmd = ac.eol().zMd.setAppCmd(23, allocate.array(), size);
                if (appCmd < 0) {
                    Log.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:engineDoMemberSelectForView failed!!");
                    com.tencent.mm.plugin.multitalk.model.p.emZ();
                    AppMethodBeat.o(178939);
                    return -1;
                }
                AppMethodBeat.o(178939);
                return appCmd;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(114743);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!this.huQ) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(114743);
                    return;
                }
                if (view.getId() == R.id.iia) {
                    ac.eom().j(true, false, false);
                } else if (view.getId() == R.id.fom) {
                    if (this.zMZ.emb()) {
                        emg();
                        this.zUA.eoD();
                        this.zMZ.ema();
                    } else {
                        com.tencent.mm.plugin.multitalk.model.p.zMn++;
                        ac.eom().rI(true);
                        com.tencent.mm.plugin.multitalk.model.p.enk();
                    }
                } else if (view.getId() == R.id.foe) {
                    m eoo = ac.eoo();
                    eoo.zLS = 0;
                    x xVar = eoo.zLT;
                    if (xVar != null) {
                        com.tencent.mm.plugin.voip.video.camera.prev.b bVar2 = c.Hjw;
                        kotlin.g.b.p.g(bVar2, "VoipCameraCompatible.gVoipCameraInfo");
                        if (bVar2.gFx < 2) {
                            StringBuilder sb = new StringBuilder("ExchangeCapture...gCameraNum= ");
                            com.tencent.mm.plugin.voip.video.camera.prev.b bVar3 = c.Hjw;
                            kotlin.g.b.p.g(bVar3, "VoipCameraCompatible.gVoipCameraInfo");
                            Log.e("MicroMsg.Voip.CaptureRender", sb.append(bVar3.gFx).toString());
                        } else {
                            StringBuilder sb2 = new StringBuilder("ExchangeCapture start, gCameraNum= ");
                            com.tencent.mm.plugin.voip.video.camera.prev.b bVar4 = c.Hjw;
                            kotlin.g.b.p.g(bVar4, "VoipCameraCompatible.gVoipCameraInfo");
                            Log.i("MicroMsg.Voip.CaptureRender", sb2.append(bVar4.gFx).toString());
                            xVar.eoc();
                            xVar.a(xVar.zOe, !xVar.zNU);
                            xVar.eob();
                            com.tencent.mm.plugin.voip.c.fFg().adn(xVar.zNX);
                            xVar.imy = true;
                        }
                    }
                    com.tencent.mm.plugin.multitalk.model.p.enj();
                } else if (view.getId() == R.id.fo_) {
                    com.tencent.mm.plugin.multitalk.model.p.zMq++;
                    this.zSH.eou();
                } else if (view.getId() == R.id.fp1) {
                    com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.zSH, 1, true);
                    eVar.hbr();
                    eVar.V(View.inflate(this.zSH, R.layout.bda, null), false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass8 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                            AppMethodBeat.i(239462);
                            mVar.a(0, p.this.zSH.getResources().getColor(R.color.am), p.this.zSH.getResources().getString(R.string.geh));
                            if (com.tencent.mm.plugin.multitalk.d.e.eqb()) {
                                mVar.a(1, p.this.zSH.getResources().getColor(R.color.am), p.this.zSH.getResources().getString(R.string.gef));
                            }
                            AppMethodBeat.o(239462);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass9 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(239463);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    if (p.this.zUr.zRU.isChecked()) {
                                        p.this.sa(false);
                                        ac.eom().aF(1, ac.eom().zMz);
                                        com.tencent.mm.plugin.multitalk.model.p.eni();
                                        ac.eon().zTR = false;
                                    }
                                    com.tencent.mm.plugin.multitalk.model.p.zMr++;
                                    if (ac.eom().zME != null) {
                                        com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 1, 1, 1);
                                    }
                                    f fVar = f.zZd;
                                    f.eqj();
                                    MultiTalkMainUI multiTalkMainUI = p.this.zSH;
                                    if (!multiTalkMainUI.zPT && ac.eom().zME != null) {
                                        multiTalkMainUI.zPT = true;
                                        Intent intent = new Intent();
                                        intent.putExtra("kintent_talker", ac.eom().zME.zHE);
                                        intent.putExtra("key_media_type", 2);
                                        intent.putExtra("scene", 3);
                                        com.tencent.mm.br.c.c(multiTalkMainUI, "com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI", intent, 3);
                                    }
                                    AppMethodBeat.o(239463);
                                    return;
                                case 1:
                                    if (p.this.zUr.zRU.isChecked()) {
                                        p.this.sa(false);
                                        ac.eom().aF(1, ac.eom().zMz);
                                        com.tencent.mm.plugin.multitalk.model.p.eni();
                                        ac.eon().zTR = false;
                                    }
                                    if (ac.eom().zME != null) {
                                        com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 2, 1, 1);
                                    }
                                    f fVar2 = f.zZd;
                                    f.eqk();
                                    MultiTalkMainUI multiTalkMainUI2 = p.this.zSH;
                                    multiTalkMainUI2.zPK.Rs(3);
                                    if (!multiTalkMainUI2.zPK.isShown()) {
                                        multiTalkMainUI2.zPI.eoG();
                                        multiTalkMainUI2.zPJ.n(ac.eom().zME);
                                        break;
                                    } else {
                                        multiTalkMainUI2.zPI.eoG();
                                        multiTalkMainUI2.zPJ.eoS();
                                        multiTalkMainUI2.zPJ.emh();
                                        multiTalkMainUI2.zPJ.eoV();
                                        multiTalkMainUI2.zPJ.eoU();
                                        multiTalkMainUI2.zPT = false;
                                        AppMethodBeat.o(239463);
                                        return;
                                    }
                            }
                            AppMethodBeat.o(239463);
                        }
                    };
                    eVar.dGm();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(114743);
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final void emg() {
                AppMethodBeat.i(239472);
                this.zUo.setVisibility(0);
                this.zUn.setVisibility(0);
                if (com.tencent.mm.plugin.multitalk.d.e.eqa()) {
                    this.zUp.setVisibility(0);
                }
                AppMethodBeat.o(239472);
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final void emh() {
                AppMethodBeat.i(239473);
                this.zUo.setVisibility(8);
                this.zUp.setVisibility(8);
                this.zUn.setVisibility(8);
                AppMethodBeat.o(239473);
            }

            public final void eoU() {
                AppMethodBeat.i(239474);
                this.zUm.setVisibility(8);
                this.zUl.setVisibility(8);
                AppMethodBeat.o(239474);
            }

            private void m(Boolean bool) {
                AppMethodBeat.i(239475);
                if (bool.booleanValue()) {
                    this.zUn.setBackgroundResource(R.drawable.bwd);
                    this.zUl.getLayoutParams().height = com.tencent.mm.cb.a.fromDPToPix((Context) this.zSH, 52) + ao.getStatusBarHeight(this.zSH);
                    this.zUl.setBackgroundColor(this.zSH.getResources().getColor(R.color.l0));
                    this.timeTV.setVisibility(4);
                    this.zUo.setVisibility(4);
                    this.zUp.setVisibility(4);
                    AppMethodBeat.o(239475);
                    return;
                }
                this.zUn.setBackground(ar.m(MMApplicationContext.getContext(), R.raw.icons_outlined_min_window, -1));
                this.zUl.getLayoutParams().height = com.tencent.mm.cb.a.fromDPToPix(this.zSH, this.zSH.getResources().getDimension(R.dimen.acj));
                this.zUl.setBackground(this.zSH.getResources().getDrawable(R.drawable.akf));
                this.timeTV.setVisibility(0);
                this.zUo.setVisibility(0);
                if (com.tencent.mm.plugin.multitalk.d.e.eqa()) {
                    this.zUp.setVisibility(0);
                    AppMethodBeat.o(239475);
                    return;
                }
                this.zUp.setVisibility(8);
                AppMethodBeat.o(239475);
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final void eml() {
                AppMethodBeat.i(239476);
                if (!this.zUF) {
                    AppMethodBeat.o(239476);
                    return;
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setDuration(150);
                alphaAnimation.setDuration(150);
                this.zUF = false;
                this.zUl.setAnimation(alphaAnimation2);
                this.zUl.setVisibility(4);
                this.zUi.setAnimation(alphaAnimation2);
                this.zUi.setVisibility(4);
                this.zUA.setAnimation(alphaAnimation);
                this.zUA.setVisibility(4);
                this.zUp.setVisibility(4);
                AppMethodBeat.o(239476);
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final void emk() {
                AppMethodBeat.i(239477);
                if (this.zUF) {
                    AppMethodBeat.o(239477);
                    return;
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(150);
                alphaAnimation2.setDuration(150);
                this.zUF = true;
                this.zUl.setAnimation(alphaAnimation);
                this.zUl.setVisibility(0);
                this.zUi.setAnimation(alphaAnimation);
                this.zUi.setVisibility(0);
                this.zUA.setAnimation(alphaAnimation2);
                this.zUA.setVisibility(0);
                AppMethodBeat.o(239477);
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final void emi() {
                AppMethodBeat.i(239478);
                m(Boolean.TRUE);
                eoT();
                AppMethodBeat.o(239478);
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final void emj() {
                AppMethodBeat.i(239479);
                m(Boolean.FALSE);
                AppMethodBeat.o(239479);
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final void bQ(String str, boolean z) {
                AppMethodBeat.i(239480);
                if (TextUtils.isEmpty(str)) {
                    aG(8, z);
                    AppMethodBeat.o(239480);
                    return;
                }
                this.titleTv.setText(str);
                aG(0, z);
                AppMethodBeat.o(239480);
            }

            private void aG(int i2, boolean z) {
                AppMethodBeat.i(239481);
                this.titleTv.setVisibility(i2);
                if (i2 == 0) {
                    this.cve.stopTimer();
                    this.cve.removeCallbacksAndMessages(null);
                    if (z) {
                        this.cve.startTimer(5000);
                    }
                    this.timeTV.setVisibility(8);
                    AppMethodBeat.o(239481);
                    return;
                }
                this.timeTV.setVisibility(0);
                AppMethodBeat.o(239481);
            }

            public final void d(HashSet<String> hashSet) {
                AppMethodBeat.i(114744);
                this.zMZ.p(hashSet);
                rY(false);
                AppMethodBeat.o(114744);
            }

            public final void rZ(boolean z) {
                AppMethodBeat.i(239482);
                if (!z) {
                    this.zUL = System.currentTimeMillis();
                }
                Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
                ac.eoo().emF();
                AppMethodBeat.o(239482);
            }

            public final void sa(boolean z) {
                AppMethodBeat.i(239483);
                if (!z && this.zUL != 0 && System.currentTimeMillis() - this.zUL > 0 && ac.eom().emr()) {
                    com.tencent.mm.plugin.multitalk.model.p.A(System.currentTimeMillis() - this.zUL, v.enW());
                    this.zUL = 0;
                }
                if (!z) {
                    ac.eoo().release();
                }
                AppMethodBeat.o(239483);
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final boolean emo() {
                AppMethodBeat.i(239484);
                boolean emo = ac.eoo().emo();
                AppMethodBeat.o(239484);
                return emo;
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final void emm() {
                AppMethodBeat.i(239485);
                this.zUI = new com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a(this.zSH);
                com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a aVar = this.zUI;
                RelativeLayout relativeLayout = this.zUH;
                kotlin.g.b.p.h(relativeLayout, "rootView");
                relativeLayout.removeAllViews();
                j jVar = aVar.zYA;
                if (jVar != null) {
                    jVar.A(relativeLayout);
                    AppMethodBeat.o(239485);
                    return;
                }
                AppMethodBeat.o(239485);
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final void emn() {
                AppMethodBeat.i(239486);
                if (this.zUI != null) {
                    Rv(0);
                    j jVar = this.zUI.zYA;
                    if (jVar != null) {
                        jVar.zWE.release();
                    }
                    com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a aVar = this.zUI;
                    RelativeLayout relativeLayout = this.zUH;
                    kotlin.g.b.p.h(relativeLayout, "rootView");
                    relativeLayout.removeAllViews();
                    j jVar2 = aVar.zYA;
                    if (jVar2 != null) {
                        jVar2.sf(false);
                    }
                    this.zUI = null;
                }
                AppMethodBeat.o(239486);
            }

            public final void sb(boolean z) {
                AppMethodBeat.i(114748);
                Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
                if (this.zMZ.emb()) {
                    emg();
                    this.zUA.eoD();
                    this.zMZ.ema();
                }
                this.cve.stopTimer();
                this.cve.removeCallbacksAndMessages(null);
                this.cve.quitSafely();
                if (!z) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(239461);
                            p.this.timeTV.setText(R.string.f5m);
                            AppMethodBeat.o(239461);
                        }
                    });
                    ac.eom().enw().close();
                }
                this.zMZ.hb(z);
                com.tencent.mm.aj.p.aYn().b(this);
                MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("multi_talk_config");
                if (mmkv.getBoolean("has_opened_screen_cast", false)) {
                    mmkv.putBoolean("has_showed_tip_window", false);
                }
                AppMethodBeat.o(114748);
            }

            public final void eoV() {
                AppMethodBeat.i(239487);
                this.zUm.setVisibility(8);
                this.zUo.setVisibility(8);
                this.zUp.setVisibility(8);
                AppMethodBeat.o(239487);
            }

            @Override // com.tencent.mm.aj.e.a
            public final void Mr(String str) {
                AppMethodBeat.i(114753);
                Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", str);
                com.tencent.mm.plugin.multitalk.model.a aVar = this.zMZ;
                kotlin.g.b.p.h(str, "wxUserName");
                b aFA = aVar.aFA(str);
                if (aFA != null) {
                    MultitalkFrameView multitalkFrameView = aFA.zQT;
                    if (multitalkFrameView != null) {
                        multitalkFrameView.eoX();
                        AppMethodBeat.o(114753);
                        return;
                    }
                    AppMethodBeat.o(114753);
                    return;
                }
                AppMethodBeat.o(114753);
            }

            /* access modifiers changed from: package-private */
            public final void eoW() {
                AppMethodBeat.i(114756);
                if (this.zUt.isEnabled()) {
                    ac.eom().rN(this.zUt.zRU.isChecked());
                }
                AppMethodBeat.o(114756);
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final int[] eme() {
                return new int[]{this.zUu, this.zUv};
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final boolean emf() {
                AppMethodBeat.i(239488);
                if (NetStatusUtil.is2G(this.zSH) || NetStatusUtil.is3G(this.zSH)) {
                    AppMethodBeat.o(239488);
                    return true;
                }
                AppMethodBeat.o(239488);
                return false;
            }

            @Override // com.tencent.mm.plugin.multitalk.model.b
            public final int deu() {
                AppMethodBeat.i(239489);
                int statusBarHeight = ao.getStatusBarHeight(this.zSH);
                AppMethodBeat.o(239489);
                return statusBarHeight;
            }

            public final void Rv(int i2) {
                AppMethodBeat.i(239490);
                if (this.zUI != null) {
                    this.zUI.setOrientation(i2);
                    if (this.zUA != null) {
                        this.zUA.Rr(i2);
                    }
                    if (this.zUq != null) {
                        this.zUq.setRotation((float) i2);
                    }
                    if (this.zUr != null) {
                        this.zUr.Rr(i2);
                    }
                    if (this.zUt != null) {
                        this.zUt.Rr(i2);
                    }
                    if (this.zUs != null) {
                        this.zUs.Rr(i2);
                    }
                }
                AppMethodBeat.o(239490);
            }
        }
