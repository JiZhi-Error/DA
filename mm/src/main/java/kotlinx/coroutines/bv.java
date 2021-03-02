package kotlinx.coroutines;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\b\u001a\u00020\t8\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"})
public final class bv extends CancellationException implements ab<bv> {
    public final bu TUQ;

    public bv(String str, Throwable th, bu buVar) {
        super(str);
        AppMethodBeat.i(118151);
        this.TUQ = buVar;
        if (th != null) {
            initCause(th);
        }
        AppMethodBeat.o(118151);
    }

    public final Throwable fillInStackTrace() {
        AppMethodBeat.i(118147);
        if (an.getDEBUG()) {
            Throwable fillInStackTrace = super.fillInStackTrace();
            AppMethodBeat.o(118147);
            return fillInStackTrace;
        }
        bv bvVar = this;
        AppMethodBeat.o(118147);
        return bvVar;
    }

    public final String toString() {
        AppMethodBeat.i(118148);
        String str = super.toString() + "; job=" + this.TUQ;
        AppMethodBeat.o(118148);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(118149);
        if (obj == this || ((obj instanceof bv) && p.j(((bv) obj).getMessage(), getMessage()) && p.j(((bv) obj).TUQ, this.TUQ) && p.j(((bv) obj).getCause(), getCause()))) {
            AppMethodBeat.o(118149);
            return true;
        }
        AppMethodBeat.o(118149);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(118150);
        String message = getMessage();
        if (message == null) {
            p.hyc();
        }
        int hashCode = ((message.hashCode() * 31) + this.TUQ.hashCode()) * 31;
        Throwable cause = getCause();
        int hashCode2 = (cause != null ? cause.hashCode() : 0) + hashCode;
        AppMethodBeat.o(118150);
        return hashCode2;
    }

    /* Return type fixed from 'java.lang.Throwable' to match base method */
    @Override // kotlinx.coroutines.ab
    public final /* synthetic */ bv hMF() {
        bv bvVar;
        AppMethodBeat.i(192324);
        if (an.getDEBUG()) {
            String message = getMessage();
            if (message == null) {
                p.hyc();
            }
            bvVar = new bv(message, this, this.TUQ);
        } else {
            bvVar = null;
        }
        bv bvVar2 = bvVar;
        AppMethodBeat.o(192324);
        return bvVar2;
    }
}
