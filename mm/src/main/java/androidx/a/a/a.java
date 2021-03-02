package androidx.a.a;

import android.content.res.AssetManager;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.pay.tool.APPluginConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ct;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.ak;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

public final class a {
    private static final boolean DEBUG = Log.isLoggable("ExifInterface", 3);
    private static final byte[] aAV = {102, 116, 121, 112};
    private static final byte[] aAW = {109, 105, 102, 49};
    private static final byte[] aAX = {104, 101, 105, 99};
    private static final d[] aAY = {new d(android.support.e.a.TAG_NEW_SUBFILE_TYPE, 254, 4), new d(android.support.e.a.TAG_SUBFILE_TYPE, 255, 4), new d(android.support.e.a.TAG_IMAGE_WIDTH, 256), new d(android.support.e.a.TAG_IMAGE_LENGTH, CdnLogic.kAppTypeFestivalImage), new d(android.support.e.a.TAG_BITS_PER_SAMPLE, CdnLogic.kAppTypeFestivalVideo, 3), new d(android.support.e.a.TAG_COMPRESSION, 259, 3), new d(android.support.e.a.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new d(android.support.e.a.TAG_IMAGE_DESCRIPTION, 270, 2), new d(android.support.e.a.TAG_MAKE, a.C0691a.CTRL_INDEX, 2), new d(android.support.e.a.TAG_MODEL, 272, 2), new d(android.support.e.a.TAG_STRIP_OFFSETS, 273), new d(android.support.e.a.TAG_ORIENTATION, a.C0693a.CTRL_INDEX, 3), new d(android.support.e.a.TAG_SAMPLES_PER_PIXEL, 277, 3), new d(android.support.e.a.TAG_ROWS_PER_STRIP, 278), new d(android.support.e.a.TAG_STRIP_BYTE_COUNTS, 279), new d(android.support.e.a.TAG_X_RESOLUTION, 282, 5), new d(android.support.e.a.TAG_Y_RESOLUTION, ct.CTRL_INDEX, 5), new d(android.support.e.a.TAG_PLANAR_CONFIGURATION, ak.CTRL_INDEX, 3), new d(android.support.e.a.TAG_RESOLUTION_UNIT, 296, 3), new d(android.support.e.a.TAG_TRANSFER_FUNCTION, 301, 3), new d(android.support.e.a.TAG_SOFTWARE, 305, 2), new d(android.support.e.a.TAG_DATETIME, TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, 2), new d(android.support.e.a.TAG_ARTIST, com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, 2), new d(android.support.e.a.TAG_WHITE_POINT, 318, 5), new d(android.support.e.a.TAG_PRIMARY_CHROMATICITIES, TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 5), new d("SubIFDPointer", TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4), new d(android.support.e.a.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new d(android.support.e.a.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new d(android.support.e.a.TAG_Y_CB_CR_COEFFICIENTS, f.CTRL_INDEX, 5), new d(android.support.e.a.TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new d(android.support.e.a.TAG_Y_CB_CR_POSITIONING, 531, 3), new d(android.support.e.a.TAG_REFERENCE_BLACK_WHITE, com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX, 5), new d(android.support.e.a.TAG_COPYRIGHT, 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d(android.support.e.a.TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new d(android.support.e.a.TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new d(android.support.e.a.TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new d(android.support.e.a.TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new d(android.support.e.a.TAG_RW2_ISO, 23, 3), new d(android.support.e.a.TAG_RW2_JPG_FROM_RAW, 46, 7), new d("Xmp", 700, 1)};
    private static final d[] aAZ = {new d(android.support.e.a.TAG_EXPOSURE_TIME, 33434, 5), new d(android.support.e.a.TAG_F_NUMBER, 33437, 5), new d(android.support.e.a.TAG_EXPOSURE_PROGRAM, 34850, 3), new d(android.support.e.a.TAG_SPECTRAL_SENSITIVITY, 34852, 2), new d(android.support.e.a.TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new d(android.support.e.a.TAG_OECF, 34856, 7), new d(android.support.e.a.TAG_EXIF_VERSION, 36864, 2), new d(android.support.e.a.TAG_DATETIME_ORIGINAL, 36867, 2), new d(android.support.e.a.TAG_DATETIME_DIGITIZED, 36868, 2), new d(android.support.e.a.TAG_COMPONENTS_CONFIGURATION, 37121, 7), new d(android.support.e.a.TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new d(android.support.e.a.TAG_SHUTTER_SPEED_VALUE, 37377, 10), new d(android.support.e.a.TAG_APERTURE_VALUE, 37378, 5), new d(android.support.e.a.TAG_BRIGHTNESS_VALUE, 37379, 10), new d(android.support.e.a.TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new d(android.support.e.a.TAG_MAX_APERTURE_VALUE, 37381, 5), new d(android.support.e.a.TAG_SUBJECT_DISTANCE, 37382, 5), new d(android.support.e.a.TAG_METERING_MODE, 37383, 3), new d(android.support.e.a.TAG_LIGHT_SOURCE, 37384, 3), new d(android.support.e.a.TAG_FLASH, 37385, 3), new d(android.support.e.a.TAG_FOCAL_LENGTH, 37386, 5), new d(android.support.e.a.TAG_SUBJECT_AREA, 37396, 3), new d(android.support.e.a.TAG_MAKER_NOTE, 37500, 7), new d(android.support.e.a.TAG_USER_COMMENT, 37510, 7), new d(android.support.e.a.TAG_SUBSEC_TIME, 37520, 2), new d(android.support.e.a.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new d(android.support.e.a.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new d(android.support.e.a.TAG_FLASHPIX_VERSION, 40960, 7), new d(android.support.e.a.TAG_COLOR_SPACE, 40961, 3), new d(android.support.e.a.TAG_PIXEL_X_DIMENSION, 40962), new d(android.support.e.a.TAG_PIXEL_Y_DIMENSION, 40963), new d(android.support.e.a.TAG_RELATED_SOUND_FILE, 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d(android.support.e.a.TAG_FLASH_ENERGY, 41483, 5), new d(android.support.e.a.TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new d(android.support.e.a.TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new d(android.support.e.a.TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new d(android.support.e.a.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new d(android.support.e.a.TAG_SUBJECT_LOCATION, 41492, 3), new d(android.support.e.a.TAG_EXPOSURE_INDEX, 41493, 5), new d(android.support.e.a.TAG_SENSING_METHOD, 41495, 3), new d(android.support.e.a.TAG_FILE_SOURCE, 41728, 7), new d(android.support.e.a.TAG_SCENE_TYPE, 41729, 7), new d(android.support.e.a.TAG_CFA_PATTERN, 41730, 7), new d(android.support.e.a.TAG_CUSTOM_RENDERED, 41985, 3), new d(android.support.e.a.TAG_EXPOSURE_MODE, 41986, 3), new d(android.support.e.a.TAG_WHITE_BALANCE, 41987, 3), new d(android.support.e.a.TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new d(android.support.e.a.TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new d(android.support.e.a.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new d(android.support.e.a.TAG_GAIN_CONTROL, 41991, 3), new d(android.support.e.a.TAG_CONTRAST, 41992, 3), new d(android.support.e.a.TAG_SATURATION, 41993, 3), new d(android.support.e.a.TAG_SHARPNESS, 41994, 3), new d(android.support.e.a.TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new d(android.support.e.a.TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new d(android.support.e.a.TAG_IMAGE_UNIQUE_ID, 42016, 2), new d(android.support.e.a.TAG_DNG_VERSION, 50706, 1), new d(android.support.e.a.TAG_DEFAULT_CROP_SIZE, 50720)};
    private static final d[] aBa = {new d(android.support.e.a.TAG_GPS_VERSION_ID, 0, 1), new d(android.support.e.a.TAG_GPS_LATITUDE_REF, 1, 2), new d(android.support.e.a.TAG_GPS_LATITUDE, 2, 5), new d(android.support.e.a.TAG_GPS_LONGITUDE_REF, 3, 2), new d(android.support.e.a.TAG_GPS_LONGITUDE, 4, 5), new d(android.support.e.a.TAG_GPS_ALTITUDE_REF, 5, 1), new d(android.support.e.a.TAG_GPS_ALTITUDE, 6, 5), new d(android.support.e.a.TAG_GPS_TIMESTAMP, 7, 5), new d(android.support.e.a.TAG_GPS_SATELLITES, 8, 2), new d(android.support.e.a.TAG_GPS_STATUS, 9, 2), new d(android.support.e.a.TAG_GPS_MEASURE_MODE, 10, 2), new d(android.support.e.a.TAG_GPS_DOP, 11, 5), new d(android.support.e.a.TAG_GPS_SPEED_REF, 12, 2), new d(android.support.e.a.TAG_GPS_SPEED, 13, 5), new d(android.support.e.a.TAG_GPS_TRACK_REF, 14, 2), new d(android.support.e.a.TAG_GPS_TRACK, 15, 5), new d(android.support.e.a.TAG_GPS_IMG_DIRECTION_REF, 16, 2), new d(android.support.e.a.TAG_GPS_IMG_DIRECTION, 17, 5), new d(android.support.e.a.TAG_GPS_MAP_DATUM, 18, 2), new d(android.support.e.a.TAG_GPS_DEST_LATITUDE_REF, 19, 2), new d(android.support.e.a.TAG_GPS_DEST_LATITUDE, 20, 5), new d(android.support.e.a.TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new d(android.support.e.a.TAG_GPS_DEST_LONGITUDE, 22, 5), new d(android.support.e.a.TAG_GPS_DEST_BEARING_REF, 23, 2), new d(android.support.e.a.TAG_GPS_DEST_BEARING, 24, 5), new d(android.support.e.a.TAG_GPS_DEST_DISTANCE_REF, 25, 2), new d(android.support.e.a.TAG_GPS_DEST_DISTANCE, 26, 5), new d(android.support.e.a.TAG_GPS_PROCESSING_METHOD, 27, 7), new d(android.support.e.a.TAG_GPS_AREA_INFORMATION, 28, 7), new d(android.support.e.a.TAG_GPS_DATESTAMP, 29, 2), new d(android.support.e.a.TAG_GPS_DIFFERENTIAL, 30, 3)};
    private static final d[] aBb = {new d(android.support.e.a.TAG_INTEROPERABILITY_INDEX, 1, 2)};
    private static final d[] aBc = {new d(android.support.e.a.TAG_NEW_SUBFILE_TYPE, 254, 4), new d(android.support.e.a.TAG_SUBFILE_TYPE, 255, 4), new d(android.support.e.a.TAG_THUMBNAIL_IMAGE_WIDTH, 256), new d(android.support.e.a.TAG_THUMBNAIL_IMAGE_LENGTH, CdnLogic.kAppTypeFestivalImage), new d(android.support.e.a.TAG_BITS_PER_SAMPLE, CdnLogic.kAppTypeFestivalVideo, 3), new d(android.support.e.a.TAG_COMPRESSION, 259, 3), new d(android.support.e.a.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new d(android.support.e.a.TAG_IMAGE_DESCRIPTION, 270, 2), new d(android.support.e.a.TAG_MAKE, a.C0691a.CTRL_INDEX, 2), new d(android.support.e.a.TAG_MODEL, 272, 2), new d(android.support.e.a.TAG_STRIP_OFFSETS, 273), new d("ThumbnailOrientation", a.C0693a.CTRL_INDEX, 3), new d(android.support.e.a.TAG_SAMPLES_PER_PIXEL, 277, 3), new d(android.support.e.a.TAG_ROWS_PER_STRIP, 278), new d(android.support.e.a.TAG_STRIP_BYTE_COUNTS, 279), new d(android.support.e.a.TAG_X_RESOLUTION, 282, 5), new d(android.support.e.a.TAG_Y_RESOLUTION, ct.CTRL_INDEX, 5), new d(android.support.e.a.TAG_PLANAR_CONFIGURATION, ak.CTRL_INDEX, 3), new d(android.support.e.a.TAG_RESOLUTION_UNIT, 296, 3), new d(android.support.e.a.TAG_TRANSFER_FUNCTION, 301, 3), new d(android.support.e.a.TAG_SOFTWARE, 305, 2), new d(android.support.e.a.TAG_DATETIME, TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, 2), new d(android.support.e.a.TAG_ARTIST, com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, 2), new d(android.support.e.a.TAG_WHITE_POINT, 318, 5), new d(android.support.e.a.TAG_PRIMARY_CHROMATICITIES, TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 5), new d("SubIFDPointer", TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4), new d(android.support.e.a.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new d(android.support.e.a.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new d(android.support.e.a.TAG_Y_CB_CR_COEFFICIENTS, f.CTRL_INDEX, 5), new d(android.support.e.a.TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new d(android.support.e.a.TAG_Y_CB_CR_POSITIONING, 531, 3), new d(android.support.e.a.TAG_REFERENCE_BLACK_WHITE, com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX, 5), new d(android.support.e.a.TAG_COPYRIGHT, 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d(android.support.e.a.TAG_DNG_VERSION, 50706, 1), new d(android.support.e.a.TAG_DEFAULT_CROP_SIZE, 50720)};
    private static final d aBd = new d(android.support.e.a.TAG_STRIP_OFFSETS, 273, 3);
    private static final d[] aBe = {new d(android.support.e.a.TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
    private static final d[] aBf = {new d(android.support.e.a.TAG_ORF_PREVIEW_IMAGE_START, CdnLogic.kAppTypeFestivalImage, 4), new d(android.support.e.a.TAG_ORF_PREVIEW_IMAGE_LENGTH, CdnLogic.kAppTypeFestivalVideo, 4)};
    private static final d[] aBg = {new d(android.support.e.a.TAG_ORF_ASPECT_FRAME, 4371, 3)};
    private static final d[] aBh = {new d(android.support.e.a.TAG_COLOR_SPACE, 55, 3)};
    static final d[][] aBi = {aAY, aAZ, aBa, aBb, aBc, aAY, aBe, aBf, aBg, aBh};
    private static final d[] aBj = {new d("SubIFDPointer", TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
    private static final d aBk = new d(android.support.e.a.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
    private static final d aBl = new d(android.support.e.a.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
    private static final byte[] aBm = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(yX);
    private static final byte[] yA = {79, 76, 89, 77, 80, 0};
    private static final byte[] yB = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static SimpleDateFormat yC;
    static final String[] yD = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] yE = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] yF = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final HashMap<Integer, d>[] yT = new HashMap[aBi.length];
    private static final HashMap<String, d>[] yU = new HashMap[aBi.length];
    private static final HashSet<String> yV = new HashSet<>(Arrays.asList(android.support.e.a.TAG_F_NUMBER, android.support.e.a.TAG_DIGITAL_ZOOM_RATIO, android.support.e.a.TAG_EXPOSURE_TIME, android.support.e.a.TAG_SUBJECT_DISTANCE, android.support.e.a.TAG_GPS_TIMESTAMP));
    private static final HashMap<Integer, Integer> yW = new HashMap<>();
    static final Charset yX = Charset.forName("US-ASCII");
    static final byte[] yY = "Exif\u0000\u0000".getBytes(yX);
    private static final List<Integer> yu = Arrays.asList(1, 6, 3, 8);
    private static final List<Integer> yv = Arrays.asList(2, 7, 4, 5);
    public static final int[] yw = {8, 8, 8};
    public static final int[] yx = {4};
    public static final int[] yy = {8};
    static final byte[] yz = {-1, -40, -1};
    private static final Pattern zr = Pattern.compile(".*[1-9].*");
    private static final Pattern zt = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    public FileDescriptor aBn;
    public boolean aBo;
    public String yZ;
    private AssetManager.AssetInputStream za;
    public int zb;
    private final HashMap<String, c>[] zc;
    private Set<Integer> zd;
    private ByteOrder ze;
    private boolean zf;
    private int zg;
    private int zi;
    public byte[] zj;
    private int zk;
    private int zl;
    private int zm;
    private int zn;
    private int zo;
    private int zp;
    public boolean zq;

    static {
        AppMethodBeat.i(178752);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        yC = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i2 = 0; i2 < aBi.length; i2++) {
            yT[i2] = new HashMap<>();
            yU[i2] = new HashMap<>();
            d[] dVarArr = aBi[i2];
            for (d dVar : dVarArr) {
                yT[i2].put(Integer.valueOf(dVar.number), dVar);
                yU[i2].put(dVar.name, dVar);
            }
        }
        yW.put(Integer.valueOf(aBj[0].number), 5);
        yW.put(Integer.valueOf(aBj[1].number), 1);
        yW.put(Integer.valueOf(aBj[2].number), 2);
        yW.put(Integer.valueOf(aBj[3].number), 3);
        yW.put(Integer.valueOf(aBj[4].number), 7);
        yW.put(Integer.valueOf(aBj[5].number), 8);
        AppMethodBeat.o(178752);
    }

    /* access modifiers changed from: package-private */
    public static class e {
        public final long zB;
        public final long zC;

        e(long j2, long j3) {
            AppMethodBeat.i(178711);
            if (j3 == 0) {
                this.zB = 0;
                this.zC = 1;
                AppMethodBeat.o(178711);
                return;
            }
            this.zB = j2;
            this.zC = j3;
            AppMethodBeat.o(178711);
        }

        public final String toString() {
            AppMethodBeat.i(178712);
            String str = this.zB + FilePathGenerator.ANDROID_DIR_SEP + this.zC;
            AppMethodBeat.o(178712);
            return str;
        }

        public final double nv() {
            return ((double) this.zB) / ((double) this.zC);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public final long aBr;
        public final int format;
        public final int zx;
        public final byte[] zy;

        private c(int i2, int i3, byte[] bArr) {
            this(i2, i3, -1, bArr);
        }

        c(int i2, int i3, long j2, byte[] bArr) {
            this.format = i2;
            this.zx = i3;
            this.aBr = j2;
            this.zy = bArr;
        }

        private static c c(int[] iArr, ByteOrder byteOrder) {
            AppMethodBeat.i(178695);
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.yE[3] * 1)]);
            wrap.order(byteOrder);
            for (int i2 = 0; i2 <= 0; i2++) {
                wrap.putShort((short) iArr[0]);
            }
            c cVar = new c(3, 1, wrap.array());
            AppMethodBeat.o(178695);
            return cVar;
        }

        public static c b(int i2, ByteOrder byteOrder) {
            AppMethodBeat.i(178696);
            c c2 = c(new int[]{i2}, byteOrder);
            AppMethodBeat.o(178696);
            return c2;
        }

        private static c b(long[] jArr, ByteOrder byteOrder) {
            AppMethodBeat.i(178697);
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.yE[4] * 1)]);
            wrap.order(byteOrder);
            for (int i2 = 0; i2 <= 0; i2++) {
                wrap.putInt((int) jArr[0]);
            }
            c cVar = new c(4, 1, wrap.array());
            AppMethodBeat.o(178697);
            return cVar;
        }

        public static c b(long j2, ByteOrder byteOrder) {
            AppMethodBeat.i(178698);
            c b2 = b(new long[]{j2}, byteOrder);
            AppMethodBeat.o(178698);
            return b2;
        }

        public static c L(String str) {
            AppMethodBeat.i(178700);
            byte[] bytes = (str + (char) 0).getBytes(a.yX);
            c cVar = new c(2, bytes.length, bytes);
            AppMethodBeat.o(178700);
            return cVar;
        }

        private static c a(e[] eVarArr, ByteOrder byteOrder) {
            AppMethodBeat.i(178701);
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.yE[5] * 1)]);
            wrap.order(byteOrder);
            for (int i2 = 0; i2 <= 0; i2++) {
                e eVar = eVarArr[0];
                wrap.putInt((int) eVar.zB);
                wrap.putInt((int) eVar.zC);
            }
            c cVar = new c(5, 1, wrap.array());
            AppMethodBeat.o(178701);
            return cVar;
        }

        public static c a(e eVar, ByteOrder byteOrder) {
            AppMethodBeat.i(178702);
            c a2 = a(new e[]{eVar}, byteOrder);
            AppMethodBeat.o(178702);
            return a2;
        }

        public final String toString() {
            AppMethodBeat.i(178705);
            String str = "(" + a.yD[this.format] + ", data length:" + this.zy.length + ")";
            AppMethodBeat.o(178705);
            return str;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x0197 A[SYNTHETIC, Splitter:B:113:0x0197] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00a1 A[SYNTHETIC, Splitter:B:47:0x00a1] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(java.nio.ByteOrder r11) {
            /*
            // Method dump skipped, instructions count: 488
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.a.a.a.c.a(java.nio.ByteOrder):java.lang.Object");
        }

        public final double d(ByteOrder byteOrder) {
            AppMethodBeat.i(178707);
            Object a2 = a(byteOrder);
            if (a2 == null) {
                NumberFormatException numberFormatException = new NumberFormatException("NULL can't be converted to a double value");
                AppMethodBeat.o(178707);
                throw numberFormatException;
            } else if (a2 instanceof String) {
                double parseDouble = Double.parseDouble((String) a2);
                AppMethodBeat.o(178707);
                return parseDouble;
            } else if (a2 instanceof long[]) {
                long[] jArr = (long[]) a2;
                if (jArr.length == 1) {
                    double d2 = (double) jArr[0];
                    AppMethodBeat.o(178707);
                    return d2;
                }
                NumberFormatException numberFormatException2 = new NumberFormatException("There are more than one component");
                AppMethodBeat.o(178707);
                throw numberFormatException2;
            } else if (a2 instanceof int[]) {
                int[] iArr = (int[]) a2;
                if (iArr.length == 1) {
                    double d3 = (double) iArr[0];
                    AppMethodBeat.o(178707);
                    return d3;
                }
                NumberFormatException numberFormatException3 = new NumberFormatException("There are more than one component");
                AppMethodBeat.o(178707);
                throw numberFormatException3;
            } else if (a2 instanceof double[]) {
                double[] dArr = (double[]) a2;
                if (dArr.length == 1) {
                    double d4 = dArr[0];
                    AppMethodBeat.o(178707);
                    return d4;
                }
                NumberFormatException numberFormatException4 = new NumberFormatException("There are more than one component");
                AppMethodBeat.o(178707);
                throw numberFormatException4;
            } else if (a2 instanceof e[]) {
                e[] eVarArr = (e[]) a2;
                if (eVarArr.length == 1) {
                    double nv = eVarArr[0].nv();
                    AppMethodBeat.o(178707);
                    return nv;
                }
                NumberFormatException numberFormatException5 = new NumberFormatException("There are more than one component");
                AppMethodBeat.o(178707);
                throw numberFormatException5;
            } else {
                NumberFormatException numberFormatException6 = new NumberFormatException("Couldn't find a double value");
                AppMethodBeat.o(178707);
                throw numberFormatException6;
            }
        }

        public final int b(ByteOrder byteOrder) {
            AppMethodBeat.i(178708);
            Object a2 = a(byteOrder);
            if (a2 == null) {
                NumberFormatException numberFormatException = new NumberFormatException("NULL can't be converted to a integer value");
                AppMethodBeat.o(178708);
                throw numberFormatException;
            } else if (a2 instanceof String) {
                int parseInt = Integer.parseInt((String) a2);
                AppMethodBeat.o(178708);
                return parseInt;
            } else if (a2 instanceof long[]) {
                long[] jArr = (long[]) a2;
                if (jArr.length == 1) {
                    int i2 = (int) jArr[0];
                    AppMethodBeat.o(178708);
                    return i2;
                }
                NumberFormatException numberFormatException2 = new NumberFormatException("There are more than one component");
                AppMethodBeat.o(178708);
                throw numberFormatException2;
            } else if (a2 instanceof int[]) {
                int[] iArr = (int[]) a2;
                if (iArr.length == 1) {
                    int i3 = iArr[0];
                    AppMethodBeat.o(178708);
                    return i3;
                }
                NumberFormatException numberFormatException3 = new NumberFormatException("There are more than one component");
                AppMethodBeat.o(178708);
                throw numberFormatException3;
            } else {
                NumberFormatException numberFormatException4 = new NumberFormatException("Couldn't find a integer value");
                AppMethodBeat.o(178708);
                throw numberFormatException4;
            }
        }

        public final String c(ByteOrder byteOrder) {
            int i2 = 0;
            AppMethodBeat.i(178709);
            Object a2 = a(byteOrder);
            if (a2 == null) {
                AppMethodBeat.o(178709);
                return null;
            } else if (a2 instanceof String) {
                String str = (String) a2;
                AppMethodBeat.o(178709);
                return str;
            } else {
                StringBuilder sb = new StringBuilder();
                if (a2 instanceof long[]) {
                    long[] jArr = (long[]) a2;
                    while (i2 < jArr.length) {
                        sb.append(jArr[i2]);
                        if (i2 + 1 != jArr.length) {
                            sb.append(",");
                        }
                        i2++;
                    }
                    String sb2 = sb.toString();
                    AppMethodBeat.o(178709);
                    return sb2;
                } else if (a2 instanceof int[]) {
                    int[] iArr = (int[]) a2;
                    while (i2 < iArr.length) {
                        sb.append(iArr[i2]);
                        if (i2 + 1 != iArr.length) {
                            sb.append(",");
                        }
                        i2++;
                    }
                    String sb3 = sb.toString();
                    AppMethodBeat.o(178709);
                    return sb3;
                } else if (a2 instanceof double[]) {
                    double[] dArr = (double[]) a2;
                    while (i2 < dArr.length) {
                        sb.append(dArr[i2]);
                        if (i2 + 1 != dArr.length) {
                            sb.append(",");
                        }
                        i2++;
                    }
                    String sb4 = sb.toString();
                    AppMethodBeat.o(178709);
                    return sb4;
                } else if (a2 instanceof e[]) {
                    e[] eVarArr = (e[]) a2;
                    while (i2 < eVarArr.length) {
                        sb.append(eVarArr[i2].zB);
                        sb.append('/');
                        sb.append(eVarArr[i2].zC);
                        if (i2 + 1 != eVarArr.length) {
                            sb.append(",");
                        }
                        i2++;
                    }
                    String sb5 = sb.toString();
                    AppMethodBeat.o(178709);
                    return sb5;
                } else {
                    AppMethodBeat.o(178709);
                    return null;
                }
            }
        }

        public final int size() {
            return a.yE[this.format] * this.zx;
        }
    }

    /* access modifiers changed from: package-private */
    public static class d {
        public final String name;
        public final int number;
        public final int zA;
        public final int zz;

        d(String str, int i2, int i3) {
            this.name = str;
            this.number = i2;
            this.zz = i3;
            this.zA = -1;
        }

        d(String str, int i2) {
            this.name = str;
            this.number = i2;
            this.zz = 3;
            this.zA = 4;
        }

        /* access modifiers changed from: package-private */
        public final boolean am(int i2) {
            if (this.zz == 7 || i2 == 7 || this.zz == i2 || this.zA == i2) {
                return true;
            }
            if ((this.zz == 4 || this.zA == 4) && i2 == 3) {
                return true;
            }
            if ((this.zz == 9 || this.zA == 9) && i2 == 8) {
                return true;
            }
            if ((this.zz == 12 || this.zA == 12) && i2 == 11) {
                return true;
            }
            return false;
        }
    }

    public a(String str) {
        FileInputStream fileInputStream;
        AppMethodBeat.i(178713);
        this.zc = new HashMap[aBi.length];
        this.zd = new HashSet(aBi.length);
        this.ze = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("filename cannot be null");
            AppMethodBeat.o(178713);
            throw nullPointerException;
        } else if (str == null) {
            NullPointerException nullPointerException2 = new NullPointerException("filename cannot be null");
            AppMethodBeat.o(178713);
            throw nullPointerException2;
        } else {
            this.za = null;
            this.yZ = str;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    if (a(fileInputStream.getFD())) {
                        this.aBn = fileInputStream.getFD();
                    } else {
                        this.aBn = null;
                    }
                    b(fileInputStream);
                    closeQuietly(fileInputStream);
                    AppMethodBeat.o(178713);
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(fileInputStream);
                    AppMethodBeat.o(178713);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                closeQuietly(fileInputStream);
                AppMethodBeat.o(178713);
                throw th;
            }
        }
    }

    public a(InputStream inputStream) {
        AppMethodBeat.i(178714);
        this.zc = new HashMap[aBi.length];
        this.zd = new HashSet(aBi.length);
        this.ze = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            NullPointerException nullPointerException = new NullPointerException("inputStream cannot be null");
            AppMethodBeat.o(178714);
            throw nullPointerException;
        }
        this.yZ = null;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.za = (AssetManager.AssetInputStream) inputStream;
            this.aBn = null;
        } else if (!(inputStream instanceof FileInputStream) || !a(((FileInputStream) inputStream).getFD())) {
            this.za = null;
            this.aBn = null;
        } else {
            this.za = null;
            this.aBn = ((FileInputStream) inputStream).getFD();
        }
        b(inputStream);
        AppMethodBeat.o(178714);
    }

    private c J(String str) {
        AppMethodBeat.i(178715);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("tag shouldn't be null");
            AppMethodBeat.o(178715);
            throw nullPointerException;
        }
        if (android.support.e.a.TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = android.support.e.a.TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i2 = 0; i2 < aBi.length; i2++) {
            c cVar = this.zc[i2].get(str);
            if (cVar != null) {
                AppMethodBeat.o(178715);
                return cVar;
            }
        }
        AppMethodBeat.o(178715);
        return null;
    }

    public final String getAttribute(String str) {
        AppMethodBeat.i(178716);
        c J = J(str);
        if (J == null) {
            AppMethodBeat.o(178716);
            return null;
        } else if (!yV.contains(str)) {
            String c2 = J.c(this.ze);
            AppMethodBeat.o(178716);
            return c2;
        } else if (!str.equals(android.support.e.a.TAG_GPS_TIMESTAMP)) {
            try {
                String d2 = Double.toString(J.d(this.ze));
                AppMethodBeat.o(178716);
                return d2;
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(178716);
                return null;
            }
        } else if (J.format == 5 || J.format == 10) {
            e[] eVarArr = (e[]) J.a(this.ze);
            if (eVarArr == null || eVarArr.length != 3) {
                new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(eVarArr));
                AppMethodBeat.o(178716);
                return null;
            }
            String format = String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) eVarArr[0].zB) / ((float) eVarArr[0].zC))), Integer.valueOf((int) (((float) eVarArr[1].zB) / ((float) eVarArr[1].zC))), Integer.valueOf((int) (((float) eVarArr[2].zB) / ((float) eVarArr[2].zC))));
            AppMethodBeat.o(178716);
            return format;
        } else {
            new StringBuilder("GPS Timestamp format is not rational. format=").append(J.format);
            AppMethodBeat.o(178716);
            return null;
        }
    }

    public final int getAttributeInt(String str, int i2) {
        AppMethodBeat.i(178717);
        c J = J(str);
        if (J == null) {
            AppMethodBeat.o(178717);
        } else {
            try {
                i2 = J.b(this.ze);
                AppMethodBeat.o(178717);
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(178717);
            }
        }
        return i2;
    }

    public final double getAttributeDouble(String str, double d2) {
        AppMethodBeat.i(178718);
        c J = J(str);
        if (J == null) {
            AppMethodBeat.o(178718);
        } else {
            try {
                d2 = J.d(this.ze);
                AppMethodBeat.o(178718);
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(178718);
            }
        }
        return d2;
    }

    public final void K(String str) {
        AppMethodBeat.i(188601);
        if (android.support.e.a.TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = android.support.e.a.TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i2 = 0; i2 < aBi.length; i2++) {
            if ((i2 != 4 || this.zf) && yU[i2].get(str) != null) {
                this.zc[i2].remove(str);
            }
        }
        AppMethodBeat.o(188601);
    }

    private void removeAttribute(String str) {
        AppMethodBeat.i(178720);
        for (int i2 = 0; i2 < aBi.length; i2++) {
            this.zc[i2].remove(str);
        }
        AppMethodBeat.o(178720);
    }

    /* JADX WARNING: Removed duplicated region for block: B:155:0x0405  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.io.InputStream r14) {
        /*
        // Method dump skipped, instructions count: 1160
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.a.a.a.b(java.io.InputStream):void");
    }

    private static boolean a(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(178722);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.lseek(fileDescriptor, 0, OsConstants.SEEK_CUR);
                AppMethodBeat.o(178722);
                return true;
            } catch (Exception e2) {
                AppMethodBeat.o(178722);
                return false;
            }
        } else {
            AppMethodBeat.o(178722);
            return false;
        }
    }

    private void nt() {
        AppMethodBeat.i(178723);
        for (int i2 = 0; i2 < this.zc.length; i2++) {
            new StringBuilder("The size of tag group[").append(i2).append("]: ").append(this.zc[i2].size());
            for (Map.Entry<String, c> entry : this.zc[i2].entrySet()) {
                c value = entry.getValue();
                new StringBuilder("tagName: ").append(entry.getKey()).append(", tagType: ").append(value.toString()).append(", tagValue: '").append(value.c(this.ze)).append("'");
            }
        }
        AppMethodBeat.o(178723);
    }

    public final byte[] getThumbnail() {
        AppMethodBeat.i(178725);
        if (this.zk == 6 || this.zk == 7) {
            byte[] thumbnailBytes = getThumbnailBytes();
            AppMethodBeat.o(178725);
            return thumbnailBytes;
        }
        AppMethodBeat.o(178725);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] getThumbnailBytes() {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.a.a.a.getThumbnailBytes():byte[]");
    }

    public final double[] nu() {
        AppMethodBeat.i(178727);
        String attribute = getAttribute(android.support.e.a.TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(android.support.e.a.TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(android.support.e.a.TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(android.support.e.a.TAG_GPS_LONGITUDE_REF);
        if (!(attribute == null || attribute2 == null || attribute3 == null || attribute4 == null)) {
            try {
                double[] dArr = {c(attribute, attribute2), c(attribute3, attribute4)};
                AppMethodBeat.o(178727);
                return dArr;
            } catch (IllegalArgumentException e2) {
                new StringBuilder("Latitude/longitude values are not parsable. ").append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4));
            }
        }
        AppMethodBeat.o(178727);
        return null;
    }

    private static double c(String str, String str2) {
        AppMethodBeat.i(178728);
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split(FilePathGenerator.ANDROID_DIR_SEP, -1);
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            String[] split3 = split[1].split(FilePathGenerator.ANDROID_DIR_SEP, -1);
            double parseDouble2 = Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim());
            String[] split4 = split[2].split(FilePathGenerator.ANDROID_DIR_SEP, -1);
            double parseDouble3 = ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d) + parseDouble + (parseDouble2 / 60.0d);
            if (str2.equals("S") || str2.equals(QLog.TAG_REPORTLEVEL_COLORUSER)) {
                double d2 = -parseDouble3;
                AppMethodBeat.o(178728);
                return d2;
            } else if (str2.equals("N") || str2.equals(QLog.TAG_REPORTLEVEL_USER)) {
                AppMethodBeat.o(178728);
                return parseDouble3;
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                AppMethodBeat.o(178728);
                throw illegalArgumentException;
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e2) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException();
            AppMethodBeat.o(178728);
            throw illegalArgumentException2;
        }
    }

    private static boolean f(byte[] bArr) {
        for (int i2 = 0; i2 < yz.length; i2++) {
            if (bArr[i2] != yz[i2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean g(byte[] bArr) {
        AppMethodBeat.i(178729);
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                AppMethodBeat.o(178729);
                return false;
            }
        }
        AppMethodBeat.o(178729);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean h(byte[] r10) {
        /*
        // Method dump skipped, instructions count: 220
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.a.a.a.h(byte[]):boolean");
    }

    private void a(C0055a aVar, int i2, int i3) {
        AppMethodBeat.i(178731);
        if (DEBUG) {
            new StringBuilder("getJpegAttributes starting with: ").append(aVar);
        }
        aVar.zv = ByteOrder.BIG_ENDIAN;
        aVar.seek((long) i2);
        byte readByte = aVar.readByte();
        if (readByte != -1) {
            IOException iOException = new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
            AppMethodBeat.o(178731);
            throw iOException;
        }
        int i4 = i2 + 1;
        if (aVar.readByte() != -40) {
            IOException iOException2 = new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
            AppMethodBeat.o(178731);
            throw iOException2;
        }
        int i5 = i4 + 1;
        while (true) {
            byte readByte2 = aVar.readByte();
            if (readByte2 != -1) {
                IOException iOException3 = new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
                AppMethodBeat.o(178731);
                throw iOException3;
            }
            int i6 = i5 + 1;
            byte readByte3 = aVar.readByte();
            if (DEBUG) {
                new StringBuilder("Found JPEG segment indicator: ").append(Integer.toHexString(readByte3 & 255));
            }
            int i7 = i6 + 1;
            if (readByte3 == -39 || readByte3 == -38) {
                aVar.zv = this.ze;
                AppMethodBeat.o(178731);
            } else {
                int readUnsignedShort = aVar.readUnsignedShort() - 2;
                int i8 = i7 + 2;
                if (DEBUG) {
                    new StringBuilder("JPEG segment: ").append(Integer.toHexString(readByte3 & 255)).append(" (length: ").append(readUnsignedShort + 2).append(")");
                }
                if (readUnsignedShort < 0) {
                    IOException iOException4 = new IOException("Invalid length");
                    AppMethodBeat.o(178731);
                    throw iOException4;
                }
                switch (readByte3) {
                    case -64:
                    case -63:
                    case -62:
                    case -61:
                    case -59:
                    case -58:
                    case -57:
                    case APPluginConstants.ERROR_JSON_RESULTCODE /*{ENCODED_INT: -55}*/:
                    case APPluginConstants.ERROR_IO_ZipException /*{ENCODED_INT: -54}*/:
                    case APPluginConstants.ERROR_IO_UnsupportedEncodingException /*{ENCODED_INT: -53}*/:
                    case APPluginConstants.ERROR_IO_UnknownHostException /*{ENCODED_INT: -51}*/:
                    case -50:
                    case APPluginConstants.ERROR_IO_SyncFailedException /*{ENCODED_INT: -49}*/:
                        if (aVar.skipBytes(1) == 1) {
                            this.zc[i3].put(android.support.e.a.TAG_IMAGE_LENGTH, c.b((long) aVar.readUnsignedShort(), this.ze));
                            this.zc[i3].put(android.support.e.a.TAG_IMAGE_WIDTH, c.b((long) aVar.readUnsignedShort(), this.ze));
                            readUnsignedShort -= 5;
                            break;
                        } else {
                            IOException iOException5 = new IOException("Invalid SOFx");
                            AppMethodBeat.o(178731);
                            throw iOException5;
                        }
                    case APPluginConstants.ERROR_IO_MalformedChunkCodingException /*{ENCODED_INT: -31}*/:
                        byte[] bArr = new byte[readUnsignedShort];
                        aVar.readFully(bArr);
                        int i9 = i8 + readUnsignedShort;
                        if (c(bArr, yY)) {
                            b(Arrays.copyOfRange(bArr, yY.length, bArr.length), i3);
                            this.zl = (int) ((long) (yY.length + i8));
                            readUnsignedShort = 0;
                            i8 = i9;
                        } else {
                            if (c(bArr, aBm)) {
                                long length = (long) (aBm.length + i8);
                                byte[] copyOfRange = Arrays.copyOfRange(bArr, aBm.length, bArr.length);
                                if (getAttribute("Xmp") == null) {
                                    this.zc[0].put("Xmp", new c(1, copyOfRange.length, length, copyOfRange));
                                }
                            }
                            readUnsignedShort = 0;
                            i8 = i9;
                        }
                    case -2:
                        byte[] bArr2 = new byte[readUnsignedShort];
                        if (aVar.read(bArr2) == readUnsignedShort) {
                            if (getAttribute(android.support.e.a.TAG_USER_COMMENT) != null) {
                                readUnsignedShort = 0;
                                break;
                            } else {
                                this.zc[1].put(android.support.e.a.TAG_USER_COMMENT, c.L(new String(bArr2, yX)));
                                readUnsignedShort = 0;
                                break;
                            }
                        } else {
                            IOException iOException6 = new IOException("Invalid exif");
                            AppMethodBeat.o(178731);
                            throw iOException6;
                        }
                }
                if (readUnsignedShort < 0) {
                    IOException iOException7 = new IOException("Invalid length");
                    AppMethodBeat.o(178731);
                    throw iOException7;
                } else if (aVar.skipBytes(readUnsignedShort) != readUnsignedShort) {
                    IOException iOException8 = new IOException("Invalid JPEG segment");
                    AppMethodBeat.o(178731);
                    throw iOException8;
                } else {
                    i5 = readUnsignedShort + i8;
                }
            }
        }
        aVar.zv = this.ze;
        AppMethodBeat.o(178731);
    }

    private void a(C0055a aVar) {
        c cVar;
        AppMethodBeat.i(178732);
        a(aVar, aVar.available());
        b(aVar, 0);
        d(aVar, 0);
        d(aVar, 5);
        d(aVar, 4);
        dD();
        if (this.zb == 8 && (cVar = this.zc[1].get(android.support.e.a.TAG_MAKER_NOTE)) != null) {
            C0055a aVar2 = new C0055a(cVar.zy);
            aVar2.zv = this.ze;
            aVar2.seek(6);
            b(aVar2, 9);
            c cVar2 = this.zc[9].get(android.support.e.a.TAG_COLOR_SPACE);
            if (cVar2 != null) {
                this.zc[1].put(android.support.e.a.TAG_COLOR_SPACE, cVar2);
            }
        }
        AppMethodBeat.o(178732);
    }

    private void b(C0055a aVar) {
        AppMethodBeat.i(178733);
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        a(aVar, i2, 5);
        aVar.seek((long) i3);
        aVar.zv = ByteOrder.BIG_ENDIAN;
        int readInt = aVar.readInt();
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == aBd.number) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                c b2 = c.b((int) readShort, this.ze);
                c b3 = c.b((int) readShort2, this.ze);
                this.zc[0].put(android.support.e.a.TAG_IMAGE_LENGTH, b2);
                this.zc[0].put(android.support.e.a.TAG_IMAGE_WIDTH, b3);
                if (DEBUG) {
                    new StringBuilder("Updated to length: ").append((int) readShort).append(", width: ").append((int) readShort2);
                }
                AppMethodBeat.o(178733);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
        AppMethodBeat.o(178733);
    }

    public final void b(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(178734);
        if (DEBUG) {
            new StringBuilder("saveJpegAttributes starting with (inputStream: ").append(inputStream).append(", outputStream: ").append(outputStream).append(")");
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        b bVar = new b(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != -1) {
            IOException iOException = new IOException("Invalid marker");
            AppMethodBeat.o(178734);
            throw iOException;
        }
        bVar.writeByte(-1);
        if (dataInputStream.readByte() != -40) {
            IOException iOException2 = new IOException("Invalid marker");
            AppMethodBeat.o(178734);
            throw iOException2;
        }
        bVar.writeByte(-40);
        bVar.writeByte(-1);
        bVar.writeByte(-31);
        a(bVar);
        byte[] bArr = new byte[4096];
        while (dataInputStream.readByte() == -1) {
            byte readByte = dataInputStream.readByte();
            switch (readByte) {
                case APPluginConstants.ERROR_IO_ObjectStreamException_WriteAbortedException /*{ENCODED_INT: -39}*/:
                case APPluginConstants.ERROR_IO_ObjectStreamException_StreamCorruptedException /*{ENCODED_INT: -38}*/:
                    bVar.writeByte(-1);
                    bVar.writeByte(readByte);
                    copy(dataInputStream, bVar);
                    AppMethodBeat.o(178734);
                    return;
                case APPluginConstants.ERROR_IO_MalformedChunkCodingException /*{ENCODED_INT: -31}*/:
                    int readUnsignedShort = dataInputStream.readUnsignedShort() - 2;
                    if (readUnsignedShort >= 0) {
                        byte[] bArr2 = new byte[6];
                        if (readUnsignedShort >= 6) {
                            if (dataInputStream.read(bArr2) == 6) {
                                if (Arrays.equals(bArr2, yY)) {
                                    if (dataInputStream.skipBytes(readUnsignedShort - 6) == readUnsignedShort - 6) {
                                        break;
                                    } else {
                                        IOException iOException3 = new IOException("Invalid length");
                                        AppMethodBeat.o(178734);
                                        throw iOException3;
                                    }
                                }
                            } else {
                                IOException iOException4 = new IOException("Invalid exif");
                                AppMethodBeat.o(178734);
                                throw iOException4;
                            }
                        }
                        bVar.writeByte(-1);
                        bVar.writeByte(readByte);
                        bVar.writeShort((short) (readUnsignedShort + 2));
                        if (readUnsignedShort >= 6) {
                            readUnsignedShort -= 6;
                            bVar.write(bArr2);
                        }
                        while (readUnsignedShort > 0) {
                            int read = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort, 4096));
                            if (read < 0) {
                                break;
                            } else {
                                bVar.write(bArr, 0, read);
                                readUnsignedShort -= read;
                            }
                        }
                        break;
                    } else {
                        IOException iOException5 = new IOException("Invalid length");
                        AppMethodBeat.o(178734);
                        throw iOException5;
                    }
                default:
                    bVar.writeByte(-1);
                    bVar.writeByte(readByte);
                    int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                    bVar.writeShort((short) readUnsignedShort2);
                    int i2 = readUnsignedShort2 - 2;
                    if (i2 >= 0) {
                        while (i2 > 0) {
                            int read2 = dataInputStream.read(bArr, 0, Math.min(i2, 4096));
                            if (read2 < 0) {
                                break;
                            } else {
                                bVar.write(bArr, 0, read2);
                                i2 -= read2;
                            }
                        }
                        break;
                    } else {
                        IOException iOException6 = new IOException("Invalid length");
                        AppMethodBeat.o(178734);
                        throw iOException6;
                    }
            }
        }
        IOException iOException7 = new IOException("Invalid marker");
        AppMethodBeat.o(178734);
        throw iOException7;
    }

    private void b(byte[] bArr, int i2) {
        AppMethodBeat.i(178735);
        C0055a aVar = new C0055a(bArr);
        a(aVar, bArr.length);
        b(aVar, i2);
        AppMethodBeat.o(178735);
    }

    private void dC() {
        AppMethodBeat.i(178736);
        String attribute = getAttribute(android.support.e.a.TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(android.support.e.a.TAG_DATETIME) == null) {
            this.zc[0].put(android.support.e.a.TAG_DATETIME, c.L(attribute));
        }
        if (getAttribute(android.support.e.a.TAG_IMAGE_WIDTH) == null) {
            this.zc[0].put(android.support.e.a.TAG_IMAGE_WIDTH, c.b(0L, this.ze));
        }
        if (getAttribute(android.support.e.a.TAG_IMAGE_LENGTH) == null) {
            this.zc[0].put(android.support.e.a.TAG_IMAGE_LENGTH, c.b(0L, this.ze));
        }
        if (getAttribute(android.support.e.a.TAG_ORIENTATION) == null) {
            this.zc[0].put(android.support.e.a.TAG_ORIENTATION, c.b(0L, this.ze));
        }
        if (getAttribute(android.support.e.a.TAG_LIGHT_SOURCE) == null) {
            this.zc[1].put(android.support.e.a.TAG_LIGHT_SOURCE, c.b(0L, this.ze));
        }
        AppMethodBeat.o(178736);
    }

    private static ByteOrder c(C0055a aVar) {
        AppMethodBeat.i(178737);
        short readShort = aVar.readShort();
        switch (readShort) {
            case 18761:
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                AppMethodBeat.o(178737);
                return byteOrder;
            case 19789:
                ByteOrder byteOrder2 = ByteOrder.BIG_ENDIAN;
                AppMethodBeat.o(178737);
                return byteOrder2;
            default:
                IOException iOException = new IOException("Invalid byte order: " + Integer.toHexString(readShort));
                AppMethodBeat.o(178737);
                throw iOException;
        }
    }

    private void a(C0055a aVar, int i2) {
        AppMethodBeat.i(178738);
        this.ze = c(aVar);
        aVar.zv = this.ze;
        int readUnsignedShort = aVar.readUnsignedShort();
        if (this.zb == 7 || this.zb == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i2) {
                IOException iOException = new IOException("Invalid first Ifd offset: ".concat(String.valueOf(readInt)));
                AppMethodBeat.o(178738);
                throw iOException;
            }
            int i3 = readInt - 8;
            if (i3 <= 0 || aVar.skipBytes(i3) == i3) {
                AppMethodBeat.o(178738);
                return;
            }
            IOException iOException2 = new IOException("Couldn't jump to first Ifd: ".concat(String.valueOf(i3)));
            AppMethodBeat.o(178738);
            throw iOException2;
        }
        IOException iOException3 = new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        AppMethodBeat.o(178738);
        throw iOException3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(androidx.a.a.a.C0055a r19, int r20) {
        /*
        // Method dump skipped, instructions count: 932
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.a.a.a.b(androidx.a.a.a$a, int):void");
    }

    private void c(C0055a aVar, int i2) {
        c cVar;
        AppMethodBeat.i(178740);
        c cVar2 = this.zc[i2].get(android.support.e.a.TAG_IMAGE_LENGTH);
        c cVar3 = this.zc[i2].get(android.support.e.a.TAG_IMAGE_WIDTH);
        if ((cVar2 == null || cVar3 == null) && (cVar = this.zc[i2].get(android.support.e.a.TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            a(aVar, cVar.b(this.ze), i2);
        }
        AppMethodBeat.o(178740);
    }

    private void a(C0055a aVar, HashMap hashMap) {
        AppMethodBeat.i(178741);
        c cVar = (c) hashMap.get(android.support.e.a.TAG_JPEG_INTERCHANGE_FORMAT);
        c cVar2 = (c) hashMap.get(android.support.e.a.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (!(cVar == null || cVar2 == null)) {
            int b2 = cVar.b(this.ze);
            int min = Math.min(cVar2.b(this.ze), aVar.mLength - b2);
            if (this.zb == 4 || this.zb == 9 || this.zb == 10) {
                b2 += this.zl;
            } else if (this.zb == 7) {
                b2 += this.zm;
            }
            if (DEBUG) {
                new StringBuilder("Setting thumbnail attributes with offset: ").append(b2).append(", length: ").append(min);
            }
            if (b2 > 0 && min > 0) {
                this.zf = true;
                this.zg = b2;
                this.zi = min;
                if (this.yZ == null && this.za == null && this.aBn == null) {
                    byte[] bArr = new byte[min];
                    aVar.seek((long) b2);
                    aVar.readFully(bArr);
                    this.zj = bArr;
                }
            }
        }
        AppMethodBeat.o(178741);
    }

    private void b(C0055a aVar, HashMap hashMap) {
        AppMethodBeat.i(178742);
        c cVar = (c) hashMap.get(android.support.e.a.TAG_STRIP_OFFSETS);
        c cVar2 = (c) hashMap.get(android.support.e.a.TAG_STRIP_BYTE_COUNTS);
        if (!(cVar == null || cVar2 == null)) {
            long[] h2 = h(cVar.a(this.ze));
            long[] h3 = h(cVar2.a(this.ze));
            if (h2 == null) {
                AppMethodBeat.o(178742);
                return;
            } else if (h3 == null) {
                AppMethodBeat.o(178742);
                return;
            } else {
                long j2 = 0;
                for (long j3 : h3) {
                    j2 += j3;
                }
                byte[] bArr = new byte[((int) j2)];
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < h2.length; i4++) {
                    int i5 = (int) h2[i4];
                    int i6 = (int) h3[i4];
                    int i7 = i5 - i3;
                    aVar.seek((long) i7);
                    int i8 = i3 + i7;
                    byte[] bArr2 = new byte[i6];
                    aVar.read(bArr2);
                    i3 = i8 + i6;
                    System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
                    i2 += bArr2.length;
                }
                this.zf = true;
                this.zj = bArr;
                this.zi = bArr.length;
            }
        }
        AppMethodBeat.o(178742);
    }

    private boolean a(HashMap hashMap) {
        AppMethodBeat.i(178743);
        c cVar = (c) hashMap.get(android.support.e.a.TAG_IMAGE_LENGTH);
        c cVar2 = (c) hashMap.get(android.support.e.a.TAG_IMAGE_WIDTH);
        if (!(cVar == null || cVar2 == null)) {
            int b2 = cVar.b(this.ze);
            int b3 = cVar2.b(this.ze);
            if (b2 <= 512 && b3 <= 512) {
                AppMethodBeat.o(178743);
                return true;
            }
        }
        AppMethodBeat.o(178743);
        return false;
    }

    private void dD() {
        AppMethodBeat.i(178744);
        t(0, 5);
        t(0, 4);
        t(5, 4);
        c cVar = this.zc[1].get(android.support.e.a.TAG_PIXEL_X_DIMENSION);
        c cVar2 = this.zc[1].get(android.support.e.a.TAG_PIXEL_Y_DIMENSION);
        if (!(cVar == null || cVar2 == null)) {
            this.zc[0].put(android.support.e.a.TAG_IMAGE_WIDTH, cVar);
            this.zc[0].put(android.support.e.a.TAG_IMAGE_LENGTH, cVar2);
        }
        if (this.zc[4].isEmpty() && a(this.zc[5])) {
            this.zc[4] = this.zc[5];
            this.zc[5] = new HashMap<>();
        }
        a(this.zc[4]);
        AppMethodBeat.o(178744);
    }

    private void d(C0055a aVar, int i2) {
        c b2;
        c b3;
        AppMethodBeat.i(178745);
        c cVar = this.zc[i2].get(android.support.e.a.TAG_DEFAULT_CROP_SIZE);
        c cVar2 = this.zc[i2].get(android.support.e.a.TAG_RW2_SENSOR_TOP_BORDER);
        c cVar3 = this.zc[i2].get(android.support.e.a.TAG_RW2_SENSOR_LEFT_BORDER);
        c cVar4 = this.zc[i2].get(android.support.e.a.TAG_RW2_SENSOR_BOTTOM_BORDER);
        c cVar5 = this.zc[i2].get(android.support.e.a.TAG_RW2_SENSOR_RIGHT_BORDER);
        if (cVar != null) {
            if (cVar.format == 5) {
                e[] eVarArr = (e[]) cVar.a(this.ze);
                if (eVarArr == null || eVarArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(eVarArr));
                    AppMethodBeat.o(178745);
                    return;
                }
                b2 = c.a(eVarArr[0], this.ze);
                b3 = c.a(eVarArr[1], this.ze);
            } else {
                int[] iArr = (int[]) cVar.a(this.ze);
                if (iArr == null || iArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(iArr));
                    AppMethodBeat.o(178745);
                    return;
                }
                b2 = c.b(iArr[0], this.ze);
                b3 = c.b(iArr[1], this.ze);
            }
            this.zc[i2].put(android.support.e.a.TAG_IMAGE_WIDTH, b2);
            this.zc[i2].put(android.support.e.a.TAG_IMAGE_LENGTH, b3);
            AppMethodBeat.o(178745);
        } else if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
            c(aVar, i2);
            AppMethodBeat.o(178745);
        } else {
            int b4 = cVar2.b(this.ze);
            int b5 = cVar4.b(this.ze);
            int b6 = cVar5.b(this.ze);
            int b7 = cVar3.b(this.ze);
            if (b5 > b4 && b6 > b7) {
                int i3 = b5 - b4;
                c b8 = c.b(i3, this.ze);
                c b9 = c.b(b6 - b7, this.ze);
                this.zc[i2].put(android.support.e.a.TAG_IMAGE_LENGTH, b8);
                this.zc[i2].put(android.support.e.a.TAG_IMAGE_WIDTH, b9);
            }
            AppMethodBeat.o(178745);
        }
    }

    private int a(b bVar) {
        int i2;
        AppMethodBeat.i(178746);
        int[] iArr = new int[aBi.length];
        int[] iArr2 = new int[aBi.length];
        for (d dVar : aBj) {
            removeAttribute(dVar.name);
        }
        removeAttribute(aBk.name);
        removeAttribute(aBl.name);
        for (int i3 = 0; i3 < aBi.length; i3++) {
            for (Object obj : this.zc[i3].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.zc[i3].remove(entry.getKey());
                }
            }
        }
        if (!this.zc[1].isEmpty()) {
            this.zc[0].put(aBj[1].name, c.b(0L, this.ze));
        }
        if (!this.zc[2].isEmpty()) {
            this.zc[0].put(aBj[2].name, c.b(0L, this.ze));
        }
        if (!this.zc[3].isEmpty()) {
            this.zc[1].put(aBj[3].name, c.b(0L, this.ze));
        }
        if (this.zf) {
            this.zc[4].put(aBk.name, c.b(0L, this.ze));
            this.zc[4].put(aBl.name, c.b((long) this.zi, this.ze));
        }
        for (int i4 = 0; i4 < aBi.length; i4++) {
            int i5 = 0;
            for (Map.Entry<String, c> entry2 : this.zc[i4].entrySet()) {
                int size = entry2.getValue().size();
                if (size > 4) {
                    i2 = size + i5;
                } else {
                    i2 = i5;
                }
                i5 = i2;
            }
            iArr2[i4] = iArr2[i4] + i5;
        }
        int i6 = 8;
        for (int i7 = 0; i7 < aBi.length; i7++) {
            if (!this.zc[i7].isEmpty()) {
                iArr[i7] = i6;
                i6 += (this.zc[i7].size() * 12) + 2 + 4 + iArr2[i7];
            }
        }
        if (this.zf) {
            this.zc[4].put(aBk.name, c.b((long) i6, this.ze));
            this.zg = i6 + 6;
            i6 += this.zi;
        }
        int i8 = i6 + 8;
        if (DEBUG) {
            for (int i9 = 0; i9 < aBi.length; i9++) {
                String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d", Integer.valueOf(i9), Integer.valueOf(iArr[i9]), Integer.valueOf(this.zc[i9].size()), Integer.valueOf(iArr2[i9]));
            }
        }
        if (!this.zc[1].isEmpty()) {
            this.zc[0].put(aBj[1].name, c.b((long) iArr[1], this.ze));
        }
        if (!this.zc[2].isEmpty()) {
            this.zc[0].put(aBj[2].name, c.b((long) iArr[2], this.ze));
        }
        if (!this.zc[3].isEmpty()) {
            this.zc[1].put(aBj[3].name, c.b((long) iArr[3], this.ze));
        }
        bVar.writeShort((short) i8);
        bVar.write(yY);
        bVar.writeShort(this.ze == ByteOrder.BIG_ENDIAN ? (short) 19789 : 18761);
        bVar.zv = this.ze;
        bVar.writeShort(42);
        bVar.writeInt(8);
        for (int i10 = 0; i10 < aBi.length; i10++) {
            if (!this.zc[i10].isEmpty()) {
                bVar.writeShort((short) this.zc[i10].size());
                int size2 = iArr[i10] + 2 + (this.zc[i10].size() * 12) + 4;
                for (Map.Entry<String, c> entry3 : this.zc[i10].entrySet()) {
                    int i11 = yU[i10].get(entry3.getKey()).number;
                    c value = entry3.getValue();
                    int size3 = value.size();
                    bVar.writeShort((short) i11);
                    bVar.writeShort((short) value.format);
                    bVar.writeInt(value.zx);
                    if (size3 > 4) {
                        bVar.writeInt((int) ((long) size2));
                        size2 += size3;
                    } else {
                        bVar.write(value.zy);
                        if (size3 < 4) {
                            for (int i12 = size3; i12 < 4; i12++) {
                                bVar.writeByte(0);
                            }
                        }
                    }
                }
                if (i10 != 0 || this.zc[4].isEmpty()) {
                    bVar.writeInt(0);
                } else {
                    bVar.writeInt((int) ((long) iArr[4]));
                }
                for (Map.Entry<String, c> entry4 : this.zc[i10].entrySet()) {
                    c value2 = entry4.getValue();
                    if (value2.zy.length > 4) {
                        bVar.write(value2.zy, 0, value2.zy.length);
                    }
                }
            }
        }
        if (this.zf) {
            bVar.write(getThumbnailBytes());
        }
        bVar.zv = ByteOrder.BIG_ENDIAN;
        AppMethodBeat.o(178746);
        return i8;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.a.a.a$a  reason: collision with other inner class name */
    public static class C0055a extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        final int mLength;
        int mPosition;
        private DataInputStream zu;
        ByteOrder zv;

        public C0055a(InputStream inputStream) {
            AppMethodBeat.i(178669);
            this.zv = ByteOrder.BIG_ENDIAN;
            this.zu = new DataInputStream(inputStream);
            this.mLength = this.zu.available();
            this.mPosition = 0;
            this.zu.mark(this.mLength);
            AppMethodBeat.o(178669);
        }

        public C0055a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
            AppMethodBeat.i(178670);
            AppMethodBeat.o(178670);
        }

        public final void seek(long j2) {
            AppMethodBeat.i(178671);
            if (((long) this.mPosition) > j2) {
                this.mPosition = 0;
                this.zu.reset();
                this.zu.mark(this.mLength);
            } else {
                j2 -= (long) this.mPosition;
            }
            if (skipBytes((int) j2) != ((int) j2)) {
                IOException iOException = new IOException("Couldn't seek up to the byteCount");
                AppMethodBeat.o(178671);
                throw iOException;
            }
            AppMethodBeat.o(178671);
        }

        @Override // java.io.InputStream
        public final int available() {
            AppMethodBeat.i(178672);
            int available = this.zu.available();
            AppMethodBeat.o(178672);
            return available;
        }

        @Override // java.io.InputStream
        public final int read() {
            AppMethodBeat.i(178673);
            this.mPosition++;
            int read = this.zu.read();
            AppMethodBeat.o(178673);
            return read;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(178674);
            int read = this.zu.read(bArr, i2, i3);
            this.mPosition += read;
            AppMethodBeat.o(178674);
            return read;
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() {
            AppMethodBeat.i(178675);
            this.mPosition++;
            int readUnsignedByte = this.zu.readUnsignedByte();
            AppMethodBeat.o(178675);
            return readUnsignedByte;
        }

        @Override // java.io.DataInput
        public final String readLine() {
            return null;
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() {
            AppMethodBeat.i(178676);
            this.mPosition++;
            boolean readBoolean = this.zu.readBoolean();
            AppMethodBeat.o(178676);
            return readBoolean;
        }

        @Override // java.io.DataInput
        public final char readChar() {
            AppMethodBeat.i(178677);
            this.mPosition += 2;
            char readChar = this.zu.readChar();
            AppMethodBeat.o(178677);
            return readChar;
        }

        @Override // java.io.DataInput
        public final String readUTF() {
            AppMethodBeat.i(178678);
            this.mPosition += 2;
            String readUTF = this.zu.readUTF();
            AppMethodBeat.o(178678);
            return readUTF;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(178679);
            this.mPosition += i3;
            if (this.mPosition > this.mLength) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(178679);
                throw eOFException;
            } else if (this.zu.read(bArr, i2, i3) != i3) {
                IOException iOException = new IOException("Couldn't read up to the length of buffer");
                AppMethodBeat.o(178679);
                throw iOException;
            } else {
                AppMethodBeat.o(178679);
            }
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr) {
            AppMethodBeat.i(178680);
            this.mPosition += bArr.length;
            if (this.mPosition > this.mLength) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(178680);
                throw eOFException;
            } else if (this.zu.read(bArr, 0, bArr.length) != bArr.length) {
                IOException iOException = new IOException("Couldn't read up to the length of buffer");
                AppMethodBeat.o(178680);
                throw iOException;
            } else {
                AppMethodBeat.o(178680);
            }
        }

        @Override // java.io.DataInput
        public final byte readByte() {
            AppMethodBeat.i(178681);
            this.mPosition++;
            if (this.mPosition > this.mLength) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(178681);
                throw eOFException;
            }
            int read = this.zu.read();
            if (read < 0) {
                EOFException eOFException2 = new EOFException();
                AppMethodBeat.o(178681);
                throw eOFException2;
            }
            byte b2 = (byte) read;
            AppMethodBeat.o(178681);
            return b2;
        }

        @Override // java.io.DataInput
        public final short readShort() {
            AppMethodBeat.i(178682);
            this.mPosition += 2;
            if (this.mPosition > this.mLength) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(178682);
                throw eOFException;
            }
            int read = this.zu.read();
            int read2 = this.zu.read();
            if ((read | read2) < 0) {
                EOFException eOFException2 = new EOFException();
                AppMethodBeat.o(178682);
                throw eOFException2;
            } else if (this.zv == LITTLE_ENDIAN) {
                short s = (short) (read + (read2 << 8));
                AppMethodBeat.o(178682);
                return s;
            } else if (this.zv == BIG_ENDIAN) {
                short s2 = (short) ((read << 8) + read2);
                AppMethodBeat.o(178682);
                return s2;
            } else {
                IOException iOException = new IOException("Invalid byte order: " + this.zv);
                AppMethodBeat.o(178682);
                throw iOException;
            }
        }

        @Override // java.io.DataInput
        public final int readInt() {
            AppMethodBeat.i(178683);
            this.mPosition += 4;
            if (this.mPosition > this.mLength) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(178683);
                throw eOFException;
            }
            int read = this.zu.read();
            int read2 = this.zu.read();
            int read3 = this.zu.read();
            int read4 = this.zu.read();
            if ((read | read2 | read3 | read4) < 0) {
                EOFException eOFException2 = new EOFException();
                AppMethodBeat.o(178683);
                throw eOFException2;
            } else if (this.zv == LITTLE_ENDIAN) {
                int i2 = read + (read2 << 8) + (read3 << 16) + (read4 << 24);
                AppMethodBeat.o(178683);
                return i2;
            } else if (this.zv == BIG_ENDIAN) {
                int i3 = (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                AppMethodBeat.o(178683);
                return i3;
            } else {
                IOException iOException = new IOException("Invalid byte order: " + this.zv);
                AppMethodBeat.o(178683);
                throw iOException;
            }
        }

        @Override // java.io.DataInput
        public final int skipBytes(int i2) {
            AppMethodBeat.i(178684);
            int min = Math.min(i2, this.mLength - this.mPosition);
            int i3 = 0;
            while (i3 < min) {
                i3 += this.zu.skipBytes(min - i3);
            }
            this.mPosition += i3;
            AppMethodBeat.o(178684);
            return i3;
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() {
            AppMethodBeat.i(178685);
            this.mPosition += 2;
            if (this.mPosition > this.mLength) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(178685);
                throw eOFException;
            }
            int read = this.zu.read();
            int read2 = this.zu.read();
            if ((read | read2) < 0) {
                EOFException eOFException2 = new EOFException();
                AppMethodBeat.o(178685);
                throw eOFException2;
            } else if (this.zv == LITTLE_ENDIAN) {
                int i2 = read + (read2 << 8);
                AppMethodBeat.o(178685);
                return i2;
            } else if (this.zv == BIG_ENDIAN) {
                int i3 = (read << 8) + read2;
                AppMethodBeat.o(178685);
                return i3;
            } else {
                IOException iOException = new IOException("Invalid byte order: " + this.zv);
                AppMethodBeat.o(178685);
                throw iOException;
            }
        }

        public final long dE() {
            AppMethodBeat.i(178686);
            long readInt = ((long) readInt()) & Util.MAX_32BIT_VALUE;
            AppMethodBeat.o(178686);
            return readInt;
        }

        @Override // java.io.DataInput
        public final long readLong() {
            AppMethodBeat.i(178687);
            this.mPosition += 8;
            if (this.mPosition > this.mLength) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(178687);
                throw eOFException;
            }
            int read = this.zu.read();
            int read2 = this.zu.read();
            int read3 = this.zu.read();
            int read4 = this.zu.read();
            int read5 = this.zu.read();
            int read6 = this.zu.read();
            int read7 = this.zu.read();
            int read8 = this.zu.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                EOFException eOFException2 = new EOFException();
                AppMethodBeat.o(178687);
                throw eOFException2;
            } else if (this.zv == LITTLE_ENDIAN) {
                long j2 = ((long) read3) << 16;
                long j3 = (long) read;
                long j4 = j3 + j2 + (((long) read5) << 32) + (((long) read7) << 48) + (((long) read8) << 56) + (((long) read6) << 40) + (((long) read4) << 24) + (((long) read2) << 8);
                AppMethodBeat.o(178687);
                return j4;
            } else if (this.zv == BIG_ENDIAN) {
                long j5 = (((long) read2) << 48) + (((long) read) << 56) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                AppMethodBeat.o(178687);
                return j5;
            } else {
                IOException iOException = new IOException("Invalid byte order: " + this.zv);
                AppMethodBeat.o(178687);
                throw iOException;
            }
        }

        @Override // java.io.DataInput
        public final float readFloat() {
            AppMethodBeat.i(178688);
            float intBitsToFloat = Float.intBitsToFloat(readInt());
            AppMethodBeat.o(178688);
            return intBitsToFloat;
        }

        @Override // java.io.DataInput
        public final double readDouble() {
            AppMethodBeat.i(178689);
            double longBitsToDouble = Double.longBitsToDouble(readLong());
            AppMethodBeat.o(178689);
            return longBitsToDouble;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends FilterOutputStream {
        ByteOrder zv;
        private final OutputStream zw;

        public b(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.zw = outputStream;
            this.zv = byteOrder;
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public final void write(byte[] bArr) {
            AppMethodBeat.i(178690);
            this.zw.write(bArr);
            AppMethodBeat.o(178690);
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public final void write(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(178691);
            this.zw.write(bArr, i2, i3);
            AppMethodBeat.o(178691);
        }

        public final void writeByte(int i2) {
            AppMethodBeat.i(178692);
            this.zw.write(i2);
            AppMethodBeat.o(178692);
        }

        public final void writeShort(short s) {
            AppMethodBeat.i(178693);
            if (this.zv == ByteOrder.LITTLE_ENDIAN) {
                this.zw.write((s >>> 0) & 255);
                this.zw.write((s >>> 8) & 255);
                AppMethodBeat.o(178693);
                return;
            }
            if (this.zv == ByteOrder.BIG_ENDIAN) {
                this.zw.write((s >>> 8) & 255);
                this.zw.write((s >>> 0) & 255);
            }
            AppMethodBeat.o(178693);
        }

        public final void writeInt(int i2) {
            AppMethodBeat.i(178694);
            if (this.zv == ByteOrder.LITTLE_ENDIAN) {
                this.zw.write((i2 >>> 0) & 255);
                this.zw.write((i2 >>> 8) & 255);
                this.zw.write((i2 >>> 16) & 255);
                this.zw.write((i2 >>> 24) & 255);
                AppMethodBeat.o(178694);
                return;
            }
            if (this.zv == ByteOrder.BIG_ENDIAN) {
                this.zw.write((i2 >>> 24) & 255);
                this.zw.write((i2 >>> 16) & 255);
                this.zw.write((i2 >>> 8) & 255);
                this.zw.write((i2 >>> 0) & 255);
            }
            AppMethodBeat.o(178694);
        }
    }

    private void t(int i2, int i3) {
        AppMethodBeat.i(178748);
        if (this.zc[i2].isEmpty() || this.zc[i3].isEmpty()) {
            AppMethodBeat.o(178748);
            return;
        }
        c cVar = this.zc[i2].get(android.support.e.a.TAG_IMAGE_LENGTH);
        c cVar2 = this.zc[i2].get(android.support.e.a.TAG_IMAGE_WIDTH);
        c cVar3 = this.zc[i3].get(android.support.e.a.TAG_IMAGE_LENGTH);
        c cVar4 = this.zc[i3].get(android.support.e.a.TAG_IMAGE_WIDTH);
        if (cVar == null || cVar2 == null) {
            if (DEBUG) {
                AppMethodBeat.o(178748);
                return;
            }
        } else if (cVar3 != null && cVar4 != null) {
            int b2 = cVar.b(this.ze);
            int b3 = cVar2.b(this.ze);
            int b4 = cVar3.b(this.ze);
            int b5 = cVar4.b(this.ze);
            if (b2 < b4 && b3 < b5) {
                HashMap<String, c> hashMap = this.zc[i2];
                HashMap<String, c>[] hashMapArr = this.zc;
                hashMapArr[i2] = hashMapArr[i3];
                this.zc[i3] = hashMap;
            }
        } else if (DEBUG) {
            AppMethodBeat.o(178748);
            return;
        }
        AppMethodBeat.o(178748);
    }

    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(178749);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(178749);
                return;
            } catch (RuntimeException e2) {
                AppMethodBeat.o(178749);
                throw e2;
            } catch (Exception e3) {
            }
        }
        AppMethodBeat.o(178749);
    }

    private static void b(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(178750);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.close(fileDescriptor);
                AppMethodBeat.o(178750);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(178750);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(178751);
        byte[] bArr = new byte[8192];
        int i2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                i2 += read;
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.o(178751);
                return i2;
            }
        }
    }

    private static long[] h(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = (long) iArr[i2];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    private static boolean c(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
