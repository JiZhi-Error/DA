package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class d<T> {
    List<Integer> Enr;
    private MMHandler handler;

    public abstract List<T> anm();

    public abstract void gZ(List<T> list);

    public d() {
        this.handler = null;
        this.Enr = new LinkedList();
        this.handler = aj.dRd();
        this.Enr.clear();
    }

    /* access modifiers changed from: protected */
    public final void pN(final boolean z) {
        boolean z2;
        int i2 = z ? 0 : 1;
        if (i2 == 1) {
            Iterator<Integer> it = this.Enr.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().intValue() == 1) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                Log.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
                return;
            }
        }
        if (!z) {
            Log.d("MicroMsg.AdapterLoader", "ui load");
        } else {
            Log.d("MicroMsg.AdapterLoader", "thread load" + this.Enr.size());
        }
        if (this.Enr.size() <= 1) {
            this.Enr.add(Integer.valueOf(i2));
            if (z) {
                aj.eJP().post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.d.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(97698);
                        d.this.gY(d.this.anm());
                        AppMethodBeat.o(97698);
                    }
                });
            } else {
                gY(anm());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void gY(List<T> list) {
        this.handler.post(new Runnable(list, true) {
            /* class com.tencent.mm.plugin.sns.ui.d.AnonymousClass2 */
            final /* synthetic */ List Enu;
            final /* synthetic */ boolean Env = true;

            {
                this.Enu = r3;
            }

            public final void run() {
                AppMethodBeat.i(97699);
                d.this.gZ(this.Enu);
                aj.eJP().post(new Runnable(this.Env) {
                    /* class com.tencent.mm.plugin.sns.ui.d.AnonymousClass3 */
                    final /* synthetic */ boolean Env;

                    {
                        this.Env = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(97700);
                        if (this.Env) {
                            d dVar = d.this;
                            if (dVar.Enr.size() > 1) {
                                dVar.Enr.remove(0);
                            }
                        }
                        AppMethodBeat.o(97700);
                    }
                });
                AppMethodBeat.o(97699);
            }
        });
    }
}
