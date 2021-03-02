package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageGCFileSystem extends AbstractFileSystem {
    public static final Parcelable.Creator<ImageGCFileSystem> CREATOR = new Parcelable.Creator<ImageGCFileSystem>() {
        /* class com.tencent.mm.vfs.ImageGCFileSystem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ImageGCFileSystem[] newArray(int i2) {
            return new ImageGCFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ImageGCFileSystem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(197216);
            ImageGCFileSystem imageGCFileSystem = new ImageGCFileSystem(parcel);
            AppMethodBeat.o(197216);
            return imageGCFileSystem;
        }
    };
    protected final FileSystem Rbo;

    static /* synthetic */ List c(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(259573);
        List<String> b2 = b(cancellationSignal);
        AppMethodBeat.o(259573);
        return b2;
    }

    public ImageGCFileSystem(FileSystem fileSystem) {
        this.Rbo = fileSystem;
    }

    protected ImageGCFileSystem(Parcel parcel) {
        AppMethodBeat.i(197220);
        aa.a(parcel, ImageGCFileSystem.class, 1);
        this.Rbo = (FileSystem) parcel.readParcelable(ImageGCFileSystem.class.getClassLoader());
        AppMethodBeat.o(197220);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(197221);
        aa.b(parcel, ImageGCFileSystem.class, 1);
        parcel.writeParcelable(this.Rbo, i2);
        AppMethodBeat.o(197221);
    }

    public String toString() {
        AppMethodBeat.i(197222);
        String str = "ImageGC [" + this.Rbo.toString() + ']';
        AppMethodBeat.o(197222);
        return str;
    }

    static {
        AppMethodBeat.i(197228);
        AppMethodBeat.o(197228);
    }

    protected class b extends c {
        protected final List<FileSystem.b> RbF;
        protected final FileSystem.b Rbp;

        protected b(FileSystem.b bVar) {
            AppMethodBeat.i(197218);
            this.Rbp = bVar;
            this.RbF = Collections.singletonList(bVar);
            AppMethodBeat.o(197218);
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return ImageGCFileSystem.this;
        }

        @Override // com.tencent.mm.vfs.c
        public final FileSystem.b ho(String str, int i2) {
            return this.Rbp;
        }

        @Override // com.tencent.mm.vfs.c
        public final List<FileSystem.b> hdS() {
            return this.RbF;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final void a(CancellationSignal cancellationSignal) {
            char c2;
            AppMethodBeat.i(197219);
            long bpi = aa.bpi("image-clean");
            if (!ImageGCFileSystem.access$200()) {
                Log.i("VFS.ImageGCFileSystem", "X Switch disabled, skip cleanup.");
            } else if (bpi < 604800000) {
                Log.i("VFS.ImageGCFileSystem", "Image cleanup interval not match, skip cleanup. %d / %d", Long.valueOf(bpi), 604800000L);
            } else {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                long j7 = 0;
                List c3 = ImageGCFileSystem.c(cancellationSignal);
                cancellationSignal.throwIfCanceled();
                if (c3 != null) {
                    Iterable<e> dx = dx("", true);
                    if (dx == null) {
                        dx = Collections.emptyList();
                    }
                    int i8 = 0;
                    ArrayList arrayList = new ArrayList();
                    HashSet hashSet = new HashSet();
                    Pattern compile = Pattern.compile("[0-9a-f]{32}");
                    Pattern compile2 = Pattern.compile("[A-Za-z0-9_@\\-]+_[A-Za-z0-9_@\\-]+_[0-9]+_backup");
                    Pattern compile3 = Pattern.compile("(?:th_(?:photoEdited|capture)_)?(1[3-7][0-9]{11,})");
                    long currentTimeMillis = System.currentTimeMillis();
                    for (e eVar : dx) {
                        int i9 = i8 + 1;
                        if (i8 >= 10) {
                            i8 = 0;
                            cancellationSignal.throwIfCanceled();
                        } else {
                            i8 = i9;
                        }
                        if (!eVar.RbJ) {
                            if (currentTimeMillis - eVar.RbI < 43200000) {
                                c2 = 0;
                            } else {
                                Matcher matcher = compile.matcher(eVar.name);
                                if (!matcher.find()) {
                                    Matcher matcher2 = compile2.matcher(eVar.name);
                                    if (matcher2.find()) {
                                        if (Collections.binarySearch(c3, matcher2.group()) >= 0) {
                                            c2 = 0;
                                        } else {
                                            c2 = 1;
                                            i5++;
                                            j5 += eVar.RbH;
                                        }
                                    } else if (compile3.matcher(eVar.name).matches()) {
                                        c2 = 1;
                                        i6++;
                                        j6 += eVar.RbH;
                                    } else if (eVar.name.equals(FilePathGenerator.NO_MEDIA_FILENAME)) {
                                        c2 = 1;
                                    } else {
                                        c2 = 2;
                                    }
                                } else if (Collections.binarySearch(c3, matcher.group()) >= 0) {
                                    c2 = 0;
                                } else if (eVar.name.startsWith("th_")) {
                                    c2 = 0;
                                    i7++;
                                    j7 += eVar.RbH;
                                } else {
                                    c2 = 1;
                                    i5++;
                                    j5 += eVar.RbH;
                                }
                            }
                            switch (c2) {
                                case 0:
                                    i3++;
                                    j3 += eVar.RbH;
                                    break;
                                case 1:
                                    i2++;
                                    j2 += eVar.RbH;
                                    eVar.hdW();
                                    break;
                                case 2:
                                    Log.w("VFS.ImageGCFileSystem", "Illegal file found: " + eVar.NGP);
                                    i4++;
                                    j4 += eVar.RbH;
                                    for (String bpg = aa.bpg(eVar.NGP); bpg != null; bpg = aa.bpg(bpg)) {
                                        hashSet.add(bpg);
                                    }
                                default:
                                    i7 = i7;
                                    break;
                            }
                        } else if (!ImageGCFileSystem.P(eVar.NGP, c3)) {
                            arrayList.add(eVar.NGP);
                        }
                        i7 = i7;
                    }
                    cancellationSignal.throwIfCanceled();
                    ListIterator listIterator = arrayList.listIterator(arrayList.size());
                    while (listIterator.hasPrevious()) {
                        cancellationSignal.throwIfCanceled();
                        String str = (String) listIterator.previous();
                        if (!hashSet.contains(str)) {
                            dy(str, false);
                        }
                    }
                }
                Log.i("VFS.ImageGCFileSystem", " > deletedFiles: %d, deletedSize: %d\n > keptFiles: %d, keptSize: %d\n > illegalFiles: %d, illegalSize: %d\n > wildFiles: %d, wildSize: %d\n > tempFiles: %d, tempSize: %d\n > noMediaFiles: %d, noMediaSize: %d", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j5), Integer.valueOf(i6), Long.valueOf(j6), Integer.valueOf(i7), Long.valueOf(j7));
                ImageGCFileSystem.this.l(2, "deletedFiles", Integer.valueOf(i2), "deletedSize", Long.valueOf(j2), "keptFiles", Integer.valueOf(i3), "keptSize", Long.valueOf(j3), "illegalFiles", Integer.valueOf(i4), "illegalSize", Long.valueOf(j4), "wildFiles", Integer.valueOf(i5), "wildSize", Long.valueOf(j5), "tempFiles", Integer.valueOf(i6), "tempSize", Long.valueOf(j6), "customFiles", Integer.valueOf(i7), "customSize", Long.valueOf(j7));
                aa.bph("image-clean");
            }
            cancellationSignal.throwIfCanceled();
            super.a(cancellationSignal);
            AppMethodBeat.o(197219);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String> b(android.os.CancellationSignal r15) {
        /*
        // Method dump skipped, instructions count: 267
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.ImageGCFileSystem.b(android.os.CancellationSignal):java.util.List");
    }

    public static final class a implements n.a {
        @Override // com.tencent.mm.vfs.n.a
        public final void a(String str, FileSystem fileSystem, int i2, Map<String, Object> map) {
            AppMethodBeat.i(197217);
            e.INSTANCE.a(22046, str, map.get("deletedFiles"), map.get("deletedSize"), map.get("keptFiles"), map.get("keptSize"), map.get("illegalFiles"), map.get("illegalSize"), map.get("wildFiles"), map.get("wildSize"), map.get("tempFiles"), map.get("tempSize"), map.get("customFiles"), map.get("customSize"));
            AppMethodBeat.o(197217);
        }
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final /* synthetic */ FileSystem.b cj(Map map) {
        AppMethodBeat.i(197224);
        b bVar = new b(this.Rbo.cj(map));
        AppMethodBeat.o(197224);
        return bVar;
    }

    static /* synthetic */ boolean P(String str, List list) {
        AppMethodBeat.i(197226);
        if (str.length() > 2) {
            str = str.replace(FilePathGenerator.ANDROID_DIR_SEP, "");
        }
        int binarySearch = Collections.binarySearch(list, str);
        if (binarySearch >= 0) {
            AppMethodBeat.o(197226);
            return true;
        }
        int i2 = (-binarySearch) - 2;
        if (i2 < 0) {
            AppMethodBeat.o(197226);
            return false;
        }
        boolean startsWith = str.startsWith((String) list.get(i2));
        AppMethodBeat.o(197226);
        return startsWith;
    }

    static /* synthetic */ boolean access$200() {
        AppMethodBeat.i(197227);
        if (WeChatEnvironment.hasDebugger() || !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(d.cRY().b("clicfg_clean_image2", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true))) {
            AppMethodBeat.o(197227);
            return true;
        }
        AppMethodBeat.o(197227);
        return false;
    }
}
