package com.tencent.mm.plugin.editor.adapter.a;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.c;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class f extends a {
    private WXRTEditText qOL;

    public f(View view, j jVar) {
        super(view, jVar);
        AppMethodBeat.i(181659);
        this.qOL = (WXRTEditText) view.findViewById(R.id.h9p);
        if (!this.qNG.qRR) {
            this.qOL.setKeyListener(null);
            this.qOL.setFocusable(false);
            this.qOL.setClickable(true);
        }
        this.qOL.qRh = this;
        this.qOL.setEditTextType(0);
        this.qNG.q(this.qOL);
        this.qOL.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.editor.adapter.a.f.AnonymousClass1 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(181656);
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.editor.adapter.a.f.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(181655);
                        f.this.qOL.hasFocus();
                        AppMethodBeat.o(181655);
                    }
                });
                AppMethodBeat.o(181656);
            }
        });
        AppMethodBeat.o(181659);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.a
    public final void a(a aVar, int i2, int i3) {
        AppMethodBeat.i(181660);
        this.qOL.setPosInDataList(i2);
        final com.tencent.mm.plugin.editor.model.a.j jVar = (com.tencent.mm.plugin.editor.model.a.j) aVar;
        jVar.qPF = this.qOL;
        jVar.qPD = null;
        jVar.qPE = null;
        a Fw = c.cDo().Fw(i2 - 1);
        if (Fw != null && Fw.getType() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qOL.getLayoutParams();
            layoutParams.topMargin = 0;
            this.qOL.setLayoutParams(layoutParams);
        }
        a Fw2 = c.cDo().Fw(i2 + 1);
        if (Fw2 != null && Fw2.getType() == 1) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.qOL.getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.qOL.setLayoutParams(layoutParams2);
        }
        if (!this.qNG.qRR) {
            this.qOL.setRichTextEditing(jVar.content);
            l.B(this.qOL);
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.editor.adapter.a.f.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(181658);
                    f.this.qOL.setRichTextEditing(jVar.content);
                    f.this.qOL.cDH();
                    f.this.qOL.cDJ();
                    l.B(f.this.qOL);
                    f.this.qOL.cDK();
                    f.this.qOL.cDI();
                    if (jVar.qPA) {
                        if (jVar.qPC == -1 || jVar.qPC >= f.this.qOL.getText().toString().length()) {
                            f.this.qOL.setSelection(f.this.qOL.getText().toString().length());
                        } else {
                            f.this.qOL.setSelection(jVar.qPC);
                        }
                        f.this.qOL.requestFocus();
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.editor.adapter.a.f.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(181657);
                                if (jVar.qPJ != 0) {
                                    int i2 = f.this.qOL.getSelection().avh;
                                    if (i2 == jVar.content.length()) {
                                        f.this.qOL.cDH();
                                        f.this.qOL.getText().append((CharSequence) "\n");
                                        f.this.qOL.cDI();
                                        f.this.qOL.setSelection(i2);
                                    }
                                    jVar.qPJ = 0;
                                    if (jVar.qPK == 1) {
                                        f.this.qOL.a(u.qTJ, Boolean.TRUE);
                                        AppMethodBeat.o(181657);
                                        return;
                                    } else if (jVar.qPK == 3) {
                                        f.this.qOL.a(u.qTI, Boolean.TRUE);
                                        AppMethodBeat.o(181657);
                                        return;
                                    } else if (jVar.qPK == 2) {
                                        f.this.qOL.a(u.qTK, Boolean.TRUE);
                                    }
                                }
                                AppMethodBeat.o(181657);
                            }
                        }, 500);
                    } else if (f.this.qOL.hasFocus()) {
                        f.this.qOL.clearFocus();
                    }
                    if (jVar.qPI) {
                        jVar.qPI = false;
                        f.this.qOL.qPI = true;
                        f.this.qOL.onTextContextMenuItem(16908322);
                    }
                    AppMethodBeat.o(181658);
                }
            });
        }
        Log.i("MicroMsg.Note.EditorTextItemHolder", "TextItemHolder position is " + lQ());
        AppMethodBeat.o(181660);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.a
    public final int cCY() {
        return 1;
    }
}
