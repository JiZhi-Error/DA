package com.google.android.exoplayer2.h;

import android.text.TextUtils;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.o;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface s extends g {
    public static final o<String> bFC = new o<String>() {
        /* class com.google.android.exoplayer2.h.s.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.exoplayer2.i.o
        public final /* synthetic */ boolean aj(String str) {
            AppMethodBeat.i(93083);
            String bH = x.bH(str);
            if (TextUtils.isEmpty(bH) || ((bH.contains("text") && !bH.contains(ITPPlayer.TP_MIMETYPE_TEXT_VTT)) || bH.contains("html") || bH.contains("xml"))) {
                AppMethodBeat.o(93083);
                return false;
            }
            AppMethodBeat.o(93083);
            return true;
        }
    };

    public interface b extends g.a {
        @Deprecated
        void setDefaultRequestProperty(String str, String str2);
    }

    public static final class f {
        private final Map<String, String> bFE = new HashMap();
        private Map<String, String> bFF;

        public f() {
            AppMethodBeat.i(93086);
            AppMethodBeat.o(93086);
        }

        public final synchronized void set(String str, String str2) {
            AppMethodBeat.i(196067);
            this.bFF = null;
            this.bFE.put(str, str2);
            AppMethodBeat.o(196067);
        }

        public final synchronized Map<String, String> wM() {
            Map<String, String> map;
            AppMethodBeat.i(93087);
            if (this.bFF == null) {
                this.bFF = Collections.unmodifiableMap(new HashMap(this.bFE));
            }
            map = this.bFF;
            AppMethodBeat.o(93087);
            return map;
        }
    }

    public static abstract class a implements b {
        private final f bFw = new f();

        /* access modifiers changed from: protected */
        public abstract s a(f fVar);

        @Override // com.google.android.exoplayer2.h.s.b
        @Deprecated
        public final void setDefaultRequestProperty(String str, String str2) {
            this.bFw.set(str, str2);
        }

        @Override // com.google.android.exoplayer2.h.g.a
        public final /* synthetic */ g wG() {
            return a(this.bFw);
        }
    }

    public static class c extends IOException {
        public final j bxj;
        public final int type;

        public c(String str, j jVar) {
            super(str);
            this.bxj = jVar;
            this.type = 1;
        }

        public c(IOException iOException, j jVar, int i2) {
            super(iOException);
            this.bxj = jVar;
            this.type = i2;
        }

        public c(String str, IOException iOException, j jVar) {
            super(str, iOException);
            this.bxj = jVar;
            this.type = 1;
        }
    }

    public static final class d extends c {
        public final String contentType;

        public d(String str, j jVar) {
            super("Invalid content type: ".concat(String.valueOf(str)), jVar);
            AppMethodBeat.i(93084);
            this.contentType = str;
            AppMethodBeat.o(93084);
        }
    }

    public static final class e extends c {
        public final Map<String, List<String>> bFD;
        public final int responseCode;

        public e(int i2, Map<String, List<String>> map, j jVar) {
            super("Response code: ".concat(String.valueOf(i2)), jVar);
            AppMethodBeat.i(93085);
            this.responseCode = i2;
            this.bFD = map;
            AppMethodBeat.o(93085);
        }
    }
}
