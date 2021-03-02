package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.core.common.TPCodecCapability;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class TPCodecUtils {
    public static final int CAP_AUDIO_AAC = 4;
    public static final int CAP_AUDIO_DDP = 8;
    public static final int CAP_VIDEO_AVC = 1;
    public static final int CAP_VIDEO_HEVC = 2;
    public static final int PLAYER_LEVEL_1 = 1;
    public static final int PLAYER_LEVEL_11 = 11;
    public static final int PLAYER_LEVEL_16 = 16;
    public static final int PLAYER_LEVEL_21 = 21;
    public static final int PLAYER_LEVEL_26 = 26;
    public static final int PLAYER_LEVEL_28 = 28;
    public static final int PLAYER_LEVEL_33 = 33;
    public static final int PLAYER_LEVEL_6 = 6;
    private static final String TAG = "TPCodecUtils";
    private static TPCodecCapability.TPVCodecMaxCapability mAVCMediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    private static TPCodecCapability.TPVCodecMaxCapability mAVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    private static TPCodecCapability.TPVCodecMaxCapability mAVS3WMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    private static Context mApplicationContext = null;
    private static int mAvs3DeviceLevel = -1;
    private static String mCapabilityVersion = "2.10.0.1072.wechat";
    private static String mCapabilityVersionKey = "Capability_version_Key";
    private static HashMap<String, Integer> mCodecCap;
    private static int mFhdAvs3HisiIndex = 14;
    private static int mFhdAvs3QualcommIndex = 58;
    private static String mHDR10CapabilityKey = "HDR10_cap_Key";
    private static String mHDR10PLUSCapabilityKey = "HDR10PLUS_cap_Key";
    private static String mHDRDOLBYVISIONCapabilityKey = "HDRDOLBYVISION_cap_Key";
    private static String mHDRHLGCapabilityKey = "HDRHLG_cap_Key";
    private static TPCodecCapability.TPVCodecMaxCapability mHEVCMediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    private static TPCodecCapability.TPVCodecMaxCapability mHEVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    protected static ArrayList<String> mHWCodecCapList = new ArrayList<>();
    private static String mHWCodecCapListKey = "HW_list_Key";
    private static int mHdHevcHisiIndex = 3;
    private static int mHdHevcMtkIndex = 8;
    private static int mHdHevcQualcommIndex = 20;
    private static int mHdHevcSumsingIndex = 5;
    private static int mHevcDeviceLevel = -1;
    private static boolean mIsFFmpegCapGot = false;
    private static int mIsInBlackListForHardwareDec = -1;
    private static boolean mIsInitDone = false;
    private static boolean mIsLocalCacheEnabled = false;
    private static boolean mIsMediaCodecCapGot = false;
    private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> mMaxVCodecHwCapabilityMap = new HashMap<>();
    private static String mMaxVCodecHwCapabilityMapKey = "HW_CapMap_key";
    private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> mMaxVCodecSwCapabilityMap = new HashMap<>();
    private static String mMaxVCodecSwCapabilityMapKey = "SW_CapMap_key";
    private static boolean mNeedToReprobeDecoderCapability = true;
    private static boolean mNeedToReprobeHDRCapability = true;
    private static int mShdAvs3QualcommIndex = 55;
    private static int mShdHevcHisiIndex = 8;
    private static int mShdHevcMtkIndex = 12;
    private static int mShdHevcQualcommIndex = 32;
    private static int mShdHevcSumsingIndex = 8;
    protected static ArrayList<String> mSoftCodecCapList = new ArrayList<>();
    private static String mSoftCodecCapListKey = "Soft_list_Key";
    private static String mSupportValue = "support";
    private static String mUnsupportValue = "unsupport";
    private static TPCodecCapability.TPVCodecMaxCapability mVP9MediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    private static TPCodecCapability.TPVCodecMaxCapability mVP9SWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    protected static ArrayList<String> mffmpegVCodecCapList = new ArrayList<>();
    private static String mffmpegVCodecCapListKey = "FFmpeg_list_Key";
    private static int sDolbyLevel = -1;
    private static boolean sIsDDPInit = false;
    private static boolean sIsDDPSup = false;
    private static boolean sIsDDSInit = false;
    private static boolean sIsDDSSup = false;

    static {
        AppMethodBeat.i(189731);
        mCodecCap = null;
        HashMap<String, Integer> hashMap = new HashMap<>();
        mCodecCap = hashMap;
        hashMap.put("NX511J", 7);
        mCodecCap.put("Hi3798MV100", 7);
        mCodecCap.put("长虹智能电视", 7);
        mCodecCap.put("Android TV on Tcl 901", 7);
        mCodecCap.put("xt880b", 7);
        TPNativeLog.printLog(2, TAG, "white list init");
        AppMethodBeat.o(189731);
    }

    public static synchronized void init(Context context, boolean z) {
        synchronized (TPCodecUtils.class) {
            AppMethodBeat.i(189695);
            TPNativeLog.printLog(2, TAG, "is local cache enabled:".concat(String.valueOf(z)));
            mApplicationContext = context.getApplicationContext();
            mIsLocalCacheEnabled = z;
            if (z) {
                if (!mCapabilityVersion.equals(getCachedStringInfo(mCapabilityVersionKey))) {
                    mNeedToReprobeDecoderCapability = true;
                    mNeedToReprobeHDRCapability = true;
                    TPNativeLog.printLog(2, TAG, "decoder hw capability not stored, need to reprobe");
                } else {
                    mNeedToReprobeDecoderCapability = false;
                    mNeedToReprobeHDRCapability = false;
                    TPNativeLog.printLog(2, TAG, "decoder hw capability stored, needn't reprobe");
                }
            }
            getDecoderMaxCapabilityMapAsync();
            if (mIsLocalCacheEnabled) {
                cacheStringInfo(mCapabilityVersionKey, mCapabilityVersion);
            }
            AppMethodBeat.o(189695);
        }
    }

    public static synchronized void getDecoderMaxCapabilityMapAsync() {
        synchronized (TPCodecUtils.class) {
            AppMethodBeat.i(189696);
            if (mIsInitDone) {
                TPNativeLog.printLog(2, TAG, "decoder capability already init,return directly!");
                AppMethodBeat.o(189696);
            } else {
                TPNativeLog.printLog(2, TAG, "decoder capability not init,acquire async with create thread!");
                Thread thread = new Thread(new Runnable() {
                    /* class com.tencent.thumbplayer.core.common.TPCodecUtils.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(189694);
                        TPCodecUtils.getMediaCodecMaxCapabilityMap();
                        TPCodecUtils.getVCodecSWMaxCapabilityMap();
                        boolean unused = TPCodecUtils.mNeedToReprobeDecoderCapability = false;
                        boolean unused2 = TPCodecUtils.mIsInitDone = true;
                        TPNativeLog.printLog(2, TPCodecUtils.TAG, "new thread getDecoderMaxCapabilityMap done");
                        AppMethodBeat.o(189694);
                    }
                });
                thread.setName("TP_codec_init_thread");
                thread.start();
                AppMethodBeat.o(189696);
            }
        }
    }

    public static int getHevcSWDecodeLevel() {
        AppMethodBeat.i(189697);
        String cpuHarewareName = TPSystemInfo.getCpuHarewareName();
        int cpuHWProducter = TPSystemInfo.getCpuHWProducter(cpuHarewareName);
        int cpuHWProductIndex = TPSystemInfo.getCpuHWProductIndex(cpuHarewareName);
        TPNativeLog.printLog(2, TAG, "[getHevcSWDecodeLevel], mCpuHWProducter = " + cpuHWProducter + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + cpuHWProductIndex + ", hardware=" + cpuHarewareName);
        if (-1 != mHevcDeviceLevel) {
            int i2 = mHevcDeviceLevel;
            AppMethodBeat.o(189697);
            return i2;
        }
        mHevcDeviceLevel = 0;
        if (-1 != cpuHWProducter) {
            switch (cpuHWProducter) {
                case 0:
                    if (cpuHWProductIndex < mShdHevcQualcommIndex) {
                        if (cpuHWProductIndex < mHdHevcQualcommIndex) {
                            mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
                            break;
                        } else {
                            mHevcDeviceLevel = 16;
                            break;
                        }
                    } else {
                        mHevcDeviceLevel = 21;
                        break;
                    }
                case 1:
                    if (cpuHWProductIndex < mShdHevcMtkIndex) {
                        if (cpuHWProductIndex < mHdHevcMtkIndex) {
                            mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
                            break;
                        } else {
                            mHevcDeviceLevel = 16;
                            break;
                        }
                    } else {
                        mHevcDeviceLevel = 21;
                        break;
                    }
                case 2:
                    if (cpuHWProductIndex < mShdHevcHisiIndex) {
                        if (cpuHWProductIndex < mHdHevcHisiIndex) {
                            mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
                            break;
                        } else {
                            mHevcDeviceLevel = 16;
                            break;
                        }
                    } else {
                        mHevcDeviceLevel = 21;
                        break;
                    }
                case 3:
                    if (cpuHWProductIndex < mShdHevcSumsingIndex) {
                        if (cpuHWProductIndex >= mHdHevcSumsingIndex) {
                            mHevcDeviceLevel = 16;
                            break;
                        }
                    } else {
                        mHevcDeviceLevel = 21;
                        break;
                    }
                    break;
            }
            int i3 = mHevcDeviceLevel;
            AppMethodBeat.o(189697);
            return i3;
        }
        mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        int i32 = mHevcDeviceLevel;
        AppMethodBeat.o(189697);
        return i32;
    }

    public static int getAvs3SWDecodeLevel() {
        AppMethodBeat.i(189698);
        String cpuHarewareName = TPSystemInfo.getCpuHarewareName();
        int cpuHWProducter = TPSystemInfo.getCpuHWProducter(cpuHarewareName);
        int cpuHWProductIndex = TPSystemInfo.getCpuHWProductIndex(cpuHarewareName);
        TPNativeLog.printLog(2, TAG, "[getAvs3SWDecodeLevel], mCpuHWProducter = " + cpuHWProducter + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + cpuHWProductIndex + ", hardware=" + cpuHarewareName);
        if (-1 != mAvs3DeviceLevel) {
            int i2 = mAvs3DeviceLevel;
            AppMethodBeat.o(189698);
            return i2;
        }
        mAvs3DeviceLevel = 0;
        if (-1 != cpuHWProducter) {
            switch (cpuHWProducter) {
                case 0:
                    if (cpuHWProductIndex < mFhdAvs3QualcommIndex) {
                        if (cpuHWProductIndex < mShdAvs3QualcommIndex) {
                            mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
                            break;
                        } else {
                            mAvs3DeviceLevel = 21;
                            break;
                        }
                    } else {
                        mAvs3DeviceLevel = 26;
                        break;
                    }
                case 1:
                    mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
                    break;
                case 2:
                    if (cpuHWProductIndex < mFhdAvs3HisiIndex) {
                        mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
                        break;
                    } else {
                        mAvs3DeviceLevel = 26;
                        break;
                    }
            }
            int i3 = mAvs3DeviceLevel;
            AppMethodBeat.o(189698);
            return i3;
        }
        mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        int i32 = mAvs3DeviceLevel;
        AppMethodBeat.o(189698);
        return i32;
    }

    private static int getDecodeLevelByCoresAndFreq() {
        int i2 = 21;
        AppMethodBeat.i(189699);
        if (TPSystemInfo.getNumCores() >= 8) {
            if (TPSystemInfo.getMaxCpuFreq() / 1000 < 1200) {
                i2 = 16;
            }
        } else if (TPSystemInfo.getNumCores() >= 6) {
            if (TPSystemInfo.getMaxCpuFreq() / 1000 < 1400) {
                i2 = 16;
            }
        } else if (TPSystemInfo.getNumCores() < 4) {
            i2 = 6;
        } else if (TPSystemInfo.getMaxCpuFreq() / 1000 < 1600) {
            i2 = 16;
        }
        AppMethodBeat.o(189699);
        return i2;
    }

    private static <K, T> void replace(K k, T t, HashMap<K, T> hashMap) {
        AppMethodBeat.i(189700);
        if (hashMap.containsKey(k)) {
            hashMap.remove(k);
            hashMap.put(k, t);
            AppMethodBeat.o(189700);
            return;
        }
        hashMap.put(k, t);
        AppMethodBeat.o(189700);
    }

    private static int maxLumaSamplesForAVCProfileLevel(int i2, int i3) {
        int i4;
        AppMethodBeat.i(189701);
        try {
            Class<?> cls = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
            int intValue = ((Integer) cls.getField("AVCLevel1").get(null)).intValue();
            int intValue2 = ((Integer) cls.getField("AVCLevel1b").get(null)).intValue();
            int intValue3 = ((Integer) cls.getField("AVCLevel11").get(null)).intValue();
            int intValue4 = ((Integer) cls.getField("AVCLevel12").get(null)).intValue();
            int intValue5 = ((Integer) cls.getField("AVCLevel13").get(null)).intValue();
            int intValue6 = ((Integer) cls.getField("AVCLevel2").get(null)).intValue();
            int intValue7 = ((Integer) cls.getField("AVCLevel21").get(null)).intValue();
            int intValue8 = ((Integer) cls.getField("AVCLevel22").get(null)).intValue();
            int intValue9 = ((Integer) cls.getField("AVCLevel3").get(null)).intValue();
            int intValue10 = ((Integer) cls.getField("AVCLevel31").get(null)).intValue();
            int intValue11 = ((Integer) cls.getField("AVCLevel32").get(null)).intValue();
            int intValue12 = ((Integer) cls.getField("AVCLevel4").get(null)).intValue();
            int intValue13 = ((Integer) cls.getField("AVCLevel41").get(null)).intValue();
            int intValue14 = ((Integer) cls.getField("AVCLevel42").get(null)).intValue();
            int intValue15 = ((Integer) cls.getField("AVCLevel5").get(null)).intValue();
            int intValue16 = ((Integer) cls.getField("AVCLevel51").get(null)).intValue();
            if (i3 == intValue) {
                i4 = 25344;
            } else if (i3 == intValue2) {
                i4 = 25344;
            } else if (i3 == intValue3) {
                i4 = 101376;
            } else if (i3 == intValue4) {
                i4 = 101376;
            } else if (i3 == intValue5) {
                i4 = 101376;
            } else if (i3 == intValue6) {
                i4 = 101376;
            } else if (i3 == intValue7) {
                i4 = 202752;
            } else if (i3 == intValue8) {
                i4 = 414720;
            } else if (i3 == intValue9) {
                i4 = 414720;
            } else if (i3 == intValue10) {
                i4 = Downloads.SPLIT_RANGE_SIZE_NET;
            } else if (i3 == intValue11) {
                i4 = 1310720;
            } else if (i3 == intValue12) {
                i4 = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
            } else if (i3 == intValue13) {
                i4 = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
            } else if (i3 == intValue14) {
                i4 = 2228224;
            } else if (i3 == intValue15) {
                i4 = 5652480;
            } else {
                if (i3 >= intValue16) {
                    i4 = 9437184;
                }
                i4 = 414720;
            }
        } catch (Exception e2) {
            TPNativeLog.printLog(4, "failed to get avc maxLumaSamples");
            TPNativeLog.printLog(4, e2.getMessage());
        }
        TPNativeLog.printLog(2, "AVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
        AppMethodBeat.o(189701);
        return i4;
    }

    private static int maxLumaSamplesForHEVCProfileLevel(int i2, int i3) {
        int i4;
        AppMethodBeat.i(189702);
        try {
            Class<?> cls = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
            int intValue = ((Integer) cls.getField("HEVCHighTierLevel1").get(null)).intValue();
            int intValue2 = ((Integer) cls.getField("HEVCHighTierLevel2").get(null)).intValue();
            int intValue3 = ((Integer) cls.getField("HEVCHighTierLevel21").get(null)).intValue();
            int intValue4 = ((Integer) cls.getField("HEVCHighTierLevel3").get(null)).intValue();
            int intValue5 = ((Integer) cls.getField("HEVCHighTierLevel31").get(null)).intValue();
            int intValue6 = ((Integer) cls.getField("HEVCHighTierLevel4").get(null)).intValue();
            int intValue7 = ((Integer) cls.getField("HEVCHighTierLevel41").get(null)).intValue();
            int intValue8 = ((Integer) cls.getField("HEVCHighTierLevel5").get(null)).intValue();
            int intValue9 = ((Integer) cls.getField("HEVCHighTierLevel51").get(null)).intValue();
            int intValue10 = ((Integer) cls.getField("HEVCHighTierLevel52").get(null)).intValue();
            int intValue11 = ((Integer) cls.getField("HEVCHighTierLevel6").get(null)).intValue();
            int intValue12 = ((Integer) cls.getField("HEVCHighTierLevel61").get(null)).intValue();
            int intValue13 = ((Integer) cls.getField("HEVCHighTierLevel62").get(null)).intValue();
            int intValue14 = ((Integer) cls.getField("HEVCMainTierLevel1").get(null)).intValue();
            int intValue15 = ((Integer) cls.getField("HEVCMainTierLevel2").get(null)).intValue();
            int intValue16 = ((Integer) cls.getField("HEVCMainTierLevel21").get(null)).intValue();
            int intValue17 = ((Integer) cls.getField("HEVCMainTierLevel3").get(null)).intValue();
            int intValue18 = ((Integer) cls.getField("HEVCMainTierLevel31").get(null)).intValue();
            int intValue19 = ((Integer) cls.getField("HEVCMainTierLevel4").get(null)).intValue();
            int intValue20 = ((Integer) cls.getField("HEVCMainTierLevel41").get(null)).intValue();
            int intValue21 = ((Integer) cls.getField("HEVCMainTierLevel5").get(null)).intValue();
            int intValue22 = ((Integer) cls.getField("HEVCMainTierLevel51").get(null)).intValue();
            int intValue23 = ((Integer) cls.getField("HEVCMainTierLevel52").get(null)).intValue();
            int intValue24 = ((Integer) cls.getField("HEVCMainTierLevel6").get(null)).intValue();
            int intValue25 = ((Integer) cls.getField("HEVCMainTierLevel61").get(null)).intValue();
            int intValue26 = ((Integer) cls.getField("HEVCMainTierLevel62").get(null)).intValue();
            if (i3 == intValue || i3 == intValue14) {
                i4 = 36864;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 == intValue2 || i3 == intValue15) {
                i4 = 122880;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 == intValue3 || i3 == intValue16) {
                i4 = 245760;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 == intValue4 || i3 == intValue17) {
                i4 = 552960;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 == intValue5 || i3 == intValue18) {
                i4 = 983040;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 == intValue6 || i3 == intValue19) {
                i4 = 2228224;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 == intValue7 || i3 == intValue20) {
                i4 = 2228224;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 == intValue8 || i3 == intValue21) {
                i4 = 8912896;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 == intValue9 || i3 == intValue22) {
                i4 = 8912896;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 == intValue10 || i3 == intValue23) {
                i4 = 8912896;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 == intValue11 || i3 == intValue24) {
                i4 = 35651584;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else if (i3 >= intValue12 || i3 == intValue25) {
                i4 = 35651584;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            } else {
                if (i3 >= intValue13 || i3 == intValue26) {
                    i4 = 35651584;
                    TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                    AppMethodBeat.o(189702);
                    return i4;
                }
                i4 = 552960;
                TPNativeLog.printLog(2, "HEVC: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
                AppMethodBeat.o(189702);
                return i4;
            }
        } catch (Exception e2) {
            TPNativeLog.printLog(4, "failed to get hevc maxLumaSamples");
            TPNativeLog.printLog(4, e2.getMessage());
        }
    }

    private static int maxLumaSamplesForVP9ProfileLevel(int i2, int i3) {
        int i4;
        AppMethodBeat.i(189703);
        try {
            Class<?> cls = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
            int intValue = ((Integer) cls.getField("VP9Level1").get(null)).intValue();
            int intValue2 = ((Integer) cls.getField("VP9Level11").get(null)).intValue();
            int intValue3 = ((Integer) cls.getField("VP9Level2").get(null)).intValue();
            int intValue4 = ((Integer) cls.getField("VP9Level21").get(null)).intValue();
            int intValue5 = ((Integer) cls.getField("VP9Level3").get(null)).intValue();
            int intValue6 = ((Integer) cls.getField("VP9Level31").get(null)).intValue();
            int intValue7 = ((Integer) cls.getField("VP9Level4").get(null)).intValue();
            int intValue8 = ((Integer) cls.getField("VP9Level41").get(null)).intValue();
            int intValue9 = ((Integer) cls.getField("VP9Level5").get(null)).intValue();
            int intValue10 = ((Integer) cls.getField("VP9Level51").get(null)).intValue();
            int intValue11 = ((Integer) cls.getField("VP9Level52").get(null)).intValue();
            int intValue12 = ((Integer) cls.getField("VP9Level6").get(null)).intValue();
            int intValue13 = ((Integer) cls.getField("VP9Level61").get(null)).intValue();
            int intValue14 = ((Integer) cls.getField("VP9Level62").get(null)).intValue();
            if (i3 == intValue) {
                i4 = 36864;
            } else if (i3 == intValue2) {
                i4 = 73728;
            } else if (i3 == intValue3) {
                i4 = 122880;
            } else if (i3 == intValue4) {
                i4 = 245760;
            } else if (i3 == intValue5) {
                i4 = 552960;
            } else if (i3 == intValue6) {
                i4 = 983040;
            } else if (i3 == intValue7) {
                i4 = 2228224;
            } else if (i3 == intValue8) {
                i4 = 2228224;
            } else if (i3 == intValue9) {
                i4 = 8912896;
            } else if (i3 == intValue10) {
                i4 = 8912896;
            } else if (i3 == intValue11) {
                i4 = 8912896;
            } else if (i3 == intValue12) {
                i4 = 35651584;
            } else if (i3 == intValue13) {
                i4 = 35651584;
            } else {
                if (i3 == intValue14) {
                    i4 = 35651584;
                }
                i4 = 552960;
            }
        } catch (Exception e2) {
            TPNativeLog.printLog(4, "failed to get vp9 maxLumaSamples");
            TPNativeLog.printLog(4, e2.getMessage());
        }
        TPNativeLog.printLog(2, "VP9: maxprofile :" + i2 + " , maxlevel :" + i3 + " , maxSample : " + i4);
        AppMethodBeat.o(189703);
        return i4;
    }

    private static int getSoftMaxSamples(int i2) {
        switch (i2) {
            case 1:
                return 129600;
            case 6:
                return 307200;
            case 11:
            default:
                return 407040;
            case 16:
                return 480000;
            case 21:
                return Downloads.SPLIT_RANGE_SIZE_NET;
            case 26:
                return 2073600;
            case 28:
                return 8294400;
            case 33:
                return 8847360;
        }
    }

    public static int getMaxSupportedFrameRatesFor(int i2, int i3, int i4, int i5) {
        int intValue;
        int intValue2;
        AppMethodBeat.i(189704);
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(189704);
            return 30;
        } else if (i2 == 101) {
            AppMethodBeat.o(189704);
            return 30;
        } else {
            try {
                int codecCount = MediaCodecList.getCodecCount();
                for (int i6 = 0; i6 < codecCount; i6++) {
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i6);
                    if (!codecInfoAt.isEncoder()) {
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        for (String str : supportedTypes) {
                            if (str.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                                Range<Double> supportedFrameRatesFor = codecInfoAt.getCapabilitiesForType(TPDecoderType.TP_CODEC_MIMETYPE_HEVC).getVideoCapabilities().getSupportedFrameRatesFor(i4, i5);
                                if (i3 == 172) {
                                    if (supportedFrameRatesFor.getUpper().intValue() % 10 == 0) {
                                        intValue2 = supportedFrameRatesFor.getUpper().intValue();
                                    } else {
                                        intValue2 = supportedFrameRatesFor.getUpper().intValue() + 1;
                                    }
                                    AppMethodBeat.o(189704);
                                    return intValue2;
                                }
                            } else if (str.equalsIgnoreCase("video/avc")) {
                                Range<Double> supportedFrameRatesFor2 = codecInfoAt.getCapabilitiesForType("video/avc").getVideoCapabilities().getSupportedFrameRatesFor(i4, i5);
                                if (i3 == 26) {
                                    if (supportedFrameRatesFor2.getUpper().intValue() % 10 == 0) {
                                        intValue = supportedFrameRatesFor2.getUpper().intValue();
                                    } else {
                                        intValue = supportedFrameRatesFor2.getUpper().intValue() + 1;
                                    }
                                    AppMethodBeat.o(189704);
                                    return intValue;
                                }
                            } else {
                                continue;
                            }
                        }
                        continue;
                    }
                }
            } catch (Throwable th) {
                TPNativeLog.printLog(4, TAG, "getSupportedFrameRatesFor func failed:" + th.toString());
            }
            AppMethodBeat.o(189704);
            return 30;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x03b3, code lost:
        cacheCapList(com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapListKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapList);
        cacheCapabilityMap(com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMapKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap);
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, com.tencent.thumbplayer.core.common.TPCodecUtils.TAG, "mediacodec capability try to cache to local");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x03cb, code lost:
        com.tencent.thumbplayer.core.common.TPCodecUtils.mIsMediaCodecCapGot = true;
        r2 = com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap;
        com.tencent.matrix.trace.core.AppMethodBeat.o(189705);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x03f7, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x03f8, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(4, "getMediaCodecMaxCapabilityMap , catch an exception : " + r2.getMessage());
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, "getMediaCodecMaxCapabilityMap success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0419, code lost:
        if (com.tencent.thumbplayer.core.common.TPCodecUtils.mIsLocalCacheEnabled != false) goto L_0x041b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x041b, code lost:
        cacheCapList(com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapListKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapList);
        cacheCapabilityMap(com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMapKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap);
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, com.tencent.thumbplayer.core.common.TPCodecUtils.TAG, "mediacodec capability try to cache to local");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0433, code lost:
        com.tencent.thumbplayer.core.common.TPCodecUtils.mIsMediaCodecCapGot = true;
        r2 = com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap;
        com.tencent.matrix.trace.core.AppMethodBeat.o(189705);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x044a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x044b, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(4, "getMediaCodecMaxCapabilityMap , catch an exception : " + r2.getMessage());
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, "getMediaCodecMaxCapabilityMap success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x046c, code lost:
        if (com.tencent.thumbplayer.core.common.TPCodecUtils.mIsLocalCacheEnabled != false) goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x046e, code lost:
        cacheCapList(com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapListKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapList);
        cacheCapabilityMap(com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMapKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap);
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, com.tencent.thumbplayer.core.common.TPCodecUtils.TAG, "mediacodec capability try to cache to local");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0486, code lost:
        com.tencent.thumbplayer.core.common.TPCodecUtils.mIsMediaCodecCapGot = true;
        r2 = com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap;
        com.tencent.matrix.trace.core.AppMethodBeat.o(189705);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x050c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x050d, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(4, "getMediaCodecMaxCapabilityMap , catch an exception : " + r2.getMessage());
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, "getMediaCodecMaxCapabilityMap success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x052e, code lost:
        if (com.tencent.thumbplayer.core.common.TPCodecUtils.mIsLocalCacheEnabled != false) goto L_0x0530;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0530, code lost:
        cacheCapList(com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapListKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapList);
        cacheCapabilityMap(com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMapKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap);
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, com.tencent.thumbplayer.core.common.TPCodecUtils.TAG, "mediacodec capability try to cache to local");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0548, code lost:
        com.tencent.thumbplayer.core.common.TPCodecUtils.mIsMediaCodecCapGot = true;
        r2 = com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap;
        com.tencent.matrix.trace.core.AppMethodBeat.o(189705);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0573, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0574, code lost:
        r6 = true;
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(4, "getMediaCodec hevc MaxCapabilityMap , catch an exception : " + r3.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0638, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0639, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(4, "getMediaCodecMaxCapabilityMap , catch an exception : " + r2.getMessage());
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, "getMediaCodecMaxCapabilityMap success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x065a, code lost:
        if (com.tencent.thumbplayer.core.common.TPCodecUtils.mIsLocalCacheEnabled != false) goto L_0x065c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x065c, code lost:
        cacheCapList(com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapListKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapList);
        cacheCapabilityMap(com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMapKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap);
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, com.tencent.thumbplayer.core.common.TPCodecUtils.TAG, "mediacodec capability try to cache to local");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0674, code lost:
        com.tencent.thumbplayer.core.common.TPCodecUtils.mIsMediaCodecCapGot = true;
        r2 = com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap;
        com.tencent.matrix.trace.core.AppMethodBeat.o(189705);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x06a1, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, "getMediaCodecMaxCapabilityMap success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x06aa, code lost:
        if (com.tencent.thumbplayer.core.common.TPCodecUtils.mIsLocalCacheEnabled != false) goto L_0x06ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x06ac, code lost:
        cacheCapList(com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapListKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapList);
        cacheCapabilityMap(com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMapKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap);
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, com.tencent.thumbplayer.core.common.TPCodecUtils.TAG, "mediacodec capability try to cache to local");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x06c4, code lost:
        com.tencent.thumbplayer.core.common.TPCodecUtils.mIsMediaCodecCapGot = true;
        r2 = com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap;
        com.tencent.matrix.trace.core.AppMethodBeat.o(189705);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x07ed, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x07ee, code lost:
        r5 = true;
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(4, "getMediaCodec vp9 MaxCapabilityMap , catch an exception : " + r3.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0840, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0841, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(4, "getMediaCodecMaxCapabilityMap , catch an exception : " + r2.getMessage());
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, "getMediaCodecMaxCapabilityMap success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0862, code lost:
        if (com.tencent.thumbplayer.core.common.TPCodecUtils.mIsLocalCacheEnabled != false) goto L_0x0864;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0864, code lost:
        cacheCapList(com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapListKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mHWCodecCapList);
        cacheCapabilityMap(com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMapKey, com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap);
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, com.tencent.thumbplayer.core.common.TPCodecUtils.TAG, "mediacodec capability try to cache to local");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x087c, code lost:
        com.tencent.thumbplayer.core.common.TPCodecUtils.mIsMediaCodecCapGot = true;
        r2 = com.tencent.thumbplayer.core.common.TPCodecUtils.mMaxVCodecHwCapabilityMap;
        com.tencent.matrix.trace.core.AppMethodBeat.o(189705);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x038f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(4, "getMediaCodecMaxCapabilityMap , catch an exception : " + r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x03a8, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, "getMediaCodecMaxCapabilityMap success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x03b1, code lost:
        if (com.tencent.thumbplayer.core.common.TPCodecUtils.mIsLocalCacheEnabled != false) goto L_0x03b3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x03f7 A[ExcHandler: NoSuchMethodException (r2v49 'e' java.lang.NoSuchMethodException A[CUSTOM_DECLARE]), Splitter:B:37:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x044a A[ExcHandler: IllegalAccessException (r2v38 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:37:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x050c A[ExcHandler: NoSuchFieldException (r2v27 'e' java.lang.NoSuchFieldException A[CUSTOM_DECLARE]), Splitter:B:37:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0638 A[ExcHandler: ClassNotFoundException (r2v16 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:37:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x038f A[ExcHandler: InvocationTargetException (r2v60 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:37:0x00bd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.HashMap<java.lang.Integer, com.tencent.thumbplayer.core.common.TPCodecCapability.TPVCodecMaxCapability> getMediaCodecMaxCapabilityMap() {
        /*
        // Method dump skipped, instructions count: 2185
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPCodecUtils.getMediaCodecMaxCapabilityMap():java.util.HashMap");
    }

    public static synchronized HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecSWMaxCapabilityMap() {
        HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> hashMap;
        synchronized (TPCodecUtils.class) {
            AppMethodBeat.i(189706);
            TPNativeLog.printLog(2, TAG, "getVCodecSWMaxCapabilityMap func in");
            if (mIsFFmpegCapGot) {
                hashMap = mMaxVCodecSwCapabilityMap;
                AppMethodBeat.o(189706);
            } else {
                try {
                    int hevcSWDecodeLevel = getHevcSWDecodeLevel();
                    int softMaxSamples = getSoftMaxSamples(hevcSWDecodeLevel);
                    int avs3SWDecodeLevel = getAvs3SWDecodeLevel();
                    int softMaxSamples2 = getSoftMaxSamples(avs3SWDecodeLevel);
                    TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMap hevcDecodeLevel:" + hevcSWDecodeLevel + " avs3DecodeLevel:" + avs3SWDecodeLevel);
                    mAVCSWMaxCapability.maxLumaSamples = softMaxSamples;
                    mAVCSWMaxCapability.maxProfile = 64;
                    mAVCSWMaxCapability.maxLevel = 65536;
                    mMaxVCodecSwCapabilityMap.put(26, mAVCSWMaxCapability);
                    mffmpegVCodecCapList.add("video/avc");
                    mHEVCSWMaxCapability.maxLumaSamples = softMaxSamples;
                    mHEVCSWMaxCapability.maxProfile = 2;
                    mHEVCSWMaxCapability.maxLevel = TPMediaCodecProfileLevel.HEVCHighTierLevel62;
                    mMaxVCodecSwCapabilityMap.put(172, mHEVCSWMaxCapability);
                    mffmpegVCodecCapList.add(TPDecoderType.TP_CODEC_MIMETYPE_HEVC);
                    mVP9SWMaxCapability.maxLumaSamples = softMaxSamples;
                    mVP9SWMaxCapability.maxProfile = 8;
                    mVP9SWMaxCapability.maxLevel = 8192;
                    mMaxVCodecSwCapabilityMap.put(166, mVP9SWMaxCapability);
                    mffmpegVCodecCapList.add(TPDecoderType.TP_CODEC_MIMETYPE_VP9);
                    mAVS3WMaxCapability.maxLumaSamples = softMaxSamples2;
                    mAVS3WMaxCapability.maxProfile = 0;
                    mAVS3WMaxCapability.maxLevel = 0;
                    mMaxVCodecSwCapabilityMap.put(192, mAVS3WMaxCapability);
                    TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMap success, maxHevcLumaSamples:" + softMaxSamples + " maxAvs3LumaSamples:" + softMaxSamples2);
                    mIsFFmpegCapGot = true;
                    hashMap = mMaxVCodecSwCapabilityMap;
                    AppMethodBeat.o(189706);
                } catch (Exception e2) {
                    TPNativeLog.printLog(4, TAG, "getVCodecSWMaxCapabilityMap exception");
                    hashMap = null;
                    AppMethodBeat.o(189706);
                }
            }
        }
        return hashMap;
    }

    public static boolean isHwSupportDDPlus() {
        AppMethodBeat.i(189707);
        if (mHWCodecCapList != null && mHWCodecCapList.size() > 0 && (mHWCodecCapList.contains("audio/eac3") || mHWCodecCapList.contains("audio/ac3"))) {
            AppMethodBeat.o(189707);
            return true;
        } else if (mSoftCodecCapList == null || mSoftCodecCapList.size() <= 0 || (!mSoftCodecCapList.contains("audio/eac3") && !mSoftCodecCapList.contains("audio/ac3"))) {
            AppMethodBeat.o(189707);
            return false;
        } else {
            AppMethodBeat.o(189707);
            return true;
        }
    }

    public static boolean isInMediaCodecWhiteList(String str, int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(189708);
        String str2 = Build.MODEL;
        if (TextUtils.isEmpty(str2) || mCodecCap == null || !mCodecCap.containsKey(str2)) {
            AppMethodBeat.o(189708);
            return false;
        }
        Integer num = mCodecCap.get(str2);
        if (TextUtils.equals(str, "video/avc")) {
            z = (num.intValue() & 1) != 0;
        } else if (TextUtils.equals(str, TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
            if ((num.intValue() & 2) == 0) {
                z = false;
            }
        } else if (TextUtils.equals(str, EncoderWriter.OUTPUT_AUDIO_MIME_TYPE)) {
            if ((num.intValue() & 4) == 0) {
                z = false;
            }
        } else if (!TextUtils.equals(str, "audio/eac3") && !TextUtils.equals(str, "audio/ac3")) {
            z = false;
        } else if ((num.intValue() & 8) == 0) {
            z = false;
        }
        AppMethodBeat.o(189708);
        return z;
    }

    public static boolean isBlackListForHardwareDec(String str) {
        AppMethodBeat.i(189709);
        if (mIsInBlackListForHardwareDec == -1) {
            String[] strArr = {"SM-J7008", "SM-J5008", "TCL i806", "NX511J", "vivo Y11i T", "长虹智能电视", "MI 1S", "SP9832A", "SP9830A", "VOTO GT17", "EVA-AL10"};
            mIsInBlackListForHardwareDec = 0;
            try {
                String str2 = Build.MODEL;
                if (!TextUtils.isEmpty(str2)) {
                    for (int i2 = 0; i2 < 11; i2++) {
                        if (strArr[i2].equals(str2)) {
                            TPNativeLog.printLog(2, TAG, "isBlackListForHardwareDec, deviceName: ".concat(String.valueOf(str2)));
                            mIsInBlackListForHardwareDec = 1;
                            AppMethodBeat.o(189709);
                            return true;
                        }
                    }
                }
                if (!TextUtils.isEmpty(str) && TPDecoderType.TP_CODEC_MIMETYPE_HEVC.equals(str) && Build.VERSION.SDK_INT >= 14 && !TextUtils.isEmpty(str2) && ("PRO 7 Plus".equals(str2) || "PRO 7-H".equals(str2) || "PRO+7+Plus".equals(str2))) {
                    mIsInBlackListForHardwareDec = 1;
                    AppMethodBeat.o(189709);
                    return true;
                }
            } catch (Exception e2) {
                TPNativeLog.printLog(4, TAG, "isBlackListForHardwareDec exception");
            }
            AppMethodBeat.o(189709);
            return false;
        } else if (mIsInBlackListForHardwareDec == 0) {
            AppMethodBeat.o(189709);
            return false;
        } else {
            AppMethodBeat.o(189709);
            return true;
        }
    }

    public static boolean isHwDDPlusSupported_V2() {
        boolean z = false;
        AppMethodBeat.i(189710);
        if (isBlackListForHardwareDec(null)) {
            sIsDDPSup = false;
            AppMethodBeat.o(189710);
        } else {
            try {
                z = isHwSupportDDPlus();
            } catch (Exception e2) {
            }
            sIsDDPSup = z;
            AppMethodBeat.o(189710);
        }
        return z;
    }

    public static boolean isHwDolbyDSSupported() {
        String str;
        boolean z;
        AppMethodBeat.i(189711);
        if (sIsDDSInit) {
            if (sIsDDSSup) {
                TPNativeLog.printLog(2, TAG, "dds ha suported " + sIsDDSSup);
            }
            boolean z2 = sIsDDSSup;
            AppMethodBeat.o(189711);
            return z2;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class).invoke(cls, "dolby.ds.state");
        } catch (Exception e2) {
            TPNativeLog.printLog(4, TAG, e2.getMessage());
            str = null;
        }
        if (str == null || (str != null && str.trim().equals(""))) {
            z = false;
        } else {
            z = true;
        }
        sIsDDSSup = z;
        sIsDDSInit = true;
        if (sIsDDSSup) {
            TPNativeLog.printLog(2, TAG, "dds ha suported " + sIsDDSSup);
        }
        boolean z3 = sIsDDSSup;
        AppMethodBeat.o(189711);
        return z3;
    }

    public static boolean isHwDDPlusSupported() {
        boolean z;
        AppMethodBeat.i(189712);
        if (sIsDDPInit) {
            boolean z2 = sIsDDPSup;
            AppMethodBeat.o(189712);
            return z2;
        } else if (isBlackListForHardwareDec(null)) {
            sIsDDPInit = true;
            sIsDDPSup = false;
            AppMethodBeat.o(189712);
            return false;
        } else {
            try {
                Class<?> cls = Class.forName("android.media.MediaCodecList");
                Method declaredMethod = cls.getDeclaredMethod("getCodecCount", new Class[0]);
                Method declaredMethod2 = cls.getDeclaredMethod("getCodecInfoAt", Integer.TYPE);
                Method declaredMethod3 = Class.forName("android.media.MediaCodecInfo").getDeclaredMethod("getSupportedTypes", new Class[0]);
                int intValue = ((Integer) declaredMethod.invoke(null, new Object[0])).intValue();
                int i2 = 0;
                boolean z3 = false;
                while (true) {
                    if (i2 >= intValue) {
                        z = z3;
                        break;
                    }
                    try {
                        String[] strArr = (String[]) declaredMethod3.invoke(declaredMethod2.invoke(null, Integer.valueOf(i2)), new Object[0]);
                        int length = strArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                z = z3;
                                break;
                            }
                            String str = strArr[i3];
                            if ("audio/eac3".equals(str) || "audio/ac3".equals(str)) {
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                        z = true;
                        if (z) {
                            break;
                        }
                        i2++;
                        z3 = z;
                    } catch (Exception e2) {
                        z = z3;
                    }
                }
            } catch (Exception e3) {
                z = false;
            }
            sIsDDPSup = z;
            sIsDDPInit = true;
            boolean z4 = sIsDDPSup;
            AppMethodBeat.o(189712);
            return z4;
        }
    }

    private static void initDolbyInvariableParams() {
        AppMethodBeat.i(189713);
        boolean isHwDDPlusSupported_V2 = isHwDDPlusSupported_V2();
        boolean isHwDolbyDSSupported = isHwDolbyDSSupported();
        if (!isHwDolbyDSSupported && !isHwDDPlusSupported_V2) {
            sDolbyLevel = 0;
            AppMethodBeat.o(189713);
        } else if (isHwDDPlusSupported_V2 && !isHwDolbyDSSupported) {
            sDolbyLevel = 1;
            AppMethodBeat.o(189713);
        } else if (isHwDDPlusSupported_V2 || !isHwDolbyDSSupported) {
            if (isHwDolbyDSSupported && isHwDDPlusSupported_V2) {
                sDolbyLevel = 11;
            }
            AppMethodBeat.o(189713);
        } else {
            sDolbyLevel = 10;
            AppMethodBeat.o(189713);
        }
    }

    public static int getHwDolbyLevel() {
        AppMethodBeat.i(189714);
        if (sDolbyLevel == -1) {
            initDolbyInvariableParams();
        }
        int i2 = sDolbyLevel;
        AppMethodBeat.o(189714);
        return i2;
    }

    private static void cacheStringInfo(String str, String str2) {
        AppMethodBeat.i(189715);
        if (mApplicationContext != null) {
            try {
                LocalCache localCache = LocalCache.get(mApplicationContext);
                if (localCache != null) {
                    localCache.put(str, str2);
                }
                AppMethodBeat.o(189715);
                return;
            } catch (Throwable th) {
                TPNativeLog.printLog(4, TAG, "cache " + str + StateEvent.ProcessResult.FAILED);
            }
        }
        AppMethodBeat.o(189715);
    }

    private static void cacheCapList(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(189716);
        if (mApplicationContext != null) {
            try {
                LocalCache localCache = LocalCache.get(mApplicationContext);
                if (localCache != null) {
                    localCache.put(str, arrayList);
                }
                AppMethodBeat.o(189716);
                return;
            } catch (Throwable th) {
                TPNativeLog.printLog(4, TAG, "cache " + str + StateEvent.ProcessResult.FAILED);
            }
        }
        AppMethodBeat.o(189716);
    }

    private static void cacheCapabilityMap(String str, HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> hashMap) {
        AppMethodBeat.i(189717);
        if (mApplicationContext != null) {
            try {
                LocalCache localCache = LocalCache.get(mApplicationContext);
                if (localCache != null) {
                    localCache.put(str, hashMap);
                }
                AppMethodBeat.o(189717);
                return;
            } catch (Throwable th) {
                TPNativeLog.printLog(4, TAG, "cache " + str + StateEvent.ProcessResult.FAILED);
            }
        }
        AppMethodBeat.o(189717);
    }

    private static String getCachedStringInfo(String str) {
        AppMethodBeat.i(189718);
        if (mApplicationContext != null) {
            try {
                LocalCache localCache = LocalCache.get(mApplicationContext);
                if (localCache != null) {
                    String asString = localCache.getAsString(str);
                    AppMethodBeat.o(189718);
                    return asString;
                }
            } catch (Throwable th) {
                TPNativeLog.printLog(4, TAG, "get " + str + StateEvent.ProcessResult.FAILED);
            }
        }
        AppMethodBeat.o(189718);
        return null;
    }

    private static ArrayList<String> getCachedCapList(String str) {
        AppMethodBeat.i(189719);
        if (mApplicationContext != null) {
            try {
                LocalCache localCache = LocalCache.get(mApplicationContext);
                if (localCache != null) {
                    ArrayList<String> arrayList = (ArrayList) localCache.getAsObject(str);
                    AppMethodBeat.o(189719);
                    return arrayList;
                }
            } catch (Throwable th) {
                TPNativeLog.printLog(4, TAG, "get " + str + StateEvent.ProcessResult.FAILED);
            }
        }
        AppMethodBeat.o(189719);
        return null;
    }

    private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getCachedCapabilityMap(String str) {
        AppMethodBeat.i(189720);
        if (mApplicationContext != null) {
            try {
                LocalCache localCache = LocalCache.get(mApplicationContext);
                if (localCache != null) {
                    HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> hashMap = (HashMap) localCache.getAsObject(str);
                    AppMethodBeat.o(189720);
                    return hashMap;
                }
            } catch (Throwable th) {
                TPNativeLog.printLog(4, TAG, "get " + str + StateEvent.ProcessResult.FAILED);
            }
        }
        AppMethodBeat.o(189720);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isHDRsupport(int r16, int r17, int r18) {
        /*
        // Method dump skipped, instructions count: 546
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPCodecUtils.isHDRsupport(int, int, int):boolean");
    }

    public static boolean isHDR10Support() {
        AppMethodBeat.i(189722);
        if (Build.VERSION.SDK_INT < 24) {
            AppMethodBeat.o(189722);
            return false;
        }
        try {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                if (!codecInfoAt.isEncoder()) {
                    for (String str : codecInfoAt.getSupportedTypes()) {
                        if (str.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecInfoAt.getCapabilitiesForType(TPDecoderType.TP_CODEC_MIMETYPE_HEVC).profileLevels) {
                                if (codecProfileLevel.profile == 4096) {
                                    TPNativeLog.printLog(2, TAG, "isHDR10Support support HDR10");
                                    AppMethodBeat.o(189722);
                                    return true;
                                }
                            }
                            continue;
                        }
                    }
                    continue;
                }
            }
            TPNativeLog.printLog(2, TAG, "isHDR10Support not support");
            AppMethodBeat.o(189722);
            return false;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, TAG, "isHDR10Support " + th.toString());
            AppMethodBeat.o(189722);
            return false;
        }
    }

    public static boolean isHDR10PLUSSupport() {
        AppMethodBeat.i(189723);
        if (Build.VERSION.SDK_INT < 29) {
            AppMethodBeat.o(189723);
            return false;
        }
        try {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                if (!codecInfoAt.isEncoder()) {
                    for (String str : codecInfoAt.getSupportedTypes()) {
                        if (str.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecInfoAt.getCapabilitiesForType(TPDecoderType.TP_CODEC_MIMETYPE_HEVC).profileLevels) {
                                if (codecProfileLevel.profile == 8192) {
                                    TPNativeLog.printLog(2, TAG, "isHDR10PLUSSupport support HDR10PLUS");
                                    AppMethodBeat.o(189723);
                                    return true;
                                }
                            }
                            continue;
                        }
                    }
                    continue;
                }
            }
            TPNativeLog.printLog(2, TAG, "isHDR10PLUSSupport not support");
            AppMethodBeat.o(189723);
            return false;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, TAG, "isHDR10PLUSSupport " + th.toString());
            AppMethodBeat.o(189723);
            return false;
        }
    }

    public static boolean isHDRDolbyVisionSupport(int i2, int i3) {
        AppMethodBeat.i(189724);
        if (Build.VERSION.SDK_INT < 24) {
            AppMethodBeat.o(189724);
            return false;
        }
        try {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i4 = 0; i4 < codecCount; i4++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i4);
                if (!codecInfoAt.isEncoder()) {
                    for (String str : codecInfoAt.getSupportedTypes()) {
                        if (str.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_DOLBYVISION)) {
                            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecInfoAt.getCapabilitiesForType(TPDecoderType.TP_CODEC_MIMETYPE_DOLBYVISION).profileLevels;
                            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                                if (codecProfileLevel.profile > 0 && codecProfileLevel.profile >= i2 && codecProfileLevel.level > 0 && codecProfileLevel.level >= i3) {
                                    TPNativeLog.printLog(2, TAG, "isHDRDolbyVisionSupport support dolbyvision");
                                    AppMethodBeat.o(189724);
                                    return true;
                                }
                            }
                            continue;
                        }
                    }
                    continue;
                }
            }
            TPNativeLog.printLog(2, TAG, "isHDRDolbyVisionSupport not support");
            AppMethodBeat.o(189724);
            return false;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, TAG, "isHDRDolbyVisionSupport " + th.toString());
            AppMethodBeat.o(189724);
            return false;
        }
    }

    public static boolean isHDRHLGSupport(int i2, int i3) {
        return false;
    }

    public static boolean isBlackListForHdr10(String str) {
        AppMethodBeat.i(189725);
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                String str2 = Build.MODEL;
                TPNativeLog.printLog(4, TAG, "hdr10 黑名单：".concat(String.valueOf(str)));
                for (String str3 : split) {
                    if (str2.equalsIgnoreCase(str3)) {
                        AppMethodBeat.o(189725);
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            TPNativeLog.printLog(4, TAG, "isBlackListForHdr10：" + e2.toString());
        }
        AppMethodBeat.o(189725);
        return false;
    }

    public static boolean isBlackListForVidHdr10Enhance(String str, String str2) {
        AppMethodBeat.i(189726);
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String[] split = str2.split(",");
                TPNativeLog.printLog(2, TAG, "hdr10 vid：".concat(String.valueOf(str2)));
                for (String str3 : split) {
                    if (str.equalsIgnoreCase(str3)) {
                        AppMethodBeat.o(189726);
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            TPNativeLog.printLog(4, TAG, "isBlackListForHdr10：" + e2.getMessage());
        }
        AppMethodBeat.o(189726);
        return false;
    }

    public static boolean isWhiteListForHdr10(String str) {
        AppMethodBeat.i(189727);
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                String str2 = Build.MODEL;
                TPNativeLog.printLog(2, TAG, "hdr10 白名单：".concat(String.valueOf(str)));
                for (String str3 : split) {
                    if (str2.equalsIgnoreCase(str3)) {
                        AppMethodBeat.o(189727);
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            TPNativeLog.printLog(4, TAG, "isWhiteListForHdr10：" + e2.toString());
        }
        AppMethodBeat.o(189727);
        return false;
    }

    public static boolean isBlackListForHdr10Enhance(String str) {
        AppMethodBeat.i(189728);
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                String str2 = Build.MODEL;
                TPNativeLog.printLog(2, TAG, "hdr10 黑名单：".concat(String.valueOf(str)));
                for (String str3 : split) {
                    if (str2.equalsIgnoreCase(str3)) {
                        AppMethodBeat.o(189728);
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            TPNativeLog.printLog(4, TAG, "isBlackListForHdr10：" + e2.toString());
        }
        AppMethodBeat.o(189728);
        return false;
    }

    public static boolean isWhiteListForHdr10Enhance(String str) {
        AppMethodBeat.i(189729);
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                String str2 = Build.MODEL;
                TPNativeLog.printLog(2, TAG, "hdr10 白名单：".concat(String.valueOf(str)));
                for (String str3 : split) {
                    if (str2.equalsIgnoreCase(str3)) {
                        AppMethodBeat.o(189729);
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            TPNativeLog.printLog(4, TAG, "isWhiteListForHdr10：" + e2.toString());
        }
        AppMethodBeat.o(189729);
        return false;
    }

    public static boolean getAudioMediaCodecPassThroughCap(int i2, int i3, int i4) {
        int i5 = 1;
        AppMethodBeat.i(189730);
        if (i2 != 5004) {
            AppMethodBeat.o(189730);
            return false;
        }
        if (i2 == 5004) {
            if (i3 == 20) {
                i5 = 7;
            } else if (i3 == 20) {
                i5 = 8;
            }
        } else if (i2 == 5002) {
            if (i3 == 1) {
                i5 = 10;
            } else if (i3 == 4) {
                i5 = 11;
            } else if (i3 == 28) {
                i5 = 12;
            }
        }
        boolean isAudioPassThroughSupport = TPAudioPassThroughPluginDetector.isAudioPassThroughSupport(i5, i4);
        AppMethodBeat.o(189730);
        return isAudioPassThroughSupport;
    }
}
