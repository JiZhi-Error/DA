package com.tencent.mm.toolkit.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.b;
import com.tencent.mm.toolkit.a.a.d;
import com.tencent.mm.toolkit.a.a.e;
import com.tencent.mm.toolkit.a.a.f;
import java.io.File;
import java.util.HashMap;

public final class c implements Comparable<c> {
    public f OvA;
    private e OvB;
    public b OvC;
    private d OvD;
    private Uri Ovo;
    Uri Ovp;
    File Ovq;
    public File Ovr;
    boolean Ovs = true;
    boolean Ovt = true;
    boolean Ovu = false;
    int Ovv = 0;
    long Ovw = 0;
    long Ovx = 1000;
    private a Ovy = a.NORMAL;
    HashMap<String, String> Ovz;
    boolean mCancelled = false;
    public long mContentLength = -1;
    int mId;
    int mState;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(c cVar) {
        AppMethodBeat.i(196818);
        c cVar2 = cVar;
        a aVar = this.Ovy;
        a aVar2 = cVar2.Ovy;
        if (aVar == aVar2) {
            int i2 = this.mId - cVar2.mId;
            AppMethodBeat.o(196818);
            return i2;
        }
        int ordinal = aVar2.ordinal() - aVar.ordinal();
        AppMethodBeat.o(196818);
        return ordinal;
    }

    public c(String str) {
        AppMethodBeat.i(196814);
        if (TextUtils.isEmpty(str)) {
            NullPointerException nullPointerException = new NullPointerException("uri is invalid!");
            AppMethodBeat.o(196814);
            throw nullPointerException;
        }
        Uri parse = Uri.parse(str);
        this.Ovz = new HashMap<>();
        this.mState = 2000;
        this.Ovo = parse;
        this.Ovp = parse;
        AppMethodBeat.o(196814);
    }

    public final c T(File file) {
        AppMethodBeat.i(196815);
        this.Ovr = file;
        this.Ovq = new File(file.getAbsolutePath() + ".tmp");
        AppMethodBeat.o(196815);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final e gGc() {
        AppMethodBeat.i(196816);
        while (this.OvB == null) {
            this.OvB = new e.a();
        }
        e eVar = this.OvB;
        AppMethodBeat.o(196816);
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public final void finish() {
        AppMethodBeat.i(196817);
        if (this.OvD != null) {
            this.OvD.f(this);
        }
        AppMethodBeat.o(196817);
    }

    public enum a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE;

        public static a valueOf(String str) {
            AppMethodBeat.i(196812);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(196812);
            return aVar;
        }

        static {
            AppMethodBeat.i(196813);
            AppMethodBeat.o(196813);
        }
    }
}
