package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.TXLiveConstants;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Exif {
    public static final int PARSE_EXIF_ERROR_CORRUPT = 1985;
    public static final int PARSE_EXIF_ERROR_NO_EXIF = 1983;
    public static final int PARSE_EXIF_ERROR_NO_JPEG = 1982;
    public static final int PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN = 1984;
    public static final int PARSE_EXIF_SUCCESS = 0;
    private static final String TAG = "MicroMsg.Exif";
    public double altitude = 0.0d;
    public short bitsPerSample;
    public String copyright;
    public String dateTime;
    public String dateTimeDigitized;
    public String dateTimeOriginal;
    public double exposureBiasValue;
    public double exposureTime;
    public double fNumber;
    public int fileSource;
    public byte flash;
    public double focalLength;
    public short focalLengthIn35mm;
    public String imageDescription;
    public int imageHeight;
    public int imageWidth;
    public short isoSpeedRatings;
    public double latitude = -1.0d;
    public double longitude = -1.0d;
    private androidx.a.a.a mExif;
    public String make;
    public short meteringMode;
    public String model;
    public short orientation;
    public int sceneType;
    public double shutterSpeedValue;
    public String software;
    public String subSecTimeOriginal;
    public double subjectDistance;
    public String yCbCrSubSampling;

    public int parseFromFile(String str) {
        AppMethodBeat.i(155892);
        InputStream inputStream = null;
        try {
            inputStream = s.openRead(str);
            this.mExif = new androidx.a.a.a(inputStream);
            readExifFromInterface();
            Util.qualityClose(inputStream);
            AppMethodBeat.o(155892);
            return 0;
        } catch (Exception e2) {
            Log.w(TAG, "Cannot read EXIF from file '%s': %s", str, e2.getMessage());
            Util.qualityClose(inputStream);
            AppMethodBeat.o(155892);
            return -1;
        } catch (Throwable th) {
            Util.qualityClose(inputStream);
            AppMethodBeat.o(155892);
            throw th;
        }
    }

    public int parseFromStream(InputStream inputStream) {
        AppMethodBeat.i(155893);
        try {
            this.mExif = new androidx.a.a.a(inputStream);
            readExifFromInterface();
            AppMethodBeat.o(155893);
            return 0;
        } catch (Exception e2) {
            Log.w(TAG, "Cannot read EXIF from stream '%s': %s", inputStream, e2.getMessage());
            AppMethodBeat.o(155893);
            return -1;
        }
    }

    public int parseFrom(byte[] bArr) {
        AppMethodBeat.i(155894);
        int parseFromStream = parseFromStream(new ByteArrayInputStream(bArr));
        AppMethodBeat.o(155894);
        return parseFromStream;
    }

    public int parseFrom(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(155895);
        int parseFromStream = parseFromStream(new ByteArrayInputStream(bArr, i2, i3));
        AppMethodBeat.o(155895);
        return parseFromStream;
    }

    private void readExifFromInterface() {
        double d2;
        int i2 = -1;
        AppMethodBeat.i(155896);
        if (this.mExif == null) {
            AppMethodBeat.o(155896);
            return;
        }
        this.imageDescription = this.mExif.getAttribute(android.support.e.a.TAG_IMAGE_DESCRIPTION);
        this.make = this.mExif.getAttribute(android.support.e.a.TAG_MAKE);
        this.model = this.mExif.getAttribute(android.support.e.a.TAG_MODEL);
        this.orientation = (short) this.mExif.getAttributeInt(android.support.e.a.TAG_ORIENTATION, 0);
        this.bitsPerSample = (short) this.mExif.getAttributeInt(android.support.e.a.TAG_BITS_PER_SAMPLE, 0);
        this.software = this.mExif.getAttribute(android.support.e.a.TAG_SOFTWARE);
        this.dateTime = this.mExif.getAttribute(android.support.e.a.TAG_DATETIME);
        this.dateTimeOriginal = this.mExif.getAttribute(android.support.e.a.TAG_DATETIME_ORIGINAL);
        this.dateTimeDigitized = this.mExif.getAttribute(android.support.e.a.TAG_DATETIME_DIGITIZED);
        this.subSecTimeOriginal = this.mExif.getAttribute(android.support.e.a.TAG_SUBSEC_TIME_ORIGINAL);
        this.copyright = this.mExif.getAttribute(android.support.e.a.TAG_COPYRIGHT);
        this.exposureTime = this.mExif.getAttributeDouble(android.support.e.a.TAG_EXPOSURE_TIME, 0.0d);
        this.fNumber = this.mExif.getAttributeDouble(android.support.e.a.TAG_F_NUMBER, 0.0d);
        this.isoSpeedRatings = (short) this.mExif.getAttributeInt(android.support.e.a.TAG_ISO_SPEED_RATINGS, 0);
        this.flash = (byte) this.mExif.getAttributeInt(android.support.e.a.TAG_FLASH, 0);
        this.imageWidth = this.mExif.getAttributeInt(android.support.e.a.TAG_IMAGE_WIDTH, 0);
        this.imageHeight = this.mExif.getAttributeInt(android.support.e.a.TAG_IMAGE_LENGTH, 0);
        this.fileSource = this.mExif.getAttributeInt(android.support.e.a.TAG_FILE_SOURCE, 0);
        this.sceneType = this.mExif.getAttributeInt(android.support.e.a.TAG_SCENE_TYPE, 0);
        double[] nu = this.mExif.nu();
        if (nu != null) {
            this.latitude = nu[0];
            this.longitude = nu[1];
        }
        androidx.a.a.a aVar = this.mExif;
        double attributeDouble = aVar.getAttributeDouble(android.support.e.a.TAG_GPS_ALTITUDE, -1.0d);
        int attributeInt = aVar.getAttributeInt(android.support.e.a.TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            d2 = 0.0d;
        } else {
            if (attributeInt != 1) {
                i2 = 1;
            }
            d2 = ((double) i2) * attributeDouble;
        }
        this.altitude = d2;
        AppMethodBeat.o(155896);
    }

    public static class a {
        public double altitude;
        public double latitude;
        public double longitude;

        public a(double d2, double d3, double d4) {
            this.latitude = d2;
            this.longitude = d3;
            this.altitude = d4;
        }
    }

    public int getOrientationInDegree() {
        AppMethodBeat.i(155897);
        if (this.mExif != null) {
            switch (this.mExif.getAttributeInt(android.support.e.a.TAG_ORIENTATION, 1)) {
                case 3:
                case 4:
                    AppMethodBeat.o(155897);
                    return TXLiveConstants.RENDER_ROTATION_180;
                case 5:
                case 8:
                    AppMethodBeat.o(155897);
                    return 270;
                case 6:
                case 7:
                    AppMethodBeat.o(155897);
                    return 90;
                default:
                    AppMethodBeat.o(155897);
                    return 0;
            }
        } else {
            switch (this.orientation) {
                case 3:
                    AppMethodBeat.o(155897);
                    return TXLiveConstants.RENDER_ROTATION_180;
                case 4:
                case 5:
                case 7:
                default:
                    AppMethodBeat.o(155897);
                    return 0;
                case 6:
                    AppMethodBeat.o(155897);
                    return 90;
                case 8:
                    AppMethodBeat.o(155897);
                    return 270;
            }
        }
    }

    public a getLocation() {
        AppMethodBeat.i(155898);
        if (this.latitude < 0.0d || this.longitude < 0.0d) {
            AppMethodBeat.o(155898);
            return null;
        }
        a aVar = new a(this.latitude, this.longitude, this.altitude);
        AppMethodBeat.o(155898);
        return aVar;
    }

    public long getUxtimeDatatimeOriginal() {
        AppMethodBeat.i(155899);
        try {
            if (this.dateTimeOriginal == null) {
                AppMethodBeat.o(155899);
                return 0;
            }
            long time = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(this.dateTimeOriginal).getTime() / 1000;
            AppMethodBeat.o(155899);
            return time;
        } catch (ParseException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(155899);
            return 0;
        }
    }

    public static Exif fromFile(String str) {
        AppMethodBeat.i(155900);
        Exif exif = new Exif();
        exif.parseFromFile(str);
        AppMethodBeat.o(155900);
        return exif;
    }

    public static Exif fromStream(InputStream inputStream) {
        AppMethodBeat.i(155901);
        Exif exif = new Exif();
        exif.parseFromStream(inputStream);
        AppMethodBeat.o(155901);
        return exif;
    }
}
