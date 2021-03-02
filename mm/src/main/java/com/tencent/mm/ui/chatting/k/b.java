package com.tencent.mm.ui.chatting.k;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.z;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.f.b;
import com.tencent.mm.ui.chatting.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public abstract class b implements c.f, b.a {
    protected b.AbstractC2093b PEm;
    c PEn;
    protected ArrayList<c.b> PEo = null;
    private long Pwr = 0;
    protected String gAn;
    protected Context mContext;
    protected ArrayList<c.b> mDataList = null;
    private LinearLayoutManager oDV;
    private boolean qoo = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.ui.chatting.view.a] */
    @Override // com.tencent.mm.ui.chatting.k.c
    public final /* bridge */ /* synthetic */ void a(b.AbstractC2093b bVar) {
        b.AbstractC2093b bVar2 = bVar;
        this.PEm = bVar2;
        bVar2.a(this);
    }

    public b(Context context) {
        this.mContext = context;
        this.mDataList = new ArrayList<>();
    }

    @Override // com.tencent.mm.ui.chatting.k.c
    public final void onDetach() {
        this.PEm.a(null);
        this.PEm = null;
        if (this.PEn != null) {
            c.Pme = null;
            c.Pmf = null;
        }
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final RecyclerView.h gRX() {
        return new RecyclerView.h() {
            /* class com.tencent.mm.ui.chatting.k.b.AnonymousClass1 */
            int jKu = b.this.mContext.getResources().getColor(R.color.oy);
            int mSize = ((int) b.this.mContext.getResources().getDimension(R.dimen.f3062g));
            ColorDrawable qoA = new ColorDrawable(this.jKu);

            {
                AppMethodBeat.i(36466);
                AppMethodBeat.o(36466);
            }

            @Override // android.support.v7.widget.RecyclerView.h
            public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
                c.b amy;
                AppMethodBeat.i(36467);
                int paddingLeft = recyclerView.getPaddingLeft();
                int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                int childCount = recyclerView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt.getTag() != null && ((amy = b.this.amy(((Integer) childAt.getTag()).intValue() + 1)) == null || amy.getType() != Integer.MAX_VALUE)) {
                        int bottom = ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom();
                        this.qoA.setBounds(paddingLeft, bottom, width, this.mSize + bottom);
                        this.qoA.draw(canvas);
                    }
                }
                AppMethodBeat.o(36467);
            }
        };
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final c.b amy(int i2) {
        if (this.mDataList == null || this.mDataList.size() <= i2) {
            return null;
        }
        return this.mDataList.get(i2);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final RecyclerView.a bmS(String str) {
        this.gAn = str;
        this.PEn = new c(this.mContext, this);
        c.Pme = gRZ();
        return this.PEn;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final int getCount() {
        if (this.mDataList == null) {
            return 0;
        }
        return this.mDataList.size();
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final b.a gSa() {
        return new b.a() {
            /* class com.tencent.mm.ui.chatting.k.b.AnonymousClass2 */
            String Pmg = "";
            private MTimerHandler gAF = new MTimerHandler(bg.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.ui.chatting.k.b.AnonymousClass2.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(36470);
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(b.this.PEo == null);
                    objArr[1] = Boolean.valueOf(Util.isNullOrNil(AnonymousClass2.this.Pmg));
                    Log.i("MicroMsg.BaseHistoryListPresenter", "[onTimerExpired]  mDataListCache is null?:%s mSearchText is null?:%s", objArr);
                    if (Util.isNullOrNil(AnonymousClass2.this.Pmg)) {
                        b.this.PEn.Pmg = AnonymousClass2.this.Pmg;
                        if (b.this.PEo == null) {
                            b.this.gRY();
                        } else {
                            b.this.mDataList = b.this.PEo;
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.k.b.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(36468);
                                    if (b.this.PEm != null) {
                                        b.this.PEm.dr(AnonymousClass2.this.Pmg, false);
                                        b.this.PEn.atj.notifyChanged();
                                    }
                                    AppMethodBeat.o(36468);
                                }
                            });
                        }
                        AppMethodBeat.o(36470);
                    } else {
                        b.this.mDataList = b.this.PEo;
                        ArrayList<c.b> arrayList = new ArrayList<>();
                        if (b.this.mDataList != null) {
                            Iterator<c.b> it = b.this.mDataList.iterator();
                            while (it.hasNext()) {
                                c.b next = it.next();
                                if (next.bmC(AnonymousClass2.this.Pmg)) {
                                    arrayList.add(next);
                                }
                            }
                        }
                        b.this.mDataList = arrayList;
                        b.this.PEn.Pmg = AnonymousClass2.this.Pmg;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.k.b.AnonymousClass2.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(36469);
                                if (b.this.PEm != null) {
                                    b.this.PEn.atj.notifyChanged();
                                    b.this.PEm.dr(AnonymousClass2.this.Pmg, b.this.mDataList.isEmpty());
                                }
                                AppMethodBeat.o(36469);
                            }
                        });
                        AppMethodBeat.o(36470);
                    }
                    return false;
                }
            }, false);

            {
                AppMethodBeat.i(36471);
                AppMethodBeat.o(36471);
            }

            @Override // com.tencent.mm.modelvoiceaddr.ui.b.a
            public final void biM() {
            }

            @Override // com.tencent.mm.modelvoiceaddr.ui.b.a
            public final void a(boolean z, String[] strArr, long j2, int i2) {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnz() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
                AppMethodBeat.i(36472);
                Log.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
                if (b.this.PEm != null) {
                    b.this.PEm.onFinish();
                }
                AppMethodBeat.o(36472);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(36473);
                if (!this.Pmg.equals(str)) {
                    this.Pmg = str;
                    this.gAF.stopTimer();
                    this.gAF.startTimer(500);
                }
                AppMethodBeat.o(36473);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnA() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnB() {
                AppMethodBeat.i(36474);
                Log.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
                AppMethodBeat.o(36474);
            }
        };
    }

    protected static String b(ca caVar, boolean z) {
        String str = null;
        if (caVar == null) {
            return null;
        }
        if (caVar.field_isSend == 1) {
            return z.aTY();
        }
        if (z) {
            str = bp.Ks(caVar.field_content);
        }
        if (Util.isNullOrNil(str)) {
            return caVar.field_talker;
        }
        return str;
    }

    public final void d(int i2, ca caVar) {
        Log.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", Integer.valueOf(i2));
        switch (i2) {
            case 0:
                cJ(caVar);
                return;
            case 1:
                cI(caVar);
                return;
            case 2:
                cK(caVar);
                return;
            default:
                return;
        }
    }

    private void cI(ca caVar) {
        cz czVar = new cz();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(caVar);
        if (j.a(this.mContext, czVar, this.gAn, arrayList, false)) {
            c(czVar);
        } else {
            Log.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
        }
    }

    private void c(cz czVar) {
        czVar.dFZ.dGf = 45;
        czVar.dFZ.activity = (Activity) this.mContext;
        EventCenter.instance.publish(czVar);
        if (czVar.dGa.ret != -2 && czVar.dGa.ret <= 0 && czVar.dGa.ret <= 0) {
            if (14 != czVar.dFZ.type) {
                Log.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
            } else if (czVar.dFZ.dGc == null) {
                Log.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
            } else {
                h.INSTANCE.a(11142, Integer.valueOf(czVar.dFZ.dGc.Lyp), Integer.valueOf(czVar.dFZ.dGc.Lyq), Integer.valueOf(czVar.dFZ.dGc.Lyr), Integer.valueOf(czVar.dFZ.dGc.xiP), Integer.valueOf(czVar.dFZ.dGc.Lys), Integer.valueOf(czVar.dFZ.dGc.Lyt), Integer.valueOf(czVar.dFZ.dGc.Lyu), Integer.valueOf(czVar.dFZ.dGc.fileCount), Integer.valueOf(czVar.dFZ.dGc.Lyv), Integer.valueOf(czVar.dFZ.dGc.Lyw), Integer.valueOf(czVar.dFZ.dGc.Lyx), Integer.valueOf(czVar.dFZ.dGc.Lyy), Integer.valueOf(czVar.dFZ.dGc.Lyz), Integer.valueOf(czVar.dFZ.dGc.LyA), Integer.valueOf(czVar.dFZ.dGc.LyB));
            }
        }
    }

    private void cJ(ca caVar) {
        k.b HD = k.b.HD(caVar.field_content);
        if (HD == null || 51 != HD.type || WeChatBrands.Business.Entries.SessionChannels.checkAvailable(this.mContext)) {
            h.INSTANCE.idkeyStat(219, 19, 1, true);
            boolean endsWith = this.gAn.toLowerCase().endsWith("@chatroom");
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(caVar);
            l.a(this.mContext, arrayList, endsWith, this.gAn, new com.tencent.mm.ag.z() {
                /* class com.tencent.mm.ui.chatting.k.b.AnonymousClass3 */

                @Override // com.tencent.mm.ag.z
                public final void a(z.a aVar) {
                }

                @Override // com.tencent.mm.ag.z
                public final void b(z.a aVar) {
                }

                @Override // com.tencent.mm.ag.z
                public final void c(z.a aVar) {
                }

                @Override // com.tencent.mm.ag.z
                public final boolean aSC() {
                    return true;
                }

                @Override // com.tencent.mm.ag.z
                public final boolean aSD() {
                    return false;
                }

                @Override // com.tencent.mm.ag.z
                public final void B(Bundle bundle) {
                }

                @Override // com.tencent.mm.ag.z
                public final boolean aSE() {
                    return false;
                }
            });
        }
    }

    private void cK(final ca caVar) {
        h.INSTANCE.a(11627, 5);
        final TreeSet treeSet = new TreeSet();
        treeSet.add(Long.valueOf(caVar.field_msgId));
        com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(R.string.b91), "", this.mContext.getString(R.string.blj), this.mContext.getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.k.b.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(36477);
                Log.i("MicroMsg.BaseHistoryListPresenter", "delete message");
                com.tencent.mm.ui.chatting.j.a(b.this.mContext, treeSet, new com.tencent.mm.ag.z() {
                    /* class com.tencent.mm.ui.chatting.k.b.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ag.z
                    public final void a(z.a aVar) {
                    }

                    @Override // com.tencent.mm.ag.z
                    public final void b(z.a aVar) {
                        AppMethodBeat.i(36475);
                        if (aVar == z.a.del) {
                            AnonymousClass1 r0 = new c.b() {
                                /* class com.tencent.mm.ui.chatting.k.b.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.chatting.a.c.b
                                public final int getType() {
                                    return -1;
                                }
                            };
                            r0.msgId = caVar.field_msgId;
                            b.this.mDataList.remove(r0);
                            b.this.PEo.remove(r0);
                        }
                        AppMethodBeat.o(36475);
                    }

                    @Override // com.tencent.mm.ag.z
                    public final void c(z.a aVar) {
                        AppMethodBeat.i(36476);
                        Log.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", Thread.currentThread(), aVar);
                        if (aVar == z.a.del) {
                            b.this.PEn.atj.notifyChanged();
                        }
                        AppMethodBeat.o(36476);
                    }

                    @Override // com.tencent.mm.ag.z
                    public final boolean aSC() {
                        return true;
                    }

                    @Override // com.tencent.mm.ag.z
                    public final boolean aSD() {
                        return false;
                    }

                    @Override // com.tencent.mm.ag.z
                    public final void B(Bundle bundle) {
                    }

                    @Override // com.tencent.mm.ag.z
                    public final boolean aSE() {
                        return false;
                    }
                });
                AppMethodBeat.o(36477);
            }
        }, null);
    }

    /* access modifiers changed from: protected */
    public final boolean gSk() {
        long currentTimeMillis = System.currentTimeMillis();
        this.Pwr = currentTimeMillis;
        if (this.Pwr + 30000 < currentTimeMillis) {
            bg.aVF();
            this.qoo = com.tencent.mm.model.c.isSDCardAvailable();
        }
        return this.qoo;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final /* synthetic */ RecyclerView.LayoutManager gRW() {
        if (this.oDV == null) {
            this.oDV = new LinearLayoutManager();
        }
        return this.oDV;
    }
}
