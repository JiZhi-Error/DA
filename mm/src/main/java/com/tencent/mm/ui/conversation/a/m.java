package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class m extends com.tencent.mm.pluginsdk.ui.b.b implements t.a {
    Map<String, Long> Qio = new HashMap();
    Map<Long, b> Qip = new HashMap();
    ViewGroup mContainer;

    /* access modifiers changed from: package-private */
    public static final class b {
        long Qir;
        boolean Qis;
        View Qit;
        com.tencent.mm.plugin.sight.decode.a.a Qiu;
        ImageView Qiv;
        TextView Qiw;
        ImageButton Qix;
        ProgressBar krF;

        private b() {
            this.Qir = 0;
            this.Qis = false;
            this.Qit = null;
            this.Qiu = null;
            this.Qiv = null;
            this.Qiw = null;
            this.krF = null;
            this.Qix = null;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public m(Context context) {
        super(context);
        AppMethodBeat.i(38821);
        o.bhj().a(this, Looper.getMainLooper());
        this.mContainer = (ViewGroup) this.view;
        AppMethodBeat.o(38821);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.b6q;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
        AppMethodBeat.i(38822);
        o.bhj().a(this);
        AppMethodBeat.o(38822);
    }

    private void updateStatus() {
        AppMethodBeat.i(38823);
        Log.i("MicroMsg.MassSightBanner", "call update status");
        a aVar = new a((byte) 0);
        aVar.Qiq = new WeakReference<>(this);
        bg.aAk().postToWorker(aVar);
        AppMethodBeat.o(38823);
    }

    /* access modifiers changed from: package-private */
    public static final class a implements Runnable {
        WeakReference<m> Qiq;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(38815);
            List<s> bhA = o.bhj().bhA();
            List<s> bhB = o.bhj().bhB();
            m mVar = this.Qiq.get();
            if (mVar == null) {
                Log.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
                AppMethodBeat.o(38815);
                return;
            }
            Log.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", Integer.valueOf(mVar.mContainer.getChildCount()), Integer.valueOf(bhA.size()), Integer.valueOf(bhB.size()));
            if (mVar.mContainer.getChildCount() != 0 || !bhA.isEmpty() || !bhB.isEmpty()) {
                c cVar = new c((byte) 0);
                cVar.Qiq = new WeakReference<>(this.Qiq.get());
                cVar.Qiz = bhA;
                cVar.QiA = bhB;
                MMHandlerThread.postToMainThread(cVar);
                AppMethodBeat.o(38815);
                return;
            }
            AppMethodBeat.o(38815);
        }
    }

    static final class c implements Runnable {
        List<s> QiA;
        WeakReference<m> Qiq;
        List<s> Qiz;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        private static int a(String str, m mVar, List<s> list, int i2, int i3, int i4) {
            View view;
            b bVar;
            AppMethodBeat.i(38818);
            for (s sVar : list) {
                mVar.Qio.put(sVar.getFileName(), Long.valueOf(sVar.jqz));
                if (mVar.Qip.containsKey(Long.valueOf(sVar.jqz))) {
                    Log.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", str, Long.valueOf(sVar.jqz), sVar.getFileName());
                } else {
                    if (i2 < i3) {
                        int i5 = i2 + 1;
                        View childAt = mVar.mContainer.getChildAt(i2);
                        Log.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(childAt.hashCode()), Long.valueOf(sVar.jqz));
                        view = childAt;
                        i2 = i5;
                    } else {
                        View inflate = LayoutInflater.from(mVar.mContainer.getContext()).inflate(R.layout.b6r, mVar.mContainer, false);
                        mVar.mContainer.addView(inflate);
                        Log.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(inflate.hashCode()), Long.valueOf(sVar.jqz));
                        view = inflate;
                    }
                    b bVar2 = (b) view.getTag();
                    if (bVar2 == null) {
                        bVar = new b((byte) 0);
                    } else {
                        bVar = bVar2;
                    }
                    if (bVar.Qir != sVar.jqz) {
                        Log.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", Long.valueOf(bVar.Qir), Long.valueOf(sVar.jqz), Integer.valueOf(i4));
                        bVar.Qir = sVar.jqz;
                        bVar.Qit = view;
                        bVar.Qiu = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(R.id.dwr);
                        bVar.Qiv = (ImageView) view.findViewById(R.id.i5g);
                        bVar.krF = (ProgressBar) view.findViewById(R.id.gl7);
                        bVar.Qix = (ImageButton) view.findViewById(R.id.aib);
                        bVar.Qiw = (TextView) view.findViewById(R.id.dy9);
                        bVar.Qiu.setDrawableWidth(view.getResources().getDimensionPixelSize(R.dimen.ij));
                        bVar.Qit.setTag(bVar);
                        bVar.Qix.setTag(Long.valueOf(bVar.Qir));
                        bVar.Qit.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.ui.conversation.a.m.b.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(38816);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MassSightBanner$MassSightViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                b bVar2 = (b) view.getTag();
                                Log.i("MicroMsg.MassSightBanner", "on click, massSendId %d, failed %B", Long.valueOf(bVar2.Qir), Boolean.valueOf(bVar2.Qis));
                                if (bVar2.Qis) {
                                    u.AL(bVar2.Qir);
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MassSightBanner$MassSightViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(38816);
                            }
                        });
                        bVar.Qix.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.ui.conversation.a.m.b.AnonymousClass2 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(38817);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MassSightBanner$MassSightViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                long longValue = ((Long) view.getTag()).longValue();
                                Log.i("MicroMsg.MassSightBanner", "on click cancel, massSendId %d", Long.valueOf(longValue));
                                g.aAk().postToWorker(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004c: INVOKE  
                                      (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x0043: INVOKE  (r3v2 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.kernel.g.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
                                      (wrap: com.tencent.mm.modelvideo.m$5 : 0x0049: CONSTRUCTOR  (r4v4 com.tencent.mm.modelvideo.m$5) = 
                                      (wrap: com.tencent.mm.modelvideo.m : 0x003f: INVOKE  (r2v2 com.tencent.mm.modelvideo.m) =  type: STATIC call: com.tencent.mm.modelvideo.o.bhp():com.tencent.mm.modelvideo.m)
                                      (r0v3 'longValue' long)
                                     call: com.tencent.mm.modelvideo.m.5.<init>(com.tencent.mm.modelvideo.m, long):void type: CONSTRUCTOR)
                                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.ui.conversation.a.m.b.2.onClick(android.view.View):void, file: classes5.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: CONSTRUCTOR  (r4v4 com.tencent.mm.modelvideo.m$5) = 
                                      (wrap: com.tencent.mm.modelvideo.m : 0x003f: INVOKE  (r2v2 com.tencent.mm.modelvideo.m) =  type: STATIC call: com.tencent.mm.modelvideo.o.bhp():com.tencent.mm.modelvideo.m)
                                      (r0v3 'longValue' long)
                                     call: com.tencent.mm.modelvideo.m.5.<init>(com.tencent.mm.modelvideo.m, long):void type: CONSTRUCTOR in method: com.tencent.mm.ui.conversation.a.m.b.2.onClick(android.view.View):void, file: classes5.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 14 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.modelvideo.m, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 20 more
                                    */
                                /*
                                    this = this;
                                    r7 = 38817(0x97a1, float:5.4394E-41)
                                    com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
                                    java.lang.String r0 = "com/tencent/mm/ui/conversation/banner/MassSightBanner$MassSightViewHolder$2"
                                    java.lang.String r1 = "android/view/View$OnClickListener"
                                    java.lang.String r2 = "onClick"
                                    java.lang.String r3 = "(Landroid/view/View;)V"
                                    com.tencent.mm.hellhoundlib.b.b r4 = new com.tencent.mm.hellhoundlib.b.b
                                    r4.<init>()
                                    r4.bm(r9)
                                    java.lang.Object[] r5 = r4.axR()
                                    r4 = r8
                                    com.tencent.mm.hellhoundlib.a.a.b(r0, r1, r2, r3, r4, r5)
                                    java.lang.Object r0 = r9.getTag()
                                    java.lang.Long r0 = (java.lang.Long) r0
                                    long r0 = r0.longValue()
                                    java.lang.String r2 = "MicroMsg.MassSightBanner"
                                    java.lang.String r3 = "on click cancel, massSendId %d"
                                    r4 = 1
                                    java.lang.Object[] r4 = new java.lang.Object[r4]
                                    r5 = 0
                                    java.lang.Long r6 = java.lang.Long.valueOf(r0)
                                    r4[r5] = r6
                                    com.tencent.mm.sdk.platformtools.Log.i(r2, r3, r4)
                                    com.tencent.mm.modelvideo.m r2 = com.tencent.mm.modelvideo.o.bhp()
                                    com.tencent.mm.sdk.platformtools.MMHandlerThread r3 = com.tencent.mm.kernel.g.aAk()
                                    com.tencent.mm.modelvideo.m$5 r4 = new com.tencent.mm.modelvideo.m$5
                                    r4.<init>(r0)
                                    r3.postToWorker(r4)
                                    java.lang.String r0 = "com/tencent/mm/ui/conversation/banner/MassSightBanner$MassSightViewHolder$2"
                                    java.lang.String r1 = "android/view/View$OnClickListener"
                                    java.lang.String r2 = "onClick"
                                    java.lang.String r3 = "(Landroid/view/View;)V"
                                    com.tencent.mm.hellhoundlib.a.a.a(r8, r0, r1, r2, r3)
                                    com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.a.m.b.AnonymousClass2.onClick(android.view.View):void");
                            }
                        });
                    } else {
                        Log.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", Long.valueOf(bVar.Qir), Integer.valueOf(i4));
                    }
                    o.bhj();
                    String Qw = t.Qw(sVar.getFileName());
                    o.bhj();
                    String Qx = t.Qx(sVar.getFileName());
                    i bcR = q.bcR();
                    float density = com.tencent.mm.cb.a.getDensity(view.getContext());
                    view.getContext();
                    bVar.Qiu.setThumbBmp(bcR.a(Qx, density, -1));
                    if (i4 > 3) {
                        bVar.Qiu.clear();
                        bVar.Qiv.setVisibility(0);
                    } else {
                        bVar.Qiu.e(Qw, false, 0);
                        bVar.Qiv.setVisibility(8);
                    }
                    a(bVar, sVar);
                    mVar.Qip.put(Long.valueOf(sVar.jqz), bVar);
                }
            }
            AppMethodBeat.o(38818);
            return i2;
        }

        public static void a(b bVar, s sVar) {
            boolean z = true;
            AppMethodBeat.i(38819);
            Log.v("MicroMsg.MassSightBanner", "info status %d", Integer.valueOf(sVar.status));
            if (sVar.status == 198 || sVar.status == 197 || sVar.status == 196) {
                bVar.krF.setVisibility(4);
                bVar.Qiw.setVisibility(0);
                bVar.Qix.setEnabled(true);
                bVar.Qis = true;
                AppMethodBeat.o(38819);
                return;
            }
            float f2 = ((float) sVar.jqP) / ((float) sVar.iKP);
            bVar.krF.setVisibility(0);
            bVar.Qiw.setVisibility(4);
            bVar.krF.setProgress((int) (((float) bVar.krF.getMax()) * f2));
            ImageButton imageButton = bVar.Qix;
            if (Float.compare(0.99f, f2) <= 0) {
                z = false;
            }
            imageButton.setEnabled(z);
            bVar.Qis = false;
            AppMethodBeat.o(38819);
        }

        public final void run() {
            AppMethodBeat.i(38820);
            m mVar = this.Qiq.get();
            if (mVar == null) {
                Log.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
                AppMethodBeat.o(38820);
                return;
            }
            int childCount = mVar.mContainer.getChildCount();
            mVar.Qip.clear();
            HashSet hashSet = new HashSet();
            for (s sVar : this.Qiz) {
                hashSet.add(Long.valueOf(sVar.jqz));
            }
            for (s sVar2 : this.QiA) {
                hashSet.add(Long.valueOf(sVar2.jqz));
            }
            int size = hashSet.size();
            int a2 = a("update fail", mVar, this.QiA, a("update unfinish", mVar, this.Qiz, 0, childCount, size), childCount, size);
            for (int i2 = a2; i2 < childCount; i2++) {
                mVar.mContainer.removeViewAt(a2);
            }
            AppMethodBeat.o(38820);
        }
    }

    @Override // com.tencent.mm.modelvideo.t.a
    public final void a(t.a.C0460a aVar) {
        AppMethodBeat.i(38824);
        String str = aVar.fileName;
        Long l = this.Qio.get(str);
        if (l == null) {
            Log.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", str);
            if (Util.nullAs(str, "").startsWith("DELETE_")) {
                updateStatus();
            }
            AppMethodBeat.o(38824);
            return;
        }
        b bVar = this.Qip.get(l);
        if (bVar == null) {
            Log.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", l);
            AppMethodBeat.o(38824);
            return;
        }
        s QN = u.QN(str);
        if (QN == null) {
            Log.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", str, l);
            AppMethodBeat.o(38824);
        } else if (QN.status == 199) {
            Log.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", str, l);
            updateStatus();
            AppMethodBeat.o(38824);
        } else {
            c.a(bVar, QN);
            AppMethodBeat.o(38824);
        }
    }
}
