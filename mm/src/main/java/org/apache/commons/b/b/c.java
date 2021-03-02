package org.apache.commons.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c implements Serializable {
    public static boolean Uhv = true;
    public static boolean Uhw = true;
    public static boolean Uhx = true;
    private Throwable Uhu = null;

    public c(b bVar) {
        AppMethodBeat.i(40720);
        this.Uhu = (Throwable) bVar;
        AppMethodBeat.o(40720);
    }

    public final void printStackTrace(PrintStream printStream) {
        AppMethodBeat.i(40721);
        synchronized (printStream) {
            try {
                PrintWriter printWriter = new PrintWriter((OutputStream) printStream, false);
                printStackTrace(printWriter);
                printWriter.flush();
            } finally {
                AppMethodBeat.o(40721);
            }
        }
    }

    public final void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.i(40722);
        Throwable th = this.Uhu;
        if (!a.hPO()) {
            ArrayList arrayList = new ArrayList();
            for (Throwable th2 = th; th2 != null; th2 = a.J(th2)) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter2 = new PrintWriter((Writer) stringWriter, true);
                if (th2 instanceof b) {
                    ((b) th2).a(printWriter2);
                } else {
                    th2.printStackTrace(printWriter2);
                }
                arrayList.add(a.bvn(stringWriter.getBuffer().toString()));
            }
            String str = "Caused by: ";
            if (!Uhv) {
                str = "Rethrown as: ";
                Collections.reverse(arrayList);
            }
            if (Uhw) {
                kN(arrayList);
            }
            synchronized (printWriter) {
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        for (String str2 : (String[]) it.next()) {
                            printWriter.println(str2);
                        }
                        if (it.hasNext()) {
                            printWriter.print(str);
                        }
                    }
                } finally {
                    AppMethodBeat.o(40722);
                }
            }
        } else if (th instanceof b) {
            ((b) th).a(printWriter);
            AppMethodBeat.o(40722);
        } else {
            th.printStackTrace(printWriter);
            AppMethodBeat.o(40722);
        }
    }

    private static void kN(List list) {
        AppMethodBeat.i(40723);
        for (int size = list.size() - 1; size > 0; size--) {
            String[] strArr = (String[]) list.get(size);
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            a.J(arrayList, new ArrayList(Arrays.asList((String[]) list.get(size - 1))));
            int length = strArr.length - arrayList.size();
            if (length > 0) {
                arrayList.add(new StringBuffer("\t... ").append(length).append(" more").toString());
                list.set(size, arrayList.toArray(new String[arrayList.size()]));
            }
        }
        AppMethodBeat.o(40723);
    }
}
