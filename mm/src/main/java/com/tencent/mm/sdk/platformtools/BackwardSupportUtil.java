package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.vfs.s;
import java.io.InputStream;

public class BackwardSupportUtil {
    public static final int ANDROID_API_LEVEL_16 = 16;
    private static final int ANDROID_API_LEVEL_8 = 8;
    private static final String TAG = "MicroMsg.SDK.BackwardSupportUtil";

    public static class BitmapFactory {
        private static final float HDPI_DENSITY = 1.5f;
        private static final float MDPI_DENSITY = 1.0f;

        public static Bitmap decodeFile(String str, float f2) {
            AppMethodBeat.i(156062);
            float f3 = 160.0f * f2;
            Bitmap bitmapNative = BitmapUtil.getBitmapNative(str, f2);
            if (bitmapNative != null) {
                bitmapNative.setDensity((int) f3);
            }
            AppMethodBeat.o(156062);
            return bitmapNative;
        }

        public static Bitmap decodeFileWithMemLimit(String str, int i2) {
            AppMethodBeat.i(215286);
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            if (imageOptions == null || TextUtils.isEmpty(imageOptions.outMimeType)) {
                Log.e(BackwardSupportUtil.TAG, "[-] [tomys] Fail to get image size: %s", str);
                AppMethodBeat.o(215286);
                return null;
            } else if (imageOptions.outWidth == 0 || imageOptions.outHeight == 0) {
                Log.w(BackwardSupportUtil.TAG, "[!] [tomys] Bad image size: %s x %s, try to decode it directly.", Integer.valueOf(imageOptions.outWidth), Integer.valueOf(imageOptions.outHeight));
                Bitmap bitmapNative = BitmapUtil.getBitmapNative(str);
                AppMethodBeat.o(215286);
                return bitmapNative;
            } else {
                imageOptions.inJustDecodeBounds = false;
                imageOptions.inSampleSize = 1;
                long j2 = (long) (imageOptions.outWidth * imageOptions.outHeight * 8);
                while (true) {
                    j2 = (j2 / ((long) imageOptions.inSampleSize)) / ((long) imageOptions.inSampleSize);
                    if (j2 > 0) {
                        if (j2 <= ((long) i2)) {
                            break;
                        }
                        imageOptions.inSampleSize++;
                    } else if (imageOptions.inSampleSize > 1) {
                        imageOptions.inSampleSize--;
                    }
                }
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, imageOptions);
                AppMethodBeat.o(215286);
                return decodeFile;
            }
        }

        public static int fromDPToPix(Context context, float f2) {
            AppMethodBeat.i(156063);
            int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * f2) / 160.0f);
            AppMethodBeat.o(156063);
            return round;
        }

        public static Bitmap decodeStream(InputStream inputStream) {
            AppMethodBeat.i(215287);
            Bitmap decodeStream = BitmapUtil.decodeStream(inputStream);
            AppMethodBeat.o(215287);
            return decodeStream;
        }

        public static Bitmap decodeStream(InputStream inputStream, float f2) {
            AppMethodBeat.i(156064);
            Bitmap decodeStream = decodeStream(inputStream, f2, 0, 0);
            AppMethodBeat.o(156064);
            return decodeStream;
        }

        public static Bitmap decodeStream(InputStream inputStream, float f2, int i2, int i3) {
            AppMethodBeat.i(215288);
            float f3 = 160.0f * f2;
            Bitmap decodeStream = BitmapUtil.decodeStream(inputStream, f2, i2, i3);
            if (decodeStream != null) {
                decodeStream.setDensity((int) f3);
            }
            AppMethodBeat.o(215288);
            return decodeStream;
        }

        public static String getDisplayDensityType(Context context) {
            String str;
            AppMethodBeat.i(156066);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            if (displayMetrics.density < MDPI_DENSITY) {
                str = "" + "LDPI";
            } else if (displayMetrics.density >= 1.5f) {
                str = "" + "HDPI";
            } else {
                str = "" + "MDPI";
            }
            String str2 = str + (configuration.orientation == 2 ? "_L" : "_P");
            AppMethodBeat.o(156066);
            return str2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x006c A[SYNTHETIC, Splitter:B:19:0x006c] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x008b A[SYNTHETIC, Splitter:B:28:0x008b] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static android.graphics.Bitmap getBitmapFromURL(java.lang.String r7) {
            /*
            // Method dump skipped, instructions count: 175
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory.getBitmapFromURL(java.lang.String):android.graphics.Bitmap");
        }

        public static String getDisplaySizeType(Context context) {
            AppMethodBeat.i(175899);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            String str = displayMetrics.heightPixels + "x" + displayMetrics.widthPixels;
            AppMethodBeat.o(175899);
            return str;
        }
    }

    public static class SmoothScrollFactory {

        public interface IScroll {
            void doScroll(ListView listView);

            void doScroll(ListView listView, int i2);

            void doScrollFromTop(ListView listView, int i2);
        }

        public static void scrollToTop(ListView listView) {
            AppMethodBeat.i(156073);
            if (listView == null) {
                AppMethodBeat.o(156073);
            } else if (Build.VERSION.SDK_INT >= 8) {
                new SmoothScrollToPosition22().doScroll(listView);
                AppMethodBeat.o(156073);
            } else {
                new SmoothScrollToPosition21below().doScroll(listView);
                AppMethodBeat.o(156073);
            }
        }

        public static void scrollTo(ListView listView, int i2) {
            AppMethodBeat.i(156074);
            if (listView == null) {
                AppMethodBeat.o(156074);
            } else if (Build.VERSION.SDK_INT >= 8) {
                new SmoothScrollToPosition22().doScroll(listView, i2);
                AppMethodBeat.o(156074);
            } else {
                new SmoothScrollToPosition21below().doScroll(listView, i2);
                AppMethodBeat.o(156074);
            }
        }

        public static void scrollToFromTop(ListView listView, int i2) {
            AppMethodBeat.i(156075);
            if (listView == null) {
                AppMethodBeat.o(156075);
            } else if (Build.VERSION.SDK_INT >= 11) {
                new SmoothScrollToPosition22().doScrollFromTop(listView, i2);
                AppMethodBeat.o(156075);
            } else {
                new SmoothScrollToPosition21below().doScrollFromTop(listView, i2);
                AppMethodBeat.o(156075);
            }
        }
    }

    public static class AnimationHelper {

        public interface IHelper {
            void cancelAnimation(View view, Animation animation);
        }

        public static void cancelAnimation(View view, Animation animation) {
            AppMethodBeat.i(156061);
            if (Build.VERSION.SDK_INT >= 8) {
                new AnimationHelperImpl22().cancelAnimation(view, animation);
                AppMethodBeat.o(156061);
                return;
            }
            new AnimationHelperImpl21below().cancelAnimation(view, animation);
            AppMethodBeat.o(156061);
        }

        public static void overridePendingTransition(Activity activity, int i2, int i3) {
            AppMethodBeat.i(215285);
            activity.overridePendingTransition(i2, i3);
            AppMethodBeat.o(215285);
        }
    }

    public static class ExifHelper {
        public static int getExifOrientation(String str) {
            AppMethodBeat.i(156071);
            if (Util.isNullOrNil(str)) {
                Log.d(BackwardSupportUtil.TAG, "filepath is null or nil");
                AppMethodBeat.o(156071);
                return 0;
            } else if (!s.YS(str)) {
                Log.d(BackwardSupportUtil.TAG, "file not exist:[%s]", str);
                AppMethodBeat.o(156071);
                return 0;
            } else {
                int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
                AppMethodBeat.o(156071);
                return orientationInDegree;
            }
        }

        public static class LatLongData implements Parcelable {
            public static final Parcelable.Creator<LatLongData> CREATOR = new Parcelable.Creator<LatLongData>() {
                /* class com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData.AnonymousClass1 */

                @Override // android.os.Parcelable.Creator
                public final LatLongData createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(215290);
                    LatLongData latLongData = new LatLongData();
                    latLongData.latitude = parcel.readFloat();
                    latLongData.longtitude = parcel.readFloat();
                    AppMethodBeat.o(215290);
                    return latLongData;
                }

                @Override // android.os.Parcelable.Creator
                public final LatLongData[] newArray(int i2) {
                    return new LatLongData[i2];
                }
            };
            private static final float PRECISION = 1.0E-6f;
            public float latitude;
            public float longtitude;

            public LatLongData() {
                this.latitude = 0.0f;
                this.longtitude = 0.0f;
            }

            public LatLongData(float f2, float f3) {
                this.latitude = f2;
                this.longtitude = f3;
            }

            public int hashCode() {
                return ((int) (this.latitude * 10000.0f)) + ((int) (this.longtitude * 10000.0f));
            }

            public boolean equals(Object obj) {
                AppMethodBeat.i(156068);
                if (!(obj instanceof LatLongData)) {
                    AppMethodBeat.o(156068);
                    return false;
                }
                LatLongData latLongData = (LatLongData) obj;
                if (Math.abs(this.latitude - latLongData.latitude) >= PRECISION || Math.abs(this.longtitude - latLongData.longtitude) >= PRECISION) {
                    AppMethodBeat.o(156068);
                    return false;
                }
                AppMethodBeat.o(156068);
                return true;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(156069);
                parcel.writeFloat(this.latitude);
                parcel.writeFloat(this.longtitude);
                AppMethodBeat.o(156069);
            }

            static {
                AppMethodBeat.i(156070);
                AppMethodBeat.o(156070);
            }
        }

        public static LatLongData getExifLatLong(String str) {
            AppMethodBeat.i(156072);
            if (Util.isNullOrNil(str)) {
                Log.d(BackwardSupportUtil.TAG, "filepath is null or nil");
                AppMethodBeat.o(156072);
                return null;
            } else if (!s.YS(str)) {
                Log.d(BackwardSupportUtil.TAG, "file not exist:[%s]", str);
                AppMethodBeat.o(156072);
                return null;
            } else {
                Exif.a location = Exif.fromFile(str).getLocation();
                if (location != null) {
                    LatLongData latLongData = new LatLongData();
                    latLongData.latitude = (float) location.latitude;
                    latLongData.longtitude = (float) location.longitude;
                    AppMethodBeat.o(156072);
                    return latLongData;
                }
                AppMethodBeat.o(156072);
                return null;
            }
        }

        public static String getExifTime(String str) {
            AppMethodBeat.i(215292);
            if (Util.isNullOrNil(str)) {
                Log.d(BackwardSupportUtil.TAG, "filepath is null or nil");
                AppMethodBeat.o(215292);
                return null;
            } else if (!s.YS(str)) {
                Log.d(BackwardSupportUtil.TAG, "file not exist:[%s]", str);
                AppMethodBeat.o(215292);
                return null;
            } else {
                String str2 = Exif.fromFile(str).dateTime;
                AppMethodBeat.o(215292);
                return str2;
            }
        }
    }

    public static ExifHelper.LatLongData getVideoLatLong(String str) {
        AppMethodBeat.i(156076);
        d dVar = new d();
        try {
            dVar.setDataSource(str);
            String extractMetadata = dVar.extractMetadata(23);
            dVar.release();
            Log.i(TAG, "getVideoLatLong locationString ".concat(String.valueOf(extractMetadata)));
            if (!TextUtils.isEmpty(extractMetadata)) {
                char[] charArray = extractMetadata.toCharArray();
                StringBuilder sb = new StringBuilder();
                for (char c2 : charArray) {
                    if (c2 == '+' || c2 == '-' || c2 == '.' || TextUtils.isDigitsOnly(String.valueOf(c2))) {
                        sb.append(c2);
                    }
                }
                String sb2 = sb.toString();
                int lastIndexOf = sb2.lastIndexOf(43);
                if (-1 == lastIndexOf) {
                    lastIndexOf = sb2.lastIndexOf(45);
                }
                ExifHelper.LatLongData latLongData = new ExifHelper.LatLongData();
                latLongData.latitude = Util.safeParseFloat(sb2.substring(0, lastIndexOf));
                latLongData.longtitude = Util.safeParseFloat(sb2.substring(lastIndexOf));
                AppMethodBeat.o(156076);
                return latLongData;
            }
            AppMethodBeat.o(156076);
            return null;
        } catch (Exception e2) {
            Log.e(TAG, "getVideoLatLong setDataSource failure: " + e2.getMessage());
            AppMethodBeat.o(156076);
            return null;
        }
    }

    public static String getVideoTakeTime(String str) {
        AppMethodBeat.i(156077);
        d dVar = new d();
        try {
            dVar.setDataSource(str);
            String extractMetadata = dVar.extractMetadata(5);
            dVar.release();
            Log.i(TAG, "getVideoTakeTime timeString ".concat(String.valueOf(extractMetadata)));
            AppMethodBeat.o(156077);
            return extractMetadata;
        } catch (Exception e2) {
            Log.e(TAG, "getVideoLatLong setDataSource failure: " + e2.getMessage());
            AppMethodBeat.o(156077);
            return null;
        }
    }
}
