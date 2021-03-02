package com.tencent.mm.plugin.gallery.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class a {
    public static Bitmap dZ(String str, int i2) {
        int i3;
        Bitmap bitmap = null;
        AppMethodBeat.i(111737);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GalleryBitmapUtil", "imgPath is invalid.");
            AppMethodBeat.o(111737);
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            byte[] thumbnail = new androidx.a.a.a(str).getThumbnail();
            if (thumbnail != null) {
                if (thumbnail != null) {
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(thumbnail, 0, thumbnail.length, options);
                    if (options.outWidth >= i2 && options.outHeight >= i2) {
                        int max = Math.max(options.outWidth / i2, options.outHeight / i2);
                        if (max <= 1) {
                            i3 = 1;
                        } else if (max > 8) {
                            i3 = (max / 8) * 8;
                        } else if (max <= 0) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                            AppMethodBeat.o(111737);
                            throw illegalArgumentException;
                        } else {
                            i3 = Integer.highestOneBit(max);
                        }
                        options.inSampleSize = i3;
                        options.inJustDecodeBounds = false;
                        options.inMutable = true;
                        bitmap = BitmapFactory.decodeByteArray(thumbnail, 0, thumbnail.length, options);
                    }
                }
                if (bitmap != null) {
                    Log.i("MicroMsg.GalleryBitmapUtil", "decode thumb success from exif.");
                    AppMethodBeat.o(111737);
                    return bitmap;
                }
            }
        } catch (FileNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", e2, "failed to find file to read thumbnail: %s.", str);
        } catch (IOException | IndexOutOfBoundsException | OutOfMemoryError e3) {
            Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", e3, "failed to get thumbnail from: %s.", str);
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", e4, "failed to get thumbnail from: %s.", str);
        }
        Bitmap a2 = a(str, options, i2);
        AppMethodBeat.o(111737);
        return a2;
    }

    private static Bitmap a(String str, BitmapFactory.Options options, int i2) {
        int i3;
        AppMethodBeat.i(111738);
        try {
            FileDescriptor fileDescriptor = s.nv(str, "r").getFileDescriptor();
            if (fileDescriptor == null) {
                AppMethodBeat.o(111738);
                return null;
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            int i4 = options.outWidth;
            int i5 = options.outHeight;
            if (i4 == -1 || i5 == -1) {
                Log.i("MicroMsg.GalleryBitmapUtil", "decode error, get invalid picture size");
                AppMethodBeat.o(111738);
                return null;
            }
            int min = Math.min(i4, i5) / i2;
            if (min <= 0) {
                i3 = 1;
            } else if (min <= 0 || min > 1073741824) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("n is invalid: ".concat(String.valueOf(min)));
                AppMethodBeat.o(111738);
                throw illegalArgumentException;
            } else {
                int i6 = min - 1;
                int i7 = i6 | (i6 >> 16);
                int i8 = i7 | (i7 >> 8);
                int i9 = i8 | (i8 >> 4);
                int i10 = i9 | (i9 >> 2);
                i3 = (i10 | (i10 >> 1)) + 1;
            }
            while ((i4 / i3) * (i5 / i3) >= 640000) {
                i3 *= 2;
            }
            options.inSampleSize = i3;
            options.inJustDecodeBounds = false;
            options.inMutable = true;
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            if (decodeFileDescriptor.getWidth() * decodeFileDescriptor.getHeight() >= 640000) {
                decodeFileDescriptor = Bitmap.createScaledBitmap(decodeFileDescriptor, i4 / i3, i5 / i3, false);
            }
            AppMethodBeat.o(111738);
            return decodeFileDescriptor;
        } catch (Exception | OutOfMemoryError e2) {
            Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", e2, "decodeThumbnail fail!!!", new Object[0]);
            AppMethodBeat.o(111738);
            return null;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", th, "err!!", new Object[0]);
            AppMethodBeat.o(111738);
            return null;
        }
    }
}
