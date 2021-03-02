package com.tencent.mm.compatible.loader;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipFile;

public class PluginResourceLoader extends Resources {
    public Resources gKO;
    private Method gKP;
    private Method gKQ;
    private HashMap<String, ZipFile> gKR;
    private final b<WeakReference<Drawable.ConstantState>> gKS;

    private XmlResourceParser b(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(155834);
        try {
            XmlResourceParser xmlResourceParser = (XmlResourceParser) this.gKQ.invoke(this.gKO, str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
            AppMethodBeat.o(155834);
            return xmlResourceParser;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.PluginResourceLoader", e2, "", new Object[0]);
            AppMethodBeat.o(155834);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Drawable loadDrawable(TypedValue typedValue, int i2) {
        AppMethodBeat.i(155835);
        Drawable a2 = a(typedValue, i2);
        AppMethodBeat.o(155835);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public Drawable loadDrawable(TypedValue typedValue, int i2, boolean z) {
        AppMethodBeat.i(155836);
        Drawable a2 = a(typedValue, i2);
        AppMethodBeat.o(155836);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0021  */
    @Override // android.content.res.Resources
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.InputStream openRawResource(int r5, android.util.TypedValue r6) {
        /*
            r4 = this;
            r0 = 0
            r3 = 155837(0x260bd, float:2.18374E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            r1 = 1
            r4.getValue(r5, r6, r1)
            java.io.InputStream r1 = super.openRawResource(r5, r6)     // Catch:{ Exception -> 0x0037 }
        L_0x000f:
            if (r1 != 0) goto L_0x003a
            java.util.HashMap<java.lang.String, java.util.zip.ZipFile> r1 = r4.gKR
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0033
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getValue()
            java.util.zip.ZipFile r0 = (java.util.zip.ZipFile) r0
            java.io.InputStream r0 = b(r0, r6)
            if (r0 == 0) goto L_0x001b
        L_0x0033:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r0
        L_0x0037:
            r1 = move-exception
            r1 = r0
            goto L_0x000f
        L_0x003a:
            r0 = r1
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.loader.PluginResourceLoader.openRawResource(int, android.util.TypedValue):java.io.InputStream");
    }

    private Drawable a(TypedValue typedValue, int i2) {
        AppMethodBeat.i(155838);
        try {
            Drawable drawable = (Drawable) this.gKP.invoke(this.gKO, typedValue, Integer.valueOf(i2));
            AppMethodBeat.o(155838);
            return drawable;
        } catch (Exception e2) {
            try {
                if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
                    XmlResourceParser b2 = b(typedValue.string.toString(), i2, typedValue.assetCookie, "drawable");
                    Drawable createFromXml = Drawable.createFromXml(this, b2);
                    b2.close();
                    AppMethodBeat.o(155838);
                    return createFromXml;
                }
            } catch (Exception e3) {
            }
            for (Map.Entry<String, ZipFile> entry : this.gKR.entrySet()) {
                Drawable a2 = a(entry.getValue(), typedValue);
                if (a2 != null) {
                    AppMethodBeat.o(155838);
                    return a2;
                }
            }
            Log.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
            AppMethodBeat.o(155838);
            return null;
        } catch (StackOverflowError e4) {
            Log.e("MicroMsg.PluginResourceLoader", "load drawable StackOverflowError");
            XmlResourceParser b22 = b(typedValue.string.toString(), i2, typedValue.assetCookie, "drawable");
            Drawable createFromXml2 = Drawable.createFromXml(this, b22);
            b22.close();
            AppMethodBeat.o(155838);
            return createFromXml2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(java.util.zip.ZipFile r12, android.util.TypedValue r13) {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.loader.PluginResourceLoader.a(java.util.zip.ZipFile, android.util.TypedValue):android.graphics.drawable.Drawable");
    }

    private static InputStream b(ZipFile zipFile, TypedValue typedValue) {
        InputStream inputStream = null;
        AppMethodBeat.i(155840);
        if (typedValue.string == null) {
            AppMethodBeat.o(155840);
        } else {
            String charSequence = typedValue.string.toString();
            try {
                Log.d("MicroMsg.PluginResourceLoader", "try load stream from zip, entry=%s, file=%s", charSequence, zipFile.getName());
                inputStream = zipFile.getInputStream(zipFile.getEntry(charSequence));
                AppMethodBeat.o(155840);
            } catch (Exception e2) {
                AppMethodBeat.o(155840);
            }
        }
        return inputStream;
    }
}
