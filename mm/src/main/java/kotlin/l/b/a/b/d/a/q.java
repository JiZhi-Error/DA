package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.l.b.a.b.f.b;

public final class q {
    private static final b TpA = new b("javax.annotation.CheckForNull");
    private static final List<b> TpB = j.listOf((Object[]) new b[]{p.Tpm, new b("edu.umd.cs.findbugs.annotations.NonNull"), new b("androidx.annotation.NonNull"), new b("android.support.annotation.NonNull"), new b("android.annotation.NonNull"), new b("com.android.annotations.NonNull"), new b("org.eclipse.jdt.annotation.NonNull"), new b("org.checkerframework.checker.nullness.qual.NonNull"), new b("lombok.NonNull"), new b("io.reactivex.annotations.NonNull")});
    private static final b TpC = new b("org.checkerframework.checker.nullness.compatqual.NullableDecl");
    private static final b TpD = new b("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
    private static final b TpE = new b("androidx.annotation.RecentlyNullable");
    private static final b TpF = new b("androidx.annotation.RecentlyNonNull");
    private static final Set<b> TpG = ak.c(ak.c(ak.c(ak.c(ak.b(ak.c(ak.b(new LinkedHashSet(), Tpy), Tpz), TpB), TpC), TpD), TpE), TpF);
    private static final List<b> TpH = j.listOf((Object[]) new b[]{p.Tpp, p.Tpq});
    private static final List<b> TpI = j.listOf((Object[]) new b[]{p.Tpo, p.Tpr});
    private static final List<b> Tpy = j.listOf((Object[]) new b[]{p.Tpn, new b("androidx.annotation.Nullable"), new b("android.support.annotation.Nullable"), new b("android.annotation.Nullable"), new b("com.android.annotations.Nullable"), new b("org.eclipse.jdt.annotation.Nullable"), new b("org.checkerframework.checker.nullness.qual.Nullable"), new b("javax.annotation.Nullable"), new b("javax.annotation.CheckForNull"), new b("edu.umd.cs.findbugs.annotations.CheckForNull"), new b("edu.umd.cs.findbugs.annotations.Nullable"), new b("edu.umd.cs.findbugs.annotations.PossiblyNull"), new b("io.reactivex.annotations.Nullable")});
    private static final b Tpz = new b("javax.annotation.Nonnull");

    static {
        AppMethodBeat.i(57617);
        AppMethodBeat.o(57617);
    }

    public static final List<b> hDv() {
        return Tpy;
    }

    public static final b hDw() {
        return Tpz;
    }

    public static final b hDx() {
        return TpA;
    }

    public static final List<b> hDy() {
        return TpB;
    }

    public static final b hDz() {
        return TpC;
    }

    public static final b hDA() {
        return TpD;
    }

    public static final b hDB() {
        return TpE;
    }

    public static final b hDC() {
        return TpF;
    }

    public static final List<b> hDD() {
        return TpH;
    }

    public static final List<b> hDE() {
        return TpI;
    }
}
