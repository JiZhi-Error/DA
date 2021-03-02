package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.b;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.k.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.v;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.d.a.a(gRF = v.class)
public class y extends a implements MStorageEx.IOnStorageChange, v {
    private a Pqc;
    private HashSet<String> Pqd = new HashSet<>();
    private volatile ca Pqe;
    private k Pqf;
    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.mm.ui.chatting.d.y.AnonymousClass3 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(35339);
            super.handleMessage(message);
            if (message.what == 1) {
                am amVar = (am) y.this.dom.bh(am.class);
                boolean z = amVar.gRb() || amVar.gRa();
                y.this.dom.Pwe.setIsBottomShowAll(false);
                y.this.dom.Pwe.setBottomViewVisible(true);
                if (z) {
                    y.this.dom.Pwe.By(true);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("load_bottom", true);
                    y.this.dom.Pwe.bs(bundle);
                }
                Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", Boolean.valueOf(z), y.this.dom.getTalkerUserName());
                AppMethodBeat.o(35339);
            } else if (message.what == 2) {
                y.this.dom.Pwe.setIsBottomShowAll(true);
                y.this.dom.Pwe.setBottomViewVisible(true);
                y.this.mMainHandler.postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.y.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(35338);
                        ((ab) y.this.dom.bh(ab.class)).gQC();
                        AppMethodBeat.o(35338);
                    }
                }, 300);
                Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", y.this.dom.getTalkerUserName());
                AppMethodBeat.o(35339);
            } else if (message.what == 4) {
                y.this.dom.Pwe.setIsBottomShowAll(false);
                y.this.dom.Pwe.setBottomViewVisible(true);
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("load_bottom", true);
                y.this.dom.Pwe.bs(bundle2);
                Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", y.this.dom.getTalkerUserName());
                AppMethodBeat.o(35339);
            } else {
                if (message.what == 8) {
                    Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
                    y.this.dom.Pwc.gNj();
                }
                AppMethodBeat.o(35339);
            }
        }
    };

    public y() {
        AppMethodBeat.i(35341);
        AppMethodBeat.o(35341);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35342);
        super.gIk();
        if (!this.dom.gRM()) {
            AppMethodBeat.o(35342);
            return;
        }
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.y.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(35336);
                long currentTimeMillis = System.currentTimeMillis();
                y.this.Pqe = ((l) g.af(l.class)).eiy().aEx(y.this.dom.getTalkerUserName());
                if (y.this.Pqe == null) {
                    AppMethodBeat.o(35336);
                    return;
                }
                Log.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), y.this.dom.getTalkerUserName(), Long.valueOf(y.this.Pqe.field_createTime));
                AppMethodBeat.o(35336);
            }
        });
        AppMethodBeat.o(35342);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35343);
        super.gIl();
        if (!this.dom.gRM()) {
            AppMethodBeat.o(35343);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ((l) g.af(l.class)).eit().add(this, g.aAk().getLooper());
        this.Pqc = new a(this, this.dom.getTalkerUserName(), (byte) 0);
        h.RTc.aX(this.Pqc);
        Log.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), this.dom.getTalkerUserName());
        AppMethodBeat.o(35343);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35344);
        super.gIn();
        if (!this.dom.gRM()) {
            AppMethodBeat.o(35344);
            return;
        }
        this.Pqc.cancel();
        ((l) g.af(l.class)).eit().remove(this);
        if (!this.Pqd.contains(this.dom.getTalkerUserName())) {
            ThreadPool.post(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: INVOKE  
                  (wrap: com.tencent.mm.as.a$1 : 0x0043: CONSTRUCTOR  (r2v0 com.tencent.mm.as.a$1) = 
                  (wrap: com.tencent.mm.as.a : 0x0037: INVOKE  (r0v11 com.tencent.mm.as.a) =  type: STATIC call: com.tencent.mm.as.a.bcg():com.tencent.mm.as.a)
                  (wrap: java.lang.String : 0x003d: INVOKE  (r1v4 java.lang.String) = 
                  (wrap: com.tencent.mm.ui.chatting.e.a : 0x003b: IGET  (r1v3 com.tencent.mm.ui.chatting.e.a) = (r4v0 'this' com.tencent.mm.ui.chatting.d.y A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.ui.chatting.d.y.dom com.tencent.mm.ui.chatting.e.a)
                 type: VIRTUAL call: com.tencent.mm.ui.chatting.e.a.getTalkerUserName():java.lang.String)
                 call: com.tencent.mm.as.a.1.<init>(com.tencent.mm.as.a, java.lang.String):void type: CONSTRUCTOR)
                  ("checkDirtyBlock")
                 type: STATIC call: com.tencent.mm.sdk.thread.ThreadPool.post(java.lang.Runnable, java.lang.String):void in method: com.tencent.mm.ui.chatting.d.y.gIn():void, file: classes4.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0043: CONSTRUCTOR  (r2v0 com.tencent.mm.as.a$1) = 
                  (wrap: com.tencent.mm.as.a : 0x0037: INVOKE  (r0v11 com.tencent.mm.as.a) =  type: STATIC call: com.tencent.mm.as.a.bcg():com.tencent.mm.as.a)
                  (wrap: java.lang.String : 0x003d: INVOKE  (r1v4 java.lang.String) = 
                  (wrap: com.tencent.mm.ui.chatting.e.a : 0x003b: IGET  (r1v3 com.tencent.mm.ui.chatting.e.a) = (r4v0 'this' com.tencent.mm.ui.chatting.d.y A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.ui.chatting.d.y.dom com.tencent.mm.ui.chatting.e.a)
                 type: VIRTUAL call: com.tencent.mm.ui.chatting.e.a.getTalkerUserName():java.lang.String)
                 call: com.tencent.mm.as.a.1.<init>(com.tencent.mm.as.a, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.ui.chatting.d.y.gIn():void, file: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 23 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.as.a, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 29 more
                */
            /*
            // Method dump skipped, instructions count: 104
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.y.gIn():void");
        }

        @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
        public final void gOK() {
            AppMethodBeat.i(35345);
            super.gOK();
            ((l) g.af(l.class)).eit().remove(this);
            b.bch().cancel();
            this.mMainHandler.removeCallbacksAndMessages(null);
            AppMethodBeat.o(35345);
        }

        @Override // com.tencent.mm.ui.chatting.d.b.v
        public final boolean gQb() {
            AppMethodBeat.i(35346);
            boolean aEf = ((l) g.af(l.class)).eit().aEf(this.dom.getTalkerUserName());
            AppMethodBeat.o(35346);
            return aEf;
        }

        @Override // com.tencent.mm.ui.chatting.d.b.v
        public final void gQc() {
            boolean z;
            int i2;
            AppMethodBeat.i(35347);
            if (this.Pqe == null) {
                Log.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", this.dom.getTalkerUserName());
                AppMethodBeat.o(35347);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c e2 = ((l) g.af(l.class)).eit().e(this.dom.getTalkerUserName(), this.Pqe.field_createTime, false);
            Object[] objArr = new Object[3];
            objArr[0] = Util.secPrint(this.Pqe.field_content);
            if (e2 == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Long.valueOf(this.Pqe.field_createTime);
            Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s", objArr);
            if (e2 == null) {
                if (this.Pqf == null) {
                    this.Pqf = (k) this.dom.bh(k.class);
                }
                int gQA = ((ab) this.dom.bh(ab.class)).gQA();
                if (this.Pqf.getCount() >= gQA) {
                    ca amt = this.Pqf.amt(this.Pqf.getCount() - 1);
                    if (amt != null) {
                        long i3 = ((l) g.af(l.class)).eiy().i(this.dom.getTalkerUserName(), amt.field_createTime, gQA);
                        int count = this.Pqf.getCount() - 1;
                        while (true) {
                            if (count >= 0) {
                                ca amt2 = this.Pqf.amt(count);
                                if (amt2 != null && amt2.field_createTime == i3) {
                                    i2 = count;
                                    break;
                                }
                                count--;
                            } else {
                                break;
                            }
                        }
                    } else {
                        Log.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("MSG_POSITION_UNREAD_COUNT", gQA);
                    this.dom.Pwc.gNi().a(d.a.ACTION_POSITION, true, bundle);
                }
                i2 = 0;
                Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", Integer.valueOf(i2));
                com.tencent.mm.ui.chatting.e.a aVar = this.dom;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(aVar, a2.axQ(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
                aVar.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
                ((k) this.dom.bh(k.class)).amu(i2);
            } else {
                com.tencent.mm.ui.chatting.e.a aVar2 = this.dom;
                com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(aVar2, a3.axQ(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
                aVar2.scrollToPosition(((Integer) a3.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(aVar2, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
                this.dom.getListView().postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.y.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(35337);
                        Bundle bundle = new Bundle();
                        bundle.putLong("MSG_ID", y.this.Pqe.field_msgId);
                        y.this.dom.Pwe.bt(bundle);
                        AppMethodBeat.o(35337);
                    }
                }, 166);
            }
            ((ab) this.dom.bh(ab.class)).gQB();
            Object[] objArr2 = new Object[2];
            objArr2[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            objArr2[1] = Boolean.valueOf(e2 == null);
            Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] cost:%s null == seqBlock?:%s", objArr2);
            AppMethodBeat.o(35347);
        }

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(35348);
            b.a aVar = (b.a) obj;
            String str = aVar.username;
            boolean z = aVar.zqi;
            if (!str.equals(this.dom.getTalkerUserName())) {
                AppMethodBeat.o(35348);
                return;
            }
            Log.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", this.dom.getTalkerUserName(), Integer.valueOf(aVar.id), Boolean.valueOf(aVar.zqi));
            if (i2 == 4 && !z) {
                Log.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(str)));
                this.mMainHandler.sendEmptyMessage(8);
            }
            if (!z && (i2 == 2 || i2 == 4)) {
                aj aEh = ((l) g.af(l.class)).eit().aEh(this.dom.getTalkerUserName());
                com.tencent.mm.as.b.bch().a(this.dom.getTalkerUserName(), aEh.field_lastLocalSeq + 1, aEh.field_lastPushSeq, 0, (b.AbstractC0268b) null);
            }
            AppMethodBeat.o(35348);
        }

        class a extends com.tencent.f.i.b {
            String talker;

            /* synthetic */ a(y yVar, String str, byte b2) {
                this(str);
            }

            private a(String str) {
                this.talker = str;
            }

            public final void run() {
                boolean z;
                AppMethodBeat.i(35340);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    bg.aVF();
                    az bjY = com.tencent.mm.model.c.aST().bjY(this.talker);
                    i eiy = ((l) g.af(l.class)).eiy();
                    if (bjY == null || eiy == null) {
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(bjY == null);
                        objArr[1] = this.talker;
                        Log.e("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] null == conv?%s talker:%s", objArr);
                        y.this.mMainHandler.sendEmptyMessage(2);
                        Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(35340);
                        return;
                    }
                    long j2 = bjY.field_lastSeq;
                    long j3 = bjY.field_conversationTime;
                    if (y.this.gQb()) {
                        aj aEh = ((l) g.af(l.class)).eit().aEh(y.this.dom.getTalkerUserName());
                        long j4 = aEh.field_lastLocalSeq;
                        long j5 = aEh.field_lastPushSeq;
                        Log.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + j5 + " lastLocalSeq:" + j4);
                        if (j4 != j5) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            y.this.mMainHandler.sendEmptyMessage(1);
                        } else {
                            y.this.mMainHandler.sendEmptyMessage(2);
                        }
                    } else if (bjY.oV(67108864)) {
                        Log.w("MicroMsg.GetChatroomComponent", "has check! %s", this.talker);
                        y.this.mMainHandler.sendEmptyMessage(2);
                        Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(35340);
                        return;
                    } else {
                        bjY.oT(67108864);
                        bg.aVF();
                        com.tencent.mm.model.c.aST().a(bjY, this.talker);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ca iG = eiy.iG(this.talker, " and msgSeq != 0 and flag & 2 != 0");
                        Log.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", Long.valueOf(iG.field_msgSeq), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), " and msgSeq != 0 and flag & 2 != 0");
                        if (iG.field_msgId > 0 || bjY.field_UnDeliverCount > 0) {
                            ca aEz = eiy.aEz(this.talker);
                            long aWy = cl.aWy() - 259200000;
                            String formatTime = f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, aWy / 1000);
                            ca aZ = eiy.aZ(this.talker, aWy);
                            if (aZ.field_msgId == 0) {
                                Log.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
                                long aEk = ((l) g.af(l.class)).aTq().aEk(this.talker);
                                long aEj = ((l) g.af(l.class)).aTq().aEj(this.talker);
                                aZ.setCreateTime(aEk);
                                aZ.yH(aEj);
                            }
                            Log.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", this.talker, Long.valueOf(j2), Long.valueOf(aZ.field_msgSeq), Long.valueOf(j3), Long.valueOf(aZ.field_createTime), formatTime, f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, aZ.field_createTime / 1000));
                            jk jkVar = new jk();
                            jkVar.dOf.username = y.this.dom.getTalkerUserName();
                            jkVar.dOf.dOi = aZ.field_msgSeq;
                            jkVar.dOf.dOj = aZ.field_createTime;
                            jkVar.dOf.dOg = j2;
                            jkVar.dOf.dOh = j3;
                            EventCenter.instance.publish(jkVar);
                            y.this.mMainHandler.sendEmptyMessage(8);
                            if (aEz == null || aEz.field_msgSeq == j2) {
                                y.this.mMainHandler.sendEmptyMessage(4);
                            } else {
                                y.this.mMainHandler.sendEmptyMessage(1);
                            }
                            Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", this.talker);
                        } else {
                            Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", this.talker);
                            y.this.mMainHandler.sendEmptyMessage(2);
                        }
                    }
                    Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(35340);
                } catch (Throwable th) {
                    Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(35340);
                    throw th;
                }
            }

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "CheckGetChatroomTask";
            }
        }
    }
