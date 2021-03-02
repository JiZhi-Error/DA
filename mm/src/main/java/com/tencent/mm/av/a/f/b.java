package com.tencent.mm.av.a.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.a;
import com.tencent.mm.av.a.c.e;
import com.tencent.mm.av.a.c.f;
import com.tencent.mm.av.a.c.g;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.a.c.i;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.a.c.l;
import com.tencent.mm.av.a.c.m;
import com.tencent.mm.av.a.c.n;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.av.a.c.p;
import com.tencent.mm.av.a.c.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class b implements Runnable {
    private final com.tencent.mm.av.a.a.b jaJ = this.jbK.jaJ;
    public final c jaR;
    private final o jaS;
    private final com.tencent.mm.av.a.c.b jaT;
    private final com.tencent.mm.av.a.c.c jaU;
    private final l jaW;
    private final f jaY;
    private final q jbB;
    private final a jbC;
    private final i jbD;
    private final com.tencent.mm.av.a.b jbK;
    public final com.tencent.mm.av.a.c jbM;
    private final MMHandler jbN;
    private final k jbO;
    private final h jbP;
    private final g jbQ;
    private final m jbR;
    private final e jbS;
    private final n jbT;
    private final p jbb;
    public final String url;

    public b(String str, com.tencent.mm.av.a.c cVar, MMHandler mMHandler, c cVar2, k kVar, com.tencent.mm.av.a.b bVar, h hVar) {
        AppMethodBeat.i(130435);
        this.url = str;
        this.jbM = cVar;
        this.jbN = mMHandler;
        this.jbK = bVar;
        this.jbP = hVar;
        if (cVar2 == null) {
            this.jaR = this.jaJ.jaR;
        } else {
            this.jaR = cVar2;
        }
        this.jbO = kVar;
        this.jaW = this.jaJ.jaW;
        if (this.jaR.jaU != null) {
            this.jaU = this.jaR.jaU;
        } else {
            this.jaU = this.jaJ.jaU;
        }
        this.jbB = this.jaR.jbB;
        this.jbC = this.jaR.jbC;
        this.jbD = this.jaR.jbD;
        this.jaS = this.jaJ.jaS;
        this.jaT = this.jaJ.jaT;
        this.jbQ = this.jaJ.jaV;
        this.jbR = this.jaJ.jaX;
        this.jaY = this.jaJ.jaY;
        this.jbS = null;
        this.jbT = null;
        this.jbb = this.jaJ.jbb;
        AppMethodBeat.o(130435);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00be A[Catch:{ Exception -> 0x0723 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0420 A[SYNTHETIC, Splitter:B:141:0x0420] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x049a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00c7 A[Catch:{ Exception -> 0x0723 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0651  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 1884
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.a.f.b.run():void");
    }

    private void i(String str, Bitmap bitmap) {
        AppMethodBeat.i(130437);
        if (this.jaR.jbd) {
            Log.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", this.url);
            this.jaS.put(str, bitmap);
        }
        AppMethodBeat.o(130437);
    }

    private Bitmap a(com.tencent.mm.av.a.d.b bVar, Bitmap bitmap) {
        AppMethodBeat.i(130438);
        if (!(this.jbP == null || bVar == null)) {
            bVar.bitmap = bitmap;
            Bitmap a2 = this.jbP.a(this.url, this.jbM.getImageView(), bVar);
            if (a2 != null && !a2.isRecycled()) {
                AppMethodBeat.o(130438);
                return a2;
            }
        }
        AppMethodBeat.o(130438);
        return bitmap;
    }

    public final String Pc(String str) {
        AppMethodBeat.i(130439);
        if (Util.isNullOrNil(str) || this.jaR == null) {
            AppMethodBeat.o(130439);
            return null;
        }
        if (this.jaR.iaT) {
            str = str + "round" + this.jaR.jbx;
        }
        if (!Util.isNullOrNil(this.jaR.jbv)) {
            str = str + this.jaR.jbv;
        }
        String str2 = str + "size" + this.jaR.hZz + this.jaR.hZA;
        AppMethodBeat.o(130439);
        return str2;
    }

    public final void AC(long j2) {
        AppMethodBeat.i(130440);
        if (this.jaW != null) {
            this.jaW.AC(j2);
        }
        AppMethodBeat.o(130440);
    }
}
