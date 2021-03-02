package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.c.c;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

public final class b implements c {

    static class a extends AsyncTask<Void, Void, int[]> implements com.davemorrissey.labs.subscaleview.c.b {
        private final WeakReference<Context> aWF;
        private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aWG;
        private final Uri aWH;
        private com.davemorrissey.labs.subscaleview.a.c aWJ;
        private long aWK;
        private d aWL;
        private Exception exception;
        private final WeakReference<SubsamplingScaleImageView> oi;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        @SuppressLint({"LongLogTag"})
        public final /* synthetic */ int[] doInBackground(Void[] voidArr) {
            AppMethodBeat.i(157361);
            int[] rK = rK();
            AppMethodBeat.o(157361);
            return rK;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(int[] iArr) {
            AppMethodBeat.i(157360);
            int[] iArr2 = iArr;
            SubsamplingScaleImageView subsamplingScaleImageView = this.oi.get();
            if (subsamplingScaleImageView == null) {
                Log.e("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask onPostExecute view is null");
            } else if (this.aWL != null && iArr2 != null && iArr2.length == 3) {
                long currentTimeMillis = System.currentTimeMillis();
                subsamplingScaleImageView.a(this.aWL, iArr2[0], iArr2[1], iArr2[2]);
                subsamplingScaleImageView.dx((int) (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(157360);
                return;
            } else if (!(this.exception == null || subsamplingScaleImageView.getOnImageEventListener() == null)) {
                subsamplingScaleImageView.getOnImageEventListener().b(this.aWJ);
                AppMethodBeat.o(157360);
                return;
            }
            AppMethodBeat.o(157360);
        }

        a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar, Uri uri) {
            AppMethodBeat.i(157356);
            this.oi = new WeakReference<>(subsamplingScaleImageView);
            this.aWF = new WeakReference<>(context);
            this.aWG = new WeakReference<>(bVar);
            this.aWH = uri;
            AppMethodBeat.o(157356);
        }

        @SuppressLint({"LongLogTag"})
        private int[] rK() {
            AppMethodBeat.i(157357);
            Log.d("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask doInBackground");
            this.aWK = System.currentTimeMillis();
            try {
                Context context = this.aWF.get();
                com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar = this.aWG.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.oi.get();
                if (!(context == null || bVar == null || subsamplingScaleImageView == null)) {
                    this.aWL = (d) bVar.rG();
                    Point d2 = this.aWL.d(context, this.aWH);
                    int i2 = d2.x;
                    int i3 = d2.y;
                    int e2 = subsamplingScaleImageView.e(context, this.aWH);
                    if (subsamplingScaleImageView.getsRegion() != null) {
                        Rect rect = subsamplingScaleImageView.getsRegion();
                        rect.left = Math.max(0, rect.left);
                        rect.top = Math.max(0, rect.top);
                        rect.right = Math.min(i2, rect.right);
                        rect.bottom = Math.min(i3, rect.bottom);
                        int width = rect.width();
                        i3 = rect.height();
                        subsamplingScaleImageView.setsRegion(rect);
                        i2 = width;
                    }
                    a(subsamplingScaleImageView);
                    int[] iArr = {i2, i3, e2};
                    AppMethodBeat.o(157357);
                    return iArr;
                }
            } catch (FileNotFoundException e3) {
                Log.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", e3, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
                this.exception = e3;
                this.aWJ = new com.davemorrissey.labs.subscaleview.a.c(1, "tile init file not found");
            } catch (Exception e4) {
                Log.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", e4, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
                this.exception = e4;
                this.aWJ = new com.davemorrissey.labs.subscaleview.a.c(4, "tile init failed");
            }
            a(this.oi.get());
            AppMethodBeat.o(157357);
            return null;
        }

        private void a(SubsamplingScaleImageView subsamplingScaleImageView) {
            AppMethodBeat.i(157358);
            if (!(subsamplingScaleImageView == null || this.aWK == -1)) {
                subsamplingScaleImageView.dx((int) (System.currentTimeMillis() - this.aWK));
            }
            AppMethodBeat.o(157358);
        }

        @Override // com.davemorrissey.labs.subscaleview.c.b
        public final void rJ() {
            AppMethodBeat.i(157359);
            executeOnExecutor(this.oi.get().executor, new Void[0]);
            AppMethodBeat.o(157359);
        }

        @Override // com.davemorrissey.labs.subscaleview.c.b
        public final void cancel() {
        }
    }

    @Override // com.davemorrissey.labs.subscaleview.c.c
    public final com.davemorrissey.labs.subscaleview.c.b a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar, Uri uri) {
        AppMethodBeat.i(157362);
        a aVar = new a(subsamplingScaleImageView, context, bVar, uri);
        AppMethodBeat.o(157362);
        return aVar;
    }
}
