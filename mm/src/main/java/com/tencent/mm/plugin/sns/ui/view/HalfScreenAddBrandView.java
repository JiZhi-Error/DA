package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.data.d;
import com.tencent.mm.plugin.sns.e.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class HalfScreenAddBrandView extends RelativeLayout implements View.OnClickListener {
    public d DCX;
    public int DxM;
    public a EcO;
    public RoundCornerImageView Fdu;
    public TextView Fdv;
    public TextView Fdw;
    private TextView Fdx;
    private TextView Fdy;
    public Button Fdz;
    private View gvQ;
    private Context mContext;
    private WeImageView wgU;

    public HalfScreenAddBrandView(Context context) {
        this(context, null);
    }

    public HalfScreenAddBrandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HalfScreenAddBrandView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(203978);
        this.mContext = context;
        this.gvQ = LayoutInflater.from(this.mContext).inflate(R.layout.au5, this);
        this.wgU = (WeImageView) this.gvQ.findViewById(R.id.b3z);
        this.Fdu = (RoundCornerImageView) this.gvQ.findViewById(R.id.e4d);
        this.Fdv = (TextView) this.gvQ.findViewById(R.id.iwt);
        this.Fdw = (TextView) this.gvQ.findViewById(R.id.iwr);
        this.Fdx = (TextView) this.gvQ.findViewById(R.id.iws);
        this.Fdy = (TextView) this.gvQ.findViewById(R.id.iwq);
        this.Fdz = (Button) this.gvQ.findViewById(R.id.aem);
        this.Fdz.setOnClickListener(this);
        this.wgU.setOnClickListener(this);
        AppMethodBeat.o(203978);
    }

    public void onClick(View view) {
        int i2;
        AppMethodBeat.i(203979);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/view/HalfScreenAddBrandView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.aem) {
            if (this.DxM == 182) {
                a aVar = this.EcO;
                int i3 = this.DxM;
                if (aVar.DCY) {
                    Log.i("HalfScreenAddBrandController", "sendAddBrandFromNativeUI isAddContact is true");
                    aVar.D(true, aVar.DCX.brandUsername);
                } else {
                    Context context = aVar.mContext;
                    aVar.mContext.getString(R.string.zb);
                    aVar.tipDialog = h.a(context, aVar.mContext.getString(R.string.b9q), true, (DialogInterface.OnCancelListener) null);
                    AdLandingPagesProxy.getInstance().doAddBrandScene(aVar.DCX.brandUsername, i3, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00e1: INVOKE  
                          (wrap: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy : 0x00d4: INVOKE  (r2v12 com.tencent.mm.plugin.sns.model.AdLandingPagesProxy) =  type: STATIC call: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.getInstance():com.tencent.mm.plugin.sns.model.AdLandingPagesProxy)
                          (wrap: java.lang.String : 0x00da: IGET  (r3v12 java.lang.String) = 
                          (wrap: com.tencent.mm.plugin.sns.data.d : 0x00d8: IGET  (r3v11 com.tencent.mm.plugin.sns.data.d) = (r0v38 'aVar' com.tencent.mm.plugin.sns.e.a) com.tencent.mm.plugin.sns.e.a.DCX com.tencent.mm.plugin.sns.data.d)
                         com.tencent.mm.plugin.sns.data.d.brandUsername java.lang.String)
                          (r1v14 'i3' int)
                          (wrap: com.tencent.mm.plugin.sns.e.a$1 : 0x00de: CONSTRUCTOR  (r4v8 com.tencent.mm.plugin.sns.e.a$1) = (r0v38 'aVar' com.tencent.mm.plugin.sns.e.a), (r1v14 'i3' int) call: com.tencent.mm.plugin.sns.e.a.1.<init>(com.tencent.mm.plugin.sns.e.a, int):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.doAddBrandScene(java.lang.String, int, com.tencent.mm.plugin.sns.model.AdLandingPagesProxy$e):void in method: com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView.onClick(android.view.View):void, file: classes3.dex
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
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00de: CONSTRUCTOR  (r4v8 com.tencent.mm.plugin.sns.e.a$1) = (r0v38 'aVar' com.tencent.mm.plugin.sns.e.a), (r1v14 'i3' int) call: com.tencent.mm.plugin.sns.e.a.1.<init>(com.tencent.mm.plugin.sns.e.a, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView.onClick(android.view.View):void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 29 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.e.a, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 35 more
                        */
                    /*
                    // Method dump skipped, instructions count: 383
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView.onClick(android.view.View):void");
                }
            }
