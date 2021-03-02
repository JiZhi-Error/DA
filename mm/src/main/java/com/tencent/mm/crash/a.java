package com.tencent.mm.crash;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.nativecrash.NativeCrash;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class a implements NativeCrash.c {
    private static boolean sInitialized = false;
    public CrashMonitorForJni.CrashExtraMessageGetter gNl;

    /* renamed from: com.tencent.mm.crash.a$a  reason: collision with other inner class name */
    public static class C0308a {
        public String clientVersion;
        public int gNm;
        public String text;
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a arO() {
        return b.gNn;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        static a gNn = new a((byte) 0);

        static {
            AppMethodBeat.i(145678);
            AppMethodBeat.o(145678);
        }
    }

    private a() {
        AppMethodBeat.i(145679);
        sInitialized = true;
        File file = new File(MMApplicationContext.getContext().getFilesDir(), "crash/NativeCrash_" + MMApplicationContext.getProcessName().replace(':', '_') + '_' + System.currentTimeMillis());
        file.getParentFile().mkdirs();
        NativeCrash.bpJ(file.getAbsolutePath());
        NativeCrash.hiE();
        NativeCrash.EJ("Client Version: " + BuildInfo.CLIENT_VERSION);
        NativeCrash.EJ("Base Version: " + com.tencent.mm.loader.j.a.CLIENT_VERSION);
        NativeCrash.a(this);
        AppMethodBeat.o(145679);
    }

    public static void EJ(String str) {
        AppMethodBeat.i(145680);
        NativeCrash.EJ(str);
        AppMethodBeat.o(145680);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039 A[SYNTHETIC, Splitter:B:14:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ea A[SYNTHETIC, Splitter:B:46:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.crash.a.C0308a g(int r10, java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 372
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.crash.a.g(int, java.lang.String, java.lang.String):com.tencent.mm.crash.a$a");
    }

    private static void a(BufferedReader bufferedReader, StringBuilder sb) {
        String readLine;
        int indexOf;
        AppMethodBeat.i(175951);
        ArrayList arrayList = new ArrayList();
        while (true) {
            readLine = bufferedReader.readLine();
            if (readLine != null && !readLine.isEmpty() && (indexOf = readLine.indexOf(" -> ")) > 0) {
                arrayList.add(readLine.substring(indexOf + 4));
            }
        }
        if (arrayList.isEmpty()) {
            AppMethodBeat.o(175951);
            return;
        }
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i2 = 1;
        String str = (String) arrayList.get(0);
        int i3 = 1;
        while (i2 < size) {
            String str2 = (String) arrayList.get(i2);
            if (!str2.equals(str)) {
                arrayList2.add(Pair.create(str, Integer.valueOf(i3)));
                i3 = 1;
            } else {
                i3++;
                str2 = str;
            }
            i2++;
            str = str2;
        }
        arrayList2.add(Pair.create(str, Integer.valueOf(i3)));
        Collections.sort(arrayList2, new Comparator<Pair<String, Integer>>() {
            /* class com.tencent.mm.crash.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Pair<String, Integer> pair, Pair<String, Integer> pair2) {
                AppMethodBeat.i(175949);
                int intValue = ((Integer) pair2.second).intValue() - ((Integer) pair.second).intValue();
                AppMethodBeat.o(175949);
                return intValue;
            }
        });
        sb.append("[File Descriptors]\n");
        if (readLine != null && readLine.startsWith("Total: ")) {
            sb.append(readLine).append('\n');
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            sb.append('(').append(pair.second).append(") ").append((String) pair.first).append('\n');
        }
        sb.append('\n');
        AppMethodBeat.o(175951);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d A[SYNTHETIC, Splitter:B:28:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d7  */
    @Override // com.tencent.nativecrash.NativeCrash.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onCrashDumped(int r7, java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.crash.a.onCrashDumped(int, java.lang.String, java.lang.String):boolean");
    }
}
