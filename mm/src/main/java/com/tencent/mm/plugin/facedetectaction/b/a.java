package com.tencent.mm.plugin.facedetectaction.b;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTFaceUtils;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;

public final class a {
    public int lPd;
    public Camera mCamera;
    public Context mContext;
    public int mDesiredPreviewHeight;
    public int mDesiredPreviewWidth;
    public int sXk;
    public String sXl;
    public TextView sXm;
    public AbstractC1040a sXn;
    public Rect sXo;
    public Rect sXp;
    public int sXq;
    public int sXr;
    YTPoseDetectInterface.PoseDetectOnFrame sXs;
    public boolean sXt;

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.a$a  reason: collision with other inner class name */
    public interface AbstractC1040a {
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static class b {
        private static a sXv = new a((byte) 0);

        static {
            AppMethodBeat.i(104203);
            AppMethodBeat.o(104203);
        }
    }

    private a() {
        this.sXt = false;
    }

    public final void a(byte[] bArr, Camera camera) {
        YTFaceTrack.FaceStatus[] faceStatusArr = null;
        AppMethodBeat.i(258252);
        if (this.sXt && YTFaceTrack.IsInstanceExist()) {
            int rotate = YTCameraSetting.getRotate(this.mContext, this.lPd, 1);
            if (PluginFace.isEnabled()) {
                faceStatusArr = YTFaceTrack.getInstance().DoDetectionProcessYUV(bArr, this.mDesiredPreviewWidth, this.mDesiredPreviewHeight, rotate, null);
            }
            if (faceStatusArr != null) {
                com.tencent.mm.plugin.flash.c.b.axo("faceRecognized");
                YTFaceTrack.FaceStatus faceStatus = faceStatusArr[0];
                if (YTPoseDetectInterface.isDetecting()) {
                    if (faceStatus == null) {
                        Log.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
                        this.sXm.setText(R.string.c6e);
                        AppMethodBeat.o(258252);
                        return;
                    }
                    YTFaceUtils.shelterJudge(faceStatus.pointsVis);
                    if (this.sXs != null) {
                        YTPoseDetectInterface.poseDetect(faceStatus.xys, faceStatus.pointsVis, this.sXk, bArr, camera, faceStatus.pitch, faceStatus.yaw, faceStatus.roll, this.sXs, 0);
                    }
                }
                AppMethodBeat.o(258252);
                return;
            }
            Log.i("MicroMsg.FaceActionLogic", "No face");
        }
        AppMethodBeat.o(258252);
    }
}
