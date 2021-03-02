package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.hw;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.widget.b.a;
import com.tencent.mm.plugin.websearch.widget.f;
import com.tencent.mm.plugin.websearch.widget.view.b;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.List;

public final class ServiceWidgetView implements g {
    List<af> IIA;
    b.AbstractC1942b IIB;
    e IIy;
    private a IIz;
    MMActivity activity;
    List<WidgetData> dataList;
    ViewPager uO;

    @Override // com.tencent.mm.plugin.websearch.api.g
    public final void fXH() {
        AppMethodBeat.i(116686);
        int currentItem = this.uO.getCurrentItem() + 1;
        WidgetData widgetData = this.dataList.get(this.uO.getCurrentItem());
        if (currentItem < 0 || currentItem > this.dataList.size() - 1) {
            f.a(3, widgetData, null);
            AppMethodBeat.o(116686);
            return;
        }
        f.a(2, widgetData, this.dataList.get(currentItem));
        if (currentItem == this.dataList.indexOf(widgetData)) {
            hw vE = new hw().vD(widgetData.IFG.iIA).vE(widgetData.IFG.iIA);
            vE.eMC = 0;
            vE.vB(widgetData.query).vC(widgetData.dWw).bfK();
            AppMethodBeat.o(116686);
            return;
        }
        Log.i("ServiceWidgetView", "switch widget to %d", Integer.valueOf(currentItem));
        WidgetData widgetData2 = this.dataList.get(currentItem);
        hw vE2 = new hw().vD(widgetData.IFG.iIA).vE(widgetData2.IFG.iIA);
        vE2.eMC = 1;
        vE2.vB(widgetData2.query).vC(widgetData2.dWw).bfK();
        this.uO.setCurrentItem(currentItem, true);
        for (int i2 = 0; i2 < this.IIA.size(); i2++) {
            af afVar = this.IIA.get(i2);
            if (i2 == currentItem) {
                afVar.isSelected = true;
            } else {
                afVar.isSelected = false;
            }
        }
        AppMethodBeat.o(116686);
    }

    @Override // com.tencent.mm.plugin.websearch.api.g
    public final void fXI() {
        AppMethodBeat.i(116687);
        this.uO.setCurrentItem(this.uO.getCurrentItem() - 1);
        AppMethodBeat.o(116687);
    }

    @Override // com.tencent.mm.plugin.websearch.api.g
    public final void a(final int i2, m mVar) {
        b bVar;
        AppMethodBeat.i(116688);
        a aVar = this.IIz;
        int currentItem = this.uO.getCurrentItem();
        if (currentItem < 0 || currentItem >= aVar.fragments.size()) {
            bVar = null;
        } else {
            bVar = aVar.fragments.get(currentItem).IID;
        }
        if (mVar == bVar && i2 != this.uO.getHeight()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(116675);
                    ServiceWidgetView serviceWidgetView = ServiceWidgetView.this;
                    int i2 = i2;
                    Log.i("ServiceWidgetView", "update viewpager height %d", Integer.valueOf(i2));
                    WidgetData widgetData = serviceWidgetView.dataList.get(serviceWidgetView.uO.getCurrentItem());
                    if (widgetData != null && !widgetData.IFG.wkz) {
                        i2 -= com.tencent.mm.cb.a.fromDPToPix((Context) serviceWidgetView.activity.getContext(), 46);
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) serviceWidgetView.uO.getLayoutParams();
                    layoutParams.height = i2;
                    serviceWidgetView.uO.setLayoutParams(layoutParams);
                    AppMethodBeat.o(116675);
                }
            });
        }
        AppMethodBeat.o(116688);
    }

    class a extends i {
        final /* synthetic */ ServiceWidgetView IIC;
        List<MyFragment> fragments;
        List<WidgetData> qzs;

        @Override // android.support.v4.view.q
        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(116683);
            b bVar = ((MyFragment) obj).IID;
            if (bVar != null) {
                int indexOf = this.qzs.indexOf(bVar.IIS);
                if (indexOf >= 0) {
                    AppMethodBeat.o(116683);
                    return indexOf;
                }
                AppMethodBeat.o(116683);
                return -2;
            }
            AppMethodBeat.o(116683);
            return -2;
        }

        @Override // android.support.v4.app.i
        public final Fragment getItem(final int i2) {
            MyFragment myFragment;
            AppMethodBeat.i(116684);
            if (i2 >= this.fragments.size()) {
                myFragment = new MyFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("data", this.qzs.get(i2));
                myFragment.setArguments(bundle);
                this.fragments.add(myFragment);
            } else {
                myFragment = this.fragments.get(i2);
            }
            b bVar = myFragment.IID;
            MMActivity mMActivity = this.IIC.activity;
            ServiceWidgetView serviceWidgetView = this.IIC;
            b.AbstractC1942b bVar2 = this.IIC.IIB;
            AnonymousClass1 r6 = new b.a() {
                /* class com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.websearch.widget.view.b.a
                public final int fZa() {
                    AppMethodBeat.i(116681);
                    if (a.this.qzs == null) {
                        AppMethodBeat.o(116681);
                        return 0;
                    }
                    int size = a.this.qzs.size();
                    AppMethodBeat.o(116681);
                    return size;
                }

                @Override // com.tencent.mm.plugin.websearch.widget.view.b.a
                public final List<af> fZb() {
                    return a.this.IIC.IIA;
                }

                @Override // com.tencent.mm.plugin.websearch.widget.view.b.a
                public final boolean fZc() {
                    return i2 > 0;
                }

                @Override // com.tencent.mm.plugin.websearch.widget.view.b.a
                public final boolean hasNext() {
                    AppMethodBeat.i(116682);
                    if (i2 < a.this.qzs.size() - 1) {
                        AppMethodBeat.o(116682);
                        return true;
                    }
                    AppMethodBeat.o(116682);
                    return false;
                }
            };
            e eVar = this.IIC.IIy;
            bVar.activity = mMActivity;
            bVar.IIQ = serviceWidgetView;
            bVar.IIB = bVar2;
            bVar.IIR = r6;
            bVar.IIy = eVar;
            bVar.IIS = this.qzs.get(i2);
            if (i2 == this.IIC.uO.getCurrentItem()) {
                myFragment.IID.setSelected(true);
            } else {
                myFragment.IID.setSelected(false);
            }
            Log.i("ServiceWidgetView", "getItem %s, fragment %s", Integer.valueOf(i2), myFragment.toString());
            AppMethodBeat.o(116684);
            return myFragment;
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(116685);
            if (this.qzs == null) {
                AppMethodBeat.o(116685);
                return 0;
            }
            int size = this.qzs.size();
            AppMethodBeat.o(116685);
            return size;
        }
    }

    public static class MyFragment extends Fragment {
        b IID = new b();

        public MyFragment() {
            AppMethodBeat.i(116676);
            AppMethodBeat.o(116676);
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AppMethodBeat.i(116677);
            Log.i("ServiceWidgetView", "onCreateView %s", toString());
            b bVar = this.IID;
            bVar.parent = viewGroup;
            if (bVar.IIH == null) {
                if (bVar.view == null) {
                    bVar.view = LayoutInflater.from(bVar.activity.getContext()).inflate(R.layout.bqd, bVar.parent, false);
                    bVar.IIG = (LinearLayout) bVar.view.findViewById(R.id.be3);
                    bVar.uGQ = bVar.view.findViewById(R.id.d8f);
                    bVar.IIF = bVar.view.findViewById(R.id.h00);
                    bVar.IIM = (LinearLayout) bVar.view.findViewById(R.id.ifc);
                    bVar.IIN = (MoreFooter) bVar.view.findViewById(R.id.fk_);
                    bVar.CkP = (TextView) bVar.view.findViewById(R.id.dp0);
                    bVar.IIK = bVar.view.findViewById(R.id.jnv);
                    bVar.IIV = bVar.view.findViewById(R.id.epa);
                    bVar.IIU = (ThreeDotsLoadingView) bVar.view.findViewById(R.id.epy);
                    bVar.IIW = bVar.view.findViewById(R.id.cap);
                    bVar.IIF.setVisibility(8);
                    bVar.IIG.setVisibility(8);
                    bVar.IIF.setVisibility(8);
                    bVar.IIG.setVisibility(8);
                    bVar.IIV.setVisibility(0);
                    bVar.IIU.gZh();
                    if (bVar.IIH != null) {
                        bVar.IIH.aWZ(bVar.III);
                    }
                    bVar.view.findViewById(R.id.gzz).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass4 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(116706);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            b.a(b.this);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(116706);
                        }
                    });
                    bVar.view.findViewById(R.id.gzy).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(116707);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            b.b(b.this);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(116707);
                        }
                    });
                    bVar.IIG.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass6 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(116708);
                            b.this.IIO[0] = motionEvent.getX();
                            b.this.IIO[1] = motionEvent.getY();
                            AppMethodBeat.o(116708);
                            return false;
                        }
                    });
                    bVar.IIG.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass7 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(116709);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            b.this.IIJ = "tap_" + System.currentTimeMillis();
                            int i2 = (int) b.this.IIO[0];
                            int i3 = (int) b.this.IIO[1];
                            if (i2 < 2) {
                                i2 = 2;
                            }
                            if (i3 < 2) {
                                i3 = 2;
                            }
                            if (i3 > b.this.IIG.getHeight() - 2) {
                                i3 = b.this.IIG.getHeight() - 2;
                            }
                            b.this.IIH.g(com.tencent.mm.plugin.appbrand.ac.g.zC(i2), com.tencent.mm.plugin.appbrand.ac.g.zC(i3), b.this.III, b.this.IIJ);
                            b.this.qA(false);
                            u.i("WidgetView", "tap event id %s, location x %f, y %f", b.this.IIJ, Float.valueOf(b.this.IIO[0]), Float.valueOf(b.this.IIO[1]));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(116709);
                        }
                    });
                    bVar.IIN.setOnClickLsn(bVar.IIY);
                    bVar.CkP.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass8 */

                        public final boolean onLongClick(View view) {
                            AppMethodBeat.i(116712);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                            if (b.this.IIS != null && WeChatEnvironment.hasDebugger()) {
                                Context context = b.this.parent.getContext();
                                AnonymousClass1 r1 = new a.AbstractC1941a() {
                                    /* class com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass8.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.websearch.widget.b.a.AbstractC1941a
                                    public final void fYX() {
                                        AppMethodBeat.i(116710);
                                        b.this.IIH.aWY(b.this.III);
                                        AppMethodBeat.o(116710);
                                    }

                                    @Override // com.tencent.mm.plugin.websearch.widget.b.a.AbstractC1941a
                                    public final void fXH() {
                                        AppMethodBeat.i(116711);
                                        b.this.IIQ.fXH();
                                        AppMethodBeat.o(116711);
                                    }
                                };
                                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(context, 2, true);
                                eVar.o("当前服务为体验版本，可以选择以下调试功能", 48);
                                eVar.HLX = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004f: IPUT  
                                      (wrap: com.tencent.mm.plugin.websearch.widget.b.a$1 : 0x004c: CONSTRUCTOR  (r0v9 com.tencent.mm.plugin.websearch.widget.b.a$1) =  call: com.tencent.mm.plugin.websearch.widget.b.a.1.<init>():void type: CONSTRUCTOR)
                                      (r2v2 'eVar' com.tencent.mm.ui.widget.a.e)
                                     com.tencent.mm.ui.widget.a.e.HLX com.tencent.mm.ui.base.o$f in method: com.tencent.mm.plugin.websearch.widget.view.b.8.onLongClick(android.view.View):boolean, file: classes7.dex
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004c: CONSTRUCTOR  (r0v9 com.tencent.mm.plugin.websearch.widget.b.a$1) =  call: com.tencent.mm.plugin.websearch.widget.b.a.1.<init>():void type: CONSTRUCTOR in method: com.tencent.mm.plugin.websearch.widget.view.b.8.onLongClick(android.view.View):boolean, file: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 19 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.websearch.widget.b.a, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 23 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 112
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass8.onLongClick(android.view.View):boolean");
                            }
                        });
                    }
                    bVar.IIH = ((com.tencent.mm.plugin.websearch.api.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.f.class)).a(bVar.parent.getContext(), new n() {
                        /* class com.tencent.mm.plugin.websearch.widget.view.b.AnonymousClass3 */

                        @Override // com.tencent.mm.plugin.websearch.api.n
                        public final void addView(View view) {
                            AppMethodBeat.i(116696);
                            b.this.IIG.removeAllViews();
                            b.this.IIG.addView(view);
                            AppMethodBeat.o(116696);
                        }

                        @Override // com.tencent.mm.plugin.websearch.api.n
                        public final void removeView(View view) {
                            AppMethodBeat.i(116697);
                            b.this.IIG.removeAllViews();
                            AppMethodBeat.o(116697);
                        }

                        @Override // com.tencent.mm.plugin.websearch.api.n
                        public final void gd(String str, int i2) {
                            AppMethodBeat.i(116698);
                            if (i2 == 3) {
                                if (!b.this.isRetry) {
                                    b.this.IIF.setVisibility(0);
                                    b.this.IIG.setVisibility(8);
                                    b.this.IIK.setVisibility(8);
                                } else {
                                    b.this.IIF.setVisibility(8);
                                    b.this.IIG.setVisibility(8);
                                    b.this.IIW.setVisibility(0);
                                    b.this.IIK.setVisibility(8);
                                }
                            }
                            if (i2 != 1) {
                                b.this.isLoading = false;
                                if (!b.this.isSelected) {
                                    b.this.IIH.onPause();
                                }
                            }
                            AppMethodBeat.o(116698);
                        }

                        @Override // com.tencent.mm.plugin.websearch.api.n
                        public final void i(String str, boolean z, String str2) {
                            AppMethodBeat.i(116699);
                            b(str, z, "", str2);
                            AppMethodBeat.o(116699);
                        }

                        @Override // com.tencent.mm.plugin.websearch.api.n
                        public final void b(String str, boolean z, String str2, String str3) {
                            AppMethodBeat.i(116700);
                            u.i("WidgetView", "on tap callback eventId %s, consume %b, errMsg %s", str, Boolean.valueOf(z), str2);
                            if (str3.equals(b.this.III) && str.equals(b.this.IIJ)) {
                                if (!z) {
                                    b.a(b.this);
                                } else {
                                    Log.i("WidgetView", "click event %s consumed by widget", b.this.IIJ);
                                }
                                b.this.IIJ = null;
                            }
                            AppMethodBeat.o(116700);
                        }

                        @Override // com.tencent.mm.plugin.websearch.api.n
                        public final void aXa(String str) {
                            AppMethodBeat.i(116701);
                            if (str.equals(b.this.III)) {
                                b.b(b.this);
                            }
                            AppMethodBeat.o(116701);
                        }

                        @Override // com.tencent.mm.plugin.websearch.api.n
                        public final void lH(String str, String str2) {
                            AppMethodBeat.i(116702);
                            Log.i("WidgetView", "onSearchWAWidgetDataPush %s", str);
                            AppMethodBeat.o(116702);
                        }

                        @Override // com.tencent.mm.plugin.websearch.api.n
                        public final void j(String str, String str2, String str3, int i2) {
                            AppMethodBeat.i(116703);
                            if (str.equals(b.this.III)) {
                                b.this.am(str2, str3, i2);
                                AppMethodBeat.o(116703);
                                return;
                            }
                            Log.e("WidgetView", "callback for expired widget %s", str);
                            AppMethodBeat.o(116703);
                        }

                        @Override // com.tencent.mm.plugin.websearch.api.n
                        public final void ge(String str, int i2) {
                            AppMethodBeat.i(116704);
                            b.this.IIS.IFH.height = i2;
                            b.this.IIH.a(b.this.IIS, b.this.III);
                            b.this.IIQ.a(com.tencent.mm.cb.a.fromDPToPix((Context) b.this.activity.getContext(), i2 + TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE), b.this);
                            AppMethodBeat.o(116704);
                        }

                        @Override // com.tencent.mm.plugin.websearch.api.n
                        public final void fXJ() {
                            AppMethodBeat.i(116705);
                            b.b(b.this);
                            AppMethodBeat.o(116705);
                        }
                    });
                    bVar.IIH.fXF();
                }
                bVar.updateView();
                if (bVar.isSelected) {
                    bVar.fZe();
                }
                View view = this.IID.view;
                AppMethodBeat.o(116677);
                return view;
            }

            @Override // android.support.v4.app.Fragment
            public void onResume() {
                AppMethodBeat.i(116678);
                super.onResume();
                if (!(this.IID == null || this.IID.IIS == null)) {
                    b bVar = this.IID;
                    if (bVar.isSelected) {
                        bVar.IIH.onResume();
                        bVar.fZd();
                        Log.v("WidgetView", "%s resume", bVar.toString());
                    }
                }
                AppMethodBeat.o(116678);
            }

            @Override // android.support.v4.app.Fragment
            public void onPause() {
                AppMethodBeat.i(116679);
                super.onPause();
                if (!(this.IID == null || this.IID.IIS == null)) {
                    b bVar = this.IID;
                    if (bVar.isSelected) {
                        if (bVar.IIH != null) {
                            bVar.IIH.onPause();
                        }
                        bVar.xEm = false;
                        Log.v("WidgetView", "%s paused", bVar.toString());
                    }
                }
                AppMethodBeat.o(116679);
            }

            @Override // android.support.v4.app.Fragment
            public void onDestroy() {
                AppMethodBeat.i(116680);
                super.onDestroy();
                if (!(this.IID == null || this.IID.IIS == null)) {
                    b bVar = this.IID;
                    if (bVar.IIH != null) {
                        bVar.IIH.aWZ(bVar.III);
                        bVar.IIH.onDestroy();
                        bVar.IIS = null;
                        bVar.III = null;
                        bVar.activity = null;
                    }
                }
                AppMethodBeat.o(116680);
            }
        }
    }
