package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.plugin.wenote.ui.nativenote.a;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;

public final class k implements c {
    private static k JIz = null;
    private static DisplayMetrics aJm;
    public static int mScreenHeight;
    public static int mScreenWidth;
    public static int qRN = -1;
    private static int qRP = -1;
    public long JIA = -1;
    public String JIB = "";
    public b JIC = null;
    private boolean JID = false;
    public int JIE = -1;
    public String JIF = null;
    public long JIG = -1;
    public int JIH = 0;
    public boolean JII = false;
    public final MTimerHandler JIJ = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.k.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(30525);
            if (-1 == k.this.JIA) {
                AppMethodBeat.o(30525);
                return false;
            }
            k.this.gjT();
            AppMethodBeat.o(30525);
            return true;
        }
    }, true);
    public boolean JIx;
    public a JIy;
    public long dFW = -1;
    public int mActionBarHeight;
    public int mStatusBarHeight;
    private transient ArrayList<WXRTEditText> qRK = new ArrayList<>();
    private int qRO;
    private View.OnKeyListener qRS = new View.OnKeyListener() {
        /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.k.AnonymousClass1 */

        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            boolean z;
            AppMethodBeat.i(30524);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            bVar.pH(i2);
            bVar.bm(keyEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return false;
            } else if (c.gjL().size() == 0) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return false;
            } else {
                WXRTEditText gjQ = k.this.gjQ();
                if (gjQ == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(30524);
                    return false;
                }
                int recyclerItemPosition = gjQ.getRecyclerItemPosition();
                Log.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", Integer.valueOf(recyclerItemPosition));
                com.tencent.mm.plugin.wenote.model.a.c ahp = c.gjL().ahp(recyclerItemPosition);
                if (ahp == null) {
                    Log.w("MicroMsg.Note.WXRTManager", "get current item is null %d", Integer.valueOf(recyclerItemPosition));
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(30524);
                    return false;
                }
                com.tencent.mm.plugin.wenote.model.a.c ahp2 = c.gjL().ahp(recyclerItemPosition - 1);
                if (ahp2 == null) {
                    Log.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", Integer.valueOf(recyclerItemPosition));
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(30524);
                    return false;
                }
                switch (gjQ.getEditTextType()) {
                    case 0:
                        Log.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
                        int selectionStart = gjQ.getSelectionStart();
                        if (selectionStart == gjQ.getSelectionEnd()) {
                            if (selectionStart == gjQ.getParagraphsInSelection().avh) {
                                gjQ.qRq = true;
                                k.this.b(u.JJj, Boolean.FALSE);
                                k.this.b(u.JJk, Boolean.FALSE);
                                k.this.b(u.JJi, Boolean.FALSE);
                                k.this.JIC.li(false);
                                k.this.JIC.lj(false);
                                k.this.JIC.lk(false);
                                gjQ.qRq = false;
                            }
                            if (selectionStart == 0 && recyclerItemPosition != 0) {
                                String a2 = gjQ.a(i.JIw);
                                c.gjL().cDr();
                                if (ahp2.getType() == 1) {
                                    z = c.gjL().ae(recyclerItemPosition, true);
                                    i iVar = (i) ahp2;
                                    iVar.content += a2;
                                    iVar.qPC = iVar.JHL.getText().toString().length();
                                    iVar.qPA = true;
                                    iVar.qPG = false;
                                } else {
                                    if (Util.isNullOrNil(a2)) {
                                        z = c.gjL().ae(recyclerItemPosition, true);
                                    } else {
                                        z = false;
                                    }
                                    ahp2.JHK.setSelection(0);
                                    ahp2.qPA = true;
                                    ahp2.qPG = false;
                                }
                                if (!z) {
                                    k.this.JIy.gkf().fu(recyclerItemPosition - 1, 2);
                                    break;
                                } else {
                                    k.this.JIy.gkf().Fr(recyclerItemPosition - 1);
                                    break;
                                }
                            } else {
                                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                                AppMethodBeat.o(30524);
                                return false;
                            }
                        } else {
                            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                            AppMethodBeat.o(30524);
                            return false;
                        }
                    case 1:
                        Log.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
                        c.gjL().cDr();
                        if (ahp2.getType() == 1) {
                            i iVar2 = (i) ahp2;
                            if (Util.isNullOrNil(iVar2.content)) {
                                ahp.JHJ.setSelection(0);
                                ahp.qPA = true;
                                ahp.qPG = true;
                                c.gjL().ae(recyclerItemPosition - 1, true);
                                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                                AppMethodBeat.o(30524);
                                return true;
                            }
                            if (iVar2.content.endsWith("<br/>")) {
                                iVar2.content = iVar2.content.substring(0, iVar2.content.length() - 5);
                            }
                            iVar2.qPC = -1;
                            iVar2.qPA = true;
                            iVar2.qPG = false;
                        } else {
                            ahp2.JHK.setSelection(0);
                            ahp2.qPA = true;
                            ahp2.qPG = false;
                        }
                        k.this.JIy.gkf().fu(recyclerItemPosition - 1, 2);
                        break;
                    case 2:
                        Log.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
                        if (ahp.getType() == 4 && ((l) ahp).qPX.booleanValue()) {
                            Log.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
                            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                            AppMethodBeat.o(30524);
                            return false;
                        } else if (ahp.qPH || ahp.getType() == -1) {
                            c.gjL().cDr();
                            c.gjL().ae(recyclerItemPosition, false);
                            k.this.JIy.gkf().Ft(recyclerItemPosition);
                            i iVar3 = new i();
                            iVar3.qPA = true;
                            iVar3.qPG = false;
                            iVar3.content = "";
                            iVar3.qPC = 0;
                            c.gjL().a(recyclerItemPosition, iVar3);
                            c.gjL().fx(recyclerItemPosition - 1, recyclerItemPosition + 1);
                            RecyclerView cCI = k.this.JIy.cCI();
                            com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(recyclerItemPosition, new com.tencent.mm.hellhoundlib.b.a());
                            com.tencent.mm.hellhoundlib.a.a.a(cCI, a3.axQ(), "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
                            cCI.scrollToPosition(((Integer) a3.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(cCI, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
                            break;
                        } else {
                            c.gjL().af(recyclerItemPosition, true);
                            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                            AppMethodBeat.o(30524);
                            return true;
                        }
                        break;
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return true;
            }
        }
    };

    public k(a aVar) {
        AppMethodBeat.i(30526);
        this.JIy = aVar;
        JIz = this;
        this.mActionBarHeight = h.eu(aVar.cCJ());
        this.mStatusBarHeight = ao.jJ(aVar.cCJ());
        int[] screenWH = com.tencent.mm.compatible.util.i.getScreenWH(aVar.cCJ());
        mScreenHeight = screenWH[1];
        mScreenWidth = screenWH[0];
        aJm = aVar.cCJ().getResources().getDisplayMetrics();
        this.qRO = ((mScreenHeight - this.mActionBarHeight) - this.mStatusBarHeight) - ((int) be(8.0f));
        this.JIB = c.gjL().cDw();
        m.qTi = 0.0f;
        AppMethodBeat.o(30526);
    }

    public final void onDestroy() {
        AppMethodBeat.i(179745);
        this.JIJ.stopTimer();
        this.JIA = -1;
        if (JIz == this) {
            JIz = null;
        }
        AppMethodBeat.o(179745);
    }

    public final WXRTEditText gjQ() {
        AppMethodBeat.i(30528);
        c gjL = c.gjL();
        ArrayList<WXRTEditText> arrayList = this.qRK;
        if (arrayList != null) {
            arrayList.clear();
            synchronized (gjL) {
                try {
                    if (gjL.mDataList != null) {
                        Iterator<com.tencent.mm.plugin.wenote.model.a.c> it = gjL.mDataList.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.wenote.model.a.c next = it.next();
                            if (next.JHL != null) {
                                arrayList.add(next.JHL);
                            } else if (!(next.JHJ == null || next.JHK == null)) {
                                arrayList.add(next.JHJ);
                                arrayList.add(next.JHK);
                            }
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(30528);
                    throw th;
                }
            }
        }
        if (this.qRK == null) {
            AppMethodBeat.o(30528);
            return null;
        }
        Iterator<WXRTEditText> it2 = this.qRK.iterator();
        while (it2.hasNext()) {
            WXRTEditText next2 = it2.next();
            if (next2.hasFocus()) {
                AppMethodBeat.o(30528);
                return next2;
            }
        }
        AppMethodBeat.o(30528);
        return null;
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.c
    public final void e(boolean z, long j2) {
        AppMethodBeat.i(30529);
        this.JIy.gkf().e(z, j2);
        AppMethodBeat.o(30529);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.c
    public final void gjJ() {
        AppMethodBeat.i(30530);
        this.JIy.gkf().gjJ();
        gjS();
        AppMethodBeat.o(30530);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.c
    public final void Fv(int i2) {
        AppMethodBeat.i(30531);
        this.JIy.gkf().Q(i2, 0);
        AppMethodBeat.o(30531);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.c
    public final void a(WXRTEditText wXRTEditText, boolean z, int i2) {
        AppMethodBeat.i(30532);
        synchronized (this) {
            if (z) {
                try {
                    gjS();
                } catch (Throwable th) {
                    AppMethodBeat.o(30532);
                    throw th;
                }
            }
            this.JIy.gkf().a(wXRTEditText, z, i2);
        }
        AppMethodBeat.o(30532);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.c
    public final void a(WXRTEditText wXRTEditText, int i2, int i3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        AppMethodBeat.i(30533);
        if (this.JIH != 2 || !this.JII) {
            AppMethodBeat.o(30533);
            return;
        }
        this.JIy.gkf().fv(i2, i3);
        if (wXRTEditText.getEditTextType() == 0) {
            Iterator<t> it = u.qTM.iterator();
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
            while (it.hasNext()) {
                t next = it.next();
                if (next.s(wXRTEditText)) {
                    if (next instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.b) {
                        z = true;
                    } else if (next instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.c) {
                        z2 = true;
                    } else if (next instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.l) {
                        z3 = true;
                    } else if (next instanceof j) {
                        z5 = true;
                        z4 = z5;
                    }
                }
                z5 = z4;
                z4 = z5;
            }
        } else {
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        this.JIC.lh(z);
        this.JIC.li(z2);
        this.JIC.lj(z3);
        this.JIC.lk(z4);
        AppMethodBeat.o(30533);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.c
    public final void a(WXRTEditText wXRTEditText, Spannable spannable, Spannable spannable2, int i2) {
        AppMethodBeat.i(30534);
        String a2 = wXRTEditText.a(i.JIw);
        if (wXRTEditText.getEditTextType() == 0) {
            com.tencent.mm.plugin.wenote.model.a.c ahp = c.gjL().ahp(wXRTEditText.getRecyclerItemPosition());
            if (ahp != null && ahp.getType() == 1) {
                int alK = spannable == null ? 0 : com.tencent.mm.plugin.wenote.c.c.alK(spannable.toString());
                int alK2 = spannable2 == null ? 0 : com.tencent.mm.plugin.wenote.c.c.alK(spannable2.toString());
                if (c.gjL().fw(alK2 - alK, 0)) {
                    this.JIy.gkf().cCx();
                    this.JIy.gkf().Fr(wXRTEditText.getRecyclerItemPosition());
                    AppMethodBeat.o(30534);
                    return;
                }
                c.gjL().cDr();
                ((i) ahp).qPC = i2;
                ((i) ahp).content = a2;
                ((i) ahp).qPA = true;
                ahp.qPG = false;
                c gjL = c.gjL();
                gjL.qQs = (alK2 - alK) + gjL.qQs;
            }
            AppMethodBeat.o(30534);
            return;
        }
        wXRTEditText.setText("");
        if (Util.isNullOrNil(a2)) {
            AppMethodBeat.o(30534);
            return;
        }
        i iVar = new i();
        iVar.content = a2.equals("<br/>") ? "" : a2;
        int a3 = c.gjL().a((com.tencent.mm.plugin.wenote.model.a.c) iVar, wXRTEditText, true, false, false);
        c.gjL().fx(a3 - 1, a3 + 1);
        AppMethodBeat.o(30534);
    }

    public static k gjR() {
        return JIz;
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.c
    public final void gjK() {
        AppMethodBeat.i(30535);
        this.JIy.gkf().cCv();
        AppMethodBeat.o(30535);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.c
    public final void b(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(30536);
        this.JIy.gkf().a(wXRTEditText);
        AppMethodBeat.o(30536);
    }

    public static float be(float f2) {
        AppMethodBeat.i(30537);
        float applyDimension = TypedValue.applyDimension(1, f2, aJm);
        AppMethodBeat.o(30537);
        return applyDimension;
    }

    private synchronized void cS(String str, boolean z) {
        AppMethodBeat.i(30538);
        hb hbVar = new hb();
        hbVar.dLm.type = 19;
        hbVar.dLm.dGb = c.gjL().alU(str);
        if (hbVar.dLm.dGb == null) {
            Log.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
            AppMethodBeat.o(30538);
        } else {
            hbVar.dLm.title = str;
            hbVar.dLm.dFW = this.dFW;
            hbVar.dLm.dLt = z ? 1 : 0;
            hbVar.dLm.desc = "fav_update_note_storage";
            EventCenter.instance.publish(hbVar);
            if (z) {
                this.JIE = hbVar.dLm.dLp.getIntExtra("fav_note_item_status", -1);
                this.JIF = hbVar.dLm.dLp.getStringExtra("fav_note_xml");
                this.JIG = hbVar.dLm.dLp.getLongExtra("fav_note_item_updatetime", -1);
            }
            AppMethodBeat.o(30538);
        }
    }

    private void gjS() {
        AppMethodBeat.i(30539);
        if (this.JIA < 0 && this.dFW > 0) {
            this.JIJ.startTimer(Util.MILLSECONDS_OF_MINUTE);
            this.JIA = Util.currentTicks();
            this.JIB = c.gjL().cDw();
        }
        AppMethodBeat.o(30539);
    }

    public final void gjT() {
        AppMethodBeat.i(30540);
        if (this.dFW > 0 && this.JIA > 0) {
            String cDw = c.gjL().cDw();
            if (!cDw.equals(this.JIB)) {
                this.JIB = cDw;
                if (!this.JID) {
                    this.JID = true;
                    cS(this.JIB, true);
                    AppMethodBeat.o(30540);
                    return;
                }
                cS(this.JIB, false);
            }
        }
        AppMethodBeat.o(30540);
    }

    public final WXRTEditText gjU() {
        AppMethodBeat.i(30541);
        WXRTEditText gjQ = gjQ();
        if (gjQ != null || this.qRK.size() <= 0) {
            AppMethodBeat.o(30541);
            return gjQ;
        }
        WXRTEditText wXRTEditText = this.qRK.get(this.qRK.size() - 1);
        AppMethodBeat.o(30541);
        return wXRTEditText;
    }

    public final <V, C extends g<V>> void b(t<V, C> tVar, V v) {
        AppMethodBeat.i(30542);
        WXRTEditText gjQ = gjQ();
        if (gjQ != null) {
            if (gjQ.getEditTextType() == 0) {
                int i2 = gjQ.getSelection().avh;
                int length = gjQ.getText().length();
                if ((v instanceof Boolean) && v.booleanValue() && i2 == length) {
                    gjQ.cDH();
                    gjQ.getText().append("\n");
                    gjQ.cDI();
                    gjQ.setSelection(i2);
                }
                gjQ.a(tVar, v);
                AppMethodBeat.o(30542);
                return;
            }
            gjQ.qRr = true;
            gjQ.qPK = tVar.cEq();
            gjQ.getText().append("\n");
        }
        AppMethodBeat.o(30542);
    }

    public final void q(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(30527);
        if (wXRTEditText.qRf == 0) {
            wXRTEditText.setTextSize(0, (float) com.tencent.mm.cb.a.aG(wXRTEditText.getContext(), R.dimen.is));
        }
        b.setTextSize(wXRTEditText.getTextSize());
        wXRTEditText.JIp = this;
        wXRTEditText.setRichTextEditing(null);
        wXRTEditText.setOnKeyListener(this.qRS);
        AppMethodBeat.o(30527);
    }

    public static void gjV() {
        AppMethodBeat.i(30543);
        if (JIz != null) {
            JIz.JIy.gkf().zD(true);
        }
        AppMethodBeat.o(30543);
    }
}
