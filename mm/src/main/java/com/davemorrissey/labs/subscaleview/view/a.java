package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;

public final class a {
    final Integer aWV;
    public boolean aWW;
    public int aWX;
    public int aWY;
    public Rect aWZ;
    boolean aXa;
    public final Bitmap bitmap;
    private final o file;

    private a(Bitmap bitmap2, boolean z) {
        AppMethodBeat.i(208712);
        this.bitmap = bitmap2;
        this.file = null;
        this.aWV = null;
        this.aWW = false;
        this.aWX = bitmap2.getWidth();
        this.aWY = bitmap2.getHeight();
        this.aXa = z;
        AppMethodBeat.o(208712);
    }

    private a(o oVar) {
        this.bitmap = null;
        this.file = oVar;
        this.aWV = null;
        this.aWW = true;
    }

    a(int i2) {
        AppMethodBeat.i(157373);
        this.bitmap = null;
        this.file = null;
        this.aWV = Integer.valueOf(i2);
        this.aWW = true;
        AppMethodBeat.o(157373);
    }

    public static a aP(String str) {
        AppMethodBeat.i(157374);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("Uri must not be null");
            AppMethodBeat.o(157374);
            throw nullPointerException;
        }
        a aVar = new a(new o(str));
        AppMethodBeat.o(157374);
        return aVar;
    }

    public static a l(Bitmap bitmap2) {
        AppMethodBeat.i(208713);
        if (bitmap2 == null) {
            NullPointerException nullPointerException = new NullPointerException("Bitmap must not be null");
            AppMethodBeat.o(208713);
            throw nullPointerException;
        }
        a aVar = new a(bitmap2, false);
        AppMethodBeat.o(208713);
        return aVar;
    }

    public static a m(Bitmap bitmap2) {
        AppMethodBeat.i(182604);
        if (bitmap2 == null) {
            NullPointerException nullPointerException = new NullPointerException("Bitmap must not be null");
            AppMethodBeat.o(182604);
            throw nullPointerException;
        }
        a aVar = new a(bitmap2, true);
        AppMethodBeat.o(182604);
        return aVar;
    }

    public final Uri getUri() {
        if (this.file == null) {
            return null;
        }
        return this.file.mUri;
    }

    public final a rM() {
        this.aWW = true;
        return this;
    }
}
