package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.b.c.a;

public final class g {
    public static boolean eP(String str) {
        AppMethodBeat.i(193642);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(193642);
            return true;
        }
        AppMethodBeat.o(193642);
        return false;
    }

    public static boolean byL(String str) {
        int length;
        AppMethodBeat.i(259076);
        if (str == null || (length = str.length()) == 0) {
            AppMethodBeat.o(259076);
            return true;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                AppMethodBeat.o(259076);
                return false;
            }
        }
        AppMethodBeat.o(259076);
        return true;
    }

    public static boolean equals(String str, String str2) {
        AppMethodBeat.i(193643);
        if (str != null) {
            boolean equals = str.equals(str2);
            AppMethodBeat.o(193643);
            return equals;
        } else if (str2 == null) {
            AppMethodBeat.o(193643);
            return true;
        } else {
            AppMethodBeat.o(193643);
            return false;
        }
    }

    public static boolean eH(String str, String str2) {
        AppMethodBeat.i(193644);
        if (str == null) {
            AppMethodBeat.o(193644);
            return false;
        } else if (str.indexOf(str2) >= 0) {
            AppMethodBeat.o(193644);
            return true;
        } else {
            AppMethodBeat.o(193644);
            return false;
        }
    }

    public static String id(String str, int i2) {
        int i3;
        AppMethodBeat.i(193645);
        if (str == null) {
            AppMethodBeat.o(193645);
            return null;
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i2 > str.length()) {
            i3 = str.length();
        } else {
            i3 = i2;
        }
        if (i3 < 0) {
            AppMethodBeat.o(193645);
            return "";
        }
        if (i3 < 0) {
            i3 = 0;
        }
        String substring = str.substring(0, i3);
        AppMethodBeat.o(193645);
        return substring;
    }

    public static String a(Object[] objArr, char c2) {
        AppMethodBeat.i(259077);
        String a2 = a(objArr, c2, objArr.length);
        AppMethodBeat.o(259077);
        return a2;
    }

    public static String a(Object[] objArr, char c2, int i2) {
        int length;
        AppMethodBeat.i(40745);
        if (objArr == null) {
            AppMethodBeat.o(40745);
            return null;
        }
        int i3 = i2 + 0;
        if (i3 <= 0) {
            AppMethodBeat.o(40745);
            return "";
        }
        if (objArr[0] == null) {
            length = 16;
        } else {
            length = objArr[0].toString().length();
        }
        a aVar = new a((length + 1) * i3);
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 > 0) {
                aVar.J(c2);
            }
            if (objArr[i4] != null) {
                aVar.gF(objArr[i4]);
            }
        }
        String aVar2 = aVar.toString();
        AppMethodBeat.o(40745);
        return aVar2;
    }

    public static String a(Object[] objArr, String str) {
        AppMethodBeat.i(40746);
        if (objArr == null) {
            AppMethodBeat.o(40746);
            return null;
        }
        String a2 = a(objArr, str, objArr.length);
        AppMethodBeat.o(40746);
        return a2;
    }

    private static String a(Object[] objArr, String str, int i2) {
        int length;
        AppMethodBeat.i(40747);
        if (objArr == null) {
            AppMethodBeat.o(40747);
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 + 0;
        if (i3 <= 0) {
            AppMethodBeat.o(40747);
            return "";
        }
        if (objArr[0] == null) {
            length = 16;
        } else {
            length = objArr[0].toString().length();
        }
        a aVar = new a((length + str.length()) * i3);
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 > 0) {
                aVar.bvo(str);
            }
            if (objArr[i4] != null) {
                aVar.gF(objArr[i4]);
            }
        }
        String aVar2 = aVar.toString();
        AppMethodBeat.o(40747);
        return aVar2;
    }

    public static String a(Iterator it, String str) {
        AppMethodBeat.i(40748);
        if (it == null) {
            AppMethodBeat.o(40748);
            return null;
        } else if (!it.hasNext()) {
            AppMethodBeat.o(40748);
            return "";
        } else {
            Object next = it.next();
            if (!it.hasNext()) {
                String eVar = e.toString(next);
                AppMethodBeat.o(40748);
                return eVar;
            }
            a aVar = new a(256);
            if (next != null) {
                aVar.gF(next);
            }
            while (it.hasNext()) {
                if (str != null) {
                    aVar.bvo(str);
                }
                Object next2 = it.next();
                if (next2 != null) {
                    aVar.gF(next2);
                }
            }
            String aVar2 = aVar.toString();
            AppMethodBeat.o(40748);
            return aVar2;
        }
    }

    public static String a(Collection collection, String str) {
        AppMethodBeat.i(40749);
        String a2 = a(collection.iterator(), str);
        AppMethodBeat.o(40749);
        return a2;
    }

    public static String bC(String str, String str2, String str3) {
        AppMethodBeat.i(193647);
        String k = k(str, str2, str3, -1);
        AppMethodBeat.o(193647);
        return k;
    }

    private static String k(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(193648);
        if (eP(str) || eP(str2) || str3 == null) {
            AppMethodBeat.o(193648);
            return str;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            AppMethodBeat.o(193648);
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        a aVar = new a((length2 * 16) + str.length());
        int i3 = 0;
        while (indexOf != -1) {
            aVar.bvo(str.substring(i3, indexOf)).bvo(str3);
            i3 = indexOf + length;
            i2--;
            if (i2 == 0) {
                break;
            }
            indexOf = str.indexOf(str2, i3);
        }
        aVar.bvo(str.substring(i3));
        String aVar2 = aVar.toString();
        AppMethodBeat.o(193648);
        return aVar2;
    }
}
