package com.tencent.liteav.videoencoder;

import org.json.JSONArray;

public class TXSVideoEncoderParam {
    public boolean annexb = false;
    public boolean appendSpsPps = true;
    public boolean bLimitFps = false;
    public boolean bMultiRef = false;
    public long baseFrameIndex = 0;
    public long baseGopIndex = 0;
    public int bitrate = 0;
    public boolean enableBFrame = false;
    public boolean enableBlackList = true;
    public boolean enableEGL14 = false;
    public JSONArray encFmt = null;
    public int encodeType = 0;
    public int encoderMode = 1;
    public int encoderProfile = 1;
    public boolean forceSetBitrateMode = false;
    public int fps = 20;
    public boolean fullIFrame = false;
    public Object glContext = null;
    public int gop = 3;
    public int height = 0;
    public boolean isHEVCEncoderEnabled = false;
    public boolean realTime = false;
    public boolean record = false;
    public int streamType = 0;
    public boolean syncOutput = false;
    public int width = 0;
}
