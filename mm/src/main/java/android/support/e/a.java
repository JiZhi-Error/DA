package android.support.e;

import android.content.res.AssetManager;
import android.util.Pair;
import com.pay.tool.APPluginConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.appbrand.jsapi.ct;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.ak;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    private static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final d TAG_RAF_IMAGE_SIZE = new d(TAG_STRIP_OFFSETS, 273, 3);
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    private static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    private static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
    private static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final byte[] yA = {79, 76, 89, 77, 80, 0};
    private static final byte[] yB = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static SimpleDateFormat yC;
    static final String[] yD = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    static final int[] yE = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] yF = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final d[] yG = {new d(TAG_NEW_SUBFILE_TYPE, 254, 4), new d(TAG_SUBFILE_TYPE, 255, 4), new d(TAG_IMAGE_WIDTH, 256), new d(TAG_IMAGE_LENGTH, CdnLogic.kAppTypeFestivalImage), new d(TAG_BITS_PER_SAMPLE, CdnLogic.kAppTypeFestivalVideo, 3), new d(TAG_COMPRESSION, 259, 3), new d(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new d(TAG_IMAGE_DESCRIPTION, 270, 2), new d(TAG_MAKE, a.C0691a.CTRL_INDEX, 2), new d(TAG_MODEL, 272, 2), new d(TAG_STRIP_OFFSETS, 273), new d(TAG_ORIENTATION, a.C0693a.CTRL_INDEX, 3), new d(TAG_SAMPLES_PER_PIXEL, 277, 3), new d(TAG_ROWS_PER_STRIP, 278), new d(TAG_STRIP_BYTE_COUNTS, 279), new d(TAG_X_RESOLUTION, 282, 5), new d(TAG_Y_RESOLUTION, ct.CTRL_INDEX, 5), new d(TAG_PLANAR_CONFIGURATION, ak.CTRL_INDEX, 3), new d(TAG_RESOLUTION_UNIT, 296, 3), new d(TAG_TRANSFER_FUNCTION, 301, 3), new d(TAG_SOFTWARE, 305, 2), new d(TAG_DATETIME, TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, 2), new d(TAG_ARTIST, com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, 2), new d(TAG_WHITE_POINT, 318, 5), new d(TAG_PRIMARY_CHROMATICITIES, TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 5), new d(TAG_SUB_IFD_POINTER, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4), new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new d(TAG_Y_CB_CR_COEFFICIENTS, f.CTRL_INDEX, 5), new d(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new d(TAG_Y_CB_CR_POSITIONING, 531, 3), new d(TAG_REFERENCE_BLACK_WHITE, com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX, 5), new d(TAG_COPYRIGHT, 33432, 2), new d(TAG_EXIF_IFD_POINTER, 34665, 4), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new d(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new d(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new d(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new d(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new d(TAG_RW2_ISO, 23, 3), new d(TAG_RW2_JPG_FROM_RAW, 46, 7)};
    private static final d[] yH = {new d(TAG_EXPOSURE_TIME, 33434, 5), new d(TAG_F_NUMBER, 33437, 5), new d(TAG_EXPOSURE_PROGRAM, 34850, 3), new d(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new d(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new d(TAG_OECF, 34856, 7), new d(TAG_EXIF_VERSION, 36864, 2), new d(TAG_DATETIME_ORIGINAL, 36867, 2), new d(TAG_DATETIME_DIGITIZED, 36868, 2), new d(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new d(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new d(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new d(TAG_APERTURE_VALUE, 37378, 5), new d(TAG_BRIGHTNESS_VALUE, 37379, 10), new d(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new d(TAG_MAX_APERTURE_VALUE, 37381, 5), new d(TAG_SUBJECT_DISTANCE, 37382, 5), new d(TAG_METERING_MODE, 37383, 3), new d(TAG_LIGHT_SOURCE, 37384, 3), new d(TAG_FLASH, 37385, 3), new d(TAG_FOCAL_LENGTH, 37386, 5), new d(TAG_SUBJECT_AREA, 37396, 3), new d(TAG_MAKER_NOTE, 37500, 7), new d(TAG_USER_COMMENT, 37510, 7), new d(TAG_SUBSEC_TIME, 37520, 2), new d(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new d(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new d(TAG_FLASHPIX_VERSION, 40960, 7), new d(TAG_COLOR_SPACE, 40961, 3), new d(TAG_PIXEL_X_DIMENSION, 40962), new d(TAG_PIXEL_Y_DIMENSION, 40963), new d(TAG_RELATED_SOUND_FILE, 40964, 2), new d(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new d(TAG_FLASH_ENERGY, 41483, 5), new d(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new d(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new d(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new d(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new d(TAG_SUBJECT_LOCATION, 41492, 3), new d(TAG_EXPOSURE_INDEX, 41493, 5), new d(TAG_SENSING_METHOD, 41495, 3), new d(TAG_FILE_SOURCE, 41728, 7), new d(TAG_SCENE_TYPE, 41729, 7), new d(TAG_CFA_PATTERN, 41730, 7), new d(TAG_CUSTOM_RENDERED, 41985, 3), new d(TAG_EXPOSURE_MODE, 41986, 3), new d(TAG_WHITE_BALANCE, 41987, 3), new d(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new d(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new d(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new d(TAG_GAIN_CONTROL, 41991, 3), new d(TAG_CONTRAST, 41992, 3), new d(TAG_SATURATION, 41993, 3), new d(TAG_SHARPNESS, 41994, 3), new d(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new d(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new d(TAG_IMAGE_UNIQUE_ID, 42016, 2), new d(TAG_DNG_VERSION, 50706, 1), new d(TAG_DEFAULT_CROP_SIZE, 50720)};
    private static final d[] yI = {new d(TAG_GPS_VERSION_ID, 0, 1), new d(TAG_GPS_LATITUDE_REF, 1, 2), new d(TAG_GPS_LATITUDE, 2, 5), new d(TAG_GPS_LONGITUDE_REF, 3, 2), new d(TAG_GPS_LONGITUDE, 4, 5), new d(TAG_GPS_ALTITUDE_REF, 5, 1), new d(TAG_GPS_ALTITUDE, 6, 5), new d(TAG_GPS_TIMESTAMP, 7, 5), new d(TAG_GPS_SATELLITES, 8, 2), new d(TAG_GPS_STATUS, 9, 2), new d(TAG_GPS_MEASURE_MODE, 10, 2), new d(TAG_GPS_DOP, 11, 5), new d(TAG_GPS_SPEED_REF, 12, 2), new d(TAG_GPS_SPEED, 13, 5), new d(TAG_GPS_TRACK_REF, 14, 2), new d(TAG_GPS_TRACK, 15, 5), new d(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new d(TAG_GPS_IMG_DIRECTION, 17, 5), new d(TAG_GPS_MAP_DATUM, 18, 2), new d(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new d(TAG_GPS_DEST_LATITUDE, 20, 5), new d(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new d(TAG_GPS_DEST_LONGITUDE, 22, 5), new d(TAG_GPS_DEST_BEARING_REF, 23, 2), new d(TAG_GPS_DEST_BEARING, 24, 5), new d(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new d(TAG_GPS_DEST_DISTANCE, 26, 5), new d(TAG_GPS_PROCESSING_METHOD, 27, 7), new d(TAG_GPS_AREA_INFORMATION, 28, 7), new d(TAG_GPS_DATESTAMP, 29, 2), new d(TAG_GPS_DIFFERENTIAL, 30, 3)};
    private static final d[] yJ = {new d(TAG_INTEROPERABILITY_INDEX, 1, 2)};
    private static final d[] yK = {new d(TAG_NEW_SUBFILE_TYPE, 254, 4), new d(TAG_SUBFILE_TYPE, 255, 4), new d(TAG_THUMBNAIL_IMAGE_WIDTH, 256), new d(TAG_THUMBNAIL_IMAGE_LENGTH, CdnLogic.kAppTypeFestivalImage), new d(TAG_BITS_PER_SAMPLE, CdnLogic.kAppTypeFestivalVideo, 3), new d(TAG_COMPRESSION, 259, 3), new d(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new d(TAG_IMAGE_DESCRIPTION, 270, 2), new d(TAG_MAKE, a.C0691a.CTRL_INDEX, 2), new d(TAG_MODEL, 272, 2), new d(TAG_STRIP_OFFSETS, 273), new d(TAG_ORIENTATION, a.C0693a.CTRL_INDEX, 3), new d(TAG_SAMPLES_PER_PIXEL, 277, 3), new d(TAG_ROWS_PER_STRIP, 278), new d(TAG_STRIP_BYTE_COUNTS, 279), new d(TAG_X_RESOLUTION, 282, 5), new d(TAG_Y_RESOLUTION, ct.CTRL_INDEX, 5), new d(TAG_PLANAR_CONFIGURATION, ak.CTRL_INDEX, 3), new d(TAG_RESOLUTION_UNIT, 296, 3), new d(TAG_TRANSFER_FUNCTION, 301, 3), new d(TAG_SOFTWARE, 305, 2), new d(TAG_DATETIME, TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, 2), new d(TAG_ARTIST, com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, 2), new d(TAG_WHITE_POINT, 318, 5), new d(TAG_PRIMARY_CHROMATICITIES, TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 5), new d(TAG_SUB_IFD_POINTER, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4), new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new d(TAG_Y_CB_CR_COEFFICIENTS, f.CTRL_INDEX, 5), new d(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new d(TAG_Y_CB_CR_POSITIONING, 531, 3), new d(TAG_REFERENCE_BLACK_WHITE, com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX, 5), new d(TAG_COPYRIGHT, 33432, 2), new d(TAG_EXIF_IFD_POINTER, 34665, 4), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new d(TAG_DNG_VERSION, 50706, 1), new d(TAG_DEFAULT_CROP_SIZE, 50720)};
    private static final d[] yL = {new d(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new d(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new d(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
    private static final d[] yM = {new d(TAG_ORF_PREVIEW_IMAGE_START, CdnLogic.kAppTypeFestivalImage, 4), new d(TAG_ORF_PREVIEW_IMAGE_LENGTH, CdnLogic.kAppTypeFestivalVideo, 4)};
    private static final d[] yN = {new d(TAG_ORF_ASPECT_FRAME, 4371, 3)};
    private static final d[] yO = {new d(TAG_COLOR_SPACE, 55, 3)};
    static final d[][] yP = {yG, yH, yI, yJ, yK, yG, yL, yM, yN, yO};
    private static final d[] yQ = {new d(TAG_SUB_IFD_POINTER, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4), new d(TAG_EXIF_IFD_POINTER, 34665, 4), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new d(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new d(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new d(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
    private static final d yR = new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
    private static final d yS = new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
    private static final HashMap<Integer, d>[] yT = new HashMap[yP.length];
    private static final HashMap<String, d>[] yU = new HashMap[yP.length];
    private static final HashSet<String> yV = new HashSet<>(Arrays.asList(TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP));
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
    private final String yZ;
    private final AssetManager.AssetInputStream za;
    private int zb;
    private final HashMap<String, c>[] zc;
    private Set<Integer> zd;
    private ByteOrder ze;
    private boolean zf;
    private int zg;
    private int zi;
    private byte[] zj;
    private int zk;
    private int zl;
    private int zm;
    private int zn;
    private int zo;
    private int zp;
    private boolean zq;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        yC = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i2 = 0; i2 < yP.length; i2++) {
            yT[i2] = new HashMap<>();
            yU[i2] = new HashMap<>();
            d[] dVarArr = yP[i2];
            for (d dVar : dVarArr) {
                yT[i2].put(Integer.valueOf(dVar.number), dVar);
                yU[i2].put(dVar.name, dVar);
            }
        }
        yW.put(Integer.valueOf(yQ[0].number), 5);
        yW.put(Integer.valueOf(yQ[1].number), 1);
        yW.put(Integer.valueOf(yQ[2].number), 2);
        yW.put(Integer.valueOf(yQ[3].number), 3);
        yW.put(Integer.valueOf(yQ[4].number), 7);
        yW.put(Integer.valueOf(yQ[5].number), 8);
    }

    /* access modifiers changed from: package-private */
    public static class e {
        public final long zB;
        public final long zC;

        e(double d2) {
            this((long) (10000.0d * d2), 10000);
        }

        e(long j2, long j3) {
            if (j3 == 0) {
                this.zB = 0;
                this.zC = 1;
                return;
            }
            this.zB = j2;
            this.zC = j3;
        }

        public final String toString() {
            return this.zB + FilePathGenerator.ANDROID_DIR_SEP + this.zC;
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public final int format;
        public final int zx;
        public final byte[] zy;

        c(int i2, int i3, byte[] bArr) {
            this.format = i2;
            this.zx = i3;
            this.zy = bArr;
        }

        public static c a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.yE[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putShort((short) i2);
            }
            return new c(3, iArr.length, wrap.array());
        }

        public static c a(int i2, ByteOrder byteOrder) {
            return a(new int[]{i2}, byteOrder);
        }

        public static c a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.yE[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j2 : jArr) {
                wrap.putInt((int) j2);
            }
            return new c(4, jArr.length, wrap.array());
        }

        public static c a(long j2, ByteOrder byteOrder) {
            return a(new long[]{j2}, byteOrder);
        }

        public static c b(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.yE[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putInt(i2);
            }
            return new c(9, iArr.length, wrap.array());
        }

        public static c n(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.yX);
            return new c(2, bytes.length, bytes);
        }

        public static c a(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.yE[5] * eVarArr.length)]);
            wrap.order(byteOrder);
            for (e eVar : eVarArr) {
                wrap.putInt((int) eVar.zB);
                wrap.putInt((int) eVar.zC);
            }
            return new c(5, eVarArr.length, wrap.array());
        }

        public static c a(e eVar, ByteOrder byteOrder) {
            return a(new e[]{eVar}, byteOrder);
        }

        public static c b(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.yE[10] * eVarArr.length)]);
            wrap.order(byteOrder);
            for (e eVar : eVarArr) {
                wrap.putInt((int) eVar.zB);
                wrap.putInt((int) eVar.zC);
            }
            return new c(10, eVarArr.length, wrap.array());
        }

        public static c a(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.yE[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double d2 : dArr) {
                wrap.putDouble(d2);
            }
            return new c(12, dArr.length, wrap.array());
        }

        public final String toString() {
            return "(" + a.yD[this.format] + ", data length:" + this.zy.length + ")";
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x0189 A[SYNTHETIC, Splitter:B:113:0x0189] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0096 A[SYNTHETIC, Splitter:B:47:0x0096] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(java.nio.ByteOrder r10) {
            /*
            // Method dump skipped, instructions count: 442
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.e.a.c.a(java.nio.ByteOrder):java.lang.Object");
        }

        public final int b(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (a2 instanceof String) {
                return Integer.parseInt((String) a2);
            } else {
                if (a2 instanceof long[]) {
                    long[] jArr = (long[]) a2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof int[]) {
                    int[] iArr = (int[]) a2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public final String c(ByteOrder byteOrder) {
            int i2 = 0;
            Object a2 = a(byteOrder);
            if (a2 == null) {
                return null;
            }
            if (a2 instanceof String) {
                return (String) a2;
            }
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
                return sb.toString();
            } else if (a2 instanceof int[]) {
                int[] iArr = (int[]) a2;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    if (i2 + 1 != iArr.length) {
                        sb.append(",");
                    }
                    i2++;
                }
                return sb.toString();
            } else if (a2 instanceof double[]) {
                double[] dArr = (double[]) a2;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    if (i2 + 1 != dArr.length) {
                        sb.append(",");
                    }
                    i2++;
                }
                return sb.toString();
            } else if (!(a2 instanceof e[])) {
                return null;
            } else {
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
                return sb.toString();
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
        Throwable th;
        this.zc = new HashMap[yP.length];
        this.zd = new HashSet(yP.length);
        this.ze = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        this.za = null;
        this.yZ = str;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                b(fileInputStream);
                closeQuietly(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            closeQuietly(fileInputStream);
            throw th;
        }
    }

    public a(InputStream inputStream) {
        this.zc = new HashMap[yP.length];
        this.zd = new HashSet(yP.length);
        this.ze = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        this.yZ = null;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.za = (AssetManager.AssetInputStream) inputStream;
        } else {
            this.za = null;
        }
        b(inputStream);
    }

    private c k(String str) {
        if (TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i2 = 0; i2 < yP.length; i2++) {
            c cVar = this.zc[i2].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    public final String getAttribute(String str) {
        double d2;
        c k = k(str);
        if (k == null) {
            return null;
        }
        if (!yV.contains(str)) {
            return k.c(this.ze);
        }
        if (!str.equals(TAG_GPS_TIMESTAMP)) {
            try {
                Object a2 = k.a(this.ze);
                if (a2 == null) {
                    throw new NumberFormatException("NULL can't be converted to a double value");
                }
                if (a2 instanceof String) {
                    d2 = Double.parseDouble((String) a2);
                } else if (a2 instanceof long[]) {
                    long[] jArr = (long[]) a2;
                    if (jArr.length == 1) {
                        d2 = (double) jArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (a2 instanceof int[]) {
                    int[] iArr = (int[]) a2;
                    if (iArr.length == 1) {
                        d2 = (double) iArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (a2 instanceof double[]) {
                    double[] dArr = (double[]) a2;
                    if (dArr.length == 1) {
                        d2 = dArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (a2 instanceof e[]) {
                    e[] eVarArr = (e[]) a2;
                    if (eVarArr.length == 1) {
                        e eVar = eVarArr[0];
                        d2 = ((double) eVar.zB) / ((double) eVar.zC);
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
                return Double.toString(d2);
            } catch (NumberFormatException e2) {
                return null;
            }
        } else if (k.format == 5 || k.format == 10) {
            e[] eVarArr2 = (e[]) k.a(this.ze);
            if (eVarArr2 == null || eVarArr2.length != 3) {
                new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(eVarArr2));
                return null;
            }
            return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) eVarArr2[0].zB) / ((float) eVarArr2[0].zC))), Integer.valueOf((int) (((float) eVarArr2[1].zB) / ((float) eVarArr2[1].zC))), Integer.valueOf((int) (((float) eVarArr2[2].zB) / ((float) eVarArr2[2].zC))));
        } else {
            new StringBuilder("GPS Timestamp format is not rational. format=").append(k.format);
            return null;
        }
    }

    public final int l(String str) {
        c k = k(str);
        if (k == null) {
            return 1;
        }
        try {
            return k.b(this.ze);
        } catch (NumberFormatException e2) {
            return 1;
        }
    }

    public final void setAttribute(String str, String str2) {
        d dVar;
        int i2;
        c cVar;
        if (TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        if (str2 != null && yV.contains(str)) {
            if (str.equals(TAG_GPS_TIMESTAMP)) {
                Matcher matcher = zt.matcher(str2);
                if (!matcher.find()) {
                    new StringBuilder("Invalid value for ").append(str).append(" : ").append(str2);
                    return;
                }
                str2 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    str2 = new e(Double.parseDouble(str2)).toString();
                } catch (NumberFormatException e2) {
                    new StringBuilder("Invalid value for ").append(str).append(" : ").append(str2);
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < yP.length; i3++) {
            if ((i3 != 4 || this.zf) && (dVar = yU[i3].get(str)) != null) {
                if (str2 == null) {
                    this.zc[i3].remove(str);
                } else {
                    Pair<Integer, Integer> m = m(str2);
                    if (dVar.zz == ((Integer) m.first).intValue() || dVar.zz == ((Integer) m.second).intValue()) {
                        i2 = dVar.zz;
                    } else if (dVar.zA != -1 && (dVar.zA == ((Integer) m.first).intValue() || dVar.zA == ((Integer) m.second).intValue())) {
                        i2 = dVar.zA;
                    } else if (dVar.zz == 1 || dVar.zz == 7 || dVar.zz == 2) {
                        i2 = dVar.zz;
                    } else {
                        new StringBuilder("Given tag (").append(str).append(") value didn't match with one of expected formats: ").append(yD[dVar.zz]).append(dVar.zA == -1 ? "" : ", " + yD[dVar.zA]).append(" (guess: ").append(yD[((Integer) m.first).intValue()]).append(((Integer) m.second).intValue() == -1 ? "" : ", " + yD[((Integer) m.second).intValue()]).append(")");
                    }
                    switch (i2) {
                        case 1:
                            HashMap<String, c> hashMap = this.zc[i3];
                            if (str2.length() != 1 || str2.charAt(0) < '0' || str2.charAt(0) > '1') {
                                byte[] bytes = str2.getBytes(yX);
                                cVar = new c(1, bytes.length, bytes);
                            } else {
                                cVar = new c(1, 1, new byte[]{(byte) (str2.charAt(0) - '0')});
                            }
                            hashMap.put(str, cVar);
                            continue;
                        case 2:
                        case 7:
                            this.zc[i3].put(str, c.n(str2));
                            continue;
                        case 3:
                            String[] split = str2.split(",", -1);
                            int[] iArr = new int[split.length];
                            for (int i4 = 0; i4 < split.length; i4++) {
                                iArr[i4] = Integer.parseInt(split[i4]);
                            }
                            this.zc[i3].put(str, c.a(iArr, this.ze));
                            continue;
                        case 4:
                            String[] split2 = str2.split(",", -1);
                            long[] jArr = new long[split2.length];
                            for (int i5 = 0; i5 < split2.length; i5++) {
                                jArr[i5] = Long.parseLong(split2[i5]);
                            }
                            this.zc[i3].put(str, c.a(jArr, this.ze));
                            continue;
                        case 5:
                            String[] split3 = str2.split(",", -1);
                            e[] eVarArr = new e[split3.length];
                            for (int i6 = 0; i6 < split3.length; i6++) {
                                String[] split4 = split3[i6].split(FilePathGenerator.ANDROID_DIR_SEP, -1);
                                eVarArr[i6] = new e((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                            }
                            this.zc[i3].put(str, c.a(eVarArr, this.ze));
                            continue;
                        case 9:
                            String[] split5 = str2.split(",", -1);
                            int[] iArr2 = new int[split5.length];
                            for (int i7 = 0; i7 < split5.length; i7++) {
                                iArr2[i7] = Integer.parseInt(split5[i7]);
                            }
                            this.zc[i3].put(str, c.b(iArr2, this.ze));
                            continue;
                        case 10:
                            String[] split6 = str2.split(",", -1);
                            e[] eVarArr2 = new e[split6.length];
                            for (int i8 = 0; i8 < split6.length; i8++) {
                                String[] split7 = split6[i8].split(FilePathGenerator.ANDROID_DIR_SEP, -1);
                                eVarArr2[i8] = new e((long) Double.parseDouble(split7[0]), (long) Double.parseDouble(split7[1]));
                            }
                            this.zc[i3].put(str, c.b(eVarArr2, this.ze));
                            continue;
                        case 12:
                            String[] split8 = str2.split(",", -1);
                            double[] dArr = new double[split8.length];
                            for (int i9 = 0; i9 < split8.length; i9++) {
                                dArr[i9] = Double.parseDouble(split8[i9]);
                            }
                            this.zc[i3].put(str, c.a(dArr, this.ze));
                            continue;
                    }
                }
            }
        }
    }

    private void removeAttribute(String str) {
        for (int i2 = 0; i2 < yP.length; i2++) {
            this.zc[i2].remove(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0248  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.io.InputStream r12) {
        /*
        // Method dump skipped, instructions count: 686
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.e.a.b(java.io.InputStream):void");
    }

    public final void saveAttributes() {
        byte[] bArr;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        if (!this.zq || this.zb != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        } else if (this.yZ == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        } else {
            if (this.zk == 6 || this.zk == 7) {
                bArr = getThumbnailBytes();
            } else {
                bArr = null;
            }
            this.zj = bArr;
            File file = new File(this.yZ + ".tmp");
            if (!new File(this.yZ).renameTo(file)) {
                throw new IOException("Could not rename to " + file.getAbsolutePath());
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(this.yZ);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                    file.delete();
                    throw th;
                }
                try {
                    b(fileInputStream, fileOutputStream);
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                    file.delete();
                    this.zj = null;
                } catch (Throwable th3) {
                    th = th3;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                    file.delete();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileInputStream = null;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
                file.delete();
                throw th;
            }
        }
    }

    private byte[] getThumbnailBytes() {
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2;
        if (!this.zf) {
            return null;
        }
        if (this.zj != null) {
            return this.zj;
        }
        try {
            if (this.za != null) {
                inputStream2 = this.za;
                try {
                    if (inputStream2.markSupported()) {
                        inputStream2.reset();
                        inputStream = inputStream2;
                    } else {
                        closeQuietly(inputStream2);
                        return null;
                    }
                } catch (IOException e2) {
                    closeQuietly(inputStream2);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    closeQuietly(inputStream);
                    throw th;
                }
            } else {
                inputStream = this.yZ != null ? new FileInputStream(this.yZ) : null;
            }
            if (inputStream == null) {
                try {
                    throw new FileNotFoundException();
                } catch (IOException e3) {
                    inputStream2 = inputStream;
                    closeQuietly(inputStream2);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    closeQuietly(inputStream);
                    throw th;
                }
            } else if (inputStream.skip((long) this.zg) != ((long) this.zg)) {
                throw new IOException("Corrupted image");
            } else {
                byte[] bArr = new byte[this.zi];
                if (inputStream.read(bArr) != this.zi) {
                    throw new IOException("Corrupted image");
                }
                this.zj = bArr;
                closeQuietly(inputStream);
                return bArr;
            }
        } catch (IOException e4) {
            inputStream2 = null;
            closeQuietly(inputStream2);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            closeQuietly(inputStream);
            throw th;
        }
    }

    public static String b(double d2) {
        long j2 = (long) d2;
        long j3 = (long) ((d2 - ((double) j2)) * 60.0d);
        return j2 + "/1," + j3 + "/1," + Math.round(((d2 - ((double) j2)) - (((double) j3) / 60.0d)) * 3600.0d * 1.0E7d) + "/10000000";
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
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    private void a(C0012a aVar, int i2, int i3) {
        aVar.zv = ByteOrder.BIG_ENDIAN;
        aVar.seek((long) i2);
        byte readByte = aVar.readByte();
        if (readByte != -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i4 = i2 + 1;
        if (aVar.readByte() != -40) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i5 = i4 + 1;
        while (true) {
            byte readByte2 = aVar.readByte();
            if (readByte2 != -1) {
                throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
            }
            byte readByte3 = aVar.readByte();
            int i6 = i5 + 1 + 1;
            if (readByte3 == -39 || readByte3 == -38) {
                aVar.zv = this.ze;
            } else {
                int readUnsignedShort = aVar.readUnsignedShort() - 2;
                int i7 = i6 + 2;
                if (readUnsignedShort < 0) {
                    throw new IOException("Invalid length");
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
                            this.zc[i3].put(TAG_IMAGE_LENGTH, c.a((long) aVar.readUnsignedShort(), this.ze));
                            this.zc[i3].put(TAG_IMAGE_WIDTH, c.a((long) aVar.readUnsignedShort(), this.ze));
                            readUnsignedShort -= 5;
                            break;
                        } else {
                            throw new IOException("Invalid SOFx");
                        }
                    case APPluginConstants.ERROR_IO_MalformedChunkCodingException /*{ENCODED_INT: -31}*/:
                        if (readUnsignedShort >= 6) {
                            byte[] bArr = new byte[6];
                            if (aVar.read(bArr) == 6) {
                                i7 += 6;
                                readUnsignedShort -= 6;
                                if (Arrays.equals(bArr, yY)) {
                                    if (readUnsignedShort > 0) {
                                        this.zl = i7;
                                        byte[] bArr2 = new byte[readUnsignedShort];
                                        if (aVar.read(bArr2) == readUnsignedShort) {
                                            i7 += readUnsignedShort;
                                            C0012a aVar2 = new C0012a(bArr2);
                                            a(aVar2, bArr2.length);
                                            b(aVar2, i3);
                                            readUnsignedShort = 0;
                                            break;
                                        } else {
                                            throw new IOException("Invalid exif");
                                        }
                                    } else {
                                        throw new IOException("Invalid exif");
                                    }
                                }
                            } else {
                                throw new IOException("Invalid exif");
                            }
                        }
                        break;
                    case -2:
                        byte[] bArr3 = new byte[readUnsignedShort];
                        if (aVar.read(bArr3) == readUnsignedShort) {
                            if (getAttribute(TAG_USER_COMMENT) != null) {
                                readUnsignedShort = 0;
                                break;
                            } else {
                                this.zc[1].put(TAG_USER_COMMENT, c.n(new String(bArr3, yX)));
                                readUnsignedShort = 0;
                                break;
                            }
                        } else {
                            throw new IOException("Invalid exif");
                        }
                }
                if (readUnsignedShort < 0) {
                    throw new IOException("Invalid length");
                } else if (aVar.skipBytes(readUnsignedShort) != readUnsignedShort) {
                    throw new IOException("Invalid JPEG segment");
                } else {
                    i5 = readUnsignedShort + i7;
                }
            }
        }
        aVar.zv = this.ze;
    }

    private void a(C0012a aVar) {
        c cVar;
        a(aVar, aVar.available());
        b(aVar, 0);
        d(aVar, 0);
        d(aVar, 5);
        d(aVar, 4);
        dD();
        if (this.zb == 8 && (cVar = this.zc[1].get(TAG_MAKER_NOTE)) != null) {
            C0012a aVar2 = new C0012a(cVar.zy);
            aVar2.zv = this.ze;
            aVar2.seek(6);
            b(aVar2, 9);
            c cVar2 = this.zc[9].get(TAG_COLOR_SPACE);
            if (cVar2 != null) {
                this.zc[1].put(TAG_COLOR_SPACE, cVar2);
            }
        }
    }

    private void b(C0012a aVar) {
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
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                c a2 = c.a((int) readShort, this.ze);
                c a3 = c.a((int) readShort2, this.ze);
                this.zc[0].put(TAG_IMAGE_LENGTH, a2);
                this.zc[0].put(TAG_IMAGE_WIDTH, a3);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    private void b(InputStream inputStream, OutputStream outputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        b bVar = new b(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        bVar.writeByte(-1);
        if (dataInputStream.readByte() != -40) {
            throw new IOException("Invalid marker");
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
                                        throw new IOException("Invalid length");
                                    }
                                }
                            } else {
                                throw new IOException("Invalid exif");
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
                        throw new IOException("Invalid length");
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
                        throw new IOException("Invalid length");
                    }
            }
        }
        throw new IOException("Invalid marker");
    }

    private void dC() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.zc[0].put(TAG_DATETIME, c.n(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.zc[0].put(TAG_IMAGE_WIDTH, c.a(0L, this.ze));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.zc[0].put(TAG_IMAGE_LENGTH, c.a(0L, this.ze));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.zc[0].put(TAG_ORIENTATION, c.a(0L, this.ze));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.zc[1].put(TAG_LIGHT_SOURCE, c.a(0L, this.ze));
        }
    }

    private static ByteOrder c(C0012a aVar) {
        short readShort = aVar.readShort();
        switch (readShort) {
            case 18761:
                return ByteOrder.LITTLE_ENDIAN;
            case 19789:
                return ByteOrder.BIG_ENDIAN;
            default:
                throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void a(C0012a aVar, int i2) {
        this.ze = c(aVar);
        aVar.zv = this.ze;
        int readUnsignedShort = aVar.readUnsignedShort();
        if (this.zb == 7 || this.zb == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i2) {
                throw new IOException("Invalid first Ifd offset: ".concat(String.valueOf(readInt)));
            }
            int i3 = readInt - 8;
            if (i3 > 0 && aVar.skipBytes(i3) != i3) {
                throw new IOException("Couldn't jump to first Ifd: ".concat(String.valueOf(i3)));
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void b(C0012a aVar, int i2) {
        int i3;
        while (true) {
            this.zd.add(Integer.valueOf(aVar.mPosition));
            if (aVar.mPosition + 2 <= aVar.mLength) {
                short readShort = aVar.readShort();
                if (aVar.mPosition + (readShort * 12) <= aVar.mLength && readShort > 0) {
                    for (short s = 0; s < readShort; s = (short) (s + 1)) {
                        int readUnsignedShort = aVar.readUnsignedShort();
                        int readUnsignedShort2 = aVar.readUnsignedShort();
                        int readInt = aVar.readInt();
                        long j2 = 4 + ((long) aVar.mPosition);
                        d dVar = yT[i2].get(Integer.valueOf(readUnsignedShort));
                        long j3 = 0;
                        boolean z = false;
                        if (dVar == null) {
                            i3 = readUnsignedShort2;
                        } else if (readUnsignedShort2 <= 0 || readUnsignedShort2 >= yE.length) {
                            i3 = readUnsignedShort2;
                        } else if (!dVar.am(readUnsignedShort2)) {
                            new StringBuilder("Skip the tag entry since data format (").append(yD[readUnsignedShort2]).append(") is unexpected for tag: ").append(dVar.name);
                            i3 = readUnsignedShort2;
                        } else {
                            if (readUnsignedShort2 == 7) {
                                readUnsignedShort2 = dVar.zz;
                            }
                            j3 = ((long) readInt) * ((long) yE[readUnsignedShort2]);
                            if (j3 < 0 || j3 > 2147483647L) {
                                i3 = readUnsignedShort2;
                            } else {
                                z = true;
                                i3 = readUnsignedShort2;
                            }
                        }
                        if (!z) {
                            aVar.seek(j2);
                        } else {
                            if (j3 > 4) {
                                int readInt2 = aVar.readInt();
                                if (this.zb == 7) {
                                    if (TAG_MAKER_NOTE.equals(dVar.name)) {
                                        this.zm = readInt2;
                                    } else if (i2 == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(dVar.name)) {
                                        this.zn = readInt2;
                                        this.zo = readInt;
                                        c a2 = c.a(6, this.ze);
                                        c a3 = c.a((long) this.zn, this.ze);
                                        c a4 = c.a((long) this.zo, this.ze);
                                        this.zc[4].put(TAG_COMPRESSION, a2);
                                        this.zc[4].put(TAG_JPEG_INTERCHANGE_FORMAT, a3);
                                        this.zc[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, a4);
                                    }
                                } else if (this.zb == 10 && TAG_RW2_JPG_FROM_RAW.equals(dVar.name)) {
                                    this.zp = readInt2;
                                }
                                if (((long) readInt2) + j3 <= ((long) aVar.mLength)) {
                                    aVar.seek((long) readInt2);
                                } else {
                                    aVar.seek(j2);
                                }
                            }
                            Integer num = yW.get(Integer.valueOf(readUnsignedShort));
                            if (num != null) {
                                long j4 = -1;
                                switch (i3) {
                                    case 3:
                                        j4 = (long) aVar.readUnsignedShort();
                                        break;
                                    case 4:
                                        j4 = aVar.dE();
                                        break;
                                    case 8:
                                        j4 = (long) aVar.readShort();
                                        break;
                                    case 9:
                                    case 13:
                                        j4 = (long) aVar.readInt();
                                        break;
                                }
                                if (j4 > 0 && j4 < ((long) aVar.mLength)) {
                                    if (!this.zd.contains(Integer.valueOf((int) j4))) {
                                        aVar.seek(j4);
                                        b(aVar, num.intValue());
                                    } else {
                                        new StringBuilder("Skip jump into the IFD since it has already been read: IfdType ").append(num).append(" (at ").append(j4).append(")");
                                    }
                                }
                                aVar.seek(j2);
                            } else {
                                byte[] bArr = new byte[((int) j3)];
                                aVar.readFully(bArr);
                                c cVar = new c(i3, readInt, bArr);
                                this.zc[i2].put(dVar.name, cVar);
                                if (TAG_DNG_VERSION.equals(dVar.name)) {
                                    this.zb = 3;
                                }
                                if (((TAG_MAKE.equals(dVar.name) || TAG_MODEL.equals(dVar.name)) && cVar.c(this.ze).contains("PENTAX")) || (TAG_COMPRESSION.equals(dVar.name) && cVar.b(this.ze) == 65535)) {
                                    this.zb = 8;
                                }
                                if (((long) aVar.mPosition) != j2) {
                                    aVar.seek(j2);
                                }
                            }
                        }
                    }
                    if (aVar.mPosition + 4 <= aVar.mLength) {
                        int readInt3 = aVar.readInt();
                        if (((long) readInt3) > 0 && readInt3 < aVar.mLength && !this.zd.contains(Integer.valueOf(readInt3))) {
                            aVar.seek((long) readInt3);
                            if (this.zc[4].isEmpty()) {
                                i2 = 4;
                            } else if (this.zc[5].isEmpty()) {
                                i2 = 5;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void c(C0012a aVar, int i2) {
        c cVar;
        c cVar2 = this.zc[i2].get(TAG_IMAGE_LENGTH);
        c cVar3 = this.zc[i2].get(TAG_IMAGE_WIDTH);
        if ((cVar2 == null || cVar3 == null) && (cVar = this.zc[i2].get(TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            a(aVar, cVar.b(this.ze), i2);
        }
    }

    private void a(C0012a aVar, HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        c cVar2 = (c) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (cVar != null && cVar2 != null) {
            int b2 = cVar.b(this.ze);
            int min = Math.min(cVar2.b(this.ze), aVar.available() - b2);
            if (this.zb == 4 || this.zb == 9 || this.zb == 10) {
                b2 += this.zl;
            } else if (this.zb == 7) {
                b2 += this.zm;
            }
            if (b2 > 0 && min > 0) {
                this.zf = true;
                this.zg = b2;
                this.zi = min;
                if (this.yZ == null && this.za == null) {
                    byte[] bArr = new byte[min];
                    aVar.seek((long) b2);
                    aVar.readFully(bArr);
                    this.zj = bArr;
                }
            }
        }
    }

    private void b(C0012a aVar, HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_STRIP_OFFSETS);
        c cVar2 = (c) hashMap.get(TAG_STRIP_BYTE_COUNTS);
        if (!(cVar == null || cVar2 == null)) {
            long[] h2 = h(cVar.a(this.ze));
            long[] h3 = h(cVar2.a(this.ze));
            if (!(h2 == null || h3 == null)) {
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
    }

    private boolean a(HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_IMAGE_LENGTH);
        c cVar2 = (c) hashMap.get(TAG_IMAGE_WIDTH);
        if (!(cVar == null || cVar2 == null)) {
            int b2 = cVar.b(this.ze);
            int b3 = cVar2.b(this.ze);
            if (b2 > 512 || b3 > 512) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void dD() {
        t(0, 5);
        t(0, 4);
        t(5, 4);
        c cVar = this.zc[1].get(TAG_PIXEL_X_DIMENSION);
        c cVar2 = this.zc[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(cVar == null || cVar2 == null)) {
            this.zc[0].put(TAG_IMAGE_WIDTH, cVar);
            this.zc[0].put(TAG_IMAGE_LENGTH, cVar2);
        }
        if (this.zc[4].isEmpty() && a(this.zc[5])) {
            this.zc[4] = this.zc[5];
            this.zc[5] = new HashMap<>();
        }
        a(this.zc[4]);
    }

    private void d(C0012a aVar, int i2) {
        c a2;
        c a3;
        c cVar = this.zc[i2].get(TAG_DEFAULT_CROP_SIZE);
        c cVar2 = this.zc[i2].get(TAG_RW2_SENSOR_TOP_BORDER);
        c cVar3 = this.zc[i2].get(TAG_RW2_SENSOR_LEFT_BORDER);
        c cVar4 = this.zc[i2].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        c cVar5 = this.zc[i2].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (cVar != null) {
            if (cVar.format == 5) {
                e[] eVarArr = (e[]) cVar.a(this.ze);
                if (eVarArr == null || eVarArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(eVarArr));
                    return;
                } else {
                    a2 = c.a(eVarArr[0], this.ze);
                    a3 = c.a(eVarArr[1], this.ze);
                }
            } else {
                int[] iArr = (int[]) cVar.a(this.ze);
                if (iArr == null || iArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(iArr));
                    return;
                } else {
                    a2 = c.a(iArr[0], this.ze);
                    a3 = c.a(iArr[1], this.ze);
                }
            }
            this.zc[i2].put(TAG_IMAGE_WIDTH, a2);
            this.zc[i2].put(TAG_IMAGE_LENGTH, a3);
        } else if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
            c(aVar, i2);
        } else {
            int b2 = cVar2.b(this.ze);
            int b3 = cVar4.b(this.ze);
            int b4 = cVar5.b(this.ze);
            int b5 = cVar3.b(this.ze);
            if (b3 > b2 && b4 > b5) {
                int i3 = b3 - b2;
                c a4 = c.a(i3, this.ze);
                c a5 = c.a(b4 - b5, this.ze);
                this.zc[i2].put(TAG_IMAGE_LENGTH, a4);
                this.zc[i2].put(TAG_IMAGE_WIDTH, a5);
            }
        }
    }

    private int a(b bVar) {
        int i2;
        int[] iArr = new int[yP.length];
        int[] iArr2 = new int[yP.length];
        for (d dVar : yQ) {
            removeAttribute(dVar.name);
        }
        removeAttribute(yR.name);
        removeAttribute(yS.name);
        for (int i3 = 0; i3 < yP.length; i3++) {
            for (Object obj : this.zc[i3].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.zc[i3].remove(entry.getKey());
                }
            }
        }
        if (!this.zc[1].isEmpty()) {
            this.zc[0].put(yQ[1].name, c.a(0L, this.ze));
        }
        if (!this.zc[2].isEmpty()) {
            this.zc[0].put(yQ[2].name, c.a(0L, this.ze));
        }
        if (!this.zc[3].isEmpty()) {
            this.zc[1].put(yQ[3].name, c.a(0L, this.ze));
        }
        if (this.zf) {
            this.zc[4].put(yR.name, c.a(0L, this.ze));
            this.zc[4].put(yS.name, c.a((long) this.zi, this.ze));
        }
        for (int i4 = 0; i4 < yP.length; i4++) {
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
        for (int i7 = 0; i7 < yP.length; i7++) {
            if (!this.zc[i7].isEmpty()) {
                iArr[i7] = i6;
                i6 += (this.zc[i7].size() * 12) + 2 + 4 + iArr2[i7];
            }
        }
        if (this.zf) {
            this.zc[4].put(yR.name, c.a((long) i6, this.ze));
            this.zg = i6 + 6;
            i6 += this.zi;
        }
        int i8 = i6 + 8;
        if (!this.zc[1].isEmpty()) {
            this.zc[0].put(yQ[1].name, c.a((long) iArr[1], this.ze));
        }
        if (!this.zc[2].isEmpty()) {
            this.zc[0].put(yQ[2].name, c.a((long) iArr[2], this.ze));
        }
        if (!this.zc[3].isEmpty()) {
            this.zc[1].put(yQ[3].name, c.a((long) iArr[3], this.ze));
        }
        bVar.writeShort((short) i8);
        bVar.write(yY);
        bVar.writeShort(this.ze == ByteOrder.BIG_ENDIAN ? (short) 19789 : 18761);
        bVar.zv = this.ze;
        bVar.writeShort(42);
        bVar.writeInt(8);
        for (int i9 = 0; i9 < yP.length; i9++) {
            if (!this.zc[i9].isEmpty()) {
                bVar.writeShort((short) this.zc[i9].size());
                int size2 = iArr[i9] + 2 + (this.zc[i9].size() * 12) + 4;
                for (Map.Entry<String, c> entry3 : this.zc[i9].entrySet()) {
                    int i10 = yU[i9].get(entry3.getKey()).number;
                    c value = entry3.getValue();
                    int size3 = value.size();
                    bVar.writeShort((short) i10);
                    bVar.writeShort((short) value.format);
                    bVar.writeInt(value.zx);
                    if (size3 > 4) {
                        bVar.writeInt((int) ((long) size2));
                        size2 += size3;
                    } else {
                        bVar.write(value.zy);
                        if (size3 < 4) {
                            for (int i11 = size3; i11 < 4; i11++) {
                                bVar.writeByte(0);
                            }
                        }
                    }
                }
                if (i9 != 0 || this.zc[4].isEmpty()) {
                    bVar.writeInt(0);
                } else {
                    bVar.writeInt((int) ((long) iArr[4]));
                }
                for (Map.Entry<String, c> entry4 : this.zc[i9].entrySet()) {
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
        return i8;
    }

    private static Pair<Integer, Integer> m(String str) {
        int i2;
        int i3;
        Pair<Integer, Integer> pair;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair<Integer, Integer> m = m(split[0]);
            if (((Integer) m.first).intValue() == 2) {
                return m;
            }
            int i4 = 1;
            while (i4 < split.length) {
                Pair<Integer, Integer> m2 = m(split[i4]);
                if (((Integer) m2.first).equals(m.first) || ((Integer) m2.second).equals(m.first)) {
                    i2 = ((Integer) m.first).intValue();
                } else {
                    i2 = -1;
                }
                if (((Integer) m.second).intValue() == -1 || (!((Integer) m2.first).equals(m.second) && !((Integer) m2.second).equals(m.second))) {
                    i3 = -1;
                } else {
                    i3 = ((Integer) m.second).intValue();
                }
                if (i2 == -1 && i3 == -1) {
                    return new Pair<>(2, -1);
                }
                if (i2 == -1) {
                    pair = new Pair<>(Integer.valueOf(i3), -1);
                } else if (i3 == -1) {
                    pair = new Pair<>(Integer.valueOf(i2), -1);
                } else {
                    pair = m;
                }
                i4++;
                m = pair;
            }
            return m;
        } else if (str.contains(FilePathGenerator.ANDROID_DIR_SEP)) {
            String[] split2 = str.split(FilePathGenerator.ANDROID_DIR_SEP, -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble < 0 || parseDouble2 < 0) {
                        return new Pair<>(10, -1);
                    }
                    if (parseDouble > 2147483647L || parseDouble2 > 2147483647L) {
                        return new Pair<>(5, -1);
                    }
                    return new Pair<>(10, 5);
                } catch (NumberFormatException e2) {
                }
            }
            return new Pair<>(2, -1);
        } else {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                if (valueOf.longValue() >= 0 && valueOf.longValue() <= 65535) {
                    return new Pair<>(3, 4);
                }
                if (valueOf.longValue() < 0) {
                    return new Pair<>(9, -1);
                }
                return new Pair<>(4, -1);
            } catch (NumberFormatException e3) {
                try {
                    Double.parseDouble(str);
                    return new Pair<>(12, -1);
                } catch (NumberFormatException e4) {
                    return new Pair<>(2, -1);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.e.a$a  reason: collision with other inner class name */
    public static class C0012a extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        final int mLength;
        int mPosition;
        private DataInputStream zu;
        ByteOrder zv;

        public C0012a(InputStream inputStream) {
            this.zv = ByteOrder.BIG_ENDIAN;
            this.zu = new DataInputStream(inputStream);
            this.mLength = this.zu.available();
            this.mPosition = 0;
            this.zu.mark(this.mLength);
        }

        public C0012a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }

        public final void seek(long j2) {
            if (((long) this.mPosition) > j2) {
                this.mPosition = 0;
                this.zu.reset();
                this.zu.mark(this.mLength);
            } else {
                j2 -= (long) this.mPosition;
            }
            if (skipBytes((int) j2) != ((int) j2)) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.zu.available();
        }

        @Override // java.io.InputStream
        public final int read() {
            this.mPosition++;
            return this.zu.read();
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) {
            int read = this.zu.read(bArr, i2, i3);
            this.mPosition += read;
            return read;
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() {
            this.mPosition++;
            return this.zu.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public final String readLine() {
            return null;
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() {
            this.mPosition++;
            return this.zu.readBoolean();
        }

        @Override // java.io.DataInput
        public final char readChar() {
            this.mPosition += 2;
            return this.zu.readChar();
        }

        @Override // java.io.DataInput
        public final String readUTF() {
            this.mPosition += 2;
            return this.zu.readUTF();
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr, int i2, int i3) {
            this.mPosition += i3;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            } else if (this.zu.read(bArr, i2, i3) != i3) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr) {
            this.mPosition += bArr.length;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            } else if (this.zu.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public final byte readByte() {
            this.mPosition++;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.zu.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final short readShort() {
            this.mPosition += 2;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.zu.read();
            int read2 = this.zu.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            } else if (this.zv == LITTLE_ENDIAN) {
                return (short) (read + (read2 << 8));
            } else {
                if (this.zv == BIG_ENDIAN) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.zv);
            }
        }

        @Override // java.io.DataInput
        public final int readInt() {
            this.mPosition += 4;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.zu.read();
            int read2 = this.zu.read();
            int read3 = this.zu.read();
            int read4 = this.zu.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new EOFException();
            } else if (this.zv == LITTLE_ENDIAN) {
                return read + (read2 << 8) + (read3 << 16) + (read4 << 24);
            } else if (this.zv == BIG_ENDIAN) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            } else {
                throw new IOException("Invalid byte order: " + this.zv);
            }
        }

        @Override // java.io.DataInput
        public final int skipBytes(int i2) {
            int min = Math.min(i2, this.mLength - this.mPosition);
            int i3 = 0;
            while (i3 < min) {
                i3 += this.zu.skipBytes(min - i3);
            }
            this.mPosition += i3;
            return i3;
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() {
            this.mPosition += 2;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.zu.read();
            int read2 = this.zu.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            } else if (this.zv == LITTLE_ENDIAN) {
                return read + (read2 << 8);
            } else {
                if (this.zv == BIG_ENDIAN) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.zv);
            }
        }

        public final long dE() {
            return ((long) readInt()) & Util.MAX_32BIT_VALUE;
        }

        @Override // java.io.DataInput
        public final long readLong() {
            this.mPosition += 8;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
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
                throw new EOFException();
            } else if (this.zv == LITTLE_ENDIAN) {
                return ((long) read) + (((long) read3) << 16) + (((long) read5) << 32) + (((long) read7) << 48) + (((long) read8) << 56) + (((long) read6) << 40) + (((long) read4) << 24) + (((long) read2) << 8);
            } else if (this.zv == BIG_ENDIAN) {
                return (((long) read2) << 48) + (((long) read) << 56) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
            } else {
                throw new IOException("Invalid byte order: " + this.zv);
            }
        }

        @Override // java.io.DataInput
        public final float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public final double readDouble() {
            return Double.longBitsToDouble(readLong());
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
            this.zw.write(bArr);
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public final void write(byte[] bArr, int i2, int i3) {
            this.zw.write(bArr, i2, i3);
        }

        public final void writeByte(int i2) {
            this.zw.write(i2);
        }

        public final void writeShort(short s) {
            if (this.zv == ByteOrder.LITTLE_ENDIAN) {
                this.zw.write((s >>> 0) & 255);
                this.zw.write((s >>> 8) & 255);
            } else if (this.zv == ByteOrder.BIG_ENDIAN) {
                this.zw.write((s >>> 8) & 255);
                this.zw.write((s >>> 0) & 255);
            }
        }

        public final void writeInt(int i2) {
            if (this.zv == ByteOrder.LITTLE_ENDIAN) {
                this.zw.write((i2 >>> 0) & 255);
                this.zw.write((i2 >>> 8) & 255);
                this.zw.write((i2 >>> 16) & 255);
                this.zw.write((i2 >>> 24) & 255);
            } else if (this.zv == ByteOrder.BIG_ENDIAN) {
                this.zw.write((i2 >>> 24) & 255);
                this.zw.write((i2 >>> 16) & 255);
                this.zw.write((i2 >>> 8) & 255);
                this.zw.write((i2 >>> 0) & 255);
            }
        }
    }

    private void t(int i2, int i3) {
        if (!this.zc[i2].isEmpty() && !this.zc[i3].isEmpty()) {
            c cVar = this.zc[i2].get(TAG_IMAGE_LENGTH);
            c cVar2 = this.zc[i2].get(TAG_IMAGE_WIDTH);
            c cVar3 = this.zc[i3].get(TAG_IMAGE_LENGTH);
            c cVar4 = this.zc[i3].get(TAG_IMAGE_WIDTH);
            if (cVar != null && cVar2 != null && cVar3 != null && cVar4 != null) {
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
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    private static int copy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        int i2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i2;
            }
            i2 += read;
            outputStream.write(bArr, 0, read);
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
}
