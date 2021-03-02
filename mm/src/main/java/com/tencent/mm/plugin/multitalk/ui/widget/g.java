package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.multitalk.b.p;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;

public final class g implements View.OnClickListener {
    private TextView pnR;
    private MultiTalkMainUI zSH;
    private View zSI;
    private View zSJ;
    private TextView zSK;
    private ImageView zSL;
    private RecyclerView zSM;
    private View zSN;
    private ImageButton zSO;
    private ImageButton zSP;
    private boolean zSQ = false;
    private int zSR = 0;

    public g(MultiTalkMainUI multiTalkMainUI) {
        AppMethodBeat.i(114722);
        this.zSH = multiTalkMainUI;
        this.zSI = multiTalkMainUI.findViewById(R.id.dzy);
        this.zSN = multiTalkMainUI.findViewById(R.id.hsp);
        View findViewById = multiTalkMainUI.findViewById(R.id.e00);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = (int) ((((double) a.jo(multiTalkMainUI)) * 15.9d) / 100.0d);
        findViewById.setLayoutParams(layoutParams);
        this.zSK = (TextView) multiTalkMainUI.findViewById(R.id.e01);
        this.zSL = (ImageView) multiTalkMainUI.findViewById(R.id.dzz);
        this.zSM = (RecyclerView) multiTalkMainUI.findViewById(R.id.hsq);
        this.zSJ = multiTalkMainUI.findViewById(R.id.fom);
        this.zSR = (a.jo(multiTalkMainUI) - a.fromDPToPix((Context) multiTalkMainUI, 382)) - ((int) ((((double) a.jo(multiTalkMainUI)) * 21.9d) / 100.0d));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.zSM.getLayoutParams();
        if (this.zSR >= (f.zSo * 3) + (f.zSg * 2)) {
            layoutParams2.height = (f.zSo * 3) + (f.zSg * 2);
        } else {
            layoutParams2.height = this.zSR;
        }
        this.zSM.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.zSN.getLayoutParams();
        layoutParams3.bottomMargin = (int) ((((double) a.jo(multiTalkMainUI)) * 21.9d) / 100.0d);
        this.zSN.setLayoutParams(layoutParams3);
        View findViewById2 = multiTalkMainUI.findViewById(R.id.dzg);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
        layoutParams4.bottomMargin = (int) ((((double) a.jo(multiTalkMainUI)) * 3.6d) / 100.0d);
        findViewById2.setLayoutParams(layoutParams4);
        this.zSM.setLayoutManager(linearLayoutManager);
        this.zSM.setAdapter(new s(multiTalkMainUI));
        this.zSM.setOnScrollListener(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.multitalk.ui.widget.g.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(178925);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0 && g.this.zSQ) {
                    p.rE(false);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(178925);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(178926);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                g.this.zSQ = i3 != 0;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(178926);
            }
        });
        this.pnR = (TextView) multiTalkMainUI.findViewById(R.id.dze);
        this.zSO = (ImageButton) multiTalkMainUI.findViewById(R.id.e02);
        this.zSP = (ImageButton) multiTalkMainUI.findViewById(R.id.dzx);
        this.zSO.setOnClickListener(this);
        this.zSP.setOnClickListener(this);
        AppMethodBeat.o(114722);
    }

    public final void m(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(114723);
        this.zSI.setVisibility(0);
        this.zSJ.setVisibility(0);
        String enX = v.enX();
        ArrayList arrayList = new ArrayList();
        if (!Util.isNullOrNil(enX)) {
            for (int i2 = 0; i2 < multiTalkGroup.RHa.size(); i2++) {
                if (!multiTalkGroup.RHa.get(i2).RHb.equals(enX)) {
                    arrayList.add(multiTalkGroup.RHa.get(i2).RHb);
                }
            }
            this.zSK.setText(l.c(this.zSH, aa.getDisplayName(enX)));
            this.zSL.setContentDescription(l.c(this.zSH, aa.getDisplayName(enX)));
            a.b.a(this.zSL, enX, 0.1f, true);
        }
        if (!(this.zSH.chG() == null || this.zSH.chG().findViewById(R.id.h9c) == null)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.bottomMargin = au.aD(this.zSH);
            this.zSH.chG().findViewById(R.id.h9c).setLayoutParams(layoutParams);
        }
        if (arrayList.size() > 0) {
            this.pnR.setVisibility(0);
            this.pnR.setText(R.string.f6f);
            this.zSM.getLayoutParams();
            this.zSM.setVisibility(0);
            this.zSM.removeAllViews();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (!((s) this.zSM.getAdapter()).aGC((String) arrayList.get(i3))) {
                    ((s) this.zSM.getAdapter()).eO((String) arrayList.get(i3), i3);
                }
            }
            this.zSM.getAdapter().atj.notifyChanged();
            AppMethodBeat.o(114723);
            return;
        }
        this.pnR.setVisibility(8);
        this.zSM.setVisibility(8);
        AppMethodBeat.o(114723);
    }

    public final void eoG() {
        AppMethodBeat.i(114724);
        this.zSI.setVisibility(8);
        this.zSH.chG().removeView(this.zSI);
        AppMethodBeat.o(114724);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(114725);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.dzx) {
            ac.eom().j(true, false, false);
        } else if (view.getId() == R.id.e02) {
            q eom = ac.eom();
            if (eom.ems()) {
                boolean aFW = eom.aFW(eom.zME.zHE);
                Log.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s, wifigateway:%d, isILink:%b", v.g(eom.zME), Integer.valueOf(v2protocal.fJa()), Boolean.valueOf(aFW));
                if (aFW) {
                    com.tencent.mm.plugin.multitalk.b.p pVar = com.tencent.mm.plugin.multitalk.b.p.INSTANCE;
                    if (pVar.qtM) {
                        Log.i("MicroMsg.Multitalk.ILinkService", "steve: already accept!!!");
                    } else {
                        pVar.zIP = p.b.ILinkMemberRoleAccept;
                        pVar.qtH = false;
                        pVar.zIy = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a4: IPUT  
                              (wrap: com.tencent.mm.plugin.multitalk.b.p$22 : 0x00a1: CONSTRUCTOR  (r1v12 com.tencent.mm.plugin.multitalk.b.p$22) = (r0v8 'pVar' com.tencent.mm.plugin.multitalk.b.p) call: com.tencent.mm.plugin.multitalk.b.p.22.<init>(com.tencent.mm.plugin.multitalk.b.p):void type: CONSTRUCTOR)
                              (r0v8 'pVar' com.tencent.mm.plugin.multitalk.b.p)
                             com.tencent.mm.plugin.multitalk.b.p.zIy com.tencent.mm.plugin.multitalk.b.l$a in method: com.tencent.mm.plugin.multitalk.ui.widget.g.onClick(android.view.View):void, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a1: CONSTRUCTOR  (r1v12 com.tencent.mm.plugin.multitalk.b.p$22) = (r0v8 'pVar' com.tencent.mm.plugin.multitalk.b.p) call: com.tencent.mm.plugin.multitalk.b.p.22.<init>(com.tencent.mm.plugin.multitalk.b.p):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.ui.widget.g.onClick(android.view.View):void, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 36 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.p, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 40 more
                            */
                        /*
                        // Method dump skipped, instructions count: 298
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.g.onClick(android.view.View):void");
                    }
                }
