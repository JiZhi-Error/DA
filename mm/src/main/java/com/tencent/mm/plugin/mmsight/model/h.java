package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class h {
    public static c a(Camera.Parameters parameters, Point point, int i2, boolean z) {
        AppMethodBeat.i(186113);
        c b2 = b(parameters, point, i2, z);
        AppMethodBeat.o(186113);
        return b2;
    }

    public static c b(Camera.Parameters parameters, Point point, int i2, boolean z) {
        int i3;
        AppMethodBeat.i(185470);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new b((byte) 0));
        new ArrayList(parameters.getSupportedPictureSizes());
        Log.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", d.fy(arrayList));
        Log.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)), Integer.valueOf(i2), 0);
        Log.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(Util.getAvailableMemoryMB(MMApplicationContext.getContext())));
        c cVar = new c();
        cVar.zum = a(arrayList, point, z, i2);
        if (cVar.zum == null) {
            Point point2 = new Point();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i3 = 0;
                    break;
                }
                Camera.Size size = (Camera.Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x == point2.y) {
                    Log.i("MicroMsg.MMSightCameraInfo", "exclude square curSize: %s", point2);
                } else {
                    Log.i("MicroMsg.MMSightCameraInfo", "cursize is %s * %s , and isRotate %s, screenRes.x %s, screenRes.y %s", Integer.valueOf(point2.x), Integer.valueOf(point2.y), Boolean.valueOf(z), Integer.valueOf(point.x), Integer.valueOf(point.y));
                    if (point.y > point.x) {
                        if (point2.y >= point2.x) {
                            Log.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio  1 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                        }
                    } else if (point2.x >= point2.y) {
                        Log.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio 2 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                    }
                    Point a2 = d.a(point, point2, z);
                    if (a2 == null) {
                        Log.i("MicroMsg.MMSightCameraInfo", "curSize: %s, can not find crop size", point2);
                    } else {
                        Log.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", point2, a2);
                        cVar.zuq = new Point(a2.x, a2.y);
                        cVar.zup = new Point(point2.x, point2.y);
                        cVar.zur = d.a(point, point2, z, true);
                        if (Math.min(a2.x, a2.y) <= i2) {
                            if (Math.min(a2.x, a2.y) < 0) {
                                AppMethodBeat.o(185470);
                                return null;
                            }
                            Point point3 = new Point(point2.x, point2.y);
                            cVar.zum = point3;
                            cVar.zun = a2;
                            cVar.zuo = d.a(point, cVar.zum, z, true);
                            i3 = 1;
                            Log.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", point3, a2, 1);
                        }
                    }
                }
            }
        } else {
            cVar.zun = d.a(point, cVar.zum, z);
            cVar.zuo = d.a(point, cVar.zum, z, true);
            i3 = 0;
        }
        Log.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d", cVar.zum, cVar.zun, Integer.valueOf(i3));
        AppMethodBeat.o(185470);
        return cVar;
    }

    public static c a(Size[] sizeArr, Point point, int i2, boolean z) {
        Point point2;
        int i3;
        AppMethodBeat.i(89413);
        Arrays.sort(sizeArr, new a((byte) 0));
        Log.i("MicroMsg.MMSightCameraInfo", "tryFindPreviewSizeAnyWay supportedPreviewSizes: %s", d.a(sizeArr));
        Log.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)), Integer.valueOf(i2));
        Log.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(Util.getAvailableMemoryMB(MMApplicationContext.getContext())));
        c cVar = new c();
        int i4 = point.x;
        int i5 = point.y;
        if ((i5 * i2) % i4 == 0) {
            int i6 = (i5 * i2) / i4;
            if (z) {
                int i7 = i2 ^ i6;
                i6 ^= i7;
                i3 = i7 ^ i6;
            } else {
                i3 = i2;
            }
            int length = sizeArr.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    break;
                }
                Size size = sizeArr[i8];
                if (size.getWidth() != i3 || size.getHeight() != i6) {
                    if (Math.min(size.getWidth(), size.getHeight()) < i2) {
                        break;
                    }
                    i8++;
                } else {
                    Log.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", Integer.valueOf(i3), Integer.valueOf(i6));
                    point2 = new Point(i3, i6);
                    break;
                }
            }
        }
        point2 = null;
        cVar.zum = point2;
        if (cVar.zum == null) {
            Point point3 = new Point();
            Math.min(point.x, point.y);
            Math.max(point.x, point.y);
            int length2 = sizeArr.length;
            int i9 = 0;
            while (true) {
                if (i9 >= length2) {
                    break;
                }
                Size size2 = sizeArr[i9];
                point3.x = size2.getWidth();
                point3.y = size2.getHeight();
                if (point3.x != point3.y && Math.min(point3.x, point3.y) <= i2 && Math.max(point3.x, point3.y) <= 2000 && d.b(point, point3, z) != null) {
                    cVar.zum = null;
                    break;
                }
                i9++;
            }
        } else {
            cVar.zun = d.b(point, cVar.zum, z);
            cVar.zuo = d.b(point, cVar.zum, z, true);
        }
        Log.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", cVar.zum, cVar.zun, 0);
        AppMethodBeat.o(89413);
        return cVar;
    }

    public static c d(Camera.Parameters parameters, Point point, int i2, boolean z) {
        AppMethodBeat.i(89414);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new b((byte) 0));
        new ArrayList(parameters.getSupportedPictureSizes());
        Log.i("MicroMsg.MMSightCameraInfo", "tryFindPreviewSizeAnyWay supportedPreviewSizes: %s", d.fy(arrayList));
        Log.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)), Integer.valueOf(i2));
        Log.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(Util.getAvailableMemoryMB(MMApplicationContext.getContext())));
        c cVar = new c();
        cVar.zum = a(arrayList, point, z, i2);
        if (cVar.zum == null) {
            Point point2 = new Point();
            Math.min(point.x, point.y);
            Math.max(point.x, point.y);
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Camera.Size size = (Camera.Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x != point2.y && Math.min(point2.x, point2.y) <= i2 && Math.max(point2.x, point2.y) <= 2000 && d.b(point, point2, z) != null) {
                    cVar.zum = null;
                    break;
                }
            }
        } else {
            cVar.zun = d.b(point, cVar.zum, z);
            cVar.zuo = d.b(point, cVar.zum, z, true);
        }
        Log.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", cVar.zum, cVar.zun, 0);
        AppMethodBeat.o(89414);
        return cVar;
    }

    private static Point a(ArrayList<Camera.Size> arrayList, Point point, boolean z, int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(89415);
        int i5 = point.x;
        int i6 = point.y;
        if ((i6 * i2) % i5 != 0) {
            AppMethodBeat.o(89415);
            return null;
        }
        int i7 = (i6 * i2) / i5;
        if (z) {
            int i8 = i2 ^ i7;
            i4 = i8 ^ i7;
            i3 = i8 ^ i4;
        } else {
            i3 = i2;
            i4 = i7;
        }
        Iterator<Camera.Size> it = arrayList.iterator();
        while (it.hasNext()) {
            Camera.Size next = it.next();
            if (next.width == i3 && next.height == i4) {
                Log.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", Integer.valueOf(i3), Integer.valueOf(i4));
                Point point2 = new Point(i3, i4);
                AppMethodBeat.o(89415);
                return point2;
            } else if (Math.min(next.width, next.height) < i2) {
                AppMethodBeat.o(89415);
                return null;
            }
        }
        AppMethodBeat.o(89415);
        return null;
    }

    public static c b(Size[] sizeArr, Point point, int i2, boolean z) {
        AppMethodBeat.i(89417);
        Arrays.sort(sizeArr, new a((byte) 0));
        Log.i("MicroMsg.MMSightCameraInfo", "findPreviewSizeWithoutCrop supportedPreviewSizes: %s", d.a(sizeArr));
        Log.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s ", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)), Integer.valueOf(i2));
        Log.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(Util.getAvailableMemoryMB(MMApplicationContext.getContext())));
        c cVar = new c();
        Point point2 = null;
        int i3 = ((int) (((float) i2) * 1.05f)) + 64;
        int length = sizeArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            Size size = sizeArr[i4];
            if (size.getHeight() <= i3 && size.getWidth() <= 2000) {
                point2 = new Point();
                point2.x = size.getWidth();
                point2.y = size.getHeight();
                break;
            }
            i4++;
        }
        Log.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s ", point2);
        cVar.zuq = new Point(point2.x, point2.y);
        cVar.zup = new Point(point2.x, point2.y);
        cVar.zur = d.a(point, point2, z, true);
        Point point3 = new Point(point2.x, point2.y);
        cVar.zum = point3;
        cVar.zun = point2;
        cVar.zuo = d.a(point, cVar.zum, z, true);
        Log.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s ", point3, point2);
        AppMethodBeat.o(89417);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public static class b implements Comparator<Camera.Size> {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
            Camera.Size size3 = size;
            Camera.Size size4 = size2;
            int i2 = size3.height * size3.width;
            int i3 = size4.height * size4.width;
            if (i3 < i2) {
                return -1;
            }
            if (i3 > i2) {
                return 1;
            }
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements Comparator<Size> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Size size, Size size2) {
            AppMethodBeat.i(89408);
            Size size3 = size;
            Size size4 = size2;
            int height = size3.getHeight() * size3.getWidth();
            int height2 = size4.getHeight() * size4.getWidth();
            if (height2 < height) {
                AppMethodBeat.o(89408);
                return -1;
            } else if (height2 > height) {
                AppMethodBeat.o(89408);
                return 1;
            } else {
                AppMethodBeat.o(89408);
                return 0;
            }
        }
    }

    public static class c {
        public Point zum;
        public Point zun;
        public Point zuo;
        public Point zup;
        public Point zuq;
        public Point zur;

        public final String toString() {
            AppMethodBeat.i(89409);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.zum != null) {
                stringBuffer.append(this.zum.toString() + ",");
            }
            if (this.zun != null) {
                stringBuffer.append(this.zun.toString() + ",");
            }
            if (this.zuo != null) {
                stringBuffer.append(this.zuo.toString() + ",");
            }
            if (this.zup != null) {
                stringBuffer.append(this.zup.toString() + ",");
            }
            if (this.zuq != null) {
                stringBuffer.append(this.zuq.toString() + ",");
            }
            if (this.zur != null) {
                stringBuffer.append(this.zur.toString() + ",");
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(89409);
            return stringBuffer2;
        }
    }

    public static c c(Camera.Parameters parameters, Point point, int i2, boolean z) {
        AppMethodBeat.i(186114);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new b((byte) 0));
        Log.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", d.fy(arrayList));
        Log.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)), Integer.valueOf(i2), 0);
        Log.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(Util.getAvailableMemoryMB(MMApplicationContext.getContext())));
        c cVar = new c();
        Point point2 = new Point();
        int i3 = ((int) (((float) i2) * 1.05f)) + 64;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Camera.Size size = (Camera.Size) it.next();
            if (size.height <= i3) {
                point2.x = size.width;
                point2.y = size.height;
                Log.i("MicroMsg.MMSightCameraInfo", "cursize is %s * %s , and isRotate %s, screenRes.x %s, screenRes.y %s", Integer.valueOf(point2.x), Integer.valueOf(point2.y), Boolean.valueOf(z), Integer.valueOf(point.x), Integer.valueOf(point.y));
                if (point.y > point.x) {
                    if (point2.y >= point2.x) {
                        Log.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio  1 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                    }
                } else if (point2.x >= point2.y) {
                    Log.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio 2 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                }
                Point a2 = d.a(point, point2, z, false);
                if (a2 != null) {
                    Log.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", point2, a2);
                    cVar.zuq = new Point(a2.x, a2.y);
                    cVar.zup = new Point(point2.x, point2.y);
                    cVar.zur = d.a(point, point2, z, true);
                    Point point3 = new Point(point2.x, point2.y);
                    cVar.zum = point3;
                    cVar.zun = a2;
                    cVar.zuo = d.a(point, cVar.zum, z, true);
                    Log.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", point3, a2, 1);
                    AppMethodBeat.o(186114);
                    return cVar;
                }
            }
        }
        Log.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with crop width", cVar.zum, cVar.zun, 0);
        AppMethodBeat.o(186114);
        return cVar;
    }
}
