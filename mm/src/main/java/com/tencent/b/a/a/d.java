package com.tencent.b.a.a;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

final class d extends q {
    d(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final boolean TW() {
        AppMethodBeat.i(87600);
        if (!s.checkPermission(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") || !Environment.getExternalStorageState().equals("mounted")) {
            AppMethodBeat.o(87600);
            return false;
        }
        AppMethodBeat.o(87600);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final String read() {
        String str;
        AppMethodBeat.i(87601);
        synchronized (this) {
            try {
                s.Uf();
                try {
                    Iterator<String> it = c.z(new File(Environment.getExternalStorageDirectory(), s.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String[] split = it.next().split(",");
                            if (split.length == 2 && split[0].equals(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                                new StringBuilder("read mid from InternalStorage:").append(split[1]);
                                s.Uf();
                                str = split[1];
                                break;
                            }
                        } else {
                            str = null;
                            break;
                        }
                    }
                } catch (IOException e2) {
                    s.Ug();
                    str = null;
                }
            } finally {
                AppMethodBeat.o(87601);
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final void write(String str) {
        AppMethodBeat.i(87602);
        synchronized (this) {
            try {
                s.Uf();
                c.eV(Environment.getExternalStorageDirectory() + FilePathGenerator.ANDROID_DIR_SEP + s.decode("6X8Y4XdM2Vhvn0I="));
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), s.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                    bufferedWriter.write(String.valueOf(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw==")) + "," + str);
                    bufferedWriter.write("\n");
                    bufferedWriter.close();
                } catch (Exception e2) {
                    s.Ug();
                }
            } finally {
                AppMethodBeat.o(87602);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final a TX() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final void a(a aVar) {
    }
}
