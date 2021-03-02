package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.z;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

public final class a extends android.support.v4.content.b {
    private static b Ey;

    /* renamed from: android.support.v4.app.a$a  reason: collision with other inner class name */
    public interface AbstractC0015a {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    public interface b {
        boolean dW();

        boolean dX();
    }

    public interface c {
        void validateRequestPermissionsRequestCode(int i2);
    }

    public static b dV() {
        return Ey;
    }

    public static void a(Activity activity, Intent intent, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i2, bundle);
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void e(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, z zVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(zVar != null ? new d(zVar) : null);
        }
    }

    public static void b(Activity activity, z zVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(zVar != null ? new d(zVar) : null);
        }
    }

    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i2) {
        if (Ey != null && Ey.dW()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof c) {
                ((c) activity).validateRequestPermissionsRequestCode(i2);
            }
            com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a()).bl(strArr);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "android/support/v4/app/ActivityCompat", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
            activity.requestPermissions((String[]) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(activity, "android/support/v4/app/ActivityCompat", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        } else if (activity instanceof AbstractC0015a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class android.support.v4.app.a.AnonymousClass1 */

                public final void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    ((AbstractC0015a) activity).onRequestPermissionsResult(i2, strArr, iArr);
                }
            });
        }
    }

    public static boolean a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class d extends SharedElementCallback {
        private final z EA;

        d(z zVar) {
            this.EA = zVar;
        }

        @Override // android.app.SharedElementCallback
        public final void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        }

        @Override // android.app.SharedElementCallback
        public final void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        }

        @Override // android.app.SharedElementCallback
        public final void onRejectSharedElements(List<View> list) {
        }

        @Override // android.app.SharedElementCallback
        public final void onMapSharedElements(List<String> list, Map<String, View> map) {
        }

        public final Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            Bitmap bitmap;
            z zVar = this.EA;
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                Drawable drawable = imageView.getDrawable();
                Drawable background = imageView.getBackground();
                if (drawable != null && background == null) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                        bitmap = null;
                    } else {
                        float min = Math.min(1.0f, 1048576.0f / ((float) (intrinsicWidth * intrinsicHeight)));
                        if (!(drawable instanceof BitmapDrawable) || min != 1.0f) {
                            int i2 = (int) (((float) intrinsicWidth) * min);
                            int i3 = (int) (((float) intrinsicHeight) * min);
                            bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(bitmap);
                            Rect bounds = drawable.getBounds();
                            int i4 = bounds.left;
                            int i5 = bounds.top;
                            int i6 = bounds.right;
                            int i7 = bounds.bottom;
                            drawable.setBounds(0, 0, i2, i3);
                            drawable.draw(canvas);
                            drawable.setBounds(i4, i5, i6, i7);
                        } else {
                            bitmap = ((BitmapDrawable) drawable).getBitmap();
                        }
                    }
                    if (bitmap != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("sharedElement:snapshot:bitmap", bitmap);
                        bundle.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
                        if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            float[] fArr = new float[9];
                            imageView.getImageMatrix().getValues(fArr);
                            bundle.putFloatArray("sharedElement:snapshot:imageMatrix", fArr);
                        }
                        return bundle;
                    }
                }
            }
            int round = Math.round(rectF.width());
            int round2 = Math.round(rectF.height());
            if (round <= 0 || round2 <= 0) {
                return null;
            }
            float min2 = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
            int i8 = (int) (((float) round) * min2);
            int i9 = (int) (((float) round2) * min2);
            if (zVar.AB == null) {
                zVar.AB = new Matrix();
            }
            zVar.AB.set(matrix);
            zVar.AB.postTranslate(-rectF.left, -rectF.top);
            zVar.AB.postScale(min2, min2);
            Bitmap createBitmap = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            canvas2.concat(zVar.AB);
            view.draw(canvas2);
            return createBitmap;
        }

        @Override // android.app.SharedElementCallback
        public final void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            new z.a() {
                /* class android.support.v4.app.a.d.AnonymousClass1 */

                @Override // android.support.v4.app.z.a
                public final void onSharedElementsReady() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            }.onSharedElementsReady();
        }

        public final View onCreateSnapshotView(Context context, Parcelable parcelable) {
            ImageView imageView;
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                Bitmap bitmap = (Bitmap) bundle.getParcelable("sharedElement:snapshot:bitmap");
                if (bitmap == null) {
                    return null;
                }
                ImageView imageView2 = new ImageView(context);
                imageView2.setImageBitmap(bitmap);
                imageView2.setScaleType(ImageView.ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
                if (imageView2.getScaleType() == ImageView.ScaleType.MATRIX) {
                    float[] floatArray = bundle.getFloatArray("sharedElement:snapshot:imageMatrix");
                    Matrix matrix = new Matrix();
                    matrix.setValues(floatArray);
                    imageView2.setImageMatrix(matrix);
                }
                imageView = imageView2;
            } else if (parcelable instanceof Bitmap) {
                imageView = new ImageView(context);
                imageView.setImageBitmap((Bitmap) parcelable);
            } else {
                imageView = null;
            }
            return imageView;
        }
    }
}
