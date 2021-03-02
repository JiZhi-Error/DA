package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.k.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0013\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0002H\b\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0002\u001a\r\u0010\u001d\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u001e\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u001f\u001a\u00020\u0002*\u00020\u0002H\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, hxF = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "toLowerCase", "toTitleCase", "toUpperCase", "kotlin-stdlib"}, hxG = 1)
public class b {
    public static final boolean isWhitespace(char c2) {
        AppMethodBeat.i(129421);
        if (Character.isWhitespace(c2) || Character.isSpaceChar(c2)) {
            AppMethodBeat.o(129421);
            return true;
        }
        AppMethodBeat.o(129421);
        return false;
    }

    public static final int avR(int i2) {
        AppMethodBeat.i(129422);
        if (2 > i2 || 36 < i2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("radix " + i2 + " was not in valid range " + new f(2, 36));
            AppMethodBeat.o(129422);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(129422);
        return i2;
    }
}
