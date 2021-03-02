package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.p;
import java.nio.ByteBuffer;

public class DartExecutor implements io.flutter.plugin.a.c {
    private final FlutterJNI SNV;
    private final a SOG;
    public final io.flutter.plugin.a.c SOH;
    public boolean SOI = false;
    public String SOJ;
    private c SOK;
    private final c.a SOL = new c.a() {
        /* class io.flutter.embedding.engine.dart.DartExecutor.AnonymousClass1 */

        @Override // io.flutter.plugin.a.c.a
        public final void a(ByteBuffer byteBuffer, c.b bVar) {
            AppMethodBeat.i(10205);
            DartExecutor dartExecutor = DartExecutor.this;
            p pVar = p.SSt;
            dartExecutor.SOJ = p.P(byteBuffer);
            if (DartExecutor.this.SOK != null) {
                c unused = DartExecutor.this.SOK;
                String unused2 = DartExecutor.this.SOJ;
            }
            AppMethodBeat.o(10205);
        }
    };
    private final AssetManager aFb;

    /* access modifiers changed from: package-private */
    public interface c {
    }

    public DartExecutor(FlutterJNI flutterJNI, AssetManager assetManager) {
        AppMethodBeat.i(10198);
        this.SNV = flutterJNI;
        this.aFb = assetManager;
        this.SOG = new a(flutterJNI);
        this.SOG.a("flutter/isolate", this.SOL);
        this.SOH = new b(this.SOG, (byte) 0);
        AppMethodBeat.o(10198);
    }

    public void onAttachedToJNI() {
        AppMethodBeat.i(10199);
        io.flutter.a.hwd();
        this.SNV.setPlatformMessageHandler(this.SOG);
        AppMethodBeat.o(10199);
    }

    public void onDetachedFromJNI() {
        AppMethodBeat.i(10200);
        io.flutter.a.hwd();
        this.SNV.setPlatformMessageHandler(null);
        AppMethodBeat.o(10200);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(10201);
        if (this.SOI) {
            io.flutter.a.hwf();
            AppMethodBeat.o(10201);
            return;
        }
        new StringBuilder("Executing Dart entrypoint: ").append(aVar);
        io.flutter.a.hwd();
        this.SNV.runBundleAndSnapshotFromLibrary(aVar.SON, aVar.SOO, null, this.aFb);
        this.SOI = true;
        AppMethodBeat.o(10201);
    }

    @Override // io.flutter.plugin.a.c
    @Deprecated
    public final void a(String str, ByteBuffer byteBuffer) {
        AppMethodBeat.i(10202);
        this.SOH.a(str, byteBuffer);
        AppMethodBeat.o(10202);
    }

    @Override // io.flutter.plugin.a.c
    @Deprecated
    public final void a(String str, ByteBuffer byteBuffer, c.b bVar) {
        AppMethodBeat.i(10203);
        this.SOH.a(str, byteBuffer, bVar);
        AppMethodBeat.o(10203);
    }

    @Override // io.flutter.plugin.a.c
    @Deprecated
    public final void a(String str, c.a aVar) {
        AppMethodBeat.i(10204);
        this.SOH.a(str, aVar);
        AppMethodBeat.o(10204);
    }

    public final void notifyLowMemoryWarning() {
        AppMethodBeat.i(214963);
        if (this.SNV.isAttached()) {
            this.SNV.notifyLowMemoryWarning();
        }
        AppMethodBeat.o(214963);
    }

    public static class a {
        public final String SON;
        public final String SOO;

        public a(String str, String str2) {
            this.SON = str;
            this.SOO = str2;
        }

        public a(String str, String str2, byte b2) {
            this(str, str2);
        }

        public final String toString() {
            AppMethodBeat.i(10212);
            String str = "DartEntrypoint( bundle path: " + this.SON + ", function: " + this.SOO + " )";
            AppMethodBeat.o(10212);
            return str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(10213);
            if (this == obj) {
                AppMethodBeat.o(10213);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(10213);
                return false;
            } else {
                a aVar = (a) obj;
                if (!this.SON.equals(aVar.SON)) {
                    AppMethodBeat.o(10213);
                    return false;
                }
                boolean equals = this.SOO.equals(aVar.SOO);
                AppMethodBeat.o(10213);
                return equals;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(10214);
            int hashCode = (this.SON.hashCode() * 31) + this.SOO.hashCode();
            AppMethodBeat.o(10214);
            return hashCode;
        }
    }

    static class b implements io.flutter.plugin.a.c {
        private final a SOP;

        /* synthetic */ b(a aVar, byte b2) {
            this(aVar);
        }

        private b(a aVar) {
            this.SOP = aVar;
        }

        @Override // io.flutter.plugin.a.c
        public final void a(String str, ByteBuffer byteBuffer) {
            AppMethodBeat.i(214964);
            this.SOP.a(str, byteBuffer, null);
            AppMethodBeat.o(214964);
        }

        @Override // io.flutter.plugin.a.c
        public final void a(String str, ByteBuffer byteBuffer, c.b bVar) {
            AppMethodBeat.i(214965);
            this.SOP.a(str, byteBuffer, bVar);
            AppMethodBeat.o(214965);
        }

        @Override // io.flutter.plugin.a.c
        public final void a(String str, c.a aVar) {
            AppMethodBeat.i(214966);
            this.SOP.a(str, aVar);
            AppMethodBeat.o(214966);
        }
    }
}
