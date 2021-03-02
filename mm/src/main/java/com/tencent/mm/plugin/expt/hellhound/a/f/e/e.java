package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/SessionPagePathMatch;", "", "()V", "Companion", "plugin-expt_release"})
public final class e {
    public static final a sIP = new a((byte) 0);

    static {
        AppMethodBeat.i(221137);
        AppMethodBeat.o(221137);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/SessionPagePathMatch$Companion;", "", "()V", "LZ77_DECODE_CHAR", "", "LZ77_DECODE_INT_BASE", "", "LZ77_DECODE_INT_CEIL_CODE", "LZ77_DECODE_INT_FLOOR_CODE", "LZ77_DECODE_MIN_STRING_LEN", "PARAM_TYPE_PAGE", "PARAM_TYPE_VIEW", "decodeJson", "", "json", "decodeReferenceInt", "data", "width", "decodeReferenceLength", "decompressJson", "getPagesInPathConfig", "", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "curPageName", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static int dq(String str, int i2) {
            AppMethodBeat.i(221136);
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 *= 64;
                char charAt = str.charAt(i4);
                if (' ' > charAt || '_' < charAt) {
                    break;
                }
                i3 += charAt - ' ';
            }
            AppMethodBeat.o(221136);
            return i3;
        }
    }

    public static final String aqU(String str) {
        AppMethodBeat.i(221138);
        if (str == null) {
            AppMethodBeat.o(221138);
            return null;
        }
        String str2 = "";
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt != '^') {
                str2 = p.I(str2, Character.valueOf(charAt));
                i2++;
            } else if (str.charAt(i2 + 1) != '^') {
                String substring = str.substring(i2 + 1, i2 + 3);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int dq = a.dq(substring, 2);
                int dq2 = a.dq(String.valueOf(str.charAt(i2 + 3)) + "", 1) + 5;
                if (str2 == null) {
                    p.hyc();
                }
                int length = (str2.length() - dq) - dq2;
                String substring2 = str2.substring(length, dq2 + length);
                p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                str2 = str2 + substring2;
                i2 += 4;
            } else {
                str2 = p.I(str2, "^".concat(String.valueOf("")));
                i2 += 2;
            }
        }
        AppMethodBeat.o(221138);
        return str2;
    }
}
