package io.flutter.embedding.engine.c;

import com.facebook.internal.NativeProtocol;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.o;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public final class h {
    public d SQK;
    private final k.c SQL = new k.c() {
        /* class io.flutter.embedding.engine.c.h.AnonymousClass1 */

        @Override // io.flutter.plugin.a.k.c
        public final void a(j jVar, final k.d dVar) {
            AppMethodBeat.i(10241);
            if (h.this.SQK == null) {
                AppMethodBeat.o(10241);
                return;
            }
            new StringBuilder("Received '").append(jVar.method).append("' message.");
            io.flutter.a.hwd();
            String str = jVar.method;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1352294148:
                    if (str.equals("create")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -934437708:
                    if (str.equals("resize")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -756050293:
                    if (str.equals("clearFocus")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 110550847:
                    if (str.equals("touch")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 576796989:
                    if (str.equals("setDirection")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1671767583:
                    if (str.equals("dispose")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    Map map = (Map) jVar.SxX;
                    boolean z = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
                    a aVar = new a(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), z ? 0.0d : ((Double) map.get("width")).doubleValue(), z ? 0.0d : ((Double) map.get("height")).doubleValue(), ((Integer) map.get(TencentLocation.EXTRA_DIRECTION)).intValue(), map.containsKey(NativeProtocol.WEB_DIALOG_PARAMS) ? ByteBuffer.wrap((byte[]) map.get(NativeProtocol.WEB_DIALOG_PARAMS)) : null);
                    if (z) {
                        try {
                            h.this.SQK.a(aVar);
                            dVar.ba(null);
                            AppMethodBeat.o(10241);
                            return;
                        } catch (IllegalStateException e2) {
                            dVar.b("error", h.s(e2), null);
                            AppMethodBeat.o(10241);
                            return;
                        }
                    } else {
                        dVar.ba(Long.valueOf(h.this.SQK.b(aVar)));
                        AppMethodBeat.o(10241);
                        return;
                    }
                case 1:
                    Map map2 = (Map) jVar.SxX;
                    int intValue = ((Integer) map2.get("id")).intValue();
                    if (map2.containsKey("hybrid") && ((Boolean) map2.get("hybrid")).booleanValue()) {
                        try {
                            h.this.SQK.att(intValue);
                        } catch (IllegalStateException e3) {
                            dVar.b("error", h.s(e3), null);
                            AppMethodBeat.o(10241);
                            return;
                        }
                    } else {
                        h.this.SQK.atu(intValue);
                    }
                    dVar.ba(null);
                    AppMethodBeat.o(10241);
                    return;
                case 2:
                    Map map3 = (Map) jVar.SxX;
                    try {
                        h.this.SQK.a(new b(((Integer) map3.get("id")).intValue(), ((Double) map3.get("width")).doubleValue(), ((Double) map3.get("height")).doubleValue()), new Runnable() {
                            /* class io.flutter.embedding.engine.c.h.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(10253);
                                dVar.ba(null);
                                AppMethodBeat.o(10253);
                            }
                        });
                        AppMethodBeat.o(10241);
                        return;
                    } catch (IllegalStateException e4) {
                        dVar.b("error", h.s(e4), null);
                        AppMethodBeat.o(10241);
                        return;
                    }
                case 3:
                    List list = (List) jVar.SxX;
                    try {
                        h.this.SQK.a(new c(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                        dVar.ba(null);
                        AppMethodBeat.o(10241);
                        return;
                    } catch (IllegalStateException e5) {
                        dVar.b("error", h.s(e5), null);
                        AppMethodBeat.o(10241);
                        return;
                    }
                case 4:
                    Map map4 = (Map) jVar.SxX;
                    try {
                        h.this.SQK.mT(((Integer) map4.get("id")).intValue(), ((Integer) map4.get(TencentLocation.EXTRA_DIRECTION)).intValue());
                        dVar.ba(null);
                        AppMethodBeat.o(10241);
                        return;
                    } catch (IllegalStateException e6) {
                        dVar.b("error", h.s(e6), null);
                        AppMethodBeat.o(10241);
                        return;
                    }
                case 5:
                    try {
                        h.this.SQK.atv(((Integer) jVar.SxX).intValue());
                        dVar.ba(null);
                        AppMethodBeat.o(10241);
                        return;
                    } catch (IllegalStateException e7) {
                        dVar.b("error", h.s(e7), null);
                        AppMethodBeat.o(10241);
                        return;
                    }
                default:
                    dVar.dLv();
                    AppMethodBeat.o(10241);
                    return;
            }
        }
    };
    public final k bbv;

    public interface d {
        void a(a aVar);

        void a(b bVar, Runnable runnable);

        void a(c cVar);

        void att(int i2);

        void atu(int i2);

        void atv(int i2);

        long b(a aVar);

        void mT(int i2, int i3);
    }

    public h(DartExecutor dartExecutor) {
        AppMethodBeat.i(10271);
        this.bbv = new k(dartExecutor, "flutter/platform_views", o.SSr);
        this.bbv.a(this.SQL);
        AppMethodBeat.o(10271);
    }

    public static class a {
        public final String SQP;
        public final double SQQ;
        public final double SQR;
        public final ByteBuffer SQS;
        public final int direction;
        public final int viewId;

        public a(int i2, String str, double d2, double d3, int i3, ByteBuffer byteBuffer) {
            this.viewId = i2;
            this.SQP = str;
            this.SQQ = d2;
            this.SQR = d3;
            this.direction = i3;
            this.SQS = byteBuffer;
        }
    }

    public static class b {
        public final double SQT;
        public final double SQU;
        public final int viewId;

        public b(int i2, double d2, double d3) {
            this.viewId = i2;
            this.SQT = d2;
            this.SQU = d3;
        }
    }

    public static class c {
        public final int SPU;
        public final int SPZ;
        public final Number SQV;
        public final Number SQW;
        public final Object SQX;
        public final Object SQY;
        public final int SQZ;
        public final float SRa;
        public final float SRb;
        public final long SRc;
        public final int action;
        public final int edgeFlags;
        public final int flags;
        public final int kyY;
        public final int source;
        public final int viewId;

        public c(int i2, Number number, Number number2, int i3, int i4, Object obj, Object obj2, int i5, int i6, float f2, float f3, int i7, int i8, int i9, int i10, long j2) {
            this.viewId = i2;
            this.SQV = number;
            this.SQW = number2;
            this.action = i3;
            this.kyY = i4;
            this.SQX = obj;
            this.SQY = obj2;
            this.SPZ = i5;
            this.SQZ = i6;
            this.SRa = f2;
            this.SRb = f3;
            this.SPU = i7;
            this.edgeFlags = i8;
            this.source = i9;
            this.flags = i10;
            this.SRc = j2;
        }
    }

    static /* synthetic */ String s(Exception exc) {
        AppMethodBeat.i(214996);
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(214996);
        return stringWriter2;
    }
}
