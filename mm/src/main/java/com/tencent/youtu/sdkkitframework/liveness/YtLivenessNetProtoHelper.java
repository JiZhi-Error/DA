package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class YtLivenessNetProtoHelper {
    private static final String TAG = YtLivenessNetProtoHelper.class.getSimpleName();

    public static class ActionLiveReqData {
        public String actionStr;
        public String actionVideo;
        public NetBaseInfoData baseInfo;
        public String bestImage;
        public int colorNum;
        public String controlConfig;
        public boolean needEyeDetect;
        public boolean needMoreImage;
        public boolean needMouthDetect;
        public String reflectConfig;
        public ArrayList<SensorData> sensorData;
    }

    public static class ActionReflectLiveReqData {
        public String actionStr;
        public String actionVideo;
        public NetBaseInfoData baseInfo;
        public String colorData;
        public int colorNum;
        public String controlConfig;
        public ImageInfo eyeImage;
        public ImageInfo liveImage;
        public int mode;
        public ImageInfo mouthImage;
        public String reflectConfig;
        public ReflectColorData reflectData;
        public ArrayList<SensorData> sensorData;
    }

    public static class FourLiveReqData {
        public NetBaseInfoData baseInfoData;
        public String validateData;
        public String video;
    }

    public static class GetFourLiveTypeReqData {
        public NetBaseInfoData baseInfo;
    }

    public static class GetLiveTypeReqData {
        public NetBaseInfoData baseInfo;
        public int colorNum;
        public String controlConfig;
        public String reflectConfig;
    }

    public static class LipReadReqData {
        public NetBaseInfoData baseInfo;
        public ImageInfo bestImage;
        public String faceExtraInfo;
        public float[] liveFivePoint;
        public String liveImage;
        public String mouth_lip_reading;
        public String mouth_move;
        public String validate_data;
        public String voice;
    }

    public static class NetBaseInfoData {
        public String appId;
        public String businessId;
        public int liveType;
        public float lux;
        public String personId;
        public String personType;
        public String reqType;
        public String sessionId;
    }

    public static class PictureLiveReqData {
        public NetBaseInfoData baseInfo;
        public ImageInfo imageInfo;
        public ArrayList<SensorData> sensorData;
    }

    public static class ReflectLiveReqData {
        public NetBaseInfoData baseInfo;
        public ImageInfo bestImage;
        public ImageInfo closeEyeImage;
        public String colorData;
        public int colorNum;
        public String config;
        public String liveImage;
        public ImageInfo openMouthImage;
        public ReflectColorData reflectData;
        public ArrayList<SensorData> sensorData;
    }

    public static class SensorData {
        public long capture_time;
        public ArrayList<Float> sensor_data;
        public int type;
    }

    static {
        AppMethodBeat.i(187306);
        AppMethodBeat.o(187306);
    }

    public static class ImageInfo {
        public String checksum;
        public ArrayList<Float> five_points;
        public String image;

        /* JADX WARNING: Removed duplicated region for block: B:20:0x003c A[SYNTHETIC, Splitter:B:20:0x003c] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0041 A[SYNTHETIC, Splitter:B:23:0x0041] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0053 A[SYNTHETIC, Splitter:B:31:0x0053] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0058 A[SYNTHETIC, Splitter:B:34:0x0058] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x005f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void createFileWithByte(java.lang.String r7, byte[] r8) {
            /*
            // Method dump skipped, instructions count: 120
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper.ImageInfo.createFileWithByte(java.lang.String, byte[]):void");
        }

        public ImageInfo(String str, ArrayList<Float> arrayList, String str2) {
            this.image = str;
            this.five_points = arrayList;
            this.checksum = str2;
        }

        public ImageInfo(byte[] bArr, float[] fArr, String str) {
            AppMethodBeat.i(187293);
            this.image = new String(Base64.encode(bArr, 2));
            this.five_points = new ArrayList<>();
            this.checksum = str;
            if (fArr != null) {
                this.five_points.add(Float.valueOf(fArr[176]));
                this.five_points.add(Float.valueOf(fArr[177]));
                this.five_points.add(Float.valueOf(fArr[178]));
                this.five_points.add(Float.valueOf(fArr[179]));
                this.five_points.add(Float.valueOf(fArr[64]));
                this.five_points.add(Float.valueOf(fArr[65]));
                this.five_points.add(Float.valueOf(fArr[90]));
                this.five_points.add(Float.valueOf(fArr[91]));
                this.five_points.add(Float.valueOf(fArr[102]));
                this.five_points.add(Float.valueOf(fArr[103]));
            }
            AppMethodBeat.o(187293);
        }
    }

    static class Version {
        public String faction_sdk_version = "";
        public String freflect_sdk_version = "";
        public String ftrack_sdk_version = "";
        public String sdk_version = "";

        Version() {
        }

        public String makeVersion() {
            AppMethodBeat.i(187296);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("sdk_version:").append(this.sdk_version);
            stringBuffer.append(";ftrack_sdk_version:").append(this.ftrack_sdk_version);
            if (this.freflect_sdk_version != "") {
                stringBuffer.append(";freflect_sdk_version:").append(this.freflect_sdk_version);
            }
            if (this.faction_sdk_version != "") {
                stringBuffer.append(";faction_sdk_version:").append(this.faction_sdk_version);
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(187296);
            return stringBuffer2;
        }
    }

    static class GetFourLiveTypeReq {
        public String app_id;
        public String seq;

        GetFourLiveTypeReq() {
        }
    }

    static class FourLiveReq {
        public String app_id;
        public String compare_image;
        public String validate_data;
        public String video;

        FourLiveReq() {
        }
    }

    static class GetLiveTypeReq {
        public String app_id;
        public String business_name;
        public String person_id;
        public int platform;
        public LiveStyleRequester.SeleceData select_data;
        public String session_id;

        GetLiveTypeReq() {
        }
    }

    static class PictureLiveDetectReq {
        public String app_id;
        public ArrayList<Float> five_point;
        public String image;
        public LiveStyleRequester.SeleceData select_data;
        public String session_id;

        PictureLiveDetectReq() {
        }
    }

    static class ActionLiveReq {
        public String action_str;
        public String action_video;
        public String app_id;
        public String best_image;
        public String business_id;
        public String compare_image;
        public int compare_image_type;
        public boolean do_eye_detect;
        public boolean do_live;
        public boolean do_mouth_detect;
        public boolean get_more_image;
        public LiveStyleRequester.SeleceData select_data;
        public String session_id;

        ActionLiveReq() {
        }
    }

    static class FaceFrame {
        public String image;
        public ArrayList<Float> x_coordinates;
        public ArrayList<Float> y_coordinates;

        FaceFrame() {
        }
    }

    static class PersonLive {
        public String color_data;
        public ArrayList<FaceFrame> frames;
        public String mouth_lip_reading;
        public String mouth_move;
        public int platform;
        public ReflectColorData reflect_data;
        public LiveStyleRequester.SeleceData select_data;
        public ArrayList<SensorData> sensor_data;
        public String validate_data;
        public String voice;

        PersonLive() {
        }
    }

    static class PersonLiveReq {
        public String app_id;
        public ImageInfo best_image;
        public String business_name;
        public int live_type;
        public PersonLive livedata;
        public String mp_business_buffer;
        public String person_id;
        public String person_type;
        public String req_type;
        public String request_id;
        public int scene;

        PersonLiveReq() {
        }
    }

    static class ReflectLiveReq {
        public String app_id;
        public String business_id;
        public String color_data;
        public String compare_image;
        public int compare_image_type;
        public String live_image;
        public int platform;
        public ReflectColorData reflect_data;
        public LiveStyleRequester.SeleceData select_data;
        public String session_id;

        ReflectLiveReq() {
        }
    }

    static class ActionReflectLiveReq {
        public String action_str;
        public String action_video;
        public String app_id;
        public String business_id;
        public String color_data;
        public ImageInfo compare_image;
        public int compare_image_type;
        public ImageInfo eye_image;
        public ImageInfo live_image;
        public int mode;
        public ImageInfo mouth_image;
        public int platform;
        public ReflectColorData reflect_data;
        public LiveStyleRequester.SeleceData select_data;
        public String session_id;

        ActionReflectLiveReq() {
        }
    }

    static class LiveStyleRequester {

        public static class YTLiveStyleReq {
            public String app_id;
            public SeleceData select_data;
        }

        LiveStyleRequester() {
        }

        public static class SeleceData {
            public LiveStyleAndroidData android_data = new LiveStyleAndroidData();
            public int change_point_num = 2;
            public String client_version;
            public String config;
            public int platform = 2;
            public int protocal = 1;
            public String reflect_param;
            public ArrayList<SensorData> sensor_data;
            public String version = YTAGReflectLiveCheckInterface.VERSION;

            public SeleceData(float f2, int i2, String str, String str2, String str3) {
                AppMethodBeat.i(187295);
                this.android_data.lux = f2;
                this.change_point_num = i2;
                if (str != null && str.length() > 0) {
                    this.reflect_param = str;
                }
                if (str3 != null && str3.length() > 0) {
                    this.config = str3;
                }
                this.client_version = str2;
                AppMethodBeat.o(187295);
            }
        }

        public static class LiveStyleAndroidData {
            public String android_apilevel = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
            public String android_version = Build.VERSION.RELEASE;
            public String build_brand = Build.BRAND;
            public String build_device = Build.DEVICE;
            public String build_display = Build.DISPLAY;
            public String build_hardware = Build.HARDWARE;
            public String build_model = Build.MODEL;
            public String build_product = Build.PRODUCT;
            public float lux = 0.0f;

            public LiveStyleAndroidData() {
                AppMethodBeat.i(187294);
                AppMethodBeat.o(187294);
            }
        }
    }

    public static String makeGetFourLiveReq(GetFourLiveTypeReqData getFourLiveTypeReqData) {
        AppMethodBeat.i(187297);
        GetFourLiveTypeReq getFourLiveTypeReq = new GetFourLiveTypeReq();
        getFourLiveTypeReq.app_id = getFourLiveTypeReqData.baseInfo.appId;
        String json = new WeJson().toJson(getFourLiveTypeReq);
        AppMethodBeat.o(187297);
        return json;
    }

    public static String makeFourLiveReq(FourLiveReqData fourLiveReqData) {
        AppMethodBeat.i(187298);
        FourLiveReq fourLiveReq = new FourLiveReq();
        fourLiveReq.app_id = fourLiveReqData.baseInfoData.appId;
        fourLiveReq.validate_data = fourLiveReqData.validateData;
        fourLiveReq.video = fourLiveReqData.video;
        Bitmap bitmap = YtFSM.getInstance().getContext().imageToCompare;
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream);
            fourLiveReq.compare_image = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 2));
        }
        String json = new WeJson().toJson(fourLiveReq);
        AppMethodBeat.o(187298);
        return json;
    }

    public static String makeGetLiveTypeReq(GetLiveTypeReqData getLiveTypeReqData) {
        AppMethodBeat.i(187299);
        GetLiveTypeReq getLiveTypeReq = new GetLiveTypeReq();
        getLiveTypeReq.app_id = getLiveTypeReqData.baseInfo.appId;
        getLiveTypeReq.business_name = getLiveTypeReqData.baseInfo.businessId;
        getLiveTypeReq.person_id = getLiveTypeReqData.baseInfo.personId;
        getLiveTypeReq.platform = 2;
        getLiveTypeReq.session_id = getLiveTypeReqData.baseInfo.sessionId;
        Version version = new Version();
        version.sdk_version = YtSDKKitFramework.getInstance().version();
        version.ftrack_sdk_version = YTFaceTrack.Version;
        if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
            version.faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
        }
        version.freflect_sdk_version = YTAGReflectLiveCheckInterface.VERSION;
        getLiveTypeReq.select_data = new LiveStyleRequester.SeleceData(getLiveTypeReqData.baseInfo.lux, getLiveTypeReqData.colorNum, getLiveTypeReqData.reflectConfig, version.makeVersion(), getLiveTypeReqData.controlConfig);
        String json = new WeJson().toJson(getLiveTypeReq);
        AppMethodBeat.o(187299);
        return json;
    }

    public static String makePictureLiveReq(PictureLiveReqData pictureLiveReqData) {
        AppMethodBeat.i(187300);
        PictureLiveDetectReq pictureLiveDetectReq = new PictureLiveDetectReq();
        pictureLiveDetectReq.app_id = pictureLiveReqData.baseInfo.appId;
        pictureLiveDetectReq.session_id = pictureLiveReqData.baseInfo.sessionId;
        pictureLiveDetectReq.five_point = pictureLiveReqData.imageInfo.five_points;
        pictureLiveDetectReq.image = pictureLiveReqData.imageInfo.image;
        Version version = new Version();
        version.sdk_version = YtSDKKitFramework.getInstance().version();
        version.ftrack_sdk_version = YTFaceTrack.Version;
        version.freflect_sdk_version = YTAGReflectLiveCheckInterface.VERSION;
        pictureLiveDetectReq.select_data = new LiveStyleRequester.SeleceData(pictureLiveReqData.baseInfo.lux, 0, "", version.makeVersion(), "");
        String json = new WeJson().toJson(pictureLiveDetectReq);
        AppMethodBeat.o(187300);
        return json;
    }

    public static String makeLipReadReq(LipReadReqData lipReadReqData) {
        AppMethodBeat.i(187301);
        PersonLiveReq personLiveReq = new PersonLiveReq();
        personLiveReq.app_id = lipReadReqData.baseInfo.appId;
        personLiveReq.business_name = lipReadReqData.baseInfo.businessId;
        personLiveReq.person_id = lipReadReqData.baseInfo.personId;
        personLiveReq.livedata = new PersonLive();
        Version version = new Version();
        version.sdk_version = YtSDKKitFramework.getInstance().version();
        version.ftrack_sdk_version = YTFaceTrack.Version;
        version.freflect_sdk_version = YTAGReflectLiveCheckInterface.VERSION;
        personLiveReq.livedata.select_data = new LiveStyleRequester.SeleceData(lipReadReqData.baseInfo.lux, 0, "", version.makeVersion(), "");
        personLiveReq.livedata.frames = new ArrayList<>();
        FaceFrame faceFrame = new FaceFrame();
        faceFrame.image = lipReadReqData.liveImage;
        faceFrame.x_coordinates = new ArrayList<>();
        faceFrame.y_coordinates = new ArrayList<>();
        for (int i2 = 0; i2 < 5; i2++) {
            faceFrame.x_coordinates.add(Float.valueOf(lipReadReqData.liveFivePoint[i2 * 2]));
            faceFrame.y_coordinates.add(Float.valueOf(lipReadReqData.liveFivePoint[(i2 * 2) + 1]));
        }
        personLiveReq.livedata.frames.add(faceFrame);
        try {
            JSONObject jSONObject = new JSONObject(lipReadReqData.faceExtraInfo);
            FaceFrame faceFrame2 = new FaceFrame();
            faceFrame2.image = jSONObject.getString("openmouth_img");
            faceFrame2.x_coordinates = new ArrayList<>();
            faceFrame2.y_coordinates = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("openmouth_5pts");
            for (int i3 = 0; i3 < 5; i3++) {
                faceFrame2.x_coordinates.add(Float.valueOf((float) jSONArray.optDouble(i3 * 2)));
                faceFrame2.y_coordinates.add(Float.valueOf((float) jSONArray.optDouble((i3 * 2) + 1)));
            }
            personLiveReq.livedata.frames.add(faceFrame2);
            FaceFrame faceFrame3 = new FaceFrame();
            faceFrame3.image = jSONObject.getString("closeeye_img");
            faceFrame3.x_coordinates = new ArrayList<>();
            faceFrame3.y_coordinates = new ArrayList<>();
            JSONArray jSONArray2 = jSONObject.getJSONArray("closeeye_5pts");
            for (int i4 = 0; i4 < 5; i4++) {
                faceFrame3.x_coordinates.add(Float.valueOf((float) jSONArray2.optDouble(i4 * 2)));
                faceFrame3.y_coordinates.add(Float.valueOf((float) jSONArray2.optDouble((i4 * 2) + 1)));
            }
            personLiveReq.livedata.frames.add(faceFrame3);
        } catch (Exception e2) {
            YtLogger.e(TAG, "Failed parse extra face list " + e2.getLocalizedMessage());
        }
        personLiveReq.livedata.validate_data = lipReadReqData.validate_data;
        personLiveReq.livedata.voice = lipReadReqData.voice;
        personLiveReq.livedata.mouth_move = lipReadReqData.mouth_move;
        personLiveReq.livedata.mouth_lip_reading = lipReadReqData.mouth_lip_reading;
        personLiveReq.livedata.platform = 2;
        personLiveReq.person_type = lipReadReqData.baseInfo.personType;
        personLiveReq.live_type = lipReadReqData.baseInfo.liveType;
        personLiveReq.req_type = lipReadReqData.baseInfo.reqType;
        String json = new WeJson().toJson(personLiveReq);
        AppMethodBeat.o(187301);
        return json;
    }

    public static String makeActionLiveReq(ActionLiveReqData actionLiveReqData) {
        AppMethodBeat.i(187302);
        ActionLiveReq actionLiveReq = new ActionLiveReq();
        actionLiveReq.app_id = actionLiveReqData.baseInfo.appId;
        actionLiveReq.session_id = actionLiveReqData.baseInfo.sessionId;
        actionLiveReq.business_id = actionLiveReqData.baseInfo.businessId;
        Version version = new Version();
        version.sdk_version = YtSDKKitFramework.getInstance().version();
        version.ftrack_sdk_version = YTFaceTrack.Version;
        version.faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
        actionLiveReq.select_data = new LiveStyleRequester.SeleceData(actionLiveReqData.baseInfo.lux, actionLiveReqData.colorNum, actionLiveReqData.reflectConfig, version.makeVersion(), actionLiveReqData.controlConfig);
        actionLiveReq.action_str = actionLiveReqData.actionStr;
        actionLiveReq.action_video = actionLiveReqData.actionVideo;
        actionLiveReq.best_image = actionLiveReqData.bestImage;
        actionLiveReq.do_eye_detect = actionLiveReqData.needEyeDetect;
        actionLiveReq.do_mouth_detect = actionLiveReqData.needMouthDetect;
        actionLiveReq.do_live = true;
        Bitmap bitmap = YtFSM.getInstance().getContext().imageToCompare;
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream);
            actionLiveReq.compare_image = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 2));
            actionLiveReq.compare_image_type = YtFSM.getInstance().getContext().imageToComapreType;
        }
        String json = new WeJson().toJson(actionLiveReq);
        AppMethodBeat.o(187302);
        return json;
    }

    public static String makeReflectLiveReq(ReflectLiveReqData reflectLiveReqData) {
        AppMethodBeat.i(187303);
        ReflectLiveReq reflectLiveReq = new ReflectLiveReq();
        reflectLiveReq.app_id = reflectLiveReqData.baseInfo.appId;
        reflectLiveReq.session_id = reflectLiveReqData.baseInfo.sessionId;
        reflectLiveReq.business_id = reflectLiveReqData.baseInfo.businessId;
        reflectLiveReq.platform = 2;
        reflectLiveReq.color_data = reflectLiveReqData.colorData;
        reflectLiveReq.live_image = reflectLiveReqData.liveImage;
        reflectLiveReq.reflect_data = reflectLiveReqData.reflectData;
        Version version = new Version();
        version.sdk_version = YtSDKKitFramework.getInstance().version();
        version.ftrack_sdk_version = YTFaceTrack.Version;
        version.freflect_sdk_version = YTAGReflectLiveCheckInterface.VERSION;
        reflectLiveReq.select_data = new LiveStyleRequester.SeleceData(reflectLiveReqData.baseInfo.lux, reflectLiveReqData.colorNum, reflectLiveReqData.config, version.makeVersion(), "");
        Bitmap bitmap = YtFSM.getInstance().getContext().imageToCompare;
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream);
            reflectLiveReq.compare_image = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 2));
            reflectLiveReq.compare_image_type = YtFSM.getInstance().getContext().imageToComapreType;
        }
        String json = new WeJson().toJson(reflectLiveReq);
        AppMethodBeat.o(187303);
        return json;
    }

    public static String makePersonLiveReq(ReflectLiveReqData reflectLiveReqData) {
        AppMethodBeat.i(187304);
        PersonLiveReq personLiveReq = new PersonLiveReq();
        personLiveReq.app_id = reflectLiveReqData.baseInfo.appId;
        personLiveReq.business_name = reflectLiveReqData.baseInfo.businessId;
        personLiveReq.person_id = reflectLiveReqData.baseInfo.personId;
        personLiveReq.live_type = reflectLiveReqData.baseInfo.liveType;
        personLiveReq.req_type = reflectLiveReqData.baseInfo.reqType;
        personLiveReq.request_id = reflectLiveReqData.baseInfo.sessionId;
        personLiveReq.person_type = reflectLiveReqData.baseInfo.personType;
        personLiveReq.livedata = new PersonLive();
        Version version = new Version();
        version.sdk_version = YtSDKKitFramework.getInstance().version();
        version.ftrack_sdk_version = YTFaceTrack.Version;
        version.freflect_sdk_version = YTAGReflectLiveCheckInterface.VERSION;
        String makeVersion = version.makeVersion();
        personLiveReq.livedata.select_data = new LiveStyleRequester.SeleceData(reflectLiveReqData.baseInfo.lux, reflectLiveReqData.colorNum, reflectLiveReqData.config, makeVersion, "");
        personLiveReq.livedata.reflect_data = reflectLiveReqData.reflectData;
        personLiveReq.livedata.color_data = reflectLiveReqData.colorData;
        personLiveReq.livedata.platform = 2;
        personLiveReq.livedata.frames = new ArrayList<>();
        FaceFrame faceFrame = new FaceFrame();
        faceFrame.image = reflectLiveReqData.bestImage.image;
        personLiveReq.livedata.frames.add(faceFrame);
        FaceFrame faceFrame2 = new FaceFrame();
        faceFrame2.image = reflectLiveReqData.openMouthImage.image;
        personLiveReq.livedata.frames.add(faceFrame2);
        FaceFrame faceFrame3 = new FaceFrame();
        faceFrame3.image = reflectLiveReqData.openMouthImage.image;
        personLiveReq.livedata.frames.add(faceFrame3);
        String json = new WeJson().toJson(personLiveReq);
        AppMethodBeat.o(187304);
        return json;
    }

    public static String makeActionReflectLiveReq(ActionReflectLiveReqData actionReflectLiveReqData) {
        AppMethodBeat.i(187305);
        ActionReflectLiveReq actionReflectLiveReq = new ActionReflectLiveReq();
        actionReflectLiveReq.app_id = actionReflectLiveReqData.baseInfo.appId;
        actionReflectLiveReq.session_id = actionReflectLiveReqData.baseInfo.sessionId;
        actionReflectLiveReq.business_id = actionReflectLiveReqData.baseInfo.businessId;
        actionReflectLiveReq.platform = 2;
        Version version = new Version();
        version.sdk_version = YtSDKKitFramework.getInstance().version();
        version.ftrack_sdk_version = YTFaceTrack.Version;
        version.faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
        version.freflect_sdk_version = YTAGReflectLiveCheckInterface.VERSION;
        actionReflectLiveReq.select_data = new LiveStyleRequester.SeleceData(actionReflectLiveReqData.baseInfo.lux, actionReflectLiveReqData.colorNum, actionReflectLiveReqData.reflectConfig, version.makeVersion(), actionReflectLiveReqData.controlConfig);
        actionReflectLiveReq.action_video = actionReflectLiveReqData.actionVideo;
        actionReflectLiveReq.color_data = actionReflectLiveReqData.colorData;
        actionReflectLiveReq.action_str = actionReflectLiveReqData.actionStr;
        Bitmap bitmap = YtFSM.getInstance().getContext().imageToCompare;
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream);
            actionReflectLiveReq.compare_image = new ImageInfo(byteArrayOutputStream.toByteArray(), (float[]) null, (String) null);
            actionReflectLiveReq.compare_image_type = YtFSM.getInstance().getContext().imageToComapreType;
        }
        actionReflectLiveReq.live_image = actionReflectLiveReqData.liveImage;
        actionReflectLiveReq.mouth_image = actionReflectLiveReqData.mouthImage;
        actionReflectLiveReq.eye_image = actionReflectLiveReqData.eyeImage;
        actionReflectLiveReq.mode = actionReflectLiveReqData.mode;
        actionReflectLiveReq.reflect_data = actionReflectLiveReqData.reflectData;
        String json = new WeJson().toJson(actionReflectLiveReq);
        AppMethodBeat.o(187305);
        return json;
    }
}
