package com.google.b;

import com.google.b.b.b;
import com.google.b.d.d;
import com.google.b.d.f;
import com.google.b.d.h;
import com.google.b.d.j;
import com.google.b.d.k;
import com.google.b.d.m;
import com.google.b.d.p;
import com.google.b.d.t;
import com.google.b.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e implements g {
    @Override // com.google.b.g
    public final b a(String str, a aVar, int i2, int i3, Map<c, ?> map) {
        g aVar2;
        AppMethodBeat.i(12285);
        switch (aVar) {
            case EAN_8:
                aVar2 = new k();
                break;
            case UPC_E:
                aVar2 = new t();
                break;
            case EAN_13:
                aVar2 = new j();
                break;
            case UPC_A:
                aVar2 = new p();
                break;
            case QR_CODE:
                aVar2 = new a();
                break;
            case CODE_39:
                aVar2 = new f();
                break;
            case CODE_93:
                aVar2 = new h();
                break;
            case CODE_128:
                aVar2 = new d();
                break;
            case ITF:
                aVar2 = new m();
                break;
            case PDF_417:
                aVar2 = new com.google.b.e.a();
                break;
            case CODABAR:
                aVar2 = new com.google.b.d.b();
                break;
            case DATA_MATRIX:
                aVar2 = new com.google.b.c.a();
                break;
            case AZTEC:
                aVar2 = new com.google.b.a.a();
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(aVar)));
                AppMethodBeat.o(12285);
                throw illegalArgumentException;
        }
        b a2 = aVar2.a(str, aVar, i2, i3, map);
        AppMethodBeat.o(12285);
        return a2;
    }
}
