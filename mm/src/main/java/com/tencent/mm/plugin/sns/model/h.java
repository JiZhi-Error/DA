package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.ExecutorService;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result> {
    MMHandler handler = aj.dRd();
    private boolean isStart = false;

    public abstract Result doInBackground(Params... paramsArr);

    public abstract ExecutorService eGk();

    public final boolean y(final Params... paramsArr) {
        if (this.isStart) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.isStart = true;
        ExecutorService eGk = eGk();
        if (eGk == null) {
            return false;
        }
        eGk.execute(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.h.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.plugin.sns.model.h */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                AppMethodBeat.i(95555);
                final Object doInBackground = h.this.doInBackground(paramsArr);
                h.this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.h.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.plugin.sns.model.h */
                    /* JADX WARN: Multi-variable type inference failed */
                    public final void run() {
                        AppMethodBeat.i(95554);
                        h.this.onPostExecute(doInBackground);
                        AppMethodBeat.o(95554);
                    }
                });
                AppMethodBeat.o(95555);
            }
        });
        return true;
    }

    public void onPostExecute(Result result) {
    }
}
