package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class ScreenShotUtil {
    private static final String EXTERNAL_CONTENT_URI_MATCHER = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    private static final String[] PROJECTION = {"_display_name", "_data", "date_added"};
    private static final String SORT_ORDER = "date_added DESC limit 1";
    private static final String TAG = "MicroMsg.ScreenShotUtil";
    private static WeakReference<ScreenShotCallback> mCallbackWeakRef;
    private static ContentObserver mScreenShotContentObserver;
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    private static MMHandler workHandler = new MMHandler(a.bqt(TAG));

    public interface ScreenShotCallback {
        void onScreenShot(String str, long j2);
    }

    static {
        AppMethodBeat.i(157810);
        AppMethodBeat.o(157810);
    }

    public static Bitmap takeScreenShot(Activity activity) {
        AppMethodBeat.i(157808);
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        try {
            drawingCache = Bitmap.createBitmap(drawingCache, 0, i2, activity.getWindowManager().getDefaultDisplay().getWidth(), activity.getWindowManager().getDefaultDisplay().getHeight() - i2);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        decorView.destroyDrawingCache();
        AppMethodBeat.o(157808);
        return drawingCache;
    }

    public static void setScreenShotCallback(final Context context, final ScreenShotCallback screenShotCallback) {
        AppMethodBeat.i(157809);
        workHandler.post(new Runnable() {
            /* class com.tencent.mm.sdk.platformtools.ScreenShotUtil.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(230380);
                Log.i(ScreenShotUtil.TAG, "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", context, screenShotCallback, Util.getStack());
                try {
                    if (context == null) {
                        AppMethodBeat.o(230380);
                    } else if (screenShotCallback == null) {
                        if (ScreenShotUtil.mScreenShotContentObserver != null) {
                            context.getContentResolver().unregisterContentObserver(ScreenShotUtil.mScreenShotContentObserver);
                            ContentObserver unused = ScreenShotUtil.mScreenShotContentObserver = null;
                        }
                        if (ScreenShotUtil.mCallbackWeakRef != null) {
                            ScreenShotUtil.mCallbackWeakRef.clear();
                            WeakReference unused2 = ScreenShotUtil.mCallbackWeakRef = null;
                        }
                        AppMethodBeat.o(230380);
                    } else {
                        WeakReference unused3 = ScreenShotUtil.mCallbackWeakRef = new WeakReference(screenShotCallback);
                        if (ScreenShotUtil.mScreenShotContentObserver == null) {
                            ContentObserver unused4 = ScreenShotUtil.mScreenShotContentObserver = new ScreenShotContentObserver(context, ScreenShotUtil.sHandler);
                            context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, ScreenShotUtil.mScreenShotContentObserver);
                        }
                        AppMethodBeat.o(230380);
                    }
                } catch (Throwable th) {
                    Log.w(ScreenShotUtil.TAG, "summerscreenshot fail e:" + th.getMessage());
                    AppMethodBeat.o(230380);
                }
            }
        });
        AppMethodBeat.o(157809);
    }

    static final class ScreenShotContentObserver extends ContentObserver {
        private Context context;
        private String lastPath;
        private long lastShotTime;

        static /* synthetic */ void access$500(ScreenShotContentObserver screenShotContentObserver, Context context2, Uri uri) {
            AppMethodBeat.i(230386);
            screenShotContentObserver.onChangeImpl(context2, uri);
            AppMethodBeat.o(230386);
        }

        static /* synthetic */ void access$800(ScreenShotContentObserver screenShotContentObserver, Context context2, String str, long j2, long j3) {
            AppMethodBeat.i(230387);
            screenShotContentObserver.postOnChangeImpl(context2, str, j2, j3);
            AppMethodBeat.o(230387);
        }

        public ScreenShotContentObserver(Context context2, Handler handler) {
            super(handler);
            this.context = context2;
        }

        public final void onChange(final boolean z, final Uri uri) {
            AppMethodBeat.i(230383);
            ScreenShotUtil.workHandler.post(new Runnable() {
                /* class com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotContentObserver.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(230381);
                    Log.d(ScreenShotUtil.TAG, "summerscreenshot onChange: " + z + ", uri:" + uri.toString());
                    try {
                        if (ScreenShotUtil.mCallbackWeakRef == null || ScreenShotUtil.mCallbackWeakRef.get() == null) {
                            Log.i(ScreenShotUtil.TAG, "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]", ScreenShotUtil.mCallbackWeakRef);
                            if (ScreenShotUtil.mScreenShotContentObserver != null) {
                                ScreenShotContentObserver.this.context.getContentResolver().unregisterContentObserver(ScreenShotUtil.mScreenShotContentObserver);
                                ContentObserver unused = ScreenShotUtil.mScreenShotContentObserver = null;
                            }
                            if (ScreenShotUtil.mCallbackWeakRef != null) {
                                ScreenShotUtil.mCallbackWeakRef.clear();
                                WeakReference unused2 = ScreenShotUtil.mCallbackWeakRef = null;
                                AppMethodBeat.o(230381);
                                return;
                            }
                        } else if (uri.toString().matches(ScreenShotUtil.EXTERNAL_CONTENT_URI_MATCHER) || uri.toString().contains(ScreenShotUtil.EXTERNAL_CONTENT_URI_MATCHER)) {
                            ScreenShotContentObserver.access$500(ScreenShotContentObserver.this, ScreenShotContentObserver.this.context, uri);
                        }
                        AppMethodBeat.o(230381);
                    } catch (Throwable th) {
                        Log.w(ScreenShotUtil.TAG, "summerscreenshot fail e:" + th.getMessage());
                        AppMethodBeat.o(230381);
                    }
                }
            });
            super.onChange(z, uri);
            AppMethodBeat.o(230383);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00ab  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void onChangeImpl(final android.content.Context r12, android.net.Uri r13) {
            /*
            // Method dump skipped, instructions count: 190
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotContentObserver.onChangeImpl(android.content.Context, android.net.Uri):void");
        }

        private void postOnChangeImpl(Context context2, String str, long j2, long j3) {
            AppMethodBeat.i(230385);
            try {
                if (Math.abs(j3 - j2) > 10 || j3 - this.lastShotTime <= 1 || Util.isNullOrNil(str) || ((!str.toLowerCase().contains("screenshot") && !str.contains("截屏") && !str.contains("截图")) || str.equals(this.lastPath))) {
                    j2 = 0;
                    str = null;
                } else {
                    this.lastShotTime = j3;
                    this.lastPath = str;
                }
                if (!Util.isNullOrNil(str)) {
                    Log.i(ScreenShotUtil.TAG, "summerscreenshot added path: " + str + ", time: " + j2);
                    if (ScreenShotUtil.mCallbackWeakRef == null || ScreenShotUtil.mCallbackWeakRef.get() == null) {
                        if (ScreenShotUtil.mScreenShotContentObserver != null) {
                            context2.getContentResolver().unregisterContentObserver(ScreenShotUtil.mScreenShotContentObserver);
                            ContentObserver unused = ScreenShotUtil.mScreenShotContentObserver = null;
                        }
                        if (ScreenShotUtil.mCallbackWeakRef != null) {
                            ScreenShotUtil.mCallbackWeakRef.clear();
                            WeakReference unused2 = ScreenShotUtil.mCallbackWeakRef = null;
                        }
                        Log.i(ScreenShotUtil.TAG, "summerscreenshot unregisterContentObserver callback is null 2");
                    } else {
                        ((ScreenShotCallback) ScreenShotUtil.mCallbackWeakRef.get()).onScreenShot(str, j2);
                        AppMethodBeat.o(230385);
                        return;
                    }
                }
                AppMethodBeat.o(230385);
            } catch (Throwable th) {
                Log.w(ScreenShotUtil.TAG, "summerscreenshot fail e:" + th.getMessage());
                AppMethodBeat.o(230385);
            }
        }
    }
}
