package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CheckBox;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.z;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@com.tencent.mm.ui.chatting.d.a.a(gRF = ai.class)
public class ar extends a implements z, RecordSelectTipsBar.a, ai {
    private static HashMap<Long, Integer> PsZ = new HashMap<>();
    private RecordSelectTipsBar PsK;
    private boolean PsL = false;
    private boolean PsM = true;
    private int PsN = -1;
    private int PsO = -1;
    private int PsP = -1;
    private long PsQ = -1;
    private int PsR = 0;
    private a PsS = null;
    private boolean PsT = true;
    private boolean PsU = false;
    private boolean PsV = false;
    private boolean PsW = false;
    private CopyOnWriteArraySet<Long> PsX = new CopyOnWriteArraySet<>();
    private HashMap<Long, ca> PsY = new HashMap<>();
    private View kvj;

    public ar() {
        AppMethodBeat.i(233154);
        AppMethodBeat.o(233154);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(233155);
        this.PsL = this.dom.Pwc.getBooleanExtra("key_record_msg_select", false).booleanValue();
        this.PsT = this.dom.Pwc.getBooleanExtra("key_record_msg_select_introduce", true).booleanValue();
        this.PsQ = this.dom.Pwc.getLongExtra("key_record_select_min_msg_id", -1);
        this.PsR = this.dom.Pwc.getIntExtra("key_record_select_msg_num", 0);
        ArrayList<String> stringArrayList = this.dom.Pwc.getStringArrayList("key_record_select_msg_black_list");
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                this.PsX.add(Long.valueOf(Util.getLong(it.next(), 0)));
            }
        }
        Log.i("MicroMsg.recordSelect.RecordSelectComponent", "isRecordSelect:%s showIntroduceView:%s lastSelectMinMsgId:%s lastSelectMsgNum:%s cancelSelectMsgSet:%s", Boolean.valueOf(this.PsL), Boolean.valueOf(this.PsT), Long.valueOf(this.PsQ), Integer.valueOf(this.PsR), Integer.valueOf(this.PsX.size()));
        AppMethodBeat.o(233155);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(233158);
        super.gOK();
        if (this.PsL) {
            this.dom.getListView().setOnScrollListener(null);
            this.PsM = true;
            this.PsL = false;
            this.PsU = false;
            this.PsV = false;
        }
        AppMethodBeat.o(233158);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(233160);
        super.onScrollStateChanged(absListView, i2);
        if (!this.PsL) {
            AppMethodBeat.o(233160);
            return;
        }
        if (!this.PsV && !gQO()) {
            com.tencent.mm.plugin.selectrecord.b.a.eSu().IF((long) gQS());
        }
        this.PsV = true;
        this.PsT = false;
        this.PsU = true;
        this.PsK.Xl(a((k) this.dom.bh(k.class)));
        Log.d("MicroMsg.recordSelect.RecordSelectComponent", "onScrollStateChanged ifSlide:%s", Boolean.valueOf(this.PsU));
        AppMethodBeat.o(233160);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ai
    public final boolean gQN() {
        return this.PsL;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ai
    public final boolean gQO() {
        return (this.PsQ == -1 || this.PsR == 0) ? false : true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ai
    public final boolean gQQ() {
        return this.PsM;
    }

    @Override // com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.a
    public final void eSC() {
        AppMethodBeat.i(233162);
        Log.i("MicroMsg.recordSelect.RecordSelectComponent", "click cleanAllSelect");
        k kVar = (k) this.dom.bh(k.class);
        for (Long l : kVar.gOs()) {
            kVar.Nu(l.longValue());
            this.PsX.add(l);
        }
        kVar.gOt();
        this.PsK.Xl(a(kVar));
        AppMethodBeat.o(233162);
    }

    @Override // com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.a
    public final void uo(boolean z) {
        AppMethodBeat.i(233163);
        ((k) this.dom.bh(k.class)).uo(z);
        AppMethodBeat.o(233163);
    }

    @Override // com.tencent.mm.ag.z
    public final void a(z.a aVar) {
        AppMethodBeat.i(233164);
        Log.i("MicroMsg.recordSelect.RecordSelectComponent", "failDoJob %s", aVar);
        AppMethodBeat.o(233164);
    }

    @Override // com.tencent.mm.ag.z
    public final void b(z.a aVar) {
        AppMethodBeat.i(233165);
        Log.i("MicroMsg.recordSelect.RecordSelectComponent", "doInBackground %s", aVar);
        AppMethodBeat.o(233165);
    }

    @Override // com.tencent.mm.ag.z
    public final void c(z.a aVar) {
        AppMethodBeat.i(233166);
        Log.i("MicroMsg.recordSelect.RecordSelectComponent", "requestExitSelectedMode %s", aVar);
        AppMethodBeat.o(233166);
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSC() {
        return false;
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSD() {
        return true;
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSE() {
        return false;
    }

    @Override // com.tencent.mm.ag.z
    public final void B(Bundle bundle) {
        AppMethodBeat.i(233167);
        Object[] objArr = new Object[1];
        objArr[0] = bundle != null ? bundle.toString() : BuildConfig.COMMAND;
        Log.i("MicroMsg.recordSelect.RecordSelectComponent", "doOnlySelectRecordMsg %s", objArr);
        this.PsM = false;
        this.dom.Pwc.gNh();
        AppMethodBeat.o(233167);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ai
    public final CopyOnWriteArraySet<Long> gQR() {
        return this.PsX;
    }

    public static int a(k kVar) {
        AppMethodBeat.i(233168);
        Set<Long> gOs = kVar.gOs();
        if (gOs == null) {
            AppMethodBeat.o(233168);
            return 0;
        }
        int size = gOs.size();
        AppMethodBeat.o(233168);
        return size;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ai
    public final int gQS() {
        AppMethodBeat.i(233169);
        int a2 = a((k) this.dom.bh(k.class));
        AppMethodBeat.o(233169);
        return a2;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ai
    public final void gQT() {
        AppMethodBeat.i(233170);
        if (!this.PsV && !gQO()) {
            com.tencent.mm.plugin.selectrecord.b.a.eSu().IF((long) gQS());
        }
        AppMethodBeat.o(233170);
    }

    private void a(k kVar, long j2, boolean z) {
        AppMethodBeat.i(233171);
        Pair<Boolean, Boolean> a2 = a(kVar, j2);
        Log.d("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle msgId:%s result:%s %s", Long.valueOf(j2), a2.first, a2.second);
        if (!((Boolean) a2.first).booleanValue()) {
            Log.w("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle invalid");
        } else if (((Boolean) a2.second).booleanValue()) {
            if (!kVar.gOs().contains(Long.valueOf(j2)) && !this.PsX.contains(Long.valueOf(j2))) {
                if (kVar.gOs().size() >= 99) {
                    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "handleFirstItemToggle max select msg num.");
                    AppMethodBeat.o(233171);
                    return;
                }
                kVar.Nu(j2);
                if (!z) {
                    if (!this.PsT) {
                        this.PsK.Xl(a(kVar));
                    }
                    BS(true);
                    AppMethodBeat.o(233171);
                    return;
                }
            }
        } else if (kVar.gOs().contains(Long.valueOf(j2))) {
            kVar.Nu(j2);
            if (!z) {
                if (!this.PsT) {
                    this.PsK.Xl(a(kVar));
                }
                BS(false);
                AppMethodBeat.o(233171);
                return;
            }
        }
        AppMethodBeat.o(233171);
    }

    private void BS(boolean z) {
        AppMethodBeat.i(233172);
        if (this.PsU) {
            this.PsK.performHapticFeedback(0, 2);
            if (z) {
                com.tencent.mm.plugin.selectrecord.b.a.eSu().eSw();
                AppMethodBeat.o(233172);
                return;
            }
            com.tencent.mm.plugin.selectrecord.b.a.eSu().eSx();
        }
        AppMethodBeat.o(233172);
    }

    private ca Ny(long j2) {
        AppMethodBeat.i(233173);
        if (this.PsY.containsKey(Long.valueOf(j2))) {
            ca caVar = this.PsY.get(Long.valueOf(j2));
            AppMethodBeat.o(233173);
            return caVar;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
        this.PsY.put(Long.valueOf(j2), Hb);
        AppMethodBeat.o(233173);
        return Hb;
    }

    private Pair<Boolean, Boolean> a(k kVar, long j2) {
        AppMethodBeat.i(233174);
        if (kVar == null) {
            Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine adapterComponent is null");
            Boolean bool = Boolean.FALSE;
            Pair<Boolean, Boolean> pair = new Pair<>(bool, bool);
            AppMethodBeat.o(233174);
            return pair;
        } else if (this.PsK.getHeight() <= 0) {
            Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine recordSelectTipsBar height <= 0");
            Boolean bool2 = Boolean.FALSE;
            Pair<Boolean, Boolean> pair2 = new Pair<>(bool2, bool2);
            AppMethodBeat.o(233174);
            return pair2;
        } else {
            View zh = kVar.zh(j2);
            if (zh != null) {
                if (this.PsN <= 0) {
                    int[] iArr = new int[2];
                    this.PsK.getLocationOnScreen(iArr);
                    this.PsN = iArr[1] + this.PsK.getHeight();
                    this.PsO = com.tencent.mm.cb.a.aH(this.dom.Pwc.getContext(), R.dimen.cl);
                    this.PsP = com.tencent.mm.cb.a.fromDPToPix((Context) this.dom.Pwc.getContext(), 24);
                    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine(%s, %s) recordSelectTipsBarBottomLoctaion:%s", Integer.valueOf(iArr[1]), Integer.valueOf(this.PsK.getHeight()), Integer.valueOf(this.PsN));
                } else {
                    int[] iArr2 = new int[2];
                    this.PsK.getLocationOnScreen(iArr2);
                    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine2(%s, %s)", Integer.valueOf(iArr2[1]), Integer.valueOf(this.PsK.getHeight()));
                }
                CheckBox checkBox = (CheckBox) zh.findViewById(R.id.aue);
                if (checkBox == null) {
                    Log.e("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine, checkBox is null??");
                    Boolean bool3 = Boolean.FALSE;
                    Pair<Boolean, Boolean> pair3 = new Pair<>(bool3, bool3);
                    AppMethodBeat.o(233174);
                    return pair3;
                }
                int[] iArr3 = new int[2];
                checkBox.getLocationOnScreen(iArr3);
                int i2 = (iArr3[1] + this.PsP) - this.PsN;
                Log.d("MicroMsg.recordSelect.RecordSelectComponent", "view(%s, %s) recordSelectTipsBar(%s) viewTopHeight:%s marginTop:%s", Integer.valueOf(iArr3[1]), Integer.valueOf(this.PsP), Integer.valueOf(this.PsN), Integer.valueOf(this.PsO), Integer.valueOf(i2));
                if (i2 > this.PsO) {
                    Boolean bool4 = Boolean.TRUE;
                    Pair<Boolean, Boolean> pair4 = new Pair<>(bool4, bool4);
                    AppMethodBeat.o(233174);
                    return pair4;
                }
                Pair<Boolean, Boolean> pair5 = new Pair<>(Boolean.TRUE, Boolean.FALSE);
                AppMethodBeat.o(233174);
                return pair5;
            }
            Log.i("MicroMsg.recordSelect.RecordSelectComponent", "ifExceedBaseLine view is null, msgId:%s", Long.valueOf(j2));
            Boolean bool5 = Boolean.FALSE;
            Pair<Boolean, Boolean> pair6 = new Pair<>(bool5, bool5);
            AppMethodBeat.o(233174);
            return pair6;
        }
    }

    static {
        AppMethodBeat.i(233175);
        AppMethodBeat.o(233175);
    }

    static class a {
        long Ptd = -1;
        long Pte = -1;

        a() {
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(233156);
        if (this.PsL) {
            if (this.PsK == null) {
                l.a(this.dom.Pwc, (int) R.id.j85);
                this.PsK = (RecordSelectTipsBar) this.dom.findViewById(R.id.gxj);
                this.PsK.setIRecordSelectCallback(this);
            }
            k kVar = (k) this.dom.bh(k.class);
            kVar.i(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.ar.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(233152);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!ar.this.PsV && !ar.this.gQO()) {
                        com.tencent.mm.plugin.selectrecord.b.a.eSu().IF((long) ar.this.gQS());
                    }
                    ar.this.PsT = false;
                    ar.this.PsV = true;
                    k kVar = (k) ar.this.dom.bh(k.class);
                    long longValue = ((Long) view.getTag()).longValue();
                    if (kVar.gOs().contains(Long.valueOf(longValue))) {
                        ar.this.PsX.add(Long.valueOf(longValue));
                        com.tencent.mm.plugin.selectrecord.b.a.eSu().CWV++;
                    } else {
                        ar.this.PsX.remove(Long.valueOf(longValue));
                        com.tencent.mm.plugin.selectrecord.b.a.eSu().CWU++;
                    }
                    if (!kVar.Nu(longValue)) {
                        com.tencent.mm.plugin.selectrecord.b.a.eSu().CWP++;
                    }
                    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "setOnEditModeItemClickListener msgId:%s", Long.valueOf(longValue));
                    ar.this.PsK.Xl(ar.a(kVar));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/RecordSelectComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(233152);
                }
            });
            kVar.gOu();
            kVar.gOv();
            kVar.gOt();
            if (gQO()) {
                ((k) this.dom.bh(k.class)).a(this.PsQ, true, d.a.ACTION_POSITION);
            }
        }
        AppMethodBeat.o(233156);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(233157);
        if (this.PsL) {
            com.tencent.mm.plugin.backup.h.d.cgP().cgS();
            this.PsK.post(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.ar.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(233149);
                    ar.this.dom.Pwe.amn(ar.this.PsK.getHeight());
                    AppMethodBeat.o(233149);
                }
            });
        }
        AppMethodBeat.o(233157);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(233159);
        if (!this.PsL) {
            AppMethodBeat.o(233159);
        } else if (i3 == 0) {
            Log.w("MicroMsg.recordSelect.RecordSelectComponent", "onScroll visibleItemCount == 0");
            AppMethodBeat.o(233159);
        } else {
            k kVar = (k) this.dom.bh(k.class);
            final a aVar = new a();
            int headerViewsCount = this.dom.getHeaderViewsCount();
            ca amt = kVar.amt(i2 - headerViewsCount);
            if (amt != null) {
                aVar.Ptd = amt.field_msgId;
            }
            ca amt2 = ((k) this.dom.bh(k.class)).amt((i2 + 1) - headerViewsCount);
            if (amt2 != null) {
                aVar.Pte = amt2.field_msgId;
            }
            if (this.PsS == null) {
                z = true;
            } else {
                if (this.kvj == null) {
                    Log.i("MicroMsg.recordSelect.RecordSelectComponent", "onScroll totalItemCount:%s headerViewsCount:%s footerViewCount:%s totalCount:%s", Integer.valueOf(i4), Integer.valueOf(this.dom.getHeaderViewsCount()), Integer.valueOf(this.dom.cda()), Integer.valueOf(kVar.cZm()));
                    if (this.PsT && (i4 - this.dom.getHeaderViewsCount()) - this.dom.cda() == kVar.cZm()) {
                        ca amt3 = kVar.amt(0);
                        if (amt3.field_msgId != 0) {
                            Pair<Boolean, Boolean> a2 = a(kVar, amt3.field_msgId);
                            if (!((Boolean) a2.first).booleanValue() || !((Boolean) a2.second).booleanValue()) {
                                View zh = kVar.zh(amt3.field_msgId);
                                if (zh != null) {
                                    CheckBox checkBox = (CheckBox) zh.findViewById(R.id.aue);
                                    Object[] objArr = new Object[1];
                                    objArr[0] = Boolean.valueOf(checkBox == null);
                                    Log.d("MicroMsg.recordSelect.RecordSelectComponent", "checkBox is null(%s)", objArr);
                                    if (checkBox == null) {
                                        this.PsT = false;
                                    }
                                }
                            } else {
                                this.PsT = false;
                            }
                        }
                    }
                    if (this.PsT) {
                        h.RTc.aV(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01b2: INVOKE  
                              (wrap: com.tencent.f.i : 0x01ab: SGET  (r2v6 com.tencent.f.i) =  com.tencent.f.h.RTc com.tencent.f.i)
                              (wrap: com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar$2 : 0x01af: CONSTRUCTOR  (r6v4 com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar$2) = 
                              (wrap: com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar : 0x01a9: IGET  (r1v20 com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar) = (r12v0 'this' com.tencent.mm.ui.chatting.d.ar A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.ui.chatting.d.ar.PsK com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar)
                             call: com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.2.<init>(com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar):void type: CONSTRUCTOR)
                             type: INTERFACE call: com.tencent.f.i.aV(java.lang.Runnable):com.tencent.f.i.d in method: com.tencent.mm.ui.chatting.d.ar.onScroll(android.widget.AbsListView, int, int, int):void, file: classes5.dex
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
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01af: CONSTRUCTOR  (r6v4 com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar$2) = 
                              (wrap: com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar : 0x01a9: IGET  (r1v20 com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar) = (r12v0 'this' com.tencent.mm.ui.chatting.d.ar A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.ui.chatting.d.ar.PsK com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar)
                             call: com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.2.<init>(com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar):void type: CONSTRUCTOR in method: com.tencent.mm.ui.chatting.d.ar.onScroll(android.widget.AbsListView, int, int, int):void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 36 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 42 more
                            */
                        /*
                        // Method dump skipped, instructions count: 1086
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.ar.onScroll(android.widget.AbsListView, int, int, int):void");
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:41:0x0235  */
                    /* JADX WARNING: Removed duplicated region for block: B:43:0x0249  */
                    @Override // com.tencent.mm.ui.chatting.d.b.ai
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final boolean gQP() {
                        /*
                        // Method dump skipped, instructions count: 994
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.ar.gQP():boolean");
                    }
                }
