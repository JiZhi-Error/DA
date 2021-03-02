package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001:\u0002\u001b\u001cB!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J'\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0011\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask;", "Landroid/os/AsyncTask;", "Landroid/content/pm/ResolveInfo;", "Ljava/lang/Void;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "key", "", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;)V", "convertDrawableToRoundedBitmap", "Landroid/graphics/Bitmap;", "drawable", "doInBackground", NativeProtocol.WEB_DIALOG_PARAMS, "", "([Landroid/content/pm/ResolveInfo;)Landroid/graphics/drawable/Drawable;", "getRoundedBitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "bitmap", "recycleBitmap", "", "onPostExecute", "", "result", "BrowserIconLoadCallback", "Companion", "plugin-webview_release"})
public final class e extends AsyncTask<ResolveInfo, Void, Drawable> {
    public static final b JlM = new b((byte) 0);
    private final a JlL;
    private final Context context;
    private final String key;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
    public interface a {
        void B(Drawable drawable);
    }

    static {
        AppMethodBeat.i(210440);
        AppMethodBeat.o(210440);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$Companion;", "", "()V", "ROUND_CORNER_SIZE_FACTOR", "", "TAG", "", "plugin-webview_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public e(Context context2, String str, a aVar) {
        p.h(context2, "context");
        AppMethodBeat.i(210439);
        this.context = context2;
        this.key = str;
        this.JlL = aVar;
        AppMethodBeat.o(210439);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ Drawable doInBackground(ResolveInfo[] resolveInfoArr) {
        AppMethodBeat.i(210436);
        Drawable a2 = a(resolveInfoArr);
        AppMethodBeat.o(210436);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Drawable drawable) {
        AppMethodBeat.i(210437);
        Drawable drawable2 = drawable;
        if (drawable2 == null) {
            Log.e("MicroMsg.BrowserIconLoadTask", "alvinluo loadBrowserIcon failed: %s", this.key);
        }
        a aVar = this.JlL;
        if (aVar != null) {
            aVar.B(drawable2);
            AppMethodBeat.o(210437);
            return;
        }
        AppMethodBeat.o(210437);
    }

    private Drawable a(ResolveInfo... resolveInfoArr) {
        Throwable th;
        BitmapDrawable bitmapDrawable = null;
        Bitmap createBitmap = null;
        AppMethodBeat.i(210435);
        p.h(resolveInfoArr, NativeProtocol.WEB_DIALOG_PARAMS);
        try {
            Drawable a2 = b.a(this.context, resolveInfoArr[0]);
            try {
                if (a2 instanceof BitmapDrawable) {
                    BitmapDrawable f2 = f(((BitmapDrawable) a2).getBitmap(), false);
                    bitmapDrawable = f2 != null ? f2 : a2;
                } else if (Build.VERSION.SDK_INT < 26 || !(a2 instanceof AdaptiveIconDrawable)) {
                    bitmapDrawable = a2;
                } else {
                    if (a2 != null) {
                        if (a2 instanceof BitmapDrawable) {
                            createBitmap = ((BitmapDrawable) a2).getBitmap();
                        } else {
                            Rect bounds = a2.getBounds();
                            p.g(bounds, "drawable.bounds");
                            int width = !bounds.isEmpty() ? bounds.width() : a2.getIntrinsicWidth();
                            int height = !bounds.isEmpty() ? bounds.height() : a2.getIntrinsicHeight();
                            if (width <= 0) {
                                width = 1;
                            }
                            if (height <= 0) {
                                height = 1;
                            }
                            createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            a2.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            a2.draw(canvas);
                            a2.setBounds(bounds);
                        }
                    }
                    BitmapDrawable f3 = f(createBitmap, true);
                    if (f3 != null) {
                        bitmapDrawable = f3;
                    } else {
                        bitmapDrawable = a2;
                    }
                }
                Log.i("MicroMsg.BrowserIconLoadTask", "alvinluo BrowserIconLoadTask doInBackground name: " + this.key + ", iconDrawable " + bitmapDrawable);
            } catch (Throwable th2) {
                th = th2;
                bitmapDrawable = a2;
                Log.printErrStackTrace("MicroMsg.BrowserIconLoadTask", th, "alvinluo loadBrowserIcon exception", new Object[0]);
                AppMethodBeat.o(210435);
                return bitmapDrawable;
            }
        } catch (Throwable th3) {
            th = th3;
            Log.printErrStackTrace("MicroMsg.BrowserIconLoadTask", th, "alvinluo loadBrowserIcon exception", new Object[0]);
            AppMethodBeat.o(210435);
            return bitmapDrawable;
        }
        AppMethodBeat.o(210435);
        return bitmapDrawable;
    }

    private final BitmapDrawable f(Bitmap bitmap, boolean z) {
        AppMethodBeat.i(210438);
        if (bitmap == null) {
            AppMethodBeat.o(210438);
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.context.getResources(), BitmapUtil.getRoundedCornerBitmap(bitmap, z, ((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.16666667f));
        AppMethodBeat.o(210438);
        return bitmapDrawable;
    }
}
