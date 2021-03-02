package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class m extends a {
    private WXRTEditText JLd;

    public m(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30879);
        this.JLd = (WXRTEditText) view.findViewById(R.id.h9p);
        if (kVar.JIH != 2 || !this.JJu.JII) {
            this.JLd.setKeyListener(null);
            this.JLd.setFocusable(false);
            this.JLd.setClickable(true);
        }
        this.JLd.qRh = this;
        this.JLd.setEditTextType(0);
        this.JJu.q(this.JLd);
        this.JLd.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.m.AnonymousClass1 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(30876);
                bg.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.m.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(30875);
                        m.this.JLd.hasFocus();
                        AppMethodBeat.o(30875);
                    }
                });
                AppMethodBeat.o(30876);
            }
        });
        AppMethodBeat.o(30879);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final void a(c cVar, int i2, int i3) {
        final Bundle grZ;
        AppMethodBeat.i(30880);
        this.JLd.setPosInDataList(i2);
        final i iVar = (i) cVar;
        iVar.JHL = this.JLd;
        iVar.JHJ = null;
        iVar.JHK = null;
        c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i2 - 1);
        if (ahp != null && ahp.getType() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.JLd.getLayoutParams();
            layoutParams.topMargin = 0;
            this.JLd.setLayoutParams(layoutParams);
        }
        c ahp2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i2 + 1);
        if (ahp2 != null && ahp2.getType() == 1) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.JLd.getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.JLd.setLayoutParams(layoutParams2);
        }
        switch (this.JJu.JIH) {
            case 1:
                if (!this.JJu.JIx) {
                    grZ = t.b.NOTE_FROM_SINGLE_CHAT.grZ();
                    break;
                } else {
                    grZ = t.b.NOTE_FROM_GROUP_CHAT.grZ();
                    break;
                }
            case 2:
                grZ = t.b.NOTE_FROM_FAV.grZ();
                break;
            case 3:
            default:
                grZ = null;
                break;
            case 4:
                grZ = t.b.NOTE_FROM_TIMELINE.grZ();
                break;
        }
        if (this.JJu.JIH != 2 || !this.JJu.JII) {
            this.JLd.setRichTextEditing(iVar.content);
            l.b(this.JLd, grZ, l.Krf);
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.m.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(30878);
                    m.this.JLd.setRichTextEditing(iVar.content);
                    m.this.JLd.cDH();
                    m.this.JLd.cDJ();
                    l.b(m.this.JLd, grZ, l.Krf);
                    m.this.JLd.cDK();
                    m.this.JLd.cDI();
                    if (iVar.qPA) {
                        if (iVar.qPC == -1 || iVar.qPC >= m.this.JLd.getText().toString().length()) {
                            m.this.JLd.setSelection(m.this.JLd.getText().toString().length());
                        } else {
                            m.this.JLd.setSelection(iVar.qPC);
                        }
                        m.this.JLd.requestFocus();
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.m.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(30877);
                                if (iVar.qPJ != 0) {
                                    int i2 = m.this.JLd.getSelection().avh;
                                    if (i2 == iVar.content.length()) {
                                        m.this.JLd.cDH();
                                        m.this.JLd.getText().append((CharSequence) "\n");
                                        m.this.JLd.cDI();
                                        m.this.JLd.setSelection(i2);
                                    }
                                    iVar.qPJ = 0;
                                    if (iVar.qPK == 1) {
                                        m.this.JLd.a(u.JJj, Boolean.TRUE);
                                        AppMethodBeat.o(30877);
                                        return;
                                    } else if (iVar.qPK == 3) {
                                        m.this.JLd.a(u.JJi, Boolean.TRUE);
                                        AppMethodBeat.o(30877);
                                        return;
                                    } else if (iVar.qPK == 2) {
                                        m.this.JLd.a(u.JJk, Boolean.TRUE);
                                    }
                                }
                                AppMethodBeat.o(30877);
                            }
                        }, 500);
                    } else if (m.this.JLd.hasFocus()) {
                        m.this.JLd.clearFocus();
                    }
                    if (iVar.qPI) {
                        iVar.qPI = false;
                        m.this.JLd.qPI = true;
                        m.this.JLd.onTextContextMenuItem(16908322);
                    }
                    AppMethodBeat.o(30878);
                }
            });
        }
        Log.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + lQ());
        AppMethodBeat.o(30880);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return 1;
    }
}
