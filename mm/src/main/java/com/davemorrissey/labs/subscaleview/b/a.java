package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.c;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.c.b;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public final class a implements com.davemorrissey.labs.subscaleview.c.a {

    /* renamed from: com.davemorrissey.labs.subscaleview.b.a$a  reason: collision with other inner class name */
    static class AsyncTaskC0082a extends AsyncTask<Void, Void, Integer> implements b {
        private final WeakReference<Context> aWF;
        private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aWG;
        private final Uri aWH;
        private final boolean aWI;
        private c aWJ;
        private long aWK = -1;
        private Bitmap bitmap;
        private Exception exception;
        private Rect mRect;
        private final WeakReference<SubsamplingScaleImageView> oi;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        @SuppressLint({"LongLogTag"})
        public final /* synthetic */ Integer doInBackground(Void[] voidArr) {
            AppMethodBeat.i(157354);
            Integer rI = rI();
            AppMethodBeat.o(157354);
            return rI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Integer num) {
            AppMethodBeat.i(157353);
            Integer num2 = num;
            Log.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onPostExecute %d", Long.valueOf(System.currentTimeMillis()));
            SubsamplingScaleImageView subsamplingScaleImageView = this.oi.get();
            if (subsamplingScaleImageView != null) {
                if (this.bitmap == null || num2 == null) {
                    if (!(this.exception == null || subsamplingScaleImageView.getOnImageEventListener() == null)) {
                        if (this.aWI) {
                            subsamplingScaleImageView.getOnImageEventListener().a(this.aWJ);
                            AppMethodBeat.o(157353);
                            return;
                        }
                        subsamplingScaleImageView.getOnImageEventListener().b(this.aWJ);
                    }
                } else if (this.aWI) {
                    subsamplingScaleImageView.a(this.bitmap, num2);
                    AppMethodBeat.o(157353);
                    return;
                } else {
                    subsamplingScaleImageView.b(this.bitmap, num2.intValue(), false);
                    AppMethodBeat.o(157353);
                    return;
                }
            }
            AppMethodBeat.o(157353);
        }

        AsyncTaskC0082a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar, Uri uri, boolean z) {
            AppMethodBeat.i(157349);
            this.oi = new WeakReference<>(subsamplingScaleImageView);
            this.aWF = new WeakReference<>(context);
            this.aWG = new WeakReference<>(bVar);
            this.aWH = uri;
            this.aWI = z;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                InputStream b2 = s.b(uri, null);
                try {
                    BitmapFactory.decodeStream(b2, null, options);
                    if (b2 != null) {
                        b2.close();
                    }
                } catch (Throwable th) {
                    if (b2 != null) {
                        if (th != null) {
                            try {
                                b2.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            b2.close();
                        }
                    }
                    AppMethodBeat.o(157349);
                    throw th;
                }
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e2, "Unable to read file: %s", uri.toString());
            }
            this.mRect = new Rect(0, 0, options.outWidth, options.outHeight);
            AppMethodBeat.o(157349);
        }

        @SuppressLint({"LongLogTag"})
        private Integer rI() {
            AppMethodBeat.i(157350);
            Log.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
            if (this.aWI) {
                this.aWK = System.currentTimeMillis();
            }
            try {
                Context context = this.aWF.get();
                com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar = this.aWG.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.oi.get();
                if (!(context == null || bVar == null || subsamplingScaleImageView == null)) {
                    subsamplingScaleImageView.h("BitmapLoadTask.doInBackground", new Object[0]);
                    d dVar = (d) bVar.rG();
                    dVar.d(context, this.aWH);
                    this.bitmap = dVar.a(this.mRect, 1);
                    Integer valueOf = Integer.valueOf(subsamplingScaleImageView.e(context, this.aWH));
                    dVar.recycle();
                    a(subsamplingScaleImageView);
                    AppMethodBeat.o(157350);
                    return valueOf;
                }
            } catch (FileNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e2, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
                this.exception = e2;
                this.aWJ = new c(1, "tile init file not found");
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e3, "Failed to load bitmap", new Object[0]);
                this.exception = e3;
                this.aWJ = new c(2, "bitmap decode failed");
            } catch (OutOfMemoryError e4) {
                Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e4, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
                this.exception = new RuntimeException(e4);
                this.aWJ = new c(3, "bitmap decode OutOfMemoryError");
                SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.RGB_565);
            }
            a(this.oi.get());
            AppMethodBeat.o(157350);
            return null;
        }

        private void a(SubsamplingScaleImageView subsamplingScaleImageView) {
            AppMethodBeat.i(157351);
            if (!(subsamplingScaleImageView == null || !this.aWI || this.aWK == -1)) {
                Log.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", Long.valueOf(System.currentTimeMillis()));
                subsamplingScaleImageView.dy((int) (System.currentTimeMillis() - this.aWK));
            }
            AppMethodBeat.o(157351);
        }

        @Override // com.davemorrissey.labs.subscaleview.c.b
        public final void rJ() {
            AppMethodBeat.i(157352);
            executeOnExecutor(this.oi.get().executor, new Void[0]);
            AppMethodBeat.o(157352);
        }

        @Override // com.davemorrissey.labs.subscaleview.c.b
        public final void cancel() {
        }
    }

    @Override // com.davemorrissey.labs.subscaleview.c.a
    public final b a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar, Uri uri, boolean z) {
        AppMethodBeat.i(157355);
        AsyncTaskC0082a aVar = new AsyncTaskC0082a(subsamplingScaleImageView, context, bVar, uri, z);
        AppMethodBeat.o(157355);
        return aVar;
    }
}
