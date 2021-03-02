package com.tencent.mm.vfs;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class o implements Comparable<o> {
    private g.e RdK;
    public final Uri mUri;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(o oVar) {
        AppMethodBeat.i(13261);
        int compareTo = aa.z(this.mUri).compareTo(aa.z(oVar.mUri));
        AppMethodBeat.o(13261);
        return compareTo;
    }

    public final g.e heo() {
        AppMethodBeat.i(13228);
        this.RdK = g.hYQ().a(this.mUri, this.RdK);
        g.e eVar = this.RdK;
        AppMethodBeat.o(13228);
        return eVar;
    }

    public static o X(File file) {
        AppMethodBeat.i(177541);
        if (file != null) {
            o oVar = new o(file);
            AppMethodBeat.o(177541);
            return oVar;
        }
        AppMethodBeat.o(177541);
        return null;
    }

    public o(String str) {
        this(aa.parseUri(str));
        AppMethodBeat.i(13229);
        AppMethodBeat.o(13229);
    }

    public o(Uri uri) {
        AppMethodBeat.i(13230);
        this.RdK = null;
        String path = uri.getPath();
        if (path != null) {
            String q = aa.q(path, false, false);
            if (!uri.getPath().equals(q)) {
                uri = uri.buildUpon().path(q).build();
            }
        }
        this.mUri = uri;
        AppMethodBeat.o(13230);
    }

    @Deprecated
    public o(File file) {
        this(aa.parseUri(file.getPath()));
        AppMethodBeat.i(13231);
        AppMethodBeat.o(13231);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public o(String str, String str2) {
        this(str == null ? null : aa.parseUri(str), str2);
        AppMethodBeat.i(13232);
        AppMethodBeat.o(13232);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public o(com.tencent.mm.vfs.o r3, java.lang.String r4) {
        /*
            r2 = this;
            r1 = 13233(0x33b1, float:1.8543E-41)
            if (r3 != 0) goto L_0x000f
            r0 = 0
        L_0x0005:
            r2.<init>(r0, r4)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x000f:
            android.net.Uri r0 = r3.mUri
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.o.<init>(com.tencent.mm.vfs.o, java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public o(File file, String str) {
        this(file == null ? null : aa.parseUri(file.getPath()), str);
        AppMethodBeat.i(13234);
        AppMethodBeat.o(13234);
    }

    private o(Uri uri, String str) {
        Uri.Builder buildUpon;
        Uri uri2;
        AppMethodBeat.i(13235);
        this.RdK = null;
        if (uri == null) {
            buildUpon = new Uri.Builder().path(str);
        } else {
            buildUpon = uri.buildUpon();
            if (!str.isEmpty()) {
                buildUpon.appendPath(str);
            }
        }
        Uri build = buildUpon.build();
        String path = build.getPath();
        if (path != null) {
            String q = aa.q(path, false, false);
            if (!build.getPath().equals(q)) {
                uri2 = buildUpon.path(q).build();
                this.mUri = uri2;
                AppMethodBeat.o(13235);
            }
        }
        uri2 = build;
        this.mUri = uri2;
        AppMethodBeat.o(13235);
    }

    public final String getPath() {
        AppMethodBeat.i(258775);
        String z = aa.z(this.mUri);
        AppMethodBeat.o(258775);
        return z;
    }

    public final String getName() {
        AppMethodBeat.i(13237);
        String path = this.mUri.getPath();
        int lastIndexOf = path.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (lastIndexOf < 0) {
            AppMethodBeat.o(13237);
            return path;
        }
        String substring = path.substring(lastIndexOf + 1);
        AppMethodBeat.o(13237);
        return substring;
    }

    private Uri hep() {
        String substring;
        AppMethodBeat.i(13238);
        String path = this.mUri.getPath();
        int length = path.length();
        int lastIndexOf = path.lastIndexOf(47);
        if (lastIndexOf == -1 || path.charAt(length - 1) == '/') {
            AppMethodBeat.o(13238);
            return null;
        }
        if (path.indexOf(47) == lastIndexOf && path.charAt(0) == '/') {
            substring = path.substring(0, lastIndexOf + 1);
        } else {
            substring = path.substring(0, lastIndexOf);
        }
        Uri build = this.mUri.buildUpon().path(substring).build();
        AppMethodBeat.o(13238);
        return build;
    }

    public final String getParent() {
        AppMethodBeat.i(13239);
        Uri hep = hep();
        if (hep == null) {
            AppMethodBeat.o(13239);
            return null;
        }
        String z = aa.z(hep);
        AppMethodBeat.o(13239);
        return z;
    }

    public final o heq() {
        AppMethodBeat.i(13240);
        Uri hep = hep();
        if (hep == null) {
            AppMethodBeat.o(13240);
            return null;
        }
        o oVar = new o(hep);
        AppMethodBeat.o(13240);
        return oVar;
    }

    public final boolean canRead() {
        AppMethodBeat.i(13241);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13241);
            return false;
        }
        FileSystem.b bVar = heo.Rcl;
        String dz = bVar.dz(heo.path, false);
        if (dz != null) {
            boolean canRead = new File(dz).canRead();
            AppMethodBeat.o(13241);
            return canRead;
        }
        boolean boL = bVar.boL(heo.path);
        AppMethodBeat.o(13241);
        return boL;
    }

    public final boolean canWrite() {
        AppMethodBeat.i(170159);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(170159);
            return false;
        }
        FileSystem.b bVar = heo.Rcl;
        if ((bVar.hdR() & 1) == 0) {
            AppMethodBeat.o(170159);
            return false;
        }
        String dz = bVar.dz(heo.path, true);
        if (dz != null) {
            boolean canWrite = new File(dz).canWrite();
            AppMethodBeat.o(170159);
            return canWrite;
        }
        boolean boL = bVar.boL(heo.path);
        AppMethodBeat.o(170159);
        return boL;
    }

    public final boolean exists() {
        AppMethodBeat.i(13242);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13242);
            return false;
        }
        boolean boL = heo.Rcl.boL(heo.path);
        AppMethodBeat.o(13242);
        return boL;
    }

    public final String getAbsolutePath() {
        AppMethodBeat.i(258776);
        String z = aa.z(her());
        AppMethodBeat.o(258776);
        return z;
    }

    public final o hes() {
        AppMethodBeat.i(13245);
        o oVar = new o(her());
        AppMethodBeat.o(13245);
        return oVar;
    }

    public final boolean isDirectory() {
        AppMethodBeat.i(13246);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13246);
            return false;
        }
        e boM = heo.Rcl.boM(heo.path);
        if (boM == null || !boM.RbJ) {
            AppMethodBeat.o(13246);
            return false;
        }
        AppMethodBeat.o(13246);
        return true;
    }

    public final boolean isFile() {
        AppMethodBeat.i(13247);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13247);
            return false;
        }
        e boM = heo.Rcl.boM(heo.path);
        if (boM == null || boM.RbJ) {
            AppMethodBeat.o(13247);
            return false;
        }
        AppMethodBeat.o(13247);
        return true;
    }

    public final boolean isHidden() {
        AppMethodBeat.i(170161);
        if (this.mUri.getPath().isEmpty()) {
            AppMethodBeat.o(170161);
            return false;
        }
        boolean startsWith = getName().startsWith(".");
        AppMethodBeat.o(170161);
        return startsWith;
    }

    public final long lastModified() {
        AppMethodBeat.i(13248);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13248);
            return 0;
        }
        e boM = heo.Rcl.boM(heo.path);
        if (boM == null) {
            AppMethodBeat.o(13248);
            return 0;
        }
        long j2 = boM.RbI;
        AppMethodBeat.o(13248);
        return j2;
    }

    public final long length() {
        AppMethodBeat.i(13249);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13249);
            return 0;
        }
        e boM = heo.Rcl.boM(heo.path);
        if (boM == null) {
            AppMethodBeat.o(13249);
            return 0;
        }
        long j2 = boM.size;
        AppMethodBeat.o(13249);
        return j2;
    }

    public final String[] list() {
        AppMethodBeat.i(13250);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13250);
            return null;
        }
        Iterable<e> dx = heo.Rcl.dx(heo.path, false);
        if (dx == null) {
            AppMethodBeat.o(13250);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : dx) {
            arrayList.add(eVar.name);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        AppMethodBeat.o(13250);
        return strArr;
    }

    public final String[] a(w wVar) {
        AppMethodBeat.i(170162);
        if (wVar == null) {
            String[] list = list();
            AppMethodBeat.o(170162);
            return list;
        }
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(170162);
            return null;
        }
        Iterable<e> dx = heo.Rcl.dx(heo.path, false);
        if (dx == null) {
            AppMethodBeat.o(170162);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : dx) {
            if (wVar.accept(this, eVar.name)) {
                arrayList.add(eVar.name);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        AppMethodBeat.o(170162);
        return strArr;
    }

    public final o[] het() {
        AppMethodBeat.i(13251);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13251);
            return null;
        }
        Iterable<e> dx = heo.Rcl.dx(heo.path, false);
        if (dx == null) {
            AppMethodBeat.o(13251);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : dx) {
            arrayList.add(new o(this, eVar.name));
        }
        o[] oVarArr = (o[]) arrayList.toArray(new o[0]);
        AppMethodBeat.o(13251);
        return oVarArr;
    }

    public final o[] b(w wVar) {
        AppMethodBeat.i(170163);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(170163);
            return null;
        }
        Iterable<e> dx = heo.Rcl.dx(heo.path, false);
        if (dx == null) {
            AppMethodBeat.o(170163);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : dx) {
            if (wVar.accept(this, eVar.name)) {
                arrayList.add(new o(this, eVar.name));
            }
        }
        o[] oVarArr = (o[]) arrayList.toArray(new o[0]);
        AppMethodBeat.o(170163);
        return oVarArr;
    }

    public final o[] a(q qVar) {
        AppMethodBeat.i(13252);
        if (qVar == null) {
            o[] het = het();
            AppMethodBeat.o(13252);
            return het;
        }
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13252);
            return null;
        }
        Iterable<e> dx = heo.Rcl.dx(heo.path, false);
        if (dx == null) {
            AppMethodBeat.o(13252);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : dx) {
            o oVar = new o(this, eVar.name);
            if (qVar.accept(oVar)) {
                arrayList.add(oVar);
            }
        }
        o[] oVarArr = (o[]) arrayList.toArray(new o[0]);
        AppMethodBeat.o(13252);
        return oVarArr;
    }

    public final boolean mkdir() {
        AppMethodBeat.i(258777);
        boolean mkdirs = mkdirs();
        AppMethodBeat.o(258777);
        return mkdirs;
    }

    public final boolean mkdirs() {
        AppMethodBeat.i(13253);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13253);
            return false;
        }
        boolean boN = heo.Rcl.boN(heo.path);
        AppMethodBeat.o(13253);
        return boN;
    }

    public final boolean createNewFile() {
        AppMethodBeat.i(13254);
        g.e heo = heo();
        if (!heo.valid()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
            AppMethodBeat.o(13254);
            throw fileNotFoundException;
        } else if (heo.Rcl.boL(heo.path)) {
            AppMethodBeat.o(13254);
            return false;
        } else {
            heo.Rcl.dw(heo.path, false).close();
            AppMethodBeat.o(13254);
            return true;
        }
    }

    public final boolean am(o oVar) {
        AppMethodBeat.i(13255);
        g.e heo = heo();
        g.e heo2 = oVar.heo();
        if (!heo.valid() || !heo2.valid()) {
            AppMethodBeat.o(13255);
            return false;
        }
        try {
            heo2.Rcl.a(heo2.path, heo.Rcl, heo.path);
            AppMethodBeat.o(13255);
            return true;
        } catch (IOException e2) {
            AppMethodBeat.o(13255);
            return false;
        }
    }

    public final boolean delete() {
        AppMethodBeat.i(13256);
        g.e heo = heo();
        if (!heo.valid() || !heo.Rcl.gC(heo.path)) {
            AppMethodBeat.o(13256);
            return false;
        }
        AppMethodBeat.o(13256);
        return true;
    }

    public final long getUsableSpace() {
        AppMethodBeat.i(13257);
        g.e heo = heo();
        if (!heo.valid()) {
            AppMethodBeat.o(13257);
            return 0;
        }
        FileSystem.a boK = heo.Rcl.boK(heo.path);
        if (boK == null) {
            AppMethodBeat.o(13257);
            return 0;
        }
        long j2 = boK.RbL;
        AppMethodBeat.o(13257);
        return j2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(13259);
        if (!(obj instanceof o)) {
            AppMethodBeat.o(13259);
            return false;
        }
        boolean equals = this.mUri.equals(((o) obj).mUri);
        AppMethodBeat.o(13259);
        return equals;
    }

    public String toString() {
        AppMethodBeat.i(13260);
        String uri = this.mUri.toString();
        AppMethodBeat.o(13260);
        return uri;
    }

    public final Uri her() {
        boolean z = false;
        AppMethodBeat.i(13243);
        String path = this.mUri.getPath();
        if (this.mUri.isAbsolute() || (path.length() > 0 && path.charAt(0) == '/')) {
            z = true;
        }
        if (z) {
            Uri uri = this.mUri;
            AppMethodBeat.o(13243);
            return uri;
        }
        String path2 = this.mUri.getPath();
        String property = System.getProperty("user.dir");
        if (!path2.isEmpty()) {
            property = property + '/' + path2;
        }
        Uri build = this.mUri.buildUpon().path(property).build();
        AppMethodBeat.o(13243);
        return build;
    }

    public int hashCode() {
        AppMethodBeat.i(13258);
        int hashCode = aa.z(this.mUri).hashCode() ^ 1234321;
        AppMethodBeat.o(13258);
        return hashCode;
    }
}
