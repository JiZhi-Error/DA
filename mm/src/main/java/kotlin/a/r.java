package kotlin.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.k.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, hxF = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", FirebaseAnalytics.b.INDEX, "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, hxG = 1)
public class r extends q {
    public static final /* synthetic */ int K(List list, int i2) {
        AppMethodBeat.i(129114);
        int kq = j.kq(list);
        if (i2 >= 0 && kq >= i2) {
            int kq2 = j.kq(list) - i2;
            AppMethodBeat.o(129114);
            return kq2;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Element index " + i2 + " must be in range [" + new f(0, j.kq(list)) + "].");
        AppMethodBeat.o(129114);
        throw indexOutOfBoundsException;
    }
}
