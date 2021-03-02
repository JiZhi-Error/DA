package com.tencent.smtt.utils;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private b f2288a = null;

    /* renamed from: b  reason: collision with root package name */
    private b f2289b = null;

    /* access modifiers changed from: package-private */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        private String f2291b;

        /* renamed from: c  reason: collision with root package name */
        private long f2292c;

        /* renamed from: d  reason: collision with root package name */
        private long f2293d;

        a(String str, long j2, long j3) {
            this.f2291b = str;
            this.f2292c = j2;
            this.f2293d = j3;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.f2292c;
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return this.f2293d;
        }
    }

    /* access modifiers changed from: package-private */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        private Map<String, a> f2295b = new HashMap();

        /* access modifiers changed from: package-private */
        public Map<String, a> a() {
            return this.f2295b;
        }

        b(File file) {
            AppMethodBeat.i(54001);
            this.f2295b.clear();
            a(file);
            AppMethodBeat.o(54001);
        }

        private void a(File file) {
            AppMethodBeat.i(54002);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null || Build.VERSION.SDK_INT < 26) {
                    TbsLog.d("TbsCopyVerify", "generateFileInfo len=" + listFiles.length);
                    for (File file2 : listFiles) {
                        a(file2);
                    }
                    AppMethodBeat.o(54002);
                    return;
                }
                AppMethodBeat.o(54002);
                return;
            }
            if (file.isFile()) {
                a(file.getName(), file.length(), file.lastModified());
            }
            AppMethodBeat.o(54002);
        }

        private void a(String str, long j2, long j3) {
            AppMethodBeat.i(54003);
            TbsLog.d("TbsCopyVerify", "generateFileInfo name=" + str + ",fileSize=" + j2 + ",lastModify=" + j3);
            if (str != null && str.length() > 0 && j2 > 0 && j3 > 0) {
                a aVar = new a(str, j2, j3);
                if (!this.f2295b.containsKey(str)) {
                    this.f2295b.put(str, aVar);
                }
            }
            AppMethodBeat.o(54003);
        }
    }

    public void a(File file) {
        AppMethodBeat.i(53916);
        this.f2288a = new b(file);
        AppMethodBeat.o(53916);
    }

    public void b(File file) {
        AppMethodBeat.i(53917);
        this.f2289b = new b(file);
        AppMethodBeat.o(53917);
    }

    public boolean a() {
        AppMethodBeat.i(53918);
        TbsLog.d("TbsCopyVerify", "verify");
        if (this.f2289b == null || this.f2288a == null) {
            AppMethodBeat.o(53918);
            return false;
        } else if (this.f2289b.a().size() != this.f2288a.a().size() || !a(this.f2288a, this.f2289b)) {
            TbsLog.d("TbsCopyVerify", "verify No!");
            AppMethodBeat.o(53918);
            return false;
        } else {
            TbsLog.d("TbsCopyVerify", "verify Yes!");
            AppMethodBeat.o(53918);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.smtt.utils.p.b r12, com.tencent.smtt.utils.p.b r13) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.p.a(com.tencent.smtt.utils.p$b, com.tencent.smtt.utils.p$b):boolean");
    }
}
