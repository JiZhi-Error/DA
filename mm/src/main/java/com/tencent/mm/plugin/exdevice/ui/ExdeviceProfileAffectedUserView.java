package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView extends LinearLayout {
    private String mRa;
    private TextView rIL;
    private MMHorList rIM;
    private a rIN = new a(this, (byte) 0);
    private ArrayList<String> rIO;

    public ExdeviceProfileAffectedUserView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(24088);
        View inflate = LayoutInflater.from(context).inflate(R.layout.a4u, (ViewGroup) this, true);
        this.rIL = (TextView) inflate.findViewById(R.id.gig);
        this.rIM = (MMHorList) inflate.findViewById(R.id.gif);
        this.rIM.setCenterInParent(true);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 44);
        this.rIM.setOverScrollEnabled(true);
        this.rIM.setItemWidth(fromDPToPix);
        this.rIM.setCenterInParent(true);
        this.rIM.setAdapter((ListAdapter) this.rIN);
        this.rIM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(24079);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                String str = (String) adapterView.getAdapter().getItem(i2);
                Log.d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", str);
                if (Util.isNullOrNil(str)) {
                    Log.w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(24079);
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra(ch.COL_USERNAME, str);
                Context context = context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(24079);
            }
        });
        this.rIL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(24080);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String aTY = z.aTY();
                if (aTY != null && aTY.equals(ExdeviceProfileAffectedUserView.this.mRa)) {
                    ExdeviceProfileAffectedUserView.this.rIM.setVisibility(ExdeviceProfileAffectedUserView.this.rIM.getVisibility() == 0 ? 8 : 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24080);
            }
        });
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(24081);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ExdeviceProfileAffectedUserView.this.rIL.performClick();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24081);
            }
        });
        setVisibility(8);
        AppMethodBeat.o(24088);
    }

    public void setUsername(String str) {
        this.mRa = str;
    }

    public void setAffectedUserInfo(ArrayList<String> arrayList) {
        AppMethodBeat.i(24089);
        this.rIO = arrayList;
        if (this.rIO == null || this.rIO.size() == 0) {
            this.rIL.setText("");
            setVisibility(8);
            AppMethodBeat.o(24089);
            return;
        }
        setVisibility(0);
        this.rIL.setText(getResources().getString(R.string.c17, Integer.valueOf(this.rIO.size())));
        this.rIN.notifyDataSetChanged();
        AppMethodBeat.o(24089);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private Runnable rIQ;

        private a() {
            AppMethodBeat.i(24083);
            this.rIQ = new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(24082);
                    a.this.notifyDataSetChanged();
                    AppMethodBeat.o(24082);
                }
            };
            AppMethodBeat.o(24083);
        }

        /* synthetic */ a(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(24084);
            if (ExdeviceProfileAffectedUserView.this.rIO == null) {
                AppMethodBeat.o(24084);
                return 0;
            }
            int size = ExdeviceProfileAffectedUserView.this.rIO.size();
            AppMethodBeat.o(24084);
            return size;
        }

        private String getItem(int i2) {
            AppMethodBeat.i(24085);
            String str = (String) ExdeviceProfileAffectedUserView.this.rIO.get(i2);
            AppMethodBeat.o(24085);
            return str;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1003a aVar;
            i Mx;
            AppMethodBeat.i(24086);
            String item = getItem(i2);
            if (view == null) {
                view = LayoutInflater.from(ExdeviceProfileAffectedUserView.this.getContext()).inflate(R.layout.a4z, viewGroup, false);
                C1003a aVar2 = new C1003a();
                aVar2.keC = (ImageView) view.findViewById(R.id.wm);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1003a) view.getTag();
            }
            Runnable runnable = this.rIQ;
            j aYB = p.aYB();
            if (aYB != null && ((Mx = aYB.Mx(item)) == null || Util.isNullOrNil(Mx.aYu()))) {
                ay.a.iDq.a(item, "", 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0057: INVOKE  
                      (wrap: com.tencent.mm.model.ay$b : 0x004d: SGET  (r3v2 com.tencent.mm.model.ay$b) =  com.tencent.mm.model.ay.a.iDq com.tencent.mm.model.ay$b)
                      (r2v0 'item' java.lang.String)
                      ("")
                      (wrap: com.tencent.mm.plugin.exdevice.model.f$1 : 0x0054: CONSTRUCTOR  (r7v0 com.tencent.mm.plugin.exdevice.model.f$1) = 
                      (wrap: long : 0x0049: INVOKE  (r4v0 long) =  type: STATIC call: com.tencent.mm.sdk.platformtools.Util.nowMilliSecond():long)
                      (r1v0 'runnable' java.lang.Runnable)
                     call: com.tencent.mm.plugin.exdevice.model.f.1.<init>(long, java.lang.Runnable):void type: CONSTRUCTOR)
                     type: INTERFACE call: com.tencent.mm.model.ay.b.a(java.lang.String, java.lang.String, com.tencent.mm.model.ay$b$a):void in method: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View, file: classes.dex
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
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: CONSTRUCTOR  (r7v0 com.tencent.mm.plugin.exdevice.model.f$1) = 
                      (wrap: long : 0x0049: INVOKE  (r4v0 long) =  type: STATIC call: com.tencent.mm.sdk.platformtools.Util.nowMilliSecond():long)
                      (r1v0 'runnable' java.lang.Runnable)
                     call: com.tencent.mm.plugin.exdevice.model.f.1.<init>(long, java.lang.Runnable):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.exdevice.model.f, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                // Method dump skipped, instructions count: 106
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
            }

            /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView$a$a  reason: collision with other inner class name */
            class C1003a {
                ImageView keC;

                C1003a() {
                }
            }
        }
    }
