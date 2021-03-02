package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.json.JSONObject;

public class DetectOnlyState extends YtFSMBaseState {
    private static final String TAG = DetectOnlyState.class.getSimpleName();
    private boolean isLoadResourceOnline = false;
    private int minFaceSize = 80;
    private boolean needBigFaceMode = false;
    private String resourceDownloadPath = "";

    static {
        AppMethodBeat.i(187156);
        AppMethodBeat.o(187156);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void loadStateWith(String str, JSONObject jSONObject) {
        AppMethodBeat.i(187154);
        super.loadStateWith(str, jSONObject);
        try {
            if (jSONObject.has("resource_online")) {
                this.isLoadResourceOnline = jSONObject.getBoolean("resource_online");
            }
            if (jSONObject.has("resource_download_path")) {
                this.resourceDownloadPath = jSONObject.getString("resource_download_path");
            }
            if (jSONObject.has("need_big_face_mode")) {
                this.needBigFaceMode = jSONObject.getBoolean("need_big_face_mode");
            }
            if (jSONObject.has("min_face_size")) {
                this.minFaceSize = jSONObject.getInt("min_face_size");
            }
        } catch (Exception e2) {
            YtLogger.e(TAG, "Failed to parse json:" + e2.getLocalizedMessage());
        }
        if (!this.isLoadResourceOnline) {
            FileUtils.loadLibrary("YTFaceTrackPro2");
        }
        Context context = YtFSM.getInstance().getContext().currentAppContext;
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (this.isLoadResourceOnline) {
            absolutePath = this.resourceDownloadPath;
            YtLogger.i(TAG, "Use online path:".concat(String.valueOf(absolutePath)));
        } else {
            YtLogger.i(TAG, "Use local path:".concat(String.valueOf(absolutePath)));
        }
        String[] strArr = {"net1_18.rpnmodel", "net1_18_bin.rpnproto", "net2_36.rpnmodel", "net2_36_bin.rpnproto"};
        if (!this.isLoadResourceOnline) {
            for (int i2 = 0; i2 < 4; i2++) {
                String str2 = strArr[i2];
                FileUtils.copyAsset(context.getAssets(), "FaceTrackModels/detector/".concat(String.valueOf(str2)), absolutePath + FilePathGenerator.ANDROID_DIR_SEP + str2);
            }
        }
        String[] strArr2 = {"align.rpdm", "align.stb", "align_bin.rpdc", "eye.rpdm", "eye_bin.rpdc"};
        if (!this.isLoadResourceOnline) {
            for (int i3 = 0; i3 < 5; i3++) {
                String str3 = strArr2[i3];
                FileUtils.copyAsset(context.getAssets(), "FaceTrackModels/ufa/".concat(String.valueOf(str3)), absolutePath + FilePathGenerator.ANDROID_DIR_SEP + str3);
            }
        }
        String[] strArr3 = {"rotBasis.bin"};
        if (!this.isLoadResourceOnline) {
            for (int i4 = 0; i4 <= 0; i4++) {
                String str4 = strArr3[i4];
                FileUtils.copyAsset(context.getAssets(), "FaceTrackModels/poseest/".concat(String.valueOf(str4)), absolutePath + FilePathGenerator.ANDROID_DIR_SEP + str4);
            }
        }
        final int GlobalInit = YTFaceTrack.GlobalInit(absolutePath + FilePathGenerator.ANDROID_DIR_SEP);
        if (GlobalInit != 0) {
            YtSDKStats.getInstance().reportError(GlobalInit, "failed to init face trace sdk");
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState.AnonymousClass1 */

                {
                    AppMethodBeat.i(187151);
                    put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                    put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_FACETRACE_INIT_FAILED));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "检测初始化失败" + GlobalInit));
                    AppMethodBeat.o(187151);
                }
            });
            AppMethodBeat.o(187154);
            return;
        }
        YTFaceDetectParam GetFaceDetectParam = YTFaceTrack.getInstance().GetFaceDetectParam();
        YtLogger.i(TAG, "big face mode" + this.needBigFaceMode);
        GetFaceDetectParam.bigger_face_mode = this.needBigFaceMode;
        GetFaceDetectParam.min_face_size = this.minFaceSize;
        YTFaceTrack.getInstance().SetFaceDetectParam(GetFaceDetectParam);
        YTFaceTrackParam GetFaceTrackParam = YTFaceTrack.getInstance().GetFaceTrackParam();
        GetFaceTrackParam.need_pose_estimate = false;
        GetFaceTrackParam.single_detect_mode = true;
        GetFaceTrackParam.detect_interval = -1;
        YTFaceTrack.getInstance().SetFaceTrackParam(GetFaceTrackParam);
        YtLogger.i(TAG, "Detect version:" + YTFaceTrack.Version);
        AppMethodBeat.o(187154);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void update(byte[] bArr, int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(187155);
        super.update(bArr, i2, i3, i4, j2);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        Rect[] GetFaceRect = YTFaceTrack.getInstance().GetFaceRect(YTFaceTrack.getInstance().GetYTImageBitmap(createBitmap, 1));
        if (GetFaceRect == null) {
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_PARAM_ERROR, "detecet failed");
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState.AnonymousClass2 */

                {
                    AppMethodBeat.i(187152);
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                    put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                    put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                    put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_PARAM_ERROR));
                    put("message", "{\"errorcode\":3145728,\"errormsg\":\"检测失败\"}");
                    AppMethodBeat.o(187152);
                }
            });
            AppMethodBeat.o(187155);
            return;
        }
        String str = "[";
        int i5 = 0;
        while (i5 < GetFaceRect.length) {
            String str2 = str + "{\"rect\":{\"x\":" + GetFaceRect[i5].left + ",\"y\":" + GetFaceRect[i5].top + ",\"w\":" + (GetFaceRect[i5].right - GetFaceRect[i5].left) + ",\"h\":" + (GetFaceRect[i5].bottom - GetFaceRect[i5].top) + "}}";
            if (i5 < GetFaceRect.length - 1) {
                str2 = str2 + ",";
            }
            i5++;
            str = str2;
        }
        final String str3 = "{\"errorcode\":0,\"errormsg\":\"OK\",\"face_count\":" + GetFaceRect.length + ",\"face_rects\":" + (str + "]") + "}";
        YtSDKStats.getInstance().reportInfo("errorcode: 0, face_count: " + GetFaceRect.length);
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
            /* class com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState.AnonymousClass3 */

            {
                AppMethodBeat.i(187153);
                put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                put(StateEvent.Name.UI_TIPS, StringCode.RST_SUCCEED);
                put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.SUCCEED);
                put("error_code", 0);
                put("message", str3);
                AppMethodBeat.o(187153);
            }
        });
        AppMethodBeat.o(187155);
    }
}
