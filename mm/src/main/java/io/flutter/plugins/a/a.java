package io.flutter.plugins.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class a implements io.flutter.embedding.engine.plugins.a, k.c {
    private k bbv;
    private Context context;

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(199145);
        this.bbv = new k(bVar.wJi.SNW, "plugins.flutter.io/path_provider");
        this.context = bVar.applicationContext;
        this.bbv.a(this);
        AppMethodBeat.o(199145);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(199146);
        this.bbv.a(null);
        this.bbv = null;
        AppMethodBeat.o(199146);
    }

    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
        String str = null;
        AppMethodBeat.i(153351);
        String str2 = jVar.method;
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1832373352:
                if (str2.equals("getApplicationSupportDirectory")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1208689078:
                if (str2.equals("getExternalCacheDirectories")) {
                    c2 = 3;
                    break;
                }
                break;
            case 299667825:
                if (str2.equals("getExternalStorageDirectories")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1200320591:
                if (str2.equals("getApplicationDocumentsDirectory")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1252916648:
                if (str2.equals("getStorageDirectory")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1711844626:
                if (str2.equals("getTemporaryDirectory")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                dVar.ba(this.context.getCacheDir().getPath());
                AppMethodBeat.o(153351);
                return;
            case 1:
                dVar.ba(io.flutter.a.a.lO(this.context));
                AppMethodBeat.o(153351);
                return;
            case 2:
                File externalFilesDir = this.context.getExternalFilesDir(null);
                dVar.ba(externalFilesDir == null ? null : externalFilesDir.getAbsolutePath());
                AppMethodBeat.o(153351);
                return;
            case 3:
                ArrayList arrayList = new ArrayList();
                if (Build.VERSION.SDK_INT >= 19) {
                    File[] externalCacheDirs = this.context.getExternalCacheDirs();
                    for (File file : externalCacheDirs) {
                        if (file != null) {
                            arrayList.add(file.getAbsolutePath());
                        }
                    }
                } else {
                    File externalCacheDir = this.context.getExternalCacheDir();
                    if (externalCacheDir != null) {
                        arrayList.add(externalCacheDir.getAbsolutePath());
                    }
                }
                dVar.ba(arrayList);
                AppMethodBeat.o(153351);
                return;
            case 4:
                Integer num = (Integer) jVar.btq("type");
                if (num != null) {
                    switch (num.intValue()) {
                        case 0:
                            str = Environment.DIRECTORY_MUSIC;
                            break;
                        case 1:
                            str = Environment.DIRECTORY_PODCASTS;
                            break;
                        case 2:
                            str = Environment.DIRECTORY_RINGTONES;
                            break;
                        case 3:
                            str = Environment.DIRECTORY_ALARMS;
                            break;
                        case 4:
                            str = Environment.DIRECTORY_NOTIFICATIONS;
                            break;
                        case 5:
                            str = Environment.DIRECTORY_PICTURES;
                            break;
                        case 6:
                            str = Environment.DIRECTORY_MOVIES;
                            break;
                        case 7:
                            str = Environment.DIRECTORY_DOWNLOADS;
                            break;
                        case 8:
                            str = Environment.DIRECTORY_DCIM;
                            break;
                        case 9:
                            if (Build.VERSION.SDK_INT >= 19) {
                                str = Environment.DIRECTORY_DOCUMENTS;
                                break;
                            } else {
                                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Documents directory is unsupported.");
                                AppMethodBeat.o(153351);
                                throw illegalArgumentException;
                            }
                        default:
                            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Unknown index: ".concat(String.valueOf(num)));
                            AppMethodBeat.o(153351);
                            throw illegalArgumentException2;
                    }
                }
                dVar.ba(btt(str));
                AppMethodBeat.o(153351);
                return;
            case 5:
                dVar.ba(this.context.getFilesDir().getPath());
                AppMethodBeat.o(153351);
                return;
            default:
                dVar.dLv();
                AppMethodBeat.o(153351);
                return;
        }
    }

    private List<String> btt(String str) {
        AppMethodBeat.i(199147);
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            File[] externalFilesDirs = this.context.getExternalFilesDirs(str);
            for (File file : externalFilesDirs) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalFilesDir = this.context.getExternalFilesDir(str);
            if (externalFilesDir != null) {
                arrayList.add(externalFilesDir.getAbsolutePath());
            }
        }
        AppMethodBeat.o(199147);
        return arrayList;
    }
}
