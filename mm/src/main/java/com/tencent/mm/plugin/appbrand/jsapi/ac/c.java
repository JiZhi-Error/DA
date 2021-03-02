package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.media.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.stubs.logger.Log;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    public interface a {
        float getTextSize();

        void setEllipsize(TextUtils.TruncateAt truncateAt);

        void setFakeBoldText(boolean z);

        void setGravity(int i2);

        void setLineHeight(int i2);

        void setSingleLine(boolean z);

        void setText(CharSequence charSequence);

        void setTextColor(int i2);

        void setTextSize(int i2, float f2);
    }

    public interface b {
        void f(BitmapFactory.Options options);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009b A[SYNTHETIC, Splitter:B:32:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.plugin.appbrand.jsapi.h r9, int r10, com.tencent.mm.plugin.appbrand.widget.b.a r11, org.json.JSONObject r12, final com.tencent.mm.plugin.appbrand.jsapi.ac.c.b r13) {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ac.c.a(com.tencent.mm.plugin.appbrand.jsapi.h, int, com.tencent.mm.plugin.appbrand.widget.b.a, org.json.JSONObject, com.tencent.mm.plugin.appbrand.jsapi.ac.c$b):void");
    }

    static e bLi() {
        AppMethodBeat.i(193728);
        e a2 = e.a.a((e) com.tencent.luggage.a.e.M(e.class));
        AppMethodBeat.o(193728);
        return a2;
    }

    public static void a(a aVar, JSONObject jSONObject) {
        AppMethodBeat.i(193729);
        if (aVar == null || jSONObject == null) {
            AppMethodBeat.o(193729);
            return;
        }
        try {
            String string = jSONObject.getString("color");
            if (!Util.isNullOrNil(string)) {
                aVar.setTextColor(g.afD(string));
            }
        } catch (JSONException e2) {
        }
        try {
            aVar.setTextSize(0, g.aT((float) jSONObject.getDouble("fontSize")));
        } catch (JSONException e3) {
        }
        try {
            String string2 = jSONObject.getString("textAlign");
            if ("left".equals(string2)) {
                aVar.setGravity(3);
            } else if ("center".equals(string2)) {
                aVar.setGravity(1);
            } else if ("right".equals(string2)) {
                aVar.setGravity(5);
            }
        } catch (JSONException e4) {
        }
        try {
            String string3 = jSONObject.getString("fontWeight");
            if ("bold".equals(string3)) {
                aVar.setFakeBoldText(true);
            } else if ("normal".equals(string3)) {
                aVar.setFakeBoldText(false);
            }
        } catch (JSONException e5) {
        }
        aVar.setLineHeight(g.a(jSONObject, "lineHeight", Math.round(aVar.getTextSize() * 1.2f)));
        try {
            String string4 = jSONObject.getString("lineBreak");
            if ("ellipsis".equals(string4)) {
                aVar.setEllipsize(TextUtils.TruncateAt.END);
                aVar.setSingleLine(true);
            } else if ("clip".equals(string4)) {
                aVar.setSingleLine(true);
            } else if ("break-word".equals(string4)) {
                aVar.setSingleLine(false);
            } else if ("break-all".equals(string4)) {
                aVar.setSingleLine(false);
            }
        } catch (JSONException e6) {
        }
        try {
            aVar.setText(jSONObject.getString("content"));
            AppMethodBeat.o(193729);
        } catch (JSONException e7) {
            AppMethodBeat.o(193729);
        }
    }

    public static int getCompatibleRewindBufferSize() {
        AppMethodBeat.i(193730);
        if ("HUAWEI".equals(Build.MANUFACTURER)) {
            AppMethodBeat.o(193730);
        } else {
            AppMethodBeat.o(193730);
        }
        return TPMediaCodecProfileLevel.HEVCHighTierLevel61;
    }

    public static InputStream F(InputStream inputStream) {
        AppMethodBeat.i(193731);
        if (inputStream.markSupported()) {
            AppMethodBeat.o(193731);
            return inputStream;
        } else if (inputStream instanceof FileInputStream) {
            C0598c cVar = new C0598c((FileInputStream) inputStream);
            AppMethodBeat.o(193731);
            return cVar;
        } else {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            AppMethodBeat.o(193731);
            return bufferedInputStream;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ac.c$c  reason: collision with other inner class name */
    public static class C0598c extends FilterInputStream {
        private long hjN = 0;

        C0598c(FileInputStream fileInputStream) {
            super(fileInputStream);
        }

        public final boolean markSupported() {
            return true;
        }

        public final synchronized void mark(int i2) {
            AppMethodBeat.i(193725);
            try {
                this.hjN = ((FileInputStream) this.in).getChannel().position();
                AppMethodBeat.o(193725);
            } catch (IOException e2) {
                Log.e("Luggage.ViewAttributeHelper", e2, "fail to mark position.");
                this.hjN = -1;
                AppMethodBeat.o(193725);
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final synchronized void reset() {
            AppMethodBeat.i(193726);
            if (this.hjN < 0) {
                IOException iOException = new IOException("Illegal marked position: " + this.hjN);
                AppMethodBeat.o(193726);
                throw iOException;
            }
            ((FileInputStream) this.in).getChannel().position(this.hjN);
            AppMethodBeat.o(193726);
        }
    }
}
