package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.b;
import com.tencent.mm.k.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.h.d;
import java.util.List;

public final class b implements f<ca> {
    private d.a PFh;
    long PFi;
    long PFj;
    private long PFk;
    int PFl;
    private Bundle PFm;
    private d.C2097d PFn;
    Cursor To;
    String gAn;
    private boolean yMq;

    public b(String str, d.a aVar, Bundle bundle, long j2, long j3, long j4, int i2, d.C2097d dVar, boolean z) {
        AppMethodBeat.i(36633);
        this.PFk = j2;
        this.PFi = j3;
        this.PFj = j4;
        this.PFl = i2;
        this.gAn = str;
        this.PFh = aVar;
        this.PFm = bundle;
        this.PFn = dVar;
        this.yMq = z;
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.PFi + " mLastBottomCreateTime:" + this.PFj + " isFromSearch:" + z + " mLastCount:" + this.PFl + " mLastBottomMsgSeq:" + this.PFk + " mTalker:" + this.gAn + " action:" + aVar);
        AppMethodBeat.o(36633);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.chatting.n.f
    public final void a(final d.b bVar) {
        int i2;
        AppMethodBeat.i(36634);
        switch (this.PFh) {
            case ACTION_ENTER:
                b(bVar);
                AppMethodBeat.o(36634);
                return;
            case ACTION_BOTTOM:
                if (this.PFm == null || !this.PFm.getBoolean("load_bottom", false)) {
                    com.tencent.mm.plugin.messenger.foundation.a.a.b eit = ((l) g.af(l.class)).eit();
                    c e2 = eit.e(this.gAn, this.PFj, true);
                    if (e2 != null) {
                        com.tencent.mm.as.b.bch().a(this.gAn, e2.gCy, e2.gCz, 0, new b.AbstractC0268b() {
                            /* class com.tencent.mm.ui.chatting.n.b.AnonymousClass3 */

                            @Override // com.tencent.mm.as.b.AbstractC0268b
                            public final void b(int i2, List<ca> list) {
                                AppMethodBeat.i(36629);
                                if (i2 < 0 || list.size() <= 0) {
                                    b.this.d(bVar);
                                    AppMethodBeat.o(36629);
                                    return;
                                }
                                long j2 = b.this.PFi;
                                ca caVar = list.get(list.size() - 1);
                                long NT = b.this.NT(caVar.field_createTime);
                                Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.gAn + " from:" + j2 + " to:" + NT + " addMsg.CreateTime:" + caVar.field_createTime);
                                b.this.To = ((l) g.af(l.class)).eiy().d(b.this.gAn, j2, NT, Integer.MAX_VALUE);
                                bVar.next();
                                AppMethodBeat.o(36629);
                            }
                        });
                        AppMethodBeat.o(36634);
                        return;
                    }
                    Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.gAn + " mLastBottomCreateTime:" + this.PFj);
                    aj aEh = eit.aEh(this.gAn);
                    com.tencent.mm.as.b.bch().a(this.gAn, 1 + aEh.field_lastLocalSeq, aEh.field_lastPushSeq, 0, new b.AbstractC0268b() {
                        /* class com.tencent.mm.ui.chatting.n.b.AnonymousClass4 */

                        @Override // com.tencent.mm.as.b.AbstractC0268b
                        public final void b(int i2, List<ca> list) {
                            AppMethodBeat.i(36630);
                            if (i2 < 0 || list.size() <= 0) {
                                Log.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock ret:".concat(String.valueOf(i2)));
                                b.this.d(bVar);
                                AppMethodBeat.o(36630);
                                return;
                            }
                            long j2 = b.this.PFi;
                            long NT = b.this.NT(list.get(list.size() - 1).field_createTime);
                            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.gAn + " from:" + j2 + " to:" + NT + " size:" + list.size());
                            b.this.To = ((l) g.af(l.class)).eiy().d(b.this.gAn, j2, NT, Integer.MAX_VALUE);
                            bVar.next();
                            AppMethodBeat.o(36630);
                        }
                    });
                    AppMethodBeat.o(36634);
                    return;
                }
                aj aEh2 = ((l) g.af(l.class)).eit().aEh(this.gAn);
                com.tencent.mm.as.b.bch().a(this.gAn, aEh2.field_lastPushSeq, 1 + aEh2.field_lastLocalSeq, 1, new b.AbstractC0268b() {
                    /* class com.tencent.mm.ui.chatting.n.b.AnonymousClass2 */

                    @Override // com.tencent.mm.as.b.AbstractC0268b
                    public final void b(int i2, List<ca> list) {
                        AppMethodBeat.i(36628);
                        if (i2 < 0 || list.size() <= 0) {
                            b.this.d(bVar);
                            AppMethodBeat.o(36628);
                            return;
                        }
                        long gTM = b.this.gTM();
                        long gTP = b.this.gTP();
                        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + b.this.gAn + " from:" + gTM + " to:" + gTP);
                        b.this.To = ((l) g.af(l.class)).eiy().d(b.this.gAn, gTM, gTP, 18);
                        bVar.next();
                        AppMethodBeat.o(36628);
                    }
                });
                AppMethodBeat.o(36634);
                return;
            case ACTION_TOP:
                final com.tencent.mm.plugin.messenger.foundation.a.a.b eit2 = ((l) g.af(l.class)).eit();
                c aF = eit2.aF(this.gAn, this.PFi);
                long j2 = aF == null ? 0 : aF.gCB;
                long j3 = this.PFi;
                int E = ((l) g.af(l.class)).eiy().E(this.gAn, j2, j3);
                Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.gAn + " from:" + j2 + " to:" + j3 + " count:" + E + " seqBlock is null? " + (aF == null));
                if (E >= 18 || aF == null) {
                    long j4 = this.PFj;
                    Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.gAn + " from:" + j2 + " to:" + j4 + " count:" + (this.PFl + 18));
                    this.To = ((l) g.af(l.class)).eiy().d(this.gAn, j2, j4, this.PFl + 18);
                    bVar.next();
                    AppMethodBeat.o(36634);
                    return;
                }
                if (aF != null) {
                    long j5 = aF.gCz;
                    long j6 = aF.gCy;
                    final long j7 = aF.gCB;
                    final long j8 = aF.gCA;
                    com.tencent.mm.as.b.bch().a(this.gAn, j5, j6, 1, new b.AbstractC0268b() {
                        /* class com.tencent.mm.ui.chatting.n.b.AnonymousClass5 */

                        @Override // com.tencent.mm.as.b.AbstractC0268b
                        public final void b(int i2, List<ca> list) {
                            long j2;
                            AppMethodBeat.i(36631);
                            if (i2 >= 0) {
                                long j3 = j8;
                                if (list.size() > 0) {
                                    j2 = list.get(0).field_createTime;
                                } else {
                                    j2 = j3;
                                }
                                if (eit2.aF(b.this.gAn, j2) == null && list.size() < 18) {
                                    j2 = ((l) g.af(l.class)).eiy().i(b.this.gAn, j2, 18 - list.size());
                                }
                                if (j2 <= 0) {
                                    j2 = j8;
                                }
                                Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + b.this.gAn + " firstCreateTime:" + j8 + " lastCreateTime:" + j7 + " from:" + j2);
                                b.this.To = ((l) g.af(l.class)).eiy().d(b.this.gAn, j2, b.this.PFj, b.this.PFl + 18);
                                bVar.next();
                                AppMethodBeat.o(36631);
                                return;
                            }
                            b.this.d(bVar);
                            AppMethodBeat.o(36631);
                        }
                    });
                }
                AppMethodBeat.o(36634);
                return;
            case ACTION_UPDATE:
                c(bVar);
                AppMethodBeat.o(36634);
                return;
            case ACTION_POSITION:
                if (!this.yMq) {
                    com.tencent.mm.plugin.messenger.foundation.a.a.b eit3 = ((l) g.af(l.class)).eit();
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.PFm == null);
                    Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "null == mSourceArgs?%s", objArr);
                    int i3 = this.PFm == null ? 0 : this.PFm.getInt("MSG_POSITION_UNREAD_COUNT");
                    if (i3 <= 0) {
                        c aEg = eit3.aEg(this.gAn);
                        if (aEg != null) {
                            long j9 = aEg.gCy;
                            final long j10 = aEg.gCA;
                            long j11 = aEg.gCz;
                            final long j12 = aEg.gCB;
                            com.tencent.mm.as.b.bch().a(this.gAn, j9, j11, 0, new b.AbstractC0268b() {
                                /* class com.tencent.mm.ui.chatting.n.b.AnonymousClass1 */

                                @Override // com.tencent.mm.as.b.AbstractC0268b
                                public final void b(int i2, List<ca> list) {
                                    AppMethodBeat.i(36627);
                                    if (i2 < 0 || list.size() <= 0) {
                                        b.this.d(bVar);
                                        AppMethodBeat.o(36627);
                                        return;
                                    }
                                    Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + b.this.gAn + " fromCreateTime:" + j10 + " toCreateTime:" + j12 + " addSize:" + list.size());
                                    long j2 = j12;
                                    if (list.size() <= 18) {
                                        j2 = b.this.NT(list.get(list.size() - 1).field_createTime);
                                    }
                                    b.this.To = ((l) g.af(l.class)).eiy().d(b.this.gAn, j10, j2, 36);
                                    bVar.next();
                                    AppMethodBeat.o(36627);
                                }
                            });
                            break;
                        } else {
                            Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", this.gAn);
                            d(bVar);
                            AppMethodBeat.o(36634);
                            return;
                        }
                    } else {
                        long gTN = gTN();
                        long i4 = ((l) g.af(l.class)).eiy().i(this.gAn, gTN, i3);
                        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.gAn + " from:" + i4 + " to:" + gTN + " unreadCount:" + i3);
                        this.To = ((l) g.af(l.class)).eiy().d(this.gAn, i4, gTN, Integer.MAX_VALUE);
                        bVar.next();
                        AppMethodBeat.o(36634);
                        return;
                    }
                } else {
                    long j13 = this.PFm.getLong("MSG_ID");
                    boolean z = this.PFm.getBoolean("IS_LOAD_ALL", false);
                    bg.aVF();
                    ca Hb = com.tencent.mm.model.c.aSQ().Hb(j13);
                    if (Hb.field_msgId != j13) {
                        Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", Long.valueOf(j13));
                        bVar.next();
                        AppMethodBeat.o(36634);
                        return;
                    }
                    long j14 = Hb.field_createTime;
                    Log.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", Long.valueOf(j14), Long.valueOf(this.PFi), Long.valueOf(this.PFj));
                    if (j14 < this.PFi || j14 > this.PFj) {
                        long j15 = Hb.field_createTime;
                        bg.aVF();
                        long min = Math.min(NT(Hb.field_createTime), com.tencent.mm.model.c.aSQ().j(this.gAn, j15, 18));
                        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", Long.valueOf(j15), Long.valueOf(min), Long.valueOf(j13), Boolean.valueOf(z), 0);
                        this.To = ((l) g.af(l.class)).eiy().d(this.gAn, j15, min, Integer.MAX_VALUE);
                        i2 = 0;
                    } else {
                        this.To = ((l) g.af(l.class)).eiy().d(this.gAn, this.PFi, this.PFj, Integer.MAX_VALUE);
                        bg.aVF();
                        i2 = com.tencent.mm.model.c.aSQ().E(this.gAn, this.PFi, j14) - 1;
                        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", Integer.valueOf(i2), Long.valueOf(j13), Boolean.valueOf(z));
                    }
                    this.PFn.selection = Math.max(0, i2);
                    bVar.next();
                    AppMethodBeat.o(36634);
                    return;
                }
                break;
        }
        AppMethodBeat.o(36634);
    }

    private void b(d.b bVar) {
        AppMethodBeat.i(36635);
        long gTM = gTM();
        long gTP = gTP();
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", Long.valueOf(gTM), Long.valueOf(gTP));
        this.To = ((l) g.af(l.class)).eiy().d(this.gAn, gTM, gTP, 18);
        bVar.next();
        AppMethodBeat.o(36635);
    }

    private void c(d.b bVar) {
        boolean z;
        long gTN;
        ca aEx;
        AppMethodBeat.i(36636);
        boolean z2 = this.PFn.PDK != null && this.PFn.PDK.getBoolean("has_position_tongue", false);
        if (this.PFn.PDK == null || !this.PFn.PDK.getBoolean("has_position_search", false)) {
            z = false;
        } else {
            z = true;
        }
        if (!z2 || (aEx = ((l) g.af(l.class)).eiy().aEx(this.gAn)) == null || aEx.field_isSend != 1 || aEx.field_msgSeq != 0) {
            long gTO = gTO();
            if (z2 || !z) {
                gTN = gTN();
            } else {
                gTN = this.PFj;
            }
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.gAn + " from:" + gTO + " to:" + gTN + " hasTongue:" + z2);
            this.To = ((l) g.af(l.class)).eiy().d(this.gAn, gTO, gTN, Integer.MAX_VALUE);
            bVar.next();
            AppMethodBeat.o(36636);
            return;
        }
        b(bVar);
        if (this.PFn.PDK == null) {
            this.PFn.PDK = new Bundle();
        }
        this.PFn.PDK.putBoolean("need_scroll_to_bottom", true);
        Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
        AppMethodBeat.o(36636);
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final int cZm() {
        AppMethodBeat.i(36637);
        bg.aVF();
        int aEM = com.tencent.mm.model.c.aSQ().aEM(this.gAn);
        AppMethodBeat.o(36637);
        return aEM;
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void jA(List<ca> list) {
        AppMethodBeat.i(36638);
        if (this.To == null) {
            Log.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
            AppMethodBeat.o(36638);
            return;
        }
        this.To.moveToFirst();
        while (!this.To.isAfterLast()) {
            try {
                ca caVar = new ca();
                caVar.convertFrom(this.To);
                list.add(caVar);
                this.To.moveToNext();
            } catch (IllegalStateException e2) {
                Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingGetDataSource", e2, "", new Object[0]);
                AppMethodBeat.o(36638);
                return;
            }
        }
        AppMethodBeat.o(36638);
    }

    @Override // com.tencent.mm.ui.chatting.n.f
    public final void close() {
        AppMethodBeat.i(36639);
        if (this.To != null) {
            this.To.close();
        }
        AppMethodBeat.o(36639);
    }

    /* access modifiers changed from: package-private */
    public final long gTM() {
        AppMethodBeat.i(36640);
        c aEg = ((l) g.af(l.class)).eit().aEg(this.gAn);
        if (aEg != null) {
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + aEg.gCB + " seq:" + aEg.gCy + "~" + aEg.gCz);
            long j2 = aEg.gCB;
            AppMethodBeat.o(36640);
            return j2;
        }
        long j3 = this.PFi;
        AppMethodBeat.o(36640);
        return j3;
    }

    /* access modifiers changed from: package-private */
    public final long NT(long j2) {
        AppMethodBeat.i(36641);
        c e2 = ((l) g.af(l.class)).eit().e(this.gAn, j2, true);
        if (e2 != null) {
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + e2.gCA + " time:" + j2);
            long j3 = e2.gCA;
            AppMethodBeat.o(36641);
            return j3;
        }
        long gTP = gTP();
        AppMethodBeat.o(36641);
        return gTP;
    }

    private long gTN() {
        boolean z;
        AppMethodBeat.i(36642);
        aj aEh = ((l) g.af(l.class)).eit().aEh(this.gAn);
        if (this.PFk > 0) {
            List<c> Ng = aEh.Ng(this.PFk);
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] list size=", Integer.valueOf(Ng.size()));
            if (Ng.size() > 0) {
                ca gTQ = gTQ();
                long j2 = gTQ.field_createTime;
                StringBuilder sb = new StringBuilder("[findUpdateLastCreateTime]isSender=");
                if (gTQ.field_isSend == 1) {
                    z = true;
                } else {
                    z = false;
                }
                Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", sb.append(z).append(" mLastBottomMsgSeq=").append(this.PFk).append(" chatroomMsgSeq:").append(aEh).append(" mLastBottomCreateTime=").append(this.PFj).append(" localLastMsgCreateTime=").append(j2).toString());
                if (gTQ.field_isSend == 1) {
                    AppMethodBeat.o(36642);
                    return j2;
                }
                long j3 = this.PFj;
                AppMethodBeat.o(36642);
                return j3;
            }
        }
        long gTP = gTP();
        AppMethodBeat.o(36642);
        return gTP;
    }

    private long gTO() {
        AppMethodBeat.i(36643);
        if (this.PFi == 0) {
            Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
            this.PFi = ((l) g.af(l.class)).eiy().i(this.gAn, gTP(), 18);
        }
        long j2 = this.PFi;
        AppMethodBeat.o(36643);
        return j2;
    }

    /* access modifiers changed from: package-private */
    public final long gTP() {
        AppMethodBeat.i(36644);
        long aEQ = ((l) g.af(l.class)).eiy().aEQ(this.gAn);
        AppMethodBeat.o(36644);
        return aEQ;
    }

    private ca gTQ() {
        AppMethodBeat.i(36645);
        ca aEx = ((l) g.af(l.class)).eiy().aEx(this.gAn);
        AppMethodBeat.o(36645);
        return aEx;
    }

    /* access modifiers changed from: package-private */
    public final void d(d.b bVar) {
        AppMethodBeat.i(36646);
        Log.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fallback]");
        c(bVar);
        AppMethodBeat.o(36646);
    }
}
