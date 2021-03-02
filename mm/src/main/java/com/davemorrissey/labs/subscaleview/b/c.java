package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.c.b;
import com.davemorrissey.labs.subscaleview.c.d;
import com.davemorrissey.labs.subscaleview.c.e;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class c implements d {

    static class a extends AsyncTask<Void, Void, Bitmap> implements b {
        private com.davemorrissey.labs.subscaleview.a.c aWJ;
        private final WeakReference<com.davemorrissey.labs.subscaleview.a.d> aWM;
        private final WeakReference<e> aWN;
        private Exception exception;
        private boolean isCancelled = false;
        private long mStartTime = -1;
        private final WeakReference<SubsamplingScaleImageView> oi;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        @SuppressLint({"LongLogTag"})
        public final /* synthetic */ Bitmap doInBackground(Void[] voidArr) {
            AppMethodBeat.i(157369);
            Bitmap rL = rL();
            AppMethodBeat.o(157369);
            return rL;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Bitmap bitmap) {
            AppMethodBeat.i(157368);
            Bitmap bitmap2 = bitmap;
            Log.i("MicroMsg.LegacyTileLoaderFactory", "alvinluo onPostExecute %d", Long.valueOf(System.currentTimeMillis()));
            SubsamplingScaleImageView subsamplingScaleImageView = this.oi.get();
            e eVar = this.aWN.get();
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(subsamplingScaleImageView != null);
            objArr[1] = Boolean.valueOf(eVar != null);
            objArr[2] = Integer.valueOf(eVar != null ? eVar.sampleSize : -1);
            objArr[3] = eVar != null ? eVar.aWO : BuildConfig.COMMAND;
            Log.d("MicroMsg.LegacyTileLoaderFactory", "alvinluo onExecuteEnd imageView != null: %b, tile != null: %b, sampleSize: %d, rect: %s", objArr);
            if (!(subsamplingScaleImageView == null || eVar == null)) {
                if (bitmap2 != null) {
                    eVar.bitmap = bitmap2;
                    eVar.aWP = false;
                    subsamplingScaleImageView.b(eVar);
                    AppMethodBeat.o(157368);
                    return;
                } else if (!(this.exception == null || subsamplingScaleImageView.getOnImageEventListener() == null)) {
                    subsamplingScaleImageView.getOnImageEventListener().c(this.aWJ);
                }
            }
            AppMethodBeat.o(157368);
        }

        a(SubsamplingScaleImageView subsamplingScaleImageView, com.davemorrissey.labs.subscaleview.a.d dVar, e eVar) {
            AppMethodBeat.i(157363);
            this.oi = new WeakReference<>(subsamplingScaleImageView);
            this.aWM = new WeakReference<>(dVar);
            this.aWN = new WeakReference<>(eVar);
            eVar.aWP = true;
            AppMethodBeat.o(157363);
        }

        @SuppressLint({"LongLogTag"})
        private Bitmap rL() {
            AppMethodBeat.i(157364);
            if (!(this.oi.get() == null || this.aWN.get() == null || this.oi.get().getFullImageSampleSize() != this.aWN.get().sampleSize)) {
                this.mStartTime = System.currentTimeMillis();
            }
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.oi.get();
                com.davemorrissey.labs.subscaleview.a.d dVar = this.aWM.get();
                e eVar = this.aWN.get();
                if (dVar == null || eVar == null || subsamplingScaleImageView == null || !dVar.isReady() || !eVar.visible) {
                    if (eVar != null) {
                        eVar.aWP = false;
                    }
                    a(this.oi.get(), this.aWN.get());
                    AppMethodBeat.o(157364);
                    return null;
                }
                Log.d("MicroMsg.LegacyTileLoaderFactory", "alvinluo TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", eVar.aWO, Integer.valueOf(eVar.sampleSize));
                subsamplingScaleImageView.getDecoderLock().readLock().lock();
                try {
                    if (dVar.isReady()) {
                        Rect rect = eVar.aWO;
                        Rect rect2 = eVar.aWR;
                        if (subsamplingScaleImageView.getRequiredRotation() == 0) {
                            rect2.set(rect);
                        } else if (subsamplingScaleImageView.getRequiredRotation() == 90) {
                            rect2.set(rect.top, subsamplingScaleImageView.aWY - rect.right, rect.bottom, subsamplingScaleImageView.aWY - rect.left);
                        } else if (subsamplingScaleImageView.getRequiredRotation() == 180) {
                            rect2.set(subsamplingScaleImageView.aWX - rect.right, subsamplingScaleImageView.aWY - rect.bottom, subsamplingScaleImageView.aWX - rect.left, subsamplingScaleImageView.aWY - rect.top);
                        } else {
                            rect2.set(subsamplingScaleImageView.aWX - rect.bottom, rect.left, subsamplingScaleImageView.aWX - rect.top, rect.right);
                        }
                        if (subsamplingScaleImageView.getsRegion() != null) {
                            eVar.aWR.offset(subsamplingScaleImageView.getsRegion().left, subsamplingScaleImageView.getsRegion().top);
                        }
                        Log.d("MicroMsg.LegacyTileLoaderFactory", "alvinluo tile sampleSize: %d", Integer.valueOf(eVar.sampleSize));
                        Bitmap a2 = dVar.a(eVar.aWR, eVar.sampleSize);
                        a(subsamplingScaleImageView, eVar);
                        subsamplingScaleImageView.getDecoderLock().readLock().unlock();
                        AppMethodBeat.o(157364);
                        return a2;
                    }
                    eVar.aWP = false;
                    subsamplingScaleImageView.getDecoderLock().readLock().unlock();
                    a(this.oi.get(), this.aWN.get());
                    AppMethodBeat.o(157364);
                    return null;
                } catch (Throwable th) {
                    subsamplingScaleImageView.getDecoderLock().readLock().unlock();
                    AppMethodBeat.o(157364);
                    throw th;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e2, "Failed to decode tile", new Object[0]);
                this.exception = e2;
                this.aWJ = new com.davemorrissey.labs.subscaleview.a.c(5, "decode tile failed");
            } catch (OutOfMemoryError e3) {
                Log.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e3, "Failed to decode tile - OutOfMemoryError", new Object[0]);
                this.exception = new RuntimeException(e3);
                this.aWJ = new com.davemorrissey.labs.subscaleview.a.c(6, "decode tile OutOfMemoryError");
                SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.RGB_565);
            }
        }

        private void a(SubsamplingScaleImageView subsamplingScaleImageView, e eVar) {
            AppMethodBeat.i(157365);
            if (!(subsamplingScaleImageView == null || eVar == null || this.mStartTime == -1 || subsamplingScaleImageView.getFullImageSampleSize() != eVar.sampleSize)) {
                subsamplingScaleImageView.dz((int) (System.currentTimeMillis() - this.mStartTime));
            }
            AppMethodBeat.o(157365);
        }

        @Override // com.davemorrissey.labs.subscaleview.c.b
        public final void rJ() {
            AppMethodBeat.i(157366);
            executeOnExecutor(this.oi.get().executor, new Void[0]);
            AppMethodBeat.o(157366);
        }

        @Override // com.davemorrissey.labs.subscaleview.c.b
        public final void cancel() {
            AppMethodBeat.i(157367);
            try {
                cancel(true);
                this.isCancelled = true;
                AppMethodBeat.o(157367);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e2, "alvinluo TileLoaderTask cancel exception", new Object[0]);
                AppMethodBeat.o(157367);
            }
        }
    }

    @Override // com.davemorrissey.labs.subscaleview.c.d
    public final b a(SubsamplingScaleImageView subsamplingScaleImageView, com.davemorrissey.labs.subscaleview.a.d dVar, e eVar) {
        AppMethodBeat.i(157370);
        a aVar = new a(subsamplingScaleImageView, dVar, eVar);
        AppMethodBeat.o(157370);
        return aVar;
    }
}
