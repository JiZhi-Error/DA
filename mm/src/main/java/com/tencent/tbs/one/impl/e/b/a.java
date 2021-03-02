package com.tencent.tbs.one.impl.e.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.e;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.e.e;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

public final class a extends com.tencent.tbs.one.impl.a.a<e<File>> {

    /* renamed from: b  reason: collision with root package name */
    Context f2686b;

    /* renamed from: c  reason: collision with root package name */
    String f2687c;

    /* renamed from: d  reason: collision with root package name */
    d.a f2688d;

    /* renamed from: e  reason: collision with root package name */
    File f2689e;

    /* renamed from: f  reason: collision with root package name */
    private Bundle f2690f;

    public a(Context context, String str, d.a aVar, File file, Bundle bundle) {
        this.f2686b = context;
        this.f2687c = str;
        this.f2688d = aVar;
        this.f2689e = file;
        this.f2690f = bundle;
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a() {
        AppMethodBeat.i(174068);
        m.d(new Runnable() {
            /* class com.tencent.tbs.one.impl.e.b.a.AnonymousClass1 */

            public final void run() {
                MessageDigest messageDigest = null;
                AppMethodBeat.i(174070);
                a aVar = a.this;
                Context context = a.this.f2686b;
                d.a aVar2 = a.this.f2688d;
                File file = a.this.f2689e;
                File a2 = f.a(context);
                String str = aVar2.f2558a;
                File a3 = f.a(a2, str, "MANIFEST");
                try {
                    com.tencent.tbs.one.impl.common.e a4 = com.tencent.tbs.one.impl.common.e.a(a3);
                    int i2 = aVar.f2688d.f2560c;
                    int i3 = a4.f2564a;
                    if (i2 != i3) {
                        aVar.a(417, "Failed to verify version code, expected " + i2 + " but was " + i3, null);
                        AppMethodBeat.o(174070);
                        return;
                    }
                    if (!file.mkdirs()) {
                        com.tencent.tbs.one.impl.a.f.c("Failed to create directory %s", file.getAbsolutePath());
                    }
                    try {
                        c.a(a3, new File(file, "MANIFEST"));
                        e.a[] aVarArr = a4.f2568e;
                        for (e.a aVar3 : aVarArr) {
                            String str2 = aVar3.f2570a;
                            File file2 = new File(file, str2);
                            try {
                                c.a(f.a(a2, str, str2), file2);
                                String str3 = aVar3.f2571b;
                                if (!TextUtils.isEmpty(str3)) {
                                    if (messageDigest == null) {
                                        try {
                                            messageDigest = com.tencent.tbs.one.impl.e.f.a();
                                        } catch (TBSOneException e2) {
                                            aVar.a(e2.getErrorCode(), e2.getMessage(), e2.getCause());
                                            AppMethodBeat.o(174070);
                                            return;
                                        }
                                    }
                                    com.tencent.tbs.one.impl.e.f.a(messageDigest, file2, str3);
                                }
                            } catch (IOException e3) {
                                aVar.a(312, "Failed to copy builtin component file from " + a2.getAbsolutePath() + " to " + file2.getAbsolutePath(), e3);
                                AppMethodBeat.o(174070);
                                return;
                            }
                        }
                        aVar.a(com.tencent.tbs.one.impl.e.e.a(e.a.BUILTIN, file));
                        AppMethodBeat.o(174070);
                    } catch (IOException e4) {
                        aVar.a(312, "Failed to copy builtin component file from " + a2.getAbsolutePath() + " to " + a3.getAbsolutePath(), e4);
                        AppMethodBeat.o(174070);
                    }
                } catch (TBSOneException e5) {
                    aVar.a(e5.getErrorCode(), e5.getMessage(), e5.getCause());
                    AppMethodBeat.o(174070);
                }
            }
        });
        AppMethodBeat.o(174068);
    }
}
