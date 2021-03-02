package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class m {
    private d TDM;
    private g TDN;
    private volatile boolean TDO;
    protected volatile q TDP;

    public final q e(q qVar) {
        q qVar2 = this.TDP;
        this.TDP = qVar;
        this.TDM = null;
        this.TDO = true;
        return qVar2;
    }

    public final int yC() {
        AppMethodBeat.i(59500);
        if (this.TDO) {
            int yC = this.TDP.yC();
            AppMethodBeat.o(59500);
            return yC;
        }
        int size = this.TDM.size();
        AppMethodBeat.o(59500);
        return size;
    }

    public final q d(q qVar) {
        AppMethodBeat.i(59499);
        if (this.TDP == null) {
            synchronized (this) {
                try {
                    if (this.TDP == null) {
                        try {
                            if (this.TDM != null) {
                                this.TDP = (q) qVar.hEs().b(this.TDM, this.TDN);
                            } else {
                                this.TDP = qVar;
                            }
                        } catch (IOException e2) {
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(59499);
                    throw th;
                }
            }
        }
        q qVar2 = this.TDP;
        AppMethodBeat.o(59499);
        return qVar2;
    }
}
