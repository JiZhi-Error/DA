package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sight.encode.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public class MainSightForwardContainerView extends RelativeLayout implements AdapterView.OnItemClickListener, a {
    private boolean DpA;
    private MediaPlayer DpB;
    public MainSightSelectContactView Dpj;
    public SightCameraView Dpk;
    private b Dpl;
    public View Dpm;
    public View Dpn;
    public View Dpo;
    private Dialog Dpp;
    private boolean Dpq;
    public String Dpr;
    private boolean Dps;
    public String Dpt;
    public float Dpu;
    private b Dpv;
    private boolean Dpw;
    public MMFragmentActivity Dpx;
    private boolean Dpy;
    private IListener Dpz;
    private int atU;
    private boolean gNC;
    private boolean mIsPause;
    public View zfy;

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(28713);
        this.Dpp = null;
        this.gNC = false;
        this.Dpq = true;
        this.Dpr = "";
        this.Dps = false;
        this.Dpt = "";
        this.atU = 1;
        this.Dpu = 1.0f;
        this.mIsPause = false;
        this.Dpv = new b();
        this.Dpw = false;
        this.Dpy = false;
        this.Dpz = new IListener<uw>() {
            /* class com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.AnonymousClass5 */

            {
                AppMethodBeat.i(161438);
                this.__eventId = uw.class.getName().hashCode();
                AppMethodBeat.o(161438);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(uw uwVar) {
                AppMethodBeat.i(28710);
                uw uwVar2 = uwVar;
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(hashCode());
                objArr[1] = Integer.valueOf(uwVar2.ebg.type);
                objArr[2] = Boolean.valueOf(MainSightForwardContainerView.this.Dpp != null);
                objArr[3] = Boolean.valueOf(MainSightForwardContainerView.this.DpA);
                Log.i("MicroMsg.MainSightContainerView", "on sight send result back[%d], type %d, waitSend %B, isForSns %B", objArr);
                switch (uwVar2.ebg.type) {
                    case 0:
                        MainSightForwardContainerView.this.Dpy = false;
                        if (!MainSightForwardContainerView.this.DpA) {
                            if (!uwVar2.ebg.ebi) {
                                MainSightForwardContainerView.this.postDelayed(new Runnable() {
                                    /* class com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.AnonymousClass5.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(28709);
                                        MainSightForwardContainerView.this.eWd();
                                        AppMethodBeat.o(28709);
                                    }
                                }, 500);
                                break;
                            } else {
                                h.INSTANCE.a(11443, 1, 4, 0);
                                MainSightForwardContainerView.this.rX(true);
                                break;
                            }
                        } else {
                            if (uwVar2.ebg.ebi) {
                                h.INSTANCE.a(11443, 3, 4, 0);
                            }
                            MainSightForwardContainerView.this.removeListener();
                            break;
                        }
                }
                AppMethodBeat.o(28710);
                return false;
            }
        };
        this.DpA = false;
        AppMethodBeat.o(28713);
    }

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void removeListener() {
        AppMethodBeat.i(28714);
        EventCenter.instance.removeListener(this.Dpz);
        AppMethodBeat.o(28714);
    }

    @Override // com.tencent.mm.plugin.sight.encode.ui.a
    public final void eWd() {
        boolean z = true;
        AppMethodBeat.i(28715);
        Log.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", this.Dpt, Boolean.valueOf(this.Dpq), Boolean.valueOf(this.gNC));
        if (!this.Dpk.isPlaying()) {
            this.Dpq = true;
        }
        this.Dpk.ce(this.Dpt, this.Dpq);
        if (!this.Dpq) {
            uI(false);
        } else {
            uI(true);
        }
        this.gNC = true;
        if (this.Dpq) {
            z = false;
        }
        this.Dpq = z;
        AppMethodBeat.o(28715);
    }

    @Override // com.tencent.mm.plugin.sight.encode.ui.a
    public final boolean Zx() {
        return !this.Dpq;
    }

    public void setIsMute(boolean z) {
        AppMethodBeat.i(28716);
        if (this.Dpk == null) {
            AppMethodBeat.o(28716);
            return;
        }
        this.Dpk.setIsMute(z);
        AppMethodBeat.o(28716);
    }

    public final void rX(boolean z) {
        AppMethodBeat.i(28717);
        if (this.Dps) {
            AppMethodBeat.o(28717);
            return;
        }
        this.Dps = true;
        Util.hideVKB(this);
        this.gNC = false;
        this.Dpq = true;
        Log.d("MicroMsg.MainSightContainerView", "dismiss sight view");
        this.Dpy = false;
        this.Dpk.eWq();
        if (this.Dpl != null && z) {
            this.Dpl.eWf();
        }
        if (this.Dpj != null) {
            MainSightSelectContactView mainSightSelectContactView = this.Dpj;
            mainSightSelectContactView.Dps = true;
            Util.hideVKB(mainSightSelectContactView);
            mainSightSelectContactView.DpW.eWl();
            mainSightSelectContactView.Dqg.clear();
            mainSightSelectContactView.Dqf.clear();
            mainSightSelectContactView.mListView.setAdapter((ListAdapter) null);
            mainSightSelectContactView.mListView.clearAnimation();
            mainSightSelectContactView.setVisibility(8);
        }
        setCameraShadowAlpha(0.85f);
        eWe();
        uI(false);
        this.Dpr = "";
        removeListener();
        AppMethodBeat.o(28717);
    }

    public final void uI(boolean z) {
        AppMethodBeat.i(28718);
        if (this.Dpw == z) {
            AppMethodBeat.o(28718);
            return;
        }
        this.Dpw = z;
        if (!z) {
            this.Dpn.setVisibility(8);
            this.zfy.setVisibility(8);
            AppMethodBeat.o(28718);
        } else if (this.Dpn.getVisibility() == 0) {
            AppMethodBeat.o(28718);
        } else {
            this.Dpk.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(28708);
                    if (!MainSightForwardContainerView.this.Dpw || (MainSightForwardContainerView.this.Dpj != null && MainSightForwardContainerView.this.Dpj.DpW.eWi())) {
                        MainSightForwardContainerView.this.Dpw = false;
                        AppMethodBeat.o(28708);
                        return;
                    }
                    MainSightForwardContainerView.this.Dpn.setVisibility(0);
                    if (!(MainSightForwardContainerView.this.Dpj == null || MainSightForwardContainerView.this.Dpj.eWp() || MainSightForwardContainerView.this.zfy.getVisibility() == 0)) {
                        MainSightForwardContainerView.this.zfy.setVisibility(0);
                        MainSightForwardContainerView.this.zfy.startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.this.Dpx, R.anim.br));
                    }
                    AppMethodBeat.o(28708);
                }
            }, 100);
            AppMethodBeat.o(28718);
        }
    }

    public void setIMainSightViewCallback(b bVar) {
        this.Dpl = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        boolean contains;
        a anH;
        AppMethodBeat.i(28719);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        int i3 = i2 - 1;
        if (MainSightSelectContactView.XI(i3) && this.gNC) {
            eWd();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28719);
        } else if (c.aNA(this.Dpj.vg(i3))) {
            this.Dpj.DpW.eWj();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28719);
        } else if (c.aNz(this.Dpj.vg(i3))) {
            if (c.DpH) {
                this.Dpy = true;
                this.Dpk.eWq();
                MMFragmentActivity mMFragmentActivity = this.Dpx;
                String aFl = e.aFl(this.Dpt);
                String str = this.Dpt;
                String str2 = this.Dpr;
                Log.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", str, aFl);
                if (!s.YS(aFl)) {
                    try {
                        BitmapUtil.saveBitmapToImage(e.az(str, 320, 240), 60, Bitmap.CompressFormat.JPEG, aFl, true);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SightRecorderHelper", e2, "", new Object[0]);
                        Log.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("KSightPath", str);
                intent.putExtra("KSightThumbPath", aFl);
                intent.putExtra("sight_md5", str2);
                intent.putExtra("KSightDraftEntrance", false);
                intent.putExtra("Ksnsupload_source", 0);
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", Util.nowSecond());
                c.b(mMFragmentActivity, "sns", ".ui.SightUploadUI", intent, 5985);
                if (this.DpA) {
                    h.INSTANCE.a(11442, 3, 3);
                } else {
                    h.INSTANCE.a(11442, 1, 3);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28719);
        } else {
            Log.d("MicroMsg.MainSightContainerView", "on item click Item : %d", Integer.valueOf(i3));
            MainSightSelectContactView mainSightSelectContactView = this.Dpj;
            if (i3 >= 0 && i3 <= mainSightSelectContactView.DpY.getCount() && (anH = mainSightSelectContactView.DpY.getItem(i3)) != null) {
                if (mainSightSelectContactView.Dqg.contains(anH.contact.field_username)) {
                    mainSightSelectContactView.Dqg.remove(anH.contact.field_username);
                } else {
                    mainSightSelectContactView.Dqg.add(anH.contact.field_username);
                }
                c.DpH = mainSightSelectContactView.Dqg.isEmpty();
                c.DpI = !mainSightSelectContactView.Dqg.isEmpty();
            }
            MainSightSelectContactView mainSightSelectContactView2 = this.Dpj;
            if (mainSightSelectContactView2.DpY != null) {
                mainSightSelectContactView2.DpY.notifyDataSetChanged();
            }
            if (!Zx()) {
                eWd();
            } else if (this.Dpj.eWp()) {
                if (this.zfy.getVisibility() == 0) {
                    this.zfy.setVisibility(8);
                    this.zfy.startAnimation(AnimationUtils.loadAnimation(this.Dpx, R.anim.bs));
                }
            } else if (this.zfy.getVisibility() != 0) {
                this.zfy.setVisibility(0);
                this.zfy.startAnimation(AnimationUtils.loadAnimation(this.Dpx, R.anim.br));
            }
            if (this.Dpj.DpW.eWi()) {
                MainSightSelectContactView mainSightSelectContactView3 = this.Dpj;
                if (mainSightSelectContactView3.DpY.getItem(i3) == null) {
                    contains = false;
                } else if (mainSightSelectContactView3.DpY.getItem(i3).contact == null) {
                    contains = false;
                } else {
                    contains = mainSightSelectContactView3.Dqg.contains(mainSightSelectContactView3.DpY.getItem(i3).contact.field_username);
                }
                if (contains) {
                    this.Dpj.DpW.eWj();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28719);
        }
    }

    public final void eWg() {
        boolean z;
        AppMethodBeat.i(28720);
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.Dpp == null);
        Log.i("MicroMsg.MainSightContainerView", "do send to friend, loadingDialog null %B", objArr);
        if (Util.isNullOrNil(this.Dpt) || this.Dpj.eWp()) {
            AppMethodBeat.o(28720);
            return;
        }
        final LinkedList<String> selectedContact = this.Dpj.getSelectedContact();
        h.INSTANCE.a(11443, 1, 3, Integer.valueOf(selectedContact.size()));
        AnonymousClass6 r3 = new b.a() {
            /* class com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.sight.encode.a.b.a
            public final void onError(int i2) {
                AppMethodBeat.i(28711);
                if (selectedContact.size() <= 1 || -1 == i2) {
                    com.tencent.mm.ui.base.h.cD(MainSightForwardContainerView.this.getContext(), MainSightForwardContainerView.this.getContext().getString(R.string.gkm));
                }
                AppMethodBeat.o(28711);
            }
        };
        if (selectedContact.size() == 1) {
            b bVar = this.Dpv;
            String str = this.Dpt;
            int i2 = this.atU;
            String str2 = this.Dpr;
            String str3 = selectedContact.get(0);
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                b.a(r3, -1);
            } else if (Util.isNullOrNil(str3)) {
                Log.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                b.a(r3, -1);
            } else if (!s.YS(str) || s.boW(str) <= 0) {
                Log.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                com.tencent.mm.ui.base.h.cD(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.h12));
            } else {
                String bhK = s.bhK(str);
                Log.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", str2, bhK);
                if (!Util.nullAs(str2, "").equals(bhK)) {
                    Log.e("MicroMsg.SightRecorderHelper", "error md5, return");
                    b.a(r3, -1);
                } else {
                    g.aAi();
                    if (g.aAk().postToWorker(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01b5: INVOKE  (r0v63 int) = 
                          (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x01ac: INVOKE  (r6v9 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.kernel.g.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
                          (wrap: com.tencent.mm.plugin.sight.encode.a.b$3 : 0x01b2: CONSTRUCTOR  (r0v62 com.tencent.mm.plugin.sight.encode.a.b$3) = 
                          (r1v25 'bVar' com.tencent.mm.plugin.sight.encode.a.b)
                          (r2v13 'str3' java.lang.String)
                          (r3v4 'r3' com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$6)
                          (r4v15 'str' java.lang.String)
                          (r5v9 'i2' int)
                         call: com.tencent.mm.plugin.sight.encode.a.b.3.<init>(com.tencent.mm.plugin.sight.encode.a.b, java.lang.String, com.tencent.mm.plugin.sight.encode.a.b$a, java.lang.String, int):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.eWg():void, file: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:128)
                        	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:56)
                        	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:45)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:141)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01b2: CONSTRUCTOR  (r0v62 com.tencent.mm.plugin.sight.encode.a.b$3) = 
                          (r1v25 'bVar' com.tencent.mm.plugin.sight.encode.a.b)
                          (r2v13 'str3' java.lang.String)
                          (r3v4 'r3' com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$6)
                          (r4v15 'str' java.lang.String)
                          (r5v9 'i2' int)
                         call: com.tencent.mm.plugin.sight.encode.a.b.3.<init>(com.tencent.mm.plugin.sight.encode.a.b, java.lang.String, com.tencent.mm.plugin.sight.encode.a.b$a, java.lang.String, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.eWg():void, file: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 41 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sight.encode.a.b, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 47 more
                        */
                    /*
                    // Method dump skipped, instructions count: 692
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.eWg():void");
                }

                /* access modifiers changed from: protected */
                public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                    AppMethodBeat.i(28723);
                    super.onLayout(z, i2, i3, i4, i5);
                    if (z && !this.Dps && this.Dpj != null) {
                        Log.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                        this.Dpj.eWo();
                    }
                    AppMethodBeat.o(28723);
                }

                public void setIsForSns(boolean z) {
                    this.DpA = z;
                }

                @Override // com.tencent.mm.plugin.sight.encode.ui.a
                @TargetApi(11)
                public void setCameraShadowAlpha(float f2) {
                    AppMethodBeat.i(28724);
                    float min = Math.min(1.0f, Math.max(0.0f, f2));
                    if (d.oD(11)) {
                        this.Dpm.setAlpha(min);
                    } else {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(min, min);
                        alphaAnimation.setDuration(0);
                        alphaAnimation.setFillAfter(true);
                        this.Dpm.startAnimation(alphaAnimation);
                    }
                    Log.d("MicroMsg.MainSightContainerView", "set alpha: %f", Float.valueOf(min));
                    if (min <= 0.0f) {
                        this.Dpm.setVisibility(8);
                        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation2.setDuration(500);
                        this.Dpm.startAnimation(alphaAnimation2);
                        AppMethodBeat.o(28724);
                        return;
                    }
                    this.Dpm.setVisibility(0);
                    AppMethodBeat.o(28724);
                }

                @Override // com.tencent.mm.plugin.sight.encode.ui.a
                public final void eWe() {
                    AppMethodBeat.i(28725);
                    this.Dpo.setVisibility(8);
                    AppMethodBeat.o(28725);
                }

                @Override // com.tencent.mm.plugin.sight.encode.ui.a
                public final void uH(boolean z) {
                    AppMethodBeat.i(28726);
                    if (z) {
                        this.Dpo.setVisibility(0);
                        setIsMute(true);
                        AppMethodBeat.o(28726);
                        return;
                    }
                    eWe();
                    setIsMute(Zx());
                    AppMethodBeat.o(28726);
                }

                @Override // com.tencent.mm.plugin.sight.encode.ui.a
                public final void eWb() {
                    AppMethodBeat.i(28727);
                    this.Dpk.setVisibility(0);
                    uI(true);
                    AppMethodBeat.o(28727);
                }

                @Override // com.tencent.mm.plugin.sight.encode.ui.a
                public final void eWc() {
                    AppMethodBeat.i(28728);
                    this.Dpk.setVisibility(4);
                    uI(false);
                    AppMethodBeat.o(28728);
                }

                @Override // com.tencent.mm.plugin.sight.encode.ui.a
                public int getViewHeight() {
                    AppMethodBeat.i(28729);
                    int height = getHeight();
                    if (height <= 0) {
                        int i2 = getResources().getDisplayMetrics().heightPixels;
                        AppMethodBeat.o(28729);
                        return i2;
                    }
                    AppMethodBeat.o(28729);
                    return height;
                }

                public final void onPause() {
                    AppMethodBeat.i(28721);
                    if (this.Dpy) {
                        AppMethodBeat.o(28721);
                        return;
                    }
                    this.Dpk.setVisibility(0);
                    uI(false);
                    this.Dpk.eWq();
                    this.mIsPause = true;
                    AppMethodBeat.o(28721);
                }

                public final void onResume() {
                    boolean z;
                    AppMethodBeat.i(28722);
                    if (!this.Dps) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        EventCenter.instance.removeListener(this.Dpz);
                        EventCenter.instance.addListener(this.Dpz);
                    } else {
                        removeListener();
                    }
                    if (this.mIsPause) {
                        eWd();
                        this.mIsPause = false;
                    }
                    AppMethodBeat.o(28722);
                }
            }
