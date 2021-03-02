package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.ExecutorService;
import junit.framework.Assert;

public abstract class n<Params, Progress, Result> {
    protected MMHandler handler = new MMHandler(Looper.getMainLooper());
    private boolean isStart = false;

    public abstract Result doInBackground(Params... paramsArr);

    public abstract ExecutorService eGk();

    public final boolean y(final Params... paramsArr) {
        if (this.isStart) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.isStart = true;
        z(paramsArr);
        ExecutorService eGk = eGk();
        if (eGk == null) {
            return false;
        }
        eGk.execute(new Runnable() {
            /* class com.tencent.mm.pluginsdk.model.n.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.pluginsdk.model.n */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                AppMethodBeat.i(151637);
                final Object doInBackground = n.this.doInBackground(paramsArr);
                n.this.handler.post(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.model.n.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.pluginsdk.model.n */
                    /* JADX WARN: Multi-variable type inference failed */
                    public final void run() {
                        AppMethodBeat.i(151636);
                        n.this.onPostExecute(doInBackground);
                        AppMethodBeat.o(151636);
                    }
                });
                AppMethodBeat.o(151637);
            }
        });
        return true;
    }

    public void z(Params... paramsArr) {
    }

    public void onPostExecute(Result result) {
    }

    public void onProgressUpdate(Progress... progressArr) {
    }
}
