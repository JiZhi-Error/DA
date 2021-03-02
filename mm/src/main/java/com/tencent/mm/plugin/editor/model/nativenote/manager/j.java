package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.a;
import com.tencent.mm.plugin.editor.model.nativenote.b.b;
import com.tencent.mm.plugin.editor.model.nativenote.b.c;
import com.tencent.mm.plugin.editor.model.nativenote.spans.k;
import com.tencent.mm.plugin.editor.model.nativenote.spans.r;
import com.tencent.mm.plugin.editor.model.nativenote.spans.t;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;

public final class j implements c {
    private static DisplayMetrics aJm;
    public static int mScreenHeight;
    public static int mScreenWidth;
    public static j qRM = null;
    public static int qRN = -1;
    private static int qRP = -1;
    public int mActionBarHeight;
    public int mStatusBarHeight;
    private transient ArrayList<WXRTEditText> qRK = new ArrayList<>();
    public a qRL;
    private int qRO;
    public b qRQ = null;
    public boolean qRR = false;
    private View.OnKeyListener qRS = new View.OnKeyListener() {
        /* class com.tencent.mm.plugin.editor.model.nativenote.manager.j.AnonymousClass1 */

        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            boolean z;
            AppMethodBeat.i(181830);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            bVar.pH(i2);
            bVar.bm(keyEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(181830);
                return false;
            } else if (c.cDo().size() == 0) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(181830);
                return false;
            } else {
                WXRTEditText cDO = j.this.cDO();
                if (cDO == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(181830);
                    return false;
                }
                int recyclerItemPosition = cDO.getRecyclerItemPosition();
                Log.i("MicroMsg.WXRTManager", "current focus pos: %d", Integer.valueOf(recyclerItemPosition));
                com.tencent.mm.plugin.editor.model.a.a Fw = c.cDo().Fw(recyclerItemPosition);
                if (Fw == null) {
                    Log.w("MicroMsg.WXRTManager", "get current item is null %d", Integer.valueOf(recyclerItemPosition));
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(181830);
                    return false;
                }
                com.tencent.mm.plugin.editor.model.a.a Fw2 = c.cDo().Fw(recyclerItemPosition - 1);
                if (Fw2 == null) {
                    Log.i("MicroMsg.WXRTManager", "get preItem is null %d", Integer.valueOf(recyclerItemPosition));
                    if (cDO.getEditTextType() != 0 || j.a(j.this, cDO, recyclerItemPosition)) {
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                        AppMethodBeat.o(181830);
                        return false;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(181830);
                    return false;
                }
                switch (cDO.getEditTextType()) {
                    case 0:
                        Log.i("MicroMsg.WXRTManager", "Handle Editor Type EDITTEXT");
                        if (j.a(j.this, cDO, recyclerItemPosition)) {
                            String a2 = cDO.a(h.qRG);
                            c.cDo().cDr();
                            if (Fw2.getType() == 1) {
                                z = c.cDo().ae(recyclerItemPosition, true);
                                com.tencent.mm.plugin.editor.model.a.j jVar = (com.tencent.mm.plugin.editor.model.a.j) Fw2;
                                jVar.content += a2;
                                jVar.qPC = jVar.qPF.getText().toString().length();
                                jVar.qPA = true;
                                jVar.qPG = false;
                            } else {
                                if (Util.isNullOrNil(a2)) {
                                    z = c.cDo().ae(recyclerItemPosition, true);
                                } else {
                                    z = false;
                                }
                                Fw2.qPE.setSelection(0);
                                Fw2.qPA = true;
                                Fw2.qPG = false;
                            }
                            if (!z) {
                                j.this.qRL.cCK().fu(recyclerItemPosition - 1, 2);
                                break;
                            } else {
                                j.this.qRL.cCK().Fr(recyclerItemPosition - 1);
                                break;
                            }
                        } else {
                            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                            AppMethodBeat.o(181830);
                            return false;
                        }
                    case 1:
                        Log.i("MicroMsg.WXRTManager", "Handle Editor Type PREBUTTON");
                        c.cDo().cDr();
                        if (Fw2.getType() == 1) {
                            com.tencent.mm.plugin.editor.model.a.j jVar2 = (com.tencent.mm.plugin.editor.model.a.j) Fw2;
                            if (Util.isNullOrNil(jVar2.content)) {
                                Fw.qPD.setSelection(0);
                                Fw.qPA = true;
                                Fw.qPG = true;
                                c.cDo().ae(recyclerItemPosition - 1, true);
                                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                                AppMethodBeat.o(181830);
                                return true;
                            }
                            if (jVar2.content.endsWith("<br/>")) {
                                jVar2.content = jVar2.content.substring(0, jVar2.content.length() - 5);
                            }
                            jVar2.qPC = -1;
                            jVar2.qPA = true;
                            jVar2.qPG = false;
                        } else {
                            Fw2.qPE.setSelection(0);
                            Fw2.qPA = true;
                            Fw2.qPG = false;
                        }
                        j.this.qRL.cCK().fu(recyclerItemPosition - 1, 2);
                        break;
                    case 2:
                        Log.i("MicroMsg.WXRTManager", "Handle Editor Type NEXTBTTTON");
                        if (Fw.getType() == 4 && ((m) Fw).qPX.booleanValue()) {
                            Log.i("MicroMsg.WXRTManager", "Current Item is Voice and Recording");
                            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                            AppMethodBeat.o(181830);
                            return false;
                        } else if (Fw.qPH || Fw.getType() == -1) {
                            c.cDo().cDr();
                            c.cDo().ae(recyclerItemPosition, false);
                            j.this.qRL.cCK().Ft(recyclerItemPosition);
                            com.tencent.mm.plugin.editor.model.a.j jVar3 = new com.tencent.mm.plugin.editor.model.a.j();
                            jVar3.qPA = true;
                            jVar3.qPG = false;
                            jVar3.content = "";
                            jVar3.qPC = 0;
                            c.cDo().a(recyclerItemPosition, jVar3);
                            c.cDo().fx(recyclerItemPosition - 1, recyclerItemPosition + 1);
                            RecyclerView cCI = j.this.qRL.cCI();
                            com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(recyclerItemPosition, new com.tencent.mm.hellhoundlib.b.a());
                            com.tencent.mm.hellhoundlib.a.a.a(cCI, a3.axQ(), "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
                            cCI.scrollToPosition(((Integer) a3.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(cCI, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
                            break;
                        } else {
                            c.cDo().af(recyclerItemPosition, true);
                            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                            AppMethodBeat.o(181830);
                            return true;
                        }
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(181830);
                return true;
            }
        }
    };

    public j(a aVar) {
        AppMethodBeat.i(181831);
        this.qRL = aVar;
        qRM = this;
        this.mActionBarHeight = h.eu(aVar.cCJ());
        this.mStatusBarHeight = ao.jJ(aVar.cCJ());
        int[] screenWH = i.getScreenWH(aVar.cCJ());
        mScreenHeight = screenWH[1];
        mScreenWidth = screenWH[0];
        aJm = aVar.cCJ().getResources().getDisplayMetrics();
        this.qRO = ((mScreenHeight - this.mActionBarHeight) - this.mStatusBarHeight) - ((int) be(8.0f));
        k.qTi = 0.0f;
        AppMethodBeat.o(181831);
    }

    public final void q(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(181832);
        wXRTEditText.a(this);
        wXRTEditText.setRichTextEditing(null);
        wXRTEditText.setOnKeyListener(this.qRS);
        AppMethodBeat.o(181832);
    }

    public final WXRTEditText cDO() {
        AppMethodBeat.i(181833);
        c.cDo().T(this.qRK);
        if (this.qRK == null) {
            AppMethodBeat.o(181833);
            return null;
        }
        Iterator<WXRTEditText> it = this.qRK.iterator();
        while (it.hasNext()) {
            WXRTEditText next = it.next();
            if (next.hasFocus()) {
                AppMethodBeat.o(181833);
                return next;
            }
        }
        AppMethodBeat.o(181833);
        return null;
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.c
    public final void e(boolean z, long j2) {
        AppMethodBeat.i(181834);
        this.qRL.cCK().e(z, j2);
        AppMethodBeat.o(181834);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.c
    public final void Fv(int i2) {
        AppMethodBeat.i(181835);
        this.qRL.cCK().Q(i2, 0);
        AppMethodBeat.o(181835);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.c
    public final void a(WXRTEditText wXRTEditText, boolean z, int i2) {
        AppMethodBeat.i(181836);
        synchronized (this) {
            try {
                this.qRL.cCK().a(wXRTEditText, z, i2);
            } finally {
                AppMethodBeat.o(181836);
            }
        }
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.c
    public final void a(WXRTEditText wXRTEditText, int i2, int i3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        AppMethodBeat.i(181837);
        if (!this.qRR) {
            AppMethodBeat.o(181837);
            return;
        }
        this.qRL.cCK().fv(i2, i3);
        if (wXRTEditText.getEditTextType() == 0) {
            Iterator<t> it = u.qTM.iterator();
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
            while (it.hasNext()) {
                t next = it.next();
                if (next.s(wXRTEditText)) {
                    if (next instanceof com.tencent.mm.plugin.editor.model.nativenote.spans.b) {
                        z = true;
                    } else if (next instanceof com.tencent.mm.plugin.editor.model.nativenote.spans.c) {
                        z2 = true;
                    } else if (next instanceof com.tencent.mm.plugin.editor.model.nativenote.spans.j) {
                        z3 = true;
                    } else if (next instanceof r) {
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
        this.qRQ.lh(z);
        this.qRQ.li(z2);
        this.qRQ.lj(z3);
        this.qRQ.lk(z4);
        AppMethodBeat.o(181837);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.c
    public final void a(WXRTEditText wXRTEditText, Spannable spannable, Spannable spannable2, int i2) {
        String str;
        AppMethodBeat.i(181838);
        String a2 = wXRTEditText.a(h.qRG);
        if (wXRTEditText.getEditTextType() == 0) {
            com.tencent.mm.plugin.editor.model.a.a Fw = c.cDo().Fw(wXRTEditText.getRecyclerItemPosition());
            if (Fw != null && Fw.getType() == 1) {
                int alK = spannable == null ? 0 : com.tencent.mm.plugin.editor.b.alK(spannable.toString());
                int alK2 = spannable2 == null ? 0 : com.tencent.mm.plugin.editor.b.alK(spannable2.toString());
                if (c.cDo().fw(alK2 - alK, 0)) {
                    this.qRL.cCK().cCx();
                    this.qRL.cCK().Fr(wXRTEditText.getRecyclerItemPosition());
                } else {
                    c.cDo().cDr();
                    ((com.tencent.mm.plugin.editor.model.a.j) Fw).qPC = i2;
                    ((com.tencent.mm.plugin.editor.model.a.j) Fw).content = a2;
                    ((com.tencent.mm.plugin.editor.model.a.j) Fw).qPA = true;
                    Fw.qPG = false;
                    c cDo = c.cDo();
                    cDo.qQs = (alK2 - alK) + cDo.qQs;
                }
            }
        } else {
            wXRTEditText.setText("");
            if (Util.isNullOrNil(a2)) {
                AppMethodBeat.o(181838);
                return;
            }
            com.tencent.mm.plugin.editor.model.a.j jVar = new com.tencent.mm.plugin.editor.model.a.j();
            if (a2.equals("<br/>")) {
                str = "";
            } else {
                str = a2;
            }
            jVar.content = str;
            int a3 = c.cDo().a((com.tencent.mm.plugin.editor.model.a.a) jVar, wXRTEditText, true, false, false);
            c.cDo().fx(a3 - 1, a3 + 1);
        }
        this.qRL.cCK().cCU();
        AppMethodBeat.o(181838);
    }

    public static j cDP() {
        return qRM;
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.c
    public final void cDj() {
        AppMethodBeat.i(181839);
        this.qRL.cCK().cCv();
        AppMethodBeat.o(181839);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.c
    public final void b(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(181840);
        this.qRL.cCK().a(wXRTEditText);
        AppMethodBeat.o(181840);
    }

    public static float be(float f2) {
        AppMethodBeat.i(181841);
        float applyDimension = TypedValue.applyDimension(1, f2, aJm);
        AppMethodBeat.o(181841);
        return applyDimension;
    }

    public final WXRTEditText cDQ() {
        AppMethodBeat.i(181842);
        WXRTEditText cDO = cDO();
        if (cDO != null || this.qRK.size() <= 0) {
            AppMethodBeat.o(181842);
            return cDO;
        }
        WXRTEditText wXRTEditText = this.qRK.get(this.qRK.size() - 1);
        AppMethodBeat.o(181842);
        return wXRTEditText;
    }

    public final <V, C extends com.tencent.mm.plugin.editor.model.nativenote.spans.h<V>> void b(t<V, C> tVar, V v) {
        AppMethodBeat.i(181843);
        WXRTEditText cDO = cDO();
        if (cDO != null) {
            if (cDO.getEditTextType() == 0) {
                int i2 = cDO.getSelection().avh;
                int length = cDO.getText().length();
                if ((v instanceof Boolean) && v.booleanValue() && i2 == length) {
                    cDO.cDH();
                    cDO.getText().append("\n");
                    cDO.cDI();
                    cDO.setSelection(i2);
                }
                cDO.a(tVar, v);
                AppMethodBeat.o(181843);
                return;
            }
            cDO.qRr = true;
            cDO.qPK = tVar.cEq();
            cDO.getText().append("\n");
        }
        AppMethodBeat.o(181843);
    }

    static /* synthetic */ boolean a(j jVar, WXRTEditText wXRTEditText, int i2) {
        AppMethodBeat.i(181844);
        int selectionStart = wXRTEditText.getSelectionStart();
        if (selectionStart == wXRTEditText.getSelectionEnd()) {
            if (selectionStart == wXRTEditText.getParagraphsInSelection().avh) {
                wXRTEditText.qRq = true;
                jVar.b(u.qTI, Boolean.FALSE);
                jVar.b(u.qTJ, Boolean.FALSE);
                jVar.b(u.qTK, Boolean.FALSE);
                jVar.b(u.qTH, Boolean.FALSE);
                jVar.qRQ.li(false);
                jVar.qRQ.lj(false);
                jVar.qRQ.lk(false);
                wXRTEditText.qRq = false;
            }
            if (selectionStart == 0 && i2 != 0) {
                AppMethodBeat.o(181844);
                return true;
            }
        }
        AppMethodBeat.o(181844);
        return false;
    }
}
